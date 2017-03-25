package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.JbtiaoDao;
import com.pengsheng.eims.basic.persistence.JbtiaoPo;
import com.pengsheng.eims.basic.persistence.JbtiaoTypePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class JbtiaoDaoImpl extends BaseJdbcDaoSupport implements JbtiaoDao {
	
	
	public List<JbtiaoTypePo> getJbtiaoTypeList() {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select B_JB_ID as bjbid,B_JB_Name as bjbname from B_JbType");


		return queryForObjectList(buffer.toString(), params.toArray(),
				JbtiaoTypePo.class);
	}
	
	
	public JbtiaoPo getJbtiaoPo(JbtiaoPo jbtiaoPo) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select top 1 ");
		buffer.append("KQ_JB_Tiao.ID as id ");
		buffer.append(",PInfo_id as pinfoid ");
		buffer.append(",KQ_DT as kqdt ");
		buffer.append(",JBSB_Time as jbsbtime ");
		buffer.append(",JBXB_Time as jbxbtime ");
		buffer.append(",JBSB_Time_B as jbsbtimeb ");
		buffer.append(",JBSB_Time_E as jbsbtimee ");
		buffer.append(",JBXB_Time_B as jbxbtimeb ");
		buffer.append(",JBXB_Time_E as jbxbtimee ");
		buffer.append(",JB_Time as jbtime ");
		buffer.append(",SB_IS_DK as sbisdk ");
		buffer.append(",XB_IS_DK as xbisdk ");
		buffer.append(",Record_YN as recordyn ");
		buffer.append(",JB_Type as jbtype ");
		buffer.append(",personName as personname ");
		buffer.append(",B_JB_Name as jbtypename ");
		buffer.append("FROM KQ_JB_Tiao ");
		buffer.append("inner join SYS_PersonInfo on PInfo_id=SYS_PersonInfo.ID ");
		buffer.append("inner join B_JbType on B_JB_ID=JB_Type ");
		buffer.append("where KQ_JB_Tiao.ID=? ");

		List<String> params = new ArrayList<String>();
		
		params.add(jbtiaoPo.getId());


		return (JbtiaoPo) queryForObject(buffer.toString(), params
				.toArray(), JbtiaoPo.class);
	}
	
	
	public void insertJbtiao(JbtiaoPo jbtiaoPo) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO KQ_JB_Tiao ");
		buffer.append("(ID ");
		buffer.append(",PInfo_id ");
		buffer.append(",KQ_DT ");
		buffer.append(",JBSB_Time ");
		buffer.append(",JBXB_Time ");
		buffer.append(",JBSB_Time_B ");
		buffer.append(",JBSB_Time_E ");
		buffer.append(",JBXB_Time_B ");
		buffer.append(",JBXB_Time_E ");
		buffer.append(",JB_Time ");
		buffer.append(",SB_IS_DK ");
		buffer.append(",XB_IS_DK ");
		buffer.append(",Record_YN ");
		buffer.append(",JB_Type )");
		buffer.append("VALUES (?, ?, ? ,?, ?, ? ,?, ?, ? ,?, ?, ? ,? ,?) ");

		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(jbtiaoPo.getPinfoid());
		params.add(jbtiaoPo.getKqdt());
		params.add(jbtiaoPo.getJbsbtime());
		params.add(jbtiaoPo.getJbxbtime());
		params.add(jbtiaoPo.getJbsbtimeb());
		params.add(jbtiaoPo.getJbsbtimee());
		params.add(jbtiaoPo.getJbxbtimeb());
		params.add(jbtiaoPo.getJbxbtimee());
		params.add(jbtiaoPo.getJbtime());
		params.add(jbtiaoPo.getSbisdk());
		params.add(jbtiaoPo.getXbisdk());
		params.add("1");
		params.add(jbtiaoPo.getJbtype());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public int getJbtiaoCount(JbtiaoPo jbtiaoPo){
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(KQ_JB_Tiao.ID) ");
		buffer.append("from KQ_JB_Tiao "); 
		buffer.append("inner join SYS_PersonInfo on PInfo_id=SYS_PersonInfo.ID ");
		buffer.append("inner join B_JbType on B_JB_ID=JB_Type ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(jbtiaoPo.getBegindate()))) {
			buffer.append("and convert(varchar(10),JBSB_Time,23)>=? ");
			params.add(jbtiaoPo.getBegindate());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getEnddate()))) {
			buffer.append("and convert(varchar(10),JBXB_Time,23)<=? ");
			params.add(jbtiaoPo.getEnddate());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getJbtype()))) {
			buffer.append("and JB_Type=? ");
			params.add(jbtiaoPo.getJbtype());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getPinfoid()))) {
			buffer.append("and PInfo_id=? ");
			params.add(jbtiaoPo.getPinfoid());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getPersonname()))) {
			buffer.append("and personName like '%' + ? + '%' ");
			params.add(jbtiaoPo.getPersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(jbtiaoPo.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(jbtiaoPo.getDepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}
	
	public List<JbtiaoPo> getJbtiaoList(JbtiaoPo jbtiaoPo, int start, int size){
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by JBSB_Time) as 'rowNum' ");
		buffer.append(",KQ_JB_Tiao.ID as id ");
		buffer.append(",PInfo_id as pinfoid ");
		buffer.append(",KQ_DT as kqdt ");
		buffer.append(",JBSB_Time as jbsbtime ");
		buffer.append(",JBXB_Time as jbxbtime ");
		buffer.append(",JBSB_Time_B as jbsbtimeb ");
		buffer.append(",JBSB_Time_E as jbsbtimee ");
		buffer.append(",JBXB_Time_B as jbxbtimeb ");
		buffer.append(",JBXB_Time_E as jbxbtimee ");
		buffer.append(",JB_Time as jbtime ");
		buffer.append(",SB_IS_DK as sbisdk ");
		buffer.append(",XB_IS_DK as xbisdk ");
		buffer.append(",Record_YN as recordyn ");
		buffer.append(",B_JB_Name as jbtypename ");
		buffer.append(",personName as personname ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append("from KQ_JB_Tiao "); 
		buffer.append("inner join SYS_PersonInfo on PInfo_id=SYS_PersonInfo.ID ");
		buffer.append("inner join B_JbType on B_JB_ID=JB_Type ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(jbtiaoPo.getBegindate()))) {
			buffer.append("and convert(varchar(10),JBSB_Time,23)>=? ");
			params.add(jbtiaoPo.getBegindate());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getEnddate()))) {
			buffer.append("and convert(varchar(10),JBXB_Time,23)<=? ");
			params.add(jbtiaoPo.getEnddate());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getJbtype()))) {
			buffer.append("and JB_Type=? ");
			params.add(jbtiaoPo.getJbtype());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getPinfoid()))) {
			buffer.append("and PInfo_id=? ");
			params.add(jbtiaoPo.getPinfoid());
		}
		if (!"".equals(Utility.getName(jbtiaoPo.getPersonname()))) {
			buffer.append("and personName like '%' + ? + '%' ");
			params.add(jbtiaoPo.getPersonname());
		}
		
		// 所属部门
		if (!"".equals(Utility.getName(jbtiaoPo.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(jbtiaoPo.getDepartmentid()).split(",");
			int count = departments.length;
			
			params.add(departments[0]);
			for (int i = 1; i < count; i++){
				buffer.append(" ,? ");
				params.add(departments[i]);
			}
			buffer.append(" ) ) ");
		}		

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				JbtiaoPo.class);
	}
	
	public void updateJbtiao(JbtiaoPo jbtiaoPo){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("update KQ_JB_Tiao ");
		buffer.append("set  PInfo_id=? ");
		buffer.append(",KQ_DT=? ");
		buffer.append(",JBSB_Time=? ");
		buffer.append(",JBXB_Time=? ");
		buffer.append(",JBSB_Time_B=? ");
		buffer.append(",JBSB_Time_E=? ");
		buffer.append(",JBXB_Time_B =? ");
		buffer.append(",JBXB_Time_E =? ");
		buffer.append(",JB_Time=? ");
		buffer.append(",SB_IS_DK=? ");
		buffer.append(",XB_IS_DK=? ");
		buffer.append(",Record_YN=? ");
		buffer.append(",JB_Type=? ");
		buffer.append("where ID=? ");

		List<String> params = new ArrayList<String>();

		params.add(jbtiaoPo.getPinfoid());
		params.add(jbtiaoPo.getKqdt());
		params.add(jbtiaoPo.getJbsbtime());
		params.add(jbtiaoPo.getJbxbtime());
		params.add(jbtiaoPo.getJbsbtimeb());
		params.add(jbtiaoPo.getJbsbtimee());
		params.add(jbtiaoPo.getJbxbtimeb());
		params.add(jbtiaoPo.getJbxbtimee());
		params.add(jbtiaoPo.getJbtime());
		params.add(jbtiaoPo.getSbisdk());
		params.add(jbtiaoPo.getXbisdk());
		params.add("1");
		params.add(jbtiaoPo.getJbtype());
		params.add(jbtiaoPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void deleteJbtiao(JbtiaoPo jbtiaoPo){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from KQ_JB_Tiao ");
		buffer.append("where ID=? "); 

		List<String> params = new ArrayList<String>();

		params.add(jbtiaoPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
}
