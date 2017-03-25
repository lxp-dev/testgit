package com.pengsheng.eims.system.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.dao.PersonDiscountDao;
import com.pengsheng.eims.system.dao.RoleDiscountDao;
import com.pengsheng.eims.system.mgr.RoleDiscountMgr;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonRolesPo;
import com.pengsheng.eims.system.persistence.RoleDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class RoleDiscountMgrImpl implements RoleDiscountMgr {
	private final String CHANGE_DISCOUNT = "changeDiscount"; //更新角色下所有人员打折权限
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	private RoleDiscountDao roleDiscountDao;
	
	private PersonDiscountDao personDiscountDao;

	public PersonDiscountDao getPersonDiscountDao() {
		return personDiscountDao;
	}

	public void setPersonDiscountDao(PersonDiscountDao personDiscountDao) {
		this.personDiscountDao = personDiscountDao;
	}

	public RoleDiscountDao getRoleDiscountDao() {
		return roleDiscountDao;
	}

	public void setRoleDiscountDao(RoleDiscountDao roleDiscountDao) {
		this.roleDiscountDao = roleDiscountDao;
	}

	public int getRoleDiscountCount(RoleDiscountPo po) {
		
		return roleDiscountDao.getRoleDiscountCount(po);
	}
	
	public List<RoleDiscountPo> getRoleDiscountList(RoleDiscountPo po,
			int start, int size) {
		
		return roleDiscountDao.getRoleDiscountList(po, start, size);
	}
	
	public List<RolePo> getRoleList(RoleDiscountPo po) {
		
		return roleDiscountDao.getRoleList(po);
	}
	
	public RoleDiscountPo getRoleDiscount(RoleDiscountPo po) {
		
		return roleDiscountDao.getRoleDiscount(po);
	}
	
	public void insertRoleDiscount(RoleDiscountPo po,RoleDiscountDetailsPo idpo,LogisticsLogPo logPo, String changeDiscount) {

		roleDiscountDao.insertRoleDiscount(po);
		
		if(idpo != null){
			roleDiscountDao.deleteRoleDiscountDetails(po.getFrdroleid());
			for(int i=0; i<idpo.getFrddgoodslevels().length; i++){
				RoleDiscountDetailsPo ipo = new RoleDiscountDetailsPo();
				ipo.setFrddroleid(po.getFrdroleid());
				ipo.setFrddgoodslevel(idpo.getFrddgoodslevels()[i]);
				ipo.setFrdddiscount(idpo.getFrdddiscounts()[i]);
				roleDiscountDao.insertRoleDiscountDetails(ipo);
			}
		}
		
		if(CHANGE_DISCOUNT.equals(changeDiscount)) {
			String roleID=po.getFrdroleid();
			
			List<PersonRolesPo> personRolesList=roleDiscountDao.getPersonForRole(roleID);
			
			Iterator<PersonRolesPo> iter=personRolesList.iterator();
			while (iter.hasNext()){
				PersonRolesPo personRolesPo=iter.next();
				PersonDiscountPo discountPo=new PersonDiscountPo();
				discountPo.setFpdpersonid(personRolesPo.getPersonID());
				discountPo.setFpddiscount(po.getFrddiscount());
				personDiscountDao.deletePersonDiscount(discountPo);
				personDiscountDao.insertPersonDiscount(discountPo);
				
				if(idpo != null){
					personDiscountDao.deletePersonDiscountDetails(discountPo.getFpdpersonid());
					
					for(int i=0; i<idpo.getFrddgoodslevels().length; i++){
						PersonDiscountDetailsPo ipdpo = new PersonDiscountDetailsPo();
						ipdpo.setFpddpersonid(discountPo.getFpdpersonid());
						ipdpo.setFpddgoodslevel(idpo.getFrddgoodslevels()[i]);
						ipdpo.setFpdddiscount(idpo.getFrdddiscounts()[i]);
						ipdpo.setFpddspecialdiscountnumber("");
						ipdpo.setFpddspecialdiscount("");
						personDiscountDao.insertPersonDiscountDetails(ipdpo);
					}
				}
			}
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateRoleDiscount(RoleDiscountPo po,RoleDiscountDetailsPo idpo,LogisticsLogPo logPo, String changeDiscount) {

		roleDiscountDao.updateRoleDiscount(po);
		
		if(idpo != null){
			roleDiscountDao.deleteRoleDiscountDetails(po.getFrdroleid());
			for(int i=0; i<idpo.getFrddgoodslevels().length; i++){
				RoleDiscountDetailsPo ipo = new RoleDiscountDetailsPo();
				ipo.setFrddroleid(po.getFrdroleid());
				ipo.setFrddgoodslevel(idpo.getFrddgoodslevels()[i]);
				ipo.setFrdddiscount(idpo.getFrdddiscounts()[i]);
				roleDiscountDao.insertRoleDiscountDetails(ipo);
			}
		}
		
		if(CHANGE_DISCOUNT.equals(changeDiscount)) {
			String roleID=po.getFrdroleid();
			
			List<PersonRolesPo> personRolesList=roleDiscountDao.getPersonForRole(roleID);
			
			Iterator<PersonRolesPo> iter=personRolesList.iterator();
			while (iter.hasNext()){
				PersonRolesPo personRolesPo=iter.next();
				PersonDiscountPo discountPo=new PersonDiscountPo();
				discountPo.setFpdpersonid(personRolesPo.getPersonID());
				discountPo.setFpddiscount(po.getFrddiscount());
				personDiscountDao.deletePersonDiscount(discountPo);
				personDiscountDao.insertPersonDiscount(discountPo);
				
				if(idpo != null){
					personDiscountDao.deletePersonDiscountDetails(discountPo.getFpdpersonid());
					
					for(int i=0; i<idpo.getFrddgoodslevels().length; i++){
						PersonDiscountDetailsPo ipdpo = new PersonDiscountDetailsPo();
						ipdpo.setFpddpersonid(discountPo.getFpdpersonid());
						ipdpo.setFpddgoodslevel(idpo.getFrddgoodslevels()[i]);
						ipdpo.setFpdddiscount(idpo.getFrdddiscounts()[i]);
						ipdpo.setFpddspecialdiscountnumber("");
						ipdpo.setFpddspecialdiscount("");
						personDiscountDao.insertPersonDiscountDetails(ipdpo);
					}
				}
			}
			logisticsLogDao.insertLog(logPo); //添加日志
		}
	}
	
	public RoleDiscountPo getRoleDiscountDetail(RoleDiscountPo po) {
		
		return roleDiscountDao.getRoleDiscountDetail(po);
	}
	public List<PersonInfoPo> getPersonInfoByRole(RoleDiscountPo po) {
		return roleDiscountDao.getPersonInfoByRole(po);
	}
	
	public List<RoleDiscountDetailsPo> selectRoleDiscountDetails(
			RoleDiscountDetailsPo po) {
		return roleDiscountDao.selectRoleDiscountDetails(po);
	}
	
}
