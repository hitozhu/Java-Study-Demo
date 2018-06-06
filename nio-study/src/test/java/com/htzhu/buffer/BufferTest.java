package com.htzhu.buffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import org.junit.Test;

/**
 * 1、常见的缓冲区：
 *
 * * ByteBuffer * CharBuffer * ShortBuffer * IntBuffer * LongBuffer * FloatBuffer * DoubleBuffer
 *
 * 2、缓冲区的底层就是byte[] 数组，数组大小不可变。
 *
 * 3、缓冲区中的几个位置参数 * capacity：容量，即缓冲区最多装载的数据大小，缓冲区创建时指定。 * limit：界限，可操作数据的最大值。 *
 * position：位置，表示缓冲区可以存放多少的数据 或者 缓冲区还有多少空间可以写入数据。 * mark：标记，为了数据的重复读取，在缓冲区的某个位置做个标记，重复从标记位置读取数据。
 *
 * mark <= position <= limit <= capacity
 *
 * 4、缓冲区读写模式切换
 *
 * @author zhuhaitao
 * @date 2018/6/5 14:06
 **/
public class BufferTest {

	/**
	 * 缓冲区的创建
	 */
	@Test
	public void testBuffer() {
		// 分配指定大小的缓冲区。底层是byte[] 数组，所以创建之后大小不可变。
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
	}

	/**
	 * property of buffer
	 */
	@Test
	public void testProperty() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(256);

		FileInputStream inputStream = new FileInputStream("README.md");
		System.out.println("文件大小：" + inputStream.available());

		FileChannel channel = inputStream.getChannel();

		while (channel.read(buffer) != -1) {
			System.out.println("capacity: " + buffer.capacity());
			// 当前是往缓冲区中写数据，尽管缓冲区已经满了，但还是显示能往 缓冲区写入 capacity 大小的数据，
			// 原因在于缓冲区已存在的数据可以被替换，还可以写入 capacity 大小的数据。
			System.out.println("limit: " + buffer.limit());
			System.out.println("position: " + buffer.position());
			System.out.println();

			buffer.clear();
		}

	}

	/**
	 * 读取模式转换
	 */
	@Test
	public void testModeSwitch() {
		ByteBuffer buffer = ByteBuffer.allocate(64);

		buffer.put("hello".getBytes());

		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());

		System.out.println("------ flip ------");
		buffer.flip();

		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());

		byte[] bytes = new byte[5];
		buffer.get(bytes);
		System.out.println(new String(bytes));
	}

	/**
	 * mark 和 reset 配合使用。reset 会使 position 回到之前 mark 时 position 的位置。
	 */
	@Test
	public void testMark() {
		ByteBuffer buffer = ByteBuffer.allocate(64);

		buffer.put((byte) 0);
		buffer.put((byte) 1);
		buffer.put((byte) 2);
		buffer.put((byte) 3);

		// 切换模式
		buffer.flip();

		// 读取一个 byte，position 位置移动一位
		System.out.println("read one byte: " + buffer.get());
		System.out.println("position: " + buffer.position());

		// 在 position = 1 的位置 mark 一下
		buffer.mark();
		// 重置 position = 0
//		buffer.rewind();
		System.out.println();

		// 再次读取一个 byte，此时 position = 2
		System.out.println("read one byte: " + buffer.get());
		System.out.println("position: " + buffer.position());

		// reset，此时 position = 1
		buffer.reset();
		System.out.println();

		// reset 后，position
		System.out.println("read one byte: " + buffer.get());
		System.out.println("position: " + buffer.position());
	}


	@Test
	public void testReadFile() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(512);

		FileInputStream inputStream = new FileInputStream("README.md");
		System.out.println("文件大小：" + inputStream.available());

		FileChannel channel = inputStream.getChannel();

		while (channel.read(buffer) != -1) {
		}

		System.out.println("position: " + buffer.position());

		// 切换为读模式
		buffer.flip();

		byte[] bytes = new byte[64];

		// 循环读取数据
		while (buffer.remaining() > 0) {
			buffer.get(bytes, 0,
					buffer.remaining() > bytes.length ? bytes.length : buffer.remaining());

			System.out.println(new String(bytes));
		}

	}

	public void test() throws IOException {
		Selector selector = Selector.open();
		selector.select();
	}


}
