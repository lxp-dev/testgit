package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.dao.StoreGoodsDao;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;

import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class StoreGoodsDaoImpl extends BaseJdbcDaoSupport  implements StoreGoodsDao
{
	public TracPo getStoreGoods(TracPo po) 
	{
		StringBuffer sb=new StringBuffer();	
		
		sb.append("select top 1 ");
		
		sb.append("M_T_BillID as cstibillid,");
		sb.append("M_T_SourceBillId as cstisourcebillid,");
		sb.append("M_T_billDate as cstibilldate,");
		sb.append("ISNULL(M_T_OutStockId,M_T_InStockId) as cstioutstockid,");
		sb.append("house.B_WH_warehouseName as cstioutstockname,");
		sb.append("M_T_SupplierId as cstisupplierid,");
		sb.append("M_T_DepartmentId as cstidepartmentid,");
		sb.append("M_T_createPerson as csticreateperson,");
		sb.append("M_T_AuditPerson as cstiauditperson,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("M_T_AuditState as cstiauditstate,");
		sb.append("M_T_AuditDate as cstiauditdate,");
		sb.append("M_T_Remark as cstiremark");
		
		sb.append(" from M_Trac ");
		sb.append("inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID ");
		
		sb.append("left join (select B_WH_ID , B_WH_warehouseName from B_Warehouse ) house ");
		sb.append("on house.B_WH_ID = Isnull(M_Trac.M_T_OutStockId, M_Trac.M_T_InStockId) ");
		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on M_Trac.M_T_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on M_Trac.M_T_AuditPerson=b.ID ");
		
		sb.append("where M_T_BillID='"+po.getCstibillid()+"'");
		
		return (TracPo)queryForObject(sb.toString(), null, TracPo.class);
	}

	public List<TracEntryPo> getStoreGoodsEntryList(TracPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();	
		sb.append("select ");
		sb.append("M_TE_ID as cstieid,");
		sb.append("M_TE_GoodsId as cstiegoodsid,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");
		sb.append("M_TE_GoodsQuantity as cstiegoodsquantity,");
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");		
		sb.append("M_TE_NotTaxRate as cstienottaxrate,");
		sb.append("M_TE_NotTaxRateAmount as cstienottaxrateamount,");
		sb.append("M_TE_TaxRate as cstietaxrate,");
		sb.append("M_TE_CostPrice as cstiecostprice,");
		sb.append("M_TE_CostPriceAmount as cstiecostpriceamount,");
		sb.append("M_TE_TaxAmount as cstietaxamount,");		
		sb.append("ISNULL(M_TE_OutStockId, M_TE_InStockId) as cstieoutstockid,");
		sb.append("B_WH_warehouseName AS cstioutstockname,");
		sb.append("B_WH_warehouseName AS cstiinstockname,");
		sb.append("M_TE_BarCode as cstiebarcode,");
		sb.append("M_TE_WarehousingDate as cstiewarehousingdate,isnull(M_TE_OutStorageFlag,'') as cstieoutstorageflag, ");
		sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0) as cstiemaxquantity, ");
		sb.append("kucun.guaranteeperiod as cstieguaranteeperiod, ");
		sb.append("kucun.batch as cstiebatch ");
		sb.append("from M_TracEntry ");
		
		sb.append("LEFT JOIN (SELECT		 C_SH_SL_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        C_SH_Sl_StockId       AS StockId, ");
		sb.append("        isnull(C_SH_SL_GuaranteePeriod,'')       AS guaranteeperiod, ");
		sb.append("        isnull(C_SH_SL_Batch,'')       AS batch ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = (select top 1 M_TE_OutStockId from M_TracEntry where M_TE_BillID = ?) ");
		params.add(po.getCstibillid());
		sb.append(" GROUP  BY C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,''), ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON M_TE_BarCode = kucun.GoodsBarCode ");
		sb.append(" LEFT JOIN (SELECT  C_SH_TSE_GoodsID as GoodsId, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append(" and C_SH_TSE_BillID <> ? ");
			params.add(po.getCstibillid());
		}
        sb.append("        AND C_SH_TSE_OUTStockID = (select top 1 M_TE_OutStockId from M_TracEntry where M_TE_BillID = ?) ");
        params.add(po.getCstibillid());
        sb.append(" GROUP  BY C_SH_TSE_GoodsID)zaitu ");
        sb.append("ON M_TE_GoodsId = zaitu.GoodsId ");
		
		sb.append("inner join B_GoodsInfo on M_TracEntry.M_TE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" LEFT JOIN B_Warehouse ON B_WH_ID = Isnull(M_TE_OutStockId, M_TE_InStockId) ");
		sb.append("where M_TE_BillID='"+po.getCstibillid()+"'");		
		
		return queryForObjectList(sb.toString(), params.toArray(), TracEntryPo.class);
	}
	
	public List<TracEntryPo> getStoreGoodsDetailList(TracPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();	
		sb.append("select ");
		sb.append("M_TE_ID as cstieid,");
		sb.append("M_TE_GoodsId as cstiegoodsid,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");
		sb.append("M_TE_GoodsQuantity as cstiegoodsquantity,");
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");		
		sb.append("M_TE_NotTaxRate as cstienottaxrate,");
		sb.append("M_TE_NotTaxRateAmount as cstienottaxrateamount,");
		sb.append("M_TE_TaxRate as cstietaxrate,");
		sb.append("M_TE_CostPrice as cstiecostprice,");
		sb.append("M_TE_CostPriceAmount as cstiecostpriceamount,");
		sb.append("M_TE_TaxAmount as cstietaxamount,");		
		sb.append("ISNULL(M_TE_OutStockId, M_TE_InStockId) as cstieoutstockid,");
		sb.append("B_WH_warehouseName AS cstioutstockname,");
		sb.append("B_WH_warehouseName AS cstiinstockname,");
		sb.append("M_TE_BarCode as cstiebarcode,");
		sb.append("M_TE_WarehousingDate as cstiewarehousingdate,isnull(M_TE_OutStorageFlag,'') as cstieoutstorageflag, ");
		sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0) as cstiemaxquantity, ");
		sb.append("kucun.guaranteeperiod as cstieguaranteeperiod, ");
		sb.append("kucun.batch as cstiebatch ");
		sb.append(" from M_TracEntry ");
		
		sb.append("LEFT JOIN (SELECT		 C_SH_SL_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        C_SH_Sl_StockId       AS StockId, ");
		sb.append("        ''       AS guaranteeperiod, ");
		sb.append("        ''      AS batch ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = (select top 1 M_TE_OutStockId from M_TracEntry where M_TE_BillID = ?) ");
		params.add(po.getCstibillid());
		sb.append(" GROUP  BY C_SH_SL_GoodsBarCode, ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON M_TE_BarCode = kucun.GoodsBarCode ");
		sb.append(" LEFT JOIN (SELECT C_SH_TSE_GoodsBarCode  AS GoodsBarCode, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
        sb.append("        AND C_SH_TSE_OUTStockID = (select top 1 M_TE_OutStockId from M_TracEntry where M_TE_BillID = ?) ");
        params.add(po.getCstibillid());
        sb.append(" GROUP  BY C_SH_TSE_GoodsBarCode)zaitu ");
        sb.append("ON M_TE_BarCode = zaitu.GoodsBarCode ");
		
		sb.append("inner join B_GoodsInfo on M_TracEntry.M_TE_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" LEFT JOIN B_Warehouse ON B_WH_ID = Isnull(M_TE_OutStockId, M_TE_InStockId) ");
		sb.append("where M_TE_BillID='"+po.getCstibillid()+"'");		
		
		return queryForObjectList(sb.toString(), params.toArray(), TracEntryPo.class);
	}

	public int getStoreGoodsCount(TracPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct M_Trac.M_T_BillID) from M_Trac ");
		sb.append("inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID ");
		sb.append("inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		sb.append("inner join B_GoodsInfo on B_GI_GoodsID = M_TE_GoodsId ");
		sb.append("left join (select B_WH_ID , B_WH_warehouseName from B_Warehouse ) house ");
		sb.append("on house.B_WH_ID = M_Trac.M_T_OutStockId ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on M_Trac.M_T_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on M_Trac.M_T_AuditPerson=b.ID  ");
		
		sb.append(" INNER JOIN ( ");
		sb.append("SELECT M_TE_BillID, ");
		sb.append("       SUM(M_TE_NotTaxRateAmount) AS M_TE_NotTaxRateAmount, ");
		sb.append("       SUM(M_TE_CostPriceAmount)  AS M_TE_CostPriceAmount ");
		sb.append("FROM   (SELECT M_TE_BillID, ");
		sb.append("               M_TE_GoodsQuantity, ");
		sb.append("               M_TE_NotTaxRateAmount, ");
		sb.append("               M_TE_CostPriceAmount ");
		sb.append("        FROM   M_TracEntry) t1 ");
		sb.append("GROUP  BY M_TE_BillID ");
		sb.append(" ) cc ON cc.M_TE_BillID = M_T_BillID where 1=1 ");
		
		if("out".equals(Utility.getName(po.getCstiinorout()))){
			sb.append("and M_T_BillID like 'SR%' ");
		}else{
			sb.append("and M_T_BillID like 'SG%' ");
		}
		if(!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("and M_T_BillID like '%"+po.getCstibillid()+"%' ");//quyanping
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and M_T_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and M_T_SupplierId='"+po.getCstisupplierid()+"' ");
		}		
		if(!"".equals(Utility.getName(po.getCstioutstockid()))){
			sb.append("and M_T_OutStockId='"+Utility.getName(po.getCstioutstockid())+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstidepartmentid()))){
			sb.append("and M_T_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}				
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
			sb.append("and M_T_AuditState='"+po.getCstiauditstate()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), M_T_billDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), M_T_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), M_T_billDate, 23) >= '"+po.getCstistartTime()+"' ");
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), M_T_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and M_T_Remark like '%"+po.getCstiremark()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and M_TE_GoodsId like '%"+po.getCstigoodsid()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%"+po.getCstigoodsname()+"%' ");
		}
		if("1".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("2".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("3".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("4".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("5".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("6".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("7".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("8".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("9".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("10".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		
		if(!"".equals(Utility.getName(po.getCstisupplieridz()))){
			sb.append("and B_GI_SupplierID = '"+po.getCstisupplieridz()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("and B_GI_BrandID = '"+po.getCstibrandid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCsticreatepersonname()))){
			sb.append("and a.personName like '%"+po.getCsticreatepersonname()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstiauditpersonname()))){
			sb.append("and b.personName like '%"+po.getCstiauditpersonname()+"%' ");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	public List<TracPo> getStoreGoodsList(TracPo po,
			int start, int size) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from ( ");
		sb.append("select ROW_NUMBER() Over(order by cstibilldate desc) as rowNum,* from(select distinct ");
		sb.append("M_T_BillID as cstibillid,");
		sb.append("M_T_BillTypeId as cstibilltypeid,");
		sb.append("M_T_billDate as cstibilldate,");
		sb.append("M_T_AuditDate as cstiauditdate,");
		sb.append("house.B_WH_warehouseName as cstioutstockname,");
		sb.append("M_T_AuditState as cstiauditstate,");
		sb.append("a.personName as csticreatepersonname,");
		sb.append("b.personName as cstiauditpersonname,");
		sb.append("M_Trac.M_T_Remark as cstiremark, ");
		sb.append("M_T_SupplierId as cstisupplierid, ");
		sb.append("B_FS_StoreName as cstisuppliername, ");
		sb.append(" cc.M_TE_NotTaxRateAmount AS cstinottaxrateamount, ");
		sb.append(" cc.M_TE_CostPriceAmount AS csticostpriceamount, ");
		sb.append(" isnull(B_FS_IsClosed,'0') AS cstiisclosed ");
		sb.append("from M_Trac ");
		sb.append("inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID ");
		sb.append("inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		sb.append("inner join B_GoodsInfo on B_GI_GoodsID = M_TE_GoodsId ");
		sb.append("left join (select B_WH_ID , B_WH_warehouseName from B_Warehouse ) house ");
		sb.append("on house.B_WH_ID = M_Trac.M_T_OutStockId ");
		
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on M_T_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on M_T_AuditPerson=b.ID");

		sb.append(" INNER JOIN ( ");
		sb.append("SELECT M_TE_BillID, ");
		sb.append("       SUM(M_TE_NotTaxRateAmount) AS M_TE_NotTaxRateAmount, ");
		sb.append("       SUM(M_TE_CostPriceAmount)  AS M_TE_CostPriceAmount ");
		sb.append("FROM   (SELECT M_TE_BillID, ");
		sb.append("               M_TE_GoodsQuantity, ");
		sb.append("               M_TE_NotTaxRateAmount, ");
		sb.append("               M_TE_CostPriceAmount ");
		sb.append("        FROM   M_TracEntry) t1 ");
		sb.append("GROUP  BY M_TE_BillID ");
		sb.append(" ) cc ON cc.M_TE_BillID = M_T_BillID ");
		sb.append(" where 1=1 ");
		if("out".equals(Utility.getName(po.getCstiinorout()))){
			sb.append("and M_T_BillID like 'SR%' ");
		}else{
			sb.append("and M_T_BillID like 'SG%' ");
		}
		if(!"".equals(Utility.getName(po.getCstibillid()))){
			sb.append("and M_T_BillID like '%"+po.getCstibillid()+"%' ");//quyanping
		}
		if (!"".equals(Utility.getName(po.getCstidepartmentid()))) {
			sb.append("and M_T_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and M_T_SupplierId='"+po.getCstisupplierid()+"' ");
		}		
		if(!"".equals(Utility.getName(po.getCstioutstockid()))){
			sb.append("and M_T_OutStockId='"+Utility.getName(po.getCstioutstockid())+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstidepartmentid()))){
			sb.append("and M_T_DepartmentId='"+po.getCstidepartmentid()+"' ");
		}				
		if(!"".equals(Utility.getName(po.getCstiauditstate()))){
			sb.append("and M_T_AuditState='"+po.getCstiauditstate()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), M_T_billDate, 23) >= '"+po.getCstistartTime()+"' ");
			sb.append("and convert(varchar(10), M_T_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}else if(!"".equals(Utility.getName(po.getCstistartTime())) && "".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), M_T_billDate, 23) >= '"+po.getCstistartTime()+"' ");
		}else if("".equals(Utility.getName(po.getCstistartTime())) && !"".equals(Utility.getName(po.getCstiendTime()))){
			sb.append("and convert(varchar(10), M_T_billDate, 23) <= '"+po.getCstiendTime()+"' ");
		}	
		if(!"".equals(Utility.getName(po.getCstiremark()))){
			sb.append("and M_T_Remark like '%"+po.getCstiremark()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and M_TE_GoodsId like '%"+po.getCstigoodsid()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstigoodsname()))){
			sb.append("and B_GI_ViewGoodsName like '%"+po.getCstigoodsname()+"%' ");
		}
		if("1".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("2".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("3".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("4".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("5".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("6".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("7".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("8".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("9".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		if("10".equals(po.getWhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginpricemin()))) {
				sb.append(" and B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginpricemin());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendpricemax()))) {
				sb.append(" and B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendpricemax());
			}
		}
		
		if(!"".equals(Utility.getName(po.getCstisupplieridz()))){
			sb.append("and B_GI_SupplierID = '"+po.getCstisupplieridz()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCstibrandid()))){
			sb.append("and B_GI_BrandID = '"+po.getCstibrandid()+"' ");
		}
		if(!"".equals(Utility.getName(po.getCsticreatepersonname()))){
			sb.append("and a.personName like '%"+po.getCsticreatepersonname()+"%' ");
		}
		if(!"".equals(Utility.getName(po.getCstiauditpersonname()))){
			sb.append("and b.personName like '%"+po.getCstiauditpersonname()+"%' ");
		}
		sb.append(" ) temp)temp1 where rowNum > "+start+" and rowNum <= "+ (start + size));
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(),  params.toArray(), TracPo.class);
	}

	public void updateStoreGoods(TracPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("update M_Trac set ");

		if( null != po.getIsSalesFlag() && "1".equals(po.getIsSalesFlag())) {
			sb.append("M_T_OutStockId='"+po.getCstioutstockid()+"',");
		} else {
			sb.append("M_T_InStockId='"+po.getCstioutstockid()+"',");
		}
		sb.append("M_T_AuditState='"+po.getCstiauditstate()+"',");
		sb.append("M_T_FinanceAuditState='"+po.getCstifinanceauditstate()+"',");
		sb.append("M_T_Remark='"+po.getCstiremark()+"' ");
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb.append(",M_T_AuditPerson='"+po.getCstiauditperson()+"',M_T_AuditDate=getdate()");
		}
		
		if(!"".equals(Utility.getName(po.getCstisourcebillid()))){
			sb.append(",M_T_SourceBillId='"+po.getCstisourcebillid()+"' ");
		}
		
		sb.append(" where M_Trac.M_T_BillID='"+po.getCstibillid()+"'");
		getJdbcTemplate().update(sb.toString());
	}
	
	//反添加负调拨的状态（对于销售出库新增）
	public void insertAllocationStatus(TracPo tracPo) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE C_SHA_Allocation ");
		sb.append("SET ");
		sb.append("C_SHA_A_SalesOutStatus = '1' ");
		sb.append("WHERE C_SHA_A_billID = ? ");
		params.add(tracPo.getCstisourcebillid());

		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void insertStoreGoods(TracPo po) {
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into M_Trac(");
		sb1.append("M_T_BillID,");
		sb1.append("M_T_BillTypeId,");
		sb1.append("M_T_billDate,");
		sb1.append("M_T_SupplierId,");

		if( null != po.getIsSalesFlag() && "1".equals(po.getIsSalesFlag())) {
			sb1.append("M_T_OutStockId,");
		} else {
			sb1.append("M_T_InStockId,");
		}
		sb1.append("M_T_DepartmentId,");
		sb1.append("M_T_createPerson,");
		sb1.append("M_T_AuditState,");
		sb1.append("M_T_FinanceAuditState,");
		sb1.append("M_T_Remark");
		
		sb2.append("'"+po.getCstibillid()+"',");
		sb2.append("'"+po.getCstibilltypeid()+"',");
		sb2.append("getdate(),");
		sb2.append("'"+po.getCstisupplierid()+"',");
		sb2.append("'"+Utility.getName(po.getCstioutstockid())+"',");
		sb2.append("'"+po.getCstidepartmentid()+"',");
		sb2.append("'"+po.getCsticreateperson()+"',");
		sb2.append("'"+po.getCstiauditstate()+"',");
		sb2.append("'"+po.getCstifinanceauditstate()+"',");
		sb2.append("'"+po.getCstiremark()+"'");
		if(!"".equals(Utility.getName(po.getCstiauditperson()))){
			sb1.append(",M_T_AuditPerson,M_T_AuditDate");
			sb2.append(",'"+po.getCstiauditperson()+"',getdate()");
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb1.append(",M_T_SourceBillId");
			sb2.append(",'"+po.getCstisourcebillid()+"'");
		}
		
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql);
	}
	
	public void insertStoreGoodsEntry(TracEntryPo po) {
		StringBuffer sb=new StringBuffer();
		sb.append("insert into M_TracEntry(");
		sb.append("M_TE_ID,");
		sb.append("M_TE_BillID,");
		sb.append("M_TE_GoodsId,");
		sb.append("M_TE_GoodsQuantity,");
		sb.append("M_TE_NotTaxRate,");
		sb.append("M_TE_NotTaxRateAmount,");
		sb.append("M_TE_TaxRate,");
		sb.append("M_TE_CostPrice,");
		sb.append("M_TE_CostPriceAmount,");
		sb.append("M_TE_TaxAmount,");
		if( null != po.getIsSalesFlag() && "1".equals(po.getIsSalesFlag())) {
			sb.append("M_TE_OutStockId,");
		} else {
			sb.append("M_TE_InStockId,");
		}
		sb.append("M_TE_BarCode,");
		sb.append("M_TE_WarehousingDate,M_TE_OutStorageFlag ");
		
		sb.append(") values(");
		
		sb.append("'"+this.uuid.generate()+"',");
		sb.append("'"+po.getCstiebillid()+"',");
		sb.append("'"+po.getCstiegoodsid()+"',");
		sb.append("'"+po.getCstiegoodsquantity()+"',");
		sb.append("'"+po.getCstienottaxrate()+"',");
		sb.append("'"+po.getCstienottaxrateamount()+"',");
		sb.append("'"+po.getCstietaxrate()+"',");
		sb.append("'"+po.getCstiecostprice()+"',");
		sb.append("'"+po.getCstiecostpriceamount()+"',");
		sb.append("'"+po.getCstietaxamount()+"',");
		sb.append("'"+Utility.getName(po.getCstieoutstockid())+"',");
		sb.append("'"+po.getCstiebarcode()+"',");
		sb.append("getdate(),?)");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getCstieoutstorageflag()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public void deleteStoreGoods(TracPo po) {		
		String sql="delete from M_Trac where M_T_BillID='"+po.getCstibillid()+"'";		
		getJdbcTemplate().update(sql);		
	}
	public void deleteStoreGoodsEntry(TracPo po) {		
		String sql="delete from M_TracEntry where M_TE_BillID='"+po.getCstibillid()+"'";		
		getJdbcTemplate().update(sql);		
	}
	
	//查询负调拨商品信息
	public List<TracEntryPo> getReallocationList(TracPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("SELECT  C_SHA_AE_goodsId as cstiegoodsid, B_GI_Spec as cstiespec,");
		sb.append("B_GI_CostPrice*0 as cstiecostprice,B_GI_NotTaxRate as cstienottaxrate,");
		sb.append("B_GI_TaxRate as cstietaxrate,");
		sb.append("cast(isnull(C_SHA_AE_allocationQuantity*B_GI_NotTaxRate,0) as numeric(18,2)) as cstienottaxrateamount,");
		sb.append("B_GI_ViewGoodsName as cstiegoodsname, B_UT_unitName as cstieunitname, ");
		sb.append("C_SHA_AE_allocationQuantity as cstiegoodsquantity, B_GI_GoodsBarCode+'00000000' as cstiebarcode ");
		sb.append("FROM C_SHA_AllocationEntry  ");
		sb.append("INNER JOIN B_GoodsInfo ON C_SHA_AE_goodsId = B_GoodsInfo.B_GI_GoodsID  ");
		sb.append("inner join B_Unit on B_GI_UnitId=B_UT_id  ");
		sb.append("where C_SHA_AE_billId = ?  ");
		sb.append("order by C_SHA_AE_goodsId  ");
		List<String> params = new ArrayList<String>();
		params.add(po.getCstisourcebillid());

		return queryForObjectList(sb.toString(), params.toArray(),TracEntryPo.class);
	}
	
	
	/**
	 * 新增业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void insertGoodsBarCode(AllocationBarcodePo allocationBarcodePo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into M_TracBarCode(M_TB_ID,M_TB_BillID,M_TB_GoodsID,M_TB_GoodsBarcode) ");
		sb.append("values(?,?,?,?)");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(allocationBarcodePo.getCshabbillid()));
		params.add(Utility.getName(allocationBarcodePo.getCshabgoodsid()));
		params.add(Utility.getName(allocationBarcodePo.getCshabgoodsbarcode()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void deleteGoodsBarCode(TracPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from M_TracBarCode where M_TB_BillID=? ");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getTracBarcode(TracPo po){
		
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		sb.append("select M_TB_GoodsID as cshabgoodsid,M_TB_GoodsBarcode as cshabgoodsbarcode from M_TracBarCode where M_TB_BillID=? ");
		params.add(Utility.getName(po.getCstibillid()));
		
		if(!"".equals(Utility.getName(po.getCstigoodsid()))){
			sb.append("and M_TB_GoodsID = ? ");
			params.add(po.getCstigoodsid());
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), AllocationBarcodePo.class);
	}
	
	/**
	 * 取指定客户
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getFranchisee(String id)
	{
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" SELECT top 1 B_FS_StoreID as bdpdepartmentid,B_FS_StoreName as bdpdepartmentname,B_FS_StorePerson as bdpperson  ,B_FS_StorePhone as bdpphone ");
		buffer.append("  ,B_FS_StoreFax as bdpfax ,B_FS_StoreAddress as bdpaddress,B_FS_StoreRemark as bdpremark ");
		
		buffer.append(" FROM B_Franchisee where B_FS_StoreID=? ");
		
		params.add(Utility.getName(id));
		
		return (DepartmentsPo) queryForObject(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 取客户列表
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public List<DepartmentsPo>  getFranchisees()
	{	
		StringBuffer buffer = new StringBuffer();

		buffer.append(" SELECT  B_FS_StoreID as bdpdepartmentid,B_FS_StoreName as bdpdepartmentname,B_FS_StorePerson as bdpperson  ,B_FS_StorePhone as bdpphone ");
		buffer.append("  ,B_FS_StoreFax as bdpfax ,B_FS_StoreAddress as bdpaddress,B_FS_StoreRemark as bdpremark ");
		
		buffer.append(" FROM B_Franchisee  ");
		
		
		return queryForObjectList(buffer.toString(), null, DepartmentsPo.class);
	}
	
	/**
	 * 根据停用启用的状态查看客户
	 */
	public List<DepartmentsPo>  getFranchisees(DepartmentsPo dpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" SELECT  B_FS_StoreID as bdpdepartmentid,B_FS_StoreName as bdpdepartmentname,B_FS_StorePerson as bdpperson  ,B_FS_StorePhone as bdpphone ");
		buffer.append("  ,B_FS_StoreFax as bdpfax ,B_FS_StoreAddress as bdpaddress,B_FS_StoreRemark as bdpremark ");		
		buffer.append(" FROM B_Franchisee where 1 = 1  ");
		
		if (!"".equals(Utility.getName(dpo.getBdpisclosed()))){
			buffer.append(" and B_FS_IsClosed = ? ");
			params.add(Utility.getName(dpo.getBdpisclosed()));
		}
		
		return queryForObjectList(buffer.toString(),params.toArray(), DepartmentsPo.class);
	}
	
	/**
	 * 新增客户往来账明细
	 */
	public void insertFranchiseeCurrentAccountDetail(TracPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_FA_DA_DealingsAccounts(L_FA_DA_ID,L_FA_DA_Date,L_FA_DA_BillID,L_FA_DA_BillTypeID,L_FA_DA_DealingsUnit,L_FA_DA_CostPriceAmount) ");
		sb.append("select newid(),M_T_AuditDate,M_T_BillID,'客户批发调货单',M_T_SupplierId,sum(M_TE_CostPriceAmount) from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		sb.append("  where M_T_AuditState='1' and M_T_FinanceAuditState='1' and M_T_BillID=? ");
		sb.append("  group by M_T_AuditDate,M_T_BillID,M_T_SupplierId ");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 新增客户批发退货单往来账明细
	 */
	public void insertFranchiseeReturnCurrentAccountDetail(TracPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into L_FA_DA_DealingsAccounts(L_FA_DA_ID,L_FA_DA_Date,L_FA_DA_BillID,L_FA_DA_BillTypeID,L_FA_DA_DealingsUnit,L_FA_DA_CostPriceAmount) ");
		sb.append("select newid(),M_T_AuditDate,M_T_BillID,'客户批发退货单',M_T_SupplierId,-sum(M_TE_CostPriceAmount) from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		sb.append("  where M_T_AuditState='1' and M_T_FinanceAuditState='1' and M_T_BillID=? ");
		sb.append("  group by M_T_AuditDate,M_T_BillID,M_T_SupplierId ");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 删除客户往来账明细
	 */
	public void deleteFranchiseeCurrentAccountDetail(TracPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from L_FA_DA_DealingsAccounts where L_FA_DA_BillID=? ");
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 *  新增客户批发调货在途库存
	 */
	public void insertFranchiseeOutInTransitStorage(TracPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_SH_InTransitStorageEntry(C_SH_TSE_ID,C_SH_TSE_DepartmentType,C_SH_TSE_ModuleID,C_SH_TSE_EntryID ");
		sb.append("           ,C_SH_TSE_BillID,C_SH_TSE_GoodsID,C_SH_TSE_GoodsBarCode,C_SH_TSE_GoodsNum,C_SH_TSE_InStockID,C_SH_TSE_OutStockID,C_SH_TSE_InOrOutStock) ");
		
		sb.append("select newid() as a1,M_T_SupplierId as a2,'4' as a3,M_TE_ID as a4,M_TE_BillID as a5,M_TE_GoodsId as a6, ");
		sb.append("       isnull(M_TE_BarCode,'') as a7,-isnull(M_TE_GoodsQuantity,0) as a8,'' as a9,M_TE_OutStockId as a10,'2' as a11 ");
		sb.append("  from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		sb.append("  where M_T_BillTypeId='3' and isnull(M_T_AuditState,'')<>'1' and M_T_BillID=? and substring(M_TE_GoodsId,9,1)<>'D'");		
		
		params.add(Utility.getName(po.getCstibillid()));
				
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	public List<TracEntryPo> getWholeApplyGoodsEntryList(TracPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();	
		sb.append("select ");
		sb.append("C_SH_AWE_ID as cstieid,");
		sb.append("C_SH_AWE_goodsId as cstiegoodsid,");
		sb.append("C_SH_AW_inDepartmentId as cstiesupplierID,");
		sb.append("B_GoodsInfo.B_GI_ViewGoodsName as cstiegoodsname,");
		sb.append("B_GI_GoodsBarCode+'00000000' as cstiebarcode,");
		if(!"0".equals(po.getCstiisbatch())){
			sb.append("case  ");
			sb.append("		when substring(C_SH_AWE_goodsId,1,1) = '4' or substring(C_SH_AWE_goodsId,1,1) = '5' then '0' ");
			sb.append("		else C_SH_AWE_requirementQuantity end as cstiegoodsquantity, ");
		}else{
			sb.append("		C_SH_AWE_requirementQuantity as cstiegoodsquantity, ");
		}
		sb.append("B_GoodsInfo.B_GI_Spec as cstiespec,");	
		sb.append("B_GI_NotTaxRate as cstienottaxrate,");
		sb.append("B_GI_TaxRate as cstietaxrate,");
		sb.append("B_GI_CostPrice as cstiecostprice,");
		sb.append("isnull(B_GI_WholesalePrice,'0.00') as cstiewholesaleprice,");
		sb.append("B_WH_ID as cstieoutstockid,");
		sb.append("B_WH_warehouseName AS cstioutstockname,");
		sb.append("B_WH_warehouseName AS cstiinstockname,");
		sb.append("isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0) as cstiemaxquantity, ");
		sb.append("kucun.guaranteeperiod as cstieguaranteeperiod, ");
		sb.append("kucun.batch as cstiebatch ");
		sb.append(" from C_SH_ApplyWholeEntry ");
		sb.append("left join C_SH_ApplyWhole on C_SH_AW_billID=C_SH_AWE_billId ");
		sb.append("LEFT JOIN (SELECT		 C_SH_SL_GoodsId  AS GoodsId, ");
		sb.append("        isnull(sum(C_SH_Sl_GoodsQuantity),0) AS GoodsQuantity, ");
		sb.append("        C_SH_Sl_StockId       AS StockId, ");
		sb.append("        isnull(C_SH_SL_GuaranteePeriod,'')       AS guaranteeperiod, ");
		sb.append("        isnull(C_SH_SL_Batch,'')       AS batch ");
		sb.append(" FROM   C_SH_StorageLog ");
		sb.append(" WHERE  1 = 1 ");
		sb.append(" AND C_SH_SL_StockId = ? ");
		params.add(po.getCstioutstockid());
		sb.append(" GROUP  BY C_SH_SL_GoodsId,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,''), ");
		sb.append("   C_SH_Sl_StockId) kucun ");
		sb.append(" ON C_SH_AWE_goodsId = kucun.GoodsId ");
		sb.append(" LEFT JOIN (SELECT C_SH_TSE_GoodsID  AS GoodsID, ");
		sb.append(" isnull(SUM(C_SH_TSE_GoodsNum),0) AS GoodsNum ");
        sb.append(" FROM   C_SH_InTransitStorageEntry ");
        sb.append(" WHERE  1 = 1 ");
        sb.append("        AND C_SH_TSE_OUTStockID = ? ");
        params.add(po.getCstioutstockid());
        sb.append(" GROUP  BY C_SH_TSE_GoodsID)zaitu ");
        sb.append("ON C_SH_AWE_goodsId = zaitu.GoodsID ");
		
		sb.append("inner join B_GoodsInfo on C_SH_AWE_goodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" LEFT JOIN B_Warehouse ON B_WH_ID = ? ");
		params.add(po.getCstioutstockid());
		sb.append("where C_SH_AWE_billId = '"+po.getCstibillid()+"'");	
		
		if(!"0".equals(po.getCstiisbatch())){
			sb.append("  and B_GI_GoodsCategoryID not in ('4','5') ");
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), TracEntryPo.class);
	}
}
