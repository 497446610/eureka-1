package com.lbh360.cloud.platform.dao.manager;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lbh360.cloud.platform.dao.common.BaseManager;
import com.lbh360.cloud.platform.dao.common.Page;
import com.lbh360.cloud.platform.dao.mapper.MerchBaseInfoMapper;
import com.lbh360.platform.base.dao.domain.merch.MerchBaseInfo;

@Repository
public class MerchInfoManager extends BaseManager<MerchBaseInfoMapper, MerchBaseInfo> {

	private final static Logger logger = LoggerFactory.getLogger(MerchInfoManager.class);

	public List<MerchBaseInfo> selectByCondition(Map<String, Object> condition, Page page) {
		logger.debug("MerchInfoManagerImpl");
		return mapper.selectByCondition(condition, page);
	}
}
