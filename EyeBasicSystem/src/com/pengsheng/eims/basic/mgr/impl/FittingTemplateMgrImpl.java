package com.pengsheng.eims.basic.mgr.impl;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import com.pengsheng.eims.basic.dao.FittingTemplateDao;
import com.pengsheng.eims.basic.mgr.FittingTemplateMgr;
import com.pengsheng.eims.basic.persistence.FittingTemplatePo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class FittingTemplateMgrImpl implements FittingTemplateMgr {

	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	private FittingTemplateDao fittingTemplateDao = null;
	private LogisticsLogDao logisticsLogDao = null;	

	/**
	 *  查询打印单据样式总数
	 */
	public int getPrintBillTemplateCount(FittingTemplatePo po){
		return fittingTemplateDao.getPrintBillTemplateCount(po);
	}
		
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po,int start,int size){
		return fittingTemplateDao.getPrintBillTemplateList(po, start, size);
	}
	
	/**
	 *  查询打印单据样式信息
	 */
	public FittingTemplatePo getPrintBillTemplateDetail(FittingTemplatePo po){
		return fittingTemplateDao.getPrintBillTemplateDetail(po);
	}
	
	/**
	 *  新增打印单据样式
	 */
	public void insertPrintBillTemplate(FittingTemplatePo po,File[] upload, String filePath, String[] fFullName,String picPath,LogisticsLogPo logPo){
				
		if ( upload != null && filePath != null && fFullName != null ){
			
			// 上传文件
			for (int i = 0; upload != null && i < upload.length; i++) {						
				File fUpload = upload[i];			
				String uuid = uuidGenerator.generate();
				String fileFullName = uuid + "/" + fFullName[i];
				
				BufferedImage image = null;
				try {
					image = ImageIO.read(fUpload);
				} catch (IOException e1) {
					image = null;
				}
				if (image == null || image.getHeight() == 0 || image.getWidth() == 0 ){
					continue;
				}
				
				if (Utility.getName(po.getBftpicflag()).equals("l")){
					po.setBftlogo(picPath + "/" + fileFullName);	
				}else if (Utility.getName(po.getBftpicflag()).equals("b")){
					po.setBftfileurl(picPath + "/" + fileFullName);
				}else{
					if (i == 0){
						po.setBftfileurl(picPath + "/" + fileFullName);
					}else{
						po.setBftlogo(picPath + "/" + fileFullName);
					}					
				}
				
				File dist = new File(filePath + "\\" + uuid);
				if (!dist.exists()) {
					dist.mkdir();
				}

				File dstFile = new File(filePath + "\\" + fileFullName);
				try {
					copy(fUpload, dstFile);
				} catch (Exception e) {
					po.setBftfileurl("");
					po.setBftlogo("");
				}			
				
			}
			
		}
		
		fittingTemplateDao.insertPrintBillTemplate(po);
		
		logisticsLogDao.insertLog(logPo);
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
	
	/**
	 *  修改打印单据样式
	 */
	public void updatePrintBillTemplate(FittingTemplatePo po,File[] upload, String filePath, String[] fFullName,String picPath,LogisticsLogPo logPo){
		
		if ( upload != null && filePath != null && fFullName != null ){
			
			// 上传文件
			for (int i = 0; upload != null && i < upload.length; i++) {						
				File fUpload = upload[i];			
				String uuid = uuidGenerator.generate();
				String fileFullName = uuid + "/" + fFullName[i];
				
				BufferedImage image = null;
				try {
					image = ImageIO.read(fUpload);
				} catch (IOException e1) {
					image = null;
				}
				if (image == null || image.getHeight() == 0 || image.getWidth() == 0 ){
					continue;
				}
				
				if (Utility.getName(po.getBftpicflag()).equals("l")){
					po.setBftlogo(picPath + "/" + fileFullName);	
				}else if (Utility.getName(po.getBftpicflag()).equals("b")){
					po.setBftfileurl(picPath + "/" + fileFullName);
				}else{
					if (i == 0){
						po.setBftfileurl(picPath + "/" + fileFullName);
					}else{
						po.setBftlogo(picPath + "/" + fileFullName);
					}					
				}
				
				File dist = new File(filePath + "\\" + uuid);
				if (!dist.exists()) {
					dist.mkdir();
				}

				File dstFile = new File(filePath + "\\" + fileFullName);
				try {
					copy(fUpload, dstFile);
				} catch (Exception e) {
					po.setBftfileurl("");
					po.setBftlogo("");
				}			
				
			}
			
		}
		
		fittingTemplateDao.updatePrintBillTemplate(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 *  删除打印单据样式
	 */
	public void deletePrintBillTemplate(FittingTemplatePo po,LogisticsLogPo logPo){
		fittingTemplateDao.deletePrintBillTemplate(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 *  停用启用打印单据样式
	 */
	public void updatePrintBillTemplateEnable(FittingTemplatePo po,LogisticsLogPo logPo){
		fittingTemplateDao.updatePrintBillTemplateEnable(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 *  查询打印单据样式列表
	 */
	public List<FittingTemplatePo> getPrintBillTemplateList(FittingTemplatePo po){
		return fittingTemplateDao.getPrintBillTemplateList(po);
	}

	public FittingTemplateDao getFittingTemplateDao() {
		return fittingTemplateDao;
	}

	public void setFittingTemplateDao(FittingTemplateDao fittingTemplateDao) {
		this.fittingTemplateDao = fittingTemplateDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}	
	
}
