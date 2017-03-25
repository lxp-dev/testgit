package com.pengsheng.eims.basic.mgr.impl;

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
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.basic.dao.GlassesFinishDao;
import com.pengsheng.eims.basic.dao.GlassesFrameDao;
import com.pengsheng.eims.basic.dao.GlassesFrameManyDao;
import com.pengsheng.eims.basic.dao.PresbyopicGlassesDao;
import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.GlassesFrameManyMgr;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoManyPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

/**
 * 镜架mgr 实现类
 */
public class GlassesFrameManyMgrImpl implements GlassesFrameManyMgr {
	private LogisticsLogDao logisticsLogDao;
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	private GlassesFrameManyDao glassesFrameManyDao; 
	private GlassesFrameDao glassesFrameDao;
	private GlassesFinishDao glassesFinishDao;
	private PresbyopicGlassesDao presbyopicGlassesDao;
	
	public List<GoodsInfoManyPo> insertImportGlassesFrameManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
		List<GoodsInfoManyPo> goodsInfoList = new ArrayList<GoodsInfoManyPo>();
		
		File dist = null;
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			
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
				
				sheetnum = 0+"";
				HSSFSheet childSheet = wbs.getSheetAt(0);
				GoodsInfoManyPo po = null;
				for (int j = 1; j <= childSheet.getLastRowNum()+1; j++) {
					 rownum = j+"";
					 HSSFRow row = childSheet.getRow(j);
					 if (null != row) {
						 po = new GoodsInfoManyPo();
						 
						 HSSFCell cell0 = row.getCell(0);   //厂家型号
						 HSSFCell cell1 = row.getCell(1);   //型号
						 HSSFCell cell2 = row.getCell(2);   //厂家色号
						 HSSFCell cell3 = row.getCell(3);   //色号
						 HSSFCell cell4 = row.getCell(4);   //材质
						 HSSFCell cell5 = row.getCell(5);   //颜色
						 HSSFCell cell6 = row.getCell(6);   //款式
						 HSSFCell cell7 = row.getCell(7);   //尺寸
						 HSSFCell cell8 = row.getCell(8);   //工艺类型
						 HSSFCell cell9 = row.getCell(9);   //含税单价
						 HSSFCell cell10 = row.getCell(10); //标准零售价
						 HSSFCell cell11 = row.getCell(11); //批发价格
						 
						 String specandcolorckstr = "^[A-Za-z0-9]+$";
						 String intckstr = "^\\+?[1-9][0-9]*$";
						 String floatckstr = "^([1-9]\\d*(\\.\\d+)?|0)$";
						 boolean addPo = false;//是否是空行，如果一行中，任何一个单元格不为null，addPo设置为true
						 
						 if(cell0 != null){
							 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell0 == null || cell0.getStringCellValue().length() > 20 || cell0.getStringCellValue().trim().length() == 0){
								 po.setBgisupplierspecck("1");
							 }else{
								 po.setBgisupplierspecck("0");
							 }
							 po.setBgisupplierspec(cell0.getStringCellValue());
							 if(cell0.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }							 
						 }else{
							 po.setBgisupplierspecck("1");
						 }
						 
						 if(cell1 != null){
							 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell1 == null || cell1.getStringCellValue().length() > 9 || !Utility.getName(cell1.getStringCellValue()).matches(specandcolorckstr)){
								 po.setBgispecck("1");
							 }else{
								 po.setBgispecck("0");
							 }
							 po.setBgispec(cell1.getStringCellValue());
							 if(cell1.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgispecck("1");
						 }
						 
						 if(cell2 != null){
							 cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell2 == null || cell2.getStringCellValue().length() > 20){
								 po.setBgisuppliercolorck("1");
							 }else{
								 po.setBgisuppliercolorck("0");
							 }
							 po.setBgisuppliercolor(cell2.getStringCellValue());
							 if(cell2.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgisuppliercolorck("1");
						 }
						 
						 if(cell3 != null){
							 cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell3 == null || cell3.getStringCellValue().length() > 4 || !cell3.getStringCellValue().matches(specandcolorckstr)){
								 po.setBgicolorck("1");
							 }else{
								 po.setBgicolorck("0");
							 }
							 po.setBgicolor(cell3.getStringCellValue());
							 if(cell3.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgicolorck("1");
						 }
						 
						 GoodsInfoPo gpo = new GoodsInfoPo();
						 if(cell4 != null){
							 gpo.setBgiframematerialtypename(cell4.getStringCellValue());
//							 int framematerialcount = glassesFrameManyDao.getIsFrameMaterialCount(gpo);
							 int framematerialcount = 0;
							 cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell4.getStringCellValue().length() > 20 || framematerialcount < 1)  && !"".equals(Utility.getName(cell4.getStringCellValue()))){
								 po.setBgiframematerialtypeck("1");
							 }else{
								 po.setBgiframematerialtypeck("0");
							 }
							 po.setBgiframematerialtype(cell4.getStringCellValue());
							 if(cell4.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframematerialtypeck("0");
						 }
						 
