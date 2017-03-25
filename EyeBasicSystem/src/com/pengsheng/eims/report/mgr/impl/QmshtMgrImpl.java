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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.report.dao.QmshtDao;
import com.pengsheng.eims.report.mgr.QmshtMgr;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class QmshtMgrImpl implements QmshtMgr {

	private QmshtDao qmshtDao;

	private DepartmentsDao departmentsDao;

	public QmshtDao getQmshtDao() {
		return qmshtDao;
	}

	public void setQmshtDao(QmshtDao qmshtDao) {
		this.qmshtDao = qmshtDao;
	}

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
			 * 门店销售金额 （不包括隐形）
			 */			
			HSSFWorkbook workbook = new HSSFWorkbook(excel);
			HSSFSheet shopSheet = null;
			HSSFSheet shopsSheet = null;
			
			List<DepartmentsPo> departmentsList = departmentsDao.getDepartments("1");
			Iterator<DepartmentsPo> it = departmentsList.iterator();
			while(it.hasNext()){
				DepartmentsPo departmentsPo = (DepartmentsPo)it.next();
				
				if (!"03".equals(departmentsPo.getBdpdepartmentid())) {
					shopSheet = workbook.getSheet(departmentsPo.getBdpdepartmentname()+departmentsPo.getBdpdepartmentid());

					if (shopSheet != null) {

						HSSFRow row = null;

						List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
						
						HSSFCell c1 = shopSheet.getRow(0).getCell(0);
						(c1 != null ? c1 : shopSheet.getRow(0).createCell(0)).setCellValue(departmentsPo.getBdpdepartmentname());

						// 常戴型
						SetExcelCell(shopSheet.getRow(24), rsource.get(14));
						// 抛弃型
						SetExcelCell(shopSheet.getRow(25), rsource.get(15));
						// 硬镜
						SetExcelCell(shopSheet.getRow(23), rsource.get(13));
						// 塑形片
						SetExcelCell(shopSheet.getRow(26), rsource.get(16));

						// 硬镜护理液
						SetExcelCell(shopSheet.getRow(29), rsource.get(17));
						// 软镜护理液
						SetExcelCell(shopSheet.getRow(30), rsource.get(18));

						// 其他金额
						SetExcelCell(shopSheet.getRow(19), rsource.get(11));
						// 订金合计
						//System.out.println("******************************************");
						SetExcelCell(shopSheet.getRow(20),rsource.get(12));
						//System.out.println("------------------------------------------");
						
						// ================ 成品镜片 =================
						// 依视路
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));

						// 尼康
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));

						// 豪雅
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						
						// 罗敦司得
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));

						// 其它
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));

						// ================ 镜片 =================
						// 渐进
						SetExcelCell(shopSheet.getRow(10), rsource.get(5));

						// MC
						SetExcelCell(shopSheet.getRow(11), rsource.get(6));

						// 其它
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));

						// ================ 镜架 =================
						// 200元以下
						SetExcelCell(shopSheet.getRow(15), rsource.get(8));

						// 200-800元
						SetExcelCell(shopSheet.getRow(16), rsource.get(9));

						// 800元以上
						SetExcelCell(shopSheet.getRow(17), rsource.get(10));

						// ================ 隐形 =================						

						// 成品镜片
						setFormulas(shopSheet.getRow(2));

						// 定做
						setFormulas(shopSheet.getRow(9));

						// 镜架
						setFormulas(shopSheet.getRow(14));

						// 隐形镜片
						setFormulas(shopSheet.getRow(22));

						// 隐形辅料
						setFormulas(shopSheet.getRow(28));

						// 合计
						setFormula(shopSheet.getRow(32));
					}
				} else {
					// 隐形销售数据

					shopSheet = workbook.getSheet("隐形中心店03");

					HSSFRow row = null;

					//List<Map> rsource = qmshtDao.getGlassDataYX(departmentsPo.getBdpdepartmentid(),begDate, endDate);
					List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);

					HSSFCell c1 = shopSheet.getRow(0).getCell(0);
					(c1 != null ? c1 : shopSheet.getRow(0).createCell(0))
							.setCellValue(departmentsPo.getBdpdepartmentname());

					if (rsource != null && rsource.size() > 0) {
						// 科视
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
						// E&E						
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));						
						// 露晰得角膜塑形镜
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						// ORTHO-K角膜塑形镜
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						// 美国C＆E角膜塑形镜
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
						// 亨泰角膜塑形镜
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));						
						// 欧几里徳角膜塑形镜
						SetExcelCell(shopSheet.getRow(9), rsource.get(6));						
						// 视力卡
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
						// 双面镜
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));
						// 字母表
						SetExcelCell(shopSheet.getRow(14), rsource.get(9));
						// 聚散球
						SetExcelCell(shopSheet.getRow(15), rsource.get(10));
						// 训练软件
						SetExcelCell(shopSheet.getRow(16), rsource.get(11));
						// 助视器
						SetExcelCell(shopSheet.getRow(17), rsource.get(12));
						// 集合卡
						SetExcelCell(shopSheet.getRow(18), rsource.get(13));
						// 范围系列立体镜+底内低外组合
						SetExcelCell(shopSheet.getRow(19), rsource.get(14));
						// 练习簿
						SetExcelCell(shopSheet.getRow(20), rsource.get(15));						
						// 救生圈卡
						SetExcelCell(shopSheet.getRow(21), rsource.get(16));
						// 偏心的同心圆卡
						SetExcelCell(shopSheet.getRow(22), rsource.get(17));						
						// 其他金额
						SetExcelCell(shopSheet.getRow(24), rsource.get(18));
						// 订金合计
						SetExcelCell(shopSheet.getRow(25), rsource.get(19));
						
						// 塑形片
						setFormulas(shopSheet.getRow(2));
						// 视觉训练
						setFormulas(shopSheet.getRow(11));
						// 合计
						setFormula(shopSheet.getRow(27));
					}
				}
				
				shopsSheet = workbook.getSheet("全年销售目标");
				if (shopsSheet != null) {
					HSSFRow row = null;
					SalesDetailPo rsource = qmshtDao.getSalesData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
					HSSFCell c1 = null;
					HSSFCell c2 = null;
					
					switch(Integer.valueOf(departmentsPo.getBdpdepartmentid())){
                    case 01://中心店
                    	c1 = shopsSheet.getRow(4).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(4).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(26).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(26).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));                    	
                    	break;
                    case 02://甘肃路店
                    	c1 = shopsSheet.getRow(3).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(3).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(25).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(25).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 03://隐形中心店
                    	c1 = shopsSheet.getRow(18).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(18).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(40).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(40).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 04://河东店
                    	c1 = shopsSheet.getRow(9).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(9).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(31).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(31).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 05://津南店
                    	c1 = shopsSheet.getRow(7).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(7).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(29).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(29).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 06://塘沽店
                    	c1 = shopsSheet.getRow(5).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(5).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(27).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(27).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 07://大港店
                    	c1 = shopsSheet.getRow(6).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(6).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(28).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(28).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 8://奥城店
                    	c1 = shopsSheet.getRow(8).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(8).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(30).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(30).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    	break;
                    case 9://武清店
                    	c1 = shopsSheet.getRow(10).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(10).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(32).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(32).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    case 10://中北店
                    	c1 = shopsSheet.getRow(11).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(11).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(33).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(33).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
                    case 11://西康路店
                    	c1 = shopsSheet.getRow(12).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(12).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(34).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(34).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
                    case 12://角膜接触镜工作室
                    	c1 = shopsSheet.getRow(13).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(13).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(35).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(35).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
                    case 13://河北店
                    	c1 = shopsSheet.getRow(14).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(14).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(36).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(36).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
                    case 14://北辰店
                    	c1 = shopsSheet.getRow(15).getCell(1);
                    	(c1 != null ? c1 : shopsSheet.getRow(15).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
                    	c2 = shopsSheet.getRow(37).getCell(1);
                    	(c2 != null ? c2 : shopsSheet.getRow(37).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
                    }					
				}
				setFormula(shopsSheet.getRow(16),1);
				setFormula(shopsSheet.getRow(20),1);
				setFormula(shopsSheet.getRow(38),1);
				setFormula(shopsSheet.getRow(42),1);
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

	private void SetExcelCell(HSSFRow row, InventoryEntryPo po) {
		HSSFCell c1 = row.getCell(0);
		HSSFCell c2 = row.getCell(1);
		HSSFCell c3 = row.getCell(2);
		//System.out.println("rsource : " + rsource.toString());
		(c1 != null ? c1 : row.createCell(0)).setCellValue(Utility.getName(po.getCstiegoodsname()));
		(c2 != null ? c2 : row.createCell(1)).setCellValue(!Utility.getName(po.getCstiegoodsquantity()).equals("") ? Double.parseDouble(Utility.getName(po.getCstiegoodsquantity())) : 0d);
		(c3 != null ? c3 : row.createCell(2)).setCellValue(!Utility.getName(po.getCstienottaxrateamount()).equals("") ? Double.parseDouble(Utility.getName(po.getCstienottaxrateamount())) : 0d);
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
	
	public InputStream bulidShopExcelNew(FileInputStream excel,String begDate, String endDate)
	   throws Exception {

		try {
			/**
			 * 门店销售金额 （不包括隐形）
			 */			
			HSSFWorkbook workbook = new HSSFWorkbook(excel);
			HSSFSheet shopSheet = null;
			HSSFSheet shopsSheet = null;
			
			List<DepartmentsPo> departmentsList = departmentsDao.getDepartments("1");
			Iterator<DepartmentsPo> it = departmentsList.iterator();
			while(it.hasNext()){
				DepartmentsPo departmentsPo = (DepartmentsPo)it.next();
				
				if (!"03".equals(departmentsPo.getBdpdepartmentid())) {
					shopSheet = workbook.getSheet(departmentsPo.getBdpdepartmentname()+departmentsPo.getBdpdepartmentid());
		
					if (shopSheet != null) {
		
						HSSFRow row = null;
		
						List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
						
						HSSFCell c1 = shopSheet.getRow(0).getCell(0);
						(c1 != null ? c1 : shopSheet.getRow(0).createCell(0)).setCellValue(departmentsPo.getBdpdepartmentname());
		
						// ================ 成品镜片 =================
						// 依视路
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
		
						// 尼康
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));
		
						// 豪雅
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						
						// 罗敦司得
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						
						// 蔡司
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
		
						// 其它
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));
		
						// ================ 订做镜片 =================
						// 渐进
						SetExcelCell(shopSheet.getRow(11), rsource.get(6));
		
						// MC
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
		
						// 其它
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));

						// ================ 镜架 =================
						// 200元以下
						SetExcelCell(shopSheet.getRow(16), rsource.get(9));
		
						// 200-800元
						SetExcelCell(shopSheet.getRow(17), rsource.get(10));
		
						// 800元以上
						SetExcelCell(shopSheet.getRow(18), rsource.get(11));			

						// ================ 其他金额 =================
						// 其他金额
						SetExcelCell(shopSheet.getRow(20), rsource.get(12));

						// ================ 订金合计 =================
						// 订金合计
						SetExcelCell(shopSheet.getRow(21),rsource.get(13));
	
						// ================ 隐形镜片 =================	
						// RGP
						SetExcelCell(shopSheet.getRow(24), rsource.get(14));
						
						// 角膜塑形镜片
						SetExcelCell(shopSheet.getRow(25), rsource.get(15));
						
						// 视觉训练
						SetExcelCell(shopSheet.getRow(26), rsource.get(16));

						// ================ 隐形软镜 =================	
						// 隐形软镜 
						SetExcelCell(shopSheet.getRow(28), rsource.get(17));
						
						// ================ 护理液 =================	
						// 硬镜护理液
						SetExcelCell(shopSheet.getRow(31), rsource.get(18));
						
						// 软镜护理液
						SetExcelCell(shopSheet.getRow(32), rsource.get(19));
						
					/*******************************************************************************/	
						// 成品镜片
						setFormulas(shopSheet.getRow(2));
		
						// 定做
						setFormulas(shopSheet.getRow(10));
		
						// 镜架
						setFormulas(shopSheet.getRow(15));
		
						// 隐形
						setFormulas(shopSheet.getRow(23));
		
						// 护理液
						setFormulas(shopSheet.getRow(30));
		
						// 合计
						setFormula(shopSheet.getRow(34));
					}
				} else {
					// 隐形销售数据
		
					shopSheet = workbook.getSheet("隐形中心店03");
		
					HSSFRow row = null;
		
					//List<Map> rsource = qmshtDao.getGlassDataYX(departmentsPo.getBdpdepartmentid(),begDate, endDate);
					List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
		
					HSSFCell c1 = shopSheet.getRow(0).getCell(0);
					(c1 != null ? c1 : shopSheet.getRow(0).createCell(0))
							.setCellValue(departmentsPo.getBdpdepartmentname());
		
					if (rsource != null && rsource.size() > 0) {
						// 科视
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
						// E&E						
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));						
						// 露晰得角膜塑形镜
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						// ORTHO-K角膜塑形镜
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						// 美国C＆E角膜塑形镜
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
						// 亨泰角膜塑形镜
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));						
						// 欧几里徳角膜塑形镜
						SetExcelCell(shopSheet.getRow(9), rsource.get(6));						
						// 视力卡
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
						// 双面镜
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));
						// 字母表
						SetExcelCell(shopSheet.getRow(14), rsource.get(9));
						// 聚散球
						SetExcelCell(shopSheet.getRow(15), rsource.get(10));
						// 训练软件
						SetExcelCell(shopSheet.getRow(16), rsource.get(11));
						// 助视器
						SetExcelCell(shopSheet.getRow(17), rsource.get(12));
						// 集合卡
						SetExcelCell(shopSheet.getRow(18), rsource.get(13));
						// 范围系列立体镜+底内低外组合
						SetExcelCell(shopSheet.getRow(19), rsource.get(14));
						// 练习簿
						SetExcelCell(shopSheet.getRow(20), rsource.get(15));						
						// 救生圈卡
						SetExcelCell(shopSheet.getRow(21), rsource.get(16));
						// 偏心的同心圆卡
						SetExcelCell(shopSheet.getRow(22), rsource.get(17));						
						// 其他金额
						SetExcelCell(shopSheet.getRow(24), rsource.get(18));
						// 订金合计
						SetExcelCell(shopSheet.getRow(25), rsource.get(19));
						
						// 塑形片
						setFormulas(shopSheet.getRow(2));
						// 视觉训练
						setFormulas(shopSheet.getRow(11));
						// 合计
						setFormula(shopSheet.getRow(27));
					}
				}
				
				shopsSheet = workbook.getSheet("全年销售目标");
				if (shopsSheet != null) {
					HSSFRow row = null;
					SalesDetailPo rsource = qmshtDao.getSalesData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
					HSSFCell c1 = null;
					HSSFCell c2 = null;
					
					switch(Integer.valueOf(departmentsPo.getBdpdepartmentid())){
		            case 01://中心店
		            	c1 = shopsSheet.getRow(4).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(4).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(26).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(26).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));                    	
		            	break;
		            case 02://甘肃路店
		            	c1 = shopsSheet.getRow(3).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(3).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(25).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(25).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 03://隐形中心店
		            	c1 = shopsSheet.getRow(18).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(18).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(40).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(40).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 04://河东店
		            	c1 = shopsSheet.getRow(9).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(9).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(31).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(31).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 05://津南店
		            	c1 = shopsSheet.getRow(7).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(7).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(29).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(29).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 06://塘沽店
		            	c1 = shopsSheet.getRow(5).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(5).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(27).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(27).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 07://大港店
		            	c1 = shopsSheet.getRow(6).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(6).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(28).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(28).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 8://奥城店
		            	c1 = shopsSheet.getRow(8).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(8).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(30).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(30).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 9://武清店
		            	c1 = shopsSheet.getRow(10).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(10).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(32).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(32).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            case 10://中北店
		            	c1 = shopsSheet.getRow(11).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(11).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(33).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(33).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            case 11://西康路店
		            	c1 = shopsSheet.getRow(12).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(12).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(34).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(34).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 12://角膜接触镜工作室
		            	c1 = shopsSheet.getRow(13).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(13).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(35).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(35).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 13://河北店
		            	c1 = shopsSheet.getRow(14).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(14).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(36).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(36).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 14://北辰店
		            	c1 = shopsSheet.getRow(15).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(15).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(37).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(37).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            }					
				}
				setFormula(shopsSheet.getRow(16),1);
				setFormula(shopsSheet.getRow(20),1);
				setFormula(shopsSheet.getRow(38),1);
				setFormula(shopsSheet.getRow(42),1);
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
	
	
	public InputStream bulidShopExcelNew2(FileInputStream excel,String begDate, String endDate)
	   throws Exception {

		try {
			/**
			 * 门店销售金额 （不包括隐形）
			 */			
			HSSFWorkbook workbook = new HSSFWorkbook(excel);
			HSSFSheet shopSheet = null;
			HSSFSheet shopsSheet = null;
			
			List<DepartmentsPo> departmentsList = departmentsDao.getDepartments("1");
			Iterator<DepartmentsPo> it = departmentsList.iterator();
			while(it.hasNext()){
				DepartmentsPo departmentsPo = (DepartmentsPo)it.next();
				
				if ("01".equals(departmentsPo.getBdpdepartmentid())) {
					shopSheet = workbook.getSheet(departmentsPo.getBdpdepartmentname()+departmentsPo.getBdpdepartmentid());
		
					if (shopSheet != null) {
		
						HSSFRow row = null;
		
						List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
						
						HSSFCell c1 = shopSheet.getRow(0).getCell(0);
						(c1 != null ? c1 : shopSheet.getRow(0).createCell(0)).setCellValue(departmentsPo.getBdpdepartmentname());
		
						// ================ 成品镜片 =================
						// 依视路
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
		
						// 尼康
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));
		
						// 豪雅
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						
						// 罗敦司得
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						
						// 蔡司
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
		
						// 其它
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));
		
						// ================ 订做镜片 =================
						// 渐进
						SetExcelCell(shopSheet.getRow(11), rsource.get(6));
		
						// MC
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
		
						// 其它
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));

						// ================ 镜架 =================
						// 200元以下
						SetExcelCell(shopSheet.getRow(16), rsource.get(9));
		
						// 200-800元
						SetExcelCell(shopSheet.getRow(17), rsource.get(10));
		
						// 800元以上
						SetExcelCell(shopSheet.getRow(18), rsource.get(11));			

						// ================ 其他金额 =================
						// 其他金额
						SetExcelCell(shopSheet.getRow(20), rsource.get(12));

						// ================ 订金合计 =================
						// 订金合计
						SetExcelCell(shopSheet.getRow(21),rsource.get(13));
	
						// ================ 隐形镜片 =================	
						// RGP
						SetExcelCell(shopSheet.getRow(24), rsource.get(14));
						
						// 角膜塑形镜片
						SetExcelCell(shopSheet.getRow(25), rsource.get(15));
						
						// 视觉训练
						SetExcelCell(shopSheet.getRow(26), rsource.get(16));

						// ================ 隐形软镜 =================	
						// 隐形软镜 
						SetExcelCell(shopSheet.getRow(28), rsource.get(17));
						
						// ================ 护理液 ===================	
						// 硬镜护理液
						SetExcelCell(shopSheet.getRow(31), rsource.get(18));
						
						// 软镜护理液
						SetExcelCell(shopSheet.getRow(32), rsource.get(19));

						// ================ 塑形片 ===================	
						// 科视
						SetExcelCell(shopSheet.getRow(35), rsource.get(20));
						
						// E&E						
						SetExcelCell(shopSheet.getRow(36), rsource.get(21));
						
						// 露晰得角膜塑形镜
						SetExcelCell(shopSheet.getRow(37), rsource.get(22));
						
						// ORTHO-K角膜塑形镜
						SetExcelCell(shopSheet.getRow(38), rsource.get(23));
						
						// 美国C＆E角膜塑形镜
						SetExcelCell(shopSheet.getRow(39), rsource.get(24));
						
						// 亨泰角膜塑形镜
						SetExcelCell(shopSheet.getRow(40), rsource.get(25));	
						
						// 欧几里徳角膜塑形镜
						SetExcelCell(shopSheet.getRow(41), rsource.get(26));	
						
						// ================ 视觉训练 ===================						
						// 视力卡
						SetExcelCell(shopSheet.getRow(44), rsource.get(27));
						
						// 双面镜
						SetExcelCell(shopSheet.getRow(45), rsource.get(28));
						
						// 字母表
						SetExcelCell(shopSheet.getRow(46), rsource.get(29));
						
						// 聚散球
						SetExcelCell(shopSheet.getRow(47), rsource.get(30));
						
						// 训练软件
						SetExcelCell(shopSheet.getRow(48), rsource.get(31));
						
						// 助视器
						SetExcelCell(shopSheet.getRow(49), rsource.get(32));
						
						// 集合卡
						SetExcelCell(shopSheet.getRow(50), rsource.get(33));
						
						// 范围系列立体镜+底内低外组合
						SetExcelCell(shopSheet.getRow(51), rsource.get(34));
						
						// 练习簿
						SetExcelCell(shopSheet.getRow(52), rsource.get(35));
						
						// 救生圈卡
						SetExcelCell(shopSheet.getRow(53), rsource.get(36));
						
						// 偏心的同心圆卡
						SetExcelCell(shopSheet.getRow(54), rsource.get(37));
	
						// ================ 其他金额 =================					
						// 其他金额
						SetExcelCell(shopSheet.getRow(56), rsource.get(38));
	
						// ================ 订金合计 =================
						// 订金合计
						SetExcelCell(shopSheet.getRow(57), rsource.get(39));
					
					/*******************************************************************************/	
						// 成品镜片
						setFormulas(shopSheet.getRow(2));
		
						// 定做
						setFormulas(shopSheet.getRow(10));
		
						// 镜架
						setFormulas(shopSheet.getRow(15));
		
						// 隐形
						setFormulas(shopSheet.getRow(23));
		
						// 护理液
						setFormulas(shopSheet.getRow(30));
						
						// 塑形片
						setFormulas(shopSheet.getRow(34));
						
						// 视觉训练
						setFormulas(shopSheet.getRow(43));
		
						// 合计
						setFormula(shopSheet.getRow(59));
					}
				} else if ("03".equals(departmentsPo.getBdpdepartmentid())) {
	
					shopSheet = workbook.getSheet("隐形中心店03");		
					HSSFRow row = null;

					List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
		
					HSSFCell c1 = shopSheet.getRow(0).getCell(0);
					(c1 != null ? c1 : shopSheet.getRow(0).createCell(0))
							.setCellValue(departmentsPo.getBdpdepartmentname());
		
					if (rsource != null && rsource.size() > 0) {
						// 科视
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
						// E&E						
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));						
						// 露晰得角膜塑形镜
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						// ORTHO-K角膜塑形镜
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						// 美国C＆E角膜塑形镜
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
						// 亨泰角膜塑形镜
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));						
						// 欧几里徳角膜塑形镜
						SetExcelCell(shopSheet.getRow(9), rsource.get(6));						
						// 视力卡
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
						// 双面镜
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));
						// 字母表
						SetExcelCell(shopSheet.getRow(14), rsource.get(9));
						// 聚散球
						SetExcelCell(shopSheet.getRow(15), rsource.get(10));
						// 训练软件
						SetExcelCell(shopSheet.getRow(16), rsource.get(11));
						// 助视器
						SetExcelCell(shopSheet.getRow(17), rsource.get(12));
						// 集合卡
						SetExcelCell(shopSheet.getRow(18), rsource.get(13));
						// 范围系列立体镜+底内低外组合
						SetExcelCell(shopSheet.getRow(19), rsource.get(14));
						// 练习簿
						SetExcelCell(shopSheet.getRow(20), rsource.get(15));						
						// 救生圈卡
						SetExcelCell(shopSheet.getRow(21), rsource.get(16));
						// 偏心的同心圆卡
						SetExcelCell(shopSheet.getRow(22), rsource.get(17));						
						// 其他金额
						SetExcelCell(shopSheet.getRow(24), rsource.get(18));
						// 订金合计
						SetExcelCell(shopSheet.getRow(25), rsource.get(19));
						
						// 塑形片
						setFormulas(shopSheet.getRow(2));
						// 视觉训练
						setFormulas(shopSheet.getRow(11));
						// 合计
						setFormula(shopSheet.getRow(27));
					}
				} else {
					
					shopSheet = workbook.getSheet(departmentsPo.getBdpdepartmentname()+departmentsPo.getBdpdepartmentid());
					
					if (shopSheet != null) {
		
						HSSFRow row = null;
		
						List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
						
						HSSFCell c1 = shopSheet.getRow(0).getCell(0);
						(c1 != null ? c1 : shopSheet.getRow(0).createCell(0)).setCellValue(departmentsPo.getBdpdepartmentname());
		
						// ================ 成品镜片 =================
						// 依视路
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
		
						// 尼康
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));
		
						// 豪雅
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						
						// 罗敦司得
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						
						// 蔡司
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
		
						// 其它
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));
		
						// ================ 订做镜片 =================
						// 渐进
						SetExcelCell(shopSheet.getRow(11), rsource.get(6));
		
						// MC
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
		
						// 其它
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));

						// ================ 镜架 =================
						// 200元以下
						SetExcelCell(shopSheet.getRow(16), rsource.get(9));
		
						// 200-800元
						SetExcelCell(shopSheet.getRow(17), rsource.get(10));
		
						// 800元以上
						SetExcelCell(shopSheet.getRow(18), rsource.get(11));			

						// ================ 其他金额 =================
						// 其他金额
						SetExcelCell(shopSheet.getRow(20), rsource.get(12));

						// ================ 订金合计 =================
						// 订金合计
						SetExcelCell(shopSheet.getRow(21),rsource.get(13));
	
						// ================ 隐形镜片 =================	
						// RGP
						SetExcelCell(shopSheet.getRow(24), rsource.get(14));
						
						// 角膜塑形镜片
						SetExcelCell(shopSheet.getRow(25), rsource.get(15));
						
						// 视觉训练
						SetExcelCell(shopSheet.getRow(26), rsource.get(16));

						// ================ 隐形软镜 =================	
						// 隐形软镜 
						SetExcelCell(shopSheet.getRow(28), rsource.get(17));
						
						// ================ 护理液 =================	
						// 硬镜护理液
						SetExcelCell(shopSheet.getRow(31), rsource.get(18));
						
						// 软镜护理液
						SetExcelCell(shopSheet.getRow(32), rsource.get(19));
						
					/*******************************************************************************/	
						// 成品镜片
						setFormulas(shopSheet.getRow(2));
		
						// 定做
						setFormulas(shopSheet.getRow(10));
		
						// 镜架
						setFormulas(shopSheet.getRow(15));
		
						// 隐形
						setFormulas(shopSheet.getRow(23));
		
						// 护理液
						setFormulas(shopSheet.getRow(30));
		
						// 合计
						setFormula(shopSheet.getRow(34));
					}

				}
				
				shopsSheet = workbook.getSheet("全年销售目标");
				if (shopsSheet != null) {
					HSSFRow row = null;
					SalesDetailPo rsource = qmshtDao.getSalesData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
					HSSFCell c1 = null;
					HSSFCell c2 = null;
					
					switch(Integer.valueOf(departmentsPo.getBdpdepartmentid())){
		            case 01://中心店
		            	c1 = shopsSheet.getRow(4).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(4).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(26).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(26).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));                    	
		            	break;
		            case 02://甘肃路店
		            	c1 = shopsSheet.getRow(3).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(3).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(25).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(25).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 03://隐形中心店
		            	c1 = shopsSheet.getRow(18).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(18).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(40).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(40).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 04://河东店
		            	c1 = shopsSheet.getRow(9).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(9).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(31).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(31).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 05://津南店
		            	c1 = shopsSheet.getRow(7).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(7).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(29).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(29).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 06://塘沽店
		            	c1 = shopsSheet.getRow(5).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(5).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(27).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(27).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 07://大港店
		            	c1 = shopsSheet.getRow(6).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(6).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(28).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(28).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 8://奥城店
		            	c1 = shopsSheet.getRow(8).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(8).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(30).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(30).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 9://武清店
		            	c1 = shopsSheet.getRow(10).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(10).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(32).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(32).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            case 10://中北店
		            	c1 = shopsSheet.getRow(11).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(11).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(33).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(33).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            case 11://西康路店
		            	c1 = shopsSheet.getRow(12).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(12).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(34).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(34).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 12://角膜接触镜工作室
		            	c1 = shopsSheet.getRow(13).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(13).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(35).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(35).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 13://河北店
		            	c1 = shopsSheet.getRow(14).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(14).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(36).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(36).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 14://北辰店
		            	c1 = shopsSheet.getRow(15).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(15).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(37).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(37).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            }					
				}
				setFormula(shopsSheet.getRow(16),1);
				setFormula(shopsSheet.getRow(20),1);
				setFormula(shopsSheet.getRow(38),1);
				setFormula(shopsSheet.getRow(42),1);
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
	
	public InputStream bulidShopExcelNew3(FileInputStream excel,String begDate, String endDate) throws Exception{

		try {
			/**
			 * 门店销售金额 （不包括隐形）
			 */			
			HSSFWorkbook workbook = new HSSFWorkbook(excel);
			HSSFSheet shopSheet = null;
			HSSFSheet shopsSheet = null;
			
			List<DepartmentsPo> departmentsList = departmentsDao.getDepartments("1");
			Iterator<DepartmentsPo> it = departmentsList.iterator();
			while(it.hasNext()){
				DepartmentsPo departmentsPo = (DepartmentsPo)it.next();
				
				if ("01".equals(departmentsPo.getBdpdepartmentid())) {
					shopSheet = workbook.getSheet(departmentsPo.getBdpdepartmentname()+departmentsPo.getBdpdepartmentid());
		
					if (shopSheet != null) {
		
						HSSFRow row = null;
		
						List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
						
						HSSFCell c1 = shopSheet.getRow(0).getCell(0);
						(c1 != null ? c1 : shopSheet.getRow(0).createCell(0)).setCellValue(departmentsPo.getBdpdepartmentname());
		
						// ================ 成品镜片 =================
						// 依视路
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
		
						// 尼康
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));
		
						// 豪雅
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						
						// 罗敦司得
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						
						// 蔡司
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
		
						// 其它
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));
		
						// ================ 订做镜片 =================
						// 渐进
						SetExcelCell(shopSheet.getRow(11), rsource.get(6));
		
						// MC
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
		
						// 其它
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));

						// ================ 镜架 =================
						// 200元以下
						SetExcelCell(shopSheet.getRow(16), rsource.get(9));
		
						// 200-800元
						SetExcelCell(shopSheet.getRow(17), rsource.get(10));
		
						// 800元以上
						SetExcelCell(shopSheet.getRow(18), rsource.get(11));			

						// ================ 其他金额 =================
						// 其他金额
						SetExcelCell(shopSheet.getRow(20), rsource.get(12));

						// ================ 订金合计 =================
						// 订金合计
						SetExcelCell(shopSheet.getRow(21),rsource.get(13));
	
						// ================ 隐形镜片 =================	
						// RGP
						SetExcelCell(shopSheet.getRow(24), rsource.get(14));
						
						// 角膜塑形镜片
						SetExcelCell(shopSheet.getRow(25), rsource.get(15));
						
						// 视觉训练
						SetExcelCell(shopSheet.getRow(26), rsource.get(16));

						// ================ 隐形软镜 =================	
						// 隐形软镜 
						SetExcelCell(shopSheet.getRow(28), rsource.get(17));
						
						// ================ 护理液 ===================	
						// 硬镜护理液
						SetExcelCell(shopSheet.getRow(31), rsource.get(18));
						
						// 软镜护理液
						SetExcelCell(shopSheet.getRow(32), rsource.get(19));
					
					/*******************************************************************************/	
						// 成品镜片
						setFormulas(shopSheet.getRow(2));
		
						// 定做
						setFormulas(shopSheet.getRow(10));
		
						// 镜架
						setFormulas(shopSheet.getRow(15));
		
						// 隐形
						setFormulas(shopSheet.getRow(23));
		
						// 护理液
						setFormulas(shopSheet.getRow(30));
		
						// 合计
						setFormula(shopSheet.getRow(34));
					}
				} else if ("03".equals(departmentsPo.getBdpdepartmentid())) {
	
					shopSheet = workbook.getSheet("隐形中心店03");		
					HSSFRow row = null;

					List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
		
					HSSFCell c1 = shopSheet.getRow(0).getCell(0);
					(c1 != null ? c1 : shopSheet.getRow(0).createCell(0))
							.setCellValue(departmentsPo.getBdpdepartmentname());
		
					if (rsource != null && rsource.size() > 0) {
						// 科视
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
						// E&E						
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));						
						// 露晰得角膜塑形镜
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						// ORTHO-K角膜塑形镜
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						// 美国C＆E角膜塑形镜
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
						// 亨泰角膜塑形镜
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));						
						// 欧几里徳角膜塑形镜
						SetExcelCell(shopSheet.getRow(9), rsource.get(6));						
						// 视力卡
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
						// 双面镜
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));
						// 字母表
						SetExcelCell(shopSheet.getRow(14), rsource.get(9));
						// 聚散球
						SetExcelCell(shopSheet.getRow(15), rsource.get(10));
						// 训练软件
						SetExcelCell(shopSheet.getRow(16), rsource.get(11));
						// 助视器
						SetExcelCell(shopSheet.getRow(17), rsource.get(12));
						// 集合卡
						SetExcelCell(shopSheet.getRow(18), rsource.get(13));
						// 范围系列立体镜+底内低外组合
						SetExcelCell(shopSheet.getRow(19), rsource.get(14));
						// 练习簿
						SetExcelCell(shopSheet.getRow(20), rsource.get(15));						
						// 救生圈卡
						SetExcelCell(shopSheet.getRow(21), rsource.get(16));
						// 偏心的同心圆卡
						SetExcelCell(shopSheet.getRow(22), rsource.get(17));						
						// 其他金额
						SetExcelCell(shopSheet.getRow(24), rsource.get(18));
						// 订金合计
						SetExcelCell(shopSheet.getRow(25), rsource.get(19));
						
						// 塑形片
						setFormulas(shopSheet.getRow(2));
						// 视觉训练
						setFormulas(shopSheet.getRow(11));
						// 合计
						setFormula(shopSheet.getRow(27));
					}
				} else {
					
					shopSheet = workbook.getSheet(departmentsPo.getBdpdepartmentname()+departmentsPo.getBdpdepartmentid());
					
					if (shopSheet != null) {
		
						HSSFRow row = null;
		
						List<InventoryEntryPo> rsource = qmshtDao.getGlassData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
						
						HSSFCell c1 = shopSheet.getRow(0).getCell(0);
						(c1 != null ? c1 : shopSheet.getRow(0).createCell(0)).setCellValue(departmentsPo.getBdpdepartmentname());
		
						// ================ 成品镜片 =================
						// 依视路
						SetExcelCell(shopSheet.getRow(3), rsource.get(0));
		
						// 尼康
						SetExcelCell(shopSheet.getRow(4), rsource.get(1));
		
						// 豪雅
						SetExcelCell(shopSheet.getRow(5), rsource.get(2));
						
						// 罗敦司得
						SetExcelCell(shopSheet.getRow(6), rsource.get(3));
						
						// 蔡司
						SetExcelCell(shopSheet.getRow(7), rsource.get(4));
		
						// 其它
						SetExcelCell(shopSheet.getRow(8), rsource.get(5));
		
						// ================ 订做镜片 =================
						// 渐进
						SetExcelCell(shopSheet.getRow(11), rsource.get(6));
		
						// MC
						SetExcelCell(shopSheet.getRow(12), rsource.get(7));
		
						// 其它
						SetExcelCell(shopSheet.getRow(13), rsource.get(8));

						// ================ 镜架 =================
						// 200元以下
						SetExcelCell(shopSheet.getRow(16), rsource.get(9));
		
						// 200-800元
						SetExcelCell(shopSheet.getRow(17), rsource.get(10));
		
						// 800元以上
						SetExcelCell(shopSheet.getRow(18), rsource.get(11));			

						// ================ 其他金额 =================
						// 其他金额
						SetExcelCell(shopSheet.getRow(20), rsource.get(12));

						// ================ 订金合计 =================
						// 订金合计
						SetExcelCell(shopSheet.getRow(21),rsource.get(13));
	
						// ================ 隐形镜片 =================	
						// RGP
						SetExcelCell(shopSheet.getRow(24), rsource.get(14));
						
						// 角膜塑形镜片
						SetExcelCell(shopSheet.getRow(25), rsource.get(15));
						
						// 视觉训练
						SetExcelCell(shopSheet.getRow(26), rsource.get(16));

						// ================ 隐形软镜 =================	
						// 隐形软镜 
						SetExcelCell(shopSheet.getRow(28), rsource.get(17));
						
						// ================ 护理液 =================	
						// 硬镜护理液
						SetExcelCell(shopSheet.getRow(31), rsource.get(18));
						
						// 软镜护理液
						SetExcelCell(shopSheet.getRow(32), rsource.get(19));
						
					/*******************************************************************************/	
						// 成品镜片
						setFormulas(shopSheet.getRow(2));
		
						// 定做
						setFormulas(shopSheet.getRow(10));
		
						// 镜架
						setFormulas(shopSheet.getRow(15));
		
						// 隐形
						setFormulas(shopSheet.getRow(23));
		
						// 护理液
						setFormulas(shopSheet.getRow(30));
		
						// 合计
						setFormula(shopSheet.getRow(34));
					}

				}
				
				shopsSheet = workbook.getSheet("全年销售目标");
				if (shopsSheet != null) {
					HSSFRow row = null;
					SalesDetailPo rsource = qmshtDao.getSalesData(departmentsPo.getBdpdepartmentid(), begDate, endDate);
					HSSFCell c1 = null;
					HSSFCell c2 = null;
					
					switch(Integer.valueOf(departmentsPo.getBdpdepartmentid())){
		            case 01://中心店
		            	c1 = shopsSheet.getRow(4).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(4).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(26).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(26).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));                    	
		            	break;
		            case 02://甘肃路店
		            	c1 = shopsSheet.getRow(3).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(3).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(25).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(25).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 03://隐形中心店
		            	c1 = shopsSheet.getRow(18).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(18).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(40).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(40).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 04://河东店
		            	c1 = shopsSheet.getRow(9).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(9).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(31).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(31).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 05://津南店
		            	c1 = shopsSheet.getRow(7).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(7).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(29).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(29).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 06://塘沽店
		            	c1 = shopsSheet.getRow(5).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(5).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(27).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(27).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 07://大港店
		            	c1 = shopsSheet.getRow(6).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(6).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(28).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(28).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 8://奥城店
		            	c1 = shopsSheet.getRow(8).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(8).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(30).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(30).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            	break;
		            case 9://武清店
		            	c1 = shopsSheet.getRow(10).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(10).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(32).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(32).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            case 10://中北店
		            	c1 = shopsSheet.getRow(11).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(11).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(33).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(33).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));
		            case 11://西康路店
		            	c1 = shopsSheet.getRow(12).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(12).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(34).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(34).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 12://角膜接触镜工作室
		            	c1 = shopsSheet.getRow(13).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(13).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(35).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(35).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 13://河北店
		            	c1 = shopsSheet.getRow(14).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(14).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(36).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(36).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            case 14://北辰店
		            	c1 = shopsSheet.getRow(15).getCell(1);
		            	(c1 != null ? c1 : shopsSheet.getRow(15).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdsalesvalue()));
		            	c2 = shopsSheet.getRow(37).getCell(1);
		            	(c2 != null ? c2 : shopsSheet.getRow(37).createCell(1)).setCellValue(Double.valueOf(rsource.getSsesdnumber()));	
		            }					
				}
				setFormula(shopsSheet.getRow(16),1);
				setFormula(shopsSheet.getRow(20),1);
				setFormula(shopsSheet.getRow(38),1);
				setFormula(shopsSheet.getRow(42),1);
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
	
}
