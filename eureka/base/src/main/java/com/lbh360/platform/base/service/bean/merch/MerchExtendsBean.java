package com.lbh360.platform.base.service.bean.merch;

import java.io.Serializable;

/**
 * 商品扩展属性
 * 
 */
public class MerchExtendsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8106151464274484698L;

	/**
	 * 商品ID
	 */
	private Long id;
	
	/**
	 * 供应商ID
	 */
	private String compId;
	
	
	/**
	 * 供货商端商品的ID
	 */
	private String extId;

	/**
	 * 扩展属性(JSONArray[{name:'',value:''}]
	 */
	private String props;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}
	
	

}
