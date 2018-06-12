package com.htzhu.abstractdocument.domain;

import com.htzhu.abstractdocument.Document;
import java.util.Optional;

/**
 * HasModel
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:40
 **/
public interface HasModel extends Document {

	String PROPERTY = "model";

	default Optional<String> getModel() {
		// Returns an describing the specified value, if non-null, otherwise returns an empty
		return Optional.ofNullable((String) get(PROPERTY));
	}

}
