package com.lbh360.cloud.platform.service.merch.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lbh360.cloud.platform.dao.common.Page;
import com.lbh360.cloud.platform.dao.manager.MerchInfoManager;
import com.lbh360.cloud.platform.service.merch.IMerchService;
import com.lbh360.platform.base.common.ServiceErrorCode;
import com.lbh360.platform.base.dao.domain.merch.MerchBaseInfo;
import com.lbh360.platform.base.service.vo.merch.MerchBaseInfoVO;
import com.lbh360.platform.base.trans.dto.merch.MerchBaseInfoDTO;
import com.pt.core.common.exception.ServiceException;

/**
 * 说明: 功能描述
 * 
 * @author 况小锋
 * @version 1.0
 */
@Service
public class MerchServiceImpl implements IMerchService {

	private final static Logger logger = LoggerFactory.getLogger(MerchServiceImpl.class);

	@Autowired
	MerchInfoManager merchInfoManager;

	@Override
	public List<MerchBaseInfoVO> queryMerchInfo4Restaurant(Map<String, Object> condition, String orderField, Page page)
			throws ServiceException {
		logger.debug("开始查询商品信息！");
		List<MerchBaseInfoVO> result = new ArrayList<>();

		List<MerchBaseInfo> list = merchInfoManager.selectByCondition(condition, page);

		try {
			for (MerchBaseInfo merchBaseInfo : list) {
				MerchBaseInfoVO bean = new MerchBaseInfoVO();
				BeanUtils.copyProperties(bean, merchBaseInfo);
				result.add(bean);
			}
		} catch (Exception e) {
			logger.error("查询商品信息失败！", e);
		}
		return result;
	}

	@Override
	public List<MerchBaseInfoVO> queryMerchInfo4Restaurant(MerchBaseInfoDTO merchDTO, Page page)
			throws ServiceException {
		logger.debug("开始查询商品信息！");
		List<MerchBaseInfoVO> result = new ArrayList<>();

		List<MerchBaseInfo> list = merchInfoManager.selectByDTO(merchDTO, page);

		try {
			for (MerchBaseInfo merchBaseInfo : list) {
				MerchBaseInfoVO bean = new MerchBaseInfoVO();
				BeanUtils.copyProperties(bean, merchBaseInfo);
				result.add(bean);
			}
		} catch (Exception e) {
			logger.error("查询商品信息失败！", e);
		}
		return result;
	}

	@Override
	@Transactional
	public void addMerchBaseInfo(MerchBaseInfoVO merchbaseInfo) throws ServiceException {
		MerchBaseInfo record = new MerchBaseInfo();
		try {

			merchInfoManager.deleteByPrimaryKey(3355L);

			BeanUtils.copyProperties(record, merchbaseInfo);
			merchInfoManager.insert(record);
			merchbaseInfo.setId(record.getId());
			// throw new ServiceException(ServiceErrorCode.ADD.toString(),
			// "测试异常事务！");
		} catch (Exception e) {
			throw new ServiceException(ServiceErrorCode.ADD.toString(), "保存商品信息出现异常！");
		}

	}

}
