package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.dao.InvisibleDistributionDao;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class InvisibleDistributionDaoImpl extends BaseJdbcDaoSupport implements
		InvisibleDistributionDao {

	/**
	 * 获取门店
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("B_DP_DepartmentID as bwhdeptid, ");
		buffer.append("B_DP_DepartmentName as bdpdepartmentname ");
		buffer.append("from B_Departments ");
		buffer.append("where B_DP_Type='1' ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		 
		buffer.append(" order by B_DP_DepartmentID ");
		 
		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}

	/**
	 * 查询隐形订做片配送
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_Location as ssesblocation, ");
		buffer.append("B_DP_DepartmentName as ssesbtakeshopname, ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, ");
		buffer.append("convert(varchar(10), S_SE_SB_TakeGlassData, 120) as ssesbtakeglassdata, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_Location = B_Departments.B_DP_DepartmentID  ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		buffer.append("where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit = '5' ");
		buffer.append("and S_SE_SB_OrdersType = '4'  ");
		buffer.append("and  S_SE_SB_Location = ? ");

		params.add(po.getSsesblocation());		
		if (!"".equals(Utility.getName(po.getSsesbtakeglassstartdata()))){
			buffer.append("and convert(varchar(10),S_SE_SB_TakeGlassData,120) >= ? ");
			params.add(Utility.getName(po.getSsesbtakeglassstartdata()));
		}
		if (!"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10),S_SE_SB_TakeGlassData,120) <= ? ");
			params.add(Utility.getName(po.getSsesbtakeglassenddata()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesdatestarttime()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
			params.add(Utility.getName(po.getSsesbsalesdatestarttime()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
			params.add(Utility.getName(po.getSsesbsalesdateendtime()));
		}
		if (!"".equals(Utility.getName(po.getSsesbMemberId()))){
			buffer.append("and S_ME_CI_MemberId = ? ");
			params.add(Utility.getName(po.getSsesbMemberId()));
		}
		if (!"".equals(Utility.getName(po.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSsesbpersonName()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSsesbsalesid()));
		}
		buffer.append("order by S_SE_SB_TakeGlassData desc ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}

	/**
	 * 修改隐形订做片配送在途状态
	 */
	public void updateSalesBasicPos(SalesBasicPo salesBasicPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("update S_SE_SalesBasic set  ");
		buffer.append("S_SE_SB_InTransit='11' ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	/**
	 * 判断是否已经插入过
	 * @param distributionPo
	 * @return
	 */
	public DistributionPo isInsertDistribution(DistributionPo distributionPo) {				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT S_DN_DN_ID as sdndnid ");
		buffer.append("FROM   S_DN_Distribution ");
		buffer.append("Where S_DN_DN_ID = ? ");
		
		params.add(Utility.getName(distributionPo.getSdndnid()));
		
		return (DistributionPo) queryForObject(buffer.toString(), params.toArray(), DistributionPo.class);
	}

	/**
	 * 新增配送记录主表
	 */
	public String insertDistribution(DistributionPo distributionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_Distribution( ");
		buffer.append("S_DN_DN_ID, ");
		buffer.append("S_DN_DN_Person, ");
		buffer.append("S_DN_DN_CreateDate, ");
		buffer.append("S_DN_DN_Type,S_DN_DN_LogonPerson,S_DN_DN_DepartmentID )  ");
		buffer.append("values(?,?,getdate(),?,?,?) ");
		List<String> params = new ArrayList<String>();
		params.add(distributionPo.getSdndnid());
		params.add(distributionPo.getSdndnPerson());
		params.add(distributionPo.getSdndntype());
		params.add(Utility.getName(distributionPo.getSdndnlogonperson()));
		params.add(Utility.getName(distributionPo.getSdndndepartmentid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		return params.get(0);

	}

	/**
	 * 新增配送记录明细表
	 */
	public void insertDistributionEntry(DistributionPo distributionPo,
			DistributionEntryPo distributionEntryPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_DistributionEntry ( ");
		buffer.append("S_DN_DE_ID, ");
		buffer.append("S_DN_DE_DistributionID, ");
		buffer.append("S_DN_DE_SalesID, ");
		buffer.append("S_DN_DE_OrdersType ) ");
		
		buffer.append("select ?,?,?,S_SE_SB_OrdersType from S_SE_SalesBasic where S_SE_SB_SalesID=?");
		
		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(distributionEntryPo.getSdndedistributionid());
		params.add(distributionEntryPo.getSdndesalesid());
		params.add(distributionEntryPo.getSdndesalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	/**
	 * 新增在途查询明细表
	 */
	public void insertInTransit(InTransitPo inTransitPo) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into S_SE_InTransit ");
		buffer.append("(S_SE_IT_ID,    ");
		buffer.append("S_SE_IT_SalesID, ");
		buffer.append("S_SE_IT_State,  ");
		buffer.append("S_SE_IT_Date,   ");
		buffer.append("S_SE_IT_CreatePerson,");
		buffer.append("S_SE_IT_Department)  ");
		buffer.append("values (?,?,'11',getdate(),?,?) ");
		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	public void summaryAllocation(AllocationPo allocationPo) {

 		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO [C_SHA_Allocation] ");
		buffer.append("           ([C_SHA_A_billID] ");
		buffer.append("           ,[C_SHA_A_billDate] ");
		buffer.append("           ,[C_SHA_A_outDepartmentId] ");
		buffer.append("           ,[C_SHA_A_outStockId] ");
		buffer.append("           ,[C_SHA_A_inStockId] ");
		buffer.append("           ,[C_SHA_A_inDepartmentId] ");
		buffer.append("           ,[C_SHA_A_createPerson] ");
		buffer.append("           ,[C_SHA_A_auditPerson] ");
		buffer.append("           ,[C_SHA_A_auditState] ");
		buffer.append("           ,[C_SHA_A_auditDate] ");
		buffer.append("           ,[C_SHA_A_consignee] ");
		buffer.append("           ,[C_SHA_A_consignState] ");
		buffer.append("           ,[C_SHA_A_consignDate] ");
		buffer.append("           ,[C_SHA_A_remark] ");
		buffer.append("           ,[C_SHA_A_flag] ");
		buffer.append("           ,[C_SHA_A_supplier] ");
		buffer.append("           ,[C_SHA_A_StatusBillID] ");
		buffer.append("           ,[C_SHA_A_AllocationStatus] ");
		buffer.append("           ,[C_SHA_A_ReturnStatus] ");
		buffer.append("           ,[C_SHA_A_SalesOutStatus]) VALUES (?, getdate(), ?, ?, ?, ?, ");
		buffer.append("?, ?, 1, getdate(), null, 0, null, '隐形订做转调拨单', 1,null,null,0,0,0 ) ");

		List<String> params = new ArrayList<String>();

		params.add(allocationPo.getCshaabillid());
		params.add(allocationPo.getCshaaoutdepartmentid());
		params.add(allocationPo.getCshaaoutstockid());
		params.add(allocationPo.getCshaainstockid());
		
		params.add(allocationPo.getCshaaindepartmentid());
		params.add(allocationPo.getCshaacreateperson());
		params.add(allocationPo.getCshaaauditperson());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void summaryAllocationEntry(AllocationPo allocationPo,
			String... salesIDs) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_SHA_AllocationEntry(C_SHA_AE_ID,C_SHA_AE_billId,C_SHA_AE_goodsId,C_SHA_AE_goodsbarcode,C_SHA_A_outStockId,C_SHA_A_inStockId,C_SHA_AE_requirementQuantity,C_SHA_AE_allocationQuantity) ");
		buffer.append("SELECT replace(newid(), '-', ''), ");
		buffer.append(" ? , C_ST_CPRD_GoodsID, '', ");
		buffer.append("?, ?, 0, sum(C_ST_CPOD_Num) ");
		buffer.append("FROM C_ST_ConsignProcessOrderDetails ");
		buffer.append("INNER JOIN C_ST_ConsignProcessReceiptDetails ON ");
		buffer.append("C_ST_CPOD_Id = C_ST_CPRD_OrderDetailsID ");
		buffer.append("WHERE C_ST_CPOD_GlassesBillID IN ( ");

		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());
		params.add(allocationPo.getCshaaoutstockid());
		params.add(allocationPo.getCshaainstockid());

		for (int i = 0; i < salesIDs.length; i++) {
			buffer.append(" ?");
			params.add(salesIDs[i]);

			if (i + 1 != salesIDs.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" ) ");
			}
		}
		
		buffer.append("GROUP BY C_ST_CPRD_GoodsID");

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void biilderAllcoactionBarcode(AllocationPo allocationPo,
			String... salesIDs) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_SHA_AllocationBarcode(C_SHA_B_UUID,C_SHA_B_billID,C_SHA_B_GoodsID,C_SHA_B_GoodsBarcode) ");
		buffer.append("select replace(NEWID(),'-',''),?, C_ST_CPRD_GoodsID, C_ST_CPRD_BarCode ");
		buffer.append("FROM C_ST_ConsignProcessOrderDetails INNER JOIN ");
		buffer.append("C_ST_ConsignProcessReceiptDetails ON ");
		buffer.append("C_ST_CPOD_Id = C_ST_CPRD_OrderDetailsID ");
		buffer.append("WHERE C_ST_CPOD_GlassesBillID IN ( ");

		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());

		for (int i = 0; i < salesIDs.length; i++) {
			buffer.append(" ?");
			params.add(salesIDs[i]);

			if (i + 1 != salesIDs.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" ) ");
			}
		}
		
		buffer.append("GROUP BY C_ST_CPRD_GoodsID, C_ST_CPRD_BarCode ");

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取委外收货单中隐形定制商品的条码
	 */
	public List<SalesDetailPo> getGoodsItemsByDelivery(String[] ssesbsalesid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select C_ST_CPOD_SalesID as ssesdid,C_ST_CPRD_BarCode as ssesditemid,C_ST_CPRD_InStockId as ssesdstockid, ");
		buffer.append("(SELECT ");
		buffer.append("		STUFF((SELECT  ',' + C_ST_CPRD_Guaranteeperiod from C_ST_ConsignProcessReceiptDetails crd ");
		buffer.append("		inner join C_ST_ConsignProcessOrderDetails cod on C_ST_CPOD_Id = crd.C_ST_CPRD_OrderDetailsID  ");
		buffer.append("		where cod.C_ST_CPOD_SalesID = codt.C_ST_CPOD_SalesID   ");
		buffer.append("		 FOR XML PATH('') ");
		buffer.append("		), 1, 1, '')) 		as ssesdguaranteeperiod, ");
		buffer.append("(SELECT ");
		buffer.append("		STUFF((SELECT  ',' + C_ST_CPRD_Batch from C_ST_ConsignProcessReceiptDetails crd ");
		buffer.append("		inner join C_ST_ConsignProcessOrderDetails cod on C_ST_CPOD_Id = crd.C_ST_CPRD_OrderDetailsID  ");
		buffer.append("		where cod.C_ST_CPOD_SalesID = codt.C_ST_CPOD_SalesID   ");
		buffer.append("		 FOR XML PATH('') ");
		buffer.append("		), 1, 1, '')) as ssesdbatch, ");
		buffer.append("		(SELECT ");
		buffer.append("		STUFF((SELECT  ',' + C_ST_CPRD_RegistrationNum from C_ST_ConsignProcessReceiptDetails crd ");
		buffer.append("		inner join C_ST_ConsignProcessOrderDetails cod on C_ST_CPOD_Id = crd.C_ST_CPRD_OrderDetailsID  ");
		buffer.append("		where cod.C_ST_CPOD_SalesID = codt.C_ST_CPOD_SalesID   ");
		buffer.append("		 FOR XML PATH('') ");
		buffer.append("		), 1, 1, '')) as ssesdregistrationnum  ");
		buffer.append("from C_ST_ConsignProcessOrderDetails codt ");
		buffer.append("inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPOD_Id = C_ST_CPRD_OrderDetailsID ");
		buffer.append(" where C_ST_CPOD_GlassesBillID in ( ");

		for (int i = 0; i < ssesbsalesid.length; i++) {
			buffer.append(" ?");
			params.add(ssesbsalesid[i]);

			if (i + 1 != ssesbsalesid.length) {
				buffer.append(" ,");
			} else {
				buffer.append(" ) ");
			}
		}
		buffer.append("group by ");
		buffer.append("C_ST_CPOD_SalesID, ");
		buffer.append("C_ST_CPRD_BarCode, ");
		buffer.append("C_ST_CPRD_InStockId  ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
	
	/**
	 * 更新配镜单中隐形订制片的商品条码
	 */
	public void updateGoodsItemsByDelivery(SalesDetailPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) S_SE_SalesDetail ");
		buffer.append("set ");
		buffer.append("S_SE_SD_ItemID=? ");
		buffer.append(",S_SE_SD_Guaranteeperiod=? ");
		buffer.append(",S_SE_SD_Batch=? ");
		buffer.append(",S_SE_SD_RegistrationNum=? ");
		buffer.append("where S_SE_SD_ID=? ");
			
		params.add(Utility.getName(po.getSsesditemid()));
		params.add(Utility.getName(po.getSsesdguaranteeperiod()));
		params.add(Utility.getName(po.getSsesdbatch()));
		params.add(Utility.getName(po.getSsesdregistrationnum()));
		params.add(Utility.getName(po.getSsesdid()));		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取需要隐形配送的门店
	 */
	public List<WarehousePo> getDistributionStoreList(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select B_DP_DepartmentID as bwhdeptid,B_DP_DepartmentName as bdpdepartmentname from ( ");
		buffer.append(" select distinct S_SE_SB_Location as S_SE_SB_Location from S_SE_SalesBasic where S_SE_SB_OrdersType='4' and S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='5' ");
		buffer.append(" )temp inner join B_Departments on S_SE_SB_Location=B_DP_DepartmentID where 1 = 1 ");
				
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));	
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(),WarehousePo.class);
	}

}
