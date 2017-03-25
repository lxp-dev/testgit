package com.pengsheng.weixin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.dao.WeiXinDataConfigDao;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;

public class WeiXinDataConfigDaoImpl extends BaseJdbcDaoSupport implements WeiXinDataConfigDao {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	/**
	 * 获取微信数据配置
	 * @param po
	 */
	public WeiXinDataConfigPo getWeiXinDataConfigPo(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("select top 1 W_DC_RegistAgreement as wdcregistagreement");
		buffer.append(",W_DC_IntegralAgreement as wdcintegralagreement");
		buffer.append(",W_DC_OptometryAppointment as wdcoptometryappointment");
		buffer.append(",W_DC_NewCmsType as wdcnewcmstype");
		buffer.append(",w1.W_CMS_C_Title as wdcregistagreementname");
		buffer.append(",w2.W_CMS_C_Title as wdcintegralagreementname");
		buffer.append(",w3.W_CMS_C_Title as wdcoptometryappointmentname");
		buffer.append(",w4.W_CMS_T_Name as wdcnewcmstypename");	
		buffer.append(",isnull(W_DC_DepartmentPicUrl,'') as wdcdepartmentpicurl");
		buffer.append(",isnull(W_DC_CmsLargeicUrl,'') as wdccmslargepicurl ");
		buffer.append(",isnull(W_DC_CmsSmallPicUrl,'') as wdccmssmallpicurl ");
		buffer.append(",isnull(W_DC_PersonCenterPicUrl,'') as wdcpersoncenterpicurl ");		
		buffer.append(",W_DC_ContactUsLxfs as wdccontactuslxfs");
		buffer.append(",w5.W_CMS_C_Title as wdccontactuslxfstitle");	
		buffer.append(",w5.W_CMS_C_Content as wdccontactuslxfscontent");	
		buffer.append(",W_DC_ContactUsLdlx as wdccontactusldlx");	
		buffer.append(",w6.W_CMS_C_Title as wdccontactusldlxtitle");	
		buffer.append(",w6.W_CMS_C_Content as wdccontactusldlxcontent");
		buffer.append(",W_DC_NewActivity as wdcnewactivity");
		buffer.append(",w7.W_CMS_T_Name as wdcnewactivityname");	
		buffer.append(",W_DC_Yqhy as wdcyqhy");
		buffer.append(",w8.W_CMS_C_Title as wdcyqhytitle");
		buffer.append(",W_DC_Yqhysuccess as wdcyqhysuccess");
		buffer.append(",w10.W_CMS_C_Title as wdcyqhysuccesstitle");
		buffer.append(",W_DC_Lxhx as wdclxhx");
		buffer.append(",w9.W_CMS_C_Title as wdclxhxtitle");
		
		buffer.append(",W_DC_Alert_Registersuccess as wdcalertregistersuccess");
		buffer.append(",W_DC_Alert_Yaoqingsuccess as wdcalertyaoqingsuccess");
		buffer.append(",W_DC_Alert_Yaoqingerror1 as wdcalertyaoqingerror1");
		buffer.append(",W_DC_Alert_Yaoqingerror2 as wdcalertyaoqingerror2");
		buffer.append(",W_DC_Alert_Jifenduihuansuccess as wdcalertjifenduihuansuccess");
		buffer.append(",W_DC_Alert_Jifenduihuanconfirm as wdcalertjifenduihuanconfirm");
		buffer.append(",W_DC_Alert_Yuyuesuccess as wdcalertyuyuesuccess");
		buffer.append(",W_DC_Alert_Yuyueerror as wdcalertyuyueerror");
		
		buffer.append(",W_DC_Introduction_Jifen as wdcintroductionjifen");
		buffer.append(",W_DC_Introduction_Chuzhi as wdcintroductionchuzhi");
		buffer.append(",W_DC_Introduction_Wodebingli as wdcintroductionwodebingli");
		buffer.append(",W_DC_Introduction_Zuixinyizhu as wdcintroductionzuixinyizhu");
		buffer.append(",W_DC_Introduction_Zuixinzhenliao as wdcintroductionzuixinzhenliao");
		
		buffer.append(" from W_DataConfig ");
		buffer.append(" left join W_CMS_Content w1 on W_DC_RegistAgreement = w1.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Content w2 on W_DC_IntegralAgreement = w2.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Content w3 on W_DC_OptometryAppointment = w3.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Type w4 on W_DC_NewCmsType = w4.W_CMS_T_ID ");
		buffer.append(" left join W_CMS_Content w5 on W_DC_ContactUsLxfs = w5.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Content w6 on W_DC_ContactUsLdlx = w6.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Type w7 on W_DC_NewActivity = w7.W_CMS_T_ID ");
		buffer.append(" left join W_CMS_Content w8 on W_DC_Yqhy = w8.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Content w9 on W_DC_Lxhx = w9.W_CMS_C_ID ");
		buffer.append(" left join W_CMS_Content w10 on W_DC_Yqhysuccess = w10.W_CMS_C_ID ");

		return (WeiXinDataConfigPo) queryForObject(buffer.toString(), null,WeiXinDataConfigPo.class);
	}
	
