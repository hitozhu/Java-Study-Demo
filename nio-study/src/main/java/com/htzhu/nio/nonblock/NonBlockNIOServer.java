package com.htzhu.nio.nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NonBlockNIOServer
 *
 * @author zhuhaitao
 * @date 2018/6/6 14:53
 **/
public class NonBlockNIOServer {

	public static void main(String[] args) throws IOException {
		// 获取通道
		ServerSocketChannel socketChannel = ServerSocketChannel.open();
		// 切换为非阻塞模式
		socketChannel.configureBlocking(false);
		// 绑定端口
		socketChannel.bind(new InetSocketAddress(9080));

		// 获取选择器
		Selector selector = Selector.open();

		// 通道绑定到选择器上，监听接收事件
//		SelectionKey.OP_CONNECT 连接
//		SelectionKey.OP_ACCEPT 接收
//		SelectionKey.OP_READ 读
//		SelectionKey.OP_WRITE 写
		socketChannel.register(selector, SelectionKey.OP_ACCEPT);

		// I/O 准备就绪的通道
		while (selector.select() > 0) {
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			// 遍历 selectedKey
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				// 接收事件
				if (selectionKey.isAcceptable()) {
					// 获取连接
					SocketChannel channel = socketChannel.accept();
					// 非阻塞模式
					channel.configureBlocking(false);
					// 注册，监听读事件
					channel.register(selector, SelectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {
					// 读就绪
					// 获取管道
					SocketChannel channel = (SocketChannel) selectionKey.channel();

					// 读取客户端数据
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					while (channel.read(byteBuffer) > 0) {
						// 切换模式
						byteBuffer.flip();
						System.out.println(byteBuffer);
						byte[] bytes = new byte[byteBuffer.remaining()];
						byteBuffer.get(bytes);
						System.out.println(new String(bytes));
						byteBuffer.clear();
					}
				}

				// 其他几个事件
//				selectionKey.isWritable(); // 键的管道是否可写
//				selectionKey.isConnectable(); // 键的管道是否可连接
//				selectionKey.isValid(); // 键是否有效
				// 需要手动移除
				iterator.remove();
			}

		}

	}

}
