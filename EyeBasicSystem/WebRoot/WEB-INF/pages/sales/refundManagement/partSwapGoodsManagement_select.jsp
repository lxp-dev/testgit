<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }
	});
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}
	
	function pay2(json,flag,ssesbhandlestate,id,handlestatecount,flag2,flag3){

        if ('${systemParameterPo.fsphisflag}' == '2' && '${person.bdplinkhisflag}' == '1' && flag2 == '0' && flag3 != '0'){
        	alert('此单收费项目HIS系统中未退费，不能退费!');
            return;
        }
        
		if('${bwcflag}' == ''){
			alert("请设置门店退款仓位!");
			return;
		}
		if(flag == '1'){
			alert("配镜单已欠费,请先缴费!");
			return;
		}

		if('${systemParameterPo.fsprefundcomplainflag}' == '1'){

			if (handlestatecount == '0'){
				if ('${permissionPo.keyf}' == '1'){
					if (confirm('退款前请先进行投诉处理！')){
						var topRows = top.document.getElementById("total").rows;
						var topCols = top.document.getElementById("btmframe").cols;
						if(is_iPad()){
							showPopWin("initInsertRefunComplain.action?moduleID="+$('#moduleID').val()+"&billID="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
						}else{
							showPopWin("initInsertRefunComplain.action?moduleID="+$('#moduleID').val()+"&billID="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
						}
						document.getElementById('popupTitle').innerHTML="【会员投诉新增】";						
					}
					return;
			    }else{
                    alert('退款前请先进行投诉处理！');
                    return;
				}
		    }else if (ssesbhandlestate != '2'){
                alert('当前配镜单的投诉正在处理！');
                return;
		    }
		}
		
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPartSwapGoodsOpen.action?hid="+json+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPartSwapGoodsOpen.action?hid="+json+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【换取商品】";
	}

	/*配镜单信息*/
	function winPopUp(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	}

	function cashOpen2(id){
		var moduleID = $('input[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initRefundNotChargeInfoToHisInsert.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【提交收费项目】";
    }
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<BODY bgColor="#ffffff" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form methed="post" name="arrearsForm">
<input type="hidden" id="print" name="print" value="${print}"/>
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="customerID" name="customerID" value="${customerInfoPo.smecicustomerid }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：退款管理</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
           <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
           <c:if test="${permissionPo.keya=='1'}">                                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initRefundSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">整单退款</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
           </c:if>
           <c:if test="${permissionPo.keyb=='1'}">                
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPartRefundSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">商品退款</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
           </c:if>
           <c:if test="${permissionPo.keyc=='1'}">                
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">换取商品</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>          
            </c:if>       
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
						<legend>顾客资料</legend>
                        <table width="98%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                          <tr>
                            <td bgcolor="#cadee8"><li class="horizontal">卡号&nbsp;
                                    <input name="customerInfoPo.smecimemberid" id="smecimemberid" value="${customerInfoPo.smecimemberid }" 
                                    onkeyup="selectCustomer();" ${systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' } class="text_input100" size="6">
                              </li>
                                <li class="horizontal">
                                  <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
                                  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn name="button22" title='查询' onclick="selCustomer();" >
                                </li>
                              <li class="horizontal">销售单号&nbsp;
                                  <input id="salesID" name="salesID" class="text_input160" onkeyup="judgekey();" value="${customerInfoPo.fmmsalesid }">
                              </li>
                              <li class="horizontal">姓名&nbsp;
                                  <input  class="text_input60" size="2" value="${customerInfoPo.smeciname }" readOnly="readOnly">
                              </li>
                              <li class="horizontal">性别&nbsp;
                                  <input class="text_input40" size="2" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly">
                              </li>
                              <li class="horizontal">年龄&nbsp;
                                    <input  class="text_input40" size="2" value="${customerInfoPo.fmmage }" readOnly="readOnly">
                                </li>
                              <li class="horizontal">&nbsp;
                              <c:if test="${empty(customerInfoPo.smecicustomerid)}">
					          </c:if>
					          <c:if test="${not empty(customerInfoPo.smecicustomerid)}">
					          	<img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详细' onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
					          </c:if>
                              </li>
                            </tr>
                        </table>
				  </fieldset>
                   <br>
                    <c:if test="${not empty(refundList)}">
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                           <c:choose>
                              <c:when test="${(permissionPo.keye==1) && systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1}">
                                  <TH width="9%" scope=col colspan="3">操作</TH>
                              </c:when>
                              <c:otherwise>
                                  <TH width="6%" scope=col colspan="2">操作</TH>
                              </c:otherwise>
                           </c:choose>
                           
                          <TH width="11%" height="30" scope=col>销售单号</TH>
                          <TH width="11%" scope=col>顾客姓名</TH>
                          <TH scope=col>销售日期</TH>
                          <TH width="10%" scope=col>原价合计</TH>
                          <TH width="10%" scope=col>应收金额</TH>
                          <TH width="10%" scope=col>折扣金额</TH>
                          <TH width="10%" scope=col>抹零金额</TH>
                          <TH width="10%" scope=col>实缴金额</TH>
                          <TH width="10%" scope=col>欠款金额</TH>
                        </TR>
                        <s:iterator value="refundList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%" height="26">
                            <img src="${ctx }/img/newbtn/search_0.png" name="button32234" title='详情' btn=btn onClick="winPopUp('${ssesbsalesid}')">
                          </TD>
                          
                          <c:if test="${(permissionPo.keye==1) && systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1}">
	                          <TD width="3%">
		                          <c:if test="${ssesbnothisflag != 0 && ssesbhisflag == 0}">
		                          	<img src="${ctx }/img/newbtn/payfee_0.png" name="pay" btn=btn title='提交待退费信息' onclick="cashOpen2('${ssesbsalesid}')">
		                          </c:if>
	                          </TD>
                          </c:if>
                          
                          <TD align="center" width="4%"><img src="${ctx }/img/newbtn/refund_0.png" btn=btn name="button3223" title="换取商品" onclick=pay2('${ssesbsalesid}','${ssesbcheckoutflag}','${ssesbhandlestate }','${ssesbsalesid }','${ssesbhandlestatecount }','${ssesbhispayflag}','${ssesbhiscancelflag}')></TD>
                          <TD height="26">${ssesbsalesid }</TD>
                          <TD>${fn:trim(ssesbpersonName) }</TD>
                          <TD>${fn:substring(ssesbsalesdatetime,0,10)}</TD>
                          <TD>${ssesbpricesum}</TD>
                          <TD>${ssesbsalesvalue }</TD>
                          <TD>${ssesbdiscountnum}</TD>
                          <TD>${ssesbrenums }</TD>
                          <TD>${ssesbpsalsvalue }</TD>
                          <TD><c:if test="${ssesbcheckoutflag == 1 }"><font color="red">${ssesbarrearsvalue }</font></c:if></TD>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
                    </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
    </form></BODY>
</HTML>
    <script>
function selectCust(flag){
    if(flag){
	   $("img").removeAttr("onclick");
	   document.forms[0].submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(event.keyCode == 13){
		if(document.getElementById('smecimemberid').value.trim() != '' || document.getElementById('salesID').value.trim() != ''){
			$("img").removeAttr("onclick");
			document.forms[0].submit();
		}
	}
}	
function judgekey(){
     if(document.getElementById('smecimemberid').value.trim() != '' || document.getElementById('salesID').value.trim() != ''){
	  if(event.keyCode == 13){
		document.forms[0].submit();
           }
     }
}

	
function selCustomer(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		
	if(is_iPad()){
		showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}		
	document.getElementById('popupTitle').innerHTML="【会员查询】";
}
function setCustomer(memberid){
	document.getElementById('smecimemberid').value = memberid;
	$("img").removeAttr("onclick");
	document.forms[0].submit();
}

</script>