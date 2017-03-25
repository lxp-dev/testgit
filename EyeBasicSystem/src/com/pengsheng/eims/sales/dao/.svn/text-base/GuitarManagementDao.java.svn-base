package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangeEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogTempPo;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

/**
 * @author Liuqian
 * 
 */
public interface GuitarManagementDao {
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size);
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) ;
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po) ;
	public void updateWeiXinIntegralSelect(WeiXinIntegralSelectPo po);
	public void updateCustomerIntegrals(String openID,String integral);
	/**
	 * 根据配镜单号查询顾客信息
	 * 
	 * @param customerInfoPo
	 * @return
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo);
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelect(WeiXinIntegralSelectPo po);
	/**
	 * 得到打印镜单信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo);

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo);

	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChange(String salseid, String stockid);

	/**
	 * 更新销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo);

	/**
	 * 删除销售单
	 * 
	 * @param salesID
	 */
	public void deleteGuitarManagement(String salesID);

	/**
	 * 删除销售明细
	 * 
	 * @param salesID
	 */
	public void deleteGuitarManagementDetail(String salesID);

	/**
	 * 更新顾客积分
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateCustomerIntegral(String salesID);
	/**
	 * 根据销售单号将信息插入当月库存变更表中
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeLog(String salseid, String stockid);
	
	public void insertCustomize(SalesBasicPo salesBasicPo);
	
	/**
	 * 取得结款记录表Po
	 */
	public SalesLogPo getSalesLog(SalesLogPo salesLogPo);
	/**
	 * 销售日志插入
	 * @param salesLogPo
	 */
	public void insertSalesLog(SalesLogPo salesLogPo);
	
	/**
	 * 新增当天销售数据
	 * @param salesLogPo
	 */
	public void insertSalesBill(SalesBasicPo salesBasicPo);
	
	/**
	 * 新增当天销售数据明细
	 * @param salesLogPo
	 */
	public void insertSalesBillEntry(SalesBasicPo salesBasicPo);
	
	/**
	 * 更新顾客积分New
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateCustomerIntegralNew(String salesID,String integral,String count,String price,String fcustomerid);
	
	/**
	 * 更新顾客积分New
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateCustomerIntegralNew2(String salesID,String integral,String count,String price,String fcustomerid);
	
	/**
	 * 更新顾客积分New
	 * 
	 * @param customerid
	 * @param integral
	 */
	public CustomerInfoPo selCustomerIntegral(String salesID);
	
	/**
	 * 更新顾客积分New
	 * 
	 * @param customerid
	 * @param integral
	 */
	public void updateCustomerIntegralNew2(String salesID,String integral);
	
	public void updateCustomerIntegral(String memberid,String integral);
	
	public void insertIntegralExchange(IntegralExchangePo integralExchangePo);
	
	public void insertIntegralExchangeEntry(IntegralExchangeEntryPo integralExchangeEntryPo);
	
	/**
	 * New Sales change stroge
	 * 
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeLogNew(String salesid,String warehouseID);
	public void insertStrogeChangeLogNewNoZengPin(String salesid,String warehouseID);
	/**
	 * New Sales change stroge
	 * 
	 * @param strogeChangePo
	 */
	public List<StrogeChangePo> getStrogeChangeLogNewTemp(String salesid,String warehouseID);
	
	/**
	 * New Sales Change Storge
	 * 2012-12-13
	 * @param strogeChangePo
	 */
	public void insertStrogeChangeNew(String salesid,String warehouseID);
	public void insertStrogeChangeNewNoZengPin(String salesid,String warehouseID);
	
	public int getIntegralExchangeCount(IntegralExchangePo po);
	
	public List<IntegralExchangePo> getIntegralExchangeList(IntegralExchangePo po,int start, int size);
	
	public IntegralExchangePo getIntegralExchangeDetail(IntegralExchangePo po);
	
	public List<IntegralExchangeEntryPo> getIntegralExchangeDetailEntry(IntegralExchangePo po);
	
	/**
	 * 更新商品出入库标志
	 * @param salesid
	 * @param inOrout
	 * @param flag
	 */
	public void updateStrogeChangeFlag(String salesid,String inOrout,String flag);
	public void updateStrogeChangeUnFinishedFlag(String salesid,String inOrout,String flag);
	public void updateStrogeChangeUnFinishedFlagNoZengPin(String salesid,String inOrout,String flag,String jiekuanOrFaliao);
	public void updateStrogeChangeUnFinishedFlagZengPin(String salesid,String inOrout,String flag);
	
	/**
	 * 删除在途库存
	 * @param po
	 */
	public void deleteInTransitStroge(InTransitStorageEntryPo po);
	
	/**
	 * 新增在途库存
	 * @param po
	 */
	public void insertInTransitStroge(InTransitStorageEntryPo po);
	
	/**
	 * 查询结款或发料、退款后需要删除在途库存的商品
	 */
	public List<InTransitStorageEntryPo> getNotInTransitStorageGoods(String salesid,String inOrout,String flag);
	public List<InTransitStorageEntryPo> getNotInTransitStorageGoods(String salesid);
	
	/**
	 * 结款时判断配镜单是否存在
	 */
	public int getSalesBillCount(String salesID);
	
	/**
	 * 门店减少隐形订制片库存
	 * 
	 * @param strogeChangePo
	 */
	public void insertStealthIscustomerStrogeChange(String[] salseid);
	
	/**
	 * 门店减少隐形订制片库存
	 * 
	 * @param strogeChangePo
	 */
	public void insertStealthIscustomerStrogeLog(String[] salseid);
	
	
	/**
	 * 删除配镜单后,删除附加费
	 */
	public void deleteSalesBillAdditionalDetail(String salesID);
	
	/**
	 * 删除配镜单后,删除特殊加工要求
	 */
	public void deleteSalesBillProcessDetail(String salesID);
	
	/**
	 * 删除配镜单后,删除在途信息
	 */
	public void deleteSalesBillInTransitDetail(String salesID);	
	
	/**
	 * 更新实收金额
	 * @param po
	 */
	public void updateSalesValue(SalesBasicPo po);
	
	/**
	 * 得到更新结款方式信息
	 */
	public List<SalesBasicPo> getUpdatePayTypeSalesBasics(SalesBasicPo salesBasicPo);
	
	/**
	 * 取得结款记录表Po
	 */
	public List<SalesLogPo> getSalesLogs(SalesLogPo salesLogPo);
	
	public void updateReturnCustomerIntegral(String salesID,String integral);
	
	/**
	 * 删除日志
	 * @param salesLogPo
	 */
	public void deleteSalesLog(SalesLogPo salesLogPo);
	
	/**
	 * 删除付款方式
	 * @param salesLogPo
	 */
	public void deleteSalesCrossLog(SalesLogPo salesLogPo);
	
	/**
	 * 销售日志插入
	 * @param salesLogPo
	 */
	public void insertSalesLogForUpdatePaymentType(SalesLogPo salesLogPo);
	
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
	 * 判断配镜单是否只通过现金或银联卡结款   1：现金   2.银联卡
	 */
	public int getSalesBillPayMentForm(SalesBasicPo po,String flag);
	
	/**
	 * 判断配镜单中商品是否开票
	 */
	public int getSalesBillGoodsByInvoice(SalesBasicPo po);		
	
	/**
	 * 外帐新增会员
	 * @param salesLogPo
	 */
	public void insertFlysheetCustomer(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增配镜单信息
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBill(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增销售商品明细
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillEntry(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);	
	
	/**
	 * 外帐新增付款记录
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesLog(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增在途信息
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillInTransit(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增附加费
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesAdditionalCDetail(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增加工要求
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesSpecialPDetail(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增当日配镜单信息
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBill(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	
	/**
	 * 外帐新增当日销售商品明细
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillEntry(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);	
	
	/**
	 * 外帐新增当月库存
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentStorageChange(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增库存流水
	 * @param salesLogPo
	 */
	public void insertFlysheetStorageLog(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增当月库存(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentStorageChange_Withdraw(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增库存流水(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetStorageLog_Withdraw(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增配镜单信息(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBill_Withdraw(SalesBasicPo salesBasicPo);
	
	/**
	 * 外帐新增销售商品明细(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillEntry_Withdraw(SalesBasicPo salesBasicPo);
	
	/**
	 * 外帐新增付款记录(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesLog_Withdraw(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增在途信息(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetSalesBillInTransit_Withdraw(InTransitPo inTransitPo);
	
	/**
	 * 外帐新增当日配镜单信息(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBill_Withdraw(SalesBasicPo salesBasicPo);	
	
	/**
	 * 外帐新增当日销售商品明细(退)
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillEntry_Withdraw(SalesBasicPo salesBasicPo);	
	
	/**
	 * 外帐新增当日配镜单信息
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillWithdraw(SalesBasicPo salesBasicPo);	
	
	/**
	 * 外帐新增当日销售商品明细
	 * @param salesLogPo
	 */
	public void insertFlysheetCurrentSalesBillEntryWithdraw(SalesBasicPo salesBasicPo);	
	
	/**
	 * 查询外帐所需当日销售单
	 * @param salesLogPo
	 */
	public List<SalesBasicPo> getFlysheetSalesBillList(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 查询外帐所需当日销售单是否只用现金结款
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByXj(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询外帐所需当日销售单是否使用银联卡结款
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByBank(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 删除外帐所需当日销售单是否使用银联卡结款
	 * @param salesLogPo
	 */
	public void deleteFlysheetSalesBill(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);
	
	/**
	 * 查询外帐所需是否是当日销售单
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByCurrent(SalesBasicPo salesBasicPo);
	
	/**
	 * 外帐所需销售单是否退款
	 * @param salesLogPo
	 */
	public int getFlysheetSalesBillByWithdraw(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询外帐所需当日挂号费
	 * @param salesLogPo
	 */
	public List<RegisteredDetailsPo> getFlysheetRegistrationList(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo);
	
	/**
	 * 查询外帐所需当日挂号费是否只用现金结款
	 * @param salesLogPo
	 */
	public int getFlysheetRegistrationByXj(RegisteredDetailsPo rpo);
	
	/**
	 * 查询外帐所需当日挂号费是否使用银联卡结款
	 * @param salesLogPo
	 */
	public int getFlysheetRegistrationByBank(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo);
	
	/**
	 * 删除外帐所需当日挂号费
	 * @param salesLogPo
	 */
	public void deleteFlysheetRegistration(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增挂号类别
	 * @param salesLogPo
	 */
	public void insertFlysheetRegistrationType(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增挂号费
	 * @param salesLogPo
	 */
	public void insertFlysheetRegistration(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo);
	
	/**
	 * 外帐新增挂号费付款记录
	 * @param salesLogPo
	 */
	public void insertFlysheetRegistrationSalesLog(RegisteredDetailsPo rpo,ExternalAccountParameterPo epo);
	
	/**
	 * 更新基表套餐使用标记
	 * @param salesLogPo
	 */
	public void updateSalseBillSetMealFlag(SalesBasicPo salesBasicPo);
	
	/**
	 * 将附加费金额更新至基表
	 * @param salesLogPo
	 */
	public void updateSalseBillAdditionalCDetail(SalesBasicPo salesBasicPo);
	
	/**
	 * 将附加费内容以逗号分隔的形式存入基表
	 * @param salesLogPo
	 */
	public void updateSalseBillAdditionalDes(SalesBasicPo salesBasicPo);
	
	/**
	 * 将套餐名称以逗号分隔的形式存入基表
	 * @param salesLogPo
	 */
	public void updateSalseBillSetMealName(SalesBasicPo salesBasicPo);
	
	/**
	 * 更新结款方式表
	 * @param salesLogPo
	 */
	public void updateSalesCashForm(SalesLogPo slpo);
	
	/**
	 * 根据非现金结款类型的id查看所属类型
	 * @param salesLogPo
	 */
	public BankPo getNotCashTypeByID(String str);
	
	/**
	 * 更新汇总采购单据的标识位
	 * @param salesLogPo
	 */
	public void updateFlysheetCollectFlag(SalesBasicPo salesBasicPo,ExternalAccountParameterPo epo);	
	
	/**
	 * 重新执行外帐中的石英
	 * @param salesLogPo
	 */
	public void deleteReportQuartzLog(ModulePo tpo,ExternalAccountParameterPo epo);
	
	public void deleteCustomerIntegral(String salesID);
	
	/**
	 * 查看当前配镜单是否包含双自片
	 */
	public int getZZSupplierClassesBySalesBill(SalesBasicPo salesBasicPo);
	
	/**
	 * 新增营业员收银员记录
	 */
	public void insertSalerCashierRecord(SalesDetailPo sdpo);
	
	/**
	 * 新增营业员收银员记录(补齐)
	 */
	public void insertSalerCashierRecord_AppendArrears(SalesDetailPo sdpo);
	
	/**
	 * 根据配镜单号获取整单优惠金额
	 */
	public SalesBasicPo getDiscountpriceByID(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据配镜单号查看配镜单是否存在附加费
	 */
	public int getAdditionpriceCountByID(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据配镜单号获取整单附加费
	 */
	public SalesBasicPo getAdditionpriceByID(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据配镜单号获取门店和营业员、收银员
	 */
	public SalesBasicPo getSalesBasicInfoByID(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据配镜单号获取vip打折卡号
	 */
	public List<SalesDetailPo> getVipCardList(String salesID);
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public SalesBasicPo getSalesBasicsNoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 只有待结款的单子才能调用
	 */	
	public CustomerInfoPo getCustmorInfoNoFinished(CustomerInfoPo customerInfoPo);
	
	/**
	 * 查看未结款的单子
	 */
	public List<SalesBasicPo> getSalesBasicNoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据配镜单号获取当前配镜单的最新在途
	 * @param po
	 */
	public String getSalesBillInTransit(SalesBasicPo po);
	
	/**
	 * 删除在途库存
	 * @param po
	 */
	public void deleteInTransitStroge(SalesBasicPo po);
	
	public void insertSalesLog(List<SalesLogPo> slList);
	
	/**
	 * 更新商品出入库标志
	 * @param salesid
	 * @param inOrout
	 * @param flag
	 */
	public void updateStrogeChangeFlag(StrogeLogTempPo po);
	
	/**
	 * 更新结款方式表（横向）
	 * @param salesLogPo
	 */
	public void insertSalesCrossLogForUpdatePaymentType(SalesLogPo slpo);
	/**
	 * 删除HIS收费确认表
	 * @param salesID
	 */
	public void deleteSalesForHISBill(String salesID);
}
