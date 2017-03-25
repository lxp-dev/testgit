package com.pengsheng.eims.basic.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pengsheng.eims.basic.dao.DownloadRegionDao;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DownloadRegionDaoImpl extends BaseJdbcDaoSupport implements DownloadRegionDao{
	public static Properties oracleDriver= Tools.getProperty("/config/", "arjdbc.properties");
	private static String ip = oracleDriver.getProperty("jdbc.ip");
	private static String user = oracleDriver.getProperty("jdbc.username");
	private static String pwd = oracleDriver.getProperty("jdbc.password");
	
	/**
	 * 打开远程连接服务
	 * @param po
	 * @return
	 */
	public void openWork(){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec sp_configure 'show advanced options',1 ");
		sb.append("reconfigure ");
		sb.append("exec sp_configure 'Ad Hoc Distributed Queries',1 ");
		sb.append("reconfigure ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 关闭远程连接服务
	 * @param po
	 * @return
	 */
	public void closeWork(){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("exec sp_configure 'Ad Hoc Distributed Queries',0 ");
		sb.append("reconfigure ");
		sb.append("exec sp_configure 'show advanced options',0 ");
		sb.append("reconfigure ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取品种下载集团端品牌信息
	 * @param po
	 * @return
	 */
	public List<BrandPo> getDownloadBrandList(BrandPo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select  ");
		sb.append("	JTB.B_BD_ID 					as bbdid,  			");
		sb.append("	JTB.B_BD_brandName 				as bbdbrandname,  	");
		sb.append("	JTB.B_BD_GoodsCategory 			as bspcategoryid,  	");
		sb.append("	JTC.B_GC_GoodsCategoryName 		as bgcgoodscategoryname,  ");
		sb.append("	case  ");
		sb.append("		when isnull(JMB.B_BD_ID,'')  = '' then '未下载'  ");
		sb.append("		when isnull(JMB.B_BD_ID,'') <> '' then '已下载'  ");
		sb.append("	end as bbddownloadflag ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Brand) JTB  	");
		sb.append("  left join B_Brand JMB ");
		sb.append("			on JTB.B_BD_ID = JMB.B_BD_ID and JTB.B_BD_SupplierID = JMB.B_BD_SupplierID  ");
		sb.append("  inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsCategory) JTC  ");
		sb.append("			on JTC.B_GC_ID = JTB.B_BD_GoodsCategory  ");
		sb.append("where JTB.B_BD_SupplierID = '"+po.getBbdsupplierid()+"'  ");
		
		return  queryForObjectList(sb.toString(),params.toArray(),BrandPo.class);
	}
	
	/**
	 * 获取医院中不存在的公司信息插入公司表
	 * @param po
	 * @return
	 */
	public void insertDownloadCompanyPos(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into B_FrameMaterial ");
		sb.append("( ");
		sb.append(" B_FM_ID ");
		sb.append(",B_FM_Name ");
		sb.append(") ");
		sb.append("select ");
		sb.append("		 JT_FrameMaterial.B_FM_ID 			 ");	 
		sb.append("		,JT_FrameMaterial.B_FM_Name		 	 ");	 
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_FrameMaterial) JT_FrameMaterial ");
		sb.append("left join B_FrameMaterial JM_FrameMaterial on JM_FrameMaterial.B_FM_ID = JT_FrameMaterial.B_FM_ID ");
		sb.append("Where isnull(JM_FrameMaterial.B_FM_ID,'') = '' ");
		sb.append("  and JT_FrameMaterial.B_FM_ID <> '' ");
		
		sb.append("insert into B_Color ");
		sb.append("( ");
		sb.append(" B_C_ID ");
		sb.append(",B_C_ColorName ");
		sb.append(") ");
		sb.append("select ");
		sb.append("		 JT_Color.B_C_ID 			 ");	 
		sb.append("		,JT_Color.B_C_ColorName		 ");	 
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Color) JT_Color ");
		sb.append("left join B_Color JM_Color on JM_Color.B_C_ID = JT_Color.B_C_ID ");
		sb.append("Where isnull(JM_Color.B_C_ID,'') = '' ");
		sb.append("  and JM_Color.B_C_ID <> '' ");
		
		sb.append("insert into B_Refractive ");
		sb.append("( ");
		sb.append(" B_RF_ID ");
		sb.append(",B_RF_Name ");
		sb.append(") ");
		sb.append("select ");
		sb.append("		 JT_Refractive.B_RF_ID 			 ");	 
		sb.append("		,JT_Refractive.B_RF_Name		 ");	 
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Refractive) JT_Refractive ");
		sb.append("left join B_Refractive JM_Refractive on JM_Refractive.B_RF_ID = JT_Refractive.B_RF_ID ");
		sb.append("Where isnull(JM_Refractive.B_RF_ID,'') = '' ");
		sb.append("  and JM_Refractive.B_RF_ID <> '' ");
		
		sb.append("insert into F_TechnologyType ");
		sb.append("( ");
		sb.append(" F_TT_ID ");
		sb.append(",F_TT_Name ");
		sb.append(") ");
		sb.append("select ");
		sb.append(" 	 JT_TechnologyType.F_TT_ID ");
		sb.append("		,JT_TechnologyType.F_TT_Name ");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_TechnologyType) JT_TechnologyType ");
		sb.append("left join F_TechnologyType JM_TechnologyType on JM_TechnologyType.F_TT_ID = JT_TechnologyType.F_TT_ID ");
		sb.append("Where isnull(JM_TechnologyType.F_TT_ID,'') = '' ");
		sb.append("  and JM_TechnologyType.F_TT_ID <> '' ");
		
		sb.append("insert into B_Unit ");
		sb.append("( ");
		sb.append(" B_UT_id ");
		sb.append(",B_UT_unitName ");
		sb.append(") ");
		sb.append("select ");
		sb.append(" 	 JT_Unit.B_UT_id ");
		sb.append("		,JT_Unit.B_UT_unitName ");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Unit) JT_Unit ");
		sb.append("left join B_Unit JM_Unit on JM_Unit.B_UT_id = JT_Unit.B_UT_id ");
		sb.append("Where isnull(JM_Unit.B_UT_id,'') = '' ");
		sb.append("  and JM_Unit.B_UT_id <> '' ");
		
		sb.append("insert into B_GoodsLevel ");
		sb.append("( ");
		sb.append(" B_GL_UUID ");
		sb.append(",B_GL_ID ");
		sb.append(",B_GL_Name ");
		sb.append(",B_GL_Discount ");
		sb.append(",B_GL_CategoryID ");
		sb.append(") ");
		sb.append("select ");
		sb.append(" 	 JT_GoodsLevel.B_GL_UUID ");
		sb.append("		,JT_GoodsLevel.B_GL_ID ");
		sb.append("		,JT_GoodsLevel.B_GL_Name ");
		sb.append("		,JT_GoodsLevel.B_GL_Discount ");
		sb.append("		,JT_GoodsLevel.B_GL_CategoryID ");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsLevel) JT_GoodsLevel ");
		sb.append("left join B_GoodsLevel JM_GoodsLevel on JM_GoodsLevel.B_GL_UUID = JT_GoodsLevel.B_GL_UUID ");
		sb.append("Where isnull(JM_GoodsLevel.B_GL_UUID,'') = '' ");
		sb.append("  and JM_GoodsLevel.B_GL_UUID <> '' ");
		
		/*sb.append("insert into F_AdditionalCosts ");
		sb.append("( ");
		sb.append(" F_AC_ID            ");
		sb.append(",F_AC_Name          ");
		sb.append(",F_AC_Amount        ");
		sb.append(",F_AC_Number        ");
		sb.append(",F_AC_SupplierID    ");
		sb.append(") ");
		sb.append("select ");
		sb.append(" 	 JT_AdditionalCosts.F_AC_ID ");
		sb.append("		,JT_AdditionalCosts.F_AC_Name ");
		sb.append("		,JT_AdditionalCosts.F_AC_Amount ");
		sb.append("		,JT_AdditionalCosts.F_AC_Number ");
		sb.append("		,JT_AdditionalCosts.F_AC_SupplierID ");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_AdditionalCosts) JT_AdditionalCosts ");
		sb.append("left join F_AdditionalCosts JM_AdditionalCosts on JM_AdditionalCosts.F_AC_ID = JT_AdditionalCosts.F_AC_ID ");
		sb.append("Where isnull(JM_AdditionalCosts.F_AC_ID,'') = '' ");
		sb.append("  and JM_AdditionalCosts.F_AC_ID <> '' ");*/
		
		/*sb.append("insert into F_SpecialRequirements ");
		sb.append("( ");
		sb.append(" F_SR_ID ");
		sb.append(",F_SR_Name ");
		sb.append(") ");
		sb.append("select ");
		sb.append(" 	 JT_SpecialRequirements.F_SR_ID ");
		sb.append("		,JT_SpecialRequirements.F_SR_Name ");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_SpecialRequirements) JT_SpecialRequirements ");
		sb.append("left join F_SpecialRequirements JM_SpecialRequirements on JM_SpecialRequirements.F_SR_ID = JT_SpecialRequirements.F_SR_ID ");
		sb.append("Where isnull(JM_SpecialRequirements.F_SR_ID,'') = '' ");
		sb.append("  and JM_SpecialRequirements.F_SR_ID <> '' ");*/
		
		sb.append("insert into F_OptionParam ");
		sb.append("( ");
		sb.append(" F_OP_ParamID    ");
		sb.append(",F_OP_ParamName  ");
		sb.append(",F_OP_ModuleID   ");
		sb.append(",F_OP_Remark     ");
		sb.append(",F_OP_ParentID   ");
		sb.append(",F_OP_Type    	");
		sb.append(") ");
		sb.append("select ");
		sb.append(" 	 JT_OptionParam.F_OP_ParamID    ");
		sb.append("		,JT_OptionParam.F_OP_ParamName  ");
		sb.append("		,JT_OptionParam.F_OP_ModuleID   ");
		sb.append("		,JT_OptionParam.F_OP_Remark     ");
		sb.append("		,JT_OptionParam.F_OP_ParentID   ");
		sb.append("		,JT_OptionParam.F_OP_Type    	");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_OptionParam) JT_OptionParam ");
		sb.append("left join F_OptionParam JM_OptionParam on JM_OptionParam.F_OP_ParamID = JT_OptionParam.F_OP_ParamID ");
		sb.append("Where isnull(JM_OptionParam.F_OP_ParamID,'') = '' ");
		sb.append("  and JM_OptionParam.F_OP_ParamID <> '' ");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端公司供应商配置信息插入公司供应商配置表
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierMentPos(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from J_Company_Supplier ");
		sb.append("Where J_CS_CompanyID = ? ");
		
		params.add(po.getFcnId());
		
		sb.append("insert into J_Company_Supplier ");
		sb.append("( ");
		sb.append(" J_CS_ID ");
		sb.append(",J_CS_CompanyID ");
		sb.append(",J_CS_SupplierID ");
		sb.append(",J_CS_SupplierAgentID ");
		sb.append(") ");
		
		sb.append("Select  ");
		sb.append(" JT_Company_Supplier.J_CS_ID  ");                
		sb.append(",JT_Company_Supplier.J_CS_CompanyID     ");      
		sb.append(",JT_Company_Supplier.J_CS_SupplierID    ");      
		sb.append(",JT_Company_Supplier.J_CS_SupplierAgentID     ");
		sb.append("From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.J_Company_Supplier) JT_Company_Supplier ");
		sb.append("Where JT_Company_Supplier.J_CS_CompanyID = ? ");
		
		params.add(po.getFcnId());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端区域下的制造商插入医院端制造商表
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierPos(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into B_Supplier ");
		sb.append("( ");
		sb.append("	 B_SP_ID                       ");  
		sb.append("	,B_SP_SupplierName             ");  
		sb.append("	,B_SP_ContactPerson            ");  
		sb.append("	,B_SP_ContactPhone             ");    
		sb.append("	,B_SP_Fax                      ");    
		sb.append("	,B_SP_Address                  ");    
		sb.append("	,B_SP_Remark                   ");    
		sb.append("	,B_SP_CategoryID               ");    
		sb.append("	,B_SP_Flag                     ");    
		sb.append("	,B_SP_OrderSupplierID          ");    
		sb.append("	,B_SP_SupplierMnemonic         ");    
		sb.append("	,B_SP_DistributionMethods      ");    
		sb.append("	,B_SP_DocumentUrl              ");    
		sb.append("	,B_SP_ContentType              ");    
		sb.append("	,B_SP_SaveFileName             ");    
		sb.append("	,B_SP_ValidDate                ");    
		sb.append("	,B_SP_ValidDateUL              ");    
		sb.append("	,B_SP_ValidDateUP              ");    
		sb.append("	,B_SP_ForShort                 ");    
		sb.append("	,B_SP_LinkMan                  ");    
		sb.append("	,B_SP_LicenceID                ");    
		sb.append("	,B_SP_LicenceValidity          ");    
		sb.append("	,B_SP_DealingsAmount           ");    
		sb.append("	,B_SP_Settlement               ");    
		sb.append("	,B_SP_SettlementMonth          ");    
		sb.append("	,B_SP_MakeInvoiceFlag          ");    
		sb.append("	,B_SP_YLicenceID               ");    
		sb.append("	,B_SP_YLicenceValidity         ");    
		sb.append("	,B_SP_GLicenceID               ");    
		sb.append("	,B_SP_GLicenceValidity 		   ");  
		sb.append(") ");  
		sb.append("Select  ");
		sb.append("	 JT_Supplier.B_SP_ID                       ");  
		sb.append("	,JT_Supplier.B_SP_SupplierName             ");  
		sb.append("	,JT_Supplier.B_SP_ContactPerson            ");  
		sb.append("	,JT_Supplier.B_SP_ContactPhone             "); 
		sb.append("	,JT_Supplier.B_SP_Fax                      ");  
		sb.append("	,JT_Supplier.B_SP_Address                  ");  
		sb.append("	,JT_Supplier.B_SP_Remark                   ");  
		sb.append("	,JT_Supplier.B_SP_CategoryID               ");  
		sb.append("	,JT_Supplier.B_SP_Flag                     ");  
		sb.append("	,JT_Supplier.B_SP_OrderSupplierID          ");  
		sb.append("	,JT_Supplier.B_SP_SupplierMnemonic         ");  
		sb.append("	,JT_Supplier.B_SP_DistributionMethods      ");  
		sb.append("	,JT_Supplier.B_SP_DocumentUrl              ");  
		sb.append("	,JT_Supplier.B_SP_ContentType              ");  
		sb.append("	,JT_Supplier.B_SP_SaveFileName             ");  
		sb.append("	,JT_Supplier.B_SP_ValidDate                ");  
		sb.append("	,JT_Supplier.B_SP_ValidDateUL              ");  
		sb.append("	,JT_Supplier.B_SP_ValidDateUP              ");  
		sb.append("	,JT_Supplier.B_SP_ForShort                 ");  
		sb.append("	,JT_Supplier.B_SP_LinkMan                  ");  
		sb.append("	,JT_Supplier.B_SP_LicenceID                ");  
		sb.append("	,JT_Supplier.B_SP_LicenceValidity          ");  
		sb.append("	,JT_Supplier.B_SP_DealingsAmount           ");  
		sb.append("	,JT_Supplier.B_SP_Settlement               ");  
		sb.append("	,JT_Supplier.B_SP_SettlementMonth          ");  
		sb.append("	,JT_Supplier.B_SP_MakeInvoiceFlag          ");  
		sb.append("	,JT_Supplier.B_SP_YLicenceID               ");  
		sb.append("	,JT_Supplier.B_SP_YLicenceValidity         ");  
		sb.append("	,JT_Supplier.B_SP_GLicenceID               ");  
		sb.append("	,JT_Supplier.B_SP_GLicenceValidity         ");  
		sb.append("	From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Supplier) JT_Supplier ");
		sb.append("	Inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.J_Company_Supplier) JT_Company_Supplier on JT_Supplier.B_SP_ID = JT_Company_Supplier.J_CS_SupplierID ");
		sb.append("	Inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_CompanyName) JT_CompanyName on JT_CompanyName.F_CN_ID = JT_Company_Supplier.J_CS_CompanyID ");
		sb.append("	left join B_Supplier JM_Supplier on JM_Supplier.B_SP_ID = JT_Supplier.B_SP_ID ");
		sb.append("	Where JT_CompanyName.F_CN_ID  = ? ");
		sb.append("	  and isnull(JM_Supplier.B_SP_ID,'') = '' ");
		
		params.add(po.getFcnId());
		
		sb.append("update  B_Supplier set ");
		sb.append(" B_Supplier.B_SP_CategoryID = JT_Supplier.B_SP_CategoryID ");
		sb.append("from B_Supplier JM ");
		sb.append("inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Supplier) JT_Supplier on JT_Supplier.B_SP_ID = JM.B_SP_ID "); 
		sb.append("	Inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.J_Company_Supplier) JT_Company_Supplier on JT_Supplier.B_SP_ID = JT_Company_Supplier.J_CS_SupplierID ");
		sb.append("	Inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_CompanyName) JT_CompanyName on JT_CompanyName.F_CN_ID = JT_Company_Supplier.J_CS_CompanyID ");
		sb.append("		and JT_Supplier.B_SP_CategoryID <> JM.B_SP_CategoryID ");
		sb.append("	Where JT_CompanyName.F_CN_ID  = ? ");
		
		params.add(po.getFcnId());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端区域下的供应商插入医院端供应商表
	 * @param po
	 * @return
	 */
	public void insertCompanySupplierAgentPos(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into B_SupplierAgent ");
		sb.append("( ");
		sb.append("	 B_SP_ID                       ");  
		sb.append("	,B_SP_SupplierName             ");  
		sb.append("	,B_SP_ContactPerson            ");  
		sb.append("	,B_SP_ContactPhone             ");    
		sb.append("	,B_SP_Fax                      ");    
		sb.append("	,B_SP_Address                  ");    
		sb.append("	,B_SP_Remark                   ");    
		sb.append("	,B_SP_CategoryID               ");    
		sb.append("	,B_SP_Flag                     ");    
		sb.append("	,B_SP_OrderSupplierID          ");    
		sb.append("	,B_SP_SupplierMnemonic         ");    
		sb.append("	,B_SP_DistributionMethods      ");    
		sb.append("	,B_SP_DocumentUrl              ");    
		sb.append("	,B_SP_ContentType              ");    
		sb.append("	,B_SP_SaveFileName             ");    
		sb.append("	,B_SP_ValidDate                ");    
		sb.append("	,B_SP_ValidDateUL              ");    
		sb.append("	,B_SP_ValidDateUP              ");    
		sb.append("	,B_SP_ForShort                 ");    
		sb.append("	,B_SP_LinkMan                  ");    
		sb.append("	,B_SP_LicenceID                ");    
		sb.append("	,B_SP_LicenceValidity          ");    
		sb.append("	,B_SP_DealingsAmount           ");    
		sb.append("	,B_SP_Settlement               ");    
		sb.append("	,B_SP_SettlementMonth          ");    
		sb.append("	,B_SP_MakeInvoiceFlag          ");    
		sb.append("	,B_SP_YLicenceID               ");    
		sb.append("	,B_SP_YLicenceValidity         ");    
		sb.append("	,B_SP_GLicenceID               ");    
		sb.append("	,B_SP_GLicenceValidity         ");
		sb.append("	,B_SP_LinkSupplierID 		   ");  
		sb.append(") ");  
		sb.append("Select  ");
		sb.append("	 JT_SupplierAgent.B_SP_ID                       ");  
		sb.append("	,JT_SupplierAgent.B_SP_SupplierName             ");  
		sb.append("	,JT_SupplierAgent.B_SP_ContactPerson            ");  
		sb.append("	,JT_SupplierAgent.B_SP_ContactPhone             "); 
		sb.append("	,JT_SupplierAgent.B_SP_Fax                      ");  
		sb.append("	,JT_SupplierAgent.B_SP_Address                  ");  
		sb.append("	,JT_SupplierAgent.B_SP_Remark                   ");  
		sb.append("	,JT_SupplierAgent.B_SP_CategoryID               ");  
		sb.append("	,JT_SupplierAgent.B_SP_Flag                     ");  
		sb.append("	,JT_SupplierAgent.B_SP_OrderSupplierID          ");  
		sb.append("	,JT_SupplierAgent.B_SP_SupplierMnemonic         ");  
		sb.append("	,JT_SupplierAgent.B_SP_DistributionMethods      ");  
		sb.append("	,JT_SupplierAgent.B_SP_DocumentUrl              ");  
		sb.append("	,JT_SupplierAgent.B_SP_ContentType              ");  
		sb.append("	,JT_SupplierAgent.B_SP_SaveFileName             ");  
		sb.append("	,JT_SupplierAgent.B_SP_ValidDate                ");  
		sb.append("	,JT_SupplierAgent.B_SP_ValidDateUL              ");  
		sb.append("	,JT_SupplierAgent.B_SP_ValidDateUP              ");  
		sb.append("	,JT_SupplierAgent.B_SP_ForShort                 ");  
		sb.append("	,JT_SupplierAgent.B_SP_LinkMan                  ");  
		sb.append("	,JT_SupplierAgent.B_SP_LicenceID                ");  
		sb.append("	,JT_SupplierAgent.B_SP_LicenceValidity          ");  
		sb.append("	,JT_SupplierAgent.B_SP_DealingsAmount           ");  
		sb.append("	,JT_SupplierAgent.B_SP_Settlement               ");  
		sb.append("	,JT_SupplierAgent.B_SP_SettlementMonth          ");  
		sb.append("	,JT_SupplierAgent.B_SP_MakeInvoiceFlag          ");  
		sb.append("	,JT_SupplierAgent.B_SP_YLicenceID               ");  
		sb.append("	,JT_SupplierAgent.B_SP_YLicenceValidity         ");  
		sb.append("	,JT_SupplierAgent.B_SP_GLicenceID               ");  
		sb.append("	,JT_SupplierAgent.B_SP_GLicenceValidity         ");  
		sb.append("	,JT_SupplierAgent.B_SP_LinkSupplierID           ");
		sb.append("	From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_SupplierAgent) JT_SupplierAgent ");
		sb.append("	Inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.J_Company_Supplier) JT_Company_Supplier on JT_SupplierAgent.B_SP_ID = JT_Company_Supplier.J_CS_SupplierAgentID ");
		sb.append("	Inner join openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_CompanyName) JT_CompanyName on JT_CompanyName.F_CN_ID = JT_Company_Supplier.J_CS_CompanyID ");
		sb.append("	left join B_SupplierAgent JM_SupplierAgent on JT_SupplierAgent.B_SP_ID = JM_SupplierAgent.B_SP_ID ");
		sb.append("	Where JT_CompanyName.F_CN_ID = ? ");
		sb.append("	  and isnull(JM_SupplierAgent.B_SP_ID,'') = '' ");
		
		params.add(po.getFcnId());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端区域下指定供应商下的品牌插入医院端品牌表
	 * @param po
	 * @return
	 */
	public void insertCompanyBrandPos(BrandPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into B_Brand ");
		sb.append("( ");
		sb.append(" B_BD_ID                                   ");
		sb.append(",B_BD_brandName                            ");
		sb.append(",B_BD_SupplierID                           ");
		sb.append(",B_BD_Place                                ");
		sb.append(",B_BD_MnemonicCode                         ");
		sb.append(",B_BD_GoodsCategory                        ");
		sb.append(",B_BD_Refractive                           ");
		sb.append(",B_BD_RetailPrice                          ");
		sb.append(",B_BD_CostPrice                            ");
		sb.append(",B_BD_NotTaxRate                           ");
		sb.append(",B_BD_TaxRate                              ");
		sb.append(",B_BD_frameProcessCraftType                ");
		sb.append(",B_BD_ThrowingCycle                        ");
		sb.append(",B_BD_Remark                               ");
		sb.append(",B_BD_SalesStatue                          ");
		sb.append(",B_BD_DocumentUrl                          ");
		sb.append(",B_BD_ContentType                          ");
		sb.append(",B_BD_SaveFileName                         ");
		sb.append(",B_BD_ValidDate                            ");
		sb.append(",B_BD_ValidDateUL                          ");
		sb.append(",B_BD_ValidDateUP                          ");
		sb.append(",B_BD_DistributionMethods                  ");
		sb.append(",B_BD_Unit                                 ");
		sb.append(",B_BD_FrameMaterialType                    ");
		sb.append(",B_BD_MaterialClass                        ");
		sb.append(",B_BD_LuminosityClass                      ");
		sb.append(",B_BD_GradualClass                         ");
		sb.append(",B_BD_FunctionClass                        ");
		sb.append(",B_BD_UseType                              ");
		sb.append(",B_BD_StealthClass                         ");
		sb.append(",B_BD_Settlement                           ");
		sb.append(",B_BD_SettlementMonth                      ");
		sb.append(",B_BD_DefaultDiscount                      ");
		sb.append(",B_BD_RegistrationNo                       ");
		sb.append(",B_BD_Promotion                            ");
		sb.append(",B_BD_PromotionType                        ");
		sb.append(",B_BD_BarCodeFlag                          ");
		sb.append(",B_BD_RegistrationNum                      ");  
		sb.append(") ");  
		sb.append("select                                              ");
		sb.append(" JT_Brand.B_BD_ID                                   ");
		sb.append(",JT_Brand.B_BD_brandName                            ");
		sb.append(",JT_Brand.B_BD_SupplierID                           ");
		sb.append(",JT_Brand.B_BD_Place                                ");
		sb.append(",JT_Brand.B_BD_MnemonicCode                         ");
		sb.append(",JT_Brand.B_BD_GoodsCategory                        ");
		sb.append(",JT_Brand.B_BD_Refractive                           ");
		sb.append(",JT_Brand.B_BD_RetailPrice                          ");
		sb.append(",JT_Brand.B_BD_CostPrice                            ");
		sb.append(",JT_Brand.B_BD_NotTaxRate                           ");
		sb.append(",JT_Brand.B_BD_TaxRate                              ");
		sb.append(",JT_Brand.B_BD_frameProcessCraftType                ");
		sb.append(",JT_Brand.B_BD_ThrowingCycle                        ");
		sb.append(",JT_Brand.B_BD_Remark                               ");
		sb.append(",JT_Brand.B_BD_SalesStatue                          ");
		sb.append(",JT_Brand.B_BD_DocumentUrl                          ");
		sb.append(",JT_Brand.B_BD_ContentType                          ");
		sb.append(",JT_Brand.B_BD_SaveFileName                         ");
		sb.append(",JT_Brand.B_BD_ValidDate                            ");
		sb.append(",JT_Brand.B_BD_ValidDateUL                          ");
		sb.append(",JT_Brand.B_BD_ValidDateUP                          ");
		sb.append(",JT_Brand.B_BD_DistributionMethods                  ");
		sb.append(",JT_Brand.B_BD_Unit                                 ");
		sb.append(",JT_Brand.B_BD_FrameMaterialType                    ");
		sb.append(",JT_Brand.B_BD_MaterialClass                        ");
		sb.append(",JT_Brand.B_BD_LuminosityClass                      ");
		sb.append(",JT_Brand.B_BD_GradualClass                         ");
		sb.append(",JT_Brand.B_BD_FunctionClass                        ");
		sb.append(",JT_Brand.B_BD_UseType                              ");
		sb.append(",JT_Brand.B_BD_StealthClass                         ");
		sb.append(",JT_Brand.B_BD_Settlement                           ");
		sb.append(",JT_Brand.B_BD_SettlementMonth                      ");
		sb.append(",JT_Brand.B_BD_DefaultDiscount                      ");
		sb.append(",JT_Brand.B_BD_RegistrationNo                       ");
		sb.append(",JT_Brand.B_BD_Promotion                            ");
		sb.append(",JT_Brand.B_BD_PromotionType                        ");
		sb.append(",JT_Brand.B_BD_BarCodeFlag                          ");
		sb.append(",JT_Brand.B_BD_RegistrationNum                      ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Brand) JT_Brand ");
		sb.append("left join B_Brand JM_Brand on JT_Brand.B_BD_SupplierID = JM_Brand.B_BD_SupplierID and JT_Brand.B_BD_ID = JM_Brand.B_BD_ID ");
		sb.append("where JT_Brand.B_BD_SupplierID = ? 				   ");
		sb.append("  and isnull(JM_Brand.B_BD_SupplierID,'') = '' 	   ");
		params.add(po.getBbdsupplierid());
		sb.append("  and JT_Brand.B_BD_ID in(							");
		
		String paramStr = "";
		for (int i = 0; i < po.getBbdids().length; i++) {
			if(!"".equals(po.getBbdids()[i])){
				paramStr = paramStr + "?,";
				params.add(po.getBbdids()[i]);
			}
		}

		sb.append(paramStr.replaceFirst(",$", ""));
		sb.append("  ) 													");
		sb.append("  and isnull(JM_Brand.B_BD_ID,'') = '' 				");
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端区域下指定品牌插入医院端品牌表
	 * @param po
	 * @return
	 */
	public void insertCompanyBrandPo(GoodsInfoPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into B_Brand ");
		sb.append("( ");
		sb.append(" B_BD_ID                                   ");
		sb.append(",B_BD_brandName                            ");
		sb.append(",B_BD_SupplierID                           ");
		sb.append(",B_BD_Place                                ");
		sb.append(",B_BD_MnemonicCode                         ");
		sb.append(",B_BD_GoodsCategory                        ");
		sb.append(",B_BD_Refractive                           ");
		sb.append(",B_BD_RetailPrice                          ");
		sb.append(",B_BD_CostPrice                            ");
		sb.append(",B_BD_NotTaxRate                           ");
		sb.append(",B_BD_TaxRate                              ");
		sb.append(",B_BD_frameProcessCraftType                ");
		sb.append(",B_BD_ThrowingCycle                        ");
		sb.append(",B_BD_Remark                               ");
		sb.append(",B_BD_SalesStatue                          ");
		sb.append(",B_BD_DocumentUrl                          ");
		sb.append(",B_BD_ContentType                          ");
		sb.append(",B_BD_SaveFileName                         ");
		sb.append(",B_BD_ValidDate                            ");
		sb.append(",B_BD_ValidDateUL                          ");
		sb.append(",B_BD_ValidDateUP                          ");
		sb.append(",B_BD_DistributionMethods                  ");
		sb.append(",B_BD_Unit                                 ");
		sb.append(",B_BD_FrameMaterialType                    ");
		sb.append(",B_BD_MaterialClass                        ");
		sb.append(",B_BD_LuminosityClass                      ");
		sb.append(",B_BD_GradualClass                         ");
		sb.append(",B_BD_FunctionClass                        ");
		sb.append(",B_BD_UseType                              ");
		sb.append(",B_BD_StealthClass                         ");
		sb.append(",B_BD_Settlement                           ");
		sb.append(",B_BD_SettlementMonth                      ");
		sb.append(",B_BD_DefaultDiscount                      ");
		sb.append(",B_BD_RegistrationNo                       ");
		sb.append(",B_BD_Promotion                            ");
		sb.append(",B_BD_PromotionType                        ");
		sb.append(",B_BD_BarCodeFlag                          ");
		sb.append(",B_BD_RegistrationNum                      ");  
		sb.append(") ");  
		sb.append("select                                              ");
		sb.append(" JT_Brand.B_BD_ID                                   ");
		sb.append(",JT_Brand.B_BD_brandName                            ");
		sb.append(",JT_Brand.B_BD_SupplierID                           ");
		sb.append(",JT_Brand.B_BD_Place                                ");
		sb.append(",JT_Brand.B_BD_MnemonicCode                         ");
		sb.append(",JT_Brand.B_BD_GoodsCategory                        ");
		sb.append(",JT_Brand.B_BD_Refractive                           ");
		sb.append(",JT_Brand.B_BD_RetailPrice                          ");
		sb.append(",JT_Brand.B_BD_CostPrice                            ");
		sb.append(",JT_Brand.B_BD_NotTaxRate                           ");
		sb.append(",JT_Brand.B_BD_TaxRate                              ");
		sb.append(",JT_Brand.B_BD_frameProcessCraftType                ");
		sb.append(",JT_Brand.B_BD_ThrowingCycle                        ");
		sb.append(",JT_Brand.B_BD_Remark                               ");
		sb.append(",JT_Brand.B_BD_SalesStatue                          ");
		sb.append(",JT_Brand.B_BD_DocumentUrl                          ");
		sb.append(",JT_Brand.B_BD_ContentType                          ");
		sb.append(",JT_Brand.B_BD_SaveFileName                         ");
		sb.append(",JT_Brand.B_BD_ValidDate                            ");
		sb.append(",JT_Brand.B_BD_ValidDateUL                          ");
		sb.append(",JT_Brand.B_BD_ValidDateUP                          ");
		sb.append(",JT_Brand.B_BD_DistributionMethods                  ");
		sb.append(",JT_Brand.B_BD_Unit                                 ");
		sb.append(",JT_Brand.B_BD_FrameMaterialType                    ");
		sb.append(",JT_Brand.B_BD_MaterialClass                        ");
		sb.append(",JT_Brand.B_BD_LuminosityClass                      ");
		sb.append(",JT_Brand.B_BD_GradualClass                         ");
		sb.append(",JT_Brand.B_BD_FunctionClass                        ");
		sb.append(",JT_Brand.B_BD_UseType                              ");
		sb.append(",JT_Brand.B_BD_StealthClass                         ");
		sb.append(",JT_Brand.B_BD_Settlement                           ");
		sb.append(",JT_Brand.B_BD_SettlementMonth                      ");
		sb.append(",JT_Brand.B_BD_DefaultDiscount                      ");
		sb.append(",JT_Brand.B_BD_RegistrationNo                       ");
		sb.append(",JT_Brand.B_BD_Promotion                            ");
		sb.append(",JT_Brand.B_BD_PromotionType                        ");
		sb.append(",JT_Brand.B_BD_BarCodeFlag                          ");
		sb.append(",JT_Brand.B_BD_RegistrationNum                      ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_Brand) JT_Brand ");
		sb.append("left join B_Brand JM_Brand on JT_Brand.B_BD_SupplierID = JM_Brand.B_BD_SupplierID and JT_Brand.B_BD_ID = JM_Brand.B_BD_ID ");
		sb.append("where JT_Brand.B_BD_SupplierID = ? 				   ");
		sb.append("  and isnull(JM_Brand.B_BD_SupplierID,'') = '' 	   ");
		params.add(po.getBgigoodsid().substring(2, 4));
		sb.append("  and JT_Brand.B_BD_ID = ?							");
		params.add(po.getBgigoodsid().substring(5, 7));
		sb.append("  and isnull(JM_Brand.B_BD_ID,'') = '' 				");

		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端商品信息插入医院端商品表
	 * @param po
	 * @return
	 */
	public void insertCompanyGoodsPo(GoodsInfoPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("insert into B_GoodsInfo(                  ");
		sb.append(" B_GI_GoodsID                             ");
		sb.append(",B_GI_GoodsBarCode                        ");
		sb.append(",B_GI_GoodsName                           ");
		sb.append(",B_GI_GoodsCategoryID                     ");
		sb.append(",B_GI_SupplierID                          ");
		sb.append(",B_GI_BrandID                             ");
		sb.append(",B_GI_UnitId                              ");
		sb.append(",B_GI_RetailPrice                         ");
		sb.append(",B_GI_CostPrice                           ");
		sb.append(",B_GI_NotTaxRate                          ");
		sb.append(",B_GI_TaxRate                             ");
		sb.append(",B_GI_Spec                                ");
		sb.append(",B_GI_Color                               ");
		sb.append(",B_GI_isCustomize                         ");
		sb.append(",B_GI_Sph                                 ");
		sb.append(",B_GI_SphUL                               ");
		sb.append(",B_GI_SphUP                               ");
		sb.append(",B_GI_Cyl                                 ");
		sb.append(",B_GI_CylUL                               ");
		sb.append(",B_GI_CylUP                               ");
		sb.append(",B_GI_BelowPlusLuminosity                 ");
		sb.append(",B_GI_BelowPlusLuminosityUL               ");
		sb.append(",B_GI_BelowPlusLuminosityUP               ");
		sb.append(",B_GI_Axis                                ");
		sb.append(",B_GI_AxisUL                              ");
		sb.append(",B_GI_AxisUP                              ");
		sb.append(",B_GI_Curvature1                          ");
		sb.append(",B_GI_Curvature1UL                        ");
		sb.append(",B_GI_Curvature1UP                        ");
		sb.append(",B_GI_Curvature2                          ");
		sb.append(",B_GI_Curvature2UL                        ");
		sb.append(",B_GI_Curvature2UP                        ");
		sb.append(",B_GI_Dia                                 ");
		sb.append(",B_GI_DiaUL                               ");
		sb.append(",B_GI_DiaUP                               ");
		sb.append(",B_GI_isMutiLuminosity                    ");
		sb.append(",B_GI_MutiLuminosityNum                   ");
		sb.append(",B_GI_MutiLuminosityAddPrice              ");
		sb.append(",B_GI_EyeGlassMaterialType                ");
		sb.append(",B_GI_isPlating                           ");
		sb.append(",B_GI_orderCycle                          ");
		sb.append(",B_GI_FinishedGlassesType                 ");
		sb.append(",B_GI_frameProcessCraftType               ");
		sb.append(",B_GI_CylMin                              ");
		sb.append(",B_GI_CylDegreeIncrease                   ");
		sb.append(",B_GI_CylMinAddPrice                      ");
		sb.append(",B_GI_CylAddPrice                         ");
		sb.append(",B_GI_PrismAddPrice                       ");
		sb.append(",B_GI_cyl25CanNotDo                       ");
		sb.append(",B_GI_ThrowingCycle                       ");
		sb.append(",B_GI_StealthType                         ");
		sb.append(",B_GI_OtherGoodsBigClass                  ");
		sb.append(",B_GI_OtherGoodsSmallClass                ");
		sb.append(",B_GI_Flag                                ");
		sb.append(",B_GI_Refractive                          ");
		sb.append(",B_GI_FrameMaterialType                   ");
		sb.append(",B_GI_AverageNotTaxRate                   ");
		sb.append(",B_GI_ReturnMax                           ");
		sb.append(",B_GI_ReturnMin                           ");
		sb.append(",B_GI_WholesalePrice                      ");
		sb.append(",B_GI_FrameSize                           ");
		sb.append(",B_GI_MaterialClass                       ");
		sb.append(",B_GI_LuminosityClass                     ");
		sb.append(",B_GI_GradualClass                        ");
		sb.append(",B_GI_FunctionClass                       ");
		sb.append(",B_GI_UseType                             ");
		sb.append(",B_GI_StealthClass                        ");
		sb.append(",B_GI_Capacity                            ");
		sb.append(",B_GI_CapacityEntry                       ");
		sb.append(",B_GI_AccessoriesType                     ");
		sb.append(",B_GI_SupplierColor                       ");
		sb.append(",B_GI_SunGglassesFun                      ");
		sb.append(",B_GI_FirstInStorageDate                  ");
		sb.append(",B_GI_RetailPriceA                        ");
		sb.append(",B_GI_RetailPriceB                        ");
		sb.append(",B_GI_RetailPriceC                        ");
		sb.append(",B_GI_RetailPriceD                        ");
		sb.append(",B_GI_RetailPriceE                        ");
		sb.append(",B_GI_RetailPriceF                        ");
		sb.append(",B_GI_RetailPriceG                        ");
		sb.append(",B_GI_RetailPriceH                        ");
		sb.append(",B_GI_RetailPriceI                        ");
		sb.append(",B_GI_WholeGoodsIsable                    ");
		sb.append(",B_GI_BrandYear                           ");
		sb.append(",B_GI_ChineseColor                        ");
		sb.append(",B_GI_SupplierSpec                        ");
		sb.append(",B_GI_ViewGoodsName                       ");
		sb.append(",B_GI_Vsph                                ");
		sb.append(",B_GI_Vcyl                                ");
		sb.append(",B_GI_DefaultDiscountValue                ");
		sb.append(",B_GI_Numberofdays                        ");
		sb.append(",B_GI_ContactType                         ");
		sb.append(",B_GI_BarCodeFlag                         ");
		sb.append(",B_GI_UnionSphCyl                         ");
		sb.append(",B_GI_FrameStyle                          ");
		sb.append(",B_GI_LastInStorageDate                   ");
		sb.append(",B_GI_ContactTypeD                        ");
		sb.append(",B_GI_ContactTypeY                        ");
		sb.append(",B_GI_DropMin                             ");
		sb.append(",B_GI_DropMax                             ");
		sb.append(",B_GI_StealthCustomizeType)               ");
		sb.append("select                                    ");
		sb.append(" JT_GoodsInfo.B_GI_GoodsID                ");
		sb.append(",JT_GoodsInfo.B_GI_GoodsBarCode           ");
		sb.append(",JT_GoodsInfo.B_GI_GoodsName              ");
		sb.append(",JT_GoodsInfo.B_GI_GoodsCategoryID        ");
		sb.append(",JT_GoodsInfo.B_GI_SupplierID             ");
		sb.append(",JT_GoodsInfo.B_GI_BrandID                ");
		sb.append(",JT_GoodsInfo.B_GI_UnitId                 ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPrice            ");
		sb.append(",JT_GoodsInfo.B_GI_CostPrice              ");
		sb.append(",JT_GoodsInfo.B_GI_NotTaxRate             ");
		sb.append(",JT_GoodsInfo.B_GI_TaxRate                ");
		sb.append(",JT_GoodsInfo.B_GI_Spec                   ");
		sb.append(",JT_GoodsInfo.B_GI_Color                  ");
		sb.append(",JT_GoodsInfo.B_GI_isCustomize            ");
		sb.append(",JT_GoodsInfo.B_GI_Sph                    ");
		sb.append(",JT_GoodsInfo.B_GI_SphUL                  ");
		sb.append(",JT_GoodsInfo.B_GI_SphUP                  ");
		sb.append(",JT_GoodsInfo.B_GI_Cyl                    ");
		sb.append(",JT_GoodsInfo.B_GI_CylUL                  ");
		sb.append(",JT_GoodsInfo.B_GI_CylUP                  ");
		sb.append(",JT_GoodsInfo.B_GI_BelowPlusLuminosity    ");
		sb.append(",JT_GoodsInfo.B_GI_BelowPlusLuminosityUL  ");
		sb.append(",JT_GoodsInfo.B_GI_BelowPlusLuminosityUP  ");
		sb.append(",JT_GoodsInfo.B_GI_Axis                   ");
		sb.append(",JT_GoodsInfo.B_GI_AxisUL                 ");
		sb.append(",JT_GoodsInfo.B_GI_AxisUP                 ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature1             ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature1UL           ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature1UP           ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature2             ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature2UL           ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature2UP           ");
		sb.append(",JT_GoodsInfo.B_GI_Dia                    ");
		sb.append(",JT_GoodsInfo.B_GI_DiaUL                  ");
		sb.append(",JT_GoodsInfo.B_GI_DiaUP                  ");
		sb.append(",JT_GoodsInfo.B_GI_isMutiLuminosity       ");
		sb.append(",JT_GoodsInfo.B_GI_MutiLuminosityNum      ");
		sb.append(",JT_GoodsInfo.B_GI_MutiLuminosityAddPrice ");
		sb.append(",JT_GoodsInfo.B_GI_EyeGlassMaterialType   ");
		sb.append(",JT_GoodsInfo.B_GI_isPlating              ");
		sb.append(",JT_GoodsInfo.B_GI_orderCycle             ");
		sb.append(",JT_GoodsInfo.B_GI_FinishedGlassesType    ");
		sb.append(",JT_GoodsInfo.B_GI_frameProcessCraftType  ");
		sb.append(",JT_GoodsInfo.B_GI_CylMin                 ");
		sb.append(",JT_GoodsInfo.B_GI_CylDegreeIncrease      ");
		sb.append(",JT_GoodsInfo.B_GI_CylMinAddPrice         ");
		sb.append(",JT_GoodsInfo.B_GI_CylAddPrice            ");
		sb.append(",JT_GoodsInfo.B_GI_PrismAddPrice          ");
		sb.append(",JT_GoodsInfo.B_GI_cyl25CanNotDo          ");
		sb.append(",JT_GoodsInfo.B_GI_ThrowingCycle          ");
		sb.append(",JT_GoodsInfo.B_GI_StealthType            ");
		sb.append(",JT_GoodsInfo.B_GI_OtherGoodsBigClass     ");
		sb.append(",JT_GoodsInfo.B_GI_OtherGoodsSmallClass   ");
		sb.append(",JT_GoodsInfo.B_GI_Flag                   ");
		sb.append(",JT_GoodsInfo.B_GI_Refractive             ");
		sb.append(",JT_GoodsInfo.B_GI_FrameMaterialType      ");
		sb.append(",JT_GoodsInfo.B_GI_AverageNotTaxRate      ");
		sb.append(",JT_GoodsInfo.B_GI_ReturnMax              ");
		sb.append(",JT_GoodsInfo.B_GI_ReturnMin              ");
		sb.append(",JT_GoodsInfo.B_GI_WholesalePrice         ");
		sb.append(",JT_GoodsInfo.B_GI_FrameSize              ");
		sb.append(",JT_GoodsInfo.B_GI_MaterialClass          ");
		sb.append(",JT_GoodsInfo.B_GI_LuminosityClass        ");
		sb.append(",JT_GoodsInfo.B_GI_GradualClass           ");
		sb.append(",JT_GoodsInfo.B_GI_FunctionClass          ");
		sb.append(",JT_GoodsInfo.B_GI_UseType                ");
		sb.append(",JT_GoodsInfo.B_GI_StealthClass           ");
		sb.append(",JT_GoodsInfo.B_GI_Capacity               ");
		sb.append(",JT_GoodsInfo.B_GI_CapacityEntry          ");
		sb.append(",JT_GoodsInfo.B_GI_AccessoriesType        ");
		sb.append(",JT_GoodsInfo.B_GI_SupplierColor          ");
		sb.append(",JT_GoodsInfo.B_GI_SunGglassesFun         ");
		sb.append(",JT_GoodsInfo.B_GI_FirstInStorageDate     ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceA           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceB           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceC           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceD           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceE           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceF           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceG           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceH           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceI           ");
		sb.append(",JT_GoodsInfo.B_GI_WholeGoodsIsable       ");
		sb.append(",JT_GoodsInfo.B_GI_BrandYear              ");
		sb.append(",JT_GoodsInfo.B_GI_ChineseColor           ");
		sb.append(",JT_GoodsInfo.B_GI_SupplierSpec           ");
		sb.append(",JT_GoodsInfo.B_GI_ViewGoodsName          ");
		sb.append(",JT_GoodsInfo.B_GI_Vsph                   ");
		sb.append(",JT_GoodsInfo.B_GI_Vcyl                   ");
		sb.append(",JT_GoodsInfo.B_GI_DefaultDiscountValue   ");
		sb.append(",JT_GoodsInfo.B_GI_Numberofdays           ");
		sb.append(",JT_GoodsInfo.B_GI_ContactType            ");
		sb.append(",JT_GoodsInfo.B_GI_BarCodeFlag            ");
		sb.append(",JT_GoodsInfo.B_GI_UnionSphCyl            ");
		sb.append(",JT_GoodsInfo.B_GI_FrameStyle             ");
		sb.append(",JT_GoodsInfo.B_GI_LastInStorageDate      ");
		sb.append(",JT_GoodsInfo.B_GI_ContactTypeD           ");
		sb.append(",JT_GoodsInfo.B_GI_ContactTypeY           ");
		sb.append(",JT_GoodsInfo.B_GI_DropMin                ");
		sb.append(",JT_GoodsInfo.B_GI_DropMax                ");
		sb.append(",JT_GoodsInfo.B_GI_StealthCustomizeType   ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsInfo) JT_GoodsInfo    ");
		
		sb.append("where JT_GoodsInfo.B_GI_GoodsID = ?          ");
		params.add(po.getBgigoodsid());


		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取集团端区域下指定供应商下品牌的商品插入医院端商品表
	 * @param po
	 * @return
	 */
	public void insertCompanyGoodsPos(BrandPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("insert into B_GoodsInfo(                  ");
		sb.append(" B_GI_GoodsID                             ");
		sb.append(",B_GI_GoodsBarCode                        ");
		sb.append(",B_GI_GoodsName                           ");
		sb.append(",B_GI_GoodsCategoryID                     ");
		sb.append(",B_GI_SupplierID                          ");
		sb.append(",B_GI_BrandID                             ");
		sb.append(",B_GI_UnitId                              ");
		sb.append(",B_GI_RetailPrice                         ");
		sb.append(",B_GI_CostPrice                           ");
		sb.append(",B_GI_NotTaxRate                          ");
		sb.append(",B_GI_TaxRate                             ");
		sb.append(",B_GI_Spec                                ");
		sb.append(",B_GI_Color                               ");
		sb.append(",B_GI_isCustomize                         ");
		sb.append(",B_GI_Sph                                 ");
		sb.append(",B_GI_SphUL                               ");
		sb.append(",B_GI_SphUP                               ");
		sb.append(",B_GI_Cyl                                 ");
		sb.append(",B_GI_CylUL                               ");
		sb.append(",B_GI_CylUP                               ");
		sb.append(",B_GI_BelowPlusLuminosity                 ");
		sb.append(",B_GI_BelowPlusLuminosityUL               ");
		sb.append(",B_GI_BelowPlusLuminosityUP               ");
		sb.append(",B_GI_Axis                                ");
		sb.append(",B_GI_AxisUL                              ");
		sb.append(",B_GI_AxisUP                              ");
		sb.append(",B_GI_Curvature1                          ");
		sb.append(",B_GI_Curvature1UL                        ");
		sb.append(",B_GI_Curvature1UP                        ");
		sb.append(",B_GI_Curvature2                          ");
		sb.append(",B_GI_Curvature2UL                        ");
		sb.append(",B_GI_Curvature2UP                        ");
		sb.append(",B_GI_Dia                                 ");
		sb.append(",B_GI_DiaUL                               ");
		sb.append(",B_GI_DiaUP                               ");
		sb.append(",B_GI_isMutiLuminosity                    ");
		sb.append(",B_GI_MutiLuminosityNum                   ");
		sb.append(",B_GI_MutiLuminosityAddPrice              ");
		sb.append(",B_GI_EyeGlassMaterialType                ");
		sb.append(",B_GI_isPlating                           ");
		sb.append(",B_GI_orderCycle                          ");
		sb.append(",B_GI_FinishedGlassesType                 ");
		sb.append(",B_GI_frameProcessCraftType               ");
		sb.append(",B_GI_CylMin                              ");
		sb.append(",B_GI_CylDegreeIncrease                   ");
		sb.append(",B_GI_CylMinAddPrice                      ");
		sb.append(",B_GI_CylAddPrice                         ");
		sb.append(",B_GI_PrismAddPrice                       ");
		sb.append(",B_GI_cyl25CanNotDo                       ");
		sb.append(",B_GI_ThrowingCycle                       ");
		sb.append(",B_GI_StealthType                         ");
		sb.append(",B_GI_OtherGoodsBigClass                  ");
		sb.append(",B_GI_OtherGoodsSmallClass                ");
		sb.append(",B_GI_Flag                                ");
		sb.append(",B_GI_Refractive                          ");
		sb.append(",B_GI_FrameMaterialType                   ");
		sb.append(",B_GI_AverageNotTaxRate                   ");
		sb.append(",B_GI_ReturnMax                           ");
		sb.append(",B_GI_ReturnMin                           ");
		sb.append(",B_GI_WholesalePrice                      ");
		sb.append(",B_GI_FrameSize                           ");
		sb.append(",B_GI_MaterialClass                       ");
		sb.append(",B_GI_LuminosityClass                     ");
		sb.append(",B_GI_GradualClass                        ");
		sb.append(",B_GI_FunctionClass                       ");
		sb.append(",B_GI_UseType                             ");
		sb.append(",B_GI_StealthClass                        ");
		sb.append(",B_GI_Capacity                            ");
		sb.append(",B_GI_CapacityEntry                       ");
		sb.append(",B_GI_AccessoriesType                     ");
		sb.append(",B_GI_SupplierColor                       ");
		sb.append(",B_GI_SunGglassesFun                      ");
		sb.append(",B_GI_FirstInStorageDate                  ");
		sb.append(",B_GI_RetailPriceA                        ");
		sb.append(",B_GI_RetailPriceB                        ");
		sb.append(",B_GI_RetailPriceC                        ");
		sb.append(",B_GI_RetailPriceD                        ");
		sb.append(",B_GI_RetailPriceE                        ");
		sb.append(",B_GI_RetailPriceF                        ");
		sb.append(",B_GI_RetailPriceG                        ");
		sb.append(",B_GI_RetailPriceH                        ");
		sb.append(",B_GI_RetailPriceI                        ");
		sb.append(",B_GI_WholeGoodsIsable                    ");
		sb.append(",B_GI_BrandYear                           ");
		sb.append(",B_GI_ChineseColor                        ");
		sb.append(",B_GI_SupplierSpec                        ");
		sb.append(",B_GI_ViewGoodsName                       ");
		sb.append(",B_GI_Vsph                                ");
		sb.append(",B_GI_Vcyl                                ");
		sb.append(",B_GI_DefaultDiscountValue                ");
		sb.append(",B_GI_Numberofdays                        ");
		sb.append(",B_GI_ContactType                         ");
		sb.append(",B_GI_BarCodeFlag                         ");
		sb.append(",B_GI_UnionSphCyl                         ");
		sb.append(",B_GI_FrameStyle                          ");
		sb.append(",B_GI_LastInStorageDate                   ");
		sb.append(",B_GI_ContactTypeD                        ");
		sb.append(",B_GI_ContactTypeY                        ");
		sb.append(",B_GI_DropMin                             ");
		sb.append(",B_GI_DropMax                             ");
		sb.append(",B_GI_StealthCustomizeType)               ");
		sb.append("select                                    ");
		sb.append(" JT_GoodsInfo.B_GI_GoodsID                ");
		sb.append(",JT_GoodsInfo.B_GI_GoodsBarCode           ");
		sb.append(",JT_GoodsInfo.B_GI_GoodsName              ");
		sb.append(",JT_GoodsInfo.B_GI_GoodsCategoryID        ");
		sb.append(",JT_GoodsInfo.B_GI_SupplierID             ");
		sb.append(",JT_GoodsInfo.B_GI_BrandID                ");
		sb.append(",JT_GoodsInfo.B_GI_UnitId                 ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPrice            ");
		sb.append(",JT_GoodsInfo.B_GI_CostPrice              ");
		sb.append(",JT_GoodsInfo.B_GI_NotTaxRate             ");
		sb.append(",JT_GoodsInfo.B_GI_TaxRate                ");
		sb.append(",JT_GoodsInfo.B_GI_Spec                   ");
		sb.append(",JT_GoodsInfo.B_GI_Color                  ");
		sb.append(",JT_GoodsInfo.B_GI_isCustomize            ");
		sb.append(",JT_GoodsInfo.B_GI_Sph                    ");
		sb.append(",JT_GoodsInfo.B_GI_SphUL                  ");
		sb.append(",JT_GoodsInfo.B_GI_SphUP                  ");
		sb.append(",JT_GoodsInfo.B_GI_Cyl                    ");
		sb.append(",JT_GoodsInfo.B_GI_CylUL                  ");
		sb.append(",JT_GoodsInfo.B_GI_CylUP                  ");
		sb.append(",JT_GoodsInfo.B_GI_BelowPlusLuminosity    ");
		sb.append(",JT_GoodsInfo.B_GI_BelowPlusLuminosityUL  ");
		sb.append(",JT_GoodsInfo.B_GI_BelowPlusLuminosityUP  ");
		sb.append(",JT_GoodsInfo.B_GI_Axis                   ");
		sb.append(",JT_GoodsInfo.B_GI_AxisUL                 ");
		sb.append(",JT_GoodsInfo.B_GI_AxisUP                 ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature1             ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature1UL           ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature1UP           ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature2             ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature2UL           ");
		sb.append(",JT_GoodsInfo.B_GI_Curvature2UP           ");
		sb.append(",JT_GoodsInfo.B_GI_Dia                    ");
		sb.append(",JT_GoodsInfo.B_GI_DiaUL                  ");
		sb.append(",JT_GoodsInfo.B_GI_DiaUP                  ");
		sb.append(",JT_GoodsInfo.B_GI_isMutiLuminosity       ");
		sb.append(",JT_GoodsInfo.B_GI_MutiLuminosityNum      ");
		sb.append(",JT_GoodsInfo.B_GI_MutiLuminosityAddPrice ");
		sb.append(",JT_GoodsInfo.B_GI_EyeGlassMaterialType   ");
		sb.append(",JT_GoodsInfo.B_GI_isPlating              ");
		sb.append(",JT_GoodsInfo.B_GI_orderCycle             ");
		sb.append(",JT_GoodsInfo.B_GI_FinishedGlassesType    ");
		sb.append(",JT_GoodsInfo.B_GI_frameProcessCraftType  ");
		sb.append(",JT_GoodsInfo.B_GI_CylMin                 ");
		sb.append(",JT_GoodsInfo.B_GI_CylDegreeIncrease      ");
		sb.append(",JT_GoodsInfo.B_GI_CylMinAddPrice         ");
		sb.append(",JT_GoodsInfo.B_GI_CylAddPrice            ");
		sb.append(",JT_GoodsInfo.B_GI_PrismAddPrice          ");
		sb.append(",JT_GoodsInfo.B_GI_cyl25CanNotDo          ");
		sb.append(",JT_GoodsInfo.B_GI_ThrowingCycle          ");
		sb.append(",JT_GoodsInfo.B_GI_StealthType            ");
		sb.append(",JT_GoodsInfo.B_GI_OtherGoodsBigClass     ");
		sb.append(",JT_GoodsInfo.B_GI_OtherGoodsSmallClass   ");
		sb.append(",JT_GoodsInfo.B_GI_Flag                   ");
		sb.append(",JT_GoodsInfo.B_GI_Refractive             ");
		sb.append(",JT_GoodsInfo.B_GI_FrameMaterialType      ");
		sb.append(",JT_GoodsInfo.B_GI_AverageNotTaxRate      ");
		sb.append(",JT_GoodsInfo.B_GI_ReturnMax              ");
		sb.append(",JT_GoodsInfo.B_GI_ReturnMin              ");
		sb.append(",JT_GoodsInfo.B_GI_WholesalePrice         ");
		sb.append(",JT_GoodsInfo.B_GI_FrameSize              ");
		sb.append(",JT_GoodsInfo.B_GI_MaterialClass          ");
		sb.append(",JT_GoodsInfo.B_GI_LuminosityClass        ");
		sb.append(",JT_GoodsInfo.B_GI_GradualClass           ");
		sb.append(",JT_GoodsInfo.B_GI_FunctionClass          ");
		sb.append(",JT_GoodsInfo.B_GI_UseType                ");
		sb.append(",JT_GoodsInfo.B_GI_StealthClass           ");
		sb.append(",JT_GoodsInfo.B_GI_Capacity               ");
		sb.append(",JT_GoodsInfo.B_GI_CapacityEntry          ");
		sb.append(",JT_GoodsInfo.B_GI_AccessoriesType        ");
		sb.append(",JT_GoodsInfo.B_GI_SupplierColor          ");
		sb.append(",JT_GoodsInfo.B_GI_SunGglassesFun         ");
		sb.append(",JT_GoodsInfo.B_GI_FirstInStorageDate     ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceA           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceB           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceC           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceD           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceE           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceF           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceG           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceH           ");
		sb.append(",JT_GoodsInfo.B_GI_RetailPriceI           ");
		sb.append(",JT_GoodsInfo.B_GI_WholeGoodsIsable       ");
		sb.append(",JT_GoodsInfo.B_GI_BrandYear              ");
		sb.append(",JT_GoodsInfo.B_GI_ChineseColor           ");
		sb.append(",JT_GoodsInfo.B_GI_SupplierSpec           ");
		sb.append(",JT_GoodsInfo.B_GI_ViewGoodsName          ");
		sb.append(",JT_GoodsInfo.B_GI_Vsph                   ");
		sb.append(",JT_GoodsInfo.B_GI_Vcyl                   ");
		sb.append(",JT_GoodsInfo.B_GI_DefaultDiscountValue   ");
		sb.append(",JT_GoodsInfo.B_GI_Numberofdays           ");
		sb.append(",JT_GoodsInfo.B_GI_ContactType            ");
		sb.append(",JT_GoodsInfo.B_GI_BarCodeFlag            ");
		sb.append(",JT_GoodsInfo.B_GI_UnionSphCyl            ");
		sb.append(",JT_GoodsInfo.B_GI_FrameStyle             ");
		sb.append(",JT_GoodsInfo.B_GI_LastInStorageDate      ");
		sb.append(",JT_GoodsInfo.B_GI_ContactTypeD           ");
		sb.append(",JT_GoodsInfo.B_GI_ContactTypeY           ");
		sb.append(",JT_GoodsInfo.B_GI_DropMin                ");
		sb.append(",JT_GoodsInfo.B_GI_DropMax                ");
		sb.append(",JT_GoodsInfo.B_GI_StealthCustomizeType   ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsInfo) JT_GoodsInfo    ");
		sb.append("left join B_GoodsInfo JM_GoodsInfo on JM_GoodsInfo.B_GI_GoodsID = JT_GoodsInfo.B_GI_GoodsID    ");
		sb.append("where JT_GoodsInfo.B_GI_SupplierID = ?          ");
		sb.append("  and isnull(JM_GoodsInfo.B_GI_SupplierID,'') = ''          ");
		params.add(po.getBbdsupplierid());
		sb.append("  and JT_GoodsInfo.B_GI_BrandID in( ");
		String paramStr = "";
		for (int i = 0; i < po.getBbdids().length; i++) {
			if(!"".equals(po.getBbdids()[i])){
				paramStr = paramStr + "?,";
				params.add(po.getBbdids()[i]);
			}
		}

		sb.append(paramStr.replaceFirst(",$", ""));
		sb.append(")      ");
		sb.append("  and isnull(JM_GoodsInfo.B_GI_BrandID,'') = ''    ");

		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取所有集团端所有区域
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionList(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select  ");
		sb.append("	J_R_ID 					as fcnjrid,  			");
		sb.append("	J_R_Name 				as fcnjrname  			");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.J_Region) JT_Region  	");
		
		return  queryForObjectList(sb.toString(),params.toArray(),CompanyNamePo.class);
	}
	
	/**
	 * 获取所有集团端所有公司
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyList(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("select  ");
		sb.append("	F_CN_ID 					as fcnId,  			");
		sb.append("	F_CN_Name 					as fcnName  			");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_CompanyName) JT_CompanyName  	");
		sb.append("where F_CN_RegionID = ?  	");
		
		params.add(po.getFcnjrid());
		
		return  queryForObjectList(sb.toString(),params.toArray(),CompanyNamePo.class);
	}
	
	/**
	 * 下载区域与公司信息及相应绑定关系
	 * @param po
	 * @return
	 */
	public void insertRegionAndCompany(CompanyNamePo po){
		StringBuffer sb = new StringBuffer();	
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_CompanyName ");
		sb.append("( ");
		sb.append(" F_CN_ID                                 ");
		sb.append(",F_CN_Name                               ");
		sb.append(",F_CN_Zone                               ");
		sb.append(",F_CN_Takeglassdata                      ");
		sb.append(",F_CN_Address                            ");
		sb.append(",F_CN_Phone                              ");
		sb.append(",F_CN_Fax                                ");
		sb.append(",F_CN_ReNumber                           ");
		sb.append(",F_CN_Show                               ");
		sb.append(",F_CN_Leftnum                            ");
		sb.append(",F_CN_LoginShow                          ");
		sb.append(",F_CN_ChangeDptShow                      ");
		sb.append(",F_CN_LoginShowFooter                    ");
		sb.append(",F_CN_MasterOrVice                       ");
		sb.append(",F_CN_LegalPerson                        ");
		sb.append(",F_CN_LegalPersonPhone                   ");
		sb.append(",F_CN_ReportShowName                     ");
		sb.append(",F_CN_CompanyType                        ");
		sb.append(",F_CN_WholeSalePrice                     ");
		sb.append(",F_CN_RegionID                           ");
		sb.append(",F_CN_TakeAddress                        ");
		sb.append(",F_CN_TakePerson                         ");
		sb.append(",F_CN_TakePhone                          ");
		sb.append(",F_CN_TakePortraiture                    ");
		sb.append(",F_CN_UUID                    			");
		sb.append(") ");
		sb.append("Select  ");
		sb.append(" F_CN_ID                                 ");
		sb.append(",F_CN_Name                               ");
		sb.append(",F_CN_Zone                               ");
		sb.append(",F_CN_Takeglassdata                      ");
		sb.append(",F_CN_Address                            ");
		sb.append(",F_CN_Phone                              ");
		sb.append(",F_CN_Fax                                ");
		sb.append(",F_CN_ReNumber                           ");
		sb.append(",F_CN_Show                               ");
		sb.append(",F_CN_Leftnum                            ");
		sb.append(",F_CN_LoginShow                          ");
		sb.append(",F_CN_ChangeDptShow                      ");
		sb.append(",F_CN_LoginShowFooter                    ");
		sb.append(",F_CN_MasterOrVice                       ");
		sb.append(",F_CN_LegalPerson                        ");
		sb.append(",F_CN_LegalPersonPhone                   ");
		sb.append(",F_CN_ReportShowName                     ");
		sb.append(",F_CN_CompanyType                        ");
		sb.append(",F_CN_WholeSalePrice                     ");
		sb.append(",?                          	 			");
		sb.append(",F_CN_TakeAddress                        ");
		sb.append(",F_CN_TakePerson                         ");
		sb.append(",F_CN_TakePhone                          ");
		sb.append(",F_CN_TakePortraiture                    ");
		sb.append(",?                    					");
		sb.append("	From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.F_CompanyName) JT_CompanyName ");
		sb.append("	Where F_CN_ID = ? ");
		
		params.add(po.getFcnjrid());
		params.add(this.uuid.generate());
		params.add(po.getFcnId());
		
		sb.append("insert into J_Region ");
		sb.append("( ");
		sb.append(" J_R_ID                                 ");
		sb.append(",J_R_Name                               ");
		sb.append(") ");
		sb.append("Select  ");
		sb.append(" J_R_ID                                 ");
		sb.append(",J_R_Name                               ");
		sb.append("	From openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.J_Region) JT_Region ");
		sb.append("	Where J_R_ID = ? ");
		
		params.add(po.getFcnjrid());
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取下载集团端商品信息数量
	 * @param po
	 * @return
	 */
	public int getDownloadGoodsInfoCount(GoodsInfoPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(B_GI_GoodsID) ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsInfo) JT_B_GoodsInfo ");
		sb.append(" where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
		    sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
		    sb.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getBgisupplierid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
		    sb.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getBgibrandid()));	
		}	
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
		    sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
		    sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));	
		}	
		
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))){
		    sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgisupplierspec()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolor()))){
		    sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgisuppliercolor()));	
		}		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 获取所有集团端所有公司
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> getDownloadGoodsInfoList(GoodsInfoPo po, int start,int size) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT temp.bgigoodsid        	 AS bgigoodsid, ");
		sb.append(" temp.bgiviewgoodsname  			 AS bgiviewgoodsname, ");
		sb.append(" temp.bgispec  					 AS bgispec, ");
		sb.append(" temp.bgisuppliername  			 AS bgisuppliername, ");
		sb.append(" temp.bgibrandname  				 AS bgibrandname, ");
		sb.append(" temp.isdownload  				 AS isdownload ");
		sb.append("	FROM  (SELECT Row_number() OVER(ORDER BY JT_B_GoodsInfo.B_GI_GoodsID) AS rowNum, ");
		sb.append(" JT_B_GoodsInfo.B_GI_GoodsID  AS bgigoodsid, ");
		sb.append(" JT_B_GoodsInfo.B_GI_ViewGoodsName  AS bgiviewgoodsname, ");
		sb.append(" B_SP_SupplierName  	AS bgisuppliername, ");
		sb.append(" B_BD_brandName  	AS bgibrandname, ");
		sb.append(" JT_B_GoodsInfo.B_GI_Spec  AS bgispec, ");
		sb.append("	case  ");
		sb.append("		when isnull(goodsInfo.B_GI_GoodsID,'')  = '' then '0'  ");
		sb.append("		when isnull(goodsInfo.B_GI_GoodsID,'') <> '' then '1'  ");
		sb.append("	end as isdownload ");
		sb.append("from openrowset('SQLOLEDB','"+ip+"'; '"+user+"'; '"+pwd+"',aierjt.dbo.B_GoodsInfo) JT_B_GoodsInfo ");
		sb.append(" left join B_GoodsInfo goodsInfo on goodsInfo.B_GI_GoodsID= JT_B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" left join B_Supplier on B_SP_ID= JT_B_GoodsInfo.B_GI_SupplierID ");
		sb.append(" left join B_Brand on B_BD_SupplierID= JT_B_GoodsInfo.B_GI_SupplierID and B_BD_ID = JT_B_GoodsInfo.B_GI_BrandID ");
		sb.append(" where 1=1 ");
		
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
		    sb.append(" and JT_B_GoodsInfo.B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
		    sb.append(" and JT_B_GoodsInfo.B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getBgisupplierid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
		    sb.append(" and JT_B_GoodsInfo.B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getBgibrandid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
		    sb.append(" and  JT_B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
		    sb.append(" and  JT_B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));	
		}	
		
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))){
		    sb.append(" and JT_B_GoodsInfo.B_GI_SupplierSpec like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgisupplierspec()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolor()))){
		    sb.append(" and JT_B_GoodsInfo.B_GI_SupplierColor like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgisuppliercolor()));	
		}		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
}
