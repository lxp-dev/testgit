package com.pengsheng.eims.his.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;

import com.pengsheng.eims.casehistory.mgr.CustmerInfoHISMgr;
import com.pengsheng.eims.casehistory.persistence.CustmerInfoHISPo;
import com.pengsheng.eims.his.dao.HisParamDao;
import com.pengsheng.eims.his.mgr.HisLogPoMgr;
import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.HttpPostJSON;
import com.pengsheng.eims.util.tools.Utility;

public class HisAction extends BaseAction {

	private HisMgr hisMgr;
	private HisLogPoMgr hisLogPoMgr;
	private HisParamDao hisParamDao;
	private LogisticsLogDao logisticsLogDao;
	private CustomerInfoMgr customerInfoMgr;
	private SystemParameterPo systemParameterPo;
	private PersonPermissionMgr personPermissionMgr;
	private CustmerInfoHISMgr custmerInfoHISMgr;
	private String  targetpage;

	
	public HisParamDao getHisParamDao() {
		return hisParamDao;
	}
	public void setHisParamDao(HisParamDao hisParamDao) {
		this.hisParamDao = hisParamDao;
	}
	public CustmerInfoHISMgr getCustmerInfoHISMgr() {
		return custmerInfoHISMgr;
	}
	public void setCustmerInfoHISMgr(CustmerInfoHISMgr custmerInfoHISMgr) {
		this.custmerInfoHISMgr = custmerInfoHISMgr;
	}
	public String getTargetpage() {
		return targetpage;
	}
	public void setTargetpage(String targetpage) {
		this.targetpage = targetpage;
	}
	public HisLogPoMgr getHisLogPoMgr() {
		return hisLogPoMgr;
	}
	public void setHisLogPoMgr(HisLogPoMgr hisLogPoMgr) {
		this.hisLogPoMgr = hisLogPoMgr;
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}
	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	
	public HisMgr getHisMgr() {
		return hisMgr;
	}

	public void setHisMgr(HisMgr hisMgr) {
		this.hisMgr = hisMgr;
	}

/** ------爱尔HIS接口-------------------------------------------------------------------------------------------------------------------------------------*/
	
