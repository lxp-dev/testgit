package com.pengsheng.eims.sales.mgr.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;


import com.pengsheng.eims.basic.dao.WarehouseConfigurationDao;
import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.mgr.CustomerTakeMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.TakeMsgPo;
import com.pengsheng.eims.storage.dao.SpectaclesMaterialsDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.dao.BillKeyDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerTakeMgrImpl implements CustomerTakeMgr {

	private CustomerTakeDao customerTakeDao;
	private GuitarManagementDao guitarManagementDao;
	private StrogeChangeDao strogeChangeDao;	
	public DoorStoreDeliveryDao doorStoreDeliveryDao;
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private InTransitDetailsDao inTransitDetailsDao;
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterDao systemParameterDao = null;
	private SystemParameterPo systemParameterPo = null;
	private SendNoteMgr sendNoteMgr = null;
	private WarehouseDao warehouseDao;
	private WarehouseConfigurationDao warehouseConfigurationDao = null;
	private SpectaclesMaterialsDao spectaclesMaterialsDao = null;
	private BillKeyDao billKeyDao;
	
	public BillKeyDao getBillKeyDao() {
		return billKeyDao;
	}

	public void setBillKeyDao(BillKeyDao billKeyDao) {
		this.billKeyDao = billKeyDao;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
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

	public DoorStoreDeliveryDao getDoorStoreDeliveryDao() {
		return doorStoreDeliveryDao;
	}

	public void setDoorStoreDeliveryDao(DoorStoreDeliveryDao doorStoreDeliveryDao) {
		this.doorStoreDeliveryDao = doorStoreDeliveryDao;
	}

	public CustomerTakeDao getCustomerTakeDao() {
		return customerTakeDao;
	}

	public void setCustomerTakeDao(CustomerTakeDao customerTakeDao) {
		this.customerTakeDao = customerTakeDao;
	}

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}

	/**
	 * 得到顾客取镜信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerTakeCount(SalesBasicPo salesBasicPo) {
		// TODO Auto-generated method stub
		return customerTakeDao.getCustomerTakeCount(salesBasicPo);
	}

	/**
	 * 得到顾客取镜信息
	 * 
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerTake(SalesBasicPo salesBasicPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return customerTakeDao.selectCustomerTake(salesBasicPo, start, size);
	}

	/**
	 * 新增顾客取镜查询信息
	 * 
	 * @param inTransitPo
	 * @param salesPo
	 */
	public void insertCustomerTake(InTransitPo inTransitPo, SalesBasicPo salesPo,NoteTemplatePo noteTemplatePo,List<SalesDetailPo> goodsInfoList,PersonInfoPo personInfoPo,String ssesbMemberId,LogisticsLogPo logPo,SystemParameterPo systemParameterPo){
		
		String billid = Utility.getName(salesPo.getSsesbsalesid());
		InTransitPo inTransitPo1 =new InTransitPo();
		inTransitPo1.setSseitsalesid(salesPo.getSsesbsalesid());
		inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
//		guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesPo.getSsesbsalesid(),"out","1");
		
		SalesDetailPo detailPo = new SalesDetailPo();
		detailPo.setSsesdsalesid(salesPo.getSsesbsalesid());		
		List<SalesDetailPo> detailPos = inTransitDetailsDao.getGoodsInfoNoFinished2(detailPo);
		
		if(Integer.parseInt(inTransitPo1.getSseitstate()) < 13){
			customerTakeDao.insertCustInTransit(inTransitPo);
			customerTakeDao.updateCustInTransit(salesPo);
		}
		
		if ((Utility.getName(salesPo.getSsesborderstype()).equals("3") || Utility.getName(salesPo.getSsesborderstype()).equals("5")) ){
			if("2".equals(systemParameterPo.getFspsalesintransit())){
				
				WarehousePo wpo = null;
				WarehouseConfigurationPo warehouseConfigurationPo = null;
				
				DepartmentsPo departmentPo = new DepartmentsPo();
				departmentPo.setBdpdepartmentid(salesPo.getSsesbshopcode());
				wpo = warehouseDao.getWarehousePo(departmentPo);
				
				WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
				tempWarehouseConfigurationPo.setBwcdeptid(salesPo.getSsesbshopcode());
				warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(tempWarehouseConfigurationPo);
				
				String bwhid = "";
				
				//自动调拨
				if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
					bwhid = Utility.getName(wpo.getBwhid());
					autoAllocationToStore(systemParameterPo,detailPos,salesPo.getSsesbsalesid(),inTransitPo,wpo,salesPo,warehouseConfigurationPo);
				}
			
				// 门店减少库存
				guitarManagementDao.insertStrogeChangeNew(salesPo.getSsesbsalesid(),bwhid);
				guitarManagementDao.insertStrogeChangeLogNew(salesPo.getSsesbsalesid(),bwhid);
				strogeChangeDao.insertStrogeChangeLogTemp(detailPos,bwhid);

			}
		}else{
			// 门店减少库存
			guitarManagementDao.insertStrogeChangeNew(salesPo.getSsesbsalesid(),"");
			guitarManagementDao.insertStrogeChangeLogNew(salesPo.getSsesbsalesid(),"");
			strogeChangeDao.insertStrogeChangeLogTemp(detailPos,"");	
		}
		
		//更新商品出库状态     in:退款   out:结款       1：出(入)库    0：未出(入)库
		guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesPo.getSsesbsalesid(),"out","1");
		
		//删除在途库存的商品
		guitarManagementDao.deleteInTransitStroge(salesPo);
		
		if (logPo != null && !logPo.equals("")){
			logisticsLogDao.insertLog(logPo);  //新增日志
		}
		
		if(null!=noteTemplatePo && null!=noteTemplatePo.getBntcontent() && !noteTemplatePo.getBntcontent().equals(""))
		{

			if(null!=goodsInfoList && goodsInfoList.size()>0)
			{
				int goods=goodsInfoList.size();

				List<GoodsInfoPo> gps=new ArrayList<GoodsInfoPo>();
				for(int i=0;i<goods;i++)
				{
					SalesDetailPo salesDetailPo=goodsInfoList.get(i);
					if(salesDetailPo.getSsesdcommoditiesflag().equals("4"))
					{
						salesDetailPo.getSsesdnumber();//商品数量
						GoodsInfoPo goodsInfoPo=customerTakeDao.getGoodsInfoPo(salesDetailPo.getSsesdsalesitemid());
						
												
						if(goodsInfoPo.getBgistealthclass().equals("1"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntdaythrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntdaythrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("2"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntweekthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntweekthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("9"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntbiweeklythrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntbiweeklythrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("3"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntmonththrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntmonththrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("4"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntseasonthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntseasonthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("5"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBnthalfyearthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBnthalfyearthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("6"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								
								if(noteTemplatePo.getBntyearthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntyearthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{									
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");								
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("7"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntrgpthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntrgpthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}						
					}
				}
				String type=noteTemplatePo.getBntsendtype();
				String hour=noteTemplatePo.getBntsendhour();
				if(gps.size()>0)
				{
					if(type.equals("1"))
					{
						
						GoodsInfoPo gpo=gps.get(0);
						for(int j=0;j<gps.size();j++)
						{
							GoodsInfoPo infopo=gps.get(j);
							if(Float.parseFloat(infopo.getBginumberofdays())>Float.parseFloat(gpo.getBginumberofdays()))
							{
								gpo=infopo;
							}
						}
						CustomerInfoPo cpo = new CustomerInfoPo();
//						SmsRecordPo smsRecordPo=new SmsRecordPo();	
						SendNotePo notepo=new SendNotePo();
						notepo.setSnnotetypeid("13");
						
						cpo.setSmecimemberid(ssesbMemberId);
						CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
						if(Utility.isMobile(customerInfoPo.getSmeciphone()))
						{
//							smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//							smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//							smsRecordPo.setFsrsendperson(personInfoPo.getId());
							
							notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
							notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
							notepo.setSnpersonid(personInfoPo.getId());
							
							String content=noteTemplatePo.getBntcontent();
							
							
							String tem= Utility.getName(gpo.getBgistealthclass()) ;
							if(tem.equals("1"))
							{
								tem="日抛";
							}
							if(tem.equals("2"))
							{
								tem="周抛";
							}
							if(tem.equals("9"))
							{
								tem="双周抛";
							}
							if(tem.equals("3"))
							{
								tem="月抛";
							}
							if(tem.equals("4"))
							{
								tem="季抛";
							}
							if(tem.equals("5"))
							{
								tem="半年抛";
							}
							if(tem.equals("6"))
							{
								tem="年抛";
							}
							if(tem.equals("7"))
							{
								tem="RGP";
							}
							if(tem.equals("8"))
							{
								tem="塑形镜";
							}

							notepo.setSnstealthclass(tem);

							notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
							
							notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
							

							String bb="";
							if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
							{
								bb="女士";
							}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
							{
								bb="先生";
							}
							notepo.setSnsex(bb);
																							
							notepo.setSnbillid(Utility.getName(salesPo.getSsesbsalesid()));
							
							notepo.setSnshopcodename(Utility.getName(salesPo.getSsesbshopName()));
							notepo.setSnshopcodephone(Utility.getName(salesPo.getSsesbsalestelphone()));
						

//							smsRecordPo.setFsrsendcontext(content);
//							notepo.setSnnotecontent(content);
							
							String dvalue=noteTemplatePo.getBntsendtime();
							int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
							if(dff>=0)
							{
								Date d=new Date();
								
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

								Calendar ca = Calendar.getInstance();
								ca.add(Calendar.DATE, dff);
								d = ca.getTime();
								String backTime = format.format(d);
							  																										
//								smsRecordPo.setFsrsenddate(backTime+" "+hour); 
//								delaysReminderInformDao.insertSmsRecord(smsRecordPo);
								
								notepo.setSnsenddate(backTime+" "+hour);
								sendNoteMgr.insertSendNoteContent(notepo);
							}
							
						}
					}
					if(type.equals("2"))
					{
						GoodsInfoPo gpo=gps.get(0);
						for(int j=0;j<gps.size();j++)
						{
							GoodsInfoPo infopo=gps.get(j);
							if(Float.parseFloat(infopo.getBginumberofdays())<Float.parseFloat(gpo.getBginumberofdays()))
							{
								gpo=infopo;
							}
						}
						CustomerInfoPo cpo = new CustomerInfoPo();

//						SmsRecordPo smsRecordPo=new SmsRecordPo();	
						SendNotePo notepo=new SendNotePo();
						notepo.setSnnotetypeid("13");
						cpo.setSmecimemberid(ssesbMemberId);
						CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
						if(Utility.isMobile(customerInfoPo.getSmeciphone()))
						{
//							smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//							smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//							smsRecordPo.setFsrsendperson(personInfoPo.getId());
							
							notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
							notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
							notepo.setSnpersonid(personInfoPo.getId());
							
							String content=noteTemplatePo.getBntcontent();
							
							String tem= Utility.getName(gpo.getBgistealthclass()) ;
							if(tem.equals("1"))
							{
								tem="日抛";
							}
							if(tem.equals("2"))
							{
								tem="周抛";
							}
							if(tem.equals("9"))
							{
								tem="双周抛";
							}
							if(tem.equals("3"))
							{
								tem="月抛";
							}
							if(tem.equals("4"))
							{
								tem="季抛";
							}
							if(tem.equals("5"))
							{
								tem="半年抛";
							}
							if(tem.equals("6"))
							{
								tem="年抛";
							}
							if(tem.equals("7"))
							{
								tem="RGP";
							}
							if(tem.equals("8"))
							{
								tem="塑形镜";
							}

							notepo.setSnstealthclass(tem);

							notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
							
							notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
							

							String bb="";
							if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
							{
								bb="女士";
							}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
							{
								bb="先生";
							}
							notepo.setSnsex(bb);
																							
							notepo.setSnbillid(Utility.getName(salesPo.getSsesbsalesid()));
							
							notepo.setSnshopcodename(Utility.getName(salesPo.getSsesbshopName()));
							notepo.setSnshopcodephone(Utility.getName(salesPo.getSsesbsalestelphone()));
						

//							smsRecordPo.setFsrsendcontext(content);
//							notepo.setSnnotecontent(content);
							
							String dvalue=noteTemplatePo.getBntsendtime();
							int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
							if(dff>=0)
							{
								Date d=new Date();
								
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

								Calendar ca = Calendar.getInstance();
								ca.add(Calendar.DATE, dff);
								d = ca.getTime();
								String backTime = format.format(d);
							  																										
//								smsRecordPo.setFsrsenddate(backTime+" "+hour); 
//								delaysReminderInformDao.insertSmsRecord(smsRecordPo);
								
								notepo.setSnsenddate(backTime+" "+hour);
								sendNoteMgr.insertSendNoteContent(notepo);
							}
							
						}
						
					}
					if(type.equals("3"))
					{
						for(int j=0;j<gps.size();j++)
						{
							GoodsInfoPo gpo=gps.get(j);
							CustomerInfoPo cpo = new CustomerInfoPo();
//							SmsRecordPo smsRecordPo=new SmsRecordPo();	
							SendNotePo notepo=new SendNotePo();
							notepo.setSnnotetypeid("13");
							
							cpo.setSmecimemberid(ssesbMemberId);
							CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
							
							if(Utility.isMobile(customerInfoPo.getSmeciphone()))
							{
//								smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//								smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//								smsRecordPo.setFsrsendperson(personInfoPo.getId());
								
								notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
								notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
								notepo.setSnpersonid(personInfoPo.getId());
								String content=noteTemplatePo.getBntcontent();
								
								String tem= Utility.getName(gpo.getBgistealthclass()) ;
								if(tem.equals("1"))
								{
									tem="日抛";
								}
								if(tem.equals("2"))
								{
									tem="周抛";
								}
								if(tem.equals("9"))
								{
									tem="双周抛";
								}
								if(tem.equals("3"))
								{
									tem="月抛";
								}
								if(tem.equals("4"))
								{
									tem="季抛";
								}
								if(tem.equals("5"))
								{
									tem="半年抛";
								}
								if(tem.equals("6"))
								{
									tem="年抛";
								}
								if(tem.equals("7"))
								{
									tem="RGP";
								}
								if(tem.equals("8"))
								{
									tem="塑形镜";
								}

								notepo.setSnstealthclass(tem);

								notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
								
								notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
								

								String bb="";
								if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
								{
									bb="女士";
								}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
								{
									bb="先生";
								}
								notepo.setSnsex(bb);
																								
								notepo.setSnbillid(Utility.getName(salesPo.getSsesbsalesid()));
								
								notepo.setSnshopcodename(Utility.getName(salesPo.getSsesbshopName()));
								notepo.setSnshopcodephone(Utility.getName(salesPo.getSsesbsalestelphone()));
							
	
//								smsRecordPo.setFsrsendcontext(content);
//								notepo.setSnnotecontent(content);
								
								String dvalue=noteTemplatePo.getBntsendtime();
								int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
								
								if(dff>=0)
								{
									Date d=new Date();
									
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");

									Calendar ca = Calendar.getInstance();
									ca.add(Calendar.DATE, dff);
									d = ca.getTime();
									String backTime = format.format(d);
								  																										
//									smsRecordPo.setFsrsenddate(backTime+" "+hour); 
//									delaysReminderInformDao.insertSmsRecord(smsRecordPo);
									
									notepo.setSnsenddate(backTime+" "+hour);
									sendNoteMgr.insertSendNoteContent(notepo);
								}
								
							}
						}
					}
				}
			}
			
		}
		
		// 将配镜单送至已完结的表中
		if (Utility.getName(systemParameterPo.getFspsplitsalesdataflag()).equals("1")){			
			customerTakeDao.insertSalesBasicFinished(billid);
			customerTakeDao.insertSalesDetailFinished(billid);
			customerTakeDao.deleteSalesBasic(billid);
			customerTakeDao.deleteSalesDetail(billid);
		}
	}
	
	/**
	 * 自动调拨（从门店出仓配置的仓位到门店仓位）
	 */
	private void autoAllocationToStore(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailList,String billID,InTransitPo inTransitPo,WarehousePo wpo,SalesBasicPo salesBasicPo,WarehouseConfigurationPo cpo){
			
		List<InventoryPo> inventoryList = new ArrayList<InventoryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		
		BigDecimal nottaxrateamount = null;  //成本合计
		BigDecimal costpriceamount = null;   //价税合计
		BigDecimal goodsNum = null;          //商品数量
		BigDecimal taxamount = null;         //税额合计
		
		List<String> stockList = new ArrayList<String>();              //出仓仓位的集合
		String secondStock = "";             //当前商品的出仓仓位
		String tbillid = "";                 //临时调拨单号
		
		if (Utility.getName(wpo.getBwhid()).equals("")){
			return;
		}
		
		boolean flag = false;
		if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") && !Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0")){
			flag = true;
		}
		
		for (SalesDetailPo po : salesDetailList){
			
			GoodsInfoPo goodsInfoPo = inTransitDetailsDao.getSalesGoodsInfo(Utility.getName(po.getSsesdsalesitemid()));
			
			if (Utility.getName(wpo.getBwhid()).equals(Utility.getName(po.getSsesdstockid())) || Utility.getName(po.getSsesdstockid()).equals("") || Utility.getName(po.getSsesditemid()).trim().equals("")){
				continue;
			}

			secondStock = Utility.getName(po.getSsesdstockid());
			
			if (!stockList.contains(secondStock) && !goodsInfoPo.getBgisupplierid().equals("ZZ")){
				
				tbillid = "ALL" + GenerateNumber.getInstance().getGenerageNumber();				
				
				InventoryPo inventoryPo=new InventoryPo();
				inventoryPo.setCstiinstockid(Utility.getName(wpo.getBwhid()));		//门店仓
				inventoryPo.setCstioutstockid(Utility.getName(po.getSsesdstockid())); //出仓仓位配置的仓位	
				inventoryPo.setCstibillid(tbillid);
				inventoryPo.setCstibilltypeid("4");
				
				inventoryPo.setCstidepartmentid(inTransitPo.getSseitdepartment());  //结款部门
				inventoryPo.setCsticreateperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstiauditperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstisourcebillid(billID);      //配镜单号
				inventoryPo.setCstiremark("门店结款自动调拨");
				inventoryPo.setCstigoodscategory("24");       //特殊标志,24标识门店结款自动调拨
				inventoryPo.setCstifinanceauditperson(inTransitPo.getSseitcreateperson());
				inventoryPo.setCstifinanceauditstate("1");
				
				inventoryList.add(inventoryPo);
				
				stockList.add(secondStock);   //用于判断需要生成多少张调拨单
			}
			
			if (!tbillid.equals("")){
				
				nottaxrateamount = new BigDecimal(po.getSsesdunitprice());
				costpriceamount = new BigDecimal(po.getSsesdcostsprive());
				goodsNum = new BigDecimal(po.getSsesdnumber());
				
				nottaxrateamount = nottaxrateamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				costpriceamount = costpriceamount.multiply(goodsNum).setScale(2, BigDecimal.ROUND_HALF_UP);
				taxamount = costpriceamount.subtract(nottaxrateamount).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
				inventoryEntryPo.setCstiebillid(tbillid);
				inventoryEntryPo.setCstiegoodsid(po.getSsesdsalesitemid());
				inventoryEntryPo.setCstiegoodsquantity(po.getSsesdnumber());
				inventoryEntryPo.setCstienottaxrate(po.getSsesdunitprice());
				inventoryEntryPo.setCstienottaxrateamount(nottaxrateamount.toString());
				inventoryEntryPo.setCstietaxrate(goodsInfoPo.getBgitaxrate());
				inventoryEntryPo.setCstiecostprice(po.getSsesdcostsprive());
				inventoryEntryPo.setCstiecostpriceamount(costpriceamount.toString());
				inventoryEntryPo.setCstietaxamount(taxamount.toString());
				inventoryEntryPo.setCstieinstockid(Utility.getName(wpo.getBwhid()));
				inventoryEntryPo.setCstieoutstockid(Utility.getName(po.getSsesdstockid()));
				inventoryEntryPo.setCstiebarcode(Utility.getName(po.getSsesditemid()));
				inventoryEntryPo.setCstieoutstorageflag("1");
				inventoryEntryPo.setCstieremark("门店结款");
				inventoryEntryPo.setCstieautoallocationflag("4");
				inventoryEntryPo.setCstiesalesbillid(billID);
				
	            if (flag == true && ("4".equals(Utility.getName(po.getSsesdsalesitemid()).substring(0,1)) || "5".equals(Utility.getName(po.getSsesdsalesitemid()).substring(0,1)))){
	    			GoodsInfoPo gpo = strogeChangeDao.getGoodsBatch(po.getSsesditemid());
	    			inventoryEntryPo.setCstieguaranteeperiod(Utility.getName(gpo.getGuaranteeperiod()));
	    			inventoryEntryPo.setCstiebatch(Utility.getName(gpo.getBatch()));            	
	            }
				
				inventoryEntryList.add(inventoryEntryPo);
			}
		}
		
		for (InventoryPo po : inventoryList){
			spectaclesMaterialsDao.inertAutoAllocationToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBillToStore(po);
		}
		
		String stockID = null;
		for (InventoryEntryPo po : inventoryEntryList){
			
			spectaclesMaterialsDao.inertAutoAllocationEntryToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBarcodeToStore(po);

			spectaclesMaterialsDao.inertAutoAllocationBillEntryToStore(po);
			spectaclesMaterialsDao.inertAutoAllocationBillBarcodeToStore(po);
			
			//门店仓位增加库存
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);
			StrogeChangePo strogeChangePo=new StrogeChangePo();
			strogeChangePo.setCshscgoodsbarcode(po.getCstiebarcode());
			strogeChangePo.setCshscgoodsid(po.getCstiegoodsid());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshsccostprice(po.getCstiecostprice());	
			strogeChangePo.setCshscnottaxrate(po.getCstienottaxrate());		
			strogeChangePo.setCshscchangeid(po.getCstiebillid());
			strogeChangePo.setCshscautoallocationflag(po.getCstieautoallocationflag());
			strogeChangePo.setCshscguaranteeperiod(po.getCstieguaranteeperiod());
			strogeChangePo.setCshscBatch(po.getCstiebatch());
			strogeChangePo.setCshscsalesbillid(po.getCstiesalesbillid());

			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
			//出仓配置的减少库存 
			po.setCstiegoodsquantity("-"+po.getCstiegoodsquantity());
			stockID = po.getCstieinstockid();
			po.setCstieinstockid(po.getCstieoutstockid());
			po.setCstieoutstockid(stockID);
			
			strogeChangePo.setCshscgoodsquantity(po.getCstiegoodsquantity());
			strogeChangePo.setCshscstockid(po.getCstieinstockid());
			strogeChangePo.setCshscfromstockid(po.getCstieoutstockid());
			
			spectaclesMaterialsDao.insertAutoAllocationStrogeChange(po);
			spectaclesMaterialsDao.insertAutoAllocationStrogeChangeLog(po);

			strogeChangeDao.insertStrogeChangeLogTemp(strogeChangePo, strogeChangePo.getCshscgoodsbarcode());
		}
		
	}
	
	/**
	 * 取镜前判断库存
	 * @param inTransitPo
	 * @param salesPo
	 * @param noteTemplatePo
	 * @param goodsInfoList
	 * @param personInfoPo
	 * @param ssesbMemberId
	 * @param logPo
	 * @param systemParameterPo
	 * @param takeMsgPo
	 * @return
	 */
	public String insertCustomerTakeCheck(InTransitPo inTransitPo, SalesBasicPo salesPo,NoteTemplatePo noteTemplatePo,List<SalesDetailPo> goodsInfoList,PersonInfoPo personInfoPo,String ssesbMemberId,LogisticsLogPo logPo,SystemParameterPo systemParameterPo,TakeMsgPo takeMsgPo){
		if(!"1".equals(systemParameterPo.getFspsalestype())&&!Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
			String errorsalesid = "以下销售单号：\\n";
			String errortype = "";
			SalesDetailPo tspo = new SalesDetailPo();
			tspo.setSsesdsalesid(salesPo.getSsesbsalesid());
			List<SalesDetailPo> sdpo = billKeyDao.selectTakeGlassListForSalesID(tspo);
			
			int istake = 0;
			for(int i=0; i<sdpo.size(); i++){
				istake = billKeyDao.selectTakeGlassIsSend(sdpo.get(i));
				if(istake > 0){
					break;
				}
			}
			
			if(istake > 0){
				errorsalesid = errorsalesid + salesPo.getSsesbsalesid()+"\\n";
				errortype = "1";
			}else{
				if(takeMsgPo != null){
					insertCustomerTakeAndTakeMsg(inTransitPo, salesPo,noteTemplatePo,goodsInfoList,personInfoPo,ssesbMemberId,logPo,systemParameterPo,takeMsgPo);
				}else{
					insertCustomerTake(inTransitPo, salesPo,noteTemplatePo,goodsInfoList,personInfoPo,ssesbMemberId,logPo,systemParameterPo);
				}
			}
			
			if("1".equals(errortype)){
				return errorsalesid+"库存不足无法取镜！";
			}else{
				return "取镜成功!";
			}
		}else{
			if(takeMsgPo != null){
				insertCustomerTakeAndTakeMsg(inTransitPo, salesPo,noteTemplatePo,goodsInfoList,personInfoPo,ssesbMemberId,logPo,systemParameterPo,takeMsgPo);
			}else{
				insertCustomerTake(inTransitPo, salesPo,noteTemplatePo,goodsInfoList,personInfoPo,ssesbMemberId,logPo,systemParameterPo);
			}
			return "取镜成功!";
		}
	}
	
	/**
	 * 批量取镜前判断库存
	 */
	public String insertCustomerTakeBulkCheck(String[] salesids, String[] memberids,NoteTemplatePo noteTemplatePo, PersonInfoPo personInfoPo,String ssesbsalerid, SystemParameterPo systemParameterPo,LogisticsLogPo logPo){
		if(!"1".equals(systemParameterPo.getFspsalestype())&&!Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
			String errorsalesid = "以下销售单号：\\n";
			String errortype = "";
			TreeSet<String> tr = new TreeSet<String>();
			for(int j=0; j<salesids.length; j++){
				SalesDetailPo tspo = new SalesDetailPo();
				tspo.setSsesdsalesid(salesids[j]);
				List<SalesDetailPo> sdpo = billKeyDao.selectTakeGlassListForSalesID(tspo);
				
				int istake = 0;
				for(int i=0; i<sdpo.size(); i++){
					istake = billKeyDao.selectTakeGlassIsSend(sdpo.get(i));
					if(istake > 0){
						break;
					}
				}
				
				if(istake > 0){
					errorsalesid = errorsalesid + salesids[j]+"\\n";
					errortype = "1";
				}else{
					tr.add(salesids[j]);
				}
			}
			String[] nsalesids= new String[tr.size()];
			for(int i=0;i<nsalesids.length;i++){
				nsalesids[i] = tr.pollFirst();
			}
			insertCustomerTakeBulk(nsalesids,memberids,noteTemplatePo,personInfoPo,ssesbsalerid,systemParameterPo,logPo);
			
			if("1".equals(errortype)){
				return errorsalesid+"库存不足无法取镜！";
			}else{
				return "取镜成功!";
			}
		}else{
			insertCustomerTakeBulk(salesids,memberids,noteTemplatePo,personInfoPo,ssesbsalerid,systemParameterPo,logPo);
			return "取镜成功!";
		}
	}
	
	/**
	 * 新增顾客取镜查询信息同时插入备注信息
	 * 
	 * @param inTransitPo
	 * @param salesPo
	 */
	public void insertCustomerTakeAndTakeMsg(InTransitPo inTransitPo, SalesBasicPo salesPo,NoteTemplatePo noteTemplatePo,List<SalesDetailPo> goodsInfoList,PersonInfoPo personInfoPo,String ssesbMemberId,LogisticsLogPo logPo,SystemParameterPo systemParameterPo,TakeMsgPo takeMsgPo){
		
		String billid = Utility.getName(salesPo.getSsesbsalesid());
		InTransitPo inTransitPo1 =new InTransitPo();
		inTransitPo1.setSseitsalesid(salesPo.getSsesbsalesid());
		inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
//		guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesPo.getSsesbsalesid(),"out","1");
		
		customerTakeDao.insertTakeMsg(takeMsgPo);
		
		SalesDetailPo detailPo = new SalesDetailPo();
		detailPo.setSsesdsalesid(salesPo.getSsesbsalesid());		
		List<SalesDetailPo> detailPos = inTransitDetailsDao.getGoodsInfoNoFinished2(detailPo);
		
		if(Integer.parseInt(inTransitPo1.getSseitstate()) < 13){
			customerTakeDao.insertCustInTransit(inTransitPo);
			customerTakeDao.updateCustInTransit(salesPo);
		}
		
		if ((Utility.getName(salesPo.getSsesborderstype()).equals("3") || Utility.getName(salesPo.getSsesborderstype()).equals("5")) ){
			if("2".equals(systemParameterPo.getFspsalesintransit())){
				
				WarehousePo wpo = null;
				WarehouseConfigurationPo warehouseConfigurationPo = null;
				
				DepartmentsPo departmentPo = new DepartmentsPo();
				departmentPo.setBdpdepartmentid(salesPo.getSsesbshopcode());
				wpo = warehouseDao.getWarehousePo(departmentPo);
				
				WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
				tempWarehouseConfigurationPo.setBwcdeptid(salesPo.getSsesbshopcode());
				warehouseConfigurationPo = warehouseConfigurationDao.getWarehouseConfiguration(tempWarehouseConfigurationPo);
				
				String bwhid = "";
				
				//自动调拨
				if (Utility.getName(systemParameterPo.getFspautoallocationflag()).equals("1")){
					bwhid = Utility.getName(wpo.getBwhid());
					autoAllocationToStore(systemParameterPo,detailPos,salesPo.getSsesbsalesid(),inTransitPo,wpo,salesPo,warehouseConfigurationPo);
				}
			
				// 门店减少库存
				guitarManagementDao.insertStrogeChangeNew(salesPo.getSsesbsalesid(),bwhid);
				guitarManagementDao.insertStrogeChangeLogNew(salesPo.getSsesbsalesid(),bwhid);
				strogeChangeDao.insertStrogeChangeLogTemp(detailPos,bwhid);
			}

		}else{
			// 门店减少库存
			guitarManagementDao.insertStrogeChangeNew(salesPo.getSsesbsalesid(),"");
			guitarManagementDao.insertStrogeChangeLogNew(salesPo.getSsesbsalesid(),"");
			strogeChangeDao.insertStrogeChangeLogTemp(detailPos,"");
		}
		
		//更新商品出库状态     in:退款   out:结款       1：出(入)库    0：未出(入)库
		guitarManagementDao.updateStrogeChangeUnFinishedFlag(salesPo.getSsesbsalesid(),"out","1");
		
		//删除在途库存的商品
		guitarManagementDao.deleteInTransitStroge(salesPo);

		if (logPo != null && !logPo.equals("")){
			logisticsLogDao.insertLog(logPo);  //新增日志
		}
		
		if(null!=noteTemplatePo && null!=noteTemplatePo.getBntcontent() && !noteTemplatePo.getBntcontent().equals(""))
		{

			if(null!=goodsInfoList && goodsInfoList.size()>0)
			{
				int goods=goodsInfoList.size();

				List<GoodsInfoPo> gps=new ArrayList<GoodsInfoPo>();
				for(int i=0;i<goods;i++)
				{
					SalesDetailPo salesDetailPo=goodsInfoList.get(i);
					if(salesDetailPo.getSsesdcommoditiesflag().equals("4"))
					{
						salesDetailPo.getSsesdnumber();//商品数量
						GoodsInfoPo goodsInfoPo=customerTakeDao.getGoodsInfoPo(salesDetailPo.getSsesdsalesitemid());
						
												
						if(goodsInfoPo.getBgistealthclass().equals("1"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntdaythrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntdaythrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("2"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntweekthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntweekthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("9"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntbiweeklythrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntbiweeklythrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("3"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntmonththrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntmonththrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("4"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntseasonthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntseasonthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("5"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBnthalfyearthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBnthalfyearthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("6"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								
								if(noteTemplatePo.getBntyearthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntyearthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{									
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");								
									gps.add(goodsInfoPo);
								}
							}
						}
						if(goodsInfoPo.getBgistealthclass().equals("7"))
						{
							if(null!=goodsInfoPo.getBginumberofdays() && !goodsInfoPo.getBginumberofdays().equals(""))
							{
								if(noteTemplatePo.getBntrgpthrow().equals("1"))
								{
									if(Float.parseFloat(noteTemplatePo.getBntrgpthrownumber())<= Float.parseFloat(salesDetailPo.getSsesdnumber()))
									{
										goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
										gps.add(goodsInfoPo);
									}
								}else
								{
									goodsInfoPo.setBginumberofdays((Float.parseFloat(salesDetailPo.getSsesdnumber())*Float.parseFloat(goodsInfoPo.getBginumberofdays()))+"");
									gps.add(goodsInfoPo);
								}
							}
						}						
					}
				}
				String type=noteTemplatePo.getBntsendtype();
				String hour=noteTemplatePo.getBntsendhour();
				if(gps.size()>0)
				{
					if(type.equals("1"))
					{
						
						GoodsInfoPo gpo=gps.get(0);
						for(int j=0;j<gps.size();j++)
						{
							GoodsInfoPo infopo=gps.get(j);
							if(Float.parseFloat(infopo.getBginumberofdays())>Float.parseFloat(gpo.getBginumberofdays()))
							{
								gpo=infopo;
							}
						}
						CustomerInfoPo cpo = new CustomerInfoPo();
//						SmsRecordPo smsRecordPo=new SmsRecordPo();	
						SendNotePo notepo=new SendNotePo();
						notepo.setSnnotetypeid("13");
						
						cpo.setSmecimemberid(ssesbMemberId);
						CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
						if(Utility.isMobile(customerInfoPo.getSmeciphone()))
						{
//							smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//							smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//							smsRecordPo.setFsrsendperson(personInfoPo.getId());
							
							notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
							notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
							notepo.setSnpersonid(personInfoPo.getId());
							
							String content=noteTemplatePo.getBntcontent();
							
							
							String tem= Utility.getName(gpo.getBgistealthclass()) ;
							if(tem.equals("1"))
							{
								tem="日抛";
							}
							if(tem.equals("2"))
							{
								tem="周抛";
							}
							if(tem.equals("9"))
							{
								tem="双周抛";
							}
							if(tem.equals("3"))
							{
								tem="月抛";
							}
							if(tem.equals("4"))
							{
								tem="季抛";
							}
							if(tem.equals("5"))
							{
								tem="半年抛";
							}
							if(tem.equals("6"))
							{
								tem="年抛";
							}
							if(tem.equals("7"))
							{
								tem="RGP";
							}
							if(tem.equals("8"))
							{
								tem="塑形镜";
							}

							notepo.setSnstealthclass(tem);

							notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
							
							notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
							

							String bb="";
							if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
							{
								bb="女士";
							}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
							{
								bb="先生";
							}
							notepo.setSnsex(bb);
																							
							notepo.setSnbillid(Utility.getName(salesPo.getSsesbsalesid()));
							
							notepo.setSnshopcodename(Utility.getName(salesPo.getSsesbshopName()));
							notepo.setSnshopcodephone(Utility.getName(salesPo.getSsesbsalestelphone()));
						

//							smsRecordPo.setFsrsendcontext(content);
//							notepo.setSnnotecontent(content);
							
							String dvalue=noteTemplatePo.getBntsendtime();
							int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
							if(dff>=0)
							{
								Date d=new Date();
								
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

								Calendar ca = Calendar.getInstance();
								ca.add(Calendar.DATE, dff);
								d = ca.getTime();
								String backTime = format.format(d);
							  																										
//								smsRecordPo.setFsrsenddate(backTime+" "+hour); 
//								delaysReminderInformDao.insertSmsRecord(smsRecordPo);
								
								notepo.setSnsenddate(backTime+" "+hour);
								sendNoteMgr.insertSendNoteContent(notepo);
							}
							
						}
					}
					if(type.equals("2"))
					{
						GoodsInfoPo gpo=gps.get(0);
						for(int j=0;j<gps.size();j++)
						{
							GoodsInfoPo infopo=gps.get(j);
							if(Float.parseFloat(infopo.getBginumberofdays())<Float.parseFloat(gpo.getBginumberofdays()))
							{
								gpo=infopo;
							}
						}
						CustomerInfoPo cpo = new CustomerInfoPo();

//						SmsRecordPo smsRecordPo=new SmsRecordPo();	
						SendNotePo notepo=new SendNotePo();
						notepo.setSnnotetypeid("13");
						cpo.setSmecimemberid(ssesbMemberId);
						CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
						if(Utility.isMobile(customerInfoPo.getSmeciphone()))
						{
//							smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//							smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//							smsRecordPo.setFsrsendperson(personInfoPo.getId());
							
							notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
							notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
							notepo.setSnpersonid(personInfoPo.getId());
							
							String content=noteTemplatePo.getBntcontent();
							
							String tem= Utility.getName(gpo.getBgistealthclass()) ;
							if(tem.equals("1"))
							{
								tem="日抛";
							}
							if(tem.equals("2"))
							{
								tem="周抛";
							}
							if(tem.equals("9"))
							{
								tem="双周抛";
							}
							if(tem.equals("3"))
							{
								tem="月抛";
							}
							if(tem.equals("4"))
							{
								tem="季抛";
							}
							if(tem.equals("5"))
							{
								tem="半年抛";
							}
							if(tem.equals("6"))
							{
								tem="年抛";
							}
							if(tem.equals("7"))
							{
								tem="RGP";
							}
							if(tem.equals("8"))
							{
								tem="塑形镜";
							}

							notepo.setSnstealthclass(tem);

							notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
							
							notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
							

							String bb="";
							if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
							{
								bb="女士";
							}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
							{
								bb="先生";
							}
							notepo.setSnsex(bb);
																							
							notepo.setSnbillid(Utility.getName(salesPo.getSsesbsalesid()));
							
							notepo.setSnshopcodename(Utility.getName(salesPo.getSsesbshopName()));
							notepo.setSnshopcodephone(Utility.getName(salesPo.getSsesbsalestelphone()));
						

//							smsRecordPo.setFsrsendcontext(content);
//							notepo.setSnnotecontent(content);
							
							String dvalue=noteTemplatePo.getBntsendtime();
							int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
							if(dff>=0)
							{
								Date d=new Date();
								
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

								Calendar ca = Calendar.getInstance();
								ca.add(Calendar.DATE, dff);
								d = ca.getTime();
								String backTime = format.format(d);
							  																										
//								smsRecordPo.setFsrsenddate(backTime+" "+hour); 
//								delaysReminderInformDao.insertSmsRecord(smsRecordPo);
								
								notepo.setSnsenddate(backTime+" "+hour);
								sendNoteMgr.insertSendNoteContent(notepo);
							}
							
						}
						
					}
					if(type.equals("3"))
					{
						for(int j=0;j<gps.size();j++)
						{
							GoodsInfoPo gpo=gps.get(j);
							CustomerInfoPo cpo = new CustomerInfoPo();
//							SmsRecordPo smsRecordPo=new SmsRecordPo();	
							SendNotePo notepo=new SendNotePo();
							notepo.setSnnotetypeid("13");
							
							cpo.setSmecimemberid(ssesbMemberId);
							CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
							
							if(Utility.isMobile(customerInfoPo.getSmeciphone()))
							{
//								smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//								smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//								smsRecordPo.setFsrsendperson(personInfoPo.getId());
								
								notepo.setSncustomerid(customerInfoPo.getSmecicustomerid());							
								notepo.setSncustomertelphone(customerInfoPo.getSmeciphone());
								notepo.setSnpersonid(personInfoPo.getId());
								String content=noteTemplatePo.getBntcontent();
								
								String tem= Utility.getName(gpo.getBgistealthclass()) ;
								if(tem.equals("1"))
								{
									tem="日抛";
								}
								if(tem.equals("2"))
								{
									tem="周抛";
								}
								if(tem.equals("9"))
								{
									tem="双周抛";
								}
								if(tem.equals("3"))
								{
									tem="月抛";
								}
								if(tem.equals("4"))
								{
									tem="季抛";
								}
								if(tem.equals("5"))
								{
									tem="半年抛";
								}
								if(tem.equals("6"))
								{
									tem="年抛";
								}
								if(tem.equals("7"))
								{
									tem="RGP";
								}
								if(tem.equals("8"))
								{
									tem="塑形镜";
								}

								notepo.setSnstealthclass(tem);

								notepo.setSngoodsname(Utility.getName(gpo.getBgigoodsname()));
								
								notepo.setSncustomername(Utility.getName(customerInfoPo.getSmeciname()));
								

								String bb="";
								if(Utility.getName(customerInfoPo.getSmecisex()).equals("1"))
								{
									bb="女士";
								}else if(Utility.getName(customerInfoPo.getSmecisex()).equals("0"))
								{
									bb="先生";
								}
								notepo.setSnsex(bb);
																								
								notepo.setSnbillid(Utility.getName(salesPo.getSsesbsalesid()));
								
								notepo.setSnshopcodename(Utility.getName(salesPo.getSsesbshopName()));
								notepo.setSnshopcodephone(Utility.getName(salesPo.getSsesbsalestelphone()));
							
	
//								smsRecordPo.setFsrsendcontext(content);
//								notepo.setSnnotecontent(content);
								
								String dvalue=noteTemplatePo.getBntsendtime();
								int dff=(int)(Float.parseFloat(gpo.getBginumberofdays())-Float.parseFloat(dvalue));
								
								if(dff>=0)
								{
									Date d=new Date();
									
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");

									Calendar ca = Calendar.getInstance();
									ca.add(Calendar.DATE, dff);
									d = ca.getTime();
									String backTime = format.format(d);
								  																										
//									smsRecordPo.setFsrsenddate(backTime+" "+hour); 
//									delaysReminderInformDao.insertSmsRecord(smsRecordPo);
									
									notepo.setSnsenddate(backTime+" "+hour);
									sendNoteMgr.insertSendNoteContent(notepo);
								}
								
							}
						}
					}
				}
			}
			
		}

		// 将配镜单送至已完结的表中
		if (Utility.getName(systemParameterPo.getFspsplitsalesdataflag()).equals("1")){			
			customerTakeDao.insertSalesBasicFinished(billid);
			customerTakeDao.insertSalesDetailFinished(billid);
			customerTakeDao.deleteSalesBasic(billid);
			customerTakeDao.deleteSalesDetail(billid);
		}
	}
	
	//批量取镜

	public void insertCustomerTakeBulk(String[] salesids, String[] memberids,
			NoteTemplatePo noteTemplatePo, PersonInfoPo personInfoPo,
			String ssesbsalerid, SystemParameterPo systemParameterPo,LogisticsLogPo logPo) {
		

		for (int i = 0; i < salesids.length; i++){

			String salesid=salesids[i];
			String memberid=memberids[i];
			SalesDetailPo salesDetailPo = new SalesDetailPo();
			salesDetailPo.setSsesdsalesid(salesid);
			List<SalesDetailPo> goodsInfoList = inTransitDetailsDao.getGoodsInfo(salesDetailPo);
			
			InTransitPo inTransitPo=new InTransitPo();
			inTransitPo.setSseitsalesid(salesid);
			inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
			inTransitPo.setSseitcreateperson(ssesbsalerid);
			
			SalesBasicPo salesPo=new SalesBasicPo();
			salesPo.setSsesbsalesid(salesid);
			SalesBasicPo salesBaPo = inTransitDetailsDao.getCustomerInfo(salesPo);
			
			logPo.setsLogContent("配镜单："+salesid+"顾客已取镜!");
			
			this.insertCustomerTake(inTransitPo, salesBaPo, noteTemplatePo, goodsInfoList, personInfoPo, memberid, logPo, systemParameterPo);
		}
		
	}
	
	public int getTakeMsgCount(TakeMsgPo takeMsgPo){
		return this.customerTakeDao.getTakeMsgCount(takeMsgPo);
	}
	public List<TakeMsgPo> selectTakeMsgList(TakeMsgPo takeMsgPo , int start , int size){
		return this.customerTakeDao.selectTakeMsgList(takeMsgPo, start , size);
	}

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}

	public WarehouseConfigurationDao getWarehouseConfigurationDao() {
		return warehouseConfigurationDao;
	}

	public void setWarehouseConfigurationDao(
			WarehouseConfigurationDao warehouseConfigurationDao) {
		this.warehouseConfigurationDao = warehouseConfigurationDao;
	}

	public SpectaclesMaterialsDao getSpectaclesMaterialsDao() {
		return spectaclesMaterialsDao;
	}

	public void setSpectaclesMaterialsDao(
			SpectaclesMaterialsDao spectaclesMaterialsDao) {
		this.spectaclesMaterialsDao = spectaclesMaterialsDao;
	}
}
