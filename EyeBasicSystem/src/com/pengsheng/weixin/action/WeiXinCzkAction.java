package com.pengsheng.weixin.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class WeiXinCzkAction  extends BaseAction {
	
	private ChuzhikaMgr chuzhikaMgr;
	private List<ChuzhikaLogPo> chuzhikaLogPos;
	
	public String initWeixinCzkSel() throws Exception{
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if(openID.equals("")){
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);
		// openID判断
		
		String czkID = Utility.getName(request.getParameter("czkID"));
		chuzhikaLogPos = chuzhikaMgr.selectChuzhikaLogsByCustomerID(czkID);
		return SUCCESS;
	}

	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

	public List<ChuzhikaLogPo> getChuzhikaLogPos() {
		return chuzhikaLogPos;
	}

	public void setChuzhikaLogPos(List<ChuzhikaLogPo> chuzhikaLogPos) {
		this.chuzhikaLogPos = chuzhikaLogPos;
	}
	
}
