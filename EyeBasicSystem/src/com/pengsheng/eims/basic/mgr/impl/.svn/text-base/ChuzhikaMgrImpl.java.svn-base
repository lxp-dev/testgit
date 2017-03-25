package com.pengsheng.eims.basic.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.basic.dao.ChuzhikaDao;
import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaLogPo;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class ChuzhikaMgrImpl implements ChuzhikaMgr {
	
	private ChuzhikaDao chuzhikaDao; 
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteChuzhika(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo) {
		chuzhikaDao.deleteChuzhika(chuzhikaPo);
		chuzhikaDao.deleteChuzhikaLog(chuzhikaPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void insertChuzhika(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo) {
		
		String uuid = UUIDHexGenerator.getInstance().generate();
		chuzhikaPo.setCstczkid(uuid);
		chuzhikaDao.insertChuzhika(chuzhikaPo);
		
		ChuzhikaLogPo chuzhikaLogPo = new ChuzhikaLogPo();
		chuzhikaLogPo.setSmeascustomerid(chuzhikaPo.getCstczkcustomerid());
		chuzhikaLogPo.setSmeaschuzhikaid(uuid);
		chuzhikaLogPo.setSmeasshifu(chuzhikaPo.getCstczkshifujine());
		chuzhikaLogPo.setSmeaszengsong(chuzhikaPo.getCstczkzengsongjine());
		chuzhikaLogPo.setSmeasyintegral("0.00");
		chuzhikaLogPo.setSmeascintegral(chuzhikaPo.getCstczkjine());
		chuzhikaLogPo.setSmeasxintegral(chuzhikaPo.getCstczkjine());
		chuzhikaLogPo.setSmeasdopersonid(chuzhikaPo.getCstczkcreatepersonid());
		chuzhikaLogPo.setSmeasaddorsub("0");
		
		chuzhikaDao.insertChuZhiKaLogInformation(chuzhikaLogPo);
		
		logisticsLogDao.insertLog(logPo);
	}

	public void insertBatchChuzhika(List<ChuzhikaPo> chuzhikaList,LogisticsLogPo logPo) {

		for (ChuzhikaPo chuzhikaPo : chuzhikaList){
			String uuid = UUIDHexGenerator.getInstance().generate();
			chuzhikaPo.setCstczkid(uuid);
			chuzhikaDao.insertChuzhika(chuzhikaPo);
			
			ChuzhikaLogPo chuzhikaLogPo = new ChuzhikaLogPo();
			chuzhikaLogPo.setSmeascustomerid(chuzhikaPo.getCstczkcustomerid());
			chuzhikaLogPo.setSmeaschuzhikaid(uuid);
			chuzhikaLogPo.setSmeasshifu(chuzhikaPo.getCstczkshifujine());
			chuzhikaLogPo.setSmeaszengsong(chuzhikaPo.getCstczkzengsongjine());
			chuzhikaLogPo.setSmeasyintegral("0.00");
			chuzhikaLogPo.setSmeascintegral(chuzhikaPo.getCstczkjine());
			chuzhikaLogPo.setSmeasxintegral(chuzhikaPo.getCstczkjine());
			chuzhikaLogPo.setSmeasdopersonid(chuzhikaPo.getCstczkcreatepersonid());
			chuzhikaLogPo.setSmeasaddorsub("0");
			chuzhikaDao.insertChuZhiKaLogInformation(chuzhikaLogPo);
		}
		
		logisticsLogDao.insertLog(logPo);
	}

	
	public void updateChuzhika(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo) {
		chuzhikaDao.updateChuzhika(chuzhikaPo);		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新储值卡充值
	 * @param chuzhikaPo
	 */
	public void updateChuzhikaChongzhi(ChuzhikaLogPo chuzhikaLogPo,LogisticsLogPo logPo){
		chuzhikaDao.insertChuZhiKaLogInformation(chuzhikaLogPo);
		
		ChuzhikaPo chuzhikaPo = new ChuzhikaPo();
		chuzhikaPo.setCstczkid(chuzhikaLogPo.getSmeaschuzhikaid());
		chuzhikaDao.updateChuzhikaChongzhi(chuzhikaPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	public void updateChuzhikaIsShowHide(ChuzhikaPo chuzhikaPo,LogisticsLogPo logPo){
		chuzhikaDao.updateChuzhikaIsShowHide(chuzhikaPo);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 导出储值ID
	 * @param vipCardPo
	 */
	public InputStream insertExportExcel(ChuzhikaPo chuzhikaPo) throws Exception {
		
		try{
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			int count = 1;
			
			HSSFSheet goodsSheet = createSheet(workbook);				
			HSSFCellStyle columnHeadStyle = createCellStyle(workbook);  //设置表头
			HSSFCellStyle style = createCellStyle(workbook,columnHeadStyle); //设置普通单元格
			
			// 创建行 表头
			HSSFRow row = goodsSheet.createRow((short) 0);			
            row.setHeightInPoints(20);

            HSSFCell headerCell0 = null;
			headerCell0 = row.createCell(0);
			headerCell0.setCellValue("储值卡号");
			headerCell0.setCellStyle(columnHeadStyle);
			headerCell0.setCellType(HSSFCell.CELL_TYPE_STRING);
						
			List<ChuzhikaPo> chuzhikaList = chuzhikaDao.selectChuzhikas(chuzhikaPo);
		    Iterator<ChuzhikaPo> iterator = chuzhikaList.iterator();				
			
		    HSSFDataFormat format = workbook.createDataFormat();
		    style.setDataFormat(format.getFormat("@"));
		    
			while (iterator.hasNext()) {
				
				ChuzhikaPo po = (ChuzhikaPo) iterator.next();

				HSSFRow rows = goodsSheet.createRow(count++);
				rows.setHeightInPoints(20);

				headerCell0 = rows.createCell(0);
				headerCell0.setCellValue(Utility.getName(po.getCstczkcardid()));
				headerCell0.setCellStyle(style);
				headerCell0.setCellType(HSSFCell.CELL_TYPE_STRING);  //定义单元格类型为字符串类型
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			
			return new ByteArrayInputStream(baos.toByteArray());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 创建sheet样式: 设置列宽
	 * @return
	 */
	private HSSFSheet createSheet(HSSFWorkbook workbook){
	
		HSSFSheet sheet = workbook.createSheet("储值卡");
		
		sheet.setColumnWidth(0, 4000);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 4000);
		sheet.setColumnWidth(4, 4000);
  
		return sheet;		
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
		columnHeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
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
		// style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM); // 设置单元格的边框为粗体
		style.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色
		style.setFont(font);
  
		return style;		
	}
	
	/**
	 * 取得充值记录
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaLogPo> selectChuzhikaLogs(String cardUUID){
		return chuzhikaDao.selectChuzhikaLogs(cardUUID);
	}
	
	/**
	 * 微信--取得会员绑定储值卡余额积分
	 * @param chuzhikaPo
	 * @return
	 */
	public ChuzhikaPo selectChuzhikaJifenByCustomerID(String customerID){
		return chuzhikaDao.selectChuzhikaJifenByCustomerID(customerID);
	}
	
	/**
	 * 微信--取得会员绑定储值卡增减记录
	 * @param chuzhikaPo
	 * @return
	 */
	public List<ChuzhikaLogPo> selectChuzhikaLogsByCustomerID(String cardUUID){
		return chuzhikaDao.selectChuzhikaLogsByCustomerID(cardUUID);
	}

	/**
	 * 批量新增储值卡时，判断哪些储值卡号已经被使用
	 * @param cardString
	 * @return
	 */
	public List<ChuzhikaPo> getChuzhikaListIsExist(String cardString){
		return chuzhikaDao.getChuzhikaListIsExist(cardString);
	}
	
	/**
	 * 批量删除储值卡
	 * @param cardString
	 * @return
	 */
	public void deleteChuzhikaBatch(String cardString,LogisticsLogPo logPo){
		chuzhikaDao.deleteChuzhikaBatch(cardString);
		logisticsLogDao.insertLog(logPo);
	}
	
	
	public ChuzhikaPo selectChuzhika(ChuzhikaPo chuzhikaPo){
		return chuzhikaDao.selectChuzhika(chuzhikaPo);
	}
	
	public ChuzhikaDao getChuzhikaDao() {
		return chuzhikaDao;
	}
	
	public void setChuzhikaDao(ChuzhikaDao chuzhikaDao) {
		this.chuzhikaDao = chuzhikaDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public void insertChuZhiKaLogInformation(ChuzhikaLogPo po){
		this.chuzhikaDao.insertChuZhiKaLogInformation(po);
	}
	
	/**
	 * 查询储值卡是否已经存在Count
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectChuzhikCount(String cardID){
		return this.chuzhikaDao.selectChuzhikCount(cardID);
	}
	
	/**
	 * 查询会员是否已经绑定了储值卡
	 * @param chuzhikaPo
	 * @return
	 */
	public int selectCustomerCzkCount(String id,String customerID){
		return this.chuzhikaDao.selectCustomerCzkCount(id,customerID);
	}
	
	public int selectChuzhikasCount(ChuzhikaPo chuzhikaPo){
		return chuzhikaDao.selectChuzhikasCount(chuzhikaPo);
	}
	
	public List<ChuzhikaPo> selectChuzhikas(ChuzhikaPo chuzhikaPo, int start, int size) {
		return chuzhikaDao.selectChuzhikas(chuzhikaPo, start, size);
	}
	
	/**
	 * 批量停用启用储值卡
	 */
	public void updateChuzhikaEnableBatch(ChuzhikaPo cpo,LogisticsLogPo logPo){
		chuzhikaDao.updateChuzhikaEnableBatch(cpo);
		logisticsLogDao.insertLog(logPo);
	}
	
}
