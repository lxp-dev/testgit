/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTallyAction.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-23
**/
package com.pengsheng.eims.logistics.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.mgr.VoucherTallyMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyTempPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

@SuppressWarnings("serial")
public class VoucherTallyAction extends BaseAction {
	
	private LogisticsLogMgr logisticsLogMgr = null; 
	private VoucherTallyMgr voucherTallyMgr = null;
	private List<VoucherTallyPo> voucherTallyList = null;
	private VoucherTallyTempPo voucherTallyTempPo = null;	
	private List<VoucherTypePo> voucherTopIDList = null;
	private VoucherMgr voucherMgr = null;
	private VoucherPo po = null;	
	private DecimalFormat df = null; 	
	private List<SubjectPo> subjectList = null;	
	private String notTaxRateAmountTotal = null;
	private String taxAmountTotal = null;
	private String costPriceAmountTotal = null;	
	private PersonPermissionMgr personPermissionMgr = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
	/**
	 * Description：生成各种凭证
	 */
	public String editVoucherTally() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		/** ********************** 权限设置 ******************************/
		
		String voucherID = Utility.getName(request.getParameter("voucherID"));
		
		int length = voucherTallyTempPo.getsLvtvtSubjectID().length;
		List<VoucherTallyPo> poList = new ArrayList<VoucherTallyPo>();
		for (int i = 0; i < length; i++){
			VoucherTallyPo po = new VoucherTallyPo();
			po.setsLvtvtVoucherID(voucherID);
			po.setsLvtsBalanceDirection(voucherTallyTempPo.getsLvtsBalanceDirection()[i]);
			po.setsLvtvtResume(voucherTallyTempPo.getsLvtvtResume()[i].trim());
			po.setsLvtvtSubjectID(voucherTallyTempPo.getsLvtvtSubjectID()[i].trim());
			po.setsLvtvtDebitMoney(Utility.getName(voucherTallyTempPo.getsLvtvtDebitMoney()[i].trim()).equals("") ? "" : new BigDecimal(Utility.getName(voucherTallyTempPo.getsLvtvtDebitMoney()[i].trim())).multiply(new BigDecimal(0.01)).setScale(2,RoundingMode.HALF_EVEN).toString());
			po.setsLvtvtLenderMoney(Utility.getName(voucherTallyTempPo.getsLvtvtLenderMoney()[i].trim()).equals("") ? "" : new BigDecimal(Utility.getName(voucherTallyTempPo.getsLvtvtLenderMoney()[i].trim())).multiply(new BigDecimal(0.01)).setScale(2,RoundingMode.HALF_EVEN).toString());
			
			po.setsLvtvtOrderID(voucherTallyTempPo.getsLssOrderID()[i].trim());
			
			poList.add(po);
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		
		voucherTallyList = voucherTallyMgr.getVoucherTallyByID(voucherID);
		if (voucherTallyList.isEmpty()){
			logPo.setsLogResult(moduleID); // 12 表示开始 
			logPo.setsLogOpID("8");    // 1 表示创建记账凭证
			logPo.setsLogContent(voucherID);
			logPo.setsLogContent("记账凭证：" + Utility.getName(voucherID)+"新增!");
//			logisticsLogMgr.insertLog(logPo);  //新增日志
			
			voucherTallyMgr.insertVoucherTally(poList,logPo);
			
//			logPo.setsLogResult("11"); // 11 表示成功 
//			logisticsLogMgr.insertLog(logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE2);
		}else{			
			logPo.setsLogResult(moduleID); // 12 表示开始 
			logPo.setsLogOpID("9");    // 1 表示修改记账凭证
			logPo.setsLogContent("记账凭证：" + Utility.getName(voucherID)+"修改!");	
//			logisticsLogMgr.insertLog(logPo);  //新增日志
			
			String voucherDate = Utility.getName(request.getParameter("voucherDate"));
			String handlePersonID = Utility.getName(request.getParameter("handlePersonID"));
			String balanceMethod = Utility.getName(request.getParameter("balanceMethod"));
			
			VoucherPo voucherPo = new VoucherPo();
			voucherPo.setsLvvID(voucherID);
			voucherPo.setsLvvDate(voucherDate);
			voucherPo.setsLvvBalanceMethod(balanceMethod);
			voucherPo.setsLvvHandlePersonID(handlePersonID);
			
			voucherTallyMgr.updateVoucherByID(voucherPo,poList,logPo);
			
//			logPo.setsLogResult("11"); // 11 表示成功 
//			logisticsLogMgr.insertLog(logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE2);
		}
		
		voucherTopIDList = voucherMgr.getVoucherTypeByID("0");
		
		return SUCCESS;		
	}

