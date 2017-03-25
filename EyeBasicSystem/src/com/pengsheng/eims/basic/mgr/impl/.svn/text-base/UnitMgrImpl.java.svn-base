package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.UnitDao;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;

public class UnitMgrImpl implements UnitMgr {

	private UnitDao unitDao;
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteUnit(UnitPo unitPo,LogisticsLogPo logPo) {
		this.unitDao.deleteUnit(unitPo);
		logisticsLogDao.insertLog(logPo);
	}

	public UnitPo getUnit(UnitPo unitPo) {
		return this.unitDao.getUnit(unitPo);
	}

	public List<UnitPo> getUnitList() {
		return this.unitDao.getUnitList();
	}
	
	public int getUnitCount() 
	{
		return this.unitDao.getUnitCount();
	}	
	public List<UnitPo> getUnitsList(int start, int size) 
	{
		return this.unitDao.getUnitsList(start, size);
	}

	public void insertUnit(UnitPo unitPo,LogisticsLogPo logPo) {
		this.unitDao.insertUnit(unitPo);
		logisticsLogDao.insertLog(logPo);
	}

	public void updateUnit(UnitPo unitPo,LogisticsLogPo logPo) {
		this.unitDao.updateUnit(unitPo);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询投诉信息	
	 */
	public List<ComplaintsTypePo> getComplaintsTypeList(){
		return unitDao.getComplaintsTypeList();
	}
	/**
	 * 查询投诉信息数量	
	 */
	public int getComplaintsTypesCount()
	{
		return unitDao.getComplaintsTypesCount();
	}
	/**
	 * 查询投诉信息	
	 */
	public List<ComplaintsTypePo> getComplaintsTypesList(int start, int size) 
	{
		return unitDao.getComplaintsTypesList(start, size);
	}

	/**
	 * 判断投诉信息的编号是否存在
	 */
	public int isExistComplaintsType(ComplaintsTypePo po){
		return unitDao.isExistComplaintsType(po);
	}

	/**
	 * 添加时判断投诉类型名称是否存在
	 */
	public int getComplaintsTypeName(ComplaintsTypePo po) 
	{
		return unitDao.getComplaintsTypeName(po);
	}
	/**
	 * 修改时判断投诉类型名称是否存在
	 */
	public int getComplaintsTypeNameUpdate(ComplaintsTypePo po) 
	{
		return unitDao.getComplaintsTypeNameUpdate(po);
	}
	/**
	 * 插入投诉信息	
	 */
	public void insertComplaintsType(ComplaintsTypePo po,LogisticsLogPo logPo){
		unitDao.insertComplaintsType(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新投诉信息	
	 */
	public void updateComplaintsType(ComplaintsTypePo po,LogisticsLogPo logPo){
		unitDao.updateComplaintsType(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除投诉信息
	 */
	public void deleteComplaintsType(ComplaintsTypePo po,LogisticsLogPo logPo){
		unitDao.deleteComplaintsType(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询外来处方	
	 */
	public List<ForeignRecipelPo> getForeignRecipelList(){
		return unitDao.getForeignRecipelList();
	}
	/**
	 * 查询外来处方数量	
	 */
	public int getForeignRecipelsCount()
	{
		return unitDao.getForeignRecipelsCount();
	}
	/**
	 * 查询外来处方	
	 */
	public List<ForeignRecipelPo> getForeignRecipelsList(int start, int size)
	{
		return unitDao.getForeignRecipelsList(start, size);
	}
	
	/**
	 * 判断外来处方的编号是否存在
	 */
	public int isExistForeignRecipel(ForeignRecipelPo po){
		return unitDao.isExistForeignRecipel(po);
	}
	/**
	 * 添加时判断外来处方名称是否存在
	 */
	public int getForeignRecipelName(ForeignRecipelPo po) 
	{
		return unitDao.getForeignRecipelName(po);
	}
	/**
	 * 修改时判断外来处方名称是否存在
	 */
	public int getForeignRecipelNameUpdate(ForeignRecipelPo po) 
	{
		return unitDao.getForeignRecipelNameUpdate(po);
	}
	/**
	 * 插入外来处方	
	 */
	public void insertForeignRecipel(ForeignRecipelPo po,LogisticsLogPo logPo){
		unitDao.insertForeignRecipel(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新外来处方	
	 */
	public void updateForeignRecipel(ForeignRecipelPo po,LogisticsLogPo logPo){
		unitDao.updateForeignRecipel(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除外来处方
	 */
	public void deleteForeignRecipel(ForeignRecipelPo po,LogisticsLogPo logPo){
		unitDao.deleteForeignRecipel(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getNoteTemplateList(){
		return unitDao.getNoteTemplateList();
	}
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getAllNoteTemplateList(){
		return unitDao.getAllNoteTemplateList();
	}
	/**
	 * 查询短信类型开关状态
	 */
	public NoteTypePo getNoteTypePo(String id)
	{
		return unitDao.getNoteTypePo(id);
	}
	/**
	 * 插入短信模板	
	 */
	public void insertNoteTemplate(NoteTemplatePo po,LogisticsLogPo logPo){
		if (Utility.getName(po.getBntautosend()).equals("1") || Utility.getName(po.getBntautosend()).equals("on")){
			unitDao.updateNoteAutoSend(po);
		}
		unitDao.insertNoteTemplate(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新短信模板	
	 */
	public void updateNoteTemplate(NoteTemplatePo po,LogisticsLogPo logPo){
		if (Utility.getName(po.getBntautosend()).equals("1") || Utility.getName(po.getBntautosend()).equals("on")){
			unitDao.updateNoteAutoSend(po);
		}else{
			po.setBnttypeautosend("0");
			po.setBnttypename(po.getBntname());
			unitDao.updateNoteTemplateAutoSend(po);
		}
		if(po.getBntname().equals("13"))
		{
			unitDao.updateNoteTemplateLens(po);
		}
		unitDao.updateNoteTemplate(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除短信模板
	 */
	public void deleteNoteTemplate(NoteTemplatePo po,LogisticsLogPo logPo){		
		unitDao.deleteNoteTemplate(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询折射率	
	 */
	public List<RefractiveSetPo> getRefractiveSetList(){
		return unitDao.getRefractiveSetList();
	}
	
	/**
	 * 查询折射率数量	
	 */
	public int getRefractiveSetsCount()
	{
		return unitDao.getRefractiveSetsCount();
	}
	/**
	 * 查询折射率	
	 */
	public List<RefractiveSetPo> getRefractiveSetsList(int start, int size)
	{
		return unitDao.getRefractiveSetsList(start, size);
	}

	/**
	 * 判断折射率的编号是否存在
	 */
	public int isExistRefractiveSet(RefractiveSetPo po){
		return unitDao.isExistRefractiveSet(po);
	}
	/**
	 * 添加时判断折射率值是否存在
	 */
	public int getRefractiveName(RefractiveSetPo po)
	{
		return unitDao.getRefractiveName(po);
	}
	/**
	 * 修改时判断折射率值是否存在
	 */
	public int getRefractiveNameUpdate(RefractiveSetPo po) 
	{
		return unitDao.getRefractiveNameUpdate(po);
	}

	/**
	 * 插入折射率	
	 */
	public void insertRefractiveSet(RefractiveSetPo po,LogisticsLogPo logPo){
		unitDao.insertRefractiveSet(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新折射率	
	 */
	public void updateRefractiveSet(RefractiveSetPo po,LogisticsLogPo logPo){
		unitDao.updateRefractiveSet(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 删除折射率
	 */
	public void deleteRefractiveSet(RefractiveSetPo po,LogisticsLogPo logPo){
		unitDao.deleteRefractiveSet(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 折射率明细
	 */
	public RefractiveSetPo getRefractiveSetDetail(RefractiveSetPo po){
		return unitDao.getRefractiveSetDetail(po);
	}
	
	/**
	 * 短信模板明细
	 */
	public NoteTemplatePo getNoteTemplateDetail(NoteTemplatePo po){
		return unitDao.getNoteTemplateDetail(po);
	}
	
	/**
	 * 外来处方明细
	 */
	public ForeignRecipelPo getForeignRecipelDetail(ForeignRecipelPo po){
		return unitDao.getForeignRecipelDetail(po);
	}
	
	/**
	 * 投诉信息明细
	 */
	public ComplaintsTypePo getComplaintsTypeDetail(ComplaintsTypePo po){
		return unitDao.getComplaintsTypeDetail(po);
	}
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getNoteTemplateMinList(NoteTemplatePo po){
		return unitDao.getNoteTemplateMinList(po);
	}
	
	
	/**
	 * 设置自动和默认发送短信	
	 */
	public void updateNoteTemplateAutoSend(NoteTemplatePo po,LogisticsLogPo logPo){
		
		NoteTemplatePo tmp = new NoteTemplatePo();
		tmp.setBntname(Utility.getName(po.getBnttypename()));
		
		if (!Utility.getName(po.getBnttypeautosend()).equals("0")){
			unitDao.setNoteAutoSend(tmp);			
		}
		
		unitDao.updateNoteTemplateAutoSend(po);
		logisticsLogDao.insertLog(logPo);
	}
	public int getUnitName(UnitPo po)
	{
		return unitDao.getUnitName(po);
	}
	public int getUnitNameUpdate(UnitPo po)
	{
		return unitDao.getUnitNameUpdate(po);
	}
	/**
	 * 查询短信模板开关状态
	 */
	public NoteTemplatePo getNoteTemplateType(NoteTemplatePo po){
		return unitDao.getNoteTemplateType(po);
	}
	
	public UnitDao getUnitDao() {
		return unitDao;
	}

	public void setUnitDao(UnitDao unitDao) {
		this.unitDao = unitDao;
	}

	public int getGoodsCount(UnitPo unitPo) {
		return this.unitDao.getGoodsCount(unitPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


}
