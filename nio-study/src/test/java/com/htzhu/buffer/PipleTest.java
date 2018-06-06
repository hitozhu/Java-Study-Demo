package com.htzhu.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;
import org.junit.Test;

/**
 * 管道（piple）：
 * 从管道中获取 channle，写数据到缓冲区并装载到管道中
 *
 * @author zhuhaitao
 * @date 2018/6/6 14:02
 **/
public class PipleTest {

	@Test
	public void test() throws IOException {
		// 获取管道
		Pipe pipe = Pipe.open();

		// 定义缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		SinkChannel sinkChannel = pipe.sink();
		buffer.put("我是谁".getBytes());
		// 切换为读模式
		buffer.flip();
		sinkChannel.write(buffer);

		// 从管道中获取 channel
		SourceChannel sourceChannel = pipe.source();
		// 切换为写模式
		buffer.flip();
		// 从缓冲区读数据
		int length = sourceChannel.read(buffer);
		System.out.println(length);
		System.out.println(new String(buffer.array(), 0, length));

		sourceChannel.close();
		sinkChannel.close();
	}

}
