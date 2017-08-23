package com.pt.core.controller;

/**
 * 说明: 功能描述
 * 
 * @author 况小锋
 * @version 1.0
 */
public class ControllerAjaxResult {
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILE = "FAILE";
	public static final String TIMEOUT = "TIMEOUT";
	public static final String NOAUTH = "NOAUTH";
	public static final String EMPTY = "EMPTY";// 没有数据
	public static final String DEPRECATED = "DEPRECATED";// 接口已经失效

	public static final String ERRORCOMMAND = "ERRORCOMMAND";
	/**
	 * 错误代码
	 */
	private String code;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 数据
	 */
	private Object data;
	// private Object rows;

	/**
	 * 总的记录数
	 */
	private String total;

	/**
	 * 总的页数
	 */
	private String totalPage;

	// private String jsessionId;

	/*
	 * public Object getRows() { return rows; }
	 * 
	 * public void setRows(Object rows) { this.rows = rows; }
	 */

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public ControllerAjaxResult(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ControllerAjaxResult(String code, String message, Object rows, String total) {
		this.code = code;
		this.message = message;
		this.data = rows;
		this.total = total;
	}

	public ControllerAjaxResult(String code, String message, Object rows, String total, String totalPage) {
		this.code = code;
		this.message = message;
		this.data = rows;
		this.total = total;
		this.totalPage = totalPage;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

}
