package com.pengsheng.eims.report.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pengsheng.eims.util.basicaction.BaseAction;

public class BillInAndOutRptAction extends BaseAction {
	
	public String initBillInAndOutRptSel(){
		
		return SUCCESS;
	}

	public String initCollectOtherOutStorageBill(){
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
		return SUCCESS;
	}
	
}
