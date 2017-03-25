package com.pengsheng.eims.member.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.member.mgr.SmsSetMgr;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SmsSetAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;	
	private SmsSetMgr smsSetMgr;	
	private SendNoteMgr sendNoteMgr;
	private SmsSetPo smsSetPo;	
	private List<SmsRecordPo> smsRecordPos; 
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private UnitMgr unitMgr;
	private List<NoteTemplatePo> noteTypeList = null;
	
	/**
	 * 初始化短信维护查询
	 */
	public String initSmsSetSel() throws Exception {
		
		smsSetPo=smsSetMgr.getSmsSetPo();
		
		return SUCCESS;
	}
	
	/**
	 * 修改短信维护信息
	 * @return
	 * @throws Exception
	 */
	public String updateSmsSet() throws Exception {
		
		String id = Utility.getName(request.getParameter("id"));
		String birthdayflag = Utility.getName(request.getParameter("birthdayflag"));
 		String birthdaydate = Utility.getName(request.getParameter("birthdaydate"));
		String birthdaytime = Utility.getName(request.getParameter("birthdaytime"));
 		String birthdaycontent = Utility.getName(request.getParameter("birthdaycontent"));
		String remindflag = Utility.getName(request.getParameter("remindflag"));
		String remindcontent = Utility.getName(request.getParameter("remindcontent"));
 		String delaysflag = Utility.getName(request.getParameter("delaysflag"));
		String delayscontent = Utility.getName(request.getParameter("delayscontent"));
		String visitflag = Utility.getName(request.getParameter("visitflag"));
		String visitdate = Utility.getName(request.getParameter("visitdate"));
 		String visittime = Utility.getName(request.getParameter("visittime"));
 		String visitcontent = Utility.getName(request.getParameter("visitcontent"));
	  
 		//生日提醒
 		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
 		
		SmsSetPo smsSetPo=new SmsSetPo();

		smsSetPo.setFssid(id);
  		if("1".equals(birthdayflag)){
			smsSetPo.setFssbirthdayflag("1");
		}else if("".equals(birthdayflag)){
			smsSetPo.setFssbirthdayflag("0");
		}
		smsSetPo.setFssbirthdaydate(birthdaydate);
		smsSetPo.setFssbirthdaytime(birthdaytime);
		smsSetPo.setFssbirthdaycontent(birthdaycontent);
		if("1".equals(remindflag)){
			smsSetPo.setFssremindflag("1");
		}else if("".equals(remindflag)){
			smsSetPo.setFssremindflag("0");
		}
		smsSetPo.setFssremindcontent(remindcontent);
		if("1".equals(delaysflag)){
			smsSetPo.setFssdelaysflag("1");
		}else if("".equals(delaysflag)){
			smsSetPo.setFssdelaysflag("0");
		}
		smsSetPo.setFssdelayscontent(delayscontent);
		if("1".equals(visitflag)){
			smsSetPo.setFssvisitflag("1");
		}else if("".equals(visitflag)){
			smsSetPo.setFssvisitflag("0");
		}
		smsSetPo.setFssvisitdate(visitdate);
		smsSetPo.setFssvisittime(visittime);
		smsSetPo.setFssvisitcontent(visitcontent);
		
		
		smsSetMgr.updateSmsSetPo(smsSetPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.MOVE);
		
		request.setAttribute("url", "'initSmsSetSel.action'");
		
		return SUCCESS;
		
	}
	
	/**
	 * 加载查询短信信息页
	 */
	public String initSelectSmsRecord() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		noteTypeList = unitMgr.getAllNoteTemplateList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectSmsRecord";
		}		
		return SUCCESS;
	}
	
	/**
	 * 加载查询短信信息页
	 */
	public String selectSmsRecord() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		SmsRecordPo po = new SmsRecordPo();
		
		String fsrreceiptpersont = Utility.getName(request.getParameter("fsrreceiptpersont"));
		String fsrreceipttelt = Utility.getName(request.getParameter("fsrreceipttelt"));
		String fsrbegindate = Utility.getName(request.getParameter("fsrbegindate"));
		String fsrenddate = Utility.getName(request.getParameter("fsrenddate"));
		String fsrsendpersont = Utility.getName(request.getParameter("fsrsendpersont"));
		String fsrsendpersonnamet = Utility.getName(request.getParameter("fsrsendpersonnamet"));
		String fsrsendflagt = Utility.getName(request.getParameter("fsrsendflagt"));
		String fsrsendtypet = Utility.getName(request.getParameter("fsrsendtypet"));
		
		po.setFsrreceiptpersont(fsrreceiptpersont);
		po.setFsrreceipttelt(fsrreceipttelt);
		po.setFsrbegindate(fsrbegindate);
		po.setFsrenddate(fsrenddate);
		po.setFsrsendpersont(fsrsendpersont);
		po.setFsrsendpersonnamet(fsrsendpersonnamet);
		po.setFsrsendflag(fsrsendflagt);
		po.setFsrsendtype(fsrsendtypet);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setFsrcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		int count = smsSetMgr.selectSmsRecordCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			smsRecordPos = smsSetMgr.selectSmsRecordList(po,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			smsRecordPos = null;
		}
		String smsCount = "";
		
		if(systemParameterPo.getFspshortmessagename()!=null&&!systemParameterPo.getFspshortmessagename().equals("")&&systemParameterPo.getFspshortmessagepw()!=null&&!systemParameterPo.getFspshortmessagepw().equals("")){
			String resultSms = "";
			try {
				resultSms = sendNoteMgr.getSmsCount();
			} catch (Exception e) {
				resultSms = "短信接口参数配置错误";
			}
			if(resultSms!=null&&!resultSms.equals("")){	
				smsCount = resultSms;
			}
		}else{
			smsCount = "短信接口参数未配置";//短信接口参数未配置；
		}
		
		request.setAttribute("smsCount", smsCount);
		request.setAttribute("fsrreceiptpersont", fsrreceiptpersont);
		request.setAttribute("fsrreceipttelt", fsrreceipttelt);
		request.setAttribute("fsrbegindate", fsrbegindate);
		request.setAttribute("fsrenddate", fsrenddate);
		request.setAttribute("fsrsendpersont", fsrsendpersont);
		request.setAttribute("fsrsendpersonnamet", fsrsendpersonnamet);
		request.setAttribute("fsrsendflagt", fsrsendflagt);
		request.setAttribute("fsrsendtypet", fsrsendtypet);
		
		noteTypeList = unitMgr.getAllNoteTemplateList();
		
		return SUCCESS;
	}

	/**
	 * 查询准备重新发送的短信
	 */
	public String selReSendMessage() throws Exception {

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
		
		String fsrreceiptpersont = Utility.getName(request.getParameter("fsrreceiptpersont"));
		String fsrreceipttelt = Utility.getName(request.getParameter("fsrreceipttelt"));
		String fsrbegindate = Utility.getName(request.getParameter("fsrbegindate"));
		String fsrenddate = Utility.getName(request.getParameter("fsrenddate"));
		String fsrsendpersont = Utility.getName(request.getParameter("fsrsendpersont"));
		String fsrsendpersonnamet = Utility.getName(request.getParameter("fsrsendpersonnamet"));
		String fsrsendflagt = Utility.getName(request.getParameter("fsrsendflagt"));
		String fsrsendtypet = Utility.getName(request.getParameter("fsrsendtypet"));
		
		SmsRecordPo po = new SmsRecordPo();
		
		po.setFsrreceiptpersont(fsrreceiptpersont);
		po.setFsrreceipttelt(fsrreceipttelt);
		po.setFsrbegindate(fsrbegindate);
		po.setFsrenddate(fsrenddate);
		po.setFsrsendpersont(fsrsendpersont);
		po.setFsrsendpersonnamet(fsrsendpersonnamet);
		po.setFsrsendflag(fsrsendflagt);
		po.setFsrsendtype(fsrsendtypet);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			po.setFsrcompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		int count = smsSetMgr.selectSmsRecordCount(po);
		request.setAttribute("count",count);
		
		request.setAttribute("fsrreceiptpersont", fsrreceiptpersont);
		request.setAttribute("fsrreceipttelt", fsrreceipttelt);
		request.setAttribute("fsrbegindate", fsrbegindate);
		request.setAttribute("fsrenddate", fsrenddate);
		request.setAttribute("fsrsendpersont", fsrsendpersont);
		request.setAttribute("fsrsendpersonnamet", fsrsendpersonnamet);
		request.setAttribute("fsrsendflagt", fsrsendflagt);
		request.setAttribute("fsrsendtypet", fsrsendtypet);
		
		return SUCCESS;
	}
	/**
	 * 发送短信
	 */
	public String insertReSendMessage() throws Exception {
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
		
		SendNotePo snpo = new SendNotePo();
		snpo.setSnpersonid(personInfoPo1.getId());
		snpo.setSndepartmentid(personInfoPo1.getDepartmentID());
		snpo.setSnnotetypeid("15");
		snpo.setSnsenddate("");
		
		String fsrreceiptpersont = Utility.getName(request.getParameter("fsrreceiptpersont"));
		String fsrreceipttelt = Utility.getName(request.getParameter("fsrreceipttelt"));
		String fsrbegindate = Utility.getName(request.getParameter("fsrbegindate"));
		String fsrenddate = Utility.getName(request.getParameter("fsrenddate"));
		String fsrsendpersont = Utility.getName(request.getParameter("fsrsendpersont"));
		String fsrsendpersonnamet = Utility.getName(request.getParameter("fsrsendpersonnamet"));
		String fsrsendflagt = Utility.getName(request.getParameter("fsrsendflagt"));
		String fsrsendtypet = Utility.getName(request.getParameter("fsrsendtypet"));
		String sendContent = Utility.getName(request.getParameter("sendContent"));
		String newSendContent = Utility.getName(request.getParameter("newSendContent"));
		
		SmsRecordPo po = new SmsRecordPo();
		
		po.setFsrreceiptpersont(fsrreceiptpersont);
		po.setFsrreceipttelt(fsrreceipttelt);
		po.setFsrbegindate(fsrbegindate);
		po.setFsrenddate(fsrenddate);
		po.setFsrsendpersont(fsrsendpersont);
		po.setFsrsendpersonnamet(fsrsendpersonnamet);
		po.setFsrsendflag(fsrsendflagt);
		po.setFsrsendtype(fsrsendtypet);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			po.setFsrcompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		smsSetMgr.reSemdSmsRecord(po, snpo,sendContent,newSendContent);
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;		
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}
	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<NoteTemplatePo> getNoteTypeList() {
		return noteTypeList;
	}

	public void setNoteTypeList(List<NoteTemplatePo> noteTypeList) {
		this.noteTypeList = noteTypeList;
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public SmsSetMgr getSmsSetMgr() {
		return smsSetMgr;
	}

	public void setSmsSetMgr(SmsSetMgr smsSetMgr) {
		this.smsSetMgr = smsSetMgr;
	}

	public SmsSetPo getSmsSetPo() {
		return smsSetPo;
	}

	public void setSmsSetPo(SmsSetPo smsSetPo) {
		this.smsSetPo = smsSetPo;
	}
	
	public List<SmsRecordPo> getSmsRecordPos() {
		return smsRecordPos;
	}

	public void setSmsRecordPos(List<SmsRecordPo> smsRecordPos) {
		this.smsRecordPos = smsRecordPos;
	}	
}
