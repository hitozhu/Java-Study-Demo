package com.htzhu.nio.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * BlockNIOClient
 *
 * @author zhuhaitao
 * @date 2018/6/6 14:25
 **/
public class BlockNIOClient {

	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9080));

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put("发送".getBytes());

		buffer.flip();
		// 给服务端发送信息
		socketChannel.write(buffer);
		buffer.clear();

		// 关闭写的通道
		socketChannel.shutdownOutput();

		// 接收服务端响应
		socketChannel.read(buffer);

		buffer.flip();
		byte[] bytes = new byte[buffer.remaining()];

		buffer.get(bytes);
		System.out.println(new String(bytes));

		socketChannel.close();

	}

}
