<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${companyNamePo.fcnName }</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />
</head>
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function save(wieintegral,goodsid,obj){
		var goodsnumber = $(obj).parent().find("#goodsnumber").val();
		var integral = wieintegral;
		if((parseFloat(goodsnumber)*parseFloat(integral)) > parseFloat('${customerInfoPo.smeciintegral }')){
			alert("所用积分不足！");
			return;
		}else{
			$("#xcintegral").val(parseFloat(goodsnumber)*parseFloat(integral));
			$("#xgoodsid").val(goodsid);
			$("#xgoodsnumber").val($(obj).parent().find("#goodsnumber").val());
			$("#xintegral").val(integral);
			$("#wiedepartmentid").val($(obj).parent().find("#departmentid").val());
		}
		
		departmentstForm.action = "updateWeiXinIntegralConvertView.action";
		departmentstForm.submit();
	}
	function selectGoodsNum(wieintegral,goodsid,obj){
		$.ajax({           
	   	 	type: "POST",          
   	   	    url: "IntegralSelectGoodsNum.action",          
   	   	    async: true, 
   	   	    data: "hid=${openID }&goodsid="+goodsid+"&goodsNum="+$(obj).parent().find("#goodsnumber").val()+"&depID="+$(obj).parent().find("#departmentid").val(),     
   	   	    success: function(msg){
	   	   		if(msg.trim() == "1"){
	   	   			save(wieintegral,goodsid,obj);
		   	   	}
		   	   	if(msg.trim() == "2"){
		   	   		alert("该部门已停用,请重新选择门店!");
		   	   	}
		   	   	if(msg.trim() == "0"){
			   	   	alert("此商品以不能再兑换,请重新选择商品！");
		   	   	}       
   	   	    }    
	   	});
	}
</script>
<body class="bg_color">
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="xcustomerid" value="${customerInfoPo.smecicustomerid }">
<input type="hidden" name="xopenid" value="${openID }"/>
<input type="hidden" name="xyintegral" value="${customerInfoPo.smeciintegral }"/>
<input type="hidden" id="xcintegral" name="xcintegral" value=""/>
<input type="hidden" id="xgoodsid" name="xgoodsid" value=""/>
<input type="hidden" id="xgoodsnumber" name="xgoodsnumber" value=""/>
<input type="hidden" id="xintegral" name="xintegral" value=""/>
<input type="hidden" id="wiedepartmentid" name="wiedepartmentid" value=""/>
<div class="title">积分兑换</div>
<div class="jifen_left">
<span class="jifen_txt">当前积分:${customerInfoPo.smeciintegral }<span class="font_txt">可兑换如下商品:</span></span></div>
<table width="100%" border="0" cellspacing="2" cellpadding="0">
 
  <s:iterator value="goodsInfoPos">
  <tr height="25">
    <td class="jifen_tit" width="13%" bgcolor="#FFFFFF">兑换简称</td>
    <td align="center" width="5%"  bgcolor="#FFFFFF">
    	<input type="hidden" id="goodsid" value="${bgigoodsid }"/>
    	${bgigoodsname }
    </td>
    <td class="jifen_tit" width="13%" bgcolor="#FFFFFF">所需积分</td>
    <td align="center" bgcolor="#FFFFFF" width="12%" colspan="3">${bgiIntegralCount }<input type="hidden" id="wieintegral" name="weiXinIntegralSelectPo.wieintegral" value="${bgiIntegralCount }"/></td>
    </tr>
    
    <tr>
     <td class="jifen_tit" width="12%" bgcolor="#FFFFFF">兑换数量</td>
     <td align="center" bgcolor="#FFFFFF">
    	<input style="width: 40px;"  id="goodsnumber" name="goodsnumber" value="1">
    	
    </td>
     <td class="jifen_tit" width="12%" bgcolor="#FFFFFF">兑换门店</td>
      <td align="center" bgcolor="#FFFFFF">
    	<select clean=clean id="departmentid" name="departmentid" >
	                             	<c:if test="${not empty(departmentsList)}" >
					               	  <s:iterator value="departmentsList">
	                    	           <OPTION value="${bdpdepartmentid}"  >${bdpdepartmentname}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
      	                   </select>
    </td>
    
    <td align="center" bgcolor="#FFFFFF" onclick="selectGoodsNum('${bgiIntegralCount }','${bgigoodsid }',this)"><u>兑换</u></td>
  </tr>
  </s:iterator>
</table>
<p>&nbsp;</p>
</form>
</body></html>