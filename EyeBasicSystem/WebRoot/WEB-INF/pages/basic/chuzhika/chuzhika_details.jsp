<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡新增</title> 
</head>
<script>

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" >

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      	<TR>
						    <TD width="8%" height="28" class="table_body">储值卡号</TD>
			                <TD width="20%" class="table_none">
	                            ${chuzhikaPo.cstczkcardid}
			               	</TD>
			               	<TD width="8%" class="table_body">发放部门</TD>
			               	<TD class="table_none" width="15%" valign="middle">
	                            ${chuzhikaPo.cstczkshopname}	               	
                            </TD>
                            <TD width="8%" class="table_body">
							   	储值卡余额
						    </TD>
			                <TD class="table_none">
			                	${chuzhikaPo.cstczkjine}                
			                </TD>			   
			            </TR>
			            <TR>
						    <TD class="table_body" height="28">绑定会员</TD>
			                <TD class="table_none">
                            	${chuzhikaPo.cstczkcustomername}
			                </TD>
			                <TD class="table_body">身份证</TD>
			                <TD width="23%" class="table_none" valign="middle">
                            	${chuzhikaPo.cstczkidcard}
                            </TD>
						    <TD class="table_body">
							  	消费密码
						    </TD>
			                <TD class="table_none">
			                	${chuzhikaPo.cstczkcardpassword}
			                </TD>
			             </TR>
			             <TR>
						    <TD height="28" class="table_body">备注</TD>
			                <TD class="table_none" colspan="5">
			                	<textarea id="cstczkremark" name="chuzhikaPo.cstczkremark">${chuzhikaPo.cstczkremark}</textarea>
			               </TD>
			             </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="8%" scope=col height="30">储值卡变更类型</TH>
                          <TH width="10%"scope=col>变更时间</TH>
                          <TH width="7%" scope=col>操作人</TH>
                          <TH width="7%" scope=col>实付金额</TH>
                          <TH width="6%" scope=col>赠送金额</TH>
						  <TH width="20%" scope=col>变更金额(建卡或充值时，变更金额=实付+赠送)</TH>
						  <TH width="7%" scope=col>剩余金额</TH>
						  <TH width="10%" scope=col>销售单号</TH>
						  <TH scope=col>备注</TH>
                        </TR>
                       <c:forEach var="chuzhikaLogPo" items="${chuzhikaLogPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">

						  <TD height="28">
						  	<c:choose>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '0')}">
						  			建卡
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '1')}">
						  			充值
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '2')}">
						  			提现
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '3')}">
						  			结款
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '4')}">
						  			退款
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '5')}">
						  			补齐欠款
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '6')}">
						  			订金
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '7')}">
						  			挂号费
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '8')}">
						  			维修费
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq '9')}">
						  			退挂号费
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C3')}">
						  			更改结款-冲结款
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C4')}">
						  			更改结款-冲退款
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C5')}">
						  			更改结款-冲补齐欠款
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C6')}">
						  			更改结款-冲订金
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C7')}">
						  			更改结款-冲挂号费
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C8')}">
						  			更改结款-冲维修费
						  		</c:when>
						  		<c:when test="${(chuzhikaLogPo.smeasaddorsub eq 'C9')}">
						  			更改结款-冲退挂号费
						  		</c:when>
						  	</c:choose>
						  </TD>
						  <TD>${fn:substring(chuzhikaLogPo.smeasdodate,0,16) }</TD>
						  <TD>${chuzhikaLogPo.smeasdopersonname}</TD>
						  <TD>${chuzhikaLogPo.smeasshifu}</TD>
						  <TD>${chuzhikaLogPo.smeaszengsong}</TD>
						  <TD>${chuzhikaLogPo.smeascintegral}</TD>
						  <TD>${chuzhikaLogPo.smeasxintegral}</TD>
						  <TD>${chuzhikaLogPo.smeassalesbillid}</TD>
						  <TD>${chuzhikaLogPo.smeasremark}</TD>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>