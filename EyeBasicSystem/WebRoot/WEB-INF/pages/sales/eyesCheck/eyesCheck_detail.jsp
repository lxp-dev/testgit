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
        document.all.button1.disabled="true";
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
                                      <TD width="15%" class="table_none"><div align="left">${eyesCheckPo.sopeccustomerpostcode}&nbsp;</div></TD>
                                      <TD width="10%" class="table_body">姓名：&nbsp;</TD>
                                      <TD width="15%" class="table_none"><div align="left">${eyesCheckPo.sopeccustomername}&nbsp;</div></TD>
                                      <TD width="10%" class="table_body">检查人员：</TD>
                                      <TD width="15%" class="table_none"><div align="left">${eyesCheckPo.sopecpersonname}&nbsp;</div></TD>
                                      <TD width="10%" class="table_body">检查时间：</TD>
                                      <TD width="15%" class="table_none"><div align="left">${fn:substring(eyesCheckPo.sopecvisiontime,0,16)}&nbsp;</div></TD>
                                    </TR>
						  </table>
						</fieldset>			 
						<br />		
						<fieldset>
							<legend>检查项目</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="3%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="17%" class="table_body"><div align="center">外眼</div></TD>
                                      <TD width="22%" class="table_body"><div align="center">结膜充血</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">结膜</div></TD>
                                      <TD width="21%" class="table_body"><div align="center">角膜</div></TD>
                                      <TD width="20%" class="table_body"><div align="center">泪液</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">右</div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopecsurfaceeyeod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopeccongestiveod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopecnippleod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopeccornealod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopectearosod}&nbsp;
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">左</div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopecsurfaceeyeos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopeccongestiveos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopecnippleos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopeccornealos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopectearosos}&nbsp;
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							    <br>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="2%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="11%" class="table_body"><div align="center">前房</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">虹膜</div></TD>
                                      <TD width="16%" class="table_body"><div align="center">晶体</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">眼底</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">眼球运动</div></TD>
                                      <TD width="14%" class="table_body"><div align="center">色觉</div></TD>
                                      <TD colspan="2" class="table_body"><div align="center">眼压</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">右</div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${eyesCheckPo.sopechyphemaod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${eyesCheckPo.sopecirisod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${eyesCheckPo.sopeccrystalod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${eyesCheckPo.sopecfundusod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${eyesCheckPo.sopeccampaignod}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      ${eyesCheckPo.sopeccolorod}&nbsp;
                                      </div>
                                      </TD>
                                      <TD width="10%" class="table_none"><div align="center">${eyesCheckPo.sopeciopod}&nbsp;</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                      ${eyesCheckPo.sopeciopselod}&nbsp;
                                      </div>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">左</div></TD>
                                      <TD class="table_none"><div align="center">
                                       ${eyesCheckPo.sopechyphemaos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                       ${eyesCheckPo.sopecirisos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                       ${eyesCheckPo.sopeccrystalos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                       ${eyesCheckPo.sopecfundusos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                       ${eyesCheckPo.sopeccampaignos}&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      ${eyesCheckPo.sopeccoloros}&nbsp;</div>
                                      </TD>
                                      <TD class="table_none"><div align="center">${eyesCheckPo.sopeciopos}&nbsp;</div></TD>
                                      <TD class="table_none"><div align="center">
                                      ${eyesCheckPo.sopeciopselos}&nbsp;
                                      </div>
                                      </TD>
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
	
	
	




