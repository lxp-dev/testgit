<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
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

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        }); 
	}); 

	function search(){
		if(checkForm(document.getElementById("goodsForm"))){
			var ShopCode = $('#departmentID').val();
			var BeginDate = document.getElementById("startTime").value;
			var End = document.getElementById("endTime").value;
			var ShopCodeName = '';			
			<c:if test='${person.departmenttype==1}'>
        	    ShopCodeName = $('#ds').val();
        	</c:if>
			<c:if test='${person.departmenttype!=1}'>
    	        ShopCodeName = $('#departmentID').find('option:selected').text();
    	    </c:if>        	
    	    var isShow = $("input[id=isShow2]:checked").val();

    	    $('#shopCode').val(ShopCode);
    	    $('#bgnDate').val(BeginDate);
    	    $('#endDate').val(End);
    	    $('#shopCodeName').val(ShopCodeName);
    	    $('#isShow').val(isShow);   	    
    	    
    		var DataURL = '';
			if (ShopCode == '01'){ // 大光明旗舰店
				DataURL = "report.action?reportlet=scdgm_yinxingxiasoshouyejiRpt1.cpt";
			}else{
				DataURL = "report.action?reportlet=scdgm_yinxingxiasoshouyejiRpt2.cpt";
			}
				
    		var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL+"&shopCode="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End+"&shopCodeName="+EncodeUtf8(ShopCodeName)+'&isShow='+isShow,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				var goodsForm = document.getElementById("goodsForm"); 
				goodsForm.method="post"; 
				goodsForm.action=DataURL;
				goodsForm.target='xyxsyj'; 	
				goodsForm.attachEvent("onsubmit",function(){ window.open('about:blank','xyxsyj','toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100)); }); 		
				goodsForm.fireEvent("onsubmit");
				goodsForm.submit();
			}		
			document.getElementById('popupTitle').innerHTML="【隐形销售业绩统计表 】";
		}		
	}
	
	function clean(){
		goodsForm.reset();	
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="goodsForm" name="goodsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" id="shopCode" name="shopCode" value="">
<input type="hidden" id="bgnDate" name="bgnDate" value="">
<input type="hidden" id="endDate" name="endDate" value="">
<input type="hidden" id="shopCodeName" name="shopCodeName" value="">
<input type="hidden" id="isShow" name="isShow" value="">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：隐形销售业绩统计表 </TD>
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
                      	   <TD width="12%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="30%">
			               <c:if test="${person.departmenttype != 1}">
                               <select id="departmentID" name="departmentID" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择销售门店！'}]">
                                   <option value="">----请选择----</option>
                                   <s:iterator value="departmentsList">
                                       <option value="${bdpdepartmentid }">${bdpdepartmentname }</option>
                                   </s:iterator>
                               </select>
                               <label style="color:red;">&nbsp;*&nbsp;</label>
      	                   </c:if>
      	                   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
      	                   	<input type="hidden" id="ds" value="${person.bdpdepartmentname}" name="ds"/>
      	                   </c:if>
			               </TD>
			               <TD width="10%" class="table_body">查询日期</TD>
			               <TD class="table_none" colspan="3" width="40%">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
                               <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
			               
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>

                      </TBODY>
                    </TABLE>
            <c:if test="${permissionPo.keya eq '1'}">        
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                                <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
			</c:if>		
            <c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">
1.查询条件：【销售门店】为必填项；【查询日期】为必填项，<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用于选取查看的日期段；【是否显示查询条件】用于在报表中是否呈现所选的查询信息。<br/>
2.报表说明：&nbsp;&nbsp;用于查看各个门店在当前日期段内隐形销售总计，旗舰店与其他门店的查看重点不同。<br/>

					</div>														
			</c:if>		
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