	/**
	 * 新增微信数据配置
	 */
	public void insertWeiXinDataConfigPo(WeiXinDataConfigPo po){
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into W_DataConfig (W_DC_RegistAgreement,W_DC_IntegralAgreement,W_DC_OptometryAppointment,W_DC_NewCmsType,W_DC_DepartmentPicUrl,W_DC_CmsLargeicUrl,W_DC_CmsSmallPicUrl,W_DC_PersonCenterPicUrl,W_DC_ContactUsLxfs,W_DC_ContactUsLdlx,W_DC_NewActivity,W_DC_Yqhy,W_DC_Yqhysuccess,W_DC_Lxhx,W_DC_Alert_Registersuccess,W_DC_Alert_Yaoqingsuccess,W_DC_Alert_Yaoqingerror1,W_DC_Alert_Yaoqingerror2,W_DC_Alert_Jifenduihuansuccess,W_DC_Alert_Jifenduihuanconfirm,W_DC_Alert_Yuyuesuccess,W_DC_Alert_Yuyueerror,W_DC_Introduction_Jifen,W_DC_Introduction_Chuzhi,W_DC_Introduction_Wodebingli,W_DC_Introduction_Zuixinyizhu,W_DC_Introduction_Zuixinzhenliao) ");
		buffer.append("values (? , ? , ? , ? , ?, ? , ?, ? , ?, ? , ? , ? , ? , ?, ? , ?, ? , ? , ? , ? , ?, ? , ? , ? , ? , ?, ?) ");
		
		params.add(Utility.getName(po.getWdcregistagreement()));
		params.add(Utility.getName(po.getWdcintegralagreement()));
		params.add(Utility.getName(po.getWdcoptometryappointment()));
		params.add(Utility.getName(po.getWdcnewcmstype()));
		params.add(Utility.getName(po.getWdcdepartmentpicurl()));
		params.add(Utility.getName(po.getWdccmslargepicurl()));
		params.add(Utility.getName(po.getWdccmssmallpicurl()));
		params.add(Utility.getName(po.getWdcpersoncenterpicurl()));	
		params.add(Utility.getName(po.getWdccontactuslxfs()));
		params.add(Utility.getName(po.getWdccontactusldlx()));
		params.add(Utility.getName(po.getWdcnewactivity()));
		params.add(Utility.getName(po.getWdcyqhy()));
		params.add(Utility.getName(po.getWdcyqhysuccess()));
		params.add(Utility.getName(po.getWdclxhx()));
		params.add(Utility.getName(po.getWdcalertregistersuccess()));
		params.add(Utility.getName(po.getWdcalertyaoqingsuccess()));
		params.add(Utility.getName(po.getWdcalertyaoqingerror1()));
		params.add(Utility.getName(po.getWdcalertyaoqingerror2()));
		params.add(Utility.getName(po.getWdcalertjifenduihuansuccess()));
		params.add(Utility.getName(po.getWdcalertjifenduihuanconfirm()));
		params.add(Utility.getName(po.getWdcalertyuyuesuccess()));
		params.add(Utility.getName(po.getWdcalertyuyueerror()));
		
		params.add(Utility.getName(po.getWdcintroductionjifen()));
		params.add(Utility.getName(po.getWdcintroductionchuzhi()));
		params.add(Utility.getName(po.getWdcintroductionwodebingli()));
		params.add(Utility.getName(po.getWdcintroductionzuixinyizhu()));
		params.add(Utility.getName(po.getWdcintroductionzuixinzhenliao()));
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 更新微信数据配置
	 */
	public void deleteWeiXinDataConfigPo(){
		StringBuffer buffer=new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from W_DataConfig");
		
		getJdbcTemplate().update(buffer.toString() , params.toArray());
	}
}
