/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.dao.WindowPersonDiscountDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.AdditionalCDetailDao;
import com.pengsheng.eims.sales.dao.FrameSalesDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.dao.SetMealDao;
import com.pengsheng.eims.sales.dao.SpecialPDetailDao;
import com.pengsheng.eims.sales.dao.ToMailDao;
import com.pengsheng.eims.sales.mgr.FrameSalesMgr;
import com.pengsheng.eims.sales.mgr.InspectionMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesRecipeNumViewPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;
import com.sun.org.apache.commons.collections.Buffer;

/**
 * @author Liuqian
 * 
 */
public class FrameSalesMgrImpl implements FrameSalesMgr {

	private FrameSalesDao frameSalesDao;
	private LogisticsLogDao logisticsLogDao;
	private WindowPersonDiscountDao windowPersonDiscountDao;
	private WarehouseMgr warehouseMgr;
	private SetMealDao setMealDao;
	private SpecialPDetailDao specialPDetailDao;
	private AdditionalCDetailDao additionalCDetailDao;
	private InspectionMgr inspectionMgr;
	private GuitarManagementDao guitarManagementDao;
	private InTransitDetailsDao inTransitDetailsDao;	
	private SystemParameterDao systemParameterDao;
	private SystemParameterPo systemParameterPo;
	private CustomerInfoDao customerInfoDao;
	private WarehouseConfigurationDao warehouseConfigurationDao; 
	private ToMailDao toMailDao;
	
