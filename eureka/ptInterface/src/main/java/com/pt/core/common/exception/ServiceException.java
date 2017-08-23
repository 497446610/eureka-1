package com.pt.core.common.exception;


@SuppressWarnings("serial")
public class ServiceException extends Exception {

	String errorCode;
	String errorMsg;
	protected Throwable caused;

	public ServiceException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public ServiceException(String errorCode, Throwable caused) {
		super(caused);
		this.errorCode = errorCode;
		this.caused = caused;
	}

	public ServiceException(String errorCode, String errorMsg,
			Throwable caused) {
		super(errorMsg, caused);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.caused = caused;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Throwable getCaused() {
		return caused;
	}
	
	
}
