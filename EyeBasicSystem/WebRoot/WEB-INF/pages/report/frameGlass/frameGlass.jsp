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

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 

	function search(){
		var ShopCode=document.all.departmentid.value;
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
		var customAmountForm = $('input[name=customAmountForm2]:checked').val();
		
		if(ShopCode=="" ){
			alert('请选择部门!');
			document.all.departmentid.focus();
			return false;
		}
		if(BeginDate==""){
			alert('请选择日期!');
			document.all.startTime.focus();
			return false;
		}
		if(End==""){
			alert('请选择日期!');
			document.all.endTime.focus();
			return false;
		}

		if (customAmountForm == '2' && BeginDate < '2014-05-01' && End >= '2014-05-01'){
			alert('由于报表统计方式发生改变，因此2014年5月1日之前和之后的数据不能一同查询!');
			return false;
	    }

		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		if (customAmountForm == '1'){
			url+="eims_reporting/sales_frameGlassSumRpt3&shopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&rs:Command=Render";
		}else {
			if (End < '2014-05-01'){
				url+="eims_reporting/sales_frameGlassSumRpt2&shopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&rs:Command=Render";
		    }else{
				url+="eims_reporting/sales_frameGlassSumRpt&shopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&rs:Command=Render";
			}
	    }
		window.open (url, 'dayMonthRsadpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		
	}
	function clean(){
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
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
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：框镜销售单据分类表</TD>
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
						   <TD width="10%" height="26" class="table_body">部门名称</TD>
			               <TD class="table_none" width="40%">
			               <c:if test="${person.departmenttype!=1}">
                            <select id="departmentid" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
      	                   </c:if>
      	                     <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" name="departmentid" value="${person.departmentID}" name="departmentid"/>
      	                   </c:if>
			               </TD>
			               <TD width="10%" height="26" class="table_body">查看日期</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input100"
				               id="startTime"
						       name="startTime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime"
						       type="text" 
						      onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})"
						       readonly="readonly" />
			               </TD>
                        </TR>
                        <TR id="subscriptionTab">
                           <TD height="78" class="table_body">订金方式</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" name="customAmountForm2" id="customAmount1" value="1" ${systemParameterPo.fspcustomamount eq '1' ? "checked" : "" }>订金按应收金额计入结款日收入,商品金额计入结款日收入<br/>
                               <input type="radio" name="customAmountForm2" id="customAmount2" value="2" ${systemParameterPo.fspcustomamount eq '2' ? "checked" : "" }>订金按应收金额计入补齐日收入,商品金额计入补齐日收入<br/>
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
                  
                  <div>
                  <1>&nbsp;2014年5月1日之前该报表是按【折扣前】的金额统计框镜配镜单数量，由2014年5月1日开始改为按【折扣后】的金额统计框镜配镜单数量。</br>
                  <2>&nbsp;2014年5月1日之前和之后的数据不能同时查看，避免出现框镜配镜单数量统计混乱的情况。
                  </div>
                  
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
