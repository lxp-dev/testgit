package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.system.dao.CompanyNameDao;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author 王磊
 * 
 */
public class CompanyNameDaoImpl extends BaseJdbcDaoSupport implements CompanyNameDao {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 查询公司的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getCompanyNameCount(CompanyNamePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(F_CN_ID) ");
		buffer.append("from F_CompanyName where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getFcnId()))){
			buffer.append("and F_CN_ID = ? ");
			params.add(Utility.getName(po.getFcnId()));
		}
		if (!"".equals(Utility.getName(po.getFcncompanyid()))){
			buffer.append("and F_CN_ID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcncompanyid()));
		}
		if (!"".equals(Utility.getName(po.getFcnName()))){
			buffer.append("and F_CN_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcnName()));
		}
		if (!"".equals(Utility.getName(po.getFcnregionid()))){
			buffer.append("and F_CN_RegionID = ? ");
			params.add(Utility.getName(po.getFcnregionid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询公司列表
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameList(CompanyNamePo po,int start,int size){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from ( ");
		
		buffer.append("select ROW_NUMBER() Over(order by F_CN_ID) as rowNum ");
		buffer.append(",F_CN_ID 				as fcnId ");
		buffer.append(",F_CN_Name 				as fcnName ");
		buffer.append(",F_CN_Phone 				as fcnPhone ");
		buffer.append(",F_CN_LegalPerson 		as fcnlegalperson ");
		buffer.append(",F_CN_LegalPersonPhone 	as fcnlegalpersonphone ");
		buffer.append(",F_CN_MasterOrVice 		as fcnmasterorvice ");
		buffer.append(",J_R_Name 				as fcnjrname ");
		buffer.append("from F_CompanyName ");
		buffer.append("left join J_Region on F_CN_RegionID = J_R_ID ");
		
		buffer.append("where 1=1 ");
		if (!"".equals(Utility.getName(po.getFcnId()))){
			buffer.append("and F_CN_ID = ? ");
			params.add(Utility.getName(po.getFcnId()));
		}
		if (!"".equals(Utility.getName(po.getFcncompanyid()))){
			buffer.append("and F_CN_ID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcncompanyid()));
		}
		if (!"".equals(Utility.getName(po.getFcnName()))){
			buffer.append("and F_CN_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcnName()));
		}
		if (!"".equals(Utility.getName(po.getFcnregionid()))){
			buffer.append("and F_CN_RegionID = ? ");
			params.add(Utility.getName(po.getFcnregionid()));
		}
		
		buffer.append(" ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
	
	public void insertCompanyName(CompanyNamePo companyNamePo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		String companyID = this.uuid.generate();

		buffer.append("insert into F_CompanyName (F_CN_ID , ");
		buffer.append("F_CN_Name,F_CN_Show,F_CN_Leftnum,F_CN_LoginShow,F_CN_ChangeDptShow,F_CN_LoginShowFooter,F_CN_MasterOrVice,F_CN_Phone ");
		buffer.append(",F_CN_LegalPerson,F_CN_LegalPersonPhone,F_CN_ReportShowName,F_CN_CompanyType,F_CN_WholeSalePrice ");
		buffer.append(",F_CN_RegionID ");
		buffer.append(",F_CN_TakeAddress ");
		buffer.append(",F_CN_TakePerson ");
		buffer.append(",F_CN_TakePhone ");
		buffer.append(",F_CN_TakePortraiture ");
		buffer.append(") values ");
		buffer.append("(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )"); 
		
		params.add(companyID);
		params.add(Utility.getName(companyNamePo.getFcnName()));
		params.add(Utility.getName(companyNamePo.getFcnShowSystem()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnleftnum()));
		params.add(Utility.getName(companyNamePo.getFcnLoginShowSystem()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnDepartmentShowSystem()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnLoginShowFooter()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnmasterorvice()));
		params.add(Utility.getName(companyNamePo.getFcnPhone()));
		params.add(Utility.getName(companyNamePo.getFcnlegalperson()));
		params.add(Utility.getName(companyNamePo.getFcnlegalpersonphone()));
		params.add(Utility.getName(companyNamePo.getFcnreportshowname()));		
		params.add(Utility.getName(companyNamePo.getFcncompanytype()));
		params.add(Utility.getName(companyNamePo.getFcnwholesaleprice()));
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		params.add(Utility.getName(companyNamePo.getFcntakeaddress()));
		params.add(Utility.getName(companyNamePo.getFcntakeperson()));
		params.add(Utility.getName(companyNamePo.getFcntakephone()));
		params.add(Utility.getName(companyNamePo.getFcntakeportraiture()));
		
		buffer.append("insert into J_Company_Supplier ( ");
		buffer.append(" J_CS_ID ");
		buffer.append(",J_CS_CompanyID ");
		buffer.append(",J_CS_SupplierID ");
		buffer.append(",J_CS_SupplierAgentID ");
		buffer.append(",J_CS_QC ");
		buffer.append(",J_CS_YF ");
		buffer.append(",J_CS_ZQ ");
		buffer.append(") ");
		buffer.append("select replace(newid(),'-','') , ? , B_SP_LinkSupplierID ,B_SP_ID , '0.00' , '0.00' , '30' from B_SupplierAgent ");
		buffer.append("where 1 = ? ");
		
		params.add(companyID);
		params.add(Utility.getName(companyNamePo.getFcnissyncompanysupplier()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateCompanyName(CompanyNamePo companyNamePo) {

		StringBuffer buffer = new StringBuffer();

		//给SQL语句传值
		List<String> params = new ArrayList<String>();

		buffer.append("update F_CompanyName set ");
		buffer.append(" F_CN_Name = ? ");
		buffer.append(",F_CN_Show = ? ");
		buffer.append(",F_CN_Leftnum = ?,F_CN_LoginShow = ?,F_CN_ChangeDptShow = ?,F_CN_LoginShowFooter = ?,F_CN_MasterOrVice = ?,F_CN_Phone = ? ");
		buffer.append(",F_CN_LegalPerson = ?,F_CN_LegalPersonPhone = ?,F_CN_ReportShowName = ?,F_CN_CompanyType = ?,F_CN_WholeSalePrice = ? ");
		buffer.append(",F_CN_RegionID = ? ");
		buffer.append(",F_CN_TakeAddress = ? ");
		buffer.append(",F_CN_TakePerson = ? ");
		buffer.append(",F_CN_TakePhone = ? ");
		buffer.append(",F_CN_TakePortraiture = ? ");
		buffer.append("where F_CN_ID = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnName()));
		params.add(Utility.getName(companyNamePo.getFcnShowSystem()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnleftnum()));
		params.add(Utility.getName(companyNamePo.getFcnLoginShowSystem()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnDepartmentShowSystem()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnLoginShowFooter()).equals("") ? "0" : "1");
		params.add(Utility.getName(companyNamePo.getFcnmasterorvice()));
		params.add(Utility.getName(companyNamePo.getFcnPhone()));
		params.add(Utility.getName(companyNamePo.getFcnlegalperson()));
		params.add(Utility.getName(companyNamePo.getFcnlegalpersonphone()));
		params.add(Utility.getName(companyNamePo.getFcnreportshowname()));		
		params.add(Utility.getName(companyNamePo.getFcncompanytype()));
		params.add(Utility.getName(companyNamePo.getFcnwholesaleprice()));
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		params.add(Utility.getName(companyNamePo.getFcntakeaddress()));
		params.add(Utility.getName(companyNamePo.getFcntakeperson()));
		params.add(Utility.getName(companyNamePo.getFcntakephone()));
		params.add(Utility.getName(companyNamePo.getFcntakeportraiture()));
		
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public CompanyNamePo getCompanyName(CompanyNamePo companyNamePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 F_CN_ID 	as fcnId, "); 
		buffer.append("F_CN_Name 				as fcnName, ");
		buffer.append("F_CN_Show 				as fcnShowSystem, ");
		buffer.append("F_CN_Leftnum 			as fcnleftnum, ");
		buffer.append("F_CN_LoginShow 			as fcnLoginShowSystem, ");
		buffer.append("F_CN_ChangeDptShow 		as fcnDepartmentShowSystem, ");
		buffer.append("F_CN_LoginShowFooter 	as fcnLoginShowFooter, ");
		buffer.append("F_CL_Url 				as fcnLogoPath, ");
		buffer.append("F_CL_BackGround 			as fcnbackGroundPath, ");
		buffer.append("F_CL_DepGround 			as fcndepgroundPath, ");
		buffer.append("F_CN_Phone 				as fcnPhone, ");
		buffer.append("F_CN_LegalPerson 		as fcnlegalperson, ");
		buffer.append("F_CN_LegalPersonPhone 	as fcnlegalpersonphone, ");
		buffer.append("F_CN_ReportShowName 		as fcnreportshowname, ");
		buffer.append("F_CN_MasterOrVice 		as fcnmasterorvice, ");
		buffer.append("F_CN_CompanyType 		as fcncompanytype, ");
		buffer.append("F_CN_WholeSalePrice 		as fcnwholesaleprice, ");
		buffer.append("F_CN_RegionID 			as fcnregionid, ");
		buffer.append("F_CN_TakeAddress 		as fcntakeaddress, ");
		buffer.append("F_CN_TakePerson 			as fcntakeperson, ");
		buffer.append("F_CN_TakePhone 			as fcntakephone, ");
		buffer.append("F_CN_TakePortraiture 	as fcntakeportraiture ");
		buffer.append("from F_CompanyName ");
		buffer.append("left join F_CompanyLogo on F_CL_CompanyID = F_CN_ID ");
		buffer.append("where 1=1 ");
		
		if ("1".equals(Utility.getName(companyNamePo.getFcnShowSystem()))){
			buffer.append(" and F_CN_Show='1' ");
		}
		if ("1".equals(Utility.getName(companyNamePo.getFcnLoginShowSystem()))){
			buffer.append(" and F_CN_LoginShow='1' ");
		}
		if ("1".equals(Utility.getName(companyNamePo.getFcnDepartmentShowSystem()))){
			buffer.append(" and F_CN_ChangeDptShow='1' ");
		}
		if ("1".equals(Utility.getName(companyNamePo.getFcnLoginShowFooter()))){
			buffer.append(" and F_CN_LoginShowFooter='1' ");
		}
		
		if(!"".equals(Utility.getName(companyNamePo.getFcnId()))){
			buffer.append("and F_CN_ID = ? ");
			params.add(Utility.getName(companyNamePo.getFcnId()));
		}
		
		if(!"".equals(Utility.getName(companyNamePo.getFcnmasterorvice()))){
			buffer.append("and F_CN_MasterOrVice = ? ");
			params.add(Utility.getName(companyNamePo.getFcnmasterorvice()));
		}

		return (CompanyNamePo) queryForObject(buffer.toString(), params.toArray(),CompanyNamePo.class);
	}
	
	public void deleteCompanyName(CompanyNamePo companyNamePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from F_CompanyName ");
		buffer.append("where F_CN_ID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		buffer.append("delete from J_Company_Supplier ");
		buffer.append("where J_CS_CompanyID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	public void deleteCompanyLogo(CompanyNamePo companyNamePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from F_CompanyLogo where F_CL_CompanyID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public int selectCompanyDepartmentsCount(CompanyNamePo companyNamePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(*) from B_Departments where B_DP_CompanysID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public void insertCompanyLogo(CompanyNamePo companyNamePo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" insert into F_CompanyLogo(F_CL_ID,F_CL_Url,F_CL_BackGround,F_CL_DepGround,F_CL_Default,F_CL_CompanyID) values (?,?,?,?,'1',?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(companyNamePo.getFcnLogoPath()));
		params.add(Utility.getName(companyNamePo.getFcnbackGroundPath()));
		params.add(Utility.getName(companyNamePo.getFcndepgroundPath()));
		params.add(Utility.getName(companyNamePo.getFcnId()));
		getJdbcTemplate().update(buffer.toString(),params.toArray());
		
	}
	
	/**
	 * 公司使用默认logo或默认背景
	 * @param companyNamePo
	 */
	public void updateCompanyInfo(CompanyNamePo companyNamePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if ("b".equals(Utility.getName(companyNamePo.getFcnflag()))){
			buffer.append(" update F_CompanyLogo set F_CL_BackGround=? ");
			params.add(Utility.getName(companyNamePo.getFcnbackGroundPath()));
		}else if("d".equals(Utility.getName(companyNamePo.getFcnflag()))){
			buffer.append(" update F_CompanyLogo set F_CL_DepGround=? ");
			params.add(Utility.getName(companyNamePo.getFcndepgroundPath()));
		}else{
			buffer.append(" update F_CompanyLogo set F_CL_Url=? ");
			params.add(Utility.getName(companyNamePo.getFcnLogoPath()));
		}
		buffer.append("where F_CL_CompanyID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 查询公司使用logo或背景
	 * @param companyNamePo
	 */
	public CompanyNamePo selectCompanyInfo(CompanyNamePo companyNamePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 isnull(F_CL_Url,'') as fcnLogoPath,isnull(F_CL_BackGround,'') as fcnbackGroundPath from F_CompanyLogo where F_CL_Default='1' ");
		buffer.append("and F_CL_CompanyID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnId()));
		
		return (CompanyNamePo) queryForObject(buffer.toString(),params.toArray(),CompanyNamePo.class);
	}
	
	/**
	 * 获取所有公司加载下拉菜单
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameForSelect(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select "); 
		buffer.append(" F_CN_ID 			as fcnId ");
		buffer.append(",substring(dbo.fn_ChineseToSpell(F_CN_Name),1,1)+F_CN_Name 			as fcnName ");
		buffer.append(",F_CN_MasterOrVice 	as fcnmasterorvice,dbo.ufn_getQcdateByCompany(F_CN_ID) as fcnqcdate ");
		buffer.append("from F_CompanyName where 1=1 ");
		
		if (po != null && !"".equals(Utility.getName(po.getFcnId()))){
			buffer.append(" and F_CN_ID = ? ");
			params.add(Utility.getName(po.getFcnId()));
		}
		
		buffer.append("order by F_CN_MasterOrVice,dbo.fn_ChineseToSpell(F_CN_Name) ");

		return queryForObjectList(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
	
//----------------------------区域维护----------------------------------------
	
	/**
	 * 查询区域的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getRegionCount(CompanyNamePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(J_R_ID) ");
		buffer.append("from J_Region where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getFcnjrid()))){
			buffer.append("and J_R_ID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcnjrid()));
		}
		if (!"".equals(Utility.getName(po.getFcnjrname()))){
			buffer.append("and J_R_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcnjrname()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询区域列表
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionList(CompanyNamePo po,int start,int size){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from ( ");
		
		buffer.append("select ROW_NUMBER() Over(order by J_R_ID) as rowNum ");
		buffer.append(",J_R_ID 					as fcnjrid ");
		buffer.append(",J_R_Name 				as fcnjrname ");
		buffer.append("from J_Region where 1=1 ");

		if (!"".equals(Utility.getName(po.getFcnjrid()))){
			buffer.append("and J_R_ID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcnjrid()));
		}
		if (!"".equals(Utility.getName(po.getFcnjrname()))){
			buffer.append("and J_R_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFcnjrname()));
		}
		
		buffer.append(" ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
	
	public void insertRegion(CompanyNamePo companyNamePo) {

		StringBuffer buffer = new StringBuffer();

		//给SQL语句传值
		List<String> params = new ArrayList<String>();

		buffer.append(" insert into J_Region ");
		buffer.append(" ( ");
		buffer.append("  J_R_ID  ");
		buffer.append(" ,J_R_Name ");
		buffer.append(" ) values ( ");
		buffer.append("  ? ");
		buffer.append(" ,? ");
		buffer.append(" ) "); 
		
		params.add(Utility.getName(companyNamePo.getFcnjrid()));
		params.add(Utility.getName(companyNamePo.getFcnjrname()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateRegion(CompanyNamePo companyNamePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" update J_Region set ");
		buffer.append("  J_R_Name = ? ");
		buffer.append(" where J_R_ID = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnjrname()));
		params.add(Utility.getName(companyNamePo.getFcnjrid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public CompanyNamePo getRegion(CompanyNamePo companyNamePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 ");
		buffer.append(" J_R_ID 					as fcnjrid 		"); 
		buffer.append(",J_R_Name 				as fcnjrname 	");
		buffer.append("from J_Region ");
		buffer.append("where 1=1 ");
		
		buffer.append("and J_R_ID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnjrid()));

		return (CompanyNamePo) queryForObject(buffer.toString(), params.toArray(),CompanyNamePo.class);
	}
	
	public void deleteRegion(CompanyNamePo companyNamePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from J_Region ");
		buffer.append("where 1=1 ");
		buffer.append("and J_R_ID = ? ");
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
	/**
	 * 查询区域列表填装下拉项
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionListForSelect(){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append(" J_R_ID 					as fcnjrid ");
		buffer.append(",J_R_Name 				as fcnjrname ");
		buffer.append("from J_Region ");
		buffer.append("order by J_R_Name ");

		return queryForObjectList(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
	
	
	/**
	 * 获取当前区域下是否配置公司
	 * 
	 * @param po
	 * @return
	 */
	public int getRegionCountForDelete(CompanyNamePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(F_CN_ID) ");
		buffer.append("from F_CompanyName "); 
		buffer.append("where 1=1 ");
		buffer.append("and F_CN_RegionID = ? ");
		
		params.add(Utility.getName(po.getFcnregionid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 公司供货商配置信息加载
	 * 
	 * @param po
	 * @return
	 */
	public List<SupplierPo> getCompanySupplierAgentList(SupplierPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select "); 
		buffer.append(" B_SupplierAgent.B_SP_ID 						as bspid ");
		buffer.append(",B_SupplierAgent.B_SP_SupplierName 				as bspsuppliername ");
		buffer.append(",B_SupplierAgent.B_SP_LinkSupplierID 			as bsplinksupplierid ");
		buffer.append("from B_SupplierAgent ");
		buffer.append("where 1=1 ");
		buffer.append("order by B_SupplierAgent.B_SP_ID,B_SupplierAgent.B_SP_SupplierName ");

		return queryForObjectList(buffer.toString(), params.toArray(), SupplierPo.class);
	}
	
	/**
	 * 公司供货商配置信息新增
	 */
	public void insertCompanyAgent(CompanyNamePo companyNamePo) {

		StringBuffer buffer = new StringBuffer();

		//给SQL语句传值
		List<String> params = new ArrayList<String>();

		buffer.append(" insert into J_Company_Supplier ( ");
		buffer.append(" J_CS_ID, ");
		buffer.append(" J_CS_CompanyID, ");
		buffer.append(" J_CS_SupplierID, ");
		buffer.append(" J_CS_SupplierAgentID ");
		buffer.append(" ) values ( ");
		buffer.append(" ? , ? , ? , ? ) "); 
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(companyNamePo.getFcnjcscompanyid()));
		params.add(Utility.getName(companyNamePo.getFcnjcssupplierid()));
		params.add(Utility.getName(companyNamePo.getFcnjcssupplieragentid()));
		
		buffer.append(" delete from B_SupplierOpening ");
		buffer.append(" where 1=1 ");
		buffer.append("   and B_SP_CompanyID = ? ");
		buffer.append("   and B_SP_SupplierID = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnjcscompanyid()));
		params.add(Utility.getName(companyNamePo.getFcnjcssupplieragentid()));
		
		buffer.append(" insert into B_SupplierOpening ( ");
		buffer.append(" B_SP_CompanyID, ");
		buffer.append(" B_SP_SupplierID, ");
		buffer.append(" B_SP_StartPrice, ");
		buffer.append(" B_SP_StartPayment, ");
		buffer.append(" B_SP_SupplierAccountDate ");
		buffer.append(" ) values ( ");
		buffer.append(" ? , ? , ? , ? , ? ) "); 
		
		params.add(Utility.getName(companyNamePo.getFcnjcscompanyid()));
		params.add(Utility.getName(companyNamePo.getFcnjcssupplieragentid()));
		params.add("".equals(Utility.getName(companyNamePo.getFcnjcsqc())) ? "0.00" : companyNamePo.getFcnjcsqc());
		params.add("".equals(Utility.getName(companyNamePo.getFcnjcsyf())) ? "0.00" : companyNamePo.getFcnjcsyf());
		params.add("".equals(Utility.getName(companyNamePo.getFcnjcszq())) ? "0.00" : companyNamePo.getFcnjcszq());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 公司制造商配置信息加载
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanySupplierList(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select "); 
		buffer.append(" J_CS_SupplierID 								as fcnjcssupplierid 		");
		buffer.append(",J_CS_SupplierAgentID 							as fcnjcssupplieragentid 	");
		buffer.append(",B_Supplier.B_SP_ID 								as fcnsupplierid 			");
		buffer.append(",B_Supplier.B_SP_SupplierName 					as fcnsuppliername 			");
		buffer.append(",B_SupplierOpening.B_SP_StartPrice 				as fcnjcsqc 				");
		buffer.append(",B_SupplierOpening.B_SP_StartPayment 			as fcnjcsyf 				");
		buffer.append(",B_SupplierOpening.B_SP_SupplierAccountDate 		as fcnjcszq 				");
		buffer.append("from B_Supplier ");
		buffer.append("left join J_Company_Supplier on J_CS_SupplierID = B_Supplier.B_SP_ID and J_CS_CompanyID = ? ");
		buffer.append("left join B_SupplierOpening  on B_SP_SupplierID = J_CS_SupplierAgentID    and B_SP_CompanyID = ? ");
		buffer.append("where 1=1 and B_SP_Flag = '1' and B_Supplier.B_SP_ID <> 'ZZ' ");
		buffer.append("order by B_Supplier.B_SP_ID,B_Supplier.B_SP_SupplierName ");
		
		params.add(po.getFcnId());
		params.add(po.getFcnId());

		return queryForObjectList(buffer.toString(), params.toArray(), CompanyNamePo.class);
	}
	
	/**
	 * 公司供货商配置信息删除
	 */
	public void deleteCompanyAgent(CompanyNamePo companyNamePo) {

		StringBuffer buffer = new StringBuffer();

		//给SQL语句传值
		List<String> params = new ArrayList<String>();

		buffer.append("delete from J_Company_Supplier ");
		buffer.append("where J_CS_CompanyID = ? "); 
		
		params.add(Utility.getName(companyNamePo.getFcnjcscompanyid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 区域下载，删除该区域下所有临时表数据
	 * @param companyNamePo
	 */
	public void deleteRegionDownloadTemp(CompanyNamePo companyNamePo) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		
		//删除区域下公司信息
		buffer.append(" delete from F_CompanyName_Download ");
		buffer.append(" where F_CNT_RegionID = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		
		//删除区域下公司制造商供应商设置信息
		buffer.append(" delete from J_Company_Supplier_Download from J_Company_Supplier_Download ");
		buffer.append(" inner join F_CompanyName on J_CSD_CompanyID = F_CN_ID ");
		buffer.append(" where F_CN_RegionID = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		
		//删除区域下公司制造商信息
		buffer.append(" delete from B_Supplier_Download from B_Supplier_Download ");
		buffer.append(" Inner join J_Company_Supplier on B_SPD_ID = J_CS_SupplierID ");
		buffer.append(" Inner join F_CompanyName on F_CN_ID = J_CS_CompanyID ");
		buffer.append(" Where F_CN_RegionID  = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		
		//删除区域下公司供应商信息
		buffer.append(" delete from B_SupplierAgent_Download from B_SupplierAgent_Download ");
		buffer.append(" Inner join J_Company_Supplier on B_SPAD_ID = J_CS_SupplierAgentID ");
		buffer.append(" Inner join F_CompanyName on F_CN_ID = J_CS_CompanyID ");
		buffer.append(" Where F_CN_RegionID  = ? ");
		
		params.add(Utility.getName(companyNamePo.getFcnregionid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 集团端下载插入公司临时表
	 * @param companyNamePo
	 */
	public void insertCompanyNameTemp(String sqlstr) {
		StringBuffer buffer = new StringBuffer();

		//给SQL语句传值
		List<String> params = new ArrayList<String>();
		
		getJdbcTemplate().update(sqlstr, params.toArray());
	}
	
	/**
	 * 插入公司制造商供应商配置临时表
	 * 
	 * @param po
	 */
	public void insertCompanySupplierTemp(String sqlstr) {
		List<String> params = new ArrayList<String>();

		getJdbcTemplate().update(sqlstr, params.toArray());

	}
	
	/**
	 * 插入公司制造商临时表
	 * 
	 * @param po
	 */
	public void insertSupplierTemp(String sqlstr) {
		List<String> params = new ArrayList<String>();
		
		getJdbcTemplate().update(sqlstr, params.toArray());

	}
	
	/**
	 * 新增制造商信息
	 * 
	 * @param po
	 */
	public void insertSupplierAgentTemp(String sqlstr) {
		List<String> params = new ArrayList<String>();
		
		getJdbcTemplate().update(sqlstr, params.toArray());

	}
	
	/**
	 * 匹配公司信息并插入公司表
	 * 
	 * @param po
	 * @return
	 */
	public void insertCompanyPosForDownload(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("insert into F_CompanyName "); 
		buffer.append("(  "); 
		buffer.append(" F_CNT_ID 								");
		buffer.append(",F_CNT_Name 								");
		buffer.append(",F_CNT_RegionID 							");
		buffer.append(",F_CN_WholeSalePrice 					");
		buffer.append(",F_CN_CompanyType 						");
		buffer.append(")  "); 
		buffer.append("select "); 
		buffer.append(" F_CNT_ID 								");
		buffer.append(",F_CNT_Name 								");
		buffer.append(",F_CNT_RegionID 							");
		buffer.append(",'1.00' 									");
		buffer.append(",'1' 									");
		buffer.append("from F_CompanyName_Download ");
		buffer.append("left join F_CompanyName on F_CN_ID = F_CNT_ID ");
		buffer.append("where isnull(F_CN_ID,'') = '' ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 匹配公司制造商配置信息并插入公司表
	 * 
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierPosForDownload(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("insert into J_Company_Supplier  "); 
		buffer.append("(  "); 
		buffer.append(" J_CS_ID 								");
		buffer.append(",J_CS_CompanyID 							");
		buffer.append(",J_CS_SupplierID 						");
		buffer.append(",J_CS_SupplierAgentID 					");
		buffer.append(")  "); 
		buffer.append("select "); 
		buffer.append(" J_CSD_ID 								");
		buffer.append(",J_CSD_CompanyID 						");
		buffer.append(",J_CSD_SupplierID 						");
		buffer.append(",J_CSD_SupplierAgentID 					");	
		buffer.append("from J_Company_Supplier_Download 		");
		buffer.append("left join J_Company_Supplier on J_CSD_ID = J_CS_ID ");
		buffer.append("where isnull(J_CS_ID,'') = '' 			");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 匹配制造商信息并插入制造商表
	 * 
	 * @param po
	 * @return
	 */
	public void insertSupplierPosForDownload(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("insert into B_Supplier  "); 
		buffer.append("(  "); 
		buffer.append(" B_SP_ID ");
		buffer.append(",B_SP_SupplierName ");
		buffer.append(",B_SP_ContactPerson ");
		buffer.append(",B_SP_ContactPhone ");
		buffer.append(",B_SP_Fax ");
		buffer.append(",B_SP_Address ");
		buffer.append(",B_SP_Remark ");
		buffer.append(",B_SP_CategoryID ");
		buffer.append(",B_SP_Flag ");
		buffer.append(",B_SP_OrderSupplierID ");
		buffer.append(",B_SP_SupplierMnemonic ");
		buffer.append(",B_SP_DistributionMethods ");
		buffer.append(",B_SP_DocumentUrl ");
		buffer.append(",B_SP_ContentType ");
		buffer.append(",B_SP_SaveFileName ");
		buffer.append(",B_SP_ValidDate ");
		buffer.append(",B_SP_ValidDateUL ");
		buffer.append(",B_SP_ValidDateUP ");
		buffer.append(",B_SP_ForShort ");
		buffer.append(",B_SP_LinkMan ");
		buffer.append(",B_SP_LicenceID ");
		buffer.append(",B_SP_LicenceValidity ");
		buffer.append(",B_SP_DealingsAmount ");
		buffer.append(",B_SP_Settlement ");
		buffer.append(",B_SP_SettlementMonth ");
		buffer.append(",B_SP_MakeInvoiceFlag ");
		buffer.append(",B_SP_YLicenceID ");
		buffer.append(",B_SP_YLicenceValidity ");
		buffer.append(",B_SP_GLicenceID ");
		buffer.append(",B_SP_GLicenceValidity ");
		buffer.append(")  "); 
		buffer.append("select "); 
		buffer.append(" B_SPD_ID ");
		buffer.append(",B_SPD_SupplierName ");
		buffer.append(",B_SPD_ContactPerson ");
		buffer.append(",B_SPD_ContactPhone ");
		buffer.append(",B_SPD_Fax ");
		buffer.append(",B_SPD_Address ");
		buffer.append(",B_SPD_Remark ");
		buffer.append(",B_SPD_CategoryID ");
		buffer.append(",B_SPD_Flag ");
		buffer.append(",B_SPD_OrderSupplierID ");
		buffer.append(",B_SPD_SupplierMnemonic ");
		buffer.append(",B_SPD_DistributionMethods ");
		buffer.append(",B_SPD_DocumentUrl ");
		buffer.append(",B_SPD_ContentType ");
		buffer.append(",B_SPD_SaveFileName ");
		buffer.append(",B_SPD_ValidDate ");
		buffer.append(",B_SPD_ValidDateUL ");
		buffer.append(",B_SPD_ValidDateUP ");
		buffer.append(",B_SPD_ForShort ");
		buffer.append(",B_SPD_LinkMan ");
		buffer.append(",B_SPD_LicenceID ");
		buffer.append(",B_SPD_LicenceValidity ");
		buffer.append(",B_SPD_DealingsAmount ");
		buffer.append(",B_SPD_Settlement ");
		buffer.append(",B_SPD_SettlementMonth ");
		buffer.append(",B_SPD_MakeInvoiceFlag ");
		buffer.append(",B_SPD_YLicenceID ");
		buffer.append(",B_SPD_YLicenceValidity ");
		buffer.append(",B_SPD_GLicenceID ");
		buffer.append(",B_SPD_GLicenceValidity ");
		buffer.append("from B_Supplier_Download 		");
		buffer.append("left join B_Supplier on B_SP_ID = B_SPD_ID ");
		buffer.append("where isnull(B_SP_ID,'') = '' 			");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 匹配制造商信息并插入制造商表
	 * 
	 * @param po
	 * @return
	 */
	public void insertSupplierAgentPosForDownload(CompanyNamePo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("insert into B_SupplierAgent  "); 
		buffer.append("(  "); 
		buffer.append(" B_SP_ID ");
		buffer.append(",B_SP_SupplierName ");
		buffer.append(",B_SP_ContactPerson ");
		buffer.append(",B_SP_ContactPhone ");
		buffer.append(",B_SP_Fax ");
		buffer.append(",B_SP_Address ");
		buffer.append(",B_SP_Remark ");
		buffer.append(",B_SP_CategoryID ");
		buffer.append(",B_SP_Flag ");
		buffer.append(",B_SP_OrderSupplierID ");
		buffer.append(",B_SP_SupplierMnemonic ");
		buffer.append(",B_SP_DistributionMethods ");
		buffer.append(",B_SP_DocumentUrl ");
		buffer.append(",B_SP_ContentType ");
		buffer.append(",B_SP_SaveFileName ");
		buffer.append(",B_SP_ValidDate ");
		buffer.append(",B_SP_ValidDateUL ");
		buffer.append(",B_SP_ValidDateUP ");
		buffer.append(",B_SP_ForShort ");
		buffer.append(",B_SP_LinkMan ");
		buffer.append(",B_SP_LicenceID ");
		buffer.append(",B_SP_LicenceValidity ");
		buffer.append(",B_SP_DealingsAmount ");
		buffer.append(",B_SP_Settlement ");
		buffer.append(",B_SP_SettlementMonth ");
		buffer.append(",B_SP_MakeInvoiceFlag ");
		buffer.append(",B_SP_YLicenceID ");
		buffer.append(",B_SP_YLicenceValidity ");
		buffer.append(",B_SP_GLicenceID ");
		buffer.append(",B_SP_GLicenceValidity ");
		buffer.append(",B_SP_LinkSupplierID ");
		buffer.append(")  "); 
		buffer.append("select "); 
		buffer.append(" B_SPAD_ID ");
		buffer.append(",B_SPAD_SupplierName ");
		buffer.append(",B_SPAD_ContactPerson ");
		buffer.append(",B_SPAD_ContactPhone ");
		buffer.append(",B_SPAD_Fax ");
		buffer.append(",B_SPAD_Address ");
		buffer.append(",B_SPAD_Remark ");
		buffer.append(",B_SPAD_CategoryID ");
		buffer.append(",B_SPAD_Flag ");
		buffer.append(",B_SPAD_OrderSupplierID ");
		buffer.append(",B_SPAD_SupplierMnemonic ");
		buffer.append(",B_SPAD_DistributionMethods ");
		buffer.append(",B_SPAD_DocumentUrl ");
		buffer.append(",B_SPAD_ContentType ");
		buffer.append(",B_SPAD_SaveFileName ");
		buffer.append(",B_SPAD_ValidDate ");
		buffer.append(",B_SPAD_ValidDateUL ");
		buffer.append(",B_SPAD_ValidDateUP ");
		buffer.append(",B_SPAD_ForShort ");
		buffer.append(",B_SPAD_LinkMan ");
		buffer.append(",B_SPAD_LicenceID ");
		buffer.append(",B_SPAD_LicenceValidity ");
		buffer.append(",B_SPAD_DealingsAmount ");
		buffer.append(",B_SPAD_Settlement ");
		buffer.append(",B_SPAD_SettlementMonth ");
		buffer.append(",B_SPAD_MakeInvoiceFlag ");
		buffer.append(",B_SPAD_YLicenceID ");
		buffer.append(",B_SPAD_YLicenceValidity ");
		buffer.append(",B_SPAD_GLicenceID ");
		buffer.append(",B_SPAD_GLicenceValidity ");
		buffer.append(",B_SPAD_LinkSupplierID ");
		buffer.append("from B_SupplierAgent_Download 		");
		buffer.append("left join B_SupplierAgent on B_SP_ID = B_SPAD_ID ");
		buffer.append("where isnull(B_SP_ID,'') = '' 			");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
