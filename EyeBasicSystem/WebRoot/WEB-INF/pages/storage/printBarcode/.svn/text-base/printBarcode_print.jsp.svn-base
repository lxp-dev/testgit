<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${ctx}/js/jquery.qrcode.min.js"></script>

<script src="${ctx}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.qrcode.js"></script>
<script type="text/javascript" src="${ctx}/js/qrcode.js"></script>
<script type="text/javascript" src="${ctx}/js/print.js"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script>
	function printBarcode(){
		
	}


    $(document).ready(function(){
    	var pageweight = document.body.clientWidth;
    	/*var pageheight = document.body.clientHeight;
    	var Spacing = 10;
    	
    	var theignt = $("#theignt",opener.document).val();
		var tweight = $("#tweight",opener.document).val();*/
		
		var tdsize = parseInt(pageweight / (100 + 10));
		
		
		
		
		var arrayObj = [{'a':'1'},{'a':'2'},{'a':'3'}, {'a':'4'}, {'a':'5'},{'a':'6'}, {'a':'7'},{'a':'8'},  {'a':'9'}, {'a':'10'}];  
		
		var barcodenumber = arrayObj.length;

    	var qrcodeTable = $('#qrcodeTable');		
		for(var i = 0; i < barcodenumber; i++){
			var row = $("<tr></tr>");
			for(var j = 0; j < tdsize; j++){
				var td = $("<td weight='200px'></td>");
				td.qrcode({
		       		render  : "table",
		       		text    : "12135433a321321s54654",
		       		width   : 80,
		       		height  : 80
				});
		    	row.append(td);
			}
			qrcodeTable.append(row);
		}
		
		
		//var td = $("<td></td>"); 
		
	     
    }); 
</script>
<html>
  <head>
  </head>
  
  <body>
  	<div id=qrcodeTable1></div>
  	<input type="button" value="打印" onclick="printBarcode();"/>
    <table id=qrcodeTable></table>
    
  </body>
</html>
