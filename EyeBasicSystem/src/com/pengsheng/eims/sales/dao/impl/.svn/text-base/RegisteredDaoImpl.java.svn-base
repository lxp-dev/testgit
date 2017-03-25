/**
 * 
 */
package com.pengsheng.eims.sales.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.dao.RegisteredDao;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class RegisteredDaoImpl extends BaseJdbcDaoSupport implements
		RegisteredDao {

	/**
	 * 按条件检索检查费用项目进行管理
	 * 
	 * @param flag
	 *            启用停用标示位 1:启用 0：停用
	 * @param feeType
	 *            收费类型 1:缴费 2：退费
	 * @return List
	 */
	public List<RegisteredCategoryPo> getSelValue(String flag, String feeType) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" select f_rc_id as frcid ");
		buffer.append(",f_rc_registeredname as frcregisteredname ");
		buffer.append(",f_rc_money as frcmoney,F_RC_AmountType as frcamounttype ");
		buffer.append("from f_registeredcategory ");
		buffer.append("where 1=1 ");
		// 启用、停用
		buffer.append("and f_rc_flag = ? ");
		// 缴费、退费
		
		params.add(Utility.getName(flag));
		if(!"".equals(feeType)){
			buffer.append("and f_rc_feetype = ? ");
			params.add(Utility.getName(feeType));
		}
		
		buffer.append("order by f_rc_ordertype");
		
		return this.queryForObjectList(buffer.toString(), params.toArray(),RegisteredCategoryPo.class);
	}
	
	/**
	 * 查询所有收费项目
	 */
	public List<RegisteredCategoryPo> getRepairsCostList(){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select F_RC_ID as frcid,F_RC_RegisteredName as frcregisteredname,F_RC_InMoney as frcmoney,F_RC_OutMoney as frcoutmoney from F_RepairsCost ");
		buffer.append("where 1=1 ");
		
		return this.queryForObjectList(buffer.toString(),null,RegisteredCategoryPo.class);
	}

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT S_CR_RD_ID as scrrdid ");
		buffer.append(", S_CR_RD_DetailsID as scrrddetailsid ");
		buffer.append(", S_CR_RD_RegisteredID as scrrdregisteredid ");
		buffer.append(", S_CR_RD_Money as scrrdmoney");
		buffer.append(", F_RC_RegisteredName AS scrrdregistername ");
		buffer.append(", F_RC_AmountType AS scrrdamounttype ");
		buffer.append(", S_CR_RD_CheckPerson AS scrrdcheckperson ");
		buffer.append(", personName AS scrrdcheckpersonname ");
		buffer.append("FROM F_RegisteredCategory ");
		buffer.append("INNER JOIN S_CR_RegisteredDetails ");
		buffer.append("ON F_RC_ID = S_CR_RD_RegisteredID ");
		buffer.append("INNER JOIN SYS_PersonInfo ON ID = S_CR_RD_CheckPerson ");
		buffer.append("WHERE DATEDIFF (DAY, GETDATE(), S_CR_RD_OptDate  ) = 0 ");
		buffer.append("and S_CR_RD_CustomerID = ? ");
		buffer.append("and S_CR_RD_Flag = 0 ");

		List<String> params = new ArrayList<String>();
		params.add(customerid);

		return this.queryForObjectList(buffer.toString(), params.toArray(),
				RegisteredDetailsPo.class);
	}

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @param typeFlag:1:挂号;2:退挂号；
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid,String typeFlag){
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT S_CR_RD_ID as scrrdid ");
		buffer.append(", S_CR_RD_DetailsID as scrrddetailsid ");
		buffer.append(", S_CR_RD_RegisteredID as scrrdregisteredid ");
		buffer.append(", S_CR_RD_Money as scrrdmoney");
		buffer.append(", F_RC_RegisteredName AS scrrdregistername ");
		buffer.append(", F_RC_AmountType AS scrrdamounttype ");
		buffer.append(", S_CR_RD_CheckPerson AS scrrdcheckperson ");
		buffer.append(", personName AS scrrdcheckpersonname ");
		buffer.append("FROM F_RegisteredCategory ");
		buffer.append("INNER JOIN S_CR_RegisteredDetails ");
		buffer.append("ON F_RC_ID = S_CR_RD_RegisteredID ");
		buffer.append("INNER JOIN SYS_PersonInfo ON ID = S_CR_RD_CheckPerson ");
		
		buffer.append("INNER JOIN B_Departments  ON S_CR_RD_ShopCode = B_DP_DepartmentID ");
		
		buffer.append("WHERE DATEDIFF (DAY, GETDATE(), S_CR_RD_OptDate  ) = 0 ");
		buffer.append("and S_CR_RD_CustomerID = ? ");
		buffer.append("and S_CR_RD_Flag = 0 ");
		
		buffer.append("and isnull(B_DP_LinkHisFlag,'0') = '0' "); 
		
		buffer.append("and F_RC_FeeType = ? ");
		
		List<String> params = new ArrayList<String>();
		params.add(customerid);
		params.add(typeFlag);
		return this.queryForObjectList(buffer.toString(), params.toArray(),
				RegisteredDetailsPo.class);
	}
	
	/**
	 * 新增挂号明细表信息
	 * 
	 * @param po
	 */
	public void insertRegisteredDetails(RegisteredDetailsPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("insert into S_CR_RegisteredDetails ");
		sb.append("(S_CR_RD_ID,");
		sb.append("S_CR_RD_DetailsID,");
		sb.append("S_CR_RD_CustomerID,");
		sb.append("S_CR_RD_ShopCode,");
		sb.append("S_CR_RD_RegisteredID,");
		sb.append("S_CR_RD_Flag,");
		sb.append("S_CR_RD_Money,");
		sb.append("S_CR_RD_OptDate,");
		sb.append("S_CR_RD_Register,");
		sb.append("S_CR_RD_Casher,");
		sb.append("S_CR_RD_CasherDate,");
		sb.append("S_CR_RD_FactCasherDate,");
		sb.append("S_CR_RD_AmountType,");
		sb.append("S_CR_RD_CheckPerson ) ");

		sb.append("select replace(newid(), '-', ''), ?, ?, ?, f_RC_id, '1', F_RC_Money, getdate(),?,");
		sb.append("?, dbo.ufn_getDayCheckOut(),getdate(),?,? from F_RegisteredCategory where f_RC_id = ? ");

		List<String> params = new ArrayList<String>();
		
		params.add(po.getScrrddetailsid());
		params.add(po.getScrrdcustomerid());
		params.add(po.getScrrdshopcode());
		params.add(po.getScrrdcasher());
		params.add(po.getScrrdregister());
		params.add(po.getScrrdamounttype());
		params.add(po.getScrrdcheckperson());
		params.add(po.getScrrdregisterid());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}


	public void updateRegisteredDetails(RegisteredDetailsPo po) {
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer();
		sb.append("update S_CR_RegisteredDetails set ");
		sb.append("  S_CR_RD_Flag = 1 ");
		sb.append(", S_CR_RD_Casher = ? ");
		sb.append(", S_CR_RD_CasherDate = dbo.ufn_getDayCheckOut() ");
		sb.append(", S_CR_RD_FactCasherDate = GETDATE() ");
		
		if (!"".equals(Utility.getName(po.getScrrdshopcode()))){
			sb.append(", S_CR_RD_ShopCode = ? ");
		}
		
		sb.append("where S_CR_RD_ID = ? ");

		List<String> params = new ArrayList<String>();
		params.add(po.getScrrdcasher());
		if (!"".equals(Utility.getName(po.getScrrdshopcode()))){
			params.add(Utility.getName(po.getScrrdshopcode()));
		}
		params.add(po.getScrrdid());

		getJdbcTemplate().update(sb.toString(), params.toArray());

	}
	
	/**
	 * 新增维修明细表信息
	 * 
	 * @param po
	 */
	public void insertRepairsCostDetails(RegisteredDetailsPo po){

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("insert into S_CR_RepairsCostDetails (S_CR_RD_ID,S_CR_RD_DetailsID,S_CR_RD_CustomerID,S_CR_RD_ShopCode,S_CR_RD_RegisteredID, ");
		sb.append("S_CR_RD_Flag,S_CR_RD_Money,S_CR_RD_OptDate,S_CR_RD_Register,S_CR_RD_Casher,S_CR_RD_CasherDate,S_CR_RD_FactCasherDate ");
		sb.append(" ) values (replace(newid(), '-', ''),?,?,?,?,?,?,getdate(),?,?,dbo.ufn_getDayCheckOut(),getdate()) ");

		params.add(po.getScrrddetailsid());
		params.add(po.getScrrdcustomerid());
		params.add(po.getScrrdshopcode());
		params.add(po.getScrrdregisterid());		
		params.add(po.getScrrdflag());
		params.add(po.getScrrdmoney());		
		params.add(po.getScrrdregister());
		params.add(po.getScrrdcasher());
		
		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	/**
	 * 查询当日个人收费金额汇总
	 */
	public RegisteredDetailsPo getRegisteredPersonSumToday(String departmentID,String personID){
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT SUM(cast(S_CR_RD_Money as numeric(18,2))) AS scrrdpersonsumtoday ");
		
		buffer.append("FROM S_CR_RegisteredDetails ");

		buffer.append("WHERE CONVERT(VARCHAR(10), S_CR_RD_FactCasherDate, 120) = CONVERT(VARCHAR(10), Getdate(), 120) ");
		buffer.append("and S_CR_RD_ShopCode=? and S_CR_RD_Casher=? ");		

		List<String> params = new ArrayList<String>();
		params.add(departmentID);
		params.add(personID);
		
		return (RegisteredDetailsPo)this.queryForObject(buffer.toString(), params.toArray(),
				RegisteredDetailsPo.class);			
	}
}
