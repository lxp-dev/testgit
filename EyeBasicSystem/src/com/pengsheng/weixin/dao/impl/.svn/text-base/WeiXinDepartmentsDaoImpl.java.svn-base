package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDepartmentsDao;
import com.pengsheng.weixin.persistence.WeiXinDepartmentPicPo;

public class WeiXinDepartmentsDaoImpl extends BaseJdbcDaoSupport implements
		WeiXinDepartmentsDao {
	
	/**
	 * 条件查询部门信息
	 */

	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as bdpdepartmentname ");
		buffer.append(",B_DP_Phone as bdpphone ");
		buffer.append(",B_DP_DepartmentName as bdpregname ");
		buffer.append(",B_DP_Address as bdpaddress,B_DP_LocationX as bdplocationx,B_DP_LocationY as  bdplocationy,isnull(B_DP_PicUrl,'') as bdppicurl ");
		buffer.append(",B_DP_IsSee as bdpissee,B_DP_IsOptometryAppointment as bdpisoptometryappointment ");
		buffer.append("FROM B_Departments ");
		buffer.append("WHERE 1 = 1 and B_DP_DepartmentID= '"+ Utility.getName(departmentsPo.getBdpdepartmentid()) +"' and B_DP_Type=1 and  B_DP_IsClosed='0'");

		return (DepartmentsPo) queryForObject(buffer.toString(), null, DepartmentsPo.class);
	}

	/**
	 * 更新部门
	 */
	public void updateDepartment(DepartmentsPo departmentsPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE B_Departments set ");
		buffer.append("B_DP_Phone=?, ");
		params.add(Utility.getName(departmentsPo.getBdpphone()));
		buffer.append("B_DP_Address=?, ");
		params.add(Utility.getName(departmentsPo.getBdpaddress()));	
		
		buffer.append("B_DP_PicUrl=?, ");
		params.add(Utility.getName(departmentsPo.getBdppicurl()));
		
		buffer.append("B_DP_LocationX=?, ");
		buffer.append("B_DP_LocationY=?, ");
		buffer.append("B_DP_IsSee=?, ");
		buffer.append("B_DP_IsOptometryAppointment=? ");
		
		buffer.append("where B_DP_DepartmentID =? ");
		
		params.add(Utility.getName(departmentsPo.getBdplocationx()));
		params.add(Utility.getName(departmentsPo.getBdplocationy()));
		params.add(Utility.getName(departmentsPo.getBdpissee()));
		params.add(Utility.getName(departmentsPo.getBdpisoptometryappointment()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询部门的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getDepartmentCount(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_DP_DepartmentID) ");
		buffer.append("  from B_Departments where B_DP_Type=1 and  B_DP_IsClosed='0'");
		
		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append("and B_DP_DepartmentID = ? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append("and B_DP_DepartmentName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询部门列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from ( ");
		
		buffer.append("select ROW_NUMBER() Over(order by B_DP_DepartmentID) as rowNum,B_DP_DepartmentID as bdpdepartmentid,");
		buffer.append("       B_DP_DepartmentName as bdpdepartmentname,B_DP_Phone as bdpphone,B_DP_Address as bdpaddress,B_DP_DepartmentName as bdpregname ");
		buffer.append("       ,isnull(B_DP_IsSee,'0') as bdpissee,isnull(B_DP_IsOptometryAppointment,'0') as bdpisoptometryappointment ");
		buffer.append("  from B_Departments where 1=1 and B_DP_Type=1 and  B_DP_IsClosed='0'");

		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append("and B_DP_DepartmentID = ? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append("and B_DP_DepartmentName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		
		if (!"".equals(Utility.getName(po.getBdpissee()))){
			buffer.append(" and isnull(B_DP_IsSee,'0')=? ");
			params.add(Utility.getName(po.getBdpissee()));
		}
		
		if (!"".equals(Utility.getName(po.getBdpisoptometryappointment()))){
			buffer.append(" and isnull(B_DP_IsOptometryAppointment,'0')=? ");
			params.add(Utility.getName(po.getBdpisoptometryappointment()));
		}
		
		buffer.append(" ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as bdpdepartmentname ");
		buffer.append(",B_DP_Phone as bdpphone ");
		buffer.append(",B_DP_Address as bdpaddress ");
		buffer.append(",isnull(B_DP_PicUrl,'') as bdppicurl ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_TakeGlassDate as bdptakeglassdate ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append(",isnull(B_DP_LocationX,'0') as bdplocationx ");
		buffer.append(",isnull(B_DP_LocationY,'0') as bdplocationy ");
		buffer.append("FROM B_Departments ");
		buffer.append(" where 1=1 and B_DP_Type=1 and  B_DP_IsClosed='0'");
		
		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))){
			buffer.append(" and B_DP_DepartmentID=? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}		
		
		if (!"".equals(Utility.getName(po.getBdpdepartmentname()))){
			buffer.append("and B_DP_DepartmentName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdpdepartmentname()));
		}
		
		if (!"".equals(Utility.getName(po.getBdpissee()))){
			buffer.append(" and isnull(B_DP_IsSee,'0')=? ");
			params.add(Utility.getName(po.getBdpissee()));
		}
		
		if (!"".equals(Utility.getName(po.getBdpisoptometryappointment()))){
			buffer.append(" and isnull(B_DP_IsOptometryAppointment,'0')=? ");
			params.add(Utility.getName(po.getBdpisoptometryappointment()));
		}
		
		buffer.append(" order by B_DP_DepartmentID");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	/**
	 * 更新部门是否微信可见
	 * 
	 * @param departmentsPo
	 */
	public void updateSeeDepartment(DepartmentsPo departmentsPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Departments set B_DP_IsSee=? where B_DP_DepartmentID=? ");
				
		params.add(Utility.getName(departmentsPo.getBdpissee()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新门店是否为微信可预约的状态
	 * 
	 * @param departmentsPo
	 */
	public void updateOptometryAppointmentDepartment(DepartmentsPo departmentsPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Departments set B_DP_IsOptometryAppointment=? where B_DP_DepartmentID=? ");
				
		params.add(Utility.getName(departmentsPo.getBdpisoptometryappointment()));
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取门店实景图List
	 * 
	 * @param departmentID
	 */
	public List<WeiXinDepartmentPicPo> getDepartmentPicList(String departmentID) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT id    AS id, ");
		sb.append("       departmentID    AS departmentID, ");
		sb.append("       isnull(picUrl,'') AS picUrl ");
		sb.append("FROM   W_DepartmentPic ");		
		sb.append("WHERE  departmentID = '"+ departmentID +"' ");
		
		return queryForObjectList(sb.toString(), null, WeiXinDepartmentPicPo.class);
	}
	
	/**
	 * 上传门店实景图
	 * 
	 * @param WeiXinDepartmentPicPo
	 */
	public void insertWeiXinDepartmentPic(WeiXinDepartmentPicPo weiXinDepartmentPicPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert W_DepartmentPic(id,departmentID,picUrl) values(?,?,?)");
				
		params.add(this.uuid.generate());
		params.add(weiXinDepartmentPicPo.getDepartmentID());
		params.add(weiXinDepartmentPicPo.getPicUrl());
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除店实景图
	 * 
	 * @param WeiXinDepartmentPicPo
	 */
	public void deleteWeiXinDepartmentPic(String departmentID){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("delete from W_DepartmentPic where departmentID='"+ departmentID +"' ");
		getJdbcTemplate().update(buffer.toString());
		
	}
}
