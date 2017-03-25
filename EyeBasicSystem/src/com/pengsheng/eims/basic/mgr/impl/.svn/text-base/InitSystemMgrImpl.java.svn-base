package com.pengsheng.eims.basic.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

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
import com.pengsheng.eims.basic.mgr.InitSystemMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.PeriodBeginClearPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.tools.XLSXCovertCSVReader;

public class InitSystemMgrImpl implements InitSystemMgr {
	
	private UUIDHexGenerator uuidGenerator = UUIDHexGenerator.getInstance();//获取随机生成主键Id
    private InitSystemDao initSystemDao = null;
    private LogisticsLogDao logisticsLogDao = null;
    private SystemParameterDao systemParameterDao;
    private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	/**
	 * 导入商品库存
	 * 
	 * @param brandPo
	 */
	public void insertImportExcel(GoodsInfoPo goodsInfoPo,String sjtype,File[] upload, String filePath, String[] fFullName,String[] ContentType,SystemParameterPo spo,String filetemplet,LogisticsLogPo logPo){
			
		List<GoodsInfoPo> goodsInfoList = new ArrayList<GoodsInfoPo>();
	    System.out.println("开始上传期初库存的Excel文件至服务器！");	
		
		// 上传文件
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
		System.out.println("期初库存的Excel文件上传完成！");	

		File file = new File(filePath + File.separator + goodsInfoPo.getDocumentUrl());
		if (file.exists() && file.isFile()){
			
	        List<String[]> strList = null;
			try {
				System.out.println(filetemplet);
				FileInputStream is = new FileInputStream(filetemplet);
				XSSFWorkbook wbs = new XSSFWorkbook(is);
				OPCPackage p = OPCPackage.open(filePath + File.separator + goodsInfoPo.getDocumentUrl(), PackageAccess.READ);  
				
				for (int k = 0; k < 9; k++){
					
					// 如果隐形开启效期，则不能导入隐形和护理液
					if ((!Utility.getName(spo.getFspbarcodetype()).equals("3") && !Utility.getName(spo.getFspstealtheffective()).equals("0")) && (k == 3 || k == 4)){
					    System.out.println("--- 由于隐形开启效期，不能导入隐形和护理液 ---");
						continue;
					}
					
					System.out.println("--- 开始读取 " + wbs.getSheetName(k) +" 的数据，转化成cvs格式！---");
   
			        XLSXCovertCSVReader xlsx2csv = new XLSXCovertCSVReader(p, System.out,wbs.getSheetName(k),9); 
			        strList = xlsx2csv.process();  
			        			        
					System.out.println(wbs.getSheetName(k) +" 的数据已全部转化成cvs格式！---");
					
			        for (int i = 1; i < strList.size(); i++ ){  // i = 1 除去表头
						GoodsInfoPo po = new GoodsInfoPo();
		                po.setBgigoodsid(strList.get(i)[0].replace("\"", ""));    // 商品代码
						po.setBgibarcodeflag("0");   // 不使用批次
						po.setBgiwarehouseid(goodsInfoPo.getBgiwarehouseid());   // 仓位
						po.setBgigoodsbarcode(Utility.getName(po.getBgigoodsid()).replace(".","")+"00000000");   // 条码
						po.setBgiisexcelflag("1");
						
		                if (!Utility.getName(strList.get(i)[2]).replace("\"", "").equals("")){
		                	po.setBgigoodsquantity(strList.get(i)[2].replace("\"", ""));    // 库存数量
		                }else{
		                	po.setBgigoodsquantity("0");
		                	System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品的库存数量有异常，不能导入 ---");
		                }
		                
		                if (po.getBgigoodsquantity().equals("0")){
		                	System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品的库存数量为零，不能导入 ---");
		                	continue;
		                }

		                if (!po.getBgigoodsid().equals("") && initSystemDao.getGoodsCount(po) > 0 ){
						    goodsInfoList.add(po);
						    System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品信息已加入List里面 ---");
						}else{
							System.out.println("--- Sheet Number:" + k + " --- Goodsid:" + po.getBgigoodsid() + " 该商品不存在或已使用批号，不能导入 ---");
						}
			        }
				}	
				
				p.close();
				
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
		
		System.out.println("--- 开始向数据库中新增库存！---");
		if (sjtype.equals("2")){   // 重新导入数据
			initSystemDao.deleteStorageGoods_Log(Utility.getName(goodsInfoPo.getBgiwarehouseid()));   // 只删除excel导入的库存
			initSystemDao.deleteStorageGoods_Beginning(Utility.getName(goodsInfoPo.getBgiwarehouseid()));	
			initSystemDao.deleteStorageGoods_Change(Utility.getName(goodsInfoPo.getBgiwarehouseid()));	  // 只删除excel导入的库存
		}

		initSystemDao.insertStorageGoods_Log(goodsInfoList);
		initSystemDao.insertStorageGoods_Change(goodsInfoList);	
		
		initSystemDao.insertStorageGoods_Collect();
		System.out.println("--- 向数据库中新增库存完成！---");
		
		logPo.setsLogContent("期初库存的Excel文件导入完成!");
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

		//System.out.println("rsource : " + rsource.toString());
		c1.setCellValue(Utility.getName(rsource.getBgigoodsid()));
		c2.setCellValue(Utility.getName(rsource.getBgigoodsname()));
		c3.setCellType(Cell.CELL_TYPE_NUMERIC);
		c3.setCellValue(0);
		
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
	 * 导出商品信息
	 * 
	 * @param personInfoPo
	 */
	public InputStream insertExportExcel(GoodsInfoPo goodsInfoPo,String url,LogisticsLogPo logPo) throws Exception{
		setFileName(java.net.URLEncoder.encode("期初商品信息.xlsx", "UTF-8"));

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
			List<GoodsInfoPo> goodsInfoList = initSystemDao.selGoodsInfo(goodsInfoPo);
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

		logPo.setsLogContent("商品信息导出完成!");
		logisticsLogDao.insertLog(logPo);
		
		return new ByteArrayInputStream(baos.toByteArray());
	}
	
	/**
	 * 创建sheet: 
	 * @return
	 */
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
	
	/**
	 * 创建cell样式: 
	 * @return
	 */
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
	
    /**
	 * 查询需要打印条码的商品信息总数
	 * 
	 * @param brandPo
	 */
	public int getPrintGoodsBarCodeCount(GoodsInfoPo po){
		return initSystemDao.getPrintGoodsBarCodeCount(po);
	}
	
    /**
	 * 查询需要打印条码的商品信息
	 * 
	 * @param brandPo
	 */
	public List<GoodsInfoPo> getPrintGoodsBarCodeList(GoodsInfoPo po,int start,int size){
		return initSystemDao.getPrintGoodsBarCodeList(po,start,size);
	}
	
    /**
	 * 更新库存表，为已打印条码的商品打上标记
	 * 
	 * @param brandPo
	 */
	public void updatePrintGoodsBarCodeStatus(GoodsInfoPo po,LogisticsLogPo logPo){
		String[] barCodes = po.getBgigoodsbarcode().split(",");
		for (int i = 0; i < barCodes.length; i++){
			GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
			goodsInfoPo.setBgigoodsbarcode(Utility.getName(barCodes[i]));
			goodsInfoPo.setBgiwarehouseid(Utility.getName(po.getBgiwarehouseid()));
			
			initSystemDao.updatePrintGoodsBarCodeStatus(goodsInfoPo);
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
    /**
	 * 使用商品不含税成本更新加权平均成本
	 * 
	 * @param brandPo
	 */
	public void updateGoodsAvgCost(GoodsInfoPo po,LogisticsLogPo logPo){
		initSystemDao.updateGoodsAvgCost(po);		
		logisticsLogDao.insertLog(logPo);
	}
	
    /**
	 * 汇总财务期初成本
	 */
	public void insertGoodsAvgCost(String bgndate,String companyID,String departmentID,String cbPriceType,String cbjsType,LogisticsLogPo logPo){
		
		// 刷新期初成本和数量
		initSystemDao.insertGoodsAvgCost(bgndate,companyID,departmentID,cbPriceType,cbjsType);
	
		logisticsLogDao.insertLog(logPo);
	}
	
    /**
	 * 清除试用数据
	 */
	public void deletePeriodBeginData(PeriodBeginClearPo ppo,LogisticsLogPo logPo){
		
		//清空数据
		initSystemDao.deletePeriodBeginData(ppo);
		
		//新增 清空数据日志
		initSystemDao.insertPeriodBeginDataLog(ppo);
		
		//操作日志
		logisticsLogDao.insertLog(logPo);
	}
	
    /**
	 * 查看试用数据
	 */
	public List<PeriodBeginClearPo> selectPeriodBeginData(){
		return initSystemDao.selectPeriodBeginData();
	}
	
    /**
	 * 查询期初成本的总数
	 */
	public int getQccbCount(GoodsInfoPo po){
		return initSystemDao.getQccbCount(po);
	}
	
    /**
	 * 查询期初成本的列表
	 */
	public List<GoodsInfoPo> getQccbList(GoodsInfoPo po,int start,int size){
		return initSystemDao.getQccbList(po,start,size);
	}
	
    /**
	 * 查询商品的期初成本
	 */
	public GoodsInfoPo getQccbDetail(GoodsInfoPo po){
		return initSystemDao.getQccbDetail(po);
	}
	
    /**
	 * 修改商品的期初成本
	 */
	public void updateQccb(GoodsInfoPo po,LogisticsLogPo logPo){
		initSystemDao.updateQccb(po);
		
		logisticsLogDao.insertLog(logPo);
	}
	
    /**
	 * 查询已导入的总成本
	 */
	public GoodsInfoPo getQccbTotal(GoodsInfoPo po){
		return initSystemDao.getQccbTotal(po);
	}
	
    /**
	 * 根据公司ID查询部门的期初时间
	 */
	public String getQcDateByCompany(String companyID){
		return initSystemDao.getQcDateByCompany(companyID);
	}
	
	public InitSystemDao getInitSystemDao() {
		return initSystemDao;
	}
	public void setInitSystemDao(InitSystemDao initSystemDao) {
		this.initSystemDao = initSystemDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


}
