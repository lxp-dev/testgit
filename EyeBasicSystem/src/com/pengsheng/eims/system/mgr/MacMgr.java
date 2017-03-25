package com.pengsheng.eims.system.mgr;

import java.util.List;
import com.pengsheng.eims.system.persistence.MacPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface MacMgr {

	/**
	 * 取客户机总数
	 */
	public int getMacCount(MacPo macPo);
	
	/**
	 * 取客户机List(分页)
	 */
	public List<MacPo> getMacList(MacPo macPo,int start,int size);
	
	/**
	 * 取指定客户机
	 * 
	 * @param macPo
	 *            客户机参数集
	 * @return
	 */
	public MacPo getMac(MacPo macPo);

	/**
	 * 插入客户机
	 * 
	 * @param macPo
	 *            客户机参数集
	 */
	public void insertMac(MacPo macPo,LogisticsLogPo logPo);

	/**
	 * 更新客户机(不加入日志)
	 * 
	 * @param macPo
	 *            客户机参数集
	 */
	public void updateMacLogin(MacPo macPo);
	
	/**
	 * 更新客户机
	 * 
	 * @param macPo
	 *            客户机参数集
	 */
	public void updateMac(MacPo macPo,LogisticsLogPo logPo);

	/**
	 * 删除客户机
	 * 
	 * @param macPo
	 *            客户机参数集
	 */
	public void deleteMac(String id,LogisticsLogPo logPo);
	
	/**
	 * 判断客户机名称、Mac重复
	 * 
	 */
	public int getISMacrepeat (MacPo macPo) ;
	
	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfosForMac(PersonInfoPo personInfoPo,
			int start, int size);
	
	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosForMacCount(PersonInfoPo personInfoPo);

	/**
	 * 更新客户机
	 * 
	 * @param macPo
	 *            客户机参数集
	 */
	public void updatePersonCheckMac(String[] insertPersonIDs, String updateOrDelFlag, LogisticsLogPo logPo);
}
