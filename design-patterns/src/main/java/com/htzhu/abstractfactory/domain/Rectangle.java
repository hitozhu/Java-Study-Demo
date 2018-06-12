package com.htzhu.abstractfactory.domain;

/**
 * Rectangle
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:58
 **/
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle...");
	}
}
