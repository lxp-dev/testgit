package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessDeliverDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliverPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
/**
 * 委外送货dao实现类
 */
public class ConsignProcessDeliverDaoImpl extends BaseJdbcDaoSupport implements ConsignProcessDeliverDao {
	
	/**
	 * 获取委外送货的数量
	 * @param po DeliverPo
	 * @return int 数量
	 */	
	public int getConsignProcessDeliverCount(DeliverPo deliverPo) {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("select count(C_ST_D_DeliverBillId) ");
		sb.append(" from C_ST_Deliver ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo)a on C_ST_Deliver.C_ST_D_CreatePerson=a.ID ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo)b on C_ST_Deliver.C_ST_D_AuditPerson=b.ID ");
		sb.append("where 1=1");
				
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(deliverPo.getCstddeliverbillid()))){
			sb.append("and C_ST_Deliver.C_ST_D_DeliverBillId like '%'+?+'%' ");//quyanping
			params.add(deliverPo.getCstddeliverbillid());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdstarttime())) && !"".equals(Utility.getName(deliverPo.getCstdendtime()))){
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) <= ? ");
			params.add(deliverPo.getCstdstarttime());
			params.add(deliverPo.getCstdendtime());
		}else if(!"".equals(Utility.getName(deliverPo.getCstdstarttime())) && "".equals(Utility.getName(deliverPo.getCstdendtime()))){
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) >= ? ");
			params.add(deliverPo.getCstdstarttime());
		}else if("".equals(Utility.getName(deliverPo.getCstdstarttime())) && !"".equals(Utility.getName(deliverPo.getCstdendtime()))){
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) <= ? ");
			params.add(deliverPo.getCstdendtime());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdcreateperson()))){
			sb.append("and a.personName like '%'+?+'%' ");
			params.add(deliverPo.getCstdcreateperson());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdauditperson()))){
			sb.append("and b.personName like '%'+?+'%' ");
			params.add(deliverPo.getCstdauditperson());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdauditstate()))){
			sb.append("and C_ST_Deliver.C_ST_D_AuditState=? ");
			params.add(deliverPo.getCstdauditstate());
		}

		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	/**
	 * 获取委外送货的list
	 * @param po DeliverPo
	 * @param start
	 * @param size 
	 * @return list DeliverPo的list
	 */	
	public List<DeliverPo> getConsignProcessDeliverList(DeliverPo deliverPo,
			int start, int size) {

		StringBuffer sb=new StringBuffer();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");	
		
		sb.append("select * from(");
		sb.append("select ROW_NUMBER() Over(order by C_ST_D_DeliverBillId desc) as rowNum,");
		sb.append("C_ST_D_DeliverBillId as cstddeliverbillid, ");
		sb.append("C_ST_D_DeliverDate as cstddeliverdate, ");
		sb.append("C_ST_D_DeliverDept as cstddeliverdept, ");
		sb.append("a.personName as cstdcreatepersonname, ");
		sb.append("b.personName as cstdauditpersonname, ");
		sb.append("C_ST_D_AuditDate as cstdauditdate, ");
		sb.append("C_ST_D_AuditState as cstdauditstate, ");
		sb.append("C_ST_D_Remark as cstdremark ");
		sb.append(" from C_ST_Deliver ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo)a on C_ST_Deliver.C_ST_D_CreatePerson=a.ID ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo)b on C_ST_Deliver.C_ST_D_AuditPerson=b.ID ");
		sb.append("where 1=1");
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(deliverPo.getCstddeliverbillid()))){
			sb.append("and C_ST_Deliver.C_ST_D_DeliverBillId like '%' + ? + '%' ");//quyanping
			params.add(deliverPo.getCstddeliverbillid());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdstarttime())) && !"".equals(Utility.getName(deliverPo.getCstdendtime()))){
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) >= ? ");
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) <= ? ");
			params.add(deliverPo.getCstdstarttime());
			params.add(deliverPo.getCstdendtime());
		}else if(!"".equals(Utility.getName(deliverPo.getCstdstarttime())) && "".equals(Utility.getName(deliverPo.getCstdendtime()))){
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) >= ? ");
			params.add(deliverPo.getCstdstarttime());
		}else if("".equals(Utility.getName(deliverPo.getCstdstarttime())) && !"".equals(Utility.getName(deliverPo.getCstdendtime()))){
			sb.append("and convert(varchar(10), C_ST_Deliver.C_ST_D_DeliverDate, 23) <= ? ");
			params.add(deliverPo.getCstdendtime());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdcreateperson()))){
			sb.append("and a.personName like '%'+?+'%' ");
			params.add(deliverPo.getCstdcreateperson());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdauditperson()))){
			sb.append("and b.personName like '%'+?+'%' ");
			params.add(deliverPo.getCstdauditperson());
		}
		if(!"".equals(Utility.getName(deliverPo.getCstdauditstate()))){
			sb.append("and C_ST_Deliver.C_ST_D_AuditState=? ");
			params.add(deliverPo.getCstdauditstate());
		}
		
		sb.append(" ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), DeliverPo.class);
	}
	/**
	 * 新增委外送货主表
	 * @param po InventoryPo
	 */	
	public void insertConsignProcessDeliver(DeliverPo deliverPo) {

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append("insert into C_ST_Deliver(C_ST_D_DeliverBillId,C_ST_D_DeliverDate,C_ST_D_DeliverDept,C_ST_D_CreatePerson,C_ST_D_AuditState,C_ST_D_Remark");
		sb2.append("?,getdate(),?,?,?,?");
		
		List<String> params = new ArrayList<String>();
		
		params.add(deliverPo.getCstddeliverbillid());
		params.add(deliverPo.getCstddeliverdept());
		params.add(deliverPo.getCstdcreateperson());
		params.add(deliverPo.getCstdauditstate());
		params.add(deliverPo.getCstdremark());
		
		if(!"".equals(Utility.getName(deliverPo.getCstdauditperson()))){
			sb1.append(",C_ST_D_AuditPerson,C_ST_D_AuditDate");
			sb2.append(",?,getdate()");
			params.add(deliverPo.getCstdauditperson());
		}
		
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		getJdbcTemplate().update(sql, params.toArray());
		
	}
	/**
	 * 新增委外送货从表
	 * @param po InventoryPo
	 */	
	public void insertConsignProcessDeliverEntry(DeliverEntryPo deliverEntryPo) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("insert into C_ST_DeliverEntry(C_ST_DE_ID,C_ST_DE_DeliverBillId,C_ST_DE_ReceiptBillId");
		sb.append(",C_ST_DE_OrderDetailsID,C_ST_DE_GlassesBillId,C_ST_DE_GoodsID,C_ST_DE_BarCode,C_ST_DE_Num)");
		sb.append("values(?,?,?,?,?,?,?,?)");
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());	
		params.add(deliverEntryPo.getCstdedeliverbillid());	
		params.add(deliverEntryPo.getCstdereceiptbillid());	
		params.add(deliverEntryPo.getCstdeorderdetailsid());	
		params.add(deliverEntryPo.getCstdeglassesbillid());	
		params.add(deliverEntryPo.getCstdegoodsid());	
		params.add(deliverEntryPo.getCstdebarcode());	
		params.add(deliverEntryPo.getCstdenum());	
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
				
	}
	
	/**
	 * 获取委外送货的主表
	 * @param deliverPo DeliverPo
	 * @return DeliverPo
	 */	
	public DeliverPo getConsignProcessDeliver(DeliverPo deliverPo) {

		StringBuffer sb = new StringBuffer();

		sb.append("select top 1  C_ST_D_DeliverBillId as cstddeliverbillid, ");
		sb.append("C_ST_D_DeliverDate as cstddeliverdate, ");
		sb.append("C_ST_D_DeliverDept as cstddeliverdept, ");
		sb.append("C_ST_D_CreatePerson as cstdcreateperson, ");
		sb.append("a.personName as cstdcreatepersonname, ");
		sb.append("C_ST_D_AuditPerson as cstdauditperson, ");
		sb.append("b.personName as cstdauditpersonname, ");
		sb.append("C_ST_D_AuditDate as cstdauditdate, ");
		sb.append("C_ST_D_AuditState as cstdauditstate, ");
		sb.append("C_ST_D_Remark as cstdremark ");
		sb.append(" from C_ST_Deliver ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo)a on C_ST_Deliver.C_ST_D_CreatePerson=a.ID ");
		sb.append(" left join (select ID,personName from SYS_PersonInfo)b on C_ST_Deliver.C_ST_D_AuditPerson=b.ID ");	
		sb.append(" where C_ST_D_DeliverBillId=?");
		
		List<String> params = new ArrayList<String>();
		params.add(deliverPo.getCstddeliverbillid());
		
		return (DeliverPo)queryForObject(sb.toString(), params.toArray(), DeliverPo.class);
	}
	/**
	 * 获取委外送货的从表
	 * @param deliverPo DeliverPo
	 * @return list DeliverEntryPo的list
	 */	
	public List<ConsignProcessOrderDetailsPo> getConsignProcessDeliverEntryList(
			DeliverPo deliverPo) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("select C_ST_DE_ReceiptBillId as cstcprdreceiptbilld,C_ST_DE_OrderDetailsID as cstcpodid,");
		sb.append("C_ST_DE_GlassesBillId as cstcpodglassesbillid,C_ST_DE_GoodsID as cstcpodgoodsid,");
		sb.append("C_ST_DE_BarCode as cstcpodgoodsbarcode,C_ST_DE_Num as cstcpodnum,");
		sb.append("C_ST_CPOD_GlassFlag as cstcpodglassflag,B_GI_ViewGoodsName as cstcpodgoodsname,");
		sb.append("C_ST_CPOD_BallGlass as cstcpodballglass,C_ST_CPOD_PostGlass as cstcpodpostglass,");
		sb.append("C_ST_CPOD_Axes as cstcpodaxes,C_ST_CPOD_Add as cstcpodadd,");
		sb.append("C_ST_CPOD_ArriseGlass as cstcpodarriseglass,C_ST_CPOD_Basis as cstcpodbasis,");
		sb.append("C_ST_CPOD_EyeCurvature as cstcpodeyecurvature,C_ST_CPOD_Diameter as cstcpoddiameter,");
		sb.append("C_ST_CPOD_Requirement as cstcpodrequirement,C_ST_CPOD_customerName as cstcpodcustomername ");
		sb.append(" from C_ST_DeliverEntry");
		sb.append(" inner join C_ST_ConsignProcessOrderDetails on C_ST_DeliverEntry.C_ST_DE_OrderDetailsID=C_ST_ConsignProcessOrderDetails.C_ST_CPOD_Id ");	
		sb.append(" inner join B_GoodsInfo on C_ST_DeliverEntry.C_ST_DE_GoodsID=B_GI_GoodsID");
		sb.append(" where C_ST_DE_DeliverBillId=? ");
		
		List<String> params = new ArrayList<String>();
		params.add(deliverPo.getCstddeliverbillid());
		
		return queryForObjectList(sb.toString(), params.toArray(), ConsignProcessOrderDetailsPo.class);
	}
	/**
	 * 修改委外送货表
	 * @param deliverPo DeliverPo
	 * @param deliverEntryPoList List<DeliverEntryPo>
	 */	
	public void updateConsignProcessDeliver(DeliverPo deliverPo) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("update C_ST_Deliver set C_ST_D_DeliverDept=?,C_ST_D_Remark=?");
				
		List<String> params = new ArrayList<String>();
		
		params.add(deliverPo.getCstddeliverdept());	
		params.add(deliverPo.getCstdremark());	
		
		if (!"".equals(Utility.getName(deliverPo.getCstdauditperson()))) {
			sb.append(",C_ST_D_AuditState= ? ");
			sb.append(",C_ST_D_AuditPerson= ?, ");
			sb.append("C_ST_D_AuditDate=getdate() ");
			params.add(deliverPo.getCstdauditstate());
			params.add(deliverPo.getCstdauditperson());
		}
		
		sb.append(" where C_ST_D_DeliverBillId=? ");
		params.add(deliverPo.getCstddeliverbillid());	
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}
	/**
	 * 删除委外送货主表
	 * @param deliverPo DeliverPo
	 */	
	public void deleteConsignProcessDeliver(DeliverPo deliverPo) {
		
		String sql="delete from C_ST_Deliver where C_ST_D_DeliverBillId=? ";		
		
		List<String> params = new ArrayList<String>();
		params.add(deliverPo.getCstddeliverbillid());	
		
		getJdbcTemplate().update(sql, params.toArray());
	}
	/**
	 * 删除委外送货从表
	 * @param deliverPo DeliverPo
	 */	
	public void deleteConsignProcessDeliverEntry(DeliverPo deliverPo) {

		String sql="delete from C_ST_DeliverEntry where C_ST_DE_DeliverBillId=? ";		
		
		List<String> params = new ArrayList<String>();
		params.add(deliverPo.getCstddeliverbillid());	
		
		getJdbcTemplate().update(sql, params.toArray());
		
	}

}
