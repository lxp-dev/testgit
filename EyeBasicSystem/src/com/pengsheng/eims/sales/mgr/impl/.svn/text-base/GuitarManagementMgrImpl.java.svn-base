/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.IntegralAddandSubDao;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangeEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.dao.SendNoteDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinIntegralSelectDao;
import com.pengsheng.weixin.dao.WeiXinInviteFriendDao;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * @author Liuqian
 * 
 */
public class GuitarManagementMgrImpl implements GuitarManagementMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private GuitarManagementDao guitarManagementDao;
	private WarehouseDao warehouseDao;
	private SetMealDao setMealDao;
	private IntegralAddandSubDao integralAddandSubDao;
	private StrogeChangeDao strogeChangeDao;	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private ChuzhikaDao chuzhikaDao; 
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private WarehouseConfigurationDao warehouseConfigurationDao = null;
	private SpectaclesMaterialsDao spectaclesMaterialsDao = null;
	private SystemParameterDao systemParameterDao = null;
	private SystemParameterPo systemParameterPo = null;
	private SendNoteMgr sendNoteMgr = null;
	private WeiXinIntegralSelectDao weiXinIntegralSelectDao;
	private ReportQuartzDao reportQuartzDao = null;
	private CashCouponDao cashCouponDao;
	private CustomerTakeDao customerTakeDao;
	private FrameSalesDao frameSalesDao;	
	private WindowsMgr windowsMgr;		
	private SendNoteDao sendNoteDao;
	private WeiXinInviteFriendDao weiXinInviteFriendDao;
	private ChuzhikaMgr chuzhikaMgr;
	
	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

	public WeiXinInviteFriendDao getWeiXinInviteFriendDao() {
		return weiXinInviteFriendDao;
	}

	public void setWeiXinInviteFriendDao(WeiXinInviteFriendDao weiXinInviteFriendDao) {
		this.weiXinInviteFriendDao = weiXinInviteFriendDao;
	}

	public SendNoteDao getSendNoteDao() {
		return sendNoteDao;
	}

	public void setSendNoteDao(SendNoteDao sendNoteDao) {
		this.sendNoteDao = sendNoteDao;
	}

	public FrameSalesDao getFrameSalesDao() {
		return frameSalesDao;
	}

	public void setFrameSalesDao(FrameSalesDao frameSalesDao) {
		this.frameSalesDao = frameSalesDao;
	}

	public CustomerTakeDao getCustomerTakeDao() {
		return customerTakeDao;
	}

	public void setCustomerTakeDao(CustomerTakeDao customerTakeDao) {
		this.customerTakeDao = customerTakeDao;
	}
	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}

	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}

	public CashCouponDao getCashCouponDao() {
		return cashCouponDao;
	}

	public void setCashCouponDao(CashCouponDao cashCouponDao) {
		this.cashCouponDao = cashCouponDao;
	}

	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}

	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
	}

	public WeiXinIntegralSelectDao getWeiXinIntegralSelectDao() {
		return weiXinIntegralSelectDao;
	}

	public void setWeiXinIntegralSelectDao(
			WeiXinIntegralSelectDao weiXinIntegralSelectDao) {
		this.weiXinIntegralSelectDao = weiXinIntegralSelectDao;
	}
	SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public WarehouseConfigurationDao getWarehouseConfigurationDao() {
		return warehouseConfigurationDao;
	}

	public void setWarehouseConfigurationDao(
			WarehouseConfigurationDao warehouseConfigurationDao) {
		this.warehouseConfigurationDao = warehouseConfigurationDao;
	}

	public SpectaclesMaterialsDao getSpectaclesMaterialsDao() {
		return spectaclesMaterialsDao;
	}

	public void setSpectaclesMaterialsDao(
			SpectaclesMaterialsDao spectaclesMaterialsDao) {
		this.spectaclesMaterialsDao = spectaclesMaterialsDao;
	}

	public ChuzhikaDao getChuzhikaDao() {
		return chuzhikaDao;
	}

	public void setChuzhikaDao(ChuzhikaDao chuzhikaDao) {
		this.chuzhikaDao = chuzhikaDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public IntegralAddandSubDao getIntegralAddandSubDao() {
		return integralAddandSubDao;
	}

	public void setIntegralAddandSubDao(IntegralAddandSubDao integralAddandSubDao) {
		this.integralAddandSubDao = integralAddandSubDao;
	}

	public SetMealDao getSetMealDao() {
		return setMealDao;
	}

	public void setSetMealDao(SetMealDao setMealDao) {
		this.setMealDao = setMealDao;
	}

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}

	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}

	
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo) {
		return guitarManagementDao.getCustmorInfo(customerInfoPo);
	}

	
	public List<SalesBasicPo> getSalesBasics(SalesBasicPo salesBasicPo) {
		return guitarManagementDao.getSalesBasics(salesBasicPo);
	}
	
	/**
	 * 得到更新结款方式信息
	 */
	public List<SalesBasicPo> getUpdatePayTypeSalesBasics(SalesBasicPo salesBasicPo){
		return guitarManagementDao.getUpdatePayTypeSalesBasics(salesBasicPo);
	}

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}

	
	public void insertSalesGutiar(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,InTransitPo inTransitPo,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,SendNotePo snpo,SendNotePo snpo2,PersonInfoPo personInfoPo,NoteTemplatePo noteTemplatePo,LogisticsLogPo logPo,SystemParameterPo systemParameterPo,int jfType,int czkType,int djqType,WeixinInviteFriendLogPo weixinInviteFriendLogPo) {

		logisticsLogDao.insertLog(logPo);  //新增日志

		SalesDetailPo detailPo = new SalesDetailPo();
		detailPo.setSsesdsalesid(salesBasicPo.getSsesbsalesid());		
		List<SalesDetailPo> detailPos = inTransitDetailsDao.getGoodsInfoNoFinished2(detailPo);

		BigDecimal jftotal = new BigDecimal(0);	// 本次销售客户应累计积分
		BigDecimal bg3 = new BigDecimal(salesBasicPo.getNowintegral());  // 本次销售积分消费
		BigDecimal bg = new BigDecimal(salesBasicPo.getSsesbjfamount());   // 本次销售获取积分
		IntegralAddandSubPo integralAddandSubPo = null;
		
		SalesBasicPo fspo = null;		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbfcustomerid()))){
			fspo = inTransitDetailsDao.getCustomerInfo2(salesBasicPo.getSsesbfcustomerid());  // 获取主卡的顾客信息
		}else{
			fspo = inTransitDetailsDao.getCustomerInfo2(salesBasicPo.getSsesbcustomerid());  // 根据配镜单查询顾客信息
		}	
		WeixinInviteFriendLogPo weixinpo = weiXinInviteFriendDao.selectWeiXinInviteFriendLogCheck(weixinInviteFriendLogPo);
		SalesBasicPo weixinfspo = inTransitDetailsDao.getCustomerInfo2(weixinpo.getWiflcustomerid()); 
		BigDecimal bg4 = new BigDecimal(Utility.getName(fspo.getInintrgral())); // 原有积分
		
		jftotal = jftotal.add(bg);
		
		if (jfType >= 0){ // 积分

			jftotal = bg.subtract(bg3);  // 本次销售获取积分 - 本次销售积分消费
			
			//积分流水--使用积分			
			int r = bg3.compareTo(BigDecimal.ZERO);   // bg3大于零，即本次销售积分消费大于零
			if(r > 0){
				integralAddandSubPo = new IntegralAddandSubPo();
				
				integralAddandSubPo.setSmeasuuid(uuid.generate());
				integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
				integralAddandSubPo.setSmeasyintegral(bg4.toString());//原积分
				integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
				
				integralAddandSubPo.setSmeascintegral("-"+bg3.toString());//消费积分
				integralAddandSubPo.setSmeasxintegral(bg4.subtract(bg3).toString());//现有积分
				
				if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
					integralAddandSubPo.setSmeasaddorsub("6");
				}else{
					integralAddandSubPo.setSmeasaddorsub("3");
				}
				
				integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());	
				
				if(!"".equals(Utility.getName(salesBasicPo.getSsesbfcustomerid()))){
					integralAddandSubPo.setSmeasfcustomerid(salesBasicPo.getSsesbcustomerid());   // 存放子卡会员ID
				}
				integralAddandSubPo.setIsjifenjiekuan("yes");
				integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
			}		
		}
		
		//订金不产生积分，全款计算积分
		if(!"1".equals(salesBasicPo.getSsesbcheckoutflag())){ 
			int r = bg.compareTo(BigDecimal.ZERO);   // bg大于零，即本次销售获取积分大于零
			if (r > 0){
				//积分流水--获得积分
				integralAddandSubPo = new IntegralAddandSubPo();
				integralAddandSubPo.setSmeasuuid(uuid.generate());
				integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
				integralAddandSubPo.setSmeasyintegral(bg4.subtract(bg3).toString());//原积分     顾客原积分要减去本次销售积分消费
				integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
				
				integralAddandSubPo.setSmeascintegral(salesBasicPo.getSsesbjfamount());//获得积分
				integralAddandSubPo.setSmeasxintegral(bg4.subtract(bg3).add(bg).toString());//现有积分
				
				if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
					integralAddandSubPo.setSmeasaddorsub("6");
				}else{
					integralAddandSubPo.setSmeasaddorsub("3");
				}
				
				integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());	
				
				if(!"".equals(Utility.getName(salesBasicPo.getSsesbfcustomerid()))){
					integralAddandSubPo.setSmeasfcustomerid(salesBasicPo.getSsesbcustomerid());
				}
				
				integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
				if(!"".equals(Utility.getName(weixinpo.getWifltousername()))){
					if(!"1".equals(weixinpo.getWiflisconfirm())&& "0".equals(fspo.getSsesbsalescount())){
						ChuzhikaPo chuzhikaPo= chuzhikaMgr.selectChuzhikaJifenByCustomerID(weixinpo.getWiflcustomerid());
						if(!"".equals(Utility.getName(chuzhikaPo.getCstczkid()))){
							String CIntegral = Double.parseDouble(systemParameterPo.getFspexchangeintegral())*Double.parseDouble(salesBasicPo.getSsesbjfamount())+"";
							LogisticsLogPo czhlogPo = new LogisticsLogPo();
							czhlogPo.setsLogName(personInfoPo.getId());
							czhlogPo.setsLogIP(logPo.getsLogIP());
							czhlogPo.setsLogResult(logPo.getsLogResult()); // 模块ID
							czhlogPo.setsLogOpID("1");    // 1 新增
							czhlogPo.setsLogContent("储值卡"+chuzhikaPo.getCstczkcardid()+"微信赠送："+CIntegral);
							
							ChuzhikaLogPo czkpo = new ChuzhikaLogPo();
							czkpo.setSmeascustomerid(weixinfspo.getSsesbcustomerid());
							czkpo.setSmeaschuzhikaid(chuzhikaPo.getCstczkid());
							czkpo.setSmeasshifu("0.00");
							czkpo.setSmeaszengsong(CIntegral);
							czkpo.setSmeascintegral(CIntegral);
							czkpo.setSmeasxintegral(CIntegral);
							czkpo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
							czkpo.setSmeasremark("微信邀请人赠送");
							czkpo.setSmeasaddorsub("1");
							czkpo.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
							czkpo.setSmeasmemberid(weixinfspo.getSsesbMemberId());
							chuzhikaMgr.updateChuzhikaChongzhi(czkpo, czhlogPo);
						}else{
							IntegralAddandSubPo weixinIntegralAddandSubPo = new IntegralAddandSubPo();
							weixinIntegralAddandSubPo.setSmeasuuid(uuid.generate());
							weixinIntegralAddandSubPo.setSmeasmemberid(weixinfspo.getSsesbMemberId());
							weixinIntegralAddandSubPo.setSmeasyintegral(weixinfspo.getInintrgral());//原积分     顾客原积分要减去本次销售积分消费
							weixinIntegralAddandSubPo.setSmeascustomerid(weixinfspo.getSsesbcustomerid());
							BigDecimal weixinbg = new BigDecimal(Utility.getName(weixinfspo.getInintrgral()));
							BigDecimal weixinaddbg = new BigDecimal(Utility.getName(salesBasicPo.getSsesbjfamount()));
							weixinIntegralAddandSubPo.setSmeascintegral(salesBasicPo.getSsesbjfamount());//获得积分
							weixinIntegralAddandSubPo.setSmeasxintegral(weixinbg.add(weixinaddbg).toString());//现有积分
							weixinIntegralAddandSubPo.setSmeasaddorsub("1");
							weixinIntegralAddandSubPo.setSmeasremark("微信邀请人赠送");
							
							weixinIntegralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
							weixinIntegralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());	
							
							integralAddandSubDao.insertIntegralAddandSubPo(weixinIntegralAddandSubPo);
						}
					}
				}
			}
		}

		
		if (czklist != null && czklist.size() != 0){
			
			List<ChuzhikaLogPo> clist = new ArrayList<ChuzhikaLogPo>();
			
			for (ChuzhikaPo czkpo : czklist){
				BigDecimal bgc1 = new BigDecimal(czkpo.getCstczkjine());
				BigDecimal bgc2 = new BigDecimal(czkpo.getCstczkchongzhijine());
				
				ChuzhikaLogPo po = new ChuzhikaLogPo();
				po.setSmeasmemberid(salesBasicPo.getSsesbMemberId());
				po.setSmeascustomerid(salesBasicPo.getSsesbcustomerid());
				po.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				po.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
				po.setSmeaschuzhikaid(czkpo.getCstczkid());
				
				if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
					po.setSmeascintegral(czkpo.getCstczkchongzhijine());
					po.setSmeasxintegral(czkpo.getCstczkjine());
					po.setSmeasyintegral((bgc1.subtract(bgc2)).toString());	
					po.setSmeasaddorsub("6");
				}else{
					po.setSmeascintegral(czkpo.getCstczkchongzhijine());
					po.setSmeasxintegral(czkpo.getCstczkjine());	
					po.setSmeasyintegral(bgc1.subtract(bgc2).toString());	
					po.setSmeasaddorsub("3");
				}
				
				clist.add(po);
			}
			
			if (clist.size() > 0){
				chuzhikaDao.insertChuZhiKaLogInformation(clist);
			}			
		}
		
		if ((djqType >= 0) && (djqlist != null) && (djqlist.size() > 0)){     //代金券更新			
			cashCouponDao.updateCashCouponState(djqlist);
		}
		
		/**
		 * 更新会员积分
		 */
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			guitarManagementDao.updateCustomerIntegralNew(salesBasicPo.getSsesbsalesid(),"-"+bg3.toString(),"0",salesBasicPo.getSsesbsalesvalue(),salesBasicPo.getSsesbfcustomerid());
		}else{
			if(!"".equals(Utility.getName(weixinpo.getWifltousername()))){
				if(!"1".equals(weixinpo.getWiflisconfirm())&& "0".equals(fspo.getSsesbsalescount())){
					ChuzhikaPo chuzhikaPo= chuzhikaMgr.selectChuzhikaJifenByCustomerID(weixinpo.getWiflcustomerid());
					if("".equals(Utility.getName(chuzhikaPo.getCstczkid()))){
						guitarManagementDao.updateCustomerIntegralNew2("", salesBasicPo.getSsesbjfamount(), "", "", weixinpo.getWiflcustomerid());
					}
					weixinpo.setWiflisconfirm("1");
					weiXinInviteFriendDao.updateWeiXinInviteFriendLog(weixinpo);
				}
			}
			guitarManagementDao.updateCustomerIntegralNew(salesBasicPo.getSsesbsalesid(),jftotal.toString(),"1",salesBasicPo.getSsesbsalesvalue(),salesBasicPo.getSsesbfcustomerid());
		}
		
		salesBasicPo.setSsesbintegral(jftotal.toString());   //本次销售应累计积分
		salesBasicPo.setSsesbintransit("2");
		
		inTransitPo.setSseitstate(salesBasicPo.getSsesbintransit());
		
		// 插入在途点 -- 收银在途
		guitarManagementDao.insertIntrnsitInfo(inTransitPo);
		
		//隐形成品和辅料在途直接到顾客取镜
		if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("3") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("5")) {
			if("1".equals(systemParameterPo.getFspsalesintransit())){
				if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
					salesBasicPo.setSsesbintransit("12");
				}else{
					salesBasicPo.setSsesbintransit("13");
				}	
			}else{
				salesBasicPo.setSsesbintransit("12");
			}
			inTransitPo.setSseitstate(salesBasicPo.getSsesbintransit());
			
			guitarManagementDao.insertIntrnsitInfo(inTransitPo);
		}else if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("1")){     // 框镜成品销售
			// 双自片不走发料流程
			int count = windowsMgr.isEnabledInTransit("3");   // 门店配送模块是否启用
			int zzcount = 0; // 判断是否存在双自片
			
			if (Utility.getName(salesBasicPo.getSsesbdoublezz()).equals("1")){
				zzcount = 2;   // 在双自片
			}
			
			if (Utility.getName(systemParameterPo.getFspzzautospectaclesmaterials()).equals("1")){    // 系统参数设定：双自片配镜单结款后在途是门店配送
				if ((count == 0) && (zzcount >= 2)){    // 门店配送模块被停用并且存在双自片时，配镜单在途直接变为配镜发料
					salesBasicPo.setSsesbintransit("6");
					inTransitPo.setSseitstate(salesBasicPo.getSsesbintransit());
					guitarManagementDao.insertIntrnsitInfo(inTransitPo);
				}
			}else if (Utility.getName(systemParameterPo.getFspzzautospectaclesmaterials()).equals("2")) { // 系统参数设定：双自片配镜单结款后在途是顾客取镜
				if (zzcount >= 2){  // 存在双自片时，配镜单在途直接变为顾客取镜
					if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
						salesBasicPo.setSsesbintransit("12");
					}else{
						salesBasicPo.setSsesbintransit("13");
					}
					inTransitPo.setSseitstate(salesBasicPo.getSsesbintransit());
					guitarManagementDao.insertIntrnsitInfo(inTransitPo);
				}
			}
		}

		// 更新销售在途点，银台结款状态
		guitarManagementDao.updateMaterialsInTransit(salesBasicPo);

		WarehousePo wpo = null;
		WarehouseConfigurationPo warehouseConfigurationPo = null;
		
		//if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){   //自动调拨
			DepartmentsPo departmentPo = new DepartmentsPo();
			departmentPo.setBdpdepartmentid(salesBasicPo.getSsesbshopcode());
			wpo = warehouseDao.getWarehousePo(departmentPo);
			
			WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
			tempWarehouseConfigurationPo.setBwcdeptid(salesBasicPo.getSsesbshopcode());
			warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		//}
		
		String bwhid = "";
				
		// 隐形成品和辅料在银台结款后至顾客取镜
		if ((Utility.getName(salesBasicPo.getSsesborderstype()).equals("3") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("5")) ){
			if("1".equals(systemParameterPo.getFspsalesintransit())){
				//自动调拨
				if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
					bwhid = Utility.getName(wpo.getBwhid());
					autoAllocationToStore(systemParameterPo,detailPos,salesBasicPo.getSsesbsalesid(),inTransitPo,wpo,salesBasicPo,warehouseConfigurationPo);
				}	
			
				// 门店减少库存
				guitarManagementDao.insertStrogeChangeNew(salesBasicPo.getSsesbsalesid(),bwhid);
				guitarManagementDao.insertStrogeChangeLogNew(salesBasicPo.getSsesbsalesid(),bwhid);
				strogeChangeDao.insertStrogeChangeLogTemp(detailPos,bwhid);
				
				//更新商品出库状态     in:退款   out:结款       1：出(入)库    0：未出(入)库
				guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesBasicPo.getSsesbsalesid(),"out","1");
				
				//删除在途库存的商品
				guitarManagementDao.deleteInTransitStroge(salesBasicPo);
			}
		}else{
			//如果赠品出仓在发料，那重新赋值商品明细po，不包含赠品
			if("2".equals(warehouseConfigurationPo.getBwcxiaocangzp2())){
				detailPos = inTransitDetailsDao.getGoodsInfoNoFinished2NoZengPin(detailPo);			
			}
			
			//自动调拨
			if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
				bwhid = Utility.getName(wpo.getBwhid());
				autoAllocationToStore(systemParameterPo,detailPos,salesBasicPo.getSsesbsalesid(),inTransitPo,wpo,salesBasicPo,warehouseConfigurationPo);
			}
			
			//如果赠品出仓在发料
			if("2".equals(warehouseConfigurationPo.getBwcxiaocangzp2())){
				// 门店减少库存
				guitarManagementDao.insertStrogeChangeNewNoZengPin(salesBasicPo.getSsesbsalesid(),bwhid);
				guitarManagementDao.insertStrogeChangeLogNewNoZengPin(salesBasicPo.getSsesbsalesid(),bwhid);		
			}else{
				// 门店减少库存
				guitarManagementDao.insertStrogeChangeNew(salesBasicPo.getSsesbsalesid(),bwhid);
				guitarManagementDao.insertStrogeChangeLogNew(salesBasicPo.getSsesbsalesid(),bwhid);
			}
			
			strogeChangeDao.insertStrogeChangeLogTemp(detailPos,bwhid);
			
			//更新商品出库状态     in:退款   out:结款       1：出(入)库    0：未出(入)库
			//如果赠品出仓在发料
			if("2".equals(warehouseConfigurationPo.getBwcxiaocangzp()) || "2".equals(warehouseConfigurationPo.getBwcxiaocangzp2())){
				// 门店减少库存
				guitarManagementDao.updateStrogeChangeUnFinishedFlagNoZengPin(salesBasicPo.getSsesbsalesid(),"out","1","jiekuan");		
			}else{
				// 门店减少库存
				guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesBasicPo.getSsesbsalesid(),"out","1");
			}
			
			//删除在途库存的商品
			guitarManagementDao.deleteInTransitStroge(salesBasicPo);
		}
		
		//新增订金
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			guitarManagementDao.insertCustomize(salesBasicPo);
		}
		
		//新增付款记录
		if (salesLogPos != null && salesLogPos.size() > 0){
			guitarManagementDao.insertSalesLog(salesLogPos);
		}
		
		//新增当天销售数据
		guitarManagementDao.insertSalesBill(salesBasicPo);
		guitarManagementDao.insertSalesBillEntry(salesBasicPo);
		
		//新增当天营业员收银员记录
		insertSalerCashierRecord(detailPos,salesBasicPo,"1",salesBasicPo.getSsesbcheckoutflag(),"0",salesBasicPo.getSsesbposid());
	
		//发送短信
		/****************************************************************************/
		if(systemParameterPo.getFspsalesintransit().equals("1"))       // 银台结款后至顾客取镜
		{
			if(null!=noteTemplatePo && null!=noteTemplatePo.getBntcontent() && !noteTemplatePo.getBntcontent().equals(""))
			{
	
				if(null!=detailPos && detailPos.size()>0)
				{
					int goods=detailPos.size();
	
					List<GoodsInfoPo> gps=new ArrayList<GoodsInfoPo>();
					for(int i=0;i<goods;i++)
					{
						SalesDetailPo salesDetailPo=detailPos.get(i);
						if(Utility.getName(salesDetailPo.getSsesdcommoditiesflag()).equals("4"))
						{
							GoodsInfoPo goodsInfoPo=customerTakeDao.getGoodsInfoPo(salesDetailPo.getSsesdsalesitemid());
							
							if(goodsInfoPo.getBgiiscustomize().equals("0") && Utility.getName(salesBasicPo.getSsesbarrearsvalue()).equals("0.00"))
							{
								if(goodsInfoPo.getBgistealthclass().equals("1"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBntdaythrow().equals("1"))    // 
										{
											if(Float.parseFloat(noteTemplatePo.getBntdaythrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("2"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBntweekthrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBntweekthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("9"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBntbiweeklythrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBntbiweeklythrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("3"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBntmonththrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBntmonththrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("4"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBntseasonthrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBntseasonthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("5"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBnthalfyearthrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBnthalfyearthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("6"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										
										if(noteTemplatePo.getBntyearthrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBntyearthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{									
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");								
											gps.add(goodsInfoPo);
										}
									}
								}
								if(goodsInfoPo.getBgistealthclass().equals("7"))
								{
									if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
									{
										if(noteTemplatePo.getBntrgpthrow().equals("1"))
										{
											if(Float.parseFloat(noteTemplatePo.getBntrgpthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
											{
												goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
												gps.add(goodsInfoPo);
											}
										}else
										{
											goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
											gps.add(goodsInfoPo);
										}
									}
								}
							}
						}
					}
					String type=noteTemplatePo.getBntsendtype();
					String hour=noteTemplatePo.getBntsendhour();
					if(gps.size()>0)
					{
						if(type.equals("1"))   // 长短周期的判断
						{
							
							GoodsInfoPo gpo=gps.get(0);
							for(int j=0;j<gps.size();j++)
							{
								GoodsInfoPo infopo=gps.get(j);
								if(Float.parseFloat(infopo.getBginumberofdays())>Float.parseFloat(gpo.getBginumberofdays()))
								{
									gpo=infopo;
								}
							}
							CustomerInfoPo cpo = new CustomerInfoPo();
							SendNotePo notepo=new SendNotePo();
							notepo.setSnnotetypeid("13");
							cpo.setSmecimemberid(Utility.getName(salesBasicPo.getSsesbMemberId()));
							CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
							if(Utility.isMobile(customerInfoPo.getSmeciphone()))
							{
							    notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
								notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
								notepo.setSnpersonid(personInfoPo.getId());
								
								String content=noteTemplatePo.getBntcontent();
								
								String tem= Utility.getName(gpo.getBgistealthclass()) ;
								if(tem.equals("1"))
								{
									tem="日抛";
								}
								if(tem.equals("2"))
								{
									tem="周抛";
								}
								if(tem.equals("9"))
								{
									tem="双周抛";
								}
								if(tem.equals("3"))
								{
									tem="月抛";
								}
								if(tem.equals("4"))
								{
									tem="季抛";
								}
								if(tem.equals("5"))
								{
									tem="半年抛";
								}
								if(tem.equals("6"))
								{
									tem="年抛";
								}
								if(tem.equals("7"))
								{
									tem="RGP";
								}
								if(tem.equals("8"))
								{
									tem="塑形镜";
								}

								notepo.setSnstealthclass(tem);

								notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
								
								notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
								

								String bb="";
								if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
								{
									bb="女士";
								}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
								{
									bb="先生";
								}
								notepo.setSnsex(bb);
																								
								notepo.setSnbillid(Utility.getName(salesBasicPo.getSsesbsalesid()));
								
								notepo.setSnshopcodename(Utility.getName(salesBasicPo.getSsesbshopName()));
								notepo.setSnshopcodephone(Utility.getName(salesBasicPo.getSsesbsalestelphone()));

								String dvalue=noteTemplatePo.getBntsendtime();
								int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
								if(dff>=0)
								{
									Date d=new Date();
									
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
									Calendar ca = Calendar.getInstance();
									ca.add(Calendar.DATE, dff);
									d = ca.getTime();
									String backTime = format.format(d);
								
									notepo.setSnsenddate(backTime+" "+hour);
									sendNoteMgr.insertSendNoteContent(notepo);
								}
								
							}
						}
						if(type.equals("2"))
						{
							GoodsInfoPo gpo=gps.get(0);
							for(int j=0;j<gps.size();j++)
							{
								GoodsInfoPo infopo=gps.get(j);
								if(Float.parseFloat(infopo.getBginumberofdays())<Float.parseFloat(gpo.getBginumberofdays()))
								{
									gpo=infopo;
								}
							}
							CustomerInfoPo cpo = new CustomerInfoPo();
							SendNotePo notepo=new SendNotePo();
							notepo.setSnnotetypeid("13");
							cpo.setSmecimemberid(Utility.getName(salesBasicPo.getSsesbMemberId()));
							CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
							if(Utility.isMobile(customerInfoPo.getSmeciphone()))
							{	
								notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
								notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
								notepo.setSnpersonid(personInfoPo.getId());
								
								String content=noteTemplatePo.getBntcontent();
								
								String tem= Utility.getName(gpo.getBgistealthclass()) ;
								if(tem.equals("1"))
								{
									tem="日抛";
								}
								if(tem.equals("2"))
								{
									tem="周抛";
								}
								if(tem.equals("9"))
								{
									tem="双周抛";
								}
								if(tem.equals("3"))
								{
									tem="月抛";
								}
								if(tem.equals("4"))
								{
									tem="季抛";
								}
								if(tem.equals("5"))
								{
									tem="半年抛";
								}
								if(tem.equals("6"))
								{
									tem="年抛";
								}
								if(tem.equals("7"))
								{
									tem="RGP";
								}
								if(tem.equals("8"))
								{
									tem="塑形镜";
								}

								notepo.setSnstealthclass(tem);

								notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
								
								notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
								

								String bb="";
								if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
								{
									bb="女士";
								}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
								{
									bb="先生";
								}
								notepo.setSnsex(bb);
																								
								notepo.setSnbillid(Utility.getName(salesBasicPo.getSsesbsalesid()));
								
								notepo.setSnshopcodename(Utility.getName(salesBasicPo.getSsesbshopName()));
								notepo.setSnshopcodephone(Utility.getName(salesBasicPo.getSsesbsalestelphone()));
							
								String dvalue=noteTemplatePo.getBntsendtime();
								int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
								if(dff>=0)
								{
									Date d=new Date();
									
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
									Calendar ca = Calendar.getInstance();
									ca.add(Calendar.DATE, dff);
									d = ca.getTime();
									String backTime = format.format(d);
								
									notepo.setSnsenddate(backTime+" "+hour);
									sendNoteMgr.insertSendNoteContent(notepo);
								}
								
							}
							
						}
						if(type.equals("3"))
						{
							for(int j=0;j<gps.size();j++)
							{
								GoodsInfoPo gpo=gps.get(j);
								CustomerInfoPo cpo = new CustomerInfoPo();
								SendNotePo notepo=new SendNotePo();
								notepo.setSnnotetypeid("13");
								
								cpo.setSmecimemberid(Utility.getName(salesBasicPo.getSsesbMemberId()));
								CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
								
								if(Utility.isMobile(customerInfoPo.getSmeciphone()))
								{				
									notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
									notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
									notepo.setSnpersonid(personInfoPo.getId());

									String content=noteTemplatePo.getBntcontent();
									
									String tem= Utility.getName(gpo.getBgistealthclass()) ;
									if(tem.equals("1"))
									{
										tem="日抛";
									}
									if(tem.equals("2"))
									{
										tem="周抛";
									}
									if(tem.equals("9"))
									{
										tem="双周抛";
									}
									if(tem.equals("3"))
									{
										tem="月抛";		
									}
									if(tem.equals("4"))
									{
										tem="季抛";
									}
									if(tem.equals("5"))
									{
										tem="半年抛";
									}
									if(tem.equals("6"))
									{
										tem="年抛";
									}
									if(tem.equals("7"))
									{
										tem="RGP";
									}
									if(tem.equals("8"))
									{
										tem="塑形镜";
									}

									notepo.setSnstealthclass(tem);

									notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
									
									notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
									

									String bb="";
									if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
									{
										bb="女士";
									}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
									{
										bb="先生";
									}
									notepo.setSnsex(bb);
																									
									notepo.setSnbillid(Utility.getName(salesBasicPo.getSsesbsalesid()));
									
									notepo.setSnshopcodename(Utility.getName(salesBasicPo.getSsesbshopName()));
									notepo.setSnshopcodephone(Utility.getName(salesBasicPo.getSsesbsalestelphone()));

									String dvalue=noteTemplatePo.getBntsendtime();
									int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
									
									if(dff>=0)
									{
										Date d=new Date();
										
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
										Calendar ca = Calendar.getInstance();
										ca.add(Calendar.DATE, dff);
										d = ca.getTime();
										String backTime = format.format(d);
											  
										notepo.setSnsenddate(backTime+" "+hour);
										sendNoteMgr.insertSendNoteContent(notepo);
									}
									
								}
							}
						}
					}
				}
				
			}
		}
		/***********************************************************************/
		if (snpo != null){
			CustomerInfoPo cpo = new CustomerInfoPo();
			cpo.setSmecicustomerid(Utility.getName(salesBasicPo.getSsesbcustomerid()));
			cpo = customerInfoDao.getCustomerInfo2(cpo);
			
			snpo.setSncustomername(Utility.getName(cpo.getSmeciname()));
			snpo.setSnsex(Utility.getName(cpo.getSmecisex()).equals("0") ? "先生" : (Utility.getName(cpo.getSmecisex()).equals("1") ? "女士" : ""));		
			snpo.setSnpsalesprice(Utility.getName(salesBasicPo.getSsesbpsalsvalue()));
			snpo.setSncustomerid(Utility.getName(salesBasicPo.getSsesbcustomerid()));	
			
			if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
				snpo.setSnintegral("0");
			}else{
				snpo.setSnintegral(jftotal.toString());
			}
			snpo.setSnshopcodephone(Utility.getName(salesBasicPo.getSsesbsalestelphone()));
			snpo.setSnshopcodename(Utility.getName(salesBasicPo.getSsesbshopName()));
			
			sendNoteMgr.insertSendNoteContent(snpo);
		}
		
		if (snpo2 != null){
			if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("2") || Utility.getName(salesBasicPo.getSsesborderstype()).equals("4")){
				snpo2.setSncustomerid(Utility.getName(salesBasicPo.getSsesbcustomerid()));
				sendNoteMgr.insertSendNoteContent(snpo2);
			}	
		}
	
		// 新增付款记录（横向）
		SalesLogPo slpo = new SalesLogPo();
		slpo.setSsesluuid(uuid.generate());
		slpo.setSsesltype("1"); // 配镜类型

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
		
		// 将配镜单送至已完结的表中
		if (Utility.getName(salesBasicPo.getSsesbintransit()).equals("13") && Utility.getName(systemParameterPo.getFspsplitsalesdataflag()).equals("1")){			
			customerTakeDao.insertSalesBasicFinished(Utility.getName(salesBasicPo.getSsesbsalesid()));
			customerTakeDao.insertSalesDetailFinished(Utility.getName(salesBasicPo.getSsesbsalesid()));
			customerTakeDao.deleteSalesBasic(Utility.getName(salesBasicPo.getSsesbsalesid()));
			customerTakeDao.deleteSalesDetail(Utility.getName(salesBasicPo.getSsesbsalesid()));
		}
    }
	
	public void insertSalerCashierRecord(List<SalesDetailPo> detailPos,SalesBasicPo salesBasicPo,String valueof,String checkout,String withdrawflag,String opperson){
		SalesDetailPo sdpo = new SalesDetailPo();
		sdpo.setSsesdsalesid(salesBasicPo.getSsesbsalesid());	
		
		salesBasicPo = guitarManagementDao.getSalesBasicInfoByID(salesBasicPo);	
		sdpo.setSsesdshopcode(salesBasicPo.getSsesbshopcode());		
		sdpo.setSsesdsalerid(salesBasicPo.getSsesbsalerid());		
		sdpo.setSsesdposid(opperson);
		sdpo.setSsesdwithdrawflag(withdrawflag);	
		
		BigDecimal jjnum = new BigDecimal(0);
		BigDecimal jjprice = new BigDecimal(0.00);		
		BigDecimal pjnum = new BigDecimal(0);
		BigDecimal pjprice = new BigDecimal(0.00);			
		BigDecimal pjyxnum = new BigDecimal(0);
		BigDecimal pjyxprice = new BigDecimal(0.00);
		BigDecimal cppnum = new BigDecimal(0);
		BigDecimal cppprice = new BigDecimal(0.00);		
		BigDecimal dzpnum = new BigDecimal(0);
		BigDecimal dzpprice = new BigDecimal(0.00);		
		BigDecimal yxcppnum = new BigDecimal(0);
		BigDecimal yxcppprice = new BigDecimal(0.00);		
		BigDecimal yxdzpnum = new BigDecimal(0);
		BigDecimal yxdzpprice = new BigDecimal(0.00);		
		BigDecimal hlynum = new BigDecimal(0);
		BigDecimal hlyprice = new BigDecimal(0.00);		
		BigDecimal tyjnum = new BigDecimal(0);
		BigDecimal tyjprice = new BigDecimal(0.00);		
		BigDecimal hcnum = new BigDecimal(0);
		BigDecimal hcprice = new BigDecimal(0.00);		
		BigDecimal lhjnum = new BigDecimal(0);
		BigDecimal lhjprice = new BigDecimal(0.00);		
		BigDecimal sgnum = new BigDecimal(0);
		BigDecimal sgprice = new BigDecimal(0.00);		
		BigDecimal additionprice = new BigDecimal(0.00);
		BigDecimal discountprice = new BigDecimal(0.00);		
		BigDecimal zzjjnum = new BigDecimal(0);
		BigDecimal zzjpnum = new BigDecimal(0);
		
		SalesBasicPo spo = guitarManagementDao.getDiscountpriceByID(salesBasicPo);
		
		discountprice = discountprice.add(new BigDecimal(Utility.getName(spo.getSsesbdiscountnum())));
		discountprice = discountprice.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		if (guitarManagementDao.getAdditionpriceCountByID(salesBasicPo) > 0){
			spo = guitarManagementDao.getAdditionpriceByID(salesBasicPo);
			
			additionprice = additionprice.add(new BigDecimal(Utility.getName(spo.getSsesbadditionPrice())));
			additionprice = additionprice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		for (SalesDetailPo tmpsdpo : detailPos){			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("1")){
				if (Utility.getName(tmpsdpo.getSsesdsupplierid()).equals("ZZ")){
					zzjjnum = zzjjnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				}else{
					jjnum = jjnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
					
					jjprice = jjprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
					jjprice = jjprice.setScale(2, BigDecimal.ROUND_HALF_UP);
				}
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("2")){
				if (Utility.getName(tmpsdpo.getSsesdaccessoriestype()).equals("1")){
					pjnum = pjnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
					
					pjprice = pjprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
					pjprice = pjprice.setScale(2, BigDecimal.ROUND_HALF_UP);
				}
				
				if (Utility.getName(tmpsdpo.getSsesdaccessoriestype()).equals("2")){
					pjyxnum = pjyxnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
					
					pjyxprice = pjyxprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
					pjyxprice = pjyxprice.setScale(2, BigDecimal.ROUND_HALF_UP);
				}

			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("3")){
				if (Utility.getName(tmpsdpo.getSsesdsupplierid()).equals("ZZ")){
					zzjpnum = zzjpnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				}else{
					if (Utility.getName(tmpsdpo.getSsesdiscustomize()).equals("0")){
						cppnum = cppnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
						
						cppprice = cppprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
						cppprice = cppprice.setScale(2, BigDecimal.ROUND_HALF_UP);
					}else{
						dzpnum = dzpnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
						
						dzpprice = dzpprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
						dzpprice = dzpprice.setScale(2, BigDecimal.ROUND_HALF_UP);
					}
				}
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("4")){
				if (Utility.getName(tmpsdpo.getSsesdiscustomize()).equals("0")){
					yxcppnum = yxcppnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
					
					yxcppprice = yxcppprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
					yxcppprice = yxcppprice.setScale(2, BigDecimal.ROUND_HALF_UP);
				}else{
					yxdzpnum = yxdzpnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
					
					yxdzpprice = yxdzpprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
					yxdzpprice = yxdzpprice.setScale(2, BigDecimal.ROUND_HALF_UP);
				}
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("5")){
				hlynum = hlynum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				
				hlyprice = hlyprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
				hlyprice = hlyprice.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("6")){
				tyjnum = tyjnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				
				tyjprice = tyjprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
				tyjprice = tyjprice.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("7")){
				hcnum = hcnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				
				hcprice = hcprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
				hcprice = hcprice.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("8")){
				lhjnum = lhjnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				
				lhjprice = lhjprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
				lhjprice = lhjprice.setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			if (Utility.getName(tmpsdpo.getSsesdcommoditiesflag()).equals("9")){
				sgnum = sgnum.add(new BigDecimal(tmpsdpo.getSsesdnumber()));
				
				sgprice = sgprice.add(new BigDecimal(tmpsdpo.getSsesdsalesvalue()));
				sgprice = sgprice.setScale(2, BigDecimal.ROUND_HALF_UP);
			}			
		}		
		
		sdpo.setSsesdjjnum(jjnum.toString());
		sdpo.setSsesdjjprice(jjprice.toString());		
		sdpo.setSsesdpjnum(pjnum.toString());
		sdpo.setSsesdpjprice(pjprice.toString());			
		sdpo.setSsesdpjyxnum(pjyxnum.toString());
		sdpo.setSsesdpjyxprice(pjyxprice.toString());
		sdpo.setSsesdcppnum(cppnum.toString());
		sdpo.setSsesdcppprice(cppprice.toString());		
		sdpo.setSsesddzpnum(dzpnum.toString());
		sdpo.setSsesddzpprice(dzpprice.toString());		
		sdpo.setSsesdyxcppnum(yxcppnum.toString());
		sdpo.setSsesdyxcppprice(yxcppprice.toString());		
		sdpo.setSsesdyxdzpnum(yxdzpnum.toString());
		sdpo.setSsesdyxdzpprice(yxdzpprice.toString());		
		sdpo.setSsesdhlynum(hlynum.toString());
		sdpo.setSsesdhlyprice(hlyprice.toString());		
		sdpo.setSsesdtyjnum(tyjnum.toString());
		sdpo.setSsesdtyjprice(tyjprice.toString());		
		sdpo.setSsesdhcnum(hcnum.toString());
		sdpo.setSsesdhcprice(hcprice.toString());		
		sdpo.setSsesdlhjnum(lhjnum.toString());
		sdpo.setSsesdlhjprice(lhjprice.toString());		
		sdpo.setSsesdsgnum(sgnum.toString());
		sdpo.setSsesdsgprice(sgprice.toString());		
		sdpo.setSsesdadditionprice(additionprice.toString());
		sdpo.setSsesddiscountprice(discountprice.toString());	
		sdpo.setSsesdzzjjnum(zzjjnum.toString());	
		sdpo.setSsesdzzjpnum(zzjpnum.toString());
		
		if ("1".equals(valueof)){
			guitarManagementDao.insertSalerCashierRecord(sdpo);
		}
				
		if (!"1".equals(checkout)){
			guitarManagementDao.insertSalerCashierRecord_AppendArrears(sdpo);
		}
		
	}
	
	public void updatePayType(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,InTransitPo inTransitPo,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String smecimemberid,LogisticsLogPo logPo,SystemParameterPo systemParameterPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		//删除积分
		CustomerInfoPo infoPo=guitarManagementDao.selCustomerIntegral(salesBasicPo.getSsesbsalesid());
		if(infoPo.getSmecicustomerid()!=null){
		guitarManagementDao.updateCustomerIntegralNew2(infoPo.getSmecicustomerid(), infoPo.getSmeciintegral());

		guitarManagementDao.deleteCustomerIntegral(salesBasicPo.getSsesbsalesid());
		}
		
		
		//删除代金券
		CashCouponPo cashPo=new CashCouponPo();
		cashPo.setSalesid(salesBasicPo.getSsesbsalesid());
		
		List<CashCouponPo> djlist=cashCouponDao.getCashCouponList4(cashPo);
		
		if (djlist != null && djlist.size() != 0){
			for (CashCouponPo couponPo:djlist){
				couponPo.setBccuseflag("0");
				cashCouponDao.updateCashCouponState2(couponPo);
			}
		}
		//积分流水
		BigDecimal jftotal = new BigDecimal(0);
		jftotal=jftotal.setScale(0, BigDecimal.ROUND_HALF_UP);

		BigDecimal bg3 = new BigDecimal(salesBasicPo.getNowintegral());  //积分消费
		jftotal = jftotal.subtract(bg3);  // 商品累计积分-积分消费
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoFinished(salesBasicPo);
		
		SalesBasicPo fspo = new SalesBasicPo();
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			CustomerInfoPo tfcpo = new CustomerInfoPo();
			tfcpo.setSmecicustomerid(salesBasicPo2.getSsesbfcustomerid());
			CustomerInfoPo fcpo = frameSalesDao.getCustomerInfo(tfcpo);
			
			SalesBasicPo tfspo = new SalesBasicPo();
			tfspo.setSsesbcustomerid(fcpo.getSmecicustomerid());
			fspo = inTransitDetailsDao.getCustomerInfo(tfspo);
		}else{
			fspo = salesBasicPo2;
		}
		
		BigDecimal bg4 = new BigDecimal(Utility.getName(fspo.getInintrgral()).equals("") ? "0" : Utility.getName(fspo.getInintrgral())); // 原有积分
		
		//积分流水
		IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
		integralAddandSubPo.setSmeasuuid(uuid.generate());
		integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
		integralAddandSubPo.setSmeasyintegral(bg4.toString());
		integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			integralAddandSubPo.setSmeascintegral("-"+bg3.toString());
			integralAddandSubPo.setSmeasxintegral(bg4.subtract(bg3).toString());
			integralAddandSubPo.setSmeasaddorsub("6");
		}else{
			integralAddandSubPo.setSmeascintegral(jftotal.toString());
			integralAddandSubPo.setSmeasxintegral(jftotal.add(bg4).toString());	
			integralAddandSubPo.setSmeasaddorsub("3");
		}		
		integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
		integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());		
		
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			integralAddandSubPo.setSmeasfcustomerid(salesBasicPo2.getSsesbcustomerid());
		}
		
		integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
		
		/**
		 * 更新会员积分
		 */
		if("1".equals(salesBasicPo.getSsesbcheckoutflag())){
			guitarManagementDao.updateCustomerIntegralNew2(salesBasicPo.getSsesbsalesid(),"-"+bg3.toString(),"1",salesBasicPo.getSsesbsalesvalue(),salesBasicPo2.getSsesbfcustomerid());
		}else{
			guitarManagementDao.updateCustomerIntegralNew2(salesBasicPo.getSsesbsalesid(),jftotal.toString(),"1",salesBasicPo.getSsesbsalesvalue(),salesBasicPo2.getSsesbfcustomerid());
		}
		
		
		SalesLogPo cpo = new SalesLogPo();
		cpo.setSseslsalesid(salesBasicPo.getSsesbsalesid());
		cpo.setSseslpaymenttype(salesBasicPo.getSseslpaymenttype());


		//冲储值卡记录
		ChuzhikaLogPo chuzhikaLogPo = new ChuzhikaLogPo();
		chuzhikaLogPo.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
		if(salesBasicPo.getSseslpaymenttype().equals("1")){//全款
			chuzhikaLogPo.setSmeasaddorsub("3");
		}else if(salesBasicPo.getSseslpaymenttype().equals("2")){//交定金
			chuzhikaLogPo.setSmeasaddorsub("6");
		}else if(salesBasicPo.getSseslpaymenttype().equals("3")){//补齐欠款
			chuzhikaLogPo.setSmeasaddorsub("5");
		}else if(salesBasicPo.getSseslpaymenttype().equals("4")){//退款
			chuzhikaLogPo.setSmeasaddorsub("4");
		}else if(salesBasicPo.getSseslpaymenttype().equals("5")){//无配镜单退款，合并为退款
			chuzhikaLogPo.setSmeasaddorsub("4");
		}else if(salesBasicPo.getSseslpaymenttype().equals("6")){//挂号费
			chuzhikaLogPo.setSmeasaddorsub("7");
		}else if(salesBasicPo.getSseslpaymenttype().equals("7")){//退挂号费
			chuzhikaLogPo.setSmeasaddorsub("9");
		}else if(salesBasicPo.getSseslpaymenttype().equals("8")){//维修费
			chuzhikaLogPo.setSmeasaddorsub("8");
		}
		
		List<ChuzhikaLogPo> chonghuiList=chuzhikaDao.selectChuzhikadel(chuzhikaLogPo);

		if (chonghuiList != null && chonghuiList.size() != 0){
			for (ChuzhikaLogPo czkLogpo:chonghuiList){
					
				czkLogpo.setSmeascustomerid(salesBasicPo2.getSsesbcustomerid());
				czkLogpo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				czkLogpo.setSmeasischong("C");
				czkLogpo.setSmeasaddorsub("C"+czkLogpo.getSmeasaddorsub());
				
				chuzhikaDao.insertChuZhiKaLogInformation(czkLogpo);
				
			}
		}	
		
		//获取储值卡消费金额
		if (czklist != null && czklist.size() != 0){
			for (ChuzhikaPo czkpo:czklist){
				BigDecimal chong = new BigDecimal(czkpo.getCstczkchongzhijine());
				BigDecimal cheng = new BigDecimal("-1");
				chong = chong.multiply(cheng);

				ChuzhikaLogPo po=new ChuzhikaLogPo();
				po.setSmeasmemberid(salesBasicPo2.getSsesbMemberId());
				po.setSmeascustomerid(salesBasicPo2.getSsesbcustomerid());
				po.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				po.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
				po.setSmeaschuzhikaid(czkpo.getCstczkid());
				po.setSmeascintegral(czkpo.getCstczkchongzhijine());
				
				if(salesBasicPo.getSseslpaymenttype().equals("1")){//全款
					po.setSmeasaddorsub("3");
				}else if(salesBasicPo.getSseslpaymenttype().equals("2")){//交定金
					po.setSmeasaddorsub("6");
				}else if(salesBasicPo.getSseslpaymenttype().equals("3")){//补齐欠款
					po.setSmeasaddorsub("5");
				}else if(salesBasicPo.getSseslpaymenttype().equals("4")){//退款
					po.setSmeascintegral(chong+"");
					po.setSmeasaddorsub("4");
				}else if(salesBasicPo.getSseslpaymenttype().equals("5")){//无配镜单退款，合并为退款
					po.setSmeascintegral(chong+"");
					po.setSmeasaddorsub("4");
				}else if(salesBasicPo.getSseslpaymenttype().equals("6")){//挂号费
					po.setSmeasaddorsub("7");
				}else if(salesBasicPo.getSseslpaymenttype().equals("7")){//退挂号费
					po.setSmeasaddorsub("9");
				}else if(salesBasicPo.getSseslpaymenttype().equals("8")){//维修费
					po.setSmeasaddorsub("8");
				}
				
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
	
		
		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState(couponPo);
			}
		}
		
		String intransit = "";
		if ("1".equals(Utility.getName(systemParameterPo.getFspsplitsalesdataflag()))){  // 拆分销售数据
			intransit = guitarManagementDao.getSalesBillInTransit(salesBasicPo);
		}
		
		guitarManagementDao.deleteSalesLog(cpo);
		//新增付款记录
		for(int i=0; i<salesLogPos.size(); i++){
			if(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))>0){
				salesLogPos.get(i).setSseslpaymenttype(salesBasicPo.getSseslpaymenttype());				
				salesLogPos.get(i).setSseslintransit(intransit);
				
				guitarManagementDao.insertSalesLogForUpdatePaymentType(salesLogPos.get(i));
			}
		}
		
		guitarManagementDao.deleteSalesCrossLog(cpo);
		
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
		slpo.setSseslintransit(intransit);
		
		guitarManagementDao.insertSalesCrossLogForUpdatePaymentType(slpo);	
		
	
		
    }
	
	/**
	 * 插入salesLog信息
	 * @param salesBasicPo
	 * @param salesLogPos
	 * @param logPo
	 */
	public void insertPayType(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist){
		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState(couponPo);
			}
		}
		BigDecimal bg3 = new BigDecimal(salesBasicPo.getNowintegral());  //积分消费
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		
		SalesBasicPo fspo = new SalesBasicPo();
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			CustomerInfoPo tfcpo = new CustomerInfoPo();
			tfcpo.setSmecicustomerid(salesBasicPo2.getSsesbfcustomerid());
			CustomerInfoPo fcpo = frameSalesDao.getCustomerInfo(tfcpo);
			
			SalesBasicPo tfspo = new SalesBasicPo();
			tfspo.setSsesbcustomerid(fcpo.getSmecicustomerid());
			fspo = inTransitDetailsDao.getCustomerInfo(tfspo);
		}else{
			fspo = salesBasicPo2;
		}
		
		BigDecimal bg4 = new BigDecimal(fspo.getInintrgral()); // 原有积分
		
		//积分流水
		if(!"0".equals(salesBasicPo.getNowintegral())){
			IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
			integralAddandSubPo.setSmeasuuid(uuid.generate());
			integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
			integralAddandSubPo.setSmeasyintegral(bg4.toString());
			integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
			if(Float.parseFloat(bg3.toString()) > 0){
				integralAddandSubPo.setSmeascintegral("-"+bg3.toString());
			}else{
				integralAddandSubPo.setSmeascintegral(Math.abs(Float.parseFloat(bg3.toString()))+"");
			}
			integralAddandSubPo.setSmeasxintegral(bg4.subtract(bg3).toString());
			integralAddandSubPo.setSmeasaddorsub("3");
			integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
			integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());	
			
			if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
				integralAddandSubPo.setSmeasfcustomerid(salesBasicPo2.getSsesbcustomerid());
			}
			
			integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
			/**
			 * 更新会员积分
			 */
			String addcount = "1";
			if(salesLogPos.get(0).getSseslpaymenttype().equals("6") || salesLogPos.get(0).getSseslpaymenttype().equals("7")||salesLogPos.get(0).getSseslpaymenttype().equals("8") || salesLogPos.get(0).getSseslpaymenttype().equals("10")){
				addcount = "0";
				salesBasicPo.setSsesbsalesid(salesBasicPo2.getSsesbcustomerid());
			}
			guitarManagementDao.updateCustomerIntegralNew(salesBasicPo.getSsesbsalesid(),integralAddandSubPo.getSmeascintegral(),addcount,salesBasicPo.getSsesbsalesvalue(),salesBasicPo2.getSsesbfcustomerid());
		}
		
		
		guitarManagementDao.deleteSalesLog(salesLogPos.get(0));
		//新增付款记录
		for(int i=0; i<salesLogPos.size(); i++){
			if(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))>0){
				guitarManagementDao.insertSalesLog(salesLogPos.get(i));
			}
		}
    }
	/**
	 * 插入salesLog信息
	 * @param salesBasicPo
	 * @param salesLogPos
	 * @param logPo
	 */
	public void insertPayType2(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist){
		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState(couponPo);
			}
		}
		BigDecimal bg3 = new BigDecimal(salesBasicPo.getNowintegral());  //积分消费
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		
		SalesBasicPo fspo = new SalesBasicPo();
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			CustomerInfoPo tfcpo = new CustomerInfoPo();
			tfcpo.setSmecicustomerid(salesBasicPo2.getSsesbfcustomerid());
			CustomerInfoPo fcpo = frameSalesDao.getCustomerInfo(tfcpo);
			
			SalesBasicPo tfspo = new SalesBasicPo();
			tfspo.setSsesbcustomerid(fcpo.getSmecicustomerid());
			fspo = inTransitDetailsDao.getCustomerInfo(tfspo);
			fspo.setSsesbsalesid(salesBasicPo2.getSsesbsalesid());
		}else{
			fspo = salesBasicPo2;
		}
		
		BigDecimal bg4 = new BigDecimal(fspo.getInintrgral()); // 原有积分
		
		//积分流水
		if(!"0".equals(salesBasicPo.getNowintegral())){
			IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
			integralAddandSubPo.setSmeasuuid(uuid.generate());
			integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
			integralAddandSubPo.setSmeasyintegral(bg4.toString());
			integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
			integralAddandSubPo.setSmeascintegral(bg3.toString());
			integralAddandSubPo.setSmeasxintegral(bg4.add(bg3).toString());
			integralAddandSubPo.setSmeasaddorsub("4");
			integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
			integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());		
			
			if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
				integralAddandSubPo.setSmeasfcustomerid(salesBasicPo2.getSsesbcustomerid());
			}
			
			integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
			/**
			 * 更新会员积分
			 */
			String addcount = "1";
			if(salesLogPos.get(0).getSseslpaymenttype().equals("6") || salesLogPos.get(0).getSseslpaymenttype().equals("7")||salesLogPos.get(0).getSseslpaymenttype().equals("8") || salesLogPos.get(0).getSseslpaymenttype().equals("10")){
				addcount = "0";
				salesBasicPo.setSsesbsalesid(salesBasicPo2.getSsesbcustomerid());
			}
			guitarManagementDao.updateCustomerIntegralNew(salesBasicPo.getSsesbsalesid(),integralAddandSubPo.getSmeascintegral(),addcount,salesBasicPo.getSsesbsalesvalue(),salesBasicPo2.getSsesbfcustomerid());
		}
		
		
		
		//新增付款记录
		for(int i=0; i<salesLogPos.size(); i++){
			if(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))>0){
				guitarManagementDao.insertSalesLog(salesLogPos.get(i));
			}
		}
    }
	/**
	 * 插入salesLog信息
	 * @param salesBasicPo
	 * @param salesLogPos
	 * @param logPo
	 */
	public void insertPayType3(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist){

		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState2(couponPo);
			}
		}
		BigDecimal bg3 = new BigDecimal(salesBasicPo.getNowintegral());  //积分消费
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		
		SalesBasicPo fspo = new SalesBasicPo();
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			CustomerInfoPo tfcpo = new CustomerInfoPo();
			tfcpo.setSmecicustomerid(salesBasicPo2.getSsesbfcustomerid());
			CustomerInfoPo fcpo = frameSalesDao.getCustomerInfo(tfcpo);
			
			SalesBasicPo tfspo = new SalesBasicPo();
			tfspo.setSsesbcustomerid(fcpo.getSmecicustomerid());
			fspo = inTransitDetailsDao.getCustomerInfo(tfspo);
		}else{
			fspo = salesBasicPo2;
		}
		
		BigDecimal bg4 = new BigDecimal(fspo.getInintrgral()); // 原有积分
		
		//积分流水
		if(!"0".equals(salesBasicPo.getNowintegral())){
			IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
			integralAddandSubPo.setSmeasuuid(uuid.generate());
			integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
			integralAddandSubPo.setSmeasyintegral(bg4.toString());
			integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
			if(Float.parseFloat(bg3.toString()) > 0){
				integralAddandSubPo.setSmeascintegral("-"+bg3.toString());
			}else{
				integralAddandSubPo.setSmeascintegral(Math.abs(Float.parseFloat(bg3.toString()))+"");
			}
			integralAddandSubPo.setSmeasxintegral(bg4.subtract(bg3).toString());
			integralAddandSubPo.setSmeasaddorsub("4");
			integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
			integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());		
			
			if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
				integralAddandSubPo.setSmeasfcustomerid(salesBasicPo2.getSsesbcustomerid());
			}
			
			integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
			/**
			 * 更新会员积分
			 */
			String addcount = "1";
			if(salesLogPos.get(0).getSseslpaymenttype().equals("6") || salesLogPos.get(0).getSseslpaymenttype().equals("7")||salesLogPos.get(0).getSseslpaymenttype().equals("8") || salesLogPos.get(0).getSseslpaymenttype().equals("10")){
				addcount = "0";
				salesBasicPo.setSsesbsalesid(salesBasicPo2.getSsesbcustomerid());
			}
			guitarManagementDao.updateCustomerIntegralNew(salesBasicPo.getSsesbsalesid(),integralAddandSubPo.getSmeascintegral(),addcount,salesBasicPo.getSsesbsalesvalue(),salesBasicPo2.getSsesbfcustomerid());
		}
		
		
		
		//新增付款记录
		guitarManagementDao.deleteSalesLog(salesLogPos.get(0));
		
		for(int i=0; i<salesLogPos.size(); i++){
			if(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))>0){
				guitarManagementDao.insertSalesLog(salesLogPos.get(i));
			}
		}
    }
	/**
	 * 自动调拨（从门店出仓配置的仓位到门店仓位）
	 */
	private void autoAllocationToStore(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailList,String billID,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo,WarehouseConfigurationPo cpo){
			
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		List<String> stockList = new ArrayList<String>();              //出仓仓位的集合
		String secondStock = "";             //当前商品的出仓仓位
		String tbillid = "";                 //临时调拨单号
		
		if (Utility.getName(wpo.getBwhid()).equals("")){
			return;
		}
		
		boolean flag = false;
		if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") && !Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0")){
			flag = true;
		}
		
		for (SalesDetailPo po : salesDetailList){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));
			
			if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(po.getSsesdstockid())) || Utility.getName(po.getSsesdstockid()).equals("") || Utility.getName(po.getSsesditemid()).trim().equals("")){
				continue;
			}

			secondStock = Utility.getName(po.getSsesdstockid());
			
			if (!stockList.contains(secondStock) && !goodsInfoPo.getBgisupplierid().equals("ZZ")){
				
				tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();				
				
				InventoryPo inventoryPo=new InventoryPo();
				inventoryPo.setCstiinstockid(Utility.getName(wpo.getBwhid()));		//门店仓
				inventoryPo.setCstioutstockid(Utility.getName(po.getSsesdstockid())); //出仓仓位配置的仓位	
				inventoryPo.setCstibillid(tbillid);
				inventoryPo.setCstibilltypeid("4");
				
				inventoryPo.setCstidepartmentid(inTransitPo.getSseitdepartment());  //结款部门
				inventoryPo.setCsticreateperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstiauditperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstisourcebillid(billID);      //配镜单号
				inventoryPo.setCstiremark("门店结款自动调拨");
				inventoryPo.setCstigoodscategory("24");       //特殊标志,24标识门店结款自动调拨
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
				inventoryEntryPo.setCstieinstockid(Utility.getName(wpo.getBwhid()));
				inventoryEntryPo.setCstieoutstockid(Utility.getName(po.getSsesdstockid()));
				inventoryEntryPo.setCstiebarcode(Utility.getName(po.getSsesditemid()));
				inventoryEntryPo.setCstieoutstorageflag("1");
				inventoryEntryPo.setCstieremark("门店结款");
				inventoryEntryPo.setCstieautoallocationflag("4");
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
			
			//门店仓位增加库存
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
			//出仓配置的减少库存 
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
			stockID = po.getCstieinstockid();
			po.setCstieinstockid(po.getCstieoutstockid());
			po.setCstieoutstockid(stockID);
			
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);

			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
		}
		
	}	
	
	public void insertIntegralExchange(SystemParameterPo systemParameterPo,IntegralExchangePo integralExchangePo,List<IntegralExchangeEntryPo> integralExchangeEntryPolist,LogisticsLogPo logPo) {
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(integralExchangePo.getFildepartmentid());
		WarehousePo wpo = warehouseDao.getWarehousePo(departmentsPo);
		
		 //计算积分消费总数
		BigDecimal subjftotal = new BigDecimal(0);
		for(int i=0; i<integralExchangeEntryPolist.size(); i++){
			BigDecimal bg2 = new BigDecimal(integralExchangeEntryPolist.get(i).getFileintegralCount());
			if(bg2.intValue() > 0){
				subjftotal = subjftotal.add(bg2);
			}
		}
		subjftotal=subjftotal.setScale(0, BigDecimal.ROUND_HALF_UP);
		BigDecimal bg4 = new BigDecimal(integralExchangePo.getFilintegralsum()); // 原有积分
		
		integralExchangePo.setFilintegralCount("-"+subjftotal.toString());
		integralExchangePo.setFilintegralsum(bg4.subtract(subjftotal).toString());
		
		guitarManagementDao.insertIntegralExchange(integralExchangePo);
		guitarManagementDao.updateCustomerIntegral(integralExchangePo.getFilmemberid(),subjftotal.toString());
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		for (int i = 0; i < integralExchangeEntryPolist.size(); i++){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(integralExchangeEntryPolist.get(i).getFilegoodsid()));
			
			nottaxrateamount = new BigDecimal(goodsInfoPo.getBginottaxrate());
			costpriceamount = new BigDecimal(goodsInfoPo.getBgicostprice());
			goodsNum = new BigDecimal(integralExchangeEntryPolist.get(i).getFilegoodsnumber());
			
			nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
			
			integralExchangeEntryPolist.get(i).setFilegoodavgnottaxrate(Utility.getName(goodsInfoPo.getBgiaveragenotnaxrate()));
			integralExchangeEntryPolist.get(i).setFilegoodscostprice(Utility.getName(goodsInfoPo.getBgicostprice()));
			integralExchangeEntryPolist.get(i).setFilegoodscostpriceamount(Utility.getName(costpriceamount.toString()));
			integralExchangeEntryPolist.get(i).setFilegoodsnottaxrate(Utility.getName(goodsInfoPo.getBginottaxrate()));
			integralExchangeEntryPolist.get(i).setFilegoodsretailprice(Utility.getName(goodsInfoPo.getBgiretailprice()));
			integralExchangeEntryPolist.get(i).setFilegoodstaxamount(Utility.getName(taxamount.toString()));
			integralExchangeEntryPolist.get(i).setFilegoodstaxrate(Utility.getName(goodsInfoPo.getBgitaxrate()));
			integralExchangeEntryPolist.get(i).setFilegoodsnottaxrateamount(Utility.getName(nottaxrateamount.toString()));			
			integralExchangeEntryPolist.get(i).setFileoutstock(Utility.getName(integralExchangePo.getFilstock()));
			integralExchangeEntryPolist.get(i).setFileinstock(Utility.getName(integralExchangePo.getFilinstock()));
		}
		
		String bwhid = "";
		
		//自动调拨至门店仓
		if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
			bwhid = Utility.getName(wpo.getBwhid());
			exchangeGoodsAutoAllocationToStore(integralExchangePo,integralExchangeEntryPolist,wpo);		
		}
		
		
		for(int i=0; i<integralExchangeEntryPolist.size(); i++){
			guitarManagementDao.insertIntegralExchangeEntry(integralExchangeEntryPolist.get(i));
		
			// 商品库存当月库存变更表
			StrogeChangePo changePo = new StrogeChangePo();
			changePo.setCshscgoodsid(integralExchangeEntryPolist.get(i).getFilegoodsid());
			changePo.setCshscgoodsbarcode(integralExchangeEntryPolist.get(i).getFilegoodscode());
			changePo.setCshscstockid(bwhid.equals("") ? integralExchangeEntryPolist.get(i).getFileoutstock() : bwhid);  // 门店仓
			changePo.setCshscgoodsquantity("-"+integralExchangeEntryPolist.get(i).getFilegoodsnumber());
			changePo.setCshsccostprice("0.00");
			changePo.setCshscnottaxrate("0.00 ");
			changePo.setCshscchangeid(integralExchangePo.getFiluuid());
			changePo.setCshscguaranteeperiod("");
			changePo.setCshscBatch("");
			
			strogeChangeDao.insertStrogeChange(changePo);
			strogeChangeDao.insertStrogeChangeLog(changePo,integralExchangeEntryPolist.get(i).getFilegoodscode());// 商品库存当月库存变更表
			strogeChangeDao.insertStrogeChangeLogTemp(changePo,integralExchangeEntryPolist.get(i).getFilegoodscode());// 商品库存当月库存变更表
		}
	}
	
	/**
	 * 积分兑换商品自动调拨至门店仓
	 */
	private void exchangeGoodsAutoAllocationToStore(IntegralExchangePo integralExchangePo,List<IntegralExchangeEntryPo> integralExchangeEntryPolist,WarehousePo wpo){
		
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		String tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();;                 //临时调拨单号
		
		if (Utility.getName(wpo.getBwhid()).equals("") || Utility.getName(wpo.getBwhid()).equals(Utility.getName(integralExchangePo.getFilstock())) || Utility.getName(integralExchangePo.getFilstock()).equals("") ){
			return;
		}
		
		InventoryPo inventoryPo=new InventoryPo();
		inventoryPo.setCstiinstockid(Utility.getName(wpo.getBwhid()));		//门店仓
		inventoryPo.setCstioutstockid(Utility.getName(integralExchangePo.getFilstock())); //出仓仓位配置的仓位	
		inventoryPo.setCstibillid(tbillid);
		inventoryPo.setCstibilltypeid("4");		
		inventoryPo.setCstidepartmentid(integralExchangePo.getFildepartmentid());  //积分兑换部门
		inventoryPo.setCsticreateperson(integralExchangePo.getFilpersonid());
		inventoryPo.setCstiauditperson(integralExchangePo.getFilpersonid());
		inventoryPo.setCstisourcebillid(integralExchangePo.getFiluuid());      //积分兑换单号
		inventoryPo.setCstiremark("门店积分兑换自动调拨");
		inventoryPo.setCstigoodscategory("26");       //特殊标志
		inventoryPo.setCstifinanceauditperson(integralExchangePo.getFilpersonid());
		inventoryPo.setCstifinanceauditstate("1");
		
		inventoryList.add(inventoryPo);
		
		for (IntegralExchangeEntryPo po : integralExchangeEntryPolist){
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(tbillid);
			inventoryEntryPo.setCstiegoodsid(po.getFilegoodsid());
			inventoryEntryPo.setCstiegoodsquantity(po.getFilegoodsnumber());
			inventoryEntryPo.setCstienottaxrate(po.getFilegoodsnottaxrate());
			inventoryEntryPo.setCstienottaxrateamount(po.getFilegoodsnottaxrateamount());
			inventoryEntryPo.setCstietaxrate(po.getFilegoodstaxrate());
			inventoryEntryPo.setCstiecostprice(po.getFilegoodscostprice());
			inventoryEntryPo.setCstiecostpriceamount(po.getFilegoodscostpriceamount());
			inventoryEntryPo.setCstietaxamount(po.getFilegoodstaxamount());
			inventoryEntryPo.setCstieinstockid(Utility.getName(wpo.getBwhid()));   // 门店仓
		    inventoryEntryPo.setCstieoutstockid(Utility.getName(integralExchangePo.getFilstock()));  //出仓
			inventoryEntryPo.setCstiebarcode(Utility.getName(po.getFilegoodscode())+"00000000");
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstieremark("门店积分兑换自动调拨");
			inventoryEntryPo.setCstieautoallocationflag("5");
			inventoryEntryPo.setCstiesalesbillid(integralExchangePo.getFiluuid());
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		if (inventoryEntryList.size() > 0){
			for (InventoryPo po : inventoryList){
				spectaclesMaterialsDao.inertAutoAllocationToStore(po);
				spectaclesMaterialsDao.inertAutoAllocationBillToStore(po);
			}
		}
		
		String stockID = null;
		for (InventoryEntryPo po : inventoryEntryList){
			
			spectaclesMaterialsDao.inertAutoAllocationEntryToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBarcodeToStore(po);

			spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBillBarcodeToStore(po);
			
			//门店仓位增加库存
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
			//出仓配置的减少库存 
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
			stockID = po.getCstieinstockid();
			po.setCstieinstockid(po.getCstieoutstockid());
			po.setCstieoutstockid(stockID);
			
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
		}
		
	}
	
	public void deleteGuitarManagement(String salesID,LogisticsLogPo logPo) {
		
	    //删除在途库存的商品
		List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesID,"out","0");
		if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
			for (InTransitStorageEntryPo po : inTransitStorageEntryList){
				guitarManagementDao.deleteInTransitStroge(po);
			}
		}
		//折扣卡加1
		List<SalesDetailPo> vipcardlist=guitarManagementDao.getVipCardList(salesID);
        for(SalesDetailPo vipcardPo:vipcardlist){
        	frameSalesDao.updateVipCardSub(vipcardPo.getSsesdvipcard());
        }
		
		guitarManagementDao.deleteGuitarManagement(salesID);            //删除销售信息
		guitarManagementDao.deleteGuitarManagementDetail(salesID);      //删除销售商品
		
		guitarManagementDao.deleteSalesBillAdditionalDetail(salesID);   //删除附加费
		guitarManagementDao.deleteSalesBillInTransitDetail(salesID);    //删除在途信息
		guitarManagementDao.deleteSalesBillProcessDetail(salesID);      //删除加工要求
		guitarManagementDao.deleteSalesForHISBill(salesID);      //删除HIS收费确认表
		
		logisticsLogDao.insertLog(logPo);  //新增日志		
	}
	
	/**
	 * 取得结款记录表Po
	 */
	public SalesLogPo getSalesLog(SalesLogPo salesLogPo){
		return guitarManagementDao.getSalesLog(salesLogPo);
	}
	/**
	 * 销售日志插入
	 * @param salesLogPo
	 */
	public void insertSalesLog(SalesLogPo salesLogPo){
		SalesLogPo po = guitarManagementDao.getSalesLog(salesLogPo);
		if("".equals(Utility.getName(po.getSseslorderby()))){
			salesLogPo.setSseslorderby("1");
		}else{
			salesLogPo.setSseslorderby((Integer.parseInt(po.getSseslorderby())+1)+"");
		}
		guitarManagementDao.insertSalesLog(salesLogPo);
	}
	
	public int getIntegralExchangeCount(IntegralExchangePo po) {
		
		return guitarManagementDao.getIntegralExchangeCount(po);
	}
	public List<IntegralExchangePo> getIntegralExchangeList(IntegralExchangePo po, int start,
			int size) {
		
		return guitarManagementDao.getIntegralExchangeList(po, start, size);
	}
	
	public IntegralExchangePo getIntegralExchangeDetail(IntegralExchangePo po) {
		
		return guitarManagementDao.getIntegralExchangeDetail(po);
	}
	
	public List<IntegralExchangeEntryPo> getIntegralExchangeDetailEntry(IntegralExchangePo po) {
		
		return guitarManagementDao.getIntegralExchangeDetailEntry(po);
	}
	
	/**
	 * 结款时判断配镜单是否存在
	 */
	public int getSalesBillCount(String salesID){
		return guitarManagementDao.getSalesBillCount(salesID);
	}
	
	/**
	 * 结款、隐形配送、配镜发料验证负库存	 * 
	 * salesID: 配镜单号
	 * systemParameterPo ：系统参数设定
	 * flag : 1:结款  2：隐形配送  3：配镜发料
	 * salesDetailList：销售商品信息
	 * 
	 * 返回值小于0则表示库存不足
	 */
	public int getNegativeStockBySalesGoods(String salesID,SystemParameterPo systemParameterPo,String flag,List<SalesDetailPo> salesDetailList ){
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		
		if ("1".equals(Utility.getName(flag)) || "2".equals(Utility.getName(flag))){
			SalesDetailPo salesDetailPo = new SalesDetailPo();
			salesDetailPo.setSsesdsalesid(salesID);
			if ("1".equals(Utility.getName(flag))){
				salesDetailPo.setSsesdcommoditiesflag("1,2,4,5,6,7,8,9");
				salesDetailPo.setSsesdiscustomize("0");
			}
			if ("2".equals(Utility.getName(flag))){
				salesDetailPo.setSsesdcommoditiesflag("4");
				salesDetailPo.setSsesdiscustomize("D");
			}
			salesDetailList = inTransitDetailsDao.getSalesGoodsInfo2(salesDetailPo);  //获取销售商品
		}
     
		if (salesDetailList == null){
			return -1;
		}
		
		int goodsNums = 0;
		InventoryEntryPo inventoryEntryPo = null;
		
		if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
	        for (SalesDetailPo salesDetailPo : salesDetailList){
	        	
			 	String goodsID = salesDetailPo.getSsesdsalesitemid();
			 	if(!"zz".equals(goodsID.substring(2,4).toLowerCase())){
				 	inventoryEntryPo = new InventoryEntryPo();
				 	inventoryEntryPo.setCstiebillid(salesID);
				 	inventoryEntryPo.setCstiegoodsid(salesDetailPo.getSsesdsalesitemid());
				 	inventoryEntryPo.setCstiebarcode(salesDetailPo.getSsesditemid());
				 	inventoryEntryPo.setCstieoutstockid(salesDetailPo.getSsesdstockid());
				 	
					if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!goodsID.substring(0,1).equals("4") && !goodsID.substring(0,1).equals("5"))){ //不用批号
						if("1".equals(salesDetailPo.getRksj())){
							goodsNums = inTransitDetailsDao.getStorageNumByNotBatch2(inventoryEntryPo);						
						}else{
							goodsNums = inTransitDetailsDao.getStorageNumByNotBatch(inventoryEntryPo);	
						}

					}
					if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (goodsID.substring(0,1).equals("4") || goodsID.substring(0,1).equals("5"))){ //使用批号
						goodsNums = inTransitDetailsDao.getStorageNumByBatch(inventoryEntryPo);
					}
					
					sNum = new BigDecimal(goodsNums);
					dNum = new BigDecimal(salesDetailPo.getSsesdnumber());
					sNum = sNum.subtract(dNum);
					
					if (sNum.intValue() < 0){
						return -1;
					}
					
					inventoryEntryPo = null;
					sNum = null;
					dNum = null;
			 	}
	        }
		}
		if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
			for (SalesDetailPo salesDetailPo : salesDetailList){
				if(!"zz".equals(salesDetailPo.getSsesdsalesitemid().substring(2,4).toLowerCase())){
					inventoryEntryPo = new InventoryEntryPo();
					inventoryEntryPo.setCstiebillid(salesID);
				 	inventoryEntryPo.setCstiegoodsid(salesDetailPo.getSsesdsalesitemid());
				 	inventoryEntryPo.setCstieoutstockid(salesDetailPo.getSsesdstockid()); 
				 	
				 	goodsNums = inTransitDetailsDao.getStorageNumByGoodsID(inventoryEntryPo);	 	
					
					sNum = new BigDecimal(goodsNums);
					dNum = new BigDecimal(salesDetailPo.getSsesdnumber());
					sNum = sNum.subtract(dNum);
					
					if (sNum.intValue() < 0){
						return -1;
					}
					
					inventoryEntryPo = null;
					sNum = null;
					dNum = null;
				}
			}
			
		}
		
		return 1;
	}
	
	/**
	 * 更新实收金额
	 * @param po
	 */
	public void updateSalesValue(SalesBasicPo po,LogisticsLogPo logPo){
		guitarManagementDao.updateSalesValue(po);
		
		logisticsLogDao.insertLog(logPo);  //新增日志	
	}
	
	/**
	 * 获取现金金额
	 * @param po
	 */
	public List<SalesLogPo> selectCash(SalesBasicPo po){
		return guitarManagementDao.selectCash(po);
	}
	
	/**
	 * 获取积分
	 * @param po
	 */
	public List<SalesLogPo> selectCredit(SalesBasicPo po){
		return guitarManagementDao.selectCredit(po);
	}
	
	/**
	 * 获取银行卡
	 * @param po
	 */
	public List<SalesLogPo> selectBankCard(SalesBasicPo po){
		return guitarManagementDao.selectBankCard(po);
	}
	
	/**
	 * 获取储值卡
	 * @param po
	 */
	public List<SalesLogPo> selectPreCard(SalesBasicPo po){
		return guitarManagementDao.selectPreCard(po);
	}
	/**
	 * 获取代金券
	 * @param po
	 */
	public List<SalesLogPo> selectDjq(SalesBasicPo po){
		return guitarManagementDao.selectDjq(po);
	}
	/**
	 * 获取其他
	 * @param po
	 */
	public List<SalesLogPo> selectQt(SalesBasicPo po){
		return guitarManagementDao.selectQt(po);
	}
	
	/**
	 * 传递配镜单和中心挂号
	 * @param po
	 */
	public void insertSalesData_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception {

		this.insertSalesGutiar_Flysheet(po, epo, logPo);
		if (logPo != null){
			logPo.setsLogContent("传递挂号费!");
		}		
		this.insertRegistration_Flysheet(po, epo, logPo);

	}	
	
	/**
	 * 传递配镜单\中心挂号\重转石英
	 * @param po
	 */
	public void insertSalesDataAndQuartz_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception{

        this.insertSalesData_Flysheet(po, epo, logPo);
		
//        ModulePo modulePo = new ModulePo();
//        modulePo.setReportBgnDate(Utility.getName(po.getSsesbsalesdatestarttime()));
//        modulePo.setReportEndDate(Utility.getName(po.getSsesbsalesdateendtime()));
//
//        // 汇总商品库存周转率表
//        modulePo.setReportID("spkczzl");        
//        deleteReportQuartzLog(modulePo,epo);
//		
//		// 商品销售分析
//        modulePo.setReportID("rxsspmxbtj");
//        deleteReportQuartzLog(modulePo,epo);
//		
//		// 日月销售门店汇总表
//        modulePo.setReportID("rxssplbhzb");      
//        deleteReportQuartzLog(modulePo,epo);
		
	}
	
	/**
	 * 重新生成报表时英的数据
	 * @return
	 */
	private void deleteReportQuartzLog(ModulePo po,ExternalAccountParameterPo epo) throws Exception{
		
		String bgnDate = Utility.getName(po.getReportBgnDate());  //起始日期
		String endDate = Utility.getName(po.getReportEndDate());  //截止日期		

		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		while (bgnDate.compareToIgnoreCase(endDate) <= 0){
			
			ModulePo tpo = new ModulePo();
			tpo.setReportDate(bgnDate);
			tpo.setReportID(Utility.getName(po.getReportID()));			

			guitarManagementDao.deleteReportQuartzLog(tpo, epo);
			
			cal.setTime(tempDate.parse(bgnDate));
			cal.add(Calendar.DATE,1);
			
			bgnDate = tempDate.format(cal.getTime());
		}
		
	}	
	
	/**
	 * 传递配镜单
	 * @param po
	 */
	public void insertSalesGutiar_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception {

		int xjcount = 0;     // 仅用现金结款
		int ylkcount = 0;    // 使用银联卡、网上支付结款
		List<SalesBasicPo> poList = guitarManagementDao.getFlysheetSalesBillList(po,epo);   // 获取配镜单号

	    for (SalesBasicPo spo : poList){
		
			xjcount = guitarManagementDao.getFlysheetSalesBillByXj(spo);
			ylkcount = guitarManagementDao.getFlysheetSalesBillByBank(spo,epo);
			
			if (xjcount > 0){    // 排除储值卡和积分
				continue;
			}else{
				if (ylkcount > 0){  // 排除非银联卡、网上支付
					continue;
				}
			}
		
			guitarManagementDao.deleteFlysheetSalesBill(spo,epo); 

			// 配镜单信息	
			guitarManagementDao.insertFlysheetSalesBill(spo,epo);
			// 销售商品明细
			guitarManagementDao.insertFlysheetSalesBillEntry(spo,epo); 
			// 付款记录	
			guitarManagementDao.insertFlysheetSalesLog(spo,epo);
			// 在途信息
			guitarManagementDao.insertFlysheetSalesBillInTransit(spo,epo);
			// 附加费
			guitarManagementDao.insertFlysheetSalesAdditionalCDetail(spo,epo);
			// 加工要求
			guitarManagementDao.insertFlysheetSalesSpecialPDetail(spo,epo);
			
			if (guitarManagementDao.getFlysheetSalesBillByCurrent(spo) > 0){   // 查看当前配镜单是否是当日结款或退款
				// 当日配镜单信息
				guitarManagementDao.insertFlysheetCurrentSalesBill(spo,epo);
				// 当日销售商品明细	
				guitarManagementDao.insertFlysheetCurrentSalesBillEntry(spo,epo);
			}
			
			// 当月库存
			guitarManagementDao.insertFlysheetCurrentStorageChange(spo,epo);
			// 库存流水
			guitarManagementDao.insertFlysheetStorageLog(spo,epo);
			
// 退款记录---------------------------------------------------------------------------------------------
			if (guitarManagementDao.getFlysheetSalesBillByWithdraw(spo) > 0){   // 查看当前配镜单是否是退单
				// 付款记录	
				guitarManagementDao.insertFlysheetSalesLog_Withdraw(spo,epo);
				// 当月库存
				guitarManagementDao.insertFlysheetCurrentStorageChange_Withdraw(spo,epo);
				// 库存流水
				guitarManagementDao.insertFlysheetStorageLog_Withdraw(spo,epo);
			}
			
			//更新汇总采购单据的标识位
			guitarManagementDao.updateFlysheetCollectFlag(spo,epo);
			
	    }

	    if (logPo != null){
		    logisticsLogDao.insertLog(logPo);  //新增日志	
	    }

	    
	}
	
	/**
	 * 传递中心挂号费
	 * @param po
	 */
	public void insertRegistration_Flysheet(SalesBasicPo po,ExternalAccountParameterPo epo,LogisticsLogPo logPo) throws Exception {

		int xjcount = 0;     // 仅用现金结款
		int ylkcount = 0;    // 使用银联卡结款
		RegisteredDetailsPo rpo = new RegisteredDetailsPo();
		rpo.setScrrdcasherbgndate(Utility.getName(po.getSsesbsalesdatestarttime()));
		rpo.setScrrdcasherenddate(Utility.getName(po.getSsesbsalesdateendtime()));
		
		List<RegisteredDetailsPo> poList = guitarManagementDao.getFlysheetRegistrationList(rpo,epo);

	    for (RegisteredDetailsPo rdpo : poList){
		
			xjcount = guitarManagementDao.getFlysheetRegistrationByXj(rdpo);
			ylkcount = guitarManagementDao.getFlysheetRegistrationByBank(rdpo,epo);
			
			if (xjcount > 0){    // 排除储值卡和积分
				continue;
			}else{
				if (ylkcount > 0){  // 排除非银联卡
					continue;
				}
			}
		
			//删除中心挂号
			guitarManagementDao.deleteFlysheetRegistration(rdpo,epo); 

			// 导入挂号信息	
			guitarManagementDao.insertFlysheetRegistration(rdpo,epo);
			// 挂号费付款记录	
			guitarManagementDao.insertFlysheetRegistrationSalesLog(rdpo,epo);
			
	    }

	    if (logPo != null){
		    logisticsLogDao.insertLog(logPo);  //新增日志	
	    }

	    
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po, int start,int size){
		return guitarManagementDao.getWeiXinIntegralSelectList(po, start, size);
	}
	public void updateWeiXinIntegralSelect(WeiXinIntegralSelectPo po){
		guitarManagementDao.updateWeiXinIntegralSelect(po);
	}
	public int getWeiXinIntegralSelectCount(WeiXinIntegralSelectPo po) {
		return guitarManagementDao.getWeiXinIntegralSelectCount(po);
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectList(WeiXinIntegralSelectPo po) {
		return guitarManagementDao.getWeiXinIntegralSelectList(po);
	}
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelect(WeiXinIntegralSelectPo po){
		return guitarManagementDao.getWeiXinIntegralSelect(po);
	}
	public void insertWieIntegralExchange(WeiXinIntegralSelectPo po,IntegralExchangePo integralExchangePo,List<IntegralExchangeEntryPo> integralExchangeEntryPolist,LogisticsLogPo logPo) {
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(integralExchangePo.getFildepartmentid());
		WarehousePo wpo = warehouseDao.getWarehousePo(departmentsPo);
		
		 //计算积分消费总数
		BigDecimal subjftotal = new BigDecimal(0);
		for(int i=0; i<integralExchangeEntryPolist.size(); i++){
			BigDecimal bg2 = new BigDecimal(integralExchangeEntryPolist.get(i).getFileintegralCount());
			if(bg2.intValue() > 0){
				subjftotal = subjftotal.add(bg2);
			}
		}
		subjftotal=subjftotal.setScale(0, BigDecimal.ROUND_HALF_UP);
		BigDecimal bg4 = new BigDecimal(integralExchangePo.getFilintegralsum()); // 原有积分
		
		integralExchangePo.setFilintegralCount("-"+subjftotal.toString());
		integralExchangePo.setFilintegralsum(bg4.subtract(subjftotal).toString());
		
		guitarManagementDao.insertIntegralExchange(integralExchangePo);
		//guitarManagementDao.updateCustomerIntegral(integralExchangePo.getFilmemberid(),subjftotal.toString());
		
		guitarManagementDao.updateWeiXinIntegralSelect(po);
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		for (int i = 0; i < integralExchangeEntryPolist.size(); i++){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(integralExchangeEntryPolist.get(i).getFilegoodsid()));
			
			nottaxrateamount = new BigDecimal(goodsInfoPo.getBginottaxrate());
			costpriceamount = new BigDecimal(goodsInfoPo.getBgicostprice());
			goodsNum = new BigDecimal(integralExchangeEntryPolist.get(i).getFilegoodsnumber());
			
			nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
			
			integralExchangeEntryPolist.get(i).setFilegoodavgnottaxrate(Utility.getName(goodsInfoPo.getBgiaveragenotnaxrate()));
			integralExchangeEntryPolist.get(i).setFilegoodscostprice(Utility.getName(goodsInfoPo.getBgicostprice()));
			integralExchangeEntryPolist.get(i).setFilegoodscostpriceamount(Utility.getName(costpriceamount.toString()));
			integralExchangeEntryPolist.get(i).setFilegoodsnottaxrate(Utility.getName(goodsInfoPo.getBginottaxrate()));
			integralExchangeEntryPolist.get(i).setFilegoodsretailprice(Utility.getName(goodsInfoPo.getBgiretailprice()));
			integralExchangeEntryPolist.get(i).setFilegoodstaxamount(Utility.getName(taxamount.toString()));
			integralExchangeEntryPolist.get(i).setFilegoodstaxrate(Utility.getName(goodsInfoPo.getBgitaxrate()));
			integralExchangeEntryPolist.get(i).setFilegoodsnottaxrateamount(Utility.getName(nottaxrateamount.toString()));			
			integralExchangeEntryPolist.get(i).setFileoutstock(Utility.getName(integralExchangePo.getFilstock()));
			integralExchangeEntryPolist.get(i).setFileinstock(Utility.getName(integralExchangePo.getFilinstock()));
		}
		
		//自动调拨至门店仓
		exchangeGoodsAutoAllocationToStore(integralExchangePo,integralExchangeEntryPolist,wpo);		
		
		for(int i=0; i<integralExchangeEntryPolist.size(); i++){
			guitarManagementDao.insertIntegralExchangeEntry(integralExchangeEntryPolist.get(i));
		
			// 商品库存当月库存变更表
			StrogeChangePo changePo = new StrogeChangePo();
			changePo.setCshscgoodsid(integralExchangeEntryPolist.get(i).getFilegoodsid());
			changePo.setCshscgoodsbarcode(integralExchangeEntryPolist.get(i).getFilegoodscode());
			changePo.setCshscstockid(Utility.getName(wpo.getBwhid()));  // 门店仓
			changePo.setCshscgoodsquantity("-"+integralExchangeEntryPolist.get(i).getFilegoodsnumber());
			changePo.setCshsccostprice("0.00");
			changePo.setCshscnottaxrate("0.00 ");
			changePo.setCshscchangeid(integralExchangePo.getFiluuid());
			changePo.setCshscguaranteeperiod("");
			changePo.setCshscBatch("");
			
			strogeChangeDao.insertStrogeChange(changePo);
			strogeChangeDao.insertStrogeChangeLog(changePo,integralExchangeEntryPolist.get(i).getFilegoodscode()+"00000000");// 商品库存当月库存变更表
			strogeChangeDao.insertStrogeChangeLogTemp(changePo,integralExchangeEntryPolist.get(i).getFilegoodscode()+"00000000");// 商品库存当月库存变更表
		}
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public SalesBasicPo getSalesBasicsNoFinished(SalesBasicPo salesBasicPo) {
		return guitarManagementDao.getSalesBasicsNoFinished(salesBasicPo);
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */	
	public CustomerInfoPo getCustmorInfoNoFinished(CustomerInfoPo customerInfoPo) {
		return guitarManagementDao.getCustmorInfoNoFinished(customerInfoPo);
	}
	
	/**
	 * 查看未结款的单子
	 */
	public List<SalesBasicPo> getSalesBasicNoFinished(SalesBasicPo salesBasicPo){
		return guitarManagementDao.getSalesBasicNoFinished(salesBasicPo);
	}
	
	private void getExecTime(String msg){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(msg + ":" + currMouthFirstDay.format(calendar.getTime()));
	}
	
}
