package com.pengsheng.eims.storage.persistence;

public class WorkingCheckPo {

	
	private String pchckid;// id
	private String pchcksalesid;// 销售单号
	private String pchckcokeballglassod;// 焦度计右眼球镜
	private String pchckcokeballglassos;// 焦度计左眼球镜
	private String pchckcokepostglassod;// 焦度计右眼柱镜
	private String pchckcokepostglassos;// 焦度计左眼柱镜
	private String pchckcokeaxesod;// 焦度计右眼轴向
	private String pchckcokeaxesos;// 焦度计左眼轴向
	private String pchckcokearriseglassod;// 焦度计右眼三棱镜
	private String pchckcokearriseglassos;// 焦度计左眼三棱镜
	private String pchckcokebasisod;// 焦度计右眼基底
	private String pchckcokebasisos;// 焦度计左眼基底
	private String pchckcokearriseglassod1;// 焦度计右眼三棱镜1
	private String pchckcokearriseglassos1;// 焦度计左眼三棱镜1
	private String pchckcokebasisod1;// 焦度计右眼基底1
	private String pchckcokebasisos1;// 焦度计左眼基底1
	private String pchckcokeaddod;// 焦度计右眼下加
	private String pchckcokeaddos;// 焦度计左眼下加
	private String pchckcokepupildistanceod;// 焦度计右眼瞳距
	private String pchckcokepupildistanceos;// 焦度计左眼瞳距
	private String pchckcokecentervertical;// 焦度计光心垂差
	private String pchckcenterhigh;// 光心高度 默认值√
	private String pchckcolor;// 色泽互差 默认值√
	private String pchckquality;// 装配质量 默认值√
	private String pchckshaping;// 整形 默认值√
	private String pchckgeometrycenter;// 几何中心距
	private String pchckvertexvertical;// 顶点垂差
	private String pchckvertexhigh;// 顶点高度
	private String pchckprocesspersonid;// 加工师ID
	private String pchckchecklabourid;// 检验人员ID
	private String pchckremark;// 备注
	private String pchckcheckdate;// 检验日期        
	
	private String pchckstartcheckdate;//检验start日期
	private String pchckendcheckdate;//检验end日期
	
	private String pchckprocesspersonname;//加工师姓名
	private String pchckchecklabourname;//检验人员姓名
	private String pchcktakeglasstime;//取镜日期
	private String pchckcustomername;//顾客姓名
	
	private String pchckpersonname;
	private String pchckpersonid;
	
	private String pchckqualified;
	private String pchckprocessdepartmentid;// 加工师部门
	
	//配镜评级使用
	private String pchckfarvaod;				//远用VA				
	private String pchckfarvaos;
	
	private String pchckclosevaod;				//近用VA
	private String pchckclosevaos;
	
	private String pchckshuiping;				//水平互差
	private String pchckchuizhi;				//垂直互差
	private String pchckzhouwei;				//轴位偏差
	private String pchckhege;					//是否合格
	private String pchckdengji;					//等级
	private String pchckglassessalesvalue;					//等级
	
	public String getPchckglassessalesvalue() {
		return pchckglassessalesvalue;
	}
	public void setPchckglassessalesvalue(String pchckglassessalesvalue) {
		this.pchckglassessalesvalue = pchckglassessalesvalue;
	}
	public String getPchckshuiping() {
		return pchckshuiping;
	}
	public void setPchckshuiping(String pchckshuiping) {
		this.pchckshuiping = pchckshuiping;
	}
	public String getPchckchuizhi() {
		return pchckchuizhi;
	}
	public void setPchckchuizhi(String pchckchuizhi) {
		this.pchckchuizhi = pchckchuizhi;
	}
	public String getPchckzhouwei() {
		return pchckzhouwei;
	}
	public void setPchckzhouwei(String pchckzhouwei) {
		this.pchckzhouwei = pchckzhouwei;
	}
	public String getPchckhege() {
		return pchckhege;
	}
	public void setPchckhege(String pchckhege) {
		this.pchckhege = pchckhege;
	}
	public String getPchckdengji() {
		return pchckdengji;
	}
	public void setPchckdengji(String pchckdengji) {
		this.pchckdengji = pchckdengji;
	}
	/**
	 * 详细页面赋值
	 * @return
	 */	
	
