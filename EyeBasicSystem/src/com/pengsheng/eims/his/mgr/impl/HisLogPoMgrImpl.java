package com.pengsheng.eims.his.mgr.impl;

import java.util.List;

import com.pengsheng.eims.his.dao.HisLogPoDao;
import com.pengsheng.eims.his.mgr.HisLogPoMgr;
import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;

public class HisLogPoMgrImpl extends BaseAction implements  HisLogPoMgr{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HisLogPoDao hisLogPoDao;
	

	
	public HisLogPoDao getHisLogPoDao() {
		return hisLogPoDao;
	}
	public void setHisLogPoDao(HisLogPoDao hisLogPoDao) {
		this.hisLogPoDao = hisLogPoDao;
	}

	public int getHisLogPoCount(HisLogPo hisLogPo) {
		return hisLogPoDao.getHisLogPoCount(hisLogPo);
	}

	public List<HisLogPo> getHisLogPoList(HisLogPo hisLogPo, int start, int pageSize) {
		List<HisLogPo> list = hisLogPoDao.getHisLogPoList(hisLogPo,start,pageSize);
		
		return list;
	}

	public void insertHisLog(HisLogPo po) {
		String uuid = UUIDHexGenerator.getInstance().generate();
		po.setHislogid(uuid);
		hisLogPoDao.insertHisLog(po);
	}

	 
	
	/**
	 * 视光系统待交费用确认收费接口更新
	 */
	public void updateNotChargeStateByHis(SalesBasicPo spo) {
		hisLogPoDao.updateNotChargeStateByHis(spo);
		
	}
   /**
    *  接口名称：HIS系统作废待交费用接口更新
    */
	public void updateNotChargeStateBySG(SalesBasicPo spo) {
		hisLogPoDao.updateNotChargeStateBySG(spo);
	}

	public HisLogPo getHisLogInfo(HisLogPo po) {
	 
		return hisLogPoDao.getHisLogInfo(po);
	}
	 
	public int queryChargeStatecount(SalesBasicPo spo) {
		 
		return hisLogPoDao.queryChargeStatecount(spo);
	}
	 
	public List<HisLogPo> gethisLogList() {
	 
		return hisLogPoDao.gethisLogList();
	}

	

}
