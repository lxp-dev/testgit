package com.pengsheng.eims.system.mgr.impl;

import java.util.List;
import com.pengsheng.eims.system.dao.MacDao;
import com.pengsheng.eims.system.mgr.MacMgr;
import com.pengsheng.eims.system.persistence.MacPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class MacMgrImpl implements MacMgr {
	
	

	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private MacDao macDao;

	public MacPo getMac(MacPo macPo) {
		return this.macDao.getMac(macPo);
	}
	
	/**
	 * 取仓位总数
	 */
	public int getMacCount(MacPo macPo){
		return this.macDao.getMacCount(macPo);
	}

	private final String UPDATE_PERSON_CHECK_MAC = "update";
	private final String DEL_PERSON_CHECK_MAC = "del";
	public void updatePersonCheckMac(String[] insertPersonIDs, String updateOrDelFlag,
			LogisticsLogPo logPo) {
		
		for (String insertPersonID : insertPersonIDs) {
			
			macDao.updatePersonCheckMac(insertPersonID, updateOrDelFlag);
			
			if(updateOrDelFlag.equals(UPDATE_PERSON_CHECK_MAC)) {
				
				logPo.setsLogContent("Mac地址验证例外人员新增:" + insertPersonID +"新增!");
			} else if(updateOrDelFlag.equals(DEL_PERSON_CHECK_MAC)) {
				
				logPo.setsLogContent("Mac地址验证例外人员删除:" + insertPersonID +"删除!");
			}
			logisticsLogDao.insertLog(logPo); //添加日志
		}
	}
	/**
	 * 取仓位List(分页)
	 */
	public List<MacPo> getMacList(MacPo macPo,int start,int size){
		return this.macDao.getMacList(macPo,start,size);
	}

	public void insertMac(MacPo macPo,LogisticsLogPo logPo) {
		this.macDao.insertMac(macPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateMacLogin(MacPo macPo) {
		this.macDao.updateMacLogin(macPo);
	}
	
	public void updateMac(MacPo macPo,LogisticsLogPo logPo) {
		this.macDao.updateMac(macPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public MacDao getMacDao() {
		return macDao;
	}

	public void setMacDao(MacDao macDao) {
		this.macDao = macDao;
	}

	public void deleteMac(String id,LogisticsLogPo logPo) {
		this.macDao.deleteMac(id);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public int getISMacrepeat(MacPo macPo) {
		return this.macDao.getISMacrepeat(macPo);
	}
	
	public List<PersonInfoPo> getPersonInfosForMac(PersonInfoPo personInfoPo,
			int start, int size) {
		return macDao.getPersonInfosForMac(personInfoPo, start, size);
	}
	
	public int getPersoninfosForMacCount(PersonInfoPo personInfoPo) {
		return macDao.getPersoninfosForMacCount(personInfoPo);
	}
	
  
}