						 if(cell5 != null){
							 gpo.setBgichinesecolorname(cell5.getStringCellValue());
//							 int chinesecolorcount = glassesFrameManyDao.getIsColorCount(gpo);
							 int chinesecolorcount = 0;
							 cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell5.getStringCellValue().length() > 20 || chinesecolorcount < 1) && !"".equals(Utility.getName(cell5.getStringCellValue()))){
								 po.setBgichinesecolorck("1");
							 }else{
								 po.setBgichinesecolorck("0");
							 }
							 po.setBgichinesecolor(cell5.getStringCellValue());
							 if(cell5.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgichinesecolorck("0");
						 }
						 
						 if(cell6 != null){
							 gpo.setBgiframestylename(cell6.getStringCellValue());
//							 int framestylecount = glassesFrameManyDao.getIsFrameStyleCount(gpo);
							 int framestylecount = 0;
							 cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell6.getStringCellValue().length() > 20 || framestylecount < 1) && !"".equals(Utility.getName(cell6.getStringCellValue()))){
								 po.setBgiframestyleck("1");
							 }else{
								 po.setBgiframestyleck("0");
							 }
							 po.setBgiframestyle(cell6.getStringCellValue());
							 if(cell6.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframestyleck("0");
						 }
						 
						 if(cell7 != null){
							 cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell7 != null && !cell7.getStringCellValue().matches(intckstr)) && !"".equals(Utility.getName(cell7.getStringCellValue()))){
								 po.setBgiframesizeck("0");
							 }else{
								 po.setBgiframesizeck("0");
							 }
							 po.setBgiframesize(cell7.getStringCellValue());
							 if(cell7.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframesizeck("0");
						 }
						 
						 if(cell8 != null){
							 gpo.setBgiframeprocesscrafttype(cell8.getStringCellValue());
//							 int teachnologytypecount = glassesFrameManyDao.getisTeachnologyTypeCount(gpo);
							 int teachnologytypecount = 0;
							 cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell8.getStringCellValue().length() > 20 || teachnologytypecount < 1) && !"".equals(Utility.getName(cell8.getStringCellValue()))){
								 po.setBgiframeprocesscrafttypeck("1");
							 }else{
								 po.setBgiframeprocesscrafttypeck("0");
							 }
							 po.setBgiframeprocesscrafttype(cell8.getStringCellValue());
							 if(cell8.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframeprocesscrafttypeck("0");
						 }
						 
						 if(cell9 != null){
							 cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell9 == null || !cell9.getStringCellValue().matches(floatckstr)){
								 po.setBgicostpriceck("1");
							 }else{
								 po.setBgicostpriceck("0");
							 }
							 po.setBgicostprice(cell9.getStringCellValue());
							 if(cell9.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgicostpriceck("1");
						 }
						 
						 if(cell10 != null){
							 cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell10 == null || !cell10.getStringCellValue().matches(floatckstr)){
								 po.setBgiretailpriceck("1");
							 }else{
								 po.setBgiretailpriceck("0");
							 }
							 po.setBgiretailprice(cell10.getStringCellValue());
							 if(cell10.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiretailpriceck("1");
						 }
						 
						 if(cell11 != null){
							 cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell11 == null || !cell11.getStringCellValue().matches(floatckstr)){
								 po.setBgiwholesalepriceck("1");
							 }else{
								 po.setBgiwholesalepriceck("0");
							 }
							 po.setBgiwholesaleprice(cell11.getStringCellValue());
							 if(cell11.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiwholesalepriceck("1");
						 }
						 
						 if(addPo){
							 goodsInfoList.add(po);
						 }					 
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
	
	public List<GoodsInfoManyPo> insertImportGlassesFinishManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
		List<GoodsInfoManyPo> goodsInfoList = new ArrayList<GoodsInfoManyPo>();
		
		File dist = null;
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			
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
				
				for (int j = 1; j <= childSheet.getLastRowNum()+1; j++) {
					 rownum = j+"";
					 HSSFRow row = childSheet.getRow(j);
					 if (null != row) {
						 GoodsInfoManyPo po = new GoodsInfoManyPo();
						 
						 HSSFCell cell0 = row.getCell(0);   //厂家型号
						 HSSFCell cell1 = row.getCell(1);   //型号
						 HSSFCell cell2 = row.getCell(2);   //厂家色号
						 HSSFCell cell3 = row.getCell(3);   //色号
						 HSSFCell cell4 = row.getCell(4);   //材质
						 HSSFCell cell5 = row.getCell(5);   //颜色
						 HSSFCell cell6 = row.getCell(6);   //款式
						 HSSFCell cell7 = row.getCell(7);   //尺寸
						 HSSFCell cell8 = row.getCell(8);   //工艺类型
						 HSSFCell cell9 = row.getCell(9);   //含税单价
						 HSSFCell cell10 = row.getCell(10); //标准零售价
						 HSSFCell cell11 = row.getCell(11); //批发价格
						 
						 String specandcolorckstr = "^[A-Za-z0-9]+$";
						 String intckstr = "^\\+?[1-9][0-9]*$";
						 String floatckstr = "^([1-9]\\d*(\\.\\d+)?|0)$";
						 boolean addPo = false;//是否是空行，如果一行中，任何一个单元格不为null，addPo设置为true
						 
						 if(cell0 != null){
							 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell0 == null || cell0.getStringCellValue().length() > 20 || cell0.getStringCellValue().trim().length() == 0){
								 po.setBgisupplierspecck("1");
							 }else{
								 po.setBgisupplierspecck("0");
							 }
							 po.setBgisupplierspec(cell0.getStringCellValue());
							 if(cell0.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }	
						 }else{
							 po.setBgisupplierspecck("1");
						 }
						 
						 if(cell1 != null){
							 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell1 == null || cell1.getStringCellValue().length() > 9 || !Utility.getName(cell1.getStringCellValue()).matches(specandcolorckstr)){
								 po.setBgispecck("1");
							 }else{
								 po.setBgispecck("0");
							 }
							 po.setBgispec(cell1.getStringCellValue());
							 if(cell1.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgispecck("1");
						 }
						 
						 if(cell2 != null){
							 cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell2 == null || cell2.getStringCellValue().length() > 20){
								 po.setBgisuppliercolorck("1");
							 }else{
								 po.setBgisuppliercolorck("0");
							 }
							 po.setBgisuppliercolor(cell2.getStringCellValue());
							 if(cell2.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgisuppliercolorck("1");
						 }
						 
						 if(cell3 != null){
							 cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell3 == null || cell3.getStringCellValue().length() > 4 || !cell3.getStringCellValue().matches(specandcolorckstr)){
								 po.setBgicolorck("1");
							 }else{
								 po.setBgicolorck("0");
							 }
							 po.setBgicolor(cell3.getStringCellValue());
							 if(cell3.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgicolorck("1");
						 }
						 
						 GoodsInfoPo gpo = new GoodsInfoPo();
						 if(cell4 != null){
							 gpo.setBgiframematerialtypename(cell4.getStringCellValue());
//							 int framematerialcount = glassesFrameManyDao.getIsFrameMaterialCount(gpo);
							 int framematerialcount = 0;
							 cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell4.getStringCellValue().length() > 20 || framematerialcount < 1) && !"".equals(Utility.getName(cell4.getStringCellValue()))){
								 po.setBgiframematerialtypeck("1");
							 }else{
								 po.setBgiframematerialtypeck("0");
							 }
							 po.setBgiframematerialtype(cell4.getStringCellValue());
							 if(cell4.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframematerialtypeck("1");
						 }
						 
						 if(cell5 != null){
							 gpo.setBgichinesecolorname(cell5.getStringCellValue());
//							 int chinesecolorcount = glassesFrameManyDao.getIsColorCount(gpo);
							 int chinesecolorcount = 0;
							 cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell5.getStringCellValue().length() > 20 || chinesecolorcount < 1) && !"".equals(Utility.getName(cell5.getStringCellValue()))){
								 po.setBgichinesecolorck("1");
							 }else{
								 po.setBgichinesecolorck("0");
							 }
							 po.setBgichinesecolor(cell5.getStringCellValue());
							 if(cell5.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgichinesecolorck("0");
						 }
						 
						 if(cell6 != null){
							 gpo.setBgiframestylename(cell6.getStringCellValue());
//							 int framestylecount = glassesFrameManyDao.getIsFrameStyleCount(gpo);
							 int framestylecount = 0;
							 cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell6.getStringCellValue().length() > 20 || framestylecount < 1) && !"".equals(Utility.getName(cell6.getStringCellValue()))){
								 po.setBgiframestyleck("1");
							 }else{
								 po.setBgiframestyleck("0");
							 }
							 po.setBgiframestyle(cell6.getStringCellValue());
							 if(cell6.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }		
						 }else{
							 po.setBgiframestyleck("0");
						 }
						 
						 if(cell7 != null){
							 cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell7 != null && !cell7.getStringCellValue().matches(intckstr)) && !"".equals(Utility.getName(cell7.getStringCellValue()))){
								 po.setBgiframesizeck("0");
							 }else{
								 po.setBgiframesizeck("0");
							 }
							 po.setBgiframesize(cell7.getStringCellValue());
							 if(cell7.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }							 
						 }else{
							 po.setBgiframesizeck("0");
						 }
						 
						 if(cell8 != null){
							 gpo.setBgiframeprocesscrafttype(cell8.getStringCellValue());
//							 int teachnologytypecount = glassesFrameManyDao.getisTeachnologyTypeCount(gpo);
							 int teachnologytypecount = 0;
							 cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell8.getStringCellValue().length() > 20 || teachnologytypecount < 1) && !"".equals(Utility.getName(cell8.getStringCellValue()))){
								 po.setBgiframeprocesscrafttypeck("1");
							 }else{
								 po.setBgiframeprocesscrafttypeck("0");
							 }
							 po.setBgiframeprocesscrafttype(cell8.getStringCellValue());
							 if(cell8.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }							 
						 }else{
							 po.setBgiframeprocesscrafttypeck("0");
						 }
						 
						 if(cell9 != null){
							 cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell9 == null || !cell9.getStringCellValue().matches(floatckstr)){
								 po.setBgicostpriceck("1");
							 }else{
								 po.setBgicostpriceck("0");
							 }
							 po.setBgicostprice(cell9.getStringCellValue());
							 if(cell9.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgicostpriceck("1");
						 }
						 
						 if(cell10 != null){
							 cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell10 == null || !cell10.getStringCellValue().matches(floatckstr)){
								 po.setBgiretailpriceck("1");
							 }else{
								 po.setBgiretailpriceck("0");
							 }
							 po.setBgiretailprice(cell10.getStringCellValue());
							 if(cell10.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiretailpriceck("1");
						 }
						 
						 if(cell11 != null){
							 cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell11 == null || !cell11.getStringCellValue().matches(floatckstr)){
								 po.setBgiwholesalepriceck("1");
							 }else{
								 po.setBgiwholesalepriceck("0");
							 }
							 po.setBgiwholesaleprice(cell11.getStringCellValue());
							 if(cell11.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiwholesalepriceck("1");
						 }
						 
						 if(addPo){
							 goodsInfoList.add(po);
						 }
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
	
	public List<GoodsInfoManyPo> insertImportGlassesPresbyopicManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
		List<GoodsInfoManyPo> goodsInfoList = new ArrayList<GoodsInfoManyPo>();
		
		File dist = null;
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			
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
				
