package com.lbh360.platform.base.service.bean.merch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类
 * 
 */
@SuppressWarnings("serial")
public class MerchCategoryBean implements Comparable<MerchCategoryBean>, Serializable {

	/**
	 * 分类Code
	 */
	private String id;

	/**
	 * 分类名称
	 */
	private String name;

	/**
	 * 分类路径
	 */
	private String paths;

	/**
	 * 分类图标路径
	 */
	private String iconURL;

	/**
	 * 级别
	 */
	private Integer pathLevel;

	/**
	 * 父Code
	 */
	private String parentId;

	/**
	 * 分类状态<br/>
	 * enable:可用, disable:停用
	 */
	private String status;

	/**
	 * 显示顺序号
	 */
	private Integer showNO;

	List<MerchCategoryBean> sub;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public Integer getPathLevel() {
		return pathLevel;
	}

	public void setPathLevel(Integer pathLevel) {
		this.pathLevel = pathLevel;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getShowNO() {
		return showNO;
	}

	public void setShowNO(Integer showNO) {
		this.showNO = showNO;
	}

	public List<MerchCategoryBean> getSub() {
		if (sub == null) {
			sub = new ArrayList<MerchCategoryBean>();
		}
		return sub;
	}

	public void setSub(List<MerchCategoryBean> sub) {
		this.sub = sub;
	}

	@Override
	public int compareTo(MerchCategoryBean o) {
		if (this.showNO == null) {
			return 0;
		}
		if (o == null || o.showNO == null) {
			return 0;
		}
		return this.showNO.compareTo(o.getShowNO());
	}

	public List<MerchCategoryBean> getChildren() {
		return getSub();
	}

}
