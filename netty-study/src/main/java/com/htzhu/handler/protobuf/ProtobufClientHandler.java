package com.htzhu.handler.protobuf;

import com.htzhu.protobuf.PersonProtos;
import com.htzhu.protobuf.PersonProtos.Person;
import com.htzhu.protobuf.PersonProtos.Person.Builder;
import com.htzhu.protobuf.PersonProtos.Person.PhoneNumber;
import com.htzhu.protobuf.PersonProtos.Person.PhoneType;
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
public class ProtobufClientHandler extends SimpleChannelInboundHandler<PersonProtos.Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {
		log.info("server callback: {}", msg.toString());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 当 channel 就绪后，客户端发送一个数据
		ctx.writeAndFlush(buile());
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
		person.setId(111);
		person.setEmail("aaa@gmail.com");
		person.setName("Mr.zhu");
		person.setPhone(phoneNumber);

		return person.build();
	}

}
