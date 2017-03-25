package com.pengsheng.eims.sales.persistence;

public class DoubleEyeFunPo {

	private String sopdeid; // id
	private String sopdecustomerid; // 顾客号
	private String sopdeoptometryid; // 验光号
	private String sopdeoptometryBasicid; // 验光基表号
	private String sopdefarworth; // worth 4 dot(远)
	private String sopdeaca; // ac/a
	private String sopdeacaway; // 方法
	private String sopdepdway; // 梯度法(1.00d)1
	private String sopdendway; // 梯度法(1.00d)2
	private String sopdesolidwatch; // 立体视
	private String sopdefarhetelevel; // 远隐斜水平
	private String sopdefarhetelevelio; // 远隐斜水平(内/外)
	private String sopdefarheteuprightness; // 远隐斜垂直
	private String sopdefarheteuprightnessud; // 远隐斜垂直(上/下)
	private String sopdefaramalevelp; // 水平(+)(远融合功能)
	private String sopdefaramalevelpo; // 水平(+)(远融合功能)1
	private String sopdefaramalevelpt; // 水平(+)(远融合功能)2
	private String sopdefaramaleveln; // 水平(-)(远融合功能)
	private String sopdefaramalevelno; // 水平(-)(远融合功能)1
	private String sopdefaramalevelnt; // 水平(-)(远融合功能)2
	private String sopdefaramabu; // 右bu(远融合功能注视)
	private String sopdefaramabuo; // 右bu(远融合功能注视)1
	private String sopdefaramalbu; // 左bu(远融合功能注视)
	private String sopdefaramalbuo; // 左bu(远融合功能注视)1
	private String sopdefaramabd; // 右bd(远融合功能注视)
	private String sopdefaramabdo; // 右bd(远融合功能注视)1
	private String sopdefaramalbd; // 左bd(远融合功能注视)
	private String sopdefaramalbdo; // 左bd(远融合功能注视)1
	private String sopdedifwatch; // 不等像视
	private String sopdeclosehetelevel; // 近隐斜水平
	private String sopdeclosehetelevelio; // 近隐斜水平(内/外)
	private String sopdecloseheteuprightness; // 近隐斜垂直
	private String sopdecloseheteuprightnessud; // 近隐斜垂直(上/下)
	private String sopdecloseamalevelp; // 水平(+)(近融合功能)
	private String sopdecloseamalevelpo; // 水平(+)(近融合功能)1
	private String sopdecloseamalevelpt; // 水平(+)(近融合功能)2
	private String sopdecloseamaleveln; // 水平(-)(近融合功能)
	private String sopdecloseamalevelno; // 水平(-)(近融合功能)1
	private String sopdecloseamalevelnt; // 水平(-)(近融合功能)2
	private String sopdecloseamabu; // 右bu(近融合功能注视)
	private String sopdecloseamabuo; // 右bu(近融合功能注视)1
	private String sopdecloseamalbu; // 左bu(近融合功能注视)
	private String sopdecloseamalbuo; // 左bu(近融合功能注视)1
	private String sopdecloseamabd; // 右bd(近融合功能注视)
	private String sopdecloseamabdo; // 右bd(近融合功能注视)1
	private String sopdecloseamalbd; // 左bd(近融合功能注视)
	private String sopdecloseamalbdo; // 左bd(近融合功能注视)1
	private String sopdenpc; // npc
	private String sopdeaccod; // 调节幅度od
	private String sopdeaccos; // 调节幅度os
	private String sopdeaccou; // 调节幅度ou
	private String sopdebcc; // bcc
	private String sopdepositiveaccpra; // 正/负相对调节pra
	private String sopdenegativeaccnra; // 正/负相对调节nra
	private String sopdefacility; // 辅辏近点
	private String sopdefacilityod; // 辅辏近点od
	private String sopdefacilityos; // 辅辏近点os
	private String sopdefacilityou; // 辅辏近点ou
	private String sopdeaddod; // add(od)
	private String sopdeaddos; // add(os)
	private String sopdedistance; // 工作距离
	private String sopderange; // 范围
	private String sopderangeo; // 范围1
	private String sopdeconclusiono; // 结论1
	private String sopdeconclusiont; // 结论2
	private String sopdesurggestion; // 建议
	private String sopdeaccount; // 原因
	private String sopdechecker; //操作人 sxh2011-5-19
	
