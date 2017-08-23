
package com.pt.core.common.exception;

/**
 * 
 *错误代码
 *
 * @version 	1.0 2011-3-26
 * @author		kuangxf
 * @history	
 *
 */
public class ErrorCode {
	private final static String DAO = "DB";
	
	private final static String SERVICE = "SERVICE";
	
	/** dao异常错误代码 */
	public enum DaoCode {
		/** 保存错误 */
		SAVE(ErrorCode.DAO + "001"),
		/** 删除错误 */
		DELETE(ErrorCode.DAO + "002"),
		/** 保存错误 */
		UPDATE(ErrorCode.DAO + "003"),
		/** 查询错误 */
		QUERY(ErrorCode.DAO + "004");

		private final String ERRORCODE;

		private DaoCode(String code) {
			ERRORCODE = code;
		}

		@Override
		public String toString() {
			return ERRORCODE;
		}
	}

	/** service异常错误代码 */
	public enum ServiceCode {
		/** 保存错误 */
		SAVE(ErrorCode.SERVICE + "001"),
		/** 删除错误 */
		DELETE(ErrorCode.SERVICE + "002"),
		/** 保存错误 */
		UPDATE(ErrorCode.SERVICE + "003"),
		/** 查询错误 */
		QUERY(ErrorCode.SERVICE + "004");
		
		private final String ERRORCODE;

		private ServiceCode(String code) {
			ERRORCODE = code;
		}

		@Override
		public String toString() {
			return ERRORCODE;
		}
	}

}
