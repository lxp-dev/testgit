package com.pengsheng.eims.hydsycasehistory.persistence;

public class CornealContactlLensPo {
	private String sopclid							;	//主键
	private String sopclcustomerid                  ;	//顾客主键
	private String sopcloptometrybasicid            ;	//验光基表ID
	private String sopcloptometryid                 ;	//验光基表2ID
	private String sopcltakevaod                    ;	//带镜视力
	private String sopcltakevaos                    ;	//带镜视力
	private String sopcltakeaddod                   ;	//带镜追加
	private String sopcltakeaddos                   ;	//带镜追加
	private String sopcltakeaddvaod                 ;   //带镜追加视力
	private String sopcltakeaddvaos                 ;   //带镜追加视力
	private String sopclwhereod                     ;   //定位
	private String sopclwhereos                     ;   //
	private String sopclmoveod                      ;   //活动度
	private String sopclmoveos                      ;   //
	private String sopcldetakevaod                  ;   //摘镜视力
	private String sopcldetakevaos                  ;   //
	private String sopcldetakeaddod                 ;   //摘镜视力追加
	private String sopcldetakeaddos                 ;   //
	private String sopcldetakeaddvaod               ;   //摘镜追加视力
	private String sopcldetakeaddvaos               ;   //
	private String sopcleyemod                      ;   //角膜
	private String sopcleyemos                      ;   //
	private String sopcleyejmod                     ;   //洁膜
	private String sopcleyejmos                     ;   //
	private String sopclotherod                     ;   //其他
	private String sopclotheros                     ;   //
	private String sopclremarkod                    ;   //备注
	private String sopclremarkos                    ;   //
	private String sopclhealthtype                  ;   //健康状态
	private String sopclhealth                      ;   //健康类型
	
	//角膜接触镜复查，增加主诉
	private String sopclsay                      		;
	
	//角膜接触镜复查，增加视力检查  裸眼/矫正 区分左右眼
	private String sopclluoyanod						;
	private String sopclluoyanos						;
	private String sopcljiaozhengod						;
	private String sopcljiaozhengos						;
	
	//角膜接触镜复查，眼部检查中，结膜，角膜后面增加输入框
	private String sopcleyejmtextod                     ;   //洁膜
	private String sopcleyejmtextos                     ;   //
	private String sopcleyemtextod                      ;   //角膜
	private String sopcleyemtextos                      ;   //
	
	//角膜接触镜复查，镜片检查后面增加下拉选择，内容为：正常、划痕、蛋白沉积、碎裂、变形。下拉后面增加输入框
	private String sopclcheckglass;
	private String sopclcheckglasstext;
	
	//角膜接触镜复查，增加复诊时间(复诊的时间让大夫自己在输入框里面填写)
	private String sopclcheckagaindate;
	
	//角膜接触镜复查，停戴改为停戴多少天（停戴，输入框，天）
	private String sopclstoptakeday;
	
	//角膜接触镜复查，增加其他检查，输入框
	private String sopclotherchecktext;
	
	//角膜接触镜复查，增加处置，输入框
	private String sopcldotext;
	
