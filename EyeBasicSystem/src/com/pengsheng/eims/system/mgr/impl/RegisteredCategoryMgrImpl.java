package com.pengsheng.eims.system.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.RegisteredCategoryDao;
import com.pengsheng.eims.system.mgr.RegisteredCategoryMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.util.tools.Utility;

/**
 * RegisteredCategoryMgrImpl 挂号类型Mgr实现类
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public class RegisteredCategoryMgrImpl implements RegisteredCategoryMgr {

	private RegisteredCategoryDao registeredCategoryDao;
	private LogisticsLogDao logisticsLogDao;
	
	public RegisteredCategoryDao getRegisteredCategoryDao() {
		return registeredCategoryDao;
	}

	public void setRegisteredCategoryDao(
			RegisteredCategoryDao registeredCategoryDao) {
		this.registeredCategoryDao = registeredCategoryDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 新增挂号类型
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void insertRegisteredCategory(RegisteredCategoryPo po,
			List<RegisteredPrintDetailsPo> details,LogisticsLogPo logPo) {
		registeredCategoryDao.insertRegisteredCategory(po);

		if (details != null) {
			for (RegisteredPrintDetailsPo registeredPrintDetailsPo : details) {

				registeredPrintDetailsPo.setFrpdregisteredid(po.getFrcid());
				registeredCategoryDao
						.insertRegisteredPrintDetails(registeredPrintDetailsPo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 检查挂号类型编号是否重复
	 * 
	 * @param po
	 *            挂号类型po
	 * @return int 0:不存在 大于0存在
	 */
	public int searchRegisteredId(RegisteredCategoryPo po) {
		// TODO Auto-generated method stub
		return registeredCategoryDao.searchRegisteredId(po);
	}

	/**
	 * 按条件检索检查费用项目进行管理
	 * 
	 * @param flag
	 *            启用停用标示位 1:启用 0：停用
	 * @param feeType
	 *            收费类型 1:缴费 2：退费
	 * @return List
	 */
	public List getSelValue(String flag, String feeType) {
		return registeredCategoryDao.getSelValue(flag, feeType);
	}

	/**
	 * 挂号类型维护保存
	 * 
	 * @param stop
	 *            停用主键ID
	 * @param start
	 *            启用主键ID
	 * @return void
	 */
	public void saveManagerValue(String[] stop, String[] start,LogisticsLogPo logPo) {
		registeredCategoryDao.saveManagerValue(stop, start);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po
	 *            查询条件
	 * @return int 挂号类型数量
	 */
	public int getRegisteredCategoryCount(RegisteredCategoryPo po) {
		return registeredCategoryDao.getRegisteredCategoryCount(po);
	}

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po
	 *            查询条件 start 开始数量 size 每页显示数量
	 * @return List 挂号类型结果集
	 */
	public List getRegisteredCategoryList(RegisteredCategoryPo po, int start,
			int size) {
		return registeredCategoryDao.getRegisteredCategoryList(po, start, size);
	}

	/**
	 * 查询挂号类型的详细信息
	 * 
	 * @param po
	 *            查询条件
	 * @return po 挂号类型详细信息
	 */
	public RegisteredCategoryPo getRegisteredCategoryPo(RegisteredCategoryPo po) {
		return registeredCategoryDao.getRegisteredCategoryPo(po);
	}

	/**
	 * 更新挂号类型信息
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po,
			List<RegisteredPrintDetailsPo> details,LogisticsLogPo logPo) {
		registeredCategoryDao.updateRegisteredCategory(po);

		registeredCategoryDao.delRegisteredPrintDetails(po.getFrcid());

		if (details != null) {
			for (RegisteredPrintDetailsPo registeredPrintDetailsPo : details) {

				registeredPrintDetailsPo.setFrpdregisteredid(po.getFrcid());
				registeredCategoryDao
						.insertRegisteredPrintDetails(registeredPrintDetailsPo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除挂号类型
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void deleteRegisteredCategory(RegisteredCategoryPo po,LogisticsLogPo logPo) {
		registeredCategoryDao.deleteRegisteredCategory(po);
		registeredCategoryDao.delRegisteredPrintDetails(po.getFrcid());
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询挂号类型在 表中是否已经使用
	 * 
	 * @param po
	 *            查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getRegisteredCategoryWithOther(RegisteredCategoryPo po) {
		return registeredCategoryDao.getRegisteredCategoryWithOther(po);
	}

	public List<RegisteredPrintDetailsPo> getRegisteredPrintDetails(
			String registeredID) {
		// TODO Auto-generated method stub
		return registeredCategoryDao.getRegisteredPrintDetails(registeredID);
	}

}
