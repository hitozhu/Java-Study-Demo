package com.htzhu.service.impl;

import com.htzhu.service.LogService;

/**
 * LogServiceImpl
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:43
 **/
public class LogServiceImpl implements LogService {

	@Override
	public void record(String msg) {
		System.out.println(msg);
	}

}
