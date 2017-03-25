package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.quartz.dao.ConsignProcessDao;
import com.pengsheng.eims.quartz.dao.CustomerLevelUpDao;
import com.pengsheng.eims.quartz.mgr.CustomerLevelUpMgr;
import com.pengsheng.eims.quartz.persistence.CustomerLevelUpPo;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerLevelUpMgrImpl implements CustomerLevelUpMgr{
	private CustomerLevelUpDao customerLevelUpDao; 
	public String first  = "4028806725d42d300125d47c76d60004";
	public String second = "4028806926a11d710126a15546260003";
	public String third  = "4028806926a11d710126a15830000004";
	public String fourth = "4028808242371fe2014249e28a120907";
	public String fifth  = "4028808242371fe2014249e333fe090c";
	
	public void updateCustomerLevel(CustomerLevelUpPo po){
		List<CustomerLevelUpPo> cpos = customerLevelUpDao.getCustomerLevelList(null);
		
		
		for(int i=0; i<cpos.size(); i++){
			CustomerLevelUpPo cpo = cpos.get(i);
			String atype = cpo.getCluagotype();
			double daysum = Double.parseDouble(cpo.getClutodaysalessum());
			double yearsum = Double.parseDouble(cpo.getClutwoyearssalessum());
			//System.out.println(i);
			if(daysum > 2000 && daysum <= 8000){
				cpo.setClunowtype(second);
				if(isLevelUP(cpo)){
					customerLevelUpDao.updateCustomerLevel(cpo);
				}else{
					if(yearsum >= 3000 && atype.equals(first) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						cpo.setClunowtype(second);
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 3000 && atype.equals(second) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						cpo.setClunowtype(third);
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 5000 && atype.equals(third) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						cpo.setClunowtype(fourth);
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 8000 && atype.equals(fourth) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						cpo.setClunowtype(fifth);
						customerLevelUpDao.updateCustomerLevel(cpo);
					}
				}
			}else if(daysum > 8001 && daysum <= 20000){
				cpo.setClunowtype(third);
				if(isLevelUP(cpo)){
					customerLevelUpDao.updateCustomerLevel(cpo);
				}else{
					if(yearsum >= 3000 && atype.equals(first) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 3000 && atype.equals(second) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 5000 && atype.equals(third) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 8000 && atype.equals(fourth) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}
				}
			}else if(daysum > 20001 && daysum <= 30000){
				cpo.setClunowtype(fourth);
				if(isLevelUP(cpo)){
					customerLevelUpDao.updateCustomerLevel(cpo);
				}else{
					if(yearsum >= 3000 && atype.equals(first) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 3000 && atype.equals(second) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 5000 && atype.equals(third) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 8000 && atype.equals(fourth) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}
				}
			}else if(daysum > 30001){
				cpo.setClunowtype(fifth);
				if(isLevelUP(cpo)){
					customerLevelUpDao.updateCustomerLevel(cpo);
				}else{
					if(yearsum >= 3000 && atype.equals(first) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 3000 && atype.equals(second) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 5000 && atype.equals(third) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}else if(yearsum >= 8000 && atype.equals(fourth) && !"".equals(Utility.getName(cpo.getClunowtype()))){
						customerLevelUpDao.updateCustomerLevel(cpo);
					}
				}
			}
		}
	}
	
	private boolean isLevelUP(CustomerLevelUpPo po){
		int agonum = 0;
		int nownum = 0;
		
		if(first.equals(po.getCluagotype())){
			agonum = 1;
		}else if(second.equals(po.getCluagotype())){
			agonum = 2;
		}else if(third.equals(po.getCluagotype())){
			agonum = 3;
		}else if(fourth.equals(po.getCluagotype())){
			agonum = 4;
		}else if(fifth.equals(po.getCluagotype())){
			agonum = 5;
		}
		
		if(first.equals(po.getClunowtype())){
			nownum = 1;
		}else if(second.equals(po.getClunowtype())){
			nownum = 2;
		}else if(third.equals(po.getClunowtype())){
			nownum = 3;
		}else if(fourth.equals(po.getClunowtype())){
			nownum = 4;
		}else if(fifth.equals(po.getClunowtype())){
			nownum = 5;
		}
		
		if(nownum > agonum){
			return true;	
		}else{
			return false;	
		}
	}

	public CustomerLevelUpDao getCustomerLevelUpDao() {
		return customerLevelUpDao;
	}

	public void setCustomerLevelUpDao(CustomerLevelUpDao customerLevelUpDao) {
		this.customerLevelUpDao = customerLevelUpDao;
	}
}
