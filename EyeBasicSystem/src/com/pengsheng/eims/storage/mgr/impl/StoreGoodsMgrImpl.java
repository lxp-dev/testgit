package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.dao.OtherDatabaseManagementDao;
import com.pengsheng.eims.storage.dao.StoreGoodsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.StoreGoodsMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class StoreGoodsMgrImpl implements StoreGoodsMgr
{
	private LogisticsLogDao logisticsLogDao;
	private StoreGoodsDao storeGoodsDao;
	private StrogeChangeDao strogeChangeDao;
	private SystemParameterMgr systemParameterMgr;
	private BatchCompareDao batchCompareDao;
	private InTransitDetailsDao inTransitDetailsDao = null;
	private GuitarManagementDao guitarManagementDao;
	
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

	public BatchCompareDao getBatchCompareDao() {
		return batchCompareDao;
	}

	public void setBatchCompareDao(BatchCompareDao batchCompareDao) {
		this.batchCompareDao = batchCompareDao;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public StoreGoodsDao getStoreGoodsDao() {
		return storeGoodsDao;
	}

	public void setStoreGoodsDao(StoreGoodsDao storeGoodsDao) {
		this.storeGoodsDao = storeGoodsDao;
	}

	
	
	
	public int getStoreGoodsCount(TracPo po) {
		return storeGoodsDao.getStoreGoodsCount(po);
	}

	public List<TracPo> getStoreGoodsList(TracPo po,int start, int size) {
		return storeGoodsDao.getStoreGoodsList(po, start, size);
	}

	public void insertStoreGoods(TracPo po,List<TracEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		storeGoodsDao.insertStoreGoods(po);// 单据主表
		Iterator<TracEntryPo> it = list.iterator();
		while (it.hasNext()) {
			TracEntryPo entryPo = it.next();
			
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
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
			
			entryPo.setCstieoutstockid(po.getCstioutstockid());//发出仓位
			storeGoodsDao.insertStoreGoodsEntry(entryPo);// 单据明细表
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				
				if("SG".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}else if("SR".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				}
				
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				
				BigDecimal bg = new BigDecimal(Utility.getName(entryPo.getCstietaxrate()));
				bg = bg.multiply(new BigDecimal(0.01)).add(new BigDecimal(1));
				
				BigDecimal bg2 = new BigDecimal(Utility.getName(entryPo.getCstienottaxrate()));
				bg2 = bg2.multiply(bg).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				changePo.setCshsccostprice(bg2.toString());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscguaranteeperiod(entryPo.getCstieguaranteeperiod());
				changePo.setCshscBatch(entryPo.getCstiebatch());
				
				if("SG".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				}else if("SR".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				}
				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));
			}	
			
			if(!Utility.getName(entryPo.getCstieguaranteeperiod()).equals("")&&!"1".equals(Utility.getName(po.getCstiauditstate()))&&"SR".equals(po.getCstibillid().substring(0, 2))){
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				
				BigDecimal bg = new BigDecimal(Utility.getName(entryPo.getCstietaxrate()));
				bg = bg.multiply(new BigDecimal(0.01)).add(new BigDecimal(1));
				
				BigDecimal bg2 = new BigDecimal(Utility.getName(entryPo.getCstienottaxrate()));
				bg2 = bg2.multiply(bg).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				changePo.setCshsccostprice(bg2.toString());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscguaranteeperiod(entryPo.getCstieguaranteeperiod());
				changePo.setCshscBatch(entryPo.getCstiebatch());
				changePo.setCshscgoodsquantity("0");
				
				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));
			}
			
		}
		
		//往来明细
		if("1".equals(Utility.getName(po.getCstiauditstate()))){
			storeGoodsDao.deleteFranchiseeCurrentAccountDetail(po);
			if ("3".equals(Utility.getName(po.getCstibilltypeid()))){
				storeGoodsDao.insertFranchiseeCurrentAccountDetail(po);
			}
			if ("2".equals(Utility.getName(po.getCstibilltypeid()))){
				storeGoodsDao.insertFranchiseeReturnCurrentAccountDetail(po);
			}
		}
		
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("4"); // 4	客户批发调货
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			
			InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();		
			outipo.setCshtsebillid(Utility.getName(po.getCstibillid()));			
			guitarManagementDao.deleteInTransitStroge(outipo);
			
			if(!"1".equals(Utility.getName(po.getCstiauditstate()))){
				storeGoodsDao.insertFranchiseeOutInTransitStorage(po);
			}			
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateStoreGoods(TracPo po,List<TracEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		storeGoodsDao.updateStoreGoods(po);//单据主表
		storeGoodsDao.deleteStoreGoodsEntry(po);//删除单据明细表
		storeGoodsDao.deleteGoodsBarCode(po);//删除条码表
		
		InTransitStorageEntryPo outipo2 = new InTransitStorageEntryPo();		
		outipo2.setCshtsebillid(Utility.getName(po.getCstibillid()));			
		guitarManagementDao.deleteInTransitStroge(outipo2);
		
		Iterator<TracEntryPo> it=list.iterator();
		while (it.hasNext()) {
			TracEntryPo entryPo = it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());//发出仓位
			storeGoodsDao.insertStoreGoodsEntry(entryPo);// 单据明细表
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				
				if("SG".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}else if("SR".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				}
				
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());				
				
				BigDecimal bg = new BigDecimal(Utility.getName(entryPo.getCstietaxrate()));
				bg = bg.multiply(new BigDecimal(0.01)).add(new BigDecimal(1));
				
				BigDecimal bg2 = new BigDecimal(Utility.getName(entryPo.getCstienottaxrate()));
				bg2 = bg2.multiply(bg).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				changePo.setCshsccostprice(bg2.toString());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());			
				
				changePo.setCshscchangeid(po.getCstibillid());
				
				if("SG".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				}else if("SR".equals(po.getCstibillid().substring(0, 2))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity());
				}
				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));
			}		
		}
		
		//往来明细
		if("1".equals(Utility.getName(po.getCstiauditstate()))){
			storeGoodsDao.deleteFranchiseeCurrentAccountDetail(po);
			if ("3".equals(Utility.getName(po.getCstibilltypeid()))){
				storeGoodsDao.insertFranchiseeCurrentAccountDetail(po);
			}
			if ("2".equals(Utility.getName(po.getCstibilltypeid()))){
				storeGoodsDao.insertFranchiseeReturnCurrentAccountDetail(po);
			}
		}
		
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("4"); // 4	客户批发调货
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			
			InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();		
			outipo.setCshtsebillid(Utility.getName(po.getCstibillid()));			
			guitarManagementDao.deleteInTransitStroge(outipo);
			
			if(!"1".equals(Utility.getName(po.getCstiauditstate()))){
				storeGoodsDao.insertFranchiseeOutInTransitStorage(po);
			}			
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public TracPo getStoreGoods(TracPo po) {
		return storeGoodsDao.getStoreGoods(po);
	}

	public void deleteStoreGoods(TracPo po,LogisticsLogPo logPo) {

		storeGoodsDao.deleteStoreGoods(po);
		storeGoodsDao.deleteStoreGoodsEntry(po);
		storeGoodsDao.deleteGoodsBarCode(po);
		
		InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();		
		outipo.setCshtsebillid(Utility.getName(po.getCstibillid()));			
		guitarManagementDao.deleteInTransitStroge(outipo);
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}
	public List<TracEntryPo> getReallocationList(TracPo po)
	{
		return storeGoodsDao.getReallocationList(po);
	}


	public List<TracEntryPo> getStoreGoodsEntryList(TracPo po) {
		return this.storeGoodsDao.getStoreGoodsEntryList(po);
	}
	
	public List<TracEntryPo> getStoreGoodsDetailList(TracPo po) {
		return this.storeGoodsDao.getStoreGoodsDetailList(po);
	}
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getTracBarcode(TracPo po)
	{
		return storeGoodsDao.getTracBarcode(po);
	}
	
	/**
	 * 取客户列表
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public List<DepartmentsPo>  getFranchisees()
	{
		return storeGoodsDao.getFranchisees();
	}
	
	public List<DepartmentsPo>  getFranchisees(DepartmentsPo dpo){
		return storeGoodsDao.getFranchisees(dpo);
	}
	
	/**
	 * 取指定客户
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getFranchisee(String id)
	{
		return storeGoodsDao.getFranchisee(id);
	}
	
	/**
	 * 获取批发申请商品信息
	 * @param po
	 * @return
	 */
	public List<TracEntryPo> getWholeApplyGoodsEntryList(TracPo po){
		return storeGoodsDao.getWholeApplyGoodsEntryList(po);
	}
}
