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
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<script>
	function link(id){
		departmentstForm.action = "initUserDepartmentsDetail.action?id="+id;
		departmentstForm.submit();
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
	/***用户打开页面的时候就加载**/
	$(document).ready(function(){
		initPage();
	});
	
	function initPage() {
		
		var obj = JSON.parse('${jsonResult}');
		wx.config({
		          debug: false,
		          appId: obj.appid,
		          timestamp:obj.timestamp,
		          nonceStr:obj.nonceStr,
		          signature:obj.signature,
		          jsApiList: [
		          'getLocation',
		          ]
		      });      
		
	};

	wx.ready(function(){
		wx.getLocation({
		    success: function (res) {
		        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
		        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
		        var speed = res.speed; // 速度，以米/每秒计
		        var accuracy = res.accuracy; // 位置精度
		        //alert("http://mysflying.vicp.net/eims/initWeiXinUserDepartmentsListShow.action?locationx="+latitude+"&locationy"+longitude);
		     	location.href="${eims_Url}/initWeiXinUserDepartmentsListShow.action?locationx="+latitude+"&locationy="+longitude;
		    },
		    cancel: function (res) {
		        alert('用户拒绝授权获取地理位置');
		    }
		});
	});
	
	wx.checkJsApi({
	    jsApiList: [
	        'getLocation'
	    ],
	    success: function (res) {
	         //alert(JSON.stringify(res));
	         //alert(JSON.stringify(res.checkResult.getLocation));
	         
	        if (res.checkResult.getLocation == false) {
	            alert('你的微信版本太低，不支持微信JS接口，请升级到最新的微信版本！');
	            return;
	        }
	    }
	});
	
</script>
</html>