package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ReturnMerchandiseManagementDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ReturnMerchandiseManagementDaoImpl extends BaseJdbcDaoSupport
		implements ReturnMerchandiseManagementDao {

	/**
	 * 获取采购商品退货的po
	 */
	public InventoryPo getReturnMerchandiseManagement(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_InStockId as cstiinstockid,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_I_SupplierId as cstisupplierid,");
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,");
		sb.append("C_ST_I_createPerson as csticreateperson,");
		sb.append("C_ST_I_AuditPerson as cstiauditperson,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("C_ST_I_Remark as cstiremark");

		sb.append(" from C_ST_Inventory ");
		sb
				.append("inner join B_Supplier on C_ST_Inventory.C_ST_I_SupplierId=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");

		sb.append("where C_ST_I_BillID=?");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstibillid());

		return (InventoryPo) queryForObject(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 获取采购商品退货的数量
	 */
	public int getReturnMerchandiseManagementCount(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select count(C_ST_Inventory.C_ST_I_BillID)");
		sb.append(" from C_ST_Inventory ");
		sb
				.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb
				.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID");

		List<String> params = new ArrayList<String>();

		sb.append(" where 1=1 and C_ST_I_BillTypeId='2'");
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_I_BillID= ? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
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

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取采购商品退货的list
	 */
	public List<InventoryPo> getReturnMerchandiseManagementList(InventoryPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from(select ROW_NUMBER() ");
		sb
				.append("Over(order by C_ST_I_BillID desc,C_ST_I_billDate desc) as rowNum,");
		sb.append("C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("B_SP_SupplierName as bspsuppliername,");
		sb.append("B_DP_DepartmentName as cstidepartmentname");

		sb.append(" from C_ST_Inventory ");
		sb
				.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on C_ST_I_SupplierId=B_SP_ID ");
		sb
				.append("inner join B_Warehouse on C_ST_I_InStockId=B_Warehouse.B_WH_ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		sb
				.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID");

		sb.append(" where 1=1 and C_ST_I_BillTypeId='2'");// 2、采购退货单 POUT

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_I_BillID= ? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
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

		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 新增采购商品退货主表
	 */
	public void insertReturnMerchandiseManagement(InventoryPo po) {

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb1.append("insert into C_ST_Inventory(");
		sb1.append("C_ST_I_BillID,");
		sb1.append("C_ST_I_BillTypeId,");
		sb1.append("C_ST_I_billDate,");
		sb1.append("C_ST_I_SupplierId,");
		sb1.append("C_ST_I_InStockId,");
		sb1.append("C_ST_I_DepartmentId,");
		sb1.append("C_ST_I_createPerson,");
		sb1.append("C_ST_I_AuditState,");
		sb1.append("C_ST_I_Remark");

		sb2.append("? , '2' , ? , ? , ? , ? , ? , ? , ? ");
		params.add(po.getCstibillid());
		params.add(po.getCstibilldate());
		params.add(po.getCstisupplierid());
		params.add(po.getCstiinstockid());
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
		// StringBuffer sb1 = new StringBuffer();
		// StringBuffer sb2 = new StringBuffer();
		// List<String> params = new ArrayList<String>();
		// sb1.append("insert into C_ST_Inventory(");
		// sb1.append("C_ST_I_BillID,");
		// sb1.append("C_ST_I_BillTypeId,");
		// sb1.append("C_ST_I_billDate,");
		// sb1.append("C_ST_I_SupplierId,");
		// sb1.append("C_ST_I_InStockId,");
		// sb1.append("C_ST_I_DepartmentId,");
		// sb1.append("C_ST_I_createPerson,");
		// sb1.append("C_ST_I_AuditState,");
		// sb1.append("C_ST_I_Remark");
		//
		// sb2.append("? , '2' , ? , ? , ? , ? , ? , ? , ? ");
		// params.add(po.getCstibillid());
		// params.add(po.getCstibilldate());
		// params.add(po.getCstisupplierid());
		// params.add(po.getCstiinstockid());
		// params.add(po.getCstidepartmentid());
		// params.add(po.getCsticreateperson());
		// params.add(po.getCstiauditstate());
		// params.add(po.getCstiremark());
		//
		// if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
		// sb1.append(",C_ST_I_AuditPerson,");
		// sb1.append("C_ST_I_AuditDate");
		// sb2.append(",? ,getdate() ");
		// params.add(po.getCstiauditperson());
		// }
		//
		// String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		// getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 新增采购商品退货明细表
	 */
	public void insertReturnMerchandiseManagementEntry(InventoryEntryPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into C_ST_InventoryEntry(");
		sb.append("C_ST_IE_ID,");
		sb.append("C_ST_IE_BillID,");
		sb.append("C_ST_IE_GoodsId,");
		sb.append("C_ST_IE_GoodsQuantity,");
		// sb.append("C_ST_IE_NotTaxRate,");
		// sb.append("C_ST_IE_TaxRate,");
		// sb.append("C_ST_IE_CostPrice,");
		sb.append("C_ST_IE_InStockId,");
		sb.append("C_ST_IE_BarCode,");
		sb.append("C_ST_IE_WarehousingDate");

		sb.append(") values(");

		sb.append(" ? , ? , ? , ?,?,? , getdate() ");
		sb.append(")");

		params.add(this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiegoodsquantity());
		// params.add(po.getCstienottaxrate());
		// params.add(po.getCstietaxrate());
		// params.add(po.getCstiecostprice());
		params.add(po.getCstieinstockid());
		params.add(po.getCstiebarcode());

		getJdbcTemplate().update(sb.toString(), params.toArray());

		// StringBuffer sb = new StringBuffer();
		// List<String> params = new ArrayList<String>();
		// sb.append("insert into C_ST_InventoryEntry(");
		// sb.append("C_ST_IE_ID,");
		// sb.append("C_ST_IE_BillID,");
		// sb.append("C_ST_IE_GoodsId,");
		// sb.append("C_ST_IE_GoodsQuantity,");
		// sb.append("C_ST_IE_NotTaxRate,");
		// sb.append("C_ST_IE_TaxRate,");
		// sb.append("C_ST_IE_CostPrice,");
		// sb.append("C_ST_IE_InStockId,");
		// sb.append("C_ST_IE_BarCode,");
		// sb.append("C_ST_IE_WarehousingDate");
		//
		// sb.append(") values(");
		//
		// sb.append(" ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate() ");
		// sb.append(")");
		//
		// params.add(this.uuid.generate());
		// params.add(po.getCstiebillid());
		// params.add(po.getCstiegoodsid());
		// params.add(po.getCstiegoodsquantity());
		// params.add(po.getCstienottaxrate());
		// params.add(po.getCstietaxrate());
		// params.add(po.getCstiecostprice());
		// params.add(po.getCstieinstockid());
		// params.add(po.getCstiepcbarcode());
		//
		// getJdbcTemplate().update(sb.toString(), params.toArray());

	}

	/**
	 * 得到业务信息明细表中的采购商品退货信息
	 */
	public List<InventoryEntryPo> getReturnMerchandiseManagementEntryList(
			InventoryPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("select C_ST_IE_ID as cstieid,");
		sb.append("C_ST_IE_GoodsId as cstiegoodsid,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");
		sb.append("C_ST_IE_GoodsQuantity as cstiegoodsquantity,");
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");
		sb.append("C_ST_IE_NotTaxRate as cstienottaxrate,");
		sb.append("C_ST_IE_NotTaxRateAmount as cstienottaxrateamount,");
		sb.append("C_ST_IE_TaxRate as cstietaxrate,");
		sb.append("C_ST_IE_CostPrice as cstiecostprice,");
		sb.append("C_ST_IE_CostPriceAmount as cstiecostpriceamount,");
		sb.append("C_ST_IE_TaxAmount as cstietaxamount,");
		sb.append("C_ST_IE_InStockId as cstieinstockid,");
		sb.append("C_ST_IE_BarCode as cstiebarcode,");
		sb.append("C_ST_IE_WarehousingDate as cstiewarehousingdate");

		sb.append(" from C_ST_InventoryEntry ");
		sb
				.append("inner join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");

		sb.append("where C_ST_IE_BillID=? ");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstibillid());

		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryEntryPo.class);

	}

	/**
	 * 删除商品退货主表
	 */
	public void deleteReturnMerchandiseManagement(InventoryPo po) {

		String sql = "delete from C_ST_Inventory where C_ST_I_BillID=? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 删除商品退货明细表
	 */
	public void deleteReturnMerchandiseManagementEntry(InventoryPo po) {

		List<String> params = new ArrayList<String>();
		String sql = "delete from C_ST_InventoryEntry where C_ST_IE_BillID= ? ";
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 删除核销表
	 */
	public void deleteVerification(InventoryPo po) {

		String sql = "delete from C_ST_Verification where C_ST_V_PinID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getCstibillid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 新增核销表
	 */
	public void insertVerification(VerificationPo po) {

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1
				.append("insert into C_ST_Verification(C_ST_V_PinID,C_ST_V_GoodsId,C_ST_V_BarCode,C_ST_V_Num,C_ST_V_Datetime,C_ST_V_UUID");
		sb2.append("?,?,?,?,getdate(),?");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstvpinid());
		params.add(po.getCstvgoodsid());
		params.add(po.getCstvbarcode());
		params.add(po.getCstvnum());
		params.add(this.uuid.generate());

		if (!"".equals(Utility.getName(po.getCstvpoid()))) {
			sb1.append(",C_ST_V_PoID");
			sb2.append(",?");
			params.add(po.getCstvpoid());
		}
		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 修改商品退货主表
	 */
	public void updateReturnMerchandiseManagement(InventoryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_Inventory set C_ST_I_InStockId=?,");
		sb.append("C_ST_I_AuditState=?,C_ST_I_Remark=? ");

		List<String> params = new ArrayList<String>();

		params.add(po.getCstiinstockid());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());

		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb
					.append(",C_ST_I_AuditPerson=?,C_ST_I_AuditDate=getdate(),C_ST_I_FinanceAuditState='0'");
			params.add(po.getCstiauditperson());
		}
		sb.append(" where C_ST_Inventory.C_ST_I_BillID=?");

		params.add(po.getCstibillid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}
	
	public void returnimportOrders(String poID) {
		String sql = "exec SP_ReturnimportOrders ? ";

		getJdbcTemplate().update(sql, new String[] { poID });
	}

}
