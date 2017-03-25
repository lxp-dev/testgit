/**
* 项目名称 : EIMS财务物流子系统
* 包 名          ：com.pengsheng.eims.logistics.action
* 文件名称 : VoucherAction.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
*/
package com.pengsheng.eims.yklogistics.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SalesShopPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.yklogistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.yklogistics.mgr.VoucherMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

@SuppressWarnings("serial")
public class VoucherAction extends BaseAction {
	
	private LogisticsLogMgr yklogisticsLogMgr = null;             //日志接口
	private PersonPermissionMgr personPermissionMgr = null;	
	private List<InventoryPo> selectBillList = null;
	private VoucherMgr ykvoucherMgr = null;                       //Mgr接口
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
	
	private List<InventoryEntryPo> inventoryEntryList = null;
	
	/**
	 * Description：单击凭证管理菜单进入凭证查询页面时，查询凭证的所有基本类型
	 */
	public String initVoucherSel() throws Exception {
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
		
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();
		voucherTopIDList = ykvoucherMgr.getVoucherTypeByID("0"); // 0 表示查询的是凭证的基本类型
		request.setAttribute("createPersonID",createPersonID);
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();		
		request.setAttribute("billStartTime",Utility.getName(po.getsLvvDateTopLimit()));
		
		String softwarePath = ykvoucherMgr.getCurrentFinanceSoftwarePath();
		request.setAttribute("softwarePath",Utility.getName(softwarePath));
		
		return SUCCESS;
	}
	
	/**
	 * Description：根据凭证基本类型查询所属具体类型
	 */
	public void initVoucherTypeByParentID() throws Exception {		
		String parentID = Utility.getName(request.getParameter("parentID"));  //页面上选择的凭证的基本类型		
		request.setAttribute("parentID" , parentID);
		
		voucherTopIDList = ykvoucherMgr.getVoucherTypeByID("0");                //查询凭证的所有基本类型
		
		PrintWriter out = null;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(parentID.equals("")){
			out.println("<option value=''>----请选择----</option>");
		}else{
			//根据页面上选择的凭证的基本类型查询其所属的具体类型
			voucherSubsetIDList = ykvoucherMgr.getVoucherTypeByID(parentID);	
			Iterator<VoucherTypePo> it = voucherSubsetIDList.iterator();	
			if (it.hasNext()) {
				while (it.hasNext()) {
					VoucherTypePo po = it.next();
					out.println("<option value='" + po.getsLvtvtId() + "'>" + po.getsLvtvtTypeName() + "</option>");
				}
			}
		}
		//释放流
		out.flush();
		out.close();
		
		//释放资源
		parentID = null;
		out = null;
	}
	
