package com.lbh360.platform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.lbh360.platform.dao.common.Page;
import com.pt.core.controller.ControllerAjaxResult;
import com.pt.core.converter.BigDecimalConverter;
import com.pt.core.utils.ObjectUtil;

/**
 * 命令
 * 
 * @author user
 * 
 */
public abstract class AbstractCommand {
	
	static {
		// 注册BigDecimal的转换器，即允许BeanUtils.copyProperties时的源目标的BigDecimal类型的值允许为空
		ConvertUtils.register(new BigDecimalConverter(),
				java.math.BigDecimal.class);
	}
	

	protected final String SESSIONLOGIN = "SESSIONUSER";
	protected final String SIGNUPINFO = "SIGNUPINFO";
	protected final String SOFTKEY_HCDOG = "hcdog";// 好吃狗
	protected final String SOFTKEY_SUPPLIER = "supplier";// 供应商

	protected String commandNM = "";

	public String getCommandNM() {
		return commandNM;
	}

	public void setCommandNM(String commandNM) {
		this.commandNM = commandNM;
	}

	public void init(ServletContext servletContext) {

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

	protected ControllerAjaxResult ajaxResult(String code, String message, Object row, Integer total) {
		return new ControllerAjaxResult(code, message, row, total.toString());
	}

	protected ControllerAjaxResult ajaxResult(String code, String message, Object row, Integer total,
			Integer totalPage) {
		return new ControllerAjaxResult(code, message, row, total.toString(), totalPage.toString());
	}

	protected ControllerAjaxResult ajaxResult(String code, String message, Object row, Page page) {
		return new ControllerAjaxResult(code, message, row, page.getTotalRecord().toString(),
				page.getTotalPages().toString());
	}

	/** 默认显示行数 */
	protected Integer defSize = 5;

	/**
	 * 取得分页对象
	 * 
	 * @param request
	 * @return
	 */
	protected Page getPage(HttpServletRequest request) {
		String strPageIndex = request.getParameter("pageNo");
		String strNumPerPage = request.getParameter("pageSize");
		if (ObjectUtil.isNull(strPageIndex)) {
			strPageIndex = request.getParameter("pagNo");
		}
		if (ObjectUtil.isNull(strNumPerPage)) {
			strNumPerPage = request.getParameter("pagSize");
		}
		int pageIndex = NumberUtils.toInt(strPageIndex, 1);
		int numPerPage = NumberUtils.toInt(strNumPerPage, defSize);
		Page page = new Page(pageIndex, numPerPage);
		return page;
	}

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

}
