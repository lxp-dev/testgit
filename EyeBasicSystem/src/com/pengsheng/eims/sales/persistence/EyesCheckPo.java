package com.pengsheng.eims.sales.persistence;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

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
	private String smecimemberid;//会员卡卡号
	
	/**
	 * 查询条件
	 */
	private String startTime;	//开始时间
	private String endTime;	//结束时间
	private List<DepartmentsPo> smecishoplist; // 相同公司的部门
		
	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}
	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
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
	public String getSmecimemberid() {
		return smecimemberid;
	}
	public void setSmecimemberid(String smecimemberid) {
		this.smecimemberid = smecimemberid;
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

}
