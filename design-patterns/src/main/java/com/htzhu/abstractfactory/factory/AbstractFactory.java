package com.htzhu.abstractfactory.factory;

import com.htzhu.abstractfactory.domain.Color;
import com.htzhu.abstractfactory.domain.Shape;

/**
 * AbstractFactory
 *
 * @author zhuhaitao
 * @date 2018/6/8 15:00
 **/
public abstract class AbstractFactory {

	public abstract Color getColor(Class<? extends Color> clazz);

	public abstract Shape getShape(Class<? extends Shape> clazz);

}
