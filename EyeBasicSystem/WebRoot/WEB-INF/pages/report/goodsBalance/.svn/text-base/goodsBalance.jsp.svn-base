<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品结存数报表</title>
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
</head>
<script>
$(document).ready(function() { 
    $("img[btn=btn]").attr("style","cursor: hand;"); 
    $("img[btn=btn]").mouseover(function () { 
    $(this).attr("src",$(this).attr("src").replace("0","1")); 
    }).mouseout(function () { 
      $(this).attr("src",$(this).attr("src").replace("1","0")); 
    }); 
});
	function search(){
	    var checkdate=document.all.date.value;
		if (checkdate == null || checkdate == ""){
		    alert("请先选择盘点时间!");
		    return;
		}
	    var billid=document.all.billID.value;	    
	    var goodscategoryid=document.all.goodscategoryID.value;
	    var supplierid=document.all.supplierID.value;
	
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		url+="eims_reporting/storage_goodsBalanceRpt&checkdate="+checkdate;
		
		if (billid != null && billid.trim() != ""){
		    url+="&billid="+billid;
		}
		if (goodscategoryid != null && goodscategoryid != ""){
		    url+="&goodscategoryid="+goodscategoryid;
		}
		if (supplierid != null && supplierid != ""){
		    url+="&supplierid="+supplierid;
		}
		url+="&rs:Command=Render";
		window.open(url, 'goodsBalanceRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');

	}

	function clean(){
	    document.all.billID.value="";
	    document.all.date.value="";
	    document.all.goodscategoryID.value="";
	    document.all.supplierName.value="";
	    document.all.supplierID.value="";
	    document.all.stockID.value="";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		//showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>报表中心</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品结存数报表</TD>        
                <TD align=right>&nbsp;</TD>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
                      <TBODY>
					  	<TR>
						   <TD width="60" height="30" class="table_body">盘点单号</TD>
			               <TD class="table_none">
                               <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			               <TD width="10%" height="30" class="table_body">盘点日期</TD>
			               <TD class="table_none">
                               <input id="date" name="date" type="text" class="text_input100" onFocus="WdatePicker({readOnly:true})"  value="${date}" />						  
                           </TD>
                        </TR>
                        <TR>
                           <TD width="60" height="30" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID">
      		                 <option value="">请选择商品类别</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>
			               <TD height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
						   	    <li class="horizontal_onlyRight">
							   	    <input id="supplierName" class="text_input200" name="supplierName" value="${supplierName}" readonly="readonly"/>
							   		<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
								</li>
						   		<li class="horizontal_onlyRight">
						   		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" ></li>
						   </TD>
                        </TR>
                    	                   
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>					
                  </DIV>
                </DIV>
                </TD>
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