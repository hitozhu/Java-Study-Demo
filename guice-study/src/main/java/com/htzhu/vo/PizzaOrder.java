package com.htzhu.vo;

/**
 * PizzaOrder
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:28
 **/
public class PizzaOrder {

	private Long amount;

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public PizzaOrder() {
	}

	public PizzaOrder(Long amount) {
		this.amount = amount;
	}

}
