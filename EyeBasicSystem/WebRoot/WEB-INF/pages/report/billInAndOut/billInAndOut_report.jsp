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
	function search(){
		if(checkForm(document.all.goodsForm)){
			var bgndate=document.getElementById("bgndate").value;
			var enddate=document.getElementById("enddate").value;
			var goodsid=document.getElementById("goodsid").value;
			var goodsname=document.getElementById("goodsname").value;
		
			var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
			url+="eims_reporting/storage_billInAndOutRpt&bgndate="+bgndate+"&enddate="+enddate+"&goodsid="+goodsid+"&goodsname="+goodsname+"&rs:Command=Render";
			//window.open (url, 'billInAndOutRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			
			if(is_iPad()){
				showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
		}
	}
	function clean(){
		document.getElementById('bgndate').value = "";
		document.getElementById('enddate').value = "";
		document.getElementById('goodsid').value = "";
		document.getElementById('goodsname').value = "";
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
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：收发单据汇总表</TD>
            <TD >&nbsp;</TD>
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
                          <TD width="%10" height="30" class="table_body" height="30">商品代码</TD>
                          <TD width="%40" class="table_none">
                          <input class="text_input200" id="goodsid" name="goodsid">
                          </TD>
                          <TD width="%10" class="table_body">商品名称</TD>
                          <TD width="%40" class="table_none">
                          <input class="text_input200" id="goodsname" name="goodsname">
                          </TD>
                        </TR>
					  	<TR>
			               <TD width="10%" height="30" class="table_body">日期</TD>
			               <TD class="table_none" colspan="3">
                            <input class="text_input100"
				               id="bgndate"
						       name="bgndate"
						       type="text" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '日期不能为空！'}]"
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('enddate').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="enddate"
						       name="enddate"
						       type="text" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '日期不能为空！'}]"
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('bgndate').value}"
						       readonly="readonly" />
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
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
