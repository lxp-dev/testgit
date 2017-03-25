package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.MemberOriginDao;
import com.pengsheng.eims.basic.mgr.MemberOriginMgr;
import com.pengsheng.eims.basic.persistence.MemberOriginPo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class MemberOriginMgrImpl implements MemberOriginMgr{
	private MemberOriginDao memberOriginDao;
	private LogisticsLogMgr logisticsLogMgr;
	
	public void deleteMemberOriginPo(MemberOriginPo po,LogisticsLogPo logPo) {
		memberOriginDao.deleteMemberOriginPo(po);
		logisticsLogMgr.insertLog(logPo);
	}

	public void insertMemberOriginPo(MemberOriginPo po,LogisticsLogPo logPo) {
		memberOriginDao.insertMemberOriginPo(po);
		logisticsLogMgr.insertLog(logPo);
	}
	
	public int selectMemberOriginCount(MemberOriginPo po){
		return memberOriginDao.selectMemberOriginCount(po);
	}

	public List<MemberOriginPo> selectMemberOriginList() {
		return memberOriginDao.selectMemberOriginList();
	}


	public int getMemberOriginsCount()
	{
		return memberOriginDao.getMemberOriginsCount();
	}
	public List<MemberOriginPo> getMemberOriginsList(int start, int size) 
	{
		return memberOriginDao.getMemberOriginsList(start, size);
	}
	public MemberOriginPo selectMemberOriginPo(MemberOriginPo po) {
		return memberOriginDao.selectMemberOriginPo(po);
	}

	public void updateMemberOriginPo(MemberOriginPo po,LogisticsLogPo logPo) {
		memberOriginDao.updateMemberOriginPo(po);
		logisticsLogMgr.insertLog(logPo);
	}
	
	public int selectMemberOriginName(MemberOriginPo po)
	{
		return memberOriginDao.selectMemberOriginName(po);
	}
	public int selectMemberOriginNameUpdate(MemberOriginPo po)
	{
		return memberOriginDao.selectMemberOriginNameUpdate(po);
	}
	

	public MemberOriginDao getMemberOriginDao() {
		return memberOriginDao;
	}

	public void setMemberOriginDao(MemberOriginDao memberOriginDao) {
		this.memberOriginDao = memberOriginDao;
	}

	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	
}
