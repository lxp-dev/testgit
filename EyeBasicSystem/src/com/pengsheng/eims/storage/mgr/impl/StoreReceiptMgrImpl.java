package com.pengsheng.eims.storage.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoManyPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.BatchCompareDao;
import com.pengsheng.eims.storage.dao.FinancialSettlementDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StoreReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.BatchCompareMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.mgr.StoreReceiptMgr;
import com.pengsheng.eims.storage.persistence.BatchComparePo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.VerificationPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 客户批发收货mgr实现类
 */
public class StoreReceiptMgrImpl extends BaseJdbcDaoSupport implements StoreReceiptMgr {
	private BatchCompareDao batchCompareDao;
	private LogisticsLogDao logisticsLogDao;
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();
	private FinancialSettlementDao financialSettlementDao;
	
	public FinancialSettlementDao getFinancialSettlementDao() {
		return financialSettlementDao;
	}
	public void setFinancialSettlementDao(
			FinancialSettlementDao financialSettlementDao) {
		this.financialSettlementDao = financialSettlementDao;
	}
	public BatchCompareDao getBatchCompareDao() {
		return batchCompareDao;
	}
	public void setBatchCompareDao(BatchCompareDao batchCompareDao) {
		this.batchCompareDao = batchCompareDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private StoreReceiptDao storeReceiptDao;

	private StrogeChangeDao strogeChangeDao;

	private SupplierDao supplierDao;
	
	private ProcurementReceiptDao procurementReceiptDao;
	
	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}
	public void setProcurementReceiptDao(ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public StoreReceiptDao getStoreReceiptDao() {
		return storeReceiptDao;
	}

	public void setStoreReceiptDao(
			StoreReceiptDao storeReceiptDao) {
		this.storeReceiptDao = storeReceiptDao;
	}

	/**
	 * 获取客户批发收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getStoreReceiptCount(InventoryPo po) {
		return storeReceiptDao.getStoreReceiptCount(po);
	}

	/**
	 * 获取客户批发收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getStoreReceiptList(InventoryPo po,int start, int size) {
		return storeReceiptDao.getStoreReceiptList(po, start, size);
	}

	/**
	 * 新增客户批发收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertStoreReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		storeReceiptDao.insertStoreReceipt(po);// 单据主表

		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			
			if(!"".equals(Utility.getName(entryPo.getCstiebatch()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(entryPo.getCstiebarcode());
				tbpo.setCshbcbatch(entryPo.getCstiebatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String isinsert = "";
				if(bpo.getCshbcbarcode() != null){
				}else{
					isinsert = "1";
				}
				entryPo.setCstiepcbarcode(entryPo.getCstiebarcode());
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(entryPo.getCstiebarcode());
					ipo.setCshbcguaranteeperiod(entryPo.getCstieguaranteeperiod());
					ipo.setCshbcbatch(entryPo.getCstiebatch());
					ipo.setCshbcsimplebatch(entryPo.getCstiebarcode().substring(25, 26));
					ipo.setCshregistrationnum(Utility.getName(entryPo.getCstieregistrationnum()));
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
			
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
			storeReceiptDao.insertStoreReceiptEntry(entryPo);// 单据明细表
		}

		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 获取客户批发收货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getStoreReceipt(InventoryPo po) {

		return storeReceiptDao.getStoreReceipt(po);
	}
	/*
	 * 
	 */
	public void updateOrderDeliveryID(InventoryPo po) {
		storeReceiptDao.updateOrderDeliveryID(po);
	}
	/**
	 * 获取客户批发收货明细表的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getStoreReceiptEntryList(InventoryPo po) {
		return storeReceiptDao.getStoreReceiptEntryList(po);
	}
	public int getStoreReceiptIsCustomizeCount(InventoryPo po){
		return storeReceiptDao.getStoreReceiptIsCustomizeCount(po);
	}
	/**
	 * 修改客户批发收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateStoreReceipt(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		storeReceiptDao.updateStoreReceipt(po);// 单据主表
		storeReceiptDao.deleteStoreReceiptEntry(po);// 删除单据明细表
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			
			if(!"".equals(Utility.getName(entryPo.getCstiebatch()))){
				BatchComparePo tbpo= new BatchComparePo();
				tbpo.setCshbcbarcode(entryPo.getCstiebarcode());
				tbpo.setCshbcbatch(entryPo.getCstiebatch());
				
				BatchComparePo bpo = batchCompareDao.selectBatchComparePo(tbpo);
				String isinsert = "";
				if(bpo.getCshbcbarcode() != null){
				}else{
					isinsert = "1";
				}
				entryPo.setCstiepcbarcode(entryPo.getCstiebarcode());
				if(!"".equals(isinsert)){
					BatchComparePo ipo = new BatchComparePo();
					ipo.setCshbcbarcode(entryPo.getCstiebarcode());
					ipo.setCshbcguaranteeperiod(entryPo.getCstieguaranteeperiod());
					ipo.setCshbcbatch(entryPo.getCstiebatch());
					ipo.setCshbcsimplebatch(entryPo.getCstiebarcode().substring(25, 26));
					ipo.setCshregistrationnum(Utility.getName(entryPo.getCstieregistrationnum()));
					
					batchCompareDao.insertBatchComparePo(ipo);
				}
			}
			
			entryPo.setCstieinstockid(po.getCstiinstockid());// 收入仓位
			storeReceiptDao.insertStoreReceiptEntry(entryPo);// 单据明细表
		}
		
		List<InventoryPo> spos = new ArrayList<InventoryPo>();
		spos = storeReceiptDao.getStoreCandS(po);
		
		String sbillid = po.getCstibillid();
		if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
			for(int i=0; i<spos.size(); i++){
				InventoryPo spo = spos.get(i);
				List<InventoryEntryPo> gpos = new ArrayList<InventoryEntryPo>();
				String billID = "PIN"+ GenerateNumber.getInstance().getGenerageNumber();
				
				po.setCstistorereceiptid(sbillid);
				po.setCstigoodscategory(spo.getCstigoodscategory());
				po.setCstisupplierid(spo.getCstisupplierid());
				po.setCstibillid(billID);
				procurementReceiptDao.insertProcurementReceipt(po);
				
				gpos = storeReceiptDao.getStoreG(spo);
				
				for(int j=0; j<gpos.size(); j++){
					InventoryEntryPo gpo = gpos.get(j);
					gpo.setCstiebillid(billID);
					procurementReceiptDao.insertProcurementReceiptEntry(gpo);
					
					if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
						StrogeChangePo changePo = new StrogeChangePo();
						changePo.setCshscgoodsid(gpo.getCstiegoodsid());
						changePo.setCshscgoodsbarcode(gpo.getCstiegoodsid().replace(".", ""));
						changePo.setCshscstockid(gpo.getCstieinstockid());
						changePo.setCshscgoodsquantity(gpo.getCstiegoodsquantity());
						changePo.setCshsccostprice(gpo.getCstiecostprice());
						changePo.setCshscnottaxrate(gpo.getCstienottaxrate());
						changePo.setCshscchangeid(po.getCstibillid());
						strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
					}
		
					if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
						StrogeChangePo changePo = new StrogeChangePo();
						changePo.setCshscgoodsid(gpo.getCstiegoodsid());
						changePo.setCshscgoodsbarcode(gpo.getCstiegoodsid().replace(".", ""));
						changePo.setCshscstockid(gpo.getCstieinstockid());
						changePo.setCshscgoodsquantity(gpo.getCstiegoodsquantity());
						changePo.setCshsccostprice(gpo.getCstiecostprice());
						changePo.setCshscnottaxrate(gpo.getCstienottaxrate());
						changePo.setCshscchangeid(po.getCstibillid());
						changePo.setCshscguaranteeperiod(gpo.getCstieguaranteeperiod());
						changePo.setCshscBatch(gpo.getCstiebatch());
						changePo.setCshscrksj(gpo.getCstierksj());
						
						strogeChangeDao.insertStrogeChangeLog(changePo, gpo.getCstiepcbarcode());// 商品库存当月库存变更表
						strogeChangeDao.insertStrogeChangeLogTemp(changePo, gpo.getCstiepcbarcode());// 商品库存当月库存变更表(9张新表)
						storeReceiptDao.updateGoodsLastInStorageDate(gpo.getCstiegoodsid());
					}
				}
			}
		}

		SupplierPo supplierPo = new SupplierPo();
		supplierPo.setBspid(po.getCstisupplierid());
		supplierPo = supplierDao.getSupplier(supplierPo);

		if ("1".equals(po.getCstiauditstate())) {
			if(!"".equals(po.getCstisourcebillid()))
			{
				storeReceiptDao.updateOrder(po);
				storeReceiptDao.updateOrderStatus(po);
			}
			else
			{
				storeReceiptDao.insertOrderStatus(po);
			}
		}

		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除客户批发收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteStoreReceipt(InventoryPo po,LogisticsLogPo logPo) {

		storeReceiptDao.deleteStoreReceipt(po);// 单据主表
		storeReceiptDao.deleteStoreReceiptEntry(po);// 删除单据明细表
		storeReceiptDao.deleteVerification(po);// 删除核销表
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	
	public List<DeliveryDetailPo> getDeliverEntryList(String deliverID) {
		return storeReceiptDao.getDeliverEntryList(deliverID);
	}

	
	public List<GoodsInfoPo> getStoreOrdersList(ProcurementOrdersPo po) {

		List<GoodsInfoPo> goodsTemp = storeReceiptDao.getStoreOrdersList(po);

		for (GoodsInfoPo goodsInfoPo : goodsTemp) {
			String pcBarcode = storeReceiptDao.getGoodsBarCode(goodsInfoPo.getBgigoodsbarcode());
			goodsInfoPo.setBgipcbarcode(pcBarcode);
		}

		return goodsTemp;
	}

	
	public int selectStoreReceipt(InventoryPo po) {
		return storeReceiptDao.selectStoreReceiptcount(po);
	}
	
	/**
	 * 获取采购订单是否收货
	 * @param sourceBillId
	 * @return
	 */
	public int selectStoreIsReceipt(String billid){
		return storeReceiptDao.selectStoreIsReceipt(billid);
	}
	/**
	 * Description :获取品种 
	 */
	public List<GoodsInfoPo> getProBrand(String proId){
		return storeReceiptDao.getProBrand(proId);
	}
	
	public List<GoodsInfoPo> insertImportStoreFrameManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
		List<GoodsInfoPo> goodsInfoList = new ArrayList<GoodsInfoPo>();
		
		File dist = null;
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			goodsInfoPo = new GoodsInfoPo();
			goodsInfoPo.setDocumentUrl(fileFullName);
			
			dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			
			try {
				copy(fUpload, dstFile);
			} catch (Exception e) {
				goodsInfoPo.setDocumentUrl("");
			}
		}
		
