package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.UpdateGoodsAttributeARDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * dao 实现类
 */
public class UpdateGoodsAttributeARDaoImpl extends BaseJdbcDaoSupport implements
		UpdateGoodsAttributeARDao {
	
	public void updateGoodsAttribute(GoodsInfoPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE B_GoodsInfo ");
		sb.append("SET     ");
		if(!"".equals(Utility.getName(po.getBgiunitid()))){
			sb.append("    B_GI_UnitId = ?, ");
			params.add(po.getBgiunitid());
		}
		if(!"".equals(Utility.getName(po.getBgidefaultdiscountvalue()))){
			sb.append("    B_GI_DefaultDiscountValue = ?, ");
			params.add(po.getBgidefaultdiscountvalue());
		}
		if(!"".equals(Utility.getName(po.getBgibarcodeflag()))){
			sb.append("    B_GI_BarCodeFlag = ?, ");
			params.add(po.getBgibarcodeflag());
		}		
		if(!"".equals(Utility.getName(po.getBgitaxrate()))){
			sb.append("    B_GI_TaxRate = ?, ");
			params.add(po.getBgitaxrate());
		}
		if(!"".equals(Utility.getName(po.getBgicontacttype()))){
			sb.append("    B_GI_ContactType = ?, ");
			params.add(po.getBgicontacttype());
		}
		if("1".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgiframeprocesscrafttype()))){
				sb.append("    B_GI_frameProcessCraftType = ?, ");
				params.add(po.getBgiframeprocesscrafttype());
			}
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))){
				sb.append("    B_GI_FrameMaterialType = ?, ");
				params.add(po.getBgiframematerialtype());
			}
			if(!"".equals(Utility.getName(po.getBgiframesize()))){
				sb.append("    B_GI_FrameSize = ?, ");
				params.add(po.getBgiframesize());
			}
			if(!"".equals(Utility.getName(po.getBgiframestyle()))){
				sb.append("    B_GI_FrameStyle = ?, ");
				params.add(po.getBgiframestyle());
			}
		}
		if("2".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgirefractive()))){
				sb.append("    B_GI_Refractive = ?, ");
				params.add(po.getBgirefractive());
			}
		}
		if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
				sb.append("    B_GI_EyeGlassMaterialType = ?, ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			if(!"".equals(Utility.getName(po.getBgirefractive()))){
				sb.append("    B_GI_Refractive = ?, ");
				params.add(po.getBgirefractive());
			}
			if(!"".equals(Utility.getName(po.getBgiismutiluminosity()))){
				sb.append("    B_GI_isMutiLuminosity = ?, ");
				params.add(po.getBgiismutiluminosity());
			}
			if(!"".equals(Utility.getName(po.getBgigradualclass()))){
				sb.append("    B_GI_GradualClass = ?, ");
				params.add(po.getBgigradualclass());
			}
			if(!"".equals(Utility.getName(po.getBgifunctionclass()))){
				sb.append("    B_GI_FunctionClass = ?, ");
				params.add(po.getBgifunctionclass());
			}
		}
		if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgicurvature1()))){
				sb.append("    B_GI_Curvature1 = ?, ");
				params.add(po.getBgicurvature1());
			}
			if(!"".equals(Utility.getName(po.getBgidia()))){
				sb.append("    B_GI_Dia = ?, ");
				params.add(po.getBgidia());
			}
			if(!"".equals(Utility.getName(po.getBgiusetype()))){
				sb.append("    B_GI_UseType = ?, ");
				params.add(po.getBgiusetype());
			}
			if(!"".equals(Utility.getName(po.getBgireturnmax()))){
				sb.append("    B_GI_ReturnMax = ?, ");
				params.add(po.getBgireturnmax());
			}
			if(!"".equals(Utility.getName(po.getBgireturnmin()))){
				sb.append("    B_GI_ReturnMin = ?, ");
				params.add(po.getBgireturnmin());
			}
			if(!"".equals(Utility.getName(po.getBgistealthclass()))){
				sb.append("    B_GI_StealthClass = ?, ");
				params.add(po.getBgistealthclass());
			}
			
			if(!"".equals(Utility.getName(po.getBginumberofdays()))){
				sb.append("    B_GI_Numberofdays = ?, ");
				params.add(po.getBginumberofdays());
			}
		}
		if("5".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgireturnmax()))){
				sb.append("    B_GI_ReturnMax = ?, ");
				params.add(po.getBgireturnmax());
			}
			if(!"".equals(Utility.getName(po.getBgireturnmin()))){
				sb.append("    B_GI_ReturnMin = ?, ");
				params.add(po.getBgireturnmin());
			}
			if(!"".equals(Utility.getName(po.getBgicapacity()))){
				sb.append("    B_GI_Capacity = ?, ");
				params.add(po.getBgicapacity());
			}
			if(!"".equals(Utility.getName(po.getBgicapacityentry()))){
				sb.append("    B_GI_CapacityEntry = ?, ");
				params.add(po.getBgicapacityentry());
			}
		}
		if("6".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgiframematerialtype()))){
				sb.append("    B_GI_SunGglassesFun = ?, ");
				params.add(po.getBgiframematerialtype());
			}
			if(!"".equals(Utility.getName(po.getBgiframesize()))){
				sb.append("    B_GI_FrameSize = ?, ");
				params.add(po.getBgiframesize());
			}
			if(!"".equals(Utility.getName(po.getBgiframestyle()))){
				sb.append("    B_GI_FrameStyle = ?, ");
				params.add(po.getBgiframestyle());
			}
		}
		if("7".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgiothergoodsbigclass()))){
				sb.append("    B_GI_OtherGoodsBigClass = ?, ");
				params.add(po.getBgiothergoodsbigclass());
			}
			if(!"".equals(Utility.getName(po.getBgiothergoodssmallclass()))){
				sb.append("    B_GI_OtherGoodsSmallClass = ?, ");
				params.add(po.getBgiothergoodssmallclass());
			}
		}
		if("8".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgiframesize()))){
				sb.append("    B_GI_FrameSize = ?, ");
				params.add(po.getBgiframesize());
			}
			
			if(!"".equals(Utility.getName(po.getBgiframestyle()))){
				sb.append("    B_GI_FrameStyle = ?, ");
				params.add(po.getBgiframestyle());
			}
		}
		if("3D".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgieyeglassmaterialtype()))){
				sb.append("    B_GI_EyeGlassMaterialType = ?, ");
				params.add(po.getBgieyeglassmaterialtype());
			}
			if(!"".equals(Utility.getName(po.getBgirefractive()))){
				sb.append("    B_GI_Refractive = ?, ");
				params.add(po.getBgirefractive());
			}
			if(!"".equals(Utility.getName(po.getBgiismutiluminosity()))){
				sb.append("    B_GI_isMutiLuminosity = ?, ");
				params.add(po.getBgiismutiluminosity());
			}
			if(!"".equals(Utility.getName(po.getBgigradualclass()))){
				sb.append("    B_GI_GradualClass = ?, ");
				params.add(po.getBgigradualclass());
			}
			if(!"".equals(Utility.getName(po.getBgifunctionclass()))){
				sb.append("    B_GI_FunctionClass = ?, ");
				params.add(po.getBgifunctionclass());
			}
			if(!"".equals(Utility.getName(po.getBgiordercycle()))){
				sb.append("    B_GI_orderCycle = ?, ");
				params.add(po.getBgiordercycle());
			}
		}
		if("4D".equals(Utility.getName(po.getBgigoodscategoryid())) || "4R".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if(!"".equals(Utility.getName(po.getBgiusetype()))){
				sb.append("    B_GI_UseType = ?, ");
				params.add(po.getBgiusetype());
			}
			if(!"".equals(Utility.getName(po.getBgireturnmax()))){
				sb.append("    B_GI_ReturnMax = ?, ");
				params.add(po.getBgireturnmax());
			}
			if(!"".equals(Utility.getName(po.getBgireturnmin()))){
				sb.append("    B_GI_ReturnMin = ?, ");
				params.add(po.getBgireturnmin());
			}
			if(!"".equals(Utility.getName(po.getBgistealthclass()))){
				sb.append("    B_GI_StealthClass = ?, ");
				params.add(po.getBgistealthclass());
			}
			if(!"".equals(Utility.getName(po.getBginumberofdays()))){
				sb.append("    B_GI_Numberofdays = ?, ");
				params.add(po.getBginumberofdays());
			}
			
			if(!"".equals(Utility.getName(po.getBgiordercycle()))){
				sb.append("    B_GI_orderCycle = ?, ");
				params.add(po.getBgiordercycle());
			}
			
			if(!"".equals(Utility.getName(po.getBgicurvature1ul()))){
				sb.append("    B_GI_Curvature1UL = ?, ");
				params.add(po.getBgicurvature1ul());
			}
			if(!"".equals(Utility.getName(po.getBgicurvature1up()))){
				sb.append("    B_GI_Curvature1UP = ?, ");
				params.add(po.getBgicurvature1up());
			}
			if(!"".equals(Utility.getName(po.getBgicurvature2ul()))){
				sb.append("    B_GI_Curvature2UL = ?, ");
				params.add(po.getBgicurvature2ul());
			}
			if(!"".equals(Utility.getName(po.getBgicurvature2up()))){
				sb.append("    B_GI_Curvature2UP = ?, ");
				params.add(po.getBgicurvature2up());
			}
			if(!"".equals(Utility.getName(po.getBgidiaul()))){
				sb.append("    B_GI_DiaUL = ?, ");
				params.add(po.getBgidiaul());
			}
			if(!"".equals(Utility.getName(po.getBgidiaup()))){
				sb.append("    B_GI_DiaUP = ?, ");
				params.add(po.getBgidiaup());
			}
			if(!"".equals(Utility.getName(po.getBgicontacttypey()))){
				sb.append("    B_GI_ContactTypeY = ?, ");
				params.add(po.getBgicontacttypey());
			}
			if(!"".equals(Utility.getName(po.getBgicontacttyped()))){
				sb.append("    B_GI_ContactTypeD = ?, ");
				params.add(po.getBgicontacttyped());
			}
		}
		sb.append("    B_GI_MaterialClass = B_GI_MaterialClass ");
		sb.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("3D".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=3 AND B_GI_isCustomize= 'D' ");
			}else if("4D".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=4 AND B_GI_isCustomize= 'D' AND B_GI_StealthCustomizeType = '2' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=3 AND B_GI_isCustomize= '0' ");
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=4 AND B_GI_isCustomize= '0' ");
			}else if("4R".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=4 AND B_GI_isCustomize= 'D' AND B_GI_StealthCustomizeType = '1' ");
			}else{
				sb.append(" AND B_GI_GoodsCategoryID=? ");
				params.add(po.getBgigoodscategoryid());
			}
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" AND B_GI_BrandID=? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" AND B_GI_SupplierID=? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" AND B_GI_GoodsID=? ");
			params.add(po.getBgigoodsid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	public void updateGoodsAttributeNot(GoodsInfoPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("UPDATE B_GoodsInfo ");
		sb.append("SET    B_GI_NotTaxRate=cast(B_GI_CostPrice/(1+B_GI_TaxRate*0.01) as numeric(18,6))  ");
		sb.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getBgigoodscategoryid()))){
			if("3D".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=3 AND B_GI_isCustomize= 'D' ");
			}else if("4D".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=4 AND B_GI_isCustomize= 'D' ");
			}else if("3".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=3 AND B_GI_isCustomize= '0' ");
			}else if("4".equals(Utility.getName(po.getBgigoodscategoryid()))){
				sb.append(" AND B_GI_GoodsCategoryID=4 AND B_GI_isCustomize= '0' ");
			}else{
				sb.append(" AND B_GI_GoodsCategoryID=? ");
				params.add(po.getBgigoodscategoryid());
			}
		}
		if(!"".equals(Utility.getName(po.getBgibrandid()))){
			sb.append(" AND B_GI_BrandID=? ");
			params.add(po.getBgibrandid());
		}
		if(!"".equals(Utility.getName(po.getBgisupplierid()))){
			sb.append(" AND B_GI_SupplierID=? ");
			params.add(po.getBgisupplierid());
		}
		if(!"".equals(Utility.getName(po.getBgigoodsid()))){
			sb.append(" AND B_GI_GoodsID=? ");
			params.add(po.getBgigoodsid());
		}
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
}
