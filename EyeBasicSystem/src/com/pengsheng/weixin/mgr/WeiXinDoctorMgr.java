package com.pengsheng.weixin.mgr;

import java.util.List;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.weixin.persistence.WeiXinDoctorPo;

public interface WeiXinDoctorMgr {
	/**
	 * 新增验光师信息
	 * @param po
	 */
	public void insertWeiXinDoctorPo(WeiXinDoctorPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新验光师信息
	 * @param po
	 */
	public void updateWeiXinDoctorPo(WeiXinDoctorPo po,LogisticsLogPo logPo);
	
	/**
	 * 获得验光师信息
	 * @param po
	 */
	public WeiXinDoctorPo selectWeiXinDoctorPo(WeiXinDoctorPo po);
	
	/**
	 * 获得验光师信息
	 * @param String personID
	 */
	public WeiXinDoctorPo selectWeiXinDoctorPo(String personID);
	
	/**
	 * 删除验光师信息
	 * @param po
	 */
	public void deleteWeiXinDoctorPo(WeiXinDoctorPo po,LogisticsLogPo logPo);
	
	/**
	 * 获取验光师信息条数
	 * @param po
	 * @return
	 */
	public int selectWeiXinDoctorCount(WeiXinDoctorPo po);
	
	/**
	 * 获取验光师信息List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinDoctorPo> selectWeiXinDoctorList(WeiXinDoctorPo po, int start,int size);

	/**
	 * 获取验光师信息List
	 * @param po
	 * @return
	 */
	public List<WeiXinDoctorPo> selectWeiXinDoctorList(WeiXinDoctorPo po);
	
}
