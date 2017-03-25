/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.RegisteredDao;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.mgr.RegisteredMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class RegisteredMgrImpl implements RegisteredMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private GuitarManagementMgr guitarManagementMgr; 
	private InTransitDetailsDao inTransitDetailsDao;
	private ChuzhikaDao chuzhikaDao;
	private GuitarManagementDao guitarManagementDao;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}

	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}

	public ChuzhikaDao getChuzhikaDao() {
		return chuzhikaDao;
	}

	public void setChuzhikaDao(ChuzhikaDao chuzhikaDao) {
		this.chuzhikaDao = chuzhikaDao;
	}

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	private RegisteredDao registeredDao;

	public RegisteredDao getRegisteredDao() {
		return registeredDao;
	}

	public void setRegisteredDao(RegisteredDao registeredDao) {
		this.registeredDao = registeredDao;
	}

	
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid) {
		// TODO Auto-generated method stub
		return registeredDao.getRegisteredDetails(customerid);
	}

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @param typeFlag:1:挂号;2:退挂号；
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid,String typeFlag){
		return registeredDao.getRegisteredDetails(customerid,typeFlag);
	}
	
	public List<RegisteredCategoryPo> getSelValue(String flag, String feeType) {
		// TODO Auto-generated method stub
		return registeredDao.getSelValue(flag, feeType);
	}
	
	/**
	 * 查询所有收费项目
	 */
	public List<RegisteredCategoryPo> getRepairsCostList(){
		return registeredDao.getRepairsCostList();
	}

	
	public void insertRegisteredDetails(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		for(int i=0; i<salesLogPos.size(); i++){
			salesLogPos.get(i).setSseslsalesid(detailsPos.get(0).getScrrddetailsid());
			if("7".equals(Utility.getName(salesLogPos.get(i).getSseslpaymenttype()))){
				salesLogPos.get(i).setSseslprice(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))+"");
				salesLogPos.get(i).setSseslintegralprice(Math.abs(Float.parseFloat(Utility.getNameTwoPoint(salesLogPos.get(i).getSseslintegralprice())))+"");
			}
		}
		
		guitarManagementMgr.insertPayType(salesBasicPo,salesLogPos,czklist,djqlist);
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		
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
				po.setSmeasaddorsub("7");
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
		
		
		for (RegisteredDetailsPo po : detailsPos) {
			if(po!=null){
				if (StringUtils.isEmpty(po.getScrrdid())) {
					registeredDao.insertRegisteredDetails(po);
				} else {
					registeredDao.updateRegisteredDetails(po);
				}
			}
		}
		
		// 新增付款记录（横向）
		SalesLogPo slpo = new SalesLogPo();
		slpo.setSsesluuid(uuid.generate());
		slpo.setSsesltype("2"); // 中心挂号
		
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
		
		guitarManagementDao.deleteSalesCrossLog(slpo);
		
		guitarManagementDao.updateSalesCashForm(slpo);

	}
	public void insertRegisteredDetails2(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		for(int i=0; i<salesLogPos.size(); i++){
			salesLogPos.get(i).setSseslsalesid(detailsPos.get(0).getScrrddetailsid());
			if("7".equals(Utility.getName(salesLogPos.get(i).getSseslpaymenttype()))){
				salesLogPos.get(i).setSseslprice(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))+"");
				salesLogPos.get(i).setSseslintegralprice(Math.abs(Float.parseFloat(Utility.getNameTwoPoint(salesLogPos.get(i).getSseslintegralprice())))+"");
			}
		}
		
		guitarManagementMgr.insertPayType3(salesBasicPo,salesLogPos,czklist,djqlist);
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		
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
				po.setSmeasaddorsub("9");
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
		
		
		for (RegisteredDetailsPo po : detailsPos) {
			if(po!=null){
				if (StringUtils.isEmpty(po.getScrrdid())) {
					registeredDao.insertRegisteredDetails(po);
				} else {
					registeredDao.updateRegisteredDetails(po);
				}
			}
		}
		
		// 新增付款记录（横向）
		SalesLogPo slpo = new SalesLogPo();
		slpo.setSsesluuid(uuid.generate());
		slpo.setSsesltype("2"); // 中心挂号
		
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
		
		guitarManagementDao.deleteSalesCrossLog(slpo);
		
		guitarManagementDao.updateSalesCashForm(slpo);

	}
	
	public void insertRepairsCostDetails(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0; i<salesLogPos.size(); i++){
			salesLogPos.get(i).setSseslsalesid(detailsPos.get(0).getScrrddetailsid());
			if("10".equals(Utility.getName(salesLogPos.get(i).getSseslpaymenttype()))){
				salesLogPos.get(i).setSseslprice(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))+"");
				salesLogPos.get(i).setSseslintegralprice(Math.abs(Float.parseFloat(Utility.getNameTwoPoint(salesLogPos.get(i).getSseslintegralprice())))+"");
			}
		}
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		//储值卡流水
		if (czklist != null && czklist.size() != 0){
			for (ChuzhikaPo czkpo:czklist){
				BigDecimal bgc1 = new BigDecimal(czkpo.getCstczkjine());
				BigDecimal bgc2 = new BigDecimal(czkpo.getCstczkchongzhijine());
				ChuzhikaLogPo po=new ChuzhikaLogPo();
				po.setSmeasmemberid(salesBasicPo2.getSsesbMemberId());
				po.setSmeascustomerid(salesBasicPo2.getSsesbcustomerid());
				po.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				po.setSmeassalesbillid(czkpo.getCstczkllinkbillid());
				po.setSmeaschuzhikaid(czkpo.getCstczkid());
				po.setSmeascintegral(czkpo.getCstczkchongzhijine());
				po.setSmeasxintegral(czkpo.getCstczkjine());
				po.setSmeasyintegral((bgc1.subtract(bgc2)).toString());	
				po.setSmeasaddorsub("8");
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
		guitarManagementMgr.insertPayType(salesBasicPo,salesLogPos,czklist,djqlist);
		
		for (RegisteredDetailsPo po : detailsPos) {
			registeredDao.insertRepairsCostDetails(po);
		}
		// 新增付款记录（横向）
		SalesLogPo slpo = new SalesLogPo();
		slpo.setSsesluuid(uuid.generate());
		slpo.setSsesltype("3"); // 中心挂号
		
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
	}
	public void insertRepairsCostDetails2(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0; i<salesLogPos.size(); i++){
			salesLogPos.get(i).setSseslsalesid(detailsPos.get(0).getScrrddetailsid());
			if("10".equals(Utility.getName(salesLogPos.get(i).getSseslpaymenttype()))){
				salesLogPos.get(i).setSseslprice(Math.abs(Float.parseFloat(salesLogPos.get(i).getSseslprice()))+"");
				salesLogPos.get(i).setSseslintegralprice(Math.abs(Float.parseFloat(Utility.getNameTwoPoint(salesLogPos.get(i).getSseslintegralprice())))+"");
			}
		}
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfoByID(salesBasicPo);
		//储值卡流水
		if (czklist != null && czklist.size() != 0){
			for (ChuzhikaPo czkpo:czklist){
				BigDecimal bgc1 = new BigDecimal(czkpo.getCstczkjine());
				BigDecimal bgc2 = new BigDecimal(czkpo.getCstczkchongzhijine());
				ChuzhikaLogPo po=new ChuzhikaLogPo();
				po.setSmeasmemberid(salesBasicPo2.getSsesbMemberId());
				po.setSmeascustomerid(salesBasicPo2.getSsesbcustomerid());
				po.setSmeasdopersonid(salesBasicPo.getSsesbposid());
				po.setSmeassalesbillid(czkpo.getCstczkllinkbillid());
				po.setSmeaschuzhikaid(czkpo.getCstczkid());
				po.setSmeascintegral(Math.abs(Float.parseFloat(Utility.getNameTwoPoint(czkpo.getCstczkchongzhijine())))+"");
				po.setSmeasxintegral(czkpo.getCstczkjine());
				po.setSmeasyintegral((bgc1.subtract(bgc2)).toString());	
				po.setSmeasaddorsub("8");
				chuzhikaDao.insertChuZhiKaLogInformation(po);
			}
		}
		guitarManagementMgr.insertPayType3(salesBasicPo,salesLogPos,czklist,djqlist);
		
		for (RegisteredDetailsPo po : detailsPos) {
			registeredDao.insertRepairsCostDetails(po);
		}
		// 新增付款记录（横向）
		SalesLogPo slpo = new SalesLogPo();
		slpo.setSsesluuid(uuid.generate());
		slpo.setSsesltype("3"); // 中心挂号
		
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
	}
	/**
	 * 查询当日个人挂号金额汇总
	 */
	public RegisteredDetailsPo getRegisteredPersonSumToday(String departmentID,String personID){
		return this.registeredDao.getRegisteredPersonSumToday(departmentID, personID);
	}
}
