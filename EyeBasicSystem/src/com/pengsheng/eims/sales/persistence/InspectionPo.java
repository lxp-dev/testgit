package com.pengsheng.eims.sales.persistence;

public class InspectionPo {
	private String sopipid; // ID
	private String sopiptime; // 验光时间
	private String sopipersonname;// 验光师姓名
	private String sopipcustomerid; // 顾客号
	private String sopipoptometrybasicid; // 验光基表ID
	private String sopipoptometryid; // 验光号
	private String sopipglasstype; // 处方形式           1.远用   2.近用     3.渐进    4.隐形   5.中用    6.角膜塑形    7. 视觉训练
	private String sopipballglassod; // 右眼球镜
	private String sopipballglassos; // 左眼球镜
	private String sopippostglassod; // 右眼柱镜
	private String sopippostglassos; // 左眼柱镜
	private String sopipaxesod; // 右眼轴向
	private String sopipaxesos; // 左眼轴向
	private String sopipaddod; // 右眼add
	private String sopipaddos; // 左眼add
	private String sopiparriseglassod1; // 右眼三棱镜
	private String sopiparriseglassos1; // 左眼三棱镜
	private String sopipbasisod1; // 右眼基底
	private String sopipbasisos1; // 左眼基底
	private String sopipprismod; // 右眼棱镜
	private String sopipprismos; // 左眼棱镜
	private String sopipinterhighod; // 右眼远用瞳距
	private String sopipinterhighos; // 左眼远用瞳距
	private String sopipinterdistanceod; // 右眼近用瞳距
	private String sopipinterdistanceos; // 左眼近用瞳距
	private String sopipfarvaod; // 右眼远用VA
	private String sopipfarvaos; // 左眼远用VA
	private String sopipclosevaod; // 右眼近用VA
	private String sopipclosevaos; // 左眼近用VA
	private String sopipeyecurvatureod1; // 隐形右眼曲率1
	private String sopipeyecurvatureod2; // 隐形右眼曲率2
	private String sopipeyecurvatureos1; // 隐形左眼曲率1
	private String sopipeyecurvatureos2; // 隐形左眼曲率2
	private String sopipdiameterod; // 隐形右眼直径
	private String sopipdiameteros; // 隐形左眼直径
	private String sopipconlenvaod; // 隐形右眼VA
	private String sopipconlenvaos; // 隐形左眼VA
	private String sopipcommendglasses; // 适用镜片
	private String sopipsuggestframe; // 建议镜框
	private String sopipframeheight; // 框高
	private String sopipglassmaterial; // 建议镜片材质
	private String sopiprecipetype; // 处方形式        1.远用   2.近用     3.渐进    4.隐形   5.中用    6.角膜塑形    7. 视觉训练
	private String sopipdisposemanner; // 处理方式
	private String sopipdignosisre; // 备注
	private String sopipconrecipetype; // 隐形处理方式
	private String sopipseccheckdate; // 复诊时间
	private String sopipsubvisitunit; // 复诊时间单位
	private String sopipusername; // 验光师
	private String sopipflag; // 处方保存标志(1-正式保存，0-非正式保存)
	private String sopipmiddledistance; //
	private String sopipcommendcardwater; //建议护理液
	private String sopipconlenodnum; //
	private String sopipconlenosnum; //
	private String sopipmiddlehighod;//中用瞳距
	private String sopipmiddlehighos;//中用瞳距
	private String sopipmiddlevaod;//中用VA
	private String sopipmiddlevaos;//中用VA
	private String sopipsource;//中用VA
	private String sopippupilheightod; 		//右眼瞳高
	private String sopippupilheightos;		//左眼瞳高
	private String sopipexaminedoctorname;  //推荐医师名称
	private String sopipexaminedoctor;  //推荐医师id
	private String sopiprecipetypenum; // 处方形式数量
	
