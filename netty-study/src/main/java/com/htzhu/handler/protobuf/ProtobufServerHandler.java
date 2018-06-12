package com.htzhu.handler.protobuf;

import com.htzhu.protobuf.PersonProtos;
import com.htzhu.protobuf.PersonProtos.Person;
import com.htzhu.protobuf.PersonProtos.Person.Builder;
import com.htzhu.protobuf.PersonProtos.Person.PhoneNumber;
import com.htzhu.protobuf.PersonProtos.Person.PhoneType;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * ProtobufClientHandler
 *
 * @author zhuhaitao
 * @date 2018/6/12 13:44
 **/
@Slf4j
public class ProtobufServerHandler extends SimpleChannelInboundHandler<PersonProtos.Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {
		log.info("client: {}", msg);

		ChannelFuture future = ctx.writeAndFlush(buile());

		// 数据发送完成后，异步的关闭 channel
		future.addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	public Person buile() {
		PhoneNumber.Builder phoneNumber = PhoneNumber.newBuilder();
		phoneNumber.setNumber("15188888888");
		phoneNumber.setType(PhoneType.MOBILE);

		Builder person = Person.newBuilder();
		person.setId(222);
		person.setEmail("aaa@gmail.com");
		person.setName("Mr.zhu");
		person.setPhone(phoneNumber);

		return person.build();
	}

}