	public static Properties oracleDriver= Tools.getProperty("/config/", "oracle.properties");	
	private static String driver =oracleDriver.getProperty("driver") ;
	private static String url = oracleDriver.getProperty("url");
	private static String user = oracleDriver.getProperty("user");
	private static String pwd = oracleDriver.getProperty("pwd");
	private static Connection conn;	
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
            System.out.println("加载驱动出现异常!");
		}
	}

	public static Connection getConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, pwd);
			}

			return conn;
		} catch (Exception e) {
			System.out.println("创建连接出现异常!");
		}
		return null;
	}

	public static void close(Connection con, Statement stm, ResultSet rs) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭连接出现异常!");
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				System.out.println("关闭通道出现异常!");
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("关闭结果集出现异常!");
			}
		}
	}
		
	public ToMailDao getToMailDao() {
		return toMailDao;
	}

	public void setToMailDao(ToMailDao toMailDao) {
		this.toMailDao = toMailDao;
	}

	public WarehouseConfigurationDao getWarehouseConfigurationDao() {
		return warehouseConfigurationDao;
	}

	public void setWarehouseConfigurationDao(
			WarehouseConfigurationDao warehouseConfigurationDao) {
		this.warehouseConfigurationDao = warehouseConfigurationDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}

	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}

	public SpecialPDetailDao getSpecialPDetailDao() {
		return specialPDetailDao;
	}

	public void setSpecialPDetailDao(SpecialPDetailDao specialPDetailDao) {
		this.specialPDetailDao = specialPDetailDao;
	}

	public AdditionalCDetailDao getAdditionalCDetailDao() {
		return additionalCDetailDao;
	}

	public void setAdditionalCDetailDao(AdditionalCDetailDao additionalCDetailDao) {
		this.additionalCDetailDao = additionalCDetailDao;
	}

	public InspectionMgr getInspectionMgr() {
		return inspectionMgr;
	}

	public void setInspectionMgr(InspectionMgr inspectionMgr) {
		this.inspectionMgr = inspectionMgr;
	}

	public SetMealDao getSetMealDao() {
		return setMealDao;
	}

	public void setSetMealDao(SetMealDao setMealDao) {
		this.setMealDao = setMealDao;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public WindowPersonDiscountDao getWindowPersonDiscountDao() {
		return windowPersonDiscountDao;
	}

	public void setWindowPersonDiscountDao(
			WindowPersonDiscountDao windowPersonDiscountDao) {
		this.windowPersonDiscountDao = windowPersonDiscountDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

 
	public FrameSalesDao getFrameSalesDao() {
		return frameSalesDao;
	}

	public void setFrameSalesDao(FrameSalesDao frameSalesDao) {
		this.frameSalesDao = frameSalesDao;
	}

	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,PersonInfoPo ppo) {		
       
		getHisCustomerInfoCount(po,ppo);
		
		return frameSalesDao.getCustomerInfo(po);
	}
	
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {		
		return frameSalesDao.getCustomerInfo(po);
	}

	public List<InspectionPo> getInspectionPos(String customerID) {
		return frameSalesDao.getInspectionPos(customerID);
	}


	public void insertSalesBasic(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,List<SpecialPDetailPo> specialPDetailList,List<AdditionalCDetailPo> additionalCDetailList,List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,String nwtype,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if (specialPDetailList != null && specialPDetailList.size() != 0){
			for (SpecialPDetailPo temp : specialPDetailList){
				specialPDetailDao.insertSpecialPDetail(temp);
			}
		}
		
		if (additionalCDetailList != null && additionalCDetailList.size() != 0){
			for (AdditionalCDetailPo temp : additionalCDetailList){
				additionalCDetailDao.insertAdditionalCDetail(temp);
			}
		}
		
		if("".equals(nwtype)){
			logPo.setsLogContent("框镜外方录入验光号："+Utility.getName(salesBasicPo.getSsesboptometryid())+" 新增!");
			inspectionMgr.inspectionInsert(inspectionPos, optometryPo, optometryBasicPo, logPo);
		}
		
		/*
		 * 销售基表
		 */
		salesBasicPo.setSsesbswapgoodsflag("1");
		
		//处理会员卡
		CustomerInfoPo customerInfoPo=frameSalesDao.getMemberType(salesBasicPo.getSsesbcustomerid());
		
		/*
		 * 特殊折扣更新 
		 */
		if("2".equals(salesBasicPo.getSsesbdiscounttype())){
			if(!"".equals(salesBasicPo.getSsesbgoodslevel())&&!"undefined".equals(salesBasicPo.getSsesbgoodslevel())){
				for(int i=0; i<salesDetailPo.getSsesddiscounttypes().length; i++){
					if(salesDetailPo.getSsesddiscounttypes()[i].equals("2")){
						windowPersonDiscountDao.updateSpecialDiscountNumberLevel(salesDetailPo.getSsesddiscountsources()[i],salesDetailPo.getSsesdgoodslevels()[i]);
					}
				}
			}else{
				windowPersonDiscountDao.updateSpecialDiscountNumber(salesBasicPo.getSsesbdiscountperson());
			}
		}
		
		/* 
		 * 销售明细表
		 */
		String nowdepartmentid = salesBasicPo.getSsesbshopcode();
		DepartmentsPo outdepartment = new DepartmentsPo();
		WarehousePo outwarehouse = new WarehousePo();
		
		for(int i=1;i<salesDetailPo.getSsesdsalesitemids().length;i++){
			SalesDetailPo temp= new SalesDetailPo();
			
			temp.setSsesdsalesid(salesDetailPo.getSsesdsalesid());
			temp.setSsesdsalesitemid(salesDetailPo.getSsesdsalesitemids()[i]);			
			outwarehouse.setBwhid(salesDetailPo.getSsesdstockids()[i]);
			outdepartment = warehouseMgr.getDepartments(outwarehouse);
			
		    String outdepartmentid = outdepartment.getBdpdepartmentid();
			
			temp.setSsesditemid(salesDetailPo.getSsesditemids()[i]);
			temp.setSsesdstockid(salesDetailPo.getSsesdstockids()[i]);
			temp.setSsesdsalesitemname(salesDetailPo.getSsesdsalesitemnames()[i]);
			temp.setSsesdsprice(salesDetailPo.getSsesdsprices()[i]);
			temp.setSsesdnumber(salesDetailPo.getSsesdnumbers()[i]);
			temp.setSsesdunitprice(salesDetailPo.getSsesdunitprices()[i]);
			temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdcostsprive(salesDetailPo.getSsesdcostsprives()[i]);
			temp.setSsesdsalesvalue(salesDetailPo.getSsesdsalesvalues()[i]);
			if("".equals(Utility.getName(salesDetailPo.getSsesddiscountrates()[i]))){
				temp.setSsesddiscountrate("1.00");
			}else{
				temp.setSsesddiscountrate(salesDetailPo.getSsesddiscountrates()[i]);
			}
			temp.setSsesddiscountnum(salesDetailPo.getSsesddiscountnums()[i]);
			temp.setSsesdgooddescribe(salesDetailPo.getSsesdgooddescribes()[i]);
			temp.setSsesdglassflag(salesDetailPo.getSsesdglassflags()[i]);
			temp.setSsesdcommoditiesflag(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1));
			temp.setSsesdlargessflag("0");
			temp.setSsesdysvalue(salesDetailPo.getSsesdpricesums()[i]);
			temp.setSsesdrenum(salesDetailPo.getSsesdrenums()[i]);
			temp.setSsesddiscounttype(salesDetailPo.getSsesddiscounttypes()[i]);
			temp.setSsesddiscountsource(salesDetailPo.getSsesddiscountsources()[i]);
			temp.setSsesdfavorable(salesDetailPo.getSsesdfavorables()[i]);
			temp.setSsesdsetmealid(salesDetailPo.getSsesdsetmealids()[i]);
			temp.setSsesdsetmealidno(salesDetailPo.getSsesdsetmealidnos()[i]);
			
			if("2".equals(Utility.getName(salesBasicPo.getSsesbisgiveyouintegral()))){
				temp.setSsesintegral("0");
			}else{
				IntegralPo ipo = setMealDao.getIntegralCountList2(salesDetailPo.getSsesdsalesitemids()[i],salesBasicPo.getSsesbshopcode(),customerInfoPo.getSmecicardtype());
				temp.setSsesintegral(Utility.getName(ipo.getFirIntegralCount()));
			}
			
			temp.setSsesdguaranteeperiod(salesDetailPo.getSsesdguaranteeperiods()[i]);
			temp.setSsesdbatch(salesDetailPo.getSsesdbatchs()[i]);
			temp.setSsesdishavestock(salesDetailPo.getSsesdishavestocks()[i]);
			
			this.frameSalesDao.insertSalesDetail(temp);
		}
			
			/*
			 * 赠品插入销售明细
			 */
			String[] goodsType=giftsPo.getBgsgoodstype().split(",");
			String[] goodsid=giftsPo.getBgsgoodsid().split(",");
			String[] goodsbarcode=giftsPo.getBgsgoodsbarcode().split(",");
			String[] costprice=giftsPo.getBgscostprice().split(",");
			String[] nottax=giftsPo.getBgsnottaxrate().split(",");
			String[] bgsviewname=giftsPo.getBgsviewname().split(",");
	 		
	 		/*
	 		 * 赠品
	 		 */
			for(int j=1;j<goodsType.length;j++){
				SalesDetailPo temp1= new SalesDetailPo();
				temp1.setSsesdsalesid(salesDetailPo.getSsesdsalesid());
				temp1.setSsesdsalesitemid(goodsid[j].trim());
				
				outwarehouse.setBwhid(giftsPo.getBgsstockid().split(",")[j].trim());
				outdepartment = warehouseMgr.getDepartments(outwarehouse);
				
				String outdepartmentid = outdepartment.getBdpdepartmentid();
				
				WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
				warehouseConfigurationPo.setBwcdeptid(Utility.getName(outdepartmentid));
				warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(warehouseConfigurationPo);	
				
				temp1.setSsesditemid(goodsbarcode[j].trim()); //天津眼科赠品发料完出库。
				
				temp1.setSsesdstockid(giftsPo.getBgsstockid().split(",")[j].trim());
				//赠品也附上8个0的条码
//				if("2".equals(warehouseConfigurationPo.getBwcxiaocangzp()) && ("1".equals(salesBasicPo.getSsesborderstype())||"2".equals(salesBasicPo.getSsesborderstype()))){
//					temp1.setSsesditemid("");
//				}
				temp1.setSsesdsalesitemname(bgsviewname[j].trim());
				temp1.setSsesdsprice("0.00");
				temp1.setSsesdnumber("1");
				temp1.setSsesdunitprice(nottax[j].trim());
				temp1.setSsesdpricesum("0.00");
				temp1.setSsesdcostsprive(costprice[j].trim());
				temp1.setSsesdsalesvalue("0.00");
				temp1.setSsesddiscountrate("0.00");
				temp1.setSsesddiscountnum("0.00");
				temp1.setSsesdgooddescribe("赠品");
				temp1.setSsesdglassflag("");
				temp1.setSsesdcommoditiesflag(goodsid[j].trim().substring(0, 1));
				temp1.setSsesdlargessflag("1");
				temp1.setSsesdysvalue("0.00");
				temp1.setSsesddiscounttype("");
				temp1.setSsesddiscountsource("");
				temp1.setSsesdfavorable("0.00");
				this.frameSalesDao.insertSalesDetail(temp1);
			}
			
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("mdxs");  // mdxs 表示门店销售
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				//新增在途库存的商品
				List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesBasicPo.getSsesbsalesid(),"out","0");
				if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
					for (InTransitStorageEntryPo po : inTransitStorageEntryList){
						po.setCshtsemoduleid("mdxs");
						guitarManagementDao.insertInTransitStroge(po);
					}
				}
			}
			
			/*
			 * 在途
			 */
			frameSalesDao.insertIntrnsitInfo(inTransitPo);
			this.frameSalesDao.insertSalesBasic(salesBasicPo);
	}
	
	public void insertShopSalesMain(SalesBasicPo salesBasicPo,SalesDetailPo salesDetailPo,GiftsPo giftsPo,InTransitPo inTransitPo,List<SpecialPDetailPo> specialPDetailList,List<AdditionalCDetailPo> additionalCDetailList,List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,String nwtype,LogisticsLogPo logPo,ToMailPo toMailPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if ((toMailPo != null) && (!Utility.getName(toMailPo.getSsetmuuid()).equals(""))){  // 新增邮寄信息
			frameSalesDao.insertToMail(toMailPo);
		}		
		
		if (specialPDetailList != null && specialPDetailList.size() != 0){
			for (SpecialPDetailPo temp : specialPDetailList){
				specialPDetailDao.insertSpecialPDetail(temp);
			}
		}
		
		StringBuffer additionname = new StringBuffer();
		BigDecimal additional = new BigDecimal(0.00);		
		if (additionalCDetailList != null && additionalCDetailList.size() != 0){
			
			for (AdditionalCDetailPo temp : additionalCDetailList){
				additionalCDetailDao.insertAdditionalCDetail(temp);
				
				if (additionname.length() > 0){
					additionname.append(",");
				}
				additionname.append(Utility.getName(temp.getSsecostsname()));
				
				additional = additional.add(new BigDecimal(Utility.getName(temp.getSsenumber())).multiply(new BigDecimal(Utility.getName(temp.getSseamount()))));
			}
		}
		
		if("".equals(nwtype)){
			logPo.setsLogContent("框镜外方录入验光号："+Utility.getName(salesBasicPo.getSsesboptometryid())+" 新增!");
			inspectionMgr.inspectionInsert(inspectionPos, optometryPo, optometryBasicPo, logPo);
		}
		
		/*
		 * 销售基表
		 */
		salesBasicPo.setSsesbswapgoodsflag("1");
		
		//处理会员卡
		CustomerInfoPo customerInfoPo=frameSalesDao.getMemberType(salesBasicPo.getSsesbcustomerid());
		
		/*
		 * 特殊折扣更新 
		 */
		if("2".equals(salesBasicPo.getSsesbdiscounttype())){
			if(!"".equals(salesBasicPo.getSsesbgoodslevel())&&!"undefined".equals(salesBasicPo.getSsesbgoodslevel())){
				for(int i=0; i<salesDetailPo.getSsesddiscounttypes().length; i++){
					if(salesDetailPo.getSsesddiscounttypes()[i].equals("2")){
						windowPersonDiscountDao.updateSpecialDiscountNumberLevel(salesDetailPo.getSsesddiscountsources()[i],salesDetailPo.getSsesdgoodslevels()[i]);
					}
				}
			}else{
				windowPersonDiscountDao.updateSpecialDiscountNumber(salesBasicPo.getSsesbdiscountperson());
			}
		}
		
		/* 
		 * 销售明细表
		 */
		DepartmentsPo outdepartment = new DepartmentsPo();
		WarehousePo outwarehouse = new WarehousePo();
		String zzcount = "0";
		int dzzcount = 0; // 判断是否存在双自片
		
		if (salesDetailPo != null){
			List<String> vipcardlist = new ArrayList<String>();
			
			if (Utility.getName(salesBasicPo.getSsesbhardvalueversion()).equals("2")){    // 天津眼科计算加工难度系数
				for(int ii = 0; ii < salesDetailPo.getSsesdsalesitemids().length; ii++){
					if("3.ZZ".equals(salesDetailPo.getSsesdsalesitemids()[ii].substring(0,4))){
						zzcount = "1";
					}
				}
			}
			
			for(int i = 0;i < salesDetailPo.getSsesdsalesitemids().length; i++){
				SalesDetailPo temp= new SalesDetailPo();
				
				temp.setSsesdsalesid(salesDetailPo.getSsesdsalesid());
				temp.setSsesdsalesitemid(salesDetailPo.getSsesdsalesitemids()[i]);			
				outwarehouse.setBwhid(salesDetailPo.getSsesdstockids()[i]);
				outdepartment = warehouseMgr.getDepartments(outwarehouse);			
				
				// 清空隐形定制片和镜片的条码
				if("3".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1)) || ("D".equals(Utility.getName(salesDetailPo.getIscustomizes()[i])) && "4".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1)))){
					temp.setSsesditemid("");
				}else{
					temp.setSsesditemid(salesDetailPo.getSsesditemids()[i]);
				}
				
				String outstockid = "";       
				if("4".equals(salesBasicPo.getSsesborderstype())){
					DepartmentsPo tdpo = new DepartmentsPo();
					tdpo.setBdpdepartmentid(salesBasicPo.getSsesblocation());
					outstockid = warehouseMgr.getWarehousePo(tdpo).getBwhid();
				}else{
					outstockid = salesDetailPo.getSsesdstockids()[i];
				}
				temp.setSsesdstockid(outstockid);
				temp.setSsesdsalesitemname(salesDetailPo.getSsesdsalesitemnames()[i]);
				temp.setSsesdsprice(salesDetailPo.getSsesdsprices()[i]);
				temp.setSsesdnumber(salesDetailPo.getSsesdnumbers()[i]);
				temp.setSsesdunitprice(salesDetailPo.getSsesdunitprices()[i]);
				temp.setSsesdpricesum(salesDetailPo.getSsesdpricesums()[i]);
				temp.setSsesdcostsprive(salesDetailPo.getSsesdcostsprives()[i]);
				temp.setSsesdsalesvalue(salesDetailPo.getSsesdsalesvalues()[i]);
				if("".equals(Utility.getName(salesDetailPo.getSsesddiscountrates()[i]))){
					temp.setSsesddiscountrate("1.00");
				}else{
					temp.setSsesddiscountrate(salesDetailPo.getSsesddiscountrates()[i]);
				}
				temp.setSsesddiscountnum(salesDetailPo.getSsesddiscountnums()[i]);
				temp.setSsesdgooddescribe(salesDetailPo.getSsesdgooddescribes()[i]);
				temp.setSsesdglassflag(salesDetailPo.getSsesdglassflags()[i]);
				temp.setSsesdcommoditiesflag(salesDetailPo.getSsesdsalesitemids()[i].substring(0,1));
				temp.setSsesdlargessflag("0");
				temp.setSsesdysvalue(salesDetailPo.getSsesdpricesums()[i]);
				temp.setSsesdrenum(salesDetailPo.getSsesdrenums()[i]);
				temp.setSsesddiscounttype(salesDetailPo.getSsesddiscounttypes()[i]);
				temp.setSsesddiscountsource(salesDetailPo.getSsesddiscountsources()[i]);
				temp.setSsesdfavorable(salesDetailPo.getSsesdfavorables()[i]);
				temp.setSsesdsetmealid(salesDetailPo.getSsesdsetmealids()[i]);
				temp.setSsesdsetmealidno(salesDetailPo.getSsesdsetmealidnos()[i]);
				
				if("2".equals(Utility.getName(salesBasicPo.getSsesbisgiveyouintegral()))){
					temp.setSsesintegral("0");
				}else{
					IntegralPo ipo = setMealDao.getIntegralCountList2(salesDetailPo.getSsesdsalesitemids()[i],salesBasicPo.getSsesbshopcode(),customerInfoPo.getSmecicardtype());
					temp.setSsesintegral(Utility.getName(ipo.getFirIntegralCount()));
				}
				
				temp.setSsesdguaranteeperiod(salesDetailPo.getSsesdguaranteeperiods()[i]);
				temp.setSsesdbatch(salesDetailPo.getSsesdbatchs()[i]);
				temp.setSsesdishavestock(salesDetailPo.getSsesdishavestocks()[i]);
				if(!"".equals(Utility.getName(salesDetailPo.getSsesdvipcards()[i])) && !"1.00".equals(Utility.getName(salesDetailPo.getSsesddiscountrates()[i]))){
					temp.setSsesdvipcard(salesDetailPo.getSsesdvipcards()[i]);
					//折扣卡去重
					if(!vipcardlist.contains(salesDetailPo.getSsesdvipcards()[i])) {
						vipcardlist.add(salesDetailPo.getSsesdvipcards()[i]);
					}  
					
				}				
				
				temp.setSsesdhardvalueversion(Utility.getName(salesBasicPo.getSsesbhardvalueversion()));
				
				if (Utility.getName(temp.getSsesdhardvalueversion()).equals("2")){    // 天津眼科计算加工难度系数
					if(salesDetailPo.getSsesdglassflags()[i].equals("R")){
						temp.setSsesdsph(Utility.getName(salesBasicPo.getSsesbballglassod()));
						temp.setSsesdcyl(Utility.getName(salesBasicPo.getSsesbpostglassod()));
						temp.setSsesdarriseglass(Utility.getName(salesBasicPo.getSsesbarriseglassod()));
					}else if(salesDetailPo.getSsesdglassflags()[i].equals("L")){
						temp.setSsesdsph(Utility.getName(salesBasicPo.getSsesbballglassos()));
						temp.setSsesdcyl(Utility.getName(salesBasicPo.getSsesbpostglassos()));
						temp.setSsesdarriseglass(Utility.getName(salesBasicPo.getSsesbarriseglassos()));
					}else{
						temp.setSsesdsph("");
						temp.setSsesdcyl("");
						temp.setSsesdarriseglass("");
					}			
				}
				
				if("3.ZZ".equals(salesDetailPo.getSsesdsalesitemids()[i].substring(0,4))){
					temp.setSsesdzzcount("0");
					dzzcount++;
				}else{
					temp.setSsesdzzcount(zzcount);
				}
			
				this.frameSalesDao.insertSalesDetail(temp);

			}
			//处理打折卡
	        for(String vipcardStr:vipcardlist){
	        	frameSalesDao.updateVipCardAdd(vipcardStr);
	        }		
		}
			
			/*
			 * 赠品插入销售明细
			 */
		if (giftsPo != null){
			String[] goodsType=giftsPo.getBgsgoodstype().split(",");
			String[] goodsid=giftsPo.getBgsgoodsid().split(",");
			String[] goodsbarcode=giftsPo.getBgsgoodsbarcode().split(",");
			String[] costprice=giftsPo.getBgscostprice().split(",");
			String[] nottax=giftsPo.getBgsnottaxrate().split(",");
			String[] bgsviewname=giftsPo.getBgsviewname().split(",");
	 		
	 		/*
	 		 * 赠品
	 		 */
			for(int j=0;j<goodsType.length;j++){
				SalesDetailPo temp1= new SalesDetailPo();
				temp1.setSsesdsalesid(Utility.getName(salesBasicPo.getSsesbsalesid()));
				temp1.setSsesdsalesitemid(goodsid[j].trim());
				
				outwarehouse.setBwhid(giftsPo.getBgsstockid().split(",")[j].trim());
				outdepartment = warehouseMgr.getDepartments(outwarehouse);
				
				String outdepartmentid = outdepartment.getBdpdepartmentid();
				WarehouseConfigurationPo warehouseConfigurationPo = new WarehouseConfigurationPo();
				warehouseConfigurationPo.setBwcdeptid(Utility.getName(outdepartmentid));
				warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(warehouseConfigurationPo);
			
				temp1.setSsesditemid(goodsbarcode[j].trim()); //天津眼科赠品发料完出库。
				
				temp1.setSsesdstockid(giftsPo.getBgsstockid().split(",")[j].trim());
				temp1.setSsesdsalesitemname(bgsviewname[j].trim());
				temp1.setSsesdsprice("0.00");
				temp1.setSsesdnumber("1");
				temp1.setSsesdunitprice(nottax[j].trim().equals("") ? "0.00" : nottax[j].trim());
				temp1.setSsesdpricesum("0.00");
				temp1.setSsesdcostsprive(costprice[j].trim().equals("") ? "0.00" : costprice[j].trim());
				temp1.setSsesdsalesvalue("0.00");
				temp1.setSsesddiscountrate("0.00");
				temp1.setSsesddiscountnum("0.00");
				temp1.setSsesdgooddescribe("赠品");
				temp1.setSsesdglassflag("");
				temp1.setSsesdcommoditiesflag(goodsid[j].trim().equals("") ? "" : goodsid[j].trim().substring(0, 1));
				temp1.setSsesdlargessflag("1");
				temp1.setSsesdysvalue("0.00");
				temp1.setSsesddiscounttype("");
				temp1.setSsesddiscountsource("");
				temp1.setSsesdfavorable("0.00");
				
				this.frameSalesDao.insertSalesDetail(temp1);
			}
		}

			
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("mdxs");  // mdxs 表示门店销售
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				//新增在途库存的商品
				List<InTransitStorageEntryPo> inTransitStorageEntryList = guitarManagementDao.getNotInTransitStorageGoods(salesBasicPo.getSsesbsalesid());
				if (inTransitStorageEntryList != null && inTransitStorageEntryList.size() > 0){
					for (InTransitStorageEntryPo po : inTransitStorageEntryList){
						po.setCshtsemoduleid("mdxs");
						guitarManagementDao.insertInTransitStroge(po);
					}
				}
			}
			
			/*
			 * 在途
			 */
			frameSalesDao.insertIntrnsitInfo(inTransitPo);
			
			if (dzzcount >= 2){
				salesBasicPo.setSsesbdoublezz("1");
			}
			this.frameSalesDao.insertSalesBasic(salesBasicPo);
			
			salesBasicPo.setSsesbadditionPrice(additional.toString());
			salesBasicPo.setSsesbadditionname(additionname.toString());
			
			if (!"".equals(Utility.getName(salesBasicPo.getSsesbsetmealtitle()))){
				salesBasicPo.setSsesbusesetmealflag("1");
			}else{
				salesBasicPo.setSsesbusesetmealflag("0");
			}
			
			guitarManagementDao.updateSalseBillAdditionalCDetail(salesBasicPo);
			guitarManagementDao.updateSalseBillAdditionalDes(salesBasicPo);	
			guitarManagementDao.updateSalseBillSetMealName(salesBasicPo);			
			guitarManagementDao.updateSalseBillSetMealFlag(salesBasicPo);
			
	}
	
	/**
	 * 获取全部类型的验光信息
	 * @param customerID
	 * @return
	 */
	public List<InspectionPo> getInspectionPosAll(String customerID){
		return frameSalesDao.getInspectionPosAll(customerID);
	}
	
	public CustomerInfoPo getAjaxCustomerDiscount(GoodsInfoPo po){
		CustomerInfoPo cpo = new CustomerInfoPo();
		
		cpo =  frameSalesDao.getAjaxCustomerDiscount(po);
		
		if(!Utility.getName(cpo.getFmmdiscount()).equals("")){
			return cpo;
		}
		
		po.setBgigoodsid("");
		
		cpo =  frameSalesDao.getAjaxCustomerDiscount(po);
		
		if(!Utility.getName(cpo.getFmmdiscount()).equals("")){
			return cpo;
		}
		
		po.setBgibrandid("");
		
		cpo =  frameSalesDao.getAjaxCustomerDiscount(po);
		
		if(!Utility.getName(cpo.getFmmdiscount()).equals("")){
			return cpo;
		}
		
		po.setBgisupplierid("");
		
		cpo =  frameSalesDao.getAjaxCustomerDiscount(po);
		
		if(!Utility.getName(cpo.getFmmdiscount()).equals("")){
			return cpo;
		}
		
		return cpo;
	}
	
	public CustomerInfoPo getCustomerFType(CustomerInfoPo po){
		return frameSalesDao.getCustomerFType(po);
	}
	
	/**
	 * 根据会员卡号查询HIS系统是否存在会员
	 */
	public void getHisCustomerInfoCount(CustomerInfoPo po,PersonInfoPo ppo){
		
		systemParameterPo = systemParameterDao.getSystemParameterPo();
		
		if (Utility.getNameNum(systemParameterPo.getFsphisflag()).equals("1")){
			CustomerInfoPo cp=new CustomerInfoPo();
			
			if(frameSalesDao.getCustomerInfoCount(po) == 0){
				try{

					String sql = "select * from YKOL_ClinPatient where MZNO='"+Utility.getName(po.getSmecimemberid())+"'";
					conn = this.getConnection();
					Statement psm = conn.createStatement();

		        	ResultSet rs = psm.executeQuery(sql); 
		        	
					while (rs.next()){
						cp.setSmecimemberid(rs.getString("MZNO")+"");         //会员卡号
						cp.setSmeciname(rs.getString("NAME")+"");             //会员姓名
						cp.setSmecisex(rs.getString("SEXID")+"");             //性别
						cp.setSmecibirthday(rs.getString("BIRDATE")+"");      //生日
						cp.setSmeciphone(rs.getString("PHONETEL")+"");        //联系方式
						cp.setSmeciaddress(rs.getString("PLANM")+"");         //住址
						cp.setSmeciregisterdate(rs.getString("FINPTM")+"");   //注册日期
					}

					psm.close();
					
//					cp.setSmeciname("小小");             //会员姓名
//					cp.setSmecibirthday("1987-12-12");      //生日
//					cp.setSmeciphone("13209876789");        //联系方式
//					cp.setSmecimemberid("10101023");         //会员卡号
//					cp.setSmeciaddress("天津南开");         //住址
//					cp.setSmeciregisterdate("2014-06-25");   //注册日期
//					cp.setSmecisex("1");   //注册日期
					
				}catch (Exception ex) {
					System.out.println("获取HIS会员信息出现异常!");
				}
				
				if(!"".equals(Utility.getName(cp.getSmecimemberid()))){
					String temp = Utility.getName(cp.getSmecisex());
					if(temp.equals("0")){
						cp.setSmecisex("1");
					}else if(temp.equals("1")){
						cp.setSmecisex("0");
					}
					cp.setSmeciintegral("0");
					cp.setSmeciconsumptionnumber("0");
					cp.setSmeciconsumptionprice("0");
					cp.setSmecizone(Utility.getName(systemParameterPo.getFspcustomeraddress()));  // 默认地区
					
					cp.setSmecishopcode(Utility.getName(ppo.getDepartmentID()));    // 默认门店
					cp.setSmeciregister(Utility.getName(ppo.getId()));    // 建卡人
					
					customerInfoDao.insertCustomerInfo(cp);
				}	
				
			}

		}
		
	}
	
	/**
	 * 更新处方显示数量
	 */
	public void updateSalesRecipeNumView(List<SalesRecipeNumViewPo> poList,LogisticsLogPo logPo){
		
		frameSalesDao.deleteSalesRecipeNumView();
		
		for (SalesRecipeNumViewPo spo : poList){
			frameSalesDao.updateSalesRecipeNumView(spo);
		}

		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
	/**
	 * 查询处方显示数量
	 */
	public List<SalesRecipeNumViewPo> getSalesRecipeNumViewList(){
		return frameSalesDao.getSalesRecipeNumViewList();
	}
	
	/**
	 * 销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeListByType(InspectionPo ipo){
		return frameSalesDao.getInspectionRecipeListByType(ipo);
	}
	
	/**
	 * 按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeCountByType(InspectionPo ipo){
		return frameSalesDao.getInspectionRecipeCountByType(ipo);
	}
	
	/**
	 *  销售页面根据会员号，按不同的处方类型查询最近几次的处方
	 */
	public List<InspectionPo> getInspectionRecipeList(List<SalesRecipeNumViewPo> list,InspectionPo ipo){
		return frameSalesDao.getInspectionRecipeList(list, ipo);
	}
	
	/**
	 * 查看是否设置过销售页面需要显示的处方数量
	 */
	public int getInspectionRecipeCount(InspectionPo ipo){
		return frameSalesDao.getInspectionRecipeCount(ipo);
	}
	
}
