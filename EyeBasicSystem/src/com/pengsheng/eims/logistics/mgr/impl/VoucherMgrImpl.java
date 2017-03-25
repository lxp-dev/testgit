/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherMgrImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.dao.VoucherDao;
import com.pengsheng.eims.logistics.dao.VoucherTallyDao;
import com.pengsheng.eims.logistics.mgr.VoucherMgr;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SalesShopPo;
import com.pengsheng.eims.logistics.persistence.VoucherEntryPo;
import com.pengsheng.eims.logistics.persistence.VoucherPo;
import com.pengsheng.eims.logistics.persistence.VoucherTallyPo;
import com.pengsheng.eims.logistics.persistence.VoucherTypePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class VoucherMgrImpl implements VoucherMgr {
	
	private VoucherDao voucherDao = null;
	private List<VoucherEntryPo> billgoodsList = null;
	private VoucherTallyDao voucherTallyDao = null;
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterDao systemParameterDao;	
	private SystemParameterPo systemParameterPo;	
	
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

	public VoucherTallyDao getVoucherTallyDao() {
		return voucherTallyDao;
	}
	public void setVoucherTallyDao(VoucherTallyDao voucherTallyDao) {
		this.voucherTallyDao = voucherTallyDao;
	}
	/**
	 * Description：根据参数查询父类凭证类型是当前参数的详细信息
	 * @param     ：父类凭证类型ID
	 * @return    ：返回符合条件的凭证类型列表
	 */
	public List<VoucherTypePo> getVoucherTypeByID(String parentID){		
		return voucherDao.getVoucherTypeByID(parentID);
	}

	/**
	 * Description：根据参数查询凭证总数
	 * @param     ：凭证实体
	 * @return    ：返回符合条件的凭证总数
	 */
	public int getVoucherCount(VoucherPo po){
		return voucherDao.getVoucherCount(po);
	}
	
	/**
	 * Description：根据参数查询凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的凭证信息列表
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po,int start, int size){
		return voucherDao.getVoucherList(po,start,size);
	}
	
	/**
	 * Description：根据参数查询凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @return    ：返回符合条件的凭证信息列表
	 */
	public List<VoucherPo> getVoucherList(VoucherPo po){
		return voucherDao.getVoucherList(po);
	}
	
	/**
	 * Description：根据参数查询其父类凭证类型ID
	 * @param     ：凭证ID
	 * @return    ：返回符合条件的凭证类型列表
	 */
	public List<VoucherTypePo> getVoucherParentTypeByID(String voucherID){
		return voucherDao.getVoucherParentTypeByID(voucherID);
	}
	
	/**
	 * Description：根据参数删除凭证及明细信息
	 * @param     ：凭证ID
	 */
	public void deleteVoucherByID(String voucherID,String voucherType,LogisticsLogPo logPo){
		
		if (!voucherType.equals("")){
			switch(Integer.valueOf(voucherType)){
	        //发票
	        case 103:
	        case 104:
	        case 203:
	        case 204: 
		    case 109:
		    case 110:
		    case 209:
		    case 210: 
	    	         updateNotLockInvoices(voucherID,null);
	    	         break;
	        //冲回
	        case 102:
	        case 106:
	        case 108:
	        case 202:
	        case 206:
	        case 208:
	    	        updateNotLockReversals(voucherID,null);
	    	        break;
	        //单据
	        default:
	    	        updateNotLockBills(voucherID,voucherType,null);			      
	        }
		}
		
		voucherDao.deleteVoucherEntryByID(voucherID);
		voucherDao.deleteVoucherByID(voucherID);
		voucherDao.deleteVoucherTallyByID(voucherID);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据参数查询其父类凭证类型名称
	 * @param     ：凭证ID
	 * @return    ：返回符合条件的凭证类型类型名称
	 */
	public String getVoucherTypeName(String id){
		return voucherDao.getVoucherTypeName(id);
	}
	
	/**
	 * Description：根据参数修改凭证信息
	 * @param     ：凭证ID
	 */
	public void updateVoucherByID(VoucherPo voucherPo,List<VoucherEntryPo> voucherEntryPoList,String id,String voucherType,LogisticsLogPo logPo){
		
		switch(Integer.valueOf(voucherType.trim())){
        //发票
        case 103:
        case 104:
        case 203:
        case 204:
	    case 109:
	    case 110:
	    case 209:
	    case 210: 
        	 updateNotLockInvoices(voucherPo.getsLvvID(),null);
             break;
        //冲回
        case 102:
        case 106:
        case 108:
        case 202:
        case 206:
        case 208:
        	updateNotLockReversals(voucherPo.getsLvvID(),null);
            break;
        //单据
        default:
        	updateNotLockBills(voucherPo.getsLvvID(),voucherType,null);
        }	
		
		voucherDao.updateVoucherByID(voucherPo);
		
		voucherDao.deleteVoucherEntryByID(voucherPo.getsLvvID());
		Iterator<VoucherEntryPo> it = voucherEntryPoList.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.updateVoucherEntryByID(po);
			switch(Integer.valueOf(voucherPo.getsLvvVoucherTypeID())){
                //发票
                case 103:
                case 104:
                case 203:
                case 204: 
    	            voucherDao.lockInvoices(po);
	                break;
                //冲回
                case 102:
                case 106:
                case 108:
                case 202:
                case 206:
                case 208:
    	            voucherDao.lockReversals(po);
	                break;
                //单据
                default:
    	            voucherDao.lockBills(po,voucherPo.getsLvvVoucherTypeID());			      
            }
		}
		
		if (id.equalsIgnoreCase("D")){
			updateVoucherAmount(voucherPo,null);
		}else{
			updateVoucherAmountByInvoice(voucherPo,null);
		}	
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据参数修改凭证模板信息
	 * @param     ：凭证ID
	 */
	public void updateVoucherByID(VoucherPo voucherPo,LogisticsLogPo logPo){
		voucherDao.updateVoucherByID(voucherPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息总数
	 * @param     ：凭证明细实体
	 * @return    ：返回符合条件的凭证明(单据)细信息总数
	 */	
	public int getVoucherEntryByBillsCount(VoucherEntryPo po){
		return voucherDao.getVoucherEntryByBillsCount(po);
	}
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息
	 * @param     ：VoucherEntryPo 凭证明细实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的凭证明细(单据)信息列表
	 */
	public List<VoucherEntryPo> getVoucherEntryByBillsList(VoucherEntryPo po,int start, int size){
		return voucherDao.getVoucherEntryByBillsList(po, start, size);
	}
	
	/**
	 * Description：根据参数查询凭证明细(单据)信息
	 * @param     ：VoucherEntryPo 凭证明细实体
	 * @return    ：返回符合条件的凭证明细(单据)信息列表
	 */
	public List<VoucherEntryPo> getVoucherEntryByBillsList(VoucherEntryPo po){
		return voucherDao.getVoucherEntryByBillsList(po);
	}
	
	/**
	 * Description：新增凭证
	 * @param     ：凭证实体
	 */
	public void insertVoucher(VoucherPo po,List<VoucherEntryPo> voucherEntryList,String id,String voucherType,LogisticsLogPo logPo){
		
		voucherDao.insertVoucher(po);
		
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo epo = (VoucherEntryPo)it.next();
			voucherDao.insertVoucherEntry(epo);
		}
		
		if (id.equalsIgnoreCase("D")){
			updateVoucherAmount(po,null);
		}else{
			updateVoucherAmountByInvoice(po,null);
		}	
		
		switch(Integer.valueOf(voucherType.trim())){
	    //发票
	    case 103:
	    case 104:
	    case 203:
	    case 204: 
	    case 109:
	    case 110:
	    case 209:
	    case 210: 	
	    	updateLockInvoices(voucherEntryList,null);//
	    	break;
	    //冲回
	    case 102:
	    case 106:
	    case 108:
	    case 202:
	    case 206:
	    case 208:
	    	updateLockReversals(voucherEntryList,null);
	    	break;
	    //单据
	    default:
	    	updateLockBills(voucherEntryList,voucherType,null);			      
	    }	
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：新增凭证
	 * @param     ：凭证实体
	 */
	public void insertVoucher(VoucherPo po,LogisticsLogPo logPo){
		voucherDao.insertVoucher(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：新增凭证明细
	 * @param     ：凭证明细实体
	 */
	public void insertVoucherEntry(List<VoucherEntryPo> list,LogisticsLogPo logPo){
		Iterator<VoucherEntryPo> it = list.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.insertVoucherEntry(po);
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateVoucherAmount(VoucherPo po,LogisticsLogPo logPo){
		voucherDao.updateVoucherAmount(voucherDao.selVoucherAmount(po));
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}		
	}
	
	public void updateVoucherAmountByInvoice(VoucherPo po,LogisticsLogPo logPo){
		voucherDao.updateVoucherAmount(po);
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}	
	}
	
	/**
	 * Description：查询发票基本信息
	 * @param     ：凭证号
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的发票列表
	 */
	public List<VoucherEntryPo> getInvoiceList(String voucherID,int start, int size){
	    return voucherDao.getInvoiceList(voucherID,start,size);
	}
	
	/**
	 * Description：查询发票基本信息
	 * @param     ：凭证号
     * @return    ：返回符合条件的发票列表
	 */
	public List<VoucherEntryPo> getInvoiceList(String voucherID){
	    return voucherDao.getInvoiceList(voucherID);
	}
	
	/**
	 * Description：查询符合条件的发票总数
	 * @param     ：凭证号
     * @return    ：返回符合条件的发票总数
	 */
	public int getInvoiceCount(String voucherID){
	    return voucherDao.getInvoiceCount(voucherID);
	}
	
	/**
	 * Description：查询符合条件的冲回记录总数
	 * @param     ：凭证号
     * @return    ：返回符合条件的冲回记录总数
	 */
	public int getReversalCount(String voucherID){
		return voucherDao.getReversalCount(voucherID);
	}
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：凭证号
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的冲回列表
	 */
	public List<VoucherEntryPo> getReversalList(String voucherID,int start, int size){
		return voucherDao.getReversalList(voucherID, start, size);
	}
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：凭证号
     * @return    ：返回符合条件的冲回列表
	 */
	public List<VoucherEntryPo> getReversalList(String voucherID){
		return voucherDao.getReversalList(voucherID);
	}
	
	/**
	 * Description：查询冲回基本信息
	 * @param     ：冲回号
     * @return    ：返回符合条件的冲回信息
	 */
	public InvoicePo getReversalPo(InvoicePo po){
		return voucherDao.getReversalPo(po);
	}
	
	/**
	 * Description：查询符合条件的冲回明细信息
	 * @param     ：冲回实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
     * @return    ：返回符合条件的冲回明细信息
	 */
	public List<InvoiceEntryPo> getReversalEntryPoList(InvoiceEntryPo po,int start, int size){
		return voucherDao.getReversalEntryPoList(po,start,size);
	}
	public List<InvoiceEntryPo> getReversalEntryPoList(InvoiceEntryPo po){
		return voucherDao.getReversalEntryPoList(po);
	}
	
	/**
	 * Description：查询符合条件的冲回明细总数
	 * @param     ：冲回实体
     * @return    ：返回符合条件的冲回明细总数
	 */
	public int getReversalEntryCount(InvoiceEntryPo po){
		return voucherDao.getReversalEntryCount(po);
	}
	
	/**
	 * Description：根据单据号得到商品明细信息
	 * @param     ：单据号数组
	 * @return    ：返回符合条件的商品明细列表
	 */
	public List<VoucherEntryPo> getBillGoods(List<VoucherEntryPo> voucherEntryList,String[] bills){
		List<VoucherEntryPo> goodsList = null;
		if (voucherEntryList.isEmpty()){
			billgoodsList = new ArrayList<VoucherEntryPo>();
		}
		
		for (int i = 0; i < bills.length; i++){
			VoucherEntryPo inPo = new VoucherEntryPo();			
			inPo.setsLveveBillID(bills[i]);
			
			if (bills[i].substring(0,2).equalsIgnoreCase("SC")){
				goodsList = voucherDao.getCheckStorgeBillGoods(inPo);
			}else if (bills[i].substring(0,2).equalsIgnoreCase("OT")){
				goodsList = voucherDao.getOtherInAndOutStorageBillGoods(inPo);
			}else if (bills[i].substring(0,2).equalsIgnoreCase("SO")){
				goodsList = voucherDao.getSalesBillGoods(inPo);
			}else{
				goodsList = voucherDao.getBillGoods(inPo);
			}
			for (VoucherEntryPo billgoodsPo : goodsList) {				
				if (voucherEntryList == null){
					int j = 0;
					for (j = 0; j < billgoodsList.size(); j++) {				
						if (billgoodsList.get(j).getsLveveID().equals(billgoodsPo.getsLveveID())){
							billgoodsList.remove(j);
							billgoodsList.add(billgoodsPo);
							break;
						}					
					}
					if (j == billgoodsList.size()){
						billgoodsList.add(billgoodsPo);
					}
				}else{
					int j = 0;
					for (j = 0; j < voucherEntryList.size(); j++) {				
						if (voucherEntryList.get(j).getsLveveID().equals(billgoodsPo.getsLveveID())){
							voucherEntryList.remove(j);
							voucherEntryList.add(billgoodsPo);
							break;
						}					
					}
					if (j == voucherEntryList.size()){
						voucherEntryList.add(billgoodsPo);
					}
				}
				

			}
		}
		if (voucherEntryList == null){
			return billgoodsList;
		}
		return voucherEntryList;
	}
	
	/**
	 * Description：根据发票号查询发票信息
	 * @param     ：voucherEntryList 旧发票列表
     * @param     ：bills 发票号数组
	 * @return    : 返回发票信息
	 */
	public List<VoucherEntryPo> getInvoiceListByID(List<VoucherEntryPo> voucherEntryList,String[] bills){
		for (int i = 0; i < bills.length; i++){
			VoucherEntryPo inPo = new VoucherEntryPo();			
			inPo.setsLveveBillID(bills[i]);
			
			List<VoucherEntryPo> goodsList = voucherDao.getInvoiceListByID(inPo);
			
			for (VoucherEntryPo billgoodsPo : goodsList) {				
				int j = 0;
				for (j = 0; j < voucherEntryList.size(); j++) {				
					if (voucherEntryList.get(j).getsLveveBillID().equals(billgoodsPo.getsLveveBillID())){
						voucherEntryList.remove(j);
						voucherEntryList.add(billgoodsPo);
						break;
					}					
				}
				if (j == voucherEntryList.size()){
					voucherEntryList.add(billgoodsPo);
				}
			}
		}		
		return voucherEntryList;
	}
	
	/**
	 * Description：根据冲回号查询冲回信息
	 * @param     ：voucherEntryList 旧冲回列表
     * @param     ：bills 冲回号数组
	 * @return    : 返回冲回信息
	 */
	public List<VoucherEntryPo> getReversalListByID(List<VoucherEntryPo> voucherEntryList,String[] bills){
		for (int i = 0; i < bills.length; i++){
			VoucherEntryPo inPo = new VoucherEntryPo();			
			inPo.setsLveveBillID(bills[i]);
			
			List<VoucherEntryPo> goodsList = voucherDao.getReversalListByID(inPo);
			
			for (VoucherEntryPo billgoodsPo : goodsList) {				
				int j = 0;
				for (j = 0; j < voucherEntryList.size(); j++) {				
					if (voucherEntryList.get(j).getsLveveBillID().equals(billgoodsPo.getsLveveBillID())){
						voucherEntryList.remove(j);
						voucherEntryList.add(billgoodsPo);
						break;
					}					
				}
				if (j == voucherEntryList.size()){
					voucherEntryList.add(billgoodsPo);
				}
			}
		}		
		return voucherEntryList;
	}
	
	/**
	 * Description：根据单据号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void updateLockBills(List<VoucherEntryPo> voucherEntryList,String type,LogisticsLogPo logPo){
		List<VoucherEntryPo> poList = new ArrayList<VoucherEntryPo>();
		int size = 0;
		poList.add(voucherEntryList.get(0));
		for (int i = 1; i < voucherEntryList.size(); i++){
			for (int j = 0; j < poList.size(); j++){
				if (poList.get(j).getsLveveBillID().equalsIgnoreCase(voucherEntryList.get(i).getsLveveBillID())){
					break;
				}
				size++;
			}
			if (poList.size() == size){
				poList.add(voucherEntryList.get(i));								
			}
			size = 0;
		}		
		
		Iterator<VoucherEntryPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.lockBills(po,type);
		}
		
		poList.clear();
		poList = null;
		
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}	
	}
	
	/**
	 * Description：根据发票号锁定发票
	 * @param     ：凭证明细实体
	 */
	public void updateLockInvoices(List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo){
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.lockInvoices(po);
		}
		
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}	
	}
	
	/**
	 * Description：根据冲回号锁定冲回记录
	 * @param     ：凭证明细实体
	 */
	public void updateLockReversals(List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo){
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.lockReversals(po);
		}
		
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}	
	}
	
	/**
	 * Description：根据发票号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void updateLockBillsByInvoiceID(List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo){
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.lockBillsByInvoiceID(po);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据冲回号锁定单据
	 * @param     ：凭证明细实体
	 */
	public void updateLockBillsByReversalID(List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo){
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo po = (VoucherEntryPo)it.next();
			voucherDao.lockBillsByReversalID(po);
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据审核人ID查询审核人名称
	 * @param     ：审核人ID
	 * @return    : 返回审核人名称
	 */
	public String getAuditPersonNameByID(String auditPersonID){
		return voucherDao.getAuditPersonNameByID(auditPersonID);
	}
	
	/**
	 * Description：根据冲回号查询核销的商品代码
	 * @param     ：冲回号
	 * @return    : 返回商品代码
	 */
	public List<VoucherEntryPo> getGoodsIdByReversalID(String reversalID){
		return 	voucherDao.getGoodsIdByReversalID(reversalID);
	}
	
	/**
	 * Description：根据发票号查询核销的商品代码
	 * @param     ：发票号
	 * @return    : 返回商品代码
	 */
	public List<VoucherEntryPo> getGoodsIdByInvoiceID(String invoiceID){
	    return 	voucherDao.getGoodsIdByInvoiceID(invoiceID);
	}
		
	
	/**
	 * Description：根据发票号查询成本合计、价税合计、税额合计
	 * @param     ：发票号
	 * @return    : 返回发票的成本合计、价税合计、税额合计
	 */
	public VoucherPo getAmountByInvoiceID(String invoiceID){
		return voucherDao.getAmountByInvoiceID(invoiceID);
	}
	
	/**
	 * Description：根据冲回号查询成本合计、价税合计、税额合计
	 * @param     ：冲回号
	 * @return    : 返回冲回的成本合计、价税合计、税额合计
	 */
	public VoucherPo getAmountByReversalID(String reversalID){		
		return voucherDao.getAmountByReversalID(reversalID);
	}	
	
	/**
	 * Description：根据单据号解锁单据
	 * @param     ：凭证明细实体
	 */
	public void updateNotLockBills(String voucherID,String voucherType,LogisticsLogPo logPo){
		voucherDao.notLockBills(voucherID,voucherType);
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}		
	}
	
	/**
	 * Description：根据发票号解锁发票
	 * @param     ：凭证明细实体
	 */
	public void updateNotLockInvoices(String voucherID,LogisticsLogPo logPo){
		voucherDao.notLockInvoices(voucherID);
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}
	}
	
	/**
	 * Description：根据冲回号解锁冲回记录
	 * @param     ：凭证明细实体
	 */
	public void updateNotLockReversals(String voucherID,LogisticsLogPo logPo){		
		voucherDao.notLockReversals(voucherID);
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}
	}
	
	/**
	 * Description：根据发票号解锁单据
	 * @param     ：凭证号
	 */
	public void updateNotLockBillByInvoiceID(String voucherID,LogisticsLogPo logPo){
		voucherDao.notLockBillByInvoiceID(voucherID);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据冲回号解锁单据
	 * @param     ：凭证号
	 */
	public void updateNotLockBillByReversalID(String voucherID,LogisticsLogPo logPo){
		voucherDao.notLockBillByReversalID(voucherID);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：根据凭证号查询凭证类型
	 * @param     ：凭证号
	 * @return    : 返回凭证类型
	 */
	public String getVoucherTypeByVoucherID(String voucherID){
		return voucherDao.getVoucherTypeByVoucherID(voucherID).trim();
	}
	
	/**
	 * Description：查询所有门店
	 * @return    : 返回所有门店
	 */
	public List<SalesShopPo> getSalesShopList(){
		return voucherDao.getSalesShopList();
	}
	
	/**
	 * Description：凭证过账（新中大）
	 * @param     ：凭证号
	 */
	public void updateXZD_VoucherPosting(String vouchersID,String companyID,String flag,LogisticsLogPo logPo){
		voucherDao.voucherPosting(vouchersID,companyID,flag);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：凭证过账（用友）
	 * @param     ：凭证号
	 */
	public void updateYY_VoucherPosting(String vouchersID,LogisticsLogPo logPo){
		voucherDao.yy_VoucherPosting(vouchersID);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * Description：修改凭证过账标识
	 * @param     ：凭证号
	 */
	public void updateVoucherPosting(String vouchersID,LogisticsLogPo logPo){		
		while (vouchersID.indexOf(",") > 0){
			voucherDao.updateVoucherPosting(vouchersID.substring(0,vouchersID.indexOf(",")).trim());
			vouchersID = vouchersID.replaceAll(vouchersID.substring(0,vouchersID.indexOf(",") + 1),"");
		}
		voucherDao.updateVoucherPosting(vouchersID.trim());
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo){
		return voucherDao.getSelectBillCount(inventoryPo);
	}
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo , int start , int size){
		return voucherDao.selectSelectBill(inventoryPo,start ,size);
	}	
	
	/**
	 * 得到发票和冲回信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelInvoiceAndReversalCount(InventoryPo po){
		return voucherDao.getSelInvoiceAndReversalCount(po);
	}
	
	/**
	 * 查询发票和冲回信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selInvoiceAndReversal(InventoryPo po , int start , int size){
		return voucherDao.selInvoiceAndReversal(po, start, size);
	}
	
	/**
	 * 新增出库凭证
	 * @param po
	 * @return
	 */
	public void insertOutStrogeVoucher(VoucherPo po,List<VoucherEntryPo> voucherEntryList,LogisticsLogPo logPo){
		voucherDao.insertOutStrogeVoucher(po);
		
		Iterator<VoucherEntryPo> it = voucherEntryList.iterator();
		while(it.hasNext()){
			VoucherEntryPo peo = (VoucherEntryPo)it.next();
			voucherDao.insertOutStrogeVoucherEntry(peo);
		}
		
		updateLockBills(voucherEntryList,po.getsLvvVoucherTypeID(),logPo);
		
	}
	
	/**
	 * 查询出库凭证
	 * @param invoicePo
	 * @return
	 */
	public List<VoucherPo> selOutStrogeVoucher(VoucherPo po,int start,int size){
		return voucherDao.selOutStrogeVoucher(po,start,size);
	}
	
	/**
	 * 查询出库凭证总数
	 * @param invoicePo
	 * @return
	 */
	public int selOutStrogeVoucherCount(VoucherPo po){
	    return voucherDao.selOutStrogeVoucherCount(po);
	}
	
	/**
	 * 查询出库成本和销售收入
	 * @param invoicePo
	 * @return
	 */
	public VoucherEntryPo getOutStrogeAmount(String voucherPo){
		return voucherDao.getOutStrogeAmount(voucherPo);
	}
	
	/**
	 * 查询当前账期
	 */
	public VoucherPo selCurrentAccountPeriod(String companyID){
		
		systemParameterPo = systemParameterDao.getSystemParameterPo();
		if (Utility.getName(systemParameterPo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		
		return voucherDao.selCurrentAccountPeriod(companyID);
	}
	
	/**
	 * 开关账
	 */
	public void updateSwitchAmount(SystemParameterPo spo,String month,String flag,String companyID,LogisticsLogPo logPo){

		if (Utility.getName(spo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		
		voucherDao.switchAmount(month,flag,companyID);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 查询未作账的单据总数
	 */
	public int selBillWhetherSettleAccountsCount(String date,String billType){
		return voucherDao.selBillWhetherSettleAccountsCount(date,billType);
	}
	
	/**
	 * 查询未作账的单据列表
	 */
	public List<InventoryEntryPo> selBillWhetherSettleAccounts(String date,String billType,int start,int size){
		return voucherDao.selBillWhetherSettleAccounts(date,billType,start,size);
	}
	
	/**
	 * 查询销售出库凭证总数
	 */
	public int getSalesOutStorageVoucherCount(VoucherPo po){
		return voucherDao.getSalesOutStorageVoucherCount(po);
	}
	
	/**
	 * 查询销售出库凭证列表
	 */
	public List<VoucherEntryPo> getSalesOutStorageVoucherList(VoucherPo po,int start,int size){
		return voucherDao.getSalesOutStorageVoucherList(po,start,size);
	}
	public List<VoucherEntryPo> getSalesOutStorageVoucherList(VoucherPo po){
		return voucherDao.getSalesOutStorageVoucherList(po);
	}
	
	/**
	 * 修改销售出库凭证
	 */
	public void updateSalesOutStorageVoucher(VoucherPo po,LogisticsLogPo logPo){
		voucherDao.updateSalesOutStorageVoucher(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 获取当前需要传输的财物软件的路径
	 */
	public String getCurrentFinanceSoftwarePath(){
		return voucherDao.getCurrentFinanceSoftwarePath();
	}
	
/*********************************************************************************************/
	
	/**
	 * Description：根据参数查询记账凭证总数
	 * @param     ：凭证实体
	 * @return    ：返回符合条件的记账凭证总数
	 */
	public int getVoucherTallyCount(VoucherPo po){
		return voucherDao.getVoucherTallyCount(po);
	}
	
	/**
	 * Description：根据参数查询记账凭证信息
	 * @param     ：VoucherPo 凭证实体
	 * @param     ：start 开始行数
	 * @param     ：size  每页显示行数
	 * @return    ：返回符合条件的记账凭证信息列表
	 */
	public List<VoucherPo> getVoucherTallyList(VoucherPo po,int start, int size){
		return voucherDao.getVoucherTallyList(po,start,size);
	}
	
	/**
	 * 新增记账凭证
	 */
	public void insertVoucherTally(VoucherPo po,List<VoucherTallyPo> poList,LogisticsLogPo logPo){
				
		BigDecimal bg = new BigDecimal(0);		
		Iterator<VoucherTallyPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherTallyPo tpo = (VoucherTallyPo)it.next();
			voucherTallyDao.insertVoucherTally(tpo);
			
			bg = bg.add(new BigDecimal(Utility.getName(tpo.getsLvtvtDebitMoney()).equals("") ? "0" : Utility.getName(tpo.getsLvtvtDebitMoney())));
		}
		
		po.setsLvvCostPriceAmount(bg.toString());
		voucherDao.insertVoucherTally(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 修改记账凭证
	 */
	public void updateVoucherTally(VoucherPo po,List<VoucherTallyPo> poList,LogisticsLogPo logPo){
			
		voucherDao.deleteVoucherTallyByID(po.getsLvvID());
		
		BigDecimal bg = new BigDecimal(0);		
		Iterator<VoucherTallyPo> it = poList.iterator();
		while(it.hasNext()){
			VoucherTallyPo tpo = (VoucherTallyPo)it.next();			
			voucherTallyDao.insertVoucherTally(tpo);
			
			bg = bg.add(new BigDecimal(Utility.getName(tpo.getsLvtvtDebitMoney())));
		}
		
		po.setsLvvCostPriceAmount(bg.toString());
		voucherDao.updateVoucherTally(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 反审记账凭证
	 */
	public void auditVoucherTally(VoucherPo po,LogisticsLogPo logPo){
		voucherDao.auditVoucherTally(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 获取记账凭证
	 */
	public VoucherPo getVoucherTallyDetail(VoucherPo po){
		return voucherDao.getVoucherTallyDetail(po);
	}
		
	/**
	 * 获取记账凭证明细
	 */
	public List<VoucherTallyPo> getVoucherTallyEntryDetail(VoucherPo po){
		return voucherDao.getVoucherTallyEntryDetail(po);
	}
	
	/**
	 * 判断是否过进行成本计算
	 */
	public int isCostAccount(){
		return voucherDao.isCostAccount();
	}
	
	/**
	 * Description：获取存在凭证模板的凭证类型
	 */
	public List<VoucherTypePo> getVoucherTypeByExitsID(){
		return voucherDao.getVoucherTypeByExitsID();
	}
	
	/**
	 * 查询成本计算日志
	 */
	public List<AutoCostAccountPo> selectAutoCostAccountList(String companyID,SystemParameterPo spo){
		if (Utility.getName(spo.getFspcbjstype()).equals("1")){
			companyID = "";
		}
		
		return voucherDao.selectAutoCostAccountList(companyID);
	}
	
	/**
	 * 根据当前日期查询所属账期
	 */
	public String getCurrentAccountPeriodByDate(String companyID){
		return voucherDao.getCurrentAccountPeriodByDate(companyID);
	}
	
	/**
	 * 查询当前账期是否做过成本计算
	 */
	public int getCurrZqCbjsCount(String date,String companyID){
		return voucherDao.getCurrZqCbjsCount(date,companyID);
	}
	
	public VoucherDao getVoucherDao() {
		return voucherDao;
	}
	public void setVoucherDao(VoucherDao voucherDao) {
		this.voucherDao = voucherDao;
	}	
	public List<VoucherEntryPo> getBillgoodsList() {
		return billgoodsList;
	}
	public void setBillgoodsList(List<VoucherEntryPo> billgoodsList) {
		this.billgoodsList = billgoodsList;
	}
	
}
