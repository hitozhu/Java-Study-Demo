package com.htzhu.abstractfactory.domain;

/**
 * Green
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:55
 **/
public class Green implements Color {

	@Override
	public void fill() {
		System.out.println("Green...");
	}
}