	/**
	 * Description：查看各种凭证
	 */
	public String selVoucherTally() throws Exception {
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
		String bType = Utility.getName(request.getParameter("bType"));
		String sType = Utility.getName(request.getParameter("sType"));
		String sTypeID = Utility.getName(request.getParameter("sVoucherType"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String createPerson = Utility.getName(request.getParameter("createPerson"));
		String posting = Utility.getName(request.getParameter("posting"));		
		
		notTaxRateAmountTotal = Utility.getName(request.getParameter("notTaxRateAmountTotal"));
		taxAmountTotal = Utility.getName(request.getParameter("taxAmountTotal"));
		costPriceAmountTotal = Utility.getName(request.getParameter("costPriceAmountTotal"));
		
		voucherTallyList = voucherTallyMgr.getVoucherTallyByID(voucherID);
		if ((voucherTallyList == null || voucherTallyList.isEmpty()) && (voucherTallyMgr.getVoucherTemplateCount(sTypeID)>0)){
			switch(Integer.valueOf(sTypeID)){
	        //3%暂估入库（采购收货）
	        case 101: 
	    	//3%暂估入库（采购退货）
	        case 201: createTemporaryInStorageVoucher(voucherID,supplierName,sTypeID);
	        	      break;
	   /******************************************************************************************************/  	        
		  	//3%暂估冲回（采购收货）
	        case 102: 
	      	//3%暂估冲回（采购退货）
	        case 202: createPercentThreeTemporaryReversalVoucher(voucherID,supplierName,sTypeID);
	        	      break;
	    /******************************************************************************************************/  	      
	    	//盘盈（盘盈）
	    	case 501: createTemporaryProfitVoucher(voucherID,supplierName,sTypeID);
	    		      break;
	    /******************************************************************************************************/ 
	    	//其他材料（其他入库）
		    case 701: createTemporaryOtherInStorageVoucher(voucherID,supplierName,sTypeID);
	    	          break;
	    /******************************************************************************************************/ 
			//普票暂估冲回（采购收货）
		    case 106: 
	    	//普票暂估冲回（采购退货）
		    case 206: createTemporaryReversalVoucher(voucherID,supplierName,sTypeID);
		    	      break; 
		/******************************************************************************************************/ 
	      	//暂估冲回 （采购收货）
		    case 108:
	    	//暂估冲回 （采购退货）
		    case 208: createTemporaryReversalInVoucher(voucherID,supplierName,sTypeID);		    
	    	          break;          
	    /******************************************************************************************************/ 
	    	//普通发票（采购收货）
		    case 103: 
	    	//普通发票（采购退货）
		    case 203: 
		    //冲应付暂估入实际（采购收货）
		    case 109: 
	    	//冲应付暂估入实际（采购退货）
		    case 209: createGeneralInvoiceVoucher(voucherID,supplierName,sTypeID);
		    	      break;
		/******************************************************************************************************/    	      
		  	//增值税发票（采购收货）
		    case 104:
		  	//增值税发票（采购退货）
		    case 204: createValueAddedTaxInvoiceVoucher(voucherID,supplierName,sTypeID);
		    	      break;
		/******************************************************************************************************/    	      
		    //普票暂估入库（采购收货）
		    case 105: 
		  	//普票暂估入库（采购退货）
		    case 205: createTemporaryPuTongInStorageVoucher(voucherID,supplierName,sTypeID);
		              break;
		/******************************************************************************************************/              
		    //冲暂估应付入实际（采购收货）
		    case 110: 
	    	//冲暂估应付入实际（采购退货）
		    case 210: createTemporaryReversalRealityVoucher(voucherID,supplierName,sTypeID);
	    	          break;
	    /******************************************************************************************************/   
		    //暂估入库（采购收货）
		    case 107: 
	    	//暂估入库（采购退货）
		    case 207: createTemporaryInStorageVoucher(voucherID,supplierName,sTypeID);
	    	          break;
	    /******************************************************************************************************/
	    	//销售成本（销售出库）
	    	case 301: createSalesNotTaxRateVoucher(voucherID,supplierName,sTypeID);
	    	          break;
	    /******************************************************************************************************/
	    	//调整 （盘盈）
	    	case 502: createInventoryProfitVoucher(voucherID,supplierName,sTypeID);
	    	          break;
	    	//盘亏入成本（盘亏）
	    	case 601: createInventoryLossesVoucher(voucherID,supplierName,sTypeID);
	    	
  	                  break;
  	    /******************************************************************************************************/	
		    //出库 （其他出库）
		    case 801: createOtherOutStorageVoucher(voucherID,supplierName,sTypeID);
	    	          break;
	    /******************************************************************************************************/	          
	    	//销售收入 （销售出库）
	    	case 302: 
		    //分店 （销售出库）
	    	case 303:
		    //隐形收入 （销售出库）
	    	case 304:
		    //增值税发票 （销售出库）
	    	case 305:
		    //分店增值税（销售出库）
	    	case 306: createSalesRevenueVoucher(voucherID,supplierName,sTypeID);
	    		      break;
	    /******************************************************************************************************/
	    	//付款单 （发票）
		    case 111:
	    	//付款单 （单据）
	    	case 112: 
		    //付款单 （预付款）
	    	case 113:     		
		    //付款单 （厂商减账）
	    	case 114:     		
		    //付款单 （其他付款）
	    	case 115: 	
			//付款单 （调帐）
	    	case 116: 
	    		createPayMentBillVoucher(voucherID,supplierName,sTypeID);
	    		      break;
	    /******************************************************************************************************/   
	        // 客户批发
	    	case 121: 		
	    		createReceiptMentBillVoucher(voucherID,supplierName,sTypeID);
	    		      break;	      
	    		      
		    }
		}
		po = voucherTallyMgr.getBalanceMethodAndHandlePerson(voucherID);
		
		request.setAttribute("voucherID",voucherID);
		request.setAttribute("voucherDate",voucherDate);
		request.setAttribute("bType",bType);
		request.setAttribute("sType",sType);
		request.setAttribute("createPerson",createPerson);
		request.setAttribute("sTypeID",sTypeID);
		request.setAttribute("posting",posting);
		
		return SUCCESS;
	}	
	
	/**
	 * Description：生成普通发票凭证（采购收退货）
	 */
	private void createGeneralInvoiceVoucher(String voucherID,String supplierName,String voucherTypeID){		
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		String[] amount = {notTaxRateAmountTotal,costPriceAmountTotal};
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName);
			if (po.getsLvtsBalanceDirection().equals("j")){
				po.setsLvtvtDebitMoney(amount[i]);
			}
			if (po.getsLvtsBalanceDirection().equals("d")){
				po.setsLvtvtLenderMoney(amount[i]);
			}
		}		
		
		voucherEntryList.clear();
		voucherEntryList = null;
	}
	
