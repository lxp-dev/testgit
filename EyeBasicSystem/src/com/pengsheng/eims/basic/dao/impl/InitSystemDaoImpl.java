package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.InitSystemDao;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.system.persistence.PeriodBeginClearPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class InitSystemDaoImpl extends BaseJdbcDaoSupport implements InitSystemDao {
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertStorageGoods_Log(List<GoodsInfoPo> poList){
		
		StringBuffer buffer = null;
		List<String> params = null;
		
		for (GoodsInfoPo po : poList){
			
			buffer = new StringBuffer();
			params = new ArrayList<String>();
			
			buffer.append("INSERT INTO C_SH_StorageLog(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity,C_SH_SL_CostPrice,C_SH_SL_NotTaxRate, ");
			buffer.append("C_SH_SL_WarehousingDate,C_SH_SL_ChangeID,C_SH_SL_SourceChangeID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch,C_SH_SL_IsExcel ) ");	
			buffer.append(" values(newid(),?,?,?,?,'0','0',getdate(),'import','import',?,?,? ) ");

			params.add(Utility.getName(po.getBgigoodsbarcode()));
			params.add(Utility.getName(po.getBgigoodsid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgigoodsquantity()));			
			params.add(Utility.getName(po.getGuaranteeperiod()));
			params.add(Utility.getName(po.getBatch()));
			params.add(Utility.getName(po.getBgiisexcelflag()));
			
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
				
	}
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertStorageGoods_Change(List<GoodsInfoPo> poList){
		
		StringBuffer buffer = null;
		List<String> params = null;
		
		for (GoodsInfoPo po : poList){
			
			buffer = new StringBuffer();
			params = new ArrayList<String>();
			
			buffer.append("INSERT INTO C_SH_StorageChange(C_SH_SC_UUID,C_SH_SC_GoodsBarCode,C_SH_SC_GoodsId,C_SH_SC_StockId,C_SH_SC_GoodsQuantity,C_SH_SC_CostPrice,C_SH_SC_NotTaxRate,C_SH_SC_WarehousingDate,C_SH_SC_ChangeID,C_SH_SC_IsExcel) ");
			buffer.append(" values(newid(),?,?,?,?,0,0,getdate(),'import',?) ");

			params.add(Utility.getName(po.getBgigoodsid()).replace(".",""));
			params.add(Utility.getName(po.getBgigoodsid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgigoodsquantity()));
			params.add(Utility.getName(po.getBgiisexcelflag()));
			
			getJdbcTemplate().update(buffer.toString(), params.toArray());
		}
		
	}

    /**
	 * 查询需要导出的商品信息
	 * 
	 * @param brandPo
	 */
	public List<GoodsInfoPo> selGoodsInfo(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select B_GI_GoodsID as bgigoodsid,B_GI_GoodsName as bgigoodsname,isnull(B_GI_SupplierSpec,'') as bgispec,isnull(B_GI_SupplierColor,'') as bgicolor,isnull(B_GI_Sph,'') as bgisph,isnull(B_GI_Cyl,'') as bgicyl,isnull(B_GI_ThrowingCycle,'') as bgithrowingcycle, ");
		buffer.append(" isnull(B_GI_OtherGoodsBigClass,'') as bgiothergoodsbigclass,isnull(B_GI_OtherGoodsSmallClass,'') as bgiothergoodssmallclass,isnull(B_GI_FinishedGlassesType,'') as bgifinishedglassestype,B_GI_RetailPrice as bgiretailprice  from B_GoodsInfo where B_GI_SupplierID <> 'ZZ' ");
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			buffer.append(" and B_GI_GoodsCategoryID=? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		
		buffer.append(" order by B_GI_GoodsID ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	public GoodsCategoryPo getGoodsCategorys(String id) {
		List<String> params = new ArrayList<String>();
		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory where B_GC_ID = ? ";
		
		params.add(id);

		return (GoodsCategoryPo)queryForObject(sql, params.toArray(), GoodsCategoryPo.class);
	}
	
    /**
	 * 查询商品是否存在
	 * 
	 * @param brandPo
	 */
	public int getGoodsCount(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(B_GI_GoodsID) from B_GoodsInfo where B_GI_GoodsID = ? ");
		
		params.add(Utility.getName(po.getBgigoodsid()));
		
		if (!Utility.getName(po.getBgibarcodeflag()).equals("")){
			buffer.append(" and isnull(B_GI_BarCodeFlag,'0') = ? ");
			params.add(Utility.getName(po.getBgibarcodeflag()));
		}
			
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
    /**
	 * 查询需要打印条码的商品信息总数
	 * 
	 * @param brandPo
	 */
	public int getPrintGoodsBarCodeCount(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(distinct bgigoodsbarcode) from ( ");
		buffer.append(" select bgigoodsid as bgigoodsid,bgigoodsname as bgigoodsname,bgigoodsbarcode as bgigoodsbarcode,bgigoodsquantity as bgigoodsquantity from ( ");
		buffer.append(" select C_SH_SL_GoodsId as bgigoodsid,B_GI_GoodsName as bgigoodsname,C_SH_SL_GoodsBarCode as bgigoodsbarcode,sum(C_SH_SL_GoodsQuantity) as bgigoodsquantity  ");
		buffer.append("  from C_SH_StorageLog left join B_GoodsInfo on C_SH_SL_GoodsId=B_GI_GoodsID inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID ");
		buffer.append(" INNER JOIN B_Brand ON substring(C_SH_SL_GoodsId,6,2) = B_BD_ID and substring(C_SH_SL_GoodsId,3,2) = B_BD_SupplierID ");
		buffer.append(" where C_SH_SL_StockId=? and C_SH_SL_ChangeID = 'import' ");
		
		params.add(Utility.getName(po.getBgiwarehouseid()));	
		
		if ("1".equals(Utility.getName(po.getBgiisprint()))){
			buffer.append(" and isnull(C_SH_SL_Month,'0') = '1' ");
		}else if(!"1".equals(Utility.getName(po.getBgiisprint()))){
			buffer.append(" and isnull(C_SH_SL_Month,'0') <> '1' ");
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			buffer.append(" and C_SH_SL_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgnDate()))){
			buffer.append(" and Convert(varchar(10),C_SH_SL_WarehousingDate,23) >= ? ");
			params.add(Utility.getName(po.getBgnDate()));
		}
		if (!"".equals(Utility.getName(po.getEndDate()))){
			buffer.append(" and Convert(varchar(10),C_SH_SL_WarehousingDate,23) <= ? ");
			params.add(Utility.getName(po.getEndDate()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}

		buffer.append(" group by C_SH_SL_GoodsId,B_GI_GoodsName,C_SH_SL_GoodsBarCode,B_WH_warehouseName,B_BD_Place,B_GI_RetailPrice,B_GI_Spec,B_GI_Color  ");
		
		buffer.append(" )temp where bgigoodsquantity > 0 ");
		buffer.append(" )temp ");		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
    /**
	 * 查询需要打印条码的商品信息
	 * 
	 * @param brandPo
	 */
	public List<GoodsInfoPo> getPrintGoodsBarCodeList(GoodsInfoPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by bgigoodsid) as rowNum, ");
		buffer.append("  bgigoodsid as bgigoodsid,bgigoodsname as bgigoodsname,bgigoodsbarcode as bgigoodsbarcode,bgiwarehousename as bgiwarehousename,bgigoodsquantity as bgigoodsquantity, ");
		buffer.append(" bgisource as bgisource,isnull(bgiretailprice,'0.00') as bgiretailprice,bgispec as bgispec,bgibrandname as bgibrandname,guaranteeperiod as guaranteeperiod,batch as batch,");
		
		buffer.append(" CASE ");
		buffer.append(" WHEN bgigoodscategoryid = '8' THEN isnull(bgicolor,'') + isnull(bgisph,'') ");
		buffer.append(" WHEN bgigoodscategoryid <> '8' THEN isnull(bgicolor,'') ");
		buffer.append(" END                                         AS bgicolor ");
		buffer.append(" from ( ");
		buffer.append(" select B_GI_GoodsCategoryID as bgigoodscategoryid,C_SH_SL_GoodsId as bgigoodsid,B_GI_GoodsName as bgigoodsname,C_SH_SL_GoodsBarCode as bgigoodsbarcode,B_WH_warehouseName as bgiwarehousename,sum(C_SH_SL_GoodsQuantity) as bgigoodsquantity,  ");
		buffer.append(" B_BD_Place as bgisource,B_GI_Spec as bgispec,B_GI_Color as bgicolor,B_GI_Sph as bgisph,B_BD_brandName as bgibrandname,C_SH_SL_GuaranteePeriod as guaranteeperiod,");
		
		if("1".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		
		buffer.append(" C_SH_SL_Batch as batch ");
		buffer.append(" from C_SH_StorageLog ");
		buffer.append(" left join B_GoodsInfo on C_SH_SL_GoodsId=B_GI_GoodsID ");
		buffer.append(" inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID ");
		buffer.append(" INNER JOIN B_Brand ON substring(C_SH_SL_GoodsId,6,2) = B_BD_ID and substring(C_SH_SL_GoodsId,3,2) = B_BD_SupplierID ");
		buffer.append(" where C_SH_SL_StockId=? and C_SH_SL_ChangeID = 'import' ");
		
		params.add(Utility.getName(po.getBgiwarehouseid()));
		
		if ("1".equals(Utility.getName(po.getBgiisprint()))){
			buffer.append(" and isnull(C_SH_SL_Month,'0') = '1' ");
		}else if(!"1".equals(Utility.getName(po.getBgiisprint()))){
			buffer.append(" and isnull(C_SH_SL_Month,'0') <> '1' ");
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			buffer.append(" and C_SH_SL_GoodsId like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgnDate()))){
			buffer.append(" and Convert(varchar(10),C_SH_SL_WarehousingDate,23) >= ? ");
			params.add(Utility.getName(po.getBgnDate()));
		}
		if (!"".equals(Utility.getName(po.getEndDate()))){
			buffer.append(" and Convert(varchar(10),C_SH_SL_WarehousingDate,23) <= ? ");
			params.add(Utility.getName(po.getEndDate()));
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getBgigoodscategoryid()));
		}
		
		buffer.append(" group by C_SH_SL_GoodsId,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch,B_BD_brandName,B_GI_GoodsName,C_SH_SL_GoodsBarCode,B_WH_warehouseName,B_BD_Place,B_GI_RetailPrice,B_GI_Spec,B_GI_Color,B_GI_GoodsCategoryID, ");
		
		if("1".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailprice     , ");
		}
		if("2".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricea     , ");
		}
		if("3".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriceb     , ");
		}
		if("4".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricec     , ");
		}
		if("5".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriced     , ");
		}
		if("6".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricee     , ");
		}
		if("7".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricef     , ");
		}
		if("8".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriceg     , ");
		}
		if("9".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpriceh     , ");
		}
		if("10".equals(po.getBgiwhichretail())){
			buffer.append(" b_gi_retailpricei     , ");
		}
		
		buffer.append(" B_GI_Sph  ");
		buffer.append(") temp where bgigoodsquantity > 0 ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
    /**
	 * 更新库存表，为已打印条码的商品打上标记
	 * 
	 * @param brandPo
	 */
	public void updatePrintGoodsBarCodeStatus(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" update C_SH_StorageLog set C_SH_SL_Month='1' where C_SH_SL_StockId=? ");		

		params.add(Utility.getName(po.getBgiwarehouseid()));
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			buffer.append(" and C_SH_SL_GoodsBarCode=? ");
			params.add(Utility.getName(po.getBgigoodsbarcode()));
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 使用商品不含税成本更新加权平均成本
	 * 
	 * @param brandPo
	 */
	public void updateGoodsAvgCost(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		if (Utility.getName(po.getBgiaverageflag()).equals("2")){
			buffer.append(" update B_GoodsInfo set B_GI_AverageNotTaxRate=B_GI_CostPrice ");
		}else{
			buffer.append(" update B_GoodsInfo set B_GI_AverageNotTaxRate=B_GI_NotTaxRate ");
		}
				
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 汇总财务期初成本
	 */
	public void insertGoodsAvgCost(String bgndate,String companyID,String departmentID,String cbPriceType,String cbjsType){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();	
		
		if (!"".equals(Utility.getName(companyID))){
			buffer.append("delete from L_CT_CostingTemplate where L_CT_CT_CompanyID = ? ");
	        params.add(Utility.getName(companyID));
	        
			if (!"".equals(Utility.getName(departmentID))){
				buffer.append(" and L_CT_CT_DepartmentID = ? ");
		        params.add(Utility.getName(departmentID));        
			}
	        
			buffer.append("delete from L_CT_CurrentMonthCostingTemp where L_CT_CT_CompanyID = ? ");
	        params.add(Utility.getName(companyID));
	        
		}else{
			buffer.append("delete from L_CT_CostingTemplate ");
			
			buffer.append("delete from L_CT_CurrentMonthCostingTemp ");
		}
		
		buffer.append(" INSERT INTO L_CT_CostingTemplate ");		
		buffer.append("           (L_CT_CT_ID ");		
		buffer.append("           ,L_CT_CT_Date ");	
		buffer.append("           ,L_CT_CT_GoodsID ");
		buffer.append("           ,L_CT_CT_GoodsQuantity ");		
		buffer.append("           ,L_CT_CT_Goodsnottaxrateamount ");		
		buffer.append("           ,L_CT_CT_BackFillTaxRate ");		
		buffer.append("           ,L_CT_CT_DepartmentID ");	
		buffer.append("           ,L_CT_CT_GoodsRateamount ");
		buffer.append("           ,L_CT_CT_BackFillRate ");
		buffer.append("           ,L_CT_CT_CompanyID) ");
		buffer.append("  select newid(),?,C_SH_SL_GoodsId,sum(C_SH_SL_GoodsQuantity), ");		
		buffer.append("         sum(cast((C_SH_SL_GoodsQuantity * B_GI_NotTaxRate) as numeric(18,2))), ");		
		buffer.append("         B_GI_NotTaxRate,");
		
		if (cbjsType.equals("1")){
			buffer.append("     '', ");		
		}else{
			buffer.append("     B_WH_deptID, ");
		}
	
		buffer.append("         sum(cast((C_SH_SL_GoodsQuantity * B_GI_CostPrice) as numeric(18,2))), ");
		buffer.append("         B_GI_CostPrice, ");	
		
		if (cbjsType.equals("1")){
			buffer.append("     '' ");
		}else{
			buffer.append("     B_DP_CompanysID ");
		}

		buffer.append("    from C_SH_StorageLog  ");		
		buffer.append("         inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID ");		
		buffer.append("         inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");	
		buffer.append("         inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("    where convert(varchar(16),C_SH_SL_WarehousingDate,120) < ? ");	
		
		params.add(bgndate);
		params.add(bgndate);
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and B_DP_CompanysID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
		if (!"".equals(Utility.getName(departmentID))){
			buffer.append(" and B_WH_deptID = ? ");
	        params.add(Utility.getName(departmentID));        
		}
		
		buffer.append("    group by C_SH_SL_GoodsId,B_GI_NotTaxRate,B_GI_CostPrice ");	
		
		if (cbjsType.equals("2")){
			buffer.append(" ,B_WH_deptID,B_DP_CompanysID ");
		}	
		
		buffer.append("    having sum(C_SH_SL_GoodsQuantity) <> 0 ");
				
		buffer.append(" INSERT INTO L_CT_CurrentMonthCostingTemp ");		
		buffer.append("           (L_CT_CT_ID ");		
		buffer.append("           ,L_CT_CT_Date ");	
		buffer.append("           ,L_CT_CT_GoodsID ");
		buffer.append("           ,L_CT_CT_GoodsQuantity ");		
		buffer.append("           ,L_CT_CT_Goodsnottaxrateamount ");		
		buffer.append("           ,L_CT_CT_BackFillTaxRate ");		
		buffer.append("           ,L_CT_CT_CompanyID) ");
		buffer.append("  select newid(),?,C_SH_SL_GoodsId,sum(C_SH_SL_GoodsQuantity), ");
		
		if (cbPriceType.equals("1")){
			buffer.append("         sum(cast((C_SH_SL_GoodsQuantity * B_GI_NotTaxRate) as numeric(18,2))), ");		
			buffer.append("         B_GI_NotTaxRate,");
		}else{
			buffer.append("         sum(cast((C_SH_SL_GoodsQuantity * B_GI_CostPrice) as numeric(18,2))), ");
			buffer.append("         B_GI_CostPrice, ");	
		}
		
		if (cbjsType.equals("1")){
			buffer.append("     '' ");
		}else{
			buffer.append("     B_DP_CompanysID ");
		}

		buffer.append("    from C_SH_StorageLog  ");		
		buffer.append("         inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID ");		
		buffer.append("         inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");	
		buffer.append("         inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("    where convert(varchar(16),C_SH_SL_WarehousingDate,120) < ? ");	
		
		params.add(bgndate);
		params.add(bgndate);
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and B_DP_CompanysID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
		buffer.append("    group by C_SH_SL_GoodsId ");	
		
		if (cbPriceType.equals("1")){
			buffer.append(",B_GI_NotTaxRate");
		}else{
			buffer.append(",B_GI_CostPrice");	
		}
		
		if (cbjsType.equals("2")){
			buffer.append(" ,B_DP_CompanysID ");		
		}	
		
		buffer.append("    having sum(C_SH_SL_GoodsQuantity) <> 0 ");
				
		if (cbjsType.equals("1")){   // 按所有公司
			
			if (cbPriceType.equals("1")){     // 按不含税成本计算
				buffer.append("  update B_GoodsInfo set B_GI_AverageNotTaxRate = B_GI_NotTaxRate ");
			}
			
			if (cbPriceType.equals("2")){    // 按含税成本计算
				buffer.append("  update B_GoodsInfo set B_GI_AverageNotTaxRate = B_GI_CostPrice ");
			}
			
		}
		
		if (cbjsType.equals("2")){   // 按公司
						
			buffer.append(" delete from B_GoodsAveragePrice where 1 = 1 ");
			
			if (!"".equals(Utility.getName(companyID))){
		        buffer.append("  and B_GA_CompanyID = ? ");
		        params.add(Utility.getName(companyID));
			}
			
			if (cbPriceType.equals("1")){    // 按不含税成本计算
				
				buffer.append(" insert into B_GoodsAveragePrice (B_GA_ID,B_GA_CompanyID,B_GA_GoodsID,B_GA_AverageNotTaxRate) ");
				buffer.append(" select newid(),?,B_GI_GoodsID,B_GI_NotTaxRate from B_GoodsInfo ");
				
				if (!"".equals(Utility.getName(companyID))){
			        params.add(Utility.getName(companyID));      
				}else{
					params.add("");
				}
			}
			
			if (cbPriceType.equals("2")){    // 按含税成本计算
				
				buffer.append(" insert into B_GoodsAveragePrice (B_GA_ID,B_GA_CompanyID,B_GA_GoodsID,B_GA_AverageNotTaxRate) ");
				buffer.append(" select newid(),?,B_GI_GoodsID,B_GI_CostPrice from B_GoodsInfo ");
				
				if (!"".equals(Utility.getName(companyID))){
			        params.add(Utility.getName(companyID));			        
				}else{
					params.add("");
				}
			}
			
		}		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 清除试用数据
	 */
	public void deletePeriodBeginData(PeriodBeginClearPo ppo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from C_MR_MaterialRecycle ");
		buffer.append("delete from C_MR_MaterialRecycleLeaveMsg ");
		
		if (!"".equals(Utility.getName(ppo.getPbcbill1()))){
			buffer.append("delete from C_PR_AdcostPrice ");
			buffer.append("delete from C_PR_AdcostPriceEntry ");			
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill2()))){
			buffer.append("delete from C_PR_AdjustmentPrice ");
			buffer.append("delete from C_PR_AdjustmentPriceEntry ");			
		}
		
		buffer.append("delete from C_PR_Promotions ");
		buffer.append("delete from C_PR_PromotionsEntry ");
		
		if (!"".equals(Utility.getName(ppo.getPbcbill3()))){
			buffer.append("delete from C_PR_WholesalePrice ");
			buffer.append("delete from C_PR_WholesalePriceEntry ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill4()))){
			buffer.append("delete from C_SA_StockAlertSetting ");
			
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SA_StockAlertSetting inner join B_Warehouse on C_SA_SA_StockID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
		}		
		
		if (!"".equals(Utility.getName(ppo.getPbcbill10()))){
			buffer.append("delete from C_SH_ApplyWhole ");
			buffer.append("delete from C_SH_ApplyWholeEntry ");
			buffer.append("update C_SHA_Status set C_SHA_StatusApplyBillID = '' where C_SHA_StatusApplyBillID like 'WAP%' ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill6()))){
			buffer.append("delete from C_SH_CheckStorage ");
			
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_CheckStorage inner join B_Warehouse on C_SH_CS_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_SH_CheckStorageEntry where C_SH_CSE_BillId not in (select C_SH_CS_BillId from C_SH_CheckStorage) ");
				
			}else{
				buffer.append("delete from C_SH_CheckStorageEntry ");
			}			
			
			buffer.append("delete from C_SH_CheckStorageTemp ");
			
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_CheckStorageTemp inner join B_Warehouse on C_SH_CST_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_SH_CheckStorageTempEntry where C_SH_CSTE_BillId not in (select C_SH_CST_BillId from C_SH_CheckStorageTemp)  ");
				
			}else{
				buffer.append("delete from C_SH_CheckStorageTempEntry ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill7()))){
			buffer.append("delete from C_SH_CheckStoragefx ");
			
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_CheckStoragefx inner join B_Warehouse on C_SH_CS_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_SH_CheckStoragefxEntry where C_SH_CSE_BillId not in (select C_SH_CS_BillId from C_SH_CheckStoragefx)  ");
				
			}else{
				buffer.append("delete from C_SH_CheckStoragefxEntry ");
			}			
		}
				
		if (!"".equals(Utility.getName(ppo.getPbcbill5()))){
			buffer.append("delete from C_SH_InTransitStorageEntry ");
			
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_InTransitStorageEntry inner join B_Warehouse on C_SH_TSE_OutStockID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill40()))){
			buffer.append("delete from C_SH_Storage_ZZL ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_Storage_ZZL inner join B_Warehouse on C_SH_SZ_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageBeginning ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageBeginning inner join B_Warehouse on C_SH_SB_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageChange ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageChange inner join B_Warehouse on C_SH_SC_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageChange_FlySheet ");
			
			buffer.append("delete from C_SH_StorageLog ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_FlySheet ");
			
			buffer.append("delete from C_SH_StorageLog_HC ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_HC inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_HLY ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_HLY inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_JJ ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_JJ inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_JP ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_JP inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_LHJ ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_LHJ inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_PJ ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_PJ inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_SG ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_SG inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_TYJ ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_TYJ inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from C_SH_StorageLog_YX ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SH_StorageLog_YX inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill8()))){
			buffer.append("delete from C_SHA_Allocation ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SHA_Allocation inner join B_Departments a on C_SHA_A_outDepartmentId = a.B_DP_DepartmentID ");
				buffer.append("                        inner join B_Departments b on C_SHA_A_inDepartmentId = b.B_DP_DepartmentID ");
				buffer.append("  where a.B_DP_CompanysID = ? or b.B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_SHA_AllocationEntry where C_SHA_AE_billId not in (select C_SHA_A_billID from C_SHA_Allocation) ");
				buffer.append("delete from C_SHA_AllocationBarcode where C_SHA_B_billID not in (select C_SHA_A_billID from C_SHA_Allocation) ");
				buffer.append("delete from C_SHA_OutSourcingDeliveryBill where C_SHA_OS_AlloctionBillID not in (select C_SHA_A_billID from C_SHA_Allocation) ");
				buffer.append("delete from C_ST_Inventory where C_ST_I_BillID like 'ALL%' and C_ST_I_BillID not in (select C_SHA_A_billID from C_SHA_Allocation) ");
				buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID like 'ALL%' and C_ST_IE_BillID not in (select C_SHA_A_billID from C_SHA_Allocation) ");
				
			}else{
				buffer.append("delete from C_SHA_AllocationEntry ");
				buffer.append("delete from C_SHA_AllocationBarcode ");
				buffer.append("delete from C_SHA_OutSourcingDeliveryBill ");
				buffer.append("delete from C_ST_Inventory where C_ST_I_BillID like 'ALL%' ");
				buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID like 'ALL%' ");				
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill9()))){
			buffer.append("delete from C_SHA_ApplyAllocation ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SHA_ApplyAllocation inner join B_Departments on C_SHA_AA_outDepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_SHA_ApplyAllocationEntry where C_SHA_AAE_billId not in (select C_SHA_AA_billID from C_SHA_ApplyAllocation) ");	
				
			}else{
				buffer.append("delete from C_SHA_ApplyAllocationEntry ");	
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill11()))){
			buffer.append("delete from C_SHA_Nonconforming ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_SHA_Nonconforming inner join B_Departments on C_SHA_N_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_SHA_NonconformingEntry where C_SHA_NE_billID not in (select C_SHA_N_billID from C_SHA_Nonconforming) ");	
				
			}else{
				buffer.append("delete from C_SHA_NonconformingEntry ");
			}
			
		}		
		
		if (!"".equals(Utility.getName(ppo.getPbcbill12()))){
			buffer.append("delete from C_ST_ConsignProcessOrder ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_ConsignProcessOrder inner join B_Departments on C_ST_CPO_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_ConsignProcessOrderDetails where C_ST_CPOD_OrderBillD not in (select C_ST_CPO_OrderBillId from C_ST_ConsignProcessOrder) ");	
				
			}else{
				buffer.append("delete from C_ST_ConsignProcessOrderDetails ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill13()))){
			buffer.append("delete from C_ST_PO ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_PO inner join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_PoEntry where C_ST_PE_PurchaseOrderID not in (select C_ST_P_ID from C_ST_PO) ");	
				
			}else{
				buffer.append("delete from C_ST_PoEntry ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill14()))){
			buffer.append("delete from C_ST_Inventory ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_Inventory left join B_Warehouse c on C_ST_I_InStockId = c.B_WH_ID  left join B_Departments a on c.B_WH_deptID = a.B_DP_DepartmentID ");
				buffer.append("                      left join B_Warehouse d on C_ST_I_OutStockId = d.B_WH_ID left join B_Departments b on d.B_WH_deptID = b.B_DP_DepartmentID ");
				buffer.append("  where a.B_DP_CompanysID = ? or b.B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID not in (select C_ST_I_BillID from C_ST_Inventory) ");
				buffer.append("delete from C_ST_InventoryBarCode where C_ST_IB_BillID not in (select C_ST_I_BillID from C_ST_Inventory) ");	
				
			}else{
				buffer.append("delete from C_ST_InventoryEntry ");
				buffer.append("delete from C_ST_InventoryBarCode ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill15()))){
			buffer.append("delete from C_ST_ConsignProcessReceipt ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_ConsignProcessReceipt inner join B_Warehouse on C_ST_CPR_InStockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_ConsignProcessReceiptDetails where C_ST_CPRD_ReceiptBillD not in (select C_ST_CPR_ReceiptBillId from C_ST_ConsignProcessReceipt) ");
				
			}else{
				buffer.append("delete from C_ST_ConsignProcessReceiptDetails ");
			}

			buffer.append("delete from C_ST_InventoryTemp ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_InventoryTemp inner join B_Warehouse on C_ST_IT_InStockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_InventoryTempEntry where C_ST_IET_BillID not in (select C_ST_IT_BillID from C_ST_InventoryTemp) ");
				
			}else{
				buffer.append("delete from C_ST_InventoryTempEntry ");
			}

			buffer.append("delete from C_ST_Inventory ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_Inventory inner join B_Warehouse on C_ST_I_InStockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where C_ST_I_BillID like 'CPIN%' and B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID like 'CPIN%' and C_ST_IE_BillID not in (select C_ST_I_BillID from C_ST_Inventory) ");
				
			}else{
				buffer.append("where C_ST_I_BillID like 'CPIN%' ");
				buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID like 'CPIN%' ");
			}			
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill16()))){
			buffer.append("delete from C_ST_ProcurementCheck ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_ProcurementCheck inner join B_Warehouse on C_ST_PC_InStockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_ProcurementCheckEntry where C_ST_POE_BillID not in (select C_ST_PC_BillID from C_ST_ProcurementCheck) ");
				
			}else{
				buffer.append("delete from C_ST_ProcurementCheckEntry ");
			}			
		}
		
		buffer.append("delete from C_ST_PurchaseBill ");
		buffer.append("delete from C_ST_PurchaseCompare ");
		buffer.append("delete from C_ST_PurchaseEntry ");
		
		if (!"".equals(Utility.getName(ppo.getPbcbill41()))){
			buffer.append("delete from C_ST_StoreTakeGoods ");
			buffer.append("delete from C_ST_StoreTakeGoodsEntry ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill17()))){
			buffer.append("delete from C_ST_TakeInventory ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from C_ST_TakeInventory inner join B_Warehouse on C_ST_I_OutStockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from C_ST_TakeInventoryBarCode where C_ST_IB_BillID not in (select C_ST_I_BillID from C_ST_TakeInventory) ");
				buffer.append("delete from C_ST_TakeInventoryEntry where C_ST_IE_BillID not in (select C_ST_I_BillID from C_ST_TakeInventory) ");
				
			}else{
				buffer.append("delete from C_ST_TakeInventoryBarCode ");
				buffer.append("delete from C_ST_TakeInventoryEntry ");	
			}		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill18()))){
			buffer.append("delete from M_Trac ");
			buffer.append("delete from M_TracBarCode ");
			buffer.append("delete from M_TracEntry ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill19()))){
			buffer.append("delete from L_AT_AutoCostAccount ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  where L_AT_CA_CompanyID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from L_CT_CurrentMonthCostingTemp ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  where L_CT_CT_CompanyID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from L_CT_HistoryCostingTemp ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  where L_CT_CT_CompanyID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from L_I_Invoice ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from L_I_Invoice inner join B_Departments on L_I_I_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from L_IE_InvoiceEntry where L_IE_IE_InvoiceID not in (select L_I_I_ID from L_I_Invoice) ");
				
			}else{
				buffer.append("delete from L_IE_InvoiceEntry ");
			}			
		
			buffer.append("delete from L_PB_PB_PaymentBill ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from L_PB_PB_PaymentBill inner join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from L_PB_PBE_PaymentBillEntry where L_PB_PBE_BillID not in (select L_PB_PB_ID from L_PB_PB_PaymentBill) ");
				
			}else{
				buffer.append("delete from L_PB_PBE_PaymentBillEntry ");
			}			
			
			buffer.append("delete from L_R_Reversal ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from L_R_Reversal inner join B_Departments on L_I_R_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from L_RE_ReversalEntry where L_IE_RE_InvoiceID not in (select L_I_R_ID from L_R_Reversal) ");
				
			}else{
				buffer.append("delete from L_RE_ReversalEntry ");
			}
			
			buffer.append("delete from L_SC_SupplierAccount ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  where L_SC_SA_BillID in ( ");
				
				buffer.append("select C_ST_I_BillID ");
				buffer.append("  from ( ");
				buffer.append("	select C_ST_I_BillID ");
				buffer.append("	  from C_ST_Inventory  ");
				buffer.append("		   left join B_Warehouse on C_ST_I_InStockId = B_WH_ID  ");
				buffer.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
				buffer.append("	  where C_ST_I_BillTypeId in ('1','9') ");
				buffer.append("			and B_DP_CompanysID = ? ");
				buffer.append("	union ");
				buffer.append("	select C_ST_I_BillID ");
				buffer.append("	  from C_ST_Inventory  ");
				buffer.append("		   left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID  ");
				buffer.append("		   left join B_Departments on B_WH_deptID = B_DP_DepartmentID  ");
				buffer.append("	  where C_ST_I_BillTypeId = '2' ");
				buffer.append("			and B_DP_CompanysID = ? ");				
				buffer.append("	union ");
				buffer.append("	select L_PB_PB_ID ");
				buffer.append("	  from L_PB_PB_PaymentBill ");
				buffer.append("		   left join B_Departments on L_PB_PB_DepartmentID = B_DP_DepartmentID  ");
				buffer.append("	  where B_DP_CompanysID = ? ");
				buffer.append("  )m ");
				
				buffer.append("  ) ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));	
				params.add(Utility.getName(ppo.getPbccompanyid()));	
				params.add(Utility.getName(ppo.getPbccompanyid()));	
	
			}
						
			buffer.append("delete from L_V_Voucher ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from L_V_Voucher inner join B_Departments on L_V_V_CreateDptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from L_VE_VoucherEntry where L_VE_VE_VoucherID not in (select L_V_V_ID from L_V_Voucher) ");
				buffer.append("delete from L_VT_VoucherTally where L_VT_VT_VoucherID not in (select L_V_V_ID from L_V_Voucher) ");
				
			}else{
				buffer.append("delete from L_VE_VoucherEntry ");
				buffer.append("delete from L_VT_VoucherTally ");
			}	

		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill20()))){
			buffer.append("delete from M_AttendanceManage ");
//			buffer.append("delete from M_CompensationTemplate ");
//			buffer.append("delete from M_Education ");
			buffer.append("delete from M_EmergencyContact ");
			buffer.append("delete from M_MonthWage ");
			buffer.append("delete from M_PersonEducation ");
			buffer.append("delete from M_PersonFamily ");
			buffer.append("delete from M_PersonnelChange ");
			buffer.append("delete from M_PersonWork ");
//			buffer.append("delete from M_Post ");
			buffer.append("delete from M_RewardsAndPenalties ");
			buffer.append("delete from M_Salary ");
			buffer.append("delete from M_SchedulingDay ");
			buffer.append("delete from M_SchedulingMonth ");
			buffer.append("delete from M_SchedulingPerson ");
			buffer.append("delete from M_SchedulingPersonDay ");
//			buffer.append("delete from M_ShiftMaintain ");
			buffer.append("delete from M_Train ");
//			buffer.append("delete from M_TrainContent ");
//			buffer.append("delete from M_TrainLevel ");
			buffer.append("delete from M_TrainResults ");
			buffer.append("delete from M_Wage ");
//			buffer.append("delete from M_Workage ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill21()))){       // 验光
			buffer.append("delete from S_OP_DoubleEyeFunction ");
			buffer.append("delete from S_OP_EyesCheck ");
			buffer.append("delete from S_OP_EyesPhotoLog ");
			buffer.append("delete from S_OP_HealthCheck ");
			buffer.append("delete from S_OP_HisInfo ");
			buffer.append("delete from S_OP_Inspection ");
			buffer.append("delete from S_OP_Mydriasis ");
			buffer.append("delete from S_OP_Optometry ");
			buffer.append("delete from S_OP_OptometryBasic ");
			buffer.append("delete from S_OP_Refractive ");
			buffer.append("delete from S_OP_ContactGlass ");
			buffer.append("delete from S_OP_CornealContactlLens ");
			buffer.append("delete from S_OP_EyesGroupPhoto ");
			buffer.append("delete from S_OP_EyesGroupPhotoLog ");
			buffer.append("delete from S_OP_RefractiveTemp ");
			buffer.append("delete from S_OP_Yanji ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill22()))){
			buffer.append("delete from F_IntegralExchangeLog ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from F_IntegralExchangeLog inner join B_Warehouse on F_IL_OutStockID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from F_IntegralExchangeLogEntry where F_ILE_UUID not in (select F_IL_UUID from F_IntegralExchangeLog) ");
				
			}else{
				buffer.append("delete from F_IntegralExchangeLogEntry ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill23()))){
			buffer.append("delete from P_PC_PerCustomer ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from P_PC_PerCustomer inner join B_Departments on R_PC_DGM_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_casher_AppendArrears ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_casher_AppendArrears inner join B_Departments on R_CQT_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_casherQTOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_casherQTOnlyStore inner join B_Departments on R_CQT_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_DS_CA_CustomerFlow ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_DS_CA_CustomerFlow inner join B_Departments on R_DS_CA_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_FD_SalesGuide ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_FD_SalesGuide inner join B_Departments on R_FD_SG_DepartmentID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_firstCheckOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_firstCheckOnlyStore inner join B_Departments on R_FC_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_getBackEyeglassPersonOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_getBackEyeglassPersonOnlyStore inner join B_Departments on R_BEP_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_GS_RR_GoodsStorageRevolveRate ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_GS_RR_GoodsStorageRevolveRate inner join B_Warehouse on R_GS_RR_WarehouseID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_GS_BrandStorageRevolveRate ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_GS_BrandStorageRevolveRate inner join B_Warehouse on R_GS_BR_WarehouseID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_GS_RR_GoodsStorageRevolveRateByBill ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_GS_RR_GoodsStorageRevolveRateByBill inner join B_Warehouse on R_GS_RR_WarehouseID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_GS_BrandStorageRevolveRateByBill ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_GS_BrandStorageRevolveRateByBill inner join B_Warehouse on R_GS_BR_WarehouseID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_inspectPersonOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_inspectPersonOnlyStore inner join B_Departments on R_IP_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_optometryOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_optometryOnlyStore inner join B_Departments on R_O_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_processWorkingStatisticsOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_processWorkingStatisticsOnlyStore inner join B_Departments on R_FWS_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_RC_DayBrandSalesEntry ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_RC_DayBrandSalesEntry inner join B_Departments on R_RC_DE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_RC_DayBrandSalesEntry_AppendArrears ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_RC_DayBrandSalesEntry_AppendArrears inner join B_Departments on R_RC_DEA_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_RC_DaySalesEntry ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_RC_DaySalesEntry inner join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_RC_DaySalesEntry_AppendArrears ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_RC_DaySalesEntry_AppendArrears inner join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_RC_DaySalesEntry_ZZ ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_RC_DaySalesEntry_ZZ inner join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_RC_DaySalesEntry_ZZ_AppendArrears ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_RC_DaySalesEntry_ZZ_AppendArrears inner join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_registrationDeskOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_registrationDeskOnlyStore inner join B_Departments on R_RD_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_salesPerson_AppendArrears ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_salesPerson_AppendArrears inner join B_Departments on R_SPQT_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_salesPersonQTOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_salesPersonQTOnlyStore inner join B_Departments on R_SPQT_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_SD_DayCollect ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_SD_DayCollect inner join B_Departments on R_SD_DC_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_SD_DayCollect_AppendArrears ");	
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_SD_DayCollect_AppendArrears inner join B_Departments on R_SD_DC_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_SD_DayCollectAreaEntry ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_SD_DayCollectAreaEntry inner join B_Departments on R_SD_DCAE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_SD_DayCollectEntry ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_SD_DayCollectEntry inner join B_Departments on R_SD_DCE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_SD_DaySalesPriceAreaEntry ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_SD_DaySalesPriceAreaEntry inner join B_Departments on R_SD_DCAE_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from R_sendMaterialOnlyStore ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from R_sendMaterialOnlyStore inner join B_Departments on R_SM_OS_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill24()))){
			buffer.append("delete from S_CR_RegisteredDetails ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_CR_RegisteredDetails inner join B_Departments on S_CR_RD_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from S_SE_SalesLog where S_SE_SL_Type = '2' and S_SE_SL_SalesID not in (select distinct S_CR_RD_DetailsID from S_CR_RegisteredDetails) ");
				buffer.append("delete from S_SE_SalesCrossLog where S_SE_SL_Type = '2' and S_SE_SL_SalesID not in (select distinct S_CR_RD_DetailsID from S_CR_RegisteredDetails) ");
				
			}else{
				buffer.append("delete from S_SE_SalesLog where S_SE_SL_Type = '2' ");
				buffer.append("delete from S_SE_SalesCrossLog  where S_SE_SL_Type = '2' ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill25()))){
			buffer.append("delete from S_CR_RepairsCostDetails ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_CR_RepairsCostDetails inner join B_Departments on S_CR_RD_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from S_SE_SalesLog where S_SE_SL_Type = '3' and S_SE_SL_SalesID not in (select distinct S_CR_RD_DetailsID from S_CR_RepairsCostDetails) ");

			}else{
				buffer.append("delete from S_SE_SalesLog where S_SE_SL_Type = '3' ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill26()))){
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){

				buffer.append("select S_SE_SB_SalesID into #salesbill from uview_SalesBasic inner join B_Departments on S_SE_SB_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from S_SE_SalesBasic where S_SE_SB_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SalesBasic_Finished where S_SE_SB_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_SE_SalesBasic_Today where S_SE_SB_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");			
				buffer.append("delete from S_DN_DistributionEntry where S_DN_DE_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_InTransit where S_SE_IT_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_AdditionalCDetail where S_SE_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SalesDetail where S_SE_SD_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SalesDetail_Today where S_SE_SD_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SalesLog where S_SE_SL_Type = '1' and S_SE_SL_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SpecialPDetail where S_SE_SD_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SS_SalesSpecial where S_SE_SS_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_ToMail where S_SE_TM_LinkSalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_Se_Customize where s_se_c_salesid in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_Se_CustomizeTui where s_se_c_salesid in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_SE_Sales_TakeMsg where S_SE_ST_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_SE_SalesCrossLog where S_SE_SL_Type = '1' and S_SE_SL_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_SE_SalesDetail_Finished where S_SE_SD_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				buffer.append("delete from S_SE_SalerCashierRecord where S_SE_SCR_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_SE_SalerCashierRecord_AppendArrears where S_SE_SCR_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from P_CH_Check where P_CH_CK_SalesId in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from P_CH_FirstCheck where P_CH_FCK_SalesId in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from P_CH_GlassesCheck where P_CH_GC_SalesId in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from P_CH_SamplingCheck where P_CH_SK_SalesId in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_ME_DelayNotice where S_ME_DN_SalesID in (select S_SE_SB_SalesID from #salesbill)  ");
				buffer.append("delete from S_SE_DelaysReminder where S_SE_DR_SalesID in (select S_SE_SB_SalesID from #salesbill) ");
				
				buffer.append("drop table #salesbill ");
				
				buffer.append("delete from S_DN_Distribution where S_DN_DN_ID not in (select distinct S_DN_DE_DistributionID from S_DN_DistributionEntry) ");
				
			}else{
				buffer.append("delete from S_SE_SalesBasic ");
				buffer.append("delete from S_SE_SalesBasic_Finished ");
				buffer.append("delete from S_SE_SalesBasic_Today ");				
				buffer.append("delete from S_DN_Distribution ");
				buffer.append("delete from S_DN_DistributionEntry ");
				buffer.append("delete from S_SE_InTransit ");
				buffer.append("delete from S_SE_AdditionalCDetail ");
				buffer.append("delete from S_SE_SalesDetail ");
				buffer.append("delete from S_SE_SalesDetail_Today ");
				buffer.append("delete from S_SE_SalesLog where S_SE_SL_Type = '1' ");
				buffer.append("delete from S_SE_SpecialPDetail ");
				buffer.append("delete from S_SE_SS_SalesSpecial ");
				buffer.append("delete from S_SE_ToMail ");
				buffer.append("delete from S_Se_Customize ");
				buffer.append("delete from S_Se_CustomizeTui ");
				buffer.append("delete from S_SE_Sales_TakeMsg ");
				buffer.append("delete from S_SE_SalesCrossLog where S_SE_SL_Type = '1' ");
				buffer.append("delete from S_SE_SalesDetail_Finished ");
				buffer.append("delete from S_SE_SalerCashierRecord ");
				buffer.append("delete from S_SE_SalerCashierRecord_AppendArrears ");
				buffer.append("delete from P_CH_Check ");
				buffer.append("delete from P_CH_FirstCheck ");
				buffer.append("delete from P_CH_GlassesCheck ");
				buffer.append("delete from P_CH_SamplingCheck ");
				buffer.append("delete from S_ME_DelayNotice ");
				buffer.append("delete from S_SE_DelaysReminder ");
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill27()))){			
			buffer.append("delete from S_SE_PreDep ");              // 门店计划销售完成额度统计表			
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_SE_PreDep inner join B_Departments on S_SE_DepId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from S_SE_PlanBrand where S_SE_PlanDepId not in (select S_SE_PlanDepId from S_SE_PreDep) ");           // 门店计划销售完成额度统计表			
				buffer.append("delete from S_SE_PrePlans where S_SE_PlanId not in (select S_SE_PlanId from S_SE_PreDep) ");            // 门店计划销售完成额度统计表	
				
			}else{
				buffer.append("delete from S_SE_PlanBrand ");           // 门店计划销售完成额度统计表			
				buffer.append("delete from S_SE_PrePlans ");            // 门店计划销售完成额度统计表	
			}
			
			buffer.append("delete from S_SE_PreSales ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_SE_PreSales inner join B_Departments on S_SE_DepartmentId = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
			
			buffer.append("delete from S_SE_PreShopSales ");        // 业绩进度表按门店设置    主表
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_SE_PreShopSales inner join B_Departments on S_SE_PS_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from S_SE_PreShopSalesEntry where S_SE_PSE_PreID not in (select S_SE_PS_ID from S_SE_PreShopSales) ");   // 业绩进度表按门店设置    明细表

			}else{
				buffer.append("delete from S_SE_PreShopSalesEntry ");   // 业绩进度表按门店设置    明细表
			}			
			
			buffer.append("delete from S_SE_PrePersonSales ");        // 业绩进度表按员工设置    主表
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_SE_PrePersonSales inner join B_Departments on S_SE_PS_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
				
				buffer.append("delete from S_SE_PrePersonSalesEntry where S_SE_PSE_PreID not in (select S_SE_PS_ID from S_SE_PrePersonSales) ");   // 业绩进度表按员工设置    明细表

			}else{
				buffer.append("delete from S_SE_PrePersonSalesEntry ");   // 业绩进度表按员工设置    明细表
			}
			
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill28()))){      // 无库存销售
			buffer.append("delete from S_SE_PreSalesS ");
			if (!"".equals(Utility.getName(ppo.getPbccompanyid()))){
				buffer.append("  from S_SE_PreSalesS inner join B_Departments on S_SE_PS_ShopCode = B_DP_DepartmentID ");
				buffer.append("  where B_DP_CompanysID = ? ");
				
				params.add(Utility.getName(ppo.getPbccompanyid()));
			}
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill29()))){
			buffer.append("update S_ME_CustomerInfo set S_ME_CI_ConsumptionNumber=0,S_ME_CI_ConsumptionPrice=0,S_ME_CI_Integral=0 ");
			buffer.append("delete from S_ME_IntegralAddandSub ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill30()))){
			buffer.append("delete from S_ME_CustomerComplain ");
			buffer.append("delete from S_ME_CustomerComplainHandle ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill31()))){
			buffer.append("delete from S_ME_CustomerVisit ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill32()))){
			buffer.append("delete from S_ME_IntegralAddandSub ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill33()))){
			buffer.append("delete from S_ME_CustomerUpgrade ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill34()))){
			buffer.append("delete from S_SM_SetMeal ");
			buffer.append("delete from S_SM_SetMealEntry ");
			buffer.append("delete from S_SM_SetMealRecord ");
			buffer.append("delete from S_SM_SetMealRecordEntry ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill35()))){
			buffer.append("delete from C_ST_Chuzhika ");
//			buffer.append("delete from C_ST_ChuzhikaLog ");
			buffer.append("delete from S_ME_ChuAddandSub ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill36()))){
			buffer.append("delete from S_SE_VIPCard ");
			buffer.append("delete from S_SE_VIPCardDetails ");
			buffer.append("delete from S_SE_VIPGoodsBind ");
			buffer.append("delete from F_DiscountShortcutKeys ");
			buffer.append("delete from F_DiscountShortcutKeysDetails ");			
			buffer.append("update S_SE_SalesDetail set S_SE_SD_VipCard = '' ");
			buffer.append("update S_SE_SalesDetail_Finished set S_SE_SD_VipCard = '' ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill37()))){
			buffer.append("delete from F_SmsRecord ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill38()))){
			buffer.append("delete from L_LogisticsLog ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill39()))){
			buffer.append("delete from W_AutoReply ");
			buffer.append("delete from W_CMS_Content ");
			buffer.append("delete from W_CMS_Type ");
//			buffer.append("delete from W_Configuration ");
			buffer.append("delete from W_DailyAttendance ");
			buffer.append("delete from W_DailyAttendanceLog ");
			buffer.append("delete from W_DepartmentPic ");
			buffer.append("delete from W_Doctor ");
			buffer.append("delete from W_IntegralExchange ");
			buffer.append("delete from W_IntegralExchangeLog ");
			buffer.append("delete from W_LuckDraw ");
			buffer.append("delete from W_LuckDrawLog ");
			buffer.append("delete from W_LuckDrawSet ");
			buffer.append("delete from W_MakeAnAppointment ");
//			buffer.append("delete from W_Menu_Config ");
//			buffer.append("delete from W_Menu_CreateReturnCode ");
//			buffer.append("delete from W_Menu_Type ");
			buffer.append("delete from W_OptometryAppointment ");
			buffer.append("delete from W_StoredValueCardFlag ");
		}

		buffer.append("delete from SYS_BillKey ");

		if (!"".equals(Utility.getName(ppo.getPbcbill9())) && !"".equals(Utility.getName(ppo.getPbcbill8())) && !"".equals(Utility.getName(ppo.getPbcbill13())) && !"".equals(Utility.getName(ppo.getPbcbill14()))){  // 调拨申请、调拨、采购订单、采购收货单
			buffer.append("update C_SHA_Status set C_SHA_StatusReceiptID = NULL where C_SHA_StatusReceiptID not in (select C_ST_I_BillID from C_ST_Inventory where C_ST_I_BillTypeId = '1' ) ");
			buffer.append("update C_SHA_Status set C_SHA_StatusOrderID = NULL where C_SHA_StatusOrderID not in (select C_ST_P_ID from C_ST_PO) ");
			buffer.append("update C_SHA_Status set C_SHA_StatusBillID = NULL where C_SHA_StatusBillID not in (select C_ST_I_BillID from C_ST_Inventory where C_ST_I_BillTypeId = '4' ) ");
			buffer.append("update C_SHA_Status set C_SHA_StatusApplyBillID = NULL where C_SHA_StatusApplyBillID not in (select C_SHA_AA_billID from C_SHA_ApplyAllocation) ");
			
			buffer.append("delete from C_SHA_Status where C_SHA_StatusReceiptID = NULL and C_SHA_StatusOrderID = NULL and C_SHA_StatusBillID = NULL and C_SHA_StatusApplyBillID = NULL ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill13())) && !"".equals(Utility.getName(ppo.getPbcbill14()))){  // 采购订单、采购收货单
			buffer.append("delete from C_ST_Verification where C_ST_V_PinID not in (select C_ST_I_BillID from C_ST_Inventory) ");
			buffer.append("delete from C_ST_Verification where C_ST_V_PoID not in (select C_ST_P_ID from C_ST_PO) ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill42()))){
			buffer.append("delete from L_CF_ClearingForm ");	
			buffer.append("delete from L_FA_DA_DealingsAccounts ");
			buffer.append("delete from L_FA_RM_ReceiptMentBill ");
			buffer.append("delete from L_FA_ME_ReceiptMentEntry ");
			buffer.append("delete from L_I_Inventory ");
			buffer.append("delete from L_IE_InventoryEntry ");			
			buffer.append("delete from L_IO_IO_InOrOutComeType ");
			buffer.append("delete from L_KB_K3Bill ");
			buffer.append("delete from L_SC_SupplierDeliver ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill43()))){        // 商品销售统计表和商品进销存报表
			buffer.append("delete from R_ST_GoodsSalesAnalysis ");
			buffer.append("delete from R_ST_GoodsSalesAnalysisEntry ");
			buffer.append("delete from R_IO_GoodsInOrOutByDpt ");
			buffer.append("delete from R_IO_GoodsInOrOutAll ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill44()))){        // 会员信息
			buffer.append("delete from S_ME_CustomerInfo ");
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}
	
    /**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertStorageGoods_Collect(){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append(" exec usp_collectStorageByType ");
				
		getJdbcTemplate().update(buffer.toString());
	}
	
    /**
	 * 删除商品库存
	 * 
	 * @param brandPo
	 */
	public void deleteStorageGoods_Log(String warehouseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from C_SH_StorageLog where C_SH_SL_StockId = ? and C_SH_SL_IsExcel = '1' ");		

		params.add(Utility.getName(warehouseid));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 删除商品库存
	 * 
	 * @param brandPo
	 */
	public void deleteStorageGoods_Beginning(String warehouseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from C_SH_StorageBeginning where C_SH_SB_StockId = ? ");
		
		buffer.append(" INSERT INTO C_SH_StorageBeginning ");
		buffer.append("            (C_SH_SB_UUID ");
		buffer.append("            ,C_SH_SB_GoodsBarCode ");
		buffer.append("            ,C_SH_SB_GoodsId ");
		buffer.append("            ,C_SH_SB_StockId ");
		buffer.append("            ,C_SH_SB_GoodsQuantity) ");
		buffer.append(" SELECT newid() ");
		buffer.append("       ,replace(C_SH_SL_GoodsId,'.','') ");
		buffer.append("       ,C_SH_SL_GoodsId ");
		buffer.append("       ,C_SH_SL_StockId ");
		buffer.append("       ,sum(C_SH_SL_GoodsQuantity) ");
		buffer.append("   FROM C_SH_StorageLog ");
		buffer.append("   where convert(varchar(10),C_SH_SL_WarehousingDate,120) < convert(varchar(10),getdate(),120) ");
		buffer.append("         and C_SH_SL_StockId = ? ");
		buffer.append("   group by C_SH_SL_GoodsId,C_SH_SL_StockId ");
		buffer.append("   having sum(C_SH_SL_GoodsQuantity) <> 0 ");

		params.add(Utility.getName(warehouseid));
		params.add(Utility.getName(warehouseid));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 删除商品库存
	 * 
	 * @param brandPo
	 */
	public void deleteStorageGoods_Change(String warehouseid){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" delete from C_SH_StorageChange where C_SH_SC_StockId = ? and C_SH_SC_IsExcel = '1' ");		

		params.add(Utility.getName(warehouseid));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 清空成本计算
	 */
	public void deleteGoodsAvgCost(String companyID,String departmentID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		String[] dptArray = departmentID.split(",");
		
		buffer.append("select C_ST_I_BillID into #bill from ( ");
		buffer.append("	select C_ST_I_BillID  ");		
		buffer.append("	  from C_ST_Inventory inner join B_Departments on C_ST_I_DepartmentId = B_DP_DepartmentID ");		
		buffer.append("	  where C_ST_I_BillTypeId in ('3') ");	
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and B_DP_CompanysID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
//		if (!"".equals(Utility.getName(departmentID))){
//	        buffer.append("  and B_DP_DepartmentID in ( ? ");
//	        params.add(Utility.getName(dptArray[0]));
//	        
//	        for (int i = 1; i < dptArray.length; i++){
//		        buffer.append("  ,? ");
//		        params.add(Utility.getName(dptArray[i]));
//	        }
//	        
//	        buffer.append("  ) ");
//		}
		
		buffer.append("	union all ");		
		buffer.append("	select C_ST_I_BillID  ");
		buffer.append("	  from C_ST_Inventory ");
		buffer.append("	  where C_ST_I_BillTypeId in ('4') ");
		buffer.append("	union all ");
		buffer.append("	select C_ST_I_BillID  ");
		buffer.append("	  from C_ST_Inventory inner join B_Warehouse on C_ST_I_OutStockId = B_WH_ID ");
		buffer.append("		   inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("	  where C_ST_I_BillTypeId in ('6','8') ");
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and B_DP_CompanysID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
//		if (!"".equals(Utility.getName(departmentID))){
//	        buffer.append("  and B_DP_DepartmentID in ( ? ");
//	        params.add(Utility.getName(dptArray[0]));
//	        
//	        for (int i = 1; i < dptArray.length; i++){
//		        buffer.append("  ,? ");
//		        params.add(Utility.getName(dptArray[i]));
//	        }
//	        
//	        buffer.append("  ) ");
//		}
		
		buffer.append("	union all ");		
		buffer.append("	select C_ST_I_BillID  ");	
		buffer.append("	  from C_ST_Inventory inner join B_Warehouse on C_ST_I_InStockId = B_WH_ID ");
		buffer.append("		   inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");		
		buffer.append("	  where C_ST_I_BillTypeId = '5' ");		
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and B_DP_CompanysID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
//		if (!"".equals(Utility.getName(departmentID))){
//	        buffer.append("  and B_DP_DepartmentID in ( ? ");
//	        params.add(Utility.getName(dptArray[0]));
//	        
//	        for (int i = 1; i < dptArray.length; i++){
//		        buffer.append("  ,? ");
//		        params.add(Utility.getName(dptArray[i]));
//	        }
//	        
//	        buffer.append("  ) ");
//		}
		
		buffer.append(")t ");		

		buffer.append("update C_ST_Inventory set C_ST_I_IsFillCostPrice = '0' ");
		buffer.append("  where C_ST_I_BillID in (select C_ST_I_BillID from #bill) ");		
	
		buffer.append("update C_ST_InventoryEntry set C_ST_IE_AverageNotTaxRate = 0,C_ST_IE_AverageNotTaxRateAmount = 0 ");		
		buffer.append("  where C_ST_IE_BillID in (select C_ST_I_BillID from #bill) ");	

		buffer.append("drop table #bill ");		

		buffer.append("delete from L_CT_HistoryCostingTemp where 1 = 1 ");
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and L_CT_CT_CompanyID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
//		if (!"".equals(Utility.getName(departmentID))){
//	        buffer.append("  and L_CT_CT_DepartmentID in ( ? ");
//	        params.add(Utility.getName(dptArray[0]));
//	        
//	        for (int i = 1; i < dptArray.length; i++){
//		        buffer.append("  ,? ");
//		        params.add(Utility.getName(dptArray[i]));
//	        }
//	        
//	        buffer.append("  ) ");
//		}
		
		buffer.append("update B_GoodsInfo set B_GI_AverageNotTaxRate = 0 ");
		
		buffer.append("update B_GoodsAveragePrice set B_GA_AverageNotTaxRate = 0 where 1 = 1 ");	
		
		if (!"".equals(Utility.getName(companyID))){
	        buffer.append("  and B_GA_CompanyID = ? ");
	        params.add(Utility.getName(companyID));
		}
		
//		if (!"".equals(Utility.getName(departmentID))){
//	        buffer.append("  and B_GA_DepartmentID in ( ? ");
//	        params.add(Utility.getName(dptArray[0]));
//	        
//	        for (int i = 1; i < dptArray.length; i++){
//		        buffer.append("  ,? ");
//		        params.add(Utility.getName(dptArray[i]));
//	        }
//	        
//	        buffer.append("  ) ");
//		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
    /**
	 * 新增试用数据日志
	 */
	public void insertPeriodBeginDataLog(PeriodBeginClearPo ppo){
		
		StringBuffer buffer = new StringBuffer();
		StringBuffer val = new StringBuffer();
		List<String> params = new ArrayList<String>();		
		
		buffer.append("insert into L_ClearBeginDataLog (L_CB_DL_ID,L_CB_DL_OpDate,L_CB_DL_PersonID,L_CB_DL_DepartmentID,L_CB_DL_LogContent) values (?,getdate(),?,?,?)  ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(ppo.getPbcoppersonid()));
		params.add(Utility.getName(ppo.getPbcdepartmentid()));
		
		if (!"".equals(Utility.getName(ppo.getPbcbill1()))){
			val.append("含税成本调价单、 ");
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill2()))){
			val.append("零售价调价单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill3()))){
			val.append("批发价调价单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill4()))){
			val.append("库存预警设置、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill5()))){
			val.append("在途库存、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill6()))){
			val.append("盘点单、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill7()))){
			val.append("盈亏分析单、 ");			
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill8()))){
			val.append("调拨单、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill9()))){
			val.append("调拨申请单、 ");			
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill10()))){
			val.append("批发申请单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill11()))){
			val.append("不合格品单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill12()))){
			val.append("委外订单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill13()))){
			val.append("采购订单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill14()))){
			val.append("业务单据、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill15()))){
			val.append("委外收货单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill16()))){
			val.append("收货检验记录、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill17()))){
			val.append("领用出库单、 ");				
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill18()))){
			val.append("客户批发调货单和客户批发退货单、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill19()))){
			val.append("财务（应付）、 ");		
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill20()))){
			val.append("人事、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill21()))){
			val.append("验光、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill22()))){
			val.append("积分兑换单、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill23()))){
			val.append("时英、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill24()))){
			val.append("挂号费、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill25()))){
			val.append("维修费、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill26()))){
			val.append("销售、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill27()))){
			val.append("业绩进度、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill28()))){
			val.append("业绩进度表设置、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill29()))){
			val.append("会员积分、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill30()))){
			val.append("会员投诉记录、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill31()))){
			val.append("会员回访记录、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill32()))){
			val.append("会员积分变更记录、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill33()))){
			val.append("会员升级记录、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill34()))){
			val.append("套餐、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill35()))){
			val.append("储值卡、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill36()))){
			val.append("打折卡、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill37()))){
			val.append("短信记录、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill38()))){
			val.append("操作日志、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill39()))){
			val.append("微信、 ");	
		}		
		
		if (!"".equals(Utility.getName(ppo.getPbcbill40()))){
			val.append("库存、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill41()))){
			val.append("客户批发导入单、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill42()))){
			val.append("财务（应收）、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill43()))){
			val.append("商品销售统计报表、商品进销存报表数据、 ");	
		}
		
		if (!"".equals(Utility.getName(ppo.getPbcbill44()))){
			val.append("会员信息、 ");	
		}

		val.append("正在操作的单据 ");

		params.add(Utility.getName(val.toString()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}
	
    /**
	 * 查看试用数据
	 */
	public List<PeriodBeginClearPo> selectPeriodBeginData(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by L_CB_DL_OpDate) as rowNum, ");
		buffer.append(" isnull(personName,'') as pbcoppersonname,convert(varchar(16),L_CB_DL_OpDate,120) as pbcopdate,isnull(B_DP_DepartmentName,'') as pbcdepartmentname,L_CB_DL_LogContent as pbcopcontent ");
		buffer.append(" from L_ClearBeginDataLog ");
		buffer.append(" left join SYS_PersonInfo on L_CB_DL_PersonID = ID ");
		buffer.append(" left join B_Departments on L_CB_DL_DepartmentID = B_DP_DepartmentID ");
		buffer.append(")temp ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), PeriodBeginClearPo.class);
	}
	
    /**
	 * 查询期初成本的总数
	 */
	public int getQccbCount(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(bgiqcid) from ( ");
		buffer.append("select L_CT_CT_ID as bgiqcid,L_CT_CT_Date as bgiqcdate,B_GC_GoodsCategoryName as bgigoodscategoryname,B_SP_SupplierName as bgisuppliername, ");
		buffer.append("       B_BD_brandName as bgibrandname,B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname, ");
		buffer.append("       isnull(F_CN_Name,'') as bgicompanyname,isnull(B_DP_DepartmentName,'') as bgidepartmentname, ");
		buffer.append("       L_CT_CT_GoodsQuantity as bgiqcnum ");
		
		if ("1".equals(Utility.getName(po.getBgiqcpricetype()))){
			buffer.append("  ,L_CT_CT_Goodsnottaxrateamount as bgiqcaouumt ");
		}else{
			buffer.append("  ,L_CT_CT_GoodsRateamount as bgiqcaouumt ");
		}
		
		buffer.append("  from L_CT_CostingTemplate  ");
		buffer.append("       left join B_GoodsInfo on L_CT_CT_GoodsID = B_GI_GoodsID ");
		buffer.append("       left join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("       left join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("       left join B_Brand on B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		buffer.append("       left join B_Departments on L_CT_CT_DepartmentID = B_DP_DepartmentID ");
		buffer.append("       left join F_CompanyName on L_CT_CT_CompanyID = F_CN_ID ");
		buffer.append("  where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			buffer.append("  and L_CT_CT_GoodsID like ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));			
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			buffer.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgidepartmentid()))){
			buffer.append("  and L_CT_CT_DepartmentID = ? ");
			params.add(Utility.getName(po.getBgidepartmentid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
			buffer.append("  and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append(" )temp ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
    /**
	 * 查询期初成本的列表
	 */
	public List<GoodsInfoPo> getQccbList(GoodsInfoPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() Over(order by bgigoodsid) as rowNum,* from (  ");
		buffer.append("select L_CT_CT_ID as bgiqcid,L_CT_CT_Date as bgiqcdate,B_GC_GoodsCategoryName as bgigoodscategoryname,B_SP_SupplierName as bgisuppliername, ");
		buffer.append("       B_BD_brandName as bgibrandname,L_CT_CT_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname, ");
		buffer.append("       isnull(F_CN_Name,'') as bgicompanyname,isnull(B_DP_DepartmentName,'') as bgidepartmentname, ");
		buffer.append("       L_CT_CT_GoodsQuantity as bgiqcnum ");
		
		if ("1".equals(Utility.getName(po.getBgiqcpricetype()))){
			buffer.append("  ,L_CT_CT_Goodsnottaxrateamount as bgiqcaouumt ");
		}else{
			buffer.append("  ,L_CT_CT_GoodsRateamount as bgiqcaouumt ");
		}
		
		buffer.append("  from L_CT_CostingTemplate  ");
		buffer.append("       left join B_GoodsInfo on L_CT_CT_GoodsID = B_GI_GoodsID ");
		buffer.append("       left join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("       left join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("       left join B_Brand on B_GI_SupplierID = B_BD_SupplierID and B_GI_BrandID = B_BD_ID ");
		buffer.append("       left join B_Departments on L_CT_CT_DepartmentID = B_DP_DepartmentID ");
		buffer.append("       left join F_CompanyName on L_CT_CT_CompanyID = F_CN_ID ");
		buffer.append("  where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			buffer.append("  and L_CT_CT_GoodsID like ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));			
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			buffer.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgidepartmentid()))){
			buffer.append("  and L_CT_CT_DepartmentID = ? ");
			params.add(Utility.getName(po.getBgidepartmentid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
			buffer.append("  and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append(") temp ) temp where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
    /**
	 * 查询商品的期初成本
	 */
	public GoodsInfoPo getQccbDetail(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 L_CT_CT_ID as bgiqcid,L_CT_CT_Date as bgiqcdate,");
		buffer.append("       B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname, ");
		buffer.append("       isnull(F_CN_Name,'') as bgicompanyname,isnull(B_DP_DepartmentName,'') as bgidepartmentname, ");
		buffer.append("       L_CT_CT_GoodsQuantity as bgiqcnum ");
		
		if ("1".equals(Utility.getName(po.getBgiqcpricetype()))){
			buffer.append("  ,L_CT_CT_Goodsnottaxrateamount as bgiqcaouumt ");
		}else{
			buffer.append("  ,L_CT_CT_GoodsRateamount as bgiqcaouumt ");
		}
		
		buffer.append("  from L_CT_CostingTemplate  ");
		buffer.append("       left join B_GoodsInfo on L_CT_CT_GoodsID = B_GI_GoodsID ");
		buffer.append("       left join B_Departments on L_CT_CT_DepartmentID = B_DP_DepartmentID ");
		buffer.append("       left join F_CompanyName on L_CT_CT_CompanyID = F_CN_ID ");
		buffer.append("  where L_CT_CT_ID = ? ");
		
		params.add(Utility.getName(po.getBgiqcid()));
		
		return (GoodsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
    /**
	 * 修改商品的期初成本
	 */
	public void updateQccb(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" update top (1) L_CT_CostingTemplate set L_CT_CT_GoodsQuantity = ?, ");
		
		if ("1".equals(Utility.getName(po.getBgiqcpricetype()))){
			buffer.append("  L_CT_CT_Goodsnottaxrateamount = ? ");
		}else{
			buffer.append("  L_CT_CT_GoodsRateamount = ? ");
		}
		
		buffer.append("  where L_CT_CT_ID = ? ");
		
		params.add(Utility.getName(po.getBgiqcnum()));
		params.add(Utility.getName(po.getBgiqcaouumt()));
		params.add(Utility.getName(po.getBgiqcid()));
				
		buffer.append(" update top (1) L_CT_CostingTemplate set ");
		
		if ("0".equals(Utility.getName(po.getBgiqcnum()))){
			buffer.append(" L_CT_CT_BackFillTaxRate = 0 ");
			buffer.append(" ,L_CT_CT_BackFillRate = 0 ");
		}else{
			buffer.append(" L_CT_CT_BackFillTaxRate = cast((isnull(L_CT_CT_Goodsnottaxrateamount,0) / L_CT_CT_GoodsQuantity) as numeric(18,6)) ");
			buffer.append(" ,L_CT_CT_BackFillRate = cast((isnull(L_CT_CT_GoodsRateamount,0) / L_CT_CT_GoodsQuantity) as numeric(18,2)) ");
		}
		
		buffer.append("  where L_CT_CT_ID = ? ");
		
		params.add(Utility.getName(po.getBgiqcid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());			
	}
	
    /**
	 * 查询已导入的总成本
	 */
	public GoodsInfoPo getQccbTotal(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select sum(L_CT_CT_GoodsQuantity) as bgiqcnum ");
		
		if ("1".equals(Utility.getName(po.getBgiqcpricetype()))){
			buffer.append("  ,sum(L_CT_CT_Goodsnottaxrateamount) as bgiqcaouumt ");
		}else{
			buffer.append("  ,sum(L_CT_CT_GoodsRateamount) as bgiqcaouumt ");
		}
		
		buffer.append("  from L_CT_CostingTemplate  ");
		buffer.append("       left join B_GoodsInfo on L_CT_CT_GoodsID = B_GI_GoodsID ");
		buffer.append("  where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))){
			buffer.append("  and L_CT_CT_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsid()));			
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))){
			buffer.append("  and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsname()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgidepartmentid()))){
			buffer.append("  and L_CT_CT_DepartmentID = ? ");
			params.add(Utility.getName(po.getBgidepartmentid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
			buffer.append("  and L_CT_CT_CompanyID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		return (GoodsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
    /**
	 * 根据公司ID查询部门的期初时间
	 */
	public String getQcDateByCompany(String companyID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 B_DP_QcDate from B_Departments ");

		if (!"".equals(Utility.getName(companyID))){
			buffer.append(" where B_DP_CompanysID = ?  ");
			params.add(Utility.getName(companyID));	
		}
		
		buffer.append(" order by B_DP_QcDate ");
		
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),params.toArray(),String.class);
	}
	
}
