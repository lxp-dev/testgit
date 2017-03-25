package com.pengsheng.eims.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class SystemParameterDaoImpl extends BaseJdbcDaoSupport implements SystemParameterDao {
	
	/**
	 * 得到DB系统时间；
	 * @param po
	 */
	public String getDBSystemData(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select convert(varchar(10),getdate(),120)");
		return (String) getJdbcTemplate().queryForObject(buffer.toString(),null,String.class);
	}
	
	/**
	 * 新增系统参数信息
	 * @param po
	 */
	public void insertSystemParameter(SystemParameterPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO F_SystemParameter ");
		buffer.append("            (F_SP_UUID, ");
		buffer.append("             F_SP_BarcodeType, ");
		buffer.append("             F_SP_Retained, ");
		buffer.append("             F_SP_Remove, ");
		buffer.append("             F_SP_RemoveNumber, ");
		buffer.append("             F_SP_AllDiscount, ");
		buffer.append("             F_SP_SalesType, ");
		buffer.append("             F_SP_ShowChange, ");
		buffer.append("             F_SP_ShortMessage, ");
		buffer.append("             F_SP_ShortMessageName, ");
		buffer.append("             F_SP_ShortMessagePw, ");		
		buffer.append("             F_SP_AutoUpgradeIsSub, ");
		buffer.append("             F_SP_ShopToShop, ");
		buffer.append("             F_SP_SelectOverShowChange, ");
		buffer.append("             F_SP_CustomerAddress, ");
		buffer.append("             F_SP_PageNo, ");
		buffer.append("             F_SP_StealthEffective, ");
		buffer.append("             F_SP_CollectType, ");
		buffer.append("             F_SP_IsCountPerfrom, ");
		buffer.append("             F_SP_UpdateCheck, ");
		buffer.append("             F_SP_ShareStockMessage, ");
		buffer.append("             F_SP_EffectiveAlert, ");
		buffer.append("             F_SP_FrameBarcodeType, ");
		buffer.append("             F_SP_GlassBarcodeType, ");
		buffer.append("             F_SP_Birthday, ");
		buffer.append("             F_SP_BirthdayCallDay, ");
		buffer.append("             F_SP_BirthdayCallHour, ");
		buffer.append("             F_SP_RTX, ");
		buffer.append("             F_SP_ServerIP, ");
		buffer.append("             F_SP_EimsIP, ");
		buffer.append("             F_SP_ExchangeIntegral, ");
		buffer.append("             F_SP_AllocationAtuoTime, ");
		buffer.append("             F_SP_SelectStockType, ");
		buffer.append("             F_SP_FirstCheckType, ");
		buffer.append("             F_SP_DefaultDiscountType,F_SP_ReportHelpShow,F_SP_ReportBgnDate,F_SP_ReportEndDate,F_SP_ReportDateFlag,F_SP_ReportDateMonth,F_SP_ReportLastMonth,F_SP_LogonForm,F_SP_ExecStandard,F_SP_SalesIntransit, ");
		buffer.append("             F_SP_IsShowSupplierAndBrand, ");
		buffer.append("             F_SP_SalesCountType, ");
		buffer.append("             F_SP_IsCheckMAC, ");
		buffer.append("             F_SP_RetailPrice, ");
		buffer.append("             F_SP_RetailPriceA, ");
		buffer.append("             F_SP_RetailPriceB, ");
		buffer.append("             F_SP_RetailPriceC, ");
		buffer.append("             F_SP_RetailPriceD, ");
		buffer.append("             F_SP_RetailPriceE, ");
		buffer.append("             F_SP_RetailPriceF, ");
		buffer.append("             F_SP_RetailPriceG, ");
		buffer.append("             F_SP_RetailPriceH, ");
		buffer.append("             F_SP_RetailPriceI, ");
		buffer.append("             F_SP_InvoiceType, ");
		buffer.append("             F_SP_PaymentType, ");
		buffer.append("             F_SP_UpdateInspection, ");
		buffer.append("             F_SP_OldglassSalestype, ");
		buffer.append("             F_SP_UpdateGuitartype, ");
		buffer.append("             F_SP_WhichMachine, ");
		buffer.append("             F_SP_CheckAccessories, ");
		buffer.append("      		F_SP_PartsBarcodeType, ");  
		buffer.append("       		F_SP_StealthBarcodeType, ");  
		buffer.append("       		F_SP_SolutionBarcodeType, ");  
		buffer.append("       		F_SP_SunglassesBarcodeType, ");  
		buffer.append("       		F_SP_ConsumeBarcodeType, ");  
		buffer.append("       		F_SP_OldglassesBarcodeType, ");  
		buffer.append("       		F_SP_MetropiaBarcodeType, ");
		buffer.append("       		F_SP_DiscountBarcodeType, ");
		buffer.append("       		F_SP_BrandBarcodeType, ");
		buffer.append("       		F_SP_JQBarcodeType, ");
		buffer.append("       		F_SP_StockQueryConditions, ");
		buffer.append("       		F_SP_JQBarcodeType,F_SP_StockQueryConditions,F_SP_ShowSupplier,F_SP_ShowRptCondition, ");
		buffer.append("       		F_SP_CJJ, ");
		buffer.append("       		F_SP_CPJ, ");
		buffer.append("       		F_SP_CJP, ");
		buffer.append("       		F_SP_CYXJP, ");
		buffer.append("       		F_SP_CHLY, ");
		buffer.append("       		F_SP_CTYJ, ");
		buffer.append("       		F_SP_CHC, ");
		buffer.append("       		F_SP_CLH, ");
		buffer.append("       		F_SP_CSG,F_SP_PjBillSetUp,F_SP_PjBillSetUpTime, ");

		buffer.append("       		F_SP_CSG,F_SP_ShowCustomerTable,F_SP_Negative,F_SP_InspectionVisuelle,F_SP_OtherNegative,F_SP_WholesalePriceSet,F_SP_PrintStealthCheck,F_SP_InTransitstorageflag,F_SP_OutMaterialsFlag,F_SP_MemberCardLen, ");
		buffer.append("       		F_SP_GlassisCheckNumber, ");
		buffer.append("       		F_SP_Identitycard,F_SP_CustomAmount, ");
		buffer.append("       		F_SP_IsAllocationCategory, ");
		buffer.append("       		F_SP_IsFillInDeliveryID, ");
		buffer.append("       		F_SP_UpdateCreditType,F_SP_RefundComplainFlag,F_SP_ComplainBandBillFlag,F_SP_ShowDwAndTable,F_SP_ShopDistributionRefund,F_SP_AutoSpectaclesMaterials,F_SP_ZZAutoSpectaclesMaterials,F_SP_SalerDefaultSet, ");
		buffer.append("       		F_SP_HisFlag,F_SP_AccountPeriod, ");
		buffer.append("       		F_SP_MinIntegral, ");		
		buffer.append("       		F_SP_AccessorySalesType, ");
		buffer.append("       		F_SP_QueryGoodsStorage, ");
        buffer.append("       		F_SP_DefGetGlassesTime,F_SP_GlassesSalesCustom,F_SP_CheckstorageFlag,F_SP_DefaultRecipeType,F_SP_PrintHistoryFlag, ");				
		buffer.append("       		F_SP_Address_Type, ");
		buffer.append("       		F_SP_Area1, ");
		buffer.append("       		F_SP_Area2, ");
		buffer.append("       		F_SP_Area3, ");
		buffer.append("       		F_SP_Area4, ");
		buffer.append("       		F_SP_Area5, ");
		buffer.append("       		F_SP_Djsbm, ");
		buffer.append("       		F_SP_SupplierInsertXzd,F_SP_DefaultMemberID,F_SP_PrintSalesbillAtBuKuanFlag,F_SP_ProcessDifficulty,F_SP_NongAllocation,F_SP_KqSystem,F_SP_IsShowDiscount3detail,F_SP_IPUrl,F_SP_YxpsFlag,F_SP_PrintbzdFlag,F_SP_AutoAllocationFlag,F_SP_SplitSalesDataFlag,F_SP_IsAllocationSupplier,F_SP_XianjinDefault,  ");		
		buffer.append("       		F_SP_OptometryDetailsType, ");
		buffer.append(" ) VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ");
		buffer.append("              ?,?,?,?,?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
        buffer.append("              ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		buffer.append("              ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getFspbarcodetype()));
		params.add(Utility.getName(po.getFspretained()));
		params.add(Utility.getName(po.getFspremove()));
		params.add(Utility.getName(po.getFspremovenumber()));
		params.add(Utility.getName(po.getFspalldiscount()));
		params.add(Utility.getName(po.getFspsalestype()));
		params.add(Utility.getName(po.getFspshowchange()));
		params.add(Utility.getName(po.getFspshortmessage()));
		params.add(Utility.getName(po.getFspshortmessagename()));
		params.add(Utility.getName(po.getFspshortmessagepw()));
		params.add(Utility.getName(po.getFspautoupgradeissub()));
		params.add(Utility.getName(po.getFspshoptoshop()));
		params.add(Utility.getName(po.getFspselectovershowchange()));
		params.add(Utility.getName(po.getFspcustomeraddress()));
		params.add(Utility.getName(po.getFsppageno()));
		params.add(Utility.getName(po.getFspstealtheffective()));
		params.add(Utility.getName(po.getFspcollecttype()));
		params.add(Utility.getName(po.getFspiscountperfrom()));
		params.add(Utility.getName(po.getFspupdatecheck()));
		params.add(Utility.getName(po.getFspsharestockmessage()));
		params.add(Utility.getName(po.getFspeffectivealert()));
		if(!"3".equals(Utility.getName(po.getFspbarcodetype()))){
			params.add(Utility.getName(po.getFspframebarcodetype()));
			params.add(Utility.getName(po.getFspglassbarcodetype()));
		}else{
			params.add("");
			params.add("");
		}
		params.add(Utility.getName(po.getFspbirthday()));
		params.add(Utility.getName(po.getFspbirthdaycallday()));
		params.add(Utility.getName(po.getFspbirthdaycallhour()));
		params.add(Utility.getName(po.getFsprtx()));
		params.add(Utility.getName(po.getFspserverip()));
		params.add(Utility.getName(po.getFspeimsip()));
		params.add(Utility.getName(po.getFspexchangeintegral()));
		params.add(Utility.getName(po.getFspallocationatuotime()));
		params.add(Utility.getName(po.getFspselectstocktype()));
		params.add(Utility.getName(po.getFspfirstchecktype()));
		params.add(Utility.getName(po.getFspdefaultdiscounttype()));		
		params.add(Utility.getName(po.getFspreporthelpshow()));
		params.add(Utility.getName(po.getFspreportbgndate()));
		params.add(Utility.getName(po.getFspreportenddate()));
		params.add(Utility.getName(po.getFspreportdateflag()));
		params.add(Utility.getName(po.getFspreportMonth()));
		params.add(Utility.getName(po.getFspreportLastMonth()));
		params.add(Utility.getName(po.getFsplogonform()));
		params.add(Utility.getName(po.getFspexecstandard()));
		params.add(Utility.getName(po.getFspsalesintransit()));
		params.add(Utility.getName(po.getFspisshowsupplierandbrand()));
		params.add(Utility.getName(po.getFspsalescounttype()));
		params.add(Utility.getName(po.getFspischeckmac()));
		params.add(Utility.getName(po.getFspretailprice()));
		params.add(Utility.getName(po.getFspretailpricea()));
		params.add(Utility.getName(po.getFspretailpriceb()));
		params.add(Utility.getName(po.getFspretailpricec()));
		params.add(Utility.getName(po.getFspretailpriced()));
		params.add(Utility.getName(po.getFspretailpricee()));
		params.add(Utility.getName(po.getFspretailpricef()));
		params.add(Utility.getName(po.getFspretailpriceg()));
		params.add(Utility.getName(po.getFspretailpriceh()));
		params.add(Utility.getName(po.getFspretailpricei()));		
		params.add(Utility.getName(po.getFspinvoicetype()));
		params.add(Utility.getName(po.getFsppaymenttype()));
		params.add(Utility.getName(po.getFspupdateinspection()));
		params.add(Utility.getName(po.getFspoldglasssalestype()));
		params.add(Utility.getName(po.getFspupdateguitartype()));
		params.add(Utility.getName(po.getFspwhichmachine()));
		params.add(Utility.getName(po.getFspcheckaccessories()));		
		params.add(Utility.getName(po.getFsppartsbarcodetype()));
		params.add(Utility.getName(po.getFspstealthbarcodetype()));
		params.add(Utility.getName(po.getFspsolutionbarcodetype()));
		params.add(Utility.getName(po.getFspsunglassesbarcodetype()));
		params.add(Utility.getName(po.getFspconsumebarcodetype()));
		params.add(Utility.getName(po.getFspoldglassesbarcodetype()));
		params.add(Utility.getName(po.getFspmetropiabarcodetype()));
		params.add(Utility.getName(po.getFspdiscountbarcodetype()));
		params.add(Utility.getName(po.getFspbrandbarcodetype()));
		params.add(Utility.getName(po.getFspjqbarcodetype()));
		params.add(Utility.getName(po.getFspstockqueryconditions()));
		params.add(Utility.getName(po.getFspcjj()));
		params.add(Utility.getName(po.getFspcpj()));
		params.add(Utility.getName(po.getFspcjp()));
		params.add(Utility.getName(po.getFspcyxjp()));
		params.add(Utility.getName(po.getFspchly()));
		params.add(Utility.getName(po.getFspctyj()));
		params.add(Utility.getName(po.getFspchc()));
		params.add(Utility.getName(po.getFspclh()));
		params.add(Utility.getName(po.getFspcsg()));
		params.add(Utility.getName(po.getFspshowsupplier()));
		params.add(Utility.getName(po.getFspshowrptcondition()));
		params.add(Utility.getName(po.getFsppjbillsetup()));
		params.add(Utility.getName(po.getFsppjbillsetuptime()));
		params.add(Utility.getName(po.getFspsalesstealthother()));
		params.add(Utility.getName(po.getFspshowcustomertable()));
		params.add(Utility.getName(po.getFspnegative()));
		params.add(Utility.getName(po.getFspinspectionvisuelle()));		
		params.add(Utility.getName(po.getFspothernegative()));
		params.add(Utility.getName(po.getFspwholesalepriceset()));
		params.add(Utility.getName(po.getFspprintstealthcheck()));
		params.add(Utility.getName(po.getFspintransitstorageflag()));
		params.add(Utility.getName(po.getFspoutmaterialsflag()));
		params.add(Utility.getName(po.getFspcustomercardlen()));
		params.add(Utility.getName(po.getFspglassischecknumber()));
		params.add(Utility.getName(po.getFspidentitycard()));
		params.add(Utility.getName(po.getFspcustomamount()));
		params.add(Utility.getName(po.getFspisallocationcategory()));
		params.add(Utility.getName(po.getFspisfillindeliveryid()));
		params.add(Utility.getName(po.getFspupdatecredittype()));
		params.add(Utility.getName(po.getFsprefundcomplainflag()));
		params.add(Utility.getName(po.getFspcomplainbandbill()));
		params.add(Utility.getName(po.getFspshowdwandtable()));
		params.add(Utility.getName(po.getFspshopdistributionrefund()));	
		params.add(Utility.getName(po.getFspautospectaclesmaterials()));
		params.add(Utility.getName(po.getFspzzautospectaclesmaterials()));
		params.add(Utility.getName(po.getFspsalerdefaultset()));
		params.add(Utility.getName(po.getFsphisflag()));
		params.add(Utility.getName(po.getFspaccountperiod()));
		params.add(Utility.getName(po.getFspminintegral()));		
		params.add(Utility.getName(po.getFspaccessorysalestype()));
		params.add(Utility.getName(po.getFspquerygoodsstorage()));
		params.add(Utility.getName(po.getFspdefgetglassestime()));
		params.add(Utility.getName(po.getFspglassessalescustom()));
		params.add(Utility.getName(po.getFspcheckstorageflag()));
		params.add(Utility.getName(po.getFspdefaultrecipetype()));
		params.add(Utility.getName(po.getFspprintmedicalhistory()));		
		params.add(Utility.getName(po.getFspaddresstype()));
		params.add(Utility.getName(po.getFsparea1()));
		params.add(Utility.getName(po.getFsparea2()));
		params.add(Utility.getName(po.getFsparea3()));
		params.add(Utility.getName(po.getFsparea4()));
		params.add(Utility.getName(po.getFsparea5()));
		params.add(Utility.getName(po.getFsparea5()));
		params.add(Utility.getName(po.getFspdjsbm()));
		params.add(Utility.getName(po.getFspdefaultmemberid()));
		params.add(Utility.getName(po.getFspprintsalesbillatbukuanflag()));		
		params.add(Utility.getName(po.getFspprocessdifficulty()));
		params.add(Utility.getName(po.getFspnongallocation()));
		params.add(Utility.getName(po.getFspkqsystem()));
		params.add(Utility.getName(po.getFspisshowdiscount3detail()));		
		params.add(Utility.getName(po.getFspipurl()));
		params.add(Utility.getName(po.getFspyxpsflag()));
		params.add(Utility.getName(po.getFspprintbzdflag()));
		params.add(Utility.getName(po.getFspautoallocationflag()));
		params.add(Utility.getName(po.getFspsplitsalesdataflag()));
		params.add(Utility.getName(po.getFspisallocationsupplier()));
		params.add(Utility.getName(po.getFspxianjindefault()));
		params.add(Utility.getName(po.getFspoptometrydetailstype()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新系统参数信息
	 * @param po
	 */
	public void updateSystemParameter(SystemParameterPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE F_SystemParameter ");
		buffer.append("SET    F_SP_BarcodeType = ?, ");
		buffer.append("       F_SP_Retained = ?, ");
		buffer.append("       F_SP_Remove = ?, ");
		buffer.append("       F_SP_RemoveNumber = ?, ");
		buffer.append("       F_SP_AllDiscount = ?, ");
		buffer.append("       F_SP_SalesType = ?, ");
		buffer.append("       F_SP_ShowChange = ?, ");
		buffer.append("       F_SP_ShortMessage = ?, ");
		buffer.append("       F_SP_ShortMessageName = ?, ");
		buffer.append("       F_SP_ShortMessagePw = ?, ");		
		buffer.append("       F_SP_AutoUpgradeIsSub = ?, ");
		buffer.append("       F_SP_ShopToShop = ?, ");
		buffer.append("       F_SP_SelectOverShowChange = ?, ");
		buffer.append("       F_SP_CustomerAddress = ?, ");
		buffer.append("       F_SP_PageNo = ?, ");
		buffer.append("       F_SP_StealthEffective = ?, ");
		buffer.append("       F_SP_CollectType = ?, ");
		buffer.append("       F_SP_IsCountPerfrom = ?, ");
		buffer.append("       F_SP_UpdateCheck = ?, ");
		buffer.append("       F_SP_ShareStockMessage = ?, ");
		buffer.append("       F_SP_EffectiveAlert = ?, ");
		buffer.append("       F_SP_FrameBarcodeType = ?, ");
		buffer.append("       F_SP_GlassBarcodeType = ?, ");
		buffer.append("       F_SP_Birthday = ?, ");
		buffer.append("       F_SP_BirthdayCallDay = ?, ");
		buffer.append("       F_SP_BirthdayCallHour = ?, ");
		buffer.append("       F_SP_RTX = ?, ");
		buffer.append("       F_SP_ServerIP = ?, ");
		buffer.append("       F_SP_EimsIP = ?, ");
		buffer.append("       F_SP_ExchangeIntegral=?, ");
		buffer.append("       F_SP_AllocationAtuoTime = ?, ");
		buffer.append("       F_SP_SelectStockType = ?, ");
		buffer.append("       F_SP_FirstCheckType = ?, ");
		buffer.append("       F_SP_DefaultDiscountType = ?,F_SP_ReportHelpShow=?,F_SP_ReportBgnDate=?,F_SP_ReportEndDate=?,F_SP_ReportDateFlag=?,F_SP_ReportDateMonth=?,F_SP_ReportLastMonth=?,F_SP_LogonForm=?, ");
		buffer.append("       F_SP_ExecStandard = ?, ");
		buffer.append("       F_SP_SalesIntransit = ?, ");
		buffer.append("       F_SP_IsShowSupplierAndBrand = ?, ");
		buffer.append("       F_SP_SalesCountType = ?, ");
        buffer.append("       F_SP_InvoiceType=?, ");
        buffer.append("       F_SP_PaymentType=?, ");
        buffer.append("       F_SP_ShowSupplier=?, ");
        buffer.append("       F_SP_PjBillSetUp=?, ");
        buffer.append("       F_SP_PjBillSetUpTime=?, ");
        buffer.append("       F_SP_ShowCustomerTable=?, ");
        buffer.append("       F_SP_Negative=?, ");
        buffer.append("       F_SP_InspectionVisuelle=?, ");
        buffer.append("       F_SP_OtherNegative=?, ");
        buffer.append("       F_SP_InTransitstorageflag=?, ");
        buffer.append("       F_SP_OutMaterialsFlag=?, ");
		params.add(Utility.getName(po.getFspbarcodetype()));
		params.add(Utility.getName(po.getFspretained()));
		params.add(Utility.getName(po.getFspremove()));
		params.add(Utility.getName(po.getFspremovenumber()));
		params.add(Utility.getName(po.getFspalldiscount()));
		params.add(Utility.getName(po.getFspsalestype()));
		params.add(Utility.getName(po.getFspshowchange()));
		params.add(Utility.getName(po.getFspshortmessage()));
		params.add(Utility.getName(po.getFspshortmessagename()));
		params.add(Utility.getName(po.getFspshortmessagepw()));
		params.add(Utility.getName(po.getFspautoupgradeissub()));
		params.add(Utility.getName(po.getFspshoptoshop()));
		params.add(Utility.getName(po.getFspselectovershowchange()));
		params.add(Utility.getName(po.getFspcustomeraddress()));
		params.add(Utility.getName(po.getFsppageno()));
		params.add(Utility.getName(po.getFspstealtheffective()));
		params.add(Utility.getName(po.getFspcollecttype()));
		params.add(Utility.getName(po.getFspiscountperfrom()));
		params.add(Utility.getName(po.getFspupdatecheck()));
		params.add(Utility.getName(po.getFspsharestockmessage()));
		params.add(Utility.getName(po.getFspeffectivealert()));
		if(!"3".equals(Utility.getName(po.getFspbarcodetype()))){
			params.add(Utility.getName(po.getFspframebarcodetype()));
			params.add(Utility.getName(po.getFspglassbarcodetype()));
		}else{
			params.add("");
			params.add("");
		}
		params.add(Utility.getName(po.getFspbirthday()));
		params.add(Utility.getName(po.getFspbirthdaycallday()));
		params.add(Utility.getName(po.getFspbirthdaycallhour()));
		params.add(Utility.getName(po.getFsprtx()));
		params.add(Utility.getName(po.getFspserverip()));
		params.add(Utility.getName(po.getFspeimsip()));
		params.add(Utility.getName(po.getFspexchangeintegral()));
		params.add(Utility.getName(po.getFspallocationatuotime()));
		params.add(Utility.getName(po.getFspselectstocktype()));
		params.add(Utility.getName(po.getFspfirstchecktype()));
		params.add(Utility.getName(po.getFspdefaultdiscounttype()));
		params.add(Utility.getName(po.getFspreporthelpshow()));
		params.add(Utility.getName(po.getFspreportbgndate()));
		params.add(Utility.getName(po.getFspreportenddate()));
		params.add(Utility.getName(po.getFspreportdateflag()));
		params.add(Utility.getName(po.getFspreportMonth()));
		params.add(Utility.getName(po.getFspreportLastMonth()));
		params.add(Utility.getName(po.getFsplogonform()));		
		params.add(Utility.getName(po.getFspexecstandard()));
		params.add(Utility.getName(po.getFspsalesintransit()));
		params.add(Utility.getName(po.getFspisshowsupplierandbrand()));
		params.add(Utility.getName(po.getFspsalescounttype()));
		if("".equals(Utility.getName(po.getFspinvoicetype()))){
			params.add("0");
		}else{
			params.add(Utility.getName(po.getFspinvoicetype()));
		}
		params.add(Utility.getName(po.getFsppaymenttype()));
		if("".equals(Utility.getName(po.getFspshowsupplier()))){
			params.add("0");
		}else{
			params.add(Utility.getName(po.getFspshowsupplier()));
		}
		params.add(Utility.getName(po.getFsppjbillsetup()));
		params.add(Utility.getName(po.getFsppjbillsetuptime()));
		if("".equals(Utility.getName(po.getFspshowcustomertable()))){
			params.add("0");
		}else{
			params.add(Utility.getName(po.getFspshowcustomertable()));
		}
		params.add(Utility.getName(po.getFspnegative()));
		params.add(Utility.getName(po.getFspinspectionvisuelle()));
		params.add(Utility.getName(po.getFspothernegative()));
		params.add(Utility.getName(po.getFspintransitstorageflag()));
		params.add(Utility.getName(po.getFspoutmaterialsflag()));
		
		buffer.append("       F_SP_RetailPrice = ?, ");
		params.add(Utility.getName(po.getFspretailprice()));
		buffer.append("       F_SP_RetailPricea = ?, ");
		params.add(Utility.getName(po.getFspretailpricea()));
		buffer.append("       F_SP_RetailPriceb = ?, ");
		params.add(Utility.getName(po.getFspretailpriceb()));
		buffer.append("       F_SP_RetailPricec = ?, ");
		params.add(Utility.getName(po.getFspretailpricec()));
		buffer.append("       F_SP_RetailPriced = ?, ");
		params.add(Utility.getName(po.getFspretailpriced()));
		buffer.append("       F_SP_RetailPricee = ?, ");
		params.add(Utility.getName(po.getFspretailpricee()));
		buffer.append("       F_SP_RetailPricef = ?, ");
		params.add(Utility.getName(po.getFspretailpricef()));
		buffer.append("       F_SP_RetailPriceg = ?, ");
		params.add(Utility.getName(po.getFspretailpriceg()));
		buffer.append("       F_SP_RetailPriceh = ?, ");
		params.add(Utility.getName(po.getFspretailpriceh()));
		buffer.append("       F_SP_RetailPricei = ?, ");
		params.add(Utility.getName(po.getFspretailpricei()));
		buffer.append("       F_SP_IsCheckMAC = ?, ");
		params.add(Utility.getName(po.getFspischeckmac()));
		buffer.append("       F_SP_UpdateInspection = ?, ");
		params.add(Utility.getName(po.getFspupdateinspection()));
		buffer.append("       F_SP_OldglassSalestype = ?, ");
		params.add(Utility.getName(po.getFspoldglasssalestype()));
		buffer.append("       F_SP_UpdateGuitartype = ?, ");
		params.add(Utility.getName(po.getFspupdateguitartype()));
		buffer.append("       F_SP_WhichMachine=?, ");  
		params.add(Utility.getName(po.getFspwhichmachine()));
		buffer.append("       F_SP_CheckAccessories=?, ");  
		params.add(Utility.getName(po.getFspcheckaccessories()));
		
		buffer.append("       F_SP_PartsBarcodeType=?, ");  
		params.add(Utility.getName(po.getFsppartsbarcodetype()));
		buffer.append("       F_SP_StealthBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspstealthbarcodetype()));
		buffer.append("       F_SP_SolutionBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspsolutionbarcodetype()));
		buffer.append("       F_SP_SunglassesBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspsunglassesbarcodetype()));
		buffer.append("       F_SP_ConsumeBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspconsumebarcodetype()));
		buffer.append("       F_SP_OldglassesBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspoldglassesbarcodetype()));
		buffer.append("       F_SP_MetropiaBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspmetropiabarcodetype()));
		buffer.append("       F_SP_DiscountBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspdiscountbarcodetype()));
		buffer.append("       F_SP_BrandBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspbrandbarcodetype()));
		buffer.append("       F_SP_JQBarcodeType=?, ");  
		params.add(Utility.getName(po.getFspjqbarcodetype()));
		buffer.append("       F_SP_ShowRptCondition=?, ");
		params.add(Utility.getName(po.getFspshowrptcondition()));
		if("1".equals(po.getFspsharestockmessage())){
			buffer.append("       F_SP_StockQueryConditions=?, ");
			params.add(Utility.getName(po.getFspstockqueryconditions()));
		}
		if("0".equals(po.getFspsharestockmessage())){
			buffer.append("       F_SP_StockQueryConditions=NULL, ");
		}
		
		params.add(Utility.getName(po.getFspcjj()));
		buffer.append("       F_SP_CJJ = ?, ");
		params.add(Utility.getName(po.getFspcpj()));
		buffer.append("       F_SP_CPJ = ?, ");
		params.add(Utility.getName(po.getFspcjp()));
		buffer.append("       F_SP_CJP = ?, ");
		params.add(Utility.getName(po.getFspcyxjp()));
		buffer.append("       F_SP_CYXJP = ?, ");
		params.add(Utility.getName(po.getFspchly()));
		buffer.append("       F_SP_CHLY = ?, ");
		params.add(Utility.getName(po.getFspctyj()));
		buffer.append("       F_SP_CTYJ = ?, ");
		params.add(Utility.getName(po.getFspchc()));
		buffer.append("       F_SP_CHC = ?, ");
		params.add(Utility.getName(po.getFspclh()));
		buffer.append("       F_SP_CLH = ?, ");
		params.add(Utility.getName(po.getFspcsg()));
		buffer.append("       F_SP_CSG = ?, ");
		buffer.append("       F_SP_SalesStealthOther = ?, ");
		params.add(Utility.getName(po.getFspsalesstealthother()));
		
		buffer.append("       F_SP_WholesalePriceSet = ?, ");
		params.add(Utility.getName(po.getFspwholesalepriceset()));
		
		buffer.append("       F_SP_PrintStealthCheck = ?, ");
		params.add(Utility.getName(po.getFspprintstealthcheck()));
		
		buffer.append("       F_SP_MemberCardLen = ?, ");
		params.add(Utility.getName(po.getFspcustomercardlen()));
		
		buffer.append("       F_SP_GlassisCheckNumber = ?, ");
		params.add(Utility.getName(po.getFspglassischecknumber()));
		
		buffer.append("       F_SP_Identitycard = ?, ");
		params.add(Utility.getName(po.getFspidentitycard()));
		
		buffer.append("       F_SP_CustomAmount = ?,");
		params.add(Utility.getName(po.getFspcustomamount()));
		buffer.append("       F_SP_IsAllocationCategory = ?, ");
		params.add(Utility.getName(po.getFspisallocationcategory()));
		buffer.append("       F_SP_IsFillInDeliveryID = ?, ");
		params.add(Utility.getName(po.getFspisfillindeliveryid()));
		buffer.append("       F_SP_UpdateCreditType = ?, ");
		params.add(Utility.getName(po.getFspupdatecredittype()));
		
		buffer.append("       F_SP_RefundComplainFlag = ?, ");
		params.add(Utility.getName(po.getFsprefundcomplainflag()));
		
		buffer.append("       F_SP_ShowDwAndTable = ?, ");
		params.add(Utility.getName(po.getFspshowdwandtable()));
		
		buffer.append("       F_SP_ComplainBandBillFlag = ?, ");
		params.add(Utility.getName(po.getFspcomplainbandbill()));
		
		buffer.append("       F_SP_VD = ?, ");
		params.add(Utility.getName(po.getFspvd()));
		
		buffer.append("       F_SP_ShopDistributionRefund = ?, ");
		params.add(Utility.getName(po.getFspshopdistributionrefund()));
		
		buffer.append("       F_SP_IsUseGoodsLevel = ?, ");
		params.add(Utility.getName(po.getFspisusegoodslevel()));
		
		buffer.append("       F_SP_AutoSpectaclesMaterials = ?, ");
		params.add(Utility.getName(po.getFspautospectaclesmaterials()));
		
		buffer.append("       F_SP_ZZAutoSpectaclesMaterials = ?, ");
		params.add(Utility.getName(po.getFspzzautospectaclesmaterials()));
		
		buffer.append("       F_SP_SalerDefaultSet = ?, ");
		params.add(Utility.getName(po.getFspsalerdefaultset()));
		
		buffer.append("       F_SP_HisFlag = ?, ");
		params.add(Utility.getName(po.getFsphisflag()));

		buffer.append("       F_SP_AccountPeriod = ?, ");
		params.add(Utility.getName(po.getFspaccountperiod()));

		buffer.append("       F_SP_MinIntegral = ?, ");
		params.add(Utility.getName(po.getFspminintegral()));

		buffer.append("       F_SP_AccessorySalesType = ?, ");
		params.add(Utility.getName(po.getFspaccessorysalestype()));
				
		buffer.append("       F_SP_QueryGoodsStorage = ?, ");
		params.add(Utility.getName(po.getFspquerygoodsstorage()));
				
		buffer.append("       F_SP_DefGetGlassesTime = ?, ");
		params.add(Utility.getName(po.getFspdefgetglassestime()));
		
		buffer.append("       F_SP_GlassesSalesCustom = ?, ");
		params.add(Utility.getName(po.getFspglassessalescustom()));

		buffer.append("       F_SP_CheckstorageFlag = ?, ");
		params.add(Utility.getName(po.getFspcheckstorageflag()));
	
		buffer.append("       F_SP_Address_Type = ?, ");
		params.add(Utility.getName(po.getFspaddresstype()));
		buffer.append("       F_SP_Area1 = ?, ");
		params.add(Utility.getName(po.getFsparea1()));
		buffer.append("       F_SP_Area2 = ?, ");
		params.add(Utility.getName(po.getFsparea2()));
		buffer.append("       F_SP_Area3 = ?, ");
		params.add(Utility.getName(po.getFsparea3()));
		buffer.append("       F_SP_Area4 = ?, ");
		params.add(Utility.getName(po.getFsparea4()));
		buffer.append("       F_SP_Area5 = ?, ");
		params.add(Utility.getName(po.getFsparea5()));
		
		buffer.append("       F_SP_DefaultRecipeType = ?, ");
		params.add(Utility.getName(po.getFspdefaultrecipetype()));
		
		buffer.append("       F_SP_PrintHistoryFlag = ?, ");
		params.add(Utility.getName(po.getFspprintmedicalhistory()));
		
		buffer.append("       F_SP_Djsbm = ?, ");
		params.add(Utility.getName(po.getFspdjsbm()));
		
		buffer.append("       F_SP_SupplierInsertXzd = ?, ");
		params.add(Utility.getName(po.getFspsupplierinsertxzd()));
		
		buffer.append("       F_SP_DefaultMemberID = ?, ");
		params.add(Utility.getName(po.getFspdefaultmemberid()));

		buffer.append("       F_SP_PrintSalesbillAtBuKuanFlag = ?, ");
		params.add(Utility.getName(po.getFspprintsalesbillatbukuanflag()));
		
		buffer.append("       F_SP_ProcessDifficulty = ?, ");
		params.add(Utility.getName(po.getFspprocessdifficulty()));
		
		buffer.append("       F_SP_NongAllocation = ?, ");
		params.add(Utility.getName(po.getFspnongallocation()));
		
		buffer.append("       F_SP_KqSystem = ?, ");
		params.add(Utility.getName(po.getFspkqsystem()));
		
		buffer.append("       F_SP_IPUrl = ?, ");
		params.add(Utility.getName(po.getFspipurl()));
		
		buffer.append("       F_SP_IsShowDiscount3detail = ?, ");
		params.add(Utility.getName(po.getFspisshowdiscount3detail()));
		
		buffer.append("       F_SP_YxpsFlag = ?, ");
		params.add(Utility.getName(po.getFspyxpsflag()));
		
		buffer.append("       F_SP_PrintbzdFlag = ?, ");
		params.add(Utility.getName(po.getFspprintbzdflag()));
		
		buffer.append("       F_SP_AutoAllocationFlag = ?, ");
		params.add(Utility.getName(po.getFspautoallocationflag()));
	
		buffer.append("       F_SP_SplitSalesDataFlag = ?, ");
		params.add(Utility.getName(po.getFspsplitsalesdataflag()));
	
		buffer.append("       F_SP_IsAllocationSupplier = ?, ");
		params.add(Utility.getName(po.getFspisallocationsupplier()));
	
		buffer.append("       F_SP_XianjinDefault = ?, ");
		params.add(Utility.getName(po.getFspxianjindefault()));
		
		buffer.append("       F_SP_OptometryDetailsType = ?, ");
		params.add(Utility.getName(po.getFspoptometrydetailstype()));

		buffer.append("       F_SP_IsSalesMessageShareForVAndV = ?, ");
		params.add(Utility.getName(po.getFspissalesmessageshareforvandv()));
		
		buffer.append("       F_SP_IsSalesMessageShareForMAndV = ?, ");
		params.add(Utility.getName(po.getFspissalesmessageshareformandv()));
		buffer.append("       F_SP_RegistrationNum = ?, ");
		params.add(Utility.getName(po.getFspisregistrationnum()));	
		
		buffer.append("       F_SP_BaojiaFlag = ?, ");
		params.add(Utility.getName(po.getFspisbaojiaflag()));

		buffer.append("       F_SP_CbjsType = ?, ");
		params.add(Utility.getName(po.getFspcbjstype()));
		buffer.append("       F_SP_Cbjsscxzsy = ?, ");
		params.add(Utility.getName(po.getFspcbjsscxzsy()));
		buffer.append("       F_SP_DayCheckOut = ?, ");
		params.add(Utility.getName(po.getFspdaycheckout()));

		buffer.append("       F_SP_SelectOptometrist = ? ");
		params.add(Utility.getName(po.getFspselectoptometrist()));
		
		buffer.append("       ,F_SP_AllocationAutoReceipt = ? ");
		params.add(Utility.getName(po.getFspallocationautoreceipt()));
		
		buffer.append("       ,F_SP_AllocationStorageType = ? ");
		params.add(Utility.getName(po.getFspallocationstoragetype()));

		buffer.append("       ,F_SP_SalesBillShare = ? ");
		params.add(Utility.getName(po.getFspissalesbillshareformandv()));

		buffer.append("       ,F_SP_Djsbmfortype = ? ");
		params.add(Utility.getName(po.getFspdjsbmfortype()));
		
		buffer.append("       ,F_SP_RightShowUrl = ? ");
		params.add(Utility.getName(po.getFsprightshowurl()));
		
		buffer.append("       ,F_SP_SynCompanySupplier = ? ");
		params.add(Utility.getName(po.getFspsyncompanysupplier()));
		
		buffer.append("       ,F_SP_QcCbFinishFlag = ? ");
		params.add(Utility.getName(po.getFspqccbfinish()));
		
		buffer.append("       ,F_SP_QcKcFinishFlag = ? ");
		params.add(Utility.getName(po.getFspqckcfinish()));
		
		buffer.append("       ,F_SP_LyAndPfByCbjs = ? ");
		params.add(Utility.getName(po.getFsplyandpfbycbjs()));
		
		buffer.append("       ,F_SP_SleepStartTime = ? ");
		params.add(Utility.getName(po.getFspsleepstarttime()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增测试手机电话
	 * @param po
	 */
	public void insertTextPhone(String phone) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("       insert into S_ME_CustomerPhone (S_ME_CI_Phone) values (?) ");
		params.add(Utility.getName(phone));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除测试手机电话
	 * @param po
	 */
	public void deleteTextPhone(SystemParameterPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("       delete from S_ME_CustomerPhone ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 查询系统参数信息
	 * @return
	 */
	public SystemParameterPo getSystemParameterPo() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("SELECT TOP 1 F_SP_UUID                 	AS fspuuid, ");
		buffer.append(" F_SP_BarcodeType          	AS fspbarcodetype, ");
		buffer.append(" F_SP_SalesCountType       	AS fspsalescounttype, ");
		buffer.append(" F_SP_Retained             	AS fspretained, ");
		buffer.append(" F_SP_Remove               	AS fspremove, ");
		buffer.append(" F_SP_RemoveNumber         	AS fspremovenumber, ");
		buffer.append(" F_SP_AllDiscount          	AS fspalldiscount, ");
		buffer.append(" F_SP_SalesType            	AS fspsalestype, ");
		buffer.append(" F_SP_ShowChange           	AS fspshowchange, ");
		buffer.append(" F_SP_ShortMessage         	AS fspshortmessage, ");
		buffer.append(" F_SP_ShortMessageName       AS fspshortmessagename, ");
		buffer.append(" F_SP_ShortMessagePw         AS fspshortmessagepw, ");
		buffer.append(" F_SP_AutoUpgradeIsSub     	AS fspautoupgradeissub, ");
		buffer.append(" F_SP_ShopToShop           	AS fspshoptoshop, ");
		buffer.append(" F_SP_SelectOverShowChange 	AS fspselectovershowchange, ");
		buffer.append(" F_SP_CustomerAddress      	AS fspcustomeraddress, ");
		buffer.append(" F_SP_PageNo               	AS fsppageno, ");
		buffer.append(" F_SP_StealthEffective     	AS fspstealtheffective, ");
		buffer.append(" F_SP_CollectType          	AS fspcollecttype, ");
		buffer.append(" F_SP_IsCountPerfrom         AS fspiscountperfrom, ");
		buffer.append(" F_SP_UpdateCheck          	AS fspupdatecheck, ");
		buffer.append(" F_SP_ShareStockMessage    	AS fspsharestockmessage, ");
		buffer.append(" F_SP_EffectiveAlert       	AS fspeffectivealert, ");
		buffer.append(" F_SP_FrameBarcodeType     	AS fspframebarcodetype, ");
		buffer.append(" F_SP_GlassBarcodeType     	AS fspglassbarcodetype, ");
		buffer.append(" F_SP_Birthday             	AS fspbirthday, ");
		buffer.append(" F_SP_BirthdayCallDay      	AS fspbirthdaycallday, ");
		buffer.append(" F_SP_BirthdayCallHour     	AS fspbirthdaycallhour, ");
		buffer.append(" F_SP_RTX                  	AS fsprtx, ");
		buffer.append(" F_SP_ServerIP             	AS fspserverip, ");
		buffer.append(" F_SP_EimsIP               	AS fspeimsip, ");
		buffer.append(" F_SP_WholesalePriceSet    	AS fspwholesalepriceset, ");
		buffer.append(" F_SP_IsCheckMAC           	AS fspischeckmac,F_SP_ShowDwAndTable  AS fspshowdwandtable, ");
		buffer.append(" isnull(F_SP_ExchangeIntegral,'0.00') as fspexchangeintegral,F_SP_InspectionVisuelle as fspinspectionvisuelle,F_SP_Negative as fspnegative, ");
		buffer.append(" F_SP_AllocationAtuoTime   	AS fspallocationatuotime, ");
		buffer.append(" F_SP_SelectStockType      	AS fspselectstocktype,isnull(F_SP_LogonForm,'1') as fsplogonform, ");
		buffer.append(" F_SP_FirstCheckType       	AS fspfirstchecktype,F_SP_ReportDateFlag as fspreportdateflag,F_SP_ReportDateMonth as fspreportMonth,F_SP_ReportLastMonth as fspreportLastMonth, ");
		buffer.append(" F_SP_DefaultDiscountType  	AS fspdefaultdiscounttype,F_SP_ReportHelpShow as fspreporthelpshow,F_SP_ReportBgnDate as fspreportbgndate,F_SP_ReportEndDate as fspreportenddate, ");
		buffer.append("(select top 1 L_BFD_Date from L_BFD_BalanceForwardDate ) as fspsystemonlinedate,isnull(F_SP_ExecStandard,'') as fspexecstandard,isnull(F_SP_SalesIntransit,'') as fspsalesintransit, ");
		buffer.append(" F_SP_IsShowSupplierAndBrand AS fspisshowsupplierandbrand, ");
		buffer.append(" F_SP_RetailPrice			as	fspretailprice	, ");
		buffer.append(" F_SP_RetailPriceA			as	fspretailpricea	, ");
		buffer.append(" F_SP_RetailPriceB			as	fspretailpriceb	, ");
		buffer.append(" F_SP_RetailPriceC			as	fspretailpricec	, ");
		buffer.append(" F_SP_RetailPriceD			as	fspretailpriced	, ");
		buffer.append(" F_SP_RetailPriceE			as	fspretailpricee	, ");
		buffer.append(" F_SP_RetailPriceF			as	fspretailpricef	, ");
		buffer.append(" F_SP_RetailPriceG			as	fspretailpriceg	, ");
		buffer.append(" F_SP_RetailPriceH			as	fspretailpriceh	, ");
		buffer.append(" F_SP_RetailPriceI			as	fspretailpricei , ");
		buffer.append(" F_SP_InvoiceType 			as fspinvoicetype, ");
		buffer.append(" F_SP_PaymentType 			as fsppaymenttype, ");
		buffer.append(" F_SP_UpdateInspection		as fspupdateinspection, ");
		buffer.append(" F_SP_OldglassSalestype		as fspoldglasssalestype, ");
		buffer.append(" F_SP_UpdateGuitartype		as fspupdateguitartype, ");
		buffer.append(" convert(varchar(10),F_SP_TrialLimit,120)	as fsptriallimit, ");
		buffer.append(" F_SP_UpdateGuitartype		as fspupdateguitartype, ");
		buffer.append(" F_SP_WhichMachine			as fspwhichmachine, ");
		buffer.append(" F_SP_CheckAccessories		as fspcheckaccessories, ");
		buffer.append(" F_SP_PartsBarcodeType 		as fsppartsbarcodetype, ");  
		buffer.append(" F_SP_StealthBarcodeType		as fspstealthbarcodetype, ");  
		buffer.append(" F_SP_SolutionBarcodeType 	as fspsolutionbarcodetype, ");  
		buffer.append(" F_SP_SunglassesBarcodeType  as fspsunglassesbarcodetype, ");  
		buffer.append(" F_SP_ConsumeBarcodeType		as fspconsumebarcodetype, ");  
		buffer.append(" F_SP_OldglassesBarcodeType	as fspoldglassesbarcodetype, ");  
		buffer.append(" F_SP_MetropiaBarcodeType	as fspmetropiabarcodetype, ");  
		buffer.append(" F_SP_DiscountBarcodeType	as fspdiscountbarcodetype, ");  
		buffer.append(" F_SP_BrandBarcodeType		as fspbrandbarcodetype, ");  
		buffer.append(" F_SP_StockQueryConditions	as fspstockqueryconditions, ");  
		buffer.append(" F_SP_JQBarcodeType			as fspjqbarcodetype, ");
		buffer.append(" F_SP_CJJ 					as fspcjj, ");
		buffer.append(" F_SP_CPJ 					as fspcpj, ");
		buffer.append(" F_SP_CJP					as fspcjp, ");
		buffer.append(" F_SP_CYXJP					as fspcyxjp, ");
		buffer.append(" F_SP_CHLY					as fspchly, ");
		buffer.append(" F_SP_CTYJ					as fspctyj, ");
		buffer.append(" F_SP_CHC					as fspchc, ");
		buffer.append(" F_SP_CLH					as fspclh, ");
		buffer.append(" F_SP_CSG					as fspcsg, ");
		buffer.append(" F_SP_StockQueryConditions	as fspstockqueryconditions, ");  
		buffer.append(" ISNULL(F_SP_ShowRptCondition, 0)		as fspshowrptcondition, ");  
		buffer.append(" F_SP_ShowSupplier			as fspshowsupplier, "); 
		buffer.append(" F_SP_PjBillSetUp			as fsppjbillsetup, ");  
		buffer.append(" F_SP_PjBillSetUpTime		as fsppjbillsetuptime, ");  
		buffer.append(" F_SP_JQBarcodeType			as fspjqbarcodetype, "); 
		buffer.append(" F_SP_GlassisCheckNumber		as fspglassischecknumber, "); 
		buffer.append(" F_SP_ShowCustomerTable		as fspshowcustomertable,F_SP_OtherNegative as fspothernegative,  "); 
		buffer.append(" F_SP_SalesStealthOther		as fspsalesstealthother,F_SP_InTransitstorageflag as fspintransitstorageflag "); 
		buffer.append(" ,F_SP_PrintStealthCheck		as fspprintstealthcheck,F_SP_OutMaterialsFlag as fspoutmaterialsflag,F_SP_MemberCardLen as fspcustomercardlen "); 
		buffer.append(" ,F_SP_Identitycard			as fspidentitycard ");
		buffer.append(" ,F_SP_CustomAmount			as fspcustomamount ");
		buffer.append(" ,F_SP_IsAllocationCategory	as fspisallocationcategory ");
		buffer.append(" ,F_SP_IsFillInDeliveryID	as fspisfillindeliveryid,F_SP_RefundComplainFlag as fsprefundcomplainflag ");
		buffer.append(" ,F_SP_UpdateCreditType		as fspupdatecredittype,F_SP_ComplainBandBillFlag as fspcomplainbandbill ");
		buffer.append(" ,F_SP_VD 					as fspvd ");
		buffer.append(" ,F_SP_ShopDistributionRefund 				as fspshopdistributionrefund ");
		buffer.append(" ,F_SP_IsUseGoodsLevel 						as fspisusegoodslevel ");
		buffer.append(" ,F_SP_AutoSpectaclesMaterials 				as fspautospectaclesmaterials ");
		buffer.append(" ,F_SP_ZZAutoSpectaclesMaterials 			as fspzzautospectaclesmaterials ");
		buffer.append(" ,F_SP_SalerDefaultSet 						as fspsalerdefaultset ");
		buffer.append(" ,F_SP_HisFlag 								as fsphisflag ");
		buffer.append(" ,F_SP_AccountPeriod 						as fspaccountperiod ");
		buffer.append(" ,F_SP_MinIntegral 							as fspminintegral ");
		buffer.append(" ,F_SP_AccessorySalesType 					as fspaccessorysalestype ");
		buffer.append(" ,F_SP_QueryGoodsStorage 					as fspquerygoodsstorage ");
		buffer.append(" ,F_SP_CheckstorageFlag 						as fspcheckstorageflag ");		// 盘点方式(1:选择商品类别盘点；0:不限制商品类别盘点；    
		buffer.append(" ,F_SP_DefGetGlassesTime 					as fspdefgetglassestime ");
		buffer.append(" ,isnull(F_SP_GlassesSalesCustom,'1') 		as fspglassessalescustom ");
		buffer.append(" ,isnull(F_SP_DefaultRecipeType,'') 			as fspdefaultrecipetype ");
		buffer.append(" ,isnull(F_SP_PrintHistoryFlag,'') 			as fspprintmedicalhistory ");
		buffer.append(" ,isnull(F_SP_Address_Type,'0') 				as fspaddresstype ");
		buffer.append(" ,isnull(F_SystemParameter.F_SP_Area1,'') 	as fsparea1 ");
		buffer.append(" ,isnull(F_SystemParameter.F_SP_Area2,'') 	as fsparea2 ");
		buffer.append(" ,isnull(F_SystemParameter.F_SP_Area3,'') 	as fsparea3 ");
		buffer.append(" ,isnull(F_SystemParameter.F_SP_Area4,'') 	as fsparea4 ");
		buffer.append(" ,isnull(F_SystemParameter.F_SP_Area5,'') 	as fsparea5 ");
		buffer.append(" ,F_SP_Djsbm 								as fspdjsbm ");
		buffer.append(" ,F_SP_SupplierInsertXzd 					as fspsupplierinsertxzd ");
		buffer.append(" ,F_SP_DefaultMemberID 						as fspdefaultmemberid ");
		buffer.append(" ,F_SP_PrintSalesbillAtBuKuanFlag 			as fspprintsalesbillatbukuanflag ");
		buffer.append(" ,F_SP_ProcessDifficulty 					as fspprocessdifficulty ");
		buffer.append(" ,F_SP_NongAllocation 						as fspnongallocation ");
		buffer.append(" ,isnull(F_SP_KqSystem,'') 					as fspkqsystem ");
		buffer.append(" ,isnull(F_SP_IsShowDiscount3detail,'1') 	as fspisshowdiscount3detail ");
		buffer.append(" ,F_SP_IPUrl 								as fspipurl ");
		buffer.append(" ,F_SP_YxpsFlag 								as fspyxpsflag ");
		buffer.append(" ,F_SP_PrintbzdFlag 							as fspprintbzdflag ");
		buffer.append(" ,F_SP_AutoAllocationFlag 					as fspautoallocationflag ");
		buffer.append(" ,F_SP_SplitSalesDataFlag 					as fspsplitsalesdataflag ");		// 销售页面打折窗口是否显示折扣率
		buffer.append(" ,isnull(F_SP_IsAllocationSupplier,'') 		as fspisallocationsupplier ");
		buffer.append(" ,isnull(F_SP_XianjinDefault,'') 			as fspxianjindefault ");
		buffer.append(" ,isnull(F_SP_OptometryDetailsType,'') 		as fspoptometrydetailstype ");
		buffer.append(" ,F_SP_IsSalesMessageShareForVAndV	 		as fspissalesmessageshareforvandv ");
		buffer.append(" ,F_SP_IsSalesMessageShareForMAndV	 		as fspissalesmessageshareformandv ");
		buffer.append(" ,isnull(F_SP_RegistrationNum,'')	 		as fspisregistrationnum ");
		buffer.append(" ,dbo.getTextPhone() 						as fsptextphone ");
		buffer.append(" ,isnull(F_SP_BaojiaFlag,'')	 				as fspisbaojiaflag ");
		buffer.append(" ,isnull(F_SP_CbjsType,'')	 				as fspcbjstype ");
		buffer.append(" ,isnull(F_SP_Cbjsscxzsy,'')	 				as fspcbjsscxzsy ");
		buffer.append(" ,isnull(F_SP_DayCheckOut,'')	 			as fspdaycheckout ");
		buffer.append(" ,isnull(F_SP_SelectOptometrist,'')	 		as fspselectoptometrist ");
		buffer.append(" ,F_SP_AllocationAutoReceipt	 				as fspallocationautoreceipt ");
		buffer.append(" ,F_SP_AllocationStorageType	 				as fspallocationstoragetype ");
		buffer.append(" ,F_SP_SalesBillShare	 				    as fspissalesbillshareformandv ");
		buffer.append(" ,F_SP_Djsbmfortype	 						as fspdjsbmfortype ");
		buffer.append(" ,F_SP_RightShowUrl	 						as fsprightshowurl ");
		buffer.append(" ,F_SP_SynCompanySupplier	 				as fspsyncompanysupplier ");		
		buffer.append(" ,F_SP_QcCbFinishFlag	 					as fspqccbfinish ");
		buffer.append(" ,F_SP_QcKcFinishFlag	 					as fspqckcfinish ");		
		buffer.append(" ,F_SP_LyAndPfByCbjs	 				    	as fsplyandpfbycbjs ");
		buffer.append(" ,isnull(F_SP_SleepStartTime,'')			    as fspsleepstarttime ");
		buffer.append("FROM   F_SystemParameter ");
		buffer.append("LEFT JOIN F_Area f1 ON f1.F_A_ID = F_SystemParameter.F_SP_Area1 and f1.F_A_Level='1' ");
		buffer.append("LEFT JOIN F_Area f2 ON f2.F_A_ID = F_SystemParameter.F_SP_Area2 and f2.F_A_Level='2' "); 
		buffer.append("LEFT JOIN F_Area f3 ON f3.F_A_ID = F_SystemParameter.F_SP_Area3 and f3.F_A_Level='3' "); 
		buffer.append("LEFT JOIN F_Area f4 ON f4.F_A_ID = F_SystemParameter.F_SP_Area4 and f4.F_A_Level='4' "); 
		buffer.append("LEFT JOIN F_Area f5 ON f5.F_A_ID = F_SystemParameter.F_SP_Area5 and f5.F_A_Level='5' "); 		
		return (SystemParameterPo) queryForObject(buffer.toString(), null, SystemParameterPo.class);
	}

	/**
	 * 查询使用过的零售价
	 */
	public List<DepartmentsPo> selectDepartmentsPoForWhichretail() {
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		
		buffer.append("SELECT B_DP_WhichRetail     AS bdpwhichretail ");
		buffer.append("FROM   B_Departments ");
		buffer.append("group by B_DP_WhichRetail ");
		buffer.append("order by B_DP_WhichRetail ");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DepartmentsPo.class);
	}

	/**
	 * 查询条码样式坐标
	 * @param po
	 * @return
	 */
	public List<SystemParameterPo> selectBarcodeCoordinate(SystemParameterPo po) {
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		
		buffer.append("SELECT C_SH_BC_PartID   				AS fsprow, ");
		buffer.append("       C_SH_BC_X     				AS fspx, ");
		buffer.append("       C_SH_BC_Y     				AS fspy, ");
		buffer.append("       C_SH_BC_FontSize    			AS fspsize, ");
		buffer.append("       C_SH_BC_Ishowbarcodename    	AS fspishowbarcodename, ");
		buffer.append("       C_SH_BC_RowPrintNum   		AS fsprowprintnum, ");
		buffer.append("       C_SH_BC_RowPrintSpan  		AS fsprowprintspan, ");
		buffer.append("       C_SH_BC_NRIB		    		AS fspnrib, ");
		buffer.append("       C_SH_BC_Port		    		AS fspport, ");
		buffer.append("       C_SH_BC_Font		    		AS fspfont, ");
		buffer.append("       C_SH_BC_YouThink1		    	AS fspyouthink1, ");
		buffer.append("       C_SH_BC_YouThink2		    	AS fspyouthink2, ");
		buffer.append("       C_SH_BC_YouThink3		    	AS fspyouthink3, ");
		buffer.append("       C_SH_BC_YouThink4		    	AS fspyouthink4, ");
		buffer.append("       C_SH_BC_YouThink5		    	AS fspyouthink5, ");
		buffer.append("       C_SH_BC_YouThink6		    	AS fspyouthink6, ");
		buffer.append("       C_SH_BC_YouThink7		    	AS fspyouthink7, ");
		buffer.append("       C_SH_BC_YouThink8		    	AS fspyouthink8, ");
		buffer.append("       C_SH_BC_YouThink9		    	AS fspyouthink9, ");
		buffer.append("       C_SH_BC_YouThink10		    AS fspyouthink10, ");
		buffer.append("       C_SH_BC_IsPrint		    	AS fspisprint ");
		buffer.append("FROM   C_SH_BarcodeCoordinate ");
		buffer.append("WHERE  C_SH_BC_StyleID = ? ");
		buffer.append("ORDER BY cast(C_SH_BC_PartID as int)");
		
		
		params.add(po.getFsptype());
		
		return queryForObjectList(buffer.toString(), params.toArray(), SystemParameterPo.class);
	}
	
	/**
	 * 更新指定行的数据
	 * @param po
	 */
	public void updateBarcodeCoordinate(SystemParameterPo po) {
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		
		buffer.append("UPDATE C_SH_BarcodeCoordinate ");
		buffer.append("SET    C_SH_BC_X = ?, ");
		buffer.append("       C_SH_BC_Y = ?, ");
		buffer.append("       C_SH_BC_FontSize = ?, ");
		buffer.append("       C_SH_BC_Ishowbarcodename = ?, ");
		buffer.append("       C_SH_BC_RowPrintNum = ?, ");
		buffer.append("       C_SH_BC_RowPrintSpan = ?, ");
		buffer.append("       C_SH_BC_NRIB = ?, ");
		buffer.append("       C_SH_BC_Port = ?, ");
		buffer.append("       C_SH_BC_Font = ?, ");
		buffer.append("       C_SH_BC_YouThink1 = ?, ");
		buffer.append("       C_SH_BC_YouThink2 = ?, ");
		buffer.append("       C_SH_BC_YouThink3 = ?, ");
		buffer.append("       C_SH_BC_YouThink4 = ?, ");
		buffer.append("       C_SH_BC_YouThink5 = ?, ");
		buffer.append("       C_SH_BC_YouThink6 = ?, ");
		buffer.append("       C_SH_BC_YouThink7 = ?, ");
		buffer.append("       C_SH_BC_YouThink8 = ?, ");
		buffer.append("       C_SH_BC_YouThink9 = ?, ");
		buffer.append("       C_SH_BC_YouThink10 = ?, ");
		buffer.append("       C_SH_BC_IsPrint = ? ");
		buffer.append("WHERE  C_SH_BC_StyleID = ? ");
		buffer.append("  AND  C_SH_BC_PartID = ? ");
		
		params.add(Utility.getName(po.getFspx()));
		params.add(Utility.getName(po.getFspy()));
		params.add(Utility.getName(po.getFspsize()));
		params.add(Utility.getName(po.getFspishowbarcodename()));
		params.add(Utility.getName(po.getFsprowprintnum()));
		params.add(Utility.getName(po.getFsprowprintspan()));
		params.add(Utility.getName(po.getFspnrib()));
		params.add(Utility.getName(po.getFspport()));
		params.add(Utility.getName(po.getFspfont()));
		
		params.add(Utility.getName(po.getFspyouthink1()));
		params.add(Utility.getName(po.getFspyouthink2()));
		params.add(Utility.getName(po.getFspyouthink3()));
		params.add(Utility.getName(po.getFspyouthink4()));
		params.add(Utility.getName(po.getFspyouthink5()));
		params.add(Utility.getName(po.getFspyouthink6()));
		params.add(Utility.getName(po.getFspyouthink7()));
		params.add(Utility.getName(po.getFspyouthink8()));
		params.add(Utility.getName(po.getFspyouthink9()));
		params.add(Utility.getName(po.getFspyouthink10()));
		params.add(Utility.getName(po.getFspisprint()));
		
		params.add(Utility.getName(po.getFsptype()));
		params.add(Utility.getName(po.getFsprow()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新某个商品类型的打印样式
	 * @param po
	 */
	public void updateCategoryBarcodeType(String categoryid,String style) {
		StringBuffer  buffer = new StringBuffer();
		List<String>  params = new ArrayList<String>();
		
		if("1".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_FrameBarcodeType = ? ");
		}else if("2".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_PartsBarcodeType = ? ");
		}else if("3".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_GlassBarcodeType = ? ");
		}else if("4".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_StealthBarcodeType = ? ");
		}else if("5".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_SolutionBarcodeType = ? ");
		}else if("6".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_SunglassesBarcodeType = ? ");
		}else if("7".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_ConsumeBarcodeType = ? ");
		}else if("8".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_OldglassesBarcodeType = ? ");
		}else if("9".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_MetropiaBarcodeType = ? ");
		}else if("10".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_BrandBarcodeType = ? ");
		}else if("11".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_JQBarcodeType = ? ");
		}else if("12".equals(categoryid)){
			buffer.append("UPDATE F_SystemParameter ");
			buffer.append("SET    F_SP_DiscountBarcodeType = ? ");
		}
		params.add(style);
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  修改商品命名规则
	 */
	public void updateGoodsViewName(SystemParameterPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		String jjstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcjj()))){
			String[] goodsnametype = po.getFspcjj().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_SupplierSpec")){
					jjstr = jjstr + "+'-厂家型号:'+"+"isnull(B_GI_SupplierSpec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
					jjstr = jjstr + "+'-型号:'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_SupplierColor")){
					jjstr = jjstr + "+'-厂家色号:'+"+"isnull(B_GI_SupplierColor,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color1")){
					jjstr = jjstr + "+'-色号:'+"+"isnull(B_GI_Color,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					jjstr = jjstr + "+'-颜色:'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_FrameMaterialType")){
					jjstr = jjstr + "+'-材质:'+"+"isnull((select top 1  B_FM_Name from B_FrameMaterial where B_FM_ID=B_GI_FrameMaterialType),'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					jjstr = jjstr + "+'-标价:'+"+"cast(B_GI_RetailPrice as varchar)";
				}else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
					jjstr = jjstr + "+'-尺寸:'+"+"cast(B_GI_FrameSize as varchar)";
				}
				
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + jjstr);
		buffer.append(" where B_GI_GoodsCategoryID = '1' ");
		
		String pjstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcpj()))){
			String[] goodsnametype = po.getFspcpj().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					pjstr = pjstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					pjstr = pjstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + pjstr);
		buffer.append(" where B_GI_GoodsCategoryID = '2' ");
		
		String cjpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcjp()))){
			String[] goodsnametype = po.getFspcjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					cjpstr = cjpstr + "+'-球镜：'+"+"isnull(B_GI_Sph,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					cjpstr = cjpstr + "+'-柱镜：'+"+"isnull(B_GI_Cyl,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					cjpstr = cjpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + cjpstr);
		buffer.append(" where B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' ");
		
		
		String djpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcjp()))){
			String[] goodsnametype = po.getFspcjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					djpstr = djpstr + "+'-球镜：'+"+"isnull(B_GI_SphUL,'')+'/'+isnull(B_GI_SphUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					djpstr = djpstr + "+'-柱镜：'+"+"isnull(B_GI_CylUL,'')+'/'+isnull(B_GI_CylUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					djpstr = djpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + djpstr);
		buffer.append(" where B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' ");
		
		String yxcjpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcyxjp()))){
			String[] goodsnametype = po.getFspcyxjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					yxcjpstr = yxcjpstr + "+'-球镜：'+"+"isnull(B_GI_Sph,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					yxcjpstr = yxcjpstr + "+'-柱镜：'+"+"isnull(B_GI_Cyl,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					yxcjpstr = yxcjpstr + "+'-颜色：'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					yxcjpstr = yxcjpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + yxcjpstr);
		buffer.append(" where B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' ");
		
		String yxdjpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcyxjp()))){
			String[] goodsnametype = po.getFspcyxjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					yxdjpstr = yxdjpstr + "+'-球镜：'+"+"isnull(B_GI_SphUL,'')+'/'+isnull(B_GI_SphUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					yxdjpstr = yxdjpstr + "+'-柱镜：'+"+"isnull(B_GI_CylUL,'')+'/'+isnull(B_GI_CylUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					yxdjpstr = yxdjpstr + "+'-颜色：'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					yxdjpstr = yxdjpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + yxdjpstr);
		buffer.append(" where B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' ");
		
		String hlystr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspchly()))){
			String[] goodsnametype = po.getFspchly().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					hlystr = hlystr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					hlystr = hlystr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + hlystr);
		buffer.append(" where B_GI_GoodsCategoryID = '5'");
		
		String tyjstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspctyj()))){
			String[] goodsnametype = po.getFspctyj().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_SupplierSpec")){
					tyjstr = tyjstr + "+'-厂家型号:'+"+"isnull(B_GI_SupplierSpec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
					tyjstr = tyjstr + "+'-型号:'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_SupplierColor")){
					tyjstr = tyjstr + "+'-厂家色号:'+"+"isnull(B_GI_SupplierColor,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color1")){
					tyjstr = tyjstr + "+'-色号:'+"+"isnull(B_GI_Color,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					tyjstr = tyjstr + "+'-颜色：'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					tyjstr = tyjstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				} else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
					tyjstr = tyjstr + "+'-尺寸:'+"+"cast(B_GI_FrameSize as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + tyjstr);
		buffer.append(" where B_GI_GoodsCategoryID = '6'");
		
		String hcstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspchc()))){
			String[] goodsnametype = po.getFspchc().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					hcstr = hcstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					hcstr = hcstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + hcstr);
		buffer.append(" where B_GI_GoodsCategoryID = '7'");
		
		String lhstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspclh()))){
			String[] goodsnametype = po.getFspclh().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					lhstr = lhstr + "+'-球镜：'+"+"isnull(B_GI_Sph,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
					lhstr = lhstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					lhstr = lhstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
					lhstr = lhstr + "+'-尺寸:'+"+"cast(B_GI_FrameSize as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + lhstr);
		buffer.append(" where B_GI_GoodsCategoryID = '8'");
		
		String sgstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcsg()))){
			String[] goodsnametype = po.getFspcsg().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					sgstr = sgstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					sgstr = sgstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
		}
		
		buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + sgstr);
		buffer.append(" where B_GI_GoodsCategoryID = '9'");

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  修改商品命名规则(调整零售价专用)
	 */
	public void updateGoodsViewNameForChangePrice(SystemParameterPo po,GoodsInfoPo gpo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		String categoryid = gpo.getBgigoodsid().substring(0, 1);
		
		String jjstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcjj())) && "1".equals(categoryid)){
			String[] goodsnametype = po.getFspcjj().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_SupplierSpec")){
					jjstr = jjstr + "+'-厂家型号:'+"+"isnull(B_GI_SupplierSpec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
					jjstr = jjstr + "+'-型号:'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_SupplierColor")){
					jjstr = jjstr + "+'-厂家色号:'+"+"isnull(B_GI_SupplierColor,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color1")){
					jjstr = jjstr + "+'-色号:'+"+"isnull(B_GI_Color,'')";
				} if(goodsnametype[i].trim().equals("B_GI_Spec")){
					jjstr = jjstr + "+'-型号:'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					jjstr = jjstr + "+'-颜色:'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_FrameMaterialType")){
					jjstr = jjstr + "+'-材质:'+"+"isnull((select top 1  B_FM_Name from B_FrameMaterial where B_FM_ID=B_GI_FrameMaterialType),'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					jjstr = jjstr + "+'-标价:'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + jjstr);
			buffer.append(" where B_GI_GoodsCategoryID = '1' ");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String pjstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcpj())) && "2".equals(categoryid)){
			String[] goodsnametype = po.getFspcpj().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					pjstr = pjstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					pjstr = pjstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + pjstr);
			buffer.append(" where B_GI_GoodsCategoryID = '2' ");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String cjpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcjp())) && "3".equals(categoryid)){
			String[] goodsnametype = po.getFspcjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					cjpstr = cjpstr + "+'-球镜：'+"+"isnull(B_GI_Sph,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					cjpstr = cjpstr + "+'-柱镜：'+"+"isnull(B_GI_Cyl,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					cjpstr = cjpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + cjpstr);
			buffer.append(" where B_GI_GoodsCategoryID = '3' and B_GI_isCustomize <> 'D' ");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String djpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcjp())) && "3".equals(categoryid)){
			String[] goodsnametype = po.getFspcjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					djpstr = djpstr + "+'-球镜：'+"+"isnull(B_GI_SphUL,'')+'/'+isnull(B_GI_SphUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					djpstr = djpstr + "+'-柱镜：'+"+"isnull(B_GI_CylUL,'')+'/'+isnull(B_GI_CylUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					djpstr = djpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + djpstr);
			buffer.append(" where B_GI_GoodsCategoryID = '3' and B_GI_isCustomize = 'D' ");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String yxcjpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcyxjp())) && "4".equals(categoryid)){
			String[] goodsnametype = po.getFspcyxjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					yxcjpstr = yxcjpstr + "+'-球镜：'+"+"isnull(B_GI_Sph,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					yxcjpstr = yxcjpstr + "+'-柱镜：'+"+"isnull(B_GI_Cyl,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					yxcjpstr = yxcjpstr + "+'-颜色：'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					yxcjpstr = yxcjpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + yxcjpstr);
			buffer.append(" where B_GI_GoodsCategoryID = '4' and B_GI_isCustomize <> 'D' ");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String yxdjpstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcyxjp())) && "4".equals(categoryid)){
			String[] goodsnametype = po.getFspcyxjp().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					yxdjpstr = yxdjpstr + "+'-球镜：'+"+"isnull(B_GI_SphUL,'')+'/'+isnull(B_GI_SphUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
					yxdjpstr = yxdjpstr + "+'-柱镜：'+"+"isnull(B_GI_CylUL,'')+'/'+isnull(B_GI_CylUP,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					yxdjpstr = yxdjpstr + "+'-颜色：'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					yxdjpstr = yxdjpstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + yxdjpstr);
			buffer.append(" where B_GI_GoodsCategoryID = '4' and B_GI_isCustomize = 'D' ");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String hlystr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspchly())) && "5".equals(categoryid)){
			String[] goodsnametype = po.getFspchly().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					hlystr = hlystr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					hlystr = hlystr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + hlystr);
			buffer.append(" where B_GI_GoodsCategoryID = '5'");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String tyjstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspctyj())) && "6".equals(categoryid)){
			String[] goodsnametype = po.getFspctyj().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_SupplierSpec")){
					tyjstr = tyjstr + "+'-厂家型号:'+"+"isnull(B_GI_SupplierSpec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
					tyjstr = tyjstr + "+'-型号:'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_SupplierColor")){
					tyjstr = tyjstr + "+'-厂家色号:'+"+"isnull(B_GI_SupplierColor,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color1")){
					tyjstr = tyjstr + "+'-色号:'+"+"isnull(B_GI_Color,'')";
				} if(goodsnametype[i].trim().equals("B_GI_Spec")){
					tyjstr = tyjstr + "+'-型号:'+"+"isnull(B_GI_Spec,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Color")){
					tyjstr = tyjstr + "+'-颜色：'+"+"isnull((select B_C_ColorName from B_Color where B_C_ID = B_GI_ChineseColor),'')";
				} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					tyjstr = tyjstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + tyjstr);
			buffer.append(" where B_GI_GoodsCategoryID = '6'");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String hcstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspchc())) && "7".equals(categoryid)){
			String[] goodsnametype = po.getFspchc().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					hcstr = hcstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					hcstr = hcstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + hcstr);
			buffer.append(" where B_GI_GoodsCategoryID = '7'");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String lhstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspclh())) && "8".equals(categoryid)){
			String[] goodsnametype = po.getFspclh().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Sph")){
					lhstr = lhstr + "+'-球镜：'+"+"isnull(B_GI_Sph,'')";
				} else if(goodsnametype[i].trim().equals("B_GI_Spec")){
					lhstr = lhstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					lhstr = lhstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + lhstr);
			buffer.append(" where B_GI_GoodsCategoryID = '8'");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		String sgstr = "B_GI_GoodsName";
		if(!"".equals(Utility.getName(po.getFspcsg())) && "9".equals(categoryid)){
			String[] goodsnametype = po.getFspcsg().trim().split(",");
			for(int i=0; i<goodsnametype.length; i++){
				if(goodsnametype[i].trim().equals("B_GI_Spec")){
					sgstr = sgstr + "+'-型号：'+"+"isnull(B_GI_Spec,'')";
				}else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
					sgstr = sgstr + "+'-标价：'+"+"cast(B_GI_RetailPrice as varchar)";
				}
			}
			
			buffer.append(" update B_GoodsInfo set B_GI_ViewGoodsName = " + sgstr);
			buffer.append(" where B_GI_GoodsCategoryID = '9'");
			buffer.append("   and B_GI_GoodsID like '%' + ? + '%'");
			params.add(Utility.getName(gpo.getBgigoodsid()));
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
