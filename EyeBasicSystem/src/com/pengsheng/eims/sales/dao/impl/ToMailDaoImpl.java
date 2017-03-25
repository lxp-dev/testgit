package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.dao.ToMailDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ToMailDaoImpl extends BaseJdbcDaoSupport implements ToMailDao{
	
	
	public void updateToMail(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_SE_ToMail SET ");
		buffer.append("       S_SE_TM_CustomerName = ?, ");
		buffer.append("       S_SE_TM_AreaCode = ?, ");
		buffer.append("       S_SE_TM_CustomerPhone = ?, ");
		buffer.append("       S_SE_TM_MaiilAudit = ?, ");
		buffer.append("       S_SE_TM_LinkSalesID = ?, ");
		buffer.append("       S_SE_TM_MaiilAddress = ?, ");
		buffer.append("       S_SE_TM_LinkMan = ?, ");
		buffer.append("       S_SE_TM_ToMailListID = ?, ");
		buffer.append("       S_SE_TM_Provinces = ?, ");	
		buffer.append("       S_SE_TM_City = ?, ");		
		buffer.append("       S_SE_TM_District = ?, ");	
		buffer.append("       S_SE_TM_Street = ?, ");		
		buffer.append("       S_SE_TM_IsSupport = ?, ");	
		buffer.append("       S_SE_TM_SupportValue = ? ");
		buffer.append("WHERE S_SE_TM_UUID = ? ");
		
		params.add(Utility.getName(toMailPo.getSsetmcustomername()));
		params.add(Utility.getName(toMailPo.getSsetmareacode()));
		params.add(Utility.getName(toMailPo.getSsetmcustomerphone()));
		params.add(Utility.getName(toMailPo.getSsetmmaiilaudit()));
		params.add(Utility.getName(toMailPo.getSsetmlinksalesid()));
		params.add(Utility.getName(toMailPo.getSsetmmaiiladdress()));
		params.add(Utility.getName(toMailPo.getSsetmlinkman()));
		params.add(Utility.getName(toMailPo.getSsetmtomaillistid()));
		
		params.add(Utility.getName(toMailPo.getSsetmprovinces()));
		params.add(Utility.getName(toMailPo.getSsetmcity()));
		params.add(Utility.getName(toMailPo.getSsetmdistrict()));
		params.add(Utility.getName(toMailPo.getSsetmstreet()));
		params.add(Utility.getName(toMailPo.getSsetmissupport()));
		params.add(Utility.getName(toMailPo.getSsetmsupportvalue()));
		
		params.add(Utility.getName(toMailPo.getSsetmuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertToMail(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_SE_ToMail ");
		buffer.append("            (S_SE_TM_UUID, ");
		buffer.append("             S_SE_TM_MailID, ");
		buffer.append("             S_SE_TM_CustomerID, ");
		buffer.append("             S_SE_TM_CustomerName, ");
		buffer.append("             S_SE_TM_AreaCode, ");
		buffer.append("             S_SE_TM_CustomerPhone, ");
		buffer.append("             S_SE_TM_MailCompanyName, ");
		buffer.append("             S_SE_TM_MaiilAudit, ");
		buffer.append("             S_SE_TM_LinkSalesID, ");
		buffer.append("             S_SE_TM_MaiilAddress, ");
		buffer.append("             S_SE_TM_CreatePensonID, ");
		buffer.append("             S_SE_TM_CreatePensonName, ");
		buffer.append("             S_SE_TM_LinkMan, ");
		buffer.append("             S_SE_TM_ToMailListID, ");
		buffer.append("             S_SE_TM_CreateDate, ");
		buffer.append("             S_SE_TM_Provinces, ");	
		buffer.append("             S_SE_TM_City, ");		
		buffer.append("             S_SE_TM_District, ");	
		buffer.append("             S_SE_TM_Street, ");		
		buffer.append("             S_SE_TM_IsSupport, ");	
		buffer.append("             S_SE_TM_SupportValue) ");
		
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              getdate(), ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?) ");
		
		params.add(Utility.getName(toMailPo.getSsetmuuid()));
		params.add(Utility.getName(toMailPo.getSsetmmailid()));
		params.add(Utility.getName(toMailPo.getSsetmcustomerid()));
		params.add(Utility.getName(toMailPo.getSsetmcustomername()));
		params.add(Utility.getName(toMailPo.getSsetmareacode()));
		params.add(Utility.getName(toMailPo.getSsetmcustomerphone()));
		params.add(Utility.getName(toMailPo.getSsetmmailcompanyname()));
		
		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			params.add(Utility.getName(toMailPo.getSsetmmaiilaudit()));
		}else{
			params.add("0");
		}
		
		params.add(Utility.getName(toMailPo.getSsetmlinksalesid()));
		params.add(Utility.getName(toMailPo.getSsetmmaiiladdress()));
		params.add(Utility.getName(toMailPo.getSsetmcreatepensonid()));
		params.add(Utility.getName(toMailPo.getSsetmcreatepensonname()));
		params.add(Utility.getName(toMailPo.getSsetmlinkman()));
		params.add(Utility.getName(toMailPo.getSsetmtomaillistid()));
		
		params.add(Utility.getName(toMailPo.getSsetmprovinces()));
		params.add(Utility.getName(toMailPo.getSsetmcity()));
		params.add(Utility.getName(toMailPo.getSsetmdistrict()));
		params.add(Utility.getName(toMailPo.getSsetmstreet()));
		params.add(Utility.getName(toMailPo.getSsetmissupport()));
		params.add(Utility.getName(toMailPo.getSsetmsupportvalue()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateToMailSend(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("Update 		S_SE_ToMail Set ");
		buffer.append("       		S_SE_TM_MailID = ?, ");
		buffer.append("       		S_SE_TM_MailCompanyName = ?, ");
		buffer.append("             S_SE_TM_SendPensonID = ?, ");
		buffer.append("             S_SE_TM_SendPensonName = ?, ");
		buffer.append("             S_SE_TM_LinkMan = ?, ");
		buffer.append("             S_SE_TM_ToMailListID = ?, ");
		buffer.append("             S_SE_TM_SendDate = ?, ");
		buffer.append("             S_SE_TM_Provinces = ?, ");	
		buffer.append("             S_SE_TM_City = ?, ");		
		buffer.append("             S_SE_TM_District = ?, ");	
		buffer.append("             S_SE_TM_Street = ?, ");		
		buffer.append("             S_SE_TM_IsSupport = ?, ");	
		buffer.append("             S_SE_TM_SupportValue = ? ");
		
		buffer.append("Where        S_SE_TM_UUID = ? ");
		
		params.add(Utility.getName(toMailPo.getSsetmmailid()));
		params.add(Utility.getName(toMailPo.getSsetmmailcompanyname()));
		params.add(Utility.getName(toMailPo.getSsetmsendpensonid()));
		params.add(Utility.getName(toMailPo.getSsetmsendpensonname()));
		params.add(Utility.getName(toMailPo.getSsetmlinkman()));
		params.add(Utility.getName(toMailPo.getSsetmtomaillistid()));
		params.add(Utility.getName(toMailPo.getSsetmsenddate()));
		
		params.add(Utility.getName(toMailPo.getSsetmprovinces()));
		params.add(Utility.getName(toMailPo.getSsetmcity()));
		params.add(Utility.getName(toMailPo.getSsetmdistrict()));
		params.add(Utility.getName(toMailPo.getSsetmstreet()));
		params.add(Utility.getName(toMailPo.getSsetmissupport()));
		params.add(Utility.getName(toMailPo.getSsetmsupportvalue()));
		
		params.add(Utility.getName(toMailPo.getSsetmuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public ToMailPo selectToMailPo(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT top 1 S_SE_TM_UUID as ssetmuuid, ");
		buffer.append("       S_SE_TM_MailID as ssetmmailid, ");
		buffer.append("       S_SE_TM_CustomerID as ssetmcustomerid, ");
		buffer.append("       S_ME_CI_MemberId as ssetmmemberid, ");
		buffer.append("       S_SE_TM_CustomerName as ssetmcustomername, ");
		buffer.append("       S_SE_TM_AreaCode as ssetmareacode, ");
		buffer.append("       S_SE_TM_CustomerPhone as ssetmcustomerphone, ");
		buffer.append("       S_SE_TM_MailCompanyName as ssetmmailcompanyname, ");
		buffer.append("       S_SE_TM_MaiilDate as ssetmmaiildate, ");
		buffer.append("       S_SE_TM_MaiilAudit as ssetmmaiilaudit, ");
		buffer.append("       S_SE_TM_LinkSalesID as ssetmlinksalesid, ");
		buffer.append("       S_SE_TM_MaiilAddress as ssetmmaiiladdress, ");
		buffer.append("       S_SE_TM_CreatePensonID as ssetmcreatepensonid, ");
		buffer.append("       S_SE_TM_CreatePensonName as ssetmcreatepensonname , ");
		buffer.append("       S_SE_TM_CreateDate as ssetmcreatedate, ");
		buffer.append("       S_SE_TM_SendPensonID as ssetmsendpensonid, ");
		buffer.append("       S_SE_TM_SendPensonName as ssetmsendpensonname, ");
		buffer.append("       S_SE_TM_LinkMan as ssetmlinkman, ");
		buffer.append("       S_SE_TM_ToMailListID as ssetmtomaillistid, ");
		buffer.append("       B_TML_Name as ssetmtomaillistname, ");
		buffer.append("       B_TML_ReportName as ssetmtoreportname, ");
		buffer.append("       S_SE_TM_SendDate as ssetmsenddate, ");
		buffer.append("       S_SE_TM_Provinces		as	ssetmprovinces       , ");
		buffer.append("       S_SE_TM_City			as	ssetmcity            , ");
		buffer.append("       S_SE_TM_District		as	ssetmdistrict        , ");
		buffer.append("       S_SE_TM_Street		as	ssetmstreet          , ");
		buffer.append("       S_SE_TM_IsSupport		as	ssetmissupport       , ");
		buffer.append("       S_SE_TM_SupportValue	as	ssetmsupportvalue      ");

		buffer.append(" FROM   dbo.S_SE_ToMail ");
		buffer.append(" inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_TM_CustomerID ");
		buffer.append(" left join B_ToMailList on S_SE_TM_ToMailListID=B_TML_ID ");
		buffer.append("WHERE  1=1 ");
		
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmuuid()))){
			buffer.append("	  and S_SE_TM_UUID = ? ");
			params.add(toMailPo.getSsetmuuid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmlinksalesid()))){
			buffer.append("	  and S_SE_TM_LinkSalesID = ? ");
			params.add(toMailPo.getSsetmlinksalesid());
		}
		buffer.append("order by   S_SE_TM_CreateDate desc ");
		
		return (ToMailPo)queryForObject(buffer.toString(), params.toArray(),ToMailPo.class);
	}
	
	
	public int selectToMailPosCount(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT sum(count1) from ( ");
		buffer.append("SELECT count(S_SE_TM_UUID) as count1 ");
		buffer.append("FROM   dbo.S_SE_ToMail ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_TM_CustomerID ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_TM_LinkSalesID = S_SE_SB_SalesID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmlinksalesid()))){
			buffer.append(" and  S_SE_TM_LinkSalesID like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmlinksalesid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmemberid()))){
			buffer.append(" and  S_ME_CI_MemberId like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmemberid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomername()))){
			buffer.append(" and  S_SE_TM_CustomerName like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomername());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomerphone()))){
			buffer.append(" and  S_SE_TM_CustomerPhone like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomerphone());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmailid()))){
			buffer.append(" and  S_SE_TM_MailID like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmailid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmbegintime()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) >= ? ");
			params.add(toMailPo.getSsetmbegintime());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmendtims()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) <= ? ");
			params.add(toMailPo.getSsetmendtims());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			buffer.append(" and  S_SE_TM_MaiilAudit = ? ");
			params.add(toMailPo.getSsetmmaiilaudit());
		}
		
		if(toMailPo.getSsetmshopcode() != null && toMailPo.getSsetmshopcode().size() > 0){
			
			buffer.append(" and S_SE_SB_ShopCode in ( ? ");

			List<DepartmentsPo> dList = toMailPo.getSsetmshopcode();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" union all ");
		buffer.append("SELECT count(S_SE_TM_UUID) as count1 ");
		buffer.append("FROM   dbo.S_SE_ToMail ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_TM_CustomerID ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_TM_LinkSalesID = S_SE_SB_SalesID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmlinksalesid()))){
			buffer.append(" and  S_SE_TM_LinkSalesID like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmlinksalesid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmemberid()))){
			buffer.append(" and  S_ME_CI_MemberId like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmemberid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomername()))){
			buffer.append(" and  S_SE_TM_CustomerName like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomername());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomerphone()))){
			buffer.append(" and  S_SE_TM_CustomerPhone like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomerphone());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmailid()))){
			buffer.append(" and  S_SE_TM_MailID like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmailid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmbegintime()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) >= ? ");
			params.add(toMailPo.getSsetmbegintime());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmendtims()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) <= ? ");
			params.add(toMailPo.getSsetmendtims());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			buffer.append(" and  S_SE_TM_MaiilAudit = ? ");
			params.add(toMailPo.getSsetmmaiilaudit());
		}
		
		if(toMailPo.getSsetmshopcode() != null && toMailPo.getSsetmshopcode().size() > 0){
			
			buffer.append(" and S_SE_SB_ShopCode in ( ? ");

			List<DepartmentsPo> dList = toMailPo.getSsetmshopcode();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	public List<ToMailPo> selectToMailPos(ToMailPo toMailPo, int start, int size){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (  ");
		buffer.append("SELECT ROW_NUMBER() Over(order by ssetmcreatedate desc ) as rowNum ,* from ( select S_SE_TM_UUID as ssetmuuid, ");
		buffer.append("       S_SE_TM_MailID as ssetmmailid, ");
		buffer.append("       S_ME_CI_MemberId as ssetmmemberid, ");
		buffer.append("       S_SE_TM_CustomerName as ssetmcustomername, ");
		buffer.append("       S_SE_TM_CustomerPhone as ssetmcustomerphone, ");
		buffer.append("       S_SE_TM_MailCompanyName as ssetmmailcompanyname, ");
		buffer.append("       S_SE_TM_MaiilDate as ssetmmaiildate, ");
		buffer.append("       S_SE_TM_MaiilAudit as ssetmmaiilaudit, ");
		buffer.append("       S_SE_TM_LinkSalesID as ssetmlinksalesid, ");
		buffer.append("       S_SE_TM_MaiilAddress as ssetmmaiiladdress, ");
		buffer.append("       S_SE_TM_CreatePensonID as ssetmcreatepensonid, ");
		buffer.append("       S_SE_TM_CreatePensonName as ssetmcreatepensonname , ");
		buffer.append("       S_SE_TM_CreateDate as ssetmcreatedate, ");
		buffer.append("       S_SE_TM_SendPensonID as ssetmsendpensonid, ");
		buffer.append("       S_SE_TM_SendPensonName as ssetmsendpensonname, ");
		buffer.append("       S_SE_TM_LinkMan as ssetmlinkman, ");
		buffer.append("       S_SE_TM_SendDate as ssetmsenddate ");
		buffer.append("FROM   dbo.S_SE_ToMail ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_TM_CustomerID ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_TM_LinkSalesID = S_SE_SB_SalesID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmlinksalesid()))){
			buffer.append(" and  S_SE_TM_LinkSalesID like '%' +  ?  + '%'");
			params.add(toMailPo.getSsetmlinksalesid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmemberid()))){
			buffer.append(" and  S_ME_CI_MemberId like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmemberid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomername()))){
			buffer.append(" and  S_SE_TM_CustomerName like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomername());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomerphone()))){
			buffer.append(" and  S_SE_TM_CustomerPhone like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomerphone());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmailid()))){
			buffer.append(" and  S_SE_TM_MailID like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmailid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmbegintime()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) >= ? ");
			params.add(toMailPo.getSsetmbegintime());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmendtims()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) <= ? ");
			params.add(toMailPo.getSsetmendtims());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			buffer.append(" and  S_SE_TM_MaiilAudit = ? ");
			params.add(toMailPo.getSsetmmaiilaudit());
		}
		
		if(toMailPo.getSsetmshopcode() != null && toMailPo.getSsetmshopcode().size() > 0){
			
			buffer.append(" and S_SE_SB_ShopCode in ( ? ");

			List<DepartmentsPo> dList = toMailPo.getSsetmshopcode();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" union all ");		
		buffer.append("   select  S_SE_TM_UUID as ssetmuuid,  S_SE_TM_MailID as ssetmmailid, ");
		buffer.append("       S_ME_CI_MemberId as ssetmmemberid, ");
		buffer.append("       S_SE_TM_CustomerName as ssetmcustomername, ");
		buffer.append("       S_SE_TM_CustomerPhone as ssetmcustomerphone, ");
		buffer.append("       S_SE_TM_MailCompanyName as ssetmmailcompanyname, ");
		buffer.append("       S_SE_TM_MaiilDate as ssetmmaiildate, ");
		buffer.append("       S_SE_TM_MaiilAudit as ssetmmaiilaudit, ");
		buffer.append("       S_SE_TM_LinkSalesID as ssetmlinksalesid, ");
		buffer.append("       S_SE_TM_MaiilAddress as ssetmmaiiladdress, ");
		buffer.append("       S_SE_TM_CreatePensonID as ssetmcreatepensonid, ");
		buffer.append("       S_SE_TM_CreatePensonName as ssetmcreatepensonname , ");
		buffer.append("       S_SE_TM_CreateDate as ssetmcreatedate, ");
		buffer.append("       S_SE_TM_SendPensonID as ssetmsendpensonid, ");
		buffer.append("       S_SE_TM_SendPensonName as ssetmsendpensonname, ");
		buffer.append("       S_SE_TM_LinkMan as ssetmlinkman, ");
		buffer.append("       S_SE_TM_SendDate as ssetmsenddate ");
		buffer.append("FROM   dbo.S_SE_ToMail ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CI_CustomerID = S_SE_TM_CustomerID ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_TM_LinkSalesID = S_SE_SB_SalesID ");
		buffer.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmlinksalesid()))){
			buffer.append(" and  S_SE_TM_LinkSalesID like '%' +  ?  + '%'");
			params.add(toMailPo.getSsetmlinksalesid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmemberid()))){
			buffer.append(" and  S_ME_CI_MemberId like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmemberid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomername()))){
			buffer.append(" and  S_SE_TM_CustomerName like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomername());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmcustomerphone()))){
			buffer.append(" and  S_SE_TM_CustomerPhone like '%' +  ? + '%' ");
			params.add(toMailPo.getSsetmcustomerphone());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmailid()))){
			buffer.append(" and  S_SE_TM_MailID like '%' +  ? + '%'");
			params.add(toMailPo.getSsetmmailid());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmbegintime()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) >= ? ");
			params.add(toMailPo.getSsetmbegintime());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmendtims()))){
			buffer.append(" and  convert(varchar(10),S_SE_TM_SendDate,23) <= ? ");
			params.add(toMailPo.getSsetmendtims());
		}
		
		if(!"".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			buffer.append(" and  S_SE_TM_MaiilAudit = ? ");
			params.add(toMailPo.getSsetmmaiilaudit());
		}
		
		if(toMailPo.getSsetmshopcode() != null && toMailPo.getSsetmshopcode().size() > 0){
			
			buffer.append(" and S_SE_SB_ShopCode in ( ? ");

			List<DepartmentsPo> dList = toMailPo.getSsetmshopcode();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
				
		buffer.append("  ) temp ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		
		return queryForObjectList(buffer.toString(), params.toArray(),ToMailPo.class);
	}
	
	
	
	/**
	 * 销售结帐基表信息数量
	 */
	public int getSalesBasicCount(SalesBasicPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");	
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");	
		buffer.append("from S_SE_SalesBasic ");		
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		buffer.append("  and S_SE_SB_SalesID not in (select S_SE_TM_LinkSalesID from S_SE_ToMail) ");
		
		if(!"".equals(Utility.getName(po.getSsesbcompanyid()))){	//所属公司
			buffer.append("and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));
		}
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}	
		buffer.append(" union all  ");		
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");	
		buffer.append("from S_SE_SalesBasic_Finished ");		
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		buffer.append("  and S_SE_SB_SalesID not in (select S_SE_TM_LinkSalesID from S_SE_ToMail) ");
		
		if(!"".equals(Utility.getName(po.getSsesbcompanyid()))){	//所属公司
			buffer.append("and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));
		}
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}	
		buffer.append(" )t ");		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 遍历销售结帐基表信息
	 */
	public List<SalesBasicPo> getSalesBasicList(SalesBasicPo po, int start,
			int size) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over (order by ssesbtakeglassdata desc) as rowNum,* from ( select * from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid, "); 
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, "); 
		buffer.append("S_ME_CI_Phone as ssesbphone, ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, "); 
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata,  ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue  ");
		buffer.append("from S_SE_SalesBasic  ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		buffer.append("  and S_SE_SB_SalesID not in (select S_SE_TM_LinkSalesID from S_SE_ToMail) ");
		
		if(!"".equals(Utility.getName(po.getSsesbcompanyid()))){	//所属公司
			buffer.append("and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));
		}
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}		
		buffer.append(" union all ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid, "); 
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, "); 
		buffer.append("S_ME_CI_Phone as ssesbphone, ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, "); 
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata,  ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue  ");
		buffer.append("from S_SE_SalesBasic_Finished  ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		buffer.append("  and S_SE_SB_SalesID not in (select S_SE_TM_LinkSalesID from S_SE_ToMail) ");
		
		if(!"".equals(Utility.getName(po.getSsesbcompanyid()))){	//所属公司
			buffer.append("and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getSsesbcompanyid()));
		}
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}	
		
		buffer.append(" ) temp ) temp ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}
	
	public void deleteToMailPo(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		buffer.append("delete 		from S_SE_ToMail ");
		buffer.append("Where        S_SE_TM_UUID = ? ");
		
		params.add(Utility.getName(toMailPo.getSsetmuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateToMailDetail(ToMailPo toMailPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_SE_ToMail SET ");
		buffer.append(" S_SE_TM_MailID = ? ");

		buffer.append(" WHERE S_SE_TM_UUID = ? ");
		
		params.add(Utility.getName(toMailPo.getSsetmmailid()));

		params.add(Utility.getName(toMailPo.getSsetmuuid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public int getComplainSalesBasicCount(SalesBasicPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");	
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");	
		buffer.append("from S_SE_SalesBasic ");		
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}	
		buffer.append(" union all  ");		
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");	
		buffer.append("from S_SE_SalesBasic_Finished ");		
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}	
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" )t ");		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public List<SalesBasicPo> getComplainSalesBasicList(SalesBasicPo po, int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over (order by ssesbtakeglassdata desc) as rowNum,* from ( select * from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid, "); 
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, "); 
		buffer.append("S_ME_CI_Phone as ssesbphone, ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, "); 
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata  ");
		buffer.append("from S_SE_SalesBasic  ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}		
		buffer.append(" union all ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid, "); 
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, "); 
		buffer.append("S_ME_CI_Phone as ssesbphone, ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, "); 
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata  ");
		buffer.append("from S_SE_SalesBasic_Finished  ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("left join S_ME_CustomerInfo on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where cast(S_SE_SB_InTransit as float) >= 2 ");
		
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId like '%' +  ? ");
			params.add(po.getSsesbMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' +  ? ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	 //所属门店
			buffer.append("and B_DP_DepartmentID = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		//财务审核日期查询
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassstartdata());
			params.add(po.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >=  ? ");
			params.add(po.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(po.getSsesbtakeglassenddata());
		}	
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" ) temp ) temp ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	
	}

}
