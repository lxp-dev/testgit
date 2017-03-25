package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.TakeMsgPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface CustomerTakeMgr {

	/**
	 * 得到顾客取镜信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerTakeCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到顾客取镜信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerTake(SalesBasicPo salesBasicPo , int start , int size);
	
	public int getTakeMsgCount(TakeMsgPo takeMsgPo);
	public List<TakeMsgPo> selectTakeMsgList(TakeMsgPo takeMsgPo , int start , int size);
	
	/**
	 * 新增顾客取镜查询信息
	 * @param inTransitPo
	 * @param salesPo
	 */
	public void insertCustomerTake(InTransitPo inTransitPo, SalesBasicPo salesPo,NoteTemplatePo noteTemplatePo,List<SalesDetailPo> goodsInfoList,PersonInfoPo personInfoPo,String ssesbMemberId,LogisticsLogPo logPo,SystemParameterPo systemParameterPo);
	/**
	 * 新增顾客取镜查询信息同时插入备注信息
	 * @param inTransitPo
	 * @param salesPo
	 */
	public void insertCustomerTakeAndTakeMsg(InTransitPo inTransitPo, SalesBasicPo salesPo,NoteTemplatePo noteTemplatePo,List<SalesDetailPo> goodsInfoList,PersonInfoPo personInfoPo,String ssesbMemberId,LogisticsLogPo logPo,SystemParameterPo systemParameterPo,TakeMsgPo takeMsgPo);
	/**
	 * 新增顾客取镜查询信息
	 * @param inTransitPo
	 * @param salesPo
	 */
	public void insertCustomerTakeBulk(String[] salesids,String[] memberids,NoteTemplatePo noteTemplatePo,PersonInfoPo personInfoPo,String ssesbsalerid,SystemParameterPo systemParameterPo,LogisticsLogPo logPo);
	
	/**
	 * 取镜前判断库存
	 * @param inTransitPo
	 * @param salesPo
	 * @param noteTemplatePo
	 * @param goodsInfoList
	 * @param personInfoPo
	 * @param ssesbMemberId
	 * @param logPo
	 * @param systemParameterPo
	 * @param takeMsgPo
	 * @return
	 */
	public String insertCustomerTakeCheck(InTransitPo inTransitPo, SalesBasicPo salesPo,NoteTemplatePo noteTemplatePo,List<SalesDetailPo> goodsInfoList,PersonInfoPo personInfoPo,String ssesbMemberId,LogisticsLogPo logPo,SystemParameterPo systemParameterPo,TakeMsgPo takeMsgPo);
	
	/**
	 * 批量取镜前判断库存
	 * @param inTransitPo
	 * @param salesPo
	 * @param noteTemplatePo
	 * @param goodsInfoList
	 * @param personInfoPo
	 * @param ssesbMemberId
	 * @param logPo
	 * @param systemParameterPo
	 * @param takeMsgPo
	 * @return
	 */
	public String insertCustomerTakeBulkCheck(String[] salesids, String[] memberids,NoteTemplatePo noteTemplatePo, PersonInfoPo personInfoPo,String ssesbsalerid, SystemParameterPo systemParameterPo,LogisticsLogPo logPo);
}
