package com.htzhu.service.impl;

import com.htzhu.annotation.Logged;
import com.htzhu.service.CreditCardProcessor;
import com.htzhu.vo.CreditCard;

/**
 * PayCreditCardProcessor
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:44
 **/
public class PayCreditCardProcessor implements CreditCardProcessor {

	@Logged
	@Override
	public boolean charge(CreditCard creditCard, Long money) {
		return creditCard.getBalance() >= money ? true : false;
	}

}
