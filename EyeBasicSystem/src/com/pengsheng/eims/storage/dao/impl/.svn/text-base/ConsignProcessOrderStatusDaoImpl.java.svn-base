package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessOrderStatusDao;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.orders.storage.persistence.ProcurementOrderEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendEntryPo;
import com.pengsheng.orders.storage.persistence.ProcurementSendPo;

public class ConsignProcessOrderStatusDaoImpl extends BaseJdbcDaoSupport implements  ConsignProcessOrderStatusDao {

	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 F_CN_ID as fcnId ");
		buffer.append("from F_CompanyName ");
		
		return (CompanyNamePo) queryForObject(buffer.toString() , params.toArray() , CompanyNamePo.class);
	}

	/**
	 * 得到委外订单状态数量
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getConsignProcessOrderStatusCount(
			ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(C_ST_P_ID) ");
		buffer.append("from Orders.orders.dbo.C_ST_Po ");
		buffer.append("inner join Orders.orders.dbo.B_Departments ");
		buffer.append("on B_DP_DepartmentID = C_ST_P_SupplierID ");
		buffer.append("left outer join Orders.orders.dbo.SYS_PersonInfo ");
		buffer.append("on ID = C_ST_P_AuditPerson ");
		buffer.append("where C_ST_P_BillTypeId = '2' ");
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpid()))){
			buffer.append("and C_ST_P_ID like '%'+? + '%'");//quyanping buffer.append("and C_ST_P_ID like ? + '-%' + ? ");
			
			//params.add(procurementOrdersPo.getCstpcompanyid());
			params.add(procurementOrdersPo.getCstpid());
		}else if("".equals(Utility.getName(procurementOrdersPo.getCstpid()))){
			buffer.append("and C_ST_P_ID like '%'+? + '%' ");//quyanping  buffer.append("and C_ST_P_ID like ? + '-%' ");
			
			params.add(procurementOrdersPo.getCstpcompanyid());
		}
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpauditstate()))){
			buffer.append("and C_ST_P_AuditState = ? ");
			params.add(procurementOrdersPo.getCstpauditstate());
		}
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpsupplierid()))){
			buffer.append("and C_ST_P_SupplierID = (select B_SP_OrderSupplierID ");
			buffer.append("from B_Supplier where B_SP_ID = ? ) ");
			params.add(procurementOrdersPo.getCstpsupplierid());
		}
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpbillstartdate()))	
				&& !"".equals(Utility.getName(procurementOrdersPo.getCstpbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpbillstartdate());
			params.add(procurementOrdersPo.getCstpbillenddate());
		} else if (!"".equals(Utility.getName(procurementOrdersPo.getCstpbillstartdate()))
				&& "".equals(Utility.getName(procurementOrdersPo.getCstpbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(procurementOrdersPo.getCstpbillstartdate());
		} else if ("".equals(Utility.getName(procurementOrdersPo.getCstpbillstartdate()))
				&& !"".equals(Utility.getName(procurementOrdersPo.getCstpbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpbillenddate());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询委外订单状态信息
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> selectConsignProcessOrderStatus(
			ProcurementOrdersPo procurementOrdersPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_P_BillDate desc , C_ST_P_ID) as rowNum, ");
		
		buffer.append("C_ST_P_ID as cstpid , ");
		buffer.append("B_DP_DepartmentName as cstpsuppliername , ");
		buffer.append("personName as cstpauditpersonname , ");
		buffer.append("C_ST_P_AuditState as cstpauditstate , ");
		buffer.append("C_ST_P_BillDate as cstpbilldate , ");
		buffer.append("C_ST_P_AuditDate as cstpauditdate ");
		buffer.append("from Orders.orders.dbo.C_ST_Po ");
		buffer.append("inner join Orders.orders.dbo.B_Departments ");
		buffer.append("on B_DP_DepartmentID = C_ST_P_SupplierID ");
		buffer.append("left outer join Orders.orders.dbo.SYS_PersonInfo ");
		buffer.append("on ID = C_ST_P_AuditPerson ");
		buffer.append("where C_ST_P_BillTypeId = '2' ");
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpid()))){
			buffer.append("and C_ST_P_ID like '%' + ? +'%'");//quyanping buffer.append("and C_ST_P_ID like ? + '-%' + ? ");
			
			//params.add(procurementOrdersPo.getCstpcompanyid());
			params.add(procurementOrdersPo.getCstpid());
		}else if("".equals(Utility.getName(procurementOrdersPo.getCstpid()))){
			buffer.append("and C_ST_P_ID like '%'+? + '%' ");//quyanping buffer.append("and C_ST_P_ID like ? + '-%' ");
			
			params.add(procurementOrdersPo.getCstpcompanyid());
		}
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpauditstate()))){
			buffer.append("and C_ST_P_AuditState = ? ");
			params.add(procurementOrdersPo.getCstpauditstate());
		}
		
		if(!"".equals(Utility.getName(procurementOrdersPo.getCstpsupplierid()))){
			buffer.append("and C_ST_P_SupplierID = (select B_SP_OrderSupplierID ");
			buffer.append("from B_Supplier where B_SP_ID = ? ) ");
			params.add(procurementOrdersPo.getCstpsupplierid());
		}
		
		if (!"".equals(Utility.getName(procurementOrdersPo.getCstpbillstartdate()))	
				&& !"".equals(Utility.getName(procurementOrdersPo.getCstpbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpbillstartdate());
			params.add(procurementOrdersPo.getCstpbillenddate());
		} else if (!"".equals(Utility.getName(procurementOrdersPo.getCstpbillstartdate()))
				&& "".equals(Utility.getName(procurementOrdersPo.getCstpbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) >= ? ");

			params.add(procurementOrdersPo.getCstpbillstartdate());
		} else if ("".equals(Utility.getName(procurementOrdersPo.getCstpbillstartdate()))
				&& !"".equals(Utility.getName(procurementOrdersPo.getCstpbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_P_BillDate, 23) <= ? ");

			params.add(procurementOrdersPo.getCstpbillenddate());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , ProcurementOrdersPo.class);
	}

	/**
	 * 得到委外订单详细开窗中表头信息
	 * @param procurementOrdersPo
	 * @return
	 */
	public ProcurementOrdersPo getConsignProcessOrderStatus(
			ProcurementOrdersPo procurementOrdersPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  C_ST_P_ID as cstpid , ");
		buffer.append("B_DP_DepartmentName as cstpsuppliername , ");
		buffer.append("C_ST_P_BillDate as cstpbilldate , ");
		buffer.append("C_ST_P_AuditState as cstpauditstate ");
		buffer.append("from Orders.orders.dbo.C_ST_Po ");
		buffer.append("inner join Orders.orders.dbo.B_Departments ");
		buffer.append("on B_DP_DepartmentID = C_ST_P_SupplierID ");
		buffer.append("where C_ST_P_ID = ? ");
		
		params.add(procurementOrdersPo.getCstpid());
		
		return (ProcurementOrdersPo) queryForObject(buffer.toString() , params.toArray() , ProcurementOrdersPo.class);
	}

	/**
	 * 委外发货单详细
	 * @param procurementSendPo
	 * @return
	 */
	public List<ProcurementSendPo> selectConsignProcessSend(
			ProcurementSendPo procurementSendPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select C_ST_D_ID as cstdid , ");
		buffer.append("C_ST_D_PoID as cstdpoid , ");
		buffer.append("personName as cstdcreatepersonname , ");
		buffer.append("B_DP_DepartmentName as cstdcustomername , ");
		buffer.append("C_ST_D_BillDate as cstdbilldate , ");
		buffer.append("C_ST_D_AuditState as cstdauditstate ");
		buffer.append("from Orders.orders.dbo.C_ST_Delivery ");
		buffer.append("inner join Orders.orders.dbo.SYS_PersonInfo on ID = C_ST_D_CreatePerson ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_D_CustomerID ");
		buffer.append("where C_ST_D_PoID = ? ");
		
		params.add(procurementSendPo.getCstdpoid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ProcurementSendPo.class);
	}

	/**
	 * 委外订单详细开窗中表体信息
	 * @param procurementOrderEntryPo
	 * @return
	 */
	public List<ProcurementOrderEntryPo> selectOrderDetaile(
			ProcurementOrderEntryPo procurementOrderEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select C_ST_PE_GoodsName as cstpegoodsname , ");
		buffer.append("C_ST_PE_Spec as cstpespec , ");
		buffer.append("C_ST_PE_Color as cstpecolor , ");
		buffer.append("C_ST_PE_BallGlass as cstpeballglass , ");
		buffer.append("C_ST_PE_PostGlass as cstpepostglass , ");
		buffer.append("C_ST_PE_Axis as cstpeaxis , ");
		buffer.append("C_ST_PE_Add as cstpeadd , ");
		buffer.append("C_ST_PE_ArriseGlass as cstpearriseglass , ");
		buffer.append("C_ST_PE_Basis as cstpebasis , ");
		buffer.append("C_ST_PE_OrderNumber as cstpeordernumber ");
		buffer.append("from Orders.orders.dbo.C_ST_PoEntry ");
		buffer.append("where C_ST_PE_PoID = ? ");
		
		params.add(procurementOrderEntryPo.getCstpepoid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ProcurementOrderEntryPo.class);
	}

	/**
	 * 委外发货单详细开窗中表头
	 * @param procurementSendPo
	 * @return
	 */
	public ProcurementSendPo getConsginSend(ProcurementSendPo procurementSendPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  C_ST_D_ID as cstdid , ");
		buffer.append("C_ST_D_PoID as cstdpoid , ");
		buffer.append("personName as cstdcreatepersonname , ");
		buffer.append("B_DP_DepartmentName as cstdcustomername , ");
		buffer.append("C_ST_D_BillDate as cstdbilldate , ");
		buffer.append("C_ST_D_AuditState as cstdauditstate ");
		buffer.append("from Orders.orders.dbo.C_ST_Delivery ");
		buffer.append("inner join Orders.orders.dbo.SYS_PersonInfo on ID = C_ST_D_CreatePerson ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_D_CustomerID ");
		buffer.append("where C_ST_D_ID = ? ");
		
		params.add(procurementSendPo.getCstdid());
		
		return (ProcurementSendPo) queryForObject(buffer.toString() , params.toArray() , ProcurementSendPo.class);
	}

	/**
	 * 委外发货单详细开窗中表体
	 * @param procurementSendEntryPo
	 * @return
	 */
	public List<ProcurementSendEntryPo> selectSendDetaile(
			ProcurementSendEntryPo procurementSendEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select C_ST_DE_GoodsName as cstdegoodsname , ");
		buffer.append("C_ST_DE_Spec as cstdespec , ");
		buffer.append("C_ST_DE_Color as cstdecolor , ");
		buffer.append("C_ST_DE_BallGlass as cstdeballglass , ");
		buffer.append("C_ST_DE_PostGlass as cstdepostglass , ");
		buffer.append("C_ST_DE_Axis as cstdeaxis , ");
		buffer.append("C_ST_DE_Add as cstdeadd , ");
		buffer.append("C_ST_DE_ArriseGlass as cstdearriseglass , ");
		buffer.append("C_ST_DE_Basis as cstdebasis , ");
		buffer.append("C_ST_DE_OrderNumber as cstdeordernumber , ");
		buffer.append("C_ST_DE_DeliveryNumber as cstdedeliverynumber ");
		buffer.append("from Orders.orders.dbo.C_ST_DeliveryEntry ");
		buffer.append("where C_ST_DE_DeliveryID = ? ");
		
		params.add(procurementSendEntryPo.getCstdedeliveryid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ProcurementSendEntryPo.class);
	}

}
