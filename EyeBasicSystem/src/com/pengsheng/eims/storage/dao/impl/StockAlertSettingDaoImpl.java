/**
 * 
 */
package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.dao.StockAlertSettingDao;
import com.pengsheng.eims.storage.persistence.StockAlertSettingPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class StockAlertSettingDaoImpl extends BaseJdbcDaoSupport implements
		StockAlertSettingDao {

	
	public void deleteStockAlertSetting(StockAlertSettingPo stockAlertSettingPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("DELETE FROM C_SA_StockAlertSetting ");
		buffer.append("WHERE C_SA_SA_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(stockAlertSettingPo.getCsasaid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void delStockAlertSettings(StockAlertSettingPo stockAlertSettingPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("DELETE FROM C_SA_StockAlertSetting ");
		buffer.append("WHERE C_SA_SA_GoodsID IN (");
		buffer.append("SELECT B_GI_GoodsID ");
		buffer.append("FROM B_GoodsInfo ");
		buffer.append("WHERE 1=1 ");

		// 镜片类
		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasasphup())) {
			buffer.append("AND CAST(replace(B_GI_Sph,'+','') AS FLOAT) ");
			buffer.append("between CAST( replace(?,'+','') AS FLOAT) and CAST( replace(?,'+','') AS FLOAT) ");

			buffer.append("AND CAST(B_GI_Cyl AS FLOAT) ");
			buffer.append("between CAST( ? AS FLOAT) AND CAST( ? AS FLOAT) ");

			params.add(stockAlertSettingPo.getCsasasphup());// 下限
			params.add(stockAlertSettingPo.getCsasasphul());// 上限

			params.add(stockAlertSettingPo.getCsasacylup());// 下限
			params.add(stockAlertSettingPo.getCsasacylul());// 上限

		}

		buffer.append("AND B_GI_BrandID = ? ");
		buffer.append("AND B_GI_SupplierID = ? ");

		params.add(stockAlertSettingPo.getCsasabrandid());
		params.add(stockAlertSettingPo.getCsasasupplierid());

		// 镜片类
		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasasphup())) {
			buffer.append("AND B_GI_isCustomize = '0' ");
			buffer.append("AND B_GI_GoodsCategoryID IN (3, 4)) ");
		} else {
			buffer.append("AND B_GI_GoodsCategoryID NOT IN (3, 4)) ");
		}

		buffer.append("AND C_SA_SA_StockID = ?");
		params.add(stockAlertSettingPo.getCsasastockid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	public List<StockAlertSettingPo> getStrockAlerInfo(
			StockAlertSettingPo stockAlertSettingPo, int start, int size) {
		StringBuffer sb = new StringBuffer();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");

		sb.append("select * from(");
		sb.append("SELECT ROW_NUMBER() ");
		sb.append("Over(order by B_GI_GoodsID) as rowNum ");
		sb.append(", C_SA_SA_ID as csasaid ");
		sb.append(", C_SA_SA_GoodsID as csasagoodsid ");
		sb.append(", C_SA_SA_SupplierID as csasasupplierid ");
		sb.append(", C_SA_SA_BrandID as csasabrandid ");
		sb.append(", C_SA_SA_StockID as csasastockid ");
		sb.append(", C_SA_SA_StockCap as csasastockcap ");
		sb.append(", C_SA_SA_StockLower as csasastocklower ");
		sb.append(", B_BD_brandName AS csasabrandname ");
		sb.append(", B_SP_SupplierName AS csasasuppliername ");
		sb.append(", B_GI_ViewGoodsName as csasagoodsname ");
		sb.append(", B_WH_warehouseName as csasawarehousename ");
		sb.append(", C_SA_SA_StockRed as csasastockred ");
		sb.append("FROM C_SA_StockAlertSetting ");
		sb.append("INNER JOIN ");
		sb.append("B_Brand ON C_SA_SA_BrandID = B_BD_ID ");
		sb.append("AND C_SA_SA_SupplierID = B_BD_SupplierID ");
		sb.append("INNER JOIN ");
		sb.append("B_Supplier ON C_SA_SA_SupplierID = B_SP_ID ");
		sb.append("INNER JOIN ");
		sb.append("B_GoodsInfo ON C_SA_SA_GoodsID = B_GI_GoodsID ");
		sb.append("INNER JOIN ");
		sb.append("B_Warehouse ON C_SA_SA_StockID = B_WH_ID ");
		
		if (!"".equals(Utility.getName(stockAlertSettingPo.getCsasacompanyd()))){
		    sb.append(" inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}

		sb.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(stockAlertSettingPo.getCsasacompanyd()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(stockAlertSettingPo.getCsasacompanyd()));	
		}
		
		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasabrandid())) {
			sb.append("AND C_SA_SA_BrandID = ? ");
			params.add(stockAlertSettingPo.getCsasabrandid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasasupplierid())) {
			sb.append("AND C_SA_SA_SupplierID = ? ");
			params.add(stockAlertSettingPo.getCsasasupplierid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasastockid())) {
			sb.append("AND C_SA_SA_StockID = ? ");
			params.add(stockAlertSettingPo.getCsasastockid());
		}
		
		if ("1".equals(Utility.getName(stockAlertSettingPo.getCsasadepartmenttype()))||"2".equals(Utility.getName(stockAlertSettingPo.getCsasadepartmenttype()))) {
			sb.append(" and C_SA_SA_StockID in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(stockAlertSettingPo.getCsasadepartmentid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo
				.getCsasagoodscategoryid())) {
			sb.append("AND B_GI_GoodsCategoryID = ? ");
			params.add(stockAlertSettingPo.getCsasagoodscategoryid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasagoodsid())) {
			sb.append("AND B_GI_GoodsID like '%' + ? + '%' ");//quyanping
			params.add(stockAlertSettingPo.getCsasagoodsid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasagoodsname())) {
			sb.append("AND B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(stockAlertSettingPo.getCsasagoodsname());
		}

		sb.append(") temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				StockAlertSettingPo.class);
	}

	public int getStrockAlerInfoCount(StockAlertSettingPo stockAlertSettingPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT count(C_SA_SA_SupplierID) ");
		sb.append("FROM C_SA_StockAlertSetting ");
		sb.append("INNER JOIN ");
		sb.append("B_GoodsInfo ON C_SA_SA_GoodsID = B_GI_GoodsID ");
		
		if (!"".equals(Utility.getName(stockAlertSettingPo.getCsasacompanyd()))){
		    sb.append(" inner join B_Warehouse on C_SA_SA_StockID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		sb.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(stockAlertSettingPo.getCsasacompanyd()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(stockAlertSettingPo.getCsasacompanyd()));	
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasabrandid())) {
			sb.append("AND C_SA_SA_BrandID = ? ");
			params.add(stockAlertSettingPo.getCsasabrandid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasasupplierid())) {
			sb.append("AND C_SA_SA_SupplierID = ? ");
			params.add(stockAlertSettingPo.getCsasasupplierid());
		}
		
		if ("1".equals(Utility.getName(stockAlertSettingPo.getCsasadepartmenttype()))||"2".equals(Utility.getName(stockAlertSettingPo.getCsasadepartmenttype()))) {
			sb.append(" and C_SA_SA_StockID in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(stockAlertSettingPo.getCsasadepartmentid());
		}
		
		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasastockid())) {
			sb.append("AND C_SA_SA_StockID = ? ");
			params.add(stockAlertSettingPo.getCsasastockid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo
				.getCsasagoodscategoryid())) {
			sb.append("AND B_GI_GoodsCategoryID = ? ");
			params.add(stockAlertSettingPo.getCsasagoodscategoryid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasagoodsid())) {
			sb.append("AND B_GI_GoodsID like '%' + ? + '%' ");//quyanping
			params.add(stockAlertSettingPo.getCsasagoodsid());
		}

		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasagoodsname())) {
			sb.append("AND B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(stockAlertSettingPo.getCsasagoodsname());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	
	public void insertStockAlertSetting(StockAlertSettingPo stockAlertSettingPo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO C_SA_StockAlertSetting ");
		buffer.append("(C_SA_SA_ID ");
		buffer.append(",C_SA_SA_GoodsID ");		
		buffer.append(",C_SA_SA_SupplierID ");
		buffer.append(",C_SA_SA_BrandID ");
		buffer.append(",C_SA_SA_StockID ");
		buffer.append(",C_SA_SA_StockCap ");
		buffer.append(",C_SA_SA_StockLower ");
		buffer.append(",C_SA_SA_StockRed) ");
		buffer.append("VALUES (?, ?, ?, ?, ?, ?, ?,?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(Utility.getName(stockAlertSettingPo.getCsasagoodsid()));
		params.add(stockAlertSettingPo.getCsasasupplierid());
		params.add(stockAlertSettingPo.getCsasabrandid());
		params.add(stockAlertSettingPo.getCsasastockid());
		params.add(stockAlertSettingPo.getCsasastockcap());
		params.add(stockAlertSettingPo.getCsasastocklower());
		params.add(stockAlertSettingPo.getCsasastockred());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void insertStockAlertSettings(StockAlertSettingPo stockAlertSettingPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO C_SA_StockAlertSetting ");
		buffer.append("SELECT replace(newid(), '-', '') ");
		buffer.append(", B_GI_GoodsID, ? ");
		buffer.append(", ?, ? ");
		buffer.append(", ?, ?, ? FROM B_GoodsInfo ");
		buffer.append("WHERE 1 = 1 ");

		params.add(stockAlertSettingPo.getCsasasupplierid());
		params.add(stockAlertSettingPo.getCsasabrandid());
		params.add(stockAlertSettingPo.getCsasastockid());
		params.add(stockAlertSettingPo.getCsasastockcap());
		params.add(stockAlertSettingPo.getCsasastocklower());
		params.add(stockAlertSettingPo.getCsasastockred());

		// 镜片类
		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasasphup())) {
			buffer.append("AND CAST(replace(B_GI_Vsph,'+','') AS FLOAT) ");
			buffer.append("between CAST( replace(?,'+','') AS FLOAT) and CAST( replace(?,'+','') AS FLOAT) ");

			buffer.append("AND CAST(B_GI_Vcyl AS FLOAT) ");
			buffer.append("between CAST( ? AS FLOAT) AND CAST( ? AS FLOAT) ");

			params.add(stockAlertSettingPo.getCsasasphup());// 下限
			params.add(stockAlertSettingPo.getCsasasphul());// 上限

			params.add(stockAlertSettingPo.getCsasacylup());// 下限
			params.add(stockAlertSettingPo.getCsasacylul());// 上限

		}

		buffer.append("AND B_GI_BrandID = ? ");
		buffer.append("AND B_GI_SupplierID = ? ");

		params.add(stockAlertSettingPo.getCsasabrandid());
		params.add(stockAlertSettingPo.getCsasasupplierid());

		// 镜片类
		if (StringUtils.isNotEmpty(stockAlertSettingPo.getCsasasphup())) {
			buffer.append("AND B_GI_isCustomize = '0' ");
			buffer.append("AND B_GI_GoodsCategoryID IN (3, 4) ");
		} else {
			buffer.append("AND B_GI_GoodsCategoryID NOT IN (3, 4) ");
		}

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	public void updateGoodsStockAlert(StockAlertSettingPo stockAlertSettingPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE C_SA_StockAlertSetting ");
		buffer.append("SET C_SA_SA_StockCap = ? ");
		buffer.append(",C_SA_SA_StockLower = ? ");
		buffer.append(",C_SA_SA_StockRed = ? ");
		buffer.append("WHERE C_SA_SA_ID =? ");

		List<String> params = new ArrayList<String>();
		params.add(stockAlertSettingPo.getCsasastockcap());
		params.add(stockAlertSettingPo.getCsasastocklower());
		params.add( (null == stockAlertSettingPo.getCsasastockred() ? "" : stockAlertSettingPo.getCsasastockred()) );
		params.add(stockAlertSettingPo.getCsasaid());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public StockAlertSettingPo getStockAlertSettingPo(String id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  C_SA_SA_ID as csasaid ");
		buffer.append(", C_SA_SA_GoodsID as csasagoodsid ");
		buffer.append(", B_GI_ViewGoodsName as csasagoodsname ");
		buffer.append(", B_SP_SupplierName as csasasuppliername ");
		buffer.append(", B_BD_brandName as csasabrandname ");
		buffer.append(", B_WH_warehouseName as csasawarehousename ");
		buffer.append(", C_SA_SA_StockCap as csasastockcap ");
		buffer.append(", C_SA_SA_StockLower as csasastocklower ");
		buffer.append(", C_SA_SA_StockRed as csasastockred ");
		buffer.append("FROM C_SA_StockAlertSetting ");
		buffer.append("INNER JOIN ");
		buffer.append("B_GoodsInfo ON C_SA_SA_GoodsID = B_GI_GoodsID ");
		buffer.append("INNER JOIN ");
		buffer.append("B_Brand ON C_SA_SA_SupplierID = B_BD_SupplierID ");
		buffer.append("AND C_SA_SA_BrandID = B_BD_ID ");
		buffer.append("INNER JOIN ");
		buffer.append("B_Supplier ON C_SA_SA_SupplierID = B_SP_ID ");
		buffer.append("INNER JOIN ");
		buffer.append("B_Warehouse ON C_SA_SA_StockID = B_WH_ID ");

		buffer.append("WHERE C_SA_SA_ID =? ");

		List<String> params = new ArrayList<String>();
		params.add(id);

		return (StockAlertSettingPo) queryForObject(buffer.toString(), params
				.toArray(), StockAlertSettingPo.class);

	}

	
	/**
	 * 批量删除
	 * 
	 * @param stockAlertSettingPo
	 */
	public void batchDeteleSettings(String id){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from C_SA_StockAlertSetting WHERE C_SA_SA_ID =? ");
		
		params.add(Utility.getName(id));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public GoodsInfoPo selectDimensionPos(GoodsInfoPo gpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname,B_GI_Sph as bgisph,B_GI_Cyl as bgicyl,B_BD_brandName as bgibrandname from dbo.B_GoodsInfo inner join B_Brand on B_BD_ID = B_GI_BrandID and B_GI_SupplierID = B_BD_SupplierID where B_GI_GoodsCategoryID in ('3','4') and B_GI_isCustomize = '0' and B_GI_GoodsID = ? ");
		
		params.add(Utility.getName(gpo.getBgigoodsid()));
		
		return (GoodsInfoPo) queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);

	}
	
	/**
	 * 删除已设置的库存预警
	 */
	public void deleteStockAlertSetting2D(StockAlertSettingPo spo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from C_SA_StockAlertSetting WHERE C_SA_SA_GoodsID = ? and C_SA_SA_StockID = ? ");
		
		params.add(Utility.getName(spo.getCsasagoodsid()));
		params.add(Utility.getName(spo.getCsasastockid()));

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
}