	/**
	 * Description：生成普票暂估入库凭证（采购收退货） 
	 */
	private void createTemporaryPuTongInStorageVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}		

		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本
		VoucherEntryPo cAmounts = null;
		VoucherEntryPo LAmounts = null;
		VoucherEntryPo vpo = null;	
		
		List<VoucherEntryPo> list = new ArrayList<VoucherEntryPo>();
		int size = 0;
		for (int j = 0; j < voucherEntryListCount; j++){
			vpo = (VoucherEntryPo)voucherEntryList.get(j);			
			//去重
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getsLveveBillID().equals(vpo.getsLveveBillID())){
					if (list.get(i).getsLveveGoodsID().equals(vpo.getsLveveGoodsID())){
						continue;
					}
				}
				size++;
		    }
			if (list.size() == size){
				list.add(vpo);
				cAmounts = voucherTallyMgr.getPercentThreeNotTaxRateAmount(vpo);
				LAmounts = voucherTallyMgr.getReversalNotTaxRateAmountByBillID(vpo);
//				cAmount += Float.valueOf(cAmounts.getsNotTaxRateAmount())-Float.valueOf(LAmounts.getsNotTaxRateAmount());
				cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(cAmounts.getsNotTaxRateAmount())));
				cAmount = cAmount.subtract(new BigDecimal(Utility.getNameNum(LAmounts.getsNotTaxRateAmount())));
			}
			size = 0;
	    }	
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName);
			if (po.getsLvtsBalanceDirection().equals("j")){
				po.setsLvtvtDebitMoney(cAmount.toString());
			}
			if (po.getsLvtsBalanceDirection().equals("d")){
				po.setsLvtvtLenderMoney(cAmount.toString());
			}
		}
		
		voucherEntryList.clear();
		voucherEntryList = null;
		list.clear();
		list = null;
		if (count == 0){			
			voucherTallyList.clear();
			voucherTallyList = null;
		}
	}
	
	/**
	 * Description：生成暂估入库、3%暂估入库凭证（采购收退货） 
	 */
	private void createTemporaryInStorageVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}	
		String amount[] = {notTaxRateAmountTotal,taxAmountTotal,costPriceAmountTotal};	
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName);
			if (po.getsLvtsBalanceDirection().equals("j")){
				if (po.getsLvtvtVoucherTypeID().equals("107")){					
					po.setsLvtvtDebitMoney(amount[i]);
				}else{
					po.setsLvtvtDebitMoney("-" + amount[i]);
				}
			}
			if (po.getsLvtsBalanceDirection().equals("d")){			
				if (po.getsLvtvtVoucherTypeID().equals("107")){					
					po.setsLvtvtLenderMoney(amount[i]);
				}else{
					po.setsLvtvtLenderMoney("-" + amount[i]);
				}
			}
		}
		
		voucherEntryList.clear();
		voucherEntryList = null;
		amount = null;
		if (count == 0){			
			voucherTallyList.clear();
			voucherTallyList = null;
		}
	}

	/**
	 * Description：生成暂估冲回凭证（采购收退货） 
	 */
	private void createTemporaryReversalInVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		String[] amount = {notTaxRateAmountTotal,taxAmountTotal,costPriceAmountTotal};
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName+"冲");
			if (po.getsLvtsBalanceDirection().equals("j")){
				po.setsLvtvtDebitMoney(amount[i]);
			}
			if (po.getsLvtsBalanceDirection().equals("d")){
				po.setsLvtvtLenderMoney(amount[i]);
			}
		}
		
		voucherEntryList.clear();
		voucherEntryList = null;
		amount = null;
		if (count == 0){			
			voucherTallyList.clear();
			voucherTallyList = null;
		}
	}
	
	/**
	 * Description：生成普票暂估冲回凭证（采购收退货）
	 */
	private void createTemporaryReversalVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		String[] amount = {notTaxRateAmountTotal,costPriceAmountTotal};
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName+"冲");			
			if (po.getsLvtsBalanceDirection().equals("j")){
				po.setsLvtvtDebitMoney(amount[i]);
			}
			if (po.getsLvtsBalanceDirection().equals("d")){
				po.setsLvtvtLenderMoney(amount[i]);
			}
		}
		
		voucherEntryList.clear();
		voucherEntryList = null;
		if (count == 0){			
			voucherTallyList.clear();
			voucherTallyList = null;
		}
	}
	
	/**
	 * Description：生成3%暂估冲回（采购收退货）
	 */
	private void createPercentThreeTemporaryReversalVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
	
		String[] amount = {notTaxRateAmountTotal,taxAmountTotal,costPriceAmountTotal};
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName+"冲");
			if (po.getsLvtsBalanceDirection().equals("j")){
				po.setsLvtvtDebitMoney(amount[i]);
			}
			if (po.getsLvtsBalanceDirection().equals("d")){
				po.setsLvtvtLenderMoney(amount[i]);
			}
		}
		
		voucherEntryList.clear();
		voucherEntryList = null;
		if (count == 0){			
			voucherTallyList.clear();
			voucherTallyList = null;
		}
	}
	
	/**
	 * Description：生成盘盈（盘盈）凭证 
	 */
	private void createTemporaryProfitVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		DepartmentsPo departmentsPo = voucherTallyMgr.getInwarehouseName(voucherEntryList.get(0)); //调整 （盘盈）
		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本
		List<String> tmpList = new ArrayList<String>();
		String billID = null;

		tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
		for (int j = 1; j < voucherEntryListCount; j++){
			if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
				tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
			}					
		}
		for (int j = 0; j < tmpList.size(); j++){
			billID = (String)tmpList.get(j);
			cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(billID))));
		}
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)poList.get(i);
			if (po.getsLvtvtIsReplace().equals("1")){ //是否允许被替换				
				poList.remove(i);
				
				List<VoucherTallyPo> replaceList = voucherTallyMgr.getReplaceVoucherTempletByID(po.getsLssID());
				Iterator<VoucherTallyPo> rits = replaceList.iterator();
				while (rits.hasNext()){
					VoucherTallyPo replacePo = (VoucherTallyPo)rits.next();
					replacePo.setsLvtsBalanceDirection(po.getsLvtsBalanceDirection());
					replacePo.setsLvtvtResume(Utility.getName(departmentsPo.getBdpdepartmentname())+"盘盈(盘盈)");
					if (po.getsLvtsBalanceDirection().equals("j")){
						replacePo.setsLvtvtDebitMoney(cAmount.toString());
					}
					if (po.getsLvtsBalanceDirection().equals("d")){
						replacePo.setsLvtvtLenderMoney(cAmount.toString());
					}
					poList.add(i,replacePo);
				}				
			}else{
				if (po.getsLvtsBalanceDirection().equals("j")){
					po.setsLvtvtDebitMoney(cAmount.toString());
				}
				if (po.getsLvtsBalanceDirection().equals("d")){
					po.setsLvtvtLenderMoney(cAmount.toString());
				}
			}
		}		
		voucherTallyList = poList;
		
		voucherEntryList.clear();
		tmpList.clear();		
		voucherEntryList = null;
		tmpList = null;
		billID = null;
	}
		
	/**
	 * Description：生成其他入库凭证 
	 */
	private void createTemporaryOtherInStorageVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}

		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本
		BigDecimal dAmount = new BigDecimal(0.00);
		BigDecimal qAmount = new BigDecimal(0.00);
		List<String> tmpList = new ArrayList<String>();
		String billID = null;
       
		//去重
		tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
		for (int j = 1; j < voucherEntryListCount; j++){
			if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
				tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
			}					
		}
		
		for (int j = 0; j < tmpList.size(); j++){
			billID = (String)tmpList.get(j);
			dAmount = dAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getOtherGoodsNotTaxRateAmount(billID,"D"))));//低值易耗
			qAmount = qAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getOtherGoodsNotTaxRateAmount(billID,"Q"))));//其他材料
		}
		cAmount = dAmount.add(qAmount);
		String[] amount = {cAmount.toString(),dAmount.toString(),qAmount.toString()};
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		for (int i = 0; i < count; i++){
			if (!amount[i].equals("0.00")){
				VoucherTallyPo po = (VoucherTallyPo)poList.get(i);
				if (po.getsLvtsBalanceDirection().equals("j")){
					po.setsLvtvtDebitMoney(amount[i]);
				}
				if (po.getsLvtsBalanceDirection().equals("d")){
					po.setsLvtvtLenderMoney(amount[i]);
				}
				voucherTallyList.add(po);
			}
		}
		
		//释放资源
		voucherEntryList.clear();
		tmpList.clear();
		poList.clear();
		voucherEntryList = null;
		tmpList = null;
		billID = null;		
		poList = null;
		cAmount = null;
		dAmount = null;
		qAmount = null;		
	}
	
	/**
	 * Description：生成增值税发票凭证（采购收退货）
	 */
	private void createValueAddedTaxInvoiceVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}		
		
		String[] amount = {notTaxRateAmountTotal,taxAmountTotal,costPriceAmountTotal};
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = voucherTallyList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
			po.setsLvtvtResume(supplierName);
			if (po.getsLvtsBalanceDirection().equals("j")){
				po.setsLvtvtDebitMoney(amount[i]);
			}
			if (po.getsLvtsBalanceDirection().equals("d")){
				po.setsLvtvtLenderMoney(amount[i]);
			}
		}
		
		voucherEntryList.clear();
		voucherEntryList = null;
		amount = null;
	}	
	
	
	/**
	 * Description：生成冲暂估应付入实际凭证（采购收退货）
	 */
	private void createTemporaryReversalRealityVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		BigDecimal tAmount = new BigDecimal(0.00);  //单据体.税额
		BigDecimal cpAmount = new BigDecimal(0.00); //单据体.价税合计	
		List<String> tmpList = new ArrayList<String>();
		String billID = null;
		
		tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
		for (int j = 1; j < voucherEntryListCount; j++){
			if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
				tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
			}					
		}
		for (int j = 0; j < tmpList.size(); j++){
			billID = (String)tmpList.get(j);
			List<InvoiceEntryPo> invoiceEntryList = voucherTallyMgr.getAmounts(billID);
			Iterator<InvoiceEntryPo> invoiceIt = invoiceEntryList.iterator();
			while(invoiceIt.hasNext()){
				InvoiceEntryPo invoiceEntryPo = (InvoiceEntryPo)invoiceIt.next();
				tAmount = tAmount.add(new BigDecimal(Utility.getNameNum(invoiceEntryPo.getLieietaxamount())));
				cpAmount = cpAmount.add(new BigDecimal(Utility.getNameNum(invoiceEntryPo.getLieiecostpriceamount())));
			}
		}
		
