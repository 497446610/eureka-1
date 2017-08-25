package com.lbh360.platform.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lbh360.platform.base.dao.domain.merch.MerchBaseInfo;
import com.lbh360.platform.dao.common.Page;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MerchBaseInfoMapper extends Mapper<MerchBaseInfo> {

	List<MerchBaseInfo> selectByCondition(Map<String, Object> condition, Page page);
}