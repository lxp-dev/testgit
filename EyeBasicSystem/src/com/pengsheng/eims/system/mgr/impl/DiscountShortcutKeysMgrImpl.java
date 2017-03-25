package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.DiscountShortcutKeysDao;
import com.pengsheng.eims.system.mgr.DiscountShortcutKeysMgr;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;

public class DiscountShortcutKeysMgrImpl implements DiscountShortcutKeysMgr {
	DiscountShortcutKeysDao discountShortcutKeysDao;
	
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}


	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	public DiscountShortcutKeysDao getDiscountShortcutKeysDao() {
		return discountShortcutKeysDao;
	}


	public void setDiscountShortcutKeysDao(
			DiscountShortcutKeysDao discountShortcutKeysDao) {
		this.discountShortcutKeysDao = discountShortcutKeysDao;
	}


	public void deleteDiscountShortcutKeys(DiscountShortcutKeysPo po,LogisticsLogPo logPo) {
		discountShortcutKeysDao.deleteDiscountShortcutKeys(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public DiscountShortcutKeysPo getDiscountShortcutKeysPo(
			DiscountShortcutKeysPo po) {
		
		return discountShortcutKeysDao.getDiscountShortcutKeysPo(po);
	}

	/*
	 * 
	 * 添加时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoId(DiscountShortcutKeysPo po) 
	{
		return discountShortcutKeysDao.getShortcutKeysPoId(po);
	}
	/*
	 * 
	 * 添加时判断快捷键名称是否重复
	 * 
	 */
	public int getShortcutKeysPoName(DiscountShortcutKeysPo po) 
	{
		return discountShortcutKeysDao.getShortcutKeysPoName(po);
	}
	/*
	 * 
	 * 修改时判断打折码是否重复
	 * 
	 */
	public int getShortcutKeysPoIdUpdate(DiscountShortcutKeysPo po) 
	{
		return discountShortcutKeysDao.getShortcutKeysPoIdUpdate(po);
	}
	/*
	 * 
	 * 修改时判断快捷键名称是否重复
	 * 
	 */
	public int getShortcutKeysPoNameUpdate(DiscountShortcutKeysPo po) 
	{
		return discountShortcutKeysDao.getShortcutKeysPoNameUpdate(po);
	}
	public List<DiscountShortcutKeysPo> getDiscountShortcutKeysPoList() {
		return discountShortcutKeysDao.getDiscountShortcutKeysPoList();
	}

	
	public void insertDiscountShortcutKeys(DiscountShortcutKeysPo po,DiscountShortcutKeysDetailsPo dpo,LogisticsLogPo logPo) {
		discountShortcutKeysDao.insertDiscountShortcutKeys(po);
		
		if(dpo != null){
			for(int i=0; i<dpo.getFdkdgoodslevels().length; i++){
				DiscountShortcutKeysDetailsPo idpo = new DiscountShortcutKeysDetailsPo();
				idpo.setFdkddiscountkeysid(po.getFdkid());
				idpo.setFdkdgoodslevel(dpo.getFdkdgoodslevels()[i]);
				idpo.setFdkddiscount(dpo.getFdkddiscounts()[i]);
				discountShortcutKeysDao.insertDiscountShortcutKeysDetails(idpo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	
	public void updateDiscountShortcutKeys(DiscountShortcutKeysPo po,DiscountShortcutKeysDetailsPo dpo,LogisticsLogPo logPo) {
		discountShortcutKeysDao.updateDiscountShortcutKeys(po);
		
		if(dpo != null){
			discountShortcutKeysDao.deleteDiscountShortcutKeysDetails(po.getFdkid());
			
			for(int i=0; i<dpo.getFdkdgoodslevels().length; i++){
				DiscountShortcutKeysDetailsPo idpo = new DiscountShortcutKeysDetailsPo();
				idpo.setFdkddiscountkeysid(po.getFdkid());
				idpo.setFdkdgoodslevel(dpo.getFdkdgoodslevels()[i]);
				idpo.setFdkddiscount(dpo.getFdkddiscounts()[i]);
				discountShortcutKeysDao.insertDiscountShortcutKeysDetails(idpo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	
	public void updateDiscountShortcutKeysEnable(DiscountShortcutKeysPo po,LogisticsLogPo logPo) {
		discountShortcutKeysDao.updateDiscountShortcutKeysEnable(po);
		logisticsLogDao.insertLog(logPo);

	}
	
	public List<DiscountShortcutKeysPo> getEnableDiscountShortcutKeysPoList(String ishow){
		return discountShortcutKeysDao.getEnableDiscountShortcutKeysPoList(ishow);
	}
	
	public void updateDiscountShortcutKeysIsShow(DiscountShortcutKeysPo po,LogisticsLogPo logPo){
		discountShortcutKeysDao.updateDiscountShortcutKeysIsShow(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public List<DiscountShortcutKeysDetailsPo> selectDiscountShortcutKeysDetails(DiscountShortcutKeysDetailsPo po){
		return discountShortcutKeysDao.selectDiscountShortcutKeysDetails(po);
	}
}
