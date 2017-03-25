package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WarehouseDaoImpl extends BaseJdbcDaoSupport implements
		WarehouseDao {

	public void deleteWarehouse(WarehousePo warehousePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Warehouse ");
		buffer.append("WHERE B_WH_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(warehousePo.getBwhid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public WarehousePo getWarehouse(WarehousePo warehousePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_WH_ID as bwhid ");
		buffer.append(",B_WH_deptID  as bwhdeptid ");
		buffer.append(",B_WH_warehouseName as bwhwarehouseName,B_DP_DepartmentName as bdpdepartmentname,B_WH_orderNumber as bwhordernumber");
		buffer.append(" FROM B_Warehouse");
		buffer.append(" left join B_Departments   on B_WH_deptID=B_DP_DepartmentID ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(warehousePo.getBwhid()))) {
			buffer.append(" AND B_WH_ID = ?");
			params.add(warehousePo.getBwhid());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhwarehouseName()))) {
			buffer.append(" AND B_WH_warehouseName = ?");
			params.add(warehousePo.getBwhwarehouseName());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))) {
			buffer.append(" AND B_WH_deptID = ?");
			params.add(warehousePo.getBwhdeptid());
		}
		
		return (WarehousePo) queryForObject(buffer.toString(), params
				.toArray(), WarehousePo.class);
	}
	
	public WarehousePo getWarehouseType(WarehousePo warehousePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_WH_ID as bwhid ");
		buffer.append(",B_WH_deptID  as bwhdeptid ");
		buffer.append(",B_WH_warehouseName as bwhwarehouseName,B_WH_orderNumber as bwhordernumber");
		buffer.append(" FROM B_Warehouse ");
		
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(warehousePo.getBwhid()))) {
			buffer.append(" AND B_WH_ID = ?");
			params.add(warehousePo.getBwhid());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhwarehouseName()))) {
			buffer.append(" AND B_WH_warehouseName = ?");
			params.add(warehousePo.getBwhwarehouseName());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))) {
			buffer.append(" AND B_WH_deptID = ?");
			params.add(warehousePo.getBwhdeptid());
		}
		
		return (WarehousePo) queryForObject(buffer.toString(), params
				.toArray(), WarehousePo.class);
	}

	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_WH_ID as bwhid ");
		buffer.append(",a.B_WH_deptID  as bwhdeptid ");
		buffer.append(",a.B_WH_warehouseName as bwhwarehouseName ");
		buffer.append(",b.B_DP_DepartmentName as bdpdepartmentname,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber");
		
		buffer.append(" FROM B_Warehouse a left join B_Departments b");
		buffer.append(" on a.B_WH_deptID=b.B_DP_DepartmentID");
		buffer.append(" WHERE 1=1 ");

		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(warehousePo.getBwhisclosed())))
		{
			buffer.append(" and B_WH_IsClosed=? ");
			params.add(warehousePo.getBwhisclosed());
		}
		
		if (!"".equals(Utility.getName(warehousePo.getBwhid()))) {
			buffer.append(" AND a.B_WH_ID like '%' + ? + '%' ");//quyanping
			params.add(warehousePo.getBwhid());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhwarehouseName()))) {
			buffer.append(" AND a.B_WH_warehouseName like '%' + ? + '%' ");
			params.add(warehousePo.getBwhwarehouseName());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))) {
			buffer.append(" AND a.B_WH_deptID = ? ");
			params.add(warehousePo.getBwhdeptid());
		}
		
		if (!"".equals(Utility.getName(warehousePo.getBwhcompanyid()))) {
			buffer.append(" AND b.B_DP_CompanysID = ? ");
			params.add(warehousePo.getBwhcompanyid());
		}
		
		buffer.append("order by B_WH_orderNumber,B_WH_ID ");

		return queryForObjectList(buffer.toString(), params.toArray(), WarehousePo.class);
	}

	/**
	 * 取仓位总数
	 */
	public int getWarehouseCount(WarehousePo warehousePo){

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(B_WH_ID) FROM B_Warehouse a left join B_Departments b ");
		buffer.append("on a.B_WH_deptID=b.B_DP_DepartmentID ");
		buffer.append("WHERE 1=1 ");	
		
		if (!"".equals(Utility.getName(warehousePo.getBwhcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(warehousePo.getBwhcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(warehousePo.getBwhisclosed()))){
			buffer.append(" and B_WH_IsClosed=? ");
			params.add(warehousePo.getBwhisclosed());
		}
		
		if (!"".equals(Utility.getName(warehousePo.getBwhid()))) {
			buffer.append(" AND a.B_WH_ID like '%' + ? + '%' ");//quyanping
			params.add(warehousePo.getBwhid());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhwarehouseName()))) {
			buffer.append(" AND a.B_WH_warehouseName like '%' + ? + '%' ");
			params.add(warehousePo.getBwhwarehouseName());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))) {
			buffer.append(" AND a.B_WH_deptID in  "+fightString(warehousePo.getBwhdeptid().split(",")));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 取仓位List(分页)
	 */
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( SELECT ROW_NUMBER() Over(order by B_WH_orderNumber,B_WH_ID ) as rowNum,B_WH_ID as bwhid ");
		buffer.append(",a.B_WH_deptID  as bwhdeptid ");
		buffer.append(",a.B_WH_warehouseName as bwhwarehouseName ");
		buffer.append(",b.B_DP_DepartmentName as bdpdepartmentname,isnull(B_WH_IsClosed,'0') as bwhisclosed");
		buffer.append(",B_WH_orderNumber as bwhordernumber ");
		
		buffer.append("FROM B_Warehouse a left join B_Departments b ");
		buffer.append("on a.B_WH_deptID=b.B_DP_DepartmentID ");
		buffer.append("WHERE 1=1 ");	
		
		if (!"".equals(Utility.getName(warehousePo.getBwhcompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(warehousePo.getBwhcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(warehousePo.getBwhisclosed()))){
			buffer.append(" and B_WH_IsClosed=? ");
			params.add(warehousePo.getBwhisclosed());
		}
		
		if (!"".equals(Utility.getName(warehousePo.getBwhid()))) {
			buffer.append(" AND a.B_WH_ID like '%' + ? + '%' ");//quyanping
			params.add(warehousePo.getBwhid());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhwarehouseName()))) {
			buffer.append(" AND a.B_WH_warehouseName like '%' + ? + '%' ");
			params.add(warehousePo.getBwhwarehouseName());
		}

		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))) {
			buffer.append(" AND a.B_WH_deptID in "+fightString(warehousePo.getBwhdeptid().split(",")));
		}
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));
		
		return queryForObjectList(buffer.toString(), params.toArray(), WarehousePo.class);
	}
	private String fightString(String[] strs) {
		if(null != strs && strs.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				sb.append("'" + strs[i] + "', ");
			}
			sb = new StringBuffer(sb.substring(0, sb.length() - 2));
			return "(" + sb.toString() + ")";
		}
		return "";
	}
	public void insertWarehouse(WarehousePo warehousePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO B_Warehouse ");
		buffer.append("(B_WH_ID ");
		buffer.append(",B_WH_deptID ");
		buffer.append(",B_WH_warehouseName,B_WH_IsClosed ");
		buffer.append(",B_WH_orderNumber) ");		
		buffer.append("VALUES (?, ?, ?,?,?)");

		List<String> params = new ArrayList<String>();
		params.add(warehousePo.getBwhid());
		params.add(warehousePo.getBwhdeptid());
		params.add(warehousePo.getBwhwarehouseName());
		params.add("0");
		params.add(Utility.getName(warehousePo.getBwhordernumber()));		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateWarehouse(WarehousePo warehousePo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE B_Warehouse ");
		buffer.append("SET B_WH_warehouseName = ? ");
		buffer.append(",B_WH_orderNumber = ? ");
		
		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))){
			buffer.append(",B_WH_deptID = ? ");
		}
		
		buffer.append("WHERE B_WH_ID = ?");

		List<String> params = new ArrayList<String>();
		
		params.add(warehousePo.getBwhwarehouseName());
		params.add(Utility.getName(warehousePo.getBwhordernumber()));
		if (!"".equals(Utility.getName(warehousePo.getBwhdeptid()))){
			params.add(Utility.getName(warehousePo.getBwhdeptid()));
		}
		params.add(warehousePo.getBwhid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
	
	public List<WarehousePo> getWarehouseList(DepartmentsPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_WH_ID as bwhid,B_WH_deptID as bwhdeptid,B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber from B_Warehouse inner join B_Departments on B_WH_deptID= B_DP_DepartmentID where B_WH_deptID=? and isnull(B_WH_IsClosed,'') <> '1' ");
		
		params.add(po.getBdpdepartmentid());
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append(" AND B_DP_CompanysID = ? ");
			params.add(po.getBdpcompanysid());
		}
		
		buffer.append("order by B_WH_orderNumber,B_WH_ID");
		
		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}
	
	public List<WarehousePo> getWarehouseAllList(DepartmentsPo po) {
				
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_WH_ID as bwhid,B_WH_deptID as bwhdeptid,B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber from B_Warehouse inner join B_Departments on B_WH_deptID= B_DP_DepartmentID where B_WH_IsClosed='0' ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append(" AND B_DP_CompanysID = ? ");
			params.add(po.getBdpcompanysid());
		}
		
		buffer.append("order by B_WH_orderNumber,B_WH_ID");
		
		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}
	
	public WarehousePo getWarehousePo(DepartmentsPo po) {
		
		String sql="select top 1 B_WH_ID as bwhid,B_WH_deptID as bwhdeptid,B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber from B_Warehouse where B_WH_deptID='"+po.getBdpdepartmentid()+"'";
		
		return (WarehousePo) queryForObject(sql, null, WarehousePo.class);
	}
	
	public DepartmentsPo getDepartments(WarehousePo po) {
		
		String sql="select top 1  B_Departments.B_DP_DepartmentID as bdpdepartmentid,B_Departments.B_DP_DepartmentName as bdpdepartmentname " +
				" from B_Warehouse inner join B_Departments on B_Warehouse.B_WH_deptID=B_Departments.B_DP_DepartmentID " +
				" where B_WH_ID='"+po.getBwhid()+"'";
		return (DepartmentsPo)queryForObject(sql, null, DepartmentsPo.class);
	}
	
	public List<WarehousePo> getWarehouseForStorageList() {
		
		String sql="SELECT B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber from B_Warehouse " +
				"inner join B_Departments on B_Warehouse.B_WH_deptID=B_Departments.B_DP_DepartmentID " +
				"where B_Departments.B_DP_Type='3' order by B_WH_orderNumber,B_WH_ID";
		return queryForObjectList(sql, null, WarehousePo.class);
	}

	public int getWareHouseCountForDel(WarehousePo warehousePo) {
	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select sum(goodsQuantity) from ( ");
		buffer.append("select sum(C_SH_SB_GoodsQuantity) as goodsQuantity from C_SH_StorageBeginning ");
		buffer.append("  where C_SH_SB_StockId=? ");
		buffer.append("union all ");
		buffer.append("select sum(C_SH_SC_GoodsQuantity) as goodsQuantity from C_SH_StorageChange ");
		buffer.append("  where C_SH_SC_StockId=? ");
		buffer.append(")temp ");
		
		params.add(Utility.getName(warehousePo.getBwhid()));
		params.add(Utility.getName(warehousePo.getBwhid()));

		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	
	public List<WarehousePo> getWarehouseListForReg(String departmentID) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_WH_ID as bwhid ");
		buffer.append(",B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber ");
		
		buffer.append("FROM B_Warehouse where b_wh_deptid in (select b_dp_departmentid from b_departments where b_dp_regid=?) ");
		buffer.append("union all SELECT B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName ");
		buffer.append(",isnull(B_WH_IsClosed,'0') as bwhisclosed ");
		buffer.append(",B_WH_orderNumber           AS bwhordernumber from b_warehouse where b_wh_deptid=?");
		List<String> params = new ArrayList<String>();
		params.add(departmentID);
		params.add(departmentID);

		return queryForObjectList(buffer.toString(), params.toArray(), WarehousePo.class);
	}
	
	public List<WarehousePo> getWarehouseForSalesList(String departmentID) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_WH_ID as bwhid ");
		buffer.append(",B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber ");
		
		buffer.append("FROM B_Warehouse where b_wh_deptid =? and B_WH_IsClosed <> '1' order by B_WH_orderNumber,B_WH_ID");
	
		List<String> params = new ArrayList<String>();
		params.add(departmentID);

		return queryForObjectList(buffer.toString(), params.toArray(), WarehousePo.class);
	}
	
   /**
    * 仓位停用启用
    */
	public void updateWarehouseAble(WarehousePo warehousePo) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update B_Warehouse set B_WH_IsClosed=? where B_WH_ID=? ");
			
		params.add(Utility.getName(warehousePo.getBwhisclosed()));
		params.add(Utility.getName(warehousePo.getBwhid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}


	public int getWarehouseName(WarehousePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_WH_ID )");
		buffer.append("   from B_Warehouse where B_WH_warehouseName = '"+Utility.getName(po.getBwhwarehouseName())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}



	public int getWarehouseNameUpdate(WarehousePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_WH_ID )");
		buffer.append("   from B_Warehouse where B_WH_warehouseName = '"+Utility.getName(po.getBwhwarehouseName())+"' and B_WH_ID <> '"+Utility.getName(po.getBwhid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getWarehouseDept(DepartmentsPo po) 
	{
		if(!po.getBdptype().equals("3"))
		{
			StringBuffer buffer = new StringBuffer();
			buffer.append(" select count( B_WH_ID )");
			buffer.append("   from B_Warehouse where  b_wh_deptid = '"+Utility.getName(po.getBdpdepartmentid())+"'");
			return getJdbcTemplate().queryForInt(buffer.toString());
		}else
		{
			return 0;
		}
	}



	public int getWarehouseDeptUpdate(DepartmentsPo po,String wid) 
	{
		if(!po.getBdptype().equals("3"))
		{
			StringBuffer buffer = new StringBuffer();
			buffer.append(" select count( B_WH_ID )");
			buffer.append("   from B_Warehouse where b_wh_deptid = '"+Utility.getName(po.getBdpdepartmentid())+"' and B_WH_ID <> '"+wid+"'");
			return getJdbcTemplate().queryForInt(buffer.toString());
		}else
		{
			return 0;
		}
	}
	
	public WarehousePo getWarehousebwhid() {
		
		String sql="select top 1 B_WH_ID as bwhid,B_WH_deptID as bwhdeptid,B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber from B_Warehouse inner join B_Departments on B_DP_DepartmentID = B_WH_deptID where B_DP_Type='3' order by B_WH_ID ";
		
		return (WarehousePo) queryForObject(sql, null, WarehousePo.class);
	}
	
	public List<WarehousePo> getRegWarehouseAllList(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName ");
		buffer.append(" FROM B_Warehouse inner join B_Departments on b_wh_deptid = B_DP_DepartmentID where B_DP_Type = '2' and B_WH_IsClosed = '0' ");
		
		if (!"".equals(Utility.getName(po.getBdpcompanysid()))) {
			buffer.append(" AND B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdpcompanysid()));
		}

		buffer.append(" order by B_WH_orderNumber  ");
		
		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}
	
	/**
	 * 获取当前部门所属仓位和所有的其他公司的仓位
	 */
	public List<WarehousePo> getWarehouseListByOtherCompany(WarehousePo warehousePo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName,B_WH_IsClosed as bwhisclosed from B_Warehouse inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("  where isnull(B_DP_CompanysID,'') not in (select B_DP_CompanysID from (select isnull(B_DP_CompanysID,'') as B_DP_CompanysID from B_Departments where B_DP_DepartmentID = ?)t) ");
		buffer.append("union ");
		buffer.append("select B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName,B_WH_IsClosed as bwhisclosed from B_Warehouse where B_WH_deptID = ? ");
			
		params.add(Utility.getName(warehousePo.getBwhdeptid()));
		params.add(Utility.getName(warehousePo.getBwhdeptid()));
		
		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);

	}
	
	/**
	 * 获取当前部门所属公司下的所有仓位
	 */
	public List<WarehousePo> getWarehouseListByCompany(WarehousePo warehousePo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName,B_WH_IsClosed as bwhisclosed from B_Warehouse inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("  where isnull(B_DP_CompanysID,'') in (select B_DP_CompanysID from (select isnull(B_DP_CompanysID,'') as B_DP_CompanysID from B_Departments where B_DP_DepartmentID = ?)t) ");
			
		params.add(Utility.getName(warehousePo.getBwhdeptid()));
		
		return queryForObjectList(buffer.toString(),params.toArray(), WarehousePo.class);
	}
	
	/**
	 * 获取总公司下总库的所有仓位
	 */
	public List<WarehousePo> getWarehouseListByZongCompany(){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select B_WH_ID as bwhid,B_WH_warehouseName as bwhwarehouseName,B_WH_IsClosed as bwhisclosed from B_Warehouse inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("  where isnull(B_DP_CompanysID,'') in (select F_CN_ID from dbo.F_CompanyName where F_CN_MasterOrVice = '1') and B_DP_Type = '3' ");
		
		return queryForObjectList(buffer.toString(),null, WarehousePo.class);
	}
	
	public WarehousePo getWarehousebwhid(DepartmentsPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_WH_ID as bwhid,B_WH_deptID as bwhdeptid,B_WH_warehouseName as bwhwarehouseName,isnull(B_WH_IsClosed,'0') as bwhisclosed,B_WH_orderNumber as bwhordernumber from B_Warehouse inner join B_Departments on B_DP_DepartmentID = B_WH_deptID where B_DP_Type='3' "); 

		if (!"".equals(Utility.getName(po.getBdpdepartmentid()))) {
			buffer.append("AND B_DP_DepartmentID = ? ");
			params.add(Utility.getName(po.getBdpdepartmentid()));
		}
		
		buffer.append(" order by B_WH_ID  ");
		
		return (WarehousePo) queryForObject(buffer.toString(), params.toArray(), WarehousePo.class);
	}
	
}
