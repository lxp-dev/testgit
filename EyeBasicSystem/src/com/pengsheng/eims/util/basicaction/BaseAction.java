package com.pengsheng.eims.util.basicaction;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, SessionAware, ApplicationAware,ApplicationContextAware {

	public HttpServletRequest request;
	public HttpServletResponse response;
	public Map<String, Object> session;
	public Map<String, Object> application;	
	
	private static ApplicationContext context;//声明一个静态变量保存
	
	public void setApplicationContext(ApplicationContext contex) throws BeansException { 
	    this.context=contex; 
	} 
	public static ApplicationContext getContext(){ 
	    return context; 
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	// 注入Request对象
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	// 注入Request对象
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}
	
	protected String[] getReportDefultDate(SystemParameterPo systemParameterPo){
		
		String flag = Utility.getName(systemParameterPo.getFspreportdateflag());
		
		String tBgnDate = "";
		String tEndDate = "";
		SimpleDateFormat tempDate = null; 
		
		if (flag.equals("1")){  // 当天
			tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
			tBgnDate = tempDate.format(new Date());
			tEndDate = tBgnDate;
		}
		if (flag.equals("2")){ //当月
			tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
			SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-01");
			tBgnDate = currDate.format(new Date());
			
			Calendar cal = Calendar.getInstance();   
			cal.set( Calendar.DATE, 1 );
			cal.roll(Calendar.DATE, - 1 );
			Date endTime = cal.getTime();
			tEndDate = tempDate.format(endTime); 
		}
		if (flag.equals("3")){ //设置日期段
			SimpleDateFormat lastDate = new SimpleDateFormat("yyyy-MM-" + Utility.getName(systemParameterPo.getFspreportbgndate())); //起始日期
			SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-" + Utility.getName(systemParameterPo.getFspreportenddate())); //截止日期
			
			BigDecimal bg = new BigDecimal(Utility.getName(systemParameterPo.getFspreportMonth()));        //起始间隔月份
			BigDecimal bg2 = new BigDecimal(Utility.getName(systemParameterPo.getFspreportLastMonth()));   //截止间隔月份
					
			Calendar cal = Calendar.getInstance();
			Date endTime = null;
			cal.add(Calendar.MONTH,-bg2.intValue());
			endTime = cal.getTime();
			tEndDate = currDate.format(endTime);   //取的截止日期

			tempDate = new SimpleDateFormat("yyyy-MM-dd"); 
			cal.add(Calendar.MONTH, 1);    //加一个月
			cal.set(Calendar.DATE, 1);     //设置为该月第一天
			cal.add(Calendar.DATE, -1);    //再减一天即为截止月份最后一天
			String endDate = tempDate.format(cal.getTime());
			if (endDate.compareToIgnoreCase(tEndDate) < 0){
				tEndDate = endDate;
			}
			
			endTime = null;
			cal = Calendar.getInstance();
			
			cal.add(Calendar.MONTH,-bg.intValue());
			endTime = cal.getTime();
			tBgnDate = lastDate.format(endTime);
			
			cal.add(Calendar.MONTH, 1);    //加一个月
			cal.set(Calendar.DATE, 1);     //设置为该月第一天
			cal.add(Calendar.DATE, -1);    //再减一天即为截止月份最后一天
			endDate = tempDate.format(cal.getTime());
			if (endDate.compareToIgnoreCase(tBgnDate) < 0){
				tBgnDate = endDate;
			}
			
			String todayDate = tempDate.format(new Date());
			if (todayDate.compareToIgnoreCase(tEndDate) > 0 && bg2.intValue() == 0){
				
				cal = Calendar.getInstance();
				try {
					cal.setTime(tempDate.parse(tBgnDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cal.add(Calendar.MONTH, 1);    //加一个月
				tBgnDate = tempDate.format(cal.getTime());

				cal = Calendar.getInstance();
				try {
					cal.setTime(tempDate.parse(tEndDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cal.add(Calendar.MONTH, 1);    //加一个月
				tEndDate = tempDate.format(cal.getTime());
			}		
			
		}
		
		String[] strArray = {tBgnDate,tEndDate};
		
		return strArray;
		
	}

	/**
	 * 根据系统参数和部门类型获取门店列表，用于显示在页面的部门列表中
	 */
	public List<DepartmentsPo> getDepartmentListByCompany(SystemParameterPo systemParameterPo,PersonInfoPo ppo){
		
		List<DepartmentsPo> dList = null;
		DepartmentsMgr departmentsMgr = (DepartmentsMgr)context.getBean("departmentsMgr");
		
		if (!Utility.getName(ppo.getDepartmenttype()).equals("1") && !Utility.getName(ppo.getDepartmenttype()).equals("2")){   // 不是门店和加工
			
            if (Utility.getName(systemParameterPo.getFspissalesmessageshareforvandv()).equals("1")){ // 公司之间共享会员
				
				// 获取所有部门
				dList = departmentsMgr.getDepartments(null,null,"");
				
			}else {                              // 公司之间不能共享会员
				
				// 获取当前公司下所有部门
				dList = departmentsMgr.getDepartments(null,null,Utility.getName(ppo.getPersoncompanyid()));
			}
			
		}else{
			if (Utility.getName(systemParameterPo.getFspissalesmessageshareforvandv()).equals("1")){ // 公司之间共享会员
				
				if (Utility.getName(systemParameterPo.getFspissalesmessageshareformandv()).equals("1")){   // 公司内部共享会员
					
					// 获取所有门店
	            	String[] array = {"1"};
					dList = departmentsMgr.getDepartments(array,null,"");
					
				}else{                                 // 公司内部不能共享会员
					
					// 获取当前门店和所有的其他公司的门店
					dList = departmentsMgr.getDepartmentListByOtherCompany(ppo.getDepartmentID());
				}
				
			}else {                              // 公司之间不能共享会员
				
				if (Utility.getName(systemParameterPo.getFspissalesmessageshareformandv()).equals("1")){   // 公司内部共享会员
					
					// 获取当前门店所属公司下的所有门店
					dList = departmentsMgr.getDepartmentListByCompany(ppo.getDepartmentID());
					
				}else{                                 // 公司内部不能共享会员
					
					// 获取当前门店
					dList = new ArrayList<DepartmentsPo>();
					
					DepartmentsPo dpo = new DepartmentsPo();
					dpo.setBdpdepartmentid(ppo.getDepartmentID());
					dpo.setBdpdepartmentname(ppo.getBdpdepartmentname());
					dpo.setBdpcompanysid(ppo.getPersoncompanyid());
					dpo.setBdpcompanynature(ppo.getCompanynature());
					
					dList.add(dpo);

				}

			}
			
		}
		
		return dList;
		
	}
	
	/**
	 * 根据系统参数和部门类型获取仓位列表，用于显示在页面的仓位列表和sql的查询条件中
	 */
	public List<WarehousePo> getWarehouseListByCompany(SystemParameterPo systemParameterPo,PersonInfoPo ppo){
		
		List<WarehousePo> wList = null;
		WarehouseMgr warehouseMgr = (WarehouseMgr)context.getBean("warehouseMgr");		
		
        WarehousePo warehousePo = new WarehousePo();
        warehousePo.setBwhcompanyid(ppo.getPersoncompanyid());   // 当前公司
        
        if (ppo.getPersoncompanytype().equals("1") && "3".equals(ppo.getDepartmenttype())){       // 总公司的总库
        	
			//获取所有公司下的所有的仓位
        	wList = warehouseMgr.getWarehouseAllList(new DepartmentsPo());
        	
        }else {       // 分公司或总公司其他类型的部门
        	
    		if("0".equals(Utility.getName(systemParameterPo.getFspsharestockmessage()))){    // 公司内部库存不共享
    			
    			if ("1".equals(ppo.getDepartmenttype())) {
    				
    				//获取当前门店下的所有仓位
    				warehousePo.setBwhdeptid(ppo.getDepartmentID());
    				wList = warehouseMgr.getWarehouseList(warehousePo);
    				
    			} else if ("2".equals(ppo.getDepartmenttype())) {

    				//获取当前加工部门和加工区域为当前部门的门店下的所有仓位
    				wList = warehouseMgr.getWarehouseListForReg(ppo.getDepartmentID());
    				
    			} else {
    				
    				//获取当前公司下所有的仓位
    				wList = warehouseMgr.getWarehouseList(warehousePo);
    				
    			}
    			
    		}else{
    			
    			//获取当前公司下所有的仓位
    			wList = warehouseMgr.getWarehouseList(warehousePo);
    			
    		}
    		
        }
        	
		return wList;
		
	}

	public SystemParameterPo getSystemParameterByCompany(SystemParameterPo systemParameterPo,PersonInfoPo ppo){
		
		DepartmentsMgr departmentsMgr = (DepartmentsMgr)context.getBean("departmentsMgr");
		CompanyNamePo cpo = departmentsMgr.getCompanyInfoByDpt(ppo.getDepartmentID());
		
    	if("1".equals(ppo.getDepartmenttype()) && "1".equals(Utility.getName(cpo.getFcnmasterorvice()))){  // 判断是否是总公司
	    	if("1".equals(systemParameterPo.getFspsharestockmessage())&&!"4".equals(systemParameterPo.getFspstockqueryconditions())){
	    		systemParameterPo.setFspshowchange("1");
	    	}
    	}
    	
		return systemParameterPo;
	}

	/**
	 * 根据系统参数获取门店列表，用于sql中的查询条件
	 */
	public List<DepartmentsPo> getDepartmentListBySystemParameter(SystemParameterPo systemParameterPo,List<DepartmentsPo> dList){
		
		// 公司之间和公司内部军共享会员
		if (Utility.getName(systemParameterPo.getFspissalesmessageshareforvandv()).equals("1") && Utility.getName(systemParameterPo.getFspissalesmessageshareformandv()).equals("1")){
			return null;
		}
		
		return dList;
	}
	
	
	/**
	 * 配镜单查询模块，判断配镜单是否共享
	 */
	public List<DepartmentsPo> getShopCodeListByCompany(SystemParameterPo systemParameterPo,PersonInfoPo ppo){
		
		List<DepartmentsPo> dList = null;
		DepartmentsMgr departmentsMgr = (DepartmentsMgr)context.getBean("departmentsMgr");
		
		if (!Utility.getName(ppo.getDepartmenttype()).equals("1") && !Utility.getName(ppo.getDepartmenttype()).equals("2")){   // 不是门店和加工
			
			// 获取当前公司下所有门店
			dList = departmentsMgr.getDepartments(null,null,Utility.getName(ppo.getPersoncompanyid()));
			
		}else{
			
			if (Utility.getName(ppo.getDepartmenttype()).equals("1")){   // 门店
				
				if (Utility.getName(systemParameterPo.getFspissalesbillshareformandv()).equals("1")){ // 公司内部共享配镜单
					
					// 获取当前公司下所有门店
					dList = departmentsMgr.getDepartments(null,null,Utility.getName(ppo.getPersoncompanyid()));
					
				}else {                              // 公司内部不共享配镜单
					
					// 获取当前门店
					dList = new ArrayList<DepartmentsPo>();
					
					DepartmentsPo dpo = new DepartmentsPo();
					dpo.setBdpdepartmentid(ppo.getDepartmentID());
					dpo.setBdpdepartmentname(ppo.getBdpdepartmentname());
					dpo.setBdpcompanysid(ppo.getPersoncompanyid());
					dpo.setBdpcompanynature(ppo.getCompanynature());
					
					dList.add(dpo);

				}
				
			}
			
			if (Utility.getName(ppo.getDepartmenttype()).equals("2")){   // 加工
				
				DepartmentsPo dpo = new DepartmentsPo();
				dpo.setBdpdepartmentid(ppo.getDepartmentID());
				
				// 按照加工区域获取门店
				dList = departmentsMgr.getDepartmentsForRegional(dpo);
				
			}
			
		}
		
		return dList;
		
	}

}