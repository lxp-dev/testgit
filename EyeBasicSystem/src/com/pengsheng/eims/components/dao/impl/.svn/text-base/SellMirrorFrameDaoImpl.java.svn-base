package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.SellMirrorFrameDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SellMirrorFrameDaoImpl extends BaseJdbcDaoSupport implements
		SellMirrorFrameDao {
	/**
	 * 查询销售镜架数量
	 */
	public int getSellMirrorFrameCount(GoodsInfoPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		sb.append("SELECT ");
		sb.append("       count(bgigoodsid) ");
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		sb.append("               b_gi_retailprice     AS bgiretailprice, ");
		sb.append("               B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append("               B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("               B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("               B_BD_brandName       AS bgibrandname, ");
		sb.append("               B_GI_CostPrice       AS bgicostprice, ");
		sb.append("               B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("               B_GI_Spec            AS bgispec, ");
		sb.append("               B_GI_Color           AS bgicolor ");
		sb.append("        FROM   B_GoodsInfo ");
		sb.append("               INNER JOIN B_Supplier ");
		sb.append("                 ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
		sb.append("               INNER JOIN B_Brand ");
		sb.append("                 ON B_GI_BrandID = B_BD_ID ");
		sb.append("                    AND B_GI_SupplierID = B_BD_SupplierID ");
		sb.append("        WHERE  1=1 ");
		sb.append("               AND B_GI_Flag = '1' ");
		
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}else{
			if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
				sb.append(" and B_GI_GoodsCategoryID = ? ");
				sb.append(" and B_GI_GoodsBarCode like ? + '%' ");
				params.add(po.getBgigoodsbarcode().substring(0, 1));
				params.add(po.getBgigoodsbarcode());
			}
		}
		
		
		sb.append("				  ) TEMP ");
		sb.append("       LEFT JOIN (SELECT C_SH_SB_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("                         C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                         C_SH_SB_StockId       AS warehouseid ");
		sb.append("                  FROM   C_SH_StorageBeginning ");
		sb.append("                  WHERE  1 = 1 ");
		sb.append("                         AND C_SH_SB_StockId = ? ");
		sb.append("                  UNION ALL ");
		sb.append("                  SELECT C_SH_SC_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("                         C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                         C_SH_SC_StockId       AS warehouseid ");
		sb.append("                  FROM   C_SH_StorageChange ");
		sb.append("                  WHERE  1 = 1 ");
		sb.append("                         AND C_SH_SC_StockId = ?) temp1 ");
		sb.append("         ON bgigoodsbarcode = temp1.GoodsBarCode where 1=1 ");

		
		
		
		
		params.add(Utility.getName(po.getOutstockidone()));
		params.add(Utility.getName(po.getOutstockidone()));
		
		
		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	public int getSellMirrorFrameCountAll(GoodsInfoPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(*) from ( ");
		sb.append("SELECT bgigoodsid as bgigoodsid,goodsQuantity as goodsQuantity ");
		
		//新增显示内容 end
		
		sb.append("FROM   (SELECT ");
		sb.append("  B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("               warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename, ");
		sb.append("               B_GI_Color           AS bgicolor, ");
		sb.append("               isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			if(!"ZZ".equals(po.getBgisupplierid())){
				sb.append(" union all ");
				sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
				sb.append(" where B_WC_deptID = ? ");
				params.add(Utility.getName(po.getBgiwarehouseid()));
			}
		}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = ? ");
		}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
				sb.append(" where B_WC_deptID = ? ");
			}else{
				sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
				sb.append(" where B_WC_deptID = ? ");
			}
		}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
				sb.append(" where B_WC_deptID = ? ");
			}else{
				sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
				sb.append(" where B_WC_deptID = ? ");
			}
		}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = ? ");
		}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = ? ");
		}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = ? ");
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = ? ");
		}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = ? ");
		}
		params.add(Utility.getName(po.getBgiwarehouseid()));
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgiunitid()))){
			sb.append(" and B_GI_SupplierID <> 'zz' ");
		}else{
			sb.append(" and B_GI_SupplierID = 'zz' ");
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) and cast(B_GI_SphUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgisph()))){
				sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
				params.add(Utility.getName(po.getBgisph()));
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		
		if("ZZ".equals(Utility.getName(po.getBgisupplierid())) || "D".equals(po.getBgiiscustomize())){
			sb.append(" left ");
		}else{
			if("1".equals(Utility.getName(po.getBgigoodsquantity()))){
				sb.append(" INNER ");
			}else{
				sb.append(" left ");
			}
		}
		
		sb.append(" join (  ");
		sb.append("         select StockId AS StockId,goodsId as goodsId,sum(goodsQuantity) as goodsQuantity from ( ");
		sb.append(" 		select C_SH_SB_StockId AS StockId,C_SH_SB_GoodsId as goodsId,C_SH_SB_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageBeginning ");
		sb.append(" 		union all ");
		sb.append(" 		select C_SH_Sc_StockId AS StockId,C_SH_SC_GoodsId as goodsId,C_SH_SC_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageChange ");
		sb.append(" 		) temp  ");
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("where substring(goodsId,1,1) = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		sb.append(" 		and  stockid   in (select B_WH_ID from B_Warehouse)");
		sb.append(" 	group by StockId,goodsId ");	
		
		sb.append(" ) temp1 ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
		
//		if(!"ZZ".equals(Utility.getName(po.getBgisupplierid()))){
//			if("0".equals(Utility.getName(po.getQueryType()))&&!"D".equals(po.getBgiiscustomize())){
//				sb.append(" AND isnull(temp1.goodsQuantity,0) > 0 ");
//			}else if("1".equals(Utility.getName(po.getBgigoodsquantity()))&&!"D".equals(po.getBgiiscustomize())){
//				sb.append(" AND isnull(temp1.goodsQuantity,0) > 0 ");
//			}
//		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgisupplierid()))){
			if("0".equals(Utility.getName(po.getQueryType()))&&!"D".equals(po.getBgiiscustomize())){				
				if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
					sb.append("where isnull(goodsQuantity,0) >= 0 ");
				}else{
					sb.append("where isnull(goodsQuantity,0) > 0 ");
				}			
			} else if("1".equals(Utility.getName(po.getBgigoodsquantity()))&&!"D".equals(po.getBgiiscustomize())){
				sb.append("where isnull(goodsQuantity,0) > 0 ");
			}
		}
		
		sb.append(" )temp2 ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getSellMirrorFrameCountBatch(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("declare @count varchar(10) ");
		sb.append("select @count = count(C_SH_SL_UUID) from dbo.C_SH_StorageLog_YXAndHLY  ");

		sb.append("select count(*) from( ");
		sb.append("SELECT *,dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount from (SELECT ROW_NUMBER() Over(order by bgigoodsid) as rowNum, bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append("  bgiretailprice     AS bgiretailprice, ");
		sb.append("  temp1.bgigoodsbarcode    AS bgigoodsbarcode, ");
		sb.append("  temp1.guaranteeperiod as guaranteeperiod, ");
		sb.append("  temp1.batch        as batch, ");
		sb.append("  bgigoodsid         AS bgigoodsid, ");
		sb.append("  bgigoodsname       AS bgigoodsname, ");
		sb.append("  bgibrandname       AS bgibrandname, ");
		sb.append("  bgicostprice       AS bgicostprice, ");
		sb.append("  bginottaxrate      AS bginottaxrate, ");
		sb.append("  bgispec            AS bgispec, ");
		sb.append("  bgicolor           AS bgicolor, ");
		sb.append("  bgiiscustomize     AS bgiiscustomize, ");
		
		//新增显示内容 begi
		sb.append("  bgiframematerialtype           AS bgiframematerialtype, ");
		sb.append("  bgiframesize     AS bgiframesize , ");
		sb.append("  bgiaccessoriestype     AS bgiaccessoriestype , ");
		sb.append("  bgisph     AS bgisph , ");
		sb.append("  bgicyl     AS bgicyl , ");
		sb.append("  bgibelowplusluminosity     AS bgibelowplusluminosity , ");
		sb.append("  bgirefractive     AS bgirefractive , ");
		sb.append("  bgiismutiluminosity     AS bgiismutiluminosity , ");
		sb.append("  bgieyeglassmaterialtype     AS bgieyeglassmaterialtype , ");
		sb.append("  bgigradualclass     AS bgigradualclass , ");
		sb.append("  bgisphul     AS bgisphul , ");
		sb.append("  bgisphup     AS bgisphup , ");
		sb.append("  bgicylul     AS bgicylul , ");
		sb.append("  bgicylup     AS bgicylup , ");
		sb.append("  bgiaxis     AS bgiaxis , ");
		sb.append("  bgibelowplusluminosityul     AS bgibelowplusluminosityul , ");
		sb.append("  bgibelowplusluminosityup     AS bgibelowplusluminosityup , ");
		sb.append("  bgifunctionclass     AS bgifunctionclass , ");
		sb.append("  bgicurvature1     AS bgicurvature1 , ");
		sb.append("  bgidia     AS bgidia , ");
		sb.append("  bgiusetype     AS bgiusetype , ");
		sb.append("  bgistealthclass     AS bgistealthclass , ");
		sb.append("  bgiaxisul     AS bgiaxisul , ");
		sb.append("  bgiaxisup     AS bgiaxisup , ");
		sb.append("  bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append("  bgicurvature1up     AS bgicurvature1up , ");
		sb.append("  bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append("  bgicurvature2up     AS bgicurvature2up , ");
		sb.append("  bgicapacity     AS bgicapacity , ");
		sb.append("  bgicapacityentry     AS bgicapacityentry , ");
		sb.append("  bgiordercycle     AS bgiordercycle , ");
		sb.append("  bgisuppliercolor     AS bgisuppliercolor , ");
		sb.append("  bgiwarehouseid       AS bgiwarehouseid , ");
		sb.append("  bgiwarehousename     as bgiwarehousename , ");
		sb.append("  bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename , ");
		sb.append("  isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity  ");
		
		//新增显示内容 end
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		sb.append(" B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append(" B_GI_GoodsID         AS bgigoodsid, ");
		sb.append(" B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append(" B_BD_brandName       AS bgibrandname, ");
		sb.append(" B_GI_CostPrice       AS bgicostprice, ");
		sb.append(" B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append(" B_GI_Spec            AS bgispec, ");
		
		//新增显示内容 beg
		sb.append(" B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append(" B_GI_FrameSize     AS bgiframesize , ");
		sb.append(" B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append(" B_GI_Sph     AS bgisph , ");
		sb.append(" B_GI_Cyl     AS bgicyl , ");
		sb.append(" B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append(" B_GI_Refractive     AS bgirefractive , ");
		sb.append(" B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append(" B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append(" B_GI_GradualClass     AS bgigradualclass , ");
		sb.append(" B_GI_SphUL     AS bgisphul , ");
		sb.append(" B_GI_SphUP     AS bgisphup , ");
		sb.append(" B_GI_CylUL     AS bgicylul , ");
		sb.append(" B_GI_CylUP     AS bgicylup , ");
		sb.append(" B_GI_Axis     AS bgiaxis , ");
		sb.append(" B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul , ");
		sb.append(" B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup , ");
		sb.append(" B_GI_FunctionClass     AS bgifunctionclass , ");
		sb.append(" B_GI_Curvature1     AS bgicurvature1 , ");
		sb.append(" B_GI_Dia     AS bgidia , ");
		sb.append(" B_GI_UseType     AS bgiusetype , ");
		sb.append(" B_GI_StealthClass     AS bgistealthclass , ");
		sb.append(" B_GI_AxisUL     AS bgiaxisul , ");
		sb.append(" B_GI_AxisUP     AS bgiaxisup , ");
		sb.append(" B_GI_Curvature1UL     AS bgicurvature1ul , ");
		sb.append(" B_GI_Curvature1UP     AS bgicurvature1up , ");
		sb.append(" B_GI_Curvature2UL     AS bgicurvature2ul , ");
		sb.append(" B_GI_Curvature2UP     AS bgicurvature2up , ");
		sb.append(" B_GI_Capacity         AS bgicapacity , ");
		sb.append(" B_GI_CapacityEntry    AS bgicapacityentry , ");
		sb.append(" B_GI_orderCycle       AS bgiordercycle , ");
		sb.append(" B_GI_SupplierColor    AS bgisuppliercolor , ");
		sb.append(" B_FM_Name             AS bgieyeglassmaterialtypename , ");
		sb.append("               warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename, ");
		sb.append("               B_GI_Color           AS bgicolor, ");
		sb.append("               isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))&&"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			if(!"ZZ".equals(po.getBgisupplierid())){
				sb.append(" union all ");
				sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
				sb.append(" where B_WC_deptID = ? ");
				params.add(Utility.getName(po.getBgiwarehouseid()));
			}
			
		}else if("".equals(Utility.getName(po.getBgiother()))){
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = ? ");
			}
			
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select wt.warehouseId,wt.warehouseName from ( ");
			sb.append(" select B_WC_StockID1 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" )wt group by wt.warehouseId,wt.warehouseName");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" and B_GI_GoodsCategoryID in('1','2','5','6','7','8','9') ");
		}
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) and cast(B_GI_SphUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(isnull(B_GI_BelowPlusLuminosity,0) as float ) = cast( ? as float ) ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
				}
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		sb.append(" left join (  ");
		sb.append("					SELECT  StockId            AS StockId, ");
		sb.append("                         goodsId            AS goodsId, ");
		sb.append("						    bgigoodsbarcode as bgigoodsbarcode, ");
		sb.append("                         SUM(goodsQuantity) AS goodsQuantity, ");
		sb.append("						CASE ");
		sb.append("						 WHEN guaranteeperiod = '' THEN '无效期' ");
		sb.append("						 WHEN guaranteeperiod is null  THEN '无效期' ");
		sb.append("					     ELSE guaranteeperiod ");
		sb.append("						END as guaranteeperiod, ");
		sb.append("						CASE ");
		sb.append("						 WHEN batch = '' THEN '无批号' ");
		sb.append("						 WHEN batch is null  THEN '无批号' ");
		sb.append("					     ELSE batch ");
		sb.append("						END as batch ");
		sb.append("                 FROM   ( ");
		sb.append("                          SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append("                                 C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("								    C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append("                                 C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch ");
		sb.append("                          FROM   dbo.C_SH_StorageLog_YXAndHLY ");
		sb.append("   union all ");
		sb.append("                          SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append("                                 C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("								    C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append("                                 C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch ");
		sb.append("                          FROM   dbo.C_SH_StorageLog ");
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" where substring(C_SH_Sl_GoodsId,1,1) = ? and ((@count <> '0' and convert(varchar(10),C_SH_SL_WarehousingDate,120) > (select top 1 convert(varchar(10),C_SH_SL_WarehousingDate,120) from dbo.C_SH_StorageLog_YXAndHLY)) or @count = '0') ");
			params.add(po.getBgigoodscategoryid());
		}
		
		sb.append("                ) TEMP  GROUP  BY StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch) temp1 ");
		sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
		sb.append(" 	where 1=1 ");
		if("4".equals(Utility.getName(po.getBgigoodscategoryid())) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"D".equals(po.getBgiiscustomize()) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
					sb.append(" and temp1.bgigoodsbarcode = ? ");
					params.add(po.getBgigoodsbarcode());
				}
			}
		}
		if(!"D".equals(po.getBgiiscustomize())){
			sb.append(" and isnull(temp1.bgigoodsbarcode,'') <> '' ");
		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgisupplierid()))){
			if("0".equals(Utility.getName(po.getQueryType()))&&!"D".equals(po.getBgiiscustomize())){
				sb.append("and isnull(temp1.goodsQuantity,0) > 0 ");
			}else if("1".equals(Utility.getName(po.getBgigoodsquantity()))&&!"D".equals(po.getBgiiscustomize())){
				sb.append("and isnull(temp1.goodsQuantity,0) > 0 ");
			}
		}
		sb.append(" )temp )asd");
		
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 查询销售镜架数量
	 */
	public int getSellMirrorFrameCount1(GoodsInfoPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");
		sb.append("where 1=1 ");

		List<String> params=new ArrayList<String>();
		if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			sb.append(" and B_GI_GoodsBarCode = ? ");
			params.add(po.getBgigoodsbarcode());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<GoodsInfoPo> getSellMirrorFrameListAll(GoodsInfoPo po,int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;  

		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT *,");
		if(po.getSystemparameterlevel().equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevel(bgigoodsid,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscount(bgigoodsid,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		sb.append(" dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid) AS bgiintransitgoodsnum,");
		sb.append(" case ");
		sb.append(" 	when isnull(bgigoodsquantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid),0) > 0 then '' ");
		sb.append(" 	when isnull(bgigoodsquantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid),0) <= 0 then '(无现货)' ");
		sb.append(" end as bgiishavestock ");
		sb.append(" from (SELECT ROW_NUMBER() Over(order by bgigoodsid) as rowNum, bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append(" bgiretailprice     	AS bgiretailprice, ");
		sb.append(" bgigoodsbarcode+'00000000'    AS bgigoodsbarcode, ");
		sb.append(" bgigoodsid         	AS bgigoodsid, ");
		sb.append(" bgigoodsname       	AS bgigoodsname, ");
		sb.append(" bgibrandname       	AS bgibrandname, ");
		sb.append(" bgicostprice       	AS bgicostprice, ");
		sb.append(" bginottaxrate      	AS bginottaxrate, ");
		sb.append(" bgispec            	AS bgispec, ");
		sb.append(" bgicolor           	AS bgicolor, ");
		sb.append(" bgiiscustomize     	AS bgiiscustomize, ");
		
		//新增显示内容 begin
		sb.append(" bgiframematerialtype           AS bgiframematerialtype, ");
		sb.append(" bgiframesize     	AS bgiframesize , ");
		sb.append(" bgiaccessoriestype  AS bgiaccessoriestype , ");
		sb.append(" bgisph     			AS bgisph , ");
		sb.append(" bgicyl     			AS bgicyl , ");
		sb.append(" bgibelowplusluminosity     AS bgibelowplusluminosity , ");
		sb.append(" bgirefractive     	AS bgirefractive , ");
		sb.append(" bgiismutiluminosity AS bgiismutiluminosity , ");
		sb.append(" bgieyeglassmaterialtype     AS bgieyeglassmaterialtype , ");
		sb.append(" bgigradualclass     AS bgigradualclass , ");
		sb.append(" bgisphul     		AS bgisphul , ");
		sb.append(" bgisphup     		AS bgisphup , ");
		sb.append(" bgicylul     		AS bgicylul , ");
		sb.append(" bgicylup     		AS bgicylup , ");
		sb.append(" bgiaxis     		AS bgiaxis , ");
		sb.append(" bgibelowplusluminosityul     AS bgibelowplusluminosityul , ");
		sb.append(" bgibelowplusluminosityup     AS bgibelowplusluminosityup , ");
		sb.append(" bgifunctionclass    AS bgifunctionclass , ");
		sb.append(" bgicurvature1     	AS bgicurvature1 , ");
		sb.append(" bgidia     			AS bgidia , ");
		sb.append(" bgiusetype     		AS bgiusetype , ");
		sb.append(" bgistealthclass     AS bgistealthclass , ");
		sb.append(" bgiaxisul     		AS bgiaxisul , ");
		sb.append(" bgiaxisup     		AS bgiaxisup , ");
		sb.append(" bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append(" bgicurvature1up     AS bgicurvature1up , ");
		sb.append(" bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append(" bgiviewgoodsname    AS bgiviewgoodsname, ");
		sb.append(" bgicurvature2up     AS bgicurvature2up , ");
		sb.append(" bgicapacity         AS bgicapacity , ");
		sb.append(" bgicapacityentry    AS bgicapacityentry , ");
		sb.append(" bgiordercycle       AS bgiordercycle , ");
		sb.append(" bgisuppliercolor    AS bgisuppliercolor , ");
		sb.append(" bgiwarehouseid      AS bgiwarehouseid , ");
		sb.append(" bgiwarehousename    as bgiwarehousename , ");
		sb.append(" bgisungglassesfun   as bgisungglassesfun , ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue, ");
		sb.append(" bgidefaultdiscountvaluename as bgidefaultdiscountvaluename, ");
		sb.append(" bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename , ");
		sb.append(" isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity  ");
		
		//新增显示内容 end
		
		
		
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		sb.append(" B_GI_GoodsBarCode  AS bgigoodsbarcode, ");
		sb.append(" B_GI_GoodsID       AS bgigoodsid, ");
		sb.append(" B_GI_ViewGoodsName AS bgigoodsname, ");
		sb.append(" B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue, ");
		sb.append(" B_GL_Name		   AS bgidefaultdiscountvaluename, ");
		sb.append(" B_BD_brandName     AS bgibrandname, ");
		sb.append(" B_GI_CostPrice     AS bgicostprice, ");
		sb.append(" B_GI_NotTaxRate    AS bginottaxrate, ");
		sb.append(" B_GI_Spec          AS bgispec, ");
		sb.append(" B_GI_SunGglassesFun          AS bgisungglassesfun, ");
		
		//新增显示内容 begin
		sb.append(" B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append(" B_GI_FrameSize     AS bgiframesize , ");
		sb.append(" B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append(" B_GI_Sph     AS bgisph , ");
		sb.append(" B_GI_Cyl     AS bgicyl , ");
		sb.append("               B_GI_ViewGoodsName         AS bgiviewgoodsname, ");
		sb.append(" B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append(" B_GI_Refractive     AS bgirefractive , ");
		sb.append(" B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append(" B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append(" B_GI_GradualClass     AS bgigradualclass , ");
		sb.append(" B_GI_SphUL     AS bgisphul , ");
		sb.append(" B_GI_SphUP     AS bgisphup , ");
		sb.append(" B_GI_CylUL     AS bgicylul , ");
		sb.append(" B_GI_CylUP     AS bgicylup , ");
		sb.append(" B_GI_Axis     AS bgiaxis , ");
		sb.append(" B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul , ");
		sb.append(" B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup , ");
		sb.append(" B_GI_FunctionClass     AS bgifunctionclass , ");
		sb.append(" B_GI_Curvature1     AS bgicurvature1 , ");
		sb.append(" B_GI_Dia     AS bgidia , ");
		sb.append(" B_GI_UseType     AS bgiusetype , ");
		sb.append(" B_GI_StealthClass     AS bgistealthclass , ");
		sb.append(" B_GI_AxisUL     AS bgiaxisul , ");
		sb.append(" B_GI_AxisUP     AS bgiaxisup , ");
		sb.append(" B_GI_Curvature1UL   AS bgicurvature1ul , ");
		sb.append(" B_GI_Curvature1UP   AS bgicurvature1up , ");
		sb.append(" B_GI_Curvature2UL   AS bgicurvature2ul , ");
		sb.append(" B_GI_Curvature2UP   AS bgicurvature2up , ");
		sb.append(" B_GI_Capacity       AS bgicapacity , ");
		sb.append(" B_GI_CapacityEntry  AS bgicapacityentry , ");
		sb.append(" B_GI_orderCycle     AS bgiordercycle , ");
		sb.append(" B_GI_SupplierColor  AS bgisuppliercolor , ");
		sb.append(" B_FM_Name           AS bgieyeglassmaterialtypename , ");
		sb.append("               warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename, ");		
		sb.append("               B_GI_Color           AS bgicolor, ");
		sb.append("               isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		sb.append(" cross join ( ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
				sb.append(" where B_WC_deptID = ? ");
				if(!"ZZ".equals(po.getBgisupplierid())){
					sb.append(" union all ");
					sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
					sb.append(" where B_WC_deptID = ? ");
					params.add(Utility.getName(po.getBgiwarehouseid()));
				}
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = ? ");
			}
			params.add(Utility.getName(po.getBgiwarehouseid()));
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgiunitid()))){
			sb.append(" and B_GI_SupplierID <> 'zz' ");
		}else{
			sb.append(" and B_GI_SupplierID = 'zz' ");
		}
		
		if(!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) and cast(B_GI_SphUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
				
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append(" and cast(isnull(B_GI_BelowPlusLuminosity,0) as float ) = cast( ? as float ) ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
				}
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgisph()))){
				sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
				params.add(Utility.getName(po.getBgisph()));
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		if("ZZ".equals(Utility.getName(po.getBgisupplierid())) || "D".equals(po.getBgiiscustomize())){
			sb.append(" left ");
		}else{
			if("1".equals(Utility.getName(po.getBgigoodsquantity()))){
				sb.append(" INNER ");
			}else{
				sb.append(" left ");
			}
		}
		sb.append(" join (  ");
		sb.append("         select StockId AS stockId,goodsId as goodsId,sum(goodsQuantity) as goodsQuantity from ( ");
		sb.append(" 		select C_SH_SB_StockId AS StockId,C_SH_SB_GoodsId as goodsId,C_SH_SB_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageBeginning ");
		sb.append(" 		union all ");
		sb.append(" 		select C_SH_Sc_StockId AS StockId,C_SH_SC_GoodsId as goodsId,C_SH_SC_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageChange ");
		sb.append(" 		) temp  ");
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("where substring(goodsId,1,1) = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		sb.append(" 	group by StockId,goodsId ");
		sb.append(" 	) temp1 ");
		sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.stockId ");
		
		if(!"ZZ".equals(Utility.getName(po.getBgisupplierid()))){
			if("0".equals(Utility.getName(po.getQueryType()))&&!"D".equals(po.getBgiiscustomize())){				
				if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
					sb.append("where isnull(goodsQuantity,0) >= 0 ");
				}else{
					sb.append("where isnull(goodsQuantity,0) > 0 ");
				}			
			} else if("1".equals(Utility.getName(po.getBgigoodsquantity()))&&!"D".equals(po.getBgiiscustomize())){
				sb.append("where isnull(goodsQuantity,0) > 0 ");
			}
		}
		
		sb.append(" )temp2 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" order by bgiwarehouseid desc ");
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListBatch(GoodsInfoPo po,int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;  

		sb.append("declare @count varchar(10) ");
		sb.append("select @count = count(C_SH_SL_UUID) from dbo.C_SH_StorageLog_YXAndHLY  ");
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT *, ");
		if(po.getSystemparameterlevel().equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevel(bgigoodsid,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscount(bgigoodsid,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		sb.append("dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid) AS bgiintransitgoodsnum ");
		sb.append("from (SELECT ROW_NUMBER() Over(order by bgigoodsid) as rowNum, bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append("       bgiretailprice     AS bgiretailprice, ");
		sb.append("       temp1.bgigoodsbarcode    AS bgigoodsbarcode, ");
		sb.append("       temp1.guaranteeperiod as guaranteeperiod, ");
		sb.append("       temp1.batch        as batch, ");
		sb.append("       bgigoodsid         AS bgigoodsid, ");
		sb.append("       bgigoodsname       AS bgigoodsname, ");
		sb.append("       bgibrandname       AS bgibrandname, ");
		sb.append("       bgicostprice       AS bgicostprice, ");
		sb.append("       bginottaxrate      AS bginottaxrate, ");
		sb.append("       bgispec            AS bgispec, ");
		sb.append("       bgicolor           AS bgicolor, ");
		sb.append("       bgiiscustomize     AS bgiiscustomize, ");
		sb.append(" 	  bgidefaultdiscountvalue as bgidefaultdiscountvalue, ");
		sb.append(" 	  bgidefaultdiscountvaluename as bgidefaultdiscountvaluename, ");
		
		//新增显示内容 begin
		sb.append("       bgiframematerialtype           AS bgiframematerialtype, ");
		sb.append("       bgiframesize     AS bgiframesize , ");
		sb.append("       bgiaccessoriestype     AS bgiaccessoriestype , ");
		sb.append("       bgisph     AS bgisph , ");
		sb.append("       bgicyl     AS bgicyl , ");
		sb.append("       bgibelowplusluminosity     AS bgibelowplusluminosity , ");
		sb.append("       bgirefractive     AS bgirefractive , ");
		sb.append("       bgiismutiluminosity     AS bgiismutiluminosity , ");
		sb.append("       bgieyeglassmaterialtype     AS bgieyeglassmaterialtype , ");
		sb.append("       bgigradualclass     AS bgigradualclass , ");
		sb.append("       bgisphul     AS bgisphul , ");
		sb.append("       bgisphup     AS bgisphup , ");
		sb.append("       bgicylul     AS bgicylul , ");
		sb.append("       bgicylup     AS bgicylup , ");
		sb.append("       bgiviewgoodsname       AS bgiviewgoodsname, ");
		sb.append("       bgiaxis     AS bgiaxis , ");
		sb.append("       bgibelowplusluminosityul     AS bgibelowplusluminosityul , ");
		sb.append("       bgibelowplusluminosityup     AS bgibelowplusluminosityup , ");
		sb.append("       bgifunctionclass     AS bgifunctionclass , ");
		sb.append("       bgicurvature1     AS bgicurvature1 , ");
		sb.append("       bgidia     AS bgidia , ");
		sb.append("       bgiusetype     AS bgiusetype , ");
		sb.append("       bgistealthclass     AS bgistealthclass , ");
		sb.append("       bgiaxisul     AS bgiaxisul , ");
		sb.append("       bgiaxisup     AS bgiaxisup , ");
		sb.append("       bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append("       bgicurvature1up     AS bgicurvature1up , ");
		sb.append("       bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append("       bgicurvature2up     AS bgicurvature2up , ");
		sb.append("       bgicapacity     AS bgicapacity , ");
		sb.append("       bgicapacityentry     AS bgicapacityentry , ");
		sb.append("       bgiordercycle     AS bgiordercycle , ");
		sb.append("       bgisuppliercolor     AS bgisuppliercolor , ");
		sb.append("       bgiwarehouseid       AS bgiwarehouseid , ");
		sb.append("       bgiwarehousename     as bgiwarehousename , ");
		sb.append("       bgisungglassesfun    				AS bgisungglassesfun , ");
		sb.append("       bgieyeglassmaterialtypename       AS bgieyeglassmaterialtypename , ");
		sb.append("       isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity  ");
		
		//新增显示内容 end
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		sb.append("               B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append("               B_GI_ViewGoodsName         AS bgiviewgoodsname, ");
		sb.append("               B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("               B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("               B_BD_brandName       AS bgibrandname, ");
		sb.append("               B_GI_CostPrice       AS bgicostprice, ");
		sb.append("               B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("               B_GI_Spec            AS bgispec, ");
		
		//新增显示内容 begin
		sb.append("               B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append("               B_GI_FrameSize     AS bgiframesize , ");
		sb.append("               B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append("               B_GI_Sph     AS bgisph , ");
		sb.append("               B_GI_Cyl     AS bgicyl , ");
		sb.append("               B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append("               B_GI_Refractive     AS bgirefractive , ");
		sb.append("               B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append("               B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append("               B_GI_GradualClass     AS bgigradualclass , ");
		sb.append("               B_GI_SphUL     AS bgisphul , ");
		sb.append("               B_GI_SphUP     AS bgisphup , ");
		sb.append("               B_GI_CylUL     AS bgicylul , ");
		sb.append("               B_GI_CylUP     AS bgicylup , ");
		sb.append("               B_GI_Axis     AS bgiaxis , ");
		sb.append(" 			  B_GI_SunGglassesFun   AS bgisungglassesfun , ");
		sb.append("               B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul , ");
		sb.append("               B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup , ");
		sb.append("               B_GI_FunctionClass     AS bgifunctionclass , ");
		sb.append("               B_GI_Curvature1     AS bgicurvature1 , ");
		sb.append("               B_GI_Dia     AS bgidia , ");
		sb.append("               B_GI_UseType     AS bgiusetype , ");
		sb.append("               B_GI_StealthClass     AS bgistealthclass , ");
		sb.append("               B_GI_AxisUL     AS bgiaxisul , ");
		sb.append("               B_GI_AxisUP     AS bgiaxisup , ");
		sb.append("               B_GI_Curvature1UL     AS bgicurvature1ul , ");
		sb.append("               B_GI_Curvature1UP     AS bgicurvature1up , ");
		sb.append("               B_GI_Curvature2UL     AS bgicurvature2ul , ");
		sb.append("               B_GI_Curvature2UP     AS bgicurvature2up , ");
		sb.append("               B_GI_Capacity         AS bgicapacity , ");
		sb.append("               B_GI_CapacityEntry    AS bgicapacityentry , ");
		sb.append("               B_GI_orderCycle       AS bgiordercycle , ");
		sb.append("               B_GI_SupplierColor    AS bgisuppliercolor , ");
		sb.append("               B_FM_Name             AS bgieyeglassmaterialtypename , ");
		sb.append("               warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename, ");
		sb.append(" B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue, ");
		sb.append(" B_GL_Name		   AS bgidefaultdiscountvaluename, ");
		
//		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
//			sb.append("        isnull(warehouseId,(select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?))         AS bgiwarehouseid , ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			sb.append("        isnull(warehouseName,(select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)))    AS bgiwarehousename, ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//		}else{
//			sb.append("               case ");
//			sb.append("					when B_GI_GoodsCategoryID = '1' then (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '2' then (select B_WC_StockID2 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' then (select B_WC_StockID3 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' then (select B_WC_StockID4 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '5' then (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '6' then (select B_WC_StockID8 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '7' then (select B_WC_StockID9 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '8' then (select B_WC_StockID11 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			sb.append("					when B_GI_GoodsCategoryID = '9' then (select B_WC_StockID12 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			sb.append("				else '' ");
//			sb.append("			    end                                         AS bgiwarehouseid, ");
//			sb.append("               case ");
//			sb.append("					when B_GI_GoodsCategoryID = '1' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '2' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID2 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID3 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID4 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '5' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '6' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID8 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '7' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID9 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '8' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID11 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			sb.append("					when B_GI_GoodsCategoryID = '9' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID12 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			sb.append("				else '' ");
//			sb.append("			    end                                         AS bgiwarehousename, ");
//		}
		//新增显示内容 end.
		
		sb.append("               B_GI_Color           AS bgicolor, ");
		sb.append("               isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))&&"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			if(!"ZZ".equals(po.getBgisupplierid())){
				sb.append(" union all ");
				sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
				sb.append(" where B_WC_deptID = ? ");
				params.add(Utility.getName(po.getBgiwarehouseid()));
			}
			
		}else if("".equals(Utility.getName(po.getBgiother()))){
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = ? ");
			}
			
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select wt.warehouseId,wt.warehouseName from ( ");
			sb.append(" select B_WC_StockID1 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" )wt group by wt.warehouseId,wt.warehouseName");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" and B_GI_GoodsCategoryID in('1','2','5','6','7','8','9') ");
		}
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) and cast(B_GI_SphUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(isnull(B_GI_BelowPlusLuminosity,0) as float ) = cast( ? as float ) ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
				}
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		sb.append(" left join (  ");
		sb.append("					SELECT  StockId            AS StockId, ");
		sb.append("                         goodsId            AS goodsId, ");
		sb.append("						    bgigoodsbarcode as bgigoodsbarcode, ");
		sb.append("                         SUM(goodsQuantity) AS goodsQuantity, ");
		sb.append("						CASE ");
		sb.append("						 WHEN guaranteeperiod = '' THEN '无效期' ");
		sb.append("						 WHEN guaranteeperiod is null  THEN '无效期' ");
		sb.append("					     ELSE guaranteeperiod ");
		sb.append("						END as guaranteeperiod, ");
		sb.append("						CASE ");
		sb.append("						 WHEN batch = '' THEN '无批号' ");
		sb.append("						 WHEN batch is null  THEN '无批号' ");
		sb.append("					     ELSE batch ");
		sb.append("						END as batch ");
		sb.append("                 FROM   ( ");
		sb.append("                          SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append("                                 C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("								    C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append("                                 C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch ");
		sb.append("                          FROM   dbo.C_SH_StorageLog_YXAndHLY ");
		sb.append("   union all ");
		sb.append("                          SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append("                                 C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("								    C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append("                                 C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch ");
		sb.append("                          FROM   dbo.C_SH_StorageLog ");
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" where substring(C_SH_Sl_GoodsId,1,1) = ? and ((@count <> '0' and convert(varchar(10),C_SH_SL_WarehousingDate,120) > (select top 1 convert(varchar(10),C_SH_SL_WarehousingDate,120) from dbo.C_SH_StorageLog_YXAndHLY)) or @count = '0') ");
			params.add(po.getBgigoodscategoryid());
		}
		sb.append("                ) TEMP  GROUP  BY StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch) temp1 ");
		sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
		sb.append(" 	where 1=1 ");
		if("4".equals(Utility.getName(po.getBgigoodscategoryid())) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"D".equals(po.getBgiiscustomize()) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
					sb.append(" and temp1.bgigoodsbarcode = ? ");
					params.add(po.getBgigoodsbarcode());
				}
			}
		}
		
		if(!"D".equals(po.getBgiiscustomize())){
			sb.append(" and isnull(temp1.bgigoodsbarcode,'') <> '' ");
		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgisupplierid()))){
			if("0".equals(Utility.getName(po.getQueryType()))&&!"D".equals(po.getBgiiscustomize())){
				sb.append("and isnull(temp1.goodsQuantity,0) > 0 ");
			} else if("1".equals(Utility.getName(po.getBgigoodsquantity()))&&!"D".equals(po.getBgiiscustomize())){
				sb.append("and isnull(temp1.goodsQuantity,0) > 0 ");
			}
		}
		sb.append(" )temp where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" order by bgiwarehouseid desc ");
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 遍历查询销售镜架信息
	 */
	public List<GoodsInfoPo> getSellMirrorFrameList(GoodsInfoPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;                                                                                                                                                                                                                                             
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append("       bgiretailprice     AS bgiretailprice, ");
		sb.append("       bgigoodsbarcode    AS bgigoodsbarcode, ");
		sb.append("       bgigoodsid         AS bgigoodsid, ");
		sb.append("       bgigoodsname       AS bgigoodsname, ");
		sb.append("       bgibrandname       AS bgibrandname, ");
		sb.append("       bgicostprice       AS bgicostprice, ");
		sb.append("       bginottaxrate      AS bginottaxrate, ");
		sb.append("       bgispec            AS bgispec, ");
		sb.append("       bgicolor           AS bgicolor, ");
		sb.append("       sum(GoodsQuantity) AS bgigoodsquantity ");
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		sb.append("               b_gi_retailprice     AS bgiretailprice, ");
		sb.append("               B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append("               B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("               B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("               B_BD_brandName       AS bgibrandname, ");
		sb.append("               B_GI_CostPrice       AS bgicostprice, ");
		sb.append("               B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("               B_GI_Spec            AS bgispec, ");
		sb.append("               B_GI_Color           AS bgicolor ");
		sb.append("        FROM   B_GoodsInfo ");
		sb.append("               INNER JOIN B_Supplier ");
		sb.append("                 ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
		sb.append("               INNER JOIN B_Brand ");
		sb.append("                 ON B_GI_BrandID = B_BD_ID ");
		sb.append("                    AND B_GI_SupplierID = B_BD_SupplierID ");
		sb.append("        WHERE  1=1 ");
		sb.append("               AND B_GI_Flag = '1' ");
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}else{
			if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
				sb.append(" and B_GI_GoodsCategoryID = ? ");
				sb.append(" and B_GI_GoodsBarCode like ? + '%' ");
				params.add(po.getBgigoodsbarcode().substring(0, 1));
				params.add(po.getBgigoodsbarcode());
			}
		}
		
		sb.append("				  ) TEMP ");
		sb.append("       LEFT JOIN (SELECT C_SH_SB_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("                         C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                         C_SH_SB_StockId       AS warehouseid ");
		sb.append("                  FROM   C_SH_StorageBeginning ");
		sb.append("                  WHERE  1 = 1 ");
		sb.append("                         AND C_SH_SB_StockId = ? ");
		sb.append("                  UNION ALL ");
		sb.append("                  SELECT C_SH_SC_GoodsBarCode  AS GoodsBarCode, ");
		sb.append("                         C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                         C_SH_SC_StockId       AS warehouseid ");
		sb.append("                  FROM   C_SH_StorageChange ");
		sb.append("                  WHERE  1 = 1 ");
		sb.append("                         AND C_SH_SC_StockId = ?) temp1 ");
		sb.append("         ON bgigoodsbarcode = temp1.GoodsBarCode where 1=1 ");
		
		params.add(po.getOutstockidone());
		params.add(po.getOutstockidone());
		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		
		sb.append("group by bgigoodscategoryid , ");
		sb.append("       bgiretailprice     , ");
		sb.append("       bgigoodsbarcode    , ");
		sb.append("       bgigoodsid         , ");
		sb.append("       bgigoodsname       , ");
		sb.append("       bgibrandname       , ");
		sb.append("       bgicostprice       , ");
		sb.append("       bginottaxrate      , ");
		sb.append("       bgispec            , ");
		sb.append("       bgicolor            ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 遍历查询销售镜架信息
	 */
	public List<GoodsInfoPo> getSellMirrorFrameList1(GoodsInfoPo po,
			int start, int size) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;                                                                                                                                                                                                                                             
		sb.append("select * from ");
		sb.append("(select ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum,B_GI_GoodsCategoryID as bgigoodscategoryid,b_gi_retailprice as bgiretailprice,B_GI_GoodsBarCode+'00000000' as bgigoodsbarcode, B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname, B_BD_brandName as bgibrandname,B_GI_CostPrice as bgicostprice , B_GI_NotTaxRate as bginottaxrate,B_GI_Spec as bgispec,B_GI_Color as bgicolor  from B_GoodsInfo ");
//		sb.append("(select * from ");
//		sb.append("(select ROW_NUMBER() Over(order by GoodsId) as rowNum,GoodsId as bgigoodsid, ");
//		sb.append("sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid  from ");
//		sb.append("(select GoodsId,GoodsQuantity,warehouseid from ");
//		sb.append("(select C_SH_SB_GoodsId as GoodsId, ");
//		
//		sb.append("C_SH_SB_GoodsQuantity as GoodsQuantity, ");
//		sb.append("C_SH_SB_StockId as warehouseid ");
//		sb.append("from C_SH_StorageBeginning where 1=1 ");
//		sb.append("and C_SH_SB_StockId = ? ");
//		sb.append("union all ");
//		sb.append("select C_SH_SC_GoodsId as GoodsId, ");
//		sb.append("C_SH_SC_GoodsQuantity as GoodsQuantity, ");
//		sb.append("C_SH_SC_StockId as warehouseid ");
//		sb.append("from C_SH_StorageChange where 1=1 ");
//		sb.append("and C_SH_SC_StockId = ? ");
//		sb.append(")a )b group by GoodsId,warehouseid)c ");
//		sb.append("inner join B_GoodsInfo on B_GI_GoodsID=c.bgigoodsid ");
		sb.append("inner join B_Supplier on B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID  ");

		sb.append("where 1=1 ");
//		sb.append("where B_GI_GoodsCategoryID= '1'  ");//and c.GoodsQuantity > 0

		
//
//		params.add(po.getBgiwarehouseid());
//		params.add(po.getBgiwarehouseid());
		
		if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			sb.append(" and B_GI_GoodsBarCode = ? ");
			params.add(po.getBgigoodsbarcode());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		
		sb.append(" ) temp ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}

	public List<GoodsInfoPo> getScanGoodsList(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		if(po.getSystemparameterlevel().equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevel(bgigoodsid,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscount(bgigoodsid,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		sb.append(" bgiretailprice     AS bgiretailprice, ");
		sb.append(" bgigoodsbarcode+'00000000'    AS bgigoodsbarcode, ");
		sb.append(" bgigoodsid         AS bgigoodsid, ");
		sb.append(" bgigoodsname       AS bgigoodsname, ");
		sb.append(" bgibrandname       AS bgibrandname, ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue, ");
		sb.append(" bgidefaultdiscountvaluename as bgidefaultdiscountvaluename, ");
		sb.append(" bgicostprice       AS bgicostprice, ");
		sb.append(" bginottaxrate      AS bginottaxrate, ");
		sb.append(" bgispec            AS bgispec, ");
		sb.append(" bgicolor           AS bgicolor, ");
		sb.append(" bgiiscustomize     AS bgiiscustomize, ");
		sb.append(" bgiviewgoodsname   AS bgiviewgoodsname, ");
		
		//新增显示内容 begin
		sb.append(" bgiframematerialtype           AS bgiframematerialtype, ");
		sb.append(" bgiframesize     AS bgiframesize , ");
		sb.append(" bgiaccessoriestype     AS bgiaccessoriestype , ");
		sb.append(" bgisph     AS bgisph , ");
		sb.append(" bgicyl     AS bgicyl , ");
		sb.append(" bgibelowplusluminosity     AS bgibelowplusluminosity , ");
		sb.append(" bgirefractive     AS bgirefractive , ");
		sb.append(" bgiismutiluminosity     AS bgiismutiluminosity , ");
		sb.append(" bgieyeglassmaterialtype     AS bgieyeglassmaterialtype , ");
		sb.append(" bgigradualclass     AS bgigradualclass , ");
		sb.append(" bgisphul     AS bgisphul , ");
		sb.append(" bgisphup     AS bgisphup , ");
		sb.append(" bgicylul     AS bgicylul , ");
		sb.append(" bgicylup     AS bgicylup , ");
		sb.append(" bgiaxis     AS bgiaxis , ");
		sb.append(" bgibelowplusluminosityul     AS bgibelowplusluminosityul , ");
		sb.append(" bgibelowplusluminosityup     AS bgibelowplusluminosityup , ");
		sb.append(" bgifunctionclass     AS bgifunctionclass , ");
		sb.append(" bgicurvature1     AS bgicurvature1 , ");
		sb.append(" bgidia     AS bgidia , ");
		sb.append(" bgiusetype     AS bgiusetype , ");
		sb.append(" bgistealthclass     AS bgistealthclass , ");
		sb.append(" bgiaxisul     AS bgiaxisul , ");
		sb.append(" bgiaxisup     AS bgiaxisup , ");
		sb.append(" bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append(" bgicurvature1up     AS bgicurvature1up , ");
		sb.append(" bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append(" bgicurvature2up     AS bgicurvature2up , ");
		sb.append(" bgicapacity     AS bgicapacity , ");
		sb.append(" bgicapacityentry     AS bgicapacityentry , ");
		sb.append(" bgiordercycle     AS bgiordercycle , ");
		sb.append(" bgisuppliercolor     AS bgisuppliercolor , ");
		sb.append(" bgiwarehouseid       AS bgiwarehouseid , ");
		sb.append(" bgiwarehousename     as bgiwarehousename , ");
		sb.append(" bgisungglassesfun    as bgisungglassesfun , ");
		sb.append(" bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename , ");
		sb.append(" isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity,  ");
		sb.append("dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode+'00000000',bgiwarehouseid) AS bgiintransitgoodsnum, ");
		sb.append(" case ");
		sb.append(" 	when isnull(temp1.goodsQuantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid),0) > 0 then '' ");
		sb.append(" 	when isnull(temp1.goodsQuantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid),0) <= 0 then '(无现货)' ");
		sb.append(" end as bgiishavestock ");
		//新增显示内容 end
		
		
		
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		sb.append(" B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append(" B_GI_GoodsID         AS bgigoodsid, ");
		sb.append(" B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append(" B_BD_brandName       AS bgibrandname, ");
		sb.append(" B_GI_CostPrice       AS bgicostprice, ");
		sb.append(" B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append(" B_GI_ViewGoodsName   AS bgiviewgoodsname, ");
		sb.append(" B_GI_Spec            AS bgispec, ");
		
		//新增显示内容 begin
		sb.append(" B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append(" B_GI_FrameSize     AS bgiframesize , ");
		sb.append(" B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append(" B_GI_Sph     AS bgisph , ");
		sb.append(" B_GI_Cyl     AS bgicyl , ");
		sb.append(" B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append(" B_GI_Refractive     AS bgirefractive , ");
		sb.append(" B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append(" B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append(" B_GI_GradualClass     AS bgigradualclass , ");
		sb.append(" B_GI_SphUL     AS bgisphul , ");
		sb.append(" B_GI_SphUP     AS bgisphup , ");
		sb.append(" B_GI_CylUL     AS bgicylul , ");
		sb.append(" B_GI_CylUP     AS bgicylup , ");
		sb.append(" B_GI_Axis     AS bgiaxis , ");
		sb.append(" B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul , ");
		sb.append(" B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup , ");
		sb.append(" B_GI_FunctionClass     AS bgifunctionclass , ");
		sb.append(" B_GI_Curvature1     AS bgicurvature1 , ");
		sb.append(" B_GI_Dia     AS bgidia , ");
		sb.append(" B_GI_UseType     AS bgiusetype , ");
		sb.append(" B_GI_StealthClass     AS bgistealthclass , ");
		sb.append(" B_GI_AxisUL     AS bgiaxisul , ");
		sb.append(" B_GI_AxisUP     AS bgiaxisup , ");
		sb.append(" B_GI_Curvature1UL     AS bgicurvature1ul , ");
		sb.append(" B_GI_Curvature1UP     AS bgicurvature1up , ");
		sb.append(" B_GI_Curvature2UL     AS bgicurvature2ul , ");
		sb.append(" B_GI_Curvature2UP     AS bgicurvature2up , ");
		sb.append(" B_GI_Capacity         AS bgicapacity , ");
		sb.append(" B_GI_CapacityEntry    AS bgicapacityentry , ");
		sb.append(" B_GI_orderCycle       AS bgiordercycle , ");
		sb.append(" B_GI_SupplierColor    AS bgisuppliercolor , ");
		sb.append(" B_FM_Name             AS bgieyeglassmaterialtypename , ");
		sb.append(" B_GI_SunGglassesFun   AS bgisungglassesfun , ");
		sb.append(" B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue, ");
		sb.append(" B_GL_Name		   AS bgidefaultdiscountvaluename, ");
		
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("        isnull(warehouseId,(select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?))         AS bgiwarehouseid , ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append("        isnull(warehouseName,(select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)))    AS bgiwarehousename, ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else{
			sb.append("  case ");
			sb.append("	when B_GI_GoodsCategoryID = '1' then (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '2' then (select B_WC_StockID2 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' then (select B_WC_StockID3 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' then (select B_WC_StockID4 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '5' then (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '6' then (select B_WC_StockID8 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '7' then (select B_WC_StockID9 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '8' then (select B_WC_StockID11 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			sb.append("	when B_GI_GoodsCategoryID = '9' then (select B_WC_StockID12 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append("	else '' ");
			sb.append("	end                                         AS bgiwarehouseid, ");
			sb.append("   case ");
			sb.append("		when B_GI_GoodsCategoryID = '1' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '2' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID2 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID3 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID4 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '5' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '6' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID8 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '7' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID9 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '8' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID11 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			sb.append("		when B_GI_GoodsCategoryID = '9' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID12 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append("	else '' ");
			sb.append("	end                                         AS bgiwarehousename, ");
		}
		//新增显示内容 end.
		
		sb.append(" B_GI_Color           AS bgicolor, ");
		sb.append(" isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))&&"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
			sb.append(" where B_WC_deptID = ? ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if("".equals(Utility.getName(po.getBgiother()))){
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = ? ");
			}
			
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select wt.warehouseId,wt.warehouseName from ( ");
			sb.append(" select B_WC_StockID1 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" )wt group by wt.warehouseId,wt.warehouseName");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		if(po.getBgigoodsbarcode().length() == 5){
			sb.append(" and B_GI_GoodsBarCode like ? + '%' ");
			params.add(Utility.getName(po.getBgigoodsbarcode()).substring(0,5));
		}else{
			if(po.getBgigoodsbarcode().length() > 18){
				sb.append(" and B_GI_GoodsBarCode like ? + '%' ");
				params.add(Utility.getName(po.getBgigoodsbarcode()).substring(0,18));
			}else{
				sb.append(" and B_GI_GoodsBarCode like ? + '%' ");
				params.add(Utility.getName(po.getBgigoodsbarcode()));
			}
			
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid())) || "4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");			
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
				
			}else if("0".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
			}else{
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgisph()))){
				sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
				params.add(Utility.getName(po.getBgisph()));
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		
		sb.append(" left join (  ");
		sb.append("         select StockId AS StockId,goodsId as goodsId,sum(goodsQuantity) as goodsQuantity from ( ");
		sb.append(" 		select C_SH_SB_StockId AS StockId,C_SH_SB_GoodsId as goodsId,C_SH_SB_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageBeginning ");
		sb.append(" 		union all ");
		sb.append(" 		select C_SH_Sc_StockId AS StockId,C_SH_SC_GoodsId as goodsId,C_SH_SC_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageChange ");
		sb.append(" 		) temp  ");
		sb.append(" 	group by StockId,goodsId) temp1 ");
		sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
		sb.append(" 	where 1=1 ");
		
//		if("1".equals(po.getBgigoodsquantity())){
//			sb.append(" 	and isnull(temp1.goodsQuantity,0) > 0");
//		}
		
		if("0".equals(Utility.getName(po.getQueryType()))){				
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" 	and isnull(temp1.goodsQuantity,0) >= 0");
			}else{
				sb.append(" 	and isnull(temp1.goodsQuantity,0) > 0");
			}			
		} else if("1".equals(Utility.getName(po.getBgigoodsquantity()))){
			sb.append(" 	and isnull(temp1.goodsQuantity,0) > 0");
		}
		
		sb.append(" 	order by bgiwarehouseid desc ");
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	public List<GoodsInfoPo> getScanGoodsList1(GoodsInfoPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("declare @count varchar(10) ");
		sb.append("select @count = count(C_SH_SL_UUID) from dbo.C_SH_StorageLog_YXAndHLY  ");
		
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		if(po.getSystemparameterlevel().equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevel(bgigoodsid,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscount(bgigoodsid,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		sb.append("       bgiretailprice     AS bgiretailprice, ");
		sb.append("       temp1.bgigoodsbarcode    AS bgigoodsbarcode, ");
		sb.append("       temp1.guaranteeperiod as guaranteeperiod, ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue, ");
		sb.append(" bgidefaultdiscountvaluename as bgidefaultdiscountvaluename, ");
		sb.append("       temp1.batch        as batch, ");
		sb.append("       bgigoodsid         AS bgigoodsid, ");
		sb.append("       bgigoodsname       AS bgigoodsname, ");
		sb.append("       bgibrandname       AS bgibrandname, ");
		sb.append("       bgicostprice       AS bgicostprice, ");
		sb.append(" 	  bgiviewgoodsname   AS bgiviewgoodsname, ");
		sb.append("       bginottaxrate      AS bginottaxrate, ");
		sb.append("       bgispec            AS bgispec, ");
		sb.append("       bgicolor           AS bgicolor, ");
		sb.append("       bgiiscustomize     AS bgiiscustomize, ");
		sb.append("       bgiframematerialtype           AS bgiframematerialtype, ");
		sb.append("       bgiframesize     AS bgiframesize , ");
		sb.append("       bgiaccessoriestype     AS bgiaccessoriestype , ");
		sb.append("       bgisph     AS bgisph , ");
		sb.append("       bgicyl     AS bgicyl , ");
		sb.append("       bgibelowplusluminosity     AS bgibelowplusluminosity , ");
		sb.append("       bgirefractive     AS bgirefractive , ");
		sb.append("       bgiismutiluminosity     AS bgiismutiluminosity , ");
		sb.append("       bgieyeglassmaterialtype     AS bgieyeglassmaterialtype , ");
		sb.append("       bgigradualclass     AS bgigradualclass , ");
		sb.append("       bgisphul     AS bgisphul , ");
		sb.append("       bgisphup     AS bgisphup , ");
		sb.append("       bgicylul     AS bgicylul , ");
		sb.append("       bgicylup     AS bgicylup , ");
		sb.append("       bgiaxis     AS bgiaxis , ");
		sb.append("       bgibelowplusluminosityul     AS bgibelowplusluminosityul , ");
		sb.append("       bgibelowplusluminosityup     AS bgibelowplusluminosityup , ");
		sb.append("       bgifunctionclass     AS bgifunctionclass , ");
		sb.append("       bgicurvature1     AS bgicurvature1 , ");
		sb.append("       bgidia     AS bgidia , ");
		sb.append("       bgiusetype     AS bgiusetype , ");
		sb.append("       bgistealthclass     AS bgistealthclass , ");
		sb.append("       bgiaxisul     AS bgiaxisul , ");
		sb.append("       bgiaxisup     AS bgiaxisup , ");
		sb.append("       bgicurvature1ul      AS bgicurvature1ul , ");
		sb.append("       bgicurvature1up      AS bgicurvature1up , ");
		sb.append("       bgicurvature2ul      AS bgicurvature2ul , ");
		sb.append("       bgicurvature2up      AS bgicurvature2up , ");
		sb.append("       bgicapacity          AS bgicapacity , ");
		sb.append("       bgicapacityentry     AS bgicapacityentry , ");
		sb.append("       bgiordercycle        AS bgiordercycle , ");
		sb.append("       bgisuppliercolor     AS bgisuppliercolor , ");
		sb.append("       bgiwarehouseid       AS bgiwarehouseid , ");
		sb.append("       bgiwarehousename     AS bgiwarehousename , ");
		sb.append("       bgisungglassesfun    AS bgisungglassesfun , ");
		sb.append("       isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity, ");
		sb.append("		  dbo.getInTransitNum(bgigoodsid,temp1.bgigoodsbarcode,bgiwarehouseid) AS bgiintransitgoodsnum ");
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}
		sb.append("  B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("  B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("  B_BD_brandName       AS bgibrandname, ");
		sb.append("  B_GI_CostPrice       AS bgicostprice, ");
		sb.append("  B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("  B_GI_Spec            AS bgispec, ");
		sb.append("  B_gi_viewgoodsname   AS bgiviewgoodsname, ");
		sb.append("  B_GI_SunGglassesFun   AS bgisungglassesfun , ");
		sb.append(" B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue, ");
		sb.append(" B_GL_Name		   AS bgidefaultdiscountvaluename, ");
		sb.append("  B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append("  B_GI_FrameSize     AS bgiframesize , ");
		sb.append("  B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append("  B_GI_Sph     AS bgisph , ");
		sb.append("  B_GI_Cyl     AS bgicyl , ");
		sb.append("  B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append("  B_GI_Refractive     AS bgirefractive , ");
		sb.append("  B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append("  B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append("  B_GI_GradualClass     AS bgigradualclass , ");
		sb.append("  B_GI_SphUL     AS bgisphul , ");
		sb.append("  B_GI_SphUP     AS bgisphup , ");
		sb.append("  B_GI_CylUL     AS bgicylul , ");
		sb.append("  B_GI_CylUP     AS bgicylup , ");
		sb.append("  B_GI_Axis     AS bgiaxis , ");
		sb.append("  B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul , ");
		sb.append("  B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup , ");
		sb.append("  B_GI_FunctionClass     AS bgifunctionclass , ");
		sb.append("  B_GI_Curvature1     AS bgicurvature1 , ");
		sb.append("  B_GI_Dia     AS bgidia , ");
		sb.append("  B_GI_UseType     AS bgiusetype , ");
		sb.append("  B_GI_StealthClass     AS bgistealthclass , ");
		sb.append("  B_GI_AxisUL     AS bgiaxisul , ");
		sb.append("  B_GI_AxisUP     AS bgiaxisup , ");
		sb.append("  B_GI_Curvature1UL     AS bgicurvature1ul , ");
		sb.append("  B_GI_Curvature1UP     AS bgicurvature1up , ");
		sb.append("  B_GI_Curvature2UL     AS bgicurvature2ul , ");
		sb.append("  B_GI_Curvature2UP     AS bgicurvature2up , ");
		sb.append("  B_GI_Capacity         AS bgicapacity , ");
		sb.append("  B_GI_CapacityEntry    AS bgicapacityentry , ");
		sb.append("  B_GI_orderCycle       AS bgiordercycle , ");
		sb.append("  B_GI_SupplierColor    AS bgisuppliercolor , ");
		
		sb.append("  case ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
		sb.append("	when B_GI_GoodsCategoryID = '5' then (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		sb.append("	else '' ");
		sb.append("	end  AS bgiwarehouseid, ");
		sb.append(" case ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
		sb.append("	when B_GI_GoodsCategoryID = '5' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		sb.append("				else '' ");
		sb.append("			    end                                         AS bgiwarehousename, ");
		
		sb.append(" B_GI_Color           AS bgicolor, ");
		sb.append(" isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		sb.append(" where 1 = 1 ");
		sb.append("   and B_GI_GoodsCategoryID = ? ");
		params.add(Utility.getName(po.getBgigoodscategoryid()));
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid())) || "4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");			
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) and cast(B_GI_SphUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
			}else if("0".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
			}else{
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		sb.append(" left join (  ");
		sb.append("	SELECT  StockId            AS StockId, ");
		sb.append(" goodsId            AS goodsId, ");
		sb.append("	bgigoodsbarcode as bgigoodsbarcode, ");
		sb.append(" SUM(goodsQuantity) AS goodsQuantity, ");
		sb.append("	CASE ");
		sb.append("	WHEN guaranteeperiod = '' THEN '无效期' ");
		sb.append("	WHEN guaranteeperiod is null  THEN '无效期' ");
		sb.append("	ELSE guaranteeperiod ");
		sb.append("	END as guaranteeperiod, ");
		sb.append("	CASE ");
		sb.append("	WHEN batch = '' THEN '无批号' ");
		sb.append("	WHEN batch is null  THEN '无批号' ");
		sb.append("	ELSE batch ");
		sb.append("	END as batch ");
		sb.append(" FROM   ( ");
		sb.append(" SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append(" C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("	C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append(" C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch ");
		sb.append("  FROM   dbo.C_SH_StorageLog_YXAndHLY ");
		sb.append("  union all ");
		sb.append(" SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append(" C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("	C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append(" C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch ");
		sb.append("  FROM   dbo.C_SH_StorageLog ");
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" where substring(C_SH_Sl_GoodsId,1,1) = ? and ((@count <> '0' and convert(varchar(10),C_SH_SL_WarehousingDate,120) > (select top 1 convert(varchar(10),C_SH_SL_WarehousingDate,120) from dbo.C_SH_StorageLog_YXAndHLY)) or @count = '0') ");
			params.add(po.getBgigoodscategoryid());
		}	
		sb.append("  ) TEMP ");
		sb.append(" GROUP  BY StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch) temp1 ");
		sb.append(" ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
		sb.append(" where 1=1 ");
		sb.append(" and temp1.bgigoodsbarcode like ? + '%' ");
		params.add(po.getBgigoodsbarcode());
		if("1".equals(po.getBgigoodsquantity())){
			sb.append(" 	and isnull(temp1.goodsQuantity,0) > 0");
		}
		sb.append(" order by bgiwarehouseid desc ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	public int getSellMirrorFrameCountBatchNew(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select count(*) from( ");
		sb.append(" SELECT ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage()))){
			if(!"D".equals(po.getBgiiscustomize())){
				sb.append("       temp1.bgigoodsbarcode    AS bgigoodsbarcode, ");
				sb.append("       temp1.guaranteeperiod as guaranteeperiod, ");
				sb.append("       temp1.batch        as batch, ");
			}else{
				sb.append("       ''    AS bgigoodsbarcode, ");
				sb.append("       ''    as guaranteeperiod, ");
				sb.append("       ''    as batch, ");
			}
		}else{
			sb.append("       bgigoodsbarcode+'00000000'    AS bgigoodsbarcode, ");
			sb.append("       ''    as guaranteeperiod, ");
			sb.append("       ''    as batch, ");
		}	

		sb.append("  bgigoodsid         AS bgigoodsid, ");
		sb.append("  bgiwarehouseid       AS bgiwarehouseid  ");
		sb.append("FROM   (SELECT ");
		sb.append(" B_GI_GoodsID         AS bgigoodsid,B_GI_GoodsBarCode as bgigoodsbarcode, ");
		sb.append(" warehouseId AS bgiwarehouseid ");
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))&&"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			if(!"ZZ".equals(po.getBgisupplierid())){
				sb.append(" union all ");
				sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
				sb.append(" where B_WC_deptID = ? ");
				params.add(Utility.getName(po.getBgiwarehouseid()));
			}
			
		}else if("".equals(Utility.getName(po.getBgiother()))){
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = ? ");
			}
			
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select wt.warehouseId,wt.warehouseName from ( ");
			sb.append(" select B_WC_StockID1 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" )wt group by wt.warehouseId,wt.warehouseName");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}

		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}

				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_SphUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_SphSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_cylUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_CylSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
				
				if(!"".equals(Utility.getName(po.getBgiunionsphcyl()))){
					sb.append(" and ((isnull(B_GI_UnionSphCyl,'') <> '' and cast(B_GI_UnionSphCyl as float) >= ?) or isnull(B_GI_UnionSphCyl,'') = '') ");
					params.add(Utility.getName(po.getBgiunionsphcyl()));				
				}	
				
				if(("3".equals(Utility.getName(po.getBgigoodscategoryid()))) && ("-0.25".equals(Utility.getName(po.getBgicyl())))){
					sb.append("and B_GI_cyl25CanNotDo = '0' ");
				}
				
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(isnull(B_GI_BelowPlusLuminosity,0) as float ) = cast( ? as float ) ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
				}
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){
			
			if(Utility.getName(po.getBgiisleftorinner()).equals("2")){  // 1. inner   2.left 
				sb.append(" left join ( ");
			}else{
				sb.append(" inner join ( ");
			}
			
			sb.append("					SELECT  StockId            AS StockId, ");
			sb.append("                         goodsId            AS goodsId, ");
			sb.append("						    bgigoodsbarcode as bgigoodsbarcode, ");
			sb.append("                         SUM(goodsQuantity) AS goodsQuantity, ");
			sb.append("						CASE ");
			sb.append("						 WHEN guaranteeperiod = '' THEN '无效期' ");
			sb.append("						 WHEN guaranteeperiod is null  THEN '无效期' ");
			sb.append("					     ELSE guaranteeperiod ");
			sb.append("						END as guaranteeperiod, ");
			sb.append("						CASE ");
			sb.append("						 WHEN batch = '' THEN '无批号' ");
			sb.append("						 WHEN batch is null  THEN '无批号' ");
			sb.append("					     ELSE batch ");
			sb.append("						END as batch ");
			sb.append("                 FROM   ( ");
			sb.append("                          SELECT C_SH_Sl_StockId       AS StockId,");
			sb.append("                                 C_SH_Sl_GoodsId       AS goodsId,");
			sb.append("								    C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
			sb.append("                                 C_SH_Sl_GoodsQuantity AS goodsQuantity,");
			sb.append("	isnull(C_SH_BC_GuaranteePeriod,'') AS guaranteeperiod, ");
			sb.append("	isnull(C_SH_BC_Batch,'') as batch FROM  ");
			
			if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_YX ");
			}
			if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HLY ");
			}
			sb.append(" left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
			sb.append(" where 1=1  ");
			if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" and substring(C_SH_SL_GoodsId,1,1) = ? ");
				params.add(Utility.getName(po.getBgigoodscategoryid()));
			}
			sb.append(" and C_SH_SL_StockId in ( ");
	        if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}
			sb.append(" ) ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			
			sb.append("                ) TEMP  GROUP  BY StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch) temp1 ");
			sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
			sb.append(" 	where 1=1 ");
			
			if("4".equals(Utility.getName(po.getBgigoodscategoryid())) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if(!"D".equals(po.getBgiiscustomize()) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
						sb.append(" and temp1.bgigoodsbarcode = ? ");
						params.add(po.getBgigoodsbarcode());
					}
				}
			}
			if(!"D".equals(po.getBgiiscustomize())){
				sb.append(" and isnull(temp1.bgigoodsbarcode,'') <> '' ");
			}
			
			if("0".equals(Utility.getName(po.getQueryType()))){
				if(Utility.getName(po.getBgiiscustomize()).equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(po.getBgicppquerytype()).equals("1")){
					
				}else{
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}			
			}else{
				if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}	
			}
			
		}		

		sb.append(" )temp ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());	
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListBatchNew(GoodsInfoPo po,int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;  
	
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT *, ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevelNew(bgigoodsid,?,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscountNew(bgigoodsid,?,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		params.add(Utility.getName(po.getBgishopcode()));
		
		sb.append("dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid) AS bgiintransitgoodsnum ");
		sb.append("from (SELECT ROW_NUMBER() Over(order by bgigoodsid) as rowNum, bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append("       bgiretailprice     AS bgiretailprice, ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage()))){
			if(!"D".equals(po.getBgiiscustomize())){
				sb.append("       isnull(temp1.bgigoodsbarcode,(goodsinfo.bgigoodsbarcode+'00000000'))    AS bgigoodsbarcode, ");
				sb.append("       isnull(temp1.guaranteeperiod,'') as guaranteeperiod, ");
				sb.append("       isnull(temp1.batch,'')        as batch, ");
			}else{
				sb.append("       bgigoodsbarcode+'00000000'    AS bgigoodsbarcode, ");
				sb.append("       ''    as guaranteeperiod, ");
				sb.append("       ''    as batch, ");
			}
		}else{
			sb.append("       bgigoodsbarcode+'00000000'    AS bgigoodsbarcode, ");
			sb.append("       ''    as guaranteeperiod, ");
			sb.append("       ''    as batch, ");
		}	

		sb.append(" bgigoodsid         	AS bgigoodsid, ");
		sb.append(" bgigoodsname       	AS bgigoodsname, ");
		sb.append(" bgibrandname       	AS bgibrandname, ");
		sb.append(" bgicostprice       	AS bgicostprice, ");
		sb.append(" bginottaxrate      	AS bginottaxrate, ");
		sb.append(" bgispec            	AS bgispec, ");
		sb.append(" bgicolor           	AS bgicolor, ");
		sb.append(" bgiviewgoodsname    AS bgiviewgoodsname, ");
		sb.append(" bgisuppliercolor    AS bgisuppliercolor , ");
		sb.append(" bgiwarehouseid      AS bgiwarehouseid , ");
		sb.append(" bgiwarehousename    as bgiwarehousename , ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue ");
		
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,bgidefaultdiscountvaluename as bgidefaultdiscountvaluename ");
		}

		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiframematerialtype           AS bgiframematerialtype ");
			sb.append(" ,bgiframesize     	AS bgiframesize  ");
			sb.append(" ,bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename  ");
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiaccessoriestype  AS bgiaccessoriestype  ");
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			
		
			sb.append(" ,bgirefractive     	AS bgirefractive  ");
			sb.append(" ,bgiismutiluminosity AS bgiismutiluminosity  ");
			sb.append(" ,bgieyeglassmaterialtype     AS bgieyeglassmaterialtype  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgibelowplusluminosity     AS bgibelowplusluminosity  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisphul     		AS bgisphul  ");
				sb.append(" ,bgisphup     		AS bgisphup  ");
				sb.append(" ,bgicylul     		AS bgicylul  ");
				sb.append(" ,bgicylup     		AS bgicylup  ");
				sb.append(" ,bgibelowplusluminosityul     AS bgibelowplusluminosityul  ");
				sb.append(" ,bgibelowplusluminosityup     AS bgibelowplusluminosityup  ");
				sb.append(" ,bgiaxis     		AS bgiaxis  ");
				sb.append(" ,bgigradualclass     AS bgigradualclass  ");
				sb.append(" ,bgifunctionclass    AS bgifunctionclass  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
		
			sb.append(" ,bgiusetype     		AS bgiusetype  ");
			sb.append(" ,bgistealthclass     AS bgistealthclass  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgicurvature1     	AS bgicurvature1  ");
				sb.append(" ,bgidia     			AS bgidia  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgicurvature1ul     AS bgicurvature1ul  ");
				sb.append(" ,bgicurvature1up     AS bgicurvature1up  ");
				sb.append(" ,bgicurvature2ul     AS bgicurvature2ul  ");
				sb.append(" ,bgicurvature2up     AS bgicurvature2up  ");
				sb.append(" ,bgiaxisul     		AS bgiaxisul  ");
				sb.append(" ,bgiaxisup     		AS bgiaxisup  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");				
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgicapacity         AS bgicapacity  ");
			sb.append(" ,bgicapacityentry    AS bgicapacityentry  ");
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisungglassesfun   as bgisungglassesfun  ");
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisph     			AS bgisph  ");
		}	
		
		if(!"D".equals(po.getBgiiscustomize()) && !"1".equals(Utility.getName(po.getBgiisselectstorage()))){
			sb.append("       ,isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity  ");
		}else{
			sb.append("       ,1     AS bgigoodsquantity  ");
		}
		
		//新增显示内容 end
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailprice     AS bgiretailprice ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricea     AS bgiretailprice ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricec     AS bgiretailprice ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriced     AS bgiretailprice ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricee     AS bgiretailprice ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricef     AS bgiretailprice ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricei     AS bgiretailprice ");
		}
		sb.append("            ,   B_GI_GoodsBarCode    AS bgigoodsbarcode ");
		sb.append("            ,   B_GI_ViewGoodsName         AS bgiviewgoodsname ");
		sb.append("             ,  B_GI_GoodsID         AS bgigoodsid ");
		sb.append("            ,   B_GI_ViewGoodsName       AS bgigoodsname ");
		sb.append("            ,   B_BD_brandName       AS bgibrandname ");
		sb.append("            ,   B_GI_CostPrice       AS bgicostprice ");
		sb.append("            ,   B_GI_NotTaxRate      AS bginottaxrate ");
		sb.append("            ,   B_GI_Spec            AS bgispec ");
		sb.append(" ,B_GI_Color           AS bgicolor ");
		sb.append(" ,B_GI_SupplierColor  AS bgisuppliercolor  ");      // 厂家颜色
		
		//新增显示内容 begin
		sb.append(" ,warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename ");
		sb.append(" ,B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,B_GL_Name		   AS bgidefaultdiscountvaluename ");
		}		
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_FrameMaterialType    AS bgiframematerialtype , ");   // 镜架材质ID
			sb.append(" ,B_GI_FrameSize     AS bgiframesize  ");                  // 镜架尺寸
			sb.append(" ,B_FM_Name           AS bgieyeglassmaterialtypename , ");   // 镜架材质名称
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_AccessoriesType     AS bgiaccessoriestype , ");      // 配件类型
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			

			sb.append(" , B_GI_Refractive     AS bgirefractive  ");   // 折射率
			sb.append(" ,B_GI_isMutiLuminosity     AS bgiismutiluminosity  ");           // 光度分类			
			sb.append(" ,B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype  ");     // 镜片材质
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity  ");    // 下加光度
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_SphUL     AS bgisphul  ");          // 球镜上限
				sb.append(" ,B_GI_SphUP     AS bgisphup  ");          // 球镜下限
				sb.append(" ,B_GI_CylUL     AS bgicylul  ");          // 柱镜上限
				sb.append(" ,B_GI_CylUP     AS bgicylup  ");          // 柱镜下限
				sb.append(" ,B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul  ");    // 下加光度上限
				sb.append(" ,B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup  ");    // 下加光度下限
				sb.append(" ,B_GI_Axis     AS bgiaxis  ");            // 轴向
				sb.append(" ,B_GI_GradualClass     AS bgigradualclass  ");      // 渐进片分类
				sb.append(" ,B_GI_FunctionClass     AS bgifunctionclass  ");     // 镜片功能
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			sb.append(" ,B_GI_UseType     AS bgiusetype  ");     // 使用类型
			sb.append(" ,B_GI_StealthClass     AS bgistealthclass  ");     // 抛弃型分类			
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_Curvature1     AS bgicurvature1  ");   // 曲率1
				sb.append(" ,B_GI_Dia     AS bgidia  ");      // 直径
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Curvature1UL   AS bgicurvature1ul  ");       // 曲率1上限
				sb.append(" ,B_GI_Curvature1UP   AS bgicurvature1up  ");       // 曲率1下限
				sb.append(" ,B_GI_Curvature2UL   AS bgicurvature2ul  ");       // 曲率2上限
				sb.append(" ,B_GI_Curvature2UP   AS bgicurvature2up  ");       // 曲率2下限		
				sb.append(" ,B_GI_AxisUL     AS bgiaxisul  ");                 // 轴向上限
				sb.append(" ,B_GI_AxisUP     AS bgiaxisup  ");                 // 轴向下限	
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Capacity       AS bgicapacity  ");           // 主容量
			sb.append(" ,B_GI_CapacityEntry  AS bgicapacityentry  ");      // 次容量
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_SunGglassesFun          AS bgisungglassesfun ");    // 太阳镜功能
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
		}		
		
		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		if(Utility.getName(po.getBgigoodscategoryid()).equals("1")){
			sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		}
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		}	
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))&&"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			if(!"ZZ".equals(po.getBgisupplierid())){
				sb.append(" union all ");
				sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
				sb.append(" where B_WC_deptID = ? ");
				params.add(Utility.getName(po.getBgiwarehouseid()));
			}
			
		}else if("".equals(Utility.getName(po.getBgiother()))){
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = ? ");
			}
			
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select wt.warehouseId,wt.warehouseName from ( ");
			sb.append(" select B_WC_StockID1 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
			sb.append(" where B_WC_deptID = ? ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = ? ");
			sb.append(" )wt group by wt.warehouseId,wt.warehouseName");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}

		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}

				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_SphUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_SphSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_cylUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_CylSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
				
				if(!"".equals(Utility.getName(po.getBgiunionsphcyl()))){
					sb.append(" and ((isnull(B_GI_UnionSphCyl,'') <> '' and cast(B_GI_UnionSphCyl as float) >= ?) or isnull(B_GI_UnionSphCyl,'') = '') ");
					params.add(Utility.getName(po.getBgiunionsphcyl()));				
				}	
				
				if(("3".equals(Utility.getName(po.getBgigoodscategoryid()))) && ("-0.25".equals(Utility.getName(po.getBgicyl())))){
					sb.append("and B_GI_cyl25CanNotDo = '0' ");
				}
				
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(isnull(B_GI_BelowPlusLuminosity,0) as float ) = cast( ? as float ) ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
				}
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");

		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){
			if(Utility.getName(po.getBgiisleftorinner()).equals("2")){  // 1. inner   2.left 
				sb.append(" left join ( ");
			}else{
				sb.append(" inner join ( ");
			}
			sb.append("					SELECT  StockId            AS StockId, ");
			sb.append("                         goodsId            AS goodsId, ");
			sb.append("						    bgigoodsbarcode as bgigoodsbarcode, ");
			sb.append("                         SUM(goodsQuantity) AS goodsQuantity, ");
			sb.append("						CASE ");
			sb.append("						 WHEN guaranteeperiod = '' THEN '无效期' ");
			sb.append("						 WHEN guaranteeperiod is null  THEN '无效期' ");
			sb.append("					     ELSE guaranteeperiod ");
			sb.append("						END as guaranteeperiod, ");
			sb.append("						CASE ");
			sb.append("						 WHEN batch = '' THEN '无批号' ");
			sb.append("						 WHEN batch is null  THEN '无批号' ");
			sb.append("					     ELSE batch ");
			sb.append("						END as batch ");
			sb.append("                 FROM   ( ");
			sb.append("                          SELECT C_SH_Sl_StockId       AS StockId,");
			sb.append("                                 C_SH_Sl_GoodsId       AS goodsId,");
			sb.append("								    C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
			sb.append("                                 C_SH_Sl_GoodsQuantity AS goodsQuantity,");
			sb.append("	isnull(C_SH_BC_GuaranteePeriod,'') AS guaranteeperiod, ");
			sb.append("	isnull(C_SH_BC_Batch,'') as batch ");
			sb.append("                          FROM ");
			
			if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_YX ");
			}
			if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HLY ");
			}
			sb.append(" left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
			sb.append(" where 1=1  ");
			if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" and substring(C_SH_SL_GoodsId,1,1) = ? ");
				params.add(Utility.getName(po.getBgigoodscategoryid()));
			}
			sb.append(" and C_SH_SL_StockId in ( ");
	        if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}
			sb.append(" ) ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
	
			sb.append("                ) TEMP  GROUP  BY StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch) temp1 ");
			sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");

			sb.append(" 	where 1=1 ");
			if("4".equals(Utility.getName(po.getBgigoodscategoryid())) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if(!"D".equals(po.getBgiiscustomize()) || "5".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
						sb.append(" and temp1.bgigoodsbarcode = ? ");
						params.add(po.getBgigoodsbarcode());
					}
				}
			}
			
			if(!"D".equals(po.getBgiiscustomize())){
				sb.append(" and isnull(temp1.bgigoodsbarcode,'') <> '' ");
			}
			
//			if(!"ZZ".equals(Utility.getName(po.getBgisupplierid()))){
//				if("0".equals(Utility.getName(po.getQueryType()))&&!"D".equals(po.getBgiiscustomize())){
//					sb.append("and isnull(temp1.goodsQuantity,0) > 0 ");
//				} else if("1".equals(Utility.getName(po.getBgigoodsquantity()))&&!"D".equals(po.getBgiiscustomize())){
//					sb.append("and isnull(temp1.goodsQuantity,0) > 0 ");
//				}
//			}
			
			if("0".equals(Utility.getName(po.getQueryType()))){
				if(Utility.getName(po.getBgiiscustomize()).equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(po.getBgicppquerytype()).equals("1")){
					
				}else{
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}			
			}else{
				if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}	
			}
			
		}

		sb.append(" )temp where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" order by bgiwarehouseid desc ");
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	
	}
	
	public int getSellMirrorFrameCountAllNew(GoodsInfoPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(*) from ( ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){
			sb.append("SELECT bgigoodsid as bgigoodsid,goodsQuantity as goodsQuantity ");
		}else{
			sb.append("SELECT bgigoodsid as bgigoodsid,0 as goodsQuantity ");
		}
		
		//新增显示内容 end
		
		sb.append("FROM   (SELECT ");
		sb.append("  B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("               warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename, ");
		sb.append("               B_GI_Color           AS bgicolor, ");
		sb.append("               isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo ");
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			if(!"ZZ".equals(po.getBgisupplierid())){
				sb.append(" union all ");
				sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
		}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
		}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else{
				sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
		}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else{
				sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
		}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
		}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
		}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
		}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgiunitid()))){
			sb.append(" and B_GI_SupplierID <> 'zz' ");
		}else{
			sb.append(" and B_GI_SupplierID = 'zz' ");
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = '"+ Utility.getName(po.getBgigoodscategoryid()) +"' ");
		}
		
		if(!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_SphUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_SphSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_cylUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_CylSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
				
				if(!"".equals(Utility.getName(po.getBgiunionsphcyl()))){
					sb.append(" and ((isnull(B_GI_UnionSphCyl,'') <> '' and cast(B_GI_UnionSphCyl as float) >= ?) or isnull(B_GI_UnionSphCyl,'') = '') ");
					params.add(Utility.getName(po.getBgiunionsphcyl()));				
				}	
				
				if(("3".equals(Utility.getName(po.getBgigoodscategoryid()))) && ("-0.25".equals(Utility.getName(po.getBgicyl())))){
					sb.append("and B_GI_cyl25CanNotDo = '0' ");
				}
				
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgisph()))){
				sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
				params.add(Utility.getName(po.getBgisph()));
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){
			
			if(Utility.getName(po.getBgiisleftorinner()).equals("2")){  // 1. inner   2.left 
				sb.append(" left join ( ");
			}else{
				sb.append(" inner join ( ");
			}
			
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select (replace(C_SH_SL_GoodsId,'.','')+'00000000') as sGoodsBarCode,C_SH_SL_GoodsId as goodsId,C_SH_SL_StockId as stockId,sum(C_SH_SL_GoodsQuantity) as goodsQuantity from ");
			}else{
				sb.append(" select C_SH_SL_GoodsBarCode as sGoodsBarCode,C_SH_SL_GoodsId as goodsId,C_SH_SL_StockId as stockId,sum(C_SH_SL_GoodsQuantity) as goodsQuantity from ");
			}
			
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JJ ");
			}
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_PJ ");
			}
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JP ");
			}
			if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_YX ");
			}
			if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HLY ");
			}
			if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_TYJ ");
			}
			if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HC ");
			}
			if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_LHJ ");
			}
			if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_SG ");
			}		
			
			sb.append(" where 1=1 ");
			if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" and substring(C_SH_SL_GoodsId,1,1) = '"+ Utility.getName(po.getBgigoodscategoryid()) +"' ");
//				params.add(Utility.getName(po.getBgigoodscategoryid()));
			}
			sb.append(" and C_SH_SL_StockId in ( ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID1  as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				if(!"ZZ".equals(po.getBgisupplierid())){
					sb.append(" union all ");
					sb.append(" select B_WC_StockID13  as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
//					params.add(Utility.getName(po.getBgiwarehouseid()));
				}
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
//			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append(" ) ");
			
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" 	group by C_SH_SL_GoodsId,C_SH_SL_StockId ");
			}else{
				sb.append(" 	group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
			}
					
			sb.append(" ) temp1 ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
			
			if("0".equals(Utility.getName(po.getQueryType()))){
				if(Utility.getName(po.getBgiiscustomize()).equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(po.getBgicppquerytype()).equals("1")){
					
				}else{
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}			
			}else{
				if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}	
			}
		}
		
		sb.append(" )temp2 ");
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListAllNew(GoodsInfoPo po,int start, int size){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;  

		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT *,");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevelNew(bgigoodsid,?,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscountNew(bgigoodsid,?,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		params.add(Utility.getName(po.getBgishopcode()));
		
		sb.append(" dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid) AS bgiintransitgoodsnum,");
		sb.append(" case ");
		sb.append(" 	when isnull(bgigoodsquantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid),0) > 0 then '' ");
		sb.append(" 	when isnull(bgigoodsquantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,bgigoodsbarcode,bgiwarehouseid),0) <= 0 then '(无现货)' ");
		sb.append(" end as bgiishavestock ");
		sb.append(" from (SELECT ROW_NUMBER() Over(order by bgigoodsid) as rowNum, bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append(" bgiretailprice     	AS bgiretailprice, ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){
			sb.append(" isnull(temp1.sGoodsBarCode,(bgigoodsbarcode+'00000000'))    AS bgigoodsbarcode, ");
		}else{
			sb.append(" bgigoodsbarcode+'00000000'    AS bgigoodsbarcode, ");
		}	
		
		sb.append(" bgigoodsid         	AS bgigoodsid, ");
		sb.append(" bgigoodsname       	AS bgigoodsname, ");
		sb.append(" bgicostprice       	AS bgicostprice, ");
		sb.append(" bginottaxrate      	AS bginottaxrate, ");
		sb.append(" bgispec            	AS bgispec, ");
		sb.append(" bgicolor           	AS bgicolor, ");
		sb.append(" bgiviewgoodsname    AS bgiviewgoodsname, ");
		sb.append(" bgisuppliercolor    AS bgisuppliercolor , ");
		sb.append(" bgiwarehouseid      AS bgiwarehouseid , ");
		sb.append(" bgiwarehousename    as bgiwarehousename , ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,bgidefaultdiscountvaluename as bgidefaultdiscountvaluename ");
			sb.append(" ,bgidefaultdiscount as bgidefaultdiscount ");
		}

		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiframematerialtype           AS bgiframematerialtype ");
			sb.append(" ,bgiframesize     	AS bgiframesize  ");
			sb.append(" ,bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename  ");
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiaccessoriestype  AS bgiaccessoriestype  ");
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			
		
			sb.append(" ,bgirefractive     	AS bgirefractive  ");
			sb.append(" ,bgiismutiluminosity AS bgiismutiluminosity  ");
			sb.append(" ,bgieyeglassmaterialtype     AS bgieyeglassmaterialtype  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgibelowplusluminosity     AS bgibelowplusluminosity  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisphul     		AS bgisphul  ");
				sb.append(" ,bgisphup     		AS bgisphup  ");
				sb.append(" ,bgicylul     		AS bgicylul  ");
				sb.append(" ,bgicylup     		AS bgicylup  ");
				sb.append(" ,bgibelowplusluminosityul     AS bgibelowplusluminosityul  ");
				sb.append(" ,bgibelowplusluminosityup     AS bgibelowplusluminosityup  ");
				sb.append(" ,bgiaxis     		AS bgiaxis  ");
				sb.append(" ,bgigradualclass     AS bgigradualclass  ");
				sb.append(" ,bgifunctionclass    AS bgifunctionclass  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
		
			sb.append(" ,bgiusetype     		AS bgiusetype  ");
			sb.append(" ,bgistealthclass     AS bgistealthclass  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgicurvature1     	AS bgicurvature1  ");
				sb.append(" ,bgidia     			AS bgidia  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgicurvature1ul     AS bgicurvature1ul  ");
				sb.append(" ,bgicurvature1up     AS bgicurvature1up  ");
				sb.append(" ,bgicurvature2ul     AS bgicurvature2ul  ");
				sb.append(" ,bgicurvature2up     AS bgicurvature2up  ");
				sb.append(" ,bgiaxisul     		AS bgiaxisul  ");
				sb.append(" ,bgiaxisup     		AS bgiaxisup  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");				
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgicapacity         AS bgicapacity  ");
			sb.append(" ,bgicapacityentry    AS bgicapacityentry  ");
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisungglassesfun   as bgisungglassesfun  ");
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisph     			AS bgisph  ");
		}		
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){			
			sb.append(" ,isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity  ");
		}else{
			sb.append(" ,1     AS bgigoodsquantity  ");
		}	
				
		//新增显示内容 end		
		sb.append("FROM   (SELECT B_GI_GoodsCategoryID AS bgigoodscategoryid ");
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailprice     AS bgiretailprice ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricea     AS bgiretailprice ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricec     AS bgiretailprice ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriced     AS bgiretailprice ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricee     AS bgiretailprice ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricef     AS bgiretailprice ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricei     AS bgiretailprice ");
		}
		sb.append(" ,B_GI_GoodsBarCode  AS bgigoodsbarcode ");
		sb.append(" ,B_GI_GoodsID       AS bgigoodsid ");
		sb.append(" ,B_GI_ViewGoodsName AS bgigoodsname ");
		sb.append(" ,B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,B_GL_Name		   AS bgidefaultdiscountvaluename ");
			sb.append(" ,B_GL_Discount	   AS bgidefaultdiscount ");
		}
		sb.append(" ,B_GI_CostPrice     AS bgicostprice ");
		sb.append(" ,B_GI_NotTaxRate    AS bginottaxrate ");
		sb.append(" ,B_GI_Spec          AS bgispec ");		
		sb.append(" ,B_GI_Color           AS bgicolor ");
		sb.append(" ,B_GI_ViewGoodsName         AS bgiviewgoodsname ");
		sb.append(" ,warehouseId AS bgiwarehouseid,warehouseName AS bgiwarehousename ");
		sb.append(" ,B_GI_SupplierColor  AS bgisuppliercolor  ");      // 厂家颜色
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_FrameMaterialType    AS bgiframematerialtype  ");   // 镜架材质ID
			sb.append(" ,B_GI_FrameSize     AS bgiframesize  ");                  // 镜架尺寸
			sb.append(" ,B_FM_Name           AS bgieyeglassmaterialtypename  ");   // 镜架材质名称
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_AccessoriesType     AS bgiaccessoriestype  ");      // 配件类型
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			

			sb.append(" ,B_GI_Refractive     AS bgirefractive  ");   // 折射率
			sb.append(" ,B_GI_isMutiLuminosity     AS bgiismutiluminosity  ");           // 光度分类			
			sb.append(" ,B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype  ");     // 镜片材质
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity  ");    // 下加光度
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_SphUL     AS bgisphul  ");          // 球镜上限
				sb.append(" ,B_GI_SphUP     AS bgisphup  ");          // 球镜下限
				sb.append(" ,B_GI_CylUL     AS bgicylul  ");          // 柱镜上限
				sb.append(" ,B_GI_CylUP     AS bgicylup  ");          // 柱镜下限
				sb.append(" ,B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul  ");    // 下加光度上限
				sb.append(" ,B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup  ");    // 下加光度下限
				sb.append(" ,B_GI_Axis     AS bgiaxis  ");            // 轴向
				sb.append(" ,B_GI_GradualClass     AS bgigradualclass  ");      // 渐进片分类
				sb.append(" ,B_GI_FunctionClass     AS bgifunctionclass  ");     // 镜片功能
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			sb.append(" ,B_GI_UseType     AS bgiusetype  ");     // 使用类型
			sb.append(" ,B_GI_StealthClass     AS bgistealthclass  ");     // 抛弃型分类			
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_Curvature1     AS bgicurvature1  ");   // 曲率1
				sb.append(" ,B_GI_Dia     AS bgidia  ");      // 直径
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Curvature1UL   AS bgicurvature1ul  ");       // 曲率1上限
				sb.append(" ,B_GI_Curvature1UP   AS bgicurvature1up  ");       // 曲率1下限
				sb.append(" ,B_GI_Curvature2UL   AS bgicurvature2ul  ");       // 曲率2上限
				sb.append(" ,B_GI_Curvature2UP   AS bgicurvature2up ");       // 曲率2下限		
				sb.append(" ,B_GI_AxisUL     AS bgiaxisul  ");                 // 轴向上限
				sb.append(" ,B_GI_AxisUP     AS bgiaxisup  ");                 // 轴向下限	
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Capacity       AS bgicapacity  ");           // 主容量
			sb.append(" ,B_GI_CapacityEntry  AS bgicapacityentry  ");      // 次容量
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_SunGglassesFun          AS bgisungglassesfun ");    // 太阳镜功能
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
		}
	
		sb.append(" from b_goodsinfo ");
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
		    sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		}
		
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");		
		}

		sb.append(" cross join ( ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				if(!"ZZ".equals(po.getBgisupplierid())){
					sb.append(" union all ");
					sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("2".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("3".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("4".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("5".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("6".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("7".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("8".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("9".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		if("10".equals(po.getBgiwhichretail())){
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!"ZZ".equals(Utility.getName(po.getBgiunitid()))){
			sb.append(" and B_GI_SupplierID <> 'zz' ");
		}else{
			sb.append(" and B_GI_SupplierID = 'zz' ");
		}
		
		if(!"".equals(Utility.getName(po.getBgirefractive()))){
			sb.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID = '"+ Utility.getName(po.getBgigoodscategoryid()) +"' ");
		}
		
		if(!"".equals(Utility.getName(po.getBgiother()))){
			if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append("and B_GI_goodsID like ? ");
			params.add("%"+po.getBgigoodsid()+"%");
		}		
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgiaccessoriestype()))){
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(Utility.getName(po.getBgiaccessoriestype()));
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append(" and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if(!"".equals(Utility.getName(po.getBgiiscustomize()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_SphUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_SphSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) ");
					sb.append("and cast(B_GI_cylUP as float)<=cast(? as float) ");
					sb.append("and cast(? as numeric(18,5)) % cast(isnull(B_GI_CylSpan,0.0001) as numeric(18,5)) = 0 ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					
				}
				
				if(!"".equals(Utility.getName(po.getBgiunionsphcyl()))){
					sb.append(" and ((isnull(B_GI_UnionSphCyl,'') <> '' and cast(B_GI_UnionSphCyl as float) >= ?) or isnull(B_GI_UnionSphCyl,'') = '') ");
					params.add(Utility.getName(po.getBgiunionsphcyl()));				
				}	
				
				if(("3".equals(Utility.getName(po.getBgigoodscategoryid()))) && ("-0.25".equals(Utility.getName(po.getBgicyl())))){
					sb.append("and B_GI_cyl25CanNotDo = '0' ");
				}
				
			}else if("0".equals(Utility.getName(po.getBgiiscustomize()))){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append(" and cast(isnull(B_GI_BelowPlusLuminosity,0) as float ) = cast( ? as float ) ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
				}
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}			
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgisph()))){
				sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
				params.add(Utility.getName(po.getBgisph()));
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !"D".equals(po.getBgiiscustomize())){
			if(Utility.getName(po.getBgiisleftorinner()).equals("2")){  // 1. inner   2.left 
				sb.append(" left join ( ");
			}else{
				sb.append(" inner join ( ");
			}

			
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))){				
				sb.append(" select (replace(C_SH_SL_GoodsId,'.','')+'00000000') as sGoodsBarCode,C_SH_SL_GoodsId as goodsId,C_SH_SL_StockId as stockId,sum(C_SH_SL_GoodsQuantity) as goodsQuantity from ");
			}else{
				sb.append(" select C_SH_SL_GoodsBarCode as sGoodsBarCode,C_SH_SL_GoodsId as goodsId,C_SH_SL_StockId as stockId,sum(C_SH_SL_GoodsQuantity) as goodsQuantity from ");
			}
			
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JJ ");
			}
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_PJ ");
			}
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JP ");
			}
			if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_YX ");
			}
			if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HLY ");
			}
			if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_TYJ ");
			}
			if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HC ");
			}
			if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_LHJ ");
			}
			if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_SG ");
			}		
			
			sb.append(" where 1=1 ");
			
			if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" and substring(C_SH_SL_GoodsId,1,1) = '"+ Utility.getName(po.getBgigoodscategoryid()) +"' ");
			}
			sb.append(" and C_SH_SL_StockId in ( ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID1  as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				if(!"ZZ".equals(po.getBgisupplierid())){
					sb.append(" union all ");
					sb.append(" select B_WC_StockID13  as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
			sb.append(" ) ");
			
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))){				
				sb.append(" 	group by C_SH_SL_GoodsId,C_SH_SL_StockId ");
			}else{
				sb.append(" 	group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
			}
			
			sb.append(" 	) temp1 ");
			sb.append(" 	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.stockId ");
			
			if("0".equals(Utility.getName(po.getQueryType()))){
				if(Utility.getName(po.getBgiiscustomize()).equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(po.getBgicppquerytype()).equals("1")){
					
				}else{
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}			
			}else{
				if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}	
			}
			
		}
		
		sb.append(" )temp2 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" order by bgiwarehouseid desc ");
		sb.append("set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	
	}
	
	public List<GoodsInfoPo> getScanGoodsListNew(GoodsInfoPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevelNew(bgigoodsid,?,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscountNew(bgigoodsid,?,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		params.add(Utility.getName(po.getBgishopcode()));
		
		sb.append(" bgiretailprice     AS bgiretailprice, ");
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !Utility.getName(po.getBgiiscustomize()).equals("D") ){
			sb.append(" isnull(temp1.sGoodsBarCode,(goodsinfo.bgigoodsbarcode+'00000000'))    AS bgigoodsbarcode, ");
		}else{
			sb.append(" bgigoodsbarcode + '00000000'    AS bgigoodsbarcode, ");
		}
		
		sb.append(" bgigoodsid         	AS bgigoodsid, ");
		sb.append(" bgigoodsname       	AS bgigoodsname, ");
//		sb.append(" bgibrandname       	AS bgibrandname, ");
		sb.append(" bgicostprice       	AS bgicostprice, ");
		sb.append(" bginottaxrate      	AS bginottaxrate, ");
		sb.append(" bgispec            	AS bgispec, ");
		sb.append(" bgicolor           	AS bgicolor, ");
		sb.append(" bgiviewgoodsname    AS bgiviewgoodsname, ");
//		sb.append(" bgisuppliercolor    AS bgisuppliercolor , ");
		sb.append(" bgiwarehouseid       AS bgiwarehouseid , ");
		sb.append(" bgiwarehousename     AS bgiwarehousename , ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue ");
		
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,bgidefaultdiscountvaluename as bgidefaultdiscountvaluename ");
		}
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiframematerialtype           AS bgiframematerialtype ");
			sb.append(" ,bgiframesize     	AS bgiframesize  ");
			sb.append(" ,bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename  ");
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiaccessoriestype  AS bgiaccessoriestype  ");
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			
		
			sb.append(" ,bgirefractive     	AS bgirefractive  ");
			sb.append(" ,bgiismutiluminosity AS bgiismutiluminosity  ");
			sb.append(" ,bgieyeglassmaterialtype     AS bgieyeglassmaterialtype  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgibelowplusluminosity     AS bgibelowplusluminosity  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisphul     		AS bgisphul  ");
				sb.append(" ,bgisphup     		AS bgisphup  ");
				sb.append(" ,bgicylul     		AS bgicylul  ");
				sb.append(" ,bgicylup     		AS bgicylup  ");
				sb.append(" ,bgibelowplusluminosityul     AS bgibelowplusluminosityul  ");
				sb.append(" ,bgibelowplusluminosityup     AS bgibelowplusluminosityup  ");
				sb.append(" ,bgiaxis     		AS bgiaxis  ");
				sb.append(" ,bgigradualclass     AS bgigradualclass  ");
				sb.append(" ,bgifunctionclass    AS bgifunctionclass  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
		
			sb.append(" ,bgiusetype     		AS bgiusetype  ");
			sb.append(" ,bgistealthclass     AS bgistealthclass  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgicurvature1     	AS bgicurvature1  ");
				sb.append(" ,bgidia     			AS bgidia  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgicurvature1ul     AS bgicurvature1ul  ");
				sb.append(" ,bgicurvature1up     AS bgicurvature1up  ");
				sb.append(" ,bgicurvature2ul     AS bgicurvature2ul  ");
				sb.append(" ,bgicurvature2up     AS bgicurvature2up  ");
				sb.append(" ,bgiaxisul     		AS bgiaxisul  ");
				sb.append(" ,bgiaxisup     		AS bgiaxisup  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");				
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgicapacity         AS bgicapacity  ");
			sb.append(" ,bgicapacityentry    AS bgicapacityentry  ");
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisungglassesfun   as bgisungglassesfun  ");
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisph     			AS bgisph  ");
		}	

		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !Utility.getName(po.getBgiiscustomize()).equals("D") ){
			sb.append(" ,isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity  ");
			sb.append(" ,dbo.getInTransitNum(bgigoodsid,isnull(temp1.sGoodsBarCode,(goodsinfo.bgigoodsbarcode+'00000000')),bgiwarehouseid) AS bgiintransitgoodsnum ");
			sb.append(" ,case ");
			sb.append(" 	when isnull(temp1.goodsQuantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,isnull(temp1.sGoodsBarCode,(goodsinfo.bgigoodsbarcode+'00000000')),bgiwarehouseid),0) > 0 then '' ");
			sb.append(" 	when isnull(temp1.goodsQuantity,0)-isnull(dbo.getInTransitNum(bgigoodsid,isnull(temp1.sGoodsBarCode,(goodsinfo.bgigoodsbarcode+'00000000')),bgiwarehouseid),0) <= 0 then '(无现货)' ");
			sb.append(" end as bgiishavestock ");
		}else{
			sb.append(" ,1     AS bgigoodsquantity  ");
			sb.append(" ,0 AS bgiintransitgoodsnum ");
			sb.append(" ,'' as bgiishavestock ");
		}
		
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, B_GI_GoodsCategoryID AS bgigoodscategoryid ");
		
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailprice     AS bgiretailprice ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricea     AS bgiretailprice ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricec     AS bgiretailprice ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriced     AS bgiretailprice ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricee     AS bgiretailprice ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricef     AS bgiretailprice ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricei     AS bgiretailprice ");
		}
		sb.append(" ,B_GI_GoodsBarCode  AS bgigoodsbarcode ");
		sb.append(" ,B_GI_GoodsID       AS bgigoodsid ");
		sb.append(" ,B_GI_ViewGoodsName AS bgigoodsname ");
		sb.append(" ,B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,B_GL_Name		   AS bgidefaultdiscountvaluename ");
		}
//		sb.append(" ,B_BD_brandName     AS bgibrandname ");
		sb.append(" ,B_GI_CostPrice     AS bgicostprice ");
		sb.append(" ,B_GI_NotTaxRate    AS bginottaxrate ");
		sb.append(" ,B_GI_Spec          AS bgispec ");		
		sb.append(" ,B_GI_Color           AS bgicolor ");
		sb.append(" ,B_GI_ViewGoodsName         AS bgiviewgoodsname ");
//		sb.append(" ,B_GI_SupplierColor  AS bgisuppliercolor  ");      // 厂家颜色
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_FrameMaterialType    AS bgiframematerialtype  ");   // 镜架材质ID
			sb.append(" ,B_GI_FrameSize     AS bgiframesize  ");                  // 镜架尺寸
			sb.append(" ,B_FM_Name           AS bgieyeglassmaterialtypename  ");   // 镜架材质名称
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_AccessoriesType     AS bgiaccessoriestype  ");      // 配件类型
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			

			sb.append(" ,B_GI_Refractive     AS bgirefractive  ");   // 折射率
			sb.append(" ,B_GI_isMutiLuminosity     AS bgiismutiluminosity  ");           // 光度分类			
			sb.append(" ,B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype  ");     // 镜片材质
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity  ");    // 下加光度
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_SphUL     AS bgisphul  ");          // 球镜上限
				sb.append(" ,B_GI_SphUP     AS bgisphup  ");          // 球镜下限
				sb.append(" ,B_GI_CylUL     AS bgicylul  ");          // 柱镜上限
				sb.append(" ,B_GI_CylUP     AS bgicylup  ");          // 柱镜下限
				sb.append(" ,B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul  ");    // 下加光度上限
				sb.append(" ,B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup  ");    // 下加光度下限
				sb.append(" ,B_GI_Axis     AS bgiaxis  ");            // 轴向
				sb.append(" ,B_GI_GradualClass     AS bgigradualclass  ");      // 渐进片分类
				sb.append(" ,B_GI_FunctionClass     AS bgifunctionclass  ");     // 镜片功能
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			sb.append(" ,B_GI_UseType     AS bgiusetype  ");     // 使用类型
			sb.append(" ,B_GI_StealthClass     AS bgistealthclass  ");     // 抛弃型分类			
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_Curvature1     AS bgicurvature1  ");   // 曲率1
				sb.append(" ,B_GI_Dia     AS bgidia  ");      // 直径
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Curvature1UL   AS bgicurvature1ul  ");       // 曲率1上限
				sb.append(" ,B_GI_Curvature1UP   AS bgicurvature1up  ");       // 曲率1下限
				sb.append(" ,B_GI_Curvature2UL   AS bgicurvature2ul  ");       // 曲率2上限
				sb.append(" ,B_GI_Curvature2UP   AS bgicurvature2up ");       // 曲率2下限		
				sb.append(" ,B_GI_AxisUL     AS bgiaxisul  ");                 // 轴向上限
				sb.append(" ,B_GI_AxisUP     AS bgiaxisup  ");                 // 轴向下限	
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Capacity       AS bgicapacity  ");           // 主容量
			sb.append(" ,B_GI_CapacityEntry  AS bgicapacityentry  ");      // 次容量
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_SunGglassesFun          AS bgisungglassesfun ");    // 太阳镜功能
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
		}
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("        ,isnull(warehouseId,(select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?))         AS bgiwarehouseid  ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append("        ,isnull(warehouseName,(select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)))    AS bgiwarehousename ");
			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else{
			sb.append("  ,case ");
			sb.append("	when B_GI_GoodsCategoryID = '1' then (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '2' then (select B_WC_StockID2 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' then (select B_WC_StockID3 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' then (select B_WC_StockID4 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '5' then (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '6' then (select B_WC_StockID8 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '7' then (select B_WC_StockID9 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '8' then (select B_WC_StockID11 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
			sb.append("	when B_GI_GoodsCategoryID = '9' then (select B_WC_StockID12 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"') ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append("	else '' ");
			sb.append("	end                                         AS bgiwarehouseid ");
			sb.append("  , case ");
			sb.append("		when B_GI_GoodsCategoryID = '1' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID1 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '2' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID2 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID3 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID4 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '5' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '6' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID8 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '7' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID9 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '8' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID11 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
			sb.append("		when B_GI_GoodsCategoryID = '9' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID12 from dbo.B_WarehouseConfiguration where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"')) ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append("	else '' ");
			sb.append("	end                                         AS bgiwarehousename ");
		}
		//新增显示内容 end.

		sb.append(" from b_goodsinfo ");
//		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		if(Utility.getName(po.getBgigoodscategoryid()).equals("1")){
			sb.append(" left join B_FrameMaterial on B_FM_ID = B_GI_FrameMaterialType ");
		}
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		}	
		sb.append(" cross join ( ");
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))&&"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select B_WC_StockID1  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID13  as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID13 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if("".equals(Utility.getName(po.getBgiother()))){
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
					sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
				sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
			
