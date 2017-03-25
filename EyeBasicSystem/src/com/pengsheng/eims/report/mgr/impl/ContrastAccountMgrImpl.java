package com.pengsheng.eims.report.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pengsheng.eims.report.dao.ContrastAccountDao;
import com.pengsheng.eims.report.mgr.ContrastAccountMgr;

public class ContrastAccountMgrImpl implements ContrastAccountMgr {
	
	private ContrastAccountDao contrastAccountDao = null;	
	public ContrastAccountDao getContrastAccountDao() {
		return contrastAccountDao;
	}
	public void setContrastAccountDao(ContrastAccountDao contrastAccountDao) {
		this.contrastAccountDao = contrastAccountDao;
	}

	@SuppressWarnings("unchecked")
	public InputStream getGlassData(FileInputStream excel,String billID,String begDate,String endDate,String salesBillID,String supplierID)
	      throws Exception {
				
		try {					
			HSSFWorkbook workbook = new HSSFWorkbook(excel);
			HSSFSheet shopSheet = workbook.getSheet("对账表");;
			
			if (shopSheet != null){
				List<Map> rsource = contrastAccountDao.getGlassData(billID, begDate, endDate, salesBillID, supplierID);
				
				for (int i = 0; i < rsource.size(); i++){
					SetExcelCell(shopSheet,shopSheet.getRow(i + 1), rsource.get(i),i);
				}				
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);

			return new ByteArrayInputStream(baos.toByteArray());

		} catch (Exception e) {
			throw e;
		} finally {
			if (excel != null)
				excel.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void SetExcelCell(HSSFSheet shopSheet,HSSFRow row, Map rsource,int index) {
		if (row == null){
			row = shopSheet.createRow(index);
		}
		
		HSSFCell c1 = row.getCell(0);
		HSSFCell c2 = row.getCell(1);
		HSSFCell c3 = row.getCell(2);
		HSSFCell c4 = row.getCell(3);
		HSSFCell c5 = row.getCell(4);
		HSSFCell c6 = row.getCell(5);
		HSSFCell c7 = row.getCell(6);
		HSSFCell c8 = row.getCell(7);
		
		(c1 != null ? c1 : row.createCell(0)).setCellValue(rsource.get("单据日期") != null ? rsource.get("单据日期").toString() : "");
		(c2 != null ? c2 : row.createCell(1)).setCellValue(rsource.get("单据号") != null ? rsource.get("单据号").toString() : "");
		(c3 != null ? c3 : row.createCell(2)).setCellValue(rsource.get("商品名称") != null ? rsource.get("商品名称").toString() : "");
		(c4 != null ? c4 : row.createCell(3)).setCellValue(rsource.get("球镜") != null ? rsource.get("球镜").toString() : "");
		(c5 != null ? c5 : row.createCell(4)).setCellValue(rsource.get("柱镜") != null ? rsource.get("柱镜").toString() : "");
		(c6 != null ? c6 : row.createCell(5)).setCellValue(rsource.get("数量") != null ? rsource.get("数量").toString() : "");
		(c7 != null ? c7 : row.createCell(6)).setCellValue(rsource.get("价税合计") != null ? rsource.get("价税合计").toString() : "");
		(c8 != null ? c8 : row.createCell(7)).setCellValue(rsource.get("客户号") != null ? rsource.get("客户号").toString() : "");	
	}

}


