/**
 * 
 */
package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.dao.ConLensDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class ConLensDaoImpl extends BaseJdbcDaoSupport implements ConLensDao {


	public int getConLensCount(GoodsInfoTempPo goodsInfoTempPo,WarehouseConfigurationPo warehouseConfigurationPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT COUNT(GoodsId) ");
		sb.append("FROM   (SELECT B_GI_GoodsID       AS GoodsId, ");
		sb.append("               SUM(GoodsQuantity) AS GoodsQuantity, ");
		sb.append("               warehouseid        AS warehouseid ");
		sb.append("        FROM   b_goodsinfo ");
		sb.append("               LEFT JOIN (SELECT GoodsId, ");
		sb.append("                                 GoodsQuantity, ");
		sb.append("                                 warehouseid ");
		sb.append("                          FROM   (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		sb.append("                                         C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                         C_SH_SB_StockId       AS warehouseid ");
		sb.append("                                  FROM   C_SH_StorageBeginning ");
		sb.append("                                  WHERE  1 = 1 ");
		sb.append("                                         AND C_SH_SB_StockId = ? ");
		sb.append("                                  UNION ALL ");
		sb.append("                                  SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		sb.append("                                         C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                         C_SH_SC_StockId       AS warehouseid ");
		sb.append("                                  FROM   C_SH_StorageChange ");
		sb.append("                                  WHERE  1 = 1 ");
		sb.append("                                         AND C_SH_SC_StockId = ?)a)b ");
		
		params.add(warehouseConfigurationPo.getBwcstockid5());
		params.add(warehouseConfigurationPo.getBwcstockid5());
		
		sb.append("                 ON B_GI_GoodsID = b.GoodsId ");
		sb.append("               INNER JOIN b_brand ");
		sb.append("                 ON B_BD_ID = B_GI_brandid ");
		sb.append("                    AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("        WHERE  B_GI_iscustomize = '0' ");
		sb.append("               AND B_GI_GoodsCategoryID = '4' ");
		sb.append("               AND B_GI_Flag = '1' ");
		
		if (!"".equals(Utility.getName(goodsInfoTempPo.getSupplierid()))) {
			sb.append("and B_GI_SupplierID=? ");
			params.add(goodsInfoTempPo.getSupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandid()))) {
			sb.append("and B_GI_brandID=? ");
			params.add(goodsInfoTempPo.getBrandid());
		}
//		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandname()))) {
//			sb.append("and B_BD_brandName=? ");
//			params.add(goodsInfoTempPo.getBrandname());
//		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsid()))) {
			sb.append("and B_GI_goodsID like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsname()))) {
			sb.append("and B_GI_goodsname like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsname());
		}
		
		
		if (!"".equals(goodsInfoTempPo.getIscustomize())) {
			if ("D".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = 'D' ");
				if (!"".equals(Utility.getName(goodsInfoTempPo.getMaterialtype()))) {
					sb.append("and B_GI_EyeGlassMaterialType = ?");
					params.add(goodsInfoTempPo.getMaterialtype());
				}
				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb
							.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(goodsInfoTempPo.getSph());
					params.add(goodsInfoTempPo.getSph());
				}
				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb
							.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) "); // zhuanhuan
					// float
					params.add(goodsInfoTempPo.getCyl());
					params.add(goodsInfoTempPo.getCyl());
				}
				if (!"".equals(Utility.getName(goodsInfoTempPo.getAdd()))) {
					sb
							.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(goodsInfoTempPo.getAdd());
					params.add(goodsInfoTempPo.getAdd());

				}
				if (!"".equals(Utility.getName(Utility.getName(goodsInfoTempPo
						.getIsmutiluminosity())))) {
					sb.append("and B_GI_Ismutiluminosity=? ");
					params.add(goodsInfoTempPo.getIsmutiluminosity());
				}

			} else if ("0".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = '0' ");

				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(goodsInfoTempPo.getSph());
				}

				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(goodsInfoTempPo.getCyl());
				}
				if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsbarcode()))) {
					sb.append("and B_GI_goodsbarcode =? ");
					params.add(goodsInfoTempPo.getLensgoodsbarcode());
				}
			}
		}
		sb.append("        GROUP  BY B_GI_GoodsID, ");
		sb.append("                  warehouseid)c ");
		
		

		return this.getJdbcTemplate().queryForInt(sb.toString(),
				params.toArray());
	}


	public List<GoodsInfoPo> getConLensList(GoodsInfoTempPo goodsInfoTempPo,WarehouseConfigurationPo warehouseConfigurationPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;

		sb.append("SET rowcount 10");


		sb.append("SELECT Isnull(TEMP.bgigoodsquantity, 0) AS bgigoodsquantity, ");
		sb.append("       TEMP.bgiordercycle, ");
		sb.append("       TEMP.bgiiscustomize, ");
		sb.append("       TEMP.bgisphul, ");
		sb.append("       TEMP.bgisphup, ");
		sb.append("       TEMP.bgicylul, ");
		sb.append("       TEMP.bgicylup, ");
		sb.append("       TEMP.bgigoodsid                  AS bgigoodsid, ");
		sb.append("       TEMP.bgigoodsname                AS bgigoodsname, ");
		sb.append("       TEMP.bgisuppliername             AS bgisuppliername, ");
		sb.append("       TEMP.bgisph                      AS bgisph, ");
		sb.append("       TEMP.bgicyl                      AS bgicyl, ");
		sb.append("       TEMP.bgiaxis                     AS bgiaxis, ");
		sb.append("       TEMP.bgicurvature1               AS bgicurvature1, ");
		sb.append("       TEMP.bgidia                      AS bgidia, ");
		sb.append("       TEMP.bgitaxrate                  AS bgitaxrate, ");
		sb.append("       TEMP.bgigoodsbarcode             AS bgigoodsbarcode, ");
		sb.append("       TEMP.bgispec                     AS bgispec, ");
		sb.append("       TEMP.bgicolor                    AS bgicolor, ");
		sb.append("       TEMP.bgibrandname                AS bgibrandname, ");
		sb.append("       TEMP.bgiunitname                 AS bgiunitname, ");
		sb.append("       TEMP.bgicostprice                AS bgicostprice, ");
		sb.append("       TEMP.bgiretailprice              AS bgiretailprice, ");
		sb.append("       TEMP.bginottaxrate               AS bginottaxrate, ");
		sb.append("       TEMP.bgiflag                     AS bgiflag ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY B_GoodsInfo.B_GI_GoodsID) AS rowNum, ");
		sb.append("               B_GoodsInfo.B_GI_orderCycle                          AS bgiordercycle, ");
		sb.append("               B_GoodsInfo.B_GI_iscustomize                         AS bgiiscustomize, ");
		sb.append("               B_GoodsInfo.B_GI_GoodsID                             AS bgigoodsid, ");
		sb.append("               B_GoodsInfo.B_GI_ViewGoodsName                           AS bgigoodsname, ");
		sb.append("               B_Supplier.B_SP_SupplierName                         AS bgisuppliername, ");
		sb.append("               B_GoodsInfo.B_GI_Spec                                AS bgispec, ");
		sb.append("               B_GoodsInfo.B_GI_Color                               AS bgicolor, ");
		sb.append("               B_GoodsInfo.B_GI_Sph                                 AS bgisph, ");
		sb.append("               B_GoodsInfo.B_GI_Cyl                                 AS bgicyl, ");
		sb.append("               B_GoodsInfo.B_GI_Axis                                AS bgiaxis, ");
		sb.append("               B_GoodsInfo.B_GI_Curvature1                          AS bgicurvature1, ");
		sb.append("               B_GoodsInfo.B_GI_Dia                                 AS bgidia, ");
		sb.append("               B_GoodsInfo.B_GI_TaxRate                             AS bgitaxrate, ");
		sb.append("               B_GoodsInfo.B_GI_GoodsBarCode                        AS bgigoodsbarcode, ");
		sb.append("               B_Brand.B_BD_brandName                               AS bgibrandname, ");
		sb.append("               B_Unit.B_UT_unitName                                 AS bgiunitname, ");
		sb.append("               B_GoodsInfo.B_GI_RetailPrice                         AS bgiretailprice, ");
		sb.append("               B_GoodsInfo.B_GI_CostPrice                           AS bgicostprice, ");
		sb.append("               B_GoodsInfo.B_GI_NotTaxRate                          AS bginottaxrate, ");
		sb.append("               B_GoodsInfo.B_GI_Flag                                AS bgiflag, ");
		sb.append("               B_GI_SphUL                                           AS bgisphul, ");
		sb.append("               B_GI_SphUp                                           AS bgisphup, ");
		sb.append("               B_GI_CylUL                                           AS bgicylul, ");
		sb.append("               B_GI_CylUp                                           AS bgicylup, ");
		sb.append("               isnull(GoodsQuantity,0)                              AS bgigoodsquantity ");
		sb.append("        FROM   B_GoodsInfo ");
		sb.append("               LEFT JOIN(SELECT GoodsId            AS GoodsId, ");
		sb.append("                                SUM(GoodsQuantity) AS GoodsQuantity, ");
		sb.append("                                warehouseid        AS warehouseid ");
		sb.append("                         FROM   (SELECT GoodsId, ");
		sb.append("                                        GoodsQuantity, ");
		sb.append("                                        warehouseid ");
		sb.append("                                 FROM   (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		sb.append("                                                C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                                C_SH_SB_StockId       AS warehouseid ");
		sb.append("                                         FROM   C_SH_StorageBeginning ");
		sb.append("                                         WHERE  1 = 1 ");
		sb.append("                                         AND C_SH_SB_StockId = ? ");
		sb.append("                                         UNION ALL ");
		sb.append("                                         SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		sb.append("                                                C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                                C_SH_SC_StockId       AS warehouseid ");
		sb.append("                                         FROM   C_SH_StorageChange ");
		sb.append("                                         WHERE  1 = 1 ");
		sb.append("                                         AND C_SH_SC_StockId = ? ");
		sb.append("                                        )a)b ");
		sb.append("                         GROUP  BY GoodsId, ");
		sb.append("                                   warehouseid)c ");
		sb.append("                 ON B_GI_GoodsID = c.GoodsId ");
		sb.append("               INNER JOIN B_Supplier ");
		sb.append("                 ON B_GoodsInfo.B_GI_SupplierID = B_Supplier.B_SP_ID ");
		sb.append("               INNER JOIN B_Brand ");
		sb.append("                 ON B_GoodsInfo.B_GI_BrandID = B_Brand.B_BD_ID ");
		sb.append("                    AND B_GoodsInfo.B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
		sb.append("               INNER JOIN B_Unit ");
		sb.append("                 ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
		sb.append("        WHERE  B_GoodsInfo.B_GI_Flag = '1' ");
		sb.append("               AND B_GI_iscustomize = '0' ");
		sb.append("               AND B_GI_GoodsCategoryID = '4' ");
		sb.append("               AND B_GI_Flag = '1' ");
		List<String> params = new ArrayList<String>();
		params.add(warehouseConfigurationPo.getBwcstockid5());
		params.add(warehouseConfigurationPo.getBwcstockid5());
		if (!"".equals(Utility.getName(goodsInfoTempPo.getSupplierid()))) {
			sb.append("and B_GI_SupplierID=? ");
			params.add(goodsInfoTempPo.getSupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandid()))) {
			sb.append("and B_GI_brandID=? ");
			params.add(goodsInfoTempPo.getBrandid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsid()))) {
			sb.append("and B_GI_goodsID like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsname()))) {
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsname());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getGoodsnames()))) {
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getGoodsnames());
		}
		if (!"".equals(goodsInfoTempPo.getIscustomize())) {
			if ("D".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = 'D' ");
				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb
							.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(goodsInfoTempPo.getSph());
					params.add(goodsInfoTempPo.getSph());
				}
				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb
							.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) "); // zhuanhuan
					// float
					params.add(goodsInfoTempPo.getCyl());
					params.add(goodsInfoTempPo.getCyl());
				}

			} else if ("0".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = '0' ");
				
				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(goodsInfoTempPo.getSph());
				}
				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(goodsInfoTempPo.getCyl());
				}
				if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsbarcode()))) {
					sb.append("and B_GI_goodsbarcode =? ");
					params.add(goodsInfoTempPo.getLensgoodsbarcode());
				}
			} else {
				sb.append("and B_GI_SupplierID='zz' ");
			}
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return this.queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	public int getOConLensCount(GoodsInfoTempPo goodsInfoTempPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(B_GI_GoodsID) from b_goodsinfo inner join b_brand on B_BD_ID=B_GI_brandid and B_BD_SupplierID=B_GI_SupplierID where 1=1 ");
		if (!"".equals(Utility.getName(goodsInfoTempPo.getSupplierid()))) {
			sb.append("and B_GI_SupplierID=? ");
			params.add(goodsInfoTempPo.getSupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandid()))) {
			sb.append("and B_GI_brandID=? ");
			params.add(goodsInfoTempPo.getBrandid());
		}
