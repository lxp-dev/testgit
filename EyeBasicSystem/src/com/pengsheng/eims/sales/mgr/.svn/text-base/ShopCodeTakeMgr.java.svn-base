package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface ShopCodeTakeMgr {

	/**
	 * 查询门店取镜信息
	 * 
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectShopCodeTake(SalesBasicPo salesBasicPo,
			int start, int size);

	/**
	 * 查询门店取镜信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getShopCodeTakeCount(SalesBasicPo salesBasicPo);

	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfo(SalesDetailPo salesDetailPo);

	/**
	 * 查询客户信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(String salesid);

	/**
	 * 获取短信平台维护表信息
	 * 
	 * @param smsSetPo
	 * @return
	 */
	public SmsSetPo getSmsSet();

	/**
	 * 新增顾客取镜信息
	 * 
	 * @param smsRecordPo
	 * @param inTransitPo
	 * @param salesPo
	 * @param goodsSalesType
	 * @throws Exception 
	 */
	public void insertShopCodeTake(SendNotePo snpo,InTransitPo inTransitPo, SalesBasicPo salesPo,
			String goodsSalesType,CustomerInfoPo customerInfoPo,PersonInfoPo personInfoPo,LogisticsLogPo logPo) throws Exception ;
	
	/**
	 * 获取到镜提醒时间
	 * @param salesID
	 * @return
	 */
	public SalesBasicPo getSalesBasic(String salesID);
	
	public void insertShopCodeTakeBulk(String[] salesids, String[] memberids,SendNotePo snpo,InTransitPo inTransitPo, SalesBasicPo salesPo,
			String goodsSalesType,CustomerInfoPo customerInfoPo,PersonInfoPo personInfoPo,LogisticsLogPo logPo,String ssesbsalerid) throws Exception ;
}
