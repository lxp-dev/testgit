package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.OrdersStatusReturnDao;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.orders.storage.persistence.ReturnsEntryPo;
import com.pengsheng.orders.storage.persistence.ReturnsPo;

public class OrdersStatusReturnDaoImpl extends BaseJdbcDaoSupport implements OrdersStatusReturnDao {

	/**
	 * 得到退货信息数量
	 * @param returnsPo
	 * @return
	 */
	public int getOrdersStatusReturnCount(ReturnsPo returnsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select count(C_ST_R_ID) ");
		buffer.append("from Orders.orders.dbo.C_ST_Returns ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_R_SupplierID ");
		buffer.append("inner join Orders.orders.dbo.SYS_PersonInfo on ID = C_ST_R_CreatePerson ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(returnsPo.getCstrid()))){
			buffer.append("and C_ST_R_ID like '%' + ? +'%' ");//quyanping
			
			//params.add(returnsPo.getCstrcompanyid());
			params.add(returnsPo.getCstrid());
		}else if("".equals(Utility.getName(returnsPo.getCstrid()))){
			buffer.append("and C_ST_R_ID like '%' + ? +'%' ");//quyanping
			
			params.add(returnsPo.getCstrcompanyid());
		}
		
		if(!"".equals(Utility.getName(returnsPo.getCstrauditstate()))){
			buffer.append("and C_ST_R_AuditState = ? ");
			params.add(returnsPo.getCstrauditstate());
		}
		
		if(!"".equals(Utility.getName(returnsPo.getCstrsupplierid()))){
			buffer.append("and C_ST_R_SupplierID = (select B_SP_OrderSupplierID ");
			buffer.append("from B_Supplier where B_SP_ID = ? ) ");
			params.add(returnsPo.getCstrsupplierid());
		}
		
		if (!"".equals(Utility.getName(returnsPo.getCstrbillstartdate()))	&& !"".equals(Utility.getName(returnsPo.getCstrbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) <= ? ");

			params.add(returnsPo.getCstrbillstartdate());
			params.add(returnsPo.getCstrbillenddate());
		} else if (!"".equals(Utility.getName(returnsPo.getCstrbillstartdate()))&& "".equals(Utility.getName(returnsPo.getCstrbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) >= ? ");

			params.add(returnsPo.getCstrbillstartdate());
		} else if ("".equals(Utility.getName(returnsPo.getCstrbillstartdate()))&& !"".equals(Utility.getName(returnsPo.getCstrbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) <= ? ");

			params.add(returnsPo.getCstrbillenddate());
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString() , params.toArray());
	}

	/**
	 * 查询退货信息
	 * @param returnsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ReturnsPo> selectOrdersStatusReturn(ReturnsPo returnsPo,
			int start, int size) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from( ");
		buffer.append("select ROW_NUMBER() Over( ");
		buffer.append("order by C_ST_R_ID) as rowNum, ");
		
		buffer.append("C_ST_R_ID as cstrid , ");
		buffer.append("B_DP_DepartmentName as cstrsuppliername , ");
		buffer.append("personName as cstrcreateoersonname , ");
		buffer.append("C_ST_R_AuditState as cstrauditstate , ");
		buffer.append("C_ST_R_BillDate as cstrauditdate ");
		buffer.append("from Orders.orders.dbo.C_ST_Returns ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_R_SupplierID ");
		buffer.append("inner join Orders.orders.dbo.SYS_PersonInfo on ID = C_ST_R_CreatePerson ");
		buffer.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(returnsPo.getCstrid()))){
			buffer.append("and C_ST_R_ID like '%' + ? +'%'  ");//quyanping
			
			//params.add(returnsPo.getCstrcompanyid());
			params.add(returnsPo.getCstrid());
		}else if("".equals(Utility.getName(returnsPo.getCstrid()))){
			buffer.append("and C_ST_R_ID like '%' + ? +'%'  ");//quyanping
			
			params.add(returnsPo.getCstrcompanyid());
		}
		
		if(!"".equals(Utility.getName(returnsPo.getCstrauditstate()))){
			buffer.append("and C_ST_R_AuditState = ? ");
			params.add(returnsPo.getCstrauditstate());
		}
		
		if(!"".equals(Utility.getName(returnsPo.getCstrsupplierid()))){
			buffer.append("and C_ST_R_SupplierID = (select B_SP_OrderSupplierID ");
			buffer.append("from B_Supplier where B_SP_ID = ? ) ");
			params.add(returnsPo.getCstrsupplierid());
		}
		
		if (!"".equals(Utility.getName(returnsPo.getCstrbillstartdate()))	&& !"".equals(Utility.getName(returnsPo.getCstrbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) <= ? ");

			params.add(returnsPo.getCstrbillstartdate());
			params.add(returnsPo.getCstrbillenddate());
		} else if (!"".equals(Utility.getName(returnsPo.getCstrbillstartdate()))&& "".equals(Utility.getName(returnsPo.getCstrbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) >= ? ");

			params.add(returnsPo.getCstrbillstartdate());
		} else if ("".equals(Utility.getName(returnsPo.getCstrbillstartdate()))&& !"".equals(Utility.getName(returnsPo.getCstrbillenddate()))) {
			buffer.append("and convert(varchar(10), C_ST_R_BillDate, 23) <= ? ");

			params.add(returnsPo.getCstrbillenddate());
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString() , params.toArray() , ReturnsPo.class);
	}

	/**
	 * 详细开窗表头
	 * @param returnsPo
	 * @return
	 */
	public ReturnsPo getOrdersStatusDetaile(ReturnsPo returnsPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1  C_ST_R_ID as cstrid , ");
		buffer.append("C_ST_R_BillDate as cstrauditdate , ");
		buffer.append("B_DP_DepartmentName as cstrsuppliername , ");
		buffer.append("C_ST_R_AuditState as cstrauditstate , ");
		buffer.append("personName as cstrcreateoersonname ");
		buffer.append("from Orders.orders.dbo.C_ST_Returns ");
		buffer.append("inner join Orders.orders.dbo.B_Departments on B_DP_DepartmentID = C_ST_R_SupplierID ");
		buffer.append("inner join Orders.orders.dbo.SYS_PersonInfo on ID = C_ST_R_CreatePerson ");
		buffer.append("where C_ST_R_ID = ? ");
		
		params.add(returnsPo.getCstrid());
		
		return (ReturnsPo) queryForObject(buffer.toString() , params.toArray() , ReturnsPo.class);
	}

	/**
	 * 详细开窗表体
	 * @param returnsEntryPo
	 * @return
	 */
	public List<ReturnsEntryPo> selectOrdersStatusDetaile(
			ReturnsEntryPo returnsEntryPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select C_ST_RE_GoodsName as cstregoodsname , ");
		buffer.append("C_ST_RE_Spec as cstrespec , ");
		buffer.append("C_ST_RE_ReturnsNumber as cstrereturnsnumber , ");
		buffer.append("C_ST_RE_NotTaxRate as cstrenottaxrate , ");
		buffer.append("C_ST_RE_NotTaxRateAmount as cstrenottaxrateamount , ");
		buffer.append("C_ST_RE_TaxRate as cstretaxrate , ");
		buffer.append("C_ST_RE_CostPrice as cstrecostprice , ");
		buffer.append("C_ST_RE_TaxAmount as cstretaxamount , ");
		buffer.append("C_ST_RE_CostPriceAmount as cstrecostpriceamount ");
		buffer.append("from Orders.orders.dbo.C_ST_ReturnsEntry ");
		buffer.append("where C_ST_RE_ReturnsID = ? ");
		
		params.add(returnsEntryPo.getCstrereturnsid());
		
		return queryForObjectList(buffer.toString() , params.toArray() , ReturnsEntryPo.class);
	}

	/**
	 * 得到公司id
	 * @param companyNamePo
	 * @return
	 */
	public CompanyNamePo getCompanyId(CompanyNamePo companyNamePo) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer();
		List<String> params=new ArrayList<String>();
		
		buffer.append("select top 1 F_CN_ID as fcnId ");
		buffer.append("from F_CompanyName ");
		
		return (CompanyNamePo) queryForObject(buffer.toString() , params.toArray() , CompanyNamePo.class);
	}

}
