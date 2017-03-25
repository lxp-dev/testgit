package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.AdditionalCDetailDao;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AdditionalCDetailDaoImpl extends BaseJdbcDaoSupport implements
		AdditionalCDetailDao {

	/**
	 * 插入附加费用
	 * 
	 * @param additionalCDetailPo
	 * @return
	 */
	public void insertAdditionalCDetail(AdditionalCDetailPo additionalCDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_AdditionalCDetail ");
		sb.append("select ?, ?, f_ac_id,F_AC_Name ");
		sb.append(", F_AC_Amount,? from F_AdditionalCosts where f_ac_id = ?");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(additionalCDetailPo.getSsesalesid());
		params.add(additionalCDetailPo.getSsenumber());
		params.add(additionalCDetailPo.getSseadditionalid());
		this.getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 根据配镜单号查询
	 * 
	 * @param additionalCDetailPo
	 * @return
	 */
	public List<AdditionalCDetailPo> getAdditionalCDetailPos(String salesID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select S_SE_ID as sseid ,");
		sb.append("S_SE_CostsName    as ssecostsname    ,");
		sb.append("S_SE_Amount        as sseamount ");
		sb.append("from S_SE_AdditionalCDetail where S_SE_SalesID=? ");
		List<String> params = new ArrayList<String>();
		params.add(salesID);
		return this.queryForObjectList(sb.toString(), params.toArray(),AdditionalCDetailPo.class);
	}

}
