package com.pengsheng.eims.basic.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.dao.InitSystemDao;
import com.pengsheng.eims.basic.dao.QcInStorageDao;
import com.pengsheng.eims.basic.mgr.QcInStorageMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.tools.Utility;

public class QcInStorageMgrImpl implements QcInStorageMgr {
	
	private QcInStorageDao qcInStorageDao;
	private LogisticsLogDao logisticsLogDao;
	private InitSystemDao initSystemDao;
	private BatchCompareDao batchCompareDao;
	
	public BatchCompareDao getBatchCompareDao() {
		return batchCompareDao;
	}

	public void setBatchCompareDao(BatchCompareDao batchCompareDao) {
		this.batchCompareDao = batchCompareDao;
	}

	public InitSystemDao getInitSystemDao() {
		return initSystemDao;
	}

	public void setInitSystemDao(InitSystemDao initSystemDao) {
		this.initSystemDao = initSystemDao;
	}

	public int getQcInStorageCount(GoodsInfoPo gpo){
		return qcInStorageDao.getQcInStorageCount(gpo);
	}
	
	public List<GoodsInfoPo> getQcInStorageList(GoodsInfoPo gpo,int start,int size){
		return qcInStorageDao.getQcInStorageList(gpo,start,size);
	}
	
	public GoodsInfoPo getQcInStorageInfo(GoodsInfoPo gpo){
		return qcInStorageDao.getQcInStorageInfo(gpo);
	}
	
	public void insertQcInStorage(List<GoodsInfoPo> gList,LogisticsLogPo logPo){
		
		initSystemDao.insertStorageGoods_Log(gList);
		initSystemDao.insertStorageGoods_Change(gList);	
		
		initSystemDao.insertStorageGoods_Collect();

		logisticsLogDao.insertLog(logPo);
	}
	
	public void insertQcInStorageYx(List<GoodsInfoPo> gList,LogisticsLogPo logPo){

		for (int k = 0; k < gList.size(); k++){
			GoodsInfoPo gpo = gList.get(k);
			
			if(!"".equals(Utility.getName(gpo.getBatch()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(gpo.getBgigoodsbarcode());
				tbpo.setCshbcbatch(gpo.getBatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String[] left = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
				String isinsert = "";
				String simplebatch = "";
				if(bpo.getCshbcbarcode() != null){
					simplebatch = bpo.getCshbcsimplebatch();
				}else{
					BatchComparePo tpo= new BatchComparePo();
					tpo.setCshbcbarcode(gpo.getBgigoodsbarcode());
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
				gpo.setBgigoodsbarcode(gpo.getBgigoodsbarcode().substring(0, 24)+simplebatch);
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(gpo.getBgigoodsbarcode().substring(0, 24)+simplebatch);
					ipo.setCshbcguaranteeperiod(gpo.getGuaranteeperiod());
					ipo.setCshbcbatch(gpo.getBatch());
					ipo.setCshbcsimplebatch(simplebatch);
					ipo.setCshregistrationnum(Utility.getName(gpo.getBgiregistrationnum()));
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
		}
		
		insertQcInStorage(gList,logPo);
	}
	
	public void updateQcInStorage(GoodsInfoPo gpo,LogisticsLogPo logPo){
		qcInStorageDao.updateQcInStorage(gpo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public int getQcInStorageSum(GoodsInfoPo gpo){
		return qcInStorageDao.getQcInStorageSum(gpo);
	}

	public QcInStorageDao getQcInStorageDao() {
		return qcInStorageDao;
	}

	public void setQcInStorageDao(QcInStorageDao qcInStorageDao) {
		this.qcInStorageDao = qcInStorageDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
}
