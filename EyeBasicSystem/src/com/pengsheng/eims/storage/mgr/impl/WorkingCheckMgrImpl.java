package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.WorkingCheckDao;
import com.pengsheng.eims.storage.mgr.WorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class WorkingCheckMgrImpl implements WorkingCheckMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private WorkingCheckDao workingCheckDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public WorkingCheckDao getWorkingCheckDao() {
		return workingCheckDao;
	}

	public void setWorkingCheckDao(WorkingCheckDao workingCheckDao) {
		this.workingCheckDao = workingCheckDao;
	}

	/**
	 * 得到检验信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getWorkingCheckCount(SalesBasicPo salesBasicPo) {
		return workingCheckDao.getWorkingCheckCount(salesBasicPo);
	}

	/**
	 * 得到检验信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectWorkingCheck(SalesBasicPo salesBasicPo,
			int start, int size) {
		return workingCheckDao.selectWorkingCheck(salesBasicPo, start, size);
	}

	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){			
			return workingCheckDao.getCustomerInfoFinished(salesBasicPo);
		}	
		return workingCheckDao.getCustomerInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
        if (inTransitDetailsDao.getDetailCount(salesBasicPo,"R") > 0){
        	return workingCheckDao.getODDetailInfo(salesBasicPo);
        }
		return workingCheckDao.getODDetailInfoFinished(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
        if (inTransitDetailsDao.getDetailCount(salesBasicPo,"L") > 0){
        	return workingCheckDao.getOSDetailInfo(salesBasicPo);
        }
		return workingCheckDao.getOSDetailInfoFinished(salesBasicPo);
	}

	/**
	 * 取加工师下拉列表
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getWorkingChenkPerson(PersonInfoPo personInfoPo) {
		return workingCheckDao.getWorkingChenkPerson(personInfoPo);
	}


	public MistakePo getMistakeODPo(SalesBasicPo salesBasicPo) {
		MistakePo mistakePo = new MistakePo();
		String odsphmistake=workingCheckDao.getMistakeSphPo(salesBasicPo, "fmtodsphmistake").getFmtodsphmistake();
		mistakePo.setFmtodsphmistake(odsphmistake);
		String odcylmistake=workingCheckDao.getMistakeCylPo(salesBasicPo, "fmtodcylmistake").getFmtodcylmistake();
		mistakePo.setFmtodcylmistake(odcylmistake);
		
		String odaxesmistake=workingCheckDao.getMistakeAxesODPo(salesBasicPo, "fmtodaxesmistake").getFmtodaxesmistake();
		mistakePo.setFmtodaxesmistake(odaxesmistake);
		
		String odaddmistake=workingCheckDao.getMistakeAddODPo(salesBasicPo, "fmtodaddmistake").getFmtodaddmistake();
		mistakePo.setFmtodaddmistake(odaddmistake);
		
		
		String odtjmistake=workingCheckDao.getMistakeTjPo(salesBasicPo, "fmtodtjmistake").getFmtodtjmistake();
		mistakePo.setFmtodtjmistake(odtjmistake);
		
		String odscmistake=workingCheckDao.getMistakeSCPo(salesBasicPo, "fmtodsphandcylmistake").getFmtodsphandcylmistake();
		mistakePo.setFmtodsphandcylmistake(odscmistake);
		return mistakePo;
	}
	
	public MistakePo getMistakeOSPo(SalesBasicPo salesBasicPo) {
		MistakePo mistakePo = new MistakePo();
		String ossphmistake=workingCheckDao.getMistakeSphPo(salesBasicPo, "fmtossphmistake").getFmtossphmistake();
		mistakePo.setFmtossphmistake(ossphmistake);
		String oscylmistake=workingCheckDao.getMistakeCylPo(salesBasicPo, "fmtoscylmistake").getFmtoscylmistake();
		mistakePo.setFmtoscylmistake(oscylmistake);
		
		String osaxesmistake=workingCheckDao.getMistakeAxesOSPo(salesBasicPo, "fmtosaxesmistake").getFmtosaxesmistake();
		mistakePo.setFmtosaxesmistake(osaxesmistake);
		
		String osaddmistake=workingCheckDao.getMistakeAddOSPo(salesBasicPo, "fmtosaddmistake").getFmtosaddmistake();
		mistakePo.setFmtosaddmistake(osaddmistake);
		
		String ostjmistake=workingCheckDao.getMistakeTjPo(salesBasicPo, "fmtostjmistake").getFmtostjmistake();
		mistakePo.setFmtostjmistake(ostjmistake);
		String osscmistake=workingCheckDao.getMistakeSCPo(salesBasicPo, "fmtossphandcylmistake").getFmtossphandcylmistake();
		mistakePo.setFmtossphandcylmistake(osscmistake);
		return mistakePo;
	}

	/**
	 * 新增检验信息
	 * @param inTransitPo
	 * @param salesPo
	 * @param workingCheckPo
	 */
	public void insertWorkingCheck(InTransitPo inTransitPo,
			SalesBasicPo salesPo, WorkingCheckPo workingCheckPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		workingCheckDao.insertIntrnsitInfo(inTransitPo);
		
		workingCheckDao.updateWorkingCheckInTransit(salesPo);
		
		workingCheckDao.insertWorkingCheck(workingCheckPo);
		
	}
	
	/**
	 * 获取上次检验记录
	 * @param inTransitPo
	 * @param salesPo
	 * @param workingCheckPo
	 */
	public WorkingCheckPo getLastWorkingCheckPo(SalesBasicPo salesBasicPo){
		return workingCheckDao.getLastWorkingCheckPo(salesBasicPo);
	}
	
	/**
	 * 检验单详细
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getWorkingCheckPo(String salesid){
		return workingCheckDao.getWorkingCheckPo(salesid);
	}
	
	/**
	 * 取出销售单镜架信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getFrameDetailInfo(SalesBasicPo salesBasicPo){
        if (inTransitDetailsDao.getDetailCount(salesBasicPo) > 0){
        	return workingCheckDao.getFrameDetailInfo(salesBasicPo);
        }
		return workingCheckDao.getFrameDetailInfoFinished(salesBasicPo);
	}
}
