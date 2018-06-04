package com.htzhu.manager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * SessionManager
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:05
 **/
public class SessionManager {

	private Provider<Long> sessionIdProvider;

	@Inject
	public SessionManager(@Named("sessionId") Provider<Long> sessionIdProvider) {
		super();
		this.sessionIdProvider = sessionIdProvider;
	}

	public Long getSessionIdProvider() {
		return sessionIdProvider.get();
	}

}
