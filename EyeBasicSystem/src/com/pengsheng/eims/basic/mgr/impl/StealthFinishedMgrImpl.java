package com.pengsheng.eims.basic.mgr.impl;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.dao.StealthFinishedDao;
import com.pengsheng.eims.basic.mgr.StealthFinishedMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class StealthFinishedMgrImpl implements StealthFinishedMgr {
	private SystemParameterMgr systemParameterMgr;
	private LogisticsLogDao logisticsLogDao;	
	
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

	private StealthFinishedDao stealthFinishedDao;

	public StealthFinishedDao getStealthFinishedDao() {
		return stealthFinishedDao;
	}

	public void setStealthFinishedDao(StealthFinishedDao stealthFinishedDao) {
		this.stealthFinishedDao = stealthFinishedDao;
	}

	public int getStealthFinishedCount(GoodsInfoPo po) {
		return stealthFinishedDao.getStealthFinishedCount(po);
	}

	public List<GoodsInfoPo> getStealthFinishedList(GoodsInfoPo po, int start,
			int size) {
		return stealthFinishedDao.getStealthFinishedList(po, start, size);
	}

	public void insertStealthFinished(GoodsInfoPo po,LogisticsLogPo logPo) {
		stealthFinishedDao.insertStealthFinished(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateStealthFinished(GoodsInfoPo po,LogisticsLogPo logPo) {
		stealthFinishedDao.updateStealthFinished(po);
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	public GoodsInfoPo getStealthFinished(GoodsInfoPo po) {

		return stealthFinishedDao.getStealthFinished(po);
	}

	public void deleteStealthFinished(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthFinishedDao.deleteStealthFinished(po);
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	public void updateStealthFinishedDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthFinishedDao.updateStealthFinishedDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	public void insertStealthFinishedBulk(SystemParameterPo systemParameterPo,GoodsInfoPo po,LogisticsLogPo logPo) {

		Float bgisphul = Float.parseFloat(po.getBgisphul());
		Float bgisphup = Float.parseFloat(po.getBgisphup());
		Float bgisphspan = Float.parseFloat(po.getBgisphspan());

		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsname(po.getBgigoodsname());
		goodsInfoPo.setBgigoodscategoryid(po.getBgigoodscategoryid());
		goodsInfoPo.setBgisupplierid(po.getBgisupplierid());
		goodsInfoPo.setBgibrandid(po.getBgibrandid());
		goodsInfoPo.setBgiunitid(po.getBgiunitid());
		goodsInfoPo.setBgispec(po.getBgispec());
		goodsInfoPo.setBgicurvature1(po.getBgicurvature1());
		goodsInfoPo.setBgicylspan(po.getBgicylspan());
		goodsInfoPo.setBgicyl(po.getBgicyl());
		goodsInfoPo.setBgidia(po.getBgidia());
		goodsInfoPo.setBgicostprice(po.getBgicostprice());
		goodsInfoPo.setBgitaxrate(po.getBgitaxrate());
		goodsInfoPo.setBginottaxrate(po.getBginottaxrate());
		goodsInfoPo.setBgiretailprice(po.getBgiretailprice());
		goodsInfoPo.setBgistorageupperlimit(po.getBgistorageupperlimit());
		goodsInfoPo.setBgistoragelowerlimit(po.getBgistoragelowerlimit());
		goodsInfoPo.setBgicolor(getGoodsBil(po));
		goodsInfoPo.setBgichinesecolor(po.getBgichinesecolor());
		goodsInfoPo.setBgireturnmax(po.getBgireturnmax());
		goodsInfoPo.setBgireturnmin(po.getBgireturnmin());
		goodsInfoPo.setBgiwholesaleprice(po.getBgiwholesaleprice());
		goodsInfoPo.setBgiusetype(po.getBgiusetype());
		goodsInfoPo.setBgistealthclass(po.getBgistealthclass());
		goodsInfoPo.setBgiaxis(po.getBgiaxis());
		goodsInfoPo.setBgiaveragenotnaxrate(po.getBgiaveragenotnaxrate());		
		goodsInfoPo.setBginumberofdays(po.getBginumberofdays());				
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
		goodsInfoPo.setBgicontacttype(Utility.getName(po.getBgicontacttype()));
		goodsInfoPo.setBgistealthtype(Utility.getName(po.getBgistealthtype()));
		goodsInfoPo.setBgipayfeeid(Utility.getName(po.getBgipayfeeid()));
		
		while (bgisphul >= bgisphup) {
			BigDecimal bgisph = new BigDecimal(bgisphup.toString()).divide(
					new BigDecimal("1"), 2, BigDecimal.ROUND_HALF_UP);
			goodsInfoPo.setBgisph(bgisph.toString());
			goodsInfoPo.setBgicyl(goodsInfoPo.getBgicyl());
			//翻方球镜柱镜 begin
			if(Double.parseDouble(goodsInfoPo.getBgicyl())>0){
				BigDecimal bgivsphNew = new BigDecimal(bgisphup.toString()).add(new BigDecimal(goodsInfoPo.getBgicyl()));
				goodsInfoPo.setBgivsph(bgivsphNew.toString());
				goodsInfoPo.setBgivcyl(new BigDecimal(goodsInfoPo.getBgicyl()).multiply(new BigDecimal("-1")).toString());
			}else{
				
				goodsInfoPo.setBgivsph(bgisph.toString());
				goodsInfoPo.setBgivcyl(goodsInfoPo.getBgicyl());
			}
			//翻方球镜柱镜 end
			

			if (Double.parseDouble(goodsInfoPo.getBgisph().replace("+", "")) > 0) {
				goodsInfoPo.setBgisph("+" + goodsInfoPo.getBgisph());
			}
			
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
			if (Double.parseDouble(goodsInfoPo.getBgivcyl().replace("+", "")) > 0) {
				goodsInfoPo.setBgivcyl("+" + goodsInfoPo.getBgivcyl());
			}
			
			if (goodsInfoPo.getBgivcyl().contains("++")) {
				goodsInfoPo.setBgivcyl(goodsInfoPo.getBgivcyl().substring(1));
			}
			goodsInfoPo.setBgispec(getSpec(goodsInfoPo));
			goodsInfoPo.setBgispecNegative(getSpecNegative(goodsInfoPo));
			String goodsID = getGoodsID(goodsInfoPo);
			goodsInfoPo.setBgigoodsid(goodsID);
			goodsInfoPo.setBgigoodsbarcode(getGoodsbarcode(goodsID));
			
			String[] goodsnametype = systemParameterPo.getFspcyxjp().trim().split(",");
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
				}
			}
			goodsInfoPo.setBgiviewgoodsname(viewgoodsname);

			GoodsInfoPo infoPo = stealthFinishedDao.getStealthFinished(goodsInfoPo);
			
			GoodsInfoPo go=new GoodsInfoPo();
			go.setBgigoodsid(getGoodsIDNegative(goodsInfoPo));
			
			if("1".equals(systemParameterMgr.getSystemParameterPo().getFspnegative())){
				if (infoPo.getBgigoodsid() == null&&"".equals(Utility.getName(stealthFinishedDao.getStealthFinished(go).getBgigoodsid()))) {
					stealthFinishedDao.insertStealthFinished(goodsInfoPo);
				}
			}else{
				if (infoPo.getBgigoodsid() == null) {
					stealthFinishedDao.insertStealthFinished(goodsInfoPo);
				}
			}
			bgisphup = bgisphup + bgisphspan;

			if (0f == bgisphspan)
				break;

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
			if (Float.parseFloat(tempsph) != 0) {
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
			if (Float.parseFloat(tempCyl) != 0) {
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

		return bil;
	}

}
