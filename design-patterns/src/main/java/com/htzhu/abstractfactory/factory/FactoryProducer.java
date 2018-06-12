package com.htzhu.abstractfactory.factory;

/**
 * FactoryProducer
 *
 * @author zhuhaitao
 * @date 2018/6/8 14:59
 **/
public class FactoryProducer {

	public static AbstractFactory getFactory(Class<? extends AbstractFactory> clazz) {
		AbstractFactory factory = null;

		try {
			factory = (AbstractFactory) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return factory;
	}

}
