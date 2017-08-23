package com.lbh360.platform.base.service.bean.merch;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品信息
 * 
 */
public class MerchBaseInfoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6512514632351875193L;

	public static final Integer ONLINE_YES = 1;// 已上架

	public static final Integer ONLINE_NO = 0;// 未上架
	
	
	public static final Integer ISSTAND_YES = 1;// 标品

	public static final Integer ISSTAND_NO = 0;// 非标品
	

	/**
	 * 商品ID
	 */
	private Long id;

	/**
	 * 企业ID
	 */
	private String compid;

	/**
	 * 供应商名称
	 */
	private String compNM;

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
	 * 一级分类名称
	 */
	private String level1Name;

	/**
	 * 二级分类
	 */
	private String level2Code;

	/**
	 * 二级分类名称
	 */
	private String level2Name;

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
	 * 缩微头像
	 */
	private String smallHeadURL;

	/**
	 * 商品说明
	 */
	private String descript;

	/**
	 * 单价
	 */
	private BigDecimal price;

	/**
	 * 采购价
	 */
	private BigDecimal costPrice;

	/**
	 * 市场价
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
	 * 累计订单数量
	 */
	private Long orderNum;

	/**
	 * 本月订单数量
	 */
	private Long monthOrderNum;

	/**
	 * 包装内的单价
	 */
	private BigDecimal secPrice;

	/**
	 * 包装内的计量单位
	 */
	private String secUnitName;

	/**
	 * 商品头像图
	 */
	private List<String> imageList;

	/**
	 * 评论数量
	 */
	private Integer commentNum;

	/**
	 * 评论累计得分
	 */
	private Integer commentScore;



	/**
	 * 供货商端商品的ID
	 */
	private String extId;

	/**
	 * 所有商品图片
	 */
	private List<MerchImagesBean> allImgList;

	/**
	 * 是否已经收藏
	 */
	private Boolean isCollect = false;

	
	
	
	/**
	 * 是否标品 0 否，1是
	 */
	private Integer isStand;
	
	/**
	 * 关联的非标品商品ID
	 */
	private Long linkMerchId;
	
	/**
	 * 是否支持白条（0 不支持，1支持）
	 */
	private Integer isSupportLous;

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

	public String getCompNM() {
		return compNM;
	}

	public void setCompNM(String compNM) {
		this.compNM = compNM;
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

	public String getLevel1Name() {
		return level1Name;
	}

	public void setLevel1Name(String level1Name) {
		this.level1Name = level1Name;
	}

	public String getLevel2Name() {
		return level2Name;
	}

	public void setLevel2Name(String level2Name) {
		this.level2Name = level2Name;
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
		if (smallHeadURL == null || smallHeadURL.trim().length() <= 0) {
			return headURL;
		}
		return smallHeadURL;
	}

	public void setSmallHeadURL(String smallHeadURL) {
		this.smallHeadURL = smallHeadURL;
	}

	public List<String> getImageList() {
		if (imageList == null) {
			return new ArrayList<>();
		}
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(Integer commentScore) {
		this.commentScore = commentScore;
	}

	
	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}

	public List<MerchImagesBean> getAllImgList() {
		return allImgList;
	}

	public void setAllImgList(List<MerchImagesBean> allImgList) {
		this.allImgList = allImgList;
	}

	public Boolean getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(Boolean isCollect) {
		this.isCollect = isCollect;
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

	public Integer getIsSupportLous() {
		return isSupportLous;
	}

	public void setIsSupportLous(Integer isSupportLous) {
		this.isSupportLous = isSupportLous;
	}

}
