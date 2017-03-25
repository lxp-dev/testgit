	package com.pengsheng.eims.storage.dao.impl;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import com.pengsheng.eims.storage.dao.OtherDatabaseManagementDao;
	import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
	import com.pengsheng.eims.storage.persistence.InventoryPo;
	import com.pengsheng.eims.storage.persistence.VerificationPo;
	import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
	
	public class OtherDatabaseManagementDaoImpl extends BaseJdbcDaoSupport
			implements OtherDatabaseManagementDao {
	
		/**
		 * 获取其它出库的po
		 */
		public InventoryPo getOtherDatabaseManagement(InventoryPo po) {
			
			StringBuffer sb = new StringBuffer();
	
			sb.append("select top 1  C_ST_I_BillID as cstibillid,");
			sb.append("C_ST_I_billDate as cstibilldate,");
			sb.append("C_ST_I_OutStockId as cstioutstockid,");
			sb.append("C_ST_I_SupplierId as cstisupplierid,");	
			sb.append("C_ST_I_DepartmentId as cstidepartmentid,");
			sb.append("C_ST_I_createPerson as csticreateperson,");
			sb.append("C_ST_I_AuditPerson as cstiauditperson,");
			sb.append("a.personName as csticreatepersonname,");
			sb.append("b.personName as cstiauditpersonname,");
			sb.append("C_ST_I_AuditState as cstiauditstate,");
			sb.append("C_ST_I_AuditDate as cstiauditdate,");
			sb.append("C_ST_I_Remark as cstiremark,");
			sb.append("bd.B_DP_DepartmentName as cstiinstockname,");
			sb.append("wa.B_WH_warehouseName as cstioutstockname");
			
			sb.append(" from C_ST_Inventory ");		
			sb.append("inner join B_Warehouse wa on C_ST_Inventory.C_ST_I_OutStockId=wa.B_WH_ID ");
			sb.append("inner join B_Departments bd on C_ST_I_SupplierId=bd.B_DP_DepartmentID ");
			sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
			sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");
	
			sb.append("where C_ST_I_BillID=?");
	
			List<String> params = new ArrayList<String>();
	
			params.add(po.getCstibillid());
	
			return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
					InventoryPo.class);
		}
	
		/**
		 * 获取其它出库的数量
		 */
		public int getOtherDatabaseManagementCount(InventoryPo po) {
			
			StringBuffer sb = new StringBuffer();
			sb.append("select count(C_ST_Inventory.C_ST_I_BillID)");
			sb.append(" from C_ST_Inventory ");
			sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
			sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
			sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
			sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID");
	
			List<String> params = new ArrayList<String>();
	
			sb.append(" where 1=1 and C_ST_I_BillTypeId='8'");//8、其他出库 OTO
			
			if (!"".equals(Utility.getName(po.getCsticompanyid()))){
			    sb.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCsticompanyid()));	
			}
			
			if (!"".equals(Utility.getName(po.getCstibillid()))) {
				sb.append("and C_ST_I_BillID like '%'+ ?+'%' ");//quyanping
				params.add(po.getCstibillid());
			}
			if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
				sb.append("and C_ST_I_SupplierId=? ");
				params.add(po.getCstisupplierid());
			}
			if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
				sb.append("and C_ST_I_OutStockId=? ");
				params.add(po.getCstioutstockid());
			}
			if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
				sb.append("and C_ST_I_DepartmentId=? ");
				params.add(po.getCstidepartmentid());
			}
			if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
				sb.append("and C_ST_I_AuditState=? ");
				params.add(po.getCstiauditstate());
			}
			if (!"".equals(Utility.getName(po.getCstistartTime()))
					&& !"".equals(Utility.getName(po.getCstiendTime()))) {
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
				params.add(po.getCstistartTime());
				params.add(po.getCstiendTime());
			} else if (!"".equals(Utility.getName(po.getCstistartTime()))
					&& "".equals(Utility.getName(po.getCstiendTime()))) {
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
				params.add(po.getCstistartTime());
			} else if ("".equals(Utility.getName(po.getCstistartTime()))
					&& !"".equals(Utility.getName(po.getCstiendTime()))) {
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
				params.add(po.getCstiendTime());
			}
			if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
				sb.append("and C_ST_I_createPerson=? ");
				params.add(po.getCsticreateperson());
			}
			if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
				sb.append("and C_ST_I_AuditPerson=? ");
				params.add(po.getCstiauditperson());
			}
			
			if (!"".equals(Utility.getName(po.getCstiauditstartdate()))) {
				sb.append("and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
				params.add(po.getCstiauditstartdate());
			}
			if (!"".equals(Utility.getName(po.getCstiauditenddate()))) {
				sb.append("and convert(varchar(10),C_ST_I_AuditDate,120) <= ? ");
				params.add(po.getCstiauditenddate());
			}
	
			return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
		}
	
		/**
		 * 获取其它出库的list
		 */
		public List<InventoryPo> getOtherDatabaseManagementList(InventoryPo po,
				int start, int size) {
			
			StringBuffer sb = new StringBuffer();
			int countPage = start + size;
			sb.append("set rowcount " + countPage + " \n");
			sb.append("select * from(select ROW_NUMBER() ");
			sb.append("Over(order by C_ST_I_billDate desc) as rowNum,");
			sb.append("C_ST_I_BillID as cstibillid,");
			sb.append("C_ST_I_BillTypeId as cstibilltypeid,");
			sb.append("C_ST_I_billDate as cstibilldate,");
			sb.append("C_ST_I_AuditDate as cstiauditdate,");		
			sb.append("C_ST_I_AuditState as cstiauditstate,");
			sb.append("a.personName as csticreatepersonname,");
			sb.append("b.personName as cstiauditpersonname,");
			sb.append("B_Departments.B_DP_DepartmentName as cstidepartmentname,");
			sb.append("wb.B_DP_DepartmentName as cstiinstockname,");
			sb.append("wa.B_WH_warehouseName as cstioutstockname");
			
			sb.append(" from C_ST_Inventory ");
			sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
			sb.append("inner join B_Warehouse wa on C_ST_I_OutStockId=wa.B_WH_ID ");
			sb.append("inner join B_Departments wb on C_ST_I_SupplierId=wb.B_DP_DepartmentID ");
			sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
			sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID");
	
			sb.append(" where 1=1 and C_ST_I_BillTypeId='8'");//8、其他出库 OTO
	
			List<String> params = new ArrayList<String>();
			
			if (!"".equals(Utility.getName(po.getCsticompanyid()))){
			    sb.append(" and B_Departments.B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCsticompanyid()));	
			}
	
			if (!"".equals(Utility.getName(po.getCstibillid()))) {
				sb.append("and C_ST_I_BillID like '%'+ ?+'%' ");//quyanping
				params.add(po.getCstibillid());
			}
			if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
				sb.append("and C_ST_I_SupplierId=? ");
				params.add(po.getCstisupplierid());
			}
			if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
				sb.append("and C_ST_I_OutStockId=? ");
				params.add(po.getCstioutstockid());
			}
			if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
				sb.append("and C_ST_I_DepartmentId=? ");
				params.add(po.getCstidepartmentid());
			}
			if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
				sb.append("and C_ST_I_AuditState=? ");
				params.add(po.getCstiauditstate());
			}
			if (!"".equals(Utility.getName(po.getCstistartTime()))
					&& !"".equals(Utility.getName(po.getCstiendTime()))) {
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
				params.add(po.getCstistartTime());
				params.add(po.getCstiendTime());
			} else if (!"".equals(Utility.getName(po.getCstistartTime()))
					&& "".equals(Utility.getName(po.getCstiendTime()))) {
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
				params.add(po.getCstistartTime());
			} else if ("".equals(Utility.getName(po.getCstistartTime()))
					&& !"".equals(Utility.getName(po.getCstiendTime()))) {
				sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
				params.add(po.getCstiendTime());
			}
			if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
				sb.append("and C_ST_I_createPerson=? ");
				params.add(po.getCsticreateperson());
			}
			if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
				sb.append("and C_ST_I_AuditPerson=? ");
				params.add(po.getCstiauditperson());
			}
			
			if (!"".equals(Utility.getName(po.getCstiauditstartdate()))) {
				sb.append("and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
				params.add(po.getCstiauditstartdate());
			}
			if (!"".equals(Utility.getName(po.getCstiauditenddate()))) {
				sb.append("and convert(varchar(10),C_ST_I_AuditDate,120) <= ? ");
				params.add(po.getCstiauditenddate());
			}
	
			sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
					+ (start + size));
			sb.append("set rowcount 0");
			return queryForObjectList(sb.toString(), params.toArray(),
					InventoryPo.class);
		}
		/**
		 * 获取其它出库明细表的list
		 */
		public List<InventoryEntryPo> getOtherDatabaseManagementEntryList(
				InventoryPo po) {
			
			StringBuffer sb=new StringBuffer();	
			List<String> params = new ArrayList<String>();
			
			sb.append("select ");
			sb.append("C_ST_IE_ID as cstieid,");
			sb.append("C_ST_IE_GoodsId as cstiegoodsid,");
			sb.append("B_GoodsInfo.B_GI_GoodsName as cstiegoodsname,");
			sb.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity,");
			sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");		
			sb.append("C_ST_IE_NotTaxRate as cstienottaxrate,");
			sb.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount,");
			sb.append("C_ST_IE_TaxRate as cstietaxrate,");
			sb.append("C_ST_IE_CostPrice as cstiecostprice,");
			sb.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount,");
			sb.append("C_ST_IE_TaxAmount as cstietaxamount,");		
			sb.append("C_ST_IE_OutStockId as cstieoutstockid,");
			sb.append("upper(C_ST_IE_BarCode) as cstiebarcode,");
			sb.append("C_ST_IE_WarehousingDate as cstiewarehousingdate,isnull(C_ST_IE_OutStorageFlag,'1') as cstieoutstorageflag, ");
			sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0) as cstiemaxquantity ");
			sb.append(" from C_ST_InventoryEntry ");
			sb.append("left join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
			
			sb.append(" left join ( ");
			sb.append("		SELECT GoodsId AS GoodsId,GoodsBarCode AS GoodsBarCode, ");
			sb.append("		       SUM(GoodsQuantity) AS GoodsQuantity, ");
			sb.append("		       StockId 			  AS StockId, ");
			sb.append("		       B_WH_warehouseName AS StockName ");
			sb.append("		FROM  (SELECT C_SH_SL_GoodsId       AS GoodsId, ");
			sb.append("		             C_SH_SL_GoodsBarCode as GoodsBarCode, ");
			sb.append("		              C_SH_SL_GoodsQuantity AS GoodsQuantity, ");
			sb.append("		              C_SH_SL_StockId       AS StockId ");
			sb.append("		       FROM   C_SH_StorageLog)ktemp ");
			sb.append("		       inner join B_Warehouse on ktemp.StockId = B_WH_ID ");
			if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
				sb.append(" WHERE ktemp.StockId = ? ");
				params.add(po.getCstioutstockid());
			}
			sb.append("		GROUP  BY GoodsId,GoodsBarCode,StockId,B_WH_warehouseName ");
			sb.append(" ) kucun ");
			sb.append(" on C_ST_IE_BarCode = kucun.GoodsBarCode and kucun.StockId=C_ST_IE_OutStockId ");
			sb.append(" left join ( ");
			sb.append(" select C_SH_TSE_GoodsID as GoodsId,sum(C_SH_TSE_GoodsNum) as GoodsNum from C_SH_InTransitStorageEntry ");
			sb.append(" where 1=1 ");
			if (!"".equals(Utility.getName(po.getCstibillid()))) {
				sb.append(" and C_SH_TSE_BillID <> ? ");
				params.add(po.getCstibillid());
			}
			if (!"".equals(Utility.getName(po.getCstioutstockid()))) {
				sb.append(" and C_SH_TSE_OUTStockID = ? ");
				params.add(po.getCstioutstockid());
			}
			sb.append(" group by C_SH_TSE_GoodsID)zaitu ");
			sb.append(" on B_GI_GoodsID = zaitu.GoodsId ");
			
			sb.append("where C_ST_IE_BillID= ? ");		
			params.add(po.getCstibillid());
	
			return queryForObjectList(sb.toString(), params.toArray(),
					InventoryEntryPo.class);
		}
	
	//	/**
	//	 *  新增其它出库主表
	//	 */
	//	public void insertOtherDatabaseManagement(InventoryPo po) {
	//		
	//		StringBuffer sb1 = new StringBuffer();
	//		StringBuffer sb2 = new StringBuffer();
	//		List<String> params = new ArrayList<String>();
	//		sb1.append("insert into C_ST_Inventory(");
	//		sb1.append("C_ST_I_BillID,");
	//		sb1.append("C_ST_I_BillTypeId,");
	//		sb1.append("C_ST_I_billDate,");
	//		//sb1.append("C_ST_I_SupplierId,");
	//		sb1.append("C_ST_I_InStockId,");
	//		sb1.append("C_ST_I_DepartmentId,");
	//		sb1.append("C_ST_I_createPerson,");
	//		sb1.append("C_ST_I_AuditState,");
	//		sb1.append("C_ST_I_Remark");
	//
	//		sb2.append("? , '8' , ? , ? , ? , ? , ? , ?  ");
	//		params.add(po.getCstibillid());
	//		params.add(po.getCstibilldate());
	//		//params.add(po.getCstisupplierid());
	//		params.add(po.getCstiinstockid());
	//		params.add(po.getCstidepartmentid());
	//		params.add(po.getCsticreateperson());
	//		params.add(po.getCstiauditstate());
	//		params.add(po.getCstiremark());
	//
	//		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
	//			sb1.append(",C_ST_I_AuditPerson,");
	//			sb1.append("C_ST_I_AuditDate");
	//			sb2.append(",? ,getdate() ");
	//			params.add(po.getCstiauditperson());
	//		}
	//
	//		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
	//		getJdbcTemplate().update(sql, params.toArray());
	//		
	//	}
	//
	//	/**
	//	 * 新增其它出库明细表
	//	 */
	//	public void insertOtherDatabaseManagementEntry(InventoryEntryPo po) {
	//		
	//		StringBuffer sb = new StringBuffer();
	//		List<String> params = new ArrayList<String>();
	//		sb.append("insert into C_ST_InventoryEntry(");
	//		sb.append("C_ST_IE_ID,");
	//		sb.append("C_ST_IE_BillID,");
	//		sb.append("C_ST_IE_GoodsId,");
	//		sb.append("C_ST_IE_GoodsQuantity,");
	//		sb.append("C_ST_IE_InStockId,");
	//		sb.append("C_ST_IE_NotTaxRateAmount,");
	//		sb.append("C_ST_IE_BarCode,");
	//		sb.append("C_ST_IE_WarehousingDate");
	//
	//		sb.append(") values(");
	//
	//		sb.append(" ? , ? , ? , ? , ? , ? , ?, getdate() ");
	//		sb.append(")");
	//
	//		params.add(this.uuid.generate());	
	//		params.add(po.getCstiebillid());	
	//		params.add(po.getCstiegoodsid());
	//		params.add(po.getCstiegoodsquantity());
	//		params.add(po.getCstieinstockid());
	//		params.add(po.getCstienottaxrateamount());
	//		params.add(po.getCstiebarcode());
	//
	//		getJdbcTemplate().update(sb.toString(), params.toArray());
	//		
	//		
	//	}
	
	
		/**
		 *  新增其它出库主表
		 */
		public void insertOtherDatabaseManagement(InventoryPo po) {
			
			StringBuffer sb1 = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			List<String> params = new ArrayList<String>();
			sb1.append("insert into C_ST_Inventory(");
			sb1.append("C_ST_I_BillID,");
			sb1.append("C_ST_I_BillTypeId,");
			sb1.append("C_ST_I_billDate,");
			sb1.append("C_ST_I_OutStockId,");
			sb1.append("C_ST_I_SupplierId,");
			sb1.append("C_ST_I_DepartmentId,");
			sb1.append("C_ST_I_createPerson,");
			sb1.append("C_ST_I_AuditState,");
			sb1.append("C_ST_I_Remark,");
			sb1.append("C_ST_I_InvoiceState ");
	
			sb2.append("? , '8' , getdate() , ? , ? , ? , ? , ? , ? , '0' ");
			params.add(po.getCstibillid());
			params.add(po.getCstioutstockid());
			params.add(po.getCstisupplierid());
			params.add(po.getCstidepartmentid());
			params.add(po.getCsticreateperson());
			params.add(po.getCstiauditstate());
			params.add(po.getCstiremark());
	
			if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
				sb1.append(",C_ST_I_AuditPerson,");
				sb1.append("C_ST_I_AuditDate");
				sb2.append(",? ,getdate() ");
				params.add(po.getCstiauditperson());
			}
	
			String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
			getJdbcTemplate().update(sql, params.toArray());
			
		}
	
		/**
		 * 新增其它出库明细表
		 */
		public void insertOtherDatabaseManagementEntry(InventoryEntryPo po) {
			
			StringBuffer sb = new StringBuffer();
			List<String> params = new ArrayList<String>();
			sb.append("insert into C_ST_InventoryEntry(");
			sb.append("C_ST_IE_ID,");
			sb.append("C_ST_IE_BillID,");
			sb.append("C_ST_IE_GoodsId,");
			sb.append("C_ST_IE_GoodsQuantity,");
			sb.append("C_ST_IE_NotTaxRate,");
			sb.append("C_ST_IE_TaxRate,");
			sb.append("C_ST_IE_CostPrice,");
			sb.append("C_ST_IE_OutStockId,");
			sb.append("C_ST_IE_BarCode,");
			sb.append("C_ST_IE_WarehousingDate,");
			sb.append("C_ST_IE_InvoiceState,C_ST_IE_OutStorageFlag ");
			
			sb.append(") values(");
	
			sb.append("?,?,?,?,?,?,?,?,? ,getdate() ,'0',? ");
			sb.append(")");
	
			params.add(this.uuid.generate());	
			params.add(po.getCstiebillid());	
			params.add(po.getCstiegoodsid());
			params.add(po.getCstiegoodsquantity());
			params.add(po.getCstienottaxrate());
			params.add(po.getCstietaxrate());
			params.add(po.getCstiecostprice());
			params.add(po.getCstieoutstockid());
			params.add(po.getCstiebarcode());
			params.add(Utility.getName(po.getCstieoutstorageflag()));
	
			getJdbcTemplate().update(sb.toString(), params.toArray());
			
			
		}
		
		
		
		////////////////////////原代码//////////////////////////////////
	
		/**
		 *  新增其它出库主表
		 */
	//	public void insertOtherDatabaseManagement(InventoryPo po) {
	//		
	//		StringBuffer sb1 = new StringBuffer();
	//		StringBuffer sb2 = new StringBuffer();
	//		List<String> params = new ArrayList<String>();
	//		sb1.append("insert into C_ST_Inventory(");
	//		sb1.append("C_ST_I_BillID,");
	//		sb1.append("C_ST_I_BillTypeId,");
	//		sb1.append("C_ST_I_billDate,");
	//		sb1.append("C_ST_I_SupplierId,");
	//		sb1.append("C_ST_I_InStockId,");
	//		sb1.append("C_ST_I_DepartmentId,");
	//		sb1.append("C_ST_I_createPerson,");
	//		sb1.append("C_ST_I_AuditState,");
	//		sb1.append("C_ST_I_Remark");
	//
	//		sb2.append("? , '8' , ? , ? , ? , ? , ? , ? , ? ");
	//		params.add(po.getCstibillid());
	//		params.add(po.getCstibilldate());
	//		params.add(po.getCstisupplierid());
	//		params.add(po.getCstiinstockid());
	//		params.add(po.getCstidepartmentid());
	//		params.add(po.getCsticreateperson());
	//		params.add(po.getCstiauditstate());
	//		params.add(po.getCstiremark());
	//
	//		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
	//			sb1.append(",C_ST_I_AuditPerson,");
	//			sb1.append("C_ST_I_AuditDate");
	//			sb2.append(",? ,getdate() ");
	//			params.add(po.getCstiauditperson());
	//		}
	//
	//		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
	//		getJdbcTemplate().update(sql, params.toArray());
	//		
	//	}
	//
	//	/**
	//	 * 新增其它出库明细表
	//	 */
	//	public void insertOtherDatabaseManagementEntry(InventoryEntryPo po) {
	//		
	//		StringBuffer sb = new StringBuffer();
	//		List<String> params = new ArrayList<String>();
	//		sb.append("insert into C_ST_InventoryEntry(");
	//		sb.append("C_ST_IE_ID,");
	//		sb.append("C_ST_IE_BillID,");
	//		sb.append("C_ST_IE_GoodsId,");
	//		sb.append("C_ST_IE_GoodsQuantity,");
	//		sb.append("C_ST_IE_NotTaxRate,");
	//		sb.append("C_ST_IE_TaxRate,");
	//		sb.append("C_ST_IE_CostPrice,");
	//		sb.append("C_ST_IE_InStockId,");
	//		sb.append("C_ST_IE_BarCode,");
	//		sb.append("C_ST_IE_WarehousingDate");
	//
	//		sb.append(") values(");
	//
	//		sb.append(" ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate() ");
	//		sb.append(")");
	//
	//		params.add(this.uuid.generate());	
	//		params.add(po.getCstiebillid());	
	//		params.add(po.getCstiegoodsid());
	//		params.add(po.getCstiegoodsquantity());
	//		params.add(po.getCstienottaxrate());
	//		params.add(po.getCstietaxrate());
	//		params.add(po.getCstiecostprice());
	//		params.add(po.getCstieinstockid());
	//		params.add(po.getCstiebarcode());
	//
	//		getJdbcTemplate().update(sb.toString(), params.toArray());
	//		
	//		
	//	}
		//////////////////////////////////////////////////////////
		/**
		 * 新增核销表
		 */
		public void insertVerification(VerificationPo po) {
			
			StringBuffer sb1=new StringBuffer();
			StringBuffer sb2=new StringBuffer();
			sb1.append("insert into C_ST_Verification(C_ST_V_PinID,C_ST_V_GoodsId,C_ST_V_BarCode,C_ST_V_Num,C_ST_V_Datetime,C_ST_V_UUID");
			sb2.append("?,?,?,?,getdate(),?");		
			
			List<String> params = new ArrayList<String>();
			
			params.add(po.getCstvpinid());	
			params.add(po.getCstvgoodsid());	
			params.add(po.getCstvbarcode());
			params.add(po.getCstvnum());
			params.add(this.uuid.generate());
			
			if(!"".equals(Utility.getName(po.getCstvpoid()))){
				sb1.append(",C_ST_V_PoID");
				sb2.append(",?");
				params.add(po.getCstvpoid());
			}
			String sql=sb1.toString()+")values("+sb2.toString()+")";
			getJdbcTemplate().update(sql, params.toArray());
		}
	
		/**
		 * 修改其它出库主表
		 */
		public void updateOtherDatabaseManagement(InventoryPo po) {
			
			StringBuffer sb=new StringBuffer();
			sb.append("update C_ST_Inventory set C_ST_I_SupplierId=?,C_ST_I_OutStockId=?,");
			sb.append("C_ST_I_AuditState=?,C_ST_I_Remark=? ");
			
			List<String> params = new ArrayList<String>();
			params.add(po.getCstisupplierid());	
			params.add(po.getCstioutstockid());	
			params.add(po.getCstiauditstate());	
			params.add(po.getCstiremark());	
			
			if(!"".equals(Utility.getName(po.getCstiauditperson()))){
				sb.append(",C_ST_I_AuditPerson=?,C_ST_I_AuditDate=getdate(),C_ST_I_FinanceAuditState='0'");
				params.add(po.getCstiauditperson());	
			}
			sb.append(" where C_ST_Inventory.C_ST_I_BillID=?");
			
			params.add(po.getCstibillid());	
			
			getJdbcTemplate().update(sb.toString(), params.toArray());
			
		}
	
		/**
		 * 删除其它出库主表
		 */
		public void deleteOtherDatabaseManagement(InventoryPo po) {
			
	        String sql="delete from C_ST_Inventory where C_ST_I_BillID=? ";		
			
			List<String> params = new ArrayList<String>();
			params.add(po.getCstibillid());	
			
			getJdbcTemplate().update(sql, params.toArray());
	       
		}
	
		/**
		 * 删除其它出库明细表
		 */
		public void deleteOtherDatabaseManagementEntry(InventoryPo po) {
			
			List<String> params = new ArrayList<String>();
			String sql = "delete from C_ST_InventoryEntry where C_ST_IE_BillID= ? ";
			params.add(po.getCstibillid());
			getJdbcTemplate().update(sql, params.toArray());
		}
	
		/**
		 * 删除核销表
		 */
		public void deleteVerification(InventoryPo po) {
			
			    String sql="delete from C_ST_Verification where C_ST_V_PinID=?";	
				
				List<String> params = new ArrayList<String>();
				params.add(po.getCstibillid());	
				
				getJdbcTemplate().update(sql, params.toArray());	
		}
		
		/**
		 *  新增其他出库在途库存
		 */
		public void insertOtherOutInTransitStorage(InventoryPo po){
			
			StringBuffer sb = new StringBuffer();
			List<String> params = new ArrayList<String>();
			
			sb.append("INSERT INTO C_SH_InTransitStorageEntry(C_SH_TSE_ID,C_SH_TSE_DepartmentType,C_SH_TSE_ModuleID,C_SH_TSE_EntryID ");
			sb.append("           ,C_SH_TSE_BillID,C_SH_TSE_GoodsID,C_SH_TSE_GoodsBarCode,C_SH_TSE_GoodsNum,C_SH_TSE_InStockID,C_SH_TSE_OutStockID,C_SH_TSE_InOrOutStock) ");
			
			sb.append("select newid() as a1,C_ST_I_SupplierId as a2,'qtck' as a3,C_ST_IE_ID as a4,C_ST_IE_BillID as a5,C_ST_IE_GoodsId as a6, ");
			sb.append("       isnull(C_ST_IE_BarCode,'') as a7,-isnull(C_ST_IE_GoodsQuantity,0) as a8,'' as a9,C_ST_IE_OutStockId as a10,'2' as a11 ");
			sb.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
			sb.append("  where C_ST_I_BillTypeId='8' and isnull(C_ST_I_AuditState,'')<>'1' and C_ST_IE_BillID=?  ");
			
			params.add(Utility.getName(po.getCstibillid()));
					
			getJdbcTemplate().update(sb.toString(),params.toArray());
		}
	
	}
