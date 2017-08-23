package com.lbh360.platform.base.service.bean.merch;

import java.io.Serializable;



/**
 * 商品销售计数
 * 
 */
@SuppressWarnings("serial")
public class MerchSoldInfoBean implements Serializable{
	/**
	 * 商品ID
	 */
	private String id;

	/**
	 * 订单数量
	 */
	private Long orderNum;
	
	/**
	 * 本月订单数量
	 */
	private Long monthOrderNum;
	
	/**
	 * 本月订单数量统计月份,201606
	 */
	private String currMonth;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Long getMonthOrderNum() {
		return monthOrderNum;
	}

	public void setMonthOrderNum(Long monthOrderNum) {
		this.monthOrderNum = monthOrderNum;
	}

	public String getCurrMonth() {
		return currMonth;
	}

	public void setCurrMonth(String currMonth) {
		this.currMonth = currMonth;
	}
	
	

}
