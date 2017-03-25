package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.GlassesCheckDao;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesCheckDaoImpl extends BaseJdbcDaoSupport implements GlassesCheckDao {

	/**
	 * 得到检验信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getWorkingCheckCount(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(*) from ");
		buffer.append("(select S_SE_SB_SalesID, ");
		buffer.append("(select top 1 personName from SYS_PersonInfo inner join S_SE_InTransit on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State='8' where S_SE_InTransit.S_SE_IT_SalesID = S_SE_SB_SalesID ) as ssesbmaterialsperson ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic_Finished.S_SE_SB_CustomerID ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = S_SE_SalesBasic_Finished.S_SE_SB_SalesID ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State = '12' ");
		buffer.append("left join P_CH_GlassesCheck on P_CH_GC_SalesId = S_SE_SalesBasic_Finished.S_SE_SB_SalesID ");
		buffer.append("left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("where S_SE_SB_OrdersType in (1,2) and isnull(P_CH_GC_SalesId,'') = '' ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbphone()))){
			buffer.append("and S_ME_CI_Phone like '%' + ? ");
			params.add(salesBasicPo.getSsesbphone());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
				//------------------------沈兴贺2011-4-18-----添加取镜日期判断----------
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) >= ? ");
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());	
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) >= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) >= ? ");
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) <= ? ");


			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		buffer.append(") temp1 where 1=1");
		
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and temp1.ssesbmaterialsperson like '%' + ? + '%'");
			params.add(salesBasicPo.getDjsbm());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到检验信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectWorkingCheck(SalesBasicPo salesBasicPo,
			int start, int size) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n ");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over(order by ssesbmaterialsdate desc) as rowNum,* from( ");
		buffer.append("select  ");
		buffer.append("S_SE_SB_WorryType as ssesbworrytype , ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("(select top 1  S_SE_IT_Date from SYS_PersonInfo inner join S_SE_InTransit on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State='8' where S_SE_InTransit.S_SE_IT_SalesID = S_SE_SB_SalesID ) as ssesbmaterialsdate, ");
		buffer.append("(select top 1  personName from SYS_PersonInfo inner join S_SE_InTransit on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State='8' where S_SE_InTransit.S_SE_IT_SalesID = S_SE_SB_SalesID ) as ssesbmaterialsperson ");
		
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic_Finished.S_SE_SB_CustomerID ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = S_SE_SalesBasic_Finished.S_SE_SB_SalesID ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State='12' ");
		buffer.append("left join P_CH_GlassesCheck on P_CH_GC_SalesId = S_SE_SalesBasic_Finished.S_SE_SB_SalesID ");
		buffer.append("left join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		
		buffer.append("where S_SE_SB_OrdersType in (1,2) and isnull(P_CH_GC_SalesId,'') = '' ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbphone()))){
			buffer.append("and S_ME_CI_Phone like '%' + ? ");
			params.add(salesBasicPo.getSsesbphone());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) >= ? ");
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& "".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) >= ? ");
			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbtakeglassstartdata()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_TakeGlassData, 20) <= ? ");
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}		

		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) >= ? ");
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(30), S_SE_SB_SalesDatetime, 20) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdateendtime());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		buffer.append(" ) temp1 where 1=1 ");
		
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and temp1.ssesbmaterialsperson like '%' + ? + '%'");
			params.add(salesBasicPo.getDjsbm());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("s.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_Location as ssesblocation , ");
		buffer.append("t.B_DP_DepartmentName as ssesbtakeshopname , ");  
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("isnull(S_SE_TM_UUID,'') as isMail, ");
		buffer.append("dbo.getCenterVertical(replace(S_SE_SB_BallGlassOD , '+' , '') , replace(S_SE_SB_PostGlassOD , '+' , '') , case when S_SE_SB_AxesOD = '' then '0' end , ");
		buffer.append("replace(S_SE_SB_BallGlassOS , '+' , '') , replace(S_SE_SB_PostGlassOS , '+' , '') , case when S_SE_SB_AxesOS = '' then '0' end,? ) as ssesblightvertical ");
		params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		buffer.append(",sp.personName as ssesbsalerName ");
		buffer.append(",yp.personName as ssesbyishiid ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_TM_LinkSalesID ");
		buffer.append("left join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments as s on s.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments as t on t.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_Location ");
		buffer.append("left join SYS_PersonInfo as sp on sp.ID = S_SE_SalesBasic.S_SE_SB_SalerID ");
		buffer.append("left join S_OP_Inspection on S_SE_SB_InspectionID = S_OP_IP_ID ");
		buffer.append("left join SYS_PersonInfo as yp on S_OP_IP_UserName = yp.ID ");
		
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	public SalesBasicPo getCustomerInfoFinished(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("s.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_Location as ssesblocation , ");
		buffer.append("t.B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("isnull(S_SE_TM_UUID,'') as isMail, ");
		buffer.append("dbo.getCenterVertical(replace(S_SE_SB_BallGlassOD , '+' , '') , replace(S_SE_SB_PostGlassOD , '+' , '') , case when S_SE_SB_AxesOD = '' then '0' end , ");
		buffer.append("replace(S_SE_SB_BallGlassOS , '+' , '') , replace(S_SE_SB_PostGlassOS , '+' , '') , case when S_SE_SB_AxesOS = '' then '0' end,? ) as ssesblightvertical ");
		params.add(Utility.getName(salesBasicPo.getSsesborderstype()));
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_TM_LinkSalesID ");
		buffer.append("left join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("left join B_Departments as s on s.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("left join B_Departments as t on t.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod , ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod , ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod , ");
		buffer.append("B_GI_isMutiLuminosity as ssesbismutiluminosity , ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod , ");
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname, ");
		buffer.append("S_SE_SD_Sprice as ssesbgoodsvalue ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("left join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_GlassFlag = 'R' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	public SalesBasicPo getODDetailInfoFinished(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("isnull(S_SE_SB_AxesOD,'') as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod , ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod , ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod , ");
		buffer.append("B_GI_isMutiLuminosity as ssesbismutiluminosity , ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod , ");
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname, ");
		buffer.append("S_SE_SD_Sprice as ssesbgoodsvalue ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_SE_SalesDetail_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID ");
		buffer.append("left join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_GlassFlag = 'R' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 取出销售单镜架信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getFrameDetailInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 ");
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname, ");
		buffer.append("S_SE_SD_Sprice as ssesbgoodsvalue ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_CommoditiesFlag = '1' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	public SalesBasicPo getFrameDetailInfoFinished(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 ");
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_SE_SalesDetail_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID ");
		buffer.append("inner join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_CommoditiesFlag = '1' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_SE_SB_BallGlassOS as ssesbballglassos , ");
		buffer.append("S_SE_SB_PostGlassOS as ssesbpostglassos , ");
		buffer.append("S_SE_SB_AxesOS as ssesbaxesos , ");
		buffer.append("S_SE_SB_ADDOS as ssesbaddos , ");
		buffer.append("S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos , ");
		buffer.append("S_SE_SB_BasisOS1 as ssesbbasisos , ");
		buffer.append("S_SE_SB_PrismOS as ssesbprismos , ");
		buffer.append("S_SE_SB_InterHighOS as ssesbinterhighos , ");
		buffer.append("S_SE_SB_InterDistanceOS as ssesbinterdistanceos , ");
		buffer.append("S_SE_SB_FarVAOS as ssesbfarvaos , ");
		buffer.append("B_GI_isMutiLuminosity as ssesbismutiluminosity , ");
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos , ");
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname, ");
		buffer.append("S_SE_SD_Sprice as ssesbgoodsvalue ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("left join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_GlassFlag = 'L' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	public SalesBasicPo getOSDetailInfoFinished(SalesBasicPo salesBasicPo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  S_SE_SB_RecipeType as ssesbrecipetype , ");
		buffer.append("S_SE_SB_BallGlassOS as ssesbballglassos , ");
		buffer.append("S_SE_SB_PostGlassOS as ssesbpostglassos , ");
		buffer.append("isnull(S_SE_SB_AxesOS,'') as ssesbaxesos , ");
		buffer.append("S_SE_SB_ADDOS as ssesbaddos , ");
		buffer.append("S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos , ");
		buffer.append("S_SE_SB_BasisOS1 as ssesbbasisos , ");
		buffer.append("S_SE_SB_PrismOS as ssesbprismos , ");
		buffer.append("S_SE_SB_InterHighOS as ssesbinterhighos , ");
		buffer.append("S_SE_SB_InterDistanceOS as ssesbinterdistanceos , ");
		buffer.append("S_SE_SB_FarVAOS as ssesbfarvaos , ");
		buffer.append("B_GI_isMutiLuminosity as ssesbismutiluminosity , ");
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos , ");
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname, ");
		buffer.append("S_SE_SD_Sprice as ssesbgoodsvalue ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_SE_SalesDetail_Finished on S_SE_SD_SalesID = S_SE_SB_SalesID ");
		buffer.append("left join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_GlassFlag = 'L' ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		return (SalesBasicPo) queryForObject(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID , S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department ) ");
		buffer.append("values (? , ? , '9' , getdate() , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 更新销售基表中的在途点
	 * @param salesDetailPo
	 */
	public void updateWorkingCheckInTransit(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= '9' ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 取加工师下拉列表
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getWorkingChenkPerson(PersonInfoPo personInfoPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		buffer.append("select SYS_PersonInfo.id as id,personName as personName from SYS_PersonInfo ");
		buffer.append("where PersonJobType like '%' + ? + '%' ");
		buffer.append("and isInvocation = '0' ");
		
		params.add(personInfoPo.getPersonjobtype());
		
		if (!"".equals(Utility.getName(personInfoPo.getPersoncompanyid()))){
		    buffer.append(" and personcompanyid = ? ");
			params.add(Utility.getName(personInfoPo.getPersoncompanyid()));	
		}
		
		return queryForObjectList(buffer.toString() , params.toArray() , PersonInfoPo.class);
	}

	/**
	 * 插入加工检验表 
	 * @param workingCheckPo
	 */
	public void insertWorkingCheck(WorkingCheckPo workingCheckPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into P_CH_GlassesCheck( ");
		buffer.append("P_CH_GC_Id , ");
		buffer.append("P_CH_GC_SalesId , ");
		buffer.append("P_CH_GC_CokeBallGlassOD , ");
		buffer.append("P_CH_GC_CokeBallGlassOS , ");
		buffer.append("P_CH_GC_CokePostGlassOD , ");
		buffer.append("P_CH_GC_CokePostGlassOS , ");
		buffer.append("P_CH_GC_CokeAxesOD , ");
		buffer.append("P_CH_GC_CokeAxesOS , ");
		buffer.append("P_CH_GC_CokeFarVAOD , ");
		buffer.append("P_CH_GC_CokeFarVAOS , ");
		buffer.append("P_CH_GC_CokeCloseVAOD , ");
		buffer.append("P_CH_GC_CokeCloseVAOS , ");
		buffer.append("P_CH_GC_CokeAddOD , ");
		buffer.append("P_CH_GC_CokeAddOS , ");
		buffer.append("P_CH_GC_CokePupilDistanceOD , ");
		buffer.append("P_CH_GC_CokePupilDistanceOS , ");
		buffer.append("P_CH_GC_ProcessPersonID , ");
		buffer.append("P_CH_GC_CheckDate,P_CH_GC_Remark,P_CH_GC_ProcessDepartment, ");
		buffer.append("P_CH_GC_shuiping , ");
		buffer.append("P_CH_GC_chuizhi , ");
		buffer.append("P_CH_GC_zhouwei , ");
		buffer.append("P_CH_GC_hege , ");
		buffer.append("P_CH_GC_dengji, ");
		buffer.append("P_CH_GC_CheckLabourID, ");
		buffer.append("P_CH_GC_GlassesSalesValue) ");
		buffer.append("values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ");
		buffer.append("? , ? , ? , ? , ? , ? , getdate(), ? , ? , ? , ? , ? , ? , ? , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(workingCheckPo.getPchcksalesid());
		params.add(workingCheckPo.getPchckcokeballglassod());
		params.add(workingCheckPo.getPchckcokeballglassos());
		params.add(workingCheckPo.getPchckcokepostglassod());
		params.add(workingCheckPo.getPchckcokepostglassos());
		params.add(workingCheckPo.getPchckcokeaxesod());
		params.add(workingCheckPo.getPchckcokeaxesos());
		params.add(workingCheckPo.getPchckfarvaod());
		params.add(workingCheckPo.getPchckfarvaos());
		params.add(workingCheckPo.getPchckclosevaod());
		params.add(workingCheckPo.getPchckclosevaos());
		params.add(workingCheckPo.getPchckcokeaddod());
		params.add(workingCheckPo.getPchckcokeaddos());
		params.add(workingCheckPo.getPchckcokepupildistanceod());
		params.add(workingCheckPo.getPchckcokepupildistanceos());
		params.add(workingCheckPo.getPchckprocesspersonid());
		params.add(workingCheckPo.getPchckremark());
		params.add(Utility.getName(workingCheckPo.getPchckprocessdepartmentid()));
		params.add(workingCheckPo.getPchckshuiping());
		params.add(workingCheckPo.getPchckchuizhi());
		params.add(workingCheckPo.getPchckzhouwei());
		params.add(workingCheckPo.getPchckhege());
		params.add(workingCheckPo.getPchckdengji());
		params.add(workingCheckPo.getPchckchecklabourid());
		params.add(workingCheckPo.getPchckglassessalesvalue());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	//國標獲得球鏡允差

	public MistakePo getMistakeSphPo(SalesBasicPo salesBasicPo,String type) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=? and cast(F_MT_lower1 as float)<=abs(?) and cast(F_MT_cap1 as float)>=abs(?)");
		params.add(salesBasicPo.getSsesbismutiluminosity());
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	//國標獲得柱鏡允差
	
	public MistakePo getMistakeCylPo(SalesBasicPo salesBasicPo,String type) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=? and cast(F_MT_lower1 as float)<=abs(?) and cast(F_MT_cap1 as float)>=abs(?)");
		sb.append(" and cast(abs(F_MT_lower2) as float)<= abs(?) and cast(abs(F_MT_cap2) as float)>=abs(?)");
		params.add(salesBasicPo.getSsesbismutiluminosity());
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?salesBasicPo.getSsesbpostglassos():salesBasicPo.getSsesbpostglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?salesBasicPo.getSsesbpostglassos():salesBasicPo.getSsesbpostglassod());
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	//國標獲得軸向允差
	
	public MistakePo getMistakeAxesODPo(SalesBasicPo salesBasicPo,String type) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=5 and cast(F_MT_lower1 as float)<=abs(?) and cast(F_MT_cap1 as float)>=abs(?)");
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()));
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()));
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	
	public MistakePo getMistakeAxesOSPo(SalesBasicPo salesBasicPo,String type) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=5 and cast(F_MT_lower1 as float)<= abs(?) and cast(F_MT_cap1 as float)>=abs(?)");
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassos()));
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassos()));
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	
	public MistakePo getMistakeAddODPo(SalesBasicPo salesBasicPo,String type) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=7 and cast(F_MT_lower1 as float)<=? and cast(F_MT_cap1 as float)>=?");
		params.add(Utility.getName(salesBasicPo.getSsesbaddod()));
		params.add(Utility.getName(salesBasicPo.getSsesbaddod()));
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	
	public MistakePo getMistakeAddOSPo(SalesBasicPo salesBasicPo,String type) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=7 and cast(F_MT_lower1 as float)<=? and cast(F_MT_cap1 as float)>=?");
		params.add(Utility.getName(salesBasicPo.getSsesbaddos()));
		params.add(Utility.getName(salesBasicPo.getSsesbaddos()));
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}

	public MistakePo getMistakeTjPo(SalesBasicPo salesBasicPo,String type) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=3 ");
		sb.append("and cast(F_MT_lower1 as float)<= ? ");
		sb.append("and cast(F_MT_cap1 as float)>= ? ");
		
		Double bvp = 0.00;
		
		String tsph = Utility.getName(salesBasicPo.getSsesbballglassod()).equals("") ? Utility.getName(salesBasicPo.getSsesbballglassos()) : Utility.getName(salesBasicPo.getSsesbballglassod());
		String tcyl = Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("") ? Utility.getName(salesBasicPo.getSsesbpostglassos()) : Utility.getName(salesBasicPo.getSsesbpostglassod());
		
		Double sph = Double.parseDouble(tsph.equals("") ? "0.00" : tsph);
		Double cyl = Double.parseDouble(tcyl.equals("") ? "0.00" : tcyl);
		Double sac = sph + cyl;
		if(Math.abs(sph) > Math.abs(cyl)){
			bvp = Math.abs(sph);
		}else{
			bvp = Math.abs(cyl);
		}
		
		if(Math.abs(sac) > Math.abs(bvp)){
			bvp = Math.abs(sac);
		}
		
		params.add(bvp+"");
		params.add(bvp+"");
		
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	
	//國標獲得球鏡允差
	
	public MistakePo getMistakeSCPo(SalesBasicPo salesBasicPo,String type) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=? and cast(F_MT_lower1 as float)<=abs(cast(? as float)+cast(? as float)) and cast(F_MT_cap1 as float)>=abs(cast(? as float)+cast(? as float))");
		params.add(salesBasicPo.getSsesbismutiluminosity());
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
	
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?salesBasicPo.getSsesbpostglassos():salesBasicPo.getSsesbpostglassod());
		
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?salesBasicPo.getSsesbpostglassos():salesBasicPo.getSsesbpostglassod());
		return (MistakePo) this.queryForObject(sb.toString(), params.toArray(), MistakePo.class);
	}
	
	/**
	 * 等到上次检验记录
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getLastWorkingCheckPo(SalesBasicPo salesBasicPo){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>(); 
		varname1.append("SELECT  top 1 * from ( ");
		varname1.append("SELECT       P_CH_GC_Id                  AS pchckid, ");
		varname1.append("             P_CH_GC_SalesId             AS pchcksalesid, ");
		varname1.append("             P_CH_GC_CokeBallGlassOD     AS pchckcokeballglassod, ");
		varname1.append("             P_CH_GC_CokeBallGlassOS     AS pchckcokeballglassos, ");
		varname1.append("             P_CH_GC_CokePostGlassOD     AS pchckcokepostglassod, ");
		varname1.append("             P_CH_GC_CokePostGlassOS     AS pchckcokepostglassos, ");
		varname1.append("             P_CH_GC_CokeAxesOD          AS pchckcokeaxesod, ");
		varname1.append("             P_CH_GC_CokeAxesOS          AS pchckcokeaxesos, ");
		varname1.append("             P_CH_GC_CokeArriseGlassOD   AS pchckcokearriseglassod, ");
		varname1.append("             P_CH_GC_CokeArriseGlassOS   AS pchckcokearriseglassos, ");
		varname1.append("             P_CH_GC_CokeBasisOD         AS pchckcokebasisod, ");
		varname1.append("             P_CH_GC_CokeBasisOS         AS pchckcokebasisos, ");
		varname1.append("             P_CH_GC_CokeAddOD           AS pchckcokeaddod, ");
		varname1.append("             P_CH_GC_CokeAddOS           AS pchckcokeaddos, ");
		varname1.append("             P_CH_GC_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		varname1.append("             P_CH_GC_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		varname1.append("             P_CH_GC_CokeCenterVertical  AS pchckcokecentervertical, ");
		varname1.append("             P_CH_GC_ProcessPersonID     AS pchckprocesspersonid, ");
		varname1.append("             P_CH_GC_CheckLabourID       AS pchckchecklabourid, ");
		varname1.append("             P_CH_GC_Remark              AS pchckremark, ");
		varname1.append("             P_CH_GC_CheckDate           AS pchckcheckdate ");
		varname1.append("FROM   S_SE_SalesBasic ");
		varname1.append("       INNER JOIN P_CH_GlassesCheck ");
		varname1.append("         ON S_SE_SB_SalesID = P_CH_GC_SalesId ");
		varname1.append("WHERE  S_SE_SB_CustomerID = ? ");
		varname1.append(" union all ");
		varname1.append("SELECT       P_CH_GC_Id                  AS pchckid, ");
		varname1.append("             P_CH_GC_SalesId             AS pchcksalesid, ");
		varname1.append("             P_CH_GC_CokeBallGlassOD     AS pchckcokeballglassod, ");
		varname1.append("             P_CH_GC_CokeBallGlassOS     AS pchckcokeballglassos, ");
		varname1.append("             P_CH_GC_CokePostGlassOD     AS pchckcokepostglassod, ");
		varname1.append("             P_CH_GC_CokePostGlassOS     AS pchckcokepostglassos, ");
		varname1.append("             P_CH_GC_CokeAxesOD          AS pchckcokeaxesod, ");
		varname1.append("             P_CH_GC_CokeAxesOS          AS pchckcokeaxesos, ");
		varname1.append("             P_CH_GC_CokeArriseGlassOD   AS pchckcokearriseglassod, ");
		varname1.append("             P_CH_GC_CokeArriseGlassOS   AS pchckcokearriseglassos, ");
		varname1.append("             P_CH_GC_CokeBasisOD         AS pchckcokebasisod, ");
		varname1.append("             P_CH_GC_CokeBasisOS         AS pchckcokebasisos, ");
		varname1.append("             P_CH_GC_CokeAddOD           AS pchckcokeaddod, ");
		varname1.append("             P_CH_GC_CokeAddOS           AS pchckcokeaddos, ");
		varname1.append("             P_CH_GC_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		varname1.append("             P_CH_GC_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		varname1.append("             P_CH_GC_CokeCenterVertical  AS pchckcokecentervertical, ");
		varname1.append("             P_CH_GC_ProcessPersonID     AS pchckprocesspersonid, ");
		varname1.append("             P_CH_GC_CheckLabourID       AS pchckchecklabourid, ");
		varname1.append("             P_CH_GC_Remark              AS pchckremark, ");
		varname1.append("             P_CH_GC_CheckDate           AS pchckcheckdate ");
		varname1.append("FROM   S_SE_SalesBasic_Finished ");
		varname1.append("       INNER JOIN P_CH_GlassesCheck ");
		varname1.append("         ON S_SE_SB_SalesID = P_CH_GC_SalesId ");
		varname1.append("WHERE  S_SE_SB_CustomerID = ? ");
		
		varname1.append(" )t ORDER  BY pchckcheckdate DESC ");
		
		params.add(salesBasicPo.getSsesbcustomerid());
		params.add(salesBasicPo.getSsesbcustomerid());
		
		return (WorkingCheckPo) this.queryForObject(varname1.toString(), params.toArray(), WorkingCheckPo.class);
	}
	
	/**
	 * 检验单详细
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getWorkingCheckPo(String salesid){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>(); 

		varname1.append("SELECT p.personName                AS pchckprocesspersonname, ");
		varname1.append("       c.personName                AS pchckchecklabourname, ");
		varname1.append("       P_CH_GC_SalesId             AS pchcksalesid, ");
		varname1.append("       P_CH_GC_CokeBallGlassOD     AS pchckcokeballglassod, ");
		varname1.append("       P_CH_GC_CokeBallGlassOS     AS pchckcokeballglassos, ");
		varname1.append("       P_CH_GC_CokePostGlassOD     AS pchckcokepostglassod, ");
		varname1.append("       P_CH_GC_CokePostGlassOS     AS pchckcokepostglassos, ");
		varname1.append("       P_CH_GC_CokeAxesOD          AS pchckcokeaxesod, ");
		varname1.append("       P_CH_GC_CokeAxesOS          AS pchckcokeaxesos, ");
		varname1.append("       P_CH_GC_CokeFarVAOD   		AS pchckfarvaod, ");
		varname1.append("       P_CH_GC_CokeFarVAOS   		AS pchckfarvaos, ");
		varname1.append("       P_CH_GC_CokeCloseVAOD       AS pchckclosevaod, ");
		varname1.append("       P_CH_GC_CokeCloseVAOS       AS pchckclosevaos, ");
		varname1.append("       P_CH_GC_CokeAddOD           AS pchckcokeaddod, ");
		varname1.append("       P_CH_GC_CokeAddOS           AS pchckcokeaddos, ");
		varname1.append("       P_CH_GC_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		varname1.append("       P_CH_GC_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		varname1.append("       P_CH_GC_shuiping  			AS pchckshuiping, ");
		varname1.append("       P_CH_GC_chuizhi  			AS pchckchuizhi, ");
		varname1.append("       P_CH_GC_zhouwei  			AS pchckzhouwei, ");
		varname1.append("       P_CH_GC_hege  				AS pchckhege, ");
		varname1.append("       P_CH_GC_dengji  			AS pchckdengji, ");
		varname1.append("       P_CH_GC_CheckDate           AS pchckcheckdate, ");
		varname1.append("       P_CH_GC_Remark           	AS pchckremark, ");
		varname1.append("       P_CH_GC_ProcessPersonID     AS pchckprocesspersonid, ");
		varname1.append("       jgs.personName     			AS pchckprocesspersonname ");
		varname1.append("FROM   P_CH_GlassesCheck ");
		varname1.append("       INNER JOIN SYS_PersonInfo AS p ");
		varname1.append("         ON p.ID = P_CH_GlassesCheck.P_CH_GC_ProcessPersonID ");
		varname1.append("       INNER JOIN SYS_PersonInfo AS c ");
		varname1.append("         ON c.ID = P_CH_GlassesCheck.P_CH_GC_CheckLabourID ");
		varname1.append("       INNER JOIN SYS_PersonInfo AS jgs ");
		varname1.append("         ON jgs.ID = P_CH_GlassesCheck.P_CH_GC_ProcessPersonID ");
		varname1.append("WHERE  P_CH_GC_SalesId = ? ");
		
		params.add(salesid);
		
		return (WorkingCheckPo) this.queryForObject(varname1.toString(), params.toArray(), WorkingCheckPo.class);
	}
	
	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid , ");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("from B_Departments ");
		buffer.append("where B_DP_IsClosed = '0'");
		
		if(!"".equals(Utility.getName(departmentsPo.getBdpregid()))){
			buffer.append("and B_DP_RegID = ? ");
			params.add(departmentsPo.getBdpregid());
		}
		
		if(!"".equals(Utility.getName(departmentsPo.getBdptype()))){
			buffer.append("and B_DP_Type = ? ");
			params.add(departmentsPo.getBdptype());
		}
		
		if (!"".equals(Utility.getName(departmentsPo.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(departmentsPo.getBdpcompanysid()));	
		}
		
		return queryForObjectList(buffer.toString() , params.toArray() , DepartmentsPo.class);
	}
	
	/**
	 * 得到打印检验单信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getGlassesCheckedCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select sum(count1) from ( ");
		buffer.append("select count(P_CH_GC_SalesId) as count1 ");
		buffer.append("from P_CH_GlassesCheck ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SB_SalesID = P_CH_GlassesCheck.P_CH_GC_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_GlassesCheck.P_CH_GC_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_GlassesCheck.P_CH_GC_CheckLabourID ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("where 1=1  ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(workingCheckPo.getPchckdengji()))){
			buffer.append("and P_CH_GC_dengji = ? ");
			params.add(workingCheckPo.getPchckdengji());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_GC_Remark like '%' + ? + '%'");
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
			buffer.append("and P_CH_GC_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_GC_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
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
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}
		
		buffer.append(" union all ");
		buffer.append("select count(P_CH_GC_SalesId) as count1 ");
		buffer.append("from P_CH_GlassesCheck ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = P_CH_GlassesCheck.P_CH_GC_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_GlassesCheck.P_CH_GC_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_GlassesCheck.P_CH_GC_CheckLabourID ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("where 1=1  ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(workingCheckPo.getPchckdengji()))){
			buffer.append("and P_CH_GC_dengji = ? ");
			params.add(workingCheckPo.getPchckdengji());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_GC_Remark like '%' + ? + '%'");
			params.add(workingCheckPo.getPchckremark());
		}
		
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and P_CH_GC_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_GC_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
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
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

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
	public List<WorkingCheckPo> selectGlassesChecked(
			SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo, int start, int size) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by pchckcheckdate desc) as rowNum,* from ( ");
		
		buffer.append("select P_CH_GC_SalesId as pchcksalesid , ");
		buffer.append("P_CH_GC_ProcessPersonID as pchckprocesspersonid , ");
		buffer.append("p.personName as pchckprocesspersonname , ");
		buffer.append("P_CH_GC_CheckLabourID as pchckchecklabourid , ");
		buffer.append("c.personName as pchckchecklabourname , ");
		buffer.append("P_CH_GC_CheckDate as pchckcheckdate , ");
		buffer.append("S_SE_SB_TakeGlassData as pchcktakeglasstime , ");
		buffer.append("S_ME_CI_Name as pchckcustomername ");
		buffer.append("from P_CH_GlassesCheck ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SB_SalesID = P_CH_GlassesCheck.P_CH_GC_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_GlassesCheck.P_CH_GC_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_GlassesCheck.P_CH_GC_CheckLabourID ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("where 1=1  ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(workingCheckPo.getPchckdengji()))){
			buffer.append("and P_CH_GC_dengji = ? ");
			params.add(workingCheckPo.getPchckdengji());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_GC_Remark like '%' + ? + '%'");
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
			buffer.append("and P_CH_GC_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_GC_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
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
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}
		buffer.append(" union all ");
		buffer.append("select P_CH_GC_SalesId as pchcksalesid , ");
		buffer.append("P_CH_GC_ProcessPersonID as pchckprocesspersonid , ");
		buffer.append("p.personName as pchckprocesspersonname , ");
		buffer.append("P_CH_GC_CheckLabourID as pchckchecklabourid , ");
		buffer.append("c.personName as pchckchecklabourname , ");
		buffer.append("P_CH_GC_CheckDate as pchckcheckdate , ");
		buffer.append("S_SE_SB_TakeGlassData as pchcktakeglasstime , ");
		buffer.append("S_ME_CI_Name as pchckcustomername ");
		buffer.append("from P_CH_GlassesCheck ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = P_CH_GlassesCheck.P_CH_GC_SalesId ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join SYS_PersonInfo as p on p.ID = P_CH_GlassesCheck.P_CH_GC_ProcessPersonID ");
		buffer.append("inner join SYS_PersonInfo as c on c.ID = P_CH_GlassesCheck.P_CH_GC_CheckLabourID ");
		buffer.append("inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
		buffer.append("where 1=1  ");
		
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(salesBasicPo.getSsesbcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(workingCheckPo.getPchckdengji()))){
			buffer.append("and P_CH_GC_dengji = ? ");
			params.add(workingCheckPo.getPchckdengji());
		}
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(workingCheckPo.getPchckremark()))){
			buffer.append("and P_CH_GC_Remark like '%' + ? + '%'");
			params.add(workingCheckPo.getPchckremark());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		//加工师
		if(!"".equals(Utility.getName(workingCheckPo.getPchckprocesspersonid()))){
			buffer.append("and P_CH_GC_ProcessPersonID = ? ");
			params.add(workingCheckPo.getPchckprocesspersonid());
		}
		//检验员
		if(!"".equals(Utility.getName(workingCheckPo.getPchckchecklabourid()))){
			buffer.append("and P_CH_GC_CheckLabourID = ? ");
			params.add(workingCheckPo.getPchckchecklabourid());
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
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
			params.add(workingCheckPo.getPchckendcheckdate());
		} else if (!"".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& "".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) >= ? ");

			params.add(workingCheckPo.getPchckstartcheckdate());
		} else if ("".equals(Utility.getName(workingCheckPo.getPchckstartcheckdate()))&& !"".equals(Utility.getName(workingCheckPo.getPchckendcheckdate()))) {
			buffer.append("and convert(varchar(10), P_CH_GC_CheckDate, 23) <= ? ");

			params.add(workingCheckPo.getPchckendcheckdate());
		}		
		
		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , WorkingCheckPo.class);
	}
}
