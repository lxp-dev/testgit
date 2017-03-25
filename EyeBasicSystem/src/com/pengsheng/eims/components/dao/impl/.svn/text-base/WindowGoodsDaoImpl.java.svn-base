package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.dao.WindowGoodsDao;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 商品开窗dao 实现类
 */
public class WindowGoodsDaoImpl extends BaseJdbcDaoSupport implements
		WindowGoodsDao {
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" left outer join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID");//quyanping
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where B_GoodsInfo.B_GI_Flag='1' ");

		List<String> params = new ArrayList<String>();
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID <> '4' and B_GoodsInfo.B_GI_GoodsCategoryID <> '5' ");
		}
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		//quyanping
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleBPCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select count(templog.GoodsBarCode) from B_GoodsInfo ");
		sb.append(" inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append(" inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" left outer join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID");//quyanping
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append(" INNER JOIN ");
		sb.append(" ( select log.GoodsId as GoodsId,log.GoodsBarCode as GoodsBarCode,log.GuaranteePeriod as GuaranteePeriod,log.Batch as Batch,log.GoodsQuantity as GoodsQuantity from (");
		sb.append(" 	select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsBarCode as GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,'') as GuaranteePeriod,isnull(C_SH_SL_Batch,'') as Batch,sum(C_SH_SL_GoodsQuantity) as GoodsQuantity from C_SH_StorageLog left join B_Warehouse on C_SH_SL_StockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("  	where 1=1 ");
		if(!Utility.getName(po.getBgiwarehouseid()).equals("")){
			sb.append(" 	and C_SH_SL_StockId = ? ");
			params.add(po.getBgiwarehouseid());
		}
		if(!Utility.getName(po.getBgicompanyid()).equals("")){
			sb.append(" 	and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));
		}
		sb.append("  	group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') )log ");
		sb.append(" where 1=1 ");
		
		if("1".equals(po.getBgigoodsquantity())){
			sb.append(" 	and log.GoodsQuantity > 0 ");
		}
		sb.append(" ) templog on templog.GoodsId = B_GI_GoodsID ");
		sb.append(" where B_GoodsInfo.B_GI_Flag='1'  ");
		
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}

		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		//quyanping
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Sph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Sph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleZTCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" left outer join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID");//quyanping
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		
//		if((Utility.getName(po.getBgistealtheffective()).equals("1") || Utility.getName(po.getBgistealtheffective()).equals("2")) && (!Utility.getName(po.getBgigoodsbarcode()).equals("") && (Utility.getName(po.getBgigoodsbarcode()).substring(0,1).equals("4") || Utility.getName(po.getBgigoodsbarcode()).substring(0,1).equals("5")))){
			sb.append(" left join ( ");
			sb.append("	 	       SELECT C_SH_SL_GoodsId        AS GoodsId, ");
			sb.append("		              sum(C_SH_SL_GoodsQuantity) AS GoodsQuantity, ");
			sb.append("		              C_SH_SL_StockId       AS StockId, ");
			sb.append("		       '' AS StockName,C_SH_SL_GoodsBarCode as  GoodsBarCode ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_JJ ");
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_PJ ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_JP ");
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_YX ");
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_HLY ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_TYJ ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_HC ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_LHJ ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_SG ");
			}else{
				sb.append("	FROM   C_SH_StorageLog ");				
			}

			if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
				sb.append(" WHERE C_SH_SL_StockId = ? ");
				params.add(po.getBgiwarehouseid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgigoodsbarcode()));
			}
			sb.append("		GROUP  BY C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsBarCode ");
			sb.append(" ) kucun ");
			sb.append(" on B_GI_GoodsID = kucun.GoodsId ");
