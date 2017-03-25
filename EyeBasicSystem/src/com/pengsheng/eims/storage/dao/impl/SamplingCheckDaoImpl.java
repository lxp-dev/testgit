package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.SamplingCheckDao;
import com.pengsheng.eims.storage.dao.WorkingCheckDao;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer.Param;

public class SamplingCheckDaoImpl extends BaseJdbcDaoSupport implements SamplingCheckDao {

	/**
	 * 得到检验信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getWorkingCheckCount(SalesBasicPo salesBasicPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(S_SE_SB_SalesID) ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State='7' ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		buffer.append("and S_SE_SB_InTransit = '8' and S_SE_SB_OrdersType in (1,2) and P_CH_CK_IsSampled <> '1' ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		//沈兴贺2011-4-18-----添加门店名---------------
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
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
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by S_SE_IT_Date desc) as rowNum, ");
		
		buffer.append("S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_IT_Date as ssesbmaterialsdate , ");
		buffer.append("personName as ssesbmaterialsperson ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join S_SE_InTransit on S_SE_InTransit.S_SE_IT_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID = S_SE_InTransit.S_SE_IT_CreatePerson and S_SE_IT_State='7' ");
		buffer.append("where S_SE_SB_ShopCode in ( ");
		buffer.append("select B_DP_DepartmentID from B_Departments where B_DP_RegID = ? ) ");
		buffer.append("and S_SE_SB_InTransit = '8' and S_SE_SB_OrdersType in (1,2) and P_CH_CK_IsSampled <> '1' ");
		
		params.add(salesBasicPo.getSsesbdepartmentid());
		
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? ");
			params.add(salesBasicPo.getSsesbsalesid());
		}
		
		//添加门店名
		if(!"".equals(Utility.getName(salesBasicPo.getSsesbshopcode()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			params.add(salesBasicPo.getSsesbshopcode());
		}
    	//添加取镜日期判断
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
		buffer.append("dbo.getCenterVertical(replace(S_SE_SB_BallGlassOD , '+' , '') , replace(S_SE_SB_PostGlassOD , '+' , '') , case when S_SE_SB_AxesOS = '' then '0' end , ");
		buffer.append("replace(S_SE_SB_BallGlassOS , '+' , '') , replace(S_SE_SB_PostGlassOS , '+' , '') , case when S_SE_SB_AxesOS = '' then '0' end ) as ssesblightvertical ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments as s on s.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("inner join B_Departments as t on t.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_Location ");
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
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		buffer.append("where S_SE_SB_SalesID = ? and S_SE_SD_GlassFlag = 'R' ");
		
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
		buffer.append("S_SE_SD_SalesItemName as ssesbgoodsname ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_SE_SalesDetail on S_SE_SalesDetail.S_SE_SD_SalesID = S_SE_SalesBasic.S_SE_SB_SalesID ");
		buffer.append("inner join b_goodsinfo on b_goodsinfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
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
		
		params.add(salesBasicPo.getSsesbsalesid());
		
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
		//只出现加工师
		//buffer.append("select ID as id , personName as personName ");
		//buffer.append("from SYS_PersonInfo ");
		//buffer.append("where departmentID = ? ");
		buffer.append("select SYS_PersonInfo.id as id,personName as personName from SYS_PersonInfo ");
		buffer.append("inner join SYS_PersonRoles on personID = SYS_PersonInfo.ID ");
		buffer.append("inner join SYS_Roles on SYS_Roles.roleID = SYS_PersonRoles.roleID ");
		buffer.append("where rolename like '加工师%' ");
		
		params.add(personInfoPo.getDepartmentID());
		
		//return queryForObjectList(buffer.toString() , params.toArray() , PersonInfoPo.class);
		return queryForObjectList(buffer.toString() , null , PersonInfoPo.class);
	}

	/**
	 * 插入加工检验表 
	 * @param workingCheckPo
	 */
	public void insertWorkingCheck(WorkingCheckPo workingCheckPo) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into P_CH_SamplingCheck( ");
		buffer.append("P_CH_SK_Id , ");
		buffer.append("P_CH_SK_SalesId , ");
		buffer.append("P_CH_SK_CokeBallGlassOD , ");
		buffer.append("P_CH_SK_CokeBallGlassOS , ");
		buffer.append("P_CH_SK_CokePostGlassOD , ");
		buffer.append("P_CH_SK_CokePostGlassOS , ");
		buffer.append("P_CH_SK_CokeAxesOD , ");
		buffer.append("P_CH_SK_CokeAxesOS , ");
		buffer.append("P_CH_SK_CokeArriseGlassOD , ");
		buffer.append("P_CH_SK_CokeArriseGlassOS , ");
		buffer.append("P_CH_SK_CokeBasisOD , ");
		buffer.append("P_CH_SK_CokeBasisOS , ");
		buffer.append("P_CH_SK_CokeAddOD , ");
		buffer.append("P_CH_SK_CokeAddOS , ");
		buffer.append("P_CH_SK_CokePupilDistanceOD , ");
		buffer.append("P_CH_SK_CokePupilDistanceOS , ");
		buffer.append("P_CH_SK_CokeCenterVertical , ");
		buffer.append("P_CH_SK_CenterHigh , ");
		buffer.append("P_CH_SK_Color , ");
		buffer.append("P_CH_SK_Quality , ");
		buffer.append("P_CH_SK_Shaping , ");
		buffer.append("P_CH_SK_ProcessPersonID , ");
		buffer.append("P_CH_SK_CheckLabourID , ");
		buffer.append("P_CH_SK_CheckDate ,  ");
		buffer.append("P_CH_SK_Qualified ) ");
		buffer.append("values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ");
		buffer.append("? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate(),? ) ");
		
		params.add(this.uuid.generate());
		params.add(workingCheckPo.getPchcksalesid());
		params.add(workingCheckPo.getPchckcokeballglassod());
		params.add(workingCheckPo.getPchckcokeballglassos());
		params.add(workingCheckPo.getPchckcokepostglassod());
		params.add(workingCheckPo.getPchckcokepostglassos());
		params.add(workingCheckPo.getPchckcokeaxesod());
		params.add(workingCheckPo.getPchckcokeaxesos());
		params.add(workingCheckPo.getPchckcokearriseglassod());
		params.add(workingCheckPo.getPchckcokearriseglassos());
		params.add(workingCheckPo.getPchckcokebasisod());
		params.add(workingCheckPo.getPchckcokebasisos());
		params.add(workingCheckPo.getPchckcokeaddod());
		params.add(workingCheckPo.getPchckcokeaddos());
		params.add(workingCheckPo.getPchckcokepupildistanceod());
		params.add(workingCheckPo.getPchckcokepupildistanceos());
		params.add(workingCheckPo.getPchckcokecentervertical());
		params.add(workingCheckPo.getPchckcenterhigh());
		params.add(workingCheckPo.getPchckcolor());
		params.add(workingCheckPo.getPchckquality());
		params.add(workingCheckPo.getPchckshaping());
		params.add(workingCheckPo.getPchckprocesspersonid());
		params.add(workingCheckPo.getPchckchecklabourid());
		params.add(workingCheckPo.getPchckqualified());
		
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
		salesBasicPo.setSsesbaxesod("".equals(Utility.getName(salesBasicPo.getSsesbaxesod()))?"0.00":salesBasicPo.getSsesbaxesod());
		salesBasicPo.setSsesbaxesos("".equals(Utility.getName(salesBasicPo.getSsesbaxesos()))?"0.00":salesBasicPo.getSsesbaxesos());
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select top 1 f_mt_value as "+type+" from F_mistake ");
		sb.append("where F_MT_type=3 and cast(F_MT_lower1 as float)<=abs((select cast(? as float)+(cast(? as float)*SQUARE(sin(PI()/(180/cast(? as float))))))) and cast(F_MT_cap1 as float)>= abs((select cast(? as float)+(cast(? as float)*SQUARE(sin(PI()/(180/cast(? as float)))))))");
		
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?salesBasicPo.getSsesbpostglassos():salesBasicPo.getSsesbpostglassod());
		Double tongjuod = Double.parseDouble(salesBasicPo.getSsesbaxesod());
		Double tongjuos = Double.parseDouble(salesBasicPo.getSsesbaxesos());
		String zero = "0.01";
		if(tongjuod!=0.00&&tongjuos==0.00){
			if(tongjuod > 90 && tongjuod < 180){
				tongjuod = 180 - tongjuod;
			}else if(tongjuod > 0 && tongjuod <= 90){
				
			}else{
				tongjuod = 0.01;
			}
			params.add(tongjuod.toString());
		}else if(tongjuod==0.00&&tongjuos!=0.00){
			if(tongjuos > 90 && tongjuos < 180){
				tongjuos = 180 - tongjuos;
			}else if(tongjuos > 0 && tongjuos <= 90){
				
			}else{
				tongjuos = 0.01;
			}
			params.add(tongjuos.toString());
		}else if(tongjuod==0.00&&tongjuos==0.00){
			params.add(zero);
		}
		
