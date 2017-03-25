package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.components.dao.VarietyDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class VarietyDaoImpl extends BaseJdbcDaoSupport implements VarietyDao {

	public VarietyPo getVarietyPo(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1 B_VY_ID as BVYID ");
		buffer.append(",B_VY_VarietyName as  BVYVarietyName ");
		buffer.append(",B_VY_BrandID as BVYBrandID ");
		buffer.append(", B_VY_SupplierID as BVYSupplierID ");
		buffer.append(",B_VY_GcID as BVYGcID ");
		buffer.append(" FROM B_Variety ");
		buffer.append(" WHERE 1 = 1 ");

		List<String> params = new ArrayList<String>();

		// 品种代码
		if (!"".equals(Utility.getName(varietyPo.getBvyid()))) {
			buffer.append(" and B_VY_ID = ? ");
			params.add(varietyPo.getBvyid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(varietyPo.getBvyvarietyname()))) {
			buffer.append(" and B_VY_VarietyName like '%' + ? + '%' ");
			params.add(varietyPo.getBvyvarietyname());
		}

		// 品种代码
		if (!"".equals(Utility.getName(varietyPo.getBvybrandid()))) {
			buffer.append(" and B_VY_BrandID = ? ");
			params.add(varietyPo.getBvybrandid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(varietyPo.getBvygcid()))) {
			buffer.append(" and B_VY_GcID = ? ");
			params.add(varietyPo.getBvygcid());
		}

		// 制造商
		if (!"".equals(Utility.getName(varietyPo.getBvysupplierid()))) {
			buffer.append(" and B_VY_SupplierID = ? ");
			params.add(varietyPo.getBvysupplierid());
		}

		return (VarietyPo) this.queryForObject(buffer.toString(), params
				.toArray(), VarietyPo.class);
	}

	public void delVariety(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Variety ");
		buffer.append("WHERE B_VY_ID = ? ");
		buffer.append("and B_VY_BrandID = ? ");
		buffer.append("AND B_VY_Supplierid = ? ");
		buffer.append("AND B_VY_GcID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(varietyPo.getBvyid());
		params.add(varietyPo.getBvybrandid());
		params.add(varietyPo.getBvysupplierid());
		params.add(varietyPo.getBvygcid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {

		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory order by B_GC_Order ";

		return queryForObjectList(sql, null, GoodsCategoryPo.class);
	}
	
	/*
	 * quyanping2011-05-26
	 */
	public List<TechnologyTypePo> getTechnologyType(){
		String sql="select F_TT_ID as fttid,F_TT_Name as fttname from F_TechnologyType";
		
		return queryForObjectList(sql,null,TechnologyTypePo.class);
	}

	public List<VarietyPo> getVarietys(VarietyPo varietyPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_VY_GcID, B_VY_BrandID, ");
		buffer.append("B_VY_ID) as 'rowNum', ");
		buffer.append("B_VY_ID as BVYID");
		buffer.append(",B_VY_VarietyName as  BVYVarietyName");
		buffer.append(",B_VY_BrandID as BVYBrandID");
		buffer.append(",B_VY_GcID as BVYGcID ");
		buffer.append(",B_BD_brandName as bbdbrandname ");
		buffer.append(",B_VY_Supplierid as bvysupplierid");
		buffer.append(",B_GC_GoodsCategoryName as bgcgoodscategoryname ");
		buffer.append(" from B_Variety ");
		buffer.append("inner join B_Brand ");
		buffer.append(" ON B_Brand.B_BD_ID = B_Variety.B_VY_BrandID ");
		buffer.append(" AND B_VY_SupplierID = B_BD_SupplierID ");
		buffer.append("inner join B_GoodsCategory ");
		buffer.append(" ON B_GC_ID = B_Variety.B_VY_GcID ");

		buffer.append(" where 1 = 1 ");

		// 品种代码
		if (!"".equals(Utility.getName(varietyPo.getBvyid()))) {
			buffer.append(" and B_VY_ID = ? ");
			params.add(varietyPo.getBvyid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(varietyPo.getBvyvarietyname()))) {
			buffer.append(" and B_VY_VarietyName like '%' + ? + '%' ");
			params.add(varietyPo.getBvyvarietyname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(varietyPo.getBvysupplierid()))) {
			buffer.append(" and B_VY_Supplierid = ? ");
			params.add(varietyPo.getBvysupplierid());
		}

		// 品种代码
		if (!"".equals(Utility.getName(varietyPo.getBvybrandid()))) {
			buffer.append(" and B_VY_BrandID = ? ");
			params.add(varietyPo.getBvybrandid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(varietyPo.getBvygcid()))) {
			buffer.append(" and B_VY_GcID = ? ");
			params.add(varietyPo.getBvygcid());
		}

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				VarietyPo.class);
	}

	public int getVarietysCount(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(B_BD_ID) from B_Variety ");
		buffer
				.append("inner join B_Brand ON B_Brand.B_BD_ID = B_Variety.B_VY_BrandID ");
		buffer.append(" AND B_VY_SupplierID = B_BD_SupplierID ");
		buffer
				.append("inner join B_GoodsCategory ON B_GC_ID = B_Variety.B_VY_GcID ");

		buffer.append(" where 1 = 1 ");

		// 品种代码
		if (!"".equals(Utility.getName(varietyPo.getBvyid()))) {
			buffer.append(" and B_VY_ID = ? ");
			params.add(varietyPo.getBvyid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(varietyPo.getBvyvarietyname()))) {
			buffer.append(" and B_VY_VarietyName like '%' + ? + '%' ");
			params.add(varietyPo.getBvyvarietyname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(varietyPo.getBvysupplierid()))) {
			buffer.append(" and B_VY_Supplierid = ? ");
			params.add(varietyPo.getBvysupplierid());
		}

		// 品种代码
		if (!"".equals(Utility.getName(varietyPo.getBvybrandid()))) {
			buffer.append(" and B_VY_BrandID = ? ");
			params.add(varietyPo.getBvybrandid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(varietyPo.getBvygcid()))) {
			buffer.append(" and B_VY_GcID = ? ");
			params.add(varietyPo.getBvygcid());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	public void insertVariety(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO B_Variety  ");
		buffer.append("(B_VY_ID ");
		buffer.append(",B_VY_VarietyName ");
		buffer.append(",B_VY_BrandID ");
		buffer.append(",B_VY_Supplierid ");
		buffer.append(",B_VY_GcID) ");
		buffer.append("VALUES (?, ?, ?, ?, ? )");

		List<String> params = new ArrayList<String>();
		params.add(varietyPo.getBvyid());
		params.add(varietyPo.getBvyvarietyname());
		params.add(varietyPo.getBvybrandid());
		params.add(varietyPo.getBvysupplierid());
		params.add(varietyPo.getBvygcid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateVariety(VarietyPo varietyPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();

		buffer.append("UPDATE B_Variety ");
		buffer.append("SET B_VY_VarietyName = ? ");
		buffer.append("WHERE B_VY_ID = ? ");
		buffer.append("AND B_VY_BrandID = ? ");
		buffer.append("AND B_VY_Supplierid = ? ");
		buffer.append("AND B_VY_GcID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(varietyPo.getBvyvarietyname());
		params.add(varietyPo.getBvyid());
		params.add(varietyPo.getBvybrandid());
		params.add(varietyPo.getBvysupplierid());
		params.add(varietyPo.getBvygcid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getGoodsInfos(GoodsInfoPo goodsInfoPo) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(B_GI_GoodsID) from B_GoodsInfo ");

		buffer.append(" where 1 = 1 ");

		// 品种代码
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))) {
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(goodsInfoPo.getBgibrandid());
		}

//		// 品种代码
//		if (!"".equals(Utility.getName(goodsInfoPo.getBgivarietyid()))) {
//			buffer.append(" and B_GI_VarietyID = ? ");
//			params.add(goodsInfoPo.getBgivarietyid());
//		}

		// 制造商代码
		if (!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(goodsInfoPo.getBgisupplierid());
		}

		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	/**
	 * 查询透视分析表的总行数
	 * 
	 * @return
	 */
	public int getSalesGoodsCount(GoodsInfoPo goodsInfoPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("exec sp_SalesPerspectiveAnalysisCount ?,?,?,?,?,?,?,?,? ");

		params.add(Utility.getName(goodsInfoPo.getBgigoodsid()));
		params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
		params.add(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
		params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
		params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
		params.add(Utility.getName(goodsInfoPo.getBgispec()));		
		params.add(Utility.getName(goodsInfoPo.getQueryType()));
		params.add(Utility.getName(goodsInfoPo.getBgnDate()));
		params.add(Utility.getName(goodsInfoPo.getEndDate()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 查询透视分析表数据
	 * 
	 * @return
	 */
	public List<GoodsInfoPo> getSalesGoodsList(GoodsInfoPo goodsInfoPo, int start, int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec sp_SalesPerspectiveAnalysisSum ?,?,?,?,?,?,?,?,?,?,?,? ");
		
		params.add(Utility.getName(goodsInfoPo.getBgigoodsid()));
		params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
		params.add(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
		params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
		params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
		params.add(Utility.getName(goodsInfoPo.getBgispec()));		
		params.add(Utility.getName(goodsInfoPo.getQueryType()));
		params.add(Utility.getName(goodsInfoPo.getBgnDate()));
		params.add(Utility.getName(goodsInfoPo.getEndDate()));		
		params.add(String.valueOf(start));
		params.add(String.valueOf(size));
		params.add(String.valueOf(start+size));
		
		return queryForObjectList(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 按部门查询透视分析表数据
	 * 
	 * @return
	 */
	public List<GoodsInfoPo> getSalesGoodsByDepartment(GoodsInfoPo goodsInfoPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec sp_SalesPerspectiveAnalysisList ?,?,?,? ");
		
		params.add(Utility.getName(goodsInfoPo.getBgigoodsid()));
		params.add(Utility.getName(goodsInfoPo.getQueryType()));
		params.add(Utility.getName(goodsInfoPo.getBgnDate()));
		params.add(Utility.getName(goodsInfoPo.getEndDate()));		
		
		return queryForObjectList(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 查询所有销售门店
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getSalesDepartmentList(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid,B_DP_DepartmentName as bdpdepartmentname from B_Departments where B_DP_Type='1' and B_DP_IsClosed=0  order by B_DP_DepartmentID ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),DepartmentsPo.class);
	}
}
