package com.htzhu.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map.Entry;
import java.util.SortedMap;
import org.junit.Test;

/**
 * 管道（channel）：
 * 和流类似，但又不同，流是单向的，分输入和输出流，既可以从通道中读数据也可以往通道中写入数据。
 * 通道中操作的是缓冲区（buffer），byte 数据先装配到 buffer 中，再在通过中传输。
 *
 * 通道的几种类型：
 * * FileChannel：文件
 * * DatagramChannel：UDP
 * * SocketChannel：套接字（客户端）
 * * ServerSocketChannel：套接字（服务端）
 *
 *
 * @author zhuhaitao
 * @date 2018/6/6 11:45
 **/
public class ChannelTest {

	/**
	 * property of buffer
	 */
	@Test
	public void testReadFile() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(256);

		FileInputStream inputStream = new FileInputStream("README.md");
		System.out.println("文件大小：" + inputStream.available());

		FileChannel channel = inputStream.getChannel();

		while (channel.read(buffer) != -1) {
			// 切换为读模式
			buffer.flip();

			byte[] bytes = new byte[buffer.limit()];
			buffer.get(bytes);
			System.out.println(new String(bytes));

			buffer.clear();
		}

		channel.close();
	}

	/**
	 * 数据从一个 channel 传递到另一个 channle
	 */
	@Test
	public void testOneToOtherOne() throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("README.md", "rw");
		FileChannel fromFileChannel = fromFile.getChannel();

		RandomAccessFile toFile = new RandomAccessFile("to.md", "rw");
		FileChannel toFileChannel = toFile.getChannel();

		// 从 fromFileChannel 拷贝到 toFileChannel
		toFileChannel.transferFrom(fromFileChannel, 0, fromFileChannel.size());

	}

	/**
	 * 分散（Sactter）读取 和 聚集（Gather）写入
	 */
	@Test
	public void testScatterAndGather() throws IOException {

		RandomAccessFile file1 = new RandomAccessFile("README.md", "rw");

		FileChannel channel = file1.getChannel();

		ByteBuffer buffer1 = ByteBuffer.allocate(256);
		ByteBuffer buffer2 = ByteBuffer.allocate(256);

		// 分撒读取
		ByteBuffer[] buffers = {buffer1, buffer2};
		channel.read(buffers);

		for (ByteBuffer buffer : buffers) {
			System.out.println("position: " + buffer.position());
			System.out.println("capacity: " + buffer.capacity());
			System.out.println();
			// 模式转换
			buffer.flip();
		}

		RandomAccessFile file2 = new RandomAccessFile("BAK.md", "rw");

		// 聚集写入
		FileChannel fileChannel = file2.getChannel();
		fileChannel.write(buffers);

	}

	/**
	 * 字符集
	 */
	@Test
	public void testCharset() throws CharacterCodingException {
		// 所有的字符编码
//		SortedMap<String, Charset> map = Charset.availableCharsets();
//
//		for (String entry : map.keySet()) {
//			System.out.println(entry + " -- " + map.get(entry));
//		}

		// gb2312 字符集
		Charset gb2312 = Charset.forName("GB2312");
		// 编码器
		CharsetEncoder encoder = gb2312.newEncoder();

		CharBuffer charBuffer = CharBuffer.allocate(128);
		charBuffer.put("我是谁");
		charBuffer.flip();

		// 编码器编码
		ByteBuffer encodeBuffer = encoder.encode(charBuffer);

		while (encodeBuffer.remaining() > 0) {
			System.out.println(encodeBuffer.get());
		}

		// 模式转换
		encodeBuffer.flip();

		// 解码器
		CharsetDecoder decoder = gb2312.newDecoder();
		CharBuffer decodeBuffer = decoder.decode(encodeBuffer);
		System.out.println(decodeBuffer.toString());
	}

}