//				HSSFCellStyle columnHeadStyle = createCellStyle(wbs);  //设置表头
//				HSSFCellStyle styleSum = createCellStyle(wbs,columnHeadStyle); //设置数量单元格
				
				sheetnum = 0+"";
				HSSFSheet childSheet = wbs.getSheetAt(0);
				
				for (int j = 1; j <= childSheet.getLastRowNum()+1; j++) {
					 rownum = j+"";
					 HSSFRow row = childSheet.getRow(j);
					 if (null != row) {
						 GoodsInfoManyPo po = new GoodsInfoManyPo();
						 
						 HSSFCell cell0 = row.getCell(0);   //厂家型号
						 HSSFCell cell1 = row.getCell(1);   //型号
						 HSSFCell cell2 = row.getCell(2);   //厂家色号
						 HSSFCell cell3 = row.getCell(3);   //色号
						 HSSFCell cell4 = row.getCell(4);   //材质
						 HSSFCell cell5 = row.getCell(5);   //颜色
						 HSSFCell cell6 = row.getCell(6);   //款式
						 HSSFCell cell7 = row.getCell(7);   //尺寸
						 HSSFCell cell8 = row.getCell(8);   //
						 HSSFCell cell9 = row.getCell(9);   //含税单价
						 HSSFCell cell10 = row.getCell(10); //标准零售价
						 HSSFCell cell11 = row.getCell(11); //批发价格
						 
						 String specandcolorckstr = "^[A-Za-z0-9]+$";
						 String intckstr = "^\\+?[1-9][0-9]*$";
						 String floatckstr = "^([1-9]\\d*(\\.\\d+)?|0)$";
						 boolean addPo = false;//是否是空行，如果一行中，任何一个单元格不为null，addPo设置为true
						 
						 if(cell0 != null){
							 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell0 == null || cell0.getStringCellValue().length() > 20 || cell0.getStringCellValue().trim().length() == 0){
								 po.setBgisupplierspecck("1");
							 }else{
								 po.setBgisupplierspecck("0");
							 }
							 po.setBgisupplierspec(cell0.getStringCellValue());
							 if(cell0.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }	
						 }else{
							 po.setBgisupplierspecck("1");
						 }
						 
						 if(cell1 != null){
							 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell1 == null || cell1.getStringCellValue().length() > 9 || !Utility.getName(cell1.getStringCellValue()).matches(specandcolorckstr)){
								 po.setBgispecck("1");
							 }else{
								 po.setBgispecck("0");
							 }
							 po.setBgispec(cell1.getStringCellValue());
							 if(cell1.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgispecck("1");
						 }
						 
						 if(cell2 != null){
							 cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell2 == null || cell2.getStringCellValue().length() > 20){
								 po.setBgisuppliercolorck("1");
							 }else{
								 po.setBgisuppliercolorck("0");
							 }
							 po.setBgisuppliercolor(cell2.getStringCellValue());
							 if(cell2.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgisuppliercolorck("1");
						 }
						 
						 if(cell3 != null){
							 cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell3 == null || "".equals(Utility.getName(cell3.getStringCellValue())) ? true : Double.parseDouble(Utility.getName(cell3.getStringCellValue())) % 0.25 != 0 || "".equals(Utility.getName(cell3.getStringCellValue())) ? true : Double.parseDouble(Utility.getName(cell3.getStringCellValue())) < 0 || "".equals(Utility.getName(cell3.getStringCellValue())) ? true : Double.parseDouble(Utility.getName(cell3.getStringCellValue())) > 20){
								 po.setBgicolorck("1");
							 }else{
								 po.setBgicolorck("0");
							 }
							 po.setBgicolor(cell3.getStringCellValue());
							 if(cell3.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgicolorck("1");
						 }
						 
						 GoodsInfoPo gpo = new GoodsInfoPo();
						 if(cell4 != null){    // 材质
							 gpo.setBgiframematerialtypename(cell4.getStringCellValue());
//							 int framematerialcount = glassesFrameManyDao.getIsFrameMaterialCount(gpo);
							 int framematerialcount = 0;
							 cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell4.getStringCellValue().length() > 20 || framematerialcount < 1)  && !"".equals(Utility.getName(cell4.getStringCellValue()))){
								 po.setBgiframematerialtypeck("1");
							 }else{
								 po.setBgiframematerialtypeck("0");
							 }
							 po.setBgiframematerialtype(cell4.getStringCellValue());
							 if(cell4.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframematerialtypeck("0");
						 }
						 
						 if(cell5 != null){    // 颜色
							 gpo.setBgichinesecolorname(cell5.getStringCellValue());
//							 int chinesecolorcount = glassesFrameManyDao.getIsColorCount(gpo);
							 int chinesecolorcount = 0;
							 cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell5.getStringCellValue().length() > 20 || chinesecolorcount < 1) && !"".equals(Utility.getName(cell5.getStringCellValue()))){
								 po.setBgichinesecolorck("1");
							 }else{
								 po.setBgichinesecolorck("0");
							 }
							 po.setBgichinesecolor(cell5.getStringCellValue());
							 if(cell5.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgichinesecolorck("0");
						 }
						 
						 if(cell6 != null){    // 款式
							 gpo.setBgiframestylename(cell6.getStringCellValue());
//							 int framestylecount = glassesFrameManyDao.getIsFrameStyleCount(gpo);
							 int framestylecount = 0;
							 cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if((cell6.getStringCellValue().length() > 20 || framestylecount < 1) && !"".equals(Utility.getName(cell6.getStringCellValue()))){
								 po.setBgiframestyleck("1");
							 }else{
								 po.setBgiframestyleck("0");
							 }
							 po.setBgiframestyle(cell6.getStringCellValue());
							 if(cell6.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }	
						 }else{
							 po.setBgiframestyleck("0");
						 }
						 
						 if(cell7 != null){    // 尺寸
							 cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell7 != null && !cell7.getStringCellValue().matches(intckstr) && !"".equals(Utility.getName(cell7.getStringCellValue()))){
								 po.setBgiframesizeck("0");
							 }else{
								 po.setBgiframesizeck("0");
							 }
							 po.setBgiframesize(cell7.getStringCellValue());
							 if(cell7.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiframesizeck("0");
						 }
						 
						 if(cell9 != null){
							 cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell9 == null || !cell9.getStringCellValue().matches(floatckstr)){
								 po.setBgicostpriceck("1");
							 }else{
								 po.setBgicostpriceck("0");
							 }
							 po.setBgicostprice(cell9.getStringCellValue());
							 if(cell9.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgicostpriceck("1");
						 }
						 
						 if(cell10 != null){
							 cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell10 == null || !cell10.getStringCellValue().matches(floatckstr)){
								 po.setBgiretailpriceck("1");
							 }else{
								 po.setBgiretailpriceck("0");
							 }
							 po.setBgiretailprice(cell10.getStringCellValue());
							 if(cell10.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiretailpriceck("1");
						 }
						 
						 if(cell11 != null){
							 cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
							 if(cell11 == null || !cell11.getStringCellValue().matches(floatckstr)){
								 po.setBgiwholesalepriceck("1");
							 }else{
								 po.setBgiwholesalepriceck("0");
							 }
							 po.setBgiwholesaleprice(cell11.getStringCellValue());
							 if(cell11.getStringCellValue().trim().length() != 0){
								 addPo = true;
							 }
						 }else{
							 po.setBgiwholesalepriceck("1");
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
	
	// 自己封装的一个把源文件对象复制成目标文件对象
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
	
	/**
	 * 创建sheet: 
	 * @return
	 */
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
	
	/**
	 * 创建cell样式: 
	 * @return
	 */
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
	
	/**
	 * 批量新增镜架
	 * @param po 商品po
	 */	
	public void insertGlassesManyFrame(List<GoodsInfoPo> po,LogisticsLogPo logPo) {
		for(int i=0; i<po.size(); i++){
//			System.out.println("i=="+i);
			glassesFrameDao.insertGlassesFrame(po.get(i));
		}
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 批量新增镜架
	 * @param po 商品po
	 */	
	public void insertGlassesPresbyopicFrame(List<GoodsInfoPo> po,LogisticsLogPo logPo) {
		for(int i=0; i<po.size(); i++){
			presbyopicGlassesDao.insertPresbyopicGlasses(po.get(i));
		}
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 批量新增镜架
	 * @param po 商品po
	 */	
	public void insertGlassesFinishFrame(List<GoodsInfoPo> po,LogisticsLogPo logPo) {
		for(int i=0; i<po.size(); i++){
			glassesFinishDao.insertGlassesFinish(po.get(i));
		}
		logisticsLogDao.insertLog(logPo);
	}

	public List<ColorPo> getColorList() {
		return glassesFrameManyDao.getColorList();
	}

	public List<FrameMaterialPo> getFrameMaterialList() {
		return glassesFrameManyDao.getFrameMaterialList();
	}

	public List<TechnologyTypePo> getTeachnologyTypeList() {
		return glassesFrameManyDao.getTeachnologyTypeList();
	}
	
	public List<OptionParamPo> getFrameStyleList(String str){
		return glassesFrameManyDao.getFrameStyleList(str);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public GlassesFrameManyDao getGlassesFrameManyDao() {
		return glassesFrameManyDao;
	}

	public void setGlassesFrameManyDao(GlassesFrameManyDao glassesFrameManyDao) {
		this.glassesFrameManyDao = glassesFrameManyDao;
	}

	public GlassesFrameDao getGlassesFrameDao() {
		return glassesFrameDao;
	}

	public void setGlassesFrameDao(GlassesFrameDao glassesFrameDao) {
		this.glassesFrameDao = glassesFrameDao;
	}

	public GlassesFinishDao getGlassesFinishDao() {
		return glassesFinishDao;
	}

	public void setGlassesFinishDao(GlassesFinishDao glassesFinishDao) {
		this.glassesFinishDao = glassesFinishDao;
	}

	public PresbyopicGlassesDao getPresbyopicGlassesDao() {
		return presbyopicGlassesDao;
	}

	public void setPresbyopicGlassesDao(PresbyopicGlassesDao presbyopicGlassesDao) {
		this.presbyopicGlassesDao = presbyopicGlassesDao;
	}
	
}