	public String getPchckpersonname() {
		return pchckpersonname;
	}
	public String getPchckfarvaod() {
		return pchckfarvaod;
	}
	public void setPchckfarvaod(String pchckfarvaod) {
		this.pchckfarvaod = pchckfarvaod;
	}
	public String getPchckfarvaos() {
		return pchckfarvaos;
	}
	public void setPchckfarvaos(String pchckfarvaos) {
		this.pchckfarvaos = pchckfarvaos;
	}
	public String getPchckclosevaod() {
		return pchckclosevaod;
	}
	public void setPchckclosevaod(String pchckclosevaod) {
		this.pchckclosevaod = pchckclosevaod;
	}
	public String getPchckclosevaos() {
		return pchckclosevaos;
	}
	public void setPchckclosevaos(String pchckclosevaos) {
		this.pchckclosevaos = pchckclosevaos;
	}
	public String getPchckprocessdepartmentid() {
		return pchckprocessdepartmentid;
	}
	public void setPchckprocessdepartmentid(String pchckprocessdepartmentid) {
		this.pchckprocessdepartmentid = pchckprocessdepartmentid;
	}
	public void setPchckpersonname(String pchckpersonname) {
		this.pchckpersonname = pchckpersonname;
	}
	public String getPchckpersonid() {
		return pchckpersonid;
	}
	public void setPchckpersonid(String pchckpersonid) {
		this.pchckpersonid = pchckpersonid;
	}
	public String getPchckqualified() {
		return pchckqualified;
	}
	public void setPchckqualified(String pchckqualified) {
		this.pchckqualified = pchckqualified;
	}
	
