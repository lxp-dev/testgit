<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
</head>
<script>
	function save(){
		if(checkForm(document.all.mydriasisForm)){    
	        $("img").removeAttr("onclick");
			mydriasisForm.action = "insertMydriasis.action";
			mydriasisForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
						  <fieldset>
							<legend>顾客资料</legend>
							<table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
							      <TR>
                                      <TD width="10%" class="table_body" height="30">卡号：</TD>
                                      <TD width="15%" class="table_none"><div align="left">${mydriasisPo.sopmdcustomerpostcode}&nbsp;</div></TD>
                                      <TD width="10%" class="table_body">姓名：&nbsp;</TD>
                                      <TD width="15%" class="table_none"><div align="left">${mydriasisPo.sopmdcustomername}&nbsp;</div></TD>
                                      <TD width="10%" class="table_body">散瞳师：</TD>
                                      <TD width="15%" class="table_none"><div align="left">${mydriasisPo.sopmdmydriasispersonname}&nbsp;</div></TD>
                                      <TD width="10%" class="table_body">散瞳时间：</TD>
                                      <TD width="15%" class="table_none"><div align="left">${fn:substring(mydriasisPo.sopmdvisiontime,0,16)}&nbsp;</div></TD>
                                    </TR>
						  </table>
						</fieldset>			
						<br />		
						 <fieldset>
							<legend>病史</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="60">${mydriasisPo.sopmdfamilyhistory}&nbsp;</td>
							</tr>
							</table>
							
						 </fieldset><br>
						<fieldset>
							<legend>检查项目</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center 
                  border=0>
                                  <TBODY>
                                    <TR>
                                      <TD width="22%" class="table_body" height="30">一般检查</TD>
                                      <TD width="27%" class="table_none">${mydriasisPo.sopmdgeneralinspection}&nbsp;</TD>
                                      <TD width="22%" class="table_body">眼底检查</TD>
                                      <TD width="27%" class="table_none">${mydriasisPo.sopmdfundusinspection}&nbsp;</TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" height="30">眼压</TD>
                                      <TD class="table_none">${mydriasisPo.sopmdfiop}&nbsp;</TD>
                                      <TD class="table_body">散瞳剂</TD>
                                      <TD class="table_none">
                                      <c:if test="${mydriasisPo.sopmdanaesthetic==1}">
                                         0.5%复方托吡卡胺(美多丽P)
                                      </c:if>
                                      <c:if test="${mydriasisPo.sopmdanaesthetic==2}">
                                         1%环戊通
                                      </c:if>
                                      <c:if test="${mydriasisPo.sopmdanaesthetic==3}">
                                         2%后马托品
                                      </c:if>
                                      <c:if test="${mydriasisPo.sopmdanaesthetic==4}">
                                         1%阿托品膏
                                      </c:if>  
                                      <c:if test="${mydriasisPo.sopmdanaesthetic=='阿托品已散瞳'}">
                                        	 阿托品已散瞳
                                      </c:if>                                   
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">散瞳类型</TD>
                                      <TD class="table_none"><c:if test="${mydriasisPo.sopmdopttype == '1'}">显然验光</c:if><c:if test="${mydriasisPo.sopmdopttype == '2'}">散瞳</c:if><c:if test="${mydriasisPo.sopmdopttype == '3'}">显加快</c:if><c:if test="${mydriasisPo.sopmdopttype == '4'}">左散瞳</c:if><c:if test="${mydriasisPo.sopmdopttype == '5'}">右散瞳</c:if></TD>
                                      <TD class="table_body">提交费用</TD>
                                      <TD class="table_none">
                                      <c:if test="${mydriasisPo.sopmdsubmitexpenseid ==23}">眼底照相</c:if>
                                      <c:if test="${mydriasisPo.sopmdsubmitexpenseid !=23}">&nbsp;</c:if>
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>	<br>
						<fieldset>
							<legend>视力检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE class="privateTable privateBorder" cellSpacing=1 cellPadding=3 width="99%" align=center 
                  border=0>
                                  <TBODY>
                                    <TR>
                                      <TD width="14%" class="table_body" height="30">戴镜视力</TD>
                                      <TD width="19%" class="table_none"><div align="right">右：</div></TD>
                                      <TD width="19%" class="table_none">${mydriasisPo.sopmdrightglassesvision}&nbsp;</TD>
                                      <TD width="19%" class="table_none"><div align="right">左：</div></TD>
                                      <TD width="19%" class="table_none">${mydriasisPo.sopmdleftglassesvision}&nbsp;</TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" height="30">裸眼视力</TD>
                                      <TD class="table_none"><div align="right">右：</div></TD>
                                      <TD class="table_none">${mydriasisPo.sopmdrightnakedvision}&nbsp;</TD>
                                      <TD class="table_none"><div align="right">左：</div></TD>
                                      <TD class="table_none">${mydriasisPo.sopmdleftnakedvision}&nbsp;</TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" height="30">近视力</TD>
                                      <TD class="table_none"><div align="right">右：</div></TD>
                                      <TD class="table_none">${mydriasisPo.sopmdrightnearvision}&nbsp;</TD>
                                      <TD class="table_none"><div align="right">左：</div></TD>
                                      <TD class="table_none">${mydriasisPo.sopmdleftnearvision}&nbsp;</TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>	                	
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
	
	
	




