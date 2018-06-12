package com.htzhu.abstractfactory.factory;

import com.htzhu.abstractfactory.domain.Color;
import com.htzhu.abstractfactory.domain.Shape;

/**
 * ColorFactory
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:59
 **/
public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(Class<? extends Color> clazz) {
		Color color = null;

		try {
			color = (Color) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return color;
	}

	@Override
	public Shape getShape(Class<? extends Shape> clazz) {
		return null;
	}

}
