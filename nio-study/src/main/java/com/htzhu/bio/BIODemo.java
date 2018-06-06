package com.htzhu.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIODemo
 *
 * @author zhuhaitao
 * @date 2018/6/6 11:00
 **/
public class BIODemo {

	public static void main(String[] args) throws IOException {
		// 线程池
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		ServerSocket socket = new ServerSocket(8080);

		// 主线程等待连接到来
		while (!Thread.currentThread().isInterrupted()) {
			Socket accept = socket.accept();
			// 为每个单独的 socket 创建单独的线程处理
			executorService.submit(new Handle(accept));
		}

	}

	static class Handle extends Thread {

		private Socket socket;

		public Handle(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
				// do something
			}
		}
	}

}
