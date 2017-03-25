package com.pengsheng.eims.member.mgr;

import java.util.List;

import com.pengsheng.eims.member.persistence.CrowdCategoriesPo;

public interface CrowdCategoriesMgr {
	
	public void insertCrowdCategories(CrowdCategoriesPo po);
	
	public void updateCrowdCategories(CrowdCategoriesPo po);	
	
	public void deleteCrowdCategories(CrowdCategoriesPo po);
	
	public CrowdCategoriesPo getCrowdCategories(CrowdCategoriesPo po);
	
	public List<CrowdCategoriesPo> getCrowdCategoriesList();
}
