package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowInspectionDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WindowInspectionDaoImpl extends BaseJdbcDaoSupport implements WindowInspectionDao {


	public int getWindowInspectionNormolCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select count(b_bd_id) from b_brand inner join b_supplier ");
		sb.append("on b_sp_id=b_bd_supplierid ");
		sb.append("where b_sp_categoryid like ? ");
		List<String> params = new ArrayList<String>();
		params.add("%"+goodsInfoPo.getBgigoodscategoryid()+"%");
		if (!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))) {
			sb.append(" and b_sp_id=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))) {
			sb.append(" and b_bd_id=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}


	public List<GoodsInfoPo> getWindowInspectionNormolList(
			GoodsInfoPo goodsInfoPo,int start,int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.bgisuppliername as bgisuppliername,");
		sb.append(" temp.bgibrandname as bgibrandname");
		sb.append(" from(select ROW_NUMBER() Over(order by b_sp_id) as rowNum,");
		sb.append("b_bd_brandname as bgibrandname,b_sp_suppliername as bgisuppliername from b_brand inner join b_supplier on b_sp_id=b_bd_supplierid ");
		sb.append(" where  b_sp_categoryid like ? ");

		List<String> params = new ArrayList<String>();
		params.add("%"+goodsInfoPo.getBgigoodscategoryid()+"%");
		if (!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))) {
			sb.append(" and b_sp_id=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))) {
			sb.append(" and b_bd_id=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}	
	

	public int getWindowInspectionOtherCount(GoodsInfoPo goodsInfoPo) {
		int existingCount = 0;
		int customizeCount = 0;
		
		StringBuffer sb = new StringBuffer();		
		sb.append("select count(B_SP_ID)");
		sb.append(" from B_GoodsInfo join B_Supplier on B_GI_SupplierID = B_SP_ID join B_Brand on B_GI_BrandID = B_BD_ID and B_GI_SupplierID = B_BD_SupplierID");
		sb.append(" where B_GI_Flag='1' and B_GI_GoodsCategoryID like '%4%' and isnull(B_GI_StealthCustomizeType,'') = '' and cast(B_GI_Sph as float) = cast(? as float) and cast(B_GI_Cyl as float) = cast(? as float)");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(goodsInfoPo.getBgisph()));
		params.add(Utility.getName(goodsInfoPo.getBgicyl()));
		
		if (goodsInfoPo.getBgisupplierid() != ""){
			params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
			sb.append(" and B_GI_SupplierID=?");
		}
		if (goodsInfoPo.getBgibrandid() != ""){
			params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
			sb.append(" and B_GI_BrandID=?");
		}
		if (goodsInfoPo.getBgigoodsname() != ""){
			params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
			sb.append(" and B_GI_ViewGoodsName like '%'+?+'%'");
		}
		
		existingCount = getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
		
		sb = new StringBuffer();		
		sb.append("select count(B_SP_ID)");
		sb.append(" from B_GoodsInfo join B_Supplier on B_GI_SupplierID = B_SP_ID join B_Brand on B_GI_BrandID = B_BD_ID and B_GI_SupplierID = B_BD_SupplierID");
		sb.append(" where B_GI_Flag='1' and B_GI_GoodsCategoryID like '%4%' and (isnull(B_GI_StealthCustomizeType,'') = '1' or isnull(B_GI_StealthCustomizeType,'') = '2') and cast(? as float) between cast(B_GI_SphUP as float) and cast(B_GI_SphUL as float) and cast(? as float) between cast(B_GI_CylUP as float) and cast(B_GI_CylUL as float)");
		
		if (goodsInfoPo.getBgisupplierid() != ""){
			sb.append(" and B_GI_SupplierID=?");
		}
		if (goodsInfoPo.getBgibrandid() != ""){
			sb.append(" and B_GI_BrandID=?");
		}
		if (goodsInfoPo.getBgigoodsname() != ""){
			sb.append(" and B_GI_ViewGoodsName like '%'+?+'%'");
		}
		
		customizeCount = getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
		
		return (existingCount + customizeCount);
	}	
	

	public List<GoodsInfoPo> getWindowInspectionOtherList(GoodsInfoPo goodsInfoPo,int start,int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.bgisuppliername as bgisuppliername,");
		sb.append("temp.bgibrandname as bgibrandname,");
		sb.append("temp.bgigoodsname as bgigoodsname,");
		sb.append("temp.bgiretailprice as bgiretailprice,");
		sb.append("temp.bgiiscustomize as bgiiscustomize");
		sb.append(" from(select ROW_NUMBER() Over(order by temp2.bspid) as rowNum,");
		sb.append("temp2.bgisuppliername,temp2.bgibrandname,temp2.bgigoodsname,temp2.bgiretailprice,temp2.bgiiscustomize");		
		sb.append(" from(select B_SP_SupplierName as bgisuppliername,B_BD_brandName as bgibrandname,B_GI_ViewGoodsName as bgigoodsname,");
		sb.append("B_GI_RetailPrice as bgiretailprice,B_GI_isCustomize as bgiiscustomize,B_SP_ID as bspid from B_GoodsInfo join B_Supplier on B_GI_SupplierID = B_SP_ID join B_Brand on B_GI_BrandID = B_BD_ID and B_GI_SupplierID = B_BD_SupplierID");
		sb.append(" where B_GI_Flag='1' and B_GI_GoodsCategoryID like '%4%' and isnull(B_GI_StealthCustomizeType,'') = '' and cast(B_GI_Sph as float)=cast(? as float) and cast(B_GI_Cyl as float)=cast(? as float)");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(goodsInfoPo.getBgisph()));
		params.add(Utility.getName(goodsInfoPo.getBgicyl()));
		
		if (goodsInfoPo.getBgisupplierid() != "" && goodsInfoPo.getBgisupplierid() != null){
			params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
			sb.append(" and B_GI_SupplierID=?");
		}
		if (goodsInfoPo.getBgibrandid() != "" && goodsInfoPo.getBgibrandid() != null){
			params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
			sb.append(" and B_GI_BrandID=?");
		}
		if (goodsInfoPo.getBgigoodsname() != ""){
			params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
			sb.append(" and B_GI_ViewGoodsName like '%'+?+'%'");
		}
		
		sb.append(" union all ");
		sb.append("select B_SP_SupplierName as bgisuppliername,B_BD_brandName as bgibrandname,B_GI_ViewGoodsName as bgigoodsname,B_GI_RetailPrice as bgiretailprice,");
		sb.append("B_GI_isCustomize as bgiiscustomize,B_SP_ID as bspid from B_GoodsInfo join B_Supplier on B_GI_SupplierID = B_SP_ID join B_Brand on B_GI_BrandID = B_BD_ID and B_GI_SupplierID = B_BD_SupplierID");
		sb.append(" where B_GI_Flag='1' and B_GI_GoodsCategoryID like '%4%' and (isnull(B_GI_StealthCustomizeType,'') = '1' or isnull(B_GI_StealthCustomizeType,'') = '2') and cast(? as float) between cast(B_GI_SphUP as float) and cast(B_GI_SphUL as float) and cast(? as float) between cast(B_GI_CylUP as float) and cast(B_GI_CylUL as float)");
	    
		params.add(Utility.getName(goodsInfoPo.getBgisph()));
		params.add(Utility.getName(goodsInfoPo.getBgicyl()));
		
		if (goodsInfoPo.getBgisupplierid() != "" && goodsInfoPo.getBgisupplierid() != null){
			params.add(Utility.getName(goodsInfoPo.getBgisupplierid()));
			sb.append(" and B_GI_SupplierID=?");
		}
		if (goodsInfoPo.getBgibrandid() != "" && goodsInfoPo.getBgibrandid() != null){
			params.add(Utility.getName(goodsInfoPo.getBgibrandid()));
			sb.append(" and B_GI_BrandID=?");
		}
		if (goodsInfoPo.getBgigoodsname() != ""){
			params.add(Utility.getName(goodsInfoPo.getBgigoodsname()));
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%'");
		}
		
		sb.append(" )temp2 ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	

	public int getWindowInspectionStealCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb
				.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		// sb.append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb
				.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where B_GoodsInfo.B_GI_Flag='1'  ");

		List<String> params = new ArrayList<String>();
		if (!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		// if(!"".equals(Utility.getName(po.getBgivarietyid()))){
		// sb.append(" and B_GoodsInfo.B_GI_VarietyID='"+po.getBgivarietyid()+"'");
		// }

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}


	public List<GoodsInfoPo> getWindowInspectionSteallList(
			GoodsInfoPo goodsInfoPo, int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