	/**
	 * 接口1)
	 * 
	 * 1. 接口名称：HIS系统患者信息调阅接口
	 * 2. 用          途：通过调用接口检索HIS系统中的患者信息
	 * 3. 返回值：如果有患者信息，返回患者信息的JSON，如果没有患者信息，返回空串
	 */
	public String getCustomerInfoByHis() {
		
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
				.getPersonPermission(personPermissionPo);                // 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		 
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String pflag = Utility.getName(request.getParameter("pflag"));      // 查询方式hisCusWin_js.jsp使用
		request.setAttribute("pflag",pflag);
		String cardno = Utility.getName(request.getParameter("cardno"));  // 诊疗卡的物理ID
		
		//封装JSON
        JSONObject obj = new JSONObject();
        obj.element("cardno", cardno);
        obj.element("interfaceID","1");
                
        //拼接调用接口的url
		String infoURL = personInfoPo1.getBdplinkhisurl() + obj.toString();
	 
        //调用接口
		String custemerInfo = Utility.getName(hisMgr.getCustomerInfoByHis(infoURL));
		
		//接口调用日志
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHislogdepatmentid(personInfoPo1.getDepartmentID());// 调用部门ID
		hisLogPo.setHislogpersonid(createPerson);                      // 调用人ID
		hisLogPo.setHisloginterfaceid("1");                            // 接口ID
		hisLogPo.setHisloginparam(obj.toString());                     // 入参
		hisLogPo.setHislogreturnparam(custemerInfo);                   // 返回值
		hisLogPo.setHislogmoduleid(moduleID);                          // 所属模块ID	
		hisLogPo.setHislogip(request.getRemoteAddr());                 // IP地址
        
				
		if (custemerInfo.equals("")){
			cardno="";
			// 新增HIS日志
			hisLogPo.setHisloginparam("视光系统与HIS系统中连接异常，请检查网络 !");                     // 入参
			hisLogPoMgr.insertHisLog(hisLogPo);      
			this.addActionError("<script>alert('视光系统与HIS系统中连接异常，请检查网络 !')</script>");			
			return "target";
		}
		
		// 视光日志
		LogisticsLogPo logistLogPo = new LogisticsLogPo();
		logistLogPo.setsLogName(createPerson);                           //操作员
		logistLogPo.setsLogIP(request.getRemoteAddr());                  //IP地址
		logistLogPo.setsLogName(createPerson);          //操作员
		logistLogPo.setsLogIP(request.getRemoteAddr()); //IP地址
		logistLogPo.setsLogDepartmentID(personInfoPo1.getDepartmentID());//操作员所属部门
		logistLogPo.setsLogResult(moduleID); // 模块ID
		
		//解析JSON
		HisParamPo hisParamPo = new HisParamPo(); 
		try {
			
			hisParamPo = this.toObject(custemerInfo,hisParamPo);

		} catch (Exception e){				
			// 新增HIS日志
			hisLogPo.setHislogreturnparam("HIS系统中患者信息解析失败 !");                   // 返回值
			hisLogPoMgr.insertHisLog(hisLogPo);      
			this.addActionError("<script>alert('HIS系统中患者信息解析失败 !')</script>");			
			return "target";
		}
		
		String memberid = Utility.getName(hisParamPo.getMemberid());
		String resultCode = Utility.getName(hisParamPo.getResultCode());
		String todayjiuzhenid = "";
		
		//判断患者信息是否存在于HIS
		if (!resultCode.equals("1")){   // 不存在
			cardno="";
			// 新增HIS日志
			hisLogPo.setHislogreturnparam("HIS系统中没有查询到患者信息 !");                   // 返回值
			hisLogPoMgr.insertHisLog(hisLogPo);    
			this.addActionError("<script>alert('HIS系统中没有查询到患者信息 !')</script>");
			return "target";
		}else{                      // 存在
			
			//将各参数封装成PO
			CustomerInfoPo cpo = new CustomerInfoPo();
			cpo.setSmecicustomerid(memberid);                                // 顾客号
			cpo.setSmeciname(Utility.getName(hisParamPo.getName()));         // 姓名
			
			if (Utility.getName(hisParamPo.getSex()).equals("男")){          // 性别：男
				cpo.setSmecisex("0");
			}else if (Utility.getName(hisParamPo.getSex()).equals("女")){    // 性别：女
				cpo.setSmecisex("1");
			}else {    // 性别：未知
				cpo.setSmecisex("0");   // 默认为男
			}
			 
			cpo.setSmecibirthday(Utility.getName(hisParamPo.getBirthday())); // 生日
			cpo.setSmeciaddress(Utility.getName(hisParamPo.getAddress()));   // 地址
			cpo.setSmecizone(Utility.getName(systemParameterPo.getFspcustomeraddress())); // 地区名称
			cpo.setSmecimemberid(cardno);                                 // 会员卡号
			cpo.setSmeciintegral("0");                                    // 积分
			cpo.setSmecishopcode(personInfoPo1.getDepartmentID());        // 店号,注册日期   getdate(),卡片类型  取默认卡类型
			cpo.setSmeciregister(createPerson);                           // 注册人员
			cpo.setSmeciconsumptionnumber("0");                           // 消费笔数
			cpo.setSmeciconsumptionprice("0");                            // 消费总金额
			cpo.setSmeciflag("1");                                        // 停用启用标记
			cpo.setSmeidentitycard(Utility.getName(hisParamPo.getIdentitycard())); // 身份证		
			
			todayjiuzhenid = Utility.getName(hisParamPo.getTodayoutpatientid());
			cpo.setSmecitodayjiuzhenid(todayjiuzhenid);                   // 当日就诊号
			
			//封装HIS患者信息与当日就诊号的PO
			CustmerInfoHISPo custmerInfoHISPo = new CustmerInfoHISPo();
			custmerInfoHISPo.setShccocustmerid(memberid);                 //顾客号
			custmerInfoHISPo.setShccotodayid(todayjiuzhenid);             //当日就诊号 
			custmerInfoHISPo.setShccoisopt("0");                          //验光标识 0未验光；1已经验光
			custmerInfoHISPo.setShccoisrefund("0");                       //退费标识 0未退费；1已退费
			
			//新增HIS患者信息与当日就诊号的对应关系
			int HIScount = custmerInfoHISMgr.queryCustHIS(custmerInfoHISPo);
			
			if(HIScount == 0){
				
				//判断当日就诊号是否重复
				/*int todayIDcount = custmerInfoHISMgr.queryTodayIDHIS(custmerInfoHISPo);

				if(todayIDcount > 0){
	            	cardno="";
	    			this.addActionError("<script>alert('该患者已验光 !')</script>");
	    			return "target";
	            }  */
				custmerInfoHISMgr.insertCustHIS(custmerInfoHISPo);
			}
			
			String tel = Utility.getName(hisParamPo.getTel());            // 联系电话,要考虑电话重复
			
			if (tel.equals("")){
				tel = "11111111111";                                        // 默认电话
			}
			// 判断电话是否重复
			cpo.setSmeciphone(tel);
			String sourcecard = customerInfoMgr.getCustPhoneInfo(cpo);
			cpo.setSmecisourcecard(sourcecard);                           // 相同电话的关联的顾客ID
		
						
			//判断患者视光是否存在
			int count = customerInfoMgr.getCuInfo(cpo);
		
			if (count == 0){ // 不存在
				
				logistLogPo.setsLogContent("HIS会员新增,顾客号: "+memberid);          //内容
				//更新已有会员的会员卡号
				customerInfoMgr.updteCustCard(cpo);
				//新增至视光系统
				customerInfoMgr.insertCust(cpo,logistLogPo);

			}else
			{     // 存在
                               
				logistLogPo.setsLogContent("HIS会员修改,顾客号: "+memberid);          //内容
				//更新已有会员的会员卡号
				customerInfoMgr.updteCustCard(cpo);
				//更新当前患者的会员卡号
				customerInfoMgr.updteCurCustCard(cpo,logistLogPo);
			}
			
		}
		
		hisLogPoMgr.insertHisLog(hisLogPo);   
		String url = "''"+personInfoPo1.getBdpreadcardform()+"?cardno={0}&moduleID={1}&memberid={2}''";
		List<String> params = new ArrayList<String>();
		params.add(cardno);
		params.add(moduleID);
		params.add(memberid);

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		request.setAttribute("cardno",cardno);
		request.setAttribute("todayjiuzhenid",todayjiuzhenid);
		request.setAttribute("memberid",memberid);
		
		
		return "target";
	}
	
