package com.pengsheng.eims.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.dao.CustomerReturnVisitDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.CustomerVisitPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerReturnVisitDaoImpl extends BaseJdbcDaoSupport implements
		CustomerReturnVisitDao {

	/**
	 * 得到顾客回访信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerReturnVisitCount(SalesBasicPo salesBasicPo,
			CustomerVisitPo customerVisitPo,SystemParameterPo systemParameterPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciaddress()))){
			buffer.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#customerInfo') and type='U')");
			buffer.append("DROP TABLE #customerInfo ");
			buffer.append("select * into #customerInfo from S_ME_CustomerInfo where replace(S_ME_CI_Zone, ' ', '') like ? + '%' ");
			params.add(Utility.getName(customerVisitPo.getSmeciaddress()));
		}
		
		buffer.append("SELECT COUNT(smecvsalesid) ");
		buffer.append("FROM   (SELECT S_SE_SB_SalesID AS smecvsalesid ");
		if ("1".equals(systemParameterPo.getFspsplitsalesdataflag())){
			buffer.append("        FROM   S_SE_SalesBasic_Finished ");
		}else{
			buffer.append("        FROM   S_SE_SalesBasic ");
		}

		if(!"".equals(Utility.getName(customerVisitPo.getSmeciaddress()))){
			buffer.append("               left JOIN #customerInfo S_ME_CustomerInfo ON S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		}else{
			buffer.append("               left JOIN S_ME_CustomerInfo ON S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		}	
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))||!"".equals(Utility.getName(customerVisitPo.getPricemin()))||!"".equals(Utility.getName(customerVisitPo.getPricemax()))||!"".equals(Utility.getName(customerVisitPo.getBbdstealthclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdusetype()))||!"".equals(Utility.getName(customerVisitPo.getBbdfunctionclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdluminosityclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdrefractive()))||!"".equals(Utility.getName(customerVisitPo.getBbdmaterialclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdframematerialtype()))||!"".equals(Utility.getName(customerVisitPo.getSelcstpsupplierid())) ||!"".equals(Utility.getName(customerVisitPo.getBrandID()))||!"".equals(Utility.getName(customerVisitPo.getGoodsid()))||!"".equals(Utility.getName(customerVisitPo.getTechnologytypeid()))){
			if ("1".equals(systemParameterPo.getFspsplitsalesdataflag())){
				buffer.append("               INNER JOIN S_SE_SalesDetail_Finished ");
			}else{
				buffer.append("               INNER JOIN S_SE_SalesDetail ");
			}
			buffer.append("                 ON S_SE_SD_SalesID = S_SE_SB_SalesID ");
			buffer.append("               INNER JOIN B_GoodsInfo ");
			buffer.append("                 ON B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		}

		if (!"".equals(Utility.getName(customerVisitPo.getSmecvreturntype()))||!"".equals(Utility.getName(customerVisitPo.getSmecvfeedbackdatestart()))||!"".equals(Utility.getName(customerVisitPo.getSmecvfeedbackdateend()))||!"".equals(Utility.getName(customerVisitPo.getSmecvcontentment()))||"1".equals(Utility.getName(customerVisitPo.getSmecvreturntype()))) {
			buffer.append("               LEFT JOIN (SELECT S_ME_CV_SalesID, ");
			buffer.append("                                 S_ME_CustomerVisit.S_ME_CV_Id, ");
			buffer.append("                                 F_CS_Name, ");
			buffer.append("                                 S_ME_CV_FeedbackDate, ");
			buffer.append("                                 S_ME_CV_Contentment, ");
			buffer.append("                                 S_ME_CV_CustomerType ");
			buffer.append("                          FROM   S_ME_CustomerVisit ");
			buffer.append("                                 INNER JOIN (SELECT MAX(S_ME_CV_Id) AS S_ME_CV_Id ");
			buffer.append("                                             FROM   S_ME_CustomerVisit ");
			buffer.append("                                             GROUP  BY S_ME_CV_SalesID) cvid ");
			buffer.append("                                   ON cvid.S_ME_CV_Id = S_ME_CustomerVisit.S_ME_CV_Id ");
			buffer.append("                                 LEFT JOIN F_CustomerSatisfaction ");
			buffer.append("                                   ON F_CustomerSatisfaction.F_CS_ID = S_ME_CustomerVisit.S_ME_CV_Contentment) a ");
			buffer.append("                 ON a.S_ME_CV_SalesID = S_SE_SB_SalesID ");
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getHuifangcishu()))){
			if ("1".equals(systemParameterPo.getFspsplitsalesdataflag())){
				buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN S_SE_SalesBasic_Finished ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			}else{
				buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN S_SE_SalesBasic ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			}	
		}
		
		buffer.append("where 1=1 and S_SE_SB_InTransit = '13' ");

		// 回访类型
		if ("1".equals(Utility.getName(customerVisitPo.getSmecvreturntype()))) {
			buffer.append("and S_ME_CV_Id is not null ");
		} else if ("0".equals(Utility.getName(customerVisitPo
				.getSmecvreturntype()))) {
			buffer.append("and S_ME_CV_Id is null ");
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSalsepersonname()))){
			buffer.append(" and (select personName from dbo.SYS_PersonInfo where ID=S_SE_SB_SalerID ) like '%' + ? + '%'");
			params.add(customerVisitPo.getSalsepersonname());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getHuifangcishu()))){
			buffer.append(" and isnull(t1.hfCiShu,0)= ? ");
			params.add(customerVisitPo.getHuifangcishu());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSalestype()))){
			
			buffer.append("and S_SE_SB_OrdersType in ( ? ");
			
			String[] array = Utility.getName(customerVisitPo.getSalestype()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}
		//人群分类
		//普通
		if ("1".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and S_SE_SB_SalesValue < '2000' ");
		}
		//高档
		else if ("2".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and S_SE_SB_SalesValue >= '2000' ");
		}
		//青少年渐进
		else if ("3".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and DateDiff(year, S_ME_CI_Birthday , getdate()) < '18' and B_GoodsInfo.B_GI_isMutiLuminosity = 'J' ");
		}
		//中老年渐进
		else if ("4".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and DateDiff(year, S_ME_CI_Birthday , getdate()) >= '18' and B_GoodsInfo.B_GI_isMutiLuminosity = 'J' ");
		}

		//回访满意度
		if (!"".equals(Utility.getName(customerVisitPo.getSmecvcontentment()))) {
			buffer.append("and S_ME_CV_Contentment = ? ");
			params.add(customerVisitPo.getSmecvcontentment());
		}
		
		// 取镜时间
		if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbtakeglassstartdata()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbtakeglassstartdata()))
				&& "".equals(Utility.getName(salesBasicPo
						.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo
				.getSsesbtakeglassstartdata()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		// 回访时间
		if (!"".equals(Utility.getName(customerVisitPo
				.getSmecvfeedbackdatestart()))
				&& !"".equals(Utility.getName(customerVisitPo
						.getSmecvfeedbackdateend()))) {
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) <= ? ");

			params.add(customerVisitPo.getSmecvfeedbackdatestart());
			params.add(customerVisitPo.getSmecvfeedbackdateend());
		} else if (!"".equals(Utility.getName(customerVisitPo
				.getSmecvfeedbackdatestart()))
				&& "".equals(Utility.getName(customerVisitPo
						.getSmecvfeedbackdateend()))) {
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) >= ? ");

			params.add(customerVisitPo.getSmecvfeedbackdatestart());
		} else if ("".equals(Utility.getName(customerVisitPo
				.getSmecvfeedbackdatestart()))
				&& !"".equals(Utility.getName(customerVisitPo
						.getSmecvfeedbackdateend()))) {
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) <= ? ");

			params.add(customerVisitPo.getSmecvfeedbackdateend());
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmecishopcode()))){
			buffer.append("and S_ME_CI_ShopCode= ? ");
			params.add(customerVisitPo.getSmecishopcode());
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmecvsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmecvsalesid());
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea1()))){
			buffer.append(" and S_ME_CI_Area1 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea1()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea2()))){
			buffer.append(" and S_ME_CI_Area2 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea2()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea3()))){
			buffer.append(" and S_ME_CI_Area3 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea3()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea4()))){
			buffer.append(" and S_ME_CI_Area4 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea4()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea5()))){
			buffer.append(" and S_ME_CI_Area5 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea5()));
		}

		if(!"".equals(Utility.getName(customerVisitPo.getSmecvmemberid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(customerVisitPo.getSmecvmemberid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmeciname());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(customerVisitPo.getSmecisex());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciphone()))){
			buffer.append("and S_ME_CI_Phone like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmeciphone());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(customerVisitPo.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(customerVisitPo.getSmeciagemax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getStarttime()))	&& !"".equals(Utility.getName(customerVisitPo.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(customerVisitPo.getStarttime());
			params.add(customerVisitPo.getEndtime());
		} else if (!"".equals(Utility.getName(customerVisitPo.getStarttime()))&& "".equals(Utility.getName(customerVisitPo.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			params.add(customerVisitPo.getStarttime());
		} else if ("".equals(Utility.getName(customerVisitPo.getStarttime()))&& !"".equals(Utility.getName(customerVisitPo.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(customerVisitPo.getEndtime());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getStarttimes()))	&& !"".equals(Utility.getName(customerVisitPo.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(customerVisitPo.getStarttimes());
			params.add(customerVisitPo.getEndtimes());
		} else if (!"".equals(Utility.getName(customerVisitPo.getStarttimes()))&& "".equals(Utility.getName(customerVisitPo.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(customerVisitPo.getStarttimes());
		} else if ("".equals(Utility.getName(customerVisitPo.getStarttimes()))&& !"".equals(Utility.getName(customerVisitPo.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(customerVisitPo.getEndtimes());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getIntegralmin())) && !"".equals(Utility.getName(customerVisitPo.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(customerVisitPo.getIntegralmin());
			params.add(customerVisitPo.getIntegralmax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getIntegralmin()))&& "".equals(Utility.getName(customerVisitPo.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(customerVisitPo.getIntegralmin());
		} else if ("".equals(Utility.getName(customerVisitPo.getIntegralmin()))&& !"".equals(Utility.getName(customerVisitPo.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(customerVisitPo.getIntegralmax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getNumbermin())) && !"".equals(Utility.getName(customerVisitPo.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= ? ");
			buffer.append("and S_ME_CI_ConsumptionNumber <= ? ");
			params.add(customerVisitPo.getNumbermin());
			params.add(customerVisitPo.getNumbermax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getNumbermin()))&& "".equals(Utility.getName(customerVisitPo.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= ? ");
			params.add(customerVisitPo.getNumbermin());
		} else if ("".equals(Utility.getName(customerVisitPo.getNumbermin()))&& !"".equals(Utility.getName(customerVisitPo.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber <= ? ");
			params.add(customerVisitPo.getNumbermax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getPricemin())) && !"".equals(Utility.getName(customerVisitPo.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(customerVisitPo.getPricemin());
			params.add(customerVisitPo.getPricemax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getPricemin()))&& "".equals(Utility.getName(customerVisitPo.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			params.add(customerVisitPo.getPricemin());
		} else if ("".equals(Utility.getName(customerVisitPo.getPricemin()))&& !"".equals(Utility.getName(customerVisitPo.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(customerVisitPo.getPricemax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getAllpricemin())) && !"".equals(Utility.getName(customerVisitPo.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(customerVisitPo.getAllpricemin());
			params.add(customerVisitPo.getAllpricemax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getAllpricemin()))&& "".equals(Utility.getName(customerVisitPo.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			params.add(customerVisitPo.getAllpricemin());
		} else if ("".equals(Utility.getName(customerVisitPo.getAllpricemin()))&& !"".equals(Utility.getName(customerVisitPo.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(customerVisitPo.getAllpricemax());
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSelcstpsupplierid()))){
			buffer.append("and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(customerVisitPo.getSelcstpsupplierid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBrandID()))){
			buffer.append("and B_GoodsInfo.B_GI_BrandID= ? ");
			params.add(customerVisitPo.getBrandID());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getGoodsid()))){
			buffer.append("and B_GoodsInfo.B_GI_GoodsID= ? ");
			params.add(customerVisitPo.getGoodsid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getTechnologytypeid()))){
			buffer.append("and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(customerVisitPo.getTechnologytypeid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdframematerialtype()))){
			buffer.append("and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(customerVisitPo.getBbdframematerialtype());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdmaterialclass()))){
			buffer.append("and B_GoodsInfo.B_GI_EyeGlassMaterialType= ? ");
			params.add(customerVisitPo.getBbdmaterialclass());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdrefractive()))){
			buffer.append("and B_GoodsInfo.B_GI_Refractive= ? ");
			params.add(customerVisitPo.getBbdrefractive());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdluminosityclass()))){
			buffer.append("and B_GoodsInfo.B_GI_isMutiLuminosity= ? ");
			params.add(customerVisitPo.getBbdluminosityclass());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdfunctionclass()))){
			buffer.append("and B_GoodsInfo.B_GI_FunctionClass= ? ");
			params.add(customerVisitPo.getBbdfunctionclass());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdusetype()))){
			buffer.append("and B_GoodsInfo.B_GI_UseType= ? ");
			params.add(customerVisitPo.getBbdusetype());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdstealthclass()))){
			buffer.append("and B_GoodsInfo.B_GI_StealthClass= ? ");
			params.add(customerVisitPo.getBbdstealthclass());
		}
		
		if(customerVisitPo.getSmecishoplist() != null && customerVisitPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerVisitPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}		
		
		buffer.append("Group BY S_SE_SB_SalesID) visitcount ");
		
		return getJdbcTemplate().queryForInt(buffer.toString(),	params.toArray());
	}


	/**
	 * 查询顾客回访信息
	 * 
	 * @param SalesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerReturnVisitList(
			SalesBasicPo salesBasicPo, CustomerVisitPo customerVisitPo,
			int start, int size,SystemParameterPo systemParameterPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		int countPage = start + size;
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciaddress()))){
			buffer.append("if exists (select * from tempdb.dbo.sysobjects where id = object_id(N'tempdb..#customerInfo') and type='U')");
			buffer.append("DROP TABLE #customerInfo ");
			buffer.append("select * into #customerInfo from S_ME_CustomerInfo where replace(S_ME_CI_Zone, ' ', '') like ? + '%' ");
			params.add(Utility.getName(customerVisitPo.getSmeciaddress()));
		}
		
		
		buffer.append("set rowcount " + countPage + " \n");
		buffer.append("SELECT * ");
		buffer.append("FROM   (SELECT Row_number() OVER( ORDER BY S_SE_SB_SalesID DESC) AS rowNum, ");
		buffer.append("               S_SE_SB_SalesID                                   AS smecvsalesid, ");
		buffer.append("               S_ME_CI_Name                                      AS smecvcustomername, ");
		buffer.append("               S_ME_CI_Phone                                     AS smecvpersonphone, ");
		buffer.append("               S_ME_CI_MemberId                                  AS smecvmemberid, ");
		buffer.append("               S_SE_SB_SalesDatetime                             AS smecvsalestime, ");
		buffer.append("               S_ME_CV_Id                                        AS smecvid,F_CS_Name as sopoypersonid, ");
		buffer.append("               S_ME_CV_FeedbackDate                              AS smecvfeedbackdate ");
		
		if ("1".equals(systemParameterPo.getFspsplitsalesdataflag())){
			buffer.append("        FROM   S_SE_SalesBasic_Finished ");
		}else{
			buffer.append("        FROM   S_SE_SalesBasic ");
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciaddress()))){
			buffer.append("               left JOIN #customerInfo S_ME_CustomerInfo ON S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		}else{
			buffer.append("               left JOIN S_ME_CustomerInfo ON S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		}		
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))||!"".equals(Utility.getName(customerVisitPo.getPricemin()))||!"".equals(Utility.getName(customerVisitPo.getPricemax()))||!"".equals(Utility.getName(customerVisitPo.getBbdstealthclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdusetype()))||!"".equals(Utility.getName(customerVisitPo.getBbdfunctionclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdluminosityclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdrefractive()))||!"".equals(Utility.getName(customerVisitPo.getBbdmaterialclass()))||!"".equals(Utility.getName(customerVisitPo.getBbdframematerialtype()))||!"".equals(Utility.getName(customerVisitPo.getSelcstpsupplierid())) ||!"".equals(Utility.getName(customerVisitPo.getBrandID()))||!"".equals(Utility.getName(customerVisitPo.getGoodsid()))||!"".equals(Utility.getName(customerVisitPo.getTechnologytypeid()))){
			if ("1".equals(systemParameterPo.getFspsplitsalesdataflag())){
				buffer.append("           INNER JOIN S_SE_SalesDetail_Finished ");
			}else{
				buffer.append("           INNER JOIN S_SE_SalesDetail ");
			}		
			buffer.append("               ON S_SE_SD_SalesID = S_SE_SB_SalesID ");
			
			buffer.append("               INNER JOIN B_GoodsInfo ");
			buffer.append("                 ON B_GoodsInfo.B_GI_GoodsID = S_SE_SD_SalesItemID ");
		}	
		
		
		
		buffer.append("               LEFT JOIN (SELECT S_ME_CV_SalesID, ");
		buffer.append("                                 S_ME_CustomerVisit.S_ME_CV_Id, ");
		buffer.append("                                 F_CS_Name, ");
		buffer.append("                                 S_ME_CV_FeedbackDate, ");
		buffer.append("                                 S_ME_CV_Contentment, ");
		buffer.append("                                 S_ME_CV_CustomerType ");
		buffer.append("                          FROM   S_ME_CustomerVisit ");
		buffer.append("                                 INNER JOIN (select S_ME_CV_Id as S_ME_CV_Id from S_ME_CustomerVisit inner join  (SELECT MAX(S_ME_CV_FeedbackDate) AS S_ME_CV_FeedbackDate ,S_ME_CV_SalesID as S_ME_CV_SalesID FROM   S_ME_CustomerVisit  GROUP  BY S_ME_CV_SalesID) a on S_ME_CustomerVisit.S_ME_CV_FeedbackDate=a.S_ME_CV_FeedbackDate and  S_ME_CustomerVisit.S_ME_CV_SalesID=a.S_ME_CV_SalesID ");
		buffer.append("                                            ) cvid ");
		buffer.append("                                   ON cvid.S_ME_CV_Id = S_ME_CustomerVisit.S_ME_CV_Id ");
		buffer.append("                                 LEFT JOIN F_CustomerSatisfaction ");
		buffer.append("                                   ON F_CustomerSatisfaction.F_CS_ID = S_ME_CustomerVisit.S_ME_CV_Contentment) a ");
		buffer.append("                 ON a.S_ME_CV_SalesID = S_SE_SB_SalesID ");
		
		if(!"".equals(Utility.getName(customerVisitPo.getHuifangcishu()))){//回访次数
			if ("1".equals(systemParameterPo.getFspsplitsalesdataflag())){
				buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN S_SE_SalesBasic_Finished ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			}else{
				buffer.append(" left join  (select count(S_SE_SB_CustomerID) as hfCiShu,S_SE_SB_CustomerID as CustomerID  from S_ME_CustomerVisit LEFT JOIN S_SE_SalesBasic ON S_SE_SB_SalesID = S_ME_CV_SalesID group by S_SE_SB_CustomerID ) as t1 on t1.CustomerID=S_ME_CustomerInfo.S_ME_CI_CustomerID ");
			}
		}		
	
		buffer.append("        WHERE  1=1 ");
		buffer.append("               AND S_SE_SB_InTransit = '13' ");

		if(!"".equals(Utility.getName(customerVisitPo.getSalsepersonname()))){
			buffer.append(" and (select personName from dbo.SYS_PersonInfo where ID=S_SE_SB_SalerID ) like '%' + ? + '%'");
			params.add(customerVisitPo.getSalsepersonname());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getHuifangcishu()))){
			buffer.append(" and isnull(t1.hfCiShu,0)= ? ");
			params.add(customerVisitPo.getHuifangcishu());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSalestype()))){
			buffer.append("and S_SE_SB_OrdersType in ( ? ");
			
			String[] array = Utility.getName(customerVisitPo.getSalestype()).split(",");
			params.add(array[0]);
			for (int i = 1; i < array.length; i++){
				buffer.append(" ,? ");
				params.add(array[i]);
			}
			buffer.append(" ) ");
		}

		// 回访类型
		if ("1".equals(Utility.getName(customerVisitPo.getSmecvreturntype()))) {
			buffer.append("and S_ME_CV_Id is not null ");
		} else if ("0".equals(Utility.getName(customerVisitPo
				.getSmecvreturntype()))) {
			buffer.append("and S_ME_CV_Id is null ");
		}

		//人群分类
		//普通
		if ("1".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and S_SE_SB_SalesValue < '2000' ");
		}
		//高档
		else if ("2".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and S_SE_SB_SalesValue >= '2000' ");
		}
		//青少年渐进
		else if ("3".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and DateDiff(year, S_ME_CI_Birthday , getdate()) < '18' and B_GoodsInfo.B_GI_isMutiLuminosity = 'J' ");
		}
		//中老年渐进
		else if ("4".equals(Utility.getName(customerVisitPo.getSmecvcustomertype()))) {
			buffer.append("and DateDiff(year, S_ME_CI_Birthday , getdate()) >= '18' and B_GoodsInfo.B_GI_isMutiLuminosity = 'J' ");
		}

		//回访满意度
		if (!"".equals(Utility.getName(customerVisitPo.getSmecvcontentment()))) {
			buffer.append("and S_ME_CV_Contentment = ? ");
			params.add(customerVisitPo.getSmecvcontentment());
		}
		
		// 取镜时间
		if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbtakeglassstartdata()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
			params.add(salesBasicPo.getSsesbtakeglassenddata());
		} else if (!"".equals(Utility.getName(salesBasicPo
				.getSsesbtakeglassstartdata()))
				&& "".equals(Utility.getName(salesBasicPo
						.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) >= ? ");

			params.add(salesBasicPo.getSsesbtakeglassstartdata());
		} else if ("".equals(Utility.getName(salesBasicPo
				.getSsesbtakeglassstartdata()))
				&& !"".equals(Utility.getName(salesBasicPo
						.getSsesbtakeglassenddata()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_TakeGlassData, 23) <= ? ");

			params.add(salesBasicPo.getSsesbtakeglassenddata());
		}
		// 回访时间
		if (!"".equals(Utility.getName(customerVisitPo
				.getSmecvfeedbackdatestart()))
				&& !"".equals(Utility.getName(customerVisitPo
						.getSmecvfeedbackdateend()))) {
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) >= ? ");
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) <= ? ");

			params.add(customerVisitPo.getSmecvfeedbackdatestart());
			params.add(customerVisitPo.getSmecvfeedbackdateend());
		} else if (!"".equals(Utility.getName(customerVisitPo
				.getSmecvfeedbackdatestart()))
				&& "".equals(Utility.getName(customerVisitPo
						.getSmecvfeedbackdateend()))) {
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) >= ? ");

			params.add(customerVisitPo.getSmecvfeedbackdatestart());
		} else if ("".equals(Utility.getName(customerVisitPo
				.getSmecvfeedbackdatestart()))
				&& !"".equals(Utility.getName(customerVisitPo
						.getSmecvfeedbackdateend()))) {
			buffer
					.append("and convert(varchar(10), S_ME_CV_FeedbackDate, 23) <= ? ");

			params.add(customerVisitPo.getSmecvfeedbackdateend());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmecishopcode()))){
			buffer.append("and S_ME_CI_ShopCode= ? ");
			params.add(customerVisitPo.getSmecishopcode());
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmecvsalesid()))){
			buffer.append("and S_SE_SB_SalesID like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmecvsalesid());
		}
		
//		if(!"".equals(Utility.getName(customerVisitPo.getSmeciaddress()))){
//			buffer.append(" and replace(S_ME_CI_Zone, ' ', '') like '%' + ? + '%' ");
//			params.add(Utility.getName(customerVisitPo.getSmeciaddress()));
//		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea1()))){
			buffer.append(" and S_ME_CI_Area1 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea1()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea2()))){
			buffer.append(" and S_ME_CI_Area2 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea2()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea3()))){
			buffer.append(" and S_ME_CI_Area3 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea3()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea4()))){
			buffer.append(" and S_ME_CI_Area4 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea4()));
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciarea5()))){
			buffer.append(" and S_ME_CI_Area5 = ? ");
			params.add(Utility.getName(customerVisitPo.getSmeciarea5()));
		}

		if(!"".equals(Utility.getName(customerVisitPo.getSmecvmemberid()))){
			buffer.append("and S_ME_CI_CustomerID= ? ");
			params.add(customerVisitPo.getSmecvmemberid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciname()))){
			buffer.append("and S_ME_CI_Name like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmeciname());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmecisex()))){
			buffer.append("and S_ME_CI_Sex= ? ");
			params.add(customerVisitPo.getSmecisex());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciphone()))){
			buffer.append("and S_ME_CI_Phone like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmeciphone());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmecimemberid()))){
			buffer.append("and S_ME_CI_MemberId like '%' + ? + '%' ");
			params.add(customerVisitPo.getSmecimemberid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciagemin()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) >= ? ");
			params.add(customerVisitPo.getSmeciagemin());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getSmeciagemax()))){
			buffer.append("and year(getdate())-year(S_ME_CI_Birthday) <= ? ");
			params.add(customerVisitPo.getSmeciagemax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getStarttime()))	&& !"".equals(Utility.getName(customerVisitPo.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(customerVisitPo.getStarttime());
			params.add(customerVisitPo.getEndtime());
		} else if (!"".equals(Utility.getName(customerVisitPo.getStarttime()))&& "".equals(Utility.getName(customerVisitPo.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) >= ? ");
			params.add(customerVisitPo.getStarttime());
		} else if ("".equals(Utility.getName(customerVisitPo.getStarttime()))&& !"".equals(Utility.getName(customerVisitPo.getEndtime()))) {
			buffer.append("and convert(varchar(10), S_ME_CI_RegisterDate, 23) <= ? ");
			params.add(customerVisitPo.getEndtime());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getStarttimes()))	&& !"".equals(Utility.getName(customerVisitPo.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(customerVisitPo.getStarttimes());
			params.add(customerVisitPo.getEndtimes());
		} else if (!"".equals(Utility.getName(customerVisitPo.getStarttimes()))&& "".equals(Utility.getName(customerVisitPo.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) >= ? ");
			params.add(customerVisitPo.getStarttimes());
		} else if ("".equals(Utility.getName(customerVisitPo.getStarttimes()))&& !"".equals(Utility.getName(customerVisitPo.getEndtimes()))) {
			buffer.append("and convert(varchar(10), S_SE_SB_SalesDatetime, 23) <= ? ");
			params.add(customerVisitPo.getEndtimes());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getIntegralmin())) && !"".equals(Utility.getName(customerVisitPo.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(customerVisitPo.getIntegralmin());
			params.add(customerVisitPo.getIntegralmax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getIntegralmin()))&& "".equals(Utility.getName(customerVisitPo.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral >= ? ");
			params.add(customerVisitPo.getIntegralmin());
		} else if ("".equals(Utility.getName(customerVisitPo.getIntegralmin()))&& !"".equals(Utility.getName(customerVisitPo.getIntegralmax()))) {
			buffer.append("and S_ME_CI_Integral <= ? ");
			params.add(customerVisitPo.getIntegralmax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getNumbermin())) && !"".equals(Utility.getName(customerVisitPo.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= ? ");
			buffer.append("and S_ME_CI_ConsumptionNumber <= ? ");
			params.add(customerVisitPo.getNumbermin());
			params.add(customerVisitPo.getNumbermax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getNumbermin()))&& "".equals(Utility.getName(customerVisitPo.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber >= ? ");
			params.add(customerVisitPo.getNumbermin());
		} else if ("".equals(Utility.getName(customerVisitPo.getNumbermin()))&& !"".equals(Utility.getName(customerVisitPo.getNumbermax()))) {
			buffer.append("and S_ME_CI_ConsumptionNumber <= ? ");
			params.add(customerVisitPo.getNumbermax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getPricemin())) && !"".equals(Utility.getName(customerVisitPo.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(customerVisitPo.getPricemin());
			params.add(customerVisitPo.getPricemax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getPricemin()))&& "".equals(Utility.getName(customerVisitPo.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue >= ? ");
			params.add(customerVisitPo.getPricemin());
		} else if ("".equals(Utility.getName(customerVisitPo.getPricemin()))&& !"".equals(Utility.getName(customerVisitPo.getPricemax()))) {
			buffer.append("and S_SE_SB_SalesValue <= ? ");
			params.add(customerVisitPo.getPricemax());
		}
		
		if (!"".equals(Utility.getName(customerVisitPo.getAllpricemin())) && !"".equals(Utility.getName(customerVisitPo.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(customerVisitPo.getAllpricemin());
			params.add(customerVisitPo.getAllpricemax());
		} else if (!"".equals(Utility.getName(customerVisitPo.getAllpricemin()))&& "".equals(Utility.getName(customerVisitPo.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice >= ? ");
			params.add(customerVisitPo.getAllpricemin());
		} else if ("".equals(Utility.getName(customerVisitPo.getAllpricemin()))&& !"".equals(Utility.getName(customerVisitPo.getAllpricemax()))) {
			buffer.append("and S_ME_CI_ConsumptionPrice <= ? ");
			params.add(customerVisitPo.getAllpricemax());
		}
		
		if(!"".equals(Utility.getName(customerVisitPo.getSelcstpsupplierid()))){
			buffer.append("and B_GoodsInfo.B_GI_SupplierID= ? ");
			params.add(customerVisitPo.getSelcstpsupplierid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBrandID()))){
			buffer.append("and B_GoodsInfo.B_GI_BrandID= ? ");
			params.add(customerVisitPo.getBrandID());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getGoodsid()))){
			buffer.append("and B_GoodsInfo.B_GI_GoodsID= ? ");
			params.add(customerVisitPo.getGoodsid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getTechnologytypeid()))){
			buffer.append("and B_GoodsInfo.B_GI_frameProcessCraftType= ? ");
			params.add(customerVisitPo.getTechnologytypeid());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdframematerialtype()))){
			buffer.append("and B_GoodsInfo.B_GI_FrameMaterialType= ? ");
			params.add(customerVisitPo.getBbdframematerialtype());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdmaterialclass()))){
			buffer.append("and B_GoodsInfo.B_GI_EyeGlassMaterialType= ? ");
			params.add(customerVisitPo.getBbdmaterialclass());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdrefractive()))){
			buffer.append("and B_GoodsInfo.B_GI_Refractive= ? ");
			params.add(customerVisitPo.getBbdrefractive());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdluminosityclass()))){
			buffer.append("and B_GoodsInfo.B_GI_isMutiLuminosity= ? ");
			params.add(customerVisitPo.getBbdluminosityclass());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdfunctionclass()))){
			buffer.append("and B_GoodsInfo.B_GI_FunctionClass= ? ");
			params.add(customerVisitPo.getBbdfunctionclass());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdusetype()))){
			buffer.append("and B_GoodsInfo.B_GI_UseType= ? ");
			params.add(customerVisitPo.getBbdusetype());
		}
		if(!"".equals(Utility.getName(customerVisitPo.getBbdstealthclass()))){
			buffer.append("and B_GoodsInfo.B_GI_StealthClass= ? ");
			params.add(customerVisitPo.getBbdstealthclass());
		}
		
		if(customerVisitPo.getSmecishoplist() != null && customerVisitPo.getSmecishoplist().size() > 0){
			
			buffer.append(" and S_ME_CI_ShopCode in ( ? ");

			List<DepartmentsPo> dList = customerVisitPo.getSmecishoplist();
			params.add(Utility.getName(dList.get(0).getBdpdepartmentid()));

			for (int i = 1; i < dList.size(); i++){
				buffer.append(" ,? ");
				params.add(Utility.getName(dList.get(i).getBdpdepartmentid()));
			}
			buffer.append(" ) ");
		}		
		
		buffer.append("        GROUP  BY S_SE_SB_SalesID, ");
		buffer.append("                  S_ME_CI_Name, ");
		buffer.append("                  S_ME_CI_Phone, ");
		buffer.append("                  S_ME_CI_MemberId, ");
		buffer.append("                  S_SE_SB_SalesDatetime, ");
		buffer.append("                  S_ME_CV_Id,F_CS_Name, ");
		buffer.append("                  S_ME_CV_FeedbackDate) TEMP ");
		
		buffer.append(" where rowNum > " + start + " and rowNum <= "	+ countPage);
		buffer.append(" set rowcount 0");

		return queryForObjectList(buffer.toString(), params.toArray(),
				CustomerVisitPo.class);
	}

	/**
	 * 得到要回访的顾客信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getReturnCustomerInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 * from ( ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = S_SE_SalesBasic.S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append(" union all ");
		buffer.append("select S_SE_SB_SalesID as ssesbsalesid , ");
		buffer.append("S_SE_SB_ShopCode as ssesbshopcode , ");
		buffer.append("B_DP_DepartmentName as ssesbshopName , ");
		buffer.append("S_ME_CI_Name as ssesbpersonName , ");
		buffer.append("S_ME_CI_Phone as ssesbphone , ");
		buffer.append("S_SE_SB_SalesDatetime as ssesbsalesdatetime , ");
		buffer.append("S_SE_SB_TakeGlassData as ssesbtakeglassdata , ");
		buffer.append("S_SE_SB_PriceSum as ssesbpricesum , ");
		buffer.append("S_SE_SB_DiscountNum as ssesbdiscountnum , ");
		buffer.append("S_SE_SB_SalesValue as ssesbsalesvalue , ");
		buffer.append("S_SE_SB_Psalsvalue as ssesbpsalsvalue , ");
		buffer.append("S_ME_CI_MemberId as ssesbMemberId ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_ME_CustomerInfo on S_ME_CustomerInfo.S_ME_CI_CustomerID = S_SE_SB_CustomerID ");
		buffer.append("inner join B_Departments on B_Departments.B_DP_DepartmentID = S_SE_SB_ShopCode ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append(")temp ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params.toArray(), SalesBasicPo.class);
	}

	/**
	 * 取出销售单中右眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo) {
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 * from ( ");
		buffer.append("select S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod , ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod , ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod , ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append("union all ");
		buffer.append("select S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOD as ssesbballglassod , ");
		buffer.append("S_SE_SB_PostGlassOD as ssesbpostglassod , ");
		buffer.append("S_SE_SB_AxesOD as ssesbaxesod , ");
		buffer.append("S_SE_SB_ADDOD as ssesbaddod , ");
		buffer.append("S_SE_SB_ArriseGlassOD1 as ssesbarriseglassod , ");
		buffer.append("S_SE_SB_BasisOD1 as ssesbbasisod , ");
		buffer.append("S_SE_SB_PrismOD as ssesbprismod , ");
		buffer.append("S_SE_SB_InterHighOD as ssesbinterhighod , ");
		buffer.append("S_SE_SB_InterDistanceOD as ssesbinterdistanceod , ");
		buffer.append("S_SE_SB_FarVAOD as ssesbfarvaod , ");
		buffer.append("S_SE_SB_CloseVAOD as ssesbclosevaod ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append(" )t ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	/**
	 * 取出销售单中左眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 * from ( ");
		buffer.append("select S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOS as ssesbballglassos , ");
		buffer.append("S_SE_SB_PostGlassOS as ssesbpostglassos , ");
		buffer.append("S_SE_SB_AxesOS as ssesbaxesos , ");
		buffer.append("S_SE_SB_ADDOS as ssesbaddos , ");
		buffer.append("S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos , ");
		buffer.append("S_SE_SB_BasisOS1 as ssesbbasisos , ");
		buffer.append("S_SE_SB_PrismOS as ssesbprismos , ");
		buffer.append("S_SE_SB_InterHighOS as ssesbinterhighos , ");
		buffer.append("S_SE_SB_InterDistanceOS as ssesbinterdistanceos , ");
		buffer.append("S_SE_SB_FarVAOS as ssesbfarvaos , ");
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos ");
		buffer.append("from S_SE_SalesBasic ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append("union all ");
		buffer.append("select S_SE_SB_OrdersType as ssesborderstype , ");
		buffer.append("S_SE_SB_BallGlassOS as ssesbballglassos , ");
		buffer.append("S_SE_SB_PostGlassOS as ssesbpostglassos , ");
		buffer.append("S_SE_SB_AxesOS as ssesbaxesos , ");
		buffer.append("S_SE_SB_ADDOS as ssesbaddos , ");
		buffer.append("S_SE_SB_ArriseGlassOS1 as ssesbarriseglassos , ");
		buffer.append("S_SE_SB_BasisOS1 as ssesbbasisos , ");
		buffer.append("S_SE_SB_PrismOS as ssesbprismos , ");
		buffer.append("S_SE_SB_InterHighOS as ssesbinterhighos , ");
		buffer.append("S_SE_SB_InterDistanceOS as ssesbinterdistanceos , ");
		buffer.append("S_SE_SB_FarVAOS as ssesbfarvaos , ");
		buffer.append("S_SE_SB_CloseVAOS as ssesbclosevaos ");
		buffer.append("from S_SE_SalesBasic_Finished ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		buffer.append(" )t ");

		params.add(salesBasicPo.getSsesbsalesid());
		params.add(salesBasicPo.getSsesbsalesid());

		return (SalesBasicPo) queryForObject(buffer.toString(), params
				.toArray(), SalesBasicPo.class);
	}

	/**
	 * 得到配镜单中商品的详细信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsInfo(SalesDetailPo salesDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe ");
		buffer.append("from S_SE_SalesDetail ");
		buffer.append("inner join S_SE_SalesBasic on S_SE_SalesBasic.S_SE_SB_SalesID = S_SE_SalesDetail.S_SE_SD_SalesID ");
		buffer.append("where S_SE_SD_SalesID = ? ");
		buffer.append("union all ");
		buffer.append("select S_SE_SD_SalesItemID as ssesdsalesitemid , ");
		buffer.append("S_SE_SD_SalesItemName as ssesdsalesitemname , ");
		buffer.append("S_SE_SD_SPrice as ssesdsprice , ");
		buffer.append("S_SE_SD_Number as ssesdnumber , ");
		buffer.append("S_SE_SD_PriceSum as ssesdpricesum , ");
		buffer.append("S_SE_SD_DiscountRate as ssesddiscountrate , ");
		buffer.append("S_SE_SD_DiscountNum as ssesddiscountnum , ");
		buffer.append("S_SE_SD_SalesValue as ssesdsalesvalue , ");
		buffer.append("S_SE_SD_GoodDescribe as ssesdgooddescribe ");
		buffer.append("from S_SE_SalesDetail_Finished ");
		buffer.append("inner join S_SE_SalesBasic_Finished on S_SE_SB_SalesID = S_SE_SD_SalesID ");
		buffer.append("where S_SE_SD_SalesID = ? ");

		params.add(salesDetailPo.getSsesdsalesid());
		params.add(salesDetailPo.getSsesdsalesid());

		return queryForObjectList(buffer.toString(), params.toArray(),SalesDetailPo.class);
	}

	/**
	 * 取得附加费用
	 * 
	 * @param additionalCDetailPo
	 * @return
	 */
	public List<AdditionalCDetailPo> getAddititonalCDetail(
			AdditionalCDetailPo additionalCDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SalesID as ssesalesid , ");
		buffer.append("S_SE_CostsName as ssecostsname , ");
		buffer.append("S_SE_Amount as sseamount ");
		buffer.append("from S_SE_AdditionalCDetail ");
		buffer.append("where S_SE_SalesID = ? ");

		params.add(additionalCDetailPo.getSsesalesid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				AdditionalCDetailPo.class);
	}

	/**
	 * 取得特殊加工要求
	 * 
	 * @param specialPDetailPo
	 * @return
	 */
	public List<SpecialPDetailPo> getSpecialPDetail(
			SpecialPDetailPo specialPDetailPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select S_SE_SD_SalesID as ssesdsalesid , ");
		buffer.append("S_SE_SD_Requirement as ssesdrequirement ");
		buffer.append("from S_SE_SpecialPDetail ");
		buffer.append("where S_SE_SD_SalesID = ? ");

		params.add(specialPDetailPo.getSsesdsalesid());

		return queryForObjectList(buffer.toString(), params.toArray(),
				SpecialPDetailPo.class);
	}

	/**
	 * 得到顾客回访信息
	 * 
	 * @param customerVisitPo
	 * @return
	 */
	public List<CustomerVisitPo> getCustomerVisitInfo(CustomerVisitPo customerVisitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("select * from ( ");
		buffer.append("select S_ME_CV_FeedbackDate as smecvfeedbackdate , ");
		buffer.append("	S_ME_CV_SalesID as smecvsalesid , ");
		buffer.append("	S_ME_CV_CustomerName as smecvcustomername , ");
		buffer.append("	S_ME_CV_CustomerType as smecvcustomertype , ");
		buffer.append("	F_CS_Name as smecvcontentment , ");
		buffer.append("	S_ME_CV_FeedbackContent as smecvfeedbackcontent , ");
		buffer.append("	S_ME_CV_Resolvent as smecvresolvent , ");
		buffer.append("	S_ME_CV_Remark as smecvremark , ");
		buffer.append("case	S_ME_CV_Ssd when '1' then '良好' when '2' then '一般' end as smecvssd , ");
		buffer.append("case	S_ME_CV_Cprzd when '1' then '了解' when '2' then '不了解' end as smecvcprzd , ");
		buffer.append("case	S_ME_CV_Zcxz  when '1' then '会' when '2' then '不会' end as smecvzcxz , ");
		buffer.append("	personName as smecvpersonname , ");
		buffer.append(" S_ME_CI_MemberId as smecvmemberid, ");
		buffer.append(" S_ME_CV_VisitType as smecvreturntype,S_ME_CV_Iphone as smecvpersonphone,S_ME_CV_Content as smecvcontent  ");
		buffer.append("from S_ME_CustomerVisit ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID = S_ME_CustomerVisit.S_ME_CV_PersonID ");
		buffer.append("left join F_CustomerSatisfaction on S_ME_CV_Contentment = F_CS_ID ");
		buffer.append("inner join (select S_SE_SB_SalesID , S_ME_CI_MemberId from S_SE_SalesBasic ");
		buffer.append("inner join S_ME_CustomerInfo ");
		buffer.append("on S_SE_SalesBasic.S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID) a ");
		buffer.append("on a.S_SE_SB_SalesID = S_ME_CustomerVisit.S_ME_CV_SalesID ");
		buffer.append("where S_ME_CV_SalesID = ? ");
		buffer.append("union all ");
		buffer.append("select S_ME_CV_FeedbackDate as smecvfeedbackdate , ");
		buffer.append("	S_ME_CV_SalesID as smecvsalesid , ");
		buffer.append("	S_ME_CV_CustomerName as smecvcustomername , ");
		buffer.append("	S_ME_CV_CustomerType as smecvcustomertype , ");
		buffer.append("	F_CS_Name as smecvcontentment , ");
		buffer.append("	S_ME_CV_FeedbackContent as smecvfeedbackcontent , ");
		buffer.append("	S_ME_CV_Resolvent as smecvresolvent , ");
		buffer.append("	S_ME_CV_Remark as smecvremark , ");
		buffer.append("case	S_ME_CV_Ssd when '1' then '良好' when '2' then '一般' end as smecvssd , ");
		buffer.append("case	S_ME_CV_Cprzd when '1' then '了解' when '2' then '不了解' end as smecvcprzd , ");
		buffer.append("case	S_ME_CV_Zcxz  when '1' then '会' when '2' then '不会' end as smecvzcxz , ");
		buffer.append("	personName as smecvpersonname , ");
		buffer.append(" S_ME_CI_MemberId as smecvmemberid, ");
		buffer.append(" S_ME_CV_VisitType as smecvreturntype,S_ME_CV_Iphone as smecvpersonphone,S_ME_CV_Content as smecvcontent  ");
		buffer.append("from S_ME_CustomerVisit ");
		buffer.append("inner join SYS_PersonInfo on SYS_PersonInfo.ID = S_ME_CustomerVisit.S_ME_CV_PersonID ");
		buffer.append("left join F_CustomerSatisfaction on S_ME_CV_Contentment = F_CS_ID ");
		buffer.append("inner join (select S_SE_SB_SalesID , S_ME_CI_MemberId from S_SE_SalesBasic_Finished ");
		buffer.append("inner join S_ME_CustomerInfo ");
		buffer.append("on S_SE_SB_CustomerID = S_ME_CustomerInfo.S_ME_CI_CustomerID) a ");
		buffer.append("on a.S_SE_SB_SalesID = S_ME_CustomerVisit.S_ME_CV_SalesID ");
		buffer.append("where S_ME_CV_SalesID = ? ");		
		buffer.append(" )t ");
		buffer.append("order by smecvfeedbackdate desc ");

		params.add(customerVisitPo.getSmecvsalesid());
		params.add(customerVisitPo.getSmecvsalesid());

		return queryForObjectList(buffer.toString() , params.toArray() , CustomerVisitPo.class);
	}

	/**
	 * 插入回访明细表
	 * 
	 * @param customerVisitPo
	 */
	public void insertCustomerVisit(CustomerVisitPo customerVisitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into S_ME_CustomerVisit( ");
		buffer.append("S_ME_CV_Id , ");
		buffer.append("S_ME_CV_SalesID , ");
		buffer.append("S_ME_CV_CustomerName , ");
		buffer.append("S_ME_CV_FeedbackDate , ");
		buffer.append("S_ME_CV_CustomerType , ");
		buffer.append("S_ME_CV_Contentment , ");
		buffer.append("S_ME_CV_FeedbackContent , ");
		buffer.append("S_ME_CV_Resolvent , ");
		buffer.append("S_ME_CV_Remark , ");
		buffer.append("S_ME_CV_PersonID,  ");
		buffer.append("S_ME_CV_VisitType , ");
		buffer.append("S_ME_CV_Iphone,  ");
		buffer.append("S_ME_CV_Ssd,  ");
		buffer.append("S_ME_CV_Cprzd,  ");
		buffer.append("S_ME_CV_Zcxz,  ");
		buffer.append("S_ME_CV_Content ) ");
		buffer.append("values (? , ? , ? , getdate() , ? , ? , ? , ? , ? , ?, ? ,? ,? ,? ,? ,? ) ");

		params.add(this.uuid.generate());
		params.add(customerVisitPo.getSmecvsalesid());
		params.add(customerVisitPo.getSmecvcustomername());
		params.add(customerVisitPo.getSmecvcustomertype());
		params.add(customerVisitPo.getSmecvcontentment());
		params.add(customerVisitPo.getSmecvfeedbackcontent());
		params.add(customerVisitPo.getSmecvresolvent());
		params.add(customerVisitPo.getSmecvremark());
		params.add(customerVisitPo.getSmecvpersonid());
		params.add(customerVisitPo.getSmecvreturntype());
		params.add(customerVisitPo.getSmecvpersonphone());
		params.add(customerVisitPo.getSmecvssd());
		params.add(customerVisitPo.getSmecvcprzd());
		params.add(customerVisitPo.getSmecvzcxz());
		params.add(customerVisitPo.getSmecvcontent());
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}
	
	/**
	 * 删除回访明细表信息
	 * @param customerVisitPo
	 */
	public void deleteCustomerVisit(CustomerVisitPo customerVisitPo) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();
		
		buffer.append("delete from S_ME_CustomerVisit where S_ME_CV_SalesID = ? ");
		
		params.add(customerVisitPo.getSmecvsalesid());
		
		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

	/**
	 * 查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1 S_ME_CI_CustomerID as smecicustomerid,S_ME_CI_MemberId as smecimemberid,S_ME_CI_Phone as smeciphone,S_ME_CI_Name as smeciname ");
		buffer.append("from S_ME_CustomerInfo ");
		buffer.append("inner join S_SE_SalesBasic on S_ME_CustomerInfo.S_ME_CI_CustomerID=S_SE_SalesBasic.S_SE_SB_CustomerID ");
		buffer.append("where S_SE_SB_SalesID = ? ");
		params.add(salesid);

		return (CustomerInfoPo) queryForObject(buffer.toString(), params
				.toArray(), CustomerInfoPo.class);
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("select top 1  F_SS_VisitFlag as fssvisitflag , F_SS_VisitDate as fssvisitdate,F_SS_VisitTime as fssvisittime,F_SS_VisitContent as fssvisitcontent ");
		buffer.append("from F_SmsSet ");

		return (SmsSetPo) queryForObject(buffer.toString(), null,
				SmsSetPo.class);
	}

	/**
	 * 新增短信记录表
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) {

		StringBuffer buffer = new StringBuffer();
		List<String> params = new ArrayList<String>();

		buffer.append("insert into F_SmsRecord ");
		buffer.append("(F_SR_id,F_SR_ReceiptPerson,F_SR_ReceiptTel, ");
		buffer.append("F_SR_SendPerson,F_SR_SendContext,F_SR_SendDate,F_SR_SendFlag )");
		buffer.append("values(? , ? , ? , ? , ? , getdate() , '1' ) ");

		params.add(this.uuid.generate());
		params.add(smsRecordPo.getFsrreceiptperson());
		params.add(smsRecordPo.getFsrreceipttel());
		params.add(smsRecordPo.getFsrsendperson());
		params.add(smsRecordPo.getFsrsendcontext());
		// params.add(smsRecordPo.getFsrsenddate());
		// params.add(smsRecordPo.getFsrsendflag());

		getJdbcTemplate().update(buffer.toString(), params.toArray());
	}

}