		String sheetnum = "";
		String rownum = "";
		String goodsid = "";
		File file = new File(filePath + File.separator + goodsInfoPo.getDocumentUrl());
		if (file.exists() && file.isFile()){
			try {
				FileInputStream is = new FileInputStream(file);
				HSSFWorkbook wbs = new HSSFWorkbook(is);
				
				HSSFCellStyle columnHeadStyle = createCellStyle(wbs);  //设置表头
				HSSFCellStyle styleSum = createCellStyle(wbs,columnHeadStyle); //设置数量单元格
				
				sheetnum = 0+"";
				HSSFSheet childSheet = wbs.getSheetAt(0);
				
				for (int j = 2; j < childSheet.getLastRowNum(); j++) {
					 rownum = j+"";
					 HSSFRow row = childSheet.getRow(j);
					 if (null != row) {
						 GoodsInfoPo po = new GoodsInfoPo();
						 
						 HSSFCell cell0 = row.getCell(0);   //商品代码
						 HSSFCell cell2 = row.getCell(2);   //数量
						 HSSFCell cell8 = row.getCell(8);   //条码
						 HSSFCell cell9 = row.getCell(9);   //效期
						 HSSFCell cell10 = row.getCell(10); //批号
						 
						 if(cell0 != null){
							 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
							 po = storeReceiptDao.selectImportStorePo(cell0.getStringCellValue());
						 }
						 
						 if(cell2 != null){
							 cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
							 po.setBgigoodsquantity(Integer.parseInt(cell2.getStringCellValue())+"");
						 }
						 
						 if(cell8 != null){
							 cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
							 po.setBgipcbarcode(cell8.getStringCellValue());
							 po.setBgigoodsbarcode(cell8.getStringCellValue());
						 }
						 
						 if(cell9 != null){
							 cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
							 po.setGuaranteeperiod(cell9.getStringCellValue());
						 }
						 
						 if(cell10 != null){
							 cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
							 po.setBatch(cell10.getStringCellValue());
						 }
						 
						 goodsInfoList.add(po);
					 }
				}
			} catch (FileNotFoundException e) {
				System.out.println("--- Sheet Number:"+sheetnum+" --- Row Number:"+rownum+" --- Goodsid:"+goodsid+" ---");
				e.printStackTrace();
			}catch (IOException e) {
				System.out.println("--- Sheet Number:"+sheetnum+" --- Row Number:"+rownum+" --- Goodsid:"+goodsid+" ---");
				e.printStackTrace();
			}
		}
		
