package com.htzhu;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.junit.Test;

/**
 * ReadWriteLockTest
 *
 * @author zhuhaitao
 * @date 2018/6/11 16:08
 **/
public class ReadWriteLockTest {

	@Test
	public void testReadWriteLock() throws InterruptedException {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		CountDownLatch latch = new CountDownLatch(2);

		ReadLock readLock = lock.readLock();
		WriteLock writeLock = lock.writeLock();

		new Thread(() -> {
			System.out.println(new Date() + " get read lock");
			readLock.lock();
			try {
				Thread.currentThread().sleep(10 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(new Date() + " release read lock");
			readLock.unlock();
			latch.countDown();
		}).start();

		new Thread(() -> {
			System.out.println(new Date() + " get write lock");
			writeLock.lock();

			System.out.println(new Date() + " release write lock");
			writeLock.unlock();
			latch.countDown();
		}).start();

		latch.await();
	}

	/**
	 * 写锁降级，持有写锁可以获取读锁，但是持有读锁尝试获取写锁会一直阻塞。
	 */
	@Test
	public void testDegrade() {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		ReadLock readLock = lock.readLock();
		WriteLock writeLock = lock.writeLock();

		System.out.println("get write lock");
		writeLock.lock();

		System.out.println("get read lock");
		readLock.lock();

		System.out.println("release write lock");
		writeLock.unlock();

		System.out.println("release read lock");
		readLock.unlock();

	}

}
