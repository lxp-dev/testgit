package com.pengsheng.eims.system.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.system.dao.PersonPermissionDao;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.tools.Utility;

public class PersonPermissionMgrImpl implements PersonPermissionMgr {

	private PersonPermissionDao personPermissionDao;

	public PersonPermissionDao getPersonPermissionDao() {
		return personPermissionDao;
	}

	public void setPersonPermissionDao(PersonPermissionDao personPermissionDao) {
		this.personPermissionDao = personPermissionDao;
	}

	public PersonPermissionPo getPersonPermission(PersonPermissionPo po) {
		List<PersonPermissionPo> permissionlist = personPermissionDao.getPersonPermissionList(po);
		PersonPermissionPo personPermissionPo = getPersonPermissionPo(permissionlist);
		return personPermissionPo;
	}

	private PersonPermissionPo getPersonPermissionPo(List<PersonPermissionPo> list) {

		PersonPermissionPo permissionPo = new PersonPermissionPo();

		Iterator<PersonPermissionPo> it = list.iterator();
		while (it.hasNext()) {
			PersonPermissionPo po = (PersonPermissionPo) it.next();
			if (po.getPageValue().equals("1")) {
				permissionPo.setKeya(po.getPageKey());
			} else if (po.getPageValue().equals("2")) {
				permissionPo.setKeyb(po.getPageKey());
			} else if (po.getPageValue().equals("3")) {
				permissionPo.setKeyc(po.getPageKey());
			} else if (po.getPageValue().equals("4")) {
				permissionPo.setKeyd(po.getPageKey());
			} else if (po.getPageValue().equals("5")) {
				permissionPo.setKeye(po.getPageKey());
			} else if (po.getPageValue().equals("6")) {
				permissionPo.setKeyf(po.getPageKey());
			} else if (po.getPageValue().equals("7")) {
				permissionPo.setKeyg(po.getPageKey());
			} else if (po.getPageValue().equals("8")) {
				permissionPo.setKeyh(po.getPageKey());
			} else if (po.getPageValue().equals("9")) {
				permissionPo.setKeyi(po.getPageKey());
			} else if (po.getPageValue().equals("10")) {
				permissionPo.setKeyj(po.getPageKey());
			} else if (po.getPageValue().equals("11")) {
				permissionPo.setKeyk(po.getPageKey());
			} else if (po.getPageValue().equals("12")) {
				permissionPo.setKeyl(po.getPageKey());
			} else if (po.getPageValue().equals("13")) {
				permissionPo.setKeym(po.getPageKey());		
			} else if (po.getPageValue().equals("14")) {
				permissionPo.setKeyn(po.getPageKey());					
			} else if (po.getPageValue().equals("15")) {
				permissionPo.setKeyo(po.getPageKey());				
			} else if (po.getPageValue().equals("16")) {
				permissionPo.setKeyp(po.getPageKey());			
			} else if (po.getPageValue().equals("17")) {
				permissionPo.setKeyq(po.getPageKey());			
			} else if (po.getPageValue().equals("18")) {
				permissionPo.setKeyr(po.getPageKey());				
			} else if (po.getPageValue().equals("19")) {
				permissionPo.setKeys(po.getPageKey());
			} else if (po.getPageValue().equals("20")) {
				permissionPo.setKeyt(po.getPageKey());
			} else if (po.getPageValue().equals("21")) {
				permissionPo.setKeyu(po.getPageKey());
			}
		
			permissionPo.setModuleName(Utility.getName(po.getModuleName()));
		}

		
		
		return permissionPo;
	}
}
