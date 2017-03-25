package com.pengsheng.eims.frame.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.frame.dao.LoginDao;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class LoginDaoImpl extends BaseJdbcDaoSupport implements LoginDao {

	/**
	 * 正常登录
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getPerson(PersonInfoPo personInfo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  uview_Person.ID as id ");
		buffer.append(",password ");
		buffer.append(",personName ");
		buffer.append(",SYS_PD_DepartmentID as departmentID ");
		buffer.append(",B_Departments.B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append(",userState ");
		buffer.append(",phone ");
		buffer.append(",sex ");
		buffer.append(",email ");
		buffer.append(",address ");
		buffer.append(",cardID ");
		buffer.append(",checkMac ");
		buffer.append(",F_PD_Discount as personDiscount");
		buffer.append(",SYS_PersonRoles.roleid as roleid,roleName ");
		buffer.append(",B_Departments.B_DP_Type as departmenttype ");
		buffer.append(",(select count(SYS_PD_DepartmentID) from SYS_PersonDepartments where SYS_PD_PersonID=?) as departmentCount ");
		buffer.append(",B_DP_WhichRetail as whichretail ");
		buffer.append(",isnull(B_DP_SalesType,'') 	as dptsalestype ");
		buffer.append(",personcompanyid 			as personcompanyid ");
		buffer.append(",F_CN_Name 					as personcompanyname ");
		buffer.append(",F_CN_MasterOrVice 			as personcompanytype ");
		buffer.append(",F_CN_RegionID 				as personcompanyregionid ");
		buffer.append(",PersonJobType 				as personjobtype ");
		buffer.append(",isnull(F_CN_CompanyType,'1') 				as companynature ");
		buffer.append(",isnull(SYS_P_SupplierID,'')	as syspsupplierid ");
		buffer.append(",B_SP_SupplierName			as syspsuppliername ");
		buffer.append(",B_SP_CategoryID				as syspsuppliercategoryid ");
		//buffer.append(",isnull(B_DP_LinkHisFlag,'0') 			    as bdplinkhisflag ");
		//buffer.append(",isnull(B_DP_LinkHis,'')  		            as bdplinkhis ");
		//buffer.append(",isnull(B_DP_NotPayFeeForm,'') 				as bdpnotpayfeeform ");
		//buffer.append(",isnull(B_DP_ChargingItemID,'') 			    as bdpchargingitemid ");
		//buffer.append(",isnull(B_H_HisUrl,'') 			            AS bdplinkhisurl ");
		//buffer.append(",isnull(B_DP_ReadCardForm,'') 			    AS bdpreadcardform ");
		
		buffer.append(" FROM uview_Person ");
		
		buffer.append(" inner join SYS_PersonDepartments on SYS_PD_PersonID=uview_Person.ID ");
		buffer.append(" inner join B_Departments on B_Departments.B_DP_DepartmentID=SYS_PD_DepartmentID ");
		buffer.append(" left join SYS_PersonRoles on personid=uview_Person.id");
		buffer.append(" left join SYS_Roles on SYS_PersonRoles.roleid=SYS_Roles.roleid");
		buffer.append(" left join F_CompanyName on F_CN_ID = personcompanyid ");
		buffer.append(" left join J_Region on J_R_ID = F_CN_RegionID ");
		buffer.append(" left join F_PersonDiscount on F_PD_PersonID = uview_Person.ID ");
		buffer.append(" left join B_Supplier on B_SP_ID = SYS_P_SupplierID ");
		//buffer.append(" left join B_His on B_DP_LinkHis = B_H_ID ");
		
		buffer.append(" where uview_Person.ID = ? and password = ? and isInvocation = '0' ");
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(personInfo.getId()))){
			params.add(Utility.getName(personInfo.getId()));
		}
		
		if(!"".equals(Utility.getName(personInfo.getId()))){
			params.add(Utility.getName(personInfo.getId()));
		}
		
		if(!"".equals(Utility.getName(personInfo.getPassword()))){
			params.add(Utility.getName(personInfo.getPassword()));
		}
		
		return (PersonInfoPo) queryForObject(buffer.toString(), params.toArray(), PersonInfoPo.class);

	}
	
	/**
	 * 员工刷卡登录
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo cardLogin(PersonInfoPo personInfoPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>(); 
	
		buffer.append("SELECT top 1  uview_Person.ID as id ");
		buffer.append(",password ");
		buffer.append(",personName ");
		buffer.append(",SYS_PD_DepartmentID as departmentID ");
		buffer.append(",B_Departments.B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append(",userState ");
		buffer.append(",phone ");
		buffer.append(",sex ");
		buffer.append(",email ");
		buffer.append(",address ");
		buffer.append(",cardID ");
		buffer.append(",checkMac ");
		buffer.append(",F_PD_Discount as personDiscount");
		buffer.append(",SYS_PersonRoles.roleid as roleid,roleName ");
		buffer.append(",B_Departments.B_DP_Type as departmenttype ");
		buffer.append(",(select count(SYS_PD_DepartmentID) from SYS_PersonDepartments where SYS_PD_PersonID=uview_Person.ID) as departmentCount ");
		buffer.append(",B_DP_WhichRetail as whichretail ");
		buffer.append(",isnull(B_DP_SalesType,'') 	as dptsalestype ");
		buffer.append(",personcompanyid 			as personcompanyid ");
		buffer.append(",F_CN_Name 					as personcompanyname ");
		buffer.append(",F_CN_MasterOrVice 			as personcompanytype ");
		buffer.append(",F_CN_RegionID 				as personcompanyregionid ");
		buffer.append(",PersonJobType 				as personjobtype ");
		buffer.append(",isnull(F_CN_CompanyType,'1') 				as companynature ");
		buffer.append(",isnull(SYS_P_SupplierID,'')	as syspsupplierid ");
		buffer.append(",B_SP_SupplierName			as syspsuppliername ");
		buffer.append(",B_SP_CategoryID				as syspsuppliercategoryid ");
		buffer.append(",isnull(B_DP_LinkHisFlag,'0') 			    as bdplinkhisflag ");
		buffer.append(",isnull(B_DP_LinkHis,'')  		            as bdplinkhis ");
		buffer.append(",isnull(B_DP_NotPayFeeForm,'') 				as bdpnotpayfeeform ");
		buffer.append(",isnull(B_DP_ChargingItemID,'') 			    as bdpchargingitemid ");
		buffer.append(",isnull(B_H_HisUrl,'') 			            AS bdplinkhisurl ");
		buffer.append(",isnull(B_DP_ReadCardForm,'') 			    AS bdpreadcardform ");
		
		buffer.append(" FROM uview_Person ");
		buffer.append(" inner join SYS_PersonDepartments on SYS_PD_PersonID=uview_Person.ID ");
		buffer.append(" inner join B_Departments on B_Departments.B_DP_DepartmentID=SYS_PD_DepartmentID ");
		buffer.append(" left join SYS_PersonRoles on personid=uview_Person.id");
		buffer.append(" left join SYS_Roles on SYS_PersonRoles.roleid=SYS_Roles.roleid");
		buffer.append(" left join F_CompanyName on F_CN_ID = personcompanyid ");
		buffer.append(" left join F_PersonDiscount on F_PD_PersonID = uview_Person.ID ");
		buffer.append(" left join B_Supplier on B_SP_ID = SYS_P_SupplierID ");
		buffer.append(" left join J_Region on J_R_ID = F_CN_RegionID ");
		buffer.append(" left join B_His on B_DP_LinkHis = B_H_ID ");
		
		buffer.append(" where cardID = ? and isInvocation = '0' ");
		
		params.add(Utility.getName(personInfoPo.getCardid()));
		
		return (PersonInfoPo) queryForObject(buffer.toString() , params.toArray() , PersonInfoPo.class);
	}
	
	public void pswdUpdate(PersonInfoPo personInfoPo){
		StringBuffer sb = new StringBuffer();
		sb.append("update sys_personinfo set password=? where id=?");
		List<String> params = new ArrayList<String>();
		params.add(personInfoPo.getPassword());
		params.add(personInfoPo.getId());
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 根据当前登录人员查询所在部门
	 * @param personInfo
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByPerson(PersonInfoPo personInfo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname,B_DP_Type as bdptype,B_DP_IsClosed as bdpisclosed ");
		buffer.append("  from SYS_PersonDepartments ");
		buffer.append("inner join B_Departments on SYS_PD_DepartmentID=B_DP_DepartmentID ");
		buffer.append("inner join uview_Person on SYS_PD_PersonID = ID ");
		buffer.append("  where SYS_PD_PersonID = ? and personcompanyid = ? ");		
		
		params.add(Utility.getName(personInfo.getId()));
		params.add(Utility.getName(personInfo.getPersoncompanyid()));

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);

	}
	
	/**
	 * 根据当前登录人员查询所在部门(控制门店数量)
	 * @param personInfo
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByPersonOther(PersonInfoPo personInfo,String shopCount) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top ");
		buffer.append(shopCount);
		buffer.append(" B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname,B_DP_Type as bdptype,B_DP_IsClosed as bdpisclosed ");
		buffer.append("  from SYS_PersonDepartments inner join B_Departments on SYS_PD_DepartmentID=B_DP_DepartmentID ");
		buffer.append("  where SYS_PD_PersonID=? and isnull(B_DP_Type,'') = '1' ");
		buffer.append(" union all ");
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname,B_DP_Type as bdptype,B_DP_IsClosed as bdpisclosed ");
		buffer.append("  from SYS_PersonDepartments inner join B_Departments on SYS_PD_DepartmentID=B_DP_DepartmentID ");
		buffer.append("  where SYS_PD_PersonID=? and isnull(B_DP_Type,'') <> '1' ");	
		
		params.add(Utility.getName(personInfo.getId()));
		params.add(Utility.getName(personInfo.getId()));

		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 查询公司信息
	 * 
	 * @return
	 */
	public CompanyNamePo getCompanyInfo(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 F_CN_Name as fcnName,F_CN_Leftnum as fcnleftnum,F_CN_LoginShow as fcnLoginShowSystem,F_CN_ChangeDptShow as fcnDepartmentShowSystem,F_CN_LoginShowFooter as fcnLoginShowFooter ");
		buffer.append(",F_CN_TakeAddress 		as fcntakeaddress ");
		buffer.append(",F_CN_TakePerson 		as fcntakeperson ");
		buffer.append(",F_CN_TakePhone 			as fcntakephone ");
		buffer.append(",F_CN_TakePortraiture 	as fcntakeportraiture ");
		buffer.append("from F_CompanyName where 1=1 ");
		
		if ("1".equals(Utility.getName(po.getFcnShowSystem()))){
			buffer.append(" and F_CN_Show='1' ");
		}
		if ("1".equals(Utility.getName(po.getFcnLoginShowSystem()))){
			buffer.append(" and F_CN_LoginShow='1' ");
		}
		if ("1".equals(Utility.getName(po.getFcnDepartmentShowSystem()))){
			buffer.append(" and F_CN_ChangeDptShow='1' ");
		}
		if ("1".equals(Utility.getName(po.getFcnLoginShowFooter()))){
			buffer.append(" and F_CN_LoginShowFooter='1' ");
		}
		if (!"".equals(Utility.getName(po.getFcnId()))){
			buffer.append(" and F_CN_ID = ? ");
			params.add(Utility.getName(po.getFcnId()));
		}
		
		return (CompanyNamePo) queryForObject(buffer.toString() , params.toArray(), CompanyNamePo.class);
	}
	
	/**
	 * 查询公司logo和背景图
	 * 
	 * @return
	 */
	public CompanyNamePo getCompanyPic(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(F_CL_Url,'') as fcnLogoPath,isnull(F_CL_BackGround,'') as fcnbackGroundPath,isnull(F_CL_DepGround,'') as fcndepgroundPath from F_CompanyLogo where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getFcnId()))){
			buffer.append(" and F_CL_CompanyID = ? ");
			params.add(Utility.getName(po.getFcnId()));
		}
		return (CompanyNamePo) queryForObject(buffer.toString() , params.toArray(), CompanyNamePo.class);
	}
	
	/**
	 * 取得打折人信息
	 * @param personInfo
	 * @return
	 */
	public PersonInfoPo getDiscountPerson(PersonInfoPo personInfo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  SYS_PersonInfo.ID ");
		buffer.append(",password ");
		buffer.append(",personName ");
		buffer.append(",SYS_PD_DepartmentID as departmentID ");
		buffer.append(",B_Departments.B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append(",userState ");
		buffer.append(",phone ");
		buffer.append(",sex ");
		buffer.append(",email ");
		buffer.append(",address ");
		buffer.append(",cardID ");
		buffer.append(",roleName ");
		buffer.append(",B_Departments.B_DP_Type as departmenttype ");
		buffer.append(" FROM SYS_PersonInfo ");
		buffer.append(" inner join SYS_PersonDepartments on SYS_PD_PersonID=SYS_PersonInfo.ID ");
		buffer.append(" inner join B_Departments on B_Departments.B_DP_DepartmentID=SYS_PD_DepartmentID ");
		buffer.append(" left join SYS_PersonRoles on personid=SYS_PersonInfo.id");
		buffer.append(" left join SYS_Roles on SYS_PersonRoles.roleid=SYS_Roles.roleid");
		buffer.append(" where isInvocation = '0' ");

		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(personInfo.getId()))){
			buffer.append(" and SYS_PersonInfo.ID = ? ");
			params.add(Utility.getName(personInfo.getId()));
		}
		
		if(!"".equals(Utility.getName(personInfo.getPassword()))){
			buffer.append(" and password = ? ");
			params.add(Utility.getName(personInfo.getPassword()));
		}
		
		if(!"".equals(Utility.getName(personInfo.getCardid()))){
			buffer.append(" and cardid = ? ");
			params.add(Utility.getName(personInfo.getCardid()));
		}

		if(!"".equals(Utility.getName(personInfo.getDepartmentID()))){
			buffer.append(" and SYS_PD_DepartmentID = ? ");
			params.add(Utility.getName(personInfo.getDepartmentID()));
		}
		
		return (PersonInfoPo) queryForObject(buffer.toString(), params.toArray(), PersonInfoPo.class);

	}
	
	/**
	 * 更新试用期限
	 */
	public void updateSysLicence(String date){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if (!date.equals("")){
			sb.append("update top (1) F_SystemParameter set F_SP_TrialLimit = ? ");
			params.add(date);
		}else{
			sb.append("update top (1) F_SystemParameter set F_SP_TrialLimit = NULL ");
		}

		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 根据部门ID查询门店销售方式
	 */
	public String getShopCodeSalesForm(String dptid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(B_DP_SalesType,'1') from B_Departments where B_DP_DepartmentID = ? ");
		params.add(dptid);

		return (String) getJdbcTemplate().queryForObject(buffer.toString(),params.toArray(),String.class);
	}
	
	/**
	 * 获取所有MAC地址对应的公司列表
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameByMacList(CompanyNamePo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT SYS_MAC_Key AS fcnmac, ");
		buffer.append("       (select F_CN_Name from dbo.F_CompanyName where F_CN_LoginShow = '1' and F_CN_ID = B_DP_CompanysID)  AS fcnName ");
		buffer.append("FROM   dbo.F_CompanyName ");
		buffer.append("       INNER JOIN dbo.B_Departments ");
		buffer.append("         ON B_DP_CompanysID = F_CN_ID ");
		buffer.append("       INNER JOIN SYS_Mac ");
		buffer.append("         ON SYS_MAC_Departmentid = B_DP_DepartmentID ");

		return queryForObjectList(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
}
