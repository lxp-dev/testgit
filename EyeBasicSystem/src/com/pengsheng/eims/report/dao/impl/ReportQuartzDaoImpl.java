package com.pengsheng.eims.report.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.report.dao.ReportQuartzDao;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ReportQuartzDaoImpl extends BaseJdbcDaoSupport implements ReportQuartzDao {
	
	/**
	 * 查询石英对应的报表
	 * @return
	 */
	public List<ModulePo> getReportInfoByQuartz(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select ROW_NUMBER() Over(order by Sys_OrderBy) as quartzReferReportCount,Sys_ReportID as reportID,Sys_ReportName as reportName,Sys_QuartzTime as quartzExecuteTime,Sys_Describe as modulecname from SYS_ReportQuartzInfo where 1=1 ");
		if (!"".equals(Utility.getName(po.getIsflag()))){
			buffer.append(" and Sys_IsSee = ? ");
			params.add(Utility.getName(po.getIsflag()));  
		}
		
		if (!"".equals(Utility.getName(po.getIsseelogflag()))){
			buffer.append(" and Sys_Flag = ? ");
			params.add(Utility.getName(po.getIsseelogflag()));  
		}
		
		return queryForObjectList(buffer.toString(), params.toArray(), ModulePo.class);
	}
	
	/**
	 * 删除收银员工作量报表数据
	 */
    public void deleteCashierWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_casherQTOnlyStore where R_CQT_OS_Date >= ? and R_CQT_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除收银员工作量报表数据
	 */
    public void deleteCashierWorkloadAppendArrears(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_casher_AppendArrears where R_CQT_OS_Date >= ? and R_CQT_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除挂号台工作量报表数据
	 */
    public void deleteRegistrationDeskWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_registrationDeskOnlyStore where R_RD_OS_Date >= ? and R_RD_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除检查人员工作量报表数据
	 */
    public void deleteInspectPersonWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_inspectPersonOnlyStore where R_IP_OS_Date >= ? and R_IP_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除取镜人员工作量报表数据
	 */
    public void deleteGetBackEyeglassPersonWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_getBackEyeglassPersonOnlyStore where R_BEP_OS_Date >= ? and R_BEP_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除加工人员工作量报表数据
	 */
    public void deleteProcessWorkingStatisticsWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append(" delete from R_processWorkingStatisticsOnlyStore where R_FWS_OS_Date >= ? and R_FWS_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		buffer.append(" delete from R_processWorkingStatisticsForType where R_FWS_OST_Date >= ? and R_FWS_OST_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除发料人员工作量报表数据
	 */
    public void deleteSendMaterialWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_sendMaterialOnlyStore where R_SM_OS_Date >= ? and R_SM_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除营业员工作量报表数据
	 */
    public void deleteSalesPersonQTWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_salesPersonQTOnlyStore where R_SPQT_OS_Date >= ? and R_SPQT_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除营业员工作量报表数据
	 */
    public void deleteSalesPersonQTWorkloadAppendArrears(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_salesPerson_AppendArrears where R_SPQT_OS_Date >= ? and R_SPQT_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除验光师工作量报表数据
	 */
    public void deleteOptometryWorkload(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_optometryOnlyStore where R_O_OS_Date >= ? and R_O_OS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除日销售汇总报表数据
	 */
    public void deleteDayCollect(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_SD_DayCollect where convert(varchar(10),R_SD_DC_Date,120) >= ? and convert(varchar(10),R_SD_DC_Date,120) <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除日商品类别销售汇总报表数据
	 */
    public void deleteDayCollectEntry(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_SD_DayCollectEntry where convert(varchar(10),R_SD_DCE_Date,120) >= ? and convert(varchar(10),R_SD_DCE_Date,120) <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除日商品类别区间销售汇总报表数据
	 */
    public void deleteDayCollectAreaEntry(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_SD_DayCollectAreaEntry where convert(varchar(10),R_SD_DCAE_Date,120) >= ? and convert(varchar(10),R_SD_DCAE_Date,120) <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    
	/**
	 * 删除日商品明细销售报表数据
	 */
    public void deleteDaySalesEntry(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_RC_DaySalesEntry where convert(varchar(10),R_SD_DSE_Date,120) >= ? and convert(varchar(10),R_SD_DSE_Date,120) <= ? ");
		
		buffer.append("delete from R_RC_DaySalesEntry_ZZ where convert(varchar(10),R_SD_DSE_Date,120) >= ? and convert(varchar(10),R_SD_DSE_Date,120) <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    /**
	 * 删除日品种明细销售报表数据
	 */
    public void deleteDayBrandSalesEntry(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_RC_DayBrandSalesEntry where convert(varchar(10),R_RC_DE_Date,120) >= ? and convert(varchar(10),R_RC_DE_Date,120) <= ? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除日商品明细销售报表数据
	 */
    public void deleteDaySalesEntryAppendArrears(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from R_RC_DaySalesEntry_AppendArrears where convert(varchar(10),R_SD_DSE_Date,120) >= ? and convert(varchar(10),R_SD_DSE_Date,120) <= ? ");
		
		buffer.append("delete from R_RC_DaySalesEntry_ZZ_AppendArrears where convert(varchar(10),R_SD_DSE_Date,120) >= ? and convert(varchar(10),R_SD_DSE_Date,120) <= ? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    /**
	 * 删除日品种明细销售报表数据
	 */
    public void deleteDayBrandSalesEntryAppendArrears(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("delete from R_RC_DayBrandSalesEntry_AppendArrears where convert(varchar(10),R_RC_DEA_Date,120) >= ? and convert(varchar(10),R_RC_DEA_Date,120) <= ? ");
		
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除商品销售报表数据
	 */
    public void deleteGoodsSalesAnalysis(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_ST_GoodsSalesAnalysis where R_ST_GS_Date >= ? and R_ST_GS_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除商品销售报表明细
	 */
    public void deleteGoodsSalesEntryAnalysis(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_ST_GoodsSalesAnalysisEntry where R_ST_GSE_Date >= ? and R_ST_GSE_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除价位段销售分析报表数据
	 */
    public void deleteGoodsSalesPriceEntry(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_SD_DaySalesPriceAreaEntry where convert(varchar(10),R_SD_DCAE_Date,120) >= ? and convert(varchar(10),R_SD_DCAE_Date,120) <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
	/**
	 * 删除销售产品同期综合对比分析(隐形镜片分析)
	 */
    public void deleteStoreCustomerFlowEntry(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_DS_CA_CustomerFlow where convert(varchar(10),R_DS_CA_Date,120) >= ? and convert(varchar(10),R_DS_CA_Date,120) <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
    
    /**
	 * 删除销售出库单汇总数据
	 * 
	 */
	public void deleteCollectSalesOutStorageBill(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from C_ST_Inventory ");
		buffer.append("where convert(varchar(10),C_ST_I_AuditDate,23) = ? and C_ST_I_GoodsCategory in('20','25') ");
		
		buffer.append("delete from C_ST_InventoryEntry where C_ST_IE_BillID in( ");
		buffer.append("select C_ST_I_BillID from C_ST_Inventory where convert(varchar(10),C_ST_I_AuditDate,23) = ? and C_ST_I_GoodsCategory in('20','25')) ");

		params.add(Utility.getName(po.getReportBgnDate()));
		params.add(Utility.getName(po.getReportBgnDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除商品进销存表
	 */
	public void deleteGoodsInOrOutStroage(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_IO_GoodsInOrOutAll where R_IO_GIO_Date >= ? and R_IO_GIO_Date <= ? ");		
		buffer.append("delete from R_IO_GoodsInOrOutByDpt where R_IO_GIO_Date >= ? and R_IO_GIO_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate())); 
		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除商品库存周转率表
	 */
	public void deleteGoodsStorageRevolveRate(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_RR_GoodsStorageRevolveRate where R_GS_RR_Date >= ? and R_GS_RR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除品种库存周转率表
	 */
	public void deleteBrandStorageRevolveRate(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_BrandStorageRevolveRate where R_GS_BR_Date >= ? and R_GS_BR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除商品库存周转率表
	 */
	public void deleteGoodsStorageRevolveRateTemp(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_RR_GoodsStorageRevolveRateTemp where R_GS_RR_Date >= ? and R_GS_RR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 删除商品库存周转率表按单据
	 */
	public void deleteGoodsStorageRevolveRateBill(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_RR_GoodsStorageRevolveRateBill where R_GS_RR_Date >= ? and R_GS_RR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	/**
	 * 删除商品库存周转率表按单据
	 */
	public void deleteGoodsStorageRevolveRateBillTemp(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_RR_GoodsStorageRevolveRateBillTemp where R_GS_RR_Date >= ? and R_GS_RR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询时英执行日志总数
	 */
	public int getReportInfoByQuartzCount(QuartzLogPo logPo){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("declare @bgndate varchar(10),@enddate varchar(10) ");

		if ("".equals(Utility.getName(logPo.getSysqllrbgndate()))){
			buffer.append("select @bgndate = convert(varchar(10),dateadd(MONTH,-1,getdate()),120) ");		
		}else{
			buffer.append("set @bgndate = ? ");
			params.add(Utility.getName(logPo.getSysqllrbgndate()));
		}
		
		if ("".equals(Utility.getName(logPo.getSysqllrenddate()))){
			buffer.append("set @enddate = convert(varchar(10),getdate()-1,120) ");
		}else{
			buffer.append("set @enddate = ? ");
			params.add(Utility.getName(logPo.getSysqllrenddate()));
		}		

		buffer.append(" select count(sysqllrdate) from ( ");
		buffer.append("select qubudate as sysqllrdate,rptname as sysqllrquartzname,rptid as sysqllrquartzid,Sys_QE_LR_ExecDate as sysqllrbgndate,Sys_QE_LR_EndDate as sysqllrenddate from ( ");
		buffer.append("	select convert(varchar(10),DATEADD(DAY,b.number,@bgndate),120) as qubudate,Sys_ReportName as rptname,Sys_ReportID as rptid ");
		buffer.append("	 from master..spt_values b cross join SYS_ReportQuartzInfo ");
		buffer.append("	 WHERE Sys_Flag = '1' and b.type='P' AND b.number BETWEEN 0 AND DATEDIFF(day,@bgndate,@enddate) ");
		buffer.append(")temp left join Sys_QE_LR_QuartzLog on rptid=Sys_QE_LR_QuartzID and qubudate=left(Sys_QE_LR_Date,10) where 1=1 ");		
		
		if (!"".equals(Utility.getName(logPo.getSysqllrquartzid()))){
			buffer.append(" and rptid = ? ");
			params.add(Utility.getName(logPo.getSysqllrquartzid()));
		}
		if ("1".equals(Utility.getName(logPo.getSysqllrquartzflag())) || "3".equals(Utility.getName(logPo.getSysqllrquartzflag()))){
			buffer.append(" and Sys_QE_LR_EndDate is null ");
		}
		if ("2".equals(Utility.getName(logPo.getSysqllrquartzflag()))){
			buffer.append(" and Sys_QE_LR_EndDate is not null ");
		}
		
		if (!"".equals(Utility.getName(logPo.getSysqllpasssecond()))){
			buffer.append(" and DATEDIFF(ss,Sys_QE_LR_ExecDate,Sys_QE_LR_EndDate) >= ? ");
			params.add(Utility.getName(logPo.getSysqllpasssecond()));
		}
		
		buffer.append(" )temp ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}
	
	/**
	 * 查询时英执行日志列表
	 */
	public List<QuartzLogPo> getReportInfoByQuartzList(QuartzLogPo logPo,int start,int size){
		
		int countPage = start + size;
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();		

		sb.append("declare @bgndate varchar(10),@enddate varchar(10) ");

		if ("".equals(Utility.getName(logPo.getSysqllrbgndate()))){
			sb.append("select @bgndate = convert(varchar(10),dateadd(MONTH,-1,getdate()),120) ");		
		}else{
			sb.append("set @bgndate = ? ");
			params.add(Utility.getName(logPo.getSysqllrbgndate()));
		}
		
		if ("".equals(Utility.getName(logPo.getSysqllrenddate()))){
			sb.append("set @enddate = convert(varchar(10),getdate()-1,120) ");
		}else{
			sb.append("set @enddate = ? ");
			params.add(Utility.getName(logPo.getSysqllrenddate()));
		}
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select sysqllrdate,sysqllrquartzname,sysqllrquartzid,sysqllrbgndate,sysqllrenddate,sysqllquartztime from (select ROW_NUMBER() ");
		sb.append("Over(order by qubudate) as 'rowNum', ");
		sb.append(" qubudate as sysqllrdate,rptname as sysqllrquartzname,rptid as sysqllrquartzid,Sys_QE_LR_ExecDate as sysqllrbgndate,Sys_QE_LR_EndDate as sysqllrenddate,sysqllquartztime as sysqllquartztime from ( ");
		sb.append("	select convert(varchar(10),DATEADD(DAY,b.number,@bgndate),120) as qubudate,Sys_ReportName as rptname,Sys_ReportID as rptid,Sys_QuartzTime as sysqllquartztime ");
		sb.append("	 from master..spt_values b cross join SYS_ReportQuartzInfo ");
		sb.append("	 WHERE Sys_Flag = '1' and b.type='P' AND b.number BETWEEN 0 AND DATEDIFF(day,@bgndate,@enddate) ");
		sb.append(")temp left join Sys_QE_LR_QuartzLog on rptid=Sys_QE_LR_QuartzID and qubudate=left(Sys_QE_LR_Date,10) where 1=1 ");
	
		if (!"".equals(Utility.getName(logPo.getSysqllrquartzid()))){
			sb.append(" and rptid = ? ");
			params.add(Utility.getName(logPo.getSysqllrquartzid()));
		}
		if ("1".equals(Utility.getName(logPo.getSysqllrquartzflag())) || "3".equals(Utility.getName(logPo.getSysqllrquartzflag()))){
			sb.append(" and Sys_QE_LR_EndDate is null ");
		}
		if ("2".equals(Utility.getName(logPo.getSysqllrquartzflag()))){
			sb.append(" and Sys_QE_LR_EndDate is not null ");
		}
		
		if (!"".equals(Utility.getName(logPo.getSysqllpasssecond()))){
			sb.append(" and DATEDIFF(ss,Sys_QE_LR_ExecDate,Sys_QE_LR_EndDate) >= ? ");
			params.add(Utility.getName(logPo.getSysqllpasssecond()));
		}
		
		sb.append(") table1 where rowNum > ");
		sb.append(start + " and rowNum <=" + countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(), QuartzLogPo.class);
	}
	
	/**
	 * 删除客单价统计表数据
	 */
    public void deletePerCustomer(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from P_PC_PerCustomer where R_PC_DGM_Date >= ? and R_PC_DGM_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
   
    public FquartzSwitchPo getFquartzSwitchPo() {
    	
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();		

		sb.append("select top 1 F_QS_UUID  as fqsuuid, ");
		sb.append("F_QS_WwshdhzckdFlag  as fqswwshdhzckdflag, ");
		sb.append("F_QS_WwddbchzckdFlag  as fqswwddbchzckdflag, ");
		sb.append("F_QS_BcthfdbhzckdFlag  as fqsbcthfdbhzckdflag, ");
		sb.append("F_QS_FdxsznbFlag  as fqsfdxsznbflag, ");
		sb.append("F_QS_ZdgzhcjlspzbFlag  as fqszdgzhcjlspzbflag, ");		
		sb.append("F_QS_Lsjtj as fqslsjtj, ");
		sb.append("F_QS_Srtx as fqssrtx, ");
		sb.append("F_QS_Washzwajs as fqswashzwajs, ");
		sb.append("F_QS_Hzkc as fqshzkc, ");
		sb.append("F_QS_Cbjtj as fqscbjtj, ");
		sb.append("F_QS_Pfjtj as fqspfjtj, ");
		sb.append("F_QS_Syygzl as fqssyygzl, ");
		sb.append("F_QS_Ghtgzl as fqsghtgzl, ");
		sb.append("F_QS_Jcrygzl as fqsjcrygzl, ");
		sb.append("F_QS_Qjrygzl as fqsqjrygzl, ");
		sb.append("F_QS_Jgsgzl as fqsjgsgzl, ");
		sb.append("F_QS_Flrygzl as fqsflrygzl, ");
		sb.append("F_QS_Yyygzl as fqsyyygzl, ");
		sb.append("F_QS_Soxstj as fqssoxstj, ");
		sb.append("F_QS_Ygsgzl as fqsygsgzl, ");
		sb.append("F_QS_Qkdrxssj as fqsqkdrxssj, ");
		sb.append("F_QS_Cbjs as fqscbjs, ");
		sb.append("F_QS_Hysj as fqshysj, ");
		sb.append("F_QS_Rxshz as fqsrxshz, ");
		sb.append("F_QS_Rxssplxhz as fqsrxssplxhz, ");
		sb.append("F_QS_Rxssplxqjhz as fqsrxssplxqjhz, ");
		sb.append("F_QS_Rxsspmxhz as fqsrxsspmxhz, ");
		sb.append("F_QS_Sscptqzhdbfxb as fqssscptqzhdbfxb, ");
		sb.append("F_QS_Tcgq as fqstcgq, ");
		sb.append("F_QS_Kczzl as fqskczzl, ");
		sb.append("F_QS_Wzhzstd as fqswzhzstd, ");
		sb.append("F_QS_Cdpjd as fqscdpjd, ");
		sb.append("F_QS_Asplxhzkc as fqsasplxhzkc, ");
		sb.append("F_QS_Hzkdjtjb as fqshzkdjtjb, ");
		sb.append("F_QS_Cbjscjpz as fqscbjscjpz, ");
		sb.append("F_QS_Xsckhz as fqsxsckhz, ");
		sb.append("F_QS_SynchronizeCost as fqssynchronizecost ");
		sb.append(",F_QS_SynchronizeCustomer as fqssynchronizecustomer ");
		sb.append("from F_QuartzSwitch ");
		
		return (FquartzSwitchPo)queryForObject(sb.toString(), params.toArray(), FquartzSwitchPo.class);
    }
    
    public void updateFquartzSwitch(FquartzSwitchPo fquartzSwitchPo) {
    	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update F_QuartzSwitch ");
		buffer.append("set F_QS_WwshdhzckdFlag=?, ");
		buffer.append("F_QS_WwddbchzckdFlag=?, ");
		buffer.append("F_QS_BcthfdbhzckdFlag=?, ");
		buffer.append("F_QS_FdxsznbFlag=?, ");
		buffer.append("F_QS_ZdgzhcjlspzbFlag=?, ");		
		buffer.append("F_QS_Lsjtj = ?, ");
		buffer.append("F_QS_Srtx = ?, ");
		buffer.append("F_QS_Washzwajs = ?, ");
		buffer.append("F_QS_Hzkc = ?, ");
		buffer.append("F_QS_Cbjtj = ?, ");
		buffer.append("F_QS_Pfjtj = ?, ");
		buffer.append("F_QS_Syygzl = ?, ");
		buffer.append("F_QS_Ghtgzl = ?, ");
		buffer.append("F_QS_Jcrygzl = ?, ");
		buffer.append("F_QS_Qjrygzl = ?, ");
		buffer.append("F_QS_Jgsgzl = ?, ");
		buffer.append("F_QS_Flrygzl = ?, ");
		buffer.append("F_QS_Yyygzl = ?, ");
		buffer.append("F_QS_Soxstj = ?, ");
		buffer.append("F_QS_Ygsgzl = ?, ");
		buffer.append("F_QS_Qkdrxssj = ?, ");
		buffer.append("F_QS_Cbjs = ?, ");
		buffer.append("F_QS_Hysj = ?, ");
		buffer.append("F_QS_Rxshz = ?, ");
		buffer.append("F_QS_Rxssplxhz = ?, ");
		buffer.append("F_QS_Rxssplxqjhz = ?, ");
		buffer.append("F_QS_Rxsspmxhz = ?, ");
		buffer.append("F_QS_Sscptqzhdbfxb = ?, ");
		buffer.append("F_QS_Tcgq = ?, ");
		buffer.append("F_QS_Kczzl = ?, ");
		buffer.append("F_QS_Wzhzstd = ?, ");
		buffer.append("F_QS_Cdpjd = ?, ");
		buffer.append("F_QS_Asplxhzkc = ?, ");
		buffer.append("F_QS_Hzkdjtjb = ?, ");
		buffer.append("F_QS_Cbjscjpz = ?, ");
		buffer.append("F_QS_Xsckhz = ?, ");
		buffer.append("F_QS_SynchronizeCost = ? ");
		buffer.append(",F_QS_SynchronizeCustomer = ? ");
		
		buffer.append("where F_QS_UUID=? ");

		params.add(Utility.getName(fquartzSwitchPo.getFqswwshdhzckdflag()));  
		params.add(Utility.getName(fquartzSwitchPo.getFqswwddbchzckdflag())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsbcthfdbhzckdflag())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsfdxsznbflag())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqszdgzhcjlspzbflag())); 		
		params.add(Utility.getName(fquartzSwitchPo.getFqslsjtj())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqssrtx())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqswashzwajs())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqshzkc())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqscbjtj())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqspfjtj())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqssyygzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsghtgzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsjcrygzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsqjrygzl())); 		
		params.add(Utility.getName(fquartzSwitchPo.getFqsjgsgzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsflrygzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsyyygzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqssoxstj())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsygsgzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsqkdrxssj())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqscbjs())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqshysj())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsrxshz())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsrxssplxhz())); 		
		params.add(Utility.getName(fquartzSwitchPo.getFqsrxssplxqjhz())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsrxsspmxhz())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqssscptqzhdbfxb())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqstcgq())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqskczzl())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqswzhzstd())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqscdpjd())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqsasplxhzkc())); 
		params.add(Utility.getName(fquartzSwitchPo.getFqshzkdjtjb())); 	
		params.add(Utility.getName(fquartzSwitchPo.getFqscbjscjpz())); 	
		params.add(Utility.getName(fquartzSwitchPo.getFqsxsckhz())); 	
		params.add(Utility.getName(fquartzSwitchPo.getFqssynchronizecost()));
		params.add(Utility.getName(fquartzSwitchPo.getFqssynchronizecustomer()));

		params.add(Utility.getName(fquartzSwitchPo.getFqsuuid())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    	
    }
    

    public void updateQuartzModule(ModulePo modulePo) {
    	
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("update SYS_ReportQuartzInfo ");		
		buffer.append("set Sys_Flag=? ");		
		params.add(Utility.getName(modulePo.getIsflag())); 
		buffer.append(" where Sys_ReportID=? ");
		params.add(Utility.getName(modulePo.getReportID())); 
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    	
    }
    
	/**
	 * 删除分店销售指南表数据
	 */
    public void deleteEachShopSalesGuide(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_FD_SalesGuide where R_FD_SG_Date >= ? and R_FD_SG_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));  
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
    }
        
	/**
	 * 删除商品库存周转率表（按单据）
	 */
	public void deleteGoodsStorageRevolveRateByBill(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_RR_GoodsStorageRevolveRateByBill where R_GS_RR_Date >= ? and R_GS_RR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除商品库存周转率表（按单据）
	 */
	public void deleteBrandStorageRevolveRateByBill(ModulePo po){
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from R_GS_BrandStorageRevolveRateByBill where R_GS_BR_Date >= ? and R_GS_BR_Date <= ? ");

		params.add(Utility.getName(po.getReportBgnDate()));  
		params.add(Utility.getName(po.getReportEndDate()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
    
}
