<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜管理</title>
</head>
<script>	

	function search(){
		$("img").removeAttr("onclick");
		invisibleDistributionForm.action = "selectConsignProcessDelivery.action";
		invisibleDistributionForm.submit();
		showLoadingBar();
	}
	
	/*清空事件 */
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).get(0).selectedIndex=0;
        });
	}	
	
	/* 全选事件  */
    function check_all(obj,chk){
		 	
		var checkboxs = document.getElementsByName(chk);
		for(var i=0;i<checkboxs.length;i++){checkboxs[i].checked = obj.checked;}
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

	function changeWarehouse(obj,index){
        $('input[index=salesbill' + index + ']').attr('xstock',obj.value);
	}

	function update(){
		if($('input[name=ssesbsalesid]:checked').length==0){
			alert("请选择配镜单号!");
			return;
		}
		var id='';
		var ystock = '';
		var xstock = '';
		var tmp = '';
		var flag = '0';
		$('input[name=ssesbsalesid]:checked').each(function(){
			ystock = $(this).attr('ystock');
			xstock = $(this).attr('xstock');
			
			if (tmp != ''){
			    if (tmp != xstock){
	                flag = '1';
				}
		    }
			tmp = xstock;
			
			id = id + $(this).val() + ',';
		})
		id = id.substring(0, id.length-1);

		if (ystock == xstock){
            alert('委外收货单入库仓位和调拨入库仓位一致，请重新确认单据!');
            return;
		}

		if (flag == '1'){
            alert('所选配镜单的调拨入库仓位不一致，请重新确认单据!');
            return;
	    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initConsignProcessDeliveryUpdate.action?moduleID="+$('#moduleID').val()+"&ystock="+ystock+"&xstock="+xstock+"&billArray="+id,400,140,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【调拨单更新】";
    }

    function printReport(){
		if($('input[name=ssesbsalesid]:checked').length==0){
			alert("请选择配镜单号!");
			return;
		}
		var id='';
		var ystock = '';
		var xstock = '';
		var tmp = '';
		var flag = '0';
		$('input[name=ssesbsalesid]:checked').each(function(){
			ystock = $(this).attr('ystock');
			xstock = $(this).attr('xstock');
			
			if (tmp != ''){
			    if (tmp != xstock){
	                flag = '1';
				}
		    }
			tmp = xstock;
			
			id = id + $(this).val() + "','";
		})
		id = id.substring(0, id.length-3);

		if (ystock == xstock){
            alert('委外收货单入库仓位和调拨入库仓位一致，请重新确认单据!');
            return;
		}

		if (flag == '1'){
            alert('所选配镜单的调拨入库仓位不一致，请重新确认单据!');
            return;
	    }

		var DataURL = "report.action?reportlet=storage_weiwaipeisongRpt.cpt&salesID="+ id + "&ystock=" + ystock + "&xstock=" + xstock + "&__bypagesize__=false";
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【委外配送单】";
		
    }
	
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="invisibleDistributionForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外配送</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
		                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <tbody>
		                <TR>

                      	<TD width="10%" height="26" class="table_body">委外收货单制单人工号</TD>
			               <TD class="table_none" width="26%">
			               <input clean=clean class="text_input160" type="text"  id="createpersonid" name="createpersonid" value="${createpersonid}">
                           </TD>
                           <TD height="26" class="table_body">委外收货日期</TD>
                           <TD class="table_none">
                           <li class="horizontal_onlyRight">
                           <input id="billbgndate" clean=clean 
					       name="billbgndate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'billenddate\')}'})"
					       value="${billbgndate}" /> 至 
					       <input id="billenddate" clean=clean 
					       name="billenddate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'billbgndate\')}'})" 
					        value="${billenddate}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('billbgndate','billenddate')"></li>
			               </TD>
		                   <td height="26" class="table_body">默认调拨至</td>
		                   <td class="table_none">
		                          <select clean=clean name="processwarehouseid" id="processwarehouseid">
		                              <option value="">----请选择----</option>
		                              <s:iterator value="warehouseList">
		                               <option value="${bwhid }" ${processwarehouseid == bwhid ? 'selected="selected"' : '' }>(${bwhid })${bwhwarehouseName }</option>
		                              </s:iterator>
		                          </select>
		                    </td>			               
                        </TR>
		                      </tbody>
		                    </table>
					<c:if test="${(permissionPo.keya==1)}">  
                    <table id="searchBar" cellspacing="2" width="100%">
						<tr height="10">
							<td width="50%" align="left">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						    <TD height="26" valign="bottom" width="50%" align="right">
						    	<img src="${ctx }/img/newbtn/btn_print_0.png" btn=btn title='打印单据' onClick="printReport()" >
						    	<img src="${ctx }/img/newbtn/btn_wwps_0.png" btn=btn title='委外配送调拨至加工' onClick="update()" >
						    </TD>
						</tr>
					</table>
					</c:if>
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
					<c:if test="${not empty(salesBasicPoList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH height="26"scope=col>全选 <input type="checkbox" id="chks" onclick="check_all(this,'chk')">
                          <TH width="20%" scope=col>配镜单号</TH>
                          <TH width="15%" scope=col>销售门店</TH>
                          <TH width="15%" scope=col>收货日期</TH>
                          <TH width="10%" scope=col>收货单制单人</TH>
                          <TH width="15%" scope=col>收货仓位</TH>
                          <TH width="15%" scope=col>所属加工</TH>
                          <TH width="15%" scope=col>调拨至</TH>
                          </TR>
						 <s:iterator value="salesBasicPoList" status="idx">
						      <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						       <TD height="26" width="8%"><input type="checkbox" id="chk" name="ssesbsalesid" index="salesbill${idx.index}" value="${ssesbsalesid }" ystock="${ssesbinwarehouseid }" xstock="${ssesbfaliaostockid}"></TD>
	                            <TD>${ssesbsalesid }</TD>
	                            <TD>${ssesbshopName }</TD>
	                            <TD>${ssesbshouhuodate }</TD>
	                            <TD>${ssesbshouhuoren }</TD>
	                            <TD>${ssesbinwarehousename }</TD>
	                            <TD>${ssesbfaliaodtpname }</TD>
	                            <TD>
	                              <select name="warehouseid" id="warehouseid" onchange="changeWarehouse(this,${idx.index})">
		                              <s:iterator value="warehouseList">
		                               <option value="${bwhid }" ${ssesbfaliaostockid == bwhid ? 'selected="selected"' : '' }>(${bwhid })${bwhwarehouseName }</option>
		                              </s:iterator>
		                          </select>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>