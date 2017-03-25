package com.pengsheng.eims.bjtrhistory.persistence;

public class HealthCheckPo {

	private String sophcid;// 主键
	private String sophccustomerid;// 顾客id
	private String sophcoptometrybasicid;// 验光基表id
	private String sophcoptometryid;// 验光号
	private String sophccorneacurvatureods1;// 角膜曲率右眼s1
	private String sophccorneacurvatureods2;// 角膜曲率右眼s2
	private String sophccorneacurvatureodf1;// 角膜曲率右眼f1
	private String sophccorneacurvatureodf2;// 角膜曲率右眼f2
	private String sophccorneacurvatureoss1;// 角膜曲率左眼s1
	private String sophccorneacurvatureoss2;// 角膜曲率左眼s2
	private String sophccorneacurvatureosf1;// 角膜曲率左眼f1
	private String sophccorneacurvatureosf2;// 角膜曲率左眼f2
	private String sophceyeaxisod;// 右眼眼轴
	private String sophceyeaxisos;// 左眼眼轴
	private String sophcanteriorchamberdeepod;// 右眼前房深
	private String sophcanteriorchamberdeepos;// 左眼前房深
	private String sophclensthicknessod;// 右眼晶状体厚度
	private String sophclensthicknessos;// 左眼晶状体厚度
	private String sophcvitreouscavitylengthod;// 右眼玻璃体腔长度
	private String sophcvitreouscavitylengthos;// 左眼玻璃体腔长度
	private String sophccornealthicknessod;// 右眼角膜厚度
	private String sophccornealthicknessos;// 左眼角膜厚度
	private String sophctopographyfkod;// 右眼角膜地形图-fk
	private String sophctopographyfkos;// 左眼角膜地形图-fk
	private String sophctopographyskod;// 右眼角膜地形图-sk
	private String sophctopographyskos;// 左眼角膜地形图-sk
	private String sophctopographyastod;// 右眼角膜地形图-ast
	private String sophctopographyastos;// 左眼角膜地形图-ast
	private String sophctopographyeod;// 右眼角膜地形图-e值
	private String sophctopographyeos;// 左眼角膜地形图-e值
	private String sophctopographysaiod;// 右眼角膜地形图-sai
	private String sophctopographysaios;// 左眼角膜地形图-sai
	private String sophctopographysriod;// 右眼角膜地形图-sri
	private String sophctopographysrios;// 左眼角膜地形图-sri
	private String sophctearfilmgradeod1;// 右眼泪膜检测分级1
	private String sophctearfilmgradeod2;// 右眼泪膜检测分级2
	private String sophctearfilmgradeos1;// 左眼泪膜检测分级1
	private String sophctearfilmgradeos2;// 左眼泪膜检测分级2
	private String sophctearfilmod;// 右眼泪膜检测分级
	private String sophctearfilmos;// 左眼泪膜检测分级
	private String sophccontrastsensitivityod;// 右眼对比敏感度检查
	private String sophccontrastsensitivityos;// 左眼对比敏感度检查
	private String sophcaberrationod;// 右眼像差检查
	private String sophcaberrationos;// 左眼像差检查
	private String sophcdynamicadjustmentod;// 右眼动态调节检查
	private String sophcdynamicadjustmentos;// 左眼动态调节检查
	private String sophcchecktime;// 检查时间
	private String sophcchecker; //检查人sxh2011-5-19
	private String sophcschirme5od;			//schirme5od
	private String sophcschirme5os;			//schirme5os
	private String sophcbu7od;				//bu7od
	private String sophcbu7os;				//bu7os
	private String sophcthicknessod;		//细胞密度od
	private String sophcthicknessos;		//细胞密度os
	private String sophcareaod;				//平均细胞面积od
	private String sophcareaos;				//平均细胞面积os
	private String sophcscaleod;			//云边细胞比例od
	private String sophcscaleos;			//云边细胞比例os
	private String sophcvariationod;		//变异系数od
	private String sophcvariationos;		//变异系数os
	private String sophcplyod;				//角膜厚度od
	private String sophcplyos;				//角膜厚度os
	private String sophccorneadiameterod;	//角膜直径od
	private String sophccorneadiameteros;	//角膜直径os
	public String getSophcvariationod() {
		return sophcvariationod;
	}
	public void setSophcvariationod(String sophcvariationod) {
		this.sophcvariationod = sophcvariationod;
	}
	public String getSophcvariationos() {
		return sophcvariationos;
	}
	public void setSophcvariationos(String sophcvariationos) {
		this.sophcvariationos = sophcvariationos;
	}
	public String getSophcplyos() {
		return sophcplyos;
	}
	public void setSophcplyos(String sophcplyos) {
		this.sophcplyos = sophcplyos;
	}
	public String getSophcchecker() {
		return sophcchecker;
	}
	public String getSophcschirme5od() {
		return sophcschirme5od;
	}
	public void setSophcschirme5od(String sophcschirme5od) {
		this.sophcschirme5od = sophcschirme5od;
	}
	public String getSophcschirme5os() {
		return sophcschirme5os;
	}
	public void setSophcschirme5os(String sophcschirme5os) {
		this.sophcschirme5os = sophcschirme5os;
	}
	public String getSophcbu7od() {
		return sophcbu7od;
	}
	public void setSophcbu7od(String sophcbu7od) {
		this.sophcbu7od = sophcbu7od;
	}
	public String getSophcbu7os() {
		return sophcbu7os;
	}
	public void setSophcbu7os(String sophcbu7os) {
		this.sophcbu7os = sophcbu7os;
	}
	public String getSophcthicknessod() {
		return sophcthicknessod;
	}
	public void setSophcthicknessod(String sophcthicknessod) {
		this.sophcthicknessod = sophcthicknessod;
	}
	public String getSophcthicknessos() {
		return sophcthicknessos;
	}
	public void setSophcthicknessos(String sophcthicknessos) {
		this.sophcthicknessos = sophcthicknessos;
	}
	public String getSophcareaod() {
		return sophcareaod;
	}
	public void setSophcareaod(String sophcareaod) {
		this.sophcareaod = sophcareaod;
	}
	public String getSophcareaos() {
		return sophcareaos;
	}
	public void setSophcareaos(String sophcareaos) {
		this.sophcareaos = sophcareaos;
	}
	public String getSophcscaleod() {
		return sophcscaleod;
	}
	public void setSophcscaleod(String sophcscaleod) {
		this.sophcscaleod = sophcscaleod;
	}
	public String getSophcscaleos() {
		return sophcscaleos;
	}
	public void setSophcscaleos(String sophcscaleos) {
		this.sophcscaleos = sophcscaleos;
	}
	public String getSophcplyod() {
		return sophcplyod;
	}
	public void setSophcplyod(String sophcplyod) {
		this.sophcplyod = sophcplyod;
	}
	public void setSophcchecker(String sophcchecker) {
		this.sophcchecker = sophcchecker;
	}
	public String getSophcid() {
		return sophcid;
	}
	public void setSophcid(String sophcid) {
		this.sophcid = sophcid;
	}
	public String getSophccustomerid() {
		return sophccustomerid;
	}
	public void setSophccustomerid(String sophccustomerid) {
		this.sophccustomerid = sophccustomerid;
	}
	public String getSophcoptometrybasicid() {
		return sophcoptometrybasicid;
	}
	public void setSophcoptometrybasicid(String sophcoptometrybasicid) {
		this.sophcoptometrybasicid = sophcoptometrybasicid;
	}
	public String getSophcoptometryid() {
		return sophcoptometryid;
	}
	public void setSophcoptometryid(String sophcoptometryid) {
		this.sophcoptometryid = sophcoptometryid;
	}
	public String getSophccorneacurvatureods1() {
		return sophccorneacurvatureods1;
	}
	public void setSophccorneacurvatureods1(String sophccorneacurvatureods1) {
		this.sophccorneacurvatureods1 = sophccorneacurvatureods1;
	}
	public String getSophccorneacurvatureods2() {
		return sophccorneacurvatureods2;
	}
	public void setSophccorneacurvatureods2(String sophccorneacurvatureods2) {
		this.sophccorneacurvatureods2 = sophccorneacurvatureods2;
	}
	public String getSophccorneacurvatureodf1() {
		return sophccorneacurvatureodf1;
	}
	public void setSophccorneacurvatureodf1(String sophccorneacurvatureodf1) {
		this.sophccorneacurvatureodf1 = sophccorneacurvatureodf1;
	}
	public String getSophccorneacurvatureodf2() {
		return sophccorneacurvatureodf2;
	}
	public void setSophccorneacurvatureodf2(String sophccorneacurvatureodf2) {
		this.sophccorneacurvatureodf2 = sophccorneacurvatureodf2;
	}
	public String getSophccorneacurvatureoss1() {
		return sophccorneacurvatureoss1;
	}
	public void setSophccorneacurvatureoss1(String sophccorneacurvatureoss1) {
		this.sophccorneacurvatureoss1 = sophccorneacurvatureoss1;
	}
	public String getSophccorneacurvatureoss2() {
		return sophccorneacurvatureoss2;
	}
	public void setSophccorneacurvatureoss2(String sophccorneacurvatureoss2) {
		this.sophccorneacurvatureoss2 = sophccorneacurvatureoss2;
	}
	public String getSophccorneacurvatureosf1() {
		return sophccorneacurvatureosf1;
	}
	public void setSophccorneacurvatureosf1(String sophccorneacurvatureosf1) {
		this.sophccorneacurvatureosf1 = sophccorneacurvatureosf1;
	}
	public String getSophccorneacurvatureosf2() {
		return sophccorneacurvatureosf2;
	}
	public void setSophccorneacurvatureosf2(String sophccorneacurvatureosf2) {
		this.sophccorneacurvatureosf2 = sophccorneacurvatureosf2;
	}
	public String getSophceyeaxisod() {
		return sophceyeaxisod;
	}
	public void setSophceyeaxisod(String sophceyeaxisod) {
		this.sophceyeaxisod = sophceyeaxisod;
	}
	public String getSophceyeaxisos() {
		return sophceyeaxisos;
	}
	public void setSophceyeaxisos(String sophceyeaxisos) {
		this.sophceyeaxisos = sophceyeaxisos;
	}
	public String getSophcanteriorchamberdeepod() {
		return sophcanteriorchamberdeepod;
	}
	public void setSophcanteriorchamberdeepod(String sophcanteriorchamberdeepod) {
		this.sophcanteriorchamberdeepod = sophcanteriorchamberdeepod;
	}
	public String getSophcanteriorchamberdeepos() {
		return sophcanteriorchamberdeepos;
	}
	public void setSophcanteriorchamberdeepos(String sophcanteriorchamberdeepos) {
		this.sophcanteriorchamberdeepos = sophcanteriorchamberdeepos;
	}
	public String getSophclensthicknessod() {
		return sophclensthicknessod;
	}
	public void setSophclensthicknessod(String sophclensthicknessod) {
		this.sophclensthicknessod = sophclensthicknessod;
	}
	public String getSophclensthicknessos() {
		return sophclensthicknessos;
	}
	public void setSophclensthicknessos(String sophclensthicknessos) {
		this.sophclensthicknessos = sophclensthicknessos;
	}
	public String getSophcvitreouscavitylengthod() {
		return sophcvitreouscavitylengthod;
	}
	public void setSophcvitreouscavitylengthod(String sophcvitreouscavitylengthod) {
		this.sophcvitreouscavitylengthod = sophcvitreouscavitylengthod;
	}
	public String getSophcvitreouscavitylengthos() {
		return sophcvitreouscavitylengthos;
	}
	public void setSophcvitreouscavitylengthos(String sophcvitreouscavitylengthos) {
		this.sophcvitreouscavitylengthos = sophcvitreouscavitylengthos;
	}
	public String getSophccornealthicknessod() {
		return sophccornealthicknessod;
	}
	public void setSophccornealthicknessod(String sophccornealthicknessod) {
		this.sophccornealthicknessod = sophccornealthicknessod;
	}
	public String getSophccornealthicknessos() {
		return sophccornealthicknessos;
	}
	public void setSophccornealthicknessos(String sophccornealthicknessos) {
		this.sophccornealthicknessos = sophccornealthicknessos;
	}
	public String getSophctopographyfkod() {
		return sophctopographyfkod;
	}
	public void setSophctopographyfkod(String sophctopographyfkod) {
		this.sophctopographyfkod = sophctopographyfkod;
	}
	public String getSophctopographyfkos() {
		return sophctopographyfkos;
	}
	public void setSophctopographyfkos(String sophctopographyfkos) {
		this.sophctopographyfkos = sophctopographyfkos;
	}
	public String getSophctopographyskod() {
		return sophctopographyskod;
	}
	public void setSophctopographyskod(String sophctopographyskod) {
		this.sophctopographyskod = sophctopographyskod;
	}
	public String getSophctopographyskos() {
		return sophctopographyskos;
	}
	public void setSophctopographyskos(String sophctopographyskos) {
		this.sophctopographyskos = sophctopographyskos;
	}
	public String getSophctopographyastod() {
		return sophctopographyastod;
	}
	public void setSophctopographyastod(String sophctopographyastod) {
		this.sophctopographyastod = sophctopographyastod;
	}
	public String getSophctopographyastos() {
		return sophctopographyastos;
	}
	public void setSophctopographyastos(String sophctopographyastos) {
		this.sophctopographyastos = sophctopographyastos;
	}
	public String getSophctopographyeod() {
		return sophctopographyeod;
	}
	public void setSophctopographyeod(String sophctopographyeod) {
		this.sophctopographyeod = sophctopographyeod;
	}
	public String getSophctopographyeos() {
		return sophctopographyeos;
	}
	public void setSophctopographyeos(String sophctopographyeos) {
		this.sophctopographyeos = sophctopographyeos;
	}
	public String getSophctopographysaiod() {
		return sophctopographysaiod;
	}
	public void setSophctopographysaiod(String sophctopographysaiod) {
		this.sophctopographysaiod = sophctopographysaiod;
	}
	public String getSophctopographysaios() {
		return sophctopographysaios;
	}
	public void setSophctopographysaios(String sophctopographysaios) {
		this.sophctopographysaios = sophctopographysaios;
	}
	public String getSophctopographysriod() {
		return sophctopographysriod;
	}
	public void setSophctopographysriod(String sophctopographysriod) {
		this.sophctopographysriod = sophctopographysriod;
	}
	public String getSophctopographysrios() {
		return sophctopographysrios;
	}
	public void setSophctopographysrios(String sophctopographysrios) {
		this.sophctopographysrios = sophctopographysrios;
	}
	public String getSophctearfilmgradeod1() {
		return sophctearfilmgradeod1;
	}
	public void setSophctearfilmgradeod1(String sophctearfilmgradeod1) {
		this.sophctearfilmgradeod1 = sophctearfilmgradeod1;
	}
	public String getSophctearfilmgradeod2() {
		return sophctearfilmgradeod2;
	}
	public void setSophctearfilmgradeod2(String sophctearfilmgradeod2) {
		this.sophctearfilmgradeod2 = sophctearfilmgradeod2;
	}
	public String getSophctearfilmgradeos1() {
		return sophctearfilmgradeos1;
	}
	public void setSophctearfilmgradeos1(String sophctearfilmgradeos1) {
		this.sophctearfilmgradeos1 = sophctearfilmgradeos1;
	}
	public String getSophctearfilmgradeos2() {
		return sophctearfilmgradeos2;
	}
	public void setSophctearfilmgradeos2(String sophctearfilmgradeos2) {
		this.sophctearfilmgradeos2 = sophctearfilmgradeos2;
	}
	public String getSophctearfilmod() {
		return sophctearfilmod;
	}
	public void setSophctearfilmod(String sophctearfilmod) {
		this.sophctearfilmod = sophctearfilmod;
	}
	public String getSophctearfilmos() {
		return sophctearfilmos;
	}
	public void setSophctearfilmos(String sophctearfilmos) {
		this.sophctearfilmos = sophctearfilmos;
	}
	public String getSophccontrastsensitivityod() {
		return sophccontrastsensitivityod;
	}
	public void setSophccontrastsensitivityod(String sophccontrastsensitivityod) {
		this.sophccontrastsensitivityod = sophccontrastsensitivityod;
	}
	public String getSophccontrastsensitivityos() {
		return sophccontrastsensitivityos;
	}
	public void setSophccontrastsensitivityos(String sophccontrastsensitivityos) {
		this.sophccontrastsensitivityos = sophccontrastsensitivityos;
	}
	public String getSophcaberrationod() {
		return sophcaberrationod;
	}
	public void setSophcaberrationod(String sophcaberrationod) {
		this.sophcaberrationod = sophcaberrationod;
	}
	public String getSophcaberrationos() {
		return sophcaberrationos;
	}
	public void setSophcaberrationos(String sophcaberrationos) {
		this.sophcaberrationos = sophcaberrationos;
	}
	public String getSophcdynamicadjustmentod() {
		return sophcdynamicadjustmentod;
	}
	public void setSophcdynamicadjustmentod(String sophcdynamicadjustmentod) {
		this.sophcdynamicadjustmentod = sophcdynamicadjustmentod;
	}
	public String getSophcdynamicadjustmentos() {
		return sophcdynamicadjustmentos;
	}
	public void setSophcdynamicadjustmentos(String sophcdynamicadjustmentos) {
		this.sophcdynamicadjustmentos = sophcdynamicadjustmentos;
	}
	public String getSophcchecktime() {
		return sophcchecktime;
	}
	public void setSophcchecktime(String sophcchecktime) {
		this.sophcchecktime = sophcchecktime;
	}
	public String getSophccorneadiameterod() {
		return sophccorneadiameterod;
	}
	public void setSophccorneadiameterod(String sophccorneadiameterod) {
		this.sophccorneadiameterod = sophccorneadiameterod;
	}
	public String getSophccorneadiameteros() {
		return sophccorneadiameteros;
	}
	public void setSophccorneadiameteros(String sophccorneadiameteros) {
		this.sophccorneadiameteros = sophccorneadiameteros;
	}
	
	
	
	

}
