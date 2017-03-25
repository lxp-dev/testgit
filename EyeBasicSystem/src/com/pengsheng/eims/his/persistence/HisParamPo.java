package com.pengsheng.eims.his.persistence;



public class HisParamPo {

	// 1.	HIS系统患者信息调阅接口
	private String memberid;          // 患者ID
	private String cardno;            // 诊疗卡
	private String identitycard;      // 身份证
	private String name;              // 姓名
	private String tel;               // 电话
	private String sex;               // 性别
	private String birthday;          // 出生日期
	private String address;           // 地址
	private String todayoutpatientid; // 当日就诊号
	
	// 2.	视光系统挂号退费确认接口
	private String isoptometry;       // 验光状态
		
	// 4.	视光系统待交费用确认收费接口
	private String id;                // 缴费单号主键
	private String billid;            // 缴费单号
	private String updatetime;        // 收费时间
	private String start;             // 开始时间
	private String end;               // 结束时间
	private String flag;              // 收费标识
	private String posid;             // 收费员ID
	private String posname;           // 收费员姓名
	private String chargetype;        // 收费类型
	private String chargestatus;      // 收费状态	
	private String tijiatime;         // 提交时间	
	
	// 每个接口都使用
	private String resultCode;        // 返回状态     1:操作成功；0:失败
	private String resultMsg;         // 返回信息
	private String mac;               // mac地址
	private String type;              // 收费退费
	
	
	private String totalmoney;        // 返回信息
	private String createtime;        // 返回信息
	private String interfaceID;        // 返回信息
	private Goodsinfo goodsinfo;      // 返回信息
	
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public HisParamPo() {
		super();
	}
	
	public HisParamPo(String id, String billid, String updatetime, String flag, String posid, String posname, String chargetype, String chargestatus) {
		super();
		this.id = id;
		this.billid = billid;
		this.updatetime = updatetime;
		this.flag = flag;
		this.posid = posid;
		this.posname = posname;
		this.chargetype = chargetype;
		this.chargestatus = chargestatus;
	}

	
	public String getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(String totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getInterfaceID() {
		return interfaceID;
	}

	public void setInterfaceID(String interfaceID) {
		this.interfaceID = interfaceID;
	}

	public Goodsinfo getGoodsinfo() {
		return goodsinfo;
	}

	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

	public String getTijiatime() {
		return tijiatime;
	}

	public void setTijiatime(String tijiatime) {
		this.tijiatime = tijiatime;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getChargetype() {
		return chargetype;
	}
	public void setChargetype(String chargetype) {
		this.chargetype = chargetype;
	}
	public String getChargestatus() {
		return chargestatus;
	}
	public void setChargestatus(String chargestatus) {
		this.chargestatus = chargestatus;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getIdentitycard() {
		return identitycard;
	}
	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTodayoutpatientid() {
		return todayoutpatientid;
	}
	public void setTodayoutpatientid(String todayoutpatientid) {
		this.todayoutpatientid = todayoutpatientid;
	}
	public String getIsoptometry() {
		return isoptometry;
	}
	public void setIsoptometry(String isoptometry) {
		this.isoptometry = isoptometry;
	}
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPosid() {
		return posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}
	public String getPosname() {
		return posname;
	}
	public void setPosname(String posname) {
		this.posname = posname;
	}

	 
	public String toString() {
		return "HisParamPo [address=" + address + ", billid=" + billid + ", birthday=" + birthday + ", cardno=" + cardno + ", chargestatus=" + chargestatus + ", chargetype=" + chargetype + ", end=" + end + ", flag=" + flag + ", id=" + id + ", identitycard=" + identitycard + ", isoptometry=" + isoptometry + ", memberid=" + memberid + ", name=" + name + ", posid=" + posid + ", posname=" + posname + ", resultCode=" + resultCode + ", resultMsg=" + resultMsg + ", sex=" + sex + ", start=" + start + ", tel=" + tel + ", todayoutpatientid=" + todayoutpatientid + ", updatetime=" + updatetime + "]";
	}
	
}