	/**
	 * Description：初始化新增凭证
	 */
	public String initVoucherInsert() throws Exception {	

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
		
		voucherTopIDList = ykvoucherMgr.getVoucherTypeByID("0");
		
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
	 * Description：新增凭证
	 */
	public String insertVoucher() throws Exception {	

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
		String supplierID = Utility.getName(request.getParameter("supplierID"));     //制造商ID
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType")); //凭证具体类型
		String remark = Utility.getName(request.getParameter("remark"));             //备注
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPersonID);
		logPo.setsLogIP(Utility.getName(request.getRemoteAddr()));
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("凭证号：" + voucherID + "新增!");		
//		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		VoucherPo po = new VoucherPo();
		po.setsLvvID(voucherID);
		po.setsLvvPersonID(createPersonID);
		po.setsLvvSupplierID(supplierID);
		po.setsLvvVoucherTypeID(sVoucherType);
		po.setsLvvRemark(remark);
		po.setsLvvDate(Utility.getName(ykvoucherMgr.selCurrentAccountPeriod().getsLvvDateLowerLimit()));
		
		String auditState = Utility.getName(request.getParameter("auditState"));
		if (auditState.equals("1")){
			po.setsLvvAuditPersonID(createPersonID);
			po.setsLvvAuditStatue("1");
		}else{
			po.setsLvvAuditStatue("0");
		}
		
		BigDecimal iNotTaxRateAmount = new BigDecimal(0.00);
		BigDecimal iTaxAmount = new BigDecimal(0.00);
		BigDecimal iCostPriceAmount = new BigDecimal(0.00);
		
		int billCount = voucherEntryTempPo.getsLveveBillID().length;
		int goodsCount = 0;
		try {
			goodsCount = voucherEntryTempPo.getsLveveGoodsID().length;
		} catch (Exception e) {
			goodsCount = 0;
		}
		id = Utility.getName(request.getParameter("id"));
		voucherEntryList = new ArrayList<VoucherEntryPo>();
		for (int i = 0; i < billCount; i++){
			if (goodsCount == 0){				
				List<VoucherEntryPo> poList = null;
				if (id.equalsIgnoreCase("F")){
					poList = ykvoucherMgr.getGoodsIdByInvoiceID(voucherEntryTempPo.getsLveveBillID()[i]);
				}else if (id.equalsIgnoreCase("C")){
					poList = ykvoucherMgr.getGoodsIdByReversalID(voucherEntryTempPo.getsLveveBillID()[i]);
				}
				if (!poList.isEmpty()){
					Iterator<VoucherEntryPo> it = poList.iterator();
					while (it.hasNext()){
						VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
						voucherEntryPo.setsLveveVoucherID(voucherID);
						voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
						
						VoucherEntryPo vePo = (VoucherEntryPo)it.next();
						voucherEntryPo.setsLveveGoodsID(vePo.getsLveveGoodsID());
						voucherEntryList.add(voucherEntryPo);
						
						iNotTaxRateAmount = iNotTaxRateAmount.add(new BigDecimal(Utility.getNameNum(vePo.getsNotTaxRateAmount())));
						iTaxAmount = iTaxAmount.add(new BigDecimal(Utility.getNameNum(vePo.getsTaxAmount())));
						iCostPriceAmount = iCostPriceAmount.add(new BigDecimal(Utility.getNameNum(vePo.getsCostPriceAmount())));
					}
				}
				
				po.setsLvvNotTaxRateAmount(iNotTaxRateAmount.toString());
				po.setsLvvTaxAmount(iTaxAmount.toString());
				po.setsLvvCostPriceAmount(iCostPriceAmount.toString());
				
			}else{
				VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
				voucherEntryPo.setsLveveVoucherID(voucherID);
				voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
				voucherEntryPo.setsLveveGoodsID(voucherEntryTempPo.getsLveveGoodsID()[i]);
				voucherEntryPo.setsGoodsQuantity(voucherEntryTempPo.getsGoodsQuantity()[i]);
				voucherEntryPo.setsCostPrice(voucherEntryTempPo.getsCostPrice()[i]);				
				voucherEntryPo.setsNotTaxRate(voucherEntryTempPo.getsNotTaxRate()[i]);				
				voucherEntryPo.setsTaxRate(voucherEntryTempPo.getsTaxRate()[i]);
				
				voucherEntryPo.setsNotTaxRateAmount(voucherEntryTempPo.getsNotTaxRateAmount()[i]);
				voucherEntryPo.setsTaxAmount(voucherEntryTempPo.getsTaxAmount()[i]);
				voucherEntryPo.setsCostPriceAmount(voucherEntryTempPo.getsCostPriceAmount()[i]);
				
				voucherEntryList.add(voucherEntryPo);
			}
		}
		
		ykvoucherMgr.insertVoucher(po,voucherEntryList,id,sVoucherType,logPo);
			
		voucherTopIDList = ykvoucherMgr.getVoucherTypeByID("0");
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：凭证查询页面中查询凭证的基本信息
	 */
	public String selVoucher() throws Exception {
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));     //制造商名称
		String supplierID = Utility.getName(request.getParameter("supplierID"));         //制造商ID
		String auditStatue = Utility.getName(request.getParameter("auditStatue"));       //审核状态
		String postStatue = Utility.getName(request.getParameter("postStatue"));         //过账标识
		String billStartTime = Utility.getName(request.getParameter("billStartTime"));   //凭证起始时间
		String billEndTime = Utility.getName(request.getParameter("billEndTime"));       //凭证终止时间
		String auditStartTime = Utility.getName(request.getParameter("auditStartTime")); //审核起始时间
		String auditEndTime = Utility.getName(request.getParameter("auditEndTime"));     //审核终止时间
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));     //凭证具体类型
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));     //凭证基本类型
		String parentID = Utility.getName(request.getParameter("parentID"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String softwarePath = Utility.getName(request.getParameter("softwarePath"));
		
		request.setAttribute("softwarePath",Utility.getName(softwarePath));
		
		if (!parentID.equals("")){
			voucherSubsetIDList = ykvoucherMgr.getVoucherTypeByID(parentID);
		}
		voucherTopIDList = ykvoucherMgr.getVoucherTypeByID("0");
		
		po = new VoucherPo();
		po.setsLvvID(voucherID);
		po.setsLvvSupplierID(supplierID);
		po.setsLvvAuditStatue(auditStatue);
		po.setsLvvAuditDateTopLimit(auditStartTime);
		po.setsLvvAuditDateLowerLimit(auditEndTime);
		po.setsLvvDateTopLimit(billStartTime);
		po.setsLvvDateLowerLimit(billEndTime);
		po.setsLvvVoucherTypeID(sVoucherType);
		po.setsLvvPosting(postStatue);		
		po.setsLvvPersonID(createPersonID);
		
		int count = ykvoucherMgr.getVoucherCount(po);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}

			Pagination page = new Pagination(request, count, perPage);
			voucherList = ykvoucherMgr.getVoucherList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			voucherList = null;
		}
		
		request.setAttribute("voucherID" , voucherID);
		request.setAttribute("supplierName" , supplierName);
		request.setAttribute("supplierID" , supplierID);
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
		
		//释放资源
		voucherID = null;
		supplierName = null;
		supplierID = null;
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
	public String selVoucherDetail() throws Exception {
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
		
		//判断是否为发票或冲回
		switch(Integer.valueOf(po.getsLvvVoucherTypeID().trim())){		
	    case 103:
	    case 104:
	    case 203:
	    case 204:
	    case 109:
	    case 110:
	    case 209:
	    case 210: 	
			id = "F";	    	
	    	voucherEntryList = ykvoucherMgr.getInvoiceList(voucherID);
			break;
	    case 102:
	    case 106:
	    case 108:
	    case 202:
	    case 206:
	    case 208:
	    	id = "C";
			voucherEntryList = ykvoucherMgr.getReversalList(voucherID);
			break;
	    default:
	    	id = "D";
			VoucherEntryPo vePo = new VoucherEntryPo();
			vePo.setsLveveID(voucherID);
	    	voucherEntryList = ykvoucherMgr.getVoucherEntryByBillsList(vePo);			
	    }		
		
		voucherID = null;
		
		return SUCCESS;		
	}
	
	/**
	 * Description：查询凭证的基本信息
	 */
	private VoucherPo getVoucherDetail(String voucherID){
		VoucherPo voucherPo = new VoucherPo();
		voucherPo.setsLvvID(voucherID);
		
		voucherList = ykvoucherMgr.getVoucherList(voucherPo,0,1);
		VoucherPo po = voucherList.iterator().next();
		
		String sLvtvtTypeName = ykvoucherMgr.getVoucherTypeName(po.getsLvvVoucherParentTypeID());
		po.setsLvvVoucherParentTypeName(sLvtvtTypeName);
		if (!"".equals(Utility.getName(po.getsLvvAuditPersonID()))){
			po.setsLvvAuditPersonName(ykvoucherMgr.getAuditPersonNameByID(Utility.getName(po.getsLvvAuditPersonID())));
		}		
		return po;
	}
	
	/**
	 * Description：查询冲回的明细信息
	 */
	public String selReversalDetail() throws Exception {
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
		
		String reversalID = Utility.getName(request.getParameter("reversalID"));
		invoicePo = new InvoicePo();
		invoicePo.setLiiid(reversalID);
		invoicePo = ykvoucherMgr.getReversalPo(invoicePo);
		
		InvoiceEntryPo invoiceEntryPo = new InvoiceEntryPo();
		invoiceEntryPo.setLieieinvoiceid(reversalID);

		invoiceEntryList = ykvoucherMgr.getReversalEntryPoList(invoiceEntryPo);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化修改凭证
	 */
	public String initVoucherUpdate() throws Exception {

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
		String parentID = Utility.getName(request.getParameter("parentID"));
		
		VoucherPo voucherPo = new VoucherPo();
		voucherPo.setsLvvID(voucherID);
		voucherList = ykvoucherMgr.getVoucherList(voucherPo,0,1);
		po = voucherList.iterator().next();
		
	    request.setAttribute("supplierID" ,po.getsLvvSupplierID());
	    request.setAttribute("supplierName",po.getsLvvSupplierName());
	    request.setAttribute("voucherDate" , po.getsLvvDate());
	    request.setAttribute("createPerson" , po.getsLvvPersonName());
	    request.setAttribute("remark" , po.getsLvvRemark());
		request.setAttribute("subID" , po.getsLvvVoucherTypeID());
		request.setAttribute("sType" , po.getsLvvVoucherTypeID());
		request.setAttribute("voucherID" , voucherID);
		
		if (parentID.equals("")){
			parentID = ykvoucherMgr.getVoucherParentTypeByID(voucherID).iterator().next().getsLvtvtParentID();
		}
		request.setAttribute("parentID" , parentID);
		
		String sLvtvtTypeName = ykvoucherMgr.getVoucherTypeName(po.getsLvvVoucherParentTypeID());
		po.setsLvvVoucherParentTypeName(sLvtvtTypeName);		
		
		VoucherEntryPo vePo = new VoucherEntryPo();
		vePo.setsLveveID(voucherID);
		
		switch(Integer.valueOf(po.getsLvvVoucherTypeID().trim())){		
	    //发票
		case 103:
	    case 104:
	    case 203:
	    case 204: 
	    case 109:
	    case 110:
	    case 209:
	    case 210: 
	    	id = "F";
	    	voucherEntryList = ykvoucherMgr.getInvoiceList(voucherID);
			break;
	    //冲回
	    case 102:
	    case 106:
	    case 108:
	    case 202:
	    case 206:
	    case 208:
	    	id = "C";
	    	voucherEntryList = ykvoucherMgr.getReversalList(voucherID);
			break;
	    //单据
	    default:
	    	id = "D";
	    	voucherEntryList = ykvoucherMgr.getVoucherEntryByBillsList(vePo);
	    }
		return SUCCESS;	
	}
	
	/**
	 * Description：根据参数修改凭证
	 */
	public String updateVoucher() throws Exception {

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
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String remark = Utility.getName(request.getParameter("remark"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String sType = Utility.getName(request.getParameter("sType"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("凭证号：" + voucherID + "修改!");		
//		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		VoucherPo voucherPo = new VoucherPo();
		voucherPo.setsLvvID(voucherID);
		voucherPo.setsLvvDate(voucherDate);
		voucherPo.setsLvvVoucherTypeID(sVoucherType);
		voucherPo.setsLvvRemark(remark);
		
		BigDecimal iNotTaxRateAmount = new BigDecimal(0.00);
		BigDecimal iTaxAmount = new BigDecimal(0.00);
		BigDecimal iCostPriceAmount = new BigDecimal(0.00);
		
		if (auditState.equals("0")){
			voucherPo.setsLvvAuditStatue("0");
			voucherPo.setsLvvAuditPersonID("");
		}else{
			voucherPo.setsLvvAuditStatue("1");
			voucherPo.setsLvvAuditPersonID(((PersonInfoPo) session.get("person")).getId());
		}
		
		int billCount = voucherEntryTempPo.getsLveveBillID().length;
		int goodsCount = 0;
		try {
			goodsCount = voucherEntryTempPo.getsLveveGoodsID().length;
		} catch (Exception e) {
			goodsCount = 0;
		}
		id = Utility.getName(request.getParameter("id"));
		
		voucherEntryList = new ArrayList<VoucherEntryPo>();
		for (int i = 0; i < billCount; i++){
			if (goodsCount == 0){				
				List<VoucherEntryPo> poList = null;
				if (id.equalsIgnoreCase("F")){
					poList = ykvoucherMgr.getGoodsIdByInvoiceID(voucherEntryTempPo.getsLveveBillID()[i]);
				}else if (id.equalsIgnoreCase("C")){
					poList = ykvoucherMgr.getGoodsIdByReversalID(voucherEntryTempPo.getsLveveBillID()[i]);
				}
				if (!poList.isEmpty()){
					Iterator<VoucherEntryPo> it = poList.iterator();
					while (it.hasNext()){
						VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
						voucherEntryPo.setsLveveVoucherID(voucherID);
						voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
						
						VoucherEntryPo po = (VoucherEntryPo)it.next();
						voucherEntryPo.setsLveveGoodsID(po.getsLveveGoodsID());
						voucherEntryList.add(voucherEntryPo);							
						
						iNotTaxRateAmount = iNotTaxRateAmount.add(new BigDecimal(Utility.getNameNum(po.getsNotTaxRateAmount())));
						iTaxAmount = iTaxAmount.add(new BigDecimal(Utility.getNameNum(po.getsTaxAmount())));
						iCostPriceAmount = iCostPriceAmount.add(new BigDecimal(Utility.getNameNum(po.getsCostPriceAmount())));
					}
				}	
				voucherPo.setsLvvNotTaxRateAmount(iNotTaxRateAmount.toString());
				voucherPo.setsLvvTaxAmount(iTaxAmount.toString());
				voucherPo.setsLvvCostPriceAmount(iCostPriceAmount.toString());
				
			}else{
				VoucherEntryPo voucherEntryPo = new VoucherEntryPo();
				voucherEntryPo.setsLveveVoucherID(voucherID);
				voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);				
				voucherEntryPo.setsLveveGoodsID(voucherEntryTempPo.getsLveveGoodsID()[i]);
				voucherEntryPo.setsGoodsQuantity(voucherEntryTempPo.getsGoodsQuantity()[i]);
				voucherEntryPo.setsCostPrice(voucherEntryTempPo.getsCostPrice()[i]);
				voucherEntryPo.setsCostPriceAmount(voucherEntryTempPo.getsCostPriceAmount()[i]);
				voucherEntryPo.setsNotTaxRate(voucherEntryTempPo.getsNotTaxRate()[i]);
				
				voucherEntryPo.setsNotTaxRateAmount(voucherEntryTempPo.getsNotTaxRateAmount()[i]);
				voucherEntryPo.setsTaxRate(voucherEntryTempPo.getsTaxRate()[i]);
				voucherEntryPo.setsTaxAmount(voucherEntryTempPo.getsTaxAmount()[i]);
				
				voucherEntryList.add(voucherEntryPo);
			}
		}
		
	    ykvoucherMgr.updateVoucherByID(voucherPo, voucherEntryList,id,sType,logPo);	
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化删除凭证
	 */
	public String initVoucherDelete() throws Exception {

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
		request.setAttribute("voucherID",voucherID);
		return SUCCESS;
	}
	
	/**
	 * Description：根据参数删除凭证
	 */
	public String deleteVoucher() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始
		logPo.setsLogOpID("2");    // 2表示删除
		logPo.setsLogContent("凭证号：" + voucherID + "删除!");		
//		logisticsLogMgr.insertLog(logPo);  //新增日志
		
		String voucherType = ykvoucherMgr.getVoucherTypeByVoucherID(voucherID);

		ykvoucherMgr.deleteVoucherByID(voucherID,voucherType,logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：凭证修改页面初始化选择单据
	 */
	public String initSelectBillUpdate() throws Exception {
		
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
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("billtype",bVoucherType);
	    request.setAttribute("sVoucherType" , sVoucherType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);
	    
		return SUCCESS;
	}
	
	/**
	 * Description：凭证修改页面单据、发票、冲回数据选择
	 */
	public String selectBillGoodsUpdate() throws Exception {
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
		if (voucherEntryList == null){
			voucherEntryList = new ArrayList<VoucherEntryPo>();
		}
		
		id = Utility.getName(request.getParameter("id"));
		if (id.equalsIgnoreCase("D")){
			if (voucherEntryTempPo != null){
				int length = voucherEntryTempPo.getsLveveBillID().length;		
				for (int i = 0; i < length; i++){
					VoucherEntryPo voucherEntryPo = new VoucherEntryPo();			
					voucherEntryPo.setsLveveVoucherID(voucherID);
					voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
					voucherEntryPo.setsLveveID(Utility.getName(voucherEntryTempPo.getsLveveID()[i]));
					voucherEntryPo.setsStockID(Utility.getName(voucherEntryTempPo.getsStockID()[i]));
					voucherEntryPo.setsLveveGoodsID(voucherEntryTempPo.getsLveveGoodsID()[i]);
					voucherEntryPo.setsGoodsName(voucherEntryTempPo.getsGoodsName()[i]);
					voucherEntryPo.setsSpec(voucherEntryTempPo.getsSpec()[i]);
					voucherEntryPo.setsGoodsQuantity(voucherEntryTempPo.getsGoodsQuantity()[i]);
					voucherEntryPo.setsNotTaxRate(voucherEntryTempPo.getsNotTaxRate()[i]);
					voucherEntryPo.setsNotTaxRateAmount(voucherEntryTempPo.getsNotTaxRateAmount()[i]);
					voucherEntryPo.setsTaxRate(voucherEntryTempPo.getsTaxRate()[i]);
					voucherEntryPo.setsCostPrice(voucherEntryTempPo.getsCostPrice()[i]);
					voucherEntryPo.setsTaxAmount(voucherEntryTempPo.getsTaxAmount()[i]);
					voucherEntryPo.setsCostPriceAmount(voucherEntryTempPo.getsCostPriceAmount()[i]);
					voucherEntryPo.setsInvoiceState(Utility.getName(voucherEntryTempPo.getsInvoiceState()[i]));
					
					voucherEntryList.add(voucherEntryPo);
				}
			}
			if(!"".equals(Utility.getName(request.getParameter("billID")))){
				String[] bills = request.getParameter("billID").split(",");
				voucherEntryList = ykvoucherMgr.getBillGoods(voucherEntryList,bills);
			}
		}else{
			if (voucherEntryTempPo != null){
				int length = voucherEntryTempPo.getsLveveBillID().length;
				for (int i = 0; i < length; i++){
					VoucherEntryPo voucherEntryPo = new VoucherEntryPo();			
					voucherEntryPo.setsLveveVoucherID(voucherID);
					voucherEntryPo.setsLveveBillID(voucherEntryTempPo.getsLveveBillID()[i]);
					voucherEntryPo.setsDate(voucherEntryTempPo.getsDate()[i]);
					voucherEntryPo.setsDepartment(voucherEntryTempPo.getsDepartment()[i]);
					voucherEntryPo.setsSupplierName(voucherEntryTempPo.getsSupplierName()[i]);
					voucherEntryPo.setsPersonID(voucherEntryTempPo.getsPersonID()[i]);
					
					voucherEntryList.add(voucherEntryPo);
				}
			}		
			
			if(!"".equals(Utility.getName(request.getParameter("billID")))){
				String[] bills = request.getParameter("billID").split(",");
				if (id.equalsIgnoreCase("C")){
					voucherEntryList = ykvoucherMgr.getReversalListByID(voucherEntryList,bills);
				}else{
					voucherEntryList = ykvoucherMgr.getInvoiceListByID(voucherEntryList,bills);
				}
			}
		}
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String bVoucherType = Utility.getName(request.getParameter("bVoucherType"));
		String sVoucherType = Utility.getName(request.getParameter("sVoucherType"));
		String sType = Utility.getName(request.getParameter("sType"));
		String voucherDate = Utility.getName(request.getParameter("voucherDate"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String remark = Utility.getName(request.getParameter("remark"));
		
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("parentID" , bVoucherType);
	    request.setAttribute("subID" , sVoucherType);
	    request.setAttribute("sType" , sType);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherDate" , voucherDate);
	    request.setAttribute("createPerson" , createPerson);
	    request.setAttribute("remark" , remark);	    
		
	    voucherTopIDList = ykvoucherMgr.getVoucherTypeByID("0");
	    voucherSubsetIDList = ykvoucherMgr.getVoucherTypeByID(bVoucherType);
	    
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}	
	
	/**
	 * Description：初始化凭证导入总账
	 */
	public String initVoucherPosting(){
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
		
		return SUCCESS;
	}	
	
	/**
	 * Description：查询需导入总账的凭证
	 */
	public String selVoucherPosting(){
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
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();
		
		po = new VoucherPo();
		po.setsLvvID(voucherID);
		po.setsLvvDateTopLimit(startTime);
		po.setsLvvDateLowerLimit(endTime);
		po.setsLvvPosting("0");		
        po.setsLvvAuditStatue("1");        
        po.setsLvvPersonID(createPersonID);
        
		voucherList = ykvoucherMgr.getVoucherList(po);
        
		request.setAttribute("voucherID" , voucherID);
		request.setAttribute("startTime" , startTime);
		request.setAttribute("endTime" , endTime);
		
		return SUCCESS;
	}
	
	/**
	 * Description：凭证导入总账
	 */
	public String voucherPosting(){
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
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.posting"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);		
		
		String createPersonID = ((PersonInfoPo) session.get("person")).getId();
		StringBuffer vouchersID = new StringBuffer();
		
		String count = Utility.getName(request.getParameter("count"));
		if ("0".equals(count)){
			po = new VoucherPo();
	        po.setsLvvPersonID(createPersonID);
	        
	        List<VoucherPo> voucherList = ykvoucherMgr.getVoucherList(po);
			Iterator<VoucherPo> it = voucherList.iterator();
			while (it.hasNext()){
				vouchersID.append(it.next().getsLvvID() + ",") ;
			}
		}else{
			if (voucherTempPo != null){
				int length = voucherTempPo.getsLvvID().length;		
				for (int i = 0; i < length; i++){
					vouchersID.append(voucherTempPo.getsLvvID()[i] + ",");
				}
			}
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("10");    // 10 表示导入
		logPo.setsLogContent("凭证号:" + vouchersID.toString() + "导入财务软件!");		
		yklogisticsLogMgr.insertLog(logPo);  //新增日志	
		
		SystemParameterPo systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		ykvoucherMgr.updateXZD_VoucherPosting(vouchersID.toString(),personInfoPo.getPersoncompanyid(),Utility.getName(systemParameterPo.getFspcbjstype()),logPo);
	
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.post.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：多级销售报表
	 */
	public String initMultilevelSales(){
		salesShopList = ykvoucherMgr.getSalesShopList();
		return SUCCESS;
	}
	
	/**
	 * Description：初始化单据查询
	 */
	public String initSelBill(){
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
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();
		
		request.setAttribute("begintime" ,Utility.getName(po.getsLvvDateTopLimit()));
	    request.setAttribute("endtime" , Utility.getName(po.getsLvvDateLowerLimit()));
		request.setAttribute("bgnDate" ,Utility.getName(po.getsLvvDateTopLimit()));
	    request.setAttribute("endDate" , Utility.getName(po.getsLvvDateLowerLimit()));
	    
		return SUCCESS;
	}
	
	/**
	 * Description：单据查询
	 */
	public String selBill(){	
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
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String billid = Utility.getName(request.getParameter("billid"));
		String startTime = Utility.getName(request.getParameter("begintime"));
		String endTime = Utility.getName(request.getParameter("endtime"));
		String bgnDate = Utility.getName(request.getParameter("bgnDate"));
		String endDate = Utility.getName(request.getParameter("endDate"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String invoiceState = Utility.getName(request.getParameter("invoiceState"));
		String voucherStatus = Utility.getName(request.getParameter("voucherStatus"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("billid" , billid);
	    request.setAttribute("begintime" , startTime);
	    request.setAttribute("endtime" , endTime);
	    request.setAttribute("bgnDate" , bgnDate);
	    request.setAttribute("endDate" , endDate);
	    request.setAttribute("goodsID" , goodsID);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("voucherID" , voucherID);
	    request.setAttribute("voucherStatus" , voucherStatus);
	    
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(startTime);
	    inPo.setCstiendTime(endTime);
	    inPo.setCstiinvoicestate(invoiceState);
	    inPo.setVoucher(voucherID);
	    inPo.setCstigoodsid(goodsID);
	    inPo.setCstisupplierid(supplierID);
	    inPo.setSalesOutBillType(voucherStatus);
	    
	    int count = ykvoucherMgr.getSelectBillCount(inPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);			
			selectBillList = ykvoucherMgr.selectSelectBill(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
	    
		return SUCCESS;
	}
	
	
	/**
	 * Description：发票冲回查询总数
	 */
	public String initSelInvoiceAndReversal(){
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
		
		VoucherPo po = ykvoucherMgr.selCurrentAccountPeriod();
		
		request.setAttribute("begintime" ,Utility.getName(po.getsLvvDateTopLimit()));
	    request.setAttribute("endtime" , Utility.getName(po.getsLvvDateLowerLimit()));
	    
		return SUCCESS;
	}	
	
	/**
	 * Description：发票冲回查询列表
	 */
	public String selInvoiceAndReversal(){	
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
		
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String billid = Utility.getName(request.getParameter("billid"));
		String startTime = Utility.getName(request.getParameter("begintime"));
		String endTime = Utility.getName(request.getParameter("endtime"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String invoiceState = Utility.getName(request.getParameter("invoiceState"));
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		
	    request.setAttribute("supplierName" , supplierName);
	    request.setAttribute("supplierID" , supplierID);
	    request.setAttribute("billid" , billid);
	    request.setAttribute("begintime" , startTime);
	    request.setAttribute("endtime" , endTime);
	    request.setAttribute("goodsID" , goodsID);
	    request.setAttribute("invoiceState" , invoiceState);
	    request.setAttribute("voucherID" , voucherID);
	    
	    InventoryPo inPo = new InventoryPo();
	    inPo.setCstibillid(billid);
	    inPo.setCstistartTime(startTime);
	    inPo.setCstiendTime(endTime);
	    inPo.setCstiinvoicestate(invoiceState);
	    inPo.setVoucher(voucherID);
	    inPo.setCstigoodsid(goodsID);
	    inPo.setCstisupplierid(supplierID);
	    
	    int count = ykvoucherMgr.getSelInvoiceAndReversalCount(inPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);			
			selectBillList = ykvoucherMgr.selInvoiceAndReversal(inPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			selectBillList = null;
		}
	    
		return SUCCESS;
	}
	
	/**
	 * Description：初始化开关账
	 */
	public String initSwitchAmount() throws Exception {

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
		
		po = ykvoucherMgr.selCurrentAccountPeriod();
		request.setAttribute("switchAmountMonth",Utility.getName(po.getsLvvDateTopLimit()).substring(0,7));		
		
		return SUCCESS;
	}
	
	/**
	 * Description：开关账
	 */
	public String insertSwitchAmount() throws Exception {

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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("1");
		logPo.setsLogContent("关账时间：" + Utility.getName(request.getParameter("switchAmountMonth")));		
//		logisticsLogMgr.insertLog(logPo);  //新增日志	
		
		ykvoucherMgr.updateSwitchAmount("g", logPo); // g:关账   k:开账
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);		
		
		po = ykvoucherMgr.selCurrentAccountPeriod();
		request.setAttribute("switchAmountMonth",Utility.getName(po.getsLvvDateTopLimit()).substring(0,7));
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化查询当期还有哪些单据未做凭证
	 */
	public String initBillWhetherSettleAccountsSel() throws Exception {
		
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
		
		po = ykvoucherMgr.selCurrentAccountPeriod();
	    request.setAttribute("currentYear",Utility.getName(po.getsLvvDateTopLimit()).substring(0,4));
	    request.setAttribute("currentMonth",Utility.getName(po.getsLvvDateTopLimit()).substring(5,7));
	    
		return SUCCESS;
	}
	
	/**
	 * Description：查询当期还有哪些单据未做凭证
	 */
	public String selBillWhetherSettleAccounts() throws Exception {
		
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
		
		String year = Utility.getName(request.getParameter("year"));
		String month = Utility.getName(request.getParameter("month"));
		String date = year + "-" + month;
		String billType = Utility.getName(request.getParameter("billType"));
		
	    int count = ykvoucherMgr.selBillWhetherSettleAccountsCount(date,billType);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);			
			inventoryEntryList = ykvoucherMgr.selBillWhetherSettleAccounts(date,billType, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inventoryEntryList = null;
		}
		
		request.setAttribute("currentYear",year);
		request.setAttribute("currentMonth",month);
		request.setAttribute("billType",billType);
		
		return SUCCESS;
	}
	
	/**
	 * Description：初始化向用友传输凭证
	 */
	public String initYYVoucherPosting() throws Exception {

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
		
		return SUCCESS;
	}
	
	/**
	 * Description：向用友传输凭证
	 */
	public String yy_VoucherPosting() throws Exception {
		
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
				
		StringBuffer vouchersID = new StringBuffer();
		
		String count = Utility.getName(request.getParameter("count"));
		if ("0".equals(count)){
			po = new VoucherPo();
	        po.setsLvvPersonID(createPerson);
	        
	        List<VoucherPo> voucherList = ykvoucherMgr.getVoucherList(po);
			Iterator<VoucherPo> it = voucherList.iterator();
			while (it.hasNext()){
				vouchersID.append(it.next().getsLvvID() + ",") ;
			}
		}else{
			if (voucherTempPo != null){
				int length = voucherTempPo.getsLvvID().length;		
				for (int i = 0; i < length; i++){
					vouchersID.append(voucherTempPo.getsLvvID()[i] + ",");
				}
			}
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogResult(moduleID);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogOpID("10");    // 10 表示导入
		logPo.setsLogContent("凭证号:" + vouchersID.toString() + "导入财务软件!");		
//		logisticsLogMgr.insertLog(logPo);  //新增日志	
		
		ykvoucherMgr.updateYY_VoucherPosting(vouchersID.toString(),logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.post.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
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
	public VoucherPo getPo() {
		return po;
	}
	public void setPo(VoucherPo po) {
		this.po = po;
	}
	public List<VoucherEntryPo> getVoucherEntryList() {
		return voucherEntryList;
	}
	public void setVoucherEntryList(
			List<VoucherEntryPo> voucherEntryList) {
		this.voucherEntryList = voucherEntryList;
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
	public VoucherTempPo getVoucherTempPo() {
		return voucherTempPo;
	}
	public void setVoucherTempPo(VoucherTempPo voucherTempPo) {
		this.voucherTempPo = voucherTempPo;
	}
	public String getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}
	public List<SalesShopPo> getSalesShopList() {
		return salesShopList;
	}
	public void setSalesShopList(List<SalesShopPo> salesShopList) {
		this.salesShopList = salesShopList;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public DecimalFormat getDf() {
		return df;
	}
	public void setDf(DecimalFormat df) {
		this.df = df;
	}
	public List<InventoryPo> getSelectBillList() {
		return selectBillList;
	}
	public void setSelectBillList(List<InventoryPo> selectBillList) {
		this.selectBillList = selectBillList;
	}

	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	public LogisticsLogMgr getYklogisticsLogMgr() {
		return yklogisticsLogMgr;
	}

	public void setYklogisticsLogMgr(LogisticsLogMgr yklogisticsLogMgr) {
		this.yklogisticsLogMgr = yklogisticsLogMgr;
	}

	public VoucherMgr getYkvoucherMgr() {
		return ykvoucherMgr;
	}

	public void setYkvoucherMgr(VoucherMgr ykvoucherMgr) {
		this.ykvoucherMgr = ykvoucherMgr;
	}	
	
}
