 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统上线数据清理</title>
<script>

    //清除库存数据
	function clearStorageData(){
		var btn1 = document.getElementById("btn1");
		if (btn1 != null){
		    btn1.disabled = "0";
		}
		var btn2 = document.getElementById("btn2");
		if (btn2 != null){
		    btn2.disabled = "0";
		}
		var btn3 = document.getElementById("btn3");
		if (btn3 != null){
		    btn3.disabled = "0";
		}
		var btn4 = document.getElementById("btn4");
		if (btn4 != null){
		    btn4.disabled = "0";
		}
	    $("img").removeAttr("onclick");
        systemClearFrm.action = "clearStorageData.action";
        systemClearFrm.submit();
	}
	
	//备份数据
	function insertDataBaseData(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDataBaseBackupInsert.action?flag1="+$('#flag1').val()+"&flag2="+$('#flag2').val()+"&flag5="+$('#flag5').val()+"&flag4="+$('#flag4').val()+"&moduleID=${requestScope.moduleID}",500,155,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【备份数据】"
	}
	
	//系统上线日期
	function initSystemDate(id,enable){
	    if ($('#systemOnLineDate').val() == ''){
	        alert("请选择系统正式上线日期!");
	        return;
	    }
		var btn1 = document.getElementById("btn1");
		if (btn1 != null){
		    btn1.disabled = "0";
		}
		var btn2 = document.getElementById("btn2");
		if (btn2 != null){
		    btn2.disabled = "0";
		}
		var btn3 = document.getElementById("btn3");
		if (btn3 != null){
		    btn3.disabled = "0";
		}
		var btn4 = document.getElementById("btn4");
		if (btn4 != null){
		    btn4.disabled = "0";
		}
	    $("img").removeAttr("onclick");
        systemClearFrm.action = "updateSystemOnLineDate.action";
        systemClearFrm.submit();
	}
	
	//初始化账期数据
	function initPaymentData(){
		var btn1 = document.getElementById("btn1");
		if (btn1 != null){
		    btn1.disabled = "0";
		}
		var btn2 = document.getElementById("btn2");
		if (btn2 != null){
		    btn2.disabled = "0";
		}
		var btn3 = document.getElementById("btn3");
		if (btn3 != null){
		    btn3.disabled = "0";
		}
		var btn4 = document.getElementById("btn4");
		if (btn4 != null){
		    btn4.disabled = "0";
		}
	    $("img").removeAttr("onclick");
	    systemClearFrm.action = "insertPayMentDate.action";
        systemClearFrm.submit();
	}
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
    
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="systemClearFrm">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="flag1" name="flag1" value="${flag1}">
<input type="hidden" id="flag2" name="flag2" value="${flag2}">
<input type="hidden" id="flag3" name="flag3" value="${flag3}">
<input type="hidden" id="flag4" name="flag4" value="${flag4}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="20%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统期初维护</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：数据清理</TD>
            <td align="right" width="40%" valign="bottom"></td>
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
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
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
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 id="title1">
		                      <TBODY>
	                           <TR class=table_title align=middle>
		                          <TH width="18%" height="26" scope=col>步骤</TH>
								  <th width="29%">描述</th>
								  <c:if test="${(permissionPo.keya == 1)}">
		                              <TH width="10%" scope=col>执行</TH>
		                          </c:if>		                          
		                       </TR>
		                       <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" align=middle>
		                          <Td width="18%" height="30" scope=col>第一步:</Td>
								  <td width="29%">备份重要数据</td>
								  <c:if test="${(permissionPo.keya == 1)}">
		                              <Td width="9%" scope=col>
		                              <c:choose>
		                                  <c:when test="${systemOnLineFlag == '1'}">系统已上线,无法执行此功能!</c:when>
		                                  <c:when test="${systemOnLineFlag != '1' && flag1 == '1'}">执行完毕!</c:when>
		                                  <c:otherwise><img btn=btn id="btn1" src="${ctx }/img/newbtn/zhixing_0.png" title='执行' onClick="insertDataBaseData()"></c:otherwise>
		                              </c:choose>
		                              </Td>
		                          </c:if>		                          
		                       </TR>
		                       <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" align=middle>
		                          <Td width="18%" height="26" scope=col>第二步:</Td>
								  <td width="29%">根据商品实盘数产生商品期初库存并删除试运行阶段产生的数据</td>
								  <c:if test="${(permissionPo.keya == 1)}">
		                              <Td width="9%" scope=col>
		                              <c:choose>
		                                  <c:when test="${systemOnLineFlag == '1'}">系统已上线,无法执行此功能!</c:when>
		                                  <c:when test="${systemOnLineFlag != '1' && flag2 == '1'}">执行完毕!</c:when>
		                                  <c:otherwise>
		                                  <img btn=btn id="btn2" src="${ctx }/img/newbtn/zhixing_0.png" title='执行' onClick="clearStorageData()"></c:otherwise>
		                              </c:choose>		                              
		                              </Td>
		                          </c:if>		                          
		                       </TR>
		                       <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" align=middle>
		                          <Td width="18%" height="26" scope=col>第三步:</Td>
								  <td width="29%">系统上线日期 </td>
								  <c:if test="${(permissionPo.keya == 1)}">
		                              <Td width="9%" scope=col>
		                              <c:choose>
		                                  <c:when test="${systemOnLineFlag == '1'}">系统已上线,无法执行此功能!</c:when>
		                                  <c:when test="${systemOnLineFlag != '1' && flag3 == '1'}">执行完毕!</c:when>
		                                  <c:otherwise>
		                                  
		                   <li class="horizontal_onlyRight">
		                   <input id="systemOnLineDate"
					       name="systemOnLineDate"
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd', minDate:'#F{$dp.$D(\'endDate\')}'})"
					       value="${systemOnLineDate }" /> 
					       <input type="hidden" id="endDate"  value="${endDate }"/>
		                              </li>
		                              <li class="horizontal_onlyRight">		                    
		                              <img btn=btn id="btn3" src="${ctx }/img/newbtn/zhixing_0.png" title='执行' onClick="initSystemDate()">
		                              </li>
		                                  
		                                  </c:otherwise>
		                              </c:choose>
		                              
                                   </Td>
		                          </c:if>		                          
		                       </TR>
		                       <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" align=middle>
		                          <Td width="18%" height="26" scope=col>第四步:</Td>
								  <td width="29%">初始化账期数据</td>
								  <c:if test="${(permissionPo.keya == 1)}">
		                              <Td width="9%" scope=col>
		                              <c:choose>
		                                  <c:when test="${systemOnLineFlag == '1'}">系统已上线,无法执行此功能!</c:when>
		                                  <c:when test="${systemOnLineFlag != '1' && flag4 == '1'}">执行完毕!</c:when>
		                                  <c:otherwise>
		                                  
		                                <li class="horizontal_onlyRight">
										   	<select id="payMentYear" name="payMentYear">      		                          
			      		                        <c:forEach var="i" begin="2011" end="${currentYear}" step="1"> 
			                                      <option value="${i}" ${payMentYear == i ? 'selected="selected"' : ''}>${i}</option>
			      		                        </c:forEach>      		                 
			      	                        </select>								
									  		<select id="payMentMonth" name="payMentMonth">
			                                      <option value="01" ${payMentMonth == '01' ? 'selected="selected"' : ''}>01</option>
			                                      <option value="02" ${payMentMonth == '02' ? 'selected="selected"' : ''}>02</option>
			                                      <option value="03" ${payMentMonth == '03' ? 'selected="selected"' : ''}>03</option>
			                                      <option value="04" ${payMentMonth == '04' ? 'selected="selected"' : ''}>04</option>
			                                      <option value="05" ${payMentMonth == '05' ? 'selected="selected"' : ''}>05</option>
			                                      <option value="06" ${payMentMonth == '06' ? 'selected="selected"' : ''}>06</option>
			                                      <option value="07" ${payMentMonth == '07' ? 'selected="selected"' : ''}>07</option>
			                                      <option value="08" ${payMentMonth == '08' ? 'selected="selected"' : ''}>08</option>
			                                      <option value="09" ${payMentMonth == '09' ? 'selected="selected"' : ''}>09</option>
			                                      <option value="10" ${payMentMonth == '10' ? 'selected="selected"' : ''}>10</option>
			                                      <option value="11" ${payMentMonth == '11' ? 'selected="selected"' : ''}>11</option>
			                                      <option value="12" ${payMentMonth == '12' ? 'selected="selected"' : ''}>12</option>
			      	                        </select>
			      	                    </li>
			                            <li class="horizontal_onlyRight">
		                                <img btn=btn id="btn4" src="${ctx }/img/newbtn/zhixing_0.png" title='执行' onClick="initPaymentData()">
		                                </li>
		                                  
		                                  </c:otherwise>
		                              </c:choose>	
		                              

		                             </Td>
		                          </c:if>		                          
		                       </TR>
	                      </TBODY>
	                    </TABLE>
				 
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    </form>
    </BODY>
</html>