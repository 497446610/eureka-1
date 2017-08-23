package com.lbh360.platform.base.service.bean.merch;

import java.math.BigDecimal;

/**
 * 商品价格
 * 
 */
public class MerchPriceBean {

	/**
	 *	ID
	 */
	private String id;

	/**
	 * 商品ID
	 */
	private Long merID;

	/**
	 *单价
	 */
	private BigDecimal price;

	/**
	 *采购价
	 */
	private BigDecimal costPrice;
	

	/**
	 *市场价
	 */
	private BigDecimal markPrice;
	
	/**
	 * 价格生效时间(yyyy-MM-dd HH:mm:ss)
	 */
	private String startTime;
	
	/**
	 * 价格失效时间(yyyy-MM-dd HH:mm:ss)
	 */
	private String overTime;
	
	/**
	 * 最低采购量
	 */
	private BigDecimal minNum;

	/**
	 * 供应量
	 */
	private BigDecimal totalNum;

	/**
	 * 每人限购
	 */
	private BigDecimal limitNum;

	

	/**
	 * 创建时间yyyy-MM-dd
	 */
	private String createTime;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Long getMerID() {
		return merID;
	}



	public void setMerID(Long merID) {
		this.merID = merID;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public BigDecimal getCostPrice() {
		return costPrice;
	}



	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}



	public BigDecimal getMarkPrice() {
		return markPrice;
	}



	public void setMarkPrice(BigDecimal markPrice) {
		this.markPrice = markPrice;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getOverTime() {
		return overTime;
	}



	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}



	public BigDecimal getMinNum() {
		return minNum;
	}



	public void setMinNum(BigDecimal minNum) {
		this.minNum = minNum;
	}



	public BigDecimal getTotalNum() {
		return totalNum;
	}



	public void setTotalNum(BigDecimal totalNum) {
		this.totalNum = totalNum;
	}



	public BigDecimal getLimitNum() {
		return limitNum;
	}



	public void setLimitNum(BigDecimal limitNum) {
		this.limitNum = limitNum;
	}



	public String getCreateTime() {
		return createTime;
	}



	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	

}
