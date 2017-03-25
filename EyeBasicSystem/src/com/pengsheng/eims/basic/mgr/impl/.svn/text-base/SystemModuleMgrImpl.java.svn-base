package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.basic.dao.SystemModuleDao;
import com.pengsheng.eims.basic.mgr.SystemModuleMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PermissionPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class SystemModuleMgrImpl implements SystemModuleMgr {
	
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	private SystemModuleDao systemModuleDao;
    public SystemModuleDao getSystemModuleDao() {
		return systemModuleDao;
	}

	public void setSystemModuleDao(SystemModuleDao systemModuleDao) {
		this.systemModuleDao = systemModuleDao;
	}

	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	
	public ModulePo getSystemModuleHelp(ModulePo po) {
		return this.systemModuleDao.getSystemModule(po);
	}

	public ModulePo getSystemModule(ModulePo po) {
		ModulePo result = new ModulePo();
		result = this.systemModuleDao.getSystemModule(po);
		if(!result.getModuleid().equals("")){
			ModulePo tmp = new ModulePo();
			tmp.setModuleid(result.getModuleid());
			result.setModulecname(this.systemModuleDao.getSystemModule(tmp).getModulecname());
		}
		return result;
	}
	
	public void insertSystemModule(ModulePo po,LogisticsLogPo logPo) {
		this.systemModuleDao.insertSystemModule(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void deleteSystemModule(ModulePo po,LogisticsLogPo logPo) {
		this.systemModuleDao.deleteSystemModule(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void disableSystemModule(ModulePo po,LogisticsLogPo logPo) {
		this.systemModuleDao.disableSystemModule(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void ableSystemModule(ModulePo po,LogisticsLogPo logPo) {
		this.systemModuleDao.ableSystemModule(po);
		logisticsLogDao.insertLog(logPo);
	}

	public List<ModulePo> getSystemModuleMaxList() {
		return this.systemModuleDao.getSystemModuleMaxList();
	}

	public List<ModulePo> getSystemModuleMinList(ModulePo po) {
		return this.systemModuleDao.getSystemModuleMinList(po);
	}

	public void updateSystemModule(ModulePo po, LogisticsLogPo logPo) {
		this.systemModuleDao.updateSystemModule(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void insertImportModuleExcel(File[] upload, String filePath,
			String[] fFullName, String[] ContentType, LogisticsLogPo logPo) {
		
		logPo.setsLogContent("文件开始上传!");
		logisticsLogDao.insertLog(logPo);
		

		
		GoodsInfoPo goodsInfoPo=new GoodsInfoPo();
		
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			
			goodsInfoPo.setDocumentUrl(fileFullName);
			
			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);
				logPo.setsLogContent("文件:" + fileFullName + "上传成功!");
			} catch (Exception e) {
				goodsInfoPo.setDocumentUrl("");
				logPo.setsLogContent("文件:" + fileFullName + "上传失败!");
			}
		}
		
		logisticsLogDao.insertLog(logPo);


		File file = new File(filePath + File.separator + goodsInfoPo.getDocumentUrl());
		if (file.exists() && file.isFile()){
			try {
				FileInputStream is = new FileInputStream(file);
				HSSFWorkbook wbs = new HSSFWorkbook(is);
				
				HSSFCellStyle columnHeadStyle = createCellStyle(wbs);  //设置表头
				HSSFCellStyle styleSum = createCellStyle(wbs,columnHeadStyle); //设置数量单元格
				
				HSSFSheet childSheet = wbs.getSheetAt(0);
				List<ModulePo> moduleList=new ArrayList<ModulePo>();
				for (int i = 1; i <= childSheet.getLastRowNum()+1; i++) {
					 HSSFRow row = childSheet.getRow(i);
					 if (null != row) {
						 HSSFCell cell0 = row.getCell(0);
						 HSSFCell cell1 = row.getCell(1);
						 HSSFCell cell2 = row.getCell(2);
						 HSSFCell cell3 = row.getCell(3);
						 HSSFCell cell4 = row.getCell(4);
						 HSSFCell cell5 = row.getCell(5);
						 HSSFCell cell6 = row.getCell(6);
						 HSSFCell cell7 = row.getCell(7);
						 HSSFCell cell8 = row.getCell(8);
						 HSSFCell cell9 = row.getCell(9);
						 HSSFCell cell10 = row.getCell(10);
						 HSSFCell cell11 = row.getCell(11);
						 HSSFCell cell12 = row.getCell(12);
						 HSSFCell cell13 = row.getCell(13);
						 HSSFCell cell14 = row.getCell(14);
						 HSSFCell cell15 = row.getCell(15);
						 ModulePo modulePo=new ModulePo();
						 
						 modulePo.setModuleid(cell0.getStringCellValue());
						 modulePo.setModuleapplicationid(cell1.getStringCellValue());
						 modulePo.setModuleparentid(cell2.getStringCellValue());
						 modulePo.setModulepagecode(cell3.getStringCellValue());
						 modulePo.setModulecname(cell4.getStringCellValue());
						 modulePo.setSmallmodulename(cell5.getStringCellValue());
						 modulePo.setModuledirectory(cell6.getStringCellValue());
						 modulePo.setModuleorderlevel(cell7.getStringCellValue());
						 modulePo.setModuleissystem(cell8.getStringCellValue());
						 modulePo.setModuleclose(cell9.getStringCellValue());
						 modulePo.setModuleicon(cell10.getStringCellValue());
						 modulePo.setIsupdate(cell11.getStringCellValue());
						 modulePo.setDepartmentType(cell12.getStringCellValue());
						 modulePo.setModuleDescribe(cell13.getStringCellValue());
						 modulePo.setModuleHelpHtmlUrl(cell14.getStringCellValue());
						 modulePo.setModuleHelpMovieUrl(cell15.getStringCellValue());
						 moduleList.add(modulePo);
					 }
				}
				HSSFSheet childSheet2 = wbs.getSheetAt(1);
				List<PermissionPo> permissionList=new ArrayList<PermissionPo>();
				for (int i = 1; i <= childSheet2.getLastRowNum()+1; i++) {
					 HSSFRow row = childSheet2.getRow(i);
					 if (null != row) {
						 HSSFCell cell0 = row.getCell(0);
						 HSSFCell cell1 = row.getCell(1);
						 HSSFCell cell2 = row.getCell(2);
						 HSSFCell cell3 = row.getCell(3);
						 HSSFCell cell4 = row.getCell(4);
						 HSSFCell cell5 = row.getCell(5);

						 
						 PermissionPo permissionPo=new PermissionPo();
						 
						 permissionPo.setId(cell0.getStringCellValue());
						 permissionPo.setModuleID(cell1.getStringCellValue());
						 permissionPo.setPageValue(cell2.getStringCellValue());
						 permissionPo.setPageName(cell3.getStringCellValue());
						 permissionPo.setModuleApplicationID(cell4.getStringCellValue());


						 permissionList.add(permissionPo);
					 }
				}
				logPo.setsLogContent("文件加载完成!");
				logisticsLogDao.insertLog(logPo);
				
				systemModuleDao.deleteModule();
				
                for(ModulePo modulePo:moduleList){
                	systemModuleDao.insertModule(modulePo);
                }
                
                systemModuleDao.deletePermission();
                
                for(PermissionPo permissionPo:permissionList){
                	systemModuleDao.insertPermission(permissionPo);
                }
                
				logPo.setsLogContent("文件导入完成!");
				logisticsLogDao.insertLog(logPo);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		

		
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
	// 自己封装的一个把源文件对象复制成目标文件对象
	private void copy(File src, File dst) throws Exception{
		InputStream in = null;
		OutputStream out = null;

		in = new BufferedInputStream(new FileInputStream(src));
		out = new BufferedOutputStream(new FileOutputStream(dst));
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}

		if (null != in) {
			in.close();
		}
		if (null != out) {
			out.close();
		}
	}	
}