//			params.add(Utility.getName(po.getBgiwarehouseid()));
		}else if(!"".equals(Utility.getName(po.getBgiother()))){
			sb.append(" select wt.warehouseId,wt.warehouseName from ( ");
			sb.append(" select B_WC_StockID1 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID1 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID2 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID2 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");		
			sb.append(" union all ");
			sb.append(" select B_WC_StockID3 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID3 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID4 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID4 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID5 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID5 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID6 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID6 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");			
			sb.append(" union all ");
			sb.append(" select B_WC_StockID7 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID7 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID8 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID8 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID9 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID9 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID11 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID11 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" union all ");
			sb.append(" select B_WC_StockID12 as warehouseId,B_WH_warehouseName as warehouseName from dbo.B_WarehouseConfiguration ");
			sb.append(" inner join B_Warehouse on B_WH_ID = B_WC_StockID12 ");
			sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			sb.append(" )wt group by wt.warehouseId,wt.warehouseName");
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
//			params.add(Utility.getName(po.getBgiwarehouseid()));
		}
		sb.append(" ) wtemp ");
		sb.append(" where 1 = 1 ");
		if(po.getBgigoodsbarcode().length() == 5){
			sb.append(" and B_GI_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()).substring(0,5) +"' + '%' ");
//			params.add(Utility.getName(po.getBgigoodsbarcode()).substring(0,5));
		}else{
			if(po.getBgigoodsbarcode().length() > 18){
				sb.append(" and B_GI_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()).substring(0,18) +"' + '%' ");
//				params.add(Utility.getName(po.getBgigoodsbarcode()).substring(0,18));
			}else{
				sb.append(" and B_GI_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()) +"' + '%' ");
//				params.add(Utility.getName(po.getBgigoodsbarcode()));
			}
		}
		
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid())) || "4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");			
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
				
				if(!"".equals(Utility.getName(po.getBgiunionsphcyl()))){
					sb.append(" and ((isnull(B_GI_UnionSphCyl,'') <> '' and cast(B_GI_UnionSphCyl as float) >= ?) or isnull(B_GI_UnionSphCyl,'') = '') ");
					params.add(Utility.getName(po.getBgiunionsphcyl()));				
				}
				
				if(("3".equals(Utility.getName(po.getBgigoodscategoryid()))) && ("-0.25".equals(Utility.getName(po.getBgicyl())))){
					sb.append("and B_GI_cyl25CanNotDo = '0' ");
				}
				
			}else if("0".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Vsph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_Vcyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
			}else{
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgisph()))){
				sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
				params.add(Utility.getName(po.getBgisph()));
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		sb.append(" )goodsinfo ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !Utility.getName(po.getBgiiscustomize()).equals("D")){
			
			if(Utility.getName(po.getBgiisleftorinner()).equals("2")){  // 1. inner   2.left 
				sb.append(" left join ( ");
			}else{
				sb.append(" inner join ( ");
			}
			
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select (replace(C_SH_SL_GoodsId,'.','')+'00000000') as sGoodsBarCode,C_SH_SL_GoodsId as goodsId,C_SH_SL_StockId as stockId,sum(C_SH_SL_GoodsQuantity) as goodsQuantity from ");
			}else{
				sb.append(" select C_SH_SL_GoodsBarCode as sGoodsBarCode,C_SH_SL_GoodsId as goodsId,C_SH_SL_StockId as stockId,sum(C_SH_SL_GoodsQuantity) as goodsQuantity from ");
			}
			
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JJ ");
			}
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_PJ ");
			}
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JP ");
			}
			if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_YX ");
			}
			if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HLY ");
			}
			if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_TYJ ");
			}
			if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HC ");
			}
			if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_LHJ ");
			}
			if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_SG ");
			}		
			
			sb.append(" where 1=1 ");
			
			if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" and substring(C_SH_SL_GoodsId,1,1) = '"+ Utility.getName(po.getBgigoodscategoryid()) +"' ");
