package com.htzhu.factory;

import com.esotericsoftware.kryo.Kryo;

/**
 * ThreadLocalKryoFactory
 *
 * @author zhuhaitao
 * @date 2018/6/12 15:35
 **/
public class ThreadLocalKryoFactory extends KryoFactory {

	private final ThreadLocal<Kryo> holder = ThreadLocal.withInitial(() -> createKryo());

	public Kryo getKryo() {
		return holder.get();
	}

}
