package com.lbh360.platform.base.common;

/**
 * 
 * 服务异常代码类
 * 
 * @version 1.0 2011-4-14
 * @author kuangxf
 * @history
 * 
 */
public enum ServiceErrorCode {

	QUERY("001"), ADD("002"), UPDATE("003"), DELETE("004");


	/**
	 * 错误代码
	 */
	private final String ERRORCODE;

	private ServiceErrorCode(String code) {
		ERRORCODE = code;
	}

	@Override
	public String toString() {
		return ERRORCODE;
	}

}
