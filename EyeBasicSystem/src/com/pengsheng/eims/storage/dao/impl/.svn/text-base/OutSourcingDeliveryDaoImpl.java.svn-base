package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.OutSourcingDeliveryDao;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OutSourcingDeliveryDaoImpl extends BaseJdbcDaoSupport implements OutSourcingDeliveryDao {
	
	/**
	 * 获取未发料的框镜委外收货单列表
	 */
	public List<SalesBasicPo> getNotMaterialsSalesBillList(ConsignProcessReceiptPo crpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid,a.B_DP_DepartmentName as ssesbshopName,a.B_DP_RegID as ssesbfaliaodtpid,convert(varchar(10),C_ST_CPR_AuditDate,120) as ssesbshouhuodate,personName as ssesbshouhuoren,b.B_DP_DepartmentName as ssesbfaliaodtpname,C_ST_CPR_InStockId as ssesbinwarehouseid, ");
		buffer.append("B_WH_warehouseName as ssesbinwarehousename,(select top 1 B_WH_ID from B_Warehouse where B_WH_deptID = a.B_DP_RegID order by B_WH_orderNumber) as ssesbfaliaostockid ");
		buffer.append("  from S_SE_SalesBasic left join B_Departments a on S_SE_SB_ShopCode = a.B_DP_DepartmentID ");
		buffer.append("       inner join C_ST_ConsignProcessReceipt on S_SE_SB_SalesID = C_ST_CPR_Salesid ");
		buffer.append("       left join SYS_PersonInfo on C_ST_CPR_CreatePerson = id ");
		buffer.append("       left join B_Departments b on a.B_DP_RegID = b.B_DP_DepartmentID ");
		buffer.append("       left join B_Warehouse on C_ST_CPR_InStockId = B_WH_ID ");
		buffer.append("  where S_SE_SB_ValueFlag = '1' and S_SE_SB_InTransit = '5' and S_SE_SB_OrdersType = '2' and C_ST_CPR_AuditState = '1' and S_SE_SB_SalesID not in (select C_SHA_OS_DeliveryBillID from C_SHA_OutSourcingDeliveryBill)  ");
		
		if (!"".equals(Utility.getName(crpo.getCstcprcompanyid()))){
		    buffer.append(" and a.B_DP_CompanysID = ? ");
			params.add(Utility.getName(crpo.getCstcprcompanyid()));	
		}
		
		if (!"".equals(Utility.getName(crpo.getCstcprcreateperson()))){
			buffer.append(" and C_ST_CPR_CreatePerson = ? ");
			params.add(Utility.getName(crpo.getCstcprcreateperson())); 
		}
		
		if (!"".equals(Utility.getName(crpo.getCstcprdeliverystart()))){
			buffer.append(" and convert(varchar(10),C_ST_CPR_AuditDate,120) >= ? ");
			params.add(Utility.getName(crpo.getCstcprdeliverystart())); 
		}
		
		if (!"".equals(Utility.getName(crpo.getCstcprdeliveryend()))){
			buffer.append(" and convert(varchar(10),C_ST_CPR_AuditDate,120) <= ? ");
			params.add(Utility.getName(crpo.getCstcprdeliveryend())); 
		}
		
		buffer.append(" ) TEMP where 1 = 1 ");
		
		if (!"".equals(Utility.getName(crpo.getCstcprfaliaostockid()))){
			buffer.append(" and ssesbfaliaostockid = ? ");
			params.add(Utility.getName(crpo.getCstcprfaliaostockid())); 
		}
		
		buffer.append(" order by ssesbshouhuodate desc ");
		
		return queryForObjectList(buffer.toString() , params.toArray() , SalesBasicPo.class);
	}
	
	/**
	 * 委外配送修改
	 */
	public void updateNotMaterialsSalesBill(ConsignProcessReceiptPo crpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" insert into C_SHA_OutSourcingDeliveryBill (C_SHA_OS_ID,C_SHA_OS_AlloctionBillID,C_SHA_OS_DeliveryBillID) values (?,?,?) ");
		
		params.add(this.uuid.generate()); 
		params.add(Utility.getName(crpo.getCstcpralloctionbillid())); 
		params.add(Utility.getName(crpo.getCstcprsalesid())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增调拨单
	 */
	public void insertConsignProcessReceiptToAlloction(AllocationPo apo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO C_SHA_Allocation ");
		buffer.append("           (C_SHA_A_billID ");
		buffer.append("           ,C_SHA_A_billDate ");
		buffer.append("           ,C_SHA_A_outDepartmentId ");
		buffer.append("           ,C_SHA_A_outStockId ");
		buffer.append("           ,C_SHA_A_inStockId ");
		buffer.append("           ,C_SHA_A_inDepartmentId ");
		buffer.append("           ,C_SHA_A_createPerson ");
		buffer.append("           ,C_SHA_A_auditPerson ");
		buffer.append("           ,C_SHA_A_auditState ");
		buffer.append("           ,C_SHA_A_auditDate ");
		buffer.append("           ,C_SHA_A_consignState ");
		buffer.append("           ,C_SHA_A_remark ");
		buffer.append("           ,C_SHA_A_flag ");
		buffer.append("           ,C_SHA_A_AutoAllocationFlag ");
		buffer.append("           ,C_SHA_A_CategoryID) ");
		buffer.append("     VALUES (?,getdate(),?,?,?,?,?,?,'1',getdate(),'0','委外转调拨单','1','','3') ");

		params.add(Utility.getName(apo.getCshaabillid())); 
		params.add(Utility.getName(apo.getCshaaoutdepartmentid())); 
		params.add(Utility.getName(apo.getCshaaoutstockid())); 
		params.add(Utility.getName(apo.getCshaainstockid())); 
		params.add(Utility.getName(apo.getCshaaindepartmentid())); 
		params.add(Utility.getName(apo.getCshaacreateperson())); 
		params.add(Utility.getName(apo.getCshaaauditperson()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增调拨单明细
	 */
	public void insertConsignProcessReceiptToAlloctionEntry(ConsignProcessReceiptPo crpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO C_SHA_AllocationEntry ");
		buffer.append("           (C_SHA_AE_ID ");
		buffer.append("           ,C_SHA_AE_billId ");
		buffer.append("           ,C_SHA_AE_goodsId ");
		buffer.append("           ,C_SHA_AE_goodsbarcode ");
		buffer.append("           ,C_SHA_A_outStockId ");
		buffer.append("           ,C_SHA_A_inStockId ");
		buffer.append("           ,C_SHA_AE_allocationQuantity ");
		buffer.append("           ,C_SHA_AE_OutStorageFlag) ");
		
		buffer.append("select newid(),?,C_ST_CPRD_GoodsID,C_ST_CPRD_BarCode,C_ST_CPRD_InStockId,?,C_ST_CPRD_Num,'0' ");
		buffer.append("  from C_ST_ConsignProcessReceiptDetails inner join C_ST_ConsignProcessReceipt on C_ST_CPRD_ReceiptBillD = C_ST_CPR_ReceiptBillId ");
		buffer.append("  where substring(C_ST_CPRD_GoodsID,1,1) = '3' and C_ST_CPR_Salesid in ( ");
		
		params.add(Utility.getName(crpo.getCstcpralloctionbillid()));
		params.add(Utility.getName(crpo.getCstcprfaliaostockid())); 
		
		String[] billArray = Utility.getName(crpo.getCstcprsalesid()).split(",");
		for (int i = 0; i < billArray.length; i++){
			buffer.append(" ?, ");
			params.add(Utility.getName(billArray[i])); 
		}

		buffer.append(" '' ) ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
}
