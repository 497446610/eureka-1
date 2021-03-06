package com.lbh360.cloud.platform.controller.merch;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbh360.cloud.platform.controller.AbstractCommand;
import com.lbh360.cloud.platform.dao.common.Page;
import com.lbh360.cloud.platform.service.merch.IMerchService;
import com.lbh360.cloud.platform.service.merch.impl.MerchServiceImpl;
import com.lbh360.platform.base.service.vo.merch.MerchBaseInfoVO;
import com.lbh360.platform.base.trans.dto.merch.MerchBaseInfoDTO;
import com.pt.core.common.exception.ServiceException;
import com.pt.core.controller.ControllerAjaxResult;

/**
 * 说明: 功能描述
 * 
 * @author 况小锋
 * @version 1.0
 */
@RestController
@RequestMapping(value = "merch")
public class MerchInfoController extends AbstractCommand {
	private final static Logger logger = LoggerFactory.getLogger(MerchServiceImpl.class);

	@Autowired
	IMerchService merchService;

	@RequestMapping(value = "list", produces = "application/json; charset=UTF-8")
	public ControllerAjaxResult merchlist(HttpServletRequest request) {
		Page page = getPage(request);
		List<MerchBaseInfoVO> result;
		try {
			Map<String, Object> condition = request2Map(request);
			result = merchService.queryMerchInfo4Restaurant(condition, null, page);
			return ajaxResult(ControllerAjaxResult.SUCCESS, "", result, page);
		} catch (ServiceException e) {
			logger.error("查询商品信息失败。", e);
			return ajaxResult(ControllerAjaxResult.FAILE, "数据查询失败！");
		}
	}

	@RequestMapping(value = "list3", produces = "application/json; charset=UTF-8")
	public ControllerAjaxResult queryByDto3(@ModelAttribute MerchBaseInfoDTO merchdto) {
		List<MerchBaseInfoVO> result;
		try {
			Page page = new Page(merchdto.getPageNo(), merchdto.getPageSize());

			result = merchService.queryMerchInfo4Restaurant(merchdto, page);
			return ajaxResult(ControllerAjaxResult.SUCCESS, "", result, page);
		} catch (ServiceException e) {
			return ajaxResult(ControllerAjaxResult.FAILE, "数据查询失败！");
		}
	}

	@RequestMapping(value = "save", produces = "application/json; charset=UTF-8")
	public ControllerAjaxResult save(@ModelAttribute MerchBaseInfoVO merch) {
		try {
			merchService.addMerchBaseInfo(merch);
			return ajaxResult(ControllerAjaxResult.SUCCESS, "商品保存成功！", merch.getId());
		} catch (ServiceException e) {
			logger.error("商品保存失败", e);
			return ajaxResult(ControllerAjaxResult.FAILE, "商品保存失败！");
		}

	}

}
