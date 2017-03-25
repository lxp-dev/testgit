/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.ArrearsDao;
import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.IntegralAddandSubDao;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.mgr.ArrearsMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinInviteFriendDao;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * @author Liuqian
 * 
 */
public class ArrearsMgrImpl implements ArrearsMgr {
	private LogisticsLogDao logisticsLogDao;
	private GuitarManagementDao guitarManagementDao;
	private SetMealDao setMealDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private IntegralAddandSubDao integralAddandSubDao;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private ChuzhikaDao chuzhikaDao;
	private CashCouponDao cashCouponDao;
	private FrameSalesDao frameSalesDao;
	private GuitarManagementMgr guitarManagementMgr;
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

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public FrameSalesDao getFrameSalesDao() {
		return frameSalesDao;
	}

	public void setFrameSalesDao(FrameSalesDao frameSalesDao) {
		this.frameSalesDao = frameSalesDao;
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

	public IntegralAddandSubDao getIntegralAddandSubDao() {
		return integralAddandSubDao;
	}

	public void setIntegralAddandSubDao(IntegralAddandSubDao integralAddandSubDao) {
		this.integralAddandSubDao = integralAddandSubDao;
	}

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public SetMealDao getSetMealDao() {
		return setMealDao;
	}

	public void setSetMealDao(SetMealDao setMealDao) {
		this.setMealDao = setMealDao;
	}

	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
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

	
	private ArrearsDao arrearsDao;
	
	public ArrearsDao getArrearsDao() {
		return arrearsDao;
	}

	public void setArrearsDao(ArrearsDao arrearsDao) {
		this.arrearsDao = arrearsDao;
	}

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {
		return arrearsDao.getCustomerInfo(po);
	}

	
	public List<SalesBasicPo> getArrears(SalesBasicPo salesBasicPo) {
		return arrearsDao.getArrears(salesBasicPo);
	}
	
	public void updateArrears(SalesBasicPo salesBasicPo,List<SalesLogPo> salesLogPos,List<ChuzhikaPo> czklist,List<CashCouponPo> djqlist,LogisticsLogPo logPo,WeixinInviteFriendLogPo weixinInviteFriendLogPo,SystemParameterPo systemParameterPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		arrearsDao.insertCustomizeTui(salesBasicPo.getSsesbsalesid());
		arrearsDao.updateArrears(salesBasicPo);
		
		//更改当日销售单
		arrearsDao.updateArrearsToday(salesBasicPo);
		
		for(int i=0; i<salesLogPos.size(); i++){
			if(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))>0){
			   guitarManagementDao.insertSalesLog(salesLogPos.get(i));
			}
		}
		
		SalesDetailPo detailPo = new SalesDetailPo();
		detailPo.setSsesdsalesid(salesBasicPo.getSsesbsalesid());		
		List<SalesDetailPo> detailPos = inTransitDetailsDao.getGoodsInfo(detailPo);
		
		BigDecimal jftotal = new BigDecimal(0);		
		BigDecimal bg = new BigDecimal(Utility.getName(salesBasicPo.getSsesbjfamount()).equals("") ? "0.00" : Utility.getName(salesBasicPo.getSsesbjfamount()));
		
		jftotal = jftotal.add(bg);
		jftotal=jftotal.setScale(2, BigDecimal.ROUND_HALF_UP);
	
		if(!"".equals(salesBasicPo.getNowintegral())){
			BigDecimal bg3 = new BigDecimal(salesBasicPo.getNowintegral());  //积分消费
			jftotal = jftotal.subtract(bg3);  // 商品累计积分-积分消费
		}
		
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfo(salesBasicPo);
		
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
		
		WeixinInviteFriendLogPo weixinpo = weiXinInviteFriendDao.selectWeiXinInviteFriendLogCheck(weixinInviteFriendLogPo);
		SalesBasicPo weixinfspo = inTransitDetailsDao.getCustomerInfo2(weixinpo.getWiflcustomerid()); 
		
