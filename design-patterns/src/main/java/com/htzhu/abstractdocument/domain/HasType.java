package com.htzhu.abstractdocument.domain;

import com.htzhu.abstractdocument.Document;
import java.util.Optional;

/**
 * HasType
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:53
 **/
public interface HasType extends Document {

	String PROPERTY = "type";

	default Optional<String> getType() {
		return Optional.ofNullable((String) get(PROPERTY));
	}

}
