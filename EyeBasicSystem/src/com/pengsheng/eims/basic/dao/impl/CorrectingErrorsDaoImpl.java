package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.CorrectingErrorsDao;
import com.pengsheng.eims.basic.persistence.CorrectingErrorsPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CorrectingErrorsDaoImpl extends BaseJdbcDaoSupport implements CorrectingErrorsDao {

	/**
	 * 获取库存差异查询总数
	 */
	public int getInventoryDifferenceCount(CorrectingErrorsPo po){		
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(B_GI_GoodsID) from ( ");
		buffer.append("select B_GI_GoodsID,B_GI_GoodsName,B_BD_brandName, ");
		buffer.append("       isnull(goodsnumlog,0) as C_SH_SL_GoodsQuantity,isnull(goodsnumchange,0) as C_SH_SC_GoodsQuantity,isnull(B_WH_warehouseName,'') as cerrstockname ");
		buffer.append("  from B_GoodsInfo  ");
		buffer.append("	  left join ( ");
		
		buffer.append("			select goodsID as goodsID,isnull(sum(goodsnumlog),0) as goodsnumlog,isnull(sum(goodsnumchange),0) as goodsnumchange,stockID as stockID from ( ");
		buffer.append("			select C_SH_SL_GoodsId as goodsID,isnull(sum(C_SH_SL_GoodsQuantity),0) as goodsnumlog,0 as goodsnumchange,C_SH_SL_StockId as stockID from C_SH_StorageLog ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append("			  where C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}		
		buffer.append("			  group by C_SH_SL_GoodsId,C_SH_SL_StockId ");
		buffer.append("	union all ");
		buffer.append("            select goodsID as goodsID,0 as goodsnumlog,isnull(sum(goodsnumchange),0) as goodsnumchange,stockID as stockID from ( ");
		buffer.append("				select C_SH_SC_GoodsId as goodsID,sum(C_SH_SC_GoodsQuantity) as goodsnumchange,C_SH_SC_StockId as stockID from C_SH_StorageChange ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append("			  where C_SH_SC_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}	
		buffer.append("				  group by C_SH_SC_GoodsId,C_SH_SC_StockId ");
		buffer.append("				union all ");
		buffer.append("				select C_SH_SB_GoodsId as goodsID,sum(C_SH_SB_GoodsQuantity) as goodsnumchange,C_SH_SB_StockId as stockID from C_SH_StorageBeginning ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append("			  where C_SH_SB_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("				  group by C_SH_SB_GoodsId,C_SH_SB_StockId ");
		buffer.append("            )temp ");
		buffer.append("            group by goodsID,stockID ");
		
		buffer.append("            )temp ");
		buffer.append("            group by goodsID,stockID ");		
		
		buffer.append("	  )logtab on B_GI_GoodsID=logtab.goodsID ");	
		buffer.append("      inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("      inner join B_Warehouse on B_WH_ID=stockID ");
		buffer.append("  where B_GI_SupplierID<>'ZZ' ");

		if ("2".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and (isnull(goodsnumlog,0)<>0 or isnull(goodsnumchange,0)<>0) ");
		}
		if ("3".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and (isnull(goodsnumlog,0)-isnull(goodsnumchange,0))<>0 ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrgoodsid()))) {
			buffer.append(" and B_GI_GoodsID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsname()))) {
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCerrsupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ?  ");
			params.add(Utility.getName(po.getCerrsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbrandid()))) {
			buffer.append(" and B_GI_BrandID = ?  ");
			params.add(Utility.getName(po.getCerrbrandid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID = ?  ");
			params.add(Utility.getName(po.getCerrgoodscategoryid()));
		}
		
		buffer.append(" ) table1 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取库存差异查询列表
	 */
	public List<CorrectingErrorsPo> getInventoryDifferenceList(CorrectingErrorsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by B_GI_GoodsID) as 'rowNum', ");
		buffer.append(" B_GI_GoodsID as cerrgoodsid,B_GI_GoodsName as cerrgoodsname,B_BD_brandName as cerrbrandname, ");
		buffer.append("       isnull(goodsnumlog,0) as cerrlognum,isnull(goodsnumchange,0) as cerrchangenum,isnull(B_WH_warehouseName,'') as cerrstockname,stockID as cerrstockid ");
		buffer.append("  from B_GoodsInfo  ");
		buffer.append("	  left join ( ");
		
		buffer.append("			select goodsID as goodsID,isnull(sum(goodsnumlog),0) as goodsnumlog,isnull(sum(goodsnumchange),0) as goodsnumchange,stockID as stockID from ( ");
		buffer.append("			select C_SH_SL_GoodsId as goodsID,isnull(sum(C_SH_SL_GoodsQuantity),0) as goodsnumlog,0 as goodsnumchange,C_SH_SL_StockId as stockID from C_SH_StorageLog ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append("			  where C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}		
		buffer.append("			  group by C_SH_SL_GoodsId,C_SH_SL_StockId ");
		buffer.append("	union all ");
		buffer.append("            select goodsID as goodsID,0 as goodsnumlog,isnull(sum(goodsnumchange),0) as goodsnumchange,stockID as stockID from ( ");
		buffer.append("				select C_SH_SC_GoodsId as goodsID,sum(C_SH_SC_GoodsQuantity) as goodsnumchange,C_SH_SC_StockId as stockID from C_SH_StorageChange ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append("			  where C_SH_SC_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}	
		buffer.append("				  group by C_SH_SC_GoodsId,C_SH_SC_StockId ");
		buffer.append("				union all ");
		buffer.append("				select C_SH_SB_GoodsId as goodsID,sum(C_SH_SB_GoodsQuantity) as goodsnumchange,C_SH_SB_StockId as stockID from C_SH_StorageBeginning ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append("			  where C_SH_SB_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("				  group by C_SH_SB_GoodsId,C_SH_SB_StockId ");
		buffer.append("            )temp ");
		buffer.append("            group by goodsID,stockID ");
		
		buffer.append("            )temp ");
		buffer.append("            group by goodsID,stockID ");		
		
		buffer.append("	  )logtab on B_GI_GoodsID=logtab.goodsID ");
		buffer.append("      inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("      inner join B_Warehouse on B_WH_ID=stockID ");
		buffer.append("  where B_GI_SupplierID<>'ZZ' ");

		if ("2".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and (isnull(goodsnumlog,0)<>0 or isnull(goodsnumchange,0)<>0) ");
		}
		if ("3".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and (isnull(goodsnumlog,0)-isnull(goodsnumchange,0))<>0 ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrgoodsid()))) {
			buffer.append(" and B_GI_GoodsID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsname()))) {
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCerrsupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ?  ");
			params.add(Utility.getName(po.getCerrsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbrandid()))) {
			buffer.append(" and B_GI_BrandID = ?  ");
			params.add(Utility.getName(po.getCerrbrandid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID = ?  ");
			params.add(Utility.getName(po.getCerrgoodscategoryid()));
		}
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), CorrectingErrorsPo.class);
	}
	
	/**
	 * 获取单据数量与库存的
	 */
	public List<InventoryEntryPo> getInventoryDifferenceBillEntryDetail(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

        buffer.append(" select cstiebarcode as cstiebarcode,cstiegoodsid as cstiegoodsid,convert(varchar(10),cstiewarehousingdate,120) as cstiewarehousingdate,isnull(B_GI_GoodsName,'') as cstiegoodsname,isnull(B_WH_warehouseName,'') as cstieinstockid,cstiebillid as cstiebillid,sum(cstiegoodsquantity) as cstiegoodsquantity,sum(cstieprovisionalnum) as cstieprovisionalnum  ");
        buffer.append("    from ( ");
        buffer.append(" select C_SH_SL_GoodsBarCode as cstiebarcode,C_SH_SL_GoodsId as cstiegoodsid,C_SH_SL_WarehousingDate as cstiewarehousingdate,C_SH_SL_StockId as cstieinstockid,C_SH_SL_ChangeID as cstiebillid,C_SH_SL_GoodsQuantity as cstiegoodsquantity,0 as cstieprovisionalnum  ");
        buffer.append("   from C_SH_StorageLog where C_SH_SL_ChangeID = ?  ");
        buffer.append(" union all ");
        buffer.append(" select C_ST_IE_BarCode as cstiebarcode,C_ST_IE_GoodsId as cstiegoodsid,C_ST_I_AuditDate as cstiewarehousingdate,C_ST_IE_InStockId as cstieinstockid,C_ST_IE_BillID as cstiebillid,0 as cstiegoodsquantity,C_ST_IE_GoodsQuantity as cstieprovisionalnum ");
        buffer.append("   from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID where C_ST_IE_BillID = ? and C_ST_I_BillTypeId in ('1','4','5','7') ");
        buffer.append(" union all ");
        buffer.append(" select C_ST_IE_BarCode as cstiebarcode,C_ST_IE_GoodsId as cstiegoodsid,C_ST_I_AuditDate as cstiewarehousingdate,C_ST_IE_OutStockId as cstieinstockid,C_ST_IE_BillID as cstiebillid,0 as cstiegoodsquantity,-C_ST_IE_GoodsQuantity as cstieprovisionalnum ");
        buffer.append("   from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID where C_ST_IE_BillID = ? and C_ST_I_BillTypeId in ('2','3','6','8') ");
        buffer.append(" union all ");
        buffer.append(" select C_ST_CPRD_BarCode as cstiebarcode,C_ST_CPRD_GoodsID as cstiegoodsid,C_ST_CPR_AuditDate as cstiewarehousingdate,C_ST_CPRD_InStockId as cstieinstockid,C_ST_CPRD_ReceiptBillD as cstiebillid,0 as cstiegoodsquantity,C_ST_CPRD_Num as cstieprovisionalnum ");
        buffer.append("   from C_ST_ConsignProcessReceipt inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD where C_ST_CPRD_ReceiptBillD = ? ");
        buffer.append(" union all ");
        buffer.append(" select S_SE_SD_ItemID as cstiebarcode,S_SE_SD_SalesItemID as cstiegoodsid,S_SE_SB_PosDatetime as cstiewarehousingdate,S_SE_SD_StockId as cstieinstockid,S_SE_SD_SalesID as cstiebillid,0 as cstiegoodsquantity,-S_SE_SD_Number as cstieprovisionalnum ");
        buffer.append("   from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID=S_SE_SD_SalesID where S_SE_SD_SalesID = ? and S_SE_SB_ValueFlag='1' ");
        buffer.append(" union all ");
        buffer.append(" select S_SE_SD_ItemID as cstiebarcode,S_SE_SD_SalesItemID as cstiegoodsid,S_SE_SD_WithdrawDate as cstiewarehousingdate,S_SE_SD_InStockId as cstieinstockid,S_SE_SD_SalesID as cstiebillid,0 as cstiegoodsquantity,S_SE_SD_Number as cstieprovisionalnum ");
        buffer.append("   from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID=S_SE_SD_SalesID where S_SE_SD_SalesID = ? and S_SE_SB_ValueFlag='1' and S_SE_SB_WithdrawFlag='1' ");
        buffer.append(" union all ");
        buffer.append(" select C_ST_IE_BarCode as cstiebarcode,C_ST_IE_GoodsId as cstiegoodsid,C_ST_I_AuditDate as cstiewarehousingdate,C_ST_IE_OutStockId as cstieinstockid,C_ST_IE_BillID as cstiebillid,0 as cstiegoodsquantity,-C_ST_IE_GoodsQuantity as cstieprovisionalnum ");
        buffer.append("   from C_ST_TakeInventory inner join C_ST_TakeInventoryEntry on C_ST_I_BillID=C_ST_IE_BillID where C_ST_IE_BillID = ? ");
        buffer.append(" union all ");
        buffer.append(" select F_ILE_GoodsCode as cstiebarcode,F_ILE_GoodsID as cstiegoodsid,F_IL_Datetime as cstiewarehousingdate,F_ILE_OutStockID as cstieinstockid,F_ILE_UUID as cstiebillid,0 as cstiegoodsquantity,-F_ILE_GoodsNumber as cstieprovisionalnum ");
        buffer.append("   from F_IntegralExchangeLog inner join F_IntegralExchangeLogEntry on F_IL_UUID=F_ILE_UUID where F_ILE_UUID = ? ");
        buffer.append(" union all ");
        buffer.append(" select M_TE_BarCode as cstiebarcode,M_TE_GoodsId as cstiegoodsid,M_T_AuditDate as cstiewarehousingdate,M_TE_InStockId as cstieinstockid,M_TE_BillID as cstiebillid,0 as cstiegoodsquantity,M_TE_GoodsQuantity as cstieprovisionalnum ");
        buffer.append("   from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID where M_TE_BillID = ? and M_T_BillTypeId='2' ");
        buffer.append(" union all ");
        buffer.append(" select M_TE_BarCode as cstiebarcode,M_TE_GoodsId as cstiegoodsid,M_T_AuditDate as cstiewarehousingdate,M_TE_OutStockId as cstieinstockid,M_TE_BillID as cstiebillid,0 as cstiegoodsquantity,-M_TE_GoodsQuantity as cstieprovisionalnum ");
        buffer.append("   from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID where M_TE_BillID = ? and M_T_BillTypeId='3' ");
        buffer.append(" )temp left join B_GoodsInfo on cstiegoodsid=B_GI_GoodsID left join B_Warehouse on cstieinstockid=B_WH_ID ");
        buffer.append("   group by cstiebarcode,cstiegoodsid,convert(varchar(10),cstiewarehousingdate,120),isnull(B_GI_GoodsName,''),isnull(B_WH_warehouseName,''),cstiebillid ");
        buffer.append("   having sum(cstiegoodsquantity)<>sum(cstieprovisionalnum) ");

		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrchangeid()));

		return queryForObjectList(buffer.toString(), params.toArray(), InventoryEntryPo.class);
	}
	
	/**
	 * 获取错误条码总数
	 */
	public int getErrorsGoodsBarCodeCount(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(cerrgoodsbarcode) from (");
		buffer.append("select cerrgoodsbarcode,cerrgoodsid,cerrchangeid,cerrdate,cerrlognum,cerrbarcodeerra,cerrbarcodeerrb,cerrbarcodeerrc,cerrbarcodeerrd,cerrbarcodeerre,cerrstockid,B_WH_warehouseName as cerrstockname from ( ");
		buffer.append("select C_SH_SL_GoodsBarCode as cerrgoodsbarcode,C_SH_SL_GoodsId as cerrgoodsid,C_SH_SL_ChangeID as cerrchangeid, ");
		buffer.append("       convert(varchar(16),C_SH_SL_WarehousingDate,120) as cerrdate,sum(C_SH_SL_GoodsQuantity) as cerrlognum,C_SH_SL_StockId as cerrstockid, ");
		buffer.append("       sum(a1) as cerrbarcodeerra, ");
		buffer.append("       sum(a2) as cerrbarcodeerrb, ");
		buffer.append("       sum(a3) as cerrbarcodeerrc, ");
		buffer.append("       sum(a4) as cerrbarcodeerrd, ");
		buffer.append("       sum(a5) as cerrbarcodeerre  ");
		buffer.append("  from ( ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,1 as a1,0 as a2,0 as a3,0 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where left(C_SH_SL_GoodsBarCode,18)<>replace(C_SH_SL_GoodsId,'.','') ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,1 as a2,0 as a3,0 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where len(C_SH_SL_GoodsBarCode)<26 ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,0 as a2,1 as a3,0 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where len(C_SH_SL_GoodsBarCode)>26 ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union  ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,0 as a2,0 as a3,1 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where isnull(C_SH_SL_GoodsBarCode,'')='' ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union  ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,0 as a2,0 as a3,0 as a4,1 as a5  ");
		buffer.append("  from C_SH_StorageLog where patindex('%[^a-z,A-Z,0-9]%',C_SH_SL_GoodsBarCode)>0 ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append(")temp ");
		buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_StockId ");
		
		buffer.append(" )temp left join B_GoodsInfo on cerrgoodsid = B_GI_GoodsID left join B_Warehouse on cerrstockid = B_WH_ID where B_GI_SupplierID<>'ZZ' ");
		
		if (!"".equals(Utility.getName(po.getCerrgoodsid()))) {
			buffer.append(" and B_GI_GoodsID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsname()))) {
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCerrsupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ?  ");
			params.add(Utility.getName(po.getCerrsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbrandid()))) {
			buffer.append(" and B_GI_BrandID = ?  ");
			params.add(Utility.getName(po.getCerrbrandid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID = ?  ");
			params.add(Utility.getName(po.getCerrgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsbarcode()))) {
			buffer.append(" and cerrgoodsbarcode like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsbarcode()));
		}
		
		buffer.append(") table1 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取错误条码查询列表
	 */
	public List<CorrectingErrorsPo> getErrorsGoodsBarCodeList(CorrectingErrorsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by cerrdate desc) as 'rowNum', ");
		buffer.append("cerrgoodsbarcode,cerrgoodsid,(case cerrchangeid when 'import' then '期初库存' else cerrchangeid end) as cerrchangeid,cerrdate,cerrlognum,cerrbarcodeerra,cerrbarcodeerrb,cerrbarcodeerrc,cerrbarcodeerrd,cerrbarcodeerre,cerrstockid,B_WH_warehouseName as cerrstockname from ( ");
		buffer.append("select C_SH_SL_GoodsBarCode as cerrgoodsbarcode,C_SH_SL_GoodsId as cerrgoodsid,C_SH_SL_ChangeID as cerrchangeid, ");
		buffer.append("       convert(varchar(16),C_SH_SL_WarehousingDate,120) as cerrdate,sum(C_SH_SL_GoodsQuantity) as cerrlognum,C_SH_SL_StockId as cerrstockid, ");
		buffer.append("       sum(a1) as cerrbarcodeerra, ");
		buffer.append("       sum(a2) as cerrbarcodeerrb, ");
		buffer.append("       sum(a3) as cerrbarcodeerrc, ");
		buffer.append("       sum(a4) as cerrbarcodeerrd, ");
		buffer.append("       sum(a5) as cerrbarcodeerre  ");
		buffer.append("  from ( ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,1 as a1,0 as a2,0 as a3,0 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where left(C_SH_SL_GoodsBarCode,18)<>replace(C_SH_SL_GoodsId,'.','') ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,1 as a2,0 as a3,0 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where len(C_SH_SL_GoodsBarCode)<26 ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,0 as a2,1 as a3,0 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where len(C_SH_SL_GoodsBarCode)>26 ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union  ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,0 as a2,0 as a3,1 as a4,0 as a5 ");
		buffer.append("  from C_SH_StorageLog where isnull(C_SH_SL_GoodsBarCode,'')='' ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append("union  ");
		buffer.append("select C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_GoodsQuantity,C_SH_SL_StockId,0 as a1,0 as a2,0 as a3,0 as a4,1 as a5  ");
		buffer.append("  from C_SH_StorageLog where patindex('%[^a-z,A-Z,0-9]%',C_SH_SL_GoodsBarCode)>0 ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		buffer.append(")temp ");
		buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_ChangeID,C_SH_SL_WarehousingDate,C_SH_SL_StockId ");
		
		buffer.append(" )temp left join B_GoodsInfo on cerrgoodsid = B_GI_GoodsID left join B_Warehouse on cerrstockid = B_WH_ID where B_GI_SupplierID<>'ZZ' ");
		
		if (!"".equals(Utility.getName(po.getCerrgoodsid()))) {
			buffer.append(" and B_GI_GoodsID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsname()))) {
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCerrsupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ?  ");
			params.add(Utility.getName(po.getCerrsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbrandid()))) {
			buffer.append(" and B_GI_BrandID = ?  ");
			params.add(Utility.getName(po.getCerrbrandid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID = ?  ");
			params.add(Utility.getName(po.getCerrgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsbarcode()))) {
			buffer.append(" and cerrgoodsbarcode like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsbarcode()));
		}
		
		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), CorrectingErrorsPo.class);
	}
	
	/**
	 * 获取异常单据总数
	 */
	public int getBillDifferenceCount(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(cerrchangeid) from (");	
		buffer.append("select changeid as cerrchangeid,abs(goodsnum) as cerrlognum,abs(isnull(billnum,0)) as cerrbillnum from ( ");
		buffer.append("select C_SH_SL_ChangeID as changeid, ");
		buffer.append("       isnull(sum(C_SH_SL_GoodsQuantity),0) as goodsnum,  ");
		buffer.append("       abs(isnull(sum(C_SH_SL_GoodsQuantity),0)) as  goodsnum1  ");  
		buffer.append("   from C_SH_StorageLog ");
		buffer.append("   where C_SH_SL_ChangeID<>'import' and ((C_SH_SL_ChangeID like 'X%' and C_SH_SL_GoodsQuantity < 0) or (C_SH_SL_ChangeID like 'ALL%' and C_SH_SL_GoodsQuantity > 0) or (C_SH_SL_ChangeID not like 'ALL%' and C_SH_SL_ChangeID not like 'X%') ) ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_SH_SL_ChangeID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_SH_SL_WarehousingDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_SH_SL_WarehousingDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("   group by C_SH_SL_ChangeID ");
		buffer.append(")changetab left join ( ");
		buffer.append("	select billid as billid,goodsnum as billnum,abs(goodsnum) as billnum1 from ( ");
		buffer.append("	select C_ST_IE_BillID as billid,sum(C_ST_IE_GoodsQuantity) as goodsnum ");
		buffer.append("	   from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("	   where C_ST_I_AuditState='1' and  ((C_ST_I_BillTypeId='3' and isnull(C_ST_I_GoodsCategory,'') not in ('20','25')) or C_ST_I_BillTypeId not in ('3','9'))  ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_ST_IE_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}		
		buffer.append("	   group by C_ST_IE_BillID ");
		buffer.append("	union all  ");		
		buffer.append("	select C_ST_CPRD_ReceiptBillD as billid,sum(C_ST_CPRD_Num) as goodsnum ");
		buffer.append("	   from C_ST_ConsignProcessReceipt inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD ");
		buffer.append("	   where C_ST_CPR_AuditState='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_ST_CPRD_ReceiptBillD like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_ST_CPR_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_ST_CPR_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}		
		buffer.append("	   group by C_ST_CPRD_ReceiptBillD ");		
		buffer.append("	union all  ");
		buffer.append("	select distinct S_SE_SD_SalesID as billid,S_SE_SD_Number as goodsnum from ( ");
		buffer.append("	select S_SE_SD_SalesID as S_SE_SD_SalesID,sum(S_SE_SD_Number) as S_SE_SD_Number ");
		buffer.append("	   from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID=S_SE_SD_SalesID ");
		buffer.append("	   where S_SE_SB_ValueFlag='1' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' and S_SE_SD_OutStorageFlag='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and S_SE_SD_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		buffer.append("	   group by S_SE_SD_SalesID ");
		buffer.append("	union ");
		buffer.append("	select S_SE_SD_SalesID as S_SE_SD_SalesID,sum(S_SE_SD_Number) as S_SE_SD_Number ");
		buffer.append("	   from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID=S_SE_SD_SalesID ");
		buffer.append("	   where S_SE_SB_ValueFlag='1' and S_SE_SB_WithdrawFlag='1' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' and S_SE_SD_InStorageFlag='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and S_SE_SD_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		buffer.append("	   group by S_SE_SD_SalesID ");
		buffer.append("	)temp inner join S_SE_InTransit on S_SE_SD_SalesID=S_SE_IT_SalesID where 1=1 ");
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),S_SE_IT_Date,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),S_SE_IT_Date,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}
		buffer.append("	union all ");
		buffer.append("	select C_ST_IE_BillID as billid,sum(C_ST_IE_GoodsQuantity) as goodsnum ");
		buffer.append("	   from C_ST_TakeInventory inner join C_ST_TakeInventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("	   where C_ST_I_AuditState='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_ST_IE_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("	   group by C_ST_IE_BillID ");
		buffer.append("	union all ");
		buffer.append("	select F_ILE_UUID as billid,sum(F_ILE_GoodsNumber) as goodsnum ");
		buffer.append("	   from F_IntegralExchangeLog inner join F_IntegralExchangeLogEntry on F_IL_UUID=F_ILE_UUID ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and F_ILE_UUID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),F_IL_Datetime,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),F_IL_Datetime,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("	   group by F_ILE_UUID ");
		buffer.append("	union all ");
		buffer.append("	select M_TE_BillID as billid,sum(M_TE_GoodsQuantity) as goodsnum ");
		buffer.append("	   from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		buffer.append("	   where M_T_AuditState='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and M_TE_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),M_T_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),M_T_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("	   group by M_TE_BillID ");
		buffer.append("	)temp ");
		buffer.append(")billtab on changetab.changeid=billtab.billid where 1=1 ");
		
		if ("2".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and (isnull(goodsnum1,0)<>0 or isnull(billnum1,0)<>0) and goodsnum1=billnum1 ");
		}
		if ("1".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and goodsnum1=billnum1 ");
		}
		if ("3".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and goodsnum1<>billnum1 ");
		}
		
		buffer.append(") table1 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取异常单据列表
	 */
	public List<CorrectingErrorsPo> getBillDifferenceList(CorrectingErrorsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by changeid desc) as 'rowNum',");	
		buffer.append("changeid as cerrchangeid,goodsnum as cerrlognum,isnull(billnum,0) as cerrbillnum from ( ");
		buffer.append("select C_SH_SL_ChangeID as changeid, ");
		buffer.append("       isnull(sum(C_SH_SL_GoodsQuantity),0) as goodsnum,  ");
		buffer.append("       abs(isnull(sum(C_SH_SL_GoodsQuantity),0)) as  goodsnum1   ");
		buffer.append("   from C_SH_StorageLog ");
		buffer.append("   where C_SH_SL_ChangeID<>'import' and ((C_SH_SL_ChangeID like 'X%' and C_SH_SL_GoodsQuantity < 0) or (C_SH_SL_ChangeID like 'ALL%' and C_SH_SL_GoodsQuantity > 0) or (C_SH_SL_ChangeID not like 'ALL%' and C_SH_SL_ChangeID not like 'X%' ) ) ");
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_SH_SL_ChangeID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_SH_SL_WarehousingDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_SH_SL_WarehousingDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}		
		buffer.append("   group by C_SH_SL_ChangeID ");
		buffer.append(")changetab left join ( ");
		buffer.append("	select billid as billid,goodsnum as billnum,abs(goodsnum) as billnum1 from ( ");
		buffer.append("	select C_ST_IE_BillID as billid,(case C_ST_I_BillTypeId when '1' then sum(C_ST_IE_GoodsQuantity) when '4' then sum(C_ST_IE_GoodsQuantity)  when '5' then sum(C_ST_IE_GoodsQuantity) when '7' then sum(C_ST_IE_GoodsQuantity) else -sum(C_ST_IE_GoodsQuantity) end) as goodsnum ");
		buffer.append("	   from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("	   where C_ST_I_AuditState='1' and  ((C_ST_I_BillTypeId='3' and isnull(C_ST_I_GoodsCategory,'') not in ('20','25')) or C_ST_I_BillTypeId not in ('3','9'))  ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_ST_IE_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}		
		buffer.append("	   group by C_ST_IE_BillID,C_ST_I_BillTypeId ");
		buffer.append("	union all  ");
		buffer.append("	select C_ST_CPRD_ReceiptBillD as billid,sum(C_ST_CPRD_Num) as goodsnum ");
		buffer.append("	   from C_ST_ConsignProcessReceipt inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD ");
		buffer.append("	   where C_ST_CPR_AuditState='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_ST_CPRD_ReceiptBillD like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_ST_CPR_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_ST_CPR_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}		
		buffer.append("	   group by C_ST_CPRD_ReceiptBillD ");		
		buffer.append("	union all  ");
		buffer.append("	select distinct S_SE_SD_SalesID as billid,S_SE_SD_Number as goodsnum from ( ");
		buffer.append("	select S_SE_SD_SalesID as S_SE_SD_SalesID,sum(S_SE_SD_Number) as S_SE_SD_Number ");
		buffer.append("	   from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID=S_SE_SD_SalesID ");
		buffer.append("	   where S_SE_SB_ValueFlag='1' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' and S_SE_SD_OutStorageFlag='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and S_SE_SD_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		buffer.append("	   group by S_SE_SD_SalesID ");
		buffer.append("	union ");
		buffer.append("	select S_SE_SD_SalesID as S_SE_SD_SalesID,-sum(S_SE_SD_Number) as S_SE_SD_Number ");
		buffer.append("	   from S_SE_SalesBasic inner join S_SE_SalesDetail on S_SE_SB_SalesID=S_SE_SD_SalesID ");
		buffer.append("	   where S_SE_SB_ValueFlag='1' and S_SE_SB_WithdrawFlag='1' and substring(S_SE_SD_SalesItemID,3,2)<>'ZZ' and S_SE_SD_InStorageFlag='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and S_SE_SD_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		buffer.append("	   group by S_SE_SD_SalesID ");
		buffer.append("	)temp inner join S_SE_InTransit on S_SE_SD_SalesID=S_SE_IT_SalesID where 1=1 ");
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),S_SE_IT_Date,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),S_SE_IT_Date,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}
		buffer.append("	union all ");
		buffer.append("	select C_ST_IE_BillID as billid,-sum(C_ST_IE_GoodsQuantity) as goodsnum ");
		buffer.append("	   from C_ST_TakeInventory inner join C_ST_TakeInventoryEntry on C_ST_I_BillID=C_ST_IE_BillID ");
		buffer.append("	   where C_ST_I_AuditState='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_ST_IE_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),C_ST_I_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("	   group by C_ST_IE_BillID ");
		buffer.append("	union all ");
		buffer.append("	select F_ILE_UUID as billid,-sum(F_ILE_GoodsNumber) as goodsnum ");
		buffer.append("	   from F_IntegralExchangeLog inner join F_IntegralExchangeLogEntry on F_IL_UUID=F_ILE_UUID ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and F_ILE_UUID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),F_IL_Datetime,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),F_IL_Datetime,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("	   group by F_ILE_UUID ");
		buffer.append("	union all ");
		buffer.append("	select M_TE_BillID as billid,(case M_T_BillTypeId when '2' then sum(M_TE_GoodsQuantity) else -sum(M_TE_GoodsQuantity) end) as goodsnum ");
		buffer.append("	   from M_Trac inner join M_TracEntry on M_T_BillID=M_TE_BillID ");
		buffer.append("	   where M_T_AuditState='1' ");
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and M_TE_BillID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),M_T_AuditDate,120)>=? ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),M_T_AuditDate,120)<=? ");
			params.add(Utility.getName(po.getCerrenddate()));
		}	
		buffer.append("	   group by M_TE_BillID,M_T_BillTypeId ");
		buffer.append("	)temp ");
		buffer.append(")billtab on changetab.changeid=billtab.billid ");
		buffer.append("	where 1=1 ");
		if ("2".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and (isnull(goodsnum1,0)<>0 or isnull(billnum1,0)<>0) and goodsnum1=billnum1 ");
		}
		if ("1".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and goodsnum1=billnum1 ");
		}
		if ("3".equals(Utility.getName(po.getCerrinventorytype()))) {
			buffer.append(" and goodsnum1<>billnum1 ");
		}
		
		buffer.append(" ) table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), CorrectingErrorsPo.class);
	}
		
	/**
	 * 获取在途库存商品总数
	 */
	public int getGoodsTransitStorageCount(CorrectingErrorsPo po,PersonInfoPo personInfoPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(cerrgoodsid) from ( ");
		buffer.append("select cerrgoodsid,cerrgoodsname,cerrlognum,cerrgoodsbarcode,cerrbrandname,cerrstockname,cerrchangeid,cerroutstockname from ( ");
		buffer.append("select C_SH_TSE_GoodsID as cerrgoodsid,B_GI_GoodsName as cerrgoodsname,C_SH_TSE_GoodsBarCode as cerrgoodsbarcode,B_BD_brandName as cerrbrandname, ");
		buffer.append("       isnull(b.B_WH_warehouseName,'') as cerroutstockname, ");
		buffer.append("       (case C_SH_TSE_InOrOutStock when '1' then ('由【' + isnull(a.B_WH_warehouseName,'')+'】调至') else (case isnull(a.B_WH_warehouseName,'') when '' then '' else ('调至【' + isnull(a.B_WH_warehouseName,'')+'】') end) end) as cerrstockname, ");
		buffer.append("       sum(C_SH_TSE_GoodsNum) as cerrlognum,C_SH_TSE_BillID as cerrchangeid,C_SH_TSE_InOrOutStock as inOrOutStock ");
		buffer.append("  from C_SH_InTransitStorageEntry inner join B_GoodsInfo on C_SH_TSE_GoodsID=B_GI_GoodsID ");
		buffer.append("       inner join B_Brand on B_GI_SupplierID=B_BD_SupplierID and B_GI_BrandID=B_BD_ID ");
		buffer.append("       left join B_Warehouse a on a.B_WH_ID=C_SH_TSE_InStockID ");
		buffer.append("       left join B_Warehouse b on b.B_WH_ID=C_SH_TSE_OutStockID ");
		buffer.append("       left join B_Departments c on b.B_WH_deptID=B_DP_DepartmentID ");
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
		    buffer.append(" and c.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCerrcompanyid()));	
		}
		
		if ("".equals(Utility.getName(po.getCerrstockid()))) {
			if ("1".equals(Utility.getName(personInfoPo.getDepartmenttype()))) {
				buffer.append(" and B_DP_DepartmentID=? ");
				params.add(Utility.getName(personInfoPo.getDepartmentID()));
			}
			if ("2".equals(Utility.getName(personInfoPo.getDepartmenttype()))) {
				buffer.append(" and (B_DP_DepartmentID=? or B_DP_RegID = ?) ");
				params.add(Utility.getName(personInfoPo.getDepartmentID()));
				params.add(Utility.getName(personInfoPo.getDepartmentID()));
			}
		}

		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_TSE_OutStockID=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsid()))) {
			buffer.append(" and B_GI_GoodsID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsname()))) {
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCerrsupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ?  ");
			params.add(Utility.getName(po.getCerrsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbrandid()))) {
			buffer.append(" and B_GI_BrandID = ?  ");
			params.add(Utility.getName(po.getCerrbrandid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID = ?  ");
			params.add(Utility.getName(po.getCerrgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsbarcode()))) {
			buffer.append(" and C_SH_TSE_GoodsBarCode like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsbarcode()));
		}
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_SH_TSE_BillID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		
		buffer.append("  group by C_SH_TSE_GoodsID,B_GI_GoodsName,C_SH_TSE_GoodsBarCode,B_BD_brandName,isnull(a.B_WH_warehouseName,''),isnull(b.B_WH_warehouseName,''),C_SH_TSE_BillID,C_SH_TSE_InOrOutStock ");
		buffer.append(" ) temp ) temp ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取在途库存商品列表
	 */
	public List<CorrectingErrorsPo> getGoodsTransitStorageList(CorrectingErrorsPo po,PersonInfoPo personInfoPo,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by cerrchangeid) as 'rowNum', ");
		buffer.append("cerrgoodsid,cerrgoodsname,cerrlognum,cerrgoodsbarcode,cerrbrandname,cerrstockname,cerrchangeid,cerroutstockname from ( ");
		buffer.append("select C_SH_TSE_GoodsID as cerrgoodsid,B_GI_GoodsName as cerrgoodsname,C_SH_TSE_GoodsBarCode as cerrgoodsbarcode,B_BD_brandName as cerrbrandname, ");
		buffer.append("       isnull(b.B_WH_warehouseName,'') as cerroutstockname, ");
		buffer.append("       (case C_SH_TSE_InOrOutStock when '1' then ('由【' + isnull(a.B_WH_warehouseName,'')+'】调至') else (case isnull(a.B_WH_warehouseName,'') when '' then '' else ('调至【' + isnull(a.B_WH_warehouseName,'')+'】') end) end) as cerrstockname, ");
		buffer.append("       sum(C_SH_TSE_GoodsNum) as cerrlognum,C_SH_TSE_BillID as cerrchangeid,C_SH_TSE_InOrOutStock as inOrOutStock  ");
		buffer.append("  from C_SH_InTransitStorageEntry inner join B_GoodsInfo on C_SH_TSE_GoodsID=B_GI_GoodsID ");
		buffer.append("       inner join B_Brand on B_GI_SupplierID=B_BD_SupplierID and B_GI_BrandID=B_BD_ID ");
		buffer.append("       left join B_Warehouse a on a.B_WH_ID=C_SH_TSE_InStockID ");
		buffer.append("       left join B_Warehouse b on b.B_WH_ID=C_SH_TSE_OutStockID ");
		buffer.append("       left join B_Departments c on b.B_WH_deptID=B_DP_DepartmentID ");
		buffer.append("  where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
		    buffer.append(" and c.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCerrcompanyid()));	
		}
		
		if ("".equals(Utility.getName(po.getCerrstockid()))) {
			if ("1".equals(Utility.getName(personInfoPo.getDepartmenttype()))) {
				buffer.append(" and B_DP_DepartmentID=? ");
				params.add(Utility.getName(personInfoPo.getDepartmentID()));
			}
			if ("2".equals(Utility.getName(personInfoPo.getDepartmenttype()))) {
				buffer.append(" and (B_DP_DepartmentID=? or B_DP_RegID = ?) ");
				params.add(Utility.getName(personInfoPo.getDepartmentID()));
				params.add(Utility.getName(personInfoPo.getDepartmentID()));
			}
		}
		
		if (!"".equals(Utility.getName(po.getCerrstockid()))) {
			buffer.append(" and C_SH_TSE_OutStockID=? ");
			params.add(Utility.getName(po.getCerrstockid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsid()))) {
			buffer.append(" and B_GI_GoodsID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsname()))) {
			buffer.append(" and B_GI_GoodsName like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getCerrsupplierid()))) {
			buffer.append(" and B_GI_SupplierID = ?  ");
			params.add(Utility.getName(po.getCerrsupplierid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbrandid()))) {
			buffer.append(" and B_GI_BrandID = ?  ");
			params.add(Utility.getName(po.getCerrbrandid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID = ?  ");
			params.add(Utility.getName(po.getCerrgoodscategoryid()));
		}
		if (!"".equals(Utility.getName(po.getCerrgoodsbarcode()))) {
			buffer.append(" and C_SH_TSE_GoodsBarCode like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrgoodsbarcode()));
		}
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and C_SH_TSE_BillID like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		
		buffer.append("  group by C_SH_TSE_GoodsID,B_GI_GoodsName,C_SH_TSE_GoodsBarCode,B_BD_brandName,isnull(a.B_WH_warehouseName,''),isnull(b.B_WH_warehouseName,''),C_SH_TSE_BillID,C_SH_TSE_InOrOutStock ");
		buffer.append(") table1 ) table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), CorrectingErrorsPo.class);
	}
		
	/**
	 * 获取未完结单据总数
	 */
	public int getNotAuditBillCount(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int dcount = 0;
		String[] paremArray = null;
		
		if (!Utility.getName(po.getCerrdepartmentid()).equals("")){			
			dcount = Utility.getName(po.getCerrdepartmentid()).split(",").length;			
			paremArray = Utility.getName(po.getCerrdepartmentid()).split(",");
			
		}
		
		buffer.append("select count(cerrchangeid) from ( ");
		buffer.append("select billid as cerrchangeid,convert(varchar(16),billdate,120) as cerrdate,createperson as cerrpersonname,billtype as cerrbilltype,departmentName as cerrdepartmentname from (  ");
		
		if (!"".equals(Utility.getName(po.getCerrbilltyped()))){
			buffer.append("select distinct C_SHA_A_billID as billid,C_SHA_A_billDate as billdate,personname as createperson,'4' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose   ");
			buffer.append("   from C_SHA_Allocation inner join SYS_PersonInfo on C_SHA_A_createPerson=id inner join B_Departments on C_SHA_A_inDepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_SHA_A_auditState='1' and C_SHA_A_consignState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_SHA_A_inDepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_SHA_A_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			
			buffer.append("union all  ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrbilltypei()))){
			buffer.append("select distinct C_ST_CPR_ReceiptBillId as billid,C_ST_CPR_BillDate as billdate,personname as createperson,'9' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose     ");
			buffer.append("   from C_ST_ConsignProcessReceipt inner join SYS_PersonInfo on C_ST_CPR_CreatePerson=id inner join B_Departments on C_ST_CPR_DepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_ST_CPR_AuditState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_CPR_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_CPR_CreatePerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			
			buffer.append("union all  ");
		}

		if (!"".equals(Utility.getName(po.getCerrbilltypea())) || !"".equals(Utility.getName(po.getCerrbilltypeb())) || !"".equals(Utility.getName(po.getCerrbilltypec())) || !"".equals(Utility.getName(po.getCerrbilltypee())) || !"".equals(Utility.getName(po.getCerrbilltypef())) || !"".equals(Utility.getName(po.getCerrbilltypeg())) || !"".equals(Utility.getName(po.getCerrbilltypeh())) ){			
			buffer.append("select distinct C_ST_I_BillID as billid,C_ST_I_billDate as billdate,personname as createperson,C_ST_I_BillTypeId as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose  ");
			buffer.append("   from C_ST_Inventory inner join SYS_PersonInfo on C_ST_I_createPerson=id inner join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_ST_I_AuditState='0' and C_ST_I_BillTypeId not in ('4','9') ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_I_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_I_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			
			buffer.append(" and ( ");
			if (!"".equals(Utility.getName(po.getCerrbilltypea()))){
				buffer.append(" C_ST_I_BillTypeId='1' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypeb()))){
				buffer.append(" C_ST_I_BillTypeId='2' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypec()))){
				buffer.append(" C_ST_I_BillTypeId='3' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypee()))){
				buffer.append(" C_ST_I_BillTypeId='5' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypef()))){
				buffer.append(" C_ST_I_BillTypeId='6' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypeg()))){
				buffer.append(" C_ST_I_BillTypeId='7' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypeh()))){
				buffer.append(" C_ST_I_BillTypeId='8' or ");
			}
			buffer.append(" 1=0 ) ");			
			buffer.append("union all  ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrbilltypem()))){
			buffer.append("select distinct C_ST_I_BillID as billid,C_ST_I_billDate as billdate,personname as createperson,'10' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose   ");
			buffer.append("   from C_ST_TakeInventory inner join SYS_PersonInfo on C_ST_I_createPerson=id inner join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_ST_I_AuditState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_I_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_I_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			
			buffer.append("union all  ");
			buffer.append("select distinct C_ST_I_BillID as billid,C_ST_I_billDate as billdate,personname as createperson,'10' as billtype,B_FS_StoreName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose   ");
			buffer.append("   from C_ST_TakeInventory inner join SYS_PersonInfo on C_ST_I_createPerson=id inner join B_Franchisee on C_ST_I_DepartmentId=B_FS_StoreID  ");
			buffer.append("   where C_ST_I_AuditState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_I_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_I_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			
			buffer.append("union all  ");
		}

		if (!"".equals(Utility.getName(po.getCerrbilltypej()))){
			buffer.append("select distinct M_T_BillID as billid,M_T_billDate as billdate,personname as createperson,'11' as billtype,B_FS_StoreName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose    ");
			buffer.append("   from M_Trac inner join SYS_PersonInfo on M_T_createPerson=id inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID  ");
			buffer.append("   where M_T_AuditState='0' and M_T_BillTypeId='3' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and M_T_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and M_T_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			buffer.append("union all  ");
		}

		if (!"".equals(Utility.getName(po.getCerrbilltypek()))){
			buffer.append("select distinct M_T_BillID as billid,M_T_billDate as billdate,personname as createperson,'12' as billtype,B_FS_StoreName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose    ");
			buffer.append("   from M_Trac inner join SYS_PersonInfo on M_T_createPerson=id inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID  ");
			buffer.append("   where M_T_AuditState='0' and M_T_BillTypeId='2' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and M_T_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and M_T_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			buffer.append("union all ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrbilltypel()))){
			
			if (!"".equals(Utility.getName(po.getCerrsalesbilltypea()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='0' and S_SE_SB_InTransit='1' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				
				buffer.append("union all ");
			}

			if (!"".equals(Utility.getName(po.getCerrsalesbilltypeb()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='3' and S_SE_SB_OrdersType='1' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='5' and S_SE_SB_OrdersType='2' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
			}
			
			if (!"".equals(Utility.getName(po.getCerrsalesbilltypec()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='11' and S_SE_SB_OrdersType='4' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
			}

			if (!"".equals(Utility.getName(po.getCerrsalesbilltyped()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='12' and S_SE_SB_OrdersType in ('3','5') ");	
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all  ");
			}

		}

		buffer.append("select '' as billid,'' as billdate,'' as createperson,'' as billtype,'' as departmentName,'0' as cerrisdelete,'0' as cerrisdispose    ");
		buffer.append(")temp where billid<>''  ");
		
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and billid like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),billdate,120) >= ?  ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),billdate,120) <= ?  ");
			params.add(Utility.getName(po.getCerrenddate()));
		}
		
		buffer.append(") table1 ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取未完结单据列表
	 */
	public List<CorrectingErrorsPo> getNotAuditBillList(CorrectingErrorsPo po,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		int countPage = start + size;
		List<String> params = new ArrayList<String>();

		int dcount = 0;
		String[] paremArray = null;
		
		if (!Utility.getName(po.getCerrdepartmentid()).equals("")){			
			dcount = Utility.getName(po.getCerrdepartmentid()).split(",").length;			
			paremArray = Utility.getName(po.getCerrdepartmentid()).split(",");
			
		}
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by cerrdate desc) as 'rowNum',* from ( ");
		buffer.append("select billid as cerrchangeid,convert(varchar(16),billdate,120) as cerrdate,createperson as cerrpersonname,billtype as cerrbilltype,departmentName as cerrdepartmentname,cerrisdelete as cerrisdelete,cerrisdispose as cerrisdispose from (  ");
		
		if (!"".equals(Utility.getName(po.getCerrbilltyped()))){
			buffer.append("select distinct C_SHA_A_billID as billid,C_SHA_A_billDate as billdate,personname as createperson,'4' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose   ");
			buffer.append("   from C_SHA_Allocation inner join SYS_PersonInfo on C_SHA_A_createPerson=id inner join B_Departments on C_SHA_A_inDepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_SHA_A_auditState='1' and C_SHA_A_consignState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_SHA_A_inDepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_SHA_A_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			buffer.append("union all  ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrbilltypei()))){
			buffer.append("select distinct C_ST_CPR_ReceiptBillId as billid,C_ST_CPR_BillDate as billdate,personname as createperson,'9' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose     ");
			buffer.append("   from C_ST_ConsignProcessReceipt inner join SYS_PersonInfo on C_ST_CPR_CreatePerson=id inner join B_Departments on C_ST_CPR_DepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_ST_CPR_AuditState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_CPR_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_CPR_CreatePerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			buffer.append("union all  ");
		}

		if (!"".equals(Utility.getName(po.getCerrbilltypea())) || !"".equals(Utility.getName(po.getCerrbilltypeb())) || !"".equals(Utility.getName(po.getCerrbilltypec())) || !"".equals(Utility.getName(po.getCerrbilltypee())) || !"".equals(Utility.getName(po.getCerrbilltypef())) || !"".equals(Utility.getName(po.getCerrbilltypeg())) || !"".equals(Utility.getName(po.getCerrbilltypeh())) ){			
			buffer.append("select distinct C_ST_I_BillID as billid,C_ST_I_billDate as billdate,personname as createperson,C_ST_I_BillTypeId as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose  ");
			buffer.append("   from C_ST_Inventory inner join SYS_PersonInfo on C_ST_I_createPerson=id inner join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_ST_I_AuditState='0' and C_ST_I_BillTypeId not in ('4','9') ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_I_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			
			buffer.append(" and ( ");
			if (!"".equals(Utility.getName(po.getCerrbilltypea()))){
				buffer.append(" C_ST_I_BillTypeId='1' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypeb()))){
				buffer.append(" C_ST_I_BillTypeId='2' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypec()))){
				buffer.append(" C_ST_I_BillTypeId='3' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypee()))){
				buffer.append(" C_ST_I_BillTypeId='5' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypef()))){
				buffer.append(" C_ST_I_BillTypeId='6' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypeg()))){
				buffer.append(" C_ST_I_BillTypeId='7' or ");
			}
			if (!"".equals(Utility.getName(po.getCerrbilltypeh()))){
				buffer.append(" C_ST_I_BillTypeId='8' or ");
			}
			buffer.append(" 1=0 ) ");
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_I_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			buffer.append("union all  ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrbilltypem()))){
			buffer.append("select distinct C_ST_I_BillID as billid,C_ST_I_billDate as billdate,personname as createperson,'10' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose   ");
			buffer.append("   from C_ST_TakeInventory inner join SYS_PersonInfo on C_ST_I_createPerson=id inner join B_Departments on C_ST_I_DepartmentId=B_DP_DepartmentID  ");
			buffer.append("   where C_ST_I_AuditState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_I_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_I_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
			    buffer.append(" and B_DP_CompanysID = ? ");
				params.add(Utility.getName(po.getCerrcompanyid()));	
			}
			buffer.append("union all  ");
			buffer.append("select distinct C_ST_I_BillID as billid,C_ST_I_billDate as billdate,personname as createperson,'10' as billtype,B_FS_StoreName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose   ");
			buffer.append("   from C_ST_TakeInventory inner join SYS_PersonInfo on C_ST_I_createPerson=id inner join B_Franchisee on C_ST_I_DepartmentId=B_FS_StoreID  ");
			buffer.append("   where C_ST_I_AuditState='0' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and C_ST_I_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and C_ST_I_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			buffer.append("union all  ");
		}

		if (!"".equals(Utility.getName(po.getCerrbilltypej()))){
			buffer.append("select distinct M_T_BillID as billid,M_T_billDate as billdate,personname as createperson,'11' as billtype,B_FS_StoreName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose    ");
			buffer.append("   from M_Trac inner join SYS_PersonInfo on M_T_createPerson=id inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID  ");
			buffer.append("   where M_T_AuditState='0' and M_T_BillTypeId='3' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and M_T_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and M_T_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			buffer.append("union all  ");
		}

		if (!"".equals(Utility.getName(po.getCerrbilltypek()))){
			buffer.append("select distinct M_T_BillID as billid,M_T_billDate as billdate,personname as createperson,'12' as billtype,B_FS_StoreName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose    ");
			buffer.append("   from M_Trac inner join SYS_PersonInfo on M_T_createPerson=id inner join B_Franchisee on M_T_SupplierId=B_FS_StoreID  ");
			buffer.append("   where M_T_AuditState='0' and M_T_BillTypeId='2' ");
			if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
				buffer.append(" and M_T_DepartmentId in ( ");
				
				for (int i = 0; i < dcount; i++){
					buffer.append("?");
					if (i+1 != dcount){
						buffer.append(",");
					}
					params.add(paremArray[i]);
				}
				buffer.append(" ) ");
			}
			if (!Utility.getName(po.getCerrpersonid()).equals("")){
				buffer.append(" and M_T_createPerson = ? ");
				params.add(Utility.getName(po.getCerrpersonid()));
			}
			buffer.append("union all ");
		}
		
		if (!"".equals(Utility.getName(po.getCerrbilltypel()))){
			
			if (!"".equals(Utility.getName(po.getCerrsalesbilltypea()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'1' as cerrisdelete,'0' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='0' and S_SE_SB_InTransit='1' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
			}

			if (!"".equals(Utility.getName(po.getCerrsalesbilltypeb()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='3' and S_SE_SB_OrdersType='1' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='5' and S_SE_SB_OrdersType='2' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
			}
			
			if (!"".equals(Utility.getName(po.getCerrsalesbilltypec()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='11' and S_SE_SB_OrdersType='4' ");
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all ");
			}

			if (!"".equals(Utility.getName(po.getCerrsalesbilltyped()))){
				buffer.append("select distinct S_SE_SB_SalesID as billid,S_SE_SB_SalesDatetime as billdate,personName as createperson,'13' as billtype,B_DP_DepartmentName as departmentName,'0' as cerrisdelete,'1' as cerrisdispose    ");
				buffer.append("  from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SB_SalesID=S_SE_SD_SalesID inner join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID inner join SYS_PersonInfo on S_SE_SB_SalerID=id ");
				buffer.append("  where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit='12' and S_SE_SB_OrdersType in ('3','5') ");	
				if (!Utility.getName(po.getCerrdepartmentid()).equals("")){
					buffer.append(" and S_SE_SB_ShopCode in ( ");
					
					for (int i = 0; i < dcount; i++){
						buffer.append("?");
						if (i+1 != dcount){
							buffer.append(",");
						}
						params.add(paremArray[i]);
					}
					buffer.append(" ) ");
				}
				if (!Utility.getName(po.getCerrpersonid()).equals("")){
					buffer.append(" and S_SE_SB_SalerID = ? ");
					params.add(Utility.getName(po.getCerrpersonid()));
				}
				if (!"".equals(Utility.getName(po.getCerrcompanyid()))){
				    buffer.append(" and B_DP_CompanysID = ? ");
					params.add(Utility.getName(po.getCerrcompanyid()));	
				}
				buffer.append("union all  ");
			}

		}
		
		buffer.append("select '' as billid,'' as billdate,'' as createperson,'' as billtype,'' as departmentName,'0' as cerrisdelete,'0' as cerrisdispose    ");
		buffer.append(")temp where billid<>''  ");
		
		if (!"".equals(Utility.getName(po.getCerrchangeid()))) {
			buffer.append(" and billid like '%' + ? + '%'  ");
			params.add(Utility.getName(po.getCerrchangeid()));
		}
		if (!"".equals(Utility.getName(po.getCerrbgndate()))) {
			buffer.append(" and convert(varchar(10),billdate,120) >= ?  ");
			params.add(Utility.getName(po.getCerrbgndate()));
		}
		if (!"".equals(Utility.getName(po.getCerrenddate()))) {
			buffer.append(" and convert(varchar(10),billdate,120) <= ?  ");
			params.add(Utility.getName(po.getCerrenddate()));
		}
		
		buffer.append(") table1 ) table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(), CorrectingErrorsPo.class);
	}	
	
	/**
	 * 更新配镜单在途至顾客取镜
	 */
	public void updateSalesBillInTransit(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();	
	    List<String> params = new ArrayList<String>();
	    
	    buffer.append("update S_SE_SalesBasic set S_SE_SB_InTransit='13' where S_SE_SB_SalesID = ? ");	
		
		params.add(Utility.getName(po.getCerrchangeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增配镜单在途(顾客取镜)
	 */
	public void insertSalesBillInTransit(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();	
	    List<String> params = new ArrayList<String>();
	    
	    buffer.append("insert into S_SE_InTransit(S_SE_IT_ID,S_SE_IT_SalesID,S_SE_IT_State,S_SE_IT_Date,S_SE_IT_CreatePerson,S_SE_IT_Department,S_SE_IT_YsalesID) ");
	    buffer.append("  values(?,?,'13',getdate(),?,?,'') ");	
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCerrchangeid()));
		params.add(Utility.getName(po.getCerrpersonid()));
		params.add(Utility.getName(po.getCerrdepartmentid()));		
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除配镜单在途库存
	 */
	public void deleteSalesBillInTransitStorage(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();	
	    List<String> params = new ArrayList<String>();
	    
	    buffer.append("delete from C_SH_InTransitStorageEntry where C_SH_TSE_BillID = ? ");	
		
		params.add(Utility.getName(po.getCerrchangeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除未完结单据
	 */
	public void deleteNotAuditBill(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();	
	    List<String> params = new ArrayList<String>();
	    
	    buffer.append("exec usp_clearNotAuditBill ? ");	
		
		params.add(Utility.getName(po.getCerrchangeid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 重新转在途库存
	 */
	public void deleteGoodsTransitStorage(CorrectingErrorsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
	    
	    buffer.append("exec usp_CreateGoodsTransitStorage ? ");
	    
		params.add(Utility.getName(po.getCerrisdelete()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
}
