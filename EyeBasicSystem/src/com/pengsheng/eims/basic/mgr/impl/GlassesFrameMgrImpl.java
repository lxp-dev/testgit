package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesFrameDao;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.PhotoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.util.tools.Utility;
/**
 * 镜架mgr 实现类
 */
public class GlassesFrameMgrImpl implements GlassesFrameMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

    private GlassesFrameDao glassesFrameDao;
	/**
	 * 获取镜架数量
	 * @param po 商品po
	 * @return int 数量
	 */	
	public int getGlassesFrameCount(GoodsInfoPo po) {
		
		return glassesFrameDao.getGlassesFrameCount(po);
	}
	/**
	 * 获取镜架list
	 * @param po 商品po
	 * @param start
	 * @param size
	 * @return list 镜架list
	 */		
	public List<GoodsInfoPo> getGlassesFrameList(GoodsInfoPo po, int start,
			int size) {
		
		return glassesFrameDao.getGlassesFrameList(po, start, size);
	}
	/**
	 * 新增镜架
	 * @param po 商品po
	 */	
	public void insertGlassesFrame(GoodsInfoPo po,LogisticsLogPo logPo) {
		glassesFrameDao.insertGlassesFrame(po);
		logisticsLogDao.insertLog(logPo);
	}
	/**
	 * 修改镜架
	 * @param po 商品po
	 */	
	public void updateGlassesFrame(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFrameDao.updateGlassesFrame(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<PhotoPo> getPhotoList(GoodsInfoPo po)
	{
		return glassesFrameDao.getPhotoList(po);
	}
	
	public int getPhotoListAllCount(GoodsInfoPo po)
	{
		return glassesFrameDao.getPhotoListAllCount(po);
	}
	
	public List<GoodsInfoPo> getPhotoListAll(GoodsInfoPo po, int start,int size)
	{
		return glassesFrameDao.getPhotoListAll(po, start, size);
	}

	/**
	 * 获取镜架po
	 * @param po 商品po
	 * @return po 商品po
	 */	
	public GoodsInfoPo getGlassesFrame(GoodsInfoPo po) {
		return glassesFrameDao.getGlassesFrame(po);
	}
	/**
	 * 获取镜架po
	 * @param po 商品po
	 * @return po 商品po
	 */	
	public GoodsInfoPo getGlassesFrameCode(GoodsInfoPo po) {
		
		return glassesFrameDao.getGlassesFrameCode(po);
	}
	/**
	 * 删除镜架
	 * @param po 商品po
	 */	
	public void deleteGlassesFrame(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFrameDao.deleteGlassesFrame(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	/**
	 * 修改镜架的停用/启用状态
	 * @param po 商品po
	 */	
	public void updateGlassesFrameDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFrameDao.updateGlassesFrameDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}

	public GlassesFrameDao getGlassesFrameDao() {
		return glassesFrameDao;
	}

	public void setGlassesFrameDao(GlassesFrameDao glassesFrameDao) {
		this.glassesFrameDao = glassesFrameDao;
	}
	
	/**
	 * 删除图片
	 * @param po 商品po
	 */	
	public void deleteGlassesFramePhoto(String filePath,String uuids) {
		// 创建目录
		PhotoPo filePo = new PhotoPo();
		if(!"".equals(uuids))
		{
			filePo.setId(uuids);
			filePo = glassesFrameDao.selectpath(filePo);
			String pathstring = filePath+"\\"+filePo.getSaveFileName();
			this.delAllFile(pathstring);
			pathstring = filePath+"\\"+filePo.getSaveFileLittleName();
			this.delAllFile(pathstring);
			
			glassesFrameDao.deleteFAQFile(filePo.getId());
		}		
	}
	
	/**
	 * 新增图片
	 * @param po 商品po
	 */	
	public void insertGlassesFramePhoto(GoodsInfoPo po,File[] upload,String filePath, String[] fFullName, String[] ContentType) {
		// 创建目录
		PhotoPo filePo = new PhotoPo();
		
		String uuid=po.getBgigoodsid();
		File dist = new File(filePath + "\\" + uuid);
		if (!dist.exists()) {
			dist.mkdir();
		}
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String temp= numHeadFormat.format(new Date());
			String fileName = fFullName[i].replaceFirst("\\..*$", "");
			String fileEnd = fFullName[i].replace(fileName, "");
			String fileFullName = uuid + "\\" + temp+i+""+fileEnd;
			String fileLitileFullName = uuid + "\\" + temp+i+"_little"+fileEnd;

			PhotoPo faqFilePo = new PhotoPo();
			faqFilePo.setFileName(fFullName[i]);
			faqFilePo.setSaveFileName(fileFullName);
			faqFilePo.setSaveFileLittleName(fileLitileFullName);
			faqFilePo.setFaqID(uuid);
			faqFilePo.setContentType(ContentType[i]);
			glassesFrameDao.insertFAQFile(faqFilePo);

			File dstFile = new File(filePath + "\\" + fileFullName);
			copy(fUpload, dstFile);
			
			try {
				toSmaillImg(filePath + "\\" + fileFullName,filePath + "\\" + fileLitileFullName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
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
	
	 private void toSmaillImg(String filePath,String thumbPath) throws Exception{   
		   String newurl =thumbPath;   
		   java.awt.Image bigJpg = javax.imageio.ImageIO.read(new java.io.File(filePath));   
		   float tagsize = 400;   
		   int old_w = bigJpg.getWidth(null);   
		   int old_h = bigJpg.getHeight(null);      
		   int new_w = 0;   
		   int new_h = 0;   
		   float tempdouble;    
		   tempdouble = old_w > old_h ? old_w/tagsize : old_h/tagsize;   
		   new_w = Math.round(old_w/tempdouble);   
		   new_h = Math.round(old_h/tempdouble);   
		   java.awt.image.BufferedImage tag = new java.awt.image.BufferedImage(new_w,new_h,java.awt.image.BufferedImage.TYPE_INT_RGB);   
		   tag.getGraphics().drawImage(bigJpg,0,0,new_w,new_h,null);   
		   FileOutputStream newimage = new FileOutputStream(newurl);   
		   com.sun.image.codec.jpeg.JPEGImageEncoder encoder = com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(newimage);          
		   encoder.encode(tag);   
		   newimage.close();   
		 } 
	 
	 /**
	 * 修改镜架批发的停用/启用状态
	 * 
	 * @param po
	 *            商品po
	 */
	public void updateAllWholeDisable(GoodsInfoPo po,LogisticsLogPo logPo){
		glassesFrameDao.updateAllWholeDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 批量修改批发的停用/启用状态
	 */
	public void updateAllWholeDisableBatch(List<GoodsInfoPo> poList,LogisticsLogPo logPo){
		
		for (GoodsInfoPo gpo : poList){
			logPo.setsLogContent(logPo.getsLogContent()+Utility.getName(gpo.getBgigoodsid()));
			this.updateAllWholeDisable(gpo,logPo);
		}
	}
	
	/**
	 * 批量修改商品停用/启用状态
	 */
	public void updateGlassesFrameDisableBatch(List<GoodsInfoPo> poList,LogisticsLogPo logPo){
		
		for (GoodsInfoPo gpo : poList){
			logPo.setsLogContent(logPo.getsLogContent()+Utility.getName(gpo.getBgigoodsid()));
			this.updateGlassesFrameDisable(gpo,logPo);
		}
	}
	
	/**
	 * 批量删除商品信息
	 */
	public void deleteGlassesFrameBatch(List<GoodsInfoPo> poList,LogisticsLogPo logPo){
		
		for (GoodsInfoPo gpo : poList){
			logPo.setsLogContent(logPo.getsLogContent()+Utility.getName(gpo.getBgigoodsid()));
			this.deleteGlassesFrame(gpo,logPo);
		}
	}
	
}