		if(!"".equals(fspo.getInintrgral())){
			BigDecimal bg4 = new BigDecimal(fspo.getInintrgral());
			jftotal.add(bg4);
		}
		
		//积分流水
		IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
		integralAddandSubPo.setSmeasuuid(uuid.generate());
		integralAddandSubPo.setSmeasmemberid(fspo.getSsesbMemberId());
		integralAddandSubPo.setSmeasyintegral(fspo.getInintrgral());
		
		integralAddandSubPo.setSmeascintegral(jftotal.toString());
		integralAddandSubPo.setSmeasxintegral(jftotal.add(new BigDecimal(fspo.getInintrgral())).toString());	
		
		integralAddandSubPo.setSmeasdopersonid(salesBasicPo.getSsesbposid());
		integralAddandSubPo.setSmeassalesbill(salesBasicPo.getSsesbsalesid());
		integralAddandSubPo.setSmeasaddorsub("5");	
		integralAddandSubPo.setSmeascustomerid(fspo.getSsesbcustomerid());
		
		if(!"".equals(Utility.getName(salesBasicPo2.getSsesbfcustomerid()))){
			integralAddandSubPo.setSmeasfcustomerid(salesBasicPo2.getSsesbcustomerid());
		}
		
		integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
		
		if(!"".equals(Utility.getName(weixinpo.getWifltousername()))){
			if(!"1".equals(weixinpo.getWiflisconfirm())&& "0".equals(fspo.getSsesbsalescount())){
				ChuzhikaPo chuzhikaPo= chuzhikaMgr.selectChuzhikaJifenByCustomerID(weixinpo.getWiflcustomerid());
				if(!"".equals(Utility.getName(chuzhikaPo.getCstczkid()))){
					String CIntegral = Double.parseDouble(systemParameterPo.getFspexchangeintegral())*Double.parseDouble(salesBasicPo.getSsesbjfamount())+"";
					LogisticsLogPo czhlogPo = new LogisticsLogPo();
					czhlogPo.setsLogName(salesBasicPo.getSsesbposid());
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
		
		//储值卡流水
		if (czklist != null && czklist.size() != 0){
			for (ChuzhikaPo czkpo:czklist){
				BigDecimal bgc1 = new BigDecimal(czkpo.getCstczkjine());
				BigDecimal bgc2 = new BigDecimal(czkpo.getCstczkchongzhijine());
				ChuzhikaLogPo po=new ChuzhikaLogPo();
				po.setSmeasmemberid(salesBasicPo2.getSsesbMemberId());
				po.setSmeascustomerid(salesBasicPo2.getSsesbcustomerid());
				po.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				po.setSmeassalesbillid(salesBasicPo.getSsesbsalesid());
				po.setSmeaschuzhikaid(czkpo.getCstczkid());
					po.setSmeascintegral(czkpo.getCstczkchongzhijine());
					po.setSmeasxintegral(czkpo.getCstczkjine());
					po.setSmeasyintegral((bgc1.subtract(bgc2)).toString());	
					po.setSmeasaddorsub("5");	
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState(couponPo);
			}
		}
		/**
		 * 更新会员积分
		 */
		guitarManagementDao.updateCustomerIntegralNew(salesBasicPo.getSsesbsalesid(),jftotal.toString(),"1",salesBasicPo.getSsesbsalesvalue(),salesBasicPo2.getSsesbfcustomerid());
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
		guitarManagementMgr.insertSalerCashierRecord(detailPos,salesBasicPo2,"0","0","0",salesBasicPo2.getSsesbposid());
		
	}

	/**
	 * 获取当前收银员当天累计金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValues(SalesBasicPo salesBasicPo){
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){
			return arrearsDao.getArrearsValuesFinished(salesBasicPo);
        }		
		return arrearsDao.getArrearsValues(salesBasicPo);
	}
	/**
	 * 获取当前收银员当天累计实收金额
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getArrearsValuesToo(SalesBasicPo salesBasicPo){
		return arrearsDao.getArrearsValuesToo(salesBasicPo);
	}
}
