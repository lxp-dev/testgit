package com.pengsheng.eims.quartz.dao.impl;

import java.util.List;

import com.pengsheng.eims.quartz.dao.DeliverSalesOutDao;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DeliverSalesOutDaoImpl extends BaseJdbcDaoSupport implements
		DeliverSalesOutDao {

	public List<InventoryEntryPo> getDeliverEntryList() {
		
		StringBuffer sb=new StringBuffer();	
		//送货主单 C_ST_D_flag=0 or C_ST_D_flag=NULL C_ST_D_AuditState='1'、送货单明细表、GOODS表、委外收货明细表C_ST_DE_GlassesBillId=C_ST_CPRD_ReceiptBillD
		sb.append("select C_ST_D_DeliverBillId as cstiebillid,B_GI_GoodsID as cstiegoodsid,C_ST_DE_Num as cstiegoodsquantity,");
		sb.append("B_GI_NotTaxRate as cstienottaxrate,B_GI_NotTaxRate*C_ST_DE_Num as cstienottaxrateamount,");
		sb.append("B_GI_TaxRate as cstietaxrate,B_GI_NotTaxRate*(B_GI_TaxRate+100)/100 as cstiecostprice,");
		sb.append("B_GI_NotTaxRate*(B_GI_TaxRate+100)/100*C_ST_DE_Num as cstiecostpriceamount,");
		sb.append("B_GI_NotTaxRate*B_GI_TaxRate*C_ST_DE_Num/100 as cstietaxamount,");
		sb.append("B_GI_GoodsBarCode+'00000000' as cstiebarcode,C_ST_D_AuditDate as cstiewarehousingdate ");
		sb.append("from C_ST_Deliver ");
		sb.append("inner join C_ST_DeliverEntry on C_ST_D_DeliverBillId = C_ST_DE_DeliverBillId ");
		sb.append("inner join B_GoodsInfo on B_GI_GoodsID = C_ST_DE_GoodsID ");
		sb.append("where (C_ST_D_flag=0 or C_ST_D_flag is NULL) and C_ST_D_AuditState='1' ");
//		sb.append("group by C_ST_D_DeliverBillId,B_GI_GoodsID,B_GI_CostPrice,B_GI_TaxRate,B_GI_GoodsBarCode,C_ST_D_AuditDate ");
		//System.out.println(sb.toString());
		return queryForObjectList(sb.toString(), null, InventoryEntryPo.class);
	}

	public void insertDeliverSalesOut(InventoryPo po) {
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
		sb2.append("'河南眼科委外生成销售出库单'");
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate");
			sb2.append(",'" + po.getCstiauditperson() + "',getdate()");
		}

		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		//System.out.println(sql);
		getJdbcTemplate().update(sql);

	}

	public void insertDeliverSalesOutEntry(InventoryEntryPo po) {

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

	public void updateDeliverFlag() {
		StringBuffer sb = new StringBuffer();
		sb.append("update C_ST_Deliver set C_ST_D_flag='1' where (C_ST_D_flag='0' or  C_ST_D_flag is NULL) and C_ST_D_AuditState='1' ");

		getJdbcTemplate().update(sb.toString());
	}
}
