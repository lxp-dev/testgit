<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定时任务维护</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function update(id,name,index){

		$('input[date=date]').attr('noValidate','noValidate');	
		$('input[id=startTime'+index+']').removeAttr('noValidate');
		$('input[id=endTime'+index+']').removeAttr('noValidate');
		
		if(checkForm(reportForm)){
	    	var bgndate = document.getElementById('startTime' + index).value;
	    	var enddate = document.getElementById('endTime' + index).value;
			
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initReportQuartzDataUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}&bgndate="+bgndate+"&enddate="+enddate+"&name="+EncodeUtf8(name),550,190,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initReportQuartzDataUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}&bgndate="+bgndate+"&enddate="+enddate+"&name="+EncodeUtf8(name),550,190,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【定时任务--数据更新】";
		}
	}

    function yesterday(bgnDate,endDate){
    	document.getElementById(bgnDate).value = '${tBgnDate }';
    	document.getElementById(endDate).value = '${tEndDate}';
    }

    function clean(bgnDate,endDate){
    	document.getElementById(bgnDate).value = '';
    	document.getElementById(endDate).value = '';
    }

	function detail(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initReportQuartzDataDetail.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReportQuartzDataDetail.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【定时任务执行情况查看】";
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="reportForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="tBgnDate" name="tBgnDate" value="${tBgnDate }">
<input type="hidden" id="tEndDate" name="tEndDate" value="${tEndDate}">

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：定时任务维护 </TD>
            <td align="right" valign="bottom">&nbsp;
                <img src="${ctx }/img/newbtn/btn_dsrwzxqkck_0.png" btn=btn title="执行日志查看" onClick="detail()">
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                   <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <c:if test="${(permissionPo.keyd==1)}">
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="3%" height="26" scope=col>编号</TH>
                          <TH width="25%" scope=col>定时任务名称</TH>
                          <TH width="15%" height="26" scope=col>执行时间</TH>
                          <TH width="25%" height="26" scope=col>汇总日期</TH>                          
                          <TH width="6%" scope=col>操作</TH>                          
                        </TR>
                        <s:iterator value="moduleList" status="idx">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>${quartzReferReportCount}</TD>
                          <TD title="${modulecname}">${reportName}</TD>
                          <TD>${quartzExecuteTime}</TD>
                          <TD align="center">
                          <li class="horizontal_onlyRight">	                           
	                           <input id="startTime${idx.index}" date=date 
							       name="startTime${idx.index}" 
							       type="text" class="text_input80" clean=clean validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择起始日期!'}]" 
							       onFocus="WdatePicker({isShowToday:false,readOnly:true, maxDate:'#F{$dp.$D(\'endTime${idx.index}\')||$dp.$D(\'tBgnDate\')}'})"/> 至 
						       <input id="endTime${idx.index}" clean=clean 
							       name="endTime${idx.index}" date=date 
							       type="text" class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择截止日期!'}]"
							       onfocus="WdatePicker({isShowToday:false,readOnly:true, minDate:'#F{$dp.$D(\'startTime${idx.index}\')}', maxDate:'#F{$dp.$D(\'tEndDate\')}'})" />
					       </li>
					       <li class="horizontal_onlyRight">    
							   <img src="${ctx }/img/newbtn/btn_yesterday_0.png" btn=btn title="昨天" onClick="yesterday('startTime${idx.index}','endTime${idx.index}')">							  
						   </li>
						   					       <li class="horizontal_onlyRight">    
							   <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean('startTime${idx.index}','endTime${idx.index}')">							  
						   </li>
						  </TD>
		                  <TD width="3%" height="26">
		                  	<c:if test="${permissionPo.keyc==1 }">
		                  		<img src="${ctx }/img/newbtn/replace_0.png" btn=btn title='重新汇总' onClick="javascript:update('${reportID}','${reportName}','${idx.index}')">
		                  	</c:if>
		                  </TD>
                        </TR>
                        </s:iterator>                                  
                      </TBODY>
                    </TABLE>
     									
                    </c:if>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>