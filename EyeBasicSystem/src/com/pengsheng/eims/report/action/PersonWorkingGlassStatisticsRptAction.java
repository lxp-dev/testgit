package com.pengsheng.eims.report.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.pengsheng.eims.util.basicaction.BaseAction;

public class PersonWorkingGlassStatisticsRptAction extends BaseAction {
	
	/**
	 * 加工师加工镜片数量统计表
	 * @return
	 */
	public String initPersonWorkingGlassStatistics(){
		
		//年龄下拉列表
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int endy = Integer.parseInt(sdf.format(new Date()));
		int beginy = endy-10;
			
		request.setAttribute("endy", endy);
		request.setAttribute("beginy", beginy);
		//////
		
		return SUCCESS;
	}

}
