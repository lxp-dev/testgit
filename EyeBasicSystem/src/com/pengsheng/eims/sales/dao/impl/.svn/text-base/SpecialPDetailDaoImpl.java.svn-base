package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.SpecialPDetailDao;
import com.pengsheng.eims.sales.persistence.SalesSpecialPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class SpecialPDetailDaoImpl extends BaseJdbcDaoSupport implements SpecialPDetailDao {

	


	/**插入加工要求明细
	 * @param inTransitPo
	 */

	
	public void insertSpecialPDetail(SpecialPDetailPo specialPDetailPo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_SE_SpecialPDetail(S_SE_SD_ID,S_SE_SD_SalesID,S_SE_SD_Requirement)");
		sb.append("values(?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(specialPDetailPo.getSsesdsalesid());
		params.add(specialPDetailPo.getSsesdrequirement());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**插入特殊加工要求明细
	 * @param inTransitPo
	 */

	
	public void insertSalesSpecial(SalesSpecialPo salesSpecialPo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_SE_SS_SalesSpecial(S_SE_SS_SalesUUID,S_SE_SS_SalesID,S_SE_SS_SalesType,S_SE_SS_SalesSpecialID,S_SE_SS_SalesValue)");
		sb.append("values(?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(salesSpecialPo.getSsesssalesid());
		params.add(salesSpecialPo.getSsesssalestype());
		params.add(salesSpecialPo.getSsessalesspecialid());
		params.add(salesSpecialPo.getSsesssalesvalue());
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	
	
}
