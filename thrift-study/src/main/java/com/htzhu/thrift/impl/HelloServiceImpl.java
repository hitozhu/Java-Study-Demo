package com.htzhu.thrift.impl;

import com.htzhu.thrift.Hello;
import org.apache.thrift.TException;

/**
 * HelloServiceImpl
 *
 * @author zhuhaitao
 * @date 2018/5/31 16:25
 **/
public class HelloServiceImpl implements Hello.Iface {

	@Override
	public String helloString(String para) throws TException {
		return "hello " + para;
	}

}
