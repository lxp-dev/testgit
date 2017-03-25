package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.pengsheng.eims.basic.dao.TrainingCoursesDao;
import com.pengsheng.eims.basic.mgr.TrainingCoursesMgr;
import com.pengsheng.eims.basic.persistence.TrainingCoursesPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;


public class TrainingCoursesMgrImpl implements TrainingCoursesMgr {
	private TrainingCoursesDao trainingCoursesDao;
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	public TrainingCoursesDao getTrainingCoursesDao() {
		return trainingCoursesDao;
	}

	public void setTrainingCoursesDao(TrainingCoursesDao trainingCoursesDao) {
		this.trainingCoursesDao = trainingCoursesDao;
	}
	
	public void deleteTrainingCourses(TrainingCoursesPo po){
		trainingCoursesDao.deleteTrainingCourses(po);
		trainingCoursesDao.deleteTrainingCoursesPR(po);
	}

	public void insertTrainingCourses(TrainingCoursesPo po){
		trainingCoursesDao.insertTrainingCourses(po);
	}

	public List<TrainingCoursesPo> selectTrainingCoursesList(TrainingCoursesPo po,int start, int size){
		return trainingCoursesDao.selectTrainingCoursesList(po, start, size);
	}

	public int getTrainingCoursesCount(TrainingCoursesPo po){
		return trainingCoursesDao.getTrainingCoursesCount(po);
	}
	public void insertTrainingCourses(TrainingCoursesPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType){
		
		String uuid = uuidGenerator.generate();
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];
						
			String fileFullName = uuid + "\\" + fFullName[i];
			String savepath =  uuid + "\\" + fFullName[i];
		
			po.setKjbtvurl(savepath);
			po.setKjbtvname(fFullName[i]);
            po.setKjbcontenttype(ContentType[i]);
			File dist = new File(filePath + "\\" + uuid );
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);				
			} catch (Exception e) {
				continue;
			}
			
		}
		po.setKjbid(uuidGenerator.generate());
		po.setKprid(po.getKjbid());
		trainingCoursesDao.insertTrainingCourses(po);
		
		String[] personid = po.getKprpersonid().split(",");
		for(int i=0;i<personid.length;i++){
			if (!Utility.getName(personid[i]).equals("")){
				po.setKprpersonid(personid[i]);
				trainingCoursesDao.insertTTrainingCoursePerson(po);
			}

		}
		String[] roleid = po.getKprroleid().split(",");
		for(int i=0;i<roleid.length;i++){
			if (!Utility.getName(roleid[i]).equals("")){
				po.setKprroleid(roleid[i]);
				trainingCoursesDao.insertTTrainingCourseRole(po);
			}
		}
	}
	
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
	public TrainingCoursesPo getTrainingCoursesPo(TrainingCoursesPo po){
		return trainingCoursesDao.getTrainingCoursesPo(po);
	}
	public List<TrainingCoursesPo> getTrainingCoursesPR(TrainingCoursesPo po){
		return trainingCoursesDao.getTrainingCoursesPR(po);
	}
	public void insertTrainingCoursesPr(TrainingCoursesPo po){
		trainingCoursesDao.updateTrainingCourses(po);
		
		trainingCoursesDao.deleteTrainingCoursesPR(po);
		po.setKprid(po.getKjbid());
		String[] personid = po.getKprpersonid().split(",");
		for(int i=0;i<personid.length;i++){
			po.setKprpersonid(personid[i]);
			trainingCoursesDao.insertTTrainingCoursePerson(po);
		}
		String[] roleid = po.getKprroleid().split(",");
		for(int i=0;i<roleid.length;i++){
			po.setKprroleid(roleid[i]);
			trainingCoursesDao.insertTTrainingCourseRole(po);
		}
	}
	
	public int  Verification (String id,String roleid){
		return trainingCoursesDao.Verification(id, roleid);
	}
	
	public List<TrainingCoursesPo> selectPriceList(TrainingCoursesPo po,int start, int size){
		return trainingCoursesDao.selectPriceList(po,start,size);
	}

	public int getPriceListCount(TrainingCoursesPo po){
		return trainingCoursesDao.getPriceListCount(po);
	}
	
	public void deletePriceList(TrainingCoursesPo po){
		trainingCoursesDao.deletePriceList(po);
	}

	public void insertPriceList(TrainingCoursesPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType){	
		
		String uuid = uuidGenerator.generate();
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];
						
			String fileFullName = uuid + "\\" + fFullName[i];
			String savepath =  uuid + "\\" + fFullName[i];
		
			po.setKjbtvurl(savepath);
			po.setKjbtvname(fFullName[i]);
            po.setKjbcontenttype(ContentType[i]);
			File dist = new File(filePath + "\\" + uuid );
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);				
			} catch (Exception e) {
				continue;
			}
			
		}
		po.setKjbid(uuidGenerator.generate());
		po.setKprid(po.getKjbid());
		
		trainingCoursesDao.insertPriceList(po);
	}
	
	public void updatePriceList(TrainingCoursesPo po){
		trainingCoursesDao.updatePriceList(po);
	}
	
	public TrainingCoursesPo getPriceListPo(TrainingCoursesPo po){
		return trainingCoursesDao.getPriceListPo(po);
	}
	
}
