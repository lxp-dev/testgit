package com.pengsheng.eims.system.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import rtx.RTXSvrApi;

import com.pengsheng.eims.basic.persistence.PersonJobTypePo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.system.dao.PersonDiscountDao;
import com.pengsheng.eims.system.dao.PersonInfoDao;
import com.pengsheng.eims.system.dao.RoleDiscountDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class PersonInfoMgrImpl implements PersonInfoMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private SystemParameterDao systemParameterDao;
	private PersonDiscountMgr personDiscountMgr;
	
	public PersonDiscountMgr getPersonDiscountMgr() {
		return personDiscountMgr;
	}
	public void setPersonDiscountMgr(PersonDiscountMgr personDiscountMgr) {
		this.personDiscountMgr = personDiscountMgr;
	}
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

	private PersonInfoDao personInfoDao;

	private RoleDiscountDao roleDiscountDao;

	private PersonDiscountDao personDiscountDao;

	private List<PersonDepartmentsPo> personDepartments;

	public PersonInfoDao getPersonInfoDao() {
		return personInfoDao;
	}

	public void setPersonInfoDao(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}

	public RoleDiscountDao getRoleDiscountDao() {
		return roleDiscountDao;
	}

	public void setRoleDiscountDao(RoleDiscountDao roleDiscountDao) {
		this.roleDiscountDao = roleDiscountDao;
	}

	public PersonDiscountDao getPersonDiscountDao() {
		return personDiscountDao;
	}

	public void setPersonDiscountDao(PersonDiscountDao personDiscountDao) {
		this.personDiscountDao = personDiscountDao;
	}

	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}
	
	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}
	
	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos(PersonInfoPo personInfoPo,
			int start, int size) {
		
		return personInfoDao.getPersonInfos(personInfoPo, start, size);
	}

	/**
	 * 得到部门中所有在职人员
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfosByDepartmentid(String departmentid){
		return personInfoDao.getPersonInfosByDepartmentid(departmentid);
	}
	
	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount(PersonInfoPo personInfoPo) {
		
		return personInfoDao.getPersoninfosCount(personInfoPo);
	}
	/**
	 * 等到所有人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfos2(PersonInfoPo personInfoPo,
			int start, int size) {
		
		return personInfoDao.getPersonInfos2(personInfoPo, start, size);
	}

	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount2(PersonInfoPo personInfoPo) {
		
		return personInfoDao.getPersoninfosCount2(personInfoPo);
	}

	/**
	 * 取得所有角色
	 * 
	 * @return
	 */
	public List<RolePo> getRoles() {
		
		return personInfoDao.getRoles();
	}

	/**
	 * 删除人员 标记删除
	 * 
	 * @param personID
	 */
	public void delPerson(SystemParameterPo systemParameterPo,String personID,LogisticsLogPo logPo) {
		//---------------RTX 数据同步 By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	
		if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
			RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
			if( RtxsvrapiObj.Init()){
		    	int iRet = -1;
				iRet =RtxsvrapiObj.deleteUser(personID);
				if (iRet == 0)
	    		{
	    			System.out.println("RTX--删除用户成功："+ personID);
	    			
	    		}
	    		else 
	    		{
	    			System.out.println("RTX--删除用户失败："+ personID);
	    		}
			}
			RtxsvrapiObj.UnInit();
		}
		//---------------RTX 数据同步  By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 		
