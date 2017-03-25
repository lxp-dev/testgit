package com.pengsheng.eims.his.mgr;

import java.util.List;

import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface HisMgr {

	/**
	 * 1. 接口名称：HIS系统患者信息调阅接口
	 * 2. 参          数：cardno 诊疗卡物理ID或身份证ID
	 *             hisLogPo 接口调用记录 
	 * 3. 返回值：患者信息的JSON
	 */
	public String getCustomerInfoByHis(String cardno);
	
	/**
	 * 1. 接口名称：视光系统挂号退费确认接口
	 * 2. 参          数：memberid 患者ID
	 *             todayoutpatientid 当日就诊号
	 * 3. 返回值：患者是否验光的状态
	 */
	public int getCustomerOptometryStateByHis(String memberid,String todayoutpatientid);
		
	/**
	 * 1. 接口名称：HIS系统待交费用推送接口（门店销售）
	 * 2. 参          数：billid 配镜单号，以X开头的单号
	 *             type 收费、退费
	 *             logPo 调用日志
	 */
	public void insertSalesNotChargeInfoToHis(String billid,String type,String state,PersonInfoPo ppo,LogisticsLogPo logPo);
	
	/**
	 * 1. 接口名称：HIS系统待交费用推送接口（验光）
	 * 2. 参          数：billid 挂号单号
	 *             type 收费、退费
	 *             logPo 调用日志
	 */
	public void insertRegisteredNotChargeInfoToHis(String billid,String type,PersonInfoPo ppo,LogisticsLogPo logPo);
	
	/**
	 * 1. 接口名称：HIS系统作废待交费用接口
	 * 2. 参          数：billid 缴费单号
	 *             hisLogPo 调用日志
	 */
	public String updateSalesBillStateByHis(String billid);
	
	/**
	 * 
	 * 视光系统挂号退费确认接口调用记录日志
	 * @param hisLogPo
	 */
	public void updateLog(HisLogPo hisLogPo);
	
	/**
	 * 1. 用          途：根据配镜单号查询商品明细中是否存在未设置收费明细的商品
	 * 2. 参          数：billid 缴费单号
	 */
	public List<SalesDetailPo> getSalesDetailNotSetPayFeeList(String billid);

	/**
	 * 接口6)
	 * 
	 * 1. 接口名称：视光系统提供挂号退费成功确认接口
	 * 2. 用       途：HIS调用接口反刷患者在视光系统验光退费状态
	 */
	public void updateCustOptStaOKByHis(HisParamPo hisParamPo);
	
	/**
	 * 视光系统提供挂号退费成功确认接口
	 * 参数: 1) memberid:患者ID
	 *      2) todayoutpatientid:当日就诊号
	 * 返回记录数
	 * 
	 */
	public int getCustomerIsrefundStateByHis(String memberid,String todayoutpatientid);

	public int getChargeCount(HisParamPo po);
	
}
