package com.pengsheng.eims.member.mgr.impl;

import java.util.List;

import com.pengsheng.eims.member.dao.CrowdCategoriesDao;
import com.pengsheng.eims.member.mgr.CrowdCategoriesMgr;
import com.pengsheng.eims.member.persistence.CrowdCategoriesPo;

public class CrowdCategoriesMgrImpl implements CrowdCategoriesMgr {

	private CrowdCategoriesDao crowdCategoriesDao;

	public CrowdCategoriesPo getCrowdCategories(CrowdCategoriesPo po) {
		return this.crowdCategoriesDao.getCrowdCategories(po);
	}

	public List<CrowdCategoriesPo> getCrowdCategoriesList(){
		return this.crowdCategoriesDao.getCrowdCategoriesList();
	}

	public void insertCrowdCategories(CrowdCategoriesPo po) {
		this.crowdCategoriesDao.insertCrowdCategories(po);
	}

	public void updateCrowdCategories(CrowdCategoriesPo po) {
		this.crowdCategoriesDao.updateCrowdCategories(po);
	}

	public CrowdCategoriesDao getCrowdCategoriesDao() {
		return crowdCategoriesDao;
	}

	public void setCrowdCategoriesDao(CrowdCategoriesDao crowdCategoriesDao) {
		this.crowdCategoriesDao = crowdCategoriesDao;
	}

	public void deleteCrowdCategories(CrowdCategoriesPo po) {
		this.crowdCategoriesDao.deleteCrowdCategories(po);
	}

}
