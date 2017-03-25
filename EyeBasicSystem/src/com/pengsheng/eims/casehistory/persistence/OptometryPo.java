/**
 * 
 */
package com.pengsheng.eims.casehistory.persistence;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

/**
 * @author Liuqian
 * 
 */
public class OptometryPo {

	private String sopoyoptometryid;// 验光号

	private String sopoyoptometrybasicid;// 验光基表ID

	private String sopoyshopcode;// 店号

	private String sopoydepartmentname;// 店名

	private String sopoycustomerid;// 顾客号

	private String sopoypersonid;// 员工ID 验光师

	private String sopoypersonname;// 员工姓名

	private String sopoytime;// 验光日期

	private String sopoyrecipeupdatetime;// 修改处方日期

	private String sopoyflag;// 提交数据标识 1-未提交 0-非正式提交 1-正式提交

	private String sopoyupdateuserid;// 修改人ID
	
	private String sopoyrownumber;//行号
	
	private String sopoyisinternal;//是否是内部配镜单
	
	
	
	/*
	 * 查询条件
	 */
	
	private String sopoydiffusepupil;//快散（1）/慢散（2）/显然屈光（3）/复检（4）
	
	private String sopoyballglassodmax;//检查结论右眼球径上限
	
	private String sopoyballglassodmin;//检查结论右眼球径下限
	
	private String sopoyballglassosmax;//检查结论左眼球径上限
	
	private String sopoydoublecheck;//双眼视功能检查
	
	private String sopoyacamin;
	private String sopoyacamax;
	private String sopoyfarhetelevelmin;
	private String sopoyfarhetelevelmax;
	private String sopoyfarHeteuprightnessmin;
	private String sopoyfarHeteuprightnessmax;
	private String sopoyclosehetelevelmin;
	private String sopoyclosehetelevelmax;
	private String sopoycloseheteuprightnessmin;
	private String sopoycloseheteuprightnessmax;
	private String sopoybccmin;
	private String sopoybccmax;
	private String sopoynramin;
	private String sopoynramax;
	private String sopoypramin;
	private String sopoypramax;
	private String sopoyoneormany;
	private String sopoytreatmentnum;          //当日就诊号  
	private List<DepartmentsPo> smecishoplist; // 相同公司的部门
	
	
	
	public String getSopoytreatmentnum() {
		return sopoytreatmentnum;
	}

