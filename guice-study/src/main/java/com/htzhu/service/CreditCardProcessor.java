package com.htzhu.service;

import com.htzhu.vo.CreditCard;

/**
 * CreditCardProcessor
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:43
 **/
public interface CreditCardProcessor {

	boolean charge(CreditCard creditCard, Long money);

}
