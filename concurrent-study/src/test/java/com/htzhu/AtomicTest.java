package com.htzhu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;

/**
 * AtomicTest
 *
 * https://my.oschina.net/yu120/blog/689204
 *
 * @author zhuhaitao
 * @date 2018/6/8 18:23
 **/
public class AtomicTest {

	@Test
	public void testAtomic() {
		int loopCount = 10000;

		int threadCount = 10;

		NoSafeSeq noSafeSeq = new NoSafeSeq();
		SafeSeq safeSeq = new SafeSeq();

		CountDownLatch latch = new CountDownLatch(threadCount);

		for (int i = 0; i < threadCount; i++) {
			final int index = i;
			new Thread(() -> {
				for (int j = 0; j < loopCount; ++j) {
					noSafeSeq.increame();
					safeSeq.increame();
				}

				System.out.println("finished : " + index);
				latch.countDown();
			}).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("NonSafeSeq:" + noSafeSeq.get());
		System.out.println("SafeSeq with atomic: " + safeSeq.get());
	}

}

class NoSafeSeq {

	private long seq = 0;

	public void increame() {
		seq++;
	}

	public Long get() {
		return seq;
	}
}

class SafeSeq {

	private AtomicLong seq = new AtomicLong(0);

	public void increame() {
		seq.incrementAndGet();
	}

	public Long get() {
		return seq.get();
	}
}
