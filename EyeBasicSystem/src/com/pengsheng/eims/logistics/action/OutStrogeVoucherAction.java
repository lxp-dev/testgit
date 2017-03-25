package com.pengsheng.eims.logistics.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SalesShopPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

@SuppressWarnings("serial")
public class OutStrogeVoucherAction extends BaseAction {

	private LogisticsLogMgr logisticsLogMgr = null;             //日志接口
	private PersonPermissionMgr personPermissionMgr = null;	
	private List<InventoryPo> selectBillList = null;
	private VoucherMgr voucherMgr = null;                       //Mgr接口
	private List<VoucherTypePo> voucherTopIDList = null;        //凭证基本类型列表
	private List<VoucherTypePo> voucherSubsetIDList = null;     //凭证基本具体列表
	private List<VoucherPo> voucherList = null;                 //凭证基本信息列表
	private List<VoucherEntryPo> voucherEntryList = null;       //凭证明细信息列表
    private List<SalesShopPo> salesShopList = null;             //门店列表	
	private VoucherPo po = null;                                //凭证基本信息实体
	private VoucherTempPo voucherTempPo = null;                 //凭证基本信息实体数组
	private VoucherEntryTempPo voucherEntryTempPo = null;       //凭证明细信息实体数组
	private List<InvoicePo> invoiceList = null;                 //发票基本信息列表
    private InvoicePo invoicePo = null;                         //发票基本信息实体
	private List<InvoiceEntryPo> invoiceEntryList = null;       //发票明细信息列表    
	private String id = null;                                   //用于区分单据、发票、冲回数据的标识
	private String isUpdate = null;                             //判断是否执行了修改操作
	private DecimalFormat df = null;	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
	/**
	 * Description：初始化查询出库凭证
	 */
	public String initOutStrogeVoucherSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		request.setAttribute("createPersonID",createPerson);
		
		salesShopList = voucherMgr.getSalesShopList();
		
