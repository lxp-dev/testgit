package com.pengsheng.eims.his.mgr.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;

import com.pengsheng.eims.his.dao.HisDao;
import com.pengsheng.eims.his.dao.HisLogPoDao;
import com.pengsheng.eims.his.dao.HisParamDao;
import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.his.persistence.HisLogPo;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.HttpPostJSON;
import com.pengsheng.eims.util.tools.Utility;

public class HisMgrImpl implements HisMgr {

	private HisDao hisDao;
	private HisLogPoDao hisLogPoDao;
	private HisParamDao hisParamDao;
	private LogisticsLogDao logisticsLogDao;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	 
	
	public HisLogPoDao getHisLogPoDao() {
		return hisLogPoDao;
	}
	public void setHisLogPoDao(HisLogPoDao hisLogPoDao) {
		this.hisLogPoDao = hisLogPoDao;
	}
	public HisParamDao getHisParamDao() {
		return hisParamDao;
	}
	public void setHisParamDao(HisParamDao hisParamDao) {
		this.hisParamDao = hisParamDao;
	} 
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public HisDao getHisDao() {
		return hisDao;
	}
	
	public void setHisDao(HisDao hisDao) {
		this.hisDao = hisDao;
	}
	
	/**
	 * 1. 接口名称：HIS系统患者信息调阅接口
	 * 2. 参          数：cardno 诊疗卡物理ID或身份证ID
	 *             hisLogPo 接口调用记录 
	 * 3. 返回值：患者信息的JSON
	 */
	public String getCustomerInfoByHis(String cardno){
		
		//调用接口
		String custemerInfo= HttpPostJSON.postJSON(cardno);
		return custemerInfo;		
	}
	
	/**
	 * 1. 接口名称：视光系统挂号退费确认接口
	 * 2. 参          数：memberid 患者ID
	 *             todayoutpatientid 当日就诊号
	 * 3. 返回值：患者是否验光的状态
	 */
	public int getCustomerOptometryStateByHis(String memberid,String todayoutpatientid){
		return hisDao.getCustomerOptometryStateByHis(memberid,todayoutpatientid);
	}
	
	
	/**
	 * 1. 接口名称：视光系统挂号退费确认接口
	 * 2. 参          数：memberid 患者ID
	 *             todayoutpatientid 当日就诊号
	 * 3. 返回值：患者是否验光的状态
	 */
	public int getCustomerIsrefundStateByHis(String memberid,String todayoutpatientid){
		return hisDao.getCustomerIsrefundStateByHis(memberid,todayoutpatientid);
	}
	
