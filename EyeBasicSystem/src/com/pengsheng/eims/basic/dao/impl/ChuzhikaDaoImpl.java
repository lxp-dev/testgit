package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ChuzhikaDaoImpl extends BaseJdbcDaoSupport implements ChuzhikaDao {

	
	public void deleteChuzhika(ChuzhikaPo chuzhikaPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		sb.append("DELETE FROM C_ST_Chuzhika ");
		sb.append("WHERE  C_ST_CZK_ID = ? ");
		
		params.add(chuzhikaPo.getCstczkid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void deleteChuzhikaLog(ChuzhikaPo chuzhikaPo){
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		sb.append("DELETE FROM S_ME_ChuAddandSub ");
		sb.append("WHERE  S_ME_AS_ChuzhikaId = ? ");
		
		params.add(chuzhikaPo.getCstczkid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void deleteChuzhikaLogBySalesBillID(ChuzhikaLogPo chuzhikaLogPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		sb.append("delete from S_ME_ChuAddandSub ");
		sb.append("where 1=1 ");
		sb.append("and S_ME_AS_SalesBillID=? and S_ME_AS_AddOrSub = ? ");
		
		params.add(chuzhikaLogPo.getSmeassalesbillid());
		params.add(chuzhikaLogPo.getSmeasaddorsub());
		
		sb.append("UPDATE C_ST_Chuzhika ");
		sb.append("SET ");
		sb.append("       C_ST_CZK_Jine = (SELECT SUM(CAST(S_ME_AS_CIntegral AS NUMERIC(20, 2))) FROM   S_ME_ChuAddandSub WHERE  S_ME_AS_ChuzhikaId = ? ) ");
		sb.append("WHERE  C_ST_CZK_ID = ? ");
		
		params.add(Utility.getName(chuzhikaLogPo.getSmeaschuzhikaid()));
		params.add(Utility.getName(chuzhikaLogPo.getSmeaschuzhikaid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public void insertChuzhika(ChuzhikaPo chuzhikaPo) {
		List<String> params = new ArrayList<String>();
		StringBuffer  sb = new StringBuffer();
		
		sb.append("INSERT INTO C_ST_Chuzhika ");
		sb.append("            (C_ST_CZK_ID, ");
		sb.append("             C_ST_CZK_CreateDate, ");
		sb.append("             C_ST_CZK_CreatePersonID, ");
		sb.append("             C_ST_CZK_Remark, ");
		sb.append("             C_ST_CZK_CardPassword, ");
		sb.append("             C_ST_CZK_IDCard, ");
		sb.append("             C_ST_ShowAndHie, ");
		sb.append("             C_ST_CZK_CustomerID, ");
		sb.append("             C_ST_CZK_ShopCode, ");
		sb.append("             C_ST_CZK_CardID) ");
		sb.append("VALUES      ( '"+ chuzhikaPo.getCstczkid() +"', ");
		sb.append("              Getdate(), ");
		sb.append("              '"+ chuzhikaPo.getCstczkcreatepersonid() +"',  ");
		sb.append("              '"+ Utility.getName(chuzhikaPo.getCstczkremark()) +"',  ");
		sb.append("              '"+ chuzhikaPo.getCstczkcardpassword() +"',  ");
		sb.append("              '"+ Utility.getName(chuzhikaPo.getCstczkidcard()) +"',  ");
		sb.append("              1,  ");
		sb.append("              '"+ Utility.getName(chuzhikaPo.getCstczkcustomerid()) +"',  ");
		sb.append("              '"+ Utility.getName(chuzhikaPo.getCstczkshopcode()) +"',  ");
		sb.append("              '"+ chuzhikaPo.getCstczkcardid() +"')  ");

		getJdbcTemplate().update(sb.toString(),params.toArray());
	}

	/**
	 * 查询储值卡是否已经存在Count
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectChuzhikCount(String cardID){
		StringBuffer  sb = new StringBuffer();
		
		sb.append("SELECT count(C_ST_CZK_ID) ");
		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("WHERE  C_ST_CZK_CardID = '"+ cardID +"' ");
		return getJdbcTemplate().queryForInt(sb.toString(), null);
	}
	
	/**
	 * 查询会员是否已经绑定了储值卡
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectCustomerCzkCount(String id,String customerID){
		
		StringBuffer  sb = new StringBuffer();
		
		sb.append("SELECT count(C_ST_CZK_ID) ");
		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("WHERE  C_ST_CZK_CustomerID = '"+ Utility.getName(customerID) +"' ");		

		if (!"".equals(Utility.getName(id))) {
			sb.append("       AND C_ST_CZK_ID <> '"+ Utility.getName(id) +"' ");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString(), null);
	}
	
	public int selectChuzhikasCount(ChuzhikaPo chuzhikaPo) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT count(C_ST_CZK_ID) ");
		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("       left JOIN S_ME_CustomerInfo ON S_ME_CI_CustomerID = C_ST_CZK_CustomerID ");
		sb.append("       left JOIN SYS_PersonInfo ON C_ST_CZK_CreatePersonID = ID left join B_Departments on C_ST_CZK_ShopCode = B_DP_DepartmentID ");
		sb.append("WHERE  1 = 1 ");

		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkid()))) {
			sb.append("       AND C_ST_CZK_ID = ? ");
			params.add(chuzhikaPo.getCstczkid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkidcard()))) {
			sb.append("       AND C_ST_CZK_IDCard like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkidcard());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomername()))) {
			sb.append("       AND S_ME_CI_Name like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcustomername());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcardid()))) {
			sb.append("       AND C_ST_CZK_CardID like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcardid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomerid()))) {
			sb.append("       AND C_ST_CZK_CustomerID = ? ");
			params.add(chuzhikaPo.getCstczkcustomerid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getPage_createdate_begin()))) {
			sb.append("       AND CONVERT(VARCHAR(10), C_ST_CZK_CreateDate, 23) >= ? ");
			params.add(chuzhikaPo.getPage_createdate_begin());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getPage_createdate_end()))) {
			sb.append("       AND CONVERT(VARCHAR(10), C_ST_CZK_CreateDate, 23) <= ? ");
			params.add(chuzhikaPo.getPage_createdate_end());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcreatepersonname()))) {
			sb.append("       AND personName LIKE '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcreatepersonname());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkshopcode()))) {
			sb.append("       AND C_ST_CZK_ShopCode = ? ");
			params.add(chuzhikaPo.getCstczkshopcode());
		}	
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcreatepersonid()))) {
			sb.append("       AND C_ST_CZK_CreatePersonID = ? ");
			params.add(chuzhikaPo.getCstczkcreatepersonid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(chuzhikaPo.getCstczkcompanyid()));	
		}	
		
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}
	
	
	public List<ChuzhikaPo> selectChuzhikas(ChuzhikaPo chuzhikaPo, int start, int size) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select * ");
		sb.append(" from(select ROW_NUMBER() ");
		sb.append("Over(order by C_ST_CZK_CreateDate desc) as rowNum,");
		sb.append("             C_ST_CZK_ID as cstczkid, ");
		sb.append("             C_ST_CZK_CardID as cstczkcardid, ");		
		sb.append("             C_ST_CZK_Jine as cstczkjine, ");
		sb.append("             C_ST_CZK_CreateDate as cstczkcreatedate, ");
		sb.append("             C_ST_CZK_CreatePersonID as cstczkcreatepersonid, ");
		sb.append("             personName as cstczkcreatepersonname, ");
		sb.append("             C_ST_CZK_Remark as cstczkremark, ");
		sb.append("             C_ST_CZK_CardPassword as cstczkcardpassword, ");
		sb.append("             C_ST_CZK_IDCard as cstczkidcard, ");
		sb.append("             isnull(C_ST_ShowAndHie,'0') as cstshowandhie, ");
		sb.append("             C_ST_CZK_CustomerID as cstczkcustomerid, ");
		sb.append("             S_ME_CI_MemberId as cstczkmemberid, ");
		sb.append("             S_ME_CI_Name as cstczkcustomername, ");		
		sb.append("             C_ST_CZK_ShopCode as cstczkshopcode, ");
		sb.append("             B_DP_DepartmentName as cstczkshopname, ");		

		sb.append("       case ");
		sb.append("       when (select count(*) from S_ME_ChuAddandSub where S_ME_AS_ChuzhikaId = C_ST_CZK_ID and S_ME_AS_AddOrSub <> '0') > 0 then '0' ");  
		sb.append("       else ");
		sb.append("       '1' ");
		sb.append("       end	 as cstczkisdelete ");

		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("       left JOIN S_ME_CustomerInfo ON S_ME_CI_CustomerID = C_ST_CZK_CustomerID ");
		sb.append("       left JOIN SYS_PersonInfo ON C_ST_CZK_CreatePersonID = ID ");
		sb.append("       left JOIN B_Departments ON C_ST_CZK_ShopCode = B_DP_DepartmentID ");
		sb.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkidcard()))) {
			sb.append("       AND C_ST_CZK_IDCard like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkidcard());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomername()))) {
			sb.append("       AND S_ME_CI_Name like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcustomername());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcardid()))) {
			sb.append("       AND C_ST_CZK_CardID like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcardid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomerid()))) {
			sb.append("       AND C_ST_CZK_CustomerID = ? ");
			params.add(chuzhikaPo.getCstczkcustomerid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getPage_createdate_begin()))) {
			sb.append("       AND CONVERT(VARCHAR(10), C_ST_CZK_CreateDate, 23) >= ? ");
			params.add(chuzhikaPo.getPage_createdate_begin());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getPage_createdate_end()))) {
			sb.append("       AND CONVERT(VARCHAR(10), C_ST_CZK_CreateDate, 23) <= ? ");
			params.add(chuzhikaPo.getPage_createdate_end());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcreatepersonname()))) {
			sb.append("       AND personName LIKE '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcreatepersonname());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkshopcode()))) {
			sb.append("       AND C_ST_CZK_ShopCode = ? ");
			params.add(chuzhikaPo.getCstczkshopcode());
		}	
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcreatepersonid()))) {
			sb.append("       AND C_ST_CZK_CreatePersonID = ? ");
			params.add(chuzhikaPo.getCstczkcreatepersonid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(chuzhikaPo.getCstczkcompanyid()));	
		}	
		
		sb.append(" ) temp where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append("set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), ChuzhikaPo.class);
	}
	
	public List<ChuzhikaPo> selectChuzhikas(ChuzhikaPo chuzhikaPo) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append(" select ");
		sb.append("             C_ST_CZK_CardID as cstczkcardid ");		
		
		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("       left JOIN S_ME_CustomerInfo ON S_ME_CI_CustomerID = C_ST_CZK_CustomerID ");
		sb.append("       left JOIN SYS_PersonInfo ON C_ST_CZK_CreatePersonID = ID ");
		sb.append("       left JOIN B_Departments ON C_ST_CZK_ShopCode = B_DP_DepartmentID ");
		sb.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkidcard()))) {
			sb.append("       AND C_ST_CZK_IDCard like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkidcard());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomername()))) {
			sb.append("       AND S_ME_CI_Name like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcustomername());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcardid()))) {
			sb.append("       AND C_ST_CZK_CardID like '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcardid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomerid()))) {
			sb.append("       AND C_ST_CZK_CustomerID = ? ");
			params.add(chuzhikaPo.getCstczkcustomerid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getPage_createdate_begin()))) {
			sb.append("       AND CONVERT(VARCHAR(10), C_ST_CZK_CreateDate, 23) >= ? ");
			params.add(chuzhikaPo.getPage_createdate_begin());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getPage_createdate_end()))) {
			sb.append("       AND CONVERT(VARCHAR(10), C_ST_CZK_CreateDate, 23) <= ? ");
			params.add(chuzhikaPo.getPage_createdate_end());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcreatepersonname()))) {
			sb.append("       AND personName LIKE '%'+?+'%' ");
			params.add(chuzhikaPo.getCstczkcreatepersonname());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkshopcode()))) {
			sb.append("       AND C_ST_CZK_ShopCode = ? ");
			params.add(chuzhikaPo.getCstczkshopcode());
		}	
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcompanyid()))){
		    sb.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(chuzhikaPo.getCstczkcompanyid()));	
		}
		
		return queryForObjectList(sb.toString(), params.toArray(), ChuzhikaPo.class);
	}
	
    public ChuzhikaPo selectChuzhika(ChuzhikaPo chuzhikaPo) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("SELECT top 1 ");
		sb.append("             C_ST_CZK_ID as cstczkid, ");
		sb.append("             C_ST_CZK_CardID as cstczkcardid, ");		
		sb.append("             C_ST_CZK_Jine as cstczkjine, ");
		sb.append("             C_ST_CZK_CreateDate as cstczkcreatedate, ");
		sb.append("             C_ST_CZK_CreatePersonID as cstczkcreatepersonid, ");
		sb.append("             personName as cstczkcreatepersonname, ");
		sb.append("             C_ST_CZK_Remark as cstczkremark, ");
		sb.append("             isnull(C_ST_CZK_CardPassword,'') as cstczkcardpassword, ");
		sb.append("             isnull(C_ST_CZK_IDCard,'') as cstczkidcard, ");
		sb.append("             isnull(C_ST_ShowAndHie,'0') as cstshowandhie, ");
		sb.append("             C_ST_CZK_CustomerID as cstczkcustomerid, ");
		sb.append("             S_ME_CI_MemberId as cstczkmemberid, ");
		sb.append("             S_ME_CI_Name as cstczkcustomername, ");		
		sb.append("             C_ST_CZK_ShopCode as cstczkshopcode, ");
		sb.append("             B_DP_DepartmentName as cstczkshopname, ");		

		sb.append("       case ");
		sb.append("       when (select count(*) from S_ME_ChuAddandSub where S_ME_AS_ChuzhikaId = C_ST_CZK_ID ) > 0 then '0' ");  
		sb.append("       else ");
		sb.append("       '1' ");
		sb.append("       end	 as cstczkisdelete ");

		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("       left JOIN S_ME_CustomerInfo ON S_ME_CI_CustomerID = C_ST_CZK_CustomerID ");
		sb.append("       left JOIN SYS_PersonInfo ON C_ST_CZK_CreatePersonID = ID ");
		sb.append("       left JOIN B_Departments ON C_ST_CZK_ShopCode = B_DP_DepartmentID ");
		sb.append("WHERE  1 = 1 ");
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkid()))) {
			sb.append("       AND C_ST_CZK_ID = ? ");
			params.add(chuzhikaPo.getCstczkid());
		}		
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcardid()))) {
			sb.append("       AND C_ST_CZK_CardID = ? ");
			params.add(chuzhikaPo.getCstczkcardid());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstshowandhie()))) {
			sb.append("       AND C_ST_ShowAndHie = ? ");
			params.add(chuzhikaPo.getCstshowandhie());
		}
		
		if (!"".equals(Utility.getName(chuzhikaPo.getCstczkcustomerid()))) {
			sb.append("       AND C_ST_CZK_CustomerID = ? ");
			params.add(chuzhikaPo.getCstczkcustomerid());
		}
		return (ChuzhikaPo)queryForObject(sb.toString(), params.toArray(), ChuzhikaPo.class);
	}
  
	public void updateChuzhika(ChuzhikaPo chuzhikaPo) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE dbo.C_ST_Chuzhika ");
		sb.append("SET ");
		sb.append("       C_ST_CZK_CustomerID = ?, ");
		sb.append("       C_ST_CZK_CardPassword = ?, ");
		sb.append("       C_ST_CZK_IDCard = ?, ");
		sb.append("       C_ST_CZK_ShopCode = ?, ");
		sb.append("  	  C_ST_CZK_Remark = ? ");
		
		params.add(Utility.getName(chuzhikaPo.getCstczkcustomerid()));
		params.add(Utility.getName(chuzhikaPo.getCstczkcardpassword()));
		params.add(Utility.getName(chuzhikaPo.getCstczkidcard()));
		params.add(Utility.getName(chuzhikaPo.getCstczkshopcode()));
		params.add(Utility.getName(chuzhikaPo.getCstczkremark()));

		sb.append("WHERE  C_ST_CZK_ID = ? ");
		params.add(chuzhikaPo.getCstczkid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	  
	public void updateChuzhikaChongzhi(ChuzhikaPo chuzhikaPo) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("UPDATE C_ST_Chuzhika ");
		sb.append("SET ");
		sb.append("       C_ST_CZK_Jine = (SELECT SUM(CAST(S_ME_AS_CIntegral AS NUMERIC(20, 2))) FROM   S_ME_ChuAddandSub WHERE  S_ME_AS_ChuzhikaId = ? ) ");
		sb.append("WHERE  C_ST_CZK_ID = ? ");
		
		params.add(chuzhikaPo.getCstczkid());
		params.add(chuzhikaPo.getCstczkid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public List<ChuzhikaLogPo> selectChuzhikaLogs(String cardUUID) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select S_ME_AS_UUID 	as smeasuuid, ");
		sb.append("	S_ME_AS_ChuzhikaId 	as smeaschuzhikaid, ");
		
		sb.append("	S_ME_AS_Shifu	 	as smeasshifu, ");
		sb.append("	S_ME_AS_Zengsong 	as smeaszengsong, ");
		
		sb.append("	S_ME_AS_YIntegral 	as smeasyintegral, ");
		sb.append("	S_ME_AS_CIntegral 	as smeascintegral, ");
		sb.append("	S_ME_AS_XIntegral 	as smeasxintegral, ");
		sb.append("	S_ME_AS_DoDate 		as smeasdodate, ");
		sb.append("	S_ME_AS_DoPersonID	as smeasdopersonid, "); 
		sb.append("	S_ME_AS_AddOrSub	as smeasaddorsub, "); 
		sb.append("	S_ME_AS_Remark		as smeasremark, "); 
		sb.append("	personName			as smeasdopersonname, "); 
		sb.append("	case S_ME_AS_AddOrSub when '7' then '挂号费' when '9' then '退挂号费' else S_ME_AS_SalesBillID end as smeassalesbillid ");    
		
		sb.append("	from S_ME_ChuAddandSub ");
		sb.append("	left JOIN SYS_PersonInfo ON S_ME_AS_DoPersonID = ID ");
		sb.append("	where S_ME_AS_ChuzhikaId = ? ");
		sb.append(" order by S_ME_AS_DoDate desc,S_ME_AS_AddOrSub asc");
		params.add(cardUUID);
		
		return queryForObjectList(sb.toString(), params.toArray(), ChuzhikaLogPo.class);
	}
	
	public ChuzhikaPo selectChuzhikaJifenByCustomerID(String customerID) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select top 1 C_ST_CZK_ID 				as cstczkid, ");
		sb.append("				isnull(C_ST_CZK_Jine,0.00) 	as cstczkjine ");
		
		sb.append("	from C_ST_Chuzhika ");
		sb.append("	where C_ST_ShowAndHie <> '1' ");
		sb.append("	  and C_ST_CZK_CustomerID = ? ");
		sb.append("	order by C_ST_CZK_CreateDate");
		params.add(customerID);
		
		return (ChuzhikaPo)queryForObject(sb.toString(), params.toArray(), ChuzhikaPo.class);
	}
	
	public List<ChuzhikaLogPo> selectChuzhikaLogsByCustomerID(String cardUUID) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select S_ME_AS_UUID 	as smeasuuid, ");
		sb.append("	S_ME_AS_ChuzhikaId 	as smeaschuzhikaid, ");
		sb.append("	S_ME_AS_CIntegral 	as smeascintegral, ");
		sb.append("	S_ME_AS_XIntegral 	as smeasxintegral, ");
		sb.append("	S_ME_AS_DoDate 		as smeasdodate, "); 
		sb.append("	S_ME_AS_AddOrSub	as smeasaddorsub "); 
		
		sb.append("	from S_ME_ChuAddandSub ");
		
		sb.append("	where S_ME_AS_ChuzhikaId = ? ");
		sb.append(" order by S_ME_AS_DoDate desc,S_ME_AS_AddOrSub asc");
		params.add(cardUUID);
		
		return queryForObjectList(sb.toString(), params.toArray(), ChuzhikaLogPo.class);
	}
	
	
	public void updateChuzhikaIsShowHide(ChuzhikaPo chuzhikaPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE C_ST_Chuzhika ");
		buffer.append("SET ");
		buffer.append("       C_ST_ShowAndHie = ? ");
		buffer.append("WHERE  C_ST_CZK_ID = ? ");
		
		params.add(chuzhikaPo.getCstshowandhie());
		params.add(chuzhikaPo.getCstczkid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	public void insertChuZhiKaLogInformation(ChuzhikaLogPo po){
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(Utility.getName(po.getSmeasischong()).equals("C")){//更新更改结款方式的储值卡原记录为已经被冲回的记录
			sb.append("UPDATE S_ME_ChuAddandSub SET S_ME_AS_IsChong = 'C' where  S_ME_AS_UUID = '"+ Utility.getName(po.getSmeasuuid()) +"' ");
		}
		
		sb.append(" INSERT INTO S_ME_ChuAddandSub ");
		sb.append("            (S_ME_AS_UUID, ");
		sb.append("             S_ME_AS_CustomerID, ");
		sb.append("             S_ME_AS_ChuzhikaId, ");
		sb.append("             S_ME_AS_Shifu, ");
		sb.append("             S_ME_AS_Zengsong, ");
		sb.append("             S_ME_AS_YIntegral, ");
		sb.append("             S_ME_AS_CIntegral, ");
		sb.append("             S_ME_AS_XIntegral, ");
		sb.append("             S_ME_AS_DoPersonID, ");
		sb.append("             S_ME_AS_DoDate, ");
		sb.append("             S_ME_AS_Remark, ");
		sb.append("             S_ME_AS_AddOrSub, ");
		sb.append("             S_ME_AS_SalesBillID, ");
		sb.append("             S_ME_AS_MemberId) ");
		sb.append("VALUES      ('"+ this.uuid.generate() +"', ");
		sb.append("             '"+ Utility.getName(po.getSmeascustomerid()) +"', ");
		sb.append("             '"+ Utility.getName(po.getSmeaschuzhikaid()) +"', ");		
		sb.append("             '"+ Utility.getName(po.getSmeasshifu()) +"', ");		
		sb.append("             '"+ Utility.getName(po.getSmeaszengsong()) +"', ");	
		sb.append("             dbo.getChuZhiKaJine('"+ Utility.getName(po.getSmeaschuzhikaid()) +"'), ");
		sb.append("             '"+ Utility.getName(po.getSmeascintegral()) +"', ");
		if(Utility.getName(po.getSmeasaddorsub()).equals("0")){//储值卡流水的余额：建卡去充值金额
			sb.append("             '"+ Utility.getName(po.getSmeascintegral()) +"', ");
		}else{//其他取储值卡金额+充值金额
			sb.append("             dbo.getChuZhiKayue('"+ Utility.getName(po.getSmeaschuzhikaid()) +"','"+ Utility.getName(po.getSmeascintegral()) +"') , ");
		}
		
		sb.append("             '"+ Utility.getName(po.getSmeasdopersonid()) +"', ");
		sb.append("             getdate(), ");
		sb.append("             '"+ Utility.getName(po.getSmeasremark()) +"', ");
		sb.append("             '"+ Utility.getName(po.getSmeasaddorsub()) +"', ");
		sb.append("             '"+ Utility.getName(po.getSmeassalesbillid()) +"', ");
		sb.append("             '"+ Utility.getName(po.getSmeasmemberid()) +"') ");
		
		//通过流水汇总，更新储值卡主表金额
		sb.append("UPDATE C_ST_Chuzhika ");
		sb.append("SET ");
		sb.append("       C_ST_CZK_Jine = (SELECT SUM(CAST(S_ME_AS_CIntegral AS NUMERIC(20, 2))) FROM   S_ME_ChuAddandSub WHERE  S_ME_AS_ChuzhikaId = ? ) ");
		sb.append("WHERE  C_ST_CZK_ID = ? ");
		
		params.add(Utility.getName(po.getSmeaschuzhikaid()));
		params.add(Utility.getName(po.getSmeaschuzhikaid()));
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	
	
	public List<ChuzhikaLogPo> selectChuzhikadel(ChuzhikaLogPo chuzhikaLogPo) {
		
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select S_ME_AS_UUID as smeasuuid, ");
		sb.append("S_ME_AS_ChuzhikaId as smeaschuzhikaid, ");
		sb.append("-CAST(S_ME_AS_CIntegral AS DECIMAL(18, 2)) as smeascintegral, ");
		sb.append("S_ME_AS_SalesBillID as smeassalesbillid, ");
		sb.append("S_ME_AS_AddOrSub as smeasaddorsub ");
	
		sb.append("from S_ME_ChuAddandSub ");
		sb.append("where isnull(S_ME_AS_IsChong,'')<>'C' ");//不从冲回数据查询
		sb.append("and S_ME_AS_SalesBillID=? and S_ME_AS_AddOrSub = ? ");
		
		params.add(chuzhikaLogPo.getSmeassalesbillid());
		params.add(chuzhikaLogPo.getSmeasaddorsub());
		
		return queryForObjectList(sb.toString(), params.toArray(), ChuzhikaLogPo.class);
	}
	
	public void insertChuZhiKaLogInformation(List<ChuzhikaLogPo> poList){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (ChuzhikaLogPo po : poList){
			sb.append("INSERT INTO S_ME_ChuAddandSub ");
			sb.append("            (S_ME_AS_UUID, ");
			sb.append("             S_ME_AS_CustomerID, ");
			sb.append("             S_ME_AS_ChuzhikaId, ");
			sb.append("             S_ME_AS_Shifu, ");
			sb.append("             S_ME_AS_Zengsong, ");
			sb.append("             S_ME_AS_YIntegral, ");
			sb.append("             S_ME_AS_CIntegral, ");
			sb.append("             S_ME_AS_XIntegral, ");
			sb.append("             S_ME_AS_DoPersonID, ");
			sb.append("             S_ME_AS_DoDate, ");
			sb.append("             S_ME_AS_Remark, ");
			sb.append("             S_ME_AS_AddOrSub, ");
			sb.append("             S_ME_AS_SalesBillID, ");
			sb.append("             S_ME_AS_MemberId) ");
			sb.append("VALUES      ('"+ this.uuid.generate() +"', ");
			sb.append("             '"+ Utility.getName(po.getSmeascustomerid()) +"', ");
			sb.append("             '"+ Utility.getName(po.getSmeaschuzhikaid()) +"', ");		
			sb.append("             '"+ Utility.getName(po.getSmeasshifu()) +"', ");		
			sb.append("             '"+ Utility.getName(po.getSmeaszengsong()) +"', ");	
			sb.append("             dbo.getChuZhiKaJine('"+ Utility.getName(po.getSmeaschuzhikaid()) +"'), ");
			sb.append("             '"+ Utility.getName(po.getSmeascintegral()) +"', ");	
			sb.append("             dbo.getChuZhiKayue('"+ Utility.getName(po.getSmeaschuzhikaid()) +"','"+ Utility.getName(po.getSmeascintegral()) +"') , ");
			sb.append("             '"+ Utility.getName(po.getSmeasdopersonid()) +"', ");
			sb.append("             getdate(), ");
			sb.append("             NULL, ");
			sb.append("             '"+ Utility.getName(po.getSmeasaddorsub()) +"', ");
			sb.append("             '"+ Utility.getName(po.getSmeassalesbillid()) +"', ");
			sb.append("             '"+ Utility.getName(po.getSmeasmemberid()) +"') ");
			
			sb.append("UPDATE C_ST_Chuzhika ");
			sb.append("SET ");
			sb.append("       C_ST_CZK_Jine = (SELECT SUM(CAST(S_ME_AS_CIntegral AS NUMERIC(20, 2))) FROM   S_ME_ChuAddandSub WHERE  S_ME_AS_ChuzhikaId = ? ) ");
			sb.append("WHERE  C_ST_CZK_ID = ? ");
			
			params.add(Utility.getName(po.getSmeaschuzhikaid()));
			params.add(Utility.getName(po.getSmeaschuzhikaid()));
		}
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	
	}
	
	/**
	 * 批量新增储值卡时，判断哪些储值卡号已经被使用
	 * @param cardString
	 * @return
	 */
	public List<ChuzhikaPo> getChuzhikaListIsExist(String cardString){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();

		sb.append("SELECT C_ST_CZK_CardID AS cstczkcardid ");
		sb.append("FROM   C_ST_Chuzhika ");
		sb.append("       INNER JOIN (SELECT str2table ");
		sb.append("                   FROM   dbo.Strtotable(?))t ");
		sb.append("         ON t.str2table = C_ST_CZK_CardID ");
		
		params.add(Utility.getName(cardString));
		
		return queryForObjectList(sb.toString(), params.toArray(),ChuzhikaPo.class);
	}
	
	/**
	 * 批量删除储值卡
	 * @param cardString
	 * @return
	 */
	public void deleteChuzhikaBatch(String cardString){
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from C_ST_Chuzhika where C_ST_CZK_ID in (SELECT str2table FROM dbo.Strtotable(?))");
		sb.append("delete from S_ME_ChuAddandSub WHERE S_ME_AS_ChuzhikaId in (SELECT str2table FROM dbo.Strtotable(?))");
		
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(cardString));
		params.add(Utility.getName(cardString));
		
		getJdbcTemplate().update(sb.toString(),params.toArray());
		
	}
	
	/**
	 * 批量停用启用储值卡
	 */
	public void updateChuzhikaEnableBatch(ChuzhikaPo cpo){
		
		String[] array = Utility.getName(cpo.getCstczkid()).split(",");
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		for (int i = 0; i < array.length; i++){
			buffer.append("update C_ST_Chuzhika set C_ST_ShowAndHie = ? where C_ST_CZK_ID = ? ");
			
			params.add(Utility.getName(cpo.getCstshowandhie()));
			params.add(Utility.getName(array[i]));
		}
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 *  退款时获取上一次微信赠送的信息
	 */
	public ChuzhikaLogPo selectChuzhikaLogsPoByCustomerIDAndSalesBillID(ChuzhikaLogPo po) {
		StringBuffer  sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select S_ME_AS_UUID 	as smeasuuid, ");
		sb.append("	S_ME_AS_ChuzhikaId 	as smeaschuzhikaid, ");
		sb.append("	S_ME_AS_CIntegral 	as smeascintegral, ");
		sb.append("	S_ME_AS_XIntegral 	as smeasxintegral, ");
		sb.append("	S_ME_AS_DoDate 		as smeasdodate, "); 
		sb.append("	S_ME_AS_AddOrSub	as smeasaddorsub "); 
		sb.append("	from S_ME_ChuAddandSub ");
		sb.append("	where S_ME_AS_CustomerID = ? ");
		sb.append("	  and S_ME_AS_SalesBillID = ? ");
		
		params.add(po.getSmeascustomerid());
		params.add(po.getSmeassalesbillid());
		
		return (ChuzhikaLogPo)queryForObject(sb.toString(), params.toArray(), ChuzhikaLogPo.class);
	}
}
