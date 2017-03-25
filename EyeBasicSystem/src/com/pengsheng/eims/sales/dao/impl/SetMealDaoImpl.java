/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.persistence.SetMealChildPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryPo;
import com.pengsheng.eims.sales.persistence.SetMealParentPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealPo;
import com.pengsheng.eims.sales.persistence.SetMealPropertyValuePo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.MaxDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 套餐
 * 
 */
public class SetMealDaoImpl extends BaseJdbcDaoSupport implements SetMealDao { 
	
	/**
	 * 查询套餐总数
	 */
	public int getSetMealCount(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(S_SM_SM_ID) from S_SM_SetMealRecord where 1=1 ");		
	
		if (!"".equals(Utility.getName(po.getSsmsmtitle()))){
			sb.append(" and S_SM_SM_Title like '%'+?+'%'");
			params.add(Utility.getName(po.getSsmsmtitle()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmcreatebegindate()))){
			sb.append(" and convert(varchar(10),S_SM_SM_CreateDate,120) >= ?");
			params.add(Utility.getName(po.getSsmsmcreatebegindate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmcreateenddate()))){
			sb.append(" and convert(varchar(10),S_SM_SM_CreateDate,120) <= ?");
			params.add(Utility.getName(po.getSsmsmcreateenddate()));
		}		
		if (!"".equals(Utility.getName(po.getSsmsmeffectivebegindate()))){
			sb.append(" and S_SM_SM_EffectiveDate >= ?");
			params.add(Utility.getName(po.getSsmsmeffectivebegindate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmeffectiveenddate()))){
			sb.append(" and S_SM_SM_EffectiveDate <= ?");
			params.add(Utility.getName(po.getSsmsmeffectiveenddate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmclassify()))){
			sb.append(" and S_SM_SM_Classify=?");
			params.add(Utility.getName(po.getSsmsmclassify()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmauditstate()))){
			sb.append(" and isnull(S_SM_SM_AuditState,'0')=?");
			params.add(Utility.getName(po.getSsmsmauditstate()));
		}
		if ("0".equals(Utility.getName(po.getSsmsmisenabled()))){
			sb.append(" and (S_SM_SM_EndDate < convert(varchar(10),getdate(),120) or S_SM_SM_IsEnabled = '0') ");
		}
		if ("1".equals(Utility.getName(po.getSsmsmisenabled()))){
			sb.append(" and (S_SM_SM_EndDate >= convert(varchar(10),getdate(),120) and S_SM_SM_IsEnabled = '1') ");
		}		
		if(!"".equals(Utility.getName(po.getSsmsmshopcode()))){
			sb.append(" and (',' + S_SM_SM_ShopCode + ',') like '%,' + ? + ',%' ");
			params.add(Utility.getName(po.getSsmsmshopcode()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询套餐列表
	 */
	public List<SetMealPo> getSetMealList(SetMealPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("select ssmsmid as ssmsmid,ssmsmisdiscount as ssmsmisdiscount,ssmsmtitle as ssmsmtitle,ssmsmcreatedate as ssmsmcreatedate,ssmsmclassify as ssmsmclassify,ssmsmeffectivedate as ssmsmeffectivedate,ssmsmenddate as ssmsmenddate,ssmsmauditstate as ssmsmauditstate,ssmsmauditdate as ssmsmauditdate,ssmsmauditperson as ssmsmauditperson,ssmsmendbgnAmount as ssmsmendbgnAmount,(select count(S_SE_SB_SalesID) from S_SE_SalesBasic where S_SE_SB_SetMealID=ssmsmid) as ssmsmsalesbillcount,ssmsmisenabled as ssmsmisenabled ");
		sb.append(" from(select ROW_NUMBER() Over(order by S_SM_SM_CreateDate desc) as rowNum,S_SM_SM_IsDiscount as ssmsmisdiscount,S_SM_SM_ID as ssmsmid,S_SM_SM_Title as ssmsmtitle,convert(varchar(10),S_SM_SM_CreateDate,120) as ssmsmcreatedate,(case when (S_SM_SM_EndDate < convert(varchar(10),getdate(),120)) then '0' else isnull(S_SM_SM_IsEnabled,'1') end) as ssmsmisenabled,S_SM_SM_NowBeginAmount as ssmsmendbgnAmount,");
		sb.append("S_SM_SM_Classify as ssmsmclassify,S_SM_SM_EffectiveDate as ssmsmeffectivedate,S_SM_SM_EndDate as ssmsmenddate,S_SM_SM_AuditPerson as ssmsmauditperson,isnull(S_SM_SM_AuditState,0) as ssmsmauditstate,S_SM_SM_AuditDate as ssmsmauditdate from S_SM_SetMealRecord where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getSsmsmtitle()))){
			sb.append(" and S_SM_SM_Title like '%'+?+'%'");
			params.add(Utility.getName(po.getSsmsmtitle()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmcreatebegindate()))){
			sb.append(" and convert(varchar(10),S_SM_SM_CreateDate,120) >= ?");
			params.add(Utility.getName(po.getSsmsmcreatebegindate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmcreateenddate()))){
			sb.append(" and convert(varchar(10),S_SM_SM_CreateDate,120) <= ?");
			params.add(Utility.getName(po.getSsmsmcreateenddate()));
		}		
		if (!"".equals(Utility.getName(po.getSsmsmeffectivebegindate()))){
			sb.append(" and S_SM_SM_EffectiveDate >= ?");
			params.add(Utility.getName(po.getSsmsmeffectivebegindate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmeffectiveenddate()))){
			sb.append(" and S_SM_SM_EffectiveDate <= ?");
			params.add(Utility.getName(po.getSsmsmeffectiveenddate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmclassify()))){
			sb.append(" and S_SM_SM_Classify=?");
			params.add(Utility.getName(po.getSsmsmclassify()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmauditstate()))){
			sb.append(" and isnull(S_SM_SM_AuditState,'0')=?");
			params.add(Utility.getName(po.getSsmsmauditstate()));
		}
		if ("0".equals(Utility.getName(po.getSsmsmisenabled()))){
			sb.append(" and (S_SM_SM_EndDate < convert(varchar(10),getdate(),120) or S_SM_SM_IsEnabled = '0') ");
		}
		if ("1".equals(Utility.getName(po.getSsmsmisenabled()))){
			sb.append(" and (S_SM_SM_EndDate >= convert(varchar(10),getdate(),120) and S_SM_SM_IsEnabled = '1') ");
		}
		if(!"".equals(Utility.getName(po.getSsmsmshopcode()))){
			sb.append(" and (',' + S_SM_SM_ShopCode + ',') like '%,' + ? + ',%' ");
			params.add(Utility.getName(po.getSsmsmshopcode()));
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" order by ssmsmcreatedate desc set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),SetMealPo.class);
	}

	/**
	 * 增加套餐
	 * 
	 */
	public void insertSetMealRecord(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SM_SetMealRecord( ");
		sb.append("S_SM_SM_ID,  ");
		sb.append("S_SM_SM_Title,                ");
		sb.append("S_SM_SM_CreateDate,                ");
		sb.append("S_SM_SM_EffectiveDate,                ");
		sb.append("S_SM_SM_EndDate,                ");
		sb.append("S_SM_SM_Form, S_SM_SM_DetailForm,               ");
		sb.append("S_SM_SM_Classify,                ");
		sb.append("S_SM_SM_IsDiscount,                ");
		sb.append("S_SM_SM_IsSum,                ");
		sb.append("S_SM_SM_ShopCode,                ");
		sb.append("S_SM_SM_Remark,                ");
	    sb.append("S_SM_SM_CreatePerson,                ");
		sb.append("S_SM_SM_SalesFlag,                ");
		sb.append("S_SM_SM_CreditFlag  ");		
		if (!"".equals(Utility.getName(po.getSsmsmsourcebgnAmount()))){
			sb.append(",S_SM_SM_BeginAmount ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourceendAmount()))){
			sb.append(",S_SM_SM_EndAmount ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmendbgnAmount()))){
			sb.append(",S_SM_SM_NowBeginAmount ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmendendAmount()))){
			sb.append(",S_SM_SM_NowEndAmount ");
		}
		sb.append(",S_SM_SM_AuditState,S_SM_SM_IsEnabled,S_SM_SM_UpdateDptPerson,S_SM_SM_UpdateDptDate,S_SM_SM_IsIntegralSum  ");		
		if ("1".equals(Utility.getName(po.getSsmsmauditstate()))){
			sb.append(",S_SM_SM_AuditPerson,S_SM_SM_AuditDate ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendup()))){
			sb.append(",S_SM_SM_ExpenseSpendUp ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendul()))){
			sb.append(",S_SM_SM_ExpenseSpendUL ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsalesbillamount()))){
			sb.append(",S_SM_SM_SalesBillAmount ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpenseamount()))){
			sb.append(",S_SM_SM_ExpenseAmount ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmdiscountrate()))){
			sb.append(",S_SM_SM_DiscountRate ");
		}
		sb.append(" ) values(?,?,getDate(),?,?,?,?,?,?,?,?,?,?,?,? ");
		if (!"".equals(Utility.getName(po.getSsmsmsourcebgnAmount()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourceendAmount()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmendbgnAmount()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmendendAmount()))){
			sb.append(",? ");
		}		
		sb.append(" ,?,'1',?,getdate(),?  ");		
		if ("1".equals(Utility.getName(po.getSsmsmauditstate()))){
			sb.append(",?,getdate() ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendup()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendul()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsalesbillamount()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpenseamount()))){
			sb.append(",? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmdiscountrate()))){
			sb.append(",? ");
		}
		sb.append(" ) ");
		
        params.add (Utility.getName(po.getSsmsmid()));
        params.add (Utility.getName(po.getSsmsmtitle()));
        params.add (Utility.getName(po.getSsmsmeffectivedate()));
        params.add (Utility.getName(po.getSsmsmenddate()));
        params.add (Utility.getName(po.getSsmsmform()));
        params.add (Utility.getName(po.getSsmsmdetailform()));
        params.add (Utility.getName(po.getSsmsmclassify()));
        params.add (Utility.getName(po.getSsmsmisdiscount()).equals("") ? "0" : Utility.getName(po.getSsmsmisdiscount()));
        params.add (Utility.getName(po.getSsmsmissum()).equals("") ? "0" : Utility.getName(po.getSsmsmissum()));
        params.add (Utility.getName(po.getSsmsmshopcode()));
        params.add (Utility.getName(po.getSsmsmremark()));
        params.add (Utility.getName(po.getSsmsmcreateperson()));        
        params.add (Utility.getName(po.getSsmsmsalesflag()));
        params.add (Utility.getName(po.getSsmsmcreditflag()));        
		if (!"".equals(Utility.getName(po.getSsmsmsourcebgnAmount()))){
			 params.add (Utility.getName(po.getSsmsmsourcebgnAmount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourceendAmount()))){
			 params.add (Utility.getName(po.getSsmsmsourceendAmount())); 
		}
		if (!"".equals(Utility.getName(po.getSsmsmendbgnAmount()))){
			params.add (Utility.getName(po.getSsmsmendbgnAmount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmendendAmount()))){
			params.add (Utility.getName(po.getSsmsmendendAmount()));
		}				
		params.add (Utility.getName(po.getSsmsmauditstate()));
		params.add (Utility.getName(po.getSsmsmcreateperson()));
		params.add (Utility.getName(po.getSsmsmintegralsum()));		
		if ("1".equals(Utility.getName(po.getSsmsmauditstate()))){
			params.add (Utility.getName(po.getSsmsmauditperson()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendup()))){
			params.add (Utility.getName(po.getSsmsmexpensespendup()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendul()))){
			params.add (Utility.getName(po.getSsmsmexpensespendul()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmsalesbillamount()))){
			params.add (Utility.getName(po.getSsmsmsalesbillamount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpenseamount()))){
			params.add (Utility.getName(po.getSsmsmexpenseamount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmdiscountrate()))){
			params.add (Utility.getName(po.getSsmsmdiscountrate()));
		}
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 更新套餐
	 * 
	 */
	public void updateSetMealRecord(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update top (1) S_SM_SetMealRecord ");
		sb.append("set S_SM_SM_Title=?                ");		
		sb.append(",S_SM_SM_EffectiveDate=?                ");
		sb.append(",S_SM_SM_EndDate=?                ");
		sb.append(",S_SM_SM_IsSum=?                ");
		sb.append(",S_SM_SM_ShopCode=?                ");
		sb.append(",S_SM_SM_Remark=?                ");	   
		sb.append(",S_SM_SM_SalesFlag=?                ");
		sb.append(",S_SM_SM_CreditFlag=?  ");
		if (!"".equals(Utility.getName(po.getSsmsmisdiscount()))){
			sb.append(",S_SM_SM_IsDiscount=? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourcebgnAmount()))){
			sb.append(",S_SM_SM_BeginAmount=? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourceendAmount()))){
			sb.append(",S_SM_SM_EndAmount=? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmendbgnAmount()))){
			sb.append(",S_SM_SM_NowBeginAmount=? ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmendendAmount()))){
			sb.append(",S_SM_SM_NowEndAmount=? ");
		}
		sb.append(",S_SM_SM_AuditState=?,S_SM_SM_IsIntegralSum=?  ");		
		if ("1".equals(Utility.getName(po.getSsmsmauditstate()))){
			sb.append(",S_SM_SM_AuditPerson=?,S_SM_SM_AuditDate=getdate() ");
		}
		
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendup()))){
			sb.append(",S_SM_SM_ExpenseSpendUp=? ");
		}else{
			sb.append(",S_SM_SM_ExpenseSpendUp=NULL ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendul()))){
			sb.append(",S_SM_SM_ExpenseSpendUL=? ");
		}else{
			sb.append(",S_SM_SM_ExpenseSpendUL=NULL ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmsalesbillamount()))){
			sb.append(",S_SM_SM_SalesBillAmount=? ");
		}else{
			sb.append(",S_SM_SM_SalesBillAmount=NULL ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpenseamount()))){
			sb.append(",S_SM_SM_ExpenseAmount=? ");
		}else{
			sb.append(",S_SM_SM_ExpenseAmount=NULL ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmdiscountrate()))){
			sb.append(",S_SM_SM_DiscountRate=? ");
		}else{
			sb.append(",S_SM_SM_DiscountRate=NULL ");
		}
		if (!"".equals(Utility.getName(po.getSsmsmdetailform()))){
			sb.append(",S_SM_SM_DetailForm=? ");
		}
		
		sb.append(" where S_SM_SM_ID=? ");	

        params.add (Utility.getName(po.getSsmsmtitle()));
        params.add (Utility.getName(po.getSsmsmeffectivedate()));
        params.add (Utility.getName(po.getSsmsmenddate()));
        params.add (Utility.getName(po.getSsmsmissum()).equals("") ? "0" : Utility.getName(po.getSsmsmissum()));
        params.add (Utility.getName(po.getSsmsmshopcode()));
        params.add (Utility.getName(po.getSsmsmremark()));       
        params.add (Utility.getName(po.getSsmsmsalesflag()));
        params.add (Utility.getName(po.getSsmsmcreditflag()));
        if (!"".equals(Utility.getName(po.getSsmsmisdiscount()))){
        	params.add (Utility.getName(po.getSsmsmisdiscount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourcebgnAmount()))){
			 params.add (Utility.getName(po.getSsmsmsourcebgnAmount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmsourceendAmount()))){
			 params.add (Utility.getName(po.getSsmsmsourceendAmount())); 
		}
		if (!"".equals(Utility.getName(po.getSsmsmendbgnAmount()))){
			params.add (Utility.getName(po.getSsmsmendbgnAmount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmendendAmount()))){
			params.add (Utility.getName(po.getSsmsmendendAmount()));
		}				
		params.add (Utility.getName(po.getSsmsmauditstate()));
		params.add (Utility.getName(po.getSsmsmintegralsum()));		
		if ("1".equals(Utility.getName(po.getSsmsmauditstate()))){
			params.add (Utility.getName(po.getSsmsmauditperson()));
		}
		
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendup()))){
			params.add (Utility.getName(po.getSsmsmexpensespendup()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpensespendul()))){
			params.add (Utility.getName(po.getSsmsmexpensespendul()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmsalesbillamount()))){
			params.add (Utility.getName(po.getSsmsmsalesbillamount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmexpenseamount()))){
			params.add (Utility.getName(po.getSsmsmexpenseamount()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmdiscountrate()))){
			params.add (Utility.getName(po.getSsmsmdiscountrate()));
		}
		if (!"".equals(Utility.getName(po.getSsmsmdetailform()))){
			params.add (Utility.getName(po.getSsmsmdetailform()));
		}
		
        params.add (Utility.getName(po.getSsmsmid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	/**
	 * 增加套餐
	 * 
	 */
	public void insertSetMeal(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO [S_SM_SetMeal] ");
		sb.append("           ([S_SM_SM_ID],[S_SM_SM_Title],[S_SM_SM_CreateDate],[S_SM_SM_EffectiveDate],[S_SM_SM_EndDate] ");
		sb.append("           ,[S_SM_SM_Form],[S_SM_SM_DetailForm],[S_SM_SM_Classify],[S_SM_SM_IsDiscount],[S_SM_SM_IsSum] ");
		sb.append("           ,[S_SM_SM_ShopCode],[S_SM_SM_Remark],[S_SM_SM_CreatePerson],[S_SM_SM_SalesFlag],[S_SM_SM_CreditFlag] ");
		sb.append("           ,[S_SM_SM_BeginAmount],[S_SM_SM_EndAmount],[S_SM_SM_NowBeginAmount],[S_SM_SM_NowEndAmount] ");
		sb.append("           ,[S_SM_SM_AuditPerson],[S_SM_SM_AuditState],[S_SM_SM_AuditDate],[S_SM_SM_IsEnabled] ");
		sb.append("           ,[S_SM_SM_UnEnablePerson],[S_SM_SM_UnEnableDate],[S_SM_SM_UpdateDptPerson],[S_SM_SM_UpdateDptDate] ");
		sb.append("           ,[S_SM_SM_ExpenseSpendUp],[S_SM_SM_ExpenseSpendUL],[S_SM_SM_SalesBillAmount],[S_SM_SM_ExpenseAmount] ");
		sb.append("           ,[S_SM_SM_DiscountRate],[S_SM_SM_IsIntegralSum]) ");
		sb.append("      select top 1  [S_SM_SM_ID],[S_SM_SM_Title],[S_SM_SM_CreateDate],[S_SM_SM_EffectiveDate],[S_SM_SM_EndDate] ");
		sb.append("           ,[S_SM_SM_Form],[S_SM_SM_DetailForm],[S_SM_SM_Classify],[S_SM_SM_IsDiscount],[S_SM_SM_IsSum] ");
		sb.append("           ,[S_SM_SM_ShopCode],[S_SM_SM_Remark],[S_SM_SM_CreatePerson],[S_SM_SM_SalesFlag],[S_SM_SM_CreditFlag] ");
		sb.append("           ,[S_SM_SM_BeginAmount],[S_SM_SM_EndAmount],[S_SM_SM_NowBeginAmount],[S_SM_SM_NowEndAmount] ");
		sb.append("           ,[S_SM_SM_AuditPerson],[S_SM_SM_AuditState],[S_SM_SM_AuditDate],[S_SM_SM_IsEnabled] ");
		sb.append("           ,[S_SM_SM_UnEnablePerson],[S_SM_SM_UnEnableDate],[S_SM_SM_UpdateDptPerson],[S_SM_SM_UpdateDptDate] ");
		sb.append("           ,[S_SM_SM_ExpenseSpendUp],[S_SM_SM_ExpenseSpendUL],[S_SM_SM_SalesBillAmount],[S_SM_SM_ExpenseAmount] ");
		sb.append("           ,[S_SM_SM_DiscountRate],[S_SM_SM_IsIntegralSum] from S_SM_SetMealRecord  ");
		sb.append("        where S_SM_SM_ID=? ");
				
		params.add (Utility.getName(po.getSsmsmid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 增加套餐明细
	 * 
	 */
	public void insertSetMealEntry(SetMealPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SM_SetMealEntry ([S_SM_SG_ID],[S_SM_SG_SetMealID],[S_SM_SG_GoodsCategory],[S_SM_SG_IsCustomize],[S_SM_SG_BigClass] ");
		sb.append("      ,[S_SM_SG_SmallClass],[S_SM_SG_Supplier],[S_SM_SG_Brand],[S_SM_SG_GoodsID],[S_SM_SG_GoodsName] ");
		sb.append("      ,[S_SM_SG_GoodsClass],[S_SM_SG_MinCostPrice],[S_SM_SG_MaxCostPrice],[S_SM_SG_GoodsQuantity] ");
		sb.append("      ,[S_SM_SG_ExpenseSpendUp],[S_SM_SG_ExpenseSpendUL],[S_SM_SG_FavorableForm],[S_SM_SG_DiscountRate] ");
		sb.append("      ,[S_SM_SG_SpecialOffer],[S_SM_SG_ExpenseCredit],[S_SM_SG_Flag],[S_SM_SG_BeginAmount] ");
		sb.append("      ,[S_SM_SG_EndAmount],[S_SM_SG_RetailPrice],[S_SM_SG_SphUL],[S_SM_SG_SphUp],[S_SM_SG_CylUL] ");
		sb.append("      ,[S_SM_SG_CylUp],[S_SM_SG_Clfl],[S_SM_SG_Zsl],[S_SM_SG_Gdfl],[S_SM_SG_Gndl],[S_SM_SG_Jjcz] ");
		sb.append("      ,[S_SM_SG_Sylx],[S_SM_SG_Pqlx],[S_SM_SG_Tyjgn]) ");
		sb.append("SELECT [S_SM_SG_ID],[S_SM_SG_SetMealID],[S_SM_SG_GoodsCategory],[S_SM_SG_IsCustomize],[S_SM_SG_BigClass] ");
		sb.append("      ,[S_SM_SG_SmallClass],[S_SM_SG_Supplier],[S_SM_SG_Brand],[S_SM_SG_GoodsID],[S_SM_SG_GoodsName] ");
		sb.append("      ,[S_SM_SG_GoodsClass],[S_SM_SG_MinCostPrice],[S_SM_SG_MaxCostPrice],[S_SM_SG_GoodsQuantity] ");
		sb.append("      ,[S_SM_SG_ExpenseSpendUp],[S_SM_SG_ExpenseSpendUL],[S_SM_SG_FavorableForm],[S_SM_SG_DiscountRate] ");
		sb.append("      ,[S_SM_SG_SpecialOffer],[S_SM_SG_ExpenseCredit],[S_SM_SG_Flag],[S_SM_SG_BeginAmount] ");
		sb.append("      ,[S_SM_SG_EndAmount],[S_SM_SG_RetailPrice],[S_SM_SG_SphUL],[S_SM_SG_SphUp],[S_SM_SG_CylUL] ");
		sb.append("      ,[S_SM_SG_CylUp],[S_SM_SG_Clfl],[S_SM_SG_Zsl],[S_SM_SG_Gdfl],[S_SM_SG_Gndl],[S_SM_SG_Jjcz] ");
		sb.append("      ,[S_SM_SG_Sylx],[S_SM_SG_Pqlx],[S_SM_SG_Tyjgn] ");
		sb.append("  FROM [S_SM_SetMealRecordEntry] where S_SM_SG_SetMealID=? ");
       
		params.add (Utility.getName(po.getSsmsmid()));
		
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 新增套餐明细
	 * 
	 */
	public void insertSetMealRecordEntry(SetMealEntryPo poEntry){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SM_SetMealRecordEntry(S_SM_SG_ID  ");
		sb.append(",S_SM_SG_SetMealID                ");
		sb.append(",S_SM_SG_GoodsCategory                ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgiscustomize()))){
			sb.append(",S_SM_SG_IsCustomize                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgbigclass()))){
			sb.append(",S_SM_SG_BigClass                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgsmallclass()))){
			sb.append(",S_SM_SG_SmallClass                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgsupplier()))){
			sb.append(",S_SM_SG_Supplier                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgbrand()))){
			sb.append(",S_SM_SG_Brand                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsggoodsid()))){
			sb.append(",S_SM_SG_GoodsID                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsggoodsname()))){
			sb.append(",S_SM_SG_GoodsName               ");
		}
		sb.append(",S_SM_SG_GoodsClass                ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgmincostPrice()))){
			sb.append(",S_SM_SG_MinCostPrice                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgmaxcostPrice()))){
			sb.append(",S_SM_SG_MaxCostPrice                ");
		}
		sb.append(",S_SM_SG_GoodsQuantity                ");		
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensespendup()))){
			sb.append(",S_SM_SG_ExpenseSpendUp                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensespendul()))){
			sb.append(",S_SM_SG_ExpenseSpendUL                ");
		}
		sb.append(",S_SM_SG_FavorableForm               ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgdiscountrate()))){
			sb.append(",S_SM_SG_DiscountRate               ");
		}	
		if (!"".equals(Utility.getName(poEntry.getSsmsgspecialoffer()))){
			sb.append(",S_SM_SG_SpecialOffer               ");
		}	
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensecredit()))){
			sb.append(",S_SM_SG_ExpenseCredit                ");
		}
		sb.append(",S_SM_SG_Flag                         ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgbeginAmount()))){
			sb.append(",S_SM_SG_BeginAmount               ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgendAmount()))){
			sb.append(",S_SM_SG_EndAmount                ");
		}
        if (!Utility.getName(poEntry.getSsmsgretailPrice()).equals("")){
        	sb.append(",S_SM_SG_RetailPrice                ");
        }		
        if (!Utility.getName(poEntry.getSsmsgsphul()).equals("")){
        	sb.append(",S_SM_SG_SphUL                ");
        }  
        if (!Utility.getName(poEntry.getSsmsgsphup()).equals("")){
        	sb.append(",S_SM_SG_SphUp                ");
        }  
        if (!Utility.getName(poEntry.getSsmsgcylul()).equals("")){
        	sb.append(",S_SM_SG_CylUL                ");
        }  
        if (!Utility.getName(poEntry.getSsmsgcylup()).equals("")){
        	sb.append(",S_SM_SG_CylUp                ");
        }
        if (!Utility.getName(poEntry.getSsmsgclfl()).equals("")){
        	sb.append(",S_SM_SG_Clfl                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgzsl()).equals("")){
        	sb.append(",S_SM_SG_Zsl                ");
        } 
        if (!Utility.getName(poEntry.getSsmsggdfl()).equals("")){
        	sb.append(",S_SM_SG_Gdfl                ");
        } 
        if (!Utility.getName(poEntry.getSsmsggndl()).equals("")){
        	sb.append(",S_SM_SG_Gndl                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgjjcz()).equals("")){
        	sb.append(",S_SM_SG_Jjcz                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgsylx()).equals("")){
        	sb.append(",S_SM_SG_Sylx                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgpqlx()).equals("")){
        	sb.append(",S_SM_SG_Pqlx                ");
        }
        if (!Utility.getName(poEntry.getSsmsgtyjgn()).equals("")){
        	sb.append(",S_SM_SG_Tyjgn                ");
        } 
        sb.append(" ) values (?,?,? ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgiscustomize()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgbigclass()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgsmallclass()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgsupplier()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgbrand()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsggoodsid()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsggoodsname()))){
			sb.append(",?                ");
		}
		sb.append(",?                ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgmincostPrice()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgmaxcostPrice()))){
			sb.append(",?                ");
		}
		sb.append(",?                ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensespendup()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensespendul()))){
			sb.append(",?                ");
		}
		sb.append(",?                ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgdiscountrate()))){
			sb.append(",?                ");
		}	
		if (!"".equals(Utility.getName(poEntry.getSsmsgspecialoffer()))){
			sb.append(",?                ");
		}	
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensecredit()))){
			sb.append(",?                ");
		}
		sb.append(",?                ");
		if (!"".equals(Utility.getName(poEntry.getSsmsgbeginAmount()))){
			sb.append(",?                ");
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgendAmount()))){
			sb.append(",?                ");
		}
        if (!Utility.getName(poEntry.getSsmsgretailPrice()).equals("")){
        	sb.append(",?                ");
        }		
        if (!Utility.getName(poEntry.getSsmsgsphul()).equals("")){
        	sb.append(",?                ");
        }  
        if (!Utility.getName(poEntry.getSsmsgsphup()).equals("")){
        	sb.append(",?                ");
        }  
        if (!Utility.getName(poEntry.getSsmsgcylul()).equals("")){
        	sb.append(",?                ");
        }  
        if (!Utility.getName(poEntry.getSsmsgcylup()).equals("")){
        	sb.append(",?                ");
        }
        if (!Utility.getName(poEntry.getSsmsgclfl()).equals("")){
        	sb.append(",?                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgzsl()).equals("")){
        	sb.append(",?                ");
        } 
        if (!Utility.getName(poEntry.getSsmsggdfl()).equals("")){
        	sb.append(",?                ");
        } 
        if (!Utility.getName(poEntry.getSsmsggndl()).equals("")){
        	sb.append(",?                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgjjcz()).equals("")){
        	sb.append(",?                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgsylx()).equals("")){
        	sb.append(",?                ");
        } 
        if (!Utility.getName(poEntry.getSsmsgpqlx()).equals("")){
        	sb.append(",?                ");
        }
        if (!Utility.getName(poEntry.getSsmsgtyjgn()).equals("")){
        	sb.append(",?                ");
        } 
        sb.append(" )     ");        
        
        params.add (this.uuid.generate());
        params.add (Utility.getName(poEntry.getSsmsgsetmealid()));
        params.add (Utility.getName(poEntry.getSsmsggoodscategory()));        
		if (!"".equals(Utility.getName(poEntry.getSsmsgiscustomize()))){
			params.add (Utility.getName(poEntry.getSsmsgiscustomize()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgbigclass()))){
			params.add (Utility.getName(poEntry.getSsmsgbigclass()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgsmallclass()))){
			params.add (Utility.getName(poEntry.getSsmsgsmallclass()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgsupplier()))){
			params.add (Utility.getName(poEntry.getSsmsgsupplier()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgbrand()))){
			params.add (Utility.getName(poEntry.getSsmsgbrand()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsggoodsid()))){
			params.add (Utility.getName(poEntry.getSsmsggoodsid()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsggoodsname()))){
			params.add (Utility.getName(poEntry.getSsmsggoodsname()));
		}
		params.add (Utility.getName(poEntry.getSsmsgoodsclass()));
		if (!"".equals(Utility.getName(poEntry.getSsmsgmincostPrice()))){
			params.add(Utility.getName(poEntry.getSsmsgmincostPrice()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgmaxcostPrice()))){
			params.add (Utility.getName(poEntry.getSsmsgmaxcostPrice()));
		}
		params.add (Utility.getName(poEntry.getSsmsggoodsquantity()));
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensespendup()))){
			params.add (Utility.getName(poEntry.getSsmsgexpensespendup()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensespendul()))){
			params.add (Utility.getName(poEntry.getSsmsgexpensespendul()));
		}
		params.add (Utility.getName(poEntry.getSsmsgfavorableflag()));
		if (!"".equals(Utility.getName(poEntry.getSsmsgdiscountrate()))){
			params.add (Utility.getName(poEntry.getSsmsgdiscountrate()));
		}	
		if (!"".equals(Utility.getName(poEntry.getSsmsgspecialoffer()))){
			params.add (Utility.getName(poEntry.getSsmsgspecialoffer()));
		}	
		if (!"".equals(Utility.getName(poEntry.getSsmsgexpensecredit()))){
			params.add (Utility.getName(poEntry.getSsmsgexpensecredit()));
		}
		params.add (Utility.getName(poEntry.getSsmsgflag()));
		if (!"".equals(Utility.getName(poEntry.getSsmsgbeginAmount()))){
			params.add (Utility.getName(poEntry.getSsmsgbeginAmount()));
		}
		if (!"".equals(Utility.getName(poEntry.getSsmsgendAmount()))){
			params.add (Utility.getName(poEntry.getSsmsgendAmount()));
		}
        if (!Utility.getName(poEntry.getSsmsgretailPrice()).equals("")){
        	params.add(Utility.getName(poEntry.getSsmsgretailPrice()));
        }		
        if (!Utility.getName(poEntry.getSsmsgsphul()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgsphul()));
        }  
        if (!Utility.getName(poEntry.getSsmsgsphup()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgsphup()));
        }  
        if (!Utility.getName(poEntry.getSsmsgcylul()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgcylul()));
        }  
        if (!Utility.getName(poEntry.getSsmsgcylup()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgcylup()));
        }
        if (!Utility.getName(poEntry.getSsmsgclfl()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgclfl()));
        } 
        if (!Utility.getName(poEntry.getSsmsgzsl()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgzsl()));
        } 
        if (!Utility.getName(poEntry.getSsmsggdfl()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsggdfl()));
        } 
        if (!Utility.getName(poEntry.getSsmsggndl()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsggndl()));
        } 
        if (!Utility.getName(poEntry.getSsmsgjjcz()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgjjcz()));
        } 
        if (!Utility.getName(poEntry.getSsmsgsylx()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgsylx()));
        } 
        if (!Utility.getName(poEntry.getSsmsgpqlx()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgpqlx()));
        }
        if (!Utility.getName(poEntry.getSsmsgtyjgn()).equals("")){
        	params.add (Utility.getName(poEntry.getSsmsgtyjgn()));
        }     
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 删除套餐
	 * 
	 */
	public void deleteSetMeal(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SM_SetMeal where S_SM_SM_ID=? ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除套餐流水
	 * 
	 */
	public void deleteSetMealRecord(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SM_SetMealRecord where S_SM_SM_ID=? ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除套餐
	 * 
	 */
	public void deleteSetMealEntry(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SM_SetMealEntry where S_SM_SG_SetMealID=? ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除套餐流水明细
	 * 
	 */
	public void deleteSetMealRecordEntry(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SM_SetMealRecordEntry where S_SM_SG_SetMealID=? ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 套餐详细
	 * 
	 */
	public SetMealPo getSetMealDetail(SetMealPo po){

		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();

		sb.append("select top 1 S_SM_SM_ID as ssmsmid,S_SM_SM_Title as ssmsmtitle,convert(varchar(10),S_SM_SM_CreateDate,120) as ssmsmcreatedate,S_SM_SM_Form as ssmsmform ,S_SM_SM_IsDiscount as ssmsmisdiscount,S_SM_SM_IsSum as ssmsmissum,S_SM_SM_ShopCode as ssmsmshopcode,S_SM_SM_AuditPerson as ssmsmauditperson,isnull(S_SM_SM_AuditState,0) as ssmsmauditstate,S_SM_SM_AuditDate as ssmsmauditdate,isnull(b.personname,'') as ssmsmauditpersonname,isnull(c.personname,'') as ssmsmunenabledpersonname,isnull(d.personname,'') as ssmsmupdatedptpersonname,");
		sb.append("S_SM_SM_Classify as ssmsmclassify,S_SM_SM_EffectiveDate as ssmsmeffectivedate,S_SM_SM_EndDate as ssmsmenddate,S_SM_SM_Remark as ssmsmremark,S_SM_SM_SalesFlag as ssmsmsalesflag,S_SM_SM_CreditFlag as ssmsmcreditflag,isnull(a.personName,'') as ssmsmcreatepersonname,S_SM_SM_BeginAmount as ssmsmsourcebgnAmount,S_SM_SM_EndAmount as ssmsmsourceendAmount,S_SM_SM_NowBeginAmount as ssmsmendbgnAmount,S_SM_SM_NowEndAmount as ssmsmendendAmount, ");
		sb.append("S_SM_SM_DetailForm as ssmsmdetailform,S_SM_SM_CreatePerson as ssmsmcreateperson,(case when (S_SM_SM_EndDate <= convert(varchar(10),getdate(),120)) then '0' else isnull(S_SM_SM_IsEnabled,'1') end) as ssmsmisenabled,S_SM_SM_UnEnablePerson as ssmsmunenabledpersonid,convert(varchar(10),S_SM_SM_UnEnableDate,120) as ssmsmunenableddate,S_SM_SM_UpdateDptPerson as ssmsmupdatedptpersonid,S_SM_SM_UpdateDptDate as ssmsmupdatedptdate,S_SM_SM_ExpenseSpendUp as ssmsmexpensespendup,S_SM_SM_ExpenseSpendUL as ssmsmexpensespendul,S_SM_SM_SalesBillAmount as ssmsmsalesbillamount,S_SM_SM_ExpenseAmount as ssmsmexpenseamount,S_SM_SM_DiscountRate as ssmsmdiscountrate,S_SM_SM_IsIntegralSum as ssmsmintegralsum ");
		
		sb.append(" ,dbo.getShopCodeNameList(S_SM_SM_ShopCode) as ssmsmshopcodename,isnull(S_SM_SM_UnAuditFlag,'') as ssmsmunauditflag from S_SM_SetMealRecord left join SYS_PersonInfo a on S_SM_SM_CreatePerson=a.id ");
		sb.append(" left join SYS_PersonInfo b on S_SM_SM_AuditPerson=b.id ");
		sb.append(" left join SYS_PersonInfo c on S_SM_SM_UnEnablePerson=c.id ");
		sb.append(" left join SYS_PersonInfo d on S_SM_SM_UpdateDptPerson=d.id ");
		sb.append(" where S_SM_SM_ID=?  ");
				
		params.add(Utility.getName(po.getSsmsmid()));
		
		return (SetMealPo)queryForObject(sb.toString(), params.toArray(),SetMealPo.class);
	}
	
	/**
	 * 套餐商品详细
	 * 
	 */
	public List<SetMealEntryPo> getSetMealEntryDetail(SetMealPo po){

		StringBuffer sb = new StringBuffer();		
		List<String> params = new ArrayList<String>();

		sb.append("select S_SM_SG_ID as ssmsgid,S_SM_SG_SetMealID as ssmsgsetmealid,S_SM_SG_GoodsCategory as ssmsggoodscategory,isnull(S_SM_SG_IsCustomize,'') as ssmsgiscustomize ,isnull(S_SM_SG_BigClass,'') as ssmsgbigclass,isnull(S_SM_SG_SmallClass,'') as ssmsgsmallclass,S_SM_SG_Supplier as ssmsgsupplier,");
		sb.append("S_SM_SG_Brand as ssmsgbrand,S_SM_SG_GoodsID as ssmsggoodsid,S_SM_SG_GoodsName as ssmsggoodsname,S_SM_SG_GoodsClass as ssmsggoodsclass,S_SM_SG_MinCostPrice as ssmsgmincostPrice,S_SM_SG_MaxCostPrice as ssmsgmaxcostPrice,S_SM_SG_GoodsQuantity as ssmsggoodsquantity,S_SM_SG_ExpenseSpendUp as ssmsgexpensespendup,S_SM_SG_ExpenseSpendUL as ssmsgexpensespendul,S_SM_SG_FavorableForm as ssmsgfavorableflag,S_SM_SG_DiscountRate as ssmsgdiscountrate,S_SM_SG_SphUL as ssmsgsphul,S_SM_SG_SphUp as ssmsgsphup,S_SM_SG_CylUL as ssmsgcylul,S_SM_SG_CylUp as ssmsgcylup, ");
		sb.append(" S_SM_SG_SpecialOffer as ssmsgspecialoffer,S_SM_SG_ExpenseCredit as ssmsgexpensecredit,S_SM_SG_Flag as ssmsgflag,S_SM_SG_BeginAmount as ssmsgbeginAmount,S_SM_SG_EndAmount as ssmsgendAmount,S_SM_SG_RetailPrice as ssmsgretailPrice,S_SM_SG_Clfl as ssmsgclfl,S_SM_SG_Zsl as ssmsgzsl,S_SM_SG_Gdfl as ssmsggdfl,S_SM_SG_Gndl as ssmsggndl,S_SM_SG_Jjcz as ssmsgjjcz,S_SM_SG_Sylx as ssmsgsylx,S_SM_SG_Pqlx as ssmsgpqlx,S_SM_SG_Tyjgn as ssmsgtyjgn from S_SM_SetMealRecordEntry where S_SM_SG_SetMealID=? ");
				
		params.add(Utility.getName(po.getSsmsmid()));
		
		return queryForObjectList(sb.toString(), params.toArray(),SetMealEntryPo.class);
	}
	
	/**
	 * 查询套餐商品总数
	 */
	public int getGoodsCount(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(B_GI_GoodsID) from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where B_GI_Flag='1' and B_GI_SupplierID<>'ZZ' ");		
	
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			sb.append(" and B_GI_GoodsBarCode=? ");
			params.add(Utility.getName(po.getBgigoodsbarcode()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getBgisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getBgibrandid()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))){
			sb.append(" and B_GI_RetailPrice>=? ");
			params.add(Utility.getName(po.getBgiretailbeginprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))){
			sb.append(" and B_GI_RetailPrice<=? ");
			params.add(Utility.getName(po.getBgiretailendprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getBgiiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sb.append(" and B_GI_FrameMaterialType=? ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
			sb.append(" and B_GI_EyeGlassMaterialType=? ");
			params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
		}
		if (!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBbdluminosityclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))){
			sb.append(" and B_GI_GradualClass=? ");
			params.add(Utility.getName(po.getBgigradualclass()));
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))){
			sb.append(" and B_GI_FunctionClass=? ");
			params.add(Utility.getName(po.getBgifunctionclass()));
		}
		if (!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive= ?");
			params.add(Utility.getName(po.getBgirefractive()));
		}
		if (!"".equals(Utility.getName(po.getBgiusetype()))){
			sb.append(" and B_GI_UseType= ?");
			params.add(Utility.getName(po.getBgiusetype()));
		}		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))){
			sb.append(" and B_GI_StealthClass= ?");
			params.add(Utility.getName(po.getBgistealthclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
//			sb.append(" and B_GI_AccessoriesType=? ");
//			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		if (!"".equals(Utility.getName(po.getBgisunglassesfuntion()))){
			sb.append(" and B_GI_SunGglassesFun=? ");
			params.add(Utility.getName(po.getBgisunglassesfuntion()));
		}
		sb.append(" and (( isnull(B_GI_isCustomize,'')='D' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_SphUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_SphUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_CylUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_CylUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}		
		sb.append(" ) or ( isnull(B_GI_isCustomize,'')='0' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_Sph as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_Sph as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_Cyl as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_Cyl as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}
		sb.append(" ) or isnull(B_GI_isCustomize,'') not in ('0','D')) ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询套餐商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(GoodsInfoPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select bgigoodsid as bgigoodsid,bgiviewgoodsname as bgiviewgoodsname,bgigoodsname as bgigoodsname,bgigoodscategoryname as bgigoodscategoryname,bgisuppliername as bgisuppliername,bgibrandname as bgibrandname,bgiretailprice as bgiretailbeginprice,bgiretailprice as bgiretailendprice,bgiiscustomize as bgiiscustomize, ");
		sb.append(" bgigoodscategoryid as bgigoodscategoryid,bgisupplierid as bgisupplierid,bgibrandid as bgibrandid,'4' as bgisalestype from (select ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum,B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname,B_GC_GoodsCategoryName as bgigoodscategoryname,B_SP_SupplierName as bgisuppliername,B_BD_brandName as bgibrandname,B_GI_RetailPrice as bgiretailprice,B_GI_isCustomize as bgiiscustomize, ");		
		sb.append(" b_gi_viewgoodsname as bgiviewgoodsname,B_GI_GoodsCategoryID as bgigoodscategoryid,B_GI_SupplierID as bgisupplierid,B_GI_BrandID as bgibrandid from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where B_GI_Flag='1' and B_GI_SupplierID<>'ZZ' ");

		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			sb.append(" and B_GI_GoodsBarCode=? ");
			params.add(Utility.getName(po.getBgigoodsbarcode()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getBgisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getBgibrandid()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))){
			sb.append(" and B_GI_RetailPrice>=? ");
			params.add(Utility.getName(po.getBgiretailbeginprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))){
			sb.append(" and B_GI_RetailPrice<=? ");
			params.add(Utility.getName(po.getBgiretailendprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getBgiiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sb.append(" and B_GI_FrameMaterialType=? ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
			sb.append(" and B_GI_EyeGlassMaterialType=? ");
			params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
		}
		if (!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBbdluminosityclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))){
			sb.append(" and B_GI_GradualClass=? ");
			params.add(Utility.getName(po.getBgigradualclass()));
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))){
			sb.append(" and B_GI_FunctionClass=? ");
			params.add(Utility.getName(po.getBgifunctionclass()));
		}
		if (!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive= ?");
			params.add(Utility.getName(po.getBgirefractive()));
		}
		if (!"".equals(Utility.getName(po.getBgiusetype()))){
			sb.append(" and B_GI_UseType= ?");
			params.add(Utility.getName(po.getBgiusetype()));
		}		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))){
			sb.append(" and B_GI_StealthClass= ?");
			params.add(Utility.getName(po.getBgistealthclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
//			sb.append(" and B_GI_AccessoriesType=? ");
//			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		if (!"".equals(Utility.getName(po.getBgisunglassesfuntion()))){
			sb.append(" and B_GI_SunGglassesFun=? ");
			params.add(Utility.getName(po.getBgisunglassesfuntion()));
		}
		sb.append(" and (( isnull(B_GI_isCustomize,'')='D' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_SphUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_SphUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_CylUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_CylUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}		
		sb.append(" ) or ( isnull(B_GI_isCustomize,'')='0' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_Sph as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_Sph as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_Cyl as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_Cyl as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}
		sb.append(" ) or isnull(B_GI_isCustomize,'') not in ('0','D')) ");
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
		
	/**
	 * 查询制造商总数
	 */
	public int getSupplierCount(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(count1) from ( select (B_GI_GoodsCategoryID + '.' + B_GI_SupplierID) as count1 from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where B_GI_Flag='1' and B_GI_SupplierID<>'ZZ' ");		
	
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getBgisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getBgibrandid()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))){
			sb.append(" and B_GI_RetailPrice>=? ");
			params.add(Utility.getName(po.getBgiretailbeginprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))){
			sb.append(" and B_GI_RetailPrice<=? ");
			params.add(Utility.getName(po.getBgiretailendprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getBgiiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sb.append(" and B_GI_FrameMaterialType=? ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
			sb.append(" and B_GI_EyeGlassMaterialType=? ");
			params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
		}
		if (!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBbdluminosityclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))){
			sb.append(" and B_GI_GradualClass=? ");
			params.add(Utility.getName(po.getBgigradualclass()));
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))){
			sb.append(" and B_GI_FunctionClass=? ");
			params.add(Utility.getName(po.getBgifunctionclass()));
		}
		if (!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive= ?");
			params.add(Utility.getName(po.getBgirefractive()));
		}
		if (!"".equals(Utility.getName(po.getBgiusetype()))){
			sb.append(" and B_GI_UseType= ?");
			params.add(Utility.getName(po.getBgiusetype()));
		}		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))){
			sb.append(" and B_GI_StealthClass= ?");
			params.add(Utility.getName(po.getBgistealthclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
//			sb.append(" and B_GI_AccessoriesType=? ");
//			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		if (!"".equals(Utility.getName(po.getBgisunglassesfuntion()))){
			sb.append(" and B_GI_SunGglassesFun=? ");
			params.add(Utility.getName(po.getBgisunglassesfuntion()));
		}
		sb.append(" and (( isnull(B_GI_isCustomize,'')='D' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_SphUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_SphUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_CylUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_CylUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}		
		sb.append(" ) or ( isnull(B_GI_isCustomize,'')='0' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_Sph as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_Sph as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_Cyl as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_Cyl as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}
		sb.append(" ) or isnull(B_GI_isCustomize,'') not in ('0','D')) ");
		
		sb.append(" group by (B_GI_GoodsCategoryID+'.'+B_GI_SupplierID),B_SP_SupplierName,B_GC_GoodsCategoryName,B_GI_SupplierID,B_GI_GoodsCategoryID ) temp ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询制造商列表
	 */
	public List<GoodsInfoPo> getSupplierList(GoodsInfoPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select bgigoodsid as bgigoodsid,bgigoodsname as bgigoodsname,bgigoodsname as bgisuppliername,bgigoodscategoryname as bgigoodscategoryname,bgisupplierid as bgisupplierid,? as bgiiscustomize,bgigoodscategoryid as bgigoodscategoryid,bgiretailbeginprice as bgiretailbeginprice,bgiretailendprice as bgiretailendprice,'' as bgibrandid,'' as bgibrandname,'2' as bgisalestype ");
		sb.append(" from (select ROW_NUMBER() Over(order by (B_GI_GoodsCategoryID+'.'+B_GI_SupplierID)) as rowNum,(B_GI_GoodsCategoryID+'.'+B_GI_SupplierID) as bgigoodsid,B_SP_SupplierName as bgigoodsname,B_GC_GoodsCategoryName as bgigoodscategoryname,B_GI_SupplierID as bgisupplierid,B_GI_GoodsCategoryID as bgigoodscategoryid,min(B_GI_RetailPrice) as bgiretailbeginprice,max(B_GI_RetailPrice) as bgiretailendprice ");		
		sb.append(" from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where B_GI_Flag='1' and B_GI_SupplierID<>'ZZ' ");
		
		params.add(Utility.getName(po.getBgiiscustomize()));
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getBgisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getBgibrandid()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))){
			sb.append(" and B_GI_RetailPrice>=? ");
			params.add(Utility.getName(po.getBgiretailbeginprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))){
			sb.append(" and B_GI_RetailPrice<=? ");
			params.add(Utility.getName(po.getBgiretailendprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getBgiiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sb.append(" and B_GI_FrameMaterialType=? ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
			sb.append(" and B_GI_EyeGlassMaterialType=? ");
			params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
		}
		if (!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBbdluminosityclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))){
			sb.append(" and B_GI_GradualClass=? ");
			params.add(Utility.getName(po.getBgigradualclass()));
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))){
			sb.append(" and B_GI_FunctionClass=? ");
			params.add(Utility.getName(po.getBgifunctionclass()));
		}
		if (!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive= ?");
			params.add(Utility.getName(po.getBgirefractive()));
		}
		if (!"".equals(Utility.getName(po.getBgiusetype()))){
			sb.append(" and B_GI_UseType= ?");
			params.add(Utility.getName(po.getBgiusetype()));
		}		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))){
			sb.append(" and B_GI_StealthClass= ?");
			params.add(Utility.getName(po.getBgistealthclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
//			sb.append(" and B_GI_AccessoriesType=? ");
//			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		if (!"".equals(Utility.getName(po.getBgisunglassesfuntion()))){
			sb.append(" and B_GI_SunGglassesFun=? ");
			params.add(Utility.getName(po.getBgisunglassesfuntion()));
		}
		sb.append(" and (( isnull(B_GI_isCustomize,'')='D' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_SphUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_SphUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_CylUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_CylUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}		
		sb.append(" ) or ( isnull(B_GI_isCustomize,'')='0' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_Sph as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_Sph as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_Cyl as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_Cyl as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}
		sb.append(" ) or isnull(B_GI_isCustomize,'') not in ('0','D')) ");
		
		sb.append(" group by (B_GI_GoodsCategoryID+'.'+B_GI_SupplierID),B_SP_SupplierName,B_GC_GoodsCategoryName,B_GI_SupplierID,B_GI_GoodsCategoryID ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 查询品种总数
	 */
	public int getBrandCount(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(count1) from (select (B_GI_GoodsCategoryID + '.' + B_GI_SupplierID+'.'+B_GI_BrandID) as count1 from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where B_GI_Flag='1' and B_GI_SupplierID<>'ZZ' ");		
	
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getBgisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getBgibrandid()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))){
			sb.append(" and B_GI_RetailPrice>=? ");
			params.add(Utility.getName(po.getBgiretailbeginprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))){
			sb.append(" and B_GI_RetailPrice<=? ");
			params.add(Utility.getName(po.getBgiretailendprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getBgiiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sb.append(" and B_GI_FrameMaterialType=? ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
			sb.append(" and B_GI_EyeGlassMaterialType=? ");
			params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
		}
		if (!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBbdluminosityclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))){
			sb.append(" and B_GI_GradualClass=? ");
			params.add(Utility.getName(po.getBgigradualclass()));
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))){
			sb.append(" and B_GI_FunctionClass=? ");
			params.add(Utility.getName(po.getBgifunctionclass()));
		}
		if (!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive= ?");
			params.add(Utility.getName(po.getBgirefractive()));
		}
		if (!"".equals(Utility.getName(po.getBgiusetype()))){
			sb.append(" and B_GI_UseType= ?");
			params.add(Utility.getName(po.getBgiusetype()));
		}		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))){
			sb.append(" and B_GI_StealthClass= ?");
			params.add(Utility.getName(po.getBgistealthclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
//			sb.append(" and B_GI_AccessoriesType=? ");
//			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		if (!"".equals(Utility.getName(po.getBgisunglassesfuntion()))){
			sb.append(" and B_GI_SunGglassesFun=? ");
			params.add(Utility.getName(po.getBgisunglassesfuntion()));
		}
		sb.append(" and (( isnull(B_GI_isCustomize,'')='D' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_SphUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_SphUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_CylUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_CylUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}		
		sb.append(" ) or ( isnull(B_GI_isCustomize,'')='0' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_Sph as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_Sph as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_Cyl as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_Cyl as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}
		sb.append(" ) or isnull(B_GI_isCustomize,'') not in ('0','D')) ");
		sb.append(" group by (B_GI_GoodsCategoryID+'.'+B_GI_SupplierID+'.'+B_GI_BrandID),B_SP_SupplierName,B_GC_GoodsCategoryName,B_GI_SupplierID,B_GI_GoodsCategoryID,B_GI_BrandID,B_BD_brandName ) temp  ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询品种列表
	 */
	public List<GoodsInfoPo> getBrandList(GoodsInfoPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select bgigoodsid as bgigoodsid,bgigoodsname as bgigoodsname,bgisuppliername as bgisuppliername,bgigoodscategoryname as bgigoodscategoryname,bgisupplierid as bgisupplierid,? as bgiiscustomize,bgigoodscategoryid as bgigoodscategoryid,bgiretailbeginprice as bgiretailbeginprice,bgiretailendprice as bgiretailendprice,bgibrandid as bgibrandid,bgigoodsname as bgibrandname,'3' as bgisalestype ");
		sb.append(" from (select ROW_NUMBER() Over(order by (B_GI_GoodsCategoryID+'.'+B_GI_SupplierID+'.'+B_GI_BrandID)) as rowNum,(B_GI_GoodsCategoryID+'.'+B_GI_SupplierID+'.'+B_GI_BrandID) as bgigoodsid,B_BD_brandName as bgigoodsname,B_SP_SupplierName as bgisuppliername,B_GC_GoodsCategoryName as bgigoodscategoryname,B_GI_SupplierID as bgisupplierid,B_GI_GoodsCategoryID as bgigoodscategoryid,min(B_GI_RetailPrice) as bgiretailbeginprice,max(B_GI_RetailPrice) as bgiretailendprice,B_GI_BrandID as bgibrandid ");		
		sb.append(" from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where B_GI_Flag='1' and B_GI_SupplierID<>'ZZ' ");
		
		params.add(Utility.getName(po.getBgiiscustomize()));
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getBgisupplierid()));
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getBgibrandid()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))){
			sb.append(" and B_GI_RetailPrice>=? ");
			params.add(Utility.getName(po.getBgiretailbeginprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))){
			sb.append(" and B_GI_RetailPrice<=? ");
			params.add(Utility.getName(po.getBgiretailendprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getBgiiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sb.append(" and B_GI_FrameMaterialType=? ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
			sb.append(" and B_GI_EyeGlassMaterialType=? ");
			params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
		}
		if (!"".equals(Utility.getName(po.getBbdluminosityclass()))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBbdluminosityclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))){
			sb.append(" and B_GI_GradualClass=? ");
			params.add(Utility.getName(po.getBgigradualclass()));
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))){
			sb.append(" and B_GI_FunctionClass=? ");
			params.add(Utility.getName(po.getBgifunctionclass()));
		}
		if (!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive= ?");
			params.add(Utility.getName(po.getBgirefractive()));
		}
		if (!"".equals(Utility.getName(po.getBgiusetype()))){
			sb.append(" and B_GI_UseType= ?");
			params.add(Utility.getName(po.getBgiusetype()));
		}		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))){
			sb.append(" and B_GI_StealthClass= ?");
			params.add(Utility.getName(po.getBgistealthclass()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
//			sb.append(" and B_GI_AccessoriesType=? ");
//			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		if (!"".equals(Utility.getName(po.getBgisunglassesfuntion()))){
			sb.append(" and B_GI_SunGglassesFun=? ");
			params.add(Utility.getName(po.getBgisunglassesfuntion()));
		}
		sb.append(" and (( isnull(B_GI_isCustomize,'')='D' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_SphUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_SphUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_CylUL as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_CylUP as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}		
		sb.append(" ) or ( isnull(B_GI_isCustomize,'')='0' ");
		if (!"".equals(Utility.getName(po.getBgisphul()))){
			sb.append(" and cast(B_GI_Sph as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphul()));
		}
		if (!"".equals(Utility.getName(po.getBgisphup()))){
			sb.append(" and cast(B_GI_Sph as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgisphup()));
		}
		if (!"".equals(Utility.getName(po.getBgicylul()))){
			sb.append(" and cast(B_GI_Cyl as float) <= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylul()));
		}
		if (!"".equals(Utility.getName(po.getBgicylup()))){
			sb.append(" and cast(B_GI_Cyl as float) >= cast(? as float) ");
			params.add(Utility.getName(po.getBgicylup()));
		}
		sb.append(" ) or isnull(B_GI_isCustomize,'') not in ('0','D')) ");
		
		sb.append(" group by (B_GI_GoodsCategoryID+'.'+B_GI_SupplierID+'.'+B_GI_BrandID),B_SP_SupplierName,B_GC_GoodsCategoryName,B_GI_SupplierID,B_GI_GoodsCategoryID,B_GI_BrandID,B_BD_brandName ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/****************************************************************************************************************/
	
	/**
	 * 查询积分累计规则总数
	 */
	public int getIntegralSetCount(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_IR_ID) from F_IntegralRule where 1=1 ");		
	
		if (!"".equals(Utility.getName(po.getFirGoodsCategoryID()))){
			sb.append(" and F_IR_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFirGoodsCategoryID()));
		}
		if (!"".equals(Utility.getName(po.getFirSupplierID()))){
			sb.append(" and F_IR_SupplierID=? ");
			params.add(Utility.getName(po.getFirSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getFirBrandID()))){
			sb.append(" and F_IR_BrandID=? ");
			params.add(Utility.getName(po.getFirBrandID()));
		}
		if (!"".equals(Utility.getName(po.getFirIscustomize()))){
			sb.append(" and F_IR_Iscustomize=? ");
			params.add(Utility.getName(po.getFirIscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and F_IR_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and F_IR_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if (!"".equals(Utility.getName(po.getFirdepartmentid()))){
			
			String[] array=Utility.getName(po.getFirdepartmentid()).split(",");
			sb.append(" and ( charindex((',' + ? + ','),(','+ F_IR_DepartmentID + ',')) >0 ");
			params.add(array[0]);
			
			for(int i = 1;i<array.length; i++){
				sb.append(" or charindex((',' + ? + ','),(','+ F_IR_DepartmentID + ',')) >0 ");
				params.add(array[i]);
			}
			sb.append(" ) "); 
		}
		if (!"".equals(Utility.getName(po.getFirmembertype()))){
			
			String[] array2=Utility.getName(po.getFirmembertype()).split(",");
			sb.append(" and ( charindex((',' + ? + ','),(','+ F_IR_MemberType + ',')) >0 ");
			params.add(array2[0]);
			
			for(int i = 1;i<array2.length; i++){
				sb.append(" or charindex((',' + ? + ','),(','+ F_IR_MemberType + ',')) >0 ");
				params.add(array2[i]);
			}
			sb.append(" ) "); 
		}

		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询积分累计规则列表
	 */
	public List<IntegralPo> getIntegralSetList(IntegralPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select firID as firID,firGoodsCategoryName as firGoodsCategoryName,firGoodsID as firGoodsID,firSupplierName as firSupplierName,firBrandName as firBrandName,firGoodsName as firGoodsName,firIntegralCount as firIntegralCount,firdepartmentname as firdepartmentname,firmembertypename as firmembertypename ");
		sb.append(" from (select ROW_NUMBER() Over(order by F_IR_GoodsCategoryID,F_IR_SupplierID,F_IR_BrandID,F_IR_GoodsID ) as rowNum,F_IR_ID as firID,F_IR_GoodsCategoryName as firGoodsCategoryName,F_IR_SupplierName as firSupplierName,F_IR_BrandName as firBrandName,F_IR_GoodsName as firGoodsName,F_IR_Goodsid as firGoodsID,F_IR_IntegralCount as firIntegralCount, ");
		sb.append(" dbo.getDepartmentNameByID(F_IR_DepartmentID) as firdepartmentname,dbo.ufn_getMemberTypeNameByID(F_IR_MemberType) as firmembertypename ");
		sb.append(" from F_IntegralRule where 1=1  ");

		if (!"".equals(Utility.getName(po.getFirGoodsCategoryID()))){
			sb.append(" and F_IR_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFirGoodsCategoryID()));
		}
		if (!"".equals(Utility.getName(po.getFirSupplierID()))){
			sb.append(" and F_IR_SupplierID=? ");
			params.add(Utility.getName(po.getFirSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getFirBrandID()))){
			sb.append(" and F_IR_BrandID=? ");
			params.add(Utility.getName(po.getFirBrandID()));
		}
		if (!"".equals(Utility.getName(po.getFirIscustomize()))){
			sb.append(" and F_IR_Iscustomize=? ");
			params.add(Utility.getName(po.getFirIscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and F_IR_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and F_IR_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if (!"".equals(Utility.getName(po.getFirdepartmentid()))){
			
			String[] array=Utility.getName(po.getFirdepartmentid()).split(",");
			sb.append(" and ( charindex((',' + ? + ','),(','+ F_IR_DepartmentID + ',')) >0 ");
			params.add(array[0]);
			
			for(int i = 1;i<array.length; i++){
				sb.append(" or charindex((',' + ? + ','),(','+ F_IR_DepartmentID + ',')) >0 ");
				params.add(array[i]);
			}
			sb.append(" ) "); 
		}
		if (!"".equals(Utility.getName(po.getFirmembertype()))){
			
			String[] array2=Utility.getName(po.getFirmembertype()).split(",");
			sb.append(" and ( charindex((',' + ? + ','),(','+ F_IR_MemberType + ',')) >0 ");
			params.add(array2[0]);
			
			for(int i = 1;i<array2.length; i++){
				sb.append(" or charindex((',' + ? + ','),(','+ F_IR_MemberType + ',')) >0 ");
				params.add(array2[i]);
			}
			sb.append(" ) "); 
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),IntegralPo.class);
	}

	/**
	 * 增加积分累计规则
	 * 
	 */
	public void insertIntegralSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_IntegralRule(F_IR_ID,  ");
		sb.append("F_IR_GoodsCategoryID,                ");
		sb.append("F_IR_Iscustomize,                ");
		sb.append("F_IR_SupplierID,                ");
		sb.append("F_IR_BrandID,                ");
		sb.append("F_IR_GoodsID,                ");
		sb.append("F_IR_GoodsName,                ");
		sb.append("F_IR_IntegralCount, F_IR_GoodsCategoryName, F_IR_SupplierName, F_IR_BrandName,             ");
		sb.append("F_IR_DepartmentID,                ");
		sb.append("F_IR_MemberType,                ");
		sb.append("F_IR_Reamrk                ");		
		sb.append("    )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)         ");

		params.add (this.uuid.generate());
        params.add (Utility.getName(po.getFirGoodsCategoryID()));
        params.add (Utility.getName(po.getFirIscustomize()));
        params.add (Utility.getName(po.getFirSupplierID()));
        params.add (Utility.getName(po.getFirBrandID()));
        params.add (Utility.getName(po.getFirGoodsID()));
        params.add (Utility.getName(po.getFirGoodsName()));
        params.add (Utility.getName(po.getFirIntegralCount()));
        params.add (Utility.getName(po.getFirGoodsCategoryName()));
        params.add (Utility.getName(po.getFirSupplierName()));
        params.add (Utility.getName(po.getFirBrandName()));
        params.add (Utility.getName(po.getFirdepartmentid()));
        params.add (Utility.getName(po.getFirmembertype()));

        params.add (Utility.getName(po.getFirReamrk()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 更新积分累计规则
	 * 
	 */
	public void updateIntegralSet(IntegralPo po){
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_IntegralRule set F_IR_IntegralCount=?,F_IR_Reamrk=? where F_IR_ID=? ");

		params.add (Utility.getName(po.getFirIntegralCount()));
		params.add (Utility.getName(po.getFirReamrk()));
		params.add (Utility.getName(po.getFirID()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 批量更新积分累计规则
	 * 
	 */
	public void updateBatchIntegralSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_IntegralRule set F_IR_IntegralCount=? where F_IR_ID=? ");

		params.add (Utility.getName(po.getFirIntegralCount()));
		params.add (Utility.getName(po.getFirID()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 删除积分累计规则
	 * 
	 */
	public void deleteIntegralSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from F_IntegralRule where F_IR_ID=? ");

		params.add (Utility.getName(po.getFirID()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询商品总数
	 */
	public int getGoodsCount(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(B_GI_GoodsID) from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID where 1=1 and B_GI_SupplierID<>'ZZ' ");		
	
		if (!"".equals(Utility.getName(po.getFirGoodsCategoryID()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFirGoodsCategoryID()));
		}
		if (!"".equals(Utility.getName(po.getFirSupplierID()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getFirSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getFirBrandID()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getFirBrandID()));
		}
		if (!"".equals(Utility.getName(po.getFirIscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getFirIscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if ("1".equals(Utility.getName(po.getFirGoodsCategoryID())) && !"".equals(Utility.getName(po.getFirTeachnologyType()))){
			sb.append(" and B_GI_frameProcessCraftType=? ");
			params.add(Utility.getName(po.getFirTeachnologyType()));
		}
		if (!"".equals(Utility.getName(po.getFirRetailPrice()))){
			sb.append(" and B_GI_RetailPrice=? ");
			params.add(Utility.getName(po.getFirRetailPrice()));
		}
		if (!"".equals(Utility.getName(po.getFirCostPrice()))){
			sb.append(" and B_GI_CostPrice=? ");
			params.add(Utility.getName(po.getFirCostPrice()));
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(IntegralPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select bgigoodsid as bgigoodsid,bgigoodsname as bgigoodsname,bgisuppliername as bgisuppliername,bgiviewgoodsname as bgiviewgoodsname,bgigoodscategoryname as bgigoodscategoryname,bgisupplierid as bgisupplierid,bgiiscustomize as bgiiscustomize,bgigoodscategoryid as bgigoodscategoryid,bgiretailprice as bgiretailprice,bgibrandid as bgibrandid,bgibrandname as bgibrandname,bgigoodsname as bgigoodsname,bgisph as bgisph,bgicyl as bgicyl,bgiunitname as bgiunitname ");
		sb.append(" from (select ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum,B_GI_ViewGoodsName           AS bgiviewgoodsname,B_GI_GoodsID as bgigoodsid,B_BD_brandName as bgibrandname,B_GI_ViewGoodsName as bgigoodsname,B_SP_SupplierName as bgisuppliername,B_GC_GoodsCategoryName as bgigoodscategoryname,B_GI_SupplierID as bgisupplierid,B_GI_GoodsCategoryID as bgigoodscategoryid,B_GI_RetailPrice as bgiretailprice,B_GI_isCustomize as bgiiscustomize,B_GI_BrandID as bgibrandid,B_GI_Sph as bgisph,B_GI_Cyl as bgicyl,B_UT_unitName as bgiunitname ");		
		sb.append(" from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID inner join B_Unit on B_GI_UnitId=B_UT_id where 1=1 and B_GI_SupplierID<>'ZZ' ");

		if (!"".equals(Utility.getName(po.getFirGoodsCategoryID()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFirGoodsCategoryID()));
		}
		if (!"".equals(Utility.getName(po.getFirSupplierID()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getFirSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getFirBrandID()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getFirBrandID()));
		}
		if (!"".equals(Utility.getName(po.getFirIscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getFirIscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if ("1".equals(Utility.getName(po.getFirGoodsCategoryID())) && !"".equals(Utility.getName(po.getFirTeachnologyType()))){
			sb.append(" and B_GI_frameProcessCraftType=? ");
			params.add(Utility.getName(po.getFirTeachnologyType()));
		}
		if (!"".equals(Utility.getName(po.getFirRetailPrice()))){
			sb.append(" and B_GI_RetailPrice=? ");
			params.add(Utility.getName(po.getFirRetailPrice()));
		}
		if (!"".equals(Utility.getName(po.getFirCostPrice()))){
			sb.append(" and B_GI_CostPrice=? ");
			params.add(Utility.getName(po.getFirCostPrice()));
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}	

	/**
	 * 查询商品列表
	 */
	public List<GoodsInfoPo> getGoodsList(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select B_GI_GoodsID as bgigoodsid,B_BD_brandName as bgibrandname,B_GI_ViewGoodsName as bgigoodsname,B_SP_SupplierName as bgisuppliername,B_GC_GoodsCategoryName as bgigoodscategoryname,B_GI_SupplierID as bgisupplierid,B_GI_GoodsCategoryID as bgigoodscategoryid,B_GI_RetailPrice as bgiretailprice,B_GI_isCustomize as bgiiscustomize,B_GI_BrandID as bgibrandid,B_GI_Sph as bgisph,B_GI_Cyl as bgicyl,B_UT_unitName as bgiunitname ");		
		sb.append(" from B_GoodsInfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_GoodsCategory on B_GI_GoodsCategoryID=B_GC_ID inner join B_Unit on B_GI_UnitId=B_UT_id where 1=1 and B_GI_SupplierID<>'ZZ' ");

		if (!"".equals(Utility.getName(po.getFirGoodsCategoryID()))){
			sb.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFirGoodsCategoryID()));
		}
		if (!"".equals(Utility.getName(po.getFirSupplierID()))){
			sb.append(" and B_GI_SupplierID=? ");
			params.add(Utility.getName(po.getFirSupplierID()));
		}
		if (!"".equals(Utility.getName(po.getFirBrandID()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(Utility.getName(po.getFirBrandID()));
		}
		if (!"".equals(Utility.getName(po.getFirIscustomize()))){
			sb.append(" and B_GI_isCustomize=? ");
			params.add(Utility.getName(po.getFirIscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if ("1".equals(Utility.getName(po.getFirGoodsCategoryID())) && !"".equals(Utility.getName(po.getFirTeachnologyType()))){
			sb.append(" and B_GI_frameProcessCraftType=? ");
			params.add(Utility.getName(po.getFirTeachnologyType()));
		}
		if (!"".equals(Utility.getName(po.getFirRetailPrice()))){
			sb.append(" and B_GI_RetailPrice=? ");
			params.add(Utility.getName(po.getFirRetailPrice()));
		}
		if (!"".equals(Utility.getName(po.getFirCostPrice()))){
			sb.append(" and B_GI_CostPrice=? ");
			params.add(Utility.getName(po.getFirCostPrice()));
		}
	
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}	
	
	/**
	 * 积分累计规则详细
	 * 
	 */
	public IntegralPo getIntegralSetDetail(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
	    sb.append(" select top 1 F_IR_ID as firID,F_IR_GoodsCategoryName as firGoodsCategoryName,F_IR_SupplierName as firSupplierName,F_IR_BrandName as firBrandName,F_IR_GoodsName as firGoodsName,F_IR_IntegralCount as firIntegralCount, ");	
		sb.append(" dbo.getDepartmentNameByID(F_IR_DepartmentID) as firdepartmentname,dbo.ufn_getMemberTypeNameByID(F_IR_MemberType) as firmembertypename, ");
		sb.append(" F_IR_GoodsCategoryID as firGoodsCategoryID,F_IR_Iscustomize as firIscustomize,F_IR_SupplierID as firSupplierID,F_IR_BrandID as firBrandID,F_IR_GoodsID as firGoodsID,F_IR_Reamrk as firReamrk from F_IntegralRule where F_IR_ID=?  ");

		params.add(Utility.getName(po.getFirID()));
		
		return (IntegralPo)queryForObject(sb.toString(), params.toArray(),IntegralPo.class);
	}
	
	/**
	 * 累计规则编号是否存在
	 * 
	 */
	public int isExistIntegralSet(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_IR_ID) from F_IntegralRule where F_IR_GoodsCategoryID=? and F_IR_SupplierID=? and F_IR_BrandID=? and F_IR_GoodsID=? ");
	
		params.add(Utility.getName(po.getFirGoodsCategoryID()));
		params.add(Utility.getName(po.getFirSupplierID()));
		params.add(Utility.getName(po.getFirBrandID()));
		params.add(Utility.getName(po.getFirGoodsID()));
		
		if(!"".equals(Utility.getName(po.getFirIscustomize())))
		{
			sb.append(" and F_IR_Iscustomize=? ");
			params.add(Utility.getName(po.getFirIscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFirdepartmentid()))){
			
			String[] array=Utility.getName(po.getFirdepartmentid()).split(",");
			sb.append(" and ( charindex((',' + ? + ','),(','+ F_IR_DepartmentID + ',')) >0 ");
			params.add(array[0]);
			
			for(int i = 1;i<array.length; i++){
				sb.append(" or charindex((',' + ? + ','),(','+ F_IR_DepartmentID + ',')) >0 ");
				params.add(array[i]);
			}
			sb.append(" ) "); 
		}
		if (!"".equals(Utility.getName(po.getFirmembertype()))){
			
			String[] array2=Utility.getName(po.getFirmembertype()).split(",");
			sb.append(" and ( charindex((',' + ? + ','),(','+ F_IR_MemberType + ',')) >0 ");
			params.add(array2[0]);
			
			for(int i = 1;i<array2.length; i++){
				sb.append(" or charindex((',' + ? + ','),(','+ F_IR_MemberType + ',')) >0 ");
				params.add(array2[i]);
			}
			sb.append(" ) "); 
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/****************************************************************************************************************/
	
	
/****************************************************************************************************************/
	
	/**
	 * 查询最大折扣设置总数
	 */
	public int getMaxDiscountSetCount(MaxDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_MD_ID) from F_MaxDiscount where 1=1 ");		
	
		if (!"".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append(" and F_MD_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getFmdiscustomize()))){
			sb.append(" and F_MD_Iscustomize=? ");
			params.add(Utility.getName(po.getFmdiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFmdsupplierid()))){
			sb.append(" and F_MD_SupplierID=? ");
			params.add(Utility.getName(po.getFmdsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getFmdbrandid()))){
			sb.append(" and F_MD_BrandID=? ");
			params.add(Utility.getName(po.getFmdbrandid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsid()))){
			sb.append(" and F_MD_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsname()))){
			sb.append(" and F_MD_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsname()));
		}

		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询最大折扣设置列表
	 */
	public List<MaxDiscountPo> getMaxDiscountSetList(MaxDiscountPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select fmdid as fmdid,fmdiscustomize as fmdiscustomize,fmdgoodsid as fmdgoodsid,fmdgoodscategoryname as fmdgoodscategoryname,fmdsuppliername as fmdsuppliername,fmdbrandname as fmdbrandname,fmdgoodsname as fmdgoodsname,fmdmaxdiscount as fmdmaxdiscount ");
		sb.append(" from (select ROW_NUMBER() Over(order by F_MD_GoodsCategoryID,F_MD_SupplierID,F_MD_BrandID) as rowNum,F_MD_GoodsID as fmdgoodsid,F_MD_ID as fmdid,F_MD_Iscustomize as fmdiscustomize,F_MD_GoodsCategoryName as fmdgoodscategoryname,F_MD_SupplierName as fmdsuppliername,F_MD_BrandName as fmdbrandname,F_MD_GoodsName as fmdgoodsname,F_MD_MaxDiscount as fmdmaxdiscount ");		
		sb.append(" from F_MaxDiscount where 1=1  ");

		if (!"".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append(" and F_MD_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getFmdsupplierid()))){
			sb.append(" and F_MD_SupplierID=? ");
			params.add(Utility.getName(po.getFmdsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getFmdbrandid()))){
			sb.append(" and F_MD_BrandID=? ");
			params.add(Utility.getName(po.getFmdbrandid()));
		}
		if (!"".equals(Utility.getName(po.getFmdiscustomize()))){
			sb.append(" and F_MD_Iscustomize=? ");
			params.add(Utility.getName(po.getFmdiscustomize()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsid()))){
			sb.append(" and F_MD_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getFmdgoodsname()))){
			sb.append(" and F_MD_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFmdgoodsname()));
		}
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),MaxDiscountPo.class);
	}

	/**
	 * 增加最大折扣设置
	 * 
	 */
	public void insertMaxDiscountSet(MaxDiscountPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_MaxDiscount(   ");
		sb.append("F_MD_ID, 					");
		sb.append("F_MD_GoodsCategoryID,        ");
		sb.append("F_MD_Iscustomize,            ");
		sb.append("F_MD_SupplierID,             ");
		sb.append("F_MD_BrandID,                ");
		sb.append("F_MD_GoodsID,                ");
		sb.append("F_MD_GoodsName,              ");
		sb.append("F_MD_MaxDiscount,            ");
		sb.append("F_MD_GoodsCategoryName,      ");
		sb.append("F_MD_SupplierName,           ");
		sb.append("F_MD_BrandName,              ");
		sb.append("F_MD_Reamrk,                 ");	
		sb.append("F_MD_GoodsLevel              ");
		sb.append("    )values(?,?,?,?,?,?,?,?,?,?,?,?,?)         ");

		params.add (Utility.getName(po.getFmdid()));
        params.add (Utility.getName(po.getFmdgoodscategoryid()));
        params.add (Utility.getName(po.getFmdiscustomize()));
        params.add (Utility.getName(po.getFmdsupplierid()));
        params.add (Utility.getName(po.getFmdbrandid()));
        params.add (Utility.getName(po.getFmdgoodsid()));
        params.add (Utility.getName(po.getFmdgoodsname()));
        params.add (Utility.getName(po.getFmdmaxdiscount()));
        params.add (Utility.getName(po.getFmdgoodscategoryname()));
        params.add (Utility.getName(po.getFmdsuppliername()));
        params.add (Utility.getName(po.getFmdbrandname()));
        params.add (Utility.getName(po.getFmdreamrk()));
        params.add (Utility.getName(po.getFmdgoodslevel()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 更新最大折扣设置
	 * 
	 */
	public void updateMaxDiscountSet(MaxDiscountPo po){
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_MaxDiscount set F_MD_MaxDiscount=?,F_MD_Reamrk=? where F_MD_ID=? ");

		params.add (Utility.getName(po.getFmdmaxdiscount()));
		params.add (Utility.getName(po.getFmdreamrk()));
		params.add (Utility.getName(po.getFmdid()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 批量更新最大折扣设置
	 * 
	 */
	public void updateBatchMaxDiscountSet(MaxDiscountPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_MaxDiscount set F_MD_MaxDiscount=? where F_MD_ID=? ");

		params.add (Utility.getName(po.getFmdmaxdiscount()));
		params.add (Utility.getName(po.getFmdid()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 删除最大折扣设置
	 * 
	 */
	public void deleteMaxDiscountSet(MaxDiscountPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from F_MaxDiscount where F_MD_ID=? ");

		params.add (Utility.getName(po.getFmdid()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 最大折扣设置详细
	 * 
	 */
	public MaxDiscountPo getMaxDiscountSetDetail(MaxDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
	    sb.append(" select top 1 F_MD_ID as fmdid,F_MD_Iscustomize as fmdiscustomize,F_MD_GoodsCategoryName as fmdgoodscategoryname,F_MD_SupplierName as fmdsuppliername,F_MD_BrandName as fmdbrandname,F_MD_GoodsName as fmdgoodsname,F_MD_MaxDiscount as fmdmaxdiscount, ");		
		sb.append(" F_MD_GoodsCategoryID as fmdgoodscategoryid,F_MD_SupplierID as fmdsupplierid,F_MD_BrandID as fmdbrandid,F_MD_GoodsID as fmdgoodsid,F_MD_Reamrk as fmdreamrk, ");
		sb.append(" F_MD_GoodsLevel 	as fmdgoodslevel, ");
		sb.append(" B_GL_Name		 	as fmdgoodslevelname ");
		sb.append(" from F_MaxDiscount ");
		sb.append(" left join B_GoodsLevel on F_MD_GoodsLevel = B_GL_UUID");
		sb.append(" where F_MD_ID=?  ");

		params.add(Utility.getName(po.getFmdid()));
		
		return (MaxDiscountPo)queryForObject(sb.toString(), params.toArray(),MaxDiscountPo.class);
	}
	
	/**
	 * 设置最大折扣编号是否存在
	 * 
	 */
	public int isExistMaxDiscountSet(MaxDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_MD_ID) from F_MaxDiscount where F_md_GoodsCategoryID=? and F_md_SupplierID=? and F_md_BrandID=? and F_md_GoodsID=? ");
		params.add(Utility.getName(po.getFmdgoodscategoryid()));
		params.add(Utility.getName(po.getFmdsupplierid()));
		params.add(Utility.getName(po.getFmdbrandid()));
		params.add(Utility.getName(po.getFmdgoodsid()));
		if(!"".equals(Utility.getName(po.getFmdiscustomize())))
		{
			sb.append(" and F_MD_Iscustomize=? ");
			params.add(Utility.getName(po.getFmdiscustomize()));
		}	
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/****************************************************************************************************************/
	/****************************************************************************************************************/
	
	/**
	 * 查询积分兑换设置总数
	 */
	public int getIntegralExchangeSetCount(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_IR_GoodsID) from F_IntegralExchange where 1=1 ");		

		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and F_IR_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and F_IR_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if (!"".equals(Utility.getName(po.getFirjfmin()))){
			sb.append(" and F_IR_IntegralCount >= cast( ? as float) ");
			params.add(Utility.getName(po.getFirjfmin()));
		}
		if (!"".equals(Utility.getName(po.getFirjfmax()))){
			sb.append(" and F_IR_IntegralCount <= cast( ? as float) ");
			params.add(Utility.getName(po.getFirjfmax()));
		}

		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询积分兑换设置列表
	 */
	public List<IntegralPo> getIntegralExchangeSetList(IntegralPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select firGoodsID as firGoodsID,firGoodsName as firGoodsName,firIntegralCount as firIntegralCount,firFlag as firFlag ");
		sb.append(" from (select ROW_NUMBER() Over(order by F_IR_GoodsID) as rowNum,F_IR_GoodsID as firGoodsID,F_IR_GoodsName as firGoodsName,F_IR_IntegralCount as firIntegralCount,F_IR_Flag as firFlag from F_IntegralExchange where 1=1 ");		

		if (!"".equals(Utility.getName(po.getFirGoodsID()))){
			sb.append(" and F_IR_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsID()));
		}
		if (!"".equals(Utility.getName(po.getFirGoodsName()))){
			sb.append(" and F_IR_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getFirGoodsName()));
		}
		if (!"".equals(Utility.getName(po.getFirjfmin()))){
			sb.append(" and F_IR_IntegralCount >= cast( ? as float) ");
			params.add(Utility.getName(po.getFirjfmin()));
		}
		if (!"".equals(Utility.getName(po.getFirjfmax()))){
			sb.append(" and F_IR_IntegralCount <= cast( ? as float) ");
			params.add(Utility.getName(po.getFirjfmax()));
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),IntegralPo.class);
	}

	/**
	 * 增加积分兑换设置
	 * 
	 */
	public void insertIntegralExchangeSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into F_IntegralExchange(F_IR_GoodsID,F_IR_GoodsName,F_IR_IntegralCount,F_IR_Flag,F_IR_DepartmentID,F_IR_PersonNum,F_IR_GoodsSumNum,F_IR_GoodsEasyName)  ");
		sb.append(" values(?,?,?,?,?,?,?,?)         ");

        params.add (Utility.getName(po.getFirGoodsID()));
        params.add (Utility.getName(po.getFirGoodsName()));
        params.add (Utility.getName(po.getFirIntegralCount()));
        params.add (Utility.getName(po.getFirFlag()));
        params.add (Utility.getName(po.getFirdepartmentid()));
        params.add (Utility.getName(po.getFirpersonnum()));
        params.add (Utility.getName(po.getFirgoodssumnum()));
        params.add (Utility.getName(po.getFirgoodseasyname()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 更新积分兑换设置
	 * 
	 */
	public void updateIntegralExchangeSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_IntegralExchange set F_IR_IntegralCount=?,F_IR_DepartmentID=?,F_IR_PersonNum=?,F_IR_GoodsSumNum=?,F_IR_GoodsEasyName=?,F_IR_PicUrl=?,F_IR_Content=? where F_IR_GoodsID=? ");

		params.add(Utility.getName(po.getFirIntegralCount()));
		params.add(Utility.getName(po.getFirdepartmentid()));
		params.add(Utility.getName(po.getFirpersonnum()));
		params.add(Utility.getName(po.getFirgoodssumnum()));
		params.add(Utility.getName(po.getFirgoodseasyname()));
		params.add(Utility.getName(po.getFirpicurl()));
		params.add(Utility.getName(po.getFircontent()));
		params.add(Utility.getName(po.getFirGoodsID()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 删除积分兑换设置
	 * 
	 */
	public void deleteIntegralExchangeSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from F_IntegralExchange where F_IR_GoodsID=? ");

		params.add(Utility.getName(po.getFirGoodsID()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 积分兑换详细
	 * 
	 */
	public IntegralPo getIntegralExchangeSetDetail(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select top 1 F_IR_GoodsID as firGoodsID,dbo.getShopCodeNameList(F_IR_DepartmentID) as firdepartmentname,F_IR_DepartmentID as firdepartmentid,F_IR_GoodsName as firGoodsName,F_IR_IntegralCount as firIntegralCount,F_IR_Flag as firFlag,F_IR_PersonNum as firpersonnum,F_IR_GoodsSumNum as firgoodssumnum,F_IR_GoodsEasyName as firgoodseasyname,isnull(F_IR_PicUrl,'') as firpicurl,isnull(F_IR_Content,'') as fircontent from F_IntegralExchange where F_IR_GoodsID=? ");		

		params.add(Utility.getName(po.getFirGoodsID()));
		return (IntegralPo)queryForObject(sb.toString(), params.toArray(),IntegralPo.class);
	}
	
	/**
	 * 积分兑换停用启用
	 * 
	 */
	public void enableIntegralExchangeSet(IntegralPo po){
		
        StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update F_IntegralExchange set F_IR_Flag=? where F_IR_GoodsID=? ");

		params.add(Utility.getName(po.getFirFlag()));
		params.add(Utility.getName(po.getFirGoodsID()));
        
        getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 判断积分兑换是否存在
	 * 
	 */
	public int isExistIntegralExchangeSet(IntegralPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(F_IR_GoodsID) from F_IntegralExchange where F_IR_GoodsID=? ");
	
		params.add(Utility.getName(po.getFirGoodsID()));
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}	

	/****************************************************************************************************/
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenCount(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		sb.append(" exec usp_QuerySetMeal ?,?,?,? ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		params.add(Utility.getName(po.getSsmsmshopcode()));
		params.add(Utility.getName(po.getSsmsmsalesamount()));
		params.add(Utility.getName(po.getSsmsmsalestype()));
		
		return queryForObjectList(sb.toString(), params.toArray(),SetMealPo.class);
	}
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealPo> getSetMealOpenList(SetMealPo po, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append(" select ssmsmid as ssmsmid,ssmsmtitle as ssmsmtitle,ssmsmeffectivedate as ssmsmeffectivedate,ssmsmenddate as ssmsmenddate,ssmsmform as ssmsmform,ssmsmclassify as ssmsmclassify,ssmsmisdiscount as ssmsmisdiscount,ssmsmissum as ssmsmissum,ssmsmintegralsum as ssmsmintegralsum,ssmsmsalesbillamount as ssmsmsalesbillamount,ssmsmexpenseamount as ssmsmexpenseamount,ssmsmdiscountrate as ssmsmdiscountrate,ssmsmdetailform as ssmsmdetailform ");
		sb.append(" from (select ROW_NUMBER() Over(order by S_SM_SM_Title) as rowNum,S_SM_SM_ID as ssmsmid,S_SM_SM_Title as ssmsmtitle,S_SM_SM_EffectiveDate as ssmsmeffectivedate,S_SM_SM_EndDate as ssmsmenddate, ");		
		sb.append("  S_SM_SM_Form as ssmsmform,S_SM_SM_Classify as ssmsmclassify,S_SM_SM_IsDiscount as ssmsmisdiscount,S_SM_SM_IsSum as ssmsmissum,S_SM_SM_IsIntegralSum as ssmsmintegralsum,isnull(S_SM_SM_SalesBillAmount,0) as ssmsmsalesbillamount,isnull(S_SM_SM_ExpenseAmount,0) as ssmsmexpenseamount,isnull(S_SM_SM_DiscountRate,1) as ssmsmdiscountrate,S_SM_SM_DetailForm as ssmsmdetailform ");
		sb.append("  from S_SM_SetMeal where S_SM_SM_ID=? and (',' + S_SM_SM_ShopCode + ',') like '%,' + ? + ',%' and convert(varchar(10),getdate(),120)>=S_SM_SM_EffectiveDate  and convert(varchar(10),getdate(),120)<=S_SM_SM_EndDate and S_SM_SM_IsEnabled='1' and S_SM_SM_AuditState='1' ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		params.add(Utility.getName(po.getSsmsmshopcode()));
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(),SetMealPo.class);
	}
	
	/**
	 * 前台套餐开窗
	 */
	public List<SetMealEntryPo> getSetMealEntryOpen(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		sb.append(" exec usp_UpdateSetMealGoods ?,?,?,?,? ");
		
		params.add(Utility.getName(po.getSsmsmid()));
		params.add(Utility.getName(po.getSsmsmgoodsid()));
		params.add(Utility.getName(po.getSsmsmentryid()));
		params.add(Utility.getName(po.getSsmsmgoodsnum()));
		params.add(Utility.getName(po.getSsmsmsalesamount()));
		
		return queryForObjectList(sb.toString(), params.toArray(),SetMealEntryPo.class);
	}
	
	/**
	 * 查询积分兑换汇率
	 */
	public IntegralPo getIntegralCountList(String goodsid){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select dbo.getSalesIntegralByID(?) firIntegralCount ");		
		params.add(goodsid);		
		
		return (IntegralPo)queryForObject(sb.toString(), params.toArray(),IntegralPo.class);
	}
	
	public IntegralPo getIntegralCountList2(String goodsid,
			String departmentID, String memberType) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select dbo.getSalesIntegralByID(?,?,?) firIntegralCount ");		
		params.add(goodsid);
		params.add(departmentID);
		params.add(memberType);
		
		return (IntegralPo)queryForObject(sb.toString(), params.toArray(),IntegralPo.class);
	}
	
	/**
	 * 最大折扣查询（销售使用）
	 * 
	 */
	public MaxDiscountPo selectMaxDiscountSetPo(MaxDiscountPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT TOP 1 F_MD_ID                AS fmdid, ");
		sb.append("             F_MD_Iscustomize       AS fmdiscustomize, ");
		sb.append("             F_MD_GoodsCategoryName AS fmdgoodscategoryname, ");
		sb.append("             F_MD_SupplierName      AS fmdsuppliername, ");
		sb.append("             F_MD_BrandName         AS fmdbrandname, ");
		sb.append("             F_MD_GoodsName         AS fmdgoodsname, ");
		sb.append("             F_MD_MaxDiscount       AS fmdmaxdiscount, ");
		sb.append("             F_MD_GoodsCategoryID   AS fmdgoodscategoryid, ");
		sb.append("             F_MD_SupplierID        AS fmdsupplierid, ");
		sb.append("             F_MD_BrandID           AS fmdbrandid, ");
		sb.append("             F_MD_GoodsID           AS fmdgoodsid, ");
		sb.append("             F_MD_Reamrk            AS fmdreamrk ");
		sb.append("FROM   F_MaxDiscount ");
		sb.append("WHERE  1 = 1 ");
		if(!"".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append("       AND F_MD_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getFmdgoodscategoryid()));
		}
		
		if(!"".equals(Utility.getName(po.getFmdsupplierid()))){
			sb.append("       AND F_MD_SupplierID = ? ");
			params.add(Utility.getName(po.getFmdsupplierid()));
		}
		
		if(!"".equals(Utility.getName(po.getFmdbrandid()))){
			sb.append("       AND F_MD_BrandID = ? ");
			params.add(Utility.getName(po.getFmdbrandid()));
		}
		
		if(!"".equals(Utility.getName(po.getFmdgoodsid()))){
			sb.append("       AND F_MD_GoodsID = ? ");
			params.add(Utility.getName(po.getFmdgoodsid()));
		}
		
		if("".equals(Utility.getName(po.getFmdgoodsid())) && "".equals(Utility.getName(po.getFmdbrandid())) && "".equals(Utility.getName(po.getFmdsupplierid())) && "".equals(Utility.getName(po.getFmdgoodscategoryid()))){
			sb.append("       AND 1=2 ");
		}
		
		return (MaxDiscountPo)queryForObject(sb.toString(), params.toArray(),MaxDiscountPo.class);
	}
	
	/**
	 * 审核套餐
	 * 
	 */
	public void updateSetMealAudit(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMeal set S_SM_SM_AuditPerson=?,S_SM_SM_AuditState='1',S_SM_SM_AuditDate=getdate() where S_SM_SM_ID=? ");
		params.add(Utility.getName(po.getSsmsmauditperson()));
		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 审核套餐
	 * 
	 */
	public void updateSetMealRecordAudit(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMealRecord set S_SM_SM_AuditPerson=?,S_SM_SM_AuditState='1',S_SM_SM_AuditDate=getdate() where S_SM_SM_ID=? ");
		params.add(Utility.getName(po.getSsmsmauditperson()));
		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 反审核套餐
	 * 
	 */
	public void updateSetMealUnAudit(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMealRecord set S_SM_SM_AuditPerson=NULL,S_SM_SM_AuditState='0',S_SM_SM_AuditDate=NULL,S_SM_SM_IsEnabled='1',S_SM_SM_UnEnablePerson=NULL,S_SM_SM_UnEnableDate=NULL,S_SM_SM_UnAuditFlag='1' where S_SM_SM_ID=? ");

		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 停用套餐
	 * 
	 */
	public void updateSetMealAble(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMeal set S_SM_SM_IsEnabled=0,S_SM_SM_EndDate=convert(varchar(10),getdate(),120) where S_SM_SM_ID=? ");
		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 停用套餐
	 * 
	 */
	public void updateSetMealRecordAble(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMealRecord set S_SM_SM_IsEnabled=0,S_SM_SM_UnEnablePerson=?,S_SM_SM_UnEnableDate=getdate() where S_SM_SM_ID=? ");
		
		params.add(Utility.getName(po.getSsmsmauditperson()));
		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 修改套餐活动部门
	 * 
	 */
	public void updateSetMealDepartments(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMeal set S_SM_SM_ShopCode=?,S_SM_SM_UpdateDptPerson=?,S_SM_SM_UpdateDptDate=getdate(),S_SM_SM_EndDate=? where S_SM_SM_ID=? ");
		
		params.add(Utility.getName(po.getSsmsmshopcode()));
		params.add(Utility.getName(po.getSsmsmauditperson()));
		params.add(Utility.getName(po.getSsmsmenddate()));
		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 修改套餐活动部门
	 * 
	 */
	public void updateSetMealRecordDepartments(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update S_SM_SetMealRecord set S_SM_SM_ShopCode=?,S_SM_SM_UpdateDptPerson=?,S_SM_SM_UpdateDptDate=getdate(),S_SM_SM_EndDate=? where S_SM_SM_ID=? ");
		
		params.add(Utility.getName(po.getSsmsmshopcode()));
		params.add(Utility.getName(po.getSsmsmauditperson()));
		params.add(Utility.getName(po.getSsmsmenddate()));
		params.add(Utility.getName(po.getSsmsmid()));
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 复制套餐
	 * 
	 */
	public void insertSetMealCopy(SetMealPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_CopySetMeal ?,?,? ");		
		
		params.add(Utility.getName(po.getSsmsmid()));
		params.add(Utility.getName(po.getSsmsmcreateperson()));
		params.add(Utility.getName(po.getSsmsmcopyid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 复制套餐明细
	 * 
	 */
	public void insertSetMealEntryCopy(SetMealPo po){
		
	}
	
	/**
	 * 根据套餐分类查询商品类型
	 * 
	 */
	public List<SetMealParentPropertyPo> getGoodsCategoryBySetMealClassify(SetMealPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select S_SM_GP_TypeID as ssmpptypeid,S_SM_GP_PropertyID as ssmpppropertyid,S_SM_GP_PropertyName as ssmpppropertyname,S_SM_GP_ControlType as ssmppcontroltype,S_SM_GP_InternalSort as ssmppinternalsort  ");
		sb.append("   from S_SM_GoodsProperty where S_SM_GP_ParentID='0' and S_SM_GP_TypeID=?  ");
		
		params.add(Utility.getName(po.getSsmsmclassify()));
		
		return queryForObjectList(sb.toString(),params.toArray(),SetMealParentPropertyPo.class);
	}
	
	/**
	 * 根据商品类型查看商品属性
	 * 
	 */
	public List<SetMealChildPropertyPo> getGoodsPropertyByGoodsCategory(SetMealEntryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select S_SM_GP_TypeID as ssmcptypeid,S_SM_GP_PropertyID as ssmcppropertyid,S_SM_GP_PropertyName as ssmcppropertyname,S_SM_GP_ControlType as ssmcpcontroltype,S_SM_GP_InternalSort as ssmcpinternalsort  ");
		sb.append("   from S_SM_GoodsProperty where S_SM_GP_ParentID=? and S_SM_GP_TypeID=?  ");		
		
		params.add(Utility.getName(po.getSsmsggoodscategory()));	
		params.add(Utility.getName(po.getSsmsgsalestype()));
		
		return queryForObjectList(sb.toString(),params.toArray(),SetMealChildPropertyPo.class);
	}
	
	/**
	 * 根据商品属性查看商品属性值
	 * 
	 */
	public List<SetMealPropertyValuePo> getGoodsPropertyValueByGoodsProperty(SetMealEntryPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" exec usp_querySetMealProperty ?  ");
		
		params.add(Utility.getName(po.getSsmsgbigclass()));
		
		return queryForObjectList(sb.toString(),params.toArray(),SetMealPropertyValuePo.class);
	}
	
	public void insertMaxDiscountDetails(MaxDiscountDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_MaxDiscountDetails (");
		buffer.append(" F_MDD_UUID, ");
		buffer.append(" F_MDD_MaxID, ");
		buffer.append(" F_MDD_GoodsLevel, ");
		buffer.append(" F_MDD_Discount ");
		buffer.append(" )values( ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ?, ");
		buffer.append(" ? ");
		buffer.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getFmddmaxid());
		params.add(po.getFmddgoodslevel());
		params.add(po.getFmdddiscount());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<MaxDiscountDetailsPo> selectMaxDiscountDetails(MaxDiscountDetailsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("	F_MDD_UUID 					as fmdduuid, 			");
		buffer.append(" F_MDD_MaxID					as fmddmaxid, 			");
		buffer.append(" B_GL_UUID					as fmddgoodslevel, 		");
		buffer.append(" B_GL_Name					as fmddgoodslevelname, 	");
		buffer.append(" F_MDD_Discount				as fmdddiscount			");
		buffer.append(" from B_GoodsLevel ");
		buffer.append(" left join F_MaxDiscountDetails on F_MDD_GoodsLevel = B_GL_UUID and F_MDD_MaxID = ?");
		buffer.append(" order by B_GL_ID ");
		
		params.add(po.getFmddmaxid());

		return queryForObjectList(buffer.toString(), params.toArray(),MaxDiscountDetailsPo.class);
	}
	
	public void deleteMaxDiscountDetails(String pid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from F_MaxDiscountDetails ");
		buffer.append(" where F_MDD_MaxID = ? ");
		
		params.add(pid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}