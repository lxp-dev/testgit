package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.InterestPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;

/**
 * TeachnologyTypeMgr 兴趣爱好Mgr
 * 
 * @author liujing
 * @version 1.0
 */
public interface InterestMgr {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 兴趣爱好数量
	 */
	public int getInterestCount(InterestPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 兴趣爱好结果集
	 */
	public List<InterestPo> getInterestList(InterestPo po,int start, int size);

	/**
	 * 查询兴趣爱好的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 兴趣爱好详细信息
	 */
	public InterestPo getInterestPo(InterestPo po);
	
	/**
	 * 查询兴趣爱好ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestId(InterestPo po);
	/**
	 * 添加时查询兴趣爱好名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestName(InterestPo po) ;
	/**
	 * 修改时查询兴趣爱好名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestNameUpdate(InterestPo po) ;
	
	/**
	 * 查询兴趣爱好在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getInterestWithGoods(InterestPo po);
	
	
	/**
	 * 新增兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void insertInterest(InterestPo po,LogisticsLogPo logPo);
	
	/**
	 * 修改兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void updateInterest(InterestPo po,LogisticsLogPo logPo);
	
	/**
	 * 删除兴趣爱好
	 * 
	 * @param po 兴趣爱好po
	 * @return void
	 */
	public void deleteInterest(InterestPo po,LogisticsLogPo logPo);
	
	/**
	 * 根据返回相应的结果集
	 * 
	 */
	public List getInterestList();
	
}
