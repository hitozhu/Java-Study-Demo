package com.htzhu.abstractfactory.domain;

/**
 * Red
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:55
 **/
public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Red...");
	}
}
