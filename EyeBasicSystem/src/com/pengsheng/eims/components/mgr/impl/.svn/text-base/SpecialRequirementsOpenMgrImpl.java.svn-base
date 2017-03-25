package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.SpecialRequirementsOpenDao;
import com.pengsheng.eims.components.mgr.SpecialRequirementsOpenMgr;
import com.pengsheng.eims.system.persistence.SpecialRequirementsPo;

public class SpecialRequirementsOpenMgrImpl implements SpecialRequirementsOpenMgr {
	private SpecialRequirementsOpenDao specialRequirementsOpenDao;

	

	public SpecialRequirementsOpenDao getSpecialRequirementsOpenDao() {
		return specialRequirementsOpenDao;
	}

	public void setSpecialRequirementsOpenDao(
			SpecialRequirementsOpenDao specialRequirementsOpenDao) {
		this.specialRequirementsOpenDao = specialRequirementsOpenDao;
	}

	/**
	 * 显示特殊加工要求并分页
	 */
	public List<SpecialRequirementsPo> geSpecialRequirementsList(
			SpecialRequirementsPo po, int start, int size) {
		
		return specialRequirementsOpenDao.geSpecialRequirementsList(po, start, size);
	}

	/**
	 * 查询特殊加工要求数量
	 */
	public int getSpecialRequirementsCount(SpecialRequirementsPo po) {
		
		return specialRequirementsOpenDao.getSpecialRequirementsCount(po);
	}

}
