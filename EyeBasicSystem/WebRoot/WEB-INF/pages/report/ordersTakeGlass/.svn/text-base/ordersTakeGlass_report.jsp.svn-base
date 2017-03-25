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
		if(checkForm(document.all.goodsForm)){
			var department=document.all.departmentid.value;
			var type=document.all.orderstypeid.value;
			
			var takeTimeStart=document.all.takestarttime.value;
			var takeTimeEnd=document.all.takeendtime.value;
			
			var salseTimeStart=document.all.salesstarttime.value;
			var salseTimeEnd=document.all.salesendtime.value;
			
			var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
			url+="eims_reporting/sales_ordersTakeGlassRpt&department="
			+department+"&type="+type+"&takeTimeStart="+takeTimeStart+"&takeTimeEnd="+takeTimeEnd+
			"&salseTimeStart="+salseTimeStart+"&salseTimeEnd="+salseTimeEnd+"&rs:Command=Render";
			window.open (url, 'ordersTakeGlassRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');

		}
	}
	function clean(){
		document.getElementById('salesstarttime').value = "";
		document.getElementById('salesendtime').value = "";
		document.getElementById('orderstypeid').value = "";
		document.getElementById('takestarttime').value = "";
		document.getElementById('takeendtime').value = "";
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
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：订做片取镜查询</TD>
            <TD>&nbsp;</TD>
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						   <TD width="10%" height="30" class="table_body">部门名称</TD>
			               <TD class="table_none" width="40%">
                            ${departmentsPo.bdpdepartmentname}
                            <input type="hidden" id="departmentid" name="departmentid" value="${departmentsPo.bdpdepartmentid}">
			               </TD>
			               <TD width="10%" height="30" class="table_body">配镜日期</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input100"
				               id="salesstarttime"
						       name="salesstarttime"
						       type="text" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '配镜日期不能为空！'}]"
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('salesendtime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="salesendtime"
						       name="salesendtime"
						       type="text" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '配镜日期不能为空！'}]"
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('salesstarttime').value}"
						       readonly="readonly" />
			               </TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="30" class="table_body">订做类型</TD>
			               <TD class="table_none" width="40%">
                           		<select id="orderstypeid" name="orderstypeid">
                           			<option value="">请选择订做类型</option>
									<option value="2">框镜订做</option>
									<option value="4">隐形订做</option>
								</select>
			               </TD>
			               <TD width="10%" height="30" class="table_body">取镜日期</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input100"
				               id="takestarttime"
						       name="takestarttime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('takeendtime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="takeendtime"
						       name="takeendtime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('takestarttime').value}"
						       readonly="readonly" />
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
