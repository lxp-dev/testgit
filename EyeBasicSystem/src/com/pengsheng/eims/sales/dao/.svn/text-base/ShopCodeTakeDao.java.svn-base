package com.pengsheng.eims.sales.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;

public interface ShopCodeTakeDao {

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
	 * 更新销售基表的在途状态
	 * 
	 * @param salesBasicPo
	 */
	public void updateInTransit(SalesBasicPo salesBasicPo);

	/**
	 * 信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertInTransit(InTransitPo inTransitPo);

	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfo(SalesDetailPo salesDetailPo);

	/**
	 * 将商品详细信息插入当月库存变更表中
	 * 
	 * @param strogeLogPo
	 */
	public void insertGoodsInfo(StrogeChangePo strogeChangePo);

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

	/**
	 * 获取短信平台维护表信息
	 * 
	 * @param smsSetPo
	 * @return
	 */
	public SmsSetPo getSmsSet();
	/**
	 * 获取到镜提醒时间
	 * @param salesID
	 * @return
	 */
	public SalesBasicPo getSalesBasic(String salesID);

	/**
	 * 得到销售结帐基表对象
	 */
	public SalesBasicPo getSalesBasicPo(String salesID);

	/**
	 * 得到所有顾客销售结帐明细表,销售结帐基表对应的
	 */
	public List<SalesDetailPo> getSalesDetail(String ssesdsalesid);
}
