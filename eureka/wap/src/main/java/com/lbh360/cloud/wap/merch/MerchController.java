package com.lbh360.cloud.wap.merch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lbh360.cloud.wap.BaseController;
import com.pt.core.controller.ControllerAjaxResult;

import net.sf.json.JSONObject;

@RestController
public class MerchController extends BaseController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "list", produces = "application/json; charset=UTF-8")
	public ControllerAjaxResult list() {
		ControllerAjaxResult result = restTemplate.getForObject("http://merchService/merch/list",
				ControllerAjaxResult.class);
		return result;
	}

	@RequestMapping(value = "list2", produces = "application/json; charset=UTF-8")
	public ControllerAjaxResult list2(HttpServletRequest request) {

		JSONObject parm = new JSONObject();
		parm.put("pageNo", request.getParameter("pageNo"));

		// HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(parm);

		ControllerAjaxResult result = restTemplate.postForObject("http://merchService/merch/list", parm,
				ControllerAjaxResult.class);
		return result;
	}

}
