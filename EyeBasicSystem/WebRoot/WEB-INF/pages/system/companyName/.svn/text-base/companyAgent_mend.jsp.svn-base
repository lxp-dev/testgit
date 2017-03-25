
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<style type="text/css">
 img{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);}
.input_text{ width:398px; margin-right:8px; border:1px solid #e0dfde; padding-left:4px; height:30px; line-height:30px;}
.input_file{width:72px; margin-left:-76px; filter:alpha(opacity=0); opacity:0; height:30px;}
.input_file_button{ height:30px; width:67px;}
    
</style>
<title>公司维护</title>
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

	function insert(){
		if(checkForm(document.all.companyNameForm)){	
			var type = 0;
			$("select[id=fcnjcssupplieragentids]").each(function (){
				if($(this).val()){
					type = "1";
				}
			});
			if(type == 0){
				alert("请选择配置信息！");
				return;
			}
       		$("img").removeAttr("onclick");     		
			companyNameForm.action = "updateCompanyAgent.action";
			companyNameForm.submit();
			showLoadingBar();
		}
	}
	
	function setValue(obj){
		if($(obj).val()){
			$(obj).parent().parent().find("#fcnjcssetstr").attr("style","visibility: visible;");
		}else{
			$(obj).parent().parent().find("#fcnjcssetstrs").attr("checked","");
			$(obj).parent().parent().find("#fcnjcssetstr").attr("style","visibility: hidden;");
		}
	}
	
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input class="text_input150" type="hidden" name="companyNamePo.fcnId" id="fcnID" value="${companyNamePo.fcnId}"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
		    <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif></TD>					
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
			           <TR>
                          <TD height="26" class="table_body " align="right" width="10%">公司名称</TD>
                          <TD class="table_none " width="40%">
                          	${companyNamePo.fcnName}
                            <input type="hidden" id="fcnName" name="companyNamePo.fcnName" maxlength="20" value="${companyNamePo.fcnName}">
                          </TD>
                          <TD height="26" class="table_body " align="right" width="10%">所属区域</TD>
                          <TD class="table_none">
                            	<s:iterator value="regionPos">
                            	<c:if test="${companyNamePo.fcnregionid eq fcnjrid}">
                            		${fcnjrname }<input id="fcnregionid" name="companyNamePo.fcnregionid" type="hidden" value="${fcnjrid }">
                            	</c:if>
                            	</s:iterator>
                          </TD>
					   </TR> 	
                      </TBODY>
                    </TABLE>
                    <br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="insert();">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
					    </td>
					  </tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                    <br/>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
                          <TH width="3%" scope=col>是否供货</TH>
                          <TH scope=col>制造商ID</TH>
                          <TH scope=col>制造商名称</TH>
                          <TH scope=col>供应商名称</TH>
                          <TH scope=col>账期</TH>
                          <TH scope=col>期初预付</TH>
                          <TH scope=col>期初应付</TH>
						</TR>
						<c:forEach items="${companySupplierList}" var="po">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" height="30">
						  <TD width="5%">
		                     <img src="${ctx }/img/newbtn/select_0.png" title="选择" id="fcnjcssetstr" ${empty(po.fcnjcssupplieragentid) ? 'style="visibility: hidden;"':'style="visibility: visible;"'}>
		                  </TD>
		                  <TD width="10%">${po.fcnsupplierid }<input type="hidden" value="${po.fcnsupplierid}" id="fcnjcssupplierids" name="companyNamePo.fcnjcssupplierids" }></TD>
                          <TD width="30%">${po.fcnsuppliername }</TD>
                          <TD width="20%">
                          	<select id="fcnjcssupplieragentids" name="companyNamePo.fcnjcssupplieragentids" sid="${po.fcnsupplierid }" onclick="setValue(this);">
                            	<option value="">----请选择----</option>
                            	<c:forEach items="${companySupplierAgentList}" var="poa">	
                            		<c:if test="${poa.bsplinksupplierid  eq po.fcnsupplierid}">
                            			<option ${po.fcnjcssupplieragentid eq poa.bspid ? 'selected="selected"' : '' } value="${poa.bspid }">${poa.bspsuppliername }</option>
                            		</c:if>
                            	</c:forEach>
                            </select>
                          </TD>
                          <TD width="10%">
                          	<select id="fcnjcszqs" name="companyNamePo.fcnjcszqs">
                          		<option value="30" ${po.fcnjcszq eq '30' ? 'selected="selected"' : '' }>30天</option>
                          		<option value="60" ${po.fcnjcszq eq '60' ? 'selected="selected"' : '' }>60天</option>
                          		<option value="90" ${po.fcnjcszq eq '90' ? 'selected="selected"' : '' }>90天</option>
                          	</select>
                          </TD>
                          <TD width="10%"><input class="text_input80" type="text" id="fcnjcsyfs" name="companyNamePo.fcnjcsyfs" value="${po.fcnjcsyf }" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"/></TD>
                          <TD width="10%"><input class="text_input80" type="text" id="fcnjcsqcs" name="companyNamePo.fcnjcsqcs" value="${po.fcnjcsqc }" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"/></TD>
						</TR>
						</c:forEach>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="insert();">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
