package com.lbh360.cloud.wap;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	/** 默认显示行数 */
	protected Integer defNumPerPage = 20;

	/**
	 * 将前台传上来的数据封装成map
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> request2Map(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String temValue = null;
		for (Object temKey : request.getParameterMap().keySet()) {
			temValue = request.getParameter(temKey.toString());
			if (null != temValue && !"".equals(temValue)) {
				map.put(temKey.toString(), temValue);
			}
		}

		return map;
	}

/*	protected ControllerAjaxResult ajaxResult() {
		return new ControllerAjaxResult(null, null, null);
	}

	protected ControllerAjaxResult ajaxResult(String code) {
		return new ControllerAjaxResult(code, null, null);
	}

	protected ControllerAjaxResult ajaxResult(String code, String message) {
		return new ControllerAjaxResult(code, message, null);
	}

	protected ControllerAjaxResult ajaxResult(String code, String message, Object data) {
		return new ControllerAjaxResult(code, message, data);
	}

	protected ControllerAjaxResult ajaxResult(String code, String message, Object row, String total) {
		return new ControllerAjaxResult(code, message, row, total);
	}

	protected ControllerAjaxResult ajaxResult(String code, String message, Object row, String total, String totalPage) {
		return new ControllerAjaxResult(code, message, row, total, totalPage);
	}
*/
}
