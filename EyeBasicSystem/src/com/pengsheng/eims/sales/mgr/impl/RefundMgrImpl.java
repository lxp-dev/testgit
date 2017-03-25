/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.dao.GiftsDao;
import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.ArrearsDao;
import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.IntegralAddandSubDao;
import com.pengsheng.eims.sales.dao.RefundDao;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.mgr.CustomerTakeMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.mgr.RefundMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.dao.AllocationDao;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogTempPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinInviteFriendDao;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * @author
 * 
 */
public class RefundMgrImpl implements RefundMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private DepartmentsMgr departmentsMgr;	
	private GuitarManagementDao guitarManagementDao;	
	private GiftsDao giftsDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private AllocationDao allocationDao = null;
	private RefundDao refundDao;
	private WarehouseDao warehouseDao;
	private WarehouseConfigurationDao warehouseConfigurationDao = null;
	private SpectaclesMaterialsDao spectaclesMaterialsDao = null;
	private FrameSalesDao frameSalesDao;
	private WarehouseMgr warehouseMgr;
	private SetMealDao setMealDao;
	private StrogeChangeDao strogeChangeDao = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private GuitarManagementMgr guitarManagementMgr;
	private ArrearsDao arrearsDao;
	private CustomerTakeMgr customerTakeMgr;
	public DoorStoreDeliveryDao doorStoreDeliveryDao;
	private ChuzhikaDao chuzhikaDao;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();	
	private CashCouponDao cashCouponDao;
	private CustomerTakeDao customerTakeDao;
	private WeiXinInviteFriendDao weiXinInviteFriendDao;
	private ChuzhikaMgr chuzhikaMgr;
	private IntegralAddandSubDao integralAddandSubDao;
	
	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

	public IntegralAddandSubDao getIntegralAddandSubDao() {
		return integralAddandSubDao;
	}

	public void setIntegralAddandSubDao(IntegralAddandSubDao integralAddandSubDao) {
		this.integralAddandSubDao = integralAddandSubDao;
	}

	public WeiXinInviteFriendDao getWeiXinInviteFriendDao() {
		return weiXinInviteFriendDao;
	}

	public void setWeiXinInviteFriendDao(WeiXinInviteFriendDao weiXinInviteFriendDao) {
		this.weiXinInviteFriendDao = weiXinInviteFriendDao;
	}

	public CustomerTakeDao getCustomerTakeDao() {
		return customerTakeDao;
	}

	public void setCustomerTakeDao(CustomerTakeDao customerTakeDao) {
		this.customerTakeDao = customerTakeDao;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public CashCouponDao getCashCouponDao() {
		return cashCouponDao;
	}

	public void setCashCouponDao(CashCouponDao cashCouponDao) {
		this.cashCouponDao = cashCouponDao;
	}

	public ChuzhikaDao getChuzhikaDao() {
		return chuzhikaDao;
	}

	public void setChuzhikaDao(ChuzhikaDao chuzhikaDao) {
		this.chuzhikaDao = chuzhikaDao;
	}

	public DoorStoreDeliveryDao getDoorStoreDeliveryDao() {
		return doorStoreDeliveryDao;
	}

	public void setDoorStoreDeliveryDao(DoorStoreDeliveryDao doorStoreDeliveryDao) {
		this.doorStoreDeliveryDao = doorStoreDeliveryDao;
	}

	public CustomerTakeMgr getCustomerTakeMgr() {
		return customerTakeMgr;
	}

	public void setCustomerTakeMgr(CustomerTakeMgr customerTakeMgr) {
		this.customerTakeMgr = customerTakeMgr;
	}

	public ArrearsDao getArrearsDao() {
		return arrearsDao;
	}

	public void setArrearsDao(ArrearsDao arrearsDao) {
		this.arrearsDao = arrearsDao;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public SetMealDao getSetMealDao() {
		return setMealDao;
	}

	public void setSetMealDao(SetMealDao setMealDao) {
		this.setMealDao = setMealDao;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public FrameSalesDao getFrameSalesDao() {
		return frameSalesDao;
	}

	public void setFrameSalesDao(FrameSalesDao frameSalesDao) {
		this.frameSalesDao = frameSalesDao;
	}

	public SpectaclesMaterialsDao getSpectaclesMaterialsDao() {
		return spectaclesMaterialsDao;
	}

	public void setSpectaclesMaterialsDao(
			SpectaclesMaterialsDao spectaclesMaterialsDao) {
		this.spectaclesMaterialsDao = spectaclesMaterialsDao;
	}

	public WarehouseConfigurationDao getWarehouseConfigurationDao() {
		return warehouseConfigurationDao;
	}

	public void setWarehouseConfigurationDao(
			WarehouseConfigurationDao warehouseConfigurationDao) {
		this.warehouseConfigurationDao = warehouseConfigurationDao;
	}

	public AllocationDao getAllocationDao() {
		return allocationDao;
	}

	public void setAllocationDao(AllocationDao allocationDao) {
		this.allocationDao = allocationDao;
	}

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public GiftsDao getGiftsDao() {
		return giftsDao;
	}

	public void setGiftsDao(GiftsDao giftsDao) {
		this.giftsDao = giftsDao;
	}

	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public RefundDao getRefundDao() {
		return refundDao;
	}

	public void setRefundDao(RefundDao refundDao) {
		this.refundDao = refundDao;
	}

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}


	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo) {
		return refundDao.getSalesBasics(salesBasicPo);
	}
	
	/**
	 * 得到打印配镜单数量
	 */
	public int getSalesBasicsCount(SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo) {
		return refundDao.getSalesBasicsCount(salesBasicPo,systemParameterPo);
	}

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> getSalesBasics(
			SalesBasicPo salesBasicPo,SystemParameterPo systemParameterPo, int start, int size) {
		return refundDao.getSalesBasics(salesBasicPo,systemParameterPo, start, size);
	}


	public void insertSalesGutiar(SalesBasicPo salesBasicPo,InTransitPo inTransitPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo, WeixinInviteFriendLogPo weixinInviteFriendLogPo, SystemParameterPo systemParameterPo) {
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		
		// 顾客取镜
		SalesBasicPo tpo = inTransitDetailsMgr.getCustomerInfo(salesBasicPo);
		if(Utility.getName(tpo.getSsesbintransit()).equals("12")){
			customerTakeMgr.insertCustomerTake(inTransitPo, salesBasicPo,null,null,null,null,null,systemParameterPo);
		}
		
		guitarManagementMgr.insertPayType2(salesBasicPo,salesLogPos,czklist,djqlist);
		
		// 冲订金
		SalesBasicPo spo = refundDao.getSalesBasicPo(salesBasicPo.getSsesbsalesid());
		if (Utility.getName(spo.getSsesbcheckoutflag()).equals("1")){
			arrearsDao.insertCustomizeTui(salesBasicPo.getSsesbsalesid());
			refundDao.updateArrearsAppendDate(salesBasicPo.getSsesbsalesid());			
		}
		//折扣卡加1
		List<SalesDetailPo> vipcardlist=guitarManagementDao.getVipCardList(salesBasicPo.getSsesbsalesid());
        for(SalesDetailPo vipcardPo:vipcardlist){
        	frameSalesDao.updateVipCardSub(vipcardPo.getSsesdvipcard());
        }


		// 更新销售在途点，银台结款状态
		refundDao.updateMaterialsInTransit(salesBasicPo);

		// 插入在途点
		refundDao.insertIntrnsitInfo(inTransitPo);
		
		//积分
		SalesBasicPo salesBasicPo2 = inTransitDetailsMgr.getCustomerInfo(salesBasicPo);
		
		SalesBasicPo fspo = new SalesBasicPo();
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			CustomerInfoPo tfcpo = new CustomerInfoPo();
			tfcpo.setSmecicustomerid(salesBasicPo2.getSsesbfcustomerid());
			CustomerInfoPo fcpo = frameSalesDao.getCustomerInfo(tfcpo);
			
			SalesBasicPo tfspo = new SalesBasicPo();
			tfspo.setSsesbcustomerid(fcpo.getSmecicustomerid());
			fspo = inTransitDetailsMgr.getCustomerInfo(tfspo);
			fspo.setSsesbsalesid(salesBasicPo2.getSsesbsalesid());
		}else{
			fspo = salesBasicPo2;
		}
		weixinInviteFriendLogPo.setWiflisconfirm("1");
		weixinInviteFriendLogPo.setWifltousername(salesBasicPo2.getSsesbpersonName());
		weixinInviteFriendLogPo.setWifltouserphone(salesBasicPo2.getSsesbphone());

		WeixinInviteFriendLogPo weixinpo = weiXinInviteFriendDao.selectWeiXinInviteFriendLogCheck(weixinInviteFriendLogPo);
		SalesBasicPo weixinfspo = inTransitDetailsDao.getCustomerInfo2(weixinpo.getWiflcustomerid());
		
		if("0".equals(salesBasicPo.getSsesbcheckoutflag())){
			IntegralAddandSubPo addandSubPo=new IntegralAddandSubPo();
			addandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());
			addandSubPo.setSmeascustomerid(tpo.getSsesbcustomerid());
			IntegralAddandSubPo integralAddandSubPo=refundDao.getIntegralAddandSub(addandSubPo);
			BigDecimal jftotal = new BigDecimal(Utility.getName(integralAddandSubPo.getSmeascintegral()).equals("") ? "0" : Utility.getName(integralAddandSubPo.getSmeascintegral()));
	
			fspo.setNowintegral(jftotal.toString());   // 本次变更积分（退商品累计积分）
			BigDecimal jftotal2 = new BigDecimal(fspo.getInintrgral());  //会员原有积分
			fspo.setSsesbintegral(jftotal2.subtract(jftotal).toString());  //会员现有积分
			salesBasicPo.setNowintegral(jftotal.toString());
			if(!Utility.getName(salesBasicPo2.getSsesbfcustomerid()).equals("")){
				salesBasicPo.setSsesbfcustomerid(salesBasicPo2.getSsesbfcustomerid());
				salesBasicPo.setSsesbcustomerid(salesBasicPo2.getSsesbcustomerid());
				fspo.setSsesbfcustomerid(salesBasicPo2.getSsesbcustomerid());
			}
			
			refundDao.updateIntegralAddandSub(fspo);
			refundDao.updateCustomerIntegral(salesBasicPo);
			
			if(!"".equals(Utility.getName(weixinInviteFriendLogPo.getWifltousername()))){
				if("1".equals(weixinpo.getWiflisconfirm())){
					ChuzhikaPo chuzhikaPo= chuzhikaMgr.selectChuzhikaJifenByCustomerID(weixinpo.getWiflcustomerid());
					if(!"".equals(Utility.getName(chuzhikaPo.getCstczkid()))){
						SalesBasicPo wsalesBasicPo = salesBasicPo;
						ChuzhikaLogPo wlpo=new ChuzhikaLogPo();
						wlpo.setSmeassalesbillid(wsalesBasicPo.getSsesbsalesid());
						wlpo.setSmeascustomerid(weixinfspo.getSsesbcustomerid());
						
						ChuzhikaLogPo lpo = chuzhikaDao.selectChuzhikaLogsPoByCustomerIDAndSalesBillID(wlpo);
						
						String CIntegral = lpo.getSmeascintegral();
						LogisticsLogPo czhlogPo = new LogisticsLogPo();
						czhlogPo.setsLogName(salesBasicPo.getSsesbposid());
						czhlogPo.setsLogIP(logPo.getsLogIP());
						czhlogPo.setsLogResult(logPo.getsLogResult()); // 模块ID
						czhlogPo.setsLogOpID("1");    // 1 新增
						czhlogPo.setsLogContent("储值卡"+chuzhikaPo.getCstczkcardid()+"微信退款："+"-"+CIntegral);
						
						ChuzhikaLogPo czkpo = new ChuzhikaLogPo();
						czkpo.setSmeascustomerid(weixinfspo.getSsesbcustomerid());
						czkpo.setSmeaschuzhikaid(chuzhikaPo.getCstczkid());
						czkpo.setSmeasshifu("0.00");
						czkpo.setSmeaszengsong("-"+CIntegral);
						czkpo.setSmeascintegral("-"+CIntegral);
						czkpo.setSmeasxintegral("-"+CIntegral);
						czkpo.setSmeasdopersonid(salesBasicPo.getSsesbwithdrawpersonid());
						czkpo.setSmeasremark("微信邀请人退款");
						czkpo.setSmeasaddorsub("1");
						czkpo.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
						czkpo.setSmeasmemberid(weixinfspo.getSsesbMemberId());
						chuzhikaMgr.updateChuzhikaChongzhi(czkpo, czhlogPo);
					}else{
						SalesBasicPo wsalesBasicPo = salesBasicPo;
						IntegralAddandSubPo waddandSubPo=new IntegralAddandSubPo();
						waddandSubPo.setSmeassalesbill(wsalesBasicPo.getSsesbsalesid());
						waddandSubPo.setSmeascustomerid(weixinfspo.getSsesbcustomerid());
						
						IntegralAddandSubPo wintegralAddandSubPo=refundDao.getIntegralAddandSub(waddandSubPo);
						BigDecimal wjftotal = new BigDecimal(Utility.getName(wintegralAddandSubPo.getSmeascintegral()).equals("") ? "0" : Utility.getName(wintegralAddandSubPo.getSmeascintegral()));
				
						weixinfspo.setNowintegral(wjftotal.toString());   // 本次变更积分（退商品累计积分）
						BigDecimal wjftotal2 = new BigDecimal(weixinfspo.getInintrgral());  //会员原有积分
						weixinfspo.setSsesbintegral(wjftotal2.subtract(wjftotal).toString());  //会员现有积分
						wsalesBasicPo.setNowintegral(wjftotal.toString());
						wsalesBasicPo.setSsesbfcustomerid(weixinfspo.getSsesbcustomerid());
						wsalesBasicPo.setSsesbweixintype("1");
						
						weixinfspo.setSsesbwithdrawpersonid(salesBasicPo.getSsesbwithdrawpersonid());
						weixinfspo.setSsesbsalesid(salesBasicPo.getSsesbsalesid());
						weixinfspo.setSsesbweixintype("1");
						
						refundDao.updateIntegralAddandSub(weixinfspo);
						refundDao.updateCustomerIntegral(wsalesBasicPo);
					}
				}
			}
		}
		
		
		
		//储值卡流水
		if (czklist != null && czklist.size() != 0){
			for (ChuzhikaPo czkpo:czklist){
				BigDecimal bgc1 = new BigDecimal(czkpo.getCstczkjine());
				BigDecimal bgc2 = new BigDecimal(czkpo.getCstczkchongzhijine());
				BigDecimal bgc3=new BigDecimal("-1");
				ChuzhikaLogPo po=new ChuzhikaLogPo();
				po.setSmeasmemberid(salesBasicPo2.getSsesbMemberId());
				po.setSmeascustomerid(salesBasicPo2.getSsesbcustomerid());
				po.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				po.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
				po.setSmeaschuzhikaid(czkpo.getCstczkid());
				po.setSmeascintegral(bgc2.multiply(bgc3).toString());
				po.setSmeasxintegral(czkpo.getCstczkjine());
				po.setSmeasyintegral((bgc1.add(bgc2)).toString());	
				po.setSmeasaddorsub("4");	
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState2(couponPo);
			}
		}

		// 门店库存
		List<StrogeLogTempPo> strogeLogPoList = new ArrayList<StrogeLogTempPo>();
		strogeLogPoList = refundDao.getSalesDetailList(salesBasicPo.getSsesbsalesid(), "");

		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(salesBasicPo.getSsesbdepartmentid());
		WarehouseConfigurationPo warehouseConfigurationPo = departmentsMgr.getInWarehouseByDpt(tempWarehouseConfigurationPo);

		for(int i=0; i < strogeLogPoList.size(); i++){
			String goodstype = strogeLogPoList.get(i).getCshslgoodsid().substring(0, 1);
			if("1".equals(strogeLogPoList.get(i).getCshsllargessflag())){
				strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid10());//赠品出仓
			}else{
				if("1".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid1());//镜架出仓
				}else if("2".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid2());//配件出仓
				}else if("3".equals(goodstype)){
					if("D".equals(strogeLogPoList.get(i).getCshslisCustomize())){
						strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid4());//成品订制镜片出仓
					}else{
						strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid3());//成品镜片出仓
					}
				}else if("4".equals(goodstype)){
					if("D".equals(strogeLogPoList.get(i).getCshslisCustomize())){
						strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid6());//隐形订制镜片出仓
					}else{
						strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid5());//隐形镜片出仓
					}
				}else if("5".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid7());//隐形护理液出仓
				}else if("6".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid8());//太阳镜
				}else if("7".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid9());//耗材
				}else if("8".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid11());//老花镜
				}else if("9".equals(goodstype)){
					strogeLogPoList.get(i).setCshslstockid(warehouseConfigurationPo.getBwcstockid12());//视光
				}
			}
		}
			
		//查询门店仓位
		DepartmentsPo departmentPo = new DepartmentsPo();
		departmentPo.setBdpdepartmentid(salesBasicPo2.getSsesbshopcode());
		WarehousePo wpo = warehouseDao.getWarehousePo(departmentPo);
		
		boolean flag = false;	
		if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") && !Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0")){
			flag = true;
		}
		
		for (StrogeLogTempPo strogeLogPo : strogeLogPoList) {
			if(strogeLogPo.getCshsloutstorageflag().equals("1")){
				//更新退款仓位
				refundDao.updateInWarehouse(strogeLogPo);
				
				if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
					// 门店仓增加商品库存,所有商品先退款到门店
					if (!Utility.getName(wpo.getBwhid()).equals("")){   //所有商品先退款到门店
						strogeLogPo.setCshslstockid(Utility.getName(wpo.getBwhid()));
					}	
				}	
			
				refundDao.insertStrogeChanges(strogeLogPo);
				strogeLogPo.setCshsllargessflag("1"); //配镜单退款标志
				
	            if (flag == true && ("4".equals(Utility.getName(strogeLogPo.getCshslgoodsid()).substring(0,1)) || "5".equals(Utility.getName(strogeLogPo.getCshslgoodsid()).substring(0,1)))){
	    			GoodsInfoPo po = strogeChangeDao.getGoodsBatch(strogeLogPo.getCshslgoodsbarcode());
	    			strogeLogPo.setCshslguaranteeperiod(Utility.getName(po.getGuaranteeperiod()));
	    			strogeLogPo.setCshslbatch(Utility.getName(po.getBatch()));            	
	            }
				
				refundDao.insertStrogeLogs(strogeLogPo);
				
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(strogeLogPo.getCshslgoodsid());
				changePo.setCshscgoodsbarcode(strogeLogPo.getCshslgoodsbarcode());
				changePo.setCshscstockid(strogeLogPo.getCshslstockid());
				changePo.setCshsccostprice(strogeLogPo.getCshslcostprice());
				changePo.setCshscnottaxrate(strogeLogPo.getCshslnottaxrate());
				changePo.setCshscchangeid(strogeLogPo.getCshslchangeid());
				changePo.setCshscgoodsquantity(strogeLogPo.getCshslgoodsquantity());
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(changePo.getCshscgoodsbarcode()));// 商品库存当月库存变更表(9张新表)
				
				//更新商品出库状态     in:退款   out:结款       1：出(入)库    0：未出(入)库
				guitarManagementDao.updateStrogeChangeFlag(strogeLogPo);
			}
		}
		
		int count = refundDao.materialsTodayCount(salesBasicPo);
		if (count > 0){
			// 更新当日销售在途点，银台结款状态
			refundDao.updateMaterialsInTransitToday(salesBasicPo); 
			
			//更新退款仓位
			refundDao.deleteMmaterialsToday(salesBasicPo);
			guitarManagementDao.insertSalesBillEntry(salesBasicPo);
		}else{
			//新增当天销售数据
			guitarManagementDao.insertSalesBill(salesBasicPo);
			guitarManagementDao.insertSalesBillEntry(salesBasicPo);
		}
		
		//查询退款商品
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesBasicPo.getSsesbsalesid());		
		List<SalesDetailPo> salesDetailPos = inTransitDetailsDao.getReturnGoodsInfo(salesDetailPo);
		
		//自动调拨,通过调拨，退款仓位增加商品库存,门店仓位减少库存
		if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
			autoAllocationFromStore(salesDetailPos,salesBasicPo.getSsesbsalesid(),inTransitPo,wpo,salesBasicPo,warehouseConfigurationPo);
		}		
		
		//删除在途库存
		InTransitStorageEntryPo ipo = new InTransitStorageEntryPo();
		ipo.setCshtsebillid(salesBasicPo.getSsesbsalesid());
		guitarManagementDao.deleteInTransitStroge(ipo);
		
		// 新增付款记录（横向）
		SalesLogPo slpo = new SalesLogPo();
		slpo.setSsesluuid(uuid.generate());
		slpo.setSsesltype("1"); // 配镜类型
		
		BankPo bpo = new BankPo();
		BigDecimal cashbg = new BigDecimal(0);
		BigDecimal petcardbg = new BigDecimal(0);
		BigDecimal bankcardbg = new BigDecimal(0);
		BigDecimal chitbg = new BigDecimal(0);		
		BigDecimal notcashbg = new BigDecimal(0);
		BigDecimal integralbg = new BigDecimal(0);
		
		for(int i=0; i<salesLogPos.size(); i++){
			if(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice())) > 0){
				
				slpo.setSseslsalesid(Utility.getName(salesLogPos.get(i).getSseslsalesid()));
				slpo.setSseslperson(Utility.getName(salesLogPos.get(i).getSseslperson()));
				slpo.setSseslshopcode(Utility.getName(salesLogPos.get(i).getSseslshopcode()));
				slpo.setSseslpaymenttype(Utility.getName(salesLogPos.get(i).getSseslpaymenttype()));
				
				if (Utility.getName(salesLogPos.get(i).getSseslconsumptionid()).equals("1")){  // 现金
					cashbg = cashbg.add(new BigDecimal(Utility.getName(salesLogPos.get(i).getSseslprice()))); 
				}
				if (Utility.getName(salesLogPos.get(i).getSseslconsumptionid()).equals("4")){  // 储值卡
					petcardbg = petcardbg.add(new BigDecimal(Utility.getName(salesLogPos.get(i).getSseslprice()))); 
				}
				if (Utility.getName(salesLogPos.get(i).getSseslconsumptionid()).equals("3")){	//银行卡
					
					bankcardbg = bankcardbg.add(new BigDecimal(Utility.getName(salesLogPos.get(i).getSseslprice()))); 					
				}
				if (Utility.getName(salesLogPos.get(i).getSseslconsumptionid()).equals("2")){     // 积分抵扣
					integralbg = integralbg.add(new BigDecimal(Utility.getName(salesLogPos.get(i).getSseslintegralprice()))); 
				}
				if (Utility.getName(salesLogPos.get(i).getSseslconsumptionid()).equals("6")){     // 其他
					notcashbg = notcashbg.add(new BigDecimal(Utility.getName(salesLogPos.get(i).getSseslprice()))); 
				}
				if (Utility.getName(salesLogPos.get(i).getSseslconsumptionid()).equals("7")){     // 代金券
					chitbg = chitbg.add(new BigDecimal(Utility.getName(salesLogPos.get(i).getSseslprice())));
				}
				
			}
		}
		
		slpo.setSseslcashprice(cashbg.toString());   // 现金
		slpo.setSseslpetcardprice(petcardbg.toString());  // 储值卡
		slpo.setSseslbankcardprice(bankcardbg.toString());  // 银行卡
		slpo.setSseslchitprice(chitbg.toString());   // 代金券
		slpo.setSseslnotcashprice(notcashbg.toString());    // 非现金
		slpo.setSseslintegralprice(integralbg.toString());     // 积分抵扣
		
		guitarManagementDao.updateSalesCashForm(slpo);		
		
		//新增当天营业员收银员记录
		SalesDetailPo detailPo = new SalesDetailPo();
		detailPo.setSsesdsalesid(salesBasicPo.getSsesbsalesid());		
		List<SalesDetailPo> detailPos = inTransitDetailsDao.getGoodsInfo(detailPo);
		
		guitarManagementMgr.insertSalerCashierRecord(detailPos,salesBasicPo,"1","0","1",salesBasicPo.getSsesbwithdrawpersonid());
		
		// 将配镜单送至已完结的表中
		if (Utility.getName(systemParameterPo.getFspsplitsalesdataflag()).equals("1")){			
			customerTakeDao.insertSalesBasicFinished(salesBasicPo.getSsesbsalesid());
			customerTakeDao.insertSalesDetailFinished(salesBasicPo.getSsesbsalesid());
			customerTakeDao.deleteSalesBasic(salesBasicPo.getSsesbsalesid());
			customerTakeDao.deleteSalesDetail(salesBasicPo.getSsesbsalesid());
		}
	}
	
	/**
	 * 部分商品退款
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public String insertPartSalesGutiar(SalesBasicPo salesBasicPo,InTransitPo inTransitPo,PersonInfoPo personInfoPo,List<SalesDetailPo> salesDetailList,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo){
		WeixinInviteFriendLogPo weixinInviteFriendLogPo = new WeixinInviteFriendLogPo();
		SystemParameterPo systemParameterPo = new SystemParameterPo();
		this.insertSalesGutiar(salesBasicPo,inTransitPo,salesLogPos,czklist,djqlist,logPo,weixinInviteFriendLogPo,systemParameterPo);
		
		//更新退款商品和当日销售数据中
		String orderstypecheck = "1";
		for (SalesDetailPo po : salesDetailList){
			refundDao.updateSalesDetailGoodsWithdrawFlag(po);
			refundDao.updateSalesDetailGoodsWithdrawFlagToday(po);
			if(("3".equals(po.getSsesdcommoditiesflag()) || "4".equals(po.getSsesdcommoditiesflag())) && "1".equals(orderstypecheck)){
				orderstypecheck = "";
			}
		}
		
		String ordertype = "";
		if("1".equals(orderstypecheck)){
			ordertype = salesBasicPo.getSsesborderstype();
		}else{
			ordertype = "5";
		}
		
		//利用未退款的商品创建新的配镜单号
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salseID = "X" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		salesBasicPo.setSsesbsourcesalesid(Utility.getName(salesBasicPo.getSsesbsalesid()));
		salesBasicPo.setSsesbswapgoodsflag("2");
		salesBasicPo.setSsesbsalesid(salseID);
		salesBasicPo.setSsesborderstype(ordertype);
		
		refundDao.insertPartSalesGoodsWithdrawBill(salesBasicPo);
		refundDao.insertPartSalesGoodsWithdrawBillEntry(salesBasicPo);
		refundDao.insertPartSalesGoodsWithdrawAdditional(salesBasicPo);
		refundDao.insertPartSalesGoodsWithdrawBillSpecialPDetail(salesBasicPo);
		
		//更新新配镜单金额：原价合计、应收金额、实收合计、折扣金额、优惠金额
		SalesDetailPo tpo = refundDao.getPartSalesGoodsNotWithdrawAmountEntry(salesBasicPo);
		
		salesBasicPo.setSsesbpricesum(Utility.getName(tpo.getSsesdpricesum()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdpricesum()));
		salesBasicPo.setSsesbsalesvalue(Utility.getName(tpo.getSsesdsalesvalue()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdsalesvalue()));
		salesBasicPo.setSsesbrenums(Utility.getName(tpo.getSsesdrenum()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdrenum()));
		salesBasicPo.setSsesbdiscountnum(Utility.getName(tpo.getSsesddiscountnum()).equals("") ? "0.00" : Utility.getName(tpo.getSsesddiscountnum()));
		salesBasicPo.setSsesbcheckoutflag("0");
		salesBasicPo.setSsesbpsalsvalue(salesBasicPo.getSsesbsalesvalue());
		
		refundDao.updatePartSalesGoodsWithdrawBillAmount(salesBasicPo);
		
		//在途库存
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("mdxs");  // mdxs 表示门店销售
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			//新增在途库存的商品
			List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesBasicPo.getSsesbsalesid(),"out","0");
			if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
				for (InTransitStorageEntryPo po : inTransitStorageEntryList){
					po.setCshtsemoduleid("mdxs");
					guitarManagementDao.insertInTransitStroge(po);
				}
			}
		}
		
		//新增在途
		inTransitPo.setSseitsalesid(salseID);
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("1");
		
		refundDao.insertIntrnsitInfo(inTransitPo);
		
		return salseID;
	}
	
	/**
	 * 部分商品换货
	 * 
	 * @param salesBasicPo
	 * @param inTransitPo
	 */
	public String insertPartSwapGoodsSalesGutiar(SalesBasicPo salesBasicPo,InTransitPo inTransitPo,PersonInfoPo personInfoPo,List<SalesDetailPo> salesDetailList,SalesDetailPo salesDetailPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo){
		
		WeixinInviteFriendLogPo weixinInviteFriendLogPo = new WeixinInviteFriendLogPo();
		SystemParameterPo systemParameterPo = new SystemParameterPo();

		//整单退款
		this.insertSalesGutiar(salesBasicPo,inTransitPo,salesLogPos,czklist,djqlist,logPo,weixinInviteFriendLogPo,systemParameterPo);
		
		//更新退款商品和当日销售数据中
		for (SalesDetailPo po : salesDetailList){
			refundDao.updateSalesDetailGoodsWithdrawFlag(po);
			refundDao.updateSalesDetailGoodsWithdrawFlagToday(po);
		}
		
		//利用未退款的商品创建新的配镜单号
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String salseID = "X" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		salesBasicPo.setSsesbsourcesalesid(Utility.getName(salesBasicPo.getSsesbsalesid()));
		salesBasicPo.setSsesbswapgoodsflag("3");
		salesBasicPo.setSsesbsalesid(salseID);
		
		refundDao.insertPartSalesGoodsWithdrawBill(salesBasicPo);		
		refundDao.insertPartSalesGoodsWithdrawBillEntry(salesBasicPo);
		//处理会员卡
		CustomerInfoPo customerInfoPo=frameSalesDao.getMemberType(salesBasicPo.getSsesbcustomerid());

		for(int i=1;i<salesDetailPo.getSsesdsalesitemids().length;i++){
			SalesDetailPo temp= new SalesDetailPo();
			
			temp.setSsesdsalesid(salseID);
			temp.setSsesdsalesitemid(salesDetailPo.getSsesdsalesitemids()[i]);
			temp.setSsesditemid(salesDetailPo.getSsesditemids()[i]);
			temp.setSsesdstockid(salesDetailPo.getSsesdstockids()[i]);
			temp.setSsesdsalesitemname(salesDetailPo.getSsesdsalesitemnames()[i]);
			temp.setSsesdsprice(salesDetailPo.getSsesdsprices()[i]);
			temp.setSsesdnumber(salesDetailPo.getSsesdnumbers()[i]);
			temp.setSsesdunitprice(salesDetailPo.getSsesdunitprices()[i]);
			temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdcostsprive(salesDetailPo.getSsesdcostsprives()[i]);
			temp.setSsesdsalesvalue(salesDetailPo.getSsesdsalesvalues()[i]);
			if("".equals(Utility.getName(salesDetailPo.getSsesddiscountrates()[i]))){
				temp.setSsesddiscountrate("1.00");
			}else{
				temp.setSsesddiscountrate(salesDetailPo.getSsesddiscountrates()[i]);
			}
			temp.setSsesddiscountnum(salesDetailPo.getSsesddiscountnums()[i]);
			temp.setSsesdgooddescribe(salesDetailPo.getSsesdgooddescribes()[i]);
			temp.setSsesdglassflag(salesDetailPo.getSsesdglassflags()[i]);
			temp.setSsesdcommoditiesflag(salesDetailPo.getSsesdcommoditiesflags()[i]);
			temp.setSsesdlargessflag("0");
			temp.setSsesdysvalue(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdrenum(salesDetailPo.getSsesdrenums()[i]);
			temp.setSsesddiscounttype(salesDetailPo.getSsesddiscounttypes()[i]);
			temp.setSsesddiscountsource(salesDetailPo.getSsesddiscountsources()[i]);
			temp.setSsesdfavorable(salesDetailPo.getSsesdfavorables()[i]);
			
			if("2".equals(Utility.getName(salesBasicPo.getSsesbisgiveyouintegral()))){
				temp.setSsesintegral("0");
			}else{
				
				IntegralPo ipo = setMealDao.getIntegralCountList2(salesDetailPo.getSsesdsalesitemids()[i],salesBasicPo.getSsesbshopcode(),customerInfoPo.getSmecicardtype());
				temp.setSsesintegral(Utility.getName(ipo.getFirIntegralCount()));
			}
			
			temp.setSsesdguaranteeperiod(salesDetailPo.getSsesdguaranteeperiods()[i]);
			temp.setSsesdbatch(salesDetailPo.getSsesdbatchs()[i]);
			temp.setSsesdexchageflag("1");
			
			frameSalesDao.insertSalesDetail(temp);
		}
		
		refundDao.insertPartSalesGoodsWithdrawAdditional(salesBasicPo);
		refundDao.insertPartSalesGoodsWithdrawBillSpecialPDetail(salesBasicPo);
		
		//更新新配镜单金额：原价合计、应收金额、实收合计、折扣金额、优惠金额
		SalesDetailPo tpo = refundDao.getPartSalesGoodsNotWithdrawAmountEntry(salesBasicPo);
				
		BigDecimal bg2 = new BigDecimal(salesBasicPo.getSsesbpsalsvalue());
		
		salesBasicPo.setSsesbpricesum(Utility.getName(tpo.getSsesdpricesum()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdpricesum()));
		salesBasicPo.setSsesbsalesvalue(Utility.getName(tpo.getSsesdsalesvalue()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdsalesvalue()));
		salesBasicPo.setSsesbpsalsvalue(Utility.getName(tpo.getSsesdsalesvalue()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdsalesvalue()));
		salesBasicPo.setSsesbrenums(Utility.getName(tpo.getSsesdrenum()).equals("") ? "0.00" : Utility.getName(tpo.getSsesdrenum()));
		salesBasicPo.setSsesbdiscountnum(Utility.getName(tpo.getSsesddiscountnum()).equals("") ? "0.00" : Utility.getName(tpo.getSsesddiscountnum()));
				
		BigDecimal bg1 = new BigDecimal(salesBasicPo.getSsesbsalesvalue());
		if (bg1.subtract(bg2).intValue() > 0){
			salesBasicPo.setSsesbcheckoutflag("1");
			salesBasicPo.setSsesbpsalsvalue(bg2.toString());
		}else{
			salesBasicPo.setSsesbcheckoutflag("0");
		}
		refundDao.updatePartSalesGoodsWithdrawBillAmount(salesBasicPo);
		
		//在途库存
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("mdxs");  // mdxs 表示门店销售
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			//新增在途库存的商品
			List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesBasicPo.getSsesbsalesid(),"out","0");
			if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
				for (InTransitStorageEntryPo po : inTransitStorageEntryList){
					po.setCshtsemoduleid("mdxs");
					guitarManagementDao.insertInTransitStroge(po);
				}
			}
		}
		
		//新增在途
		inTransitPo.setSseitsalesid(salseID);
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("1");
		
		refundDao.insertIntrnsitInfo(inTransitPo);
		
		return salseID;
	}

	/**
	 * 自动调拨（从门店仓位到门店退款仓位）
	 */
	private void autoAllocationFromStore(List<SalesDetailPo> salesDetailList,String billID,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo,WarehouseConfigurationPo cpo){
			
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		List<String> stockList = new ArrayList<String>();              //退款仓位的集合
		String secondStock = "";             //当前商品的退款仓位
		String tbillid = "";                 //调拨单号
		
		boolean flag = false;
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") && !Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0")){
			flag = true;
		}
		
		if (Utility.getName(wpo.getBwhid()).equals("")){
			return;
		}
		
		for (SalesDetailPo po : salesDetailList){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));
			
			if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(po.getSsesdinstockid())) || Utility.getName(po.getSsesdinstockid()).equals("")){
				continue;
			}
			
			if (Utility.getName(po.getSsesdlargessflag()).equals("1")){
				secondStock = Utility.getName(cpo.getBwcstockid10());
			}else{
				int goodsCategoryid = 0;
				if (!Utility.getName(goodsInfoPo.getBgigoodscategoryid()).equals("")){
					goodsCategoryid = Integer.valueOf(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
				}
				
				switch(goodsCategoryid){
					case 3 :
						if (Utility.getName(goodsInfoPo.getBgiiscustomize()).equals("0")){  // 成品片
							secondStock = Utility.getName(cpo.getBwcstockid3());					
						}
						if (Utility.getName(goodsInfoPo.getBgiiscustomize()).equals("D")){  // 订制片
							secondStock = Utility.getName(cpo.getBwcstockid4());
						}
						break;
					case 4 :
						if (Utility.getName(goodsInfoPo.getBgiiscustomize()).equals("0")){  // 成品片
							secondStock = Utility.getName(cpo.getBwcstockid5());					
						}
						if (Utility.getName(goodsInfoPo.getBgiiscustomize()).equals("D")){  // 订制片
							secondStock = Utility.getName(cpo.getBwcstockid6());
						}
						break; 
					case 1 :
						secondStock = Utility.getName(cpo.getBwcstockid1());
						break; 
					case 2 :
						secondStock = Utility.getName(cpo.getBwcstockid2());
						break; 
					case 5 :
						secondStock = Utility.getName(cpo.getBwcstockid7());
						break; 
					case 6 :
						secondStock = Utility.getName(cpo.getBwcstockid8());
						break; 
					case 7 :
						secondStock = Utility.getName(cpo.getBwcstockid9());
						break; 
					case 8 :
						secondStock = Utility.getName(cpo.getBwcstockid11());
						break; 
					case 9 :
						secondStock = Utility.getName(cpo.getBwcstockid12());
						break; 
			    }
			}
			
			if (!stockList.contains(secondStock) && !goodsInfoPo.getBgisupplierid().equals("ZZ")){
				
				tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();
				
				InventoryPo inventoryPo=new InventoryPo();
				inventoryPo.setCstioutstockid(Utility.getName(wpo.getBwhid())); //门店仓
				inventoryPo.setCstibillid(tbillid);
				inventoryPo.setCstibilltypeid("4");
				inventoryPo.setCstiinstockid(secondStock);		//退款仓位配置的仓位	
				inventoryPo.setCstidepartmentid(inTransitPo.getSseitdepartment());  //退款部门
				inventoryPo.setCsticreateperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstiauditperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstisourcebillid(billID);      //配镜单号
				inventoryPo.setCstiremark("门店退款自动调拨");
				inventoryPo.setCstigoodscategory("22");       //特殊标志,22标识门店自动调拨
				inventoryPo.setCstifinanceauditperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstifinanceauditstate("1");
				
				inventoryList.add(inventoryPo);
				
				stockList.add(secondStock);   //用于判断需要生成多少张调拨单
			}
			
			if (!tbillid.equals("")){
				
				nottaxrateamount = new BigDecimal(po.getSsesdunitprice());
				costpriceamount = new BigDecimal(po.getSsesdcostsprive());
				goodsNum = new BigDecimal(po.getSsesdnumber());
				
				nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(tbillid);
				inventoryEntryPo.setCstiegoodsid(po.getSsesdsalesitemid());
				inventoryEntryPo.setCstiegoodsquantity(po.getSsesdnumber());
				inventoryEntryPo.setCstienottaxrate(po.getSsesdunitprice());
				inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
				inventoryEntryPo.setCstietaxrate(goodsInfoPo.getBgitaxrate());
				inventoryEntryPo.setCstiecostprice(po.getSsesdcostsprive());
				inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
				inventoryEntryPo.setCstietaxamount(taxamount.toString());
				inventoryEntryPo.setCstieinstockid(secondStock);
				inventoryEntryPo.setCstieoutstockid(Utility.getName(wpo.getBwhid()));
				inventoryEntryPo.setCstiebarcode(po.getSsesditemid());
				inventoryEntryPo.setCstieoutstorageflag("1");
				inventoryEntryPo.setCstieremark("门店退款");
				inventoryEntryPo.setCstieautoallocationflag("2");
				inventoryEntryPo.setCstiesalesbillid(billID);
				
	            if (flag == true && ("4".equals(Utility.getName(po.getSsesdsalesitemid()).substring(0,1)) || "5".equals(Utility.getName(po.getSsesdsalesitemid()).substring(0,1)))){
	    			GoodsInfoPo gpo = strogeChangeDao.getGoodsBatch(po.getSsesditemid());
	    			inventoryEntryPo.setCstieguaranteeperiod(Utility.getName(gpo.getGuaranteeperiod()));
	    			inventoryEntryPo.setCstiebatch(Utility.getName(gpo.getBatch()));            	
	            }
				inventoryEntryList.add(inventoryEntryPo);
			}
		}
		
		for (InventoryPo po : inventoryList){
			spectaclesMaterialsDao.inertAutoAllocationToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBillToStore(po);
		}
		
		String stockID = null;
		for (InventoryEntryPo po : inventoryEntryList){
			
			spectaclesMaterialsDao.inertAutoAllocationEntryToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBarcodeToStore(po);
			
			spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBillBarcodeToStore(po);
			
			//退款配置的仓位增加库存
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
			StrogeChangePo strogeChangePo=new StrogeChangePo();
			strogeChangePo.setCshscgoodsbarcode(po.getCstiebarcode());
			strogeChangePo.setCshscgoodsid(po.getCstiegoodsid());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshsccostprice(po.getCstiecostprice());	
			strogeChangePo.setCshscnottaxrate(po.getCstienottaxrate());		
			strogeChangePo.setCshscchangeid(po.getCstiebillid());
			strogeChangePo.setCshscautoallocationflag(po.getCstieautoallocationflag());
			strogeChangePo.setCshscguaranteeperiod(po.getCstieguaranteeperiod());
			strogeChangePo.setCshscBatch(po.getCstiebatch());
			strogeChangePo.setCshscsalesbillid(po.getCstiesalesbillid());

			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
			
			//门店减少库存 
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());			
			stockID = po.getCstieinstockid();
			po.setCstieinstockid(po.getCstieoutstockid()); //用门店仓位赋值
			po.setCstieoutstockid(stockID);
			
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
			
			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
		}
		
	}
	
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo customerInfoPo) {
		return refundDao.getCustomerInfo(customerInfoPo);
	}
	
	public SalesBasicPo getSalesBasicPo(String salesID){
		return refundDao.getSalesBasicPo(salesID);
	}
	
	public List<SalesLogPo> getSalesLogList(SalesLogPo salesLogPo) {
		
		return refundDao.getSalesLogList(salesLogPo);
	}
}
