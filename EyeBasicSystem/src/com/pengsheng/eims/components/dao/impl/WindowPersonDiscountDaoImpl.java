package com.pengsheng.eims.components.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.components.dao.WindowPersonDiscountDao;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class WindowPersonDiscountDaoImpl extends BaseJdbcDaoSupport implements
		WindowPersonDiscountDao {

	/**
	 * 查询员工折扣
	 * 
	 * @param personDiscountPo
	 * @return
	 */
	public PersonInfoPo getDiscount(PersonInfoPo personInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		if(!Utility.getName(personInfoPo.getGoodslevel()).equals("")){
			buffer.append(" select top 1  ID as id,F_PDD_Discount as personDiscount,personName as personName, ");
			buffer.append(" F_PDD_UUID as goodslevel, ");
			buffer.append(" F_PDD_SpecialDiscountNumber as fpdspecialdiscountnumber,F_PDD_SpecialDiscount as fpdspecialdiscount ");
			buffer.append(" from F_PersonDiscount ");
			buffer.append(" inner join SYS_PersonInfo on ID = F_PD_PersonID ");
			buffer.append(" left join F_PersonDiscountDetails on F_PDD_PersonID = F_PD_PersonID ");
		}else{
			buffer.append(" select top 1  ID as id,F_PD_Discount as personDiscount,personName as personName, ");
			buffer.append(" F_PD_SpecialDiscountNumber as fpdspecialdiscountnumber,F_PD_SpecialDiscount as fpdspecialdiscount ");
			buffer.append(" from F_PersonDiscount ");
			buffer.append(" inner join SYS_PersonInfo on ID = F_PD_PersonID ");
		}
		buffer.append("where ID = ? and  password = ?");

		params.add(personInfoPo.getId());
		params.add(personInfoPo.getPassword());
		
		if(!Utility.getName(personInfoPo.getGoodslevel()).equals("")){
			buffer.append(" and F_PDD_GoodsLevel = ? ");
			params.add(personInfoPo.getGoodslevel());
		}

		return (PersonInfoPo) queryForObject(buffer.toString(), params
				.toArray(), PersonInfoPo.class);
	}

	/**
	 * 查询员工折扣
	 * 
	 * @param personDiscountPo
	 * @return
	 */
	public PersonInfoPo getDiscountCard(PersonInfoPo personInfoPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  F_PD_Discount as personDiscount, SYS_PersonInfo.* ");
		buffer.append("from F_PersonDiscount ");
		buffer.append("inner join SYS_PersonInfo on ID = F_PD_PersonID ");
		buffer.append("where cardID = ? and userState = 0 and ");
		buffer.append("F_PD_Discount is not null and F_PD_Discount <> ''");

		params.add(personInfoPo.getCardid());

		return (PersonInfoPo) queryForObject(buffer.toString(), params
				.toArray(), PersonInfoPo.class);
	}
	
	/**
	 * 更新特殊折扣次数
	 * @param personid
	 */
	public void updateSpecialDiscountNumber(String personid){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();

		varname1.append("UPDATE dbo.F_PersonDiscount ");
		varname1.append("SET    F_PD_SpecialDiscountNumber = F_PD_SpecialDiscountNumber - 1 ");
		varname1.append("WHERE  F_PD_PersonID = ? ");
		
		params.add(personid);
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}
	
	/**
	 * 更新特殊折扣次数
	 * @param personid
	 */
	public void updateSpecialDiscountNumberLevel(String personid,String goodslevel){
		StringBuffer  varname1 = new StringBuffer();
		List<String> params = new ArrayList<String>();

		varname1.append("UPDATE F_PersonDiscountDetails ");
		varname1.append("SET    F_PDD_SpecialDiscountNumber = F_PDD_SpecialDiscountNumber - 1 ");
		varname1.append("WHERE  F_PDD_PersonID = ? ");
		varname1.append("  and  F_PDD_GoodsLevel = ? ");
		
		params.add(personid);
		params.add(goodslevel);
		
		getJdbcTemplate().update(varname1.toString(),params.toArray());
	}

	public List<PersonInfoPo> getPersonInfoPoList(PersonInfoPo personInfoPo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT distinct SYS_PersonInfo.ID         AS id, ");
		buffer.append("       SYS_PersonInfo.personName AS personName, ");
		buffer.append("       dbo.getDepartmentNameList(SYS_PersonInfo.ID)       AS bdpdepartmentname ");
		buffer.append("FROM   SYS_PersonInfo ");
		buffer.append("       INNER JOIN SYS_PersonRoles ");
		buffer.append("         ON SYS_PersonRoles.personID = SYS_PersonInfo.id ");
		buffer.append("       INNER JOIN SYS_Roles ");
		buffer.append("         ON SYS_Roles.roleid = SYS_PersonRoles.roleid ");
		buffer.append("WHERE  userState = 0 ");
		if(null != personInfoPo){
			if(!"".equals(Utility.getName(personInfoPo.getId()))){
				buffer.append(" and SYS_PersonInfo.ID like '%' + ? + '%'");
				params.add(Utility.getName(personInfoPo.getId()));
			}
			if(!"".equals(Utility.getName(personInfoPo.getPersonName()))){
				buffer.append(" and SYS_PersonInfo.personName like '%' + ? + '%'");
				params.add(Utility.getName(personInfoPo.getPersonName()));
			}
		}
		buffer.append("ORDER  BY SYS_PersonInfo.ID ");
		return queryForObjectList(buffer.toString() , params.toArray() , PersonInfoPo.class);
	}
	
	public List<RolePo> getRolePoList(RolePo rolePo){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("SELECT roleID              AS roleid, ");
		buffer.append("       roleName            AS rolename, ");
		buffer.append("       roleDescription     AS roledescription, ");
		buffer.append("       moduleApplicationID AS moduleapplicationid ");
		buffer.append("FROM   SYS_Roles ");
		buffer.append("ORDER  BY roleID ");
		return queryForObjectList(buffer.toString() , params.toArray() , RolePo.class);
	}
	
}