	private String sopipupkod	             ;		//升K
	private String sopipupkos	             ;      //升K
	private String sopipdownkod	             ;      //陡K
	private String sopipdownkos	             ;      //陡K
	private String sopipeod	                 ;      //e值
	private String sopipeos	                 ;      //e值
	private String sopipcornealdiameterod	 ;      //角膜直径
	private String sopipcornealdiameteros	 ;      //角膜直径
	private String sopipk0od	             ;      //试戴片K
	private String sopipk0os	             ;      //试戴片K
	private String sopipk1od	             ;      //K1
	private String sopipk1os	             ;      //K1
	private String sopipk2od	             ;      //K2
	private String sopipk2os	             ;      //K2
	private String sopipupcod	             ;      //光度
	private String sopipupcos	             ;      //光度
	private String sopipdowncod	             ;      //降度
	private String sopipdowncos	             ;      //降度
	private String sopiphlytype	             ;      //护理液品种
	
	private String sopipfamilytrain			;		//家庭训练
	private String sopiptrainroom			;		//训练室训练
	private String sopipneareye				;		//近视眼
	private String sopipfareye				;		//远视眼
	private String sopipastigmia			;       //散光
	private String sopipestimate			;       //双眼视功能评估
	private String sopipglasstypes			;       //框架眼镜
	private String sopiptouchglass			;		//角膜接触镜
	private String sopiptraintypes			;       //视觉训练
	private String sopiptaketype			;       //戴镜方式	
	private String sopiponeormany			;       //初验OR复验	
	private String sopipcommendglassesod; // 右眼适用镜片
	private String sopipcommendglassesos; // 左眼适用镜片
	
	public String getSopipcommendglassesod() {
		return sopipcommendglassesod;
	}

	public void setSopipcommendglassesod(String sopipcommendglassesod) {
		this.sopipcommendglassesod = sopipcommendglassesod;
	}

	public String getSopipcommendglassesos() {
		return sopipcommendglassesos;
	}

	public void setSopipcommendglassesos(String sopipcommendglassesos) {
		this.sopipcommendglassesos = sopipcommendglassesos;
	}

	public String getSopipupkod() {
		return sopipupkod;
	}

	public void setSopipupkod(String sopipupkod) {
		this.sopipupkod = sopipupkod;
	}

	public String getSopipupkos() {
		return sopipupkos;
	}

	public void setSopipupkos(String sopipupkos) {
		this.sopipupkos = sopipupkos;
	}

	public String getSopipdownkod() {
		return sopipdownkod;
	}

	public void setSopipdownkod(String sopipdownkod) {
		this.sopipdownkod = sopipdownkod;
	}

	public String getSopipdownkos() {
		return sopipdownkos;
	}

	public void setSopipdownkos(String sopipdownkos) {
		this.sopipdownkos = sopipdownkos;
	}

	public String getSopipeod() {
		return sopipeod;
	}

	public void setSopipeod(String sopipeod) {
		this.sopipeod = sopipeod;
	}

	public String getSopipeos() {
		return sopipeos;
	}

	public void setSopipeos(String sopipeos) {
		this.sopipeos = sopipeos;
	}

	public String getSopipcornealdiameterod() {
		return sopipcornealdiameterod;
	}

	public void setSopipcornealdiameterod(String sopipcornealdiameterod) {
		this.sopipcornealdiameterod = sopipcornealdiameterod;
	}

	public String getSopipcornealdiameteros() {
		return sopipcornealdiameteros;
	}

	public void setSopipcornealdiameteros(String sopipcornealdiameteros) {
		this.sopipcornealdiameteros = sopipcornealdiameteros;
	}

	public String getSopipk0od() {
		return sopipk0od;
	}

	public void setSopipk0od(String sopipk0od) {
		this.sopipk0od = sopipk0od;
	}

	public String getSopipk0os() {
		return sopipk0os;
	}

	public void setSopipk0os(String sopipk0os) {
		this.sopipk0os = sopipk0os;
	}

	public String getSopipk1od() {
		return sopipk1od;
	}

	public void setSopipk1od(String sopipk1od) {
		this.sopipk1od = sopipk1od;
	}