	public String getSopcldotext() {
		return sopcldotext;
	}
	public void setSopcldotext(String sopcldotext) {
		this.sopcldotext = sopcldotext;
	}
	public String getSopclsay() {
		return sopclsay;
	}
	public void setSopclsay(String sopclsay) {
		this.sopclsay = sopclsay;
	}
	public String getSopclluoyanod() {
		return sopclluoyanod;
	}
	public void setSopclluoyanod(String sopclluoyanod) {
		this.sopclluoyanod = sopclluoyanod;
	}
	public String getSopclluoyanos() {
		return sopclluoyanos;
	}
	public void setSopclluoyanos(String sopclluoyanos) {
		this.sopclluoyanos = sopclluoyanos;
	}
	public String getSopcljiaozhengod() {
		return sopcljiaozhengod;
	}
	public void setSopcljiaozhengod(String sopcljiaozhengod) {
		this.sopcljiaozhengod = sopcljiaozhengod;
	}
	public String getSopcljiaozhengos() {
		return sopcljiaozhengos;
	}
	public void setSopcljiaozhengos(String sopcljiaozhengos) {
		this.sopcljiaozhengos = sopcljiaozhengos;
	}
	public String getSopcleyejmtextod() {
		return sopcleyejmtextod;
	}
	public void setSopcleyejmtextod(String sopcleyejmtextod) {
		this.sopcleyejmtextod = sopcleyejmtextod;
	}
	public String getSopcleyejmtextos() {
		return sopcleyejmtextos;
	}
	public void setSopcleyejmtextos(String sopcleyejmtextos) {
		this.sopcleyejmtextos = sopcleyejmtextos;
	}
	public String getSopcleyemtextod() {
		return sopcleyemtextod;
	}
	public void setSopcleyemtextod(String sopcleyemtextod) {
		this.sopcleyemtextod = sopcleyemtextod;
	}
	public String getSopcleyemtextos() {
		return sopcleyemtextos;
	}
	public void setSopcleyemtextos(String sopcleyemtextos) {
		this.sopcleyemtextos = sopcleyemtextos;
	}
	public String getSopclcheckglass() {
		return sopclcheckglass;
	}
	public void setSopclcheckglass(String sopclcheckglass) {
		this.sopclcheckglass = sopclcheckglass;
	}
	public String getSopclcheckglasstext() {
		return sopclcheckglasstext;
	}
	public void setSopclcheckglasstext(String sopclcheckglasstext) {
		this.sopclcheckglasstext = sopclcheckglasstext;
	}
	public String getSopclcheckagaindate() {
		return sopclcheckagaindate;
	}
	public void setSopclcheckagaindate(String sopclcheckagaindate) {
		this.sopclcheckagaindate = sopclcheckagaindate;
	}
	public String getSopclstoptakeday() {
		return sopclstoptakeday;
	}
	public void setSopclstoptakeday(String sopclstoptakeday) {
		this.sopclstoptakeday = sopclstoptakeday;
	}
	public String getSopclotherchecktext() {
		return sopclotherchecktext;
	}
	public void setSopclotherchecktext(String sopclotherchecktext) {
		this.sopclotherchecktext = sopclotherchecktext;
	}
	public String getSopclid() {
		return sopclid;
	}
	public void setSopclid(String sopclid) {
		this.sopclid = sopclid;
	}
	public String getSopclcustomerid() {
		return sopclcustomerid;
	}
	public void setSopclcustomerid(String sopclcustomerid) {
		this.sopclcustomerid = sopclcustomerid;
	}
	public String getSopcloptometrybasicid() {
		return sopcloptometrybasicid;
	}
	public void setSopcloptometrybasicid(String sopcloptometrybasicid) {
		this.sopcloptometrybasicid = sopcloptometrybasicid;
	}
	public String getSopcloptometryid() {
		return sopcloptometryid;
	}
	public void setSopcloptometryid(String sopcloptometryid) {
		this.sopcloptometryid = sopcloptometryid;
	}
	public String getSopcltakevaod() {
		return sopcltakevaod;
	}
	public void setSopcltakevaod(String sopcltakevaod) {
		this.sopcltakevaod = sopcltakevaod;
	}
	public String getSopcltakevaos() {
		return sopcltakevaos;
	}
	public void setSopcltakevaos(String sopcltakevaos) {
		this.sopcltakevaos = sopcltakevaos;
	}
	public String getSopcltakeaddod() {
		return sopcltakeaddod;
	}
	public void setSopcltakeaddod(String sopcltakeaddod) {
		this.sopcltakeaddod = sopcltakeaddod;
	}
	public String getSopcltakeaddos() {
		return sopcltakeaddos;
	}
	public void setSopcltakeaddos(String sopcltakeaddos) {
		this.sopcltakeaddos = sopcltakeaddos;
	}
	public String getSopcltakeaddvaod() {
		return sopcltakeaddvaod;
	}
	public void setSopcltakeaddvaod(String sopcltakeaddvaod) {
		this.sopcltakeaddvaod = sopcltakeaddvaod;
	}
	public String getSopcltakeaddvaos() {
		return sopcltakeaddvaos;
	}
	public void setSopcltakeaddvaos(String sopcltakeaddvaos) {
		this.sopcltakeaddvaos = sopcltakeaddvaos;
	}
	public String getSopclwhereod() {
		return sopclwhereod;
	}
	public void setSopclwhereod(String sopclwhereod) {
		this.sopclwhereod = sopclwhereod;
	}
	public String getSopclwhereos() {
		return sopclwhereos;
	}
	public void setSopclwhereos(String sopclwhereos) {
		this.sopclwhereos = sopclwhereos;
	}
	public String getSopclmoveod() {
		return sopclmoveod;
	}
	public void setSopclmoveod(String sopclmoveod) {
		this.sopclmoveod = sopclmoveod;
	}
	public String getSopclmoveos() {
		return sopclmoveos;
	}
	public void setSopclmoveos(String sopclmoveos) {
		this.sopclmoveos = sopclmoveos;
	}
	public String getSopcldetakevaod() {
		return sopcldetakevaod;
	}
	public void setSopcldetakevaod(String sopcldetakevaod) {
		this.sopcldetakevaod = sopcldetakevaod;
	}
	public String getSopcldetakevaos() {
		return sopcldetakevaos;
	}
	public void setSopcldetakevaos(String sopcldetakevaos) {
		this.sopcldetakevaos = sopcldetakevaos;
	}
	public String getSopcldetakeaddod() {
		return sopcldetakeaddod;
	}
	public void setSopcldetakeaddod(String sopcldetakeaddod) {
		this.sopcldetakeaddod = sopcldetakeaddod;
	}
	public String getSopcldetakeaddos() {
		return sopcldetakeaddos;
	}
	public void setSopcldetakeaddos(String sopcldetakeaddos) {
		this.sopcldetakeaddos = sopcldetakeaddos;
	}
	public String getSopcldetakeaddvaod() {
		return sopcldetakeaddvaod;
	}
	public void setSopcldetakeaddvaod(String sopcldetakeaddvaod) {
		this.sopcldetakeaddvaod = sopcldetakeaddvaod;
	}
	public String getSopcldetakeaddvaos() {
		return sopcldetakeaddvaos;
	}
	public void setSopcldetakeaddvaos(String sopcldetakeaddvaos) {
		this.sopcldetakeaddvaos = sopcldetakeaddvaos;
	}
	public String getSopcleyemod() {
		return sopcleyemod;
	}
	public void setSopcleyemod(String sopcleyemod) {
		this.sopcleyemod = sopcleyemod;
	}
	public String getSopcleyemos() {
		return sopcleyemos;
	}
	public void setSopcleyemos(String sopcleyemos) {
		this.sopcleyemos = sopcleyemos;
	}
	public String getSopcleyejmod() {
		return sopcleyejmod;
	}
	public void setSopcleyejmod(String sopcleyejmod) {
		this.sopcleyejmod = sopcleyejmod;
	}
	public String getSopcleyejmos() {
		return sopcleyejmos;
	}
	public void setSopcleyejmos(String sopcleyejmos) {
		this.sopcleyejmos = sopcleyejmos;
	}
	public String getSopclotherod() {
		return sopclotherod;
	}
	public void setSopclotherod(String sopclotherod) {
		this.sopclotherod = sopclotherod;
	}
	public String getSopclotheros() {
		return sopclotheros;
	}
	public void setSopclotheros(String sopclotheros) {
		this.sopclotheros = sopclotheros;
	}
	public String getSopclremarkod() {
		return sopclremarkod;
	}
	public void setSopclremarkod(String sopclremarkod) {
		this.sopclremarkod = sopclremarkod;
	}
	public String getSopclremarkos() {
		return sopclremarkos;
	}
	public void setSopclremarkos(String sopclremarkos) {
		this.sopclremarkos = sopclremarkos;
	}
	public String getSopclhealthtype() {
		return sopclhealthtype;
	}
	public void setSopclhealthtype(String sopclhealthtype) {
		this.sopclhealthtype = sopclhealthtype;
	}
	public String getSopclhealth() {
		return sopclhealth;
	}
	public void setSopclhealth(String sopclhealth) {
		this.sopclhealth = sopclhealth;
	}
}
