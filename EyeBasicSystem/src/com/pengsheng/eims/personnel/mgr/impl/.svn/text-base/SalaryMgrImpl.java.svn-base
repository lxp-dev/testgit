package com.pengsheng.eims.personnel.mgr.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.MPersonInfoDao;
import com.pengsheng.eims.personnel.dao.SalaryDao;
import com.pengsheng.eims.personnel.mgr.MPersonInfoMgr;
import com.pengsheng.eims.personnel.mgr.SalaryMgr;
import com.pengsheng.eims.personnel.persistence.SalaryPo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class SalaryMgrImpl implements SalaryMgr
{
	private SalaryDao salaryDao;
	private LogisticsLogDao logisticsLogDao;
	private List<PersonDepartmentsPo> personDepartments;
	private MPersonInfoDao mpersonInfoDao;
	
	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}
	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}

	public MPersonInfoDao getMpersonInfoDao() {
		return mpersonInfoDao;
	}
	public void setMpersonInfoDao(MPersonInfoDao mpersonInfoDao) {
		this.mpersonInfoDao = mpersonInfoDao;
	}
	public SalaryDao getSalaryDao() {
		return salaryDao;
	}
	public void setSalaryDao(
			SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	/**
	 * 查询所有员工薪酬(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalaryPo> getSalarys(SalaryPo po,int start, int size)
	{
		return salaryDao.getSalarys(po, start, size);
	}
	/**
	 * 查询所有员工薪酬总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSalaryCount(SalaryPo po)
	{
		return salaryDao.getSalaryCount(po);
	}
	
	/**
	 * 新增员工工资
	 */
	public void insertSalaryPo(SalaryPo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);	
		salaryDao.insertSalaryPo(po);
	}
	/**
	 * 更新员工工资
	 * 
	 * @param personInfoPo
	 */
	public void updateSalaryPo(SalaryPo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);
		salaryDao.updateSalaryPo(po);		
	}
	
	/**
	 * 删除员工工资
	 * 
	 * @param 
	 */
	public void deleteSalaryPo(SalaryPo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);
		salaryDao.deleteSalaryPo(po);
	}

	/**
	 * 得到员工工资模版
	 * @return
	 */
	public SalaryPo selectCompensationTemplatePo(String id)
	{
		return salaryDao.selectCompensationTemplatePo(id);
	}
	
	/**
	 * 得到员工工资
	 * @return
	 */
	public SalaryPo selectSalaryPo(String id)
	{
		return salaryDao.selectSalaryPo(id);
	}
	
	/**
	 * 判断员工工资是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getSalaryRepeat(SalaryPo po)
	{
		return salaryDao.getSalaryRepeat(po);
	}
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public PersonInfoPo getPersonByid(String id ) 
	{
		return salaryDao.getPersonByid(id ); 
	}
	
	/**
	 * 导出人员编号
	 * 
	 * @param personInfoPo
	 */
	public InputStream bulidSalaryExcel(SalaryPo salaryPo) throws Exception {

		try{
			
			HSSFWorkbook workbook = new HSSFWorkbook();	
			// 在Excel工作簿中建一工作表		
			HSSFSheet personInfoSheet = workbook.createSheet("工资表");
			// 设置列宽
			personInfoSheet.setColumnWidth(0, 3000);
			personInfoSheet.setColumnWidth(1, 3000);
			personInfoSheet.setColumnWidth(2, 2000);
			personInfoSheet.setColumnWidth(3, 2000);
			personInfoSheet.setColumnWidth(4, 3000);
			
			personInfoSheet.setColumnWidth(5, 3000);
			personInfoSheet.setColumnWidth(6, 4000);
			personInfoSheet.setColumnWidth(7, 6000);
			personInfoSheet.setColumnWidth(8, 3000);
			personInfoSheet.setColumnWidth(9, 6000);
			personInfoSheet.setColumnWidth(10, 6000);
			personInfoSheet.setColumnWidth(11, 6000);
			personInfoSheet.setColumnWidth(12, 6000);
			personInfoSheet.setColumnWidth(13, 6000);
			personInfoSheet.setColumnWidth(14, 6000);
			personInfoSheet.setColumnWidth(15, 6000);
			personInfoSheet.setColumnWidth(16, 6000);
			
			
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

			// 创建行 表头
			HSSFRow row = personInfoSheet.createRow((short) 0);
			HSSFCell headerCell = null;
			row.setHeightInPoints(20);

			headerCell = row.createCell(0);
			headerCell.setCellValue("ID号");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(1);
			headerCell.setCellValue("部门");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(2);
			headerCell.setCellValue("姓名");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(3);
			headerCell.setCellValue("性别");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(4);
			headerCell.setCellValue("基本工资");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(5);
			headerCell.setCellValue("工龄工资");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(6);
			headerCell.setCellValue("岗位津贴");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(7);
			headerCell.setCellValue("误餐费");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(8);
			headerCell.setCellValue("洗理费");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(9);
			headerCell.setCellValue("奖金");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(10);
			headerCell.setCellValue("加班费");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(11);
			headerCell.setCellValue("年终奖");
			headerCell.setCellStyle(columnHeadStyle);			

			headerCell = row.createCell(12);
			headerCell.setCellValue("福利");
			headerCell.setCellStyle(columnHeadStyle);

			headerCell = row.createCell(13);
			headerCell.setCellValue("工资合计");
			headerCell.setCellStyle(columnHeadStyle);						

			headerCell = row.createCell(14);
			headerCell.setCellValue("保险");
			headerCell.setCellStyle(columnHeadStyle);				

			headerCell = row.createCell(15);
			headerCell.setCellValue("公积金");
			headerCell.setCellStyle(columnHeadStyle);	

			headerCell = row.createCell(16);
			headerCell.setCellValue("备注");
			headerCell.setCellStyle(columnHeadStyle);
			
			List<SalaryPo> salarysList = salaryDao.bulidSalaryExcel(salaryPo);
			
			Iterator<SalaryPo> iterator = (Iterator<SalaryPo>) salarysList.iterator();
			int i = 1;
			
			while (iterator.hasNext()) {
				SalaryPo po = (SalaryPo) iterator.next();

				HSSFRow rows = personInfoSheet.createRow(i++);
				rows.setHeightInPoints(20);

				headerCell = rows.createCell(0);
				headerCell.setCellValue(po.getMslpersonid());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(1);
				headerCell.setCellValue(po.getDepartmentname());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(2);
				headerCell.setCellValue(po.getPersonname());
				headerCell.setCellStyle(style);
				
				headerCell = rows.createCell(3);
				headerCell.setCellValue(po.getSex());
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(4);
				headerCell.setCellValue(this.floatFormat(po.getMsljibengongzi()));
				headerCell.setCellStyle(style);
				
				headerCell = rows.createCell(5);
				headerCell.setCellValue(this.floatFormat(po.getMslgonglingjintie()));
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(6);
				headerCell.setCellValue(this.floatFormat(po.getMslgangweijintie()));
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(7);
				headerCell.setCellValue(this.floatFormat(po.getMslwucanfei()));
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(8);
				headerCell.setCellValue(this.floatFormat(po.getMslxilifei()));
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(9);
				headerCell.setCellValue(this.floatFormat(po.getMsljiangjin()));
				headerCell.setCellStyle(style);

				headerCell = rows.createCell(10);
				headerCell.setCellValue(this.floatFormat(po.getMsljiabanfei()));
				headerCell.setCellStyle(style);	

				headerCell = rows.createCell(11);
				headerCell.setCellValue(this.floatFormat(po.getMslnianzhongjiang()));
				headerCell.setCellStyle(style);	

				headerCell = rows.createCell(12);
				headerCell.setCellValue(this.floatFormat(po.getMslfuli()));
				headerCell.setCellStyle(style);	

				headerCell = rows.createCell(13);
				headerCell.setCellValue(this.floatFormat(po.getMslsumsalary()));
				headerCell.setCellStyle(style);	

				headerCell = rows.createCell(14);
				headerCell.setCellValue(this.floatFormat(po.getMslbaoxian()));
				headerCell.setCellStyle(style);	

				headerCell = rows.createCell(15);
				headerCell.setCellValue(this.floatFormat(po.getMslgongjijin()));
				headerCell.setCellStyle(style);	

				headerCell = rows.createCell(16);
				headerCell.setCellValue(po.getMslremark());
				headerCell.setCellStyle(style);	
																												
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			
			return new ByteArrayInputStream(baos.toByteArray());
			
		} catch (Exception e) {
			throw e;
		}
	}	
	
	private String floatFormat(String str){
		BigDecimal n=new BigDecimal(0.00);
		if(!str.equals("")){
			n = new BigDecimal(str);
		}		
		BigDecimal n2 = n.setScale(2, BigDecimal.ROUND_FLOOR);
		return n2+"";
	}
}
