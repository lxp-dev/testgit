package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.dao.PreSalesDao;
import com.pengsheng.eims.sales.persistence.PreBrandPo;
import com.pengsheng.eims.sales.persistence.PreDepPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesEntryPo;
import com.pengsheng.eims.sales.persistence.PrePersonSalesPo;
import com.pengsheng.eims.sales.persistence.PrePlanPo;
import com.pengsheng.eims.sales.persistence.PreSalesPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesEntryPo;
import com.pengsheng.eims.sales.persistence.PreShopSalesPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class PreSalesDaoImpl extends BaseJdbcDaoSupport implements PreSalesDao {

	public int deletePreSales(PreSalesPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("DELETE FROM S_SE_PreSales ");
		sb.append("WHERE  S_SE_PreSalesId = ? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getPreSalesId());
		return getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void updatePreSalesPoQuantity(String id, String quantity) {

		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		sb.append(" UPDATE S_SE_PreSales ");
		sb.append(" SET  ");
		sb.append(" S_SE_SalesQuantity = ? ");
		sb.append("WHERE  S_SE_PreSalesId = ? ");
		
		params.add(quantity);
		params.add(id);
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public PreSalesPo getPreSalesPo(PreSalesPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT S_SE_PreSalesId     AS preSalesId, ");
		sb.append("       S_SE_DepartmentId   AS departmentId, ");
		sb.append("       S_SE_SupplierId     AS supplierId, ");
		sb.append("       S_SE_BrandId        AS brandId, ");
		sb.append("       CONVERT(VARCHAR(10), S_SE_StartDate, 23)      AS startDate, ");
		sb.append("       CONVERT(VARCHAR(10), S_SE_EndDate, 23)        AS endDate, ");
		sb.append("       S_SE_SalesQuantity  AS salesQuantity, ");
		sb.append("       B_DP_DepartmentName AS departmentName, ");
		sb.append("       B_BD_brandName      AS brandName, ");
		sb.append("       B_SP_SupplierName   AS supplierName ");
		sb.append("FROM   S_SE_PreSales ");
		sb.append("       LEFT JOIN B_Supplier ");
		sb.append("         ON B_SP_ID = S_SE_SupplierId ");
		sb.append("       LEFT JOIN B_Brand ");
		sb.append("         ON B_BD_ID = S_SE_BrandId ");
		sb.append("            AND B_BD_SupplierID = S_SE_SupplierId ");
		sb.append("       LEFT JOIN B_Departments ");
		sb.append("         ON B_DP_DepartmentID = S_SE_DepartmentId ");
		sb.append("         WHERE S_SE_PreSalesId = ? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getPreSalesId());
		return (PreSalesPo) queryForObject(sb.toString(), params.toArray(), PreSalesPo.class);
	}

	public int insertPreSales(PreSalesPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_PreSales ");
		sb.append("            (S_SE_PreSalesId, ");
		sb.append("             S_SE_DepartmentId, ");
		sb.append("             S_SE_SupplierId, ");
		sb.append("             S_SE_BrandId, ");
		sb.append("             S_SE_StartDate, ");
		sb.append("             S_SE_EndDate, ");
		sb.append("             S_SE_SalesQuantity, ");
		sb.append("             S_SE_AddedPersonId, ");
		sb.append("             S_SE_AddedDate) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             GETDATE()) ");
		List<String> params = new ArrayList<String>();
		params.add(po.getPreSalesId());
		params.add(po.getDepartmentId());
		params.add(po.getSupplierId());
		params.add(po.getBrandId());
		params.add(po.getStartDate());
		params.add(po.getEndDate());
		params.add(po.getSalesQuantity());
		params.add(po.getAddedPersonId());
		return getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public int updatePreSales(PreSalesPo po) {
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		sb.append(" UPDATE S_SE_PreSales ");
		sb.append(" SET  ");
		
		sb.append(" S_SE_PreSalesId = ?  ");
		params.add(po.getPreSalesId());
		
		if(null != po) {
			if(!"".equals(Utility.getName(po.getSupplierId()))) {
				sb.append("       ,S_SE_SupplierId = ? ");
				params.add(po.getSupplierId());
			}
			if(!"".equals(Utility.getName(po.getBrandId()))) {
				sb.append("       ,S_SE_BrandId = ? ");
				params.add(po.getBrandId());
			}
			if(!"".equals(Utility.getName(po.getStartDate()))) {
				sb.append("       ,S_SE_StartDate = ? ");
				params.add(po.getStartDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))) {
				sb.append("       ,S_SE_EndDate = ? ");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getSalesQuantity()))) {
				sb.append("       ,S_SE_SalesQuantity = ? ");
				params.add(po.getSalesQuantity());
			}
		}
		sb.append("WHERE  S_SE_PreSalesId = ? ");
		params.add(po.getPreSalesId());
		return getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public List<PreSalesPo> getIntersectionPreSalesList(PreSalesPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT S_SE_PreSalesId    AS preSalesId, ");
		sb.append("       S_SE_DepartmentId  AS departmentId, ");
		sb.append("       S_SE_SupplierId    AS supplierId, ");
		sb.append("       S_SE_BrandId       AS brandId, ");
		sb.append("       S_SE_StartDate     AS startDate, ");
		sb.append("       S_SE_EndDate       AS endDate, ");
		sb.append("       S_SE_SalesQuantity AS salesQuantity ");
		sb.append("FROM   S_SE_PreSales ");
		sb.append("WHERE  S_SE_DepartmentId IN ( " + formatStringArrayToSQL(po.getDepartmentIds()) + " ) ");
		sb.append("       AND CONVERT(VARCHAR(10), S_SE_EndDate, 23) < ? ");
		sb.append("       AND S_SE_SupplierId IN ( " + formatStringArrayToSQL(po.getSupplierIds()) + " ) ");
		sb.append("       AND S_SE_BrandId IN ( " + formatStringArrayToSQL(po.getBrandIds()) + " ) ");
		
		List<String> params = new ArrayList<String>();
		if(null != po) {
			params.add(po.getStartDate());
		}
		return queryForObjectList(sb.toString(), params.toArray(), PreSalesPo.class);
	}
	
	private static String formatStringArrayToSQL(String[] strs) {
		if(null != strs && strs.length > 0) {
			StringBuffer sqlStr = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				if(null != strs[i] && !"".equals(strs[i])) {
					sqlStr.append(",'" + strs[i] + "'");
				}
			}
			return sqlStr.toString().replaceFirst("\\,", "");
		}
		return "";
	}

	public void deletePrePlanPo(PrePlanPo po) {
		StringBuffer  sb = new StringBuffer();
		
		sb.append("DELETE FROM dbo.S_SE_PrePlans ");
		sb.append("WHERE  S_SE_PlanId = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getPlanId());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public List<PrePlanPo> getPrePlanPoList(PrePlanPo po, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SET ROWCOUNT 10");
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY S_SE_PlanId) AS rowNum, ");
		sb.append("               S_SE_PlanId                             AS planId, ");
		sb.append("               S_SE_PlanName                           AS planName, ");
		sb.append("        CONVERT(VARCHAR(10), S_SE_StartDate, 23)       AS startDate, ");
		sb.append("    CONVERT(VARCHAR(10), S_SE_endDate, 23)             AS endDate, ");
		sb.append("               S_SE_Overdue                            AS Overdue ");
		sb.append("        FROM   S_SE_PrePlans ");
		sb.append("        WHERE  1 = 1 ");
		
		List<String> params = new ArrayList<String>();
		if(null != po) {
			if(!"".equals(Utility.getName(po.getPlanName()))) {
				sb.append(" AND S_SE_PlanName LIKE '%' + ? + '%' ");
				params.add(po.getPlanName());
			}
			if(!"".equals(Utility.getName(po.getStartDate()))) {
				sb.append(" AND S_SE_StartDate >= ? ");
				params.add(po.getStartDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))) {
				sb.append(" AND S_SE_endDate <= ? ");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getOverdue()))) {
				sb.append(" AND S_SE_Overdue = ? ");
				params.add(po.getOverdue());
			}
		}
		int pageCount = start + size;
		sb.append("        ) AS TEMP ");
		sb.append("WHERE  rowNum > " + start + "  ");
		sb.append("       AND rowNum <= " + pageCount + "  ");
		sb.append("SET ROWCOUNT 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), PrePlanPo.class);
	}

	public int getPrePlanPoListCount(PrePlanPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT COUNT(*) ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY S_SE_PlanId) AS rowNum, ");
		sb.append("               S_SE_PlanId                             AS planId, ");
		sb.append("               S_SE_PlanName                           AS planName, ");
		sb.append("               S_SE_StartDate                          AS startDate, ");
		sb.append("               S_SE_endDate                            AS endDate, ");
		sb.append("               S_SE_Overdue                            AS Overdue ");
		sb.append("        FROM   S_SE_PrePlans ");
		sb.append("        WHERE  1 = 1 ");
		
		List<String> params = new ArrayList<String>();
		if(null != po) {
			if(!"".equals(Utility.getName(po.getPlanName()))) {
				sb.append(" AND S_SE_PlanName LIKE '%' + ? + '%' ");
				params.add(po.getPlanName());
			}
			if(!"".equals(Utility.getName(po.getStartDate()))) {
				sb.append(" AND S_SE_StartDate >= ? ");
				params.add(po.getStartDate());
			}
			if(!"".equals(Utility.getName(po.getEndDate()))) {
				sb.append(" AND S_SE_endDate <= ? ");
				params.add(po.getEndDate());
			}
			if(!"".equals(Utility.getName(po.getOverdue()))) {
				sb.append(" AND S_SE_Overdue = ? ");
				params.add(po.getOverdue());
			}
		}
		sb.append("        ) AS TEMP ");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public void insertPrePlanPo(PrePlanPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_PrePlans ");
		sb.append("            (S_SE_PlanId, ");
		sb.append("             S_SE_PlanName, ");
		sb.append("             S_SE_StartDate, ");
		sb.append("             S_SE_endDate, ");
		sb.append("             S_SE_Overdue) ");
		sb.append("VALUES     (?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?, ");
		sb.append("            ?) ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getPlanId());
		params.add(po.getPlanName());
		params.add(po.getStartDate());
		params.add(po.getEndDate());
		params.add( (po.getOverdue() == null ? "0" : po.getOverdue()) );
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void updatePrePlanPo(PrePlanPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("UPDATE S_SE_PrePlans ");
		sb.append("SET    S_SE_PlanName = ?, ");
		sb.append("       S_SE_StartDate = ?, ");
		sb.append("       S_SE_endDate = ?, ");
		sb.append("       S_SE_Overdue = ? ");
		sb.append("WHERE  S_SE_PlanId = ? ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(po.getPlanName());
		params.add(po.getStartDate());
		params.add(po.getEndDate());
		params.add(po.getOverdue());
		params.add(po.getOverdue());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public PrePlanPo getPrePlanPo(PrePlanPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append(" SELECT S_SE_PlanId AS planId, ");
		sb.append("       S_SE_PlanName AS planName, ");
		sb.append("       S_SE_StartDate AS startDate, ");
		sb.append("       S_SE_endDate AS endDate, ");
		sb.append("       S_SE_Overdue AS Overdue ");
		sb.append(" FROM   S_SE_PrePlans ");
		sb.append(" WHERE  S_SE_PlanId = ? ");
		List<String> params = new ArrayList<String>();
		if(null != po) {
			params.add(po.getPlanId());
		}
		
		return (PrePlanPo) queryForObject(sb.toString(), params.toArray(), PrePlanPo.class);
	}

	public List<PreDepPo> getPreDepPoList(PrePlanPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT S_SE_PrePlans.S_SE_PlanId AS prePlanId, ");
		sb.append("       S_SE_PlanDepId AS preDepId, ");
		sb.append("       S_SE_DepId AS prePlanDepId, ");
		sb.append("       B_DP_DepartmentName AS departmentName  ");
		sb.append(" FROM   S_SE_PrePlans ");
		sb.append("       INNER JOIN S_SE_PreDep ");
		sb.append("         ON S_SE_PreDep.S_SE_PlanId = S_SE_PrePlans.S_SE_PlanId ");
		sb.append("       INNER JOIN B_Departments ");
		sb.append("         ON B_DP_DepartmentID = S_SE_DepId ");
		sb.append("WHERE  S_SE_PrePlans.S_SE_PlanId = ? ");
		List<String> params = new ArrayList<String>();
		if(null != po) {
			params.add(po.getPlanId());
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), PreDepPo.class);
	}

	public List<PreBrandPo> getPreBrandPoList(PreDepPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT S_SE_PlanBraId AS preBrandId, ");
		sb.append("       S_SE_PreDep.S_SE_PlanDepId AS preDepId, ");
		sb.append("       S_SE_PlanBrand.S_SE_SupplierAndBrandId AS supplierAndBrandId, ");
		sb.append("       S_SE_SupplierId AS supplierId, ");
		sb.append("       B_SP_SupplierName AS supplierName, ");
		sb.append("       S_SE_BrandId AS brandId, ");
		sb.append("       B_BD_brandName AS brandName, ");
		sb.append("       S_SE_PreSalesQuantity AS salesQuantity ");
		sb.append("FROM   S_SE_PreDep ");
		sb.append("       INNER JOIN S_SE_PlanBrand ");
		sb.append("         ON S_SE_PlanBrand.S_SE_PlanDepId = S_SE_PreDep.S_SE_PlanDepId ");
		sb.append("       INNER JOIN B_Supplier ");
		sb.append("         ON B_SP_ID = S_SE_SupplierId ");
		sb.append("       INNER JOIN B_Brand ");
		sb.append("         ON B_BD_ID = S_SE_BrandId  AND B_BD_SupplierID = B_SP_ID ");
		sb.append("WHERE  S_SE_PreDep.S_SE_PlanDepId = ? ");
		List<String> params = new ArrayList<String>();
		if(null != po) {
			params.add(po.getPreDepId());
		}
		return queryForObjectList(sb.toString(), params.toArray(), PreBrandPo.class);
	}

	public void insertPreBrandPo(PreBrandPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_PlanBrand ");
		sb.append("            (S_SE_PlanBraId, ");
		sb.append("             S_SE_SupplierAndBrandId, ");
		sb.append("             S_SE_PlanDepId, ");
		sb.append("             S_SE_SupplierId, ");
		sb.append("             S_SE_BrandId, ");
		sb.append("             S_SE_PreSalesQuantity) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?) ");
		
		List<String> params = new ArrayList<String>();
		
		if(null != po) {
			params.add(po.getPreBrandId());
			params.add(po.getSupplierAndBrandId());
			params.add(po.getPreDepId());
			params.add(po.getSupplierId());
			params.add(po.getBrandId());
			params.add(po.getSalesQuantity());
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void insertPreDepPo(PreDepPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_PreDep ");
		sb.append("            (S_SE_PlanDepId, ");
		sb.append("             S_SE_PlanId, ");
		sb.append("             S_SE_DepId) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?) ");
		
		List<String> params = new ArrayList<String>();
		
		if(null != po) {
			params.add(po.getPrePlanDepId());
			params.add(po.getPrePlanId());
			params.add(po.getPreDepId());
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void deletePreBrandPoByPreDepPoId(PreDepPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("DELETE FROM S_SE_PlanBrand ");
		sb.append("WHERE  S_SE_PlanDepId = ? ");
		List<String> params = new ArrayList<String>();
		if(null != po) {
			params.add(po.getPreDepId());
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public void deletePreDepPo(PreDepPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("DELETE FROM S_SE_PreDep ");
		sb.append("WHERE  S_SE_PlanDepId = ? ");
		
		List<String> params = new ArrayList<String>();
		if(null != po) {
			params.add(po.getPreDepId());
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	public PreDepPo getPreDepPo(PreDepPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT TOP 1 S_SE_PlanDepId      AS preDepId, ");
		sb.append("       S_SE_PlanId         AS prePlanId, ");
		sb.append("       S_SE_DepId          AS prePlanDepId, ");
		sb.append("       B_DP_DepartmentName AS departmentName ");
		sb.append("FROM   S_SE_PreDep ");
		sb.append("       INNER JOIN B_Departments ");
		sb.append("         ON S_SE_DepId = B_DP_DepartmentID ");
		sb.append(" WHERE S_SE_PlanDepId = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getPreDepId());
		
		return (PreDepPo) queryForObject(sb.toString(), params.toArray(), PreDepPo.class);
	}

	public void updatePreDepPoOverdue() {
		StringBuffer  sb = new StringBuffer();
		sb.append("UPDATE S_SE_PrePlans ");
		sb.append("SET    S_SE_Overdue = '1' ");
		sb.append("WHERE  S_SE_endDate < Getdate() ");
		
		getJdbcTemplate().update(sb.toString());
	}
	
	public int insertPreSalesS(PreSalesPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("INSERT INTO S_SE_PreSalesS ");
		sb.append("            (S_SE_PS_ID, ");
		sb.append("             S_SE_PS_SerialNumber, ");
		sb.append("             S_SE_PS_ShopCode, ");
		sb.append("             S_SE_PS_CustomerID, ");
		sb.append("             S_SE_PS_PriceSum, ");
		sb.append("             S_SE_PS_SalesValue, ");
		sb.append("             S_SE_PS_Saler, ");
		sb.append("             S_SE_PS_Poser, ");
		sb.append("             S_SE_PS_Date, ");
		sb.append("             S_SE_PS_FactDate, ");
		sb.append("				S_SE_PS_Type, ");
		sb.append("				S_SE_PS_TakeGlassTime, ");
		sb.append("				S_SE_PS_Remark) ");
		sb.append("VALUES      (?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             ?, ");
		sb.append("             dbo.ufn_getDayCheckOut(), ");
		sb.append("             getdate(), ");
		sb.append("             '0', ");
		sb.append("             ?, ");
		sb.append("             ?) ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getSsepsid());
		params.add(po.getSsepsserialnumber());
		params.add(po.getSsepsshopcode());
		params.add(po.getSsepscustomerid());
		params.add(po.getSsepspricesum());
		params.add(po.getSsepssalesvalue());
		params.add(po.getSsepssaler());
		params.add(po.getSsepsposer());
		params.add(po.getSsepstakeglasstime());
		params.add(Utility.getName(po.getSsepsremark()));
		
		return getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	/**
	 * 查询门店计划销售金额列表
	 */
	public List<PreShopSalesPo> getPreShopSalesList(PreShopSalesPo po, int start, int size){
		
		int pageCount = start + size;
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SET ROWCOUNT " + size + " ");
		sb.append(" SELECT * FROM ( ");
		sb.append("SELECT Row_number() OVER(ORDER BY S_SE_PS_PreBgnDate desc) AS rowNum,S_SE_PS_ID as ssepsid ");
		sb.append("      ,S_SE_PS_ShopCode as ssepsshopcode ");
		sb.append("      ,S_SE_PS_PreBgnDate as ssepsprebgndate ");
		sb.append("      ,S_SE_PS_PreEndDate as ssepspreenddate ");
		sb.append("      ,S_SE_PS_SalesPrice as ssepssalesprice ");
		sb.append("      ,S_SE_PS_CreateDate as ssepscreatedate ");
		sb.append("      ,S_SE_PS_CreatePersonID as ssepscreatepersonid ");
		sb.append("      ,S_SE_PS_CreateDptID as ssepscreatedptid ");
		sb.append("      ,S_SE_PS_LastUpdateDate as ssepslastupdatedate ");
		sb.append("      ,S_SE_PS_LastUpdatePersonID as ssepslastupdatepersonid ");
		sb.append("      ,S_SE_PS_LastUpdateDptID as ssepslastupdatedptid ");
		sb.append("      ,a.B_DP_DepartmentName as ssepsshopcodename ");
		sb.append("  FROM S_SE_PreShopSales inner join B_Departments a on S_SE_PS_ShopCode=a.B_DP_DepartmentID where 1 = 1  ");
				
		if (!"".equals(Utility.getName(po.getSsepsshopcode()))){
			String[] array = Utility.getName(po.getSsepsshopcode()).split(",");
			sb.append(" and S_SE_PS_ShopCode in ( ");
			
			for (int i = 0; i < array.length; i++) {
				sb.append(" ? ");
				params.add(array[i]);

				if (i + 1 != array.length) {
					sb.append(" ,");
				} else {
					sb.append(" ) ");
				}
			}
		}
		if (!"".equals(Utility.getName(po.getSsepsprebgndate()))){
			sb.append("   and S_SE_PS_PreBgnDate >= ? ");
			params.add(Utility.getName(po.getSsepsprebgndate()));
		}
		if (!"".equals(Utility.getName(po.getSsepspreenddate()))){
			sb.append("   and S_SE_PS_PreEndDate <= ? ");
			params.add(Utility.getName(po.getSsepspreenddate()));
		}
		if (!"".equals(Utility.getName(po.getSsepsbgnsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice >= ? ");
			params.add(Utility.getName(po.getSsepsbgnsalesprice()));
		}
		if (!"".equals(Utility.getName(po.getSsepsendsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice <= ? ");
			params.add(Utility.getName(po.getSsepsendsalesprice()));
		}
		
		sb.append(" ) temp ");
		sb.append(" WHERE rowNum > " + start + " AND rowNum <= " + pageCount);
		sb.append(" SET ROWCOUNT 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), PreShopSalesPo.class);
	}
	
	public PreSalesPo selectPreSalesPoSerialNumber() {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 temp.ssepsserialnumber as ssepsserialnumber from ( ");
		sb.append("  select isnull(S_SE_PS_SerialNumber,0)+1 AS ssepsserialnumber ");
		sb.append("  FROM S_SE_PreSalesS ");
		sb.append("  union all ");
		sb.append("  select '1' as ssepsserialnumber )temp ");
		sb.append("  Order by temp.ssepsserialnumber desc ");
		
		return (PreSalesPo)queryForObject(sb.toString(), null, PreSalesPo.class);
	}
	/**
	 * 查询门店计划销售金额总数
	 */
	public int getPreShopSalesCount(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(ssepsid) from ( ");
		sb.append("SELECT S_SE_PS_ID as ssepsid ");
		sb.append("      ,S_SE_PS_ShopCode as ssepsshopcode ");
		sb.append("      ,S_SE_PS_PreBgnDate as ssepsprebgndate ");
		sb.append("      ,S_SE_PS_PreEndDate as ssepspreenddate ");
		sb.append("      ,S_SE_PS_SalesPrice as ssepssalesprice ");
		sb.append("      ,S_SE_PS_CreateDate as ssepscreatedate ");
		sb.append("      ,S_SE_PS_CreatePersonID as ssepscreatepersonid ");
		sb.append("      ,S_SE_PS_CreateDptID as ssepscreatedptid ");
		sb.append("      ,S_SE_PS_LastUpdateDate as ssepslastupdatedate ");
		sb.append("      ,S_SE_PS_LastUpdatePersonID as ssepslastupdatepersonid ");
		sb.append("      ,S_SE_PS_LastUpdateDptID as ssepslastupdatedptid ");
		sb.append("      ,a.B_DP_DepartmentName as ssepsshopcodename ");
		sb.append("  FROM S_SE_PreShopSales inner join B_Departments a on S_SE_PS_ShopCode=a.B_DP_DepartmentID where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getSsepsshopcode()))){
			String[] array = Utility.getName(po.getSsepsshopcode()).split(",");
			sb.append(" and S_SE_PS_ShopCode in ( ");
			
			for (int i = 0; i < array.length; i++) {
				sb.append(" ? ");
				params.add(array[i]);

				if (i + 1 != array.length) {
					sb.append(" ,");
				} else {
					sb.append(" ) ");
				}
			}
		}
		if (!"".equals(Utility.getName(po.getSsepsprebgndate()))){
			sb.append("   and S_SE_PS_PreBgnDate >= ? ");
			params.add(Utility.getName(po.getSsepsprebgndate()));
		}
		if (!"".equals(Utility.getName(po.getSsepspreenddate()))){
			sb.append("   and S_SE_PS_PreEndDate <= ? ");
			params.add(Utility.getName(po.getSsepspreenddate()));
		}
		if (!"".equals(Utility.getName(po.getSsepsbgnsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice >= ? ");
			params.add(Utility.getName(po.getSsepsbgnsalesprice()));
		}
		if (!"".equals(Utility.getName(po.getSsepsendsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice <= ? ");
			params.add(Utility.getName(po.getSsepsendsalesprice()));
		}
		sb.append(")temp ");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	public List<PreSalesPo> getPreSalesPoList(PreSalesPo po, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int pageCount = start + size;
		sb.append("SET ROWCOUNT " + size + " ");
		sb.append(" SELECT * FROM ");
		sb.append(" (select Row_number() OVER(ORDER BY S_SE_PS_SerialNumber desc) AS rowNum, ");
		sb.append("    S_SE_PS_ID AS ssepsid, ");
		sb.append("    S_SE_PS_SerialNumber AS ssepsserialnumber, ");
		sb.append("    S_SE_PS_ShopCode AS ssepsshopcode, ");
		sb.append("    B_DP_DepartmentName AS ssepsshopcodename, ");
		sb.append("    S_SE_PS_CustomerID AS ssepscustomerid, ");
		sb.append("    S_ME_CI_Name AS ssepscustomername, ");
		sb.append("    S_SE_PS_PriceSum AS ssepspricesum, ");
		sb.append("    S_SE_PS_SalesValue AS ssepssalesvalue, ");
		sb.append("    S_SE_PS_Saler AS ssepssaler, ");
		sb.append("    a.personName AS ssepssalername, ");
		sb.append("    S_SE_PS_Poser AS ssepsposer, ");
		sb.append("    b.personName AS ssepsposername, ");
		sb.append("    S_SE_PS_Date AS ssepsdate, ");
		sb.append("	   S_SE_PS_Type AS ssepstype, ");
		sb.append("	   S_SE_PS_TakeGlassTime AS ssepstakeglasstime ");
		sb.append("FROM S_SE_PreSalesS ");
		sb.append("left join S_ME_CustomerInfo on S_SE_PS_CustomerID = S_ME_CI_CustomerID ");
		sb.append("left join SYS_PersonInfo a on a.id = S_SE_PS_Saler ");
		sb.append("left join SYS_PersonInfo b on b.id = S_SE_PS_Poser ");
		sb.append("left join B_Departments on S_SE_PS_ShopCode = B_DP_DepartmentID ");
		sb.append("WHERE 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSsepsid()))){
			sb.append("and S_SE_PS_ID like '%' + ? + '%' ");
			params.add(po.getSsepsid());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsserialnumber()))){
			sb.append("and S_SE_PS_SerialNumber = ? ");
			params.add(po.getSsepsserialnumber());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsshopcode()))){
			sb.append("and S_SE_PS_ShopCode = ? ");
			params.add(po.getSsepsshopcode());
		}
		
		if(!"".equals(Utility.getName(po.getSsepscustomername()))){
			sb.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSsepscustomername());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsmemberid()))){
			sb.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(po.getSsepsmemberid());
		}
		
		if(!"".equals(Utility.getName(po.getSsepssalername()))){
			sb.append("and a.personName like '%' + ? + '%' ");
			params.add(po.getSsepssalername());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsposername()))){
			sb.append("and b.personName like '%' + ? + '%' ");
			params.add(po.getSsepsposername());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsbgntime()))){
			sb.append("and convert(varchar(10),S_SE_PS_Date,23) >= ? ");
			params.add(po.getSsepsbgntime());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsendtime()))){
			sb.append("and convert(varchar(10),S_SE_PS_Date,23) <= ? ");
			params.add(po.getSsepsendtime());
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			sb.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				sb.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			sb.append(" ) ");
		}
		
		sb.append(" ) AS temp ");
		sb.append(" WHERE rowNum > " + start + " AND rowNum <= " + pageCount);
		
		return queryForObjectList(sb.toString(), params.toArray(), PreSalesPo.class);
	}
	
	public int getPreSalesPoListCount(PreSalesPo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" SELECT count(*) FROM ( ");
		sb.append("    select S_SE_PS_ID AS ssepsid, ");
		sb.append("    S_SE_PS_SerialNumber AS ssepsserialnumber, ");
		sb.append("    S_SE_PS_ShopCode AS ssepsshopcode, ");
		sb.append("    B_DP_DepartmentName AS ssepsshopcodename, ");
		sb.append("    S_SE_PS_CustomerID AS ssepscustomerid, ");
		sb.append("    S_ME_CI_Name AS ssepscustomername, ");
		sb.append("    S_SE_PS_PriceSum AS ssepspricesum, ");
		sb.append("    S_SE_PS_SalesValue AS ssepssalesvalue, ");
		sb.append("    S_SE_PS_Saler AS ssepssaler, ");
		sb.append("    a.personName AS ssepssalername, ");
		sb.append("    S_SE_PS_Poser AS ssepsposer, ");
		sb.append("    b.personName AS ssepsposername, ");
		sb.append("    S_SE_PS_Date AS ssepsdate, ");
		sb.append("	   S_SE_PS_Type AS ssepstype ");
		sb.append("FROM S_SE_PreSalesS ");
		sb.append("left join S_ME_CustomerInfo on S_SE_PS_CustomerID = S_ME_CI_CustomerID ");
		sb.append("left join SYS_PersonInfo a on a.id = S_SE_PS_Saler ");
		sb.append("left join SYS_PersonInfo b on b.id = S_SE_PS_Poser ");
		sb.append("left join B_Departments on S_SE_PS_ShopCode = B_DP_DepartmentID ");
		sb.append("WHERE 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSsepsid()))){
			sb.append("and S_SE_PS_ID like '%' + ? + '%' ");
			params.add(po.getSsepsid());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsserialnumber()))){
			sb.append("and S_SE_PS_SerialNumber = ? ");
			params.add(po.getSsepsserialnumber());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsshopcode()))){
			sb.append("and S_SE_PS_ShopCode = ? ");
			params.add(po.getSsepsshopcode());
		}
		
		if(!"".equals(Utility.getName(po.getSsepscustomername()))){
			sb.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(po.getSsepscustomername());
		}
		
		if(!"".equals(Utility.getName(po.getSsepssalername()))){
			sb.append("and a.personName like '%' + ? + '%' ");
			params.add(po.getSsepssalername());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsposername()))){
			sb.append("and b.personName like '%' + ? + '%' ");
			params.add(po.getSsepsposername());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsbgntime()))){
			sb.append("and convert(varchar(10),S_SE_PS_Date,23) >= ? ");
			params.add(po.getSsepsbgntime());
		}
		
		if(!"".equals(Utility.getName(po.getSsepsendtime()))){
			sb.append("and convert(varchar(10),S_SE_PS_Date,23) <= ? ");
			params.add(po.getSsepsendtime());
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			sb.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				sb.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			sb.append(" ) ");
		}
		
		sb.append(") temp ");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 新增门店计划销售金额列表
	 */
	public void insertPreShopSales(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SE_PreShopSales (S_SE_PS_ID,S_SE_PS_ShopCode,S_SE_PS_PreBgnDate,S_SE_PS_PreEndDate,S_SE_PS_SalesPrice,S_SE_PS_CreateDate,S_SE_PS_CreatePersonID,S_SE_PS_CreateDptID,S_SE_PS_LastUpdateDate,S_SE_PS_LastUpdatePersonID,S_SE_PS_LastUpdateDptID) values (?,?,?,?,?,getdate(),?,?,getdate(),?,?) ");
		
		params.add(Utility.getName(po.getSsepsid()));
		params.add(Utility.getName(po.getSsepsshopcode()));
		params.add(Utility.getName(po.getSsepsprebgndate()));
		params.add(Utility.getName(po.getSsepspreenddate()));
		params.add(Utility.getName(po.getSsepssalesprice()));		
		params.add(Utility.getName(po.getSsepscreatepersonid()));
		params.add(Utility.getName(po.getSsepscreatedptid()));		
		params.add(Utility.getName(po.getSsepscreatepersonid()));
		params.add(Utility.getName(po.getSsepscreatedptid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 新增门店计划销售金额明细列表
	 */
	public void insertPreShopSalesEntry(PreShopSalesEntryPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SE_PreShopSalesEntry (S_SE_PSE_ID,S_SE_PSE_PreID,S_SE_PSE_ShopCode,S_SE_PSE_PreDate,S_SE_PSE_SalesPrice) values (?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSsepsepreid()));
		params.add(Utility.getName(po.getSsepseshopcode()));
		params.add(Utility.getName(po.getSsepsepredate()));
		params.add(Utility.getName(po.getSsepsesalesprice()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除门店计划销售金额列表
	 */
	public void deletePreShopSales(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SE_PreShopSales where S_SE_PS_ID = ? ");
		
		params.add(Utility.getName(po.getSsepsid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除门店计划销售金额明细列表
	 */
	public void deletePreShopSalesEntry(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SE_PreShopSalesEntry where S_SE_PSE_PreID = ? ");
		
		params.add(Utility.getName(po.getSsepsid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 修改门店计划销售金额列表
	 */
	public void updatePreShopSales(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update S_SE_PreShopSales set S_SE_PS_SalesPrice = ?,S_SE_PS_LastUpdateDate = getdate(),S_SE_PS_LastUpdatePersonID = ?,S_SE_PS_LastUpdateDptID = ? where S_SE_PS_ID = ? ");
		
		params.add(Utility.getName(po.getSsepssalesprice()));
		params.add(Utility.getName(po.getSsepslastupdatepersonid()));
		params.add(Utility.getName(po.getSsepslastupdatedptid()));
		params.add(Utility.getName(po.getSsepsid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public PreShopSalesPo getPreShopSalesDetail(PreShopSalesPo po) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 S_SE_PS_ID as ssepsid ");
		sb.append("      ,S_SE_PS_ShopCode as ssepsshopcode ");
		sb.append("      ,S_SE_PS_PreBgnDate as ssepsprebgndate ");
		sb.append("      ,S_SE_PS_PreEndDate as ssepspreenddate ");
		sb.append("      ,S_SE_PS_SalesPrice as ssepssalesprice ");
		sb.append("      ,S_SE_PS_CreateDate as ssepscreatedate ");
		sb.append("      ,S_SE_PS_CreatePersonID as ssepscreatepersonid ");
		sb.append("      ,S_SE_PS_CreateDptID as ssepscreatedptid ");
		sb.append("      ,S_SE_PS_LastUpdateDate as ssepslastupdatedate ");
		sb.append("      ,S_SE_PS_LastUpdatePersonID as ssepslastupdatepersonid ");
		sb.append("      ,S_SE_PS_LastUpdateDptID as ssepslastupdatedptid ");
		sb.append("      ,a.B_DP_DepartmentName as ssepsshopcodename ");
		sb.append("  FROM S_SE_PreShopSales inner join B_Departments a on S_SE_PS_ShopCode=a.B_DP_DepartmentID where S_SE_PS_ID = ? ");
		
		params.add(Utility.getName(po.getSsepsid()));
		
		return (PreShopSalesPo) queryForObject(sb.toString(), params.toArray(), PreShopSalesPo.class);
	}
	
	/**
	 * 判断门店计划销售金额是否重复
	 */
	public int getPreShopSalesByIDCount(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SELECT count(S_SE_PSE_ID) ");
		sb.append("  FROM S_SE_PreShopSalesEntry where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getSsepsshopcode()))){
			sb.append(" and  S_SE_PSE_ShopCode = ? ");
			params.add(Utility.getName(po.getSsepsshopcode()));
		}
		if (!"".equals(Utility.getName(po.getSsepspredate()))){
			sb.append("   and S_SE_PSE_PreDate = ? ");
			params.add(Utility.getName(po.getSsepspredate()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 计算两个日期的间隔天数
	 */
	public int getDayAreaCount(PreShopSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select DATEDIFF (dd,?,? ) + 1 ");
		
		params.add(Utility.getName(po.getSsepsprebgndate()));
		params.add(Utility.getName(po.getSsepspreenddate()));
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 查询人员计划销售金额列表
	 */
	public List<PrePersonSalesPo> getPrePersonSalesList(PrePersonSalesPo po, int start, int size){
		
		int pageCount = start + size;
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SET ROWCOUNT " + size + " ");
		sb.append(" SELECT * FROM ( ");
		sb.append("SELECT Row_number() OVER(ORDER BY S_SE_PS_PreBgnDate desc) AS rowNum,S_SE_PS_ID as ssepsid ");
		sb.append("      ,S_SE_PS_ShopCode as ssepsshopcode ");
		sb.append("      ,S_SE_PS_PreBgnDate as ssepsprebgndate ");
		sb.append("      ,S_SE_PS_PreEndDate as ssepspreenddate ");
		sb.append("      ,S_SE_PS_SalesPrice as ssepssalesprice ");
		sb.append("      ,S_SE_PS_CreateDate as ssepscreatedate ");
		sb.append("      ,S_SE_PS_CreatePersonID as ssepscreatepersonid ");
		sb.append("      ,S_SE_PS_CreateDptID as ssepscreatedptid ");
		sb.append("      ,S_SE_PS_LastUpdateDate as ssepslastupdatedate ");
		sb.append("      ,S_SE_PS_LastUpdatePersonID as ssepslastupdatepersonid ");
		sb.append("      ,S_SE_PS_LastUpdateDptID as ssepslastupdatedptid ");
		sb.append("      ,a.B_DP_DepartmentName as ssepsshopcodename ");
		sb.append("      ,S_SE_PS_person as ssepspersonid ");
		sb.append("      ,personName as ssepspersonname ");
		sb.append("  FROM S_SE_PrePersonSales  ");
		sb.append("  inner join B_Departments a on S_SE_PS_ShopCode=a.B_DP_DepartmentID ");
		sb.append("  inner join SYS_PersonInfo  on S_SE_PS_person=SYS_PersonInfo.ID  ");        
		sb.append("  where 1 = 1  ");	
				
		if (!"".equals(Utility.getName(po.getSsepsshopcode()))){
			String[] array = Utility.getName(po.getSsepsshopcode()).split(",");
			sb.append(" and S_SE_PS_ShopCode in ( ");
			
			for (int i = 0; i < array.length; i++) {
				sb.append(" ? ");
				params.add(array[i]);

				if (i + 1 != array.length) {
					sb.append(" ,");
				} else {
					sb.append(" ) ");
				}
			}
		}
		if (!"".equals(Utility.getName(po.getSsepsprebgndate()))){
			sb.append("   and S_SE_PS_PreBgnDate >= ? ");
			params.add(Utility.getName(po.getSsepsprebgndate()));
		}
		if (!"".equals(Utility.getName(po.getSsepspreenddate()))){
			sb.append("   and S_SE_PS_PreEndDate <= ? ");
			params.add(Utility.getName(po.getSsepspreenddate()));
		}
		if (!"".equals(Utility.getName(po.getSsepsbgnsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice >= ? ");
			params.add(Utility.getName(po.getSsepsbgnsalesprice()));
		}
		if (!"".equals(Utility.getName(po.getSsepsendsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice <= ? ");
			params.add(Utility.getName(po.getSsepsendsalesprice()));
		}
		if (!"".equals(Utility.getName(po.getSsepspersonid()))){
			sb.append("   and S_SE_PS_person = ? ");
			params.add(Utility.getName(po.getSsepspersonid()));
		}
		if (!"".equals(Utility.getName(po.getSsepspersonname()))){
			sb.append("   and personName  like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsepspersonname()));
		}
		sb.append(" ) temp ");
		sb.append(" WHERE rowNum > " + start + " AND rowNum <= " + pageCount);
		sb.append(" SET ROWCOUNT 0 ");
		
		return queryForObjectList(sb.toString(), params.toArray(), PrePersonSalesPo.class);
	}
	
	/**
	 * 查询人员计划销售金额总数
	 */
	public int getPrePersonSalesCount(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(ssepsid) from ( ");
		sb.append("SELECT S_SE_PS_ID as ssepsid ");
		sb.append("      ,S_SE_PS_ShopCode as ssepsshopcode ");
		sb.append("      ,S_SE_PS_PreBgnDate as ssepsprebgndate ");
		sb.append("      ,S_SE_PS_PreEndDate as ssepspreenddate ");
		sb.append("      ,S_SE_PS_SalesPrice as ssepssalesprice ");
		sb.append("      ,S_SE_PS_CreateDate as ssepscreatedate ");
		sb.append("      ,S_SE_PS_CreatePersonID as ssepscreatepersonid ");
		sb.append("      ,S_SE_PS_CreateDptID as ssepscreatedptid ");
		sb.append("      ,S_SE_PS_LastUpdateDate as ssepslastupdatedate ");
		sb.append("      ,S_SE_PS_LastUpdatePersonID as ssepslastupdatepersonid ");
		sb.append("      ,S_SE_PS_LastUpdateDptID as ssepslastupdatedptid ");
		sb.append("      ,a.B_DP_DepartmentName as ssepsshopcodename ");
		sb.append("      ,S_SE_PS_person as ssepspersonid ");
		sb.append("      ,personName as ssepspersonname ");
		sb.append("  FROM S_SE_PrePersonSales  ");
		sb.append("  inner join B_Departments a on S_SE_PS_ShopCode=a.B_DP_DepartmentID ");
		sb.append("  inner join SYS_PersonInfo  on S_SE_PS_person=SYS_PersonInfo.ID  ");        
		sb.append("  where 1 = 1  ");		
		
		if (!"".equals(Utility.getName(po.getSsepsshopcode()))){
			String[] array = Utility.getName(po.getSsepsshopcode()).split(",");
			sb.append(" and S_SE_PS_ShopCode in ( ");
			
			for (int i = 0; i < array.length; i++) {
				sb.append(" ? ");
				params.add(array[i]);

				if (i + 1 != array.length) {
					sb.append(" ,");
				} else {
					sb.append(" ) ");
				}
			}
		}
		if (!"".equals(Utility.getName(po.getSsepsprebgndate()))){
			sb.append("   and S_SE_PS_PreBgnDate >= ? ");
			params.add(Utility.getName(po.getSsepsprebgndate()));
		}
		if (!"".equals(Utility.getName(po.getSsepspreenddate()))){
			sb.append("   and S_SE_PS_PreEndDate <= ? ");
			params.add(Utility.getName(po.getSsepspreenddate()));
		}
		if (!"".equals(Utility.getName(po.getSsepsbgnsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice >= ? ");
			params.add(Utility.getName(po.getSsepsbgnsalesprice()));
		}
		if (!"".equals(Utility.getName(po.getSsepsendsalesprice()))){
			sb.append("   and S_SE_PS_SalesPrice <= ? ");
			params.add(Utility.getName(po.getSsepsendsalesprice()));
		}
		if (!"".equals(Utility.getName(po.getSsepspersonid()))){
			sb.append("   and S_SE_PS_person = ? ");
			params.add(Utility.getName(po.getSsepspersonid()));
		}
		if (!"".equals(Utility.getName(po.getSsepspersonname()))){
			sb.append("   and personName  like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getSsepspersonname()));
		}
		sb.append(")temp ");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 新增人员计划销售金额列表
	 */
	public void insertPrePersonSales(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SE_PrePersonSales (S_SE_PS_ID,S_SE_PS_ShopCode,S_SE_PS_Person,S_SE_PS_PreBgnDate,S_SE_PS_PreEndDate,S_SE_PS_SalesPrice,S_SE_PS_CreateDate,S_SE_PS_CreatePersonID,S_SE_PS_CreateDptID,S_SE_PS_LastUpdateDate,S_SE_PS_LastUpdatePersonID,S_SE_PS_LastUpdateDptID) values (?,?,?,?,?,?,getdate(),?,?,getdate(),?,?) ");
		
		params.add(Utility.getName(po.getSsepsid()));
		params.add(Utility.getName(po.getSsepsshopcode()));
		params.add(Utility.getName(po.getSsepspersonid()));
		params.add(Utility.getName(po.getSsepsprebgndate()));
		params.add(Utility.getName(po.getSsepspreenddate()));
		params.add(Utility.getName(po.getSsepssalesprice()));		
		params.add(Utility.getName(po.getSsepscreatepersonid()));
		params.add(Utility.getName(po.getSsepscreatedptid()));		
		params.add(Utility.getName(po.getSsepscreatepersonid()));
		params.add(Utility.getName(po.getSsepscreatedptid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 新增人员计划销售金额明细列表
	 */
	public void insertPrePersonSalesEntry(PrePersonSalesEntryPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_SE_PrePersonSalesEntry (S_SE_PSE_ID,S_SE_PSE_PreID,S_SE_PSE_ShopCode,S_SE_PSE_Person,S_SE_PSE_PreDate,S_SE_PSE_SalesPrice) values (?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSsepsepreid()));
		params.add(Utility.getName(po.getSsepseshopcode()));
		params.add(Utility.getName(po.getSsepsepersonid()));
		params.add(Utility.getName(po.getSsepsepredate()));
		params.add(Utility.getName(po.getSsepsesalesprice()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 删除人员计划销售金额列表
	 */
	public void deletePrePersonSales(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SE_PrePersonSales where S_SE_PS_ID = ? ");
		
		params.add(Utility.getName(po.getSsepsid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	/**
	 * 删除人员计划销售金额明细列表
	 */
	public void deletePrePersonSalesEntry(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("delete from S_SE_PrePersonSalesEntry where S_SE_PSE_PreID = ? ");
		
		params.add(Utility.getName(po.getSsepsid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/**
	 * 修改人员计划销售金额列表
	 */
	public void updatePrePersonSales(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("update S_SE_PrePersonSales set S_SE_PS_SalesPrice = ?,S_SE_PS_LastUpdateDate = getdate(),S_SE_PS_LastUpdatePersonID = ?,S_SE_PS_LastUpdateDptID = ? where S_SE_PS_ID = ? ");
		
		params.add(Utility.getName(po.getSsepssalesprice()));
		params.add(Utility.getName(po.getSsepslastupdatepersonid()));
		params.add(Utility.getName(po.getSsepslastupdatedptid()));
		params.add(Utility.getName(po.getSsepsid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}	
	
	/**
	 * 查看人员计划销售金额明细
	 */
	public PrePersonSalesPo getPrePersonSalesDetail(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 S_SE_PS_ID as ssepsid ");
		sb.append("      ,S_SE_PS_ShopCode as ssepsshopcode ");
		sb.append("      ,S_SE_PS_PreBgnDate as ssepsprebgndate ");
		sb.append("      ,S_SE_PS_PreEndDate as ssepspreenddate ");
		sb.append("      ,S_SE_PS_SalesPrice as ssepssalesprice ");
		sb.append("      ,S_SE_PS_CreateDate as ssepscreatedate ");
		sb.append("      ,S_SE_PS_CreatePersonID as ssepscreatepersonid ");
		sb.append("      ,S_SE_PS_CreateDptID as ssepscreatedptid ");
		sb.append("      ,S_SE_PS_LastUpdateDate as ssepslastupdatedate ");
		sb.append("      ,S_SE_PS_LastUpdatePersonID as ssepslastupdatepersonid ");
		sb.append("      ,S_SE_PS_LastUpdateDptID as ssepslastupdatedptid ");
		sb.append("      ,a.B_DP_DepartmentName as ssepsshopcodename ");
		sb.append("      ,S_SE_PS_person as ssepspersonid ");
		sb.append("      ,personName as ssepspersonname ");
		sb.append("      FROM S_SE_PrePersonSales  ");
		sb.append("      inner join B_Departments a on S_SE_PS_ShopCode=a.B_DP_DepartmentID ");
		sb.append("      inner join SYS_PersonInfo  on S_SE_PS_person=SYS_PersonInfo.ID where S_SE_PS_ID = ? ");
		
		params.add(Utility.getName(po.getSsepsid()));
		
		return (PrePersonSalesPo) queryForObject(sb.toString(), params.toArray(), PrePersonSalesPo.class);
	}
	/**
	 * 判断人员计划销售金额是否重复
	 */
	public int getPrePersonSalesByIDCount(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SELECT count(S_SE_PSE_ID) ");
		sb.append("  FROM S_SE_PrePersonSalesEntry where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getSsepspersonid()))){
			sb.append(" and  S_SE_PSE_Person = ? ");
			params.add(Utility.getName(po.getSsepspersonid()));
		}
		if (!"".equals(Utility.getName(po.getSsepspredate()))){
			sb.append("   and S_SE_PSE_PreDate = ? ");
			params.add(Utility.getName(po.getSsepspredate()));
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 计算两个日期的间隔天数
	 */
	public int getDayAreaCount2(PrePersonSalesPo po){
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select DATEDIFF (dd,?,? ) + 1 ");
		
		params.add(Utility.getName(po.getSsepsprebgndate()));
		params.add(Utility.getName(po.getSsepspreenddate()));
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
}
