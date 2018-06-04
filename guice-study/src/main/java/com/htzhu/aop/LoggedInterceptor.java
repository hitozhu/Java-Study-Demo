package com.htzhu.aop;

import com.google.common.base.Joiner;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * LoggedInterceptor
 *
 * @author zhuhaitao
 * @date 2018/6/4 16:13
 **/
public class LoggedInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();

		Object proceed = invocation.proceed();

		System.out.println(String.format("calling %s#%s(%s), result:%s",
				method.getDeclaringClass().getName(),
				method.getName(),
				Joiner.on(",").join(invocation.getArguments()),
				proceed.toString()));

		return proceed;
	}
}
