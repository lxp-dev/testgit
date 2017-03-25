/**
 * 
 */
package com.pengsheng.eims.storage.persistence;

/**
 * @author Liuqian
 * 
 */
public class DeliveryPo {
	private String cstdid;// 单据编号

	private String cstdpoid;// 订单编号

	private String cstdbilldate;// 单据日期

	private String cstdsupplierid;// 制造商编码

	private String cstdcustomerid;// 客户编码

	private String cstdcreateperson;// 创建人

	private String cstdauditperson;// 处理人

	private String cstdauditstate;// 处理状态

	private String cstdauditdate;// 处理日期

	private String cstdremark;// 备注

	public String getCstdid() {
		return cstdid;
	}

	public void setCstdid(String cstdid) {
		this.cstdid = cstdid;
	}

	public String getCstdpoid() {
		return cstdpoid;
	}

	public void setCstdpoid(String cstdpoid) {
		this.cstdpoid = cstdpoid;
	}

	public String getCstdbilldate() {
		return cstdbilldate;
	}

	public void setCstdbilldate(String cstdbilldate) {
		this.cstdbilldate = cstdbilldate;
	}

	public String getCstdsupplierid() {
		return cstdsupplierid;
	}

	public void setCstdsupplierid(String cstdsupplierid) {
		this.cstdsupplierid = cstdsupplierid;
	}

	public String getCstdcustomerid() {
		return cstdcustomerid;
	}

	public void setCstdcustomerid(String cstdcustomerid) {
		this.cstdcustomerid = cstdcustomerid;
	}

	public String getCstdcreateperson() {
		return cstdcreateperson;
	}

	public void setCstdcreateperson(String cstdcreateperson) {
		this.cstdcreateperson = cstdcreateperson;
	}

	public String getCstdauditperson() {
		return cstdauditperson;
	}

	public void setCstdauditperson(String cstdauditperson) {
		this.cstdauditperson = cstdauditperson;
	}

	public String getCstdauditstate() {
		return cstdauditstate;
	}

	public void setCstdauditstate(String cstdauditstate) {
		this.cstdauditstate = cstdauditstate;
	}

	public String getCstdauditdate() {
		return cstdauditdate;
	}

	public void setCstdauditdate(String cstdauditdate) {
		this.cstdauditdate = cstdauditdate;
	}

	public String getCstdremark() {
		return cstdremark;
	}

	public void setCstdremark(String cstdremark) {
		this.cstdremark = cstdremark;
	}

}
