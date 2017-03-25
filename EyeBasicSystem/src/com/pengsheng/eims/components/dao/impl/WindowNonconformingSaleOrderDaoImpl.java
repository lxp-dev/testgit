package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.components.dao.WindowNonconformingSaleOrderDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WindowNonconformingSaleOrderDaoImpl extends BaseJdbcDaoSupport implements
		WindowNonconformingSaleOrderDao {

	/**
	 * 得到销售单中商品信息的数量
	 */
	public int getNonconformingSaleCount(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_SE_SD_SalesItemID) ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = S_SE_SalesDetail.S_SE_SD_SalesID inner join B_Departments on B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append(" where S_SE_SD_SalesID= ? and S_SE_SB_InTransit >= 2 ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdsalesid()))){
			buffer.append("and S_SE_SD_SalesID = ? and S_SE_SB_InTransit >= 2 ");
			params.add(salesDetailPo.getSsesdsalesid());
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcompanyid()));	
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	public int getNonconformingSaleCountFinished(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_SE_SD_SalesItemID) ");
		buffer.append("from S_SE_SalesDetail_Finished ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_Departments on B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append(" where S_SE_SD_SalesID= ? and S_SE_SB_InTransit >= 2 ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdsalesid()))){
			buffer.append("and S_SE_SD_SalesID = ? and S_SE_SB_InTransit >= 2 ");
			params.add(salesDetailPo.getSsesdsalesid());
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcompanyid()));	
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到销售单中商品详细信息
	 */
	public List<SalesDetailPo> getNonconformingSaleList(
			SalesDetailPo salesDetailPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SD_SalesID desc) as rowNum, ");
		buffer.append("S_SE_SD_ID as ssesdid, ");
		buffer.append("S_SE_SD_SalesID as ssesdsalesid , S_SE_SD_SalesItemID as ssesdsalesitemid , S_SE_SD_ItemID as ssesditemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , S_SE_SD_StockId as ssesdstockid , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , S_SE_SD_GlassFlag as ssesdglassflag , ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = S_SE_SalesDetail.S_SE_SD_SalesID inner join B_Departments on B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SD_SalesID= ? and S_SE_SB_InTransit >= 2 ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdsalesid()))){
			buffer.append("and S_SE_SD_SalesID = ? and S_SE_SB_InTransit >= 2 ");
			params.add(salesDetailPo.getSsesdsalesid());
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcompanyid()));	
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray(),SalesDetailPo.class);
	}
	
	public List<SalesDetailPo> getNonconformingSaleListFinished(SalesDetailPo salesDetailPo , int start, int size){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SD_SalesID desc) as rowNum, ");
		buffer.append("S_SE_SD_ID as ssesdid, ");
		buffer.append("S_SE_SD_SalesID as ssesdsalesid , S_SE_SD_SalesItemID as ssesdsalesitemid , S_SE_SD_ItemID as ssesditemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , S_SE_SD_StockId as ssesdstockid , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , S_SE_SD_GlassFlag as ssesdglassflag , ");
		buffer.append("S_SE_SD_CommoditiesFlag as ssesdcommoditiesflag ");
		buffer.append("from S_SE_SalesDetail_Finished ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = S_SE_SD_SalesID inner join B_Departments on B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SD_SalesID= ? and S_SE_SB_InTransit >= 2 ");
		
		params.add(salesDetailPo.getSsesdsalesid());
		if(!"".equals(Utility.getName(salesDetailPo.getSsesdsalesid()))){
			buffer.append("and S_SE_SD_SalesID = ? and S_SE_SB_InTransit >= 2 ");
			params.add(salesDetailPo.getSsesdsalesid());
		}
		
		if (!"".equals(Utility.getName(salesDetailPo.getSsesdcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesDetailPo.getSsesdcompanyid()));	
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray(),SalesDetailPo.class);
	}

	/**
	 * 得到顾客的详细信息
	 */
	public SalesBasicPo getCustmorInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_ShopCode as ssesbshopcode , B_DP_DepartmentName as ssesbshopName , S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , S_SE_SB_SalesDatetime as ssesbsalesdatetime , S_SE_SB_SalerID as ssesbsalerid , S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("s_me_ci_name as ssesbpersonName , S_ME_CI_Phone      as ssesbphone , S_ME_CI_Address    as ssesbaddress , personName as ssesbsalerName ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join s_me_customerinfo on S_SE_SB_CustomerID=s_me_ci_customerid ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_SalesBasic.S_SE_SB_SalerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	public SalesBasicPo getCustmorInfoFinished(SalesBasicPo salesBasicPo){
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_ShopCode as ssesbshopcode , B_DP_DepartmentName as ssesbshopName , S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , S_SE_SB_SalesDatetime as ssesbsalesdatetime , S_SE_SB_SalerID as ssesbsalerid , S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("s_me_ci_name as ssesbpersonName , S_ME_CI_Phone      as ssesbphone , S_ME_CI_Address    as ssesbaddress , personName as ssesbsalerName ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join s_me_customerinfo on S_SE_SB_CustomerID=s_me_ci_customerid ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_SB_SalerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 得到销售单数量
	 */
	public int getSaleOrderCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("left join s_me_customerinfo on S_SE_SalesBasic.S_SE_SB_CustomerID = s_me_ci_customerid ");
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_SalesBasic.S_SE_SB_SalerID ");
		buffer.append("left join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_InTransit >= 2 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		else if("2".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and B_DP_RegID = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}	
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbphone()))){	//顾客姓名
			buffer.append(" and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
		} 	
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))){	//顾客卡号
			buffer.append(" and S_ME_CI_MemberId = ?  ");
			params.add(salesBasicPo.getSsesbMemberId());
		} 
		
		buffer.append(" union all  ");
		buffer.append("select count(S_SE_SB_SalesID) as count1 ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("left join s_me_customerinfo on S_SE_SB_CustomerID = s_me_ci_customerid ");
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_SB_SalerID ");
		buffer.append("left join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_InTransit >= 2 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		else if("2".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and B_DP_RegID = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}	
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbphone()))){	//顾客姓名
			buffer.append(" and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
		} 	
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))){	//顾客卡号
			buffer.append(" and S_ME_CI_MemberId = ?  ");
			params.add(salesBasicPo.getSsesbMemberId());
		} 
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到销售单号
	 */
	public List<SalesBasicPo> getSaleOrderList(SalesBasicPo salesBasicPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesdatetime desc) as rowNum,* from ( select * from ( ");
		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_CustomerID as ssesbcustomerid , S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , S_SE_SB_SalesValue as ssesbsalesvalue , S_SE_SB_ShopCode as ssesbshopcode , S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , personName as ssesbsalerName ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("left join s_me_customerinfo on S_SE_SalesBasic.S_SE_SB_CustomerID = s_me_ci_customerid ");
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_SalesBasic.S_SE_SB_SalerID ");
		buffer.append("left join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_InTransit >= 2 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		else if("2".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and B_DP_RegID = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}	
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbphone()))){	//顾客姓名
			buffer.append(" and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
		} 	
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))){	//顾客卡号
			buffer.append(" and S_ME_CI_MemberId = ?  ");
			params.add(salesBasicPo.getSsesbMemberId());
		} 
		buffer.append(" union all ");		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid , S_SE_SB_CustomerID as ssesbcustomerid , S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , S_SE_SB_SalesValue as ssesbsalesvalue , S_SE_SB_ShopCode as ssesbshopcode , S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , personName as ssesbsalerName ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("left join s_me_customerinfo on S_SE_SB_CustomerID = s_me_ci_customerid ");
		buffer.append("left join SYS_PersonInfo on SYS_PersonInfo.ID=S_SE_SB_SalerID ");
		buffer.append("left join B_Departments on B_Departments.B_DP_DepartmentID=S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_InTransit >= 2 ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if("1".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		else if("2".equals(Utility.getName(salesBasicPo.getSsesbdepid()))){
			buffer.append("and B_DP_RegID = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}	
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}else if(!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		}else if("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbphone()))){	//顾客姓名
			buffer.append(" and (S_ME_CI_Phone  like '%' + ? + '%' or S_ME_CI_Phone2  like '%' + ? + '%' or S_ME_CI_Phone3  like '%' + ? + '%') ");
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
			params.add(salesBasicPo.getSsesbphone());
		} 	
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbMemberId()))){	//顾客卡号
			buffer.append(" and S_ME_CI_MemberId = ?  ");
			params.add(salesBasicPo.getSsesbMemberId());
		} 
		
		buffer.append(" ) temp ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0 ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

}
