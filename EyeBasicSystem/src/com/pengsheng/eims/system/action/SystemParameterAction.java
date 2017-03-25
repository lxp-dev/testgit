package com.pengsheng.eims.system.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.AreaMgr;
import com.pengsheng.eims.basic.mgr.ReminderWindowMgr;
import com.pengsheng.eims.basic.persistence.AreaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.safenet.Encrypt;

public class SystemParameterAction extends BaseAction{
	private List<DepartmentsPo> departmentsPos;
	private String savePath;
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	// ----------5级地区 moyongsheng 2014-11-08-------------	
	private List<AreaPo> area1List;	
	private List<AreaPo> area2List;	
	private List<AreaPo> area3List;	
	private List<AreaPo> area4List;	
	private List<AreaPo> area5List;	
	private AreaMgr areaMgr;	
// ----------5级地区 moyongsheng 2014-11-08-------------	

	private ReminderWindowMgr reminderWindowMgr;
	
	/**
	 * 加载系统设置页面
	 * @return
	 */
	public String initSystemParameter() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		Encrypt encrypt = new Encrypt();
		encrypt.setKey(GlobalConstants.DES_KEY);    //调用set函数设置密钥。
		encrypt.setDesString(systemParameterPo.getFspsleepstarttime());   //将要解密的密文传送给Encrypt.java进行解密计算。
		systemParameterPo.setFspsleepstarttime(encrypt.getStrM().replace("sleep", ""));
		
		departmentsPos = systemParameterMgr.selectDepartmentsPoForWhichretail();
		
		area1List = areaMgr.getAjaxAreaData("1", "000000000000");
		area2List = areaMgr.getAjaxAreaData("2", systemParameterPo.getFsparea1());
		area3List = areaMgr.getAjaxAreaData("3", systemParameterPo.getFsparea2());
		area4List = areaMgr.getAjaxAreaData("4", systemParameterPo.getFsparea3());
		area5List = areaMgr.getAjaxAreaData("5", systemParameterPo.getFsparea4());
		
		request.setAttribute("companyAdmin", Utility.getName(request.getParameter("companyAdmin")));

