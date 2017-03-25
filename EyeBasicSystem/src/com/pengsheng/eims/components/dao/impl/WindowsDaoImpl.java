package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.VarietyPo;
import com.pengsheng.eims.components.dao.WindowsDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WindowsDaoImpl extends BaseJdbcDaoSupport implements WindowsDao {

	public int getSupplierCount(SupplierPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select count(B_SP_ID) from B_Supplier where 1 = 1");
		sb.append(" and B_SP_ID<>'ZZ'");
		if (!"".equals(Utility.getName(po.getBspid()))) {
			sb.append(" and B_SP_ID= ?");
			params.add(po.getBspid());
		}
		if (!"".equals(Utility.getName(po.getBspsuppliername()))) {
			sb.append(" and B_SP_SupplierName like'%' + ? + '%'");
			params.add(po.getBspsuppliername());
		}
		if (!"".equals(Utility.getName(po.getBspcategoryid()))
				&& po.getBspcategoryid().indexOf(",") == -1) {
			sb.append(" and B_SP_CategoryID like'%' + ? + '%'");
			params.add(po.getBspcategoryid());
		}

		if (po.getBspcategoryid().indexOf(",") != -1) {
			sb.append(" and ( ");

			String[] categorys = po.getBspcategoryid().split(",");
			for (int i = 0; i < categorys.length; i++) {
				sb.append(" B_SP_CategoryID like'%' + ? + '%' ");
				params.add(categorys[i].trim());

				if (categorys.length != i + 1) {
					sb.append(" or ");
				}
			}
			sb.append(" ) ");
		}
		
		if (!"".equals(Utility.getName(po.getBspflag()))) {
			sb.append(" and B_SP_Flag = ? ");
			params.add(Utility.getName(po.getBspflag()));
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<SupplierPo> getSupplierList(SupplierPo po, int start, int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;

		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by B_SP_ID asc) as 'rowNum', ");
		sb.append("B_SP_ID as bspid,B_SP_SupplierName as bspsuppliername,B_SP_ContactPerson as bspcontactperson,");
		sb.append("B_SP_ContactPhone as bspcontactphone,B_SP_Fax as bspfax,B_SP_Address as bspaddress,");
		sb.append("B_SP_Remark as bspremark,B_SP_CategoryID as bspcategoryid,B_SP_Settlement as bspsettlement,B_SP_SettlementMonth as bspsettlementmonth, ");
		sb.append("B_SP_Flag as bspflag ");
		sb.append("from B_Supplier where 1 = 1");
		sb.append(" and B_SP_ID<>'ZZ'");
		if (!"".equals(Utility.getName(po.getBspid()))) {
			sb.append(" and B_SP_ID= ?");
			params.add(po.getBspid());
		}
		if (!"".equals(Utility.getName(po.getBspsuppliername()))) {
			sb.append(" and B_SP_SupplierName like'%' + ? + '%'");
			params.add(po.getBspsuppliername());
		}
		if (!"".equals(Utility.getName(po.getBspcategoryid()))
				&& po.getBspcategoryid().indexOf(",") == -1) {
			sb.append(" and B_SP_CategoryID like'%' + ? + '%'");
			params.add(po.getBspcategoryid());
		}

		if (po.getBspcategoryid().indexOf(",") != -1) {
			sb.append(" and ( ");

			String[] categorys = po.getBspcategoryid().split(",");
			for (int i = 0; i < categorys.length; i++) {
				sb.append(" B_SP_CategoryID like'%' + ? + '%' ");
				params.add(categorys[i].trim());

				if (categorys.length != i + 1) {
					sb.append(" or ");
				}
			}
			sb.append(" ) ");
		}
		
		if (!"".equals(Utility.getName(po.getBspflag()))) {
			sb.append(" and B_SP_Flag = ? ");
			params.add(Utility.getName(po.getBspflag()));
		}
		
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
	//	sb.append("order by table1.bspid set rowcount 0");
		sb.append("order by table1.bspid asc set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				SupplierPo.class);
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {

		String sql = "select B_GC_ID as bgcid,B_GC_GoodsCategoryName as bgcgoodscategoryname from B_GoodsCategory order by B_GC_Order";

		return queryForObjectList(sql, null, GoodsCategoryPo.class);
	}

	public List<BrandPo> getBrands(BrandPo brandPo, int start, int size) {
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_SP_CategoryID, B_BD_ID) as 'rowNum', ");
		buffer.append("B_BD_ID as bbdid ");
		buffer.append(",B_BD_brandName as bbdbrandname ");
		buffer.append(",B_BD_DefaultDiscount as bbddefaultdiscount ");
		buffer.append(",B_BD_SupplierID as bbdsupplierid, ");
		buffer.append("B_SP_SupplierName as bspsuppliername, isnull(B_BD_CostPrice,0.00) as bbdcostprice,isnull(B_BD_RetailPrice,0.00) as bbdretailprice,isnull(B_BD_frameProcessCraftType,'') as bbdframeprocesscrafttype,isnull(B_BD_TaxRate,0) as bbdtaxrate, B_BD_Unit as bbdunit,isnull(B_BD_Refractive,'') as bbdrefractive,isnull(B_BD_FrameMaterialType,'') as bbdframematerialtype ");
		buffer.append(" ,isnull(B_BD_MaterialClass,'') as bbdmaterialclass,isnull(B_BD_LuminosityClass,'') as bbdluminosityclass, isnull(B_BD_GradualClass,'') as bbdgradualclass ,isnull(B_BD_FunctionClass,'') as bbdfunctionclass , isnull(B_BD_UseType,'') as bbdusetype,isnull(B_BD_StealthClass,'') as bbdstealthclass ");
		buffer.append(" ,(SELECT [values]= STUFF(REPLACE(REPLACE(( ");
		buffer.append("SELECT B_GC_GoodsCategoryName as value FROM B_GoodsCategory n ");
		buffer.append("WHERE B_GC_ID in (SELECT [value] FROM Split (B_BD_GoodsCategory, ',')) ");
		buffer.append("order by B_GC_ID ");
		buffer.append("FOR XML AUTO ");
		buffer.append("), '<N value=\"', ','), '\"/>', ''), 1, 1, '') )  ");
		buffer.append("as bgcgoodscategoryname,B_BD_ValidDateUL as bbdvaliddateUL,B_BD_ValidDateUP as bbdvaliddateUP ");
		buffer.append(",B_BD_PayFeeID 			as bbdpayfeeid ");
		buffer.append("from b_brand ");
		buffer.append("inner join B_Supplier ON B_Supplier.B_SP_ID = B_BD_SupplierID ");
		buffer.append("where 1 = 1 ");

		// 品种代码
		if (!"".equals(Utility.getName(brandPo.getBbdid()))) {
			buffer.append(" and B_BD_ID = ? ");
			params.add(brandPo.getBbdid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(brandPo.getBspcategoryid()))) {
			buffer.append(" and ? IN (SELECT [value] FROM Split (B_BD_GoodsCategory, ',')) ");
			params.add(brandPo.getBspcategoryid());
		}
		
		// 品种是否被停用 
		if (!"".equals(Utility.getName(brandPo.getBbdsalesstatue()))) {
			buffer.append(" and B_BD_SalesStatue = ? ");
			params.add(Utility.getName(brandPo.getBbdsalesstatue()));
		}

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),BrandPo.class);
	}

	public int getBrandsCount(BrandPo brandPo) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("SELECT count(*) ");
		buffer.append("FROM   (SELECT Row_number() OVER(ORDER BY B_BD_GoodsCategory, B_BD_ID) AS 'rowNum', ");
		buffer.append("               B_SP_ID                                                 AS bbdsupplierid, ");
		buffer.append("               B_SP_SupplierName                                       AS bspsuppliername, ");
		buffer.append("               B_BD_GoodsCategory + '.' + B_SP_ID + '.' + B_BD_ID      AS bbdid, ");
		buffer.append("               B_BD_brandName                                          AS bbdbrandname, ");
		buffer.append("               B_GC_GoodsCategoryName                                  AS bgcgoodscategoryname, ");
		buffer.append("               B_BD_GoodsCategory                                      AS bbdgoodscategory ");
		buffer.append("        FROM   B_Brand ");
		buffer.append("               LEFT JOIN B_Supplier ");
		buffer.append("                 ON B_BD_SupplierID = B_SP_ID ");
		buffer.append("               LEFT JOIN dbo.B_GoodsCategory ");
		buffer.append("                 ON B_BD_GoodsCategory = B_GC_ID ");
		buffer.append("        WHERE  1 = 1 ");

		// 品种代码
		if (!"".equals(Utility.getName(brandPo.getBbdid()))) {
			buffer.append(" and B_BD_ID = ? ");
			params.add(brandPo.getBbdid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(brandPo.getBspcategoryid()))) {
			buffer.append(" and B_BD_GoodsCategory = ? ");
			params.add(brandPo.getBspcategoryid());
		}
		
		buffer.append("        GROUP  BY B_BD_ID, ");
		buffer.append("                  B_SP_ID, ");
		buffer.append("                  B_SP_SupplierName, ");
		buffer.append("                  B_BD_brandName, ");
		buffer.append("                  B_BD_GoodsCategory, ");
		buffer.append("                  B_GC_GoodsCategoryName ");
		buffer.append(") table1 ");

		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	public SupplierPo getSupplier(SupplierPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  B_SP_ID as bspid,B_SP_SupplierName as bspsuppliername,B_SP_ContactPerson as bspcontactperson,");
		sb.append("B_SP_ContactPhone as bspcontactphone,B_SP_Fax as bspfax,B_SP_Address as bspaddress,");
		sb.append("B_SP_Remark as bspremark,B_SP_CategoryID as bspcategoryid,");
		sb.append("B_SP_Flag as bspflag from B_Supplier where B_SP_ID=?");

		return (SupplierPo) queryForObject(sb.toString(), new String[] { po
				.getBspid() }, SupplierPo.class);
	}

	public List<VarietyPo> getVarietys(VarietyPo varietyPo, int start, int size) {
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

		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	public BrandPo getBrandPo(BrandPo brandPo) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select top 1 ");
		buffer.append("B_BD_ID as bbdid ");
		buffer.append(",B_BD_brandName as bbdbrandname ");
		buffer.append(",B_BD_SupplierID as bbdsupplierid ");
		buffer.append("from b_brand ");
		buffer.append(" where 1 = 1");

		List<String> params = new ArrayList<String>();

		// 品种代码
		if (!"".equals(Utility.getName(brandPo.getBbdid()))) {
			buffer.append(" and B_BD_ID = ? ");
			params.add(brandPo.getBbdid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(brandPo.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(brandPo.getBbdsupplierid());
		}

		return (BrandPo) this.queryForObject(buffer.toString(), params
				.toArray(), BrandPo.class);
	}
	
	/**
	 * 查询所有在途点
	 * 
	 * @param brandPo
	 * @return
	 */
	public List<InTransitPo> selectInTransit(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select S_SE_SIT_ID as sseitstate,S_SE_SIT_TransitName as sseitintransitname,S_SE_SIT_Flag as sseitflag,S_SE_SIT_IsFlag as sseitisflag from S_SE_SetInTransit order by S_SE_SIT_OrderID ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),InTransitPo.class);
	}
	
	/**
	 * 停用启用在途点
	 * 
	 * @param brandPo
	 * @return
	 */
	public void updateEnabledInTransit(String flag,String inTransitID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append(" update S_SE_SetInTransit set S_SE_SIT_Flag=? where S_SE_SIT_ID=? ");
		
		params.add(Utility.getName(flag));
		params.add(Utility.getName(inTransitID));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

	/**
	 * 查询当前模块所代表的在途点是否已启用
	 * 
	 * @param brandPo
	 * @return
	 */
	public int isEnabledInTransit(String inTransitID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select top 1 S_SE_SIT_Flag from S_SE_SetInTransit where S_SE_SIT_ID=? ");
		
		params.add(Utility.getName(inTransitID));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 查询出价签打印品种Po
	 * @param po
	 * @return
	 */
	public List<BrandPo> selectPrintBrandPo(BrandPo po, int start, int size){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT * ");
		buffer.append("FROM   (SELECT Row_number() OVER(ORDER BY B_BD_GoodsCategory, B_BD_ID) AS 'rowNum', ");
		buffer.append("               B_SP_ID                                                 AS bbdsupplierid, ");
		buffer.append("               B_SP_SupplierName                                       AS bspsuppliername, ");
		buffer.append("               B_BD_GoodsCategory + '.' + B_SP_ID + '.' + B_BD_ID      AS bbdid, ");
		buffer.append("               B_BD_brandName                                          AS bbdbrandname, ");
		buffer.append("               B_UT_unitName                                           AS bbdunitname, ");
		buffer.append("               B_GC_GoodsCategoryName                                  AS bgcgoodscategoryname, ");
		buffer.append("               B_BD_GoodsCategory                                      AS bbdgoodscategory, ");
		buffer.append("               B_BD_Place		                                      AS bbdplace, ");
		buffer.append("               (select top 1 B_GI_RetailPrice  ");
		buffer.append("               from B_GoodsInfo  ");
		buffer.append("               where B_GI_GoodsID like B_BD_GoodsCategory + '.' + B_SP_ID + '.' + B_BD_ID + '%' ");
		buffer.append("               order by B_GI_RetailPrice) AS bbdminretailPrice, ");
		buffer.append("               (select top 1 B_GI_RetailPrice  ");
		buffer.append("               from B_GoodsInfo  ");
		buffer.append("               where B_GI_GoodsID like B_BD_GoodsCategory + '.' + B_SP_ID + '.' + B_BD_ID + '%' ");
		buffer.append("               order by B_GI_RetailPrice desc) AS bbdmaxretailPrice ");
		buffer.append("        FROM   B_Brand ");
		buffer.append("               LEFT JOIN B_Supplier ");
		buffer.append("                 ON B_BD_SupplierID = B_SP_ID ");
		buffer.append("               LEFT JOIN dbo.B_GoodsCategory ");
		buffer.append("                 ON B_BD_GoodsCategory = B_GC_ID ");
		buffer.append("               LEFT JOIN B_Unit ");
		buffer.append("                 ON B_UT_ID = B_BD_Unit ");
		buffer.append("        WHERE  1 = 1 ");

		// 品种代码
		if (!"".equals(Utility.getName(po.getBbdid()))) {
			buffer.append(" and B_BD_ID = ? ");
			params.add(po.getBbdid());
		}

		// 品种名称
		if (!"".equals(Utility.getName(po.getBbdbrandname()))) {
			buffer.append(" and B_BD_brandName like '%' + ? + '%' ");
			params.add(po.getBbdbrandname());
		}

		// 制造商代码
		if (!"".equals(Utility.getName(po.getBbdsupplierid()))) {
			buffer.append(" and B_BD_SupplierID = ? ");
			params.add(po.getBbdsupplierid());
		}

		// 商品类别
		if (!"".equals(Utility.getName(po.getBspcategoryid()))) {
			buffer.append(" and B_BD_GoodsCategory = ? ");
			params.add(po.getBspcategoryid());
		}
		
		buffer.append("        GROUP  BY B_BD_ID, ");
		buffer.append("                  B_SP_ID, ");
		buffer.append("                  B_SP_SupplierName, ");
		buffer.append("                  B_BD_brandName, ");
		buffer.append("                  B_BD_GoodsCategory, ");
		buffer.append("                  B_GC_GoodsCategoryName,B_UT_unitName,B_BD_Place ");
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");
	
		return this.queryForObjectList(buffer.toString(), params.toArray(), BrandPo.class);
	}
	
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 B_GI_GoodsID          AS bgigoodsid, ");
		sb.append("       B_GI_GoodsBarCode           AS bgigoodsbarcode, ");
		sb.append("       B_GI_ViewGoodsName          AS bgigoodsname, ");
		sb.append("       B_GI_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append("       B_GI_SupplierID             AS bgisupplierid, ");
		sb.append("       B_GI_BrandID                AS bgibrandid, ");
		sb.append("       B_GI_UnitId                 AS bgiunitid, ");
		sb.append("       B_GI_RetailPrice            AS bgiretailprice, ");
		sb.append("       B_GI_CostPrice              AS bgicostprice, ");
		sb.append("       B_GI_CostPrice              AS bgicostpriceamount, ");
		sb.append("       B_GI_NotTaxRate             AS bginottaxrate, ");
		sb.append("       B_GI_NotTaxRate             AS bginottaxrateamount, ");
		sb.append("       B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("       B_GI_Spec                   AS bgispec, ");
		sb.append("       (select B_UT_unitName from B_Unit where B_UT_id = B_GI_UnitId)     AS bgiunitname, ");
		sb.append("       case ");
		sb.append("       	when B_GI_GoodsCategoryID = '8' then B_GI_Sph ");
		sb.append("       	else B_GI_Color                   ");
		sb.append("       end 						  AS bgicolor, ");
		sb.append("       B_GI_isCustomize            AS bgiiscustomize, ");
		sb.append("       B_GI_Sph                    AS bgisph, ");
		sb.append("       B_GI_SphUL                  AS bgisphul, ");
		sb.append("       B_GI_SphUP                  AS bgisphup, ");
		sb.append("       B_GI_Cyl                    AS bgicyl, ");
		sb.append("       B_GI_CylUL                  AS bgicylul, ");
		sb.append("       B_GI_CylUP                  AS bgicylup, ");
		sb.append("       B_GI_BelowPlusLuminosity    AS bgibelowplusluminosity, ");
		sb.append("       B_GI_BelowPlusLuminosityUL  AS bgibelowplusluminosityul, ");
		sb.append("       B_GI_BelowPlusLuminosityUP  AS bgibelowplusluminosityup, ");
		sb.append("       B_GI_Axis                   AS bgiaxis, ");
		sb.append("       B_GI_AxisUL                 AS bgiaxisul, ");
		sb.append("       B_GI_AxisUP                 AS bgiaxisup, ");
		sb.append("       B_GI_Curvature1             AS bgicurvature1, ");
		sb.append("       B_GI_Curvature1UL           AS bgicurvature1ul, ");
		sb.append("       B_GI_Curvature1UP           AS bgicurvature1up, ");
		sb.append("       B_GI_Curvature2             AS bgicurvature2, ");
		sb.append("       B_GI_Curvature2UL           AS bgicurvature2ul, ");
		sb.append("       B_GI_Curvature2UP           AS bgicurvature2up, ");
		sb.append("       B_GI_Dia                    AS bgidia, ");
		sb.append("       B_GI_DiaUL                  AS bgidiaul, ");
		sb.append("       B_GI_DiaUP                  AS bgidiaup, ");
		
		sb.append("       cast((dbo.ufn_getWholeSalePriceByDpt(?) * isnull(B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");
		params.add(Utility.getName(po.getBgidepartmentid()));
		
		sb.append("       b_gi_wholesaleprice         AS bgiwholesalepriceamount, ");
		sb.append("       B_GI_isMutiLuminosity       AS bgiismutiluminosity, ");
		sb.append("       B_GI_MutiLuminosityNum      AS bgimutiluminositynum, ");
		sb.append("       B_GI_MutiLuminosityAddPrice AS bgimutiluminosityaddprice, ");
		sb.append("       B_GI_EyeGlassMaterialType   AS bgieyeglassmaterialtype, ");
		sb.append("       B_GI_isPlating              AS bgiisplating, ");
		sb.append("       B_GI_orderCycle             AS bgiordercycle, ");
		sb.append("       B_GI_FinishedGlassesType    AS bgifinishedglassestype, ");
		sb.append("       B_GI_frameProcessCraftType  AS bgiframeprocesscrafttype, ");
		sb.append("       B_GI_CylMin                 AS bgicylmin, ");
		sb.append("       B_GI_CylDegreeIncrease      AS bgicyldegreeincrease, ");
		sb.append("       B_GI_CylMinAddPrice         AS bgicylminaddprice, ");
		sb.append("       B_GI_CylAddPrice            AS bgicyladdprice, ");
		sb.append("       B_GI_PrismAddPrice          AS bgiprismaddprice, ");
		sb.append("       B_GI_cyl25CanNotDo          AS bgicyl25cannotdo, ");
		sb.append("       B_GI_ThrowingCycle          AS bgithrowingcycle, ");
		sb.append("       B_GI_StealthType            AS bgistealthtype, ");
		sb.append("       B_GI_OtherGoodsBigClass     AS bgiothergoodsbigclass, ");
		sb.append("       B_GI_OtherGoodsSmallClass   AS bgiothergoodssmallclass, ");
		sb.append("       B_GI_Flag                   AS bgiflag, ");
		sb.append("       B_GI_Refractive             AS bgirefractive, ");
		sb.append("       B_GI_FrameMaterialType      AS bgiframematerialtype, ");
		sb.append("       B_BD_brandName              AS bgibrandname, ");
		sb.append("       B_BD_Place		      	  AS bgisource, ");
		if("4".equals(po.getBgigoodscategoryid()) || "5".equals(po.getBgigoodscategoryid())){
			sb.append("       kucun.guaranteeperiod     AS guaranteeperiod, ");
			sb.append("       kucun.batch               AS batch, ");
		}
		sb.append("       isnull(kucun.GoodsQuantity,0) + isnull(zaitu.GoodsNum,0) as cshaaemaxquantity ");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("Left join B_Brand on B_GI_SupplierID = B_BD_SupplierID and B_BD_ID = B_GI_BrandID ");
		sb.append(" LEFT JOIN (SELECT SUM(C_SH_SL_GoodsQuantity) AS GoodsQuantity, ");
		sb.append("          C_SH_SL_StockId			as StockId, ");
		sb.append(" 		 C_SH_SL_GoodsBarCode       as GoodsBarCode, ");
		sb.append(" 		 ''    as guaranteeperiod, ");
		sb.append(" 		 ''				as batch ");
		sb.append("     FROM   dbo.C_SH_StorageLog ");
		sb.append("     WHERE  C_SH_SL_StockId = ? ");
		sb.append("            AND C_SH_SL_GoodsBarCode = ? ");
		sb.append(" 	group by C_SH_SL_StockId,C_SH_SL_GoodsBarCode ");
		sb.append(" ) kucun on Substring(kucun.GoodsBarCode, 1, 18) = B_GI_GoodsBarCode ");
		params.add(po.getBgiwarehouseid());
		params.add(po.getBgigoodsbarcode());
		
		
		sb.append(" left join ( ");
		sb.append(" select C_SH_TSE_GoodsID as GoodsId,sum(C_SH_TSE_GoodsNum) as GoodsNum from C_SH_InTransitStorageEntry ");
		sb.append(" where 1=1 ");
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SH_TSE_OUTStockID = ? ");
			params.add(po.getBgiwarehouseid());
		}
		sb.append(" and C_SH_TSE_GoodsBarCode = ? ");
		
		sb.append(" group by C_SH_TSE_GoodsID)zaitu ");
		sb.append(" on B_GI_GoodsID = zaitu.GoodsId ");		
		
		params.add(po.getBgigoodsbarcode());
		
		sb.append("WHERE  B_GI_GoodsBarCode = ? ");			
		params.add(po.getBgigoodsbarcode().substring(0, 18));
		
		if(!"".equals(Utility.getName(po.getBgijm()))){
			sb.append("and  B_GI_WholeGoodsIsable = '1' ");
			
		}
		
		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);  
	}
	
	/**
	 * 获取价格区间
	 * 
	 * @return
	 */
	public List<SalesAreaPo> getSalesAreaList(SalesAreaPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select R_RC_SA_ID as rsaid,R_RC_SA_ReportID as rsareportid,R_RC_SA_PriceMin as rsapricemin,R_RC_SA_PriceMax as rsapricemax,R_RC_SA_PriceMinDes as rsapricemindes,R_RC_SA_PriceMaxDes as rsapricemaxdes from R_RC_SalesArea where R_RC_SA_ReportID=? ");
		buffer.append("order by cast(R_RC_SA_PriceMin as float) ");
		
		params.add(Utility.getName(po.getRsareportid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(),SalesAreaPo.class);
	}

	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(
			String goodsCategoryID, String typeID, String salesTypeID) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT R_RC_SA_ID          AS rrcsaid, ");
		buffer.append("       R_RC_SA_ReportID    AS rrcsareportid, ");
		buffer.append("       R_RC_SA_PriceMin    AS rrcsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax    AS rrcsapricemax, ");
		buffer.append("       R_RC_SA_PriceMin    AS rsapricemin, ");
		buffer.append("       R_RC_SA_PriceMax    AS rsapricemax, ");
		buffer.append("       R_RC_SA_PriceMinDes AS rrcsapricemindes, ");
		buffer.append("       R_RC_SA_PriceMaxDes AS rrcsapricemaxdes, ");
		buffer.append("       R_RC_SA_SalesType AS rrcsasalestype, ");
		buffer.append("       R_RC_SA_GoodsCategoryID AS rrcsagoodscategoryid ");
		buffer.append("FROM   R_RC_SalesArea ");
		buffer.append("WHERE  1=1 ");
		if(null != goodsCategoryID && !"".equals(goodsCategoryID)) {
			buffer.append(" AND R_RC_SA_GoodsCategoryID = ? ");
			params.add(goodsCategoryID);
		}
		if(null != salesTypeID && !"".equals(salesTypeID)) {
			buffer.append(" AND R_RC_SA_SalesType = ? ");
			params.add(salesTypeID);
		}
		buffer.append("order by cast(R_RC_SA_PriceMin as float) ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesAreaPo.class);
	}
	
	public GoodsInfoPo getWholsGoodsInfoByScan(GoodsInfoPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 B_GI_GoodsID          AS bgigoodsid, ");
		sb.append("       B_GI_ViewGoodsName          AS bgigoodsname, ");
		sb.append("       B_GI_Spec                   AS bgispec ");
		sb.append("FROM   B_GoodsInfo ");	
		sb.append("WHERE  B_GI_GoodsBarCode = ? and B_GI_SupplierID <> 'ZZ' ");
		
		params.add(Utility.getName(po.getBgigoodsbarcode()));
		
		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);  
	}
	
}
