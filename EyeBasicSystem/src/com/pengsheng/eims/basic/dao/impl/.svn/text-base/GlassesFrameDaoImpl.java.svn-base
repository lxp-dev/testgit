package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesFrameDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.PhotoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 镜架dao 实现类
 */
public class GlassesFrameDaoImpl extends BaseJdbcDaoSupport implements
		GlassesFrameDao {
	/**
	 * 获取镜架数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getGlassesFrameCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1 and B_GoodsInfo.B_GI_GoodsCategoryID='1' and B_GoodsInfo.B_GI_SupplierID<>'ZZ' ");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GI_ViewGoodsName like'%' + ? + '%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode=?");
			params.add(po.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=?");
			params.add(po.getBgibrandid());
		}
		if (!"".equals(Utility.getName(po.getBgibarcodeflag()))) {
			sb.append(" and B_GI_BarCodeFlag=?");
			params.add(po.getBgibarcodeflag());
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
		if (!"".equals(Utility.getName(po.getBgicostbeginprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice>=?");
			params.add(po.getBgicostbeginprice());
		}
		if (!"".equals(Utility.getName(po.getBgicostendprice()))) {
			sb.append(" and B_GoodsInfo.B_GI_CostPrice<=?");
			params.add(po.getBgicostendprice());
		}
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			sb.append(" and B_GoodsInfo.B_GI_Flag=?");
			params.add(po.getBgiflag());
		}

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
		if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(Utility.getName(po.getBgitechnologytypeid()));
		}
		
		if("2".equals(Utility.getName(po.getBgiissetflag()))){
        	sb.append(" and isnull(B_GI_PayFeeID,'') = '' ");
        }
        
        if("3".equals(Utility.getName(po.getBgiissetflag()))){
        	if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
        		sb.append(" and isnull(B_GI_PayFeeID,'') = ? ");
        		params.add(Utility.getName(po.getBgipayfeeid()));
        	}else{
        		sb.append(" and isnull(B_GI_PayFeeID,'') <> '' ");
        	}
        } 
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	/**
	 * 获取镜架list
	 * 
	 * @param po
	 *            商品po
	 * @param start
	 * @param size
	 * @return list 镜架list
	 */
	public List<GoodsInfoPo> getGlassesFrameList(GoodsInfoPo po, int start,int size) {

		StringBuffer sb = new StringBuffer();

		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");

		sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,temp.bgiwholegoodsisable as bgiwholegoodsisable,");
		sb.append("temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bgiflag as bgiflag ");
		sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,B_GI_WholeGoodsIsable as bgiwholegoodsisable,");
		sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
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
		sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_Flag as bgiflag ");
		sb.append(",B_GI_PayFeeID as bgipayfeeid ");
		sb.append("from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1 and B_GoodsInfo.B_GI_GoodsCategoryID='1' and B_GoodsInfo.B_GI_SupplierID<>'ZZ' ");
		
		List<String> params = new ArrayList<String>();
		
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
		
		if (!"".equals(Utility.getName(po.getBgibarcodeflag()))) {
			sb.append(" and B_GI_BarCodeFlag=?");
			params.add(po.getBgibarcodeflag());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%' ");
			params.add(po.getBgigoodsid());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GI_ViewGoodsName like'%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode=? ");
			params.add(po.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID=?");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID=? ");
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
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			sb.append(" and B_GoodsInfo.B_GI_Flag=?");
			params.add(po.getBgiflag());
		}
		
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
		if(!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			sb.append(" and B_GoodsInfo.B_GI_FrameMaterialType=?");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		if(!"".equals(Utility.getName(po.getBgitechnologytypeid()))) {
			sb.append(" and B_GoodsInfo.B_GI_frameProcessCraftType=?");
			params.add(Utility.getName(po.getBgitechnologytypeid()));
		}
		if("2".equals(Utility.getName(po.getBgiissetflag()))){
        	sb.append(" and isnull(B_GI_PayFeeID,'') = '' ");
        }
        
        if("3".equals(Utility.getName(po.getBgiissetflag()))){
        	if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
        		sb.append(" and isnull(B_GI_PayFeeID,'') = ? ");
        		params.add(Utility.getName(po.getBgipayfeeid()));
        	}else{
        		sb.append(" and isnull(B_GI_PayFeeID,'') <> '' ");
        	}
        } 
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");

		return queryForObjectList(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 新增镜架
	 * 
	 * @param po
	 *            商品po
	 */
	public void insertGlassesFrame(GoodsInfoPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("INSERT INTO B_GoodsInfo (");

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			buffer.append("B_GI_GoodsID ");
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
		if (!"".equals(Utility.getName(po.getBgispec()))) {
			buffer.append(",B_GI_Spec ");
			params.add(po.getBgispec());
		}
		if (!"".equals(Utility.getName(po.getBgicolor()))) {
			buffer.append(",B_GI_Color ");
			params.add(po.getBgicolor());
		}
		if (!"".equals(Utility.getName(po.getBgiframeprocesscrafttype()))) {
			buffer.append(",B_GI_frameProcessCraftType ");
			params.add(po.getBgiframeprocesscrafttype());
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
		if (!"".equals(Utility.getName(po.getBgiretailprice()))) {
			buffer.append(",B_GI_RetailPrice ");
			params.add(po.getBgiretailprice());
		}

		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			buffer.append(",B_GI_Flag ");
			params.add(po.getBgiflag());
		}
		
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))) {
			buffer.append(",B_GI_FrameMaterialType ");
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		
		if (!"".equals(Utility.getName(po.getBgiwholesaleprice()))) {
			buffer.append(",B_GI_WholesalePrice ");
			params.add(Utility.getName(po.getBgiwholesaleprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiframesize()))) {
			buffer.append(",B_GI_FrameSize ");
			params.add(Utility.getName(po.getBgiframesize()));
		}
		if (!"".equals(Utility.getName(po.getBgisuppliercolor()))) {
			buffer.append(",B_GI_SupplierColor ");
			params.add(Utility.getName(po.getBgisuppliercolor()));
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
		if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
			buffer.append(",B_GI_BrandYear ");
			params.add(Utility.getName(po.getBgibrandyear()));
		}
		if (!"".equals(Utility.getName(po.getBgichinesecolor()))) {
			buffer.append(",B_GI_ChineseColor ");
			params.add(Utility.getName(po.getBgichinesecolor()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
			buffer.append(",B_GI_SupplierSpec ");
			params.add(Utility.getName(po.getBgisupplierspec()));
		}
		if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
			buffer.append(",B_GI_ViewGoodsName ");
			params.add(Utility.getName(po.getBgiviewgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgibarcodeflag()))) {
			buffer.append(",B_GI_BarCodeFlag ");
			params.add(Utility.getName(po.getBgibarcodeflag()));
		}
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			buffer.append(",B_GI_PayFeeID ");
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		buffer.append(",B_GI_WholeGoodsIsable ");
		buffer.append(",B_GI_DefaultDiscountValue ");
		buffer.append(",B_GI_FrameStyle ");
		buffer.append(") VALUES ( ");

		String paramStr = "";
		for (int i = 0; i < params.size(); i++) {
			paramStr = paramStr + "?,";
		}

		buffer.append(paramStr.replaceFirst(",$", ""));

		buffer.append(" ,'1',? ,?) ");
		params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
		params.add(Utility.getName(po.getBgiframestyle()));
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 修改镜架
	 * 
	 * @param po
	 *            商品po
	 */
	public void updateGlassesFrame(GoodsInfoPo po) {
		List<String> params = new ArrayList<String>();
		String sql = "update B_GoodsInfo set B_GI_GoodsName=?,B_GI_UnitId=?,B_GI_frameProcessCraftType=?,"
			+ "B_GI_TaxRate=?,B_GI_NotTaxRate=? ,B_GI_FrameMaterialType=?,B_GI_WholesalePrice=?,B_GI_FrameSize=?,B_GI_SupplierColor=? ";
			
			params.add(po.getBgigoodsname());
			params.add(po.getBgiunitid());
			params.add(po.getBgiframeprocesscrafttype());
			params.add(po.getBgitaxrate());
			params.add(po.getBginottaxrate());
			params.add(po.getBgiframematerialtype());
			if(!"".equals(Utility.getName(po.getBgiwholesaleprice()))){
			params.add(Utility.getName(po.getBgiwholesaleprice()));
			}else{
				params.add("0.00");
			}
			params.add(po.getBgiframesize());
			params.add(po.getBgisuppliercolor());
			if (!"".equals(Utility.getName(po.getBgiretailprice()))) {
				sql = sql+",B_GI_RetailPrice=? ";
				params.add(Utility.getName(po.getBgiretailprice()));
			}
			
			if (!"".equals(Utility.getName(po.getBgiretailpricea()))) {
				sql = sql+",B_GI_RetailPriceA=? ";
				params.add(Utility.getName(po.getBgiretailpricea()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpriceb()))) {
				sql = sql+",B_GI_RetailPriceB=? ";
				params.add(Utility.getName(po.getBgiretailpriceb()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpricec()))) {
				sql = sql+",B_GI_RetailPriceC=? ";
				params.add(Utility.getName(po.getBgiretailpricec()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpriced()))) {
				sql = sql+",B_GI_RetailPriceD=? ";
				params.add(Utility.getName(po.getBgiretailpriced()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpricee()))) {
				sql = sql+",B_GI_RetailPriceE=? ";
				params.add(Utility.getName(po.getBgiretailpricee()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpricef()))) {
				sql = sql+",B_GI_RetailPriceF=? ";
				params.add(Utility.getName(po.getBgiretailpricef()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpriceg()))) {
				sql = sql+",B_GI_RetailPriceG=? ";
				params.add(Utility.getName(po.getBgiretailpriceg()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpriceh()))) {
				sql = sql+",B_GI_RetailPriceH=? ";
				params.add(Utility.getName(po.getBgiretailpriceh()));
			}
			if (!"".equals(Utility.getName(po.getBgiretailpricei()))) {
				sql = sql+",B_GI_RetailPriceI=? ";
				params.add(Utility.getName(po.getBgiretailpricei()));
			}
			if (!"".equals(Utility.getName(po.getBgibrandyear()))) {
				sql = sql+",B_GI_BrandYear=? ";
				params.add(Utility.getName(po.getBgibrandyear()));
			}
			if (!"".equals(Utility.getName(po.getBgichinesecolor()))) {
				sql = sql+",B_GI_ChineseColor=? ";
				params.add(Utility.getName(po.getBgichinesecolor()));
			}
			if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
				sql = sql+",B_GI_SupplierSpec=? ";
				params.add(Utility.getName(po.getBgisupplierspec()));
			}
			if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
				sql = sql+",B_GI_ViewGoodsName=? ";
				params.add(Utility.getName(po.getBgiviewgoodsname()));
			}
			if (!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))) {
				sql = sql+",B_GI_DefaultDiscountValue=? ";
				params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
			}
			if (!"".equals(Utility.getName(po.getBgibarcodeflag()))) {
				sql = sql+",B_GI_BarCodeFlag=? ";
				params.add(Utility.getName(po.getBgibarcodeflag()));
			}
			if (!"".equals(Utility.getName(po.getBgicostprice()))) {
				sql = sql+",B_GI_CostPrice=? ";
				params.add(Utility.getName(po.getBgicostprice()));
			}
			if (!"".equals(Utility.getName(po.getBgiframestyle()))) {
				sql = sql+",B_GI_FrameStyle=? ";
				params.add(Utility.getName(po.getBgiframestyle()));
			}
			if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
				sql = sql+",B_GI_PayFeeID=? ";
				params.add(Utility.getName(po.getBgipayfeeid()));
			}
			sql = sql+" where B_GI_GoodsID=?";
			
			params.add(po.getBgigoodsid());
		
		getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 获取镜架po
	 * 
	 * @param po
	 *            商品po
	 * @return po 商品po
	 */
	public GoodsInfoPo getGlassesFrame(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,B_GI_GoodsName as bgigoodsname,B_GoodsInfo.B_GI_SupplierID as bgisupplierid,B_Supplier.B_SP_SupplierName as bgisuppliername,");
		sb.append("B_GoodsInfo.B_GI_BrandID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,");
		sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_UnitId as bgiunitid,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_frameProcessCraftType as bgiframeprocesscrafttype,");
		sb.append("B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_FrameMaterial.B_FM_Name as bgiframematerialtypename,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,B_GI_FrameMaterialType as bgiframematerialtype,B_GI_AverageNotTaxRate as bgiaveragenotnaxrate,B_GI_WholesalePrice as bgiwholesaleprice,B_GI_FrameSize as bgiframesize,B_GI_SupplierColor as bgisuppliercolor,isnull(B_GI_BrandYear,'') as bgibrandyear, ");
		
		sb.append("isnull(B_GI_RetailPriceA ,0.00)    as  bgiretailpricea,");
		sb.append("isnull(B_GI_RetailPriceB ,0.00)    as  bgiretailpriceb,");
		sb.append("isnull(B_GI_RetailPriceC ,0.00)    as  bgiretailpricec,");
		sb.append("isnull(B_GI_RetailPriceD ,0.00)    as  bgiretailpriced,");
		sb.append("isnull(B_GI_RetailPriceE ,0.00)    as  bgiretailpricee,");
		sb.append("isnull(B_GI_RetailPriceF ,0.00)    as  bgiretailpricef,");
		sb.append("isnull(B_GI_RetailPriceG ,0.00)    as  bgiretailpriceg,");
		sb.append("isnull(B_GI_RetailPriceH ,0.00)    as  bgiretailpriceh,");
		sb.append("isnull(B_GI_RetailPriceI ,0.00)    as  bgiretailpricei, ");
		sb.append("B_GI_ChineseColor    		as  bgichinesecolor, ");
		sb.append("B_C_ColorName    			as  bgichinesecolorname, ");
		sb.append("B_GI_SupplierSpec    		as  bgisupplierspec, ");
		sb.append("B_GI_ViewGoodsName   		as  bgiviewgoodsname, ");
		sb.append("B_GI_DefaultDiscountValue   	as  bgidefaultdiscountvalue, ");
		sb.append("B_GI_BarCodeFlag   			as  bgibarcodeflag, ");
		sb.append("B_GL_Name				   	as  bgidefaultdiscountvaluename, ");
		sb.append("B_GI_FrameStyle				as  bgiframestyle ");
		sb.append(",B_GI_PayFeeID				as  bgipayfeeid ");
		sb.append(" from B_GoodsInfo");
		sb.append(" inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID");
		sb.append(" inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" left join B_FrameMaterial on B_GoodsInfo.B_GI_FrameMaterialType=B_FrameMaterial.B_FM_ID  ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id");
		sb.append(" left join B_Color on B_GoodsInfo.B_GI_ChineseColor = B_C_id");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID");
		sb.append(" where B_GoodsInfo.B_GI_GoodsID=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());

		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}
	
	
	/**
	 * 获取镜架po
	 * 
	 * @param po
	 *            商品po
	 * @return po 商品po
	 */
	public GoodsInfoPo getGlassesFrameCode(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1 B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode ");
		sb.append(" from B_GoodsInfo");
		sb.append(" where B_GoodsInfo.B_GI_GoodsBarCode=? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsbarcode());

		return (GoodsInfoPo) queryForObject(sb.toString(), params.toArray(),
				GoodsInfoPo.class);
	}

	/**
	 * 删除镜架
	 * 
	 * @param po
	 *            商品po
	 */
	public void deleteGlassesFrame(GoodsInfoPo po) {

		String sql = "delete from B_GoodsInfo where B_GI_GoodsID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql, params.toArray());

	}

	/**
	 * 修改镜架的停用/启用状态
	 * 
	 * @param po
	 *            商品po
	 */
	public void updateGlassesFrameDisable(GoodsInfoPo po) {

		String sql = "update B_GoodsInfo set B_GI_Flag=? where B_GI_GoodsID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgiflag());
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql, params.toArray());
	}
	
	/**
	 * 修改镜架批发的停用/启用状态
	 * 
	 * @param po
	 *            商品po
	 */
	public void updateAllWholeDisable(GoodsInfoPo po) {

		String sql = "update B_GoodsInfo set B_GI_WholeGoodsIsable=? where B_GI_GoodsID=?";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgiflag());
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql, params.toArray());
	}
	
	public void insertFAQFile(PhotoPo faqFilePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_OP_EyesPhotoLog ");
		buffer.append("(S_OP_ID,  ");
		buffer.append("S_OP_WID,  ");
		buffer.append("S_OP_FileName,  ");
		buffer.append("S_OP_SaveFileName, ");
		buffer.append("S_OP_SaveFileLittleName, ");
		buffer.append("S_OP_ContentType ");
		buffer.append(") ");
		buffer.append("values (?, ?, ?, ?, ?, ?  ); ");

		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(Utility.getName(faqFilePo.getFaqID()));
		params.add(Utility.getName(faqFilePo.getFileName()));
		params.add(Utility.getName(faqFilePo.getSaveFileName()));
		params.add(Utility.getName(faqFilePo.getSaveFileLittleName()));
		params.add(Utility.getName(faqFilePo.getContentType()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void updateFAQFile(PhotoPo faqFilePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update  S_OP_EyesPhotoLog set ");
		buffer.append(" S_OP_Status = '2' ");
		buffer.append(" where S_OP_WID=? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(faqFilePo.getFaqID()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	public PhotoPo selectpath(PhotoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1 S_OP_ID as id,S_OP_WID as faqID,S_OP_FileName as fileName,S_OP_SaveFileName as saveFileName,S_OP_SaveFileLittleName as saveFileLittleName,S_OP_ContentType as contentType ");
		sb.append(" from S_OP_EyesPhotoLog");
		sb.append(" where S_OP_ID=? ");
		List<String> params = new ArrayList<String>();
		params.add(po.getId());
		return (PhotoPo) queryForObject(sb.toString(), params.toArray(),PhotoPo.class);
	}
	
	public void deleteFAQFile(String uuid) {
		StringBuffer buffer = new StringBuffer();	
		buffer.append("delete from S_OP_EyesPhotoLog where S_OP_ID=? ");
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(uuid));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public List<PhotoPo> getPhotoList(GoodsInfoPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select S_OP_ID as id,S_OP_WID as faqID,S_OP_FileName as fileName,S_OP_SaveFileName as saveFileName,S_OP_SaveFileLittleName as saveFileLittleName,S_OP_ContentType as contentType ");
		sb.append(" from  S_OP_EyesPhotoLog where S_OP_WID=? order by S_OP_Status desc");
		params.add(Utility.getName(po.getBgigoodsid()));
		
		return queryForObjectList(sb.toString(), params.toArray(),PhotoPo.class);
	}
	
	/**
	 * 获取镜架数量
	 * 
	 * @param po
	 *            商品po
	 * @return int 数量
	 */
	public int getPhotoListAllCount(GoodsInfoPo po) {

		StringBuffer varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();
		varname1.append("SELECT count(B_GoodsInfo.B_GI_GoodsID) ");
		
		varname1.append("FROM   S_OP_EyesPhotoLog ");
		varname1.append("       INNER JOIN B_GoodsInfo ");
		varname1.append("         ON B_GoodsInfo.B_GI_GoodsID = S_OP_EyesPhotoLog.S_OP_WID ");
		varname1.append("       INNER JOIN B_Supplier ");
		varname1.append("         ON B_GoodsInfo.B_GI_SupplierID = B_Supplier.B_SP_ID ");
		varname1.append("       INNER JOIN B_Brand ");
		varname1.append("         ON B_GoodsInfo.B_GI_BrandID = B_Brand.B_BD_ID ");
		varname1.append("            AND B_GoodsInfo.B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
		varname1.append("       LEFT JOIN B_Unit ");
		varname1.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
		varname1.append("       INNER JOIN B_GoodsCategory ");
		varname1.append("         ON B_GoodsInfo.B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
		varname1.append("       LEFT JOIN B_FrameMaterial ");
		varname1.append("         ON B_GoodsInfo.B_GI_FrameMaterialType = B_FrameMaterial.B_FM_ID ");
		varname1.append(" where B_GI_Flag='1'");
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			varname1.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=? ");
			params.add(po.getBgigoodscategoryid());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			varname1.append(" and  B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%' ");
			params.add(po.getBgigoodsid());
		}

		return getJdbcTemplate().queryForInt(varname1.toString(), params.toArray());
	}
	
	public List<GoodsInfoPo> getPhotoListAll(GoodsInfoPo po, int start,int size) {
		
		StringBuffer varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		varname1.append("set rowcount " + countPage + " \n");
		varname1.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,");
		varname1.append("temp.bgispec as bgispec,temp.bgigoodscategoryname as bgigoodscategoryname,temp.bgicolor as bgicolor,temp.faqID as faqID,temp.bgisource as bgisource, ");
		varname1.append("temp.fileName as fileName,temp.saveFileLittleName as saveFileLittleName,temp.saveFileName as saveFileName,temp.contentType as contentType,temp.bgiframematerialtypename as bgiframematerialtypename,temp.id as id,temp.bgibrandname as bgibrandname,temp.bgigoodsbarcode as bgigoodsbarcode,temp.bgiretailprice as bgiretailprice ");
		varname1.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
		varname1.append("       B_GoodsInfo.B_GI_GoodsID               AS bgigoodsid, ");
		varname1.append("       B_GI_ViewGoodsName             AS bgigoodsname, ");
		varname1.append("       B_Supplier.B_SP_SupplierName           AS bgisuppliername, ");
		varname1.append("       B_GoodsInfo.B_GI_Spec                  AS bgispec, ");
		varname1.append("       B_GoodsInfo.B_GI_Color                 AS bgicolor, ");
		varname1.append("       B_GoodsInfo.B_GI_Sph                   AS bgisph, ");
		varname1.append("       B_GoodsInfo.B_GI_GoodsBarCode          AS bgigoodsbarcode, ");
		varname1.append("       B_Brand.B_BD_brandName                 AS bgibrandname, ");
		varname1.append("       B_Unit.B_UT_unitName                   AS bgiunitname, ");
		varname1.append("       B_GoodsInfo.B_GI_Flag                  AS bgiflag, ");
		varname1.append("       B_GoodsInfo.B_GI_GoodsCategoryID       AS bgigoodscategoryid, ");
		varname1.append("       B_GoodsCategory.B_GC_GoodsCategoryName AS bgigoodscategoryname, ");
		varname1.append("       B_GI_FrameSize                         AS bgiframesize, ");
		varname1.append("       B_GI_RetailPrice                       AS bgiretailprice, ");
		varname1.append("       B_BD_Place                         	   AS bgisource, ");
		varname1.append("       S_OP_ID                                AS id, ");
		varname1.append("       B_FrameMaterial.B_FM_Name              AS bgiframematerialtypename, ");
		varname1.append("       S_OP_EyesPhotoLog.S_OP_WID             AS faqID, ");
		varname1.append("       S_OP_FileName                          AS fileName, ");
		varname1.append("       S_OP_SaveFileLittleName                      AS saveFileLittleName, ");
		varname1.append("       S_OP_SaveFileName                      AS saveFileName, ");
		varname1.append("       S_OP_ContentType                       AS contentType ");
		varname1.append("FROM   S_OP_EyesPhotoLog ");
		varname1.append("       INNER JOIN B_GoodsInfo ");
		varname1.append("         ON B_GoodsInfo.B_GI_GoodsID = S_OP_EyesPhotoLog.S_OP_WID ");
		varname1.append("       INNER JOIN B_Supplier ");
		varname1.append("         ON B_GoodsInfo.B_GI_SupplierID = B_Supplier.B_SP_ID ");
		varname1.append("       INNER JOIN B_Brand ");
		varname1.append("         ON B_GoodsInfo.B_GI_BrandID = B_Brand.B_BD_ID ");
		varname1.append("            AND B_GoodsInfo.B_GI_SupplierID = B_Brand.B_BD_SupplierID ");
		varname1.append("       LEFT JOIN B_Unit ");
		varname1.append("         ON B_GoodsInfo.B_GI_UnitId = B_Unit.B_UT_id ");
		varname1.append("       INNER JOIN B_GoodsCategory ");
		varname1.append("         ON B_GoodsInfo.B_GI_GoodsCategoryID = B_GoodsCategory.B_GC_ID ");
		varname1.append("       LEFT JOIN B_FrameMaterial ");
		varname1.append("         ON B_GoodsInfo.B_GI_FrameMaterialType = B_FrameMaterial.B_FM_ID ");
		varname1.append(" where B_GI_Flag='1' ");
		
		if (!"".equals(Utility.getName(po.getBgigoodscategoryid()))) {
			varname1.append(" and B_GoodsInfo.B_GI_GoodsCategoryID=? ");
			params.add(po.getBgigoodscategoryid());
		}

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			varname1.append(" and  B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%' ");
			params.add(po.getBgigoodsid());
		}
		varname1.append(" ) temp where rowNum > " + start + " and rowNum <= "+ countPage);
		varname1.append(" set rowcount 0");
		
		return queryForObjectList(varname1.toString(), params.toArray(),GoodsInfoPo.class);
	}

}
