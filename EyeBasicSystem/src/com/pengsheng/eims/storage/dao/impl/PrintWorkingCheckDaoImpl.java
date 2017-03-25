package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.PrintWorkingCheckDao;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PrintWorkingCheckDaoImpl extends BaseJdbcDaoSupport implements PrintWorkingCheckDao {

	/**
	 * 得到打印检验单信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getPrintWorkingCheckCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(P_CH_CK_SalesId) as count1 ");
		buffer.append("from P_CH_Check ");
//		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = P_CH_Check.P_CH_CK_SalesId and S_SE_IT_State = '9' ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SB_SalesID = P_CH_Check.P_CH_CK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_Check.P_CH_CK_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_Check.P_CH_CK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
//		buffer.append("AND (P_CH_CK_IsSampled <> '1' or P_CH_CK_IsSampled is NULL)  ");   
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_CK_Remark like '%' + ? + '%'");
			params.add(workingCheckPo.getPchckremark());
		}

		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}
		
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and isnull(P_CH_CK_ProcessPersonID,'') = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_CK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}
		
		buffer.append(" union all ");
		buffer.append("select count(P_CH_CK_SalesId) as count1 ");
		buffer.append("from P_CH_Check ");
//		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = P_CH_Check.P_CH_CK_SalesId and S_SE_IT_State = '9' ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = P_CH_Check.P_CH_CK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_Check.P_CH_CK_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_Check.P_CH_CK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
//		buffer.append(" AND (P_CH_CK_IsSampled <> '1' or P_CH_CK_IsSampled is NULL)  ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_CK_Remark like '%' + ? + '%'");
			params.add(workingCheckPo.getPchckremark());
		}
		
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and isnull(P_CH_CK_ProcessPersonID,'') = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_CK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}		
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}
	
	/**
	 * 得到打印检验单信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getSampledCheckCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(P_CH_SK_SalesId) as count1 ");
		buffer.append("from P_CH_SamplingCheck ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = P_CH_SamplingCheck.P_CH_SK_SalesId and S_SE_IT_State = '9' ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SB_SalesID = P_CH_SamplingCheck.P_CH_SK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_SamplingCheck.P_CH_SK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
		buffer.append("and S_SE_SB_OrdersType in (1,2)  ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and P_CH_SK_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_SK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}
		
		buffer.append(" union all ");
		buffer.append("select count(P_CH_SK_SalesId) as count1 ");
		buffer.append("from P_CH_SamplingCheck ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = P_CH_SamplingCheck.P_CH_SK_SalesId and S_SE_IT_State = '9' ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = P_CH_SamplingCheck.P_CH_SK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_SamplingCheck.P_CH_SK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
		buffer.append("and S_SE_SB_OrdersType in (1,2)  ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and P_CH_SK_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_SK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}		
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询打印检验单信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WorkingCheckPo> selectPrintWorkingCheck(
			SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by pchckcheckdate desc) as rowNum,* from ( ");
		
		buffer.append("select P_CH_CK_SalesId as pchcksalesid , ");
		buffer.append("P_CH_CK_ProcessPersonID as pchckprocesspersonid , ");
		buffer.append("p.personName as pchckprocesspersonname , ");
		buffer.append("P_CH_CK_CheckLabourID as pchckchecklabourid , ");
		buffer.append("c.personName as pchckchecklabourname , ");
		buffer.append("P_CH_CK_CheckDate as pchckcheckdate , ");
		buffer.append("S_SE_SB_TakeGlassData as pchcktakeglasstime , ");
		buffer.append("S_ME_CI_Name as pchckcustomername ");
		buffer.append("from P_CH_Check ");
//		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = P_CH_Check.P_CH_CK_SalesId and S_SE_IT_State = '9' ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SB_SalesID = P_CH_Check.P_CH_CK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_Check.P_CH_CK_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_Check.P_CH_CK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
//		buffer.append("AND (P_CH_CK_IsSampled <> '1' or P_CH_CK_IsSampled is NULL) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_CK_Remark like '%' + ? + '%'");
			params.add(workingCheckPo.getPchckremark());
		}

		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm = ? ");
			params.add(salesBasicPo.getDjsbm());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and isnull(P_CH_CK_ProcessPersonID,'') = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_CK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}
		buffer.append(" union all ");
		buffer.append("select P_CH_CK_SalesId as pchcksalesid , ");
		buffer.append("P_CH_CK_ProcessPersonID as pchckprocesspersonid , ");
		buffer.append("p.personName as pchckprocesspersonname , ");
		buffer.append("P_CH_CK_CheckLabourID as pchckchecklabourid , ");
		buffer.append("c.personName as pchckchecklabourname , ");
		buffer.append("P_CH_CK_CheckDate as pchckcheckdate , ");
		buffer.append("S_SE_SB_TakeGlassData as pchcktakeglasstime , ");
		buffer.append("S_ME_CI_Name as pchckcustomername ");
		buffer.append("from P_CH_Check ");
//		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = P_CH_Check.P_CH_CK_SalesId and S_SE_IT_State = '9' ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = P_CH_Check.P_CH_CK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_Check.P_CH_CK_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_Check.P_CH_CK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
//		buffer.append(" AND (P_CH_CK_IsSampled <> '1' or P_CH_CK_IsSampled is NULL) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_CK_Remark like '%' + ? + '%'");
			params.add(workingCheckPo.getPchckremark());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and isnull(P_CH_CK_ProcessPersonID,'') = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_CK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_CK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}		
		
		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , WorkingCheckPo.class);
	}
	
	/**
	 * 查询抽检单信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WorkingCheckPo> selectSampledCheck(
			SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by pchckcheckdate desc) as rowNum,* from ( ");
		buffer.append("select P_CH_SK_SalesId as pchcksalesid , ");
		buffer.append("P_CH_SK_ProcessPersonID as pchckprocesspersonid , ");
		buffer.append("P_CH_SK_CheckLabourID as pchckchecklabourid , ");
		buffer.append("b.personName as pchckprocesspersonname , ");
		buffer.append("c.personName as pchckchecklabourname , ");
		buffer.append("P_CH_SK_CheckDate as pchckcheckdate , ");
		buffer.append("S_SE_SB_TakeGlassData as pchcktakeglasstime , ");
		buffer.append("S_ME_CI_Name as pchckcustomername ");
		buffer.append("from P_CH_SamplingCheck ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = P_CH_SamplingCheck.P_CH_SK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as b on b.ID = P_CH_SamplingCheck.P_CH_SK_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_SamplingCheck.P_CH_SK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
		buffer.append("and S_SE_SB_OrdersType in (1,2) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and P_CH_SK_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_SK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}		
		buffer.append(" union all ");
		buffer.append("select P_CH_SK_SalesId as pchcksalesid , ");
		buffer.append("P_CH_SK_ProcessPersonID as pchckprocesspersonid , ");
		buffer.append("P_CH_SK_CheckLabourID as pchckchecklabourid , ");
		buffer.append("b.personName as pchckprocesspersonname , ");
		buffer.append("c.personName as pchckchecklabourname , ");
		buffer.append("P_CH_SK_CheckDate as pchckcheckdate , ");
		buffer.append("S_SE_SB_TakeGlassData as pchcktakeglasstime , ");
		buffer.append("S_ME_CI_Name as pchckcustomername ");
		buffer.append("from P_CH_SamplingCheck ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = P_CH_SamplingCheck.P_CH_SK_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as b on b.ID = P_CH_SamplingCheck.P_CH_SK_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_SamplingCheck.P_CH_SK_CheckLabourID ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ?  ) ");
		buffer.append("and S_SE_SB_OrdersType in (1,2) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and P_CH_SK_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_SK_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
		}
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		//取镜日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		//检验日期
		if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_SK_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}	
		
		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , WorkingCheckPo.class);
	}

	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid , ");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("from B_Departments ");
		buffer.append("where B_DP_RegID = ? and B_DP_IsClosed = '0'");
		
		params.add(departmentsPo.getBdpregid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , DepartmentsPo.class);
	}
	
	/**
	 * 得到抽检记录
	 * @param salesid
	 * @return WorkingCheckPo
	 */
	public WorkingCheckPo getSampledCheckPo(String salesid) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("SELECT P_CH_SK_Id                  AS pchckid, ");
		buffer.append("       P_CH_SK_SalesId             AS pchcksalesid, ");
		buffer.append("       P_CH_SK_CokeBallGlassOD     AS pchckcokeballglassod, ");
		buffer.append("       P_CH_SK_CokeBallGlassOS     AS pchckcokeballglassos, ");
		buffer.append("       P_CH_SK_CokePostGlassOD     AS pchckcokepostglassod, ");
		buffer.append("       P_CH_SK_CokePostGlassOS     AS pchckcokepostglassos, ");
		buffer.append("       P_CH_SK_CokeAxesOD          AS pchckcokeaxesod, ");
		buffer.append("       P_CH_SK_CokeAxesOS          AS pchckcokeaxesos, ");
		buffer.append("       P_CH_SK_CokeArriseGlassOD   AS pchckcokearriseglassod, ");
		buffer.append("       P_CH_SK_CokeArriseGlassOS   AS pchckcokearriseglassos, ");
		buffer.append("       P_CH_SK_CokeBasisOD         AS pchckcokebasisod, ");
		buffer.append("       P_CH_SK_CokeBasisOS         AS pchckcokebasisos, ");
		buffer.append("       P_CH_SK_CokeAddOD           AS pchckcokeaddod, ");
		buffer.append("       P_CH_SK_CokeAddOS           AS pchckcokeaddos, ");
		buffer.append("       P_CH_SK_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		buffer.append("       P_CH_SK_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		buffer.append("       P_CH_SK_CokeCenterVertical  AS pchckcokecentervertical, ");
		buffer.append("       P_CH_SK_CenterHigh          AS pchckcenterhigh, ");
		buffer.append("       P_CH_SK_Color               AS pchckcolor, ");
		buffer.append("       P_CH_SK_Quality             AS pchckquality, ");
		buffer.append("       P_CH_SK_Shaping             AS pchckshaping, ");
		buffer.append("       P_CH_SK_GeometryCenter      AS pchckgeometrycenter, ");
		buffer.append("       P_CH_SK_VertexVertical      AS pchckvertexvertical, ");
		buffer.append("       P_CH_SK_VertexHigh          AS pchckvertexhigh, ");
		buffer.append("       P_CH_SK_ProcessPersonID     AS pchckprocesspersonid, ");
		buffer.append("       P_CH_SK_CheckLabourID       AS pchckchecklabourid, ");
		buffer.append("       P_CH_SK_Remark              AS pchckremark, ");
		buffer.append("       P_CH_SK_CheckDate           AS pchckcheckdate, ");
		buffer.append("       P_CH_SK_Qualified           AS pchckqualified ");
		buffer.append("FROM   P_CH_SamplingCheck ");
		buffer.append("WHERE  P_CH_SK_SalesId = ? ");
		
		params.add(salesid);
		
		return (WorkingCheckPo)queryForObject(buffer.toString() , params.toArray() , WorkingCheckPo.class);
	}

}