		VoucherPo po = voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid());		
		request.setAttribute("billStartTime",Utility.getName(po.getsLvvDateTopLimit()));
		
		String softwarePath = voucherMgr.getCurrentFinanceSoftwarePath();
		request.setAttribute("softwarePath",Utility.getName(softwarePath));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selOutStrogeVoucher";
		}
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化新增出库凭证
	 */
	public String initOutStrogeVoucherInsert() throws Exception {		

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String createPersonName = ((PersonInfoPo) session.get("person")).getPersonName();                     //获取创建人名称		
		String voucherDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //新增凭证的时间		
		String voucherID = "V"+GenerateNumber.getInstance().getGenerageNumber();                          //新增凭证的ID	
		
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		
		request.setAttribute("voucherID" , voucherID);
		request.setAttribute("voucherDate" , voucherDate);		
		request.setAttribute("createPerson" , createPersonName);
		
		//释放资源
		createPersonName = null;
		voucherDate = null;
		voucherID = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询出库单据
	 */
	public String selSalesBills() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String voucherID = Utility.getName(request.getParameter("voucherID")); 
		String voucherDate = Utility.getName(request.getParameter("voucherDate")); 
		String createPerson = Utility.getName(request.getParameter("createPerson")); 
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		
	    request.setAttribute("bVoucherType",bVoucherType);
	    request.setAttribute("sVoucherType" , sVoucherType);	    
	    request.setAttribute("voucherID",voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson",createPerson);
	    
		if (voucherEntryList == null){
			voucherEntryList = new ArrayList<VoucherEntryPo>();
		}
		
		if (voucherEntryTempPo != null){
			int count = voucherEntryTempPo.getsLveveBillID().length;
			for (int i = 0; i < count; i++){
				VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
				voucherEntryPo.setsLveveVoucherID(voucherID);
				voucherEntryPo.setsLveveID(voucherEntryTempPo.getsLveveID()[i]);
				voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
				voucherEntryPo.setsBillDate(voucherEntryTempPo.getsDate()[i]);
				voucherEntryPo.setsDepartmentID(voucherEntryTempPo.getsDepartmentID()[i]);
				voucherEntryPo.setsDepartment(voucherEntryTempPo.getsDepartment()[i]);
				voucherEntryPo.setsNotTaxRateAmount(voucherEntryTempPo.getsNotTaxRateAmount()[i]);
				voucherEntryPo.setsCostPriceAmount(voucherEntryTempPo.getsCostPriceAmount()[i]);
				
				voucherEntryList.add(voucherEntryPo);
			}
		}
		
		String[] bills = request.getParameter("billID").split(",");
		voucherEntryList = voucherMgr.getBillGoods(voucherEntryList,bills);
		
	    voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
	    voucherSubsetIDList = voucherMgr.getVoucherTypeByID(bVoucherType);
		
		return SUCCESS;
	}
	
	/**
	 * Description：新增出库凭证
	 */
	public String insertOutStrogeVoucher() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));       //凭证号
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();      //创建人ID	
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType")); //凭证具体类型
		String remark = Utility.getName(request.getParameter("remark"));             //备注		
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPersonID);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("出库凭证：" + voucherID + "新增!");		
//		logisticsLogMgr.insertLog(logPo);  //新增日志

		VoucherPo po = new VoucherPo();
		po.setsLvvID(voucherID);
		po.setsLvvPersonID(createPersonID);
		po.setsLvvRemark(remark);
		po.setsLvvVoucherTypeID(sVoucherType);
		po.setsLvvDate(Utility.getName(voucherMgr.selCurrentAccountPeriod(personInfoPo.getPersoncompanyid()).getsLvvDateLowerLimit()));
		
		int count = voucherEntryTempPo.getsLveveBillID().length;
		List<VoucherEntryPo> voucherEntryList = new ArrayList<VoucherEntryPo>();
		for (int i = 0; i < count; i++){
			VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
			voucherEntryPo.setsLveveVoucherID(voucherID);
			voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
						
			voucherEntryList.add(voucherEntryPo);
		}
				
		String auditState=Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			po.setsLvvAuditPersonID(createPersonID);
			po.setsLvvAuditStatue("1");
		}else{
			po.setsLvvAuditStatue("0");
		}
		
		if (sVoucherType.equals("301") || sVoucherType.equals("502") || sVoucherType.equals("601") ){
			int costcount = voucherMgr.isCostAccount();
			if (costcount > 0){
				voucherMgr.insertOutStrogeVoucher(po, voucherEntryList,logPo);			
				this.clearMessages();
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			}else{
				this.clearMessages();
				this.addActionMessage(getText("新增凭证失败，未进行成本计算!"));
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			}
					
			return SUCCESS;
		}

		voucherMgr.insertOutStrogeVoucher(po, voucherEntryList,logPo);			
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
	/**
	 * Description：查询出库凭证
	 */
	public String selOutStrogeVoucher() throws Exception {		

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));           //凭证号
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String postStatue = Utility.getName(request.getParameter("postStatue"));         //过账标识
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //凭证起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //凭证终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));     //凭证具体类型
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));     //凭证基本类型
		String shopCode = Utility.getName(request.getParameter("shopCode"));
		String parentID = Utility.getName(request.getParameter("parentID"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		
		String softwarePath = Utility.getName(request.getParameter("softwarePath"));
		request.setAttribute("softwarePath",Utility.getName(softwarePath));
		
		if (!parentID.equals("")){
			voucherSubsetIDList = voucherMgr.getVoucherTypeByID(parentID);
		}
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		
		po = new VoucherPo();
		po.setsLvvID(voucherID);
		po.setsLvvAuditStatue(auditStatue);
		po.setsLvvAuditDateTopLimit(auditStartTime);
		po.setsLvvAuditDateLowerLimit(auditEndTime);
		po.setsLvvDateTopLimit(billStartTime);
		po.setsLvvDateLowerLimit(billEndTime);
		po.setsLvvVoucherTypeID(bVoucherType.equals("") ? "3" : sVoucherType);
		po.setsLvvPosting(postStatue);		
		po.setsLvvPersonID(createPersonID);
		po.setsShopCode(shopCode);

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
		
	    int count = voucherMgr.selOutStrogeVoucherCount(po);
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
			voucherList = voucherMgr.selOutStrogeVoucher(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			voucherList = null;
		}
		
		salesShopList = voucherMgr.getSalesShopList();
		
		request.setAttribute("voucherID" , voucherID);
		request.setAttribute("auditStatue" , auditStatue);
		request.setAttribute("postStatue" , postStatue);
		request.setAttribute("billStartTime" , billStartTime);
		request.setAttribute("billEndTime" , billEndTime);
		request.setAttribute("auditStartTime" , auditStartTime);
		request.setAttribute("auditEndTime" , auditEndTime);
		request.setAttribute("sVoucherType" , sVoucherType);
		request.setAttribute("bVoucherType" , bVoucherType);
		request.setAttribute("parentID" , bVoucherType);
		request.setAttribute("subID" , sVoucherType);
		request.setAttribute("createPersonID" , createPersonID);
		request.setAttribute("shopNum" , shopCode);
		
		//释放资源
		voucherID = null;
		shopCode = null;
		auditStatue = null;
		postStatue = null;
		billStartTime = null;
		billEndTime = null;
		auditStartTime = null;
		auditEndTime = null;
		sVoucherType = null;
		bVoucherType = null;
		
		return SUCCESS;
	}
	
	/**
	 * Description：查询凭证的所有信息
	 */
	public String selOutStrogeVoucherDetail() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		po = getVoucherDetail(voucherID);
		request.setAttribute("createPerson",po.getsLvvPersonName());
		request.setAttribute("sType",po.getsLvvVoucherTypeID().substring(0,1));
		
		VoucherPo vePo = new VoucherPo();
		vePo.setsLvvID(voucherID);
		
		voucherEntryList = voucherMgr.getSalesOutStorageVoucherList(vePo);
		
		voucherID = null;
		
		return SUCCESS;		
	}
	
	/**
	 * Description：初始化修改凭证的所有信息
	 */
	public String initOutStrogeVoucherUpdate() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		po = getVoucherDetail(voucherID);
		
		request.setAttribute("createPerson",po.getsLvvPersonName());
		request.setAttribute("sType",po.getsLvvVoucherTypeID().substring(0,1));
		
		VoucherPo vePo = new VoucherPo();
		vePo.setsLvvID(voucherID);
		
		voucherEntryList = voucherMgr.getSalesOutStorageVoucherList(vePo);
		
		voucherID = null;
		
		return SUCCESS;		
	}	
	
	/**
	 * Description：修改凭证的所有信息
	 */
	public String updateOutStrogeVoucher() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPersonID = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPersonID);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ******************************/
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPersonID);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("3");    // 1 表示新增
		logPo.setsLogContent("出库凭证：" + Utility.getName(po.getsLvvID())+"修改!");		
