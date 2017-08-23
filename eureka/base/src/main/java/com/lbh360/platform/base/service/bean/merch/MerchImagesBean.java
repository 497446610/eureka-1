package com.lbh360.platform.base.service.bean.merch;

import java.io.Serializable;

/**
 * 商品图片
 * 
 */
@SuppressWarnings("serial")
public class MerchImagesBean implements Serializable {
	/**
	 * 商品图片
	 */
	public static final String CATEGORY_HEAD = "head";

	/**
	 * 商品图片
	 */
	public static final String CATEGORY_MAIN = "main";

	/**
	 * 图文详情
	 */
	public static final String CATEGORY_MORE = "more";

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 商品ID
	 */
	private Long merchId;

	/**
	 * 类别,main:商品图片 more:图文详情
	 */
	private String category;

	/**
	 * url
	 */
	private String url;
	
	/**
	 * 缩微图
	 */
	private String smallurl;

	/**
	 * 显示顺序
	 */
	private Integer showNO;
	
	/**
	 * 供应商ID
	 */
	private String compId;

	/**
	 * 创建时间yyyy-MM-dd
	 */
	private String createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMerchId() {
		return merchId;
	}

	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getShowNO() {
		return showNO;
	}

	public void setShowNO(Integer showNO) {
		this.showNO = showNO;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSmallurl() {
		return smallurl;
	}

	public void setSmallurl(String smallurl) {
		this.smallurl = smallurl;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	
}