		deleteDir(dist);
		
		return goodsInfoList;
	}
	
	private void copy(File src, File dst) throws Exception{
		InputStream in = null;
		OutputStream out = null;

		in = new BufferedInputStream(new FileInputStream(src));
		out = new BufferedOutputStream(new FileOutputStream(dst));
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}

		if (null != in) {
			in.close();
		}
		if (null != out) {
			out.close();
		}
	}
	
	private HSSFCellStyle createCellStyle(HSSFWorkbook workbook){
		
		HSSFFont headfont = workbook.createFont();
		headfont.setFontName("黑体");
		headfont.setFontHeightInPoints((short) 12);// 字体大小
		headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗			
		// 列头的样式
		HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
		columnHeadStyle.setWrapText(true);	// 指定单元格自动换行
		columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		columnHeadStyle.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
		columnHeadStyle.setBorderLeft((short) 1);// 边框的大小
		columnHeadStyle.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
		columnHeadStyle.setBorderRight((short) 1);// 边框的大小
		columnHeadStyle.setTopBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
		columnHeadStyle.setBorderBottom((short) 1);// 边框的大小
		columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
		// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
		columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		columnHeadStyle.setFont(headfont);
  
		return columnHeadStyle;		
	}

	private HSSFCellStyle createCellStyle(HSSFWorkbook workbook,HSSFCellStyle columnHeadStyle){
	
		// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
		columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 10);
		// 普通单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		style.setWrapText(true);	// 指定单元格自动换行
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		style.setLeftBorderColor(HSSFColor.BLACK.index);// 左边框的颜色
		style.setBorderLeft((short) 1);// 边框的大小
		style.setRightBorderColor(HSSFColor.BLACK.index);// 右边框的颜色
		style.setBorderRight((short) 1);// 边框的大小
		style.setBorderBottom((short) 1);// 边框的大小
		style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
		style.setFont(font);
	
		return style;		
	}
	
	private boolean deleteDir(File dir) {        
		if (dir.isDirectory()) {            
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {                
				boolean success = deleteDir(new File(dir, children[i]));                
				if (!success) {                    
					return false;                
				}
			}
		}
		return dir.delete();    
	}
	
	/**
	 * 财务结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getStoreFinancialSettlement(InventoryPo po) {

		return storeReceiptDao.getStoreFinancialSettlement(po);
	}
	
	/**
	 * 遍历财务结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getStoreFinancialSettlementEntryList(InventoryPo po) {
		return storeReceiptDao.getStoreFinancialSettlementEntryList(po);
	}
	
	/**
	 * 修改财务结算
	 * @param po
	 */
	public void updateStoreFinancialSettlement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		if("1".equals(po.getCstifinanceauditstate())){
			storeReceiptDao.updateStoreFinancialSettlement(po);//单据主表
			financialSettlementDao.updateStoreFinancialSettlement(po);//单据主表
		}

		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			entryPo.setBgcretailPrice(storeReceiptDao.getStoreGoodsInfoByInventoryEntry(entryPo).getBgiretailprice());
			storeReceiptDao.updateStoreFinancialSettlementEntry(entryPo);		
			financialSettlementDao.updateFinancialSettlementEntry(entryPo);	
		}
		
		if ("1".equals(Utility.getName(po.getCstifinanceauditstate()))){
			storeReceiptDao.insertStoreSupplierDealingEntry(po);     								// 新增应付款

			List<InventoryEntryPo> elist = storeReceiptDao.getStoreStorageCostEntryByBillID(po);  	// 更新库存表的结算成本
			for (InventoryEntryPo epo : elist){
				storeReceiptDao.updateStoreStorageCostEntry(epo);    
			}
			
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}
}
