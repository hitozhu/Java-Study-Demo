package com.htzhu.vo;

/**
 * Receipt
 *
 * @author zhuhaitao
 * @date 2018/6/4 15:28
 **/
public class Receipt {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 金额
	 */
	private Long money;
	/**
	 * 订单状态
	 */
	private Boolean result;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Receipt(String name, Long money, Boolean result) {
		this.name = name;
		this.money = money;
		this.result = result;
	}

	public Receipt() {
	}

	@Override
	public String toString() {
		return "Receipt{" +
				"name='" + name + '\'' +
				", money=" + money +
				", result=" + result +
				'}';
	}

}
