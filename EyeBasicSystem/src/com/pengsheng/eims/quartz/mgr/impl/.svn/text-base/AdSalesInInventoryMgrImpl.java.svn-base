package com.pengsheng.eims.quartz.mgr.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.dao.UnitDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.CalDao;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.mgr.VoucherTallyMgr;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.dao.MemberUpGradeDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.StockSummaryDao;
import com.pengsheng.eims.quartz.mgr.AdConsignProcessTakeMgr;
import com.pengsheng.eims.quartz.mgr.AdSalesInInventoryMgr;
import com.pengsheng.eims.quartz.mgr.AdcostPriceJobMgr;
import com.pengsheng.eims.quartz.mgr.AdjustmentPriceJobMgr;
import com.pengsheng.eims.quartz.mgr.StockSummaryMgr;
import com.pengsheng.eims.quartz.mgr.WholesalePriceJobMgr;
import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.ExternalAccountParameterMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class AdSalesInInventoryMgrImpl implements AdSalesInInventoryMgr {

	private AdSalesInInventoryDao adSalesInInventoryDao;
	private CalDao calDao;
	private CustomerInfoDao customerInfoDao;
	private MemberUpGradeDao memberUpGradeDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private SystemParameterDao systemParameterDao;
	private UnitDao	unitDao;
	private ReportQuartzDao reportQuartzDao = null;
	private AdjustmentPriceJobMgr adjustmentPriceJobMgr;
	private AdcostPriceJobMgr adcostPriceJobMgr;
	private WholesalePriceJobMgr wholesalePriceJobMgr;
	private AdConsignProcessTakeMgr adConsignProcessTakeMgr;
	private StockSummaryMgr stockSummaryMgr;
	private GuitarManagementMgr guitarManagementMgr;
	private ExternalAccountParameterMgr externalAccountParameterMgr = null;
	private VoucherTallyMgr voucherTallyMgr = null;
	private List<VoucherTallyPo> voucherTallyList = null;
	private VoucherMgr voucherMgr = null;                       //Mgr接口
	private DepartmentsDao departmentsDao = null;
	private StockSummaryDao stockSummaryDao;
	private SystemParameterMgr systemParameterMgr;
	
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public StockSummaryDao getStockSummaryDao() {
		return stockSummaryDao;
	}

	public void setStockSummaryDao(StockSummaryDao stockSummaryDao) {
		this.stockSummaryDao = stockSummaryDao;
	}

	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}

	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}

	public VoucherMgr getVoucherMgr() {
		return voucherMgr;
	}

	public void setVoucherMgr(VoucherMgr voucherMgr) {
		this.voucherMgr = voucherMgr;
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

	public ExternalAccountParameterMgr getExternalAccountParameterMgr() {
		return externalAccountParameterMgr;
	}

	public void setExternalAccountParameterMgr(
			ExternalAccountParameterMgr externalAccountParameterMgr) {
		this.externalAccountParameterMgr = externalAccountParameterMgr;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public AdConsignProcessTakeMgr getAdConsignProcessTakeMgr() {
		return adConsignProcessTakeMgr;
	}

	public void setAdConsignProcessTakeMgr(
			AdConsignProcessTakeMgr adConsignProcessTakeMgr) {
		this.adConsignProcessTakeMgr = adConsignProcessTakeMgr;
	}

	public StockSummaryMgr getStockSummaryMgr() {
		return stockSummaryMgr;
	}

	public void setStockSummaryMgr(StockSummaryMgr stockSummaryMgr) {
		this.stockSummaryMgr = stockSummaryMgr;
	}

	public WholesalePriceJobMgr getWholesalePriceJobMgr() {
		return wholesalePriceJobMgr;
	}

	public void setWholesalePriceJobMgr(WholesalePriceJobMgr wholesalePriceJobMgr) {
		this.wholesalePriceJobMgr = wholesalePriceJobMgr;
	}

	public AdcostPriceJobMgr getAdcostPriceJobMgr() {
		return adcostPriceJobMgr;
	}

	public void setAdcostPriceJobMgr(AdcostPriceJobMgr adcostPriceJobMgr) {
		this.adcostPriceJobMgr = adcostPriceJobMgr;
	}

	public AdjustmentPriceJobMgr getAdjustmentPriceJobMgr() {
		return adjustmentPriceJobMgr;
	}

	public void setAdjustmentPriceJobMgr(AdjustmentPriceJobMgr adjustmentPriceJobMgr) {
		this.adjustmentPriceJobMgr = adjustmentPriceJobMgr;
	}

	public ReportQuartzDao getReportQuartzDao() {
		return reportQuartzDao;
	}

	public void setReportQuartzDao(ReportQuartzDao reportQuartzDao) {
		this.reportQuartzDao = reportQuartzDao;
	}

	public UnitDao getUnitDao() {
		return unitDao;
	}

	public void setUnitDao(UnitDao unitDao) {
		this.unitDao = unitDao;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public MemberUpGradeDao getMemberUpGradeDao() {
		return memberUpGradeDao;
	}

	public void setMemberUpGradeDao(MemberUpGradeDao memberUpGradeDao) {
		this.memberUpGradeDao = memberUpGradeDao;
	}

	public CalDao getCalDao() {
		return calDao;
	}

	public void setCalDao(CalDao calDao) {
		this.calDao = calDao;
	}
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}
	
	/**
	 * 汇总销售出库单
	 * 
	 */
	public void insertCollectSalesOutStorageBill(String bgnDate,String endDate){
		FquartzSwitchPo fspo = reportQuartzDao.getFquartzSwitchPo();
		if (Utility.getName(fspo.getFqsxsckhz()).equals("1")){
			adSalesInInventoryDao.collectSalesOutStorageBill(bgnDate,endDate);   // 按订金第一种方式汇总（基础版）
		}else if (Utility.getName(fspo.getFqsxsckhz()).equals("2")){
			adSalesInInventoryDao.collectSalesOutStorageBill_AppendArrears(bgnDate,endDate);  // 按订金第二种方式汇总（基础版）
		}else if (Utility.getName(fspo.getFqsxsckhz()).equals("3")){
			adSalesInInventoryDao.collectSalesOutStorageBill_YK(bgnDate,endDate);   // 按订金第一种方式汇总（眼科专用）
		}else if (Utility.getName(fspo.getFqsxsckhz()).equals("4")){
			adSalesInInventoryDao.collectSalesOutStorageBill_YK_AppendArrears(bgnDate,endDate);    // 按订金第二种方式汇总（眼科专用）
		}else{
			System.out.println("禁止汇总销售出库单的方式!");
		}
	}
	
	/**
	 * 客户批发调货汇总销售出库单、积分兑换汇总销售出库单
	 * 
	 */
	public void insertFromOtherBillToSalesOutStorageBill(String bgnDate,String endDate){
		adSalesInInventoryDao.insertFromOtherBillToSalesOutStorageBill(bgnDate,endDate);
	}

	/**
	 * 汇总收银员工作量统计
	 */
	public void insertCashierWorkload(String bgnDate,String endDate,QuartzLogPo logPo,String jkflag,String bqflag){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);
		
		if (jkflag.equals("1")){
			reportQuartzDao.deleteCashierWorkload(po);
			adSalesInInventoryDao.insertCashierWorkload(po);
		}
		
		if (bqflag.equals("1")){
			reportQuartzDao.deleteCashierWorkloadAppendArrears(po);
			adSalesInInventoryDao.insertCashierWorkloadAppendArrears(po);
		}
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 汇总挂号台工作量统计
	 */
	public void insertRegistrationDeskWorkload(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteRegistrationDeskWorkload(po);
		
		adSalesInInventoryDao.insertRegistrationDeskWorkload(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

	/**
	 * 检查人员工作量统计表（单店）
	 * 
	 */
	public void insertInspectPersonWorkload(String bgnDate,String endDate,QuartzLogPo logPo) {
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteInspectPersonWorkload(po);
		
		adSalesInInventoryDao.insertInspectPersonWorkload(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

	
	/**
	 * 取镜人员工作量统计表（单店）
	 * 
	 */
	public void insertGetBackEyeglassPersonWorkload(String bgnDate,String endDate,QuartzLogPo logPo) {
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteGetBackEyeglassPersonWorkload(po);
		
		adSalesInInventoryDao.insertGetBackEyeglassPersonWorkload(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

	
	/**
	 * 加工人员工作量统计（单店）
	 * 
	 */
	public void insertProcessWorkingStatisticsWorkload(String bgnDate,String endDate,QuartzLogPo logPo) {

		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteProcessWorkingStatisticsWorkload(po);
		
		adSalesInInventoryDao.insertProcessWorkingStatisticsWorkload(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

	/**
	 * 发料人员工作量统计表（单店）
	 * 
	 */
	public void insertSendMaterialWorkload(String bgnDate,String endDate,QuartzLogPo logPo) {
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteSendMaterialWorkload(po);
		
		adSalesInInventoryDao.insertSendMaterialWorkload(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}

	/**
	 * 营业员工作量统计表（单店）
	 * 
	 */
	public void insertSalesPersonQTWorkload(String bgnDate,String endDate,QuartzLogPo logPo,String jkflag,String bqflag) {
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		
		if (jkflag.equals("1")){
			reportQuartzDao.deleteSalesPersonQTWorkload(po);
			adSalesInInventoryDao.insertSalesPersonQTWorkload(po);
		}

		if (bqflag.equals("1")){
			reportQuartzDao.deleteSalesPersonQTWorkloadAppendArrears(po);
			adSalesInInventoryDao.insertSalesPersonQTWorkloadAppendArrears(po);
		}
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 商品销售统计表
	 */
	public void insertGoodsSalesAnalysis(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);
		reportQuartzDao.deleteGoodsSalesAnalysis(po);
		
		adSalesInInventoryDao.insertGoodsSalesAnalysis(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}

	}
	
	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesData(QuartzLogPo logPo){
		adSalesInInventoryDao.deleteTodaySalesData();
		adSalesInInventoryDao.deleteTodaySalesDataEntry();
		
		adSalesInInventoryDao.deleteTodaySalerCashierRecord();
		adSalesInInventoryDao.deleteTodaySalerCashierRecordAppendArrears();
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	
	/**
	 * 自动进行成本计算
	 */
	public void insertAutoCostAccountJob(String billDate,QuartzLogPo logPo){		

		this.insertSalesOutBillByDate(billDate,billDate,null);
		
		SystemParameterPo spo = systemParameterDao.getSystemParameterPo();
		FquartzSwitchPo fspo = reportQuartzDao.getFquartzSwitchPo();
		List<AutoCostAccountPo> acaList = null;		
		
		if (Utility.getName(spo.getFspcbjstype()).equals("1")){
			
			acaList = adSalesInInventoryDao.selCurrentAccountPeriod();
		
			insertAutoCostAccountAllCompany(acaList,fspo);   // 按所有公司进行成本计算

		}else{
			
			acaList = adSalesInInventoryDao.selCurrentAccountPeriodOneCompany();
			
			for (AutoCostAccountPo acapo : acaList){
				insertAutoCostAccountOneCompany(acapo,fspo);   // 按公司进行成本计算
			}
			
		}
				
		//重新转日销商品明细和商品周转率表的时英
		if (Utility.getName(spo.getFspcbjsscxzsy()).equals("2")){
			
			for (AutoCostAccountPo acapo : acaList){
				AutoCostAccountPo apo = adSalesInInventoryDao.getCurrentAccountPeriodDateArea(acapo.getLatcapaymentday());
				
				// 周转率
				insertGoodsStorageRevolveRate(apo.getLatcabgndate(),apo.getLatcaenddate(),null); 
				
				// 日销商品明细
				insertDaySalesEntry(apo.getLatcabgndate(),apo.getLatcaenddate(),null,"1","1");
			}
			System.out.println("重新转日销商品明细和商品周转率表的时英!");
		}
		
		System.out.println("自动进行成本计算完成!");
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);

	}
	
	private void insertAutoCostAccountAllCompany(List<AutoCostAccountPo> acaList,FquartzSwitchPo fspo){
		
		calDao.realCalStorage(acaList,Utility.getName(fspo.getFqscbjs()),"","1");
		
		calDao.autoCostAccountFinish(acaList,"");
		
		//自动创建销售成本凭证(西安波涛专用)
		if (Utility.getName(fspo.getFqscbjscjpz()).equals("2") && acaList.size() > 0){
			
			String[] array = getCreateSalesCostPriceVoucherDate();
			
			List<DepartmentsPo> departmentList = departmentsDao.getDepartments("1");
			for (DepartmentsPo departmentsPo : departmentList) {
			    createSalesCostPriceVoucher("301",Utility.getName(departmentsPo.getBdpdepartmentid()),Utility.getName(departmentsPo.getBdpdepartmentname()),array[0],array[1]);
			}
			
			//createSalesCostPriceVoucher("301","000","旗舰店");	
		}

	}
	
	private void insertAutoCostAccountOneCompany(AutoCostAccountPo acapo,FquartzSwitchPo fspo){

		List<AutoCostAccountPo> acaList = new ArrayList<AutoCostAccountPo>();		
		acaList.add(acapo);
		
		calDao.realCalStorage(acaList,Utility.getName(fspo.getFqscbjs()),acapo.getLatcacompanyid(),"1");

		calDao.autoCostAccountFinish(acaList,acapo.getLatcacompanyid());
		
	}
	
	/**
	 * Description：自动创建销售成本凭证
	 */
	private void createSalesCostPriceVoucher(String voucherTypeID,String dptid,String dptname,String bgnDate,String endDate){
		
		// 默认制单人、制单部门、商品销售日期、成本取值、重复成本计算是否判断凭证创建重复
		
		if (voucherTallyList == null){
			voucherTallyList = new ArrayList<VoucherTallyPo>();
		}else{
			voucherTallyList.clear();
		}
		
		String voucherID = "V"+GenerateNumber.getInstance().getGenerageNumber();
		String voucherDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
//		String bgnDate = "2014-06-26";    // 销售起始时间
//		String endDate = "2014-07-25";    // 销售截止时间
		
		VoucherPo vpo = new VoucherPo();
		vpo.setsLvvID(voucherID);
		vpo.setsLvvPersonID("0008");          // 制单人
		vpo.setsLvvCreateDptID("6");		  // 制单部门
		vpo.setsLvvDateLowerLimit(bgnDate);  // 起始日期
		vpo.setsLvvDateTopLimit(endDate);   // 截止日期
		
		vpo.setsLvvAuditStatue("0");      // 未审核
		vpo.setsLvvTypeID("2");		      // 部门
		vpo.setsLvvDate(voucherDate);	  // 凭证日期
		vpo.setsLvvVoucherTypeID(voucherTypeID);  // 凭证类型
		vpo.setsLvvRemark("自动转凭证");    // 备注
		vpo.setsLvvDepartmentID(dptid);    // 核算部门
		
		voucherTallyList = voucherTallyMgr.getVoucherTallyByID(vpo, (dptname + "--计算成本"));
		
		for (int j = 0; j < voucherTallyList.size(); j++){
			if (((VoucherTallyPo)voucherTallyList.get(j)).getsLvtsBalanceDirection().equalsIgnoreCase("j")){
				((VoucherTallyPo)voucherTallyList.get(j)).setsLvtvtDebitMoney(((VoucherTallyPo)voucherTallyList.get(j)).getsLvtvtMoney());
			}else{
				((VoucherTallyPo)voucherTallyList.get(j)).setsLvtvtLenderMoney(((VoucherTallyPo)voucherTallyList.get(j)).getsLvtvtMoney());
			}
		}
				
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(Utility.getName(vpo.getsLvvPersonID()));
		logPo.setsLogIP("");
		logPo.setsLogResult("V0402"); // 表示模块名称 
		logPo.setsLogOpID("1");    // 
		logPo.setsLogContent("自动创建销售成本凭证：" + voucherID + " !");

		for (int i = 0; i < voucherTallyList.size(); i++){
			voucherTallyList.get(i).setsLvtvtVoucherID(Utility.getName(voucherID));
		}
	
		voucherMgr.insertVoucherTally(vpo, voucherTallyList, logPo);
		
	}
	
	/**
	 * 验光师工作量统计表（单店）
	 */
	public void insertOptometryWorkload(String bgnDate,String endDate,QuartzLogPo logPo,String flag){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteOptometryWorkload(po);

		if (Utility.getName(flag).equals("1")){
			adSalesInInventoryDao.insertOptometryWorkload(po);
		}else{
			adSalesInInventoryDao.insertOptometryWorkload_Tr(po);
		}

		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 自动进行会员升级
	 */
	public void insertAutoCustomerUpGradeJob(QuartzLogPo logPo){
		
		CustomerInfoPo po = new CustomerInfoPo();
		List<CustomerInfoPo> customerInfoList = memberUpGradeDao.selectMemberUpGrade(po);
		
		for (int i = 0; i < customerInfoList.size(); i++) {
			CustomerInfoPo customerPo = new CustomerInfoPo();
			if(!"".equals(Utility.getName(customerInfoList.get(i).getSmecimemberid()))){
				customerPo.setSmecimemberid(Utility.getName(customerInfoList.get(i).getSmecimemberid()));
				CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(customerPo);
			
				CustomerInfoPo po2 = memberUpGradeDao.selectCustomerInfo(customerInfoPo);
				CustomerInfoPo po3 = memberUpGradeDao.selectUpgradeCardInfo(customerInfoPo);
				
				UpgradeRecordPo tmp = new UpgradeRecordPo();
				tmp.setSmecucurrentcardid(Utility.getName(po2.getSmecicardtype()));
				tmp.setSmecucurrentintegral(Utility.getName(po2.getSmeciintegral()));
				tmp.setSmeculastcardid(Utility.getName(po3.getSmecicardtype()));
								
				BigDecimal bg = new BigDecimal(Utility.getName(po2.getSmeciintegral()));
				BigDecimal bg2 = new BigDecimal(Utility.getName(po3.getSmeciintegral()));
				bg = bg.subtract(bg2);
				bg = bg.setScale(0, BigDecimal.ROUND_HALF_UP);
				
				if (!Utility.getName(bg2.toString()).equals("0")){
					tmp.setSmecuintegralchange("-"+Utility.getName(bg2.toString()));
				}else{
					tmp.setSmecuintegralchange("0");
				}
				if (bg.intValue() < 0){
					tmp.setSmeculastintegral("0");
				}else{
					tmp.setSmeculastintegral(bg.toString());
				}
				
				tmp.setSmecucustomerid(Utility.getName(customerInfoPo.getSmecicustomerid()));
				tmp.setSmecumemberid(Utility.getName(customerInfoPo.getSmecimemberid()));
				tmp.setSmecuflag("3");
				tmp.setSmecushopcode("600");
				tmp.setSmecupersonid("admin");
				
				memberUpGradeDao.insertUpGradeRecord(tmp);
				memberUpGradeDao.updateCustomerInfo(tmp);
				
				memberUpGradeDao.updateMemberUpGrade(tmp);
			}			
		}
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	
	/**
	 * 日销售汇总表统计
	 */
	public void insertDayCollect(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteDayCollect(po);
		
		adSalesInInventoryDao.insertDayCollect(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 日商品类别销售汇总表统计
	 */
	public void insertDayCollectEntry(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteDayCollectEntry(po);
		
		adSalesInInventoryDao.insertDayCollectEntry(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 日商品类别区间销售汇总表统计
	 */
	public void insertDayCollectAreaEntry(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteDayCollectAreaEntry(po);
		
		List<SalesAreaPo> saList = adSalesInInventoryDao.getDayCollectArea();
		int count = saList.size();
		if (count > 0){
			adSalesInInventoryDao.insertDayCollectAreaEntry(po,saList);
		}
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 日商品销售明细表统计
	 */
	public void insertDaySalesEntry(String bgnDate,String endDate,QuartzLogPo logPo,String jkfalg,String bqflag){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		
		if (jkfalg.equals("1")){
			reportQuartzDao.deleteDaySalesEntry(po);
			reportQuartzDao.deleteDayBrandSalesEntry(po);
			adSalesInInventoryDao.insertDaySalesEntry(po);	
		}
		
		if (bqflag.equals("1")){
			reportQuartzDao.deleteDaySalesEntryAppendArrears(po);
			adSalesInInventoryDao.insertDaySalesEntryAppendArrears(po);	
		}

		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 日品种销售明细表统计
	 */
	public void insertDayBrandSalesEntry(String bgnDate,String endDate,QuartzLogPo logPo,String jkfalg,String bqflag){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		
		reportQuartzDao.deleteDayBrandSalesEntry(po);
		adSalesInInventoryDao.insertDayBrandSalesEntry(po);	
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 判断套餐是否过期
	 */
	public void updateSetMealOverdue(String date,QuartzLogPo logPo){
		adSalesInInventoryDao.updateSetMealOverdue(date);
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}

	/**
	 * 销售产品同期综合对比分析
	 */
	public void insertStoreCustomerFlowEntry(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		reportQuartzDao.deleteStoreCustomerFlowEntry(po);
		
		adSalesInInventoryDao.insertStoreCustomerFlowEntry(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}

	}
	
	/**
	 * 商品调价定时器
	 */
	public void updateAadjustmentPriceEffective(String date,QuartzLogPo logPo){		
		SystemParameterPo spo = systemParameterMgr.getSystemParameterPo();
		adjustmentPriceJobMgr.updateAadjustmentPriceEffective(date,logPo,spo);
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	
	/**
	 * 成本调价定时器
	 */
	public void updateAdcostPriceEffective(String date,QuartzLogPo logPo){
		adcostPriceJobMgr.updateAdcostPriceEffective(date,logPo);
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	
	/**
	 * 商品批发调价定时器
	 */
	public void updateWholesalePriceEffective(String date,QuartzLogPo logPo){
		wholesalePriceJobMgr.updateWholesalePriceEffective(date,logPo);
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	
	/**
	 * 委外收货定时器
	 */
	public void updateAdConsignProcessTakeJob(String date,QuartzLogPo logPo){
		adConsignProcessTakeMgr.insertInventory(logPo);
	}
	
	/**
	 * 删除时英执行日志
	 */
	public void updateStockSummary(QuartzLogPo logPo){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String billDate = currMouthFirstDay.format(calendar.getTime());		
		System.out.println("删除时英执行日志日期:"+billDate);
	
		//删除时英执行日志
		stockSummaryMgr.insertSalesOutBill(billDate,logPo);
	}
	
	/**
	 * 商品库存周转率统计表（按库存）
	 */
	public void insertGoodsStorageRevolveRate(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		
		reportQuartzDao.deleteGoodsStorageRevolveRate(po);
		reportQuartzDao.deleteBrandStorageRevolveRate(po);
		
		adSalesInInventoryDao.insertGoodsStorageRevolveRate(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 品种库存周转率统计表（按库存）
	 */
	public void insertBrandStorageRevolveRate(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		
		reportQuartzDao.deleteBrandStorageRevolveRate(po);
		
		adSalesInInventoryDao.insertBrandStorageRevolveRate(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 商品库存周转率统计表（按单据）
	 */
	public void insertGoodsStorageRevolveRateByBill(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);	
		
		reportQuartzDao.deleteGoodsStorageRevolveRateByBill(po);
		reportQuartzDao.deleteBrandStorageRevolveRateByBill(po);
		
		adSalesInInventoryDao.insertGoodsStorageRevolveRateByBill(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	
	/**
	 * 新增时英日志
	 */
	public void insertQuartzExecLog(QuartzLogPo logPo){
		adSalesInInventoryDao.insertQuartzExecLog(logPo);
	}
	
	/**
	 * 修改时英日志
	 */
	public void updateQuartzExecLog(QuartzLogPo logPo){
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	
	/**
	 * 查看未执行的任务
	 */
	public List<QuartzLogPo> getQuartzExecLog(QuartzLogPo po){
		return adSalesInInventoryDao.getQuartzExecLog(po);
	}
		
	/**
	 * 按商品类型汇总库存
	 */
	public void insertCollectStealthStorage(){
		adSalesInInventoryDao.insertCollectGoodsTypeStorage();
		adSalesInInventoryDao.insertCollectZZLStorage();
		adSalesInInventoryDao.insertCollectZZLStorageByBill("","");
		
		stockSummaryDao.strogeBeginningClear();
		stockSummaryDao.strogeChangeClear();
		stockSummaryDao.strogeBeginningSummary();
	}
	
	/**
	 * 汇总客单价统计表
	 */
	public void insertPerCustomer(String bgnDate,String endDate,QuartzLogPo logPo){
		
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);		
		reportQuartzDao.deletePerCustomer(po);
		
		adSalesInInventoryDao.insertPerCustomer(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 根据当前账期计算自动创建凭证数据的日期
	 */
	private String[] getCreateSalesCostPriceVoucherDate(){
		String[] array = adSalesInInventoryDao.getCurrentAccountPeriodDate().split(",");
		
		if (array == null || array.length == 0){		    
			array = new String[2];
			array[0] = "";
			array[1] = "";
		}
		
		return array;
	}
	/**
	 * 分店销售指南表
	 */
	public void collectEachShopSalesGuide(String bgnDate,String endDate,QuartzLogPo logPo){
	
		ModulePo po = new ModulePo();
		po.setReportBgnDate(bgnDate);
		po.setReportEndDate(endDate);		
		reportQuartzDao.deleteEachShopSalesGuide(po);
		
		adSalesInInventoryDao.collectEachShopSalesGuide(po);		
		adSalesInInventoryDao.collectStealthShopSalesGuide(po);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
		
	}
	
	/**
	 * 自动关账和创建临时凭证表
	 */
	public void switchAmount(){
		adSalesInInventoryDao.switchAmount();
		adSalesInInventoryDao.createTempVoucherTab();
	}
	
	/**
	 * 按日期、仓位、单据类型汇总历史库存
	 */
	public void updateStroageByDateAndBillType(String bgnDate,String endDate,QuartzLogPo logPo){
		adSalesInInventoryDao.updateStroageByDateAndBillType(bgnDate,endDate);
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}
	}
	
	
	/**
	 * 汇总销售出库
	 */
	public void insertSalesOutBillByDate(String bgnDate,String endDate,QuartzLogPo logPo){
		adSalesInInventoryDao.deleteSalesOutBillByDate(bgnDate,endDate);
		
		this.insertCollectSalesOutStorageBill(bgnDate,endDate);  //汇总销售出库单
		this.insertFromOtherBillToSalesOutStorageBill(bgnDate,endDate);  //积分兑换汇总销售出库单
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}

	}
	
}
