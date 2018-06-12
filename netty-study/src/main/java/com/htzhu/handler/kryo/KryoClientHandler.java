package com.htzhu.handler.kryo;

import com.htzhu.domain.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * KryoClientHandler
 *
 * @author zhuhaitao
 * @date 2018/6/12 15:45
 **/
@Slf4j
public class KryoClientHandler extends SimpleChannelInboundHandler<Message> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		log.info("server callback: {}", msg);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 获取连接后，往服务端发送一条信息
		ctx.writeAndFlush(new Message(1, "from client"));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