	public String getPchckcokearriseglassod1() {
		return pchckcokearriseglassod1;
	}
	public void setPchckcokearriseglassod1(String pchckcokearriseglassod1) {
		this.pchckcokearriseglassod1 = pchckcokearriseglassod1;
	}
	public String getPchckcokearriseglassos1() {
		return pchckcokearriseglassos1;
	}
	public void setPchckcokearriseglassos1(String pchckcokearriseglassos1) {
		this.pchckcokearriseglassos1 = pchckcokearriseglassos1;
	}
	public String getPchckcokebasisod1() {
		return pchckcokebasisod1;
	}
	public void setPchckcokebasisod1(String pchckcokebasisod1) {
		this.pchckcokebasisod1 = pchckcokebasisod1;
	}
	public String getPchckcokebasisos1() {
		return pchckcokebasisos1;
	}
	public void setPchckcokebasisos1(String pchckcokebasisos1) {
		this.pchckcokebasisos1 = pchckcokebasisos1;
	}
	
	
	public String getPchckstartcheckdate() {
		return pchckstartcheckdate;
	}
	public void setPchckstartcheckdate(String pchckstartcheckdate) {
		this.pchckstartcheckdate = pchckstartcheckdate;
	}
	public String getPchckendcheckdate() {
		return pchckendcheckdate;
	}
	public void setPchckendcheckdate(String pchckendcheckdate) {
		this.pchckendcheckdate = pchckendcheckdate;
	}
	public String getPchckcustomername() {
		return pchckcustomername;
	}
	public void setPchckcustomername(String pchckcustomername) {
		this.pchckcustomername = pchckcustomername;
	}
	public String getPchcktakeglasstime() {
		return pchcktakeglasstime;
	}
	public void setPchcktakeglasstime(String pchcktakeglasstime) {
		this.pchcktakeglasstime = pchcktakeglasstime;
	}
	public String getPchckprocesspersonname() {
		return pchckprocesspersonname;
	}
	public void setPchckprocesspersonname(String pchckprocesspersonname) {
		this.pchckprocesspersonname = pchckprocesspersonname;
	}
	public String getPchckchecklabourname() {
		return pchckchecklabourname;
	}
	public void setPchckchecklabourname(String pchckchecklabourname) {
		this.pchckchecklabourname = pchckchecklabourname;
	}
	public String getPchckid() {
		return pchckid;
	}
	public void setPchckid(String pchckid) {
		this.pchckid = pchckid;
	}
	public String getPchcksalesid() {
		return pchcksalesid;
	}
	public void setPchcksalesid(String pchcksalesid) {
		this.pchcksalesid = pchcksalesid;
	}
	public String getPchckcokeballglassod() {
		return pchckcokeballglassod;
	}
	public void setPchckcokeballglassod(String pchckcokeballglassod) {
		this.pchckcokeballglassod = pchckcokeballglassod;
	}
	public String getPchckcokeballglassos() {
		return pchckcokeballglassos;
	}
	public void setPchckcokeballglassos(String pchckcokeballglassos) {
		this.pchckcokeballglassos = pchckcokeballglassos;
	}
	public String getPchckcokepostglassod() {
		return pchckcokepostglassod;
	}
	public void setPchckcokepostglassod(String pchckcokepostglassod) {
		this.pchckcokepostglassod = pchckcokepostglassod;
	}
	public String getPchckcokepostglassos() {
		return pchckcokepostglassos;
	}
	public void setPchckcokepostglassos(String pchckcokepostglassos) {
		this.pchckcokepostglassos = pchckcokepostglassos;
	}
	public String getPchckcokeaxesod() {
		return pchckcokeaxesod;
	}
	public void setPchckcokeaxesod(String pchckcokeaxesod) {
		this.pchckcokeaxesod = pchckcokeaxesod;
	}
	public String getPchckcokeaxesos() {
		return pchckcokeaxesos;
	}
	public void setPchckcokeaxesos(String pchckcokeaxesos) {
		this.pchckcokeaxesos = pchckcokeaxesos;
	}
	public String getPchckcokearriseglassod() {
		return pchckcokearriseglassod;
	}
	public void setPchckcokearriseglassod(String pchckcokearriseglassod) {
		this.pchckcokearriseglassod = pchckcokearriseglassod;
	}
	public String getPchckcokearriseglassos() {
		return pchckcokearriseglassos;
	}
	public void setPchckcokearriseglassos(String pchckcokearriseglassos) {
		this.pchckcokearriseglassos = pchckcokearriseglassos;
	}
	public String getPchckcokebasisod() {
		return pchckcokebasisod;
	}
	public void setPchckcokebasisod(String pchckcokebasisod) {
		this.pchckcokebasisod = pchckcokebasisod;
	}
	public String getPchckcokebasisos() {
		return pchckcokebasisos;
	}
	public void setPchckcokebasisos(String pchckcokebasisos) {
		this.pchckcokebasisos = pchckcokebasisos;
	}
	public String getPchckcokeaddod() {
		return pchckcokeaddod;
	}
	public void setPchckcokeaddod(String pchckcokeaddod) {
		this.pchckcokeaddod = pchckcokeaddod;
	}
	public String getPchckcokeaddos() {
		return pchckcokeaddos;
	}
	public void setPchckcokeaddos(String pchckcokeaddos) {
		this.pchckcokeaddos = pchckcokeaddos;
	}
	public String getPchckcokepupildistanceod() {
		return pchckcokepupildistanceod;
	}
	public void setPchckcokepupildistanceod(String pchckcokepupildistanceod) {
		this.pchckcokepupildistanceod = pchckcokepupildistanceod;
	}
	public String getPchckcokepupildistanceos() {
		return pchckcokepupildistanceos;
	}
	public void setPchckcokepupildistanceos(String pchckcokepupildistanceos) {
		this.pchckcokepupildistanceos = pchckcokepupildistanceos;
	}
	public String getPchckcokecentervertical() {
		return pchckcokecentervertical;
	}
	public void setPchckcokecentervertical(String pchckcokecentervertical) {
		this.pchckcokecentervertical = pchckcokecentervertical;
	}
	public String getPchckcenterhigh() {
		return pchckcenterhigh;
	}
	public void setPchckcenterhigh(String pchckcenterhigh) {
		this.pchckcenterhigh = pchckcenterhigh;
	}
	public String getPchckcolor() {
		return pchckcolor;
	}
	public void setPchckcolor(String pchckcolor) {
		this.pchckcolor = pchckcolor;
	}
	public String getPchckquality() {
		return pchckquality;
	}
	public void setPchckquality(String pchckquality) {
		this.pchckquality = pchckquality;
	}
	public String getPchckshaping() {
		return pchckshaping;
	}
	public void setPchckshaping(String pchckshaping) {
		this.pchckshaping = pchckshaping;
	}
	public String getPchckgeometrycenter() {
		return pchckgeometrycenter;
	}
	public void setPchckgeometrycenter(String pchckgeometrycenter) {
		this.pchckgeometrycenter = pchckgeometrycenter;
	}
	public String getPchckvertexvertical() {
		return pchckvertexvertical;
	}
	public void setPchckvertexvertical(String pchckvertexvertical) {
		this.pchckvertexvertical = pchckvertexvertical;
	}
	public String getPchckvertexhigh() {
		return pchckvertexhigh;
	}
	public void setPchckvertexhigh(String pchckvertexhigh) {
		this.pchckvertexhigh = pchckvertexhigh;
	}
	public String getPchckprocesspersonid() {
		return pchckprocesspersonid;
	}
	public void setPchckprocesspersonid(String pchckprocesspersonid) {
		this.pchckprocesspersonid = pchckprocesspersonid;
	}
	public String getPchckchecklabourid() {
		return pchckchecklabourid;
	}
	public void setPchckchecklabourid(String pchckchecklabourid) {
		this.pchckchecklabourid = pchckchecklabourid;
	}
	public String getPchckremark() {
		return pchckremark;
	}
	public void setPchckremark(String pchckremark) {
		this.pchckremark = pchckremark;
	}
	public String getPchckcheckdate() {
		return pchckcheckdate;
	}
	public void setPchckcheckdate(String pchckcheckdate) {
		this.pchckcheckdate = pchckcheckdate;
	}
	
	
}
