package com.pengsheng.eims.hydsycasehistory.persistence;

public class EyesCheckPo {
	
	private String sopecid;//自动编号
	private String sopeccustomerid;//顾客号
	private String sopeccustomername;//顾客姓名
	private String sopeccustomerpostcode;//顾客会员卡号
	private String sopeccustomersex;//顾客性别
	private String sopeccustomerage;//顾客年龄
	private String sopeccustomerphone;//顾客电话
	private String sopecshopcode;//店号
	private String sopecsurfaceeyeod;//外眼-右
	private String sopecsurfaceeyeos;//外眼-左
	private String sopeccongestiveod;//结膜充血-右
	private String sopeccongestiveos;//结膜充血-左
	private String sopecnippleod;//结膜乳头滤泡结石-右
	private String sopecnippleos;//结膜乳头滤泡结石-左
	private String sopeccornealod;//角膜-右
	private String sopeccornealos;//角膜-左
	private String sopectearosod;//泪液-右
	private String sopectearosos;//泪液-左
	private String sopechyphemaod;//前房-右
	private String sopechyphemaos;//前房-左
	private String sopecirisod;//虹膜-右
	private String sopecirisos;//虹膜-左
	private String sopeccrystalod;//晶体-右
	private String sopeccrystalos;//晶体-左
	private String sopecfundusod;//眼底-右
	private String sopecfundusos;//眼底-左
	private String sopeccampaignod;//眼球运动-右
	private String sopeccampaignos;//眼球运动-左
	private String sopeccolorod;//色觉-右
	private String sopeccoloros;//色觉-左
	private String sopeciopod;//眼压录入-右
	private String sopeciopos;//眼压录入-左
	private String sopeciopselod;//眼压-右
	private String sopeciopselos;//眼压-左	
	private String sopecpersonid;//检查人员ID
	private String sopecpersonname;//检查人员姓名
	private String sopecpersondepartment;//检查人员部门
	private String sopecvisiontime;//眼部健康检查检查时间
	private String startTime;
	private String endTime;
	private String smecimemberid;
	private String sopecfruit;					//检查结果 
	private String sopecills;					//检查病症
	private String sopecillhistory1;			//病史1
	private String sopecillhistory2;			//病史2
	private String sopecillhistory3;			//病史3
	private String sopecheredityhistory1;		//遗传史1
	private String sopecallergyhistory1;		//过敏史1
	private String sopecismydriasis;			//是否散瞳
	private String sopecanaesthetic;			//散瞳用药
	
	//哈医大四院加
	private String sopdefarhetelevel; // 远隐斜水平
	private String sopdefarhetelevelio; // 远隐斜水平(内/外)
	private String sopdefarheteuprightness; // 远隐斜垂直
	private String sopdefarheteuprightnessud; // 远隐斜垂直(上/下)
	private String sopdeclosehetelevel; // 近隐斜水平
	private String sopdeclosehetelevelio; // 近隐斜水平(内/外)
	private String sopdecloseheteuprightness; // 近隐斜垂直
	private String sopdecloseheteuprightnessud; // 近隐斜垂直(上/下)
	private String sopecapparatusod;//泪器-右
	private String sopecapparatusos;//泪器-左	
	private String sophctearfilmgradeod1;   // 分级-右
	private String sophctearfilmgradeos1;    // 分级-左	
	private String sophcschirme5od; // schirme5-右
	private String sophcschirme5os;  // schirme5-左
	private String sophcbu7od;  // BUT-右
	private String sophcbu7os;   // BUT-左
	private String soprcustomersay;   // 主诉	
	private String sopipglasstypes; // 矫正方案 - 框架眼镜
	private String sopiptouchglass; // 矫正方案 - 角膜接触镜
	private String sopiptraintypes; // 矫正方案 - 视觉训练
	private String sopioperation; // 矫正方案 - 手术	
	private String soperefractiveerror; // 诊断 - 屈光不正
	
