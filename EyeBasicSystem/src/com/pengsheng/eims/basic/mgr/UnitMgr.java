package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface UnitMgr {
	
	/**
	 * 取计量单位List
	 * @return
	 */
	public List<UnitPo> getUnitList();
	
	/**
	 * 取计量单位数量
	 * @return
	 */
	public int getUnitCount() ;

	/**
	 * 取计量单位List
	 * @return
	 */
	public List<UnitPo> getUnitsList(int start, int size) ;

	/**
	 * 取指定计量单位
	 * 
	 * @param unitPo
	 *            计量单位参数集
	 * @return
	 */
	public UnitPo getUnit(UnitPo unitPo);

	/**
	 * 插入计量单位
	 * 
	 * @param unitPo
	 *            计量单位参数集
	 */
	public void insertUnit(UnitPo unitPo,LogisticsLogPo logPo);

	/**
	 * 更新计量单位
	 * 
	 * @param unitPo
	 *            计量单位参数集
	 */
	public void updateUnit(UnitPo unitPo,LogisticsLogPo logPo);

	/**
	 * 删除仓位
	 * 
	 * @param unitPo
	 *            计量单位参数集
	 */
	public void deleteUnit(UnitPo unitPo,LogisticsLogPo logPo);
	
	public int getGoodsCount(UnitPo unitPo);
	public int getUnitName(UnitPo po) ;
	public int getUnitNameUpdate(UnitPo po) ;
	
	/**
	 * 查询投诉信息	
	 */
	public List<ComplaintsTypePo> getComplaintsTypeList();
	/**
	 * 查询投诉信息数量	
	 */
	public int getComplaintsTypesCount() ;
	/**
	 * 查询投诉信息	
	 */
	public List<ComplaintsTypePo> getComplaintsTypesList(int start, int size) ;

	/**
	 * 判断投诉信息的编号是否存在
	 */
	public int isExistComplaintsType(ComplaintsTypePo po);

	/**
	 * 插入投诉信息	
	 */
	public void insertComplaintsType(ComplaintsTypePo po,LogisticsLogPo logPo);

	/**
	 * 更新投诉信息	
	 */
	public void updateComplaintsType(ComplaintsTypePo po,LogisticsLogPo logPo);

	/**
	 * 删除投诉信息
	 */
	public void deleteComplaintsType(ComplaintsTypePo po,LogisticsLogPo logPo);
	
	/**
	 * 查询外来处方	
	 */
	public List<ForeignRecipelPo> getForeignRecipelList();
	/**
	 * 查询外来处方数量	
	 */
	public int getForeignRecipelsCount() ;
	/**
	 * 查询外来处方	
	 */
	public List<ForeignRecipelPo> getForeignRecipelsList(int start, int size) ;

	/**
	 * 判断外来处方的编号是否存在
	 */
	public int isExistForeignRecipel(ForeignRecipelPo po);

	/**
	 * 插入外来处方	
	 */
	public void insertForeignRecipel(ForeignRecipelPo po,LogisticsLogPo logPo);

	/**
	 * 更新外来处方	
	 */
	public void updateForeignRecipel(ForeignRecipelPo po,LogisticsLogPo logPo);

	/**
	 * 删除外来处方
	 */
	public void deleteForeignRecipel(ForeignRecipelPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getNoteTemplateList();

	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getAllNoteTemplateList();
	
	/**
	 * 插入短信模板	
	 */
	public void insertNoteTemplate(NoteTemplatePo po,LogisticsLogPo logPo);

	/**
	 * 更新短信模板	
	 */
	public void updateNoteTemplate(NoteTemplatePo po,LogisticsLogPo logPo);

	/**
	 * 删除短信模板
	 */
	public void deleteNoteTemplate(NoteTemplatePo po,LogisticsLogPo logPo);
	/**
	 * 查询短信类型开关状态
	 */
	public NoteTypePo getNoteTypePo(String id);
	
	/**
	 * 查询折射率	
	 */
	public List<RefractiveSetPo> getRefractiveSetList();
	/**
	 * 查询折射率数量	
	 */
	public int getRefractiveSetsCount() ;
	/**
	 * 查询折射率	
	 */
	public List<RefractiveSetPo> getRefractiveSetsList(int start, int size) ;

	/**
	 * 判断折射率的编号是否存在
	 */
	public int isExistRefractiveSet(RefractiveSetPo po);

	/**
	 * 插入折射率	
	 */
	public void insertRefractiveSet(RefractiveSetPo po,LogisticsLogPo logPo);

	/**
	 * 更新折射率	
	 */
	public void updateRefractiveSet(RefractiveSetPo po,LogisticsLogPo logPo);

	/**
	 * 删除折射率
	 */
	public void deleteRefractiveSet(RefractiveSetPo po,LogisticsLogPo logPo);
	
	/**
	 * 折射率明细
	 */
	public RefractiveSetPo getRefractiveSetDetail(RefractiveSetPo po);
	
	/**
	 * 短信模板明细
	 */
	public NoteTemplatePo getNoteTemplateDetail(NoteTemplatePo po);
	
	/**
	 * 外来处方明细
	 */
	public ForeignRecipelPo getForeignRecipelDetail(ForeignRecipelPo po);
	
	/**
	 * 投诉信息明细
	 */
	public ComplaintsTypePo getComplaintsTypeDetail(ComplaintsTypePo po);
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getNoteTemplateMinList(NoteTemplatePo po);	
	
	/**
	 * 设置自动和默认发送短信	
	 */
	public void updateNoteTemplateAutoSend(NoteTemplatePo po,LogisticsLogPo logPo);
	
	/**
	 * 查询短信模板开关状态
	 */
	public NoteTemplatePo getNoteTemplateType(NoteTemplatePo po);
	/**
	 * 添加时判断折射率值是否存在
	 */
	public int getRefractiveName(RefractiveSetPo po);
	/**
	 * 修改时判断折射率值是否存在
	 */
	public int getRefractiveNameUpdate(RefractiveSetPo po) ;
	/**
	 * 添加时判断投诉类型名称是否存在
	 */
	public int getComplaintsTypeName(ComplaintsTypePo po) ;
	/**
	 * 修改时判断投诉类型名称是否存在
	 */
	public int getComplaintsTypeNameUpdate(ComplaintsTypePo po) ;
	/**
	 * 添加时判断外来处方名称是否存在
	 */
	public int getForeignRecipelName(ForeignRecipelPo po) ;
	/**
	 * 修改时判断外来处方名称是否存在
	 */
	public int getForeignRecipelNameUpdate(ForeignRecipelPo po) ;
}
