package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.FittingTemplateDao;
import com.pengsheng.eims.basic.persistence.FittingTemplatePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class FittingTemplateDaoImpl extends BaseJdbcDaoSupport implements FittingTemplateDao {


	/**
	 *  查询打印单据样式总数
	 */
	public int getPrintBillTemplateCount(FittingTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(B_FT_ID) from B_FittingTemplate left join SYS_PersonInfo on B_FT_PersonID = id ");
		buffer.append(" where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBftbgndate()))) {
			buffer.append(" and convert(varchar(10),B_FT_Date,120) >= ?  ");
			params.add(Utility.getName(po.getBftbgndate()));
		}
		if (!"".equals(Utility.getName(po.getBftenddate()))) {
			buffer.append(" and convert(varchar(10),B_FT_Date,120) <= ?  ");
			params.add(Utility.getName(po.getBftenddate()));
		}
		if (!"".equals(Utility.getName(po.getBftpersonid()))) {
			buffer.append(" and B_FT_PersonID = ?  ");
			params.add(Utility.getName(po.getBftpersonid()));
		}
		if (!"".equals(Utility.getName(po.getBfttype()))) {
			buffer.append(" and B_FT_Type = ?  ");
			params.add(Utility.getName(po.getBfttype()));
		}
		if (!"".equals(Utility.getName(po.getBftcurrentflag()))) {
			buffer.append(" and B_FT_CurrentFlag = ?  ");
			params.add(Utility.getName(po.getBftcurrentflag()));
		}
		if (!"".equals(Utility.getName(po.getBftflag()))) {
			buffer.append(" and B_FT_Flag = ?  ");
			params.add(Utility.getName(po.getBftflag()));
		}
		if (!"".equals(Utility.getName(po.getBfttemplatename()))) {
			buffer.append(" and B_FT_TemplateName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getBfttemplatename()));
		}
		if (!"".equals(Utility.getName(po.getBftserver()))) {
			buffer.append(" and B_FT_Server = ?  ");
			params.add(Utility.getName(po.getBftserver()));
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
		
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by convert(varchar(16),B_FT_Date,120) desc) as 'rowNum', ");
		buffer.append("B_FT_ID as bftid ");
		buffer.append(",convert(varchar(16),B_FT_Date,120) as bftdate ");
		buffer.append(",B_FT_Flag as bftflag, ");
		buffer.append("B_FT_Type as bfttype, ");
		buffer.append("B_FT_Rmark as bftremark, ");
		buffer.append("B_FT_CurrentFlag as bftcurrentflag, ");
		buffer.append("personname as bftpersonname,B_FT_TemplateName as bfttemplatename,B_FT_Server as bftserver ");
		buffer.append(" from B_FittingTemplate left join SYS_PersonInfo on B_FT_PersonID = id ");
		buffer.append(" where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBftbgndate()))) {
			buffer.append(" and convert(varchar(10),B_FT_Date,120) >= ?  ");
			params.add(Utility.getName(po.getBftbgndate()));
		}
		if (!"".equals(Utility.getName(po.getBftenddate()))) {
			buffer.append(" and convert(varchar(10),B_FT_Date,120) <= ?  ");
			params.add(Utility.getName(po.getBftenddate()));
		}
		if (!"".equals(Utility.getName(po.getBftpersonid()))) {
			buffer.append(" and B_FT_PersonID = ?  ");
			params.add(Utility.getName(po.getBftpersonid()));
		}
		if (!"".equals(Utility.getName(po.getBfttype()))) {
			buffer.append(" and B_FT_Type = ?  ");
			params.add(Utility.getName(po.getBfttype()));
		}
		if (!"".equals(Utility.getName(po.getBftcurrentflag()))) {
			buffer.append(" and B_FT_CurrentFlag = ?  ");
			params.add(Utility.getName(po.getBftcurrentflag()));
		}
		if (!"".equals(Utility.getName(po.getBftflag()))) {
			buffer.append(" and B_FT_Flag = ?  ");
			params.add(Utility.getName(po.getBftflag()));
		}
		if (!"".equals(Utility.getName(po.getBfttemplatename()))) {
			buffer.append(" and B_FT_TemplateName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getBfttemplatename()));
		}
		if (!"".equals(Utility.getName(po.getBftserver()))) {
			buffer.append(" and B_FT_Server = ?  ");
			params.add(Utility.getName(po.getBftserver()));
		}		
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), FittingTemplatePo.class);
	}
	
	/**
	 *  查询打印单据样式信息
	 */
	public FittingTemplatePo getPrintBillTemplateDetail(FittingTemplatePo po){		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 B_FT_ID as bftid ");
		buffer.append(",convert(varchar(16),B_FT_Date,120) as bftdate ");
		buffer.append(",B_FT_Flag as bftflag,B_FT_FIleUrl as bftfileurl,B_FT_Logo as bftlogo, ");
		buffer.append("B_FT_Type as bfttype, ");
		buffer.append("B_FT_Rmark as bftremark, ");
		buffer.append("B_FT_CurrentFlag as bftcurrentflag, ");
		buffer.append("personname as bftpersonname,B_FT_TemplateName as bfttemplatename,B_FT_FileName as bftfilename,B_FT_Server as bftserver ");
		buffer.append(" from B_FittingTemplate left join SYS_PersonInfo on B_FT_PersonID = id ");
		buffer.append(" where B_FT_ID=? ");
		
		params.add(Utility.getName(po.getBftid()));
		
		return (FittingTemplatePo) this.queryForObject(buffer.toString(), params.toArray(), FittingTemplatePo.class);
	}
	
	/**
	 *  新增打印单据样式
	 */
	public void insertPrintBillTemplate(FittingTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_FittingTemplate(B_FT_ID,B_FT_Date,B_FT_PersonID,B_FT_FileName,B_FT_FIleUrl,B_FT_Flag,B_FT_Rmark,B_FT_Type,B_FT_CurrentFlag,B_FT_Logo,B_FT_TemplateName,B_FT_Server) values(?,getdate(),?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getBftpersonid()));
		params.add(Utility.getName(po.getBftfilename()));
		params.add(Utility.getName(po.getBftfileurl()));
		params.add(Utility.getName(po.getBftflag()));
		params.add(Utility.getName(po.getBftremark()));
		params.add(Utility.getName(po.getBfttype()));
		params.add(Utility.getName(po.getBftcurrentflag()));
		params.add(Utility.getName(po.getBftlogo()));
		params.add(Utility.getName(po.getBfttemplatename()));
		params.add(Utility.getName(po.getBftserver()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  修改打印单据样式
	 */
	public void updatePrintBillTemplate(FittingTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update B_FittingTemplate set B_FT_TemplateName = ?  ");

		params.add(Utility.getName(po.getBfttemplatename()));
		if (!"".equals(Utility.getName(po.getBftcurrentflag()))) {
			buffer.append(" ,B_FT_CurrentFlag = ?  ");
			params.add(Utility.getName(po.getBftcurrentflag()));
		}
		if (!"".equals(Utility.getName(po.getBftflag()))) {
			buffer.append(" ,B_FT_Flag = ?  ");
			params.add(Utility.getName(po.getBftflag()));
		}
		if (!"".equals(Utility.getName(po.getBftremark()))) {
			buffer.append(" ,B_FT_Rmark = ?  ");
			params.add(Utility.getName(po.getBftremark()));
		}
		if (!"".equals(Utility.getName(po.getBftfilename()))) {
			buffer.append(" ,B_FT_FileName = ?  ");
			params.add(Utility.getName(po.getBftfilename()));
		}
		if (!"".equals(Utility.getName(po.getBftfileurl()))) {
			buffer.append(" ,B_FT_FIleUrl = ?  ");
			params.add(Utility.getName(po.getBftfileurl()));
		}
		if (!"".equals(Utility.getName(po.getBftlogo()))) {
			buffer.append(" ,B_FT_Logo = ?  ");
			params.add(Utility.getName(po.getBftlogo()));
		}
		if (!"".equals(Utility.getName(po.getBfttype()))) {
			buffer.append(" ,B_FT_Type = ?  ");
			params.add(Utility.getName(po.getBfttype()));
		}	
		if (!"".equals(Utility.getName(po.getBftserver()))) {
			buffer.append(" ,B_FT_Server = ?  ");
			params.add(Utility.getName(po.getBftserver()));
		}	
		
		buffer.append(" where B_FT_ID = ?  ");
		params.add(Utility.getName(po.getBftid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  删除打印单据样式
	 */
	public void deletePrintBillTemplate(FittingTemplatePo po){		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete top (1) from B_FittingTemplate where B_FT_ID = ? ");
		
		params.add(Utility.getName(po.getBftid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  停用启用打印单据样式
	 */
	public void updatePrintBillTemplateEnable(FittingTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) B_FittingTemplate set B_FT_Flag=? where B_FT_ID = ? ");
		
		params.add(Utility.getName(po.getBftflag()));
		params.add(Utility.getName(po.getBftid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select B_FT_ID as bftid ");
		buffer.append(",convert(varchar(16),B_FT_Date,120) as bftdate ");
		buffer.append(",B_FT_Flag as bftflag,B_FT_FIleUrl as bftfileurl,B_FT_Logo as bftlogo, ");
		buffer.append("B_FT_Type as bfttype, ");
		buffer.append("B_FT_Rmark as bftremark, ");
		buffer.append("B_FT_CurrentFlag as bftcurrentflag, ");
		buffer.append("personname as bftpersonname,B_FT_TemplateName as bfttemplatename,B_FT_FileName as bftfilename,B_FT_Server as bftserver ");
		buffer.append(" from B_FittingTemplate left join SYS_PersonInfo on B_FT_PersonID = id ");
		buffer.append(" where B_FT_Flag='1' ");

		if (!"".equals(Utility.getName(po.getBfttype()))) {
			buffer.append(" and B_FT_Type = ?  ");
			params.add(Utility.getName(po.getBfttype()));
		}

		return queryForObjectList(buffer.toString(), params.toArray(), FittingTemplatePo.class);
	}
	
	/**
	 *  修改当前使用的打印单据样式
	 */
	public void updateCurrentUsingTemplateByType(String typeid){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("update B_FittingTemplate set B_FT_CurrentFlag='0' where B_FT_Type = '"+ typeid +"' ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 *  修改当前使用的打印单据样式
	 */
	public void updateCurrentUsingTemplateByid(String id){
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append("update B_FittingTemplate set B_FT_CurrentFlag='1' where B_FT_ID = '"+ id +"' ");

		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 *  查询配置的默认配镜单的模版
	 */
	public List<FittingTemplatePo> getBillTemplateList(){
		
		StringBuffer  buffer = new StringBuffer();
		buffer.append("SELECT b.B_FT_ID                            AS bftid, ");
		buffer.append("       CONVERT(VARCHAR(16), B_FT_Date, 120) AS bftdate, ");
		buffer.append("       B_FT_Flag                            AS bftflag, ");
		buffer.append("       B_FT_FIleUrl                         AS bftfileurl, ");
		buffer.append("       B_FT_Logo                            AS bftlogo, ");
		buffer.append("       B_FT_Type                            AS bfttype, ");
		buffer.append("       B_FT_Rmark                           AS bftremark, ");
		buffer.append("       B_FT_TemplateName                    AS bfttemplatename, ");
		buffer.append("       B_FT_FileName                        AS bftfilename, ");
		buffer.append("       B_FT_Server                          AS bftserver ");
		buffer.append("FROM   B_FittingTemplate_Type a ");
		buffer.append("       LEFT JOIN B_FittingTemplate b ");
		buffer.append("         ON a.B_FT_ID = b.B_FT_ID ");
		buffer.append("WHERE  B_FT_T_ID IN ( '1', '2', '3', '4', '5', '41', '42', '43' ) ");

		return queryForObjectList(buffer.toString(),null, FittingTemplatePo.class);
	}
}
