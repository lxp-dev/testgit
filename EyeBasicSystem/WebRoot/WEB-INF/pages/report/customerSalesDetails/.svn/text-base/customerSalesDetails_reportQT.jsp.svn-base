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
			
			var shopCode = document.getElementById("shopcode").value;
			var bgnDate = document.getElementById("startTime").value;
			var endDate = document.getElementById("endTime").value;
			var salseID = document.getElementById("salesid").value;
			var MemberID = document.getElementById("memberid").value;
			var name = document.getElementById("customername").value;
			var SalseItemName = document.getElementById("goodsname").value;
			var optometryerID = document.getElementById("optoid").value;
			
			var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
			url+="eims_reporting/sales_customerSalesDetailsQTRpt&shopCode="+shopCode+"&bgnDate="+bgnDate+
			"&endDate="+endDate+"&salseID="+salseID+"&MemberID="+MemberID+"&SalseItemName="+EncodeUtf8(SalseItemName)+
			"&name="+EncodeUtf8(name)+"&optometryerID="+optometryerID+"&rs:Command=Render"; 
			//window.open (url, 'customerSalesDetailsQTRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
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
		document.getElementById('shopcode').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('salesid').value = "";
		document.getElementById('memberid').value = "";
		document.getElementById('customername').value = "";
		document.getElementById('goodsname').value = "";
		document.getElementById('optoid').value = "";
	}
	
	   /** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }  
 
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>门店类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：顾客销售明细表</TD>
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
                            <c:if test="${person.departmenttype!=1}">
                                <select id="shopCode" name="shopCode">
	      		                 	<option value="">请选择门店名称</option>
	                             	<c:if test="${not empty(departmentsList)}">
					               	  <s:iterator value="departmentsList">
	                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
      	                   		</select>
      	                   </c:if>
      	                     <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="shopCode" value="${person.departmentID}" name="shopCode"/>
      	                   </c:if>
			               </TD>
			               <TD width="10%" height="30" class="table_body">日期</TD>
			               <TD class="table_none" width="40%">
			               <li class="horizontal_onlyRight">
                            <input class="text_input100"
				               id="startTime"
						       name="startTime"
						       type="text" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '日期不能为空！'}]"
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime"
						       type="text" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '日期不能为空！'}]"
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
						    </li>
						    <li class="horizontal_onlyRight">
					  				  <INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today()"></li>
						    
			               </TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="30" class="table_body">销售单号</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input200" type="text" id="salesid" name="salesid">
			               </TD>
			               <TD width="10%" height="30" class="table_body">会员号</TD>
			                <TD class="table_none" width="40%">
			               <input class="text_input200" type="text" id="memberid" name="memberid">
			               </TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="30" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input200" type="text" id="customername" name="customername">
			               </TD>
			               <TD width="10%" height="30" class="table_body">商品名称</TD>
			                <TD class="table_none" width="40%">
			               <input class="text_input200" type="text" id="goodsname" name="goodsname">
			               </TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="30" class="table_body">验光师(工号)</TD>
			               <TD class="table_none" width="40%" colspan="3">
                            <input class="text_input200" type="text" id="optoid" name="optoid">
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
