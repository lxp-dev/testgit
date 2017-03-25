package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WarehouseConfigurationDaoImpl  extends BaseJdbcDaoSupport implements WarehouseConfigurationDao {

	public List<WarehouseConfigurationPo> getWarehouseConfigurationList() 
	{
		
		String sql="select B_Departments.B_DP_DepartmentID as bwcdeptid,B_Departments.B_DP_DepartmentName as bwcdeptname,B_WarehouseConfiguration.B_WC_deptID as bwcflag" +
				" from B_Departments left join B_WarehouseConfiguration on B_Departments.B_DP_DepartmentID=B_WarehouseConfiguration.B_WC_deptID where B_Departments.B_DP_Type='1'";
		
		return queryForObjectList(sql, null, WarehouseConfigurationPo.class);
	}
	
	public int getWarehouseConfigurationsCount(DepartmentsPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select count(B_Departments.B_DP_DepartmentID)");
		buffer.append("   from B_Departments left join B_WarehouseConfiguration on B_Departments.B_DP_DepartmentID=B_WarehouseConfiguration.B_WC_deptID where B_Departments.B_DP_Type='1' ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append("AND B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}


	public List<WarehouseConfigurationPo> getWarehouseConfigurationsList(DepartmentsPo po,int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_Departments.B_DP_DepartmentID) as rowNum, B_Departments.B_DP_DepartmentID as bwcdeptid,B_Departments.B_DP_DepartmentName as bwcdeptname,B_WarehouseConfiguration.B_WC_deptID as bwcflag,B_InWarehouseConfiguration.B_WC_deptID as bwcInflag ");
		buffer.append(" from B_Departments left join B_WarehouseConfiguration on B_Departments.B_DP_DepartmentID=B_WarehouseConfiguration.B_WC_deptID left join B_InWarehouseConfiguration on B_Departments.B_DP_DepartmentID=B_InWarehouseConfiguration.B_WC_deptID where B_Departments.B_DP_Type='1' ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append("AND B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}
		
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(),params.toArray(),
				WarehouseConfigurationPo.class);
	}
	
	
	public WarehouseConfigurationPo getWarehouseConfiguration(
			WarehouseConfigurationPo po) {
		
		String sql="select top 1  B_Departments.B_DP_DepartmentID as bwcdeptid,B_Departments.B_DP_DepartmentName as bwcdeptname," +
				"B_WarehouseConfiguration.B_WC_StockID1 as bwcstockid1,B_WarehouseConfiguration.B_WC_StockID2 as bwcstockid2," +
				"B_WarehouseConfiguration.B_WC_StockID3 as bwcstockid3,B_WarehouseConfiguration.B_WC_StockID4 as bwcstockid4," +
				"B_WarehouseConfiguration.B_WC_StockID5 as bwcstockid5,B_WarehouseConfiguration.B_WC_StockID6 as bwcstockid6," +
				"B_WarehouseConfiguration.B_WC_StockID7 as bwcstockid7,B_WarehouseConfiguration.B_WC_StockID8 as bwcstockid8," + 
				"B_WarehouseConfiguration.B_WC_StockID9 as bwcstockid9,B_WarehouseConfiguration.B_WC_StockID10 as bwcstockid10, " + 
				"B_WarehouseConfiguration.B_WC_StockID11 as bwcstockid11,B_WarehouseConfiguration.B_WC_StockID12 as bwcstockid12, " + 
				"B_WarehouseConfiguration.B_WC_StockID13 as bwcstockid13,B_WarehouseConfiguration.B_WC_StockID14 as bwcstockid14, " +
				"B_WarehouseConfiguration.B_WC_StockID15 as bwcstockid15,B_WarehouseConfiguration.B_WC_xiaocangzp2 as bwcxiaocangzp2, " +
				"B_WarehouseConfiguration.B_WC_xiaocangzp as bwcxiaocangzp,B_WarehouseConfiguration.B_WC_xiaocangww as bwcxiaocangww " +
				" from B_WarehouseConfiguration left join B_Departments on B_Departments.B_DP_DepartmentID=B_WarehouseConfiguration.B_WC_deptID " +
				" where B_Departments.B_DP_DepartmentID='"+po.getBwcdeptid()+"'";
		
		return (WarehouseConfigurationPo)queryForObject(sql, null, WarehouseConfigurationPo.class);
	}
	
	public void insertWarehouseConfiguration(WarehouseConfigurationPo po) {
		
		String sql="insert into B_WarehouseConfiguration (B_WC_deptID,B_WC_StockID1,B_WC_StockID2,B_WC_StockID3,B_WC_StockID4,B_WC_StockID5,B_WC_StockID6,B_WC_StockID7,B_WC_StockID8,B_WC_StockID9,B_WC_StockID10,B_WC_StockID11,B_WC_StockID12,B_WC_StockID13,B_WC_StockID14,B_WC_StockID15,B_WC_xiaocangzp,B_WC_xiaocangzp2) values('"+po.getBwcdeptid()+"','"+po.getBwcstockid1()+"','"+po.getBwcstockid2()+"'," +
				"'"+po.getBwcstockid3()+"','"+po.getBwcstockid4()+"','"+po.getBwcstockid5()+"','"+po.getBwcstockid6()+"','"+po.getBwcstockid7()+"','"+po.getBwcstockid8()+"','"+po.getBwcstockid9()+"','"+po.getBwcstockid10()+"','"+po.getBwcstockid11()+"','"+po.getBwcstockid12()+"','"+po.getBwcstockid13()+"','"+po.getBwcstockid14()+"','"+po.getBwcstockid15()+"','"+po.getBwcxiaocangzp()+"','"+po.getBwcxiaocangzp2()+"')";
		
		getJdbcTemplate().update(sql);
	}
	
	public void updateWarehouseConfiguration(WarehouseConfigurationPo po) {
		
		String sql="update B_WarehouseConfiguration set B_WC_StockID1='"+po.getBwcstockid1()+"',B_WC_StockID2='"+po.getBwcstockid2()+"'," +
				"B_WC_StockID3='"+po.getBwcstockid3()+"',B_WC_StockID4='"+po.getBwcstockid4()+"',B_WC_StockID5='"+po.getBwcstockid5()+"'," +
			    "B_WC_StockID6='"+po.getBwcstockid6()+"',B_WC_StockID7='"+po.getBwcstockid7()+"',B_WC_StockID8='"+po.getBwcstockid8()+"'," +
			    "B_WC_StockID9='"+po.getBwcstockid9()+"' " + ",B_WC_StockID10='"+po.getBwcstockid10()+"',B_WC_StockID11='"+po.getBwcstockid11()+"' " + ",B_WC_StockID12='"+po.getBwcstockid12()+"'"+
			    ",B_WC_StockID13='"+po.getBwcstockid13()+"'"+ ",B_WC_StockID14='"+po.getBwcstockid14()+"'"+ ",B_WC_StockID15='"+po.getBwcstockid15()+"'"+ ",B_WC_xiaocangzp='"+po.getBwcxiaocangzp()+"'"+",B_WC_xiaocangzp2='"+po.getBwcxiaocangzp2()+"'"+",B_WC_xiaocangww='"+po.getBwcxiaocangww()+"'"+
			    " where B_WarehouseConfiguration.B_WC_deptID='"+po.getBwcdeptid()+"'";
		
		getJdbcTemplate().update(sql);
	}
	
    public int getWarehouseConfigurationCount(WarehouseConfigurationPo po) {

		String sql="select count(B_WarehouseConfiguration.B_WC_deptID) from B_WarehouseConfiguration where B_WarehouseConfiguration.B_WC_deptID='"+po.getBwcdeptid()+"'";
		
    	return getJdbcTemplate().queryForInt(sql);
    }
    
    public List<WarehousePo> getWarehouseList() {

    	String sql="select B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName from B_Warehouse where B_WH_IsClosed='0' ";
    	
    	return queryForObjectList(sql, null, WarehousePo.class);
    }
    
    /**
     * 获取入仓配置的仓位
     */
	public WarehouseConfigurationPo getInWarehouseConfiguration(WarehouseConfigurationPo po) {
		
		String sql="select top 1 B_DP_DepartmentID as bwcdeptid,B_DP_DepartmentName as bwcdeptname," +
				"B_WC_StockID1 as bwcstockid1,B_WC_StockID2 as bwcstockid2," +
				"B_WC_StockID3 as bwcstockid3,B_WC_StockID4 as bwcstockid4," +
				"B_WC_StockID5 as bwcstockid5,B_WC_StockID6 as bwcstockid6," +
				"B_WC_StockID7 as bwcstockid7,B_WC_StockID8 as bwcstockid8," + 
				"B_WC_StockID9 as bwcstockid9,B_WC_StockID10 as bwcstockid10, " + 
				"B_WC_StockID11 as bwcstockid11,B_WC_StockID12 as bwcstockid12,B_WC_StockID13 as bwcstockid13,B_WC_StockID14 as bwcstockid14,B_WC_StockID15 as bwcstockid15 " +
				" from  B_InWarehouseConfiguration left join B_Departments on B_DP_DepartmentID=B_WC_deptID " +
				" where B_DP_DepartmentID='"+po.getBwcdeptid()+"'";
		
		return (WarehouseConfigurationPo)queryForObject(sql, null, WarehouseConfigurationPo.class);
	}
	
    /**
     * 获取入仓配置的仓位总数
     */
    public int getInWarehouseConfigurationCount(WarehouseConfigurationPo po) {

		String sql="select count(B_InWarehouseConfiguration.B_WC_deptID) from B_InWarehouseConfiguration where B_InWarehouseConfiguration.B_WC_deptID='"+po.getBwcdeptid()+"'";
		
    	return getJdbcTemplate().queryForInt(sql);
    }
    
	public void insertInWarehouseConfiguration(WarehouseConfigurationPo po) {
		
		String sql="insert into B_InWarehouseConfiguration (B_WC_deptID,B_WC_StockID1,B_WC_StockID2,B_WC_StockID3,B_WC_StockID4,B_WC_StockID5,B_WC_StockID6,B_WC_StockID7,B_WC_StockID8,B_WC_StockID9,B_WC_StockID10,B_WC_StockID11,B_WC_StockID12,B_WC_StockID13,B_WC_StockID14,B_WC_StockID15) values('"+po.getBwcdeptid()+"','"+po.getBwcstockid1()+"','"+po.getBwcstockid2()+"'," +
				"'"+po.getBwcstockid3()+"','"+po.getBwcstockid4()+"','"+po.getBwcstockid5()+"','"+po.getBwcstockid6()+"','"+po.getBwcstockid7()+"','"+po.getBwcstockid8()+"','"+po.getBwcstockid9()+"','"+po.getBwcstockid10()+"','"+po.getBwcstockid11()+"','"+po.getBwcstockid12()+"','"+po.getBwcstockid13()+"','"+po.getBwcstockid14()+"','"+po.getBwcstockid15()+"')";
		
		getJdbcTemplate().update(sql);
	}
	
	public void updateInWarehouseConfiguration(WarehouseConfigurationPo po) {
		
		String sql="update B_InWarehouseConfiguration set B_WC_StockID1='"+po.getBwcstockid1()+"',B_WC_StockID2='"+po.getBwcstockid2()+"'," +
				"B_WC_StockID3='"+po.getBwcstockid3()+"',B_WC_StockID4='"+po.getBwcstockid4()+"',B_WC_StockID5='"+po.getBwcstockid5()+"'," +
			    "B_WC_StockID6='"+po.getBwcstockid6()+"',B_WC_StockID7='"+po.getBwcstockid7()+"',B_WC_StockID8='"+po.getBwcstockid8()+"'," +
			    "B_WC_StockID9='"+po.getBwcstockid9()+"' " + ",B_WC_StockID10='"+po.getBwcstockid10()+"', "+
			    "B_WC_StockID11='"+po.getBwcstockid11()+"' " + ",B_WC_StockID12='"+po.getBwcstockid12()+"' "+ ",B_WC_StockID13='"+po.getBwcstockid13()+"' "+",B_WC_StockID14='"+po.getBwcstockid14()+"',B_WC_StockID15='"+po.getBwcstockid15()+"' "+
			    " where B_InWarehouseConfiguration.B_WC_deptID='"+po.getBwcdeptid()+"'";
		
		getJdbcTemplate().update(sql);
	}
	
	public List<WarehousePo> getWarehouseList(DepartmentsPo po){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName from B_Warehouse left join B_Departments on B_WH_deptID = B_DP_DepartmentID where B_WH_IsClosed='0' "); 

		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))) {
			buffer.append("AND B_DP_DepartmentID = ? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append("AND B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}
		
    	return queryForObjectList(buffer.toString(), params.toArray(), WarehousePo.class);
	}
	
}
