package com.lbh360.cloud.wap.merch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pt.core.controller.ControllerAjaxResult;

@RestController
public class MerchController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "list", produces = "application/json; charset=UTF-8")
	public ControllerAjaxResult list() {
		ControllerAjaxResult result = restTemplate.getForObject("http://merchService/merch/list",
				ControllerAjaxResult.class);
		return result;
	}

	@RequestMapping("list2")
	public ResponseEntity<ControllerAjaxResult> list2() {
		ResponseEntity<ControllerAjaxResult> result = restTemplate.getForObject("http://merchService/list2",
				ResponseEntity.class);
		return result;
	}

}
