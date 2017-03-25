package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.HisInfoDao;
import com.pengsheng.eims.basic.persistence.HisInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class HisInfoDaoImpl extends BaseJdbcDaoSupport implements HisInfoDao {

	public void deleteHisInfoList(HisInfoPo hisInfoPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete top (1) from B_His where B_H_ID = ? ");
		
		params.add(Utility.getName(hisInfoPo.getBhid()));			

		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

	public HisInfoPo getHisInfoDetail(HisInfoPo hisInfoPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_H_ID as bhid,B_H_HisName as bhhisname,B_H_HisUrl as bhhisurl from B_His where B_H_ID = ? ");
		
		params.add(Utility.getName(hisInfoPo.getBhid()));	
		
		return (HisInfoPo)queryForObject(buffer.toString(), params.toArray(), HisInfoPo.class);
	}

	public List<HisInfoPo> getHisInfoList(HisInfoPo hisInfoPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_H_ID as bhid,B_H_HisName as bhhisname,B_H_HisUrl as bhhisurl from B_His where 1 = 1 ");
		
		if (!"".equals(Utility.getName(hisInfoPo.getBhhisname()))){
			buffer.append(" and B_H_HisName like '%' + ? + '%' ");
			params.add(Utility.getName(hisInfoPo.getBhhisname()));			
		}
		
		return queryForObjectList(buffer.toString() ,params.toArray(), HisInfoPo.class);		
	}

	public void insertHisInfoList(HisInfoPo hisInfoPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_His (B_H_ID,B_H_HisName,B_H_HisUrl) values (?,?,?) ");
		
		params.add(Utility.getName(hisInfoPo.getBhid()));		
		params.add(Utility.getName(hisInfoPo.getBhhisname()));			
		params.add(Utility.getName(hisInfoPo.getBhhisurl()));			

		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

	public void updateHisInfoList(HisInfoPo hisInfoPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) B_His set B_H_HisName = ?,B_H_HisUrl = ? where B_H_ID = ? ");
		
		params.add(Utility.getName(hisInfoPo.getBhhisname()));			
		params.add(Utility.getName(hisInfoPo.getBhhisurl()));			
		params.add(Utility.getName(hisInfoPo.getBhid()));			

		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

}
