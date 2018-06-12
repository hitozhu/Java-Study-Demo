package com.htzhu.abstractfactory;

import com.htzhu.abstractfactory.domain.Color;
import com.htzhu.abstractfactory.domain.Green;
import com.htzhu.abstractfactory.domain.Rectangle;
import com.htzhu.abstractfactory.domain.Red;
import com.htzhu.abstractfactory.domain.Shape;
import com.htzhu.abstractfactory.domain.Square;
import com.htzhu.abstractfactory.factory.AbstractFactory;
import com.htzhu.abstractfactory.factory.ColorFactory;
import com.htzhu.abstractfactory.factory.FactoryProducer;
import com.htzhu.abstractfactory.factory.ShapeFactory;

/**
 * App
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:54
 **/
public class App {

	public static void main(String[] args) {
		AbstractFactory colorFactory =
				FactoryProducer.getFactory(ColorFactory.class);
		Color green = colorFactory.getColor(Green.class);

		green.fill();

		Color red = colorFactory.getColor(Red.class);
		red.fill();

		AbstractFactory shapeFactory = FactoryProducer.getFactory(ShapeFactory.class);
		Shape rectangle = shapeFactory.getShape(Rectangle.class);
		rectangle.draw();

		Shape square = shapeFactory.getShape(Square.class);
		square.draw();

	}

}
