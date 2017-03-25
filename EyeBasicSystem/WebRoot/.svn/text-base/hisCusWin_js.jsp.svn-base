<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<script language="javascript">

$(function(){
     // 银台结款、退款管理、欠款管理、无配镜单管理、打印配镜单 、打印处方、更改结款方式、积分兑换、中心挂号、打印挂号费、维修收费、无库存销售、旧镜检查、基础版和爱尔的视光检查和眼部健康检查
     
     if('${systemParameterPo.fsphisflag}' == '2'){
        if('${person.bdplinkhisflag}' == '0' && '${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){ //部门不连接HIS 
	        $("img[his=his]").hide();
        }else{
	     	$("img[his=his]").siblings("img").hide();
		 	$("img[his=his]").click(function(){
		 	    if('${person.bdplinkhisflag}' == '0'){
			 		initselCustomerHIS('${person.bdpreadcardform}','0');//1是从HIS读取会员信息；0是只从视光
		 	    }else{
			 		initselCustomerHIS('${person.bdpreadcardform}','1');//1是从HIS读取会员信息；0是只从视光
		 	    }
		 	});
		 	 
        }
      }else if('${systemParameterPo.fsphisflag}' == '0'){
        if('${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){
	        $("img[his=his]").hide();
        }else{
    	    $("#smecimemberid").attr("readonly",true);
	     	$("img[his=his]").siblings("img").hide();
		 	$("img[his=his]").click(function(){
		 		initselCustomerHIS('${person.bdpreadcardform}','0');//1是从HIS读取会员信息；0是只从视光
		 	});
        }  
      }
     
     //连HIS后不能使用  中心挂号和维修收费 
     if('${systemParameterPo.fsphisflag}' == '2'){
	     
	     if('${person.bdplinkhisflag}' == '0' && '${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){
	    	 $("img[hisn=hisn]").hide();
	     }else if('${person.bdplinkhisflag}' == '1'){
	         $("img[hisn=hisn]").hide();
	     }else{
	    	 $("#smecimemberid").attr("readonly",true);
	     	 $("img[hisn=hisn]").siblings("img").hide();
		 	 $("img[hisn=hisn]").click(function(){
		 		initselCustomerHIS('${person.bdpreadcardform}','0');//1是从HIS读取会员信息；0是只从视光
		 	 });
		 }
     }else{
         $("img[hisn=hisn]").hide();
     }
     
	 //会员模块、销售、验光使用(连接HIS)
     if('${systemParameterPo.fsphisflag}' == '2'){
		 if('${person.bdplinkhisflag}' == '0' && '${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){
			 $("img[hiss=hiss]").hide();
		 }else{
			 $("#smecimemberid").attr("readonly",true);
		     $("img[hiss=hiss]").siblings("img").hide();
			 $("img[hiss=hiss]").click(function(){
			    if('${person.bdplinkhisflag}' == '0'){
				 	initselCustomerHIS('${person.bdpreadcardform}','0');
			    }else{
				 	initselCustomerHIS('${person.bdpreadcardform}','1');
			    }
			 });
		 }
     
     }else if('${systemParameterPo.fsphisflag}' == '0'){
    	 if('${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){
			 $("img[hiss=hiss]").hide();
         }else{
			 $("#smecimemberid").attr("readonly",true);
			 $("img[hiss=hiss]").click(function(){
			 	initselCustomerHIS('${person.bdpreadcardform}','0');
			 });
         }
     }
     
	 //销售门店 title页专用(连接HIS)
	 if('${systemParameterPo.fsphisflag}' == '2'){
	 
	     if('${person.bdplinkhisflag}' == '0' && '${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){
			 $("img[hisy=hisy]").hide();
		 }else{
			 
			 $("#smecimemberid").attr("readonly",true);
			 $("img[hisy=hisy]").click(function(){
			    if('${person.bdplinkhisflag}' == '0'){
			 		initselCustomerHIS('${person.bdpreadcardform}','0');
			    }else{
			 		initselCustomerHIS('${person.bdpreadcardform}','1');
			    }
			 });
		 }
	 }else if('${systemParameterPo.fsphisflag}' == '0'){
	     if('${person.bdpreadcardform}' == 'initSCIHISsaomaWin.action'){
			 $("img[hisy=hisy]").hide();
		 }else{
			 $("#smecimemberid").attr("readonly",true);
			 $("img[hisy=hisy]").click(function(){
			 	initselCustomerHIS('${person.bdpreadcardform}','0');
			 });
		 }    
		 
	 }
	 
});
//读卡器：initSCIHISdukaWin.action
//扫 码 ：initSCIHISsaomaWin.action
// 初始化连接HIS后会员查询开窗
function initselCustomerHIS(str,pflag){
 
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
 
	if(is_iPad()){
		showPopWin(str+"?pflag="+pflag+"&moduleID=${moduleID}",350,100,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin(str+"?pflag="+pflag+"&moduleID=${moduleID}",350,100,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【卡片扫描】";
}


function selCustomerHIS(url,str,targetpage,pflag){
	location.href = url+"?moduleID=${moduleID}&targetpage="+targetpage+"&cardno="+str+"&pflag="+pflag;
}

function CustMessage(){
	alert("门店已连接HIS,无法使用此功能!");		
}
 
	

</script>
</html>