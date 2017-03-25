package com.pengsheng.eims.report.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.report.dao.GoodsSalesAnalysisDao;
import com.pengsheng.eims.report.mgr.GoodsSalesAnalysisMgr;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.dao.DepartmentsDao;

public class GoodsSalesAnalysisMgrImpl implements GoodsSalesAnalysisMgr {

	private GoodsSalesAnalysisDao goodsSalesAnalysisDao;

	private DepartmentsDao departmentsDao;

	public DepartmentsDao getDepartmentsDao() {
		return departmentsDao;
	}

	public void setDepartmentsDao(DepartmentsDao departmentsDao) {
		this.departmentsDao = departmentsDao;
	}

	public GoodsSalesAnalysisDao getGoodsSalesAnalysisDao() {
		return goodsSalesAnalysisDao;
	}

	public void setGoodsSalesAnalysisDao(GoodsSalesAnalysisDao goodsSalesAnalysisDao) {
		this.goodsSalesAnalysisDao = goodsSalesAnalysisDao;
	}

	public InputStream bulidShopExcel(FileInputStream excel, String begDate,
			String endDate) {


		/**
		 * 门店销售金额 （不包括隐形）
		 */
		HSSFWorkbook workbook;

		try {
			workbook = new HSSFWorkbook(excel);

			HSSFSheet shopSheet = null;
			HSSFSheet shopsSheet = null;
			shopSheet = workbook.getSheet("商品销售分析报表（院长）");
			
//			List<DepartmentsPo> departmentsList = departmentsDao
//					.getDepartments("1");

			if (shopSheet != null) {
				HSSFRow row = null;

				List<Map> rsource = goodsSalesAnalysisDao.getGoodsSalesAnalysis("",
						begDate, endDate);

				// 折射率为1.5镜片
				SetExcelCell(shopSheet.getRow(4), rsource.get(0));
				SetExcelCell(shopSheet.getRow(5), rsource.get(1));
				shopSheet.getRow(4).getCell(3).setCellFormula(shopSheet.getRow(4).getCell(3).getCellFormula());
				shopSheet.getRow(4).getCell(5).setCellFormula(shopSheet.getRow(4).getCell(5).getCellFormula());
				shopSheet.getRow(5).getCell(3).setCellFormula(shopSheet.getRow(5).getCell(3).getCellFormula());
				shopSheet.getRow(5).getCell(5).setCellFormula(shopSheet.getRow(5).getCell(5).getCellFormula());
				
				shopSheet.getRow(6).getCell(2).setCellFormula(shopSheet.getRow(6).getCell(2).getCellFormula());
				shopSheet.getRow(6).getCell(3).setCellFormula(shopSheet.getRow(6).getCell(3).getCellFormula());
				shopSheet.getRow(6).getCell(4).setCellFormula(shopSheet.getRow(6).getCell(4).getCellFormula());
				shopSheet.getRow(6).getCell(5).setCellFormula(shopSheet.getRow(6).getCell(5).getCellFormula());
				shopSheet.getRow(6).getCell(6).setCellFormula(shopSheet.getRow(6).getCell(6).getCellFormula());
//				// 折射率为1.56镜片
				SetExcelCell(shopSheet.getRow(7), rsource.get(2));
				SetExcelCell(shopSheet.getRow(8), rsource.get(3));
				shopSheet.getRow(7).getCell(3).setCellFormula(shopSheet.getRow(7).getCell(3).getCellFormula());
				shopSheet.getRow(7).getCell(5).setCellFormula(shopSheet.getRow(7).getCell(5).getCellFormula());
				shopSheet.getRow(8).getCell(3).setCellFormula(shopSheet.getRow(8).getCell(3).getCellFormula());
				shopSheet.getRow(8).getCell(5).setCellFormula(shopSheet.getRow(8).getCell(5).getCellFormula());
				
				shopSheet.getRow(9).getCell(2).setCellFormula(shopSheet.getRow(9).getCell(2).getCellFormula());
				shopSheet.getRow(9).getCell(3).setCellFormula(shopSheet.getRow(9).getCell(3).getCellFormula());
				shopSheet.getRow(9).getCell(4).setCellFormula(shopSheet.getRow(9).getCell(4).getCellFormula());
				shopSheet.getRow(9).getCell(5).setCellFormula(shopSheet.getRow(9).getCell(5).getCellFormula());
				shopSheet.getRow(9).getCell(6).setCellFormula(shopSheet.getRow(9).getCell(6).getCellFormula());

				// 折射率为1.6镜片
				SetExcelCell(shopSheet.getRow(10), rsource.get(4));
				SetExcelCell(shopSheet.getRow(11), rsource.get(5));
				shopSheet.getRow(10).getCell(3).setCellFormula(shopSheet.getRow(10).getCell(3).getCellFormula());
				shopSheet.getRow(10).getCell(5).setCellFormula(shopSheet.getRow(10).getCell(5).getCellFormula());
				shopSheet.getRow(11).getCell(3).setCellFormula(shopSheet.getRow(11).getCell(3).getCellFormula());
				shopSheet.getRow(11).getCell(5).setCellFormula(shopSheet.getRow(11).getCell(5).getCellFormula());
				
				shopSheet.getRow(12).getCell(2).setCellFormula(shopSheet.getRow(12).getCell(2).getCellFormula());
				shopSheet.getRow(12).getCell(3).setCellFormula(shopSheet.getRow(12).getCell(3).getCellFormula());
				shopSheet.getRow(12).getCell(4).setCellFormula(shopSheet.getRow(12).getCell(4).getCellFormula());
				shopSheet.getRow(12).getCell(5).setCellFormula(shopSheet.getRow(12).getCell(5).getCellFormula());
				shopSheet.getRow(12).getCell(6).setCellFormula(shopSheet.getRow(12).getCell(6).getCellFormula());


				// 折射率为1.67镜片
				SetExcelCell(shopSheet.getRow(13), rsource.get(6));
				SetExcelCell(shopSheet.getRow(14), rsource.get(7));
				shopSheet.getRow(13).getCell(3).setCellFormula(shopSheet.getRow(13).getCell(3).getCellFormula());
				shopSheet.getRow(13).getCell(5).setCellFormula(shopSheet.getRow(13).getCell(5).getCellFormula());
				shopSheet.getRow(14).getCell(3).setCellFormula(shopSheet.getRow(14).getCell(3).getCellFormula());
				shopSheet.getRow(14).getCell(5).setCellFormula(shopSheet.getRow(14).getCell(5).getCellFormula());
				
				shopSheet.getRow(15).getCell(2).setCellFormula(shopSheet.getRow(15).getCell(2).getCellFormula());
				shopSheet.getRow(15).getCell(3).setCellFormula(shopSheet.getRow(15).getCell(3).getCellFormula());
				shopSheet.getRow(15).getCell(4).setCellFormula(shopSheet.getRow(15).getCell(4).getCellFormula());
				shopSheet.getRow(15).getCell(5).setCellFormula(shopSheet.getRow(15).getCell(5).getCellFormula());
				shopSheet.getRow(15).getCell(6).setCellFormula(shopSheet.getRow(15).getCell(6).getCellFormula());

				
				// 折射率为1.74镜片
				SetExcelCell(shopSheet.getRow(16), rsource.get(8));
				SetExcelCell(shopSheet.getRow(17), rsource.get(9));
				
				shopSheet.getRow(16).getCell(3).setCellFormula(shopSheet.getRow(16).getCell(3).getCellFormula());
				shopSheet.getRow(16).getCell(5).setCellFormula(shopSheet.getRow(16).getCell(5).getCellFormula());
				shopSheet.getRow(17).getCell(3).setCellFormula(shopSheet.getRow(17).getCell(3).getCellFormula());
				shopSheet.getRow(17).getCell(5).setCellFormula(shopSheet.getRow(17).getCell(5).getCellFormula());
				
				shopSheet.getRow(18).getCell(2).setCellFormula(shopSheet.getRow(18).getCell(2).getCellFormula());
				shopSheet.getRow(18).getCell(3).setCellFormula(shopSheet.getRow(18).getCell(3).getCellFormula());
				shopSheet.getRow(18).getCell(4).setCellFormula(shopSheet.getRow(18).getCell(4).getCellFormula());
				shopSheet.getRow(18).getCell(5).setCellFormula(shopSheet.getRow(18).getCell(5).getCellFormula());
				shopSheet.getRow(18).getCell(6).setCellFormula(shopSheet.getRow(18).getCell(6).getCellFormula());
				// 青少年渐进
				SetExcelCell(shopSheet.getRow(19), rsource.get(10));
				
				shopSheet.getRow(19).getCell(3).setCellFormula(shopSheet.getRow(19).getCell(3).getCellFormula());
				shopSheet.getRow(19).getCell(5).setCellFormula(shopSheet.getRow(19).getCell(5).getCellFormula());
				//中老年渐进
				SetExcelCell(shopSheet.getRow(21), rsource.get(11));
				SetExcelCell(shopSheet.getRow(22), rsource.get(12));
				SetExcelCell(shopSheet.getRow(23), rsource.get(13));
				
				shopSheet.getRow(21).getCell(3).setCellFormula(shopSheet.getRow(21).getCell(3).getCellFormula());
				shopSheet.getRow(21).getCell(5).setCellFormula(shopSheet.getRow(21).getCell(5).getCellFormula());
				shopSheet.getRow(22).getCell(3).setCellFormula(shopSheet.getRow(22).getCell(3).getCellFormula());
				shopSheet.getRow(22).getCell(5).setCellFormula(shopSheet.getRow(22).getCell(5).getCellFormula());
				shopSheet.getRow(23).getCell(3).setCellFormula(shopSheet.getRow(23).getCell(3).getCellFormula());
				shopSheet.getRow(23).getCell(5).setCellFormula(shopSheet.getRow(23).getCell(5).getCellFormula());
				
				shopSheet.getRow(24).getCell(2).setCellFormula(shopSheet.getRow(24).getCell(2).getCellFormula());
				shopSheet.getRow(24).getCell(3).setCellFormula(shopSheet.getRow(24).getCell(3).getCellFormula());
				shopSheet.getRow(24).getCell(4).setCellFormula(shopSheet.getRow(24).getCell(4).getCellFormula());
				shopSheet.getRow(24).getCell(5).setCellFormula(shopSheet.getRow(24).getCell(5).getCellFormula());
				shopSheet.getRow(24).getCell(6).setCellFormula(shopSheet.getRow(24).getCell(6).getCellFormula());
				
				//变色镜片
				SetExcelCell(shopSheet.getRow(25), rsource.get(14));
				
				shopSheet.getRow(25).getCell(3).setCellFormula(shopSheet.getRow(25).getCell(3).getCellFormula());
				shopSheet.getRow(25).getCell(5).setCellFormula(shopSheet.getRow(25).getCell(5).getCellFormula());
			
				//其他
				SetExcelCell(shopSheet.getRow(27), rsource.get(15));
				
				shopSheet.getRow(27).getCell(3).setCellFormula(shopSheet.getRow(27).getCell(3).getCellFormula());
				shopSheet.getRow(27).getCell(5).setCellFormula(shopSheet.getRow(27).getCell(5).getCellFormula());
				
				shopSheet.getRow(29).getCell(2).setCellFormula(shopSheet.getRow(29).getCell(2).getCellFormula());
				shopSheet.getRow(29).getCell(3).setCellFormula(shopSheet.getRow(29).getCell(3).getCellFormula());
				shopSheet.getRow(29).getCell(4).setCellFormula(shopSheet.getRow(29).getCell(4).getCellFormula());
				shopSheet.getRow(29).getCell(5).setCellFormula(shopSheet.getRow(29).getCell(5).getCellFormula());
				shopSheet.getRow(29).getCell(6).setCellFormula(shopSheet.getRow(29).getCell(6).getCellFormula());
				//镜架类
				SetExcelCell(shopSheet.getRow(33), rsource.get(16));//200元以下
				SetExcelCell(shopSheet.getRow(34), rsource.get(17));//200-400元
				SetExcelCell(shopSheet.getRow(35), rsource.get(18));//400-800元
				SetExcelCell(shopSheet.getRow(36), rsource.get(19));//800-1200元
				SetExcelCell(shopSheet.getRow(37), rsource.get(20));//1200-2000元
				SetExcelCell(shopSheet.getRow(38), rsource.get(21));//2000-4000元
				SetExcelCell(shopSheet.getRow(39), rsource.get(22));//4000-10000元
				SetExcelCell(shopSheet.getRow(40), rsource.get(23));//10000元以上
				
				shopSheet.getRow(33).getCell(3).setCellFormula(shopSheet.getRow(33).getCell(3).getCellFormula());
				shopSheet.getRow(33).getCell(5).setCellFormula(shopSheet.getRow(33).getCell(5).getCellFormula());
				shopSheet.getRow(34).getCell(3).setCellFormula(shopSheet.getRow(34).getCell(3).getCellFormula());
				shopSheet.getRow(34).getCell(5).setCellFormula(shopSheet.getRow(34).getCell(5).getCellFormula());
				shopSheet.getRow(35).getCell(3).setCellFormula(shopSheet.getRow(35).getCell(3).getCellFormula());
				shopSheet.getRow(35).getCell(5).setCellFormula(shopSheet.getRow(35).getCell(5).getCellFormula());
				shopSheet.getRow(36).getCell(3).setCellFormula(shopSheet.getRow(36).getCell(3).getCellFormula());
				shopSheet.getRow(36).getCell(5).setCellFormula(shopSheet.getRow(36).getCell(5).getCellFormula());
				shopSheet.getRow(37).getCell(3).setCellFormula(shopSheet.getRow(37).getCell(3).getCellFormula());
				shopSheet.getRow(37).getCell(5).setCellFormula(shopSheet.getRow(37).getCell(5).getCellFormula());
				shopSheet.getRow(38).getCell(3).setCellFormula(shopSheet.getRow(38).getCell(3).getCellFormula());
				shopSheet.getRow(38).getCell(5).setCellFormula(shopSheet.getRow(38).getCell(5).getCellFormula());
				shopSheet.getRow(39).getCell(3).setCellFormula(shopSheet.getRow(39).getCell(3).getCellFormula());
				shopSheet.getRow(39).getCell(5).setCellFormula(shopSheet.getRow(39).getCell(5).getCellFormula());
				shopSheet.getRow(40).getCell(3).setCellFormula(shopSheet.getRow(40).getCell(3).getCellFormula());
				shopSheet.getRow(40).getCell(5).setCellFormula(shopSheet.getRow(40).getCell(5).getCellFormula());
				
				shopSheet.getRow(41).getCell(2).setCellFormula(shopSheet.getRow(41).getCell(2).getCellFormula());
				shopSheet.getRow(41).getCell(3).setCellFormula(shopSheet.getRow(41).getCell(3).getCellFormula());
				shopSheet.getRow(41).getCell(4).setCellFormula(shopSheet.getRow(41).getCell(4).getCellFormula());
				shopSheet.getRow(41).getCell(5).setCellFormula(shopSheet.getRow(41).getCell(5).getCellFormula());
				shopSheet.getRow(41).getCell(6).setCellFormula(shopSheet.getRow(41).getCell(6).getCellFormula());
				
				//太阳镜
				SetExcelCell(shopSheet.getRow(45), rsource.get(24));//200元以下
				SetExcelCell(shopSheet.getRow(46), rsource.get(25));//200-400元
				SetExcelCell(shopSheet.getRow(47), rsource.get(26));//400-600元
				SetExcelCell(shopSheet.getRow(48), rsource.get(27));//600元以上
				
				shopSheet.getRow(45).getCell(3).setCellFormula(shopSheet.getRow(45).getCell(3).getCellFormula());
				shopSheet.getRow(45).getCell(5).setCellFormula(shopSheet.getRow(45).getCell(5).getCellFormula());
				shopSheet.getRow(46).getCell(3).setCellFormula(shopSheet.getRow(46).getCell(3).getCellFormula());
				shopSheet.getRow(46).getCell(5).setCellFormula(shopSheet.getRow(46).getCell(5).getCellFormula());
				shopSheet.getRow(47).getCell(3).setCellFormula(shopSheet.getRow(47).getCell(3).getCellFormula());
				shopSheet.getRow(47).getCell(5).setCellFormula(shopSheet.getRow(47).getCell(5).getCellFormula());
				shopSheet.getRow(48).getCell(3).setCellFormula(shopSheet.getRow(48).getCell(3).getCellFormula());
				shopSheet.getRow(48).getCell(5).setCellFormula(shopSheet.getRow(48).getCell(5).getCellFormula());
				
				//----------
				shopSheet.getRow(49).getCell(2).setCellFormula(shopSheet.getRow(49).getCell(2).getCellFormula());
				shopSheet.getRow(49).getCell(3).setCellFormula(shopSheet.getRow(49).getCell(3).getCellFormula());
				shopSheet.getRow(49).getCell(4).setCellFormula(shopSheet.getRow(49).getCell(4).getCellFormula());
				shopSheet.getRow(49).getCell(5).setCellFormula(shopSheet.getRow(49).getCell(5).getCellFormula());
				shopSheet.getRow(49).getCell(6).setCellFormula(shopSheet.getRow(49).getCell(6).getCellFormula());
				
				//老花镜
				SetExcelCell(shopSheet.getRow(50), rsource.get(28));//60元以下
				SetExcelCell(shopSheet.getRow(51), rsource.get(29));//60元以上
				
				shopSheet.getRow(50).getCell(3).setCellFormula(shopSheet.getRow(50).getCell(3).getCellFormula());
				shopSheet.getRow(50).getCell(5).setCellFormula(shopSheet.getRow(50).getCell(5).getCellFormula());
				shopSheet.getRow(51).getCell(3).setCellFormula(shopSheet.getRow(51).getCell(3).getCellFormula());
				shopSheet.getRow(51).getCell(5).setCellFormula(shopSheet.getRow(51).getCell(5).getCellFormula());
				
				shopSheet.getRow(52).getCell(2).setCellFormula(shopSheet.getRow(52).getCell(2).getCellFormula());
				shopSheet.getRow(52).getCell(3).setCellFormula(shopSheet.getRow(52).getCell(3).getCellFormula());
				shopSheet.getRow(52).getCell(4).setCellFormula(shopSheet.getRow(52).getCell(4).getCellFormula());
				shopSheet.getRow(52).getCell(5).setCellFormula(shopSheet.getRow(52).getCell(5).getCellFormula());
				shopSheet.getRow(52).getCell(6).setCellFormula(shopSheet.getRow(52).getCell(6).getCellFormula());
				
				//其他
				SetExcelCell(shopSheet.getRow(54), rsource.get(30));
				
				shopSheet.getRow(54).getCell(3).setCellFormula(shopSheet.getRow(54).getCell(3).getCellFormula());
				shopSheet.getRow(54).getCell(5).setCellFormula(shopSheet.getRow(54).getCell(5).getCellFormula());
				
				shopSheet.getRow(55).getCell(2).setCellFormula(shopSheet.getRow(55).getCell(2).getCellFormula());
				shopSheet.getRow(55).getCell(3).setCellFormula(shopSheet.getRow(55).getCell(3).getCellFormula());
				shopSheet.getRow(55).getCell(4).setCellFormula(shopSheet.getRow(55).getCell(4).getCellFormula());
				shopSheet.getRow(55).getCell(5).setCellFormula(shopSheet.getRow(55).getCell(5).getCellFormula());
				shopSheet.getRow(55).getCell(6).setCellFormula(shopSheet.getRow(55).getCell(6).getCellFormula());
				
				//抛弃型
				SetExcelCell(shopSheet.getRow(59), rsource.get(31));
				SetExcelCell(shopSheet.getRow(60), rsource.get(32));
				SetExcelCell(shopSheet.getRow(61), rsource.get(33));
				
				shopSheet.getRow(59).getCell(3).setCellFormula(shopSheet.getRow(59).getCell(3).getCellFormula());
				shopSheet.getRow(59).getCell(5).setCellFormula(shopSheet.getRow(59).getCell(5).getCellFormula());
				shopSheet.getRow(60).getCell(3).setCellFormula(shopSheet.getRow(60).getCell(3).getCellFormula());
				shopSheet.getRow(60).getCell(5).setCellFormula(shopSheet.getRow(60).getCell(5).getCellFormula());
				shopSheet.getRow(61).getCell(3).setCellFormula(shopSheet.getRow(61).getCell(3).getCellFormula());
				shopSheet.getRow(61).getCell(5).setCellFormula(shopSheet.getRow(61).getCell(5).getCellFormula());
				
				shopSheet.getRow(62).getCell(2).setCellFormula(shopSheet.getRow(62).getCell(2).getCellFormula());
				shopSheet.getRow(62).getCell(3).setCellFormula(shopSheet.getRow(62).getCell(3).getCellFormula());
				shopSheet.getRow(62).getCell(4).setCellFormula(shopSheet.getRow(62).getCell(4).getCellFormula());
				shopSheet.getRow(62).getCell(5).setCellFormula(shopSheet.getRow(62).getCell(5).getCellFormula());
				shopSheet.getRow(62).getCell(6).setCellFormula(shopSheet.getRow(62).getCell(6).getCellFormula());
				
				//长戴型
				SetExcelCell(shopSheet.getRow(63), rsource.get(34));//400元以下
				SetExcelCell(shopSheet.getRow(64), rsource.get(35));//400元以上
				
				shopSheet.getRow(63).getCell(3).setCellFormula(shopSheet.getRow(63).getCell(3).getCellFormula());
				shopSheet.getRow(63).getCell(5).setCellFormula(shopSheet.getRow(63).getCell(5).getCellFormula());
				shopSheet.getRow(64).getCell(3).setCellFormula(shopSheet.getRow(64).getCell(3).getCellFormula());
				shopSheet.getRow(64).getCell(5).setCellFormula(shopSheet.getRow(64).getCell(5).getCellFormula());
				
				shopSheet.getRow(65).getCell(2).setCellFormula(shopSheet.getRow(65).getCell(2).getCellFormula());
				shopSheet.getRow(65).getCell(3).setCellFormula(shopSheet.getRow(65).getCell(3).getCellFormula());
				shopSheet.getRow(65).getCell(4).setCellFormula(shopSheet.getRow(65).getCell(4).getCellFormula());
				shopSheet.getRow(65).getCell(5).setCellFormula(shopSheet.getRow(65).getCell(5).getCellFormula());
				shopSheet.getRow(65).getCell(6).setCellFormula(shopSheet.getRow(65).getCell(6).getCellFormula());
				
				//RGP
				SetExcelCell(shopSheet.getRow(66), rsource.get(36));//2000元以下
				SetExcelCell(shopSheet.getRow(67), rsource.get(37));//2000元以上
				
				shopSheet.getRow(66).getCell(3).setCellFormula(shopSheet.getRow(66).getCell(3).getCellFormula());
				shopSheet.getRow(66).getCell(5).setCellFormula(shopSheet.getRow(66).getCell(5).getCellFormula());
				shopSheet.getRow(67).getCell(3).setCellFormula(shopSheet.getRow(67).getCell(3).getCellFormula());
				shopSheet.getRow(67).getCell(5).setCellFormula(shopSheet.getRow(67).getCell(5).getCellFormula());
				
				shopSheet.getRow(68).getCell(2).setCellFormula(shopSheet.getRow(68).getCell(2).getCellFormula());
				shopSheet.getRow(68).getCell(3).setCellFormula(shopSheet.getRow(68).getCell(3).getCellFormula());
				shopSheet.getRow(68).getCell(4).setCellFormula(shopSheet.getRow(68).getCell(4).getCellFormula());
				shopSheet.getRow(68).getCell(5).setCellFormula(shopSheet.getRow(68).getCell(5).getCellFormula());
				shopSheet.getRow(68).getCell(6).setCellFormula(shopSheet.getRow(68).getCell(6).getCellFormula());
				
				//软镜类护理产品
				
				shopSheet.getRow(69).getCell(3).setCellFormula(shopSheet.getRow(69).getCell(3).getCellFormula());
				shopSheet.getRow(69).getCell(5).setCellFormula(shopSheet.getRow(69).getCell(5).getCellFormula());
				shopSheet.getRow(70).getCell(3).setCellFormula(shopSheet.getRow(70).getCell(3).getCellFormula());
				shopSheet.getRow(70).getCell(5).setCellFormula(shopSheet.getRow(70).getCell(5).getCellFormula());
				shopSheet.getRow(71).getCell(3).setCellFormula(shopSheet.getRow(71).getCell(3).getCellFormula());
				shopSheet.getRow(71).getCell(5).setCellFormula(shopSheet.getRow(71).getCell(5).getCellFormula());
				
				shopSheet.getRow(72).getCell(2).setCellFormula(shopSheet.getRow(72).getCell(2).getCellFormula());
				shopSheet.getRow(72).getCell(3).setCellFormula(shopSheet.getRow(72).getCell(3).getCellFormula());
				shopSheet.getRow(72).getCell(4).setCellFormula(shopSheet.getRow(72).getCell(4).getCellFormula());
				shopSheet.getRow(72).getCell(5).setCellFormula(shopSheet.getRow(72).getCell(5).getCellFormula());
				shopSheet.getRow(72).getCell(6).setCellFormula(shopSheet.getRow(72).getCell(6).getCellFormula());
				
				//硬镜类护理产品
				
				shopSheet.getRow(73).getCell(3).setCellFormula(shopSheet.getRow(73).getCell(3).getCellFormula());
				shopSheet.getRow(73).getCell(5).setCellFormula(shopSheet.getRow(73).getCell(5).getCellFormula());
				shopSheet.getRow(74).getCell(3).setCellFormula(shopSheet.getRow(74).getCell(3).getCellFormula());
				shopSheet.getRow(74).getCell(5).setCellFormula(shopSheet.getRow(74).getCell(5).getCellFormula());
				shopSheet.getRow(75).getCell(3).setCellFormula(shopSheet.getRow(75).getCell(3).getCellFormula());
				shopSheet.getRow(75).getCell(5).setCellFormula(shopSheet.getRow(75).getCell(5).getCellFormula());
				shopSheet.getRow(76).getCell(3).setCellFormula(shopSheet.getRow(76).getCell(3).getCellFormula());
				shopSheet.getRow(76).getCell(5).setCellFormula(shopSheet.getRow(76).getCell(5).getCellFormula());
				
				shopSheet.getRow(77).getCell(2).setCellFormula(shopSheet.getRow(77).getCell(2).getCellFormula());
				shopSheet.getRow(77).getCell(3).setCellFormula(shopSheet.getRow(77).getCell(3).getCellFormula());
				shopSheet.getRow(77).getCell(4).setCellFormula(shopSheet.getRow(77).getCell(4).getCellFormula());
				shopSheet.getRow(77).getCell(5).setCellFormula(shopSheet.getRow(77).getCell(5).getCellFormula());
				shopSheet.getRow(77).getCell(6).setCellFormula(shopSheet.getRow(77).getCell(6).getCellFormula());
				
				shopSheet.getRow(78).getCell(2).setCellFormula(shopSheet.getRow(78).getCell(2).getCellFormula());
				shopSheet.getRow(78).getCell(3).setCellFormula(shopSheet.getRow(78).getCell(3).getCellFormula());
				shopSheet.getRow(78).getCell(4).setCellFormula(shopSheet.getRow(78).getCell(4).getCellFormula());
				shopSheet.getRow(78).getCell(5).setCellFormula(shopSheet.getRow(78).getCell(5).getCellFormula());
				shopSheet.getRow(78).getCell(6).setCellFormula(shopSheet.getRow(78).getCell(6).getCellFormula());
				//镜盒
				SetExcelCell(shopSheet.getRow(82), rsource.get(38));
				
				shopSheet.getRow(82).getCell(3).setCellFormula(shopSheet.getRow(82).getCell(3).getCellFormula());
				shopSheet.getRow(82).getCell(5).setCellFormula(shopSheet.getRow(82).getCell(5).getCellFormula());
				
								
				//镜布
				SetExcelCell(shopSheet.getRow(84), rsource.get(39));
				
				shopSheet.getRow(84).getCell(3).setCellFormula(shopSheet.getRow(84).getCell(3).getCellFormula());
				shopSheet.getRow(84).getCell(5).setCellFormula(shopSheet.getRow(84).getCell(5).getCellFormula());
				
				//镜链
				SetExcelCell(shopSheet.getRow(86), rsource.get(40));
				
				shopSheet.getRow(86).getCell(3).setCellFormula(shopSheet.getRow(86).getCell(3).getCellFormula());
				shopSheet.getRow(86).getCell(5).setCellFormula(shopSheet.getRow(86).getCell(5).getCellFormula());
				//其它
				SetExcelCell(shopSheet.getRow(88), rsource.get(41));
				
				

				shopSheet.getRow(88).getCell(3).setCellFormula(shopSheet.getRow(88).getCell(3).getCellFormula());
				shopSheet.getRow(88).getCell(5).setCellFormula(shopSheet.getRow(88).getCell(5).getCellFormula());

				shopSheet.getRow(90).getCell(2).setCellFormula(shopSheet.getRow(90).getCell(2).getCellFormula());
				shopSheet.getRow(90).getCell(3).setCellFormula(shopSheet.getRow(90).getCell(3).getCellFormula());
				shopSheet.getRow(90).getCell(4).setCellFormula(shopSheet.getRow(90).getCell(4).getCellFormula());
				shopSheet.getRow(90).getCell(5).setCellFormula(shopSheet.getRow(90).getCell(5).getCellFormula());
				shopSheet.getRow(90).getCell(6).setCellFormula(shopSheet.getRow(90).getCell(6).getCellFormula());
				
				shopSheet.getRow(3).getCell(7).setCellFormula(shopSheet.getRow(3).getCell(7).getCellFormula());
				shopSheet.getRow(3).getCell(8).setCellFormula(shopSheet.getRow(3).getCell(8).getCellFormula());
				shopSheet.getRow(3).getCell(9).setCellFormula(shopSheet.getRow(3).getCell(9).getCellFormula());
				shopSheet.getRow(3).getCell(10).setCellFormula(shopSheet.getRow(3).getCell(10).getCellFormula());
				shopSheet.getRow(3).getCell(11).setCellFormula(shopSheet.getRow(3).getCell(11).getCellFormula());
				shopSheet.getRow(3).getCell(12).setCellFormula(shopSheet.getRow(3).getCell(12).getCellFormula());
				shopSheet.getRow(3).getCell(13).setCellFormula(shopSheet.getRow(3).getCell(13).getCellFormula());
				shopSheet.getRow(3).getCell(14).setCellFormula(shopSheet.getRow(3).getCell(14).getCellFormula());
				shopSheet.getRow(3).getCell(15).setCellFormula(shopSheet.getRow(3).getCell(15).getCellFormula());
				shopSheet.getRow(3).getCell(16).setCellFormula(shopSheet.getRow(3).getCell(16).getCellFormula());
				
				shopSheet.getRow(4).getCell(7).setCellFormula(shopSheet.getRow(4).getCell(7).getCellFormula());
				shopSheet.getRow(4).getCell(8).setCellFormula(shopSheet.getRow(4).getCell(8).getCellFormula());
				shopSheet.getRow(4).getCell(9).setCellFormula(shopSheet.getRow(4).getCell(9).getCellFormula());
				shopSheet.getRow(4).getCell(10).setCellFormula(shopSheet.getRow(4).getCell(10).getCellFormula());
				shopSheet.getRow(4).getCell(11).setCellFormula(shopSheet.getRow(4).getCell(11).getCellFormula());
				shopSheet.getRow(4).getCell(12).setCellFormula(shopSheet.getRow(4).getCell(12).getCellFormula());
				shopSheet.getRow(4).getCell(13).setCellFormula(shopSheet.getRow(4).getCell(13).getCellFormula());
				shopSheet.getRow(4).getCell(14).setCellFormula(shopSheet.getRow(4).getCell(14).getCellFormula());
				shopSheet.getRow(4).getCell(15).setCellFormula(shopSheet.getRow(4).getCell(15).getCellFormula());
				shopSheet.getRow(4).getCell(16).setCellFormula(shopSheet.getRow(4).getCell(16).getCellFormula());
				
				shopSheet.getRow(18).getCell(7).setCellFormula(shopSheet.getRow(18).getCell(7).getCellFormula());
				shopSheet.getRow(18).getCell(8).setCellFormula(shopSheet.getRow(18).getCell(8).getCellFormula());
				shopSheet.getRow(18).getCell(9).setCellFormula(shopSheet.getRow(18).getCell(9).getCellFormula());
				shopSheet.getRow(18).getCell(10).setCellFormula(shopSheet.getRow(18).getCell(10).getCellFormula());
				shopSheet.getRow(18).getCell(11).setCellFormula(shopSheet.getRow(18).getCell(11).getCellFormula());
				shopSheet.getRow(18).getCell(12).setCellFormula(shopSheet.getRow(18).getCell(12).getCellFormula());
				shopSheet.getRow(18).getCell(13).setCellFormula(shopSheet.getRow(18).getCell(13).getCellFormula());
				shopSheet.getRow(18).getCell(14).setCellFormula(shopSheet.getRow(18).getCell(14).getCellFormula());
				shopSheet.getRow(18).getCell(15).setCellFormula(shopSheet.getRow(18).getCell(15).getCellFormula());
				shopSheet.getRow(18).getCell(16).setCellFormula(shopSheet.getRow(18).getCell(16).getCellFormula());
				
				shopSheet.getRow(19).getCell(7).setCellFormula(shopSheet.getRow(19).getCell(7).getCellFormula());
				shopSheet.getRow(19).getCell(8).setCellFormula(shopSheet.getRow(19).getCell(8).getCellFormula());
				shopSheet.getRow(19).getCell(9).setCellFormula(shopSheet.getRow(19).getCell(9).getCellFormula());
				shopSheet.getRow(19).getCell(10).setCellFormula(shopSheet.getRow(19).getCell(10).getCellFormula());
				shopSheet.getRow(19).getCell(11).setCellFormula(shopSheet.getRow(19).getCell(11).getCellFormula());
				shopSheet.getRow(19).getCell(12).setCellFormula(shopSheet.getRow(19).getCell(12).getCellFormula());
				shopSheet.getRow(19).getCell(13).setCellFormula(shopSheet.getRow(19).getCell(13).getCellFormula());
				shopSheet.getRow(19).getCell(14).setCellFormula(shopSheet.getRow(19).getCell(14).getCellFormula());
				shopSheet.getRow(19).getCell(15).setCellFormula(shopSheet.getRow(19).getCell(15).getCellFormula());
				shopSheet.getRow(19).getCell(16).setCellFormula(shopSheet.getRow(19).getCell(16).getCellFormula());
				

				shopSheet.getRow(44).getCell(8).setCellFormula(shopSheet.getRow(44).getCell(8).getCellFormula());
				shopSheet.getRow(44).getCell(9).setCellFormula(shopSheet.getRow(44).getCell(9).getCellFormula());
				shopSheet.getRow(44).getCell(10).setCellFormula(shopSheet.getRow(44).getCell(10).getCellFormula());
				shopSheet.getRow(44).getCell(11).setCellFormula(shopSheet.getRow(44).getCell(11).getCellFormula());
				shopSheet.getRow(44).getCell(14).setCellFormula(shopSheet.getRow(44).getCell(14).getCellFormula());
				shopSheet.getRow(44).getCell(15).setCellFormula(shopSheet.getRow(44).getCell(15).getCellFormula());
				shopSheet.getRow(44).getCell(16).setCellFormula(shopSheet.getRow(44).getCell(16).getCellFormula());
				shopSheet.getRow(44).getCell(17).setCellFormula(shopSheet.getRow(44).getCell(17).getCellFormula());
				
				
				shopSheet.getRow(45).getCell(8).setCellFormula(shopSheet.getRow(45).getCell(8).getCellFormula());
				shopSheet.getRow(45).getCell(9).setCellFormula(shopSheet.getRow(45).getCell(9).getCellFormula());
				shopSheet.getRow(45).getCell(10).setCellFormula(shopSheet.getRow(45).getCell(10).getCellFormula());
				shopSheet.getRow(45).getCell(11).setCellFormula(shopSheet.getRow(45).getCell(11).getCellFormula());
				shopSheet.getRow(45).getCell(14).setCellFormula(shopSheet.getRow(45).getCell(14).getCellFormula());
				shopSheet.getRow(45).getCell(15).setCellFormula(shopSheet.getRow(45).getCell(15).getCellFormula());
				shopSheet.getRow(45).getCell(16).setCellFormula(shopSheet.getRow(45).getCell(16).getCellFormula());
				shopSheet.getRow(45).getCell(17).setCellFormula(shopSheet.getRow(45).getCell(17).getCellFormula());
				
				shopSheet.getRow(58).getCell(7).setCellFormula(shopSheet.getRow(58).getCell(7).getCellFormula());
				shopSheet.getRow(58).getCell(8).setCellFormula(shopSheet.getRow(58).getCell(8).getCellFormula());
				shopSheet.getRow(58).getCell(9).setCellFormula(shopSheet.getRow(58).getCell(9).getCellFormula());
				shopSheet.getRow(58).getCell(10).setCellFormula(shopSheet.getRow(58).getCell(10).getCellFormula());
				shopSheet.getRow(58).getCell(11).setCellFormula(shopSheet.getRow(58).getCell(11).getCellFormula());
				shopSheet.getRow(58).getCell(14).setCellFormula(shopSheet.getRow(58).getCell(14).getCellFormula());
				shopSheet.getRow(58).getCell(15).setCellFormula(shopSheet.getRow(58).getCell(15).getCellFormula());
				shopSheet.getRow(58).getCell(16).setCellFormula(shopSheet.getRow(58).getCell(16).getCellFormula());
				shopSheet.getRow(58).getCell(17).setCellFormula(shopSheet.getRow(58).getCell(17).getCellFormula());
				shopSheet.getRow(58).getCell(18).setCellFormula(shopSheet.getRow(58).getCell(18).getCellFormula());
				
				shopSheet.getRow(59).getCell(7).setCellFormula(shopSheet.getRow(59).getCell(7).getCellFormula());
				shopSheet.getRow(59).getCell(8).setCellFormula(shopSheet.getRow(59).getCell(8).getCellFormula());
				shopSheet.getRow(59).getCell(9).setCellFormula(shopSheet.getRow(59).getCell(9).getCellFormula());
				shopSheet.getRow(59).getCell(10).setCellFormula(shopSheet.getRow(59).getCell(10).getCellFormula());
				shopSheet.getRow(59).getCell(11).setCellFormula(shopSheet.getRow(59).getCell(11).getCellFormula());
				shopSheet.getRow(59).getCell(14).setCellFormula(shopSheet.getRow(59).getCell(14).getCellFormula());
				shopSheet.getRow(59).getCell(15).setCellFormula(shopSheet.getRow(59).getCell(15).getCellFormula());
				shopSheet.getRow(59).getCell(16).setCellFormula(shopSheet.getRow(59).getCell(16).getCellFormula());
				shopSheet.getRow(59).getCell(17).setCellFormula(shopSheet.getRow(59).getCell(17).getCellFormula());
				shopSheet.getRow(59).getCell(18).setCellFormula(shopSheet.getRow(59).getCell(18).getCellFormula());
				
				shopSheet.getRow(94).getCell(0).setCellFormula(shopSheet.getRow(94).getCell(0).getCellFormula());
				shopSheet.getRow(94).getCell(1).setCellFormula(shopSheet.getRow(94).getCell(1).getCellFormula());
				shopSheet.getRow(94).getCell(2).setCellFormula(shopSheet.getRow(94).getCell(2).getCellFormula());
				shopSheet.getRow(94).getCell(3).setCellFormula(shopSheet.getRow(94).getCell(3).getCellFormula());
				shopSheet.getRow(94).getCell(4).setCellFormula(shopSheet.getRow(94).getCell(4).getCellFormula());
				
				shopSheet.getRow(94).getCell(6).setCellFormula(shopSheet.getRow(94).getCell(6).getCellFormula());
				shopSheet.getRow(94).getCell(7).setCellFormula(shopSheet.getRow(94).getCell(7).getCellFormula());
				shopSheet.getRow(94).getCell(8).setCellFormula(shopSheet.getRow(94).getCell(8).getCellFormula());
				shopSheet.getRow(94).getCell(9).setCellFormula(shopSheet.getRow(94).getCell(9).getCellFormula());
				shopSheet.getRow(94).getCell(10).setCellFormula(shopSheet.getRow(94).getCell(10).getCellFormula());
				
				shopSheet.getRow(95).getCell(0).setCellFormula(shopSheet.getRow(95).getCell(0).getCellFormula());
				shopSheet.getRow(95).getCell(1).setCellFormula(shopSheet.getRow(95).getCell(1).getCellFormula());
				shopSheet.getRow(95).getCell(2).setCellFormula(shopSheet.getRow(95).getCell(2).getCellFormula());
				shopSheet.getRow(95).getCell(3).setCellFormula(shopSheet.getRow(95).getCell(3).getCellFormula());
				shopSheet.getRow(95).getCell(4).setCellFormula(shopSheet.getRow(95).getCell(4).getCellFormula());
				
				shopSheet.getRow(95).getCell(6).setCellFormula(shopSheet.getRow(95).getCell(6).getCellFormula());
				shopSheet.getRow(95).getCell(7).setCellFormula(shopSheet.getRow(95).getCell(7).getCellFormula());
				shopSheet.getRow(95).getCell(8).setCellFormula(shopSheet.getRow(95).getCell(8).getCellFormula());
				shopSheet.getRow(95).getCell(9).setCellFormula(shopSheet.getRow(95).getCell(9).getCellFormula());
				shopSheet.getRow(95).getCell(10).setCellFormula(shopSheet.getRow(95).getCell(10).getCellFormula());
//				
				
				
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);

			return new ByteArrayInputStream(baos.toByteArray());
		} catch (IOException e) {
			System.out.println("商品销售分析表打开失败!");
			return null;
		}

	}

	private void SetExcelCell(HSSFRow row, Map rsource) {
//		HSSFCell c1 = row.getCell(2);
//		HSSFCell c4 = row.getCell(4);
//		HSSFCell c7 = row.getCell(6);
		row.createCell(2).setCellValue(Double.valueOf(rsource.get("number").toString()));
		row.createCell(4).setCellValue(Double.valueOf(rsource.get("CostsPrive").toString()));
		row.createCell(6).setCellValue(Double.valueOf(rsource.get("SalesValue").toString()));
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

	private void setFormula(HSSFRow row, int cell) {
		HSSFCell c1 = row.getCell(cell); // 金额
		c1.setCellFormula(c1.getCellFormula());
	}

	private void setFormulaDefinition(HSSFCell cell) {
		cell.setCellFormula(cell.getCellFormula());
	}
}
