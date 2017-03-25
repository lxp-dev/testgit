package com.pengsheng.eims.system.mgr.impl;

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

import com.pengsheng.eims.storage.dao.SystemClearDao;
import com.pengsheng.eims.system.dao.CompanyNameDao;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.basic.dao.DownloadRegionDao;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;


public class CompanyNameMgrImpl implements CompanyNameMgr {

	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	private CompanyNameDao companyNameDao;
	private SystemClearDao systemClearDao;
	private DownloadRegionDao downloadRegionDao; 
	
	public DownloadRegionDao getDownloadRegionDao() {
		return downloadRegionDao;
	}
	public void setDownloadRegionDao(DownloadRegionDao downloadRegionDao) {
		this.downloadRegionDao = downloadRegionDao;
	}

	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public CompanyNameDao getCompanyNameDao() {
		return companyNameDao;
	}

	public void setCompanyNameDao(CompanyNameDao companyNameDao) {
		this.companyNameDao = companyNameDao;
	}
	
	/**
	 * 查询公司的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getCompanyNameCount(CompanyNamePo po){
		return companyNameDao.getCompanyNameCount(po);
	}
	
	/**
	 * 查询公司列表
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameList(CompanyNamePo po,int start,int size){
		return companyNameDao.getCompanyNameList(po, start, size);
	}

	/**
	 * 查询公司名称设定
	 */
	public CompanyNamePo getCompanyName(CompanyNamePo companyNamePo) {
		return companyNameDao.getCompanyName(companyNamePo);
	}

