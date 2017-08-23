
package com.pt.core.dao.common;

import com.pt.core.common.exception.ErrorCode;

/**
 * 
 * DAO异常
 *
 * @version 	1.0 2011-3-26
 * @author		kuangxf
 * @history	
 *
 */
@SuppressWarnings("serial")
public class DBException extends Exception {

	/** 异常代码 */
	ErrorCode.DaoCode errorCode;
	/** 异常信息 */
	String errorMsg;
	/** 根异常，保持异常链 */
	protected Throwable caused;

	public DBException(ErrorCode.DaoCode errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public DBException(ErrorCode.DaoCode errorCode, Throwable caused) {
		super(caused);
		this.errorCode = errorCode;
		this.caused = caused;
	}

	public DBException(ErrorCode.DaoCode errorCode, String errorMsg,
			Throwable caused) {
		super(errorMsg, caused);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.caused = caused;
	}

	public ErrorCode.DaoCode getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Throwable getCaused() {
		return caused;
	}
	
	
}