	public String getSopipk1os() {
		return sopipk1os;
	}

	public void setSopipk1os(String sopipk1os) {
		this.sopipk1os = sopipk1os;
	}

	public String getSopipk2od() {
		return sopipk2od;
	}

	public void setSopipk2od(String sopipk2od) {
		this.sopipk2od = sopipk2od;
	}

	public String getSopipk2os() {
		return sopipk2os;
	}

	public void setSopipk2os(String sopipk2os) {
		this.sopipk2os = sopipk2os;
	}

	public String getSopipupcod() {
		return sopipupcod;
	}

	public void setSopipupcod(String sopipupcod) {
		this.sopipupcod = sopipupcod;
	}

	public String getSopipupcos() {
		return sopipupcos;
	}

	public void setSopipupcos(String sopipupcos) {
		this.sopipupcos = sopipupcos;
	}

	public String getSopipdowncod() {
		return sopipdowncod;
	}

	public void setSopipdowncod(String sopipdowncod) {
		this.sopipdowncod = sopipdowncod;
	}

	public String getSopipdowncos() {
		return sopipdowncos;
	}

	public void setSopipdowncos(String sopipdowncos) {
		this.sopipdowncos = sopipdowncos;
	}

	public String getSopiphlytype() {
		return sopiphlytype;
	}

	public void setSopiphlytype(String sopiphlytype) {
		this.sopiphlytype = sopiphlytype;
	}

	public String getSopipfamilytrain() {
		return sopipfamilytrain;
	}

	public void setSopipfamilytrain(String sopipfamilytrain) {
		this.sopipfamilytrain = sopipfamilytrain;
	}

	public String getSopiptrainroom() {
		return sopiptrainroom;
	}

	public void setSopiptrainroom(String sopiptrainroom) {
		this.sopiptrainroom = sopiptrainroom;
	}

	public String getSopipneareye() {
		return sopipneareye;
	}

	public void setSopipneareye(String sopipneareye) {
		this.sopipneareye = sopipneareye;
	}

	public String getSopipfareye() {
		return sopipfareye;
	}

	public void setSopipfareye(String sopipfareye) {
		this.sopipfareye = sopipfareye;
	}

	public String getSopipastigmia() {
		return sopipastigmia;
	}

	public void setSopipastigmia(String sopipastigmia) {
		this.sopipastigmia = sopipastigmia;
	}

	public String getSopipestimate() {
		return sopipestimate;
	}

