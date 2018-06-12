package com.htzhu.coder.kryo;

import com.htzhu.domain.Message;
import com.htzhu.serializer.KryoSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * KryoEncoder
 *
 * @author zhuhaitao
 * @date 2018/6/12 15:31
 **/
public class KryoEncoder extends MessageToByteEncoder<Message> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		KryoSerializer.serialize(msg, out);
		ctx.flush();
	}

}
