package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.VenditionInformationDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class VenditionInformationDaoImpl extends BaseJdbcDaoSupport implements
		VenditionInformationDao {

	/**
	 * 得到销售结帐基表对象
	 */
	public SalesBasicPo getSalesBasicPo(String salesID) {
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select top 1 ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode ,  ");
		buffer.append("S_SE_SB_OptID as ssesboptid , ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype, ");
		buffer.append("S_SE_SB_SalesType as ssesbsalestype, ");
		buffer.append("S_SE_SB_SalerID as ssesbsalerid , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountRate as ssesbdiscountrate, ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum, ");
		buffer.append("S_SE_SB_SalesValue as  ssesbsalesvalue ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo on S_SE_SalesBasic.S_SE_SB_SalerID = SYS_PersonInfo.ID  ");
		buffer.append("where S_SE_SB_SalesID= ? ");
	
		List<String> params = new ArrayList<String>();
		params.add(salesID);

		return (SalesBasicPo) this.queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	/**
	 * 取销售结帐基表下有几个销售结帐明细表
	 */
	public int getSalesDetailCount(String salesID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT COUNT(*) ");
		buffer.append("FROM S_SE_SalesDetail ");
		buffer.append("WHERE S_SE_SD_SalesID = ?  ");

		List<String> params = new ArrayList<String>();
		params.add(salesID);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 得到所有顾客销售结帐明细表,销售结帐基表对应的
	 */
	public List<SalesDetailPo> getcustomerSalesBasic(String ssesdsalesid) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname, ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice, ");
		buffer.append("S_SE_SD_Number as ssesdnumber, ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue, ");
		buffer.append("convert(varchar(10), S_SE_SD_Updatetime, 120) as ssesdupdatetime ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("where S_SE_SD_SalesID= ? ");
	    buffer.append("order by S_SE_SD_Updatetime desc ");
	    
	    List<String> params = new ArrayList<String>();
		params.add(ssesdsalesid);

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesDetailPo.class);
	}

	/**
	 * 销售信息数量
	 */
	public int getcustomerSalesBasicCount(String customerID) {
		
        StringBuffer buffer = new StringBuffer();
		
		buffer.append("SELECT sum(count1) from ( ");
		buffer.append("SELECT count(S_SE_SB_CustomerID) as count1 ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo on S_SE_SalesBasic.S_SE_SB_SalerID = SYS_PersonInfo.ID  ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode=B_Departments.B_DP_DepartmentID ");
		buffer.append("where S_SE_SB_CustomerID = ? ");
		buffer.append(" union all ");
		buffer.append("SELECT count(S_SE_SB_CustomerID) as count1 ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join SYS_PersonInfo on S_SE_SB_SalerID = SYS_PersonInfo.ID  ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode=B_Departments.B_DP_DepartmentID ");
		buffer.append("where S_SE_SB_CustomerID = ? ");
		buffer.append(" )t ");

		List<String> params = new ArrayList<String>();
		params.add(customerID);
		params.add(customerID);

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 遍历销售信息
	 */
	public List<SalesBasicPo> getcustomerSalesBasicList(String customerID,
			int start, int size) {
		
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * ");
		buffer.append("from(SELECT ROW_NUMBER() Over ");
		buffer.append("(order by ssesbsalesdatetime desc) as rowNum,* from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopcode ,  ");
		buffer.append("S_SE_SB_OptometryID as ssesboptometryid, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype, ");
		buffer.append("S_SE_SB_SalesType as ssesbsalestype, ");
		buffer.append("personName as ssesbsalerid , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountRate as ssesbdiscountrate, ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum, ");
		buffer.append("S_SE_SB_PosDatetime as ssesbposdatetime, ");
		buffer.append("convert(varchar(10), S_SE_SB_TakeGlassData, 120) as ssesbtakeglassdata,S_SE_SB_salesDatetime as ssesbsalesdatetime, ");
		buffer.append("S_SE_SB_SalesValue as  ssesbsalesvalue, ");
		buffer.append("case when S_SE_SB_WithdrawFlag = '1' then '已退货' else '未退货' end  as  ssesbwithdrawflag ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join SYS_PersonInfo on S_SE_SalesBasic.S_SE_SB_SalerID = SYS_PersonInfo.ID  ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode=B_Departments.B_DP_DepartmentID ");
		buffer.append("where S_SE_SB_CustomerID = ? ");
		buffer.append("union all ");		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopcode ,  ");
		buffer.append("S_SE_SB_OptometryID as ssesboptometryid, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype, ");
		buffer.append("S_SE_SB_SalesType as ssesbsalestype, ");
		buffer.append("personName as ssesbsalerid , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountRate as ssesbdiscountrate, ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum, ");
		buffer.append("S_SE_SB_PosDatetime as ssesbposdatetime, ");
		buffer.append("convert(varchar(10), S_SE_SB_TakeGlassData, 120) as ssesbtakeglassdata,S_SE_SB_salesDatetime as ssesbsalesdatetime, ");
		buffer.append("S_SE_SB_SalesValue as  ssesbsalesvalue, ");
		buffer.append("case when S_SE_SB_WithdrawFlag = '1' then '已退货' else '未退货' end  as  ssesbwithdrawflag ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join SYS_PersonInfo on S_SE_SB_SalerID = SYS_PersonInfo.ID  ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode=B_Departments.B_DP_DepartmentID ");
		buffer.append("where S_SE_SB_CustomerID = ? ");

		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		List<String> params = new ArrayList<String>();
		params.add(customerID);
		params.add(customerID);

		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public int getIntegralExpenseCount(String customerID){
		 StringBuffer varname1 = new StringBuffer();
			

		 varname1.append("SELECT ");
		 varname1.append("  count(CustomerID) ");
		 varname1.append("FROM   (");
		 varname1.append("        SELECT isnull(S_ME_AS_SalesBillID,'')                       AS salseid,S_ME_AS_CustomerID as CustomerID, ");
		 varname1.append("               S_ME_CI_Name                              AS membername, ");
		 varname1.append("               S_ME_AS_CIntegral                         AS inintrgral, ");
		 varname1.append("               S_ME_AS_XIntegral                         AS nowintegral, ");
		 varname1.append("               S_ME_AS_DoDate AS integraldate, ");
		 varname1.append("               '积分赠送'                                AS integraltype ");
		 varname1.append("        FROM   S_ME_IntegralAddandSub ");
		 varname1.append("               INNER JOIN S_ME_CustomerInfo ");
		 varname1.append("                 ON S_ME_AS_CustomerID = S_ME_CI_CustomerID where isnull(S_ME_AS_AddOrSub,'') in ('1','2') and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		 varname1.append("        UNION ALL ");
		 varname1.append("        SELECT isnull(S_ME_AS_SalesBillID,'')                       AS salseid,S_ME_AS_CustomerID as CustomerID, ");
		 varname1.append("               S_ME_CI_Name                              AS membername, ");
		 varname1.append("               S_ME_AS_CIntegral                         AS inintrgral, ");
		 varname1.append("               S_ME_AS_XIntegral                         AS nowintegral, ");
		 varname1.append("               S_ME_AS_DoDate AS integraldate, ");
		 varname1.append("               '积分兑换'                                AS integraltype ");
		 varname1.append("        FROM   S_ME_IntegralAddandSub ");
		 varname1.append("               INNER JOIN S_ME_CustomerInfo ");
		 varname1.append("                 ON S_ME_AS_CustomerID = S_ME_CI_CustomerID where isnull(S_ME_AS_AddOrSub,'') ='7' and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		 varname1.append("        UNION ALL ");
		 varname1.append("        SELECT isnull(S_ME_AS_SalesBillID,'')                       AS salseid,S_ME_AS_CustomerID as CustomerID, ");
		 varname1.append("               S_ME_CI_Name                              AS membername, ");
		 varname1.append("               S_ME_AS_CIntegral                         AS inintrgral, ");
		 varname1.append("               S_ME_AS_XIntegral                         AS nowintegral, ");
		 varname1.append("               S_ME_AS_DoDate AS integraldate, ");
		 varname1.append("               '清除积分'                                AS integraltype ");
		 varname1.append("        FROM   S_ME_IntegralAddandSub ");
		 varname1.append("               INNER JOIN S_ME_CustomerInfo ");
		 varname1.append("                 ON S_ME_AS_CustomerID = S_ME_CI_CustomerID where isnull(S_ME_AS_AddOrSub,'') ='8' ");
		 varname1.append("        UNION ALL ");
		 varname1.append("        SELECT isnull(S_ME_AS_SalesBillID,'')                       AS salseid,S_ME_AS_CustomerID as CustomerID, ");	
		 varname1.append("               S_ME_CI_Name                              AS membername, ");
		 varname1.append("               S_ME_AS_CIntegral                         AS inintrgral, ");
		 varname1.append("               S_ME_AS_XIntegral                         AS nowintegral, ");
		 varname1.append("               S_ME_AS_DoDate AS integraldate, ");
		 varname1.append("               '消费累计'                                AS integraltype ");
		 varname1.append("        FROM   S_ME_IntegralAddandSub ");
		 varname1.append("               INNER JOIN S_ME_CustomerInfo ");
		 varname1.append("                 ON S_ME_AS_CustomerID = S_ME_CI_CustomerID where isnull(S_ME_AS_AddOrSub,'') in ('3','4','5','6') and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		 
		 varname1.append("union all ");
		 varname1.append("select S_ME_CU_ID as salseid,S_ME_CU_CustomerID as CustomerID,S_ME_CI_Name as membername,");
		 varname1.append("S_ME_CU_IntegralChange as inintrgral,S_ME_CU_LastIntegral as nowintegral, ");
		 varname1.append("S_ME_CU_UpgradeDate as integraldate, ");
		 varname1.append("'会员升级' as integraltype ");
		 varname1.append("from S_ME_CustomerUpgrade  ");
		 varname1.append("inner join S_ME_CustomerInfo on S_ME_CU_CustomerID = S_ME_CI_CustomerID where cast(S_ME_CU_IntegralChange as numeric)<>0 ");
		 
		 varname1.append("   )TEMP  ");
		 varname1.append("where CustomerID = ? ");
			List<String> params = new ArrayList<String>();
			params.add(customerID);
			return getJdbcTemplate().queryForInt(varname1.toString(),params.toArray());
	}
	/**
	 * 储值卡消费记录
	 * @param customerID
	 * @return
	 */
	public int getChuZhiKaExpenseCount(String customerID){
		 StringBuffer varname1 = new StringBuffer();
			

		 varname1.append("SELECT ");
		 varname1.append("  count(CustomerID) ");
		 varname1.append("FROM   ( ");
		 varname1.append("        SELECT isnull(S_ME_AS_SalesBillID,'')                       AS salseid,S_ME_AS_CustomerID as CustomerID, ");
		 varname1.append("               S_ME_AS_MemberId                          AS MemberId, ");
		 varname1.append("               S_ME_CI_Name                              AS membername, ");
		 varname1.append("               S_ME_AS_CIntegral                         AS inintrgral, ");
		 varname1.append("               S_ME_AS_XIntegral                         AS nowintegral, ");
		 varname1.append("               S_ME_AS_DoDate AS integraldate, ");
		 varname1.append("               S_ME_AS_AddOrSub                                AS integraltype ");
		 varname1.append("        FROM   dbo.S_ME_ChuAddandSub ");
		 varname1.append("               INNER JOIN S_ME_CustomerInfo ON S_ME_AS_CustomerID = S_ME_CI_CustomerID ");
		 varname1.append("               INNER JOIN C_ST_Chuzhika ON S_ME_AS_ChuzhikaId = C_ST_CZK_ID ");
		 varname1.append("               where cast(S_ME_AS_CIntegral as numeric)<>0 ");
		 varname1.append("   )TEMP  ");
		 varname1.append("where CustomerID = ? ");
			List<String> params = new ArrayList<String>();
			params.add(customerID);
			return getJdbcTemplate().queryForInt(varname1.toString(),params.toArray());
	}
	
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getIntegralExpenseList(String customerID){
		List<String> params = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT ROW_NUMBER() Over(order by integraldate desc) as rowNum, ");
		buffer.append("salseid as ssesbsalesid,MemberId as ssesbMemberId,membername as ssesbpersonName, ");
		buffer.append("case when CAST(inintrgral AS NUMERIC)>0 then '+' + convert(varchar(32),inintrgral) else convert(varchar(32),inintrgral) end as inintrgral, ");
		buffer.append("isnull(CAST(nowintegral AS NUMERIC(18,2)),'0.00') as nowintegral,convert(varchar(16), integraldate, 120) as integraldate,integraltype,ssesbcheckoutflag ");
		buffer.append(",ssesbfmemberId as ssesbfmemberId ");
		buffer.append(",ssesbfcustomername as ssesbfcustomername ");
		buffer.append("from (");
		buffer.append("select S_ME_AS_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_AS_CIntegral as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'积分兑换' as integraltype,'' as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where S_ME_AS_AddOrSub ='7' and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		buffer.append("union all ");
		buffer.append("select S_ME_AS_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("CAST(S_ME_AS_CIntegral AS NUMERIC(18,2)) as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'积分赠送' as integraltype,'' as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where S_ME_AS_AddOrSub in ('1','2') and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		buffer.append("union all ");
		buffer.append("select S_ME_AS_SalesBillID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_AS_CIntegral as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'消费累计' as integraltype,isnull(S_ME_AS_AddOrSub,'') as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId ");
		buffer.append(",(select top 1 S_ME_CI_Name+'('+S_ME_CI_MemberId+')' from S_ME_CustomerInfo where S_ME_CI_CustomerID = S_ME_AS_FCustomerID) as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where isnull(S_ME_AS_AddOrSub,'') in ('3','4','5','6') and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		buffer.append("union all ");
		buffer.append("select S_ME_AS_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_AS_CIntegral as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'清除积分' as integraltype,'' as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where S_ME_AS_AddOrSub ='8' ");
		buffer.append("union all ");
		buffer.append("select S_ME_CU_ID as salseid, S_ME_CU_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_CU_IntegralChange as inintrgral,S_ME_CU_LastIntegral as nowintegral, ");
		buffer.append("S_ME_CU_UpgradeDate as integraldate, ");
		buffer.append("'会员升级' as integraltype,'' as ssesbcheckoutflag,S_ME_CU_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_CustomerUpgrade ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_CU_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where cast(S_ME_CU_IntegralChange as numeric) <> 0 ");
	
		buffer.append(" )temp1 ");
		
		
		buffer.append("where temp1.CustomerID = ? ");

		params.add(customerID);
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}
		
	/**
	 * 积分消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getIntegralExpenseList(String customerID,int start, int size){
		List<String> params = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ( SELECT ROW_NUMBER() Over(order by integraldate desc) as rowNum, ");
		buffer.append("salseid as ssesbsalesid,MemberId as ssesbMemberId,membername as ssesbpersonName,inintrgral as inintrgral,isnull(nowintegral,'0.00') as nowintegral,convert(varchar(16), integraldate, 120) as integraldate,integraltype,ssesbcheckoutflag ");
		buffer.append(",ssesbfmemberId as ssesbfmemberId ");
		buffer.append(",ssesbfcustomername as ssesbfcustomername ");
		buffer.append("from (");
		buffer.append("select S_ME_AS_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_AS_CIntegral as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'积分兑换' as integraltype,'' as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where S_ME_AS_AddOrSub ='7' and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		buffer.append("union all ");
		buffer.append("select F_IL_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("F_IL_IntegralCount as inintrgral,F_IL_IntegralSum as nowintegral, ");
		buffer.append("F_IL_Datetime as integraldate, ");
		buffer.append("'积分兑换' as integraltype,'' as ssesbcheckoutflag,F_IL_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from F_IntegralExchangeLog  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on F_IL_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where cast(F_IL_IntegralCount as numeric)<>0 ");
		buffer.append("union all ");		
		buffer.append("select S_ME_AS_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("CAST(S_ME_AS_CIntegral AS NUMERIC(18,2)) as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'积分赠送' as integraltype,'' as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where S_ME_AS_AddOrSub in ('1','2') and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		buffer.append("union all ");
		buffer.append("select S_ME_AS_UUID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_AS_CIntegral as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'清除积分' as integraltype,'' as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where S_ME_AS_AddOrSub ='8' ");
		buffer.append("union all ");
		buffer.append("select S_ME_AS_SalesBillID as salseid, s1.S_ME_CI_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_AS_CIntegral as inintrgral,S_ME_AS_XIntegral as nowintegral, ");
		buffer.append("S_ME_AS_DoDate as integraldate, ");
		buffer.append("'消费累计' as integraltype,isnull(S_ME_AS_AddOrSub,'') as ssesbcheckoutflag,S_ME_AS_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId ");
		buffer.append(",(select top 1 S_ME_CI_Name+'('+S_ME_CI_MemberId+')' from S_ME_CustomerInfo where S_ME_CI_CustomerID = S_ME_AS_FCustomerID) as ssesbfcustomername ");
		buffer.append("from S_ME_IntegralAddandSub  ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_AS_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where isnull(S_ME_AS_AddOrSub,'') in ('3','4','5','6') and cast(S_ME_AS_CIntegral as numeric)<>0 ");
		buffer.append("union all ");
		buffer.append("select S_ME_CU_ID as salseid, S_ME_CU_MemberId as MemberId,s1.S_ME_CI_Name as membername,");
		buffer.append("S_ME_CU_IntegralChange as inintrgral,S_ME_CU_LastIntegral as nowintegral, ");
		buffer.append("S_ME_CU_UpgradeDate as integraldate, ");
		buffer.append("'会员升级' as integraltype,'' as ssesbcheckoutflag,S_ME_CU_CustomerID as CustomerID ");
		buffer.append(",s2.S_ME_CI_MemberId as ssesbfmemberId,s2.S_ME_CI_Name as ssesbfcustomername ");
		buffer.append("from S_ME_CustomerUpgrade ");
		buffer.append("inner join S_ME_CustomerInfo s1 on S_ME_CU_CustomerID = s1.S_ME_CI_CustomerID ");
		buffer.append("left join S_ME_CustomerInfo s2 on s1.S_ME_CI_FCustomerID = s2.S_ME_CI_CustomerID ");
		buffer.append("where cast(S_ME_CU_IntegralChange as numeric) <> 0 ");
	
		buffer.append(" )temp1 ");
		
		
		buffer.append("where temp1.CustomerID = ? ");

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");

		params.add(customerID);
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}
	
	/**
	 * 储值卡消费记录
	 * @param customerID
	 * @return
	 */
	public List<SalesBasicPo> getChuZhiKaExpenseList(String customerID,int start, int size){
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ( SELECT ROW_NUMBER() Over(order by integraldate desc) as rowNum, ");
		buffer.append("salseid as ssesbsalesid,MemberId as ssesbMemberId,membername as ssesbpersonName,inintrgral as inintrgral,nowintegral,convert(varchar(16), integraldate, 120) as integraldate,integraltype,chuzhikaid from ");
		buffer.append("              (select isnull(S_ME_AS_SalesBillID,'') AS salseid,");
		buffer.append("               S_ME_AS_CustomerID                        AS CustomerID,");
		buffer.append("               S_ME_CI_MemberId                          AS MemberId,");
		buffer.append("               C_ST_CZK_CardID		                    AS chuzhikaid, ");
		buffer.append("               S_ME_CI_Name                              AS membername, ");
		buffer.append("               S_ME_AS_CIntegral                         AS inintrgral, ");
		buffer.append("               S_ME_AS_XIntegral                         AS nowintegral, ");
		buffer.append("               S_ME_AS_DoDate AS integraldate, ");
		buffer.append("               S_ME_AS_AddOrSub                                AS integraltype ");
		buffer.append("        FROM   dbo.S_ME_ChuAddandSub ");
		buffer.append("               INNER JOIN S_ME_CustomerInfo ON S_ME_AS_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("               INNER JOIN C_ST_Chuzhika ON S_ME_AS_ChuzhikaId = C_ST_CZK_ID ");
		buffer.append("               where cast(S_ME_AS_CIntegral as numeric)<>0 ");
		 
		buffer.append(" )temp1 ");
		
		
		buffer.append("where temp1.CustomerID = ? ");

		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");

		List<String> params = new ArrayList<String>();
		params.add(customerID);
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}
}