	private String sopdeacaz; //AC/A值  sxh2011-5-20 begin
	private String sopdexieshi; //斜视
	private String sopderuoshi; //弱视
	private String sopdequguangbuzheng; //屈光不正
	private String sopdefeixieshixingshuangyanshiyichang; //非斜视性双眼视异常
	private String sopdekuangjiayanjing; //框架眼镜
	private String sopdeyinxingyanjing; //隐形眼镜
	private String sopderuoshixunlian; //弱视训练
	private String sopdetiaojiexunlian; //调节训练
	private String sopdefucouxunlian; //辐辏训练  end
	private String sopdeacaz1;
	private String sopdeacaf1;
	private String sopdeinspecteyefun; // 是否进行双眼视功能检查
	
	public String getSopdeinspecteyefun() {
		return sopdeinspecteyefun;
	}

	public void setSopdeinspecteyefun(String sopdeinspecteyefun) {
		this.sopdeinspecteyefun = sopdeinspecteyefun;
	}

	public String getSopdeacaz1() {
		return sopdeacaz1;
	}

	public void setSopdeacaz1(String sopdeacaz1) {
		this.sopdeacaz1 = sopdeacaz1;
	}

	public String getSopdeacaf1() {
		return sopdeacaf1;
	}

	public void setSopdeacaf1(String sopdeacaf1) {
		this.sopdeacaf1 = sopdeacaf1;
	}

	public String getSopdeacaz() {
		return sopdeacaz;
	}

	public void setSopdeacaz(String sopdeacaz) {
		this.sopdeacaz = sopdeacaz;
	}

	public String getSopdexieshi() {
		return sopdexieshi;
	}

	public void setSopdexieshi(String sopdexieshi) {
		this.sopdexieshi = sopdexieshi;
	}

	public String getSopderuoshi() {
		return sopderuoshi;
	}

	public void setSopderuoshi(String sopderuoshi) {
		this.sopderuoshi = sopderuoshi;
	}

	public String getSopdequguangbuzheng() {
		return sopdequguangbuzheng;
	}

	public void setSopdequguangbuzheng(String sopdequguangbuzheng) {
		this.sopdequguangbuzheng = sopdequguangbuzheng;
	}

	public String getSopdefeixieshixingshuangyanshiyichang() {
		return sopdefeixieshixingshuangyanshiyichang;
	}

	public void setSopdefeixieshixingshuangyanshiyichang(
			String sopdefeixieshixingshuangyanshiyichang) {
		this.sopdefeixieshixingshuangyanshiyichang = sopdefeixieshixingshuangyanshiyichang;
	}

	public String getSopdekuangjiayanjing() {
		return sopdekuangjiayanjing;
	}

	public void setSopdekuangjiayanjing(String sopdekuangjiayanjing) {
		this.sopdekuangjiayanjing = sopdekuangjiayanjing;
	}

	public String getSopdeyinxingyanjing() {
		return sopdeyinxingyanjing;
	}

	public void setSopdeyinxingyanjing(String sopdeyinxingyanjing) {
		this.sopdeyinxingyanjing = sopdeyinxingyanjing;
	}

	public String getSopderuoshixunlian() {
		return sopderuoshixunlian;
	}

	public void setSopderuoshixunlian(String sopderuoshixunlian) {
		this.sopderuoshixunlian = sopderuoshixunlian;
	}

	public String getSopdetiaojiexunlian() {
		return sopdetiaojiexunlian;
	}

	public void setSopdetiaojiexunlian(String sopdetiaojiexunlian) {
		this.sopdetiaojiexunlian = sopdetiaojiexunlian;
	}

	public String getSopdefucouxunlian() {
		return sopdefucouxunlian;
	}

	public void setSopdefucouxunlian(String sopdefucouxunlian) {
		this.sopdefucouxunlian = sopdefucouxunlian;
	}
	
	public String getSopdechecker() {
		return sopdechecker;
	}

	public void setSopdechecker(String sopdechecker) {
		this.sopdechecker = sopdechecker;
	}

	public String getSopdeaccount() {
		return sopdeaccount;
	}

