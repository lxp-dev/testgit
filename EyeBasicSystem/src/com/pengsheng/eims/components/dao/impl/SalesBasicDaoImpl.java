package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.components.dao.SalesBasicDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SalesBasicDaoImpl extends BaseJdbcDaoSupport implements
		SalesBasicDao {

	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getDepartments() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_DP_DepartmentID as bdpdepartmentid ");
		buffer.append(",B_DP_DepartmentName  as bdpdepartmentname ");
		buffer.append(",B_DP_Type as bdptype ");
		buffer.append(",B_DP_WizardFlag as bdpwizardflag ");
		buffer.append("FROM B_Departments");

		buffer.append(" order by B_DP_DepartmentID");

		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}
	/**
	 * 销售结帐基表信息数量
	 */
	public int getSalesBasicCount(SalesBasicPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select count(S_SE_SB_SalesID)  ");
	
		buffer.append("from S_SE_SalesBasic ");		

		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where S_SE_SB_InTransit in('4','6','7','8') ");
		buffer.append("and datediff(day,getdate(),S_SE_SB_TakeGlassData) <= (select top 1 S_SE_DS_DelaysDay from S_SE_DelaysReminderSet) ");
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID  like '%' + ? + '%'  ");
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
		buffer.append("select * from(select ROW_NUMBER() Over (order by S_SE_SB_TakeGlassData desc) as rowNum, ");
		buffer.append("S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode, ");
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid, "); 
		buffer.append("S_ME_CI_Name as ssesbpersonName, "); 
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata  ");
		buffer.append("from S_SE_SalesBasic  ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where S_SE_SB_InTransit in('4','6','7','8') ");
		buffer.append("and datediff(day,getdate(),S_SE_SB_TakeGlassData) <= (select top 1 S_SE_DS_DelaysDay from S_SE_DelaysReminderSet) ");
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
		
		buffer.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

	/**
	 * 查询销售结帐基表信息
	 */
	public SalesBasicPo getSalesBasic(SalesBasicPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select top 1 ");
	
		buffer.append("S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("B_DP_DepartmentID as ssesbshopcode , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_ME_CI_Name as ssedrcustomerName , "); 
		buffer.append("S_ME_CI_CustomerID as ssesbcustomerid , "); 
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata  ");
		buffer.append("from S_SE_SalesBasic  ");
		
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_ShopCode = B_Departments.B_DP_DepartmentID ");	
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where S_SE_SB_InTransit =  '4' ");
		buffer.append("and datediff(day,getdate(),S_SE_SB_TakeGlassData) <= (select top 1 S_SE_DS_DelaysDay from S_SE_DelaysReminderSet) ");
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID  like '%' + ? ");
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
		
		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}
	
}