	public void setSopipestimate(String sopipestimate) {
		this.sopipestimate = sopipestimate;
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

	public String getSopiptaketype() {
		return sopiptaketype;
	}

	public void setSopiptaketype(String sopiptaketype) {
		this.sopiptaketype = sopiptaketype;
	}

	public String getSopiponeormany() {
		return sopiponeormany;
	}

	public void setSopiponeormany(String sopiponeormany) {
		this.sopiponeormany = sopiponeormany;
	}

	public String getSopiprecipetypenum() {
		return sopiprecipetypenum;
	}

	public void setSopiprecipetypenum(String sopiprecipetypenum) {
		this.sopiprecipetypenum = sopiprecipetypenum;
	}

	public String getSopipexaminedoctor() {
		return sopipexaminedoctor;
	}

	public void setSopipexaminedoctor(String sopipexaminedoctor) {
		this.sopipexaminedoctor = sopipexaminedoctor;
	}

	public String getSopipexaminedoctorname() {
		return sopipexaminedoctorname;
	}

	public void setSopipexaminedoctorname(String sopipexaminedoctorname) {
		this.sopipexaminedoctorname = sopipexaminedoctorname;
	}

	public String getSopippupilheightod() {
		return sopippupilheightod;
	}

	public void setSopippupilheightod(String sopippupilheightod) {
		this.sopippupilheightod = sopippupilheightod;
	}

	public String getSopippupilheightos() {
		return sopippupilheightos;
	}

	public void setSopippupilheightos(String sopippupilheightos) {
		this.sopippupilheightos = sopippupilheightos;
	}

	public String getSopipsource() {
		return sopipsource;
	}

	public void setSopipsource(String sopipsource) {
		this.sopipsource = sopipsource;
	}

	public String getSopipmiddlehighod() {
		return sopipmiddlehighod;
	}

	public void setSopipmiddlehighod(String sopipmiddlehighod) {
		this.sopipmiddlehighod = sopipmiddlehighod;
	}

	public String getSopipmiddlehighos() {
		return sopipmiddlehighos;
	}

	public void setSopipmiddlehighos(String sopipmiddlehighos) {
		this.sopipmiddlehighos = sopipmiddlehighos;
	}

	public String getSopipmiddlevaod() {
		return sopipmiddlevaod;
	}

	public void setSopipmiddlevaod(String sopipmiddlevaod) {
		this.sopipmiddlevaod = sopipmiddlevaod;
	}

	public String getSopipmiddlevaos() {
		return sopipmiddlevaos;
	}

	public void setSopipmiddlevaos(String sopipmiddlevaos) {
		this.sopipmiddlevaos = sopipmiddlevaos;
	}

	public String getSopipid() {
		return sopipid;
	}

	public void setSopipid(String sopipid) {
		this.sopipid = sopipid;
	}

	public String getSopiptime() {
		return sopiptime;
	}

	public void setSopiptime(String sopiptime) {
		this.sopiptime = sopiptime;
	}

	public String getSopipersonname() {
		return sopipersonname;
	}

	public void setSopipersonname(String sopipersonname) {
		this.sopipersonname = sopipersonname;
	}

	public String getSopipcustomerid() {
		return sopipcustomerid;
	}

	public void setSopipcustomerid(String sopipcustomerid) {
		this.sopipcustomerid = sopipcustomerid;
	}

	public String getSopipoptometrybasicid() {
		return sopipoptometrybasicid;
	}

	public void setSopipoptometrybasicid(String sopipoptometrybasicid) {
		this.sopipoptometrybasicid = sopipoptometrybasicid;
	}

	public String getSopipoptometryid() {
		return sopipoptometryid;
	}

	public void setSopipoptometryid(String sopipoptometryid) {
		this.sopipoptometryid = sopipoptometryid;
	}

	public String getSopipglasstype() {
		return sopipglasstype;
	}

	public void setSopipglasstype(String sopipglasstype) {
		this.sopipglasstype = sopipglasstype;
	}

	public String getSopipballglassod() {
		return sopipballglassod;
	}

	public void setSopipballglassod(String sopipballglassod) {
		this.sopipballglassod = sopipballglassod;
	}

	public String getSopipballglassos() {
		return sopipballglassos;
	}

	public void setSopipballglassos(String sopipballglassos) {
		this.sopipballglassos = sopipballglassos;
	}

	public String getSopippostglassod() {
		return sopippostglassod;
	}

	public void setSopippostglassod(String sopippostglassod) {
		this.sopippostglassod = sopippostglassod;
	}

	public String getSopippostglassos() {
		return sopippostglassos;
	}

	public void setSopippostglassos(String sopippostglassos) {
		this.sopippostglassos = sopippostglassos;
	}

	public String getSopipaxesod() {
		return sopipaxesod;
	}

	public void setSopipaxesod(String sopipaxesod) {
		this.sopipaxesod = sopipaxesod;
	}

	public String getSopipaxesos() {
		return sopipaxesos;
	}

	public void setSopipaxesos(String sopipaxesos) {
		this.sopipaxesos = sopipaxesos;
	}

	public String getSopipaddod() {
		return sopipaddod;
	}

	public void setSopipaddod(String sopipaddod) {
		this.sopipaddod = sopipaddod;
	}

	public String getSopipaddos() {
		return sopipaddos;
	}

	public void setSopipaddos(String sopipaddos) {
		this.sopipaddos = sopipaddos;
	}

	public String getSopiparriseglassod1() {
		return sopiparriseglassod1;
	}

	public void setSopiparriseglassod1(String sopiparriseglassod1) {
		this.sopiparriseglassod1 = sopiparriseglassod1;
	}

	public String getSopiparriseglassos1() {
		return sopiparriseglassos1;
	}

	public void setSopiparriseglassos1(String sopiparriseglassos1) {
		this.sopiparriseglassos1 = sopiparriseglassos1;
	}

	public String getSopipbasisod1() {
		return sopipbasisod1;
	}

	public void setSopipbasisod1(String sopipbasisod1) {
		this.sopipbasisod1 = sopipbasisod1;
	}

	public String getSopipbasisos1() {
		return sopipbasisos1;
	}

	public void setSopipbasisos1(String sopipbasisos1) {
		this.sopipbasisos1 = sopipbasisos1;
	}

	public String getSopipprismod() {
		return sopipprismod;
	}

	public void setSopipprismod(String sopipprismod) {
		this.sopipprismod = sopipprismod;
	}

	public String getSopipprismos() {
		return sopipprismos;
	}

	public void setSopipprismos(String sopipprismos) {
		this.sopipprismos = sopipprismos;
	}

	public String getSopipinterhighod() {
		return sopipinterhighod;
	}

	public void setSopipinterhighod(String sopipinterhighod) {
		this.sopipinterhighod = sopipinterhighod;
	}

	public String getSopipinterhighos() {
		return sopipinterhighos;
	}

	public void setSopipinterhighos(String sopipinterhighos) {
		this.sopipinterhighos = sopipinterhighos;
	}

	public String getSopipinterdistanceod() {
		return sopipinterdistanceod;
	}

	public void setSopipinterdistanceod(String sopipinterdistanceod) {
		this.sopipinterdistanceod = sopipinterdistanceod;
	}

	public String getSopipinterdistanceos() {
		return sopipinterdistanceos;
	}

	public void setSopipinterdistanceos(String sopipinterdistanceos) {
		this.sopipinterdistanceos = sopipinterdistanceos;
	}

	public String getSopipfarvaod() {
		return sopipfarvaod;
	}

	public void setSopipfarvaod(String sopipfarvaod) {
		this.sopipfarvaod = sopipfarvaod;
	}

	public String getSopipfarvaos() {
		return sopipfarvaos;
	}

	public void setSopipfarvaos(String sopipfarvaos) {
		this.sopipfarvaos = sopipfarvaos;
	}

	public String getSopipclosevaod() {
		return sopipclosevaod;
	}

	public void setSopipclosevaod(String sopipclosevaod) {
		this.sopipclosevaod = sopipclosevaod;
	}

	public String getSopipclosevaos() {
		return sopipclosevaos;
	}

	public void setSopipclosevaos(String sopipclosevaos) {
		this.sopipclosevaos = sopipclosevaos;
	}

	public String getSopipeyecurvatureod1() {
		return sopipeyecurvatureod1;
	}

	public void setSopipeyecurvatureod1(String sopipeyecurvatureod1) {
		this.sopipeyecurvatureod1 = sopipeyecurvatureod1;
	}

	public String getSopipeyecurvatureod2() {
		return sopipeyecurvatureod2;
	}

	public void setSopipeyecurvatureod2(String sopipeyecurvatureod2) {
		this.sopipeyecurvatureod2 = sopipeyecurvatureod2;
	}

	public String getSopipeyecurvatureos1() {
		return sopipeyecurvatureos1;
	}

	public void setSopipeyecurvatureos1(String sopipeyecurvatureos1) {
		this.sopipeyecurvatureos1 = sopipeyecurvatureos1;
	}

	public String getSopipeyecurvatureos2() {
		return sopipeyecurvatureos2;
	}

	public void setSopipeyecurvatureos2(String sopipeyecurvatureos2) {
		this.sopipeyecurvatureos2 = sopipeyecurvatureos2;
	}

	public String getSopipdiameterod() {
		return sopipdiameterod;
	}

	public void setSopipdiameterod(String sopipdiameterod) {
		this.sopipdiameterod = sopipdiameterod;
	}

	public String getSopipdiameteros() {
		return sopipdiameteros;
	}

	public void setSopipdiameteros(String sopipdiameteros) {
		this.sopipdiameteros = sopipdiameteros;
	}

	public String getSopipconlenvaod() {
		return sopipconlenvaod;
	}

	public void setSopipconlenvaod(String sopipconlenvaod) {
		this.sopipconlenvaod = sopipconlenvaod;
	}

	public String getSopipconlenvaos() {
		return sopipconlenvaos;
	}

	public void setSopipconlenvaos(String sopipconlenvaos) {
		this.sopipconlenvaos = sopipconlenvaos;
	}

	public String getSopipcommendglasses() {
		return sopipcommendglasses;
	}

	public void setSopipcommendglasses(String sopipcommendglasses) {
		this.sopipcommendglasses = sopipcommendglasses;
	}

	public String getSopipsuggestframe() {
		return sopipsuggestframe;
	}

	public void setSopipsuggestframe(String sopipsuggestframe) {
		this.sopipsuggestframe = sopipsuggestframe;
	}

	public String getSopipframeheight() {
		return sopipframeheight;
	}

	public void setSopipframeheight(String sopipframeheight) {
		this.sopipframeheight = sopipframeheight;
	}

	public String getSopipglassmaterial() {
		return sopipglassmaterial;
	}

	public void setSopipglassmaterial(String sopipglassmaterial) {
		this.sopipglassmaterial = sopipglassmaterial;
	}

	public String getSopiprecipetype() {
		return sopiprecipetype;
	}

	public void setSopiprecipetype(String sopiprecipetype) {
		this.sopiprecipetype = sopiprecipetype;
	}

	public String getSopipdisposemanner() {
		return sopipdisposemanner;
	}

	public void setSopipdisposemanner(String sopipdisposemanner) {
		this.sopipdisposemanner = sopipdisposemanner;
	}

	public String getSopipdignosisre() {
		return sopipdignosisre;
	}

	public void setSopipdignosisre(String sopipdignosisre) {
		this.sopipdignosisre = sopipdignosisre;
	}

	public String getSopipconrecipetype() {
		return sopipconrecipetype;
	}

	public void setSopipconrecipetype(String sopipconrecipetype) {
		this.sopipconrecipetype = sopipconrecipetype;
	}

	public String getSopipseccheckdate() {
		return sopipseccheckdate;
	}

	public void setSopipseccheckdate(String sopipseccheckdate) {
		this.sopipseccheckdate = sopipseccheckdate;
	}

	public String getSopipsubvisitunit() {
		return sopipsubvisitunit;
	}

	public void setSopipsubvisitunit(String sopipsubvisitunit) {
		this.sopipsubvisitunit = sopipsubvisitunit;
	}

	public String getSopipusername() {
		return sopipusername;
	}

	public void setSopipusername(String sopipusername) {
		this.sopipusername = sopipusername;
	}

	public String getSopipflag() {
		return sopipflag;
	}

	public void setSopipflag(String sopipflag) {
		this.sopipflag = sopipflag;
	}

	public String getSopipmiddledistance() {
		return sopipmiddledistance;
	}

	public void setSopipmiddledistance(String sopipmiddledistance) {
		this.sopipmiddledistance = sopipmiddledistance;
	}

	public String getSopipcommendcardwater() {
		return sopipcommendcardwater;
	}

	public void setSopipcommendcardwater(String sopipcommendcardwater) {
		this.sopipcommendcardwater = sopipcommendcardwater;
	}

	public String getSopipconlenodnum() {
		return sopipconlenodnum;
	}

	public void setSopipconlenodnum(String sopipconlenodnum) {
		this.sopipconlenodnum = sopipconlenodnum;
	}

	public String getSopipconlenosnum() {
		return sopipconlenosnum;
	}

	public void setSopipconlenosnum(String sopipconlenosnum) {
		this.sopipconlenosnum = sopipconlenosnum;
	}

}