	/**
	 * 接口2)
	 * 
	 * 1. 接口名称：视光系统挂号退费确认接口
	 * 2. 用          途：通过调用接口检索患者是否在视光系统验光
	 */
	public void getCustomerOptometryStateByHis() {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");      //解决中文乱码问题

		String paramStr = Utility.getName(request.getParameter("paramStr"));    // "缴费单号"的JSON
		
		//接口调用日志
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHisloginterfaceid("2"); // 接口ID
		hisLogPo.setHisloginparam(paramStr); // 入参
		
		//封装JSON
        JSONObject obj = new JSONObject();
        obj.element("interfaceID","2");
        
		//解析JSON
		HisParamPo hisParamPo = new HisParamPo(); 
		try {
			hisParamPo = this.toObject(paramStr,hisParamPo);
		} catch (Exception e) {	
			
			obj.element("resultCode", "0");
		    obj.element("resultMsg", "HIS传入参数解析失败!");
		    
		    if("".equals(paramStr)){
		    	hisLogPo.setHisloginparam("传入视光参数为空!"); // 入参
		    }
			hisLogPo.setHislogreturnparam("HIS传入参数解析失败!"); // 返回值

			// 新增HIS日志
			hisLogPoMgr.insertHisLog(hisLogPo);
			
			//返回调用结果
			this.outMessage(obj.toString());
			return;
		}
		
		// 检索患者的当日就诊号是否已经验光
		int count = hisMgr.getCustomerOptometryStateByHis(Utility.getName(hisParamPo.getMemberid()),Utility.getName(hisParamPo.getTodayoutpatientid()));
		String opflag = "0";   // 未验光
		String msg = "当前患者未进行验光，可以退挂号费";     // 能退费
	 
		if (count > 0){
			opflag = "1";    // 已验光
			msg = "当前患者已进行验光，不能退挂号费";        // 不能退费
		}
		
		//封装JSON
        obj.element("resultCode", opflag);
        obj.element("resultMsg", msg);

        //调用接口
		String str = obj.toString();

		hisLogPo.setHislogpersonname("HIS系统【"+Utility.getName(hisParamPo.getPosname())+"】"); // 调用人姓名
		hisLogPo.setHisloginparam(paramStr); // 入参
		hisLogPo.setHislogreturnparam(str); // 返回值
		hisLogPo.setHislogip(Utility.getName(hisParamPo.getMac())); // IP地址

		// 新增HIS日志
		hisLogPoMgr.insertHisLog(hisLogPo); 
		
		//返回调用结果
		this.outMessage(str);		
	}
	
