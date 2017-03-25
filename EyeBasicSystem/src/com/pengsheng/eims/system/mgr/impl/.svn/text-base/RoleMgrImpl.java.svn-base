package com.pengsheng.eims.system.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.system.dao.RoleDao;
import com.pengsheng.eims.system.dao.RolePermissionDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.RoleMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.system.persistence.RolePermissionPo;
import com.pengsheng.eims.system.persistence.RoleTemplatePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class RoleMgrImpl implements RoleMgr {
	
	private LogisticsLogDao logisticsLogDao;
    private SystemParameterDao systemParameterDao;
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private RoleDao roleDao;
	private RolePermissionDao rolePermissionDao;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
    private String fileName;
    
    

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RolePermissionDao getRolePermissionDao() {
		return rolePermissionDao;
	}

	public void setRolePermissionDao(RolePermissionDao rolePermissionDao) {
		this.rolePermissionDao = rolePermissionDao;
	}

	public int getPMpersonCount(String pmName, String applicationID) {
		return roleDao.getPMpersonCount(pmName, applicationID);
	}

	public void setSysRoleDao(RoleDao sysRoleDao) {
		this.roleDao = sysRoleDao;
	}

	public void deleteSysRole(RolePo whereSysRolePo,LogisticsLogPo logPo) {
		
		roleDao.deleteSysRole(whereSysRolePo);
		
		RolePermissionPo whereSysRolePermissionPo = new RolePermissionPo();
		whereSysRolePermissionPo.setRoleID(whereSysRolePo.getRoleid());
		whereSysRolePermissionPo.setApplicationID(whereSysRolePo.getModuleapplicationid());

		roleDao.deleteSysRolePermissionByWhere(whereSysRolePermissionPo);
		
		roleDao.deleteRolePersonRelationShip(whereSysRolePo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void deleteSysRolePermissionByWhere(
			RolePermissionPo whereSysRolePermissionPo) {
		// TODO Auto-generated method stub
		roleDao.deleteSysRolePermissionByWhere(whereSysRolePermissionPo);
	}

	public int getPersonForRole(String roleID, String moduleApplicationID) {
		// TODO Auto-generated method stub
		return roleDao.getPersonForRole(roleID, moduleApplicationID);
	}

	public int getPermissionForRole(String roleID, String moduleApplicationID) {
		return roleDao.getPermissionForRole(roleID, moduleApplicationID);
	}

	public RolePo getSysRoleByWhere(RolePo sysRolePo) {
		// TODO Auto-generated method stub
		return roleDao.getSysRoleByWhere(sysRolePo);
	}

	public List<RolePo> getSysRoleList(RolePo po) {
		// TODO Auto-generated method stub
		return roleDao.getSysRoleList(po);
	}

	public List getSysRolePermissionListByWhere(
			RolePermissionPo whereSysRolePermissionPo) {
		return rolePermissionDao
				.getSysRolePermissionListByWhere(whereSysRolePermissionPo);
	}

	public List<RolePermissionPo> getSysPermissionListByWhere(
			PermissionPo sysPermissionPo) {
		return rolePermissionDao.getSysPermissionListByWhere(sysPermissionPo);
	}

	public void insertSysRole(RolePo rolesPo,List<ModulePo> moduleParents,LogisticsLogPo logPo) {
						
		roleDao.insertSysRole(rolesPo);
		
		for (ModulePo moduleParent : moduleParents) {
			if (moduleParent != null) {
				for (ModulePo modulelower : moduleParent.getModuleLowers()) {
					if (modulelower != null) {
						for (RolePermissionPo rolePermission : modulelower.getRolePermissions()) {
							for (PermissionPo permission : rolePermission.getTmpLstPermission()) {
								RolePermissionPo po = new RolePermissionPo();
								po.setRoleID(Utility.getName(rolesPo.getRoleid()));
								po.setApplicationID(Utility.getName(rolesPo.getModuleapplicationid()));
								po.setModuleID(Utility.getName(permission.getModuleID()));
								po.setPageValue(Utility.getName(permission.getPageValue()));
								po.setPageKey(Utility.getName(permission.getPageKey()).equals("1") ? "1" : "0");
								
								roleDao.rolePermissionInsert(po);
								po = null;
							}
						}
					}
				}
			}
		}
				
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void insertSysRolePermissionByWhere(
			RolePermissionPo whereSysRolePermissionPo) {
		// TODO Auto-generated method stub
		roleDao.insertSysRolePermissionByWhere(whereSysRolePermissionPo);
	}

	public int getProjectForRole(String roleID, String moduleApplicationID) {
		return roleDao.getProjectForRole(roleID, moduleApplicationID);
	}

	public void updateSysRole(RolePo whereSysRolePo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		roleDao.updateSysRole(whereSysRolePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void insertSysRolePermission(RolePo rolePo,List<ModulePo> moduleParents,LogisticsLogPo logPo) {

		roleDao.updateRole(rolePo);
		
		RolePermissionPo whereSysRolePermissionPo = new RolePermissionPo();
		whereSysRolePermissionPo.setRoleID(Utility.getName(rolePo.getRoleid()));
		whereSysRolePermissionPo.setApplicationID(rolePo.getModuleapplicationid());
		roleDao.deleteSysRolePermissionByWhere(whereSysRolePermissionPo);
		
		roleDao.insertSysRolePermissions(rolePo.getRoleid(),moduleParents);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void insertInitSysPermission(RolePo rolePo,List<ModulePo> moduleParents,LogisticsLogPo logPo) {

		ModulePo tpo = new ModulePo();
		roleDao.deleteSyStemPermission(tpo);
		roleDao.deleteSyStemModule(tpo);
		
		StringBuffer buffer = new StringBuffer();
		
		for (ModulePo moduleParent : moduleParents) {
			if (moduleParent != null) {
				for (ModulePo modulelower : moduleParent.getModuleLowers()) {
					if (modulelower != null) {
						for (RolePermissionPo rolePermission : modulelower.getRolePermissions()) {
							for (PermissionPo permission : rolePermission.getTmpLstPermission()) {
								
								RolePermissionPo po = new RolePermissionPo();
								po.setModuleID(Utility.getName(permission.getModuleID()));
								po.setPageValue(Utility.getName(permission.getPageValue()));
								
								if (Utility.getName(permission.getPageKey()).equals("1")){
									roleDao.insertSyStemPermission(po);
									
									buffer.append(Utility.getName(po.getModuleID())+",");
								}								
								po = null;
							}
						}
					}
				}			
			}
		}
		
		tpo.setModuleID(buffer.toString());
		roleDao.insertSyStemModule(tpo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/*
	 * 获取角色模板
	 */
	public List<RoleTemplatePo> getRoleTemplate(){
		return roleDao.getRoleTemplate();
	}

	/**
	 * Description :获取角色类型列表
	 * @return :角色类型列表
	 */
	public List<RoleTemplatePo> getRoleTypeList(){
		return roleDao.getRoleTypeList();
	}
	
	/**
	* Description :获取根菜单列表
	* @return :根菜单列表
	*/
	public List<ModulePo> getRootModules(){
		return roleDao.getRootModules();
	}
	
	/**
	* Description :获取所有菜单列表
	* @return :所有菜单列表
	*/
	public List<ModulePo> getAllModules(){
		return roleDao.getAllModules();
	}
	
	/**
	* Description :获取根菜单列表
	* @return :根菜单列表
	*/
	public List<ModulePo> getInitRootModules(){
		return roleDao.getInitRootModules();
	}
	
	/**
	 * Description :得到父节点下所有的子模块
	 * 
	 * @param parentModuleID 父类模块ID
	 * @return 当前父节点下所有的子模块
	 */
	public List<ModulePo> getChildModules(String parentModuleID){
		return roleDao.getChildModules(parentModuleID);
	}
	
	/**
	 * Description :得到父节点下所有的子模块
	 * 
	 * @param parentModuleID 父类模块ID
	 * @return 当前父节点下所有的子模块
	 */
	public List<ModulePo> getInitChildModules(String parentModuleID){
		return roleDao.getInitChildModules(parentModuleID);
	}
	
	/**
	 * Description :获取所有权限
	 * 
	 * @param  String roleID
	 * @return 得到所有权限
	 */
	public List<PermissionPo> getRolePermissionListByRoleID(String roleID){
		return roleDao.getRolePermissionListByRoleID(roleID);
	}
	
	/**
	 * Description :获取当前角色的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前角色的所有权限
	 */
	public List<RolePermissionPo> getRolePermission(RolePo rolesPo){
		return roleDao.getRolePermission(rolesPo); 
	}
	
	/**
	 * Description :获取当前角色的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前角色的所有权限
	 */
	public List<RolePermissionPo> getInitRolePermission(RolePo rolesPo){
		return roleDao.getInitRolePermission(rolesPo); 
	}
	
	/**
	 * Description :获取当前模块的所有权限
	 * 
	 * @param  模块实体类
	 * @return 得到当前模块的所有权限
	 */
	public List<RolePermissionPo> getModulePermission(ModulePo childModulePo){
		return roleDao.getModulePermission(childModulePo); 
	}
	
	
	public InputStream insertExportExcel(SystemParameterPo systemParameterPo,String url, LogisticsLogPo logPo)
			throws Exception {
		setFileName(java.net.URLEncoder.encode("模块权限信息.xls", "UTF-8"));

		InputStream stream = null;

		stream = new FileInputStream(url+"\\qcqxxx.xls");

		FileInputStream excel = (FileInputStream)stream;
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFCellStyle columnHeadStyle = createCellStyle(workbook);  //设置表头				
		HSSFCellStyle style = createCellStyle(workbook,columnHeadStyle); //设置普通单元格
		HSSFSheet moduleSheet = null;
	
		List<ModulePo> moduleList=roleDao.getModuleList();
		
		List<PermissionPo> permissionList=roleDao.getPermissionList();
		
		moduleSheet=workbook.getSheet("SYS_Module");
		int count = 1;
		for(ModulePo modulePo:moduleList){
			HSSFRow rows =moduleSheet.createRow(count++);
			rows.setHeightInPoints(20);
			SetExcelCell(rows, modulePo,style);
		}
		moduleSheet=workbook.getSheet("SYS_Permission");
		int countt = 1;
		for(PermissionPo permissionPo:permissionList){
			HSSFRow rows =moduleSheet.createRow(countt++);
			rows.setHeightInPoints(20);
			SetExcelPermissionCell(rows, permissionPo,style);
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		
		logPo.setsLogContent("模块权限导出完成!");
		logisticsLogDao.insertLog(logPo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}
	/**
	 * 创建sheet: 
	 * @return
	 */
	private HSSFCellStyle createCellStyle(HSSFWorkbook workbook){
		
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
		columnHeadStyle.setTopBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
		columnHeadStyle.setBorderBottom((short) 1);// 边框的大小
		columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
		// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
		columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		columnHeadStyle.setFont(headfont);
  
		return columnHeadStyle;		
	}
	/**
	 * 创建cell样式: 
	 * @return
	 */
	private HSSFCellStyle createCellStyle(HSSFWorkbook workbook,HSSFCellStyle columnHeadStyle){

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
		style.setBorderBottom((short) 1);// 边框的大小
		style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
		style.setFont(font);
  
		return style;		
	}
	private void SetExcelCell(HSSFRow row, ModulePo modulePo,HSSFCellStyle style) {
		HSSFCell c1 = row.createCell(0);
		HSSFCell c2 = row.createCell(1);
		HSSFCell c3 = row.createCell(2);
		HSSFCell c4 = row.createCell(3);
		HSSFCell c5 = row.createCell(4);
		HSSFCell c6 = row.createCell(5);
		HSSFCell c7 = row.createCell(6);
		HSSFCell c8 = row.createCell(7);
		HSSFCell c9 = row.createCell(8);
		HSSFCell c10 = row.createCell(9);
		HSSFCell c11 = row.createCell(10);
		HSSFCell c12 = row.createCell(11);
		HSSFCell c13 = row.createCell(12);
		HSSFCell c14 = row.createCell(13);
		HSSFCell c15 = row.createCell(14);
		HSSFCell c16 = row.createCell(15);

		c1.setCellValue(Utility.getName(modulePo.getModuleid()));
		c2.setCellValue(Utility.getName(modulePo.getModuleapplicationid()));
		c3.setCellValue(Utility.getName(modulePo.getModuleparentid()));
		c4.setCellValue(Utility.getName(modulePo.getModulepagecode()));
		c5.setCellValue(Utility.getName(modulePo.getModulecname()));
		c6.setCellValue(Utility.getName(modulePo.getSmallmodulename()));
		c7.setCellValue(Utility.getName(modulePo.getModuledirectory()));
		c8.setCellValue(Utility.getName(modulePo.getModuleorderlevel()));
		c9.setCellValue(Utility.getName(modulePo.getModuleissystem()));
		c10.setCellValue(Utility.getName(modulePo.getModuleclose()));
		c11.setCellValue(Utility.getName(modulePo.getModuleicon()));
		c12.setCellValue(Utility.getName(modulePo.getIsupdate()));
		c13.setCellValue(Utility.getName(modulePo.getDepartmentType()));
		c14.setCellValue(Utility.getName(modulePo.getModuleDescribe()));
		c15.setCellValue(Utility.getName(modulePo.getModuleHelpHtmlUrl()));
		c16.setCellValue(Utility.getName(modulePo.getModuleHelpMovieUrl()));
		

	}
	private void SetExcelPermissionCell(HSSFRow row, PermissionPo permissionPo,HSSFCellStyle style) {
		HSSFCell c1 = row.createCell(0);
		HSSFCell c2 = row.createCell(1);
		HSSFCell c3 = row.createCell(2);
		HSSFCell c4 = row.createCell(3);
		HSSFCell c5 = row.createCell(4);


		c1.setCellValue(Utility.getName(permissionPo.getId()));
		c2.setCellValue(Utility.getName(permissionPo.getModuleID()));
		c3.setCellValue(Utility.getName(permissionPo.getPageValue()));
		c4.setCellValue(Utility.getName(permissionPo.getPageName()));
		c5.setCellValue(Utility.getName(permissionPo.getModuleApplicationID()));
	}
	
	public void insertRoleCopyInfo(RolePo rolePo,LogisticsLogPo logPo){
		
		roleDao.insertRoleCopyInfo(rolePo); 
		
		logisticsLogDao.insertLog(logPo);
	}
	
}