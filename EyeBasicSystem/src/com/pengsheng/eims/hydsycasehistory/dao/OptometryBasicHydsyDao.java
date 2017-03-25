/**
 * 
 */
package com.pengsheng.eims.hydsycasehistory.dao;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public interface OptometryBasicHydsyDao {

	/**
	 * 得到顾客验光基表
	 * 
	 * @param customerID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<OptometryBasicPo> getcustomerOptometryBasics(String customerID,
			int start, int size);

	/**
	 * 得到顾客所有验光基表明细
	 * 
	 * @param customerID
	 * @return
	 */
	public int getcustomerOptometryBasicCount(String customerID);

	/**
	 * 得到所有顾客验光病历,验光基表对应的
	 * 
	 * @return
	 */
	public List<OptometryPo> getcustomerOptometrys(String basicID);

	/**
	 * 删除验光基表
	 * 
	 * @param optometryBasicID
	 */
	public void delOptometryBasic(String optometryBasicID);

	/**
	 * 删除验光病历表
	 * 
	 * @param optometryID
	 */
	public void delOptometry(String optometryID);

	/**
	 * 删除双眼视功能
	 * 
	 * @param optometryID
	 */
	public void delDoubleEyeFun(String optometryID);

	/**
	 * 删除检查结论
	 * 
	 * @param optometryID
	 */
	public void delInspection(String optometryID);

	/**
	 * 删除特殊功能检查
	 * 
	 * @param optometryID
	 */
	public void delHealthCheck(String optometryID);

	/**
	 * 得到验光基表对象
	 * 
	 * @param optometryBasicID
	 * @return
	 */
	public OptometryBasicPo getOptometryBasicPo(String optometryBasicID);
	
	/**
	 * 更新复验时间
	 * 
	 * @param optometryBasicID
	 * @return
	 */
	public void updateOptoTime(String optometryBasicID);
	public void updateOptoTime1(String optometryID);

	/**
	 * 取验光基表下有几个验光病历
	 * 
	 * @param optometryBasicID
	 * @return
	 */
	public int getOptometryCount(String optometryBasicID);
	
	
	public void optometryBasicInsert(OptometryBasicPo optometryBasicPo);
	public void optometryInsert(OptometryPo optometryPo);
	
	
	public int getOptometryCount2(OptometryPo optometryPo) ;
	public int getOptometryBasicCount2(OptometryBasicPo optometryBasicPo);
	public void optometryUpdate(OptometryPo optometryPo);
	public OptometryPo getOptometryPo(String optometryBasicID);
	
	public OptometryBasicPo getOptometryBasicPo1(String optometryID);
	//删除屈光检查
	public void delRefractive(String optometryID);
	
	public OptometryPo selectOptometryPo(String optometryid);
}