	/**
	 * 1. 接口名称：HIS系统待交费用推送接口（门店销售）
	 * 2. 参       数：billid 配镜单号，以X开头的单号
	 *             type 收费、退费
	 *             state 单据类型
	 *             logPo 调用日志
	 */
	public void insertSalesNotChargeInfoToHis(String billid,String type,String state,PersonInfoPo ppo,LogisticsLogPo logPo){
		 
		//根据配镜单号，查询出收费项目信息
		SalesBasicPo spo = hisDao.getSalesBasicInfo(billid);
		List<SalesDetailPo> sdpList = hisDao.getSalesDetailInfoList(billid);
		
		String posid = Utility.getName(spo.getSsesbsalerid());
		String posname = Utility.getName(spo.getSsesbsalerName());
		String createtime = Utility.getName(spo.getSsesbsalesdatetime());
		String uid = uuid.generate();
		//封装JSON
        JSONObject obj = new JSONObject();
        if("2".equals(type)){
        	HisParamPo po = new HisParamPo();
        	po.setBillid(billid);
        	po.setFlag("1");
        	po.setChargestatus("1");
        	obj.element("billid", hisParamDao.getHisParamPo(po).getId());
        	
        }else if("1".equals(type)){
        	obj.element("billid", uid);
        }
        
        obj.element("memberid", Utility.getName(spo.getSsesbcustomerid()));
        obj.element("posid", posid);
        obj.element("posname", posname);
        obj.element("totalmoney", Utility.getName(spo.getSsesbsalesvalue()));
        obj.element("type",type);
        obj.element("createtime", createtime);
        
        String[] paramsArray = null;
        String chargetype ="";
        
        if (Utility.getName(ppo.getBdpnotpayfeeform()).equals("1")){   // 按商品明细传递
        	
        	paramsArray = new String[sdpList.size()];
        	
            for (int i = 0; i < sdpList.size(); i++){
                Map<String, String> params = new HashMap<String, String>();
                params.put("detailno", "'" + Utility.getName(sdpList.get(i).getSsesdpayfeeno()) + "'");
                params.put("goodstype", "'" + Utility.getName(sdpList.get(i).getSsesdpayfeeid()) + "'");    
                params.put("goodsmoney", "'" + Utility.getName(sdpList.get(i).getSsesdsalesvalue()) + "'");
                            
                paramsArray[i] = params.toString();     
            }
            chargetype = state;
        }else{     // 按整单传递  
        	
        	paramsArray = new String[1];
        	
            Map<String, String> params = new HashMap<String, String>();
            params.put("detailno","'1'");
            params.put("goodstype", "'" + Utility.getName(ppo.getBdpchargingitemid()) + "'");   
            
        	if (state.equals("1")){   // 订金
        		params.put("goodsmoney", "'" + Utility.getName(spo.getSsesbpsalsvalue()) + "'");
        		chargetype = "2";
        	}else{     // 补齐
        		params.put("goodsmoney", "'" + Utility.getName(spo.getSsesbarrearsvalue()) + "'");
        		chargetype = "3";
        	}
                        
            paramsArray[0] = params.toString();
        }

        obj.element("goodsinfo", paramsArray);
        obj.element("interfaceID","3");
        
        //获取JSON字符串
        String paramStr = obj.toString();
		
        //type==2,表示退款
        if("2".equals(type)){
        	chargetype = "4";
		}
        
		//新增待缴费记录
        HisParamPo hisParamPo = new HisParamPo( uid, billid, createtime, "", posid, posname, chargetype, type);
       
        //新增调用接口日志
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHisloginparam(paramStr); // 入参
        
		try {
			
			//调用接口
			String resultStr = HttpPostJSON.postJSON(ppo.getBdplinkhisurl() + URLEncoder.encode(paramStr,"UTF-8"));
			//String resultStr = HttpPostJSON.postJSON(ppo.getBdplinkhisurl() + paramStr); //原版方法，测试HIS无法使用
			hisLogPo.setHislogreturnparam(resultStr); // 返回值
			
 			HisParamPo paramPo = new HisParamPo();
 			
			if(resultStr.contains("{")||resultStr.contains("}")){

				paramPo = this.toObject(resultStr,paramPo);
				 
				if (Utility.getName(paramPo.getResultCode()).equals("0"))
				{
					// 更新提交失败的状态
					hisParamPo.setFlag("2");
				}
				
			}
			else
			{hisParamPo.setFlag("2");}
			
		} catch (UnsupportedEncodingException e1) {
			hisParamPo.setFlag("2");
			hisLogPo.setHislogreturnparam("编码异常-长度"+paramStr.length()); // 返回值
		}catch(Exception e) {
			hisParamPo.setFlag("2");
		}
	    
		int count = hisParamDao.getHisParamPoCountByBillid(hisParamPo);
        if(count == 0){
        	hisParamDao.insertSaleInfoToHis(hisParamPo);
        } 

		hisLogPo.setHislogdepatmentid(Utility.getName(logPo.getsLogDepartmentID())); // 调用部门ID
		hisLogPo.setHislogpersonid(Utility.getName(logPo.getsLogName())); // 调用人ID
		hisLogPo.setHisloginterfaceid("3"); // 接口ID
		hisLogPo.setHislogmoduleid(Utility.getName(logPo.getsLogResult())); // 所属模块ID	
		hisLogPo.setHislogip(Utility.getName(logPo.getsLogIP())); // IP地址
		
	    hisLogPoDao.insertHisLog(hisLogPo);  //新增日志
		
		//新增系统操作日期
		logisticsLogDao.insertLog(logPo);		
	}
	
