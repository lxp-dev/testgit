package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface CustomerComplainMgr {
	/**
	 * 插入投诉主表
	 * @param po
	 */
	public void insertCustomerComplainPo(CustomerComplainPo po,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,LogisticsLogPo logisticsLogPo) ;
	
	/**
	 * 查询投诉Po
	 * @param po
	 * @return
	 */
	public CustomerComplainPo selectCustomerComplainPo (CustomerComplainPo po);
	
	/**
	 * 获取分页Count
	 * @param po
	 * @return
	 */
	public int selectCustomerComplainCount (CustomerComplainPo po);
	
	/**
	 * 获取分页List
	 * @param po
	 * @return
	 */
	public List<CustomerComplainPo> selectCustomerComplainList (CustomerComplainPo po, int start, int size);
	
	/**
	 * 更新主表处理状态及时间
	 * @param po
	 */
	public void updateCustomerComplainPo (CustomerComplainPo po,LogisticsLogPo logisticsLogPo);
	
	/**
	 * 获取处理List
	 * @param po
	 * @return
	 */
	public List<CustomerComplainPo> selectCustomerComplainHandleList (CustomerComplainPo po);
	/**
	 * 会员详细链接LIST
	 * @param po
	 * @return
	 */
	public List<CustomerComplainPo> getCustomerComplainListByCustomer(String id,int start, int size) ;
	/**
	 * 会员详细链接总数
	 * @param po
	 * @return
	 */
	public int getCustomerComplainCountByCustomer(String id) ;
	
	/**
	 * 删除投诉
	 * @param po
	 */
	public void deleteCustomerComplain(CustomerComplainPo po,LogisticsLogPo logisticsLogPo);
	
	/**
	 * 获取改配镜单的投诉总数
	 * @param po
	 * @return
	 */
	public int getCustomerComplainBySalesBillCount (CustomerComplainPo po);
	
}
