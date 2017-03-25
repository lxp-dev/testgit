package com.pengsheng.eims.storage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.dao.CheckStorageDao;
import com.pengsheng.eims.storage.persistence.CheckStorageEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragePo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CheckStorageDaoImpl extends

BaseJdbcDaoSupport implements CheckStorageDao {

	public void dropCheckBarcodeTable() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("IF (object_id('tempdb..#barcode') IS NOT NULL) ");
		buffer.append("DROP TABLE #barcode");

		this.getJdbcTemplate().update(buffer.toString());
	}

	public void createCheckBarcodeTable() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select top 0 * into #barcode ");
		buffer.append("from (select replace(NEWID(), '-', '') as BarCode) t");

		this.getJdbcTemplate().update(buffer.toString());
	}

	public void insertCheckBarcode(String barcode)

	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("insert into #barcode values (?)");

		this.getJdbcTemplate().update(buffer.toString(),
				new String[] { barcode });
	}

	public void insertCheckStorgeTemp(CheckStoragePo checkStoragePo) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO C_SH_CheckStorageTemp ");
		buffer.append("(C_SH_CST_BillId ");
		buffer.append(",C_SH_CST_CheckDate ");
		buffer.append(",C_SH_CST_CheckName ");
		buffer.append(",C_SH_CST_StockId ");
		buffer.append(",C_SH_CST_CheckStockPerson ");
		buffer.append(",C_SH_CST_AuditState ");
		buffer.append(",C_SH_CST_Remark ");
		buffer.append(",C_SH_CST_CategoryId) ");
		buffer.append("VALUES (?,getDate(),?,?,?,'0','',?) ");

		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(checkStoragePo.getCshcsbillid()));
		params.add(Utility.getName(checkStoragePo.getCshcscheckname()));
		params.add(Utility.getName(checkStoragePo.getCshcsstockid()));
		params.add(Utility.getName(checkStoragePo.getCshcscheckstockperson()));
		params.add(Utility.getName(checkStoragePo.getCshccategoryid()));
		
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void insertCheckStorgeTempEntry(
			CheckStorageEntryPo checkStorageEntryPo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into c_sh_checkstoragetempentry ");
		buffer.append("values ");
		buffer.append("(REPLACE(NEWID(), '-', ''),?,?,'',0,1,0,'') ");

		List<String> params = new ArrayList<String>();
		params.add(checkStorageEntryPo.getCshcsebillid());
		params.add(checkStorageEntryPo.getCshcsebarcode());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public List<CheckStoragePo> getCheckStorageTempList(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(" SELECT C_SH_CST_BillId as cshcsbillid, ");
		buffer.append("C_SH_CST_CheckDate as cshcscheckdate, ");
		buffer.append("C_SH_CST_CheckName as cshcscheckname, ");
		buffer.append("C_SH_CST_AuditState as cshcsauditstate, ");
		buffer.append("personName as cshcscheckstockpersonname, ");
		buffer.append("B_WH_warehouseName as cshcsstockname, ");
		buffer.append("B_GC_GoodsCategoryName as cshccategoryname ");
		buffer.append("FROM C_SH_CheckStorageTemp ");
		buffer.append("INNER JOIN SYS_PersonInfo ");
		buffer.append("ON C_SH_CST_CheckStockPerson = SYS_PersonInfo.ID ");
		buffer.append("left JOIN B_GoodsCategory ");
		buffer.append("ON C_SH_CST_CategoryId = B_GC_ID ");
		buffer.append("INNER JOIN B_Warehouse as cshcsstockidname ");
		buffer.append("ON C_SH_CST_StockId = B_WH_ID ");
		buffer.append("WHERE C_SH_CST_StockId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(checkStoragePo.getCshcsstockid());
		if(!"".equals(Utility.getName(checkStoragePo.getCshcsauditstate()))){
			buffer.append(" and C_SH_CST_AuditState = ? ");
			params.add(checkStoragePo.getCshcsauditstate());
		}
		if(!"".equals(Utility.getName(checkStoragePo.getCshcsbillid()))){
			buffer.append(" and C_SH_CST_BillId like '%'+?+'%' ");
			params.add(checkStoragePo.getCshcsbillid());
		}
		if(!"".equals(Utility.getName(checkStoragePo.getCshccategoryid()))){
			buffer.append(" and C_SH_CST_CategoryId =? ");
			params.add(checkStoragePo.getCshccategoryid());
		}

		return queryForObjectList(buffer.toString(), params.toArray(),
				CheckStoragePo.class);
	}

	public CheckStoragePo getCheckStorageTempPo(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT top 1  C_SH_CST_BillId as cshcsbillid, ");
		buffer.append("C_SH_CST_CheckDate as cshcscheckdate, ");
		buffer.append("C_SH_CST_CheckName as cshcscheckname, ");
		buffer.append("C_SH_CST_AuditState as cshcsauditstate, ");
		buffer.append("personName as cshcscheckstockpersonname, ");
		buffer.append("C_SH_CST_StockId as cshcsstockid, ");
		buffer.append("B_WH_warehouseName as cshcsstockname, ");
		buffer.append("B_GC_GoodsCategoryName as cshccategoryname ");
		buffer.append("FROM C_SH_CheckStorageTemp ");
		buffer.append("INNER JOIN SYS_PersonInfo ");
		buffer.append("ON C_SH_CST_CheckStockPerson = SYS_PersonInfo.ID ");
		buffer.append("INNER JOIN B_Warehouse ");
		buffer.append("ON C_SH_CST_StockId = B_WH_ID ");
		buffer.append("left JOIN B_GoodsCategory ");
		buffer.append("ON C_SH_CST_CategoryId = B_GC_ID ");
		buffer.append("WHERE C_SH_CST_BillId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(checkStoragePo.getCshcsbillid());

		return (CheckStoragePo) queryForObject(buffer.toString(), params
				.toArray(), CheckStoragePo.class);

	}

	public CheckStoragePo getCheckStoragePo(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT top 1  C_SH_CS_BillId as cshcsbillid, ");
		buffer.append("C_SH_CS_CheckDate as cshcscheckdate, ");
		buffer.append("C_SH_CS_CheckName as cshcscheckname, ");
		buffer.append("C_SH_CS_AuditState as cshcsauditstate, ");
		buffer.append("personName as cshcscheckstockpersonname, ");
		buffer.append("C_SH_CS_StockId as cshcsstockid, ");
		buffer.append("B_WH_warehouseName as cshcsstockname ");
		buffer.append("FROM C_SH_CheckStorage ");
		buffer.append("INNER JOIN SYS_PersonInfo ");
		buffer.append("ON C_SH_CS_CheckStockPerson = SYS_PersonInfo.ID ");
		buffer.append("INNER JOIN B_Warehouse ");
		buffer.append("ON C_SH_CS_StockId = B_WH_ID ");
		buffer.append("WHERE C_SH_CS_BillId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(checkStoragePo.getCshcsbillid());

		return (CheckStoragePo) queryForObject(buffer.toString(), params
				.toArray(), CheckStoragePo.class);

	}

	public int getCheckStorageCount(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT count(C_SH_CS_BillId) ");
		buffer.append("FROM C_SH_CheckStorage ");
		
		if (!"".equals(Utility.getName(checkStoragePo.getCshcscompanyid()))){
		    buffer.append(" inner join B_Warehouse on C_SH_CS_StockId = B_WH_ID inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}

		buffer.append("WHERE 1 = 1 ");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(checkStoragePo.getCshcscompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(checkStoragePo.getCshcscompanyid()));	
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsbillid()))) {
			buffer.append("and C_SH_CS_BillId= ? ");
			params.add(checkStoragePo.getCshcsbillid());
		}
		
		if (!"".equals(Utility.getName(checkStoragePo.getCshccategoryid()))) {			
			if(Utility.getName(checkStoragePo.getCshccategoryid()).equals("no")){//不限定类型，字段值为空
				buffer.append("and (C_SH_CS_CategoryId = '' or C_SH_CS_CategoryId is null ) ");		
			}else{
				buffer.append("and C_SH_CS_CategoryId = ? ");//quyanping
				params.add(checkStoragePo.getCshccategoryid());
			}
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsstockid()))) {
			buffer.append("and C_SH_CS_StockId = ? ");
			params.add(checkStoragePo.getCshcsstockid());
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsstarttime()))
				&& !""
						.equals(Utility.getName(checkStoragePo
								.getCshcsendtime()))) {
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) <= ? ");

			params.add(checkStoragePo.getCshcsstarttime());
			params.add(checkStoragePo.getCshcsendtime());
		} else if (!"".equals(Utility.getName(checkStoragePo
				.getCshcsstarttime()))
				&& "".equals(Utility.getName(checkStoragePo.getCshcsendtime()))) {
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) >= ? ");

			params.add(checkStoragePo.getCshcsstarttime());
		} else if ("".equals(Utility
				.getName(checkStoragePo.getCshcsstarttime()))
				&& !""
						.equals(Utility.getName(checkStoragePo
								.getCshcsendtime()))) {
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) <= ? ");

			params.add(checkStoragePo.getCshcsendtime());
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsauditstate()))) {
			buffer.append("and C_SH_CS_AuditState = ? ");
			params.add(checkStoragePo.getCshcsauditstate());
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsauditperson()))) {
			buffer.append("and C_SH_CS_AuditPerson = ? ");
			params.add(checkStoragePo.getCshcsauditperson());
		}

		if (!"".equals(Utility.getName(checkStoragePo
				.getCshcscheckstockperson()))) {
			buffer.append("and C_SH_CS_CheckStockPerson = ? ");
			params.add(checkStoragePo.getCshcscheckstockperson());
		}
		return getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());

	}

	public List<CheckStoragePo> getCheckStorageList(
			CheckStoragePo checkStoragePo, int start, int size) {
		StringBuffer buffer = new StringBuffer();

		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (select ROW_NUMBER() ");
		buffer.append("Over(order by C_SH_CS_CheckDate desc ) as 'rowNum', ");
		buffer.append("C_SH_CS_BillId as cshcsbillid, ");
		buffer.append("C_SH_CS_CheckDate as cshcscheckdate, ");
		buffer.append("C_SH_CS_CheckName as cshcscheckname, ");
		buffer.append("C_SH_CS_AuditState as cshcsauditstate, ");
		buffer.append("personName as cshcscheckstockpersonname, ");
		buffer.append("C_SH_CS_Overage as cshcsoverage, ");
		buffer.append("C_SH_CS_Losses as cshcslosses, ");
		buffer.append("C_SH_CS_StockId as cshcsstockid, ");
		buffer.append("B_WH_warehouseName as cshcsstockname, ");
		buffer.append("C_SH_CS_CategoryId as cshccategoryid, ");
		buffer.append("B_GC_GoodsCategoryName as cshccategoryname, ");
		buffer.append("B_WH_deptID as cshcsdepartmentid ");
		buffer.append("FROM C_SH_CheckStorage ");
		buffer.append("INNER JOIN SYS_PersonInfo ");
		buffer.append("ON C_SH_CS_CheckStockPerson = SYS_PersonInfo.ID ");
		buffer.append("INNER JOIN B_Warehouse ");
		buffer.append("ON C_SH_CS_StockId = B_WH_ID ");
		buffer.append("LEFT JOIN B_GoodsCategory ");
		buffer.append("ON C_SH_CS_CategoryId = B_GC_ID ");

		if (!"".equals(Utility.getName(checkStoragePo.getCshcscompanyid()))){
		    buffer.append(" inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		}

		buffer.append("WHERE 1 = 1 ");

		List<String> params = new ArrayList<String>();
		
		if (!"".equals(Utility.getName(checkStoragePo.getCshcscompanyid()))){
		    buffer.append(" and B_DP_CompanysID = ? ");
			params.add(Utility.getName(checkStoragePo.getCshcscompanyid()));	
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsbillid()))) {
			buffer.append("and C_SH_CS_BillId= ? ");
			params.add(checkStoragePo.getCshcsbillid());
		}
		
		if (!"".equals(Utility.getName(checkStoragePo.getCshccategoryid()))) {
			if(Utility.getName(checkStoragePo.getCshccategoryid()).equals("no")){//不限定类型，字段值为空
				buffer.append("and (C_SH_CS_CategoryId = '' or C_SH_CS_CategoryId is null ) ");		
			}else{
				buffer.append("and C_SH_CS_CategoryId = ? ");//quyanping
				params.add(checkStoragePo.getCshccategoryid());
			}
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsstockid()))) {
			buffer.append("and C_SH_CS_StockId = ? ");
			params.add(checkStoragePo.getCshcsstockid());
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsstarttime()))
				&& !""
						.equals(Utility.getName(checkStoragePo
								.getCshcsendtime()))) {
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) <= ? ");

			params.add(checkStoragePo.getCshcsstarttime());
			params.add(checkStoragePo.getCshcsendtime());
		} else if (!"".equals(Utility.getName(checkStoragePo
				.getCshcsstarttime()))
				&& "".equals(Utility.getName(checkStoragePo.getCshcsendtime()))) {
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) >= ? ");

			params.add(checkStoragePo.getCshcsstarttime());
		} else if ("".equals(Utility
				.getName(checkStoragePo.getCshcsstarttime()))
				&& !""
						.equals(Utility.getName(checkStoragePo
								.getCshcsendtime()))) {
			buffer
					.append("and convert(varchar(10), C_SH_CS_CheckDate, 23) <= ? ");

			params.add(checkStoragePo.getCshcsendtime());
		}

		if (!"".equals(Utility.getName

		(checkStoragePo.getCshcsauditstate()))) {
			buffer.append("and C_SH_CS_AuditState = ? ");
			params.add(checkStoragePo.getCshcsauditstate());
		}

		buffer.append(") table1 where rowNum > ");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				CheckStoragePo.class);
	}

	public int getCheckStorageTempEntryCount(CheckStoragePo checkStoragePo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select count(table1.countNumber) from ");
		buffer.append("(select count(C_SH_CSTE_BarCode) as countNumber from C_SH_CheckStorageTempEntry where C_SH_CSTE_BillId = ? group by C_SH_CSTE_BarCode)table1");

		List<String> params = new ArrayList<String>();
		params.add(checkStoragePo.getCshcsbillid());

		return this.getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	public List<CheckStorageEntryPo> getCheckStorageTempEntryList(CheckStoragePo checkStoragePo,

	int start, int size) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from ( ");
		buffer
				.append(" select ROW_NUMBER() Over(order by CheckNumberTable.B_GI_GoodsID ) as 'rowNum',  ");
		buffer.append(" isnull(CheckNumberTable.B_GI_GoodsID,'错误条码不能正常导入') as cshcsegoodsid, ");
		buffer.append(" CheckNumberTable.C_SH_CSTE_BarCode as cshcsebarcode, ");
		buffer.append(" isnull(CheckNumberTable.B_GI_GoodsName,'--') as cshcsegoodsname, ");
		buffer.append(" isnull(CheckNumberTable.B_GI_Spec,'--') as cshcsespec,  ");
		buffer.append(" isnull(CheckNumberTable.B_UT_unitName,'--') as cshcseunitname, ");
		buffer.append(" isnull(BookNumberTable.BookNumber,0) as cshcsebooknumber, ");
		buffer.append(" isnull(CheckNumberTable.CheckNumber,0) as cshcsechecknumber, ");
		buffer.append(" isnull((BookNumberTable.BookNumber - CheckNumberTable.CheckNumber),0) as cshcsesurplusnumber ");
		buffer.append(" from  (select C_SH_CSTE_BarCode, ");
		buffer.append(" B_GI_GoodsID, ");
		buffer.append(" B_GI_GoodsName, ");
		buffer.append(" B_GI_Spec, ");
		buffer.append(" B_UT_unitName, ");
		buffer.append(" sum(C_SH_CSTE_CheckNumber) as CheckNumber ");
		buffer.append(" from C_SH_CheckStorageTempEntry ");
		buffer
				.append(" inner join C_SH_CheckStorageTemp on C_SH_CSTE_BillId = C_SH_CST_BillId ");
		buffer
				.append(" left join B_GoodsInfo on substring(C_SH_CSTE_BarCode,1,18) = B_GI_GoodsBarCode ");
		buffer.append(" left join B_Unit on B_GI_UnitId = B_UT_id ");
		buffer.append(" where C_SH_CSTE_BillId = ? ");
		buffer.append(" and C_SH_CST_StockId = ? ");
		buffer
				.append(" group by C_SH_CSTE_BarCode,B_GI_GoodsID,B_GI_GoodsName,B_GI_Spec,B_UT_unitName) as CheckNumberTable  ");
		buffer.append(" left join  ");
		buffer.append(" (select C_SH_SL_GoodsBarCode, ");
		buffer.append(" sum(C_SH_SL_GoodsQuantity) as BookNumber ");
		buffer.append(" from C_SH_StorageLog ");
		buffer.append(" where C_SH_SL_StockId = ? ");
		buffer.append(" group by C_SH_SL_GoodsBarCode) BookNumberTable ");
		buffer
				.append(" on CheckNumberTable.C_SH_CSTE_BarCode = BookNumberTable.C_SH_SL_GoodsBarCode ");
		buffer.append(" ) table1 where rowNum >");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");
		params.add(checkStoragePo.getCshcsbillid());
		params.add(checkStoragePo.getCshcsstockid());
		params.add(checkStoragePo.getCshcsstockid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				CheckStorageEntryPo.class);
	}

	public void auditCheckStorageTemp(String buildid) {
		StringBuffer buffer = new

		StringBuffer();
		buffer.append("UPDATE C_SH_CheckStorageTemp ");
		buffer.append("SET C_SH_CST_AuditState = 1 ");
		buffer.append("WHERE C_SH_CST_BillId = ? ");

		List<String> params = new

		ArrayList<String>();
		params.add(buildid);

		this.getJdbcTemplate().update

		(buffer.toString(), params.toArray());
	}

	public void delCheckStorageTemp(String buildid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_SH_CheckStorageTemp ");
		buffer.append("WHERE C_SH_CST_BillId = ?");

		List<String> params = new ArrayList<String>();
		params.add(buildid);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void delCheckStorageTempEntry(String buildid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_SH_CheckStorageTempEntry ");
		buffer.append("WHERE C_SH_CSTE_BillId = ?");

		List<String> params = new ArrayList<String>();
		params.add(buildid);
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 汇总删除临时盘点单
	 * 
	 * @param buildid
	 */
	public void delCheckStorageTempSum(String buildid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_SH_CheckStorageTemp ");
		buffer.append("where c_sh_cst_stockid =  ");
		buffer.append("(select c_sh_cs_stockid from C_SH_CheckStorage ");
		buffer.append("where c_sh_cs_billid = ? ) ");
		buffer.append("and C_SH_CST_CategoryId = ");
		buffer.append("(select C_SH_CS_CategoryId from C_SH_CheckStorage ");
		buffer.append("where c_sh_cs_billid = ? ) ");

		List<String> params = new ArrayList<String>();
		params.add(buildid);
		params.add(buildid);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 汇总删除临时盘点明细单
	 * 
	 * @param buildid
	 */
	public void delCheckStorageTempEntrySum(String buildid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_SH_CheckStorageTempEntry ");
		buffer.append("where C_SH_CSTE_BillId in (SELECT ");
		buffer.append("C_SH_CST_BillId FROM C_SH_CheckStorageTemp ");
		buffer.append("where c_sh_cst_stockid = ");
		buffer.append("(select c_sh_cs_stockid from C_SH_CheckStorage ");
		buffer.append("where c_sh_cs_billid = ? ) ");
		
		buffer.append("and C_SH_CST_CategoryId = ");
		buffer.append("(select C_SH_CS_CategoryId from C_SH_CheckStorage ");
		buffer.append("where c_sh_cs_billid = ? )) ");

		List<String> params = new ArrayList<String>();
		params.add(buildid);
		params.add(buildid);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void buildCheckStorage(CheckStoragePo checkStoragePo,
			String... buildids) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" insert into C_SH_CheckStorage ");
		buffer.append(" (C_SH_CS_BillId,C_SH_CS_CheckDate, ");
		buffer.append("	C_SH_CS_CheckName,C_SH_CS_StockId, ");
		buffer.append(" C_SH_CS_CheckStockPerson,C_SH_CS_AuditState, ");
		buffer.append(" C_SH_CS_AuditDate,C_SH_CS_AuditPerson, ");
		buffer.append(" C_SH_CS_Remark,C_SH_CS_CategoryId");
		buffer.append(" ) select top 1 ?, ");
		buffer.append(" getDate(),B_WH_warehouseName+convert(varchar(20),getdate(),23), ");
		buffer.append(" C_SH_CST_StockId,C_SH_CST_CheckStockPerson, ");
		buffer.append(" '0',C_SH_CST_AuditDate, ");
		buffer.append(" C_SH_CST_AuditPerson,C_SH_CST_Remark,C_SH_CST_CategoryId");
		buffer.append(" from C_SH_CheckStoragetemp ");
		buffer.append(" inner join B_Warehouse on b_wh_id = C_SH_CST_StockId ");
		buffer.append(" where  ");
		buffer.append("  c_sh_cst_stockid = ? and C_SH_CST_CategoryId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(checkStoragePo.getCshcsbillid());
		params.add(checkStoragePo.getCshcsstockid());
		params.add(checkStoragePo.getCshccategoryid());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 获取当天仓位盘点主表数量
	 * 
	 * sxh 2011-5-30
	 */
	public int buildCheckStorageCount(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append("select count(*) from C_SH_CheckStorage ");
		buffer
				.append("where convert(varchar(20),C_SH_CS_CheckDate,23) = convert(varchar(20),getdate(),23) ");
		buffer.append("and c_sh_cs_auditstate <> '1' and C_SH_CS_CategoryId = ? ");
		buffer.append("and c_sh_cs_stockid= ? ");
		
		params.add(checkStoragePo.getCshccategoryid());
		params.add(checkStoragePo.getCshcsstockid());
		
		return this.getJdbcTemplate().queryForInt(buffer.toString(),
				params.toArray());
	}

	/**
	 * 删除当天仓位重复盘点主表
	 * 
	 * sxh 2011-5-30
	 */

	public void deleteDoubleCheckStorage(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from C_SH_CheckStorage ");
		buffer.append("where  convert(varchar(20),C_SH_CS_CheckDate,23) = convert(varchar(20),getdate(),23) ");
		buffer.append("and c_sh_cs_auditstate <> '1' ");
		buffer.append("and c_sh_cs_stockid= ? and C_SH_CS_CategoryId = ? ");

		params.add(checkStoragePo.getCshcsstockid());
		params.add(checkStoragePo.getCshccategoryid());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 删除当天仓位重复盘点详细表
	 * 
	 * sxh 2011-5-30
	 */
	public void deleteDoubleCheckStorageEntry(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from C_SH_CheckStorageEntry ");
		buffer.append("where C_SH_CSE_BillId = (select C_SH_CS_BillId from C_SH_CheckStorage ");
		buffer.append("where convert(varchar(20),C_SH_CS_CheckDate,23) = convert(varchar(20),getdate(),23) ");
		buffer.append("and c_sh_cs_auditstate <> '1' ");
		buffer.append("and c_sh_cs_stockid= ? and C_SH_CS_CategoryId = ? )");

		params.add(checkStoragePo.getCshcsstockid());
		params.add(checkStoragePo.getCshccategoryid());
		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void buildCheckStorageEntry(CheckStoragePo checkStoragePo,
			String... buildids) {
		List<String> params = new ArrayList<String>();
		StringBuffer varname1 = new StringBuffer();

		varname1.append(" insert into C_SH_CheckStorageEntry ");
		varname1.append(" (C_SH_CSE_ID, ");
		varname1.append(" C_SH_CSE_BillId, ");
		varname1.append(" C_SH_CSE_BarCode, ");
		varname1.append(" C_SH_CSE_GoodsId, ");
		varname1.append(" C_SH_CSE_BookNumber, ");
		varname1.append(" C_SH_CSE_CheckNumber, ");
		varname1.append(" C_SH_CSE_surplusNumber)  ");
		varname1.append(" SELECT REPLACE(NEWID(), '-', ''), ");
		varname1.append("                       ?, ");
		params.add(checkStoragePo.getCshcsbillid());
		varname1.append("                      barCode, ");
		varname1.append("                      '', ");
		varname1.append("              isnull(bookNum.BookNumber,0), ");
		varname1.append("            isnull(checkNum.CheckNumber,0), ");
		varname1
				.append(" isnull(checkNum.CheckNumber,0)-isnull(bookNum.BookNumber,0) ");
		varname1.append(" FROM   (SELECT barCode ");
		varname1.append("        FROM   (SELECT C_SH_CStE_BarCode AS barCode ");
		varname1.append("                FROM  C_SH_CheckStoragetempEntry ");
		varname1.append("                where C_SH_CSTE_BillId in ( ");
		String param = new String();
		for (String buildID : buildids) {
			param += "?,";
			params.add(buildID);
		}
		param = param.replaceFirst(",$", "");
		varname1.append(param + " ) ");
		varname1.append("                UNION ALL ");
		varname1
				.append("                SELECT C_SH_SL_GoodsBarCode AS barCode ");
		varname1.append("                FROM  C_SH_StorageLog ");
		varname1.append("                WHERE  C_SH_SL_StockId = ? and ");
		params.add(checkStoragePo.getCshcsstockid());
		varname1
				.append("                       Substring(C_SH_SL_GoodsId, 3, 2) <> 'ZZ' )BarCode ");
		varname1.append("        GROUP  BY barCode ) BarCodeTemp ");
		varname1
				.append("       LEFT JOIN (SELECT C_SH_CStE_BarCode          AS C_SH_CStE_BarCode, ");
		varname1
				.append("                      SUM(C_SH_CStE_CheckNumber) AS CheckNumber ");
		varname1.append("                  FROM   C_SH_CheckStoragetempEntry ");
		varname1
				.append("                      INNER JOIN C_SH_CheckStoragetemp ");
		varname1
				.append("                           ON C_SH_CStE_BillId = C_SH_CSt_BillId ");
		varname1.append("                  where  C_SH_CStE_BillId in ( ");
		String param1 = new String();
		for (String buildID : buildids) {
			param1 += "?,";
			params.add(buildID);
		}
		param1 = param1.replaceFirst(",$", "");
		varname1.append(param1 + " ) ");
		varname1
				.append("                  GROUP  BY C_SH_CStE_BarCode) checkNum ");
		varname1
				.append("         ON BarCodeTemp.barCode = checkNum.C_SH_CStE_BarCode ");
		varname1
				.append("       LEFT JOIN (SELECT C_SH_SL_GoodsBarCode       AS C_SH_SL_GoodsBarCode, ");
		varname1
				.append("                         SUM(C_SH_SL_GoodsQuantity) AS BookNumber ");
		varname1.append("                  FROM   C_SH_StorageLog ");
		varname1
				.append("                  WHERE  C_SH_SL_StockId = ? and Substring(C_SH_SL_GoodsId, 3, 2) <> 'ZZ' ");
		params.add(checkStoragePo.getCshcsstockid());
		varname1
				.append("                  GROUP  BY C_SH_SL_GoodsBarCode ) bookNum ");
		varname1
				.append("         ON BarCodeTemp.barCode = bookNum.C_SH_SL_GoodsBarCode ");
		
		varname1
				.append("Where (Isnull(checkNumber, 0) > 0 OR Isnull(bookNumber, 0) <> 0)");

		if (!Utility.getName(checkStoragePo.getCshccategoryid()).equals("")){
			varname1.append(" and substring(barCode,1,1) = ? ");
			params.add(checkStoragePo.getCshccategoryid());
		}
		
		this.getJdbcTemplate().update(varname1.toString(), params.toArray());	
	}

	public void auditCheckStorage(CheckStoragePo checkStoragePo,
			String buillid, String personid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update C_SH_CheckStorage set ");
		buffer.append("C_SH_CS_AuditState = 1, ");
		buffer.append("C_SH_CS_AuditDate = GETDATE(), ");
		buffer.append("C_SH_CS_AuditPerson = ?, ");
		buffer.append("C_SH_CS_Overage = ");
		buffer.append("(SELECT CASE ");
		buffer.append("         WHEN COUNT(CheckNumberTable.pynum) > 0 THEN 0 ");
		buffer.append("         ELSE 1 ");
		buffer.append("       END ");
		buffer.append("FROM   (SELECT C_SH_CSE_BarCode, ");
		buffer.append("               Isnull(SUM(C_SH_CSE_CheckNumber), 0) - Isnull(SUM(C_SH_CSE_bookNumber), 0) AS pynum ");
		buffer.append("        FROM   C_SH_CheckStorageEntry ");
		buffer.append("               LEFT JOIN C_SH_CheckStorage ");
		buffer.append("                 ON C_SH_CSE_BillId = C_SH_CS_BillId ");
		buffer.append("				  inner join B_GoodsInfo on substring(C_SH_CSE_BarCode,1,18) = B_GI_GoodsBarCode ");
		buffer.append("        WHERE  C_SH_CSE_BillId = ? ");
		buffer.append("               AND C_SH_CS_StockId = ? ");
		buffer.append("        GROUP  BY C_SH_CSE_BarCode) AS CheckNumberTable ");
		buffer.append("WHERE  CheckNumberTable.pynum > 0");
		buffer.append("), ");
		buffer.append("C_SH_CS_Losses = (");
		buffer.append("SELECT CASE ");
		buffer.append("         WHEN COUNT(CheckNumberTable.pynum) > 0 THEN 0 ");
		buffer.append("         ELSE 1 ");
		buffer.append("       END ");
		buffer.append("FROM   (SELECT C_SH_CSE_BarCode, ");
		buffer.append("               Isnull(SUM(C_SH_CSE_CheckNumber), 0) - Isnull(SUM(C_SH_CSE_bookNumber), 0) AS pynum ");
		buffer.append("        FROM   C_SH_CheckStorageEntry ");
		buffer.append("               LEFT JOIN C_SH_CheckStorage ");
		buffer.append("                 ON C_SH_CSE_BillId = C_SH_CS_BillId ");
		buffer.append("				  inner join B_GoodsInfo on substring(C_SH_CSE_BarCode,1,18) = B_GI_GoodsBarCode ");
		buffer.append("        WHERE  C_SH_CSE_BillId = ? ");
		buffer.append("               AND C_SH_CS_StockId = ? ");
		buffer.append("        GROUP  BY C_SH_CSE_BarCode) AS CheckNumberTable ");
		buffer.append(" WHERE  CheckNumberTable.pynum < 0 )");
		buffer.append(" where C_SH_CS_BillId = ? ");

		List<String> params = new ArrayList<String>();
		params.add(personid);
		params.add(buillid);
		params.add(checkStoragePo.getCshcsstockid());
		params.add(buillid);
		params.add(checkStoragePo.getCshcsstockid());
		params.add(buillid);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void updateCheckStorageSCISCO(CheckStoragePo checkStoragePo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("update C_SH_CheckStorage set ");

		if (!"".equals(Utility.getName(checkStoragePo.getCshcsoverage()))) {
			buffer.append("C_SH_CS_Overage = ?, ");
			params.add(checkStoragePo.getCshcsoverage());
		} else {
			buffer.append("C_SH_CS_Overage = C_SH_CS_Overage, ");
		}

		if (!"".equals(Utility.getName(checkStoragePo.getCshcslosses()))) {
			buffer.append("C_SH_CS_Losses = ? ");
			params.add(checkStoragePo.getCshcslosses());
		} else {
			buffer.append("C_SH_CS_Losses = C_SH_CS_Losses ");
		}
		buffer.append("where C_SH_CS_BillId = ? ");

		params.add(checkStoragePo.getCshcsbillid());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void delCheckStorage(String buildid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_SH_CheckStorage ");
		buffer.append("WHERE C_SH_CS_BillId = ?");

		List<String> params = new ArrayList<String>();
		params.add(buildid);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void delCheckStorageEntry(String buildid) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM C_SH_CheckStorageEntry ");
		buffer.append("WHERE C_SH_CSE_BillId = ?");

		List<String> params = new ArrayList<String>();
		params.add(buildid);

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public int getCheckStorageEntryCount(CheckStoragePo checkStoragePo) { 
		StringBuffer buffer = new StringBuffer(); 

		buffer.append(" select count(goodsID) from ("); 
		buffer.append("SELECT C_SH_CSE_BarCode as barcode, "); 
		buffer.append("B_GI_GoodsID as goodsID, "); 
		buffer.append(" SUM(C_SH_CSE_CheckNumber) as checknumber, "); 
		buffer.append(" SUM(C_SH_CSE_BookNumber) as booknumber "); 
		buffer.append("FROM C_SH_CheckStorageEntry "); 
		buffer.append(" LEFT JOIN C_SH_CheckStorage "); 
		buffer.append(" ON C_SH_CSE_BillId = C_SH_CS_BillId "); 
		buffer.append(" INNER JOIN B_GoodsInfo "); 
		buffer.append(" ON B_GI_GoodsBarCode = Substring(C_SH_CSE_BarCode, 1, 18) "); 
		buffer.append("WHERE C_SH_CSE_BillId = ? "); 
		buffer.append(" AND C_SH_CS_StockId = ? "); 
		buffer.append("GROUP BY B_GI_GoodsID,C_SH_CSE_BarCode ) table1 "); 

		List<String> params = new ArrayList<String>(); 
		params.add(checkStoragePo.getCshcsbillid()); 
		params.add(checkStoragePo.getCshcsstockid()); 
		return this.getJdbcTemplate().queryForInt(buffer.toString(), params.toArray()); 
		}

	public List<CheckStorageEntryPo> getCheckStorageEntryList(
			CheckStoragePo checkStoragePo, int start, int size) {
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * ");
		buffer.append("FROM   (SELECT Row_number() OVER(ORDER BY B_GI_GoodsID ) AS 'rowNum', ");
		buffer.append("               B_GI_GoodsID                              AS cshcsegoodsid, ");
		buffer.append("               C_SH_CSE_BarCode                          AS cshcsebarcode, ");
		buffer.append("               B_GI_Goodsname                            AS cshcsegoodsname, ");
		buffer.append("               B_GI_Spec                                 AS cshcsespec, ");
		buffer.append("               B_UT_unitName                             AS cshcseunitname, ");
		buffer.append("               SUM(Isnull(C_SH_CSE_CheckNumber, 0))      AS cshcsechecknumber, ");
		buffer.append("               SUM(Isnull(C_SH_CSE_BookNumber, 0))       AS cshcsebooknumber, ");
		buffer.append("               SUM(Isnull(C_SH_CSE_surplusNumber, 0))    AS cshcsesurplusnumber ");
		buffer.append("        FROM   C_SH_CheckStorageEntry ");
		buffer.append("               LEFT JOIN C_SH_CheckStorage ");
		buffer.append("                 ON C_SH_CSE_BillId = C_SH_CS_BillId ");
		buffer.append("               INNER JOIN B_GoodsInfo ");
		buffer.append("                 ON B_GI_GoodsBarCode = Substring(C_SH_CSE_BarCode, 1, 18) ");
		buffer.append("               LEFT JOIN B_Unit ");
		buffer.append("                 ON B_GI_UnitId = B_UT_id ");
		buffer.append("        WHERE  C_SH_CSE_BillId = ? ");
		buffer.append("               AND C_SH_CS_StockId = ? ");
		buffer.append("        GROUP  BY C_SH_CSE_BarCode, ");
		buffer.append("                  B_GI_GoodsID, ");
		buffer.append("                  B_GI_Goodsname, ");
		buffer.append("                  B_GI_Spec, ");
		buffer.append("                  B_UT_unitName ");
		buffer.append(" ) table1 where rowNum >");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append("set rowcount 0");

		params.add(checkStoragePo.getCshcsbillid());
		params.add(checkStoragePo.getCshcsstockid());

		return queryForObjectList(buffer.toString(), params.toArray(),CheckStorageEntryPo.class);
	}

	public void buildSCISCO(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO C_ST_Inventory( ");
		buffer.append("C_ST_I_BillTypeId ");
		buffer.append(",C_ST_I_BillID ");
		buffer.append(",C_ST_I_SourceBillId ");
		buffer.append(",C_ST_I_billDate ");
		buffer.append(",C_ST_I_DepartmentId ");
		buffer.append(",C_ST_I_createPerson ");
		buffer.append(",C_ST_I_InStockId ");
		buffer.append(",C_ST_I_OutStockId ");
		buffer.append(",C_ST_I_AuditPerson ");
		buffer.append(",C_ST_I_AuditState ");
		buffer.append(",C_ST_I_GoodsCategory) ");
		buffer.append("SELECT ?, ?, C_SH_CS_BillId, ");
		buffer.append("GETDATE(), ");
		buffer.append("(select B_WH_deptID from B_Warehouse ");
		buffer.append("where B_WH_ID = ?) ");
		buffer.append("as C_ST_I_DepartmentId,? ");
		buffer.append(", CASE ? WHEN 5 THEN C_SH_CS_StockId END /* 盘盈仓库*/");
		buffer.append(", CASE ? WHEN 6 THEN C_SH_CS_StockId END /* 盘亏仓库*/ ");
		buffer.append(", '', 0,C_SH_CS_CategoryId ");
		buffer.append("FROM C_SH_CheckStorage where C_SH_CS_BillId = ?");

		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibilltypeid()); // 5、盘盈单 SCI；6、盘亏单 SCO
		params.add(inventoryPo.getCstibillid());// 单号
		params.add(inventoryPo.getCstioutstockid());
		params.add(inventoryPo.getCsticreateperson());
		params.add(inventoryPo.getCstibilltypeid());
		params.add(inventoryPo.getCstibilltypeid());
		params.add(inventoryPo.getCstisourcebillid());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public void buildSCISCOEntry(InventoryPo inventoryPo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO C_ST_InventoryEntry( ");
		buffer.append("C_ST_IE_ID ");
		buffer.append(",C_ST_IE_BillID	/*单号*/ ");
		buffer.append(",C_ST_IE_GoodsId /*代码*/");
		buffer.append(",C_ST_IE_GoodsQuantity/*数量*/ ");
		buffer.append(",C_ST_IE_NotTaxRate	/*单位成本*/ ");
		buffer.append(",C_ST_IE_NotTaxRateAmount/*成本合计*/ ");
		buffer.append(",C_ST_IE_TaxRate/*税率*/ ");
		buffer.append(",C_ST_IE_CostPrice/*含税单价  */ ");
		buffer.append(",C_ST_IE_TaxAmount/*税额合计*/ ");
		buffer.append(",C_ST_IE_CostPriceAmount/*价税合计*/ ");
		buffer.append(",C_ST_IE_InStockId/*收入仓位*/ ");
		buffer.append(",C_ST_IE_OutStockId/*发出仓位*/ ");
		buffer.append(",C_ST_IE_WarehousingDate ");
		buffer.append(",C_ST_IE_Remark ");
		buffer.append(",C_ST_IE_BarCode/*条码*/ ");
		buffer.append(") ");
		buffer.append("SELECT REPLACE(Newid(), '-', ''), ");
		buffer.append("       ?, ");
		buffer.append("       CheckNumberTable.B_GI_GoodsID, ");
		buffer.append("       Abs(CheckNumberTable.C_SH_CSE_surplusNumber), ");
		buffer.append("       CheckNumberTable.B_GI_NotTaxRate, ");
		buffer.append("       Abs(CheckNumberTable.C_SH_CSE_surplusNumber) * CheckNumberTable.B_GI_NotTaxRate, ");
		buffer.append("       CheckNumberTable.B_GI_TaxRate, ");
		buffer.append("       CheckNumberTable.B_GI_NotTaxRate * ( 100 + B_GI_TaxRate ) / 100, ");
		buffer.append("       B_GI_TaxRate * CheckNumberTable.B_GI_NotTaxRate * Abs(CheckNumberTable.C_SH_CSE_surplusNumber) / 100, ");
		buffer.append("       CheckNumberTable.B_GI_NotTaxRate * ( 100 + B_GI_TaxRate ) / 100 * Abs(CheckNumberTable.C_SH_CSE_surplusNumber), ");
		buffer.append("       CASE ? ");
		buffer.append("         WHEN 5 THEN C_SH_CS_StockId ");
		buffer.append("       END /* 盘盈仓库*/, ");
		buffer.append("       CASE ? ");
		buffer.append("         WHEN 6 THEN C_SH_CS_StockId ");
		buffer.append("       END /* 盘亏仓库*/, ");
		buffer.append("       Getdate(), ");
		buffer.append("       '', ");
		buffer.append("       C_SH_CSE_BarCode ");
		buffer.append("FROM   (SELECT B_GI_GoodsID, ");
		buffer.append("               C_SH_CSE_BarCode, ");
		buffer.append("               B_GI_NotTaxRate, ");
		buffer.append("               B_GI_TaxRate, ");
		buffer.append("               C_SH_CS_StockId, ");
		buffer.append("               C_SH_CSE_surplusNumber ");
		buffer.append("        FROM   C_SH_CheckStorageEntry ");
		buffer.append("               INNER JOIN C_SH_CheckStorage ");
		buffer.append("                 ON C_SH_CSE_BillId = C_SH_CS_BillId ");
		buffer.append("               INNER JOIN B_GoodsInfo ");
		buffer.append("                 ON Substring(C_SH_CSE_BarCode, 1, 18) = B_GI_GoodsBarCode ");
		buffer.append("        WHERE  C_SH_CSE_BillId = ? ");
		buffer.append("               AND C_SH_CS_StockId = ?) AS CheckNumberTable ");
		buffer.append("WHERE  ( ( ? = 5 ");
		buffer.append("           AND CheckNumberTable.C_SH_CSE_surplusNumber > 0 ) ");
		buffer.append("          OR ( ? = 6 ");
		buffer.append("               AND CheckNumberTable.C_SH_CSE_surplusNumber < 0 ) ) ");

		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());
		params.add(inventoryPo.getCstibilltypeid());
		params.add(inventoryPo.getCstibilltypeid());
		params.add(inventoryPo.getCstisourcebillid());
		params.add(inventoryPo.getCstioutstockid());
		params.add(inventoryPo.getCstibilltypeid());
		params.add(inventoryPo.getCstibilltypeid());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 盘盈盘亏查询数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStorageykCount(CheckStoragePo checkStoragePo){
		
		StringBuffer buffer = new StringBuffer(); 

		buffer.append(" select count(goodsID) from ("); 
		buffer.append("SELECT C_SH_CSE_BarCode as barcode, "); 
		buffer.append("B_GI_GoodsID as goodsID, "); 
		buffer.append(" SUM(C_SH_CSE_CheckNumber) as checknumber, "); 
		buffer.append(" SUM(C_SH_CSE_BookNumber) as booknumber "); 
		buffer.append("FROM C_SH_CheckStorageEntry "); 
		buffer.append(" LEFT JOIN C_SH_CheckStorage "); 
		buffer.append(" ON C_SH_CSE_BillId = C_SH_CS_BillId "); 
		buffer.append(" INNER JOIN B_GoodsInfo "); 
		buffer.append(" ON B_GI_GoodsBarCode = Substring(C_SH_CSE_BarCode, 1, 18) "); 
		buffer.append("WHERE C_SH_CSE_BillId = ? "); 
		buffer.append(" AND C_SH_CS_StockId = ? "); 
		buffer.append("GROUP BY B_GI_GoodsID,C_SH_CSE_BarCode ) table1 where 1=1 "); 
		
		if("".equals(Utility.getName(checkStoragePo.getYkFlag()))){
			buffer.append(" and checknumber<>booknumber ");
		}else if("1".equals(Utility.getName(checkStoragePo.getYkFlag()))){//盘盈 —— 实盘大于帐存
			buffer.append(" and checknumber>booknumber ");
		}else if("2".equals(Utility.getName(checkStoragePo.getYkFlag()))){//盘亏 —— 实盘小于帐存
			buffer.append(" and checknumber<booknumber ");
		}
		
		List<String> params = new ArrayList<String>(); 
		params.add(checkStoragePo.getCshcsbillid()); 
		params.add(checkStoragePo.getCshcsstockid()); 
		return this.getJdbcTemplate().queryForInt(buffer.toString(), params.toArray()); 
	}

	/**
	 * 盘盈盘亏查询list
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageykList(
			CheckStoragePo checkStoragePo, int start, int size){
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();
		int countPage = start + size;

		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("select * from (SELECT Row_number() OVER(ORDER BY cshcsegoodsid ) AS 'rowNum',* ");
		buffer.append("FROM   (SELECT  ");
		buffer.append("               B_GI_GoodsID                              AS cshcsegoodsid, ");
		buffer.append("               C_SH_CSE_BarCode                          AS cshcsebarcode, ");
		buffer.append("               B_GI_Goodsname                            AS cshcsegoodsname, ");
		buffer.append("               B_GI_Spec                                 AS cshcsespec, ");
		buffer.append("               B_UT_unitName                             AS cshcseunitname, ");
		buffer.append("               SUM(Isnull(C_SH_CSE_CheckNumber, 0))      AS cshcsechecknumber, ");
		buffer.append("               SUM(Isnull(C_SH_CSE_BookNumber, 0))       AS cshcsebooknumber, ");
		buffer.append("               SUM(Isnull(C_SH_CSE_surplusNumber, 0))    AS cshcsesurplusnumber ");
		buffer.append("        FROM   C_SH_CheckStorageEntry ");
		buffer.append("               LEFT JOIN C_SH_CheckStorage ");
		buffer.append("                 ON C_SH_CSE_BillId = C_SH_CS_BillId ");
		buffer.append("               INNER JOIN B_GoodsInfo ");
		buffer.append("                 ON B_GI_GoodsBarCode = Substring(C_SH_CSE_BarCode, 1, 18) ");
		buffer.append("               LEFT JOIN B_Unit ");
		buffer.append("                 ON B_GI_UnitId = B_UT_id ");
		buffer.append("        WHERE  C_SH_CSE_BillId = ? ");
		buffer.append("               AND C_SH_CS_StockId = ? ");
		buffer.append("        GROUP  BY C_SH_CSE_BarCode, ");
		buffer.append("                  B_GI_GoodsID, ");
		buffer.append("                  B_GI_Goodsname, ");
		buffer.append("                  B_GI_Spec, ");
		buffer.append("                  B_UT_unitName ");
		buffer.append(" ) table1 where 1=1 " );
		
		if("".equals(Utility.getName(checkStoragePo.getYkFlag()))){
			buffer.append(" and cshcsechecknumber<>cshcsebooknumber ");
		}else if("1".equals(Utility.getName(checkStoragePo.getYkFlag()))){//盘盈 —— 实盘大于帐存
			buffer.append(" and cshcsechecknumber>cshcsebooknumber ");
		}else if("2".equals(Utility.getName(checkStoragePo.getYkFlag()))){//盘亏 —— 实盘小于帐存
			buffer.append(" and cshcsechecknumber<cshcsebooknumber ");
		}
		
		buffer.append(" )temp where rowNum >");
		buffer.append(start + " and rowNum <=" + countPage);
		buffer.append(" set rowcount 0");

		params.add(checkStoragePo.getCshcsbillid());
		params.add(checkStoragePo.getCshcsstockid());

		return queryForObjectList(buffer.toString(), params.toArray(),CheckStorageEntryPo.class);
	}
	
	/**
	 * 盘盈盘亏查询list
	 * 
	 * @param checkStoragePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CheckStorageEntryPo> getCheckStorageykList(CheckStoragePo checkStoragePo){
		StringBuffer buffer = new StringBuffer();

		List<String> params = new ArrayList<String>();

		buffer.append("SELECT * FROM (SELECT Substring(B_GI_GoodsID, 1, 7) AS cshcsegoodsid,  ");
		buffer.append(" B_GI_Goodsname  AS cshcsegoodsname,  ");
		buffer.append(" B_UT_unitName as cshcseunitname,  ");
		buffer.append("  case when SUM(Isnull(C_SH_CSE_surplusNumber, 0))>0 then SUM(Isnull(C_SH_CSE_surplusNumber, 0)) else 0  end AS cshcsebooknumber,  ");
		buffer.append("  case when SUM(Isnull(C_SH_CSE_surplusNumber, 0))<0 then SUM(Isnull(C_SH_CSE_surplusNumber, 0)) else 0 end AS cshcsechecknumber, ");
		buffer.append(" SUM(Isnull(C_SH_CSE_surplusNumber, 0))    AS cshcsesurplusnumber, ");
		buffer.append(" SUM(Isnull(C_SH_CSE_surplusNumber, 0)) * B_GI_RetailPrice as cshcsecostPrice ");
		buffer.append(" FROM   C_SH_CheckStorageEntry   ");
		buffer.append(" LEFT JOIN C_SH_CheckStorage ON C_SH_CSE_BillId = C_SH_CS_BillId  ");
		buffer.append(" INNER JOIN B_GoodsInfo ON B_GI_GoodsBarCode = Substring(C_SH_CSE_BarCode, 1, 18) ");
		buffer.append(" LEFT JOIN B_Unit  ON B_GI_UnitId = B_UT_id  ");
		buffer.append(" WHERE  C_SH_CSE_BillId = ?  AND C_SH_CS_StockId = ? ");		
		buffer.append(" GROUP  BY  Substring(B_GI_GoodsID, 1, 7),B_GI_Goodsname,B_UT_unitName,B_GI_RetailPrice) ");
		buffer.append(" table1 where 1=1  and cshcsechecknumber<>cshcsebooknumber  ");
		buffer.append(" ORDER BY cshcsegoodsid ");

		params.add(checkStoragePo.getCshcsbillid());
		params.add(checkStoragePo.getCshcsstockid());

		return queryForObjectList(buffer.toString(), params.toArray(),CheckStorageEntryPo.class);
	}
	
	
	/**
	 * 盈亏分析主表新增
	 * 
	 * @param checkStoragefxPo
	 * @return
	 */
	public void insertCheckStoragefx(CheckStoragefxPo checkStoragefxPo){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_SH_CheckStoragefx(C_SH_CS_ID,C_SH_CS_BillId,C_SH_CS_CheckDate");
		buffer.append(",C_SH_CS_CheckName,C_SH_CS_StockId,C_SH_CS_CheckStockPerson,C_SH_CS_AuditState");
		buffer.append(",C_SH_CS_AuditDate,C_SH_CS_AuditPerson,C_SH_CS_Remark) values(?,?,GETDATE(),?,?,?,?,GETDATE(),?,?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(checkStoragefxPo.getCshcsbillid());
		params.add(checkStoragefxPo.getCshcscheckname());
		params.add(checkStoragefxPo.getCshcsstockid());
		params.add(checkStoragefxPo.getCshcscheckstockperson());
		params.add(checkStoragefxPo.getCshcsauditstate());
		params.add(checkStoragefxPo.getCshcsauditperson());
		params.add(checkStoragefxPo.getCshcsremark());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 盈亏分析明细表新增
	 * 
	 * @param checkStoragefxPo
	 * @return
	 */
	public void insertCheckStoragefxEntry(CheckStoragefxEntryPo checkStoragefxEntryPo){
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("insert into C_SH_CheckStoragefxEntry(C_SH_CSE_ID,C_SH_CSE_BillId,C_SH_CSE_GoodsId");
		buffer.append(",C_SH_CSE_GoodsName,C_SH_CSE_Unit,C_SH_CSE_BookNumber,C_SH_CSE_CheckNumber,C_SH_CSE_CostPrice");
		buffer.append(",C_SH_CSE_Reason,C_SH_CSE_Solve)values(?,?,?,?,?,?,?,?,?,?)");

		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(checkStoragefxEntryPo.getCshcsebillid());
		params.add(checkStoragefxEntryPo.getCshcsegoodsid());
		params.add(checkStoragefxEntryPo.getCshcsegoodsname());
		params.add(checkStoragefxEntryPo.getCshcseunitname());
		params.add(checkStoragefxEntryPo.getCshcsebooknumber());
		params.add(checkStoragefxEntryPo.getCshcsechecknumber());
		params.add(checkStoragefxEntryPo.getCshcsecostPrice());
		params.add(checkStoragefxEntryPo.getCshcsereason());
		params.add(checkStoragefxEntryPo.getCshcsesolve());

		this.getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public int getCheckStoragefxCount(CheckStoragePo checkStoragePo){
		
		StringBuffer buffer = new StringBuffer(); 

		buffer.append("select count(C_SH_CS_BillId) from C_SH_CheckStoragefx "); 
		buffer.append("where C_SH_CS_BillId=? "); 
		
		List<String> params = new ArrayList<String>(); 
		params.add(checkStoragePo.getCshcsbillid()); 

		return this.getJdbcTemplate().queryForInt(buffer.toString(), params.toArray()); 
	}
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public CheckStoragefxPo getCheckStoragefxPo(CheckStoragePo checkStoragePo){
		
		
		StringBuffer buffer = new StringBuffer(); 

		List<String> params = new ArrayList<String>();

		buffer.append("select C_SH_CS_ID as cshcsid,C_SH_CS_BillId as cshcsbillid,C_SH_CS_CheckDate as cshcscheckdate");
		buffer.append(",C_SH_CS_CheckName as cshcscheckname,C_SH_CS_StockId as cshcsstockid,C_SH_CS_CheckStockPerson as cshcscheckstockperson ");
		buffer.append(",a.personName as cshcscheckstockpersonname,C_SH_CS_AuditState as cshcsauditstate,C_SH_CS_AuditDate as cshcsauditdate ");
		buffer.append(",c.B_WH_warehouseName as cshcsstockname,b.personName as cshcsauditpersonname,C_SH_CS_Remark as cshcsremark ");
		buffer.append(" from C_SH_CheckStoragefx ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) a on C_SH_CS_CheckStockPerson=a.ID ");
		buffer.append("left join (select ID,personName from SYS_PersonInfo) b on C_SH_CS_AuditPerson=b.ID ");
		buffer.append("left join (select B_WH_ID,B_WH_warehouseName from B_Warehouse) c on C_SH_CS_StockId=c.B_WH_ID ");
		buffer.append("where C_SH_CS_BillId=? ");

		params.add(checkStoragePo.getCshcsbillid());

		return (CheckStoragefxPo)queryForObject(buffer.toString(), params.toArray(),CheckStoragefxPo.class);
	}
	/**
	 * 盈盘分析数量
	 * 
	 * @param checkStoragePo
	 * @return
	 */
	public List<CheckStoragefxEntryPo> getCheckStoragefxEntryList(CheckStoragePo checkStoragePo){
		
		
		StringBuffer buffer = new StringBuffer(); 

		List<String> params = new ArrayList<String>();		
		
		buffer.append("select C_SH_CSE_ID as cshcseid,C_SH_CSE_BillId as cshcsebillid ");
		buffer.append(",C_SH_CSE_GoodsId as cshcsegoodsid,C_SH_CSE_GoodsName as cshcsegoodsname,C_SH_CSE_Unit as cshcseunitname");
		buffer.append(",C_SH_CSE_BookNumber as  cshcsebooknumber,C_SH_CSE_CheckNumber as cshcsechecknumber,C_SH_CSE_CostPrice as cshcsecostPrice");
		buffer.append(",C_SH_CSE_Reason as cshcsereason,C_SH_CSE_Solve as cshcsesolve ");
		buffer.append("from C_SH_CheckStoragefxEntry ");
		buffer.append("where C_SH_CSE_BillId=? ");

		params.add(checkStoragePo.getCshcsbillid());

		return queryForObjectList(buffer.toString(), params.toArray(),CheckStoragefxEntryPo.class);
	}
}
