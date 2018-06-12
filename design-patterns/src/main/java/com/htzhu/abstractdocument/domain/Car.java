package com.htzhu.abstractdocument.domain;

import com.htzhu.abstractdocument.AbstractDocument;
import java.util.Map;

/**
 * Car
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:39
 **/
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

	public Car(Map<String, Object> properties) {
		super(properties);
	}
}
