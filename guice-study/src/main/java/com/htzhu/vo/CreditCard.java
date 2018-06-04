package com.htzhu.vo;

/**
 * CreditCard
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:28
 **/
public class CreditCard {

	private Long balance;

	private String name;

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreditCard(String name, Long balance) {
		this.balance = balance;
		this.name = name;
	}

	public CreditCard() {
	}

}
