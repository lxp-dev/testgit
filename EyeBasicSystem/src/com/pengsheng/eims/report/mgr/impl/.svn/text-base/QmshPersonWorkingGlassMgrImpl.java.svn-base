/**
 * 
 */
package com.pengsheng.eims.report.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.report.dao.QmshPersonWorkingGlassDao;
import com.pengsheng.eims.report.mgr.QmshPersonWorkingGlassMgr;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.util.tools.Tools;

/**
 * @author liujing
 * 
 */
public class QmshPersonWorkingGlassMgrImpl implements QmshPersonWorkingGlassMgr {

	private QmshPersonWorkingGlassDao qmshPersonWorkingGlassDao;


	public QmshPersonWorkingGlassDao getQmshPersonWorkingGlassDao() {
		return qmshPersonWorkingGlassDao;
	}

	public void setQmshPersonWorkingGlassDao(
			QmshPersonWorkingGlassDao qmshPersonWorkingGlassDao) {
		this.qmshPersonWorkingGlassDao = qmshPersonWorkingGlassDao;
	}

	private DepartmentsDao departmentsDao;



	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}

	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}

	/**
	 * 生成excel
	 * 
	 * @param begDate
	 * @param endDate
	 * @throws Exception
	 */
	public InputStream bulidShopExcel(FileInputStream excel,String begDate, String endDate)
			throws Exception {
		
		try {
			/**
			 * 门店加工数量 
			 */			
			HSSFWorkbook workbook = new HSSFWorkbook(excel);
			HSSFSheet shopSheet = null;
			shopSheet = workbook.getSheet("加工数量");
			if (shopSheet != null) {

				HSSFRow row = null;
				
				List<Map> rsource = qmshPersonWorkingGlassDao.getGlassworkData(begDate, endDate);
				
				SetExcelCell(shopSheet.getRow(0),"各店镜片加工数量统计表("+begDate.substring(0,4)+"年"+begDate.substring(5,7)+"月份)");				
				
				for(int i=2;i<rsource.size()+2;i++){
				    SetExcelCell(shopSheet.getRow(i),rsource.get(i-2));
				}
				for(int i=2;i<33;i++){
					setFormula(shopSheet.getRow(i),16);     // 每增加一个门店，累加 1，当前  16
				}
				
				for(int i=1;i<17;i++){          // 每增加一个门店，累加 1，当前  17
					setFormula(shopSheet.getRow(33),i);
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

	private void SetExcelCell(HSSFRow row, Map rsource) {
		HSSFCell c1 = row.getCell(1);
		HSSFCell c2 = row.getCell(2);
		HSSFCell c3 = row.getCell(3);
		HSSFCell c4 = row.getCell(4);
		HSSFCell c5 = row.getCell(5);
		HSSFCell c6 = row.getCell(6);
		HSSFCell c7 = row.getCell(7);
		HSSFCell c8 = row.getCell(8);
		HSSFCell c9 = row.getCell(9);
		HSSFCell c10 = row.getCell(10);
		HSSFCell c11 = row.getCell(11);
		HSSFCell c12 = row.getCell(12);
		HSSFCell c13 = row.getCell(13);
		HSSFCell c14 = row.getCell(14);
		HSSFCell c15 = row.getCell(15);
		
		(c1 != null ? c1 : row.createCell(1)).setCellValue((rsource.get("ysgcount") != null ? Double.valueOf(rsource.get("ysgcount").toString()) : 0d));
		(c2 != null ? c2 : row.createCell(2)).setCellValue((rsource.get("zxdcount") != null ? Double.valueOf(rsource.get("zxdcount").toString()) : 0d));
		(c3 != null ? c3 : row.createCell(3)).setCellValue((rsource.get("hdcount") != null ? Double.valueOf(rsource.get("hdcount").toString()) : 0d));
		(c4 != null ? c4 : row.createCell(4)).setCellValue((rsource.get("dgdcount") != null ? Double.valueOf(rsource.get("dgdcount").toString()) : 0d));
		(c5 != null ? c5 : row.createCell(5)).setCellValue((rsource.get("tgdcount") != null ? Double.valueOf(rsource.get("tgdcount").toString()) : 0d));
		(c6 != null ? c6 : row.createCell(6)).setCellValue((rsource.get("jndcount") != null ? Double.valueOf(rsource.get("jndcount").toString()) : 0d));
		(c7 != null ? c7 : row.createCell(7)).setCellValue((rsource.get("acdcount") != null ? Double.valueOf(rsource.get("acdcount").toString()) : 0d));
		(c8 != null ? c8 : row.createCell(8)).setCellValue((rsource.get("wqdcount") != null ? Double.valueOf(rsource.get("wqdcount").toString()) : 0d));
		(c9 != null ? c9 : row.createCell(9)).setCellValue((rsource.get("hxdcount") != null ? Double.valueOf(rsource.get("hxdcount").toString()) : 0d));
		(c10 != null ? c10 : row.createCell(10)).setCellValue((rsource.get("zbdcount") != null ? Double.valueOf(rsource.get("zbdcount").toString()) : 0d));
		(c11 != null ? c11 : row.createCell(11)).setCellValue((rsource.get("xkldcount") != null ? Double.valueOf(rsource.get("xkldcount").toString()) : 0d));
		(c12 != null ? c12 : row.createCell(12)).setCellValue((rsource.get("hbdcount") != null ? Double.valueOf(rsource.get("hbdcount").toString()) : 0d));
		(c13 != null ? c13 : row.createCell(13)).setCellValue((rsource.get("jmgzscount") != null ? Double.valueOf(rsource.get("jmgzscount").toString()) : 0d));
		(c14 != null ? c14 : row.createCell(14)).setCellValue((rsource.get("bcdcount") != null ? Double.valueOf(rsource.get("bcdcount").toString()) : 0d));
		(c15 != null ? c15 : row.createCell(15)).setCellValue((rsource.get("tbdcount") != null ? Double.valueOf(rsource.get("tbdcount").toString()) : 0d));
		
	}
	
	private void SetExcelCell(HSSFRow row,String rsource) {
		HSSFCell c1 = row.getCell(0);		
		(c1 != null ? c1 : row.createCell(0)).setCellValue(rsource);
	}
	
	private void setFormulas(HSSFRow row) {
		HSSFCell c0 = row.getCell(1); // 数量
		HSSFCell c1 = row.getCell(2); // 金额

		c0.setCellFormula(c0.getCellFormula());
		c1.setCellFormula(c1.getCellFormula());
	}

	private void setFormula(HSSFRow row) {
		HSSFCell c1 = row.getCell(2); // 金额
		c1.setCellFormula(c1.getCellFormula());
	}
	
	private void setFormula(HSSFRow row,int cell) {
		HSSFCell c1 = row.getCell(cell); // 金额
		c1.setCellFormula(c1.getCellFormula());
	}
	
	private void setFormulaDefinition(HSSFCell cell) {
		cell.setCellFormula(cell.getCellFormula());
	}
}
