package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.QjccDao;
import com.pengsheng.eims.basic.persistence.JbtiaoPo;
import com.pengsheng.eims.basic.persistence.JbtiaoTypePo;
import com.pengsheng.eims.basic.persistence.QjccPo;
import com.pengsheng.eims.basic.persistence.QjccTypePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class QjccDaoImpl  extends BaseJdbcDaoSupport implements QjccDao {
	
	public List<QjccTypePo> getQjccTypeList(){
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select B_QJ_ID as bqjid ");
		buffer.append(",B_QJ_Name as bqjname ");
		buffer.append(",B_QJ_Parentid as bqjparentid ");
		buffer.append(",B_QJ_Flag as bqjflag ");
		buffer.append(" from B_QjccType ");
		buffer.append("where B_QJ_Flag='1' ");

		return queryForObjectList(buffer.toString(), params.toArray(),
				QjccTypePo.class);
	} 
	
	public List<QjccTypePo> getQjccTypeMinList(QjccTypePo qjccTypePo) {
		
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select B_QJ_ID as bqjid ");
		buffer.append(",B_QJ_Name as bqjname ");
		buffer.append(",B_QJ_Parentid as bqjparentid ");
		buffer.append(",B_QJ_Flag as bqjflag ");
		buffer.append(" from B_QjccType ");
		buffer.append(" where B_QJ_Flag='2' and B_QJ_Parentid=? ");
		
		params.add(qjccTypePo.getBqjparentid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				QjccTypePo.class);
	}
	
	public void insertQjcc(QjccPo qjccPo){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO KQ_Q_C_X ");
		buffer.append("(ID ");
		buffer.append(",PInfo_id ");
		buffer.append(",Type_Main ");
		buffer.append(",Type_Zi ");
		buffer.append(",Type_JS ");
		buffer.append(",Date_B ");
		buffer.append(",Time_B ");
		buffer.append(",Time_E ");
		buffer.append(",Sum_XS ");
		buffer.append(",Type_Say ");
		buffer.append(",CaoZuoYuan ");
		buffer.append(",DJ_Date) ");
		buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,getdate()) ");

		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(qjccPo.getPinfoid());
		params.add(qjccPo.getTypemain());
		params.add(qjccPo.getTypezi());
		params.add("1");
		params.add(qjccPo.getDateb());
		params.add(qjccPo.getTimeb());
		params.add(qjccPo.getTimee());
		params.add(qjccPo.getSumxs());
		params.add(qjccPo.getTypesay());
		params.add(qjccPo.getCaozuoyuan());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public QjccPo getQjccPo(QjccPo qjccPo){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select top 1 ");
		buffer.append("KQ_Q_C_X.ID as id ");
		buffer.append(",PInfo_id as pinfoid ");
		buffer.append(",Type_Main as typemain ");
		buffer.append(",Type_Zi as typezi ");
		buffer.append(",Type_JS as typejs ");
		buffer.append(",Date_B as dateb ");
		buffer.append(",Time_B as timeb ");
		buffer.append(",Time_E as timee ");
		buffer.append(",Sum_XS as sumxs ");
		buffer.append(",Type_Say as typesay ");
		buffer.append(",CaoZuoYuan as caozuoyuan ");
		buffer.append(",DJ_Date as djdate ");
		buffer.append(" ,personName as personname ");
		buffer.append(",a.B_QJ_Name as typemainname ");
		buffer.append(",b.B_QJ_Name as typeziname ");
		buffer.append("from KQ_Q_C_X ");
		buffer.append("inner join SYS_PersonInfo on PInfo_id=SYS_PersonInfo.ID ");
	    buffer.append("inner join (select B_QJ_ID,B_QJ_Name from B_QjccType)a on a.B_QJ_ID=Type_Main ");
	    buffer.append("inner join (select B_QJ_ID,B_QJ_Name from B_QjccType)b on b.B_QJ_ID=Type_Zi ");
	    buffer.append("where 1=1 ");
	    buffer.append("and KQ_Q_C_X.id=? ");

		List<String> params = new ArrayList<String>();
		
		params.add(qjccPo.getId());


		return (QjccPo) queryForObject(buffer.toString(), params
				.toArray(), QjccPo.class);
	}
	
	public int getQjccCount(QjccPo qjccPo){
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		

		buffer.append("SELECT count(KQ_Q_C_X.ID)  ");
		buffer.append("from KQ_Q_C_X ");
		buffer.append("inner join SYS_PersonInfo on PInfo_id=SYS_PersonInfo.ID ");
		buffer.append("inner join (select B_QJ_ID,B_QJ_Name from B_QjccType)a on a.B_QJ_ID=Type_Main ");
		buffer.append("inner join (select B_QJ_ID,B_QJ_Name from B_QjccType)b on b.B_QJ_ID=Type_Zi ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(qjccPo.getBegindate()))) {
			buffer.append("and convert(varchar(10),Time_B,23)>=? ");
			params.add(qjccPo.getBegindate());
		}
		if (!"".equals(Utility.getName(qjccPo.getEnddate()))) {
			buffer.append("and convert(varchar(10),Time_E,23)<=? ");
			params.add(qjccPo.getEnddate());
		}
		if (!"".equals(Utility.getName(qjccPo.getTypemain()))) {
			buffer.append("and Type_Main=? ");
			params.add(qjccPo.getTypemain());
		}
		if (!"".equals(Utility.getName(qjccPo.getTypezi()))) {
			buffer.append("and Type_Zi=? ");
			params.add(qjccPo.getTypezi());
		}
		if (!"".equals(Utility.getName(qjccPo.getPinfoid()))) {
			buffer.append("and PInfo_id=? ");
			params.add(qjccPo.getPinfoid());
		}
		if (!"".equals(Utility.getName(qjccPo.getPersonname()))) {
			buffer.append("and personName like '%' + ? + '%' ");
			params.add(qjccPo.getPersonname());
		}
		// 所属部门
		if (!"".equals(Utility.getName(qjccPo.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(qjccPo.getDepartmentid()).split(",");
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
	
	public List<QjccPo> getQjccList(QjccPo qjccPo, int start, int size){
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by Date_B) as 'rowNum' ");
		buffer.append(",KQ_Q_C_X.ID as id ");
		buffer.append(",PInfo_id as pinfoid ");
		buffer.append(",Type_Main as typemain ");
		buffer.append(",Type_Zi as typezi ");
		buffer.append(",Type_JS as typejs ");
		buffer.append(",Date_B as dateb ");
		buffer.append(",Time_B as timeb ");
		buffer.append(",Time_E as timee ");
		buffer.append(",Sum_XS as sumxs ");
		buffer.append(",Type_Say as typesay ");
		buffer.append(",CaoZuoYuan as caozuoyuan ");
		buffer.append(",DJ_Date as djdate ");
		buffer.append(",personName as personname ");
		buffer.append(",departmentname=stuff((select ',' + B_DP_DepartmentName from SYS_PersonDepartments,B_Departments where SYS_PersonInfo.ID = SYS_PD_PersonID and SYS_PD_DepartmentID=B_DP_DepartmentID for XML path('')) , 1 , 1 , '')");
		buffer.append(",a.B_QJ_Name as typemainname ");
		buffer.append(",b.B_QJ_Name as typeziname ");
		buffer.append("from KQ_Q_C_X ");
		buffer.append("inner join SYS_PersonInfo on PInfo_id=SYS_PersonInfo.ID ");
		buffer.append("inner join (select B_QJ_ID,B_QJ_Name from B_QjccType)a on a.B_QJ_ID=Type_Main ");
		buffer.append("inner join (select B_QJ_ID,B_QJ_Name from B_QjccType)b on b.B_QJ_ID=Type_Zi ");
		buffer.append("where 1=1 ");
		
		if (!"".equals(Utility.getName(qjccPo.getBegindate()))) {
			buffer.append("and convert(varchar(10),Time_B,23)>=? ");
			params.add(qjccPo.getBegindate());
		}
		if (!"".equals(Utility.getName(qjccPo.getEnddate()))) {
			buffer.append("and convert(varchar(10),Time_E,23)<=? ");
			params.add(qjccPo.getEnddate());
		}
		if (!"".equals(Utility.getName(qjccPo.getTypemain()))) {
			buffer.append("and Type_Main=? ");
			params.add(qjccPo.getTypemain());
		}
		if (!"".equals(Utility.getName(qjccPo.getTypezi()))) {
			buffer.append("and Type_Zi=? ");
			params.add(qjccPo.getTypezi());
		}
		if (!"".equals(Utility.getName(qjccPo.getPinfoid()))) {
			buffer.append("and PInfo_id=? ");
			params.add(qjccPo.getPinfoid());
		}
		if (!"".equals(Utility.getName(qjccPo.getPersonname()))) {
			buffer.append("and personName like '%' + ? + '%' ");
			params.add(qjccPo.getPersonname());
		}
		// 所属部门
		if (!"".equals(Utility.getName(qjccPo.getDepartmentid()))) {
			buffer.append(" and SYS_PersonInfo.ID in (select distinct SYS_PD_PersonID from SYS_PersonDepartments where SYS_PD_DepartmentID in ( ? ");
			
			String[] departments = Utility.getName(qjccPo.getDepartmentid()).split(",");
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
				QjccPo.class);
	}
	
	public void updateQjcc(QjccPo qjccPo){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("update KQ_Q_C_X ");
		buffer.append("set  PInfo_id=? ");
		buffer.append(",Type_Main=? ");
		buffer.append(",Type_Zi=? ");
		buffer.append(",Type_JS=? ");
		buffer.append(",Date_B=? ");
		buffer.append(",Time_B=? ");
		buffer.append(",Time_E =? ");
		buffer.append(",Sum_XS =? ");
		buffer.append(",Type_Say=? ");
		buffer.append(",CaoZuoYuan=? ");
		buffer.append(",DJ_Date=getdate() ");
		buffer.append("where ID=? ");

		List<String> params = new ArrayList<String>();

		params.add(qjccPo.getPinfoid());
		params.add(qjccPo.getTypemain());
		params.add(qjccPo.getTypezi());
		params.add("1");
		params.add(qjccPo.getDateb());
		params.add(qjccPo.getTimeb());
		params.add(qjccPo.getTimee());
		params.add(qjccPo.getSumxs());
		params.add(qjccPo.getTypesay());
		params.add(qjccPo.getCaozuoyuan());

		params.add(qjccPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void deleteQjcc(QjccPo qjccPo){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from KQ_Q_C_X ");
		buffer.append("where ID=? "); 

		List<String> params = new ArrayList<String>();

		params.add(qjccPo.getId());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
