package com.htzhu.service.impl;

import com.htzhu.annotation.Logged;
import com.htzhu.annotation.PayPal;
import com.htzhu.manager.SessionManager;
import com.htzhu.service.BillingService;
import com.htzhu.service.CreditCardProcessor;
import com.htzhu.service.LogService;
import com.htzhu.vo.CreditCard;
import com.htzhu.vo.PizzaOrder;
import com.htzhu.vo.Receipt;
import com.sun.istack.internal.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * RealBillingService
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:30
 **/
public class RealBillingServiceImpl implements BillingService {

	private final CreditCardProcessor processor;

	private final LogService logService;

	private final CreditCard creditCard;

	private final SessionManager sessionManager;

	@Inject
	public RealBillingServiceImpl(@PayPal CreditCardProcessor processor,
			@Named("log") LogService logService,
			@Nullable CreditCard creditCard,
			SessionManager sessionManager) {
		this.processor = processor;
		this.logService = logService;
		this.creditCard = creditCard;
		this.sessionManager = sessionManager;
	}

	@Logged
	@Override
	public Receipt chargeOrder(PizzaOrder order) {
		Boolean result = processor.charge(creditCard, order.getAmount());

		Receipt receipt = result ? new Receipt("pizza order", order.getAmount(), true) :
				new Receipt("pizza order", order.getAmount(), false);
		logService.record(String
				.format("记录 %d 日志: %s", sessionManager.getSessionIdProvider(), receipt.toString()));
		return receipt;
	}

}
