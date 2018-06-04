package com.htzhu.service;

import com.htzhu.vo.PizzaOrder;
import com.htzhu.vo.Receipt;

/**
 * BillingService
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:27
 **/
public interface BillingService {

	/**
	 * attempts to charge the order to the credit card. Both successful and failed transactions will
	 * be recorded.
	 */
	Receipt chargeOrder(PizzaOrder order) throws InterruptedException;

}
