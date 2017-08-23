package com.lbh360.cloud.wap.merch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pt.core.controller.ControllerAjaxResult;

@RestController
public class MerchController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("list")
	public ControllerAjaxResult list() {
		ControllerAjaxResult result = restTemplate
				.getForEntity("http://merchService/merch/list", ControllerAjaxResult.class).getBody();
		return result;
	}

}
