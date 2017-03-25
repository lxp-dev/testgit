package com.pengsheng.eims.personnel.persistence;

public class RewardsAndPenaltiesPo {
	private String mrpuuid;						//主键
	private String mrprewardsandpenaltiesid;	//奖惩单号
	private String mrppersonid;					//奖惩人
	private String mrppersonname;				//奖惩人
	private String mrprewardsorpenaltiesnum;	//奖惩金额
	private String mrprewardsorpenalties;		//奖惩type
	private String mrpremark;					
	private String mrpcreatpersonid;			//create person id
	private String mrpcreatpersonname;			//create person name
	private String mrpcreatdate;				//create date
	private String mrprewardsreason;			//奖reason
	private String mrppenaltiesreason;			//惩reason
	
	//change
	private String rewardsandpenaltiesid;		//billid
	private String rewardsorpenalties;			//奖惩type
	private String personid;					//奖惩人id
	private String personname;					//奖惩人name
	private String creatpersonid;				//create person id
	private String creatpersonname;				//create person name
	private String bgncreatdate;				//begin create date
	private String endcreatdate;				//end create date
	private String remark;
	
	public String getMrprewardsorpenaltiesnum() {
		return mrprewardsorpenaltiesnum;
	}
	public void setMrprewardsorpenaltiesnum(String mrprewardsorpenaltiesnum) {
		this.mrprewardsorpenaltiesnum = mrprewardsorpenaltiesnum;
	}
	public String getMrppersonname() {
		return mrppersonname;
	}
	public void setMrppersonname(String mrppersonname) {
		this.mrppersonname = mrppersonname;
	}
	public String getMrpcreatpersonname() {
		return mrpcreatpersonname;
	}
	public void setMrpcreatpersonname(String mrpcreatpersonname) {
		this.mrpcreatpersonname = mrpcreatpersonname;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getCreatpersonname() {
		return creatpersonname;
	}
	public void setCreatpersonname(String creatpersonname) {
		this.creatpersonname = creatpersonname;
	}
	public String getMrpcreatpersonid() {
		return mrpcreatpersonid;
	}
	public void setMrpcreatpersonid(String mrpcreatpersonid) {
		this.mrpcreatpersonid = mrpcreatpersonid;
	}
	public String getMrpcreatdate() {
		return mrpcreatdate;
	}
	public void setMrpcreatdate(String mrpcreatdate) {
		this.mrpcreatdate = mrpcreatdate;
	}
	public String getCreatpersonid() {
		return creatpersonid;
	}
	public void setCreatpersonid(String creatpersonid) {
		this.creatpersonid = creatpersonid;
	}
	public String getBgncreatdate() {
		return bgncreatdate;
	}
	public void setBgncreatdate(String bgncreatdate) {
		this.bgncreatdate = bgncreatdate;
	}
	public String getEndcreatdate() {
		return endcreatdate;
	}
	public void setEndcreatdate(String endcreatdate) {
		this.endcreatdate = endcreatdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMrpuuid() {
		return mrpuuid;
	}
	public void setMrpuuid(String mrpuuid) {
		this.mrpuuid = mrpuuid;
	}
	public String getMrprewardsandpenaltiesid() {
		return mrprewardsandpenaltiesid;
	}
	public void setMrprewardsandpenaltiesid(String mrprewardsandpenaltiesid) {
		this.mrprewardsandpenaltiesid = mrprewardsandpenaltiesid;
	}
	public String getMrppersonid() {
		return mrppersonid;
	}
	public void setMrppersonid(String mrppersonid) {
		this.mrppersonid = mrppersonid;
	}
	public String getMrprewardsorpenalties() {
		return mrprewardsorpenalties;
	}
	public void setMrprewardsorpenalties(String mrprewardsorpenalties) {
		this.mrprewardsorpenalties = mrprewardsorpenalties;
	}
	public String getMrpremark() {
		return mrpremark;
	}
	public void setMrpremark(String mrpremark) {
		this.mrpremark = mrpremark;
	}
	public String getMrprewardsreason() {
		return mrprewardsreason;
	}
	public void setMrprewardsreason(String mrprewardsreason) {
		this.mrprewardsreason = mrprewardsreason;
	}
	public String getMrppenaltiesreason() {
		return mrppenaltiesreason;
	}
	public void setMrppenaltiesreason(String mrppenaltiesreason) {
		this.mrppenaltiesreason = mrppenaltiesreason;
	}
	public String getRewardsandpenaltiesid() {
		return rewardsandpenaltiesid;
	}
	public void setRewardsandpenaltiesid(String rewardsandpenaltiesid) {
		this.rewardsandpenaltiesid = rewardsandpenaltiesid;
	}
	public String getRewardsorpenalties() {
		return rewardsorpenalties;
	}
	public void setRewardsorpenalties(String rewardsorpenalties) {
		this.rewardsorpenalties = rewardsorpenalties;
	}
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
}
