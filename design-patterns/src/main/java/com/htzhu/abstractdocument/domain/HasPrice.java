package com.htzhu.abstractdocument.domain;

import com.htzhu.abstractdocument.Document;
import java.util.Optional;

/**
 * HasPrice
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:52
 **/
public interface HasPrice extends Document {

	String PROPERTY = "price";

	default Optional<Number> getPrice() {
		return Optional.ofNullable((Number) get(PROPERTY));
	}

}
