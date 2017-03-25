package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.RecordWorkingTimeDao;
import com.pengsheng.eims.storage.persistence.FirstCheckPo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class RecordWorkingTimeDaoImpl extends BaseJdbcDaoSupport implements RecordWorkingTimeDao {

	/**
	 * 得到记录加工时间信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getRecordWorkingTimeCount(SalesBasicPo salesBasicPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_SE_SB_SalesID) ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where ((S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) and isnull(S_SE_SB_ProcessDepartment,'')='') or S_SE_SB_ProcessDepartment=?) ");
		buffer.append("and S_SE_SB_InTransit = '6' ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? + '%'");
			params.add(salesBasicPo.getDjsbm());
		}
		
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
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
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
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到记录加工时间信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectRecordWorkingTime(
			SalesBasicPo salesBasicPo, int start, int size) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SB_SalesDatetime desc) as rowNum, ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_WorryType as ssesbworrytype , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("shopcode.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_Location as ssesblocation , ");
		buffer.append("location.B_DP_DepartmentName as ssesbtakeshopname ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where ((S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) and isnull(S_SE_SB_ProcessDepartment,'')='') or S_SE_SB_ProcessDepartment=?) ");
		buffer.append("and S_SE_SB_InTransit = '6' ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? + '%'");
			params.add(salesBasicPo.getDjsbm());
		}
		
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
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
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
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertInTranit(InTransitPo inTransitPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID , S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department ) ");
		buffer.append("values (? , ? , '7' , getdate() , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 根据销售单号更新销售基表中在途点
	 * @param salesBasicPo
	 */
	public void updateSalesBasicInTranit(SalesBasicPo salesBasicPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit= '7' ");
		buffer.append("where S_SE_SB_SalesID= ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
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
		buffer.append("where B_DP_RegID = ? and B_DP_IsClosed='0'");
		
		params.add(departmentsPo.getBdpregid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , DepartmentsPo.class);
	}
	
	/**
	 * 初检新增数据加载
	 * @param salesid
	 * @return
	 */
	public List<FirstCheckPo> getFirstChecks(String salesid){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("SELECT B_GI_ViewGoodsName as pchfcgoodsname, ");
		varname1.append("       S_SE_SD_SalesID as pchfcsalesid, ");
		varname1.append("       salesShop.B_DP_DepartmentID as pchfcsalesshop, ");
		varname1.append("       salesShop.B_DP_DepartmentName as pchfcsalesshopname, ");
		varname1.append("       getShop.B_DP_DepartmentID as pchfcgetShop, ");
		varname1.append("       getShop.B_DP_DepartmentName as pchfcgetshopname, ");
		varname1.append("       S_SE_SB_CustomerID as pchfccustomerid, ");
		varname1.append("       S_ME_CI_Name as pchfccustomername, ");
		varname1.append("       S_ME_CI_Phone as pchfccustomerphone, ");
		varname1.append("       sendperson.id as pchfcsendpersonid, ");
		varname1.append("       sendperson.personName as pchfcsendpersonname, ");
		varname1.append("       getdate() as pchfcfirstcheckdate ");
		varname1.append("FROM   S_SE_SalesBasic ");
		varname1.append("       INNER JOIN dbo.S_SE_SalesDetail ");
		varname1.append("         ON S_SE_SB_SalesID = S_SE_SD_SalesID ");
		varname1.append("       INNER JOIN B_GoodsInfo ");
		varname1.append("         ON B_GI_GoodsID = S_SE_SD_SalesItemID ");
		varname1.append("       INNER JOIN B_Departments salesShop ");
		varname1.append("         ON salesShop.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		varname1.append("       INNER JOIN B_Departments getShop ");
		varname1.append("         ON getShop.B_DP_DepartmentID = S_SE_SB_Location ");
		varname1.append("       INNER JOIN S_ME_CustomerInfo ");
		varname1.append("         ON S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		varname1.append("       INNER JOIN S_SE_InTransit ");
		varname1.append("         ON S_SE_SB_SalesID = S_SE_IT_SalesID ");
		varname1.append("            AND S_SE_IT_State = '7' ");
		varname1.append("       left JOIN SYS_PersonInfo sendperson ");
		varname1.append("         ON S_SE_InTransit.S_SE_IT_CreatePerson = sendperson.id ");
		varname1.append("WHERE  S_SE_SB_SalesID = ? ");
		varname1.append("       AND Substring(S_SE_SD_SalesItemID, 1, 1) = '3' ");
		varname1.append("       AND S_SE_SB_InTransit = '7' ");
		varname1.append("ORDER  BY S_SE_SD_GlassFlag DESC ");
		
		params.add(salesid);
		
		return queryForObjectList(varname1.toString() , params.toArray() , FirstCheckPo.class);
	}
	
	/**
	 * 插入初检信息
	 * @param firstCheckPo
	 */
	public void insertFirstCheckPo(WorkingCheckPo workingCheckPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into P_CH_FirstCheck( ");
		buffer.append("P_CH_FCK_Id , ");
		buffer.append("P_CH_FCK_SalesId , ");
		buffer.append("P_CH_FCK_CokeBallGlassOD , ");
		buffer.append("P_CH_FCK_CokeBallGlassOS , ");
		buffer.append("P_CH_FCK_CokePostGlassOD , ");
		buffer.append("P_CH_FCK_CokePostGlassOS , ");
		buffer.append("P_CH_FCK_CokeAxesOD , ");
		buffer.append("P_CH_FCK_CokeAxesOS , ");
		buffer.append("P_CH_FCK_CokeArriseGlassOD , ");
		buffer.append("P_CH_FCK_CokeArriseGlassOS , ");
		buffer.append("P_CH_FCK_CokeBasisOD , ");
		buffer.append("P_CH_FCK_CokeBasisOS , ");
		buffer.append("P_CH_FCK_CokeAddOD , ");
		buffer.append("P_CH_FCK_CokeAddOS , ");
		buffer.append("P_CH_FCK_CokePupilDistanceOD , ");
		buffer.append("P_CH_FCK_CokePupilDistanceOS , ");
		buffer.append("P_CH_FCK_CokeCenterVertical , ");
		buffer.append("P_CH_FCK_CenterHigh , ");
		buffer.append("P_CH_FCK_Color , ");
		buffer.append("P_CH_FCK_Quality , ");
		buffer.append("P_CH_FCK_Shaping , ");
		buffer.append("P_CH_FCK_ProcessPersonID , ");
		buffer.append("P_CH_FCK_CheckLabourID , ");
		buffer.append("P_CH_FCK_CheckDate,P_CH_FCK_Remark ) ");
		buffer.append("values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ");
		buffer.append("? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate(),? ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(workingCheckPo.getPchcksalesid()));
		params.add(Utility.getName(workingCheckPo.getPchckcokeballglassod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokeballglassos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokepostglassod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokepostglassos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokeaxesod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokeaxesos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokearriseglassod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokearriseglassos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokebasisod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokebasisos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokeaddod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokeaddos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokepupildistanceod()));
		params.add(Utility.getName(workingCheckPo.getPchckcokepupildistanceos()));
		params.add(Utility.getName(workingCheckPo.getPchckcokecentervertical()));
		params.add(Utility.getName(workingCheckPo.getPchckcenterhigh()));
		params.add(Utility.getName(workingCheckPo.getPchckcolor()));
		params.add(Utility.getName(workingCheckPo.getPchckquality()));
		params.add(Utility.getName(workingCheckPo.getPchckshaping()));
		params.add(Utility.getName(workingCheckPo.getPchckprocesspersonid()));
		params.add(Utility.getName(workingCheckPo.getPchckchecklabourid()));
		params.add(Utility.getName(workingCheckPo.getPchckremark()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	
	/**
	 * 得到初检记录数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getRecordWorkingCheckCount(SalesBasicPo salesBasicPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append(" select sum(count1) from ( ");
		buffer.append("select count(*) as count1 ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join P_CH_FirstCheck on P_CH_FCK_SalesId = S_SE_SB_SalesID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("where S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		if(!"".equals(Utility.getName(salesBasicPo.getRemark()))){
			buffer.append("and P_CH_FCK_Remark like '%' + ? + '%' ");
			params.add(salesBasicPo.getRemark());
		}
		
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
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
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
		buffer.append(" union all ");
		buffer.append("select count(*) as count1 ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join P_CH_FirstCheck on P_CH_FCK_SalesId = S_SE_SB_SalesID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("where S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		if(!"".equals(Utility.getName(salesBasicPo.getRemark()))){
			buffer.append("and P_CH_FCK_Remark like '%' + ? + '%' ");
			params.add(salesBasicPo.getRemark());
		}
		
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
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
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
		buffer.append(" )t ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到初检记录信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectRecordWorkingCheck(
			SalesBasicPo salesBasicPo, int start, int size) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by ssesbsalesid) as rowNum,* from ( ");
		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("shopcode.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_Location as ssesblocation , ");
		buffer.append("location.B_DP_DepartmentName as ssesbtakeshopname ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join P_CH_FirstCheck on P_CH_FCK_SalesId = S_SE_SB_SalesID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getRemark()))){
			buffer.append("and P_CH_FCK_Remark like '%' + ? + '%'  ");
			params.add(salesBasicPo.getRemark());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
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
		buffer.append(" union all ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("shopcode.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_Location as ssesblocation , ");
		buffer.append("location.B_DP_DepartmentName as ssesbtakeshopname ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join P_CH_FirstCheck on P_CH_FCK_SalesId = S_SE_SB_SalesID ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("where S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		//销售单号
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getRemark()))){
			buffer.append("and P_CH_FCK_Remark like '%' + ? + '%'  ");
			params.add(salesBasicPo.getRemark());
		}
		//顾客姓名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%'");
			params.add(salesBasicPo.getSsesbpersonName());
		}
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
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
		
		buffer.append(" ) temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 初检记录数据加载
	 * @param salesid
	 * @return
	 */
	public WorkingCheckPo getFirstChecksDetails(String salesid){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>(); 

		varname1.append("SELECT  ");
		varname1.append("       c.personName                 AS pchckchecklabourname, ");
		varname1.append("       P_CH_FCK_SalesId             AS pchcksalesid, ");
		varname1.append("       P_CH_FCK_CokeBallGlassOD     AS pchckcokeballglassod, ");
		varname1.append("       P_CH_FCK_CokeBallGlassOS     AS pchckcokeballglassos, ");
		varname1.append("       P_CH_FCK_CokePostGlassOD     AS pchckcokepostglassod, ");
		varname1.append("       P_CH_FCK_CokePostGlassOS     AS pchckcokepostglassos, ");
		varname1.append("       P_CH_FCK_CokeAxesOD          AS pchckcokeaxesod, ");
		varname1.append("       P_CH_FCK_CokeAxesOS          AS pchckcokeaxesos, ");
		varname1.append("       P_CH_FCK_CokeArriseGlassOD   AS pchckcokearriseglassod, ");
		varname1.append("       P_CH_FCK_CokeArriseGlassOS   AS pchckcokearriseglassos, ");
		varname1.append("       P_CH_FCK_CokeBasisOD         AS pchckcokebasisod, ");
		varname1.append("       P_CH_FCK_CokeBasisOS         AS pchckcokebasisos, ");
		varname1.append("       P_CH_FCK_CokeAddOD           AS pchckcokeaddod, ");
		varname1.append("       P_CH_FCK_CokeAddOS           AS pchckcokeaddos, ");
		varname1.append("       P_CH_FCK_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		varname1.append("       P_CH_FCK_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		varname1.append("       P_CH_FCK_CokeCenterVertical  AS pchckcokecentervertical, ");
		varname1.append("       P_CH_FCK_Color				 AS pchckcolor, ");
		varname1.append("       P_CH_FCK_CheckDate           AS pchckcheckdate, ");
		varname1.append("       P_CH_FCK_Remark              AS pchckremark, ");
		varname1.append("       P_CH_FCK_ProcessPersonID     AS pchckprocesspersonid ");
		varname1.append("FROM   P_CH_FirstCheck ");
		varname1.append("       INNER JOIN SYS_PersonInfo AS c ");
		varname1.append("         ON c.ID = P_CH_FirstCheck.P_CH_FCK_CheckLabourID ");
		varname1.append("WHERE  P_CH_FCK_SalesId = ? ");
		
		params.add(salesid);
		
		return (WorkingCheckPo) this.queryForObject(varname1.toString(), params.toArray(), WorkingCheckPo.class);
	}
	
	/**
	 * 加工师加工Count
	 * @param salesBasicPo
	 * @return
	 */
	public int selectStartWorkingCount(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();

		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('7') ");
		buffer.append("select count(S_SE_SB_SalesID) ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where ((S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) and isnull(S_SE_SB_ProcessDepartment,'')='') or S_SE_SB_ProcessDepartment=?) ");
		buffer.append("and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
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
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? + '%'");
			params.add(salesBasicPo.getDjsbm());
		}
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
		}
		
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		buffer.append(" drop table #dpt ");
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 加工师加工List
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectStartWorkingList(SalesBasicPo salesBasicPo, int start, int size) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;

		buffer.append("SELECT DISTINCT inTransit into #dpt FROM ufn_currentintransittab('7') ");
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_SB_SalesID) as rowNum, ");
		buffer.append("S_SE_SB_WorryType as ssesbworrytype, ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("shopcode.B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_Location as ssesblocation , ");
		buffer.append("location.B_DP_DepartmentName as ssesbtakeshopname ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as shopcode on shopcode.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as location on location.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where ((S_SE_SB_ShopCode in  (select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) and isnull(S_SE_SB_ProcessDepartment,'')='') or S_SE_SB_ProcessDepartment=?) ");
		buffer.append("and S_SE_SB_InTransit in (SELECT inTransit FROM #dpt) ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbworrytype()))){
			buffer.append("and S_SE_SB_WorryType = ? ");
			params.add(salesBasicPo.getSsesbworrytype());
		}
		if(!"".equals(Utility.getName(salesBasicPo.getDjsbm()))){
			buffer.append("and S_SE_SB_Djsbm like '%' + ? + '%'");
			params.add(salesBasicPo.getDjsbm());
		}
		
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
		
		//销售门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
		
		//取镜门店
		if(!"".equals(Utility.getName(salesBasicPo.getSsesblocation()))){
			buffer.append("and S_SE_SB_Location = ? ");
			params.add(salesBasicPo.getSsesblocation());
		}
		
		//销售日期
		if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))	&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
			params.add(salesBasicPo.getSsesbsalesdateendtime());
		} else if (!"".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& "".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) >= ? ");

			params.add(salesBasicPo.getSsesbsalesdatestarttime());
		} else if ("".equals(Utility.getName(salesBasicPo.getSsesbsalesdatestarttime()))&& !"".equals(Utility.getName(salesBasicPo.getSsesbsalesdateendtime()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_PosDatetime, 23) <= ? ");

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
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		buffer.append(" drop table #dpt ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 根据加工师加工在途点更新销售基表
	 * @param salesBasicPo
	 */
	public void updateSalesBasicInTranitStartWorking(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update S_SE_SalesBasic ");
		buffer.append("set S_SE_SB_InTransit = '8' ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		
		params.add(salesBasicPo.getSsesbsalesid());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertStartWorkingInTranit(InTransitPo inTransitPo) {
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
			
		buffer.append("insert into S_SE_InTransit( ");
		buffer.append("S_SE_IT_ID , S_SE_IT_SalesID , S_SE_IT_State , ");
		buffer.append("S_SE_IT_Date , S_SE_IT_CreatePerson , S_SE_IT_Department ) ");
		buffer.append("values (? , ? , '8' , getdate() , ? , ?) ");
		
		params.add(this.uuid.generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
}
