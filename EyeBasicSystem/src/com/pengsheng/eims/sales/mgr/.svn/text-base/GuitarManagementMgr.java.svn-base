/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangeEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * @author Liuqian
 * 
 */
public interface GuitarManagementMgr {

	/**
	 * 根据配镜单号查询顾客信息
	 * 
	 * @param customerInfoPo
	 * @return
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo);

	/**
	 * 得到打印镜单信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo);
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelect(WeiXinIntegralSelectPo po);
	/**
	 * 银台结款
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public void insertSalesGutiar(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,InTransitPo inTransitPo,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,SendNotePo snpo,SendNotePo snpo2,PersonInfoPo personInfoPo,NoteTemplatePo noteTemplatePo,LogisticsLogPo logPo,SystemParameterPo systemParameterPo,int jfType,int czkType,int djqType,WeixinInviteFriendLogPo weixinInviteFriendLogPo);

	/**
	 * 积分兑换商品
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public void insertIntegralExchange(SystemParameterPo systemParameterPo,IntegralExchangePo integralExchangePo,List<IntegralExchangeEntryPo> integralExchangeEntryPolist,
			LogisticsLogPo logPo);

	/**
	 * 删除销售单
	 * 
	 * @param salesID
	 */
	public void deleteGuitarManagement(String salesID,LogisticsLogPo logPo);
	
	/**
	 * 取得结款记录表Po
	 */
	public SalesLogPo getSalesLog(SalesLogPo salesLogPo);
	/**
	 * 销售日志插入
	 * @param salesLogPo
	 */
	public void insertSalesLog(SalesLogPo salesLogPo);
	
	
	public int getIntegralExchangeCount(IntegralExchangePo integralExchangePo);
	
	public List<IntegralExchangePo> getIntegralExchangeList(IntegralExchangePo integralExchangePo,int start, int size);
	
	public IntegralExchangePo getIntegralExchangeDetail(IntegralExchangePo integralExchangePo);
	
	public List<IntegralExchangeEntryPo> getIntegralExchangeDetailEntry(IntegralExchangePo integralExchangePo);
	
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po) ;
	
	/**
	 * 结款时判断配镜单是否存在
	 */
	public int getSalesBillCount(String salesID);
	
	/**
	 * 结款、隐形配送、配镜发料验证负库存	 * 
	 * salesID: 配镜单号
	 * systemParameterPo ：系统参数设定
	 * flag : 1:结款  2：隐形配送  3：配镜发料
	 * salesDetailList：销售商品信息
	 * 
	 * 返回值小于0则表示库存不足
	 */
	public int getNegativeStockBySalesGoods(String salesID,SystemParameterPo systemParameterPo,String flag,List<SalesDetailPo> salesDetailList);
	
	/**
	 * 更新实收金额
	 * @param po
	 */
	public void updateSalesValue(SalesBasicPo po,LogisticsLogPo logPo);
	
	/**
	 * 得到更新结款方式信息
	 */
	public List<SalesBasicPo> getUpdatePayTypeSalesBasics(SalesBasicPo salesBasicPo);
	
	public void updatePayType(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,InTransitPo inTransitPo,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String smecimemberid,LogisticsLogPo logPo,SystemParameterPo systemParameterPo);
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size);
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) ;
	public void updateWeiXinIntegralSelect(WeiXinIntegralSelectPo po);
	public void insertWieIntegralExchange(WeiXinIntegralSelectPo po,IntegralExchangePo integralExchangePo,List<IntegralExchangeEntryPo> integralExchangeEntryPolist,LogisticsLogPo logPo) ;
	/**
	 * 插入salesLog信息
	 * @param salesBasicPo
	 * @param salesLogPos
	 * @param logPo
	 */
	public void insertPayType(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist);
	/**
	 * 插入salesLog信息
	 * @param salesBasicPo
	 * @param salesLogPos
	 * @param logPo
	 */
	public void insertPayType2(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist);
	/**
	 * 插入salesLog信息
	 * @param salesBasicPo
	 * @param salesLogPos
	 * @param logPo
	 */
	public void insertPayType3(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist);
	
	/**
	 * 获取现金金额
	 * @param po
	 */
	public List<SalesLogPo> selectCash(SalesBasicPo po);
	
	/**
	 * 获取积分
	 * @param po
	 */
	public List<SalesLogPo> selectCredit(SalesBasicPo po);
	
	/**
	 * 获取银行卡
	 * @param po
	 */
	public List<SalesLogPo> selectBankCard(SalesBasicPo po);
	
	/**
	 * 获取储值卡
	 * @param po
	 */
	public List<SalesLogPo> selectPreCard(SalesBasicPo po);
	/**
	 * 获取代金券
	 * @param po
	 */
	public List<SalesLogPo> selectDjq(SalesBasicPo po);
	/**
	 * 获取其他
	 * @param po
	 */
	public List<SalesLogPo> selectQt(SalesBasicPo po);
	
	/**
	 * 传递配镜单和中心挂号
	 * @param po
	 */
	public void insertSalesData_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception;
	
	/**
	 * 传递配镜单
	 * @param po
	 */
	public void insertSalesGutiar_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception;
	
	/**
	 * 传递配镜单\中心挂号\重转石英
	 * @param po
	 */
	public void insertSalesDataAndQuartz_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception;
	
	/**
	 * 新增当天营业员收银员记录
	 */
	public void insertSalerCashierRecord(List<SalesDetailPo> detailPos,SalesBasicPo salesBasicPo,String valueof,String checkout,String withdrawflag,String opperson);
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public SalesBasicPo getSalesBasicsNoFinished(SalesBasicPo salesBasicPo) ;
	
	/**
	 * 只有待结款的单子才能调用
	 */	
	public CustomerInfoPo getCustmorInfoNoFinished(CustomerInfoPo customerInfoPo);
	
	/**
	 * 查看未结款的单子
	 */
	public List<SalesBasicPo> getSalesBasicNoFinished(SalesBasicPo salesBasicPo);
	
}