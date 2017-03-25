package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowFramesAccessoriesDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WindowFramesAccessoriesDaoImpl extends BaseJdbcDaoSupport implements
		WindowFramesAccessoriesDao {

	/**
	 * 得到镜架辅料信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getFramesAccessoriesCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(B_GI_GoodsID) ");
		buffer.append("from(select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid ");
		buffer.append("from (select ROW_NUMBER() Over(order by GoodsId) as num , GoodsId , GoodsQuantity , warehouseid ");
		buffer.append("from (select C_SH_SB_GoodsId as GoodsId ,C_SH_SB_GoodsQuantity as GoodsQuantity , C_SH_SB_StockId as warehouseid ");
		buffer.append("from C_SH_StorageBeginning where 1=1 and C_SH_SB_StockId = ? union all ");
		buffer.append("select C_SH_SC_GoodsId as GoodsId , C_SH_SC_GoodsQuantity as GoodsQuantity , C_SH_SC_StockId as warehouseid ");
		buffer.append("from C_SH_StorageChange where 1=1 and C_SH_SC_StockId = ? )a )b ");
		buffer.append("group by GoodsId,warehouseid)c ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID=c.GoodsId ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID=B_Supplier.B_SP_ID ");
		buffer.append("inner join B_Brand on B_GI_BrandID=B_BD_ID ");
		buffer.append("and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("where B_GI_GoodsCategoryID= '2' ");
		
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgiwarehouseid());
		
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))){
			buffer.append("and B_GI_GoodsID= ? ");
			params.add(goodsInfoPo.getBgigoodsid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))){
			buffer.append("and B_GI_ViewGoodsName= ? ");
			params.add(goodsInfoPo.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))){
			buffer.append("and B_GI_BrandID= ? ");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))){
			buffer.append("and B_GI_SupplierID= ? ");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询镜架辅料信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectFramesAccessoriesList(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by B_GI_GoodsID desc) as rowNum, ");
		
		buffer.append("B_GI_GoodsID as bgigoodsid , B_GI_ViewGoodsName as bgigoodsname , ");
		buffer.append("B_GI_Spec as bgispec , B_GI_RetailPrice as bgiretailprice , ");
		buffer.append("B_GI_SupplierID as bgisupplierid , B_SP_SupplierName as bgisuppliername , ");
		buffer.append("B_GI_BrandID as bgibrandid , B_BD_brandName as bgibrandname , ");
		buffer.append("B_GI_GoodsCategoryID as bgigoodscategoryid , ");
		buffer.append("B_GI_CostPrice as bgicostprice , B_GI_NotTaxRate as bginottaxrate ");
		buffer.append("from ");
		buffer.append("(select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid  from ");
		buffer.append("(select ROW_NUMBER() Over(order by GoodsId) as num , ");
		buffer.append("GoodsId,GoodsQuantity,warehouseid from ");
		buffer.append("(select C_SH_SB_GoodsId as GoodsId , ");
		buffer.append("C_SH_SB_GoodsQuantity as GoodsQuantity , ");
		buffer.append("C_SH_SB_StockId as warehouseid ");
		buffer.append("from C_SH_StorageBeginning where 1=1 ");
		buffer.append("and C_SH_SB_StockId = ? ");
		buffer.append("union all ");
		buffer.append("select C_SH_SC_GoodsId as GoodsId , ");
		buffer.append("C_SH_SC_GoodsQuantity as GoodsQuantity , ");
		buffer.append("C_SH_SC_StockId as warehouseid ");
		buffer.append("from C_SH_StorageChange where 1=1 ");
		buffer.append("and C_SH_SC_StockId = ? ");
		buffer.append(")a )b group by GoodsId,warehouseid)c ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID=c.GoodsId ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID=B_Supplier.B_SP_ID ");
		buffer.append("inner join B_Brand on B_GI_BrandID=B_BD_ID 	and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("where B_GI_GoodsCategoryID= '2' ");
		
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgiwarehouseid());
		
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))){
			buffer.append("and B_GI_GoodsID= ? ");
			params.add(goodsInfoPo.getBgigoodsid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))){
			buffer.append("and B_GI_ViewGoodsName= ? ");
			params.add(goodsInfoPo.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))){
			buffer.append("and B_GI_BrandID= ? ");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if(!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))){
			buffer.append("and B_GI_SupplierID= ? ");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , GoodsInfoPo.class);
	}
	
	/**
	 * 根据商品条码得到商品信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getCountByGoodsbarcode(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		List<String> params=new ArrayList<String>();
		
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("SELECT COUNT(B_GI_GoodsID) ");
		varname1.append("FROM   (SELECT B_GI_GoodsID ");
		varname1.append("        FROM   B_GoodsInfo ");
		varname1.append("               INNER JOIN B_Supplier ");
		varname1.append("                 ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
		varname1.append("               INNER JOIN B_Brand ");
		varname1.append("                 ON B_GI_BrandID = B_BD_ID ");
		varname1.append("                    AND B_GI_SupplierID = B_BD_SupplierID ");
		varname1.append("        WHERE  B_GI_GoodsCategoryID = '2' ");
		varname1.append("               AND B_GI_GoodsBarCode = substring(?,1,18) ");
		varname1.append("               AND B_GI_Flag = '1') temp1 ");
		varname1.append("       LEFT JOIN (SELECT GoodsId ");
		varname1.append("                  FROM   (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		varname1.append("                                 C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		varname1.append("                                 C_SH_SB_GoodsBarCode  AS GoodsBarcode, ");
		varname1.append("                                 C_SH_SB_StockId       AS warehouseid ");
		varname1.append("                          FROM   C_SH_StorageBeginning ");
		varname1.append("                          WHERE  1 = 1 ");
		varname1.append("                                 AND C_SH_SB_StockId = ? ");
		varname1.append("                                 AND C_SH_SB_GoodsBarCode = substring(?,1,18) ");
		varname1.append("                          UNION ALL ");
		varname1.append("                          SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		varname1.append("                                 C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		varname1.append("                                 C_SH_SC_GoodsBarCode  AS GoodsBarcode, ");
		varname1.append("                                 C_SH_SC_StockId       AS warehouseid ");
		varname1.append("                          FROM   C_SH_StorageChange ");
		varname1.append("                          WHERE  1 = 1 ");
		varname1.append("                                 AND C_SH_SC_StockId = ? ");
		varname1.append("                                 AND C_SH_SC_GoodsBarCode = substring(?,1,18) )a ");
		varname1.append("                  GROUP  BY GoodsId)temp2 ");
		varname1.append("         ON temp2.GoodsId = temp1.B_GI_GoodsID ");
		
		params.add(goodsInfoPo.getBgigoodsbarcode());
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgigoodsbarcode());
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgigoodsbarcode());
		
		
		return getJdbcTemplate().queryForInt(varname1.toString() , params.toArray());
	}

	/**
	 * 根据商品条码得到商品信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getListByGoodsbarcode(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer  varname1 = new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		varname1.append("set rowcount " + countPage + " \n");

		varname1.append(" ");
		varname1.append("SELECT * ");
		varname1.append("FROM   (SELECT Row_number() OVER( ORDER BY B_GI_GoodsID DESC) AS rowNum, ");
		varname1.append("               B_GI_Goodsbarcode                              AS bgigoodsbarcode, ");
		varname1.append("               B_GI_GoodsID                                   AS bgigoodsid, ");
		varname1.append("               B_GI_ViewGoodsName                                 AS bgigoodsname, ");
		varname1.append("               B_GI_Spec                                      AS bgispec, ");
		varname1.append("               B_GI_RetailPrice                               AS bgiretailprice, ");
		varname1.append("               B_GI_SupplierID                                AS bgisupplierid, ");
		varname1.append("               B_SP_SupplierName                              AS bgisuppliername, ");
		varname1.append("               B_GI_BrandID                                   AS bgibrandid, ");
		varname1.append("               B_BD_brandName                                 AS bgibrandname, ");
		varname1.append("               B_GI_GoodsCategoryID                           AS bgigoodscategoryid, ");
		varname1.append("               B_GI_CostPrice                                 AS bgicostprice, ");
		varname1.append("               B_GI_NotTaxRate                                AS bginottaxrate ");
		varname1.append("        FROM   B_GoodsInfo ");
		varname1.append("               INNER JOIN B_Supplier ");
		varname1.append("                 ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
		varname1.append("               INNER JOIN B_Brand ");
		varname1.append("                 ON B_GI_BrandID = B_BD_ID ");
		varname1.append("                    AND B_GI_SupplierID = B_BD_SupplierID ");
		varname1.append("        WHERE  B_GI_GoodsCategoryID = '2' ");
		varname1.append("               AND B_GI_GoodsBarCode = ? ");
		varname1.append("               AND B_GI_Flag = '1') TEMP ");
		varname1.append("       LEFT JOIN (SELECT GoodsId            AS GoodsId, ");
		varname1.append("                         SUM(GoodsQuantity) AS bgigoodsquantity ");
		varname1.append("                  FROM   (SELECT GoodsId, ");
		varname1.append("                                 GoodsQuantity ");
		varname1.append("                          FROM   (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		varname1.append("                                         C_SH_SB_GoodsQuantity AS GoodsQuantity ");
		varname1.append("                                  FROM   C_SH_StorageBeginning ");
		varname1.append("                                  WHERE  1 = 1 ");
		varname1.append("                                         AND C_SH_SB_StockId = ? ");
		varname1.append("                                         AND C_SH_SB_GoodsBarCode = ? ");
		varname1.append("                                  UNION ALL ");
		varname1.append("                                  SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		varname1.append("                                         C_SH_SC_GoodsQuantity AS GoodsQuantity ");
		varname1.append("                                  FROM   C_SH_StorageChange ");
		varname1.append("                                  WHERE  1 = 1 ");
		varname1.append("                                         AND C_SH_SC_StockId = ? ");
		varname1.append("                                         AND C_SH_SC_GoodsBarCode = ?)a)b ");
		varname1.append("                  GROUP  BY GoodsId)temp1 ");
		varname1.append("         ON TEMP.bgigoodsid = temp1.GoodsId ");
		varname1.append("where rowNum > " + start + " and rowNum <= "+ countPage);


		varname1.append(" ");
		varname1.append("SET rowcount 0 "); 
		
		params.add(goodsInfoPo.getBgigoodsbarcode());
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgigoodsbarcode());
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgigoodsbarcode());
		
		
		return queryForObjectList(varname1.toString() , params.toArray() , GoodsInfoPo.class);
	}

}
