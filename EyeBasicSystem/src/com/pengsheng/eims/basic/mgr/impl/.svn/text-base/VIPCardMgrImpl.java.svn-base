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

import com.pengsheng.eims.basic.dao.VIPCardDao;
import com.pengsheng.eims.basic.mgr.VIPCardMgr;
import com.pengsheng.eims.basic.persistence.VIPCardDetailsPo;
import com.pengsheng.eims.basic.persistence.VIPCardPo;
import com.pengsheng.eims.basic.persistence.VIPGoodsBindPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.util.tools.Utility;

public class VIPCardMgrImpl implements VIPCardMgr{
	private VIPCardDao vipCardDao; 
	private LogisticsLogDao logisticsLogDao;
	
	public void deleteVIPCardPo(VIPCardPo vipCardPo,LogisticsLogPo logPo) {
		vipCardDao.deleteVIPCardPo(vipCardPo);
		vipCardDao.deleteVIPCardBindGoodsType(vipCardPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void insertVIPCardPo(VIPCardPo vipCardPo,VIPCardDetailsPo vipCardDetailsPo,List<VIPGoodsBindPo> vlist,LogisticsLogPo logPo) {
		vipCardDao.insertVIPCardPo(vipCardPo);
		
		if (vipCardDetailsPo != null){
			for(int i=0; i<vipCardDetailsPo.getSsevcdgoodslevels().length; i++){
				VIPCardDetailsPo idpo = new VIPCardDetailsPo();
				idpo.setSsevcdvipcardid(vipCardPo.getSsevcid());
				idpo.setSsevcdgoodslevel(vipCardDetailsPo.getSsevcdgoodslevels()[i]);
				idpo.setSsevcddiscount(vipCardDetailsPo.getSsevcddiscounts()[i]);
				vipCardDao.insertVIPCardDetails(idpo);
			}
		}
		
		if (vlist != null && vlist.size() > 0){
			for(VIPGoodsBindPo vpo : vlist){
				vipCardDao.insertVIPCardBindGoodsType(vpo);
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void insertBatchVIPCard(List<VIPCardPo> vipCardList,VIPCardDetailsPo vipCardDetailsPo,List<VIPGoodsBindPo> vlist,LogisticsLogPo logPo){
		
		for (VIPCardPo vipCardPo : vipCardList){
			vipCardDao.insertVIPCardPo(vipCardPo);
			
			if (vipCardDetailsPo != null){
				for(int i=0; i<vipCardDetailsPo.getSsevcdgoodslevels().length; i++){
					VIPCardDetailsPo idpo = new VIPCardDetailsPo();
					idpo.setSsevcdvipcardid(vipCardPo.getSsevcid());
					idpo.setSsevcdgoodslevel(vipCardDetailsPo.getSsevcdgoodslevels()[i]);
					idpo.setSsevcddiscount(vipCardDetailsPo.getSsevcddiscounts()[i]);
					vipCardDao.insertVIPCardDetails(idpo);
				}
			}
			
			if (vlist != null && vlist.size() > 0){
				for(int j = 0; j < vlist.size(); j++){
					vlist.get(j).setSsevbVipcardID(Utility.getName(vipCardPo.getSsevcid()));
					vipCardDao.insertVIPCardBindGoodsType(vlist.get(j));
				}
			}

		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	public int selectVIPCardCount(VIPCardPo vipCardPo) {
		return vipCardDao.selectVIPCardCount(vipCardPo);
	}

	public List<VIPCardPo> selectVIPCardList(VIPCardPo vipCardPo, int start,
			int size) {
		return vipCardDao.selectVIPCardList(vipCardPo, start, size);
	}

	public VIPCardPo selectVIPCardPo(VIPCardPo vipCardPo) {
		return vipCardDao.selectVIPCardPo(vipCardPo);
	}
	
	public VIPCardPo selectVIPCardDetail(VIPCardPo vipCardPo){
		return vipCardDao.selectVIPCardDetail(vipCardPo);
	}

	public void updateVIPCardPo(VIPCardPo vipCardPo,VIPCardDetailsPo vipCardDetailsPo,List<VIPGoodsBindPo> vlist,LogisticsLogPo logPo) {
		
		vipCardDao.updateVIPCardPo(vipCardPo);
		
		vipCardDao.deleteVIPCardBindGoodsType(vipCardPo);
		
		if(!"".equals(Utility.getName(vipCardPo.getIschangecard()))){
			vipCardDao.updateVIPCardID(vipCardPo);
		}
		
		vipCardDao.deleteVIPCardDetails(vipCardPo.getSsevcid());
		
		if(vipCardDetailsPo!=null){
			for(int i=0; i<vipCardDetailsPo.getSsevcdgoodslevels().length; i++){
				VIPCardDetailsPo idpo = new VIPCardDetailsPo();
				idpo.setSsevcdvipcardid(vipCardPo.getSsevcid());
				idpo.setSsevcdgoodslevel(vipCardDetailsPo.getSsevcdgoodslevels()[i]);
				idpo.setSsevcddiscount(vipCardDetailsPo.getSsevcddiscounts()[i]);
				vipCardDao.insertVIPCardDetails(idpo);
			}
		}	
		
		if (vlist != null && vlist.size() > 0){
			for(VIPGoodsBindPo vpo : vlist){
				vipCardDao.insertVIPCardBindGoodsType(vpo);
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public VIPCardDao getVipCardDao() {
		return vipCardDao;
	}

	public void setVipCardDao(VIPCardDao vipCardDao) {
		this.vipCardDao = vipCardDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public void updateVIPCardID(VIPCardPo vipCardPo,LogisticsLogPo logPo){
		vipCardDao.updateVIPCardID(vipCardPo);
		vipCardDao.updateVIPCardIDBindGoodsType(vipCardPo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 导出VIP卡ID
	 * @param vipCardPo
	 */
	public InputStream insertExportExcel(VIPCardPo vipCardPo) throws Exception {
		
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
			headerCell0.setCellValue("打折卡号");
			headerCell0.setCellStyle(columnHeadStyle);
			headerCell0.setCellType(HSSFCell.CELL_TYPE_STRING);
			
			HSSFCell headerCell1 = null;
			headerCell1 = row.createCell(1);
			headerCell1.setCellValue("折扣");
			headerCell1.setCellStyle(columnHeadStyle);
			headerCell1.setCellType(HSSFCell.CELL_TYPE_STRING);
			
			HSSFCell headerCell2 = null;
			headerCell2 = row.createCell(2);
			headerCell2.setCellValue("有效期");
			headerCell2.setCellStyle(columnHeadStyle);
			headerCell2.setCellType(HSSFCell.CELL_TYPE_STRING);
			
			HSSFCell headerCell3 = null;
			headerCell3 = row.createCell(3);
			headerCell3.setCellValue("使用次数");
			headerCell3.setCellStyle(columnHeadStyle);
			headerCell3.setCellType(HSSFCell.CELL_TYPE_STRING);
						
			List<VIPCardPo> vipCardList = vipCardDao.selectVIPCardList(vipCardPo);
		    Iterator<VIPCardPo> iterator = vipCardList.iterator();				
			
		    HSSFDataFormat format = workbook.createDataFormat();
		    style.setDataFormat(format.getFormat("@"));
		    
			while (iterator.hasNext()) {
				
				VIPCardPo po = (VIPCardPo) iterator.next();

				HSSFRow rows = goodsSheet.createRow(count++);
				rows.setHeightInPoints(20);

				headerCell0 = rows.createCell(0);
				headerCell0.setCellValue(Utility.getName(po.getSsevcid()));
				headerCell0.setCellStyle(style);
				headerCell0.setCellType(HSSFCell.CELL_TYPE_STRING);  //定义单元格类型为字符串类型
				
				headerCell1 = rows.createCell(1);
				headerCell1.setCellValue(Utility.getName(po.getSsevcdiscount()));
				headerCell1.setCellStyle(style);
				headerCell1.setCellType(HSSFCell.CELL_TYPE_STRING);  //定义单元格类型为字符串类型
				
				headerCell2 = rows.createCell(2);
				headerCell2.setCellValue(Utility.getName(po.getSsevcdowntime())+"-"+Utility.getName(po.getSsevcuptime()));
				headerCell2.setCellStyle(style);
				headerCell2.setCellType(HSSFCell.CELL_TYPE_STRING);  //定义单元格类型为字符串类型
				
				headerCell3 = rows.createCell(3);
				headerCell3.setCellValue(Utility.getName(po.getSsevcusecount()));
				headerCell3.setCellStyle(style);
				headerCell3.setCellType(HSSFCell.CELL_TYPE_STRING);  //定义单元格类型为字符串类型
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
	
		HSSFSheet sheet = workbook.createSheet("打折卡");
		
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
	
	public void insertVIPCardDetails(VIPCardDetailsPo po){
		vipCardDao.insertVIPCardDetails(po);
	}
	
	public List<VIPCardDetailsPo> selectVIPCardDetails(VIPCardDetailsPo po){
		return vipCardDao.selectVIPCardDetails(po);
	}
	
	public List<VIPGoodsBindPo> selectVIPCardBindGoodsType(VIPCardPo vipCardPo){
		return vipCardDao.selectVIPCardBindGoodsType(vipCardPo);
	}
	
	public void deleteVIPCardDetails(String pid){
		vipCardDao.deleteVIPCardDetails(pid);
	}
}
