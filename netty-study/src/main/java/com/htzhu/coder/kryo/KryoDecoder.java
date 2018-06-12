package com.htzhu.coder.kryo;

import com.htzhu.serializer.KryoSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * KryoDecoder
 *
 * @author zhuhaitao
 * @date 2018/6/12 15:32
 **/
public class KryoDecoder extends ByteToMessageDecoder {


	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
			throws Exception {
		Object object = KryoSerializer.deserialize(in);
		out.add(object);
	}
}
