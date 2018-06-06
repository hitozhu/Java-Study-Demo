package com.htzhu.nio.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * BlockNIO
 *
 * @author zhuhaitao
 * @date 2018/6/6 14:19
 **/
public class BlockNIOServer {


	public static void main(String[] args) throws IOException {
		ServerSocketChannel channel = ServerSocketChannel.open();

		// 绑定端口
		channel.bind(new InetSocketAddress(9080));

		// 接收客户端的请求
		SocketChannel socketChannel = channel.accept();

		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// 读取数据
		while (socketChannel.read(buffer) != -1) {
			buffer.flip();
			byte[] bytes = new byte[buffer.remaining()];

			buffer.get(bytes);
			System.out.println(new String(bytes));
			buffer.clear();
		}

		// 给客户端响应
		buffer.put("你好啊".getBytes());
		buffer.flip();
		socketChannel.write(buffer);

		socketChannel.close();
		channel.close();

	}

}
