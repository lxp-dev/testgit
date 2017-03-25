package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.ProcurementWaitDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.ProcurementWaitMgr;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class ProcurementWaitMgrImpl implements ProcurementWaitMgr {
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

	private ProcurementWaitDao procurementWaitDao;
	
	private StrogeChangeDao strogeChangeDao;
	
	private ProcurementReceiptDao procurementReceiptDao;

	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public void setProcurementReceiptDao(ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public ProcurementWaitDao getProcurementWaitDao() {
		return procurementWaitDao;
	}

	public void setProcurementWaitDao(ProcurementWaitDao procurementWaitDao) {
		this.procurementWaitDao = procurementWaitDao;
	}

	/**
	 * 得到待收获订单信息总个数
	 */
	public int getProcurementWaitCount(ProcurementOrdersPo procurementOrdersPo) {
		return procurementWaitDao.getProcurementWaitCount(procurementOrdersPo);
	}

	/**
	 * 得到待收货订单信息
	 */
	public List<ProcurementOrdersPo> getProcurementWaitList(
			ProcurementOrdersPo procurementOrdersPo, int start, int size) {
		return procurementWaitDao.getProcurementWaitList(procurementOrdersPo,
				start, size);
	}

	/**
	 * 得到转单页面中的详细信息
	 */
	public List<InventoryEntryPo> getProcurementInventoryEntryList(
			InventoryEntryPo inventoryEntryPo) {
		List<InventoryEntryPo> entryList=procurementWaitDao.getProcurementInventoryEntryList(inventoryEntryPo);
//		for(int i =0 ; i<entryList.size();i++){
//			InventoryEntryPo po=entryList.get(i);
//			String pcBarcode=procurementReceiptDao.getGoodsBarCode(po.getCstiebarcode());
//			po.setCstiepcbarcode(pcBarcode);
//		}
		return entryList;
	}

	/**
	 * 得到转单详细信息个数
	 */
	public int getProcurementInventoryEntryCount(
			InventoryEntryPo inventoryEntryPo) {
		return procurementWaitDao.getProcurementInventoryEntryCount(inventoryEntryPo);
	}
	
	/**
	 * 新增采购收货转单
	 * @param po InventoryPo
	 */	
	public void insertProcurementWaitAll(InventoryPo inventoryPo,List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		procurementWaitDao.insertProcurementInventoryPo(inventoryPo);//单据主表
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
			strogeChangeDao.deleteStockByChangeID(inventoryPo.getCstibillid());
		}
		
		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			
			//将得到的每条商品信息便利出来、并一条条插入数据库
			
			InventoryEntryPo inventoryEntryPo=it.next();
			
			if(!"".equals(Utility.getName(inventoryEntryPo.getCstiebatch()))&& "1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(inventoryEntryPo.getCstiebarcode());
				tbpo.setCshbcbatch(inventoryEntryPo.getCstiebatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String[] left = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
				String isinsert = "";
				String simplebatch = "";
				if(bpo.getCshbcbarcode() != null){
					simplebatch = bpo.getCshbcsimplebatch();
				}else{
					BatchComparePo tpo= new BatchComparePo();
					tpo.setCshbcbarcode(inventoryEntryPo.getCstiebarcode());
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
				inventoryEntryPo.setCstiepcbarcode(inventoryEntryPo.getCstiebarcode().substring(0, 24)+simplebatch);
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(inventoryEntryPo.getCstiebarcode().substring(0, 24)+simplebatch);
					ipo.setCshbcguaranteeperiod(inventoryEntryPo.getCstieguaranteeperiod());
					ipo.setCshbcbatch(inventoryEntryPo.getCstiebatch());
					ipo.setCshbcsimplebatch(simplebatch);
					ipo.setCshregistrationnum(Utility.getName(inventoryEntryPo.getCstieregistrationnum()));
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
//			StrogeChangePo changePoTemp = new StrogeChangePo();
//			changePoTemp.setCshscgoodsid(inventoryEntryPo.getCstiegoodsid());
//			changePoTemp.setCshscrksj(inventoryEntryPo.getCstierksj());
//			
//			GoodsInfoPo goodsInfoPo=strogeChangeDao.getGoodsInfoPoBarCode(inventoryEntryPo.getCstiegoodsid());
//			changePoTemp.setCshscbarcodeflag(goodsInfoPo.getBgirksj());
//			changePoTemp.setCshscgoodsbarcode(goodsInfoPo.getBgigoodsbarcode());
//			
//			changePoTemp=strogeChangeDao.getStrogeChangePoBarCode(changePoTemp);
//			if("4".equals(changePoTemp.getCshscgoodsbarcode().substring(1))||"5".equals(changePoTemp.getCshscgoodsbarcode().substring(1))){
//				inventoryEntryPo.setCstiepcbarcode(changePoTemp.getCshscgoodsbarcode());
//			}
			
			procurementWaitDao.insertProcurementInventoryEntryPo(inventoryEntryPo);//单据明细表
			
			
			VerificationPo verificationPo=new VerificationPo();
			verificationPo.setCstvpinid(inventoryPo.getCstibillid());
			verificationPo.setCstvpoid(inventoryPo.getCstisourcebillid());
			verificationPo.setCstvgoodsid(inventoryEntryPo.getCstiegoodsid());
			verificationPo.setCstvbarcode(inventoryEntryPo.getCstiebarcode());
			verificationPo.setCstvnum(inventoryEntryPo.getCstiegoodsquantity());
			
			//将已经审核的订单销掉
			
//			if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))&&!"".equals(Utility.getName(inventoryPo.getCstisourcebillid()))) {
//				procurementWaitDao.insertVerification(verificationPo);//核销表
//			}
			
			//将已经审核的数据填入核销表中
			if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(inventoryEntryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(inventoryEntryPo.getCstiebarcode());
				changePo.setCshscstockid(inventoryEntryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(inventoryEntryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(inventoryEntryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(inventoryEntryPo.getCstienottaxrate());
				changePo.setCshscchangeid(inventoryPo.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
				
//				changePoTemp=strogeChangeDao.getStrogeChangePoBarCode(changePoTemp);
				
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(inventoryEntryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(inventoryEntryPo.getCstiebarcode());
				changePo.setCshscstockid(inventoryEntryPo.getCstieinstockid());
				changePo.setCshscgoodsquantity(inventoryEntryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(inventoryEntryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(inventoryEntryPo.getCstienottaxrate());
				changePo.setCshscchangeid(inventoryPo.getCstibillid());
				changePo.setCshscguaranteeperiod(inventoryEntryPo.getCstieguaranteeperiod());
				changePo.setCshscBatch(inventoryEntryPo.getCstiebatch());
				changePo.setCshscrksj(inventoryEntryPo.getCstierksj());
				
				strogeChangeDao.insertStrogeChangeLog(changePo, inventoryEntryPo.getCstiebarcode());// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, inventoryEntryPo.getCstiebarcode());// 商品库存当月库存变更表(9张新表)
				
				procurementReceiptDao.updateGoodsLastInStorageDate(inventoryEntryPo.getCstiegoodsid());  // 更新商品最后一次的入库时间
			}		
			
			if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate())) && !"".equals(Utility.getName(inventoryPo.getCstisourcebillid()))) {
				procurementReceiptDao.insertVerification(verificationPo);// 核销表
			}	
		}
		
		if ("1".equals(inventoryPo.getCstiauditstate())) {
			procurementReceiptDao.updateOrder(inventoryPo);
		}

		if ("1".equals(inventoryPo.getCstiauditstate())) {
			if(!"".equals(inventoryPo.getCstisourcebillid()))
			{
				procurementReceiptDao.updateOrder(inventoryPo);
				procurementReceiptDao.updateOrderStatus(inventoryPo);
			}else{
				procurementReceiptDao.insertOrderStatus(inventoryPo);
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
}