	/**
	 * 新增公司名称设定
	 */
	public void insertCompanyName(CompanyNamePo companyNamePo,File[] upload, String filePath, String[] fFullName,String picPath,LogisticsLogPo logPo) {
		
		
		if("".equals(Utility.getName(companyNamePo.getFcnId()))){
			companyNameDao.deleteCompanyName(companyNamePo);
			companyNameDao.insertCompanyName(companyNamePo);
		}else{
			companyNameDao.updateCompanyName(companyNamePo);
		}
		
		if ( upload != null && filePath != null && fFullName != null ){
			CompanyNamePo po = companyNameDao.selectCompanyInfo(companyNamePo);
			companyNamePo.setFcnLogoPath(Utility.getName(po.getFcnLogoPath()));	
			companyNamePo.setFcnbackGroundPath(Utility.getName(po.getFcnbackGroundPath()));
			companyNamePo.setFcndepground(Utility.getName(po.getFcndepground()));
			companyNameDao.deleteCompanyLogo(companyNamePo);
			
			// 上传文件
			for (int i = 0; upload != null && i < upload.length; i++) {						
				File fUpload = upload[i];			
				String uuid = uuidGenerator.generate();
				String fileFullName = uuid + "\\" + fFullName[i];
				
				BufferedImage image = null;
				try {
					image = ImageIO.read(fUpload);
				} catch (IOException e1) {
					image = null;
				}
				if (image == null || image.getHeight() == 0 || image.getWidth() == 0 ){
					continue;
				}
				
				if (companyNamePo.getFcnflag().equals("l")){
					companyNamePo.setFcnLogoPath(picPath + "\\" + fileFullName);	
				}else if (companyNamePo.getFcnflag().equals("b")){
					companyNamePo.setFcnbackGroundPath(picPath + "\\" + fileFullName);
				}else if(companyNamePo.getFcnflag().equals("d")){
					companyNamePo.setFcndepgroundPath(picPath + "\\" + fileFullName);
				}else if(companyNamePo.getFcnflag().equals("bd")){
					companyNamePo.setFcnbackGroundPath(picPath + "\\" + fileFullName);
					companyNamePo.setFcndepgroundPath(picPath + "\\" + fileFullName);
				}else if(companyNamePo.getFcnflag().equals("lb")){
					companyNamePo.setFcnLogoPath(picPath + "\\" + fileFullName);
					companyNamePo.setFcnbackGroundPath(picPath + "\\" + fileFullName);
				}else if(companyNamePo.getFcnflag().equals("ld")){
					companyNamePo.setFcnLogoPath(picPath + "\\" + fileFullName);
					companyNamePo.setFcndepgroundPath(picPath + "\\" + fileFullName);
				}else{
					if (i == 0){
						companyNamePo.setFcnLogoPath(picPath + "\\" + fileFullName);	
					}else if(i == 1){
						companyNamePo.setFcnbackGroundPath(picPath + "\\" + fileFullName);
					}else{
						companyNamePo.setFcndepgroundPath(picPath + "\\" + fileFullName);
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
					companyNamePo.setFcnbackGroundPath("");	
					companyNamePo.setFcnLogoPath("");
				}
			}
		}
		
		companyNameDao.insertCompanyLogo(companyNamePo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	//自己封装的一个把源文件对象复制成目标文件对象
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
	 * 公司使用默认logo或默认背景
	 * @param companyNamePo
	 */
	public void updateCompanyInfo(CompanyNamePo companyNamePo,LogisticsLogPo logPo){
		companyNameDao.updateCompanyInfo(companyNamePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public SystemClearDao getSystemClearDao() {
		return systemClearDao;
	}
	public void setSystemClearDao(SystemClearDao systemClearDao) {
		this.systemClearDao = systemClearDao;
	}
	
	/**
	 * 获取所有公司加载下拉菜单
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanyNameForSelect(CompanyNamePo po){
		return companyNameDao.getCompanyNameForSelect(po);
	}
	
	public String deleteCompanyName(CompanyNamePo companyNamePo,LogisticsLogPo logPo){
		
		int count = companyNameDao.selectCompanyDepartmentsCount(companyNamePo);
		
		if(count > 0){
			return "该公司下已设置部门，不能被删除！";
		}else{
			companyNameDao.deleteCompanyName(companyNamePo);
			companyNameDao.deleteCompanyLogo(companyNamePo);
			logisticsLogDao.insertLog(logPo); //添加日志
			return "";
		}
	}
	
//--------------------------------------------区域维护------------------------------------------------
	
	/**
	 * 查询区域的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getRegionCount(CompanyNamePo po){
		return companyNameDao.getRegionCount(po);
	}
	
	/**
	 * 查询区域列表
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionList(CompanyNamePo po,int start,int size){
		return companyNameDao.getRegionList(po, start, size);
	}

	/**
	 * 查询区域名称设定
	 */
	public CompanyNamePo getRegion(CompanyNamePo companyNamePo) {
		return companyNameDao.getRegion(companyNamePo);
	}

	/**
	 * 新增区域名称设定
	 */
	public void insertRegion(CompanyNamePo companyNamePo,LogisticsLogPo logPo) {
		companyNameDao.insertRegion(companyNamePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 修改区域名称设定
	 */
	public void updateRegion(CompanyNamePo companyNamePo,LogisticsLogPo logPo) {
		companyNameDao.updateRegion(companyNamePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 删除区域名称设定
	 */
	public String deleteRegion(CompanyNamePo companyNamePo,LogisticsLogPo logPo) {
		int count = companyNameDao.getRegionCountForDelete(companyNamePo);
		
		if(count > 0){
			return "该区域下已设置公司，不能被删除！";
		}else{
			companyNameDao.deleteRegion(companyNamePo);
			logisticsLogDao.insertLog(logPo); //添加日志
			return "";
		}
	}
	
	/**
	 * 查询区域列表填装下拉项
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getRegionListForSelect(){
		return companyNameDao.getRegionListForSelect();
	}
	
	/**
	 * 公司制造商配置信息加载
	 * 
	 * @param po
	 * @return
	 */
	public List<CompanyNamePo> getCompanySupplierList(CompanyNamePo po){
		return companyNameDao.getCompanySupplierList(po);
	}
	
	/**
	 * 公司供货商配置信息加载
	 * 
	 * @param po
	 * @return
	 */
	public List<SupplierPo> getCompanySupplierAgentList(SupplierPo po){
		return companyNameDao.getCompanySupplierAgentList(po);
	}
	
	/**
	 * 公司供货商配置信息新增
	 */
	public void insertCompanyAgent(List<CompanyNamePo> pos,LogisticsLogPo logPo){
		companyNameDao.deleteCompanyAgent(pos.get(0));
		
		for(int i=0; i<pos.size(); i++){
			companyNameDao.insertCompanyAgent(pos.get(i));
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 下载区域下公司信息
	 */
	public String noInsertCompanyPoForDownload(CompanyNamePo po,LogisticsLogPo logPo){
		
		downloadRegionDao.openWork();
		
		//基础信息加入
		downloadRegionDao.insertDownloadCompanyPos(po);
		
		//配置
		downloadRegionDao.insertCompanySupplierMentPos(po);
		
		//制造商
		downloadRegionDao.insertCompanySupplierPos(po);
		
		//供应商
		downloadRegionDao.insertCompanySupplierAgentPos(po);
		
		downloadRegionDao.closeWork();
		
		logisticsLogDao.insertLog(logPo); //添加日志
		
		return "下载完成！";
	}
	
	/**
	 * 下载区域与公司信息及相应绑定关系
	 * @param po
	 * @return
	 */
	public String noInsertRegionAndCompany(CompanyNamePo po,LogisticsLogPo logPo){
		downloadRegionDao.openWork();
		
		downloadRegionDao.insertRegionAndCompany(po);
		
		downloadRegionDao.closeWork();
		
		return "下载完成！";
	}
}