//		float[] amount = {tAmount.floatValue(),tAmount.floatValue(),cpAmount.floatValue(),cpAmount.floatValue()};		
		
		voucherTallyList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
//		int count = voucherTallyList.size();
//		for (int i = 0; i < count; i++){
//			VoucherTallyPo po = (VoucherTallyPo)voucherTallyList.get(i);
//			po.setsLvtvtResume(supplierName);
//			if (po.getsLvtsBalanceDirection().equals("j")){
//				po.setsLvtvtDebitMoney(getLegalForm(Float.valueOf(po.getsLvtsHBConstant()) * amount[i]));
//			}
//			if (po.getsLvtsBalanceDirection().equals("d")){
//				po.setsLvtvtLenderMoney(getLegalForm(Float.valueOf(po.getsLvtsHBConstant()) * amount[i]));
//			}
//		}
		
		voucherEntryList.clear();
		tmpList.clear();
		voucherEntryList = null;
		tmpList = null;
		billID = null;
//		amount = null;
	}	
	
	/**
	 * Description：生成调整 （盘盈）
	 */
	private void createInventoryProfitVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		DepartmentsPo departmentsPo = voucherTallyMgr.getInwarehouseName(voucherEntryList.get(0)); //调整 （盘盈）
		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本		
        String typeID = null;
		List<String> tmpList = new ArrayList<String>();
		String billID = null;
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}		
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)poList.get(i);			
						
			List<VoucherTallyPo> replaceList = voucherTallyMgr.getReplaceVoucherTempletByID(po.getsLssID());
			if (!replaceList.isEmpty()){
				Iterator<VoucherTallyPo> rits = replaceList.iterator();
				while (rits.hasNext()){
					VoucherTallyPo replacePo = (VoucherTallyPo)rits.next();
					replacePo.setsLvtsBalanceDirection(po.getsLvtsBalanceDirection());
					replacePo.setsLvtvtResume(Utility.getName(departmentsPo.getBdpdepartmentname()) + "盘盈(调整)");
					
					typeID = voucherTallyMgr.getGoodsCategoryByID(po.getsLssID(), replacePo.getsLssID());
					if (!typeID.equals("")){
//						cAmount = Float.valueOf(voucherTallyMgr.getNotTaxRateAmount(voucherID,typeID));
						cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(voucherID,typeID))));
					}else{
						tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
						for (int j = 1; j < voucherEntryListCount; j++){
							if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
								tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
							}					
						}
						for (int j = 0; j < tmpList.size(); j++){
							billID = (String)tmpList.get(j);		
//							cAmount += Float.valueOf(voucherTallyMgr.getNotTaxRateAmount(billID));
							cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(billID))));
						}
					}					
					if (cAmount.floatValue() != 0f){
						if (po.getsLvtsBalanceDirection().equals("j")){
							replacePo.setsLvtvtDebitMoney(cAmount.toString());
						}
						if (po.getsLvtsBalanceDirection().equals("d")){
							replacePo.setsLvtvtLenderMoney(cAmount.toString());
						}
						voucherTallyList.add(replacePo);
					}
					cAmount = new BigDecimal(0.00);
					tmpList.clear();
				}
			}
			replaceList.clear();
			replaceList = null;
		}		
		voucherEntryList.clear();
		tmpList.clear();
		poList.clear();
		
		voucherEntryList = null;
		tmpList = null;
		poList = null;
		billID = null;
	}
	
	
	/**
	 * Description：盘亏凭证 
	 */
	private void createInventoryLossesVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		DepartmentsPo departmentsPo = voucherTallyMgr.getOutwarehouseName(voucherEntryList.get(0)); //调整 （盘盈）
		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本		
        String typeID = null;
		List<String> tmpList = new ArrayList<String>();
		String billID = null;
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}		
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)poList.get(i);			
						
			List<VoucherTallyPo> replaceList = voucherTallyMgr.getReplaceVoucherTempletByID(po.getsLssID());
			if (!replaceList.isEmpty()){
				Iterator<VoucherTallyPo> rits = replaceList.iterator();
				while (rits.hasNext()){
					VoucherTallyPo replacePo = (VoucherTallyPo)rits.next();
					replacePo.setsLvtsBalanceDirection(po.getsLvtsBalanceDirection());
					replacePo.setsLvtvtResume(Utility.getName(departmentsPo.getBdpdepartmentname()) + "盘亏");
					
					typeID = voucherTallyMgr.getGoodsCategoryByID(po.getsLssID(), replacePo.getsLssID());
					if (!typeID.equals("")){
//						cAmount = Float.valueOf(voucherTallyMgr.getNotTaxRateAmount(voucherID,typeID));
						cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(voucherID,typeID))));
					}else{
						tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
						for (int j = 1; j < voucherEntryListCount; j++){
							if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
								tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
							}					
						}
						for (int j = 0; j < tmpList.size(); j++){
							billID = (String)tmpList.get(j);		
//							cAmount += Float.valueOf(voucherTallyMgr.getNotTaxRateAmount(billID));
							cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(billID))));
						}
					}					
					if (cAmount.floatValue() != 0f){
						if (po.getsLvtsBalanceDirection().equals("j")){
							replacePo.setsLvtvtDebitMoney(cAmount.toString());
						}
						if (po.getsLvtsBalanceDirection().equals("d")){
							replacePo.setsLvtvtLenderMoney(cAmount.toString());
						}
						voucherTallyList.add(replacePo);
					}
					cAmount = new BigDecimal(0.00);
					tmpList.clear();
				}
			}
			replaceList.clear();
			replaceList = null;
		}		
		voucherEntryList.clear();
		tmpList.clear();
		poList.clear();
		
		voucherEntryList = null;
		tmpList = null;
		poList = null;
		billID = null;
	}
	
	/**
	 * Description：生成其他出库 
	 */
	private void createOtherOutStorageVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		DepartmentsPo departmentsPo = voucherTallyMgr.getShopCode(voucherEntryList.get(0));
		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本
        String typeID = null;
		List<String> tmpList = new ArrayList<String>();
		String billID = null;
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}		
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)poList.get(i);
						
			List<VoucherTallyPo> replaceList = voucherTallyMgr.getReplaceVoucherTempletByID(po.getsLssID());
			if (!replaceList.isEmpty()){
				Iterator<VoucherTallyPo> rits = replaceList.iterator();
				while (rits.hasNext()){
					VoucherTallyPo replacePo = (VoucherTallyPo)rits.next();
					replacePo.setsLvtsBalanceDirection(po.getsLvtsBalanceDirection());
					replacePo.setsLvtvtResume(Utility.getName(departmentsPo.getBdpdepartmentname())+"领用");
					
					typeID = voucherTallyMgr.getGoodsCategoryByID(po.getsLssID(), replacePo.getsLssID());
					if (!typeID.equals("")){
						cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(voucherID,typeID))));
					}else{
						tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
						for (int j = 1; j < voucherEntryListCount; j++){
							if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
								tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
							}					
						}
						for (int j = 0; j < tmpList.size(); j++){
							billID = (String)tmpList.get(j);
							cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(billID))));
						}
					}					
					if (cAmount.floatValue() != 0f){
						if (po.getsLvtsBalanceDirection().equals("j")){
							replacePo.setsLvtvtDebitMoney(cAmount.toString());
						}
						if (po.getsLvtsBalanceDirection().equals("d")){
							replacePo.setsLvtvtLenderMoney(cAmount.toString());
						}
						voucherTallyList.add(replacePo);
					}
					cAmount = new BigDecimal(0.00);
					tmpList.clear();
				}
			}
			replaceList.clear();
			replaceList = null;
		}		
		voucherEntryList.clear();
		tmpList.clear();
		poList.clear();
		
		voucherEntryList = null;
		tmpList = null;
		poList = null;
		billID = null;
	}
	
	/**
	 * Description：生成销售成本（销售出库）
	 */
	private void createSalesNotTaxRateVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		DepartmentsPo departmentsPo = voucherTallyMgr.getShopCode(voucherEntryList.get(0));
		BigDecimal cAmount = new BigDecimal(0.00); //单据体.成本	
        String typeID = null;
		List<String> tmpList = new ArrayList<String>();
		String billID = null;
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		for (int i = 0; i < count; i++){
			VoucherTallyPo po = (VoucherTallyPo)poList.get(i);			
						
			List<VoucherTallyPo> replaceList = voucherTallyMgr.getReplaceVoucherTempletByID(po.getsLssID());
			if (!replaceList.isEmpty()){
				Iterator<VoucherTallyPo> rits = replaceList.iterator();
				while (rits.hasNext()){
					VoucherTallyPo replacePo = (VoucherTallyPo)rits.next();
					replacePo.setsLvtsBalanceDirection(po.getsLvtsBalanceDirection());
					replacePo.setsLvtvtResume("结转成本-" + Utility.getName(departmentsPo.getBdpdepartmentname()));
					
					typeID = voucherTallyMgr.getGoodsCategoryByID(po.getsLssID(), replacePo.getsLssID());
					if (!typeID.equals("")){
						cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(voucherID,typeID))));
					}else{
						tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
						for (int j = 1; j < voucherEntryListCount; j++){
							if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
								tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
							}					
						}
						for (int j = 0; j < tmpList.size(); j++){
							billID = (String)tmpList.get(j);
							cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getNotTaxRateAmount(billID))));
						}
					}					
					if (cAmount.floatValue() != 0f){
						if (po.getsLvtsBalanceDirection().equals("j")){
							replacePo.setsLvtvtDebitMoney(cAmount.toString());
						}
						if (po.getsLvtsBalanceDirection().equals("d")){
							replacePo.setsLvtvtLenderMoney(cAmount.toString());
						}
						voucherTallyList.add(replacePo);
					}
					cAmount = new BigDecimal(0.00);
					tmpList.clear();
				}
			}
			replaceList.clear();
			replaceList = null;
		}		
		voucherEntryList.clear();
		tmpList.clear();
		poList.clear();
		
		voucherEntryList = null;
		tmpList = null;
		poList = null;
		billID = null;
	}
	
	/**
	 * Description：生成销售收入凭证（销售出库）
	 */
	private void createSalesRevenueVoucher(String voucherID,String supplierName,String voucherTypeID){
		List<VoucherEntryPo> voucherEntryList = getVoucherEntryList(voucherID);
		int voucherEntryListCount = voucherEntryList.size();
		if (voucherEntryListCount == 0){
			voucherEntryList = null;
			return;
		}
		
		DepartmentsPo departmentsPo = voucherTallyMgr.getShopCode(voucherEntryList.get(0));		
		BigDecimal cAmount = new BigDecimal(0.00);
		String typeID = null;
		String billID = null;
        List<String> tmpList = new ArrayList<String>();
        List<VoucherTallyPo> replaceList = null;
        
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}
		
		List<VoucherTallyPo> poList = voucherTallyMgr.getVoucherTempletByID(voucherTypeID);
		int count = poList.size();
		VoucherTallyPo po = null;
		for (int i = 0; i < count; i++){
			po = (VoucherTallyPo)poList.get(i);			
			if (po.getsLvtvtIsReplace().equals("1")){ //是否允许被替换
				replaceList = voucherTallyMgr.getReplaceVoucherTempletByID(po.getsLssID());
				Iterator<VoucherTallyPo> rits = replaceList.iterator();
				while (rits.hasNext()){
					VoucherTallyPo replacePo = (VoucherTallyPo)rits.next();
					replacePo.setsLvtsBalanceDirection(po.getsLvtsBalanceDirection());
					typeID = voucherTallyMgr.getGoodsCategoryByID(po.getsLssID(), replacePo.getsLssID());
					replacePo.setsLvtvtResume(Utility.getName(departmentsPo.getBdpdepartmentname())+(typeID.equals("10") ? "附加费" : "收入"));					
					
					if (typeID.startsWith("p")){
						if (typeID.substring(1, typeID.length()).equalsIgnoreCase(departmentsPo.getBdpdepartmentid())){
							for (int j = 0; j < voucherEntryListCount; j++){
								VoucherEntryPo voucherEntryPo = (VoucherEntryPo)voucherEntryList.get(j);						
								if (!tmpList.contains(voucherEntryPo.getsLveveBillID())){
									tmpList.add(voucherEntryPo.getsLveveBillID());
								}						
							}			
							for (int j = 0; j < tmpList.size(); j++){
								billID = (String)tmpList.get(j);
								cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getSalesValueByID(billID))));
							}
							
							if (cAmount.floatValue() != 0f){
								if (po.getsLvtsBalanceDirection().equals("j")){
//									replacePo.setsLvtvtDebitMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant())));
								}
								if (po.getsLvtsBalanceDirection().equals("d")){
//									replacePo.setsLvtvtLenderMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant())));
								}
								voucherTallyList.add(replacePo);
							}
							cAmount = new BigDecimal(0.00);
							continue;
						}
					}else{
						for (int j = 0; j < voucherEntryListCount; j++){
							VoucherEntryPo voucherEntryPo = (VoucherEntryPo)voucherEntryList.get(j);						
							if (typeID.equals("10") || typeID.equalsIgnoreCase(voucherEntryPo.getsLveveGoodsID().substring(0,1))){  // 10 表示附加费
								if (!tmpList.contains(voucherEntryPo.getsLveveBillID())){
									tmpList.add(voucherEntryPo.getsLveveBillID());
								}							
							}						
						}			
						for (int j = 0; j < tmpList.size(); j++){
							billID = (String)tmpList.get(j);
							cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getSalesValueByID(billID,typeID))));
						}
						if (cAmount.floatValue() != 0f){
							if (po.getsLvtsBalanceDirection().equals("j")){
//								replacePo.setsLvtvtDebitMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant())));
							}
							if (po.getsLvtsBalanceDirection().equals("d")){
								//replacePo.setsLvtvtLenderMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant())));
								replacePo.setsLvtvtLenderMoney(cAmount.toString());
							}
							voucherTallyList.add(replacePo);
						}
					}
					cAmount = new BigDecimal(0.00);
					tmpList.clear();
				}
				replaceList = null;
			}else{				
				po.setsLvtvtResume(Utility.getName(departmentsPo.getBdpdepartmentname())+"收入");
				tmpList.add(((VoucherEntryPo)voucherEntryList.get(0)).getsLveveBillID());
				for (int j = 1; j < voucherEntryListCount; j++){
					if (!tmpList.contains(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID())){
						tmpList.add(((VoucherEntryPo)voucherEntryList.get(j)).getsLveveBillID());
					}					
				}
				for (int j = 0; j < tmpList.size(); j++){
					billID = (String)tmpList.get(j);
					cAmount = cAmount.add(new BigDecimal(Utility.getNameNum(voucherTallyMgr.getSalesValueByID(billID))));
				}
				
				if (po.getsLvtsBalanceDirection().equals("j")){
//					po.setsLvtvtDebitMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant())));
					po.setsLvtvtDebitMoney(cAmount.toString());
				}
				if (po.getsLvtsBalanceDirection().equals("d")){
//					int index = po.getsLvtsHBConstant().indexOf("*");
//					if (index > 0){						
//						po.setsLvtvtLenderMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant().substring(0,index)) * Float.valueOf(po.getsLvtsHBConstant().substring(index + 1,po.getsLvtsHBConstant().length()))));
//					}else{
//						po.setsLvtvtLenderMoney(getLegalForm(cAmount.floatValue() / Float.valueOf(po.getsLvtsHBConstant())));
//					}
				}
				voucherTallyList.add(po);
				cAmount = new BigDecimal(0.00);
			}			
			billID = null;				
			tmpList.clear();
		}
		voucherEntryList.clear();
		poList.clear();
		voucherEntryList = null;
		poList = null;		
		tmpList = null;
	}
	
	/**
	 * Description：生成付款单凭证 
	 */
	private void createPayMentBillVoucher(String voucherID,String supplierName,String voucherTypeID){
		
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}
		
		supplierName = "付货款-" + supplierName;
		if (supplierName.length()>30){
			supplierName = supplierName.substring(0,29);
		}
		
		VoucherPo vpo = new VoucherPo();
		vpo.setsLvvID(voucherID);
		vpo.setsLvvVoucherTypeID(voucherTypeID);
		
		voucherTallyList = voucherTallyMgr.getVoucherTallyByID(vpo, supplierName);
		
		for (int j = 0; j < voucherTallyList.size(); j++){
			if (((VoucherTallyPo)voucherTallyList.get(j)).getsLvtsBalanceDirection().equalsIgnoreCase("j")){
				((VoucherTallyPo)voucherTallyList.get(j)).setsLvtvtDebitMoney(((VoucherTallyPo)voucherTallyList.get(j)).getsLvtvtMoney());
			}else{
				((VoucherTallyPo)voucherTallyList.get(j)).setsLvtvtLenderMoney(((VoucherTallyPo)voucherTallyList.get(j)).getsLvtvtMoney());
			}
		}
		
	}
	
	/**
	 * Description：生成收款单凭证 
	 */
	private void createReceiptMentBillVoucher(String voucherID,String supplierName,String voucherTypeID){
		
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}
		
		supplierName = "收货款-" + supplierName;
		if (supplierName.length()>30){
			supplierName = supplierName.substring(0,29);
		}
		
		VoucherPo vpo = new VoucherPo();
		vpo.setsLvvID(voucherID);
		vpo.setsLvvVoucherTypeID(voucherTypeID);
		
		voucherTallyList = voucherTallyMgr.getVoucherTallyByID(vpo, supplierName);
		
		for (int j = 0; j < voucherTallyList.size(); j++){
			if (((VoucherTallyPo)voucherTallyList.get(j)).getsLvtsBalanceDirection().equalsIgnoreCase("j")){
				((VoucherTallyPo)voucherTallyList.get(j)).setsLvtvtDebitMoney(((VoucherTallyPo)voucherTallyList.get(j)).getsLvtvtMoney());
			}else{
				((VoucherTallyPo)voucherTallyList.get(j)).setsLvtvtLenderMoney(((VoucherTallyPo)voucherTallyList.get(j)).getsLvtvtMoney());
			}
		}
		
	}
	
	/**
	 * Description：根据凭证号查询凭证明细
	 */
	private List<VoucherEntryPo> getVoucherEntryList(String voucherID){
		VoucherEntryPo po = new VoucherEntryPo();
		po.setsLveveVoucherID(voucherID);		
		return voucherTallyMgr.getBillsAndGoods(po);
	}
	
	/**
	 * Description：将数字四舍五入后转换成字符串格式
	 */
