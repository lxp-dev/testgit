package com.pengsheng.eims.basic.mgr.impl;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.dao.LensFinishedDao;
import com.pengsheng.eims.basic.mgr.LensFinishedMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class LensFinishedMgrImpl implements LensFinishedMgr {
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterMgr systemParameterMgr;
	
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}
	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	private LensFinishedDao lensFinishedDao;

	public LensFinishedDao getLensFinishedDao() {
		return lensFinishedDao;
	}

	public void setLensFinishedDao(LensFinishedDao lensFinishedDao) {
		this.lensFinishedDao = lensFinishedDao;
	}

	public int getLensFinishedCount(GoodsInfoPo goodsInfoPo) {
		return lensFinishedDao.getLensFinishedCount(goodsInfoPo);
	}

	public List<GoodsInfoPo> getLensFinishedList(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		return lensFinishedDao.getLensFinishedList(goodsInfoPo, start, size);
	}

	public GoodsInfoPo getLensFinished(GoodsInfoPo po) {
		return lensFinishedDao.getLensFinished(po);
	}

	public void insertLensFinished(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensFinishedDao.insertLensFinished(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void insertLensFinisheds(List<GoodsInfoPo> pos,List<LogisticsLogPo> logPos) {
		for(int i=0; i<pos.size(); i++){
			lensFinishedDao.insertLensFinished(pos.get(i));
			logisticsLogDao.insertLog(logPos.get(i)); //添加日志
		}
	}

	public void updateLendsFinishedDisable(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensFinishedDao.updateLendsFinishedDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateLensFinished(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensFinishedDao.updateLensFinished(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void deleteLensFinished(GoodsInfoPo po,LogisticsLogPo logPo) {
		lensFinishedDao.deleteLensFinished(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void insertLensFinishedBulk(SystemParameterPo systemParameterPo,GoodsInfoPo po,LogisticsLogPo logPo) {

		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsname(po.getBgigoodsname());
		goodsInfoPo.setBgigoodscategoryid(po.getBgigoodscategoryid());
		goodsInfoPo.setBgisupplierid(po.getBgisupplierid());
		goodsInfoPo.setBgibrandid(po.getBgibrandid());
		goodsInfoPo.setBgibelowplusluminosity(po.getBgibelowplusluminosity());
		goodsInfoPo.setBgiunitid(po.getBgiunitid());
		goodsInfoPo.setBgispec(po.getBgispec());
		goodsInfoPo.setBgieyeglassmaterialtype(po.getBgieyeglassmaterialtype());
		goodsInfoPo.setBgistealthtype(po.getBgistealthtype());
		goodsInfoPo.setBgicurvature1(po.getBgicurvature1());
		goodsInfoPo.setBgicylspan(po.getBgicylspan());
		goodsInfoPo.setBgidia(po.getBgidia());
		goodsInfoPo.setBgithrowingcycle(po.getBgithrowingcycle());
		goodsInfoPo.setBgicostprice(po.getBgicostprice());
		goodsInfoPo.setBgitaxrate(po.getBgitaxrate());
		goodsInfoPo.setBginottaxrate(po.getBginottaxrate());
		goodsInfoPo.setBgiretailprice(po.getBgiretailprice());
		goodsInfoPo.setBgistorageupperlimit(po.getBgistorageupperlimit());
		goodsInfoPo.setBgistoragelowerlimit(po.getBgistoragelowerlimit());
		goodsInfoPo.setBgiiscustomize(po.getBgiiscustomize());
		goodsInfoPo.setBgiflag(po.getBgiflag());
		goodsInfoPo.setBgirefractive(po.getBgirefractive());
		goodsInfoPo.setBgicolor(getGoodsBil(po));
		goodsInfoPo.setBgiismutiluminosity(Utility.getName(po.getBgiismutiluminosity()));
		goodsInfoPo.setBgiwholesaleprice(Utility.getName(po.getBgiwholesaleprice()));
		goodsInfoPo.setBgigradualclass(Utility.getName(po.getBgigradualclass()));
		goodsInfoPo.setBgifunctionclass(Utility.getName(po.getBgifunctionclass()));
		goodsInfoPo.setBgiaveragenotnaxrate(Utility.getName(po.getBgiaveragenotnaxrate()));
		
		goodsInfoPo.setBgiretailpricea(Utility.getName(po.getBgiretailpricea()));
		goodsInfoPo.setBgiretailpriceb(Utility.getName(po.getBgiretailpriceb()));
		goodsInfoPo.setBgiretailpricec(Utility.getName(po.getBgiretailpricec()));
		goodsInfoPo.setBgiretailpriced(Utility.getName(po.getBgiretailpriced()));
		goodsInfoPo.setBgiretailpricee(Utility.getName(po.getBgiretailpricee()));
		goodsInfoPo.setBgiretailpricef(Utility.getName(po.getBgiretailpricef()));
		goodsInfoPo.setBgiretailpriceg(Utility.getName(po.getBgiretailpriceg()));
		goodsInfoPo.setBgiretailpriceh(Utility.getName(po.getBgiretailpriceh()));
		goodsInfoPo.setBgiretailpricei(Utility.getName(po.getBgiretailpricei()));
		goodsInfoPo.setBgidefaultdiscountvalue(Utility.getName(po.getBgidefaultdiscountvalue()));
		goodsInfoPo.setBgibarcodeflag(Utility.getName(po.getBgibarcodeflag()));
		goodsInfoPo.setBgipayfeeid(Utility.getName(po.getBgipayfeeid()));
		
		// 如果球镜跨度等于0 球镜上下限相同
		Float bgisphspan = Float.parseFloat(po.getBgisphspan());
		if (bgisphspan == 0) {
			po.setBgisphup(po.getBgisphul());
		}

		Float bgisphul = Float.parseFloat(po.getBgisphul());
		Float bgisphup = Float.parseFloat(po.getBgisphup());

		while (bgisphul >= bgisphup) {
			BigDecimal bgisph = new BigDecimal(bgisphup.toString()).divide(
					new BigDecimal("1"), 2, BigDecimal.ROUND_HALF_UP);
			if(Double.parseDouble(bgisph.toString())>0){
				goodsInfoPo.setBgisph("+"+bgisph.toString());
			}else{
				goodsInfoPo.setBgisph(bgisph.toString());
			}
			

			// 如果柱镜跨度等于0 柱镜上下限相同
			Float bgicylspan = Float.parseFloat(po.getBgicylspan());
			if (bgicylspan == 0) {
				po.setBgicylup(po.getBgicylul());
			}

			Float bgicylul = Float.parseFloat(po.getBgicylul());
			Float bgicylup = Float.parseFloat(po.getBgicylup());

			while (bgicylul >= bgicylup) { // 柱镜
				BigDecimal bgicyl = new BigDecimal(bgicylup).divide(
						new BigDecimal("1"), 2, BigDecimal.ROUND_HALF_UP);
				goodsInfoPo.setBgicyl(bgicyl.toString());
				//翻方球镜柱镜 begin
				if(Double.parseDouble(bgicyl.toString())>0){
					BigDecimal bgisphNew = new BigDecimal(bgicylup).add(bgisph);
					goodsInfoPo.setBgivsph(bgisphNew.toString());
					goodsInfoPo.setBgivcyl("-"+bgicyl.toString());
				}else{
					BigDecimal bgisphNew=bgisph;
					goodsInfoPo.setBgivsph(bgisphNew.toString());
					goodsInfoPo.setBgivcyl(bgicyl.toString());
				}
				
				//翻方球镜柱镜 end
				
				

				if (goodsInfoPo.getBgisph().contains("++")) {
					goodsInfoPo.setBgisph(goodsInfoPo.getBgisph().substring(1));
				}
				if (Double.parseDouble(goodsInfoPo.getBgicyl().replace("+", "")) > 0) {
					goodsInfoPo.setBgicyl("+" + goodsInfoPo.getBgicyl());
				}
				
				if (goodsInfoPo.getBgicyl().contains("++")) {
					goodsInfoPo.setBgicyl(goodsInfoPo.getBgicyl().substring(1));
				}
				
				if (goodsInfoPo.getBgivsph().contains("++")) {
					goodsInfoPo.setBgivsph(goodsInfoPo.getBgivsph().substring(1));
				}
				goodsInfoPo.setBgispec(getSpec(goodsInfoPo));
				goodsInfoPo.setBgispecNegative(getSpecNegative(goodsInfoPo));

				String goodsID = getGoodsID(goodsInfoPo);
				goodsInfoPo.setBgigoodsid(goodsID);
				goodsInfoPo.setBgigoodsbarcode(getGoodsbarcode(goodsID));

				GoodsInfoPo infoPo = lensFinishedDao.getLensFinished(goodsInfoPo);

				String[] goodsnametype = systemParameterPo.getFspcjp().trim().split(",");
				String viewgoodsname = goodsInfoPo.getBgigoodsname();
				for(int i=0; i<goodsnametype.length; i++){
					if(goodsnametype[i].trim().equals("B_GI_Spec")){
						viewgoodsname = viewgoodsname + "-型号："+goodsInfoPo.getBgispec();
					} else if(goodsnametype[i].trim().equals("B_GI_Color")){
						viewgoodsname = viewgoodsname + "-颜色："+goodsInfoPo.getBgichinesecolorname();
					} else if(goodsnametype[i].trim().equals("B_GI_Sph")){
						viewgoodsname = viewgoodsname + "-球镜："+goodsInfoPo.getBgisph();
					} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
						viewgoodsname = viewgoodsname + "-柱镜："+goodsInfoPo.getBgicyl();
					} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
						viewgoodsname = viewgoodsname + "-标价："+goodsInfoPo.getBgiretailprice();
					}
				}
				goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
				
					GoodsInfoPo go=new GoodsInfoPo();
					go.setBgigoodsid(getGoodsIDNegative(goodsInfoPo));
				if("1".equals(systemParameterMgr.getSystemParameterPo().getFspnegative())){
					if (infoPo.getBgigoodsid() == null&&"".equals(Utility.getName(lensFinishedDao.getLensFinished(go).getBgigoodsid()))) {
						lensFinishedDao.insertLensFinished(goodsInfoPo);
				}
				}else{
					if (infoPo.getBgigoodsid() == null) {
						lensFinishedDao.insertLensFinished(goodsInfoPo);
					}
				}
				bgicylup = bgicylup + bgicylspan;
				// 如果柱镜跨度等于0 柱镜上下限相同 柱镜循环只执行一次
				if (bgicylspan == 0) {
					break;
				}
			}

			bgisphup = bgisphup + bgisphspan;

			// 如果球镜跨度等于0 球镜上下限相同 球镜循环只执行一次
			if (bgisphspan == 0) {
				break;
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	private String getSpec(GoodsInfoPo po) {
		String specid = "";
		String specid1 = "";
		String specid2 = "";
		String bgisph = "";
		String bgicyl = "";
		if("1".equals(systemParameterMgr.getSystemParameterPo().getFspnegative())){
			if (Float.parseFloat(po.getBgisph()) <= 0) {
				specid1 = "A";
			} else {
				specid1 = "B";
			}
			if (Float.parseFloat(po.getBgicyl()) <= 0) {
				specid2 = "A";
			} else {
				specid2 = "B";
			}
			String tempsph = po.getBgisph().replace("+", "");
			if (Float.parseFloat(tempsph) < 0) {
				tempsph = tempsph.substring(1, tempsph.length());
			}
			String[] sph = tempsph.split("\\.");
			for (int i = 0; i < sph.length; i++) {
				bgisph = bgisph + sph[i];
			}
			if (bgisph.length() < 4) {
				for (int i = 0; i < 4 - bgisph.length(); i++) {
					bgisph = "0" + bgisph;
				}
			}
			String tempCyl = po.getBgicyl();
			if (Float.parseFloat(tempCyl) < 0) {
				tempCyl = tempCyl.substring(1, tempCyl.length());
			}
			String[] cyl = tempCyl.split("\\.");
			for (int i = 0; i < cyl.length; i++) {
				bgicyl = bgicyl + cyl[i];
			}
			if (bgicyl.length() < 3) {
				for (int i = 0; i < 4 - bgicyl.length(); i++) {
					bgicyl = "0" + bgicyl;
				}
			}
		}else{
			if (Float.parseFloat(po.getBgisph()) <= 0) {
				specid = "CA";
			} else {
				specid = "CB";
			}
			String tempsph = po.getBgisph().replace("+", "");
			if (Float.parseFloat(tempsph) < 0) {
				tempsph = tempsph.substring(1, tempsph.length());
			}
			String[] sph = tempsph.split("\\.");
			for (int i = 0; i < sph.length; i++) {
				bgisph = bgisph + sph[i];
			}
			if (bgisph.length() < 4) {
				for (int i = 0; i < 4 - bgisph.length(); i++) {
					bgisph = "0" + bgisph;
				}
			}
			String tempCyl = po.getBgicyl();
			if (Float.parseFloat(tempCyl) < 0) {
				tempCyl = tempCyl.substring(1, tempCyl.length());
			}
			String[] cyl = tempCyl.split("\\.");
			for (int i = 0; i < cyl.length; i++) {
				bgicyl = bgicyl + cyl[i];
			}
			if (bgicyl.length() < 3) {
				for (int i = 0; i < 4 - bgicyl.length(); i++) {
					bgicyl = "0" + bgicyl;
				}
			}

		}
		specid = specid+specid1 +specid2 + bgisph + bgicyl;

		return specid;
	}
	
	//翻方spec
	private String getSpecNegative(GoodsInfoPo po) {
		String specid = "";
		String specid1 = "";
		if (Float.parseFloat(po.getBgivsph()) <= 0) {
			specid1 = "A";
		} else {
			specid1 = "B";
		}
		String specid2 = "";
			if (Float.parseFloat(po.getBgivcyl()) <= 0) {
				specid2 = "A";
			} else {
				specid2 = "B";
			}
		String bgisph = "";
		String tempsph = po.getBgivsph().replace("+", "");
		if (Float.parseFloat(tempsph) < 0) {
			tempsph = tempsph.substring(1, tempsph.length());
		}
		String[] sph = tempsph.split("\\.");
		for (int i = 0; i < sph.length; i++) {
			bgisph = bgisph + sph[i];
		}
		if (bgisph.length() < 4) {
			for (int i = 0; i < 4 - bgisph.length(); i++) {
				bgisph = "0" + bgisph;
			}
		}
		String bgicyl = "";
		String tempCyl = po.getBgivcyl();
		if (Float.parseFloat(tempCyl) < 0) {
			tempCyl = tempCyl.substring(1, tempCyl.length());
		}
		String[] cyl = tempCyl.split("\\.");
		for (int i = 0; i < cyl.length; i++) {
			bgicyl = bgicyl + cyl[i];
		}
		if (bgicyl.length() < 3) {
			for (int i = 0; i < 4 - bgicyl.length(); i++) {
				bgicyl = "0" + bgicyl;
			}
		}

		specid = specid1 +specid2 + bgisph + bgicyl;

		return specid;
	}
	private String getGoodsBil(GoodsInfoPo po) {

		String bil = "";
		if (Utility.getName(po.getBgicolor()) == "") {
			bil = "0000";
		}
		
		if (Utility.getName(po.getBgicolor()).length() == 1) {
			bil = "000"+po.getBgicolor();
		}
		
		if (Utility.getName(po.getBgicolor()).length() == 2) {
			bil = "00"+po.getBgicolor();
		}
		
		if (Utility.getName(po.getBgicolor()).length() == 3) {
			bil = "0"+po.getBgicolor();
		}
		
		if (Utility.getName(po.getBgicolor()).length() == 4) {
			bil = po.getBgicolor();
		}
		
		if (Utility.getName(po.getBgicolor()).length() > 4) {
			bil = Utility.getName(po.getBgicolor()).substring(Utility.getName(po.getBgicolor()).length()-4);
		}

		return bil;
	}

	private String getGoodsID(GoodsInfoPo po) {

		String goodsID = po.getBgigoodscategoryid() + "."
				+ po.getBgisupplierid() + "." + po.getBgibrandid() + "."
				+ po.getBgispec().replace("+", "") + "."+po.getBgicolor().replace("+", "");

		return goodsID;
	}
	
	private String getGoodsIDNegative(GoodsInfoPo po) {

		String goodsID = po.getBgigoodscategoryid() + "."
				+ po.getBgisupplierid() + "." + po.getBgibrandid() + "."
				+ po.getBgispecNegative().replace("+", "") + "."+po.getBgicolor().replace("+", "");

		return goodsID;
	}

	private String getGoodsbarcode(String goodsID) {

		String goodsbarcode = "";
		String[] goodsid = goodsID.split("\\.");
		for (int i = 0; i < goodsid.length; i++) {
			goodsbarcode = goodsbarcode + goodsid[i];
		}
		return goodsbarcode;
	}
	
	/**
	 * 获取商品库存数量
	 * 
	 * @param po
	 */
	public int getGoodsCount(GoodsInfoPo po){
		return lensFinishedDao.getGoodsCount(po);
	}
	public int getLensFinishedCountNV(GoodsInfoPo po){
		return lensFinishedDao.getLensFinishedCountNV(po);
	}
}
