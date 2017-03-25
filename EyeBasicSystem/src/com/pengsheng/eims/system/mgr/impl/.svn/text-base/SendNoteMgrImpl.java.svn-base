package com.pengsheng.eims.system.mgr.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.system.dao.SendNoteDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.DateTool;
import com.pengsheng.eims.util.tools.SMSUtil;
import com.pengsheng.eims.util.tools.Utility;

public class SendNoteMgrImpl implements SendNoteMgr {

	private SendNoteDao sendNoteDao;
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterDao systemParameterDao;
	private SystemParameterPo systemParameterPo;
	private CustomerInfoDao customerInfoDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}
	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}
	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	public SendNoteDao getSendNoteDao() {
		return sendNoteDao;
	}
	public void setSendNoteDao(SendNoteDao sendNoteDao) {
		this.sendNoteDao = sendNoteDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 根据短信模板发送短信
	 */
	public void insertSendNoteContent(SendNotePo po){
		
		NoteTemplatePo ntpo = new NoteTemplatePo();
		
		ntpo.setBnttypeid(Utility.getName(po.getSnnotetypeid()));
		int count = sendNoteDao.getSendNoteTemplateCount(ntpo);  // 查询当前模块是否存在短信模板
		
		if (sendNoteDao.getSendNotePhoneCountByCustomer(po) <= 0){   // 没有手机号
			return;
		}
		
		systemParameterPo = systemParameterDao.getSystemParameterPo();
		if (count > 0 && (Utility.getName(systemParameterPo.getFspshortmessage()).equals("1") || Utility.getName(systemParameterPo.getFspshortmessage()).equals("2"))){	 // 存在短信模板。并且已开启短信功能

			// 所有参数
			String[] paremList = {"%顾客姓名%","%性别%","%配镜单号%","%配镜日期%",
					              "%取镜日期%","%取镜门店%","%门店电话%","%取镜门店电话%",
					              "%反馈内容%","%验光日期%","%复验日期%","%实收金额%",
					              "%获取积分%","%抛弃类型%","%商品名称%","%销售门店%"
 			                     };
			String[] dList = null;   // 各个模块的参数数组
			String[] sList = null;   // 各个模块的参数值数组
			int index = 0;    // 模块标识
			
			if (!Utility.getName(ntpo.getBnttypeid()).equals("")){   // 对模块标识进行类型转换
				BigDecimal bg = new BigDecimal(Utility.getName(ntpo.getBnttypeid()));
				index = bg.intValue();
			}
			
			NoteTemplatePo tpo = sendNoteDao.getSendNoteTemplate(ntpo);  // 查询当前模块的短信模板			
			po.setSnnotecontent(Utility.getName(tpo.getBntcontent()));
			
			
			SendNotePo snpo = sendNoteDao.getSendNotePhoneByCustomer(po);
			po.setSncustomertelphone(Utility.getName(snpo.getSncustomertelphone()));  // 查询手机号
			
			if ("".equals(Utility.getName(po.getSnsenddate()))){    // 设置发送时间,实时发送的短信时间要为空
		        Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.MINUTE,1);    // 时间延迟 1分钟

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				po.setSnsenddate(dateFormat.format(cal.getTime()));
			}
			
			if (Utility.getName(po.getSncustomername()).equals("")){  // 使用微信注册但未完善资料
				po.setSncustomername("顾客");
			}
			
			switch(index){
			case 4: // 委外预误期
				dList = new String[]{paremList[0],paremList[1],paremList[2],paremList[4],paremList[8],paremList[6]};
				sList = new String[]{Utility.getName(po.getSncustomername()),Utility.getName(po.getSnsex()),
						             Utility.getName(po.getSnbillid()),Utility.getName(po.getSntakedate()),
						             Utility.getName(po.getSnfeedbackcontent()),Utility.getName(po.getSnshopcodephone())
						             };
				
				po.setSnnotetypeid("4");
				
				break;
			case 5: // 验光
				dList = new String[]{paremList[0],paremList[1],paremList[9],paremList[10],paremList[6]};
				sList = new String[]{Utility.getName(po.getSncustomername()),Utility.getName(po.getSnsex()),
			             Utility.getName(po.getSnoptometrydate()),Utility.getName(po.getSnfurtherdate()),
			             Utility.getName(po.getSnshopcodephone())
			             };
				
				po.setSnnotetypeid("5");
				
				break;
			case 6:// 取镜处到货
				dList = new String[]{paremList[0],paremList[1],paremList[2],paremList[5],paremList[7]};
				sList = new String[]{Utility.getName(po.getSncustomername()),Utility.getName(po.getSnsex()),
			             Utility.getName(po.getSnbillid()),Utility.getName(po.getSntakeshopcodename()),
			             Utility.getName(po.getSntakeshopcodephone())
			             };
				
				po.setSnnotetypeid("6");
				po.setSnsenddate("");
				
				break;
			case 9:// 结款
				dList = new String[]{paremList[0],paremList[1],paremList[2],paremList[6],paremList[11],paremList[12],paremList[15]};
				sList = new String[]{Utility.getName(po.getSncustomername()),Utility.getName(po.getSnsex()),
			             Utility.getName(po.getSnbillid()),Utility.getName(po.getSnshopcodephone()),
			             Utility.getName(po.getSnpsalesprice()),Utility.getName(po.getSnintegral()),
			             Utility.getName(po.getSnshopcodename())
			             
			             };
				
				po.setSnnotetypeid("9");
				po.setSnsenddate("");
				
				break;
			case 11:// 生日提醒
				dList = new String[]{paremList[0],paremList[1],paremList[6]};
				sList = new String[]{Utility.getName(po.getSncustomername()),Utility.getName(po.getSnsex()),
			             Utility.getName(po.getSnshopcodephone())
			             };
				
				po.setSnnotetypeid("11");
				
				break;	
			case 13:// 隐形商品使用提醒
				dList = new String[]{paremList[0],paremList[1],paremList[2],paremList[6],paremList[13],paremList[14],paremList[15] };
				sList = new String[]{Utility.getName(po.getSncustomername()),Utility.getName(po.getSnsex()),Utility.getName(po.getSnbillid()),Utility.getName(po.getSnshopcodephone()),Utility.getName(po.getSnstealthclass()),Utility.getName(po.getSngoodsname()),
			             Utility.getName(po.getSnshopcodename())
			             };
				
				po.setSnnotetypeid("13");
				
				break;	
				
			default:
				break;
			}
			
			// 发送短信
			this.insertSendNote(dList,sList,po);
		}
		
	}
	
	/**
	 * 发送短信
	 */
	private void insertSendNote(String[] dArray,String[] sArray,SendNotePo po){
		
		String notecontent = Utility.getName(po.getSnnotecontent());
		
		if (dArray != null && dArray.length > 0){
			for (int i = 0; i < dArray.length; i++){
				
				if (notecontent.indexOf(dArray[i]) >= 0 ){
					
					String[] array = notecontent.split(dArray[i]);
					StringBuffer buffer = new StringBuffer();
					
					int j1 = 0;
					if (notecontent.startsWith(dArray[i])){
						buffer.append(sArray[i]);	
						j1 = 1;
					}
					
					for (int j = j1; j < array.length; j++){				
						buffer.append(array[j]);
						
						if (array.length - j > 1){
							buffer.append(sArray[i]);
						}
					}
					
					if (notecontent.endsWith(dArray[i])){
						buffer.append(sArray[i]);		
					}
					
					notecontent = buffer.toString();
				}
			}	
		}	
		
		po.setSnnotecontent(notecontent);
		
		po.setSnsendflag(insertSendNoteInterface(po));		
		sendNoteDao.insertSendNoteContent(po);		
	}
	
	/**
	 * 发送短信（单条）
	 */
	public void sendNote(SendNotePo po){
		po.setSnsendflag(insertSendNoteInterface(po));		
		sendNoteDao.insertSendNoteContent(po);
	}
	
	/**
	 * 发送短信（会员高级查询）
	 */
	public void insertSendNote(SendNotePo po){
		
		if (sendNoteDao.getSendNotePhoneCountByCustomer(po) <= 0){   // 没有手机号
			return;
		}
		
		SendNotePo snpo = sendNoteDao.getSendNotePhoneByCustomer(po);
		po.setSncustomertelphone(Utility.getName(snpo.getSncustomertelphone()));  // 查询手机号		
		po.setSnsenddate("");
		
		po.setSnsendflag(insertSendNoteInterface(po));		
		sendNoteDao.insertSendNoteContent(po);

	}
	
	
	/**
	 * 重发送短信（短信记录管理）
	 */
	public void insertReSendNote(SendNotePo po){
		
		po.setSnsendflag(insertSendNoteInterface(po));		
		sendNoteDao.insertSendNoteContent(po);
	}
	
	/**
	 * 短信接口
	 */
	public String insertSendNoteInterface(SendNotePo po){
		String doResult = "";
		systemParameterPo = systemParameterDao.getSystemParameterPo();
		
		if ((Utility.getName(systemParameterPo.getFspshortmessage()).equals("1")) || ((sendNoteDao.getSendNotePhoneCountTestByCustomer(po) > 0) && (Utility.getName(systemParameterPo.getFspshortmessage()).equals("2")))){
			// 短接接口
			
			String mobile=po.getSncustomertelphone();    
			String content=po.getSnnotecontent();
			String timeDate = Utility.getName(po.getSnsenddate());
			if (!timeDate.equals("")){
				timeDate=timeDate.replaceAll("/","-");	//日期连接符统一为 "-"
			}

//			System.out.println(timeDate);
			
			try {
				if (!timeDate.equals("")){
					timeDate = DateTool.getDateStr(DateTool.getDate(timeDate, "yyyy-MM-dd HH:mm"));	//统一日期格式到秒
					timeDate=timeDate.replaceAll("/","-");
					timeDate=timeDate.replaceAll(" ","+");
					timeDate=timeDate.replaceAll(":","%3A");
				}
				doResult = SMSUtil.getInstance().sendSms(systemParameterPo.getFspshortmessagename(),systemParameterPo.getFspshortmessagepw(),mobile, content, timeDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("发送异常");
				e.printStackTrace();
			}
		}

		return doResult;
	}
	
	/**
	 * 获得短信条数
	 */
	public String getSmsCount(){
		String doResult = "";
		systemParameterPo = systemParameterDao.getSystemParameterPo();
		doResult = SMSUtil.getSmsCount(systemParameterPo.getFspshortmessagename(),systemParameterPo.getFspshortmessagepw());
		return doResult;
	}
	
	/**
	 * 获取短信模板数量
	 */
	public List<NoteTemplatePo> getSendNoteTemplateCount(){
		return sendNoteDao.getSendNoteTemplateCount();
	}
	
	/**
	 * 获取短信模板数量
	 */
	public NoteTemplatePo getSendNoteTemplate(NoteTemplatePo po){
		return sendNoteDao.getSendNoteTemplate(po);
	}
}