	/**
	 * 1. 接口名称：HIS系统待交费用推送接口（验光）
	 * 2. 参          数：billid 挂号单号
	 *             type 收费、退费
	 *             logPo 调用日志
	 */
	public void insertRegisteredNotChargeInfoToHis(String billid,String type,PersonInfoPo ppo,LogisticsLogPo logPo){
		
		//根据挂号流水号，查询出收费项目信息
		RegisteredDetailsPo rpo = hisDao.getRegisteredInfo(billid);
		List<RegisteredDetailsPo> rdpList = hisDao.getRegisteredDetailInfoList(billid);
		
		String posid = Utility.getName(rpo.getScrrdregister());
		String posname = Utility.getName(rpo.getScrrdcreatename());
		String createtime = Utility.getName(rpo.getScrrdoptdate());
		String uid = uuid.generate();
		
		//封装JSON
        JSONObject obj = new JSONObject();
        obj.element("billid", uid);
        obj.element("memberid", Utility.getName(rpo.getScrrdcustomerid()));
        obj.element("posid", posid);
        obj.element("posname", posname);
        obj.element("totalmoney", Utility.getName(rpo.getScrrdmoney()));
        obj.element("type",type);
        obj.element("createtime", createtime);
                
        String[] paramsArray = new String[rdpList.size()];
        String chargetype ="1";
        
        for (int i = 0; i < rdpList.size(); i++){
            Map<String, String> params = new HashMap<String, String>();
            params.put("detailno", "'" + Utility.getName(rdpList.get(i).getScrrdpayfeeno()) + "'");
            params.put("goodstype", "'" + Utility.getName(rdpList.get(i).getScrrdpayfeeid()) + "'");
            params.put("goodsmoney","'" + Utility.getName(rdpList.get(i).getScrrdmoney()) + "'");
            
            paramsArray[i] = params.toString();
 
        }
        obj.element("goodsinfo", paramsArray);
        obj.element("interfaceID", "3");
        
        //获取JSON字符串
        String paramStr = obj.toString();
		
        //type==2,表示退款
        if("2".equals(type)){
        	chargetype = "4";
		}
        
        //新增待缴费记录
        HisParamPo hisParamPo = new HisParamPo(uid,billid,createtime,"",posid,posname,chargetype,type);        
		
        //新增调用接口日志
		HisLogPo hisLogPo = new HisLogPo();
		hisLogPo.setHisloginparam(paramStr); // 入参
        
		try {
			
			//调用接口
			String resultStr = HttpPostJSON.postJSON(ppo.getBdplinkhisurl() + URLEncoder.encode(paramStr,"UTF-8"));
			//String resultStr = HttpPostJSON.postJSON(ppo.getBdplinkhisurl() + paramStr); //原版方法，测试HIS无法使用;
			hisLogPo.setHislogreturnparam(resultStr); // 返回值
			
 			HisParamPo paramPo = new HisParamPo();
			if(resultStr.contains("{")||resultStr.contains("}")){

				paramPo = this.toObject(resultStr,paramPo);
				 
				if (Utility.getName(paramPo.getResultCode()).equals("0"))
				{
					// 更新提交失败的状态
					hisParamPo.setFlag("2");
				}
			}else{hisParamPo.setFlag("2");}
			
		} catch (UnsupportedEncodingException e1) {
			hisParamPo.setFlag("2");
			hisLogPo.setHislogreturnparam("编码异常-长度"+paramStr.length()); // 返回值
		}catch(Exception e) {
			hisParamPo.setFlag("2");
		}
		 
		int count = hisParamDao.getHisParamPoCountByBillid(hisParamPo);
        if(count == 0){
        	hisParamDao.insertSaleInfoToHis(hisParamPo);
        } 
        
		hisLogPo.setHislogdepatmentid(Utility.getName(logPo.getsLogDepartmentID())); // 调用部门ID
		hisLogPo.setHislogpersonid(Utility.getName(logPo.getsLogName())); // 调用人ID
		hisLogPo.setHisloginterfaceid("3"); // 接口ID
		hisLogPo.setHislogmoduleid(Utility.getName(logPo.getsLogResult())); // 所属模块ID	
		hisLogPo.setHislogip(Utility.getName(logPo.getsLogIP())); // IP地址

		hisLogPoDao.insertHisLog(hisLogPo);  //新增日志
		
		//新增系统操作日期
		logisticsLogDao.insertLog(logPo);
		
	}
	
	/**
	 * 1. 接口名称：HIS系统作废待交费用接口
	 * 2. 参       数：billid 缴费单号
	 *             hisLogPo 调用日志
	 */
	public String updateSalesBillStateByHis(String url){
			
			String str = HttpPostJSON.postJSON(url);
       if(str.contains("{")||str.contains("}")){
    	   return "1";
       } 
       return "0";
	}
	/**
	 * 接口6)
	 * 
	 * 1. 接口名称：视光系统提供挂号退费成功确认接口
	 * 2. 用       途：HIS调用接口反刷患者在视光系统验光退费状态
	 */
	public void updateCustOptStaOKByHis(HisParamPo hisParamPo) {
		 
		hisDao.updateCustOptStaOKByHis(hisParamPo);
	}
	
	/**
	 * 
	 * 视光系统挂号退费确认接口调用记录日志
	 * @param hisLogPo
	 */

	public void updateLog(HisLogPo hisLogPo) {
		hisLogPoDao.insertHisLog(hisLogPo);  //新增日志		
	}
	
	/**
	 * 1. 用          途：根据配镜单号查询商品明细中是否存在未设置收费明细的商品
	 * 2. 参          数：billid 缴费单号
	 */
	public List<SalesDetailPo> getSalesDetailNotSetPayFeeList(String billid){
		return hisDao.getSalesDetailNotSetPayFeeList(billid);
	}
	
	/**
	 * 1. 用          途：解析JSON，将其转成PO
	 * 2. 入          参：jsonString   JSON字符串
	 *              hisParamPo  需要将解析后的JSON封装的PO
	 * 3. 返回值：将JSON其转成的PO
	 */
	public HisParamPo toObject(String jsonString, HisParamPo hisParamPo) throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
        
		return (HisParamPo) objectMapper.readValue(jsonString, hisParamPo.getClass());
	}
 
	public int getChargeCount(HisParamPo po) {
		 
		return hisDao.getChargeCount(po);
	}
	
	
}
