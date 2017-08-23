package com.lbh360.platform.base.dao.domain.merch;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息
 * 
 */
@SuppressWarnings("serial")
public class MerchBaseInfo implements Serializable {

	/**
	 * 商品ID
	 */
	private Long id;
	
	/**
	 * 企业ID
	 */
	private String compid;
	

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 分类路径
	 */
	private String paths;

	/**
	 * 一级分类
	 */
	private String level1Code;

	/**
	 * 二级分类
	 */
	private String level2Code;

	/**
	 * 计量单位
	 */
	private String unitName;

	/**
	 * 包装规格
	 */
	private String packSize;

	/**
	 * 品牌
	 */
	private String brand;

	/**
	 * 等级
	 */
	private String grade;

	/**
	 * 生产厂家
	 */
	private String verder;

	/**
	 * 产地
	 */
	private String place;


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

	// -----配送说明------

	/**
	 * 下单时间
	 */
	private Integer dayofhour;

	/**
	 * 下单时间之前配送时间(多少小时内）
	 */
	private Integer beforeTimes;

	/**
	 * 下单时间之后配送时间(多少小时内）
	 */
	private Integer afterTimes;

	/**
	 * 商品图片URL
	 */
	private String headURL;
	
	/**
	 * 商品图片URL
	 */
	private String  smallHeadURL;

	/**
	 * 商品说明
	 */
	private String descript;
	
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
	 * 最低采购量
	 */
	private BigDecimal minNum;

	/**
	 * 供应量（1可以销售，0已售罄）
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
	
	/**
	 * 包装内的单价
	 */
	private BigDecimal secPrice;
	
	/**
	 * 包装内的计量单位
	 */
	private String secUnitName;
	
	/**
	 * 是否标品 0 否，1是
	 */
	private Integer isStand;
	
	/**
	 * 关联的非标品商品ID
	 */
	private Long linkMerchId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaths() {
		return paths;
	}

	public void setPaths(String paths) {
		this.paths = paths;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getVerder() {
		return verder;
	}

	public void setVerder(String verder) {
		this.verder = verder;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public Integer getDayofhour() {
		return dayofhour;
	}

	public void setDayofhour(Integer dayofhour) {
		this.dayofhour = dayofhour;
	}

	public Integer getBeforeTimes() {
		return beforeTimes;
	}

	public void setBeforeTimes(Integer beforeTimes) {
		this.beforeTimes = beforeTimes;
	}

	public Integer getAfterTimes() {
		return afterTimes;
	}

	public void setAfterTimes(Integer afterTimes) {
		this.afterTimes = afterTimes;
	}

	public String getHeadURL() {
		return headURL;
	}

	public void setHeadURL(String headURL) {
		this.headURL = headURL;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public BigDecimal getSecPrice() {
		return secPrice;
	}

	public void setSecPrice(BigDecimal secPrice) {
		this.secPrice = secPrice;
	}

	public String getSecUnitName() {
		return secUnitName;
	}

	public void setSecUnitName(String secUnitName) {
		this.secUnitName = secUnitName;
	}

	public String getSmallHeadURL() {
		return smallHeadURL;
	}

	public void setSmallHeadURL(String smallHeadURL) {
		this.smallHeadURL = smallHeadURL;
	}

	public Integer getIsStand() {
		return isStand;
	}

	public void setIsStand(Integer isStand) {
		this.isStand = isStand;
	}

	public Long getLinkMerchId() {
		return linkMerchId;
	}

	public void setLinkMerchId(Long linkMerchId) {
		this.linkMerchId = linkMerchId;
	}

	
	

}