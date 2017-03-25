package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.freehep.graphicsio.swf.SWFAction.Add;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.dao.BillKeyDao;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class BillKeyDaoImpl extends BaseJdbcDaoSupport implements BillKeyDao {

	public void deleteBill(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("DELETE FROM SYS_BillKey ");
		buffer.append("WHERE S_K_BillKey = ?");

		params.add(id);

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int selectBill(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*)");
		buffer.append(" from SYS_BillKey where S_K_BillKey = ? ");
		
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public void insertBill(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" insert into SYS_BillKey ");
		buffer.append(" (S_K_BillKey) ");
		buffer.append(" values ");
		buffer.append(" (?) ");
		
		params.add(id);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断业务单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectInventoryForAuditType(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*)");
		buffer.append(" from C_ST_Inventory ");
		buffer.append(" where C_ST_I_AuditState = '1' ");
		buffer.append("   and C_ST_I_BillID = ? ");
		
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断采购订单是否重复收货  1、已收货 0、未收货
	 * @param id
	 * @return
	 */
	public int selectProcurementOrderForType(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*)");
		buffer.append(" from C_ST_Po ");
		buffer.append(" where C_ST_P_Flag = '1' ");
		buffer.append("   and C_ST_P_ID = ? ");
		
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断在途状态是否存在
	 * @param id
	 * @return
	 */
	public int selectProcurementOrderForType(String intransit,String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(S_SE_IT_ID)");
		buffer.append(" from S_SE_InTransit ");
		buffer.append(" where S_SE_IT_State = ? ");
		buffer.append("   and S_SE_IT_SalesID = ? ");
		
		params.add(intransit);
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断领用单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectTakeInventoryForAuditType(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*)");
		buffer.append(" from C_ST_TakeInventory ");
		buffer.append(" where C_ST_I_AuditState = '1' ");
		buffer.append("   and C_ST_I_BillID = ? ");
		
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断批发单据是否被审核  1、审核 0、未审核
	 * @param id
	 * @return
	 */
	public int selectTracForAuditType(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*)");
		buffer.append(" from M_Trac ");
		buffer.append(" where M_T_AuditState = '1' ");
		buffer.append("   and M_T_BillID = ? ");
		
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断是否存在同类型的未处理的盈亏单
	 * @param id
	 * @return
	 */
	public int selectSCIorSCOForAuditType(String id, String categoryid, String stockid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*)");
		buffer.append(" from C_ST_Inventory ");
		buffer.append(" where C_ST_I_AuditState <> '1' ");
		buffer.append("   and C_ST_I_BillID like '%'+?+'%' ");
		
		if(categoryid.length() > 1){
			buffer.append("   and C_ST_I_GoodsCategory = (select top 1 C_ST_I_GoodsCategory from C_ST_Inventory where C_ST_I_BillID = ?) ");
		}else{
			buffer.append("   and C_ST_I_GoodsCategory = ? ");
		}
		
		params.add(id);
		params.add(categoryid);
		
		if(id.endsWith("SCI")){
			buffer.append("   and C_ST_I_InStockId = ? ");
			params.add(stockid);
		}else if(id.endsWith("SCO")){
			buffer.append("   and C_ST_I_OutStockId = ? ");
			params.add(stockid);
		}
		
		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断配镜单是否做过委外订单
	 * @param id
	 * @return
	 */
	public int selectOrdersForSalesBill(String id) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(C_ST_CPOD_Id) from C_ST_ConsignProcessOrderDetails where C_ST_CPOD_GlassesBillID = ? ");
	
		params.add(id);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断调拨单是否已配送
	 * @param id
	 * @return
	 */
	public int selectAllocationIsSend(String billid) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(*) ");
		buffer.append(" from C_SHA_Allocation ");
		buffer.append(" where C_SHA_A_billID = ? ");
		buffer.append("   and isnull(C_SHA_A_SendBillId,'') <> '' ");
		
		params.add(billid);
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 委外收货后判断配送库存
	 * @param po
	 * @return
	 */
	public int selectConsignProcessIsSend(SalesDetailPo po) {				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("IF EXISTS (SELECT * ");
		buffer.append("           FROM   tempdb.dbo.sysobjects ");
		buffer.append("           WHERE  id = Object_id(N'tempdb..#stocktmp') ");
		buffer.append("                  AND TYPE = 'U') ");
		buffer.append("  DROP TABLE #stocktmp");

		buffer.append(" ");
		buffer.append("SELECT * ");
		buffer.append("INTO   #stocktmp ");
		buffer.append("FROM   dbo.Strtotable(?)");

		buffer.append(" ");
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   (SELECT S_SE_SD_SalesItemID 				AS goodsid, ");
		buffer.append("               cprd.C_ST_CPRD_InStockId 			AS stockid, ");
		buffer.append("               isnull(SUM(S_SE_SD_Number),0) 	AS xnum ");
		buffer.append("        FROM   S_SE_SalesDetail ");
		buffer.append("               INNER JOIN #stocktmp ");
		buffer.append("                 ON S_SE_SD_SalesID = #stocktmp.str2table ");
		buffer.append("               INNER JOIN C_ST_ConsignProcessOrderDetails ");
		buffer.append("                 ON C_ST_CPOD_SalesID = S_SE_SD_ID ");
		buffer.append("               INNER JOIN (SELECT C_ST_CPRD_OrderDetailsID, ");
		buffer.append("                       C_ST_CPRD_InStockId ");
		buffer.append("                FROM   C_ST_ConsignProcessReceiptDetails ");
		buffer.append("                 GROUP  BY C_ST_CPRD_OrderDetailsID, ");
		buffer.append("                          C_ST_CPRD_InStockId) cprd ");
		buffer.append("                 ON cprd.C_ST_CPRD_OrderDetailsID = C_ST_CPOD_Id ");
		buffer.append("        GROUP  BY S_SE_SD_SalesItemID, ");
		buffer.append("                  cprd.C_ST_CPRD_InStockId)TEMP ");
		buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsId            				AS goodsid, ");
		buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
		buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
		buffer.append("                  FROM   C_SH_StorageLog_YX ");
		buffer.append("                  GROUP  BY C_SH_SL_GoodsId, ");
		buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		buffer.append("         ON TEMP.goodsid = TEMP1.goodsid ");
		buffer.append("            AND TEMP.stockid = TEMP1.stockid ");
		buffer.append("		   LEFT JOIN (SELECT C_SH_TSE_GoodsID 						AS goodsid, ");
		buffer.append("		   					 C_SH_TSE_OutStockID 					AS stockid, ");
		buffer.append("		   					 Isnull(SUM(C_SH_TSE_GoodsNum), 0) 		AS znum ");
		buffer.append("		   			  FROM   dbo.C_SH_InTransitStorageEntry ");
		buffer.append("		   			  GROUP BY C_SH_TSE_GoodsID,");
		buffer.append("		   			   		   C_SH_TSE_OutStockID)TEMP2");
		buffer.append("         ON TEMP.goodsid = TEMP2.goodsid ");
		buffer.append("            AND TEMP.stockid = TEMP2.stockid ");
		
		buffer.append("Where isnull(TEMP.xnum,0) > (isnull(TEMP1.snum,0) + isnull(TEMP2.znum,0)) ");
		
		params.add(Utility.getName(po.getSsesdsalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 取镜处取镜(按销售单号获取商品信息)
	 * @param po
	 * @return
	 */
	public List<SalesDetailPo> selectTakeGlassListForSalesID(SalesDetailPo po) {				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("IF EXISTS (SELECT * ");
		buffer.append("           FROM   tempdb.dbo.sysobjects ");
		buffer.append("           WHERE  id = Object_id(N'tempdb..#stocktmp') ");
		buffer.append("                  AND TYPE = 'U') ");
		buffer.append("  DROP TABLE #stocktmp");

		buffer.append(" ");
		buffer.append("SELECT * ");
		buffer.append("INTO   #stocktmp ");
		buffer.append("FROM   dbo.Strtotable(?)");

		params.add(Utility.getName(po.getSsesdsalesid()));
		
		buffer.append(" ");
		buffer.append("SELECT * ");
		buffer.append("FROM   (SELECT S_SE_SD_ItemId            AS ssesditemid, ");
		buffer.append("				  ?            				AS ssesdsalesid ");
		buffer.append("        FROM   S_SE_SalesDetail ");
		buffer.append("               INNER JOIN #stocktmp ");
		buffer.append("                 ON S_SE_SD_SalesID = #stocktmp.str2table ");
		buffer.append("               INNER JOIN S_SE_SalesBasic ");
		buffer.append("                 ON S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("        WHERE  S_SE_SB_OrdersType NOT IN( '1', '2' ) ");
		buffer.append("          AND  S_SE_SD_OutStorageFlag <> '1' ");
		buffer.append("        GROUP  BY S_SE_SD_ItemId)TEMP ");
		
		params.add(Utility.getName(po.getSsesdsalesid()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), SalesDetailPo.class);
	}
	
	/**
	 * 取镜处判断库存
	 * @param po
	 * @return
	 */
	public int selectTakeGlassIsSend(SalesDetailPo po) {				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("IF EXISTS (SELECT * ");
		buffer.append("           FROM   tempdb.dbo.sysobjects ");
		buffer.append("           WHERE  id = Object_id(N'tempdb..#stocktmp') ");
		buffer.append("                  AND TYPE = 'U') ");
		buffer.append("  DROP TABLE #stocktmp");

		buffer.append(" ");
		buffer.append("SELECT * ");
		buffer.append("INTO   #stocktmp ");
		buffer.append("FROM   dbo.Strtotable(?)");
		
		params.add(Utility.getName(po.getSsesdsalesid()));

		buffer.append(" ");
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   (SELECT S_SE_SD_ItemID 					AS goodsid, ");
		buffer.append("           	  S_SE_SD_StockId 					AS stockid, ");
		buffer.append("               isnull(SUM(S_SE_SD_Number),0) 	AS xnum ");
		buffer.append("        FROM   S_SE_SalesDetail ");
		buffer.append("               INNER JOIN #stocktmp ");
		buffer.append("                 ON S_SE_SD_SalesID = #stocktmp.str2table ");
		buffer.append("        WHERE  S_SE_SD_ItemID = ? ");
		buffer.append("        GROUP  BY S_SE_SD_ItemID, ");
		buffer.append("                  S_SE_SD_StockId ");
		buffer.append("       )TEMP ");
		if("1".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_JJ ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("2".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_PJ ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("3".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_JP ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("4".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_YX ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("5".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_HLY ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("6".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_TYJ ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("7".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_HC ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("8".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_LHJ ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		if("9".equals(Utility.getName(po.getSsesditemid()).substring(0, 1))){
			buffer.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode            		AS goodsid, ");
			buffer.append("                         C_SH_SL_StockId            				AS stockid, ");
			buffer.append("                         isnull(SUM(C_SH_SL_GoodsQuantity),0) 	AS snum ");
			buffer.append("                  FROM   C_SH_StorageLog_SG ");
			buffer.append("        			 WHERE  C_SH_SL_GoodsBarCode = ? ");
			buffer.append("                  GROUP  BY C_SH_SL_GoodsBarCode, ");
			buffer.append("                            C_SH_SL_StockId)TEMP1 ");
		}
		buffer.append("         ON TEMP.goodsid = TEMP1.goodsid ");
		buffer.append("            AND TEMP.stockid = TEMP1.stockid ");
		buffer.append("		   LEFT JOIN (SELECT C_SH_TSE_GoodsBarCode 					AS goodsid, ");
		buffer.append("		   					 C_SH_TSE_OutStockID 					AS stockid, ");
		buffer.append("		   					 Isnull(SUM(C_SH_TSE_GoodsNum), 0) 		AS znum ");
		buffer.append("		   			  FROM   dbo.C_SH_InTransitStorageEntry ");
		buffer.append("        			 WHERE  C_SH_TSE_GoodsBarCode = ? ");
		buffer.append("		   			  GROUP BY C_SH_TSE_GoodsBarCode,");
		buffer.append("		   			   		   C_SH_TSE_OutStockID)TEMP2");
		buffer.append("         ON TEMP.goodsid = TEMP2.goodsid ");
		buffer.append("            AND TEMP.stockid = TEMP2.stockid ");
		
		buffer.append("Where isnull(TEMP.xnum,0) > (isnull(TEMP1.snum,0) + isnull(TEMP2.znum,0)) ");
		
		params.add(Utility.getName(po.getSsesditemid()));
		params.add(Utility.getName(po.getSsesditemid()));
		params.add(Utility.getName(po.getSsesditemid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
}
