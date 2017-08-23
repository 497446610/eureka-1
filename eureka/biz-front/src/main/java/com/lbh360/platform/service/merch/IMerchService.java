package com.lbh360.platform.service.merch;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lbh360.platform.base.service.bean.merch.MerchBaseInfoBean;
import com.pt.core.common.exception.ServiceException;
import com.pt.core.utils.Page;

/**
 * 说明: 功能描述
 * 
 * @author 况小锋
 * @version 1.0
 */
@Service
public interface IMerchService {

	List<MerchBaseInfoBean> queryMerchInfo4Restaurant(Map<String, Object> condition, String orderField,Page page)
			throws ServiceException;
	
	
	void addMerchBaseInfo(MerchBaseInfoBean merchbaseInfo)throws ServiceException;

}
