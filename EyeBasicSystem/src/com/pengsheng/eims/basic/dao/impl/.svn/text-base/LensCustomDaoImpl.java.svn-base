package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.LensCustomDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 订做镜片类dao 实现类
 */
public class LensCustomDaoImpl extends BaseJdbcDaoSupport implements
		LensCustomDao {
	/**
	 * 删除订做镜片
	 * 
	 * @param po
	 */
	public void deleteLensCustom(GoodsInfoPo po) {
		// TODO Auto-generated method stub
		String sql = "delete from B_GoodsInfo where B_GI_GoodsID = ? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 订做镜片数量
	 * 
	 * @param goodsInfoPo
	 * @return
	 */
	public int getLensCustomCount(GoodsInfoPo goodsInfoPo) {
		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on ");
		sb.append("B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on ");
		sb.append("B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
		sb.append("AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("inner join B_Unit on ");
		sb.append("B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append("where 1=1 ");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibarcodeflag()))) {
			sb.append(" and B_GI_BarCodeFlag=?");
			params.add(goodsInfoPo.getBgibarcodeflag());
		}
		
		if("1".equals(goodsInfoPo.getBgiismendretail())){
			if("1".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("2".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("3".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("4".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("5".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("6".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("7".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("8".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("9".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("10".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}

		if (!"".equals(Utility.getName(goodsInfoPo.getBgiiscustomize()))) {
			sb.append(" and B_GI_isCustomize=?");
			params.add(goodsInfoPo.getBgiiscustomize());
		}

		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(goodsInfoPo.getBgigoodscategoryid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(goodsInfoPo.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(goodsInfoPo.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodsbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode=?");
			params.add(goodsInfoPo.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(goodsInfoPo.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?" );
			params.add(goodsInfoPo.getBgicostendprice());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiflag()))) {
			sb.append(" and B_GoodsInfo.B_GI_Flag=?");
			params.add(goodsInfoPo.getBgiflag());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiismutiluminosity()))) {
			sb.append(" and B_GI_isMutiLuminosity = ? ");
			params.add(goodsInfoPo.getBgiismutiluminosity());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgieyeglassmaterialtype()))) {
			sb.append(" and B_GI_EyeGlassMaterialType = ? ");
			params.add(goodsInfoPo.getBgieyeglassmaterialtype());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgirefractive()))) {
			sb.append(" and B_GI_Refractive = ? ");
			params.add(goodsInfoPo.getBgirefractive());
		}
		
		// if (!"".equals(Utility.getName(goodsInfoPo.getBgivarietyid()))) {
		// sb.append(" and B_GoodsInfo.B_GI_VarietyID=?");
		// params.add(goodsInfoPo.getBgivarietyid());
		// }

		if("2".equals(Utility.getName(goodsInfoPo.getBgiissetflag()))){
        	sb.append(" and isnull(B_GI_PayFeeID,'') = '' ");
        }
        
        if("3".equals(Utility.getName(goodsInfoPo.getBgiissetflag()))){
        	if (!"".equals(Utility.getName(goodsInfoPo.getBgipayfeeid()))) {
        		sb.append(" and isnull(B_GI_PayFeeID,'') = ? ");
        		params.add(Utility.getName(goodsInfoPo.getBgipayfeeid()));
        	}else{
        		sb.append(" and isnull(B_GI_PayFeeID,'') <> '' ");
        	}
        } 
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 订做镜片
	 * 
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getLensCustomList(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		StringBuffer sb = new StringBuffer();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * ");
		sb.append(" from(select ROW_NUMBER() ");
		sb.append("Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,B_GI_WholeGoodsIsable as bgiwholegoodsisable,");
		sb.append(" B_GI_GoodsID as BGIGoodsID ");
		sb.append(",B_GI_GoodsBarCode  as BGIGoodsBarCode   ");
		sb.append(",B_GI_ViewGoodsName  as BGIGoodsName   ");
		sb.append(",B_GI_GoodsCategoryID  as BGIGoodsCategoryID   ");
		sb.append(",B_GI_SupplierID as BGISupplierID  ");
		sb.append(",B_GI_BrandID as BGIBrandID  ");
		sb.append(",B_GI_UnitId  as BGIUnitId   ");
		if("1".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailprice     AS bgiretailprice ");
		}
		if("2".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpricea     AS bgiretailprice ");
		}
		if("3".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpriceb     AS bgiretailprice ");
		}
		if("4".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpricec     AS bgiretailprice ");
		}
		if("5".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpriced     AS bgiretailprice ");
		}
		if("6".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpricee     AS bgiretailprice ");
		}
		if("7".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpricef     AS bgiretailprice ");
		}
		if("8".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpriceg     AS bgiretailprice ");
		}
		if("9".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpriceh     AS bgiretailprice ");
		}
		if("10".equals(goodsInfoPo.getBgiwhichretail())){
			sb.append(",b_gi_retailpricei     AS bgiretailprice ");
		}
		sb.append(",B_GI_CostPrice  as BGICostPrice   ");
		sb.append(",B_GI_NotTaxRate as BGINotTaxRate  ");
		sb.append(",B_GI_TaxRate as BGITaxRate  ");
		sb.append(",B_GI_Spec as BGISpec  ");
		sb.append(",B_GI_Color as BGIColor ");
		sb.append(",B_GI_isCustomize as BGIisCustomize ");
		sb.append(",B_GI_Sph  as BGISph   ");
		sb.append(",B_GI_SphUL as BGISphUL ");
		sb.append(",B_GI_SphUP as BGISphUP ");
		sb.append(",B_GI_Cyl  as BGICyl   ");
		sb.append(",B_GI_CylUL as BGICylUL ");
		sb.append(",B_GI_CylUP as BGICylUP ");
		sb.append(",B_GI_BelowPlusLuminosity as BGIBelowPlusLuminosity ");
		sb.append(",B_GI_BelowPlusLuminosityUL as BGIBelowPlusLuminosityUL ");
		sb.append(",B_GI_BelowPlusLuminosityUP as BGIBelowPlusLuminosityUP ");
		sb.append(",B_GI_Axis as BGIAxis  ");
		sb.append(",B_GI_AxisUL  as BGIAxisUL   ");
		sb.append(",B_GI_AxisUP  as BGIAxisUP   ");
		sb.append(",B_GI_Curvature1 as BGICurvature1  ");
		sb.append(",B_GI_Curvature1UL  as BGICurvature1UL   ");
		sb.append(",B_GI_Curvature1UP  as BGICurvature1UP   ");
		sb.append(",B_GI_Curvature2 as BGICurvature2  ");
		sb.append(",B_GI_Curvature2UL  as BGICurvature2UL   ");
		sb.append(",B_GI_Curvature2UP  as BGICurvature2UP   ");
		sb.append(",B_GI_Dia  as BGIDia   ");
		sb.append(",B_GI_DiaUL as BGIDiaUL ");
		sb.append(",B_GI_DiaUP as BGIDiaUP ");
		sb.append(",B_GI_isMutiLuminosity as BGIisMutiLuminosity  ");
		sb.append(",B_GI_MutiLuminosityNum as BGIMutiLuminosityNum ");
		sb.append(",B_GI_MutiLuminosityAddPrice as BGIMutiLuminosityAddPrice ");
		sb.append(",B_GI_EyeGlassMaterialType as BGIEyeGlassMaterialType ");
		sb.append(",B_GI_isPlating  as BGIisPlating   ");
		sb.append(",B_GI_orderCycle as BGIorderCycle  ");
		sb.append(",B_GI_FinishedGlassesType as BGIFinishedGlassesType  ");
		sb.append(",B_GI_frameProcessCraftType  as BGIframeProcessCraftType ");
		sb.append(",B_GI_CylMin  as BGICylMin   ");
		sb.append(",B_GI_CylDegreeIncrease  as BGICylDegreeIncrease   ");
		sb.append(",B_GI_CylMinAddPrice as BGICylMinAddPrice ");
		sb.append(",B_GI_CylAddPrice as BGICylAddPrice ");
		sb.append(",B_GI_PrismAddPrice as BGIPrismAddPrice  ");
		sb.append(",B_GI_cyl25CanNotDo as BGIcyl25CanNotDo  ");
		sb.append(",B_GI_ThrowingCycle as BGIThrowingCycle  ");
		sb.append(",B_GI_StealthType as BGIStealthType ");
		sb.append(",B_GI_OtherGoodsBigClass  as BGIOtherGoodsBigClass   ");
		sb.append(",B_GI_OtherGoodsSmallClass as BGIOtherGoodsSmallClass ");
		sb.append(",B_GI_Flag as BGIFlag  ");
		sb.append(",B_SP_SupplierName as bgisuppliername  ");
		sb.append(",B_BD_brandName as bgibrandname  ");
		sb.append(",B_UT_unitName as bgiunitname ");
		sb.append(" from B_GoodsInfo ");
		sb.append("inner join B_Supplier on ");
		sb.append("B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on ");
		sb.append("B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
		sb.append("AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("inner join B_Unit on ");
		sb.append("B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1 ");

		List<String> params = new ArrayList<String>();
		
		if("1".equals(goodsInfoPo.getBgiismendretail())){
			if("1".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPrice<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("2".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricea<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("3".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceb<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("4".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricec<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("5".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriced<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("6".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricee<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("7".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricef<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("8".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceg<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("9".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPriceh<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
			if("10".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is not null ");
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailbeginprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei>=?");
					params.add(goodsInfoPo.getBgiretailbeginprice());
				}
				if (!"".equals(Utility.getName(goodsInfoPo.getBgiretailendprice()))) {
					sb.append(" and B_GoodsInfo.B_GI_RetailPricei<=?");
					params.add(goodsInfoPo.getBgiretailendprice());
				}
			}
		}else{
			if("1".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPrice is null ");
			}
			if("2".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricea is null ");
			}
			if("3".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceb is null ");
			}
			if("4".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricec is null ");
			}
			if("5".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriced is null ");
			}
			if("6".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricee is null ");
			}
			if("7".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricef is null ");
			}
			if("8".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceg is null ");
			}
			if("9".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPriceh is null ");
			}
			if("10".equals(goodsInfoPo.getBgiwhichretail())){
				sb.append(" and B_GoodsInfo.B_GI_RetailPricei is null ");
			}
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiiscustomize()))) {
			sb.append(" and B_GI_isCustomize=?");
			params.add(goodsInfoPo.getBgiiscustomize());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodscategoryid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=?");
			params.add(goodsInfoPo.getBgigoodscategoryid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(goodsInfoPo.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(goodsInfoPo.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgigoodsbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode=?");
			params.add(goodsInfoPo.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(goodsInfoPo.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(goodsInfoPo.getBgibrandid());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(goodsInfoPo.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(goodsInfoPo.getBgicostendprice());
		}
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiflag()))) {
			sb.append(" and B_GoodsInfo.B_GI_Flag=?");
			params.add(goodsInfoPo.getBgiflag());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgiismutiluminosity()))) {
			sb.append(" and B_GI_isMutiLuminosity = ? ");
			params.add(goodsInfoPo.getBgiismutiluminosity());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgieyeglassmaterialtype()))) {
			sb.append(" and B_GI_EyeGlassMaterialType = ? ");
			params.add(goodsInfoPo.getBgieyeglassmaterialtype());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgirefractive()))) {
			sb.append(" and B_GI_Refractive = ? ");
			params.add(goodsInfoPo.getBgirefractive());
		}
		
		if (!"".equals(Utility.getName(goodsInfoPo.getBgibarcodeflag()))) {
			sb.append(" and B_GI_BarCodeFlag = ? ");
			params.add(goodsInfoPo.getBgibarcodeflag());
		}
		
		if("2".equals(Utility.getName(goodsInfoPo.getBgiissetflag()))){
        	sb.append(" and isnull(B_GI_PayFeeID,'') = '' ");
        }
        
        if("3".equals(Utility.getName(goodsInfoPo.getBgiissetflag()))){
        	if (!"".equals(Utility.getName(goodsInfoPo.getBgipayfeeid()))) {
        		sb.append(" and isnull(B_GI_PayFeeID,'') = ? ");
        		params.add(Utility.getName(goodsInfoPo.getBgipayfeeid()));
        	}else{
        		sb.append(" and isnull(B_GI_PayFeeID,'') <> '' ");
        	}
        } 
		
		sb.append(" ) temp where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 取订做镜片PO
	 * 
	 * @param po
	 * @return
	 */
	public GoodsInfoPo getLensCustom(GoodsInfoPo po) {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT top 1  B_GI_GoodsID 		as BGIGoodsID ");
		sb.append(",B_GI_GoodsBarCode  				as BGIGoodsBarCode   ");
		sb.append(",B_GI_GoodsName  				as BGIGoodsName   ");
		sb.append(",B_GI_GoodsCategoryID  			as BGIGoodsCategoryID   ");
		sb.append(",B_GI_SupplierID 				as BGISupplierID  ");
		sb.append(",B_GI_BrandID 					as BGIBrandID  ");
		sb.append(",B_GI_UnitId  					as BGIUnitId,   ");
		sb.append("isnull(B_GI_RetailPriceA,0.00)   as  bgiretailpricea,");
		sb.append("isnull(B_GI_RetailPriceB,0.00)   as  bgiretailpriceb,");
		sb.append("isnull(B_GI_RetailPriceC,0.00)   as  bgiretailpricec,");
		sb.append("isnull(B_GI_RetailPriceD ,0.00)  as  bgiretailpriced,");
		sb.append("isnull(B_GI_RetailPriceE,0.00)   as  bgiretailpricee,");
		sb.append("isnull(B_GI_RetailPriceF,0.00)   as  bgiretailpricef,");
		sb.append("isnull(B_GI_RetailPriceG,0.00)   as  bgiretailpriceg,");
		sb.append("isnull(B_GI_RetailPriceH,0.00)   as  bgiretailpriceh,");
		sb.append("isnull(B_GI_RetailPriceI,0.00)   as  bgiretailpricei ");
		sb.append(",B_GI_RetailPrice 				as BGIRetailPrice ");
		sb.append(",B_GI_CostPrice  				as BGICostPrice   ");
		sb.append(",B_GI_NotTaxRate 				as BGINotTaxRate  ");
		sb.append(",B_GI_TaxRate 					as BGITaxRate  ");
		sb.append(",B_GI_Spec 						as BGISpec  ");
		sb.append(",B_GI_Color 						as BGIColor ");
		sb.append(",B_GI_isCustomize 				as BGIisCustomize ");
		sb.append(",B_GI_Sph  						as BGISph   ");
		sb.append(",B_GI_SphUL 						as BGISphUL ");
		sb.append(",B_GI_SphUP 						as BGISphUP ");
		sb.append(",B_GI_SphSpan 					as bgisphspan ");
		sb.append(",B_GI_Cyl  						as BGICyl   ");
		sb.append(",B_GI_CylUL 						as BGICylUL ");
		sb.append(",B_GI_CylUP 						as BGICylUP ");
		sb.append(",B_GI_CylSpan 					as bgicylspan ");
		sb.append(",B_GI_BelowPlusLuminosity 		as BGIBelowPlusLuminosity ");
		sb.append(",B_GI_BelowPlusLuminosityUL  	as BGIBelowPlusLuminosityUL ");
		sb.append(",B_GI_BelowPlusLuminosityUP  	as BGIBelowPlusLuminosityUP ");
		sb.append(",B_GI_Axis 						as BGIAxis  ");
		sb.append(",B_GI_AxisUL  					as BGIAxisUL   ");
		sb.append(",B_GI_AxisUP  					as BGIAxisUP   ");
		sb.append(",B_GI_Curvature1 				as BGICurvature1  ");
		sb.append(",B_GI_Curvature1UL  				as BGICurvature1UL   ");
		sb.append(",B_GI_Curvature1UP  				as BGICurvature1UP   ");
		sb.append(",B_GI_Curvature2 				as BGICurvature2  ");
		sb.append(",B_GI_Curvature2UL  				as BGICurvature2UL   ");
		sb.append(",B_GI_Curvature2UP  				as BGICurvature2UP   ");
		sb.append(",B_GI_Dia  						as BGIDia   ");
		sb.append(",B_GI_DiaUL 						as BGIDiaUL ");
		sb.append(",B_GI_DiaUP 						as BGIDiaUP ");
		sb.append(",B_GI_isMutiLuminosity 			as BGIisMutiLuminosity  ");
		sb.append(",B_GI_MutiLuminosityNum 			as BGIMutiLuminosityNum ");
		sb.append(",B_GI_MutiLuminosityAddPrice 	as BGIMutiLuminosityAddPrice ");
		sb.append(",B_GI_EyeGlassMaterialType 		as BGIEyeGlassMaterialType ");
		sb.append(",B_GI_isPlating  				as BGIisPlating   ");
		sb.append(",B_GI_orderCycle 				as BGIorderCycle  ");
		sb.append(",B_GI_UnionSphCyl 				as bgiunionsphcyl  ");		
		sb.append(",B_GI_FinishedGlassesType 		as BGIFinishedGlassesType  ");
		sb.append(",B_GI_frameProcessCraftType  	as BGIframeProcessCraftType ");
		sb.append(",B_GI_CylMin  					as BGICylMin   ");
		sb.append(",B_GI_CylDegreeIncrease  		as BGICylDegreeIncrease   ");
		sb.append(",B_GI_CylMinAddPrice 			as BGICylMinAddPrice ");
		sb.append(",B_GI_CylAddPrice 				as BGICylAddPrice ");
		sb.append(",B_GI_PrismAddPrice 				as BGIPrismAddPrice  ");
		sb.append(",B_GI_cyl25CanNotDo 				as BGIcyl25CanNotDo  ");
		sb.append(",B_GI_ThrowingCycle 				as BGIThrowingCycle  ");
		sb.append(",B_GI_StealthType 				as BGIStealthType ");
		sb.append(",B_GI_OtherGoodsBigClass  		as BGIOtherGoodsBigClass   ");
		sb.append(",B_GI_OtherGoodsSmallClass 		as BGIOtherGoodsSmallClass ");
		sb.append(",B_GI_Flag 						as BGIFlag  ");
		sb.append(",B_SP_SupplierName 				as bgisuppliername  ");
		sb.append(",B_BD_brandName 					as bgibrandname ,B_GI_Refractive as bgirefractive ");
		sb.append(",B_GI_DefaultDiscountValue 		as bgidefaultdiscountvalue  ");
		sb.append(",B_GL_Name					  	as bgidefaultdiscountvaluename ");
		sb.append(",B_GI_PayFeeID					as bgipayfeeid ");
		sb.append(",B_UT_unitName as bgiunitname,B_GI_AverageNotTaxRate as bgiaveragenotnaxrate,B_GI_WholesalePrice as bgiwholesaleprice,B_GI_GradualClass as bgigradualclass,B_GI_FunctionClass as bgifunctionclass   ");
		sb.append("  FROM B_GoodsInfo ");
		sb.append("inner join B_Supplier on ");
		sb.append("B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on ");
		sb.append("B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID ");
		sb.append("AND B_BD_SupplierID = B_GI_SupplierID ");
		sb.append("inner join B_Unit on ");
		sb.append("B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		sb.append(" where B_GoodsInfo.B_GI_GoodsID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());

		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 新增订做镜片
	 * 
	 * @param po
	 */
	public void insertLensCustom(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO B_GoodsInfo ");

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append("(B_GI_GoodsID ");
			params.add(po.getBgigoodsid());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			buffer.append(",B_GI_GoodsBarCode ");
			params.add(po.getBgigoodsbarcode());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append(",B_GI_GoodsName ");
			params.add(po.getBgigoodsname());
		}

		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append(",B_GI_GoodsCategoryID ");
			params.add(po.getBgigoodscategoryid());
		}

		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append(",B_GI_SupplierID ");
			params.add(po.getBgisupplierid());
		}

		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append(",B_GI_BrandID ");
			params.add(po.getBgibrandid());
		}

		if (!"".equals(Utility.getName(po.getBgiunitid()))) {
			buffer.append(",B_GI_UnitId ");
			params.add(po.getBgiunitid());
		}

		if (!"".equals(Utility.getName(po.getBgiretailprice()))) {
			buffer.append(",B_GI_RetailPrice ");
			params.add(po.getBgiretailprice());
		}

		if (!"".equals(Utility.getName(po.getBgicostprice()))) {
			buffer.append(",B_GI_CostPrice ");
			params.add(po.getBgicostprice());
		}

		if (!"".equals(Utility.getName(po.getBginottaxrate()))) {
			buffer.append(",B_GI_NotTaxRate ");
			params.add(po.getBginottaxrate());
		}

		if (!"".equals(Utility.getName(po.getBgitaxrate()))) {
			buffer.append(",B_GI_TaxRate ");
			params.add(po.getBgitaxrate());
		}

		if (!"".equals(Utility.getName(po.getBgispec()))) {
			buffer.append(",B_GI_Spec ");
			params.add(po.getBgispec());
		}

		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			buffer.append(",B_GI_Color ");
			params.add(po.getBgicolor());
		}

		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			buffer.append(",B_GI_isCustomize ");
			params.add(po.getBgiiscustomize());
		}

		if (!"".equals(Utility.getName(po.getBgisph()))) {
			buffer.append(",B_GI_Sph ");
			params.add(po.getBgisph());
		}

		if (!"".equals(Utility.getName(po.getBgisphul()))) {
			buffer.append(",B_GI_SphUL ");
			params.add(po.getBgisphul());
		}

		if (!"".equals(Utility.getName(po.getBgisphup()))) {
			buffer.append(",B_GI_SphUP ");
			params.add(po.getBgisphup());
		}
		
		if (!"".equals(Utility.getName(po.getBgisphspan()))) {
			buffer.append(",B_GI_SphSpan ");
			params.add(po.getBgisphspan());
		}

		if (!"".equals(Utility.getName(po.getBgicyl()))) {
			buffer.append(",B_GI_Cyl ");
			params.add(po.getBgicyl());
		}

		if (!"".equals(Utility.getName(po.getBgicylul()))) {
			buffer.append(",B_GI_CylUL ");
			params.add(po.getBgicylul());
		}

		if (!"".equals(Utility.getName(po.getBgicylup()))) {
			buffer.append(",B_GI_CylUP ");
			params.add(po.getBgicylup());
		}
		
		if (!"".equals(Utility.getName(po.getBgicylspan()))) {
			buffer.append(",B_GI_CylSpan ");
			params.add(po.getBgicylspan());
		}

		if (!"".equals(Utility.getName(po.getBgibelowplusluminosity()))) {
			buffer.append(",B_GI_BelowPlusLuminosity ");
			params.add(po.getBgibelowplusluminosity());
		}

		if (!"".equals(Utility.getName(po.getBgibelowplusluminosityul()))) {
			buffer.append(",B_GI_BelowPlusLuminosityUL ");
			params.add(po.getBgibelowplusluminosityul());
		}

		if (!"".equals(Utility.getName(po.getBgibelowplusluminosityup()))) {
			buffer.append(",B_GI_BelowPlusLuminosityUP ");
			params.add(po.getBgibelowplusluminosityup());
		}

		if (!"".equals(Utility.getName(po.getBgiaxis()))) {
			buffer.append(",B_GI_Axis ");
			params.add(po.getBgiaxis());
		}

		if (!"".equals(Utility.getName(po.getBgiaxisul()))) {
			buffer.append(",B_GI_AxisUL ");
			params.add(po.getBgiaxisul());
		}

		if (!"".equals(Utility.getName(po.getBgiaxisup()))) {
			buffer.append(",B_GI_AxisUP ");
			params.add(po.getBgiaxisup());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature1()))) {
			buffer.append(",B_GI_Curvature1 ");
			params.add(po.getBgicurvature1());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature1ul()))) {
			buffer.append(",B_GI_Curvature1UL ");
			params.add(po.getBgicurvature1ul());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature1up()))) {
			buffer.append(",B_GI_Curvature1UP ");
			params.add(po.getBgicurvature1up());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature2()))) {
			buffer.append(",B_GI_Curvature2 ");
			params.add(po.getBgicurvature2());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature2ul()))) {
			buffer.append(",B_GI_Curvature2UL ");
			params.add(po.getBgicurvature2ul());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature2up()))) {
			buffer.append(",B_GI_Curvature2UP ");
			params.add(po.getBgicurvature2up());
		}

		if (!"".equals(Utility.getName(po.getBgidia()))) {
			buffer.append(",B_GI_Dia ");
			params.add(po.getBgidia());
		}

		if (!"".equals(Utility.getName(po.getBgidiaul()))) {
			buffer.append(",B_GI_DiaUL ");
			params.add(po.getBgidiaul());
		}

		if (!"".equals(Utility.getName(po.getBgidiaup()))) {
			buffer.append(",B_GI_DiaUP ");
			params.add(po.getBgidiaup());
		}

		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			buffer.append(",B_GI_isMutiLuminosity ");
			params.add(po.getBgiismutiluminosity());
		}

		if (!"".equals(Utility.getName(po.getBgimutiluminositynum()))) {
			buffer.append(",B_GI_MutiLuminosityNum ");
			params.add(po.getBgimutiluminositynum());
		}
		
		if (!"".equals(Utility.getName(po.getBgimutiluminosityaddprice()))) {
			buffer.append(",B_GI_MutiLuminosityAddPrice ");
			params.add(po.getBgimutiluminosityaddprice());
		}

		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			buffer.append(",B_GI_EyeGlassMaterialType ");
			params.add(po.getBgieyeglassmaterialtype());
		}

		if (!"".equals(Utility.getName(po.getBgiisplating()))) {
			buffer.append(",B_GI_isPlating ");
			params.add(po.getBgiisplating());
		}

		if (!"".equals(Utility.getName(po.getBgiunionsphcyl()))) {//联合光度
			buffer.append(",B_GI_UnionSphCyl ");
			params.add(po.getBgiunionsphcyl());
		}
		
		if (!"".equals(Utility.getName(po.getBgiordercycle()))) {
			buffer.append(",B_GI_orderCycle ");
			params.add(po.getBgiordercycle());
		}

		if (!"".equals(Utility.getName(po.getBgifinishedglassestype()))) {
			buffer.append(",B_GI_FinishedGlassesType ");
			params.add(po.getBgifinishedglassestype());
		}

		if (!"".equals(Utility.getName(po.getBgiframeprocesscrafttype()))) {
			buffer.append(",B_GI_frameProcessCraftType ");
			params.add(po.getBgiframeprocesscrafttype());
		}

		if (!"".equals(Utility.getName(po.getBgicylmin()))) {
			buffer.append(",B_GI_CylMin ");
			params.add(po.getBgicylmin());
		}

		if (!"".equals(Utility.getName(po.getBgicyldegreeincrease()))) {
			buffer.append(",B_GI_CylDegreeIncrease ");
			params.add(po.getBgicyldegreeincrease());
		}

		if (!"".equals(Utility.getName(po.getBgicylminaddprice()))) {
			buffer.append(",B_GI_CylMinAddPrice ");
			params.add(po.getBgicylminaddprice());
		}

		if (!"".equals(Utility.getName(po.getBgicyladdprice()))) {
			buffer.append(",B_GI_CylAddPrice ");
			params.add(po.getBgicyladdprice());
		}

		if (!"".equals(Utility.getName(po.getBgiprismaddprice()))) {
			buffer.append(",B_GI_PrismAddPrice ");
			params.add(po.getBgiprismaddprice());
		}

		if (!"".equals(Utility.getName(po.getBgicyl25cannotdo()))) {
			buffer.append(",B_GI_cyl25CanNotDo ");
			params.add(Utility.getName(po.getBgicyl25cannotdo()));
		}

		if (!"".equals(Utility.getName(po.getBgithrowingcycle()))) {
			buffer.append(",B_GI_ThrowingCycle ");
			params.add(po.getBgithrowingcycle());
		}

		if (!"".equals(Utility.getName(po.getBgistealthtype()))) {
			buffer.append(",B_GI_StealthType ");
			params.add(po.getBgistealthtype());
		}

		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			buffer.append(",B_GI_OtherGoodsBigClass ");
			params.add(po.getBgiothergoodsbigclass());
		}

		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			buffer.append(",B_GI_OtherGoodsSmallClass ");
			params.add(po.getBgiothergoodssmallclass());
		}

		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			buffer.append(",B_GI_Flag ");
			params.add(po.getBgiflag());
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			buffer.append(" , B_GI_Refractive  ");
			params.add(po.getBgirefractive());
		}
		if (!"".equals(Utility.getName(po.getBgiwholesaleprice()))) {
			buffer.append(",B_GI_WholesalePrice ");
			params.add(po.getBgiwholesaleprice());
		}
		if (!"".equals(Utility.getName(po.getBgigradualclass()))) {
			buffer.append(",B_GI_GradualClass ");
			params.add(po.getBgigradualclass());
		}
		
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))) {
			buffer.append(",B_GI_FunctionClass ");
			params.add(po.getBgifunctionclass());
		}
		
		if (!"".equals(Utility.getName(po.getBgiaveragenotnaxrate()))) {
			buffer.append(",B_GI_AverageNotTaxRate ");
			params.add(Utility.getName(po.getBgiaveragenotnaxrate()));
		}
		
		if (!"".equals(Utility.getName(po.getBgiretailpricea()))) {
			buffer.append(",B_GI_RetailPriceA ");
			params.add(Utility.getName(po.getBgiretailpricea()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceb()))) {
			buffer.append(",B_GI_RetailPriceB ");
			params.add(Utility.getName(po.getBgiretailpriceb()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricec()))) {
			buffer.append(",B_GI_RetailPriceC ");
			params.add(Utility.getName(po.getBgiretailpricec()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriced()))) {
			buffer.append(",B_GI_RetailPriceD ");
			params.add(Utility.getName(po.getBgiretailpriced()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricee()))) {
			buffer.append(",B_GI_RetailPriceE ");
			params.add(Utility.getName(po.getBgiretailpricee()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricef()))) {
			buffer.append(",B_GI_RetailPriceF ");
			params.add(Utility.getName(po.getBgiretailpricef()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceg()))) {
			buffer.append(",B_GI_RetailPriceG ");
			params.add(Utility.getName(po.getBgiretailpriceg()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceh()))) {
			buffer.append(",B_GI_RetailPriceH ");
			params.add(Utility.getName(po.getBgiretailpriceh()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricei()))) {
			buffer.append(",B_GI_RetailPriceI ");
			params.add(Utility.getName(po.getBgiretailpricei()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
			buffer.append(",B_GI_SupplierSpec ");
			params.add(Utility.getName(po.getBgisupplierspec()));
		}
		if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
			buffer.append(",B_GI_ViewGoodsName ");
			params.add(Utility.getName(po.getBgiviewgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			buffer.append(",B_GI_PayFeeID ");
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		buffer.append(",B_GI_WholeGoodsIsable,B_GI_DefaultDiscountValue ");
		buffer.append(" ) VALUES ( ");

		String paramStr = "";
		for (int i = 0; i < params.size(); i++) {
			paramStr = paramStr + "?,";
		}

		buffer.append(paramStr.replaceFirst(",$", ""));

		buffer.append(" ,'1',?) ");
		params.add(Utility.getName(po.getBgidefaultdiscountvalue()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 停用
	 * 
	 * @param po
	 */
	public void updateLendsCustomDisable(GoodsInfoPo po) {
		String sql = "update B_GoodsInfo set B_GI_Flag= ? where B_GI_GoodsID= ? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgiflag());
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql, params.toArray());
	}

	/**
	 * 更新订做镜片
	 * 
	 * @param po
	 */
	public void updateLensCustom(GoodsInfoPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("UPDATE B_GoodsInfo ");
		buffer.append("SET ");

		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			buffer.append("B_GI_GoodsBarCode = ?, ");
			params.add(po.getBgigoodsbarcode());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			buffer.append("B_GI_GoodsName = ?, ");
			params.add(po.getBgigoodsname());
		}

		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			buffer.append("B_GI_GoodsCategoryID = ?, ");
			params.add(po.getBgigoodscategoryid());
		}

		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			buffer.append("B_GI_SupplierID = ?, ");
			params.add(po.getBgisupplierid());
		}

		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			buffer.append("B_GI_BrandID = ?, ");
			params.add(po.getBgibrandid());
		}

		if (!"".equals(Utility.getName(po.getBgiunitid()))) {
			buffer.append("B_GI_UnitId = ?, ");
			params.add(po.getBgiunitid());
		}

		if (!"".equals(Utility.getName(po.getBginottaxrate()))) {
			buffer.append("B_GI_NotTaxRate = ?, ");
			params.add(po.getBginottaxrate());
		}

		if (!"".equals(Utility.getName(po.getBgitaxrate()))) {
			buffer.append("B_GI_TaxRate = ?, ");
			params.add(po.getBgitaxrate());
		}

		if (!"".equals(Utility.getName(po.getBgispec()))) {
			buffer.append("B_GI_Spec = ?, ");
			params.add(po.getBgispec());
		}

		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			buffer.append("B_GI_Color = ?, ");
			params.add(po.getBgicolor());
		}

		if (!"".equals(Utility.getName(po.getBgiiscustomize()))) {
			buffer.append("B_GI_isCustomize = ?, ");
			params.add(po.getBgiiscustomize());
		}

		if (!"".equals(Utility.getName(po.getBgisph()))) {
			buffer.append("B_GI_Sph = ?, ");
			params.add(po.getBgisph());
		}

		if (!"".equals(Utility.getName(po.getBgisphul()))) {
			buffer.append("B_GI_SphUL = ?, ");
			params.add(po.getBgisphul());
		}

		if (!"".equals(Utility.getName(po.getBgisphup()))) {
			buffer.append("B_GI_SphUP = ?, ");
			params.add(po.getBgisphup());
		}
		
		if (!"".equals(Utility.getName(po.getBgisphspan()))) {
			buffer.append("B_GI_SphSpan = ?, ");
			params.add(po.getBgisphspan());
		}

		if (!"".equals(Utility.getName(po.getBgicyl()))) {
			buffer.append("B_GI_Cyl = ?, ");
			params.add(po.getBgicyl());
		}

		if (!"".equals(Utility.getName(po.getBgicylul()))) {
			buffer.append("B_GI_CylUL = ?, ");
			params.add(po.getBgicylul());
		}

		if (!"".equals(Utility.getName(po.getBgicylup()))) {
			buffer.append("B_GI_CylUP = ?, ");
			params.add(po.getBgicylup());
		}
		
		if (!"".equals(Utility.getName(po.getBgicylspan()))) {
			buffer.append("B_GI_CylSpan = ?, ");
			params.add(po.getBgicylspan());
		}

		if (!"".equals(Utility.getName(po.getBgibelowplusluminosity()))) {
			buffer.append("B_GI_BelowPlusLuminosity = ?, ");
			params.add(po.getBgibelowplusluminosity());
		}

		if (!"".equals(Utility.getName(po.getBgibelowplusluminosityul()))) {
			buffer.append("B_GI_BelowPlusLuminosityUL = ?, ");
			params.add(po.getBgibelowplusluminosityul());
		} else {
			buffer.append("B_GI_BelowPlusLuminosityUL = null, ");
		}

		if (!"".equals(Utility.getName(po.getBgibelowplusluminosityup()))) {
			buffer.append("B_GI_BelowPlusLuminosityUP = ?, ");
			params.add(po.getBgibelowplusluminosityup());
		} else {
			buffer.append("B_GI_BelowPlusLuminosityUP = null, ");
		}

		if (!"".equals(Utility.getName(po.getBgiaxis()))) {
			buffer.append("B_GI_Axis = ?, ");
			params.add(po.getBgiaxis());
		}

		if (!"".equals(Utility.getName(po.getBgiaxisul()))) {
			buffer.append("B_GI_AxisUL = ?, ");
			params.add(po.getBgiaxisul());
		}

		if (!"".equals(Utility.getName(po.getBgiaxisup()))) {
			buffer.append("B_GI_AxisUP = ?, ");
			params.add(po.getBgiaxisup());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature1()))) {
			buffer.append("B_GI_Curvature1 = ?, ");
			params.add(po.getBgicurvature1());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature1ul()))) {
			buffer.append("B_GI_Curvature1UL = ?, ");
			params.add(po.getBgicurvature1ul());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature1up()))) {
			buffer.append("B_GI_Curvature1UP = ?, ");
			params.add(po.getBgicurvature1up());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature2()))) {
			buffer.append("B_GI_Curvature2 = ?, ");
			params.add(po.getBgicurvature2());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature2ul()))) {
			buffer.append("B_GI_Curvature2UL = ?, ");
			params.add(po.getBgicurvature2ul());
		}

		if (!"".equals(Utility.getName(po.getBgicurvature2up()))) {
			buffer.append("B_GI_Curvature2UP = ?, ");
			params.add(po.getBgicurvature2up());
		}

		if (!"".equals(Utility.getName(po.getBgidia()))) {
			buffer.append("B_GI_Dia = ?, ");
			params.add(po.getBgidia());
		}

		if (!"".equals(Utility.getName(po.getBgidiaul()))) {
			buffer.append("B_GI_DiaUL = ?, ");
			params.add(po.getBgidiaul());
		}

		if (!"".equals(Utility.getName(po.getBgidiaup()))) {
			buffer.append("B_GI_DiaUP = ?, ");
			params.add(po.getBgidiaup());
		}

		if (!"".equals(Utility.getName(po.getBgiismutiluminosity()))) {
			buffer.append("B_GI_isMutiLuminosity = ?, ");
			params.add(po.getBgiismutiluminosity());
		}

		if (!"".equals(Utility.getName(po.getBgimutiluminositynum()))) {
			buffer.append("B_GI_MutiLuminosityNum = ?, ");
			params.add(po.getBgimutiluminositynum());
		}

		if (!"".equals(Utility.getName(po.getBgimutiluminosityaddprice()))) {
			buffer.append("B_GI_MutiLuminosityAddPrice = ?, ");
			params.add(po.getBgimutiluminosityaddprice());
		}

		if (!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))) {
			buffer.append("B_GI_EyeGlassMaterialType = ?, ");
			params.add(po.getBgieyeglassmaterialtype());
		}

		if (!"".equals(Utility.getName(po.getBgiisplating()))) {
			buffer.append("B_GI_isPlating = ?, ");
			params.add(po.getBgiisplating());
		}

		if (!"".equals(Utility.getName(po.getBgiordercycle()))) {
			buffer.append("B_GI_orderCycle = ?, ");
			params.add(po.getBgiordercycle());
		}
		
		if (!"".equals(Utility.getName(po.getBgiunionsphcyl()))) {//联合光度
			buffer.append("B_GI_UnionSphCyl = ?, ");
			params.add(po.getBgiunionsphcyl());
		}else{
			buffer.append("B_GI_UnionSphCyl = NULL, ");
		}
		
		if (!"".equals(Utility.getName(po.getBgifinishedglassestype()))) {
			buffer.append("B_GI_FinishedGlassesType = ?, ");
			params.add(po.getBgifinishedglassestype());
		}

		if (!"".equals(Utility.getName(po.getBgiframeprocesscrafttype()))) {
			buffer.append("B_GI_frameProcessCraftType = ?, ");
			params.add(po.getBgiframeprocesscrafttype());
		}

		if (!"".equals(Utility.getName(po.getBgicylmin()))) {
			buffer.append("B_GI_CylMin = ?, ");
			params.add(po.getBgicylmin());
		}

		if (!"".equals(Utility.getName(po.getBgicyldegreeincrease()))) {
			buffer.append("B_GI_CylDegreeIncrease = ?, ");
			params.add(po.getBgicyldegreeincrease());
		}

		if (!"".equals(Utility.getName(po.getBgicylminaddprice()))) {
			buffer.append("B_GI_CylMinAddPrice = ?, ");
			params.add(po.getBgicylminaddprice());
		}

		if (!"".equals(Utility.getName(po.getBgicyladdprice()))) {
			buffer.append("B_GI_CylAddPrice = ?, ");
			params.add(po.getBgicyladdprice());
		}

		if (!"".equals(Utility.getName(po.getBgiprismaddprice()))) {
			buffer.append("B_GI_PrismAddPrice = ?, ");
			params.add(po.getBgiprismaddprice());
		}

		if (!"".equals(Utility.getName(po.getBgicyl25cannotdo()))) {
			buffer.append("B_GI_cyl25CanNotDo = ?, ");
			params.add(po.getBgicyl25cannotdo());
		}

		if (!"".equals(Utility.getName(po.getBgithrowingcycle()))) {
			buffer.append("B_GI_ThrowingCycle = ?, ");
			params.add(po.getBgithrowingcycle());
		}

		if (!"".equals(Utility.getName(po.getBgistealthtype()))) {
			buffer.append("B_GI_StealthType = ?, ");
			params.add(po.getBgistealthtype());
		}

		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			buffer.append("B_GI_OtherGoodsBigClass = ?, ");
			params.add(po.getBgiothergoodsbigclass());
		}

		if (!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))) {
			buffer.append("B_GI_OtherGoodsSmallClass = ?, ");
			params.add(po.getBgiothergoodssmallclass());
		}
		
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			buffer.append("B_GI_Flag = ?, ");
			params.add(po.getBgiflag());
		}
		
		if (!"".equals(Utility.getName(po.getBgirefractive()))) {
			buffer.append("B_GI_Refractive = ?, ");
			params.add(po.getBgirefractive());
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesaleprice()))) {
			buffer.append("B_GI_WholesalePrice = ?, ");
			params.add(po.getBgiwholesaleprice());
		}
		
		if (!"".equals(Utility.getName(po.getBgigradualclass()))) {
			buffer.append("B_GI_GradualClass=?, ");
			params.add(po.getBgigradualclass());
		}
		
		if (!"".equals(Utility.getName(po.getBgifunctionclass()))) {
			buffer.append("B_GI_FunctionClass=?, ");
			params.add(po.getBgifunctionclass());  
		}
		
		if (!"".equals(Utility.getName(po.getBgiretailprice()))) {
			buffer.append("B_GI_RetailPrice=?, ");
			params.add(Utility.getName(po.getBgiretailprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricea()))) {
			buffer.append("B_GI_RetailPriceA=?, ");
			params.add(Utility.getName(po.getBgiretailpricea()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceb()))) {
			buffer.append("B_GI_RetailPriceB=?, ");
			params.add(Utility.getName(po.getBgiretailpriceb()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricec()))) {
			buffer.append("B_GI_RetailPriceC=?, ");
			params.add(Utility.getName(po.getBgiretailpricec()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriced()))) {
			buffer.append("B_GI_RetailPriceD=?, ");
			params.add(Utility.getName(po.getBgiretailpriced()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricee()))) {
			buffer.append("B_GI_RetailPriceE=?, ");
			params.add(Utility.getName(po.getBgiretailpricee()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricef()))) {
			buffer.append("B_GI_RetailPriceF=?, ");
			params.add(Utility.getName(po.getBgiretailpricef()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceg()))) {
			buffer.append("B_GI_RetailPriceG=?, ");
			params.add(Utility.getName(po.getBgiretailpriceg()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceh()))) {
			buffer.append("B_GI_RetailPriceH=?, ");
			params.add(Utility.getName(po.getBgiretailpriceh()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricei()))) {
			buffer.append("B_GI_RetailPriceI=?, ");
			params.add(Utility.getName(po.getBgiretailpricei()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
			buffer.append("B_GI_SupplierSpec=?, ");
			params.add(Utility.getName(po.getBgisupplierspec()));
		}
		if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
			buffer.append("B_GI_ViewGoodsName=?, ");
			params.add(Utility.getName(po.getBgiviewgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))) {
			buffer.append("B_GI_DefaultDiscountValue=?, ");
			params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
		}
		if (!"".equals(Utility.getName(po.getBgicostprice()))) {
			buffer.append("B_GI_CostPrice=?, ");
			params.add(Utility.getName(po.getBgicostprice()));
		}
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			buffer.append("B_GI_PayFeeID=?, ");
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		
		buffer = buffer.deleteCharAt(buffer.length() - 2);

		buffer.append("WHERE B_GI_GoodsID = ?");
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

}
