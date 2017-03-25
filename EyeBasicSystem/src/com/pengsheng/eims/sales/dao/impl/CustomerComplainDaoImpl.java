package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.dao.CustomerComplainDao;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerComplainDaoImpl extends BaseJdbcDaoSupport implements CustomerComplainDao {

	
	public void insertCustomerComplainHandlePo(CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_ME_CustomerComplainHandle ");
		buffer.append("            (S_ME_CH_UUID, ");
		buffer.append("             S_ME_CH_CustomerComplainID, ");
		buffer.append("             S_ME_CH_HandleState, ");
		buffer.append("             S_ME_CH_HandleDate, ");
		buffer.append("             S_ME_CH_HandleContent, ");
		buffer.append("             S_ME_CH_HandlePersonID) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("      getdate(), ");
		buffer.append("              ?, ");
		buffer.append("              ? ) ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSmechcustomercomplainid()));
		params.add(Utility.getName(po.getSmechhandlestate()));
		params.add(Utility.getName(po.getSmechhandlecontent()));
		params.add(Utility.getName(po.getSmechhandlepersonid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public void insertCustomerComplainPo(CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_ME_CustomerComplain ");
		buffer.append("            (S_ME_CC_UUID, ");
		buffer.append("             S_ME_CC_CustomerMemberID, ");
		buffer.append("             S_ME_CC_IntendHandleDate, ");
		buffer.append("             S_ME_CC_ComplainType, ");
		buffer.append("             S_ME_CC_ComplainContent, ");
		buffer.append("             S_ME_CC_HandleState, ");
		buffer.append("             S_ME_CC_RegisterPersonID, ");
		buffer.append("             S_ME_CC_RegisterDate,S_ME_CC_LinkSalesID) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("       getdate(),?) ");
		params.add(Utility.getName(po.getSmeccuuid()));
		params.add(Utility.getName(po.getSmecccustomermemberid()));
		params.add(Utility.getName(po.getSmeccintendhandledate()));
		params.add(Utility.getName(po.getSmecccomplaintype()));
		params.add(Utility.getName(po.getSmecccomplaincontent()));
		params.add(Utility.getName(po.getSmecchandlestate()));
		params.add(Utility.getName(po.getSmeccregisterpersonid()));
		params.add(Utility.getName(po.getSmecclinksalesid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public int selectCustomerComplainCount(CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(*) ");
		buffer.append("FROM   S_ME_CustomerComplain ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_MemberId = S_ME_CC_CustomerMemberID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)j1 ");
		buffer.append("         ON j1.ID = S_ME_CC_RegisterPersonID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)c1 ");
		buffer.append("         ON c1.ID = S_ME_CC_NewHandlePersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getComplainid()))){
			buffer.append("       AND S_ME_CC_UUID like '%'+?+'%' ");
			params.add(po.getComplainid());
		}
		
		if(!"".equals(Utility.getName(po.getMemberId()))){
			buffer.append("       AND S_ME_CC_CustomerMemberID like '%'+?+'%' ");
			params.add(po.getMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getCustomername()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(po.getCustomername());
		}
		
		if(!"".equals(Utility.getName(po.getPhone()))){
			buffer.append("       AND S_ME_CI_Phone LIKE '%'+?+'%' ");
			params.add(po.getPhone());
		}
		
		if(!"".equals(Utility.getName(po.getHandlestate()))){
			if("0".equals(Utility.getName(po.getHandlestate()))){
				buffer.append("       AND S_ME_CC_HandleState = '' ");
			}else{
				buffer.append("       AND S_ME_CC_HandleState = ? ");
				params.add(po.getHandlestate());
			}
		}
		
		if(!"".equals(Utility.getName(po.getComplaintype()))){
			buffer.append("       AND S_ME_CC_ComplainType = ? ");
			params.add(po.getComplaintype());
		}
		
		if(!"".equals(Utility.getName(po.getComplainbegindate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_RegisterDate,23) >= ? ");
			params.add(po.getComplainbegindate());
		}
		
		if(!"".equals(Utility.getName(po.getComplainenddate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_RegisterDate,23) <= ? ");
			params.add(po.getComplainenddate());
		}
		
		if(!"".equals(Utility.getName(po.getIntendhandlebegindate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_IntendHandleDate,23) >= ? ");
			params.add(po.getIntendhandlebegindate());
		}
		
		if(!"".equals(Utility.getName(po.getIntendhandleenddate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_IntendHandleDate,23) <= ? ");
			params.add(po.getIntendhandleenddate());
		}
		
		if(!"".equals(Utility.getName(po.getHandlebegindate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_NewHandleDate,23) >= ? ");
			params.add(po.getHandlebegindate());
		}
		
		if(!"".equals(Utility.getName(po.getHandleenddate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_NewHandleDate,23) <= ? ");
			params.add(po.getHandleenddate());
		}
		
		if(!"".equals(Utility.getName(po.getRegisterpersonname()))){
			buffer.append("       AND j1.personName LIKE '%'+?+'%' ");
			params.add(po.getRegisterpersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHandlepersonname()))){
			buffer.append("       AND c1.personName LIKE '%'+?+'%' ");
			params.add(po.getHandlepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getSmecclinksalesid()))){
			buffer.append("       AND S_ME_CC_LinkSalesID LIKE '%'+?+'%' ");
			params.add(Utility.getName(po.getSmecclinksalesid()));
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}

	
	public List<CustomerComplainPo> selectCustomerComplainList(
			CustomerComplainPo po,int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CC_RegisterDate desc) as rowNum,");
		buffer.append("       S_ME_CC_UUID              AS smeccuuid, ");
		buffer.append("       S_ME_CC_CustomerMemberID  AS smecccustomermemberid, ");
		buffer.append("       S_ME_CI_Name              AS smecccustomername, ");
		buffer.append("       S_ME_CI_Phone             AS smecccustomerphone, ");
		buffer.append("       S_ME_CC_IntendHandleDate  AS smeccintendhandledate, ");
		buffer.append("       S_ME_CC_ComplainType      AS smecccomplaintype, ");
		buffer.append("       S_ME_CC_ComplainContent   AS smecccomplaincontent, ");
		buffer.append("       S_ME_CC_HandleState       AS smecchandlestate, ");
		buffer.append("       S_ME_CC_RegisterPersonID  AS smeccregisterpersonid, ");
		buffer.append("       j1.personName             AS smeccregisterpersonname, ");
		buffer.append("       S_ME_CC_RegisterDate      AS smeccregisterdate, ");
		buffer.append("       S_ME_CC_NewHandleDate     AS smeccnewhandledate, ");
		buffer.append("       S_ME_CC_NewHandlePersonID AS smeccnewhandlepersonid, ");
		buffer.append("       c1.personName             AS smeccnewhandlepersonname ");
		buffer.append("FROM   S_ME_CustomerComplain ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_MemberId = S_ME_CC_CustomerMemberID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)j1 ");
		buffer.append("         ON j1.ID = S_ME_CC_RegisterPersonID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)c1 ");
		buffer.append("         ON c1.ID = S_ME_CC_NewHandlePersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(po.getComplainid()))){
			buffer.append("       AND S_ME_CC_UUID like '%'+?+'%' ");
			params.add(po.getComplainid());
		}
		
		if(!"".equals(Utility.getName(po.getMemberId()))){
			buffer.append("       AND S_ME_CC_CustomerMemberID like '%'+?+'%' ");
			params.add(po.getMemberId());
		}
		
		if(!"".equals(Utility.getName(po.getCustomername()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(po.getCustomername());
		}
		
		if(!"".equals(Utility.getName(po.getPhone()))){
			buffer.append("       AND S_ME_CI_Phone LIKE '%'+?+'%' ");
			params.add(po.getPhone());
		}
		
		if(!"".equals(Utility.getName(po.getHandlepersonname()))){
			buffer.append("       AND c1.personName LIKE '%'+?+'%' ");
			params.add(po.getHandlepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHandlestate()))){
			if("0".equals(Utility.getName(po.getHandlestate()))){
				buffer.append("       AND S_ME_CC_HandleState = '' ");
			}else{
				buffer.append("       AND S_ME_CC_HandleState = ? ");
				params.add(po.getHandlestate());
			}
		}
		
		if(!"".equals(Utility.getName(po.getComplaintype()))){
			buffer.append("       AND S_ME_CC_ComplainType = ? ");
			params.add(po.getComplaintype());
		}
		
		if(!"".equals(Utility.getName(po.getComplainbegindate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_RegisterDate,23) >= ? ");
			params.add(po.getComplainbegindate());
		}
		
		if(!"".equals(Utility.getName(po.getComplainenddate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_RegisterDate,23) <= ? ");
			params.add(po.getComplainenddate());
		}
		
		if(!"".equals(Utility.getName(po.getIntendhandlebegindate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_IntendHandleDate,23) >= ? ");
			params.add(po.getIntendhandlebegindate());
		}
		
		if(!"".equals(Utility.getName(po.getIntendhandleenddate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_IntendHandleDate,23) <= ? ");
			params.add(po.getIntendhandleenddate());
		}
		
		if(!"".equals(Utility.getName(po.getHandlebegindate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_NewHandleDate,23) >= ? ");
			params.add(po.getHandlebegindate());
		}
		
		if(!"".equals(Utility.getName(po.getHandleenddate()))){
			buffer.append("       AND Convert(varchar(10),S_ME_CC_NewHandleDate,23) <= ? ");
			params.add(po.getHandleenddate());
		}
		
		if(!"".equals(Utility.getName(po.getRegisterpersonname()))){
			buffer.append("       AND j1.personName LIKE '%'+?+'%' ");
			params.add(po.getRegisterpersonname());
		}
		
		if(!"".equals(Utility.getName(po.getHandlepersonname()))){
			buffer.append("       AND c1.personName LIKE '%'+?+'%' ");
			params.add(po.getHandlepersonname());
		}
		
		if(!"".equals(Utility.getName(po.getSmecclinksalesid()))){
			buffer.append("       AND S_ME_CC_LinkSalesID LIKE '%'+?+'%' ");
			params.add(Utility.getName(po.getSmecclinksalesid()));
		}
		
		if(po.getSmecishoplist() != null && po.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = po.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				CustomerComplainPo.class);
	}

	//新增方法lvhz  begin
	public List<CustomerComplainPo> getCustomerComplainListByCustomer(String id,int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from(select ROW_NUMBER() ");
		buffer.append("Over(order by S_ME_CC_RegisterDate desc) as rowNum,");
		buffer.append("       S_ME_CC_UUID              AS smeccuuid, ");
		buffer.append("       S_ME_CC_CustomerMemberID  AS smecccustomermemberid, ");
		buffer.append("       S_ME_CI_Name              AS smecccustomername, ");
		buffer.append("       S_ME_CI_Phone             AS smecccustomerphone, ");
		buffer.append("       S_ME_CC_IntendHandleDate  AS smeccintendhandledate, ");
		buffer.append("       S_ME_CC_ComplainType      AS smecccomplaintype, ");
		buffer.append("       S_ME_CC_ComplainContent   AS smecccomplaincontent, ");
		buffer.append("       S_ME_CC_HandleState       AS smecchandlestate, ");
		buffer.append("       S_ME_CC_RegisterPersonID  AS smeccregisterpersonid, ");
		buffer.append("       j1.personName             AS smeccregisterpersonname, ");
		buffer.append("       S_ME_CC_RegisterDate      AS smeccregisterdate, ");
		buffer.append("       S_ME_CC_NewHandleDate     AS smeccnewhandledate, ");
		buffer.append("       S_ME_CC_NewHandlePersonID AS smeccnewhandlepersonid, ");
		buffer.append("       c1.personName             AS smeccnewhandlepersonname ");
		buffer.append("FROM   S_ME_CustomerComplain ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_MemberId = S_ME_CC_CustomerMemberID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)j1 ");
		buffer.append("         ON j1.ID = S_ME_CC_RegisterPersonID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)c1 ");
		buffer.append("         ON c1.ID = S_ME_CC_NewHandlePersonID ");
		buffer.append("WHERE  1 = 1 ");
		
		if(!"".equals(Utility.getName(id))){
			buffer.append("       AND S_ME_CC_CustomerMemberID = ? ");
			params.add(id);
		}
		
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ (start + size));
		buffer.append("set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				CustomerComplainPo.class);
	}
	
	
	public int getCustomerComplainCountByCustomer(String id) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(*) ");
		buffer.append("FROM   S_ME_CustomerComplain ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_MemberId = S_ME_CC_CustomerMemberID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)j1 ");
		buffer.append("         ON j1.ID = S_ME_CC_RegisterPersonID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)c1 ");
		buffer.append("         ON c1.ID = S_ME_CC_NewHandlePersonID ");
		buffer.append("WHERE  1 = 1 ");
		if(!"".equals(Utility.getName(id))){
			buffer.append("       AND S_ME_CC_CustomerMemberID = ? ");
			params.add(id);
		}
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	//end
	
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ");
		buffer.append("       S_ME_CC_UUID              AS smeccuuid, ");
		buffer.append("       S_ME_CC_CustomerMemberID  AS smecccustomermemberid, ");
		buffer.append("       S_ME_CI_Name              AS smecccustomername, ");
		buffer.append("       S_ME_CI_Phone             AS smecccustomerphone, ");
		buffer.append("       S_ME_CC_IntendHandleDate  AS smeccintendhandledate, ");
		buffer.append("       S_ME_CC_ComplainType      AS smecccomplaintype, ");
		buffer.append("       S_ME_CC_ComplainContent   AS smecccomplaincontent, ");
		buffer.append("       S_ME_CC_HandleState       AS smecchandlestate, ");
		buffer.append("       S_ME_CC_RegisterPersonID  AS smeccregisterpersonid, ");
		buffer.append("       j1.personName             AS smeccregisterpersonname, ");
		buffer.append("       S_ME_CC_RegisterDate      AS smeccregisterdate, ");
		buffer.append("       S_ME_CC_NewHandleDate     AS smeccnewhandledate, ");
		buffer.append("       S_ME_CC_NewHandlePersonID AS smeccnewhandlepersonid, ");
		buffer.append("       c1.personName             AS smeccnewhandlepersonname,isnull(S_ME_CC_LinkSalesID,'') as smecclinksalesid ");
		buffer.append("FROM   S_ME_CustomerComplain ");
		buffer.append("       INNER JOIN S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_MemberId = S_ME_CC_CustomerMemberID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)j1 ");
		buffer.append("         ON j1.ID = S_ME_CC_RegisterPersonID ");
		buffer.append("       left JOIN (SELECT ID, ");
		buffer.append("                          personName ");
		buffer.append("                   FROM   SYS_PersonInfo)c1 ");
		buffer.append("         ON c1.ID = S_ME_CC_NewHandlePersonID ");
		buffer.append("WHERE  S_ME_CC_UUID = ? ");
		
		params.add(po.getSmeccuuid());
		
		return (CustomerComplainPo) queryForObject(buffer.toString(), params.toArray(),
				CustomerComplainPo.class);
	}

	public List<CustomerComplainPo> selectCustomerComplainHandleList(
			CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT S_ME_CH_UUID               AS smechuuid, ");
		buffer.append("       S_ME_CH_CustomerComplainID AS smechcustomercomplainid, ");
		buffer.append("       S_ME_CH_HandleState        AS smechhandlestate, ");
		buffer.append("       S_ME_CH_HandleDate         AS smechhandledate, ");
		buffer.append("       S_ME_CH_HandleContent      AS smechhandlecontent, ");
		buffer.append("       S_ME_CH_HandlePersonID     AS smechhandlepersonid, ");
		buffer.append("       personName                 AS smechhandlepersonname ");
		buffer.append("FROM   S_ME_CustomerComplainHandle ");
		buffer.append("       INNER JOIN SYS_PersonInfo ");
		buffer.append("         ON id = S_ME_CH_HandlePersonID ");
		buffer.append("WHERE  S_ME_CH_CustomerComplainID = ? ");
		
		params.add(po.getSmechcustomercomplainid());
		
		return queryForObjectList(buffer.toString(), params.toArray(),
				CustomerComplainPo.class);
	}
	
	public void updateCustomerComplainPo(CustomerComplainPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_ME_CustomerComplain ");
		buffer.append("SET    S_ME_CC_HandleState = ?, ");
		buffer.append("       S_ME_CC_NewHandlePersonID = ?, ");
		buffer.append("       S_ME_CC_NewHandleDate = getdate() ");
		buffer.append("WHERE  S_ME_CC_UUID = ? ");
		
		params.add(Utility.getName(po.getSmechhandlestate()));
		params.add(Utility.getName(po.getSmechhandlepersonid()));
		params.add(Utility.getName(po.getSmechcustomercomplainid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除投诉
	 * @param po
	 */
	public void deleteCustomerComplain(CustomerComplainPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete S_ME_CustomerComplain ");
		buffer.append("WHERE  S_ME_CC_UUID = ? ");
		
		params.add(Utility.getName(po.getComplainid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 获取改配镜单的投诉总数
	 * @param po
	 * @return
	 */
	public int getCustomerComplainBySalesBillCount (CustomerComplainPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(S_ME_CC_UUID) FROM S_ME_CustomerComplain where S_ME_CC_LinkSalesID = ? ");

		params.add(Utility.getName(po.getSmecclinksalesid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
}
