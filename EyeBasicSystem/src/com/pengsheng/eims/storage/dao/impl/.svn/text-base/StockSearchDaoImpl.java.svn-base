package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.persistence.GoodsDetailsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.dao.StockSearchDao;
import com.pengsheng.eims.storage.persistence.StockSearchWarehousePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 库存查询dao实现类
 */
public class StockSearchDaoImpl extends BaseJdbcDaoSupport implements
		StockSearchDao {
	/**
	 * 获取库存综合查询的数量
	 * 
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchCount(GoodsInfoPo po) {
		
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		//查询人能查询的仓位插入临时表处理
			sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
			sb.append("DROP TABLE #stocktmp ");		
			//sb.append("select * into #stocktmp from dbo.Strtotable('0,000,0000,0002,0003,0015,0004,0005,0006,0007,0008,0009,001,0010,0011,002,003,004,005,006,007,008,009,01,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,035,036,1111,8,9,997,999,0012,10,0013,0014,0017,0016,038,037,0001') ");
			sb.append("select * into #stocktmp from dbo.Strtotable('");
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				List<WarehousePo> dList = po.getSmecistocklist();      
				sb.append(Utility.getName(dList.get(0).getBwhid()));
				for (int i = 1; i < dList.size(); i++){
					sb.append(","+ Utility.getName(dList.get(i).getBwhid()) +"");
				}
			}else{
				params.add("");
			}
			sb.append("') ");
		//查询人能查询的仓位插入临时表处理
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){
			sb.append("SELECT COUNT(B_GoodsInfo.B_GI_GoodsID) AS COUNT, ");
			sb.append("       Isnull(SUM(GoodsQuantity), 0)              AS titlenum ");
			sb.append("FROM   (SELECT GoodsId            AS GoodsId, ");
			sb.append("               SUM(GoodsQuantity) AS GoodsQuantity ");
			sb.append("        FROM   (SELECT ");
			sb.append("                       GoodsId, ");
			sb.append("                       GoodsQuantity ");
			sb.append("                       ,warehouseid ");
			sb.append("                FROM   (SELECT C_SH_SB_GoodsId                       AS GoodsId, ");
			sb.append("                               C_SH_SB_GoodsQuantity                 AS GoodsQuantity ");
			sb.append("                               ,C_SH_SB_StockId                       AS warehouseid ");
			sb.append("                        FROM   C_SH_StorageBeginning ");
			sb.append("                				  inner join #stocktmp on C_SH_SB_StockId = str2table ");

			sb.append("                        UNION ALL ");
			sb.append("                        SELECT C_SH_SC_GoodsId                    AS GoodsId, ");
			sb.append("                               C_SH_SC_GoodsQuantity              AS GoodsQuantity ");
			sb.append("                               ,C_SH_SC_StockId                    AS warehouseid ");
			sb.append("                        FROM   C_SH_StorageChange ");
			sb.append("                		   inner join #stocktmp on C_SH_SC_StockId = str2table ");		
			
			sb.append("        )a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP  BY GoodsId  ");
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)=0");
			}
			sb.append("        )c ");
			sb.append("       inner JOIN B_GoodsInfo ");
			sb.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
			sb.append("       INNER JOIN B_Supplier ");
			sb.append("         ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
			sb.append("       inner JOIN B_Brand ");
			sb.append("         ON B_GI_BrandID = B_Brand.B_BD_ID ");
			sb.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
			sb.append("       left JOIN B_Unit ");
			sb.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
			sb.append("       INNER JOIN B_GoodsCategory ");
			sb.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
			sb.append("WHERE  1 = 1 and B_GI_SupplierID<>'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				sb.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				sb.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			// add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Vsph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Vsph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
		}else{
			
			//查询条件选择的仓位插入临时表处理
				if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
					sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
					sb.append("DROP TABLE #stocktmp1 ");
					sb.append("select * into #stocktmp1 from dbo.Strtotable('");
					
					String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
					sb.append(array[0]);
					for (int i = 1; i < array.length; i++){
						sb.append(","+ array[i] +"");
					}
					sb.append("') ");
				}
			//查询条件选择的仓位插入临时表处理
			
			sb.append("SELECT count(temp.COUNT) 		AS COUNT, ");
			sb.append("       Isnull(SUM(TEMP.titlenum), 0)   	AS titlenum ");
			sb.append("from (");
			sb.append("SELECT B_GoodsInfo.B_GI_GoodsID AS COUNT, ");
			sb.append("       GoodsQuantity              AS titlenum, ");
			sb.append("case ");
			sb.append("when isnull(alerttemp.scap,100000) = 100000 then '2' ");
			sb.append("when isnull(c.GoodsQuantity,0) <= isnull(alerttemp.sred,100000) then '4' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.sred,100000) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.slower,0) then '3' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.slower,100000) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.scap,0)   then '2' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.scap,100000) then '1' ");
			sb.append("else '' ");
			sb.append("end as alerttype ");
			
			sb.append("FROM  B_GoodsInfo inner JOIN ( ");
				sb.append("select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
				sb.append("select GoodsId,GoodsQuantity,warehouseid ");
				sb.append("from (select C_SH_SB_GoodsId as GoodsId,C_SH_SB_GoodsQuantity as GoodsQuantity,");
				sb.append("C_SH_StorageBeginning.C_SH_SB_StockId as warehouseid from C_SH_StorageBeginning ");
				sb.append("                inner join #stocktmp on C_SH_SB_StockId = #stocktmp.str2table ");
				if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
					sb.append("                inner join #stocktmp1 on C_SH_SB_StockId = #stocktmp1.str2table ");
				}
				sb.append("where 1=1  ");
				if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
					sb.append(" and C_SH_SB_GoodsBarCode like '%' + ? + '%' ");
					params.add(po.getBgigoodsbarcode());
				}
				sb.append("union all select C_SH_SC_GoodsId as GoodsId,C_SH_SC_GoodsQuantity as GoodsQuantity, ");
				sb.append("C_SH_StorageChange.C_SH_SC_StockId as warehouseid from C_SH_StorageChange ");
				sb.append("                inner join #stocktmp on C_SH_SC_StockId = #stocktmp.str2table ");	
				if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
					sb.append("                inner join #stocktmp1 on C_SH_SC_StockId = #stocktmp1.str2table ");
				}
				sb.append("where 1=1  ");
				if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
					sb.append(" and C_SH_SC_GoodsBarCode like '%' + ? + '%' ");
					params.add(po.getBgigoodsbarcode());
				}
				sb.append(")a )b  ");
				
				sb.append("group by GoodsId,warehouseid ");
			sb.append(")c ");
			sb.append("        ");
			sb.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
			sb.append("       left JOIN B_Supplier ");
			sb.append("         ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
			sb.append("       left JOIN B_Brand ");
			sb.append("        ON B_GI_BrandID = B_Brand.B_BD_ID ");
			sb.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
			sb.append("       left JOIN B_Unit ");
			sb.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
			sb.append("       left JOIN B_Warehouse ");
			sb.append("         ON B_Warehouse.B_WH_ID = c.warehouseid ");
			
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			
			sb.append("       left JOIN B_GoodsCategory ");
			sb.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
			sb.append("left join (  ");
			sb.append("select ");
			sb.append("C_SA_SA_GoodsID as goodsid, ");
			sb.append("C_SA_SA_StockID as stockid, ");
			sb.append("isnull(C_SA_SA_StockCap,0) as scap, ");
			sb.append("isnull(C_SA_SA_StockLower,0) as slower, ");
			sb.append("isnull(C_SA_SA_StockRed,0) as sred ");
			sb.append("from C_SA_StockAlertSetting ");
			sb.append(" ) alerttemp on alerttemp.goodsid = B_GoodsInfo.B_GI_GoodsID and alerttemp.stockid = c.warehouseid ");
			sb.append("WHERE  1 = 1 AND B_GI_SupplierID <> 'ZZ' ");

			// add by ZK begin
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
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
			
				
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				sb.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				sb.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}

			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Vsph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Vsph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			
			sb.append(" ) temp where 1=1 ");
			
			if (!"".equals(Utility.getName(po.getAlerttype()))) {
				sb.append(" and temp.alerttype = ? ");
				params.add(po.getAlerttype());
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			
		}
		
		sb.append(" DROP TABLE #stocktmp1 ");
		sb.append(" DROP TABLE #stocktmp ");

		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}
	/**
	 * 获取库存综合查询的数量
	 * 
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchCodeCount(GoodsInfoPo po) {
		
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		//查询人能查询的仓位插入临时表处理
		sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
		sb.append("DROP TABLE #stocktmp ");		
		//sb.append("select * into #stocktmp from dbo.Strtotable('0,000,0000,0002,0003,0015,0004,0005,0006,0007,0008,0009,001,0010,0011,002,003,004,005,006,007,008,009,01,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,035,036,1111,8,9,997,999,0012,10,0013,0014,0017,0016,038,037,0001') ");
		sb.append("select * into #stocktmp from dbo.Strtotable('");
		if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
			List<WarehousePo> dList = po.getSmecistocklist();      
			sb.append(Utility.getName(dList.get(0).getBwhid()));
			for (int i = 1; i < dList.size(); i++){
				sb.append(","+ Utility.getName(dList.get(i).getBwhid()) +"");
			}
		}else{
			params.add("");
		}
		sb.append("') ");
		//查询人能查询的仓位插入临时表处理
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){
			sb.append("SELECT COUNT(B_GoodsInfo.B_GI_GoodsID) AS COUNT, ");
			sb.append("       Isnull(SUM(GoodsQuantity), 0)              AS titlenum ");
			sb.append("FROM   (SELECT GoodsId            AS GoodsId, ");
			sb.append("        GoodsBarCode     AS GoodsBarCode, ");
			sb.append("               SUM(GoodsQuantity) AS GoodsQuantity ");
			sb.append("        FROM   (SELECT ");
			sb.append("                       GoodsId, ");
			sb.append("                       GoodsBarCode, ");			
			sb.append("                       GoodsQuantity, ");
			sb.append("                       warehouseid ");
			sb.append("                FROM   (SELECT C_SH_SL_GoodsId                       AS GoodsId, ");
			sb.append("                               C_SH_SL_GoodsBarCode                 AS GoodsBarCode, ");
			sb.append("                               C_SH_SL_GoodsQuantity                 AS GoodsQuantity, ");
			sb.append("                               C_SH_SL_StockId                        AS warehouseid ");
			
			sb.append("                        FROM   ");			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
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
			}else{
				sb.append("                        C_SH_StorageLog  ");
			}
			sb.append("                				  inner join #stocktmp on C_SH_SL_StockId = #stocktmp.str2table ");
			
			sb.append("                        WHERE  1 = 1 ");
			
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			
			sb.append("        )a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP  BY GoodsId,GoodsBarCode  ");
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)=0");
			}
			sb.append("        )c ");
			sb.append("       inner JOIN B_GoodsInfo ");
			sb.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
			sb.append("       INNER JOIN B_Supplier ");
			sb.append("         ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
			sb.append("       inner JOIN B_Brand ");
			sb.append("         ON B_GI_BrandID = B_Brand.B_BD_ID ");
			sb.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
			sb.append("       left JOIN B_Unit ");
			sb.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
			sb.append("       INNER JOIN B_GoodsCategory ");
			sb.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
			sb.append("WHERE  1 = 1 and B_GI_SupplierID<>'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}

			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}

			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				sb.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				sb.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			// add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Vsph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Vsph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
		}else{
			//查询条件选择的仓位插入临时表处理
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
				sb.append("DROP TABLE #stocktmp1 ");
				sb.append("select * into #stocktmp1 from dbo.Strtotable('");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				sb.append(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(","+ array[i] +"");
				}
				sb.append("') ");
			}
			//查询条件选择的仓位插入临时表处理
			
			sb.append("SELECT count(temp.COUNT) 		AS COUNT, ");
			sb.append("       Isnull(sum(temp.titlenum), 0)   	AS titlenum ");
			sb.append("from (");
			sb.append("SELECT B_GoodsInfo.B_GI_GoodsID AS COUNT, ");
			sb.append("       GoodsQuantity              AS titlenum ");
			sb.append("FROM  B_GoodsInfo inner JOIN ( ");
			sb.append("select GoodsId as GoodsId,GoodsBarCode as GoodsBarCode,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
			sb.append("select GoodsId,GoodsBarCode,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsBarCode AS GoodsBarCode,");
			sb.append("C_SH_SL_GoodsQuantity as GoodsQuantity,C_SH_SL_StockId as warehouseid ");
			
			sb.append("                        FROM   ");			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
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
			}else{
				sb.append("                        C_SH_StorageLog  ");
			}
			
			sb.append("                inner join #stocktmp on C_SH_SL_StockId = #stocktmp.str2table ");
			
			sb.append("where 1=1  ");
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}

			sb.append(")a )b  ");
			
			sb.append("group by GoodsId,GoodsBarCode,warehouseid ");
			sb.append(")c ");
			sb.append("        ");
			sb.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
			sb.append("       left JOIN B_Supplier ");
			sb.append("         ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
			sb.append("       left JOIN B_Brand ");
			sb.append("        ON B_GI_BrandID = B_Brand.B_BD_ID ");
			sb.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
			sb.append("       left JOIN B_Unit ");
			sb.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
			sb.append("       left JOIN B_Warehouse ");
			sb.append("         ON B_Warehouse.B_WH_ID = c.warehouseid ");
			sb.append("       left JOIN B_GoodsCategory ");
			sb.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
			sb.append("WHERE  1 = 1 AND B_GI_SupplierID <> 'ZZ' ");

			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			
			// add by ZK begin
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
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
			
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}		
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				sb.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				sb.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Vsph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Vsph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			sb.append(" ) temp where 1=1 ");
		}
		
		sb.append(" DROP TABLE #stocktmp1 ");
		sb.append(" DROP TABLE #stocktmp ");
		
		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}
	/**
	 * 获取库存综合查询的数量
	 * 
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchAnyTimeCount(GoodsInfoPo po) {
		
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){
			sb.append("SELECT COUNT(B_GoodsInfo.B_GI_GoodsID) AS COUNT, ");
			sb.append("       SUM(GoodsQuantity)              AS titlenum ");
			sb.append("FROM   (SELECT GoodsId            AS GoodsId, ");
			sb.append("               SUM(GoodsQuantity) AS GoodsQuantity ");
			sb.append("        FROM   (SELECT ");
			sb.append("                       GoodsId, ");
			sb.append("                       GoodsQuantity ");
			sb.append("                       ,warehouseid ");
			sb.append("                FROM   (SELECT C_SH_SL_GoodsId                       AS GoodsId, ");
			sb.append("                               C_SH_SL_GoodsQuantity                 AS GoodsQuantity ");
			sb.append("                               ,C_SH_SL_StockId                       AS warehouseid ");
			sb.append("                        FROM   C_SH_StorageLog ");
			sb.append("                        WHERE  1 = 1 ");

			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				sb.append(" and C_SH_SL_StockId in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				sb.append(" ) ");
			}
			
			sb.append("        )a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP  BY GoodsId  ");
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having SUM(GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having SUM(GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having SUM(GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having SUM(GoodsQuantity)=0");
			}
			sb.append("        )c ");
			sb.append("       right JOIN B_GoodsInfo ");
			sb.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
			sb.append("       INNER JOIN B_Supplier ");
			sb.append("         ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
			sb.append("       inner JOIN B_Brand ");
			sb.append("         ON B_GI_BrandID = B_Brand.B_BD_ID ");
			sb.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
			sb.append("       left JOIN B_Unit ");
			sb.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
			sb.append("       INNER JOIN B_GoodsCategory ");
			sb.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
			sb.append("WHERE  1 = 1 and B_GI_SupplierID<>'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				sb.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				sb.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			// add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Vsph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Vsph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
		}else{
			sb.append("SELECT count(temp.COUNT) 		AS COUNT, ");
			sb.append("       sum(temp.titlenum)   	AS titlenum ");
			sb.append("from (");
			sb.append("SELECT B_GoodsInfo.B_GI_GoodsID AS COUNT, ");
			sb.append("       GoodsQuantity              AS titlenum, ");
			sb.append("case ");
			sb.append("when isnull(GoodsQuantity,0) <= isnull(alerttemp.sred,0) then '4' ");
			sb.append("when isnull(GoodsQuantity,0) >  isnull(alerttemp.sred,0) and isnull(GoodsQuantity,0) <= isnull(alerttemp.slower,0) then '1' ");
			sb.append("when isnull(GoodsQuantity,0) >  isnull(alerttemp.slower,0) and isnull(GoodsQuantity,0) <= isnull(alerttemp.scap,0)   then '2' ");
			sb.append("when isnull(GoodsQuantity,0) >  isnull(alerttemp.scap,0) then '3' ");
			sb.append("else '' ");
			sb.append("end as alerttype ");
			
			sb.append("FROM  B_GoodsInfo inner JOIN ( ");
			sb.append("select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
			sb.append("select GoodsId,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,");
			sb.append("C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
			sb.append("where 1=1  ");
			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode = ? ");
				params.add(po.getBgigoodsbarcode());
			}
			sb.append(")a )b  ");
			sb.append("group by GoodsId,warehouseid ");
			sb.append(")c ");
			sb.append("        ");
			sb.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
			sb.append("       left JOIN B_Supplier ");
			sb.append("         ON B_GI_SupplierID = B_Supplier.B_SP_ID ");
			sb.append("       left JOIN B_Brand ");
			sb.append("        ON B_GI_BrandID = B_Brand.B_BD_ID ");
			sb.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
			sb.append("       left JOIN B_Unit ");
			sb.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
			sb.append("       left JOIN B_Warehouse ");
			sb.append("         ON B_Warehouse.B_WH_ID = c.warehouseid ");
			sb.append("       left JOIN B_GoodsCategory ");
			sb.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
			sb.append("left join (  ");
			sb.append("select ");
			sb.append("C_SA_SA_GoodsID as goodsid, ");
			sb.append("C_SA_SA_StockID as stockid, ");
			sb.append("isnull(C_SA_SA_StockCap,0) as scap, ");
			sb.append("isnull(C_SA_SA_StockLower,0) as slower, ");
			sb.append("isnull(C_SA_SA_StockRed,0) as sred ");
			sb.append("from C_SA_StockAlertSetting ");
			sb.append(" ) alerttemp on alerttemp.goodsid = B_GoodsInfo.B_GI_GoodsID and alerttemp.stockid = c.warehouseid ");
			sb.append("WHERE  1 = 1 AND B_GI_SupplierID <> 'ZZ' ");

			// add by ZK begin
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
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
			
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}		
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				sb.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				sb.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				sb.append(" and c.warehouseid in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				sb.append(" ) ");
			}
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append(" and warehouseid in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}

			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Vsph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Vsph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			sb.append(" ) temp where 1=1 ");
			
			if (!"".equals(Utility.getName(po.getAlerttype()))) {
				sb.append(" and temp.alerttype = ? ");
				params.add(po.getAlerttype());
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			
		}
		
		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}
	
	
	/**
	 * 获取库存详细查询的数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchDetailsCount(GoodsDetailsInfoPo po,PersonInfoPo personInfoPo) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		sb.append("select count(*) as count,sum(sumnum) as titlenum from ");
		sb.append("(select C_SH_SL_GoodsBarCode,");	//条码  条件2
		sb.append("C_SH_SL_GoodsId, ");	//代码   条件1
		sb.append("B_GI_ViewGoodsName , ");	//商品名称  条件4
		sb.append("B_GC_GoodsCategoryName, ");	//商品类别
		sb.append("B_SP_SupplierName, ");	//制造商名称
		sb.append("B_GI_RetailPrice, ");	//单价 条件9
		sb.append("B_WH_warehouseName,  ");	//仓库名称
		sb.append("sum(C_SH_SL_GoodsQuantity) as sumnum,");  	//数量 条件8
		sb.append("B_GI_GoodsCategoryID, ");	//商品类别 条件3
		sb.append("B_GI_SupplierID, ");	//制造商ID 条件5 
		sb.append("B_GI_BrandID, ");	//商品类别ID 条件6
		sb.append("C_SH_SL_StockId 	");//仓位ID 条件7
		sb.append("from C_SH_StorageLog  ");
		sb.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		sb.append("inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		sb.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		sb.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		sb.append("where C_SH_SL_GoodsQuantity<>'0' ");
		sb.append("group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,B_SP_SupplierName,B_GI_ViewGoodsName,B_GC_GoodsCategoryName,B_GI_RetailPrice,B_WH_warehouseName,B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,C_SH_SL_StockId ) table1 ");
		sb.append("where 1=1 and sumnum<>0");
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			sb.append("and C_SH_SL_GoodsId like '%"+po.getSxhGoodsId().toString()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			sb.append("and C_SH_SL_GoodsBarCode like '%"+po.getSxhGoodsBarCode().toString()+"%'  ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getSxhGoodsCategoryID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsName()))){
			sb.append(" and B_GI_ViewGoodsName like '%"+po.getSxhGoodsName()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(po.getSxhSupplierID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(po.getSxhBrandID());
		}

		if ("1".equals(Utility.getName(personInfoPo.getDepartmenttype()))||"2".equals(Utility.getName(personInfoPo.getDepartmenttype()))) {
			sb.append(" and C_SH_SL_StockId in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(personInfoPo.getDepartmentID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			sb.append(" and C_SH_SL_StockId = ? ");
			params.add(po.getSxhStockID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhRetailPrice()))){
			sb.append(" and B_GI_RetailPrice = ? ");
			params.add(po.getSxhRetailPrice());
		}
		
		if(!"".equals(Utility.getName(po.getSxhsumnum()))&&!"".equals(Utility.getName(po.getSxhsumnums()))){
			sb.append(" and sumnum >= ? and sumnum<=?");
			params.add(po.getSxhsumnum());
			params.add(po.getSxhsumnums());
		}
		
		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}

	/**
	 * 获取库存综合查询的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getStockSearchList(GoodsInfoPo po,int start,
			int size) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		int countPage = start + size;
		//查询人能查询的仓位插入临时表处理
		sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
		sb.append("DROP TABLE #stocktmp ");		
		//sb.append("select * into #stocktmp from dbo.Strtotable('0,000,0000,0002,0003,0015,0004,0005,0006,0007,0008,0009,001,0010,0011,002,003,004,005,006,007,008,009,01,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,035,036,1111,8,9,997,999,0012,10,0013,0014,0017,0016,038,037,0001') ");
		sb.append("select * into #stocktmp from dbo.Strtotable('");
		if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
			List<WarehousePo> dList = po.getSmecistocklist();      
			sb.append(Utility.getName(dList.get(0).getBwhid()));
			for (int i = 1; i < dList.size(); i++){
				sb.append(","+ Utility.getName(dList.get(i).getBwhid()) +"");
			}
		}else{
			params.add("");
		}
		sb.append("') ");
		
		//查询条件选择的仓位插入临时表处理
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
			sb.append("DROP TABLE #stocktmp1 ");
			sb.append("select * into #stocktmp1 from dbo.Strtotable('");
			
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			sb.append(array[0]);
			for (int i = 1; i < array.length; i++){
				sb.append(","+ array[i] +"");
			}
			sb.append("') ");
		}
		sb.append("set rowcount " + countPage + " \n");
		
		//查询人能查询的仓位插入临时表处理
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组 
			sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgiviewgoodsname as bgiviewgoodsname,temp.bgisuppliername as bgisuppliername,");
			sb.append("temp.bgiretailprice as bgiretailprice,temp.bgigoodsquantity as bgigoodsquantity,temp.bgigoodscategoryname as bgigoodscategoryname ");
			sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,b_gi_viewgoodsname as bgiviewgoodsname,");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");

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

			sb.append("sum(isnull(c.GoodsQuantity,0)) as bgigoodsquantity,");
			sb.append("B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");
			
			sb.append("from(select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity ");
			sb.append("from (select GoodsId,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SB_GoodsId as GoodsId,C_SH_SB_GoodsQuantity as GoodsQuantity,C_SH_SB_StockId as warehouseid from C_SH_StorageBeginning ");
			sb.append("                inner join #stocktmp on C_SH_SB_StockId = str2table ");
			sb.append("union all select C_SH_SC_GoodsId as GoodsId,C_SH_SC_GoodsQuantity as GoodsQuantity,C_SH_SC_StockId as warehouseid from C_SH_StorageChange ");
			sb.append("                inner join #stocktmp on C_SH_SC_StockId = str2table ");
			
			sb.append(")a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP BY GoodsId ");
			sb.append(" )c ");
			sb.append("right join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
			sb.append("inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("where 1=1 and B_GI_SupplierID<>'ZZ' ");			
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}

			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}

			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}

			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}

			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
				
			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			
			sb.append("  group by  B_GoodsInfo.B_GI_GoodsID , B_GoodsInfo.B_GI_ViewGoodsName,b_gi_viewgoodsname,");
            sb.append("  B_Supplier.B_SP_SupplierName ,");
            
            if("1".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailprice, ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricea, ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceb, ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricec, ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriced, ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricee, ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricef, ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceg, ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceh, ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricei, ");
			}
            
            sb.append(" B_GoodsCategory.B_GC_GoodsCategoryName ");
            if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(c.GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(c.GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(c.GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(c.GoodsQuantity)=0");
			}
		}else{
			
			//查询条件选择的仓位插入临时表处理
			
			sb.append("select * from(");
			sb.append("select ROW_NUMBER() Over(order by tem.bgigoodsid) as rowNum,tem.bgigoodsid as bgigoodsid,tem.bgigoodsname as bgigoodsname,tem.bgiviewgoodsname as bgiviewgoodsname,tem.bgisuppliername as bgisuppliername,");
			sb.append("tem.bgiretailprice as bgiretailprice,tem.bgigoodsquantity as bgigoodsquantity,");
			sb.append("tem.bgiwarehousename as bgiwarehousename,bgiwarehouseid as bgiwarehouseid,tem.bgigoodscategoryname as bgigoodscategoryname,");
			sb.append("tem.alerttype as alerttype ");
			sb.append(" from( select ");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,b_gi_viewgoodsname as bgiviewgoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("alerttemp.scap as bgistorageupperlimit,alerttemp.slower as bgistoragelowerlimit,alerttemp.sred as bgistorageredlimit,");
			sb.append("case ");
			sb.append("when isnull(alerttemp.scap,100000) = 100000 then '2' ");
			sb.append("when isnull(c.GoodsQuantity,0) <= isnull(alerttemp.sred,100000) then '4' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.sred,100000) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.slower,0) then '3' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.slower,100000) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.scap,0)   then '2' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.scap,100000) then '1' ");
			sb.append("else '' ");
			sb.append("end as alerttype, ");
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
			
			sb.append("isnull(c.GoodsQuantity,0) as bgigoodsquantity,B_Warehouse.B_WH_warehouseName as bgiwarehousename,B_Warehouse.B_WH_ID as bgiwarehouseid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");
			sb.append("from B_GoodsInfo inner join ( ");

			sb.append("select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
			sb.append("select GoodsId,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SB_GoodsId as GoodsId,C_SH_SB_GoodsQuantity as GoodsQuantity,");
			sb.append("C_SH_StorageBeginning.C_SH_SB_StockId as warehouseid from C_SH_StorageBeginning ");
			sb.append("                inner join #stocktmp on C_SH_SB_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append("                inner join #stocktmp1 on C_SH_SB_StockId = #stocktmp1.str2table ");
			}
			sb.append(" where 1=1  ");
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SB_GoodsBarCode like '%' + ? + '%' ");
				params.add(po.getBgigoodsbarcode());
			}
			sb.append("union all select C_SH_SC_GoodsId as GoodsId,C_SH_SC_GoodsQuantity as GoodsQuantity, ");
			sb.append("C_SH_StorageChange.C_SH_SC_StockId as warehouseid from C_SH_StorageChange ");
			sb.append("                inner join #stocktmp on C_SH_SC_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append("                inner join #stocktmp1 on C_SH_SC_StockId = #stocktmp1.str2table ");
			}
			sb.append(" where 1=1  ");
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SC_GoodsBarCode like '%' + ? + '%' ");
				params.add(po.getBgigoodsbarcode());
			}
			sb.append(")a )b  ");
			
			sb.append("group by GoodsId,warehouseid ");

			
			sb.append(")c  ");
			sb.append(" on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("left join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			
			sb.append("left join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
			sb.append("left join B_Warehouse on B_Warehouse.B_WH_ID=c.warehouseid  ");
			
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			
			sb.append("left join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("left join (  ");
			sb.append("select ");
			sb.append("C_SA_SA_GoodsID as goodsid, ");
			sb.append("C_SA_SA_StockID as stockid, ");
			sb.append("isnull(C_SA_SA_StockCap,0) as scap, ");
			sb.append("isnull(C_SA_SA_StockLower,0) as slower, ");
			sb.append("isnull(C_SA_SA_StockRed,0) as sred ");
			sb.append("from C_SA_StockAlertSetting ");
			sb.append(" ) alerttemp on alerttemp.goodsid = B_GoodsInfo.B_GI_GoodsID and alerttemp.stockid = c.warehouseid ");
			sb.append("where 1=1 AND B_GI_SupplierID <> 'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}

			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID  like '%' + ? + '%' ");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}

			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}

			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}

			sb.append(" ) tem where 1=1 ");
			if (!"".equals(Utility.getName(po.getAlerttype()))) {
				sb.append(" and tem.alerttype = ? ");
				params.add(po.getAlerttype());
			}
			
		}
		
		sb.append(" )temp where rowNum > " + start + " and rowNum <= " + countPage);
		if( po.getCstcpodid()!=null && !po.getCstcpodid().equals("2") ) {
			sb.append(" ORDER BY bgiwarehouseid DESC ");
		}
		
		sb.append(" DROP TABLE #stocktmp1 ");
		sb.append(" DROP TABLE #stocktmp ");
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	/**
	 * 获取库存综合查询的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getStockSearchCodeList(GoodsInfoPo po,int start,
			int size) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		//查询人能查询的仓位插入临时表处理
		sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
		sb.append("DROP TABLE #stocktmp ");		
		//sb.append("select * into #stocktmp from dbo.Strtotable('0,000,0000,0002,0003,0015,0004,0005,0006,0007,0008,0009,001,0010,0011,002,003,004,005,006,007,008,009,01,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,035,036,1111,8,9,997,999,0012,10,0013,0014,0017,0016,038,037,0001') ");
		sb.append("select * into #stocktmp from dbo.Strtotable('");
		if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
			List<WarehousePo> dList = po.getSmecistocklist();      
			sb.append(Utility.getName(dList.get(0).getBwhid()));
			for (int i = 1; i < dList.size(); i++){
				sb.append(","+ Utility.getName(dList.get(i).getBwhid()) +"");
			}
		}else{
			params.add("");
		}
		sb.append("') ");
		
		//查询条件选择的仓位插入临时表处理
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
			sb.append("DROP TABLE #stocktmp1 ");
			sb.append("select * into #stocktmp1 from dbo.Strtotable('");
			
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			sb.append(array[0]);
			for (int i = 1; i < array.length; i++){
				sb.append(","+ array[i] +"");
			}
			sb.append("') ");
		}
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		
		//查询人能查询的仓位插入临时表处理
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组 
			sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgiviewgoodsname as bgiviewgoodsname,temp.bgisuppliername as bgisuppliername,");
			sb.append("temp.GoodsBarCode as bgigoodsbarcode,temp.bgiretailprice as bgiretailprice,");
			sb.append("temp.bgigoodsquantity as bgigoodsquantity,");
			sb.append("temp.bgigoodscategoryid as bgigoodscategoryid,temp.bgigoodscategoryname as bgigoodscategoryname ");
			sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,b_gi_viewgoodsname as bgiviewgoodsname,");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("c.GoodsBarCode as goodsbarcode,");

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

			sb.append("sum(isnull(c.GoodsQuantity,0)) as bgigoodsquantity,");
			sb.append("B_GoodsInfo.B_GI_GoodsCategoryID as bgigoodscategoryid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");
			
			sb.append("from(select GoodsId as GoodsId,GoodsBarCode as GoodsBarCode,sum(GoodsQuantity) as GoodsQuantity ");
			sb.append("from (select GoodsId,GoodsBarCode,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsBarCode AS GoodsBarCode,C_SH_SL_GoodsQuantity as GoodsQuantity,C_SH_SL_StockId as warehouseid ");
			
			sb.append("                        FROM   ");			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
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
			}else{
				sb.append("                        C_SH_StorageLog  ");
			}
			sb.append("                inner join #stocktmp on C_SH_SL_StockId = #stocktmp.str2table ");
			
			sb.append("where 1=1");
			
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}		
			
			sb.append(")a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP BY GoodsId,GoodsBarCode ");
			sb.append(" )c ");
			sb.append("right join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("where 1=1 and B_GI_SupplierID<>'ZZ' ");			
			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like ? + '%'");
				params.add(po.getBgigoodsname());
			}

			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}

			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			
			sb.append("  group by  B_GoodsInfo.B_GI_GoodsID , B_GoodsInfo.B_GI_ViewGoodsName,b_gi_viewgoodsname,");
            sb.append("  B_Supplier.B_SP_SupplierName ,c.GoodsBarCode ,B_Brand.B_BD_brandName,");
            
            if("1".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailprice, ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricea, ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceb, ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricec, ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriced, ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricee, ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricef, ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceg, ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceh, ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricei, ");
			}
            
            sb.append("  B_GoodsInfo.B_GI_GoodsCategoryID , B_GoodsCategory.B_GC_GoodsCategoryName ");
            if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(c.GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(c.GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(c.GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(c.GoodsQuantity)=0");
			}
		}else{
			
			//查询条件选择的仓位插入临时表处理
			
			sb.append("select * from(");
			sb.append("select ROW_NUMBER() Over(order by tem.bgigoodsid) as rowNum,tem.bgigoodsid as bgigoodsid,tem.bgigoodsname as bgigoodsname,tem.bgiviewgoodsname as bgiviewgoodsname,tem.bgisuppliername as bgisuppliername,");
			sb.append("tem.bgigoodsbarcode as bgigoodsbarcode,tem.bgiretailprice as bgiretailprice,tem.bgigoodsquantity as bgigoodsquantity,");
			sb.append("tem.bgiwarehousename as bgiwarehousename,bgiwarehouseid as bgiwarehouseid,tem.bgigoodscategoryid as bgigoodscategoryid,tem.bgigoodscategoryname as bgigoodscategoryname");
			sb.append(" from( select ");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,b_gi_viewgoodsname as bgiviewgoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("c.GoodsBarCode as bgigoodsbarcode,");

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
			sb.append("isnull(c.GoodsQuantity,0) as bgigoodsquantity,");
			sb.append("B_Warehouse.B_WH_warehouseName as bgiwarehousename,B_Warehouse.B_WH_ID as bgiwarehouseid,B_GoodsInfo.B_GI_GoodsCategoryID as bgigoodscategoryid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");
			sb.append("from B_GoodsInfo inner join ( ");
			sb.append("select GoodsId as GoodsId,GoodsBarCode as GoodsBarCode,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
			sb.append("select GoodsId,GoodsBarCode,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsBarCode AS GoodsBarCode,C_SH_SL_GoodsQuantity as GoodsQuantity,");
			sb.append("C_SH_SL_StockId as warehouseid  ");
			sb.append("                        FROM   ");			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
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
			}else{
				sb.append("                        C_SH_StorageLog  ");
			}
			sb.append("                inner join #stocktmp on C_SH_SL_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append("                inner join #stocktmp1 on C_SH_SL_StockId = #stocktmp1.str2table ");
			}
			
			sb.append("where 1=1  ");
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
				sb.append(")a )b  ");
				
				sb.append("group by GoodsId,warehouseid,GoodsBarCode ");
			
			sb.append(")c  ");
			sb.append(" on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("left join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			
			sb.append("left join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Warehouse on B_Warehouse.B_WH_ID=c.warehouseid  ");
			sb.append("left join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");

			sb.append("where 1=1 AND B_GI_SupplierID <> 'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				sb.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				sb.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			sb.append(" ) tem where 1=1 ");
		}
		
		sb.append(" )temp where rowNum > " + start + " and rowNum <= " + countPage);
		if( po.getCstcpodid()!=null && !po.getCstcpodid().equals("2") ) {
			sb.append(" ORDER BY bgiwarehouseid DESC ");
		}
		
		sb.append(" DROP TABLE #stocktmp1 ");
		sb.append(" DROP TABLE #stocktmp ");
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	/**
	 * 获取库存综合查询的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getStockSearchAnyTimeList(GoodsInfoPo po ,int start,
			int size) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组 
			sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgiviewgoodsname as bgiviewgoodsname,temp.bgisuppliername as bgisuppliername,temp.bgiframesize as bgiframesize,");
			sb.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia,");
			sb.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
			sb.append("temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.bgiflag as bgiflag,");
			sb.append("temp.bgigoodsquantity as bgigoodsquantity,");
			sb.append("temp.bgigoodscategoryid as bgigoodscategoryid,temp.bgigoodscategoryname as bgigoodscategoryname ");
			sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,b_gi_viewgoodsname as bgiviewgoodsname,");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,");
			sb.append("B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,");
			sb.append("B_Brand.B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,");
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
			sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,");
			sb.append("B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag,sum(isnull(c.GoodsQuantity,0)) as bgigoodsquantity,");
			sb.append("B_GoodsInfo.B_GI_GoodsCategoryID as bgigoodscategoryid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname,B_GI_FrameSize as bgiframesize ");
			
			sb.append("from(select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity ");
			sb.append("from (select GoodsId,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
			sb.append("where 1=1");
			
			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				sb.append(" and C_SH_SL_StockId in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				sb.append(" ) ");
			}
			
			sb.append(")a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP BY GoodsId ");
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)=0");
			}
			sb.append(" )c ");
			sb.append("right join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
			sb.append("inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("where 1=1 and B_GI_SupplierID<>'ZZ' ");			
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}

			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}

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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}

			/*-----------------------------新条件 2012/11/06----------------------------*/
			
			sb.append("  group by  B_GoodsInfo.B_GI_GoodsID , B_GoodsInfo.B_GI_ViewGoodsName,b_gi_viewgoodsname,");
            sb.append("  B_Supplier.B_SP_SupplierName ,B_GoodsInfo.B_GI_Spec,B_GoodsInfo.B_GI_Color,");
            sb.append("  B_GoodsInfo.B_GI_Sph,B_GoodsInfo.B_GI_Cyl, B_GoodsInfo.B_GI_Axis,B_GoodsInfo.B_GI_Curvature1,");
            sb.append("  B_GoodsInfo.B_GI_Dia ,B_GoodsInfo.B_GI_TaxRate ,");
            sb.append("  B_GoodsInfo.B_GI_GoodsBarCode ,B_Brand.B_BD_brandName,B_Unit.B_UT_unitName, ");
            
            if("1".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailprice, ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricea, ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceb, ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricec, ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriced, ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricee, ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricef, ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceg, ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceh, ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricei, ");
			}
            
            sb.append("  B_GoodsInfo.B_GI_CostPrice,B_GoodsInfo.B_GI_NotTaxRate ,");
            sb.append("  B_GoodsInfo.B_GI_Flag ,B_GoodsInfo.B_GI_GoodsCategoryID , B_GoodsCategory.B_GC_GoodsCategoryName,B_GI_FrameSize ");
			
		}else{
			sb.append("select * from(");
			sb.append("select ROW_NUMBER() Over(order by tem.bgigoodsid) as rowNum,tem.bgigoodsid as bgigoodsid,tem.bgigoodsname as bgigoodsname,tem.bgiviewgoodsname as bgiviewgoodsname,tem.bgisuppliername as bgisuppliername,tem.bgiframesize as bgiframesize,");
			sb.append("tem.bgisph as bgisph,tem.bgicyl as bgicyl,tem.bgiaxis as bgiaxis,tem.bgicurvature1 as bgicurvature1,tem.bgidia as bgidia,");
			sb.append("tem.bgispec as bgispec,tem.bgicolor as bgicolor,tem.bgibrandname as bgibrandname,tem.bgitaxrate as bgitaxrate,tem.bgigoodsbarcode as bgigoodsbarcode,");
			sb.append("tem.bgiunitname as bgiunitname,tem.bgicostprice as bgicostprice,tem.bgiretailprice as bgiretailprice,tem.bginottaxrate as bginottaxrate,tem.bgiflag as bgiflag,");
			sb.append("tem.bgigoodsquantity as bgigoodsquantity,");
			sb.append("tem.bgiwarehousename as bgiwarehousename,bgiwarehouseid as bgiwarehouseid,tem.bgigoodscategoryid as bgigoodscategoryid,tem.bgigoodscategoryname as bgigoodscategoryname,");
			sb.append("tem.alerttype as alerttype ");
			sb.append(" from( select ");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,b_gi_viewgoodsname as bgiviewgoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GI_FrameSize as bgiframesize,");
			sb.append("B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,");
			sb.append("B_Brand.B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,alerttemp.scap as bgistorageupperlimit,alerttemp.slower as bgistoragelowerlimit,alerttemp.sred as bgistorageredlimit,");
			sb.append("case ");
			sb.append("when isnull(c.GoodsQuantity,0) <= isnull(alerttemp.sred,100000) then '4' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.sred,100000) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.slower,0) then '3' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.slower,100000) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.scap,0)   then '2' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.scap,100000) then '1' ");
			sb.append("when isnull(alerttemp.scap,100000) = 100000 then '5' ");
			sb.append("else '' ");
			sb.append("end as alerttype, ");
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
			sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,");
			sb.append("B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag,isnull(c.GoodsQuantity,0) as bgigoodsquantity,");
			sb.append("B_Warehouse.B_WH_warehouseName as bgiwarehousename,B_Warehouse.B_WH_ID as bgiwarehouseid,B_GoodsInfo.B_GI_GoodsCategoryID as bgigoodscategoryid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");
			sb.append("from B_GoodsInfo inner join ( ");
			
				sb.append("select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
				sb.append("select GoodsId,GoodsQuantity,warehouseid ");
				sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,");
				sb.append("C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
				sb.append("where 1=1  ");
				if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
					sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
					params.add(po.getStockQueryBeginDate());
				}
				if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
					sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
					params.add(po.getStockQueryEndDate());
				}
				if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
					sb.append(" and C_SH_SL_GoodsBarCode = ? ");
					params.add(po.getBgigoodsbarcode());
				}
				sb.append(")a )b  ");
				sb.append("group by GoodsId,warehouseid ");
			
			
			sb.append(")c  ");
			sb.append(" on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("left join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			
			sb.append("left join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
			sb.append("left join B_Warehouse on B_Warehouse.B_WH_ID=c.warehouseid  ");
			sb.append("left join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("left join (  ");
			sb.append("select ");
			sb.append("C_SA_SA_GoodsID as goodsid, ");
			sb.append("C_SA_SA_StockID as stockid, ");
			sb.append("isnull(C_SA_SA_StockCap,0) as scap, ");
			sb.append("isnull(C_SA_SA_StockLower,0) as slower, ");
			sb.append("isnull(C_SA_SA_StockRed,0) as sred ");
			sb.append("from C_SA_StockAlertSetting ");
			sb.append(" ) alerttemp on alerttemp.goodsid = B_GoodsInfo.B_GI_GoodsID and alerttemp.stockid = c.warehouseid ");
			sb.append("where 1=1 AND B_GI_SupplierID <> 'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID  like '%' + ? + '%' ");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				sb.append(" and c.warehouseid in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				sb.append(" ) ");
			}

			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append(" and c.warehouseid in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}
			
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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sb.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}

			/*-----------------------------新条件 2012/11/06----------------------------*/
			sb.append(" ) tem where 1=1 ");
			if (!"".equals(Utility.getName(po.getAlerttype()))) {
				sb.append(" and tem.alerttype = ? ");
				params.add(po.getAlerttype());
			}
		}
		
		sb.append(" )temp where rowNum > " + start + " and rowNum <= " + countPage);
		if( po.getCstcpodid()!=null && !po.getCstcpodid().equals("2") ) {
			sb.append(" ORDER BY bgiwarehouseid DESC ");
		}
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	/*---------两层---------------------------------------------------------------------*/
	public int selectGoodsIdCount(GoodsInfoPo po){
		
		List<StockSearchWarehousePo> warehouseids = new ArrayList<StockSearchWarehousePo>();
		if ("".equals(Utility.getName(po.getBgiwarehouseid()))){
			warehouseids = this.selectWarehouseId(Utility.getName(po.getIsclosed()).equals("2") ? "" : Utility.getName(po.getIsclosed()),po);
		}else{
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			for (int i = 0; i < array.length; i++){
				StockSearchWarehousePo spo = new StockSearchWarehousePo();
				spo.setWarehouseid(array[i]);
				
				warehouseids.add(spo);
			}
		}		
		
		List<String> params = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		
		String widstr = "";
		for(int i=0; i<warehouseids.size(); i++){
			widstr = widstr+warehouseids.get(i).getWarehouseid().toString()+"],[";
		}
		widstr = "["+widstr.substring(0, widstr.length()-2);
		
        String str = "";
		for(int i=0; i < warehouseids.size(); i++){
			str = str + warehouseids.get(i).getWarehouseid().toString()+",";
		}
		po.setBgiwarehouseid(str);
		
		buffer.append("        SELECT    count(*) FROM   ( ");
		if ("brand".equals(Utility.getName(po.getQueryType()))){
			buffer.append("        SELECT substring(goodsid,1,7) as goodsid, ");
			buffer.append("                       sum(quantity) as quantity, ");
			buffer.append("                       warehouseid from ( ");
		}
		buffer.append("        SELECT goodsid, ");
		buffer.append("                       sum(quantity) as quantity, ");
		buffer.append("                       warehouseid ");
		if ("yes".equals(Utility.getName(po.getBrandGroup()))){
			buffer.append("                   ,B_GI_RetailPrice as B_GI_RetailPrice ");
		}
		
		buffer.append("                FROM   (SELECT B_GI_GoodsID              AS goodsid, ");
		buffer.append("                               B_GI_ViewGoodsName            AS goodsname, ");
		buffer.append("                               B_GC_ID                   AS categoryid, ");
		buffer.append("                               B_GC_GoodsCategoryName    AS categoryname, ");
		buffer.append("                               B_GI_SupplierID           AS supplierid, ");
		buffer.append("                               B_SP_SupplierName         AS suppliername, ");
		buffer.append("                               B_GI_Spec                 AS spec, ");
		buffer.append("                               B_GI_Color                AS color, ");
		buffer.append("                               B_GI_Sph                  AS ds, ");
		buffer.append("                               B_GI_Cyl                  AS dc, ");
		buffer.append("                               B_GI_FrameSize            AS framesize,B_BD_brandName as B_BD_brandName, ");
		buffer.append("                               Isnull(temp1.quantity, 0) AS quantity, ");
		buffer.append("                               temp1.stockid             AS warehouseid, ");
		if ("yes".equals(Utility.getName(po.getBrandGroup()))){
			buffer.append("                   B_GI_RetailPrice as B_GI_RetailPrice, ");
		}
		buffer.append("                               B_WH_warehouseName        AS warehousename ");
		buffer.append("                        FROM   dbo.B_GoodsInfo ");                                          // c
		buffer.append("                               INNER JOIN (SELECT goodsid       AS goodsid, ");
		buffer.append("                                                  stockid       AS stockid, ");
		buffer.append("                                                  SUM(quantity) AS quantity ");
		buffer.append("                                           FROM   (SELECT C_SH_SC_GoodsId       AS goodsid, ");
		buffer.append("                                                          C_SH_SC_StockId       AS stockid, ");
		buffer.append("                                                          C_SH_SC_GoodsQuantity AS quantity ");
		buffer.append("                                                   FROM   dbo.C_SH_StorageChange ");
		buffer.append("                                                          INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                                            ON C_SH_SC_StockId = B_WH_ID ");
		
		buffer.append("                                                   WHERE  1=1 ");
		if(!"2".equals(Utility.getName(po.getIsclosed()))){
			buffer.append("                                                   and dbo.B_Warehouse.B_WH_IsClosed = '"+po.getIsclosed()+"' ");
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and C_SH_SC_StockId in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
		}
		
		buffer.append("                                                   UNION ALL ");
		buffer.append("                                                   SELECT C_SH_SB_GoodsId       AS goodsid, ");
		buffer.append("                                                          C_SH_SB_StockId       AS stockid, ");
		buffer.append("                                                          C_SH_SB_GoodsQuantity AS quantity ");
		buffer.append("                                                   FROM   dbo.C_SH_StorageBeginning ");
		buffer.append("                                                          INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                                            ON C_SH_SB_StockId = B_WH_ID ");
		
		buffer.append("                                                   WHERE  1=1 ");
		if(!"2".equals(Utility.getName(po.getIsclosed()))){
			buffer.append("                                                   and dbo.B_Warehouse.B_WH_IsClosed = '"+po.getIsclosed()+"' ");
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and C_SH_SB_StockId in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
		}
		
		buffer.append("                                           ) TEMP GROUP  BY goodsid, ");
		buffer.append("                                                     stockid) temp1 ");
		buffer.append("                                 ON B_GI_GoodsID = temp1.goodsid ");
		buffer.append("                               INNER JOIN dbo.B_Supplier ");
		buffer.append("                                 ON B_GI_SupplierID = B_SP_ID ");
		buffer.append("                               RIGHT JOIN dbo.B_Warehouse ");
		buffer.append("                                 ON temp1.stockid = B_WH_ID ");
		buffer.append("                               INNER JOIN B_GoodsCategory ");
		buffer.append("                                 ON B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("                               inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");

		buffer.append(" and B_GI_SupplierID<>'ZZ' ");
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
			buffer.append(" and B_GI_AccessoriesType = ? ");
			params.add(po.getBgiaccessoriestype());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsID like'%"+po.getBgigoodsid()+"%'");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like'%"+po.getBgigoodsbarcode()+"%'");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%"+po.getBgigoodsname()+"%'");
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsCategoryID='"+po.getBgigoodscategoryid()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_SupplierID='"+po.getBgisupplierid()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_BrandID='"+po.getBgibrandid()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
			buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
			params.add(po.getBgiallbrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>="+po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<="+po.getBgiretailendprice());
		}
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			buffer.append(" and B_GI_Flag= '"+po.getBgiflag()+"'");
		}
		if(!"".equals(Utility.getName(po.getJxfs()))){
			buffer.append(" and B_BD_Settlement in ( ? ");
			
			String[] array = Utility.getName(po.getJxfs()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}		
		/*-----------------------------新条件 2012/11/06----------------------------*/
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgispec()));
		}
		
		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgicolor()));
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
			buffer.append(" and B_GI_BrandYear = ? ");
			params.add(Utility.getName(po.getBgibrandyear()));
		}
		
		if (!"".equals(Utility.getName(po.getBgiframesize()))) {
			buffer.append(" and B_GI_FrameSize = '"+po.getBgiframesize()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			buffer.append(" and B_GI_isMutiLuminosity = '"+po.getBgiismutiluminosity()+"'");
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			buffer.append(" and B_GI_EyeGlassMaterialType = '"+po.getBgieyeglassmaterialtype()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			buffer.append(" and B_GI_Refractive = '"+po.getBgirefractive()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getMaxSph()))) {
			buffer.append(" and B_GI_Vsph <= cast( '"+po.getMaxSph()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getMinSph()))) {
			buffer.append(" and B_GI_Vsph >= cast( '"+po.getMinSph()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getMaxCyl()))) {
			buffer.append(" and B_GI_Vcyl <= cast( '"+po.getMaxCyl()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getMinCyl()))) {
			buffer.append(" and B_GI_Vcyl >= cast( '"+po.getMinCyl()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getBgiusetype()))) {
			buffer.append(" and B_GI_UseType = '"+po.getBgiusetype()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
			buffer.append(" and B_GI_StealthClass = '"+po.getBgistealthclass()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			buffer.append(" and B_GI_frameProcessCraftType = '"+po.getBgitechnologytypeid()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			buffer.append(" and B_GI_FrameMaterialType = '"+po.getBgiframematerialtype()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			buffer.append(" and B_GI_OtherGoodsBigClass=?");
			params.add(po.getBgiothergoodsbigclass());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			buffer.append(" and B_GI_OtherGoodsSmallClass=?");
			params.add(po.getBgiothergoodssmallclass());
		}
		
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			buffer.append(" and B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		/*-----------------------------新条件 2012/11/06----------------------------*/
		buffer.append(")c group by goodsid,warehouseid ");
		if ("yes".equals(Utility.getName(po.getBrandGroup()))){
			buffer.append("  ,B_GI_RetailPrice ");
		}
		
		if ("brand".equals(Utility.getName(po.getQueryType()))){
			buffer.append(")c group by substring(goodsid,1,7),warehouseid ");
			if ("yes".equals(Utility.getName(po.getBrandGroup()))){
				buffer.append("  ,B_GI_RetailPrice ");
			}
		}
				
		if("2".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) < 0");
		}
		else if("3".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) > 0");
		}
		else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) <> 0");
		}
		else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) = 0");
		}
		buffer.append(" ) a PIVOT (MAX(quantity)  FOR warehouseid IN ("+widstr+")) b");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int selectGoodsIdSum(GoodsInfoPo po){
		
		List<StockSearchWarehousePo> warehouseids = new ArrayList<StockSearchWarehousePo>();
		if ("".equals(Utility.getName(po.getBgiwarehouseid()))){
			warehouseids = this.selectWarehouseId(Utility.getName(po.getIsclosed()).equals("2") ? "" : Utility.getName(po.getIsclosed()),po);
		}else{
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			for (int i = 0; i < array.length; i++){
				StockSearchWarehousePo spo = new StockSearchWarehousePo();
				spo.setWarehouseid(array[i]);
				
				warehouseids.add(spo);
			}
		}		
		
		String widstr = "";
		for(int i=0; i < warehouseids.size(); i++){
			widstr = widstr + warehouseids.get(i).getWarehouseid().toString()+",";
		}
		po.setBgiwarehouseid(widstr);
				
		List<String> params = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("SELECT SUM(GoodsQuantity)              AS titlenum ");
		buffer.append("FROM   (SELECT GoodsId            AS GoodsId, ");
		buffer.append("               SUM(GoodsQuantity) AS GoodsQuantity ");
		buffer.append("               ,warehouseid AS warehouseid ");
		buffer.append("        FROM   (SELECT ");
		buffer.append("                       GoodsId, ");
		buffer.append("                       GoodsQuantity ");
		buffer.append("                       ,warehouseid ");
		buffer.append("                FROM   (SELECT C_SH_SB_GoodsId                       AS GoodsId, ");
		buffer.append("                               C_SH_SB_GoodsQuantity                 AS GoodsQuantity ");
		buffer.append("                               ,C_SH_SB_StockId                       AS warehouseid ");
		buffer.append("                        FROM   C_SH_StorageBeginning ");
		buffer.append("                                                          INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                                            ON C_SH_SB_StockId = B_WH_ID ");
		buffer.append("                                                   WHERE  1=1 ");
		if(!"2".equals(Utility.getName(po.getIsclosed()))){
			buffer.append("                                                   and B_WH_IsClosed = ? ");
			params.add(po.getIsclosed());			
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and C_SH_SB_StockId in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
		}
		
		buffer.append("                        UNION ALL ");
		buffer.append("                        SELECT C_SH_SC_GoodsId                    AS GoodsId, ");
		buffer.append("                               C_SH_SC_GoodsQuantity              AS GoodsQuantity ");
		buffer.append("                               ,C_SH_SC_StockId                    AS warehouseid ");
		buffer.append("                        FROM   C_SH_StorageChange ");
		buffer.append("                                                          INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                                            ON C_SH_SC_StockId = B_WH_ID ");
		
		buffer.append("                                                   WHERE  1=1 ");
		if(!"2".equals(Utility.getName(po.getIsclosed()))){
			buffer.append("                                                   and B_WH_IsClosed = ? ");
			params.add(po.getIsclosed());			
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and C_SH_SC_StockId in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
		}
		
		buffer.append("        )a)b inner JOIN B_Warehouse ON B_Warehouse.B_WH_ID = warehouseid GROUP  BY GoodsId,warehouseid ");
		if("2".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having SUM(GoodsQuantity) < 0");
		}
		else if("3".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having SUM(GoodsQuantity) > 0");
		}
		else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having SUM(GoodsQuantity) <> 0");
		}
		else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having SUM(GoodsQuantity) = 0");
		}
		
		buffer.append(")c ");		
		buffer.append("       INNER JOIN B_GoodsInfo ");
		buffer.append("         ON B_GoodsInfo.B_GI_GoodsID = c.GoodsId ");
		buffer.append("       INNER JOIN B_Supplier ");
		buffer.append("         ON B_GI_SupplierID  = B_Supplier.B_SP_ID ");
		buffer.append("       INNER JOIN B_Brand ");
		buffer.append("         ON B_GI_BrandID = B_Brand.B_BD_ID ");
		buffer.append("            AND B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
		buffer.append("       left JOIN B_Unit ");
		buffer.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
		buffer.append("       INNER JOIN B_GoodsCategory ");
		buffer.append("         ON B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
		buffer.append("WHERE  B_GI_SupplierID<>'ZZ' ");
		
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
			buffer.append(" and B_GI_AccessoriesType = ? ");
			params.add(po.getBgiaccessoriestype());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsID like'%'+?+'%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsID like'%'+?+'%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like'%'+?+'%'");
			params.add(po.getBgigoodsbarcode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%'+?+'%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsCategoryID= ? ");
			params.add(po.getBgigoodscategoryid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_SupplierID=? ");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_BrandID=? ");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
			buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
			params.add(po.getBgiallbrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			buffer.append(" and B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=? ");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=? ");
			params.add(po.getBgiretailendprice());
		}
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			buffer.append(" and B_GI_Flag= ? ");
			params.add(po.getBgiflag());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			buffer.append(" and B_GI_OtherGoodsBigClass=?");
			params.add(po.getBgiothergoodsbigclass());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			buffer.append(" and B_GI_OtherGoodsSmallClass=?");
			params.add(po.getBgiothergoodssmallclass());
		}
		
//		if (!"".equals(Utility.getName(po.getJxfs()))) {
//			buffer.append(" and B_BD_Settlement = '"+po.getJxfs()+"'");
//		}
		if(!"".equals(Utility.getName(po.getJxfs()))){
			buffer.append(" and B_BD_Settlement in ( ? ");
			
			String[] array = Utility.getName(po.getJxfs()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}	
		/*-----------------------------新条件 2012/11/06----------------------------*/
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgispec()));
		}
		
		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBgicolor()));
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
			buffer.append(" and B_GI_BrandYear = ? ");
			params.add(Utility.getName(po.getBgibrandyear()));
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgiframesize()))) {
			buffer.append(" and B_GI_FrameSize = ? ");
			params.add(po.getBgiframesize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			buffer.append(" and B_GI_isMutiLuminosity = ? ");
			params.add(po.getBgiismutiluminosity());
		}
		
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
			params.add(po.getBgieyeglassmaterialtype());
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			buffer.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if (!"".equals(Utility.getName(po.getMaxSph()))) {
			buffer.append(" and B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSph());
		}
		
		if (!"".equals(Utility.getName(po.getMinSph()))) {
			buffer.append(" and B_GI_Vsph >= cast( ? as float) ");
			params.add(po.getMinSph());
		}
		
		if (!"".equals(Utility.getName(po.getMaxCyl()))) {
			buffer.append(" and B_GI_Vcyl <= cast( ? as float) ");
			params.add(po.getMaxCyl());
		}
		
		if (!"".equals(Utility.getName(po.getMinCyl()))) {
			buffer.append(" and B_GI_Vcyl >= cast( ? as float) ");
			params.add(po.getMinCyl());
		}
		
		if (!"".equals(Utility.getName(po.getBgiusetype()))) {
			buffer.append(" and B_GI_UseType = ? ");
			params.add(po.getBgiusetype());
		}
		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
			buffer.append(" and B_GI_StealthClass = ? ");
			params.add(po.getBgistealthclass());
		}
		
		if (!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			buffer.append(" and B_GI_frameProcessCraftType = '"+po.getBgitechnologytypeid()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			buffer.append(" and B_GI_FrameMaterialType = '"+po.getBgiframematerialtype()+"'");
		}
		
		/*-----------------------------新条件 2012/11/06----------------------------*/
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	//表头
	public List<StockSearchWarehousePo> selectWarehouseId(String isclosed,String warehouseID){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_WH_ID as warehouseid, ");
		buffer.append("       B_WH_warehouseName as warehousename ");
		buffer.append("from B_Warehouse ");
		buffer.append("inner join dbo.B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("where B_DP_Type in('1','2','3') ");
		
		if(!"".equals(isclosed)){
			buffer.append("and B_WH_IsClosed = ? ");
			params.add(isclosed);
		}
		
		if(!"".equals(Utility.getName(warehouseID))){
			buffer.append(" and B_WH_ID in ( ? ");
			
			String[] array = Utility.getName(warehouseID).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		
		buffer.append("order by B_WH_orderNumber,B_WH_ID ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), StockSearchWarehousePo.class);
	}
	
	//表头
	public List<StockSearchWarehousePo> selectWarehouseId(String isclosed,GoodsInfoPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_WH_ID as warehouseid, ");
		buffer.append("       B_WH_warehouseName as warehousename ");
		buffer.append("from B_Warehouse ");
		buffer.append("inner join dbo.B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("where 1 = 1 ");
		
		if(!"".equals(isclosed)){
			buffer.append("and B_WH_IsClosed = ? ");
			params.add(isclosed);
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
			buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append("order by B_WH_orderNumber,B_WH_ID ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), StockSearchWarehousePo.class);
	}
	
	//内容
	public List selectStockSearchWarehouseList(GoodsInfoPo po,PersonInfoPo personInfoPo ,int start,int size){

		List<StockSearchWarehousePo> warehouseids = new ArrayList<StockSearchWarehousePo>();
		if ("".equals(Utility.getName(po.getBgiwarehouseid()))){
			warehouseids = this.selectWarehouseId(Utility.getName(po.getIsclosed()).equals("2") ? "" : Utility.getName(po.getIsclosed()),po);
		}else{
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			for (int i = 0; i < array.length; i++){
				StockSearchWarehousePo spo = new StockSearchWarehousePo();
				spo.setWarehouseid(array[i]);
				
				warehouseids.add(spo);
			}
		}
		
        String widstr = "";
		for(int i=0; i<warehouseids.size(); i++){
			widstr = widstr+warehouseids.get(i).getWarehouseid().toString()+"],[";
		}
		widstr = "["+widstr.substring(0, widstr.length()-2);
		
        String str = "";
		for(int i=0; i < warehouseids.size(); i++){
			str = str + warehouseids.get(i).getWarehouseid().toString()+",";
		}
		po.setBgiwarehouseid(str);
		
		StringBuffer buffer = new StringBuffer();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append(" ");
		buffer.append("SELECT * ");
		buffer.append("FROM   (SELECT Row_number() OVER(ORDER BY goodsid) AS rowNum, ");
		buffer.append("               *  FROM   ( ");
		
		if ("brand".equals(Utility.getName(po.getQueryType()))){
			buffer.append("        SELECT substring(goodsid,1,7) as goodsid, ");
			buffer.append("                       brandName as goodsname, ");
			buffer.append("                       categoryid, ");
			buffer.append("                       categoryname, ");
			buffer.append("                       supplierid, ");
			buffer.append("                       suppliername, ");
			buffer.append("                       sum(quantity) as quantity, ");
			if ("yes".equals(Utility.getName(po.getBrandGroup()))){
				buffer.append("                   retailPrice as retailPrice, ");
			}
			buffer.append("                       warehouseid from ( ");
		}		
		buffer.append("       SELECT goodsid, ");
		buffer.append("                       goodsname, ");
		buffer.append("                       categoryid, ");
		buffer.append("                       categoryname, ");
		buffer.append("                       supplierid, ");
		buffer.append("                       suppliername, ");
		buffer.append("                       spec, ");
		buffer.append("                       color, ");
		buffer.append("                       ds, ");
		buffer.append("                       dc, ");
		buffer.append("                       framesize, ");
		buffer.append("                       sum(quantity) as quantity,B_BD_brandName as brandName, ");
		if ("yes".equals(Utility.getName(po.getBrandGroup()))){
			buffer.append("                   B_GI_RetailPrice as retailPrice, ");
		}
		buffer.append("                       warehouseid ");
		buffer.append("                FROM   (SELECT B_GI_GoodsID              AS goodsid, ");
		buffer.append("                               B_GI_ViewGoodsName            AS goodsname, ");
		buffer.append("                               B_GC_ID                   AS categoryid, ");
		buffer.append("                               B_GC_GoodsCategoryName    AS categoryname, ");
		buffer.append("                               B_GI_SupplierID           AS supplierid, ");
		buffer.append("                               B_SP_SupplierName         AS suppliername, ");
		buffer.append("                               B_GI_Spec                 AS spec, ");
		buffer.append("                               B_GI_Color                AS color, ");
		buffer.append("                               B_GI_Sph                  AS ds, ");
		buffer.append("                               B_GI_Cyl                  AS dc, ");
		buffer.append("                               B_GI_FrameSize            AS framesize,B_BD_brandName as B_BD_brandName, ");
		buffer.append("                               Isnull(temp1.quantity, 0) AS quantity, ");
		buffer.append("                               temp1.stockid             AS warehouseid, ");
		if ("yes".equals(Utility.getName(po.getBrandGroup()))){
			buffer.append("                   B_GI_RetailPrice as B_GI_RetailPrice, ");
		}
		buffer.append("                               B_WH_warehouseName        AS warehousename ");
		buffer.append("                        FROM   dbo.B_GoodsInfo ");
		buffer.append("                               INNER JOIN (SELECT goodsid       AS goodsid, ");
		buffer.append("                                                  stockid       AS stockid, ");
		buffer.append("                                                  SUM(quantity) AS quantity ");
		buffer.append("                                           FROM   (SELECT C_SH_SC_GoodsId       AS goodsid, ");
		buffer.append("                                                          C_SH_SC_StockId       AS stockid, ");
		buffer.append("                                                          C_SH_SC_GoodsQuantity AS quantity ");
		buffer.append("                                                   FROM   dbo.C_SH_StorageChange ");
		buffer.append("                                                          INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                                            ON C_SH_SC_StockId = B_WH_ID ");
		
		buffer.append("                                                   WHERE  1=1 ");
		if(!"2".equals(Utility.getName(po.getIsclosed()))){
			buffer.append("                                                   and dbo.B_Warehouse.B_WH_IsClosed = '"+po.getIsclosed()+"' ");
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				buffer.append(" and C_SH_SC_StockId in ( '" + array[0] + "' ");
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,'" + array[i] + "' ");
				}
				buffer.append(" ) ");
			}
		}
		
		buffer.append("                                                   UNION ALL ");
		buffer.append("                                                   SELECT C_SH_SB_GoodsId       AS goodsid, ");
		buffer.append("                                                          C_SH_SB_StockId       AS stockid, ");
		buffer.append("                                                          C_SH_SB_GoodsQuantity AS quantity ");
		buffer.append("                                                   FROM   dbo.C_SH_StorageBeginning ");
		buffer.append("                                                          INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                                            ON C_SH_SB_StockId = B_WH_ID ");
		
		buffer.append("                                                   WHERE  1=1 ");
		if(!"2".equals(Utility.getName(po.getIsclosed()))){
			buffer.append("                                                   and dbo.B_Warehouse.B_WH_IsClosed = '"+po.getIsclosed()+"' ");
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				buffer.append(" and C_SH_SB_StockId in ( '" + array[0] + "' ");
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,'" + array[i] + "' ");
				}
				buffer.append(" ) ");
			}
		}
		
		buffer.append("                                           ) TEMP GROUP  BY goodsid, ");
		buffer.append("                                                     stockid) temp1 ");
		buffer.append("                                 ON B_GI_GoodsID = temp1.goodsid ");
		buffer.append("                               INNER JOIN dbo.B_Supplier ");
		buffer.append("                                 ON B_GI_SupplierID = B_SP_ID ");
		buffer.append("                               INNER JOIN dbo.B_Warehouse ");
		buffer.append("                                 ON temp1.stockid = B_WH_ID ");
		buffer.append("                               INNER JOIN B_GoodsCategory ");
		buffer.append("                                 ON B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("                               inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");

		buffer.append(" and B_GI_SupplierID<>'ZZ' ");
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
			buffer.append(" and B_GI_AccessoriesType = '"+po.getBgiaccessoriestype()+"' ");
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsID like'%"+po.getBgigoodsid()+"%'");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like'%"+po.getBgigoodsbarcode()+"%'");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%"+po.getBgigoodsname()+"%'");
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsCategoryID='"+po.getBgigoodscategoryid()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_SupplierID='"+po.getBgisupplierid()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_BrandID='"+po.getBgibrandid()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
			buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)='" + po.getBgiallbrandid() + "'");
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			buffer.append(" and B_GI_isCustomize='"+po.getBgiiscustomize()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>="+po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<="+po.getBgiretailendprice());
		}
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			buffer.append(" and B_GI_Flag= '"+po.getBgiflag()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			buffer.append(" and B_GI_OtherGoodsBigClass='"+po.getBgiothergoodsbigclass()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			buffer.append(" and B_GI_OtherGoodsSmallClass='"+po.getBgiothergoodssmallclass()+"'");
		}
		
		if(!"".equals(Utility.getName(po.getJxfs()))){
			String[] array = Utility.getName(po.getJxfs()).split(",");
			buffer.append(" and B_BD_Settlement in ( '" + array[0] + "' ");
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,'" + array[i] + "' ");
			}
			buffer.append(" ) ");
		}	
		/*-----------------------------新条件 2012/11/06----------------------------*/
	
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			buffer.append(" and B_GI_SupplierSpec like '%' + '"+po.getBgispec()+"' + '%' ");
		}
		
		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			buffer.append(" and B_GI_SupplierColor like '%' + '"+po.getBgicolor()+"' + '%' ");
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
			buffer.append(" and B_GI_BrandYear = '"+po.getBgibrandyear()+"' ");
		}
		
		if (!"".equals(Utility.getName(po.getBgiframesize()))) {
			buffer.append(" and B_GI_FrameSize = '"+po.getBgiframesize()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			buffer.append(" and B_GI_isMutiLuminosity = '"+po.getBgiismutiluminosity()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			buffer.append(" and B_GI_EyeGlassMaterialType = '"+po.getBgieyeglassmaterialtype()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			buffer.append(" and B_GI_Refractive = '"+po.getBgirefractive()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getMaxSph()))) {
			buffer.append(" and B_GI_Sph <= cast( '"+po.getMaxSph()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getMinSph()))) {
			buffer.append(" and B_GI_Sph >= cast( '"+po.getMinSph()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getMaxCyl()))) {
			buffer.append(" and B_GI_Cyl <= cast( '"+po.getMaxCyl()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getMinCyl()))) {
			buffer.append(" and B_GI_Cyl >= cast( '"+po.getMinCyl()+"' as float) ");
		}
		
		if (!"".equals(Utility.getName(po.getBgiusetype()))) {
			buffer.append(" and B_GI_UseType = '"+po.getBgiusetype()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
			buffer.append(" and B_GI_StealthClass = '"+po.getBgistealthclass()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			buffer.append(" and B_GI_frameProcessCraftType = '"+po.getBgitechnologytypeid()+"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			buffer.append(" and B_GI_FrameMaterialType = '"+po.getBgiframematerialtype()+"'");
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		/*-----------------------------新条件 2012/11/06----------------------------*/
		buffer.append(")c group by goodsid,goodsname,categoryid,categoryname,supplierid,suppliername,spec,color,ds,dc,framesize,B_BD_brandName,warehouseid ");
		if ("yes".equals(Utility.getName(po.getBrandGroup()))){
			buffer.append("  ,B_GI_RetailPrice ");
		}
		
		if ("brand".equals(Utility.getName(po.getQueryType()))){
			buffer.append(")c group by substring(goodsid,1,7),brandName,categoryid,categoryname,supplierid,suppliername,warehouseid ");
			if ("yes".equals(Utility.getName(po.getBrandGroup()))){
				buffer.append("  ,retailPrice ");
			}
		}
				
		if("2".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) < 0");
		}
		else if("3".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) > 0");
		}
		else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) <> 0");
		}
		else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))){
			buffer.append(" having sum(quantity) = 0");
		}
		
		buffer.append(" ) a PIVOT (MAX(quantity)  FOR warehouseid IN ("+widstr+")) b )TEMP ");
		buffer.append(" where rowNum > " + start + " and rowNum <= " + countPage + " ORDER BY goodsid ");
		buffer.append(" set rowcount 0");
		
		return getRsList(buffer.toString());
	
	}
	
	/**
	 * 获取库存详细查询的list
	 * 沈兴贺 2011-4-28
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchDetailsList(GoodsDetailsInfoPo po,PersonInfoPo personInfoPo,int start,
			int size) {

		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ");
		buffer.append("(select ROW_NUMBER() Over (order by table1.sxhGoodsId) as rowNum, * from ( select * from (select C_SH_SL_GoodsBarCode as sxhGoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId as sxhGoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName as sxhGoodsName, ");	//商品名称  条件4
		buffer.append("B_GC_GoodsCategoryName as sxhGoodsCategoryName, ");	//商品类别
		buffer.append("B_SP_SupplierName as sxhSupplierName, ");	//制造商名称
		buffer.append("B_GI_RetailPrice as sxhRetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName as sxhWarehouseName,  ");	//仓库名称
		buffer.append("sum(C_SH_SL_GoodsQuantity) as sxhsumnum,");  	//数量 条件8
		buffer.append("B_GI_GoodsCategoryID as sxhGoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID as sxhSupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID as sxhBrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId as sxhStockID, 	");//仓位ID 条件7
		buffer.append("B_BD_brandName as sxhbrandName "); //品种名称
		buffer.append("from C_SH_StorageLog  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("inner join B_Brand on B_BD_ID = B_GI_BrandID and B_BD_SupplierID = B_GI_SupplierID ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0' ");
		buffer.append("group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,B_SP_SupplierName,B_GI_ViewGoodsName,B_GC_GoodsCategoryName,B_GI_RetailPrice,B_WH_warehouseName,B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,C_SH_SL_StockId,B_BD_brandName) table2 ");
		buffer.append("where 1=1 and sxhsumnum<>0 ");
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append("and sxhGoodsId like '%"+po.getSxhGoodsId().toString()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and sxhGoodsBarCode like '%"+po.getSxhGoodsBarCode().toString()+"%'  ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and sxhGoodsCategoryID = ? ");
			params.add(po.getSxhGoodsCategoryID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsName()))){
			buffer.append(" and sxhGoodsName like '%"+po.getSxhGoodsName()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and sxhSupplierID = ? ");
			params.add(po.getSxhSupplierID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and sxhBrandID = ? ");
			params.add(po.getSxhBrandID());
		}

		if ("1".equals(Utility.getName(personInfoPo.getDepartmenttype()))||"2".equals(Utility.getName(personInfoPo.getDepartmenttype()))) {
			buffer.append(" and sxhStockID in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(personInfoPo.getDepartmentID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append(" and sxhStockID = ? ");
			params.add(po.getSxhStockID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhRetailPrice()))){
			buffer.append(" and sxhRetailPrice = ? "); 
			params.add(po.getSxhRetailPrice());
		}
		
		
		if(!"".equals(Utility.getName(po.getSxhsumnum()))&&!"".equals(Utility.getName(po.getSxhsumnums()))){
			buffer.append(" and sxhsumnum >= ? and sxhsumnum<=?");
			params.add(po.getSxhsumnum());
			params.add(po.getSxhsumnums());
		}
		buffer.append(" ) table1  ");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				GoodsDetailsInfoPo.class);
	}

	/**
	 * 获取库存综合查询(品种)的数量
	 * @param po 商品po
	 * @return int 数量
	 */		
	public Map<String, Object> getStockSearchBrandCount(GoodsInfoPo po) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
			List<String> params = new ArrayList<String>();
			StringBuffer  buffer = new StringBuffer();
	
			//查询人能查询的仓位插入临时表处理
			buffer.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
			buffer.append("DROP TABLE #stocktmp ");
			//sb.append("select * into #stocktmp from dbo.Strtotable('0,000,0000,0002,0003,0015,0004,0005,0006,0007,0008,0009,001,0010,0011,002,003,004,005,006,007,008,009,01,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,035,036,1111,8,9,997,999,0012,10,0013,0014,0017,0016,038,037,0001') ");
			buffer.append("select * into #stocktmp from dbo.Strtotable('");
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				List<WarehousePo> dList = po.getSmecistocklist();      
				buffer.append(Utility.getName(dList.get(0).getBwhid()));
				for (int i = 1; i < dList.size(); i++){
					buffer.append(","+ Utility.getName(dList.get(i).getBwhid()) +"");
				}
			}else{
				params.add("");
			}
			buffer.append("') ");
		//查询人能查询的仓位插入临时表处理
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组
			buffer.append("select count(GoodsId) as count , Isnull(sum(GoodsQuantity), 0) as titlenum from( select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as GoodsQuantity");

			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
			
			buffer.append(" from (select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
			
			buffer.append(" from (select C_SH_SB_GoodsId as GoodsId,C_SH_SB_GoodsQuantity as GoodsQuantity,C_SH_SB_StockId as warehouseid from C_SH_StorageBeginning ");
			buffer.append("                inner join #stocktmp on C_SH_SB_StockId =  #stocktmp.str2table ");
			
			buffer.append(" UNION ALL ");
			buffer.append(" SELECT C_SH_SC_GoodsId       AS GoodsId, ");
			buffer.append("        C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
			buffer.append("        C_SH_SC_StockId       AS warehouseid ");
			buffer.append(" FROM   C_SH_StorageChange ");
			buffer.append("                inner join #stocktmp on C_SH_SC_StockId =  #stocktmp.str2table ");			
			
			buffer.append(")a inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=a.GoodsId inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner join B_Warehouse on B_Warehouse.B_WH_ID=a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID  ");
	
			//-------------------------------合并------------------------
			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}


			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getJxfs()))) {
				buffer.append(" and B_BD_Settlement = ? ");
				params.add(po.getJxfs());
			}	
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				buffer.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				buffer.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				buffer.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(" group by GoodsId,warehouseid ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
		
			buffer.append(" )b group by substring(GoodsId,1,7) ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}

			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)=0");
			}
			buffer.append(" )c ");
			
		}else{
			
			//查询条件选择的仓位插入临时表处理
				if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
					buffer.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
					buffer.append("DROP TABLE #stocktmp1 ");
					buffer.append("select * into #stocktmp1 from dbo.Strtotable('");
					
					String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
					buffer.append(array[0]);
					for (int i = 1; i < array.length; i++){
						buffer.append(","+ array[i] +"");
					}
					buffer.append("') ");
				}
			//查询条件选择的仓位插入临时表处理
			
			buffer.append("select count(GoodsId) as count , Isnull(sum(GoodsQuantity), 0) as titlenum from( select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",RetailPrice as RetailPrice ");
			}
			
			buffer.append(" from ( select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid");	

			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice as RetailPrice ");
			}
						
			buffer.append(" from (select GoodsId,GoodsQuantity,warehouseid");

			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice as B_GI_RetailPrice ");
			}
			
			buffer.append(" from (select C_SH_SB_GoodsId as GoodsId,C_SH_SB_GoodsQuantity as GoodsQuantity,C_SH_StorageBeginning.C_SH_SB_StockId as warehouseid from C_SH_StorageBeginning ");
			buffer.append("                inner join #stocktmp on C_SH_SB_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append("                inner join #stocktmp1 on C_SH_SB_StockId = #stocktmp1.str2table ");
			}
			
			buffer.append("union all select C_SH_SC_GoodsId as GoodsId,C_SH_SC_GoodsQuantity as GoodsQuantity,C_SH_StorageChange.C_SH_SC_StockId as warehouseid from C_SH_StorageChange ");
			buffer.append("                inner join #stocktmp on C_SH_SC_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append("                inner join #stocktmp1 on C_SH_SC_StockId = #stocktmp1.str2table ");
			}
			
			buffer.append(")a inner join B_GoodsInfo on B_GI_GoodsID=GoodsId inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner join B_Warehouse on B_Warehouse.B_WH_ID=a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			
			//-------------------------------合并------------------------
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				buffer.append(" where B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				buffer.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				buffer.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}	
			
			if(!"".equals(Utility.getName(po.getJxfs()))){
				buffer.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			
			buffer.append(")b group by substring(GoodsId,1,7),warehouseid ");	
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
			
			buffer.append(" )c where 1=1 ");
			
			buffer.append(" group by GoodsId,warehouseid ");
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",RetailPrice ");
			}
			
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)=0");
			}
			buffer.append(" )c1 ");
					
		}
		
		buffer.append(" DROP TABLE #stocktmp1 ");	
		buffer.append(" DROP TABLE #stocktmp ");
		
		
		return getJdbcTemplate().queryForMap(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取库存综合查询(品种)的数量
	 * @param po 商品po
	 * @return int 数量
	 */		
	public Map<String, Object> getStockSearchBrandAnyTimeCount(GoodsInfoPo po) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();

		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组
			buffer.append("select count(GoodsId) as count , sum(GoodsQuantity) as titlenum from( select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as GoodsQuantity");

			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
			
			buffer.append(" from (select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
			
			buffer.append(" from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,C_SH_SL_StockId as warehouseid from C_SH_StorageLog where 1=1 ");
			
			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				buffer.append(" and C_SH_SL_StockId in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				buffer.append(" ) ");
			}
						
			buffer.append(")a inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=a.GoodsId inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner join B_Warehouse on B_Warehouse.B_WH_ID=a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID  ");
	
			//-------------------------------合并------------------------
			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(" group by GoodsId,warehouseid ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
		
			buffer.append(" )b group by substring(GoodsId,1,7) ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}

			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)=0");
			}
			buffer.append(" )c ");
			
		}else{
			buffer.append("select count(GoodsId) as count , sum(GoodsQuantity) as titlenum from( select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid");
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",RetailPrice as RetailPrice");
			}
			buffer.append(" from ( select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid");	

			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice as RetailPrice ");
			}
						
			buffer.append(" from (select GoodsId,GoodsQuantity,warehouseid");

			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice as B_GI_RetailPrice ");
			}
			
			buffer.append(" from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,C_SH_StorageLog.C_SH_SL_StockId as warehouseid from C_SH_StorageLog where 1=1 ");
			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			buffer.append(")a inner join B_GoodsInfo on B_GI_GoodsID=GoodsId left join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner join B_Warehouse on B_Warehouse.B_WH_ID=a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			
			//-------------------------------合并------------------------
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				buffer.append(" where B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(")b group by substring(GoodsId,1,7),warehouseid ");	
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",B_GI_RetailPrice");
			}
			
			buffer.append(" )c where 1=1 ");
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				buffer.append(" and warehouseid in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				buffer.append(" ) ");
			}
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and warehouseid in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			
			buffer.append(" group by GoodsId,warehouseid ");
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",RetailPrice");
			}		
			
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)=0");
			}
			buffer.append(" )c1 ");
						
		}
		return getJdbcTemplate().queryForMap(buffer.toString(), params.toArray());
	}
	/**
	 * 获取库存综合查询(品种)的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchBrandList(GoodsInfoPo po,int start, int size) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		//查询人能查询的仓位插入临时表处理
		buffer.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp') and type='U')");
		buffer.append("DROP TABLE #stocktmp ");
		//buffer.append("select * into #stocktmp from dbo.Strtotable('0,000,0000,0002,0003,0015,0004,0005,0006,0007,0008,0009,001,0010,0011,002,003,004,005,006,007,008,009,01,010,011,012,013,014,015,016,017,018,019,020,021,022,023,024,025,026,027,028,029,030,031,032,033,035,036,1111,8,9,997,999,0012,10,0013,0014,0017,0016,038,037,0001') ");
		buffer.append("select * into #stocktmp from dbo.Strtotable('");
		if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
			List<WarehousePo> dList = po.getSmecistocklist();      
			buffer.append(Utility.getName(dList.get(0).getBwhid()));
			for (int i = 1; i < dList.size(); i++){
				buffer.append(","+ Utility.getName(dList.get(i).getBwhid()) +"");
			}
		}else{
			params.add("");
		}
		buffer.append("') ");
		
		//查询条件选择的仓位插入临时表处理
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			buffer.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
			buffer.append("DROP TABLE #stocktmp1 ");
			buffer.append("select * into #stocktmp1 from dbo.Strtotable('");
			
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			buffer.append(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(","+ array[i] +"");
			}
			buffer.append("') ");
		}
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		//查询人能查询的仓位插入临时表处理
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组		
			buffer.append("SELECT * from ( ");
			buffer.append("		SELECT Row_number() OVER(ORDER BY bgibrandid) AS rowNum, ");
			buffer.append("       bgibrandid, ");
			buffer.append("       GoodsQuantity as bgigoodsquantity, ");
			buffer.append("       B_Supplier.B_SP_SupplierName           AS bgisuppliername, ");
			buffer.append("       B_Brand.B_BD_brandName                 AS bgibrandname, ");
			buffer.append("       B_GoodsCategory.B_GC_GoodsCategoryName AS bgigoodscategoryname ");
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice as bgiretailprice ");
			}
			buffer.append("FROM   (SELECT bgibrandid ");
			buffer.append("               ,SUM(GoodsQuantity)                  AS GoodsQuantity ");
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice     AS bgiretailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea     AS bgiretailprice ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec     AS bgiretailprice ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced     AS bgiretailprice ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee     AS bgiretailprice ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef     AS bgiretailprice ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei     AS bgiretailprice ");
				}
			}
			buffer.append("        FROM   (SELECT C_SH_SB_GoodsId                       AS GoodsId, ");
			buffer.append("                       Substring(C_SH_SB_GoodsId, 1, 7)      AS bgibrandid, ");
			buffer.append("                       C_SH_SB_GoodsQuantity                 AS GoodsQuantity ");
			buffer.append("                FROM   C_SH_StorageBeginning ");
			buffer.append("                inner join #stocktmp on C_SH_SB_StockId = #stocktmp.str2table ");
			buffer.append("                WHERE  1 = 1 ");

			buffer.append("                UNION ALL ");
			buffer.append("                SELECT C_SH_SC_GoodsId                    AS GoodsId, ");
			buffer.append("                       Substring(C_SH_SC_GoodsId, 1, 7)   AS bgibrandid, ");
			buffer.append("                       C_SH_SC_GoodsQuantity              AS GoodsQuantity ");
			buffer.append("                FROM   C_SH_StorageChange ");
			buffer.append("                inner join #stocktmp on C_SH_SC_StockId = #stocktmp.str2table ");
			buffer.append("                WHERE  1 = 1 ");
			
			buffer.append("               )a ");
			buffer.append("               INNER JOIN B_GoodsInfo ");
			buffer.append("                 ON B_GI_GoodsID = GoodsId ");
			
			buffer.append("        WHERE  1=1 ");
			
			buffer.append("               AND B_GI_SupplierID <> 'ZZ' ");
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}

			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				buffer.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				buffer.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			buffer.append("        GROUP  BY bgibrandid ");
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei ");
				}
			}
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)=0");
			}
			buffer.append("        )b ");
			
			buffer.append("       INNER JOIN B_GoodsCategory ");
			buffer.append("         ON Substring(bgibrandid, 1, 1) = B_GoodsCategory.B_GC_ID ");
			buffer.append("       INNER JOIN B_Supplier ");
			buffer.append("         ON Substring(bgibrandid, 3, 2) = B_Supplier.B_SP_ID ");
			buffer.append("       INNER JOIN B_Brand ");
			buffer.append("         ON Substring(bgibrandid, 6, 2) = B_Brand.B_BD_ID ");
			buffer.append("            AND Substring(bgibrandid, 3, 2) = B_Brand.B_BD_SupplierID ");
			buffer.append("WHERE  1=1 ");
			if(!"".equals(Utility.getName(po.getJxfs()))){
				buffer.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			buffer.append(" )c");
			buffer.append(" WHERE rowNum > " + start + " and rowNum <= "	+ countPage);
			buffer.append("ORDER  BY bgibrandid");

		}else{
			
			//查询条件选择的仓位插入临时表处理
			
			buffer.append("SELECT * from ( ");
			buffer.append("SELECT Row_number() OVER(ORDER BY bgibrandid) AS rowNum, ");
			buffer.append("       bgibrandid, ");
			buffer.append("       GoodsQuantity as bgigoodsquantity, ");
			buffer.append("       warehouseid as bgiwarehouseid, ");
			buffer.append("       B_Supplier.B_SP_SupplierName           AS bgisuppliername, ");
			buffer.append("       B_Brand.B_BD_brandName                 AS bgibrandname, ");
			buffer.append("       B_Warehouse.B_WH_warehouseName         AS bgiwarehousename, ");
			buffer.append("       B_GoodsCategory.B_GC_GoodsCategoryName AS bgigoodscategoryname ");
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice as bgiretailprice ");
			}
			buffer.append("FROM   (SELECT bgibrandid ");
			buffer.append("               ,SUM(GoodsQuantity)                  AS GoodsQuantity ");
			buffer.append("               ,warehouseid ");
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice     AS bgiretailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea     AS bgiretailprice ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec     AS bgiretailprice ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced     AS bgiretailprice ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee     AS bgiretailprice ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef     AS bgiretailprice ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei     AS bgiretailprice ");
				}
			}
			buffer.append("        FROM   (SELECT C_SH_SB_GoodsId                       AS GoodsId, ");
			buffer.append("                       Substring(C_SH_SB_GoodsId, 1, 7)      AS bgibrandid, ");
			buffer.append("                       C_SH_SB_GoodsQuantity                 AS GoodsQuantity, ");
			buffer.append("                       C_SH_SB_StockId AS warehouseid ");
			buffer.append("                FROM   C_SH_StorageBeginning ");
			buffer.append("                inner join #stocktmp on C_SH_SB_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append("                inner join #stocktmp1 on C_SH_SB_StockId = #stocktmp1.str2table ");
			}
			
			buffer.append("                UNION ALL ");
			buffer.append("                SELECT C_SH_SC_GoodsId                    AS GoodsId, ");
			buffer.append("                       Substring(C_SH_SC_GoodsId, 1, 7)   AS bgibrandid, ");
			buffer.append("                       C_SH_SC_GoodsQuantity              AS GoodsQuantity, ");
			buffer.append("                       C_SH_SC_StockId AS warehouseid ");
			buffer.append("                FROM   C_SH_StorageChange ");
			buffer.append(" 			   inner join #stocktmp on C_SH_SC_StockId = #stocktmp.str2table ");
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append("                inner join #stocktmp1 on C_SH_SC_StockId = #stocktmp1.str2table ");
			}

			buffer.append("                )a ");
			buffer.append("               INNER JOIN B_GoodsInfo ");
			buffer.append("                 ON B_GI_GoodsID = GoodsId ");
			
			buffer.append("        WHERE  1=1 ");
			buffer.append("               AND B_GI_SupplierID <> 'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiallbrandid()))) {
				buffer.append(" and substring(B_GoodsInfo.B_GI_GoodsID,1,7)=?");
				params.add(po.getBgiallbrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}

			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}

			//零售价条件
			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			//零售价条件
			
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}

			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize = ? ");
				params.add(po.getBgiiscustomize());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				buffer.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				buffer.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			buffer.append("        GROUP  BY bgibrandid ");
			buffer.append("                  ,warehouseid ");
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei ");
				}
			}
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(GoodsQuantity)=0");
			}
			buffer.append("        )b ");
			
			buffer.append("       INNER JOIN B_GoodsCategory ");
			buffer.append("         ON Substring(bgibrandid, 1, 1) = B_GoodsCategory.B_GC_ID ");
			buffer.append("       INNER JOIN B_Supplier ");
			buffer.append("         ON Substring(bgibrandid, 3, 2) = B_Supplier.B_SP_ID ");
			buffer.append("       INNER JOIN B_Brand ");
			buffer.append("         ON Substring(bgibrandid, 6, 2) = B_Brand.B_BD_ID ");
			buffer.append("            AND Substring(bgibrandid, 3, 2) = B_Brand.B_BD_SupplierID ");
			buffer.append("       INNER JOIN B_Warehouse ");
			buffer.append("         ON B_Warehouse.B_WH_ID = warehouseid ");
			buffer.append("WHERE  1=1 ");
			if(!"".equals(Utility.getName(po.getJxfs()))){
				buffer.append(" and B_BD_Settlement in ( ? ");
				
				String[] array = Utility.getName(po.getJxfs()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				buffer.append("       AND B_WH_IsClosed = ? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			buffer.append(" )c ");
			buffer.append("WHERE rowNum > " + start + " and rowNum <= "	+ countPage);
			buffer.append("ORDER  BY bgibrandid,bgiwarehouseid ");
			
		}
		
		buffer.append(" DROP TABLE #stocktmp1 ");
		buffer.append(" DROP TABLE #stocktmp ");
		buffer.append(" set rowcount 0");
		return queryForObjectList(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	/**
	 * 获取库存综合查询(品种)的list
	 * @param po 商品po
	 * @param start
	 * @param size 
	 * @return list 商品list
	 */	
	public List<GoodsInfoPo> getStockSearchBrandAnyTimeList(GoodsInfoPo po,int start, int size) {

		//po.getCstcpodid() 代表是否考虑仓位：2不进行仓位的分组 ；0：开启仓位分组 ；1：关闭仓位分组
		List<String> params = new ArrayList<String>();
		StringBuffer  buffer = new StringBuffer();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组			
			buffer.append("select temp.bgisuppliername as bgisuppliername,");
			buffer.append("temp.GoodsId as bgibrandid,temp.bgibrandname as bgibrandname,");
			buffer.append("temp.bgigoodsquantity as bgigoodsquantity,");
			buffer.append("temp.bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice as bgiretailprice ");
			}
			
			buffer.append(" from ( ");
			buffer.append("select ROW_NUMBER() Over(order by GoodsId) as rowNum,temp.bgisuppliername as bgisuppliername,");
			buffer.append("temp.GoodsId as GoodsId,temp.bgibrandname as bgibrandname,");
			buffer.append("sum(temp.GoodsQuantity) as bgigoodsquantity,");
			buffer.append("temp.bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice as bgiretailprice ");
			}
			
			buffer.append(" from ( select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as GoodsQuantity, ");
			buffer.append("bgisuppliername as bgisuppliername,");
			buffer.append("bgibrandid as bgibrandid,bgibrandname as bgibrandname,");			
			buffer.append("bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice as bgiretailprice");
			}
			
			buffer.append(" from ( select GoodsId,GoodsQuantity,warehouseid, ");  // a 
			buffer.append("B_Supplier.B_SP_SupplierName as bgisuppliername,");
			buffer.append("B_Brand.B_BD_ID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,");			
			buffer.append("B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname  ");	
			
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice     AS bgiretailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea     AS bgiretailprice ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec     AS bgiretailprice ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced     AS bgiretailprice ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee     AS bgiretailprice ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef     AS bgiretailprice ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei     AS bgiretailprice ");
				}
			}
			
			buffer.append(" from (select C_SH_SL_GoodsId as GoodsId,sum(C_SH_SL_GoodsQuantity) as GoodsQuantity,C_SH_SL_StockId as warehouseid from C_SH_StorageLog where 1=1 ");
		
			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				buffer.append(" and C_SH_SL_StockId in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				buffer.append(" ) ");
			}			
			
			buffer.append(" group by C_SH_SL_GoodsId,C_SH_SL_StockId ");			
				
			buffer.append("  )a inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=a.GoodsId inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner join B_Warehouse on B_Warehouse.B_WH_ID=a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID where 1=1 ");			
			
			//-------------------------------合并------------------------
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(" )b group by substring(GoodsId,1,7),bgisuppliername,bgibrandid,bgibrandname,bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice");
			}
			
			buffer.append(" )temp group by temp.GoodsId,bgisuppliername,bgibrandname,bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice");
			}
			
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)=0");
			}
			buffer.append(" )temp where rowNum > " + start + " and rowNum <= "	+ countPage);
			buffer.append(" set rowcount 0");
			
		}else{
			buffer.append("select temp.bgisuppliername as bgisuppliername,");
			buffer.append("temp.bgibrandid as bgibrandid,temp.bgibrandname as bgibrandname,");
			buffer.append("temp.bgigoodsquantity as bgigoodsquantity,");
			buffer.append("temp.bgiwarehousename as bgiwarehousename,temp.bgigoodscategoryname as bgigoodscategoryname,temp.bgiwarehouseid as bgiwarehouseid");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice as bgiretailprice ");
			}
			
			buffer.append(" from(select ROW_NUMBER() Over(order by GoodsId) as rowNum,");
			buffer.append(" temp.bgisuppliername as bgisuppliername,");
			buffer.append("temp.GoodsId as bgibrandid,temp.bgibrandname as bgibrandname,");
			buffer.append("sum(temp.bgigoodsquantity) as bgigoodsquantity,");
			buffer.append("temp.bgiwarehousename as bgiwarehousename,temp.bgigoodscategoryname as bgigoodscategoryname,temp.bgiwarehouseid as bgiwarehouseid ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice as bgiretailprice");
			}
			
			buffer.append(" from( select GoodsId as GoodsId ,");   // c
			buffer.append("bgisuppliername as bgisuppliername,");
			buffer.append("warehouseid as bgiwarehouseid,");
			buffer.append("bgibrandid as bgibrandid,bgibrandname as bgibrandname,");
			buffer.append("isnull(bgigoodsquantity,0) as bgigoodsquantity,");
			buffer.append("bgiwarehousename as bgiwarehousename,bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice as bgiretailprice");
			}
			
			buffer.append(" from(select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as bgigoodsquantity,warehouseid as warehouseid,bgisuppliername as bgisuppliername,bgibrandid as bgibrandid,bgibrandname as bgibrandname,bgiwarehousename as bgiwarehousename,bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice ");
			}
			
			buffer.append(" from (select GoodsId,GoodsQuantity,warehouseid, "); // a
			buffer.append("B_Supplier.B_SP_SupplierName as bgisuppliername,");
			buffer.append("B_Brand.B_BD_ID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,");
			buffer.append("B_Warehouse.B_WH_warehouseName as bgiwarehousename,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");			
			
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice     AS bgiretailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea     AS bgiretailprice ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec     AS bgiretailprice ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced     AS bgiretailprice ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee     AS bgiretailprice ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef     AS bgiretailprice ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei     AS bgiretailprice ");
				}
			}
			
			buffer.append(" from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,");			
			buffer.append("C_SH_StorageLog.C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
			buffer.append("where 1=1  ");
			if(!"".equals(Utility.getName(po.getStockQueryBeginDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)>= ? ");
				params.add(po.getStockQueryBeginDate());
			}
			if(!"".equals(Utility.getName(po.getStockQueryEndDate()))){
				buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)<= ? ");
				params.add(po.getStockQueryEndDate());
			}
			buffer.append(" )a inner join B_GoodsInfo on B_GI_GoodsID=GoodsId left join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner JOIN B_Warehouse ON B_Warehouse.B_WH_ID = a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID where 1=1 ");
			
			//-------------------------------合并------------------------
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				buffer.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_SupplierSpec like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgispec()));
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_SupplierColor like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgicolor()));
			}
			
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				buffer.append(" and B_GI_BrandYear = ? ");
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(")b group by substring(GoodsId,1,7),warehouseid,bgisuppliername,bgibrandid,bgibrandname,bgiwarehousename,bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice");
			}
			
			buffer.append(" )c  where 1=1 ");
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				buffer.append(" and c.warehouseid in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				buffer.append(" ) ");
			}
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and warehouseid in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			
			buffer.append(" )temp group by temp.bgisuppliername,temp.GoodsId,temp.bgibrandname,temp.bgigoodscategoryname,temp.bgiwarehousename,temp.bgiwarehouseid ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice");
			}
			
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)=0");
			}
			
			buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
			buffer.append(" ORDER BY bgiwarehouseid DESC ");
			buffer.append(" set rowcount 0");
		}

		return queryForObjectList(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	/**
	 * 获取库存预警查询的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getStockAlertCount(GoodsInfoPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("SELECT count(B_GI_GoodsID) FROM C_SA_StockAlertSetting ");
		buffer.append("INNER JOIN B_GoodsInfo ON B_GI_GoodsID = C_SA_SA_GoodsID ");
		buffer.append("left join ( ");
		buffer.append("select ");
		buffer.append("GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid  ");
		buffer.append("from ");
		buffer.append(" (select C_SH_SB_GoodsId as GoodsId , C_SH_SB_GoodsQuantity as GoodsQuantity, ");
		buffer.append("0 as zaitu,");
		buffer.append("C_SH_SB_StockId as warehouseid ");
		buffer.append(" from C_SH_StorageBeginning ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" inner join B_Warehouse on C_SH_SB_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append(" where 1 = 1 ");
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and C_SH_SB_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append("union all  ");
		buffer.append("select C_SH_SC_GoodsId as GoodsId , C_SH_SC_GoodsQuantity as GoodsQuantity, ");
		buffer.append("0 as zaitu,");
		buffer.append("C_SH_SC_StockId as warehouseid ");
		buffer.append("from C_SH_StorageChange  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" inner join B_Warehouse on C_SH_SC_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append(" where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and C_SH_SC_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append("union all  ");
		buffer.append("select C_ST_PE_goodsID as GoodsId ,0,C_ST_PE_OrderNumber as zaitu,'' ");
		buffer.append("from C_ST_Po ");
		buffer.append("inner join C_ST_PoEntry on C_ST_PE_PurchaseOrderID = C_ST_P_ID left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID where C_ST_P_flag='0' and C_ST_P_AuditState='1'  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append(")a inner join B_Warehouse on a.warehouseid = B_WH_ID ");
		buffer.append("group by GoodsId,warehouseid)c ON C_SA_SA_GoodsID = c.goodsid and c.warehouseid=C_SA_SA_StockID ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" inner join B_Warehouse on C_SA_SA_StockID = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append("where B_GI_Flag='1'  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getAlerttype()))){
			if("4".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockRed,0)  ");
			}
			
			if("3".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockRed,0)  ");
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockLower,0)  ");
			}
			
			if("2".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockLower,0)  ");
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockCap,0)  ");
			}
			
			if("1".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockCap,0)  ");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GI_GoodsID like'%' + ? + '%' ");//quyanping
			params.add(po.getBgigoodsid());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}

		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(" and B_GI_GoodsCategoryID= ? ");
			params.add(po.getBgigoodscategoryid());

			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_isCustomize='0'");
			}
		}

		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(" and B_GI_SupplierID= '" + Utility.getName(po.getBgisupplierid()) + "' ");
		}

		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(" and B_GI_BrandID= '" + Utility.getName(po.getBgibrandid()) + "' ");
		}
		
		if ("1".equals(Utility.getName(po.getBgidepartmenttype()))||"2".equals(Utility.getName(po.getBgidepartmenttype()))) {
			buffer.append(" and C_SA_SA_StockID in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(po.getBgidepartmentid());
		}

		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and (C_SA_SA_StockID = ?) ");
			params.add(po.getBgiwarehouseid());
		}
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 获取库存预警查询的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getStockAlertList(GoodsInfoPo po, int start,
			int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select bgigoodsid as bgigoodsid,bgistorageredlimit as bgistorageredlimit,bgigoodsname as bgigoodsname , bgisuppliername as bgisuppliername ,alerttype as alerttype, ");
		buffer.append("bgisph as bgisph,bgicyl as bgicyl , bgiaxis as bgiaxis,bgicurvature1 as bgicurvature1 , bgidia as bgidia ,");
		buffer.append("bgispec as bgispec,bgicolor as bgicolor , bgibrandname as bgibrandname,bgitaxrate as bgitaxrate , bgigoodsbarcode as bgigoodsbarcode , ");
		buffer.append("bgiunitname as bgiunitname,bgicostprice as bgicostprice , bgiretailprice as bgiretailprice , bginottaxrate as bginottaxrate,");
		buffer.append("bgiflag as bgiflag , bgistorageupperlimit as bgistorageupperlimit , bgistoragelowerlimit as bgistoragelowerlimit , ");
		buffer.append("bgigoodsquantity as bgigoodsquantity, bgigoodscategoryid as bgigoodscategoryid , ");
		buffer.append("zaitu as zaitu, ");
		buffer.append("bgigoodscategoryname as bgigoodscategoryname,bgiwarehousename as bgiwarehousename from(");
		buffer.append("select ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum , B_GI_GoodsID as bgigoodsid ,");
		buffer.append("case ");
		buffer.append("when isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockRed,0) then '4' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockRed,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockLower,0) then '3' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockLower,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockCap,0)   then '2' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockCap,0) then '1' ");
		buffer.append("else '' ");
		buffer.append("end as alerttype, ");
		buffer.append("B_GI_ViewGoodsName as bgigoodsname ,B_SP_SupplierName as bgisuppliername , B_GI_Spec as bgispec,B_GI_Color as bgicolor ,");
		buffer.append("B_GI_Sph as bgisph,B_GI_Cyl as bgicyl ,B_GI_Axis as bgiaxis,B_GI_Curvature1 as bgicurvature1 ,B_GI_Dia as bgidia,");
		buffer.append("B_GI_TaxRate as bgitaxrate ,B_GI_GoodsBarCode as bgigoodsbarcode ,B_BD_brandName as bgibrandname,B_UT_unitName as bgiunitname ,");
		buffer.append("B_GI_RetailPrice as bgiretailprice,B_GI_CostPrice as bgicostprice ,B_GI_NotTaxRate as bginottaxrate,B_GI_Flag as bgiflag , ");
		buffer.append("C_SA_SA_StockCap as bgistorageupperlimit ,C_SA_SA_StockLower as bgistoragelowerlimit ,isnull(c.GoodsQuantity,0) as bgigoodsquantity");
		buffer.append(",isnull(zaitu, 0) as zaitu");
		buffer.append(",B_GI_GoodsCategoryID as bgigoodscategoryid, isnull(C_SA_SA_StockRed,0) as bgistorageredlimit,");
		buffer.append("B_GC_GoodsCategoryName as bgigoodscategoryname,B_WH_warehouseName as bgiwarehousename from C_SA_StockAlertSetting  ");
		buffer.append("INNER JOIN B_Warehouse on B_WH_ID=C_SA_SA_StockID ");
		buffer.append("INNER JOIN B_GoodsInfo ON B_GI_GoodsID = C_SA_SA_GoodsID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("left join B_Unit on B_GI_UnitId=B_UT_id inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("left join (select GoodsId, sum(GoodsQuantity) as GoodsQuantity, ");
		buffer.append("warehouseid,B_WH_warehouseName as warehousename,sum(zaitu) as zaitu from ( ");
		buffer.append("select C_SH_SB_GoodsId as GoodsId , C_SH_SB_GoodsQuantity as GoodsQuantity, ");
		buffer.append("0 as zaitu,");
		buffer.append("C_SH_SB_StockId as warehouseid ");
		buffer.append("from C_SH_StorageBeginning ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" inner join B_Warehouse on C_SH_SB_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append(" where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and C_SH_SB_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append("union all  ");
		buffer.append("select C_SH_SC_GoodsId as GoodsId , C_SH_SC_GoodsQuantity as GoodsQuantity, ");
		buffer.append("0 as zaitu,");
		buffer.append("C_SH_SC_StockId as warehouseid ");
		buffer.append("from C_SH_StorageChange  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" inner join B_Warehouse on C_SH_SC_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append(" where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and C_SH_SC_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append("union all  ");
		buffer.append("select C_ST_PE_goodsID as GoodsId ,0,C_ST_PE_OrderNumber as zaitu,");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" ? ");
			params.add(po.getBgiwarehouseid());
		}else
		{
			buffer.append(" '' ");
		}
		buffer.append("from C_ST_Po ");
		buffer.append("inner join C_ST_PoEntry on C_ST_PE_PurchaseOrderID = C_ST_P_ID left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID where C_ST_P_flag='0' and C_ST_P_AuditState='1'  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		buffer.append(")a inner join B_Warehouse on a.warehouseid = B_WH_ID ");
		buffer.append("group by GoodsId,warehouseid,B_WH_warehouseName)c on  B_GI_GoodsID=c.goodsid and c.warehouseid=C_SA_SA_StockID  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		buffer.append("where B_GI_Flag='1'  ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getAlerttype()))){
			if("4".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockRed,0)  ");
			}
			
			if("3".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockRed,0)  ");
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockLower,0)  ");
			}
			
			if("2".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockLower,0)  ");
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockCap,0)  ");
			}
			
			if("1".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockCap,0)  ");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_isCustomize='0'");
			}
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(" and B_GI_SupplierID= '" + Utility.getName(po.getBgisupplierid()) + "' ");
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(" and B_GI_BrandID= '" + Utility.getName(po.getBgibrandid()) + "' ");
		}
		
		if ("1".equals(Utility.getName(po.getBgidepartmenttype()))||"2".equals(Utility.getName(po.getBgidepartmenttype()))) {
			buffer.append(" and C_SA_SA_StockID in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(po.getBgidepartmentid());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and (C_SA_SA_StockID=?) ");
			params.add(po.getBgiwarehouseid());
		}
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 获取库存预警查询的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getStockAlertList(GoodsInfoPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 4 bgigoodsid as bgigoodsid,bgistorageredlimit as bgistorageredlimit,bgigoodsname as bgigoodsname , bgisuppliername as bgisuppliername ,alerttype as alerttype, ");
		buffer.append("bgisph as bgisph,bgicyl as bgicyl , bgiaxis as bgiaxis,bgicurvature1 as bgicurvature1 , bgidia as bgidia ,");
		buffer.append("bgispec as bgispec,bgicolor as bgicolor , bgibrandname as bgibrandname,bgitaxrate as bgitaxrate , bgigoodsbarcode as bgigoodsbarcode , ");
		buffer.append("bgiunitname as bgiunitname,bgicostprice as bgicostprice , bgiretailprice as bgiretailprice , bginottaxrate as bginottaxrate,");
		buffer.append("bgiflag as bgiflag , bgistorageupperlimit as bgistorageupperlimit , bgistoragelowerlimit as bgistoragelowerlimit , ");
		buffer.append("bgigoodsquantity as bgigoodsquantity, bgigoodscategoryid as bgigoodscategoryid , ");
		buffer.append("zaitu as zaitu, ");
		buffer.append("bgigoodscategoryname as bgigoodscategoryname,bgiwarehousename as bgiwarehousename from(");
		buffer.append("select ROW_NUMBER() Over(order by case when isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockRed,0) then '4' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockRed,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockLower,0) then '3' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockLower,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockCap,0)   then '2' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockCap,0) then '1' ");
		buffer.append("else '' ");
		buffer.append("end desc) as rowNum , B_GI_GoodsID as bgigoodsid ,");
		buffer.append("case ");
		buffer.append("when isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockRed,0) then '4' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockRed,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockLower,0) then '3' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockLower,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockCap,0)   then '2' ");
		buffer.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockCap,0) then '1' ");
		buffer.append("else '' ");
		buffer.append("end as alerttype, ");
		buffer.append("B_GI_ViewGoodsName as bgigoodsname ,B_SP_SupplierName as bgisuppliername , B_GI_Spec as bgispec,B_GI_Color as bgicolor ,");
		buffer.append("B_GI_Sph as bgisph,B_GI_Cyl as bgicyl ,B_GI_Axis as bgiaxis,B_GI_Curvature1 as bgicurvature1 ,B_GI_Dia as bgidia,");
		buffer.append("B_GI_TaxRate as bgitaxrate ,B_GI_GoodsBarCode as bgigoodsbarcode ,B_BD_brandName as bgibrandname,B_UT_unitName as bgiunitname ,");
		buffer.append("B_GI_RetailPrice as bgiretailprice,B_GI_CostPrice as bgicostprice ,B_GI_NotTaxRate as bginottaxrate,B_GI_Flag as bgiflag , ");
		buffer.append("C_SA_SA_StockCap as bgistorageupperlimit ,C_SA_SA_StockLower as bgistoragelowerlimit ,isnull(c.GoodsQuantity,0) as bgigoodsquantity");
		buffer.append(",isnull(zaitu, 0) as zaitu");
		buffer.append(",B_GI_GoodsCategoryID as bgigoodscategoryid, isnull(C_SA_SA_StockRed,0) as bgistorageredlimit,");
		buffer.append("B_GC_GoodsCategoryName as bgigoodscategoryname,B_WH_warehouseName as bgiwarehousename from C_SA_StockAlertSetting  ");
		buffer.append("INNER JOIN B_Warehouse on B_WH_ID=C_SA_SA_StockID ");
		buffer.append("INNER JOIN B_GoodsInfo ON B_GI_GoodsID = C_SA_SA_GoodsID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID=B_SP_ID inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");
		buffer.append("left join B_Unit on B_GI_UnitId=B_UT_id inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("left join (select GoodsId, sum(GoodsQuantity) as GoodsQuantity, ");
		buffer.append("warehouseid,B_WH_warehouseName as warehousename,sum(zaitu) as zaitu from ( ");
		buffer.append("select C_SH_SB_GoodsId as GoodsId , C_SH_SB_GoodsQuantity as GoodsQuantity, ");
		buffer.append("0 as zaitu,");
		buffer.append("C_SH_SB_StockId as warehouseid ");
		buffer.append("from C_SH_StorageBeginning ");
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" where C_SH_SB_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		buffer.append("union all  ");
		buffer.append("select C_SH_SC_GoodsId as GoodsId , C_SH_SC_GoodsQuantity as GoodsQuantity, ");
		buffer.append("0 as zaitu,");
		buffer.append("C_SH_SC_StockId as warehouseid ");
		buffer.append("from C_SH_StorageChange  ");
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" where C_SH_SC_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		buffer.append("union all  ");
		buffer.append("select C_ST_PE_goodsID as GoodsId ,0,C_ST_PE_OrderNumber as zaitu,");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" ? ");
			params.add(po.getBgiwarehouseid());
		}else
		{
			buffer.append(" '' ");
		}
		buffer.append("from C_ST_Po ");
		buffer.append("inner join C_ST_PoEntry on C_ST_PE_PurchaseOrderID = C_ST_P_ID where C_ST_P_flag='0' and C_ST_P_AuditState='1'  ");
		
		buffer.append(")a inner join B_Warehouse on a.warehouseid = B_WH_ID ");
		buffer.append("group by GoodsId,warehouseid,B_WH_warehouseName)c on  B_GI_GoodsID=c.goodsid and c.warehouseid=C_SA_SA_StockID  ");
		
		buffer.append("where B_GI_Flag='1'  ");
		
		if(!"".equals(Utility.getName(po.getAlerttype()))){
			if("4".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockRed,0)  ");
			}
			
			if("3".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockRed,0)  ");
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockLower,0)  ");
			}
			
			if("2".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockLower,0)  ");
				buffer.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockCap,0)  ");
			}
			
			if("1".equals(Utility.getName(po.getAlerttype()))){
				buffer.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockCap,0)  ");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_isCustomize='0'");
			}
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(" and B_GI_SupplierID= '" + Utility.getName(po.getBgisupplierid()) + "' ");
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(" and B_GI_BrandID= '" + Utility.getName(po.getBgibrandid()) + "' ");
		}
		
		if ("1".equals(Utility.getName(po.getBgidepartmenttype()))||"2".equals(Utility.getName(po.getBgidepartmenttype()))) {
			buffer.append(" and C_SA_SA_StockID in (select b_wh_id from b_warehouse where b_wh_deptid=? ) ");
			params.add(po.getBgidepartmentid());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			buffer.append(" and (C_SA_SA_StockID=?) ");
			params.add(po.getBgiwarehouseid());
		}
		buffer.append(" ) temp ");

		return queryForObjectList(buffer.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	
	/**
	 * 获取隐形效期查询的数量
	 * sxh 2012-08-30
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchInvisibleCount(GoodsDetailsInfoPo po) {

		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select isnull(count(*),0) as count,isnull(sum(sumnum),0) as titlenum from ( ");
		buffer.append("select C_SH_SL_GoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName , ");	//商品名称  条件4
		buffer.append("B_GC_GoodsCategoryName, ");	//商品类别
		buffer.append("B_SP_SupplierName, ");	//制造商名称
		buffer.append("B_GI_RetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName,  ");	//仓库名称
		buffer.append("sum(C_SH_SL_GoodsQuantity) as sumnum,");  	//数量 条件8
		buffer.append("C_SH_BC_GuaranteePeriod,");
		buffer.append("B_GI_GoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId 	");//仓位ID 条件7
		buffer.append("from C_SH_StorageLog_YX  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
		
		buffer.append("where C_SH_SL_GoodsQuantity <> '0' and B_GI_isCustomize = '0' ");

		if("0".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') <> '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') <> '' ");
		}

		if("1".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') <> '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') = '' ");
		}

		if("2".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') = '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') <> '' ");
		}

		if("3".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') = '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') = '' ");
		}
		
		if("1".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMax ");
		}
		
		if("2".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= B_GI_ReturnMax ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMin ");
		}
		
		if("3".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= B_GI_ReturnMin ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= 0 ");
		}
		
		if("4".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < 0 ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhmax()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) - B_GI_ReturnMax <= cast(? as float) ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMax ");
			params.add(po.getSxhmax());
		}
		
		if(!"".equals(Utility.getName(po.getSxhmin()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= cast(? as float) ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= 0 ");
			params.add(po.getSxhmin());
		}
		
		buffer.append("group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,B_SP_SupplierName,B_GI_ViewGoodsName,B_GC_GoodsCategoryName,B_GI_RetailPrice,B_WH_warehouseName,C_SH_BC_GuaranteePeriod,B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,C_SH_SL_StockId ");
		
		buffer.append(" union all ");
		buffer.append("select C_SH_SL_GoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName , ");	//商品名称  条件4
		buffer.append("B_GC_GoodsCategoryName, ");	//商品类别
		buffer.append("B_SP_SupplierName, ");	//制造商名称
		buffer.append("B_GI_RetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName,  ");	//仓库名称
		buffer.append("sum(C_SH_SL_GoodsQuantity) as sumnum,");  	//数量 条件8
		buffer.append("C_SH_BC_GuaranteePeriod,");
		buffer.append("B_GI_GoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId 	");//仓位ID 条件7
		buffer.append("from C_SH_StorageLog_HLY  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
		
		buffer.append("where C_SH_SL_GoodsQuantity <> '0' ");

		if("0".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') <> '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') <> '' ");
		}

		if("1".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') <> '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') = '' ");
		}

		if("2".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') = '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') <> '' ");
		}

		if("3".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(C_SH_BC_Batch, '') = '' AND ISNULL(C_SH_BC_GuaranteePeriod, '') = '' ");
		}
		
		if("1".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMax ");
		}
		
		if("2".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= B_GI_ReturnMax ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMin ");
		}
		
		if("3".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= B_GI_ReturnMin ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= 0 ");
		}
		
		if("4".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < 0 ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhmax()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) - B_GI_ReturnMax <= cast(? as float) ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMax ");
			params.add(po.getSxhmax());
		}
		
		if(!"".equals(Utility.getName(po.getSxhmin()))){
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= cast(? as float) ");
			buffer.append("and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= 0 ");
			params.add(po.getSxhmin());
		}
		
		buffer.append("group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,B_SP_SupplierName,B_GI_ViewGoodsName,B_GC_GoodsCategoryName,B_GI_RetailPrice,B_WH_warehouseName,C_SH_BC_GuaranteePeriod,B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,C_SH_SL_StockId ");
				
		buffer.append(" ) table1 where 1=1 and sumnum<>0 ");		
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append("and C_SH_SL_GoodsId like '%"+po.getSxhGoodsId().toString()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and C_SH_SL_GoodsBarCode like '%"+po.getSxhGoodsBarCode().toString()+"%'  ");
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(po.getSxhGoodsCategoryID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsName()))){
			buffer.append(" and B_GI_ViewGoodsName like '%"+po.getSxhGoodsName()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(po.getSxhSupplierID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(po.getSxhBrandID());
		}
		
		if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
			
			buffer.append(" and C_SH_SL_StockId in ( ? ");

			List<WarehousePo> dList = po.getSmecistocklist();
			params.add(Utility.getName(dList.get(0).getBwhid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBwhid()));
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append(" and C_SH_SL_StockId = ? ");
			params.add(Utility.getName(po.getSxhStockID()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhRetailPrice()))){
			buffer.append(" and B_GI_RetailPrice = ? ");
			params.add(po.getSxhRetailPrice());
		}
		
		if(!"".equals(Utility.getName(po.getSxhsumnum()))&&!"".equals(Utility.getName(po.getSxhsumnums()))){
			buffer.append(" and sumnum >= ? and sumnum<=?");
			params.add(po.getSxhsumnum());
			params.add(po.getSxhsumnums());
		}

		return getJdbcTemplate().queryForMap(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取隐形效期查询的list
	 * sxh 2012-08-30
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchInvisibleList(GoodsDetailsInfoPo po,int start,
			int size) {

		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ");
		buffer.append("(select ROW_NUMBER() Over (order by table1.sxhGoodsId) as rowNum, * from ( select * from (select C_SH_SL_GoodsBarCode as sxhGoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId as sxhGoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName as sxhGoodsName, ");	//商品名称  条件4
		buffer.append("B_GC_GoodsCategoryName as sxhGoodsCategoryName, ");	//商品类别
		buffer.append("B_SP_SupplierName as sxhSupplierName, ");	//制造商名称
		buffer.append("B_GI_RetailPrice as sxhRetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName as sxhWarehouseName,  ");	//仓库名称
		buffer.append("sum(C_SH_SL_GoodsQuantity) as sxhsumnum,");  	//数量 条件8
		buffer.append("C_SH_BC_GuaranteePeriod as sxhguaranteeperiod,");
		buffer.append("B_GI_GoodsCategoryID as sxhGoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID as sxhSupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID as sxhBrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId as sxhStockID, 	");//仓位ID 条件7
		buffer.append("B_BD_brandName as sxhbrandName, "); //品种名称
		buffer.append("C_SH_BC_Batch as cshslbatch, "); //批号
		buffer.append("B_GI_ReturnMax			  AS sxhmax, ");
		buffer.append("B_GI_ReturnMin			  AS sxhmin, ");
		buffer.append("   Case ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) > B_GI_ReturnMax then '正常' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= B_GI_ReturnMax and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMin then '滞销' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) > 0 and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < B_GI_ReturnMin then '将失效' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < 0 and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) > -7000 then '已过期' ");
		buffer.append("		else '未设置' ");
		buffer.append("   End as sxhinvisibletype, ");
		buffer.append("   case  ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < -7000 then '无效期' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) is null then '无效期' ");
		buffer.append("		else cast(DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) as varchar) ");
		buffer.append("   end as sxhDay, ");
		buffer.append("   B_UT_unitName as sxhunitname, ");
		buffer.append("   B_GI_CostPrice as sxhcostprice, ");
		buffer.append("   B_GI_NotTaxRate as sxhnottaxrate, ");
		buffer.append("   B_GI_Spec as sxhspec, ");
		buffer.append("   B_GI_TaxRate as sxhtaxrate ");
		buffer.append("from C_SH_StorageLog_YX  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("left join B_Unit on B_GI_UnitId = B_UT_id ");
		buffer.append("left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
		buffer.append("inner join B_Brand on B_BD_ID = B_GI_BrandID and B_BD_SupplierID = B_GI_SupplierID ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0' and B_GI_isCustomize = '0' ");
		buffer.append("group by C_SH_SL_GoodsId,C_SH_BC_Batch,C_SH_SL_GoodsBarCode,B_SP_SupplierName,B_GI_ViewGoodsName,B_GC_GoodsCategoryName,B_GI_RetailPrice,B_WH_warehouseName,C_SH_BC_GuaranteePeriod,B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,C_SH_SL_StockId,B_BD_brandName,B_GI_ReturnMax,B_GI_ReturnMin,B_UT_unitName,B_GI_CostPrice,B_GI_NotTaxRate,B_GI_Spec,B_GI_TaxRate ");
		buffer.append(" union all  ");		
		buffer.append("select C_SH_SL_GoodsBarCode as sxhGoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId as sxhGoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName as sxhGoodsName, ");	//商品名称  条件4
		buffer.append("B_GC_GoodsCategoryName as sxhGoodsCategoryName, ");	//商品类别
		buffer.append("B_SP_SupplierName as sxhSupplierName, ");	//制造商名称
		buffer.append("B_GI_RetailPrice as sxhRetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName as sxhWarehouseName,  ");	//仓库名称
		buffer.append("sum(C_SH_SL_GoodsQuantity) as sxhsumnum,");  	//数量 条件8
		buffer.append("C_SH_BC_GuaranteePeriod as sxhguaranteeperiod,");
		buffer.append("B_GI_GoodsCategoryID as sxhGoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID as sxhSupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID as sxhBrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId as sxhStockID, 	");//仓位ID 条件7
		buffer.append("B_BD_brandName as sxhbrandName, "); //品种名称
		buffer.append("C_SH_BC_Batch as cshslbatch, "); //批号
		buffer.append("B_GI_ReturnMax			  AS sxhmax, ");
		buffer.append("B_GI_ReturnMin			  AS sxhmin, ");
		buffer.append("   Case ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) > B_GI_ReturnMax then '正常' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) <= B_GI_ReturnMax and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) >= B_GI_ReturnMin then '滞销' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) > 0 and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < B_GI_ReturnMin then '将失效' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < 0 and DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) > -7000 then '已过期' ");
		buffer.append("		else '未设置' ");
		buffer.append("   End as sxhinvisibletype, ");
		buffer.append("   case  ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) < -7000 then '无效期' ");
		buffer.append("		when DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) is null then '无效期' ");
		buffer.append("		else cast(DATEDIFF(day, getdate(), C_SH_BC_GuaranteePeriod) as varchar) ");
		buffer.append("   end as sxhDay, ");
		buffer.append("   B_UT_unitName as sxhunitname, ");
		buffer.append("   B_GI_CostPrice as sxhcostprice, ");
		buffer.append("   B_GI_NotTaxRate as sxhnottaxrate, ");
		buffer.append("   B_GI_Spec as sxhspec, ");
		buffer.append("   B_GI_TaxRate as sxhtaxrate ");
		buffer.append("from C_SH_StorageLog_HLY  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_GoodsCategory on B_GI_GoodsCategoryID = B_GC_ID ");
		buffer.append("inner join B_Supplier on B_GI_SupplierID = B_SP_ID ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("left join B_Unit on B_GI_UnitId = B_UT_id ");
		buffer.append("left join C_SH_BatchCompare on C_SH_SL_GoodsBarCode = C_SH_BC_Barcode ");
		buffer.append("inner join B_Brand on B_BD_ID = B_GI_BrandID and B_BD_SupplierID = B_GI_SupplierID ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0' ");
		buffer.append("group by C_SH_SL_GoodsId,C_SH_BC_Batch,C_SH_SL_GoodsBarCode,B_SP_SupplierName,B_GI_ViewGoodsName,B_GC_GoodsCategoryName,B_GI_RetailPrice,B_WH_warehouseName,C_SH_BC_GuaranteePeriod,B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,C_SH_SL_StockId,B_BD_brandName,B_GI_ReturnMax,B_GI_ReturnMin,B_UT_unitName,B_GI_CostPrice,B_GI_NotTaxRate,B_GI_Spec,B_GI_TaxRate ");
		
		buffer.append(" ) table2 where 1=1 and sxhsumnum <> 0 ");
		
		if("1".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) >= sxhmax ");
		}
		
		if("2".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) <= sxhmax ");
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) >= sxhmin ");
		}
		
		if("3".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) <= sxhmin ");
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) >= 0 ");
		}
		
		if("4".equals(Utility.getName(po.getSxhinvisibletype()))){
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) < 0 ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhmax()))){
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) - sxhmax <= cast(? as float) ");
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) >= sxhmax ");
			params.add(po.getSxhmax());
		}
		
		if(!"".equals(Utility.getName(po.getSxhmin()))){
			buffer.append("and DATEDIFF(day, getdate(), sxhguaranteeperiod) <= cast(? as float) ");
			params.add(po.getSxhmin());
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append("and sxhGoodsId like '%"+po.getSxhGoodsId().toString()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and sxhGoodsBarCode like '%"+po.getSxhGoodsBarCode().toString()+"%'  ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and sxhGoodsCategoryID = ? ");
			params.add(po.getSxhGoodsCategoryID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsName()))){
			buffer.append(" and sxhGoodsName like '%"+po.getSxhGoodsName()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and sxhSupplierID = ? ");
			params.add(po.getSxhSupplierID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and sxhBrandID = ? ");
			params.add(po.getSxhBrandID());
		}
		
		if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
			
			buffer.append(" and sxhStockID in ( ? ");

			List<WarehousePo> dList = po.getSmecistocklist();
			params.add(Utility.getName(dList.get(0).getBwhid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBwhid()));
			}
			buffer.append(" ) ");
		}
		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append(" and sxhStockID = ? ");
			params.add(po.getSxhStockID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhRetailPrice()))){
			buffer.append(" and sxhRetailPrice = ? "); 
			params.add(po.getSxhRetailPrice());
		}
		
		if(!"".equals(Utility.getName(po.getSxhsumnum()))&&!"".equals(Utility.getName(po.getSxhsumnums()))){
			buffer.append(" and sxhsumnum >= ? and sxhsumnum<=?");
			params.add(po.getSxhsumnum());
			params.add(po.getSxhsumnums());
		}

		if("0".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(cshslbatch, '') <> '' AND ISNULL(sxhguaranteeperiod, '') <> '' ");
		}

		if("1".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(cshslbatch, '') <> '' AND ISNULL(sxhguaranteeperiod, '') = '' ");
		}

		if("2".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(cshslbatch, '') = '' AND ISNULL(sxhguaranteeperiod, '') <> '' ");
		}

		if("3".equals(Utility.getName(po.getViewType()))) {
			buffer.append(" AND ISNULL(cshslbatch, '') = '' AND ISNULL(sxhguaranteeperiod, '') = '' ");
		}
		buffer.append(" ) table1  ");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				GoodsDetailsInfoPo.class);
	}
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getStockGoodsInfoPo(GoodsInfoPo po) {
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT top 1 B_GI_GoodsID          AS bgigoodsid, ");
		sb.append("       B_GI_GoodsBarCode           AS bgigoodsbarcode, ");
		sb.append("       B_GI_ViewGoodsName              AS bgigoodsname, ");
		sb.append("       B_GI_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append("       B_GI_SupplierID             AS bgisupplierid, ");
		sb.append("       B_GI_BrandID                AS bgibrandid, ");
		sb.append("       B_GI_UnitId                 AS bgiunitid, ");
		sb.append("       B_GI_RetailPrice            AS bgiretailprice, ");
		sb.append("       B_GI_CostPrice              AS bgicostprice, ");
		sb.append("       B_GI_NotTaxRate             AS bginottaxrate, ");
		sb.append("       B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("       B_GI_Spec                   AS bgispec, ");
		sb.append("       B_GI_Color                  AS bgicolor, ");
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
		sb.append("       dbo.ufn_getCostPriceByCostType(?,?)	  as bgiaveragenotnaxrate, ");
		sb.append("       B_GI_ReturnMax	          as bgireturnmax, ");
		sb.append("       B_GI_ReturnMin	          as bgireturnmin, ");
		sb.append("       B_GI_SupplierColor	      as bgisuppliercolor, ");
		sb.append("       B_GI_WholesalePrice	      as bgiwholesaleprice, ");
		sb.append("       B_GI_FrameSize	          as bgiframesize, ");
		sb.append("       B_GI_GradualClass	          as bgigradualclass, ");
		sb.append("       B_GI_FunctionClass	      as bgifunctionclass, ");
		sb.append("       B_GI_UseType	              as bgiusetype, ");
		sb.append("       B_GI_StealthClass	          as bgistealthclass, ");
		sb.append("       B_GI_Capacity	              as bgicapacity, ");
		sb.append("       B_GI_CapacityEntry	      as bgicapacityentry, ");
		sb.append("       B_GI_AccessoriesType	      as bgiaccessoriestype, ");
		sb.append("       B_Brand.B_BD_brandName      as bgibrandname, ");
		sb.append("       B_Supplier.B_SP_SupplierName as bgisuppliername, ");
		sb.append(" B_FrameMaterial.B_FM_Name    AS bgiframematerialtypename , ");
		sb.append("       B_Unit.B_UT_unitName as bgiunitname ");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("INNER JOIN B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("INNER JOIN B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("left JOIN B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = B_GoodsInfo.B_GI_FrameMaterialType ");
		sb.append("WHERE  1=1 ");
		List<String> params = new ArrayList<String>();
		sb.append("AND B_GI_GoodsID = ? ");
		
		params.add(Utility.getName(po.getBgicompanyid()));
		params.add(Utility.getName(po.getBgigoodsid()));
		params.add(Utility.getName(po.getBgigoodsid()));

		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	/**
	 * 商品库存流水查询数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getStockSearchLsCount(GoodsDetailsInfoPo po) {
		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		sb.append("select count(*) as count,sum(C_SH_SL_GoodsQuantity) as titlenum from ");
		sb.append("(select C_SH_SL_GoodsBarCode,");	//条码  条件2
		sb.append("C_SH_SL_GoodsId, ");	//代码   条件1
		sb.append("B_GI_ViewGoodsName , ");	//商品名称  条件4
		sb.append("B_GI_RetailPrice, ");	//单价 条件9
		sb.append("B_WH_warehouseName,  ");	//仓库名称
		sb.append("C_SH_SL_GoodsQuantity,");  	//数量 条件8
		sb.append("B_GI_GoodsCategoryID, ");	//商品类别 条件3
		sb.append("B_GI_SupplierID, ");	//制造商ID 条件5 
		sb.append("B_GI_BrandID, ");	//商品类别ID 条件6
		sb.append("C_SH_SL_StockId,B_GI_Sph,B_GI_Cyl 	");//仓位ID 条件7
		sb.append("from C_SH_StorageLog  ");
		sb.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		sb.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		sb.append("where C_SH_SL_GoodsQuantity<>'0' ");
		
		if(!"".equals(Utility.getName(po.getSxhchangeid()))){
			sb.append("and C_SH_SL_ChangeID = ? ");
			params.add(Utility.getName(po.getSxhchangeid()));
		}
		if(!"".equals(Utility.getName(po.getSxhbgndate()))){
			sb.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
			params.add(Utility.getName(po.getSxhbgndate()));
		}
		if(!"".equals(Utility.getName(po.getSxhenddate()))){
			sb.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
			params.add(Utility.getName(po.getSxhenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			sb.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			sb.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			sb.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		
		sb.append(") table1 ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			sb.append("and C_SH_SL_GoodsId = ? ");
			params.add(po.getSxhGoodsId());
		}		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			sb.append("and C_SH_SL_StockId = ? ");
			params.add(po.getSxhStockID());
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			sb.append("and C_SH_SL_GoodsBarCode = ? ");
			params.add(Utility.getName(po.getSxhGoodsBarCode()));
		}
		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}
	
	public Map<String, Object>  getStockSearchLsCount2(GoodsDetailsInfoPo po) {
		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		sb.append("select count(*) as count,sum(C_SH_SL_GoodsQuantity) as titlenum from ");
		sb.append("(select C_SH_SL_GoodsBarCode,");	//条码  条件2
		sb.append("C_SH_SL_GoodsId, ");	//代码   条件1
		sb.append("B_GI_ViewGoodsName , ");	//商品名称  条件4
		sb.append("B_GI_RetailPrice, ");	//单价 条件9
		sb.append("B_WH_warehouseName,  ");	//仓库名称
		sb.append("C_SH_SL_GoodsQuantity,");  	//数量 条件8
		sb.append("B_GI_GoodsCategoryID, ");	//商品类别 条件3
		sb.append("B_GI_SupplierID, ");	//制造商ID 条件5 
		sb.append("B_GI_BrandID, ");	//商品类别ID 条件6
		sb.append("C_SH_SL_StockId,B_GI_Sph,B_GI_Cyl 	");//仓位ID 条件7
		sb.append("from C_SH_StorageLog  ");
		sb.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		sb.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		sb.append("where C_SH_SL_GoodsQuantity<>'0' ");
		
		if(!"".equals(Utility.getName(po.getSxhchangeid()))){
			sb.append("and C_SH_SL_ChangeID = ? ");
			params.add(Utility.getName(po.getSxhchangeid()));
		}
		if(!"".equals(Utility.getName(po.getSxhbgndate()))){
			sb.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
			params.add(Utility.getName(po.getSxhbgndate()));
		}
		if(!"".equals(Utility.getName(po.getSxhenddate()))){
			sb.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
			params.add(Utility.getName(po.getSxhenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			sb.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			sb.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			sb.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			sb.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			sb.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			sb.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		
		sb.append(") table1 ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			sb.append("and substring(C_SH_SL_GoodsId,1,7) = ? ");
			params.add(po.getSxhGoodsId());
		}
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			sb.append("and C_SH_SL_StockId = ? ");
			params.add(po.getSxhStockID());
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			sb.append("and C_SH_SL_GoodsBarCode = ? ");
			params.add(Utility.getName(po.getSxhGoodsBarCode()));
		}
		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}
	
	/**
	 * 商品库存流水查询list
	 * 沈兴贺 2011-11-28
	 * @param po
	 * 商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getStockSearchLsList(GoodsDetailsInfoPo po,int start,int size) {

		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ");
		buffer.append("(select ROW_NUMBER() Over (order by sxhwarehousingdate desc) as rowNum, * from ( select * from (select C_SH_SL_UUID as sxhinvisibletype,C_SH_SL_GoodsBarCode as sxhGoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId as sxhGoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName as sxhGoodsName, ");	//商品名称  条件4
		buffer.append("B_GI_RetailPrice as sxhRetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName as sxhWarehouseName,  ");	//仓库名称
		buffer.append("C_SH_SL_GoodsQuantity as sxhsumnum,");  	//数量 条件8
		buffer.append("B_GI_GoodsCategoryID as sxhGoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID as sxhSupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID as sxhBrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId as sxhStockID, ");//仓位ID 条件7
		buffer.append("C_SH_SL_WarehousingDate as sxhwarehousingdate, ");
		buffer.append("C_SH_SL_ChangeID as sxhchangeid,C_SH_SL_AutoAllocation as sxhautoallocationflag,isnull(C_SH_SL_Flag,'') as sxhsalesbillflag ");
		buffer.append("from C_SH_StorageLog  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0'");		
		
		if(!"".equals(Utility.getName(po.getSxhchangeid()))){
			buffer.append("and C_SH_SL_ChangeID = ? ");
			params.add(Utility.getName(po.getSxhchangeid()));
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and C_SH_SL_GoodsBarCode = ? ");
			params.add(Utility.getName(po.getSxhGoodsBarCode()));
		}
		if(!"".equals(Utility.getName(po.getSxhbgndate()))){
			buffer.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
			params.add(Utility.getName(po.getSxhbgndate()));
		}
		if(!"".equals(Utility.getName(po.getSxhenddate()))){
			buffer.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
			params.add(Utility.getName(po.getSxhenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			buffer.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			buffer.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		
		buffer.append(") table2 ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append("and sxhGoodsId = ? ");
			params.add(po.getSxhGoodsId());
		}		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append("and sxhStockID = ? ");
			params.add(po.getSxhStockID());
		}
		
		buffer.append(" ) table1  ");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		 
		 buffer.append(" order by sxhwarehousingdate desc");
		 buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				GoodsDetailsInfoPo.class);
	}
	
	public List<GoodsDetailsInfoPo> getStockSearchLsList2(GoodsDetailsInfoPo po,int start,int size) {

		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ");
		buffer.append("(select ROW_NUMBER() Over (order by sxhwarehousingdate desc) as rowNum, * from ( select * from (select C_SH_SL_UUID as sxhinvisibletype,C_SH_SL_GoodsBarCode as sxhGoodsBarCode,");	//条码  条件2
		buffer.append("C_SH_SL_GoodsId as sxhGoodsId, ");	//代码   条件1
		buffer.append("B_GI_ViewGoodsName as sxhGoodsName, ");	//商品名称  条件4
		buffer.append("B_GI_RetailPrice as sxhRetailPrice, ");	//单价 条件9
		buffer.append("B_WH_warehouseName as sxhWarehouseName,  ");	//仓库名称
		buffer.append("C_SH_SL_GoodsQuantity as sxhsumnum,");  	//数量 条件8
		buffer.append("B_GI_GoodsCategoryID as sxhGoodsCategoryID, ");	//商品类别 条件3
		buffer.append("B_GI_SupplierID as sxhSupplierID, ");	//制造商ID 条件5 
		buffer.append("B_GI_BrandID as sxhBrandID, ");	//商品类别ID 条件6
		buffer.append("C_SH_SL_StockId as sxhStockID, ");//仓位ID 条件7
		buffer.append("C_SH_SL_WarehousingDate as sxhwarehousingdate, ");
		buffer.append("C_SH_SL_ChangeID as sxhchangeid,C_SH_SL_AutoAllocation as sxhautoallocationflag,isnull(C_SH_SL_Flag,'') as sxhsalesbillflag ");
		buffer.append("from C_SH_StorageLog  ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0'");		
		
		if(!"".equals(Utility.getName(po.getSxhchangeid()))){
			buffer.append("and C_SH_SL_ChangeID = ? ");
			params.add(Utility.getName(po.getSxhchangeid()));
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and C_SH_SL_GoodsBarCode = ? ");
			params.add(Utility.getName(po.getSxhGoodsBarCode()));
		}
		if(!"".equals(Utility.getName(po.getSxhbgndate()))){
			buffer.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
			params.add(Utility.getName(po.getSxhbgndate()));
		}
		if(!"".equals(Utility.getName(po.getSxhenddate()))){
			buffer.append("and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
			params.add(Utility.getName(po.getSxhenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			buffer.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			buffer.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		
		buffer.append(") table2 ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append("and substring(sxhGoodsId,1,7) = ? ");
			params.add(po.getSxhGoodsId());
		}		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append("and sxhStockID = ? ");
			params.add(po.getSxhStockID());
		}
		
		buffer.append(" ) table1  ");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		 
		 buffer.append(" order by sxhwarehousingdate desc");
		 buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				GoodsDetailsInfoPo.class);
	}
	
	/**
	 * 商品库存流水查询list
	 * 沈兴贺 2011-11-28
	 * @param po
	 * 商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsDetailsInfoPo> getSalseSearchLsList(GoodsDetailsInfoPo po,int start,int size) {

		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ");
		buffer.append("(select ROW_NUMBER() Over (order by S_SE_SB_PosDatetime desc) as rowNum, ");	//条码  条件2
		buffer.append(" 	 S_SE_SD_SalesItemID as sxhGoodsId,B_GI_ViewGoodsName as sxhGoodsName, ");
		buffer.append("       S_SE_SD_ItemID as sxhGoodsBarCode, ");
		buffer.append("       SUM(S_SE_SD_Number) AS sxhsumnum, ");
		buffer.append("       S_SE_SD_SalesID as sxhchangeid, ");
		buffer.append("       B_GI_BrandID as sxhBrandID, ");
		buffer.append("       B_GI_SupplierID as sxhSupplierID, ");
		buffer.append("       S_SE_SB_PosDatetime as sxhwarehousingdate, ");
		buffer.append("       S_SE_SD_StockId as sxhStockID, ");
		buffer.append("       B_WH_warehouseName as sxhWarehouseName, ");
		buffer.append("       B_GI_GoodsCategoryID as sxhGoodsCategoryID  ");
		buffer.append("FROM   S_SE_SalesDetail ");
		buffer.append("       LEFT JOIN S_SE_SalesBasic ");
		buffer.append("         ON S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("       INNER JOIN B_GoodsInfo ");
		buffer.append("         ON B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("       INNER JOIN B_Warehouse ");
		buffer.append("         ON B_WH_ID = S_SE_SD_StockId ");
		buffer.append("WHERE  B_GI_isCustomize = '0' ");
		buffer.append("       AND B_GI_SupplierID <> 'ZZ' ");
		buffer.append("       AND S_SE_SB_ValueFlag = 1 ");
		
		if(!"".equals(Utility.getName(po.getSxhchangeid()))){
			buffer.append("and S_SE_SD_SalesID = ? ");
			params.add(Utility.getName(po.getSxhchangeid()));
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and S_SE_SD_ItemID = ? ");
			params.add(Utility.getName(po.getSxhGoodsBarCode()));
		}
		if(!"".equals(Utility.getName(po.getSxhbgndate()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
			params.add(Utility.getName(po.getSxhbgndate()));
		}
		if(!"".equals(Utility.getName(po.getSxhenddate()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
			params.add(Utility.getName(po.getSxhenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			buffer.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			buffer.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		buffer.append("GROUP  BY S_SE_SD_SalesItemID,B_GI_ViewGoodsName, ");
		buffer.append("          S_SE_SD_ItemID, ");
		buffer.append("          S_SE_SD_SalesID, ");
		buffer.append("          B_GI_BrandID, ");
		buffer.append("          B_GI_SupplierID, ");
		buffer.append("          S_SE_SB_PosDatetime, ");
		buffer.append("          S_SE_SD_StockId, ");
		buffer.append("          B_WH_warehouseName, ");
		buffer.append("          B_GI_GoodsCategoryID ");
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		 
		 buffer.append(" order by sxhwarehousingdate desc");
		 buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				GoodsDetailsInfoPo.class);
	}
	/**
	 * 商品库存流水查询数量
	 * 沈兴贺2011-4-29
	 * @param po
	 *            商品po
	 * @return 
	 * @return int 数量
	 */
	public Map<String, Object>  getSalseSearchLsCount(GoodsDetailsInfoPo po) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("select count(*) as count,sum(sxhsumnum) as titlenum from ");
		buffer.append(" 	 (select S_SE_SD_SalesItemID as sxhGoodsId,B_GI_ViewGoodsName as sxhGoodsName, ");
		buffer.append("       S_SE_SD_ItemID as sxhGoodsBarCode, ");
		buffer.append("       SUM(S_SE_SD_Number) AS sxhsumnum, ");
		buffer.append("       S_SE_SD_SalesID as sxhchangeid, ");
		buffer.append("       B_GI_BrandID as sxhBrandID, ");
		buffer.append("       B_GI_SupplierID as sxhSupplierID, ");
		buffer.append("       S_SE_SB_PosDatetime as sxhwarehousingdate, ");
		buffer.append("       S_SE_SD_StockId as sxhStockID, ");
		buffer.append("       B_WH_warehouseName as sxhWarehouseName, ");
		buffer.append("       B_GI_GoodsCategoryID as sxhGoodsCategoryID  ");
		buffer.append("FROM   S_SE_SalesDetail ");
		buffer.append("       LEFT JOIN S_SE_SalesBasic ");
		buffer.append("         ON S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("       INNER JOIN B_GoodsInfo ");
		buffer.append("         ON B_GI_GoodsID = S_SE_SD_SalesItemID ");
		buffer.append("       INNER JOIN B_Warehouse ");
		buffer.append("         ON B_WH_ID = S_SE_SD_StockId ");
		buffer.append("WHERE  B_GI_isCustomize = '0' ");
		buffer.append("       AND B_GI_SupplierID <> 'ZZ' ");
		buffer.append("       AND S_SE_SB_ValueFlag = 1 ");
		
		if(!"".equals(Utility.getName(po.getSxhchangeid()))){
			buffer.append("and S_SE_SD_SalesID = ? ");
			params.add(Utility.getName(po.getSxhchangeid()));
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsBarCode()))){
			buffer.append("and S_SE_SD_ItemID = ? ");
			params.add(Utility.getName(po.getSxhGoodsBarCode()));
		}
		if(!"".equals(Utility.getName(po.getSxhbgndate()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
			params.add(Utility.getName(po.getSxhbgndate()));
		}
		if(!"".equals(Utility.getName(po.getSxhenddate()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
			params.add(Utility.getName(po.getSxhenddate()));
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			buffer.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			buffer.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		buffer.append("GROUP  BY S_SE_SD_SalesItemID,B_GI_ViewGoodsName, ");
		buffer.append("          S_SE_SD_ItemID, ");
		buffer.append("          S_SE_SD_SalesID, ");
		buffer.append("          B_GI_BrandID, ");
		buffer.append("          B_GI_SupplierID, ");
		buffer.append("          S_SE_SB_PosDatetime, ");
		buffer.append("          S_SE_SD_StockId, ");
		buffer.append("          B_WH_warehouseName, ");
		buffer.append("          B_GI_GoodsCategoryID ");
		buffer.append(" ) temp ");
		return getJdbcTemplate().queryForMap(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据商品代码查询库存流水
	 */
	public List<StrogeLogPo> getGoodsStrogeList(StrogeLogPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select cshslid as cshslid,cshslgoodsid as cshslgoodsid,cshslgoodsbarcode as cshslgoodsbarcode,cshslgoodsquantity as cshslgoodsquantity,cshslwarehousingdate as cshslwarehousingdate,cshslchangeid as cshslchangeid,cshslstockid as cshslstockid,cshslfromstockid as cshslfromstockid,cshslautoallocationflag as cshslautoallocationflag,isnull(a.B_WH_warehouseName,'') as cshslstockname,isnull(b.B_WH_warehouseName,'') as cshslfromstockname,isnull(cshslsalesid,'') as cshslsalesid from (");
		buffer.append(" select C_SH_SL_UUID as cshslid,C_SH_SL_GoodsId as cshslgoodsid,C_SH_SL_GoodsBarCode as cshslgoodsbarcode,C_SH_SL_GoodsQuantity as cshslgoodsquantity,C_SH_SL_WarehousingDate as cshslwarehousingdate,C_SH_SL_ChangeID as cshslchangeid,C_SH_SL_StockId as cshslstockid,C_SH_SL_FromStockId as cshslfromstockid,isnull(C_SH_SL_AutoAllocation,'') as cshslautoallocationflag,isnull(C_SH_SL_SalesID,'') as cshslsalesid from C_SH_StorageLog  ");
		buffer.append(" where C_SH_SL_ChangeID=? ");		
		params.add(Utility.getName(po.getCshslchangeid()));		
		if (!"".equals(Utility.getName(po.getCshslstockid()))){
			buffer.append(" and C_SH_SL_StockId=? ");
			params.add(Utility.getName(po.getCshslstockid()));
		}
		if(!"".equals(Utility.getName(po.getCshslsalesbillflag()))){
			buffer.append(" and isnull(C_SH_SL_Flag,'')=? ");
			params.add(Utility.getName(po.getCshslsalesbillflag()));
		}
		buffer.append(" )temp left join B_Warehouse a on temp.cshslstockid=a.B_WH_ID left join B_Warehouse b on temp.cshslfromstockid=b.B_WH_ID ");
		
		return queryForObjectList(buffer.toString(), params.toArray(),StrogeLogPo.class);
	}
	
	/**
	 * 获取期初商品信息
	 */
	public GoodsDetailsInfoPo getFirstStockGoodsInfoPo(GoodsDetailsInfoPo po) {
		
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

        buffer.append("select sum(C_SH_SL_GoodsQuantity) as sxhsumnum from C_SH_StorageLog ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0' and convert(varchar(10),C_SH_SL_WarehousingDate,120) < ? ");	
		
		params.add(Utility.getName(po.getSxhbgndate()));
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append("and C_SH_SL_GoodsId = ? ");
			params.add(po.getSxhGoodsId());
		}		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append("and C_SH_SL_StockId = ? ");
			params.add(po.getSxhStockID());
		}
		
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			buffer.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			buffer.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			buffer.append("and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		
		return (GoodsDetailsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsDetailsInfoPo.class);
	}
	
	/**
	 * 获取商品库存数量
	 */
	public GoodsDetailsInfoPo getEndStockGoodsInfoPo(GoodsDetailsInfoPo po) {
		
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

        buffer.append("select sum(C_SH_SL_GoodsQuantity) as sxhsumnum from C_SH_StorageLog ");
		buffer.append("inner join B_GoodsInfo on B_GI_GoodsID = C_SH_SL_GoodsId ");
		buffer.append("inner join B_Warehouse on B_WH_ID = C_SH_SL_StockId ");
		buffer.append("where C_SH_SL_GoodsQuantity<>'0' ");	
		
		if(!"".equals(Utility.getName(po.getSxhGoodsId()))){
			buffer.append(" and C_SH_SL_GoodsId = ? ");
			params.add(po.getSxhGoodsId());
		}		
		if(!"".equals(Utility.getName(po.getSxhStockID()))){
			buffer.append(" and C_SH_SL_StockId = ? ");
			params.add(po.getSxhStockID());
		}
		if(!"".equals(Utility.getName(po.getSxhGoodsCategoryID()))){
			buffer.append(" and B_GI_GoodsCategoryID = ? ");
			params.add(Utility.getName(po.getSxhGoodsCategoryID()));
		}
		if(!"".equals(Utility.getName(po.getSxhSupplierID()))){
			buffer.append(" and B_GI_SupplierID = ? ");
			params.add(Utility.getName(po.getSxhSupplierID()));
		}
		if(!"".equals(Utility.getName(po.getSxhBrandID()))){
			buffer.append(" and B_GI_BrandID = ? ");
			params.add(Utility.getName(po.getSxhBrandID()));
		}
		if(!"".equals(Utility.getName(po.getSxhsph()))){
			buffer.append(" and cast(B_GI_Sph as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhsph()));
		}
		if(!"".equals(Utility.getName(po.getSxhcyl()))){
			buffer.append(" and cast(B_GI_Cyl as float) = cast(? as float) ");
			params.add(Utility.getName(po.getSxhcyl()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		if(!"".equals(Utility.getName(po.getSxhisCustomize()))){
			buffer.append(" and B_GI_isCustomize = ? ");
			params.add(Utility.getName(po.getSxhisCustomize()));
		}
		
		return (GoodsDetailsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsDetailsInfoPo.class);
	}
	public GoodsInfoPo getStorageAnyTimerBrandQ(GoodsInfoPo po){
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组			
			buffer.append("select isnull(sum(tt.bgigoodsquantity),0) as bgigoodsquantity ");
			
			buffer.append(" from ( ");
			buffer.append("select ROW_NUMBER() Over(order by GoodsId) as rowNum,temp.bgisuppliername as bgisuppliername,");
			buffer.append("temp.GoodsId as GoodsId,temp.bgibrandname as bgibrandname,");
			buffer.append("sum(temp.GoodsQuantity) as bgigoodsquantity,");
			buffer.append("temp.bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice as bgiretailprice ");
			}
			
			buffer.append(" from ( select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as GoodsQuantity, ");
			buffer.append("bgisuppliername as bgisuppliername,");
			buffer.append("bgibrandid as bgibrandid,bgibrandname as bgibrandname,");			
			buffer.append("bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice as bgiretailprice");
			}
			
			buffer.append(" from ( select GoodsId,GoodsQuantity,warehouseid, ");  // a 
			buffer.append("B_Supplier.B_SP_SupplierName as bgisuppliername,");
			buffer.append("B_Brand.B_BD_ID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,");			
			buffer.append("B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname  ");	
			
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice     AS bgiretailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea     AS bgiretailprice ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec     AS bgiretailprice ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced     AS bgiretailprice ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee     AS bgiretailprice ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef     AS bgiretailprice ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei     AS bgiretailprice ");
				}
			}
			
			buffer.append(" from (select C_SH_SL_GoodsId as GoodsId,sum(C_SH_SL_GoodsQuantity) as GoodsQuantity,C_SH_SL_StockId as warehouseid from C_SH_StorageLog where 1=1 ");
			
			buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25) < ? ");
			params.add(Utility.getName(po.getStockQueryBeginDate()));
			
			buffer.append(" group by C_SH_SL_GoodsId,C_SH_SL_StockId ");			
				
			buffer.append("  )a inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=a.GoodsId inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner join B_Warehouse on B_Warehouse.B_WH_ID=a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID where 1=1 ");			
			
			//-------------------------------合并------------------------
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_Spec like '%' + ? + '%' ");
				params.add(po.getBgispec());
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_Color like '%' + ? + '%' ");
				params.add(po.getBgicolor());
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(" )b group by substring(GoodsId,1,7),bgisuppliername,bgibrandid,bgibrandname,bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice");
			}
			
			buffer.append(" )temp group by temp.GoodsId,bgisuppliername,bgibrandname,bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice");
			}
			
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.GoodsQuantity)=0");
			}
			buffer.append(" ) as tt " );
			
		}else{
			buffer.append("select isnull(sum(tt.bgigoodsquantity),0) as bgigoodsquantity  ");
			buffer.append(" from(select ROW_NUMBER() Over(order by GoodsId) as rowNum,");
			buffer.append(" temp.bgisuppliername as bgisuppliername,");
			buffer.append("temp.GoodsId as bgibrandid,temp.bgibrandname as bgibrandname,");
			buffer.append("sum(temp.bgigoodsquantity) as bgigoodsquantity,");
			buffer.append("temp.bgiwarehousename as bgiwarehousename,temp.bgigoodscategoryname as bgigoodscategoryname,temp.bgiwarehouseid as bgiwarehouseid ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice as bgiretailprice");
			}
			
			buffer.append(" from( select GoodsId as GoodsId ,");   // c
			buffer.append("bgisuppliername as bgisuppliername,");
			buffer.append("warehouseid as bgiwarehouseid,");
			buffer.append("bgibrandid as bgibrandid,bgibrandname as bgibrandname,");
			buffer.append("isnull(bgigoodsquantity,0) as bgigoodsquantity,");
			buffer.append("bgiwarehousename as bgiwarehousename,bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice as bgiretailprice");
			}
			
			buffer.append(" from(select substring(GoodsId,1,7) as GoodsId,sum(GoodsQuantity) as bgigoodsquantity,warehouseid as warehouseid,bgisuppliername as bgisuppliername,bgibrandid as bgibrandid,bgibrandname as bgibrandname,bgiwarehousename as bgiwarehousename,bgigoodscategoryname as bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice ");
			}
			
			buffer.append(" from (select GoodsId,GoodsQuantity,warehouseid, "); // a
			buffer.append("B_Supplier.B_SP_SupplierName as bgisuppliername,");
			buffer.append("B_Brand.B_BD_ID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,");
			buffer.append("B_Warehouse.B_WH_warehouseName as bgiwarehousename,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");			
			
			if("yes".equals(po.getPricegroup()))
			{
				if("1".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailprice     AS bgiretailprice ");
				}
				if("2".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricea     AS bgiretailprice ");
				}
				if("3".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceb     AS bgiretailprice ");
				}
				if("4".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricec     AS bgiretailprice ");
				}
				if("5".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriced     AS bgiretailprice ");
				}
				if("6".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricee     AS bgiretailprice ");
				}
				if("7".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricef     AS bgiretailprice ");
				}
				if("8".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceg     AS bgiretailprice ");
				}
				if("9".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpriceh     AS bgiretailprice ");
				}
				if("10".equals(po.getBgiwhichretail())){
					buffer.append(" ,b_gi_retailpricei     AS bgiretailprice ");
				}
			}
			
			buffer.append(" from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,");			
			buffer.append("C_SH_StorageLog.C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
			buffer.append("where 1=1  ");
			
			buffer.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25) < ? ");
			params.add(Utility.getName(po.getStockQueryBeginDate()));
			
			buffer.append(" )a inner join B_GoodsInfo on B_GI_GoodsID=GoodsId inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID inner JOIN B_Warehouse ON B_Warehouse.B_WH_ID = a.warehouseid inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID where 1=1 ");
			
			//-------------------------------合并------------------------
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				buffer.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				buffer.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				buffer.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				buffer.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				buffer.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				buffer.append(" and B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				buffer.append(" and B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				buffer.append(" and B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
				buffer.append(" and B_GI_OtherGoodsBigClass=?");
				params.add(po.getBgiothergoodsbigclass());
			}
			if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
				buffer.append(" and B_GI_OtherGoodsSmallClass=?");
				params.add(po.getBgiothergoodssmallclass());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				buffer.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				buffer.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end

			if("1".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					buffer.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				buffer.append(" and B_GI_Flag=? ");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				buffer.append(" and B_GI_Spec like '%' + ? + '%' ");
				params.add(po.getBgispec());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				buffer.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				buffer.append(" and B_GI_Color like '%' + ? + '%' ");
				params.add(po.getBgicolor());
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				buffer.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				buffer.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				buffer.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				buffer.append(" and B_GI_Refractive=?");
				params.add(po.getBgirefractive());
			}
			buffer.append(" and B_GI_SupplierID<>'ZZ' ");
			buffer.append(")b group by substring(GoodsId,1,7),warehouseid,bgisuppliername,bgibrandid,bgibrandname,bgiwarehousename,bgigoodscategoryname ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",bgiretailprice");
			}
			
			buffer.append(" )c  where 1=1 ");
		
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				buffer.append(" and c.warehouseid in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					buffer.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				buffer.append(" ) ");
			}

			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				buffer.append(" and c.warehouseid in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					buffer.append(" ,? ");
					params.add(array[i]);
				}
				buffer.append(" ) ");
			}
			
			buffer.append(" )temp group by temp.bgisuppliername,temp.GoodsId,temp.bgibrandname,temp.bgigoodscategoryname,temp.bgiwarehousename,temp.bgiwarehouseid ");
			
			if("yes".equals(po.getPricegroup()))
			{
				buffer.append(",temp.bgiretailprice");
			}
			
			if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)<>0");
			}
			if ("2".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)<0");
			}
			if ("3".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)>0");
			}
			if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				buffer.append(" having sum(temp.bgigoodsquantity)=0");
			}
			
			buffer.append(" )  as tt ");
		}
		return (GoodsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	public GoodsInfoPo getStorageAnyTimerGoodsQ(GoodsInfoPo po){
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		if(po.getCstcpodid()!=null&&po.getCstcpodid().equals("2")){	//不进行仓位的分组 
			sb.append("select isnull(sum(tt.bgigoodsquantity),0) as bgigoodsquantity ");
			sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,b_gi_viewgoodsname as bgiviewgoodsname,");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,");
			sb.append("B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,");
			sb.append("B_Brand.B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,");
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
			sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,");
			sb.append("B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag,sum(isnull(c.GoodsQuantity,0)) as bgigoodsquantity,");
			sb.append("B_GoodsInfo.B_GI_GoodsCategoryID as bgigoodscategoryid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname,B_GI_FrameSize as bgiframesize ");
			
			sb.append("from(select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity ");
			sb.append("from (select GoodsId,GoodsQuantity,warehouseid ");
			sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
			sb.append("where 1=1");
			
			sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25) < ? ");
			params.add(Utility.getName(po.getStockQueryBeginDate()));
			
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				sb.append(" and C_SH_SL_StockId in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				sb.append(" ) ");
			}
			
			sb.append(")a inner join B_Warehouse on warehouseid=B_WH_ID )b GROUP BY GoodsId ");
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" having sum(GoodsQuantity)>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" having sum(GoodsQuantity)=0");
			}
			sb.append(" )c ");
			sb.append("right join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
			sb.append("inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("where 1=1 and B_GI_SupplierID<>'ZZ' ");			
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and B_GoodsInfo.B_GI_Goodsbarcode like '%' + ? + '%'");
				params.add(po.getBgigoodsbarcode());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}

			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}

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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_Spec like '%' + ? + '%' ");
				params.add(po.getBgispec());
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_Color like '%' + ? + '%' ");
				params.add(po.getBgicolor());
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}

			/*-----------------------------新条件 2012/11/06----------------------------*/
			
			sb.append("  group by  B_GoodsInfo.B_GI_GoodsID , B_GoodsInfo.B_GI_ViewGoodsName,b_gi_viewgoodsname,");
            sb.append("  B_Supplier.B_SP_SupplierName ,B_GoodsInfo.B_GI_Spec,B_GoodsInfo.B_GI_Color,");
            sb.append("  B_GoodsInfo.B_GI_Sph,B_GoodsInfo.B_GI_Cyl, B_GoodsInfo.B_GI_Axis,B_GoodsInfo.B_GI_Curvature1,");
            sb.append("  B_GoodsInfo.B_GI_Dia ,B_GoodsInfo.B_GI_TaxRate ,");
            sb.append("  B_GoodsInfo.B_GI_GoodsBarCode ,B_Brand.B_BD_brandName,B_Unit.B_UT_unitName, ");
            
            if("1".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailprice, ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricea, ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceb, ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricec, ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriced, ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricee, ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricef, ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceg, ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpriceh, ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" b_gi_retailpricei, ");
			}
            
            sb.append("  B_GoodsInfo.B_GI_CostPrice,B_GoodsInfo.B_GI_NotTaxRate ,");
            sb.append("  B_GoodsInfo.B_GI_Flag ,B_GoodsInfo.B_GI_GoodsCategoryID , B_GoodsCategory.B_GC_GoodsCategoryName,B_GI_FrameSize ");
			
		}else{
			sb.append("select isnull(sum(tt.bgigoodsquantity),0) as bgigoodsquantity from(");
			sb.append("select ROW_NUMBER() Over(order by tem.bgigoodsid) as rowNum,tem.bgigoodsid as bgigoodsid,tem.bgigoodsname as bgigoodsname,tem.bgiviewgoodsname as bgiviewgoodsname,tem.bgisuppliername as bgisuppliername,tem.bgiframesize as bgiframesize,");
			sb.append("tem.bgisph as bgisph,tem.bgicyl as bgicyl,tem.bgiaxis as bgiaxis,tem.bgicurvature1 as bgicurvature1,tem.bgidia as bgidia,");
			sb.append("tem.bgispec as bgispec,tem.bgicolor as bgicolor,tem.bgibrandname as bgibrandname,tem.bgitaxrate as bgitaxrate,tem.bgigoodsbarcode as bgigoodsbarcode,");
			sb.append("tem.bgiunitname as bgiunitname,tem.bgicostprice as bgicostprice,tem.bgiretailprice as bgiretailprice,tem.bginottaxrate as bginottaxrate,tem.bgiflag as bgiflag,");
			sb.append("tem.bgigoodsquantity as bgigoodsquantity,");
			sb.append("tem.bgiwarehousename as bgiwarehousename,bgiwarehouseid as bgiwarehouseid,tem.bgigoodscategoryid as bgigoodscategoryid,tem.bgigoodscategoryname as bgigoodscategoryname,");
			sb.append("tem.alerttype as alerttype ");
			sb.append(" from( select ");
			sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,b_gi_viewgoodsname as bgiviewgoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
			sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GI_FrameSize as bgiframesize,");
			sb.append("B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,");
			sb.append("B_Brand.B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,alerttemp.scap as bgistorageupperlimit,alerttemp.slower as bgistoragelowerlimit,alerttemp.sred as bgistorageredlimit,");
			sb.append("case ");
			sb.append("when isnull(c.GoodsQuantity,0) <= isnull(alerttemp.sred,0) then '4' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.sred,0) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.slower,0) then '1' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.slower,0) and isnull(c.GoodsQuantity,0) <= isnull(alerttemp.scap,0)   then '2' ");
			sb.append("when isnull(c.GoodsQuantity,0) >  isnull(alerttemp.scap,0) then '3' ");
			sb.append("else '' ");
			sb.append("end as alerttype, ");
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
			sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,");
			sb.append("B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag,isnull(c.GoodsQuantity,0) as bgigoodsquantity,");
			sb.append("B_Warehouse.B_WH_warehouseName as bgiwarehousename,B_Warehouse.B_WH_ID as bgiwarehouseid,B_GoodsInfo.B_GI_GoodsCategoryID as bgigoodscategoryid,B_GoodsCategory.B_GC_GoodsCategoryName as bgigoodscategoryname ");
			sb.append("from B_GoodsInfo inner join ( ");
			
				sb.append("select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid from ( ");
				sb.append("select GoodsId,GoodsQuantity,warehouseid ");
				sb.append("from (select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsQuantity as GoodsQuantity,");
				sb.append("C_SH_SL_StockId as warehouseid from C_SH_StorageLog ");
				sb.append("where 1=1  ");

				sb.append(" and convert(varchar(100),C_SH_SL_WarehousingDate,25)< ? ");
				params.add(Utility.getName(po.getStockQueryBeginDate()));
				
				if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
					sb.append(" and C_SH_SL_GoodsBarCode = ? ");
					params.add(po.getBgigoodsbarcode());
				}
				sb.append(")a )b  ");
				sb.append("group by GoodsId,warehouseid ");
			
			
			sb.append(")c  ");
			sb.append(" on B_GoodsInfo.B_GI_GoodsID=c.GoodsId ");
			sb.append("left join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
			
			sb.append("left join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
			sb.append("and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
			sb.append("left join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
			sb.append("left join B_Warehouse on B_Warehouse.B_WH_ID=c.warehouseid  ");
			sb.append("left join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
			sb.append("left join (  ");
			sb.append("select ");
			sb.append("C_SA_SA_GoodsID as goodsid, ");
			sb.append("C_SA_SA_StockID as stockid, ");
			sb.append("isnull(C_SA_SA_StockCap,0) as scap, ");
			sb.append("isnull(C_SA_SA_StockLower,0) as slower, ");
			sb.append("isnull(C_SA_SA_StockRed,0) as sred ");
			sb.append("from C_SA_StockAlertSetting ");
			sb.append(" ) alerttemp on alerttemp.goodsid = B_GoodsInfo.B_GI_GoodsID and alerttemp.stockid = c.warehouseid ");
			sb.append("where 1=1 AND B_GI_SupplierID <> 'ZZ' ");
			
			if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
				sb.append(" and B_GI_AccessoriesType = ? ");
				params.add(po.getBgiaccessoriestype());
			}
			//add by ZK begin
			if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
				sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
				params.add(po.getBgitechnologytypeid());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
				sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
				params.add(po.getBgiframematerialtype());
			}
			//add by ZK end
			if (!"".equals(Utility.getName(po.getCstcpodid()))) {
				sb.append(" and B_WH_IsClosed=? ");
				params.add(Utility.getName(po.getCstcpodid()));
			}	
			
			if("2".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity<0");
			}
			else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
			{
				sb.append(" and GoodsQuantity>0");
			}
			else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity<>0");
			}
			else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
				sb.append(" and GoodsQuantity=0");
			}
			if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsID  like '%' + ? + '%' ");
				params.add(po.getBgigoodsid());
			}
			
			if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
				sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
				params.add(po.getBgigoodsname());
			}
			if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
				params.add(po.getBgigoodscategoryid());
			}
			if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
				sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
				params.add(po.getBgisupplierid());
			}
			if (!"".equals(Utility.getName(po.getBgibrandid()))) {
				sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
				params.add(po.getBgibrandid());
			}
			if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
				sb.append(" and B_GI_isCustomize=? ");
				params.add(po.getBgiiscustomize());
			}
		
			if(po.getSmecistocklist() != null && po.getSmecistocklist().size() > 0){
				
				sb.append(" and c.warehouseid in ( ? ");

				List<WarehousePo> dList = po.getSmecistocklist();
				params.add(Utility.getName(dList.get(0).getBwhid()));

				for (int i = 1; i < dList.size(); i++){
					sb.append(" ,? ");
					params.add(Utility.getName(dList.get(i).getBwhid()));
				}
				sb.append(" ) ");
			}
			
			if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
				sb.append(" and c.warehouseid in ( ? ");
				
				String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
				params.add(array[0]);
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				sb.append(" ) ");
			}

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
			if (!"".equals(Utility.getName(po.getBgiflag()))) {
				sb.append(" and B_GI_Flag=?");
				params.add(po.getBgiflag());
			}
			if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
				sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
			}
			/*-----------------------------新条件 2012/11/06----------------------------*/
			if (!"".equals(Utility.getName(po.getBgispec()))) {
				sb.append(" and B_GI_Spec like '%' + ? + '%' ");
				params.add(po.getBgispec());
			}
			
			if (!"".equals(Utility.getName(po.getBgicolor()))) {
				sb.append(" and B_GI_Color like '%' + ? + '%' ");
				params.add(po.getBgicolor());
			}
			
			if (!"".equals(Utility.getName(po.getBgiframesize()))) {
				sb.append(" and B_GI_FrameSize = ? ");
				params.add(po.getBgiframesize());
			}
			
			if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
				sb.append(" and B_GI_isMutiLuminosity = ? ");
				params.add(po.getBgiismutiluminosity());
			}
			
			if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
				sb.append(" and B_GI_EyeGlassMaterialType = ? ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			
			if (!"".equals(Utility.getName(po.getBgirefractive()))) {
				sb.append(" and B_GI_Refractive = ? ");
				params.add(po.getBgirefractive());
			}
			
			if (!"".equals(Utility.getName(po.getMaxSph()))) {
				sb.append(" and B_GI_Sph <= cast( ? as float) ");
				params.add(po.getMaxSph());
			}
			
			if (!"".equals(Utility.getName(po.getMinSph()))) {
				sb.append(" and B_GI_Sph >= cast( ? as float) ");
				params.add(po.getMinSph());
			}
			
			if (!"".equals(Utility.getName(po.getMaxCyl()))) {
				sb.append(" and B_GI_Cyl <= cast( ? as float) ");
				params.add(po.getMaxCyl());
			}
			
			if (!"".equals(Utility.getName(po.getMinCyl()))) {
				sb.append(" and B_GI_Cyl >= cast( ? as float) ");
				params.add(po.getMinCyl());
			}
			
			if (!"".equals(Utility.getName(po.getBgiusetype()))) {
				sb.append(" and B_GI_UseType = ? ");
				params.add(po.getBgiusetype());
			}
			
			if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
				sb.append(" and B_GI_StealthClass = ? ");
				params.add(po.getBgistealthclass());
			}

			/*-----------------------------新条件 2012/11/06----------------------------*/
			sb.append(" ) tem where 1=1 ");
			if (!"".equals(Utility.getName(po.getAlerttype()))) {
				sb.append(" and tem.alerttype = ? ");
				params.add(po.getAlerttype());
			}
		}
		
		sb.append(" ) as tt " );
		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}

	public GoodsInfoPo getStorageAlertGoodsInfoPo(GoodsInfoPo po) {
		StringBuffer  buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select scap as bgistorageupperlimit,slower as bgistoragelowerlimit,sred as bgistorageredlimit,sum(C_SH_SL_GoodsQuantity) as bgigoodsquantity from C_SH_StorageLog ");
		buffer.append(" left join (    ");
		buffer.append("		 select   ");
		buffer.append("		 C_SA_SA_GoodsID as goodsid,   ");
		buffer.append("		 C_SA_SA_StockID as stockid,   "); 
		buffer.append("		 isnull(C_SA_SA_StockCap,0) as scap,  "); 
		buffer.append("		 isnull(C_SA_SA_StockLower,0) as slower,   ");
		buffer.append("		 isnull(C_SA_SA_StockRed,0) as sred   ");
		buffer.append("		 from C_SA_StockAlertSetting   ");
		buffer.append("		  ) alerttemp on alerttemp.goodsid = C_SH_SL_GoodsId and alerttemp.stockid = C_SH_SL_StockId ");
		buffer.append("where 1=1 ");
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			buffer.append("and C_SH_SL_GoodsId = ? ");
			params.add(po.getBgigoodsid());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			buffer.append("and C_SH_SL_GoodsBarCode = ? ");
			params.add(po.getBgigoodsbarcode());
		}
		
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			buffer.append("and C_SH_SL_StockId = ? ");
			params.add(po.getBgiwarehouseid());
		}
		
		buffer.append("group by scap,slower,sred ");
	
		return (GoodsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	
	public Map<String, Object> getStockAgeSearchCount(GoodsInfoPo po,
			PersonInfoPo personInfoPo) {
		
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		//查询条件选择的仓位插入临时表处理
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
			sb.append("DROP TABLE #stocktmp1 ");
			sb.append("select * into #stocktmp1 from dbo.Strtotable('");
			
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			sb.append(array[0]);
			for (int i = 1; i < array.length; i++){
				sb.append(","+ array[i] +"");
			}
			sb.append("') ");
		}
		//查询条件选择的仓位插入临时表处理
		
		sb.append("SELECT COUNT(bgigoodsbarcode) AS COUNT,SUM(bgigoodsquantity)	AS titlenum ");
		sb.append(" FROM (SELECT C_SH_SL_GoodsBarCode as bgigoodsbarcode,C_SH_SL_Rksj as rksj,SUM(C_SH_SL_GoodsQuantity)   AS bgigoodsquantity ");
		
		sb.append("                        FROM C_SH_StorageLog  ");			

		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append("                			  inner join #stocktmp1 on C_SH_SL_StockId = #stocktmp1.str2table ");
		}
		
		sb.append("inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID ");
		sb.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=C_SH_SL_GoodsId ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
		sb.append("where 1=1 and B_GI_SupplierID<>'ZZ' AND C_SH_SL_GoodsBarCode NOT LIKE '%00000000' ");
		
		if (!"".equals(Utility.getName(po.getRksjbegin()))) {
			sb.append("and C_SH_SL_Rksj>=? ");
			params.add(po.getRksjbegin());
		}
		if (!"".equals(Utility.getName(po.getRksjend()))) {
			sb.append("and C_SH_SL_Rksj<=? ");
			params.add(po.getRksjend());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			sb.append(" and B_GI_OtherGoodsBigClass=?");
			params.add(po.getBgiothergoodsbigclass());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			sb.append(" and B_GI_OtherGoodsSmallClass=?");
			params.add(po.getBgiothergoodssmallclass());
		}

		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			sb.append(" and B_GI_Flag=? ");
			params.add(po.getBgiflag());
		}
		
		/*-----------------------------新条件 2012/11/06----------------------------*/
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GI_Spec like '%' + ? + '%' ");
			params.add(po.getBgispec());
		}
		
		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			sb.append(" and B_GI_Color like '%' + ? + '%' ");
			params.add(po.getBgicolor());
		}
		
		if (!"".equals(Utility.getName(po.getBgiframesize()))) {
			sb.append(" and B_GI_FrameSize = ? ");
			params.add(po.getBgiframesize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			sb.append(" and B_GI_isMutiLuminosity = ? ");
			params.add(po.getBgiismutiluminosity());
		}
		
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			sb.append(" and B_GI_EyeGlassMaterialType = ? ");
			params.add(po.getBgieyeglassmaterialtype());
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			sb.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if (!"".equals(Utility.getName(po.getMaxSph()))) {
			sb.append(" and B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSph());
		}
		
		if (!"".equals(Utility.getName(po.getMinSph()))) {
			sb.append(" and B_GI_Vsph >= cast( ? as float) ");
			params.add(po.getMinSph());
		}
		
		if (!"".equals(Utility.getName(po.getMaxCyl()))) {
			sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
			params.add(po.getMaxCyl());
		}
		
		if (!"".equals(Utility.getName(po.getMinCyl()))) {
			sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
			params.add(po.getMinCyl());
		}
		
		if (!"".equals(Utility.getName(po.getBgiusetype()))) {
			sb.append(" and B_GI_UseType = ? ");
			params.add(po.getBgiusetype());
		}
		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
			sb.append(" and B_GI_StealthClass = ? ");
			params.add(po.getBgistealthclass());
		}
		if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(po.getBgiframematerialtype());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(po.getBgiaccessoriestype());
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GI_isCustomize=? ");
			params.add(po.getBgiiscustomize());
		}
		sb.append(" group by b_gi_viewgoodsname , ");
		sb.append("B_GoodsInfo.B_GI_GoodsID, ");
		sb.append("B_GoodsInfo.B_GI_GoodsName, ");
		sb.append("B_GC_GoodsCategoryName, ");
		sb.append("B_Supplier.B_SP_SupplierName, ");
		sb.append("C_SH_SL_GoodsBarCode, ");
		sb.append("C_SH_SL_Rksj, ");
		sb.append("B_Brand.B_BD_brandName, ");
		sb.append("C_SH_SL_StockId, ");
        if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei, ");
		}
		sb.append("B_WH_warehouseName ");
		
		if("2".equals(Utility.getName(po.getBgigoodsquantity())))
		{
			sb.append(" having(SUM(C_SH_SL_GoodsQuantity))<0");
		}
		else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
		{
			sb.append(" having(SUM(C_SH_SL_GoodsQuantity))>0");
		}
		else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
			sb.append(" having(SUM(C_SH_SL_GoodsQuantity))<>0");
		}
		else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
			sb.append(" having(SUM(C_SH_SL_GoodsQuantity))=0");
		}
		sb.append(")t");
		
		return getJdbcTemplate().queryForMap(sb.toString(), params.toArray());
	}
	
	public List<GoodsInfoPo> getStockAgeSearchList(GoodsInfoPo po,
			PersonInfoPo personInfoPo, int start, int size) {
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		
		//查询条件选择的仓位插入临时表处理
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#stocktmp1') and type='U')");
			sb.append("DROP TABLE #stocktmp1 ");
			sb.append("select * into #stocktmp1 from dbo.Strtotable('");
			
			String[] array = Utility.getName(po.getBgiwarehouseid()).split(",");
			sb.append(array[0]);
			for (int i = 1; i < array.length; i++){
				sb.append(","+ array[i] +"");
			}
			sb.append("') ");
		}
		//查询条件选择的仓位插入临时表处理
		
		sb.append("SELECT  * ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY C_SH_SL_GoodsBarCode) AS rowNum, ");
		sb.append("                         B_GoodsInfo.B_GI_GoodsID                         AS bgigoodsid,");
		sb.append("                         b_gi_viewgoodsname                               AS bgiviewgoodsname,");
		sb.append("                         B_GoodsInfo.B_GI_GoodsName                       AS bgigoodsname,");
		sb.append("                         B_GC_GoodsCategoryName                           AS bgigoodscategoryname,");
		sb.append("                         B_Supplier.B_SP_SupplierName                     AS bgisuppliername,");
		sb.append("                         C_SH_SL_GoodsBarCode                             AS bgigoodsbarcode,");
		sb.append("                         C_SH_SL_Rksj                             		 AS bgirksj,");
		sb.append("                         B_Brand.B_BD_brandName                           AS bgibrandname,");
		sb.append("                         C_SH_SL_StockId                                  AS bgiwarehouseid,");
		sb.append("                         B_WH_warehouseName                               AS bgiwarehousename,");
		
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
		sb.append("                         SUM(C_SH_SL_GoodsQuantity)                       AS bgigoodsquantity ");

		sb.append("from C_SH_StorageLog ");
		sb.append("inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID ");
		sb.append("inner join B_GoodsInfo on B_GoodsInfo.B_GI_GoodsID=C_SH_SL_GoodsId ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_GoodsCategory on B_GoodsInfo.B_GI_GoodsCategoryID=B_GoodsCategory.B_GC_ID ");
		sb.append("where 1=1 and B_GI_SupplierID<>'ZZ' AND C_SH_SL_GoodsBarCode NOT LIKE '%00000000' ");
		
		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append("                				  inner join #stocktmp1 on C_SH_SL_StockId = #stocktmp1.str2table ");
		}
		
		if (!"".equals(Utility.getName(po.getRksjbegin()))) {
			sb.append("and C_SH_SL_Rksj>=? ");
			params.add(po.getRksjbegin());
		}
		if (!"".equals(Utility.getName(po.getRksjend()))) {
			sb.append("and C_SH_SL_Rksj<=? ");
			params.add(po.getRksjend());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if("2".equals(Utility.getName(po.getMakeinvoiceflags()))){
			sb.append(" and B_SP_MakeInvoiceFlag ='"+po.getMakeinvoiceflag()+"'");
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			sb.append(" and B_GI_OtherGoodsBigClass=?");
			params.add(po.getBgiothergoodsbigclass());
		}
		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			sb.append(" and B_GI_OtherGoodsSmallClass=?");
			params.add(po.getBgiothergoodssmallclass());
		}

		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			sb.append(" and B_GI_Flag=? ");
			params.add(po.getBgiflag());
		}
		
		/*-----------------------------新条件 2012/11/06----------------------------*/
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GI_Spec like '%' + ? + '%' ");
			params.add(po.getBgispec());
		}
		
		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			sb.append(" and B_GI_Color like '%' + ? + '%' ");
			params.add(po.getBgicolor());
		}
		
		if (!"".equals(Utility.getName(po.getBgiframesize()))) {
			sb.append(" and B_GI_FrameSize = ? ");
			params.add(po.getBgiframesize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			sb.append(" and B_GI_isMutiLuminosity = ? ");
			params.add(po.getBgiismutiluminosity());
		}
		
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			sb.append(" and B_GI_EyeGlassMaterialType = ? ");
			params.add(po.getBgieyeglassmaterialtype());
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			sb.append(" and B_GI_Refractive = ? ");
			params.add(po.getBgirefractive());
		}
		
		if (!"".equals(Utility.getName(po.getMaxSph()))) {
			sb.append(" and B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSph());
		}
		
		if (!"".equals(Utility.getName(po.getMinSph()))) {
			sb.append(" and B_GI_Vsph >= cast( ? as float) ");
			params.add(po.getMinSph());
		}
		
		if (!"".equals(Utility.getName(po.getMaxCyl()))) {
			sb.append(" and B_GI_Vcyl <= cast( ? as float) ");
			params.add(po.getMaxCyl());
		}
		
		if (!"".equals(Utility.getName(po.getMinCyl()))) {
			sb.append(" and B_GI_Vcyl >= cast( ? as float) ");
			params.add(po.getMinCyl());
		}
		
		if (!"".equals(Utility.getName(po.getBgiusetype()))) {
			sb.append(" and B_GI_UseType = ? ");
			params.add(po.getBgiusetype());
		}
		
		if (!"".equals(Utility.getName(po.getBgistealthclass()))) {
			sb.append(" and B_GI_StealthClass = ? ");
			params.add(po.getBgistealthclass());
		}
		if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(po.getBgiframematerialtype());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestype()))) {
			sb.append(" and B_GI_AccessoriesType = ? ");
			params.add(po.getBgiaccessoriestype());
		}
		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GI_isCustomize=? ");
			params.add(po.getBgiiscustomize());
		}
		sb.append(" group by b_gi_viewgoodsname , ");
		sb.append("B_GoodsInfo.B_GI_GoodsID, ");
		sb.append("B_GoodsInfo.B_GI_GoodsName, ");
		sb.append("B_GC_GoodsCategoryName, ");
		sb.append("B_Supplier.B_SP_SupplierName, ");
		sb.append("C_SH_SL_GoodsBarCode, ");
		sb.append("C_SH_SL_Rksj, ");
		sb.append("B_Brand.B_BD_brandName, ");
		sb.append("C_SH_SL_StockId, ");
        if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei, ");
		}
		sb.append("B_WH_warehouseName ");
		
		if("2".equals(Utility.getName(po.getBgigoodsquantity())))
		{
			sb.append(" HAVING( SUM(C_SH_SL_GoodsQuantity) )<0");
		}
		else if("3".equals(Utility.getName(po.getBgigoodsquantity())))
		{
			sb.append(" HAVING( SUM(C_SH_SL_GoodsQuantity) )>0");
		}
		else if ("1".equals(Utility.getName(po.getBgigoodsquantity()))) {
			sb.append(" HAVING( SUM(C_SH_SL_GoodsQuantity) )<>0");
		}
		else if ("4".equals(Utility.getName(po.getBgigoodsquantity()))) {
			sb.append(" HAVING( SUM(C_SH_SL_GoodsQuantity) )=0");
		}
		
		sb.append(")t where rowNum > " + start + " and rowNum <= " + countPage);

		if(!"".equals(Utility.getName(po.getBgiwarehouseid()))){
			sb.append(" DROP TABLE #stocktmp1 ");
		}
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
}
