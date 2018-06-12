package com.htzhu;

import com.htzhu.coder.kryo.KryoDecoder;
import com.htzhu.coder.kryo.KryoEncoder;
import com.htzhu.handler.kryo.KryoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * SocketServer
 *
 * @author zhuhaitao
 * @date 2018/6/12 11:35
 **/
@Data
@AllArgsConstructor
public class SocketServer implements Runnable {

	private int port;

	@Override
	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup(8);
		EventLoopGroup workGroup = new NioEventLoopGroup();

		ServerBootstrap bootstrap = new ServerBootstrap();

		bootstrap.group(bossGroup, workGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel channel) throws Exception {
						// 编码、解码
//						channel.pipeline().addLast("decoder", new StringDecoder());
//						channel.pipeline().addLast("encoder", new StringEncoder());

						// kryo
						channel.pipeline().addLast("decoder", new KryoDecoder());
						channel.pipeline().addLast("encoder", new KryoEncoder());

						// protobuf
						// 添加解码器，用于处理半包
//						channel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//						channel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
//						// 添加ProtobufEncoder编码器
//						channel.pipeline().addLast(new ProtobufEncoder());
//						channel.pipeline().addLast(
//								new ProtobufDecoder(PersonProtos.Person.getDefaultInstance()));

//						channel.pipeline().addLast(new StringServerHandler());
						channel.pipeline().addLast(new KryoServerHandler());
//						channel.pipeline().addLast(new ProtobufServerHandler());
					}
				})
				.option(ChannelOption.SO_BACKLOG, 128)
				.childOption(ChannelOption.SO_KEEPALIVE, true);

		try {
			ChannelFuture future = bootstrap.bind(port).sync();
			future.channel().closeFuture().sync();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			workGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		new SocketServer(10086).run();
	}

}

