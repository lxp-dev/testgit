package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.UnitDao;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.NoteTypePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class UnitDaoImpl extends BaseJdbcDaoSupport implements
UnitDao {

	public void deleteUnit(UnitPo unitPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM B_Unit ");
		buffer.append("WHERE B_UT_id = ?");

		List<String> params = new ArrayList<String>();
		params.add(unitPo.getButid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public UnitPo getUnit(UnitPo unitPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  B_UT_id as butid ");
		buffer.append(",B_UT_unitName  as butunitname ");
		buffer.append("FROM B_Unit ");
		buffer.append("WHERE 1 = 1");

		List<String> params = new ArrayList<String>();

		if (!"".equals(Utility.getName(unitPo.getButid()))) {
			buffer.append(" AND B_UT_id = ?");
			params.add(unitPo.getButid());
		}
		

		return (UnitPo) queryForObject(buffer.toString(), params
				.toArray(), UnitPo.class);
	}

	public int getUnitName(UnitPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_UT_id)");
		buffer.append("   from B_Unit where B_UT_unitName = ? ");
		params.add(Utility.getName(po.getButunitname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public int getUnitNameUpdate(UnitPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_UT_id)");
		buffer.append("   from B_Unit where B_UT_unitName = ? and B_UT_id <> ? ");

		params.add(Utility.getName(po.getButunitname()));
		params.add(Utility.getName(po.getButid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public List<UnitPo> getUnitList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT B_UT_id as butid ");
		buffer.append(",B_UT_unitName  as butunitname ");
		buffer.append("FROM B_Unit ");

		return queryForObjectList(buffer.toString(), null, UnitPo.class);
	}
	
	public int getUnitCount() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_UT_id)");
		buffer.append("   from B_Unit");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}


	public List<UnitPo> getUnitsList(int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_UT_id) as rowNum, B_UT_id as butid,B_UT_unitName  as butunitname from B_Unit ");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				UnitPo.class);
	}
	

	public void insertUnit(UnitPo unitPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO B_Unit ");
		buffer.append("(B_UT_id ");
		buffer.append(",B_UT_unitName) ");
		buffer.append("VALUES (?,?)");

		List<String> params = new ArrayList<String>();
		params.add(unitPo.getButid());
		params.add(unitPo.getButunitname());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateUnit(UnitPo unitPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE B_Unit ");
		buffer.append("SET B_UT_unitName = ? ");
		buffer.append("WHERE B_UT_id = ?");

		List<String> params = new ArrayList<String>();

		params.add(unitPo.getButunitname());
		params.add(unitPo.getButid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getGoodsCount(UnitPo unitPo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("select count(b_gi_goodsid) from b_goodsinfo where 1=1 ");
		if(unitPo.getButid()!=null){
			sb.append(" and b_gi_unitid=?");
			params.add(unitPo.getButid());
		}
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}	
	
	/**
	 * 查询投诉信息	
	 */
	public List<ComplaintsTypePo> getComplaintsTypeList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_CT_ID as bctid,B_CT_Name as bctname from B_ComplaintsType ");

		return queryForObjectList(buffer.toString(), null, ComplaintsTypePo.class);
	}
	/**
	 * 查询投诉信息数量	
	 */
	public int getComplaintsTypesCount() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_CT_ID)");
		buffer.append("   from B_ComplaintsType");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询投诉信息	
	 */
	public List<ComplaintsTypePo> getComplaintsTypesList(int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_CT_ID) as rowNum, B_CT_ID as bctid,B_CT_Name as bctname from B_ComplaintsType");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				ComplaintsTypePo.class);
	}
	/**
	 * 判断投诉信息的编号是否存在
	 */
	public int isExistComplaintsType(ComplaintsTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_CT_ID) from B_ComplaintsType where B_CT_ID=? ");
		
		params.add(Utility.getName(po.getBctid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 添加时判断投诉类型名称是否存在
	 */
	public int getComplaintsTypeName(ComplaintsTypePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_CT_ID)");
		buffer.append("   from B_ComplaintsType where B_CT_Name = ? ");
		params.add(Utility.getName(po.getBctname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 修改时判断投诉类型名称是否存在
	 */
	public int getComplaintsTypeNameUpdate(ComplaintsTypePo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_CT_ID)");
		buffer.append("   from B_ComplaintsType where B_CT_Name = ? and B_CT_ID <> ? ");

		params.add(Utility.getName(po.getBctname()));
		params.add(Utility.getName(po.getBctid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 插入投诉信息	
	 */
	public void insertComplaintsType(ComplaintsTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_ComplaintsType(B_CT_ID,B_CT_Name) values(?,?) ");

		params.add(Utility.getName(po.getBctid()));
		params.add(Utility.getName(po.getBctname()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新投诉信息	
	 */
	public void updateComplaintsType(ComplaintsTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_ComplaintsType set B_CT_Name=? where B_CT_ID=? ");		
		
		params.add(Utility.getName(po.getBctname()));
		params.add(Utility.getName(po.getBctid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除投诉信息
	 */
	public void deleteComplaintsType(ComplaintsTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_ComplaintsType where B_CT_ID=? ");

		params.add(Utility.getName(po.getBctid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 投诉信息明细
	 */
	public ComplaintsTypePo getComplaintsTypeDetail(ComplaintsTypePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_CT_ID as bctid,B_CT_Name as bctname from B_ComplaintsType where B_CT_ID=? ");

		params.add(Utility.getName(po.getBctid()));

		return (ComplaintsTypePo) this.queryForObject(buffer.toString(), params.toArray(), ComplaintsTypePo.class);
	}
	
	/**
	 * 查询外来处方	
	 */
	public List<ForeignRecipelPo> getForeignRecipelList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_FR_ID as bfrid,B_FR_Name as bfrname from B_ForeignRecipel ");

		return queryForObjectList(buffer.toString(), null, ForeignRecipelPo.class);
	}
	/**
	 * 查询外来处方数量	
	 */
	public int getForeignRecipelsCount() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_FR_ID)");
		buffer.append("   from B_ForeignRecipel");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 查询外来处方	
	 */
	public List<ForeignRecipelPo> getForeignRecipelsList(int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_FR_ID) as rowNum, B_FR_ID as bfrid,B_FR_Name as bfrname from B_ForeignRecipel");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				ForeignRecipelPo.class);
	}
	
	
	/**
	 * 判断外来处方的编号是否存在
	 */
	public int isExistForeignRecipel(ForeignRecipelPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_FR_ID) from B_ForeignRecipel where B_FR_ID=? ");
		
		params.add(Utility.getName(po.getBfrid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 添加时判断外来处方名称是否存在
	 */
	public int getForeignRecipelName(ForeignRecipelPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_FR_ID)");
		buffer.append("   from B_ForeignRecipel where B_FR_Name = ? ");
		params.add(Utility.getName(po.getBfrname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 修改时判断外来处方名称是否存在
	 */
	public int getForeignRecipelNameUpdate(ForeignRecipelPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_FR_ID)");
		buffer.append("   from B_ForeignRecipel where B_FR_Name = ? and B_FR_ID <> ? ");
		params.add(Utility.getName(po.getBfrname()));
		params.add(Utility.getName(po.getBfrid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 插入外来处方	
	 */
	public void insertForeignRecipel(ForeignRecipelPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_ForeignRecipel(B_FR_ID,B_FR_Name) values(?,?) ");

		params.add(Utility.getName(po.getBfrid()));
		params.add(Utility.getName(po.getBfrname()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新外来处方	
	 */
	public void updateForeignRecipel(ForeignRecipelPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_ForeignRecipel set B_FR_Name=? where B_FR_ID=? ");		
		
		params.add(Utility.getName(po.getBfrname()));
		params.add(Utility.getName(po.getBfrid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除外来处方
	 */
	public void deleteForeignRecipel(ForeignRecipelPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_ForeignRecipel where B_FR_ID=? ");

		params.add(Utility.getName(po.getBfrid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}	
	
	/**
	 * 外来处方明细
	 */
	public ForeignRecipelPo getForeignRecipelDetail(ForeignRecipelPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_FR_ID as bfrid,B_FR_Name as bfrname from B_ForeignRecipel where B_FR_ID=? ");

		params.add(Utility.getName(po.getBfrid()));

		return (ForeignRecipelPo) this.queryForObject(buffer.toString(), params.toArray(), ForeignRecipelPo.class);
	}
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getNoteTemplateList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select cast(B_NT_TypeID as int) as paixu ,B_NT_TypeID as bnttypeid,B_NT_TypeName as bnttypename,B_NT_AutoSend as bnttypeautosend,(select count(B_NT_ID) from B_NoteTemplate where B_NT_Name=B_NT_TypeID) as bnttypecount from B_NoteType where B_NT_IsShow = 1 ");
		buffer.append(" order by paixu ");
		
		return queryForObjectList(buffer.toString(), null, NoteTemplatePo.class);
	}
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getAllNoteTemplateList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select cast(B_NT_TypeID as int) as paixu ,B_NT_TypeID as bnttypeid,B_NT_TypeName as bnttypename,B_NT_AutoSend as bnttypeautosend,(select count(B_NT_ID) from B_NoteTemplate where B_NT_Name=B_NT_TypeID) as bnttypecount from B_NoteType ");
		buffer.append("order by paixu ");

		return queryForObjectList(buffer.toString(), null, NoteTemplatePo.class);
	}
	
	/**
	 * 查询短信模板	
	 */
	public List<NoteTemplatePo> getNoteTemplateMinList(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select B_NT_ID as bntid,B_NT_Name as bntname,B_NT_Content as bntcontent,B_NT_AutoSend as bntautosend from B_NoteTemplate where B_NT_Name=? ");

		params.add(Utility.getName(po.getBntname()));
		
		return queryForObjectList(buffer.toString(), params.toArray(), NoteTemplatePo.class);
	}
	
	/**
	 * 插入短信模板	
	 */
	public void insertNoteTemplate(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		
		
		if(po.getBntname().equals("13"))
		{
			buffer.append("insert into B_NoteTemplate(B_NT_ID,B_NT_Name,B_NT_Content,B_NT_AutoSend,B_NT_daythrow,B_NT_daythrownumber,B_NT_weekthrow,B_NT_weekthrownumber,B_NT_biweeklythrow,B_NT_biweeklythrownumber,B_NT_monththrow,B_NT_monththrownumber,B_NT_seasonthrow,B_NT_seasonthrownumber,B_NT_halfyearthrow,B_NT_halfyearthrownumber,B_NT_yearthrow,B_NT_yearthrownumber,B_NT_rgpthrow,B_NT_rgpthrownumber,B_NT_sendtype,B_NT_sendtime,B_NT_sendhour) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			params.add(Utility.getName(po.getBntid()));		
			params.add(Utility.getName(po.getBntname()));
			params.add(Utility.getName(po.getBntcontent()));
			params.add(Utility.getName(po.getBntautosend()).equals("") ? "0" : "1");
			
			params.add(Utility.getName(po.getBntdaythrow()));
			params.add(Utility.getName(po.getBntdaythrownumber()));
			params.add(Utility.getName(po.getBntweekthrow()));
			params.add(Utility.getName(po.getBntweekthrownumber()));
			params.add(Utility.getName(po.getBntbiweeklythrow()));
			params.add(Utility.getName(po.getBntbiweeklythrownumber()));
			params.add(Utility.getName(po.getBntmonththrow()));
			params.add(Utility.getName(po.getBntmonththrownumber()));
			params.add(Utility.getName(po.getBntseasonthrow()));
			params.add(Utility.getName(po.getBntseasonthrownumber()));
			params.add(Utility.getName(po.getBnthalfyearthrow()));
			params.add(Utility.getName(po.getBnthalfyearthrownumber()));
			params.add(Utility.getName(po.getBntyearthrow()));
			params.add(Utility.getName(po.getBntyearthrownumber()));
			params.add(Utility.getName(po.getBntrgpthrow()));
			params.add(Utility.getName(po.getBntrgpthrownumber()));
			params.add(Utility.getName(po.getBntsendtype()));
			params.add(Utility.getName(po.getBntsendtime()));
			params.add(Utility.getName(po.getBntsendhour()));
		}else
		{
			buffer.append("insert into B_NoteTemplate(B_NT_ID,B_NT_Name,B_NT_Content,B_NT_AutoSend) values(?,?,?,?) ");
			params.add(Utility.getName(po.getBntid()));		
			params.add(Utility.getName(po.getBntname()));
			params.add(Utility.getName(po.getBntcontent()));
			params.add(Utility.getName(po.getBntautosend()).equals("") ? "0" : "1");
		}
		

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新短信模板	
	 */
	public void updateNoteTemplate(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_NoteTemplate set B_NT_AutoSend=? ");		
		params.add(Utility.getName(po.getBntautosend()).equals("") ? "0" : "1");
		
		if (!"".equals(Utility.getName(Utility.getName(po.getBntname())))){
			buffer.append(",B_NT_Name=? ");	
			params.add(Utility.getName(po.getBntname()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntcontent())))){
			buffer.append(",B_NT_Content=? ");	
			params.add(Utility.getName(po.getBntcontent()));
		}
		
		
		if (!"".equals(Utility.getName(Utility.getName(po.getBntdaythrow())))){
			buffer.append(",B_NT_daythrow=? ");	
			params.add(Utility.getName(po.getBntdaythrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntdaythrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBntdaythrownumber())))){
			buffer.append(",B_NT_daythrownumber	=? ");	
			params.add(Utility.getName(po.getBntdaythrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntweekthrow())))){
			buffer.append(",B_NT_weekthrow=? ");	
			params.add(Utility.getName(po.getBntweekthrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntweekthrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBntweekthrownumber())))){
			buffer.append(",B_NT_weekthrownumber=? ");	
			params.add(Utility.getName(po.getBntweekthrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntbiweeklythrow())))){
			buffer.append(",B_NT_biweeklythrow=? ");	
			params.add(Utility.getName(po.getBntbiweeklythrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntbiweeklythrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBntbiweeklythrownumber())))){
			buffer.append(",B_NT_biweeklythrownumber=? ");	
			params.add(Utility.getName(po.getBntbiweeklythrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntmonththrow())))){
			buffer.append(",B_NT_monththrow=? ");	
			params.add(Utility.getName(po.getBntmonththrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntmonththrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBntmonththrownumber())))){
			buffer.append(",B_NT_monththrownumber=? ");	
			params.add(Utility.getName(po.getBntmonththrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntseasonthrow())))){
			buffer.append(",B_NT_seasonthrow=? ");	
			params.add(Utility.getName(po.getBntseasonthrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntseasonthrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBntseasonthrownumber())))){
			buffer.append(",B_NT_seasonthrownumber=? ");	
			params.add(Utility.getName(po.getBntseasonthrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBnthalfyearthrow())))){
			buffer.append(",B_NT_halfyearthrow=? ");	
			params.add(Utility.getName(po.getBnthalfyearthrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBnthalfyearthrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBnthalfyearthrownumber())))){
			buffer.append(",B_NT_halfyearthrownumber=? ");	
			params.add(Utility.getName(po.getBnthalfyearthrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntyearthrow())))){
			buffer.append(",B_NT_yearthrow=? ");	
			params.add(Utility.getName(po.getBntyearthrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntyearthrow()))) && !"".equals(Utility.getName(Utility.getName(po.getBntyearthrownumber())))){
			buffer.append(",B_NT_yearthrownumber=? ");	
			params.add(Utility.getName(po.getBntyearthrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntrgpthrow())))){
			buffer.append(",B_NT_rgpthrow=? ");	
			params.add(Utility.getName(po.getBntrgpthrow()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntrgpthrow())))&&  !"".equals(Utility.getName(Utility.getName(po.getBntrgpthrownumber())))){
			buffer.append(",B_NT_rgpthrownumber=? ");	
			params.add(Utility.getName(po.getBntrgpthrownumber()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntsendtype())))){
			buffer.append(",B_NT_sendtype=? ");	
			params.add(Utility.getName(po.getBntsendtype()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntsendtime())))){
			buffer.append(",B_NT_sendtime=? ");	
			params.add(Utility.getName(po.getBntsendtime()));
		}
		if (!"".equals(Utility.getName(Utility.getName(po.getBntsendhour())))){
			buffer.append(",B_NT_sendhour=? ");	
			params.add(Utility.getName(po.getBntsendhour()));
		}
		
		buffer.append(" where B_NT_ID=? ");			
		params.add(Utility.getName(po.getBntid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 隐形商品使用提醒短信模板清空	
	 */
	public void updateNoteTemplateLens(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_NoteTemplate set B_NT_daythrow='' ");
		
			buffer.append(",B_NT_daythrownumber	='' ");					
			buffer.append(",B_NT_weekthrow='' ");	
			buffer.append(",B_NT_weekthrownumber='' ");	
			
			buffer.append(",B_NT_biweeklythrow='' ");	
			
			buffer.append(",B_NT_biweeklythrownumber='' ");	
			
			buffer.append(",B_NT_monththrow='' ");	
			
			buffer.append(",B_NT_monththrownumber='' ");	
			
			buffer.append(",B_NT_seasonthrow='' ");	
			
			buffer.append(",B_NT_seasonthrownumber='' ");	
			
			buffer.append(",B_NT_halfyearthrow='' ");	
			
			buffer.append(",B_NT_halfyearthrownumber='' ");	
			
			buffer.append(",B_NT_yearthrow='' ");	
			
			buffer.append(",B_NT_yearthrownumber='' ");	
			
			buffer.append(",B_NT_rgpthrow='' ");	
			
			buffer.append(",B_NT_rgpthrownumber='' ");	
		
							
		buffer.append(" where B_NT_ID=? ");			
		params.add(Utility.getName(po.getBntid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新短信模板	
	 */
	public void updateNoteAutoSend(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_NoteTemplate set B_NT_AutoSend=0 where B_NT_Name=? ");
		params.add(Utility.getName(po.getBntname()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 设置自动和默认发送短信	
	 */
	public void setNoteAutoSend(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("declare @count int select @count=count(B_NT_Name) from B_NoteTemplate where B_NT_AutoSend=1 and B_NT_Name=? ");		
		buffer.append("if @count = 0 begin update top (1) B_NoteTemplate set B_NT_AutoSend=1 where B_NT_Name=? end ");
		
		params.add(Utility.getName(po.getBntname()));
		params.add(Utility.getName(po.getBntname()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除短信模板
	 */
	public void deleteNoteTemplate(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_NoteTemplate where B_NT_ID=? ");

		params.add(Utility.getName(po.getBntid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 短信模板明细
	 */
	public NoteTemplatePo getNoteTemplateDetail(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_NT_IsShow as bntisshow,B_NT_daythrow as bntdaythrow,B_NT_daythrownumber as bntdaythrownumber,B_NT_weekthrow as bntweekthrow,B_NT_weekthrownumber as bntweekthrownumber " +
				",B_NT_biweeklythrow as bntbiweeklythrow ,B_NT_biweeklythrownumber as bntbiweeklythrownumber,B_NT_monththrow as bntmonththrow,B_NT_monththrownumber as bntmonththrownumber,B_NT_seasonthrow as bntseasonthrow,B_NT_seasonthrownumber as bntseasonthrownumber, B_NT_halfyearthrow as bnthalfyearthrow, B_NT_halfyearthrownumber as bnthalfyearthrownumber,B_NT_yearthrow as bntyearthrow,B_NT_yearthrownumber as bntyearthrownumber,B_NT_rgpthrow as bntrgpthrow,B_NT_rgpthrownumber as bntrgpthrownumber,B_NT_sendtype as bntsendtype,B_NT_sendtime as bntsendtime,B_NT_sendhour as bntsendhour," +
				"B_NT_ID as bntid,B_NT_Name as bntname2,B_NT_Content as bntcontent,B_NoteTemplate.B_NT_AutoSend as bntautosend,B_NT_TypeName as bntname,b_nt_typeid as bnttypeid from B_NoteTemplate left join B_NoteType on B_NT_Name=B_NT_TypeID where B_NT_ID=? ");

		params.add(Utility.getName(po.getBntid()));

		return (NoteTemplatePo) this.queryForObject(buffer.toString(), params.toArray(), NoteTemplatePo.class);
	}
	
	/**
	 * 查询短信模板开关状态
	 */
	public NoteTemplatePo getNoteTemplateType(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_NT_ID as bntid,B_NT_Name as bntname,B_NT_Content as bntcontent,B_NT_AutoSend as bntautosend from B_NoteTemplate ");
		buffer.append(" where B_NT_Name = ? ");
		buffer.append("   and B_NT_AutoSend = ? ");

		params.add(Utility.getName(po.getBntname()));
		params.add(Utility.getName(po.getBntautosend()));

		return (NoteTemplatePo) this.queryForObject(buffer.toString(), params.toArray(), NoteTemplatePo.class);
	}
	
	/**
	 * 查询短信类型开关状态
	 */
	public NoteTypePo getNoteTypePo(String id)
	{
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_NT_TypeID as bnttypeid,B_NT_TypeName as bnttypename,B_NT_AutoSend as bntautosend from B_NoteType ");
		buffer.append(" where B_NT_TypeID = ? ");

		params.add(Utility.getName(id));

		return (NoteTypePo) this.queryForObject(buffer.toString(), params.toArray(), NoteTypePo.class);
	}
	/**
	 * 查询折射率	
	 */
	public List<RefractiveSetPo> getRefractiveSetList(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select B_RF_ID as brfid,B_RF_Name as brfname from B_Refractive ");

		return queryForObjectList(buffer.toString(), null, RefractiveSetPo.class);
	}
	
	public int getRefractiveSetsCount() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_RF_ID)");
		buffer.append("   from B_Refractive");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}


	public List<RefractiveSetPo> getRefractiveSetsList(int start, int size) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_RF_ID) as rowNum,B_RF_ID as brfid,B_RF_Name as brfname from B_Refractive");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				RefractiveSetPo.class);
	}

	/**
	 * 判断折射率的编号是否存在
	 */
	public int isExistRefractiveSet(RefractiveSetPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(B_RF_ID) from B_Refractive where B_RF_ID=? ");
		
		params.add(Utility.getName(po.getBrfid()));
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 添加时判断折射率值是否存在
	 */
	public int getRefractiveName(RefractiveSetPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_RF_ID)");
		buffer.append("   from B_Refractive where B_RF_Name = ? ");
		params.add(Utility.getName(po.getBrfname()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	/**
	 * 修改时判断折射率值是否存在
	 */
	public int getRefractiveNameUpdate(RefractiveSetPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" select count(B_RF_ID)");
		buffer.append("   from B_Refractive where B_RF_Name = ? and B_RF_ID <> ? ");
		params.add(Utility.getName(po.getBrfname()));
		params.add(Utility.getName(po.getBrfid()));
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	/**
	 * 插入折射率	
	 */
	public void insertRefractiveSet(RefractiveSetPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into B_Refractive(B_RF_ID,B_RF_Name) values(?,?) ");

		params.add(Utility.getName(po.getBrfid()));
		params.add(Utility.getName(po.getBrfname()));


		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 更新折射率	
	 */
	public void updateRefractiveSet(RefractiveSetPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_Refractive set B_RF_Name=? where B_RF_ID=? ");		
		
		params.add(Utility.getName(po.getBrfname()));
		params.add(Utility.getName(po.getBrfid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除折射率
	 */
	public void deleteRefractiveSet(RefractiveSetPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from B_Refractive where B_RF_ID=? ");

		params.add(Utility.getName(po.getBrfid()));

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 折射率明细
	 */
	public RefractiveSetPo getRefractiveSetDetail(RefractiveSetPo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select top 1 B_RF_ID as brfid,B_RF_Name as brfname from B_Refractive where B_RF_ID=? ");

		params.add(Utility.getName(po.getBrfid()));

		return (RefractiveSetPo) this.queryForObject(buffer.toString(), params.toArray(), RefractiveSetPo.class);
	}
	
	/**
	 * 设置自动和默认发送短信	
	 */
	public void updateNoteTemplateAutoSend(NoteTemplatePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update B_NoteType set B_NT_AutoSend=? where B_NT_TypeID=? ");
		
		params.add(Utility.getName(po.getBnttypeautosend()));
		params.add(Utility.getName(po.getBnttypename()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	
}
