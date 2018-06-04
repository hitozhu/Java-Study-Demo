package com.htzhu.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.htzhu.annotation.PayPal;
import com.htzhu.service.BillingService;
import com.htzhu.service.CreditCardProcessor;
import com.htzhu.service.LogService;
import com.htzhu.service.impl.LogServiceImpl;
import com.htzhu.service.impl.PayCreditCardProcessor;
import com.htzhu.service.impl.RealBillingServiceImpl;
import com.htzhu.vo.CreditCard;
import javax.inject.Named;

/**
 * BillingModule
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:07
 **/
public class BillingModule extends AbstractModule {

	@Override
	protected void configure() {

		// 连接绑定
		bind(BillingService.class).to(RealBillingServiceImpl.class);

		// 注解绑定
		bind(CreditCardProcessor.class).annotatedWith(PayPal.class)
				.to(PayCreditCardProcessor.class);
		bind(LogService.class).annotatedWith(Names.named("log")).to(LogServiceImpl.class);

		// 实例绑定
		bind(CreditCard.class).toInstance(new CreditCard("信用卡", 1200L));
	}

	@Provides
	@Named("sessionId")
	public Long getSessionId() {
		return System.currentTimeMillis();
	}

}
