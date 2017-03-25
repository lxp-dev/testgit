package com.pengsheng.eims.personnel.mgr;

import java.util.List;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.PostPo;

public interface PostMgr {
	/**
	 * 取职务List
	 * @return
	 */
	public List<PostPo> getPostMaxList() ;
	
	/**
	 * 取职务List
	 * @return
	 */
	public List<PostPo> getPostList(PostPo po,int start, int size);
	
	/**
	 * 取数量
	 * @return
	 */
	public int getPostCount(PostPo po)  ;
	
	/**
	 * 取职称List
	 * 
	 * @param postPo
	 *            所属职务Po 
	 * @return
	 */
	public List<PostPo> getPostMinList(PostPo postPo);	

	/**
	 * 取指定职务/职称
	 * @return
	 */
	public PostPo getPost(PostPo postPo);

	/**
	 * 插入职务/职称
	 * 
	 * @param postPo
	 *           职务/职称参数集
	 */
	public void insertPost(PostPo postPo,LogisticsLogPo logPo);

	/**
	 * 更新职务/职称
	 * 
	 * @param postPo
	 *            职务/职称参数集
	 */
	public void updatePost(PostPo postPo,LogisticsLogPo logPo);

	/**
	 * 删除职务/职称
	 * 
	 * @param postPo
	 *            职务/职称参数集
	 */
	public void deletePost(PostPo postPo,LogisticsLogPo logPo);
	/**
	 * 判断是否有人员使用该职务
	 * @return
	 */
	public int getBeUsed(PostPo postPo);	
	/**
	 * 添加时判断职称名称 是否重复
	 * @return
	 */
	public int getPostName(PostPo postPo);
	/**
	 * 修改时判断职称名称 是否重复
	 * @return
	 */
	public int getPostNameUpdate(PostPo postPo) ;
}
