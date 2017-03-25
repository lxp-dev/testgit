/**
 * 
 */
package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.components.dao.CustomerOptometryDao;
import com.pengsheng.eims.components.dao.SellLensDao;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class SellStealthLensDaoImpl extends BaseJdbcDaoSupport implements
		SellLensDao {


	public int getSellLensCount( GoodsInfoTempPo goodsInfoTempPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(B_GI_GoodsID) from b_goodsinfo where 1=1 ");
		if(!"".equals(goodsInfoTempPo.getSupplierid())){
			sb.append("and B_GI_SupplierID=? ");
			params.add(goodsInfoTempPo.getSupplierid());
		}
		if(!"".equals(goodsInfoTempPo.getBrandid())){
			sb.append("and B_GI_brandID=? ");
			params.add(goodsInfoTempPo.getBrandid());
		}
		if(!"".equals(goodsInfoTempPo.getLensgoodsid())){
			sb.append("and B_GI_goodsID=? ");
			params.add(goodsInfoTempPo.getLensgoodsid());
		}
		if(!"".equals(goodsInfoTempPo.getLensgoodsname())){
			sb.append("and B_GI_goodsname like ? ");
			params.add("%"+goodsInfoTempPo.getLensgoodsname()+"%");
		}
		if(!"".equals(goodsInfoTempPo.getIscustomize())){
			if("D".equals(goodsInfoTempPo.getIscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"".equals(goodsInfoTempPo.getMaterialtype())){
					sb.append("and B_GI_EyeGlassMaterialType=?" );
					params.add(goodsInfoTempPo.getMaterialtype());
				}
				if(!"".equals(goodsInfoTempPo.getSph())){
					sb.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(goodsInfoTempPo.getSph());
					params.add(goodsInfoTempPo.getSph());
				}
				if(!"".equals(goodsInfoTempPo.getCyl())){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) "); //zhuanhuan float
					params.add(goodsInfoTempPo.getCyl());
					params.add(goodsInfoTempPo.getCyl());
				}
				if(!"".equals(goodsInfoTempPo.getAdd())){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(goodsInfoTempPo.getAdd());
					params.add(goodsInfoTempPo.getAdd());
					
				}
				if(!"".equals(Utility.getName(goodsInfoTempPo.getIsmutiluminosity()))){
					sb.append("and B_GI_Ismutiluminosity=? ");
					params.add(goodsInfoTempPo.getIsmutiluminosity());
				}
				
			}else if("0".equals(goodsInfoTempPo.getIscustomize())){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(goodsInfoTempPo.getMaterialtype())){
					sb.append("and B_GI_EyeGlassMaterialType=? ");
					params.add(goodsInfoTempPo.getMaterialtype());
				}
				if(!"".equals(goodsInfoTempPo.getSph())){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(goodsInfoTempPo.getSph());
				}
				if(!"".equals(goodsInfoTempPo.getCyl())){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(goodsInfoTempPo.getCyl());
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}
			sb.append("and B_GI_GoodsCategoryID='4' and B_GI_Flag='1'");
		}
		
		
		return this.getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}


	public List<GoodsInfoPo> getSellLensList( GoodsInfoTempPo goodsInfoTempPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		int countPage=start+size;
		sb.append("set rowcount " + countPage + " \n");
		sb
				.append("select temp.bgigoodsid as bgigoodsid,temp.bgigoodsname as bgigoodsname,temp.bgisuppliername as bgisuppliername,");
		sb
				.append("temp.bgisph as bgisph,temp.bgicyl as bgicyl,temp.bgiaxis as bgiaxis,temp.bgicurvature1 as bgicurvature1,temp.bgidia as bgidia,temp.bgitaxrate as bgitaxrate,temp.bgigoodsbarcode as bgigoodsbarcode,");
		sb
				.append("temp.bgispec as bgispec,temp.bgicolor as bgicolor,temp.bgibrandname as bgibrandname,temp.bgiunitname as bgiunitname,temp.bgicostprice as bgicostprice,temp.bgiretailprice as bgiretailprice,temp.bginottaxrate as bginottaxrate,temp.bgiflag as bgiflag ");
		sb
				.append(" from(select ROW_NUMBER() Over(order by B_GoodsInfo.B_GI_GoodsID) as rowNum,");
		sb
				.append("B_GoodsInfo.B_GI_GoodsID as bgigoodsid,B_GoodsInfo.B_GI_ViewGoodsName as bgigoodsname,B_Supplier.B_SP_SupplierName as bgisuppliername,");
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
		if(!"".equals(goodsInfoTempPo.getSupplierid())){
			sb.append("and B_GI_SupplierID=? ");
			params.add(goodsInfoTempPo.getSupplierid());
		}
		if(!"".equals(goodsInfoTempPo.getBrandid())){
			sb.append("and B_GI_brandID=? ");
			params.add(goodsInfoTempPo.getBrandid());
		}
		if(!"".equals(goodsInfoTempPo.getLensgoodsid())){
			sb.append("and B_GI_goodsID=? ");
			params.add(goodsInfoTempPo.getLensgoodsid());
		}
		if(!"".equals(goodsInfoTempPo.getLensgoodsname())){
			sb.append("and B_GI_ViewGoodsName like ? ");
			params.add("%"+goodsInfoTempPo.getLensgoodsname()+"%");
		}
		if(!"".equals(goodsInfoTempPo.getIscustomize())){
			if("D".equals(goodsInfoTempPo.getIscustomize())){
				sb.append("and B_GI_iscustomize = 'D' ");
				if(!"".equals(goodsInfoTempPo.getMaterialtype())){
					sb.append("and B_GI_EyeGlassMaterialType=?" );
					params.add(goodsInfoTempPo.getMaterialtype());
				}
				if(!"".equals(goodsInfoTempPo.getSph())){
					sb.append("and cast(B_GI_SphUL as float)>=? and cast(B_GI_SphUP as float)<=? ");
					params.add(goodsInfoTempPo.getSph());
					params.add(goodsInfoTempPo.getSph());
				}
				if(!"".equals(goodsInfoTempPo.getCyl())){
					sb.append("and cast(B_GI_cylUL as float)>=cast(? as float) and cast(B_GI_cylUP as float)<=cast(? as float) "); //zhuanhuan float
					params.add(goodsInfoTempPo.getCyl());
					params.add(goodsInfoTempPo.getCyl());
				}
				if(!"".equals(goodsInfoTempPo.getAdd())){
					sb.append("and cast(B_GI_BelowPlusLuminosityUL as float)>=? and cast(B_GI_BelowPlusLuminosityUP as float)<=? ");
					params.add(goodsInfoTempPo.getAdd());
					params.add(goodsInfoTempPo.getAdd());
					
				}
				if(!"".equals(Utility.getName(goodsInfoTempPo.getIsmutiluminosity()))){
					sb.append("and B_GI_Ismutiluminosity=? ");
					params.add(goodsInfoTempPo.getIsmutiluminosity());
				}
				
			}else if("0".equals(goodsInfoTempPo.getIscustomize())){
				sb.append("and B_GI_iscustomize = '0' ");
				if(!"".equals(goodsInfoTempPo.getMaterialtype())){
					sb.append("and B_GI_EyeGlassMaterialType=? ");
					params.add(goodsInfoTempPo.getMaterialtype());
				}
				if(!"".equals(goodsInfoTempPo.getSph())){
					sb.append("and cast(B_GI_Sph as float)=cast(? as float) ");
					params.add(goodsInfoTempPo.getSph());
				}
				if(!"".equals(goodsInfoTempPo.getCyl())){
					sb.append("and cast(B_GI_cyl as float)=cast(? as float)  ");
					params.add(goodsInfoTempPo.getCyl());
				}
			}else{
				sb.append("and B_GI_SupplierID='zz' ");
			}
			sb.append("and B_GI_GoodsCategoryID='4' and B_GI_Flag='1'");
			sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
					+ countPage);
			sb.append(" set rowcount 0");
		}
		return this.queryForObjectList(sb.toString(), params.toArray(), GoodsInfoPo.class);
	}

	

}
