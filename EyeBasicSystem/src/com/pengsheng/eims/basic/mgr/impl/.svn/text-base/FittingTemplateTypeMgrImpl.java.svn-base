package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.FittingTemplateDao;
import com.pengsheng.eims.basic.dao.FittingTemplateTypeDao;
import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;

public class FittingTemplateTypeMgrImpl implements FittingTemplateTypeMgr {

	private FittingTemplateTypeDao fittingTemplateTypeDao = null;
	private FittingTemplateDao fittingTemplateDao = null;
	
	public List<FittingTemplateTypePo> getFittingTemplateTypeList(FittingTemplateTypePo po) {
		return fittingTemplateTypeDao.getFittingTemplateTypeList(po);
	}

	public FittingTemplateTypePo getFittingTemplateTypePo(String typeID){
		return fittingTemplateTypeDao.getFittingTemplateTypePo(typeID);
	}

	public void updateFittingTemplateTypePo(FittingTemplateTypePo po) {
		fittingTemplateTypeDao.updateFittingTemplateTypePo(po);
		fittingTemplateDao.updateCurrentUsingTemplateByType(po.getBfttid());
		fittingTemplateDao.updateCurrentUsingTemplateByid(po.getBftid());
	}		
	
	public void updateFittingTemplateTypeShowtype(String typeID,String showType){
		fittingTemplateTypeDao.updateFittingTemplateTypeShowtype(typeID, showType);
	}
	
	public FittingTemplateTypeDao getFittingTemplateTypeDao() {
		return fittingTemplateTypeDao;
	}
	public void setFittingTemplateTypeDao(
			FittingTemplateTypeDao fittingTemplateTypeDao) {
		this.fittingTemplateTypeDao = fittingTemplateTypeDao;
	}

	public FittingTemplateDao getFittingTemplateDao() {
		return fittingTemplateDao;
	}

	public void setFittingTemplateDao(FittingTemplateDao fittingTemplateDao) {
		this.fittingTemplateDao = fittingTemplateDao;
	}
}
