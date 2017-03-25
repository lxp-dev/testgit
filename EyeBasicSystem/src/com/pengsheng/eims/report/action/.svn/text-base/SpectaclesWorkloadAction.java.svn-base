package com.pengsheng.eims.report.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.pengsheng.eims.util.basicaction.BaseAction;

public class SpectaclesWorkloadAction extends BaseAction {
	
	/**
	 * 初始化
	 * @return
	 */
	public String initSpectaclesWorkloadSel(){
		//年下拉列表
		Date time = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int endy = Integer.parseInt(sdf.format(new Date()));
		int month = time.getMonth()+1;
		int beginy = endy-10;
		request.setAttribute("month", month);
		request.setAttribute("endy", endy);
		request.setAttribute("beginy", beginy);
		//////
		
		return SUCCESS;
	}

}
