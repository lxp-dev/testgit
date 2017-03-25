package com.pengsheng.eims.components.action;

import com.pengsheng.eims.sales.mgr.DelaysReminderMgr;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class DelaysReminderInformAction extends BaseAction {
	

	private DelaysReminderPo delaysReminderPo;
	
	private DelaysReminderMgr delaysReminderMgr;
	
	public DelaysReminderMgr getDelaysReminderMgr() {
		return delaysReminderMgr;
	}

	public void setDelaysReminderMgr(DelaysReminderMgr delaysReminderMgr) {
		this.delaysReminderMgr = delaysReminderMgr;
	}

	public DelaysReminderPo getDelaysReminderPo() {
		return delaysReminderPo;
	}

	public void setDelaysReminderPo(DelaysReminderPo delaysReminderPo) {
		this.delaysReminderPo = delaysReminderPo;
	}

	/**
	 * 初始化误期查询通知开窗
	 * @return
	 */
	public String initDelaysReminderInformSel()throws Exception{
		delaysReminderPo=new DelaysReminderPo();
		delaysReminderPo.setSsedrsalesid(request.getParameter("hid"));
		
//		delaysReminderMgr..delConsignProcessOrder(consignProcessOrderPo
//				.getCstcpoorderbillid());

//		this.clearMessages();
//		this.addActionMessage(getText("struts.messages.update.sucess"));
//
//		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

}
