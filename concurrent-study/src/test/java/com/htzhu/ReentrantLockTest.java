package com.htzhu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * RentrantLockTest
 *
 * @author zhuhaitao
 * @date 2018/6/11 15:30
 **/
public class ReentrantLockTest {

	@Test
	public void test() throws InterruptedException {
		int loopCount = 10000;
		int threadNum = 10;

		SafeSeqLock safeSeqLock = new SafeSeqLock();
		CountDownLatch latch = new CountDownLatch(threadNum);

		for (int i = 0; i < threadNum; i++) {
			final int index = i;
			new Thread(() -> {
				for (int j = 0; j < loopCount; j++) {
					safeSeqLock.increame();
				}
				System.out.println("Thread " + index + " finished...");
				latch.countDown();
			}).start();
		}

		latch.await();

		System.out.println();
		System.out.println("SafeSeqLock: " + safeSeqLock.get());
	}

}

class SafeSeqLock {
	private Long count = 0L;

	private ReentrantLock lock = new ReentrantLock();

	public void increame() {
		lock.lock();
		count++;
		lock.unlock();
	}

	public long get() {
		return count;
	}
}