package com.pengsheng.eims.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.util.tools.Utility;

/**
 * RegisteredCategoryDao 挂号类型Dao
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public interface RegisteredCategoryDao {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po
	 *            查询条件
	 * @return int 挂号类型数量
	 */
	public int getRegisteredCategoryCount(RegisteredCategoryPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po
	 *            查询条件 start 开始数量 size 每页显示数量
	 * @return List 挂号类型结果集
	 */
	public List getRegisteredCategoryList(RegisteredCategoryPo po, int start,
			int size);

	/**
	 * 新增挂号类型
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void insertRegisteredCategory(RegisteredCategoryPo po);

	/**
	 * 检查挂号类型编号是否重复
	 * 
	 * @param po
	 *            挂号类型po
	 * @return int 0:不存在 大于0存在
	 */
	public int searchRegisteredId(RegisteredCategoryPo po);

	/**
	 * 按条件检索检查费用项目进行管理
	 * 
	 * @param flag
	 *            启用停用标示位 1:启用 0：停用
	 * @param feeType
	 *            收费类型 1:缴费 2：退费
	 * @return List
	 */
	public List getSelValue(String flag, String feeType);

	/**
	 * 挂号类型维护保存
	 * 
	 * @param stop
	 *            停用主键ID
	 * @param start
	 *            启用主键ID
	 * @return void
	 */
	public void saveManagerValue(String[] stop, String[] start);

	/**
	 * 查询挂号类型的详细信息
	 * 
	 * @param po
	 *            查询条件
	 * @return po 挂号类型详细信息
	 */
	public RegisteredCategoryPo getRegisteredCategoryPo(RegisteredCategoryPo po);

	/**
	 * 更新挂号类型信息
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po);

	/**
	 * 删除挂号类型
	 * 
	 * @param po
	 *            挂号类型po
	 * @return void
	 */
	public void deleteRegisteredCategory(RegisteredCategoryPo po);

	/**
	 * 查询挂号类型在 表中是否已经使用
	 * 
	 * @param po
	 *            查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getRegisteredCategoryWithOther(RegisteredCategoryPo po);

	/**
	 * 得到挂号医保明细
	 * 
	 * @param registeredID
	 * @return
	 */
	public List<RegisteredPrintDetailsPo> getRegisteredPrintDetails(
			String registeredID);

	/**
	 * 插入医保明细
	 * 
	 * @param registeredPrintDetailsPo
	 */
	public void insertRegisteredPrintDetails(
			RegisteredPrintDetailsPo registeredPrintDetailsPo);

	/**
	 * 刪除医保明细
	 * 
	 * @param registeredID
	 */
	public void delRegisteredPrintDetails(String registeredID);
}
