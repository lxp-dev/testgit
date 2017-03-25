package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.OptometryInformationDao;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class OptometryInformationDaoImpl extends BaseJdbcDaoSupport implements
		OptometryInformationDao {

	/**
	 * 得到验光基表对象
	 */
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

	/**
	 *  取验光基表下有几个验光病历
	 */
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

	/**
	 * 得到顾客所有验光基表明细
	 */
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

	/**
	 * 得到顾客验光基表
	 */
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

	/**
	 * 得到所有顾客验光病历,验光基表对应的
	 */
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

}