//				params.add(Utility.getName(po.getBgigoodscategoryid()));
			}
			if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
				sb.append(" and C_SH_SL_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()) +"' + '%' ");
//				params.add(Utility.getName(po.getBgigoodsbarcode()));
			}
			
			sb.append(" and C_SH_SL_StockId in ( ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID1  as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				if(!"ZZ".equals(po.getBgisupplierid())){
					sb.append(" union all ");
					sb.append(" select B_WC_StockID13  as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
//					params.add(Utility.getName(po.getBgiwarehouseid()));
				}
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = '"+ Utility.getName(po.getBgiwarehouseid()) +"' ");
			}
//			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append(" ) ");
			
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" 	group by C_SH_SL_GoodsId,C_SH_SL_StockId ");	
			}else{
				sb.append(" 	group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");	
			}
				
			
			sb.append(" ) temp1	ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
			sb.append(" 	where 1=1 ");

			if("0".equals(Utility.getName(po.getQueryType()))){
				if(Utility.getName(po.getBgiiscustomize()).equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(po.getBgicppquerytype()).equals("1")){
					
				}else{
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}			
			}else{
				if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}	
			}
		}
		
		sb.append(" 	order by bgiwarehouseid desc ");
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	
	}
	
	public List<GoodsInfoPo> getScanGoodsList1New(GoodsInfoPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		if(po.getSystemparameterlevel().equals("1")){
			sb.append("dbo.getGoodsMaxDiscountLevel(bgigoodsid) as maxdiscount,dbo.GetcustomermaxdiscountLevelNew(bgigoodsid,?,?) as customerdiscount,");
		}else{
			sb.append("dbo.getGoodsMaxDiscount(bgigoodsid) as maxdiscount,dbo.getCustomerMaxDiscountNew(bgigoodsid,?,?) as customerdiscount,");
		}
		params.add(Utility.getName(po.getCustomercardtype()));
		params.add(Utility.getName(po.getBgishopcode()));
		
		sb.append("       bgiretailprice     AS bgiretailprice, ");
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !Utility.getName(po.getBgiiscustomize()).equals("D") ){
			sb.append("       isnull(temp1.bgigoodsbarcode,(goodsinfo.bgigoodsbarcode+'00000000'))    AS bgigoodsbarcode, ");
			sb.append("       isnull(temp1.guaranteeperiod,'') as guaranteeperiod, ");
			sb.append("       isnull(temp1.batch,'')        as batch, ");
			
		}else{			
			sb.append(" goodsinfo.bgigoodsbarcode + '00000000'    AS bgigoodsbarcode, ");
			sb.append(" '' as guaranteeperiod, ");
			sb.append(" ''      as batch, ");
		}
		
		sb.append(" bgigoodsid         	AS bgigoodsid, ");
		sb.append(" bgigoodsname       	AS bgigoodsname, ");
		sb.append(" bgibrandname       	AS bgibrandname, ");
		sb.append(" bgicostprice       	AS bgicostprice, ");
		sb.append(" bginottaxrate      	AS bginottaxrate, ");
		sb.append(" bgispec            	AS bgispec, ");
		sb.append(" bgicolor           	AS bgicolor, ");
		sb.append(" bgiviewgoodsname    AS bgiviewgoodsname, ");
		sb.append(" bgisuppliercolor    AS bgisuppliercolor , ");
		sb.append(" bgiwarehouseid       AS bgiwarehouseid , ");
		sb.append(" bgiwarehousename     AS bgiwarehousename , ");
		sb.append(" bgidefaultdiscountvalue as bgidefaultdiscountvalue ");
		
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,bgidefaultdiscountvaluename as bgidefaultdiscountvaluename ");
		}
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiframematerialtype           AS bgiframematerialtype ");
			sb.append(" ,bgiframesize     	AS bgiframesize  ");
			sb.append(" ,bgieyeglassmaterialtypename     as bgieyeglassmaterialtypename  ");
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgiaccessoriestype  AS bgiaccessoriestype  ");
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			
		
			sb.append(" ,bgirefractive     	AS bgirefractive  ");
			sb.append(" ,bgiismutiluminosity AS bgiismutiluminosity  ");
			sb.append(" ,bgieyeglassmaterialtype     AS bgieyeglassmaterialtype  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgibelowplusluminosity     AS bgibelowplusluminosity  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisphul     		AS bgisphul  ");
				sb.append(" ,bgisphup     		AS bgisphup  ");
				sb.append(" ,bgicylul     		AS bgicylul  ");
				sb.append(" ,bgicylup     		AS bgicylup  ");
				sb.append(" ,bgibelowplusluminosityul     AS bgibelowplusluminosityul  ");
				sb.append(" ,bgibelowplusluminosityup     AS bgibelowplusluminosityup  ");
				sb.append(" ,bgiaxis     		AS bgiaxis  ");
				sb.append(" ,bgigradualclass     AS bgigradualclass  ");
				sb.append(" ,bgifunctionclass    AS bgifunctionclass  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
		
			sb.append(" ,bgiusetype     		AS bgiusetype  ");
			sb.append(" ,bgistealthclass     AS bgistealthclass  ");
			sb.append(" ,bgiiscustomize     	AS bgiiscustomize ");
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,bgisph     			AS bgisph  ");
				sb.append(" ,bgicyl     			AS bgicyl  ");
				sb.append(" ,bgicurvature1     	AS bgicurvature1  ");
				sb.append(" ,bgidia     			AS bgidia  ");
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,bgicurvature1ul     AS bgicurvature1ul  ");
				sb.append(" ,bgicurvature1up     AS bgicurvature1up  ");
				sb.append(" ,bgicurvature2ul     AS bgicurvature2ul  ");
				sb.append(" ,bgicurvature2up     AS bgicurvature2up  ");
				sb.append(" ,bgiaxisul     		AS bgiaxisul  ");
				sb.append(" ,bgiaxisup     		AS bgiaxisup  ");
				sb.append(" ,bgiordercycle       AS bgiordercycle  ");				
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgicapacity         AS bgicapacity  ");
			sb.append(" ,bgicapacityentry    AS bgicapacityentry  ");
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisungglassesfun   as bgisungglassesfun  ");
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,bgisph     			AS bgisph  ");
		}	

		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !Utility.getName(po.getBgiiscustomize()).equals("D") ){
			sb.append("       ,isnull(temp1.goodsQuantity,0)     AS bgigoodsquantity ");
			sb.append("		  ,dbo.getInTransitNum(bgigoodsid,isnull(temp1.bgigoodsbarcode,(goodsinfo.bgigoodsbarcode + '00000000')),bgiwarehouseid) AS bgiintransitgoodsnum ");
		}else{			
			sb.append("       ,1    AS bgigoodsquantity ");
			sb.append("		  ,dbo.getInTransitNum(bgigoodsid,(bgigoodsbarcode + '00000000') ,bgiwarehouseid) AS bgiintransitgoodsnum ");
		}
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, B_GI_GoodsCategoryID AS bgigoodscategoryid ");

		if("1".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailprice     AS bgiretailprice ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricea     AS bgiretailprice ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricec     AS bgiretailprice ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriced     AS bgiretailprice ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricee     AS bgiretailprice ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricef     AS bgiretailprice ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" ,b_gi_retailpricei     AS bgiretailprice ");
		}
		sb.append(" ,B_GI_GoodsBarCode  AS bgigoodsbarcode ");
		sb.append(" ,B_GI_GoodsID       AS bgigoodsid ");
		sb.append(" ,B_GI_ViewGoodsName AS bgigoodsname ");
		sb.append(" ,B_GI_DefaultDiscountValue AS bgidefaultdiscountvalue ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" ,B_GL_Name		   AS bgidefaultdiscountvaluename ");
		}
		sb.append(" ,B_BD_brandName     AS bgibrandname ");
		sb.append(" ,B_GI_CostPrice     AS bgicostprice ");
		sb.append(" ,B_GI_NotTaxRate    AS bginottaxrate ");
		sb.append(" ,B_GI_Spec          AS bgispec ");		
		sb.append(" ,B_GI_Color           AS bgicolor ");
		sb.append(" ,B_GI_ViewGoodsName         AS bgiviewgoodsname ");
		sb.append(" ,B_GI_SupplierColor  AS bgisuppliercolor  ");      // 厂家颜色
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_FrameMaterialType    AS bgiframematerialtype  ");   // 镜架材质ID
			sb.append(" ,B_GI_FrameSize     AS bgiframesize , ");                  // 镜架尺寸
			sb.append(" ,B_FM_Name           AS bgieyeglassmaterialtypename  ");   // 镜架材质名称
		}

		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_AccessoriesType     AS bgiaccessoriestype  ");      // 配件类型
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){			

			sb.append(" ,B_GI_Refractive     AS bgirefractive  ");   // 折射率
			sb.append(" ,B_GI_isMutiLuminosity     AS bgiismutiluminosity  ");           // 光度分类			
			sb.append(" ,B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype  ");     // 镜片材质
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity  ");    // 下加光度
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_SphUL     AS bgisphul  ");          // 球镜上限
				sb.append(" ,B_GI_SphUP     AS bgisphup  ");          // 球镜下限
				sb.append(" ,B_GI_CylUL     AS bgicylul  ");          // 柱镜上限
				sb.append(" ,B_GI_CylUP     AS bgicylup  ");          // 柱镜下限
				sb.append(" ,B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul  ");    // 下加光度上限
				sb.append(" ,B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup  ");    // 下加光度下限
				sb.append(" ,B_GI_Axis     AS bgiaxis  ");            // 轴向
				sb.append(" ,B_GI_GradualClass     AS bgigradualclass  ");      // 渐进片分类
				sb.append(" ,B_GI_FunctionClass     AS bgifunctionclass  ");     // 镜片功能
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			sb.append(" ,B_GI_UseType     AS bgiusetype  ");     // 使用类型
			sb.append(" ,B_GI_StealthClass     AS bgistealthclass  ");     // 抛弃型分类			
			sb.append(" ,isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");   // 定做标志
			
			if("0".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
				sb.append(" ,B_GI_Cyl     AS bgicyl  ");     // 柱镜
				sb.append(" ,B_GI_Curvature1     AS bgicurvature1  ");   // 曲率1
				sb.append(" ,B_GI_Dia     AS bgidia  ");      // 直径
			}
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append(" ,B_GI_Curvature1UL   AS bgicurvature1ul  ");       // 曲率1上限
				sb.append(" ,B_GI_Curvature1UP   AS bgicurvature1up  ");       // 曲率1下限
				sb.append(" ,B_GI_Curvature2UL   AS bgicurvature2ul  ");       // 曲率2上限
				sb.append(" ,B_GI_Curvature2UP   AS bgicurvature2up ");       // 曲率2下限		
				sb.append(" ,B_GI_AxisUL     AS bgiaxisul  ");                 // 轴向上限
				sb.append(" ,B_GI_AxisUP     AS bgiaxisup  ");                 // 轴向下限	
				sb.append(" ,B_GI_orderCycle     AS bgiordercycle  ");         // 委外加工周期
			}
		}
		
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Capacity       AS bgicapacity  ");           // 主容量
			sb.append(" ,B_GI_CapacityEntry  AS bgicapacityentry  ");      // 次容量
		}
		
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_SunGglassesFun          AS bgisungglassesfun ");    // 太阳镜功能
		}
		
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" ,B_GI_Sph     AS bgisph  ");     // 球镜
		}
		
		sb.append("  ,case ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
		sb.append("	when B_GI_GoodsCategoryID = '5' then (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?) ");
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		sb.append("	else '' ");
		sb.append("	end  AS bgiwarehouseid ");
		sb.append(" ,case ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID5 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
		sb.append("	when B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID6 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
		sb.append("	when B_GI_GoodsCategoryID = '5' then (select B_WH_warehouseName from B_Warehouse where B_WH_ID = (select B_WC_StockID7 from dbo.B_WarehouseConfiguration where B_WC_deptID = ?)) ");
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		params.add(Utility.getName(po.getBgiwarehouseid()));
		sb.append("				else '' ");
		sb.append("			    end                                         AS bgiwarehousename ");

		sb.append(" from b_goodsinfo ");
		sb.append(" inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		if(Utility.getName(po.getSystemparameterlevel()).equals("1")){
			sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		}	
		sb.append(" where 1 = 1 ");
		sb.append("   and B_GI_GoodsCategoryID = ? ");
		params.add(Utility.getName(po.getBgigoodscategoryid()));
		if(!"".equals(Utility.getName(Utility.getName(po.getBgiismutiluminosity())))){
			sb.append("and B_GI_isMutiLuminosity=? ");
			params.add(Utility.getName(po.getBgiismutiluminosity()));
		}
		
		if("3".equals(Utility.getName(po.getBgigoodscategoryid())) || "4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");			
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_SphUL as float)>=cast(? as float) and cast(B_GI_SphUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
				
				if(!"".equals(Utility.getName(po.getBgiunionsphcyl()))){
					sb.append(" and ((isnull(B_GI_UnionSphCyl,'') <> '' and cast(B_GI_UnionSphCyl as float) >= ?) or isnull(B_GI_UnionSphCyl,'') = '') ");
					params.add(Utility.getName(po.getBgiunionsphcyl()));				
				}	
				
				if(("3".equals(Utility.getName(po.getBgigoodscategoryid()))) && ("-0.25".equals(Utility.getName(po.getBgicyl())))){
					sb.append("and B_GI_cyl25CanNotDo = '0' ");
				}
				
			}else if("0".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"4".equals(Utility.getName(po.getBgigoodscategoryid()))){
					if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
						sb.append("and B_GI_EyeGlassMaterialType=? " );
						params.add(Utility.getName(po.getBgieyeglassmaterialtype()));
					}
				}
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("D".equals(po.getBgiiscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) ");
					params.add(Utility.getName(po.getBgicyl()));
					params.add(Utility.getName(po.getBgicyl()));
				}
				if(!"".equals(Utility.getName(po.getBgibelowplusluminosity()))){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(Utility.getName(po.getBgibelowplusluminosity()));
					params.add(Utility.getName(po.getBgibelowplusluminosity()));				
				}
			}else{
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(Utility.getName(po.getBgisph()))){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(Utility.getName(po.getBgisph()));
				}
				if(!"".equals(Utility.getName(po.getBgicyl()))){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(Utility.getName(po.getBgicyl()));
				}
			}
		}
		sb.append(" and B_GI_Flag='1' ");
		
		if(Utility.getName(po.getBgigoodsbarcode()).length() == 5){
			sb.append(" and B_GI_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()).substring(0,5) +"' + '%' ");
		}else{
			if(po.getBgigoodsbarcode().length() > 18){
				sb.append(" and B_GI_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()).substring(0,18) +"' + '%' ");
			}else{
				sb.append(" and B_GI_GoodsBarCode like '"+ Utility.getName(po.getBgigoodsbarcode()) +"' + '%' ");
			}
		}
		
		sb.append(" )goodsinfo ");
		
		if (!"1".equals(Utility.getName(po.getBgiisselectstorage())) && !Utility.getName(po.getBgiiscustomize()).equals("D") ){

			if(Utility.getName(po.getBgiisleftorinner()).equals("2")){  // 1. inner   2.left 
				sb.append(" left join ( ");
			}else{
				sb.append(" inner join ( ");
			}
			sb.append("	SELECT  StockId            AS StockId, ");
			sb.append(" goodsId            AS goodsId, ");
			sb.append("	bgigoodsbarcode as bgigoodsbarcode, ");
			sb.append(" SUM(goodsQuantity) AS goodsQuantity, ");
			sb.append("	CASE ");
			sb.append("	WHEN guaranteeperiod = '' THEN '无效期' ");
			sb.append("	WHEN guaranteeperiod is null  THEN '无效期' ");
			sb.append("	ELSE guaranteeperiod ");
			sb.append("	END as guaranteeperiod, ");
			sb.append("	CASE ");
			sb.append("	WHEN batch = '' THEN '无批号' ");
			sb.append("	WHEN batch is null  THEN '无批号' ");
			sb.append("	ELSE batch ");
			sb.append("	END as batch ");
			sb.append(" FROM   ( ");
			sb.append(" SELECT C_SH_Sl_StockId       AS StockId,");
			sb.append(" C_SH_Sl_GoodsId       AS goodsId,");
			sb.append("	C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
			sb.append(" C_SH_Sl_GoodsQuantity AS goodsQuantity,");
			sb.append("	isnull(C_SH_BC_GuaranteePeriod,'') AS guaranteeperiod, ");
			sb.append("	isnull(C_SH_BC_Batch,'') as batch FROM ");

			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JJ ");
			}
			if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_PJ ");
			}
			if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_JP ");
			}
			if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_YX ");
			}
			if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HLY ");
			}
			if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_TYJ ");
			}
			if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_HC ");
			}
			if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_LHJ ");
			}
			if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" C_SH_StorageLog_SG ");
			}		
			sb.append(" left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
			sb.append(" where 1=1 ");
			
			if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" and substring(C_SH_SL_GoodsId,1,1) = ? ");
				params.add(Utility.getName(po.getBgigoodscategoryid()));
			}
			sb.append(" and C_SH_SL_StockId in ( ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID1  as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
				if(!"ZZ".equals(po.getBgisupplierid())){
					sb.append(" union all ");
					sb.append(" select B_WC_StockID13  as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
					params.add(Utility.getName(po.getBgiwarehouseid()));
				}
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID2 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID4 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID3 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				if("D".equals(po.getBgiiscustomize())){
					sb.append(" select B_WC_StockID6 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}else{
					sb.append(" select B_WC_StockID5 as warehouseId from dbo.B_WarehouseConfiguration ");
					sb.append(" where B_WC_deptID = ? ");
				}
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID7 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID8 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID9 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID11 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" select B_WC_StockID12 as warehouseId from dbo.B_WarehouseConfiguration ");
				sb.append(" where B_WC_deptID = ? ");
			}
			params.add(Utility.getName(po.getBgiwarehouseid()));
			sb.append(" ) ");
			
			sb.append(" )t1	group by StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch ");
			
			sb.append(" ) temp1 ON temp1.goodsId = goodsinfo.bgigoodsid and goodsinfo.bgiwarehouseid = temp1.StockId ");
			sb.append(" where 1=1 ");
			sb.append(" and temp1.bgigoodsbarcode like ? + '%' ");
			params.add(po.getBgigoodsbarcode());
			
			if("0".equals(Utility.getName(po.getQueryType()))){
				if(Utility.getName(po.getBgiiscustomize()).equals("0") && "3".equals(Utility.getName(po.getBgigoodscategoryid())) && Utility.getName(po.getBgicppquerytype()).equals("1")){
					
				}else{
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}			
			}else{
				if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
					sb.append(" and isnull(temp1.goodsQuantity,0) > 0 ");
				}	
			}
			
		}		

		sb.append(" order by bgiwarehouseid desc ");
		
		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
}