		params.add(Utility.getName(salesBasicPo.getSsesbballglassod()).equals("")?salesBasicPo.getSsesbballglassos():salesBasicPo.getSsesbballglassod());
		params.add(Utility.getName(salesBasicPo.getSsesbpostglassod()).equals("")?salesBasicPo.getSsesbpostglassos():salesBasicPo.getSsesbpostglassod());
		if(tongjuod!=0.00&&tongjuos==0.00){
			if(tongjuod > 90 && tongjuod < 180){
				tongjuod = 180 - tongjuod;
			}else if(tongjuod > 0 && tongjuod <= 90){
				
			}else{
				tongjuod = 0.01;
			}
			params.add(tongjuod.toString());
		}else if(tongjuod==0.00&&tongjuos!=0.00){
			if(tongjuos > 90 && tongjuos < 180){
				tongjuos = 180 - tongjuos;
			}else if(tongjuos > 0 && tongjuos <= 90){
				
			}else{
				tongjuos = 0.01;
			}
			params.add(tongjuos.toString());
		}else if(tongjuod==0.00&&tongjuos==0.00){
			params.add(zero);
		}
		
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
		varname1.append("SELECT TOP 1 P_CH_SK_Id                  AS pchckid, ");
		varname1.append("             P_CH_SK_SalesId             AS pchcksalesid, ");
		varname1.append("             P_CH_SK_CokeBallGlassOD     AS pchckcokeballglassod, ");
		varname1.append("             P_CH_SK_CokeBallGlassOS     AS pchckcokeballglassos, ");
		varname1.append("             P_CH_SK_CokePostGlassOD     AS pchckcokepostglassod, ");
		varname1.append("             P_CH_SK_CokePostGlassOS     AS pchckcokepostglassos, ");
		varname1.append("             P_CH_SK_CokeAxesOD          AS pchckcokeaxesod, ");
		varname1.append("             P_CH_SK_CokeAxesOS          AS pchckcokeaxesos, ");
		varname1.append("             P_CH_SK_CokeArriseGlassOD   AS pchckcokearriseglassod, ");
		varname1.append("             P_CH_SK_CokeArriseGlassOS   AS pchckcokearriseglassos, ");
		varname1.append("             P_CH_SK_CokeBasisOD         AS pchckcokebasisod, ");
		varname1.append("             P_CH_SK_CokeBasisOS         AS pchckcokebasisos, ");
		varname1.append("             P_CH_SK_CokeAddOD           AS pchckcokeaddod, ");
		varname1.append("             P_CH_SK_CokeAddOS           AS pchckcokeaddos, ");
		varname1.append("             P_CH_SK_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		varname1.append("             P_CH_SK_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		varname1.append("             P_CH_SK_CokeCenterVertical  AS pchckcokecentervertical, ");
		varname1.append("             P_CH_SK_ProcessPersonID     AS pchckprocesspersonid, ");
		varname1.append("             P_CH_SK_CheckLabourID       AS pchckchecklabourid, ");
		varname1.append("             P_CH_SK_Remark              AS pchckremark, ");
		varname1.append("             P_CH_SK_CheckDate           AS pchckcheckdate ");
		varname1.append("FROM   S_SE_SalesBasic ");
		varname1.append("       INNER JOIN P_CH_Check ");
		varname1.append("         ON S_SE_SB_SalesID = P_CH_SK_SalesId ");
		varname1.append("WHERE  S_SE_SB_CustomerID = ? ");
		varname1.append("ORDER  BY P_CH_SK_CheckDate DESC ");
		
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
		varname1.append("       P_CH_SK_SalesId             AS pchcksalesid, ");
		varname1.append("       P_CH_SK_CokeBallGlassOD     AS pchckcokeballglassod, ");
		varname1.append("       P_CH_SK_CokeBallGlassOS     AS pchckcokeballglassos, ");
		varname1.append("       P_CH_SK_CokePostGlassOD     AS pchckcokepostglassod, ");
		varname1.append("       P_CH_SK_CokePostGlassOS     AS pchckcokepostglassos, ");
		varname1.append("       P_CH_SK_CokeAxesOD          AS pchckcokeaxesod, ");
		varname1.append("       P_CH_SK_CokeAxesOS          AS pchckcokeaxesos, ");
		varname1.append("       P_CH_SK_CokeArriseGlassOD   AS pchckcokearriseglassod, ");
		varname1.append("       P_CH_SK_CokeArriseGlassOS   AS pchckcokearriseglassos, ");
		varname1.append("       P_CH_SK_CokeBasisOD         AS pchckcokebasisod, ");
		varname1.append("       P_CH_SK_CokeBasisOS         AS pchckcokebasisos, ");
		varname1.append("       P_CH_SK_CokeAddOD           AS pchckcokeaddod, ");
		varname1.append("       P_CH_SK_CokeAddOS           AS pchckcokeaddos, ");
		varname1.append("       P_CH_SK_CokePupilDistanceOD AS pchckcokepupildistanceod, ");
		varname1.append("       P_CH_SK_CokePupilDistanceOS AS pchckcokepupildistanceos, ");
		varname1.append("       P_CH_SK_CokeCenterVertical  AS pchckcokecentervertical, ");
		varname1.append("       P_CH_SK_CheckDate           AS pchckcheckdate ");
		varname1.append("FROM   P_CH_Check ");
		varname1.append("       INNER JOIN SYS_PersonInfo AS p ");
		varname1.append("         ON p.ID = P_CH_Check.P_CH_SK_ProcessPersonID ");
		varname1.append("       INNER JOIN SYS_PersonInfo AS c ");
		varname1.append("         ON c.ID = P_CH_Check.P_CH_SK_CheckLabourID ");
		varname1.append("WHERE  P_CH_SK_SalesId = ? ");
		
		params.add(salesid);
		
		return (WorkingCheckPo) this.queryForObject(varname1.toString(), params.toArray(), WorkingCheckPo.class);
	}
	
	/**
	 * 更新检验单抽检状态
	 * @param salesDetailPo
	 */
	public void updateWorkingCheckIsSampled(String salesid) {
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("update P_CH_Check ");
		buffer.append("set P_CH_CK_IsSampled= '1' ");
		buffer.append("where P_CH_CK_SalesId= ? ");
		
		params.add(salesid);
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
}
