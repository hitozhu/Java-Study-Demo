package com.htzhu.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.htzhu.factory.ThreadLocalKryoFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * KryoSerializer
 *
 * @author zhuhaitao
 * @date 2018/6/12 15:33
 **/
public class KryoSerializer {

	private static final ThreadLocalKryoFactory factory = new ThreadLocalKryoFactory();

	/**
	 * 序列化
	 */
	public static void serialize(Object object, ByteBuf out) {
		Kryo kryo = factory.getKryo();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Output output = new Output(outputStream);
		kryo.writeClassAndObject(output, object);
		output.flush();
		output.close();

		byte[] bytes = outputStream.toByteArray();
		try {
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.writeBytes(bytes);
	}

	/**
	 * 反序列化
	 */
	public static Object deserialize(ByteBuf out) {
		if (out == null) {
			return null;
		}
		Input input = new Input(new ByteBufInputStream(out));
		Kryo kryo = factory.getKryo();
		return kryo.readClassAndObject(input);
	}

}
