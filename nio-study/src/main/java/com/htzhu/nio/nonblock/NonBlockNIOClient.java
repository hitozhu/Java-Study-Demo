package com.htzhu.nio.nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NonBlockNIOClient
 *
 * @author zhuhaitao
 * @date 2018/6/6 15:03
 **/
public class NonBlockNIOClient {

	public static void main(String[] args) throws IOException {
		// 获取通道
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9080));

		// 切换成非阻塞模式
		socketChannel.configureBlocking(false);

		ByteBuffer buffer = ByteBuffer.allocate(1024);

		buffer.put("我是谁".getBytes());

		// 发送数据
		buffer.flip();
		socketChannel.write(buffer);
		buffer.clear();

		socketChannel.close();
	}

}
