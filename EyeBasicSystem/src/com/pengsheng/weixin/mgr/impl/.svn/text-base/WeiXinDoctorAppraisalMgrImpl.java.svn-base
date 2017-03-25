package com.pengsheng.weixin.mgr.impl;

import java.util.List;
import com.pengsheng.weixin.dao.WeiXinDoctorAppraisalDao;
import com.pengsheng.weixin.mgr.WeiXinDoctorAppraisalMgr;
import com.pengsheng.weixin.persistence.WeiXinDoctorAppraisalPo;

public class WeiXinDoctorAppraisalMgrImpl implements WeiXinDoctorAppraisalMgr {
	private WeiXinDoctorAppraisalDao weiXinDoctorAppraisalDao;
	/**
	 * 新增验光师评价
	 * @param po
	 */
	public void insertWeiXinDoctorAppraisalPo(WeiXinDoctorAppraisalPo po){
		this.weiXinDoctorAppraisalDao.insertWeiXinDoctorAppraisalPo(po);
	}
	
	/**
	 * 获得某检查结论评价数量
	 * @param inspectionID
	 */
	public int selectWeiXinDoctorAppraisalisOk(String inspectionID){
		return this.weiXinDoctorAppraisalDao.selectWeiXinDoctorAppraisalisOk(inspectionID);
	}
	
	/**
	 * 获得某验光师论评价数量
	 * @param inspectionID
	 */
	public int selectWeiXinDoctorAppraisalCount(String doctorID){
		return this.weiXinDoctorAppraisalDao.selectWeiXinDoctorAppraisalCount(doctorID);
	}
	
	/**
	 * 获取验光师好评率
	 * @param  doctorID
	 * @return
	 */
	public int selectWeiXinDoctorAppraisalHaopinglv(String doctorID){
		return this.weiXinDoctorAppraisalDao.selectWeiXinDoctorAppraisalHaopinglv(doctorID);
	}
	
	/**
	 * 获取验光师信息评价List
	 * @param  doctorID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinDoctorAppraisalPo> selectWeiXinDoctorAppraisalList(String doctorID, int start,int size){
		return this.weiXinDoctorAppraisalDao.selectWeiXinDoctorAppraisalList(doctorID, start, size);
	}

	public List<WeiXinDoctorAppraisalPo> selectWeiXinDoctorAppraisalList(String doctorID){
		return this.weiXinDoctorAppraisalDao.selectWeiXinDoctorAppraisalList(doctorID);
	}
	
	public WeiXinDoctorAppraisalDao getWeiXinDoctorAppraisalDao() {
		return weiXinDoctorAppraisalDao;
	}

	public void setWeiXinDoctorAppraisalDao(
			WeiXinDoctorAppraisalDao weiXinDoctorAppraisalDao) {
		this.weiXinDoctorAppraisalDao = weiXinDoctorAppraisalDao;
	}
}
