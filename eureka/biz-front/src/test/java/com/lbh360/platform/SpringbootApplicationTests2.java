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

import com.lbh360.platform.base.service.bean.merch.MerchBaseInfoBean;
import com.lbh360.platform.dao.common.Page;
import com.lbh360.platform.service.merch.IMerchService;

/*import com.dbuyer.springboot.jpa.order.MemberInfo;
import com.dbuyer.springboot.jpa.order.MemberInfoRepository;
import com.dbuyer.springboot.jpa.report.TradeOrder;
import com.dbuyer.springboot.jpa.report.TradeOrderRepository;*/

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
		
		List<MerchBaseInfoBean> list =  merchService.queryMerchInfo4Restaurant(condition, null,new Page(1, 10));
		for (MerchBaseInfoBean merchBaseInfoBean : list) {
			System.out.println(merchBaseInfoBean.getName());
		}
	}
}

