package com.lbh360.platform.dao.mapper.merch;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageRowBounds;
import com.lbh360.platform.base.dao.domain.merch.MerchBaseInfo;

public interface MerchBaseInfoMapper {

	int deleteByPrimaryKey(Long id);

	int insert(MerchBaseInfo record);

	MerchBaseInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MerchBaseInfo record);

	int updateByPrimaryKey(MerchBaseInfo record);

	List<MerchBaseInfo> selectByCondition(Map<String, Object> condition);

	List<MerchBaseInfo> selectByCondition(Map<String, Object> condition, 
			PageRowBounds pageRowBounds);
}