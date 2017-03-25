package com.pengsheng.eims.system.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface SendNoteDao {

	/**
	 * 获取短信模板
	 */
	public NoteTemplatePo getSendNoteTemplate(NoteTemplatePo po);
	
	/**
	 * 获取短信模板数量
	 */
	public List<NoteTemplatePo> getSendNoteTemplateCount();
	public int getSendNoteTemplateCount(NoteTemplatePo po);
	
	/**
	 * 新增短信
	 */
	public void insertSendNoteContent(SendNotePo po);
	
	/**
	 * 根据顾客号查询手机
	 */
	public SendNotePo getSendNotePhoneByCustomer(SendNotePo po);
	
	/**
	 * 根据顾客号查询手机是否存在
	 */
	public int getSendNotePhoneCountByCustomer(SendNotePo po);
	
	/**
	 * 测试短信接口
	 */
	public int getSendNotePhoneCountTestByCustomer(SendNotePo po);
	
}
