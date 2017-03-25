package com.pengsheng.eims.basic.persistence;

public class NoticeFilePo {
	
	private String bnfuuid;				//主键UUID
	private String bnfnoticeid;				//主键UUID
	private String bnftitle;			//公告标题
	private String bnfpublishdate;		//公告日期
	private String bnfpublishperson;	//发布人工号
	private String bnfpublishpersonname;//发布人姓名
	private String bnfdepartmentid;		//部门ID
	private String bnfsavefilename;
	private String bnfcontenttype;
	private String bnfdocumenturl;
	private String bnfdepartmentname;		//部门名称
		
	public String getBnfnoticeid() {
		return bnfnoticeid;
	}
	public void setBnfnoticeid(String bnfnoticeid) {
		this.bnfnoticeid = bnfnoticeid;
	}
	public String getBnfuuid() {
		return bnfuuid;
	}
	public void setBnfuuid(String bnfuuid) {
		this.bnfuuid = bnfuuid;
	}
	public String getBnftitle() {
		return bnftitle;
	}
	public void setBnftitle(String bnftitle) {
		this.bnftitle = bnftitle;
	}
	public String getBnfpublishdate() {
		return bnfpublishdate;
	}
	public void setBnfpublishdate(String bnfpublishdate) {
		this.bnfpublishdate = bnfpublishdate;
	}
	public String getBnfpublishperson() {
		return bnfpublishperson;
	}
	public void setBnfpublishperson(String bnfpublishperson) {
		this.bnfpublishperson = bnfpublishperson;
	}
	public String getBnfpublishpersonname() {
		return bnfpublishpersonname;
	}
	public void setBnfpublishpersonname(String bnfpublishpersonname) {
		this.bnfpublishpersonname = bnfpublishpersonname;
	}
	public String getBnfdepartmentid() {
		return bnfdepartmentid;
	}
	public void setBnfdepartmentid(String bnfdepartmentid) {
		this.bnfdepartmentid = bnfdepartmentid;
	}
	public String getBnfsavefilename() {
		return bnfsavefilename;
	}
	public void setBnfsavefilename(String bnfsavefilename) {
		this.bnfsavefilename = bnfsavefilename;
	}
	public String getBnfcontenttype() {
		return bnfcontenttype;
	}
	public void setBnfcontenttype(String bnfcontenttype) {
		this.bnfcontenttype = bnfcontenttype;
	}
	public String getBnfdocumenturl() {
		return bnfdocumenturl;
	}
	public void setBnfdocumenturl(String bnfdocumenturl) {
		this.bnfdocumenturl = bnfdocumenturl;
	}
	public String getBnfdepartmentname() {
		return bnfdepartmentname;
	}
	public void setBnfdepartmentname(String bnfdepartmentname) {
		this.bnfdepartmentname = bnfdepartmentname;
	}	
	
}
