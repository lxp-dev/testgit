package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.dao.GiftsDao;
import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.AdditionalCDetailDao;
import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.RefundDao;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.dao.AllocationDao;
import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.dao.SalesReturnDao;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.SalesReturnMgr;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class SalesReturnMgrImpl implements SalesReturnMgr{
	
	private BatchCompareDao batchCompareDao;
	private GuitarManagementMgr guitarManagementMgr;
	private ChuzhikaDao chuzhikaDao;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private CashCouponDao cashCouponDao;
	private SystemParameterDao systemParameterDao;
		
	public UUIDHexGenerator getUuid() {
		return uuid;
	}
	public void setUuid(UUIDHexGenerator uuid) {
		this.uuid = uuid;
	}
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
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
	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}
	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}
	public BatchCompareDao getBatchCompareDao() {
		return batchCompareDao;
	}
	public void setBatchCompareDao(BatchCompareDao batchCompareDao) {
		this.batchCompareDao = batchCompareDao;
	}
	private SalesReturnDao salesReturnDao;
	private DepartmentsMgr departmentsMgr;	
	private RefundDao refundDao;
	private LogisticsLogDao logisticsLogDao;	
	private GuitarManagementDao guitarManagementDao;	
	private GiftsDao giftsDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private AllocationDao allocationDao = null;
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}
	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}
	public GiftsDao getGiftsDao() {
		return giftsDao;
	}
	public void setGiftsDao(GiftsDao giftsDao) {
		this.giftsDao = giftsDao;
	}
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public AllocationDao getAllocationDao() {
		return allocationDao;
	}
	public void setAllocationDao(AllocationDao allocationDao) {
		this.allocationDao = allocationDao;
	}
	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}
	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
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
	public FrameSalesDao getFrameSalesDao() {
		return frameSalesDao;
	}
	public void setFrameSalesDao(FrameSalesDao frameSalesDao) {
		this.frameSalesDao = frameSalesDao;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public SetMealDao getSetMealDao() {
		return setMealDao;
	}
	public void setSetMealDao(SetMealDao setMealDao) {
		this.setMealDao = setMealDao;
	}
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
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
	private WarehouseDao warehouseDao;
	private WarehouseConfigurationDao warehouseConfigurationDao = null;
	private SpectaclesMaterialsDao spectaclesMaterialsDao = null;
	private FrameSalesDao frameSalesDao;
	private WarehouseMgr warehouseMgr;
	private SetMealDao setMealDao;
	private StrogeChangeDao strogeChangeDao = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private AdditionalCDetailDao additionalCDetailDao;
	public AdditionalCDetailDao getAdditionalCDetailDao() {
		return additionalCDetailDao;
	}
	public void setAdditionalCDetailDao(AdditionalCDetailDao additionalCDetailDao) {
		this.additionalCDetailDao = additionalCDetailDao;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public SalesReturnDao getSalesReturnDao() {
		return salesReturnDao;
	}
	public void setSalesReturnDao(SalesReturnDao salesReturnDao) {
		this.salesReturnDao = salesReturnDao;
	}
	/*
	 * 退款新增
	 */
	public void insertSalesReturn(SalesBasicPo salesBasicPo){
		salesReturnDao.insertSalesReturn(salesBasicPo);
	}
	/*
	 * 当天退款新增
	 */
	public void insertSalesReturnToday(SalesBasicPo salesBasicPo){
		salesReturnDao.insertSalesReturnToday(salesBasicPo);
	}
	/**
	 * 退款单详细新增
	 */
	public void insertSalesReturnDetail(SalesDetailPo salesDetailPo){
		salesReturnDao.insertSalesReturnDetail(salesDetailPo);
	}
	/**
	 * 当天退款单详细新增
	 */
	public void insertSalesReturnDetailToday(SalesDetailPo salesDetailPo){
		salesReturnDao.insertSalesReturnDetailToday(salesDetailPo);
	}
	
	public RefundDao getRefundDao() {
		return refundDao;
	}
	public void setRefundDao(RefundDao refundDao) {
		this.refundDao = refundDao;
	}
	public String insertSalesReturnProcess(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailPoList,
			SalesBasicPo salesBasicPo,InTransitPo inTransitPo,List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist,LogisticsLogPo logPo,List<AdditionalCDetailPo> additionalCDetailPoList) {
		salesBasicPo.setSsesborderstype("5");
		
		// 插入在途点
		refundDao.insertIntrnsitInfo(inTransitPo);
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		SalesBasicPo salesBasicPo2 = inTransitDetailsDao.getCustomerInfo(salesBasicPo);
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
		
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(salesBasicPo.getSsesbdepartmentid());
		WarehouseConfigurationPo warehouseConfigurationPo = departmentsMgr.getInWarehouseByDpt(tempWarehouseConfigurationPo);

		for(SalesDetailPo salesDetailPo:salesDetailPoList){
			
			salesDetailPo.setSsesdiscustomize( salesReturnDao.getGoodsIsCustomize(salesDetailPo.getSsesdsalesitemid()).getSsesdiscustomize());
			String goodstype = salesDetailPo.getSsesdsalesitemid().substring(0,1);
			
			if("1".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid1());//镜架出仓
				salesDetailPo.setSsesdgooddescribe("镜架");
			}else if("2".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid2());//配件出仓
				salesDetailPo.setSsesdgooddescribe("配件");
			}else if("3".equals(goodstype)){
				if("D".equals(salesDetailPo.getSsesdiscustomize())){
					salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid4());//成品订制镜片出仓
					salesDetailPo.setSsesdgooddescribe("镜片");
				}else{
					salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid3());//成品镜片出仓
					salesDetailPo.setSsesdgooddescribe("镜片");
				}
			}else if("4".equals(goodstype)){
				if("D".equals(salesDetailPo.getSsesdiscustomize())){
					salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid6());//隐形订制镜片出仓
					salesDetailPo.setSsesdgooddescribe("隐形");
				}else{
					salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid5());//隐形镜片出仓
					salesDetailPo.setSsesdgooddescribe("隐形");
				}
			}else if("5".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid7());//隐形护理液出仓
				salesDetailPo.setSsesdgooddescribe("护理液");
			}else if("6".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid8());//太阳镜
				salesDetailPo.setSsesdgooddescribe("太阳镜");
			}else if("7".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid9());//耗材
				salesDetailPo.setSsesdgooddescribe("耗材");
			}else if("8".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid11());//老花镜
				salesDetailPo.setSsesdgooddescribe("老花镜");
			}else if("9".equals(goodstype)){
				salesDetailPo.setSsesdinstockid(warehouseConfigurationPo.getBwcstockid12());//视光
				salesDetailPo.setSsesdgooddescribe("视光");
			}
			
			if(!"".equals(salesDetailPo.getSsesdsalesitemid())&&!"2".equals(salesBasicPo.getSsesborderstype())&&!"4".equals(salesBasicPo.getSsesborderstype())){
				if("D".equals(Utility.getName(salesDetailPo.getSsesdiscustomize())) && "3".equals(goodstype)){
					salesBasicPo.setSsesborderstype("2");					
				}else if(!"D".equals(Utility.getName(salesDetailPo.getSsesdiscustomize())) && "3".equals(goodstype)){
					salesBasicPo.setSsesborderstype("1");
				}else if("D".equals(Utility.getName(salesDetailPo.getSsesdiscustomize())) && "4".equals(goodstype)){
					salesBasicPo.setSsesborderstype("4");
				}else if(!"D".equals(Utility.getName(salesDetailPo.getSsesdiscustomize())) && "4".equals(goodstype)){
					salesBasicPo.setSsesborderstype("3");
				}	
			}
			
			salesReturnDao.insertSalesReturnDetailToday(salesDetailPo);
			salesReturnDao.insertSalesReturnDetail(salesDetailPo);			
		}
		
		if (Utility.getName(salesBasicPo.getSsesborderstype()).equals("5")){
			salesBasicPo.setSsesbsalestype("3"); // 销售类型：辅料
		}
		
		salesReturnDao.insertSalesReturn(salesBasicPo);
		salesReturnDao.insertSalesReturnToday(salesBasicPo);
		
		for(AdditionalCDetailPo additionalCDetailPo:additionalCDetailPoList){
			additionalCDetailDao.insertAdditionalCDetail(additionalCDetailPo);
		}
		
		guitarManagementMgr.insertPayType2(salesBasicPo,salesLogPos,czklist,djqlist);
		
		//代金券更新
		if (djqlist != null && djqlist.size() != 0){
			for (CashCouponPo couponPo:djqlist){
				cashCouponDao.updateCashCouponState2(couponPo);
			}
		}
		
		DepartmentsPo departmentPo = new DepartmentsPo();
		departmentPo.setBdpdepartmentid(salesBasicPo.getSsesbshopcode());
		WarehousePo wpo = warehouseDao.getWarehousePo(departmentPo);
		
		String bwhid = "";
		if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
			bwhid = Utility.getName(wpo.getBwhid());
		}
		
		salesBasicPo.setSsesbshopcodewarehouseid(bwhid);
		
		salesReturnDao.insertStrogeChanges(salesBasicPo);//库存插入change表
		salesReturnDao.insertStrogeLog(salesBasicPo);//库存插入log表
		List<StrogeChangePo> strogeChangePos=salesReturnDao.selectStrogeLogTemp(salesBasicPo);
		for (StrogeChangePo strogeChangePo : strogeChangePos){
			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
		}
		
		//自动调拨,通过调拨，退款仓位增加商品库存,门店仓位减少库存
		if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
			autoAllocationFromStore(systemParameterPo,salesDetailPoList,salesBasicPo.getSsesbsalesid(),inTransitPo,wpo,salesBasicPo,warehouseConfigurationPo);
		}		

		//效期判断begin
		 Iterator<SalesDetailPo> it = salesDetailPoList.iterator();
		 while (it.hasNext()) {
			SalesDetailPo salesDetailPo = it.next();
			if(!"".equals(Utility.getName(salesDetailPo.getSsesdbatch()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(salesDetailPo.getSsesditemid());
				tbpo.setCshbcbatch(salesDetailPo.getSsesdbatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String[] left = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
				String isinsert = "";
				if(bpo.getCshbcbarcode() != null){
					
				}else{
					BatchComparePo tpo= new BatchComparePo();
					tpo.setCshbcbarcode(salesDetailPo.getSsesditemid());
					BatchComparePo maxpo = batchCompareDao.selectBatchComparePo(tpo);
					isinsert = "1";
					if(maxpo.getCshbcbarcode() != null){
						for(int i=0; i<left.length;i++){
							if(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2)) == 9){
								if(left[i].equals(maxpo.getCshbcsimplebatch().substring(0, 1))){
									bpo.setCshbcsimplebatch(left[i+1]+"0");
									break;
								}
							}else{
								bpo.setCshbcsimplebatch(maxpo.getCshbcsimplebatch().substring(0, 1)+(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2))+1));
								break;
							}
						}
					}else{
						bpo.setCshbcsimplebatch("A0");
					}
				}
				salesDetailPo.setSsesditemid(salesDetailPo.getSsesditemid().substring(0, 24)+bpo.getCshbcsimplebatch());
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(salesDetailPo.getSsesditemid());
					ipo.setCshbcguaranteeperiod(salesDetailPo.getSsesdguaranteeperiod());
					ipo.setCshbcbatch(salesDetailPo.getSsesdbatch());
					ipo.setCshbcsimplebatch(bpo.getCshbcsimplebatch());
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
		}
		//效期判断end
		 
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
		 
		//新增当天营业员收银员记录
		SalesDetailPo detailPo = new SalesDetailPo();
		detailPo.setSsesdsalesid(salesBasicPo.getSsesbsalesid());		
		List<SalesDetailPo> detailPos = inTransitDetailsDao.getGoodsInfo(detailPo);
		
		guitarManagementMgr.insertSalerCashierRecord(detailPos,salesBasicPo,"1","0","1",salesBasicPo.getSsesbwithdrawpersonid());
		
		return Utility.getName(salesBasicPo.getSsesbsalesid());
	}
	
	
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public SalesBasicPo getCustomerId(String cid){
		return salesReturnDao.getCustomerId(cid);
	}
	/**
	 * 自动调拨（从门店仓位到门店退款仓位）
	 */
	private void autoAllocationFromStore(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailList,String billID,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo,WarehouseConfigurationPo cpo){
			
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
				inventoryPo.setCstiremark("门店直接退款自动调拨");
				inventoryPo.setCstigoodscategory("28");       //特殊标志,22标识门店自动调拨
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
				inventoryEntryPo.setCstieremark("门店直接退款");
				inventoryEntryPo.setCstieautoallocationflag("7");
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
}
