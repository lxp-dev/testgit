package com.pengsheng.eims.report.action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.report.mgr.GoodsSalesAnalysisMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;

public class GoodsSalesAnalysisRptAction extends BaseAction {
	private GoodsSalesAnalysisMgr goodsSalesAnalysisMgr;

	public GoodsSalesAnalysisMgr getGoodsSalesAnalysisMgr() {
		return goodsSalesAnalysisMgr;
	}

	public void setGoodsSalesAnalysisMgr(GoodsSalesAnalysisMgr goodsSalesAnalysisMgr) {
		this.goodsSalesAnalysisMgr = goodsSalesAnalysisMgr;
	}

	private String contentType;

	private String inputPath = null;
	
	private InputStream inputStream;

	private String fileName;

	
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String initanalysisShop() {

		return SUCCESS;
	}

	public String analysisShop() throws Exception {
		setFileName(java.net.URLEncoder.encode("商品销售分析报表.xls", "UTF-8"));

		String billDateStart = Utility.getName(request.getParameter("startTime"));
		String billDateEnd = Utility.getName(request.getParameter("endTime"));		

		try {
			InputStream stream = new FileInputStream("D:/商品销售分析报表（院长）.xls");
			//InputStream stream = new FileInputStream("D:/workspaces/eims/WebRoot/WEB-INF/classes/excel/fendianxiaoshou.xls");
			if (stream != null){
				FileInputStream excel = (FileInputStream)stream;
				if (excel != null){
					inputStream = goodsSalesAnalysisMgr.bulidShopExcel(excel,billDateStart, billDateEnd);
				}
			}
		} catch (Exception e) {
			System.out.println("商品销售分析报表：" + e.getMessage());
		}

		return SUCCESS;
	}
}
