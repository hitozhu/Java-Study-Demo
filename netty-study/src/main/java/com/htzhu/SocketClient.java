package com.htzhu;

import com.htzhu.coder.kryo.KryoDecoder;
import com.htzhu.coder.kryo.KryoEncoder;
import com.htzhu.domain.Message;
import com.htzhu.handler.kryo.KryoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Data;

/**
 * SocketClient
 *
 * @author zhuhaitao
 * @date 2018/6/12 11:36
 **/
@Data
public class SocketClient {

	private Channel channel;

	public Channel connect(String host, int port) {
		doConnect(host, port);
		return this.channel;
	}

	private void doConnect(String host, int port) {
		try {
			EventLoopGroup workerGroup = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup).channel(NioSocketChannel.class)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel channel) {
							// String
//							channel.pipeline().addLast("decoder", new StringDecoder());
//							channel.pipeline().addLast("encoder", new StringEncoder());

							// kryo
							channel.pipeline().addLast("decoder", new KryoDecoder());
							channel.pipeline().addLast("encoder", new KryoEncoder());

							// protobuf
							// 添加解码器，用于处理半包
//							channel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//							channel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
//							// 添加ProtobufEncoder编码器
//							channel.pipeline().addLast(new ProtobufEncoder());
//							channel.pipeline().addLast(
//									new ProtobufDecoder(PersonProtos.Person.getDefaultInstance()));

//							channel.pipeline().addLast(new StringClientHandler());
							channel.pipeline().addLast(new KryoClientHandler());
//							channel.pipeline().addLast(new ProtobufClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect(host, port).sync();
			channel = future.channel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Channel channel = new SocketClient().connect("localhost", 10086);

//		channel.writeAndFlush("hello");
	}

}
