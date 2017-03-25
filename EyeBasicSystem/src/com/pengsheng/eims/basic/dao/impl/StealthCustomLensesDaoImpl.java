package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.StealthCustomLensesDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class StealthCustomLensesDaoImpl extends BaseJdbcDaoSupport implements
		StealthCustomLensesDao {

	public int getStealthCustomLensesCount(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("where 1=1 and B_GoodsInfo.B_GI_GoodsCategoryID='4' and B_GI_StealthCustomizeType = '2' ");

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

		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
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

	public List<GoodsInfoPo> getStealthCustomLensesList(GoodsInfoPo po,
			int start, int size) {

		StringBuffer sb = new StringBuffer();

		sb.append("select temp.bgiordercycle as bgiordercycle, temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgiwholegoodsisable as bgiwholegoodsisable,");
		sb.append("temp.bgicostprice,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bgiflag as bgiflag,");
		sb.append("temp.bgisphul,temp.bgisphup,temp.bgicylul,temp.bgicylup,temp.bgicurvature1ul,temp.bgicurvature1up,temp.bgicurvature2ul,temp.bgicurvature2up,");
		sb.append("temp.bgiaxisul,temp.bgiaxisup,temp.bgidiaul,temp.bgidiaup ");
		sb.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,B_GI_WholeGoodsIsable as bgiwholegoodsisable,");
		sb.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,");
		sb.append("B_GoodsInfo.B_GI_ordercycle as bgiordercycle,");
		
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
		sb.append("B_GoodsInfo.B_GI_SphUL as bgisphul,B_GoodsInfo.B_GI_SphUP as bgisphup,B_GoodsInfo.B_GI_CylUL as bgicylul,B_GoodsInfo.B_GI_CylUP as bgicylup,B_GoodsInfo.B_GI_StealthType as bgistealthtype,");
		sb.append("B_GoodsInfo.B_GI_ThrowingCycle as bgithrowingcycle,B_GoodsInfo.B_GI_Curvature1UL as bgicurvature1ul,B_GoodsInfo.B_GI_Curvature1UP as bgicurvature1up,B_GoodsInfo.B_GI_Curvature2UL as bgicurvature2ul,");
		sb.append("B_GoodsInfo.B_GI_Curvature2UP as bgicurvature2up,B_GoodsInfo.B_GI_AxisUL as bgiaxisul,B_GoodsInfo.B_GI_AxisUP as bgiaxisup,B_GoodsInfo.B_GI_DiaUL as bgidiaul,B_GoodsInfo.B_GI_DiaUP as bgidiaup ");
		sb.append(" from B_GoodsInfo ");
		sb.append("where 1=1 and B_GoodsInfo.B_GI_GoodsCategoryID='4' and B_GI_StealthCustomizeType = '2' ");

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
		
		if (!"".equals(Utility.getName(po.getBgigoodsid()))) {
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like'%' + ? + '%'");
			params.add(po.getBgigoodsid());
		}
		if (!"".equals(Utility.getName(po.getBgigoodsname()))) {
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like'%' + ? + '%'");
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
				+ (start + size));

		return queryForObjectList(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}

	public void insertStealthCustomLenses(GoodsInfoPo po) {
		String sql = "insert into B_GoodsInfo(B_GI_GoodsID,B_GI_GoodsBarCode,B_GI_GoodsName,B_GI_GoodsCategoryID,B_GI_SupplierID,"
				+ "B_GI_BrandID,B_GI_Spec,B_GI_StealthType,B_GI_UnitId,B_GI_CostPrice,B_GI_TaxRate,B_GI_NotTaxRate,B_GI_RetailPrice,B_GI_SphUL,B_GI_SphUP,"
				+ "B_GI_CylUL,B_GI_CylUP,B_GI_Curvature1UL,B_GI_Curvature1UP,B_GI_Curvature2UL,B_GI_Curvature2UP,"
				+ "B_GI_AxisUL,B_GI_AxisUP,B_GI_DiaUL,B_GI_DiaUP,B_GI_isCustomize,B_GI_Flag,B_GI_Color,B_GI_ReturnMax,B_GI_orderCycle,B_GI_UnionSphCyl,B_GI_ReturnMin,B_GI_WholesalePrice,B_GI_UseType,B_GI_StealthClass,B_GI_Numberofdays,B_GI_AverageNotTaxRate ";
		
		
		String sql1 = "values('"
				+ po.getBgigoodsid()
				+ "',"
				+ "'"
				+ po.getBgigoodsbarcode()
				+ "','"
				+ po.getBgigoodsname()
				+ "','"
				+ po.getBgigoodscategoryid()
				+ "','"
				+ po.getBgisupplierid()
				+ "',"
				+ "'"
				+ po.getBgibrandid()
				+ "','"
				+ po.getBgispec()
				+ "','"
				+ po.getBgistealthtype()
				+ "','"
				+ po.getBgiunitid()
				+ "',"
				+ "'"
				+ po.getBgicostprice()
				+ "','"
				+ po.getBgitaxrate()
				+ "','"
				+ po.getBginottaxrate()
				+ "',"
				+ "'"
				+ po.getBgiretailprice()
				+ "','"
				+ po.getBgisphul()
				+ "','"
				+ po.getBgisphup()
				+ "','"
				+ po.getBgicylul()
				+ "','"
				+ po.getBgicylup()
				+ "',"
				+ "'"
				+ po.getBgicurvature1ul()
				+ "','"
				+ po.getBgicurvature1up()
				+ "',"
				+ "'"
				+ po.getBgicurvature2ul()
				+ "','"
				+ po.getBgicurvature2up()
				+ "','"
				+ po.getBgiaxisul()
				+ "','"
				+ po.getBgiaxisup()
				+ "',"
				+ "'"
				+ po.getBgidiaul()
				+ "','"
				+ po.getBgidiaup()
				+ "','"
				+ po.getBgiiscustomize() + "'," + "'1','"+po.getBgicolor()
				+ "','" 
				+ po.getBgireturnmax()
				+ "','"
				+ po.getBgiordercycle()
				+ "','"
				+ po.getBgiunionsphcyl()
				+ "','"				
				+ po.getBgireturnmin()
				+ "','"
				+ po.getBgiwholesaleprice()
				+ "','"
				+ po.getBgiusetype()
				+ "','"
				+ po.getBgistealthclass()
				+ "','"
				+ po.getBginumberofdays()
				+ "','"
				+ (Utility.getName(po.getBgiaveragenotnaxrate()).equals("") ? "0.00" : Utility.getName(po.getBgiaveragenotnaxrate()))
				+"'";
		List<String> params = new ArrayList<String>();
		if (!"".equals(Utility.getName(po.getBgiretailpricea()))) {
			sql = sql+",B_GI_RetailPriceA ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpricea()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceb()))) {
			sql = sql+",B_GI_RetailPriceB ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpriceb()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricec()))) {
			sql = sql+",B_GI_RetailPriceC ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpricec()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriced()))) {
			sql = sql+",B_GI_RetailPriceD ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpriced()));
		}
		if (!"".equals(Utility.getName(po.getBgichinesecolor()))) {
			sql = sql+",B_GI_ChineseColor ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgichinesecolor()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricee()))) {
			sql = sql+",B_GI_RetailPricee ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpricee()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricef()))) {
			sql = sql+",B_GI_RetailPriceF ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpricef()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceg()))) {
			sql = sql+",B_GI_RetailPriceG ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpriceg()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceh()))) {
			sql = sql+",B_GI_RetailPriceH ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpriceh()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricei()))) {
			sql = sql+",B_GI_RetailPriceI ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiretailpricei()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
			sql = sql+",B_GI_SupplierSpec ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgisupplierspec()));
		}
		if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
			sql = sql+",B_GI_ViewGoodsName ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgiviewgoodsname()));
		}
		
		if (!"".equals(Utility.getName(po.getBgicontacttypey()))) {
			sql = sql+",B_GI_ContactTypeY ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgicontacttypey()));
		}
		
		if (!"".equals(Utility.getName(po.getBgidropmin()))) {
			sql = sql+",B_GI_DropMin ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgidropmin()));
		}
		
		if (!"".equals(Utility.getName(po.getBgidropmax()))) {
			sql = sql+",B_GI_DropMax ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgidropmax()));
		}
		
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			sql = sql+",B_GI_PayFeeID ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		
		if (!"".equals(Utility.getName(po.getBgisphspan()))) {
			sql = sql+",B_GI_SphSpan ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgisphspan()));
		}
		
		if (!"".equals(Utility.getName(po.getBgicylspan()))) {
			sql = sql+",B_GI_CylSpan ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgicylspan()));
		}
		
		sql = sql+",B_GI_WholeGoodsIsable,B_GI_DefaultDiscountValue,B_GI_StealthCustomizeType)";
		sql1 = sql1+",'1',?,'2')";
		params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
		
		sql = sql + sql1;
		getJdbcTemplate().update(sql, params.toArray());

	}

	public void updateStealthCustomLenses(GoodsInfoPo po) {

		String sql = "update B_GoodsInfo set B_GI_GoodsName='"
				+ po.getBgigoodsname() + "',B_GI_UnitId='" + po.getBgiunitid() +"',B_GI_ReturnMax='" + po.getBgireturnmax()+"',B_GI_ReturnMin='" + po.getBgireturnmin()
				+ "',B_GI_TaxRate='" + po.getBgitaxrate()
				+ "',B_GI_NotTaxRate='" + po.getBginottaxrate()
				+ "',B_GI_SphUL='" + po.getBgisphul() + "',B_GI_SphUP='"
				+ po.getBgisphup() + "',B_GI_CylUL='" + po.getBgicylul()
				+ "',B_GI_CylUP='" + po.getBgicylup() + "',"
				+ "B_GI_UseType='" + po.getBgiusetype()
				+ "',B_GI_StealthClass='" + po.getBgistealthclass()
				+ "',B_GI_Numberofdays='" + po.getBginumberofdays()
				+ "',B_GI_orderCycle='"+po.getBgiordercycle()
				+ "',B_GI_Curvature1UL='" + po.getBgicurvature1ul()
				+ "',B_GI_UnionSphCyl='" + po.getBgiunionsphcyl() 
				+ "',B_GI_Curvature1UP='" + po.getBgicurvature1up()
				+ "',B_GI_Curvature2UL='" + po.getBgicurvature2ul()
				+ "',B_GI_ContactTypeY='" + po.getBgicontacttypey()
				+ "',B_GI_DropMin='" + po.getBgidropmin()
				+ "',B_GI_DropMax='" + po.getBgidropmax()
				+ "',B_GI_Curvature2UP='" + po.getBgicurvature2up()
				+ "',B_GI_PayFeeID='" + po.getBgipayfeeid();
				
				if (!"".equals(Utility.getName(po.getBgiwholesaleprice()))) {
					sql = sql + "',B_GI_WholesalePrice='"+po.getBgiwholesaleprice();
				}				
				
				sql = sql + "',B_GI_AxisUL='" + po.getBgiaxisul() + "',B_GI_AxisUP='"
				+ po.getBgiaxisup() + "'," + "B_GI_DiaUL='" + po.getBgidiaul()
				+ "',B_GI_DiaUP='" + po.getBgidiaup()+"'";
				
				List<String> params = new ArrayList<String>();
				
				if (!"".equals(Utility.getName(po.getBgiretailprice()))) {
					sql = sql+",B_GI_RetailPrice=? ";
					params.add(Utility.getName(po.getBgiretailprice()));
				}

				if (!"".equals(Utility.getName(po.getBgiretailpricea()))) {
					sql = sql+",B_GI_RetailPriceA=? ";
					params.add(Utility.getName(po.getBgiretailpricea()));
				}
				if (!"".equals(Utility.getName(po.getBgichinesecolor()))) {
					sql = sql+",B_GI_ChineseColor=? ";
					params.add(Utility.getName(po.getBgichinesecolor()));
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
				if (!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))) {
					sql = sql+",B_GI_DefaultDiscountValue=? ";
					params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
				}
				if (!"".equals(Utility.getName(po.getBgicostprice()))) {
					sql = sql+",B_GI_CostPrice=? ";
					params.add(Utility.getName(po.getBgicostprice()));
				}	
				if (!"".equals(Utility.getName(po.getBgisphspan()))) {
					sql = sql+",B_GI_SphSpan=? ";
					params.add(Utility.getName(po.getBgisphspan()));
				}
				if (!"".equals(Utility.getName(po.getBgicylspan()))) {
					sql = sql+",B_GI_CylSpan=? ";
					params.add(Utility.getName(po.getBgicylspan()));
				}
				
				sql = sql+ " where B_GI_GoodsID='" + po.getBgigoodsid() + "'";

		getJdbcTemplate().update(sql, params.toArray());

	}

	public GoodsInfoPo getStealthCustomLenses(GoodsInfoPo po) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,B_GoodsInfo.B_GI_ordercycle as bgiordercycle,B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_GoodsName as bgigoodsname,B_GoodsInfo.B_GI_SupplierID as bgisupplierid,B_Supplier.B_SP_SupplierName as bgisuppliername,");
		sb.append("B_GoodsInfo.B_GI_BrandID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,B_GI_ReturnMax as bgireturnmax,B_GI_ReturnMin as bgireturnmin, ");
		sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_UnitId as bgiunitid,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,");
		sb.append("B_GoodsInfo.B_GI_SphUL as bgisphul,B_GoodsInfo.B_GI_SphUP as bgisphup,B_GoodsInfo.B_GI_CylUL as bgicylul,B_GoodsInfo.B_GI_CylUP as bgicylup,B_GoodsInfo.B_GI_StealthType as bgistealthtype,");
		sb.append("B_GoodsInfo.B_GI_ThrowingCycle as bgithrowingcycle,B_GoodsInfo.B_GI_Curvature1UL as bgicurvature1ul,B_GoodsInfo.B_GI_Curvature1UP as bgicurvature1up,B_GoodsInfo.B_GI_CylUP as bgicylup,B_GoodsInfo.B_GI_Curvature2UL as bgicurvature2ul,");
		sb.append("B_GoodsInfo.B_GI_Curvature2UP as bgicurvature2up,B_GoodsInfo.B_GI_AxisUL as bgiaxisul,B_GoodsInfo.B_GI_AxisUP as bgiaxisup,B_GoodsInfo.B_GI_DiaUL as bgidiaul,B_GoodsInfo.B_GI_DiaUP as bgidiaup,");
		sb.append("B_GoodsInfo.B_GI_isCustomize as bgiiscustomize,B_GI_Color as bgicolor,B_GI_AverageNotTaxRate as bgiaveragenotnaxrate,B_GI_WholesalePrice as bgiwholesaleprice ,B_GI_UseType as bgiusetype,B_GI_StealthClass as bgistealthclass,B_GI_Numberofdays as bginumberofdays, ");
		sb.append("B_GI_ChineseColor    				as  bgichinesecolor,");
		sb.append("B_C_ColorName    					as  bgichinesecolorname, ");
		sb.append("B_GI_UnionSphCyl    					as  bgiunionsphcyl, ");		
		sb.append("isnull(B_GI_RetailPriceA ,0.00)    	as  bgiretailpricea,");
		sb.append("isnull(B_GI_RetailPriceB ,0.00)   	as  bgiretailpriceb,");
		sb.append("isnull(B_GI_RetailPriceC ,0.00)    	as  bgiretailpricec,");
		sb.append("isnull(B_GI_RetailPriceD ,0.00)   	as  bgiretailpriced,");
		sb.append("isnull(B_GI_RetailPriceE ,0.00)   	as  bgiretailpricee,");
		sb.append("isnull(B_GI_RetailPriceF ,0.00)  	as  bgiretailpricef,");
		sb.append("isnull(B_GI_RetailPriceG ,0.00)   	as  bgiretailpriceg,");
		sb.append("isnull(B_GI_RetailPriceH ,0.00)   	as  bgiretailpriceh,");
		sb.append("isnull(B_GI_RetailPriceI ,0.00)   	as  bgiretailpricei, ");
		sb.append("B_GI_SupplierSpec    				as  bgisupplierspec, ");
		sb.append("B_GI_DefaultDiscountValue    		as  bgidefaultdiscountvalue, ");
		sb.append("B_GI_DropMin    						as  bgidropmin, ");
		sb.append("B_GI_DropMax    						as  bgidropmax, ");
		sb.append("B_GI_PayFeeID    					as  bgipayfeeid, ");
		sb.append("B_GI_SphSpan    						as  bgisphspan, ");
		sb.append("B_GI_CylSpan    						as  bgicylspan, ");
		sb.append("B_GL_Name					  		as  bgidefaultdiscountvaluename,isnull(B_GI_ContactTypeY,'') as bgicontacttypey ");
		sb.append(" from B_GoodsInfo");
		sb.append(" inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID");
		sb.append(" inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id");
		sb.append(" left join B_Color on B_GoodsInfo.B_GI_ChineseColor = B_C_id ");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID");
		sb.append(" where B_GoodsInfo.B_GI_GoodsID='" + po.getBgigoodsid()
				+ "'");

		return (GoodsInfoPo) queryForObject(sb.toString(), null,
				GoodsInfoPo.class);
	}

	public void deleteStealthCustomLenses(GoodsInfoPo po) {

		String sql = "delete from B_GoodsInfo where B_GI_GoodsID='"
				+ po.getBgigoodsid() + "'";

		getJdbcTemplate().update(sql);

	}

	public void updateStealthCustomLensesDisable(GoodsInfoPo po) {

		String sql = "update B_GoodsInfo set B_GI_Flag='" + po.getBgiflag()
				+ "' where B_GI_GoodsID='" + po.getBgigoodsid() + "'";

		getJdbcTemplate().update(sql);
	}

	public List<UnitPo> getUnitList() {

		String sql = "select B_UT_id as butid,B_UT_unitName as butunitname from B_Unit";

		return queryForObjectList(sql, null, UnitPo.class);
	}
}
