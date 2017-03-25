/**
 * 
 */
package com.pengsheng.eims.casehistory.persistence;

import java.util.List;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicPo {

	private String sopoboptometrybasicid;// 验光号

	private String sopobcustomerid;// 顾客号

	private String sopobcustomername;// 顾客姓名

	private String sopobmedicalstarttime;// 病历开始日期

	private String sopobmedicalendtime;// 病历结束日期

	private List<OptometryPo> optometrys;// 验光病历表

	public String getSopoboptometrybasicid() {
		return sopoboptometrybasicid;
	}

	public void setSopoboptometrybasicid(String sopoboptometrybasicid) {
		this.sopoboptometrybasicid = sopoboptometrybasicid;
	}

	public String getSopobcustomerid() {
		return sopobcustomerid;
	}

	public void setSopobcustomerid(String sopobcustomerid) {
		this.sopobcustomerid = sopobcustomerid;
	}

	public String getSopobcustomername() {
		return sopobcustomername;
	}

	public void setSopobcustomername(String sopobcustomername) {
		this.sopobcustomername = sopobcustomername;
	}

	public String getSopobmedicalstarttime() {
		return sopobmedicalstarttime;
	}

	public void setSopobmedicalstarttime(String sopobmedicalstarttime) {
		this.sopobmedicalstarttime = sopobmedicalstarttime;
	}

	public String getSopobmedicalendtime() {
		return sopobmedicalendtime;
	}

	public void setSopobmedicalendtime(String sopobmedicalendtime) {
		this.sopobmedicalendtime = sopobmedicalendtime;
	}

	public List<OptometryPo> getOptometrys() {
		return optometrys;
	}

	public void setOptometrys(List<OptometryPo> optometrys) {
		this.optometrys = optometrys;
	}

}
