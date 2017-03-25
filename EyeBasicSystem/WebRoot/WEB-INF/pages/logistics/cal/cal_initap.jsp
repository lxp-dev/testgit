<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>期末处理</title>
</head>
<script>

	$(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });	

	    showCompany('${systemParameterPo.fspcbjstype}');
	});
	
	function save(){

        if ('${systemParameterPo.fspcbjstype}' == '2' && $('#companyID').val() == ''){
            alert('请选取所属公司!');
            return;
        }
		
	    if(confirm('是否确定初始化账期?')){
	    	$("img").removeAttr("onclick");
	        calForm.action="updateAccountPeriodSet.action?moduleID=${moduleID}";
	        calForm.submit();
	        showLoadingBar();
	    }
	}

    function showCompany(id){

        $('#companyID').val(''); 
    	
        if (id == '1'){
            $('tr[company=hiddencompany2]').hide();
        }

        if (id == '2'){
            $('tr[company=hiddencompany2]').show();
        }
    }

</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form method="post" name="calForm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="9%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;基础信息</TD>
           <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：初始化账期</TD>
        </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
							<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

                    <TABLE id="searchBar" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                      
                      	<TR>
					  		<TD width="15%" height="26" class="table_body">初始化方式</TD>
					  		<TD height="26" class="table_none" colspan="3">
					  		    <c:if test="${systemParameterPo.fspcbjstype eq '1'}">&nbsp;初始化所有公司下的账期&nbsp;</c:if>
					  		    <c:if test="${systemParameterPo.fspcbjstype eq '2'}">&nbsp;选取一个所属公司后，初始化该公司下的账期&nbsp;</c:if>		    
					  		</TD>
                        </TR>
                        
                        <TR company="hiddencompany">
						   <TD width="14%" height="26" class="table_body">所属公司</TD>
			               <TD class="table_none" colspan="3">
						   		<select id="companyID" name="companyID">
	                              <option value="" qcdate="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" qcdate="${fcnqcdate}">${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;*&nbsp;</label>
                           </TD>				   
                        </TR>

						<TR>
						  <TD height="26" class="table_body">请选择初始化后的账期：</TD>
                          <TD class="table_none" colspan="3">
                              <select id="year" name="year">
      		                      <c:forEach var="i" begin="2011" end="2080" step="1"> 
                                      <option value="${i}">${i}</option>
      		                      </c:forEach> 
                              </select>
                              <select id="month" name="month">
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                              </select>                             
						   </TD>			    
						</TR>
						    
                        <TR>
                          <TD align="left" colspan="2">
                              <p>
                              <li class="horizontal_onlyRight">
                                <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_cshzq_0.png" title='初始化账期' onclick="save()">
                              </li>
                              <li class="horizontal_onlyRight">  
                                <strong><label style="color: red">*提示:单击此按钮后,账期将会直接初始化为所选账期!</label></strong>
                              </li>				 
                              </p>
                              </TD>
                        </TR>
                    
                      </TBODY>
                    </TABLE>
                    <br/>
	                    
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->

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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>