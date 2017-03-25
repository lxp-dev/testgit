package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.CorrectingErrorsDao;
import com.pengsheng.eims.basic.dao.FittingTemplateDao;
import com.pengsheng.eims.basic.persistence.CorrectingErrorsPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplatePo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.SystemClearDao;
import com.pengsheng.eims.system.dao.ExternalAccountParameterDao;
import com.pengsheng.eims.system.dao.PersonInfoDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.ExternalAccountParameterMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class ExternalAccountParameterMgrImpl implements ExternalAccountParameterMgr{
	
	private PersonInfoDao personInfoDao;
	private ExternalAccountParameterDao externalAccountParameterDao;
	public ExternalAccountParameterDao getExternalAccountParameterDao() {
		return externalAccountParameterDao;
	}
	public void setExternalAccountParameterDao(
			ExternalAccountParameterDao externalAccountParameterDao) {
		this.externalAccountParameterDao = externalAccountParameterDao;
	}
	public PersonInfoDao getPersonInfoDao() {
		return personInfoDao;
	}
	public void setPersonInfoDao(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}
	/**
	 * 导出人员编号
	 * 
	 * @param personInfoPo
	 */
	public List<PersonInfoPo> exportPersonInfo(PersonInfoPo personInfoPo){
		return personInfoDao.exportPersonInfo(personInfoPo);
	}
	public void insertExternalAccountParameter(ExternalAccountParameterPo po){
		if(!"".equals(externalAccountParameterDao.getExternalAccountParameterPo(po).getFeaid())){
			externalAccountParameterDao.deleteExternalAccountParameter(po);
			externalAccountParameterDao.insertExternalAccountParameter(po);
		}else{
			externalAccountParameterDao.insertExternalAccountParameter(po);
		}
	}
	public ExternalAccountParameterPo getExternalAccountParameterPo(ExternalAccountParameterPo po){
		return externalAccountParameterDao.getExternalAccountParameterPo(po);
	}
	public void deleteExternalAccountParameter(ExternalAccountParameterPo po){
		externalAccountParameterDao.deleteExternalAccountParameter(po);
	}
}
