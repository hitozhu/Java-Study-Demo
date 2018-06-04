package com.htzhu.module;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.htzhu.annotation.Logged;
import com.htzhu.aop.LoggedInterceptor;

/**
 * LoggedModule
 *
 * @author zhuhaitao
 * @date 2018/6/4 16:12
 **/
public class LoggedModule extends AbstractModule {

	@Override
	protected void configure() {
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Logged.class),
				new LoggedInterceptor());
	}

}
