package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.quartz.dao.ConsignProcessDao;
import com.pengsheng.eims.quartz.dao.DeliverSalesOutsDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ConsignProcessDaoImpl extends BaseJdbcDaoSupport implements ConsignProcessDao {

	public List<InventoryEntryPo> getConsignProcessEntryList() {
		
		StringBuffer sb=new StringBuffer();	
		//委外订单 C_ST_D_AuditState='1'
		 sb.append("select C_ST_CPR_ReceiptBillId as cstiereceiptbillid , C_ST_CPR_SourceBillId as cstiebillid,B_GI_GoodsID as cstiegoodsid,C_ST_CPRD_Num as cstiegoodsquantity,"); 
		 sb.append("B_GI_NotTaxRate as cstienottaxrate,B_GI_NotTaxRate*C_ST_CPRD_Num as cstienottaxrateamount,"); 
		 sb.append("C_ST_CPRD_TaxRate as cstietaxrate,C_ST_CPRD_NotTaxRate*(C_ST_CPRD_TaxRate+100)/100 as cstiecostprice,"); 
		 sb.append("C_ST_CPRD_NotTaxRate*(C_ST_CPRD_TaxRate+100)/100*C_ST_CPRD_Num as cstiecostpriceamount,"); 
		 sb.append("B_GI_NotTaxRate*B_GI_TaxRate*C_ST_CPRD_Num/100 as cstietaxamount,"); 
		 sb.append("C_ST_CPRD_BarCode as cstiebarcode,C_ST_CPR_AuditState as cstiewarehousingdate ");    
		 sb.append("from C_ST_ConsignProcessReceipt ");   
		 sb.append("inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId = C_ST_CPRD_ReceiptBillD ");  
		 sb.append("inner join C_ST_ConsignProcessOrderDetails on C_ST_CPOD_Id = C_ST_CPRD_OrderDetailsID "); 
		 sb.append("inner join B_GoodsInfo on B_GI_GoodsID = C_ST_CPRD_GoodsID ");  
		 sb.append("where (C_ST_CPR_State='0' or  C_ST_CPR_State is NULL) and C_ST_CPR_AuditState='1'  and C_ST_CPOD_GlassesBillID like 'R%' "); 
//		sb.append("group by C_ST_D_DeliverBillId,B_GI_GoodsID,B_GI_CostPrice,B_GI_TaxRate,B_GI_GoodsBarCode,C_ST_D_AuditDate ");
		//System.out.println(sb.toString());
		return queryForObjectList(sb.toString(), null, InventoryEntryPo.class);
	}

	public void insertConsignProcess(InventoryPo po) {
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
		sb2.append("'2',");
		sb2.append(" getDate() ,");
		sb2.append("'" + po.getCstisupplierid() + "',");
		sb2.append("'" + po.getCstioutstockid() + "',");
		sb2.append("'" + po.getCstidepartmentid() + "',");
		sb2.append("'" + po.getCsticreateperson() + "',");
		sb2.append("'" + po.getCstiauditstate() + "',");
		sb2.append("'" + po.getCstifinanceauditstate() + "',");
		sb2.append("'报残委外生成退货 单'");
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate");
			sb2.append(",'" + po.getCstiauditperson() + "',getdate()");
		}

		String sql = sb1.toString() + ")values(" + sb2.toString() + ")";
		//System.out.println(sql);
		getJdbcTemplate().update(sql);

	}

	public void insertConsignProcessEntry(InventoryEntryPo po) {

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

	//王磊05-29
	public void updateConsignProcessReceipt(String receiptbillid) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("update C_ST_ConsignProcessReceipt set C_ST_CPR_State ='1' ");
		sb.append("where (C_ST_CPR_State='0' or  C_ST_CPR_State is NULL) ");
		sb.append("and C_ST_CPR_ReceiptBillId = ? ");
		
		params.add(receiptbillid);
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
}
