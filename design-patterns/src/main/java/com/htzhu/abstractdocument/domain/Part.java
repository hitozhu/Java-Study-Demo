package com.htzhu.abstractdocument.domain;

import com.htzhu.abstractdocument.AbstractDocument;
import java.util.Map;

/**
 * Part
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:39
 **/
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

	public Part(Map<String, Object> properties) {
		super(properties);
	}

}
