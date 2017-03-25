package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.PackingListDao;
import com.pengsheng.eims.sales.dao.PutOptometryOrderDao;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PackingListDaoImpl extends BaseJdbcDaoSupport implements
		PackingListDao {

	/**
	 * 根据配镜单号查询顾客信息
	 */
	public CustomerInfoPo getCustmorInfo(CustomerInfoPo customerInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  S_ME_CI_Name as smeciname , S_ME_CI_Sex as smecisex , ");
		buffer.append("S_ME_CI_Birthday as smecibirthday , S_ME_CI_MemberId as smecimemberid , ");
		buffer.append("S_ME_CI_CustomerID as smecicustomerid ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join S_SE_SalesBasic on S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("where 1=1 ");

		if (!"".equals(Utility.getName(customerInfoPo.getFmmsalesid()))) {
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(customerInfoPo.getFmmsalesid());
		}

		buffer.append("and S_SE_SB_ValueFlag = 1 ");

		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}

	/**
	 * 得到打印配镜单数量
	 */
	public int getPackingListCount(SalesBasicPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select count(S_SE_SB_SalesID)  ");
	
		buffer.append("from S_SE_SalesBasic ");		

		buffer.append("inner join B_Departments as aa on S_SE_SalesBasic.S_SE_SB_ShopCode = aa.B_DP_DepartmentID  ");	
		buffer.append("left join B_Departments as bb on S_SE_SalesBasic.S_SE_SB_Location = bb.B_DP_DepartmentID  ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where 1=1 ");
		
		if("1".equals(Utility.getName(po.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");			
			params.add(po.getSsesbdepid());
		}
		
		if("2".equals(Utility.getName(po.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SB_ShopCode in ( ");
			buffer.append("select B_DP_DepartmentID ");
			buffer.append("from B_Departments ");
			buffer.append("where B_DP_RegID = ? ) ");
			
			params.add(po.getSsesbdepid());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%'+ ? + '%'  ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getDjsbm()))){	//配镜单识别码
			buffer.append("and S_SE_SB_Djsbm like '%'+ ? + '%'  ");
			params.add(po.getDjsbm());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%'  ");
			params.add(po.getSsesbcustomerid());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	//销售门店
			buffer.append("and S_SE_SB_ShopCode = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbintransit()))){	//在途状态
			buffer.append("and S_SE_SB_InTransit = ?  ");
			params.add(po.getSsesbintransit());
		} 
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId = ?  ");
			params.add(po.getSsesbMemberId());
		} 
		if(!"".equals(Utility.getName(po.getSsesbphone()))){	//顾客电话
			buffer.append("and S_ME_CI_Phone = ?  ");
			params.add(po.getSsesbphone());
		} 
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		
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
		//配镜日期
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >=  ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());
		}		
		
		if(!"".equals(Utility.getName(po.getSsesbchooseflag()))){	//配镜类型
			buffer.append("and S_SE_SB_OrdersType = ?  ");
			params.add(po.getSsesbchooseflag());
		}  else{
			buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
		}
		
		buffer.append("and S_SE_SB_InTransit = 9 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 得到打印镜单信息
	 */
	public List<SalesBasicPo> selectPackingList(
			SalesBasicPo po, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() Over (order by S_SE_SB_TakeGlassData desc) as rowNum, ");
		
		buffer.append("S_SE_SB_SalesID as ssesbsalesid,S_ME_CI_Phone as ssesbphone, ");
		buffer.append("aa.B_DP_DepartmentName as ssesbshopcode, ");
		buffer.append("S_ME_CI_Name as ssesbcustomerid, ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId, ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata, ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime, ");
		buffer.append("S_SE_SB_InTransit as ssesbintransit, ");
		buffer.append("bb.B_DP_DepartmentName as ssesblocation, ");
		buffer.append("case ");
		buffer.append("when S_SE_SB_OrdersType = '1' then '框镜成品' ");
		buffer.append("when S_SE_SB_OrdersType = '2' then '框镜定做' ");
		buffer.append("when S_SE_SB_OrdersType = '3' then '隐形成品' ");
		buffer.append("when S_SE_SB_OrdersType = '4' then '隐形订做' ");
		buffer.append("when S_SE_SB_OrdersType = '5' then '辅料' ");
		buffer.append("end     AS ssesbchooseflag ");
		buffer.append(",case ");
		buffer.append("when S_SE_SB_OrdersType = '2' then 'D' ");
		buffer.append("when S_SE_SB_OrdersType = '1' then '0' ");
		buffer.append("end     AS ssesbsalestype, ");
		buffer.append("isnull(S_SE_TM_UUID,'') as isMail ");
		buffer.append("from S_SE_SalesBasic ");		
		
		buffer.append("inner join B_Departments as aa on S_SE_SalesBasic.S_SE_SB_ShopCode = aa.B_DP_DepartmentID  ");
		buffer.append("left join  S_SE_ToMail ON S_SE_SB_SalesID = S_SE_TM_LinkSalesID ");
		buffer.append("left join B_Departments as bb on S_SE_SalesBasic.S_SE_SB_Location = bb.B_DP_DepartmentID  ");	
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");	
		buffer.append("where 1=1 ");
		
		if("1".equals(Utility.getName(po.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SB_ShopCode = ? ");
			
			params.add(po.getSsesbdepid());
		}
		if("2".equals(Utility.getName(po.getSsesbdepartmenttype()))){
			buffer.append("and S_SE_SB_ShopCode in ( ");
			buffer.append("select B_DP_DepartmentID ");
			buffer.append("from B_Departments ");
			buffer.append("where B_DP_RegID = ? ) ");
			
			params.add(po.getSsesbdepid());
		}
		if(!"".equals(Utility.getName(po.getSsesbphone()))){	//顾客电话
			buffer.append("and S_ME_CI_Phone = ?  ");
			params.add(po.getSsesbphone());
		} 
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){	//配镜单号
			buffer.append("and S_SE_SB_SalesID like '%' + ? + '%'  ");
			params.add(po.getSsesbsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getDjsbm()))){	//配镜单识别码
			buffer.append("and S_SE_SB_Djsbm like '%'+ ? + '%'  ");
			params.add(po.getDjsbm());
		}
		
		if(!"".equals(Utility.getName(po.getSsesbcustomerid()))){	//顾客姓名
			buffer.append("and S_ME_CI_Name  like '%' + ? + '%' ");
			params.add(po.getSsesbcustomerid());
		} 
		
		//取镜日期
		if(!"".equals(Utility.getName(po.getSsesbtakeglassstartdata())) && !"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){		
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
	
		//配镜日期
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){		
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdatestarttime());
			params.add(po.getSsesbsalesdateendtime());
		}else if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && "".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >=  ? ");
			params.add(po.getSsesbsalesdatestarttime());
		}else if("".equals(Utility.getName(po.getSsesbsalesdatestarttime())) && !"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(po.getSsesbsalesdateendtime());
		}		
		
		if(!"".equals(Utility.getName(po.getSsesbshopcode()))){	//销售门店
			buffer.append("and S_SE_SB_ShopCode = ?  ");
			params.add(po.getSsesbshopcode());
		} 
		
		if(!"".equals(Utility.getName(po.getSsesbintransit()))){	//在途状态
			buffer.append("and S_SE_SB_InTransit = ?  ");
			params.add(po.getSsesbintransit());
		} 
		if(!"".equals(Utility.getName(po.getSsesbchooseflag()))){	//配镜类型
			buffer.append("and S_SE_SB_OrdersType = ?  ");
			params.add(po.getSsesbchooseflag());
		} else{
			buffer.append("and S_SE_SB_OrdersType in ('1','2')  ");
		}
		if(!"".equals(Utility.getName(po.getSsesbMemberId()))){	//顾客卡号
			buffer.append("and S_ME_CI_MemberId = ?  ");
			params.add(po.getSsesbMemberId());
		} 
		buffer.append("and S_SE_SB_InTransit = 9 ");
		
		buffer.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				SalesBasicPo.class);
	}

}
