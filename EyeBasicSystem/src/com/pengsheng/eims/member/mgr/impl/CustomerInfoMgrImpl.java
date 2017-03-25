package com.pengsheng.eims.member.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.dao.MemberUpGradeDao;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.MemberExportPo;
import com.pengsheng.eims.member.persistence.UpgradeRecordPo;
import com.pengsheng.eims.sales.dao.IntegralAddandSubDao;
import com.pengsheng.eims.sales.mgr.FrameSalesMgr;
import com.pengsheng.eims.sales.persistence.IntegralAddandSubPo;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;
import com.safenet.CheckSystemShutDown;


public class CustomerInfoMgrImpl implements CustomerInfoMgr {
	
	private LogisticsLogDao logisticsLogDao;
	
	private MemberUpGradeDao memberUpGradeDao;
	private CustomerInfoDao customerInfoDao;
	private SendNoteMgr sendNoteMgr = null;
	private FrameSalesMgr frameSalesMgr = null;
	private IntegralAddandSubDao integralAddandSubDao;
	
	
	public FrameSalesMgr getFrameSalesMgr() {
		return frameSalesMgr;
	}
	public void setFrameSalesMgr(FrameSalesMgr frameSalesMgr) {
		this.frameSalesMgr = frameSalesMgr;
	}
	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}
	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private DelaysReminderInformDao delaysReminderInformDao;
	
	
	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}


	public MemberUpGradeDao getMemberUpGradeDao() {
		return memberUpGradeDao;
	}
	public void setMemberUpGradeDao(MemberUpGradeDao memberUpGradeDao) {
		this.memberUpGradeDao = memberUpGradeDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}
	/**
	 * 查询会员信息数量
	 */
	public int getCustomerInfoCount(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfoCount(po);
	}
	
	/**
	 * 查询会员信息数量
	 */
	public int getCustomerInfoCount2(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfoCount2(po);
	}
	
	public int getCustomerInfoCount1(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfoCount1(po);
	}
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po,PersonInfoPo ppo) {
		
		frameSalesMgr.getHisCustomerInfoCount(po,ppo);
		
		return this.customerInfoDao.getCustomerInfo(po);
	}
	
	public CustomerInfoPo getCustomerInfo(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfo(po);
	}
	
	public InputStream bulidCustomerInfoExcel(CustomerInfoPo po) throws Exception
	{
		try{
			List<CustomerInfoPo> customerInfosList = customerInfoDao.exportCustomerInfo(po);
			Iterator<CustomerInfoPo> iterator = (Iterator<CustomerInfoPo>) customerInfosList.iterator();
		    int count1=0;
			if(customerInfosList.size() > 65536){
				int sx = customerInfosList.size() / 65535 + 1;
				SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
				for(int y = 0; y < sx; y++){
					
					// 在Excel工作簿中建一工作表		
					Sheet customerInfoSheet = workbook.createSheet("CustomerInfo"+y);
					// 设置列宽
					customerInfoSheet.setColumnWidth(0, 4000);
					customerInfoSheet.setColumnWidth(1, 4000);
					customerInfoSheet.setColumnWidth(2, 4000);
					customerInfoSheet.setColumnWidth(3, 4000);
					customerInfoSheet.setColumnWidth(4, 4000);
					customerInfoSheet.setColumnWidth(5, 4000);
					customerInfoSheet.setColumnWidth(6, 4000);
					customerInfoSheet.setColumnWidth(7, 4000);
					
					//导出可选的会员属性
					int exportcount = customerInfoDao.getCustomerInfoForExport() + 8;
					for (int i = 8; i < exportcount; i++){
						customerInfoSheet.setColumnWidth(i, 4000);
					}
					
					Font headfont = workbook.createFont();
					headfont.setFontName("黑体");
					headfont.setFontHeightInPoints((short) 12);// 字体大小
					headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
					// 列头的样式
					CellStyle columnHeadStyle = workbook.createCellStyle();
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
					Font font = workbook.createFont();
					font.setFontName("宋体");
					font.setFontHeightInPoints((short) 10);
					// 普通单元格样式
					CellStyle style = workbook.createCellStyle();
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
					Row row = customerInfoSheet.createRow((short) 0);
					Cell headerCell = null;
					row.setHeightInPoints(20);
		
					headerCell = row.createCell(0);
					headerCell.setCellValue("会员卡号");
					headerCell.setCellStyle(columnHeadStyle);
		
					headerCell = row.createCell(1);
					headerCell.setCellValue("会员姓名");
					headerCell.setCellStyle(columnHeadStyle);
		
					headerCell = row.createCell(2);
					headerCell.setCellValue("会员积分");
					headerCell.setCellStyle(columnHeadStyle);
		
					headerCell = row.createCell(3);
					headerCell.setCellValue("性别");
					headerCell.setCellStyle(columnHeadStyle);
		
					headerCell = row.createCell(4);
					headerCell.setCellValue("年龄");
					headerCell.setCellStyle(columnHeadStyle);
					
					headerCell = row.createCell(5);
					headerCell.setCellValue("联系电话1");
					headerCell.setCellStyle(columnHeadStyle);
					
					headerCell = row.createCell(6);
					headerCell.setCellValue("联系电话2");
					headerCell.setCellStyle(columnHeadStyle);
					
					headerCell = row.createCell(7);
					headerCell.setCellValue("联系电话3");
					headerCell.setCellStyle(columnHeadStyle);
					
					List<MemberExportPo> mepo = customerInfoDao.getCustomerInfoForExportList("1");
					for (int i = 8; i < exportcount; i++){
						headerCell = row.createCell(i);
						headerCell.setCellValue(mepo.get(i - 8).getBmepropertyname());
						headerCell.setCellStyle(columnHeadStyle);
					}
					
					int i = 1;
					
					while (iterator.hasNext()) {
						if(count1>customerInfosList.size())
						{
							break;
						}
						CustomerInfoPo pox = (CustomerInfoPo) iterator.next();
						if(i==65534)
						{
							break;
						}
						
					    Row rows = customerInfoSheet.createRow(i++);
						rows.setHeightInPoints(20);
		
						headerCell = rows.createCell(0);
						headerCell.setCellValue(Utility.getName(pox.getSmecimemberid()));
						headerCell.setCellStyle(style);
		
						headerCell = rows.createCell(1);
						headerCell.setCellValue(Utility.getName(pox.getSmeciname()));
						headerCell.setCellStyle(style);
		
						headerCell = rows.createCell(2);
						headerCell.setCellValue(Utility.getName(pox.getSmeciintegral()));
						headerCell.setCellStyle(style);
		
						headerCell = rows.createCell(3);
						headerCell.setCellValue(Utility.getName(pox.getSmecisex()).equals("0") ? "男" : "女");
						headerCell.setCellStyle(style);
						
						headerCell = rows.createCell(4);
						String birthdayYear = "";
						int age = -1;
						if (!Utility.getName(pox.getSmecibirthday()).equals("")){
							birthdayYear = Utility.getName(pox.getSmecibirthday()).substring(0,4);
							age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
						}
						if (age == -1){
							headerCell.setCellValue("");
						}else{
							headerCell.setCellValue(age);
						}		
						headerCell.setCellStyle(style);
						
						headerCell = rows.createCell(5);
						headerCell.setCellValue(Utility.getName(pox.getSmeciphone()));
						headerCell.setCellStyle(style);
						
						headerCell = rows.createCell(6);
						headerCell.setCellValue(Utility.getName(pox.getSmeciphone2()));
						headerCell.setCellStyle(style);
						
						headerCell = rows.createCell(7);
						headerCell.setCellValue(Utility.getName(pox.getSmeciphone3()));
						headerCell.setCellStyle(style);
						
						for (int j = 8; j < exportcount; j++){
							headerCell = rows.createCell(j);
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("1")){  // 地区
								headerCell.setCellValue(pox.getSmecizone());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("2")){  // 职业
								headerCell.setCellValue(pox.getSmeciworkname());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("3")){  // QQ号码
								headerCell.setCellValue(pox.getSmeciqqnumber());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("4")){  // Email
								headerCell.setCellValue(pox.getSmeciemail());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("5")){  // 地址
								headerCell.setCellValue(pox.getSmeciaddress());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("6")){  // 邮编
								headerCell.setCellValue(pox.getSmecipostcode());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("7")){  // 兴趣
								headerCell.setCellValue(pox.getSmeciinterest());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("8")){  // 来源
								headerCell.setCellValue(pox.getSmecimemberoriginname());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("9")){  // 备注
								headerCell.setCellValue(pox.getSmeciremark());
							}
							if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("10")){  // 生日
								headerCell.setCellValue(pox.getSmecibirthday());
							}							
							headerCell.setCellStyle(style);
						}
						
						count1++;
					}
				}
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				workbook.write(baos);
				return new ByteArrayInputStream(baos.toByteArray());
				
			}else{
				
				SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
	
				// 在Excel工作簿中建一工作表		
				Sheet customerInfoSheet = workbook.createSheet("CustomerInfo");
				// 设置列宽
				customerInfoSheet.setColumnWidth(0, 4000);
				customerInfoSheet.setColumnWidth(1, 4000);
				customerInfoSheet.setColumnWidth(2, 4000);
				customerInfoSheet.setColumnWidth(3, 4000);
				customerInfoSheet.setColumnWidth(4, 4000);
				customerInfoSheet.setColumnWidth(5, 4000);
				customerInfoSheet.setColumnWidth(6, 4000);
				customerInfoSheet.setColumnWidth(7, 4000);
				
				//导出可选的会员属性
				int exportcount = customerInfoDao.getCustomerInfoForExport() + 8;
				for (int i = 8; i < exportcount; i++){
					customerInfoSheet.setColumnWidth(i, 4000);
				}
				
				Font headfont = workbook.createFont();
				headfont.setFontName("黑体");
				headfont.setFontHeightInPoints((short) 12);// 字体大小
				headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
				// 列头的样式
				CellStyle columnHeadStyle = workbook.createCellStyle();
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
				Font font = workbook.createFont();
				font.setFontName("宋体");
				font.setFontHeightInPoints((short) 10);
				// 普通单元格样式
				CellStyle style = workbook.createCellStyle();
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
				Row row = customerInfoSheet.createRow((short) 0);
				Cell headerCell = null;
				row.setHeightInPoints(20);
	
				headerCell = row.createCell(0);
				headerCell.setCellValue("会员卡号");
				headerCell.setCellStyle(columnHeadStyle);
	
				headerCell = row.createCell(1);
				headerCell.setCellValue("会员姓名");
				headerCell.setCellStyle(columnHeadStyle);
	
				headerCell = row.createCell(2);
				headerCell.setCellValue("会员积分");
				headerCell.setCellStyle(columnHeadStyle);
	
				headerCell = row.createCell(3);
				headerCell.setCellValue("性别");
				headerCell.setCellStyle(columnHeadStyle);
	
				headerCell = row.createCell(4);
				headerCell.setCellValue("年龄");
				headerCell.setCellStyle(columnHeadStyle);
				
				headerCell = row.createCell(5);
				headerCell.setCellValue("联系电话1");
				headerCell.setCellStyle(columnHeadStyle);
				
				headerCell = row.createCell(6);
				headerCell.setCellValue("联系电话2");
				headerCell.setCellStyle(columnHeadStyle);
				
				headerCell = row.createCell(7);
				headerCell.setCellValue("联系电话3");
				headerCell.setCellStyle(columnHeadStyle);
				
				List<MemberExportPo> mepo = customerInfoDao.getCustomerInfoForExportList("1");
				for (int i = 8; i < exportcount; i++){
					headerCell = row.createCell(i);
					headerCell.setCellValue(mepo.get(i - 8).getBmepropertyname());
					headerCell.setCellStyle(columnHeadStyle);
				}
				
				int i = 1;
				
				while (iterator.hasNext()) {
					CustomerInfoPo pox = (CustomerInfoPo) iterator.next();
	
					Row rows = customerInfoSheet.createRow(i++);
					rows.setHeightInPoints(20);
	
					headerCell = rows.createCell(0);
					headerCell.setCellValue(Utility.getName(pox.getSmecimemberid()));
					headerCell.setCellStyle(style);
	
					headerCell = rows.createCell(1);
					headerCell.setCellValue(Utility.getName(pox.getSmeciname()));
					headerCell.setCellStyle(style);
	
					headerCell = rows.createCell(2);
					headerCell.setCellValue(Utility.getName(pox.getSmeciintegral()));
					headerCell.setCellStyle(style);
	
					headerCell = rows.createCell(3);
					headerCell.setCellValue(Utility.getName(pox.getSmecisex()).equals("0") ? "男" : "女");
					headerCell.setCellStyle(style);
					
					headerCell = rows.createCell(4);
					String birthdayYear = "";
					int age = -1;
					if (!Utility.getName(pox.getSmecibirthday()).equals("")){
						birthdayYear = Utility.getName(pox.getSmecibirthday()).substring(0,4);
						age = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(birthdayYear);
					}
					if (age == -1){
						headerCell.setCellValue("");
					}else{
						headerCell.setCellValue(age);
					}		
					headerCell.setCellStyle(style);
					
					headerCell = rows.createCell(5);
					headerCell.setCellValue(Utility.getName(pox.getSmeciphone()));
					headerCell.setCellStyle(style);
					
					headerCell = rows.createCell(6);
					headerCell.setCellValue(Utility.getName(pox.getSmeciphone2()));
					headerCell.setCellStyle(style);
					
					headerCell = rows.createCell(7);
					headerCell.setCellValue(Utility.getName(pox.getSmeciphone3()));
					headerCell.setCellStyle(style);
					
					for (int j = 8; j < exportcount; j++){
						headerCell = rows.createCell(j);
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("1")){  // 地区
							headerCell.setCellValue(pox.getSmecizone());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("2")){  // 职业
							headerCell.setCellValue(pox.getSmeciworkname());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("3")){  // QQ号码
							headerCell.setCellValue(pox.getSmeciqqnumber());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("4")){  // Email
							headerCell.setCellValue(pox.getSmeciemail());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("5")){  // 地址
							headerCell.setCellValue(pox.getSmeciaddress());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("6")){  // 邮编
							headerCell.setCellValue(pox.getSmecipostcode());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("7")){  // 兴趣
							headerCell.setCellValue(pox.getSmeciinterest());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("8")){  // 来源
							headerCell.setCellValue(pox.getSmecimemberoriginname());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("9")){  // 备注
							headerCell.setCellValue(pox.getSmeciremark());
						}
						if (Utility.getName(mepo.get(j - 8).getBmepropertyid()).equals("10")){  // 生日
							headerCell.setCellValue(pox.getSmecibirthday());
						}		
						headerCell.setCellStyle(style);
					}
				
				}
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				workbook.write(baos);
				
				return new ByteArrayInputStream(baos.toByteArray());
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 查询会员信息通过电话
	 */
	public CustomerInfoPo getCustomerInfocall(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfocall(po);
	}
	
	/**
	 * 查询会员信息通过电话
	 */
	public int getCustomerInfoByPhone(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfoByPhone(po);
	}
	
	/**
	 * 遍历会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoList(CustomerInfoPo po,
			int start, int size) {
		CheckSystemShutDown.execSleep();
		return this.customerInfoDao.getCustomerInfoList(po, start, size);
	}
	
	/**
	 * 遍历高级会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoList1(CustomerInfoPo po,
			int start, int size) {
		return this.customerInfoDao.getCustomerInfoList1(po, start, size);
	}
	/**
	 * 新增会员信息
	 */
	public void insertCustomerInfo(CustomerInfoPo po,LogisticsLogPo logPo) {

		//----------用于照片上传 moyongsheng 2012-12-12-18:39		
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			try
		    {
		      BufferedInputStream in = new BufferedInputStream(
		                                   new FileInputStream(po.getRootPath()+po.getMemberPicPath()));

		      BufferedOutputStream out = new BufferedOutputStream(
		                                     new FileOutputStream(po.getRootPath()+"memberPic/"+po.getSmecimemberid()+".jpg"));
		      byte[] buffer = new byte[1024*128];
		      int b = 0;
		      while ((b=in.read(buffer)) != -1)  out.write(buffer,0,b);
		      in.close();
		      out.close();
		      File file=new File(po.getRootPath()+po.getMemberPicPath());//删除临时照片
		      file.delete();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		    }
		    po.setMemberPicPath("memberPic/"+po.getSmecimemberid()+".jpg");//变更为会员图片目录路径
		}
		//----------用于照片上传 moyongsheng 2012-12-12-18:39	
		
		logisticsLogDao.insertLog(logPo);  //新增日志		
		this.customerInfoDao.insertCustomerInfo(po);
	}
	/**
	 * 修改会员信息
	 */
	public void updateCustomerInfo(CustomerInfoPo po,LogisticsLogPo logPo) {
		//----------用于照片上传 moyongsheng 2012-12-12-18:39		
		if(po.getMemberPicPath()!=null&&!po.getMemberPicPath().equals("")){
			try
		    {
		      BufferedInputStream in = new BufferedInputStream(
		                                   new FileInputStream(po.getRootPath()+po.getMemberPicPath()));
		      BufferedOutputStream out = new BufferedOutputStream(
		                                     new FileOutputStream(po.getRootPath()+"memberPic/"+po.getSmecimemberid()+".jpg"));
		      byte[] buffer = new byte[1024*128];
		      int b = 0;
		      while ((b=in.read(buffer)) != -1)  out.write(buffer,0,b);
		      in.close();
		      out.close();
		      File file=new File(po.getRootPath()+po.getMemberPicPath());//删除临时照片
		      file.delete();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		    }
		    po.setMemberPicPath("memberPic/"+po.getSmecimemberid()+".jpg");//变更为会员图片目录路径
		}
		//----------用于照片上传 moyongsheng 2012-12-12-18:39					
			
		CustomerInfoPo po2 = memberUpGradeDao.selectCustomerInfo(po);
		if (!Utility.getName(po.getSmecicardtype()).equals(Utility.getName(po2.getSmecicardtype()))){
			UpgradeRecordPo tmp = new UpgradeRecordPo();
			tmp.setSmecucurrentcardid(Utility.getName(po2.getSmecicardtype()));
			tmp.setSmecucurrentintegral(Utility.getName(po2.getSmeciintegral()));
			tmp.setSmecuintegralchange("0");
			tmp.setSmeculastcardid(Utility.getName(po.getSmecicardtype()));
			tmp.setSmeculastintegral(Utility.getName(po2.getSmeciintegral()));
			tmp.setSmecucustomerid(Utility.getName(po.getSmecicustomerid()));
			tmp.setSmecumemberid(Utility.getName(po.getSmecimemberid()));
			tmp.setSmecuflag("2");
			tmp.setSmecushopcode(Utility.getName(po.getUpgradeshopcode()));
			tmp.setSmecupersonid(Utility.getName(po.getUpgradeperson()));
			
			memberUpGradeDao.insertUpGradeRecord(tmp);
		}
		logisticsLogDao.insertLog(logPo);  //新增日志
		this.customerInfoDao.updateCustomerInfo(po);
		
		if("".equals(po.getSmecisourcecard())){
			customerInfoDao.updateCustomerInfoPhone(po.getSmecimemberoldid(),po.getSmecimemberid(), po.getSmeciphone());
		}
	}

	/**
	 * 删除会员信息
	 */
	public void deleteCustomerInfo(CustomerInfoPo po,LogisticsLogPo logPo) {
		
		CustomerInfoPo filePo = customerInfoDao.getCustomerInfo(po);	
		
		//----------删除照片 moyongsheng 2012-12-12-18:39	
		if(filePo.getMemberPicPath()!=null&&!filePo.getMemberPicPath().equals("")){
			try
		    {
		      File file=new File(po.getRootPath()+filePo.getMemberPicPath());//删除照片
		      file.delete();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		    }
		}
		//----------删除照片 moyongsheng 2012-12-12-18:39	
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		this.customerInfoDao.deleteCustomerInfo(po);
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}
	
	/**
	 * 判断重复
	 * @param po
	 * @return
	 */
	public int getCount(CustomerInfoPo po) {
		return customerInfoDao.getCount(po);
	}
	
	/**
	 * 是否存在
	 * @param po
	 * @return
	 */
	public int getCount() {
		return customerInfoDao.getCount();
	}
	
	/**
	 * 新增发送短信
	 */
	public void insertCustomerInfoMessage(List<CustomerInfoPo> plist,SendNotePo snpo,LogisticsLogPo logPo){

		for(int i = 0;i < plist.size(); i++){
			
			snpo.setSncustomerid(Utility.getName(plist.get(i).getSmecicustomerid()));
			sendNoteMgr.insertSendNote(snpo);
			
			logPo.setsLogContent("会员编号：" + Utility.getName(snpo.getSncustomerid()) + " 发送短信!");
			logisticsLogDao.insertLog(logPo);  //新增日志
		}
	}
	
	/**
	 * 更新会员积分
	 */
	public void updateCustomerInfoIntegral(CustomerInfoPo po){
		customerInfoDao.updateCustomerInfoIntegral(po);
	}
	
	/**
	 * 查询会员卡类型
	 */
	public List<MemberManagementPo> getMemberCardTypeList(){
		return customerInfoDao.getMemberCardTypeList();
	}
	/**
	 * 遍历高级会员信息
	 */
	public List<CustomerInfoPo> getCustomerInfoListMessage(CustomerInfoPo po) 
	{
		return customerInfoDao.getCustomerInfoListMessage(po);
	}
	
	/**
	 * 查询顾客是否可以删除
	 * @param po
	 * @return
	 */
	public int selectCustomerInfoIsDelete(CustomerInfoPo po){
		return customerInfoDao.selectCustomerInfoIsDelete(po);
	}
	
	/**
	 * 清空指定会员积分
	 */
	public void updateCustomerInfoAppointCredit(List<CustomerInfoPo> pos,LogisticsLogPo logPo){
		for(int i=0; i<pos.size(); i++){
			//插入积分流水表
			IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
			CustomerInfoPo customerInfoPo = (CustomerInfoPo)pos.get(i);
			customerInfoPo = customerInfoDao.getCustomerInfo2(customerInfoPo);
			integralAddandSubPo.setSmeascustomerid(customerInfoPo.getSmecicustomerid());
			integralAddandSubPo.setSmeasmemberid(customerInfoPo.getSmecicustomerid());
			integralAddandSubPo.setSmeasdopersonid(logPo.getsLogName());
			integralAddandSubPo.setSmeasaddorsub("8");
			integralAddandSubPo.setSmeasyintegral(customerInfoPo.getSmeciintegral());
			integralAddandSubPo.setSmeascintegral("-"+customerInfoPo.getSmeciintegral());
			integralAddandSubPo.setSmeasxintegral("0.00");
			integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
			
			//更新顾客表积分为0
			customerInfoDao.updateCustomerInfoAppointCredit(pos.get(i));
		}
		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
	/**
	 * 清空所有会员积分
	 */
	public void updateCustomerInfoAllCredit(LogisticsLogPo logPo){
		
		List customerInfoPoList = customerInfoDao.getCustomerInfo_Integral_List();
		Iterator it = customerInfoPoList.iterator();
		while(it.hasNext()){
			CustomerInfoPo customerInfoPo = (CustomerInfoPo)it.next();
			IntegralAddandSubPo integralAddandSubPo = new IntegralAddandSubPo();
			integralAddandSubPo.setSmeascustomerid(customerInfoPo.getSmecicustomerid());
			integralAddandSubPo.setSmeasmemberid(customerInfoPo.getSmecicustomerid());
			integralAddandSubPo.setSmeasdopersonid(logPo.getsLogName());
			integralAddandSubPo.setSmeasaddorsub("8");
			integralAddandSubPo.setSmeasyintegral(customerInfoPo.getSmeciintegral());
			integralAddandSubPo.setSmeascintegral("-"+customerInfoPo.getSmeciintegral());
			integralAddandSubPo.setSmeasxintegral("0.00");
			integralAddandSubDao.insertIntegralAddandSubPo(integralAddandSubPo);
		}
		
		
		customerInfoDao.updateCustomerInfoAllCredit();		
		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
	/**
	 * 更新会员导出配置项
	 */
	public void updateCustomerExportInfoProperty(MemberExportPo po,LogisticsLogPo logPo){
		customerInfoDao.updateCustomerExportInfoProperty(po);
		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
	/**
	 * 获取会员导出属性的列表
	 */
	public List<MemberExportPo> getCustomerInfoForExportList(String flag){
		return customerInfoDao.getCustomerInfoForExportList(flag);
	}
	
	public List<CustomerInfoPo> selectGXList(CustomerInfoPo po){
		return customerInfoDao.selectGXList(po);
	}
	
	/**
	 * 获取主子卡全部销售金额
	 */
	public CustomerInfoPo getALLsalesvalues(String salesid){
		return customerInfoDao.getALLsalesvalues(salesid);
	}
	
	/**
	 * 会员启用停用
	 */
	public void updateCustomerEnable(CustomerInfoPo cpo,LogisticsLogPo logPo){
		
		String[] array = Utility.getName(cpo.getSmecicustomerid()).split(",");
		for (int i = 0; i < array.length; i++){
			CustomerInfoPo po = new CustomerInfoPo();
			po.setSmecicustomerid(array[i]);
			po.setSmeciflag(Utility.getName(cpo.getSmeciflag()));
			
			logPo.setsLogContent("会员卡号：" + array[i] + (Utility.getName(po.getSmeciflag()).equals("1") ? " 被启用!" : "被停用!"));	
			
			customerInfoDao.updateCustomerEnable(po);
			
			logisticsLogDao.insertLog(logPo);  //新增日志
		}
		
	}
	
	/**
	 * 只有待结款的单子才能调用
	 */
	public CustomerInfoPo getCustomerInfoNoFinished(CustomerInfoPo po) {
		return this.customerInfoDao.getCustomerInfoNoFinished(po);
	}

	public CustomerInfoPo getCustomerInfoByH() {
		return customerInfoDao.getCustomerInfoByH();

	}
	
	/**
	 * 微信中获得主卡或关联卡信息
	 */
	public List<CustomerInfoPo> getWeixinCustomerInfoList(CustomerInfoPo po){
		return customerInfoDao.getWeixinCustomerInfoList(po);
	}
	public IntegralAddandSubDao getIntegralAddandSubDao() {
		return integralAddandSubDao;
	}
	public void setIntegralAddandSubDao(IntegralAddandSubDao integralAddandSubDao) {
		this.integralAddandSubDao = integralAddandSubDao;
	}
	
	/**
	 * 获取集团端顾客信息List
	 */
	public List<CustomerInfoPo> noGetCustomerInfoDownloadList(CustomerInfoPo po,int start, int size){
		
		customerInfoDao.openWork();		
		List<CustomerInfoPo> customerInfoPoList = customerInfoDao.getCustomerInfoDownloadList(po,start,size);	
		customerInfoDao.closeWork();
		return customerInfoPoList;
	}
	/**
	 * 查询会员信息数量
	 */
	public int noGetCustomerInfoDownloadCount(CustomerInfoPo po){
		customerInfoDao.openWork();		
		int i = customerInfoDao.getCustomerInfoDownloadCount(po);	
		customerInfoDao.closeWork();
		return i;
	}
	/**
	 * 查询会员信息
	 */
	public CustomerInfoPo noGetCustomerInfoDownload(CustomerInfoPo po){
		customerInfoDao.openWork();		
		CustomerInfoPo returnPo = customerInfoDao.getCustomerInfoDownload(po);	
		customerInfoDao.closeWork();
		return returnPo;
	}
	public int getCuInfo(CustomerInfoPo cpo) {
		return customerInfoDao.getCuInfo(cpo);
	}
	public void updteCustCard(CustomerInfoPo cpo) {
		customerInfoDao.updteCustCard(cpo);
	}
	/**
	 * HIS新增会员信息
	 */
	public void insertCust(CustomerInfoPo po,LogisticsLogPo logPo) {
		customerInfoDao.insertCustomerInfo(po);
		logisticsLogDao.insertLog(logPo);
    }
	
	public void updteCurCustCard(CustomerInfoPo cpo,LogisticsLogPo logPo) {
		customerInfoDao.updteCurCustCard(cpo);
	}
	/**
	 * 
	 * HIS模块判断会员电话是否重复
	 */
	public String getCustPhoneInfo(CustomerInfoPo cpo) {
		CustomerInfoPo customerInfo = customerInfoDao.getCustPhoneInfo(cpo);
		return Utility.getName(customerInfo.getSmecimemberid());
	}
}
