package com.pengsheng.weixin.dao;

import java.util.List;
import com.pengsheng.weixin.persistence.WeiXinDoctorAppraisalPo;

public interface WeiXinDoctorAppraisalDao {
	/**
	 * 新增验光师评价
	 * @param po
	 */
	public void insertWeiXinDoctorAppraisalPo(WeiXinDoctorAppraisalPo po);
	
	/**
	 * 获得某检查结论评价数量
	 * @param inspectionID
	 */
	public int selectWeiXinDoctorAppraisalisOk(String inspectionID);
	
	/**
	 * 获得某验光师论评价数量
	 * @param inspectionID
	 */
	public int selectWeiXinDoctorAppraisalCount(String doctorID);
	
	/**
	 * 获取验光师好评率
	 * @param  doctorID
	 * @return
	 */
	public int selectWeiXinDoctorAppraisalHaopinglv(String doctorID);
	
	/**
	 * 获取验光师信息评价List
	 * @param  doctorID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinDoctorAppraisalPo> selectWeiXinDoctorAppraisalList(String doctorID, int start,int size);
	
	public List<WeiXinDoctorAppraisalPo> selectWeiXinDoctorAppraisalList(String doctorID);
}