	public void setSopoytreatmentnum(String sopoytreatmentnum) {
		this.sopoytreatmentnum = sopoytreatmentnum;
	}

	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}

	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
	}

	public String getSopoyoneormany() {
		return sopoyoneormany;
	}

	public void setSopoyoneormany(String sopoyoneormany) {
		this.sopoyoneormany = sopoyoneormany;
	}

	public String getSopoybccmin() {
		return sopoybccmin;
	}

	public void setSopoybccmin(String sopoybccmin) {
		this.sopoybccmin = sopoybccmin;
	}

	public String getSopoybccmax() {
		return sopoybccmax;
	}

	public void setSopoybccmax(String sopoybccmax) {
		this.sopoybccmax = sopoybccmax;
	}

	public String getSopoynramin() {
		return sopoynramin;
	}

	public void setSopoynramin(String sopoynramin) {
		this.sopoynramin = sopoynramin;
	}

	public String getSopoynramax() {
		return sopoynramax;
	}

	public void setSopoynramax(String sopoynramax) {
		this.sopoynramax = sopoynramax;
	}

	public String getSopoypramin() {
		return sopoypramin;
	}

	public void setSopoypramin(String sopoypramin) {
		this.sopoypramin = sopoypramin;
	}

	public String getSopoypramax() {
		return sopoypramax;
	}

	public void setSopoypramax(String sopoypramax) {
		this.sopoypramax = sopoypramax;
	}

	public String getSopoyacamin() {
		return sopoyacamin;
	}

	public void setSopoyacamin(String sopoyacamin) {
		this.sopoyacamin = sopoyacamin;
	}

	public String getSopoyacamax() {
		return sopoyacamax;
	}

	public void setSopoyacamax(String sopoyacamax) {
		this.sopoyacamax = sopoyacamax;
	}

	public String getSopoyfarhetelevelmin() {
		return sopoyfarhetelevelmin;
	}

	public void setSopoyfarhetelevelmin(String sopoyfarhetelevelmin) {
		this.sopoyfarhetelevelmin = sopoyfarhetelevelmin;
	}

	public String getSopoyfarhetelevelmax() {
		return sopoyfarhetelevelmax;
	}

	public void setSopoyfarhetelevelmax(String sopoyfarhetelevelmax) {
		this.sopoyfarhetelevelmax = sopoyfarhetelevelmax;
	}

	public String getSopoyfarHeteuprightnessmin() {
		return sopoyfarHeteuprightnessmin;
	}

	public void setSopoyfarHeteuprightnessmin(String sopoyfarHeteuprightnessmin) {
		this.sopoyfarHeteuprightnessmin = sopoyfarHeteuprightnessmin;
	}

	public String getSopoyfarHeteuprightnessmax() {
		return sopoyfarHeteuprightnessmax;
	}

	public void setSopoyfarHeteuprightnessmax(String sopoyfarHeteuprightnessmax) {
		this.sopoyfarHeteuprightnessmax = sopoyfarHeteuprightnessmax;
	}

	public String getSopoyclosehetelevelmin() {
		return sopoyclosehetelevelmin;
	}

	public void setSopoyclosehetelevelmin(String sopoyclosehetelevelmin) {
		this.sopoyclosehetelevelmin = sopoyclosehetelevelmin;
	}

	public String getSopoyclosehetelevelmax() {
		return sopoyclosehetelevelmax;
	}

	public void setSopoyclosehetelevelmax(String sopoyclosehetelevelmax) {
		this.sopoyclosehetelevelmax = sopoyclosehetelevelmax;
	}

	public String getSopoycloseheteuprightnessmin() {
		return sopoycloseheteuprightnessmin;
	}

	public void setSopoycloseheteuprightnessmin(String sopoycloseheteuprightnessmin) {
		this.sopoycloseheteuprightnessmin = sopoycloseheteuprightnessmin;
	}

	public String getSopoycloseheteuprightnessmax() {
		return sopoycloseheteuprightnessmax;
	}

	public void setSopoycloseheteuprightnessmax(String sopoycloseheteuprightnessmax) {
		this.sopoycloseheteuprightnessmax = sopoycloseheteuprightnessmax;
	}

	public String getSopoydoublecheck() {
		return sopoydoublecheck;
	}

	public void setSopoydoublecheck(String sopoydoublecheck) {
		this.sopoydoublecheck = sopoydoublecheck;
	}

	public String getSopoyballglassodmax() {
		return sopoyballglassodmax;
	}

	public void setSopoyballglassodmax(String sopoyballglassodmax) {
		this.sopoyballglassodmax = sopoyballglassodmax;
	}

	public String getSopoyballglassodmin() {
		return sopoyballglassodmin;
	}

	public void setSopoyballglassodmin(String sopoyballglassodmin) {
		this.sopoyballglassodmin = sopoyballglassodmin;
	}

	public String getSopoyballglassosmax() {
		return sopoyballglassosmax;
	}

	public void setSopoyballglassosmax(String sopoyballglassosmax) {
		this.sopoyballglassosmax = sopoyballglassosmax;
	}

	public String getSopoyballglassosmin() {
		return sopoyballglassosmin;
	}

	public void setSopoyballglassosmin(String sopoyballglassosmin) {
		this.sopoyballglassosmin = sopoyballglassosmin;
	}

	public String getSopoypostglassodmax() {
		return sopoypostglassodmax;
	}

	public void setSopoypostglassodmax(String sopoypostglassodmax) {
		this.sopoypostglassodmax = sopoypostglassodmax;
	}

	public String getSopoypostglassodmin() {
		return sopoypostglassodmin;
	}

	public void setSopoypostglassodmin(String sopoypostglassodmin) {
		this.sopoypostglassodmin = sopoypostglassodmin;
	}

	public String getSopoypostglassosmax() {
		return sopoypostglassosmax;
	}

	public void setSopoypostglassosmax(String sopoypostglassosmax) {
		this.sopoypostglassosmax = sopoypostglassosmax;
	}

	public String getSopoypostglassosmin() {
		return sopoypostglassosmin;
	}

	public void setSopoypostglassosmin(String sopoypostglassosmin) {
		this.sopoypostglassosmin = sopoypostglassosmin;
	}

	private String sopoyballglassosmin;//检查结论左眼球径下限
	
	private String sopoypostglassodmax;//检查结论右眼柱镜上限
	
	private String sopoypostglassodmin;//检查结论右眼柱镜下限
	
	private String sopoypostglassosmax;//检查结论左眼柱镜上限
	
	private String sopoypostglassosmin;//检查结论左眼柱镜下限
	
	private String sopoyfarworth;//WORTH 4 DOT(远)
	
	private String sopoyaca;//ACA
	
	private String sopoyfarhetelevel;//远隐斜水平
	
	private String sopoyfarHeteuprightness;//远隐斜垂直
	
	private String sopoyclosehetelevel;//近隐斜水平
	
	private String sopoycloseheteuprightness;//近隐斜垂直
	
	private String sopoybcc;
	
	private String sopoypra;
	
	private String sopoynra;
	
	private String sopoybegindate;
	
	private String sopoyenddate;
	
	private String sopoymemberid;//顾客卡号
	
	private String sopoyname;//顾客姓名
	
	private String sopoyphone;//顾客电话
	
	public String getSopoyphone() {
		return sopoyphone;
	}

	public void setSopoyphone(String sopoyphone) {
		this.sopoyphone = sopoyphone;
	}

	public String getSopoymemberid() {
		return sopoymemberid;
	}

	public void setSopoymemberid(String sopoymemberid) {
		this.sopoymemberid = sopoymemberid;
	}

	public String getSopoyname() {
		return sopoyname;
	}

	public void setSopoyname(String sopoyname) {
		this.sopoyname = sopoyname;
	}

	public String getSopoybegindate() {
		return sopoybegindate;
	}

	public void setSopoybegindate(String sopoybegindate) {
		this.sopoybegindate = sopoybegindate;
	}

	public String getSopoyenddate() {
		return sopoyenddate;
	}

	public void setSopoyenddate(String sopoyenddate) {
		this.sopoyenddate = sopoyenddate;
	}

	public String getSopoydiffusepupil() {
		return sopoydiffusepupil;
	}

	public void setSopoydiffusepupil(String sopoydiffusepupil) {
		this.sopoydiffusepupil = sopoydiffusepupil;
	}

	public String getSopoyfarworth() {
		return sopoyfarworth;
	}

	public void setSopoyfarworth(String sopoyfarworth) {
		this.sopoyfarworth = sopoyfarworth;
	}

	public String getSopoyaca() {
		return sopoyaca;
	}

	public void setSopoyaca(String sopoyaca) {
		this.sopoyaca = sopoyaca;
	}

	public String getSopoyfarhetelevel() {
		return sopoyfarhetelevel;
	}

	public void setSopoyfarhetelevel(String sopoyfarhetelevel) {
		this.sopoyfarhetelevel = sopoyfarhetelevel;
	}

	public String getSopoyfarHeteuprightness() {
		return sopoyfarHeteuprightness;
	}

	public void setSopoyfarHeteuprightness(String sopoyfarHeteuprightness) {
		this.sopoyfarHeteuprightness = sopoyfarHeteuprightness;
	}

	public String getSopoyclosehetelevel() {
		return sopoyclosehetelevel;
	}

	public void setSopoyclosehetelevel(String sopoyclosehetelevel) {
		this.sopoyclosehetelevel = sopoyclosehetelevel;
	}

	public String getSopoycloseheteuprightness() {
		return sopoycloseheteuprightness;
	}

	public void setSopoycloseheteuprightness(String sopoycloseheteuprightness) {
		this.sopoycloseheteuprightness = sopoycloseheteuprightness;
	}

	public String getSopoybcc() {
		return sopoybcc;
	}

	public void setSopoybcc(String sopoybcc) {
		this.sopoybcc = sopoybcc;
	}

	public String getSopoypra() {
		return sopoypra;
	}

	public void setSopoypra(String sopoypra) {
		this.sopoypra = sopoypra;
	}

	public String getSopoynra() {
		return sopoynra;
	}

	public void setSopoynra(String sopoynra) {
		this.sopoynra = sopoynra;
	}

	public String getSopoyisinternal() {
		return sopoyisinternal;
	}

	public void setSopoyisinternal(String sopoyisinternal) {
		this.sopoyisinternal = sopoyisinternal;
	}

	public String getSopoyrownumber() {
		return sopoyrownumber;
	}

	public void setSopoyrownumber(String sopoyrownumber) {
		this.sopoyrownumber = sopoyrownumber;
	}

	private String sopoyjumpType; //跳转表示

	public String getSopoyjumpType() {
		return sopoyjumpType;
	}

	public void setSopoyjumpType(String sopoyjumpType) {
		this.sopoyjumpType = sopoyjumpType;
	}

	public String getSopoyoptometryid() {
		return sopoyoptometryid;
	}

	public void setSopoyoptometryid(String sopoyoptometryid) {
		this.sopoyoptometryid = sopoyoptometryid;
	}

	public String getSopoyoptometrybasicid() {
		return sopoyoptometrybasicid;
	}

	public void setSopoyoptometrybasicid(String sopoyoptometrybasicid) {
		this.sopoyoptometrybasicid = sopoyoptometrybasicid;
	}

	public String getSopoyshopcode() {
		return sopoyshopcode;
	}

	public void setSopoyshopcode(String sopoyshopcode) {
		this.sopoyshopcode = sopoyshopcode;
	}

	public String getSopoydepartmentname() {
		return sopoydepartmentname;
	}

	public void setSopoydepartmentname(String sopoydepartmentname) {
		this.sopoydepartmentname = sopoydepartmentname;
	}

	public String getSopoycustomerid() {
		return sopoycustomerid;
	}

	public void setSopoycustomerid(String sopoycustomerid) {
		this.sopoycustomerid = sopoycustomerid;
	}

	public String getSopoypersonid() {
		return sopoypersonid;
	}

	public void setSopoypersonid(String sopoypersonid) {
		this.sopoypersonid = sopoypersonid;
	}

	public String getSopoypersonname() {
		return sopoypersonname;
	}

	public void setSopoypersonname(String sopoypersonname) {
		this.sopoypersonname = sopoypersonname;
	}

	public String getSopoytime() {
		return sopoytime;
	}

	public void setSopoytime(String sopoytime) {
		this.sopoytime = sopoytime;
	}

	public String getSopoyrecipeupdatetime() {
		return sopoyrecipeupdatetime;
	}

	public void setSopoyrecipeupdatetime(String sopoyrecipeupdatetime) {
		this.sopoyrecipeupdatetime = sopoyrecipeupdatetime;
	}

	public String getSopoyflag() {
		return sopoyflag;
	}

	public void setSopoyflag(String sopoyflag) {
		this.sopoyflag = sopoyflag;
	}

	public String getSopoyupdateuserid() {
		return sopoyupdateuserid;
	}

	public void setSopoyupdateuserid(String sopoyupdateuserid) {
		this.sopoyupdateuserid = sopoyupdateuserid;
	}


	
}
