package com.pengsheng.eims.report.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.report.dao.LeaderBoardDao;
import com.pengsheng.eims.report.mgr.LeaderBoardMgr;

public class LeaderBoardMgrImpl implements LeaderBoardMgr {
	
	private LeaderBoardDao leaderBoardDao;
	
	/**
	 *   各店独立核算表,查询各个销售门店
	 */
	public List<DepartmentsPo> getEachStoreList(){
		return leaderBoardDao.getEachStoreList();
	}
	
	/**
	 *   根据不同的部门参数获取部门列表
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po){
		return leaderBoardDao.getDepartmentList(po);
	}

	/**
	 * 查询商品类别
	 */
	public List<GoodsCategoryPo> getGoodsCategoryList(){
		return leaderBoardDao.getGoodsCategoryList();
	}
	
	public LeaderBoardDao getLeaderBoardDao() {
		return leaderBoardDao;
	}

	public void setLeaderBoardDao(LeaderBoardDao leaderBoardDao) {
		this.leaderBoardDao = leaderBoardDao;
	}
	
	
}
