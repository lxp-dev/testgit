package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.mgr.DoorStoreDeliveryMgr;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class DoorStoreDeliveryMgrImpl implements DoorStoreDeliveryMgr {
	
	public SalesBasicPo salesBasicPo;
	public DoorStoreDeliveryDao doorStoreDeliveryDao;
	private WindowsMgr windowsMgr;		
	private SystemParameterDao systemParameterDao = null;
	private SystemParameterPo systemParameterPo = null;
	private GuitarManagementDao guitarManagementDao;
	
	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}

	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
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

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	/**
	 * 查询门店配送信息
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo po,String type) {
		
		return doorStoreDeliveryDao.getSalesBasicPos(po,type);
	}

	/**
	 * 新增在途查询明细表信息
	 */
	public void insertInTransit(InTransitPo inTransitPo) {

		doorStoreDeliveryDao.insertInTransit(inTransitPo);
	}
	
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	
	/**
	 * 修改在途状态
	 */
	public void updateSalesBasicPos(SystemParameterPo systemParameterPo,String[] ssesbsalesid,String[] ssesbdragstype,InTransitPo inTransitPo,DistributionPo distributionPo,LogisticsLogPo logPo) {
	
		salesBasicPo=new SalesBasicPo();
		
		DistributionEntryPo distributionEntryPo=new DistributionEntryPo();
		String id=doorStoreDeliveryDao.insertDistribution(distributionPo);
		
		for(int i=0;i<ssesbsalesid.length;i++){
			
			salesBasicPo.setSsesbsalesid(ssesbsalesid[i]);
			salesBasicPo.setSsesbdragstype(i >= ssesbdragstype.length ? "" : ssesbdragstype[i]);
			InTransitPo inTransitPo1 =new InTransitPo();
			inTransitPo1.setSseitsalesid(ssesbsalesid[i]);
			
			inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
			
			if(Utility.getName(inTransitPo1.getSseitstate()).equals("1") || Utility.getName(inTransitPo1.getSseitstate()).equals("2")){
				doorStoreDeliveryDao.updateSalesBasicPos(salesBasicPo);
				
				inTransitPo.setSseitsalesid(ssesbsalesid[i]);
				doorStoreDeliveryDao.insertInTransit(inTransitPo);
				
				distributionEntryPo.setSdndesalesid(ssesbsalesid[i]);
				distributionEntryPo.setSdndedistributionid(id);
				distributionEntryPo.setSdndeorderstype(ssesbsalesid[i]);
				doorStoreDeliveryDao.insertDistributionEntry(distributionPo,distributionEntryPo);
				
				logPo.setsLogContent("调拨配送销售单："+ssesbsalesid[i]+" 修改");
				logisticsLogDao.insertLog(logPo);  //新增日志				
				
				// 双自片不走发料流程
				int zzcount = guitarManagementDao.getZZSupplierClassesBySalesBill(salesBasicPo); // 判断是否存在双自片		
				if (Utility.getName(systemParameterPo.getFspzzautospectaclesmaterials()).equals("1")){    // 系统参数设定：双自片配镜单结款后在途是门店配送
					if (zzcount >= 2){    // 存在双自片时，配镜单在途直接变为配镜发料
						salesBasicPo.setSsesbintransit("6");
						inTransitPo.setSseitstate(salesBasicPo.getSsesbintransit());
						guitarManagementDao.insertIntrnsitInfo(inTransitPo);
						
						doorStoreDeliveryDao.updateSalesIntrnsitInfo(salesBasicPo);
					}
				}			
				
			}
		}
		
	}
	
	/**
	 * 新增配送记录主表
	 * @param po
	 */
	public void insertDistribution(DistributionPo distributionPo) {
		doorStoreDeliveryDao.insertDistribution(distributionPo);
	}

	/**
	 * 新增配送记录明细表
	 * @param po
	 */
	public void insertDistributionEntry(DistributionEntryPo distributionEntryPo) {
//		doorStoreDeliveryDao.insertDistributionEntry(distributionEntryPo);
	}

	/**
	 * 获取门店已配送的数量
	 * @return
	 */
	public int getDoorStoreYetDeliveryCount(DistributionPo distributionPo){
		return doorStoreDeliveryDao.getDoorStoreYetDeliveryCount(distributionPo);
	}
	
	/**
	 * 获取门店已配送的列表
	 * @return
	 */
	public List<DistributionPo> getDoorStoreYetDeliveryList(DistributionPo distributionPo,int start,int size){
		return doorStoreDeliveryDao.getDoorStoreYetDeliveryList(distributionPo,start,size);
	}
	
	/**
	 * 获取门店已配送信息
	 * @return
	 */
	public DistributionPo getDoorStoreYetDeliveryDetail(DistributionPo distributionPo){
		return doorStoreDeliveryDao.getDoorStoreYetDeliveryDetail(distributionPo);
	}
	
	/**
	 * 获取门店已配送明细
	 * @return
	 */
	public List<DistributionEntryPo> getDoorStoreYetDeliveryEntryDetail(DistributionPo distributionPo){
		return doorStoreDeliveryDao.getDoorStoreYetDeliveryEntryDetail(distributionPo);
	}
	
	/**
	 * 查询调拨配送信息
	 */
	public int selectAllocationSendOrSendedsCount(AllocationPo po){
		return doorStoreDeliveryDao.selectAllocationSendOrSendedsCount(po);
	}
	
	/**
	 * 查询调拨配送信息
	 */
	public List<AllocationPo> selectAllocationSendOrSendeds(AllocationPo po, int start, int size){
		return doorStoreDeliveryDao.selectAllocationSendOrSendeds(po, start, size);
	}
	
	/**
	 * 调拨配送更新方法
	 */
	public void updateAllocationSends(String[] ssesbsalesid,DistributionPo distributionPo,LogisticsLogPo logPo) {
		
		salesBasicPo=new SalesBasicPo();
		
		DistributionEntryPo distributionEntryPo=new DistributionEntryPo();
		String id=doorStoreDeliveryDao.insertDistribution(distributionPo);
		
		for(int i=0;i<ssesbsalesid.length;i++){
			distributionEntryPo.setSdndesalesid(ssesbsalesid[i]);
			distributionEntryPo.setSdndedistributionid(id);
			distributionEntryPo.setSdndeorderstype(ssesbsalesid[i]);
			doorStoreDeliveryDao.insertAllocationSendEntry(distributionPo,distributionEntryPo);
			
			AllocationPo po = new AllocationPo();
			po.setCshaasendbillid(distributionEntryPo.getSdndedistributionid());
			po.setCshaabillid(ssesbsalesid[i]);
			
			doorStoreDeliveryDao.updateAllocationSendBillId(po);
		}
	}
	
	/**
	 * 获取门店已配送的数量
	 * @return
	 */
	public int selectAllocationSendedCount(DistributionPo distributionPo){
		return doorStoreDeliveryDao.selectAllocationSendedCount(distributionPo);
	}
	
	/**
	 * 获取门店已配送的列表
	 * @return
	 */
	public List<DistributionPo> selectAllocationSendedList(DistributionPo distributionPo,int start,int size){
		return doorStoreDeliveryDao.selectAllocationSendedList(distributionPo, start, size);
	}
	
	/**
	 * 获取调拨已配送明细
	 * @return
	 */
	public List<DistributionEntryPo> getAllocationSendedEntryDetail(DistributionPo distributionPo){
		return doorStoreDeliveryDao.getAllocationSendedEntryDetail(distributionPo);
	}
}
