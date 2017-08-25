package com.lbh360.platform.base.trans.dto.merch;

import java.math.BigDecimal;

import com.lbh360.platform.base.trans.dto.PageDTO;

public class MerchBaseInfoDTO extends PageDTO {

	/**
	 * 企业ID
	 */
	private String compId;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 模仿查询字段
	 */
	private String search;

	/**
	 * 一级分类
	 */
	private String level1Code;

	/**
	 * 二级分类
	 */
	private String level2Code;

	/**
	 * 包装规格
	 */
	private String packSize;

	/**
	 * 品牌
	 */
	private String brand;

	/**
	 * 上架状态<br/>
	 * 0、未上架 1、已上架
	 */
	private Integer isOnline;

	/**
	 * 平台控制是否能产生交易<br/>
	 * 0、不能产生交易 1、可以产生交易
	 */
	private Integer isTrans;

	/**
	 * 单价
	 */
	private BigDecimal pricemin;

	/**
	 * 单价
	 */
	private BigDecimal pricemax;

	/**
	 * 是否标品 0 否，1是
	 */
	private Integer isStand;

	/**
	 * 排序字段
	 */
	private String orderField;

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getLevel1Code() {
		return level1Code;
	}

	public void setLevel1Code(String level1Code) {
		this.level1Code = level1Code;
	}

	public String getLevel2Code() {
		return level2Code;
	}

	public void setLevel2Code(String level2Code) {
		this.level2Code = level2Code;
	}

	public String getPackSize() {
		return packSize;
	}

	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	public Integer getIsTrans() {
		return isTrans;
	}

	public void setIsTrans(Integer isTrans) {
		this.isTrans = isTrans;
	}

	public BigDecimal getPricemin() {
		return pricemin;
	}

	public void setPricemin(BigDecimal pricemin) {
		this.pricemin = pricemin;
	}

	public BigDecimal getPricemax() {
		return pricemax;
	}

	public void setPricemax(BigDecimal pricemax) {
		this.pricemax = pricemax;
	}

	public Integer getIsStand() {
		return isStand;
	}

	public void setIsStand(Integer isStand) {
		this.isStand = isStand;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

}
