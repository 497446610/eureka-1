package com.lbh360.platform.controller.merch;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbh360.platform.base.service.bean.merch.MerchBaseInfoBean;
import com.lbh360.platform.controller.AbstractCommand;
import com.lbh360.platform.dao.common.Page;
import com.lbh360.platform.service.merch.IMerchService;
import com.lbh360.platform.service.merch.impl.MerchServiceImpl;
import com.pt.core.common.exception.ServiceException;
import com.pt.core.controller.ControllerAjaxResult;

/**
 * 说明: 功能描述
 * 
 * @author 况小锋
 * @version 1.0
 */
@RestController
public class MerchInfoController extends AbstractCommand {
	private final static Logger logger = LoggerFactory.getLogger(MerchServiceImpl.class);

	@Autowired
	IMerchService merchService;

	@RequestMapping("list")
	public ControllerAjaxResult merchlist(HttpServletRequest request) {
		Page page = getPage(request);
		List<MerchBaseInfoBean> result;
		try {
			Map<String, Object> condition = request2Map(request);

			result = merchService.queryMerchInfo4Restaurant(condition, null, page);
			return ajaxResult(ControllerAjaxResult.SUCCESS, "", result, page);
		} catch (ServiceException e) {
			return ajaxResult(ControllerAjaxResult.FAILE, "数据查询失败！");
		}
	}

	@RequestMapping("list2")
	public ResponseEntity<ControllerAjaxResult> merchlist2(HttpServletRequest request) {
		Page page = getPage(request);
		List<MerchBaseInfoBean> result;
		try {
			Map<String, Object> condition = request2Map(request);

			result = merchService.queryMerchInfo4Restaurant(condition, null, page);

			return ResponseEntity.ok(ajaxResult(ControllerAjaxResult.SUCCESS, "", result, page));
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@RequestMapping("save")
	public ControllerAjaxResult save(@ModelAttribute MerchBaseInfoBean merch) {
		try {
			merchService.addMerchBaseInfo(merch);
			return ajaxResult(ControllerAjaxResult.SUCCESS, "商品保存成功！", merch.getId());
		} catch (ServiceException e) {
			logger.error("商品保存失败", e);
			return ajaxResult(ControllerAjaxResult.FAILE, "商品保存失败！");
		}

	}

}
