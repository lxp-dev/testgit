package com.pengsheng.eims.personnel.persistence;

public class TrainPo {
	private String mtuuid;			//培训主键
	private String mttrainid;		//培训ID号
	private String mttraintittle;	//培训标题
	private String mttraincontent;	//培训内容
	private String mttraindate;		//培训时间
	private String mttrainpersonid;	//培训人	
	private String mttrainpersonname;//培训人	
	private String mtcreatpersonid;	//记录人	
	private String mtcreatpersonname;//记录人	
	private String mtcreatdate;		//创建日期
	private String mtremark;		//培训备注
	
	private String mtpuuid;			//培训成绩主键
	private String mtptrainid;		//关联培训ID号
	private String mtppersonid;		//受训人ID
	private String mtppersonName;	//受训人ID
	private String mtpresults;		//受训人成绩
	
	private String[] mtpuuids;			//培训成绩主键
	private String[] mtptrainids;		//关联培训ID号
	private String[] mtppersonids;		//受训人ID
	private String[] mtpresultss;		//受训人成绩
	
	//条件区
	private String trainid;			//培训ID号
	private String traintittle;		//培训标题
	private String trainpersonid;	//培训人	
	private String trainpersonname;	//培训人
	private String creatpersonid;	//记录人	
	private String creatpersonname;	//记录人	
	private String pbgncreatdate;	//培训日期bgn
	private String pendcreatdate;	//培训日期end
	private String bgncreatdate;	//创建日期bgn
	private String endcreatdate;	//创建日期end
	private String remark;			//备注
	
	public String getPbgncreatdate() {
		return pbgncreatdate;
	}
	public void setPbgncreatdate(String pbgncreatdate) {
		this.pbgncreatdate = pbgncreatdate;
	}
	public String getPendcreatdate() {
		return pendcreatdate;
	}
	public void setPendcreatdate(String pendcreatdate) {
		this.pendcreatdate = pendcreatdate;
	}
	public String getMttrainpersonname() {
		return mttrainpersonname;
	}
	public void setMttrainpersonname(String mttrainpersonname) {
		this.mttrainpersonname = mttrainpersonname;
	}
	public String getTrainpersonid() {
		return trainpersonid;
	}
	public void setTrainpersonid(String trainpersonid) {
		this.trainpersonid = trainpersonid;
	}
	public String getTrainpersonname() {
		return trainpersonname;
	}
	public void setTrainpersonname(String trainpersonname) {
		this.trainpersonname = trainpersonname;
	}
	public String getMttrainpersonid() {
		return mttrainpersonid;
	}
	public void setMttrainpersonid(String mttrainpersonid) {
		this.mttrainpersonid = mttrainpersonid;
	}
	public String getMttraindate() {
		return mttraindate;
	}
	public void setMttraindate(String mttraindate) {
		this.mttraindate = mttraindate;
	}
	public String getMtppersonName() {
		return mtppersonName;
	}
	public void setMtppersonName(String mtppersonName) {
		this.mtppersonName = mtppersonName;
	}
	public String[] getMtpuuids() {
		return mtpuuids;
	}
	public void setMtpuuids(String[] mtpuuids) {
		this.mtpuuids = mtpuuids;
	}
	public String[] getMtptrainids() {
		return mtptrainids;
	}
	public void setMtptrainids(String[] mtptrainids) {
		this.mtptrainids = mtptrainids;
	}
	public String[] getMtppersonids() {
		return mtppersonids;
	}
	public void setMtppersonids(String[] mtppersonids) {
		this.mtppersonids = mtppersonids;
	}
	public String[] getMtpresultss() {
		return mtpresultss;
	}
	public void setMtpresultss(String[] mtpresultss) {
		this.mtpresultss = mtpresultss;
	}
	public String getMttraincontent() {
		return mttraincontent;
	}
	public void setMttraincontent(String mttraincontent) {
		this.mttraincontent = mttraincontent;
	}
	public String getMtcreatpersonname() {
		return mtcreatpersonname;
	}
	public void setMtcreatpersonname(String mtcreatpersonname) {
		this.mtcreatpersonname = mtcreatpersonname;
	}
	public String getCreatpersonname() {
		return creatpersonname;
	}
	public void setCreatpersonname(String creatpersonname) {
		this.creatpersonname = creatpersonname;
	}
	public String getMtuuid() {
		return mtuuid;
	}
	public void setMtuuid(String mtuuid) {
		this.mtuuid = mtuuid;
	}
	public String getMttrainid() {
		return mttrainid;
	}
	public void setMttrainid(String mttrainid) {
		this.mttrainid = mttrainid;
	}
	public String getMttraintittle() {
		return mttraintittle;
	}
	public void setMttraintittle(String mttraintittle) {
		this.mttraintittle = mttraintittle;
	}
	public String getMtcreatpersonid() {
		return mtcreatpersonid;
	}
	public void setMtcreatpersonid(String mtcreatpersonid) {
		this.mtcreatpersonid = mtcreatpersonid;
	}
	public String getMtcreatdate() {
		return mtcreatdate;
	}
	public void setMtcreatdate(String mtcreatdate) {
		this.mtcreatdate = mtcreatdate;
	}
	public String getMtremark() {
		return mtremark;
	}
	public void setMtremark(String mtremark) {
		this.mtremark = mtremark;
	}
	public String getMtpuuid() {
		return mtpuuid;
	}
	public void setMtpuuid(String mtpuuid) {
		this.mtpuuid = mtpuuid;
	}
	public String getMtptrainid() {
		return mtptrainid;
	}
	public void setMtptrainid(String mtptrainid) {
		this.mtptrainid = mtptrainid;
	}
	public String getMtppersonid() {
		return mtppersonid;
	}
	public void setMtppersonid(String mtppersonid) {
		this.mtppersonid = mtppersonid;
	}
	public String getMtpresults() {
		return mtpresults;
	}
	public void setMtpresults(String mtpresults) {
		this.mtpresults = mtpresults;
	}
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	public String getTraintittle() {
		return traintittle;
	}
	public void setTraintittle(String traintittle) {
		this.traintittle = traintittle;
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
}
