package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.InvisibleDistributionDao;
import com.pengsheng.eims.sales.mgr.InvisibleDistributionMgr;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.dao.BillKeyDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class InvisibleDistributionMgrImpl implements InvisibleDistributionMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public DoorStoreDeliveryDao doorStoreDeliveryDao;
	public SalesBasicPo salesBasicPo;
	private InvisibleDistributionDao invisibleDistributionDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private SpectaclesMaterialsDao spectaclesMaterialsDao;
	private WarehouseConfigurationDao warehouseConfigurationDao = null;
	private WarehouseDao warehouseDao = null;
	private GuitarManagementDao guitarManagementDao;
	private StrogeChangeDao strogeChangeDao = null;
	private BillKeyDao billKeyDao;

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}
	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}
	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}
	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
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
	public DoorStoreDeliveryDao getDoorStoreDeliveryDao() {
		return doorStoreDeliveryDao;
	}
	public void setDoorStoreDeliveryDao(DoorStoreDeliveryDao doorStoreDeliveryDao) {
		this.doorStoreDeliveryDao = doorStoreDeliveryDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public InvisibleDistributionDao getInvisibleDistributionDao() {
		return invisibleDistributionDao;
	}

	public void setInvisibleDistributionDao(
			InvisibleDistributionDao invisibleDistributionDao) {
		this.invisibleDistributionDao = invisibleDistributionDao;
	}

	/**
	 * 获取门店
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po) {
		return invisibleDistributionDao.getWarehouseList(po);
	}

	/**
	 * 查询隐形订做片配送
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo salesBasicPo) {
		return invisibleDistributionDao.getSalesBasicPos(salesBasicPo);
	}

	/**
	 * 新增配送记录主表
	 */
	public void insertDistribution(DistributionPo distributionPo) {
		invisibleDistributionDao.insertDistribution(distributionPo);
	}

	/**
	 * 新增配送记录明细表
	 */
	public void insertDistributionEntry(DistributionEntryPo distributionEntryPo) {

	}

	/**
	 * 新增在途查询明细表
	 */
	public void insertInTransit(InTransitPo inTransitPo) {
		invisibleDistributionDao.insertInTransit(inTransitPo);
	}
	
	
	/**
	 * 修改在途状态前的库存判断
	 */
	public String updateSalesBasicPosCheck(SystemParameterPo systemParameterPo,AllocationPo allocationPo,
			String[] ssesbsalesid, InTransitPo inTransitPo,
			DistributionPo distributionPo,LogisticsLogPo logPo) {
		
		if(!"1".equals(systemParameterPo.getFspsalestype())){
			String errorsalesid = "以下销售单号：\\n";
			String errortype = "";
			String[] ssesbsalesids = new String[1];
			for(int i=0; i<ssesbsalesid.length; i++){
				SalesDetailPo tspo = new SalesDetailPo();
				tspo.setSsesdsalesid(ssesbsalesid[i]);
				int istake = billKeyDao.selectConsignProcessIsSend(tspo);
				if(istake > 0){
					errorsalesid = errorsalesid + ssesbsalesid[i]+"\\n";
					errortype = "1";
				}else{
					ssesbsalesids[0] = ssesbsalesid[i];
					updateSalesBasicPos(systemParameterPo,allocationPo,ssesbsalesids,inTransitPo,distributionPo,logPo);
				}
			}
			
			if("1".equals(errortype)){
				return errorsalesid+"库存不足无法配送！";
			}else{
				return "隐形配送成功!";
			}
		}else{
			updateSalesBasicPos(systemParameterPo,allocationPo,ssesbsalesid,inTransitPo,distributionPo,logPo);
			return "隐形配送成功!";
		}
	}
	/**
	 * 修改在途状态
	 */
	public void updateSalesBasicPos(SystemParameterPo systemParameterPo,AllocationPo allocationPo,
			String[] ssesbsalesid, InTransitPo inTransitPo,
			DistributionPo distributionPo,LogisticsLogPo logPo) {

		salesBasicPo = new SalesBasicPo();
		DistributionEntryPo distributionEntryPo = new DistributionEntryPo();
		DistributionPo checkpo = invisibleDistributionDao.isInsertDistribution(distributionPo);
		String id = "";
		if(!"".equals(Utility.getName(checkpo.getSdndnid()))){
			id = checkpo.getSdndnid();
		}else{
			id = invisibleDistributionDao.insertDistribution(distributionPo); //新增配镜单配送信息
		}
		
		for (int i = 0; i < ssesbsalesid.length; i++) {
			if(!"".equals(ssesbsalesid[i])){
				salesBasicPo.setSsesbsalesid(ssesbsalesid[i]);
				
				InTransitPo inTransitPo1 =new InTransitPo();
				inTransitPo1.setSseitsalesid(ssesbsalesid[i]);
				inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1); //确认配镜单在途在隐形配送之前
				
				if(Integer.parseInt(inTransitPo1.getSseitstate()) < 11){
					invisibleDistributionDao.updateSalesBasicPos(salesBasicPo); //更新销售基表在途
					
					inTransitPo.setSseitsalesid(ssesbsalesid[i]);
					invisibleDistributionDao.insertInTransit(inTransitPo);// 新增在途查询明细表
					
					distributionEntryPo.setSdndesalesid(ssesbsalesid[i]);
					distributionEntryPo.setSdndedistributionid(id);
					
					logPo.setsLogContent(ssesbsalesid[i]);				
					logisticsLogDao.insertLog(logPo); //添加日志
					
					invisibleDistributionDao.insertDistributionEntry(distributionPo,distributionEntryPo);// 新增配送记录主表和配送记录明细表
				}
			}
		}

		//更新配镜单中隐形订制片的商品条码
		List<SalesDetailPo> salesDetailList = invisibleDistributionDao.getGoodsItemsByDelivery(ssesbsalesid);
		for (SalesDetailPo po : salesDetailList){
			invisibleDistributionDao.updateGoodsItemsByDelivery(po);
		}	
		
		//隐形订做镜片由委外收货仓位自动调拨至取镜门店仓位
		if (systemParameterPo.getFspyxpsflag().equals("1")){			 
			autoAllocationToStore(systemParameterPo,allocationPo,ssesbsalesid);	 // 按配镜单创建调拨单
		}else{
			autoAllocationToStore(allocationPo,ssesbsalesid,distributionPo);  // 按配送单创建调拨单
		}
		
	}
	
	/**
	 * 自动调拨（从隐形定制片出仓仓位到门店仓位）
	 */
	private void autoAllocationToStore(SystemParameterPo systemParameterPo,AllocationPo allocationPo,String[] ssesbsalesid){
		
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		String firstStock = "";              //一只镜片的出仓配置的仓位
		String secondStock = "";             //另一只镜片的出仓配置的仓位
		String tbillid = "";                 //调拨单号
		
		int count = ssesbsalesid.length;     //配镜单数量
		if (count > 0){
			
			DepartmentsPo departmentsPo = new DepartmentsPo();			
			WarehousePo wpo = null;   //配镜单销售部门的所属仓位
			List<SalesDetailPo> salesDetailList = null;   //配镜单中隐形定制商品列表
			SalesBasicPo sbPo = new SalesBasicPo();
			GoodsInfoPo goodsInfoPo = null;
				
			SalesDetailPo tsdpo = new SalesDetailPo();		
			tsdpo.setSsesdcommoditiesflag("4");  //隐形
			tsdpo.setSsesdlargessflag("");  // 不是赠品
			tsdpo.setSsesdiscustomize("D"); // 定制片	
			
			int flag = 1;
			
			for (int i = 0; i < count; i++){
				if(!"".equals(ssesbsalesid[i])){
					InTransitPo inTransitPo1 =new InTransitPo();
					inTransitPo1.setSseitsalesid(ssesbsalesid[i]);
					inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1); //确认配镜单在途在隐形配送之前
					
					if(Integer.parseInt(inTransitPo1.getSseitstate()) > 11){
						continue;
					}
					
					tsdpo.setSsesdsalesid(ssesbsalesid[i]);
					salesDetailList = inTransitDetailsDao.getAutoAllocationGoodsList(tsdpo);  //获取配镜单中隐形定制商品列表
					
					sbPo.setSsesbcustomerid("");
					sbPo.setSsesbsalesid(ssesbsalesid[i]);
					sbPo = inTransitDetailsDao.getCustomerInfo(sbPo);   //获取配镜单信息
	
					departmentsPo.setBdpdepartmentid(sbPo.getSsesblocation());  // 取镜门店
					wpo = warehouseDao.getWarehousePo(departmentsPo);   //获取配镜单取镜部门的所属仓位
									
					firstStock = "";				
					for (SalesDetailPo po : salesDetailList){					
	
						secondStock = Utility.getName(inTransitDetailsDao.getSalesGoodsInWarehouse(po.getSsesdid()));  //委外收货仓位
						
						if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(secondStock))){ //判断隐形定制片出仓仓位和取镜门店仓位是否相同
							flag = 0;
						}
						
						goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));  //根据商品代码获取商品信息
						
						if (Utility.getName(goodsInfoPo.getBgigoodscategoryid()).equals("4") && Utility.getName(goodsInfoPo.getBgiiscustomize()).equals("D") && !Utility.getName(goodsInfoPo.getBgisupplierid()).equals("ZZ")){  // 隐形订制片 
																	
							if (!firstStock.equals(secondStock)){   //一张配镜单生成一张调拨单
								
								tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();
								
								InventoryPo inventoryPo=new InventoryPo();
								inventoryPo.setCstioutstockid(secondStock); //出仓配置的隐形定制镜片消仓仓位
								inventoryPo.setCstibillid(tbillid);
								inventoryPo.setCstibilltypeid("4");
								inventoryPo.setCstiinstockid(Utility.getName(wpo.getBwhid()));		//取镜门店仓			
								inventoryPo.setCstidepartmentid(allocationPo.getCshaaoutdepartmentid());  //隐形配送部门
								inventoryPo.setCsticreateperson(allocationPo.getCshaacreateperson());
								inventoryPo.setCstiauditperson(allocationPo.getCshaacreateperson());
								inventoryPo.setCstisourcebillid(ssesbsalesid[i]);      //配镜单号
								inventoryPo.setCstiremark("隐形配送自动调拨");
								inventoryPo.setCstigoodscategory("23");       //特殊标志,23标识隐形配送自动调拨
								inventoryPo.setCstifinanceauditperson(allocationPo.getCshaacreateperson());
								inventoryPo.setCstifinanceauditstate("1");
								
								inventoryList.add(inventoryPo);
								
								firstStock = secondStock;
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
								inventoryEntryPo.setCstieoutstockid(secondStock);
								inventoryEntryPo.setCstiebarcode(po.getSsesditemid());
								inventoryEntryPo.setCstieoutstorageflag("1");
								inventoryEntryPo.setCstieremark("隐形订制片配送至取镜门店");
								inventoryEntryPo.setCstiesalesbillid(ssesbsalesid[i]);  //配镜单号
								inventoryEntryPo.setCstieautoallocationflag("3");       //库存表使用
								
				    			inventoryEntryPo.setCstieguaranteeperiod(Utility.getName(po.getSsesdguaranteeperiod()));
				    			inventoryEntryPo.setCstiebatch(Utility.getName(po.getSsesdbatch()));
				    			inventoryEntryPo.setCstieregistrationnum(Utility.getName(po.getSsesdregistrationnum()));
					            
								inventoryEntryList.add(inventoryEntryPo);
							}
						}
					}
				}
			}
			
			if (flag == 1){
				for (InventoryPo po : inventoryList){
					spectaclesMaterialsDao.inertAutoAllocationToStore(po);
					spectaclesMaterialsDao.inertAutoAllocationBillToStore(po);
				}
			}
			
			String stockID = null;
			for (InventoryEntryPo po : inventoryEntryList){
				if (flag == 1){
					spectaclesMaterialsDao.inertAutoAllocationEntryToStore(po);

					spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);    // 回填调拨明细表
				}else{
					po.setCstiebillid(po.getCstiesalesbillid());
					po.setCstiesalesbillid("");
				}
				
				//调拨使取镜门店增加库存
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
				
				//调拨委外收货的仓位减少库存
				po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
				stockID = po.getCstieinstockid();
				po.setCstieinstockid(po.getCstieoutstockid()); //用委外收货的仓位赋值
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
	
	private void autoAllocationToStore(AllocationPo allocationPo,String[] ssesbsalesid,DistributionPo dpo){
		
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		String firstStock = "";              //一只镜片的出仓配置的仓位
		String secondStock = "";             //另一只镜片的出仓配置的仓位
		String tbillid = "";               //调拨单号
		String firstDpt = "";              //第一个取镜门店
		
		int count = ssesbsalesid.length;     //配镜单数量
		if (count > 0){
			
			DepartmentsPo departmentsPo = new DepartmentsPo();			
			WarehouseConfigurationPo cpo = new WarehouseConfigurationPo();
			WarehousePo wpo = null;   //配镜单销售部门的所属仓位
			List<SalesDetailPo> salesDetailList = null;   //配镜单中隐形定制商品列表
			SalesBasicPo sbPo = new SalesBasicPo();
			GoodsInfoPo goodsInfoPo = null;
				
			SalesDetailPo tsdpo = new SalesDetailPo();		
			tsdpo.setSsesdcommoditiesflag("4");  //隐形
			tsdpo.setSsesdlargessflag("");  // 不是赠品
			tsdpo.setSsesdiscustomize("D"); // 定制片			
			
			List<SalesBasicPo> sbList = inTransitDetailsDao.getLocationShopCodeList(ssesbsalesid);  //获取各配镜单的取镜门店
			
			for (int i = 0; i < count; i++){
				tsdpo.setSsesdsalesid(ssesbsalesid[i]);
				salesDetailList = inTransitDetailsDao.getAutoAllocationGoodsList(tsdpo);  //获取配镜单中隐形定制商品列表，按仓位排序
				
				sbPo.setSsesbsalesid(ssesbsalesid[i]);
				sbPo = inTransitDetailsDao.getCustomerInfo(sbPo);   //获取配镜单信息

				departmentsPo.setBdpdepartmentid(sbPo.getSsesblocation());  // 取镜门店
				wpo = warehouseDao.getWarehousePo(departmentsPo);   //获取配镜单取镜部门的所属仓位

				cpo.setBwcdeptid(sbPo.getSsesbshopcode());
				cpo = warehouseConfigurationDao.getWarehouseConfiguration(cpo);  // 获取销售门店的出仓配置

				for (SalesDetailPo po : salesDetailList){

					secondStock = Utility.getName(inTransitDetailsDao.getSalesGoodsInWarehouse(po.getSsesdid()));  //委外收货仓位
					
					if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(secondStock))){ //判断隐形定制片委外收货的仓位和取镜门店仓位是否相同
						break;
					}
					
					goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));  //根据商品代码获取商品信息
					
					if (Utility.getName(goodsInfoPo.getBgigoodscategoryid()).equals("4") && Utility.getName(goodsInfoPo.getBgiiscustomize()).equals("D") && !Utility.getName(goodsInfoPo.getBgisupplierid()).equals("ZZ")){  // 隐形订制片 
																
						if ((!firstDpt.equals(Utility.getName(sbList.get(i).getSsesblocation()))) || (!firstStock.equals(secondStock))){   //一张配送单生成一张调拨单或者相同收入仓位的配镜单生成一张调拨单
							
							tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();
							
							InventoryPo inventoryPo = new InventoryPo();
							inventoryPo.setCstioutstockid(secondStock); //出仓配置的隐形定制镜片消仓仓位
							inventoryPo.setCstibillid(tbillid);
							inventoryPo.setCstiinstockid(Utility.getName(wpo.getBwhid()));		//取镜门店仓
							inventoryPo.setCstidepartmentid(allocationPo.getCshaaoutdepartmentid());  //隐形配送部门
							inventoryPo.setCsticreateperson(allocationPo.getCshaacreateperson());
							inventoryPo.setCstiauditperson(allocationPo.getCshaacreateperson());
							inventoryPo.setCstisourcebillid(Utility.getName(dpo.getSdndnid()));      //配送单号
							inventoryPo.setCstiremark("隐形配送自动调拨");
							
							inventoryList.add(inventoryPo);
							
							firstStock = secondStock;
							firstDpt = Utility.getName(sbList.get(i).getSsesblocation());	
						}
						
						if (!tbillid.equals("")){
					
							InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
							inventoryEntryPo.setCstiebillid(tbillid);
							inventoryEntryPo.setCstiegoodsid(po.getSsesdsalesitemid());
							inventoryEntryPo.setCstiegoodsquantity(po.getSsesdnumber());
							inventoryEntryPo.setCstieinstockid(Utility.getName(wpo.getBwhid()));
							inventoryEntryPo.setCstieoutstockid(secondStock);
							inventoryEntryPo.setCstiebarcode(po.getSsesditemid());
							inventoryEntryPo.setCstieoutstorageflag("0");
			    			inventoryEntryPo.setCstieguaranteeperiod(Utility.getName(po.getSsesdguaranteeperiod()));
			    			inventoryEntryPo.setCstiebatch(Utility.getName(po.getSsesdbatch()));
			    			inventoryEntryPo.setCstieregistrationnum(Utility.getName(po.getSsesdregistrationnum()));
				            
							inventoryEntryList.add(inventoryEntryPo);
						}
					}
				}
				
			}
			
			for (InventoryPo po : inventoryList){
				spectaclesMaterialsDao.inertAutoAllocationBillByyx(po);
			}
			
			for (InventoryEntryPo po : inventoryEntryList){
				spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
			}


		}
		
	}
	
	/**
	 * 获取需要隐形配送的门店
	 */
	public List<WarehousePo> getDistributionStoreList(DepartmentsPo po){
		return invisibleDistributionDao.getDistributionStoreList(po);
	}
	public BillKeyDao getBillKeyDao() {
		return billKeyDao;
	}
	public void setBillKeyDao(BillKeyDao billKeyDao) {
		this.billKeyDao = billKeyDao;
	}
	
}
