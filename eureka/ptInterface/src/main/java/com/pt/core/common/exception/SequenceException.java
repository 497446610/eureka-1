package com.pt.core.common.exception;

/**
 * Sequence异常
 * @author kuangxiaofeng
 *
 */
@SuppressWarnings("serial")
public class SequenceException extends Exception {
	/** 异常信息 */
	String errorMsg;
	/** 根异常，保持异常链 */
	protected Throwable caused;

	public SequenceException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public SequenceException( Throwable caused) {
		super(caused);
		this.caused = caused;
	}

	public SequenceException(String errorMsg,
			Throwable caused) {
		super(errorMsg, caused);
		this.errorMsg = errorMsg;
		this.caused = caused;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	public Throwable getCaused() {
		return caused;
	}
	
}
