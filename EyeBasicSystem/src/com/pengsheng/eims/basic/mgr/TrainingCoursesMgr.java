package com.pengsheng.eims.basic.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.TrainingCoursesPo;

public interface TrainingCoursesMgr {
	
	
	public void deleteTrainingCourses(TrainingCoursesPo po);

	public void insertTrainingCourses(TrainingCoursesPo po);

	public List<TrainingCoursesPo> selectTrainingCoursesList(TrainingCoursesPo po,int start, int size);

	public int getTrainingCoursesCount(TrainingCoursesPo po);
	
	public void insertTrainingCourses(TrainingCoursesPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType);
	
	public void insertTrainingCoursesPr(TrainingCoursesPo po);
	
	public TrainingCoursesPo getTrainingCoursesPo(TrainingCoursesPo po);
	
	public List<TrainingCoursesPo> getTrainingCoursesPR(TrainingCoursesPo po);
	
	public int  Verification (String id,String roleid);
	
	
	public List<TrainingCoursesPo> selectPriceList(TrainingCoursesPo po,int start, int size);

	public int getPriceListCount(TrainingCoursesPo po);
	
	public void deletePriceList(TrainingCoursesPo po);
	
	public void updatePriceList(TrainingCoursesPo po);
	
	public TrainingCoursesPo getPriceListPo(TrainingCoursesPo po);
	
	public void insertPriceList(TrainingCoursesPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType);
	
	
}
