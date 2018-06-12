package com.htzhu.abstractfactory.domain;

/**
 * Square（正方形）
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:56
 **/
public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square...");
	}
}