//	private String getLegalForm(float number){		
//		float floor = number * 1000 - (int)Math.floor(number) * 1000;		
//		if (floor >= 5 && floor < 10){
//			number += 0.01;
//		}
//		df = new DecimalFormat("0.00");
//		return df.format(number);
//	}	
	
	/**
	 * Description：初始化科目选择
	 */
	public String selSubjectOpen(){
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
	 * Description：查询科目
	 */
	public String selSubject(){
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
		
		String subjectID = Utility.getName(request.getParameter("subjectID"));
		String subjectName = Utility.getName(request.getParameter("subjectName"));
		String subjectOpenTree = Utility.getName(request.getParameter("subjectOpenTree"));
		
		SubjectPo po = new SubjectPo();
		po.setsLssSubjectID(subjectID);
		po.setsLssSubjectName(subjectName);		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		int count = voucherTallyMgr.getSubjectCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			subjectList = voucherTallyMgr.getSubjectList(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			subjectList = null;
		}

		request.setAttribute("subjectID",subjectID);
		request.setAttribute("subjectName",subjectName);
		request.setAttribute("subjectOpenTree",subjectOpenTree);
		
		po = voucherTallyMgr.getSubjectDetail(po);
		request.setAttribute("spo",po);
		
		return SUCCESS;
	}
	
	public VoucherTallyTempPo getVoucherTallyTempPo() {
		return voucherTallyTempPo;
	}
	public void setVoucherTallyTempPo(VoucherTallyTempPo voucherTallyTempPo) {
		this.voucherTallyTempPo = voucherTallyTempPo;
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
	public VoucherPo getPo() {
		return po;
	}
	public void setPo(VoucherPo po) {
		this.po = po;
	}
	public VoucherTallyMgr getVoucherTallyMgr() {
		return voucherTallyMgr;
	}
	public void setVoucherTallyMgr(VoucherTallyMgr voucherTallyMgr) {
		this.voucherTallyMgr = voucherTallyMgr;
	}
	public List<VoucherTallyPo> getVoucherTallyList() {
		return voucherTallyList;
	}
	public void setVoucherTallyList(List<VoucherTallyPo> voucherTallyList) {
		this.voucherTallyList = voucherTallyList;
	}
	public DecimalFormat getDf() {
		return df;
	}
	public void setDf(DecimalFormat df) {
		this.df = df;
	}
	public List<SubjectPo> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<SubjectPo> subjectList) {
		this.subjectList = subjectList;
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
