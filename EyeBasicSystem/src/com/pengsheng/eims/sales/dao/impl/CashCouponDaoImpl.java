package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.CashCouponDao;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CashCouponDaoImpl extends BaseJdbcDaoSupport implements CashCouponDao {
	
	public int selectCashCoupon(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(B_CC_ID) from B_CashCoupon where B_CC_Card = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(cashCouponPo.getBcccard());
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public void insertCashCoupon(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into B_CashCoupon(B_CC_ID,B_CC_Card,B_CC_Amount, ");
		sb.append("B_CC_BeginDate,B_CC_EndDate,B_CC_Type,B_CC_Expense,B_CC_Mark,B_CC_CardPerson,B_CC_CardDate,B_CC_UseFlag,B_CC_wxflag) ");
		sb.append("values(?,?,?,?,?,?,?,?,?,getdate(),?,?) ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(this.uuid.generate()));
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		params.add(Utility.getName(cashCouponPo.getBccamount()));
		params.add(Utility.getName(cashCouponPo.getBccbegindate()));
		params.add(Utility.getName(cashCouponPo.getBccenddate()));
		params.add(Utility.getName(cashCouponPo.getBcctype()));
		params.add(Utility.getName(cashCouponPo.getBccexpense()));
		params.add(Utility.getName(cashCouponPo.getBccmark()));
		params.add(Utility.getName(cashCouponPo.getBcccardperson()));
		params.add("0");
		params.add(Utility.getName(cashCouponPo.getBccwxflag()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	public void updateCashCoupon(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("update B_CashCoupon set B_CC_Amount=?,B_CC_BeginDate=?,B_CC_EndDate=?,");
		sb.append("B_CC_Type=?,B_CC_Expense=?,B_CC_Mark=?,B_CC_CardPerson=?,B_CC_CardDate=getdate(),B_CC_UseFlag=?,B_CC_wxflag=? where B_CC_ID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBccamount()));
		params.add(Utility.getName(cashCouponPo.getBccbegindate()));
		params.add(Utility.getName(cashCouponPo.getBccenddate()));
		params.add(Utility.getName(cashCouponPo.getBcctype()));
		params.add(Utility.getName(cashCouponPo.getBccexpense()));
		params.add(Utility.getName(cashCouponPo.getBccmark()));
		params.add(Utility.getName(cashCouponPo.getBcccardperson()));
		params.add("0");
		params.add(Utility.getName(cashCouponPo.getBccwxflag()));
		params.add(Utility.getName(cashCouponPo.getBccid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	public void deleteCashCoupon(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from B_CashCoupon where B_CC_ID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBccid()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	public CashCouponPo getCashCoupon(CashCouponPo cashCouponPo){
				
		StringBuffer sb = new StringBuffer();
		sb.append("select B_CC_ID as bccid,");
		sb.append("B_CC_Card as bcccard,");
		sb.append("B_CC_Amount as bccamount,");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate,");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate,");
		sb.append("B_CC_Type as bcctype,");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename,");
		sb.append("B_CC_Expense as bccexpense,");
		sb.append("B_CC_wxflag as bccwxflag,");
		sb.append("B_CC_Mark as bccmark ");
		sb.append("from B_CashCoupon where B_CC_ID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBccid()));
		
		return (CashCouponPo)queryForObject(sb.toString(), params.toArray(),CashCouponPo.class);
		
	}	
	
	public int getCashCouponCount(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(B_CC_ID) ");
		sb.append(" from B_CashCoupon ");
		sb.append("left join S_ME_CustomerInfo on S_ME_CI_CustomerID=B_CC_Customer ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on a.ID=B_CC_CardPerson ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on b.ID=B_CC_UsePerson ");
		sb.append("where  1=1 ");
		if (!"".equals(Utility.getName(cashCouponPo.getBccuseflag()))) {
			
		    sb.append("and B_CC_UseFlag=? ");
		    params.add(cashCouponPo.getBccuseflag());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccard()))) {
		    sb.append("and B_CC_Card like '%'+?+'%' ");
	        params.add(cashCouponPo.getBcccard());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcctype()))) {
		    sb.append("and B_CC_Type like '%'+?+'%' ");
	        params.add(cashCouponPo.getBcctype());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccuseamount1()))) {
		    sb.append("and B_CC_Amount>=? ");
	        params.add(cashCouponPo.getBccuseamount1());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccuseamount2()))) {
		    sb.append("and B_CC_Amount<=? ");
	        params.add(cashCouponPo.getBccuseamount2());		
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccbegindate()))) {
		    sb.append("and convert(varchar(10),B_CC_BeginDate,120)>=? ");
	        params.add(cashCouponPo.getBccbegindate());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccenddate()))) {
		    sb.append("and convert(varchar(10),B_CC_EndDate,120)<=? ");
	        params.add(cashCouponPo.getBccenddate());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccarddate1()))) {
		    sb.append("and convert(varchar(10),B_CC_CardDate,120)>=? ");
	        params.add(cashCouponPo.getBcccarddate1());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccarddate2()))) {
		    sb.append("and convert(varchar(10),B_CC_CardDate,120)<=? ");
	        params.add(cashCouponPo.getBcccarddate2());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccusedate1()))) {
		    sb.append("and convert(varchar(10),B_CC_UseDate,120)>=? ");
	        params.add(cashCouponPo.getBccusedate1());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccusedate2()))) {
		    sb.append("and convert(varchar(10),B_CC_UseDate,120)<=? ");
	        params.add(cashCouponPo.getBccusedate2());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccustomer()))) {
		    sb.append("and S_ME_CI_Name like '%'+?+'%' ");
	        params.add(cashCouponPo.getBcccustomer());
		}
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public List<CashCouponPo> getCashCouponList(CashCouponPo cashCouponPo, int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by B_CC_CardDate desc) as 'rowNum', ");
		sb.append("B_CC_ID as bccid,");
		sb.append("B_CC_Card as bcccard,");
		sb.append("B_CC_Amount as bccamount,");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate,");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate,");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctype,");
		sb.append("B_CC_Expense as bccexpense,");
		sb.append("B_CC_Mark as bccmark,");
		sb.append("S_ME_CI_Name as bcccustomer,");
		sb.append("a.personName as bcccardperson,");
		sb.append("convert(varchar(10),B_CC_CardDate,120) as bcccarddate,");
		sb.append("b.personName as bccuseperson,");
		sb.append("convert(varchar(10),B_CC_UseDate,120) as bccusedate,");
		sb.append("B_CC_UseFlag as bccuseflag,");
		sb.append("B_CC_UseAmount as bccuseamount ");
		sb.append(" from B_CashCoupon ");
		sb.append("left join S_ME_CustomerInfo on S_ME_CI_CustomerID=B_CC_Customer ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on a.ID=B_CC_CardPerson ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on b.ID=B_CC_UsePerson ");
		sb.append("where  1=1 ");
		if (!"".equals(Utility.getName(cashCouponPo.getBccuseflag()))) {
			
		    sb.append("and B_CC_UseFlag=? ");
		    params.add(cashCouponPo.getBccuseflag());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccard()))) {
		    sb.append("and B_CC_Card like '%'+?+'%' ");
	        params.add(cashCouponPo.getBcccard());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcctype()))) {
		    sb.append("and B_CC_Type like '%'+?+'%' ");
	        params.add(cashCouponPo.getBcctype());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccuseamount1()))) {
		    sb.append("and B_CC_Amount>=? ");
	        params.add(cashCouponPo.getBccuseamount1());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccuseamount2()))) {
		    sb.append("and B_CC_Amount<=? ");
	        params.add(cashCouponPo.getBccuseamount2());		
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccbegindate()))) {
		    sb.append("and convert(varchar(10),B_CC_BeginDate,120)>=? ");
	        params.add(cashCouponPo.getBccbegindate());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccenddate()))) {
		    sb.append("and convert(varchar(10),B_CC_EndDate,120)<=? ");
	        params.add(cashCouponPo.getBccenddate());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccarddate1()))) {
		    sb.append("and convert(varchar(10),B_CC_CardDate,120)>=? ");
	        params.add(cashCouponPo.getBcccarddate1());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccarddate2()))) {
		    sb.append("and convert(varchar(10),B_CC_CardDate,120)<=? ");
	        params.add(cashCouponPo.getBcccarddate2());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccusedate1()))) {
		    sb.append("and convert(varchar(10),B_CC_UseDate,120)>=? ");
	        params.add(cashCouponPo.getBccusedate1());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBccusedate2()))) {
		    sb.append("and convert(varchar(10),B_CC_UseDate,120)<=? ");
	        params.add(cashCouponPo.getBccusedate2());
		}
		if (!"".equals(Utility.getName(cashCouponPo.getBcccustomer()))) {
		    sb.append("and S_ME_CI_Name like '%'+?+'%' ");
	        params.add(cashCouponPo.getBcccustomer());
		}
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),CashCouponPo.class);
		
	}
	public CashCouponPo getCashCouponDelete(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select B_CC_ID as bccid,");
		sb.append("B_CC_Card as bcccard,");
		sb.append("B_CC_Amount as bccamount,");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate,");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate,");
		sb.append("B_CC_Type as bcctype,");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename,");
		sb.append("B_CC_Expense as bccexpense,");
		sb.append("B_CC_Mark as bccmark ");
		sb.append("from B_CashCoupon where B_CC_ID=? and B_CC_UseFlag='0'");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBccid()));
		
		return (CashCouponPo)queryForObject(sb.toString(), params.toArray(),CashCouponPo.class);
	}
	public CashCouponPo getCashCouponPo(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select B_CC_ID as bccid,");
		sb.append("B_CC_Card as bcccard,");
		sb.append("B_CC_Amount as bccamount,");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate,");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate,");
		sb.append("B_CC_Type as bcctype,");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename,");
		sb.append("B_CC_Expense as bccexpense,");
		sb.append("B_CC_Mark as bccmark ");
		sb.append("from B_CashCoupon where B_CC_Card=? and B_CC_UseFlag='0' ");
		sb.append("and convert(varchar(10),B_CC_BeginDate,120)<=convert(varchar(10),getdate(),120) ");
		sb.append("and convert(varchar(10),B_CC_EndDate,120)>=convert(varchar(10),getdate(),120) ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		
		return (CashCouponPo)queryForObject(sb.toString(), params.toArray(),CashCouponPo.class);
		
	}
	public CashCouponPo getCashCouponPo2(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select B_CC_ID as bccid,");
		sb.append("B_CC_Card as bcccard,");
		sb.append("B_CC_Amount as bccamount,");
		sb.append("B_CC_UseAmount as bccuseamount,");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate,");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate,");
		sb.append("B_CC_Type as bcctype,");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename,");
		sb.append("B_CC_Expense as bccexpense,");
		sb.append("B_CC_Mark as bccmark ");
		sb.append("from B_CashCoupon where B_CC_Card=? and B_CC_UseFlag='1' ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		
		return (CashCouponPo)queryForObject(sb.toString(), params.toArray(),CashCouponPo.class);
		
	}
	public CashCouponPo getCashCouponPogg(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		sb.append("select B_CC_ID as bccid, ");
		sb.append("B_CC_Card as bcccard, ");
		sb.append("B_CC_Amount as bccamount, ");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate, ");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate, ");
		sb.append("B_CC_Type as bcctype, ");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename, ");
		sb.append("B_CC_Expense as bccexpense, ");
		sb.append("B_CC_Mark as bccmark  ");
		sb.append("from B_CashCoupon where 1=1  ");
		sb.append("and B_CC_Card=?  ");
		sb.append("and B_CC_UseFlag='0'  ");
		sb.append("and convert(varchar(10),B_CC_BeginDate,120)<=convert(varchar(10),getdate(),120)  ");
		sb.append("and convert(varchar(10),B_CC_EndDate,120)>=convert(varchar(10),getdate(),120) ");
		sb.append("union all ");
		sb.append("select B_CC_ID as bccid, ");
		sb.append("B_CC_Card as bcccard, ");
		sb.append("B_CC_Amount as bccamount, ");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate, ");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate, ");
		sb.append("B_CC_Type as bcctype, ");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename, ");
		sb.append("B_CC_Expense as bccexpense, ");
		sb.append("B_CC_Mark as bccmark  ");
		sb.append("from S_SE_SalesLog ");
		sb.append("inner join B_CashCoupon on S_SE_SL_SourceID=B_CC_Card ");
		sb.append("where 1=1 ");
		sb.append("and (S_SE_SL_PaymentType ='1' or S_SE_SL_PaymentType ='2' or S_SE_SL_PaymentType ='3')  ");
		sb.append("and S_SE_SL_ConsumptionID='7' ");
		sb.append("and S_SE_SL_SalesID=? ");
		sb.append("and S_SE_SL_SourceID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		params.add(Utility.getName(cashCouponPo.getSalesid()));
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		
		return (CashCouponPo)queryForObject(sb.toString(), params.toArray(),CashCouponPo.class);
		
	}
	
	public void updateCashCouponState(CashCouponPo cashCouponPo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("update B_CashCoupon set B_CC_UseDate=getdate(),B_CC_Customer=?,B_CC_UsePerson=?,B_CC_UseFlag=?,B_CC_UseAmount=? where B_CC_Card=?");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cashCouponPo.getBcccustomer()));
		params.add(Utility.getName(cashCouponPo.getBccuseperson()));
		params.add(Utility.getName(cashCouponPo.getBccuseflag()));
		params.add(Utility.getName(cashCouponPo.getBccuseamount()));
		params.add(Utility.getName(cashCouponPo.getBcccard()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	public void updateCashCouponState2(CashCouponPo cashCouponPo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("update B_CashCoupon set B_CC_UseDate=NULL,B_CC_Customer=NULL,B_CC_UsePerson=NULL,B_CC_UseFlag=?,B_CC_UseAmount=NULL where B_CC_Card=?");
		
		List<String> params = new ArrayList<String>();

		params.add(Utility.getName(cashCouponPo.getBccuseflag()));

		params.add(Utility.getName(cashCouponPo.getBcccard()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	public List<CashCouponPo> getCashCouponList2(String customerID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select B_CC_Card as bcccard from S_SE_SalesLog ");
		sb.append("inner join B_CashCoupon on S_SE_SL_SourceID = B_CC_Card ");
		sb.append("where S_SE_SL_PaymentType='6' ");
		sb.append("and S_SE_SL_ConsumptionID='7' ");
		sb.append("and B_CC_Customer = ? ");
		sb.append("and convert(varchar(10),S_SE_SL_DateTime,120)=convert(varchar(10),getdate(),120) ");
		
		params.add(Utility.getName(customerID));
		
		return queryForObjectList(sb.toString(), params.toArray(),CashCouponPo.class);
	}
	public List<CashCouponPo> getCashCouponList3(String customerID){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select B_CC_Card as bcccard from S_SE_SalesLog ");
		sb.append("inner join B_CashCoupon on S_SE_SL_SourceID = B_CC_Card ");
		sb.append("where S_SE_SL_PaymentType='8' ");
		sb.append("and S_SE_SL_ConsumptionID='7' ");
		sb.append("and B_CC_Customer = ? ");
		sb.append("and convert(varchar(10),S_SE_SL_DateTime,120)=convert(varchar(10),getdate(),120) ");
		
		params.add(Utility.getName(customerID));
		
		return queryForObjectList(sb.toString(), params.toArray(),CashCouponPo.class);
	}
	public List<CashCouponPo> getCashCouponList4(CashCouponPo cashCouponPo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select B_CC_ID as bccid, ");
		sb.append("B_CC_Card as bcccard, ");
		sb.append("B_CC_Amount as bccamount, ");
		sb.append("convert(varchar(10),B_CC_BeginDate,120) as bccbegindate, ");
		sb.append("convert(varchar(10),B_CC_EndDate,120) as bccenddate, ");
		sb.append("B_CC_Type as bcctype, ");
		sb.append("dbo.ufn_getSalesTypeNameByID(B_CC_Type) as bcctypename, ");
		sb.append("B_CC_Expense as bccexpense, ");
		sb.append("B_CC_Mark as bccmark  ");
		sb.append("from S_SE_SalesLog ");
		sb.append("inner join B_CashCoupon on S_SE_SL_SourceID=B_CC_Card ");
		sb.append("where 1=1 ");
		sb.append("and (S_SE_SL_PaymentType ='1' or S_SE_SL_PaymentType ='2' or S_SE_SL_PaymentType ='3')  ");
		sb.append("and S_SE_SL_ConsumptionID='7' ");
		sb.append("and S_SE_SL_SalesID=? ");
		
		params.add(Utility.getName(cashCouponPo.getSalesid()));
		
		return queryForObjectList(sb.toString(), params.toArray(),CashCouponPo.class);
	}
	
	public void updateCashCouponState(List<CashCouponPo> ccpList){		
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (CashCouponPo cashCouponPo : ccpList){
			sb.append(" update B_CashCoupon set B_CC_UseDate=getdate(),B_CC_Customer=?,B_CC_UsePerson=?,B_CC_UseFlag=?,B_CC_UseAmount=? where B_CC_Card=? ");

			params.add(Utility.getName(cashCouponPo.getBcccustomer()));
			params.add(Utility.getName(cashCouponPo.getBccuseperson()));
			params.add(Utility.getName(cashCouponPo.getBccuseflag()));
			params.add(Utility.getName(cashCouponPo.getBccuseamount()));
			params.add(Utility.getName(cashCouponPo.getBcccard()));			
		}
		
		getJdbcTemplate().update(sb.toString(),params.toArray());		
	}

	/**
	 * 批量新增代金券时，判断哪些代金券号已经被使用
	 * @param cardString
	 * @return
	 */
	public List<CashCouponPo> getCashCouponListIsExist(String cardString){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SELECT B_CC_Card AS bcccard ");
		sb.append("FROM   B_CashCoupon ");
		sb.append("       INNER JOIN (SELECT str2table ");
		sb.append("                   FROM   dbo.Strtotable(?))t ");
		sb.append("         ON t.str2table = B_CC_Card ");
		
		params.add(Utility.getName(cardString));
		
		return queryForObjectList(sb.toString(), params.toArray(),CashCouponPo.class);
	}
	
	/**
	 * 批量删除代金券
	 * @param cardString
	 * @return
	 */
	public void deleteCashCouponBatch(String cardString){
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from B_CashCoupon where B_CC_Card in (SELECT str2table FROM dbo.Strtotable(?))");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cardString));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
}
