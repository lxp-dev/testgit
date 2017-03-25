/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTemplateMgrImpl.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import com.pengsheng.eims.basic.dao.InitSystemDao;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.dao.VoucherTemplateDao;
import com.pengsheng.eims.logistics.mgr.VoucherTemplateMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.persistence.SubjectPo;
import com.pengsheng.eims.logistics.persistence.VoucherTempletPo;
import com.pengsheng.eims.system.persistence.ExportAmountLogPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.tools.XLSXCovertCSVReader;

public class VoucherTemplateMgrImpl implements VoucherTemplateMgr {
	
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
	private VoucherTemplateDao voucherTemplateDao = null;
	private LogisticsLogDao logisticsLogDao;	
	private InitSystemDao initSystemDao;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public VoucherTemplateDao getVoucherTemplateDao() {
		return voucherTemplateDao;
	}

	public void setVoucherTemplateDao(VoucherTemplateDao voucherTemplateDao) {
		this.voucherTemplateDao = voucherTemplateDao;
	}

	/**
	 * 查询科目总数
	 */
	public int getSubjectCount(SubjectPo po){
		return voucherTemplateDao.getSubjectCount(po);
	}

	/**
	 * 查询科目列表
	 */
	public List<SubjectPo> getSubjectList(SubjectPo po,int start,int size){
		return voucherTemplateDao.getSubjectList(po,start,size);
	}
	
	/**
	 * 新增科目
	 */
	public void insertSubject(SubjectPo po,LogisticsLogPo lopo){
		voucherTemplateDao.insertSubject(po);
		logisticsLogDao.insertLog(lopo);
	}
	
