package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.ContractPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.sun.org.apache.xpath.internal.operations.And;

public class DoorStoreDeliveryDaoImpl extends BaseJdbcDaoSupport implements
		DoorStoreDeliveryDao {

	/**
	 * 查询门店配送信息
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo po,String type) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid, ");
		buffer.append("S_SE_SB_CustomerID as ssesbcustomerid, ");
		buffer.append("S_SE_SB_Location as ssesblocation, ");
		buffer.append("B_DP_DepartmentName as ssesbtakeshopname , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName, ");
		buffer.append("convert(varchar(16), S_SE_SB_TakeGlassData, 120) as ssesbtakeglassdata, ");
		buffer.append("S_SE_SB_OrdersType as ssesborderstype, ");
		buffer.append("S_SE_SB_DragsType as ssesbdragstype ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join B_Departments on S_SE_SalesBasic.S_SE_SB_Location = B_Departments.B_DP_DepartmentID ");
		buffer.append("inner join S_ME_CustomerInfo on S_SE_SalesBasic.S_SE_SB_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		buffer.append("where S_SE_SB_ValueFlag='1' and S_SE_SB_InTransit = '2' ");
		
		String ssesborderstypebuffer = "";
		for(int i=0; i<po.getSsesborderstypes().length; i++){
			if(!"".equals(po.getSsesborderstypes()[i].trim())){
				ssesborderstypebuffer = ssesborderstypebuffer+"?,";
				params.add(po.getSsesborderstypes()[i].trim());
			}
		}
		
		if (!"".equals(ssesborderstypebuffer)){
			ssesborderstypebuffer = ssesborderstypebuffer.substring(0, ssesborderstypebuffer.length()-1);
			buffer.append("and S_SE_SB_OrdersType in("+ssesborderstypebuffer+") ");
		}else{
			buffer.append("and S_SE_SB_OrdersType in ('1','2','4') ");
		}
		
		buffer.append("and S_SE_SB_ShopCode = ? ");
		params.add(Utility.getName(po.getSsesbshopcode()));
		
		if (!"".equals(Utility.getName(po.getSsesbtakeglassstartdata()))){
			buffer.append("and convert(varchar(10),S_SE_SB_TakeGlassData,120) >= ? ");
			params.add(Utility.getName(po.getSsesbtakeglassstartdata()));
		}
		if (!"".equals(Utility.getName(po.getSsesbtakeglassenddata()))){
			buffer.append("and convert(varchar(10),S_SE_SB_TakeGlassData,120) <= ? ");
			params.add(Utility.getName(po.getSsesbtakeglassenddata()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesdatestarttime()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) >= ? ");
			params.add(Utility.getName(po.getSsesbsalesdatestarttime()));
		}
		if (!"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){
			buffer.append("and convert(varchar(10),S_SE_SB_PosDatetime,120) <= ? ");
			params.add(Utility.getName(po.getSsesbsalesdateendtime()));
		}
		if (!"".equals(Utility.getName(po.getSsesbMemberId()))){
			buffer.append("and S_ME_CI_MemberId = ? ");
			params.add(Utility.getName(po.getSsesbMemberId()));
		}
		if (!"".equals(Utility.getName(po.getSsesbpersonName()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(Utility.getName(po.getSsesbpersonName()));
		}
		
		if (!"".equals(Utility.getName(po.getSsesbsalesid()))){
			buffer.append("and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(po.getSsesbsalesid()));
		}
		buffer.append("order by S_SE_SB_OrdersType ,S_SE_SB_TakeGlassData ");

		return queryForObjectList(buffer.toString(), params.toArray(),SalesBasicPo.class);
	}

	/**
	 * 修改在途状态
	 */
	public void updateSalesBasicPos(SalesBasicPo salesBasicPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("update S_SE_SalesBasic set  ");
		buffer.append("S_SE_SB_InTransit='3', ");
		buffer.append("S_SE_SB_DragsType=? ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesBasicPo.getSsesbdragstype());
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());

	}
	
	
	
	/**
	 * 查询在途状态
	 */
	public InTransitPo selectInTransit(InTransitPo inTransitPo) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 S_SE_IT_SalesID as sseitsalesid, S_SE_IT_State as sseitstate ");
		buffer.append(" from S_SE_InTransit where S_SE_IT_SalesID = ? order by convert(int,S_SE_IT_State) desc ");
		List<String> params = new ArrayList<String>();
		params.add(inTransitPo.getSseitsalesid());
		
		return (InTransitPo)queryForObject(buffer.toString(), params.toArray(), InTransitPo.class);

	}

	/**
	 * 新增在途查询明细表信息
	 */
	public void insertInTransit(InTransitPo inTransitPo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into S_SE_InTransit ");
		buffer.append("(S_SE_IT_ID,    ");
		buffer.append("S_SE_IT_SalesID, ");
		buffer.append("S_SE_IT_State,  ");
		buffer.append("S_SE_IT_Date,   ");
		buffer.append("S_SE_IT_CreatePerson,");
		buffer.append("S_SE_IT_Department)  ");
		buffer.append("values (?,?,'3',getdate(),?,?) ");
		List<String> params = new ArrayList<String>();
		params.add(uuid.getInstance().generate());
		params.add(inTransitPo.getSseitsalesid());
		params.add(inTransitPo.getSseitcreateperson());
		params.add(inTransitPo.getSseitdepartment());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 新增配送记录主表
	 * 
	 * @param po
	 */
	public String insertDistribution(DistributionPo distributionPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_Distribution( ");
		buffer.append("S_DN_DN_ID, ");
		buffer.append("S_DN_DN_Person, ");
		buffer.append("S_DN_DN_CreateDate, ");
		buffer.append("S_DN_DN_Type,S_DN_DN_LogonPerson,S_DN_DN_DepartmentID )  ");
		buffer.append("values(?,?,getdate(),?,?,?) ");
		List<String> params = new ArrayList<String>();
		params.add(distributionPo.getSdndnid());
		params.add(distributionPo.getSdndnPerson());
		params.add(distributionPo.getSdndntype());
		params.add(Utility.getName(distributionPo.getSdndnlogonperson()));
		params.add(Utility.getName(distributionPo.getSdndndepartmentid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
		return distributionPo.getSdndnid();
	}

	/**
	 * 新增配送记录明细表
	 * 
	 * @param po
	 */
	public void insertDistributionEntry(DistributionPo distributionPo,
			DistributionEntryPo distributionEntryPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_DistributionEntry ( ");
		buffer.append("S_DN_DE_ID, ");
		buffer.append("S_DN_DE_DistributionID, ");
		buffer.append("S_DN_DE_SalesID, ");
		buffer.append("S_DN_DE_OrdersType ) ");
		buffer.append("select ?,?,?,S_SE_SB_OrdersType from S_SE_SalesBasic where S_SE_SB_SalesID=?");
		
		List<String> params = new ArrayList<String>();		
		params.add(uuid.getInstance().generate());
		params.add(distributionEntryPo.getSdndedistributionid());
		params.add(distributionEntryPo.getSdndesalesid());
		params.add(distributionEntryPo.getSdndesalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 获取门店已配送的数量
	 * @return
	 */
	public int getDoorStoreYetDeliveryCount(DistributionPo distributionPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(distinct S_DN_DN_ID) as count1 from S_DN_Distribution inner join S_DN_DistributionEntry on S_DN_DN_ID=S_DN_DE_DistributionID ");
		buffer.append(" inner join uview_SalesBasic on S_SE_SB_SalesID=S_DN_DE_SalesID left join SYS_PersonInfo on S_DN_DN_Person=id  ");
		if (!"1".equals(Utility.getName(distributionPo.getSdndntype()))) {
			buffer.append(" left join B_Departments on S_SE_SB_Location=B_DP_DepartmentID  ");
		}else{
			buffer.append(" left join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID  ");
		}
		buffer.append("  where 1=1 and S_DN_DN_Type=? ");
		
		params.add(Utility.getName(distributionPo.getSdndntype()).trim());
		
		String ssesborderstypebuffer = "";
		for(int i=0; i<distributionPo.getSdndnorderstypes().length; i++){
			if(!"".equals(distributionPo.getSdndnorderstypes()[i].trim())){
				ssesborderstypebuffer = ssesborderstypebuffer+"?,";
				params.add(distributionPo.getSdndnorderstypes()[i].trim());
			}
		}		
		if (!"".equals(ssesborderstypebuffer)){
			ssesborderstypebuffer = ssesborderstypebuffer.substring(0, ssesborderstypebuffer.length()-1);
			buffer.append("and S_SE_SB_OrdersType in("+ssesborderstypebuffer+") ");
		}else{
			buffer.append("and S_SE_SB_OrdersType in ('1','2','4') ");
		}

		if (!"".equals(Utility.getName(distributionPo.getSdndnPerson()))) {
			buffer.append(" and S_DN_DN_Person=? ");
			params.add(Utility.getName(distributionPo.getSdndnPerson()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreatebgndate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)>=? ");
			params.add(Utility.getName(distributionPo.getSdndncreatebgndate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreateenddate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)<=? ");
			params.add(Utility.getName(distributionPo.getSdndncreateenddate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnshopcode()))) {			
			if (!"1".equals(Utility.getName(distributionPo.getSdndntype()))) {
				buffer.append(" and S_SE_SB_Location=? ");
			}else{
				buffer.append(" and S_SE_SB_ShopCode=? ");
			}
			params.add(Utility.getName(distributionPo.getSdndnshopcode()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnid()))) {
			buffer.append(" and S_DN_DN_ID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnid()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnsalesid()))) {
			buffer.append(" and S_DN_DE_SalesID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnsalesid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 获取门店已配送的列表
	 * @return
	 */
	public List<DistributionPo> getDoorStoreYetDeliveryList(DistributionPo distributionPo,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from (select ROW_NUMBER() Over(order by sdndncreatedate desc) as rowNum,* from ( select distinct S_DN_DN_ID as sdndnid,B_DP_DepartmentName as sdndnshopcode,S_DN_DN_CreateDate as sdndncreatedate,personName as sdndnPerson from S_DN_Distribution inner join S_DN_DistributionEntry on S_DN_DN_ID=S_DN_DE_DistributionID ");
		buffer.append(" inner join uview_SalesBasic on S_SE_SB_SalesID=S_DN_DE_SalesID left join SYS_PersonInfo on S_DN_DN_Person=id ");
		if (!"1".equals(Utility.getName(distributionPo.getSdndntype()))) {
			buffer.append(" left join B_Departments on S_SE_SB_Location=B_DP_DepartmentID  ");
		}else{
			buffer.append(" left join B_Departments on S_SE_SB_ShopCode=B_DP_DepartmentID  ");
		}
		buffer.append("  where 1=1 and S_DN_DN_Type=? ");
		
		params.add(Utility.getName(distributionPo.getSdndntype()));
		
		String ssesborderstypebuffer = "";
		for(int i=0; i<distributionPo.getSdndnorderstypes().length; i++){
			if(!"".equals(distributionPo.getSdndnorderstypes()[i].trim())){
				ssesborderstypebuffer = ssesborderstypebuffer+"?,";
				params.add(distributionPo.getSdndnorderstypes()[i].trim());
			}
		}
		
		if (!"".equals(ssesborderstypebuffer)){
			ssesborderstypebuffer = ssesborderstypebuffer.substring(0, ssesborderstypebuffer.length()-1);
			buffer.append("and S_SE_SB_OrdersType in("+ssesborderstypebuffer+") ");
		}else{
			buffer.append("and S_SE_SB_OrdersType in ('1','2','4') ");
		}		
		
		if (!"".equals(Utility.getName(distributionPo.getSdndnPerson()))) {
			buffer.append(" and S_DN_DN_Person=? ");
			params.add(Utility.getName(distributionPo.getSdndnPerson()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreatebgndate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)>=? ");
			params.add(Utility.getName(distributionPo.getSdndncreatebgndate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreateenddate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)<=? ");
			params.add(Utility.getName(distributionPo.getSdndncreateenddate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnshopcode()))) {
			if (!"1".equals(Utility.getName(distributionPo.getSdndntype()))) {
				buffer.append(" and S_SE_SB_Location=? ");
			}else{
				buffer.append(" and S_SE_SB_ShopCode=? ");
			}
			params.add(Utility.getName(distributionPo.getSdndnshopcode()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnid()))) {
			buffer.append(" and S_DN_DN_ID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnid()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnsalesid()))) {
			buffer.append(" and S_DN_DE_SalesID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnsalesid()));
		}

		buffer.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));
		
		return queryForObjectList(buffer.toString(),params.toArray(), DistributionPo.class);
	}
	
	/**
	 * 获取门店已配送信息
	 * @return
	 */
	public DistributionPo getDoorStoreYetDeliveryDetail(DistributionPo distributionPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if ("1".equals(Utility.getName(distributionPo.getSdndntype()))){
			buffer.append("select top 1 S_DN_DN_ID as sdndnid,a.personName as sdndnPerson,isnull(b.personName,'') as sdndnlogonpersonname,S_DN_DN_CreateDate as sdndncreatedate,S_DN_DN_Type as sdndntype,(select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID=(select top 1 S_SE_SB_ShopCode from uview_SalesBasic where S_SE_SB_SalesID=(select top 1 S_DN_DE_SalesID from S_DN_DistributionEntry where S_DN_DE_DistributionID=S_DN_DN_ID))) as sdndnshopcode,S_DN_DN_Type as sdndntype from S_DN_Distribution left join SYS_PersonInfo a on S_DN_DN_Person=a.id left join SYS_PersonInfo b on S_DN_DN_LogonPerson=b.id ");
		}else{
			buffer.append("select top 1 S_DN_DN_ID as sdndnid,a.personName as sdndnPerson,isnull(b.personName,'') as sdndnlogonpersonname,S_DN_DN_CreateDate as sdndncreatedate,S_DN_DN_Type as sdndntype,(select top 1 B_DP_DepartmentName from B_Departments where B_DP_DepartmentID=(select top 1 S_SE_SB_Location from uview_SalesBasic where S_SE_SB_SalesID=(select top 1 S_DN_DE_SalesID from S_DN_DistributionEntry where S_DN_DE_DistributionID=S_DN_DN_ID))) as sdndnshopcode,S_DN_DN_Type as sdndntype from S_DN_Distribution left join SYS_PersonInfo a on S_DN_DN_Person=a.id left join SYS_PersonInfo b on S_DN_DN_LogonPerson=b.id ");
		}
		buffer.append(" where S_DN_DN_ID = ? ");
		
		params.add(distributionPo.getSdndnid());

		return (DistributionPo)queryForObject(buffer.toString(), params.toArray(), DistributionPo.class);
	}
	
	/**
	 * 获取门店已配送明细
	 * @return
	 */
	public List<DistributionEntryPo> getDoorStoreYetDeliveryEntryDetail(DistributionPo distributionPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select S_DN_DE_SalesID as sdndesalesid,S_ME_CI_Name as sdndemembername,B_DP_DepartmentName as sdndeshopcode,S_SE_SB_TakeGlassData as sdndetakeDate,S_SE_SB_OrdersType as sdndeorderstype from S_DN_DistributionEntry ");
		buffer.append(" inner join uview_SalesBasic on S_SE_SB_SalesID=S_DN_DE_SalesID left join B_Departments on S_SE_SB_Location=B_DP_DepartmentID left join S_ME_CustomerInfo on S_SE_SB_CustomerID=S_ME_CI_CustomerID ");
		buffer.append("  where S_DN_DE_DistributionID=? ");
		
		params.add(distributionPo.getSdndnid());
		
		return queryForObjectList(buffer.toString(),params.toArray(), DistributionEntryPo.class);
	}
	
	/**
	 * 修改在途状态
	 * 
	 * @return
	 */
	public void updateSalesIntrnsitInfo(SalesBasicPo salesBasicPo){

		StringBuffer buffer = new StringBuffer();
		buffer.append("update top (1) S_SE_SalesBasic set  ");
		buffer.append("S_SE_SB_InTransit='6' ");
		buffer.append("where S_SE_SB_SalesID= ? ");

		List<String> params = new ArrayList<String>();
		params.add(salesBasicPo.getSsesbsalesid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询调拨配送信息
	 */
	public int selectAllocationSendOrSendedsCount(AllocationPo po) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(*) ");
		buffer.append("from C_SHA_Allocation ");
		buffer.append("inner join B_Departments outd on C_SHA_A_outDepartmentId = outd.B_DP_DepartmentID ");
		buffer.append("inner join B_Departments ind  on C_SHA_A_inDepartmentId  = ind.B_DP_DepartmentID ");
		buffer.append("inner join SYS_PersonInfo	on C_SHA_A_auditPerson	   = ID  ");
		buffer.append("where C_SHA_A_auditState = '1' and C_SHA_A_consignState <> '1' and Isnull(C_SHA_A_SendBillId, '') = '' ");
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    buffer.append(" and outd.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCshaabillid()))) {
			buffer.append(" and C_SHA_A_billID like '%'+?+'%' ");
			params.add(Utility.getName(po.getCshaabillid()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaauditperson()))) {
			buffer.append(" and C_SHA_A_auditPerson = ? ");
			params.add(Utility.getName(po.getCshaaauditperson()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaauditdatestart()))) {
			buffer.append(" and convert(varchar(10),C_SHA_A_auditDate,120) >= ? ");
			params.add(Utility.getName(po.getCshaaauditdatestart()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaauditdateend()))) {
			buffer.append(" and convert(varchar(10),C_SHA_A_auditDate,120) <= ? ");
			params.add(Utility.getName(po.getCshaaauditdateend()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))) {
			buffer.append(" and C_SHA_A_outDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaoutdepartmentid()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaindepartmentid()))) {
			buffer.append(" and C_SHA_A_inDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaindepartmentid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 查询调拨配送信息
	 */
	public List<AllocationPo> selectAllocationSendOrSendeds(AllocationPo po, int start, int size) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from (select ROW_NUMBER() Over(order by C_SHA_A_auditDate desc) as rowNum, ");
		buffer.append("C_SHA_A_billID 				as cshaabillid, ");
		buffer.append("outd.B_DP_DepartmentName 	as cshaaoutdepartmentname, ");
		buffer.append("ind.B_DP_DepartmentName 		as cshaaindepartmentname, ");
		buffer.append("convert(varchar(16), C_SHA_A_auditDate, 120)			as cshaaauditdate, ");
		buffer.append("personName 					as cshaaauditpersonname ");
		buffer.append("from C_SHA_Allocation ");
		buffer.append("inner join B_Departments outd on C_SHA_A_outDepartmentId = outd.B_DP_DepartmentID ");
		buffer.append("inner join B_Departments ind  on C_SHA_A_inDepartmentId  = ind.B_DP_DepartmentID ");
		buffer.append("inner join SYS_PersonInfo	on C_SHA_A_auditPerson	   = ID  ");
		buffer.append("where C_SHA_A_auditState = '1' and C_SHA_A_consignState <> '1' and Isnull(C_SHA_A_SendBillId, '') = '' ");
		
		if (!"".equals(Utility.getName(po.getCshaaindptcompanyid()))){
		    buffer.append(" and outd.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getCshaaindptcompanyid()));	
		}
		
		if (!"".equals(Utility.getName(po.getCshaabillid()))) {
			buffer.append(" and C_SHA_A_billID like '%'+?+'%' ");
			params.add(Utility.getName(po.getCshaabillid()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaauditperson()))) {
			buffer.append(" and C_SHA_A_auditPerson = ? ");
			params.add(Utility.getName(po.getCshaaauditperson()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaauditdatestart()))) {
			buffer.append(" and convert(varchar(10),C_SHA_A_auditDate,120) >= ? ");
			params.add(Utility.getName(po.getCshaaauditdatestart()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaauditdateend()))) {
			buffer.append(" and convert(varchar(10),C_SHA_A_auditDate,120) <= ? ");
			params.add(Utility.getName(po.getCshaaauditdateend()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaoutdepartmentid()))) {
			buffer.append(" and C_SHA_A_outDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaoutdepartmentid()));
		}
		
		if (!"".equals(Utility.getName(po.getCshaaindepartmentid()))) {
			buffer.append(" and C_SHA_A_inDepartmentId = ? ");
			params.add(Utility.getName(po.getCshaaindepartmentid()));
		}
		
		buffer.append(") temp where rowNum > " + start + " and rowNum <= "	+ (start + size));
		return queryForObjectList(buffer.toString(), params.toArray(),AllocationPo.class);
	}
	
	/**
	 * 修改调拨单配送状态
	 * 
	 * @return
	 */
	public void updateAllocationSendBillId(AllocationPo po){

		StringBuffer buffer = new StringBuffer();
		buffer.append("update C_SHA_Allocation set  ");
		buffer.append("C_SHA_A_SendBillId = ? ");
		buffer.append("where C_SHA_A_billID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(po.getCshaasendbillid()));
		params.add(Utility.getName(po.getCshaabillid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 新增配送记录明细表
	 * 
	 * @param po
	 */
	public void insertAllocationSendEntry(DistributionPo distributionPo,
			DistributionEntryPo distributionEntryPo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into S_DN_DistributionEntry ( ");
		buffer.append("S_DN_DE_ID, ");
		buffer.append("S_DN_DE_DistributionID, ");
		buffer.append("S_DN_DE_SalesID, ");
		buffer.append("S_DN_DE_OrdersType ) ");
		buffer.append("values (?,?,?,?)");
		
		List<String> params = new ArrayList<String>();		
		params.add(uuid.getInstance().generate());
		params.add(distributionEntryPo.getSdndedistributionid());
		params.add(distributionEntryPo.getSdndesalesid());
		params.add("");

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取门店已配送的数量
	 * @return
	 */
	public int selectAllocationSendedCount(DistributionPo distributionPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select count(distinct S_DN_DN_ID) from S_DN_Distribution inner join S_DN_DistributionEntry on S_DN_DN_ID=S_DN_DE_DistributionID ");
		buffer.append(" left join SYS_PersonInfo on S_DN_DN_Person=id  ");
		buffer.append(" where 1=1 and S_DN_DN_Type= '4' and S_DN_DN_DepartmentID = ? ");
		
		params.add(Utility.getName(distributionPo.getSdndndepartmentid()));
		
		if (!"".equals(Utility.getName(distributionPo.getSdndnPerson()))) {
			buffer.append(" and S_DN_DN_Person=? ");
			params.add(Utility.getName(distributionPo.getSdndnPerson()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreatebgndate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)>=? ");
			params.add(Utility.getName(distributionPo.getSdndncreatebgndate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreateenddate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)<=? ");
			params.add(Utility.getName(distributionPo.getSdndncreateenddate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnid()))) {
			buffer.append(" and S_DN_DN_ID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnid()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnsalesid()))) {
			buffer.append(" and S_DN_DE_SalesID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnsalesid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 获取门店已配送的列表
	 * @return
	 */
	public List<DistributionPo> selectAllocationSendedList(DistributionPo distributionPo,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from (select ROW_NUMBER() Over(order by sdndncreatedate desc) as rowNum,* from ( select distinct S_DN_DN_ID as sdndnid,S_DN_DN_CreateDate as sdndncreatedate,personName as sdndnPerson from S_DN_Distribution ");
		buffer.append(" inner join S_DN_DistributionEntry on S_DN_DN_ID=S_DN_DE_DistributionID ");
		buffer.append(" left join SYS_PersonInfo on S_DN_DN_Person=id ");
		buffer.append("  where 1=1 and S_DN_DN_Type='4' and S_DN_DN_DepartmentID = ? ");
		
		params.add(Utility.getName(distributionPo.getSdndndepartmentid()));
		
		if (!"".equals(Utility.getName(distributionPo.getSdndnPerson()))) {
			buffer.append(" and S_DN_DN_Person=? ");
			params.add(Utility.getName(distributionPo.getSdndnPerson()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreatebgndate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)>=? ");
			params.add(Utility.getName(distributionPo.getSdndncreatebgndate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndncreateenddate()))) {
			buffer.append(" and convert(varchar(10),S_DN_DN_CreateDate,120)<=? ");
			params.add(Utility.getName(distributionPo.getSdndncreateenddate()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnid()))) {
			buffer.append(" and S_DN_DN_ID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnid()));
		}
		if (!"".equals(Utility.getName(distributionPo.getSdndnsalesid()))) {
			buffer.append(" and S_DN_DE_SalesID like '%'+?+'%' ");
			params.add(Utility.getName(distributionPo.getSdndnsalesid()));
		}

		buffer.append(" )temp ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));
		
		return queryForObjectList(buffer.toString(),params.toArray(), DistributionPo.class);
	}
	
	/**
	 * 获取调拨已配送明细
	 * @return
	 */
	public List<DistributionEntryPo> getAllocationSendedEntryDetail(DistributionPo distributionPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select ");
		buffer.append("C_SHA_A_billID 										as sdndesalesid, ");
		buffer.append("sp.personName										as sdndepersonname, ");
		buffer.append("ap.personName										as sdndeallauditname, ");
		buffer.append("outd.B_DP_DepartmentName 							as sdndeoutdepartmentname, ");
		buffer.append("ind.B_DP_DepartmentName 								as sdndeindepartmentname, ");
		buffer.append("convert(varchar(16), C_SHA_A_auditDate, 120)			as sdndeallauditdate, ");
		buffer.append("convert(varchar(16), S_DN_DN_CreateDate, 120)		as sdndetakeDate ");
		buffer.append("from C_SHA_Allocation ");
		buffer.append("inner join S_DN_DistributionEntry on S_DN_DE_SalesID = C_SHA_A_billID ");
		buffer.append("inner join S_DN_Distribution	 on S_DN_DN_ID = S_DN_DE_DistributionID ");
		buffer.append("inner join B_Departments outd on C_SHA_A_outDepartmentId = outd.B_DP_DepartmentID ");
		buffer.append("inner join B_Departments ind  on C_SHA_A_inDepartmentId  = ind.B_DP_DepartmentID ");
		buffer.append("inner join SYS_PersonInfo ap	 on C_SHA_A_auditPerson	   	= ap.ID  ");
		buffer.append("inner join SYS_PersonInfo sp	 on S_DN_DN_Person	   		= sp.ID  ");
		buffer.append("where S_DN_DN_ID = ? ");
		
		params.add(distributionPo.getSdndnid());
		
		return queryForObjectList(buffer.toString(),params.toArray(), DistributionEntryPo.class);
	}
}
