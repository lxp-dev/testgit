<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function setReportEvent(fineReportRequestString,reportingServiceRequestString,reportFileName,reportServer,reportTitle,showtype){
		switch(reportServer)
		{
		case "1":
		  fineReportEvent(fineReportRequestString,reportFileName,reportTitle,showtype);
		  break;
		case "2":
		  reportingServiceEvent(reportingServiceRequestString,reportFileName,reportTitle,showtype);
		  break;
		default:
		  alert("单据配置异常！");
		}				
	}

	function fineReportEvent(requestString,reportFileName,reportTitle,showtype){
		var url="report.action?__bypagesize__=false&reportlet="+ reportFileName + requestString;
		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}			
			document.getElementById('popupTitle').innerHTML="【"+ reportTitle +"】";
		  break;
		case "2":
			window.open (url, reportTitle, 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}			
    }

    function reportingServiceEvent(requestString,reportFileName,reportTitle,showtype){
    	var url = '<%= getServletContext().getInitParameter("rptUrl")%>'+"eims_reporting/"+reportFileName + "&rs:Command=Render" + requestString; 
		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}			
			document.getElementById('popupTitle').innerHTML="【"+ reportTitle +"】";
		  break;
		case "2":
			window.open (url, reportTitle, 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}	
    }
</script>
<img src="${actionImgUrl }" btn=btn style="cursor: hand;" title="打印单据" onClick="setReportEvent('${actionFinereportRequestString}','${actionReportingServiceRequestString}','${fittingTemplateTypePo.bftfilename}','${fittingTemplateTypePo.bftserver}','${actionReportTitle}','${fittingTemplateTypePo.bfttshowtype}');"></td>