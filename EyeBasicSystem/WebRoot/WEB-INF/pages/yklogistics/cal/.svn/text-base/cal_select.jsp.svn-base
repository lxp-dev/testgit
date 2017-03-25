<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>成本计算管理</title>
</head>
<script>

    //加权平均计算
    var isAvgCal = 0;
    //成本计算
    var isCostCal = 0;
    
	function realCalStorage(){
		var currDate="";
		var lastDate="";
		var month = new Date().getMonth();
		
		if($('#month')[0].selectedIndex - month > 0 || $('#month')[0].selectedIndex - month < -1){
			alert("此月无法进行加权平均计算!");
			return;
		}
		
		if(confirm('确定进行加权平均计算')){
			if ($('#month').val() < 10){
			    currDate=$('#year').val()+'-0'+$('#month').val();
			    lastDate=$('#year').val()+'-0'+($('#month').val() - 1);
			}else{
			    currDate=$('#year').val()+'-'+$('#month').val();
			    if ($('#month').val() - 1 < 10){
			        lastDate=$('#year').val()+'-0'+($('#month').val() - 1);
			    }else{
			        lastDate=$('#year').val()+'-'+($('#month').val() - 1);
			    }
			}
			
			document.getElementById("btn1").disabled = "0";
			document.getElementById("btn2").disabled = "0";
            //document.getElementById("btn3").disabled = "0";
            document.getElementById("btn4").disabled = "0";

			$('select').each(function(){
			    $(this).attr("disabled","disabled");
			});
			
			isAvgCal = 1;
			
			calForm.action="realCalStorage.action?currDate="+currDate+"&lastDate="+lastDate+"&isAvgCal="+isAvgCal+"&moduleID=${moduleID}";
			calForm.submit();
			showLoadingBar();
		}
	}
	function moniCalRetrun(){
		var month = new Date().getMonth();		
		if($('#month')[0].selectedIndex - month > 0 || $('#month')[0].selectedIndex - month < -1){
			alert("此月无法进行加权平均计算!");
			return;
		}
		
		if (${isAvgCal != 1}){
		    alert("请先进行加权平均计算!");
			return; 
		}
		
		if(confirm('确定进行成本计算')){
			document.getElementById("btn1").disabled = "0";
			document.getElementById("btn2").disabled = "0";
            //document.getElementById("btn3").disabled = "0";
            document.getElementById("btn4").disabled = "0";
			$('select').each(function(){
			    $(this).attr("disabled","disabled");
			});
			
			var date='';
			if ($('#month').val() < 10){
			    date=$('#year').val()+'-0'+$('#month').val();
			}else{
			    date=$('#year').val()+'-'+$('#month').val();
			}
			
			isAvgCal = 1;	
			isCostCal = 1;
			
		    calForm.action="moniCalRetrun.action?date="+date+"&isCostCal="+isCostCal+"&isAvgCal="+isAvgCal+"&moduleID=${moduleID}";
		    calForm.submit();
		    showLoadingBar();
		}
	}
	
	function realCalRetrun(){
		var month = new Date().getMonth();		
		if($('#month')[0].selectedIndex - month > 0 || $('#month')[0].selectedIndex - month < -1){
			alert("此月无法进行加权平均计算!");
			return;
		}
		
		if (${isAvgCal != 1}){
		    alert("请先进行加权平均计算!");
			return; 
		}
		if (${isCostCal != 1}){
		    alert("请先进行成本计算!");
			return; 
		}
		
		if(confirm('确定进行成本回填')){
			var date='';
			if ($('#month').val() < 10){
			    date=$('#year').val()+'-0'+$('#month').val();
			}else{
			    date=$('#year').val()+'-'+$('#month').val();
			}	
			document.getElementById("btn1").disabled = "0";
			document.getElementById("btn2").disabled = "0";
            //document.getElementById("btn3").disabled = "0";
            document.getElementById("btn4").disabled = "0";
			$('select').each(function(){
			    $(this).attr("disabled","disabled");
			});
			
			calForm.action="realCalReturn.action?date="+date+"&moduleID=${moduleID}";
			calForm.submit();
			showLoadingBar();
		}
	}
	
	function moniSelect(){
	    var month = new Date().getMonth();
		if($('#month')[0].selectedIndex - month > 0 || $('#month')[0].selectedIndex - month <= -1){
			alert("此月无法进行加权平均计算!");
			return;
		}
			
	    var date="";
	    if ($('#month').val() < 10){
		    date=$('#year').val()+'-0'+$('#month').val();
		}else{
		    date=$('#year').val()+'-'+$('#month').val();
		}		
		showPopWin("","initMoniSelect.action?date="+date+"&moduleID=${moduleID}",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	$(document).ready(function(){	   
		var date='${date}'.substring(5,7);
		var month = new Date().getMonth();
		if(date == ''){		    
			$('#month')[0].selectedIndex = month;
		}else{
			$('#month')[0].selectedIndex = accAdd(date,'-1');
		}
		
	});
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form method="post" name="calForm">
<input id="isAvgCal" name="isAvgCal" type="hidden" value="${isAvgCal}">
<input id="isCostCal" name="isCostCal" type="hidden" value="${isCostCal}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;成本计算管理</TD>
          <TD class=menubar_readme_text vAlign=bottom></TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：成本计算</TD>
          <TD class=menubar_function_text align=right>&nbsp;</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">成本计算</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
							<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

                    <TABLE id="searchBar" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <p>
                            <span class="table_none">
							   	<select id="year" name="year" >      		                          
      		                        <c:forEach var="i" begin="2011" end="${currentYear}" step="1"> 
                                      <option value="${i}" ${currentYear == i ? 'selected="selected"' : ''}>${i}</option>
      		                        </c:forEach>      		                 
      	                        </select>								
						  		<select id="month" name="month">
      		                        <c:forEach var="i" begin="1" end="12" step="1"> 
                                      <option value="${i}" ${currentMonth == i ? 'selected="selected"' : ''}>${i}</option>
      		                        </c:forEach>             
      	                        </select>
                            </span>
                            </p>
                            <p>
                                <input id="btn1" type='button' onClick="realCalStorage()" value="加权平均" icon='icon-edit'>
						  <br/><br/>
                                <input icon='icon-edit' id="btn2" type='button' value="成本计算" onClick="moniCalRetrun()">
                               <!-- <input icon='icon-edit' id="btn3" type='button' value="上月成本查询" onClick="moniSelect()"> --> 
						  <br/><br/>
                                <input icon='icon-edit' id="btn4" type='button' value="成本回填" onClick="realCalRetrun()">
						   <br/><br/>
                              </p></TD></TR>
                      </TBODY>
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>