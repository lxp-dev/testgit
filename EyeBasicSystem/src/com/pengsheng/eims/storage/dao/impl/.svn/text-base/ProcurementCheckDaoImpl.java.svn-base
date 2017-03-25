package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ProcurementCheckDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementCheckPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProcurementCheckDaoImpl extends BaseJdbcDaoSupport implements ProcurementCheckDao{
	//查询采购收货商品信息
	public List<ProcurementCheckPo> getProcurementCheckReceiptList(ProcurementCheckPo procurementCheckPo) {
		StringBuffer  varname1 = new StringBuffer();
		
		varname1.append("SELECT TEMP.C_ST_I_billDate         AS cstpoeinstockdate, ");
		varname1.append("       TEMP.B_SP_SupplierName 		 AS cstpoesuppliername, ");
		varname1.append("       TEMP.C_ST_I_SupplierId       AS cstpoesupplierid, ");
		varname1.append("       TEMP.C_ST_IE_BillID          AS cstpoebillsource, ");
		varname1.append("       TEMP.C_ST_IE_GoodsId         AS cstpoegoodsid, ");
		varname1.append("       TEMP.B_GI_Sph				 AS cstpoesph, ");
		varname1.append("       TEMP.B_GI_ViewGoodsName          AS cstpoegoodsname, ");
		varname1.append("       isnull(C_ST_PE_OrderNumber,0) AS cstpoeordergoodsquantity, ");
		varname1.append("       isnull(TEMP.C_ST_IE_GoodsQuantity,0) AS cstpoegoodsquantity, ");
		varname1.append("       TEMP.B_WH_warehouseName      AS cstpoeinstockname, ");
		varname1.append("       TEMP.C_ST_I_InStockId        AS cstpoeinstockid, ");
		varname1.append("       TEMP.B_GI_Sph + CASE ");
		varname1.append("                         WHEN TEMP.B_GI_Cyl = '0.00' THEN '+0.00' ");
		varname1.append("                         WHEN TEMP.B_GI_Cyl != '0.00' THEN TEMP.B_GI_Cyl ");
		varname1.append("                       END          AS cstpoebluminosity ");
		varname1.append("FROM   (SELECT C_ST_I_billDate, ");
		varname1.append("               C_ST_IE_BillID, ");
		varname1.append("               C_ST_I_InStockId, ");
		varname1.append("               B_WH_warehouseName, ");
		varname1.append("               C_ST_IE_GoodsId, ");
		varname1.append("               B_GI_Sph, ");
		varname1.append("               B_GI_Cyl, ");
		varname1.append("               C_ST_I_SupplierId, ");
		varname1.append("               B_SP_SupplierName, ");
		varname1.append("               C_ST_I_SourceBillId, ");
		varname1.append("               B_GI_ViewGoodsName, ");
		varname1.append("               C_ST_IE_GoodsQuantity ");
		varname1.append("        FROM   C_ST_InventoryEntry ");
		varname1.append("               INNER JOIN B_GoodsInfo ");
		varname1.append("                 ON C_ST_IE_GoodsId = B_GoodsInfo.B_GI_GoodsID ");
		varname1.append("               INNER JOIN C_ST_Inventory ");
		varname1.append("                 ON C_ST_I_BillID = C_ST_IE_BillID ");
		varname1.append("               INNER JOIN B_Warehouse ");
		varname1.append("                 ON C_ST_I_InStockId = B_WH_ID ");
		varname1.append("       		LEFT JOIN B_Supplier ");
		varname1.append("         		  ON C_ST_I_SupplierId = B_SP_ID ");
		varname1.append("        WHERE  C_ST_IE_BillID = ?) TEMP ");
		varname1.append("       LEFT JOIN C_st_po ");
		varname1.append("         ON TEMP.C_ST_I_SourceBillId = C_ST_P_ID ");
		varname1.append("       LEFT JOIN C_ST_PoEntry ");
		varname1.append("         ON TEMP.C_ST_I_SourceBillId = C_ST_PE_PurchaseOrderID  and TEMP.C_ST_IE_GoodsId = C_ST_PE_goodsID ");
		
		List<String> params = new ArrayList<String>();
		params.add(procurementCheckPo.getCstpoebillsource());

		return queryForObjectList(varname1.toString(), params.toArray(),ProcurementCheckPo.class);
	}
	
	public int getProcurementCheckReceiptGlassCount(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' and C_ST_I_AuditState='1' and C_ST_I_BillID not in( select C_ST_PC_BillSource from C_ST_ProcurementCheck ) ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		//if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId='1' ");
		//	params.add(po.getCstibilltypeid());
		//}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory='3' ");

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementCheckGlassReceiptList(InventoryPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.cstibillid as cstibillid,temp.cstisuppliername as cstisuppliername,temp.cstisourcebillid as cstisourcebillid,temp.cstibilltypeid as cstibilltypeid,");
		sb.append("temp.cstibilldate as cstibilldate,temp.cstiauditdate as cstiauditdate,temp.cstiinstockname as cstiinstockname,");
		sb.append("temp.cstiauditstate as cstiauditstate,temp.csticreatepersonname as csticreatepersonname,temp.cstiauditpersonname as cstiauditpersonname,cshastatusdepartmentid as cshastatusdepartmentid ");
		sb.append("from(select ROW_NUMBER() Over(order by C_ST_Inventory.C_ST_I_billDate desc,C_ST_Inventory.C_ST_I_BillID desc) as rowNum,C_ST_Inventory.C_ST_I_BillID as cstibillid,C_ST_Inventory.C_ST_I_SourceBillId as cstisourcebillid,C_ST_Inventory.C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_Inventory.C_ST_I_billDate as cstibilldate,C_ST_Inventory.C_ST_I_AuditDate as cstiauditdate,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");
		sb.append("C_SHA_StatusDepartmentID as cshastatusdepartmentid,");
		sb.append("C_ST_Inventory.C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("inner join B_Supplier on B_Supplier.B_SP_ID=C_ST_Inventory.C_ST_I_SupplierId ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join C_SHA_Status on C_SHA_StatusReceiptID=C_ST_Inventory.C_ST_I_BillID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' and C_ST_I_AuditState='1' and C_ST_I_BillID not in( select C_ST_PC_BillSource from C_ST_ProcurementCheck ) ");
		

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory='3' ");
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	
	public int getProcurementCheckReceiptCount(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' and C_ST_I_AuditState='1' and C_ST_I_BillID not in( select C_ST_PC_BillSource from C_ST_ProcurementCheck ) ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		//if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId='1' ");
		//	params.add(po.getCstibilltypeid());
		//}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory <> '3' ");
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory <> '4' ");

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementCheckReceiptList(InventoryPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.cstibillid as cstibillid,temp.cstisuppliername as cstisuppliername,temp.cstisourcebillid as cstisourcebillid,temp.cstibilltypeid as cstibilltypeid,");
		sb.append("temp.cstibilldate as cstibilldate,temp.cstiauditdate as cstiauditdate,temp.cstiinstockname as cstiinstockname,");
		sb.append("temp.cstiauditstate as cstiauditstate,temp.csticreatepersonname as csticreatepersonname,temp.cstiauditpersonname as cstiauditpersonname,cshastatusdepartmentid as cshastatusdepartmentid ");
		sb.append("from(select ROW_NUMBER() Over(order by C_ST_Inventory.C_ST_I_billDate desc,C_ST_Inventory.C_ST_I_BillID desc) as rowNum,C_ST_Inventory.C_ST_I_BillID as cstibillid,C_ST_Inventory.C_ST_I_SourceBillId as cstisourcebillid,C_ST_Inventory.C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_Inventory.C_ST_I_billDate as cstibilldate,C_ST_Inventory.C_ST_I_AuditDate as cstiauditdate,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");
		sb.append("C_SHA_StatusDepartmentID as cshastatusdepartmentid,");
		sb.append("C_ST_Inventory.C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb.append("inner join B_Supplier on B_Supplier.B_SP_ID=C_ST_Inventory.C_ST_I_SupplierId ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join C_SHA_Status on C_SHA_StatusReceiptID=C_ST_Inventory.C_ST_I_BillID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' and C_ST_I_AuditState='1' and C_ST_I_BillID not in( select C_ST_PC_BillSource from C_ST_ProcurementCheck )  ");
		

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory <> '3' ");
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory <> '4' ");
		sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory <> '5' ");
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),InventoryPo.class);
	}
	
	public void insertProcurementCheck(ProcurementCheckPo po) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		varname1.append("INSERT INTO C_ST_ProcurementCheck ");
		varname1.append("            (C_ST_PC_BillID, ");
		varname1.append("             C_ST_PC_SupplierID, ");
		varname1.append("             C_ST_PC_BillType, ");
		varname1.append("             C_ST_PC_BillSource, ");
		varname1.append("             C_ST_PC_BillDate, ");
		varname1.append("             C_ST_PC_Checker, ");
		varname1.append("             C_ST_PC_InStockId, ");
		varname1.append("             C_ST_PC_OrderGoodsQuantity, ");
		varname1.append("             C_ST_PC_GoodsQuantity) ");
		varname1.append("VALUES      ( ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("      getdate(), ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ? ) ");
		
		params.add(Utility.getName(po.getCstpoebillid()));
		params.add(Utility.getName(po.getCstpoesupplierid()));
		params.add(Utility.getName(po.getCstpoebilltype()));
		params.add(Utility.getName(po.getCstpoebillsource()));
		params.add(Utility.getName(po.getCstpoechecker()));
		params.add(Utility.getName(po.getCstpoeinstockid()));
		params.add(Utility.getName(po.getCstpoeordergoodsquantity()));
		params.add(Utility.getName(po.getCstpoegoodsquantity()));
		
		getJdbcTemplate().update(varname1.toString() , params.toArray());
	}
	
	public void insertProcurementCheckEntry(ProcurementCheckPo po) {
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
 
		varname1.append("INSERT INTO C_ST_ProcurementCheckEntry ");
		varname1.append("            (C_ST_POE_UUID, ");
		varname1.append("             C_ST_POE_BillID, ");
		varname1.append("             C_ST_POE_GoodsID, ");
		varname1.append("             C_ST_POE_OrderGoodsQuantity, ");
		varname1.append("             C_ST_POE_GoodsQuantity, ");
		varname1.append("             C_ST_POE_CoincidenceRate, ");
		varname1.append("             C_ST_POE_Pack, ");
		varname1.append("             C_ST_POE_App, ");
		varname1.append("             C_ST_POE_UnqualifiedQuantity, ");
		varname1.append("             C_ST_POE_UnqualifiedRate, ");
		varname1.append("             C_ST_POE_BLuminosity, ");
		varname1.append("             C_ST_POE_SLuminosity, ");
		varname1.append("             C_ST_POE_Thickness) ");
		varname1.append("VALUES      ( ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ?, ");
		varname1.append("              ? ) ");
		
		params.add(uuid.getInstance().generate());
		params.add(Utility.getName(po.getCstpoebillid()));
		params.add(Utility.getName(po.getCstpoegoodsid()));
		params.add(Utility.getName(po.getCstpoeordergoodsquantity()));
		params.add(Utility.getName(po.getCstpoegoodsquantity()));
		params.add(Utility.getName(po.getCstpoecoincidencerate()));
		params.add(Utility.getName(po.getCstpoepack()));
		params.add(Utility.getName(po.getCstpoeapp()));
		params.add(Utility.getName(po.getCstpoeunqualifiedquantity()));
		params.add(Utility.getName(po.getCstpoeunqualifiedrate()));
		params.add(Utility.getName(po.getCstpoebluminosity()));
		params.add(Utility.getName(po.getCstpoesluminosity()));
		params.add(Utility.getName(po.getCstpoethickness()));
		
		
		getJdbcTemplate().update(varname1.toString() , params.toArray());
	}
	
	
	public int getProcurementCheckCount(ProcurementCheckPo po) {
		List<String> params = new ArrayList<String>();

		StringBuffer  varname1 = new StringBuffer();
		varname1.append("SELECT COUNT(distinct C_ST_PC_BillID) ");
		varname1.append("FROM   C_ST_ProcurementCheck inner join C_ST_ProcurementCheckEntry on C_ST_PC_BillID=C_ST_POE_BillID inner join B_GoodsInfo on C_ST_POE_GoodsID=B_GI_GoodsID ");
		varname1.append("WHERE  1 = 1 ");

		if (!"".equals(Utility.getName(po.getCstpoebillid()))) {
			varname1.append("and C_ST_PC_BillID like '%' + ? + '%' ");
			params.add(po.getCstpoebillid());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoebillsource()))) {
			varname1.append("and C_ST_PC_BillSource like '%' + ? + '%' ");
			params.add(po.getCstpoebillsource());
		}

		if (!"".equals(Utility.getName(po.getCstpoebegintime()))) {
			varname1.append("and convert(varchar(10), C_ST_PC_BillDate, 23) >= ? ");
			params.add(po.getCstpoebegintime());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoeendtime()))) {
			varname1.append("and convert(varchar(10), C_ST_PC_BillDate, 23) <= ? ");
			params.add(po.getCstpoeendtime());
		} 
		
		if (!"".equals(Utility.getName(po.getCstpoesupplierid()))) {
			varname1.append("and C_ST_PC_SupplierID = ? ");
			params.add(po.getCstpoesupplierid());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoechecker()))) {
			varname1.append("and C_ST_PC_Checker = ? ");
			params.add(po.getCstpoechecker());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoebilltype()))) {
			varname1.append("and C_ST_PC_BillType = ? ");
			params.add(po.getCstpoebilltype());
		}
		if(!"".equals(Utility.getName(po.getCstpoegoodsname()))){
			varname1.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstpoegoodsname()));
		}
		
		return getJdbcTemplate().queryForInt(varname1.toString(), params.toArray());
	}
	
	/**
	 * 获取收货检验的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<ProcurementCheckPo> getProcurementCheckList(ProcurementCheckPo po,
			int start, int size) {
		
		int countPage = start + size;
		
		StringBuffer  varname1 = new StringBuffer();
		
		varname1.append("set rowcount " + countPage + " \n");
		
		varname1.append("select * from (SELECT Row_number() OVER(ORDER BY TEMP.C_ST_PC_BillDate DESC) AS rowNum,TEMP.C_ST_PC_BillID     AS cstpoebillid, ");
		varname1.append("       TEMP.C_ST_PC_SupplierID AS cstpoesupplierid, ");
		varname1.append("       TEMP.B_SP_SupplierName  AS cstpoesuppliername, ");
		varname1.append("       TEMP.C_ST_PC_BillType   AS cstpoebilltype, ");
		varname1.append("       TEMP.C_ST_PC_BillSource AS cstpoebillsource, ");
		varname1.append("       TEMP.C_ST_PC_BillDate   AS cstpoebilldate, ");
		varname1.append("       TEMP.C_ST_PC_Checker    AS cstpoechecker, ");
		varname1.append("       TEMP.personName         AS cstpoecheckername, ");
		varname1.append("       TEMP.C_ST_PC_InStockId  AS cstpoeinstockid, ");
		varname1.append("       TEMP.B_WH_warehouseName AS cstpoeinstockname ");
		varname1.append("FROM   (SELECT distinct ");
		varname1.append("               C_ST_PC_BillID, ");
		varname1.append("               C_ST_PC_SupplierID, ");
		varname1.append("               B_SP_SupplierName, ");
		varname1.append("               C_ST_PC_BillType, ");
		varname1.append("               C_ST_PC_BillSource, ");
		varname1.append("               C_ST_PC_BillDate, ");
		varname1.append("               C_ST_PC_Checker, ");
		varname1.append("               personName, ");
		varname1.append("               C_ST_PC_InStockId, ");
		varname1.append("               B_WH_warehouseName ");
		varname1.append("        FROM   C_ST_ProcurementCheck inner join C_ST_ProcurementCheckEntry on C_ST_PC_BillID=C_ST_POE_BillID inner join B_GoodsInfo on C_ST_POE_GoodsID=B_GI_GoodsID ");
		varname1.append("               INNER JOIN B_Supplier ");
		varname1.append("                 ON C_ST_PC_SupplierID = B_SP_ID ");
		varname1.append("               INNER JOIN SYS_PersonInfo ");
		varname1.append("                 ON C_ST_PC_Checker = ID ");
		varname1.append("               INNER JOIN B_Warehouse ");
		varname1.append("                 ON C_ST_PC_InStockId = B_WH_ID ");
		varname1.append("        WHERE  1 = 1 ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstpoebillid()))) {
			varname1.append("and C_ST_PC_BillID like '%' + ? + '%' ");
			params.add(po.getCstpoebillid());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoebillsource()))) {
			varname1.append("and C_ST_PC_BillSource like '%' + ? + '%' ");
			params.add(po.getCstpoebillsource());
		}

		if (!"".equals(Utility.getName(po.getCstpoebegintime()))) {
			varname1.append("and convert(varchar(10), C_ST_PC_BillDate, 23) >= ? ");
			params.add(po.getCstpoebegintime());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoeendtime()))) {
			varname1.append("and convert(varchar(10), C_ST_PC_BillDate, 23) <= ? ");
			params.add(po.getCstpoeendtime());
		} 
		
		if (!"".equals(Utility.getName(po.getCstpoesupplierid()))) {
			varname1.append("and C_ST_PC_SupplierID = ? ");
			params.add(po.getCstpoesupplierid());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoechecker()))) {
			varname1.append("and C_ST_PC_Checker = ? ");
			params.add(po.getCstpoechecker());
		}
		
		if (!"".equals(Utility.getName(po.getCstpoebilltype()))) {
			varname1.append("and C_ST_PC_BillType = ? ");
			params.add(po.getCstpoebilltype());
		}
		if(!"".equals(Utility.getName(po.getCstpoegoodsname()))){
			varname1.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCstpoegoodsname()));
		}
		
		varname1.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		varname1.append(" set rowcount 0");
		
		return queryForObjectList(varname1.toString(), params.toArray(),
				ProcurementCheckPo.class);
	}
	
	
	/**
	 * 获取收货检验的详细
	 * @param po
	 * @return
	 */
	public List<ProcurementCheckPo> getProcurementCheckDetails(ProcurementCheckPo po) {

		StringBuffer  varname1 = new StringBuffer();
		
		varname1.append(" declare @billid varchar(50) ");
		varname1.append(" select top 1 @billid = C_ST_PC_BillSource from dbo.C_ST_ProcurementCheck where C_ST_PC_BillID = ? ");
		
		varname1.append("SELECT cstpoebillid                        AS cstpoebillid, ");
		varname1.append("       cstpoesupplierid                    AS cstpoesupplierid, ");
		varname1.append("       cstpoesuppliername                  AS cstpoesuppliername, ");
		varname1.append("       cstpoebilltype                      AS cstpoebilltype, ");
		varname1.append("       cstpoebillsource                    AS cstpoebillsource, ");
		varname1.append("       cstpoebilldate                      AS cstpoebilldate, ");
		varname1.append("       cstpoecheckername                   AS cstpoecheckername, ");
		varname1.append("       cstpoechecker                       AS cstpoechecker, ");
		varname1.append("       cstpoeinstockname                   AS cstpoeinstockname, ");
		varname1.append("       cstpoeinstockid                     AS cstpoeinstockid, ");
		varname1.append("       cstpoegoodsid                       AS cstpoegoodsid, ");
		varname1.append("       cstpoegoodsname                    AS cstpoegoodsname, ");
		varname1.append("       cstpoeordergoodsquantity           AS cstpoeordergoodsquantity, ");
		varname1.append("       cstpoegoodsquantity                AS cstpoegoodsquantity, ");
		varname1.append("       cstpoecoincidencerate              AS cstpoecoincidencerate, ");
		varname1.append("       cstpoepack                         AS cstpoepack, ");
		varname1.append("       cstpoeapp                          AS cstpoeapp, ");
		varname1.append("       cstpoequalifiedquantity            AS cstpoequalifiedquantity, ");
		varname1.append("       cstpoeunqualifiedquantity          AS cstpoeunqualifiedquantity, ");
		varname1.append("       cstpoeunqualifiedrate              AS cstpoeunqualifiedrate, ");
		varname1.append("       cstpoebluminosity                  AS cstpoebluminosity, ");
		varname1.append("       cstpoesluminosity                  AS cstpoesluminosity, ");
		varname1.append("       cstpoethickness                    AS cstpoethickness ");
		varname1.append("  from ( ");
		
		varname1.append("SELECT C_ST_PC_BillID                        AS cstpoebillid, ");
		varname1.append("       C_ST_PC_SupplierID                    AS cstpoesupplierid, ");
		varname1.append("       B_SP_SupplierName                     AS cstpoesuppliername, ");
		varname1.append("       C_ST_PC_BillType                      AS cstpoebilltype, ");
		varname1.append("       C_ST_PC_BillSource                    AS cstpoebillsource, ");
		varname1.append("       C_ST_PC_BillDate                      AS cstpoebilldate, ");
		varname1.append("       personName                            AS cstpoecheckername, ");
		varname1.append("       C_ST_PC_Checker                       AS cstpoechecker, ");
		varname1.append("       B_WH_warehouseName                    AS cstpoeinstockname, ");
		varname1.append("       C_ST_PC_InStockId                     AS cstpoeinstockid, ");
		varname1.append("       C_ST_POE_GoodsID                      AS cstpoegoodsid, ");
		varname1.append("       B_GI_GoodsName                        AS cstpoegoodsname, ");
		varname1.append("       cast(C_ST_POE_OrderGoodsQuantity as varchar)           AS cstpoeordergoodsquantity, ");
		varname1.append("       cast(C_ST_POE_GoodsQuantity  as varchar)                AS cstpoegoodsquantity, ");
		varname1.append("       C_ST_POE_CoincidenceRate              AS cstpoecoincidencerate, ");
		varname1.append("       C_ST_POE_Pack                         AS cstpoepack, ");
		varname1.append("       C_ST_POE_App                          AS cstpoeapp, ");
		varname1.append("       CASE ");
		varname1.append("         WHEN Substring(C_ST_POE_GoodsID, 1, 1) = '3' THEN 1 - CAST(C_ST_POE_UnqualifiedQuantity AS INT) ");
		varname1.append("         ELSE CAST(C_ST_POE_GoodsQuantity AS INT) - CAST(C_ST_POE_UnqualifiedQuantity AS INT) ");
		varname1.append("       END                                   AS cstpoequalifiedquantity, ");
		varname1.append("       C_ST_POE_UnqualifiedQuantity          AS cstpoeunqualifiedquantity, ");
		varname1.append("       C_ST_POE_UnqualifiedRate              AS cstpoeunqualifiedrate, ");
		varname1.append("       C_ST_POE_BLuminosity                  AS cstpoebluminosity, ");
		varname1.append("       C_ST_POE_SLuminosity                  AS cstpoesluminosity, ");
		varname1.append("       C_ST_POE_Thickness                    AS cstpoethickness, ");
		varname1.append("       isnull(B_GI_Sph,'')                    AS B_GI_Sph ");
		varname1.append("FROM   dbo.C_ST_ProcurementCheckEntry ");
		varname1.append("       INNER JOIN dbo.C_ST_ProcurementCheck ");
		varname1.append("         ON C_ST_POE_BillID = C_ST_PC_BillID ");
		varname1.append("       INNER JOIN B_Supplier ");
		varname1.append("         ON C_ST_PC_SupplierID = B_SP_ID ");
		varname1.append("       INNER JOIN SYS_PersonInfo ");
		varname1.append("         ON C_ST_PC_Checker = ID ");
		varname1.append("       INNER JOIN B_Warehouse ");
		varname1.append("         ON C_ST_PC_InStockId = B_WH_ID ");
		varname1.append("       INNER JOIN dbo.B_GoodsInfo ");
		varname1.append("         ON B_GI_GoodsID = C_ST_POE_GoodsID ");		
		varname1.append(" WHERE  C_ST_PC_BillID = ?  ");
		varname1.append(" union all ");		
		varname1.append(" SELECT C_ST_IE_BillID                        AS cstpoebillid, ");
		varname1.append("       ''                    AS cstpoesupplierid, ");
		varname1.append("       ''                     AS cstpoesuppliername, ");
		varname1.append("       ''                      AS cstpoebilltype, ");
		varname1.append("       ''                    AS cstpoebillsource, ");
		varname1.append("       ''                      AS cstpoebilldate, ");
		varname1.append("       ''                            AS cstpoecheckername, ");
		varname1.append("       ''                       AS cstpoechecker, ");
		varname1.append("       ''                    AS cstpoeinstockname, ");
		varname1.append("       C_ST_IE_InStockId                     AS cstpoeinstockid, ");
		varname1.append("       C_ST_IE_GoodsId                      AS cstpoegoodsid, ");
		varname1.append("       B_GI_GoodsName                        AS cstpoegoodsname, ");
		varname1.append("       cast(t1.C_ST_PE_OrderNumber  as varchar)           AS cstpoeordergoodsquantity, ");
		varname1.append("       cast(C_ST_IE_GoodsQuantity   as varchar)               AS cstpoegoodsquantity, ");
		varname1.append("       ''              AS cstpoecoincidencerate, ");
		varname1.append("       ''                         AS cstpoepack, ");
		varname1.append("       ''                          AS cstpoeapp, ");
		varname1.append("       0                         AS cstpoequalifiedquantity, ");
		varname1.append("       0          AS cstpoeunqualifiedquantity, ");
		varname1.append("       ''              AS cstpoeunqualifiedrate, ");		
		varname1.append("       B_GI_Sph + CASE ");
		varname1.append("                         WHEN B_GI_Cyl = '0.00' THEN '+0.00' ");
		varname1.append("                         WHEN B_GI_Cyl != '0.00' THEN B_GI_Cyl ");
		varname1.append("                       END          AS cstpoebluminosity, ");		
		varname1.append("       ''                  AS cstpoesluminosity, ");
		varname1.append("       ''                    AS cstpoethickness, ");
		varname1.append("       isnull(B_GI_Sph,'')                    AS B_GI_Sph ");
		varname1.append("FROM   C_ST_InventoryEntry ");
		varname1.append("       INNER JOIN dbo.B_GoodsInfo ");
		varname1.append("         ON B_GI_GoodsID = C_ST_IE_GoodsId ");
		varname1.append("       INNER JOIN ( ");
		varname1.append("select C_ST_PE_goodsID,C_ST_PE_OrderNumber from ( ");
		varname1.append("	select C_ST_PE_goodsID,sum(C_ST_PE_OrderNumber) as C_ST_PE_OrderNumber from C_ST_PoEntry where C_ST_PE_PurchaseOrderID in ( ");
		varname1.append("		select top 1 C_SHA_StatusOrderID from dbo.C_SHA_Status ");
		varname1.append("		  where C_SHA_StatusReceiptID = @billid ");
		varname1.append("	)");
		varname1.append("	group by C_ST_PE_goodsID ");
		varname1.append(")temp )t1 on C_ST_IE_GoodsId = t1.C_ST_PE_goodsID ");		
		varname1.append("WHERE C_ST_IE_BillID = @billid and C_ST_IE_GoodsId not in (select distinct C_ST_POE_GoodsID from dbo.C_ST_ProcurementCheckEntry where C_ST_POE_BillID = ?) ");
		
		varname1.append(" ) t1 ");
		varname1.append("       left join (select ROW_NUMBER() Over(order by orderby) as rowNum,B_GI_Sph from getSphAndCylOrderBy(@billid)) a on t1.B_GI_Sph = a.B_GI_Sph ");
		varname1.append("     order by a.rowNum ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(po.getCstpoebillid()));
		params.add(Utility.getName(po.getCstpoebillid()));
		params.add(Utility.getName(po.getCstpoebillid()));
		
		return queryForObjectList(varname1.toString(), params.toArray(),ProcurementCheckPo.class);
	}
	
	/**
	 * 获取收货检验的详细
	 * @param po
	 * @return
	 */
	public ProcurementCheckPo getProcurementCheckDetailsByPin(ProcurementCheckPo po){

		StringBuffer  varname1 = new StringBuffer();
		
		varname1.append("SELECT top 1 C_ST_PC_BillID                        AS cstpoebillid, ");
		varname1.append("       C_ST_PC_SupplierID                    AS cstpoesupplierid, ");
		varname1.append("       B_SP_SupplierName                     AS cstpoesuppliername, ");
		varname1.append("       C_ST_PC_BillType                      AS cstpoebilltype, ");
		varname1.append("       C_ST_PC_BillSource                    AS cstpoebillsource, ");
		varname1.append("       C_ST_PC_BillDate                      AS cstpoebilldate, ");
		varname1.append("       personName                            AS cstpoecheckername, ");
		varname1.append("       C_ST_PC_Checker                       AS cstpoechecker, ");
		varname1.append("       B_WH_warehouseName                    AS cstpoeinstockname, ");
		varname1.append("       C_ST_PC_InStockId                     AS cstpoeinstockid, ");
		varname1.append("       C_ST_POE_GoodsID                      AS cstpoegoodsid, ");
		varname1.append("       B_GI_GoodsName                        AS cstpoegoodsname, ");
		varname1.append("       C_ST_POE_OrderGoodsQuantity           AS cstpoeordergoodsquantity, ");
		varname1.append("       C_ST_POE_GoodsQuantity                AS cstpoegoodsquantity, ");
		varname1.append("       C_ST_POE_CoincidenceRate              AS cstpoecoincidencerate, ");
		varname1.append("       C_ST_POE_Pack                         AS cstpoepack, ");
		varname1.append("       C_ST_POE_App                          AS cstpoeapp, ");
		varname1.append("       CASE ");
		varname1.append("         WHEN Substring(C_ST_POE_GoodsID, 1, 1) = '3' THEN 1 - CAST(C_ST_POE_UnqualifiedQuantity AS INT) ");
		varname1.append("         ELSE CAST(C_ST_POE_GoodsQuantity AS INT) - CAST(C_ST_POE_UnqualifiedQuantity AS INT) ");
		varname1.append("       END                                   AS cstpoequalifiedquantity, ");
		varname1.append("       C_ST_POE_UnqualifiedQuantity          AS cstpoeunqualifiedquantity, ");
		varname1.append("       C_ST_POE_UnqualifiedRate              AS cstpoeunqualifiedrate, ");
		varname1.append("       C_ST_POE_BLuminosity                  AS cstpoebluminosity, ");
		varname1.append("       C_ST_POE_SLuminosity                  AS cstpoesluminosity, ");
		varname1.append("       C_ST_POE_Thickness                    AS cstpoethickness, ");
		varname1.append("       isnull(B_GI_Sph,'')                    AS B_GI_Sph ");
		varname1.append("FROM   dbo.C_ST_ProcurementCheckEntry ");
		varname1.append("       INNER JOIN C_ST_ProcurementCheck ");
		varname1.append("         ON C_ST_POE_BillID = C_ST_PC_BillID ");
		varname1.append("       INNER JOIN B_Supplier ");
		varname1.append("         ON C_ST_PC_SupplierID = B_SP_ID ");
		varname1.append("       INNER JOIN SYS_PersonInfo ");
		varname1.append("         ON C_ST_PC_Checker = ID ");
		varname1.append("       INNER JOIN B_Warehouse ");
		varname1.append("         ON C_ST_PC_InStockId = B_WH_ID ");
		varname1.append("       INNER JOIN dbo.B_GoodsInfo ");
		varname1.append("         ON B_GI_GoodsID = C_ST_POE_GoodsID ");		
		varname1.append(" WHERE  C_ST_PC_BillID = ? ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(Utility.getName(po.getCstpoebillid()));
		
		return (ProcurementCheckPo)queryForObject(varname1.toString(),  params.toArray(), ProcurementCheckPo.class);
	
	}
	
}
