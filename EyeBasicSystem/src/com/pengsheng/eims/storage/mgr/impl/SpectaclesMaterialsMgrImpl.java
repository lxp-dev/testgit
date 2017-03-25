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
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.AllocationDao;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.SpectaclesMaterialsMgr;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class SpectaclesMaterialsMgrImpl implements SpectaclesMaterialsMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private SpectaclesMaterialsDao spectaclesMaterialsDao;
	private GuitarManagementDao guitarManagementDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private AllocationDao allocationDao = null;
	private WarehouseDao warehouseDao = null;
	private StrogeChangeDao strogeChangeDao;	
	private WarehouseConfigurationDao warehouseConfigurationDao = null;
	private SystemParameterDao systemParameterDao = null;
	private SystemParameterPo systemParameterPo = null;
	
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
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
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
	
	public SpectaclesMaterialsDao getSpectaclesMaterialsDao() {
		return spectaclesMaterialsDao;
	}

	public void setSpectaclesMaterialsDao(
			SpectaclesMaterialsDao spectaclesMaterialsDao) {
		this.spectaclesMaterialsDao = spectaclesMaterialsDao;
	}

	/**
	 * 查询配镜发料信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSpectaclesMaterialsCount(SalesBasicPo salesBasicPo) {
		return spectaclesMaterialsDao.getSpectaclesMaterialsCount(salesBasicPo);
	}

	/**
	 * 查询配镜发料信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectSpectaclesMaterials(
			SalesBasicPo salesBasicPo, int start, int size) {
		return spectaclesMaterialsDao.selectSpectaclesMaterials(salesBasicPo, start, size);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		return spectaclesMaterialsDao.getODDetailInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		return spectaclesMaterialsDao.getOSDetailInfo(salesBasicPo);
	}

	/**
	 * 得到订单及顾客信息 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getSalesDetailInfo(SalesBasicPo salesBasicPo) {
		return spectaclesMaterialsDao.getSalesDetailInfo(salesBasicPo);
	}
	
	/**
	 * 得到销售单中商品个数
	 * @param salesDetailPo
	 * @return
	 */
	public int getGoodsDetailCount(SalesDetailPo salesDetailPo) {
		return spectaclesMaterialsDao.getGoodsDetailCount(salesDetailPo);
	}

	/**
	 * 得到销售单中商品信息
	 * @param salesDetailPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(
			SalesDetailPo salesDetailPo, int start, int size) {
		return spectaclesMaterialsDao.selectGoodsDetailInfo(salesDetailPo, start, size);
	}
	
	public List<SalesDetailPo> selectGoodsDetailInfoes(
			SalesDetailPo salesDetailPo) {
		return spectaclesMaterialsDao.selectGoodsDetailInfoes(salesDetailPo);
	}

	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo) {
		return spectaclesMaterialsDao.getdepartment(departmentsPo);
	}

	/**
	 * 新增发料信息
	 * @param inTransitPo
	 * @param salesPo
	 * @param goodsid
	 * @param stockid
	 * @param number
	 * @param costsprive
	 * @param unitprice
	 * @param goodsCode
	 * @param salesId
	 */
	public void insertMaterials(SystemParameterPo systemParameterPo,InTransitPo inTransitPo, SalesBasicPo salesPo,
			String[] goodsid, String[] stockid, String[] number,
			String[] costsprive, String[] unitprice, String[] goodsCode,
			String salesId,LogisticsLogPo logPo,String[] ssesdid) {
		
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(salesId);			
		salesBasicPo = inTransitDetailsDao.getCustomerInfo(salesBasicPo);
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(salesBasicPo.getSsesbshopcode());
		WarehousePo wpo = warehouseDao.getWarehousePo(departmentsPo);
		String bwhid = Utility.getName(wpo.getBwhid());
		
		//当月库存变更表
		if(goodsid.length != 0){
			
			List<StrogeChangePo> strogeChangeList = new ArrayList<StrogeChangePo>();
			List<StrogeChangePo> strogeChangelogList = new ArrayList<StrogeChangePo>();
			List<SalesDetailPo> salesDetailList = new ArrayList<SalesDetailPo>();
			
			int count = goodsid.length;
			for (int i = 0; i < goodsCode.length; i++){				
				if (i >= count){
	                break;
				}
				
				if (!Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
					bwhid = stockid[i];
				}
				
				String SupplierID=goodsid[i].split("\\.")[1];
				if(!"zz".equals(SupplierID)){
					
					StrogeChangePo strogeChangePo = new StrogeChangePo();
					strogeChangePo.setCshscgoodsbarcode(goodsid[i].replace(".", ""));
					strogeChangePo.setCshscgoodsid(goodsid[i]);
					strogeChangePo.setCshscstockid(bwhid);  // 门店仓位
					strogeChangePo.setCshscgoodsquantity(number[i]);
					strogeChangePo.setCshsccostprice(costsprive[i]);
					strogeChangePo.setCshscnottaxrate(unitprice[i]);
					strogeChangePo.setCshscchangeid(salesId);
					
					strogeChangeList.add(strogeChangePo);
					
					StrogeChangePo strogeChangeLogPo = new StrogeChangePo();					
					strogeChangeLogPo.setCshscgoodsbarcode(goodsCode[i]);
					strogeChangeLogPo.setCshscgoodsid(goodsid[i]);
					strogeChangeLogPo.setCshscstockid(bwhid);  // 门店仓位
					strogeChangeLogPo.setCshscgoodsquantity(number[i]);
					strogeChangeLogPo.setCshsccostprice(costsprive[i]);
					strogeChangeLogPo.setCshscnottaxrate(unitprice[i]);
					strogeChangeLogPo.setCshscchangeid(salesId);
					
					strogeChangelogList.add(strogeChangeLogPo);
				}
				
				SalesDetailPo salesDetailPo=new SalesDetailPo();
				salesDetailPo.setSsesditemid(goodsCode[i]);
				salesDetailPo.setSsesdstockid(stockid[i]);   //出仓配置的仓位
				salesDetailPo.setSsesdsalesid(salesId);
				salesDetailPo.setSsesdid(ssesdid[i]);
				salesDetailPo.setSsesdsalesitemid(goodsid[i]);
				
				salesDetailPo.setSsesdunitprice(unitprice[i]); //不含税成本
				salesDetailPo.setSsesdcostsprive(costsprive[i]); //含税成本
				salesDetailPo.setSsesdnumber(number[i]); //销售数量
				
				salesDetailList.add(salesDetailPo);
				
				spectaclesMaterialsDao.updateDetailsBarcode(salesDetailPo);
			}
						
			//自动调拨,通过调拨，出仓配置仓位减少镜片库存,门店仓位增加镜片库存
			if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
				autoAllocationToStore(systemParameterPo,salesDetailList,salesId,inTransitPo,wpo,salesBasicPo);
			}
			
			
			//门店仓位消减镜片库存
			for (StrogeChangePo strogeChangePo : strogeChangeList){
				spectaclesMaterialsDao.insertStrogeChange(strogeChangePo);
			}			
			for (StrogeChangePo strogeChangeLogPo : strogeChangelogList){
				spectaclesMaterialsDao.insertStrogeChangeLog(strogeChangeLogPo);
				strogeChangeLogPo.setCshscgoodsquantity("-"+strogeChangeLogPo.getCshscgoodsquantity());
				strogeChangeDao.insertStrogeChangeLogTemp(strogeChangeLogPo, strogeChangeLogPo.getCshscgoodsbarcode());
			}
			
		}
		
		WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(Utility.getName(salesBasicPo.getSsesbshopcode()));			
		warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(warehouseConfigurationPo);
		
		String tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();

		if("2".equals(warehouseConfigurationPo.getBwcxiaocangzp2())){ //赠品出仓点设置为发料出仓
			
			SalesDetailPo salesDetailPo=new SalesDetailPo();
			salesDetailPo.setSsesdsalesid(salesId);				
			List<SalesDetailPo> goodsInfoList = spectaclesMaterialsDao.selectGoodsDetailInfoes2(salesDetailPo);				

			if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
				bwhid = Utility.getName(wpo.getBwhid());
				giftautoAllocationToStore(systemParameterPo,goodsInfoList,salesId,inTransitPo,wpo,salesBasicPo);   // 赠品自动调拨至门店仓位
			}

			for(SalesDetailPo detailPo:goodsInfoList){
				//门店仓位消减赠品库存
				StrogeChangePo strogeChangePo = new StrogeChangePo();
				String barcode = detailPo.getSsesdsalesitemid().replace(".", "");
				strogeChangePo.setCshscgoodsbarcode(barcode);
				strogeChangePo.setCshscgoodsid(detailPo.getSsesdsalesitemid());
				strogeChangePo.setCshscstockid(bwhid);
				strogeChangePo.setCshscgoodsquantity(detailPo.getSsesdnumber());
				strogeChangePo.setCshsccostprice(detailPo.getSsesdcostsprive());
				strogeChangePo.setCshscnottaxrate(detailPo.getSsesdunitprice());
				strogeChangePo.setCshscchangeid(salesId);

				spectaclesMaterialsDao.insertStrogeChange(strogeChangePo);
				
				StrogeChangePo strogeChangeLogPo = new StrogeChangePo();
				strogeChangeLogPo.setCshscgoodsbarcode(detailPo.getSsesditemid());
				strogeChangeLogPo.setCshscgoodsid(detailPo.getSsesdsalesitemid());
				strogeChangeLogPo.setCshscstockid(bwhid);
				strogeChangeLogPo.setCshscgoodsquantity(detailPo.getSsesdnumber());
				strogeChangeLogPo.setCshsccostprice(detailPo.getSsesdcostsprive());
				strogeChangeLogPo.setCshscnottaxrate(detailPo.getSsesdunitprice());
				strogeChangeLogPo.setCshscchangeid(salesId);
				spectaclesMaterialsDao.insertStrogeChangeLog(strogeChangeLogPo);
				
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(detailPo.getSsesdsalesitemid());
				changePo.setCshscgoodsbarcode(detailPo.getSsesditemid());
				changePo.setCshscstockid(bwhid);
				changePo.setCshscgoodsquantity(detailPo.getSsesdnumber());
				changePo.setCshsccostprice(detailPo.getSsesdcostsprive());
				changePo.setCshscnottaxrate(detailPo.getSsesdunitprice());
				changePo.setCshscchangeid(salesId);
				
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, detailPo.getSsesditemid());// 商品库存当月库存变更表(9张新表)	
			}
			
			//更新商品出库状态     in:退款   out:发料       1：出(入)库    0：未出(入)库
			guitarManagementDao.updateStrogeChangeUnFinishedFlagZengPin(salesId,"out","1");	
			
		}
		
		//新增在途信息
		spectaclesMaterialsDao.insertIntrnsitInfo(inTransitPo);
		//更新基表
		spectaclesMaterialsDao.updateMaterialsInTransit(salesPo);
		
		//更新商品出库状态     in:退款   out:发料       1：出(入)库    0：未出(入)库
		guitarManagementDao.updateStrogeChangeUnFinishedFlagNoZengPin(salesId,"out","1","faliao");		
		
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("pjfl");  // pjfl 表示配镜发料
		if (Utility.getName(inTransitStorageTypePo.getCshstindelete()).equals("1")){
			//删除在途库存的商品
			List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesId,"out","1");
			if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
				for (InTransitStorageEntryPo po : inTransitStorageEntryList){
					guitarManagementDao.deleteInTransitStroge(po);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 发料时判断销售单在途
	 * @param String
	 * @return
	 */
	public int selectIsSend(String salesid){
		return spectaclesMaterialsDao.selectIsSend(salesid);
	}

	/**
	 * 自动调拨（从出仓仓位到门店仓位）
	 */
	private void autoAllocationToStore(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailList,String billID,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo){
		
		WarehouseConfigurationPo cpo = new WarehouseConfigurationPo();
		cpo.setBwcdeptid(salesBasicPo.getSsesbshopcode());
		cpo = warehouseConfigurationDao.getWarehouseConfiguration(cpo);
		
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		String firstStock = "";              //一只镜片的出仓配置的仓位
		String secondStock = "";             //另一只镜片的出仓配置的仓位
		String tbillid = "";                 //调拨单号
		
		for (SalesDetailPo po : salesDetailList){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));
			
			if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(po.getSsesdstockid()))){
				continue;
			}
			
			if (Utility.getName(goodsInfoPo.getBgigoodscategoryid()).equals("3")){				

				secondStock = Utility.getName(po.getSsesdstockid());
								
				if (!firstStock.equals(secondStock) && !goodsInfoPo.getBgisupplierid().equals("ZZ")){   //用于区分成品片和订制片、自片
					
					tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();
					
					InventoryPo inventoryPo=new InventoryPo();
					inventoryPo.setCstioutstockid(secondStock); //出仓配置的镜片消仓仓位
					inventoryPo.setCstibillid(tbillid);
					inventoryPo.setCstibilltypeid("4");
					inventoryPo.setCstiinstockid(Utility.getName(wpo.getBwhid()));		//门店仓			
					inventoryPo.setCstidepartmentid(inTransitPo.getSseitdepartment());  //发料部门
					inventoryPo.setCsticreateperson(inTransitPo.getSseitcreateperson());
					inventoryPo.setCstiauditperson(inTransitPo.getSseitcreateperson());
					inventoryPo.setCstisourcebillid(billID);      //配镜单号
					inventoryPo.setCstiremark("配镜发料自动调拨");
					inventoryPo.setCstigoodscategory("21");       //特殊标志,21标识发料自动调拨
					inventoryPo.setCstifinanceauditperson(inTransitPo.getSseitcreateperson());
					inventoryPo.setCstifinanceauditstate("1");
					
					inventoryList.add(inventoryPo);
					
					firstStock = secondStock;   //用于区分成品片和订制片
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
					inventoryEntryPo.setCstieremark("配镜发料");
					inventoryEntryPo.setCstieautoallocationflag("1");
					inventoryEntryPo.setCstiesalesbillid(billID);
					
					inventoryEntryList.add(inventoryEntryPo);
				}
			}
		}
		
		for (InventoryPo po : inventoryList){
			spectaclesMaterialsDao.inertAutoAllocationToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBillToStore(po);
		}
		
		String stockID = null;
		for (InventoryEntryPo po : inventoryEntryList){
			
			spectaclesMaterialsDao.inertAutoAllocationEntryToStore(po);

			spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
			
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
	/**
	 * 自动调拨（从出仓仓位到门店仓位）
	 */
	private void giftautoAllocationToStore(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailList,String billID,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo){
		
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
				inventoryPo.setCstiremark("配镜发料自动调拨");
				inventoryPo.setCstigoodscategory("21");       //特殊标志,21标识门店结款自动调拨
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
				inventoryEntryPo.setCstieremark("配镜发料");
				inventoryEntryPo.setCstieautoallocationflag("1");
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

			spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
			
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
	 * 查询未打印发料单的总数
	 */
	public int getPrintSpectaclesMaterialsBillCount(SalesBasicPo salesBasicPo){
		return spectaclesMaterialsDao.getPrintSpectaclesMaterialsBillCount(salesBasicPo);
	}
	
	/**
	 * 查询未打印发料单
	 */
	public List<SalesBasicPo> selectPrintSpectaclesMaterialsBill(SalesBasicPo salesBasicPo , int start , int size){
		return spectaclesMaterialsDao.selectPrintSpectaclesMaterialsBill(salesBasicPo,start,size);
	}	
	
	/**
	 * 批量新增发料信息
	 */
	public void insertMaterialsBatch(SystemParameterPo systemParameterPo,InTransitPo inTransitPo,List<SalesBasicPo> poList,LogisticsLogPo logPo){		

		String[] goodsid = null ;
		String[] stockid = null;
		String[] number = null;
		String[] goodsCode = null;
		String[] costsprive = null;
		String[] unitprice = null;
		String[] ssesdid = null;
		List<SalesDetailPo> goodsInfoList = null;
		
		for (int i = 0; i < poList.size(); i++){
			SalesBasicPo spo = new SalesBasicPo();
			spo.setSsesbsalesid(poList.get(i).getSsesbsalesid());
			
			inTransitPo.setSseitsalesid(poList.get(i).getSsesbsalesid());
			
			goodsInfoList = spectaclesMaterialsDao.selectGoodsDetailInfo(spo);
			
			int goodscount = goodsInfoList.size();
			
			goodsid = new String[goodscount] ;
			stockid = new String[goodscount];
			number = new String[goodscount];
			goodsCode = new String[goodscount];
			costsprive = new String[goodscount];
			unitprice = new String[goodscount];
			ssesdid = new String[goodscount];
			
			for (int n = 0; n < goodscount; n++){
				goodsid[n] = goodsInfoList.get(n).getSsesdsalesitemid();
				stockid[n] = goodsInfoList.get(n).getSsesdstockid();
				number[n] = goodsInfoList.get(n).getSsesdnumber();
				goodsCode[n] = goodsInfoList.get(n).getGoodscode();
				costsprive[n] = goodsInfoList.get(n).getSsesdcostsprive();
				unitprice[n] = goodsInfoList.get(n).getSsesdunitprice();
				ssesdid[n] = goodsInfoList.get(n).getSsesdid();
			}
			
			logPo.setsLogContent(logPo.getsLogContent()+poList.get(i).getSsesbsalesid());
			this.insertMaterials(systemParameterPo,inTransitPo, poList.get(i), goodsid, stockid, number, costsprive, unitprice, goodsCode, poList.get(i).getSsesbsalesid(), logPo, ssesdid);
			
		}		

	}
	
	/**
	 * 获取发料商品
	 */
	public List<SalesDetailPo> selectGoodsDetailInfo(SalesBasicPo po){
		return spectaclesMaterialsDao.selectGoodsDetailInfo(po);
	}
	
}