	public void setSopdeaccount(String sopdeaccount) {
		this.sopdeaccount = sopdeaccount;
	}

	public String getSopdeid() {
		return sopdeid;
	}

	public void setSopdeid(String sopdeid) {
		this.sopdeid = sopdeid;
	}

	public String getSopdecustomerid() {
		return sopdecustomerid;
	}

	public void setSopdecustomerid(String sopdecustomerid) {
		this.sopdecustomerid = sopdecustomerid;
	}

	public String getSopdeoptometryid() {
		return sopdeoptometryid;
	}

	public void setSopdeoptometryid(String sopdeoptometryid) {
		this.sopdeoptometryid = sopdeoptometryid;
	}

	public String getSopdeoptometryBasicid() {
		return sopdeoptometryBasicid;
	}

	public void setSopdeoptometryBasicid(String sopdeoptometryBasicid) {
		this.sopdeoptometryBasicid = sopdeoptometryBasicid;
	}

	public String getSopdefarworth() {
		return sopdefarworth;
	}

	public void setSopdefarworth(String sopdefarworth) {
		this.sopdefarworth = sopdefarworth;
	}

	public String getSopdeaca() {
		return sopdeaca;
	}

	public void setSopdeaca(String sopdeaca) {
		this.sopdeaca = sopdeaca;
	}

	public String getSopdeacaway() {
		return sopdeacaway;
	}

	public void setSopdeacaway(String sopdeacaway) {
		this.sopdeacaway = sopdeacaway;
	}

	public String getSopdepdway() {
		return sopdepdway;
	}

	public void setSopdepdway(String sopdepdway) {
		this.sopdepdway = sopdepdway;
	}

	public String getSopdendway() {
		return sopdendway;
	}

	public void setSopdendway(String sopdendway) {
		this.sopdendway = sopdendway;
	}

	public String getSopdesolidwatch() {
		return sopdesolidwatch;
	}

