package com.pengsheng.weixin.dao;

import java.util.List;
import com.pengsheng.weixin.persistence.WeiXinOptometryAppointmentPo;

public interface WeiXinOptometryAppointmentDao {
	/**
	 * 会员新增预约
	 * @param po
	 */
	public void insertWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po);
	
	/**
	 * 更新预约
	 * @param po
	 */
	public void updateWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po);
	
	/**
	 * 获得预约
	 * @param po
	 */
	public WeiXinOptometryAppointmentPo selectWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po);
	
	/**
	 * 删除预约
	 * @param po
	 */
	public void deleteWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo po);
	
	/**
	 * 获取预约条数
	 * @param po
	 * @return
	 */
	public int selectWeiXinOptometryAppointmentCount(WeiXinOptometryAppointmentPo po);
	
	/**
	 * 获取预约List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinOptometryAppointmentPo> selectWeiXinOptometryAppointmentList(WeiXinOptometryAppointmentPo po);
	
	/**
	 * 获取预约List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinOptometryAppointmentPo> selectWeiXinOptometryAppointmentList(WeiXinOptometryAppointmentPo po, int start,int size);
}
