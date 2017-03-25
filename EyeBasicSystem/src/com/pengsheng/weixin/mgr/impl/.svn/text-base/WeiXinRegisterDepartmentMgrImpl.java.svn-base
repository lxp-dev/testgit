package com.pengsheng.weixin.mgr.impl;

import java.util.List;
import com.pengsheng.weixin.dao.WeiXinRegisterDepartmentDao;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;

public class WeiXinRegisterDepartmentMgrImpl implements WeiXinRegisterDepartmentMgr {
	
	private WeiXinRegisterDepartmentDao weiXinRegisterDepartmentDao;

	public void deleteWeiXinRegisterDepartment(WeiXinRegisterDepartmentPo po) {
		weiXinRegisterDepartmentDao.deleteWeiXinRegisterDepartment(po);
	}

	public void insertWeiXinRegisterDepartment(WeiXinRegisterDepartmentPo po) {
		weiXinRegisterDepartmentDao.insertWeiXinRegisterDepartment(po);
	}

	public int selectWeiXinRegisterDepartmentCount(WeiXinRegisterDepartmentPo po) {
		return weiXinRegisterDepartmentDao.selectWeiXinRegisterDepartmentCount(po);
	}

	public List<WeiXinRegisterDepartmentPo> selectWeiXinRegisterDepartments(){
		return weiXinRegisterDepartmentDao.selectWeiXinRegisterDepartments();
	}	
	public List<WeiXinRegisterDepartmentPo> selectWeiXinRegisterDepartments(WeiXinRegisterDepartmentPo po,
			int start, int size) {
		return weiXinRegisterDepartmentDao.selectWeiXinRegisterDepartments(po, start, size);
	}

	public void updateWeiXinRegisterDepartment(WeiXinRegisterDepartmentPo po) {
		weiXinRegisterDepartmentDao.updateWeiXinRegisterDepartment(po);

	}

	public WeiXinRegisterDepartmentPo getWeiXinRegisterDepartmentPo(WeiXinRegisterDepartmentPo po) {
		// TODO Auto-generated method stub
		return weiXinRegisterDepartmentDao.getWeiXinRegisterDepartmentPo(po);
	}

	public WeiXinRegisterDepartmentDao getWeiXinRegisterDepartmentDao() {
		return weiXinRegisterDepartmentDao;
	}

	public void setWeiXinRegisterDepartmentDao(WeiXinRegisterDepartmentDao weiXinRegisterDepartmentDao) {
		this.weiXinRegisterDepartmentDao = weiXinRegisterDepartmentDao;
	}
}