//		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandname()))) {
//			sb.append("and B_BD_brandName=? ");
//			params.add(goodsInfoTempPo.getBrandname());
//		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsid()))) {
			sb.append("and B_GI_goodsID like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsname()))) {
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsname());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getGoodsnames()))) {
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getGoodsnames());
		}
		
		if (!"".equals(goodsInfoTempPo.getIscustomize())) {
			if ("D".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = 'D' ");
				if (!"".equals(Utility.getName(goodsInfoTempPo.getMaterialtype()))) {
					sb.append("and B_GI_EyeGlassMaterialType = ?");
					params.add(goodsInfoTempPo.getMaterialtype());
				}
				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb
							.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(goodsInfoTempPo.getSph());
					params.add(goodsInfoTempPo.getSph());
				}
				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb
							.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) "); // zhuanhuan
					// float
					params.add(goodsInfoTempPo.getCyl());
					params.add(goodsInfoTempPo.getCyl());
				}
				if (!"".equals(Utility.getName(goodsInfoTempPo.getAdd()))) {
					sb
							.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(goodsInfoTempPo.getAdd());
					params.add(goodsInfoTempPo.getAdd());

				}
				if (!"".equals(Utility.getName(Utility.getName(goodsInfoTempPo
						.getIsmutiluminosity())))) {
					sb.append("and B_GI_Ismutiluminosity=? ");
					params.add(goodsInfoTempPo.getIsmutiluminosity());
				}

			} else if ("0".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = '0' ");

				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(goodsInfoTempPo.getSph());
				}

				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(goodsInfoTempPo.getCyl());
				}
				if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsbarcode()))) {
					sb.append("and B_GI_goodsbarcode =? ");
					params.add(goodsInfoTempPo.getLensgoodsbarcode());
				}
			}

			sb.append("and B_GI_GoodsCategoryID='4' and B_GI_Flag='1'");
		}

		return this.getJdbcTemplate().queryForInt(sb.toString(),
				params.toArray());
	}


	public List<GoodsInfoPo> getOConLensList(GoodsInfoTempPo goodsInfoTempPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb
				.append("select temp.bgiiscustomize,temp.bgisphul,temp.bgisphup,temp.bgicylul,temp.bgicylup,temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,");
		sb
				.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
		sb
				.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.bgiflag as bgiflag,temp.bgiordercycle as bgiordercycle ");
		sb
				.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
		sb
				.append("B_GoodsInfo.B_GI_iscustomize as bgiiscustomize,B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
		sb
				.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,");
		sb
				.append("B_Brand.B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag, ");
		sb
				.append("B_GI_SphUL as bgisphul,B_GI_SphUp as bgisphup,B_GI_CylUL as bgicylul,B_GI_CylUp as bgicylup,B_GoodsInfo.B_GI_orderCycle as bgiordercycle from B_GoodsInfo inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		// sb.append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb
				.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where B_GoodsInfo.B_GI_Flag='1' ");
		List<String> params = new ArrayList<String>();
		if (!"".equals(Utility.getName(goodsInfoTempPo.getSupplierid()))) {
			sb.append("and B_GI_SupplierID=? ");
			params.add(goodsInfoTempPo.getSupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandid()))) {
			sb.append("and B_GI_brandID=? ");
			params.add(goodsInfoTempPo.getBrandid());
		}
//		if (!"".equals(Utility.getName(goodsInfoTempPo.getBrandname()))) {
//			sb.append("and B_BD_brandName=? ");
//			params.add(goodsInfoTempPo.getBrandname());
//		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsid()))) {
			sb.append("and B_GI_goodsID like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsid());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsname()))) {
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getLensgoodsname());
		}
		if (!"".equals(Utility.getName(goodsInfoTempPo.getGoodsnames()))) {
			sb.append("and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(goodsInfoTempPo.getGoodsnames());
		}
		if (!"".equals(goodsInfoTempPo.getIscustomize())) {
			if ("D".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = 'D' ");
				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb
							.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(goodsInfoTempPo.getSph());
					params.add(goodsInfoTempPo.getSph());
				}
				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb
							.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) "); // zhuanhuan
					// float
					params.add(goodsInfoTempPo.getCyl());
					params.add(goodsInfoTempPo.getCyl());
				}

			} else if ("0".equals(goodsInfoTempPo.getIscustomize())) {
				sb.append("and B_GI_iscustomize = '0' ");
				
				if (!"".equals(goodsInfoTempPo.getSph())) {
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(goodsInfoTempPo.getSph());
				}
				if (!"".equals(goodsInfoTempPo.getCyl())) {
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(goodsInfoTempPo.getCyl());
				}
				if (!"".equals(Utility.getName(goodsInfoTempPo.getLensgoodsbarcode()))) {
					sb.append("and B_GI_goodsbarcode =? ");
					params.add(goodsInfoTempPo.getLensgoodsbarcode());
				}
			} else {
				sb.append("and B_GI_SupplierID='zz' ");
			}
			sb.append("and B_GI_GoodsCategoryID='4' and B_GI_Flag='1'");
			sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
					+ countPage);
			sb.append(" set rowcount 0");
		}
		return this.queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

}