//		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		String auditState=Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			po.setsLvvAuditStatue("1");
			po.setsLvvAuditPersonID(createPersonID);			
		}else{
			po.setsLvvAuditStatue("0");
		}
		
		voucherMgr.updateSalesOutStorageVoucher(po, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;		
	}
	
	/**
	 * Description：查询凭证的基本信息
	 */
	private VoucherPo getVoucherDetail(String voucherID){
		VoucherPo voucherPo = new VoucherPo();
		voucherPo.setsLvvID(voucherID);
		voucherPo.setsLvvVoucherParentTypeID("3");
		
		voucherList = voucherMgr.getVoucherList(voucherPo,0,1);
		Iterator<VoucherPo> it = voucherList.iterator();
		VoucherPo po = new VoucherPo();
		
		while (it.hasNext()){
			po = (VoucherPo)it.next();
			
			String sLvtvtTypeName = voucherMgr.getVoucherTypeName(po.getsLvvVoucherParentTypeID());
			po.setsLvvVoucherParentTypeName(sLvtvtTypeName);
			if (!"".equals(Utility.getName(po.getsLvvAuditPersonID()))){
				po.setsLvvAuditPersonName(voucherMgr.getAuditPersonNameByID(Utility.getName(po.getsLvvAuditPersonID())));
			}
			
			VoucherEntryPo epo = voucherMgr.getOutStrogeAmount(voucherID);
			
			po.setsLvvNotTaxRateAmount(Utility.getName(epo.getsNotTaxRateAmount()));
			po.setsLvvCostPriceAmount(Utility.getName(epo.getsCostPriceAmount()));
		
		    break;
		}
		
		return po;
	}
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}

	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<InventoryPo> getSelectBillList() {
		return selectBillList;
	}

	public void setSelectBillList(List<InventoryPo> selectBillList) {
		this.selectBillList = selectBillList;
	}

	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}

	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
	}

	public List<VoucherTypePo> getVoucherTopIDList() {
		return voucherTopIDList;
	}

	public void setVoucherTopIDList(List<VoucherTypePo> voucherTopIDList) {
		this.voucherTopIDList = voucherTopIDList;
	}

	public List<VoucherTypePo> getVoucherSubsetIDList() {
		return voucherSubsetIDList;
	}

	public void setVoucherSubsetIDList(List<VoucherTypePo> voucherSubsetIDList) {
		this.voucherSubsetIDList = voucherSubsetIDList;
	}

	public List<VoucherPo> getVoucherList() {
		return voucherList;
	}

	public void setVoucherList(List<VoucherPo> voucherList) {
		this.voucherList = voucherList;
	}

	public List<VoucherEntryPo> getVoucherEntryList() {
		return voucherEntryList;
	}

	public void setVoucherEntryList(List<VoucherEntryPo> voucherEntryList) {
		this.voucherEntryList = voucherEntryList;
	}

	public List<SalesShopPo> getSalesShopList() {
		return salesShopList;
	}

	public void setSalesShopList(List<SalesShopPo> salesShopList) {
		this.salesShopList = salesShopList;
	}

	public VoucherPo getPo() {
		return po;
	}

	public void setPo(VoucherPo po) {
		this.po = po;
	}

	public VoucherTempPo getVoucherTempPo() {
		return voucherTempPo;
	}

	public void setVoucherTempPo(VoucherTempPo voucherTempPo) {
		this.voucherTempPo = voucherTempPo;
	}

	public VoucherEntryTempPo getVoucherEntryTempPo() {
		return voucherEntryTempPo;
	}

	public void setVoucherEntryTempPo(VoucherEntryTempPo voucherEntryTempPo) {
		this.voucherEntryTempPo = voucherEntryTempPo;
	}

	public List<InvoicePo> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<InvoicePo> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public InvoicePo getInvoicePo() {
		return invoicePo;
	}

	public void setInvoicePo(InvoicePo invoicePo) {
		this.invoicePo = invoicePo;
	}

	public List<InvoiceEntryPo> getInvoiceEntryList() {
		return invoiceEntryList;
	}

	public void setInvoiceEntryList(List<InvoiceEntryPo> invoiceEntryList) {
		this.invoiceEntryList = invoiceEntryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
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
	
}