	/**
	 * 接口4)
	 * 
	 * 1. 接口名称：视光系统待交费用确认收费接口
	 * 2. 用      途：更新视光系统中待交费项目是否收费成功
	 */
	public void updateNotChargeStateByHis() {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");      //解决中文乱码问题
		
		String paramStr = Utility.getName(request.getParameter("paramStr"));  // "缴费单号、缴费时间、收费人工号、收费人姓名、收费成功是否标识"的JSON
		
		//接口调用日志
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHisloginterfaceid("4"); // 接口ID
		
		//返回调用结果
        JSONObject obj = new JSONObject();
        obj.element("interfaceID","4");
        
        if("".equals(paramStr)){
        	
        	obj.element("resultCode", "0");
    		obj.element("resultMsg", "传入参数为空!");
        	hisLogPo.setHisloginparam("传入参数为空!"); // 入参
        	// 新增HIS日志
    		hisLogPoMgr.insertHisLog(hisLogPo);
    		
    		this.outMessage(obj.toString());
    		return;
        }
        
        hisLogPo.setHisloginparam(paramStr); // 入参
		
		//解析JSON
		HisParamPo hisParamPo = new HisParamPo();
		
		//封装JSON
        String str = "";
        String str2 = "";
        SalesBasicPo spo = new SalesBasicPo();
		try {
			hisParamPo = this.toObject(paramStr,hisParamPo);
			
			String type = hisParamPo.getType();

			//封装PO
			if("1".equals(type)){

				spo.setSsesbsalesid(Utility.getName(hisParamPo.getBillid()));         // 缴费单号(实际用来保存主键)
				
			}else if("2".equals(type)){
				
				HisParamPo po = new HisParamPo();
	        	po.setId(Utility.getName(hisParamPo.getBillid()));
	        	po.setBillid(hisParamDao.getHisParamPo(po).getBillid());
	        	po.setId("");
	        	po.setChargetype("4");
	        	po.setChargestatus("2");
				spo.setSsesbsalesid(hisParamDao.getHisParamPo(po).getId());         // 缴费单号(实际用来保存主键)
				
			}
			spo.setSsesbposdatetime(Utility.getName(hisParamPo.getUpdatetime())); // 缴费时间
			spo.setSsesbposid(Utility.getName(hisParamPo.getPosid()));            // 收费人工号
			spo.setSsesbposName(Utility.getName(hisParamPo.getPosname()));        // 收费人姓名
			spo.setSsesbvalueflag(Utility.getName(hisParamPo.getFlag()));         // 收费标识
			 
			int count = hisLogPoMgr.queryChargeStatecount(spo);
			//判断是否更新过缴费状态
			if(count > 0){

				str = "此单据已更新过，不能重复更新!";
				str2 = "0";
			}else if(count == 0){
				//更新视光系统中待交费是否收费成功
				hisLogPoMgr.updateNotChargeStateByHis(spo);
				if("1".equals(type)){
					str = "收费更新成功";
					
				}else if("2".equals(type)){
					
					str = "退费更新成功";
				}
				str2 = "1";
				
			} 
			
		} catch (Exception e) {				
			str = "传入参数解析失败,未更新";
			str2 = "0";
		}
		
		
		obj.element("resultCode", str2);
		obj.element("resultMsg", str);

		//接口调用日志
		hisLogPo.setHislogpersonid(Utility.getName(hisParamPo.getPosid())); // 调用人ID
		hisLogPo.setHislogpersonname("HIS系统【"+Utility.getName(hisParamPo.getPosname())+"】"); // 调用人姓名
		hisLogPo.setHislogreturnparam(obj.toString()); // 返回值
		hisLogPo.setHislogip(Utility.getName(hisParamPo.getMac())); // mac
		
		// 新增HIS日志
		hisLogPoMgr.insertHisLog(hisLogPo); 
					
		this.outMessage(obj.toString());
	}
	
