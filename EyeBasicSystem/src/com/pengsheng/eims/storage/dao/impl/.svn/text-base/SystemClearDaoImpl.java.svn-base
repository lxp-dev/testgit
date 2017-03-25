package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.SystemClearDao;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;

public class SystemClearDaoImpl extends BaseJdbcDaoSupport implements
		SystemClearDao {
	
	/**
	 * 判断系统是否正式上线
	 * @return 0： 未上线    1 ：以上线
	 */
	public int isSystemOnLine(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(L_BFD_Date) from L_BFD_BalanceForwardDate where L_BFD_Flag='1' and convert(varchar(10),getdate(),120)>=L_BFD_Date and L_BFD_Date<>'' ");

		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 判断是否可以清除库存
	 * @return 0： 没有库存    >0 ：存在库存
	 */
	public int getStorageCount(){
		StringBuffer buffer = new StringBuffer();
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 清除库存(第一张)
	 * 
	 */
	public void deleteStorageData_Beginning(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from C_SH_StorageBeginning ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 清除库存(第三张)
	 * 
	 */
	public void deleteStorageData_Change(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from C_SH_StorageChange ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 清除库存(第四张)
	 * 
	 */
	public void deleteStorageData_Log(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from C_SH_StorageLog ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 根据商品的实盘数导入库存
	 * 
	 */
	public void insertStorageData(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("exec usp_UpdateStorageByCheck ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 删除系统正式上线日期
	 * 
	 */
	public void deleteSystemOnLineDate(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from L_BFD_BalanceForwardDate ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 更新系统正式上线日期
	 * 
	 */
	public void updateSystemOnLineDate(String systemOnLineDate){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("insert into L_BFD_BalanceForwardDate(L_BFD_Date,L_BFD_Flag) values(?,'1') ");
		
		params.add(systemOnLineDate);
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 更新系统正式上线日期(年份)
	 * 
	 */
	public void insertPayMentYear(String payMentYear){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update L_SA_SwitchAmount set L_SA_Year=? ");
		
		params.add(payMentYear);
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 更新系统正式上线日期(月份)
	 * 
	 */
	public void updatePayMentMonth(){
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("update L_SA_SwitchAmount set L_SA_CurrentMonth='0' ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 更新系统正式上线日期(月份)
	 * 
	 */
	public void insertPayMentMonth(String payMentMonth){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update L_SA_SwitchAmount set L_SA_CurrentMonth='1' where L_SA_Month=? ");
		
		params.add(payMentMonth);
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	/**
	 * 清除业务数据
	 * 
	 */
	public void deleteInventoryData(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("exec sp_clearDB ");
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 备份数据库
	 * 
	 */
	public void dataBaseBackup(String databaseName,String backupPath){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("exec createBackupDirectory '" + backupPath.replace("/","\\") + "' ");
		List<String> resultList = queryForObjectList(buffer.toString(),null,String.class);
		System.out.println(resultList.size() < 2 ? "目录已创建" : "目录已存在");
		
		buffer.setLength(0);
		backupPath = backupPath.replace("/","\\")+"\\"+ databaseName + this.uuid.generate() +"_backup.bak";		
		buffer.append("USE master Backup Database ? To disk= '" + backupPath + "' ");
		
		params.add(databaseName);		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
		
		buffer.setLength(0);		
		buffer.append("USE " + databaseName);
		
		getJdbcTemplate().update(buffer.toString());
	}
	
	/**
	 * 确定是否存在系统正式上线日期
	 * 
	 */
	public int getSystemOnLineDateCount(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select count(L_BFD_Date) from L_BFD_BalanceForwardDate where L_BFD_Flag='1' ");
		
		return getJdbcTemplate().queryForInt(buffer.toString());
	}
	
	/**
	 * 查询系统正式上线日期
	 * 
	 */
	public String getSystemOnLineDate(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select top 1 L_BFD_Date from L_BFD_BalanceForwardDate where L_BFD_Flag='1' ");
		
		return (String)getJdbcTemplate().queryForObject(buffer.toString(), null,String.class);
	}
	
	/**
	 * 查询当前账期
	 * 
	 */
	public String getCurrentPayMentDate(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("select top 1 (cast(L_SA_Year as varchar)+'-'+L_SA_Month) from L_SA_SwitchAmount where L_SA_CurrentMonth='1' ");
		
		return (String)getJdbcTemplate().queryForObject(buffer.toString(), null,String.class);
	}
}
