package com.htzhu.abstractdocument.domain;

import com.htzhu.abstractdocument.Document;
import java.util.stream.Stream;

/**
 * HasParts
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:43
 **/
public interface HasParts extends Document {

	String PROPERTY = "parts";

	default Stream<Part> getParts() {
		return children(PROPERTY, Part::new);
	}

}
