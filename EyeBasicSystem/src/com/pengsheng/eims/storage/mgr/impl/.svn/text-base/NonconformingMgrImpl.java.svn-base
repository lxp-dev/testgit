package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.dao.AllocationDao;
import com.pengsheng.eims.storage.dao.NonconformingDao;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.NonconformingMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.NonconformingEntryPo;
import com.pengsheng.eims.storage.persistence.NonconformingPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class NonconformingMgrImpl implements NonconformingMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private AllocationMgr allocationMgr = null;
	private InTransitDetailsDao inTransitDetailsDao;
	private SpectaclesMaterialsDao spectaclesMaterialsDao;
	private StrogeChangeDao strogeChangeDao;
	
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public SpectaclesMaterialsDao getSpectaclesMaterialsDao() {
		return spectaclesMaterialsDao;
	}

	public void setSpectaclesMaterialsDao(
			SpectaclesMaterialsDao spectaclesMaterialsDao) {
		this.spectaclesMaterialsDao = spectaclesMaterialsDao;
	}

	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private NonconformingDao nonconformingDao;

	/**
	 * 得到不合格商品信息总数
	 */
	public int getNonconformingCount(NonconformingPo po) {

		return nonconformingDao.getNonconformingCount(po);
	}

	/**
	 * 得到不合格商品信息
	 */
	public List<NonconformingPo> getNonconformingList(NonconformingPo po,
			int start, int size) {

		return nonconformingDao.getNonconformingList(po, start, size);
	}

	/**
	 * 在业务及业务明细表中添加不合格品信息
	 */
	public void insertNonconforming(NonconformingPo po,List<NonconformingEntryPo> list,LogisticsLogPo logPo,AllocationPo allocationPo, List<AllocationEntryPo> elist,SmsLertsPo smsLertsPo, List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo1) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		nonconformingDao.insertNonconforming(po);// 单据主表
		nonconformingDao.deleteNonconformingEntry(po);// 删除单据明细表

		Iterator<NonconformingEntryPo> it = list.iterator();
		while (it.hasNext()) {
			NonconformingEntryPo entryPo = it.next();
			nonconformingDao.insertNonconformingEntry(entryPo);// 单据明细表
		}

		// 生成负调拨单4--------------------------------------------------------------------------
		if ("1".equals(Utility.getName(po.getCshanisallocation()))) {
			allocationMgr.insertAllocation(allocationPo, elist, smsLertsPo, null, allocationBarcodeList,logPo1);
		}
		// 生成负调拨单4--------------------------------------------------------------------------
		
	}

	/**
	 * 更新业务及业务明细表中的数据
	 */
	public void updateNonconforming(NonconformingPo po,
			List<NonconformingEntryPo> list) {

		nonconformingDao.updateNonconforming(po);// 单据主表
		nonconformingDao.deleteNonconformingEntry(po);// 删除单据明细表

		Iterator<NonconformingEntryPo> it = list.iterator();
		while (it.hasNext()) {
			NonconformingEntryPo entryPo = it.next();
			nonconformingDao.insertNonconformingEntry(entryPo);// 单据明细表
		}

	}

	public void updateNonconforming(NonconformingPo po,List<NonconformingEntryPo> list, String flag,LogisticsLogPo logPo,AllocationPo allocationPo, List<AllocationEntryPo> elist,SmsLertsPo smsLertsPo, List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo1) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		if (!"1".equals(flag)) {
			nonconformingDao.updateNonconforming(po);// 单据主表
		} else {
			nonconformingDao.doNonconforming(po);
		}

		nonconformingDao.deleteNonconformingEntry(po);// 删除单据明细表

		Iterator<NonconformingEntryPo> it = list.iterator();
		while (it.hasNext()) {
			NonconformingEntryPo entryPo = it.next();
			nonconformingDao.insertNonconformingEntry(entryPo);// 单据明细表
		}
		
		// 生成负调拨单4--------------------------------------------------------------------------
		if ("1".equals(Utility.getName(po.getCshanisallocation()))) {
			allocationMgr.insertAllocation(allocationPo, elist, smsLertsPo, null, allocationBarcodeList,logPo1);
		}
		// 生成负调拨单4--------------------------------------------------------------------------

	}
	
	public void updateNonconforming(NonconformingPo po,List<NonconformingEntryPo> list, String flag,LogisticsLogPo logPo,List<AllocationEntryPo> elist) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		if (!"1".equals(flag)) {
			nonconformingDao.updateNonconforming(po);// 单据主表
		} else {
			nonconformingDao.doNonconforming(po);
		}

		nonconformingDao.deleteNonconformingEntry(po);// 删除单据明细表

		Iterator<NonconformingEntryPo> it = list.iterator();
		while (it.hasNext()) {
			NonconformingEntryPo entryPo = it.next();
			nonconformingDao.insertNonconformingEntry(entryPo);// 单据明细表
		}
		
		//不合格品单自动调拨收货
		if ((Utility.getName(po.getCshanautoallocation()).equals("1")) && (elist.size() > 0)){
			autoAllocationTo(po,elist);
		}
		
	}
	
	/**
	 * 不合格品单自动调拨收货
	 */
	private void autoAllocationTo(NonconformingPo npo,List<AllocationEntryPo> elist){

		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		String tbillid = npo.getCshanbillid().replaceFirst("NCP", "ALLN"); //调拨单号
		
		InventoryPo inventoryPo = new InventoryPo();
		inventoryPo.setCstioutstockid(npo.getCshanoutstockid());
		inventoryPo.setCstibillid(tbillid);
		inventoryPo.setCstibilltypeid("4");
		inventoryPo.setCstiinstockid(Utility.getName(npo.getCshaninstockid()));
		inventoryPo.setCstidepartmentid(npo.getCshanconsigndeparmentid()); 
		inventoryPo.setCsticreateperson(npo.getCshanauditperson());
		inventoryPo.setCstiauditperson(npo.getCshanconsignperson());
		inventoryPo.setCstisourcebillid(npo.getCshanbillid());      //不合格品单号
		inventoryPo.setCstiremark("不合格品单自动调拨");
		inventoryPo.setCstigoodscategory("30");       //特殊标志,30标识不合格品自动调拨
		inventoryPo.setCstifinanceauditperson(npo.getCshanconsignperson());
		inventoryPo.setCstifinanceauditstate("1");
		
		for (AllocationEntryPo epo : elist){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(epo.getCshaaegoodsid()));		
		
			nottaxrateamount = new BigDecimal(goodsInfoPo.getBginottaxrate());
			costpriceamount = new BigDecimal(goodsInfoPo.getBgicostprice());
			goodsNum = new BigDecimal(epo.getCshaaeallocationquantity());
			
			nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
			taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(tbillid);
			inventoryEntryPo.setCstiegoodsid(epo.getCshaaegoodsid());
			inventoryEntryPo.setCstiegoodsquantity(epo.getCshaaeallocationquantity());
			inventoryEntryPo.setCstienottaxrate(goodsInfoPo.getBginottaxrate());
			inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
			inventoryEntryPo.setCstietaxrate(goodsInfoPo.getBgitaxrate());
			inventoryEntryPo.setCstiecostprice(goodsInfoPo.getBgicostprice());
			inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
			inventoryEntryPo.setCstietaxamount(taxamount.toString());
			inventoryEntryPo.setCstieinstockid(epo.getCshaainstockid());
			inventoryEntryPo.setCstieoutstockid(epo.getCshaaoutstockid());
			inventoryEntryPo.setCstiebarcode(epo.getCshaaegoodsBarCode());
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstieremark("不合格品单自动调拨");
			inventoryEntryPo.setCstieautoallocationflag("1");
			inventoryEntryPo.setCstiesalesbillid(npo.getCshanbillid());
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		spectaclesMaterialsDao.inertAutoAllocationToStore(inventoryPo);
		spectaclesMaterialsDao.inertAutoAllocationBillToStore(inventoryPo);
		
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
	 * 得到不合格品详细信息
	 */
	public NonconformingPo getNonconforming(NonconformingPo po) {

		return nonconformingDao.getNonconforming(po);
	}

	/**
	 * 删除不合格商品信息
	 */
	public void deleteNonconforming(NonconformingPo po,LogisticsLogPo logPo ) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		nonconformingDao.deleteNonconforming(po);
		nonconformingDao.deleteNonconformingEntry(po);
	}

	public NonconformingDao getNonconformingDao() {
		return nonconformingDao;
	}

	public void setNonconformingDao(NonconformingDao nonconformingDao) {
		this.nonconformingDao = nonconformingDao;
	}

	/**
	 * 得到List类型的不合格商品详细信息
	 */
	public List<NonconformingEntryPo> getNonconformingEntryList(
			NonconformingPo po) {
		return this.nonconformingDao.getNonconformingEntryList(po);
	}

	
	public List<NonconformingPo> getNonconformingList(String shopcode,
			String cshanstartTime, String cshanendTime) {
		return nonconformingDao.getNonconformingList(shopcode, cshanstartTime,
				cshanendTime);
	}

	public void summaryAllocation(AllocationPo allocationPo, String... billids) {
		nonconformingDao.summaryAllocation(allocationPo);
		nonconformingDao.summaryAllocationEntry(allocationPo, billids);
		nonconformingDao.biilderAllcoactionBarcode(allocationPo, billids);
		nonconformingDao.updateNonconformingState(billids);
	}
	
	public SalesBasicPo getSalesBasicPo(NonconformingPo po){
		SalesBasicPo spo = new SalesBasicPo();
		spo.setSsesbsalesid(Utility.getName(po.getCshanbillid()));
		
		if (inTransitDetailsDao.getSalesBasicInfoByID(spo) == 0){			
			return nonconformingDao.getSalesBasicPoFinished(po);
		}	
		return nonconformingDao.getSalesBasicPo(po);
	}
	
	public WarehousePo getWarehousePo(String did){
		return nonconformingDao.getWarehousePo(did);
	}

}
