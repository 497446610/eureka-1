package com.lbh360.cloud.platform.service.merch;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lbh360.cloud.platform.dao.common.Page;
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
public interface IMerchService {

	List<MerchBaseInfoVO> queryMerchInfo4Restaurant(Map<String, Object> condition, String orderField, Page page)
			throws ServiceException;

	List<MerchBaseInfoVO> queryMerchInfo4Restaurant(MerchBaseInfoDTO merchDTO, Page page) throws ServiceException;

	void addMerchBaseInfo(MerchBaseInfoVO merchbaseInfo) throws ServiceException;

}
