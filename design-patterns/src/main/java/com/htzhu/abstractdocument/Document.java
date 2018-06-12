package com.htzhu.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Document
 *
 * @author zhuhaitao
 * @date 2018/6/8 11:30
 **/
public interface Document {

	Void put(String key, Object value);

	Object get(String key);

	<T>Stream<T> children(String key, Function<Map<String, Object>, T> constructor);

}
