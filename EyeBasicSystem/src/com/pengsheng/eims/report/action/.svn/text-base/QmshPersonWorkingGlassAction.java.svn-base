/**
 * 
 */
package com.pengsheng.eims.report.action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.report.mgr.QmshPersonWorkingGlassMgr;
import com.pengsheng.eims.report.mgr.QmshtMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author liujing
 * 
 */
public class QmshPersonWorkingGlassAction extends BaseAction {

	private QmshPersonWorkingGlassMgr qmshPersonWorkingGlassMgr;

	public QmshPersonWorkingGlassMgr getQmshPersonWorkingGlassMgr() {
		return qmshPersonWorkingGlassMgr;
	}

	public void setQmshPersonWorkingGlassMgr(
			QmshPersonWorkingGlassMgr qmshPersonWorkingGlassMgr) {
		this.qmshPersonWorkingGlassMgr = qmshPersonWorkingGlassMgr;
	}

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

	public String initQmshPersonWorkingGlass() {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		DepartmentsPo departPo = new DepartmentsPo();
		departPo.setBdpdepartmentid(personInfoPo.getDepartmentID());

		departmentsPo = departmentsMgr.getDepartment(departPo);

		return SUCCESS;
	}

	public String QmshPersonWorkingGlass() throws Exception {
		setFileName(java.net.URLEncoder.encode("各店镜片加工数量统计表.xls", "UTF-8"));

		String billDateStart = Utility.getName(request.getParameter("startTime"));
		String billDateEnd = Utility.getName(request.getParameter("endTime"));		

		try {
			InputStream stream = new FileInputStream("D:/gedianjiagongcount.xls");
			if (stream != null){
				FileInputStream excel = (FileInputStream)stream;
				if (excel != null){
					inputStream = qmshPersonWorkingGlassMgr.bulidShopExcel(excel,billDateStart, billDateEnd);
				}
			}
		} catch (Exception e) {
			System.out.println("各店镜片加工数量统计表：" + e.getMessage());
		}

		return SUCCESS;
	}
}