	/**
	 * 接口5)
	 * 
	 * 1. 接口名称：HIS系统作废待交费用接口
	 * 2. 用       途：将本次交费作废
	 */
	public String updateSalesBillStateByHis() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("5");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String billid = Utility.getName(request.getParameter("billid"));  // 缴费单号
	 
		//封装JSON
        JSONObject obj = new JSONObject();
        obj.element("billid", billid);
        obj.element("interfaceID","5");
			
        HisParamPo paramPo = new HisParamPo();
       
        //接口调用日志
		HisLogPo hisLogPo = new HisLogPo();
		
    	String resultStr = "";
        try { 
        	
        	//调用接口
        	resultStr = HttpPostJSON.postJSON(personInfoPo1.getBdplinkhisurl() + URLEncoder.encode(obj.toString(),"UTF-8"));
        	hisLogPo.setHislogreturnparam(resultStr); // 返回值
        	
        	//将返回的json封装成po
			paramPo = this.toObject(resultStr,paramPo);
			
		}catch (UnsupportedEncodingException e1) {
			hisLogPo.setHislogreturnparam("编码异常-长度"+obj.toString().length()); // 返回值
		}catch (Exception e) {
			hisLogPo.setHislogreturnparam("HIS返回信息解析失败!"); // 返回值
		}
		
		hisLogPo.setHislogdepatmentid(personInfoPo1.getDepartmentID()); // 调用部门ID
		hisLogPo.setHislogpersonid(createPerson); // 调用人ID
		hisLogPo.setHisloginterfaceid("5"); // 接口ID
		hisLogPo.setHisloginparam(obj.toString()); // 入参
		hisLogPo.setHislogmoduleid(moduleID); // 所属模块ID	
		hisLogPo.setHislogip(request.getRemoteAddr()); // IP地址
		
		// 新增HIS日志
		hisLogPoMgr.insertHisLog(hisLogPo); 
		
		String str = "";
		//判断接口调用成功与否，并更新视光日志
		if(!(resultStr.contains("{")||resultStr.contains("}"))){
			str="取消缴费失败!请检查网络,确保与HIS系统连通!";
			
		}else {
			
			if (Utility.getName(paramPo.getResultCode()).equals("1")){   // 更新成功
				str = "已取消缴费!";

				// 视光日志
				LogisticsLogPo logistLogPo=new LogisticsLogPo();
				logistLogPo.setsLogName(createPerson);          //操作员
				logistLogPo.setsLogIP(request.getRemoteAddr()); //IP地址
				logistLogPo.setsLogDepartmentID(personInfoPo1.getDepartmentID());//操作员所属部门
				logistLogPo.setsLogContent("作废待缴费,订单号: "+billid);            //内容
				logistLogPo.setsLogResult(moduleID); // 模块ID
				
				//封装PO
				SalesBasicPo spo = new SalesBasicPo();
				spo.setSsesbsalesid(billid);                                      // 缴费单号
				spo.setSsesbvalueflag("5");                                       // 收费状态
				
				//更新单据状态				
				hisLogPoMgr.updateNotChargeStateBySG(spo);
				
				logisticsLogDao.insertLog(logistLogPo);
			}else{
				str = "取消缴费失败!";
			}

		}
		
		this.clearMessages();
		this.addActionMessage(getText(str));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
				
