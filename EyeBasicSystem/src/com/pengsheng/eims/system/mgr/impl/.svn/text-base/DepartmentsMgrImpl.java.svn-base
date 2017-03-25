package com.pengsheng.eims.system.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import rtx.RTXSvrApi;

import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.DepartmentTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.system.dao.PersonInfoDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class DepartmentsMgrImpl implements DepartmentsMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private SystemParameterDao systemParameterDao;
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	private ProcurementOrdersDao procurementOrdersDao;

	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}
	public void setProcurementOrdersDao(ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	private DepartmentsDao departmentsDao;
	private PersonInfoDao personInfoDao;
	private WarehouseDao warehouseDao;
	
	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}
	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}
	public PersonInfoDao getPersonInfoDao() {
		return personInfoDao;
	}

	public void setPersonInfoDao(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}

	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}

	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}
	
	/**
	 * 查询部门
	 */
	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo) {
		return departmentsDao.getDepartment(departmentsPo);
	}

	
	/**
	 * 查询所有部门信息
	 */
	public List<DepartmentsPo> getDepartments() {
		return departmentsDao.getDepartments();
	}
	
	/**
	 * 删除部门
	 */
	public boolean deleteDepartment(SystemParameterPo systemParameterPo,String departmentID,LogisticsLogPo logPo) {
		if(departmentsDao.getWarehouseOrPersonCountByDpt(departmentID)==0){
			//---------------RTX 数据同步 By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	

			if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
				RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
				if( RtxsvrapiObj.Init()){
			    	int iRet = -1;
			    	iRet = RtxsvrapiObj.deleteDept("1"+departmentID,"0");//0表示仅仅删除部门，不删部门下人员；
			    	if (iRet==0)
		    		{
			    		System.out.println("删除部门成功："+departmentID);
		    		}
		    		else 
		    		{
		    			System.out.println("删除部门失败"+departmentID);
		    		}
			    	
				}
				RtxsvrapiObj.UnInit();
			}
			//---------------RTX 数据同步  By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	
			
			departmentsDao.deleteDepartment(departmentID);   //删除部门信息
			departmentsDao.deleteDptPersonRelationship(departmentID);  // 删除部门与人员关联信息
			
			departmentsDao.deleteDefaultWarehouseByDpt(departmentID);  // 删除部门的默认仓位的设置
			departmentsDao.deleteOutWarehouseByDpt(departmentID);      // 删除部门的出仓仓位
			departmentsDao.deleteInWarehouseByDpt(departmentID);       // 删除部门的退款仓位
			departmentsDao.deleteWarehouseByDpt(departmentID);         // 删除部门下的仓位
			
			logisticsLogDao.insertLog(logPo); //添加日志
			return true;
		}else{
			return false;
		}
		
	}

	
	/**
	 * 添加部门
	 */
	public void insertDepartment(SystemParameterPo systemParameterPo,DepartmentsPo departmentsPo,LogisticsLogPo logPo) {
		//---------------RTX 数据同步 By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	
		if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
			RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
			if( RtxsvrapiObj.Init()){
		    	int iRet = -1;
		    	iRet = RtxsvrapiObj.addDept("1"+departmentsPo.getBdpdepartmentid(),"", departmentsPo.getBdpdepartmentname(),"0");
		    	if (iRet==0)
	    		{
		    		System.out.println("添加部门成功："+departmentsPo.getBdpdepartmentname());
	    		}
	    		else 
	    		{
	    			System.out.println("添加部门失败"+departmentsPo.getBdpdepartmentname());
	    		}
		    	
			}
			RtxsvrapiObj.UnInit();
		}
		//---------------RTX 数据同步  By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 
		
		departmentsDao.insertDepartment(departmentsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
		
		if ("1".equals(Utility.getName(departmentsPo.getIsNewWarehouse()))){  // 1:表示新增仓位  0：暂不新增
			
			WarehousePo warehousePo = new WarehousePo();
			warehousePo.setBwhid(departmentsPo.getWarehouseID());
			warehousePo.setBwhwarehouseName(departmentsPo.getWarehouseName());
			warehousePo.setBwhdeptid(departmentsPo.getBdpdepartmentid());
			
			warehouseDao.insertWarehouse(warehousePo);
			
			logPo.setsLogContent(departmentsPo.getWarehouseID());
			logisticsLogDao.insertLog(logPo); //添加日志
		}
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(departmentsPo.getBdpdepartmentid());		
		if (Utility.getName(departmentsPo.getBdptype()).equals("2")){
			po.setBdpperson("wbjgs");   //外部加工师
			departmentsDao.insertPersonDepartment(po);
		}
		if (Utility.getName(departmentsPo.getBdptype()).equals("1")){
			po.setBdpperson("wbygs");   //外部验光师
			departmentsDao.insertPersonDepartment(po);
		}
		if (Utility.getName(departmentsPo.getBdptype()).equals("3")){
			po.setBdpperson("psb001");  //配送部临时人员
			departmentsDao.insertPersonDepartment(po);
			
			po.setBdpperson("yyb001");  //配送部临时人员
			departmentsDao.insertPersonDepartment(po);
		}
		
	}

	
	/**
	 * 修改部门
	 */
	public void updateDepartment(SystemParameterPo systemParameterPo,DepartmentsPo departmentsPo,LogisticsLogPo logPo) {
		//---------------RTX 数据同步 By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	
		if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
			RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
			if( RtxsvrapiObj.Init()){
		    	int iRet = -1;
		    	iRet = RtxsvrapiObj.setDept("1"+departmentsPo.getBdpdepartmentid(),"", departmentsPo.getBdpdepartmentname(),"0");
		    	if (iRet==0)
	    		{
		    		System.out.println("更新部门成功："+departmentsPo.getBdpdepartmentname());
	    		}
	    		else 
	    		{
	    			System.out.println("更新部门失败"+departmentsPo.getBdpdepartmentname());
	    		}
		    	
			}
			RtxsvrapiObj.UnInit();
		}
		//---------------RTX 数据同步  By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 
		
		departmentsDao.updateDepartment(departmentsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 初始化各部门打印单据为系统默认设置模版
	 */
	public void updateDepartmentDefaultBill(LogisticsLogPo logPo) {
		
		departmentsDao.updateDepartmentDefaultBill();
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	
	/**
	 * 根据区域ID取出所有相同类型的门店
	 */
	public List<DepartmentsPo> getDepartments(DepartmentsPo po) {
		
		List<DepartmentsPo> departmentlist=new ArrayList<DepartmentsPo>();
		String departmenttype=Utility.getName(po.getBdptype());
		if(departmenttype.equals("") || departmenttype.equals("3")||departmenttype.equals("4")||departmenttype.equals("2")||departmenttype.equals("5")){//仓储 取所有部门
			if(po.getBdpisalldepartments()!=null && po.getBdpisalldepartments().equals("all")){
				departmentlist=departmentsDao.getAllDepartments(po);
			}else{
				departmentlist=departmentsDao.getDepartments(po);
			}	
		}else if(departmenttype.equals("1")){//门店 取本部门
			departmentlist.add(po);
		}
		return departmentlist;
	}
	
	public List<DepartmentsPo> getDepartments2(DepartmentsPo po) {
		return departmentsDao.getDepartments2(po);
	}
	
	/**
	 * 根据区域ID取出所有相同类型的门店
	 */
	public List<DepartmentsPo> getDepartmentwheres(DepartmentsPo po) {
		
		List<DepartmentsPo> departmentlist=new ArrayList<DepartmentsPo>();
    		String departmenttype=po.getBdptype();
			if(departmenttype.equals("3")||departmenttype.equals("4")||departmenttype.equals("2")||departmenttype.equals("5")){//仓储 取所有部门
				departmentlist=departmentsDao.getDepartmentwheres(po);
	
			}else if(departmenttype.equals("1")){//门店 取本部门
				departmentlist.add(po);
			}
		return departmentlist;
	}
	
	/**
	 * 调拨使用
	 */
	public List<DepartmentsPo> getDepartmentAll(DepartmentsPo po) {
		
		List<DepartmentsPo> departmentlist=new ArrayList<DepartmentsPo>();
    		String departmenttype=po.getBdptype();
			if(departmenttype.equals("6")){//仓储 取所有部门
				departmentlist=departmentsDao.getDepartmentwheres(po);
	
			}else if(departmenttype.equals("1")||departmenttype.equals("3")||departmenttype.equals("4")||departmenttype.equals("2")||departmenttype.equals("5")){//门店 取本部门
				departmentlist.add(po);
			}
		return departmentlist;
	}
	
	public List<DepartmentsPo> getDepartmentsMove(DepartmentsPo po) {
		
		List<DepartmentsPo> departmentlist=new ArrayList<DepartmentsPo>();
		
		
		
		StatusModulePo statusModulePo =new StatusModulePo();
		statusModulePo = procurementOrdersDao.OrdersStatus("5"); //是否共享门店销售信息
    	if("0".equals(Utility.getName(statusModulePo.getFsmstatuscode()))) //0表示共享1表示不共享
    	{
    		departmentlist=departmentsDao.getDepartments("1");
    	}
    	else
    	{
    		String departmenttype=po.getBdptype();
			if(departmenttype.equals("3")||departmenttype.equals("4")||departmenttype.equals("5")){//仓储 取所有部门
				departmentlist=departmentsDao.getDepartments();
	
			}else if(departmenttype.equals("1")){//门店 取本部门
				departmentlist.add(po);
			}else if(departmenttype.equals("2"))
			{
				departmentlist=departmentsDao.getDepartmentsForRegional(po);
			}
    	}
		return departmentlist;
	}
	
	/**
	 * 查询所有部门
	 */
	public List<DepartmentsPo> getDepartmentsInfo(DepartmentsPo po) {
		return departmentsDao.getDepartments(po.getBdptype());
	}
	
	/**
	 * 查询当前门店
	 * 	 */
	public List<DepartmentsPo> getDepartmentOne(DepartmentsPo po) {
		List<DepartmentsPo> departmentlist=new ArrayList<DepartmentsPo>();
		departmentlist.add(po);
		return departmentlist;
	}

	
	/**
	 * 取调拨门店汇总
	 */
	public List<DepartmentsPo> getDepartmentsForAllocation(DepartmentsPo po) {
		
		List<DepartmentsPo> departmentlist=new ArrayList<DepartmentsPo>();
		String departmenttype = po.getBdptype();
		
		if(departmenttype.equals("3")){//仓储 取所有部门
			departmentlist = departmentsDao.getDepartmentwheres(po);

		}else if(departmenttype.equals("2")){//区域 取本区域下对于门店+本区域
			
			po.setBdpcompanysid(po.getBdpothercompanyid());
			departmentlist.add(po);//添加本部门
 		
		}else if(departmenttype.equals("1")){//门店 取本部门
			
			po.setBdpcompanysid(po.getBdpothercompanyid());
			departmentlist.add(po);//添加本部门
		}
		
		return departmentlist;
	}
	

	
	public List<DepartmentsPo> getDepartments(String departmenttype) {
		return departmentsDao.getDepartments(departmenttype);
	}
	
	/**
	 * 取所有部门根据本门类型
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartments(String departmenttype,String isclosed){
		return departmentsDao.getDepartments(departmenttype,isclosed);
	}
	
	/**
	 * 查询部门的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getDepartmentCount(DepartmentsPo po){
		return departmentsDao.getDepartmentCount(po);
	}
	
	/**
	 * 查询部门列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po,int start,int size){
		return departmentsDao.getDepartmentList(po,start,size);
	}
	
	/**
	 * 设置默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public int getDefaultWarehouseByDptCount(WarehouseConfigurationPo warehouseConfigurationPo){
		return departmentsDao.getDefaultWarehouseByDptCount(warehouseConfigurationPo);
	}
	
	/**
	 * 修改默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void updateDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo,LogisticsLogPo logPo){
		departmentsDao.updateDefaultWarehouse(warehouseConfigurationPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 新增默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void insertDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo,LogisticsLogPo logPo){
		departmentsDao.insertDefaultWarehouse(warehouseConfigurationPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 获取默认仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getDefaultWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo){
		return departmentsDao.getDefaultWarehouseByDpt(warehouseConfigurationPo);
	}
	
	/**
	 * 获取出仓仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getOutWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo){
		return departmentsDao.getOutWarehouseByDpt(warehouseConfigurationPo);
	}
	
	/**
	 * 获取默认仓位名称
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getDefaultWarehouse(WarehouseConfigurationPo warehouseConfigurationPo){
		return departmentsDao.getDefaultWarehouse(warehouseConfigurationPo);
	}
	
	/**
	 * 获取退款仓位
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public WarehouseConfigurationPo getInWarehouseByDpt(WarehouseConfigurationPo warehouseConfigurationPo){
		return departmentsDao.getInWarehouseByDpt(warehouseConfigurationPo);
	}
	
	/**
	 * 停用启用部门
	 * 
	 * @param warehouseConfigurationPo
	 * @return
	 */
	public void usingDepartment(DepartmentsPo departmentsPo,LogisticsLogPo logPo ){
		departmentsDao.usingDepartment(departmentsPo);
		departmentsDao.usingWarehouse(departmentsPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 根据部门ID查询所属仓位
	 */
	public List<WarehousePo> getWarehouseByDpt(DepartmentsPo departmentsPo){
		return departmentsDao.getWarehouseByDpt(departmentsPo);
	}
	
	/**
	 * 查询所有门店和配送部门
	 */
	public List<DepartmentsPo> getSalesAndStorageDepartment(){
		return departmentsDao.getSalesAndStorageDepartment();
	}
	
	public List<DepartmentsPo> getSalesAndStorageDepartment(DepartmentsPo departmentsPo){
		return departmentsDao.getSalesAndStorageDepartment(departmentsPo);
	}
	
	/**
	 * 取所有部门(组织结构)
	 * 
	 * @return
	 */
	public List<FuctionTreeNode> getDepartmentsTree(String nodeId,String hrefTarget,String href,String isClosed,String isRole,String isPerson,String companyID){
		//System.out.println(nodeId+"@@@@@@"+isRole);
		if (nodeId.startsWith("L_")){
			if(isRole.equals("1"))
			{
				List<FuctionTreeNode> mp=departmentsDao.getPersonTree(nodeId, hrefTarget, href, isPerson,companyID);
				if(mp!=null && mp.size()>0)
				{
					for(int i=0;i<mp.size();i++)
					{
						FuctionTreeNode tn=mp.get(i);
						if(tn.getCls().equals("1"))
						{
							tn.setText(tn.getText()+"<label style='color:red;'>(离职)</label>");
						}
					}
				}
				return mp;
			}else
			{
				return departmentsDao.getRoleByDptTree(nodeId,hrefTarget,href,isPerson,companyID);
			}
		}else if (nodeId.startsWith("R_"))
		{
			List<FuctionTreeNode> mp=departmentsDao.getPersonByDptTree(nodeId,hrefTarget,href,isPerson,companyID);
			if(mp!=null && mp.size()>0)
			{
				for(int i=0;i<mp.size();i++)
				{
					FuctionTreeNode tn=mp.get(i);
					if(tn.getCls().equals("1"))
					{
						tn.setText(tn.getText()+"<label style='color:red;'>(离职)</label>");
					}
				}
			}
			return mp;
		}else 
		{
			List<FuctionTreeNode> mp=departmentsDao.getDepartmentsTree(nodeId,hrefTarget,href,isClosed,companyID);
			if(mp!=null && mp.size()>0)
			{
				for(int i=0;i<mp.size();i++)
				{
					FuctionTreeNode tn=mp.get(i);
					if(tn.getCls().equals("1"))
					{
						tn.setText(tn.getText()+"<label style='color:red;'>(已停用)</label>");
					}
				}
			}
			return mp;
			

		}		
	}
	
	/**
	 * 取所有银行卡名称
	 * 
	 * @return
	 */
	public List<BrankCardPo> getBankCardList(){
		return departmentsDao.getBankCardList();
	}
	
	/**
	 * 查询客户的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getFranchiseeCount(DepartmentsPo po){
		return departmentsDao.getFranchiseeCount(po);
	}
	
	/**
	 * 查询客户列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getFranchiseeList(DepartmentsPo po,int start,int size){
		return departmentsDao.getFranchiseeList(po,start,size);
	}
	

	/**
	 * 插入客户
	 * 
	 * @param departmentsPo
	 */
	public void insertFranchisee(DepartmentsPo departmentsPo,LogisticsLogPo logPo){
		departmentsDao.insertFranchisee(departmentsPo);		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 更新客户
	 * 
	 * @param departmentsPo
	 */
	public void updateFranchisee(DepartmentsPo departmentsPo,LogisticsLogPo logPo){
		departmentsDao.updateFranchisee(departmentsPo);		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除客户
	 * 
	 * @param departmentID
	 */
	public void deleteFranchisee(String departmentID,LogisticsLogPo logPo){
		departmentsDao.deleteFranchisee(departmentID);		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 取指定客户
	 * 
	 * @param departmentsPo
	 *            部门参数集
	 * @return
	 */
	public DepartmentsPo getFranchisee(DepartmentsPo departmentsPo){
		return departmentsDao.getFranchisee(departmentsPo);
	}
	
	/**
	 * 调拨查询页面使用
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo po){
		return departmentsDao.getDepartmentsList(po);
	}
	public List<DepartmentsPo> getDepartments(String[] departmenttype, String isClosed, String companyID) {
		// TODO Auto-generated method stub
		return departmentsDao.getDepartments(departmenttype, isClosed,companyID);
	}
	
	/**
	 * 取部门对应的配镜单模版
	 */
	public DepartmentsPo getBillTemplate(String departmentID){
		return departmentsDao.getBillTemplate(departmentID);
	}
	
	/**
	 * 更新部门对应的配镜单模版
	 */
	public void updateBillTemplate(DepartmentsPo po){
		departmentsDao.updateBillTemplate(po);
	}
	
	/**
	 * 启用停用客户
	 */
	public void updateFranchiseeEnable(DepartmentsPo po,LogisticsLogPo logPo){
		departmentsDao.updateFranchiseeEnable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public String getDepartmentByWarehouseID(String warehouseid){
		return departmentsDao.getDepartmentByWarehouseID(warehouseid);
	}

	/**
	 * 根据部门ID查询相同公司的部门
	 */
	public List<DepartmentsPo> getDepartmentListByCompany(String departmentID){
		return departmentsDao.getDepartmentListByCompany(departmentID);
	}
	
	/**
	 * 根据部门ID查询其他公司的部门
	 */
	public List<DepartmentsPo> getDepartmentListByOtherCompany(String departmentID){
		return departmentsDao.getDepartmentListByOtherCompany(departmentID);
	}
	
	/**
	 * 根据部门ID查询当前公司
	 */
	public CompanyNamePo getCompanyInfoByDpt(String departmentID){
		return departmentsDao.getCompanyInfoByDpt(departmentID);
	}
	
	/**
	 * 查询当前会员卡号与部门是同属一个公司
	 */
	public int getCustomerCount(String memberID,String departmentID){
		return departmentsDao.getCustomerCount(memberID,departmentID);
	}
	
	/**
	 * 查询部门表所有信息
	 */
	public List<DepartmentsPo> getAllDepartments(){
		return departmentsDao.getAllDepartments();
	}

	/**
	 * 查询部门表所有信息(通过登录人员取出人员公司下的部门)
	 */
	public List<DepartmentsPo> getDepartments(PersonInfoPo po){
		return departmentsDao.getDepartments(po);
	}
	
	/**
	 * 根据公司ID查询公司下的部门ID（报表使用）
	 */
	public List<DepartmentsPo> getDepartmentIDByCompanysID(DepartmentsPo po){
		return departmentsDao.getDepartmentIDByCompanysID(po);
	}
	
	/**
	 * 取得当前公司下的所有门店
	 * 
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentsByCompanyID(DepartmentsPo po){
		return departmentsDao.getDepartmentsByCompanyID(po);
	}
	
	public List<WarehousePo> getWarehouseByDptCompany(DepartmentsPo po){
		return departmentsDao.getWarehouseByDptCompany(po);
	}
	
	public List<DepartmentsPo> getDepartmentsForRegional(DepartmentsPo po){
		return departmentsDao.getDepartmentsForRegional(po);
	}
	
	/**
	 * 取总公司库房
	 */
	public List<DepartmentsPo> getParentCompanyDepartments(String flag){
		return departmentsDao.getParentCompanyDepartments(flag);
	}
	
	/**
	 * 获取部门类型
	 */
	public List<DepartmentTypePo> getDepartmentTypeList(){
		return departmentsDao.getDepartmentTypeList();
	}
	
	/**
	 * 设置部门期初日期和上线日期
	 */
	public void updateDepartmentDate(DepartmentsPo po,LogisticsLogPo logPo){
		departmentsDao.updateDepartmentDate(po);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}	
	
	/**
	 * 获取门店配置的HIS信息
	 */
	public DepartmentsPo getDepartmentSetHisInfo(String departmentID){
		return departmentsDao.getDepartmentSetHisInfo(departmentID);
	}
	
	/**
	 * 更新门店配置的HIS信息
	 */
	public void updateDepartmentSetHisInfo(DepartmentsPo po,LogisticsLogPo logPo){
		
		departmentsDao.updateDepartmentSetHisInfo(po);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
}
