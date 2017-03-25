/**
 * 
 */
package com.pengsheng.eims.report.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.report.dao.QmshtDao;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

/**
 * @author Liuqian
 * 
 */
public class QmshtDaoImpl extends BaseJdbcDaoSupport implements QmshtDao {

	/**
	 * 得到所有结果集
	 * 
	 * @param ShopCode
	 * @param begDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryEntryPo> getGlassData(String ShopCode, String begDate,String endDate) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> parems = new ArrayList<String>();
		
		buffer.append("select cstiegoodsname,t.R_FD_SG_OrderByID,isnull(cstiegoodsquantity,0) as cstiegoodsquantity,isnull(cstienottaxrateamount,0.00) as cstienottaxrateamount from ( ");
		buffer.append("	select 1 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 2 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 3 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 4 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 5 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 6 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 7 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 8 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 9 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 10 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 11 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 12 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 13 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 14 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 15 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 16 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 17 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 18 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 19 as R_FD_SG_OrderByID ");
		buffer.append("	union all ");
		buffer.append("	select 20 as R_FD_SG_OrderByID ");
		buffer.append(")t left join ( ");
				
		if("02".equals(ShopCode)){
			buffer.append("select R_FD_SG_GoodsDescribe AS cstiegoodsname,R_FD_SG_OrderByID,isnull(sum(R_FD_SG_GoodsGuantity),0) as cstiegoodsquantity,isnull(sum(R_FD_SG_GoodsAmount),0.00) as cstienottaxrateamount from R_FD_SalesGuide where R_FD_SG_DepartmentID in('02','12') and R_FD_SG_Date>= ? and R_FD_SG_Date <=? group by R_FD_SG_GoodsDescribe,R_FD_SG_OrderByID ");
			parems.add(begDate);
			parems.add(endDate);
		} else {
			buffer.append("select R_FD_SG_GoodsDescribe AS cstiegoodsname,R_FD_SG_OrderByID,isnull(sum(R_FD_SG_GoodsGuantity),0) as cstiegoodsquantity,isnull(sum(R_FD_SG_GoodsAmount),0.00) as cstienottaxrateamount from R_FD_SalesGuide where R_FD_SG_DepartmentID=? and R_FD_SG_Date>= ? and R_FD_SG_Date <=? group by R_FD_SG_GoodsDescribe,R_FD_SG_OrderByID ");
			parems.add(ShopCode);
			parems.add(begDate);
			parems.add(endDate);
		}
		
		
		buffer.append(" )t1 on t.R_FD_SG_OrderByID = t1.R_FD_SG_OrderByID order by t.R_FD_SG_OrderByID ");
		
		//System.out.println(queryForObjectList(buffer.toString(),parems.toArray(),InventoryEntryPo.class).size()+"------");
		
		return queryForObjectList(buffer.toString(),parems.toArray(),InventoryEntryPo.class);
	}

	/**
	 * 得到隐形所有结果集
	 * 
	 * @param ShopCode
	 * @param begDate
	 * @param endDate
	 * @return
	 */
	public List<Map> getGlassDataYX(String ShopCode, String begDate,
			String endDate) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("exec [QMSHT_yx] ?, ? , ?");

		return getJdbcTemplate().queryForList(buffer.toString(),
				new String[] { ShopCode, begDate, endDate });
	}
	
	/**
	 * 得到销售金额和销售数量
	 * 
	 * @param ShopCode
	 * @param begDate
	 * @param endDate
	 * @return
	 */
	public SalesDetailPo getSalesData(String ShopCode,String begDate,String endDate) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select top 1  isnull(sum(S_SE_SD_Number),0) as ssesdnumber,isnull(sum(S_SE_SD_SalesValue),0) as ssesdsalesvalue ");
		buffer.append(" from uview_SalesDetail inner join uview_SalesBasic on S_SE_SD_SalesID=S_SE_SB_SalesID ");
		buffer.append(" where S_SE_SB_ShopCode=? and substring(convert(varchar(10),S_SE_SB_PosDatetime,120),1,10) between ? and ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(ShopCode);
		params.add(begDate);
		params.add(endDate);
		
		return (SalesDetailPo)queryForObject(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}
}