		return SUCCESS;
	}
	
	/**
	 * 接口6)
	 * 
	 * 1. 接口名称：视光系统提供挂号退费成功接口
	 * 2. 用       途：HIS调用接口反刷患者在视光系统验光退费状态
	 */
	public void updateCustOptStaOKByHis() {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");      //解决中文乱码问题
		
		String paramStr = Utility.getName(request.getParameter("paramStr"));    // "患者验光信息"的JSON
		
		String resultCode = "";
		String resultMsg = "";
		
		//返回调用结果
        JSONObject obj = new JSONObject();
        obj.element("interfaceID","6");
        
    	//接口调用日志
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHisloginterfaceid("6"); // 接口ID
		
		if("".equals(paramStr)){

			resultCode = "0";
			resultMsg = "传入参数为空!";
			
			obj.element("resultCode", resultCode);
			obj.element("resultMsg", resultMsg);
			hisLogPo.setHisloginparam(resultMsg); // 入参
			hisLogPo.setHislogreturnparam(obj.toString()); // 返回值
			
			// 新增HIS日志
			hisLogPoMgr.insertHisLog(hisLogPo); 
			this.outMessage(obj.toString());
		}
		
		//解析JSON
		HisParamPo hisParamPo = new HisParamPo(); 
		
		try {
			hisParamPo = this.toObject(paramStr,hisParamPo);
		} catch (Exception e) {				
			resultCode = "0";
			resultMsg = "HIS信息解析失败!";
			
			obj.element("resultCode", resultCode);
			obj.element("resultMsg", resultMsg);
			hisLogPo.setHisloginparam(paramStr); // 入参
			hisLogPo.setHislogreturnparam(resultMsg); // 返回值
			
			// 新增HIS日志
			hisLogPoMgr.insertHisLog(hisLogPo); 
			
			this.outMessage(obj.toString());
		}
		 
		// 检索患者的当日就诊号是否已经验光
		int count = hisMgr.getCustomerIsrefundStateByHis(Utility.getName(hisParamPo.getMemberid()),Utility.getName(hisParamPo.getTodayoutpatientid()));
		 
		if (count > 0){
			hisMgr.updateCustOptStaOKByHis(hisParamPo);
			
			resultCode = "1";
			resultMsg = "退费更新成功";
		}else{
			resultCode = "0";
			resultMsg = "患者没有验光记录或已退费";
		}	
		
		
		obj.element("resultCode", resultCode);
		obj.element("resultMsg", resultMsg);
		
	
		hisLogPo.setHislogpersonname("HIS系统【"+Utility.getName(hisParamPo.getPosname())+"】"); // 调用人姓名
		hisLogPo.setHisloginparam(paramStr); // 入参
		hisLogPo.setHislogreturnparam(obj.toString()); // 返回值
		hisLogPo.setHislogip(Utility.getName(hisParamPo.getMac())); // MAC地址

		// 新增HIS日志
		hisLogPoMgr.insertHisLog(hisLogPo); 
		
		this.outMessage(obj.toString());
	}
	
	/**
	 * 1. 用          途：解析JSON，将其转成PO
	 * 2. 入          参：jsonString   JSON字符串
	 *              hisParamPo  需要将解析后的JSON封装的PO
	 * 3. 返回值：将JSON其转成的PO
	 */
	public static HisParamPo toObject(String jsonString, HisParamPo hisParamPo) throws Exception {
         
		ObjectMapper objectMapper = new ObjectMapper();
		
		return (HisParamPo) objectMapper.readValue(jsonString, hisParamPo.getClass());
	}
	
	/**
	 * 1. 用          途：将字符串转成JSON,并已流的形式传输
	 * 2. 入          参：objString   需要封装JSON的字符串
	 */
	 public void outMessage(String objString) {
         try {
             PrintWriter out = response.getWriter();
             out.print(objString);
             out.flush();
             out.close();
         } catch (Exception e) {
    	     e.printStackTrace();
         }
	 }
	 
/** ------邢台眼科HIS接口-------------------------------------------------------------------------------------------------------------------------------------*/
	
	/**
	 * 接口7)
	 * 
	 * 1. 接口名称：视光系统待交费用提交接口
	 * 2. 用      途：由视光系统向HIS提交待收费信息
	 */
	public void insertNotChargeStateByHis() {
		
	}
	
	/**
	 * 接口8)
	 * 
	 * 1. 接口名称：视光系统待交费用确认收费接口
	 * 2. 用      途：更新视光系统中待交费项目是否收费成功
	 */
	public void updateNotChargeStateByXtHis() {
		 
	}

	
}
