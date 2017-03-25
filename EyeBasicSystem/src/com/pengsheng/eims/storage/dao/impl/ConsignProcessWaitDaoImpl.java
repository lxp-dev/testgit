package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.ConsignProcessWaitDao;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.sun.org.apache.commons.collections.Buffer;

public class ConsignProcessWaitDaoImpl extends BaseJdbcDaoSupport implements ConsignProcessWaitDao {

	/**
	 * 得到委外订单收货信息的数量  主表
	 */
	public int getConsignProcessOrderCount(
			ConsignProcessOrderPo consignProcessOrderPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select count(C_ST_CPO_OrderBillId) ");
		buffer.append("from C_ST_ConsignProcessOrder ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) cr on C_ST_CPO_CreatePerson=cr.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) au on C_ST_CPO_AuditPerson=au.ID ");
		buffer.append("inner join B_GoodsCategory on B_GC_ID = C_ST_CPO_OrderGoodsCategory ");
		buffer.append("inner join B_Supplier on B_SP_ID = C_ST_CPO_SupplierId ");
		buffer.append("where 1 = 1 and C_ST_CPO_AuditPerson=1 ");
		buffer.append("and C_ST_CPO_OrderBillId in( ");
		buffer.append("select b.cstcpodorderbilld from( ");
		buffer.append("select a.cstcpodorderbilld , a.cstcpodgoodsid , sum(a.cstcpodnum) as cstcpodnum ");
		buffer.append("from(select C_ST_CPOD_OrderBillD as cstcpodorderbilld , C_ST_CPOD_GoodsID as cstcpodgoodsid , ");
		buffer.append("C_ST_CPOD_Num as cstcpodnum from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD ");
		buffer.append("and C_ST_CPO_AuditState = '1' ");
		buffer.append("union all select C_ST_V_PoID as cstpid , C_ST_V_GoodsId as goodsid , -C_ST_V_Num as goodsquantity ");
		buffer.append("from C_ST_Verification ");
		buffer.append("where C_ST_V_PinID like 'CPIN%' ");
		buffer.append(")a group by a.cstcpodorderbilld, a.cstcpodgoodsid ");
		buffer.append(")b where b.cstcpodnum>0 ");
		buffer.append("group by cstcpodorderbilld) ");
		
		List<String> params=new ArrayList<String>();
		
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoorderbillid()))) {
			buffer.append("and C_ST_CPO_OrderBillId= ? ");
			params.add(consignProcessOrderPo.getCstcpoorderbillid());
		}
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoordergoodscategory()))) {
			buffer.append("and C_ST_CPO_OrderGoodsCategory = ? ");
			params.add(consignProcessOrderPo.getCstcpoordergoodscategory());
		}
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcposupplierid()))) {
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderPo.getCstcposupplierid());
		}

		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");
			params.add(consignProcessOrderPo.getCstcpostarttime());
			params.add(consignProcessOrderPo.getCstcpoendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))&& "".equals(Utility.getName(consignProcessOrderPo.getCstcpoendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");
			params.add(consignProcessOrderPo.getCstcpostarttime());
		} else if ("".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");
			params.add(consignProcessOrderPo.getCstcpoendtime());
		}
		if(!"".equals(Utility.getName(consignProcessOrderPo.getCstcpocreateperson()))){
			buffer.append("and C_ST_CPO_CreatePerson=? ");
			params.add(consignProcessOrderPo.getCstcpocreateperson());
		}
		if(!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoauditperson()))){
			buffer.append("and C_ST_CPO_AuditPerson=? ");
			params.add(consignProcessOrderPo.getCstcpoauditperson());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到委外订单收货信息的数量 明细表   从表
	 */
	public int getConsignProcessOrderDetailsCount(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select count(C_ST_CPOD_GoodsID) ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD ");
		buffer.append("LEFT outer join C_ST_Verification  ON C_ST_V_OrderDetailsID = C_ST_CPOD_Id ");
		buffer.append("inner join B_GoodsInfo  on C_ST_CPOD_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		buffer.append("where C_ST_CPOD_OrderBillD= ? ");
		
		List<String> params =new ArrayList<String>();
		
		params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 得到委外订单收货信息   明细表  从表
	 */
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("select C_ST_CPOD_OrderBillD as cstcpodorderbilld, C_ST_CPOD_GlassesBillID as cstcpodglassesbillid, ");
		buffer.append("C_ST_CPOD_GoodsID as cstcpodgoodsid, B_GI_ViewGoodsName as cstcpodgoodsname, ");
		buffer.append("C_ST_CPOD_Num - isnull(C_ST_V_Num, 0) as cstcpodnum, ");
		buffer.append("C_ST_CPOD_BallGlass as cstcpodballglass, C_ST_CPOD_PostGlass as cstcpodpostglass, ");
		buffer.append("C_ST_CPOD_Axes as cstcpodaxes, C_ST_CPOD_EyeCurvature as cstcpodeyecurvature, ");
		buffer.append("C_ST_CPOD_Diameter as cstcpoddiameter, B_GI_Color as cstcpobgicolor, ");
		buffer.append("B_GI_Spec as cstcpobgispec, B_GI_GoodsBarCode as cstcpodgoodsbarcode, ");
		buffer.append("B_GI_RetailPrice as cstcporetailprice , B_GI_NotTaxRate as cstcponottaxrate , ");
		buffer.append("B_GI_TaxRate as cstcpotaxrate ");
		buffer.append("from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD ");
		buffer.append("LEFT outer join C_ST_Verification  ON C_ST_V_OrderDetailsID = C_ST_CPOD_Id ");
		buffer.append("inner join B_GoodsInfo  on C_ST_CPOD_GoodsID = B_GoodsInfo.B_GI_GoodsID ");
		buffer.append("where C_ST_CPOD_OrderBillD= ? ");
		
		List<String> params =new ArrayList<String>();
		
		params.add(consignProcessOrderDetailsPo.getCstcpodorderbilld());
		
		return queryForObjectList(buffer.toString(), params.toArray(), ConsignProcessOrderDetailsPo.class);
	}

	/**
	 * 得到委外订单收货信息 主表
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();

		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_CPO_OrderBillId desc) as rowNum, ");		
		buffer.append("C_ST_CPO_OrderBillId as cstcpoorderbillid , C_ST_CPO_BillDate as cstcpobilldate , ");
		buffer.append("B_SP_SupplierName as bspsuppliername, C_ST_CPO_SupplierId as cstcposupplierid , C_ST_CPO_OrderGoodsCategory as cstcpoordergoodscategory , ");
		buffer.append("cr.personName as createPersonName, au.personName as auditPersonName ");
		buffer.append("from C_ST_ConsignProcessOrder ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) cr on C_ST_CPO_CreatePerson=cr.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) au on C_ST_CPO_AuditPerson=au.ID ");
		buffer.append("inner join B_GoodsCategory on B_GC_ID = C_ST_CPO_OrderGoodsCategory ");
		buffer.append("inner join B_Supplier on B_SP_ID = C_ST_CPO_SupplierId ");
		buffer.append("where 1 = 1 and C_ST_CPO_AuditPerson=1 ");
		buffer.append("and C_ST_CPO_OrderBillId in( ");
		buffer.append("select b.cstcpodorderbilld from( ");
		buffer.append("select a.cstcpodorderbilld , a.cstcpodgoodsid , sum(a.cstcpodnum) as cstcpodnum ");
		buffer.append("from(select C_ST_CPOD_OrderBillD as cstcpodorderbilld , C_ST_CPOD_GoodsID as cstcpodgoodsid , ");
		buffer.append("C_ST_CPOD_Num as cstcpodnum from C_ST_ConsignProcessOrderDetails ");
		buffer.append("inner join C_ST_ConsignProcessOrder ON C_ST_CPO_OrderBillId = C_ST_CPOD_OrderBillD ");
		buffer.append("and C_ST_CPO_AuditState = '1' ");
		buffer.append("union all select C_ST_V_PoID as cstpid , C_ST_V_GoodsId as goodsid , -C_ST_V_Num as goodsquantity ");
		buffer.append("from C_ST_Verification ");
		buffer.append("where C_ST_V_PinID like 'CPIN%' ");
		buffer.append(")a group by a.cstcpodorderbilld, a.cstcpodgoodsid ");
		buffer.append(")b where b.cstcpodnum>0 ");
		buffer.append("group by cstcpodorderbilld) ");
		
		List<String> params=new ArrayList<String>();
		
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoorderbillid()))) {
			buffer.append("and C_ST_CPO_OrderBillId= ? ");
			params.add(consignProcessOrderPo.getCstcpoorderbillid());
		}
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoordergoodscategory()))) {
			buffer.append("and C_ST_CPO_OrderGoodsCategory = ? ");
			params.add(consignProcessOrderPo.getCstcpoordergoodscategory());
		}
		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcposupplierid()))) {
			buffer.append("and C_ST_CPO_SupplierId = ? ");
			params.add(consignProcessOrderPo.getCstcposupplierid());
		}

		if (!"".equals(Utility.getName(consignProcessOrderPo.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");
			params.add(consignProcessOrderPo.getCstcpostarttime());
			params.add(consignProcessOrderPo.getCstcpoendtime());
		} else if (!"".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))&& "".equals(Utility.getName(consignProcessOrderPo.getCstcpoendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) >= ? ");
			params.add(consignProcessOrderPo.getCstcpostarttime());
		} else if ("".equals(Utility.getName(consignProcessOrderPo
				.getCstcpostarttime()))
				&& !"".equals(Utility.getName(consignProcessOrderPo
						.getCstcpoendtime()))) {
			buffer.append("and convert(varchar(10), C_ST_CPO_BillDate, 23) <= ? ");
			params.add(consignProcessOrderPo.getCstcpoendtime());
		}
		if(!"".equals(Utility.getName(consignProcessOrderPo.getCstcpocreateperson()))){
			buffer.append("and C_ST_CPO_CreatePerson=? ");
			params.add(consignProcessOrderPo.getCstcpocreateperson());
		}
		if(!"".equals(Utility.getName(consignProcessOrderPo.getCstcpoauditperson()))){
			buffer.append("and C_ST_CPO_AuditPerson=? ");
			params.add(consignProcessOrderPo.getCstcpoauditperson());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),ConsignProcessOrderPo.class);
	}

	/**
	 * 插入委外收货信息   插入主表中
	 */
	public void insertConsignProcessReceipt(
			ConsignProcessReceiptPo consignProcessReceiptPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("insert into C_ST_ConsignProcessReceipt ");
		buffer.append("(C_ST_CPR_ReceiptBillId , C_ST_CPR_SourceBillId , C_ST_CPR_BillDate , C_ST_CPR_GoodsCategory , ");
		buffer.append("C_ST_CPR_SupplierId , C_ST_CPR_InStockId , C_ST_CPR_DepartmentId , C_ST_CPR_CreatePerson , ");
		buffer.append("C_ST_CPR_AuditPerson , C_ST_CPR_Remark , C_ST_CPR_AuditState ) ");
		buffer.append("values(? , ? , getdate() , ? , ? , ? , ? , ? , ? , ? , ? ) ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(consignProcessReceiptPo.getCstcprreceiptbillid());
		params.add(consignProcessReceiptPo.getCstcprsourcebillid());
//		params.add(consignProcessReceiptPo.getCstcprbilldate());
		params.add(consignProcessReceiptPo.getCstcprgoodscategory());
		params.add(consignProcessReceiptPo.getCstcprsupplierid());
		params.add(consignProcessReceiptPo.getCstcprinstockid());
		params.add(consignProcessReceiptPo.getCstcprdepartmentid());
		params.add(consignProcessReceiptPo.getCstcprcreateperson());
		params.add(consignProcessReceiptPo.getCstcprauditperson());
		params.add(consignProcessReceiptPo.getCstcprremark());
		params.add(consignProcessReceiptPo.getCstcprauditstate());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 插入委外收货信息   插入从表中
	 */
	public void insertConsignProcessReceiptDetails(
			ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		
		buffer.append("insert into C_ST_ConsignProcessReceiptDetails ");
		buffer.append("(C_ST_CPRD_Id , C_ST_CPRD_ReceiptBillD , C_ST_CPRD_OrderDetailsID , C_ST_CPRD_GoodsID , ");
		buffer.append("C_ST_CPRD_BarCode , C_ST_CPRD_Num , C_ST_CPRD_InStockId , C_ST_CPRD_NotTaxRate , ");
		buffer.append("C_ST_CPRD_TaxRate , C_ST_CPRD_CostPrice) ");
		buffer.append("values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ");
		
		List<String> params = new ArrayList<String>();
		
		params.add(this.uuid.generate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdreceiptbilld());
		params.add(this.uuid.generate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdgoodsid());
		params.add(consignProcessReceiptDetailsPo.getCstcprdbarcode());
		params.add(consignProcessReceiptDetailsPo.getCstcprdnum());
		params.add(consignProcessReceiptDetailsPo.getCstcprdinstockid());
		params.add(consignProcessReceiptDetailsPo.getCstcprdnottaxrate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdtaxrate());
		params.add(consignProcessReceiptDetailsPo.getCstcprdcostprice());
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}

	/**
	 * 新增核销表
	 */
	public void insertVerification(VerificationPo po) {
		// TODO Auto-generated method stub
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		sb1.append("insert into C_ST_Verification(C_ST_V_PinID,C_ST_V_GoodsId,C_ST_V_BarCode,C_ST_V_Num,C_ST_V_Datetime,C_ST_V_UUID");
		sb2.append("?,?,?,?,getdate(),?");		
		
		List<String> params = new ArrayList<String>();
		
		params.add(po.getCstvpinid());	
		params.add(po.getCstvgoodsid());	
		params.add(po.getCstvbarcode());
		params.add(po.getCstvnum());
		params.add(this.uuid.generate());
		
		if(!"".equals(Utility.getName(po.getCstvpoid()))){
			sb1.append(",C_ST_V_PoID");
			sb2.append(",?");
			params.add(po.getCstvpoid());
		}
		String sql=sb1.toString()+")values("+sb2.toString()+")";
		
		getJdbcTemplate().update(sql, params.toArray());
		
	}
	
	public void buildInventory(String id) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_ST_Inventory select ");
		buffer.append("C_ST_CPR_ReceiptBillId, ");
		buffer.append("9, ");
		buffer.append("C_ST_CPR_SourceBillId, ");
		buffer.append("C_ST_CPR_BillDate, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPR_InStockId, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPR_SupplierId, ");
		buffer.append("null, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPR_DepartmentId, ");
		buffer.append("C_ST_CPR_CreatePerson, ");
		buffer.append("C_ST_CPR_AuditPerson, ");
		buffer.append("C_ST_CPR_AuditState, ");
		buffer.append("C_ST_CPR_AuditDate, ");
		buffer.append("null, ");
		buffer.append("0, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPR_Remark, ");
		buffer.append("0, ");
		buffer.append("null, ");
		buffer.append("null ");
		buffer.append("from C_ST_ConsignProcessReceipt ");
		buffer.append("where C_ST_CPR_ReceiptBillId = ?");

		getJdbcTemplate().update(buffer.toString(), new String[] { id });
	}

	public void buildInventoryEntry(String id) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO C_ST_InventoryEntry ");
		buffer.append("select ");
		buffer.append("REPLACE(NEWID(), '-', ''), ");
		buffer.append("C_ST_CPRD_ReceiptBillD, ");
		buffer.append("C_ST_CPRD_GoodsID, ");
		buffer.append("C_ST_CPRD_Num, ");
		buffer.append("C_ST_CPRD_NotTaxRate, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPRD_TaxRate, ");
		buffer.append("C_ST_CPRD_CostPrice, ");
		buffer.append("null, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPRD_InStockId, ");
		buffer.append("null, ");
		buffer.append("C_ST_CPRD_BarCode, ");
		buffer.append("GETDATE(), ");
		buffer.append("null, ");
		buffer.append("0 ");
		buffer.append("from C_ST_ConsignProcessReceiptDetails ");
		buffer.append("where C_ST_CPRD_ReceiptBillD = ? ");

		getJdbcTemplate().update(buffer.toString(), new String[] { id });
	}

}
