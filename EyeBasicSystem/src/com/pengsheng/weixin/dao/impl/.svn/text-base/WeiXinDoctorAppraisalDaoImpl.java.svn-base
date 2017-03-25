package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDoctorAppraisalDao;
import com.pengsheng.weixin.dao.WeiXinDoctorDao;
import com.pengsheng.weixin.persistence.WeiXinDoctorAppraisalPo;
import com.pengsheng.weixin.persistence.WeiXinDoctorPo;

public class WeiXinDoctorAppraisalDaoImpl extends BaseJdbcDaoSupport implements WeiXinDoctorAppraisalDao{

	public void insertWeiXinDoctorAppraisalPo(WeiXinDoctorAppraisalPo po) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("INSERT INTO W_DoctorAppraisal ");
		buffer.append("            (W_DA_ID, ");
		buffer.append("             W_DA_InspectionID, ");
		buffer.append("             W_DA_CustomerID, ");		
		buffer.append("             W_DA_DoctorID, ");
		buffer.append("             W_DA_Manyidu, ");
		buffer.append("             W_DA_Content, ");
		buffer.append("             W_DA_CreateTime) ");
		buffer.append("VALUES      ( '"+ this.uuid.generate() +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdainspectionid()) +"', ");		
		buffer.append("              '"+ Utility.getName(po.getWdacustomerid()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdadoctorid()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdamanyidu()) +"', ");
		buffer.append("              '"+ Utility.getName(po.getWdacontent()) +"', ");
		buffer.append("              getdate() ");
		buffer.append("             ) ");
		
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 获得某检查结论评价数量
	 * @param inspectionID
	 */
	public int selectWeiXinDoctorAppraisalisOk(String inspectionID){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(W_DA_ID) ");

		buffer.append("FROM   W_DoctorAppraisal ");

		buffer.append("WHERE  W_DA_InspectionID = ? ");
		params.add(Utility.getName(inspectionID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获得某验光师论评价数量
	 * @param inspectionID
	 */
	public int selectWeiXinDoctorAppraisalCount(String doctorID){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(W_DA_ID) ");

		buffer.append("FROM   W_DoctorAppraisal ");

		buffer.append("WHERE  W_DA_DoctorID = ? ");
		params.add(Utility.getName(doctorID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 获取验光师好评率
	 * @param  doctorID
	 * @return
	 */
	public int selectWeiXinDoctorAppraisalHaopinglv(String doctorID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(W_DA_ID) ");
		buffer.append("FROM   W_DoctorAppraisal ");
		buffer.append("WHERE  1=1 AND W_DA_DoctorID = ? ");
		params.add(Utility.getName(doctorID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<WeiXinDoctorAppraisalPo> selectWeiXinDoctorAppraisalList(
			String doctorID, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by W_DA_ID) as rowNum, ");
		buffer.append("             W_DA_ID      			AS wdaid, ");
		buffer.append("             W_DA_InspectionID    	AS wdainspectionid, ");
		buffer.append("             W_DA_CustomerID   		AS wdacustomerid, ");
		buffer.append("             W_DA_DoctorID   		AS wdadoctorid, ");
		buffer.append("				S_ME_CI_Name			as wdacustomername, ");
		buffer.append("             W_DA_Manyidu 			AS wdamanyidu, ");
		buffer.append("             W_DA_Content    		AS wdacontent, ");
		buffer.append("             W_DA_CreateTime    		AS wdacreatetime ");
		
		buffer.append("FROM   W_DoctorAppraisal ");
		buffer.append(" left join S_ME_CustomerInfo on W_DoctorAppraisal.W_DA_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("WHERE  1=1 AND W_DA_DoctorID = ? ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		
		buffer.append(" order by W_DA_CreateTime desc ");
		buffer.append(" set rowcount 0");
		
		params.add(Utility.getName(doctorID));
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinDoctorAppraisalPo.class);
	}
	
	public List<WeiXinDoctorAppraisalPo> selectWeiXinDoctorAppraisalList(
			String doctorID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT	    ");
		buffer.append("             W_DA_ID      			AS wdaid, ");
		buffer.append("             W_DA_InspectionID    	AS wdainspectionid, ");
		buffer.append("             W_DA_CustomerID   		AS wdacustomerid, ");
		buffer.append("             W_DA_DoctorID   		AS wdadoctorid, ");
		buffer.append("				S_ME_CI_Name			as wdacustomername, ");
		buffer.append("             W_DA_Manyidu 			AS wdamanyidu, ");
		buffer.append("             W_DA_Content    		AS wdacontent, ");
		buffer.append("             W_DA_CreateTime    		AS wdacreatetime ");
		
		buffer.append("FROM   W_DoctorAppraisal ");
		buffer.append(" left join S_ME_CustomerInfo on W_DoctorAppraisal.W_DA_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("WHERE  1=1 AND W_DA_DoctorID = ? ");
		
		buffer.append(" order by W_DA_CreateTime desc ");
		
		params.add(Utility.getName(doctorID));
		
		return queryForObjectList(buffer.toString(), params.toArray(), WeiXinDoctorAppraisalPo.class);
	}
}
