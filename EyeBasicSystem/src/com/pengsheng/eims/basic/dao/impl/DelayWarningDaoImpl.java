package com.pengsheng.eims.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.DelayWarningDao;
import com.pengsheng.eims.basic.persistence.CustomerPo;
import com.pengsheng.eims.basic.persistence.DelayNoticePo;
import com.pengsheng.eims.basic.persistence.DelayWarningPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class DelayWarningDaoImpl extends BaseJdbcDaoSupport implements DelayWarningDao {

	public void insertDelayWarning(DelayWarningPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO dbo.B_DelayWarning ");
		buffer.append("            (B_DW_UUID, ");
		buffer.append("             B_DW_WarningDate, ");
		buffer.append("             B_DW_PMF, ");
		buffer.append("             B_DW_FMJ, ");
		buffer.append("             B_DW_JMJ, ");
		buffer.append("             B_DW_JMP, ");
		buffer.append("             B_DW_WSMF, ");
		buffer.append("             B_DW_WSMP) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             ? ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getBdwwarningdate());
		params.add(po.getBdwpmf());
		params.add(po.getBdwfmj());
		params.add(po.getBdwjmj());
		params.add(po.getBdwjmp());
		params.add(po.getBdwwsmf());
		params.add(po.getBdwwsmp());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	public DelayWarningPo selectDelayWarningPo() {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT TOP 1 B_DW_UUID        AS bdwuuid, ");
		buffer.append("             B_DW_WarningDate AS bdwwarningdate, ");
		buffer.append("             B_DW_PMF         AS bdwpmf, ");
		buffer.append("             B_DW_FMJ         AS bdwfmj, ");
		buffer.append("             B_DW_JMJ         AS bdwjmj, ");
		buffer.append("             B_DW_JMP         AS bdwjmp, ");
		buffer.append("             B_DW_WSMF        AS bdwwsmf, ");
		buffer.append("             B_DW_WSMP        AS bdwwsmp ");
		buffer.append("FROM   B_DelayWarning ");
		
		return (DelayWarningPo) queryForObject(buffer.toString(), params.toArray(),DelayWarningPo.class);
	}

	public void updateDelayWarning(DelayWarningPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE dbo.B_DelayWarning ");
		buffer.append("SET ");
		
		buffer.append("       B_DW_PMF = ?, ");
		params.add(Utility.getName(po.getBdwpmf()));
		
		
	
		buffer.append("       B_DW_warningdate = ?, ");
		params.add(Utility.getName(po.getBdwwarningdate()));
	
		
		
		buffer.append("       B_DW_FMJ = ?, ");
		params.add(Utility.getName(po.getBdwfmj()));
		
		
	
		buffer.append("       B_DW_JMJ = ?, ");
		params.add(Utility.getName(po.getBdwjmj()));

		
	
		buffer.append("       B_DW_JMP = ?, ");
		params.add(Utility.getName(po.getBdwjmp()));
	
		
		
		buffer.append("       B_DW_WSMF = ?, ");
		params.add(Utility.getName(po.getBdwwsmf()));
		
		
		
		buffer.append("       B_DW_WSMP = ? ");
		params.add(Utility.getName(po.getBdwwsmp()));
		
		buffer.append(" where       B_DW_uuid = ? ");
		params.add(po.getBdwuuid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 委外预误期查询count
	 * @param po
	 */
	public int selectDelayWarningCount(DelayWarningPo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT count(S_SE_SB_SalesID) ");
		buffer.append("FROM   S_SE_SalesBasic ");
		
		if(!"".equals(Utility.getName(po.getSelbbdsupplierid()))){
			buffer.append(" inner join S_SE_SalesDetail on S_SE_SD_SalesID = S_SE_SB_SalesID and substring(S_SE_SD_SalesItemID,3,2) in (?) ");
			params.add(Utility.getName(po.getSelbbdsupplierid()));
		}
		
		buffer.append("       INNER JOIN dbo.S_ME_CustomerInfo ");
		buffer.append("         ON S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("       INNER JOIN dbo.B_Departments AS ds ");
		buffer.append("         ON ds.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("       INNER JOIN dbo.B_Departments AS dl ");
		buffer.append("         ON dl.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("       LEFT JOIN S_ME_DelayNotice ");
		buffer.append("         ON S_SE_SB_SalesID = S_ME_DN_SalesID ");
		buffer.append("WHERE  S_SE_SB_OrdersType in ('2','4') ");
		buffer.append("  AND S_SE_SB_InTransit not in ('11','12','13','14') ");
		
		if (!"".equals(Utility.getName(po.getBdwcompanyid()))){
		    buffer.append(" and ds.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdwcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getBdwsalesid()))){
			buffer.append("       AND S_SE_SB_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdwsalesid()));
		}
		
		if(!"".equals(Utility.getName(po.getBdwqshopcodeid()))){
			buffer.append("       AND S_SE_SB_Location = ? ");
			params.add(Utility.getName(po.getBdwqshopcodeid()));
		}
		
		if("1".equals(Utility.getName(po.getBdwnoticetype()))){
			buffer.append("       AND isnull(S_ME_DN_UUID,'') <> '' ");
		}
		
		if("0".equals(Utility.getName(po.getBdwnoticetype()))){
			buffer.append("       AND isnull(S_ME_DN_UUID,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getBdwwarningdate()))){
			buffer.append(" AND DATEDIFF(day, getdate(),S_SE_SB_TakeGlassData ) <= cast(? as float) ");
			params.add(Utility.getName(po.getBdwwarningdate()));
		}
		
		if(!"".equals(Utility.getName(po.getBdwminwarningdate()))){
			buffer.append(" AND DATEDIFF(day, getdate(),S_SE_SB_TakeGlassData ) >= cast(? as float) ");
			params.add(Utility.getName(po.getBdwminwarningdate()));
		}
		
		if(!"".equals(Utility.getName(po.getBdintransit()))){	//在途状态
			if("1".equals(Utility.getName(po.getBdintransittype()))){
				if(!"".equals(Utility.getName(po.getBdintransit()))){
					buffer.append("and S_SE_SB_InTransit = cast(? as int)  ");
					params.add(po.getBdintransit());
				}
			}else if("2".equals(Utility.getName(po.getBdintransittype()))){
				if(!"".equals(Utility.getName(po.getBdintransit()))){
					buffer.append("and S_SE_SB_InTransit >= cast(? as int)  ");
					params.add(po.getBdintransit());
				}
				if("1".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}else if("2".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}
			}else if("3".equals(Utility.getName(po.getBdintransittype()))){
				if(!"".equals(Utility.getName(po.getBdintransit()))){
					buffer.append("and S_SE_SB_InTransit > cast(? as int)  ");
					params.add(po.getBdintransit());
				}
				if("1".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}else if("2".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}
			}else if("4".equals(Utility.getName(po.getBdintransittype()))){
				buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
				params.add(po.getBdintransit());
			}else if("5".equals(Utility.getName(po.getBdintransittype()))){
				buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
				params.add(po.getBdintransit());
			}
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(),params.toArray());
	}
	
	/**
	 * 委外预误期查询list
	 * @param po
	 */
	public List<DelayWarningPo> selectDelayWarningList(DelayWarningPo po, int start,int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		
		buffer.append("select * ");
		buffer.append("from( ");
		buffer.append("SELECT ROW_NUMBER() Over(order by S_SE_SB_TakeGlassData) as rowNum, ");
		buffer.append("		  S_SE_SB_SalesID        AS bdwsalesid, ");
		buffer.append("       S_SE_SB_ShopCode       AS bdwsshopcodeid, ");
		buffer.append("       ds.B_DP_DepartmentName AS bdwsshopcodename, ");
		buffer.append("       S_SE_SB_Location       AS bdwqshopcodeid, ");
		buffer.append("       dl.B_DP_DepartmentName AS bdwqshopcodename, ");
		buffer.append("       S_SE_SB_CustomerID     AS bdwcustomerid, ");
		buffer.append("       S_ME_CI_Name           AS bdwcustomername, ");
		buffer.append("       S_SE_SB_PosDatetime  AS bdwsalesdatetime, ");
		buffer.append("       S_SE_SB_TakeGlassData  AS bdwtakedatetime, ");
		buffer.append("       S_ME_DN_UUID           AS bdwnoticeid, ");
		buffer.append("       S_SE_SB_InTransit      AS bdwinTransit ");
		buffer.append("FROM   dbo.S_SE_SalesBasic ");
		if(!"".equals(Utility.getName(po.getSelbbdsupplierid()))){
			buffer.append(" inner join S_SE_SalesDetail on S_SE_SD_SalesID = S_SE_SB_SalesID and substring(S_SE_SD_SalesItemID,3,2) in (?) ");
			params.add(Utility.getName(po.getSelbbdsupplierid()));
		}		
		buffer.append("       INNER JOIN dbo.S_ME_CustomerInfo ");
		buffer.append("         ON S_SE_SB_CustomerID = S_ME_CI_CustomerID ");
		buffer.append("       INNER JOIN dbo.B_Departments AS ds ");
		buffer.append("         ON ds.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("       INNER JOIN dbo.B_Departments AS dl ");
		buffer.append("         ON dl.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("       LEFT JOIN S_ME_DelayNotice ");
		buffer.append("         ON S_SE_SB_SalesID = S_ME_DN_SalesID ");
		buffer.append("WHERE  S_SE_SB_OrdersType in ('2','4') ");
		buffer.append("  AND S_SE_SB_InTransit not in ('11','12','13','14') ");
		
		if (!"".equals(Utility.getName(po.getBdwcompanyid()))){
		    buffer.append(" and ds.B_DP_CompanysID = ? ");
			params.add(Utility.getName(po.getBdwcompanyid()));	
		}
		
		if(!"".equals(Utility.getName(po.getBdwsalesid()))){
			buffer.append("       AND S_SE_SB_SalesID like '%' + ? + '%' ");
			params.add(Utility.getName(po.getBdwsalesid()));
		}
		
		if(!"".equals(Utility.getName(po.getBdwqshopcodeid()))){
			buffer.append("       AND S_SE_SB_Location = ? ");
			params.add(Utility.getName(po.getBdwqshopcodeid()));
		}
		
		if("1".equals(Utility.getName(po.getBdwnoticetype()))){
			buffer.append("       AND isnull(S_ME_DN_UUID,'') <> '' ");
		}
		
		if("0".equals(Utility.getName(po.getBdwnoticetype()))){
			buffer.append("       AND isnull(S_ME_DN_UUID,'') = '' ");
		}
		
		if(!"".equals(Utility.getName(po.getBdwwarningdate()))){
			buffer.append("       AND DATEDIFF(day, getdate(),S_SE_SB_TakeGlassData ) <= cast(? as float) ");
			params.add(Utility.getName(po.getBdwwarningdate()));
		}
		
		if(!"".equals(Utility.getName(po.getBdwminwarningdate()))){
			buffer.append(" 	  AND DATEDIFF(day, getdate(),S_SE_SB_TakeGlassData ) >= cast(? as float) ");
			params.add(Utility.getName(po.getBdwminwarningdate()));
		}
		
		if(!"".equals(Utility.getName(po.getBdintransit()))){	//在途状态
			if("1".equals(Utility.getName(po.getBdintransittype()))){
				if(!"".equals(Utility.getName(po.getBdintransit()))){
					buffer.append("and S_SE_SB_InTransit = cast(? as int)  ");
					params.add(po.getBdintransit());
				}
			}else if("2".equals(Utility.getName(po.getBdintransittype()))){
				if(!"".equals(Utility.getName(po.getBdintransit()))){
					buffer.append("and S_SE_SB_InTransit >= cast(? as int)  ");
					params.add(po.getBdintransit());
				}
				if("1".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}else if("2".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}
			}else if("3".equals(Utility.getName(po.getBdintransittype()))){
				if(!"".equals(Utility.getName(po.getBdintransit()))){
					buffer.append("and S_SE_SB_InTransit > cast(? as int)  ");
					params.add(po.getBdintransit());
				}
				if("1".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}else if("2".equals(Utility.getName(po.getBdintransittype2()))){
					if(!"".equals(Utility.getName(po.getBdintransit2()))){
						buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
						params.add(po.getBdintransit2());
					}
				}
			}else if("4".equals(Utility.getName(po.getBdintransittype()))){
				buffer.append("and S_SE_SB_InTransit <= cast(? as int)  ");
				params.add(po.getBdintransit());
			}else if("5".equals(Utility.getName(po.getBdintransittype()))){
				buffer.append("and S_SE_SB_InTransit < cast(? as int)  ");
				params.add(po.getBdintransit());
			}
		}
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= " + countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), DelayWarningPo.class);
	}
	
	/**
	 * 委外预误期通知新增
	 * @param po
	 */
	public void insertDelayNotice(DelayNoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("INSERT INTO S_ME_DelayNotice ");
		buffer.append("            (S_ME_DN_UUID, ");
		buffer.append("             S_ME_DN_SalesID, ");
		buffer.append("             S_ME_DN_PersonID, ");
		buffer.append("             S_ME_DN_Date, ");
		buffer.append("             S_ME_DN_Message) ");
		buffer.append("VALUES     ( ?, ");
		buffer.append("             ?, ");
		buffer.append("             ?, ");
		buffer.append("             getdate(), ");
		buffer.append("             ? ) ");
		
		params.add(this.uuid.generate());
		params.add(po.getSmednsalesid());
		params.add(po.getSmednpersonid());
		params.add(po.getSmednmessage());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 委外预误期通知更新
	 * @param po
	 */
	public void updateDelayNotice(DelayNoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("UPDATE S_ME_DelayNotice ");
		buffer.append("SET ");
		if(!"".equals(Utility.getName(po.getSmednsalesid()))){
			buffer.append("       S_ME_DN_SalesID = ?, ");
			params.add(po.getSmednsalesid());
		}
		
		if(!"".equals(Utility.getName(po.getSmednpersonid()))){
			buffer.append("       S_ME_DN_PersonID = ?, ");
			params.add(po.getSmednpersonid());
		}
		
		if(!"".equals(Utility.getName(po.getSmednmessage()))){
			buffer.append("       S_ME_DN_Message = ? ");
			params.add(po.getSmednmessage());
		}
		buffer.append("       S_ME_DN_SalesID = ? ");
		params.add(po.getSmednsalesid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 委外预误期加载po
	 * @param po
	 */
	public DelayNoticePo selectDelayNoticePo(DelayNoticePo po) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("SELECT top 1 ");
		buffer.append("		  S_SE_SB_SalesID        AS smednsalesid, ");
		buffer.append("       S_SE_SB_ShopCode       AS smednsshopcodeid, ");
		buffer.append("       ds.B_DP_DepartmentName AS smednsshopcodename, ");
		buffer.append("       S_SE_SB_Location       AS smednqshopcodeid, ");
		buffer.append("       dl.B_DP_DepartmentName AS smednqshopcodename, ");
		buffer.append("       S_ME_CI_CustomerID     AS smedncustomerid, ");
		buffer.append("       cw.S_ME_CI_Name        AS smedncustomername, ");
		buffer.append("       S_SE_SB_PosDatetime  AS smednsalesdatetime, ");
		buffer.append("       S_SE_SB_TakeGlassData  AS smedntakedatetime, ");
		buffer.append("       S_ME_DN_UUID           AS smednuuid, ");
		buffer.append("       S_ME_DN_PersonID       AS smednpersonid, ");
		buffer.append("       S_ME_DN_Date       	 AS smedndate, ");
		buffer.append("       S_ME_DN_Message      	 AS smednmessage ");
		buffer.append("FROM   S_SE_SalesBasic ");
		buffer.append("       INNER JOIN dbo.S_ME_CustomerInfo as cw ");
		buffer.append("         ON S_SE_SB_CustomerID = cw.S_ME_CI_CustomerID ");
		buffer.append("       INNER JOIN dbo.B_Departments AS ds ");
		buffer.append("         ON ds.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("       INNER JOIN dbo.B_Departments AS dl ");
		buffer.append("         ON dl.B_DP_DepartmentID = S_SE_SB_Location ");
		buffer.append("       LEFT JOIN S_ME_DelayNotice ");
		buffer.append("         ON S_SE_SB_SalesID = S_ME_DN_SalesID ");
		buffer.append("WHERE  S_SE_SB_SalesID = ? ");
		
		params.add(po.getSmednsalesid());
		
		return (DelayNoticePo)queryForObject(buffer.toString(), params.toArray(), DelayNoticePo.class);
	}
}
