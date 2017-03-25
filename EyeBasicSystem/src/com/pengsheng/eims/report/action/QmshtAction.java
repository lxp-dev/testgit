/**
 * 
 */
package com.pengsheng.eims.report.action;

import java.io.FileInputStream;
import java.io.InputStream;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.report.mgr.QmshtMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class QmshtAction extends BaseAction {

	private QmshtMgr qmshtMgr;

	private DepartmentsMgr departmentsMgr;

	private DepartmentsPo departmentsPo;

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

	public QmshtMgr getQmshtMgr() {
		return qmshtMgr;
	}

	public void setQmshtMgr(QmshtMgr qmshtMgr) {
		this.qmshtMgr = qmshtMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
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

	public String initQmshtShop() {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		DepartmentsPo departPo = new DepartmentsPo();
		departPo.setBdpdepartmentid(personInfoPo.getDepartmentID());

		departmentsPo = departmentsMgr.getDepartment(departPo);

		return SUCCESS;
	}

	public String qmshtShop() throws Exception {
		setFileName(java.net.URLEncoder.encode("分店销售指南.xls", "UTF-8"));

		String billDateStart = Utility.getName(request.getParameter("startTime"));
		String billDateEnd = Utility.getName(request.getParameter("endTime"));
		String newflag = Utility.getName(request.getParameter("newflag"));	
		String filePath = "D:"+System.getProperty("file.separator")+"fendianxiaoshou.xls";
		
		if (newflag.equals("1")){
			filePath = "D:"+System.getProperty("file.separator")+"fendianxiaoshounew.xls";
		}
		
		if (newflag.equals("2")){
			filePath = "D:"+System.getProperty("file.separator")+"fendianxiaoshounewnew.xls";
		}
		
		if (newflag.equals("3")){
			filePath = "D:"+System.getProperty("file.separator")+"fendianxiaoshounewnew3.xls";
		}
		
		try {
			InputStream stream = new FileInputStream(filePath);
			//InputStream stream = new FileInputStream("D:/workspaces/eims/WebRoot/WEB-INF/classes/excel/fendianxiaoshou.xls");
			if (stream != null){
				FileInputStream excel = (FileInputStream)stream;
				if (excel != null){
					if (newflag.equals("1")){
						inputStream = qmshtMgr.bulidShopExcelNew(excel,billDateStart, billDateEnd);
					}else if (newflag.equals("2")){
						inputStream = qmshtMgr.bulidShopExcelNew2(excel,billDateStart, billDateEnd);
					}else if (newflag.equals("3")){
						inputStream = qmshtMgr.bulidShopExcelNew3(excel,billDateStart, billDateEnd);
					}else{
						inputStream = qmshtMgr.bulidShopExcel(excel,billDateStart, billDateEnd);
					}					
				}
			}
		} catch (Exception e) {
			System.out.println("分店销售指南：" + e.getMessage());
		}

		return SUCCESS;
	}
}
