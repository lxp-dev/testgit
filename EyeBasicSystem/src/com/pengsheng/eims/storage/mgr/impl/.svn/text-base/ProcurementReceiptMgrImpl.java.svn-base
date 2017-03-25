package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.BatchCompareMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 采购收货mgr实现类
 */
public class ProcurementReceiptMgrImpl implements ProcurementReceiptMgr {
	private BatchCompareDao batchCompareDao;
	private LogisticsLogDao logisticsLogDao;
	
	public BatchCompareDao getBatchCompareDao() {
		return batchCompareDao;
	}
	public void setBatchCompareDao(BatchCompareDao batchCompareDao) {
		this.batchCompareDao = batchCompareDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private ProcurementReceiptDao procurementReceiptDao;

	private StrogeChangeDao strogeChangeDao;

	private SupplierDao supplierDao;

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public void setProcurementReceiptDao(
			ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}

	/**
	 * 获取采购收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getProcurementReceiptCount(InventoryPo po) {
		return procurementReceiptDao.getProcurementReceiptCount(po);
	}

	/**
	 * 获取采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementReceiptList(InventoryPo po,
			int start, int size) {
		return procurementReceiptDao.getProcurementReceiptList(po, start, size);
	}

	/**
	 * 新增采购收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		procurementReceiptDao.insertProcurementReceipt(po);// 单据主表
		if ("1".equals(Utility.getName(po.getCstiauditstate()))){
			strogeChangeDao.deleteStockByChangeID(po.getCstibillid());
		}
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			
			if(!"".equals(Utility.getName(entryPo.getCstiebatch()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(entryPo.getCstiebarcode());
				tbpo.setCshbcbatch(entryPo.getCstiebatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String[] left = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
				String isinsert = "";
				String simplebatch = "";
				if(bpo.getCshbcbarcode() != null){
					simplebatch = bpo.getCshbcsimplebatch();
				}else{
					BatchComparePo tpo= new BatchComparePo();
					tpo.setCshbcbarcode(entryPo.getCstiebarcode());
					BatchComparePo maxpo = batchCompareDao.selectBatchComparePo(tpo);
					isinsert = "1";
					if(maxpo.getCshbcbarcode() != null){
						for(int i=0; i<left.length;i++){
							if(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2)) == 9){
								if(left[i].equals(maxpo.getCshbcsimplebatch().substring(0, 1))){
									simplebatch = left[i+1]+"0";
									break;
								}
							}else{
								simplebatch = maxpo.getCshbcsimplebatch().substring(0, 1)+(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2))+1);
								break;
							}
						}
					}else{
						simplebatch = "A0";
					}
				}
				entryPo.setCstiepcbarcode(entryPo.getCstiebarcode().substring(0, 24)+simplebatch);
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(entryPo.getCstiebarcode().substring(0, 24)+simplebatch);
					ipo.setCshbcguaranteeperiod(entryPo.getCstieguaranteeperiod());
					ipo.setCshbcbatch(entryPo.getCstiebatch());
					ipo.setCshbcsimplebatch(simplebatch);
					ipo.setCshregistrationnum(Utility.getName(entryPo.getCstieregistrationnum()));
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
			
//			StrogeChangePo changePoTemp = new StrogeChangePo();
//			changePoTemp.setCshscgoodsid(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscrksj(entryPo.getCstierksj());
//			
//			GoodsInfoPo goodsInfoPo=strogeChangeDao.getGoodsInfoPoBarCode(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscbarcodeflag(goodsInfoPo.getBgirksj());
//			changePoTemp.setCshscgoodsbarcode(goodsInfoPo.getBgigoodsbarcode());
//			
//			changePoTemp=strogeChangeDao.getStrogeChangePoBarCode(changePoTemp);
//			if("4".equals(changePoTemp.getCshscgoodsbarcode().substring(1))||"5".equals(changePoTemp.getCshscgoodsbarcode().substring(1))){
//				entryPo.setCstiepcbarcode(changePoTemp.getCshscgoodsbarcode());
//			}
			
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
			procurementReceiptDao.insertProcurementReceiptEntry(entryPo);// 单据明细表
			
			
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());
			
			if ("1".equals(Utility.getName(po.getCstiauditstate())) && !"".equals(Utility.getName(po.getCstisourcebillid()))) {
				procurementReceiptDao.updateOrder(po);//更新采购订单主表收货状态 
			}
			
			if ("1".equals(Utility.getName(po.getCstiauditstate())) && !"".equals(Utility.getName(po.getCstisourcebillid()))) {
				procurementReceiptDao.insertVerification(verificationPo);// 核销表
			}
			
			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());

				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscguaranteeperiod(entryPo.getCstieguaranteeperiod());
				changePo.setCshscBatch(entryPo.getCstiebatch());
				changePo.setCshscrksj(entryPo.getCstierksj());
				
				strogeChangeDao.insertStrogeChangeLog(changePo, entryPo.getCstiepcbarcode());// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, entryPo.getCstiepcbarcode());// 商品库存当月库存变更表(9张新表)

				procurementReceiptDao.updateGoodsLastInStorageDate(entryPo.getCstiegoodsid());
			}
		}

		if ("1".equals(po.getCstiauditstate())) {
			if(!"".equals(po.getCstisourcebillid()))
			{
				procurementReceiptDao.updateOrder(po);
				procurementReceiptDao.updateOrderStatus(po);
			}else
			{
				procurementReceiptDao.insertOrderStatus(po);
			}
		}

		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 获取采购收货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getProcurementReceipt(InventoryPo po) {

		return procurementReceiptDao.getProcurementReceipt(po);
	}
	/*
	 * 
	 */
	public void updateOrderDeliveryID(InventoryPo po) {
		procurementReceiptDao.updateOrderDeliveryID(po);
	}
	/**
	 * 获取采购收货明细表的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getProcurementReceiptEntryList(InventoryPo po) {

		return procurementReceiptDao.getProcurementReceiptEntryList(po);
	}
	public int getProcurementReceiptIsCustomizeCount(InventoryPo po){
		return procurementReceiptDao.getProcurementReceiptIsCustomizeCount(po);
	}
	/**
	 * 修改采购收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateProcurementReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		procurementReceiptDao.updateProcurementReceipt(po);// 单据主表
		procurementReceiptDao.deleteProcurementReceiptEntry(po);// 删除单据明细表
		procurementReceiptDao.deleteVerification(po);// 删除核销表
		if ("1".equals(Utility.getName(po.getCstiauditstate()))){
			strogeChangeDao.deleteStockByChangeID(po.getCstibillid());
		}
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			
			if(!"".equals(Utility.getName(entryPo.getCstiebatch()))&& "1".equals(Utility.getName(po.getCstiauditstate()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(entryPo.getCstiebarcode());
				tbpo.setCshbcbatch(entryPo.getCstiebatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String[] left = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
				String isinsert = "";
				String simplebatch = "";
				if(bpo.getCshbcbarcode() != null){
					simplebatch = bpo.getCshbcsimplebatch();
				}else{
					BatchComparePo tpo= new BatchComparePo();
					tpo.setCshbcbarcode(entryPo.getCstiebarcode());
					BatchComparePo maxpo = batchCompareDao.selectBatchComparePo(tpo);
					isinsert = "1";
					if(maxpo.getCshbcbarcode() != null){
						for(int i=0; i<left.length;i++){
							if(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2)) == 9){
								if(left[i].equals(maxpo.getCshbcsimplebatch().substring(0, 1))){
									simplebatch = left[i+1]+"0";
									break;
								}
							}else{
								simplebatch = maxpo.getCshbcsimplebatch().substring(0, 1)+(Integer.parseInt(maxpo.getCshbcsimplebatch().substring(1, 2))+1);
								break;
							}
						}
					}else{
						simplebatch = "A0";
					}
				}
				entryPo.setCstiepcbarcode(entryPo.getCstiebarcode().substring(0, 24)+simplebatch);
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(entryPo.getCstiebarcode().substring(0, 24)+simplebatch);
					ipo.setCshbcguaranteeperiod(entryPo.getCstieguaranteeperiod());
					ipo.setCshbcbatch(entryPo.getCstiebatch());
					ipo.setCshbcsimplebatch(simplebatch);
					ipo.setCshregistrationnum(Utility.getName(entryPo.getCstieregistrationnum()));
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
//			StrogeChangePo changePoTemp = new StrogeChangePo();
//			changePoTemp.setCshscgoodsid(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscrksj(entryPo.getCstierksj());
//			
//			GoodsInfoPo goodsInfoPo=strogeChangeDao.getGoodsInfoPoBarCode(entryPo.getCstiegoodsid());
//			changePoTemp.setCshscbarcodeflag(goodsInfoPo.getBgirksj());
//			changePoTemp.setCshscgoodsbarcode(goodsInfoPo.getBgigoodsbarcode());
//			
//			changePoTemp=strogeChangeDao.getStrogeChangePoBarCode(changePoTemp);
//			if("4".equals(changePoTemp.getCshscgoodsbarcode().substring(1))||"5".equals(changePoTemp.getCshscgoodsbarcode().substring(1))){
//				entryPo.setCstiepcbarcode(changePoTemp.getCshscgoodsbarcode());
//			}
				
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
			procurementReceiptDao.insertProcurementReceiptEntry(entryPo);// 单据明细表
			
			VerificationPo verificationPo = new VerificationPo();
			verificationPo.setCstvpinid(po.getCstibillid());
			verificationPo.setCstvpoid(po.getCstisourcebillid());
			verificationPo.setCstvgoodsid(entryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(entryPo.getCstiebarcode());
			verificationPo.setCstvnum(entryPo.getCstiegoodsquantity());

			if ("1".equals(Utility.getName(po.getCstiauditstate()))
					&& !"".equals(Utility.getName(po.getCstisourcebillid()))) {
				procurementReceiptDao.insertVerification(verificationPo);// 核销表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
				
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				
				
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscguaranteeperiod(entryPo.getCstieguaranteeperiod());
				changePo.setCshscBatch(entryPo.getCstiebatch());
				changePo.setCshscrksj(entryPo.getCstierksj());
				
				strogeChangeDao.insertStrogeChangeLog(changePo, entryPo.getCstiepcbarcode());// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, entryPo.getCstiepcbarcode());// 商品库存当月库存变更表(9张新表)
				
				procurementReceiptDao.updateGoodsLastInStorageDate(entryPo.getCstiegoodsid());
			}
		}

		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(po.getCstisupplierid());
		supplierPo = supplierDao.getSupplier(supplierPo);


		if ("1".equals(po.getCstiauditstate())) {
			if(!"".equals(po.getCstisourcebillid()))
			{
//				procurementReceiptDao.updatestatusReceipt(po);
				procurementReceiptDao.updateOrder(po);
				procurementReceiptDao.updateOrderStatus(po);
			}
			else
			{
				procurementReceiptDao.insertOrderStatus(po);
			}
		}
		

		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除采购收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteProcurementReceipt(InventoryPo po,LogisticsLogPo logPo) {

		procurementReceiptDao.deleteProcurementReceipt(po);// 单据主表
		procurementReceiptDao.deleteProcurementReceiptEntry(po);// 删除单据明细表
		procurementReceiptDao.deleteVerification(po);// 删除核销表
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	
	public List<DeliveryDetailPo> getDeliverEntryList(String deliverID) {
		return procurementReceiptDao.getDeliverEntryList(deliverID);
	}

	
	public List<GoodsInfoPo> getProcurementOrdersList(ProcurementOrdersPo po) {

		List<GoodsInfoPo> goodsTemp = procurementReceiptDao
				.getProcurementOrdersList(po);

		for (GoodsInfoPo goodsInfoPo : goodsTemp) {
			String pcBarcode = procurementReceiptDao
					.getGoodsBarCode(goodsInfoPo.getBgigoodsbarcode());
			goodsInfoPo.setBgipcbarcode(pcBarcode);
		}

		return goodsTemp;
	}

	
	public int selectProcurementReceipt(InventoryPo po) {
		return procurementReceiptDao.selectProcurementReceiptcount(po);
	}
	
	/**
	 * 获取采购订单是否收货
	 * @param sourceBillId
	 * @return
	 */
	public int selectProcurementIsReceipt(String billid){
		return procurementReceiptDao.selectProcurementIsReceipt(billid);
	}
	/**
	 * Description :获取品种 
	 */
	public List<GoodsInfoPo> getProBrand(String proId){
		return procurementReceiptDao.getProBrand(proId);
	}
	
	/**
	 * 根据公司和制造商查询绑定的供应商
	 */
	public String getSupplierByModeAndCompany(String companyID,String modeID){
		return procurementReceiptDao.getSupplierByModeAndCompany(companyID,modeID);
	}
	
}
