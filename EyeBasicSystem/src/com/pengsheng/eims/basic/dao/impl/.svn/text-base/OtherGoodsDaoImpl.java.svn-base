package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ParamSupport;

import com.pengsheng.eims.basic.dao.OtherGoodsDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class OtherGoodsDaoImpl extends BaseJdbcDaoSupport  implements OtherGoodsDao {

	public int getOtherGoodsCount(GoodsInfoPo po) {
		
		StringBuffer sb=new StringBuffer();	
		
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(B_GoodsInfo.B_GI_GoodsID) from B_GoodsInfo ");
		sb.append("inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1 and B_GoodsInfo.B_GI_GoodsCategoryID='7' ");
		
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
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%' ");
			params.add(po.getBgigoodsid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode= ? ");
			params.add(po.getBgigoodsbarcode());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GoodsInfo.B_GI_BrandID= ? ");
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
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			sb.append(" and B_GI_OtherGoodsBigClass=?");
			params.add(po.getBgiothergoodsbigclass());
		}
		
//		if(!"".equals(Utility.getName(po.getBgivarietyid()))){
//			sb.append(" and B_GoodsInfo.B_GI_VarietyID='"+po.getBgivarietyid()+"'");
//		}
		
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
	public List<GoodsInfoPo> getOtherGoodsList(GoodsInfoPo po, int start,
			int size) {
		
		StringBuffer sb=new StringBuffer();	
		
		List<String> params = new ArrayList<String>();
		
		sb.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,temp.bgiwholegoodsisable as bgiwholegoodsisable,");
		sb.append("temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bgiflag as bgiflag ");
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
		sb.append("B_GoodsInfo.B_GI_CostPrice as bgicostprice,B_GoodsInfo.B_GI_Flag as bgiflag ");
		sb.append(" from B_GoodsInfo inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID ");
		sb.append("inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append("inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id where 1=1 and B_GoodsInfo.B_GI_GoodsCategoryID='7'");
		
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
		
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" and B_GoodsInfo.B_GI_GoodsID like '%' + ? + '%' ");
			params.add(po.getBgigoodsid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsname()))){
			sb.append(" and B_GoodsInfo.B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(po.getBgigoodsname());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsbarcode()))){
			sb.append(" and B_GoodsInfo.B_GI_GoodsBarCode= ? ");
			params.add(po.getBgigoodsbarcode());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" and B_GoodsInfo.B_GI_BrandID= ? ");
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
		
		if (!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))) {
			sb.append(" and B_GI_OtherGoodsBigClass=?");
			params.add(po.getBgiothergoodsbigclass());
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
		
		sb.append("   ) temp where rowNum > "+start+" and rowNum <= "+ (start + size));
		
		return queryForObjectList(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	public void insertOtherGoods(GoodsInfoPo po) {
		
		List<String> params = new ArrayList<String>();
		
		String sql="insert into B_GoodsInfo(B_GI_GoodsID,B_GI_GoodsBarCode,B_GI_GoodsName,B_GI_GoodsCategoryID,B_GI_SupplierID," +
				"B_GI_BrandID,B_GI_UnitId,B_GI_Spec,B_GI_OtherGoodsBigClass,B_GI_OtherGoodsSmallClass,B_GI_CostPrice,B_GI_TaxRate," +
				"B_GI_NotTaxRate,B_GI_RetailPrice,B_GI_Flag,B_GI_Color,B_GI_WholesalePrice,B_GI_AverageNotTaxRate";
		String sql1="values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'1',?,?,?";
		
		params.add(po.getBgigoodsid());
		params.add(po.getBgigoodsbarcode());
		params.add(po.getBgigoodsname());
		params.add(po.getBgigoodscategoryid());
		params.add(po.getBgisupplierid());
		params.add(po.getBgibrandid());
		params.add(po.getBgiunitid());
		params.add(po.getBgispec());
		params.add(po.getBgiothergoodsbigclass());
		params.add(po.getBgiothergoodssmallclass());
		params.add(po.getBgicostprice());
		params.add(po.getBgitaxrate());
		params.add(po.getBginottaxrate());
		params.add(po.getBgiretailprice());
		params.add(po.getBgicolor());
		params.add(po.getBgiwholesaleprice());
		params.add(Utility.getName(po.getBgiaveragenotnaxrate()).equals("") ? "0.00" : Utility.getName(po.getBgiaveragenotnaxrate()));
		
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
		if (!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))) {
			sql = sql+",B_GI_DefaultDiscountValue ";
			sql1 = sql1 + ",?";
			params.add(Utility.getName(po.getBgidefaultdiscountvalue()));
		}
		if (!"".equals(Utility.getName(po.getBgibarcodeflag()))) {
			sql = sql+",B_GI_BarCodeFlag ";
			sql1 = sql1 + ",?";			
			params.add(Utility.getName(po.getBgibarcodeflag()));
		}
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			sql = sql+",B_GI_PayFeeID ";
			sql1 = sql1 + ",?";			
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		
		sql = sql+",B_GI_WholeGoodsIsable)";
		sql1 = sql1+",'1')";
		
		sql = sql + sql1;
		
		getJdbcTemplate().update(sql, params.toArray());
	}
	public void updateOtherGoods(GoodsInfoPo po) {
		
		String sql="update B_GoodsInfo set B_GI_GoodsName= ?,B_GI_UnitId= ?," +
				"B_GI_TaxRate= ?,B_GI_NotTaxRate= ?,B_GI_WholesalePrice= ?,B_GI_OtherGoodsBigClass=?,B_GI_OtherGoodsSmallClass=? ";
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsname());
		params.add(po.getBgiunitid());
		params.add(po.getBgitaxrate());
		params.add(po.getBginottaxrate());
		params.add(po.getBgiwholesaleprice());
		params.add(po.getBgiothergoodsbigclass());
		params.add(po.getBgiothergoodssmallclass());
		
		if (!"".equals(Utility.getName(po.getBgiframematerialtype()))){
			sql=sql+" ,B_GI_SunGglassesFun= ? ";
			params.add(Utility.getName(po.getBgiframematerialtype()));
		}
		
		if (!"".equals(Utility.getName(po.getBgiretailprice()))) {
			sql=sql+",B_GI_RetailPrice=? ";
			params.add(Utility.getName(po.getBgiretailprice()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricea()))) {
			sql=sql+",B_GI_RetailPriceA=? ";
			params.add(Utility.getName(po.getBgiretailpricea()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceb()))) {
			sql=sql+",B_GI_RetailPriceB=? ";
			params.add(Utility.getName(po.getBgiretailpriceb()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricec()))) {
			sql=sql+",B_GI_RetailPriceC=? ";
			params.add(Utility.getName(po.getBgiretailpricec()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriced()))) {
			sql=sql+",B_GI_RetailPriceD=? ";
			params.add(Utility.getName(po.getBgiretailpriced()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricee()))) {
			sql=sql+",B_GI_RetailPriceE=? ";
			params.add(Utility.getName(po.getBgiretailpricee()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricef()))) {
			sql=sql+",B_GI_RetailPriceF=? ";
			params.add(Utility.getName(po.getBgiretailpricef()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceg()))) {
			sql=sql+",B_GI_RetailPriceG=? ";
			params.add(Utility.getName(po.getBgiretailpriceg()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpriceh()))) {
			sql=sql+",B_GI_RetailPriceH=? ";
			params.add(Utility.getName(po.getBgiretailpriceh()));
		}
		if (!"".equals(Utility.getName(po.getBgiretailpricei()))) {
			sql=sql+",B_GI_RetailPriceI=? ";
			params.add(Utility.getName(po.getBgiretailpricei()));
		}
		if (!"".equals(Utility.getName(po.getBgisupplierspec()))) {
			sql=sql+",B_GI_SupplierSpec=? ";
			params.add(Utility.getName(po.getBgisupplierspec()));
		}
		if (!"".equals(Utility.getName(po.getBgiviewgoodsname()))) {
			sql=sql+",B_GI_ViewGoodsName=? ";
			params.add(Utility.getName(po.getBgiviewgoodsname()));
		}
		if (!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))) {
			sql=sql+",B_GI_DefaultDiscountValue=? ";
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
		if (!"".equals(Utility.getName(po.getBgipayfeeid()))) {
			sql = sql+",B_GI_PayFeeID=? ";
			params.add(Utility.getName(po.getBgipayfeeid()));
		}
		sql=sql+" where B_GI_GoodsID= ? ";
		params.add(po.getBgigoodsid());
		
		getJdbcTemplate().update(sql,params.toArray());
		
	}
	public GoodsInfoPo getOtherGoods(GoodsInfoPo po) {
		
		StringBuffer sb=new StringBuffer();	
		
		sb.append("select top 1  B_GoodsInfo.B_GI_GoodsBarCode as bgigoodsbarcode,B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_GoodsName as bgigoodsname,B_GoodsInfo.B_GI_SupplierID as bgisupplierid,B_Supplier.B_SP_SupplierName as bgisuppliername,");
		sb.append("B_GoodsInfo.B_GI_BrandID as bgibrandid,B_Brand.B_BD_brandName as bgibrandname,");
		sb.append("B_GoodsInfo.B_GI_Spec as bgispec,B_GoodsInfo.B_GI_UnitId as bgiunitid,B_Unit.B_UT_unitName as bgiunitname,B_GoodsInfo.B_GI_CostPrice as bgicostprice,");
		sb.append("B_GoodsInfo.B_GI_TaxRate as bgitaxrate,B_GoodsInfo.B_GI_RetailPrice as bgiretailprice,B_GoodsInfo.B_GI_OtherGoodsBigClass as bgiothergoodsbigclass,B_GoodsInfo.B_GI_OtherGoodsSmallClass as bgiothergoodssmallclass,B_GI_Color as bgicolor,B_GI_AverageNotTaxRate as bgiaveragenotnaxrate,B_GI_WholesalePrice as bgiwholesaleprice, ");
		
		sb.append("B_GI_RetailPriceA    			as  bgiretailpricea,");
		sb.append("B_GI_RetailPriceB    			as  bgiretailpriceb,");
		sb.append("B_GI_RetailPriceC    			as  bgiretailpricec,");
		sb.append("B_GI_RetailPriceD    			as  bgiretailpriced,");
		sb.append("B_GI_RetailPriceE    			as  bgiretailpricee,");
		sb.append("B_GI_RetailPriceF    			as  bgiretailpricef,");
		sb.append("B_GI_RetailPriceG    			as  bgiretailpriceg,");
		sb.append("B_GI_RetailPriceH    			as  bgiretailpriceh,");
		sb.append("B_GI_RetailPriceI    			as  bgiretailpricei,");
		sb.append("b_gi_supplierspec    			as  bgisupplierspec, ");
		sb.append("B_GI_DefaultDiscountValue   		as  bgidefaultdiscountvalue, ");
		sb.append("B_GI_BarCodeFlag   				as  bgibarcodeflag, ");
		sb.append("B_GI_PayFeeID   					as  bgipayfeeid, ");	
		sb.append("B_GL_Name					  	as  bgidefaultdiscountvaluename ");
		
		sb.append(" from B_GoodsInfo");
		sb.append(" inner join B_Supplier on B_GoodsInfo.B_GI_SupplierID=B_Supplier.B_SP_ID");
		sb.append(" inner join B_Brand on B_GoodsInfo.B_GI_BrandID=B_Brand.B_BD_ID and  B_GoodsInfo.B_GI_SupplierID=B_Brand.B_BD_SupplierID ");
		sb.append(" inner join B_Unit on B_GoodsInfo.B_GI_UnitId=B_Unit.B_UT_id");
		sb.append(" left join B_GoodsLevel on B_GI_DefaultDiscountValue = B_GL_UUID");
		sb.append(" where B_GoodsInfo.B_GI_GoodsID= ? ");	
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());
		
		return (GoodsInfoPo)queryForObject(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}
	public void deleteOtherGoods(GoodsInfoPo po) {
		
		String sql="delete from B_GoodsInfo where B_GI_GoodsID= ? ";
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());
		
		getJdbcTemplate().update(sql,params.toArray());
		
	}
	public void updateOtherGoodsDisable(GoodsInfoPo po) {
		
		String sql="update B_GoodsInfo set B_GI_Flag='"+po.getBgiflag()+"' where B_GI_GoodsID= ? ";
		
		List<String> params = new ArrayList<String>();
		params.add(po.getBgigoodsid());
		
		getJdbcTemplate().update(sql,params.toArray());
	}
	public List<UnitPo> getUnitList() {
		
		String sql="select B_UT_id as butid,B_UT_unitName as butunitname from B_Unit";
		
		return queryForObjectList(sql, null, UnitPo.class);
	}
	
	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po) {
		List<String> params = new ArrayList<String>();
		
		StringBuffer  varname1 = new StringBuffer();
		varname1.append("SELECT sum(num) ");
		varname1.append("FROM   (SELECT count(C_SH_SB_GoodsId) AS num ");
		varname1.append("        FROM   C_SH_StorageBeginning ");
		varname1.append("        WHERE  C_SH_SB_GoodsId = ? ");
		varname1.append("        UNION ALL ");
		varname1.append("        SELECT count(C_SH_SC_GoodsId) AS num ");
		varname1.append("        FROM   C_SH_StorageChange ");
		varname1.append("        WHERE  C_SH_SC_GoodsId = ?) table1 ");
		
		params.add(po.getBgigoodsid());
		params.add(po.getBgigoodsid());
		
		return getJdbcTemplate().queryForInt(varname1.toString(), params.toArray());
	}
}
