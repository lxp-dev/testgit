package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.OtherOutDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OtherOutDaoImpl extends BaseJdbcDaoSupport implements OtherOutDao {

	/**
	 * 得到其他出库总数
	 */
	public int getOtherOutCount(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();
		List<String> params=new ArrayList<String>();

		sb.append("select count(C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
	
		sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");

		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where 1=1 and C_ST_I_BillTypeId='8'");
		if(!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("and C_ST_I_BillID= ? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId= ? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstioutstockid()))){
			sb.append("and C_ST_I_OutStockId= ? ");
			params.add(po.getCstioutstockid());
		}
		if(!"".equals(Utility.getName(po.getCstidepartmentid()))){
			sb.append("and C_ST_I_DepartmentId= ? ");
			params.add(po.getCstidepartmentid());
		}		
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
			sb.append("and C_ST_I_AuditState= ? ");
			params.add(po.getCstiauditstate());
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}	
		if(!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("and C_ST_I_createPerson= ? ");
			params.add(po.getCsticreateperson());
		}
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("and C_ST_I_AuditPerson= ? ");
			params.add(po.getCstiauditperson());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString() , params.toArray());
	}
	
	/**
	 * 得到其他出库信息
	 */
	public List<InventoryPo> getOtherOutList(InventoryPo po, int start, int size) {
		StringBuffer sb=new StringBuffer();
		List<String> params=new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from(select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_I_BillID desc,C_ST_I_billDate desc) as rowNum,");
		sb.append("C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("B_DP_DepartmentName as cstidepartmentname");
		
		sb.append(" from C_ST_Inventory ");
		sb.append("inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");
		sb.append("inner join B_Warehouse on C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_I_AuditPerson=b.ID");
		
		sb.append(" where 1=1 and C_ST_I_BillTypeId='8'");
		if(!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("and C_ST_I_BillID= ? ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_I_SupplierId= ? ");
			params.add(po.getCstisupplierid());
		}
		if(!"".equals(Utility.getName(po.getCstioutstockid()))){
			sb.append("and C_ST_I_OutStockId= ? ");
			params.add(po.getCstioutstockid());
		}
		if(!"".equals(Utility.getName(po.getCstidepartmentid()))){
			sb.append("and C_ST_I_DepartmentId= ? ");
			params.add(po.getCstidepartmentid());
		}		
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
			sb.append("and C_ST_I_AuditState= ? ");
			params.add(po.getCstiauditstate());
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}	
		if(!"".equals(Utility.getName(po.getCsticreateperson()))){
			sb.append("and C_ST_I_createPerson= ? ");
			params.add(po.getCsticreateperson());
		}
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append("and C_ST_I_AuditPerson= ? ");
			params.add(po.getCstiauditperson());
		}	
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), InventoryPo.class);
	}
	
	/**
	 * 业务表中插入其他出库信息
	 */
	public void insertOtherOut(InventoryPo po) {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		List<String> params=new ArrayList<String>();
		sb1.append("insert into C_ST_Inventory(");
		sb1.append("C_ST_I_BillID,");
		sb1.append("C_ST_I_BillTypeId,");
		sb1.append("C_ST_I_billDate,");
		sb1.append("C_ST_I_OutStockId,");
		sb1.append("C_ST_I_DepartmentId,");
		sb1.append("C_ST_I_createPerson,");
		sb1.append("C_ST_I_AuditState,");
		sb1.append("C_ST_I_Remark,");
		sb1.append("C_ST_I_GoodsCategory");
		
		sb2.append("? , 8 , ? , ? , ? , ? , ? , ? , ? ");
		
		params.add(po.getCstibillid());
		params.add(po.getCstibilldate());
		params.add(po.getCstioutstockid());
		params.add(po.getCstidepartmentid());
		params.add(po.getCsticreateperson());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		params.add(po.getCstigoodscategory());
		
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb1.append(",C_ST_I_AuditPerson,C_ST_I_AuditDate");
			sb2.append(", ? , getdate() ");
			params.add(po.getCstiauditperson());
		}
		
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql , params.toArray());
		
	}
	
	/**
	 * 业务明细表中添加其他出库信息
	 */
	public void insertOtherOutEntry(InventoryEntryPo po) {
		List<String> params=new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
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
		sb.append("C_ST_IE_WarehousingDate,C_ST_IE_OutStorageFlag");
		
		sb.append(") values(");
		
		sb.append("? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , getdate(),? ");
		
		sb.append(" ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getCstiebillid());
		params.add(po.getCstiegoodsid());
		params.add(po.getCstiegoodsquantity());
		params.add(po.getCstienottaxrate());
		params.add(po.getCstienottaxrateamount());
		params.add(po.getCstietaxrate());
		params.add(po.getCstiecostprice());
		params.add(po.getCstiecostpriceamount());
		params.add(po.getCstietaxamount());
		params.add(po.getCstieoutstockid());
		params.add(po.getCstiebarcode());
		params.add(Utility.getName(po.getCstieoutstorageflag()));
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
		
	}
	
	/**
	 * 删除其他出库信息
	 */
	public void deleteOtherOut(InventoryPo po) {
		List<String> params=new ArrayList<String>();
		String sql="delete from C_ST_Inventory where C_ST_I_BillID= ? ";	
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql , params.toArray());	
		
	}
	/**
	 * 删除其他出库详细信息
	 */
	public void deleteOtherOutEntry(InventoryPo po) {
		List<String> params=new ArrayList<String>();
		String sql="delete from C_ST_InventoryEntry where C_ST_IE_BillID= ? ";	
		params.add(po.getCstibillid());
		getJdbcTemplate().update(sql , params.toArray());	
		
	}
	
	/**
	 * 更新其他出库信息
	 */
	public void updateOtherOut(InventoryPo po) {
		StringBuffer sb=new StringBuffer();
		List<String> params=new ArrayList<String>();
		sb.append("update C_ST_Inventory set ");
		
		sb.append("C_ST_I_OutStockId= ? ,");
		sb.append("C_ST_I_AuditState= ? ,");
		sb.append("C_ST_I_Remark= ? ");
		params.add(po.getCstioutstockid());
		params.add(po.getCstiauditstate());
		params.add(po.getCstiremark());
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append(",C_ST_I_AuditPerson= ? ,C_ST_I_AuditDate=getdate()");
			params.add(po.getCstiauditperson());
		}
		
		sb.append(" where C_ST_Inventory.C_ST_I_BillID= ? ");
		params.add(po.getCstibillid());
		
		getJdbcTemplate().update(sb.toString() , params.toArray());
		
	}
	
	/**
	 * 得到详细中的业务表中信息信息
	 */
	public InventoryPo getOtherOut(InventoryPo po) {
		StringBuffer sb=new StringBuffer();	
		List<String> params=new ArrayList<String>();
		
		sb.append("select top 1 ");
		
		sb.append("C_ST_I_BillID as cstibillid,");
		sb.append("C_ST_I_billDate as cstibilldate,");
		sb.append("C_ST_I_OutStockId as cstioutstockid,");
		sb.append("B_Warehouse.B_WH_warehouseName as cstioutstockname,");
		sb.append("C_ST_I_DepartmentId as cstidepartmentid,");
		sb.append("B_DP_DepartmentName as cstidepartmentname , ");
		sb.append("C_ST_I_createPerson as csticreateperson,");
		sb.append("C_ST_I_AuditPerson as cstiauditperson,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("C_ST_I_AuditState as cstiauditstate,");
		sb.append("C_ST_I_AuditDate as cstiauditdate,");
		sb.append("C_ST_I_Remark as cstiremark");
		
		sb.append(" from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_OutStockId=B_Warehouse.B_WH_ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID ");
		sb.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = C_ST_Inventory.C_ST_I_DepartmentId ");
		
		sb.append("where C_ST_I_BillID= ? ");
		
		params.add(po.getCstibillid());
		
		return (InventoryPo)queryForObject(sb.toString(), params.toArray(), InventoryPo.class);
	}
	
	/**
	 * 得到业务明细表中的详细信息
	 */
	public List<InventoryEntryPo> getOtherOutEntryList(InventoryPo po) {
		
		StringBuffer sb=new StringBuffer();	
		
		List<String> params=new ArrayList<String>();
		
		sb.append("select ");
		
		sb.append("C_ST_IE_ID as cstieid,");
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
		sb.append("C_ST_IE_OutStockId as cstieoutstockid,");
		sb.append("C_ST_IE_BarCode as cstiebarcode,");
		sb.append("C_ST_IE_WarehousingDate as cstiewarehousingdate,isnull(C_ST_IE_OutStorageFlag,'1') as cstieoutstorageflag ");
		
		sb.append(" from C_ST_InventoryEntry ");
		sb.append("inner join B_GoodsInfo on C_ST_InventoryEntry.C_ST_IE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		
		sb.append("where C_ST_IE_BillID= ? ");	
		
		params.add(po.getCstibillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), InventoryEntryPo.class);
	}
}
