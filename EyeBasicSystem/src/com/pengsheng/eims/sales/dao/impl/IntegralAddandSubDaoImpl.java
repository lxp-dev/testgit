package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.dao.IntegralAddandSubDao;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class IntegralAddandSubDaoImpl extends BaseJdbcDaoSupport implements IntegralAddandSubDao{

	public void insertIntegralAddandSubPo(IntegralAddandSubPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_ME_IntegralAddandSub ");
		buffer.append("            (S_ME_AS_UUID, ");
		buffer.append("             S_ME_AS_MemberId, ");
		buffer.append("             S_ME_AS_YIntegral, ");
		buffer.append("             S_ME_AS_CIntegral, ");
		buffer.append("             S_ME_AS_XIntegral, ");
		buffer.append("             S_ME_AS_DoPersonID, ");
		buffer.append("             S_ME_AS_DoDate, ");
		buffer.append("             S_ME_AS_Remark, ");
		buffer.append("             S_ME_AS_IsSendMessage, ");
		buffer.append("             S_ME_AS_AddOrSub, ");
		buffer.append("             S_ME_AS_SalesBillID, ");
		buffer.append("             S_ME_AS_CustomerID, ");
		buffer.append("             S_ME_AS_FCustomerID) ");
		buffer.append("VALUES      ( ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		if(Utility.getName(po.getIsjifenjiekuan()).equals("")){//为空表示整单积分插入
			buffer.append("              dateadd (ss,1,getdate()), ");
		}else{//不为空表示积分结款数据插入
			buffer.append("              getdate(), ");
		}
		
		buffer.append("              ?, ");
		buffer.append("              '0', ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?, ");
		buffer.append("              ?) ");
		
		if("".equals(Utility.getName(po.getSmeasuuid()))){
			params.add(this.uuid.generate());
		}else{
			params.add(Utility.getName(po.getSmeasuuid()));
		}
		params.add(Utility.getName(po.getSmeasmemberid()));
		params.add(Utility.getName(po.getSmeasyintegral()));
		if("".equals(Utility.getName(po.getSmeascintegral()))){
			params.add("0");
		}else{
			params.add(Utility.getName(po.getSmeascintegral()));
		}
		params.add(Utility.getName(po.getSmeasxintegral()));
		params.add(Utility.getName(po.getSmeasdopersonid()));
		params.add(Utility.getName(po.getSmeasremark()));
		params.add(Utility.getName(po.getSmeasaddorsub()));
		params.add(Utility.getName(po.getSmeassalesbill()));
		params.add(Utility.getName(po.getSmeascustomerid()));
		params.add(Utility.getName(po.getSmeasfcustomerid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	
	public int selectIntegralAddandSubCount(IntegralAddandSubPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(*) ");
		buffer.append("FROM   dbo.S_ME_IntegralAddandSub ");
		buffer.append("       INNER JOIN dbo.S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_AS_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("       left JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON id = S_ME_AS_DoPersonID ");
		buffer.append("WHERE S_ME_AS_AddOrSub in ('1','2') ");
		if(!"".equals(Utility.getName(po.getSmeasmemberid()))){
			buffer.append("       AND S_ME_AS_MemberId LIKE '%'+?+'%' ");
			params.add(po.getSmeasmemberid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeascustomername()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(po.getSmeascustomername());
		}
		
		if(!"".equals(Utility.getName(po.getSmeascustomerphone()))){
			buffer.append("       AND S_ME_CI_Phone LIKE '%'+?+'%' ");
			params.add(po.getSmeascustomerphone());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasdopersonname()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(po.getSmeasdopersonname());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasdobegindate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_ME_AS_DoDate, 23) >= ? ");
			params.add(po.getSmeasdobegindate());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasdoenddate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_ME_AS_DoDate, 23) <= ? ");
			params.add(po.getSmeasdoenddate());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasissendmessage()))){
			buffer.append("       AND S_ME_AS_IsSendMessage = ? ");
			params.add(po.getSmeasissendmessage());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasaddorsub()))){
			buffer.append("       AND S_ME_AS_AddOrSub = ? ");
			params.add(po.getSmeasaddorsub());
		}
		
		if(!"".equals(Utility.getName(po.getSmeassalesbill()))){
			buffer.append("       AND S_ME_AS_SalesBillID = ? ");
			params.add(po.getSmeassalesbill());
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

	
	public List<IntegralAddandSubPo> selectIntegralAddandSubList(
			IntegralAddandSubPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * from( ");
		buffer.append("SELECT ROW_NUMBER() Over(order by S_ME_AS_DoDate desc) as rowNum,  ");
		buffer.append("       S_ME_AS_UUID          AS smeasuuid, ");
		buffer.append("       S_ME_CI_MemberId      AS smeasmemberid, ");
		buffer.append("       S_ME_CI_Name          AS smeascustomername, ");
		buffer.append("       S_ME_CI_Phone         AS smeascustomerphone, ");
		buffer.append("       S_ME_AS_YIntegral     AS smeasyintegral, ");
		buffer.append("       S_ME_AS_CIntegral     AS smeascintegral, ");
		buffer.append("       S_ME_AS_XIntegral     AS smeasxintegral, ");
		buffer.append("       S_ME_AS_DoPersonID    AS smeasdopersonid, ");
		buffer.append("       personName            AS smeasdopersonname, ");
		buffer.append("       S_ME_AS_DoDate        AS smeasdodate, ");
		buffer.append("       S_ME_AS_Remark        AS smeasremark, ");
		buffer.append("       S_ME_AS_IsSendMessage AS smeasissendmessage, ");
		buffer.append("       S_ME_AS_AddOrSub      AS smeasaddorsub, ");
		buffer.append("       S_ME_AS_SalesBillID      AS smeassalesbill ");
		buffer.append("FROM   dbo.S_ME_IntegralAddandSub ");
		buffer.append("       INNER JOIN dbo.S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_AS_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("       left JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON id = S_ME_AS_DoPersonID ");
		buffer.append("WHERE  S_ME_AS_AddOrSub in ('1','2') ");
		
		if(!"".equals(Utility.getName(po.getSmeasmemberid()))){
			buffer.append("       AND S_ME_AS_MemberId LIKE '%'+?+'%' ");
			params.add(po.getSmeasmemberid());
		}
		
		if(!"".equals(Utility.getName(po.getSmeassalesbill()))){
			buffer.append("       AND S_ME_AS_SalesBillID = ? ");
			params.add(po.getSmeassalesbill());
		}
		
		if(!"".equals(Utility.getName(po.getSmeascustomername()))){
			buffer.append("       AND S_ME_CI_Name LIKE '%'+?+'%' ");
			params.add(po.getSmeascustomername());
		}
		
		if(!"".equals(Utility.getName(po.getSmeascustomerphone()))){
			buffer.append("       AND S_ME_CI_Phone LIKE '%'+?+'%' ");
			params.add(po.getSmeascustomerphone());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasdopersonname()))){
			buffer.append("       AND personName LIKE '%'+?+'%' ");
			params.add(po.getSmeasdopersonname());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasdobegindate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_ME_AS_DoDate, 23) >= ? ");
			params.add(po.getSmeasdobegindate());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasdoenddate()))){
			buffer.append("       AND CONVERT(VARCHAR(10), S_ME_AS_DoDate, 23) <= ? ");
			params.add(po.getSmeasdoenddate());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasissendmessage()))){
			buffer.append("       AND S_ME_AS_IsSendMessage = ? ");
			params.add(po.getSmeasissendmessage());
		}
		
		if(!"".equals(Utility.getName(po.getSmeasaddorsub()))){
			buffer.append("       AND S_ME_AS_AddOrSub = ? ");
			params.add(po.getSmeasaddorsub());
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
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(),IntegralAddandSubPo.class);
	}
	
	public IntegralAddandSubPo selectIntegralAddandSubPo(IntegralAddandSubPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		buffer.append("       S_ME_AS_UUID          AS smeasuuid, ");
		buffer.append("       S_ME_CI_MemberId      AS smeasmemberid, ");
		buffer.append("       S_ME_CI_Name          AS smeascustomername, ");
		buffer.append("       S_ME_CI_Phone         AS smeascustomerphone, ");
		buffer.append("       S_ME_AS_YIntegral     AS smeasyintegral, ");
		buffer.append("       S_ME_AS_CIntegral     AS smeascintegral, ");
		buffer.append("       S_ME_AS_XIntegral     AS smeasxintegral, ");
		buffer.append("       S_ME_AS_DoPersonID    AS smeasdopersonid, ");
		buffer.append("       personName            AS smeasdopersonname, ");
		buffer.append("       S_ME_AS_DoDate        AS smeasdodate, ");
		buffer.append("       S_ME_AS_Remark        AS smeasremark, ");
		buffer.append("       S_ME_AS_IsSendMessage AS smeasissendmessage, ");
		buffer.append("       S_ME_AS_AddOrSub      AS smeasaddorsub,S_ME_AS_CustomerID as smeascustomerid ");
		buffer.append("FROM   dbo.S_ME_IntegralAddandSub ");
		buffer.append("       INNER JOIN dbo.S_ME_CustomerInfo ");
		buffer.append("         ON S_ME_CI_CustomerID = S_ME_AS_CustomerID ");
		buffer.append("       left JOIN dbo.SYS_PersonInfo ");
		buffer.append("         ON id = S_ME_AS_DoPersonID ");
		buffer.append("WHERE  S_ME_AS_UUID = ? ");
		
		params.add(po.getSmeasuuid());
		
		return (IntegralAddandSubPo) queryForObject(buffer.toString(), params.toArray(),
				IntegralAddandSubPo.class);
	}


	public void updateIntegralAddandSubSendType(IntegralAddandSubPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE dbo.S_ME_IntegralAddandSub ");
		buffer.append("SET    S_ME_AS_IsSendMessage = '1' ");
		buffer.append("WHERE  S_ME_AS_UUID = ? ");
		
		params.add(po.getSmeasuuid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
}