//		personInfoDao.delPerson(personID);
		personInfoDao.delPersonInfo(personID);
		personInfoDao.delPersonDepartments(personID);
		personInfoDao.delPersonRoles(personID);

		PersonDiscountPo discountPo = new PersonDiscountPo();
		discountPo.setFpdpersonid(personID);
		personDiscountDao.deletePersonDiscount(discountPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfo(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1) {
		//---------------RTX 数据同步 By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	
		if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
			RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
			if( RtxsvrapiObj.Init()){
		    	int iRet = -1;
		    	String departmentIDs="";
		    	for (PersonDepartmentsPo personDepartmentsPo : personDepartments) 
				{					
					departmentIDs=departmentIDs + "1"+personDepartmentsPo.getDepartmentID() + ";";
				}
		    	iRet =RtxsvrapiObj.addUser(personInfoPo.getId(),departmentIDs,personInfoPo.getPersonName(),personInfoPo.getPassword());
		    	if (iRet==0)
	    		{
		    		System.out.println("RTX--添加用户成功："+personInfoPo.getPersonName());
	    		}
	    		else 
	    		{
	    			System.out.println("RTX--添加用户失败"+personInfoPo.getPersonName());
	    		}
		    	iRet =RtxsvrapiObj.SetUserSimpleInfo(personInfoPo.getId(), personInfoPo.getPersonName(), personInfoPo.getEmail(), ""+(Integer.parseInt(personInfoPo.getSex())-1), personInfoPo.getPhone(), personInfoPo.getPhone(), personInfoPo.getPassword());
		    	if (iRet==0)
	    		{
		    		System.out.println("RTX--设置用户详细信息成功："+personInfoPo.getPersonName());
	    		}
	    		else 
	    		{
	    			System.out.println("RTX--设置用户详细信息失败："+personInfoPo.getPersonName());
	    		}
			}
			RtxsvrapiObj.UnInit();
		}
		//---------------RTX 数据同步  By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 
		
		personInfoDao.insertPersonInfo(personInfoPo);
		
		Iterator<PersonDepartmentsPo> it = personDepartments.iterator();
		while (it.hasNext()) {
			PersonDepartmentsPo personDepartmentsPo = it.next();
			personInfoDao.insertPersonDepartments(personDepartmentsPo);
		}
		
		personInfoPo.setModuleapplicationid("1");		
		personInfoDao.insertPersonRole(personInfoPo);
		
		if(null != roleDiscountPo.getFrddiscount() && !"".equals(roleDiscountPo.getFrddiscount())) {
			personDiscountPo.setFpdpersonid(personInfoPo.getId());
			personDiscountPo.setFpddiscount(roleDiscountPo.getFrddiscount());
			
//			personDiscountMgr.insertPersonDiscount(personDiscountPo,logPo1);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo tempPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1) {
		//---------------RTX 数据同步 By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 	

		if(systemParameterPo.getFsprtx().equals("1")&&systemParameterPo.getFspserverip()!=null&&!systemParameterPo.getFspserverip().equals("")){
			RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();
			if( RtxsvrapiObj.Init()){
		    	int iRet = -1;
		    	String departmentIDs="";
		    	for (PersonDepartmentsPo personDepartmentsPo : personDepartments) 
				{					
					departmentIDs=departmentIDs + "1"+personDepartmentsPo.getDepartmentID() + ";";
				}
		    	iRet =RtxsvrapiObj.SetUserSimpleInfoEx(personInfoPo.getId(),departmentIDs, personInfoPo.getPersonName(), personInfoPo.getEmail(), ""+(Integer.parseInt(personInfoPo.getSex())-1), personInfoPo.getPhone(), personInfoPo.getPhone(), personInfoPo.getPassword());
		    	if (iRet==0)
	    		{
		    		System.out.println("RTX--设置用户详细信息成功："+personInfoPo.getPersonName());
	    		}
	    		else 
	    		{
	    			System.out.println("RTX--设置用户详细信息失败："+personInfoPo.getPersonName());
	    		}
			}
			RtxsvrapiObj.UnInit();
		}
		//---------------RTX 数据同步  By:moyongsheng 2012-11-28 10:40 ------------------------------------------------------------ 		
		
		//插入人员变动  begin
		List<PersonDepartmentsPo> dps;
		dps = personInfoDao.getPersonDepartments(personInfoPo);
		PersonInfoPo person= personInfoDao.getPersonInfoID(personInfoPo);
		PersonnelChangePo personnelChangePo=new PersonnelChangePo();
		StringBuffer contents=new StringBuffer();
		StringBuffer changeTypes=new StringBuffer();
		
		StringBuffer departmentIDs = new StringBuffer();
		StringBuffer departmentNames = new StringBuffer();

		for (PersonDepartmentsPo personDepartmentsPo : dps) 
		{
			
			departmentIDs.append(personDepartmentsPo.getDepartmentID() + ",");
			departmentNames.append(personDepartmentsPo.getDepartmentName() + ",");
		}
		
		if (departmentIDs.length() - 1 > 0) {
			departmentIDs.deleteCharAt(departmentIDs.length() - 1);
		}
		if (departmentNames.length() - 1 > 0) {
			departmentNames.deleteCharAt(departmentNames.length() - 1);
		}
		
		String departmentID = departmentIDs.toString();
		String departmentName = departmentNames.toString();
		

		StringBuffer departmentIDNews = new StringBuffer();
		StringBuffer departmentNameNews = new StringBuffer();

		for (PersonDepartmentsPo personDepartmentsPo : personDepartments) 
		{
			
			departmentIDNews.append(personDepartmentsPo.getDepartmentID() + ",");
			departmentNameNews.append(personDepartmentsPo.getDepartmentName() + ",");
		}
		
		if (departmentIDNews.length() - 1 > 0) {
			departmentIDNews.deleteCharAt(departmentIDNews.length() - 1);
		}
		if (departmentNameNews.length() - 1 > 0) {
			departmentNameNews.deleteCharAt(departmentNameNews.length() - 1);
		}
		
		String departmentIDNew = departmentIDNews.toString();
		String departmentNameNew = departmentNameNews.toString();
		if(!departmentID.equals(departmentIDNew))
		{
			contents.append("部门由"+departmentName+"变动到"+departmentNameNew+",");
			changeTypes.append(1+",");
		}
		if(!person.getIsinvocation().equals(personInfoPo.getIsinvocation()))
		{
			if(person.getIsinvocation().equals("0"))
			{
				contents.append("人员由在职变为离职,");
				changeTypes.append(3+",");
			}else
			{
				contents.append("人员由离职变为在职,");
				changeTypes.append(3+",");
			}			
		}
		if (contents.length() - 1 > 0) {
			contents.deleteCharAt(contents.length() - 1);
		}
		if (changeTypes.length() - 1 > 0) {
			changeTypes.deleteCharAt(changeTypes.length() - 1);
		}
		String content=contents.toString();
		String changeType=changeTypes.toString();
		if(!"".equals(Utility.getName(changeType)))
		{
			personnelChangePo.setMpcpersonid(personInfoPo.getId());
			personnelChangePo.setMpcchangetype(changeType);
			personnelChangePo.setMpccontent(content);
			personnelChangePo.setMpcrecordid(personInfoPo.getUpdatepersonid());
			personnelChangePo.setMpcrecordname(personInfoPo.getUpdatepersonname());
			personInfoDao.insertPersonnelChangePo(personnelChangePo);
						
		}
		//插入人员变动  end
		
		personInfoDao.updatePersonInfo(personInfoPo);

		personInfoDao.deletePersonDepartments(personInfoPo);

		Iterator<PersonDepartmentsPo> it = personDepartments.iterator();
		while (it.hasNext()) {
			PersonDepartmentsPo personDepartmentsPo = it.next();
			personInfoDao.insertPersonDepartments(personDepartmentsPo);
		}
		
		personInfoPo.setModuleapplicationid("1");
		personInfoDao.updatePersonRole(personInfoPo);
				
		if (roleDiscountPo != null){
			if (!Utility.getName(roleDiscountPo.getFrddiscount()).equals("")){
				if((null == tempPo || tempPo.getFpdpersonid() == null || "".equals(Utility.getName(tempPo.getFpdpersonid())))) {
//					personDiscountMgr.insertPersonDiscount(personDiscountPo,logPo1);
				} else {
//					personDiscountMgr.updatePersonDiscount(personDiscountPo, logPo1);
				}
			}else{
//				personDiscountMgr.deletePersonDiscount(personDiscountPo, logPo1);
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfo(PersonInfoPo personInfoPo) {
		
		return personInfoDao.getPersonInfo(personInfoPo);
	}

	/**
	 * 得到指定人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getPersonDepartments(PersonInfoPo personInfoPo) {
		
		return personInfoDao.getPersonDepartments(personInfoPo);
	}

	/**
	 * 人员角色新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonRole(PersonInfoPo personInfoPo) {
		personInfoDao.insertPersonRole(personInfoPo);

		RoleDiscountPo roleDiscountPo = new RoleDiscountPo();
		roleDiscountPo.setFrdroleid(personInfoPo.getRoleid());

		roleDiscountPo = roleDiscountDao.getRoleDiscount(roleDiscountPo);

		PersonDiscountPo discountPo = new PersonDiscountPo();
		discountPo.setFpdpersonid(personInfoPo.getId());
		discountPo.setFpddiscount(roleDiscountPo.getFrddiscount());

		personDiscountDao.deletePersonDiscount(discountPo);
		personDiscountDao.insertPersonDiscount(discountPo);
		//logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 更新角色人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonRole(PersonInfoPo personInfoPo) {
		personInfoDao.updatePersonRole(personInfoPo);

		RoleDiscountPo roleDiscountPo = new RoleDiscountPo();
		roleDiscountPo.setFrdroleid(personInfoPo.getRoleid());

		roleDiscountPo = roleDiscountDao.getRoleDiscount(roleDiscountPo);

		PersonDiscountPo discountPo = new PersonDiscountPo();
		discountPo.setFpdpersonid(personInfoPo.getId());
		discountPo.setFpddiscount(roleDiscountPo.getFrddiscount());

		personDiscountDao.deletePersonDiscount(discountPo);
		personDiscountDao.insertPersonDiscount(discountPo);
	}

	/**
	 * 取所有人员
	 * 
	 * @return
	 */
	public List<PersonInfoPo> getPersonList(String selResult) {
		return personInfoDao.getPersonList(selResult);
	}
	

	/**
	 * 取所有制造商
	 * 
	 * @return
	 */
	public List<SupplierPo> getSupplierList(String selResult){
		return personInfoDao.getSupplierList(selResult);
	}
	
	/**
	 * 更新启用状态
	 * @param personInfoPo
	 */
	public void isInvocationUpdate(PersonInfoPo personInfoPo,LogisticsLogPo logPo)
	{	
		//插入人员变动  begin
		
		PersonnelChangePo personnelChangePo=new PersonnelChangePo();
		StringBuffer contents=new StringBuffer();
		StringBuffer changeTypes=new StringBuffer();
		
		
		if("0".equals(personInfoPo.getIsinvocation()))
		{
			contents.append("人员由在职变为离职");
			changeTypes.append("3");
		}else
		{
			contents.append("人员由离职变为在职");
			changeTypes.append("3");
		}			
				
		String content=contents.toString();
		String changeType=changeTypes.toString();
		if(!changeType.isEmpty())
		{			
			personnelChangePo.setMpcpersonid(personInfoPo.getId());
			personnelChangePo.setMpcchangetype(changeType);
			personnelChangePo.setMpccontent(content);
			personnelChangePo.setMpcrecordid(personInfoPo.getUpdatepersonid());
			personnelChangePo.setMpcrecordname(personInfoPo.getUpdatepersonname());
			
			personInfoDao.insertPersonnelChangePo(personnelChangePo);
						
		}
		//插入人员变动  end
		
		
		personInfoDao.isInvocationUpdate(personInfoPo);
		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
	/**
	 * 不合格品取责任人
	 */
	public List<PersonInfoPo> getResponsibility(String departmentid) {
		return personInfoDao.getResponsibility(departmentid);
	}

	/**
	 * 导出人员编号
	 * 
	 * @param personInfoPo
	 */
	public InputStream bulidPersonInfoExcel(PersonInfoPo personInfoPo) throws Exception {
		
		try{
			
			HSSFWorkbook workbook = new HSSFWorkbook();	
			// 在Excel工作簿中建一工作表		
			HSSFSheet personInfoSheet = workbook.createSheet("personInfo");
			// 设置列宽
			personInfoSheet.setColumnWidth(0, 4000);
			personInfoSheet.setColumnWidth(1, 4000);
			personInfoSheet.setColumnWidth(2, 4000);
			personInfoSheet.setColumnWidth(3, 4000);
			personInfoSheet.setColumnWidth(4, 4000);
			
			HSSFFont headfont = workbook.createFont();
			headfont.setFontName("黑体");
			headfont.setFontHeightInPoints((short) 12);// 字体大小
			headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
			// 列头的样式
			HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
			columnHeadStyle.setWrapText(true);	// 指定单元格自动换行
			columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
			columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
			columnHeadStyle.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
			columnHeadStyle.setBorderLeft((short) 1);// 边框的大小
			columnHeadStyle.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
			columnHeadStyle.setBorderRight((short) 1);// 边框的大小
			columnHeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
			columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
			// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
			columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			columnHeadStyle.setFont(headfont);

			// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
			columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setFontHeightInPoints((short) 10);
			// 普通单元格样式
			HSSFCellStyle style = workbook.createCellStyle();
			style.setWrapText(true);	// 指定单元格自动换行
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
			style.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
			style.setBorderLeft((short) 1);// 边框的大小
			style.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
			style.setBorderRight((short) 1);// 边框的大小
			// style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
			style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); // 设置单元格的边框为粗体
			style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
			style.setFont(font);

			// 创建行 表头
			HSSFRow row = personInfoSheet.createRow((short) 0);
			HSSFCell headerCell = null;
			row.setHeightInPoints(20);

			headerCell = row.createCell(0);
			headerCell.setCellValue("员工工号");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(1);
			headerCell.setCellValue("员工姓名");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(2);
			headerCell.setCellValue("所属部门");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(3);
			headerCell.setCellValue("角色名称");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(4);
			headerCell.setCellValue("是否在岗");
			headerCell.setCellStyle(columnHeadStyle);
			
			List<PersonInfoPo> personInfosList = personInfoDao.exportPersonInfo(personInfoPo);

			for (PersonInfoPo po : personInfosList) {
				personDepartments = personInfoDao.getPersonDepartments(po);

				StringBuffer departmentIDs = new StringBuffer();
				StringBuffer departmentNames = new StringBuffer();

				for (PersonDepartmentsPo personDepartmentsPo : personDepartments) {
					
					departmentIDs.append(personDepartmentsPo.getDepartmentID() + ",");
					departmentNames.append(personDepartmentsPo.getDepartmentName() + ",");
				}
				
				if (departmentIDs.length() - 1 > 0) {
					departmentIDs.deleteCharAt(departmentIDs.length() - 1);
				}
				if (departmentNames.length() - 1 > 0) {
					departmentNames.deleteCharAt(departmentNames.length() - 1);
				}
				
				String departmentID = departmentIDs.toString();
				String departmentName = departmentNames.toString();
				
				po.setDepartmentID(departmentID);
				po.setBdpdepartmentname(departmentName);
			}
			
			Iterator<PersonInfoPo> iterator = (Iterator<PersonInfoPo>) personInfosList.iterator();
			int i = 1;
			
			while (iterator.hasNext()) {
				PersonInfoPo po = (PersonInfoPo) iterator.next();

				HSSFRow rows = personInfoSheet.createRow(i++);
				rows.setHeightInPoints(20);

				headerCell = rows.createCell(0);
				headerCell.setCellValue(po.getId());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(1);
				headerCell.setCellValue(po.getPersonName());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(2);
				headerCell.setCellValue(po.getBdpdepartmentname());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(3);
				headerCell.setCellValue(po.getRolename());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(4);
				headerCell.setCellValue(po.getIsinvocation().equals("0") ? "是" : "否");
				headerCell.setCellStyle(style);
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			
			return new ByteArrayInputStream(baos.toByteArray());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 通过moduleid查出具有相关权限的用户
	 * @param moduleid
	 * @return
	 */
	public List<PersonInfoPo> getModulePersoninfoPoList(String moduleid,String departmentID){
		return personInfoDao.getModulePersoninfoPoList(moduleid,departmentID);
	}
	
	/**
	 * 通过工作类型查出用户
	 * @param jobTypeID
	 * @return
	 */	
	public List<PersonInfoPo> getPersoninfoPoListByJobType(String jobTypeID,String departmentID,SystemParameterPo systemParameterPo){
		List<PersonInfoPo> personInfoPos = personInfoDao.getPersoninfoPoListByJobType(jobTypeID,departmentID);
		
		if("1".equals(systemParameterPo.getFspisusegoodslevel()) && "1".equals(jobTypeID)){
			for(int i=0; i<personInfoPos.size(); i++){
				PersonDiscountDetailsPo dpo = new PersonDiscountDetailsPo();
				dpo.setFpddpersonid(personInfoPos.get(i).getId());
				
				List<PersonDiscountDetailsPo> personDiscountDetailsPos = personDiscountMgr.selectPersonDiscountDetail(dpo);
				
				personInfoPos.get(i).setPersonDiscountDetailsPos(personDiscountDetailsPos);
			}
		}
		
		return personInfoPos;
	}
	
	
	/**
	 * 卡号去重insert
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoName(PersonInfoPo po){
		return personInfoDao.getPersonInfoPoName(po);
	}
	
	/**
	 * 卡号去重update
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoNameUpdate(PersonInfoPo po){
		return personInfoDao.getPersonInfoPoNameUpdate(po);
	}
	
	/**
	 * 是否已经使用
	 * @param po
	 * @return
	 */
	public int getPersonInfoPoNameSelect(String id){
		return personInfoDao.getPersonInfoPoNameSelect(id);
	}
	
	
	/**
	 * 获取员工职务类型List
	 * @return List<PersonJobTypePo>
	 */
	public List<PersonJobTypePo> getPersonJobTypeList(){
		return personInfoDao.getPersonJobTypeList();
	}
	
	/**
	 * 取得角色信息（按公司类型）
	 * 
	 * @return
	 */
	public List<RolePo> getRolesByCompanyType(RolePo po){
		return personInfoDao.getRolesByCompanyType(po);
	}
	
	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfoSupplier(PersonInfoPo personInfoPo){
		return personInfoDao.getPersonInfoSupplier(personInfoPo);
	}
	
	/**
	 * 制造商人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfoSupplier(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1) {
		personInfoDao.insertPersonInfoSupplier(personInfoPo);
		
		personInfoDao.insertPersonDepartments(personDepartments.get(0));
		
		personInfoPo.setModuleapplicationid("1");		
		personInfoDao.insertPersonRole(personInfoPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfoSupplier(SystemParameterPo systemParameterPo,PersonInfoPo personInfoPo,List<PersonDepartmentsPo> personDepartments,RoleDiscountPo roleDiscountPo,PersonDiscountPo tempPo,PersonDiscountPo personDiscountPo,LogisticsLogPo logPo,LogisticsLogPo logPo1) {
		//插入人员变动  begin
		List<PersonDepartmentsPo> dps;
		dps = personInfoDao.getPersonDepartments(personInfoPo);
		PersonInfoPo person= personInfoDao.getPersonInfoID(personInfoPo);
		PersonnelChangePo personnelChangePo=new PersonnelChangePo();
		StringBuffer contents=new StringBuffer();
		StringBuffer changeTypes=new StringBuffer();
		
		StringBuffer departmentIDs = new StringBuffer();
		StringBuffer departmentNames = new StringBuffer();

		for (PersonDepartmentsPo personDepartmentsPo : dps) 
		{
			
			departmentIDs.append(personDepartmentsPo.getDepartmentID() + ",");
			departmentNames.append(personDepartmentsPo.getDepartmentName() + ",");
		}
		
		if (departmentIDs.length() - 1 > 0) {
			departmentIDs.deleteCharAt(departmentIDs.length() - 1);
		}
		if (departmentNames.length() - 1 > 0) {
			departmentNames.deleteCharAt(departmentNames.length() - 1);
		}
		
		String departmentID = departmentIDs.toString();
		String departmentName = departmentNames.toString();
		

		StringBuffer departmentIDNews = new StringBuffer();
		StringBuffer departmentNameNews = new StringBuffer();

		for (PersonDepartmentsPo personDepartmentsPo : personDepartments) 
		{
			
			departmentIDNews.append(personDepartmentsPo.getDepartmentID() + ",");
			departmentNameNews.append(personDepartmentsPo.getDepartmentName() + ",");
		}
		
		if (departmentIDNews.length() - 1 > 0) {
			departmentIDNews.deleteCharAt(departmentIDNews.length() - 1);
		}
		if (departmentNameNews.length() - 1 > 0) {
			departmentNameNews.deleteCharAt(departmentNameNews.length() - 1);
		}
		
		String departmentIDNew = departmentIDNews.toString();
		String departmentNameNew = departmentNameNews.toString();
		if(!departmentID.equals(departmentIDNew))
		{
			contents.append("部门由"+departmentName+"变动到"+departmentNameNew+",");
			changeTypes.append(1+",");
		}
		if (contents.length() - 1 > 0) {
			contents.deleteCharAt(contents.length() - 1);
		}
		if (changeTypes.length() - 1 > 0) {
			changeTypes.deleteCharAt(changeTypes.length() - 1);
		}
		String content=contents.toString();
		String changeType=changeTypes.toString();
		if(!"".equals(Utility.getName(changeType)))
		{
			personnelChangePo.setMpcpersonid(personInfoPo.getId());
			personnelChangePo.setMpcchangetype(changeType);
			personnelChangePo.setMpccontent(content);
			personnelChangePo.setMpcrecordid(personInfoPo.getUpdatepersonid());
			personnelChangePo.setMpcrecordname(personInfoPo.getUpdatepersonname());
			personInfoDao.insertPersonnelChangePo(personnelChangePo);
						
		}
		//插入人员变动  end
		
		personInfoDao.updatePersonInfoSupplier(personInfoPo);

		personInfoDao.deletePersonDepartments(personInfoPo);

		Iterator<PersonDepartmentsPo> it = personDepartments.iterator();
		while (it.hasNext()) {
			PersonDepartmentsPo personDepartmentsPo = it.next();
			personInfoDao.insertPersonDepartments(personDepartmentsPo);
		}
		
		personInfoPo.setModuleapplicationid("1");
		personInfoDao.updatePersonRole(personInfoPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
}
