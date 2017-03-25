package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.dao.OveragelossesDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OveragelossesDaoImpl extends BaseJdbcDaoSupport implements
		OveragelossesDao {

	public int getOveragelossesCount(InventoryPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(C_ST_I_BillID) from C_ST_Inventory left join B_Departments on B_DP_DepartmentID = C_ST_I_DepartmentId ");
		buffer.append("where 1 = 1 ");

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		// 单据编号
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))) {
			if(Utility.getName(po.getCstigoodscategory()).equals("no")){//不限定类型，字段值为空
				buffer.append("and (C_ST_I_GoodsCategory = '' or C_ST_I_GoodsCategory is null ) ");//quyanping				
			}else{
				buffer.append("and C_ST_I_GoodsCategory = ? ");//quyanping
				params.add(po.getCstigoodscategory());
			}
		}

		// 单据源编号
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			buffer.append("and C_ST_I_SourceBillId like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstisourcebillid());
		}

		// 单据类型 5：盘盈 6：盘亏
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			buffer.append("and C_ST_I_BillTypeId= ? ");
			params.add(po.getCstibilltypeid());
		} else {
			buffer.append("and C_ST_I_BillTypeId IN (5,6) ");
		}
		// 出入库仓位
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			buffer.append("and ? IN (C_ST_I_InStockId , C_ST_I_OutStockId) ");
			params.add(po.getCstiinstockid());
		}

		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			buffer.append("and C_ST_I_AuditState = ? ");
			params.add(po.getCstiauditstate());
		}

		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());

		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());

		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstiendTime());
		}

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			buffer.append("and C_ST_I_AuditPerson = ? ");
			params.add(po.getCstiauditperson());
		}

		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			buffer.append("and C_ST_I_createPerson = ? ");
			params.add(po.getCsticreateperson());
		}
		
		// 非总仓库房类型的部门，只能穿本部门下仓位的单据
		if (po.getCstistocklist() != null) {
			
			buffer.append(" and ( 1 <> 1 ");
			
			for (WarehousePo wpo : po.getCstistocklist()){
				buffer.append(" or ? IN (C_ST_I_InStockId , C_ST_I_OutStockId) ");
				params.add(Utility.getName(wpo.getBwhid()));
			}
			
			buffer.append(" ) ");
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	public List<InventoryPo> getOveragelossesList(InventoryPo po, int start,
			int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over(order by C_ST_I_billDate desc,C_ST_I_BillID desc) as rowNum,C_ST_I_BillID as cstibillid,C_ST_I_SourceBillId as cstisourcebillid,C_ST_I_BillTypeId as cstibilltypeid,");
		buffer.append("C_ST_I_billDate as cstibilldate,C_ST_I_AuditDate as cstiauditdate,InWarehouse.B_WH_warehouseName as cstiinstockname,OutWarehouse.B_WH_warehouseName as cstioutstockname,");
		buffer.append("C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname,C_ST_I_GoodsCategory as cstigoodscategory,B_GC_GoodsCategoryName as cstigoodscategoryname from C_ST_Inventory ");
		buffer.append("left join B_Warehouse InWarehouse on C_ST_I_InStockId=InWarehouse.B_WH_ID ");
		buffer.append("left join B_Warehouse OutWarehouse on C_ST_I_OutStockId=OutWarehouse.B_WH_ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID ");
		buffer.append("left join B_GoodsCategory on B_GC_ID=C_ST_I_GoodsCategory left join B_Departments on B_DP_DepartmentID = C_ST_I_DepartmentId ");
		buffer.append("where 1 = 1 ");

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		// 单据编号
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			buffer.append("and C_ST_I_BillID  like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstibillid());
		}
		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))) {
			if(Utility.getName(po.getCstigoodscategory()).equals("no")){//不限定类型，字段值为空
				buffer.append("and (C_ST_I_GoodsCategory = '' or C_ST_I_GoodsCategory is null ) ");//quyanping				
			}else{
				buffer.append("and C_ST_I_GoodsCategory = ? ");//quyanping
				params.add(po.getCstigoodscategory());
			}
		}

		// 单据源编号
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			buffer.append("and C_ST_I_SourceBillId like '%'+ ?+'%' ");//quyanping
			params.add(po.getCstisourcebillid());
		}

		// 单据类型 5：盘盈 6：盘亏
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			buffer.append("and C_ST_I_BillTypeId= ? ");
			params.add(po.getCstibilltypeid());
		} else {
			buffer.append("and C_ST_I_BillTypeId IN (5,6) ");
		}
		// 出入库仓位
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			buffer.append("and ? IN (C_ST_I_InStockId , C_ST_I_OutStockId) ");
			params.add(po.getCstiinstockid());
		}

		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			buffer.append("and C_ST_I_AuditState = ? ");
			params.add(po.getCstiauditstate());
		}

		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());

		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());

		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			buffer
					.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");

			params.add(po.getCstiendTime());
		}
		
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			buffer.append("and C_ST_I_AuditPerson = ? ");
			params.add(po.getCstiauditperson());
		}

		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			buffer.append("and C_ST_I_createPerson = ? ");
			params.add(po.getCsticreateperson());
		}
		
		// 非总仓库房类型的部门，只能穿本部门下仓位的单据
		if (po.getCstistocklist() != null) {
			
			buffer.append(" and ( 1 <> 1 ");
			
			for (WarehousePo wpo : po.getCstistocklist()){
				buffer.append(" or ? IN (C_ST_I_InStockId , C_ST_I_OutStockId) ");
				params.add(Utility.getName(wpo.getBwhid()));
			}
			
			buffer.append(" ) ");
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		return queryForObjectList(buffer.toString(), params.toArray(),
				InventoryPo.class);
	}
	
	
	/**
	 * 新增盘盈盘亏主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertOveragelosses(InventoryPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append("insert into C_ST_Inventory(C_ST_I_BillID,C_ST_I_BillTypeId,C_ST_I_billDate,C_ST_I_DepartmentId,");
		sb1.append("C_ST_I_createPerson,C_ST_I_AuditState,C_ST_I_InvoiceState,C_ST_I_Remark ");
		sb2.append("?,?,getdate(),?,?,?,0,?");
		
		List<String> params = new ArrayList<String>();
		
		params.add(po.getCstibillid());
		params.add(po.getCstibilltypeid());
		params.add(po.getCstidepartmentid());
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate ");
			sb2.append(",?,getdate()  ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",C_ST_I_SourceBillId");
			sb2.append(",?");
			params.add(po.getCstisourcebillid());
		}
		if ("5".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb1.append(",C_ST_I_InStockId");
			sb2.append(",?");
			params.add(po.getCstiinstockid());
		}
		if ("6".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb1.append(",C_ST_I_OutStockId");
			sb2.append(",?");
			params.add(po.getCstioutstockid());
		}
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))) {
			sb1.append(",C_ST_I_GoodsCategory");
			sb2.append(",?");
			params.add(Utility.getName(po.getCstigoodscategory()));
		}
		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增盘盈盘亏明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertOveragelossesEntry(InventoryEntryPo po) {

		String sql = "insert into C_ST_InventoryEntry(C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity,"
			+ "C_ST_IE_NotTaxRate,C_ST_IE_TaxRate,C_ST_IE_CostPrice,C_ST_IE_NotTaxRateAmount,"
			+ "C_ST_IE_InStockId,C_ST_IE_OutStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_Ie_InvoiceState ) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,getdate(),0)";

		List<String> params = new ArrayList<String>();

		params.add(this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiegoodsquantity());
		params.add(po.getCstienottaxrate());
		params.add(po.getCstietaxrate());
		params.add(po.getCstiecostprice());
		params.add(po.getCstienottaxrateamount());
		params.add(po.getCstieinstockid());
		params.add(po.getCstieoutstockid());
		params.add(po.getCstiepcbarcode());


		getJdbcTemplate().update(sql, params.toArray());

	}

	public void updateOveragelosses(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE C_ST_Inventory ");
		buffer.append("SET ");

		List<String> params = new ArrayList<String>();

		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			buffer.append("C_ST_I_AuditPerson = ? ");
			buffer.append(",C_ST_I_AuditState = 1 ");
			buffer.append(",C_ST_I_AuditDate = GETDATE() ");
			params.add(inventoryPo.getCstiauditperson());
		} else {
			buffer.append("C_ST_I_AuditPerson = null ");
			buffer.append(",C_ST_I_AuditState = 0 ");
			buffer.append(",C_ST_I_AuditDate = null ");
		}

		buffer.append("WHERE C_ST_I_BillID = ? ");
		params.add(inventoryPo.getCstibillid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateCheckStorage(String billid, String type) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		buffer.append("UPDATE C_SH_CheckStorage ");
		buffer.append("SET ");

		if (type.matches("^0$")) {
			buffer.append("C_SH_CS_Overage = 0 ");
		} else if (type.matches("^1$")) {
			buffer.append("C_SH_CS_Losses = 0 ");
		}

		buffer.append("WHERE C_SH_CS_BillId = ? ");
		params.add(billid);

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}

	public void deleteOveragelosses(InventoryPo po) {
		String sql = "delete from C_ST_Inventory where C_ST_I_BillID = ?";

		getJdbcTemplate().update(sql, new String[] { po.getCstibillid() });
	}

	public void deleteOveragelossesEntry(InventoryPo po) {
		String sql = "delete from C_ST_InventoryEntry where C_ST_IE_BillID= ? ";
		getJdbcTemplate().update(sql, new String[] { po.getCstibillid() });
	}

	public InventoryPo getOveragelosses(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select top 1  C_ST_I_BillID as cstibillid,C_ST_I_BillTypeId as cstibilltypeid");
		sb.append(",C_ST_I_SourceBillId as cstisourcebillid,C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_InStockId as cstiinstockid,instock.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_I_outStockId as cstioutstockid,outstock.B_WH_warehouseName as cstioutstockname,");
		sb.append("B_DP_DepartmentName as cstidepartmentname, ");
		sb.append("C_ST_I_GoodsCategory as cstigoodscategory,C_ST_I_SupplierId as cstisupplierid,C_ST_I_PurchseWayId as cstipurchsewayid,C_ST_I_DayLimit as cstidaylimit,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,C_ST_I_createPerson as csticreateperson,C_ST_I_AuditPerson as cstiauditperson,a.personName as csticreatepersonname,b.personName as cstiauditpersonname,C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,C_ST_I_Remark as cstiremark,C_ST_I_GoodsCategory as cstigoodscategory, ");
		sb.append("B_GC_GoodsCategoryName as cstigoodscategoryname ");
		sb.append("from C_ST_Inventory ");
		sb.append("left join B_Warehouse instock on C_ST_Inventory.C_ST_I_InStockId=instock.B_WH_ID ");
		sb.append("left join B_Warehouse outstock on C_ST_Inventory.C_ST_I_outStockId=outstock.B_WH_ID ");
		sb.append("left join B_GoodsCategory on C_ST_I_GoodsCategory = B_GC_ID ");
		sb.append("inner join B_Departments ON C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");
		sb.append("where C_ST_I_BillID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	public List<InventoryEntryPo> getOveragelossesEntryList(InventoryPo po,
			int start, int size) {

		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by C_ST_IE_GoodsId ) as 'rowNum', ");
		buffer.append(" C_ST_IE_BillID as cstiebillid ");
		buffer.append(", C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", C_ST_IE_NotTaxRate as cstienottaxrate ");
		buffer.append(", C_ST_IE_NotTaxRateAmount as cstienottaxrateamount ");
		buffer.append(", C_ST_IE_BarCode as cstiebarcode ");
		buffer.append(", C_ST_IE_WarehousingDate as cstiewarehousingdate ");
		buffer.append(", C_ST_IE_Remark as cstieremark");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append("FROM C_ST_InventoryEntry  ");
		buffer.append("INNER JOIN  ");
		buffer.append("B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID ");
		buffer.append("INNER JOIN ");
		buffer.append("B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID= ? ");
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				InventoryEntryPo.class);
	}

	public List<InventoryEntryPo> getOveragelossesEntrys(InventoryPo po) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("select ");
		buffer.append(" C_ST_IE_BillID as cstiebillid ");
		buffer.append(", C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", C_ST_IE_NotTaxRate as cstienottaxrate ");
		buffer.append(", C_ST_IE_NotTaxRateAmount as cstienottaxrateamount ");
		buffer.append(", C_ST_IE_BarCode as cstiebarcode ");
		buffer.append(", C_ST_IE_WarehousingDate as cstiewarehousingdate ");
		buffer.append(", C_ST_IE_Remark as cstieremark");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append(", C_ST_IE_CostPrice as cstiecostprice ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append(", C_ST_IE_InStockId as cstieinstockid ");
		buffer.append(", C_ST_IE_OutStockId as cstieoutstockid ");
		buffer.append("FROM C_ST_InventoryEntry  ");
		buffer.append("INNER JOIN  ");
		buffer.append("B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID ");
		buffer.append("INNER JOIN ");
		buffer.append("B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				InventoryEntryPo.class);
	}

	public int getOveragelossesEntryCount(InventoryPo inventoryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT count(C_ST_IE_BillID) ");
		buffer.append("FROM C_ST_InventoryEntry  ");
		buffer.append("WHERE C_ST_IE_BillID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());

		return this.getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}
	
	public int getOveragelossesEntryFactCount(InventoryPo po) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(cstiegoodsid) from ( ");
		buffer.append(" select cstiegoodsid as cstiegoodsid ");
		buffer.append(", sum(cstiegoodsquantity) as cstiegoodsquantity ");
		buffer.append(", cstienottaxrate as cstienottaxrate ");
		buffer.append(", sum(cstienottaxrateamount) as cstienottaxrateamount ");
		buffer.append(", cstiegoodsname as cstiegoodsname ");
		buffer.append(", cstiespec as cstiespec ");
		buffer.append(", cstieunitname as cstieunitname from ( ");		
		buffer.append(" select C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", isnull(C_ST_IE_AverageNotTaxRate,0) as cstienottaxrate ");
		buffer.append(", isnull(C_ST_IE_AverageNotTaxRateAmount,0) as cstienottaxrateamount ");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append("FROM C_ST_InventoryEntry left JOIN B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID left JOIN B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID = ? ");
		buffer.append(" union all ");
		buffer.append(" select C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", -C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", isnull(C_ST_IE_AverageNotTaxRate,0) as cstienottaxrate ");
		buffer.append(", -isnull(C_ST_IE_AverageNotTaxRateAmount,0) as cstienottaxrateamount ");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append("FROM C_ST_InventoryEntry left JOIN B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID left JOIN B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID = (select top 1 C_ST_I_BillID from C_ST_Inventory where C_ST_I_SourceBillId = (select sid from (select top 1 C_ST_I_SourceBillId as sid from C_ST_Inventory where C_ST_I_BillID = ? )t) and C_ST_I_BillTypeId = ? ) ");
		buffer.append(" )t group by cstiegoodsid,cstienottaxrate,cstiegoodsname,cstiespec,cstieunitname having sum(cstiegoodsquantity) > 0 ");
		buffer.append(" )t ");
		
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibilltypeid()).equals("5") ? "6" : "5");

		return this.getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	public List<InventoryEntryPo> getOveragelossesEntryFactList(InventoryPo po,int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by cstiegoodsid ) as 'rowNum',* from ( ");		
		buffer.append(" select cstiegoodsid as cstiegoodsid ");
		buffer.append(", sum(cstiegoodsquantity) as cstiegoodsquantity ");
		buffer.append(", cstienottaxrate as cstienottaxrate ");
		buffer.append(", sum(cstienottaxrateamount) as cstienottaxrateamount ");
		buffer.append(", cstiegoodsname as cstiegoodsname ");
		buffer.append(", cstiespec as cstiespec ");
		buffer.append(", cstieunitname as cstieunitname from ( ");		
		buffer.append(" select C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", isnull(C_ST_IE_AverageNotTaxRate,0) as cstienottaxrate ");
		buffer.append(", isnull(C_ST_IE_AverageNotTaxRateAmount,0) as cstienottaxrateamount ");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append("FROM C_ST_InventoryEntry left JOIN B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID left JOIN B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID = ? ");
		buffer.append(" union all ");
		buffer.append(" select C_ST_IE_GoodsId as cstiegoodsid ");
		buffer.append(", -C_ST_IE_GoodsQuantity as cstiegoodsquantity ");
		buffer.append(", isnull(C_ST_IE_AverageNotTaxRate,0) as cstienottaxrate ");
		buffer.append(", -isnull(C_ST_IE_AverageNotTaxRateAmount,0) as cstienottaxrateamount ");
		buffer.append(", B_GI_ViewGoodsName as cstiegoodsname ");
		buffer.append(", B_GI_Spec as cstiespec ");
		buffer.append(", B_UT_unitName as cstieunitname ");
		buffer.append("FROM C_ST_InventoryEntry left JOIN B_GoodsInfo ON C_ST_IE_GoodsId = B_GI_GoodsID left JOIN B_Unit ON B_GI_UnitId = B_UT_id ");
		buffer.append("where C_ST_IE_BillID = (select top 1 C_ST_I_BillID from C_ST_Inventory where C_ST_I_SourceBillId = (select sid from (select top 1 C_ST_I_SourceBillId as sid from C_ST_Inventory where C_ST_I_BillID = ? )t) and C_ST_I_BillTypeId = ? ) ");
		buffer.append(" )t group by cstiegoodsid,cstienottaxrate,cstiegoodsname,cstiespec,cstieunitname having sum(cstiegoodsquantity) > 0 ");
		buffer.append(" ) table1 ) table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
	
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibilltypeid()).equals("5") ? "6" : "5");

		return queryForObjectList(buffer.toString(), params.toArray(),InventoryEntryPo.class);
	}

}
