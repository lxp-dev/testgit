package com.pengsheng.eims.quartz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.sales.persistence.SalesAreaPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class AdSalesInInventoryDaoImpl extends BaseJdbcDaoSupport implements AdSalesInInventoryDao {

	/**
	 * 取门店号
	 * @return
	 * 修改记录: SZK
	 */
	public List<DepartmentsPo> getDepartmentList(String date) {
		// TODO Auto-generated method stub
				
		//查询条件销售单(补交欠款日期为当天 or (销售日期为当天 and 欠费日期为空)) and 已缴费 and 未欠费 
		//union all 销售退单 条件 (退款为当天 and 退费标识为1) 
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SB_ShopCode as bdpdepartmentid from uview_SalesBasic ");
		buffer.append("where convert(varchar(10) , S_SE_SB_PosDatetime , 23 ) = convert(varchar(10) ,? , 23 ) ");
		buffer.append("and S_SE_SB_ValueFlag = '1' ");
		buffer.append("group by S_SE_SB_ShopCode ");
		buffer.append("union  ");
		buffer.append("select S_SE_SB_ShopCode as bdpdepartmentid from uview_SalesBasic  ");
		buffer.append("where convert(varchar(10) , S_SE_SB_WithdrawDate , 23 ) = convert(varchar(10) ,?, 23 ) ");
		buffer.append("and S_SE_SB_WithdrawFlag = '1' and S_SE_SB_ValueFlag = '1' ");
		buffer.append("group by S_SE_SB_ShopCode ");
		buffer.append("union  ");
		buffer.append("select S_CR_RD_ShopCode as bdpdepartmentid from S_CR_RegisteredDetails  ");
		buffer.append("where convert(varchar(10) , S_CR_RD_CasherDate , 23 ) = convert(varchar(10) ,?, 23 ) ");
		buffer.append("and S_CR_RD_Flag = '1' ");
		
		params.add(date);
		params.add(date);
		params.add(date);
		
		return queryForObjectList(buffer.toString() ,params.toArray(), DepartmentsPo.class);		
	}
	
	/**
	 * 取门店号
	 * @return
	 * 修改记录: SZK
	 */
	public List<DepartmentsPo> getAppendArrearsDepartmentList(String date) {
		// TODO Auto-generated method stub
				
		//查询条件销售单(补交欠款日期为当天 or (销售日期为当天 and 欠费日期为空)) and 已缴费 and 未欠费 
		//union all 销售退单 条件 (退款为当天 and 退费标识为1) 
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SB_ShopCode as bdpdepartmentid from uview_SalesBasic ");
		buffer.append("where convert(varchar(10) , S_SE_SB_PosDatetime , 23 ) = convert(varchar(10) ,? , 23 ) ");
		buffer.append("and S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag='0' and S_SE_SB_ArrearsAppendDate is null ");
		buffer.append("group by S_SE_SB_ShopCode ");
		buffer.append("union  ");
		buffer.append("select S_SE_SB_ShopCode as bdpdepartmentid from uview_SalesBasic ");
		buffer.append("where convert(varchar(10) , S_SE_SB_ArrearsAppendDate , 23 ) = convert(varchar(10) ,? , 23 ) ");
		buffer.append("and S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag='0' ");
		buffer.append("group by S_SE_SB_ShopCode ");
		buffer.append("union  ");
		buffer.append("select S_SE_SB_ShopCode as bdpdepartmentid from uview_SalesBasic  ");
		buffer.append("where convert(varchar(10) , S_SE_SB_WithdrawDate , 23 ) = convert(varchar(10) ,?, 23 ) ");
		buffer.append("and S_SE_SB_WithdrawFlag = '1' and S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag='0' and S_SE_SB_ArrearsAppendDate is null ");
		buffer.append("group by S_SE_SB_ShopCode ");
		buffer.append("union  ");
		buffer.append("select S_SE_SB_ShopCode as bdpdepartmentid from uview_SalesBasic  ");
		buffer.append("where convert(varchar(10) , S_SE_SB_WithdrawDate , 23 ) = convert(varchar(10) ,?, 23 ) ");
		buffer.append("and S_SE_SB_WithdrawFlag = '1' and S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag='0' and S_SE_SB_ArrearsAppendDate is not null ");
		buffer.append("group by S_SE_SB_ShopCode ");
		buffer.append("union  ");
		buffer.append("select S_CR_RD_ShopCode as bdpdepartmentid from S_CR_RegisteredDetails  ");
		buffer.append("where convert(varchar(10) , S_CR_RD_CasherDate , 23 ) = convert(varchar(10) ,?, 23 ) ");
		buffer.append("and S_CR_RD_Flag = '1' ");
		
		params.add(date);
		params.add(date);
		params.add(date);
		params.add(date);
		params.add(date);
		
		return queryForObjectList(buffer.toString() ,params.toArray(), DepartmentsPo.class);		
	}
	
	/**
	 * 取所有加工部门
	 * @return
	 * 修改记录: SZK
	 */
	public List<DepartmentsPo> getProcessWorkingDepartmentList() {

		StringBuffer buffer = new StringBuffer();		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid from B_Departments where B_DP_Type='2' ");
		
		return queryForObjectList(buffer.toString() , null , DepartmentsPo.class);
		
	}

	/**
	 * 取所有发料部门
	 * @return
	 * 修改记录: SZK
	 */
	public List<DepartmentsPo> getSendMaterialDepartmentList(){

		StringBuffer buffer = new StringBuffer();		
		buffer.append("select B_DP_DepartmentID as bdpdepartmentid from B_Departments ");
		
		return queryForObjectList(buffer.toString() , null , DepartmentsPo.class);
	}
	
	/**
	 * 取销售详细信息
	 * @return
	 */
	public List<InventoryEntryPo> getSalesEntry(String departmentid) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SD_SalesID as cstiebillid , ");
		buffer.append("	S_SE_SD_SalesItemID as cstiegoodsid , ");
		buffer.append("	S_SE_SD_Number as cstiegoodsquantity , ");
		buffer.append("	0 as cstienottaxrate , ");
		buffer.append("	0 as cstienottaxrateamount , ");
		buffer.append("	B_GI_TaxRate as cstietaxrate , ");
		buffer.append("	B_GI_CostPrice as cstiecostprice , ");
		buffer.append("	0 as cstietaxamount , ");
		buffer.append("	isnull(S_SE_SD_SalesValue , 0) as cstiecostpriceamount , ");
		buffer.append("	S_SE_SD_StockId as cstieoutstockid , ");
		
		buffer.append("case ");
		buffer.append("	when S_SE_SD_ItemID = '' or S_SE_SD_ItemID is null ");
		buffer.append("		then replace(S_SE_SD_SalesItemID , '.' , '') + '00000000' ");
		buffer.append("	when S_SE_SD_ItemID is not null ");
		buffer.append("		then S_SE_SD_ItemID ");
		buffer.append("	end as cstiebarcode ");
		
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic ");
		buffer.append("	on S_SE_SalesBasic.S_SE_SB_SalesID =  S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("left join B_GoodsInfo ");//inner 改为 left
		buffer.append("	on B_GoodsInfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		
		buffer.append("where convert(varchar(10) , S_SE_SB_ArrearsAppendDate , 23 ) = convert(varchar(10) , getdate() , 23 ) ");
		buffer.append("	or (convert(varchar(10) , S_SE_SB_PosDatetime , 23 ) = convert(varchar(10) , getdate() , 23 ) ");//S_SE_SB_SalesDatetime改为S_SE_SB_PosDatetime
		buffer.append("	and convert(varchar(10) , S_SE_SB_ArrearsDate , 23 ) is null ) ");
		buffer.append("	and S_SE_SB_ValueFlag = '1' and S_SE_SB_CheckoutFlag = '0' ");
		buffer.append("	and subString(S_SE_SD_SalesItemID , 3, 2) <> 'zz' and S_SE_SB_WithdrawFlag <> '1'");//追加S_SE_SB_WithdrawFlag
		buffer.append("	and S_SE_SB_ShopCode = ? ");
		
		buffer.append("union all ");
		
		buffer.append("select S_SE_SD_SalesID as cstiebillid , ");
		buffer.append("	S_SE_SD_SalesItemID as cstiegoodsid , ");
		buffer.append("	-isnull(S_SE_SD_Number,0) as cstiegoodsquantity , ");
		buffer.append("	0 as cstienottaxrate , ");
		buffer.append("	0 as cstienottaxrateamount , ");
		buffer.append("	B_GI_TaxRate as cstietaxrate , ");
		buffer.append("	isnull(B_GI_CostPrice,0) as cstiecostprice , ");
		buffer.append("	0 as cstietaxamount , ");
		buffer.append("	-isnull(S_SE_SD_SalesValue , 0) as cstiecostpriceamount , ");
		buffer.append("	S_SE_SD_StockId as cstieoutstockid , ");
		
		buffer.append("case ");
		buffer.append("	when S_SE_SD_ItemID = '' or S_SE_SD_ItemID is null ");
		buffer.append("		then replace(S_SE_SD_SalesItemID , '.' , '') + '00000000' ");
		buffer.append("	when S_SE_SD_ItemID is not null ");
		buffer.append("		then S_SE_SD_ItemID ");
		buffer.append("	end as cstiebarcode ");
		
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic ");
		buffer.append("	on S_SE_SalesBasic.S_SE_SB_SalesID =  S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("left join B_GoodsInfo "); //inner 改为 left
		buffer.append("	on B_GoodsInfo.B_GI_GoodsID = S_SE_SalesDetail.S_SE_SD_SalesItemID ");
		
		buffer.append("where S_SE_SB_WithdrawFlag = '1' ");
		buffer.append("	and subString(S_SE_SD_SalesItemID , 3, 2) <> 'zz' ");
		buffer.append("	and convert(varchar(10) , S_SE_SB_WithdrawDate , 23 ) = convert(varchar(10) , getdate() , 23 ) ");
		buffer.append("	and S_SE_SB_ShopCode = ? ");
		
		params.add(departmentid);
		params.add(departmentid);
		
		return queryForObjectList(buffer.toString() , params.toArray() , InventoryEntryPo.class);
	}
	
	
	/**
	 * 将销售基表数据汇总到业务主表
	 * @param billID
	 */
	public void insertSalesInInventory(String billID , String departmentid) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_ST_Inventory (C_ST_I_BillID , C_ST_I_BillTypeId , C_ST_I_billDate , ");
		buffer.append("C_ST_I_GoodsCategory , C_ST_I_DepartmentId , ");
		buffer.append("C_ST_I_AuditState , C_ST_I_FinanceAuditState , C_ST_I_AuditPerson , C_ST_I_FinanceAuditPerson , ");
		buffer.append("C_ST_I_InvoiceState , C_ST_I_SupplierId ) ");
		buffer.append("values( ? , '3' , getdate() , '20' , ? , '1' , '1' , 'cwb001' , 'cwb001' , '0' , ? ) ");
		
		params.add(billID);
		params.add(departmentid);
		params.add(departmentid);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}

	/**
	 * 将销售明细表数据汇总到业务明细表
	 * @param billID
	 */
	public void insertSalesInInventoryEntry(InventoryEntryPo inventoryEntryPo , String billID , String departmentid) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into C_ST_InventoryEntry ");
		buffer.append("values (? , ");//主键
		buffer.append("? , ");   //单据号
		buffer.append("? , ");   //商品代码
		buffer.append("? , ");   //商品数量
		buffer.append("'0' , "); //单位成本
		buffer.append("'0' , "); //成本合计
		buffer.append("? , ");   //税率
		buffer.append("? , ");   //含税单价
		buffer.append("'0' , "); //税额合计
		buffer.append("? , ");   //价税合计
		buffer.append("'' , ");  //收入仓位
		buffer.append("? , ");   //发出仓位
		buffer.append("? , ");   //条码
		buffer.append("getdate() , ");
		buffer.append("? , ");   //备注       存放销售单号
		buffer.append("'0' , ");
		buffer.append("'0' ) ");
		
		params.add(this.uuid.generate());                         //主键
		params.add(billID);                                       //单据号
		params.add(inventoryEntryPo.getCstiegoodsid());           //商品代码
		params.add(inventoryEntryPo.getCstiegoodsquantity());     //商品数量
		params.add(inventoryEntryPo.getCstietaxrate());           //税率
		params.add(inventoryEntryPo.getCstiecostprice());         //含税单价
		params.add(inventoryEntryPo.getCstiecostpriceamount());   //价税合计     
		params.add(inventoryEntryPo.getCstieoutstockid());        //发出仓位
		params.add(inventoryEntryPo.getCstiebarcode());           //条码
		params.add(inventoryEntryPo.getCstiebillid());            //备注       存放销售单号
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 汇总销售出库单
	 * 
	 */
	public void collectSalesOutStorageBill(String bgnDate,String endDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_collectSalesOutStorageBill ?,? ");
		
		params.add(bgnDate);
		params.add(endDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void collectSalesOutStorageBill_AppendArrears(String bgnDate,String endDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_collectSalesOutStorageBill_AppendArrears ?,? ");
		
		params.add(bgnDate);
		params.add(endDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void collectSalesOutStorageBill_YK_AppendArrears(String bgnDate,String endDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec collectSalesOutStorageBill_YK_AppendArrears ");
		
		//params.add(date);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void collectSalesOutStorageBill_YK(String bgnDate,String endDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_collectSalesOutStorageBill_YK ?,? ");
		
		params.add(bgnDate);
		params.add(endDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 客户批发调货汇总销售出库单、积分兑换汇总销售出库单
	 * 
	 */
	public void insertFromOtherBillToSalesOutStorageBill(String bgnDate,String endDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_FromIntegralExchangeToSalesOutStorage ?,? ");
		
		params.add(bgnDate);
		params.add(endDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
	/**
	 * 检查人员工作量统计表（单店）
	 * 
	 */
	public void insertInspectPerson(String departmentId,String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec sp_inspectPersonOnlyStoreQuartz ?,?,? ");
		params.add(departmentId); 
		params.add(date); 
		params.add(date); 
		getJdbcTemplate().update(buffer.toString(), params.toArray()); 

	}
		
	/**
	 * 汇总收银员工作量统计
	 */
	public void insertCashierWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_CashierQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 汇总收银员工作量统计
	 */
	public void insertCashierWorkloadAppendArrears(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_CashierQuartz_AppendArrears ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 汇总挂号台工作量统计
	 */
	public void insertRegistrationDeskWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_registrationDeskQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	/**
	 * 检查人员工作量统计表（单店）
	 * 
	 */

	public void insertInspectPersonWorkload(ModulePo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_inspectPersonQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());	
	}



	/**
	 * 取镜人员工作量统计表（单店）
	 * 
	 */
	public void insertGetBackEyeglassPersonWorkload(ModulePo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_getBackEyeglassPersonQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}


	/**
	 * 加工人员工作量统计（单店）
	 * 
	 */

	public void insertProcessWorkingStatisticsWorkload(ModulePo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_processWorkingQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}


	/**
	 * 发料人员工作量统计表（单店）
	 * 
	 */

	public void insertSendMaterialWorkload(ModulePo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_sendMaterialQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}

	/**
	 * 营业员工作量统计表（单店）
	 * 
	 */
	public void insertSalesPersonQTWorkload(ModulePo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_SalesPersonQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 营业员工作量统计表（单店）
	 * 
	 */
	public void insertSalesPersonQTWorkloadAppendArrears(ModulePo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_SalesPersonQuartz_AppendArrears ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	/**
	 * 商品销售统计表
	 */
	public void insertGoodsSalesAnalysis(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_SalesPerspectiveAnalysisQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesData(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from S_SE_SalesBasic_Today where convert(varchar(10),S_SE_SB_PosDatetime,120) < convert(varchar(10),getdate(),120) ");
		
		buffer.append("delete from S_SE_SalesBasic_Today where convert(varchar(10),S_SE_SB_WithdrawDate,120) < convert(varchar(10),getdate(),120) ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 清空当日销售数据
	 */
	public void deleteTodaySalesDataEntry(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from S_SE_SalesDetail_Today where S_SE_SD_SalesID not in (select S_SE_SB_SalesID from S_SE_SalesBasic_Today) ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 自动进行成本计算
	 */
	public int autoCostAccountJob(String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(L_AT_CA_ID) from L_AT_AutoCostAccount where L_AT_CA_PaymentDay=? and L_AT_CA_Flag='0' ");
		
		params.add(date); 
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	public List<AutoCostAccountPo> selCurrentAccountPeriod(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct L_AT_CA_PaymentDay as latcapaymentday from L_AT_AutoCostAccount where isnull(L_AT_CA_CompanyID,'') = '' and L_AT_CA_Flag = '0' order by L_AT_CA_PaymentDay ");	
		
		return queryForObjectList(buffer.toString() , params.toArray() , AutoCostAccountPo.class);
	}
	
	/**
	 * 自动进行成本计算完成
	 */
	public void autoCostAccountFinish(String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update L_AT_AutoCostAccount set L_AT_CA_ExecDate=getdate(),L_AT_CA_Flag='1' where L_AT_CA_PaymentDay=? ");
		
		params.add(date); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 验光师工作量统计表（单店）
	 * 
	 */
	public void insertOptometryWorkload(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_optometryQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertOptometryWorkload_Tr(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_bjtr_optometryQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 日销售汇总表统计
	 * 
	 */
	public void insertDayCollect(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_getSalseCollectQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 日商品类别销售汇总表统计
	 * 
	 */
	public void insertDayCollectEntry(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_getSalseGoodsCategoryQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 日商品类别区间销售汇总表统计
	 * 
	 */
	public void insertDayCollectAreaEntry(ModulePo po,List<SalesAreaPo> saList){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (SalesAreaPo sapo : saList){
			buffer.append("exec usp_getSalseGoodsCategoryAreaQuartz ?,?,?,?,? ");
			
			params.add(Utility.getName(po.getReportBgnDate()));  
			params.add(Utility.getName(po.getReportEndDate()));
			params.add(Utility.getName(sapo.getRsapricemin()));
			params.add(Utility.getName(sapo.getRsapricemax()));
			params.add(Utility.getName(sapo.getRsaorderstype()));
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取【日商品类别区间销售汇总表】中价格区间
	 * 
	 */
	public List<SalesAreaPo> getDayCollectArea(){

		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select distinct R_RC_SA_PriceMin as rsapricemin,isnull(R_RC_SA_PriceMax,'') as rsapricemax,isnull(R_RC_SA_SalesType,'') as rsaorderstype from R_RC_SalesArea where isnull(R_RC_SA_SalesType,'')<>'' ");
		
		return queryForObjectList(buffer.toString() , null , SalesAreaPo.class);
	}
	
	/**
	 * 价位段销售分析报表
	 */
	public void insertDayCollectSalesPriceAreaEntry(String date,String departmentID){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_getSalsePriceAreaQuartz ?,?,? ");
		
		params.add(departmentID);  
		params.add(date);  
		params.add(date);  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 日商品销售明细表统计
	 * 
	 */
	public void insertDaySalesEntry(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" exec usp_getSalseGoodsEntryQuartz ?,? ");
		buffer.append(" exec usp_getSalseBrandEntryQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 日品种销售明细表统计
	 * 
	 */
	public void insertDayBrandSalesEntry(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_getSalseBrandEntryQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 日商品销售明细表统计(补齐)
	 * 
	 */
	public void insertDaySalesEntryAppendArrears(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_getSalseGoodsEntryQuartz_AppendArrears ?,? ");
 
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
	
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 刷新商品进销存表加权平均成本
	 * 
	 */
	public void updateGoodsInOrOutStorage(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update R_IO_GoodsInOrOutAll set R_IO_GIO_AverageNotTaxRate=?,R_IO_GIO_OutAvgNotTaxRate=cast((R_IO_GIO_GoodsOutNum * ?) as numeric(18,2)),R_IO_GIO_Flag='1' where R_IO_GIO_Flag='0' and R_IO_GIO_GoodsID=? ");

		params.add(Utility.getName(po.getBgiaveragenotnaxrate()));
		params.add(Utility.getName(po.getBgiaveragenotnaxrate()));
		params.add(Utility.getName(po.getBgigoodsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 刷新商品进销存表加权平均成本（按部门）
	 * 
	 */
	public void updateGoodsInOrOutStorageByDpt(GoodsInfoPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update R_IO_GoodsInOrOutByDpt set R_IO_GIO_AverageNotTaxRate=?,R_IO_GIO_OutAvgNotTaxRate=cast((R_IO_GIO_GoodsOutNum * ?) as numeric(18,2)),R_IO_GIO_Flag='1' where R_IO_GIO_Flag='0' and R_IO_GIO_GoodsID=? ");

		params.add(Utility.getName(po.getBgiaveragenotnaxrate()));
		params.add(Utility.getName(po.getBgiaveragenotnaxrate()));
		params.add(Utility.getName(po.getBgigoodsid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 汇总商品进销存表数据
	 * 
	 */
	public void insertCollectGoodsInOrOutStorage(String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_GoodsInOrOutStorageCollect ?,? ");

		params.add(date);
		params.add(date);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 判断套餐是否过期
	 */
	public void updateSetMealOverdue(String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_UpdateSetMealOverdue ? ");

		params.add(date);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		
	}

	/**
	 * 销售产品同期综合对比分析(隐形镜片分析)
	 */
	public void insertStoreCustomerFlowEntry(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_StoreCustomerFlowQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 商品库存周转率统计表
	 */
	public void insertGoodsStorageRevolveRate(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" exec usp_GoodsStorageRevolveRateQuartz ?,? ");
		buffer.append(" exec usp_BrandStorageRevolveRateQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));
		params.add(Utility.getName(po.getReportEndDate()));
		
		params.add(Utility.getName(po.getReportBgnDate()));
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 品种库存周转率统计表
	 */
	public void insertBrandStorageRevolveRate(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_BrandStorageRevolveRateQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 商品库存周转率统计表
	 */
	public void insertGoodsStorageRevolveRateTemp(String date){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_GoodsStorageRevolveRateTempQuartz ?,? ");

		params.add(date);
		params.add(date);  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 商品库存周转率统计表按单据
	 */
	public void insertGoodsStorageRevolveRateBill(String date){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_GoodsStorageRevolveRateBillQuartz ?,? ");

		params.add(date);
		params.add(date);  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 商品库存周转率统计表按单据
	 */
	public void insertGoodsStorageRevolveRateBillTemp(String date){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_GoodsStorageRevolveRateBillTempQuartz ?,? ");

		params.add(date);
		params.add(date);  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
		
	/**
	 * 新增时英日志
	 */
	public void insertQuartzExecLog(QuartzLogPo logPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into Sys_QE_LR_QuartzLog (Sys_QE_LR_ID,Sys_QE_LR_QuartzID,Sys_QE_LR_ExecDate,Sys_QE_LR_EndDate,Sys_QE_LR_Date) values(?,?,getdate(),NULL,?) ");

		params.add(Utility.getName(logPo.getSysqllrid()));
		params.add(Utility.getName(logPo.getSysqllrquartzid()));
		params.add(Utility.getName(logPo.getSysqllrdate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新时英日志
	 */
	public void updateQuartzExecLog(QuartzLogPo logPo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update top (1) Sys_QE_LR_QuartzLog set Sys_QE_LR_EndDate = getdate() where Sys_QE_LR_ID = ? ");

		params.add(Utility.getName(logPo.getSysqllrid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查看未执行的任务
	 */
	public List<QuartzLogPo> getQuartzExecLog(QuartzLogPo logPo){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();		

		sb.append("declare @bgndate varchar(10),@enddate varchar(10) ");
		sb.append("select @bgndate = convert(varchar(10),dateadd(MONTH,-1,getdate()),120) ");
		sb.append("set @enddate = convert(varchar(10),getdate() - 1,120) ");

		sb.append(" select qubudate as sysqllrdate,rptname as sysqllrquartzname,rptid as sysqllrquartzid,Sys_QE_LR_ExecDate as sysqllrbgndate,Sys_QE_LR_EndDate as sysqllrenddate from ( ");
		sb.append("	select convert(varchar(10),DATEADD(DAY,b.number,@bgndate),120) as qubudate,Sys_ReportName as rptname,Sys_ReportID as rptid ");
		sb.append("	 from master..spt_values b cross join SYS_ReportQuartzInfo ");
		sb.append("	 WHERE b.type='P' AND b.number BETWEEN 0 AND DATEDIFF(day,@bgndate,@enddate) and Sys_Flag='1' ");
		sb.append(")temp left join Sys_QE_LR_QuartzLog on rptid=Sys_QE_LR_QuartzID and qubudate=Sys_QE_LR_Date where 1=1 ");	
		sb.append(" and rptid = ? and Sys_QE_LR_EndDate is null order by qubudate ");
		
		params.add(Utility.getName(logPo.getSysqllrquartzid()));
		
		return queryForObjectList(sb.toString(), params.toArray(), QuartzLogPo.class);
	}
	
	/**
	 * 配镜单汇总生成采购收货单
	 */
	public List<SalesDetailPo> getSalesDetailList(String flag){

		StringBuffer sb = new StringBuffer();	

		sb.append("select S_SE_SD_SalesItemID as ssesdsalesitemid,(case isnull(S_SE_SD_ItemID,'') when '' then (replace(S_SE_SD_SalesItemID,'.','')+'00000000') else S_SE_SD_ItemID end) as ssesditemid,S_SE_SD_StockId as ssesdstockid,S_SE_SD_InStockId as ssesdinstockid,sum(S_SE_SD_Number) as ssesdnumber,B_GI_TaxRate as ssesdtaxRate, ");
		sb.append("       S_SE_SD_UnitPrice as ssesdunitprice,S_SE_SD_CostsPrive as ssesdcostsprive,isnull(S_SE_SD_Guaranteeperiod,'') as ssesdguaranteeperiod,isnull(S_SE_SD_Batch,'') as ssesdbatch,B_GI_SupplierID as ssesdsupplierid ");
		sb.append(" from S_SE_SalesDetail inner join B_GoodsInfo on S_SE_SD_SalesItemID=B_GI_GoodsID ");
		sb.append("      inner join S_SE_SalesBasic on S_SE_SD_SalesID=S_SE_SB_SalesID ");
		sb.append(" where 1=1 and B_GI_SupplierID <> 'ZZ' ");
		if (flag.equals("1")){
			sb.append(" and isnull(S_SE_SD_IsPurchaseCollect,'0')='0' ");
		}else{
			sb.append(" and S_SE_SB_WithdrawFlag = '1' and isnull(S_SE_SD_IsReturnPurchaseCollect,'0')='0' ");
		}
		sb.append(" group by S_SE_SD_SalesItemID,S_SE_SD_ItemID,S_SE_SD_StockId,S_SE_SD_InStockId,B_GI_TaxRate,S_SE_SD_UnitPrice, ");
		sb.append("          S_SE_SD_CostsPrive,isnull(S_SE_SD_Guaranteeperiod,''),isnull(S_SE_SD_Batch,''),B_GI_SupplierID ");		
		if (flag.equals("1")){
			sb.append(" order by S_SE_SD_SalesItemID ");
		}else{
			sb.append(" order by B_GI_SupplierID ");
		}
		
		return queryForObjectList(sb.toString(),null, SalesDetailPo.class);
	}
	
	/**
	 * 更新配镜单汇总生成采购收货单的标识
	 */
	public void updateSalesDetail(String flag){

		StringBuffer sb = new StringBuffer();
		
		if (flag.equals("1")){
			sb.append(" update S_SE_SalesDetail set S_SE_SD_IsPurchaseCollect = '1' where isnull(S_SE_SD_IsPurchaseCollect,'0')='0' ");
		}else{
			sb.append(" update S_SE_SalesDetail set S_SE_SD_IsReturnPurchaseCollect = '1' where isnull(S_SE_SD_IsReturnPurchaseCollect,'0')='0' and S_SE_SD_SalesID in (select S_SE_SB_SalesID from S_SE_SalesBasic where S_SE_SB_WithdrawFlag = '1' ) ");
		}
		
		getJdbcTemplate().update(sb.toString());
	}
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoPurchaseBillFromSalesBill(InventoryPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_ST_PurchaseBill ");
		sb.append("           (C_ST_I_BillID ");
		sb.append("           ,C_ST_I_BillTypeId ");
		sb.append("           ,C_ST_I_billDate ");
		sb.append("           ,C_ST_I_GoodsCategory ");
		sb.append("           ,C_ST_I_InStockId ");
		sb.append("           ,C_ST_I_OutStockId ");
		sb.append("           ,C_ST_I_SupplierId ");
		sb.append("           ,C_ST_I_DepartmentId ");
		sb.append("           ,C_ST_I_createPerson ");
		sb.append("           ,C_ST_I_AuditPerson ");
		sb.append("           ,C_ST_I_AuditState ");
		sb.append("           ,C_ST_I_AuditDate ");
		sb.append("           ,C_ST_I_FinanceAuditState ");
		sb.append("           ,C_ST_I_Remark ");
		sb.append("           ,C_ST_I_InvoiceState) ");
		sb.append(" values (?,?,getdate(),?,?,?,?,?,?,?,'1',getdate(),'0',?,'0') ");
		
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibilltypeid()));
		params.add(Utility.getName(po.getCstigoodscategory()));
		params.add(Utility.getName(po.getCstiinstockid()));
		params.add(Utility.getName(po.getCstioutstockid()));
		params.add(Utility.getName(po.getCstisupplierid()));
		params.add(Utility.getName(po.getCstidepartmentid()));
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCstiauditperson()));
		params.add(Utility.getName(po.getCstiremark()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoInventoryBillFromSalesBill(InventoryPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_ST_Inventory ");
		sb.append("           (C_ST_I_BillID ");
		sb.append("           ,C_ST_I_BillTypeId ");
		sb.append("           ,C_ST_I_billDate ");
		sb.append("           ,C_ST_I_GoodsCategory ");
		sb.append("           ,C_ST_I_InStockId ");
		sb.append("           ,C_ST_I_OutStockId ");
		sb.append("           ,C_ST_I_SupplierId ");
		sb.append("           ,C_ST_I_DepartmentId ");
		sb.append("           ,C_ST_I_createPerson ");
		sb.append("           ,C_ST_I_AuditPerson ");
		sb.append("           ,C_ST_I_AuditState ");
		sb.append("           ,C_ST_I_AuditDate ");
		sb.append("           ,C_ST_I_FinanceAuditState ");
		sb.append("           ,C_ST_I_Remark ");
		sb.append("           ,C_ST_I_InvoiceState) ");
		sb.append(" values (?,?,getdate(),?,?,?,?,?,?,?,'1',getdate(),'0',?,'0') ");
		
		params.add(Utility.getName(po.getCstibillid()));
		params.add(Utility.getName(po.getCstibilltypeid()));
		params.add(Utility.getName(po.getCstigoodscategory()));
		params.add(Utility.getName(po.getCstiinstockid()));
		params.add(Utility.getName(po.getCstioutstockid()));
		params.add(Utility.getName(po.getCstisupplierid()));
		params.add(Utility.getName(po.getCstidepartmentid()));
		params.add(Utility.getName(po.getCsticreateperson()));
		params.add(Utility.getName(po.getCstiauditperson()));
		params.add(Utility.getName(po.getCstiremark()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 配镜单汇总明细
	 */
	public void inertAutoPurchaseBillEntryFromSalesBill(InventoryEntryPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_ST_PurchaseEntry ");
		sb.append("           (C_ST_IE_ID ");
		sb.append("           ,C_ST_IE_BillID ");
		sb.append("           ,C_ST_IE_GoodsId ");
		sb.append("           ,C_ST_IE_GoodsQuantity ");
		sb.append("           ,C_ST_IE_NotTaxRate ");
		sb.append("           ,C_ST_IE_NotTaxRateAmount ");
		sb.append("           ,C_ST_IE_TaxRate ");
		sb.append("           ,C_ST_IE_CostPrice ");
		sb.append("           ,C_ST_IE_TaxAmount ");
		sb.append("           ,C_ST_IE_CostPriceAmount ");
		sb.append("           ,C_ST_IE_InStockId ");
		sb.append("           ,C_ST_IE_OutStockId ");
		sb.append("           ,C_ST_IE_BarCode ");
		sb.append("           ,C_ST_IE_WarehousingDate ");
		sb.append("           ,C_ST_IE_Remark ");
		sb.append("           ,C_ST_IE_InvoiceState ");
		sb.append("           ,C_ST_IE_checkquantity ");
		sb.append("           ,C_ST_IE_GuaranteePeriod ");
		sb.append("           ,C_ST_IE_Batch) ");
		sb.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),?,'0','0',?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstienottaxrate()));
		params.add(Utility.getName(po.getCstienottaxrateamount()));
		params.add(Utility.getName(po.getCstietaxrate()));
		params.add(Utility.getName(po.getCstiecostprice()));
		params.add(Utility.getName(po.getCstietaxamount()));
		params.add(Utility.getName(po.getCstiecostpriceamount()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstieremark()));
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 配镜单汇总明细
	 */
	public void inertAutoInventoryBillEntryFromSalesBill(InventoryEntryPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("INSERT INTO C_ST_InventoryEntry ");
		sb.append("           (C_ST_IE_ID ");
		sb.append("           ,C_ST_IE_BillID ");
		sb.append("           ,C_ST_IE_GoodsId ");
		sb.append("           ,C_ST_IE_GoodsQuantity ");
		sb.append("           ,C_ST_IE_NotTaxRate ");
		sb.append("           ,C_ST_IE_NotTaxRateAmount ");
		sb.append("           ,C_ST_IE_TaxRate ");
		sb.append("           ,C_ST_IE_CostPrice ");
		sb.append("           ,C_ST_IE_TaxAmount ");
		sb.append("           ,C_ST_IE_CostPriceAmount ");
		sb.append("           ,C_ST_IE_InStockId ");
		sb.append("           ,C_ST_IE_OutStockId ");
		sb.append("           ,C_ST_IE_BarCode ");
		sb.append("           ,C_ST_IE_WarehousingDate ");
		sb.append("           ,C_ST_IE_Remark ");
		sb.append("           ,C_ST_IE_InvoiceState ");
		sb.append("           ,C_ST_IE_checkquantity ");
		sb.append("           ,C_ST_IE_GuaranteePeriod ");
		sb.append("           ,C_ST_IE_Batch) ");
		sb.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),?,'0','0',?,?) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstienottaxrate()));
		params.add(Utility.getName(po.getCstienottaxrateamount()));
		params.add(Utility.getName(po.getCstietaxrate()));
		params.add(Utility.getName(po.getCstiecostprice()));
		params.add(Utility.getName(po.getCstietaxamount()));
		params.add(Utility.getName(po.getCstiecostpriceamount()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstieoutstockid()));
		params.add(Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstieremark()));
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
	}
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoPurchaseBillToStrogeChange(InventoryEntryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageChange (C_SH_SC_GoodsBarCode , C_SH_SC_GoodsId , C_SH_SC_StockId , ");
		buffer.append("C_SH_SC_GoodsQuantity , C_SH_SC_CostPrice , C_SH_SC_NotTaxRate , ");
		buffer.append("C_SH_SC_WarehousingDate , C_SH_SC_ChangeID ,C_SH_SC_UUID) ");
		buffer.append("values(? , ? , ? ,? , ? , ? , getdate() , ? ,?) ");
		
		params.add(Utility.getName(po.getCstiebarcode()).substring(0, 18));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstiecostprice()));	
		params.add(Utility.getName(po.getCstienottaxrate()));		
		params.add(Utility.getName(po.getCstiebillid()));		
		params.add(this.uuid.generate());	
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 配镜单汇总
	 */
	public void inertAutoPurchaseBillToStrogeLog(InventoryEntryPo po){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("insert into C_SH_StorageLog (C_SH_Sl_GoodsBarCode , C_SH_Sl_GoodsId , C_SH_Sl_StockId , ");
		buffer.append("C_SH_Sl_GoodsQuantity , C_Sh_Sl_CostPrice , C_SH_Sl_NotTaxRate , ");
		buffer.append("C_SH_Sl_WarehousingDate , C_SH_Sl_ChangeID , C_SH_SL_UUID,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
		buffer.append("values(? , ? , ? ,?,? , ? , getdate() , ?, ?,?,?) ");
		
		params.add(Utility.getName(po.getCstiebarcode()));
		params.add(Utility.getName(po.getCstiegoodsid()));
		params.add(Utility.getName(po.getCstieinstockid()));
		params.add(Utility.getName(po.getCstiegoodsquantity()));
		params.add(Utility.getName(po.getCstiecostprice()));	
		params.add(Utility.getName(po.getCstienottaxrate()));		
		params.add(Utility.getName(po.getCstiebillid()));
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getCstieguaranteeperiod()));
		params.add(Utility.getName(po.getCstiebatch()));
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
	
	/**
	 * 记录汇总生成采购单的配镜单号
	 */
	public void insertCollectPurchaseBillBySalesBill(ExternalAccountParameterPo epo){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("INSERT INTO C_ST_PurchaseCompare ");
		buffer.append("           (C_ST_PC_ID ");
		buffer.append("           ,C_ST_PC_SalesBillID ");
		buffer.append("           ,C_ST_PC_IsPurchaseCollect ");
		buffer.append("           ,C_ST_PC_IsReturnPurchaseCollect) ");
		buffer.append("select newid(),S_SE_SD_SalesID,oflag,inflag from ( ");
		buffer.append("	select S_SE_SD_SalesID,'1' as oflag,'0' as inflag from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SD_SalesID=S_SE_SB_SalesID where isnull(S_SE_SD_IsPurchaseCollect,'0')='0' ");
		buffer.append("	union all ");
		buffer.append("	select S_SE_SD_SalesID,'0' as oflag,'1' as inflag from S_SE_SalesDetail inner join S_SE_SalesBasic on S_SE_SD_SalesID=S_SE_SB_SalesID where S_SE_SB_WithdrawFlag = '1' and isnull(S_SE_SD_IsReturnPurchaseCollect,'0')='0' ");
		buffer.append(")t ");
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());		
	}
	
	/**
	 * 汇总周转率报表的库存
	 */
	public void insertCollectZZLStorage(){
		
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("delete from C_SH_Storage_ZZL ");
		
        buffer.append("INSERT INTO C_SH_Storage_ZZL ");
        buffer.append("           (C_SH_SZ_UUID ");
        buffer.append("           ,C_SH_SZ_GoodsId ");
        buffer.append("           ,C_SH_SZ_StockId ");
        buffer.append("           ,C_SH_SZ_GoodsQuantity ");
        buffer.append("           ,C_SH_SZ_Date ");
        buffer.append("           ,C_SH_SZ_Flag) ");
        buffer.append("select newid(),C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity) as goodsNum,date,billFlag ");
        buffer.append("  from ( ");
        
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'1' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where (C_SH_SL_ChangeID like 'PIN%' or C_SH_SL_ChangeID like 'CPIN%' or C_SH_SL_ChangeID like 'OTI%') ");    // 采购收货、委外收货、其他入库

        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'2' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'ALL%' and C_SH_SL_GoodsQuantity > 0 ");    // 调拨入库
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'3' as billFlag ");
        buffer.append("	 from C_SH_StorageLog  ");
        buffer.append("	 where C_SH_SL_ChangeID like 'X%' ");        // 门店销售      

        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'4' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SCI%' ");      // 盘盈
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'5' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SCO%' ");    // 盘亏
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'6' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'TOUT%' ");     // 领用出库
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'7' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SG%' ");      // 客户批发调货
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'8' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SR%' ");     // 客户批发退货
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'9' as billFlag ");
        buffer.append("	 from C_SH_StorageLog  ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SOUT%' ");       // 销售出库 
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'10' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID = 'import' ");   // 导入        
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'11' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where (C_SH_SL_ChangeID like 'POUT%' or C_SH_SL_ChangeID like 'OTO%') ");    // 采购退货、其他出库
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'12' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'ALL%' and C_SH_SL_GoodsQuantity < 0  ");      // 调拨出库

        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'13' as billFlag ");
        buffer.append("	 from C_SH_StorageLog  ");
        buffer.append("	 where C_SH_SL_ChangeID like 'DH%' ");     // 积分兑换
        
        buffer.append("  )t ");
        buffer.append("  group by C_SH_SL_GoodsId,C_SH_SL_StockId,date,billFlag ");
        buffer.append("  having sum(C_SH_SL_GoodsQuantity) <> 0 ");
		
		getJdbcTemplate().update(buffer.toString());		
	}
	
	/**
	 * 按商品类型汇总库存
	 */
	public void insertCollectGoodsTypeStorage(){

		StringBuffer buffer = new StringBuffer();
		
		buffer.append("exec usp_collectStorageByType ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 汇总客单价统计表
	 */
	public void insertPerCustomer(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec usp_PerCustomerQuartz ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 根据当前账期计算自动创建凭证数据的日期
	 */
	public String getCurrentAccountPeriodDate(){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select dbo.ufn_CurrentAccountPeriodDate() ");
		
		return (String)getJdbcTemplate().queryForObject(buffer.toString(), params.toArray(),String.class);
	}
	/**
	 * 分店销售指南表（除中心店、隐形店）
	 */
	public void collectEachShopSalesGuide(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec QMSHT2 ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 分店销售指南表（中心店、隐形店）
	 */
	public void collectStealthShopSalesGuide(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec QMSHT2_yx ?,? ");
		
		buffer.append("exec QMSHT_zxdyx ?,? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 自动关账
	 */
	public void switchAmount(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec xzd_SwitchAmount ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 创建临时凭证表
	 */
	public void createTempVoucherTab(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec xzd_CreateTempVoucherTab ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 清空当日营业员收银员记录
	 */
	public void deleteTodaySalerCashierRecord(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from S_SE_SalerCashierRecord where convert(varchar(10),S_SE_SCR_PosDate,120) < convert(varchar(10),getdate(),120) ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 清空当日营业员收银员记录（补齐）
	 */
	public void deleteTodaySalerCashierRecordAppendArrears(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from S_SE_SalerCashierRecord_AppendArrears where convert(varchar(10),S_SE_SCR_PosDate,120) < convert(varchar(10),getdate(),120) ");
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public AutoCostAccountPo getCurrentAccountPeriodDateArea(String date){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare ");
		buffer.append("@bgnDate varchar(10), ");
		buffer.append("@endDate varchar(10), ");
		buffer.append("@accountperiod varchar(10), ");
		buffer.append("@year varchar(4), ");
		buffer.append("@month varchar(2) ");

		buffer.append("set @year = substring(?,1,4) ");
		buffer.append("set @month = substring(?,6,7) ");

		buffer.append("select top 1 @accountperiod = F_SP_AccountPeriod from F_SystemParameter ");

		buffer.append("if @accountperiod = '1' ");
		buffer.append("begin ");
		buffer.append("	select @bgnDate=@year+'-'+@month+'-01', ");
		buffer.append("	       @endDate=convert(varchar(10),dateadd(dd,-day(@year+'-'+@month+'-01'),dateadd(m,1,@year+'-'+@month+'-01')),120)        ");
		buffer.append("end ");

		buffer.append("if @accountperiod = '2' ");
		buffer.append("begin ");
		buffer.append("	select @bgnDate=convert(varchar(10),dateadd(month,-1,(@year+'-'+@month+'-26')),120), ");
		buffer.append("	       @endDate=(@year+'-'+@month+'-25') ");
		buffer.append("end ");

		buffer.append("if @accountperiod = '3' ");
		buffer.append("begin ");
		buffer.append("	select @bgnDate=(@year+'-'+@month+'-26'), ");
		buffer.append("	       @endDate=convert(varchar(10),dateadd(month,1,(@year+'-'+@month+'-25')),120)        ");
		buffer.append("end ");
		
		buffer.append("select @bgnDate as latcabgndate,@endDate as latcaenddate ");
		
		params.add(Utility.getName(date));
		params.add(Utility.getName(date));
		
		return (AutoCostAccountPo) queryForObject(buffer.toString(), params.toArray(), AutoCostAccountPo.class);
	}
	
	public List<AutoCostAccountPo> selCurrentAccountPeriodOneCompany(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select distinct L_AT_CA_PaymentDay as latcapaymentday,isnull(L_AT_CA_CompanyID,'') as latcacompanyid from L_AT_AutoCostAccount where isnull(L_AT_CA_CompanyID,'') <> '' and L_AT_CA_Flag = '0' order by isnull(L_AT_CA_CompanyID,'') desc,L_AT_CA_PaymentDay asc ");	
		
		return queryForObjectList(buffer.toString() , params.toArray() , AutoCostAccountPo.class);
	}
	
	public void autoCostAccountFinish(String date,String companyID){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update L_AT_AutoCostAccount set L_AT_CA_ExecDate=getdate(),L_AT_CA_Flag='1' where L_AT_CA_PaymentDay=? and L_AT_CA_CompanyID = ? ");
		
		params.add(date); 
		params.add(companyID); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 按日期、仓位、单据类型汇总历史库存
	 */
	public void updateStroageByDateAndBillType(String bgnDate,String endDate){
				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
				
		buffer.append("delete from C_SH_Storage_ZZL where C_SH_SZ_Date >= ? and C_SH_SZ_Date <= ? ");
		
        buffer.append("INSERT INTO C_SH_Storage_ZZL ");
        buffer.append("           (C_SH_SZ_UUID ");
        buffer.append("           ,C_SH_SZ_GoodsId ");
        buffer.append("           ,C_SH_SZ_StockId ");
        buffer.append("           ,C_SH_SZ_GoodsQuantity ");
        buffer.append("           ,C_SH_SZ_Date ");
        buffer.append("           ,C_SH_SZ_Flag) ");
        buffer.append("select newid(),C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity) as goodsNum,date,billFlag ");
        buffer.append("  from ( ");
        
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'1' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where (C_SH_SL_ChangeID like 'PIN%' or C_SH_SL_ChangeID like 'CPIN%' or C_SH_SL_ChangeID like 'OTI%') ");    // 采购收货、委外收货、其他入库
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'2' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'ALL%' and C_SH_SL_GoodsQuantity > 0 ");    // 调拨入库
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'3' as billFlag ");
        buffer.append("	 from C_SH_StorageLog  ");
        buffer.append("	 where C_SH_SL_ChangeID like 'X%' ");        // 门店销售      
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'4' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SCI%' ");      // 盘盈
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'5' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SCO%' ");    // 盘亏
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'6' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'TOUT%' ");     // 领用出库
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'7' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SG%' ");      // 客户批发调货
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'8' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SR%' ");     // 客户批发退货
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'9' as billFlag ");
        buffer.append("	 from C_SH_StorageLog  ");
        buffer.append("	 where C_SH_SL_ChangeID like 'SOUT%' ");       // 销售出库 
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'10' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID = 'import' ");   // 导入        
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'11' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where (C_SH_SL_ChangeID like 'POUT%' or C_SH_SL_ChangeID like 'OTO%') ");    // 采购退货、其他出库
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'12' as billFlag ");
        buffer.append("	 from C_SH_StorageLog ");
        buffer.append("	 where C_SH_SL_ChangeID like 'ALL%' and C_SH_SL_GoodsQuantity < 0  ");      // 调拨出库
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("	union all ");
        buffer.append("	select C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity, ");
        buffer.append("		   convert(varchar(10),C_SH_SL_WarehousingDate,120) as date,'13' as billFlag ");
        buffer.append("	 from C_SH_StorageLog  ");
        buffer.append("	 where C_SH_SL_ChangeID like 'DH%' ");     // 积分兑换
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) >= ? ");
        buffer.append("	      and convert(varchar(10),C_SH_SL_WarehousingDate,120) <= ? ");
        
        buffer.append("  )t ");
        buffer.append("  group by C_SH_SL_GoodsId,C_SH_SL_StockId,date,billFlag ");
        buffer.append("  having sum(C_SH_SL_GoodsQuantity) <> 0 ");
                
		
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate);
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
		
	/**
	 * 汇总销售出库
	 */
	public void deleteSalesOutBillByDate(String bgnDate,String endDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID in ( ");
		buffer.append("  select C_ST_I_BillID from C_ST_Inventory where C_ST_I_BillTypeId = '3' and C_ST_I_GoodsCategory in ('20','25') and convert(varchar(10),C_ST_I_AuditDate,120) >= ? and convert(varchar(10),C_ST_I_AuditDate,120) <= ? ");
		buffer.append(") ");
		
		buffer.append("delete from C_ST_Inventory where C_ST_I_BillTypeId = '3' and C_ST_I_GoodsCategory in ('20','25') and convert(varchar(10),C_ST_I_AuditDate,120) >= ? and convert(varchar(10),C_ST_I_AuditDate,120) <= ? ");
		
		params.add(bgnDate); 
		params.add(endDate); 
		params.add(bgnDate); 
		params.add(endDate);
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 商品库存周转率统计表（按单据）
	 */
	public void insertGoodsStorageRevolveRateByBill(ModulePo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" exec usp_GoodsStorageRevolveRateByBillQuartz ?,? ");

		params.add(Utility.getName(po.getReportBgnDate()));
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 汇总周转率报表的库存
	 */
	public void insertCollectZZLStorageByBill(String bgnDate,String endDate){
		
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select convert(varchar(10),C_ST_I_FinanceAuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_NotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_CostPriceAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("       into #goodsInfo ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("  where C_ST_I_BillTypeId in ('1','2','7','8','9') and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_FinanceAuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId ");

		buffer.append("select convert(varchar(10),C_ST_I_AuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType,isnull(C_ST_I_GoodsCategory,'') as goodsType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("       into #goodsInfo2 ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("  where C_ST_I_BillTypeId in ('3','5','6') and C_ST_I_AuditState = '1' and C_ST_IE_GoodsId not like '%附%' ");
				
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_AuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId,isnull(C_ST_I_GoodsCategory,'') ");
		
		buffer.append("select changeDate as changeDate, ");
		buffer.append("       goodsID as goodsID, ");
		buffer.append("       inStockID as inStockID, ");
		buffer.append("       outStockID as outStockID, ");
		buffer.append("       billType, ");
		buffer.append("       isnull(sum(isnull(goodsNum,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(notTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(costPriceAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(averageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("       into #goodsInfo3 ");
		buffer.append("  from ( ");
		buffer.append("select convert(varchar(10),C_ST_I_FinanceAuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("       left join B_Warehouse a on C_ST_I_InStockId = a.B_WH_ID left join B_Departments c on a.B_WH_deptID = c.B_DP_DepartmentID left join F_CompanyName x on x.F_CN_ID = c.B_DP_CompanysID ");		
		buffer.append("       left join B_Warehouse b on C_ST_I_OutStockId = b.B_WH_ID left join B_Departments d on b.B_WH_deptID = d.B_DP_DepartmentID left join F_CompanyName m on m.F_CN_ID = d.B_DP_CompanysID ");	
		buffer.append("  where C_ST_I_BillTypeId = '4' and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' and x.F_CN_CompanyType = m.F_CN_CompanyType ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_FinanceAuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId ");

		buffer.append(" union all ");
		buffer.append("select convert(varchar(10),C_ST_I_FinanceAuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_WholesalePriceAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_WholesalePriceAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("       left join B_Warehouse a on C_ST_I_InStockId = a.B_WH_ID left join B_Departments c on a.B_WH_deptID = c.B_DP_DepartmentID left join F_CompanyName x on x.F_CN_ID = c.B_DP_CompanysID ");		
		buffer.append("       left join B_Warehouse b on C_ST_I_OutStockId = b.B_WH_ID left join B_Departments d on b.B_WH_deptID = d.B_DP_DepartmentID left join F_CompanyName m on m.F_CN_ID = d.B_DP_CompanysID ");
		buffer.append("  where C_ST_I_BillTypeId = '4' and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' and x.F_CN_CompanyType = '2' and m.F_CN_CompanyType = '1' ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_FinanceAuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId ");
		
		buffer.append(" union all ");
		buffer.append("select convert(varchar(10),C_ST_I_FinanceAuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_NotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_CostPriceAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("       left join B_Warehouse a on C_ST_I_InStockId = a.B_WH_ID left join B_Departments c on a.B_WH_deptID = c.B_DP_DepartmentID left join F_CompanyName x on x.F_CN_ID = c.B_DP_CompanysID ");		
		buffer.append("       left join B_Warehouse b on C_ST_I_OutStockId = b.B_WH_ID left join B_Departments d on b.B_WH_deptID = d.B_DP_DepartmentID left join F_CompanyName m on m.F_CN_ID = d.B_DP_CompanysID ");
		buffer.append("  where C_ST_I_BillTypeId = '4' and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' and x.F_CN_CompanyType = '1' and m.F_CN_CompanyType = '2' ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_FinanceAuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId ");
		
		buffer.append("  )m ");
		buffer.append("  group by changeDate,goodsID,inStockID,outStockID,billType ");
		
		buffer.append("select changeDate as changeDate, ");
		buffer.append("       goodsID as goodsID, ");
		buffer.append("       inStockID as inStockID, ");
		buffer.append("       outStockID as outStockID, ");
		buffer.append("       billType, ");
		buffer.append("       isnull(sum(isnull(goodsNum,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(notTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(costPriceAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(averageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("       into #goodsInfo4 ");
		buffer.append("  from ( ");
		buffer.append("select convert(varchar(10),C_ST_I_FinanceAuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("       left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID left join F_CompanyName on F_CN_ID = B_DP_CompanysID ");
		buffer.append("  where C_ST_I_BillTypeId = '4' and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' and F_CN_CompanyType = '1' ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_FinanceAuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId ");

		buffer.append(" union all ");
		buffer.append("select convert(varchar(10),C_ST_I_FinanceAuditDate,120) as changeDate, ");
		buffer.append("       C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_InStockId,'') as inStockID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as outStockID, ");
		buffer.append("       C_ST_I_BillTypeId as billType, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount ");
		buffer.append("  from C_ST_Inventory inner join C_ST_InventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
		buffer.append("       left join B_Warehouse on C_ST_I_OutStockId = B_WH_ID left join B_Departments on B_WH_deptID = B_DP_DepartmentID left join F_CompanyName on F_CN_ID = B_DP_CompanysID ");
		buffer.append("  where C_ST_I_BillTypeId = '4' and C_ST_I_AuditState = '1' and C_ST_I_FinanceAuditState = '1' and F_CN_CompanyType = '2' ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_FinanceAuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
		buffer.append("  group by convert(varchar(10),C_ST_I_FinanceAuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_InStockId,''),isnull(C_ST_I_OutStockId,''),C_ST_I_BillTypeId ");
		
		buffer.append("  )m ");
		buffer.append("  group by changeDate,goodsID,inStockID,outStockID,billType ");
		
		buffer.append("delete from C_SH_Storage_ZZL_Bill where 1 = 1 ");
		
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and C_SH_SZ_Date >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and C_SH_SZ_Date <= ? ");
			params.add(Utility.getName(endDate));
		}
		
        buffer.append("INSERT INTO C_SH_Storage_ZZL_Bill ");
        buffer.append("           (C_SH_SZ_UUID ");
        buffer.append("           ,C_SH_SZ_GoodsId ");
        buffer.append("           ,C_SH_SZ_StockId ");
        buffer.append("           ,C_SH_SZ_GoodsQuantity ");
        buffer.append("           ,C_SH_SZ_NotTaxRateAmount ");
        buffer.append("           ,C_SH_SZ_CostPriceAmount ");
        buffer.append("           ,C_SH_SZ_AveragePriceAmount ");
        buffer.append("           ,C_SH_SZ_Date ");
        buffer.append("           ,C_SH_SZ_Flag) ");
        buffer.append("select newid(),goodsID,stockID,sum(goodsNum) as goodsNum,sum(notTaxRateAmount) as notTaxRateAmount,sum(costPriceAmount) as costPriceAmount,sum(averageNotTaxRateAmount) as averageNotTaxRateAmount,changeDate,billFlag ");
        buffer.append("  from ( ");
        buffer.append("	select goodsID,inStockID as stockID,goodsNum,notTaxRateAmount,costPriceAmount,averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '1' as billFlag ");
        buffer.append("	 from #goodsInfo ");
        buffer.append("	 where billType in ('1','7','9') ");    // 采购收货、委外收货、其他入库

        buffer.append("	union all ");
        buffer.append("	select goodsID,inStockID as stockID,goodsNum,notTaxRateAmount,costPriceAmount,averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '2' as billFlag ");
        buffer.append("	 from #goodsInfo3 ");
        buffer.append("	 where billType = '4' ");    // 调拨入库

        buffer.append("	union all ");
        buffer.append("	select goodsID,outStockID as stockID,-goodsNum,-notTaxRateAmount,-costPriceAmount,-averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '3' as billFlag ");
        buffer.append("	 from #goodsInfo2  ");
        buffer.append("	 where billType = '3' and goodsType = '20' ");        // 门店销售     

        buffer.append("	union all ");
        buffer.append("	select goodsID,inStockID as stockID,goodsNum,notTaxRateAmount,costPriceAmount,averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '4' as billFlag ");
        buffer.append("	 from #goodsInfo2 ");
        buffer.append("	 where billType = '5' ");      // 盘盈
        
        buffer.append("	union all ");
        buffer.append("	select goodsID,outStockID as stockID,-goodsNum,-notTaxRateAmount,-costPriceAmount,-averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '5' as billFlag ");
        buffer.append("	 from #goodsInfo2 ");
        buffer.append("	 where billType = '6' ");    // 盘亏
        
        buffer.append("	union all ");
		buffer.append("select C_ST_IE_GoodsId as goodsID, ");
		buffer.append("       isnull(C_ST_I_OutStockId,'') as stockID, ");
		buffer.append("       -isnull(sum(isnull(C_ST_IE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       -isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       -isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       -isnull(sum(isnull(C_ST_IE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount, ");
		buffer.append("       convert(varchar(10),C_ST_I_AuditDate,120) as changeDate, ");
        buffer.append("		  '6' as billFlag ");
        buffer.append("	 from C_ST_TakeInventory inner join C_ST_TakeInventoryEntry on C_ST_I_BillID = C_ST_IE_BillID ");
        buffer.append("	 where C_ST_I_AuditState = '1' ");     // 领用出库
        
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_AuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),C_ST_I_AuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
        buffer.append("	 group by convert(varchar(10),C_ST_I_AuditDate,120),C_ST_IE_GoodsId,isnull(C_ST_I_OutStockId,'') ");
        
        buffer.append("	union all ");
		buffer.append("select M_TE_GoodsId as goodsID, ");
		buffer.append("       isnull(M_T_OutStockId,'') as stockID, ");
		buffer.append("       -isnull(sum(isnull(M_TE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       -isnull(sum(isnull(M_TE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       -isnull(sum(isnull(M_TE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       -isnull(sum(isnull(M_TE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount, ");
		buffer.append("       convert(varchar(10),M_T_AuditDate,120) as changeDate, ");
        buffer.append("		  '7' as billFlag ");
        buffer.append("	 from M_Trac inner join M_TracEntry on M_T_BillID = M_TE_BillID ");
        buffer.append("	 where M_T_BillTypeId = '3' and M_T_AuditState = '1' ");      // 客户批发调货
        
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),M_T_AuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),M_T_AuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
        buffer.append("	 group by convert(varchar(10),M_T_AuditDate,120),M_TE_GoodsId,isnull(M_T_OutStockId,'') ");
        
        buffer.append("	union all ");
		buffer.append("select M_TE_GoodsId as goodsID, ");
		buffer.append("       isnull(M_T_InStockId,'') as stockID, ");
		buffer.append("       isnull(sum(isnull(M_TE_GoodsQuantity,0)),0) as goodsNum, ");
		buffer.append("       isnull(sum(isnull(M_TE_AverageNotTaxRateAmount,0)),0) as notTaxRateAmount, ");
		buffer.append("       isnull(sum(isnull(M_TE_AverageNotTaxRateAmount,0)),0) as costPriceAmount,  ");
		buffer.append("       isnull(sum(isnull(M_TE_AverageNotTaxRateAmount,0)),0) as averageNotTaxRateAmount, ");
		buffer.append("       convert(varchar(10),M_T_AuditDate,120) as changeDate, ");
        buffer.append("		  '8' as billFlag ");
        buffer.append("	 from M_Trac inner join M_TracEntry on M_T_BillID = M_TE_BillID ");
        buffer.append("	 where M_T_BillTypeId = '2' and M_T_AuditState = '1' ");     // 客户批发退货
        
		if (!"".equals(Utility.getName(bgnDate))){
			buffer.append("  and convert(varchar(10),M_T_AuditDate,120) >= ? ");
			params.add(Utility.getName(bgnDate));
		}
		
		if (!"".equals(Utility.getName(endDate))){
			buffer.append("  and convert(varchar(10),M_T_AuditDate,120) <= ? ");
			params.add(Utility.getName(endDate));
		}
		
        buffer.append("	 group by convert(varchar(10),M_T_AuditDate,120),M_TE_GoodsId,isnull(M_T_InStockId,'') ");
        
        buffer.append("	union all ");
        buffer.append("	select goodsID,outStockID as stockID,-goodsNum,-notTaxRateAmount,-costPriceAmount,-averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '9' as billFlag ");
        buffer.append("	 from #goodsInfo2  ");
        buffer.append("	 where billType = '3' and goodsType = '' ");       // 销售出库 
        
        // 10 为导入，按单据查看的周转率报表，没有库存导入的方式
        
        buffer.append("	union all ");
        buffer.append("	select goodsID,outStockID as stockID,-goodsNum,-notTaxRateAmount,-costPriceAmount,-averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '11' as billFlag ");
        buffer.append("	 from #goodsInfo ");
        buffer.append("	 where billType in ('2','8') ");    // 采购退货、其他出库
        
        buffer.append("	union all ");
        buffer.append("	select goodsID,outStockID as stockID,-goodsNum,-notTaxRateAmount,-costPriceAmount,-averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '12' as billFlag ");
        buffer.append("	 from #goodsInfo4 ");
        buffer.append("	 where billType = '4'  ");      // 调拨出库
        
        buffer.append("	union all ");
        buffer.append("	select goodsID,outStockID as stockID,-goodsNum,-notTaxRateAmount,-costPriceAmount,-averageNotTaxRateAmount,changeDate, ");
        buffer.append("		   '13' as billFlag ");
        buffer.append("	 from #goodsInfo2  ");
        buffer.append("	 where billType = '3' and goodsType = '25' ");     // 积分兑换
        
        buffer.append("  )t ");
        buffer.append("  group by goodsID,stockID,changeDate,billFlag ");
        buffer.append("  having sum(goodsNum) <> 0 or sum(notTaxRateAmount) <> 0 or sum(costPriceAmount) <> 0 or sum(averageNotTaxRateAmount) <> 0 ");
                
		buffer.append("drop table #goodsInfo ");
		buffer.append("drop table #goodsInfo2 ");
		buffer.append("drop table #goodsInfo3 ");
		buffer.append("drop table #goodsInfo4 ");
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());		
	}
	
}
