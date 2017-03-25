package com.pengsheng.eims.hydsycasehistory.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.hydsycasehistory.mgr.EyesCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.GlassesHistoryHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HisInfoPo;
import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesHistoryHydsyAction extends BaseAction {
	
	private List<CornealContactlLensPo> cornealContactlLensPos;
	private CornealContactlLensPo cornealContactlLensPo;
	private OptometryBasicPo optometryBasicPo;
	private HealthCheckPo healthCheckPo;
	private RefractivePo refractivePo;	
	private ContactGlassPo contactGlassPo;
	private List<ContactGlassPo> contactGlassPos;
	private InspectionPo inspectionPo;
	private DoubleEyeFunPo doubleEyeFunPo;
	private List<InspectionPo> inspectionPos;	
	private HisInfoPo hisInfoPo;	
	private GlassesHistoryHydsyMgr glassesHistoryHydsyMgr;	
	private PersonPermissionMgr personPermissionMgr;
	private OptometryPo optometryPo;	
	private OptometryBasicHydsyMgr optometryBasicHydsyMgr; 
	private EyesCheckHydsyMgr eyesCheckNMgr;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	private CustomerInfoPo customerInfoPo;
	private CustomerInfoMgr customerInfoMgr;

	/**
	 * 查询戴镜史信息
	 * @return
	 */
	public String selectGlassesHistoryN(){
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
		
		String sophifcustomerid = customerInfoPo.getSmecicustomerid();
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		
		hisInfoPo=new HisInfoPo();
		hisInfoPo.setSophifcustomerid(sophifcustomerid);
		
		hisInfoPo=glassesHistoryHydsyMgr.selectGlassesHistory(hisInfoPo);
		
		optometryPo = optometryBasicHydsyMgr.selectOptometryPo(optometryPo.getSopoyoptometryid());

		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String chuyanfuyan= Utility.getName(request.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("customerID", sophifcustomerid);

		String viewDetail = Utility.getName(request.getParameter("viewDetail"));
		request.setAttribute("viewDetail", viewDetail);
		request.setAttribute("optometryBasicID", optometryBasicID);
		return SUCCESS;
	}
	
	/**
	 * 更新戴镜史信息
	 * @return
	 */
	public String updateGlassesHistoryN(){
		
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
		
		optometryPo = optometryBasicHydsyMgr.selectOptometryPo(optometryPo.getSopoyoptometryid());
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String optPersonName=personInfoPo.getPersonName();
		
		String sophifcustomerid = customerInfoPo.getSmecicustomerid();
		
		String sophifglassestype = Utility.getName(request.getParameter("sophifglassestype"));
		String sophifglassesm = Utility.getName(request.getParameter("sophifglassesm"));
		String sophifglasseskind = Utility.getName(request.getParameter("sophifglasseskind"));
		String sophifglassesc = Utility.getName(request.getParameter("sophifglassesc"));
		String sophifglassesage = Utility.getName(request.getParameter("sophifglassesage"));
		String sophifcontactlensm = Utility.getName(request.getParameter("sophifcontactlensm"));
		String sophifcontactlensbrand = Utility.getName(request.getParameter("sophifcontactlensbrand"));
		String sophifcontactlensc = Utility.getName(request.getParameter("sophifcontactlensc"));
		String sophifcontactlensage = Utility.getName(request.getParameter("sophifcontactlensage"));
		String sophifeyeillhis1 = Utility.getName(request.getParameter("sophifeyeillhis1"));
		String sophifeyeillhis2 = Utility.getName(request.getParameter("sophifeyeillhis2"));
		String sophifeyeillhis3 = Utility.getName(request.getParameter("sophifeyeillhis3"));
		String sophifinherithis = Utility.getName(request.getParameter("sophifinherithis"));
		String sophifsensitivehis = Utility.getName(request.getParameter("sophifsensitivehis"));
		
		String sophiballod = Utility.getName(request.getParameter("sophiballod"));
		String sophiballos = Utility.getName(request.getParameter("sophiballos"));
		String sophipostod = Utility.getName(request.getParameter("sophipostod"));
		String sophipostos = Utility.getName(request.getParameter("sophipostos"));
		String sophiaxesod = Utility.getName(request.getParameter("sophiaxesod"));
		String sophiaxesos = Utility.getName(request.getParameter("sophiaxesos"));
		String sophiaddod = Utility.getName(request.getParameter("sophiaddod"));
		String sophiaddos = Utility.getName(request.getParameter("sophiaddos"));
		String sophiarriseod = Utility.getName(request.getParameter("sophiarriseod"));
		String sophiarriseos = Utility.getName(request.getParameter("sophiarriseos"));
		String sophibasisod = Utility.getName(request.getParameter("sophibasisod"));
		String sophibasisos = Utility.getName(request.getParameter("sophibasisos"));
		String sophiinterhighod = Utility.getName(request.getParameter("sophiinterhighod"));
		String sophiinterhighos = Utility.getName(request.getParameter("sophiinterhighos"));
		
		String sophiydiameterod = Utility.getName(request.getParameter("sophiydiameterod"));
		String sophiydiameteros = Utility.getName(request.getParameter("sophiydiameteros"));
		String sophiycamberod = Utility.getName(request.getParameter("sophiycamberod"));
		String sophiycamberos = Utility.getName(request.getParameter("sophiycamberos"));
		
		String sophiballoda = Utility.getName(request.getParameter("sophiballoda"));
		String sophiballosa = Utility.getName(request.getParameter("sophiballosa"));
		String sophipostoda = Utility.getName(request.getParameter("sophipostoda"));
		String sophipostosa = Utility.getName(request.getParameter("sophipostosa"));
		String sophiaxesoda = Utility.getName(request.getParameter("sophiaxesoda"));
		String sophiaxesosa = Utility.getName(request.getParameter("sophiaxesosa"));
		String sophiaddoda = Utility.getName(request.getParameter("sophiaddoda"));
		String sophiaddosa = Utility.getName(request.getParameter("sophiaddosa"));
		String sophiarriseoda = Utility.getName(request.getParameter("sophiarriseoda"));
		String sophiarriseosa = Utility.getName(request.getParameter("sophiarriseosa"));
		String sophibasisoda = Utility.getName(request.getParameter("sophibasisoda"));
		String sophibasisosa = Utility.getName(request.getParameter("sophibasisosa"));
		String sophiinterhighoda = Utility.getName(request.getParameter("sophiinterhighoda"));
		String sophiinterhighosa = Utility.getName(request.getParameter("sophiinterhighosa"));
		
		String sophiydiameteroda = Utility.getName(request.getParameter("sophiydiameteroda"));
		String sophiydiameterosa = Utility.getName(request.getParameter("sophiydiameterosa"));
		String sophiycamberoda = Utility.getName(request.getParameter("sophiycamberoda"));
		String sophiycamberosa = Utility.getName(request.getParameter("sophiycamberosa"));
		
		String sophivaoda = Utility.getName(request.getParameter("sophivaoda"));
		String sophivaosa = Utility.getName(request.getParameter("sophivaosa"));
		String sophivaod = Utility.getName(request.getParameter("sophivaod"));
		String sophivaos = Utility.getName(request.getParameter("sophivaos"));
		
		request.setAttribute("customerID", sophifcustomerid);
		
		hisInfoPo=new HisInfoPo();
		hisInfoPo.setSophifcustomerid(sophifcustomerid);
		hisInfoPo.setSophifglassestype(sophifglassestype);
		hisInfoPo.setSophifglassesm(sophifglassesm);
		hisInfoPo.setSophifglasseskind(sophifglasseskind);
		hisInfoPo.setSophifglassesc(sophifglassesc);
		hisInfoPo.setSophifglassesage(sophifglassesage);
		hisInfoPo.setSophifcontactlensm(sophifcontactlensm);
		hisInfoPo.setSophifcontactlensbrand(sophifcontactlensbrand);
		hisInfoPo.setSophifcontactlensc(sophifcontactlensc);
		hisInfoPo.setSophifcontactlensage(sophifcontactlensage);
		hisInfoPo.setSophifeyeillhis1(sophifeyeillhis1);
		hisInfoPo.setSophifeyeillhis2(sophifeyeillhis2);
		hisInfoPo.setSophifeyeillhis3(sophifeyeillhis3);
		hisInfoPo.setSophifinherithis(sophifinherithis);
		hisInfoPo.setSophifsensitivehis(sophifsensitivehis);
		hisInfoPo.setSophifusername(optPersonName);
		
		hisInfoPo.setSophiballod(sophiballod);
		hisInfoPo.setSophiballos(sophiballos);
		hisInfoPo.setSophipostod(sophipostod);
		hisInfoPo.setSophipostos(sophipostos);
		hisInfoPo.setSophiaxesod(sophiaxesod);
		hisInfoPo.setSophiaxesos(sophiaxesos);
		hisInfoPo.setSophiaddod(sophiaddod);
		hisInfoPo.setSophiaddos(sophiaddos);
		hisInfoPo.setSophiarriseod(sophiarriseod);
		hisInfoPo.setSophiarriseos(sophiarriseos);
		hisInfoPo.setSophibasisod(sophibasisod);
		hisInfoPo.setSophibasisos(sophibasisos);
		hisInfoPo.setSophiinterhighod(sophiinterhighod);
		hisInfoPo.setSophiinterhighos(sophiinterhighos);
		
		hisInfoPo.setSophiydiameterod(sophiydiameterod);
		hisInfoPo.setSophiydiameteros(sophiydiameteros);
		hisInfoPo.setSophiycamberod(sophiycamberod);
		hisInfoPo.setSophiycamberos(sophiycamberos);
		
		hisInfoPo.setSophiballoda(sophiballoda);
		hisInfoPo.setSophiballosa(sophiballosa);
		hisInfoPo.setSophipostoda(sophipostoda);
		hisInfoPo.setSophipostosa(sophipostosa);
		hisInfoPo.setSophiaxesoda(sophiaxesoda);
		hisInfoPo.setSophiaxesosa(sophiaxesosa);
		hisInfoPo.setSophiaddoda(sophiaddoda);
		hisInfoPo.setSophiaddosa(sophiaddosa);
		hisInfoPo.setSophiarriseoda(sophiarriseoda);
		hisInfoPo.setSophiarriseosa(sophiarriseosa);
		hisInfoPo.setSophibasisoda(sophibasisoda);
		hisInfoPo.setSophibasisosa(sophibasisosa);
		hisInfoPo.setSophiinterhighoda(sophiinterhighoda);
		hisInfoPo.setSophiinterhighosa(sophiinterhighosa);
		
		hisInfoPo.setSophiydiameteroda(sophiydiameteroda);
		hisInfoPo.setSophiydiameterosa(sophiydiameterosa);
		hisInfoPo.setSophiycamberoda(sophiycamberoda);
		hisInfoPo.setSophiycamberosa(sophiycamberosa);
		
		hisInfoPo.setSophivaod(sophivaod);
		hisInfoPo.setSophivaos(sophivaos);
		hisInfoPo.setSophivaoda(sophivaoda);
		hisInfoPo.setSophivaosa(sophivaosa);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 新增
		logPo.setsLogContent("戴镜史管理会员卡号："+customerInfoPo.getSmecimemberid()+"删除后新增");
		
		glassesHistoryHydsyMgr.insertGlassesHistory(hisInfoPo,logPo);
		
		String chuyanfuyan= Utility.getName(request.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("optometryBasicID", Utility.getName(request.getParameter("optometryBasicID")));
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.save.sucess"));
		
		return SUCCESS;
	}
	
	/**
	 * 查询戴镜史信息
	 * @return
	 */
	public String selectGlassesHistoryEyesCheck(){
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

		String id = Utility.getName(request.getParameter("smecimemberid"));
		
		if(id.equals("")){
			hisInfoPo= new HisInfoPo();
		}else{
			CustomerInfoPo po = new CustomerInfoPo();
			po.setSmecimemberid(id);
			customerInfoPo = customerInfoMgr.getCustomerInfo(po);
			if (customerInfoPo.getSmecicustomerid() == null) {
				this.clearMessages();
				this.addActionMessage(getText("customer.select.err"));
				return SUCCESS;
			}
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
			
			hisInfoPo=new HisInfoPo();
			hisInfoPo.setSophifcustomerid(customerInfoPo.getSmecicustomerid());
			
			hisInfoPo=glassesHistoryHydsyMgr.selectGlassesHistory(hisInfoPo);
		}

		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("customerID", id);
		
		return SUCCESS;
	}
	
	/**
	 * 更新戴镜史信息
	 * @return
	 */
	public String updateGlassesHistoryEyesCheck(){
		
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
		
		
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String optPersonName=personInfoPo.getPersonName();
		
		String sophifcustomerid = Utility.getName(request.getParameter("smecimemberid"));
		
		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(sophifcustomerid);
		customerInfoPo = customerInfoMgr.getCustomerInfo(po);
		if (customerInfoPo.getSmecicustomerid() == null) {
			this.clearMessages();
			this.addActionMessage(getText("customer.select.err"));
			return SUCCESS;
		}
		if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
			String birthdayYear = customerInfoPo.getSmecibirthday()
					.substring(0, 4);
			int age = Calendar.getInstance().get(Calendar.YEAR)
					- Integer.parseInt(birthdayYear);
			customerInfoPo.setFmmage(Integer.toString(age));
		}
		
		String sophifglassestype = Utility.getName(request.getParameter("sophifglassestype"));
		String sophifglassesm = Utility.getName(request.getParameter("sophifglassesm"));
		String sophifglasseskind = Utility.getName(request.getParameter("sophifglasseskind"));
		String sophifglassesc = Utility.getName(request.getParameter("sophifglassesc"));
		String sophifglassesage = Utility.getName(request.getParameter("sophifglassesage"));
		String sophifcontactlensm = Utility.getName(request.getParameter("sophifcontactlensm"));
		String sophifcontactlensbrand = Utility.getName(request.getParameter("sophifcontactlensbrand"));
		String sophifcontactlensc = Utility.getName(request.getParameter("sophifcontactlensc"));
		String sophifcontactlensage = Utility.getName(request.getParameter("sophifcontactlensage"));
		String sophifeyeillhis1 = Utility.getName(request.getParameter("sophifeyeillhis1"));
		String sophifeyeillhis2 = Utility.getName(request.getParameter("sophifeyeillhis2"));
		String sophifeyeillhis3 = Utility.getName(request.getParameter("sophifeyeillhis3"));
		String sophifinherithis = Utility.getName(request.getParameter("sophifinherithis"));
		String sophifsensitivehis = Utility.getName(request.getParameter("sophifsensitivehis"));
		
		String sophiballod = Utility.getName(request.getParameter("sophiballod"));
		String sophiballos = Utility.getName(request.getParameter("sophiballos"));
		String sophipostod = Utility.getName(request.getParameter("sophipostod"));
		String sophipostos = Utility.getName(request.getParameter("sophipostos"));
		String sophiaxesod = Utility.getName(request.getParameter("sophiaxesod"));
		String sophiaxesos = Utility.getName(request.getParameter("sophiaxesos"));
		String sophiaddod = Utility.getName(request.getParameter("sophiaddod"));
		String sophiaddos = Utility.getName(request.getParameter("sophiaddos"));
		String sophiarriseod = Utility.getName(request.getParameter("sophiarriseod"));
		String sophiarriseos = Utility.getName(request.getParameter("sophiarriseos"));
		String sophibasisod = Utility.getName(request.getParameter("sophibasisod"));
		String sophibasisos = Utility.getName(request.getParameter("sophibasisos"));
		String sophiinterhighod = Utility.getName(request.getParameter("sophiinterhighod"));
		String sophiinterhighos = Utility.getName(request.getParameter("sophiinterhighos"));
		
		String sophiydiameterod = Utility.getName(request.getParameter("sophiydiameterod"));
		String sophiydiameteros = Utility.getName(request.getParameter("sophiydiameteros"));
		String sophiycamberod = Utility.getName(request.getParameter("sophiycamberod"));
		String sophiycamberos = Utility.getName(request.getParameter("sophiycamberos"));
		
		String sophiballoda = Utility.getName(request.getParameter("sophiballoda"));
		String sophiballosa = Utility.getName(request.getParameter("sophiballosa"));
		String sophipostoda = Utility.getName(request.getParameter("sophipostoda"));
		String sophipostosa = Utility.getName(request.getParameter("sophipostosa"));
		String sophiaxesoda = Utility.getName(request.getParameter("sophiaxesoda"));
		String sophiaxesosa = Utility.getName(request.getParameter("sophiaxesosa"));
		String sophiaddoda = Utility.getName(request.getParameter("sophiaddoda"));
		String sophiaddosa = Utility.getName(request.getParameter("sophiaddosa"));
		String sophiarriseoda = Utility.getName(request.getParameter("sophiarriseoda"));
		String sophiarriseosa = Utility.getName(request.getParameter("sophiarriseosa"));
		String sophibasisoda = Utility.getName(request.getParameter("sophibasisoda"));
		String sophibasisosa = Utility.getName(request.getParameter("sophibasisosa"));
		String sophiinterhighoda = Utility.getName(request.getParameter("sophiinterhighoda"));
		String sophiinterhighosa = Utility.getName(request.getParameter("sophiinterhighosa"));
		
		String sophiydiameteroda = Utility.getName(request.getParameter("sophiydiameteroda"));
		String sophiydiameterosa = Utility.getName(request.getParameter("sophiydiameterosa"));
		String sophiycamberoda = Utility.getName(request.getParameter("sophiycamberoda"));
		String sophiycamberosa = Utility.getName(request.getParameter("sophiycamberosa"));
		
		String sophivaoda = Utility.getName(request.getParameter("sophivaoda"));
		String sophivaosa = Utility.getName(request.getParameter("sophivaosa"));
		String sophivaod = Utility.getName(request.getParameter("sophivaod"));
		String sophivaos = Utility.getName(request.getParameter("sophivaos"));
		
		hisInfoPo=new HisInfoPo();
		hisInfoPo.setSophifcustomerid(customerInfoPo.getSmecicustomerid());
		hisInfoPo.setSophifglassestype(sophifglassestype);
		hisInfoPo.setSophifglassesm(sophifglassesm);
		hisInfoPo.setSophifglasseskind(sophifglasseskind);
		hisInfoPo.setSophifglassesc(sophifglassesc);
		hisInfoPo.setSophifglassesage(sophifglassesage);
		hisInfoPo.setSophifcontactlensm(sophifcontactlensm);
		hisInfoPo.setSophifcontactlensbrand(sophifcontactlensbrand);
		hisInfoPo.setSophifcontactlensc(sophifcontactlensc);
		hisInfoPo.setSophifcontactlensage(sophifcontactlensage);
		hisInfoPo.setSophifeyeillhis1(sophifeyeillhis1);
		hisInfoPo.setSophifeyeillhis2(sophifeyeillhis2);
		hisInfoPo.setSophifeyeillhis3(sophifeyeillhis3);
		hisInfoPo.setSophifinherithis(sophifinherithis);
		hisInfoPo.setSophifsensitivehis(sophifsensitivehis);
		hisInfoPo.setSophifusername(optPersonName);
		
		hisInfoPo.setSophiballod(sophiballod);
		hisInfoPo.setSophiballos(sophiballos);
		hisInfoPo.setSophipostod(sophipostod);
		hisInfoPo.setSophipostos(sophipostos);
		hisInfoPo.setSophiaxesod(sophiaxesod);
		hisInfoPo.setSophiaxesos(sophiaxesos);
		hisInfoPo.setSophiaddod(sophiaddod);
		hisInfoPo.setSophiaddos(sophiaddos);
		hisInfoPo.setSophiarriseod(sophiarriseod);
		hisInfoPo.setSophiarriseos(sophiarriseos);
		hisInfoPo.setSophibasisod(sophibasisod);
		hisInfoPo.setSophibasisos(sophibasisos);
		hisInfoPo.setSophiinterhighod(sophiinterhighod);
		hisInfoPo.setSophiinterhighos(sophiinterhighos);
		
		hisInfoPo.setSophiydiameterod(sophiydiameterod);
		hisInfoPo.setSophiydiameteros(sophiydiameteros);
		hisInfoPo.setSophiycamberod(sophiycamberod);
		hisInfoPo.setSophiycamberos(sophiycamberos);
		
		hisInfoPo.setSophiballoda(sophiballoda);
		hisInfoPo.setSophiballosa(sophiballosa);
		hisInfoPo.setSophipostoda(sophipostoda);
		hisInfoPo.setSophipostosa(sophipostosa);
		hisInfoPo.setSophiaxesoda(sophiaxesoda);
		hisInfoPo.setSophiaxesosa(sophiaxesosa);
		hisInfoPo.setSophiaddoda(sophiaddoda);
		hisInfoPo.setSophiaddosa(sophiaddosa);
		hisInfoPo.setSophiarriseoda(sophiarriseoda);
		hisInfoPo.setSophiarriseosa(sophiarriseosa);
		hisInfoPo.setSophibasisoda(sophibasisoda);
		hisInfoPo.setSophibasisosa(sophibasisosa);
		hisInfoPo.setSophiinterhighoda(sophiinterhighoda);
		hisInfoPo.setSophiinterhighosa(sophiinterhighosa);
		
		hisInfoPo.setSophiydiameteroda(sophiydiameteroda);
		hisInfoPo.setSophiydiameterosa(sophiydiameterosa);
		hisInfoPo.setSophiycamberoda(sophiycamberoda);
		hisInfoPo.setSophiycamberosa(sophiycamberosa);
		
		hisInfoPo.setSophivaod(sophivaod);
		hisInfoPo.setSophivaos(sophivaos);
		hisInfoPo.setSophivaoda(sophivaoda);
		hisInfoPo.setSophivaosa(sophivaosa);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 新增
		logPo.setsLogContent("眼部健康检查--戴镜史：管理会员卡号："+customerInfoPo.getSmecimemberid()+"删除后新增");
		
		glassesHistoryHydsyMgr.insertGlassesHistory(hisInfoPo,logPo);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.save.sucess"));
		return SUCCESS;
	}

	
	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}
	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}
	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}
	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}
	
	public List<CornealContactlLensPo> getCornealContactlLensPos() {
		return cornealContactlLensPos;
	}
	public void setCornealContactlLensPos(
			List<CornealContactlLensPo> cornealContactlLensPos) {
		this.cornealContactlLensPos = cornealContactlLensPos;
	}
	public CornealContactlLensPo getCornealContactlLensPo() {
		return cornealContactlLensPo;
	}
	public void setCornealContactlLensPo(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensPo = cornealContactlLensPo;
	}
	public ContactGlassPo getContactGlassPo() {
		return contactGlassPo;
	}
	public void setContactGlassPo(ContactGlassPo contactGlassPo) {
		this.contactGlassPo = contactGlassPo;
	}
	public List<ContactGlassPo> getContactGlassPos() {
		return contactGlassPos;
	}
	public void setContactGlassPos(List<ContactGlassPo> contactGlassPos) {
		this.contactGlassPos = contactGlassPos;
	}
	public OptometryBasicPo getOptometryBasicPo() {
		return optometryBasicPo;
	}
	public void setOptometryBasicPo(OptometryBasicPo optometryBasicPo) {
		this.optometryBasicPo = optometryBasicPo;
	}
	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}
	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}
	public RefractivePo getRefractivePo() {
		return refractivePo;
	}
	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}
	public InspectionPo getInspectionPo() {
		return inspectionPo;
	}
	public void setInspectionPo(InspectionPo inspectionPo) {
		this.inspectionPo = inspectionPo;
	}
	public DoubleEyeFunPo getDoubleEyeFunPo() {
		return doubleEyeFunPo;
	}
	public void setDoubleEyeFunPo(DoubleEyeFunPo doubleEyeFunPo) {
		this.doubleEyeFunPo = doubleEyeFunPo;
	}
	public List<InspectionPo> getInspectionPos() {
		return inspectionPos;
	}
	public void setInspectionPos(List<InspectionPo> inspectionPos) {
		this.inspectionPos = inspectionPos;
	}
	public OptometryBasicHydsyMgr getOptometryBasicHydsyMgr() {
		return optometryBasicHydsyMgr;
	}
	public void setOptometryBasicHydsyMgr(OptometryBasicHydsyMgr optometryBasicHydsyMgr) {
		this.optometryBasicHydsyMgr = optometryBasicHydsyMgr;
	}
	public OptometryPo getOptometryPo() {
		return optometryPo;
	}
	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public HisInfoPo getHisInfoPo() {
		return hisInfoPo;
	}
	public void setHisInfoPo(HisInfoPo hisInfoPo) {
		this.hisInfoPo = hisInfoPo;
	}
	public GlassesHistoryHydsyMgr getGlassesHistoryHydsyMgr() {
		return glassesHistoryHydsyMgr;
	}
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}
	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	public void setGlassesHistoryHydsyMgr(GlassesHistoryHydsyMgr glassesHistoryHydsyMgr) {
		this.glassesHistoryHydsyMgr = glassesHistoryHydsyMgr;
	}
	
	public EyesCheckHydsyMgr getEyesCheckHydsyMgr() {
		return eyesCheckNMgr;
	}
	public void setEyesCheckHydsyMgr(EyesCheckHydsyMgr eyesCheckNMgr) {
		this.eyesCheckNMgr = eyesCheckNMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}
}
