package com.htzhu.handler.string;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * StringHandler
 *
 * @author zhuhaitao
 * @date 2018/6/12 11:36
 **/
@Slf4j
public class StringServerHandler extends SimpleChannelInboundHandler {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info("server: ", msg.toString());
		ctx.writeAndFlush("callback " + msg.toString());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
