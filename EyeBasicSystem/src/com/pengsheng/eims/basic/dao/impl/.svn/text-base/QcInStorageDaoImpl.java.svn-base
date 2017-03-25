package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.QcInStorageDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class QcInStorageDaoImpl extends BaseJdbcDaoSupport implements QcInStorageDao {

	public int getQcInStorageCount(GoodsInfoPo gpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select count(bgigoodsbarcode) from ( ");
		buffer.append("select F_CN_Name as bgicompanyname,B_DP_DepartmentName as bgidepartmentname,B_WH_warehouseName as bgiwarehousename,B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname, ");
		buffer.append("       C_SH_SL_StockId as bgiwarehouseid,C_SH_SL_GoodsBarCode as bgigoodsbarcode,isnull(C_SH_SL_GuaranteePeriod,'') as guaranteeperiod,isnull(C_SH_SL_Batch,'') as batch,sum(C_SH_SL_GoodsQuantity) as bgistockquantity ");
		buffer.append("  from C_SH_StorageLog ");
		buffer.append("       inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID ");
		buffer.append("       inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("       inner join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("       inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
		buffer.append("  where C_SH_SL_ChangeID = 'import' and C_SH_SL_SourceChangeID = 'import' ");
		
		if (!"".equals(Utility.getName(gpo.getBgicompanyid()))){
		    buffer.append(" and F_CN_ID = ? ");
			params.add(Utility.getName(gpo.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgidepartmentid()))){
		    buffer.append(" and B_DP_DepartmentID = ? ");
			params.add(Utility.getName(gpo.getBgidepartmentid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgiwarehouseid()))){
		    buffer.append(" and B_WH_ID = ? ");
			params.add(Utility.getName(gpo.getBgiwarehouseid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsid()))){
		    buffer.append(" and B_GI_GoodsID like ? + '%' ");
			params.add(Utility.getName(gpo.getBgigoodsid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsname()))){
		    buffer.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(gpo.getBgigoodsname()));	
		}		
		
		buffer.append("  group by F_CN_Name,B_DP_DepartmentName,B_WH_warehouseName,B_GI_GoodsID,B_GI_ViewGoodsName,C_SH_SL_StockId,C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
		buffer.append(")t");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	public List<GoodsInfoPo> getQcInStorageList(GoodsInfoPo gpo,int start,int size){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select ROW_NUMBER() Over(order by F_CN_Name,B_DP_DepartmentName,B_WH_warehouseName,B_GI_GoodsID) as rowNum,F_CN_Name as bgicompanyname,B_DP_DepartmentName as bgidepartmentname,B_WH_warehouseName as bgiwarehousename,B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname, ");
		buffer.append("       C_SH_SL_StockId as bgiwarehouseid,C_SH_SL_GoodsBarCode as bgigoodsbarcode,isnull(C_SH_SL_GuaranteePeriod,'') as guaranteeperiod,isnull(C_SH_SL_Batch,'') as batch,sum(C_SH_SL_GoodsQuantity) as bgistockquantity ");
		buffer.append("  from C_SH_StorageLog ");
		buffer.append("       inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID ");
		buffer.append("       inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("       inner join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("       inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
		buffer.append("  where C_SH_SL_ChangeID = 'import' and C_SH_SL_SourceChangeID = 'import' ");
		
		if (!"".equals(Utility.getName(gpo.getBgicompanyid()))){
		    buffer.append(" and F_CN_ID = ? ");
			params.add(Utility.getName(gpo.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgidepartmentid()))){
		    buffer.append(" and B_DP_DepartmentID = ? ");
			params.add(Utility.getName(gpo.getBgidepartmentid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgiwarehouseid()))){
		    buffer.append(" and B_WH_ID = ? ");
			params.add(Utility.getName(gpo.getBgiwarehouseid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsid()))){
		    buffer.append(" and B_GI_GoodsID like ? + '%' ");
			params.add(Utility.getName(gpo.getBgigoodsid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsname()))){
		    buffer.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(gpo.getBgigoodsname()));	
		}		
		
		buffer.append("  group by F_CN_Name,B_DP_DepartmentName,B_WH_warehouseName,B_GI_GoodsID,B_GI_ViewGoodsName,C_SH_SL_StockId,C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ (start + size));
		
		return queryForObjectList(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	public GoodsInfoPo getQcInStorageInfo(GoodsInfoPo gpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 F_CN_Name as bgicompanyname,B_DP_DepartmentName as bgidepartmentname,B_WH_warehouseName as bgiwarehousename,B_GI_GoodsID as bgigoodsid,B_GI_ViewGoodsName as bgigoodsname,B_GI_GoodsCategoryID as bgigoodscategoryid, ");
		buffer.append("       C_SH_SL_StockId as bgiwarehouseid,C_SH_SL_GoodsBarCode as bgigoodsbarcode,isnull(C_SH_SL_GuaranteePeriod,'') as guaranteeperiod,isnull(C_SH_SL_Batch,'') as batch,sum(C_SH_SL_GoodsQuantity) as bgistockquantity ");
		buffer.append("  from C_SH_StorageLog ");
		buffer.append("       inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID ");
		buffer.append("       inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("       inner join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("       inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
		buffer.append("  where C_SH_SL_ChangeID = 'import' and C_SH_SL_SourceChangeID = 'import' ");
		
		if (!"".equals(Utility.getName(gpo.getGuaranteeperiod()))){
		    buffer.append(" and isnull(C_SH_SL_GuaranteePeriod,'') = ? ");
			params.add(Utility.getName(gpo.getGuaranteeperiod()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBatch()))){
		    buffer.append(" and isnull(C_SH_SL_Batch,'') = ? ");
			params.add(Utility.getName(gpo.getBatch()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgiwarehouseid()))){
		    buffer.append(" and B_WH_ID = ? ");
			params.add(Utility.getName(gpo.getBgiwarehouseid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsid()))){
		    buffer.append(" and C_SH_SL_GoodsId = ? ");
			params.add(Utility.getName(gpo.getBgigoodsid()));	
		}
	
		if (!"".equals(Utility.getName(gpo.getBgigoodsbarcode()))){
		    buffer.append(" and C_SH_SL_GoodsBarCode = ? ");
			params.add(Utility.getName(gpo.getBgigoodsbarcode()));	
		}
		
		buffer.append("  group by F_CN_Name,B_DP_DepartmentName,B_WH_warehouseName,B_GI_GoodsID,B_GI_ViewGoodsName,B_GI_GoodsCategoryID,C_SH_SL_StockId,C_SH_SL_GoodsBarCode,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
		
		return (GoodsInfoPo)queryForObject(buffer.toString(), params.toArray(), GoodsInfoPo.class);
	}
	
	public void updateQcInStorage(GoodsInfoPo gpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update C_SH_StorageLog set C_SH_SL_GoodsQuantity = 0 ");
		buffer.append(" where C_SH_SL_ChangeID = 'import' and C_SH_SL_SourceChangeID = 'import' and C_SH_SL_StockId = ? and C_SH_SL_GoodsBarCode = ? and isnull(C_SH_SL_GuaranteePeriod,'') = ? and isnull(C_SH_SL_Batch,'') = ? ");	
		
		buffer.append("update top (1) C_SH_StorageLog set C_SH_SL_GoodsQuantity = ? ");
		buffer.append(" where C_SH_SL_ChangeID = 'import' and C_SH_SL_SourceChangeID = 'import' and C_SH_SL_StockId = ? and C_SH_SL_GoodsBarCode = ? and isnull(C_SH_SL_GuaranteePeriod,'') = ? and isnull(C_SH_SL_Batch,'') = ? ");	
		
		buffer.append("update C_SH_StorageBeginning set C_SH_SB_GoodsQuantity = 0 ");
		buffer.append("  where C_SH_SB_GoodsId = ? and C_SH_SB_StockId = ? ");
		
		buffer.append("update C_SH_StorageChange set C_SH_SC_GoodsQuantity = 0 ");
		buffer.append("  where C_SH_SC_GoodsId = ? and C_SH_SC_StockId = ? ");

		buffer.append("insert into C_SH_StorageBeginning (C_SH_SB_UUID,C_SH_SB_GoodsBarCode,C_SH_SB_GoodsId,C_SH_SB_StockId,C_SH_SB_GoodsQuantity) ");
		buffer.append("select newid(),replace(C_SH_SL_GoodsId,'.',''),C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity) ");
		buffer.append("  from C_SH_StorageLog ");
		buffer.append("  where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? and convert(varchar(10),C_SH_SL_WarehousingDate,120) < convert(varchar(10),getdate(),120) ");
		buffer.append("  group by C_SH_SL_GoodsId,C_SH_SL_StockId ");
		
		buffer.append("insert into C_SH_StorageChange (C_SH_SC_UUID,C_SH_SC_GoodsBarCode,C_SH_SC_GoodsId,C_SH_SC_StockId, ");
		buffer.append("    C_SH_SC_GoodsQuantity,C_SH_SC_CostPrice,C_SH_SC_NotTaxRate,C_SH_SC_WarehousingDate,C_SH_SC_ChangeID) ");
		buffer.append("select newid(),replace(C_SH_SL_GoodsId,'.',''),C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity), ");
		buffer.append("       B_GI_CostPrice,B_GI_NotTaxRate,C_SH_SL_WarehousingDate,C_SH_SL_ChangeID ");
		buffer.append("  from C_SH_StorageLog inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
		buffer.append("  where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? and convert(varchar(10),C_SH_SL_WarehousingDate,120) = convert(varchar(10),getdate(),120) ");
		buffer.append("  group by C_SH_SL_GoodsId,C_SH_SL_StockId,B_GI_CostPrice,B_GI_NotTaxRate,C_SH_SL_WarehousingDate,C_SH_SL_ChangeID ");
		
		buffer.append("delete from C_SH_StorageBeginning where C_SH_SB_GoodsQuantity = 0 ");
		buffer.append("delete from C_SH_StorageChange where C_SH_SC_GoodsQuantity = 0 ");
		buffer.append("delete from C_SH_StorageLog where C_SH_SL_GoodsQuantity = 0 ");
		
		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("1")){
			buffer.append("delete from C_SH_StorageLog_JJ where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_JJ(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}
		
		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("2")){
			buffer.append("delete from C_SH_StorageLog_PJ where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_PJ(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}
		
		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("3")){
			buffer.append("delete from C_SH_StorageLog_JP where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_JP(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog left join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
			buffer.append("  where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}

		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("4")){
			buffer.append("delete from C_SH_StorageLog_YX where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_YX(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity),isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
			buffer.append("  from dbo.C_SH_StorageLog  left join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
			buffer.append("  where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
		}

		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("5")){
			buffer.append("delete from C_SH_StorageLog_HLY where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_HLY(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity,C_SH_SL_GuaranteePeriod,C_SH_SL_Batch) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity) ,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
			buffer.append("  from dbo.C_SH_StorageLog  where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,isnull(C_SH_SL_GuaranteePeriod,''),isnull(C_SH_SL_Batch,'') ");
		}

		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("6")){
			buffer.append("delete from C_SH_StorageLog_TYJ where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_TYJ(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog  where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}

		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("7")){
			buffer.append("delete from C_SH_StorageLog_HC where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_HC(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}

		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("8")){
			buffer.append("delete from C_SH_StorageLog_LHJ where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_LHJ(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}

		if (Utility.getName(gpo.getBgigoodsid()).substring(0,1).equals("9")){
			buffer.append("delete from C_SH_StorageLog_SG where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			
			buffer.append("insert into dbo.C_SH_StorageLog_SG(C_SH_SL_UUID,C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,C_SH_SL_GoodsQuantity) ");
			buffer.append("select newid(),C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId,sum(C_SH_SL_GoodsQuantity)  ");
			buffer.append("  from dbo.C_SH_StorageLog where C_SH_SL_GoodsId = ? and C_SH_SL_StockId = ? ");
			buffer.append("  group by C_SH_SL_GoodsBarCode,C_SH_SL_GoodsId,C_SH_SL_StockId ");
		}
		
		
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		params.add(Utility.getName(gpo.getBgigoodsbarcode()));
		params.add(Utility.getName(gpo.getGuaranteeperiod()));
		params.add(Utility.getName(gpo.getBatch()));
		
		params.add(Utility.getName(gpo.getBgiqcnum()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		params.add(Utility.getName(gpo.getBgigoodsbarcode()));
		params.add(Utility.getName(gpo.getGuaranteeperiod()));
		params.add(Utility.getName(gpo.getBatch()));
		
		params.add(Utility.getName(gpo.getBgigoodsid()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		
		params.add(Utility.getName(gpo.getBgigoodsid()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		
		params.add(Utility.getName(gpo.getBgigoodsid()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		
		params.add(Utility.getName(gpo.getBgigoodsid()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		
		params.add(Utility.getName(gpo.getBgigoodsid()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));	
		params.add(Utility.getName(gpo.getBgigoodsid()));
		params.add(Utility.getName(gpo.getBgiwarehouseid()));
		
		getJdbcTemplate().update(buffer.toString(),params.toArray());
	}
	
	public int getQcInStorageSum(GoodsInfoPo gpo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
        buffer.append("select sum(C_SH_SL_GoodsQuantity) ");
		buffer.append("  from C_SH_StorageLog ");
		buffer.append("       inner join B_Warehouse on C_SH_SL_StockId = B_WH_ID ");
		buffer.append("       inner join B_Departments on B_WH_deptID = B_DP_DepartmentID ");
		buffer.append("       inner join F_CompanyName on B_DP_CompanysID = F_CN_ID ");
		buffer.append("       inner join B_GoodsInfo on C_SH_SL_GoodsId = B_GI_GoodsID ");
		buffer.append("  where C_SH_SL_ChangeID = 'import' and C_SH_SL_SourceChangeID = 'import' ");
		
		if (!"".equals(Utility.getName(gpo.getBgicompanyid()))){
		    buffer.append(" and F_CN_ID = ? ");
			params.add(Utility.getName(gpo.getBgicompanyid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgidepartmentid()))){
		    buffer.append(" and B_DP_DepartmentID = ? ");
			params.add(Utility.getName(gpo.getBgidepartmentid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgiwarehouseid()))){
		    buffer.append(" and B_WH_ID = ? ");
			params.add(Utility.getName(gpo.getBgiwarehouseid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsid()))){
		    buffer.append(" and B_GI_GoodsID like ? + '%' ");
			params.add(Utility.getName(gpo.getBgigoodsid()));	
		}
		
		if (!"".equals(Utility.getName(gpo.getBgigoodsname()))){
		    buffer.append(" and B_GI_ViewGoodsName like '%' + ? + '%' ");
			params.add(Utility.getName(gpo.getBgigoodsname()));	
		}		
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
}
