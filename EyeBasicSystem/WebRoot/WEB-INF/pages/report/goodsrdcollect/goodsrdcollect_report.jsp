<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表中心</title>
</head>
<script>	
    /**
	 * 制造商开窗
	 */
	function openSupplier(){	
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

	function search(){
		var BillDateStart=document.all.billDateStart.value;
		var BillDateEnd=document.all.billDateEnd.value;
		var ji = document.all.ji.value;
		if(BillDateStart=="" || BillDateEnd==""){
			alert('请选择日期!');
			return false;
		};
		var SupplierID=document.all.supplierID.value;
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		var reportName = '';
        if (ji == '1'){
        	reportName = 'logistics_GoodsRDCollectRpt_Type';
        }
        if (ji == '2'){
        	reportName = 'logistics_GoodsRDCollectRpt_supplier';
        }
        if (ji == '3'){
        	reportName = 'logistics_GoodsRDCollectRpt_brand';
        }
        if (ji == '4'){
        	reportName = 'logistics_GoodsRDCollectRpt_goods';
        }
		
		url+="eims_reporting/" + reportName + "&bgnDate="+BillDateStart+"&endDate="+BillDateEnd+"&ji="+ji+"&supplier="+SupplierID+"&rs:Command=Render";
		window.open (url, 'GoodsRDCollectRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');		
	}
	
	function clean(){
		document.getElementById('billDateStart').value = "";
		document.getElementById('billDateEnd').value = "";
		document.getElementById('ji').value="1";
		document.getElementById('supplierName').value="";
		document.getElementById('SupplierID').value = "";
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
<body  oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;">
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>报表中心</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品结存表(二)</TD>
            <TD align=right>&nbsp;</TD>
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD width="13%" height="26" class="table_body">查看日期</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input100"
				               id="billDateStart"
						       name="billDateStart"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('billDateEnd').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="billDateEnd"
						       name="billDateEnd"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('billDateStart').value}"
						       readonly="readonly" />
			               </TD>
			               <TD width="13%" height="26" class="table_body">分级查询</TD>
			                <TD class="table_none" width="40%">
				           <select id="ji" name="ji">
				           	<option value="1">一级</option>
				           	<option value="2">二级</option>
				           	<option value="3">三级</option>
				           	<option value="4">四级</option>
				           </select>
				           </TD>
 						   </tr>
 						   <tr>
			               <TD width="13%" height="26" class="table_body">制造商</TD>
						            <TD class="table_none"  colspan="3">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" readonly="readonly" name="supplierName" value="${supplierName}" />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='选择' onClick="openSupplier();" ></li>
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
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>

