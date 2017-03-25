package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.DiffPriceDao;
import com.pengsheng.eims.sales.mgr.DiffPriceMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesPostBasicPo;
import com.pengsheng.eims.sales.persistence.SalesPostDetailPo;

public class DiffPriceMgrImpl implements DiffPriceMgr{
	
	private DiffPriceDao diffPriceDao;
	
	public DiffPriceDao getDiffPriceDao() {
		return diffPriceDao;
	}
	public void setDiffPriceDao(DiffPriceDao diffPriceDao) {
		this.diffPriceDao = diffPriceDao;
	}

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return this.diffPriceDao.getCustomerInfo(po,salesBasicPo);
	}

	public List<SalesBasicPo> getDiffPrices(SalesBasicPo salesBasicPo,String departmentID) {
		// TODO Auto-generated method stub
		return this.diffPriceDao.getDiffPrices(salesBasicPo,departmentID);
	}

	public SalesBasicPo getSalesBasicPo(String salesID) {
		// TODO Auto-generated method stub
		return this.diffPriceDao.getSalesBasicPo(salesID);
	}
	
	public List<SalesDetailPo> getSalesDetail(String ssesdsalesid) {
		// TODO Auto-generated method stub
		return this.diffPriceDao.getSalesDetail(ssesdsalesid);
	}

	/*
	 * 插入退差价基表
	 */
	public void insertBasic(SalesPostBasicPo salesPostBasicPo,SalesPostDetailPo salesPostDetailPo) {
		// TODO Auto-generated method stub
		/*
		 * 更新基表
		 */
		this.diffPriceDao.insertBasic(salesPostBasicPo);
		this.diffPriceDao.updateBasic(salesPostBasicPo);
		/*
		 * 更新明细表
		 */
		
		String[] newdiscount=salesPostDetailPo.getSsespddiscountrate().split(",");
		String[] newdiscountnum=salesPostDetailPo.getSsespddiscountnum().split(",");
		String[] posts=salesPostDetailPo.getSsespdpostvalue().split(",");
		for(int i=0;i<newdiscount.length;i++){
			SalesPostDetailPo temp = new SalesPostDetailPo();
			temp.setSsespdnewdiscountrate(newdiscount[i].trim());
			temp.setSsespdnewdiscountnum(newdiscountnum[i].trim());
			temp.setSsespdpostvalue(posts[i].trim().equals("")?"0.00":posts[i].trim());
			temp.setSsespdsalesid(salesPostDetailPo.getSsespdsalesid());
			temp.setSsespdrownumber((i+1)+"");
			this.diffPriceDao.insertDetail(temp);
		}
		
		String[] id=salesPostDetailPo.getSsespdid().split(",");
//		String[] newdiscount=salesPostDetailPo.getSsespddiscountrate().split(",");
//		String[] newdiscountnum=salesPostDetailPo.getSsespddiscountnum().split(",");
		String[] salesvalue=salesPostDetailPo.getSsespdsalesvalue().split(",");
		for(int i=0;i<newdiscount.length;i++){
			SalesPostDetailPo temp = new SalesPostDetailPo();
			temp.setSsespdsalesvalue(salesvalue[i].trim());
			temp.setSsespdnewdiscountrate(newdiscount[i].trim());
			temp.setSsespdnewdiscountnum(newdiscountnum[i].trim());
			temp.setSsespdid(id[i].trim());
			this.diffPriceDao.updateDetail(temp);
		}
	}
	
	/*
	 * 插入退差价明细
	 */
	public void insertDetail(SalesPostDetailPo salesPostDetailPo) {
		// TODO Auto-generated method stub
		String[] newdiscount=salesPostDetailPo.getSsespddiscountrate().split(",");
		String[] newdiscountnum=salesPostDetailPo.getSsespddiscountnum().split(",");
		String[] posts=salesPostDetailPo.getSsespdpostvalue().split(",");
		for(int i=0;i<newdiscount.length;i++){
			SalesPostDetailPo temp = new SalesPostDetailPo();
			temp.setSsespdnewdiscountrate(newdiscount[i].trim());
			temp.setSsespdnewdiscountnum(newdiscountnum[i].trim());
			temp.setSsespdpostvalue(posts[i].trim().equals("")?"0.00":posts[i].trim());
			temp.setSsespdsalesid(salesPostDetailPo.getSsespdsalesid());
			temp.setSsespdrownumber((i+1)+"");
			this.diffPriceDao.insertDetail(temp);
		}
 		
	}
	
	/*
	 * 更新销售明细表
	 */
	public void UpdateDetail(SalesPostDetailPo salesPostDetailPo) {
		// TODO Auto-generated method stub
		String[] id=salesPostDetailPo.getSsespdid().split(",");
		String[] newdiscount=salesPostDetailPo.getSsespddiscountrate().split(",");
		String[] newdiscountnum=salesPostDetailPo.getSsespddiscountnum().split(",");
		String[] salesvalue=salesPostDetailPo.getSsespdsalesvalue().split(",");
		for(int i=0;i<newdiscount.length;i++){
			SalesPostDetailPo temp = new SalesPostDetailPo();
			temp.setSsespdsalesvalue(salesvalue[i].trim());
			temp.setSsespdnewdiscountrate(newdiscount[i].trim());
			temp.setSsespdnewdiscountnum(newdiscountnum[i].trim());
			temp.setSsespdid(id[i].trim());
			this.diffPriceDao.updateDetail(temp);
		}
 		
		
	}
	
	/*
	 * 更新销售基表
	 */
	public void updateBasic(SalesPostBasicPo salesPostBasicPo) {
		// TODO Auto-generated method stub
		this.diffPriceDao.updateBasic(salesPostBasicPo);
	}
	

	public void updateCustomerIntegral(String customerID,float ssespbpostvalue){
		this.diffPriceDao.updateCustomerIntegral(customerID,ssespbpostvalue);
	}
	
	public void insertPost(SalesBasicPo salesBasicPo,List<SalesDetailPo> salesDetailPos,InTransitPo inTransitPo,SalesPostBasicPo salesPostBasicPo,String newsalesid) {
		// TODO Auto-generated method stub
		
		//更新销售基表S_SE_SalesBasic退款日期、退款标示、退款人、在途状态
		diffPriceDao.updateSalesBasic(salesBasicPo);
		
		//插入原单据在途14
		diffPriceDao.insertYIntransitInfo(inTransitPo);
		
		for (SalesDetailPo salesDetailPo : salesDetailPos) {
			//退差价商品变更金额，变更单号插入销售明细表
			diffPriceDao.insertSalesDetails(salesDetailPo, newsalesid);
		}
		//退差价商品入库C_SH_StorageLog
		diffPriceDao.insertStrogeLog(salesDetailPos.get(0));
		
		//退差价商品入库C_SH_StorageChange
		diffPriceDao.insertStrogeChange(salesDetailPos.get(0));
		
		//退差价商品用新销售单出库C_SH_StorageChange
		diffPriceDao.insertOutStrogeChange(salesDetailPos.get(0), newsalesid);
		
		//退差价商品用新销售单出库C_SH_StorageLog
		diffPriceDao.insertOutStrogeLog(salesDetailPos.get(0), newsalesid);
		
		//插入退差价关系表S_SE_SalesPostBasic
		diffPriceDao.insertBasic(salesPostBasicPo);
		
		//退差价商品变更金额，变更单号插入销售基表
		diffPriceDao.insertSalesBasic(salesBasicPo, newsalesid);
		
		//插入在途点1,2,13
		
		
		List<InTransitPo> inTransitPos = diffPriceDao.getIntransitInfo(inTransitPo);
		
		for (InTransitPo inTransitPo2 : inTransitPos) {
			diffPriceDao.insertIntransitInfo(inTransitPo2,newsalesid);
		}
	}
	
	//取得门店仓位
	public WarehousePo getWarehouse(String deptID){
		return diffPriceDao.getWarehouse(deptID);
	}
	
	//获取原销售明细
	public List<SalesDetailPo> getSalesDetails(String ssesdsalesid){
		return diffPriceDao.getSalesDetails(ssesdsalesid);
	}
	
}
