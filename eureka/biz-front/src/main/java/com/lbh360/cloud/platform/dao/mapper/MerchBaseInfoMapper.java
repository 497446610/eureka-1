package com.lbh360.cloud.platform.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lbh360.cloud.platform.dao.common.Page;
import com.lbh360.platform.base.dao.domain.merch.MerchBaseInfo;
import com.lbh360.platform.base.trans.dto.merch.MerchBaseInfoDTO;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MerchBaseInfoMapper extends Mapper<MerchBaseInfo> {

	List<MerchBaseInfo> selectByCondition(Map<String, Object> condition, Page page);
	
	List<MerchBaseInfo> selectByDTO(MerchBaseInfoDTO dto, Page page);
}