	private String sopecillstype;//诊断类型	1：屈光不正；2弱视；3斜视；4：其他
	private String sopecillsConent;//诊断内容	S_OP_DE_IllsType为2/3/4时
	
	private String sopdezdqgbz;			//屈光不正
	private String sopdezdrs;			//弱视
	private String sopdezdxs;			//斜视
	private String sopdezdqt;			//其他
	
	//哈医大四院加
	
	public String getSopecapparatusod() {
		return sopecapparatusod;
	}
	public String getSopdezdqgbz() {
		return sopdezdqgbz;
	}
	public void setSopdezdqgbz(String sopdezdqgbz) {
		this.sopdezdqgbz = sopdezdqgbz;
	}
	public String getSopdezdrs() {
		return sopdezdrs;
	}
	public void setSopdezdrs(String sopdezdrs) {
		this.sopdezdrs = sopdezdrs;
	}
	public String getSopdezdxs() {
		return sopdezdxs;
	}
	public void setSopdezdxs(String sopdezdxs) {
		this.sopdezdxs = sopdezdxs;
	}
	public String getSopdezdqt() {
		return sopdezdqt;
	}
	public void setSopdezdqt(String sopdezdqt) {
		this.sopdezdqt = sopdezdqt;
	}
	public void setSopecapparatusod(String sopecapparatusod) {
		this.sopecapparatusod = sopecapparatusod;
	}
	public String getSopecapparatusos() {
		return sopecapparatusos;
	}
	public void setSopecapparatusos(String sopecapparatusos) {
		this.sopecapparatusos = sopecapparatusos;
	}
	public String getSophctearfilmgradeod1() {
		return sophctearfilmgradeod1;
	}
	public void setSophctearfilmgradeod1(String sophctearfilmgradeod1) {
		this.sophctearfilmgradeod1 = sophctearfilmgradeod1;
	}
	public String getSophcschirme5od() {
		return sophcschirme5od;
	}
	public void setSophcschirme5od(String sophcschirme5od) {
		this.sophcschirme5od = sophcschirme5od;
	}
	public String getSophcbu7od() {
		return sophcbu7od;
	}
	public void setSophcbu7od(String sophcbu7od) {
		this.sophcbu7od = sophcbu7od;
	}
	public String getSophctearfilmgradeos1() {
		return sophctearfilmgradeos1;
	}
	public void setSophctearfilmgradeos1(String sophctearfilmgradeos1) {
		this.sophctearfilmgradeos1 = sophctearfilmgradeos1;
	}
	public String getSophcschirme5os() {
		return sophcschirme5os;
	}
	public void setSophcschirme5os(String sophcschirme5os) {
		this.sophcschirme5os = sophcschirme5os;
	}
	public String getSophcbu7os() {
		return sophcbu7os;
	}
	public void setSophcbu7os(String sophcbu7os) {
		this.sophcbu7os = sophcbu7os;
	}
	public String getSoprcustomersay() {
		return soprcustomersay;
	}
	public void setSoprcustomersay(String soprcustomersay) {
		this.soprcustomersay = soprcustomersay;
	}
	public String getSopipglasstypes() {
		return sopipglasstypes;
	}
	public void setSopipglasstypes(String sopipglasstypes) {
		this.sopipglasstypes = sopipglasstypes;
	}
	public String getSopiptouchglass() {
		return sopiptouchglass;
	}
	public void setSopiptouchglass(String sopiptouchglass) {
		this.sopiptouchglass = sopiptouchglass;
	}
	public String getSopiptraintypes() {
		return sopiptraintypes;
	}
	public void setSopiptraintypes(String sopiptraintypes) {
		this.sopiptraintypes = sopiptraintypes;
	}
	public String getSopioperation() {
		return sopioperation;
	}
	public void setSopioperation(String sopioperation) {
		this.sopioperation = sopioperation;
	}
	public String getSoperefractiveerror() {
		return soperefractiveerror;
	}
	public void setSoperefractiveerror(String soperefractiveerror) {
		this.soperefractiveerror = soperefractiveerror;
	}
	public String getSopecanaesthetic() {
		return sopecanaesthetic;
	}
	public void setSopecanaesthetic(String sopecanaesthetic) {
		this.sopecanaesthetic = sopecanaesthetic;
	}
	public String getSopecismydriasis() {
		return sopecismydriasis;
	}
	public void setSopecismydriasis(String sopecismydriasis) {
		this.sopecismydriasis = sopecismydriasis;
	}
	public String getSopecillhistory1() {
		return sopecillhistory1;
	}
	public void setSopecillhistory1(String sopecillhistory1) {
		this.sopecillhistory1 = sopecillhistory1;
	}
	public String getSopecillhistory2() {
		return sopecillhistory2;
	}
	public void setSopecillhistory2(String sopecillhistory2) {
		this.sopecillhistory2 = sopecillhistory2;
	}
	public String getSopecillhistory3() {
		return sopecillhistory3;
	}
	public void setSopecillhistory3(String sopecillhistory3) {
		this.sopecillhistory3 = sopecillhistory3;
	}
	public String getSopecheredityhistory1() {
		return sopecheredityhistory1;
	}
	public void setSopecheredityhistory1(String sopecheredityhistory1) {
		this.sopecheredityhistory1 = sopecheredityhistory1;
	}
	public String getSopecallergyhistory1() {
		return sopecallergyhistory1;
	}
	public void setSopecallergyhistory1(String sopecallergyhistory1) {
		this.sopecallergyhistory1 = sopecallergyhistory1;
	}
	public String getSopecfruit() {
		return sopecfruit;
	}
	public void setSopecfruit(String sopecfruit) {
		this.sopecfruit = sopecfruit;
	}
	public String getSopecills() {
		return sopecills;
	}
	public void setSopecills(String sopecills) {
		this.sopecills = sopecills;
	}
	public String getSmecimemberid() {
		return smecimemberid;
	}
	public void setSmecimemberid(String smecimemberid) {
		this.smecimemberid = smecimemberid;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSopecid() {
		return sopecid;
	}
	public void setSopecid(String sopecid) {
		this.sopecid = sopecid;
	}
	public String getSopeccustomerid() {
		return sopeccustomerid;
	}
	public void setSopeccustomerid(String sopeccustomerid) {
		this.sopeccustomerid = sopeccustomerid;
	}
	public String getSopecshopcode() {
		return sopecshopcode;
	}
	public void setSopecshopcode(String sopecshopcode) {
		this.sopecshopcode = sopecshopcode;
	}
	public String getSopecsurfaceeyeod() {
		return sopecsurfaceeyeod;
	}
	public void setSopecsurfaceeyeod(String sopecsurfaceeyeod) {
		this.sopecsurfaceeyeod = sopecsurfaceeyeod;
	}
	public String getSopecsurfaceeyeos() {
		return sopecsurfaceeyeos;
	}
	public void setSopecsurfaceeyeos(String sopecsurfaceeyeos) {
		this.sopecsurfaceeyeos = sopecsurfaceeyeos;
	}
	public String getSopeccongestiveod() {
		return sopeccongestiveod;
	}
	public void setSopeccongestiveod(String sopeccongestiveod) {
		this.sopeccongestiveod = sopeccongestiveod;
	}
	public String getSopeccongestiveos() {
		return sopeccongestiveos;
	}
	public void setSopeccongestiveos(String sopeccongestiveos) {
		this.sopeccongestiveos = sopeccongestiveos;
	}
	public String getSopecnippleod() {
		return sopecnippleod;
	}
	public void setSopecnippleod(String sopecnippleod) {
		this.sopecnippleod = sopecnippleod;
	}
	public String getSopecnippleos() {
		return sopecnippleos;
	}
	public void setSopecnippleos(String sopecnippleos) {
		this.sopecnippleos = sopecnippleos;
	}
	public String getSopeccornealod() {
		return sopeccornealod;
	}
	public void setSopeccornealod(String sopeccornealod) {
		this.sopeccornealod = sopeccornealod;
	}
	public String getSopeccornealos() {
		return sopeccornealos;
	}
	public void setSopeccornealos(String sopeccornealos) {
		this.sopeccornealos = sopeccornealos;
	}
	public String getSopechyphemaod() {
		return sopechyphemaod;
	}
	public void setSopechyphemaod(String sopechyphemaod) {
		this.sopechyphemaod = sopechyphemaod;
	}
	public String getSopechyphemaos() {
		return sopechyphemaos;
	}
	public void setSopechyphemaos(String sopechyphemaos) {
		this.sopechyphemaos = sopechyphemaos;
	}
	public String getSopecirisod() {
		return sopecirisod;
	}
	public void setSopecirisod(String sopecirisod) {
		this.sopecirisod = sopecirisod;
	}
	public String getSopecirisos() {
		return sopecirisos;
	}
	public void setSopecirisos(String sopecirisos) {
		this.sopecirisos = sopecirisos;
	}
	public String getSopeccrystalod() {
		return sopeccrystalod;
	}
	public void setSopeccrystalod(String sopeccrystalod) {
		this.sopeccrystalod = sopeccrystalod;
	}
	public String getSopeccrystalos() {
		return sopeccrystalos;
	}
	public void setSopeccrystalos(String sopeccrystalos) {
		this.sopeccrystalos = sopeccrystalos;
	}
	public String getSopecfundusod() {
		return sopecfundusod;
	}
	public void setSopecfundusod(String sopecfundusod) {
		this.sopecfundusod = sopecfundusod;
	}
	public String getSopecfundusos() {
		return sopecfundusos;
	}
	public void setSopecfundusos(String sopecfundusos) {
		this.sopecfundusos = sopecfundusos;
	}
	public String getSopeccampaignod() {
		return sopeccampaignod;
	}
	public void setSopeccampaignod(String sopeccampaignod) {
		this.sopeccampaignod = sopeccampaignod;
	}
	public String getSopeccampaignos() {
		return sopeccampaignos;
	}
	public void setSopeccampaignos(String sopeccampaignos) {
		this.sopeccampaignos = sopeccampaignos;
	}
	public String getSopeccolorod() {
		return sopeccolorod;
	}
	public void setSopeccolorod(String sopeccolorod) {
		this.sopeccolorod = sopeccolorod;
	}
	public String getSopeccoloros() {
		return sopeccoloros;
	}
	public void setSopeccoloros(String sopeccoloros) {
		this.sopeccoloros = sopeccoloros;
	}
	public String getSopeciopod() {
		return sopeciopod;
	}
	public void setSopeciopod(String sopeciopod) {
		this.sopeciopod = sopeciopod;
	}
	public String getSopeciopos() {
		return sopeciopos;
	}
	public void setSopeciopos(String sopeciopos) {
		this.sopeciopos = sopeciopos;
	}
	public String getSopecpersonid() {
		return sopecpersonid;
	}
	public void setSopecpersonid(String sopecpersonid) {
		this.sopecpersonid = sopecpersonid;
	}
	public String getSopecpersonname() {
		return sopecpersonname;
	}
	public void setSopecpersonname(String sopecpersonname) {
		this.sopecpersonname = sopecpersonname;
	}
	public String getSopecpersondepartment() {
		return sopecpersondepartment;
	}
	public void setSopecpersondepartment(String sopecpersondepartment) {
		this.sopecpersondepartment = sopecpersondepartment;
	}
	public String getSopecvisiontime() {
		return sopecvisiontime;
	}
	public void setSopecvisiontime(String sopecvisiontime) {
		this.sopecvisiontime = sopecvisiontime;
	}
	public String getSopeccustomername() {
		return sopeccustomername;
	}
	public void setSopeccustomername(String sopeccustomername) {
		this.sopeccustomername = sopeccustomername;
	}
	public String getSopeccustomerpostcode() {
		return sopeccustomerpostcode;
	}
	public void setSopeccustomerpostcode(String sopeccustomerpostcode) {
		this.sopeccustomerpostcode = sopeccustomerpostcode;
	}
	public String getSopeccustomersex() {
		return sopeccustomersex;
	}
	public void setSopeccustomersex(String sopeccustomersex) {
		this.sopeccustomersex = sopeccustomersex;
	}
	public String getSopeccustomerage() {
		return sopeccustomerage;
	}
	public void setSopeccustomerage(String sopeccustomerage) {
		this.sopeccustomerage = sopeccustomerage;
	}
	public String getSopeccustomerphone() {
		return sopeccustomerphone;
	}
	public void setSopeccustomerphone(String sopeccustomerphone) {
		this.sopeccustomerphone = sopeccustomerphone;
	}
	public String getSopectearosod() {
		return sopectearosod;
	}
	public void setSopectearosod(String sopectearosod) {
		this.sopectearosod = sopectearosod;
	}
	public String getSopectearosos() {
		return sopectearosos;
	}
	public void setSopectearosos(String sopectearosos) {
		this.sopectearosos = sopectearosos;
	}
	public String getSopeciopselod() {
		return sopeciopselod;
	}
	public void setSopeciopselod(String sopeciopselod) {
		this.sopeciopselod = sopeciopselod;
	}
	public String getSopeciopselos() {
		return sopeciopselos;
	}
	public void setSopeciopselos(String sopeciopselos) {
		this.sopeciopselos = sopeciopselos;
	}
	public String getSopdeclosehetelevel() {
		return sopdeclosehetelevel;
	}
	public void setSopdeclosehetelevel(String sopdeclosehetelevel) {
		this.sopdeclosehetelevel = sopdeclosehetelevel;
	}
	public String getSopdeclosehetelevelio() {
		return sopdeclosehetelevelio;
	}
	public void setSopdeclosehetelevelio(String sopdeclosehetelevelio) {
		this.sopdeclosehetelevelio = sopdeclosehetelevelio;
	}
	public String getSopdecloseheteuprightness() {
		return sopdecloseheteuprightness;
	}
	public void setSopdecloseheteuprightness(String sopdecloseheteuprightness) {
		this.sopdecloseheteuprightness = sopdecloseheteuprightness;
	}
	public String getSopdecloseheteuprightnessud() {
		return sopdecloseheteuprightnessud;
	}
	public void setSopdecloseheteuprightnessud(String sopdecloseheteuprightnessud) {
		this.sopdecloseheteuprightnessud = sopdecloseheteuprightnessud;
	}
	public String getSopdefarhetelevel() {
		return sopdefarhetelevel;
	}
	public void setSopdefarhetelevel(String sopdefarhetelevel) {
		this.sopdefarhetelevel = sopdefarhetelevel;
	}
	public String getSopdefarhetelevelio() {
		return sopdefarhetelevelio;
	}
	public void setSopdefarhetelevelio(String sopdefarhetelevelio) {
		this.sopdefarhetelevelio = sopdefarhetelevelio;
	}
	public String getSopdefarheteuprightness() {
		return sopdefarheteuprightness;
	}
	public void setSopdefarheteuprightness(String sopdefarheteuprightness) {
		this.sopdefarheteuprightness = sopdefarheteuprightness;
	}
	public String getSopdefarheteuprightnessud() {
		return sopdefarheteuprightnessud;
	}
	public void setSopdefarheteuprightnessud(String sopdefarheteuprightnessud) {
		this.sopdefarheteuprightnessud = sopdefarheteuprightnessud;
	}
	public String getSopecillstype() {
		return sopecillstype;
	}
	public void setSopecillstype(String sopecillstype) {
		this.sopecillstype = sopecillstype;
	}
	public String getSopecillsConent() {
		return sopecillsConent;
	}
	public void setSopecillsConent(String sopecillsConent) {
		this.sopecillsConent = sopecillsConent;
	}

}
