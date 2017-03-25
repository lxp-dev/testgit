package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.SelectGoodsByGoodsbarcodeDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SelectGoodsByGoodsbarcodeDaoImpl extends BaseJdbcDaoSupport implements
		SelectGoodsByGoodsbarcodeDao {

	/**
	 * 根据条码查询商品数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int goodsByGoodsbarcodeCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(B_GI_GoodsID) ");
		buffer.append("from (select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,");
		buffer.append("warehouseid as warehouseid, GoodsBarcode ");
		buffer.append("from (select ROW_NUMBER() Over(order by GoodsId) as num , ");
		buffer.append("GoodsId,GoodsQuantity,warehouseid,GoodsBarcode ");
		buffer.append("from (select C_SH_SB_GoodsId as GoodsId , C_SH_SB_GoodsQuantity as GoodsQuantity , ");
		buffer.append("C_SH_SB_GoodsBarCode as GoodsBarcode , ");
		buffer.append("C_SH_SB_StockId as warehouseid from C_SH_StorageBeginning ");
		buffer.append("where 1=1 and C_SH_SB_StockId = ? ");
		buffer.append("union all select C_SH_SC_GoodsId as GoodsId , C_SH_SC_GoodsQuantity as GoodsQuantity , ");
		buffer.append("C_SH_SC_GoodsBarCode as GoodsBarcode , ");
		buffer.append("C_SH_SC_StockId as warehouseid from C_SH_StorageChange where 1=1 and C_SH_SC_StockId = ? )a )b ");
		buffer.append("group by GoodsId,warehouseid ,GoodsBarcode )c ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID=c.GoodsId ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID=B_Supplier.B_SP_ID ");
		buffer.append("inner join B_Brand on B_GI_BrandID=B_BD_ID 	");
		buffer.append("and B_GI_SupplierID=B_BD_SupplierID where GoodsBarcode = ? ");
		
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgigoodsbarcode());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 根据条码查询商品
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectGoodsByGoodsbarcode(GoodsInfoPo goodsInfoPo,
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
		buffer.append("B_GI_CostPrice as bgicostprice , B_GI_NotTaxRate as bginottaxrate , ");
		buffer.append("B_GI_Color as bgicolor ");
		buffer.append("from ");
		buffer.append("(select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid, GoodsBarcode from ");
		buffer.append("(select ROW_NUMBER() Over(order by GoodsId) as num , ");
		buffer.append("GoodsId,GoodsQuantity,warehouseid, GoodsBarcode from ");
		buffer.append("(select C_SH_SB_GoodsId as GoodsId , ");
		buffer.append("C_SH_SB_GoodsQuantity as GoodsQuantity , ");
		buffer.append("C_SH_SB_GoodsBarCode as GoodsBarcode ,");
		buffer.append("C_SH_SB_StockId as warehouseid ");
		buffer.append("from C_SH_StorageBeginning where 1=1 ");
		buffer.append("and C_SH_SB_StockId = ? ");
		buffer.append("union all ");
		buffer.append("select C_SH_SC_GoodsId as GoodsId , ");
		buffer.append("C_SH_SC_GoodsQuantity as GoodsQuantity , ");
		buffer.append("C_SH_SC_GoodsBarCode as GoodsBarcode , ");
		buffer.append("C_SH_SC_StockId as warehouseid ");
		buffer.append("from C_SH_StorageChange where 1=1 ");
		buffer.append("and C_SH_SC_StockId = ? ");
		buffer.append(")a )b group by GoodsId,warehouseid , GoodsBarcode)c ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID=c.GoodsId ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID=B_Supplier.B_SP_ID ");
		buffer.append("inner join B_Brand on B_GI_BrandID=B_BD_ID 	and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("where GoodsBarcode = ? ");
		
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgiwarehouseid());
		params.add(goodsInfoPo.getBgigoodsbarcode());
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , GoodsInfoPo.class);
	}

}
