package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.ProcessOutDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ProcessOutDaoImpl extends BaseJdbcDaoSupport implements
  ProcessOutDao {

	public List<InventoryEntryPo> getProcessEntryList() {
		
		StringBuffer sb=new StringBuffer();	
		
		sb.append("select C_SHA_NE_billID as cstiebillid  ");
		sb.append("		,B_GI_GoodsID as cstiegoodsid,C_SHA_NE_GoodsQuantity as cstiegoodsquantity, ");
		sb.append("		B_GI_NotTaxRate as cstienottaxrate,cast((B_GI_NotTaxRate*C_SHA_NE_GoodsQuantity) as numeric(18,2)) as cstienottaxrateamount,  ");		
		sb.append("		B_GI_TaxRate as cstietaxrate,0 as cstiecostprice,0 as cstiecostpriceamount,  ");
		sb.append("		(B_GI_NotTaxRate*B_GI_TaxRate*'1'/100) as cstietaxamount,C_SHA_NE_BarCode as cstiebarcode, ");
		sb.append("		C_SHA_N_ConsignDate as cstiewarehousingdate  ");
		sb.append("  from C_SHA_Nonconforming inner join C_SHA_NonconformingEntry on C_SHA_N_billID = C_SHA_NE_billID ");
		sb.append("       inner join B_GoodsInfo on B_GI_GoodsID = C_SHA_NE_goodsID  ");		
		sb.append("  where C_SHA_N_AuditState = '2' and convert(varchar(10),C_SHA_N_ConsignDate,23) = convert(varchar(10),getDate(),23) ");  // convert(varchar(10),getDate(),23)
		sb.append("        and C_SHA_NE_consignMode = '0' ");   // 报残		

		return queryForObjectList(sb.toString(), null, InventoryEntryPo.class);
	}

	public void insertProcessOut(InventoryPo po) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append("insert into C_ST_Inventory(");
		sb1.append("C_ST_I_BillID,");
		sb1.append("C_ST_I_BillTypeId,");
		sb1.append("C_ST_I_billDate,");
		sb1.append("C_ST_I_SupplierId,");
		sb1.append("C_ST_I_OutStockId,");
		sb1.append("C_ST_I_DepartmentId,");
		sb1.append("C_ST_I_createPerson,");
		sb1.append("C_ST_I_AuditState,");
		sb1.append("C_ST_I_FinanceAuditState,");
		sb1.append("C_ST_I_Remark");

		sb2.append("'" + po.getCstibillid() + "',");
		sb2.append("'3',");
		sb2.append(" getDate() ,");
		sb2.append("'" + po.getCstisupplierid() + "',");
		sb2.append("'" + po.getCstioutstockid() + "',");
		sb2.append("'" + po.getCstidepartmentid() + "',");
		sb2.append("'" + po.getCsticreateperson() + "',");
		sb2.append("'" + po.getCstiauditstate() + "',");
		sb2.append("'" + po.getCstifinanceauditstate() + "',");
		sb2.append("'不合格品报残转销售出库单 '");
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate");
			sb2.append(",'" + po.getCstiauditperson() + "',getdate()");
		}

		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		//System.out.println(sql);
		getJdbcTemplate().update(sql);

	}

	public void insertProcessOutEntry(InventoryEntryPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("insert into C_ST_InventoryEntry(");
		sb.append("C_ST_IE_ID,");
		sb.append("C_ST_IE_BillID,");
		sb.append("C_ST_IE_GoodsId,");
		sb.append("C_ST_IE_GoodsQuantity,");
		sb.append("C_ST_IE_NotTaxRate,");
		sb.append("C_ST_IE_NotTaxRateAmount,");
		sb.append("C_ST_IE_TaxRate,");
		sb.append("C_ST_IE_CostPrice,");
		sb.append("C_ST_IE_CostPriceAmount,");
		sb.append("C_ST_IE_TaxAmount,");
		sb.append("C_ST_IE_OutStockId,");
		sb.append("C_ST_IE_BarCode,");
		sb.append("C_ST_IE_WarehousingDate");
		sb.append(") values(");
		sb.append("'" + this.uuid.generate() + "',");
		sb.append("'" + po.getCstiebillid() + "',");
		sb.append("'" + po.getCstiegoodsid() + "',");
		sb.append("" + Integer.parseInt(po.getCstiegoodsquantity().toString()) + ",");
		sb.append("'" + po.getCstienottaxrate() + "',");
		sb.append("'" + po.getCstienottaxrateamount() + "',");
		sb.append("'" + po.getCstietaxrate() + "',");
		sb.append("'" + po.getCstiecostprice() + "',");
		sb.append("'" + po.getCstiecostpriceamount() + "',");
		sb.append("'" + po.getCstietaxamount() + "',");
		sb.append("'" + po.getCstieoutstockid() + "',");
		sb.append("'" + po.getCstiebarcode() + "',");
		sb.append("getdate())");
		getJdbcTemplate().update(sb.toString());
	}

	public void updateProcessFlag() {
		StringBuffer sb = new StringBuffer();
		//sb.append("update C_ST_Deliver set C_ST_D_flag='1' where (C_ST_D_flag='0' or  C_ST_D_flag is NULL) and C_ST_D_AuditState='1' ");

		getJdbcTemplate().update(sb.toString());
	}
	
	public List<InventoryPo> getSupplierid() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
													
		buffer.append("select distinct substring(B_GI_GoodsID,3,2) as cstisupplierid ");
		buffer.append("  from C_SHA_Nonconforming inner join C_SHA_NonconformingEntry on C_SHA_N_billID = C_SHA_NE_billID ");
		buffer.append("       inner join B_GoodsInfo on B_GI_GoodsID = C_SHA_NE_goodsID  ");		
		buffer.append("  where C_SHA_N_AuditState = '2' and convert(varchar(10),C_SHA_N_ConsignDate,23) = convert(varchar(10),getDate(),23) ");
		buffer.append("        and C_SHA_NE_consignMode = '1' ");   // 退货	

		return queryForObjectList(buffer.toString(), params.toArray(),
				InventoryPo.class);
	}

	
	public void insertInventory(String producedid, String supplierid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		
		buffer.append("insert into C_ST_Inventory (");
		buffer.append("C_ST_I_BillID,");
		buffer.append("C_ST_I_BillTypeId,");
		buffer.append("C_ST_I_SourceBillId,");
		buffer.append("C_ST_I_DeliveryID,");
		buffer.append("C_ST_I_billDate,");
		buffer.append("C_ST_I_GoodsCategory,");
		buffer.append("C_ST_I_InStockId,");
		buffer.append("C_ST_I_OutStockId,");
		buffer.append("C_ST_I_SupplierId,");
		buffer.append("C_ST_I_PurchseWayId,");
		buffer.append("C_ST_I_DayLimit,");
		buffer.append("C_ST_I_DepartmentId,");
		buffer.append("C_ST_I_createPerson,");
		buffer.append("C_ST_I_AuditPerson,");
		buffer.append("C_ST_I_AuditState,");
		buffer.append("C_ST_I_AuditDate,");
		buffer.append("C_ST_I_FinanceAuditPerson,");
		buffer.append("C_ST_I_FinanceAuditState,");
		buffer.append("C_ST_I_FinanceAuditDate,");
		buffer.append("C_ST_I_Remark,");
		buffer.append("C_ST_I_InvoiceState,");
		buffer.append("C_ST_I_VoucherType,");
		buffer.append("C_ST_I_VoucherDate");
		
		buffer.append(") values(");
		buffer.append("?, ");
		buffer.append("'2' , ");
		buffer.append("null, ");
		buffer.append("null, ");
		buffer.append("getdate() , ");
		buffer.append("null , ");
		buffer.append("null, ");
		buffer.append("'yybbhgpc' , ");
		buffer.append("? , ");
		buffer.append("null , ");
		buffer.append("null , ");
		buffer.append("'101' , ");
		buffer.append("'100' , ");
		buffer.append("null, ");
		buffer.append("0 , ");
		buffer.append("null , ");
		buffer.append("null , ");
		buffer.append("0 , ");
		buffer.append("null , ");
		buffer.append("'不合格调拨商品汇总退货单' , ");
		buffer.append("'0' , ");
		buffer.append("null , ");
		buffer.append("null )");

		params.add(producedid);
		params.add(supplierid);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}

	
	public void insertInventoryEntry(String producedid, String supplierid) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into C_ST_InventoryEntry (C_ST_IE_ID,C_ST_IE_BillID,C_ST_IE_GoodsId,C_ST_IE_GoodsQuantity,C_ST_IE_NotTaxRate,C_ST_IE_NotTaxRateAmount,C_ST_IE_TaxRate, ");
		buffer.append("C_ST_IE_CostPrice,C_ST_IE_TaxAmount,C_ST_IE_CostPriceAmount,C_ST_IE_InStockId,C_ST_IE_OutStockId,C_ST_IE_BarCode,C_ST_IE_WarehousingDate,C_ST_IE_Remark,C_ST_IE_InvoiceState,C_ST_IE_checkquantity,C_ST_IE_OutStorageFlag) ");
		
		buffer.append("select replace(newid(), '-', ''),? ");
		buffer.append(",B_GI_GoodsID as cstiegoodsid, C_SHA_NE_GoodsQuantity as cstiegoodsquantity,");
		buffer.append("B_GI_NotTaxRate,null,B_GI_TaxRate as cstietaxrate,B_GI_CostPrice, null,null , ");
		buffer.append("null ,'yybbhgpc',C_SHA_NonconformingEntry.C_SHA_NE_BarCode as cstiebarcode,");
		buffer.append("getdate(),null,0,null,0 ");
		buffer.append("  from C_SHA_Nonconforming inner join C_SHA_NonconformingEntry on C_SHA_N_billID = C_SHA_NE_billID ");
		buffer.append("       inner join B_GoodsInfo on B_GI_GoodsID = C_SHA_NE_goodsID  ");		
		buffer.append("  where C_SHA_N_AuditState = '2' and convert(varchar(10),C_SHA_N_ConsignDate,23) = convert(varchar(10),getDate(),23) ");
		buffer.append("        and C_SHA_NE_consignMode = '1' and substring(B_GI_GoodsID,3,2) = ? ");  
		
		params.add(producedid);
		params.add(supplierid);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
