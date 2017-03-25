<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出物流期初商品信息</title>
</head>
<script>	
    function save(){
    	if(checkForm(updateAmountFrm)){
    		updateAmountFrm.action = "updatePeriodBeginQccb.action";
    		updateAmountFrm.submit();
        }
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
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }> 
<form id="updateAmountFrm" name="updateAmountFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="goodsInfoPo.bgiqcid" value="${goodsInfoPo.bgiqcid}">
<input type="hidden" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
<input type="hidden" name="goodsInfoPo.bgiqcpricetype" value="${fquartzSwitchPo.fqscbjs}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="14%" height="26" class="table_body">所属公司</TD>
					  		<TD height="26" class="table_none">${goodsInfoPo.bgicompanyname}&nbsp;</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">所属部门</TD>
					  		<TD height="26" class="table_none">${goodsInfoPo.bgidepartmentname}&nbsp;</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">商品代码</TD>
					  		<TD height="26" class="table_none">${goodsInfoPo.bgigoodsid}&nbsp;</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">商品名称</TD>
					  		<TD height="26" class="table_none">${goodsInfoPo.bgigoodsname}&nbsp;</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">期初日期</TD>
					  		<TD height="26" class="table_none">${goodsInfoPo.bgiqcdate}&nbsp;</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">期初数量</TD>
					  		<TD height="26" class="table_none">
					  			<input type="text" name="goodsInfoPo.bgiqcnum" value="${goodsInfoPo.bgiqcnum}" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '期初数量填写有误，请重新填写！'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
					  		    <input type="hidden" name="qcnum" value="${goodsInfoPo.bgiqcnum}">
					  		</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">期初成本(${fquartzSwitchPo.fqscbjs eq '1' ? '不含税' : '含税'})</TD>
					  		<TD height="26" class="table_none">
					  		    <input type="text" name="goodsInfoPo.bgiqcaouumt" value="${goodsInfoPo.bgiqcaouumt}" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '期初成本填写有误，请重新填写！'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
					  		    <input type="hidden" name="qcaouumt" value="${goodsInfoPo.bgiqcaouumt}">
					  		</TD>
                        </TR> 
                        
                        <TR>
						   <TD height="26" colspan="2">
						       <label style="color:red;"><b>由于期初数量和成本的变更，将导致以后各个账期的加权平均成本不准确，请从期初账期开始重新进行成本计算！</b></label>
						   </TD>
						</TR> 					                     
                    
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="26">
							  <td>
							    <img btn=btn src="${ctx }/img/newbtn/btn_save_0.png" title='保存' onclick="save();" >
							  </td>	  
						</tr>
					</table>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
