package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 品种action
 */
public class PrintBarcodeAction extends BaseAction {
	
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private WindowsMgr windowsMgr;
	
	private List<BrandPo> brandPos;
	
	public String initPrintBarcode() throws Exception{
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}
	
	public String initPrintsBarcode() throws Exception{
		return SUCCESS;
	}
	
	public String initPrintBarcodePrint() throws Exception{
		return SUCCESS;
	}
	
	public String initPrintJQ() throws Exception{
		return SUCCESS;
	}
	
	public String initPrintBrandBarcode() throws Exception{
		
		return SUCCESS;
	}
	
	public String initPrintJQcqjy() throws Exception{
		
		return SUCCESS;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}

	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}
	
	
}
