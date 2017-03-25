package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;


import com.pengsheng.eims.basic.dao.GiftsDao;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class GiftsDaoImpl extends BaseJdbcDaoSupport implements GiftsDao {

	/*
	 * 删除赠品
	 */
	public void deleteGifts(GiftsPo giftsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Gifts ");
		buffer.append("WHERE B_GS_uuid = ? ");
		List<String> params = new ArrayList<String>();
		params.add(giftsPo.getBgsuuid());
		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	public int getGiftsCount(GiftsPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(B_GS_GoodsID) from B_Gifts where 1=1 ");		
		if (!"".equals(Utility.getName(po.getBgsgoodsid()))){
			sb.append(" and B_GS_GoodsID=? ");
			params.add(Utility.getName(po.getBgsgoodsid()));
		}
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	/*
	 * 新增赠品
	 */
	public void insertGifts(GiftsPo giftsPo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO B_Gifts ");
		buffer.append("(B_GS_uuid ");
		buffer.append(",B_GS_GoodsID ");
		buffer.append(",B_GS_GoodsBarCode ");
		buffer.append(",B_GS_GoodsName");
		buffer.append(",B_GS_ViewName");
		buffer.append(",B_GS_InPerson");
		buffer.append(",B_GS_InDate");
		buffer.append(",B_GS_AuditState");
		buffer.append(",B_GS_Flag");
		buffer.append(",B_GS_Departments,B_GS_IsShow,B_GS_Type) ");
		buffer.append(" VALUES (?,?, ?, ?, ?, ?, getdate() , '0' ,'1' ,?,?,?) ");		
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(giftsPo.getBgsgoodsid()));
		params.add(Utility.getName(giftsPo.getBgsgoodsbarcode()));
		params.add(Utility.getName(giftsPo.getBgsgoodsname()));
		params.add(Utility.getName(giftsPo.getBgsviewname()));
		params.add(Utility.getName(giftsPo.getBgsinperson()));
		params.add(","+ Utility.getName(giftsPo.getBgsdepartments()) +",");
		params.add(Utility.getName(giftsPo.getBdpisshow()));
		params.add(Utility.getName(giftsPo.getBgstype()));

		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}

	/*
	 * 修改赠品
	 */
	public void updateGifts(GiftsPo giftsPo) {
		
		StringBuffer buffer1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer1.append("update B_Gifts set B_GS_AuditState=? ");		
		params.add(Utility.getName(giftsPo.getBgsauditstate()));
		
		if (!"".equals(Utility.getName(giftsPo.getBgsdepartments()))) {
			buffer1.append(",B_GS_Departments=? ");
			params.add(","+ Utility.getName(giftsPo.getBgsdepartments()) +",");
		}
		if (!"".equals(Utility.getName(giftsPo.getBgsviewname()))) {
			buffer1.append(",B_GS_ViewName=?");
			params.add(Utility.getName(giftsPo.getBgsviewname()));
		}
		if (!"".equals(Utility.getName(giftsPo.getBdpisshow()))) {
			buffer1.append(",B_GS_IsShow=?");
			params.add(Utility.getName(giftsPo.getBdpisshow()));
		}
		if (!"".equals(Utility.getName(giftsPo.getBgstype()))) {
			buffer1.append(",B_GS_Type=?");
			params.add(Utility.getName(giftsPo.getBgstype()));
		}
		if ("1".equals(Utility.getName(giftsPo.getBgsauditstate()))) {
			buffer1.append(",B_GS_AuditPerson=?,B_GS_AuditDate=getdate() ");
			params.add(Utility.getName(giftsPo.getBgsauditperson()));
		}else{
			buffer1.append(",B_GS_AuditPerson=null,B_GS_AuditDate=null ");
		}
		
		buffer1.append(" where B_GS_uuid=? ");
		params.add(Utility.getName(giftsPo.getBgsuuid()));

		getJdbcTemplate().update(buffer1.toString(), params.toArray());
	}

	/*
	 * 修改赠品
	 */
	public void updateGiftsDepartment(GiftsPo giftsPo) {
		
		StringBuffer buffer1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer1.append("update B_Gifts set B_GS_Departments=?,B_GS_IsShow=? where B_GS_uuid=? ");
		
		params.add(","+ Utility.getName(giftsPo.getBgsdepartments()) +",");
		params.add(Utility.getName(giftsPo.getBdpisshow()));
		params.add(Utility.getName(giftsPo.getBgsuuid()));

		getJdbcTemplate().update(buffer1.toString(), params.toArray());
	}
	
	/*
	 * 获得赠品list
	 */
	public List<GiftsPo> getGifts() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("B_GS_uuid as bgsuuid, ");
		sb.append("B_GS_GoodsID as bgsgoodsid, ");
		sb.append("B_GS_GoodsBarCode as bgsgoodsbarcode, ");
		sb.append("B_GS_GoodsName as bgsgoodsname, ");
		sb.append("B_GS_GoodsType as bgsgoodstype, ");
		sb.append("B_GS_ViewName as bgsviewname, ");
		sb.append("B_GS_InPerson as bgsinperson, ");
		sb.append("B_GS_InDate as bgsindate, ");
		sb.append("B_GS_AuditPerson as bgsauditperson, ");
		sb.append("B_GS_AuditState as bgsauditstate, ");
		sb.append("B_GS_AuditDate as bgsauditdate, ");
		sb.append("B_GS_Flag as bgsflag, ");
		sb.append("B_GS_Type as bgstype, ");
		sb.append("SUBSTRING(B_GS_Departments,2,len(B_GS_Departments)-2) as bgsdepartments ");
		sb.append(" FROM B_GIFTS");
		return getJdbcTemplate().queryForList(sb.toString());
	}
	
	/*
	 * 获得赠品list 条件查询
	 */

	public List<GiftsPo> getGifts(GiftsPo giftsPo) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT *, ");
		sb.append("       B_WH_warehouseName AS giftStockName ");
		sb.append("INTO   #GiftTmp ");
		sb.append("FROM   (SELECT *, ");
		sb.append("               CASE B_GS_Type ");
		sb.append("                 WHEN '1' THEN (SELECT B_WC_StockID10 ");
		sb.append("                                FROM   dbo.B_WarehouseConfiguration ");
		sb.append("                                WHERE  B_WC_deptID = ?) ");
		sb.append("                 WHEN '2' THEN (SELECT B_WC_StockID15 ");
		sb.append("                                FROM   dbo.B_WarehouseConfiguration ");
		sb.append("                                WHERE  B_WC_deptID = ?) ");
		sb.append("               END AS giftStockId ");
		sb.append("        FROM   B_Gifts)t ");
		sb.append("       INNER JOIN B_Warehouse ");
		sb.append("         ON giftStockid = B_WH_ID ");
		
		params.add(Utility.getName(giftsPo.getBgsdepartments()));
		params.add(Utility.getName(giftsPo.getBgsdepartments()));
		
		sb.append("SELECT ");
		sb.append("B_GS_uuid as bgsuuid, ");
		sb.append("B_GS_GoodsID as bgsgoodsid, ");
		sb.append("(case when len(B_GS_GoodsBarCode) > 18 then B_GS_GoodsBarCode else (B_GS_GoodsBarCode + '00000000') end  ) as bgsgoodsbarcode, ");
		sb.append("B_GS_GoodsName as bgsgoodsname, ");
		sb.append("B_GS_GoodsType as bgsgoodstype, ");
		sb.append("B_GS_ViewName as bgsviewname, ");
		sb.append("B_GS_InPerson as bgsinperson, ");
		sb.append("B_GS_InDate as bgsindate, ");
		sb.append("B_GS_AuditPerson as bgsauditperson, ");
		sb.append("B_GS_AuditState as bgsauditstate, ");
		sb.append("B_GS_AuditDate as bgsauditdate, ");
		sb.append("B_GS_Flag as bgsflag ,");
		sb.append("B_GI_CostPrice as bgscostprice ,");
		sb.append("B_GI_NotTaxRate as bgsnottaxrate ");	
		if(!"".equals(Utility.getName(giftsPo.getBgsdepartments()))){
		    sb.append(",giftStockId as bdpwarehouseid ");
		    //sb.append(",temp1.goodsQuantity AS bgigoodsquantity ");
		}
		sb.append(" FROM #GiftTmp B_Gifts  " );
		sb.append(" inner join b_goodsinfo on B_GI_GoodsID=B_GS_GoodsID ");		
		sb.append(" inner join (  ");
		sb.append("         select StockId AS StockId,goodsId as goodsId,sum(goodsQuantity) as goodsQuantity from ( ");
		sb.append(" 		select C_SH_SB_StockId AS StockId,C_SH_SB_GoodsId as goodsId,C_SH_SB_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageBeginning ");
		sb.append(" 				INNER JOIN #GiftTmp ON B_GS_GoodsID = C_SH_SB_GoodsId and  C_SH_SB_StockId = giftStockId ");
		sb.append(" 		union all ");
		sb.append(" 		select C_SH_Sc_StockId AS StockId,C_SH_SC_GoodsId as goodsId,C_SH_SC_GoodsQuantity as goodsQuantity from dbo.C_SH_StorageChange ");
		sb.append(" 				INNER JOIN #GiftTmp ON B_GS_GoodsID = C_SH_SC_GoodsId and  C_SH_Sc_StockId = giftStockId ");
		sb.append(" 		) temp  ");
		
		sb.append(" 	group by StockId,goodsId) temp1 ");
		sb.append(" on temp1.goodsId = B_GI_GoodsID ");
		sb.append(" where 1=1 ");
		
		if(!"".equals(Utility.getName(giftsPo.getBgsflag()))){
			sb.append(" and b_gs_flag = '"+ Utility.getName(giftsPo.getBgsflag()) +"' ");
		}
		
		if(!"".equals(Utility.getName(giftsPo.getBdpisshow()))){
			sb.append(" and B_GS_IsShow = '"+ Utility.getName(giftsPo.getBdpisshow()) +"' ");
		}
		
		if(!"".equals(Utility.getName(giftsPo.getBgsdepartments()))){
			sb.append(" and B_GS_Departments like '%," + Utility.getName(giftsPo.getBgsdepartments()) + ",%' ");
		}
		
		if(!"".equals(Utility.getName(giftsPo.getBgsauditstate()))){
			sb.append(" and B_GS_AuditState = '"+ Utility.getName(giftsPo.getBgsauditstate()) +"' ");
		}
		
		if("0".equals(Utility.getName(giftsPo.getBdpsalestype()))){
			sb.append(" and temp1.goodsQuantity > 0 ");
		}
		sb.append(" order by B_GS_GoodsID ");
		
		if("0".equals(Utility.getName(giftsPo.getBdpsalestype()))){
			sb.append("drop table #GiftTmp ");
		}
		
		return queryForObjectList(sb.toString(),params.toArray(),GiftsPo.class);
	}
	
	public int getGiftsCount2(GiftsPo giftsPo){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append(" select count(distinct B_GS_GoodsID) from B_Gifts inner join b_goodsinfo on B_GI_GoodsID=B_GS_GoodsID where 1=1 ");		

		if(!"".equals(Utility.getName(giftsPo.getBgstype()))){
			sb.append(" and B_GS_Type= ? ");
			params.add(Utility.getName(giftsPo.getBgstype()));
		}
		
		if(!"".equals(Utility.getName(giftsPo.getBgsflag()))){
			sb.append(" and b_gs_flag= ? ");
			params.add(Utility.getName(giftsPo.getBgsflag()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgsgoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(giftsPo.getBgsgoodsid()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgsgoodsname()))){
			sb.append(" and B_GI_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(giftsPo.getBgsgoodsname()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgsdepartments()))){
			String[] str = null;
			if (Utility.getName(giftsPo.getBgsdepartments()).indexOf(",") >= 0){
				str = Utility.getName(giftsPo.getBgsdepartments()).split(",");
			}else{
				str = (Utility.getName(giftsPo.getBgsdepartments())+",").split(",");
			}
			if (str != null && str.length > 0){
				sb.append(" and ( 1=0 ");
				for (int i = 0; i < str.length; i++){
					sb.append(" or (','+B_GS_Departments+',') like '%' + ? + '%' ");
					params.add(","+Utility.getName(str[i])+",");
				}
				sb.append(" ) ");
			}
		}
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
		
	/*
	 * 获得赠品list 条件查询
	 */

	public List<GiftsPo> getGifts(GiftsPo giftsPo, int start, int size) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * from (select ROW_NUMBER() ");
		sb.append("Over(order by bgsgoodsid) as 'rowNum',* from ( ");

		sb.append("SELECT distinct B_GS_uuid as bgsuuid, ");
		sb.append("B_GS_GoodsID as bgsgoodsid, ");
		sb.append("B_GS_GoodsBarCode as bgsgoodsbarcode, ");
		sb.append("B_GS_GoodsName as bgsgoodsname, ");
		sb.append("B_GS_GoodsType as bgsgoodstype, ");
		sb.append("B_GS_ViewName as bgsviewname, ");
		sb.append("B_GS_InPerson as bgsinperson, ");
		sb.append("B_GS_InDate as bgsindate, ");
		sb.append("B_GS_AuditPerson as bgsauditperson, ");
		sb.append("B_GS_AuditState as bgsauditstate, ");
		sb.append("B_GS_AuditDate as bgsauditdate, ");
		sb.append("B_GS_Flag as bgsflag ,");	
		sb.append("B_GS_Type as bgstype ,");
		sb.append("B_GS_IsShow as bdpisshow ");
		sb.append(" FROM B_GIFTS  " );
		sb.append("inner join b_goodsinfo on B_GI_GoodsID=B_GS_GoodsID where 1=1 ");
		
		if(!"".equals(Utility.getName(giftsPo.getBgsflag()))){
			sb.append(" and b_gs_flag= ? ");
			params.add(Utility.getName(giftsPo.getBgsflag()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgstype()))){
			sb.append(" and B_GS_Type= ? ");
			params.add(Utility.getName(giftsPo.getBgstype()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgsgoodsid()))){
			sb.append(" and B_GI_GoodsID like '%' + ? + '%' ");
			params.add(Utility.getName(giftsPo.getBgsgoodsid()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgsgoodsname()))){
			sb.append(" and B_GI_GoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(giftsPo.getBgsgoodsname()));
		}
		if(!"".equals(Utility.getName(giftsPo.getBgsdepartments()))){
			String[] str = null;
			if (Utility.getName(giftsPo.getBgsdepartments()).indexOf(",") >= 0){
				str = Utility.getName(giftsPo.getBgsdepartments()).split(",");
			}else{
				str = (Utility.getName(giftsPo.getBgsdepartments())+",").split(",");
			}
			if (str != null && str.length > 0){
				sb.append(" and ( 1=0 ");
				for (int i = 0; i < str.length; i++){
					sb.append(" or (','+B_GS_Departments+',') like '%' + ? + '%' ");
					params.add(","+Utility.getName(str[i])+",");
				}
				sb.append(" ) ");
			}
		}
		
		sb.append(") temp ) temp where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), GiftsPo.class);
	}

	/*
	 * 赠品启用
	 */
	public void ableGifts(GiftsPo giftsPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();

		sb.append("UPDATE B_GIFTS SET B_GS_FLAG='1' WHERE B_GS_uuid=?");
		List<String> params = new ArrayList<String>();
		params.add(giftsPo.getBgsuuid());

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/*
	 * 赠品停用
	 */
	public void disableGifts(GiftsPo giftsPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE B_GIFTS SET B_GS_FLAG='0',B_GS_IsShow='0' WHERE B_GS_uuid=?");
		List<String> params = new ArrayList<String>();
		params.add(giftsPo.getBgsuuid());
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}

	/*
	 * 获得赠品po.
	 */
	public GiftsPo getGift(GiftsPo giftsPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT top 1  ");
		sb.append("B_GS_uuid as bgsuuid, ");
		sb.append("B_GS_GoodsID as bgsgoodsid, ");
		sb.append("B_GS_GoodsBarCode as bgsgoodsbarcode, ");
		sb.append("B_GS_GoodsName as bgsgoodsname, ");
		sb.append("B_GS_GoodsType as bgsgoodstype, ");
		sb.append("B_GS_ViewName as bgsviewname, ");
		sb.append("B_GS_InPerson as bgsinperson, ");
		sb.append("B_GS_InDate as bgsindate, ");
		sb.append("B_GS_AuditPerson as bgsauditperson, ");
		sb.append("B_GS_AuditState as bgsauditstate, ");
		sb.append("B_GS_AuditDate as bgsauditdate, ");
		sb.append("B_GS_Flag as bgsflag ,B_GS_Type as bgstype, ");
		sb.append("SUBSTRING(B_GS_Departments,2,len(B_GS_Departments)-2) as bgsdepartments,B_GS_IsShow as bdpisshow ");
		sb.append(" FROM B_GIFTS WHERE B_GS_uuid=?");

		List<String> params = new ArrayList<String>();
		params.add(giftsPo.getBgsuuid());

		return (GiftsPo) queryForObject(sb.toString(), params.toArray(),GiftsPo.class);
	}

}
