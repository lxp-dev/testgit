package com.pengsheng.eims.logistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class LogisticsLogDaoImpl  extends BaseJdbcDaoSupport implements LogisticsLogDao {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 模块：物流系统
	 * 描述：新增日志
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public void insertLog(LogisticsLogPo po){
		StringBuffer sb = new StringBuffer();
		sb.append("insert into L_LogisticsLog(logID,logDate,logName,logIP,logOpID,logContent,logResult,logBillList) ");
		sb.append(" values(?,getDate(),?,?,?,?,?,?)");
		List<String> params = new ArrayList<String>();
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getsLogName()));
		params.add(Utility.getName(po.getsLogIP()));
		params.add(Utility.getName(po.getsLogOpID()));
		params.add(Utility.getName(po.getsLogContent()));
		params.add(Utility.getName(po.getsLogResult()));
		params.add(Utility.getName(po.getsLogBillList()));
	
		getJdbcTemplate().update(sb.toString() , params.toArray());
	}
	/**
	 * 模块：物流系统
	 * 描述：查询财务部所有人员
	 * 优化记录：1. szk 2011-08-10
	 */
	@SuppressWarnings("unchecked")
	public List<PersonInfoPo> selPersonInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("select ID as id,personName as personName from SYS_PersonInfo ");
		sb.append("   where departmentID='500' and userState='0' ");
		List<String> params = new ArrayList<String>();
	
		return queryForObjectList(sb.toString(), params.toArray(),PersonInfoPo.class);
	}
	
	
	/**
	 * 模块：物流系统
	 * 描述：查询物流日志总数
	 * 参数：po   日志实体
	 * 优化记录：1. szk 2011-08-10
	 */
	public int selLogisticsLogCount(LogisticsLogPo po){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		sb.append("select count(logID) from L_LogisticsLog inner join SYS_PersonInfo on logName=id ");
		sb.append("       inner join L_LogOperationType a on logOpID=a.opID ");
		sb.append("       left join L_LogOperationType b on logResult=b.opID ");
		sb.append("  where departmentID='500' ");
		
	    if (!"".equals(Utility.getName(po.getsLogStartDate()))){
	    	sb.append(" and convert(varchar(10),logDate,120) >= ? ");
	    	params.add(Utility.getName(po.getsLogStartDate()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogEndDate()))){
	    	sb.append(" and convert(varchar(10),logDate,120) <= ? ");
	    	params.add(Utility.getName(po.getsLogEndDate()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogName()))){
	    	sb.append(" and logName = ? ");
	    	params.add(Utility.getName(po.getsLogName()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogBillList()))){
	    	sb.append(" and logBillList like '%'+?+'%' ");
	    	params.add(Utility.getName(po.getsLogName()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogContent()))){
	    	sb.append(" and logContent like '%'+?+'%' ");
	    	params.add(Utility.getName(po.getsLogContent()));
	    }
	    
		return getJdbcTemplate().queryForInt(sb.toString(),params.toArray());
	}

	
	/**
	 * 模块：物流系统
	 * 描述：查询物流日志
	 * 参数：po   日志实体
	 *      start 开始行数
	 *      size  每页行数
	 * 优化记录：1. szk 2011-08-10
	 */
	@SuppressWarnings("unchecked")
	public List<LogisticsLogPo> selLogisticsLog(LogisticsLogPo po,int start,int size){
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		int countPage = start + size;
		
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select sLogDate as sLogDate,sLogName as sLogName,sLogIP as sLogIP,sLogOpID as sLogOpID,sLogContent as sLogContent,sLogResult as sLogResult,sLogBillList as sLogBillList ");
		
		sb.append("  from( select ROW_NUMBER() Over(order by logDate desc) as rowNum, logDate as sLogDate,personName as sLogName,logIP as sLogIP,a.opName as sLogOpID,logContent as sLogContent,b.opName as sLogResult,logBillList as sLogBillList ");
		sb.append("  from L_LogisticsLog inner join SYS_PersonInfo on logName=id ");
		sb.append("       inner join L_LogOperationType a on logOpID=a.opID ");
		sb.append("       left join L_LogOperationType b on logResult=b.opID ");
		sb.append("  where departmentID='500' ");
		
	    if (!"".equals(Utility.getName(po.getsLogStartDate()))){
	    	sb.append(" and convert(varchar(10),logDate,120) >= ? ");
	    	params.add(Utility.getName(po.getsLogStartDate()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogEndDate()))){
	    	sb.append(" and convert(varchar(10),logDate,120) <= ? ");
	    	params.add(Utility.getName(po.getsLogEndDate()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogName()))){
	    	sb.append(" and logName = ? ");
	    	params.add(Utility.getName(po.getsLogName()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogBillList()))){
	    	sb.append(" and logBillList like '%'+?+'%' ");
	    	params.add(Utility.getName(po.getsLogName()));
	    }
	    if (!"".equals(Utility.getName(po.getsLogContent()))){
	    	sb.append(" and logContent like '%'+?+'%' ");
	    	params.add(Utility.getName(po.getsLogContent()));
	    }
	    
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		sb.append(" set rowcount 0");
		
		return queryForObjectList(sb.toString(), params.toArray(),LogisticsLogPo.class);
	}
	
	
}