	public void setSopdesolidwatch(String sopdesolidwatch) {
		this.sopdesolidwatch = sopdesolidwatch;
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

	public String getSopdefaramalevelp() {
		return sopdefaramalevelp;
	}

	public void setSopdefaramalevelp(String sopdefaramalevelp) {
		this.sopdefaramalevelp = sopdefaramalevelp;
	}

	public String getSopdefaramalevelpo() {
		return sopdefaramalevelpo;
	}

	public void setSopdefaramalevelpo(String sopdefaramalevelpo) {
		this.sopdefaramalevelpo = sopdefaramalevelpo;
	}

	public String getSopdefaramalevelpt() {
		return sopdefaramalevelpt;
	}

	public void setSopdefaramalevelpt(String sopdefaramalevelpt) {
		this.sopdefaramalevelpt = sopdefaramalevelpt;
	}

	public String getSopdefaramaleveln() {
		return sopdefaramaleveln;
	}

	public void setSopdefaramaleveln(String sopdefaramaleveln) {
		this.sopdefaramaleveln = sopdefaramaleveln;
	}

	public String getSopdefaramalevelno() {
		return sopdefaramalevelno;
	}

	public void setSopdefaramalevelno(String sopdefaramalevelno) {
		this.sopdefaramalevelno = sopdefaramalevelno;
	}

	public String getSopdefaramalevelnt() {
		return sopdefaramalevelnt;
	}

	public void setSopdefaramalevelnt(String sopdefaramalevelnt) {
		this.sopdefaramalevelnt = sopdefaramalevelnt;
	}

	public String getSopdefaramabu() {
		return sopdefaramabu;
	}

	public void setSopdefaramabu(String sopdefaramabu) {
		this.sopdefaramabu = sopdefaramabu;
	}

	public String getSopdefaramabuo() {
		return sopdefaramabuo;
	}

	public void setSopdefaramabuo(String sopdefaramabuo) {
		this.sopdefaramabuo = sopdefaramabuo;
	}

	public String getSopdefaramalbu() {
		return sopdefaramalbu;
	}

	public void setSopdefaramalbu(String sopdefaramalbu) {
		this.sopdefaramalbu = sopdefaramalbu;
	}

	public String getSopdefaramalbuo() {
		return sopdefaramalbuo;
	}

	public void setSopdefaramalbuo(String sopdefaramalbuo) {
		this.sopdefaramalbuo = sopdefaramalbuo;
	}

	public String getSopdefaramabd() {
		return sopdefaramabd;
	}

	public void setSopdefaramabd(String sopdefaramabd) {
		this.sopdefaramabd = sopdefaramabd;
	}

	public String getSopdefaramabdo() {
		return sopdefaramabdo;
	}

	public void setSopdefaramabdo(String sopdefaramabdo) {
		this.sopdefaramabdo = sopdefaramabdo;
	}

	public String getSopdefaramalbd() {
		return sopdefaramalbd;
	}

	public void setSopdefaramalbd(String sopdefaramalbd) {
		this.sopdefaramalbd = sopdefaramalbd;
	}

	public String getSopdefaramalbdo() {
		return sopdefaramalbdo;
	}

	public void setSopdefaramalbdo(String sopdefaramalbdo) {
		this.sopdefaramalbdo = sopdefaramalbdo;
	}

	public String getSopdedifwatch() {
		return sopdedifwatch;
	}

	public void setSopdedifwatch(String sopdedifwatch) {
		this.sopdedifwatch = sopdedifwatch;
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

	public void setSopdecloseheteuprightnessud(
			String sopdecloseheteuprightnessud) {
		this.sopdecloseheteuprightnessud = sopdecloseheteuprightnessud;
	}

	public String getSopdecloseamalevelp() {
		return sopdecloseamalevelp;
	}

	public void setSopdecloseamalevelp(String sopdecloseamalevelp) {
		this.sopdecloseamalevelp = sopdecloseamalevelp;
	}

	public String getSopdecloseamalevelpo() {
		return sopdecloseamalevelpo;
	}

	public void setSopdecloseamalevelpo(String sopdecloseamalevelpo) {
		this.sopdecloseamalevelpo = sopdecloseamalevelpo;
	}

	public String getSopdecloseamalevelpt() {
		return sopdecloseamalevelpt;
	}

	public void setSopdecloseamalevelpt(String sopdecloseamalevelpt) {
		this.sopdecloseamalevelpt = sopdecloseamalevelpt;
	}

	public String getSopdecloseamaleveln() {
		return sopdecloseamaleveln;
	}

	public void setSopdecloseamaleveln(String sopdecloseamaleveln) {
		this.sopdecloseamaleveln = sopdecloseamaleveln;
	}

	public String getSopdecloseamalevelno() {
		return sopdecloseamalevelno;
	}

	public void setSopdecloseamalevelno(String sopdecloseamalevelno) {
		this.sopdecloseamalevelno = sopdecloseamalevelno;
	}

	public String getSopdecloseamalevelnt() {
		return sopdecloseamalevelnt;
	}

	public void setSopdecloseamalevelnt(String sopdecloseamalevelnt) {
		this.sopdecloseamalevelnt = sopdecloseamalevelnt;
	}

	public String getSopdecloseamabu() {
		return sopdecloseamabu;
	}

	public void setSopdecloseamabu(String sopdecloseamabu) {
		this.sopdecloseamabu = sopdecloseamabu;
	}

	public String getSopdecloseamabuo() {
		return sopdecloseamabuo;
	}

	public void setSopdecloseamabuo(String sopdecloseamabuo) {
		this.sopdecloseamabuo = sopdecloseamabuo;
	}

	public String getSopdecloseamalbu() {
		return sopdecloseamalbu;
	}

	public void setSopdecloseamalbu(String sopdecloseamalbu) {
		this.sopdecloseamalbu = sopdecloseamalbu;
	}

	public String getSopdecloseamalbuo() {
		return sopdecloseamalbuo;
	}

	public void setSopdecloseamalbuo(String sopdecloseamalbuo) {
		this.sopdecloseamalbuo = sopdecloseamalbuo;
	}

	public String getSopdecloseamabd() {
		return sopdecloseamabd;
	}

	public void setSopdecloseamabd(String sopdecloseamabd) {
		this.sopdecloseamabd = sopdecloseamabd;
	}

	public String getSopdecloseamabdo() {
		return sopdecloseamabdo;
	}

	public void setSopdecloseamabdo(String sopdecloseamabdo) {
		this.sopdecloseamabdo = sopdecloseamabdo;
	}

	public String getSopdecloseamalbd() {
		return sopdecloseamalbd;
	}

	public void setSopdecloseamalbd(String sopdecloseamalbd) {
		this.sopdecloseamalbd = sopdecloseamalbd;
	}

	public String getSopdecloseamalbdo() {
		return sopdecloseamalbdo;
	}

	public void setSopdecloseamalbdo(String sopdecloseamalbdo) {
		this.sopdecloseamalbdo = sopdecloseamalbdo;
	}

	public String getSopdenpc() {
		return sopdenpc;
	}

	public void setSopdenpc(String sopdenpc) {
		this.sopdenpc = sopdenpc;
	}

	public String getSopdeaccod() {
		return sopdeaccod;
	}

	public void setSopdeaccod(String sopdeaccod) {
		this.sopdeaccod = sopdeaccod;
	}

	public String getSopdeaccos() {
		return sopdeaccos;
	}

	public void setSopdeaccos(String sopdeaccos) {
		this.sopdeaccos = sopdeaccos;
	}

	public String getSopdeaccou() {
		return sopdeaccou;
	}

	public void setSopdeaccou(String sopdeaccou) {
		this.sopdeaccou = sopdeaccou;
	}

	public String getSopdebcc() {
		return sopdebcc;
	}

	public void setSopdebcc(String sopdebcc) {
		this.sopdebcc = sopdebcc;
	}

	public String getSopdepositiveaccpra() {
		return sopdepositiveaccpra;
	}

	public void setSopdepositiveaccpra(String sopdepositiveaccpra) {
		this.sopdepositiveaccpra = sopdepositiveaccpra;
	}

	public String getSopdenegativeaccnra() {
		return sopdenegativeaccnra;
	}

	public void setSopdenegativeaccnra(String sopdenegativeaccnra) {
		this.sopdenegativeaccnra = sopdenegativeaccnra;
	}

	public String getSopdefacility() {
		return sopdefacility;
	}

	public void setSopdefacility(String sopdefacility) {
		this.sopdefacility = sopdefacility;
	}

	public String getSopdefacilityod() {
		return sopdefacilityod;
	}

	public void setSopdefacilityod(String sopdefacilityod) {
		this.sopdefacilityod = sopdefacilityod;
	}

	public String getSopdefacilityos() {
		return sopdefacilityos;
	}

	public void setSopdefacilityos(String sopdefacilityos) {
		this.sopdefacilityos = sopdefacilityos;
	}

	public String getSopdefacilityou() {
		return sopdefacilityou;
	}

	public void setSopdefacilityou(String sopdefacilityou) {
		this.sopdefacilityou = sopdefacilityou;
	}

	public String getSopdeaddod() {
		return sopdeaddod;
	}

	public void setSopdeaddod(String sopdeaddod) {
		this.sopdeaddod = sopdeaddod;
	}

	public String getSopdeaddos() {
		return sopdeaddos;
	}

	public void setSopdeaddos(String sopdeaddos) {
		this.sopdeaddos = sopdeaddos;
	}

	public String getSopdedistance() {
		return sopdedistance;
	}

	public void setSopdedistance(String sopdedistance) {
		this.sopdedistance = sopdedistance;
	}

	public String getSopderange() {
		return sopderange;
	}

	public void setSopderange(String sopderange) {
		this.sopderange = sopderange;
	}

	public String getSopderangeo() {
		return sopderangeo;
	}

	public void setSopderangeo(String sopderangeo) {
		this.sopderangeo = sopderangeo;
	}

	public String getSopdeconclusiono() {
		return sopdeconclusiono;
	}

	public void setSopdeconclusiono(String sopdeconclusiono) {
		this.sopdeconclusiono = sopdeconclusiono;
	}

	public String getSopdeconclusiont() {
		return sopdeconclusiont;
	}

	public void setSopdeconclusiont(String sopdeconclusiont) {
		this.sopdeconclusiont = sopdeconclusiont;
	}

	public String getSopdesurggestion() {
		return sopdesurggestion;
	}

	public void setSopdesurggestion(String sopdesurggestion) {
		this.sopdesurggestion = sopdesurggestion;
	}

}
