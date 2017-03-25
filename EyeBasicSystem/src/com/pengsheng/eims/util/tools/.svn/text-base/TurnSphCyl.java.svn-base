package com.pengsheng.eims.util.tools;

import java.math.BigDecimal;

public class TurnSphCyl {
	public static String changeSph(String sph,String cyl){
		BigDecimal sphNew;
		if("".equals(Utility.getName(cyl))){
			return sph;
		}
		if(Double.parseDouble(cyl)>0){
			if(!"".equals(sph)){
				sphNew = new BigDecimal(Float.parseFloat(cyl)).add(new BigDecimal(Float.parseFloat(sph)));
			}else{
				return "";
			}
		}else{
			return sph;
		}
		return sphNew.toString();
	}
	public static String changeCyl(String sph,String cyl){
		BigDecimal cylNew ;
		if("".equals(Utility.getName(cyl))){
			return "";
		}
		if(Double.parseDouble(cyl)>0){
			cylNew = new BigDecimal(Float.parseFloat(cyl)).multiply(new BigDecimal("-1"));
		}else{
			return cyl;
		}
		return cylNew.toString();
	}
	public static String changeScopeCyl(String cyl,String cyl2){
		BigDecimal cylNew ;
		if("".equals(Utility.getName(cyl))&&!"".equals(Utility.getName(cyl2))){
			if(Double.parseDouble(cyl2)>0){
				cylNew = new BigDecimal(Float.parseFloat(cyl2)).multiply(new BigDecimal("-1"));
			}else{
				return cyl2;
			}
		}else if(!"".equals(Utility.getName(cyl))&&"".equals(Utility.getName(cyl2))){
			return "";
		}else if(!"".equals(Utility.getName(cyl))&&!"".equals(Utility.getName(cyl2))){
			if(Double.parseDouble(cyl)<0&&Double.parseDouble(cyl2)<0){
				return cyl2;
			}else{
					cylNew = new BigDecimal(Float.parseFloat(cyl)).multiply(new BigDecimal("-1"));
			}
		}else{
			return "";
		}
		
		return cylNew.toString();
	}
}
