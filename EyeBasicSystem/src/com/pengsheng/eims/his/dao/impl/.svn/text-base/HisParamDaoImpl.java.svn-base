package com.pengsheng.eims.his.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.his.dao.HisParamDao;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class HisParamDaoImpl extends BaseJdbcDaoSupport implements HisParamDao {

	public List<HisParamPo> getHisParamPoList(HisParamPo po) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT S_HC_CC_ID              as id ");
		sb.append(",      S_HC_CC_Billid          as billid ");
		sb.append(",      S_HC_CC_Updatetime      as updatetime ");
		sb.append(",      S_HC_CC_Flag            as flag ");
		sb.append(",      S_HC_CC_Posid           as posid ");
		sb.append(",      S_HC_CC_Posname         as posname ");
		sb.append(",      S_HC_CC_Chargetype      as chargetype ");
		sb.append(",      S_HC_CC_Chargestatus    as chargestatus ");
		sb.append(",      S_HC_CC_Tijiatime       as tijiatime ");
		
		sb.append(" FROM S_HC_CC_HISChargeConfirm where 1=1 ");
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(po.getId()))){
			sb.append(" and S_HC_CC_ID = ? ");
			params.add(po.getId());
		}
		if(!"".equals(Utility.getName(po.getBillid()))){
			sb.append(" and S_HC_CC_Billid like '%' + ? + '%' ");
			params.add(po.getBillid());
		}
		if(!"".equals(Utility.getName(po.getStart()))){
			sb.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) >= ?");
			params.add(po.getStart());
		}
		if(!"".equals(Utility.getName(po.getEnd()))){
			sb.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) <= ?");
			params.add(po.getEnd());
		}
		if(!"".equals(Utility.getName(po.getFlag()))){
			sb.append(" and S_HC_CC_Flag =? ");
			params.add(po.getFlag());
		}
		if(!"".equals(Utility.getName(po.getPosid()))){
			sb.append(" and S_HC_CC_Posid = ? ");
			params.add(po.getPosid());
		}
		if(!"".equals(Utility.getName(po.getPosname()))){
			sb.append(" and S_HC_CC_Posname like '%' + ? + '%' ");
			params.add(po.getPosname());
		}
		if(!"".equals(Utility.getName(po.getChargetype()))){
			sb.append(" and S_HC_CC_Chargetype = ? ");
			params.add(po.getChargetype());
		}
		if(!"".equals(Utility.getName(po.getChargestatus()))){ 
			sb.append(" and S_HC_CC_Chargestatus = ? ");
			params.add(po.getChargestatus());
		}
		
		return this.queryForObjectList(sb.toString(), params.toArray(), HisParamPo.class);
	}

	public int getHisParamPoCountByBillid(HisParamPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT count(*) ");
		sb.append("FROM   S_HC_CC_HISChargeConfirm ");
		sb.append("where  S_HC_CC_Billid = ? ");
		
		params.add(po.getBillid());
		if(!"".equals(Utility.getName(po.getChargetype()))){
			sb.append(" and S_HC_CC_Chargetype = ? ");
			params.add(po.getChargetype());
		}
		if(!"".equals(Utility.getName(po.getChargestatus()))){ 
			sb.append(" and S_HC_CC_Chargestatus = ? ");
			params.add(po.getChargestatus());
		}
	 
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public int getHisParamPoCount(HisParamPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT count(*) ");
		sb.append("FROM   S_HC_CC_HISChargeConfirm ");
		sb.append("WHERE  isnull(S_HC_CC_Flag,'') = ? ");
		
		params.add(Utility.getName(po.getFlag()));
		
		if(!"".equals(Utility.getName(po.getId()))){
			sb.append(" and S_HC_CC_ID = ? ");
			params.add(Utility.getName(po.getId()));
		}
		if(!"".equals(Utility.getName(po.getBillid()))){
			sb.append(" and S_HC_CC_Billid = ? ");
			params.add(Utility.getName(po.getBillid()));
		}
		if(!"".equals(Utility.getName(po.getStart()))){
			sb.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) >= ?");
			params.add(Utility.getName(po.getStart()));
		}
		if(!"".equals(Utility.getName(po.getEnd()))){
			sb.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) <= ?");
			params.add(Utility.getName(po.getEnd()));
		}
		if(!"".equals(Utility.getName(po.getPosid()))){
			sb.append(" and S_HC_CC_Posid = ? ");
			params.add(Utility.getName(po.getPosid()));
		}
		if(!"".equals(Utility.getName(po.getPosname()))){
			sb.append(" and S_HC_CC_Posname like '%' + ? + '%' ");
			params.add(Utility.getName(po.getPosname()));
		}
		if(!"".equals(Utility.getName(po.getChargetype()))){
			sb.append(" and S_HC_CC_Chargetype = ? ");
			params.add(Utility.getName(po.getChargetype()));
		}
		if(!"".equals(Utility.getName(po.getChargestatus()))){
			sb.append(" and S_HC_CC_Chargestatus = ? ");
			params.add(Utility.getName(po.getChargestatus()));
		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<HisParamPo> getHisParamPoList(HisParamPo po, int start, int size) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + size;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by S_HC_CC_Tijiatime desc) as rowNum, ");
		buffer.append("       S_HC_CC_ID    	      AS id ");
		buffer.append(",      S_HC_CC_Billid          as billid ");
		buffer.append(",      S_HC_CC_Updatetime      as updatetime ");
		buffer.append(",      S_HC_CC_Flag            as flag ");
		buffer.append(",      S_HC_CC_Posid           as posid ");
		buffer.append(",      S_HC_CC_Posname         as posname ");
		buffer.append(",      S_HC_CC_Chargetype      as chargetype ");   
		buffer.append(",      S_HC_CC_Chargestatus    as chargestatus ");		
		buffer.append(",      S_HC_CC_Tijiatime       as tijiatime ");		
		buffer.append("FROM   S_HC_CC_HISChargeConfirm where isnull(S_HC_CC_Flag,'') = ? ");		

		params.add(Utility.getName(po.getFlag()));
		
		if(!"".equals(Utility.getName(po.getId()))){
			buffer.append(" and S_HC_CC_ID = ? ");
			params.add(Utility.getName(po.getId()));
		}
		if(!"".equals(Utility.getName(po.getBillid()))){
			buffer.append(" and S_HC_CC_Billid = ? ");
			params.add(Utility.getName(po.getBillid()));
		}
		if(!"".equals(Utility.getName(po.getStart()))){
			buffer.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) >= ?");
			params.add(Utility.getName(po.getStart()));
		}
		if(!"".equals(Utility.getName(po.getEnd()))){
			buffer.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) <= ?");
			params.add(Utility.getName(po.getEnd()));
		}
		if(!"".equals(Utility.getName(po.getPosid()))){
			buffer.append(" and S_HC_CC_Posid = ? ");
			params.add(Utility.getName(po.getPosid()));
		}
		if(!"".equals(Utility.getName(po.getPosname()))){
			buffer.append(" and S_HC_CC_Posname like '%' + ? + '%' ");
			params.add(Utility.getName(po.getPosname()));
		}
		if(!"".equals(Utility.getName(po.getChargetype()))){
			buffer.append(" and S_HC_CC_Chargetype = ? ");
			params.add(Utility.getName(po.getChargetype()));
		}
		if(!"".equals(Utility.getName(po.getChargestatus()))){
			buffer.append(" and S_HC_CC_Chargestatus = ? ");
			params.add(Utility.getName(po.getChargestatus()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		buffer.append(" set rowcount 0");
		
		return queryForObjectList(buffer.toString(), params.toArray(), HisParamPo.class);
		
	}

	public HisParamPo getHisParamPo(HisParamPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT S_HC_CC_ID              as id ");
		sb.append(",      S_HC_CC_Billid          as billid ");
		sb.append(",      S_HC_CC_Updatetime      as updatetime ");
		sb.append(",      S_HC_CC_Flag            as flag ");
		sb.append(",      S_HC_CC_Posid           as posid ");
		sb.append(",      S_HC_CC_Posname         as posname ");
		sb.append(",      S_HC_CC_Chargetype      as chargetype ");
		sb.append(",      S_HC_CC_Chargestatus    as chargestatus ");
		sb.append(",      S_HC_CC_Tijiatime       as tijiatime ");
		
		sb.append(" FROM S_HC_CC_HISChargeConfirm where 1=1 ");
		
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(po.getId()))){
			sb.append(" and S_HC_CC_ID = ? ");
			params.add(Utility.getName(po.getId()));
		}
		if(!"".equals(Utility.getName(po.getBillid()))){
			sb.append(" and S_HC_CC_Billid = ? ");
			params.add(Utility.getName(po.getBillid()));
		}
		if(!"".equals(Utility.getName(po.getStart()))){
			sb.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) >= ?");
			params.add(Utility.getName(po.getStart()));
		}
		if(!"".equals(Utility.getName(po.getEnd()))){
			sb.append(" and convert(varchar(10), S_HC_CC_Updatetime, 23) <= ?");
			params.add(Utility.getName(po.getEnd()));
		}
		if(!"".equals(Utility.getName(po.getFlag()))){
			sb.append(" and S_HC_CC_Flag =? ");
			params.add(po.getFlag());
		}
		if(!"".equals(Utility.getName(po.getPosid()))){
			sb.append(" and S_HC_CC_Posid = ? ");
			params.add(po.getPosid());
		}
		if(!"".equals(Utility.getName(po.getPosname()))){
			sb.append(" and S_HC_CC_Posname like '%' + ? + '%' ");
			params.add(po.getPosname());
		}
		if(!"".equals(Utility.getName(po.getChargetype()))){
			sb.append(" and S_HC_CC_Chargetype = ? ");
			params.add(po.getChargetype());
		}
		if(!"".equals(Utility.getName(po.getChargestatus()))){ 
			sb.append(" and S_HC_CC_Chargestatus = ? ");
			params.add(po.getChargestatus());
		}
		
		return (HisParamPo)this.queryForObject(sb.toString(), params.toArray(), HisParamPo.class);
	}

	public void insertSaleInfoToHis(HisParamPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into S_HC_CC_HISChargeConfirm( ");
		sb.append("       S_HC_CC_ID    	 ");
		sb.append(",      S_HC_CC_Billid     ");
		sb.append(",      S_HC_CC_Flag       ");
		sb.append(",      S_HC_CC_Chargetype ");
		sb.append(",      S_HC_CC_Chargestatus ");
		sb.append(",      S_HC_CC_Tijiatime ");
		sb.append(" )VALUES (");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" ?,");
		sb.append(" convert(varchar(16),getDate(),120))");
		
		params.add(po.getId());
		params.add(Utility.getName(po.getBillid()));
		params.add(Utility.getName(po.getFlag()));
		params.add(Utility.getName(po.getChargetype()));
		params.add(Utility.getName(po.getChargestatus()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

	//更新待交费提交状态 
	public void updateTollState(HisParamPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update S_HC_CC_HISChargeConfirm   ");
		sb.append("   set    S_HC_CC_Flag =  ?    	 ");
		sb.append("   where  S_HC_CC_Billid  =  ?    ");
		 
		params.add(Utility.getName(po.getFlag()));
		params.add(Utility.getName(po.getBillid()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

	 
	public int getNotSubCount(SalesBasicPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		buffer.append(" SELECT count(*)   ");
		buffer.append(" FROM   S_SE_SalesBasic  ");
		buffer.append(" left join   SYS_PersonInfo      on  S_SE_SB_SalerID = ID   ");		
		buffer.append(" left join   S_ME_CustomerInfo   on  S_SE_SB_CustomerID  =  S_ME_CI_CustomerID ");		
		buffer.append(" where S_SE_SB_InTransit = '1' ");		
		buffer.append(" and  S_SE_SB_ShopCode = ?   ");
		buffer.append(" and  S_SE_SB_SalesID not in ( select distinct S_HC_CC_Billid from S_HC_CC_HISChargeConfirm )    ");

		params.add(Utility.getName(po.getSsesbshopcode()));
		
		if("".equals(Utility.getName(po.getSsesbcheckoutflag()))){ 
			buffer.append("  and  S_SE_SB_CheckoutFlag in ('0','1') ");
		}else{
			buffer.append("  and  S_SE_SB_CheckoutFlag  =  ? ");
			String str = "1".equals(Utility.getName(po.getSsesbcheckoutflag()))? "0":"1";
			params.add(str);
			
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime()))){   // 销售start日期
			buffer.append(" and convert(varchar(10), S_SE_SB_SalesDatetime, 120) >= ? ");
			params.add(Utility.getName(po.getSsesbsalesdatestarttime()));
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){     // 销售end日期
			buffer.append(" and convert(varchar(10), S_SE_SB_SalesDatetime, 120) <= ? ");
			params.add(Utility.getName(po.getSsesbsalesdateendtime())); 
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){ 
			buffer.append(" and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(po.getSsesbsalesid()));
		}
		
		return getJdbcTemplate().queryForInt(buffer.toString(), params.toArray());
	}

	 
	public List<SalesBasicPo> getNotSubList(SalesBasicPo po, int start, int pageSize) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + pageSize;
		buffer.append("set rowcount " + countPage + " \n");
		
		buffer.append("SELECT	    * from( ");
		buffer.append("SELECT	    ROW_NUMBER() Over(order by S_SE_SB_SalesDatetime desc) as rowNum, ");
		buffer.append("       S_SE_SB_SalesID         as ssesbsalesid ");       // 销售单号
		buffer.append(",      S_SE_SB_SalesDatetime   as ssesbsalesdatetime "); // 销售日期
		buffer.append(",      (case S_SE_SB_CheckoutFlag when '0' then '1' when '1' then '2' end )  as ssesbcheckoutflag ");  // 欠费标志(1-欠费，0-未欠费)定金状态
		buffer.append(",      personName              as ssesbsalerName  ");      // 销售人员姓名
		buffer.append(",      S_ME_CI_Name            as ssesbpersonName  ");   // 顾客姓名
		buffer.append(",      S_ME_CI_Phone           as ssesbphone  ");        // 顾客电话
		//buffer.append(",      S_SE_SB_InTransit       as ssesbintransittype  ");// 在途状态==1
		//buffer.append(",      S_SE_SB_ShopCode        as chargestatus  ");      // 只能查本部门
		buffer.append(" FROM   S_SE_SalesBasic    ");		
		buffer.append(" left join   SYS_PersonInfo      on  S_SE_SB_SalerID = ID   ");		
		buffer.append(" left join   S_ME_CustomerInfo   on  S_SE_SB_CustomerID  =  S_ME_CI_CustomerID ");		
		buffer.append(" where S_SE_SB_InTransit = '1' ");		
		buffer.append(" and  S_SE_SB_ShopCode = ?   ");
		buffer.append(" and  S_SE_SB_SalesID not in ( select distinct S_HC_CC_Billid from S_HC_CC_HISChargeConfirm )   ");

		params.add(Utility.getName(po.getSsesbshopcode()));
		
		if("".equals(Utility.getName(po.getSsesbcheckoutflag()))){ 
			buffer.append("  and  S_SE_SB_CheckoutFlag in ('0','1') ");
		}else{
			buffer.append("  and  S_SE_SB_CheckoutFlag  =  ? ");
			String str = "1".equals(Utility.getName(po.getSsesbcheckoutflag()))? "0":"1";
			params.add(str);
		}
		
		if(!"".equals(Utility.getName(po.getSsesbsalesdatestarttime()))){   // 销售start日期
			buffer.append(" and convert(varchar(10), S_SE_SB_SalesDatetime, 120) >= ? ");
			params.add(Utility.getName(po.getSsesbsalesdatestarttime()));
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesdateendtime()))){     // 销售end日期
			buffer.append(" and convert(varchar(10), S_SE_SB_SalesDatetime, 120) <= ? ");
			params.add(Utility.getName(po.getSsesbsalesdateendtime()));
		}
		if(!"".equals(Utility.getName(po.getSsesbsalesid()))){ 
			buffer.append(" and S_SE_SB_SalesID = ? ");
			params.add(Utility.getName(po.getSsesbsalesid()));
		}
		
		buffer.append(" ) temp where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");
		 
		return queryForObjectList(buffer.toString(), params.toArray(), SalesBasicPo.class);
		
	}

	 
	public void updateSaleInfoToHis(HisParamPo po) {
		
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update S_HC_CC_HISChargeConfirm  set ");
		sb.append("    S_HC_CC_Chargetype =  ? ");
       	sb.append("   ,S_HC_CC_Flag =  ? ");
       	sb.append("   ,S_HC_CC_Chargestatus =  ? ");
		sb.append("   ,S_HC_CC_Tijiatime = convert(varchar(16),getDate(),120) ");
		sb.append("   where  S_HC_CC_Billid  =  ?    ");

		params.add(Utility.getName(po.getChargetype()));
		params.add(Utility.getName(po.getFlag()));
		params.add(Utility.getName(po.getChargestatus()));
		params.add(Utility.getName(po.getBillid()));
		

		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

	 
	public void deleteHisParam(HisParamPo po) {
		
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from S_HC_CC_HISChargeConfirm where 1=1  ");
		
		buffer.append("and S_HC_CC_Billid = ? ");
		params.add(Utility.getName(po.getBillid()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());		
	}

}