	/**
	 * 批量新增科目
	 */
	public void insertSubjectBatch(SubjectPo po,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo){
		
		logPo.setsLogContent("科目文件开始上传!");
		logisticsLogDao.insertLog(logPo);
		
		List<SubjectPo> subjectList = new ArrayList<SubjectPo>();
		
		// 上传文件
		for (int i = 0; upload != null && i < upload.length; i++) {
			
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			
			po.setDocumentUrl(fileFullName);
			
			File dist = new File(filePath + "\\" + uuid);
			if (!dist.exists()) {
				dist.mkdir();
			}

			File dstFile = new File(filePath + "\\" + fileFullName);
			try {
				copy(fUpload, dstFile);
				logPo.setsLogContent("科目文件:" + fileFullName + "上传成功!");
			} catch (Exception e) {
				po.setDocumentUrl("");
				logPo.setsLogContent("科目文件:" + fileFullName + "上传失败!");
			}
		}
		
		logisticsLogDao.insertLog(logPo);
		
		File file = new File(filePath + File.separator + po.getDocumentUrl());
		if (file.exists() && file.isFile()){
			try {
				FileInputStream is = new FileInputStream(file);
				HSSFWorkbook wbs = new HSSFWorkbook(is);
				
				HSSFSheet childSheet = wbs.getSheetAt(0);    
				if (childSheet != null){
					for (int j = 1; j <= childSheet.getLastRowNum()+1; j++) {
						 HSSFRow row = childSheet.getRow(j);
						 if (null != row) {
							 SubjectPo tpo = new SubjectPo();							 							
							 
							 HSSFCell cell0 = row.getCell(0);   //科目代码
							 if (null != cell0 && !cell0.equals("")) {							
								 tpo.setsLssSubjectID(Utility.getName(cell0.getStringCellValue()));
							 }
							 HSSFCell cell2 = row.getCell(1);  //科目名称
							 if (null != cell2 && !cell2.equals("")) {
								 tpo.setsLssSubjectName(Utility.getName(String.valueOf(cell2.getStringCellValue())));
							 }
							 HSSFCell cell3 = row.getCell(2);  //所属科目类型ID
							 if (null != cell3 && !cell3.equals("")) {
								 tpo.setsLssParentID(Utility.getName(String.valueOf(cell3.getStringCellValue())));
							 }
							 
							 subjectList.add(tpo);
						 }
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		logPo.setsLogContent("科目文件加载完成!");
		logisticsLogDao.insertLog(logPo);
		
		Iterator<SubjectPo> it = subjectList.iterator();
		while (it.hasNext()){
			SubjectPo subjectPo = (SubjectPo)it.next();
			if (voucherTemplateDao.getSubjectByIdCount(subjectPo) == 0){
				voucherTemplateDao.insertSubject(subjectPo);
			}
			
		}	
		
		logPo.setsLogContent("科目文件导入完成!");
		logisticsLogDao.insertLog(logPo);
		
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
	 * 修改科目
	 */
	public void updateSubject(SubjectPo po,LogisticsLogPo lopo){
		voucherTemplateDao.updateSubject(po);
		logisticsLogDao.insertLog(lopo);
	}
	
	/**
	 * 删除科目
	 */
	public void deleteSubject(SubjectPo po,LogisticsLogPo lopo){
		voucherTemplateDao.deleteSubject(po);
		logisticsLogDao.insertLog(lopo);
	}
	
	/**
	 * 查询科目详情
	 */
	public SubjectPo getSubjectDetail(SubjectPo po){
		return voucherTemplateDao.getSubjectDetail(po);
	}
	
	/**
	 * 查询科目是否存在
	 */
	public int isExistsSubject(SubjectPo po){
		return voucherTemplateDao.isExistsSubject(po);
	}
	
	/**
	 * 查询科目是否存在(更新时)
	 */
	public int isExistsSubjectUpdate(SubjectPo po){
		return voucherTemplateDao.isExistsSubjectUpdate(po);
	}
	
    /**
	 * 导入期初商品金额
	 * 
	 * @param brandPo
	 */
	public void insertImportAmountExcel(GoodsInfoPo goodsInfoPo,String sjtype,String companyID,String departmentID,String date,SystemParameterPo spo,File[] upload, String filePath, String[] fFullName,String[] ContentType,String filetemplet,LogisticsLogPo logPo){
	
		List<GoodsInfoPo> goodsInfoList = new ArrayList<GoodsInfoPo>();
		System.out.println("开始上传期初成本的Excel文件至服务器！");	
		
		for (int i = 0; upload != null && i < upload.length; i++) {
			
			File fUpload = upload[i];

			String uuid = uuidGenerator.generate();
			String fileFullName = uuid + "\\" + fFullName[i];
			
			goodsInfoPo.setDocumentUrl(fileFullName);
			
			File dist = new File(filePath + "\\" + uuid);
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
		System.out.println("期初成本的Excel文件上传完成！");	

		File file = new File(filePath + File.separator + goodsInfoPo.getDocumentUrl());
		if (file.exists() && file.isFile()){

	        List<String[]> strList = null;
			try {

				FileInputStream is = new FileInputStream(filetemplet);
				XSSFWorkbook wbs = new XSSFWorkbook(is);
				OPCPackage p = OPCPackage.open(filePath + File.separator + goodsInfoPo.getDocumentUrl(), PackageAccess.READ);  
				
				for (int k = 0; k < 9; k++){

					System.out.println("--- 开始读取 " + wbs.getSheetName(k) +" 的数据，转化成cvs格式！---");
					   
			        XLSXCovertCSVReader xlsx2csv = new XLSXCovertCSVReader(p, System.out,wbs.getSheetName(k),9); 
			        strList = xlsx2csv.process();  
			        			        
					System.out.println(wbs.getSheetName(k) +" 的数据已全部转化成cvs格式！---");
									 
			        for (int i = 1; i < strList.size(); i++ ){  // i = 1 除去表头
						GoodsInfoPo po = new GoodsInfoPo();
						po.setBgiaverageflag(goodsInfoPo.getBgiaverageflag());   // 成本类型
		                po.setBgigoodsid(strList.get(i)[0].replace("\"", ""));    // 商品代码
		                
		                if (!Utility.getName(strList.get(i)[2]).replace("\"", "").equals("")){
		                	po.setBgigoodsquantity(strList.get(i)[2].replace("\"", ""));    // 库存数量
		                }else{
		                	po.setBgigoodsquantity("0");
		                	System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品的期初库存有异常，按零导入 ---");
		                }
		                
		                if (!Utility.getName(strList.get(i)[3]).replace("\"", "").equals("")){
		                	po.setBginottaxrate(strList.get(i)[3].replace("\"", ""));    // 商品成本
		                }else{
		                	po.setBginottaxrate("0.00");
		                	System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品的期初成本有异常，按零导入 ---");
		                }
		                
		                System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品信息已加入List里面 ---");
		                
		                goodsInfoList.add(po); 
			        }
				}			
				
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (OpenXML4JException e1) {
				e1.printStackTrace();
			} catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			} catch (SAXException e1) {
				e1.printStackTrace();
			}
			
		}
		
		System.out.println("--- 开始向数据库中新增期初成本！---");
		if (sjtype.equals("2")){   // 重新导入数据
			voucherTemplateDao.deleteInitGoodsAmount_Backup(companyID,departmentID);			
		}
				
		voucherTemplateDao.insertInitGoodsAmount_Backup(goodsInfoList,date,companyID,departmentID);		
		voucherTemplateDao.setNotTaxRateAmount_Backup(companyID,departmentID);    // 计算单位成本
		
		voucherTemplateDao.deleteInitGoodsAmount_CurrentMonth(companyID,departmentID);   // 删除公司下当月成本
		voucherTemplateDao.insertInitGoodsAmount_CurrentMonth(companyID,departmentID,goodsInfoPo.getBgiaverageflag());    // 重新导入公司下当月成本
		
		voucherTemplateDao.updateGoodsInoAvgAmount(companyID,Utility.getName(spo.getFspcbjstype()));
		
		System.out.println("--- 向数据库中新增期初成本完成！---");
		
		logPo.setsLogContent("期初成本的Excel文件导入完成!");
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 导出期初商品金额
	 * 
	 * @param personInfoPo
	 */
	public InputStream insertExportAmountExcel(GoodsInfoPo goodsInfoPo,String companyID,String departmentID,String date,String type,String pID,String url,String fname,LogisticsLogPo logPo) throws Exception{
		
		setFileName(java.net.URLEncoder.encode(fname, "UTF-8"));

		InputStream stream = new FileInputStream(url+"\\qc.xlsx");
		FileInputStream excel = (FileInputStream)stream;
		
		XSSFWorkbook workbook = new XSSFWorkbook(excel);    // 用于读取Excel2007
		XSSFCellStyle columnHeadStyle = createCellStyle(workbook);  //设置表头				
		XSSFCellStyle style = createCellStyle(workbook,columnHeadStyle); //设置普通单元格
		Sheet goodsSheet = null;
		
		SXSSFWorkbook wb = new SXSSFWorkbook(workbook,1000);
	
		int count = 1;
		for (int i = 1; i < 10; i++){
			goodsInfoPo.setBgigoodscategoryid(i+"");
			List<GoodsInfoPo> goodsInfoList = voucherTemplateDao.selGoodsInfo(goodsInfoPo,companyID,departmentID,date);
		    count = 1;
		    goodsSheet = wb.getSheetAt(i - 1);
			for(int j = 0; j < goodsInfoList.size(); j++){
				Row rows = goodsSheet.createRow(count++);
				rows.setHeightInPoints(20); 
				SetExcelCell(rows, goodsInfoList.get(j), i,style);
			}
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wb.write(baos);
		
		voucherTemplateDao.insertExportAmountLog(companyID, departmentID, date, type, pID);
		logisticsLogDao.insertLog(logPo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	private XSSFCellStyle createCellStyle(XSSFWorkbook workbook){
		
		XSSFFont headfont = workbook.createFont();
		headfont.setFontName("黑体");
		headfont.setFontHeightInPoints((short) 12);// 字体大小
		headfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 加粗			
		// 列头的样式
		XSSFCellStyle columnHeadStyle = workbook.createCellStyle();
		columnHeadStyle.setWrapText(true);	// 指定单元格自动换行
		columnHeadStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 左右居中
		columnHeadStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 上下居中
		columnHeadStyle.setLeftBorderColor(new XSSFColor(java.awt.Color.BLACK));// 左边框的颜色
		columnHeadStyle.setBorderLeft((short) 1);// 边框的大小
		columnHeadStyle.setRightBorderColor(new XSSFColor(java.awt.Color.BLACK));// 右边框的颜色
		columnHeadStyle.setBorderRight((short) 1);// 边框的大小
		columnHeadStyle.setTopBorderColor(new XSSFColor(java.awt.Color.BLACK));// 左边框的颜色
		columnHeadStyle.setBorderBottom((short) 1);// 边框的大小
		columnHeadStyle.setBottomBorderColor(new XSSFColor(java.awt.Color.BLACK)); // 设置单元格的边框颜色
		// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
		columnHeadStyle.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		columnHeadStyle.setFont(headfont);
  
		return columnHeadStyle;		
	}
	
	private XSSFCellStyle createCellStyle(XSSFWorkbook workbook,XSSFCellStyle columnHeadStyle){

		// 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）
		columnHeadStyle.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		XSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 10);
		// 普通单元格样式
		XSSFCellStyle style = workbook.createCellStyle();
		style.setWrapText(true);	// 指定单元格自动换行
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 上下居中
		style.setLeftBorderColor(new XSSFColor(java.awt.Color.BLACK));// 左边框的颜色
		style.setBorderLeft((short) 1);// 边框的大小
		style.setRightBorderColor(new XSSFColor(java.awt.Color.BLACK));// 右边框的颜色
		style.setBorderRight((short) 1);// 边框的大小
		style.setBorderBottom((short) 1);// 边框的大小
		style.setBottomBorderColor(new XSSFColor(java.awt.Color.BLACK)); // 设置单元格的边框颜色
		style.setFont(font);
  
		return style;		
	}
	
	private void SetExcelCell(Row row, GoodsInfoPo rsource,int i,XSSFCellStyle style) {
		
		String bigclass = "";
		String smallclass = "";
		
		Cell c1 = row.createCell(0);
		Cell c2 = row.createCell(1);
		Cell c3 = row.createCell(2);
		Cell c4 = row.createCell(3);
	    Cell c5 = row.createCell(4);
		Cell c6 = row.createCell(5);
		Cell c7 = row.createCell(6);
		Cell c8 = row.createCell(7);

		c1.setCellValue(Utility.getName(rsource.getBgigoodsid()));
		c2.setCellValue(Utility.getName(rsource.getBgigoodsname()));
		c3.setCellValue(Utility.getName(rsource.getBgigoodsquantity()));
		c4.setCellValue(0);
		
		c1.setCellStyle(style);
		c2.setCellStyle(style);
		c3.setCellStyle(style);
		c4.setCellStyle(style);	
		
		switch(i){
			case 2 :
			case 9 :
				c5.setCellValue(Utility.getName(rsource.getBgispec()));
				c6.setCellValue(Utility.getName(rsource.getBgicolor()));
				c7.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);	
				
				break;
			case 5 :
				c5.setCellValue(Utility.getName(rsource.getBgispec()));
				c6.setCellValue(Utility.getName(rsource.getBgicolor()));
				c7.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);	
				
				break;
			case 3 :
				c5.setCellValue(Utility.getName(rsource.getBgispec()));
				c6.setCellValue(Utility.getName(rsource.getBgisph()));
				c7.setCellValue(Utility.getName(rsource.getBgicyl()));
				c8.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);
				c8.setCellStyle(style);
				
				break;
			case 4 :
				c5.setCellValue(Utility.getName(rsource.getBgisph()));
				c6.setCellValue(Utility.getName(rsource.getBgicyl()));
				c7.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);
			
				break;
			case 1 :
			case 6 :
				c5.setCellValue(Utility.getName(rsource.getBgispec()));
				c6.setCellValue(Utility.getName(rsource.getBgicolor()));
				c7.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);
				
				break;						
			case 8 :
				c5.setCellValue(Utility.getName(rsource.getBgispec()));
				c6.setCellValue(Utility.getName(rsource.getBgisph()));
				c7.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);
				
				break;
			default:
				
				bigclass = Utility.getName(rsource.getBgiothergoodsbigclass()).equalsIgnoreCase("Q") ? "其它材料" : "低值易耗品";
				
				if (Utility.getName(rsource.getBgiothergoodsbigclass()).equalsIgnoreCase("Q")){
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("001")){
						smallclass = "办公用品";
					}
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("002")){
						smallclass = "印刷品";
					}
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("003")){
						smallclass = "眼镜用具";
					}
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("004")){
						smallclass = "其它";
					}
				}
				
				if (Utility.getName(rsource.getBgiothergoodsbigclass()).equalsIgnoreCase("D")){
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("001")){
						smallclass = "加工工具";
					}
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("002")){
						smallclass = "办公工具";
					}
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("003")){
						smallclass = "验配工具";
					}
					
					if (Utility.getName(rsource.getBgiothergoodssmallclass()).equals("004")){
						smallclass = "其它";
					}
				}
				
				c5.setCellValue(Utility.getName(rsource.getBgispec()));
				c6.setCellValue(bigclass);
				c7.setCellValue(smallclass);
				c8.setCellValue(Utility.getName(rsource.getBgiretailprice()));
				
				c5.setCellStyle(style);
				c6.setCellStyle(style);
				c7.setCellStyle(style);
				c8.setCellStyle(style);
		}
	}
	
	/**
	 * 获取物流系统期初商品数量和金额
	 */
	public GoodsInfoPo getGoodsSumAndAmount(){
        return voucherTemplateDao.getGoodsSumAndAmount();		
	}
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectTree(String nodeId,String hrefTarget,String href){
		//System.out.println(nodeId+"@@@@"+hrefTarget+"###"+href);
		return voucherTemplateDao.getSubjectTree(nodeId,hrefTarget,href);
	}
	
	/**
	 * 新增凭证模板
	 */
	public void insertVoucherTemplet(VoucherTempletPo po,List<VoucherTempletPo> tlist,LogisticsLogPo logPo){
		
		voucherTemplateDao.deleteVoucherTemplet(po);
		for (VoucherTempletPo tpo : tlist){
			voucherTemplateDao.insertVoucherTemplet(tpo);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询凭证模板
	 */
	public List<VoucherTempletPo> getVoucherTempletDetail(VoucherTempletPo po){
		return voucherTemplateDao.getVoucherTempletDetail(po);
	}
	
	/**
	 * 查询树形科目
	 */
	public List<FuctionTreeNode> getSubjectOpenTree(String nodeId,String hrefTarget,String href){
		return voucherTemplateDao.getSubjectOpenTree(nodeId,hrefTarget,href);
	}
	
	/**
	 * 查询期初成本导出日志
	 */
	public List<ExportAmountLogPo> getExportAmountLog(String companyID){
		return voucherTemplateDao.getExportAmountLog(companyID);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public InitSystemDao getInitSystemDao() {
		return initSystemDao;
	}

	public void setInitSystemDao(InitSystemDao initSystemDao) {
		this.initSystemDao = initSystemDao;
	}	

	
}
