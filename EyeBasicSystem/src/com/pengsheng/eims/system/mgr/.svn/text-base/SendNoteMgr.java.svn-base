package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.system.persistence.SendNotePo;

public interface SendNoteMgr {

	/**
	 * 新增短信
	 */
	public void insertSendNoteContent(SendNotePo po);
	
	/**
	 * 发送短信
	 */
	public void insertSendNote(SendNotePo po);
	
	/**
	 * 发送短信（单条）
	 */
	public void sendNote(SendNotePo po);
	
	/**
	 * 重发送短信（短信记录管理）
	 */
	public void insertReSendNote(SendNotePo po);
	
	/**
	 * 短信接口
	 */
	public String insertSendNoteInterface(SendNotePo po);
	
	/**
	 * 获得短信条数
	 */
	public String getSmsCount();	
	
	/**
	 * 获取短信模板数量
	 */
	public List<NoteTemplatePo> getSendNoteTemplateCount();
	
	
	/**
	 * 获取短信模板数量
	 */
	public NoteTemplatePo getSendNoteTemplate(NoteTemplatePo po);
}