//		}else{
//			sb.append(" left join ( ");
//			sb.append("		SELECT GoodsId AS GoodsId, ");
//			sb.append("		       SUM(GoodsQuantity) AS GoodsQuantity, ");
//			sb.append("		       StockId 			  AS StockId, ");
//			sb.append("		       '' AS StockName ");
//			sb.append("		FROM  (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
//			sb.append("		              C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
//			sb.append("		              C_SH_SB_StockId       AS StockId ");
//			sb.append("		       FROM   C_SH_StorageBeginning ");
//			sb.append("		       UNION ALL ");
//			sb.append("	 	       SELECT C_SH_SC_GoodsId        AS GoodsId, ");
//			sb.append("		              C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
//			sb.append("		              C_SH_SC_StockId       AS StockId ");
//			sb.append("		       FROM   C_SH_StorageChange)ktemp ");
//			if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
//				sb.append(" WHERE ktemp.StockId = ? ");
//				params.add(po.getBgiwarehouseid());
//			}
//			sb.append("		GROUP  BY GoodsId,StockId ");
//			sb.append(" ) kucun ");
//			sb.append(" on B_GI_GoodsID = kucun.GoodsId ");
//		}
				
		sb.append(" left join ( ");
		sb.append(" select C_SH_TSE_GoodsID as GoodsId,sum(C_SH_TSE_GoodsNum) as GoodsNum from C_SH_InTransitStorageEntry ");
		sb.append(" where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SH_TSE_OUTStockID = ? ");
			params.add(po.getBgiwarehouseid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and C_SH_TSE_GoodsBarCode = ? ");
			params.add(Utility.getName(po.getBgigoodsbarcode()));
		}
		sb.append(" group by C_SH_TSE_GoodsID)zaitu ");
		sb.append(" on B_GI_GoodsID = zaitu.GoodsId ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where B_GoodsInfo.B_GI_Flag='1' ");
		
		if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
			sb.append(" and (isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0)) > 0 ");
		}
		
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID <> '4' and B_GoodsInfo.B_GI_GoodsCategoryID <> '5' ");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and kucun.StockId = ? ");
			params.add(po.getBgiwarehouseid());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleExchangeCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(F_IntegralExchange.F_IR_GoodsID) from F_IntegralExchange ");
		sb.append("inner join B_GoodsInfo on F_IntegralExchange.F_IR_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" left outer join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id  ");
		sb.append(" left join(select C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,sum(C_SH_SL_GoodsQuantity) as GoodsQuantity from C_SH_StorageLog");
		sb.append(" inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID ");
		sb.append(" where B_WH_deptID=? ");
		sb.append(" group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode ");
		sb.append(" )tt on C_SH_SL_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("  where F_IntegralExchange.F_IR_Flag='1' ");
		List<String> params = new ArrayList<String>();
		params.add(po.getShopCode());
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and (',' + F_IR_DepartmentID + ',') like '%,' + ? + ',%' ");
			params.add(po.getShopCode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and F_IntegralExchange.F_IR_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
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
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and cast(F_IR_IntegralCount as numeric)>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and cast(F_IR_IntegralCount as numeric)<=?");
			params.add(po.getBgiretailendprice());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleCountGifts(GoodsInfoPo po) {


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
		
		params.add(Utility.getName(po.getShopCode()));
		params.add(Utility.getName(po.getShopCode()));
		
		sb.append("select count(counttemp.GoodsID) from ( ");
		sb.append("select B_Gifts.B_GS_GoodsID as GoodsID,sum(temp1.goodsQuantity) as goodsQuantity from #GiftTmp B_Gifts ");
		sb.append("inner join B_GoodsInfo on B_Gifts.B_GS_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" left outer join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID");//quyanping
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
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
		
		sb.append(" where B_GoodsInfo.B_GI_Flag='1' and B_Gifts.B_GS_Flag='1' and  B_Gifts.B_GS_AuditState='1'  ");
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_Gifts.B_GS_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
	
		if (!"".equals(Utility.getName(po.getBgigifttype()))) {
			sb.append(" and B_Gifts.B_GS_Type = ?");
			params.add(po.getBgigifttype());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		//quyanping
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		if(!"1".equals(Utility.getName(po.getBgisalestype()))){
			sb.append(" and temp1.goodsQuantity > 0 ");
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" AND +''''+B_GS_Departments+'''' LIKE '%," + po.getShopCode() + ",%' ");
		}

		sb.append("group by B_Gifts.B_GS_GoodsID )counttemp");
		sb.append(" DROP TABLE #GiftTmp");
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleCountGiftsBatch(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("select count(counttemp.GoodsID) from ( ");
		sb.append("select B_Gifts.B_GS_GoodsID as GoodsID,sum(temp1.goodsQuantity) as goodsQuantity,temp1.bgigoodsbarcode as bgigoodsbarcode from B_Gifts ");
		sb.append("inner join B_GoodsInfo on B_Gifts.B_GS_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append(" left join (  ");
		sb.append("         select warehouseName as warehouseName,StockId AS StockId,goodsId as goodsId,sum(goodsQuantity) as goodsQuantity,bgigoodsbarcode as bgigoodsbarcode from ( ");
		sb.append(" 		select B_WH_warehouseName    AS warehouseName,C_SH_SL_StockId       AS StockId,C_SH_SL_GoodsId       AS goodsId,C_SH_SL_GoodsQuantity AS goodsQuantity,C_SH_SL_GoodsBarCode  AS bgigoodsbarcode ");
		
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_JJ ");
		}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_PJ ");
		}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_JP ");
		}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_YX ");
		}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_HLY ");
		}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_TYJ ");
		}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_HC ");
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_LHJ ");
		}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_SG ");
		}else{
			sb.append("	FROM   C_SH_StorageLog ");				
		}
		
		sb.append(" 		inner join dbo.B_Warehouse on C_SH_SL_StockId = B_WH_ID ");
		sb.append(" ) temp  ");
		List<String> params = new ArrayList<String>();
		sb.append(" where temp.StockId = ( select B_WC_StockID10 from dbo.B_WarehouseConfiguration where B_WC_deptID = ? ) ");
		params.add(Utility.getName(po.getShopCode()));
		
		sb.append(" 	group by warehouseName,StockId,goodsId,bgigoodsbarcode) temp1 ");
		sb.append(" on temp1.goodsId = B_GI_GoodsID ");
		
		sb.append(" where B_GoodsInfo.B_GI_Flag='1' and B_Gifts.B_GS_Flag='1' and  B_Gifts.B_GS_AuditState='1'  ");
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and B_Gifts.B_GS_Departments like '%,' + '"+ po.getShopCode() +"' + ',%' ");
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_Gifts.B_GS_GoodsID like '%' + '"+ po.getBgigoodsid() +"' + '%'");
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID= '"+ po.getBgigoodscategoryid() +"'");
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		if(!"1".equals(Utility.getName(po.getBgisalestype()))){
			sb.append(" and temp1.goodsQuantity >0 ");
		}
		
		sb.append(" and isnull(temp1.bgigoodsbarcode,'') <> '' ");
		
		sb.append(" group by B_Gifts.B_GS_GoodsID,temp1.bgigoodsbarcode )counttemp");
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleList(GoodsInfoPo po, int start,int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		if(!"".equals(Utility.getName(po.getBgiwhichretail()))){
			sb.append("       bgiretailprice     AS bgiretailprice, ");
		}
		sb.append("       UPPER(bgigoodsbarcode+'00000000')    AS bgigoodsbarcode, ");
		sb.append("       UPPER(bgigoodsbarcode+'00000000')    AS bgipcbarcode, ");
		sb.append("       UPPER(bgigoodsid)         AS bgigoodsid, ");
		sb.append("       bgigoodsname       AS bgigoodsname, ");
		sb.append("       bgibrandname       AS bgibrandname, ");
		sb.append("       bgicostprice       AS bgicostprice, ");
		sb.append("       bginottaxrate      AS bginottaxrate, ");
		sb.append("       bgispec            AS bgispec, ");
		sb.append("       CASE ");
		sb.append("       WHEN bgigoodscategoryid = '8' THEN isnull(bgicolor,'') + isnull(bgisph,'') ");
		sb.append("       WHEN bgigoodscategoryid <> '8' THEN isnull(bgicolor,'') ");
		sb.append("       END                                         AS bgicolor, ");
		sb.append("       bgiiscustomize           AS bgiiscustomize, ");		
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
		sb.append("       bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append("       bgicurvature1up     AS bgicurvature1up , ");
		sb.append("       bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append("       bgicurvature2up     AS bgicurvature2up , ");
		sb.append("       bgicapacity     AS bgicapacity , ");
		sb.append("       bgicapacityentry     AS bgicapacityentry , ");
		sb.append("       bgiwholesaleprice     AS bgiwholesaleprice , ");
		sb.append("       bgiunitname     AS bgiunitname , ");
		sb.append("       fttid     AS fttid , ");
		sb.append("       bgitaxrate     AS bgitaxrate , ");
		sb.append("       bgisuppliername     AS bgisuppliername , ");
		sb.append("       bgisupplierid     AS bgisupplierid , ");
		sb.append("       bgisource     AS bgisource , ");	
		sb.append("       bgidiaul     AS bgidiaul , ");	
		sb.append("       bgidiaup     AS bgidiaup , ");
		sb.append("       bgiviewgoodsname     AS bgiviewgoodsname , ");
		sb.append("       bgiframematerialtypename     AS bgiframematerialtypename , ");
		sb.append("       bgisuppliercolor     AS bgisuppliercolor  ");
		List<String> params = new ArrayList<String>();
		if(!"".equals(Utility.getName(po.getBgiwhichretail()))){
			sb.append("       ,?     AS bgiwhichretail  ");
			params.add(po.getBgiwhichretail());
		}
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, ");
		
		sb.append("B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		
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
		sb.append("  B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append("  B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("  B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("  B_BD_brandName       AS bgibrandname, ");
		sb.append("  B_GI_CostPrice       AS bgicostprice, ");
		sb.append("  B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("  b_gi_supplierspec     AS bgisupplierspec , ");
		sb.append("  B_GI_Spec            AS bgispec, ");
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
		sb.append("  B_GI_Capacity     AS bgicapacity , ");
		sb.append("  B_GI_CapacityEntry     AS bgicapacityentry , ");
		sb.append("  B_GI_SupplierColor     AS bgisuppliercolor , ");		
		sb.append("  B_GoodsInfo.B_GI_WholesalePrice     AS bgiwholesaleprice , ");
		sb.append("  B_Unit.B_UT_unitName               AS bgiunitname, ");
		sb.append("  F_TechnologyType.F_TT_ID                AS fttid, ");
		sb.append("  B_GoodsInfo.B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("  B_Supplier.B_SP_SupplierName                AS bgisuppliername, ");
		sb.append("  B_GoodsInfo.B_GI_SupplierID                AS bgisupplierid, "); 
		sb.append("  B_BD_Place                AS bgisource, "); 
		sb.append("  B_GI_Color           AS bgicolor, ");
		sb.append("  B_GI_DiaUL           AS bgidiaul, ");
		sb.append("  B_GI_DiaUP           AS bgidiaup, ");
		sb.append("  B_FrameMaterial.B_FM_Name           AS bgiframematerialtypename, ");
		sb.append("  B_GI_ViewGoodsName           AS bgiviewgoodsname, ");
		sb.append("  isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append(" from b_goodsinfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID INNER JOIN B_Unit ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id LEFT OUTER JOIN F_TechnologyType ON B_GoodsInfo.B_GI_frameProcessCraftType = F_TechnologyType.F_TT_ID ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append(" where 1=1 and B_GoodsInfo.B_GI_Flag='1'");
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID <> '4' and B_GoodsInfo.B_GI_GoodsCategoryID <> '5' ");
		}
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleBPList(GoodsInfoPo po, int start,int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT * from( ");
		sb.append("SELECT  ROW_NUMBER() Over(order by bgigoodsbarcode) as rowNum, ");
		sb.append(" bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append(" bgiretailprice     AS bgiretailprice, ");
		sb.append(" GoodsQuantity      AS bgigoodsquantity, ");
		sb.append(" bgigoodsbarcode    AS bgigoodsbarcode, ");
		sb.append(" bgiviewgoodsname    AS bgiviewgoodsname, ");
		sb.append(" bgigoodsid         AS bgigoodsid, ");
		sb.append(" bgigoodsname       AS bgigoodsname, ");
		sb.append(" bgibrandname       AS bgibrandname, ");
		sb.append(" bgicostprice       AS bgicostprice, ");
		sb.append(" bginottaxrate      AS bginottaxrate, ");
		sb.append(" bgispec            AS bgispec, ");
		sb.append(" CASE ");
		sb.append(" WHEN bgigoodscategoryid = '8' THEN isnull(bgicolor,'') + bgisph ");
		sb.append(" WHEN bgigoodscategoryid <> '8' THEN isnull(bgicolor,'')  ");
		sb.append(" END                                         AS bgicolor, ");
		sb.append(" bgiiscustomize           AS bgiiscustomize, ");		
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
		sb.append(" bgiwholesaleprice     AS bgiwholesaleprice , ");
		sb.append(" bgiunitname     AS bgiunitname , ");
		sb.append(" fttid     AS fttid , ");
		sb.append(" bgitaxrate     AS bgitaxrate , ");
		sb.append(" bgisuppliername     AS bgisuppliername , ");
		sb.append(" bgisupplierid     AS bgisupplierid , ");
		sb.append(" bgisource     AS bgisource , ");	
		sb.append(" bgidiaul     AS bgidiaul , ");	
		sb.append(" bgidiaup     AS bgidiaup , ");
		sb.append(" bgiframematerialtypename     AS bgiframematerialtypename , ");
		sb.append(" bgisuppliercolor AS bgisuppliercolor ");
		sb.append(" ,guaranteeperiod as guaranteeperiod,batch as batch ");
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
		
		sb.append("   templog.GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append("   templog.GoodsQuantity    AS GoodsQuantity, ");
		sb.append("   B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("   B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("   B_BD_brandName       AS bgibrandname, ");
		sb.append("   B_GI_CostPrice       AS bgicostprice, ");
		sb.append("   B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("   B_GI_viewgoodsname    AS bgiviewgoodsname, ");
		sb.append("   B_GI_Spec            AS bgispec, ");
		sb.append("   B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append("   B_GI_FrameSize     AS bgiframesize , ");
		sb.append("   B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append("   B_GI_Sph     AS bgisph , ");
		sb.append("   B_GI_Cyl     AS bgicyl , ");
		sb.append("   B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append("   B_GI_Refractive     AS bgirefractive , ");
		sb.append("   B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append("   B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append("   B_GI_GradualClass     AS bgigradualclass , ");
		sb.append("   B_GI_SphUL     AS bgisphul , ");
		sb.append("   B_GI_SphUP     AS bgisphup , ");
		sb.append("   B_GI_CylUL     AS bgicylul , ");
		sb.append("   B_GI_CylUP     AS bgicylup , ");
		sb.append("   B_GI_Axis     AS bgiaxis , ");
		sb.append("   B_GI_BelowPlusLuminosityUL     AS bgibelowplusluminosityul , ");
		sb.append("   B_GI_BelowPlusLuminosityUP     AS bgibelowplusluminosityup , ");
		sb.append("   B_GI_FunctionClass     AS bgifunctionclass , ");
		sb.append("   B_GI_Curvature1     AS bgicurvature1 , ");
		sb.append("   B_GI_Dia     AS bgidia , ");
		sb.append("   B_GI_UseType     AS bgiusetype , ");
		sb.append("   B_GI_StealthClass     AS bgistealthclass , ");
		sb.append("   B_GI_AxisUL     AS bgiaxisul , ");
		sb.append("   B_GI_AxisUP     AS bgiaxisup , ");
		sb.append("   B_GI_Curvature1UL     AS bgicurvature1ul , ");
		sb.append("   B_GI_Curvature1UP     AS bgicurvature1up , ");
		sb.append("   B_GI_Curvature2UL     AS bgicurvature2ul , ");
		sb.append("   B_GI_Curvature2UP     AS bgicurvature2up , ");
		sb.append("   B_GI_Capacity     AS bgicapacity , ");
		sb.append("   B_GI_CapacityEntry     AS bgicapacityentry , ");
		sb.append("   B_GI_SupplierColor     AS bgisuppliercolor , ");		
		sb.append("   B_GoodsInfo.B_GI_WholesalePrice     AS bgiwholesaleprice , ");
		sb.append("   B_Unit.B_UT_unitName               AS bgiunitname, ");
		sb.append("   F_TechnologyType.F_TT_ID                AS fttid, ");
		sb.append("   B_GoodsInfo.B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("   B_Supplier.B_SP_SupplierName                AS bgisuppliername, ");
		sb.append("   B_GoodsInfo.B_GI_SupplierID                AS bgisupplierid, "); 
		sb.append("   B_BD_Place                AS bgisource, "); 
		sb.append("   B_GI_Color           AS bgicolor, ");
		sb.append("   B_GI_DiaUL           AS bgidiaul, ");
		sb.append("   B_GI_DiaUP           AS bgidiaup, ");
		sb.append("   B_FrameMaterial.B_FM_Name           AS bgiframematerialtypename, ");
		sb.append("   isnull(B_GI_isCustomize,'')           AS bgiiscustomize ");
		sb.append("   ,isnull(templog.GuaranteePeriod,'') as guaranteeperiod,isnull(templog.Batch,'') as batch ");
		sb.append(" from b_goodsinfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID INNER JOIN B_Unit ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id LEFT OUTER JOIN F_TechnologyType ON B_GoodsInfo.B_GI_frameProcessCraftType = F_TechnologyType.F_TT_ID ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append(" INNER JOIN ");
		sb.append(" ( select log.GoodsId as GoodsId,log.GoodsBarCode as GoodsBarCode,log.GuaranteePeriod as GuaranteePeriod,log.Batch as Batch,log.GoodsQuantity as GoodsQuantity from (");
		sb.append(" 	select C_SH_SL_GoodsId as GoodsId,C_SH_SL_GoodsBarCode as GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,'') as GuaranteePeriod,isnull(C_SH_SL_Batch,'') as Batch,sum(C_SH_SL_GoodsQuantity) as GoodsQuantity from C_SH_StorageLog left join B_Warehouse on C_SH_SL_StockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("  	where 1=1 ");
		if(!Utility.getName(po.getBgiwarehouseid()).equals("")){
			sb.append(" 	and C_SH_SL_StockId = ? ");
			params.add(po.getBgiwarehouseid());
		}
		if(!Utility.getName(po.getBgicompanyid()).equals("")){
			sb.append(" 	and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));
		}
		sb.append("  	group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') )log ");
		sb.append(" where 1=1 ");
		
		if("1".equals(po.getBgigoodsquantity())){
			sb.append(" 	and log.GoodsQuantity > 0 ");
		}
		sb.append(" ) templog on templog.GoodsId = B_GI_GoodsID ");
		sb.append(" where 1=1 ");
		
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
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
			sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
			if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
				params.add(po.getBgiretailbeginprice());
			}
			if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
				params.add(po.getBgiretailendprice());
			}
		}
		
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		//quyanping
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		
		sb.append(" ) temp )temp1 where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleZTList(GoodsInfoPo po, int start,int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append("       bgiretailprice     AS bgiretailprice, ");
		sb.append("       upper(bgigoodsbarcode)    AS bgigoodsbarcode, ");
		sb.append("       upper(bgigoodsid)         AS bgigoodsid, ");
		sb.append("       bgigoodsname       AS bgigoodsname, ");
		sb.append("       bgiviewgoodsname       AS bgiviewgoodsname, ");
		sb.append("       bgibrandname       AS bgibrandname, ");
		sb.append("       bgicostprice       AS bgicostprice, ");
		sb.append("       bginottaxrate      AS bginottaxrate, ");
		sb.append("       bgispec            AS bgispec, ");
		sb.append("       bgicolor           AS bgicolor, ");
		sb.append("       bgiiscustomize           AS bgiiscustomize, ");		
		sb.append("       bgiframematerialtype           AS bgiframematerialtype, ");
		sb.append("               bgiframesize     AS bgiframesize , ");
		sb.append("               bgiaccessoriestype     AS bgiaccessoriestype , ");
		sb.append("               bgisph     AS bgisph , ");
		sb.append("               bgicyl     AS bgicyl , ");
		sb.append("               bgibelowplusluminosity     AS bgibelowplusluminosity , ");
		sb.append("               bgirefractive     AS bgirefractive , ");
		sb.append("               bgiismutiluminosity     AS bgiismutiluminosity , ");
		sb.append("               bgieyeglassmaterialtype     AS bgieyeglassmaterialtype , ");
		sb.append("               bgigradualclass     AS bgigradualclass , ");
		sb.append("               bgisphul     AS bgisphul , ");
		sb.append("               bgisphup     AS bgisphup , ");
		sb.append("               bgicylul     AS bgicylul , ");
		sb.append("               bgicylup     AS bgicylup , ");
		sb.append("               bgiaxis     AS bgiaxis , ");
		sb.append("               bgibelowplusluminosityul     AS bgibelowplusluminosityul , ");
		sb.append("               bgibelowplusluminosityup     AS bgibelowplusluminosityup , ");
		sb.append("               bgifunctionclass     AS bgifunctionclass , ");
		sb.append("               bgicurvature1     AS bgicurvature1 , ");
		sb.append("               bgidia     AS bgidia , ");
		sb.append("               bgiusetype     AS bgiusetype , ");
		sb.append("               bgistealthclass     AS bgistealthclass , ");
		sb.append("               bgiaxisul     AS bgiaxisul , ");
		sb.append("               bgiaxisup     AS bgiaxisup , ");
		sb.append("               bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append("               bgicurvature1up     AS bgicurvature1up , ");
		sb.append("               bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append("               bgicurvature2up     AS bgicurvature2up , ");
		sb.append("               bgicapacity     AS bgicapacity , ");
		sb.append("               bgicapacityentry     AS bgicapacityentry , ");
		sb.append("               bgiwholesaleprice     AS bgiwholesaleprice , ");
		sb.append("               bgiunitname     AS bgiunitname , ");
		sb.append("               fttid     AS fttid , ");
		sb.append("               bgitaxrate     AS bgitaxrate , ");
		sb.append("               bgisuppliername     AS bgisuppliername , ");
		sb.append("               bgisupplierid     AS bgisupplierid , ");
		sb.append("               bgisource     AS bgisource , ");	
		sb.append("               bgidiaul     AS bgidiaul , ");	
		sb.append("               bgidiaup     AS bgidiaup , ");
		sb.append("               isnull(bgigoodsquantity,0)     AS bgigoodsquantity, ");
		sb.append("               bgiframematerialtypename     AS bgiframematerialtypename, ");
		sb.append("               bgiwarehousename            AS bgiwarehousename, ");
		sb.append("               upper(bgipcbarcode+'00000000')                AS bgipcbarcode, ");
		sb.append("               bgisuppliercolor     AS bgisuppliercolor,  ");
		sb.append("               bgiwarehouseid     AS bgiwarehouseid,  ");
		sb.append("               bgirksj as bgirksj,  ");
		sb.append("               bgiintransitgoodsnum     AS bgiintransitgoodsnum  ");
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		sb.append("               b_gi_retailprice     AS bgiretailprice, ");
		
//		if((Utility.getName(po.getBgistealtheffective()).equals("1") || Utility.getName(po.getBgistealtheffective()).equals("2")) && (!Utility.getName(po.getBgigoodsbarcode()).equals("") && (Utility.getName(po.getBgigoodsbarcode()).substring(0,1).equals("4") || Utility.getName(po.getBgigoodsbarcode()).substring(0,1).equals("5")))){
			sb.append("               isnull(kucun.GoodsBarCode,'')    AS bgigoodsbarcode, ");
//		}else{
//			sb.append("               (B_GI_GoodsBarCode+'00000000')    AS bgigoodsbarcode, ");
//		}
		
		sb.append("               B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("               B_GI_ViewGoodsName       AS bgigoodsname, ");
		sb.append("               B_BD_brandName       AS bgibrandname, ");
		sb.append("               B_GI_CostPrice       AS bgicostprice, ");
		sb.append("               B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("               B_GI_Spec            AS bgispec, ");
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
		sb.append("               B_GI_Capacity     AS bgicapacity , ");
		sb.append("               B_GI_CapacityEntry     AS bgicapacityentry , ");
		sb.append("               B_GI_SupplierColor     AS bgisuppliercolor , ");		
		sb.append("cast((dbo.ufn_getWholeSalePriceByDpt(?) * isnull(B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");		
		params.add(Utility.getName(po.getBgidepartmentid()));
		
		sb.append("               B_Unit.B_UT_unitName               AS bgiunitname, ");
		sb.append("               F_TechnologyType.F_TT_ID                AS fttid, ");
		sb.append("               B_GoodsInfo.B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("               B_Supplier.B_SP_SupplierName                AS bgisuppliername, ");
		sb.append("               B_GoodsInfo.B_GI_SupplierID                AS bgisupplierid, "); 
		sb.append("               B_BD_Place                AS bgisource, "); 
		sb.append("               B_GI_Color           AS bgicolor, ");
		sb.append("               B_GI_DiaUL           AS bgidiaul, ");
		sb.append("               B_GI_DiaUP           AS bgidiaup, ");
		sb.append("               B_GI_GoodsBarCode           AS bgipcbarcode, ");
		sb.append("               B_FrameMaterial.B_FM_Name           AS bgiframematerialtypename, ");
		sb.append("               kucun.GoodsQuantity 				  AS bgigoodsquantity, ");
		sb.append("               kucun.StockName 				  	  AS bgiwarehousename, ");
		sb.append("               kucun.StockId 				  	  AS bgiwarehouseid, ");
		sb.append("               isnull(B_GI_isCustomize,'')         AS bgiiscustomize, ");
		sb.append("               B_GI_ViewGoodsName         AS bgiviewgoodsname, ");
		sb.append("               B_GI_BarCodeFlag as bgirksj, ");
		sb.append("               isnull(zaitu.GoodsNum,0)         AS bgiintransitgoodsnum ");
		sb.append(" from b_goodsinfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID INNER JOIN B_Unit ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id LEFT OUTER JOIN F_TechnologyType ON B_GoodsInfo.B_GI_frameProcessCraftType = F_TechnologyType.F_TT_ID ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		
//		if((Utility.getName(po.getBgistealtheffective()).equals("1") || Utility.getName(po.getBgistealtheffective()).equals("2")) && (!Utility.getName(po.getBgigoodsbarcode()).equals("") && (Utility.getName(po.getBgigoodsbarcode()).substring(0,1).equals("4") || Utility.getName(po.getBgigoodsbarcode()).substring(0,1).equals("5")))){
			sb.append(" left join ( ");
			sb.append("	 	       SELECT C_SH_SL_GoodsId        AS GoodsId, ");
			sb.append("		              sum(C_SH_SL_GoodsQuantity) AS GoodsQuantity, ");
			sb.append("		              C_SH_SL_StockId       AS StockId, ");
			sb.append("		       B_WH_warehouseName AS StockName,C_SH_SL_GoodsBarCode as GoodsBarCode ");
			if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_JJ ");
			}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_PJ ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_JP ");
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_YX ");
			}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_HLY ");
			}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_TYJ ");
			}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_HC ");
			}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_LHJ ");
			}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" FROM C_SH_StorageLog_SG ");
			}else{
				sb.append("	FROM   C_SH_StorageLog ");				
			}

			sb.append("		       left join B_Warehouse on B_WH_ID=C_SH_SL_StockId ");

			if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
				sb.append(" WHERE C_SH_SL_StockId = ? ");
				params.add(po.getBgiwarehouseid());
			}
			if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
				sb.append(" and C_SH_SL_GoodsBarCode like '%' + ? + '%' ");
				params.add(Utility.getName(po.getBgigoodsbarcode()));
			}
			sb.append("		GROUP  BY C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsBarCode,B_WH_warehouseName ");
			sb.append(" ) kucun ");
			sb.append(" on B_GI_GoodsID = kucun.GoodsId ");
//		}else{
//			sb.append(" left join ( ");
//			sb.append("		SELECT GoodsId AS GoodsId, ");
//			sb.append("		       SUM(GoodsQuantity) AS GoodsQuantity, ");
//			sb.append("		       StockId 			  AS StockId, ");
//			sb.append("		       B_WH_warehouseName AS StockName ");
//			sb.append("		FROM  (SELECT C_SH_SB_GoodsId       AS GoodsId, ");
//			sb.append("		              C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
//			sb.append("		              C_SH_SB_StockId       AS StockId ");
//			sb.append("		       FROM   C_SH_StorageBeginning ");
//			sb.append("		       UNION ALL ");
//			sb.append("	 	       SELECT C_SH_SC_GoodsId        AS GoodsId, ");
//			sb.append("		              C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
//			sb.append("		              C_SH_SC_StockId       AS StockId ");
//			sb.append("		       FROM   C_SH_StorageChange)ktemp ");
//			sb.append("		       left join B_Warehouse on B_WH_ID=StockId ");
//			if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
//				sb.append(" WHERE ktemp.StockId = ? ");
//				params.add(po.getBgiwarehouseid());
//			}
//			sb.append("		GROUP  BY GoodsId,StockId,B_WH_warehouseName ");
//			sb.append(" ) kucun ");
//			sb.append(" on B_GI_GoodsID = kucun.GoodsId ");
//		}

		sb.append(" left join ( ");
		sb.append(" select C_SH_TSE_GoodsID as GoodsId,sum(C_SH_TSE_GoodsNum) as GoodsNum from C_SH_InTransitStorageEntry ");
		sb.append(" where 1=1 ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SH_TSE_OUTStockID = ? ");
			params.add(po.getBgiwarehouseid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and C_SH_TSE_GoodsBarCode = ? ");
			params.add(Utility.getName(po.getBgigoodsbarcode()));
		}
		sb.append(" group by C_SH_TSE_GoodsID)zaitu ");
		sb.append(" on B_GI_GoodsID = zaitu.GoodsId ");

		sb.append(" where 1=1 ");
		if(Utility.getName(po.getBgigoodsquantity()).equals("1")){
			sb.append(" and (isnull(kucun.GoodsQuantity,0)+isnull(zaitu.GoodsNum,0)) > 0 ");
		}
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID <> '4' and B_GoodsInfo.B_GI_GoodsCategoryID <> '5' ");
		}
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Sph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Sph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Cyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and kucun.StockId = ? ");
			params.add(po.getBgiwarehouseid());
		}
		sb.append(" ) temp ");
		sb.append(" where rowNum > " + start + " and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	public List<GoodsInfoPo> getGoodsSingleExchangeList(GoodsInfoPo po, int start,int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgipcbarcode as bgipcbarcode,TEMP.bgiwholesaleprice as bgiwholesaleprice,TEMP.bgisource as bgisource,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,temp.bgisupplierid as bgisupplierid,");
		sb.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
		sb.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.bgiflag as bgiflag , temp.fttid as fttid, temp.bgiIntegralCount as bgiIntegralCount ");
		sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
		sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_WholesalePrice as bgiwholesaleprice,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,B_GoodsInfo.B_GI_SupplierID as bgisupplierid,");
		sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,");
		sb.append("B_Brand.B_BD_brandName as bgibrandname,B_BD_Place as bgisource,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag,F_TechnologyType.F_TT_ID as fttid ,F_IntegralExchange.F_IR_IntegralCount as bgiIntegralCount ");
		sb.append(",B_GI_GoodsBarCode+'00000000' as bgipcbarcode ");
		sb.append(",B_GI_GoodsBarCode+'00000000' as bgigoodsbarcode ");
		sb.append(" from F_IntegralExchange inner join B_GoodsInfo on F_IntegralExchange.F_IR_GoodsID = B_GoodsInfo.B_GI_GoodsID inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id left outer join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID  ");
		sb.append("left join(select C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode,sum(C_SH_SL_GoodsQuantity) as GoodsQuantity from C_SH_StorageLog ");
		sb.append("inner join B_Warehouse on C_SH_SL_StockId=B_WH_ID ");
		sb.append("where B_WH_deptID=? ");
		sb.append("group by C_SH_SL_GoodsId,C_SH_SL_GoodsBarCode ");
		sb.append(")tt on C_SH_SL_GoodsId=B_GoodsInfo.B_GI_GoodsID ");
		sb.append("where F_IntegralExchange.F_IR_Flag='1' ");

		List<String> params = new ArrayList<String>();
		
		params.add(po.getShopCode());
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and (',' + F_IR_DepartmentID + ',') like '%,' + ? + ',%' ");
			params.add(po.getShopCode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and F_IntegralExchange.F_IR_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		
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
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and cast(F_IR_IntegralCount as numeric)>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and cast(F_IR_IntegralCount as numeric)<=?");
			params.add(po.getBgiretailendprice());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}
	
	public List<GoodsInfoPo> getGoodsSingleGiftsBatchList(GoodsInfoPo po, int start,int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT TEMP.bgigoodsid        AS bgigoodsid, ");
		sb.append(" TEMP.bgiwholesaleprice AS bgiwholesaleprice, ");
		sb.append(" TEMP.bgisource         AS bgisource, ");
		sb.append(" TEMP.bgigoodsname      AS bgigoodsname, ");
		sb.append(" TEMP.bgisuppliername   AS bgisuppliername, ");
		sb.append(" TEMP.bgisupplierid     AS bgisupplierid, ");
		sb.append(" TEMP.bgisph            AS bgisph, ");
		sb.append(" TEMP.bgicyl            AS bgicyl, ");
		sb.append(" TEMP.bgiaxis           AS bgiaxis, ");
		sb.append(" TEMP.bgicurvature1     AS bgicurvature1, ");
		sb.append(" TEMP.bgidia            AS bgidia, ");
		sb.append(" TEMP.bgitaxrate        AS bgitaxrate, ");
		sb.append(" TEMP.bgigoodsbarcode   AS bgigoodsbarcode, ");
		sb.append(" TEMP.bgispec           AS bgispec, ");
		sb.append(" TEMP.bgicolor          AS bgicolor, ");
		sb.append(" TEMP.bgibrandname      AS bgibrandname, ");
		sb.append(" TEMP.bgiunitname       AS bgiunitname, ");
		sb.append(" TEMP.bgicostprice      AS bgicostprice, ");
		sb.append(" TEMP.bgiretailprice    AS bgiretailprice, ");
		sb.append(" TEMP.bginottaxrate     AS bginottaxrate, ");
		sb.append(" TEMP.bgiflag           AS bgiflag, ");
//		sb.append(" TEMP.fttid             AS fttid, ");
		sb.append(" TEMP.bgiwarehousename  AS bgiwarehousename, ");
		sb.append(" TEMP.bgiwarehouseid    AS bgiwarehouseid, ");
		sb.append(" isnull(TEMP.bgigoodsquantity,0)  AS bgigoodsquantity, ");
		sb.append(" TEMP.guaranteeperiod   AS guaranteeperiod, ");
		sb.append(" TEMP.batch             AS batch ");
		sb.append("FROM  (SELECT Row_number() OVER(ORDER BY B_GoodsInfo.B_GI_GoodsID) AS rowNum, ");
		sb.append(" B_GoodsInfo.B_GI_GoodsID                             AS bgigoodsid, ");
		sb.append(" B_GoodsInfo.B_GI_WholesalePrice                      AS bgiwholesaleprice, ");
		sb.append(" B_GoodsInfo.B_GI_ViewGoodsName                           AS bgigoodsname, ");
		sb.append(" B_Supplier.B_SP_SupplierName                         AS bgisuppliername, ");
		sb.append(" B_GoodsInfo.B_GI_SupplierID                          AS bgisupplierid, ");
		sb.append(" B_GoodsInfo.B_GI_Spec                                AS bgispec, ");
		sb.append(" B_GoodsInfo.B_GI_Color                               AS bgicolor, ");
		sb.append(" B_GoodsInfo.B_GI_Sph                                 AS bgisph, ");
		sb.append(" B_GoodsInfo.B_GI_Cyl                                 AS bgicyl, ");
		sb.append(" B_GoodsInfo.B_GI_Axis                                AS bgiaxis, ");
		sb.append(" B_GoodsInfo.B_GI_Curvature1                          AS bgicurvature1, ");
		sb.append(" B_GoodsInfo.B_GI_Dia                                 AS bgidia, ");
		sb.append(" B_GoodsInfo.B_GI_TaxRate                             AS bgitaxrate, ");
		sb.append(" temp1.bgigoodsbarcode                                AS bgigoodsbarcode, ");
		sb.append(" temp1.guaranteeperiod 								  as guaranteeperiod, ");
		sb.append("	temp1.batch 										  as batch, ");
		sb.append(" B_Brand.B_BD_brandName                               AS bgibrandname, ");
		sb.append(" B_BD_Place                                           AS bgisource, ");
		sb.append(" B_Unit.B_UT_unitName                                 AS bgiunitname, ");
		sb.append(" B_GoodsInfo.B_GI_RetailPrice                         AS bgiretailprice, ");
		sb.append(" B_GoodsInfo.B_GI_CostPrice                           AS bgicostprice, ");
		sb.append(" B_GoodsInfo.B_GI_NotTaxRate                          AS bginottaxrate, ");
		sb.append(" B_GoodsInfo.B_GI_Flag                                AS bgiflag, ");
//		sb.append(" F_TechnologyType.F_TT_ID                             AS fttid, ");
		sb.append(" (select B_WH_warehouseName from dbo.B_Warehouse where B_WH_ID= ( select B_WC_StockID10 from dbo.B_WarehouseConfiguration where B_WC_deptID = ? )) AS bgiwarehousename, ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getShopCode()));
		sb.append("              ( select B_WC_StockID10 from dbo.B_WarehouseConfiguration where B_WC_deptID = ? ) AS bgiwarehouseid, ");
		params.add(Utility.getName(po.getShopCode()));
		sb.append("              temp1.goodsQuantity                                  AS bgigoodsquantity ");
		sb.append("       FROM   B_Gifts ");
		sb.append("              INNER JOIN B_GoodsInfo ");
		sb.append("                ON B_Gifts.B_GS_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("              INNER JOIN B_Supplier ");
		sb.append("                ON B_GoodsInfo.B_GI_SupplierID = B_Supplier.B_SP_ID ");
		sb.append("              INNER JOIN B_Brand ");
		sb.append("                ON B_GoodsInfo.B_GI_BrandID = B_Brand.B_BD_ID ");
		sb.append("                   AND B_GoodsInfo.B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
		sb.append("              INNER JOIN B_Unit ");
		sb.append("                ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
//		sb.append("              LEFT OUTER JOIN F_TechnologyType ");
//		sb.append("                ON B_GoodsInfo.B_GI_frameProcessCraftType = F_TechnologyType.F_TT_ID ");
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
		sb.append("	END as batch, ");
		sb.append("	warehouseName as warehouseName ");
		sb.append(" FROM   ( ");
		sb.append(" SELECT C_SH_Sl_StockId       AS StockId,");
		sb.append(" C_SH_Sl_GoodsId       AS goodsId,");
		sb.append("	C_SH_SL_GoodsBarCode  AS bgigoodsbarcode,");
		sb.append(" C_SH_Sl_GoodsQuantity AS goodsQuantity,");
		sb.append("	isnull(C_SH_SL_GuaranteePeriod,'') AS guaranteeperiod, ");
		sb.append("	isnull(C_SH_SL_Batch,'') as batch, ");
		sb.append(" B_WH_warehouseName AS warehouseName ");

		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_JJ ");
		}else if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_PJ ");
		}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_JP ");
		}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_YX ");
		}else if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_HLY ");
		}else if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_TYJ ");
		}else if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_HC ");
		}else if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_LHJ ");
		}else if("9".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" FROM C_SH_StorageLog_SG ");
		}else{
			sb.append("	FROM   C_SH_StorageLog ");				
		}
		
		sb.append(" inner join dbo.B_Warehouse on C_SH_SL_StockId = B_WH_ID ");
		sb.append(" where C_SH_Sl_StockId = ( select B_WC_StockID10 from dbo.B_WarehouseConfiguration where B_WC_deptID = ? ) ");
		params.add(Utility.getName(po.getShopCode()));
		sb.append("  ) sl  GROUP  BY warehouseName,StockId,goodsId,bgigoodsbarcode,guaranteeperiod,batch) temp1 ");
		
		sb.append(" on temp1.goodsId = B_GI_GoodsID ");
		sb.append(" WHERE B_GoodsInfo.B_GI_Flag = '1' ");
		sb.append("   AND B_Gifts.B_GS_Flag = '1' ");
		sb.append("   AND B_Gifts.B_GS_AuditState = '1' ");
		sb.append("   AND isnull(temp1.bgigoodsbarcode,'') <> '' ");
		if(!"1".equals(Utility.getName(po.getBgisalestype()))){
			sb.append(" and temp1.goodsQuantity > 0 ");
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and B_Gifts.B_GS_Departments like '%,' + ? + ',%' ");
			params.add(po.getShopCode());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_Gifts.B_GS_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	
	public List<GoodsInfoPo> getGoodsSingleGiftsList(GoodsInfoPo po, int start,int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
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
		
		params.add(Utility.getName(po.getShopCode()));
		params.add(Utility.getName(po.getShopCode()));
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT dbo.getInTransitNum(TEMP.bgigoodsid,TEMP.bgigoodsbarcode+'00000000',TEMP.bgiwarehouseid) AS bgiintransitgoodsnum, ");
		sb.append("		  TEMP.bgigoodsid        AS bgigoodsid, ");
		sb.append("       TEMP.bgiwholesaleprice AS bgiwholesaleprice, ");
		sb.append("       TEMP.bgisource         AS bgisource, ");
		sb.append("       TEMP.bgigoodsname      AS bgigoodsname, ");
		sb.append("       TEMP.bgisuppliername   AS bgisuppliername, ");
		sb.append("       TEMP.bgisupplierid     AS bgisupplierid, ");
		sb.append("       TEMP.bgisph            AS bgisph, ");
		sb.append("       TEMP.bgicyl            AS bgicyl, ");
		sb.append("       TEMP.bgiaxis           AS bgiaxis, ");
		sb.append("       TEMP.bgicurvature1     AS bgicurvature1, ");
		sb.append("       TEMP.bgidia            AS bgidia, ");
		sb.append("       TEMP.bgitaxrate        AS bgitaxrate, ");
		sb.append("       TEMP.bgigoodsbarcode+'00000000'   AS bgigoodsbarcode, ");
		sb.append("       TEMP.bgispec           AS bgispec, ");
		sb.append("       TEMP.bgicolor          AS bgicolor, ");
		sb.append("       TEMP.bgibrandname      AS bgibrandname, ");
		sb.append("       TEMP.bgiunitname       AS bgiunitname, ");
		sb.append("       TEMP.bgicostprice      AS bgicostprice, ");
		sb.append("       TEMP.bgiretailprice    AS bgiretailprice, ");
		sb.append("       TEMP.bginottaxrate     AS bginottaxrate, ");
		sb.append("       TEMP.bgiflag           AS bgiflag, ");
		sb.append("       TEMP.fttid             AS fttid, ");
		sb.append("       TEMP.bgiwarehousename  AS bgiwarehousename, ");
		sb.append("       TEMP.bgiwarehouseid    AS bgiwarehouseid, ");
		sb.append("       TEMP.bgigifttype 		 AS bgigifttype, ");
		sb.append("       isnull(TEMP.bgigoodsquantity,0)  AS bgigoodsquantity ");
		sb.append("FROM  (SELECT Row_number() OVER(ORDER BY B_GoodsInfo.B_GI_GoodsID) AS rowNum, ");
		sb.append(" B_GoodsInfo.B_GI_GoodsID                             AS bgigoodsid, ");
		sb.append(" B_GoodsInfo.B_GI_WholesalePrice                      AS bgiwholesaleprice, ");
		sb.append(" B_GoodsInfo.B_GI_ViewGoodsName                           AS bgigoodsname, ");
		sb.append(" B_Supplier.B_SP_SupplierName                         AS bgisuppliername, ");
		sb.append(" B_GoodsInfo.B_GI_SupplierID                          AS bgisupplierid, ");
		sb.append(" B_GoodsInfo.B_GI_Spec                                AS bgispec, ");
		sb.append(" B_GoodsInfo.B_GI_Color                               AS bgicolor, ");
		sb.append(" B_GoodsInfo.B_GI_Sph                                 AS bgisph, ");
		sb.append(" B_GoodsInfo.B_GI_Cyl                                 AS bgicyl, ");
		sb.append(" B_GoodsInfo.B_GI_Axis                                AS bgiaxis, ");
		sb.append(" B_GoodsInfo.B_GI_Curvature1                          AS bgicurvature1, ");
		sb.append(" B_GoodsInfo.B_GI_Dia                                 AS bgidia, ");
		sb.append(" B_GoodsInfo.B_GI_TaxRate                             AS bgitaxrate, ");
		sb.append(" B_GoodsInfo.B_GI_GoodsBarCode                        AS bgigoodsbarcode, ");
		sb.append(" B_Brand.B_BD_brandName                               AS bgibrandname, ");
		sb.append(" B_BD_Place                                           AS bgisource, ");
		sb.append(" B_Unit.B_UT_unitName                                 AS bgiunitname, ");
		sb.append(" B_GoodsInfo.B_GI_RetailPrice                         AS bgiretailprice, ");
		sb.append(" B_GoodsInfo.B_GI_CostPrice                           AS bgicostprice, ");
		sb.append(" B_GoodsInfo.B_GI_NotTaxRate                          AS bginottaxrate, ");
		sb.append(" B_GoodsInfo.B_GI_Flag                                AS bgiflag, ");
		sb.append(" F_TechnologyType.F_TT_ID                             AS fttid, ");
		sb.append(" giftStockName                             AS bgiwarehousename, ");
		sb.append(" giftStockId                             AS bgiwarehouseid, ");
		sb.append(" B_GS_Type 								AS bgigifttype, ");
		sb.append(" temp1.goodsQuantity		                AS bgigoodsquantity");
		sb.append("       FROM   #GiftTmp B_Gifts ");
		sb.append("              INNER JOIN B_GoodsInfo ");
		sb.append("                ON B_Gifts.B_GS_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		sb.append("              INNER JOIN B_Supplier ");
		sb.append("                ON B_GoodsInfo.B_GI_SupplierID = B_Supplier.B_SP_ID ");
		sb.append("              INNER JOIN B_Brand ");
		sb.append("                ON B_GoodsInfo.B_GI_BrandID = B_Brand.B_BD_ID ");
		sb.append("                   AND B_GoodsInfo.B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
		sb.append("              INNER JOIN B_Unit ");
		sb.append("                ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
		sb.append("              LEFT OUTER JOIN F_TechnologyType ");
		sb.append("                ON B_GoodsInfo.B_GI_frameProcessCraftType = F_TechnologyType.F_TT_ID ");
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
		sb.append("       WHERE  B_GoodsInfo.B_GI_Flag = '1' ");
		sb.append("              AND B_Gifts.B_GS_Flag = '1' ");
		sb.append("              AND B_Gifts.B_GS_AuditState = '1' ");

		if(!"1".equals(Utility.getName(po.getBgisalestype()))){
			sb.append(" and temp1.goodsQuantity > 0 ");
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" AND +''''+B_GS_Departments+'''' LIKE '%," + po.getShopCode() + ",%' ");
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_Gifts.B_GS_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigifttype()))) {
			sb.append(" and B_Gifts.B_GS_Type = ?");
			params.add(po.getBgigifttype());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
			params.add(po.getBgiretailbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
			params.add(po.getBgiretailendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		
		sb.append(" set rowcount 0");
		sb.append("drop table #GiftTmp ");
		
		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 获取商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsSingleAllCount(GoodsInfoPo po) {

		List<String> params = new ArrayList<String>();
		
		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_GI_GoodsID) from B_GoodsInfo ");
		sb.append(" inner join ( ");
		sb
				.append("SELECT C_SHA_AE_goodsId, SUM(C_SHA_AE_requirementQuantity) ");
		sb.append("AS bgigoodsquantity FROM C_SHA_Allocation ");
		sb.append("INNER JOIN C_SHA_AllocationEntry ON C_SHA_A_billID ");
		sb.append("= C_SHA_AE_billId and (C_SHA_A_flag = 1) AND ");
		sb.append("(C_SHA_A_auditState = 0 ");
		
		if (!"".equals(Utility.getName(po.getBgiallBillid()))) {
			sb.append(" and C_SHA_A_billID like '%' + ? ");
			params.add(po.getBgiallBillid());
		}
		
		sb.append(") GROUP BY C_SHA_AE_goodsId ");
		sb.append(") allTemp ON C_SHA_AE_goodsId = B_GI_GoodsID ");
		sb.append("inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb
				.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and  B_GI_SupplierID=B_BD_SupplierID ");
		// sb.append("inner join B_Variety on B_GI_VarietyID=B_Variety.B_VY_ID and B_GI_BrandID=B_Variety.B_VY_BrandID and B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb
				.append("inner join B_Unit on B_GI_UnitId=B_Unit.B_UT_id where B_GI_Flag='1' ");

		

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());

			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GI_isCustomize='0'");
			}
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取商品开窗的list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 商品list
	 */
	public List<GoodsInfoPo> getGoodsSingleAllList(GoodsInfoPo po, int start,
			int size) {
		
		List<String> params = new ArrayList<String>();

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,bgigoodsquantity,");
		sb.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
		sb.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.bgiflag as bgiflag ");
		sb.append(" from(select ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum,");
		sb.append("B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname,B_SP_SupplierName as bgisuppliername,");
		sb.append("B_GI_Spec as bgispec,B_GI_Color as bgicolor,B_GI_Sph as bgisph,B_GI_Cyl as bgicyl,B_GI_Axis as bgiaxis,B_GI_Curvature1 as bgicurvature1,B_GI_Dia as bgidia,B_GI_TaxRate as bgitaxrate,B_GI_GoodsBarCode as bgigoodsbarcode,");
		sb.append("B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,B_GI_RetailPrice as bgiretailprice,B_GI_CostPrice as bgicostprice,B_GI_NotTaxRate as bginottaxrate,B_GI_Flag as bgiflag, bgigoodsquantity ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_GI_SupplierID=B_SP_ID ");
		sb.append(" inner join ( ");
		sb.append("SELECT ROW_NUMBER() Over(order by C_SHA_AE_goodsId) as row,C_SHA_AE_goodsId, SUM(C_SHA_AE_requirementQuantity) ");
		sb.append("AS bgigoodsquantity FROM C_SHA_Allocation ");
		sb.append("INNER JOIN C_SHA_AllocationEntry ON C_SHA_A_billID ");
		sb.append("= C_SHA_AE_billId and (C_SHA_A_flag = 1) AND ");
		sb.append("(C_SHA_A_auditState = 0 ");
		
		if (!"".equals(Utility.getName(po.getBgiallBillid()))) {
			sb.append(" and C_SHA_A_billID like '%' + ? ");
			params.add(po.getBgiallBillid());
		}
		
		sb.append(") GROUP BY C_SHA_AE_goodsId ");
		sb.append(") allTemp ON C_SHA_AE_goodsId = B_GI_GoodsID ");
		
		sb.append("inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID ");
		// sb.append("inner join B_Variety on B_GI_VarietyID=B_Variety.B_VY_ID and B_GI_BrandID=B_Variety.B_VY_BrandID and B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb.append("inner join B_Unit on B_GI_UnitId=B_Unit.B_UT_id where B_GI_Flag='1' ");

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GI_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());

			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GI_isCustomize='0'");
			}
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}

		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getGoodsReceiptCount(InventoryPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(C_ST_Inventory.C_ST_I_BillID) from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' and C_ST_I_AllocationStatus='1' ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}

		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		//if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId='1' ");
		//	params.add(po.getCstibilltypeid());
		//}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))) {
			sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory=? ");
			params.add(po.getCstigoodscategory());
		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getGoodsReceiptList(InventoryPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.cstibillid as cstibillid,temp.cstisuppliername as cstisuppliername,temp.cstisourcebillid as cstisourcebillid,temp.cstibilltypeid as cstibilltypeid,");
		sb.append("temp.cstibilldate as cstibilldate,temp.cstiauditdate as cstiauditdate,temp.cstiinstockname as cstiinstockname,cstigoodscategoryname as cstigoodscategoryname,");
		sb.append("temp.cstiauditstate as cstiauditstate,temp.csticreatepersonname as csticreatepersonname,temp.cstiauditpersonname as cstiauditpersonname,cshastatusdepartmentid as cshastatusdepartmentid ");
		sb.append("from(select ROW_NUMBER() Over(order by C_ST_Inventory.C_ST_I_billDate desc,C_ST_Inventory.C_ST_I_BillID desc) as rowNum,C_ST_Inventory.C_ST_I_BillID as cstibillid,C_ST_Inventory.C_ST_I_SourceBillId as cstisourcebillid,C_ST_Inventory.C_ST_I_BillTypeId as cstibilltypeid,");
		sb.append("C_ST_Inventory.C_ST_I_billDate as cstibilldate,C_ST_Inventory.C_ST_I_AuditDate as cstiauditdate,B_Warehouse.B_WH_warehouseName as cstiinstockname,");
		sb.append("B_Supplier.B_SP_SupplierName as cstisuppliername,");
		sb.append("C_SHA_StatusDepartmentID as cshastatusdepartmentid ,B_GC_GoodsCategoryName as cstigoodscategoryname,");
		sb.append("C_ST_Inventory.C_ST_I_AuditState as cstiauditstate,a.personName as csticreatepersonname,b.personName as cstiauditpersonname from C_ST_Inventory ");
		sb.append("inner join B_Warehouse on C_ST_Inventory.C_ST_I_InStockId=B_Warehouse.B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		sb.append("inner join B_Supplier on B_Supplier.B_SP_ID=C_ST_Inventory.C_ST_I_SupplierId ");
		sb.append("left join B_GoodsCategory on B_GC_ID = C_ST_I_GoodsCategory ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_ST_Inventory.C_ST_I_createPerson=a.ID ");
		sb.append("left join C_SHA_Status on C_SHA_StatusReceiptID=C_ST_Inventory.C_ST_I_BillID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_ST_Inventory.C_ST_I_AuditPerson=b.ID where C_ST_Inventory.C_ST_I_BillTypeId='1' and C_ST_I_AllocationStatus='1' ");
		

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getCsticompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCsticompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCstibillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillID like '%' + ? + '%' ");
			params.add(po.getCstibillid());
		}
		if (!"".equals(Utility.getName(po.getCstisourcebillid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SourceBillId like '%' + ? + '%' ");
			params.add(po.getCstisourcebillid());
		}
		if (!"".equals(Utility.getName(po.getCstibilltypeid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_BillTypeId=? ");
			params.add(po.getCstibilltypeid());
		}
		if (!"".equals(Utility.getName(po.getCstiinstockid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_InStockId=? ");
			params.add(po.getCstiinstockid());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstate()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditState=? ");
			params.add(po.getCstiauditstate());
		}
		if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstistartTime());
			params.add(po.getCstiendTime());
		} else if (!"".equals(Utility.getName(po.getCstistartTime()))
				&& "".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) >= ? ");
			params.add(po.getCstistartTime());
		} else if ("".equals(Utility.getName(po.getCstistartTime()))
				&& !"".equals(Utility.getName(po.getCstiendTime()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_billDate, 23) <= ? ");
			params.add(po.getCstiendTime());
		}
		if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditstartdate());
			params.add(po.getCstiauditenddate());
		} else if (!"".equals(Utility.getName(po.getCstiauditstartdate()))
				&& "".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) >= ? ");
			params.add(po.getCstiauditstartdate());
		} else if ("".equals(Utility.getName(po.getCstiauditstartdate()))
				&& !"".equals(Utility.getName(po.getCstiauditenddate()))) {
			sb.append("and convert(varchar(10), C_ST_Inventory.C_ST_I_AuditDate, 23) <= ? ");
			params.add(po.getCstiauditenddate());
		}
		if (!"".equals(Utility.getName(po.getCsticreateperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_createPerson=? ");
			params.add(po.getCsticreateperson());
		}
		if (!"".equals(Utility.getName(po.getCstiauditperson()))) {
			sb.append("and C_ST_Inventory.C_ST_I_AuditPerson=? ");
			params.add(po.getCstiauditperson());
		}
		if (!"".equals(Utility.getName(po.getCstisupplierid()))) {
			sb.append("and C_ST_Inventory.C_ST_I_SupplierId=? ");
			params.add(po.getCstisupplierid());
		}
		
		if (!"".equals(Utility.getName(po.getCstigoodscategory()))) {
			sb.append("and C_ST_Inventory.C_ST_I_GoodsCategory=? ");
			params.add(po.getCstigoodscategory());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(),
				InventoryPo.class);
	}

	/**
	 * 获取库存预警的商品开窗的数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGoodsAlertCount(GoodsInfoPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(B_GI_GoodsID) FROM B_GoodsInfo ");
		sb.append("INNER JOIN C_SA_StockAlertSetting ON B_GI_GoodsID = C_SA_SA_GoodsID ");
		sb.append("left join ( ");
		sb.append("select GoodsId as GoodsId,sum(GoodsQuantity) as GoodsQuantity,warehouseid as warehouseid ");
		sb.append("from (select C_SH_SB_GoodsId as GoodsId ");
		sb.append(",C_SH_SB_GoodsQuantity as GoodsQuantity ");
		sb.append(",C_SH_SB_StockId as warehouseid ");
		sb.append("from C_SH_StorageBeginning ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" inner join B_Warehouse on C_SH_SB_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		sb.append(" where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append("  and C_SH_SB_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		sb.append(" union all ");
		sb.append("select C_SH_SC_GoodsId as GoodsId ");
		sb.append(",C_SH_SC_GoodsQuantity as GoodsQuantity ");
		sb.append(",C_SH_SC_StockId as warehouseid ");
		sb.append("from C_SH_StorageChange ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" inner join B_Warehouse on C_SH_SC_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		sb.append(" where 1 = 1 ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SH_SC_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}

		sb.append(")a group by GoodsId,warehouseid )c ");
		sb.append("on  B_GI_GoodsID=c.GoodsId AND c.warehouseid = C_SA_SA_StockID ");

		sb.append("left join ( ");
		sb.append("SELECT C_ST_PE_goodsID     AS GoodsId, ");
		sb.append("isnull(sum(C_ST_PE_OrderNumber),0) AS zaitu ");
		sb.append("FROM   C_ST_Po ");
		sb.append("INNER JOIN C_ST_PoEntry ");
		sb.append("ON C_ST_PE_PurchaseOrderID = C_ST_P_ID left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append("WHERE  C_ST_P_flag = '0' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		sb.append("AND C_ST_P_AuditState = '1' group by C_ST_PE_goodsID) d on d.GoodsId = c.GoodsId ");
		
		sb.append("where B_GI_Flag='1'  ");
		
		if(!"".equals(Utility.getName(po.getAlerttype()))){
			if("4".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockRed,0)  ");
			}
			
			if("3".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockRed,0)  ");
				sb.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockLower,0)  ");
			}
			
			if("2".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockLower,0)  ");
				sb.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockCap,0)  ");
			}
			
			if("1".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockCap,0)  ");
			}
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GI_ViewGoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GI_isCustomize='0'");
			}
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GI_BrandID='"+ po.getBgibrandid() +"'");
		}
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SA_SA_StockID = ? ");
			params.add(po.getBgiwarehouseid());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取库存预警的商品开窗的商品list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list
	 */
	public List<GoodsInfoPo> getGoodsAlertList(GoodsInfoPo po, int start,
			int size) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT * from (");
		sb.append("SELECT ROW_NUMBER() Over(order by case ");
		sb.append("when isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockRed,0) then '4' ");
		sb.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockRed,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockLower,0) then '3' ");
		sb.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockLower,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockCap,0)   then '2' ");
		sb.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockCap,0) then '1' ");
		sb.append("else '' ");
		sb.append("end desc) as rowNum ,B_GI_GoodsID           AS bgigoodsid, ");
		sb.append("       B_GI_ViewGoodsName         AS bgigoodsname, ");
		sb.append("       B_GI_Sph               AS bgisph, ");
		sb.append("       B_GI_Cyl               AS bgicyl, ");
		sb.append("  	  B_SP_SupplierName                AS bgisuppliername, ");
		sb.append("  	  B_GI_SupplierID                AS bgisupplierid, "); 
		sb.append("       B_GI_Axis              AS bgiaxis, ");
		sb.append("       B_GI_Curvature1        AS bgicurvature1, ");
		sb.append("       B_GI_Dia               AS bgidia, ");
		sb.append("       B_GI_Spec              AS bgispec, ");
		sb.append("       B_GI_Color             AS bgicolor, ");
		sb.append("       B_GI_TaxRate           AS bgitaxrate, ");
		sb.append("       B_GI_GoodsBarCode      AS bgigoodsbarcode, ");
		sb.append("       B_UT_unitName          AS bgiunitname, ");
		sb.append("       B_GI_CostPrice         AS bgicostprice, ");
		sb.append("       B_GI_RetailPrice       AS bgiretailprice, ");
		sb.append("       B_GI_NotTaxRate        AS bginottaxrate, ");
		sb.append("B_GI_FrameMaterialType    AS bgiframematerialtype , ");
		sb.append("B_FrameMaterial.B_FM_Name  AS bgiframematerialtypename , ");
		sb.append("B_GI_FrameSize     AS bgiframesize , ");
		sb.append("B_GI_AccessoriesType     AS bgiaccessoriestype , ");
		sb.append("B_GI_Capacity     AS bgicapacity , ");
		sb.append("B_GI_CapacityEntry     AS bgicapacityentry , ");
		sb.append("B_GI_SupplierColor     AS bgisuppliercolor , ");	
		sb.append("B_GI_BelowPlusLuminosity     AS bgibelowplusluminosity , ");
		sb.append("B_GI_Refractive     AS bgirefractive , ");
		sb.append("B_GI_isMutiLuminosity     AS bgiismutiluminosity , ");
		sb.append("B_GI_EyeGlassMaterialType     AS bgieyeglassmaterialtype , ");
		sb.append("B_GI_UseType     AS bgiusetype , ");
		sb.append("isnull(C_SA_SA_StockRed,0) as bgistorageredlimit, ");
		sb.append("B_GI_StealthClass     AS bgistealthclass , ");
		sb.append("case ");
		sb.append("when isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockRed,0) then '4' ");
		sb.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockRed,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockLower,0) then '3' ");
		sb.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockLower,0) and isnull(c.GoodsQuantity,0) <= isnull(C_SA_SA_StockCap,0)   then '2' ");
		sb.append("when isnull(c.GoodsQuantity,0) >  isnull(C_SA_SA_StockCap,0) then '1' ");
		sb.append("else '' ");
		sb.append("end as alerttype, ");
		sb.append("       B_GI_Flag              AS bgiflag, ");
		sb.append("       C_SA_SA_StockCap       AS bgistorageupperlimit, ");
		sb.append("       C_SA_SA_StockLower     AS bgistoragelowerlimit, ");
		sb.append("       isnull(c.GoodsQuantity,0)        AS bgigoodsquantity, ");
		sb.append("       B_GI_GoodsCategoryID   AS bgigoodscategoryid, ");
		sb.append("       Isnull(d.zaitu, 0)                AS zaitu, ");
		sb.append("       B_GC_GoodsCategoryName AS bgigoodscategoryname, ");
		sb.append("       B_WH_warehouseName          AS bgiwarehousename ");
		sb.append("FROM   B_GoodsInfo ");
		sb.append("       INNER JOIN C_SA_StockAlertSetting ");
		sb.append("         ON B_GI_GoodsID = C_SA_SA_GoodsID ");		
		sb.append("       LEFT JOIN (SELECT  ");
		sb.append("                                 GoodsId as GoodsId, ");
		sb.append("                                 sum(GoodsQuantity) as GoodsQuantity, ");
		sb.append("                                 warehouseid as warehouseid ");
		sb.append("                          FROM   ( ");
		sb.append("                                  SELECT C_SH_SB_GoodsId       AS GoodsId, ");
		sb.append("                                  C_SH_SB_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                  C_SH_SB_StockId       AS warehouseid ");
		sb.append("                                  FROM   C_SH_StorageBeginning ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" inner join B_Warehouse on C_SH_SB_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		sb.append(" where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SH_SB_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		sb.append("                                  UNION ALL ");
		sb.append("                                  SELECT C_SH_SC_GoodsId       AS GoodsId, ");
		sb.append("                                         C_SH_SC_GoodsQuantity AS GoodsQuantity, ");
		sb.append("                                         C_SH_SC_StockId       AS warehouseid ");
		sb.append("                                  FROM   C_SH_StorageChange ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" inner join B_Warehouse on C_SH_SC_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}
		
		sb.append(" where 1 = 1  ");
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append(" and C_SH_SC_StockId = ?  ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		sb.append(" )a ");
		sb.append("                  GROUP  BY GoodsId, ");
		sb.append("                            warehouseid ");
		sb.append("                            )c ");
		sb.append("         ON B_GI_GoodsID = c.GoodsId AND c.warehouseid = C_SA_SA_StockID ");

		sb.append("       INNER JOIN B_Unit ");
		sb.append("         ON B_UT_id = B_GI_UnitId ");
		sb.append("         INNER JOIN B_Warehouse   on B_WH_ID=C_SA_SA_StockID  ");
		sb.append("       left JOIN B_FrameMaterial ");
		sb.append("         ON B_FrameMaterial.B_FM_ID = B_GI_FrameMaterialType ");
		sb.append("       INNER JOIN B_GoodsCategory ");
		sb.append("         ON B_GC_ID = B_GI_GoodsCategoryID ");
		sb.append("       INNER JOIN B_Supplier ON B_SP_ID = B_GI_SupplierID ");
		sb.append(" left join ( ");
		sb.append(" SELECT C_ST_PE_goodsID     AS GoodsId, ");
		sb.append(" isnull(sum(C_ST_PE_OrderNumber),0) AS zaitu ");
		sb.append(" FROM   C_ST_Po ");
		sb.append(" INNER JOIN C_ST_PoEntry ON C_ST_PE_PurchaseOrderID = C_ST_P_ID left join B_Departments on C_ST_P_DepartmentID = B_DP_DepartmentID ");
		sb.append(" WHERE  C_ST_P_flag = '0' aND C_ST_P_AuditState = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		sb.append(" group by C_ST_PE_goodsID) d on d.GoodsId = c.GoodsId ");
		sb.append("WHERE  B_GI_Flag = '1' ");
		
		if(!"".equals(Utility.getName(po.getAlerttype()))){
			if("4".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockRed,0)  ");
			}
			
			if("3".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockRed,0)  ");
				sb.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockLower,0)  ");
			}
			
			if("2".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockLower,0)  ");
				sb.append("and isnull(c.GoodsQuantity, 0) <= isnull(C_SA_SA_StockCap,0)  ");
			}
			
			if("1".equals(Utility.getName(po.getAlerttype()))){
				sb.append("and isnull(c.GoodsQuantity, 0) >  isnull(C_SA_SA_StockCap,0)  ");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GI_BrandID='"+ po.getBgibrandid() +"'");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
			if ("3".equals(Utility.getName(po.getBgigoodscategoryid()))
					|| "4".equals(Utility.getName(po.getBgigoodscategoryid()))) {
				sb.append(" and B_GI_isCustomize='0'");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append("   AND B_GI_SupplierID = ?  ");
			params.add(po.getBgisupplierid());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwarehouseid()))) {
			sb.append("   AND C_SA_SA_StockID = ?   ");
			params.add(po.getBgiwarehouseid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append("   AND B_GoodsInfo.B_GI_GoodsID LIKE '%' + ? + '%' ");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append("   AND B_GoodsInfo.B_GI_ViewGoodsName LIKE '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		// if(!"".equals(Utility.getName(po.getBgivarietyid()))){
		// sb.append(" and B_GoodsInfo.B_GI_VarietyID='"+po.getBgivarietyid()+"'");
		// }
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0 ");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 获取批量开窗商品数量
	 */
	public int getMoreAdjuestmentPriceCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append(" where B_GoodsInfo.B_GI_Flag='1' ");
		List<String> params = new ArrayList<String>();
		if (!"".equals(goodsInfoPo.getBgigoodscategoryid())) {
			sb.append(" and B_GI_GoodsCategoryID=?");
			params.add(goodsInfoPo.getBgigoodscategoryid());
		}
		if (!"".equals(goodsInfoPo.getBgisupplierid())) {
			sb.append(" and B_GI_SupplierID=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(goodsInfoPo.getBgibrandid())) {
			sb.append(" and B_GI_BrandID=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if (!"".equals(goodsInfoPo.getBgiiscustomize())
				&& ("3".equals(goodsInfoPo.getBgigoodscategoryid()) || "4"
						.equals(goodsInfoPo.getBgigoodscategoryid()))) {
			sb.append(" and B_GI_isCustomize=?");
			params.add(goodsInfoPo.getBgiiscustomize());
			if ("0".equals(goodsInfoPo.getBgiiscustomize())) {
				if (!"".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb
							.append(" and convert(float,B_GI_Sph)<=? and convert(float,B_GI_Sph)>=? ");
					params.add(goodsInfoPo.getBgisphul());
					params.add(goodsInfoPo.getBgisphup());
				} else if (!"".equals(goodsInfoPo.getBgisphul())
						&& "".equals(goodsInfoPo.getBgisphup())) {
					sb.append(" and convert(float,B_GI_Sph)<=? ");
					params.add(goodsInfoPo.getBgisphul());
				} else if ("".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb.append("  and convert(float,B_GI_Sph)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}
				if (!"".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb
							.append(" and convert(float,B_GI_cyl)<=? and convert(float,B_GI_cyl)>=? ");
					params.add(goodsInfoPo.getBgicylul());
					params.add(goodsInfoPo.getBgicylup());
				} else if (!"".equals(goodsInfoPo.getBgicylul())
						&& "".equals(goodsInfoPo.getBgicylup())) {
					sb.append(" and convert(float,B_GI_cyl)<=? ");
					params.add(goodsInfoPo.getBgicylul());
				} else if ("".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb.append("  and convert(float,B_GI_cyl)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}

			} else {
				if (!"".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb
							.append(" and convert(float,B_GI_sphul)<=? and convert(float,B_GI_sphup)>=? ");
					params.add(goodsInfoPo.getBgicylul());
					params.add(goodsInfoPo.getBgicylup());
				} else if (!"".equals(goodsInfoPo.getBgisphul())
						&& "".equals(goodsInfoPo.getBgisphup())) {
					sb.append(" and convert(float,B_GI_sphul)<=? ");
					params.add(goodsInfoPo.getBgisphul());
				} else if ("".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb.append("  and convert(float,B_GI_sphup)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}

				if (!"".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb
							.append(" and convert(float,B_GI_cylul)<=? and convert(float,B_GI_cylup)>=? ");
					params.add(goodsInfoPo.getBgicylul());
					params.add(goodsInfoPo.getBgicylup());
				} else if (!"".equals(goodsInfoPo.getBgicylul())
						&& "".equals(goodsInfoPo.getBgicylup())) {
					sb.append(" and convert(float,B_GI_cylul)<=? ");
					params.add(goodsInfoPo.getBgisphul());
				} else if ("".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb.append("  and convert(float,B_GI_cylup)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}

			}
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取批量开窗商品List
	 */
	public List<GoodsInfoPo> getMoreAdjustmentPriceList(
			GoodsInfoPo goodsInfoPo, int start, int size) {

		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb
				.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,temp.bgiwholesaleprice as bgiwholesaleprice,");
		sb
				.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
		sb
				.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.bgiflag as bgiflag ");
		sb
				.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
		sb
				.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_WholesalePrice as bgiwholesaleprice,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
		sb
				.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GoodsInfo.B_GI_Axis as bgiaxis,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,");
		sb
				.append("B_Brand.B_BD_brandName as bgibrandname,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_NotTaxRate as bginottaxrate,B_GoodsInfo.B_GI_Flag as bgiflag ");
		sb
				.append(" from B_GoodsInfo inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb
				.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		// sb.append("inner join B_Variety on B_GoodsInfo.B_GI_VarietyID=B_Variety.B_VY_ID and B_GoodsInfo.B_GI_BrandID=B_Variety.B_VY_BrandID and B_GoodsInfo.B_GI_SupplierID=B_Variety.B_VY_SupplierID and B_GoodsInfo.B_GI_GoodsCategoryID=B_Variety.B_VY_GcID ");
		sb
				.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where B_GoodsInfo.B_GI_Flag='1' ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(goodsInfoPo.getBgigoodscategoryid())) {
			sb.append(" and B_GI_GoodsCategoryID=?");
			params.add(goodsInfoPo.getBgigoodscategoryid());
		}
		if (!"".equals(goodsInfoPo.getBgisupplierid())) {
			sb.append(" and B_GI_SupplierID=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(goodsInfoPo.getBgibrandid())) {
			sb.append(" and B_GI_BrandID=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if (!"".equals(goodsInfoPo.getBgiiscustomize())
				&& "3".equals(goodsInfoPo.getBgigoodscategoryid())) {
			sb.append(" and B_GI_isCustomize=?");
			params.add(goodsInfoPo.getBgiiscustomize());
			if ("0".equals(goodsInfoPo.getBgiiscustomize())) {
				if (!"".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb
							.append(" and convert(float,B_GI_Sph)<=? and convert(float,B_GI_Sph)>=? ");
					params.add(goodsInfoPo.getBgisphul());
					params.add(goodsInfoPo.getBgisphup());
				} else if (!"".equals(goodsInfoPo.getBgisphul())
						&& "".equals(goodsInfoPo.getBgisphup())) {
					sb.append(" and convert(float,B_GI_Sph)<=? ");
					params.add(goodsInfoPo.getBgisphul());
				} else if ("".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb.append("  and convert(float,B_GI_Sph)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}
				if (!"".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb
							.append(" and convert(float,B_GI_cyl)<=? and convert(float,B_GI_cyl)>=? ");
					params.add(goodsInfoPo.getBgicylul());
					params.add(goodsInfoPo.getBgicylup());
				} else if (!"".equals(goodsInfoPo.getBgicylul())
						&& "".equals(goodsInfoPo.getBgicylup())) {
					sb.append(" and convert(float,B_GI_cyl)<=? ");
					params.add(goodsInfoPo.getBgicylul());
				} else if ("".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb.append("  and convert(float,B_GI_cyl)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}

			} else {
				if (!"".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb
							.append(" and convert(float,B_GI_sphul)<=? and convert(float,B_GI_sphup)>=? ");
					params.add(goodsInfoPo.getBgicylul());
					params.add(goodsInfoPo.getBgicylup());
				} else if (!"".equals(goodsInfoPo.getBgisphul())
						&& "".equals(goodsInfoPo.getBgisphup())) {
					sb.append(" and convert(float,B_GI_sphul)<=? ");
					params.add(goodsInfoPo.getBgisphul());
				} else if ("".equals(goodsInfoPo.getBgisphul())
						&& !"".equals(goodsInfoPo.getBgisphup())) {
					sb.append("  and convert(float,B_GI_sphup)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}

				if (!"".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb
							.append(" and convert(float,B_GI_cylul)<=? and convert(float,B_GI_cylup)>=? ");
					params.add(goodsInfoPo.getBgicylul());
					params.add(goodsInfoPo.getBgicylup());
				} else if (!"".equals(goodsInfoPo.getBgicylul())
						&& "".equals(goodsInfoPo.getBgicylup())) {
					sb.append(" and convert(float,B_GI_cylul)<=? ");
					params.add(goodsInfoPo.getBgisphul());
				} else if ("".equals(goodsInfoPo.getBgicylul())
						&& !"".equals(goodsInfoPo.getBgicylup())) {
					sb.append("  and convert(float,B_GI_cylup)>=? ");
					params.add(goodsInfoPo.getBgicylup());
				}

			}
		}

		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return getJdbcTemplate().queryForList(sb.toString(), params.toArray());

	}
	
	public int getGoodsSingleAllCount1(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SHA_ApplyAllocation.C_SHA_AA_billID) from C_SHA_ApplyAllocation inner join C_SHA_ApplyAllocationEntry on C_SHA_AA_billID=C_SHA_AAE_billId ");
		sb.append("left join B_GoodsInfo on C_SHA_AAE_goodsId=B_GI_GoodsID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_AA_flag=1 and isnull(C_SHA_AA_OrderStatus,'0')='0' ");
		List<String> params = new ArrayList<String>();
		//params.add(po.getCshaaflag());
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and B_GI_SupplierID = ? ");
			params.add(po.getChaasupplier());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	public int getGoodsSingleAllCountForApp(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_ApplyAllocation.C_SHA_AA_billID) from C_SHA_ApplyAllocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");

		sb.append(" LEFT JOIN  C_SHA_Allocation ON  C_SHA_A_StatusBillID=C_SHA_AA_billID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_AA_ForAppFlag='1' AND C_SHA_AA_flag=1 ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and d.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if("1".equals(Utility.getName(po.getIsWriteoffs()))){
			sb.append("and isnull(C_SHA_AA_AllocationStatus,'0') = ? and ISNULL(C_SHA_A_StatusBillID,'') <> '' ");
			params.add(po.getIsWriteoffs());
		}
		
		if("0".equals(Utility.getName(po.getIsWriteoffs()))){
			sb.append("and isnull(C_SHA_AA_AllocationStatus,'0') = ? and ISNULL(C_SHA_A_StatusBillID,'') = '' ");
			params.add(po.getIsWriteoffs());
		}
		
		if("".equals(Utility.getName(po.getIsWriteoffs()))){
			sb.append(" AND ISNULL(C_SHA_A_StatusBillID,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid())))
		{
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(Utility.getName(po.getCshaaoutdepartmentid()));
		}
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory like '%'+?+'%' ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getGoodsSingleAllCount2(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_ApplyAllocation.C_SHA_AA_billID) from C_SHA_ApplyAllocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_AA_flag=1 and (C_SHA_AA_AllocationStatus=0 ) ");
		List<String> params = new ArrayList<String>();
		//params.add(po.getCshaaflag());
		
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory like '%'+?+'%' ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory <> '4' ");
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory <> '5' ");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getGoodsSingleAllCount3(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_Allocation.C_SHA_A_billID) from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_consignee=b.ID ");
//		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
//		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_A_flag=2 and C_SHA_A_consignState=1 and C_SHA_A_AllocationStatus=0 ");
		List<String> params = new ArrayList<String>();
		//params.add(po.getCshaaflag());
		
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
//		if(!"".equals(Utility.getName(po.getChaasupplier()))){
//			sb.append("and C_SHA_Allocation.C_SHA_A_supplier like '%'+?+'%' ");
//			params.add(po.getChaasupplier());
//		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	
	public int getGoodsSingleAllCountTui(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_Allocation.C_SHA_A_billID) from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_consignee=b.ID ");
		sb.append("where C_SHA_A_consignState=1 and C_SHA_A_ReturnStatus=0 ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_supplier = ? ");
			params.add(po.getChaasupplier());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getBrandCountForReturn(BrandPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(*) from dbo.B_Brand ");
		sb.append("inner join dbo.B_Supplier on B_BD_SupplierID = B_SP_ID ");
		sb.append("where 1=1 ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(po.getBbdsupplierid()))){
			sb.append("and B_BD_SupplierID = ? ");
			params.add(po.getBbdsupplierid());
		}
		
		if(!"".equals(Utility.getName(po.getBbdid()))){
			sb.append("and B_BD_ID = ? ");
			params.add(po.getBbdid());
		}
		
		if(!"".equals(Utility.getName(po.getBbdbrandname()))){
			sb.append("and B_BD_brandName like '%' + ? + '%' ");
			params.add(po.getBbdbrandname());
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public List<BrandPo> getBrandListForReturn(BrandPo po,int start,int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from( ");	
		sb.append("select ROW_NUMBER() Over(order by B_BD_ID desc) as rowNum,");
		sb.append("B_BD_GoodsCategory+'.'+B_BD_SupplierID+'.'+B_BD_ID as bbdid,");
		sb.append("B_BD_brandName as bbdbrandname,");
		sb.append("B_SP_SupplierName as bspsuppliername ");
		sb.append("from dbo.B_Brand ");
		sb.append("inner join dbo.B_Supplier on B_BD_SupplierID = B_SP_ID ");
		sb.append("where 1=1 ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(po.getBbdsupplierid()))){
			sb.append("and B_BD_SupplierID = ? ");
			params.add(po.getBbdsupplierid());
		}
		
		if(!"".equals(Utility.getName(po.getBbdid()))){
			sb.append("and B_BD_ID = ? ");
			params.add(po.getBbdid());
		}
		
		if(!"".equals(Utility.getName(po.getBbdbrandname()))){
			sb.append("and B_BD_brandName like '%' + ? + '%' ");
			params.add(po.getBbdbrandname());
		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(),params.toArray(),BrandPo.class);
	}
	
	public int getGoodsSingleAllCountOut(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_SHA_Allocation.C_SHA_A_billID) from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_consignee=b.ID ");
//		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
//		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)e on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=e.B_GC_ID ");
		sb.append("where C_SHA_A_flag=2 and C_SHA_A_consignState=1 and (C_SHA_A_SalesOutStatus=0 or C_SHA_A_SalesOutStatus is null) ");
		List<String> params = new ArrayList<String>();
		//params.add(po.getCshaaflag());
		
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaauditstate());
		}		
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
//		if(!"".equals(Utility.getName(po.getChaasupplier()))){
//			sb.append("and C_SHA_Allocation.C_SHA_A_supplier like '%'+?+'%' ");
//			params.add(po.getChaasupplier());
//		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}



	
	public List<AllocationPo> getGoodsSingleAllList1(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from ( ");
		sb.append("select ROW_NUMBER() Over(order by cshaabilldate desc) as rowNum,temp.cshaabillid as cshaabillid,temp.cshaaindepartmentname as cshaaindepartmentname,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid, ");
		sb.append("temp.chaasupplier as chaasupplier,temp.goodscategoryid as goodscategoryid,temp.cshaaoutdepartmentid as cshaaoutdepartmentid,temp.cshaaoutdepartmentname as cshaaoutdepartmentname ");
		sb.append("from(select distinct ");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_ApplyAllocation.C_SHA_AA_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_ApplyAllocation.C_SHA_AA_auditDate as cshaaauditdate,");
		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_auditState as cshaaauditstate,c.B_SP_ID as chaasupplier,f.B_GC_ID as goodscategoryid,d.B_DP_DepartmentID as cshaaoutdepartmentid,g.B_DP_DepartmentName as cshaaoutdepartmentname from C_SHA_ApplyAllocation ");
		sb.append("inner join C_SHA_ApplyAllocationEntry on C_SHA_AA_billID=C_SHA_AAE_billId ");
		sb.append("left join B_GoodsInfo on C_SHA_AAE_goodsId=B_GI_GoodsID ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		sb.append("left join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)g on C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=g.B_DP_DepartmentID ");
		
		sb.append(" where C_SHA_AA_flag=1 and isnull(C_SHA_AA_OrderStatus,'0')='0' ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}

		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and B_GI_GoodsCategoryID = ? ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and B_GI_SupplierID = ? ");
			params.add(po.getChaasupplier());
		}
		
		sb.append(" ) temp  ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	public List<AllocationPo> getGoodsSingleAllListForApp(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,temp.cshaaindepartmentname as cshaaindepartmentname,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid,temp.cshaaremark as cshaaremark, ");
		sb.append("temp.chaasupplier as chaasupplier,temp.goodscategoryid as goodscategoryid,temp.cshaaoutdepartmentid as cshaaoutdepartmentid ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_ApplyAllocation.C_SHA_AA_billDate desc,C_SHA_ApplyAllocation.C_SHA_AA_billID desc) as rowNum,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,C_SHA_AA_remark as cshaaremark,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_ApplyAllocation.C_SHA_AA_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_ApplyAllocation.C_SHA_AA_auditDate as cshaaauditdate,");
		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_auditState as cshaaauditstate,c.B_SP_ID as chaasupplier,f.B_GC_ID as goodscategoryid,d.B_DP_DepartmentID as cshaaoutdepartmentid from C_SHA_ApplyAllocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName,B_DP_CompanysID from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		sb.append(" LEFT JOIN  C_SHA_Allocation ON  C_SHA_A_StatusBillID=C_SHA_AA_billID ");
		sb.append(" where C_SHA_AA_ForAppFlag='1' AND C_SHA_AA_flag=1 ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and d.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if("1".equals(Utility.getName(po.getIsWriteoffs()))){
			sb.append("and C_SHA_AA_AllocationStatus=? and ISNULL(C_SHA_A_StatusBillID,'') <> '' ");
			params.add(po.getIsWriteoffs());
		}
		
		if("0".equals(Utility.getName(po.getIsWriteoffs()))){
			sb.append("and isnull(C_SHA_AA_AllocationStatus,'0') = ? and ISNULL(C_SHA_A_StatusBillID,'') = '' ");
			params.add(po.getIsWriteoffs());
		}
		
		if("".equals(Utility.getName(po.getIsWriteoffs()))){
			sb.append(" AND ISNULL(C_SHA_A_StatusBillID,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid())))
		{
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}

		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(Utility.getName(po.getCshaaoutdepartmentid()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory like '%'+?+'%' ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	public List<AllocationPo> getGoodsSingleAllList2(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,temp.cshaaindepartmentname as cshaaindepartmentname,");
		sb.append("temp.cshaacreatepersonname as cshaacreatepersonname,temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.chaasuppliername as chaasuppliername,temp.goodscategoryname as goodscategoryname,");
		sb.append("temp.cshaaauditstate as cshaaauditstate,temp.cshastatusorderid as cshastatusorderid ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_ApplyAllocation.C_SHA_AA_billDate desc,C_SHA_ApplyAllocation.C_SHA_AA_billID desc) as rowNum,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("a.personName as cshaacreatepersonname,C_SHA_ApplyAllocation.C_SHA_AA_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_ApplyAllocation.C_SHA_AA_auditDate as cshaaauditdate,");
		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,");
		sb.append("C_SHA_ApplyAllocation.C_SHA_AA_auditState as cshaaauditstate from C_SHA_ApplyAllocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_ApplyAllocation.C_SHA_AA_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_ApplyAllocation.C_SHA_AA_auditPerson=b.ID ");
		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		
		sb.append(" where (ISNULL(C_SHA_AA_ForAppFlag, '')='' OR C_SHA_AA_ForAppFlag='0') AND C_SHA_AA_flag=1 and C_SHA_AA_AllocationStatus=0 ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}

		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_ApplyAllocation.C_SHA_AA_auditDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_auditPerson like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
		
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory like '%'+?+'%' ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_supplier like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory <> '4' ");
			sb.append("and C_SHA_ApplyAllocation.C_SHA_AA_goodscategory <> '5' ");
		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	public List<AllocationPo> getGoodsSingleAllList3(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,temp.cshaaindepartmentname as cshaaindepartmentname,");
		sb.append(" temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.cshaaauditstate as cshaaauditstate ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_Allocation.C_SHA_A_consignDate desc,C_SHA_Allocation.C_SHA_A_billID desc) as rowNum,");
		sb.append("C_SHA_Allocation.C_SHA_A_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("C_SHA_Allocation.C_SHA_A_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_Allocation.C_SHA_A_consignDate as cshaaauditdate,");
//		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,");
		sb.append("C_SHA_Allocation.C_SHA_A_consignState as cshaaauditstate from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
//		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_consignee=b.ID ");
//		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
//		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
//		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		
		sb.append(" where C_SHA_A_flag=2 and C_SHA_A_consignState=1 and C_SHA_A_AllocationStatus=0 ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}

		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}	
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
//		if(!"".equals(Utility.getName(po.getChaasupplier()))){
//			sb.append("and C_SHA_Allocation.C_SHA_A_supplier like '%'+?+'%' ");
//			params.add(po.getChaasupplier());
//		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	public List<AllocationPo> getGoodsSingleAllListTui(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,temp.cshaaindepartmentname as cshaaindepartmentname,");
		sb.append(" temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.cshaaauditstate as cshaaauditstate ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_Allocation.C_SHA_A_consignDate desc,C_SHA_Allocation.C_SHA_A_billID desc) as rowNum,");
		sb.append("C_SHA_Allocation.C_SHA_A_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("C_SHA_Allocation.C_SHA_A_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_Allocation.C_SHA_A_consignDate as cshaaauditdate,");
		sb.append("C_SHA_Allocation.C_SHA_A_consignState as cshaaauditstate from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_consignee=b.ID ");
		
		sb.append(" where C_SHA_A_consignState=1 and C_SHA_A_ReturnStatus=0 ");
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			params.add(po.getCshaaindepartmentid());
		}

		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}	
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
//		if(!"".equals(Utility.getName(po.getChaasupplier()))){
//			sb.append("and C_SHA_Allocation.C_SHA_A_supplier like '%'+?+'%' ");
//			params.add(po.getChaasupplier());
//		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	
	
	public List<AllocationPo> getGoodsSingleAllListOut(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select temp.cshaabillid as cshaabillid,temp.cshaaindepartmentname as cshaaindepartmentname,");
		sb.append(" temp.cshaabilldate as cshaabilldate,");
		sb.append("temp.cshaaauditpersonname as cshaaauditpersonname,temp.cshaaauditdate as cshaaauditdate,");
		sb.append("temp.cshaaauditstate as cshaaauditstate ");
		sb.append("from(select ROW_NUMBER() Over(order by C_SHA_Allocation.C_SHA_A_consignDate desc,C_SHA_Allocation.C_SHA_A_billID desc) as rowNum,");
		sb.append("C_SHA_Allocation.C_SHA_A_billID as cshaabillid,d.B_DP_DepartmentName as cshaaindepartmentname,");
		sb.append("C_SHA_Allocation.C_SHA_A_billDate as cshaabilldate,b.personName as cshaaauditpersonname,C_SHA_Allocation.C_SHA_A_consignDate as cshaaauditdate,");
//		sb.append("c.B_SP_SupplierName as chaasuppliername,f.B_GC_GoodsCategoryName as goodscategoryname,e.C_SHA_StatusOrderID as cshastatusorderid,");
		sb.append("C_SHA_Allocation.C_SHA_A_consignState as cshaaauditstate from C_SHA_Allocation ");
		sb.append("inner join (select B_DP_DepartmentID,B_DP_DepartmentName from B_Departments)d on C_SHA_Allocation.C_SHA_A_inDepartmentId=d.B_DP_DepartmentID ");
//		sb.append("left join (select ID,personName from SYS_PersonInfo)a on C_SHA_Allocation.C_SHA_A_createPerson=a.ID ");
		sb.append("left join (select ID,personName from SYS_PersonInfo)b on C_SHA_Allocation.C_SHA_A_consignee=b.ID ");
//		sb.append("left join (select B_SP_ID,B_SP_SupplierName from B_Supplier)c on C_SHA_ApplyAllocation.C_SHA_AA_supplier=c.B_SP_ID ");
//		sb.append("left join (select B_GC_ID,B_GC_GoodsCategoryName from B_GoodsCategory)f on C_SHA_ApplyAllocation.C_SHA_AA_goodscategory=f.B_GC_ID ");
//		sb.append("left join (select * from C_SHA_Status)e on C_SHA_ApplyAllocation.C_SHA_AA_billID=e.C_SHA_StatusApplyBillID ");
		
		sb.append(" where C_SHA_A_flag=2 and C_SHA_A_consignState=1 and (C_SHA_A_SalesOutStatus=0 or C_SHA_A_SalesOutStatus is null) " );
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(po.getCshaaindepartmentid()))
		{
			sb.append("and C_SHA_Allocation.C_SHA_A_inDepartmentId=? ");
			//params.add(departmentsPo.getBdpdepartmentid());
			params.add(po.getCshaaindepartmentid());
		}

		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");//quyanping
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_outDepartmentId=? ");
			params.add(po.getCshaaoutdepartmentid());
		}	
		if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}else if(!"".equals(Utility.getName(po.getCshaaauditdatestart())) && "".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) >= ? ");
			params.add(po.getCshaaauditdatestart());
			
		}else if("".equals(Utility.getName(po.getCshaaauditdatestart())) && !"".equals(Utility.getName(po.getCshaaauditdateend()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_consignDate, 23) <= ? ");
			params.add(po.getCshaaauditdateend());
		}
		////////////////////////////////////////
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignState=? ");
			params.add(po.getCshaaauditstate());
		}
		
		if(!"".equals(Utility.getName(po.getCshaaauditperson()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_consignee like '%'+?+'%' ");
			params.add(po.getCshaaauditperson());
		}
//		if(!"".equals(Utility.getName(po.getChaasupplier()))){
//			sb.append("and C_SHA_Allocation.C_SHA_A_supplier like '%'+?+'%' ");
//			params.add(po.getChaasupplier());
//		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}

	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount(BrandPo brandPo){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(bspcategoryid) ");
		sb.append("from(select distinct B_GI_GoodsCategoryID as bspcategoryid, ");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		if("1".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailprice     AS bgiretailprice, ");
		}
		if("2".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricea     AS bgiretailprice, ");
		}
		if("3".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bgiretailprice, ");
		}
		if("4".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricec     AS bgiretailprice, ");
		}
		if("5".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriced     AS bgiretailprice, ");
		}
		if("6".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricee     AS bgiretailprice, ");
		}
		if("7".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricef     AS bgiretailprice, ");
		}
		if("8".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bgiretailprice, ");
		}
		if("9".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bgiretailprice, ");
		}
		if("10".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricei     AS bgiretailprice, ");
		}

		sb.append("substring(B_GI_GoodsID,1,7)+cast(B_GI_RetailPrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}	
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			sb.append(" AND B_BD_BrandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}
		
		if("1".equals(brandPo.getBbdismendretail())){
			if("1".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("2".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("3".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("4".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("5".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("6".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("7".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("8".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("9".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("10".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
		}else{
			if("1".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		sb.append(" )t");
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList(BrandPo brandPo, int start,int size){
		
		StringBuffer sb=new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from (select  ROW_NUMBER() Over(order by temp.bbdremark )as rowNum,* from");
		sb.append("(select distinct B_GI_GoodsCategoryID as bspcategoryid,");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		if("1".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailprice     AS bbdretailprice, ");
		}
		if("2".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricea     AS bbdretailprice, ");
		}
		if("3".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceb     AS bbdretailprice, ");
		}
		if("4".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricec     AS bbdretailprice, ");
		}
		if("5".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriced     AS bbdretailprice, ");
		}
		if("6".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricee     AS bbdretailprice, ");
		}
		if("7".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricef     AS bbdretailprice, ");
		}
		if("8".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceg     AS bbdretailprice, ");
		}
		if("9".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpriceh     AS bbdretailprice, ");
		}
		if("10".equals(brandPo.getBbdwhichretail())){
			sb.append(" b_gi_retailpricei     AS bbdretailprice, ");
		}
		sb.append(" ?     AS bbdwhichretail, ");
		params.add(brandPo.getBbdwhichretail());
		sb.append(" substring(B_GI_GoodsID,1,7)+cast(B_GI_RetailPrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}
		if (!"".equals(Utility.getName(brandPo.getBbdbrandname()))) {
			sb.append(" AND B_BD_BrandName like '%' + ? + '%' ");
			params.add(brandPo.getBbdbrandname());
		}
		if("1".equals(brandPo.getBbdismendretail())){
			if("1".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("2".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("3".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("4".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("5".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("6".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("7".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("8".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("9".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
			if("10".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(brandPo.getBbdminretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(brandPo.getBbdminretailPrice());
				}
				if (!"".equals(Utility.getName(brandPo.getBbdmaxretailPrice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(brandPo.getBbdmaxretailPrice());
				}
			}
		}else{
			if("1".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(brandPo.getBbdwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		sb.append(" ) temp )t where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");



		return queryForObjectList(sb.toString(), params.toArray(), BrandPo.class);
		
	}
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount2(BrandPo brandPo){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(bspcategoryid) ");
		sb.append("from(select distinct B_GI_GoodsCategoryID as bspcategoryid, ");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		sb.append("B_GI_CostPrice as bbdcostprice,substring(B_GI_GoodsID,1,7)+cast(B_GI_CostPrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}	
		
		if(!"".equals(Utility.getName(brandPo.getBbdbgncostprice()))){
			sb.append(" and B_GI_CostPrice >= cast(? as float) ");
			params.add(Utility.getName(brandPo.getBbdbgncostprice()));
		}	
		if(!"".equals(Utility.getName(brandPo.getBbdendcostprice()))){
			sb.append("  and B_GI_CostPrice <= cast(? as float) ");
			params.add(Utility.getName(brandPo.getBbdendcostprice()));
		}	
		
		sb.append(" )t");
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	public int getManyBrandPriceCountOpen(BrandPo brandPo){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(brands) ");
		sb.append("from(select distinct ");
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname "); 
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			if (Utility.getName(brandPo.getBbdsupplierid()).indexOf(",") < 0){
				sb.append(" and B_GI_SupplierID=?");
				params.add(brandPo.getBbdsupplierid());
			}else{
				String[] array = Utility.getName(brandPo.getBbdsupplierid()).split(",");
				sb.append(" and B_GI_SupplierID in ( ? ");
				params.add(array[0]);
				
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				
				sb.append(" ) ");
			}
			
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}	
		
		sb.append(" )t");
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList2(BrandPo brandPo, int start,int size){
		
		StringBuffer sb=new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from (select  ROW_NUMBER() Over(order by temp.bbdremark )as rowNum,* from");
		sb.append("(select distinct B_GI_GoodsCategoryID as bspcategoryid,");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		sb.append("B_GI_CostPrice as bbdcostprice,substring(B_GI_GoodsID,1,7)+cast(B_GI_CostPrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}
		
		if(!"".equals(Utility.getName(brandPo.getBbdbgncostprice()))){
			sb.append(" and B_GI_CostPrice >= cast(? as float) ");
			params.add(Utility.getName(brandPo.getBbdbgncostprice()));
		}	
		if(!"".equals(Utility.getName(brandPo.getBbdendcostprice()))){
			sb.append("  and B_GI_CostPrice <= cast(? as float) ");
			params.add(Utility.getName(brandPo.getBbdendcostprice()));
		}
		
		sb.append(" ) temp )t where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");



		return queryForObjectList(sb.toString(), params.toArray(), BrandPo.class);
		
	}
	
	public List<BrandPo> getManyBrandPriceOpenList(BrandPo brandPo, int start,int size){
		
		StringBuffer sb=new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from (select  ROW_NUMBER() Over(order by temp.brands )as rowNum,* from");
		sb.append("(select distinct ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands ");

		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			if (Utility.getName(brandPo.getBbdsupplierid()).indexOf(",") < 0){
				sb.append(" and B_GI_SupplierID=?");
				params.add(brandPo.getBbdsupplierid());
			}else{
				String[] array = Utility.getName(brandPo.getBbdsupplierid()).split(",");
				sb.append(" and B_GI_SupplierID in ( ? ");
				params.add(array[0]);
				
				for (int i = 1; i < array.length; i++){
					sb.append(" ,? ");
					params.add(array[i]);
				}
				
				sb.append(" ) ");
			}
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}
		
		sb.append(" ) temp )t where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), BrandPo.class);
	}
	
	/**
	 * 获取商品品种的数量
	 */	
	public int getBrandPriceCount3(BrandPo brandPo){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(bspcategoryid) ");
		sb.append("from(select distinct B_GI_GoodsCategoryID as bspcategoryid, ");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		sb.append("B_GI_WholesalePrice as bbdwholesaleprice,substring(B_GI_GoodsID,1,7)+cast(B_GI_WholesalePrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}		
		sb.append(" )t");
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	/**
	 * 获取商品品种的List
	 */	
	public List<BrandPo> getBrandPriceList3(BrandPo brandPo, int start,int size){
		
		StringBuffer sb=new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from (select  ROW_NUMBER() Over(order by temp.bbdremark )as rowNum,* from");
		sb.append("(select distinct B_GI_GoodsCategoryID as bspcategoryid,");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands, ");
		sb.append("isnull(B_GI_WholesalePrice,0) as bbdwholesaleprice,substring(B_GI_GoodsID,1,7)+cast(isnull(B_GI_WholesalePrice,'0') as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}
		sb.append(" ) temp )t where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");



		return queryForObjectList(sb.toString(), params.toArray(), BrandPo.class);
		
	}
	
	/**
	 * 获取商品的数量
	 */	
	public int getGoodsInfoCountForSOUT(GoodsInfoPo po){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select departmentID into #salesDepartments from sales_createShopCodeTab(?) ");
		params.add(po.getShopCode());
		sb.append("SELECT count(temp.bgigoodsid) from( ");
		sb.append("SELECT ");
		sb.append("       bgigoodscategoryid                          AS bgigoodscategoryid, ");
		sb.append("       bgisupplierid                               AS bgisupplierid, ");
		sb.append("       bgisuppliername                             AS bgisuppliername, ");
		sb.append("       bgibrandid                                  AS bgibrandid, ");
		sb.append("       bgibrandname                                AS bgibrandname, ");
		sb.append("       bgigoodsid                                  AS bgigoodsid, ");
		sb.append("       bgigoodsname                                AS bgigoodsname, ");
		sb.append("       Isnull(SUM(Isnull(bgigoodsquantity, 0)), 0) AS bgigoodsquantity, ");
		sb.append("       bgiretailprice                              AS bgiretailprice, ");
		sb.append("       bgispec                                     AS bgispec, ");
		sb.append("       bgiunitname                                 AS bgiunitname, ");
		sb.append("       bgigoodsbarcode                             AS bgigoodsbarcode, ");
		sb.append("       bgicostprice                                AS bgicostprice, ");
		sb.append("       bginottaxrate                               AS bginottaxrate, ");
		sb.append("       bgiframematerialtype                        AS bgiframematerialtype, ");
		sb.append("       bgiframesize                                AS bgiframesize, ");
		sb.append("       bgiaccessoriestype                          AS bgiaccessoriestype, ");
		sb.append("       bgisph                                      AS bgisph, ");
		sb.append("       bgicyl                                      AS bgicyl, ");
		sb.append("       bgibelowplusluminosity                      AS bgibelowplusluminosity, ");
		sb.append("       bgirefractive                               AS bgirefractive, ");
		sb.append("       bgiismutiluminosity                         AS bgiismutiluminosity, ");
		sb.append("       bgieyeglassmaterialtype                     AS bgieyeglassmaterialtype, ");
		sb.append("       bgigradualclass                             AS bgigradualclass, ");
		sb.append("       bgisphul                                    AS bgisphul, ");
		sb.append("       bgisphup                                    AS bgisphup, ");
		sb.append("       bgicylul                                    AS bgicylul, ");
		sb.append("       bgicylup                                    AS bgicylup, ");
		sb.append("       bgiaxis                                     AS bgiaxis, ");
		sb.append("       bgibelowplusluminosityul                    AS bgibelowplusluminosityul, ");
		sb.append("       bgibelowplusluminosityup                    AS bgibelowplusluminosityup, ");
		sb.append("       bgifunctionclass                            AS bgifunctionclass, ");
		sb.append("       bgicurvature1                               AS bgicurvature1, ");
		sb.append("       bgidia                                      AS bgidia, ");
		sb.append("       bgiusetype                                  AS bgiusetype, ");
		sb.append("       bgistealthclass                             AS bgistealthclass, ");
		sb.append("       bgiaxisul                                   AS bgiaxisul, ");
		sb.append("       bgiaxisup                                   AS bgiaxisup, ");
		sb.append("       bgicurvature1ul                             AS bgicurvature1ul, ");
		sb.append("       bgicurvature1up                             AS bgicurvature1up, ");
		sb.append("       bgicurvature2ul                             AS bgicurvature2ul, ");
		sb.append("       bgicurvature2up                             AS bgicurvature2up, ");
		sb.append("       bgicapacity                                 AS bgicapacity, ");
		sb.append("       bgicapacityentry                            AS bgicapacityentry, ");
		sb.append("       bgisuppliercolor                            AS bgisuppliercolor, ");
		sb.append("       bgiwholesaleprice                           AS bgiwholesaleprice, ");
		sb.append("       bgitaxrate                                  AS bgitaxrate, ");
		sb.append("       bgisource                                   AS bgisource, ");
		sb.append("       bgicolor                                    AS bgicolor, ");
		sb.append("       bgidiaul                                    AS bgidiaul, ");
		sb.append("       bgidiaup                                    AS bgidiaup, ");
		sb.append("       bgiframematerialtypename                    AS bgiframematerialtypename, ");
		sb.append("       bgiiscustomize                              AS bgiiscustomize ");
		sb.append("FROM  (SELECT bgigoodscategoryid                          AS bgigoodscategoryid, ");
		sb.append("              bgisupplierid                               AS bgisupplierid, ");
		sb.append("              bgisuppliername                             AS bgisuppliername, ");
		sb.append("              bgibrandid                                  AS bgibrandid, ");
		sb.append("              bgibrandname                                AS bgibrandname, ");
		sb.append("              bgigoodsid                                  AS bgigoodsid, ");
		sb.append("              bgigoodsname                                AS bgigoodsname, ");
		sb.append("              Isnull(SUM(Isnull(bgigoodsquantity, 0)), 0) AS bgigoodsquantity, ");
		sb.append("              bgiretailprice                              AS bgiretailprice, ");
		sb.append("              bgispec                                     AS bgispec, ");
		sb.append("              bgiunitname                                 AS bgiunitname, ");
		sb.append("              bgigoodsbarcode                             AS bgigoodsbarcode, ");
		sb.append("              bgicostprice                                AS bgicostprice, ");
		sb.append("              bginottaxrate                               AS bginottaxrate, ");
		sb.append("              bgiframematerialtype                        AS bgiframematerialtype, ");
		sb.append("              bgiframesize                                AS bgiframesize, ");
		sb.append("              bgiaccessoriestype                          AS bgiaccessoriestype, ");
		sb.append("              bgisph                                      AS bgisph, ");
		sb.append("              bgicyl                                      AS bgicyl, ");
		sb.append("              bgibelowplusluminosity                      AS bgibelowplusluminosity, ");
		sb.append("              bgirefractive                               AS bgirefractive, ");
		sb.append("              bgiismutiluminosity                         AS bgiismutiluminosity, ");
		sb.append("              bgieyeglassmaterialtype                     AS bgieyeglassmaterialtype, ");
		sb.append("              bgigradualclass                             AS bgigradualclass, ");
		sb.append("              bgisphul                                    AS bgisphul, ");
		sb.append("              bgisphup                                    AS bgisphup, ");
		sb.append("              bgicylul                                    AS bgicylul, ");
		sb.append("              bgicylup                                    AS bgicylup, ");
		sb.append("              bgiaxis                                     AS bgiaxis, ");
		sb.append("              bgibelowplusluminosityul                    AS bgibelowplusluminosityul, ");
		sb.append("              bgibelowplusluminosityup                    AS bgibelowplusluminosityup, ");
		sb.append("              bgifunctionclass                            AS bgifunctionclass, ");
		sb.append("              bgicurvature1                               AS bgicurvature1, ");
		sb.append("              bgidia                                      AS bgidia, ");
		sb.append("              bgiusetype                                  AS bgiusetype, ");
		sb.append("              bgistealthclass                             AS bgistealthclass, ");
		sb.append("              bgiaxisul                                   AS bgiaxisul, ");
		sb.append("              bgiaxisup                                   AS bgiaxisup, ");
		sb.append("              bgicurvature1ul                             AS bgicurvature1ul, ");
		sb.append("              bgicurvature1up                             AS bgicurvature1up, ");
		sb.append("              bgicurvature2ul                             AS bgicurvature2ul, ");
		sb.append("              bgicurvature2up                             AS bgicurvature2up, ");
		sb.append("              bgicapacity                                 AS bgicapacity, ");
		sb.append("              bgicapacityentry                            AS bgicapacityentry, ");
		sb.append("              bgisuppliercolor                            AS bgisuppliercolor, ");
		sb.append("              bgiwholesaleprice                           AS bgiwholesaleprice, ");
		sb.append("              bgitaxrate                                  AS bgitaxrate, ");
		sb.append("              bgisource                                   AS bgisource, ");
		sb.append("              bgicolor                                    AS bgicolor, ");
		sb.append("              bgidiaul                                    AS bgidiaul, ");
		sb.append("              bgidiaup                                    AS bgidiaup, ");
		sb.append("              bgiframematerialtypename                    AS bgiframematerialtypename, ");
		sb.append("              bgiiscustomize                              AS bgiiscustomize ");
		sb.append("       FROM   (SELECT R_RC_DSE_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append("                      R_RC_DSE_SupplierID             AS bgisupplierid, ");
		sb.append("                      R_RC_DSE_SupplierName           AS bgisuppliername, ");
		sb.append("                      R_RC_DSE_BandID                 AS bgibrandid, ");
		sb.append("                      R_RC_DSE_BandName               AS bgibrandname, ");
		sb.append("                      Isnull(R_SD_DSE_GoodsNum, 0)    AS bgigoodsquantity, ");
		sb.append("                      R_RC_DSE_GoodsID                AS bgigoodsid, ");
		sb.append("                      B_GI_ViewGoodsName              AS bgigoodsname, ");
		
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
		
		sb.append("                      B_GI_Spec                       AS bgispec, ");
		sb.append("                      B_UT_unitName                   AS bgiunitname, ");
		sb.append("                      B_GI_GoodsBarCode               AS bgigoodsbarcode, ");
		sb.append("                      B_GI_CostPrice                  AS bgicostprice, ");
		sb.append("                      B_GI_NotTaxRate                 AS bginottaxrate, ");
		sb.append("                      B_GI_FrameMaterialType          AS bgiframematerialtype, ");
		sb.append("                      B_GI_FrameSize                  AS bgiframesize, ");
		sb.append("                      B_GI_AccessoriesType            AS bgiaccessoriestype, ");
		sb.append("                      B_GI_Sph                        AS bgisph, ");
		sb.append("                      B_GI_Cyl                        AS bgicyl, ");
		sb.append("                      B_GI_BelowPlusLuminosity        AS bgibelowplusluminosity, ");
		sb.append("                      B_GI_Refractive                 AS bgirefractive, ");
		sb.append("                      B_GI_isMutiLuminosity           AS bgiismutiluminosity, ");
		sb.append("                      B_GI_EyeGlassMaterialType       AS bgieyeglassmaterialtype, ");
		sb.append("                      B_GI_GradualClass               AS bgigradualclass, ");
		sb.append("                      B_GI_SphUL                      AS bgisphul, ");
		sb.append("                      B_GI_SphUP                      AS bgisphup, ");
		sb.append("                      B_GI_CylUL                      AS bgicylul, ");
		sb.append("                      B_GI_CylUP                      AS bgicylup, ");
		sb.append("                      B_GI_Axis                       AS bgiaxis, ");
		sb.append("                      B_GI_BelowPlusLuminosityUL      AS bgibelowplusluminosityul, ");
		sb.append("                      B_GI_BelowPlusLuminosityUP      AS bgibelowplusluminosityup, ");
		sb.append("                      B_GI_FunctionClass              AS bgifunctionclass, ");
		sb.append("                      B_GI_Curvature1                 AS bgicurvature1, ");
		sb.append("                      B_GI_Dia                        AS bgidia, ");
		sb.append("                      B_GI_UseType                    AS bgiusetype, ");
		sb.append("                      B_GI_StealthClass               AS bgistealthclass, ");
		sb.append("                      B_GI_AxisUL                     AS bgiaxisul, ");
		sb.append("                      B_GI_AxisUP                     AS bgiaxisup, ");
		sb.append("                      B_GI_Curvature1UL               AS bgicurvature1ul, ");
		sb.append("                      B_GI_Curvature1UP               AS bgicurvature1up, ");
		sb.append("                      B_GI_Curvature2UL               AS bgicurvature2ul, ");
		sb.append("                      B_GI_Curvature2UP               AS bgicurvature2up, ");
		sb.append("                      B_GI_Capacity                   AS bgicapacity, ");
		sb.append("                      B_GI_CapacityEntry              AS bgicapacityentry, ");
		sb.append("                      B_GI_SupplierColor              AS bgisuppliercolor, ");
		sb.append("                      B_GoodsInfo.B_GI_WholesalePrice AS bgiwholesaleprice, ");
		sb.append("                      B_GoodsInfo.B_GI_TaxRate        AS bgitaxrate, ");
		sb.append("                      B_BD_Place                      AS bgisource, ");
		sb.append("                      B_GI_Color                      AS bgicolor, ");
		sb.append("                      B_GI_DiaUL                      AS bgidiaul, ");
		sb.append("                      B_GI_DiaUP                      AS bgidiaup, ");
		sb.append("                      B_FrameMaterial.B_FM_Name       AS bgiframematerialtypename, ");
		sb.append("                      Isnull(B_GI_isCustomize, '')    AS bgiiscustomize ");
		sb.append("               FROM   R_RC_DaySalesEntry  left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("                      LEFT JOIN B_GoodsInfo ");
		sb.append("                        ON B_GI_GoodsID = R_RC_DSE_GoodsID ");
		sb.append("                      LEFT JOIN B_Brand ");
		sb.append("                        ON B_BD_ID = B_GI_BrandID ");
		sb.append("                           AND B_GI_SupplierID = B_BD_SupplierID ");
		sb.append("                      LEFT JOIN B_Supplier ");
		sb.append("                        ON B_GI_SupplierID = B_SP_ID ");
		sb.append("                      LEFT JOIN B_Unit ");
		sb.append("                        ON B_UT_id = B_GI_UnitId ");
		sb.append("                      LEFT JOIN B_FrameMaterial ");
		sb.append("                        ON B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append("               WHERE  R_SD_DSE_SalesType = '1' and B_GI_Flag = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" 	  AND B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" 	  AND B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append("       AND B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append("       AND B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid())) && !"no".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("       AND B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		sb.append("               UNION ALL ");
		sb.append("               SELECT R_RC_DSE_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append("                      R_RC_DSE_SupplierID             AS bgisupplierid, ");
		sb.append("                      R_RC_DSE_SupplierName           AS bgisuppliername, ");
		sb.append("                      R_RC_DSE_BandID                 AS bgibrandid, ");
		sb.append("                      R_RC_DSE_BandName               AS bgibrandname, ");
		sb.append("                      Isnull(R_SD_DSE_GoodsNum, 0)    AS bgigoodsquantity, ");
		sb.append("                      R_RC_DSE_GoodsID                AS bgigoodsid, ");
		sb.append("                      B_GI_ViewGoodsName              AS bgigoodsname, ");
		
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
		
		sb.append("                      B_GI_Spec                       AS bgispec, ");
		sb.append("                      B_UT_unitName                   AS bgiunitname, ");
		sb.append("                      B_GI_GoodsBarCode               AS bgigoodsbarcode, ");
		sb.append("                      B_GI_CostPrice                  AS bgicostprice, ");
		sb.append("                      B_GI_NotTaxRate                 AS bginottaxrate, ");
		sb.append("                      B_GI_FrameMaterialType          AS bgiframematerialtype, ");
		sb.append("                      B_GI_FrameSize                  AS bgiframesize, ");
		sb.append("                      B_GI_AccessoriesType            AS bgiaccessoriestype, ");
		sb.append("                      B_GI_Sph                        AS bgisph, ");
		sb.append("                      B_GI_Cyl                        AS bgicyl, ");
		sb.append("                      B_GI_BelowPlusLuminosity        AS bgibelowplusluminosity, ");
		sb.append("                      B_GI_Refractive                 AS bgirefractive, ");
		sb.append("                      B_GI_isMutiLuminosity           AS bgiismutiluminosity, ");
		sb.append("                      B_GI_EyeGlassMaterialType       AS bgieyeglassmaterialtype, ");
		sb.append("                      B_GI_GradualClass               AS bgigradualclass, ");
		sb.append("                      B_GI_SphUL                      AS bgisphul, ");
		sb.append("                      B_GI_SphUP                      AS bgisphup, ");
		sb.append("                      B_GI_CylUL                      AS bgicylul, ");
		sb.append("                      B_GI_CylUP                      AS bgicylup, ");
		sb.append("                      B_GI_Axis                       AS bgiaxis, ");
		sb.append("                      B_GI_BelowPlusLuminosityUL      AS bgibelowplusluminosityul, ");
		sb.append("                      B_GI_BelowPlusLuminosityUP      AS bgibelowplusluminosityup, ");
		sb.append("                      B_GI_FunctionClass              AS bgifunctionclass, ");
		sb.append("                      B_GI_Curvature1                 AS bgicurvature1, ");
		sb.append("                      B_GI_Dia                        AS bgidia, ");
		sb.append("                      B_GI_UseType                    AS bgiusetype, ");
		sb.append("                      B_GI_StealthClass               AS bgistealthclass, ");
		sb.append("                      B_GI_AxisUL                     AS bgiaxisul, ");
		sb.append("                      B_GI_AxisUP                     AS bgiaxisup, ");
		sb.append("                      B_GI_Curvature1UL               AS bgicurvature1ul, ");
		sb.append("                      B_GI_Curvature1UP               AS bgicurvature1up, ");
		sb.append("                      B_GI_Curvature2UL               AS bgicurvature2ul, ");
		sb.append("                      B_GI_Curvature2UP               AS bgicurvature2up, ");
		sb.append("                      B_GI_Capacity                   AS bgicapacity, ");
		sb.append("                      B_GI_CapacityEntry              AS bgicapacityentry, ");
		sb.append("                      B_GI_SupplierColor              AS bgisuppliercolor, ");
		sb.append("                      B_GoodsInfo.B_GI_WholesalePrice AS bgiwholesaleprice, ");
		sb.append("                      B_GoodsInfo.B_GI_TaxRate        AS bgitaxrate, ");
		sb.append("                      B_BD_Place                      AS bgisource, ");
		sb.append("                      B_GI_Color                      AS bgicolor, ");
		sb.append("                      B_GI_DiaUL                      AS bgidiaul, ");
		sb.append("                      B_GI_DiaUP                      AS bgidiaup, ");
		sb.append("                      B_FrameMaterial.B_FM_Name       AS bgiframematerialtypename, ");
		sb.append("                      Isnull(B_GI_isCustomize, '')    AS bgiiscustomize ");
		sb.append("               FROM   R_RC_DaySalesEntry left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("                      LEFT JOIN B_GoodsInfo ");
		sb.append("                        ON B_GI_GoodsID = R_RC_DSE_GoodsID ");
		sb.append("                      LEFT JOIN B_Brand ");
		sb.append("                        ON B_BD_ID = B_GI_BrandID ");
		sb.append("                           AND B_GI_SupplierID = B_BD_SupplierID ");
		sb.append("                      LEFT JOIN B_Supplier ");
		sb.append("                        ON B_GI_SupplierID = B_SP_ID ");
		sb.append("                      LEFT JOIN B_Unit ");
		sb.append("                        ON B_UT_id = B_GI_UnitId ");
		sb.append("                      LEFT JOIN B_FrameMaterial ");
		sb.append("                        ON B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append("               WHERE  R_SD_DSE_SalesType = '2' and B_GI_Flag = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}

		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" 	  AND B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" 	  AND B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append("       AND B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append("       AND B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid())) && !"no".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("       AND B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		sb.append("       )TEMP ");
		sb.append("       GROUP  BY bgigoodscategoryid, ");
		sb.append("                 bgisupplierid, ");
		sb.append("                 bgisuppliername, ");
		sb.append("                 bgibrandid, ");
		sb.append("                 bgibrandname, ");
		sb.append("                 bgigoodsid, ");
		sb.append("                 bgigoodsname, ");
		sb.append("                 bgiretailprice, ");
		sb.append("                 bgispec, ");
		sb.append("                 bgiunitname, ");
		sb.append("                 bgigoodsbarcode, ");
		sb.append("                 bgicostprice, ");
		sb.append("                 bginottaxrate, ");
		sb.append("                 bgiframematerialtype, ");
		sb.append("                 bgiframesize, ");
		sb.append("                 bgiaccessoriestype, ");
		sb.append("                 bgisph, ");
		sb.append("                 bgicyl, ");
		sb.append("                 bgibelowplusluminosity, ");
		sb.append("                 bgirefractive, ");
		sb.append("                 bgiismutiluminosity, ");
		sb.append("                 bgieyeglassmaterialtype, ");
		sb.append("                 bgigradualclass, ");
		sb.append("                 bgisphul, ");
		sb.append("                 bgisphup, ");
		sb.append("                 bgicylul, ");
		sb.append("                 bgicylup, ");
		sb.append("                 bgiaxis, ");
		sb.append("                 bgibelowplusluminosityul, ");
		sb.append("                 bgibelowplusluminosityup, ");
		sb.append("                 bgifunctionclass, ");
		sb.append("                 bgicurvature1, ");
		sb.append("                 bgidia, ");
		sb.append("                 bgiusetype, ");
		sb.append("                 bgistealthclass, ");
		sb.append("                 bgiaxisul, ");
		sb.append("                 bgiaxisup, ");
		sb.append("                 bgicurvature1ul, ");
		sb.append("                 bgicurvature1up, ");
		sb.append("                 bgicurvature2ul, ");
		sb.append("                 bgicurvature2up, ");
		sb.append("                 bgicapacity, ");
		sb.append("                 bgicapacityentry, ");
		sb.append("                 bgisuppliercolor, ");
		sb.append("                 bgiwholesaleprice, ");
		sb.append("                 bgitaxrate, ");
		sb.append("                 bgisource, ");
		sb.append("                 bgicolor, ");
		sb.append("                 bgidiaul, ");
		sb.append("                 bgidiaup, ");
		sb.append("                 bgiframematerialtypename, ");
		sb.append("                 bgiiscustomize) TEMP ");
		sb.append("GROUP  BY bgigoodscategoryid, ");
		sb.append("          bgisupplierid, ");
		sb.append("          bgisuppliername, ");
		sb.append("          bgibrandid, ");
		sb.append("          bgibrandname, ");
		sb.append("          bgigoodsid, ");
		sb.append("          bgigoodsname, ");
		sb.append("          bgiretailprice, ");
		sb.append("          bgispec, ");
		sb.append("          bgiunitname, ");
		sb.append("          bgigoodsbarcode, ");
		sb.append("          bgicostprice, ");
		sb.append("          bginottaxrate, ");
		sb.append("          bgiframematerialtype, ");
		sb.append("          bgiframesize, ");
		sb.append("          bgiaccessoriestype, ");
		sb.append("          bgisph, ");
		sb.append("          bgicyl, ");
		sb.append("          bgibelowplusluminosity, ");
		sb.append("          bgirefractive, ");
		sb.append("          bgiismutiluminosity, ");
		sb.append("          bgieyeglassmaterialtype, ");
		sb.append("          bgigradualclass, ");
		sb.append("          bgisphul, ");
		sb.append("          bgisphup, ");
		sb.append("          bgicylul, ");
		sb.append("          bgicylup, ");
		sb.append("          bgiaxis, ");
		sb.append("          bgibelowplusluminosityul, ");
		sb.append("          bgibelowplusluminosityup, ");
		sb.append("          bgifunctionclass, ");
		sb.append("          bgicurvature1, ");
		sb.append("          bgidia, ");
		sb.append("          bgiusetype, ");
		sb.append("          bgistealthclass, ");
		sb.append("          bgiaxisul, ");
		sb.append("          bgiaxisup, ");
		sb.append("          bgicurvature1ul, ");
		sb.append("          bgicurvature1up, ");
		sb.append("          bgicurvature2ul, ");
		sb.append("          bgicurvature2up, ");
		sb.append("          bgicapacity, ");
		sb.append("          bgicapacityentry, ");
		sb.append("          bgisuppliercolor, ");
		sb.append("          bgiwholesaleprice, ");
		sb.append("          bgitaxrate, ");
		sb.append("          bgisource, ");
		sb.append("          bgicolor, ");
		sb.append("          bgidiaul, ");
		sb.append("          bgidiaup, ");
		sb.append("          bgiframematerialtypename, ");
		sb.append("          bgiiscustomize)temp ");
		sb.append("   where bgigoodsquantity > 0 ");
		
		sb.append("drop table #shopCode ");
		
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
	
	/**
	 * 获取商品List
	 */	
	public List<GoodsInfoPo> getGoodsInfoListForSOUT(GoodsInfoPo po, int start,int size){
		
		StringBuffer sb=new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("SELECT departmentID ");
		sb.append("INTO #salesDepartments ");
		sb.append("FROM Sales_createshopcodetab(?) ");
		params.add(po.getShopCode());
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("SELECT * from( ");
		sb.append("SELECT ROW_NUMBER() Over(order by bgigoodsid)as rowNum,* from( ");
		sb.append("SELECT ");
		sb.append(" bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append(" bgisupplierid AS bgisupplierid, ");
		sb.append(" bgisuppliername AS bgisuppliername, ");
		sb.append(" bgibrandid AS bgibrandid, ");
		sb.append(" bgibrandname AS bgibrandname, ");
		sb.append(" bgigoodsid AS bgigoodsid, ");
		sb.append(" bgigoodsname AS bgigoodsname, ");
		sb.append(" Isnull(SUM(Isnull(bgigoodsquantity, 0)), 0) AS bgigoodsquantity, ");
		sb.append(" bgiretailprice AS bgiretailprice, ");
		sb.append(" bgispec AS bgispec, ");
		sb.append(" bgiunitname AS bgiunitname, ");
		sb.append(" bgigoodsbarcode AS bgigoodsbarcode, ");
		sb.append(" bgicostprice AS bgicostprice, ");
		sb.append(" bginottaxrate AS bginottaxrate, ");
		sb.append(" bgiframematerialtype AS bgiframematerialtype, ");
		sb.append(" bgiframesize AS bgiframesize, ");
		sb.append(" bgiaccessoriestype AS bgiaccessoriestype, ");
		sb.append(" bgisph AS bgisph, ");
		sb.append(" bgicyl AS bgicyl, ");
		sb.append(" bgibelowplusluminosity AS bgibelowplusluminosity, ");
		sb.append(" bgirefractive AS bgirefractive, ");
		sb.append(" bgiismutiluminosity AS bgiismutiluminosity, ");
		sb.append(" bgieyeglassmaterialtype AS bgieyeglassmaterialtype, ");
		sb.append(" bgigradualclass AS bgigradualclass, ");
		sb.append(" bgisphul AS bgisphul, ");
		sb.append(" bgisphup AS bgisphup, ");
		sb.append(" bgicylul AS bgicylul, ");
		sb.append(" bgicylup AS bgicylup, ");
		sb.append(" bgiaxis AS bgiaxis, ");
		sb.append(" bgibelowplusluminosityul AS bgibelowplusluminosityul, ");
		sb.append(" bgibelowplusluminosityup AS bgibelowplusluminosityup, ");
		sb.append(" bgifunctionclass AS bgifunctionclass, ");
		sb.append(" bgicurvature1 AS bgicurvature1, ");
		sb.append(" bgidia AS bgidia, ");
		sb.append(" bgiusetype AS bgiusetype, ");
		sb.append(" bgistealthclass AS bgistealthclass, ");
		sb.append(" bgiaxisul AS bgiaxisul, ");
		sb.append(" bgiaxisup AS bgiaxisup, ");
		sb.append(" bgicurvature1ul AS bgicurvature1ul, ");
		sb.append(" bgicurvature1up AS bgicurvature1up, ");
		sb.append(" bgicurvature2ul AS bgicurvature2ul, ");
		sb.append(" bgicurvature2up AS bgicurvature2up, ");
		sb.append(" bgicapacity AS bgicapacity, ");
		sb.append(" bgicapacityentry AS bgicapacityentry, ");
		sb.append(" bgisuppliercolor AS bgisuppliercolor, ");
		sb.append(" bgiwholesaleprice AS bgiwholesaleprice, ");
		sb.append(" bgitaxrate AS bgitaxrate, ");
		sb.append(" bgisource AS bgisource, ");
		sb.append(" bgicolor AS bgicolor, ");
		sb.append(" bgidiaul AS bgidiaul, ");
		sb.append(" bgidiaup AS bgidiaup, ");
		sb.append(" bgiframematerialtypename AS bgiframematerialtypename, ");
		sb.append(" bgiiscustomize AS bgiiscustomize ");
		sb.append("FROM (SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		sb.append(" bgisupplierid AS bgisupplierid, ");
		sb.append(" bgisuppliername AS bgisuppliername, ");
		sb.append(" bgibrandid AS bgibrandid, ");
		sb.append(" bgibrandname AS bgibrandname, ");
		sb.append(" bgigoodsid AS bgigoodsid, ");
		sb.append(" bgigoodsname AS bgigoodsname, ");
		sb.append(" Isnull(SUM(Isnull(bgigoodsquantity, 0)), 0) AS bgigoodsquantity, ");
		sb.append(" bgiretailprice AS bgiretailprice, ");
		sb.append(" bgispec AS bgispec, ");
		sb.append(" bgiunitname AS bgiunitname, ");
		sb.append(" bgigoodsbarcode AS bgigoodsbarcode, ");
		sb.append(" bgicostprice AS bgicostprice, ");
		sb.append(" bginottaxrate AS bginottaxrate, ");
		sb.append(" bgiframematerialtype AS bgiframematerialtype, ");
		sb.append(" bgiframesize AS bgiframesize, ");
		sb.append(" bgiaccessoriestype AS bgiaccessoriestype, ");
		sb.append(" bgisph AS bgisph, ");
		sb.append(" bgicyl AS bgicyl, ");
		sb.append(" bgibelowplusluminosity AS bgibelowplusluminosity, ");
		sb.append(" bgirefractive AS bgirefractive, ");
		sb.append(" bgiismutiluminosity AS bgiismutiluminosity, ");
		sb.append(" bgieyeglassmaterialtype AS bgieyeglassmaterialtype, ");
		sb.append(" bgigradualclass AS bgigradualclass, ");
		sb.append(" bgisphul AS bgisphul, ");
		sb.append(" bgisphup AS bgisphup, ");
		sb.append(" bgicylul AS bgicylul, ");
		sb.append(" bgicylup AS bgicylup, ");
		sb.append(" bgiaxis AS bgiaxis, ");
		sb.append(" bgibelowplusluminosityul AS bgibelowplusluminosityul, ");
		sb.append(" bgibelowplusluminosityup AS bgibelowplusluminosityup, ");
		sb.append(" bgifunctionclass AS bgifunctionclass, ");
		sb.append(" bgicurvature1 AS bgicurvature1, ");
		sb.append(" bgidia AS bgidia, ");
		sb.append(" bgiusetype AS bgiusetype, ");
		sb.append(" bgistealthclass AS bgistealthclass, ");
		sb.append(" bgiaxisul AS bgiaxisul, ");
		sb.append(" bgiaxisup AS bgiaxisup, ");
		sb.append(" bgicurvature1ul AS bgicurvature1ul, ");
		sb.append(" bgicurvature1up AS bgicurvature1up, ");
		sb.append(" bgicurvature2ul AS bgicurvature2ul, ");
		sb.append(" bgicurvature2up AS bgicurvature2up, ");
		sb.append(" bgicapacity AS bgicapacity, ");
		sb.append(" bgicapacityentry AS bgicapacityentry, ");
		sb.append(" bgisuppliercolor AS bgisuppliercolor, ");
		sb.append(" bgiwholesaleprice AS bgiwholesaleprice, ");
		sb.append(" bgitaxrate AS bgitaxrate, ");
		sb.append(" bgisource AS bgisource, ");
		sb.append(" bgicolor AS bgicolor, ");
		sb.append(" bgidiaul AS bgidiaul, ");
		sb.append(" bgidiaup AS bgidiaup, ");
		sb.append(" bgiframematerialtypename AS bgiframematerialtypename, ");
		sb.append(" bgiiscustomize AS bgiiscustomize ");
		sb.append(" FROM (SELECT R_RC_DSE_GoodsCategoryID AS bgigoodscategoryid, ");
		sb.append(" R_RC_DSE_SupplierID AS bgisupplierid, ");
		sb.append(" B_SP_SupplierName AS bgisuppliername, ");
		sb.append(" R_RC_DSE_BandID AS bgibrandid, ");
		sb.append(" R_RC_DSE_BandName AS bgibrandname, ");
		sb.append(" Isnull(R_SD_DSE_GoodsNum, 0) AS bgigoodsquantity, ");
		sb.append(" R_RC_DSE_GoodsID AS bgigoodsid, ");
		sb.append(" B_GI_ViewGoodsName AS bgigoodsname, ");
		
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei AS bgiretailprice, ");
		}

		sb.append("                      B_GI_Spec                       AS bgispec, ");
		sb.append("                      B_UT_unitName                   AS bgiunitname, ");
		sb.append("                      B_GI_GoodsBarCode               AS bgigoodsbarcode, ");
		sb.append("                      B_GI_CostPrice                  AS bgicostprice, ");
		sb.append("                      B_GI_NotTaxRate                 AS bginottaxrate, ");		
		sb.append("                      B_GI_FrameMaterialType          AS bgiframematerialtype, ");
		sb.append("                      B_GI_FrameSize                  AS bgiframesize, ");
		sb.append("                      B_GI_AccessoriesType            AS bgiaccessoriestype, ");
		sb.append("                      B_GI_Sph                        AS bgisph, ");
		sb.append("                      B_GI_Cyl                        AS bgicyl, ");
		sb.append("                      B_GI_BelowPlusLuminosity        AS bgibelowplusluminosity, ");
		sb.append("                      B_GI_Refractive                 AS bgirefractive, ");
		sb.append("                      B_GI_isMutiLuminosity           AS bgiismutiluminosity, ");
		sb.append("                      B_GI_EyeGlassMaterialType       AS bgieyeglassmaterialtype, ");
		sb.append("                      B_GI_GradualClass               AS bgigradualclass, ");
		sb.append("                      B_GI_SphUL                      AS bgisphul, ");
		sb.append("                      B_GI_SphUP                      AS bgisphup, ");
		sb.append("                      B_GI_CylUL                      AS bgicylul, ");
		sb.append("                      B_GI_CylUP                      AS bgicylup, ");
		sb.append("                      B_GI_Axis                       AS bgiaxis, ");
		sb.append("                      B_GI_BelowPlusLuminosityUL      AS bgibelowplusluminosityul, ");
		sb.append("                      B_GI_BelowPlusLuminosityUP      AS bgibelowplusluminosityup, ");
		sb.append("                      B_GI_FunctionClass              AS bgifunctionclass, ");
		sb.append("                      B_GI_Curvature1                 AS bgicurvature1, ");
		sb.append("                      B_GI_Dia                        AS bgidia, ");
		sb.append("                      B_GI_UseType                    AS bgiusetype, ");
		sb.append("                      B_GI_StealthClass               AS bgistealthclass, ");
		sb.append("                      B_GI_AxisUL                     AS bgiaxisul, ");
		sb.append("                      B_GI_AxisUP                     AS bgiaxisup, ");
		sb.append("                      B_GI_Curvature1UL               AS bgicurvature1ul, ");
		sb.append("                      B_GI_Curvature1UP               AS bgicurvature1up, ");
		sb.append("                      B_GI_Curvature2UL               AS bgicurvature2ul, ");
		sb.append("                      B_GI_Curvature2UP               AS bgicurvature2up, ");
		sb.append("                      B_GI_Capacity                   AS bgicapacity, ");
		sb.append("                      B_GI_CapacityEntry              AS bgicapacityentry, ");
		sb.append("                      B_GI_SupplierColor              AS bgisuppliercolor, ");
		
		sb.append("cast((dbo.ufn_getWholeSalePriceByDpt(?) * isnull(B_GoodsInfo.B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");
		params.add(Utility.getName(po.getBgidepartmentid()));
		
		sb.append("                      B_GoodsInfo.B_GI_TaxRate        AS bgitaxrate, ");
		sb.append("                      B_BD_Place                      AS bgisource, ");
		sb.append("                      B_GI_Color                      AS bgicolor, ");
		sb.append("                      B_GI_DiaUL                      AS bgidiaul, ");
		sb.append("                      B_GI_DiaUP                      AS bgidiaup, ");
		sb.append("                      B_FrameMaterial.B_FM_Name       AS bgiframematerialtypename, ");
		sb.append("                      Isnull(B_GI_isCustomize, '')    AS bgiiscustomize ");
		sb.append("               FROM   R_RC_DaySalesEntry  left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("                      LEFT JOIN B_GoodsInfo ");
		sb.append("                        ON B_GI_GoodsID = R_RC_DSE_GoodsID ");
		sb.append("                      LEFT JOIN B_Brand ");
		sb.append("                        ON B_BD_ID = B_GI_BrandID ");
		sb.append("                           AND B_GI_SupplierID = B_BD_SupplierID ");
		sb.append("                      LEFT JOIN B_Supplier ");
		sb.append("                        ON B_GI_SupplierID = B_SP_ID ");
		sb.append("                      LEFT JOIN B_Unit ");
		sb.append("                        ON B_UT_id = B_GI_UnitId ");
		sb.append("                      LEFT JOIN B_FrameMaterial ");
		sb.append("                        ON B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append("               WHERE  R_SD_DSE_SalesType = '1'  and B_GI_Flag = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}

		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append(" AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append(" AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" AND B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" AND B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" AND B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" AND B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid())) && !"no".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" AND B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		sb.append(" UNION ALL ");
		sb.append(" SELECT R_RC_DSE_GoodsCategoryID AS bgigoodscategoryid, ");
		sb.append(" R_RC_DSE_SupplierID AS bgisupplierid, ");
		sb.append(" B_SP_SupplierName AS bgisuppliername, ");
		sb.append(" R_RC_DSE_BandID AS bgibrandid, ");
		sb.append(" R_RC_DSE_BandName AS bgibrandname, ");
		sb.append(" Isnull(R_SD_DSE_GoodsNum, 0) AS bgigoodsquantity, ");
		sb.append(" R_RC_DSE_GoodsID AS bgigoodsid, ");
		sb.append(" B_GI_ViewGoodsName AS bgigoodsname, ");
		
		if("1".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailprice AS bgiretailprice, ");
		}
		if("2".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricea AS bgiretailprice, ");
		}
		if("3".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceb AS bgiretailprice, ");
		}
		if("4".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricec AS bgiretailprice, ");
		}
		if("5".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriced AS bgiretailprice, ");
		}
		if("6".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricee AS bgiretailprice, ");
		}
		if("7".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricef AS bgiretailprice, ");
		}
		if("8".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceg AS bgiretailprice, ");
		}
		if("9".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpriceh AS bgiretailprice, ");
		}
		if("10".equals(po.getBgiwhichretail())){
			sb.append(" b_gi_retailpricei AS bgiretailprice, ");
		}

		sb.append("                      B_GI_Spec                       AS bgispec, ");
		sb.append("                      B_UT_unitName                   AS bgiunitname, ");
		sb.append("                      B_GI_GoodsBarCode               AS bgigoodsbarcode, ");
		sb.append("                      B_GI_CostPrice                  AS bgicostprice, ");
		sb.append("                      B_GI_NotTaxRate                 AS bginottaxrate, ");
		sb.append("                      B_GI_FrameMaterialType          AS bgiframematerialtype, ");
		sb.append("                      B_GI_FrameSize                  AS bgiframesize, ");
		sb.append("                      B_GI_AccessoriesType            AS bgiaccessoriestype, ");
		sb.append("                      B_GI_Sph                        AS bgisph, ");
		sb.append("                      B_GI_Cyl                        AS bgicyl, ");
		sb.append("                      B_GI_BelowPlusLuminosity        AS bgibelowplusluminosity, ");
		sb.append("                      B_GI_Refractive                 AS bgirefractive, ");
		sb.append("                      B_GI_isMutiLuminosity           AS bgiismutiluminosity, ");
		sb.append("                      B_GI_EyeGlassMaterialType       AS bgieyeglassmaterialtype, ");
		sb.append("                      B_GI_GradualClass               AS bgigradualclass, ");
		sb.append("                      B_GI_SphUL                      AS bgisphul, ");
		sb.append("                      B_GI_SphUP                      AS bgisphup, ");
		sb.append("                      B_GI_CylUL                      AS bgicylul, ");
		sb.append("                      B_GI_CylUP                      AS bgicylup, ");
		sb.append("                      B_GI_Axis                       AS bgiaxis, ");
		sb.append("                      B_GI_BelowPlusLuminosityUL      AS bgibelowplusluminosityul, ");
		sb.append("                      B_GI_BelowPlusLuminosityUP      AS bgibelowplusluminosityup, ");
		sb.append("                      B_GI_FunctionClass              AS bgifunctionclass, ");
		sb.append("                      B_GI_Curvature1                 AS bgicurvature1, ");
		sb.append("                      B_GI_Dia                        AS bgidia, ");
		sb.append("                      B_GI_UseType                    AS bgiusetype, ");
		sb.append("                      B_GI_StealthClass               AS bgistealthclass, ");
		sb.append("                      B_GI_AxisUL                     AS bgiaxisul, ");
		sb.append("                      B_GI_AxisUP                     AS bgiaxisup, ");
		sb.append("                      B_GI_Curvature1UL               AS bgicurvature1ul, ");
		sb.append("                      B_GI_Curvature1UP               AS bgicurvature1up, ");
		sb.append("                      B_GI_Curvature2UL               AS bgicurvature2ul, ");
		sb.append("                      B_GI_Curvature2UP               AS bgicurvature2up, ");
		sb.append("                      B_GI_Capacity                   AS bgicapacity, ");
		sb.append("                      B_GI_CapacityEntry              AS bgicapacityentry, ");
		sb.append("                      B_GI_SupplierColor              AS bgisuppliercolor, ");

		sb.append("cast((dbo.ufn_getWholeSalePriceByDpt(?) * isnull(B_GoodsInfo.B_GI_WholesalePrice,0)) as numeric(18,2)) as bgiwholesaleprice, ");
		params.add(Utility.getName(po.getBgidepartmentid()));
		
		sb.append("                      B_GoodsInfo.B_GI_TaxRate        AS bgitaxrate, ");
		sb.append("                      B_BD_Place                      AS bgisource, ");
		sb.append("                      B_GI_Color                      AS bgicolor, ");
		sb.append("                      B_GI_DiaUL                      AS bgidiaul, ");
		sb.append("                      B_GI_DiaUP                      AS bgidiaup, ");
		sb.append("                      B_FrameMaterial.B_FM_Name       AS bgiframematerialtypename, ");
		sb.append("                      Isnull(B_GI_isCustomize, '')    AS bgiiscustomize ");
		sb.append("               FROM   R_RC_DaySalesEntry  left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("                      LEFT JOIN B_GoodsInfo ");
		sb.append("                        ON B_GI_GoodsID = R_RC_DSE_GoodsID ");
		sb.append("                      LEFT JOIN B_Brand ");
		sb.append("                        ON B_BD_ID = B_GI_BrandID ");
		sb.append("                           AND B_GI_SupplierID = B_BD_SupplierID ");
		sb.append("                      LEFT JOIN B_Supplier ");
		sb.append("                        ON B_GI_SupplierID = B_SP_ID ");
		sb.append("                      LEFT JOIN B_Unit ");
		sb.append("                        ON B_UT_id = B_GI_UnitId ");
		sb.append("                      LEFT JOIN B_FrameMaterial ");
		sb.append("                        ON B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append("               WHERE  R_SD_DSE_SalesType = '2' and B_GI_Flag = '1' ");

		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append(" AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append(" AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(po.getBgiretailendprice());
				}
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=? ");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=? ");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}

		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" AND B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" AND B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" AND B_GI_BrandID = ? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" AND B_GI_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid())) && !"no".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append(" AND B_GI_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		sb.append(" )TEMP ");
		sb.append(" GROUP BY bgigoodscategoryid, ");
		sb.append(" bgisupplierid, ");
		sb.append(" bgisuppliername, ");
		sb.append(" bgibrandid, ");
		sb.append(" bgibrandname, ");
		sb.append(" bgigoodsid, ");
		sb.append(" bgigoodsname, ");
		sb.append(" bgiretailprice, ");
		sb.append(" bgispec, ");
		sb.append(" bgiunitname, ");
		sb.append(" bgigoodsbarcode, ");
		sb.append(" bgicostprice, ");
		sb.append(" bginottaxrate, ");
		sb.append(" bgiframematerialtype, ");
		sb.append(" bgiframesize, ");
		sb.append(" bgiaccessoriestype, ");
		sb.append(" bgisph, ");
		sb.append(" bgicyl, ");
		sb.append(" bgibelowplusluminosity, ");
		sb.append(" bgirefractive, ");
		sb.append(" bgiismutiluminosity, ");
		sb.append(" bgieyeglassmaterialtype, ");
		sb.append(" bgigradualclass, ");
		sb.append(" bgisphul, ");
		sb.append(" bgisphup, ");
		sb.append(" bgicylul, ");
		sb.append(" bgicylup, ");
		sb.append(" bgiaxis, ");
		sb.append(" bgibelowplusluminosityul, ");
		sb.append(" bgibelowplusluminosityup, ");
		sb.append(" bgifunctionclass, ");
		sb.append(" bgicurvature1, ");
		sb.append(" bgidia, ");
		sb.append(" bgiusetype, ");
		sb.append(" bgistealthclass, ");
		sb.append(" bgiaxisul, ");
		sb.append(" bgiaxisup, ");
		sb.append(" bgicurvature1ul, ");
		sb.append(" bgicurvature1up, ");
		sb.append(" bgicurvature2ul, ");
		sb.append(" bgicurvature2up, ");
		sb.append(" bgicapacity, ");
		sb.append(" bgicapacityentry, ");
		sb.append(" bgisuppliercolor, ");
		sb.append(" bgiwholesaleprice, ");
		sb.append(" bgitaxrate, ");
		sb.append(" bgisource, ");
		sb.append(" bgicolor, ");
		sb.append(" bgidiaul, ");
		sb.append(" bgidiaup, ");
		sb.append(" bgiframematerialtypename, ");
		sb.append(" bgiiscustomize) TEMP ");
		sb.append("GROUP BY bgigoodscategoryid, ");
		sb.append("bgisupplierid, ");
		sb.append("bgisuppliername, ");
		sb.append("bgibrandid, ");
		sb.append("bgibrandname, ");
		sb.append("bgigoodsid, ");
		sb.append("bgigoodsname, ");
		sb.append("bgiretailprice, ");
		sb.append("bgispec, ");
		sb.append("bgiunitname, ");
		sb.append("bgigoodsbarcode, ");
		sb.append("bgicostprice, ");
		sb.append("bginottaxrate, ");
		sb.append("bgiframematerialtype, ");
		sb.append("bgiframesize, ");
		sb.append("bgiaccessoriestype, ");
		sb.append("bgisph, ");
		sb.append("bgicyl, ");
		sb.append("bgibelowplusluminosity, ");
		sb.append("bgirefractive, ");
		sb.append("bgiismutiluminosity, ");
		sb.append("bgieyeglassmaterialtype, ");
		sb.append("bgigradualclass, ");
		sb.append("bgisphul, ");
		sb.append("bgisphup, ");
		sb.append("bgicylul, ");
		sb.append("bgicylup, ");
		sb.append("bgiaxis, ");
		sb.append("bgibelowplusluminosityul, ");
		sb.append("bgibelowplusluminosityup, ");
		sb.append("bgifunctionclass, ");
		sb.append("bgicurvature1, ");
		sb.append("bgidia, ");
		sb.append("bgiusetype, ");
		sb.append("bgistealthclass, ");
		sb.append("bgiaxisul, ");
		sb.append("bgiaxisup, ");
		sb.append("bgicurvature1ul, ");
		sb.append("bgicurvature1up, ");
		sb.append("bgicurvature2ul, ");
		sb.append("bgicurvature2up, ");
		sb.append("bgicapacity, ");
		sb.append("bgicapacityentry, ");
		sb.append("bgisuppliercolor, ");
		sb.append("bgiwholesaleprice, ");
		sb.append("bgitaxrate, ");
		sb.append("bgisource, ");
		sb.append("bgicolor, ");
		sb.append("bgidiaul, ");
		sb.append("bgidiaup, ");
		sb.append("bgiframematerialtypename, ");
		sb.append("bgiiscustomize)tempin ");
		sb.append("where tempin.bgigoodsquantity > 0 ");
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		
		sb.append(" set rowcount 0");
		
		sb.append("DROP TABLE #salesDepartments ");
		
		
		return queryForObjectList(sb.toString(), params.toArray(), GoodsInfoPo.class);
		
	}
	
	/**
	 * 获取类别List
	 */	
	public List<GoodsCategoryPo> getGoodsInfoListForSOUTCategory(GoodsInfoPo po){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT departmentID ");
		sb.append("INTO #salesDepartments ");
		sb.append("FROM Sales_createshopcodetab(?) ");
		params.add(po.getShopCode());

		sb.append("SELECT DISTINCT bgigoodscategoryid AS bgcid, ");
		sb.append("       bgigoodscategoryname              AS bgcgoodscategoryname ");
		sb.append("FROM  (SELECT bgigoodscategoryid                AS bgigoodscategoryid, ");
		sb.append("  bgigoodscategoryname              AS bgigoodscategoryname ");
		sb.append("       FROM   (SELECT R_RC_DSE_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append("  B_GC_GoodsCategoryName          AS bgigoodscategoryname ");
		sb.append("               FROM   R_RC_DaySalesEntry left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("  LEFT JOIN B_GoodsCategory ");
		sb.append("    ON B_GC_ID = R_RC_DSE_GoodsCategoryID ");
		sb.append("               WHERE  R_SD_DSE_SalesType = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		sb.append(" UNION ALL ");
		sb.append(" SELECT R_RC_DSE_GoodsCategoryID        AS bgigoodscategoryid, ");
		sb.append(" B_GC_GoodsCategoryName          AS bgigoodscategoryname ");
		sb.append(" FROM   R_RC_DaySalesEntry left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("  LEFT JOIN B_GoodsCategory ");
		sb.append("    ON B_GC_ID = R_RC_DSE_GoodsCategoryID ");
		sb.append(" WHERE  R_SD_DSE_SalesType = '2' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		sb.append("              )TEMP ");
		sb.append("  GROUP  BY bgigoodscategoryid, ");
		sb.append("  bgigoodscategoryname ) TEMP ");

		sb.append("DROP TABLE #salesDepartments ");
		
		return queryForObjectList(sb.toString(), params.toArray(), GoodsCategoryPo.class);
	}
	
	/**
	 * 获取制造商List
	 */	
	public List<SupplierPo> getGoodsInfoListForSOUTSupplier(GoodsInfoPo po){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT departmentID ");
		sb.append("INTO   #salesDepartments ");
		sb.append("FROM   Sales_createshopcodetab(?) ");
		params.add(po.getShopCode());

		sb.append("SELECT DISTINCT bgisupplierid        AS bspid, ");
		sb.append("              bgisuppliername        AS bspsuppliername ");
		sb.append("FROM  (SELECT  ");
		sb.append("  bgisupplierid     AS bgisupplierid, ");
		sb.append("  bgisuppliername   AS bgisuppliername ");
		sb.append("       FROM   (SELECT ");
		sb.append("  R_RC_DSE_SupplierID             AS bgisupplierid, ");
		sb.append("  B_SP_SupplierName           AS bgisuppliername ");
		sb.append("  FROM   R_RC_DaySalesEntry  left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("  INNER JOIN B_Supplier ON B_SP_ID = R_RC_DSE_SupplierID ");
		sb.append("  WHERE  R_SD_DSE_SalesType = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("       AND R_RC_DSE_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		sb.append(" UNION ALL ");
		sb.append(" SELECT  ");
		sb.append(" R_RC_DSE_SupplierID             AS bgisupplierid, ");
		sb.append("  B_SP_SupplierName           AS bgisuppliername ");
		sb.append("  FROM   R_RC_DaySalesEntry left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID  ");
		sb.append("  INNER JOIN B_Supplier ON B_SP_ID = R_RC_DSE_SupplierID ");
		sb.append(" WHERE  R_SD_DSE_SalesType = '2' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("        AND R_RC_DSE_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		sb.append("              )TEMP ");
		sb.append("  GROUP  BY ");
		sb.append("  bgisupplierid, ");
		sb.append("  bgisuppliername ) TEMP ");

		sb.append("DROP TABLE #salesDepartments ");
		
		
		return queryForObjectList(sb.toString(), params.toArray(), SupplierPo.class);
	}
	
	/**
	 * 获取品种List
	 */	
	public List<BrandPo> getGoodsInfoListForSOUTBrand(GoodsInfoPo po){
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT departmentID ");
		sb.append("INTO   #salesDepartments ");
		sb.append("FROM   Sales_createshopcodetab(?) ");
		params.add(po.getShopCode());

		sb.append("SELECT DISTINCT bgibrandid        AS bbdid, ");
		sb.append("              bgibrandname        AS bbdbrandname ");
		sb.append("FROM  (SELECT  ");
		sb.append("  bgibrandid        AS bgibrandid, ");
		sb.append("  bgibrandname      AS bgibrandname ");
		sb.append("       FROM   (SELECT  ");
		sb.append("  R_RC_DSE_BandID                 AS bgibrandid, ");
		sb.append("  B_BD_brandName               	AS bgibrandname ");
		sb.append("  FROM   R_RC_DaySalesEntry left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("  INNER JOIN B_Brand ON B_BD_ID = R_RC_DSE_BandID AND B_BD_SupplierID = ? ");
		params.add(po.getBgisupplierid());
		sb.append("  WHERE  R_SD_DSE_SalesType = '1' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("       AND R_RC_DSE_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append("       AND R_RC_DSE_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		
		sb.append(" UNION ALL ");
		sb.append(" SELECT ");
		sb.append(" R_RC_DSE_BandID                 AS bgibrandid, ");
		sb.append("  B_BD_brandName               	AS bgibrandname ");
		sb.append("  FROM   R_RC_DaySalesEntry left join B_Departments on R_SD_DSE_ShopCode = B_DP_DepartmentID ");
		sb.append("  INNER JOIN B_Brand ON B_BD_ID = R_RC_DSE_BandID AND B_BD_SupplierID = ? ");
		params.add(po.getBgisupplierid());
		sb.append(" WHERE  R_SD_DSE_SalesType = '2' ");
		
		if (!"".equals(Utility.getName(po.getBgicompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getShopCode()))) {
			sb.append(" and ((isnull(?,'')<>'' and R_SD_DSE_ShopCode in (select departmentID from #salesDepartments )) or (isnull(?,'')='')) ");
			params.add(po.getShopCode());
			params.add(po.getShopCode());
		}
		
		if(!"".equals(Utility.getName(po.getBgnDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) >= ? ");
			params.add(po.getBgnDate());
		}
		if(!"".equals(Utility.getName(po.getEndDate()))){
			sb.append("       AND convert(varchar(10),R_SD_DSE_Date,23) <= ? ");
			params.add(po.getEndDate());
		}
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			sb.append("        AND R_RC_DSE_GoodsCategoryID = ? ");
			params.add(po.getBgigoodscategoryid());
		}
		
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append("       AND R_RC_DSE_SupplierID = ? ");
			params.add(po.getBgisupplierid());
		}
		
		sb.append("              )TEMP ");
		sb.append("  GROUP  BY ");
		sb.append("  bgibrandid, ");
		sb.append("  bgibrandname ) TEMP ");

		sb.append("DROP TABLE #salesDepartments ");
		
		
		return queryForObjectList(sb.toString(), params.toArray(), BrandPo.class);
	}

	public int getBrandPriceCount4(BrandPo brandPo) {
		StringBuffer sb=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(bspcategoryid) ");
		sb.append("from(select distinct B_GI_GoodsCategoryID as bspcategoryid, ");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands ");
//		sb.append("substring(B_GI_GoodsID,1,7)+cast(B_GI_RetailPrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}	
		
		sb.append(" GROUP BY substring(B_GI_GoodsID,1,7),B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,B_SP_SupplierName,B_BD_brandName )t ");
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	public List<BrandPo> getBrandPriceList4(BrandPo brandPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");	
		sb.append("select * from (select  ROW_NUMBER() Over(order by temp.bspcategoryid )as rowNum,* from");
		sb.append("(select distinct B_GI_GoodsCategoryID as bspcategoryid,");
		sb.append("B_GI_SupplierID as bbdsupplierid,B_GI_BrandID as bbdid, ");
		sb.append("B_SP_SupplierName as bspsuppliername,B_BD_brandName as bbdbrandname,"); 
		sb.append("substring(B_GI_GoodsID,1,7) as brands ");
//		sb.append(" substring(B_GI_GoodsID,1,7)+cast(B_GI_RetailPrice as varchar) as bbdremark ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_SP_ID=B_GI_SupplierID ");
		sb.append("  inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID where 1=1 ");
		if(!"".equals(Utility.getName(brandPo.getBspcategoryid()))){
			sb.append(" and B_GI_GoodsCategoryID=?");	
			params.add(brandPo.getBspcategoryid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdsupplierid()))){
			sb.append(" and B_GI_SupplierID=?");
			params.add(brandPo.getBbdsupplierid());
		}
		if(!"".equals(Utility.getName(brandPo.getBbdid()))){
			sb.append(" and B_GI_BrandID=? ");
			params.add(brandPo.getBbdid());
		}
		sb.append(" GROUP BY substring(B_GI_GoodsID,1,7),B_GI_GoodsCategoryID,B_GI_SupplierID,B_GI_BrandID,B_SP_SupplierName,B_BD_brandName ) temp )t where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");



		return queryForObjectList(sb.toString(), params.toArray(), BrandPo.class);
	}
	


	public int getGoodsSingleForAllocationCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("left join F_TechnologyType on B_GoodsInfo.B_GI_frameProcessCraftType=F_TechnologyType.F_TT_ID ");//quyanping
		sb.append("left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where B_GoodsInfo.B_GI_Flag='1' ");
		sb.append("and B_GoodsInfo.B_GI_SupplierID<>'ZZ' ");
		List<String> params = new ArrayList<String>();
		
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID <> '4' and B_GoodsInfo.B_GI_GoodsCategoryID <> '5' ");
		}
		
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsName like '%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		
		if (!"".equals(Utility.getName(po.getBgistockquantity()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID in(");
			sb.append("SELECT goodsid ");
			sb.append("FROM  (SELECT C_SH_SB_GoodsId       AS goodsid, ");
			sb.append("              C_SH_SB_StockId       AS stockid, ");
			sb.append("              C_SH_SB_GoodsQuantity AS goodsquantity ");
			sb.append("       FROM   C_SH_StorageBeginning ");
			sb.append("       UNION ALL ");
			sb.append("       SELECT C_SH_SC_GoodsId       AS goodsid, ");
			sb.append("              C_SH_SC_StockId       AS stockid, ");
			sb.append("              C_SH_SC_GoodsQuantity AS goodsquantity ");
			sb.append("       FROM   C_SH_StorageChange)tmp1 ");
			sb.append("GROUP  BY goodsid,stockid HAVING SUM(goodsquantity) = 0 AND stockid = ?)");
			params.add(po.getBgiwarehouseid());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<GoodsInfoPo> getGoodsSingleForAllocationList(GoodsInfoPo po, int start,int size) {
		StringBuffer sb = new StringBuffer();
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("SELECT bgigoodscategoryid AS bgigoodscategoryid, ");
		if(!"".equals(Utility.getName(po.getBgiwhichretail()))){
			sb.append("       bgiretailprice     AS bgiretailprice, ");
		}
		sb.append("       UPPER(bgigoodsbarcode+'00000000')    AS bgigoodsbarcode, ");
		sb.append("       UPPER(dbo.getbarcode(bgirksj,bgigoodsid,bgigoodsbarcode,convert(varchar(10),getdate(),120),?))    AS bgipcbarcode, ");
		sb.append("       UPPER(bgigoodsid)         AS bgigoodsid, ");
		sb.append("       bgigoodsname       AS bgigoodsname, ");
		sb.append("       bgibrandname       AS bgibrandname, ");
		sb.append("       bgicostprice       AS bgicostprice, ");
		sb.append("       bginottaxrate      AS bginottaxrate, ");
		sb.append("       bgispec            AS bgispec, ");
		sb.append("       CASE ");
		sb.append("       WHEN bgigoodscategoryid = '8' THEN isnull(bgicolor,'') + isnull(bgisph,'') ");
		sb.append("       WHEN bgigoodscategoryid <> '8' THEN isnull(bgicolor,'') ");
		sb.append("       END                                         AS bgicolor, ");
		sb.append("       bgiiscustomize           AS bgiiscustomize, ");		
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
		sb.append("       bgicurvature1ul     AS bgicurvature1ul , ");
		sb.append("       bgicurvature1up     AS bgicurvature1up , ");
		sb.append("       bgicurvature2ul     AS bgicurvature2ul , ");
		sb.append("       bgicurvature2up     AS bgicurvature2up , ");
		sb.append("       bgicapacity     AS bgicapacity , ");
		sb.append("       bgicapacityentry     AS bgicapacityentry , ");
		sb.append("       bgiwholesaleprice     AS bgiwholesaleprice , ");
		sb.append("       bgiunitname     AS bgiunitname , ");
		sb.append("       fttid     AS fttid , ");
		sb.append("       bgitaxrate     AS bgitaxrate , ");
		sb.append("       bgisuppliername     AS bgisuppliername , ");
		sb.append("       bgisupplierid     AS bgisupplierid , ");
		sb.append("       bgisource     AS bgisource , ");	
		sb.append("       bgidiaul     AS bgidiaul , ");	
		sb.append("       bgidiaup     AS bgidiaup , ");
		sb.append("       bgiviewgoodsname     AS bgiviewgoodsname , ");
		sb.append("       bgirksj as bgirksj , ");
		sb.append("       bgiframematerialtypename     AS bgiframematerialtypename , ");
		sb.append("       bgisuppliercolor     AS bgisuppliercolor,  ");
		sb.append("       bgiregistrationnum     AS bgiregistrationnum  ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getBillid()));
		if(!"".equals(Utility.getName(po.getBgiwhichretail()))){
			sb.append("       ,?     AS bgiwhichretail  ");
			params.add(po.getBgiwhichretail());
		}
		sb.append("FROM   (SELECT ROW_NUMBER() Over(order by B_GI_GoodsID) as rowNum, ");
		
		sb.append("B_GI_GoodsCategoryID AS bgigoodscategoryid, ");
		
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
		sb.append("  B_GI_GoodsBarCode    AS bgigoodsbarcode, ");
		sb.append("  B_GI_GoodsID         AS bgigoodsid, ");
		sb.append("  B_GI_GoodsName       AS bgigoodsname, ");
		sb.append("  B_BD_brandName       AS bgibrandname, ");
		sb.append("  B_GI_CostPrice       AS bgicostprice, ");
		sb.append("  B_GI_NotTaxRate      AS bginottaxrate, ");
		sb.append("  b_gi_supplierspec     AS bgisupplierspec , ");
		sb.append("  B_GI_Spec            AS bgispec, ");
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
		sb.append("  B_GI_Capacity     AS bgicapacity , ");
		sb.append("  B_GI_CapacityEntry     AS bgicapacityentry , ");
		sb.append("  B_GI_SupplierColor     AS bgisuppliercolor , ");		
		sb.append("  B_GoodsInfo.B_GI_WholesalePrice     AS bgiwholesaleprice , ");
		sb.append("  B_Unit.B_UT_unitName               AS bgiunitname, ");
		sb.append("  F_TechnologyType.F_TT_ID                AS fttid, ");
		sb.append("  B_GoodsInfo.B_GI_TaxRate                AS bgitaxrate, ");
		sb.append("  B_Supplier.B_SP_SupplierName                AS bgisuppliername, ");
		sb.append("  B_GoodsInfo.B_GI_SupplierID                AS bgisupplierid, "); 
		sb.append("  B_BD_Place                AS bgisource, "); 
		sb.append("  B_GI_Color           AS bgicolor, ");
		sb.append("  B_GI_DiaUL           AS bgidiaul, ");
		sb.append("  B_GI_DiaUP           AS bgidiaup, ");
		sb.append("  B_FrameMaterial.B_FM_Name           AS bgiframematerialtypename, ");
		sb.append("  B_GI_ViewGoodsName           AS bgiviewgoodsname, ");
		sb.append("  B_GI_BarCodeFlag           AS bgirksj, ");
		sb.append("  isnull(B_GI_isCustomize,'')           AS bgiiscustomize, ");
		sb.append("  isnull(B_BD_RegistrationNum,'')           AS bgiregistrationnum ");
		sb.append(" from b_goodsinfo inner join B_Brand on B_GI_BrandID=B_BD_ID and B_GI_SupplierID=B_BD_SupplierID inner join B_Supplier on B_GI_SupplierID=B_SP_ID INNER JOIN B_Unit ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id LEFT OUTER JOIN F_TechnologyType ON B_GoodsInfo.B_GI_frameProcessCraftType = F_TechnologyType.F_TT_ID ");
		sb.append(" left join B_FrameMaterial on B_FrameMaterial.B_FM_ID = b_goodsinfo.B_GI_FrameMaterialType ");
		sb.append(" where 1=1 and B_GI_Flag = '1' ");
		sb.append(" and B_GoodsInfo.B_GI_SupplierID<>'ZZ' ");
		if(Utility.getName(po.getIsguaranteeperiod()).equals("1")||Utility.getName(po.getIsguaranteeperiod()).equals("2")){
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID <> '4' and B_GoodsInfo.B_GI_GoodsCategoryID <> '5' ");
		}
		if("1".equals(po.getBgiismendretail())){
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
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
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(po.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(po.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(po.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(po.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(po.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if(!Utility.getName(po.getBgijm()).equals("")){
			sb.append(" and B_GI_WholesalePrice is not null and B_GI_WholeGoodsIsable = 1 ");
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgibrandname()))) {
			sb.append(" and B_Brand.B_BD_brandName like '%' + ? + '%'");
			params.add(po.getBgibrandname());
		}
		
		if (!"".equals(Utility.getName(po.getBgipcbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode like '%' + ? + '%'");
			params.add(po.getBgipcbarcode());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(po.getBgigoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))){
			sb.append(" and F_TechnologyType.F_TT_ID=?");
			params.add(po.getBgitechnologytypeid());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		
		if (("3".equals(Utility.getName(po.getBgigoodscategoryid()))||"4".equals(Utility.getName(po.getBgigoodscategoryid())))&&!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			sb.append(" and B_GoodsInfo.B_GI_isCustomize=?");
			params.add(po.getBgiiscustomize());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesalebeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice>=?");
			params.add(po.getBgiwholesalebeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_WholesalePrice<=?");
			params.add(po.getBgiwholesaleendprice());
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		if (!"".equals(Utility.getName(po.getBgisuppliercolorjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor= ? ");
			params.add(po.getBgisuppliercolorjj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize =?");
			params.add(po.getBgiframesizejj());
		}
		if (!"".equals(Utility.getName(po.getBgiframematerialtypejj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(po.getBgiframematerialtypejj());
		}
		if (!"".equals(Utility.getName(po.getTechnologyTypeIDjj()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(po.getTechnologyTypeIDjj());
		}
		if (!"".equals(Utility.getName(po.getBgiaccessoriestypepj()))) {
			sb.append(" and B_GoodsInfo.B_GI_AccessoriesType<=?");
			params.add(po.getBgiaccessoriestypepj());
		}
		
		if (!"".equals(Utility.getName(po.getMinSphjp()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphjp());
		}
		if (!"".equals(Utility.getName(po.getMaxSphjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphjp());
		}
		if (!"".equals(Utility.getName(po.getMinCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCyljp());
		}
		if (!"".equals(Utility.getName(po.getMaxCyljp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCyljp());
		}
		if (!"".equals(Utility.getName(po.getMinbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity >=cast( ? as float) ");
			params.add(po.getMinbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getMaxbgibelowplusluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_BelowPlusLuminosity <=cast( ? as float) ");
			params.add(po.getMaxbgibelowplusluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtypejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_EyeGlassMaterialType=? ");
			params.add(po.getBgieyeglassmaterialtypejp());
		}
		if (!"".equals(Utility.getName(po.getBgirefractivejp()))) {
			sb.append(" and B_GoodsInfo.B_GI_Refractive=?");
			params.add(po.getBgirefractivejp());
		}
		if (!"".equals(Utility.getName(po.getBgiismutiluminosityjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_isMutiLuminosity=?");
			params.add(po.getBgiismutiluminosityjp());
		}
		if (!"".equals(Utility.getName(po.getBgifunctionclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_FunctionClass=?");
			params.add(po.getBgifunctionclassjp());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclassjp()))) {
			sb.append(" and B_GoodsInfo.B_GI_GradualClass=?");
			params.add(po.getBgigradualclassjp());
		}
		if (!"".equals(Utility.getName(po.getMinSphyx()))) {
			sb.append(" and  B_GoodsInfo.B_GI_Vsph >= cast( ? as float)  ");
			params.add(po.getMinSphyx());
		}
		if (!"".equals(Utility.getName(po.getMaxSphyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vsph <= cast( ? as float) ");
			params.add(po.getMaxSphyx());
		}
		if (!"".equals(Utility.getName(po.getMinCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl >= cast( ? as float)");
			params.add(po.getMinCylyx());
		}
		if (!"".equals(Utility.getName(po.getMaxCylyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Vcyl <= cast( ? as float)");
			params.add(po.getMaxCylyx());
		}
		if (!"".equals(Utility.getName(po.getBgicurvature1yx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Curvature1=?");
			params.add(po.getBgicurvature1yx());
		}
		if (!"".equals(Utility.getName(po.getBgidiayx()))) {
			sb.append(" and B_GoodsInfo.B_GI_Dia=? ");
			params.add(po.getBgidiayx());
		}
		if (!"".equals(Utility.getName(po.getBgiusetypeyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_UseType=?");
			params.add(po.getBgiusetypeyx());
		}
		if (!"".equals(Utility.getName(po.getBgistealthclassyx()))) {
			sb.append(" and B_GoodsInfo.B_GI_StealthClass=?");
			params.add(po.getBgistealthclassyx());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_Capacity=?");
			params.add(po.getBgicapacityyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgicapacityentryyxhly()))) {
			sb.append(" and B_GoodsInfo.B_GI_CapacityEntry=?");
			params.add(po.getBgicapacityentryyxhly());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolortyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolortyj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizetyj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizetyj());
		}
		if (!"".equals(Utility.getName(po.getMinSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph >= cast( ? as float) ");
			params.add(po.getMinSphlhj());
		}
		if (!"".equals(Utility.getName(po.getMaxSphlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_Sph <= cast( ? as float) ");
			params.add(po.getMaxSphlhj());
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolorlhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierColor=?");
			params.add(po.getBgisuppliercolorlhj());
		}
		if (!"".equals(Utility.getName(po.getBgiframesizelhj()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameSize=?");
			params.add(po.getBgiframesizelhj());
		}
		
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			sb.append(" and B_GoodsInfo.B_GI_Spec like '%'+ ? +'%' ");
			params.add(po.getBgispec());
		}
		
		if (!"".equals(Utility.getName(po.getBgistockquantity()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID in(");
			sb.append("SELECT goodsid ");
			sb.append("FROM  (SELECT C_SH_SB_GoodsId       AS goodsid, ");
			sb.append("              C_SH_SB_StockId       AS stockid, ");
			sb.append("              C_SH_SB_GoodsQuantity AS goodsquantity ");
			sb.append("       FROM   C_SH_StorageBeginning ");
			sb.append("       UNION ALL ");
			sb.append("       SELECT C_SH_SC_GoodsId       AS goodsid, ");
			sb.append("              C_SH_SC_StockId       AS stockid, ");
			sb.append("              C_SH_SC_GoodsQuantity AS goodsquantity ");
			sb.append("       FROM   C_SH_StorageChange)tmp1 ");
			sb.append("GROUP  BY goodsid,stockid HAVING SUM(goodsquantity) = 0 AND stockid = ?)");
			params.add(po.getBgiwarehouseid());
		}	
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	public List<AllocationPo> getGoodsSingleAllListss(AllocationPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();
		int countPage = start + size;
		sb.append("SET rowcount 50");
		sb.append(" ");
		sb.append("SELECT TEMP.cshaabillid           AS cshaabillid, ");
		sb.append("       TEMP.cshaaindepartmentname AS cshaaindepartmentname, ");
		sb.append("       TEMP.cshaacreatepersonname AS cshaacreatepersonname, ");
		sb.append("       TEMP.cshaabilldate         AS cshaabilldate, ");
		sb.append("       TEMP.cshaaauditpersonname  AS cshaaauditpersonname, ");
		sb.append("       TEMP.cshaaauditdate        AS cshaaauditdate, ");
		sb.append("       TEMP.chaasuppliername      AS chaasuppliername, ");
		sb.append("       TEMP.goodscategoryname     AS goodscategoryname, ");
		sb.append("       TEMP.cshaaauditstate       AS cshaaauditstate, ");
		sb.append("       TEMP.cshastatusorderid     AS cshastatusorderid, ");
		sb.append("       TEMP.cshaaremark           AS cshaaremark, ");
		sb.append("       TEMP.chaasupplier          AS chaasupplier, ");
		sb.append("       TEMP.goodscategoryid       AS goodscategoryid, ");
		sb.append("       TEMP.cshaaoutdepartmentid  AS cshaaoutdepartmentid ");
		sb.append("FROM   (SELECT Row_number() OVER(ORDER BY cshaabilldate DESC,cshaabillid DESC) AS rowNum,* ");
		sb.append("FROM   (SELECT distinct ");
		sb.append("               C_SHA_Allocation.C_SHA_A_billID                                                                          AS cshaabillid, ");
		sb.append("               d.B_DP_DepartmentName                                                                                    AS cshaaindepartmentname, ");
		sb.append("               C_SHA_A_remark                                                                                           AS cshaaremark, ");
		sb.append("               a.personName                                                                                             AS cshaacreatepersonname, ");
		sb.append("               C_SHA_Allocation.C_SHA_A_billDate                                                                        AS cshaabilldate, ");
		sb.append("               b.personName                                                                                             AS cshaaauditpersonname, ");
		sb.append("               C_SHA_Allocation.C_SHA_A_auditDate                                                                       AS cshaaauditdate, ");
		sb.append("               c.B_SP_SupplierName                                                                                      AS chaasuppliername, ");
		sb.append("               f.B_GC_GoodsCategoryName                                                                                 AS goodscategoryname, ");
		sb.append("               e.C_SHA_StatusOrderID                                                                                    AS cshastatusorderid, ");
		sb.append("               C_SHA_Allocation.C_SHA_A_auditDate                                                                       AS cshaaauditstate, ");
		sb.append("               c.B_SP_ID                                                                                                AS chaasupplier, ");
		sb.append("               f.B_GC_ID                                                                                                AS goodscategoryid, ");
		sb.append("               d.B_DP_DepartmentID                                                                                      AS cshaaoutdepartmentid ");
		sb.append("        FROM   C_SHA_Allocation ");
		sb.append("               INNER JOIN (SELECT B_DP_DepartmentID, ");
		sb.append("                                  B_DP_DepartmentName,B_DP_CompanysID ");
		sb.append("                           FROM   B_Departments)d ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_inDepartmentId = d.B_DP_DepartmentID ");
		sb.append("               LEFT JOIN (SELECT ID, ");
		sb.append("                                 personName ");
		sb.append("                          FROM   SYS_PersonInfo)a ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_createPerson = a.ID ");
		sb.append("               LEFT JOIN (SELECT ID, ");
		sb.append("                                 personName ");
		sb.append("                          FROM   SYS_PersonInfo)b ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_auditPerson = b.ID ");
		sb.append("               LEFT JOIN (SELECT B_SP_ID, ");
		sb.append("                                 B_SP_SupplierName ");
		sb.append("                          FROM   B_Supplier)c ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_supplier = c.B_SP_ID ");
		sb.append("               LEFT JOIN (SELECT B_GC_ID, ");
		sb.append("                                 B_GC_GoodsCategoryName ");
		sb.append("                          FROM   B_GoodsCategory)f ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_CategoryID = f.B_GC_ID ");
		sb.append("               LEFT JOIN (SELECT * ");
		sb.append("                          FROM   C_SHA_Status)e ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_billID = e.C_SHA_StatusBillID ");		
		sb.append("    inner join C_SHA_AllocationEntry on C_SHA_A_billID = C_SHA_AE_billId ");
		
		sb.append("        WHERE  1 = 1 ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and d.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCshaaflag()))){
			sb.append(" and C_SHA_A_flag = ? ");
			params.add(Utility.getName(po.getCshaaflag()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("AND C_SHA_Allocation.C_SHA_A_inDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaindepartmentid()));
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("AND C_SHA_Allocation.C_SHA_A_outDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaoutdepartmentid()));
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_CategoryID like '%'+?+'%' ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SHA_AE_goodsId,3,2) like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditState = ?");
			params.add(po.getCshaaauditstate());
		}
		sb.append(" ) TEMP ) TEMP  where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), params.toArray(), AllocationPo.class);
	}
	public int getGoodsSingleAllCountss(AllocationPo po) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(distinct C_SHA_Allocation.C_SHA_A_billID )  ");
		
		sb.append("        FROM   C_SHA_Allocation ");
		sb.append("               INNER JOIN (SELECT B_DP_DepartmentID, ");
		sb.append("                                  B_DP_DepartmentName,B_DP_CompanysID ");
		sb.append("                           FROM   B_Departments)d ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_inDepartmentId= d.B_DP_DepartmentID ");
		sb.append("               LEFT JOIN (SELECT ID, ");
		sb.append("                                 personName ");
		sb.append("                          FROM   SYS_PersonInfo)a ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_createPerson = a.ID ");
		sb.append("               LEFT JOIN (SELECT ID, ");
		sb.append("                                 personName ");
		sb.append("                          FROM   SYS_PersonInfo)b ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_auditPerson = b.ID ");
		sb.append("               LEFT JOIN (SELECT B_SP_ID, ");
		sb.append("                                 B_SP_SupplierName ");
		sb.append("                          FROM   B_Supplier)c ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_supplier = c.B_SP_ID ");
		sb.append("               LEFT JOIN (SELECT B_GC_ID, ");
		sb.append("                                 B_GC_GoodsCategoryName ");
		sb.append("                          FROM   B_GoodsCategory)f ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_CategoryID = f.B_GC_ID ");
		sb.append("               LEFT JOIN (SELECT * ");
		sb.append("                          FROM   C_SHA_Status)e ");
		sb.append("                 ON C_SHA_Allocation.C_SHA_A_billID = e.C_SHA_StatusBillID ");
		sb.append("    inner join C_SHA_AllocationEntry on C_SHA_A_billID = C_SHA_AE_billId ");
		
		sb.append("where 1 = 1 ");
		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    sb.append(" and d.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCshaaflag()))){
			sb.append(" and C_SHA_A_flag = ? ");
			params.add(Utility.getName(po.getCshaaflag()));
		}
		
		if(!"".equals(Utility.getName(po.getCshaaindepartmentid()))){
			sb.append("AND C_SHA_Allocation.C_SHA_A_inDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaindepartmentid()));
		}
		if(!"".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}else if(!"".equals(Utility.getName(po.getCshaastartTime())) && "".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) >= ? ");
			params.add(po.getCshaastartTime());
			
		}else if("".equals(Utility.getName(po.getCshaastartTime())) && !"".equals(Utility.getName(po.getCshaaendTime()))){
			sb.append("and convert(varchar(10), C_SHA_Allocation.C_SHA_A_billDate, 23) <= ? ");
			params.add(po.getCshaaendTime());
		}
		if(!"".equals(Utility.getName(po.getCshaaauditstate()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_auditState = ?");
			params.add(po.getCshaaauditstate());
		}
		if(!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))){
			sb.append("AND C_SHA_Allocation.C_SHA_A_outDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaoutdepartmentid()));
		}
		if(!"".equals(Utility.getName(po.getGoodscategoryid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_CategoryID like '%'+?+'%' ");
			params.add(po.getGoodscategoryid());
		}
		if(!"".equals(Utility.getName(po.getCshaabillid()))){
			sb.append("and C_SHA_Allocation.C_SHA_A_billID like '%'+?+'%' ");
			params.add(po.getCshaabillid());
		}
		if(!"".equals(Utility.getName(po.getChaasupplier()))){
			sb.append("and substring(C_SHA_AE_goodsId,3,2) like '%'+?+'%' ");
			params.add(po.getChaasupplier());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}
}
