package com.pengsheng.eims.his.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.his.dao.HisLogPoDao;
import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class HisLogPoDaoImpl extends BaseJdbcDaoSupport implements HisLogPoDao{

	public int getHisLogPoCount(HisLogPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT count(*) ");
		sb.append("FROM   L_HI_IL_HISInterfaceLog ");
		sb.append(" left join B_Departments        on L_HI_IL_Depatmentid=B_DP_DepartmentID ");
		sb.append(" left join SYS_PersonInfo       on L_HI_IL_Personid=ID ");
		sb.append(" left join L_HI_IF_HISInterface on L_HI_IL_Interfaceid=L_HI_IF_ID ");
		sb.append(" left join SYS_Module           on L_HI_IL_Moduleid=moduleID ");
		sb.append("WHERE  1=1 ");
		
		if(!"".equals(Utility.getName(po.getHislogid()))){
			sb.append(" and L_HI_IL_ID = ? ");
			params.add(po.getHislogid());
		}
		if(!"".equals(Utility.getName(po.getHislogdepatmentid()))){
			sb.append(" and L_HI_IL_Depatmentid = ? ");
			params.add(po.getHislogdepatmentid());
		}
		if(!"".equals(Utility.getName(po.getHislogpersonid()))){
			sb.append(" and L_HI_IL_Personid = ?");
			params.add(po.getHislogpersonid());
		}
		if(!"".equals(Utility.getName(po.getHislogbegindate()))){
			sb.append(" and convert(varchar(10), L_HI_IL_Date, 23) >= ?");
			params.add(po.getHislogbegindate());
		}
		if(!"".equals(Utility.getName(po.getHislogenddate()))){
			sb.append(" and convert(varchar(10), L_HI_IL_Date, 23) <= ?");
			params.add(po.getHislogenddate());
		}
		if(!"".equals(Utility.getName(po.getHisloginterfaceid()))){
			sb.append(" and L_HI_IL_Interfaceid =? ");
			params.add(po.getHisloginterfaceid());
		}
		if(!"".equals(Utility.getName(po.getHisloginparam()))){
			sb.append(" and L_HI_IL_Inparam = ? ");
			params.add(po.getHisloginparam());
		}
		if(!"".equals(Utility.getName(po.getHislogreturnparam()))){
			sb.append(" and L_HI_IL_Returnparam = ? ");
			params.add(po.getHislogreturnparam());
		}
		if(!"".equals(Utility.getName(po.getHislogmoduleid()))){
			sb.append(" and L_HI_IL_Moduleid = ? ");
			params.add(po.getHislogmoduleid());
		}
		if(!"".equals(Utility.getName(po.getHislogip()))){
			sb.append(" and L_HI_IL_Ip = ? ");
			params.add(po.getHislogip());
		}
		if(!"".equals(Utility.getName(po.getHislogpersonname()))){
			sb.append(" and L_HI_IL_HisPersonName = ? ");
			params.add(po.getHislogpersonname());
		}
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	public List<HisLogPo> getHisLogPoList(HisLogPo po, int start, int pageSize) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		int countPage = start + pageSize;
		sb.append("set rowcount " + countPage + " \n");
		
		sb.append("SELECT	    * from( ");//  (case S_SE_SB_CheckoutFlag when '0' then '1' when '1' then '2' end )
		sb.append("SELECT	    ROW_NUMBER() Over(order by L_HI_IL_Date desc) as rowNum, ");
		sb.append("       L_HI_IL_ID    	       AS hislogid ");
		sb.append(",      L_HI_IL_Depatmentid      as hislogdepatmentid ");
		sb.append(",      B_DP_DepartmentName      as hislogdepatmentname ");//
		sb.append(",      L_HI_IL_Personid         as hislogpersonid ");
		sb.append(", (case isnull(personName,'') when '' then L_HI_IL_HisPersonName else isnull(personName,'') end ) as hislogpersonname ");   //
		sb.append(",      L_HI_IL_Date             as hislogdate ");
		sb.append(",      L_HI_IL_Interfaceid      as hisloginterfaceid ");
		sb.append(",      L_HI_IF_Ifname           as hisloginterfacename ");//
		sb.append(",      L_HI_IL_Inparam          as hisloginparam ");
		sb.append(",      L_HI_IL_Returnparam      as hislogreturnparam ");
		sb.append(",      L_HI_IL_Moduleid         as hislogmoduleid ");
		sb.append(",      moduleCname              as hislogmodulename ");     //
		sb.append(",      L_HI_IL_Ip               as hislogip ");
	 
		sb.append(" FROM L_HI_IL_HISInterfaceLog ");
		sb.append(" left join B_Departments        on L_HI_IL_Depatmentid = B_DP_DepartmentID ");
		sb.append(" left join SYS_PersonInfo       on L_HI_IL_Personid = ID ");
		sb.append(" left join L_HI_IF_HISInterface on L_HI_IL_Interfaceid = L_HI_IF_ID ");
		sb.append(" left join SYS_Module           on L_HI_IL_Moduleid = moduleID ");
		
		sb.append(" where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getHislogid()))){
			sb.append(" and L_HI_IL_ID = ? ");
			params.add(po.getHislogid());
		}
		if(!"".equals(Utility.getName(po.getHislogdepatmentid()))){
			sb.append(" and L_HI_IL_Depatmentid = ? ");
			params.add(po.getHislogdepatmentid());
		}
		
		if(!"".equals(Utility.getName(po.getHislogdepatmentname()))){
			sb.append(" and B_DP_DepartmentName like '%' + ? + '%' ");
			params.add(po.getHislogdepatmentname());
		}
		if(!"".equals(Utility.getName(po.getHislogpersonid()))){
			sb.append(" and L_HI_IL_Personid = ?");
			params.add(po.getHislogpersonid());
		}
		
		if(!"".equals(Utility.getName(po.getHislogpersonname()))){
			sb.append(" and personName like '%' + ? + '%' ");
			params.add(po.getHislogpersonname());
		}
		if(!"".equals(Utility.getName(po.getHislogbegindate()))){
			sb.append(" and convert(varchar(10), L_HI_IL_Date, 23) >= ?");
			params.add(po.getHislogbegindate());
		}
		if(!"".equals(Utility.getName(po.getHislogenddate()))){
			sb.append(" and convert(varchar(10), L_HI_IL_Date, 23) <= ?");
			params.add(po.getHislogenddate());
		}
		if(!"".equals(Utility.getName(po.getHisloginterfaceid()))){
			sb.append(" and L_HI_IL_Interfaceid = ? ");
			params.add(po.getHisloginterfaceid());
		}
		
		if(!"".equals(Utility.getName(po.getHisloginterfacename()))){
			sb.append(" and L_HI_IF_Ifname like '%' + ? + '%' ");
			params.add(po.getHisloginterfacename());
		}
		if(!"".equals(Utility.getName(po.getHisloginparam()))){
			sb.append(" and L_HI_IL_Inparam = ? ");
			params.add(po.getHisloginparam());
		}
		if(!"".equals(Utility.getName(po.getHislogreturnparam()))){
			sb.append(" and L_HI_IL_Returnparam = ? ");
			params.add(po.getHislogreturnparam());
		}
		if(!"".equals(Utility.getName(po.getHislogmoduleid()))){
			sb.append(" and L_HI_IL_Moduleid = ? ");
			params.add(po.getHislogmoduleid());
		}

		if(!"".equals(Utility.getName(po.getHislogmodulename()))){
			sb.append(" and moduleCname like '%' + ? + '%'  ");
			params.add(po.getHislogmodulename());
		}
		if(!"".equals(Utility.getName(po.getHislogip()))){
			sb.append(" and L_HI_IL_Ip like '%' + ? + '%'  ");
			params.add(po.getHislogip());
		}
		
		sb.append(" ) temp where rowNum > " + start + " and rowNum <= "
				+ countPage);
		sb.append(" set rowcount 0");
		 
		return queryForObjectList(sb.toString(), params.toArray(), HisLogPo.class);
		
	}

	/**
	 * 模块：HIS日志新增
	 * 描述：新增日志
	 * 参数：po   日志实体
	 * 
	 */
	public void insertHisLog(HisLogPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("insert into L_HI_IL_HISInterfaceLog( ");
		sb.append("       L_HI_IL_ID    	       ");
		sb.append(",      L_HI_IL_Depatmentid      ");
		sb.append(",      L_HI_IL_Personid         ");
		sb.append(",      L_HI_IL_Date             ");
		sb.append(",      L_HI_IL_Interfaceid      ");
		sb.append(",      L_HI_IL_Inparam          ");
		sb.append(",      L_HI_IL_Returnparam      ");
		sb.append(",      L_HI_IL_Moduleid         ");
		sb.append(",      L_HI_IL_Ip               ");
		sb.append(",      L_HI_IL_HisPersonName    ");
		sb.append(" )VALUES (?,?,?,getdate(),?,?,?,?,?,?)");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getHislogdepatmentid()));
		params.add(Utility.getName(po.getHislogpersonid()));
		
		params.add(Utility.getName(po.getHisloginterfaceid()));
		params.add(Utility.getName(po.getHisloginparam()));
		params.add(Utility.getName(po.getHislogreturnparam()));
		params.add(Utility.getName(po.getHislogmoduleid()));
		params.add(Utility.getName(po.getHislogip()));
		params.add(Utility.getName(po.getHislogpersonname()));
   
		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

	public void updateNotChargeStateByHis(SalesBasicPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update S_HC_CC_HISChargeConfirm set  ");
		sb.append("  S_HC_CC_Updatetime = ? ");
		sb.append(", S_HC_CC_Flag       = ? ");
		sb.append(", S_HC_CC_Posid      = ? ");
		sb.append(", S_HC_CC_Posname    = ? ");
		sb.append("  where  S_HC_CC_ID  = ?  ");
		
		params.add(Utility.getName(po.getSsesbposdatetime()));
		params.add(Utility.getName(po.getSsesbvalueflag()));
		params.add(Utility.getName(po.getSsesbposid()));
		params.add(Utility.getName(po.getSsesbposName()));
		params.add(Utility.getName(po.getSsesbsalesid()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}
	


	/**
    *  接口名称：HIS系统作废待交费用接口更新
    */ 
	public void updateNotChargeStateBySG(SalesBasicPo po) {

		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("update S_HC_CC_HISChargeConfirm set  ");
		sb.append(" S_HC_CC_Chargestatus   = ? ");
		sb.append("  where  S_HC_CC_ID      = ?  ");
		
		params.add(Utility.getName(po.getSsesbvalueflag()));
		params.add(Utility.getName(po.getSsesbsalesid()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
		
	}

	 
	public HisLogPo getHisLogInfo(HisLogPo po) {

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT  ");
		sb.append("       L_HI_IL_ID    	       AS hislogid ");
		sb.append(",      L_HI_IL_Depatmentid      as hislogdepatmentid ");
		sb.append(",      B_DP_DepartmentName      as hislogdepatmentname ");//
		sb.append(",      L_HI_IL_Personid         as hislogpersonid ");
		sb.append(",   (case isnull(personName,'') when '' then L_HI_IL_HisPersonName else isnull(personName,'') end )  as hislogpersonname ");   //
		sb.append(",      L_HI_IL_Date             as hislogdate ");
		sb.append(",      L_HI_IL_Interfaceid      as hisloginterfaceid ");
		sb.append(",      L_HI_IF_Ifname           as hisloginterfacename ");//
		sb.append(",      L_HI_IL_Inparam          as hisloginparam ");
		sb.append(",      L_HI_IL_Returnparam      as hislogreturnparam ");
		sb.append(",      L_HI_IL_Moduleid         as hislogmoduleid ");
		sb.append(",      moduleCname              as hislogmodulename ");     //
		sb.append(",      L_HI_IL_Ip               as hislogip ");
		
		sb.append(" FROM L_HI_IL_HISInterfaceLog ");
		sb.append(" left join B_Departments        on L_HI_IL_Depatmentid=B_DP_DepartmentID ");
		sb.append(" left join SYS_PersonInfo       on L_HI_IL_Personid=ID ");
		sb.append(" left join L_HI_IF_HISInterface on L_HI_IL_Interfaceid=L_HI_IF_ID "); 
		sb.append(" left join SYS_Module           on L_HI_IL_Moduleid=moduleID ");
		
		sb.append(" where  L_HI_IL_ID = ?  ");
		
		List<String> params = new ArrayList<String>();
		
			params.add(po.getHislogid());
			
		return (HisLogPo)this.queryForObject(sb.toString(), params.toArray(), HisLogPo.class);
	}

	 
	public int queryChargeStatecount(SalesBasicPo po) {
		StringBuffer sb = new StringBuffer();
		List<String> params = new ArrayList<String>();
		sb.append("SELECT count(*) ");
		sb.append("FROM   S_HC_CC_HISChargeConfirm ");
		sb.append("WHERE  S_HC_CC_ID = ? and S_HC_CC_Flag = '1' ");
		
		params.add(Utility.getName(po.getSsesbsalesid()));
		 
		return getJdbcTemplate().queryForInt(sb.toString(), params.toArray());
	}

	 
	public List<HisLogPo> gethisLogList() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(" SELECT L_HI_IF_ID AS hisloginterfaceid, L_HI_IF_Ifname AS hisloginterfacename ");
		buffer.append(" FROM L_HI_IF_HISInterface ");
		buffer.append(" WHERE 1 = 1 ");

		return queryForObjectList(buffer.toString(), null, HisLogPo.class);
	}

}
