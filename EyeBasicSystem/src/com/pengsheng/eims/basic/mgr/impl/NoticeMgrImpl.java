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

import com.pengsheng.eims.basic.dao.NoticeDao;
import com.pengsheng.eims.basic.mgr.NoticeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.NoticeFilePo;
import com.pengsheng.eims.basic.persistence.NoticePo;
import com.pengsheng.eims.basic.persistence.NoticeStaffViewPo;
import com.pengsheng.eims.basic.persistence.RepairsCostPo;
import com.pengsheng.eims.basic.persistence.StoresSalesPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;

public class NoticeMgrImpl implements NoticeMgr{
	
	private LogisticsLogDao logisticsLogDao;
	private NoticeDao noticeDao;
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id

	/**
	 * 插入公告
	 * @param po
	 */
	public void insertNotice(NoticePo po,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
		
		String uuid = uuidGenerator.generate();
		po.setBneuuid(uuid);
		
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];
						
			String fileFullName = uuid + "\\" + fFullName[i];
			
			NoticePo po2 = new NoticePo();
			po2.setBneuuid(uuid);
			po2.setContentType(ContentType[i]);
			po2.setDocumentUrl(fileFullName);
			po2.setSaveFileName(fFullName[i]);		
			po2.setBnedepartmentid(po.getBnedepartmentid());
            po2.setBnepublishperson(po.getBnepublishperson());
            
			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);				
			} catch (Exception e) {
				continue;
			}
			
			noticeDao.insertNoticeFile(po2);
		}
		
		noticeDao.insertNotice(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新公告
	 * @param po
	 */
	public void updateNotice(NoticePo po,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
			
		String uuid = uuidGenerator.generate();
		
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];			
			String fileFullName = uuid + "\\" + fFullName[i];
			
			NoticePo po2 = new NoticePo();
			po2.setBneuuid(po.getBneuuid());
			po2.setContentType(ContentType[i]);
			po2.setDocumentUrl(fileFullName);
			po2.setSaveFileName(fFullName[i]);		
			po2.setBnedepartmentid(po.getBnedepartmentid());
            po2.setBnepublishperson(po.getBnepublishperson());
            
			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);				
			} catch (Exception e) {
				continue;
			}
			
			noticeDao.insertNoticeFile(po2);
		}
		
		noticeDao.updateNotice(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除公告
	 * @param po
	 */
	public void deleteNotice(NoticePo po,LogisticsLogPo logPo){
		noticeDao.deleteNoticeStaffViewPo( po);
		noticeDao.deleteNotice(po);
		noticeDao.deleteNoticeFile(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除附件
	 * @param po
	 */
	public void deleteNoticeFile(NoticeFilePo po,LogisticsLogPo logPo){
		noticeDao.deleteNoticeFile(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 审核公告
	 */
	public void updateNoticeAudit(NoticePo po,LogisticsLogPo logPo){
		noticeDao.updateNoticeAudit(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 启用停用公告
	 */
	public void updateNoticeEnable(NoticePo po,LogisticsLogPo logPo){
		noticeDao.updateNoticeEnable(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改公告发布部门
	 */
	public void updateNoticeDpt(NoticePo po,LogisticsLogPo logPo){
		noticeDao.updateNoticeDpt(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询公告count
	 * @param po
	 * @return
	 */
	public int selectNoticeCount(NoticePo po){
		return noticeDao.selectNoticeCount(po);
	}
	
	/**
	 * 查询公告list
	 * @param po
	 * @return
	 */
	public List<NoticePo> selectNoticeList(NoticePo po, int start, int size){
		return noticeDao.selectNoticeList(po, start, size);
	}
	
	/**
	 * 获取所有门店信息
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> selectDepartmentList(NoticePo po){
		return noticeDao.selectDepartmentList(po);
	}
	
	/**
	 * 查询公告Po
	 * @param po
	 * @return
	 */
	public NoticePo selectNoticePo(NoticePo po){
		return noticeDao.selectNoticePo(po);
	}
	
	/**
	 * 查询公告附件
	 * @param po
	 * @return
	 */
	public List<NoticeFilePo> selectNoticeFile(NoticePo po){
		return noticeDao.selectNoticeFile(po);
	}
	
	/**
	 * 下载公告附件
	 * @param po
	 * @return
	 */
	public NoticeFilePo selectNoticeFile(NoticeFilePo po){
		return noticeDao.selectNoticeFile(po);
	}
	
	/**
	 * 新增公告查看人
	 */
	public void insertNoticeStaffViewPo(NoticeStaffViewPo po) 
	{
		 noticeDao.insertNoticeStaffViewPo(po) ;
	}
	
	/**
	 * 判断员工是否查看过公告
	 */
	public int getNoticeStaffViewCount(NoticeStaffViewPo po){
		return noticeDao.getNoticeStaffViewCount(po) ;
	}
	
	/**
	 * 更新员工是否查看过公告
	 */
	public void updateNoticeStaffView(NoticeStaffViewPo po){
		noticeDao.updateNoticeStaffView(po);
	}
	
	public int getViewNoticePersonCount(NoticePo po){
		return noticeDao.getViewNoticePersonCount(po) ;
	}
	
	/**
	 * 查询公告所有查看过的人
	 */
	public List<PersonInfoPo> getPersonList(NoticePo po,int start, int size) 
	{
		return noticeDao.getPersonList(po,start,size);
	}
	/**
	 * 加载部门
	 */
	public List<DepartmentsPo> getDepartmentsList(String id) 
	{
		return noticeDao.getDepartmentsList(id);
	}
		
	// 自己封装的一个把源文件对象复制成目标文件对象
	private void copy(File src, File dst) throws Exception {
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
	 * 插入公告类型
	 * @param po
	 */
	public void insertNoticeType(NoticePo po,LogisticsLogPo logPo){
		noticeDao.insertNoticeType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新公告类型
	 * @param po
	 */
	public void updateNoticeType(NoticePo po,LogisticsLogPo logPo){
		noticeDao.updateNoticeType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除公告类型
	 * @param po
	 */
	public void deleteNoticeType(NoticePo po,LogisticsLogPo logPo){
		noticeDao.deleteNoticeType(po);
		logisticsLogDao.insertLog(logPo);
	}
		
	/**
	 * 查询公告类型的总数
	 * @param po
	 * @return
	 */
	public int getNoticeTypeCount(NoticePo po){
		return noticeDao.getNoticeTypeCount(po);
	}
	
	/**
	 * 查询公告类型的列表
	 * @param po
	 * @return
	 */
	public List<NoticePo> getNoticeTypeList(NoticePo po, int start, int size){
		return noticeDao.getNoticeTypeList(po,start,size);
	}
	
	/**
	 * 查询公告类型的明细
	 * @param po
	 * @return
	 */
	public NoticePo getNoticeTypeDetail(NoticePo po){
		return noticeDao.getNoticeTypeDetail(po);
	}
	
	/**
	 * 查询公告类型的列表
	 * @param po
	 * @return
	 */
	public List<NoticePo> getNoticeTypeList(){
		return noticeDao.getNoticeTypeList();
	}
	
	/**
	 * 查询维修项的明细
	 * @param po
	 * @return
	 */
	public RepairsCostPo getRepairsCostDetail(RepairsCostPo po){
		return noticeDao.getRepairsCostDetail(po);
	}
	
	/**
	 * 插入维修项
	 * @param po
	 */
	public void insertRepairsCost(RepairsCostPo po,LogisticsLogPo logPo){
		noticeDao.insertRepairsCost(po);
	}
	
	/**
	 * 更新维修项
	 * @param po
	 */
	public void updateRepairsCost(RepairsCostPo po,LogisticsLogPo logPo){
		noticeDao.updateRepairsCost(po);
	}
	
	/**
	 * 删除维修项
	 * @param po
	 */
	public void deleteRepairsCost(RepairsCostPo po,LogisticsLogPo logPo){
		noticeDao.deleteRepairsCost(po);
	}
	
	/**
	 * 查询维修项的总数
	 * @param po
	 * @return
	 */
	public int getRepairsCostCount(RepairsCostPo po){
		return noticeDao.getRepairsCostCount(po);
	}
	
	/**
	 * 查询维修项的列表
	 * @param po
	 * @return
	 */
	public List<RepairsCostPo> getRepairsCostList(RepairsCostPo po, int start, int size){
		return noticeDao.getRepairsCostList(po,start,size);
	}
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public int getStoresSalesAmountCount(String departmentID, String totalType, String companyID) {
		return noticeDao.getStoresSalesAmountCount(departmentID, totalType,companyID);
	}

	public List<StoresSalesPo> getStoresSalesAmountList(String departmentID, String totalType, String companyID) {
		return noticeDao.getStoresSalesAmountList(departmentID, totalType,companyID);
	}
}
