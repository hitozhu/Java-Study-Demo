package com.htzhu;

import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/**
 * CountDownLatchTest
 *
 * @author zhuhaitao
 * @date 2018/6/8 18:15
 **/
public class CountDownLatchTest {

	@Test
	public void test() throws InterruptedException {
		int count = 10;

		final CountDownLatch latch = new CountDownLatch(count + 1);

		for (int i = 0; i < count; i++) {
			final int index = i;
			new Thread(() -> {
				try {
					Thread.sleep(20 * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread " + index + " has finished...");
				latch.countDown();
			}).start();
		}

		// 等待前面 10 个线程执行完
		latch.await();

		System.out.println("all threads has finished...");
	}

}
