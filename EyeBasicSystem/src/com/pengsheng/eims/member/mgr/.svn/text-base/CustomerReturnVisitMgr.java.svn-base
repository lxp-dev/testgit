package com.pengsheng.eims.member.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.CustomerVisitPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface CustomerReturnVisitMgr {

	/**
	 * 得到顾客回访信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerReturnVisitCount(SalesBasicPo salesBasicPo,
			CustomerVisitPo customerVisitPo,SystemParameterPo systemParameterPo);

	/**
	 * 查询顾客回访信息
	 * 
	 * @param SalesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerReturnVisitList(
			SalesBasicPo salesBasicPo, CustomerVisitPo customerVisitPo,
			int start, int size,SystemParameterPo systemParameterPo);

	/**
	 * 得到要回访的顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getReturnCustomerInfo(SalesBasicPo salesBasicPo);

	/**
	 * 取出销售单中右眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);

	/**
	 * 取出销售单中左眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);

	/**
	 * 得到配镜单中商品的详细信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo);

	/**
	 * 取得特殊加工要求
	 * 
	 * @param specialPDetailPo
	 * @return
	 */
	public List<SpecialPDetailPo> getSpecialPDetail(
			SpecialPDetailPo specialPDetailPo);

	/**
	 * 取得附加费用
	 * 
	 * @param additionalCDetailPo
	 * @return
	 */
	public List<AdditionalCDetailPo> getAddititonalCDetail(
			AdditionalCDetailPo additionalCDetailPo);

	/**
	 * 得到顾客回访信息
	 * 
	 * @param customerVisitPo
	 * @return
	 */
	public List<CustomerVisitPo> getCustomerVisitInfo(CustomerVisitPo customerVisitPo);

	/**
	 * 插入回访明细表
	 * 
	 * @param customerVisitPo
	 */
	public void insertCustomerVisit(CustomerVisitPo customerVisitPo,CustomerInfoPo customerInfoPo,PersonInfoPo personInfoPo,SmsRecordPo smsRecordPo,String isSend,LogisticsLogPo logPo);

	// /**
	// * 新增短信记录表
	// * @param smsRecordPo
	// */
	// public void insertSmsRecord(SmsRecordPo smsRecordPo);
	//	
	//	
	// /**
	// * 查询顾客信息
	// * @param salesBasicPo
	// * @return
	// */
	// public CustomerInfoPo getCustomerInfo(String salesid );

	/**
	 * 新增短信记录表
	 * 
	 * @param smsRecordPo
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo);

	/**
	 * 查询顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(String salesid);

	// public List<CustomerInfoPo> getCustomerInfo() ;

	/**
	 * 获取短信平台维护表信息
	 * 
	 * @param smsSetPo
	 * @return
	 */
	public SmsSetPo getSmsSet();
}
