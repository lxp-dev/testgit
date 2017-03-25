package com.pengsheng.eims.report.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.report.dao.ContrastAccountDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class ContrastAccountDaoImpl extends BaseJdbcDaoSupport implements ContrastAccountDao {

	/**
	 * 得到所有结果集
	 * @author SZK
	 * @param billID        单据号
	 * @param begDate       开始日期
	 * @param endDate       结束日期
	 * @param salesBillID   客户号
	 * @param supplierID    制造商ID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map> getGlassData(String billID,String begDate,String endDate,String salesBillID,String supplierID) {
		List<String> params = new ArrayList<String>();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select convert(varchar(10),C_ST_CPR_BillDate,120) as 单据日期,C_ST_CPR_ReceiptBillId as 单据号,");
		buffer.append("       B_GI_GoodsName as 商品名称,C_ST_CPOD_BallGlass as 球镜,C_ST_CPOD_PostGlass as 柱镜,");
		buffer.append("       C_ST_CPRD_Num as 数量,(C_ST_CPRD_CostPrice*C_ST_CPRD_Num) as 价税合计,");
		buffer.append("       right(C_ST_CPOD_GlassesBillID,9) as 客户号       ");
		buffer.append("  from C_ST_ConsignProcessReceipt inner join C_ST_ConsignProcessReceiptDetails on C_ST_CPR_ReceiptBillId=C_ST_CPRD_ReceiptBillD ");
		buffer.append("       left join B_GoodsInfo on C_ST_CPRD_GoodsID=B_GI_GoodsID ");
		buffer.append("       left join C_ST_ConsignProcessOrderDetails on C_ST_CPRD_OrderDetailsID=C_ST_CPOD_Id ");
		buffer.append("  where C_ST_CPR_AuditState='1' ");
        
		if (!"".equals(billID)){
			buffer.append(" and C_ST_CPR_ReceiptBillId like '%' + ? + '%' ");
			params.add(billID);
		}
		if(!"".equals(begDate)){
			buffer.append(" and convert(varchar(10),C_ST_CPR_BillDate,120) >= ? ");
			params.add(begDate);
		}
		if(!"".equals(endDate)){
			buffer.append("and convert(varchar(10),C_ST_CPR_BillDate,120) <= ? ");
			params.add(endDate);
		}
		if(!"".equals(supplierID)){
			buffer.append(" and C_ST_CPR_SupplierId = ? ");
			params.add(supplierID);
		}
		if(!"".equals(salesBillID)){
			buffer.append("and C_ST_CPOD_GlassesBillID like '%' + ? ");
			params.add(salesBillID);
		}
		buffer.append(" order by C_ST_CPR_BillDate,C_ST_CPR_ReceiptBillId ");
		
		return getJdbcTemplate().queryForList(buffer.toString(),params.toArray());
	}
}
