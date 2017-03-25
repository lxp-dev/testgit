package com.pengsheng.eims.hydsycasehistory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.hydsycasehistory.dao.YjCheckHydsyDao;
import com.pengsheng.eims.hydsycasehistory.persistence.YjCheckPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class YjCheckHydsyDaoImpl extends BaseJdbcDaoSupport implements YjCheckHydsyDao {

	public int getYjCheckCount(YjCheckPo po) {
				
		StringBuffer sb=new StringBuffer();
		sb.append("select count(S_OP_YJ_ID) from S_OP_Yanji ");
		sb.append("inner join S_ME_CustomerInfo on S_OP_YJ_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		sb.append("where 1=1 ");
		if(!"".equals(Utility.getName(po.getSopyjcustomerid()))){
			sb.append(" and S_ME_CI_MemberId='"+po.getSopyjcustomerid()+"' ");
		}

		if(!"".equals(Utility.getName(po.getSopyjcustomername()))){
			sb.append(" and S_ME_CI_Name like '%"+po.getSopyjcustomername()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getStartTime()))){
			sb.append(" and convert(varchar(10),S_OP_YJ_Datetime,23)>= '"+po.getStartTime()+"'");
		}
		
		if(!"".equals(Utility.getName(po.getEndTime()))){
			sb.append(" and convert(varchar(10),S_OP_YJ_Datetime,23)<= '"+po.getEndTime()+"'" );
		}
		
		if(!"".equals(Utility.getName(po.getSopyjcustomerphone()))){
			sb.append(" and S_ME_CI_Phone='"+po.getSopyjcustomerphone()+"' ");
		}
		
		return getJdbcTemplate().queryForInt(sb.toString());
	}
	
	public List<YjCheckPo> getYjCheckList(YjCheckPo po, int start,
			int size) {
		StringBuffer sb=new StringBuffer();
		
		int countPage = start + size;
		sb.append("set rowcount " + countPage + " \n");
		sb.append("select *");
		sb.append(" from(select ROW_NUMBER() Over(order by S_OP_YJ_Datetime desc) as rowNum,");
		sb.append("S_ME_CI_CustomerID as sopyjcustomerid,S_ME_CI_MemberId as sopyjcustomerMemberId,");
		sb.append("S_ME_CI_Name as sopyjcustomername,S_ME_CI_Sex as sopyjcustomersex,");
		sb.append("S_OP_YJ_ID as sopyjid,B_DP_DepartmentName as sopyjshopname,personName as sopyjpersonname,");
		sb.append("S_OP_YJ_Datetime as sopyjdatetime from S_OP_Yanji ");
		sb.append("inner join S_ME_CustomerInfo on S_OP_YJ_CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID  ");
		sb.append("inner join B_Departments on B_DP_DepartmentID=S_OP_YJ_ShopCode  ");
		sb.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID=S_OP_YJ_Personid  ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSopyjcustomerid()))){
			sb.append(" and S_ME_CI_MemberId='"+po.getSopyjcustomerid()+"' ");
		}

		if(!"".equals(Utility.getName(po.getSopyjcustomername()))){
			sb.append(" and S_ME_CI_Name like '%"+po.getSopyjcustomername()+"%' ");
		}
		
		if(!"".equals(Utility.getName(po.getStartTime()))){
			sb.append(" and convert(varchar(10),S_OP_YJ_Datetime,23)>= '"+po.getStartTime()+"'");
		}
		
		if(!"".equals(Utility.getName(po.getEndTime()))){
			sb.append(" and convert(varchar(10),S_OP_YJ_Datetime,23)<= '"+po.getEndTime()+"'" );
		}
		
		if(!"".equals(Utility.getName(po.getSopyjcustomerphone()))){
			sb.append(" and S_ME_CI_Phone='"+po.getSopyjcustomerphone()+"' ");
		}
		
		sb.append("  ) temp where rowNum > "+start+" and rowNum <= "+ countPage);
		sb.append(" set rowcount 0");
		return queryForObjectList(sb.toString(), null, YjCheckPo.class);
	}
	
	public void insertYjCheck(YjCheckPo po) {
		StringBuffer sb=new StringBuffer();	
		List<String> params = new ArrayList<String>(); 

		sb.append("INSERT INTO S_OP_Yanji( ");
		sb.append("             S_OP_YJ_ID, ");
		sb.append("             S_OP_YJ_CustomerID, ");
		sb.append("             S_OP_YJ_ShopCode, ");
		sb.append("             S_OP_YJ_Personid, ");
		sb.append("             S_OP_YJ_Datetime, ");
		sb.append("             S_OP_YJ_DCTW_Touxiang, ");
		sb.append("             S_OP_YJ_DCTW_Jianqing, ");
		sb.append("             S_OP_YJ_DCTW_Waitoushiyan, ");
		sb.append("             S_OP_YJ_JMYG_Luoyan, ");
		sb.append("             S_OP_YJ_JMYG_Daijing, ");
		sb.append("             S_OP_YJ_JMYG_Kongzhizhengwei, ");
		sb.append("             S_OP_YJ_JMYG_Zhudaoyan, ");
		sb.append("             S_OP_YJ_SLJ, ");
		sb.append("             S_OP_YJ_SLJ_5MOD_Luoyan, ");
		sb.append("             S_OP_YJ_SLJ_5MOD_Daijing, ");
		sb.append("             S_OP_YJ_SLJ_5MOS_Luoyan, ");
		sb.append("             S_OP_YJ_SLJ_5MOS_Daijing, ");
		sb.append("             S_OP_YJ_SLJ_3MOD_Luoyan, ");
		sb.append("             S_OP_YJ_SLJ_3MOD_Daijing, ");
		sb.append("             S_OP_YJ_SLJ_3MOS_Luoyan, ");
		sb.append("             S_OP_YJ_SLJ_3MOS_Daijing, ");
		sb.append("             S_OP_YJ_SLJ_YQYD_Shuangyan, ");
		sb.append("             S_OP_YJ_SLJ_YQYD_Danyan, ");
		sb.append("             S_OP_YJ_TSJ_1ZJXJ_Luoyan, ");
		sb.append("             S_OP_YJ_SLJ_1ZJXJ_Daijing, ");
		sb.append("             S_OP_YJ_TSJ_1TJXJ_Luoyan, ");
		sb.append("             S_OP_YJ_SLJ_1TJXJ_Daijing, ");
		sb.append("             S_OP_YJ_TSJ_2Ronghedian, ");
		sb.append("             S_OP_YJ_SLJ_2Ronghefanwei, ");
		sb.append("             S_OP_YJ_TSJ_3Litishi, ");
		sb.append("             S_OP_YJ_SLJ_3TitmusLitishi, ");
		sb.append("             S_OP_YJ_TSJ_A_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_A_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_A_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_A_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_A_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_A_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_B_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_B_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_B_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_B_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_B_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_B_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_C_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_C_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_C_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_C_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_C_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_C_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_D_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_D_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_D_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_D_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_D_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_D_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_E_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_E_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_E_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_E_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_E_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_E_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_F_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_F_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_F_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_F_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_F_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_F_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_G_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_G_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_G_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_G_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_G_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_G_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_H_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_H_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_H_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_H_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_H_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_H_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_I_ZF_Radio, ");
		sb.append("             S_OP_YJ_TSJ_I_RL_Radio, ");
		sb.append("             S_OP_YJ_TSJ_I_EX_Radio, ");
		sb.append("             S_OP_YJ_TSJ_I_ZF_Input, ");
		sb.append("             S_OP_YJ_TSJ_I_RL_Input, ");
		sb.append("             S_OP_YJ_TSJ_I_EX_Input, ");
		sb.append("             S_OP_YJ_TSJ_RefLef_Radio, ");
		sb.append("             S_OP_YJ_TSJ_CcSc_Radio, ");
		sb.append("             S_OP_YJ_TSJ_1050_Radio, ");		
		sb.append("             S_OP_YJ_FXJC, ");
		sb.append("             S_OP_YJ_TSJC_Select, ");
		sb.append("             S_OP_YJ_TSJC_Input, ");
		sb.append("             S_OP_YJ_TJLMD_Shuangmianjingdushu, ");
		sb.append("             S_OP_YJ_TJLMD_Shibiao, ");
		sb.append("             S_OP_YJ_TJLMD_Ou, ");
		sb.append("             S_OP_YJ_TJLMD_Od, ");
		sb.append("             S_OP_YJ_TJLMD_Os, ");
		sb.append("             S_OP_YJ_SLJ_LY_Q_SELECTOD, ");
		sb.append("             S_OP_YJ_SLJ_LY_Q_SELECTOS, ");
		sb.append("             S_OP_YJ_SLJ_DJ_Q_SELECTOD, ");
		sb.append("             S_OP_YJ_SLJ_DJ_Q_SELECTOS, ");
		sb.append("             S_OP_YJ_SLJ_LY_H_SELECTOD, ");
		sb.append("             S_OP_YJ_SLJ_LY_H_SELECTOS, ");
		sb.append("             S_OP_YJ_SLJ_DJ_H_SELECTOD, ");
		sb.append("             S_OP_YJ_SLJ_DJ_H_SELECTOS  ");
		sb.append(" )VALUES (?,?,?,?,getdate(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
		sb.append("             ,?,?,?,?,?,?,?,?)  ");
		
		params.add(this.uuid.generate());
		params.add(Utility.getName(po.getSopyjcustomerid()));
		params.add(Utility.getName(po.getSopyjshopcode()));
		params.add(Utility.getName(po.getSopyjpersonid()));
		params.add(Utility.getName(po.getSopyjdctwtouxiang()));
		params.add(Utility.getName(po.getSopyjdctwjianqing()));
		params.add(Utility.getName(po.getSopyjdctwwaitoushiyan()));
		params.add(Utility.getName(po.getSopyjjmygluoyan()));
		params.add(Utility.getName(po.getSopyjjmygdaijing()));
		params.add(Utility.getName(po.getSopyjjmygkongzhizhengwei()));
		params.add(Utility.getName(po.getSopyjjmygzhudaoyan()));
		params.add(Utility.getName(po.getSopyjslj()));
		params.add(Utility.getName(po.getSopyjslj5modluoyan()));
		params.add(Utility.getName(po.getSopyjslj5moddaijing()));
		params.add(Utility.getName(po.getSopyjslj5mosluoyan()));
		params.add(Utility.getName(po.getSopyjslj5mosdaijing()));
		params.add(Utility.getName(po.getSopyjslj3modluoyan()));
		params.add(Utility.getName(po.getSopyjslj3moddaijing()));
		params.add(Utility.getName(po.getSopyjslj3mosluoyan()));
		params.add(Utility.getName(po.getSopyjslj3mosdaijing()));
		params.add(Utility.getName(po.getSopyjsljyqydshuangyan()));
		params.add(Utility.getName(po.getSopyjsljyqyddanyan()));
		params.add(Utility.getName(po.getSopyjtsj1zjxjluoyan()));
		params.add(Utility.getName(po.getSopyjslj1zjxjdaijing()));
		params.add(Utility.getName(po.getSopyjtsj1tjxjluoyan()));
		params.add(Utility.getName(po.getSopyjslj1tjxjdaijing()));
		params.add(Utility.getName(po.getSopyjtsj2ronghedian()));
		params.add(Utility.getName(po.getSopyjslj2ronghefanwei()));
		params.add(Utility.getName(po.getSopyjtsj3litishi()));
		params.add(Utility.getName(po.getSopyjslj3titmuslitishi()));
		params.add(Utility.getName(po.getSopyjtsjazfradio()));
		params.add(Utility.getName(po.getSopyjtsjarlradio()));
		params.add(Utility.getName(po.getSopyjtsjaexradio()));
		params.add(Utility.getName(po.getSopyjtsjazfinput()));
		params.add(Utility.getName(po.getSopyjtsjarlinput()));
		params.add(Utility.getName(po.getSopyjtsjaexinput()));
		params.add(Utility.getName(po.getSopyjtsjbzfradio()));
		params.add(Utility.getName(po.getSopyjtsjbrlradio()));
		params.add(Utility.getName(po.getSopyjtsjbexradio()));
		params.add(Utility.getName(po.getSopyjtsjbzfinput()));
		params.add(Utility.getName(po.getSopyjtsjbrlinput()));
		params.add(Utility.getName(po.getSopyjtsjbexinput()));
		params.add(Utility.getName(po.getSopyjtsjczfradio()));
		params.add(Utility.getName(po.getSopyjtsjcrlradio()));
		params.add(Utility.getName(po.getSopyjtsjcexradio()));
		params.add(Utility.getName(po.getSopyjtsjczfinput()));
		params.add(Utility.getName(po.getSopyjtsjcrlinput()));
		params.add(Utility.getName(po.getSopyjtsjcexinput()));
		params.add(Utility.getName(po.getSopyjtsjdzfradio()));
		params.add(Utility.getName(po.getSopyjtsjdrlradio()));
		params.add(Utility.getName(po.getSopyjtsjdexradio()));
		params.add(Utility.getName(po.getSopyjtsjdzfinput()));
		params.add(Utility.getName(po.getSopyjtsjdrlinput()));
		params.add(Utility.getName(po.getSopyjtsjdexinput()));
		params.add(Utility.getName(po.getSopyjtsjezfradio()));
		params.add(Utility.getName(po.getSopyjtsjerlradio()));
		params.add(Utility.getName(po.getSopyjtsjeexradio()));
		params.add(Utility.getName(po.getSopyjtsjezfinput()));
		params.add(Utility.getName(po.getSopyjtsjerlinput()));
		params.add(Utility.getName(po.getSopyjtsjeexinput()));
		params.add(Utility.getName(po.getSopyjtsjfzfradio()));
		params.add(Utility.getName(po.getSopyjtsjfrlradio()));
		params.add(Utility.getName(po.getSopyjtsjfexradio()));
		params.add(Utility.getName(po.getSopyjtsjfzfinput()));
		params.add(Utility.getName(po.getSopyjtsjfrlinput()));
		params.add(Utility.getName(po.getSopyjtsjfexinput()));
		params.add(Utility.getName(po.getSopyjtsjgzfradio()));
		params.add(Utility.getName(po.getSopyjtsjgrlradio()));
		params.add(Utility.getName(po.getSopyjtsjgexradio()));
		params.add(Utility.getName(po.getSopyjtsjgzfinput()));
		params.add(Utility.getName(po.getSopyjtsjgrlinput()));
		params.add(Utility.getName(po.getSopyjtsjgexinput()));
		params.add(Utility.getName(po.getSopyjtsjhzfradio()));
		params.add(Utility.getName(po.getSopyjtsjhrlradio()));
		params.add(Utility.getName(po.getSopyjtsjhexradio()));
		params.add(Utility.getName(po.getSopyjtsjhzfinput()));
		params.add(Utility.getName(po.getSopyjtsjhrlinput()));
		params.add(Utility.getName(po.getSopyjtsjhexinput()));
		params.add(Utility.getName(po.getSopyjtsjizfradio()));
		params.add(Utility.getName(po.getSopyjtsjirlradio()));
		params.add(Utility.getName(po.getSopyjtsjiexradio()));
		params.add(Utility.getName(po.getSopyjtsjizfinput()));
		params.add(Utility.getName(po.getSopyjtsjirlinput()));
		params.add(Utility.getName(po.getSopyjtsjiexinput()));
		
		params.add(Utility.getName(po.getSopyjtsjreflefradio()));
		params.add(Utility.getName(po.getSopyjtsjccscradio()));
		params.add(Utility.getName(po.getSopyjtsj1050radio()));
		
		params.add(Utility.getName(po.getSopyjfxjc()));
		params.add(Utility.getName(po.getSopyjtsjcselect()));
		params.add(Utility.getName(po.getSopyjtsjcinput()));
		params.add(Utility.getName(po.getSopyjtjlmdshuangmianjingdushu()));
		params.add(Utility.getName(po.getSopyjtjlmdshibiao()));
		params.add(Utility.getName(po.getSopyjtjlmdou()));
		params.add(Utility.getName(po.getSopyjtjlmdod()));
		params.add(Utility.getName(po.getSopyjtjlmdos()));
		
		params.add(Utility.getName(po.getSljlyqselectod()));
		params.add(Utility.getName(po.getSljlyqselectos()));
		params.add(Utility.getName(po.getSljdjqselectod()));
		params.add(Utility.getName(po.getSljdjqselectos()));
		params.add(Utility.getName(po.getSljlyhselectod()));
		params.add(Utility.getName(po.getSljlyhselectos()));
		params.add(Utility.getName(po.getSljdjhselectod()));
		params.add(Utility.getName(po.getSljdjhselectos()));

		getJdbcTemplate().update(sb.toString(), params.toArray());
	}
	
	public YjCheckPo getYjCheck(YjCheckPo po) {
		
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT S_OP_YJ_ID                        AS sopyjid, ");
		sb.append("       S_OP_YJ_CustomerID                AS sopyjcustomerid, ");
		sb.append("       S_ME_CI_MemberId                	AS sopyjcustomerMemberId, ");
		sb.append("       S_ME_CI_Name                		AS sopyjcustomername, ");
		sb.append("       S_ME_CI_Sex                		AS sopyjcustomersex, ");
		sb.append("       S_OP_YJ_ShopCode                  AS sopyjshopcode, ");
		sb.append("       B_DP_DepartmentName               AS sopyjshopname, ");
		sb.append("       personName                        AS sopyjpersonname, ");
		sb.append("       S_OP_YJ_Personid                  AS sopyjpersonid, ");
		sb.append("       S_OP_YJ_Datetime                  AS sopyjdatetime, ");
		sb.append("       S_OP_YJ_DCTW_Touxiang             AS sopyjdctwtouxiang, ");
		sb.append("       S_OP_YJ_DCTW_Jianqing             AS sopyjdctwjianqing, ");
		sb.append("       S_OP_YJ_DCTW_Waitoushiyan         AS sopyjdctwwaitoushiyan, ");
		sb.append("       S_OP_YJ_JMYG_Luoyan               AS sopyjjmygluoyan, ");
		sb.append("       S_OP_YJ_JMYG_Daijing              AS sopyjjmygdaijing, ");
		sb.append("       S_OP_YJ_JMYG_Kongzhizhengwei      AS sopyjjmygkongzhizhengwei, ");
		sb.append("       S_OP_YJ_JMYG_Zhudaoyan            AS sopyjjmygzhudaoyan, ");
		sb.append("       S_OP_YJ_SLJ                       AS sopyjslj, ");
		sb.append("       S_OP_YJ_SLJ_5MOD_Luoyan           AS sopyjslj5modluoyan, ");
		sb.append("       S_OP_YJ_SLJ_5MOD_Daijing          AS sopyjslj5moddaijing, ");
		sb.append("       S_OP_YJ_SLJ_5MOS_Luoyan           AS sopyjslj5mosluoyan, ");
		sb.append("       S_OP_YJ_SLJ_5MOS_Daijing          AS sopyjslj5mosdaijing, ");
		sb.append("       S_OP_YJ_SLJ_3MOD_Luoyan           AS sopyjslj3modluoyan, ");
		sb.append("       S_OP_YJ_SLJ_3MOD_Daijing          AS sopyjslj3moddaijing, ");
		sb.append("       S_OP_YJ_SLJ_3MOS_Luoyan           AS sopyjslj3mosluoyan, ");
		sb.append("       S_OP_YJ_SLJ_3MOS_Daijing          AS sopyjslj3mosdaijing, ");
		sb.append("       S_OP_YJ_SLJ_YQYD_Shuangyan        AS sopyjsljyqydshuangyan, ");
		sb.append("       S_OP_YJ_SLJ_YQYD_Danyan           AS sopyjsljyqyddanyan, ");
		sb.append("       S_OP_YJ_TSJ_1ZJXJ_Luoyan          AS sopyjtsj1zjxjluoyan, ");
		sb.append("       S_OP_YJ_SLJ_1ZJXJ_Daijing         AS sopyjslj1zjxjdaijing, ");
		sb.append("       S_OP_YJ_TSJ_1TJXJ_Luoyan          AS sopyjtsj1tjxjluoyan, ");
		sb.append("       S_OP_YJ_SLJ_1TJXJ_Daijing         AS sopyjslj1tjxjdaijing, ");
		sb.append("       S_OP_YJ_TSJ_2Ronghedian           AS sopyjtsj2ronghedian, ");
		sb.append("       S_OP_YJ_SLJ_2Ronghefanwei         AS sopyjslj2ronghefanwei, ");
		sb.append("       S_OP_YJ_TSJ_3Litishi              AS sopyjtsj3litishi, ");
		sb.append("       S_OP_YJ_SLJ_3TitmusLitishi        AS sopyjslj3titmuslitishi, ");
		sb.append("       S_OP_YJ_TSJ_A_ZF_Radio            AS sopyjtsjazfradio, ");
		sb.append("       S_OP_YJ_TSJ_A_RL_Radio            AS sopyjtsjarlradio, ");
		sb.append("       S_OP_YJ_TSJ_A_EX_Radio            AS sopyjtsjaexradio, ");
		sb.append("       S_OP_YJ_TSJ_A_ZF_Input            AS sopyjtsjazfinput, ");
		sb.append("       S_OP_YJ_TSJ_A_RL_Input            AS sopyjtsjarlinput, ");
		sb.append("       S_OP_YJ_TSJ_A_EX_Input            AS sopyjtsjaexinput, ");
		sb.append("       S_OP_YJ_TSJ_B_ZF_Radio            AS sopyjtsjbzfradio, ");
		sb.append("       S_OP_YJ_TSJ_B_RL_Radio            AS sopyjtsjbrlradio, ");
		sb.append("       S_OP_YJ_TSJ_B_EX_Radio            AS sopyjtsjbexradio, ");
		sb.append("       S_OP_YJ_TSJ_B_ZF_Input            AS sopyjtsjbzfinput, ");
		sb.append("       S_OP_YJ_TSJ_B_RL_Input            AS sopyjtsjbrlinput, ");
		sb.append("       S_OP_YJ_TSJ_B_EX_Input            AS sopyjtsjbexinput, ");
		sb.append("       S_OP_YJ_TSJ_C_ZF_Radio            AS sopyjtsjczfradio, ");
		sb.append("       S_OP_YJ_TSJ_C_RL_Radio            AS sopyjtsjcrlradio, ");
		sb.append("       S_OP_YJ_TSJ_C_EX_Radio            AS sopyjtsjcexradio, ");
		sb.append("       S_OP_YJ_TSJ_C_ZF_Input            AS sopyjtsjczfinput, ");
		sb.append("       S_OP_YJ_TSJ_C_RL_Input            AS sopyjtsjcrlinput, ");
		sb.append("       S_OP_YJ_TSJ_C_EX_Input            AS sopyjtsjcexinput, ");
		sb.append("       S_OP_YJ_TSJ_D_ZF_Radio            AS sopyjtsjdzfradio, ");
		sb.append("       S_OP_YJ_TSJ_D_RL_Radio            AS sopyjtsjdrlradio, ");
		sb.append("       S_OP_YJ_TSJ_D_EX_Radio            AS sopyjtsjdexradio, ");
		sb.append("       S_OP_YJ_TSJ_D_ZF_Input            AS sopyjtsjdzfinput, ");
		sb.append("       S_OP_YJ_TSJ_D_RL_Input            AS sopyjtsjdrlinput, ");
		sb.append("       S_OP_YJ_TSJ_D_EX_Input            AS sopyjtsjdexinput, ");
		sb.append("       S_OP_YJ_TSJ_E_ZF_Radio            AS sopyjtsjezfradio, ");
		sb.append("       S_OP_YJ_TSJ_E_RL_Radio            AS sopyjtsjerlradio, ");
		sb.append("       S_OP_YJ_TSJ_E_EX_Radio            AS sopyjtsjeexradio, ");
		sb.append("       S_OP_YJ_TSJ_E_ZF_Input            AS sopyjtsjezfinput, ");
		sb.append("       S_OP_YJ_TSJ_E_RL_Input            AS sopyjtsjerlinput, ");
		sb.append("       S_OP_YJ_TSJ_E_EX_Input            AS sopyjtsjeexinput, ");
		sb.append("       S_OP_YJ_TSJ_F_ZF_Radio            AS sopyjtsjfzfradio, ");
		sb.append("       S_OP_YJ_TSJ_F_RL_Radio            AS sopyjtsjfrlradio, ");
		sb.append("       S_OP_YJ_TSJ_F_EX_Radio            AS sopyjtsjfexradio, ");
		sb.append("       S_OP_YJ_TSJ_F_ZF_Input            AS sopyjtsjfzfinput, ");
		sb.append("       S_OP_YJ_TSJ_F_RL_Input            AS sopyjtsjfrlinput, ");
		sb.append("       S_OP_YJ_TSJ_F_EX_Input            AS sopyjtsjfexinput, ");
		sb.append("       S_OP_YJ_TSJ_G_ZF_Radio            AS sopyjtsjgzfradio, ");
		sb.append("       S_OP_YJ_TSJ_G_RL_Radio            AS sopyjtsjgrlradio, ");
		sb.append("       S_OP_YJ_TSJ_G_EX_Radio            AS sopyjtsjgexradio, ");
		sb.append("       S_OP_YJ_TSJ_G_ZF_Input            AS sopyjtsjgzfinput, ");
		sb.append("       S_OP_YJ_TSJ_G_RL_Input            AS sopyjtsjgrlinput, ");
		sb.append("       S_OP_YJ_TSJ_G_EX_Input            AS sopyjtsjgexinput, ");
		sb.append("       S_OP_YJ_TSJ_H_ZF_Radio            AS sopyjtsjhzfradio, ");
		sb.append("       S_OP_YJ_TSJ_H_RL_Radio            AS sopyjtsjhrlradio, ");
		sb.append("       S_OP_YJ_TSJ_H_EX_Radio            AS sopyjtsjhexradio, ");
		sb.append("       S_OP_YJ_TSJ_H_ZF_Input            AS sopyjtsjhzfinput, ");
		sb.append("       S_OP_YJ_TSJ_H_RL_Input            AS sopyjtsjhrlinput, ");
		sb.append("       S_OP_YJ_TSJ_H_EX_Input            AS sopyjtsjhexinput, ");
		sb.append("       S_OP_YJ_TSJ_I_ZF_Radio            AS sopyjtsjizfradio, ");
		sb.append("       S_OP_YJ_TSJ_I_RL_Radio            AS sopyjtsjirlradio, ");
		sb.append("       S_OP_YJ_TSJ_I_EX_Radio            AS sopyjtsjiexradio, ");
		sb.append("       S_OP_YJ_TSJ_I_ZF_Input            AS sopyjtsjizfinput, ");
		sb.append("       S_OP_YJ_TSJ_I_RL_Input            AS sopyjtsjirlinput, ");
		sb.append("       S_OP_YJ_TSJ_I_EX_Input            AS sopyjtsjiexinput, ");		
		sb.append("       S_OP_YJ_TSJ_RefLef_Radio          AS sopyjtsjreflefradio, ");
		sb.append("       S_OP_YJ_TSJ_CcSc_Radio            AS sopyjtsjccscradio, ");
		sb.append("       S_OP_YJ_TSJ_1050_Radio            AS sopyjtsj1050radio, ");		
		sb.append("       S_OP_YJ_FXJC                      AS sopyjfxjc, ");
		sb.append("       S_OP_YJ_TSJC_Select               AS sopyjtsjcselect, ");
		sb.append("       S_OP_YJ_TSJC_Input                AS sopyjtsjcinput, ");
		sb.append("       S_OP_YJ_TJLMD_Shuangmianjingdushu AS sopyjtjlmdshuangmianjingdushu, ");
		sb.append("       S_OP_YJ_TJLMD_Shibiao             AS sopyjtjlmdshibiao, ");
		sb.append("       S_OP_YJ_TJLMD_Ou                  AS sopyjtjlmdou, ");
		sb.append("       S_OP_YJ_TJLMD_Od                  AS sopyjtjlmdod, ");
		sb.append("       S_OP_YJ_TJLMD_Os                  AS sopyjtjlmdos, ");
		sb.append("       S_OP_YJ_SLJ_LY_Q_SELECTOD			AS sljlyqselectod, ");
		sb.append("       S_OP_YJ_SLJ_LY_Q_SELECTOS			AS sljlyqselectos, ");
		sb.append("       S_OP_YJ_SLJ_DJ_Q_SELECTOD			AS sljdjqselectod, ");
		sb.append("       S_OP_YJ_SLJ_DJ_Q_SELECTOS			AS sljdjqselectos, ");
		sb.append("       S_OP_YJ_SLJ_LY_H_SELECTOD			AS sljlyhselectod, ");
		sb.append("       S_OP_YJ_SLJ_LY_H_SELECTOS			AS sljlyhselectos, ");
		sb.append("       S_OP_YJ_SLJ_DJ_H_SELECTOD			AS sljdjhselectod, ");
		sb.append("       S_OP_YJ_SLJ_DJ_H_SELECTOS  		AS sljdjhselectos ");
		sb.append("FROM   S_OP_Yanji ");
		sb.append("       INNER JOIN S_ME_CustomerInfo ON S_OP_YJ_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("       INNER JOIN B_Departments ON B_DP_DepartmentID = S_OP_YJ_ShopCode ");
		sb.append("       INNER JOIN SYS_PersonInfo ON SYS_PersonInfo.ID = S_OP_YJ_Personid ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSopyjid()))){
			sb.append(" and S_OP_YJ_ID='"+po.getSopyjid()+"'");
		}
		
		return (YjCheckPo)queryForObject(sb.toString(), null, YjCheckPo.class);
	}
	
	public YjCheckPo getLastYjCheck(YjCheckPo po) {
		
		StringBuffer  sb = new StringBuffer();
		sb.append("SELECT top 1 S_OP_YJ_ID                        AS sopyjid, ");
		sb.append("       S_OP_YJ_CustomerID                AS sopyjcustomerid, ");
		sb.append("       S_ME_CI_MemberId                	AS sopyjcustomerMemberId, ");
		sb.append("       S_ME_CI_Name                		AS sopyjcustomername, ");
		sb.append("       S_ME_CI_Sex                		AS sopyjcustomersex, ");
		sb.append("       S_OP_YJ_ShopCode                  AS sopyjshopcode, ");
		sb.append("       B_DP_DepartmentName               AS sopyjshopname, ");
		sb.append("       personName                        AS sopyjpersonname, ");
		sb.append("       S_OP_YJ_Personid                  AS sopyjpersonid, ");
		sb.append("       S_OP_YJ_Datetime                  AS sopyjdatetime, ");
		sb.append("       S_OP_YJ_DCTW_Touxiang             AS sopyjdctwtouxiang, ");
		sb.append("       S_OP_YJ_DCTW_Jianqing             AS sopyjdctwjianqing, ");
		sb.append("       S_OP_YJ_DCTW_Waitoushiyan         AS sopyjdctwwaitoushiyan, ");
		sb.append("       S_OP_YJ_JMYG_Luoyan               AS sopyjjmygluoyan, ");
		sb.append("       S_OP_YJ_JMYG_Daijing              AS sopyjjmygdaijing, ");
		sb.append("       S_OP_YJ_JMYG_Kongzhizhengwei      AS sopyjjmygkongzhizhengwei, ");
		sb.append("       S_OP_YJ_JMYG_Zhudaoyan            AS sopyjjmygzhudaoyan, ");
		sb.append("       S_OP_YJ_SLJ                       AS sopyjslj, ");
		sb.append("       S_OP_YJ_SLJ_5MOD_Luoyan           AS sopyjslj5modluoyan, ");
		sb.append("       S_OP_YJ_SLJ_5MOD_Daijing          AS sopyjslj5moddaijing, ");
		sb.append("       S_OP_YJ_SLJ_5MOS_Luoyan           AS sopyjslj5mosluoyan, ");
		sb.append("       S_OP_YJ_SLJ_5MOS_Daijing          AS sopyjslj5mosdaijing, ");
		sb.append("       S_OP_YJ_SLJ_3MOD_Luoyan           AS sopyjslj3modluoyan, ");
		sb.append("       S_OP_YJ_SLJ_3MOD_Daijing          AS sopyjslj3moddaijing, ");
		sb.append("       S_OP_YJ_SLJ_3MOS_Luoyan           AS sopyjslj3mosluoyan, ");
		sb.append("       S_OP_YJ_SLJ_3MOS_Daijing          AS sopyjslj3mosdaijing, ");
		sb.append("       S_OP_YJ_SLJ_YQYD_Shuangyan        AS sopyjsljyqydshuangyan, ");
		sb.append("       S_OP_YJ_SLJ_YQYD_Danyan           AS sopyjsljyqyddanyan, ");
		sb.append("       S_OP_YJ_TSJ_1ZJXJ_Luoyan          AS sopyjtsj1zjxjluoyan, ");
		sb.append("       S_OP_YJ_SLJ_1ZJXJ_Daijing         AS sopyjslj1zjxjdaijing, ");
		sb.append("       S_OP_YJ_TSJ_1TJXJ_Luoyan          AS sopyjtsj1tjxjluoyan, ");
		sb.append("       S_OP_YJ_SLJ_1TJXJ_Daijing         AS sopyjslj1tjxjdaijing, ");
		sb.append("       S_OP_YJ_TSJ_2Ronghedian           AS sopyjtsj2ronghedian, ");
		sb.append("       S_OP_YJ_SLJ_2Ronghefanwei         AS sopyjslj2ronghefanwei, ");
		sb.append("       S_OP_YJ_TSJ_3Litishi              AS sopyjtsj3litishi, ");
		sb.append("       S_OP_YJ_SLJ_3TitmusLitishi        AS sopyjslj3titmuslitishi, ");
		sb.append("       S_OP_YJ_TSJ_A_ZF_Radio            AS sopyjtsjazfradio, ");
		sb.append("       S_OP_YJ_TSJ_A_RL_Radio            AS sopyjtsjarlradio, ");
		sb.append("       S_OP_YJ_TSJ_A_EX_Radio            AS sopyjtsjaexradio, ");
		sb.append("       S_OP_YJ_TSJ_A_ZF_Input            AS sopyjtsjazfinput, ");
		sb.append("       S_OP_YJ_TSJ_A_RL_Input            AS sopyjtsjarlinput, ");
		sb.append("       S_OP_YJ_TSJ_A_EX_Input            AS sopyjtsjaexinput, ");
		sb.append("       S_OP_YJ_TSJ_B_ZF_Radio            AS sopyjtsjbzfradio, ");
		sb.append("       S_OP_YJ_TSJ_B_RL_Radio            AS sopyjtsjbrlradio, ");
		sb.append("       S_OP_YJ_TSJ_B_EX_Radio            AS sopyjtsjbexradio, ");
		sb.append("       S_OP_YJ_TSJ_B_ZF_Input            AS sopyjtsjbzfinput, ");
		sb.append("       S_OP_YJ_TSJ_B_RL_Input            AS sopyjtsjbrlinput, ");
		sb.append("       S_OP_YJ_TSJ_B_EX_Input            AS sopyjtsjbexinput, ");
		sb.append("       S_OP_YJ_TSJ_C_ZF_Radio            AS sopyjtsjczfradio, ");
		sb.append("       S_OP_YJ_TSJ_C_RL_Radio            AS sopyjtsjcrlradio, ");
		sb.append("       S_OP_YJ_TSJ_C_EX_Radio            AS sopyjtsjcexradio, ");
		sb.append("       S_OP_YJ_TSJ_C_ZF_Input            AS sopyjtsjczfinput, ");
		sb.append("       S_OP_YJ_TSJ_C_RL_Input            AS sopyjtsjcrlinput, ");
		sb.append("       S_OP_YJ_TSJ_C_EX_Input            AS sopyjtsjcexinput, ");
		sb.append("       S_OP_YJ_TSJ_D_ZF_Radio            AS sopyjtsjdzfradio, ");
		sb.append("       S_OP_YJ_TSJ_D_RL_Radio            AS sopyjtsjdrlradio, ");
		sb.append("       S_OP_YJ_TSJ_D_EX_Radio            AS sopyjtsjdexradio, ");
		sb.append("       S_OP_YJ_TSJ_D_ZF_Input            AS sopyjtsjdzfinput, ");
		sb.append("       S_OP_YJ_TSJ_D_RL_Input            AS sopyjtsjdrlinput, ");
		sb.append("       S_OP_YJ_TSJ_D_EX_Input            AS sopyjtsjdexinput, ");
		sb.append("       S_OP_YJ_TSJ_E_ZF_Radio            AS sopyjtsjezfradio, ");
		sb.append("       S_OP_YJ_TSJ_E_RL_Radio            AS sopyjtsjerlradio, ");
		sb.append("       S_OP_YJ_TSJ_E_EX_Radio            AS sopyjtsjeexradio, ");
		sb.append("       S_OP_YJ_TSJ_E_ZF_Input            AS sopyjtsjezfinput, ");
		sb.append("       S_OP_YJ_TSJ_E_RL_Input            AS sopyjtsjerlinput, ");
		sb.append("       S_OP_YJ_TSJ_E_EX_Input            AS sopyjtsjeexinput, ");
		sb.append("       S_OP_YJ_TSJ_F_ZF_Radio            AS sopyjtsjfzfradio, ");
		sb.append("       S_OP_YJ_TSJ_F_RL_Radio            AS sopyjtsjfrlradio, ");
		sb.append("       S_OP_YJ_TSJ_F_EX_Radio            AS sopyjtsjfexradio, ");
		sb.append("       S_OP_YJ_TSJ_F_ZF_Input            AS sopyjtsjfzfinput, ");
		sb.append("       S_OP_YJ_TSJ_F_RL_Input            AS sopyjtsjfrlinput, ");
		sb.append("       S_OP_YJ_TSJ_F_EX_Input            AS sopyjtsjfexinput, ");
		sb.append("       S_OP_YJ_TSJ_G_ZF_Radio            AS sopyjtsjgzfradio, ");
		sb.append("       S_OP_YJ_TSJ_G_RL_Radio            AS sopyjtsjgrlradio, ");
		sb.append("       S_OP_YJ_TSJ_G_EX_Radio            AS sopyjtsjgexradio, ");
		sb.append("       S_OP_YJ_TSJ_G_ZF_Input            AS sopyjtsjgzfinput, ");
		sb.append("       S_OP_YJ_TSJ_G_RL_Input            AS sopyjtsjgrlinput, ");
		sb.append("       S_OP_YJ_TSJ_G_EX_Input            AS sopyjtsjgexinput, ");
		sb.append("       S_OP_YJ_TSJ_H_ZF_Radio            AS sopyjtsjhzfradio, ");
		sb.append("       S_OP_YJ_TSJ_H_RL_Radio            AS sopyjtsjhrlradio, ");
		sb.append("       S_OP_YJ_TSJ_H_EX_Radio            AS sopyjtsjhexradio, ");
		sb.append("       S_OP_YJ_TSJ_H_ZF_Input            AS sopyjtsjhzfinput, ");
		sb.append("       S_OP_YJ_TSJ_H_RL_Input            AS sopyjtsjhrlinput, ");
		sb.append("       S_OP_YJ_TSJ_H_EX_Input            AS sopyjtsjhexinput, ");
		sb.append("       S_OP_YJ_TSJ_I_ZF_Radio            AS sopyjtsjizfradio, ");
		sb.append("       S_OP_YJ_TSJ_I_RL_Radio            AS sopyjtsjirlradio, ");
		sb.append("       S_OP_YJ_TSJ_I_EX_Radio            AS sopyjtsjiexradio, ");
		sb.append("       S_OP_YJ_TSJ_I_ZF_Input            AS sopyjtsjizfinput, ");
		sb.append("       S_OP_YJ_TSJ_I_RL_Input            AS sopyjtsjirlinput, ");
		sb.append("       S_OP_YJ_TSJ_I_EX_Input            AS sopyjtsjiexinput, ");		
		sb.append("       S_OP_YJ_TSJ_RefLef_Radio          AS sopyjtsjreflefradio, ");
		sb.append("       S_OP_YJ_TSJ_CcSc_Radio            AS sopyjtsjccscradio, ");
		sb.append("       S_OP_YJ_TSJ_1050_Radio            AS sopyjtsj1050radio, ");		
		sb.append("       S_OP_YJ_FXJC                      AS sopyjfxjc, ");
		sb.append("       S_OP_YJ_TSJC_Select               AS sopyjtsjcselect, ");
		sb.append("       S_OP_YJ_TSJC_Input                AS sopyjtsjcinput, ");
		sb.append("       S_OP_YJ_TJLMD_Shuangmianjingdushu AS sopyjtjlmdshuangmianjingdushu, ");
		sb.append("       S_OP_YJ_TJLMD_Shibiao             AS sopyjtjlmdshibiao, ");
		sb.append("       S_OP_YJ_TJLMD_Ou                  AS sopyjtjlmdou, ");
		sb.append("       S_OP_YJ_TJLMD_Od                  AS sopyjtjlmdod, ");
		sb.append("       S_OP_YJ_TJLMD_Os                  AS sopyjtjlmdos, ");
		sb.append("       S_OP_YJ_SLJ_LY_Q_SELECTOD			AS sljlyqselectod, ");
		sb.append("       S_OP_YJ_SLJ_LY_Q_SELECTOS			AS sljlyqselectos, ");
		sb.append("       S_OP_YJ_SLJ_DJ_Q_SELECTOD			AS sljdjqselectod, ");
		sb.append("       S_OP_YJ_SLJ_DJ_Q_SELECTOS			AS sljdjqselectos, ");
		sb.append("       S_OP_YJ_SLJ_LY_H_SELECTOD			AS sljlyhselectod, ");
		sb.append("       S_OP_YJ_SLJ_LY_H_SELECTOS			AS sljlyhselectos, ");
		sb.append("       S_OP_YJ_SLJ_DJ_H_SELECTOD			AS sljdjhselectod, ");
		sb.append("       S_OP_YJ_SLJ_DJ_H_SELECTOS  		AS sljdjhselectos ");
		sb.append("FROM   S_OP_Yanji ");
		sb.append("       INNER JOIN S_ME_CustomerInfo ON S_OP_YJ_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID ");
		sb.append("       INNER JOIN B_Departments ON B_DP_DepartmentID = S_OP_YJ_ShopCode ");
		sb.append("       INNER JOIN SYS_PersonInfo ON SYS_PersonInfo.ID = S_OP_YJ_Personid ");
		sb.append("where 1=1 ");
		
		if(!"".equals(Utility.getName(po.getSopyjcustomerid()))){
			sb.append(" and S_OP_YJ_CustomerID='"+po.getSopyjcustomerid()+"'");
		}
		
		sb.append(" order by S_OP_YJ_Datetime desc");
		
		return (YjCheckPo)queryForObject(sb.toString(), null, YjCheckPo.class);
	}
	
	public void deleteYjCheck(YjCheckPo po){
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM S_OP_Yanji ");
		buffer.append("WHERE S_OP_YJ_ID = ?");

		List<String> params = new ArrayList<String>();
		params.add(po.getSopyjid());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
}
