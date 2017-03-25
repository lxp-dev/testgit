package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.pengsheng.eims.basic.dao.ContractDao;
import com.pengsheng.eims.basic.mgr.ContractMgr;
import com.pengsheng.eims.basic.persistence.ContractPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;

public class ContractMgrImpl implements ContractMgr {

	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	
	private ContractDao contractDao;
	
	private LogisticsLogDao logisticsLogDao;
	
	public ContractDao getContractDao() {
		return contractDao;
	}

	public void setContractDao(ContractDao contractDao) {
		this.contractDao = contractDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 查询制造商合同的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getContractCount(ContractPo po) {

		return contractDao.getContractCount(po);
	}
	
	/**
	 * 
	 * 遍历制造商合同并实现分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ContractPo> getContractList(ContractPo po,int start, int size) {

		return contractDao.getContractList(po, start, size);
	}
	
	/**
	 * 查询制造商合同信息
	 * 
	 * @param po
	 * @return
	 */
	public ContractPo getContract(ContractPo po) {

		return contractDao.getContract(po);
	}

	/**
	 * 新增制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void insertContract(ContractPo contractPo, String delFileID,
			File[] upload, String filePath, String[] fFullName,
			String[] ContentType, LogisticsLogPo logPo) {

		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			// System.out.println("上传的文件的类型：" + this.getUploadContentType()[i]);
			String uuid = uuidGenerator.generate();

			String fileFullName = uuid + "\\" + fFullName[i];

			contractPo.setSaveFileName(fileFullName);
			contractPo.setContentType(ContentType[i]);
			contractPo.setDocumentUrl(fileFullName);
			contractPo.setSaveFileName(fFullName[i]);		
			
			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);
			} catch (Exception e) {
				contractPo.setSaveFileName("");
				contractPo.setContentType("");
				contractPo.setDocumentUrl("");
				contractPo.setSaveFileName("");
				System.out.println("上传制造商合同失败!");
			}
		}

		contractDao.insertContract(contractPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
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
	 * 修改制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void updateContract(ContractPo contractPo, String delFileID,
			File[] upload, String filePath, String[] fFullName,
			String[] ContentType, LogisticsLogPo logPo) {

		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			// System.out.println("上传的文件的类型：" + this.getUploadContentType()[i]);
			String uuid = uuidGenerator.generate();

			String fileFullName = uuid + "\\" + fFullName[i];

			contractPo.setSaveFileName(fileFullName);
			contractPo.setContentType(ContentType[i]);
			contractPo.setDocumentUrl(fileFullName);
			contractPo.setSaveFileName(fFullName[i]);

			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);
			} catch (Exception e) {
				contractPo.setSaveFileName("");
				contractPo.setContentType("");
				contractPo.setDocumentUrl("");
				contractPo.setSaveFileName("");
				System.out.println("上传制造商合同失败!");
			}
		}

		contractDao.updateContract(contractPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除制造商合同信息
	 * 
	 * @param po
	 * @param logPo
	 */
	public void deleteContract(ContractPo po, LogisticsLogPo logPo) {

		contractDao.deleteContract(po);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
}
