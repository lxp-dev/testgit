package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.StealthFinishedDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class StealthFinishedDaoImpl extends BaseJdbcDaoSupport implements
		StealthFinishedDao {

	public int getStealthFinishedCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1  and B_GoodsInfo.B_GI_GoodsCategoryID='4' and B_GI_isCustomize='0' ");
		
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
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? +'%'");
			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode= ? ");
			params.add(po.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID= ? ");
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
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			sb.append(" and B_GoodsInfo.B_GI_Flag=?");
			params.add(po.getBgiflag());
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

	public List<GoodsInfoPo> getStealthFinishedList(GoodsInfoPo po, int start,
			int size) {

		StringBuffer sb = new StringBuffer();

		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,temp.bgiwholegoodsisable as bgiwholegoodsisable,");
		sb.append("temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bgiflag as bgiflag,");
		sb.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia ");
		sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,B_GI_WholeGoodsIsable as bgiwholegoodsisable,");
		sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
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
		sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_Flag as bgiflag,");
		sb.append("B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1  and B_GoodsInfo.B_GI_GoodsCategoryID='4' and B_GI_isCustomize='0'");
		
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
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%' ");

			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? +'%' ");

			params.add(po.getBgigoodsname());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsbarcode()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode= ? ");

			params.add(po.getBgigoodsbarcode());
		}
		if (!"".equals(Utility.getName(po.getBgisupplierid()))) {
			sb.append(" and B_GoodsInfo.B_GI_SupplierID= ? ");

			params.add(po.getBgisupplierid());
		}
		if (!"".equals(Utility.getName(po.getBgibrandid()))) {
			sb.append(" and B_GoodsInfo.B_GI_BrandID= ? ");

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
		
		if (!"".equals(Utility.getName(po.getBgiflag()))) {
			sb.append(" and B_GoodsInfo.B_GI_Flag=?");
			params.add(po.getBgiflag());
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

	public void insertStealthFinished(GoodsInfoPo po) {
		List<String> params = new ArrayList<String>();
		
		params.add(po.getBgigoodsid().toUpperCase());
		params.add(po.getBgigoodsbarcode().toUpperCase());
		params.add(po.getBgigoodsname());
		params.add(po.getBgigoodscategoryid());
		params.add(po.getBgisupplierid());
		params.add(po.getBgibrandid());
		params.add(po.getBgiunitid());
		params.add(po.getBgistealthtype());
		params.add(po.getBgisph());
		params.add(po.getBgicyl());
		params.add(po.getBgicurvature1());
		params.add(po.getBgidia());
		params.add(po.getBgicostprice());
		params.add(po.getBgitaxrate());
		params.add(po.getBginottaxrate());
		params.add(po.getBgiretailprice());
		params.add(po.getBgicolor());
		params.add(po.getBgireturnmax());
		params.add(po.getBgireturnmin());
		params.add(po.getBgiwholesaleprice());
		params.add(po.getBgiusetype());
		params.add(po.getBgistealthclass());
		params.add(po.getBgiaxis());
		params.add(Utility.getName(po.getBgiaveragenotnaxrate()).equals("") ? "0.00" : Utility.getName(po.getBgiaveragenotnaxrate()));
		params.add(Utility.getName(po.getBgicontacttype()));
		
		String sql = "insert into B_GoodsInfo(B_GI_GoodsID,B_GI_GoodsBarCode,B_GI_GoodsName,B_GI_GoodsCategoryID,B_GI_SupplierID,"
				+ "B_GI_BrandID,B_GI_UnitId,B_GI_StealthType,B_GI_Sph,B_GI_Cyl,B_GI_Curvature1,B_GI_Dia,B_GI_CostPrice,B_GI_TaxRate,"
				+ "B_GI_NotTaxRate,B_GI_RetailPrice,B_GI_isCustomize,B_GI_Flag,B_GI_Color,B_GI_ReturnMax,B_GI_ReturnMin,B_GI_WholesalePrice,B_GI_UseType,B_GI_StealthClass,B_GI_Axis,B_GI_AverageNotTaxRate,B_GI_ContactType ";
		String sql1 = "values(?, ?, ?,?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, '0', '1',?,?,?,?,?,?,?,?,?";	
				if(!"".equals(Utility.getName(po.getBgiretailpricea()))){
					sql = sql + ",B_GI_RetailPriceA ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpricea()));
				}
				if (!"".equals(Utility.getName(po.getBgivsph()))) {
					sql = sql + ",B_GI_Vsph ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgivsph()));
				}
				
				if (!"".equals(Utility.getName(po.getBgivcyl()))) {
					sql = sql + ",B_GI_Vcyl ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgivcyl()));
				}
				if(!"".equals(Utility.getName(po.getBgiretailpriceb()))){
					sql = sql + ",B_GI_RetailPriceB ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpriceb()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpricec()))){
					sql = sql + ",B_GI_RetailPriceC ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpricec()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpriced()))){
					sql = sql + ",B_GI_RetailPriceD ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpriced()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpricee()))){
					sql = sql + ",B_GI_RetailPriceE ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpricee()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpricef()))){
					sql = sql + ",B_GI_RetailPriceF ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpricef()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpriceg()))){
					sql = sql + ",B_GI_RetailPriceG ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpriceg()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpriceh()))){
					sql = sql + ",B_GI_RetailPriceH ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpriceh()));
				}
				
				if(!"".equals(Utility.getName(po.getBgiretailpricei()))){
					sql = sql + ",B_GI_RetailPriceI ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiretailpricei()));
				}
				
				if (!"".equals(Utility.getName(po.getBgichinesecolor()))) {
					sql = sql+",B_GI_ChineseColor ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgichinesecolor()));
				}
				
				if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
					sql = sql + ",B_GI_ViewGoodsName ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBgiviewgoodsname()));
				}
				/**************************隐形产品可使用天数************************************/			
				if (!"".equals(Utility.getName(po.getBginumberofdays()))) {
					sql = sql + ",B_GI_Numberofdays ";
					sql1 = sql1 + ",?";
					params.add(Utility.getName(po.getBginumberofdays()));
				}
				/**************************************************************/
				
				sql = sql + ",B_GI_WholeGoodsIsable,B_GI_DefaultDiscountValue,B_GI_PayFeeID ";
				sql = sql + ") ";
				sql1 = sql1 + ",'1', ?, ?) ";
				params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
				params.add(Utility.getName(po.getBgipayfeeid()));
				
				sql = sql+sql1;

		getJdbcTemplate().update(sql, params.toArray());

	}

	public void updateStealthFinished(GoodsInfoPo po) {
		List<String> params = new ArrayList<String>();
		String sql = "update B_GoodsInfo set B_GI_GoodsName= ? ,B_GI_UnitId= ? ,B_GI_UseType= ?, "
			+ "B_GI_Curvature1= ? ,B_GI_Dia=?,B_GI_StealthClass= ?,"
			+ "B_GI_TaxRate= ?,B_GI_NotTaxRate= ?,B_GI_ReturnMax=?,B_GI_ReturnMin=? ,B_GI_WholesalePrice=? ";
		
		params.add(po.getBgigoodsname());
		params.add(po.getBgiunitid());
		params.add(Utility.getName(po.getBgiusetype()));
		params.add(po.getBgicurvature1());
		params.add(po.getBgidia());
		params.add(po.getBgistealthclass());
		params.add(po.getBgitaxrate());
		params.add(po.getBginottaxrate());
		params.add(po.getBgireturnmax());
		params.add(po.getBgireturnmin());
		params.add(po.getBgiwholesaleprice());
		
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
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
			sql = sql+",B_GI_SupplierSpec=? ";
			params.add(Utility.getName(po.getBgisupplierspec()));
		}
		if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
			sql = sql+",B_GI_ViewGoodsName=? ";
			params.add(Utility.getName(po.getBgiviewgoodsname()));
		}
		/**************************隐形产品可使用天数************************************/		
		if (!"".equals(Utility.getName(po.getBginumberofdays()))) {
			sql = sql+",B_GI_Numberofdays=? ";
			params.add(Utility.getName(po.getBginumberofdays()));
		}
		/*************************************************************/		
		
		
		if (!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))) {
			sql = sql+",B_GI_DefaultDiscountValue=? ";
			params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
		}
		
		if (!"".equals(Utility.getName(po.getBgicontacttype()))) {
			sql = sql+",B_GI_ContactType=? ";
			params.add(Utility.getName(po.getBgicontacttype()));
		}
		
		if (!"".equals(Utility.getName(po.getBgicostprice()))) {
			sql = sql+",B_GI_CostPrice=? ";
			params.add(Utility.getName(po.getBgicostprice()));
		}
		
		sql = sql+",B_GI_ChineseColor=? ";
		params.add(Utility.getName(po.getBgichinesecolor()));
		
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			sql = sql+",B_GI_PayFeeID=? ";
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		
		sql = sql + "where B_GI_GoodsID= ? ";
		params.add(po.getBgigoodsid());
		getJdbcTemplate().update(sql, params.toArray());
	}

	public GoodsInfoPo getStealthFinished(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GI_GoodsBarCode as bgigoodsbarcode,B_GoodsInfo.B_GI_GoodsName as bgigoodsname,B_GoodsInfo.B_GI_SupplierID as bgisupplierid,B_Supplier.B_SP_SupplierName as bgisuppliername,");
		sb.append("B_GoodsInfo.B_GI_BrandID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,B_GI_ReturnMax as bgireturnmax,B_GI_ReturnMin as bgireturnmin, ");  
		sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_Color as bgicolor,B_GoodsInfo.B_GI_UnitId as bgiunitid,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_frameProcessCraftType as bgiframeprocesscrafttype,");
		sb.append("B_GoodsInfo.B_GI_Sph as bgisph,B_GoodsInfo.B_GI_Cyl as bgicyl,B_GoodsInfo.B_GI_Curvature1 as bgicurvature1,B_GoodsInfo.B_GI_Dia as bgidia,B_GoodsInfo.B_GI_StealthType as bgistealthtype,B_GoodsInfo.B_GI_ThrowingCycle as bgithrowingcycle,");
		sb.append("B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,B_GI_AverageNotTaxRate as bgiaveragenotnaxrate,B_GI_WholesalePrice as bgiwholesaleprice,B_GI_UseType as bgiusetype,B_GI_StealthClass as bgistealthclass,B_GI_Axis as bgiaxis,  ");
		
		sb.append("B_GI_Numberofdays    as  bginumberofdays,");
		sb.append("B_GI_PayFeeID    	as  bgipayfeeid,");
		sb.append("B_GI_ChineseColor    as  bgichinesecolor,");
		sb.append("B_C_ColorName    	as  bgichinesecolorname, ");
		sb.append("isnull(B_GI_RetailPriceA ,0.00)    	as  bgiretailpricea,");
		sb.append("isnull(B_GI_RetailPriceB ,0.00)   	as  bgiretailpriceb,");
		sb.append("isnull(B_GI_RetailPriceC ,0.00)    	as  bgiretailpricec,");
		sb.append("isnull(B_GI_RetailPriceD ,0.00)   	as  bgiretailpriced,");
		sb.append("isnull(B_GI_RetailPriceE ,0.00)   	as  bgiretailpricee,");
		sb.append("isnull(B_GI_RetailPriceF ,0.00)  	as  bgiretailpricef,");
		sb.append("isnull(B_GI_RetailPriceG ,0.00)   	as  bgiretailpriceg,");
		sb.append("isnull(B_GI_RetailPriceH ,0.00)   	as  bgiretailpriceh,");
		sb.append("isnull(B_GI_RetailPriceI ,0.00)   	as  bgiretailpricei, ");
		sb.append("B_GI_DefaultDiscountValue    		as  bgidefaultdiscountvalue, ");
		sb.append("B_GL_Name					  		as  bgidefaultdiscountvaluename,isnull(B_GI_ContactType,'') as bgicontacttype ");
		sb.append(" from B_GoodsInfo");
		sb.append(" inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID");
		sb.append(" inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id");
		sb.append(" left join B_Color on B_GoodsInfo.B_GI_ChineseColor = B_C_id ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID ");
		sb.append(" where B_GoodsInfo.B_GI_GoodsID = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());

		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(),GoodsInfoPo.class);
	}

	public void deleteStealthFinished(GoodsInfoPo po) {

		String sql = "delete from B_GoodsInfo where B_GI_GoodsID= ? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql,params.toArray());

	}

	public void updateStealthFinishedDisable(GoodsInfoPo po) {

		String sql = "update B_GoodsInfo set B_GI_Flag= ? "
				+ "where B_GI_GoodsID= ? ";

		List<String> params = new ArrayList<String>();
		params.add(po.getBgiflag());
		params.add(po.getBgigoodsid());

		getJdbcTemplate().update(sql, params.toArray());

	}
}