		return SUCCESS;
	}
	
	/**
	 * 插入系统设置数据
	 * @return
	 */
	public String insertSystemParameter() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo.setFspstockqueryconditions(request.getParameter("KCquery"));
		SystemParameterPo po = new SystemParameterPo();		
		po = systemParameterMgr.getSystemParameterPo();
		systemParameterPo.setFspshowsupplier(request.getParameter("showsupplier"));
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		String hhcheckout = Utility.getName(request.getParameter("hhcheckout"));
		String mmcheckout = Utility.getName(request.getParameter("mmcheckout"));	
		
		Encrypt encrypt = new Encrypt();
		encrypt.setKey(GlobalConstants.DES_KEY);    //调用set函数设置密钥。
		encrypt.setEncString("sleep"+systemParameterPo.getFspsleepstarttime());//将要加密的明文传送给Encrypt.java进行加密计算。
		
		systemParameterPo.setFspsleepstarttime(encrypt.getStrMi());
		systemParameterPo.setFspdaycheckout(hhcheckout + ":" + mmcheckout);
		
		if(Utility.getName(po.getFspuuid()) != ""){
			logPo.setsLogOpID("2");    // 表示状态
			logPo.setsLogContent("修改系统设置!");
			
			systemParameterMgr.updateSystemParameter(systemParameterPo,logPo);
		}else{
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("新增系统设置!");
			
			systemParameterMgr.insertSystemParameter(systemParameterPo,logPo);
		}	
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		departmentsPos = systemParameterMgr.selectDepartmentsPoForWhichretail();
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		if(!"".equals(Utility.getName(request.getParameter("companyAdmin")))){
			request.setAttribute("url", "'initSystemParameter.action?moduleID="+moduleID+"&companyAdmin="+request.getParameter("companyAdmin")+"'");
		}else{
			request.setAttribute("url", "'initSystemParameter.action?moduleID="+moduleID+"'");
		}
		
		this.clearMessages();
		this.addActionMessage("用户重新登录系统后，设置生效!");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 插入系统设置数据
	 * @return
	 */
	public String updateSystemParameter() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		departmentsPos = systemParameterMgr.selectDepartmentsPoForWhichretail();
		
		return SUCCESS;
	}
	
	
	/**
	 * 加载页面样式设置页
	 * @return
	 * @throws IOException 
	 */
	public String writeJS() throws IOException {
		return SUCCESS;
	}
	

	
	/**
	 * 图片浏览
	 * @return
	 * @throws Exception
	 */
	public String lookimage() throws Exception {
		String id = Utility.getName(request.getParameter("id"));
		request.setAttribute("id", id);
		
		String width = Utility.getName(request.getParameter("width"));
		request.setAttribute("width", width);
		
		String height = Utility.getName(request.getParameter("height"));
		request.setAttribute("height", height);
		
		return SUCCESS;
	}
	
	public String initMendBarcode() throws Exception {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String ctype = Utility.getName(request.getParameter("ctype"));
		
		SystemParameterPo tspo = new SystemParameterPo();
		
		request.setAttribute("ctype", ctype);
		
		if("10".equals(ctype)){
			tspo.setFsptype("10");
			List<SystemParameterPo> barcodepo1 = systemParameterMgr.selectBarcodeCoordinate(tspo);
			request.setAttribute("barcodepo1", barcodepo1);
			return "brand";
		}else if("11".equals(ctype)){
			tspo.setFsptype("11");
			List<SystemParameterPo> barcodepo1 = systemParameterMgr.selectBarcodeCoordinate(tspo);
			request.setAttribute("barcodepo1", barcodepo1);
			return "jq";
		}else if("12".equals(ctype)){
			tspo.setFsptype("12");
			List<SystemParameterPo> barcodepo1 = systemParameterMgr.selectBarcodeCoordinate(tspo);
			request.setAttribute("barcodepo1", barcodepo1);
			return "discount";
		}else{
			tspo.setFsptype(ctype);
			List<SystemParameterPo> barcodepo1 = systemParameterMgr.selectBarcodeCoordinate(tspo);
			request.setAttribute("barcodepo1", barcodepo1);
			return SUCCESS;
		}
	}
	
	public String mendBarcode() throws Exception {
		SystemParameterPo xqpo = systemParameterMgr.getSystemParameterPo();
		List<SystemParameterPo> list = new ArrayList<SystemParameterPo>();
		String ctype = Utility.getName(request.getParameter("systemParameterPo.fsptype"));
 		for(int i=0; i<systemParameterPo.getFsprows().length; i++){
			SystemParameterPo po = new SystemParameterPo();
			po.setFspcategoryid(ctype);
			po.setFsptype(systemParameterPo.getFsptype());
			po.setFsprow(systemParameterPo.getFsprows()[i]);
			po.setFspx(systemParameterPo.getFspxs()[i]);
			po.setFspy(systemParameterPo.getFspys()[i]);
			po.setFspsize(systemParameterPo.getFspsizes()[i]);
			
			if(!"10".equals(ctype)&&!"11".equals(ctype)&&!"12".equals(ctype)){
				po.setFspnrib(Utility.getName(systemParameterPo.getFspnribs()[i]));
				po.setFspishowbarcodename(Utility.getName(systemParameterPo.getFspishowbarcodenames()[i]));
				po.setFspyouthink1(systemParameterPo.getFspyouthinks1()[i]);
				po.setFspyouthink2(systemParameterPo.getFspyouthinks2()[i]);
				po.setFspyouthink3(systemParameterPo.getFspyouthinks3()[i]);
				po.setFspyouthink4(systemParameterPo.getFspyouthinks4()[i]);
				po.setFspyouthink5(systemParameterPo.getFspyouthinks5()[i]);
				po.setFspyouthink6(systemParameterPo.getFspyouthinks6()[i]);
				po.setFspyouthink7(systemParameterPo.getFspyouthinks7()[i]);
				po.setFspyouthink8(systemParameterPo.getFspyouthinks8()[i]);
				po.setFspyouthink9(systemParameterPo.getFspyouthinks9()[i]);
				po.setFspyouthink10(systemParameterPo.getFspyouthinks10()[i]);
				po.setFspisprint(Utility.getName(systemParameterPo.getFspisprints()[i]));
			}
			
			po.setFsprowprintnum(systemParameterPo.getFsprowprintnum());
			po.setFsprowprintspan(systemParameterPo.getFsprowprintspan());
			po.setFspport(systemParameterPo.getFspport());
			po.setFspfont(systemParameterPo.getFspfont());
			
			
			list.add(po);
		}
		
		systemParameterMgr.updateBarcodeCoordinate(list);
		
		String barcodetype = systemParameterPo.getFsptype();
		
		List<SystemParameterPo> barcodepo1 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo2 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo3 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo4 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo5 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo6 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo7 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo8 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo9 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo10 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo11 = new ArrayList<SystemParameterPo>();
		List<SystemParameterPo> barcodepo12 = new ArrayList<SystemParameterPo>();
		
		for(int i=1; i<=12; i++){
			SystemParameterPo po = new SystemParameterPo();
			po.setFsptype(i+"");
			if(i == 1){
				barcodepo1 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("1".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo1);
				}
			}else if(i == 2){
				barcodepo2 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("2".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo2);
				}
			}else if(i == 3){
				barcodepo3 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("3".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo3);
				}
			}else if(i == 4){
				barcodepo4 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("4".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo4);
				}
			}else if(i == 5){
				barcodepo5 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("5".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo5);
				}
			}else if(i == 6){
				barcodepo6 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("6".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo6);
				}
			}else if(i == 7){
				barcodepo7 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("7".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo7);
				}
			}else if(i == 8){
				barcodepo8 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("8".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo8);
				}
			}else if(i == 9){
				barcodepo9 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("9".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo9);
				}
			}else if(i == 10){
				barcodepo10 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("10".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo10);
				}
			}else if(i == 11){
				barcodepo11 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("11".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo11);
				}
			}else if(i == 12){
				barcodepo12 = systemParameterMgr.selectBarcodeCoordinate(po);
				if("12".equals(ctype)){
					request.setAttribute("barcodepo1", barcodepo12);
				}
			}
		}
		
		request.setAttribute("ctype", ctype);
		request.setAttribute("barcodetype", barcodetype);
		
		String url = ServletActionContext.getServletContext().getRealPath(this.getSavePath());
		try {
			File file = new File(url + "\\printBarcode.jsp");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(url + "\\printBarcode.jsp"), "UTF-8"));
			out.println("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%> ");
			out.println("<%@ taglib prefix=\"s\" uri=\"/struts-tags\"%> ");
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> ");
			out.println("<html> ");
			out.println("  <head> ");
			out.println("	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> ");
			out.println("  </head> ");
			out.println("  <script> ");
			out.println("function printBarCode(barCode, quantity, brandname, source, spec, color, retailprice, person, printtype,guaranteeperiod,batch) {	 ");
			out.println("	var barCodes = new Array(); ");
			out.println("	var brandnames = new Array(); ");
			out.println("	var sources = new Array(); ");
			out.println("	var specs = new Array(); ");
			out.println("	var colors = new Array(); ");
			out.println("	var retailprices = new Array(); ");
			out.println("	var persons = new Array(); ");
			out.println("	var guaranteeperiods = new Array(); ");
			out.println("	var batchs = new Array(); ");
			out.println("	for(var i = 0;i< barCode.length; i++){ ");
			out.println("		for(var a = 0; a < quantity[i]; a++){  ");
			out.println("			barCodes[barCodes.length] = barCode[i]; ");
			out.println("			brandnames[brandnames.length] = brandname[i]; ");
			out.println("			sources[sources.length] = source[i]; ");
			out.println("			specs[specs.length] = spec[i]; ");
			out.println("			colors[colors.length] = color[i]; ");
			out.println("			retailprices[retailprices.length] = retailprice[i]; ");
			out.println("			persons[persons.length] = person[i]; ");
			out.println("			if(guaranteeperiod){ ");
			out.println("				guaranteeperiods[guaranteeperiods.length] = guaranteeperiod[i]; ");
			out.println("			}else{ ");
			out.println("				guaranteeperiods[guaranteeperiods.length] = ''; ");
			out.println("			} ");
			out.println("			if(batch){ ");
			out.println("				batchs[batchs.length] = batch[i]; ");
			out.println("			}else{ ");
			out.println("				batchs[batchs.length] = ''; ");
			out.println("			} ");
			out.println("		} ");
			out.println("	} ");
			out.println("	if(/^[1]/.test(barCodes[0])){ ");
			out.println("		callPrint1(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	}else if(/^[2]/.test(barCodes[0])){ ");
			out.println("		callPrint2(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	}else if(/^[3]/.test(barCodes[0])){ ");
			out.println("		callPrint3(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	}else if(/^[4]/.test(barCodes[0])){ ");
			out.println("		callPrint4(barCodes,brandnames,sources,specs,colors,retailprices,persons,guaranteeperiods,batchs); ");
			out.println("	}else if(/^[5]/.test(barCodes[0])){ ");
			out.println("		callPrint5(barCodes,brandnames,sources,specs,colors,retailprices,persons,guaranteeperiods,batchs); ");
			out.println("	}else if(/^[6]/.test(barCodes[0])){ ");
			out.println("		callPrint6(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	}else if(/^[7]/.test(barCodes[0])){ ");
			out.println("		callPrint7(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	}else if(/^[8]/.test(barCodes[0])){ ");
			out.println("		callPrint8(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	}else if(/^[9]/.test(barCodes[0])){ ");
			out.println("		callPrint9(barCodes,brandnames,sources,specs,colors,retailprices,persons); ");
			out.println("	} ");
			out.println("} ");
			
			
			for(int i=1; i<=12; i++){
				SystemParameterPo po = new SystemParameterPo();
				po.setFsptype(i+"");
				if(i == 1){
					out.println("function callPrint1(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print1(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print1(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo1.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo1.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						if("1".equals(barcodepo1.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(0).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(0).getFspy()+"^BQ"+barcodepo1.get(0).getFspnrib()+","+barcodepo1.get(0).getFspsize()+","+barcodepo1.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(1).getFspx())+Integer.parseInt(barcodepo1.get(1).getFsprowprintspan())*a)+","+barcodepo1.get(1).getFspy()+"^A0"+barcodepo1.get(1).getFspnrib()+","+barcodepo1.get(1).getFspsize()+","+barcodepo1.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(2).getFspx())+Integer.parseInt(barcodepo1.get(2).getFsprowprintspan())*a)+","+barcodepo1.get(2).getFspy()+"^A0"+barcodepo1.get(2).getFspnrib()+","+barcodepo1.get(2).getFspsize()+","+barcodepo1.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(3).getFspisprint())){
							if("1".equals(barcodepo1.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(3).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(3).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(3).getFspnrib()+","+barcodepo1.get(3).getFspsize()+","+barcodepo1.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(3).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(3).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(3).getFspnrib()+","+barcodepo1.get(3).getFspsize()+","+barcodepo1.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo1.get(4).getFspisprint())){
							if("1".equals(barcodepo1.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(4).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(4).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(4).getFspnrib()+","+barcodepo1.get(4).getFspsize()+","+barcodepo1.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(4).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(4).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(4).getFspnrib()+","+barcodepo1.get(4).getFspsize()+","+barcodepo1.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo1.get(5).getFspisprint())){
							if("1".equals(barcodepo1.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(5).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(5).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(5).getFspnrib()+","+barcodepo1.get(5).getFspsize()+","+barcodepo1.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(5).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(5).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(5).getFspnrib()+","+barcodepo1.get(5).getFspsize()+","+barcodepo1.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo1.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo1.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(6).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(6).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(6).getFspnrib()+","+barcodepo1.get(6).getFspsize()+","+barcodepo1.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(6).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(6).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(6).getFspnrib()+","+barcodepo1.get(6).getFspsize()+","+barcodepo1.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo1.get(7).getFspisprint())){
							if("1".equals(barcodepo1.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(7).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(7).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(7).getFspnrib()+","+barcodepo1.get(7).getFspsize()+","+barcodepo1.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(7).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(7).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(7).getFspnrib()+","+barcodepo1.get(7).getFspsize()+","+barcodepo1.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo1.get(8).getFspisprint())){
							if("1".equals(barcodepo1.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(8).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(8).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(8).getFspnrib()+","+barcodepo1.get(8).getFspsize()+","+barcodepo1.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(8).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(8).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(8).getFspnrib()+","+barcodepo1.get(8).getFspsize()+","+barcodepo1.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo1.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(9).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(9).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(9).getFspnrib()+","+barcodepo1.get(9).getFspsize()+","+barcodepo1.get(9).getFspsize()+"^FD"+barcodepo1.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(10).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(10).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(10).getFspnrib()+","+barcodepo1.get(10).getFspsize()+","+barcodepo1.get(10).getFspsize()+"^FD"+barcodepo1.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(11).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(11).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(11).getFspnrib()+","+barcodepo1.get(11).getFspsize()+","+barcodepo1.get(11).getFspsize()+"^FD"+barcodepo1.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(12).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(12).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(12).getFspnrib()+","+barcodepo1.get(12).getFspsize()+","+barcodepo1.get(12).getFspsize()+"^FD"+barcodepo1.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(13).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(13).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(13).getFspnrib()+","+barcodepo1.get(13).getFspsize()+","+barcodepo1.get(13).getFspsize()+"^FD"+barcodepo1.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(14).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(14).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(14).getFspnrib()+","+barcodepo1.get(14).getFspsize()+","+barcodepo1.get(14).getFspsize()+"^FD"+barcodepo1.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(15).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(15).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(15).getFspnrib()+","+barcodepo1.get(15).getFspsize()+","+barcodepo1.get(15).getFspsize()+"^FD"+barcodepo1.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(16).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(16).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(16).getFspnrib()+","+barcodepo1.get(16).getFspsize()+","+barcodepo1.get(16).getFspsize()+"^FD"+barcodepo1.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(17).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(17).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(17).getFspnrib()+","+barcodepo1.get(17).getFspsize()+","+barcodepo1.get(17).getFspsize()+"^FD"+barcodepo1.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo1.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo1.get(18).getFspx())+Integer.parseInt(barcodepo1.get(0).getFsprowprintspan())*a)+","+barcodepo1.get(18).getFspy()+"^"+barcodepo1.get(0).getFspfont()+barcodepo1.get(18).getFspnrib()+","+barcodepo1.get(18).getFspsize()+","+barcodepo1.get(18).getFspsize()+"^FD"+barcodepo1.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo1.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 2){
					
					out.println("function callPrint2(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print2(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print2(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo2.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo2.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						if("1".equals(barcodepo2.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(0).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(0).getFspy()+"^BQ"+barcodepo2.get(0).getFspnrib()+","+barcodepo2.get(0).getFspsize()+","+barcodepo2.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(1).getFspx())+Integer.parseInt(barcodepo2.get(1).getFsprowprintspan())*a)+","+barcodepo2.get(1).getFspy()+"^A0"+barcodepo2.get(1).getFspnrib()+","+barcodepo2.get(1).getFspsize()+","+barcodepo2.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(2).getFspx())+Integer.parseInt(barcodepo2.get(2).getFsprowprintspan())*a)+","+barcodepo2.get(2).getFspy()+"^A0"+barcodepo2.get(2).getFspnrib()+","+barcodepo2.get(2).getFspsize()+","+barcodepo2.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(3).getFspisprint())){
							if("1".equals(barcodepo2.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(3).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(3).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(3).getFspnrib()+","+barcodepo2.get(3).getFspsize()+","+barcodepo2.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(3).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(3).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(3).getFspnrib()+","+barcodepo2.get(3).getFspsize()+","+barcodepo2.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo2.get(4).getFspisprint())){
							if("1".equals(barcodepo2.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(4).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(4).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(4).getFspnrib()+","+barcodepo2.get(4).getFspsize()+","+barcodepo2.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(4).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(4).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(4).getFspnrib()+","+barcodepo2.get(4).getFspsize()+","+barcodepo2.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo2.get(5).getFspisprint())){
							if("1".equals(barcodepo2.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(5).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(5).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(5).getFspnrib()+","+barcodepo2.get(5).getFspsize()+","+barcodepo2.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(5).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(5).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(5).getFspnrib()+","+barcodepo2.get(5).getFspsize()+","+barcodepo2.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo2.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo2.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(6).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(6).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(6).getFspnrib()+","+barcodepo2.get(6).getFspsize()+","+barcodepo2.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(6).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(6).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(6).getFspnrib()+","+barcodepo2.get(6).getFspsize()+","+barcodepo2.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo2.get(7).getFspisprint())){
							if("1".equals(barcodepo2.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(7).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(7).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(7).getFspnrib()+","+barcodepo2.get(7).getFspsize()+","+barcodepo2.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(7).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(7).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(7).getFspnrib()+","+barcodepo2.get(7).getFspsize()+","+barcodepo2.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo2.get(8).getFspisprint())){
							if("1".equals(barcodepo2.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(8).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(8).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(8).getFspnrib()+","+barcodepo2.get(8).getFspsize()+","+barcodepo2.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(8).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(8).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(8).getFspnrib()+","+barcodepo2.get(8).getFspsize()+","+barcodepo2.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo2.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(9).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(9).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(9).getFspnrib()+","+barcodepo2.get(9).getFspsize()+","+barcodepo2.get(9).getFspsize()+"^FD"+barcodepo2.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(10).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(10).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(10).getFspnrib()+","+barcodepo2.get(10).getFspsize()+","+barcodepo2.get(10).getFspsize()+"^FD"+barcodepo2.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(11).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(11).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(11).getFspnrib()+","+barcodepo2.get(11).getFspsize()+","+barcodepo2.get(11).getFspsize()+"^FD"+barcodepo2.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(12).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(12).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(12).getFspnrib()+","+barcodepo2.get(12).getFspsize()+","+barcodepo2.get(12).getFspsize()+"^FD"+barcodepo2.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(13).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(13).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(13).getFspnrib()+","+barcodepo2.get(13).getFspsize()+","+barcodepo2.get(13).getFspsize()+"^FD"+barcodepo2.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(14).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(14).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(14).getFspnrib()+","+barcodepo2.get(14).getFspsize()+","+barcodepo2.get(14).getFspsize()+"^FD"+barcodepo2.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(15).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(15).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(15).getFspnrib()+","+barcodepo2.get(15).getFspsize()+","+barcodepo2.get(15).getFspsize()+"^FD"+barcodepo2.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(16).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(16).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(16).getFspnrib()+","+barcodepo2.get(16).getFspsize()+","+barcodepo2.get(16).getFspsize()+"^FD"+barcodepo2.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(17).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(17).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(17).getFspnrib()+","+barcodepo2.get(17).getFspsize()+","+barcodepo2.get(17).getFspsize()+"^FD"+barcodepo2.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo2.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo2.get(18).getFspx())+Integer.parseInt(barcodepo2.get(0).getFsprowprintspan())*a)+","+barcodepo2.get(18).getFspy()+"^"+barcodepo2.get(0).getFspfont()+barcodepo2.get(18).getFspnrib()+","+barcodepo2.get(18).getFspsize()+","+barcodepo2.get(18).getFspsize()+"^FD"+barcodepo2.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo2.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 3){
					
					out.println("function callPrint3(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print3(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print3(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo3.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo3.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo3.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(0).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(0).getFspy()+"^BQ"+barcodepo3.get(0).getFspnrib()+","+barcodepo3.get(0).getFspsize()+","+barcodepo3.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(1).getFspx())+Integer.parseInt(barcodepo3.get(1).getFsprowprintspan())*a)+","+barcodepo3.get(1).getFspy()+"^A0"+barcodepo3.get(1).getFspnrib()+","+barcodepo3.get(1).getFspsize()+","+barcodepo3.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(2).getFspx())+Integer.parseInt(barcodepo3.get(2).getFsprowprintspan())*a)+","+barcodepo3.get(2).getFspy()+"^A0"+barcodepo3.get(2).getFspnrib()+","+barcodepo3.get(2).getFspsize()+","+barcodepo3.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(3).getFspisprint())){
							if("1".equals(barcodepo3.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(3).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(3).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(3).getFspnrib()+","+barcodepo3.get(3).getFspsize()+","+barcodepo3.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(3).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(3).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(3).getFspnrib()+","+barcodepo3.get(3).getFspsize()+","+barcodepo3.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo3.get(4).getFspisprint())){
							if("1".equals(barcodepo3.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(4).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(4).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(4).getFspnrib()+","+barcodepo3.get(4).getFspsize()+","+barcodepo3.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(4).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(4).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(4).getFspnrib()+","+barcodepo3.get(4).getFspsize()+","+barcodepo3.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo3.get(5).getFspisprint())){
							if("1".equals(barcodepo3.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(5).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(5).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(5).getFspnrib()+","+barcodepo3.get(5).getFspsize()+","+barcodepo3.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(5).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(5).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(5).getFspnrib()+","+barcodepo3.get(5).getFspsize()+","+barcodepo3.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo3.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo3.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(6).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(6).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(6).getFspnrib()+","+barcodepo3.get(6).getFspsize()+","+barcodepo3.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(6).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(6).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(6).getFspnrib()+","+barcodepo3.get(6).getFspsize()+","+barcodepo3.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo3.get(7).getFspisprint())){
							if("1".equals(barcodepo3.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(7).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(7).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(7).getFspnrib()+","+barcodepo3.get(7).getFspsize()+","+barcodepo3.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(7).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(7).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(7).getFspnrib()+","+barcodepo3.get(7).getFspsize()+","+barcodepo3.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo3.get(8).getFspisprint())){
							if("1".equals(barcodepo3.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(8).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(8).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(8).getFspnrib()+","+barcodepo3.get(8).getFspsize()+","+barcodepo3.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(8).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(8).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(8).getFspnrib()+","+barcodepo3.get(8).getFspsize()+","+barcodepo3.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo3.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(9).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(9).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(9).getFspnrib()+","+barcodepo3.get(9).getFspsize()+","+barcodepo3.get(9).getFspsize()+"^FD"+barcodepo3.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(10).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(10).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(10).getFspnrib()+","+barcodepo3.get(10).getFspsize()+","+barcodepo3.get(10).getFspsize()+"^FD"+barcodepo3.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(11).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(11).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(11).getFspnrib()+","+barcodepo3.get(11).getFspsize()+","+barcodepo3.get(11).getFspsize()+"^FD"+barcodepo3.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(12).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(12).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(12).getFspnrib()+","+barcodepo3.get(12).getFspsize()+","+barcodepo3.get(12).getFspsize()+"^FD"+barcodepo3.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(13).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(13).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(13).getFspnrib()+","+barcodepo3.get(13).getFspsize()+","+barcodepo3.get(13).getFspsize()+"^FD"+barcodepo3.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(14).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(14).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(14).getFspnrib()+","+barcodepo3.get(14).getFspsize()+","+barcodepo3.get(14).getFspsize()+"^FD"+barcodepo3.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(15).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(15).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(15).getFspnrib()+","+barcodepo3.get(15).getFspsize()+","+barcodepo3.get(15).getFspsize()+"^FD"+barcodepo3.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(16).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(16).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(16).getFspnrib()+","+barcodepo3.get(16).getFspsize()+","+barcodepo3.get(16).getFspsize()+"^FD"+barcodepo3.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(17).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(17).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(17).getFspnrib()+","+barcodepo3.get(17).getFspsize()+","+barcodepo3.get(17).getFspsize()+"^FD"+barcodepo3.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo3.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo3.get(18).getFspx())+Integer.parseInt(barcodepo3.get(0).getFsprowprintspan())*a)+","+barcodepo3.get(18).getFspy()+"^"+barcodepo3.get(0).getFspfont()+barcodepo3.get(18).getFspnrib()+","+barcodepo3.get(18).getFspsize()+","+barcodepo3.get(18).getFspsize()+"^FD"+barcodepo3.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo3.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 4){
					
					out.println("function callPrint4(barCodes,brandnames,sources,specs,colors,retailprices,persons,guaranteeperiods,batchs){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	var guaranteeperiod = ''; ");
					out.println("	var batch = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("		guaranteeperiod = guaranteeperiod + guaranteeperiods[cStr] + '|'; ");
					out.println("		batch = batch + batchs[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print4(barCode,brandname,source,spec,color,retailprice,person,guaranteeperiod,batch); ");
					out.println("} ");
					
					out.println("function Print4(barCode,brandname,source,spec,color,retailprice,person,guaranteeperiod,batch){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var printguaranteeperiod = new Array(); ");
					out.println("	printguaranteeperiod = guaranteeperiod.split('|'); ");
					out.println("	var printbatch = new Array(); ");
					out.println("	printbatch = batch.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo4.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo4.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo4.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(0).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(0).getFspy()+"^BQ"+barcodepo4.get(0).getFspnrib()+","+barcodepo4.get(0).getFspsize()+","+barcodepo4.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(1).getFspx())+Integer.parseInt(barcodepo4.get(1).getFsprowprintspan())*a)+","+barcodepo4.get(1).getFspy()+"^A0"+barcodepo4.get(1).getFspnrib()+","+barcodepo4.get(1).getFspsize()+","+barcodepo4.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(2).getFspx())+Integer.parseInt(barcodepo4.get(2).getFsprowprintspan())*a)+","+barcodepo4.get(2).getFspy()+"^A0"+barcodepo4.get(2).getFspnrib()+","+barcodepo4.get(2).getFspsize()+","+barcodepo4.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(3).getFspisprint())){
							if("1".equals(barcodepo4.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(3).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(3).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(3).getFspnrib()+","+barcodepo4.get(3).getFspsize()+","+barcodepo4.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(3).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(3).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(3).getFspnrib()+","+barcodepo4.get(3).getFspsize()+","+barcodepo4.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(4).getFspisprint())){
							if("1".equals(barcodepo4.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(4).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(4).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(4).getFspnrib()+","+barcodepo4.get(4).getFspsize()+","+barcodepo4.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(4).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(4).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(4).getFspnrib()+","+barcodepo4.get(4).getFspsize()+","+barcodepo4.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(5).getFspisprint())){
							if("1".equals(barcodepo4.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(5).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(5).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(5).getFspnrib()+","+barcodepo4.get(5).getFspsize()+","+barcodepo4.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(5).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(5).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(5).getFspnrib()+","+barcodepo4.get(5).getFspsize()+","+barcodepo4.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo4.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(6).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(6).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(6).getFspnrib()+","+barcodepo4.get(6).getFspsize()+","+barcodepo4.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(6).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(6).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(6).getFspnrib()+","+barcodepo4.get(6).getFspsize()+","+barcodepo4.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(7).getFspisprint())){
							if("1".equals(barcodepo4.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(7).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(7).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(7).getFspnrib()+","+barcodepo4.get(7).getFspsize()+","+barcodepo4.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(7).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(7).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(7).getFspnrib()+","+barcodepo4.get(7).getFspsize()+","+barcodepo4.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(8).getFspisprint())){
							if("1".equals(barcodepo4.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(8).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(8).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(8).getFspnrib()+","+barcodepo4.get(8).getFspsize()+","+barcodepo4.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(8).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(8).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(8).getFspnrib()+","+barcodepo4.get(8).getFspsize()+","+barcodepo4.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(9).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(9).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(9).getFspnrib()+","+barcodepo4.get(9).getFspsize()+","+barcodepo4.get(9).getFspsize()+"^FD"+barcodepo4.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(10).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(10).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(10).getFspnrib()+","+barcodepo4.get(10).getFspsize()+","+barcodepo4.get(10).getFspsize()+"^FD"+barcodepo4.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(11).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(11).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(11).getFspnrib()+","+barcodepo4.get(11).getFspsize()+","+barcodepo4.get(11).getFspsize()+"^FD"+barcodepo4.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(12).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(12).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(12).getFspnrib()+","+barcodepo4.get(12).getFspsize()+","+barcodepo4.get(12).getFspsize()+"^FD"+barcodepo4.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(13).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(13).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(13).getFspnrib()+","+barcodepo4.get(13).getFspsize()+","+barcodepo4.get(13).getFspsize()+"^FD"+barcodepo4.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(14).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(14).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(14).getFspnrib()+","+barcodepo4.get(14).getFspsize()+","+barcodepo4.get(14).getFspsize()+"^FD"+barcodepo4.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(15).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(15).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(15).getFspnrib()+","+barcodepo4.get(15).getFspsize()+","+barcodepo4.get(15).getFspsize()+"^FD"+barcodepo4.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(16).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(16).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(16).getFspnrib()+","+barcodepo4.get(16).getFspsize()+","+barcodepo4.get(16).getFspsize()+"^FD"+barcodepo4.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(17).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(17).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(17).getFspnrib()+","+barcodepo4.get(17).getFspsize()+","+barcodepo4.get(17).getFspsize()+"^FD"+barcodepo4.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(18).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(18).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(18).getFspnrib()+","+barcodepo4.get(18).getFspsize()+","+barcodepo4.get(18).getFspsize()+"^FD"+barcodepo4.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo4.get(19).getFspisprint())){
							if("1".equals(barcodepo4.get(19).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(19).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(19).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(19).getFspnrib()+","+barcodepo4.get(19).getFspsize()+","+barcodepo4.get(19).getFspsize()+"^FD\"+ \"效期:\" + printguaranteeperiod[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(19).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(19).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(19).getFspnrib()+","+barcodepo4.get(19).getFspsize()+","+barcodepo4.get(19).getFspsize()+"^FD\"+ printguaranteeperiod[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo4.get(20).getFspisprint())){
							if("1".equals(barcodepo4.get(20).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(20).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(20).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(20).getFspnrib()+","+barcodepo4.get(20).getFspsize()+","+barcodepo4.get(20).getFspsize()+"^FD\"+ \"批号:\" + printbatch[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo4.get(20).getFspx())+Integer.parseInt(barcodepo4.get(0).getFsprowprintspan())*a)+","+barcodepo4.get(20).getFspy()+"^"+barcodepo4.get(0).getFspfont()+barcodepo4.get(20).getFspnrib()+","+barcodepo4.get(20).getFspsize()+","+barcodepo4.get(20).getFspsize()+"^FD\"+ printbatch[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo4.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 5){
					
					out.println("function callPrint5(barCodes,brandnames,sources,specs,colors,retailprices,persons,guaranteeperiods,batchs){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	var guaranteeperiod = ''; ");
					out.println("	var batch = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("		guaranteeperiod = guaranteeperiod + guaranteeperiods[cStr] + '|'; ");
					out.println("		batch = batch + batchs[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print5(barCode,brandname,source,spec,color,retailprice,person,guaranteeperiod,batch); ");
					out.println("} ");
					
					out.println("function Print5(barCode,brandname,source,spec,color,retailprice,person,guaranteeperiod,batch){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var printguaranteeperiod = new Array(); ");
					out.println("	printguaranteeperiod = guaranteeperiod.split('|'); ");
					out.println("	var printbatch = new Array(); ");
					out.println("	printbatch = batch.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo5.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo5.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo5.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(0).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(0).getFspy()+"^BQ"+barcodepo5.get(0).getFspnrib()+","+barcodepo5.get(0).getFspsize()+","+barcodepo5.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(1).getFspx())+Integer.parseInt(barcodepo5.get(1).getFsprowprintspan())*a)+","+barcodepo5.get(1).getFspy()+"^A0"+barcodepo5.get(1).getFspnrib()+","+barcodepo5.get(1).getFspsize()+","+barcodepo5.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(2).getFspx())+Integer.parseInt(barcodepo5.get(2).getFsprowprintspan())*a)+","+barcodepo5.get(2).getFspy()+"^A0"+barcodepo5.get(2).getFspnrib()+","+barcodepo5.get(2).getFspsize()+","+barcodepo5.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(3).getFspisprint())){
							if("1".equals(barcodepo5.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(3).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(3).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(3).getFspnrib()+","+barcodepo5.get(3).getFspsize()+","+barcodepo5.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(3).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(3).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(3).getFspnrib()+","+barcodepo5.get(3).getFspsize()+","+barcodepo5.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(4).getFspisprint())){
							if("1".equals(barcodepo5.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(4).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(4).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(4).getFspnrib()+","+barcodepo5.get(4).getFspsize()+","+barcodepo5.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(4).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(4).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(4).getFspnrib()+","+barcodepo5.get(4).getFspsize()+","+barcodepo5.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(5).getFspisprint())){
							if("1".equals(barcodepo5.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(5).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(5).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(5).getFspnrib()+","+barcodepo5.get(5).getFspsize()+","+barcodepo5.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(5).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(5).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(5).getFspnrib()+","+barcodepo5.get(5).getFspsize()+","+barcodepo5.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo5.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(6).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(6).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(6).getFspnrib()+","+barcodepo5.get(6).getFspsize()+","+barcodepo5.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(6).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(6).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(6).getFspnrib()+","+barcodepo5.get(6).getFspsize()+","+barcodepo5.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(7).getFspisprint())){
							if("1".equals(barcodepo5.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(7).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(7).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(7).getFspnrib()+","+barcodepo5.get(7).getFspsize()+","+barcodepo5.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(7).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(7).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(7).getFspnrib()+","+barcodepo5.get(7).getFspsize()+","+barcodepo5.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(8).getFspisprint())){
							if("1".equals(barcodepo5.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(8).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(8).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(8).getFspnrib()+","+barcodepo5.get(8).getFspsize()+","+barcodepo5.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(8).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(8).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(8).getFspnrib()+","+barcodepo5.get(8).getFspsize()+","+barcodepo5.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(9).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(9).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(9).getFspnrib()+","+barcodepo5.get(9).getFspsize()+","+barcodepo5.get(9).getFspsize()+"^FD"+barcodepo5.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(10).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(10).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(10).getFspnrib()+","+barcodepo5.get(10).getFspsize()+","+barcodepo5.get(10).getFspsize()+"^FD"+barcodepo5.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(11).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(11).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(11).getFspnrib()+","+barcodepo5.get(11).getFspsize()+","+barcodepo5.get(11).getFspsize()+"^FD"+barcodepo5.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(12).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(12).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(12).getFspnrib()+","+barcodepo5.get(12).getFspsize()+","+barcodepo5.get(12).getFspsize()+"^FD"+barcodepo5.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(13).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(13).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(13).getFspnrib()+","+barcodepo5.get(13).getFspsize()+","+barcodepo5.get(13).getFspsize()+"^FD"+barcodepo5.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(14).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(14).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(14).getFspnrib()+","+barcodepo5.get(14).getFspsize()+","+barcodepo5.get(14).getFspsize()+"^FD"+barcodepo5.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(15).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(15).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(15).getFspnrib()+","+barcodepo5.get(15).getFspsize()+","+barcodepo5.get(15).getFspsize()+"^FD"+barcodepo5.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(16).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(16).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(16).getFspnrib()+","+barcodepo5.get(16).getFspsize()+","+barcodepo5.get(16).getFspsize()+"^FD"+barcodepo5.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(17).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(17).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(17).getFspnrib()+","+barcodepo5.get(17).getFspsize()+","+barcodepo5.get(17).getFspsize()+"^FD"+barcodepo5.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(18).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(18).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(18).getFspnrib()+","+barcodepo5.get(18).getFspsize()+","+barcodepo5.get(18).getFspsize()+"^FD"+barcodepo5.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo5.get(19).getFspisprint())){
							if("1".equals(barcodepo5.get(19).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(19).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(19).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(19).getFspnrib()+","+barcodepo5.get(19).getFspsize()+","+barcodepo5.get(19).getFspsize()+"^FD\"+ \"效期:\" + printguaranteeperiod[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(19).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(19).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(19).getFspnrib()+","+barcodepo5.get(19).getFspsize()+","+barcodepo5.get(19).getFspsize()+"^FD\"+ printguaranteeperiod[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo5.get(20).getFspisprint())){
							if("1".equals(barcodepo5.get(20).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(20).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(20).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(20).getFspnrib()+","+barcodepo5.get(20).getFspsize()+","+barcodepo5.get(20).getFspsize()+"^FD\"+ \"批号:\" + printbatch[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo5.get(20).getFspx())+Integer.parseInt(barcodepo5.get(0).getFsprowprintspan())*a)+","+barcodepo5.get(20).getFspy()+"^"+barcodepo5.get(0).getFspfont()+barcodepo5.get(20).getFspnrib()+","+barcodepo5.get(20).getFspsize()+","+barcodepo5.get(20).getFspsize()+"^FD\"+ printbatch[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo5.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 6){
					
					out.println("function callPrint6(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print6(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print6(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo6.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo6.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo6.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(0).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(0).getFspy()+"^BQ"+barcodepo6.get(0).getFspnrib()+","+barcodepo6.get(0).getFspsize()+","+barcodepo6.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(1).getFspx())+Integer.parseInt(barcodepo6.get(1).getFsprowprintspan())*a)+","+barcodepo6.get(1).getFspy()+"^A0"+barcodepo6.get(1).getFspnrib()+","+barcodepo6.get(1).getFspsize()+","+barcodepo6.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(2).getFspx())+Integer.parseInt(barcodepo6.get(2).getFsprowprintspan())*a)+","+barcodepo6.get(2).getFspy()+"^A0"+barcodepo6.get(2).getFspnrib()+","+barcodepo6.get(2).getFspsize()+","+barcodepo6.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(3).getFspisprint())){
							if("1".equals(barcodepo6.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(3).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(3).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(3).getFspnrib()+","+barcodepo6.get(3).getFspsize()+","+barcodepo6.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(3).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(3).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(3).getFspnrib()+","+barcodepo6.get(3).getFspsize()+","+barcodepo6.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo6.get(4).getFspisprint())){
							if("1".equals(barcodepo6.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(4).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(4).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(4).getFspnrib()+","+barcodepo6.get(4).getFspsize()+","+barcodepo6.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(4).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(4).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(4).getFspnrib()+","+barcodepo6.get(4).getFspsize()+","+barcodepo6.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo6.get(5).getFspisprint())){
							if("1".equals(barcodepo6.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(5).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(5).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(5).getFspnrib()+","+barcodepo6.get(5).getFspsize()+","+barcodepo6.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(5).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(5).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(5).getFspnrib()+","+barcodepo6.get(5).getFspsize()+","+barcodepo6.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo6.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo6.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(6).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(6).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(6).getFspnrib()+","+barcodepo6.get(6).getFspsize()+","+barcodepo6.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(6).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(6).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(6).getFspnrib()+","+barcodepo6.get(6).getFspsize()+","+barcodepo6.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo6.get(7).getFspisprint())){
							if("1".equals(barcodepo6.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(7).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(7).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(7).getFspnrib()+","+barcodepo6.get(7).getFspsize()+","+barcodepo6.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(7).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(7).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(7).getFspnrib()+","+barcodepo6.get(7).getFspsize()+","+barcodepo6.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo6.get(8).getFspisprint())){
							if("1".equals(barcodepo6.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(8).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(8).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(8).getFspnrib()+","+barcodepo6.get(8).getFspsize()+","+barcodepo6.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(8).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(8).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(8).getFspnrib()+","+barcodepo6.get(8).getFspsize()+","+barcodepo6.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo6.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(9).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(9).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(9).getFspnrib()+","+barcodepo6.get(9).getFspsize()+","+barcodepo6.get(9).getFspsize()+"^FD"+barcodepo6.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(10).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(10).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(10).getFspnrib()+","+barcodepo6.get(10).getFspsize()+","+barcodepo6.get(10).getFspsize()+"^FD"+barcodepo6.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(11).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(11).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(11).getFspnrib()+","+barcodepo6.get(11).getFspsize()+","+barcodepo6.get(11).getFspsize()+"^FD"+barcodepo6.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(12).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(12).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(12).getFspnrib()+","+barcodepo6.get(12).getFspsize()+","+barcodepo6.get(12).getFspsize()+"^FD"+barcodepo6.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(13).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(13).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(13).getFspnrib()+","+barcodepo6.get(13).getFspsize()+","+barcodepo6.get(13).getFspsize()+"^FD"+barcodepo6.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(14).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(14).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(14).getFspnrib()+","+barcodepo6.get(14).getFspsize()+","+barcodepo6.get(14).getFspsize()+"^FD"+barcodepo6.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(15).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(15).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(15).getFspnrib()+","+barcodepo6.get(15).getFspsize()+","+barcodepo6.get(15).getFspsize()+"^FD"+barcodepo6.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(16).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(16).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(16).getFspnrib()+","+barcodepo6.get(16).getFspsize()+","+barcodepo6.get(16).getFspsize()+"^FD"+barcodepo6.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(17).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(17).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(17).getFspnrib()+","+barcodepo6.get(17).getFspsize()+","+barcodepo6.get(17).getFspsize()+"^FD"+barcodepo6.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo6.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo6.get(18).getFspx())+Integer.parseInt(barcodepo6.get(0).getFsprowprintspan())*a)+","+barcodepo6.get(18).getFspy()+"^"+barcodepo6.get(0).getFspfont()+barcodepo6.get(18).getFspnrib()+","+barcodepo6.get(18).getFspsize()+","+barcodepo6.get(18).getFspsize()+"^FD"+barcodepo6.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo6.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 7){
					
					out.println("function callPrint7(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print7(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print7(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo7.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo7.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo7.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(0).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(0).getFspy()+"^BQ"+barcodepo7.get(0).getFspnrib()+","+barcodepo7.get(0).getFspsize()+","+barcodepo7.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(1).getFspx())+Integer.parseInt(barcodepo7.get(1).getFsprowprintspan())*a)+","+barcodepo7.get(1).getFspy()+"^A0"+barcodepo7.get(1).getFspnrib()+","+barcodepo7.get(1).getFspsize()+","+barcodepo7.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(2).getFspx())+Integer.parseInt(barcodepo7.get(2).getFsprowprintspan())*a)+","+barcodepo7.get(2).getFspy()+"^A0"+barcodepo7.get(2).getFspnrib()+","+barcodepo7.get(2).getFspsize()+","+barcodepo7.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(3).getFspisprint())){
							if("1".equals(barcodepo7.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(3).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(3).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(3).getFspnrib()+","+barcodepo7.get(3).getFspsize()+","+barcodepo7.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(3).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(3).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(3).getFspnrib()+","+barcodepo7.get(3).getFspsize()+","+barcodepo7.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo7.get(4).getFspisprint())){
							if("1".equals(barcodepo7.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(4).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(4).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(4).getFspnrib()+","+barcodepo7.get(4).getFspsize()+","+barcodepo7.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(4).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(4).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(4).getFspnrib()+","+barcodepo7.get(4).getFspsize()+","+barcodepo7.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo7.get(5).getFspisprint())){
							if("1".equals(barcodepo7.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(5).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(5).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(5).getFspnrib()+","+barcodepo7.get(5).getFspsize()+","+barcodepo7.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(5).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(5).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(5).getFspnrib()+","+barcodepo7.get(5).getFspsize()+","+barcodepo7.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo7.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo7.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(6).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(6).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(6).getFspnrib()+","+barcodepo7.get(6).getFspsize()+","+barcodepo7.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(6).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(6).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(6).getFspnrib()+","+barcodepo7.get(6).getFspsize()+","+barcodepo7.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo7.get(7).getFspisprint())){
							if("1".equals(barcodepo7.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(7).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(7).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(7).getFspnrib()+","+barcodepo7.get(7).getFspsize()+","+barcodepo7.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(7).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(7).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(7).getFspnrib()+","+barcodepo7.get(7).getFspsize()+","+barcodepo7.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo7.get(8).getFspisprint())){
							if("1".equals(barcodepo7.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(8).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(8).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(8).getFspnrib()+","+barcodepo7.get(8).getFspsize()+","+barcodepo7.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(8).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(8).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(8).getFspnrib()+","+barcodepo7.get(8).getFspsize()+","+barcodepo7.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo7.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(9).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(9).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(9).getFspnrib()+","+barcodepo7.get(9).getFspsize()+","+barcodepo7.get(9).getFspsize()+"^FD"+barcodepo7.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(10).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(10).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(10).getFspnrib()+","+barcodepo7.get(10).getFspsize()+","+barcodepo7.get(10).getFspsize()+"^FD"+barcodepo7.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(11).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(11).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(11).getFspnrib()+","+barcodepo7.get(11).getFspsize()+","+barcodepo7.get(11).getFspsize()+"^FD"+barcodepo7.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(12).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(12).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(12).getFspnrib()+","+barcodepo7.get(12).getFspsize()+","+barcodepo7.get(12).getFspsize()+"^FD"+barcodepo7.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(13).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(13).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(13).getFspnrib()+","+barcodepo7.get(13).getFspsize()+","+barcodepo7.get(13).getFspsize()+"^FD"+barcodepo7.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(14).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(14).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(14).getFspnrib()+","+barcodepo7.get(14).getFspsize()+","+barcodepo7.get(14).getFspsize()+"^FD"+barcodepo7.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(15).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(15).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(15).getFspnrib()+","+barcodepo7.get(15).getFspsize()+","+barcodepo7.get(15).getFspsize()+"^FD"+barcodepo7.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(16).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(16).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(16).getFspnrib()+","+barcodepo7.get(16).getFspsize()+","+barcodepo7.get(16).getFspsize()+"^FD"+barcodepo7.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(17).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(17).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(17).getFspnrib()+","+barcodepo7.get(17).getFspsize()+","+barcodepo7.get(17).getFspsize()+"^FD"+barcodepo7.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo7.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo7.get(18).getFspx())+Integer.parseInt(barcodepo7.get(0).getFsprowprintspan())*a)+","+barcodepo7.get(18).getFspy()+"^"+barcodepo7.get(0).getFspfont()+barcodepo7.get(18).getFspnrib()+","+barcodepo7.get(18).getFspsize()+","+barcodepo7.get(18).getFspsize()+"^FD"+barcodepo7.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo7.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 8){
					
					out.println("function callPrint8(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print8(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print8(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo8.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo8.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo8.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(0).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(0).getFspy()+"^BQ"+barcodepo8.get(0).getFspnrib()+","+barcodepo8.get(0).getFspsize()+","+barcodepo8.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(1).getFspx())+Integer.parseInt(barcodepo8.get(1).getFsprowprintspan())*a)+","+barcodepo8.get(1).getFspy()+"^A0"+barcodepo8.get(1).getFspnrib()+","+barcodepo8.get(1).getFspsize()+","+barcodepo8.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(2).getFspx())+Integer.parseInt(barcodepo8.get(2).getFsprowprintspan())*a)+","+barcodepo8.get(2).getFspy()+"^A0"+barcodepo8.get(2).getFspnrib()+","+barcodepo8.get(2).getFspsize()+","+barcodepo8.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(3).getFspisprint())){
							if("1".equals(barcodepo8.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(3).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(3).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(3).getFspnrib()+","+barcodepo8.get(3).getFspsize()+","+barcodepo8.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(3).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(3).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(3).getFspnrib()+","+barcodepo8.get(3).getFspsize()+","+barcodepo8.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo8.get(4).getFspisprint())){
							if("1".equals(barcodepo8.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(4).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(4).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(4).getFspnrib()+","+barcodepo8.get(4).getFspsize()+","+barcodepo8.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(4).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(4).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(4).getFspnrib()+","+barcodepo8.get(4).getFspsize()+","+barcodepo8.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo8.get(5).getFspisprint())){
							if("1".equals(barcodepo8.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(5).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(5).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(5).getFspnrib()+","+barcodepo8.get(5).getFspsize()+","+barcodepo8.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(5).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(5).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(5).getFspnrib()+","+barcodepo8.get(5).getFspsize()+","+barcodepo8.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo8.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo8.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(6).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(6).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(6).getFspnrib()+","+barcodepo8.get(6).getFspsize()+","+barcodepo8.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(6).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(6).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(6).getFspnrib()+","+barcodepo8.get(6).getFspsize()+","+barcodepo8.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo8.get(7).getFspisprint())){
							if("1".equals(barcodepo8.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(7).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(7).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(7).getFspnrib()+","+barcodepo8.get(7).getFspsize()+","+barcodepo8.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(7).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(7).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(7).getFspnrib()+","+barcodepo8.get(7).getFspsize()+","+barcodepo8.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo8.get(8).getFspisprint())){
							if("1".equals(barcodepo8.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(8).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(8).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(8).getFspnrib()+","+barcodepo8.get(8).getFspsize()+","+barcodepo8.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(8).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(8).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(8).getFspnrib()+","+barcodepo8.get(8).getFspsize()+","+barcodepo8.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo8.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(9).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(9).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(9).getFspnrib()+","+barcodepo8.get(9).getFspsize()+","+barcodepo8.get(9).getFspsize()+"^FD"+barcodepo8.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(10).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(10).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(10).getFspnrib()+","+barcodepo8.get(10).getFspsize()+","+barcodepo8.get(10).getFspsize()+"^FD"+barcodepo8.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(11).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(11).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(11).getFspnrib()+","+barcodepo8.get(11).getFspsize()+","+barcodepo8.get(11).getFspsize()+"^FD"+barcodepo8.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(12).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(12).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(12).getFspnrib()+","+barcodepo8.get(12).getFspsize()+","+barcodepo8.get(12).getFspsize()+"^FD"+barcodepo8.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(13).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(13).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(13).getFspnrib()+","+barcodepo8.get(13).getFspsize()+","+barcodepo8.get(13).getFspsize()+"^FD"+barcodepo8.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(14).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(14).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(14).getFspnrib()+","+barcodepo8.get(14).getFspsize()+","+barcodepo8.get(14).getFspsize()+"^FD"+barcodepo8.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(15).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(15).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(15).getFspnrib()+","+barcodepo8.get(15).getFspsize()+","+barcodepo8.get(15).getFspsize()+"^FD"+barcodepo8.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(16).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(16).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(16).getFspnrib()+","+barcodepo8.get(16).getFspsize()+","+barcodepo8.get(16).getFspsize()+"^FD"+barcodepo8.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(17).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(17).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(17).getFspnrib()+","+barcodepo8.get(17).getFspsize()+","+barcodepo8.get(17).getFspsize()+"^FD"+barcodepo8.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo8.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo8.get(18).getFspx())+Integer.parseInt(barcodepo8.get(0).getFsprowprintspan())*a)+","+barcodepo8.get(18).getFspy()+"^"+barcodepo8.get(0).getFspfont()+barcodepo8.get(18).getFspnrib()+","+barcodepo8.get(18).getFspsize()+","+barcodepo8.get(18).getFspsize()+"^FD"+barcodepo8.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo8.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 9){
					
					out.println("function callPrint9(barCodes,brandnames,sources,specs,colors,retailprices,persons){ ");
					out.println("	var barCode = ''; ");
					out.println("	var brandname = ''; ");
					out.println("	var source = ''; ");
					out.println("	var spec = ''; ");
					out.println("	var color = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var person = ''; ");
					out.println("	for(var cStr = 0; cStr < barCodes.length; cStr++){ ");
					out.println("		barCode = barCode + barCodes[cStr] + '|'; ");
					out.println("		brandname = brandname + brandnames[cStr] + '|'; ");
					out.println("		source = source + sources[cStr] + '|'; ");
					out.println("		spec = spec + specs[cStr] + '|'; ");
					out.println("		color = color + colors[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		person = person + persons[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print9(barCode,brandname,source,spec,color,retailprice,person); ");
					out.println("} ");
					
					out.println("function Print9(barCode,brandname,source,spec,color,retailprice,person){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printbrandname = new Array(); ");
					out.println("	printbrandname = brandname.split('|'); ");
					out.println("	var printsource = new Array(); ");
					out.println("	printsource = source.split('|'); ");
					out.println("	var printspec = new Array(); ");
					out.println("	printspec = spec.split('|'); ");
					out.println("	var printcolor = new Array(); ");
					out.println("	printcolor = color.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|'); ");
					out.println("	var printperson = new Array(); ");
					out.println("	printperson = person.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo9.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) {   ");
						
					out.println("		printstr = printstr + \"^XA\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo9.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						
						if("1".equals(barcodepo9.get(0).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(0).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(0).getFspy()+"^BQ"+barcodepo9.get(0).getFspnrib()+","+barcodepo9.get(0).getFspsize()+","+barcodepo9.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(1).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(1).getFspx())+Integer.parseInt(barcodepo9.get(1).getFsprowprintspan())*a)+","+barcodepo9.get(1).getFspy()+"^A0"+barcodepo9.get(1).getFspnrib()+","+barcodepo9.get(1).getFspsize()+","+barcodepo9.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(2).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(2).getFspx())+Integer.parseInt(barcodepo9.get(2).getFsprowprintspan())*a)+","+barcodepo9.get(2).getFspy()+"^A0"+barcodepo9.get(2).getFspnrib()+","+barcodepo9.get(2).getFspsize()+","+barcodepo9.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(13) + \"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(3).getFspisprint())){
							if("1".equals(barcodepo9.get(3).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(3).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(3).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(3).getFspnrib()+","+barcodepo9.get(3).getFspsize()+","+barcodepo9.get(3).getFspsize()+"^FD\"+ \"品种:\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(3).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(3).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(3).getFspnrib()+","+barcodepo9.get(3).getFspsize()+","+barcodepo9.get(3).getFspsize()+"^FD\"+ printbrandname[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo9.get(4).getFspisprint())){
							if("1".equals(barcodepo9.get(4).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(4).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(4).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(4).getFspnrib()+","+barcodepo9.get(4).getFspsize()+","+barcodepo9.get(4).getFspsize()+"^FD\"+ \"产地:\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(4).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(4).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(4).getFspnrib()+","+barcodepo9.get(4).getFspsize()+","+barcodepo9.get(4).getFspsize()+"^FD\"+ printsource[i+"+a+"]+\"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo9.get(5).getFspisprint())){
							if("1".equals(barcodepo9.get(5).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(5).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(5).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(5).getFspnrib()+","+barcodepo9.get(5).getFspsize()+","+barcodepo9.get(5).getFspsize()+"^FD\"+ \"规格:\" + printspec[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(5).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(5).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(5).getFspnrib()+","+barcodepo9.get(5).getFspsize()+","+barcodepo9.get(5).getFspsize()+"^FD\"+ printspec[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo9.get(6).getFspisprint())){
							out.println("			var printctype = \"色号:\"; ");
							out.println("			if(printbarCode[i+"+a+"].substring(0,1).trim() == \"8\"){ ");
							out.println("				printctype = \"球镜:\"; ");
							out.println("			} ");
							
							if("1".equals(barcodepo9.get(6).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(6).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(6).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(6).getFspnrib()+","+barcodepo9.get(6).getFspsize()+","+barcodepo9.get(6).getFspsize()+"^FD\"+ printctype + printcolor[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(6).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(6).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(6).getFspnrib()+","+barcodepo9.get(6).getFspsize()+","+barcodepo9.get(6).getFspsize()+"^FD\"+ printcolor[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo9.get(7).getFspisprint())){
							if("1".equals(barcodepo9.get(7).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(7).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(7).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(7).getFspnrib()+","+barcodepo9.get(7).getFspsize()+","+barcodepo9.get(7).getFspsize()+"^FD\"+ \"售价:\" + printretailprice[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(7).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(7).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(7).getFspnrib()+","+barcodepo9.get(7).getFspsize()+","+barcodepo9.get(7).getFspsize()+"^FD\"+ printretailprice[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo9.get(8).getFspisprint())){
							if("1".equals(barcodepo9.get(8).getFspishowbarcodename())){
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(8).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(8).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(8).getFspnrib()+","+barcodepo9.get(8).getFspsize()+","+barcodepo9.get(8).getFspsize()+"^FD\"+ \"物价员:\" + printperson[i+"+a+"] + \"^FS\"; ");
							}else{
								out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(8).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(8).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(8).getFspnrib()+","+barcodepo9.get(8).getFspsize()+","+barcodepo9.get(8).getFspsize()+"^FD\"+ printperson[i+"+a+"] + \"^FS\"; ");
							}
						}
						
						if("1".equals(barcodepo9.get(9).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(9).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(9).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(9).getFspnrib()+","+barcodepo9.get(9).getFspsize()+","+barcodepo9.get(9).getFspsize()+"^FD"+barcodepo9.get(9).getFspyouthink1()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(10).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(10).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(10).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(10).getFspnrib()+","+barcodepo9.get(10).getFspsize()+","+barcodepo9.get(10).getFspsize()+"^FD"+barcodepo9.get(10).getFspyouthink2()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(11).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(11).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(11).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(11).getFspnrib()+","+barcodepo9.get(11).getFspsize()+","+barcodepo9.get(11).getFspsize()+"^FD"+barcodepo9.get(11).getFspyouthink3()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(12).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(12).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(12).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(12).getFspnrib()+","+barcodepo9.get(12).getFspsize()+","+barcodepo9.get(12).getFspsize()+"^FD"+barcodepo9.get(12).getFspyouthink4()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(13).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(13).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(13).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(13).getFspnrib()+","+barcodepo9.get(13).getFspsize()+","+barcodepo9.get(13).getFspsize()+"^FD"+barcodepo9.get(13).getFspyouthink5()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(14).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(14).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(14).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(14).getFspnrib()+","+barcodepo9.get(14).getFspsize()+","+barcodepo9.get(14).getFspsize()+"^FD"+barcodepo9.get(14).getFspyouthink6()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(15).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(15).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(15).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(15).getFspnrib()+","+barcodepo9.get(15).getFspsize()+","+barcodepo9.get(15).getFspsize()+"^FD"+barcodepo9.get(15).getFspyouthink7()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(16).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(16).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(16).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(16).getFspnrib()+","+barcodepo9.get(16).getFspsize()+","+barcodepo9.get(16).getFspsize()+"^FD"+barcodepo9.get(16).getFspyouthink8()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(17).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(17).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(17).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(17).getFspnrib()+","+barcodepo9.get(17).getFspsize()+","+barcodepo9.get(17).getFspsize()+"^FD"+barcodepo9.get(17).getFspyouthink9()+"^FS\"; ");
						}
						
						if("1".equals(barcodepo9.get(18).getFspisprint())){
							out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo9.get(18).getFspx())+Integer.parseInt(barcodepo9.get(0).getFsprowprintspan())*a)+","+barcodepo9.get(18).getFspy()+"^"+barcodepo9.get(0).getFspfont()+barcodepo9.get(18).getFspnrib()+","+barcodepo9.get(18).getFspsize()+","+barcodepo9.get(18).getFspsize()+"^FD"+barcodepo9.get(18).getFspyouthink10()+"^FS\"; ");
						}
						
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						
						if(a>0){
							out.println("		} ");
						}
					} 
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo9.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 10){
					
					out.println("function printBarCodeForBrand(barCode, quantity, retailprice,brandName) {	 ");
					out.println("	var printCode = new Array(); ");
					out.println("	var retailprices = new Array(); ");
					out.println("	var brandNames = new Array(); ");
					out.println("	for(var i = 0;i< barCode.length; i++){ ");
					out.println("		for(var a = 0; a < quantity[i]; a++){  ");
					out.println("			printCode[printCode.length] = barCode[i]; ");
					out.println("			retailprices[retailprices.length] = retailprice[i]; ");
					out.println("			brandNames[brandNames.length] = brandName[i]; ");
					out.println("		} ");
					out.println("	} ");
					out.println("	callPrintForBrand(printCode,retailprices,brandNames); ");
					out.println("} ");
					
					out.println("function callPrintForBrand(printBarcode,retailprices,brandNames){ ");
					out.println("	var str = ''; ");
					out.println("	var retailprice = ''; ");
					out.println("	var brandName = ''; ");
					out.println("	for(var cStr = 0; cStr < printBarcode.length; cStr++){ ");
					out.println("		str = str + printBarcode[cStr] + '|'; ");
					out.println("		retailprice = retailprice + retailprices[cStr] + '|'; ");
					out.println("		brandName = brandName + brandNames[cStr] + '|'; ");
					out.println("	} ");
					out.println("	Print10(str,retailprice, 0, brandName); ");
					out.println("} ");
					
					out.println("function Print10(barCode,retailprice, flag, brandName){ ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barCode.split('|'); ");
					out.println("	var printretailprice = new Array(); ");
					out.println("	printretailprice = retailprice.split('|');	 ");
					out.println("	var printbrandName = new Array(); ");
					out.println("	printbrandName = brandName.split('|');	 ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查条码打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo10.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\";   ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) { ");
					out.println("		printstr = printstr + \"^XA^LH10,10\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo10.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						out.println("			printstr = printstr + \"^BY2,2.0,10^LH0,0^FO"+(Integer.parseInt(barcodepo10.get(0).getFspx())+Integer.parseInt(barcodepo10.get(0).getFsprowprintspan())*a)+","+barcodepo10.get(0).getFspy()+"^BQN,"+barcodepo10.get(0).getFspsize()+","+barcodepo10.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo10.get(1).getFspx())+Integer.parseInt(barcodepo10.get(1).getFsprowprintspan())*a)+","+barcodepo10.get(1).getFspy()+"^"+barcodepo10.get(0).getFspfont()+","+barcodepo10.get(1).getFspsize()+","+barcodepo10.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,13) + \"^FS\"; ");
						out.println("			printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo10.get(2).getFspx())+Integer.parseInt(barcodepo10.get(2).getFsprowprintspan())*a)+","+barcodepo10.get(2).getFspy()+"^"+barcodepo10.get(0).getFspfont()+"N,"+barcodepo10.get(2).getFspsize()+","+barcodepo10.get(2).getFspsize()+"^FD\"+ printbrandName[i+"+a+"].substring(0,9) +\"^FS\";	");	
						out.println("			printstr = printstr + \"^PQ1^FS\"; ");
						if(a>0){
							out.println("		} ");
						}
					}
					out.println("		printstr = printstr + \"^XZ\"; ");
							
					out.println("		i=i+"+(Integer.parseInt(barcodepo10.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
				}else if(i == 12){
					out.println("function callPrintForDiscountNum(barCode,discountNm,quantity) {	 ");
					out.println("	var printCode = new Array(); ");
					out.println("	var discountNms = new Array(); ");
					out.println("	for(var i = 0;i< barCode.length; i++){ ");
					out.println("		for(var a = 0; a < quantity[i]; a++){  ");
					out.println("			printCode[printCode.length] = barCode[i]; ");
					out.println("			discountNms[discountNms.length] = discountNm[i]; ");
					out.println("		} ");
					out.println("	} ");
					out.println("	callPrintForDiscountNum1(printCode,discountNms); ");
					out.println("} ");
					
					out.println("function callPrintForDiscountNum1(printCode,discountNm){ ");
					out.println("	var printCodes = ''; ");
					out.println("	var discountNms = ''; ");
					out.println("	for(var i = 0; i < printCode.length; i++){ ");
					out.println("		printCodes = printCodes + printCode[i] + '|'; ");
					out.println("		discountNms = discountNms + discountNm[i] + '|'; ");
					out.println("	} ");
					out.println("	PrintForDiscountNum(printCodes,discountNms); ");
					out.println("} ");
					
					out.println("function PrintForDiscountNum(barcode,discountNm) { ");
					out.println("	var printbarCode = new Array(); ");
					out.println("	printbarCode = barcode.split('|'); ");
					out.println("	var printdiscount = new Array(); ");
					out.println("	printdiscount = discountNm.split('|'); ");
					out.println("	var num=1; ");
					out.println("	var fso,f1,ts,s; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo12.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\"; ");
					out.println("	for (var i = 0; i < printbarCode.length-1; i++) { ");
					out.println("		printstr = printstr + \"^XA^LH10,10\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^AI26\"; ");
					
					for(int a=0; a<Integer.parseInt(barcodepo12.get(0).getFsprowprintnum()); a++){
						if(a>0){
							out.println("		if(printbarCode[i+"+a+"]){ ");
						}
						out.println("	printstr = printstr + \"^BY2,2.0,10^LH0,0\"; ");
						out.println("	printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo12.get(0).getFspx())+Integer.parseInt(barcodepo12.get(0).getFsprowprintspan())*a)+","+barcodepo12.get(0).getFspy()+"^BQN,"+barcodepo12.get(0).getFspsize()+","+barcodepo12.get(0).getFspsize()+"^FDQM,A\" + printbarCode[i+"+a+"] + \"^FS\"; ");
						out.println("	printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo12.get(1).getFspx())+Integer.parseInt(barcodepo12.get(0).getFsprowprintspan())*a)+","+barcodepo12.get(1).getFspy()+"^"+barcodepo12.get(0).getFspfont()+","+barcodepo12.get(1).getFspsize()+","+barcodepo12.get(1).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(0,14) + \"^FS\"; ");
						out.println("	printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo12.get(2).getFspx())+Integer.parseInt(barcodepo12.get(0).getFsprowprintspan())*a)+","+barcodepo12.get(2).getFspy()+"^"+barcodepo12.get(0).getFspfont()+","+barcodepo12.get(2).getFspsize()+","+barcodepo12.get(2).getFspsize()+"^FD\" + printbarCode[i+"+a+"].substring(14) + \"^FS\"; ");
						out.println("	printstr = printstr + \"^FO"+(Integer.parseInt(barcodepo12.get(3).getFspx())+Integer.parseInt(barcodepo12.get(0).getFsprowprintspan())*a)+","+barcodepo12.get(3).getFspy()+"^"+barcodepo12.get(0).getFspfont()+","+barcodepo12.get(3).getFspsize()+","+barcodepo12.get(3).getFspsize()+"^FD\" + \"Discount: \"+ printdiscount[i+"+a+"] + \"^FS\"; ");
						out.println("	printstr = printstr + \"^PQ1^FS\"; ");
						if(a>0){
							out.println("		} ");
						}
					}
					out.println("		printstr = printstr + \"^XZ\"; ");
					out.println("		i=i+"+(Integer.parseInt(barcodepo12.get(0).getFsprowprintnum())-1)+"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close(); ");
					out.println("} ");
					
				}else if(i == 11){
					
					out.println("function PrintJQ(text,num){ ");
					out.println("	var fso,f1; ");
					out.println("	var ForReading = 1; ");
					out.println("	fso = new ActiveXObject(\"Scripting.FileSystemObject\"); ");
					out.println("	if(fso==null){ ");
					out.println("		alert(\"请检查打印机！\"); ");
					out.println("		return false; ");
					out.println("	} ");
					out.println("	f1 = fso.CreateTextFile(\""+barcodepo11.get(0).getFspport()+":\",true,true); ");
					out.println("	var printstr = \"\";   ");
					out.println("	printstr = printstr + \"\\x1B\\x40\"; ");
					out.println("	for (var i = 0; i < num; i++) {		 ");
					out.println("		printstr = printstr + \"^XA^LH10,10\"; ");
					out.println("		printstr = printstr + \"^MD21\"; ");
					out.println("		printstr = printstr + \"^CWX,E:MSUNG24.FNT^FS\"; ");
					out.println("		printstr = printstr + \"^BY2,2.0,10^LH0,0^AI26\"; ");
					out.println("		printstr = printstr + \"^FO"+barcodepo11.get(0).getFspx()+","+barcodepo11.get(0).getFspy()+"^"+barcodepo11.get(0).getFspfont()+"N,"+barcodepo11.get(0).getFspsize()+","+barcodepo11.get(0).getFspsize()+"^FH\\^FDRMB:^FS\"; ");
					out.println("		printstr = printstr + \"^FO"+barcodepo11.get(1).getFspx()+","+barcodepo11.get(1).getFspy()+"^"+barcodepo11.get(0).getFspfont()+"N,"+barcodepo11.get(1).getFspsize()+","+barcodepo11.get(1).getFspsize()+"^FH\\^FD\"+text+\"^FS\"; ");
					out.println("		printstr = printstr + \"^PQ1,0,1,Y^XZ\"; ");
					out.println("	} ");
					out.println("	f1.Write(printstr); ");
					out.println("	f1.close();	");
					out.println("} ");
				}
			}
			
			out.println("  </script> ");
			out.println("  <body> ");
			out.println("  </body> ");
			out.println("</html> ");

		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if("10".equals(ctype)){
			return "brand";
		}else if("11".equals(ctype)){
			return "jq";
		}else if("12".equals(ctype)){
			return "discount";
		}else{
			return SUCCESS;
		}
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<AreaPo> getArea1List() {
		return area1List;
	}

	public void setArea1List(List<AreaPo> area1List) {
		this.area1List = area1List;
	}

	public List<AreaPo> getArea2List() {
		return area2List;
	}

	public void setArea2List(List<AreaPo> area2List) {
		this.area2List = area2List;
	}

	public List<AreaPo> getArea3List() {
		return area3List;
	}

	public void setArea3List(List<AreaPo> area3List) {
		this.area3List = area3List;
	}

	public List<AreaPo> getArea4List() {
		return area4List;
	}

	public void setArea4List(List<AreaPo> area4List) {
		this.area4List = area4List;
	}

	public List<AreaPo> getArea5List() {
		return area5List;
	}

	public void setArea5List(List<AreaPo> area5List) {
		this.area5List = area5List;
	}

	public AreaMgr getAreaMgr() {
		return areaMgr;
	}

	public void setAreaMgr(AreaMgr areaMgr) {
		this.areaMgr = areaMgr;
	}
	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}

	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}

	public ReminderWindowMgr getReminderWindowMgr() {
		return reminderWindowMgr;
	}

	public void setReminderWindowMgr(ReminderWindowMgr reminderWindowMgr) {
		this.reminderWindowMgr = reminderWindowMgr;
	}	
}
