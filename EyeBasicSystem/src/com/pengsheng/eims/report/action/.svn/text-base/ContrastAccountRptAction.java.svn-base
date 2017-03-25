package com.pengsheng.eims.report.action;

import java.io.FileInputStream;
import java.io.InputStream;

import com.pengsheng.eims.report.mgr.ContrastAccountMgr;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

@SuppressWarnings("serial")
public class ContrastAccountRptAction extends BaseAction {
	
	private ContrastAccountMgr contrastAccountMgr = null;
	private InputStream inputStream = null;
	private String fileName = null;
	
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
	public ContrastAccountMgr getContrastAccountMgr() {
		return contrastAccountMgr;
	}
	public void setContrastAccountMgr(ContrastAccountMgr contrastAccountMgr) {
		this.contrastAccountMgr = contrastAccountMgr;
	}

	/**
	 * 初始化对账单 
	 * @author SZK
	 * @return
	 */
	public String initContrastAccount(){	
		return SUCCESS;
	}
	
	/**
	 * 查询对账单 SZK
 	 * @author SZK
	 * @return
	 */
	public String contrastAccount()throws Exception {
		setFileName(java.net.URLEncoder.encode("对账表.xls", "UTF-8"));
		
		String billID = Utility.getName(request.getParameter("billID"));
		String begDate = Utility.getName(request.getParameter("begDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String salesBillID = Utility.getName(request.getParameter("salesBillID"));		
		String supplierID = Utility.getName(request.getParameter("supplierID"));

		try {
			InputStream stream = new FileInputStream("D:/duizhangbiao.xls");
			if (stream != null){
				FileInputStream excel = (FileInputStream)stream;
				if (excel != null){
					inputStream = contrastAccountMgr.getGlassData(excel,billID, begDate, endDate, salesBillID, supplierID);
				}
			}
		} catch (Exception e) {
			System.out.println("对账表：" + e.getMessage());
		}

		
		return SUCCESS;
	}
	
}
