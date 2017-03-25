package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.GlassesCheckDao;
import com.pengsheng.eims.storage.mgr.GlassesCheckMgr;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class GlassesCheckMgrImpl implements GlassesCheckMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private GlassesCheckDao glassesCheckDao;
	
	public GlassesCheckDao getGlassesCheckDao() {
		return glassesCheckDao;
	}

	public void setGlassesCheckDao(GlassesCheckDao glassesCheckDao) {
		this.glassesCheckDao = glassesCheckDao;
	}

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

	/**
	 * 得到检验信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getWorkingCheckCount(SalesBasicPo salesBasicPo) {
		return glassesCheckDao.getWorkingCheckCount(salesBasicPo);
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
		return glassesCheckDao.selectWorkingCheck(salesBasicPo, start, size);
	}

	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo) {
		if (inTransitDetailsDao.getSalesBasicInfoByID(salesBasicPo) == 0){			
			return glassesCheckDao.getCustomerInfoFinished(salesBasicPo);
		}	
		return glassesCheckDao.getCustomerInfo(salesBasicPo);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
        if (inTransitDetailsDao.getDetailCount(salesBasicPo,"R") > 0){
        	return glassesCheckDao.getODDetailInfo(salesBasicPo);
        }
		return glassesCheckDao.getODDetailInfoFinished(salesBasicPo);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
        if (inTransitDetailsDao.getDetailCount(salesBasicPo,"L") > 0){
        	return glassesCheckDao.getOSDetailInfo(salesBasicPo);
        }
		return glassesCheckDao.getOSDetailInfoFinished(salesBasicPo);
	}

	/**
	 * 取加工师下拉列表
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getWorkingChenkPerson(PersonInfoPo personInfoPo) {
		return glassesCheckDao.getWorkingChenkPerson(personInfoPo);
	}


	public MistakePo getMistakeODPo(SalesBasicPo salesBasicPo) {
		MistakePo mistakePo = new MistakePo();
		String odsphmistake=glassesCheckDao.getMistakeSphPo(salesBasicPo, "fmtodsphmistake").getFmtodsphmistake();
		mistakePo.setFmtodsphmistake(odsphmistake);
		String odcylmistake=glassesCheckDao.getMistakeCylPo(salesBasicPo, "fmtodcylmistake").getFmtodcylmistake();
		mistakePo.setFmtodcylmistake(odcylmistake);
		
		String odaxesmistake=glassesCheckDao.getMistakeAxesODPo(salesBasicPo, "fmtodaxesmistake").getFmtodaxesmistake();
		mistakePo.setFmtodaxesmistake(odaxesmistake);
		
		String odaddmistake=glassesCheckDao.getMistakeAddODPo(salesBasicPo, "fmtodaddmistake").getFmtodaddmistake();
		mistakePo.setFmtodaddmistake(odaddmistake);
		
		
		String odtjmistake=glassesCheckDao.getMistakeTjPo(salesBasicPo, "fmtodtjmistake").getFmtodtjmistake();
		mistakePo.setFmtodtjmistake(odtjmistake);
		
		String odscmistake=glassesCheckDao.getMistakeSCPo(salesBasicPo, "fmtodsphandcylmistake").getFmtodsphandcylmistake();
		mistakePo.setFmtodsphandcylmistake(odscmistake);
		return mistakePo;
	}
	
	public MistakePo getMistakeOSPo(SalesBasicPo salesBasicPo) {
		MistakePo mistakePo = new MistakePo();
		String ossphmistake=glassesCheckDao.getMistakeSphPo(salesBasicPo, "fmtossphmistake").getFmtossphmistake();
		mistakePo.setFmtossphmistake(ossphmistake);
		String oscylmistake=glassesCheckDao.getMistakeCylPo(salesBasicPo, "fmtoscylmistake").getFmtoscylmistake();
		mistakePo.setFmtoscylmistake(oscylmistake);
		
		String osaxesmistake=glassesCheckDao.getMistakeAxesOSPo(salesBasicPo, "fmtosaxesmistake").getFmtosaxesmistake();
		mistakePo.setFmtosaxesmistake(osaxesmistake);
		
		String osaddmistake=glassesCheckDao.getMistakeAddOSPo(salesBasicPo, "fmtosaddmistake").getFmtosaddmistake();
		mistakePo.setFmtosaddmistake(osaddmistake);
		
		String ostjmistake=glassesCheckDao.getMistakeTjPo(salesBasicPo, "fmtostjmistake").getFmtostjmistake();
		mistakePo.setFmtostjmistake(ostjmistake);
		String osscmistake=glassesCheckDao.getMistakeSCPo(salesBasicPo, "fmtossphandcylmistake").getFmtossphandcylmistake();
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
		
		glassesCheckDao.insertWorkingCheck(workingCheckPo);
		
	}
	
	/**
	 * 获取上次检验记录
	 * @param inTransitPo
	 * @param salesPo
	 * @param workingCheckPo
	 */
	public WorkingCheckPo getLastWorkingCheckPo(SalesBasicPo salesBasicPo){
		return glassesCheckDao.getLastWorkingCheckPo(salesBasicPo);
	}
	
	/**
	 * 检验单详细
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getWorkingCheckPo(String salesid){
		return glassesCheckDao.getWorkingCheckPo(salesid);
	}
	
	/**
	 * 取出销售单镜架信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getFrameDetailInfo(SalesBasicPo salesBasicPo){
        if (inTransitDetailsDao.getDetailCount(salesBasicPo) > 0){
        	return glassesCheckDao.getFrameDetailInfo(salesBasicPo);
        }
		return glassesCheckDao.getFrameDetailInfoFinished(salesBasicPo);
	}
	
	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo){
		return glassesCheckDao.getdepartment(departmentsPo);
	}
	
	/**
	 * 得到打印检验单信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getGlassesCheckedCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo){
		return glassesCheckDao.getGlassesCheckedCount(salesBasicPo, workingCheckPo);
	}
	
	/**
	 * 查询打印检验单信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WorkingCheckPo> selectGlassesChecked(
			SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo, int start, int size){
		return glassesCheckDao.selectGlassesChecked(salesBasicPo, workingCheckPo, start, size);
	}
}
