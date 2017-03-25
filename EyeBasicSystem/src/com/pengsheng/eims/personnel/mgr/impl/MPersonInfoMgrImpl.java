package com.pengsheng.eims.personnel.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.personnel.dao.MPersonInfoDao;
import com.pengsheng.eims.personnel.mgr.MPersonInfoMgr;
import com.pengsheng.eims.personnel.persistence.EmergencyContactPo;
import com.pengsheng.eims.personnel.persistence.PersonEducationPo;
import com.pengsheng.eims.personnel.persistence.PersonFamilyPo;
import com.pengsheng.eims.personnel.persistence.PersonInfoPo;
import com.pengsheng.eims.personnel.persistence.PersonWorkPo;
import com.pengsheng.eims.personnel.persistence.PersonnelChangePo;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.system.dao.PersonDiscountDao;
import com.pengsheng.eims.system.dao.RoleDiscountDao;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class MPersonInfoMgrImpl implements MPersonInfoMgr 
{
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	private MPersonInfoDao mpersonInfoDao;

	private RoleDiscountDao roleDiscountDao;

	private PersonDiscountDao personDiscountDao;

	private List<PersonDepartmentsPo> personDepartments;

	

	public MPersonInfoDao getMpersonInfoDao() {
		return mpersonInfoDao;
	}
	public void setMpersonInfoDao(MPersonInfoDao mpersonInfoDao) {
		this.mpersonInfoDao = mpersonInfoDao;
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
		
		return mpersonInfoDao.getPersonInfos(personInfoPo, start, size);
	}

	/**
	 * 得到所有人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersoninfosCount(PersonInfoPo personInfoPo) {
		
		return mpersonInfoDao.getPersoninfosCount(personInfoPo);
	}
	
	/**
	 * 查询所有未排班人员(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonInfoPo> getPersonsByScheduingMonth(PersonInfoPo personInfoPo,SchedulingMonthPo schedulingMonthPo,int start, int size)
	{
		return mpersonInfoDao.getPersonsByScheduingMonth(personInfoPo,schedulingMonthPo,start,size);
	}
	/**
	 * 未排班选择人员总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonsByScheduingMonthCount(PersonInfoPo personInfoPo,SchedulingMonthPo schedulingMonthPo)
	{
		return mpersonInfoDao.getPersonsByScheduingMonthCount(personInfoPo,schedulingMonthPo);
	}
	/**
	 * 等到所有人事变动(查询条件)
	 * 
	 * @param personInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<PersonnelChangePo> getPersonnelChanges(PersonnelChangePo personnelChangePo  ,int start, int size)
	{
		
		return mpersonInfoDao.getPersonnelChanges(personnelChangePo,start,size);
	}

	/**
	 * 得到所有人事变动总数
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonnelChangeCount(PersonnelChangePo personnelChangePo)  
	{
		
		return mpersonInfoDao.getPersonnelChangeCount(personnelChangePo);
	}
	
	/**
	 * 得到人事变动
	 * @return
	 */
	public PersonnelChangePo selectPersonnelChangePo(String id)
	{
		return mpersonInfoDao.selectPersonnelChangePo(id);
	}

	/**
	 * 取得所有角色
	 * 
	 * @return
	 */
	public List<RolePo> getRoles() {
		
		return mpersonInfoDao.getRoles();
	}

	/**
	 * 删除人员 标记删除
	 * 
	 * @param personID
	 */
	public void delPerson(String personID,LogisticsLogPo logPo) {
		
		mpersonInfoDao.delPerson(personID);

		PersonDiscountPo discountPo = new PersonDiscountPo();
		discountPo.setFpdpersonid(personID);
		personDiscountDao.deletePersonDiscount(discountPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

		
	// 自己封装的一个把源文件对象复制成目标文件对象
	private void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src));
			out = new BufferedOutputStream(new FileOutputStream(dst));
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 人员新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonInfo(PersonInfoPo personInfoPo,File[] upload,List<String> mm,String ph, String filePath, String[] fFullName,List<PersonDepartmentsPo> personDepartments,List<PersonWorkPo> personWorkPos,List<PersonFamilyPo> personFamilyPos,List<PersonEducationPo> personEducationPos,EmergencyContactPo emergencyContactPo,LogisticsLogPo logPo) 
	{
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String temp= numHeadFormat.format(new Date());
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) 
		{

			File fUpload = upload[i];	

			File dist = new File(filePath +"\\" + personInfoPo.getId());
			File ff=new File(filePath);
			if (!ff.exists()) 
			{
				ff.mkdir();
			}
			
			if (!dist.exists()) 
			{
				dist.mkdir();
			}
			String fileName = fFullName[i].replaceFirst("\\..*$", "");
			String fileEnd = fFullName[i].replace(fileName, "");
			String fileFullName = personInfoPo.getId() + "\\" + personInfoPo.getId()+temp+i+""+fileEnd;
			File dstFile = new File(filePath +"\\"  +  fileFullName);

			copy(fUpload, dstFile);
			
			for(int j=0;j<mm.size();j++)
			{
				String aa=mm.get(j);
				if(i==j)
				{

					if(aa.equals("A"))
					{
						personInfoPo.setPicturepath(ph+"\\"+fileFullName);
					}
					if(aa.equals("B"))
					{
						personInfoPo.setPositivecardpath(ph+"\\"+fileFullName);
					}
					if(aa.equals("C"))
					{
						personInfoPo.setBackcardpath(ph+"\\"+fileFullName);
					}
				}
			}
		}
		PostPo postPo=mpersonInfoDao.selectPostPo(personInfoPo.getPostid());
		personInfoPo.setPostname(postPo.getMptcontent());
		mpersonInfoDao.insertPersonInfo(personInfoPo);
		
		Iterator<PersonDepartmentsPo> it = personDepartments.iterator();
		while (it.hasNext()) 
		{
			PersonDepartmentsPo personDepartmentsPo = it.next();
			mpersonInfoDao.insertPersonDepartments(personDepartmentsPo);
		}
		
		
		//插入员工工作
		if(null!=personWorkPos && personWorkPos.size()>0)
		{
			Iterator<PersonWorkPo> pw = personWorkPos.iterator();
			while (pw.hasNext()) 
			{
				PersonWorkPo personWorkPo = pw.next();
				personWorkPo.setMpwpersonid(personInfoPo.getId());
				mpersonInfoDao.insertPersonWorkPo(personWorkPo);
			}
		}
		//插入家庭成员
		if(null!=personFamilyPos && personFamilyPos.size()>0)
		{
			Iterator<PersonFamilyPo> pf = personFamilyPos.iterator();
			while (pf.hasNext()) 
			{
				PersonFamilyPo personFamilyPo = pf.next();
				personFamilyPo.setMpfpersonid(personInfoPo.getId());
				mpersonInfoDao.insertPersonFamilyPo(personFamilyPo);
			}
		}
		//插入员工教育培训
		if(null!=personEducationPos && personEducationPos.size()>0)
		{
			Iterator<PersonEducationPo> pe = personEducationPos.iterator();
			while (pe.hasNext()) 
			{
				PersonEducationPo personEducationPo=pe.next();
				personEducationPo.setMpepersonid(personInfoPo.getId());
				mpersonInfoDao.insertPersonEducationPo(personEducationPo);
			}
		}
		//紧急情况联系
		if(null!=emergencyContactPo)
		{
			emergencyContactPo.setMecpersonid(personInfoPo.getId());
			mpersonInfoDao.insertEmergencyContactPo(emergencyContactPo);
		}
		personInfoPo.setModuleapplicationid("1");		
		mpersonInfoDao.insertPersonRole(personInfoPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	
	public  boolean delAllFile(String path)
	{    
		
		boolean flag = false;  
		File file = new File(path);  
		
		if (!file.exists()) 
		{
			return flag;
		}else
		{
			file.delete();
			flag=true;
		}
		
		return flag; 
	}



	/**
	 * 更新人员
	 * 
	 * @param personInfoPo
	 */
	public void updatePersonInfo(PersonInfoPo personInfoPo,File[] upload,List<String> mm,String ph, String filePath, String[] fFullName,List<PersonDepartmentsPo> personDepartments,List<PersonWorkPo> personWorkPos,List<PersonFamilyPo> personFamilyPos,List<PersonEducationPo> personEducationPos,EmergencyContactPo emergencyContactPo,LogisticsLogPo logPo)
	{

		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String temp= numHeadFormat.format(new Date());
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) 
		{

			File fUpload = upload[i];	
			File ff=new File(filePath);
			File dist = new File(filePath +"\\" + personInfoPo.getId());
			
			if (!ff.exists()) 
			{
				ff.mkdir();
			}
			
			if (!dist.exists()) 
			{
				dist.mkdir();
			}
			
			String fileName = fFullName[i].replaceFirst("\\..*$", "");
			String fileEnd = fFullName[i].replace(fileName, "");
			String fileFullName = personInfoPo.getId() + "\\" + personInfoPo.getId()+temp+i+""+fileEnd;

			File dstFile = new File(filePath +"\\"  +  fileFullName);

			copy(fUpload, dstFile);
			
			for(int j=0;j<mm.size();j++)
			{
				String aa=mm.get(j);
				if(i==j)
				{
					if(aa.equals("A"))
					{							
						if(!personInfoPo.getPicturepath().equals(" "))
						{
							this.delAllFile(filePath+personInfoPo.getPicturepath().substring(ph.length()));												
						}
						personInfoPo.setPicturepath(ph+"\\"+fileFullName);
					}
					if(aa.equals("B"))
					{
						if(!personInfoPo.getPositivecardpath().equals(" "))
						{
							this.delAllFile(filePath+personInfoPo.getPositivecardpath().substring(ph.length()));
							
						}
						personInfoPo.setPositivecardpath(ph+"\\"+fileFullName);
					}
					if(aa.equals("C"))
					{	
						if(!personInfoPo.getBackcardpath().equals(" "))
						{
							this.delAllFile(filePath+personInfoPo.getBackcardpath().substring(ph.length()));
							
						}
						personInfoPo.setBackcardpath(ph+"\\"+fileFullName);
					}
				}
			}
		}
		
		
		PostPo postPo=mpersonInfoDao.selectPostPo(personInfoPo.getPostid());
		personInfoPo.setPostname(postPo.getMptcontent());

		
		
		//插入人员变动  begin
		List<PersonDepartmentsPo> dps;
		dps = mpersonInfoDao.getPersonDepartments(personInfoPo);
		PersonInfoPo person= mpersonInfoDao.getPersonInfo(personInfoPo);
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
		if(null!=person.getPostid())
		{
			if(!person.getPostid().equals(personInfoPo.getPostid()))
			{
				contents.append("职务由"+person.getPostname()+"变动到"+personInfoPo.getPostname()+",");
				changeTypes.append(2+",");
			}
		}else
		{
			contents.append("职务由空变动到"+personInfoPo.getPostname()+",");
			changeTypes.append(2+",");
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
		if(!changeType.isEmpty())
		{
			personnelChangePo.setMpcpersonid(personInfoPo.getId());
			personnelChangePo.setMpcchangetype(changeType);
			personnelChangePo.setMpccontent(content);
			personnelChangePo.setMpcrecordid(personInfoPo.getUpdatepersonid());
			personnelChangePo.setMpcrecordname(personInfoPo.getUpdatepersonname());
			mpersonInfoDao.insertPersonnelChangePo(personnelChangePo);
						
		}
		//插入人员变动  end
		
		
		mpersonInfoDao.updatePersonInfo(personInfoPo);
		
		
		mpersonInfoDao.delEmergencyContactPo(personInfoPo);
		mpersonInfoDao.delPersonEducationPo(personInfoPo);
		mpersonInfoDao.delPersonFamilyPo(personInfoPo);
		mpersonInfoDao.delPersonWorkPo(personInfoPo);
		//插入员工工作
		if(null!=personWorkPos && personWorkPos.size()>0)
		{
			Iterator<PersonWorkPo> pw = personWorkPos.iterator();
			while (pw.hasNext()) 
			{
				PersonWorkPo personWorkPo = pw.next();
				personWorkPo.setMpwpersonid(personInfoPo.getId());
				mpersonInfoDao.insertPersonWorkPo(personWorkPo);
			}
		}
		//插入家庭成员
		if(null!=personFamilyPos && personFamilyPos.size()>0)
		{
			Iterator<PersonFamilyPo> pf = personFamilyPos.iterator();
			while (pf.hasNext()) 
			{
				PersonFamilyPo personFamilyPo = pf.next();
				personFamilyPo.setMpfpersonid(personInfoPo.getId());
				mpersonInfoDao.insertPersonFamilyPo(personFamilyPo);
			}
		}
		//插入员工教育培训
		if(null!=personEducationPos && personEducationPos.size()>0)
		{
			Iterator<PersonEducationPo> pe = personEducationPos.iterator();
			while (pe.hasNext()) 
			{
				PersonEducationPo personEducationPo=pe.next();
				personEducationPo.setMpepersonid(personInfoPo.getId());
				mpersonInfoDao.insertPersonEducationPo(personEducationPo);
			}
		}
		//紧急情况联系
		if(null!=emergencyContactPo)
		{
			emergencyContactPo.setMecpersonid(personInfoPo.getId());
			mpersonInfoDao.insertEmergencyContactPo(emergencyContactPo);
		}
		

		mpersonInfoDao.deletePersonDepartments(personInfoPo);

		Iterator<PersonDepartmentsPo> it = personDepartments.iterator();
		while (it.hasNext()) {
			PersonDepartmentsPo personDepartmentsPo = it.next();
			mpersonInfoDao.insertPersonDepartments(personDepartmentsPo);
		}
		
		personInfoPo.setModuleapplicationid("1");
		mpersonInfoDao.updatePersonRole(personInfoPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 得到指定人员信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public PersonInfoPo getPersonInfo(PersonInfoPo personInfoPo) {
		
		return mpersonInfoDao.getPersonInfo(personInfoPo);
	}
	
	/**
	 * 判断人员工号是否重复
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public int getPersonRepeat(String id ) 
	{
		return mpersonInfoDao.getPersonRepeat(id);
	}
	/**
	 * 教育培训背景查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonEducationPo> selectPersonEducationPo(String id) 
	{
		return mpersonInfoDao.selectPersonEducationPo( id) ;
	}
	
	/**
	 * 工作背景查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonWorkPo> selectPersonWorkPo(String id) 
	{
		return mpersonInfoDao.selectPersonWorkPo(id);
	}
	
	/**
	 * 家庭成员查询
	 * 
	 * @param personDepartmentsPo
	 */
	public List<PersonFamilyPo> selectPersonFamilyPo(String id) 
	{
		return mpersonInfoDao.selectPersonFamilyPo(id);
	}
	
	/**
	 * 遇紧急情况通知人查询
	 * 
	 * @param personDepartmentsPo
	 */
	public EmergencyContactPo selectEmergencyContactPo(String id) 
	{
		return mpersonInfoDao.selectEmergencyContactPo(id);
	}
	
	/**
	 * 得到指定人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getPersonDepartments(PersonInfoPo personInfoPo) {
		
		return mpersonInfoDao.getPersonDepartments(personInfoPo);
	}
	/**
	 * 得到人员部门信息
	 * 
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonDepartmentsPo> getDepartments(String  id) 
	{
		return mpersonInfoDao.getDepartments(id);
	}

	/**
	 * 人员角色新增
	 * 
	 * @param personInfoPo
	 */
	public void insertPersonRole(PersonInfoPo personInfoPo) {
		mpersonInfoDao.insertPersonRole(personInfoPo);

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
		mpersonInfoDao.updatePersonRole(personInfoPo);

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
		return mpersonInfoDao.getPersonList(selResult);
	}
	

	/**
	 * 取所有制造商
	 * 
	 * @return
	 */
	public List<SupplierPo> getSupplierList(String selResult){
		return mpersonInfoDao.getSupplierList(selResult);
	}
	
	/**
	 * 更新启用状态
	 * @param personInfoPo
	 */
	public void isInvocationUpdate(PersonInfoPo personInfoPo,LogisticsLogPo logPo){		
		mpersonInfoDao.isInvocationUpdate(personInfoPo);
		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
	/**
	 * 不合格品取责任人
	 */
	public List<PersonInfoPo> getResponsibility(String departmentid) {
		return mpersonInfoDao.getResponsibility(departmentid);
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
			HSSFSheet personInfoSheet = workbook.createSheet("员工信息");
			// 设置列宽
			personInfoSheet.setColumnWidth(0, 3000);
			personInfoSheet.setColumnWidth(1, 3000);
			personInfoSheet.setColumnWidth(2, 2000);
			personInfoSheet.setColumnWidth(3, 2000);
			personInfoSheet.setColumnWidth(4, 3000);
			
			personInfoSheet.setColumnWidth(5, 3000);
			personInfoSheet.setColumnWidth(6, 4000);
			personInfoSheet.setColumnWidth(7, 6000);
			personInfoSheet.setColumnWidth(8, 3000);
			personInfoSheet.setColumnWidth(9, 6000);
			
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
			headerCell.setCellValue("ID号");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(1);
			headerCell.setCellValue("姓名");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(2);
			headerCell.setCellValue("性别");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(3);
			headerCell.setCellValue("年龄");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(4);
			headerCell.setCellValue("学历");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(5);
			headerCell.setCellValue("工龄");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(6);
			headerCell.setCellValue("角色");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(7);
			headerCell.setCellValue("部门");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(8);
			headerCell.setCellValue("职工类别");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(9);
			headerCell.setCellValue("备注");
			headerCell.setCellStyle(columnHeadStyle);
	
			List<PersonInfoPo> personInfosList = mpersonInfoDao.exportPersonInfo(personInfoPo);
			
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
				headerCell.setCellValue(po.getSex());
				headerCell.setCellStyle(style);
				
				headerCell = rows.createCell(3);
				headerCell.setCellValue(po.getBegage());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(4);
				headerCell.setCellValue(po.getMaxschoollevelname());
				headerCell.setCellStyle(style);
				
				String tmpString = "";
				if(!po.getEntrytime().equals("")){
					int gongling =  this.getGongLing(po.getEntrytime());
					int nian = gongling/12;
					int yue = gongling%12;
					
					if(nian>0){
						tmpString = nian+" 年";
					}
					if(yue>0){
						tmpString = tmpString+" "+ yue +" 月";
					}
					if(tmpString.equals("")){
						tmpString = "入职不满1个月";
					}
				}				
				
				headerCell = rows.createCell(5);
				headerCell.setCellValue(tmpString);
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(6);
				headerCell.setCellValue(po.getRolename());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(7);
				headerCell.setCellValue(po.getBdpdepartmentname());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(8);
				headerCell.setCellValue(po.getZhigongtype());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(9);
				headerCell.setCellValue(po.getRemark());
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
		return mpersonInfoDao.getModulePersoninfoPoList(moduleid,departmentID);
	}
	
	private int getGongLing(String dateString){
		//////--------当前时间取得年\月----------------	
		Calendar start = Calendar.getInstance();
	    int startYear = start.get(Calendar.YEAR);
	    int startMonth = start.get(Calendar.MONTH) + 1;
	    //////--------当前时间取得年\月----------------	
	    
		Calendar end = Calendar.getInstance();//获得一个日历的实例   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
        Date date = null;   
        try{   
            date = sdf.parse(dateString);//初始日期   
        }catch(Exception e){  

        }   
        end.setTime(date);
	    int endMonth = end.get(Calendar.MONTH) + 1;
	    int endYear = end.get(Calendar.YEAR);
	    //////--------当前时间取得年\月----------------	
//	    System.out.println("startYear=="+startYear);
//	    System.out.println("startMonth=="+startMonth);
//	    System.out.println("endYear=="+endYear);
//	    System.out.println("endMonth=="+endMonth);
		return (startYear-endYear)*12+startMonth-endMonth;
	}

	public List<PersonInfoPo> getGonglingChangePersonInfos(int start, int size) {
		return mpersonInfoDao.getGonglingChangePersonInfos(start, size);
	}

	public int getGonglingChangePersoninfosCount() {
		// TODO Auto-generated method stub
		return mpersonInfoDao.getGonglingChangePersoninfosCount();
	}
}
