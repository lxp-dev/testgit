package com.pengsheng.weixin.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;

public interface WeiXinCmsContentDao {
	/**
	 * 新增文章信息
	 * @param po
	 */
	public void insertWeiXinCmsContentPo(WeiXinCmsContentPo po);
	
	/**
	 * 更新文章信息
	 * @param po
	 */
	public void updateWeiXinCmsContentPo(WeiXinCmsContentPo po);
	
	/**
	 * 更新启用状态
	 * @param po
	 */
	public void updateWeiXinCmsContentFlag(WeiXinCmsContentPo po);
	
	/**
	 * 获得文章信息
	 * @param po
	 */
	public WeiXinCmsContentPo selectWeiXinCmsContentPo(WeiXinCmsContentPo po);
	
	/**
	 * 删除文章信息
	 * @param po
	 */
	public void deleteWeiXinCmsContentPo(WeiXinCmsContentPo po);
	
	/**
	 * 获取文章信息条数
	 * @param po
	 * @return
	 */
	public int selectWeiXinCmsContentCount(WeiXinCmsContentPo po);
	
	/**
	 * 获取文章信息List
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WeiXinCmsContentPo> selectWeiXinCmsContentList(WeiXinCmsContentPo po, int start,int size);
	
	/**
	 * 获取投诉人信息
	 * @param po
	 * @return
	 */
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo po);
	
	/**
	 * 获取眼部常识预览信息List
	 * @param po
	 * @return
	 */
	public List<WeiXinCmsContentPo> selectWeiXinCmsContentListForView(WeiXinCmsContentPo po);
	
	/**
	 * 获取几条文章的title，并以逗号分割返回
	 * @param ids
	 * @return
	 */
	public String getWeiXinCmsContentTitles(String ids);	
}
