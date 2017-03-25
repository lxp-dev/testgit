package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface PutOptometryOrderMgr {

	/**
	 * 得到打印配镜单信息
	 * @return
	 */
	public List<SalesBasicPo> selectPutOptometryOrder(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 得到打印配镜单信息数量
	 * @return
	 */
	public int getPutOptometryOrderCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到顾客信息根据配镜单号
	 * @param salesBasicPo
	 * @return
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo);
}
