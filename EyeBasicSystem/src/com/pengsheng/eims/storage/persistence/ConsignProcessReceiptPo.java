package com.pengsheng.eims.storage.persistence;

public class ConsignProcessReceiptPo {
	private String cstcprreceiptbillid; // 收货单号
	private String cstcprsourcebillid; // 转单号
	private String cstcprbilldate; // 单据日期
	private String cstcprgoodscategory; // 商品类型
	private String cstcprsupplierid; // 制造商
	private String cstcprsuppliername;// 制造商名称
	private String cstcprinstockid; // 收入仓位
	private String cstcprdepartmentid;// 部门
	private String cstcprcreateperson; // 创建人
	private String cstcprauditperson; // 审核人
	private String cstcprauditdate; // 审核日期
	private String cstcprauditstate; // 0，未审核 1，已审核


	private String cstcprremark; // 备注
	private String cstcprauditstartdate; // 备注
	private String cstcprauditenddate; // 备注
	private String cstcprinstockname;// 新加收入仓位名称
	private String cstcprcreatepersonname;// 新加创建人姓名
	private String cstcprauditpersonname;// 新加审核人姓名

	private String cstcprstartTime;// 财务审核日期查询
	private String cstcprendTime;// 财务审核结束日期查询
	
	private String cstcprdeliverystart;//发货时间start
	private String cstcprdeliveryend;//发货时间end
	
	private String cstcprordersdeliveryid;//订单系统发货单号
	private String cstcprsalesid;//配镜单号
	private String cstcprysalesid;//原配镜单号
	private String salesdjsbm;	//原配镜单单据识别码
	
	private String cstcprwaybillid;//运单号
	
	private String cstcprcustomercardnumber;//顾客卡号
	private String cstcprcustomername;//顾客姓名
	private String cstcprgoodsname;// 商品名称
	private String cstcprfaliaostockid; // 委外配送中新增发料仓位
	private String cstcpralloctionbillid; // 委外配送中调拨单号
	
	private String cstcprcompanyid; // 所属公司
	private String cstcprsubsupplierid; // 制造商
	private String cstcprshopcodename;// 销售部门
	
	public String getCstcprshopcodename() {
		return cstcprshopcodename;
	}

	public void setCstcprshopcodename(String cstcprshopcodename) {
		this.cstcprshopcodename = cstcprshopcodename;
	}

	public String getCstcprsubsupplierid() {
		return cstcprsubsupplierid;
	}

	public void setCstcprsubsupplierid(String cstcprsubsupplierid) {
		this.cstcprsubsupplierid = cstcprsubsupplierid;
	}

	public String getCstcprcompanyid() {
		return cstcprcompanyid;
	}

	public void setCstcprcompanyid(String cstcprcompanyid) {
		this.cstcprcompanyid = cstcprcompanyid;
	}

	public String getCstcpralloctionbillid() {
		return cstcpralloctionbillid;
	}

	public void setCstcpralloctionbillid(String cstcpralloctionbillid) {
		this.cstcpralloctionbillid = cstcpralloctionbillid;
	}

	public String getCstcprfaliaostockid() {
		return cstcprfaliaostockid;
	}

	public void setCstcprfaliaostockid(String cstcprfaliaostockid) {
		this.cstcprfaliaostockid = cstcprfaliaostockid;
	}

	public String getCstcprgoodsname() {
		return cstcprgoodsname;
	}

	public void setCstcprgoodsname(String cstcprgoodsname) {
		this.cstcprgoodsname = cstcprgoodsname;
	}

	public String getCstcprcustomercardnumber() {
		return cstcprcustomercardnumber;
	}

	public void setCstcprcustomercardnumber(String cstcprcustomercardnumber) {
		this.cstcprcustomercardnumber = cstcprcustomercardnumber;
	}

	public String getCstcprcustomername() {
		return cstcprcustomername;
	}

	public void setCstcprcustomername(String cstcprcustomername) {
		this.cstcprcustomername = cstcprcustomername;
	}

	public String getCstcprwaybillid() {
		return cstcprwaybillid;
	}

	public void setCstcprwaybillid(String cstcprwaybillid) {
		this.cstcprwaybillid = cstcprwaybillid;
	}

	public String getCstcprysalesid() {
		return cstcprysalesid;
	}

	public void setCstcprysalesid(String cstcprysalesid) {
		this.cstcprysalesid = cstcprysalesid;
	}

	public String getCstcprdeliverystart() {
		return cstcprdeliverystart;
	}

	public void setCstcprdeliverystart(String cstcprdeliverystart) {
		this.cstcprdeliverystart = cstcprdeliverystart;
	}

	public String getCstcprdeliveryend() {
		return cstcprdeliveryend;
	}

	public void setCstcprdeliveryend(String cstcprdeliveryend) {
		this.cstcprdeliveryend = cstcprdeliveryend;
	}

	public String getCstcprsalesid() {
		return cstcprsalesid;
	}

