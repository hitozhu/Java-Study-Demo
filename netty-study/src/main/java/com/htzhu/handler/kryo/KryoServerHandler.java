package com.htzhu.handler.kryo;

import com.htzhu.domain.Message;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
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
public class KryoServerHandler extends SimpleChannelInboundHandler<Message> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		log.info("client: {}", msg);
		ChannelFuture future = ctx.writeAndFlush(new Message(2, "from server"));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
