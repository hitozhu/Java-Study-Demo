package com.htzhu.abstractfactory.factory;

import com.htzhu.abstractfactory.domain.Color;
import com.htzhu.abstractfactory.domain.Shape;

/**
 * ShapeFactory
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:59
 **/
public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(Class<? extends Color> clazz) {
		return null;
	}

	@Override
	public Shape getShape(Class<? extends Shape> clazz) {
		Shape shape = null;
		try {
			shape = (Shape) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return shape;
	}
}
