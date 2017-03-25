package com.pengsheng.eims.system.dao.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.dao.BrankCardDao;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

/**
 * BrankCardDaoImpl 银行卡Dao实现类
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see BaseJdbcDaoSupport
 * @see BrankCardDao
 */
public class BrankCardDaoImpl extends BaseJdbcDaoSupport implements BrankCardDao {

	/**
	 * 删除银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void deleteBrankCard(BrankCardPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from B_BrankCard where  B_BC_ID = '"+Utility.getName(po.getBbcid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 银行卡数量
	 */
	public int getBrankCardCount(BrankCardPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_BC_ID)");
		buffer.append("   from B_BrankCard");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询银行卡ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardId(BrankCardPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_BC_ID)");
		buffer.append("   from B_BrankCard where B_BC_ID = '"+Utility.getName(po.getBbcid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 添加时查询银行卡名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardName(BrankCardPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_BC_ID)");
		buffer.append("   from B_BrankCard where B_BC_Name = '"+Utility.getName(po.getBbcname())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 添加时查询银行卡卡号是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardCardid(BrankCardPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_BC_ID)");
		buffer.append("   from B_BrankCard where B_BC_CardID = '"+Utility.getName(po.getBbccardid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 修改时查询银行卡名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardNameUpdate(BrankCardPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_BC_ID)");
		buffer.append("   from B_BrankCard where B_BC_Name = '"+Utility.getName(po.getBbcname())+"' and B_BC_ID <>  '"+Utility.getName(po.getBbcid())+"' ");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 修改时查询银行卡卡号是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardCardidUpdate(BrankCardPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_BC_ID)");
		buffer.append("   from B_BrankCard where B_BC_CardID = '"+Utility.getName(po.getBbccardid())+"' and B_BC_ID <>  '"+Utility.getName(po.getBbcid())+"' ");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 银行卡结果集
	 */
	public List getBrankCardList(BrankCardPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by B_BC_ID) as rowNum, B_BC_ID as bbcid,B_BC_Name as bbcname,B_BC_CardID as bbccardid,B_BC_PersonName as bbcpersonname from B_BrankCard");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				BrankCardPo.class);
	}

	/**
	 * 新增银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void insertBrankCard(BrankCardPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" INSERT INTO B_BrankCard");
		buffer.append("            ( B_BC_ID");
		buffer.append("            ,B_BC_Name");
		buffer.append("            ,B_BC_CardID");
		buffer.append("            ,B_BC_PersonName )");
		buffer.append("      VALUES");
		buffer.append("            ('"+Utility.getName(po.getBbcid())+"'");
		buffer.append("            ,'"+Utility.getName(po.getBbcname())+"'");
		buffer.append("            ,'"+Utility.getName(po.getBbccardid())+"'");
		buffer.append("            ,'"+Utility.getName(po.getBbcpersonname())+"')");
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 修改银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void updateBrankCard(BrankCardPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE B_BrankCard");
		buffer.append("    SET  B_BC_Name = '"+Utility.getName(po.getBbcname())+"'");
		buffer.append("    ,  B_BC_CardID = '"+Utility.getName(po.getBbccardid())+"'");
		buffer.append("    ,  B_BC_PersonName = '"+Utility.getName(po.getBbcpersonname())+"'");
		buffer.append("  WHERE  B_BC_ID = '"+Utility.getName(po.getBbcid())+"'");
	
		getJdbcTemplate().update(buffer.toString());
	}

	/**
	 * 查询银行卡在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardWithGoods(BrankCardPo po){
		StringBuffer buffer = new StringBuffer();
		//buffer.append(" select count(B_GI_frameProcessCraftType) from B_GoodsInfo");
		//buffer.append(" where B_GI_frameProcessCraftType = '"+Utility.getName(po.getFttid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	
	/**
	 * 查询银行卡在部门表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardDepartment(BrankCardPo po)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(B_DP_DepartmentID) from B_Departments ");
		buffer.append(" where B_DP_BankCard = '"+Utility.getName(po.getBbcid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}

	/**
	 * 查询银行卡的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 银行卡详细信息
	 */
	public BrankCardPo getBrankCardPo(BrankCardPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select top 1  B_BC_ID as bbcid,B_BC_Name as bbcname,B_BC_CardID as bbccardid,B_BC_PersonName as bbcpersonname from B_BrankCard");
		buffer.append(" where B_BC_ID = '"+Utility.getName(po.getBbcid())+"'");
		return (BrankCardPo) queryForObject(buffer.toString(), null, BrankCardPo.class);
	}
	
	public List getBrankCardList() {
        String sql="select B_BC_ID as bbcid,B_BC_Name as bbcname,B_BC_CardID as bbccardid,B_BC_PersonName as bbcpersonname from B_BrankCard ";
		return queryForObjectList(sql, null,BrankCardPo.class);
	}
	
	public List getBankList() {
        String sql="select B_B_UUID as bbuuid,B_B_Number as bbnumber, B_B_Name as bbname from B_Bank ";
		return queryForObjectList(sql, null,BankPo.class);
	}
	
	public List getOnlyBankList() {
        String sql="select B_B_UUID as bbuuid,B_B_Number as bbnumber, B_B_Name as bbname from B_Bank where B_B_NonCashType='2' ";
		return queryForObjectList(sql, null,BankPo.class);
	}
	
	public List getOtherBankList() {
        String sql="select B_B_UUID as bbuuid,B_B_Number as bbnumber, B_B_Name as bbname from B_Bank where B_B_NonCashType='9' ";
		return queryForObjectList(sql, null,BankPo.class);
	}
	
	public List<BankPo> getNonCashBankList() {
        String sql="select B_B_UUID as bbuuid,B_B_Number as bbnumber, B_B_Name as bbname,B_B_NonCashType as bbtype from B_Bank where B_B_NonCashType in ('2','9') ";
		return queryForObjectList(sql, null,BankPo.class);
	}
	
	/**
	 * 
	 * 银行的维护
	 * @param po 
	 * @return void
	 */
	
	public int selectBankCount(BankPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_B_UUID ) ");
		buffer.append("   from B_Bank");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public void deleteBankPo(BankPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" delete from B_Bank where B_B_UUID = '"+Utility.getName(po.getBbuuid())+"'");
		getJdbcTemplate().update(buffer.toString());
	}

	
	public void insertBankPo(BankPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into B_Bank ");
		buffer.append("(");
		buffer.append("B_B_UUID ");
		buffer.append(",B_B_Number  ");
		buffer.append(",B_B_Name,B_B_NonCashType,B_B_IsCountPerfrom ) ");
		buffer.append("values (");
		buffer.append("'" + this.uuid.generate() + "',");
		buffer.append("'" + po.getBbnumber()+ "',");
		buffer.append("'" + po.getBbname() + "',");		
		buffer.append("'" + Utility.getName(po.getBbtype()) + "',");
		buffer.append("'" + Utility.getName(po.getBbstatistics()) + "' ");
		
		buffer.append(")");

		getJdbcTemplate().update(buffer.toString());
	}
	
	public List<BankPo> selectBankList(BankPo po, int start, int size) {				
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select * from (");
		buffer.append(" select ROW_NUMBER() Over(order by  B_B_UUID) as rowNum, B_B_UUID as bbuuid, B_B_Number as bbnumber, B_B_Name as bbname,B_B_NonCashType as bbtype,B_B_IsCountPerfrom as bbstatistics from B_Bank");
		buffer.append(" ) table1 where rowNum >"+ start + " and rowNum <="+(start + size));
		return this.queryForObjectList(buffer.toString(), null,
				BankPo.class);
	}

	
	public BankPo selectBankPo(BankPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT top 1  ");
		buffer.append(" B_B_UUID as bbuuid, ");
		buffer.append(" B_B_Number as bbnumber, ");
		buffer.append(" B_B_Name as bbname,B_B_NonCashType as bbtype,B_B_IsCountPerfrom as bbstatistics ");
		buffer.append(" FROM B_Bank ");
		buffer.append(" WHERE ");
		buffer.append("B_B_UUID = '" + po.getBbuuid() + "'");
		return (BankPo)queryForObject(buffer.toString(), null, BankPo.class);
	}
	
	public int getBankPoId(BankPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_B_UUID )");
		buffer.append("   from B_Bank where B_B_Number = '"+Utility.getName(po.getBbnumber())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	public int getBankPoName(BankPo po) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_B_UUID )");
		buffer.append("   from B_Bank where B_B_Name = '"+Utility.getName(po.getBbname())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getBankPoIdUpdate(BankPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_B_UUID )");
		buffer.append("   from B_Bank where B_B_Number = '"+Utility.getName(po.getBbnumber())+"' and B_B_UUID <> '"+Utility.getName(po.getBbuuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public int getBankPoNameUpdate(BankPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count( B_B_UUID )");
		buffer.append("   from B_Bank where B_B_Name = '"+Utility.getName(po.getBbname())+"' and B_B_UUID <> '"+Utility.getName(po.getBbuuid())+"'");
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	public void updateBankPo(BankPo po) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" UPDATE B_Bank ");
		buffer.append("  SET  B_B_Number = '"+Utility.getName(po.getBbnumber())+"' , ");
		buffer.append(" B_B_Name = '"+Utility.getName(po.getBbname())+"' , ");
		buffer.append(" B_B_NonCashType = '"+Utility.getName(po.getBbtype())+"' , ");
		buffer.append(" B_B_IsCountPerfrom = '"+Utility.getName(po.getBbstatistics())+"' ");
		buffer.append("  WHERE B_B_UUID = '"+Utility.getName(po.getBbuuid())+"'");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
}