	public void setCstcprsalesid(String cstcprsalesid) {
		this.cstcprsalesid = cstcprsalesid;
	}

	public String getCstcprordersdeliveryid() {
		return cstcprordersdeliveryid;
	}

	public void setCstcprordersdeliveryid(String cstcprordersdeliveryid) {
		this.cstcprordersdeliveryid = cstcprordersdeliveryid;
	}

	public String getCstcprreceiptbillid() {
		return cstcprreceiptbillid;
	}

	public void setCstcprreceiptbillid(String cstcprreceiptbillid) {
		this.cstcprreceiptbillid = cstcprreceiptbillid;
	}

	public String getCstcprsourcebillid() {
		return cstcprsourcebillid;
	}

	public void setCstcprsourcebillid(String cstcprsourcebillid) {
		this.cstcprsourcebillid = cstcprsourcebillid;
	}

	public String getCstcprbilldate() {
		return cstcprbilldate;
	}

	public void setCstcprbilldate(String cstcprbilldate) {
		this.cstcprbilldate = cstcprbilldate;
	}

	public String getCstcprgoodscategory() {
		return cstcprgoodscategory;
	}

	public void setCstcprgoodscategory(String cstcprgoodscategory) {
		this.cstcprgoodscategory = cstcprgoodscategory;
	}

	public String getCstcprsupplierid() {
		return cstcprsupplierid;
	}

	public void setCstcprsupplierid(String cstcprsupplierid) {
		this.cstcprsupplierid = cstcprsupplierid;
	}

	public String getCstcprsuppliername() {
		return cstcprsuppliername;
	}

	public void setCstcprsuppliername(String cstcprsuppliername) {
		this.cstcprsuppliername = cstcprsuppliername;
	}

	public String getCstcprinstockid() {
		return cstcprinstockid;
	}

	public void setCstcprinstockid(String cstcprinstockid) {
		this.cstcprinstockid = cstcprinstockid;
	}

	public String getCstcprdepartmentid() {
		return cstcprdepartmentid;
	}

	public void setCstcprdepartmentid(String cstcprdepartmentid) {
		this.cstcprdepartmentid = cstcprdepartmentid;
	}

	public String getCstcprcreateperson() {
		return cstcprcreateperson;
	}

	public void setCstcprcreateperson(String cstcprcreateperson) {
		this.cstcprcreateperson = cstcprcreateperson;
	}

	public String getCstcprauditperson() {
		return cstcprauditperson;
	}

	public void setCstcprauditperson(String cstcprauditperson) {
		this.cstcprauditperson = cstcprauditperson;
	}

	public String getCstcprauditdate() {
		return cstcprauditdate;
	}

	public void setCstcprauditdate(String cstcprauditdate) {
		this.cstcprauditdate = cstcprauditdate;
	}

	public String getCstcprauditstate() {
		return cstcprauditstate;
	}

	public void setCstcprauditstate(String cstcprauditstate) {
		this.cstcprauditstate = cstcprauditstate;
	}

	public String getCstcprremark() {
		return cstcprremark;
	}

	public void setCstcprremark(String cstcprremark) {
		this.cstcprremark = cstcprremark;
	}

	public String getCstcprinstockname() {
		return cstcprinstockname;
	}

	public void setCstcprinstockname(String cstcprinstockname) {
		this.cstcprinstockname = cstcprinstockname;
	}

	public String getCstcprcreatepersonname() {
		return cstcprcreatepersonname;
	}

	public void setCstcprcreatepersonname(String cstcprcreatepersonname) {
		this.cstcprcreatepersonname = cstcprcreatepersonname;
	}

	public String getCstcprauditpersonname() {
		return cstcprauditpersonname;
	}

	public void setCstcprauditpersonname(String cstcprauditpersonname) {
		this.cstcprauditpersonname = cstcprauditpersonname;
	}

	public String getCstcprstartTime() {
		return cstcprstartTime;
	}

	public void setCstcprstartTime(String cstcprstartTime) {
		this.cstcprstartTime = cstcprstartTime;
	}

	public String getCstcprendTime() {
		return cstcprendTime;
	}

	public void setCstcprendTime(String cstcprendTime) {
		this.cstcprendTime = cstcprendTime;
	}
	public String getCstcprauditstartdate() {
		return cstcprauditstartdate;
	}

	public void setCstcprauditstartdate(String cstcprauditstartdate) {
		this.cstcprauditstartdate = cstcprauditstartdate;
	}

	public String getCstcprauditenddate() {
		return cstcprauditenddate;
	}

	public void setCstcprauditenddate(String cstcprauditenddate) {
		this.cstcprauditenddate = cstcprauditenddate;
	}

	public String getSalesdjsbm() {
		return salesdjsbm;
	}

	public void setSalesdjsbm(String salesdjsbm) {
		this.salesdjsbm = salesdjsbm;
	}
}
