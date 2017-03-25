package com.pengsheng.eims.storage.mgr.impl;

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
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.ConsignProcessTakeDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.ConsignProcessTakeMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.InventoryTempEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryTempPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class ConsignProcessTakeMgrImpl implements ConsignProcessTakeMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private ConsignProcessTakeDao consignProcessTakeDao;
	private SystemParameterDao systemParameterDao = null;
	private SystemParameterPo systemParameterPo = null;
	private StrogeChangeDao strogeChangeDao;
	private WarehouseConfigurationDao warehouseConfigurationDao;
	private SpectaclesMaterialsDao spectaclesMaterialsDao;
	private GuitarManagementDao guitarManagementDao;	
	private InTransitDetailsDao inTransitDetailsDao;
	private WarehouseDao warehouseDao = null;
	private ReportQuartzDao reportQuartzDao;
	private ProcurementReceiptDao procurementReceiptDao;
	
	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}
	public void setProcurementReceiptDao(ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}
	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}
	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
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
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}
	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
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
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
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
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public ConsignProcessTakeDao getConsignProcessTakeDao() {
		return consignProcessTakeDao;
	}

	public void setConsignProcessTakeDao(
			ConsignProcessTakeDao consignProcessTakeDao) {
		this.consignProcessTakeDao = consignProcessTakeDao;
	}
	
	/**
	 *得到委外收货单数量
	 * 
	 */
	public int getConsignProcessReceiptCount(ConsignProcessReceiptPo po) {
		return consignProcessTakeDao.getConsignProcessReceiptCount(po);
	}
	
	/**
	 * 取所有委外收货单
	 * 
	 */
	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList(
			ConsignProcessReceiptPo po, int start, int size) {
		// TODO Auto-generated method stub
		return consignProcessTakeDao.getConsignProcessReceiptList(po, start,
				size);
	}
	
	/**
	 * 取委外订单主表
	 * 
	 */
	public ConsignProcessReceiptPo getConsignProcessReceipt(
			ConsignProcessReceiptPo po) {
		// TODO Auto-generated method stub
		return consignProcessTakeDao.getConsignProcessReceipt(po);
	}
	

	/**
	 * 取委外订单明细
	 * 
	 */
	public List<ConsignProcessReceiptDetailsPo> getConsignProcessReceiptEntryList(
			ConsignProcessReceiptPo po) {
		return consignProcessTakeDao.getConsignProcessReceiptEntryList(po);
	}
	
	/**
	 * 得到顾客信息
	 * 
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public ConsignProcessOrderDetailsPo getCustomer(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		return consignProcessTakeDao.getCustomer(consignProcessOrderDetailsPo);
	}

	/**
	 * 得到商品信息 柱镜、球镜等
	 * 
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getGoods(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		return consignProcessTakeDao.getGoods(consignProcessOrderDetailsPo);
	}

	/**
	 * 得到商品信息 代码、批号、收入仓位
	 * 
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getGoodsWarehouse(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		return consignProcessTakeDao
				.getGoodsWarehouse(consignProcessOrderDetailsPo);
	}

	/**
	 * 得到仓位信息
	 * 
	 * @param warehousePo
	 * @return
	 */
	public List<WarehousePo> getWarehouse(WarehousePo warehousePo) {
		// TODO Auto-generated method stub
		return consignProcessTakeDao.getWarehouse(warehousePo);
	}

	/**
	 * 委外订单开窗查询，回带订单号及配镜单
	 * 
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesid(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		return consignProcessTakeDao.getSalesid(consignProcessOrderDetailsPo);
	}
	
	public int getSalesids(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		return consignProcessTakeDao.getSalesids(consignProcessOrderDetailsPo);
	}

	/**
	 * 委外订单开窗查询，回带订单号及配镜单
	 * 
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesid(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size) {
		return consignProcessTakeDao.selectSalesid(
				consignProcessOrderDetailsPo, start, size);
	}
	
	public List<ConsignProcessOrderDetailsPo> selectSalesids(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,int start, int size) {
		return consignProcessTakeDao.selectSalesids(consignProcessOrderDetailsPo, start, size);
	}

	/**
	 * 新增收货表及其他表
	 * 
	 * @param salesid
	 * @param receiptList
	 * @param consignReceiptPo
	 * @param inTransitPo
	 */
	public void insertReceipt(SystemParameterPo systemParameterPo,String salesid,List<ConsignProcessReceiptDetailsPo> receiptList,ConsignProcessReceiptPo consignReceiptPo, InTransitPo inTransitPo,InventoryTempPo inventoryTempPo,LogisticsLogPo logPo) {
		
		//判断是何种配镜单：内部X，外部W,R,B  处理内部配镜单
		if("X".equals(salesid.substring(0,1))&&"4".equals(Utility.getName(consignReceiptPo.getCstcprgoodscategory()))){//隐形
			inTransitPo.setSseitstate("5");
			// 新增在途明细表信息  委外收货
			consignProcessTakeDao.insertIntransit(inTransitPo);
			// 更新销售主表在途
			consignProcessTakeDao.updateSalesBasic(salesid,inTransitPo.getSseitstate());
		    //更新销售表条码
			for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : receiptList) {
				SalesDetailPo salesDetailPo = new SalesDetailPo();
				salesDetailPo.setSsesdsalesid(salesid);
				salesDetailPo.setSsesdsalesitemid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
				salesDetailPo.setSsesditemid(consignProcessReceiptDetailsPo.getCstcprdbarcode());
				salesDetailPo.setSsesdglassflag(consignProcessReceiptDetailsPo.getCstcprflag());				
				salesDetailPo.setSsesdguaranteeperiod(consignProcessReceiptDetailsPo.getCstcpguaranteeperiod());    //效期
				salesDetailPo.setSsesdbatch(consignProcessReceiptDetailsPo.getCstcpbatch());   //批号
				salesDetailPo.setSsesdregistrationnum(consignProcessReceiptDetailsPo.getCstcpregistrationnum());   // 注册证号

				consignProcessTakeDao.updateDetailsBarcode(salesDetailPo);
			}			
		}else if("X".equals(salesid.substring(0,1))&&"2".equals(Utility.getName(consignReceiptPo.getCstcprgoodscategory()))){//框镜
			// 新增在途明细表信息 委外收货
			inTransitPo.setSseitstate("5");
			consignProcessTakeDao.insertIntransit(inTransitPo);			
		
			// 更新销售主表在途
			consignProcessTakeDao.updateSalesBasic(salesid,inTransitPo.getSseitstate());

		}else if("W".equals(salesid.substring(0,1))||"R".equals(salesid.substring(0,1))||"B".equals(salesid.substring(0,1))){   //重订
			
			InTransitPo transitPo = consignProcessTakeDao.getIntransitPo(inTransitPo);
			inTransitPo.setSseitstate("2");
			inTransitPo.setSseitysalesid(transitPo.getSseitysalesid());
			
			// 新增在途明细表信息 委外收货
			consignProcessTakeDao.insertIntransit(inTransitPo);
		}

		// 新增收货主表信息
		consignProcessTakeDao.insertReceipt(consignReceiptPo);
		inventoryTempPo.setCstitdeliveryid(Utility.getName(consignReceiptPo.getCstcprwaybillid()));
		
		// 新增收货明细表信息
		for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : receiptList) {
			consignProcessReceiptDetailsPo.setCstcprdreceiptbilld(consignReceiptPo.getCstcprreceiptbillid());
			consignProcessReceiptDetailsPo.setCstcprdinstockid(consignReceiptPo.getCstcprinstockid());

			consignProcessTakeDao.insertReceiptDetails(consignProcessReceiptDetailsPo);
		}
		
		for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : receiptList) {
			// 新增当月库存变更信息
			StrogeChangePo strogeChangePo = new StrogeChangePo();
			String barcode = consignProcessReceiptDetailsPo.getCstcprdgoodsid().replace(".", "");
			strogeChangePo.setCshscgoodsbarcode(barcode);
			strogeChangePo.setCshscgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
			strogeChangePo.setCshscstockid(consignReceiptPo.getCstcprinstockid());
			strogeChangePo.setCshscgoodsquantity(consignProcessReceiptDetailsPo.getCstcprdnum());
			strogeChangePo.setCshsccostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
			strogeChangePo.setCshscnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
			strogeChangePo.setCshscchangeid(consignReceiptPo.getCstcprreceiptbillid());

			consignProcessTakeDao.insertStrogeChange(strogeChangePo);

		    // 新增库存日志表信息
			StrogeLogPo strogeLogPo = new StrogeLogPo();
			strogeLogPo.setCshslgoodsbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());
			strogeLogPo.setCshslgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
			strogeLogPo.setCshslstockid(consignReceiptPo.getCstcprinstockid());
			strogeLogPo.setCshslgoodsquantity(consignProcessReceiptDetailsPo.getCstcprdnum());
			strogeLogPo.setCshslcostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
			strogeLogPo.setCshslnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
			strogeLogPo.setCshslchangeid(consignReceiptPo.getCstcprreceiptbillid());

			consignProcessTakeDao.insertStrogeLog(strogeLogPo);
			
			StrogeChangePo changePo = new StrogeChangePo();
			changePo.setCshscgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
			changePo.setCshscgoodsbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());
			changePo.setCshscstockid(consignReceiptPo.getCstcprinstockid());
			changePo.setCshscgoodsquantity(consignProcessReceiptDetailsPo.getCstcprdnum());
			changePo.setCshsccostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
			changePo.setCshscnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
			changePo.setCshscchangeid(consignReceiptPo.getCstcprreceiptbillid());
			
			strogeChangeDao.insertStrogeChangeLogTemp(changePo, consignProcessReceiptDetailsPo.getCstcprdbarcode());// 商品库存当月库存变更表(9张新表)
			
			procurementReceiptDao.updateGoodsLastInStorageDate(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
		}
		
		if("X".equals(salesid.substring(0,1)) && "2".equals(Utility.getName(consignReceiptPo.getCstcprgoodscategory()))){        //框镜
			
			SalesBasicPo salesBasicPo = consignProcessTakeDao.getSalesBasicPo(salesid);
			
			WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
			warehouseConfigurationPo.setBwcdeptid(Utility.getName(salesBasicPo.getSsesbshopcode()));			
			warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(warehouseConfigurationPo);
			
			DepartmentsPo departmentsPo = new DepartmentsPo();
			departmentsPo.setBdpdepartmentid(salesBasicPo.getSsesbshopcode());   // 销售门店ID
			WarehousePo wpo = warehouseDao.getWarehousePo(departmentsPo);   // 获取门店所属仓位
			String tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();
			String bwhid = "";
			
			ConsignProcessOrderDetailsPo tcpo = new ConsignProcessOrderDetailsPo();
			tcpo.setCstcpodglassesbillid(salesid);
			List<ConsignProcessOrderDetailsPo> isdc = consignProcessTakeDao.selectGlassesIsDandC(tcpo);
			String goon = "";
			if(isdc.size() > 1){
				if(isdc.get(0).getCstcpiscustomize().equals(isdc.get(1).getCstcpiscustomize())){
					goon = "1";
				}
			}else{
				goon = "1";
			}
			
			
			if("1".equals(warehouseConfigurationPo.getBwcxiaocangww())&&"1".equals(goon)){//--消仓点在委外收货，即委外收货和发料一起执行；
				//--------------------赠品处理-------------------------------------
				if("2".equals(warehouseConfigurationPo.getBwcxiaocangzp2())){
					
					SalesDetailPo salesDetailPo=new SalesDetailPo();
					salesDetailPo.setSsesdsalesid(salesid);				
					List<SalesDetailPo> goodsInfoList = spectaclesMaterialsDao.selectGoodsDetailInfoes2(salesDetailPo);			

					if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
						bwhid = Utility.getName(wpo.getBwhid());
						gifeAutoAllocationToStore(tbillid,goodsInfoList,consignReceiptPo,inTransitPo,wpo,salesBasicPo);   // 赠品自动调拨至门店仓位
					}

					
					for(SalesDetailPo detailPo:goodsInfoList){
						//门店仓位消减赠品库存
						StrogeChangePo strogeChangePo = new StrogeChangePo();
						String barcode = detailPo.getSsesdsalesitemid().replace(".", "");
						strogeChangePo.setCshscgoodsbarcode(barcode);
						strogeChangePo.setCshscgoodsid(detailPo.getSsesdsalesitemid());
						strogeChangePo.setCshscstockid(bwhid.equals("") ? consignReceiptPo.getCstcprinstockid() : bwhid);
						strogeChangePo.setCshscgoodsquantity("-"+detailPo.getSsesdnumber());
						strogeChangePo.setCshsccostprice(detailPo.getSsesdcostsprive());
						strogeChangePo.setCshscnottaxrate(detailPo.getSsesdunitprice());
						strogeChangePo.setCshscchangeid(salesid);

						consignProcessTakeDao.insertStrogeChange(strogeChangePo);

					    // 新增库存日志表信息
						StrogeLogPo strogeLogPo = new StrogeLogPo();
						strogeLogPo.setCshslgoodsbarcode(detailPo.getGoodscode());
						strogeLogPo.setCshslgoodsid(detailPo.getSsesdsalesitemid());
						strogeLogPo.setCshslstockid(bwhid.equals("") ? consignReceiptPo.getCstcprinstockid() : bwhid);
						strogeLogPo.setCshslgoodsquantity("-"+detailPo.getSsesdnumber());
						strogeLogPo.setCshslcostprice(detailPo.getSsesdcostsprive());
						strogeLogPo.setCshslnottaxrate(detailPo.getSsesdunitprice());
						strogeLogPo.setCshslchangeid(salesid);

						consignProcessTakeDao.insertStrogeLog(strogeLogPo);
						
						StrogeChangePo changePo = new StrogeChangePo();
						changePo.setCshscgoodsid(detailPo.getSsesdsalesitemid());
						changePo.setCshscgoodsbarcode(detailPo.getGoodscode());
						changePo.setCshscstockid(bwhid.equals("") ? consignReceiptPo.getCstcprinstockid() : bwhid);
						changePo.setCshscgoodsquantity("-"+detailPo.getSsesdnumber());
						changePo.setCshsccostprice(detailPo.getSsesdcostsprive());
						changePo.setCshscnottaxrate(detailPo.getSsesdunitprice());
						changePo.setCshscchangeid(salesid);
						
						strogeChangeDao.insertStrogeChangeLogTemp(changePo, detailPo.getGoodscode());// 商品库存当月库存变更表(9张新表)					

						SalesDetailPo detailPo2=new SalesDetailPo();
						detailPo2.setSsesditemid(detailPo.getGoodscode());
						detailPo2.setSsesdstockid(detailPo.getSsesdstockid());   //出仓配置的仓位
						detailPo2.setSsesdsalesid(salesid);
						detailPo2.setSsesdid(detailPo.getSsesdid());
						detailPo2.setSsesdsalesitemid(detailPo.getSsesdsalesitemid());
						
						spectaclesMaterialsDao.updateDetailsBarcode(detailPo2);
					}
					
					//更新商品出库状态     in:退款   out:发料       1：出(入)库    0：未出(入)库
					guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesid,"out","1");
					//删除在途库存的商品
					InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("wwsh");  // wwsh 表示委外收货
					if (Utility.getName(inTransitStorageTypePo.getCshstindelete()).equals("1")){
						//删除在途库存的商品
						List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesid,"out","1");
						if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
							for (InTransitStorageEntryPo po : inTransitStorageEntryList){
								guitarManagementDao.deleteInTransitStroge(po);
							}
						}
					}
					
				}
				//--------------------赠品处理-------------------------------------
				
				if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
					bwhid = Utility.getName(wpo.getBwhid());
					if (!Utility.getName(consignReceiptPo.getCstcprinstockid()).equals(Utility.getName(wpo.getBwhid()))){      // 收货仓位和门店仓位相同						
						customizeAutoAllocationToStore(tbillid,consignReceiptPo,receiptList,inTransitPo,wpo,salesBasicPo);   // 定制片自动调拨至门店仓位
					}
				}
				
				for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : receiptList) {
					// 新增当月库存变更信息
					StrogeChangePo strogeChangePo = new StrogeChangePo();
					String barcode = consignProcessReceiptDetailsPo.getCstcprdgoodsid().replace(".", "");
					strogeChangePo.setCshscgoodsbarcode(barcode);
					strogeChangePo.setCshscgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
					strogeChangePo.setCshscstockid(bwhid.equals("") ? consignReceiptPo.getCstcprinstockid() : bwhid);
					strogeChangePo.setCshscgoodsquantity("-"+consignProcessReceiptDetailsPo.getCstcprdnum());
					strogeChangePo.setCshsccostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
					strogeChangePo.setCshscnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
					strogeChangePo.setCshscchangeid(salesid);

					consignProcessTakeDao.insertStrogeChange(strogeChangePo);

				    // 新增库存日志表信息
					StrogeLogPo strogeLogPo = new StrogeLogPo();
					strogeLogPo.setCshslgoodsbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());
					strogeLogPo.setCshslgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
					strogeLogPo.setCshslstockid(bwhid.equals("") ? consignReceiptPo.getCstcprinstockid() : bwhid);
					strogeLogPo.setCshslgoodsquantity("-"+consignProcessReceiptDetailsPo.getCstcprdnum());
					strogeLogPo.setCshslcostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
					strogeLogPo.setCshslnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
					strogeLogPo.setCshslchangeid(salesid);

					consignProcessTakeDao.insertStrogeLog(strogeLogPo);
					
					StrogeChangePo changePo = new StrogeChangePo();
					changePo.setCshscgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
					changePo.setCshscgoodsbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());
					changePo.setCshscstockid(bwhid.equals("") ? consignReceiptPo.getCstcprinstockid() : bwhid);
					changePo.setCshscgoodsquantity("-"+consignProcessReceiptDetailsPo.getCstcprdnum());
					changePo.setCshsccostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
					changePo.setCshscnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
					changePo.setCshscchangeid(salesid);
					
					strogeChangeDao.insertStrogeChangeLogTemp(changePo, consignProcessReceiptDetailsPo.getCstcprdbarcode());// 商品库存当月库存变更表(9张新表)
					
					SalesDetailPo salesDetailPo=new SalesDetailPo();
					salesDetailPo.setSsesditemid(consignProcessReceiptDetailsPo.getCstcprdbarcode());
					salesDetailPo.setSsesdstockid(consignReceiptPo.getCstcprinstockid());   //出仓配置的仓位
					salesDetailPo.setSsesdsalesid(salesid);
					salesDetailPo.setSsesdid(Utility.getName(consignProcessReceiptDetailsPo.getCstcpodsalesid()));
					salesDetailPo.setSsesdsalesitemid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
					
					spectaclesMaterialsDao.updateDetailsBarcode(salesDetailPo);
				}
				
				//更新商品出库状态     in:退款   out:发料       1：出(入)库    0：未出(入)库
				guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesid,"out","1");
				//删除在途库存的商品
				InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("wwsh");  // wwsh 表示委外收货
				if (Utility.getName(inTransitStorageTypePo.getCshstindelete()).equals("1")){
					//删除在途库存的商品
					List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesid,"out","1");
					if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
						for (InTransitStorageEntryPo po : inTransitStorageEntryList){
							guitarManagementDao.deleteInTransitStroge(po);
						}
					}
				}
				
				//更新基表
				inTransitPo.setSseitstate("6");
				consignProcessTakeDao.updateSalesBasic(salesid,inTransitPo.getSseitstate());
				//新增在途信息
				consignProcessTakeDao.insertIntransit(inTransitPo);
			}
			
		}
		
		// 新增业务单据主表信息
		FquartzSwitchPo fspo = reportQuartzDao.getFquartzSwitchPo();
		if ("1".equals(Utility.getName(fspo.getFqswashzwajs()))){
			inventoryTempPo.setCstitflag("1");
			consignProcessTakeDao.insertInventory(inventoryTempPo);
			consignProcessTakeDao.insertInventoryEntry(inventoryTempPo);
		}
		
		consignProcessTakeDao.insertInventoryTemp(inventoryTempPo);
		// 新增业务单据明细表信息
		for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : receiptList) {
			InventoryTempEntryPo inventoryTempEntryPo = new InventoryTempEntryPo();
			inventoryTempEntryPo.setCstietbillid(consignReceiptPo.getCstcprreceiptbillid());
			inventoryTempEntryPo.setCstietgoodsid(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
			inventoryTempEntryPo.setCstietgoodsquantity(consignProcessReceiptDetailsPo.getCstcprdnum());
			inventoryTempEntryPo.setCstietnottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
			inventoryTempEntryPo.setCstiettaxrate(consignProcessReceiptDetailsPo.getCstcprdtaxrate());
			inventoryTempEntryPo.setCstietcostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
			inventoryTempEntryPo.setCstietinstockid(consignReceiptPo.getCstcprinstockid());
			inventoryTempEntryPo.setCstietbarcode(consignProcessReceiptDetailsPo.getCstcprdbarcode());

			consignProcessTakeDao.insertInventoryTempEntry(inventoryTempEntryPo);
		}

		// 更新委外订单收货状态提交
		consignProcessTakeDao.updateSalesStatus(salesid);
		
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	/**
	 * 定制片自动调拨
	 */
	private void customizeAutoAllocationToStore(String tbillid,ConsignProcessReceiptPo consignReceiptPo,List<ConsignProcessReceiptDetailsPo> receiptList,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo){
	
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		String outStockID = Utility.getName(consignReceiptPo.getCstcprinstockid());                //委外收货的仓位
		String inStockID = Utility.getName(wpo.getBwhid());                                        //门店仓		
		String salesBillID = Utility.getName(salesBasicPo.getSsesbsalesid());                      //配镜单号
		String taxrate = "17";                // 税率
		
		InventoryPo inventoryPo=new InventoryPo();
		inventoryPo.setCstioutstockid(outStockID); //委外收货的仓位
		inventoryPo.setCstibillid(tbillid);
		inventoryPo.setCstibilltypeid("4");
		inventoryPo.setCstiinstockid(inStockID);		//门店仓			
		inventoryPo.setCstidepartmentid(inTransitPo.getSseitdepartment());  //收货部门
		inventoryPo.setCsticreateperson(inTransitPo.getSseitcreateperson());
		inventoryPo.setCstiauditperson(inTransitPo.getSseitcreateperson());
		inventoryPo.setCstisourcebillid(salesBillID);      //配镜单号
		inventoryPo.setCstiremark("委外收货订制片自动调拨");
		inventoryPo.setCstigoodscategory("29");       //特殊标志,29标识委外收货自动调拨
		
		inventoryList.add(inventoryPo);
		
		for (ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo : receiptList) {
			
			taxrate = spectaclesMaterialsDao.getGoodsTaxRateByID(Utility.getName(consignProcessReceiptDetailsPo.getCstcprdgoodsid())).getBgitaxrate();
			
			nottaxrateamount = new BigDecimal(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
			costpriceamount = new BigDecimal(consignProcessReceiptDetailsPo.getCstcprdcostprice());
			goodsNum = new BigDecimal(consignProcessReceiptDetailsPo.getCstcprdnum());
			
			nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(tbillid);
			inventoryEntryPo.setCstiegoodsid(Utility.getName(consignProcessReceiptDetailsPo.getCstcprdgoodsid()));
			inventoryEntryPo.setCstiegoodsquantity(consignProcessReceiptDetailsPo.getCstcprdnum());
			inventoryEntryPo.setCstienottaxrate(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
			inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
			inventoryEntryPo.setCstietaxrate(taxrate);
			inventoryEntryPo.setCstiecostprice(consignProcessReceiptDetailsPo.getCstcprdcostprice());
			inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
			inventoryEntryPo.setCstietaxamount(taxamount.toString());			
			inventoryEntryPo.setCstieinstockid(inStockID);
			inventoryEntryPo.setCstieoutstockid(outStockID);			
			inventoryEntryPo.setCstiebarcode(Utility.getName(consignProcessReceiptDetailsPo.getCstcprdbarcode()));	
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstieremark("委外收货订制片");
			inventoryEntryPo.setCstieautoallocationflag("1");
			inventoryEntryPo.setCstiesalesbillid(salesBillID);
			
			inventoryEntryList.add(inventoryEntryPo);
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
			
			//门店增加库存
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
			
			//出仓配置的仓位减少库存
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
			stockID = po.getCstieinstockid();
			po.setCstieinstockid(po.getCstieoutstockid()); //用出仓配置的仓位赋值
			po.setCstieoutstockid(stockID);			
			
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
			
			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
		}		
		
	}	
	
	/**
	 * 赠品自动调拨
	 */
	private void gifeAutoAllocationToStore(String allocationID,List<SalesDetailPo> salesDetailList,ConsignProcessReceiptPo consignReceiptPo,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo){
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		String salesBillID = Utility.getName(salesBasicPo.getSsesbsalesid());                      //配镜单号
		
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
				inventoryPo.setCstisourcebillid(salesBillID);      //配镜单号
				inventoryPo.setCstiremark("委外收货赠品自动调拨");
				inventoryPo.setCstigoodscategory("29");       //特殊标志,29标识委外收货赠品自动调拨
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
				inventoryEntryPo.setCstieremark("委外收货赠品");
				inventoryEntryPo.setCstieautoallocationflag("1");
				inventoryEntryPo.setCstiesalesbillid(salesBillID);
				
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
			
			//门店增加库存
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
			
			//出仓配置的仓位减少库存
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
			stockID = po.getCstieinstockid();
			po.setCstieinstockid(po.getCstieoutstockid()); //用出仓配置的仓位赋值
			po.setCstieoutstockid(stockID);
			
			
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
			
			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
		}		
//		WarehouseConfigurationPo cpo = new WarehouseConfigurationPo();
//		cpo.setBwcdeptid(salesBasicPo.getSsesbshopcode());
//		cpo = warehouseConfigurationDao.getWarehouseConfiguration(cpo);  // 获取门店出仓配置的赠品出仓仓位
//		
//		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
//		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
//		
//		BigDecimal nottaxrateamount = null;  //成本合计
//		BigDecimal costpriceamount = null;   //价税合计
//		BigDecimal goodsNum = null;          //商品数量
//		BigDecimal taxamount = null;         //税额合计
//		
//		String outStockID = Utility.getName(cpo.getBwcstockid10());                //委外收货的仓位
//		String inStockID = Utility.getName(wpo.getBwhid());                                        //门店仓		
//		String salesBillID = Utility.getName(salesBasicPo.getSsesbsalesid());                      //配镜单号
//		
//		if (!Utility.getName(consignReceiptPo.getCstcprinstockid()).equals(Utility.getName(cpo.getBwcstockid10())) || !Utility.getName(consignReceiptPo.getCstcprinstockid()).equals(Utility.getName(cpo.getBwcstockid10()))){      // 收货仓位和赠品出仓配置不相同
//			allocationID = "ALL" + GenerateNumber.getInstance().getGenerageNumber();
//			
//			InventoryPo inventoryPo=new InventoryPo();
//			inventoryPo.setCstioutstockid(outStockID); //委外收货的仓位
//			inventoryPo.setCstibillid(allocationID);
//			inventoryPo.setCstibilltypeid("4");
//			inventoryPo.setCstiinstockid(inStockID);		//门店仓			
//			inventoryPo.setCstidepartmentid(inTransitPo.getSseitdepartment());  //收货部门
//			inventoryPo.setCsticreateperson(inTransitPo.getSseitcreateperson());
//			inventoryPo.setCstiauditperson(inTransitPo.getSseitcreateperson());
//			inventoryPo.setCstisourcebillid(salesBillID);      //配镜单号
//			inventoryPo.setCstiremark("委外收货赠品自动调拨");
//			inventoryPo.setCstigoodscategory("29");       //特殊标志,29标识委外收货自动调拨
//			
//			inventoryList.add(inventoryPo);
//		}
//		
//		for (SalesDetailPo po : salesDetailList){
//			
//			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));
//			
//			if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(po.getSsesdstockid()))){
//				continue;
//			}
//			
//			nottaxrateamount = new BigDecimal(po.getSsesdunitprice());
//			costpriceamount = new BigDecimal(po.getSsesdcostsprive());
//			goodsNum = new BigDecimal(po.getSsesdnumber());
//			
//			nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
//			costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
//			taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
//			
//			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
//			inventoryEntryPo.setCstiebillid(allocationID);
//			inventoryEntryPo.setCstiegoodsid(po.getSsesdsalesitemid());
//			inventoryEntryPo.setCstiegoodsquantity(po.getSsesdnumber());
//			inventoryEntryPo.setCstienottaxrate(po.getSsesdunitprice());
//			inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
//			inventoryEntryPo.setCstietaxrate(goodsInfoPo.getBgitaxrate());
//			inventoryEntryPo.setCstiecostprice(po.getSsesdcostsprive());
//			inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
//			inventoryEntryPo.setCstietaxamount(taxamount.toString());
//			inventoryEntryPo.setCstieinstockid(inStockID);
//			inventoryEntryPo.setCstieoutstockid(outStockID);
//			inventoryEntryPo.setCstiebarcode(po.getSsesditemid());
//			inventoryEntryPo.setCstieoutstorageflag("1");
//			inventoryEntryPo.setCstieremark("委外收货赠品");
//			inventoryEntryPo.setCstieautoallocationflag("1");
//			inventoryEntryPo.setCstiesalesbillid(salesBillID);
//			
//			inventoryEntryList.add(inventoryEntryPo);
//		}
//		
//		for (InventoryPo po : inventoryList){
//			spectaclesMaterialsDao.inertAutoAllocationToStore(po);
//			spectaclesMaterialsDao.inertAutoAllocationBillToStore(po);
//		}
//		
//		String stockID = null;
//		for (InventoryEntryPo po : inventoryEntryList){
//			
//			spectaclesMaterialsDao.inertAutoAllocationEntryToStore(po);
//			spectaclesMaterialsDao.inertAutoAllocationBarcodeToStore(po);
//
//			spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
//			spectaclesMaterialsDao.inertAutoAllocationBillBarcodeToStore(po);
//			
//			//门店增加库存
//			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
//			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
//			
//			StrogeChangePo strogeChangePo=new StrogeChangePo();
//			strogeChangePo.setCshscgoodsbarcode(po.getCstiebarcode());
//			strogeChangePo.setCshscgoodsid(po.getCstiegoodsid());
//			strogeChangePo.setCshscstockid(po.getCstieinstockid());
//			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
//			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
//			strogeChangePo.setCshsccostprice(po.getCstiecostprice());	
//			strogeChangePo.setCshscnottaxrate(po.getCstienottaxrate());		
//			strogeChangePo.setCshscchangeid(po.getCstiebillid());
//			strogeChangePo.setCshscautoallocationflag(po.getCstieautoallocationflag());
//			strogeChangePo.setCshscguaranteeperiod(po.getCstieguaranteeperiod());
//			strogeChangePo.setCshscBatch(po.getCstiebatch());
//			strogeChangePo.setCshscsalesbillid(po.getCstiesalesbillid());
//
//			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
//			
//			//出仓配置的仓位减少库存
//			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
//			stockID = po.getCstieinstockid();
//			po.setCstieinstockid(po.getCstieoutstockid()); //用出仓配置的仓位赋值
//			po.setCstieoutstockid(stockID);			
//			
//			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
//			strogeChangePo.setCshscstockid(po.getCstieinstockid());
//			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
//			
//			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
//			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
//			
//			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
//		}		
		
	}	
	
	/**
	 * 得到订单系统发货信息数量
	 * 
	 * @param consignProcessReceiptPo
	 * @return
	 */
	public int getdeliveryCount(ConsignProcessReceiptPo consignProcessReceiptPo) {
		return consignProcessTakeDao.getdeliveryCount(consignProcessReceiptPo);
	}

	/**
	 * 得到订单系统发货信息
	 * 
	 * @param consignProcessReceiptPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessReceiptPo> selectdeliveryList(
			ConsignProcessReceiptPo consignProcessReceiptPo, int start, int size) {
		return consignProcessTakeDao.selectdeliveryList(
				consignProcessReceiptPo, start, size);
	}
	
	/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesidsW(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo){
		return consignProcessTakeDao.getSalesidsW(consignProcessOrderDetailsPo);
	}

/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesidsW(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size){
		return consignProcessTakeDao.selectSalesidsW(
				consignProcessOrderDetailsPo, start, size);
	}
	
	/**
	 * 查询配镜单中的镜架、太阳镜、老花镜
	 */
	public List<ConsignProcessOrderDetailsPo> getFrameGoods(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo){
		return consignProcessTakeDao.getFrameGoods(consignProcessOrderDetailsPo);
	}
	
}
