package com.lbh360.platform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lbh360.cloud.platform.dao.common.Page;
import com.lbh360.cloud.platform.service.merch.IMerchService;
import com.lbh360.platform.base.service.vo.merch.MerchBaseInfoVO;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@MapperScan("com.lbh360.platform.dao")
public class SpringbootApplicationTests2 {
	
	@Autowired
	IMerchService merchService;
	
	@Test
	public void test() throws Exception {
		
		Map<String, Object> condition = new HashMap<>();
		
		List<MerchBaseInfoVO> list =  merchService.queryMerchInfo4Restaurant(condition, null,new Page(1, 10));
		for (MerchBaseInfoVO merchBaseInfoBean : list) {
			System.out.println(merchBaseInfoBean.getName());
		}
	}
}

