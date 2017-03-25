package com.pengsheng.eims.sales.persistence;

public class SpecialPDetailPo {
	
	private String ssesdid;//	主键
	private String ssesdsalesid;//	销售编号
	private String ssesdspecialprocessid;//	特殊加工编号
	private String ssesdrequirement;//	加工要求
	public String getSsesdid() {
		return ssesdid;
	}
	public void setSsesdid(String ssesdid) {
		this.ssesdid = ssesdid;
	}
	public String getSsesdsalesid() {
		return ssesdsalesid;
	}
	public void setSsesdsalesid(String ssesdsalesid) {
		this.ssesdsalesid = ssesdsalesid;
	}
	public String getSsesdspecialprocessid() {
		return ssesdspecialprocessid;
	}
	public void setSsesdspecialprocessid(String ssesdspecialprocessid) {
		this.ssesdspecialprocessid = ssesdspecialprocessid;
	}
	public String getSsesdrequirement() {
		return ssesdrequirement;
	}
	public void setSsesdrequirement(String ssesdrequirement) {
		this.ssesdrequirement = ssesdrequirement;
	}

}
