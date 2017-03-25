/**
 * 
 */
package com.pengsheng.eims.bjtrhistory.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicBjtrDaoImpl extends BaseJdbcDaoSupport implements
		OptometryBasicBjtrDao {


	public int getcustomerOptometryBasicCount(String customerID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT count(S_OP_OB_CustomerID) ");
		buffer.append("FROM S_OP_OptometryBasic ");
		buffer.append("WHERE S_OP_OB_CustomerID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(customerID);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	
	public OptometryBasicPo getOptometryBasicPo(String optometryBasicID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 ");
		buffer.append("S_OP_OB_OptometryBasicID as sopoboptometrybasicid ");
		buffer.append(",S_OP_OB_CustomerID as sopobcustomerid ");
		buffer.append(",S_OP_OB_CustomerName as sopobcustomername ");
		buffer.append(",S_OP_OB_MedicalStartTime as sopobmedicalstarttime ");
		buffer.append(",S_OP_OB_MedicalEndTime as sopobmedicalendtime ");
		buffer.append("FROM S_OP_OptometryBasic ");
		buffer.append("WHERE S_OP_OB_OptometryBasicID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryBasicID);

		return (OptometryBasicPo) this.queryForObject(buffer.toString(), params
				.toArray(), OptometryBasicPo.class);
	}

	
	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size) {
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");

		buffer.append("select * ");
		buffer.append("from(SELECT ROW_NUMBER() Over ");
		buffer.append("(order by S_OP_OB_MedicalStartTime desc) as rowNum ");
		buffer.append(",S_OP_OB_OptometryBasicID as sopoboptometrybasicid ");
		buffer.append(",S_OP_OB_CustomerID as sopobcustomerid ");
		buffer.append(",S_OP_OB_CustomerName as sopobcustomername ");
		buffer.append(",S_OP_OB_MedicalStartTime as sopobmedicalstarttime ");
		buffer.append(",S_OP_OB_MedicalEndTime as sopobmedicalendtime ");
		buffer.append("FROM S_OP_OptometryBasic ");
		buffer.append("WHERE S_OP_OB_CustomerID = ? ");

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		List<String> params = new ArrayList<String>();
		params.add(customerID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				OptometryBasicPo.class);
	}

	
	public List<OptometryPo> getcustomerOptometrys(String basicID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ROW_NUMBER() OVER (ORDER BY S_OP_OY_Time )  as sopoyrownumber,");
		buffer.append("S_OP_OY_OptometryID as sopoyoptometryid ");
		buffer.append(", S_OP_OY_OptometryBasicID as sopoyoptometrybasicid ");
		buffer.append(", S_OP_OY_ShopCode as sopoyshopcode ");
		buffer.append(", S_OP_OY_CustomerID as sopoycustomerid ");
		buffer.append(", S_OP_OY_PersonID as sopoypersonid ");
		buffer.append(", S_OP_OY_Time as sopoytime ");
		buffer.append(", S_OP_OY_RecipeUpdateTime as sopoyrecipeupdatetime ");
		buffer.append(", S_OP_OY_Flag as sopoyflag ");
		buffer.append(", S_OP_OY_Updateuserid as sopoyupdateuserid ");
		buffer.append(", personName as sopoypersonname ");
		buffer.append(", B_DP_DepartmentName as sopoydepartmentname ");
		buffer.append(", S_OP_OY_isInternal as sopoyisinternal ");
		buffer.append(", isnull(S_OP_OY_OneOrMany,0) 	as sopoyoneormany ");
		buffer.append("FROM  S_OP_Optometry ");
		buffer.append("INNER JOIN SYS_PersonInfo ");
		buffer.append("ON S_OP_OY_PersonID = SYS_PersonInfo.ID ");
		buffer.append("INNER JOIN B_Departments ");
		buffer.append("ON S_OP_OY_ShopCode = B_DP_DepartmentID ");
		buffer.append("WHERE S_OP_OY_OptometryBasicID = ? ");
		buffer.append("ORDER BY S_OP_OY_Time DESC ");

		List<String> params = new ArrayList<String>();
		params.add(basicID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				OptometryPo.class);
	}

	
	public void delDoubleEyeFun(String optometryID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_DoubleEyeFunction ");
		buffer.append("WHERE S_OP_DE_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void delHealthCheck(String optometryID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_HealthCheck ");
		buffer.append("WHERE S_OP_HC_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void delRefractive(String optometryID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_Refractive ");
		buffer.append("WHERE S_OP_R_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void delInspection(String optometryID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_Inspection ");
		buffer.append("WHERE S_OP_IP_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void delOptometry(String optometryID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_Optometry ");
		buffer.append("WHERE S_OP_OY_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void delOptometryBasic(String optometryBasicID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_OptometryBasic ");
		buffer.append("WHERE S_OP_OB_OptometryBasicID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryBasicID);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public int getOptometryCount(String optometryBasicID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT COUNT(*) ");
		buffer.append("FROM S_OP_Optometry ");
		buffer.append("WHERE S_OP_OY_OptometryBasicID = ?  ");

		List<String> params = new ArrayList<String>();
		params.add(optometryBasicID);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}
	
	
	public void optometryBasicInsert(OptometryBasicPo optometryBasicPo){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_OP_OptometryBasic values(?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(optometryBasicPo.getSopoboptometrybasicid());
		params.add(optometryBasicPo.getSopobcustomerid());
		params.add(optometryBasicPo.getSopobcustomername());
		params.add(optometryBasicPo.getSopobmedicalstarttime());
		params.add(optometryBasicPo.getSopobmedicalendtime());
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void optometryInsert(OptometryPo optometryPo){
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO S_OP_Optometry ( ");
		sb.append(" S_OP_OY_OptometryID          "); 
		sb.append(",S_OP_OY_OptometryBasicID     "); 
		sb.append(",S_OP_OY_ShopCode             "); 
		sb.append(",S_OP_OY_CustomerID           "); 
		sb.append(",S_OP_OY_PersonID             "); 
		sb.append(",S_OP_OY_Time                 "); 
		sb.append(",S_OP_OY_RecipeUpdateTime     "); 
		sb.append(",S_OP_OY_Flag                 "); 
		sb.append(",S_OP_OY_Updateuserid         "); 
		sb.append(",S_OP_OY_isInternal           "); 
		sb.append(",S_OP_OY_OneOrMany            "); 
		sb.append(" ) values(?,?,?,?,?,?,?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(optometryPo.getSopoyoptometryid());
		params.add(optometryPo.getSopoyoptometrybasicid());
		params.add(optometryPo.getSopoyshopcode());
		params.add(optometryPo.getSopoycustomerid());
		params.add(optometryPo.getSopoypersonid());
		params.add(optometryPo.getSopoytime());
		params.add(optometryPo.getSopoyrecipeupdatetime());
		params.add(optometryPo.getSopoyflag());
		params.add(optometryPo.getSopoyupdateuserid());
		params.add(optometryPo.getSopoyisinternal());
		params.add(Utility.getName(optometryPo.getSopoyoneormany()));
		
		this.getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT COUNT(S_OP_OB_OptometryBasicID) ");
		buffer.append("FROM S_OP_Optometrybasic ");
		buffer.append("WHERE S_OP_Ob_OptometryBasicID = ?  ");

		List<String> params = new ArrayList<String>();
		params.add(optometryBasicPo.getSopoboptometrybasicid());

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}
	
	public int getOptometryCount2(OptometryPo optometryPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT COUNT(S_OP_OY_OptometryID) ");
		buffer.append("FROM S_OP_Optometry ");
		buffer.append("WHERE S_OP_OY_OptometryID = ?  ");

		List<String> params = new ArrayList<String>();
		params.add(optometryPo.getSopoyoptometryid());

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}
	
	public void optometryUpdate(OptometryPo optometryPo){
		StringBuffer buffer = new StringBuffer();
		buffer.append("update  S_OP_Optometry ");
		buffer.append("set S_OP_OY_Flag=?,S_OP_OY_RecipeUpdateTime=getDate(),S_OP_OY_Updateuserid=? ");
		buffer.append("WHERE S_OP_OY_OptometryID = ?  ");

		List<String> params = new ArrayList<String>();
		params.add(optometryPo.getSopoyflag());
		params.add(optometryPo.getSopoypersonid());
		params.add(optometryPo.getSopoyoptometryid());

		this.getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	public OptometryPo getOptometryPo(String optometryBasicID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT TOP 1 S_OP_OY_OptometryID as sopoyoptometryid,S_OP_OY_CustomerID as sopoycustomerid FROM S_OP_Optometry WHERE S_OP_OY_OptometryBasicID=? ");
		buffer.append("ORDER BY S_OP_OY_Time DESC");

		List<String> params = new ArrayList<String>();
		params.add(optometryBasicID);

		return (OptometryPo) this.queryForObject(buffer.toString(), params.toArray(), OptometryPo.class);
	}
	/*
	 * 避免生成不同的BASICID.
	 */
	public OptometryBasicPo getOptometryBasicPo1(String optometryID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT TOP 1 S_OP_OY_OptometryBasicID as sopoboptometrybasicid FROM S_OP_Optometry WHERE S_OP_OY_OptometryID=? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		return (OptometryBasicPo) this.queryForObject(buffer.toString(), params
				.toArray(), OptometryBasicPo.class);
	}
	
	public void updateOptoTime(String optometryBasicID){
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_OptometryBasic set S_OP_OB_MedicalEndTime=getdate() where S_OP_OB_OptometryBasicID=?");

		List<String> params = new ArrayList<String>();
		params.add(optometryBasicID);

		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void updateOptoTime1(String optometryID){
		StringBuffer sb = new StringBuffer();
		sb.append("update S_OP_Optometry set S_OP_OY_time=getdate() where S_OP_Oy_OptometryID=?");

		List<String> params = new ArrayList<String>();
		params.add(optometryID);

		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public OptometryPo selectOptometryPo(String optometryid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 ");
		
		buffer.append(" S_OP_OY_OptometryID          as sopoyoptometryid       ");
		buffer.append(",S_OP_OY_OptometryBasicID     as sopoyoptometrybasicid  ");
		buffer.append(",S_OP_OY_ShopCode             as sopoyshopcode          ");
		buffer.append(",S_OP_OY_CustomerID           as sopoycustomerid        ");
		buffer.append(",S_OP_OY_PersonID             as sopoypersonid          ");
		buffer.append(",S_OP_OY_Time                 as sopoytime              ");
		buffer.append(",S_OP_OY_RecipeUpdateTime     as sopoyrecipeupdatetime  ");
		buffer.append(",S_OP_OY_Flag                 as sopoyflag              ");
		buffer.append(",S_OP_OY_Updateuserid         as sopoyupdateuserid      ");
		buffer.append(",S_OP_OY_isInternal           as sopoyisinternal        ");
		buffer.append(",S_OP_OY_OneOrMany            as sopoyoneormany         ");
		buffer.append("FROM S_OP_Optometry ");
		buffer.append("WHERE S_OP_OY_OptometryID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(optometryid);
		
		return (OptometryPo) this.queryForObject(buffer.toString(), params
				.toArray(), OptometryPo.class);
	}

}
