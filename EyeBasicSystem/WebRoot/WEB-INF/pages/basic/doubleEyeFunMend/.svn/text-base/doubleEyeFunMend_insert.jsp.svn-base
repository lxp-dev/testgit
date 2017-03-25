<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增双眼视功能检查</title>
</head>
<script>
	function save(){	
        $("img").removeAttr("onclick");
		doubleEyeFunForm.action = "mendDoubleEyeFun.action";
		doubleEyeFunForm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doubleEyeFunForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left">目前操作功能：双眼视功能模块必填项设置 </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
        </TBODY>
      </TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
						<TBODY>
						<TR><!--ťStart-->
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx }/img/pic/tab_top_bg.gif>
							</TD>
						</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 8px; PADDING-LEFT: 8px; PADDING-BOTTOM: 8px; PADDING-TOP: 8px; HEIGHT: 100px" vAlign=top>
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">远：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="14%" class="table_none"><div align="center">
                                        <input type="checkbox" id="bdmfarhetelevel" name="doubleEyeFunMendPo.bdmfarhetelevel" ${doubleEyeFunMendPo.bdmfarhetelevel ne '1' ? '':'checked' } value="1">
                                      </div>
                                      </TD>
                                      <TD width="15%" rowspan="2" class="table_body">近：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"colspan="2"><div align="center">
                                          <input type="checkbox"  id="bdmclosehetelevel" name="doubleEyeFunMendPo.bdmclosehetelevel" ${doubleEyeFunMendPo.bdmclosehetelevel ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input type="checkbox" id="bdmfarheteuprightness"  name="doubleEyeFunMendPo.bdmfarheteuprightness" ${doubleEyeFunMendPo.bdmfarheteuprightness ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none" colspan="2"><div align="center">
                                          <input type="checkbox" id="bdmcloseheteuprightness"     name="doubleEyeFunMendPo.bdmcloseheteuprightness" ${doubleEyeFunMendPo.bdmcloseheteuprightness ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="15%" class="table_body" align="center">测试</TD>
                                      <TD width="8%" class="table_none"><div align="right">+1</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                        <input type="checkbox" id="bdmtestbig" name="doubleEyeFunMendPo.bdmtestbig" ${doubleEyeFunMendPo.bdmtestbig ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="right">-1</div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                      	<input type="checkbox" id="bdmtestsmall" name="doubleEyeFunMendPo.bdmtestsmall" ${doubleEyeFunMendPo.bdmtestsmall ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD width="15%" class="table_none">AC/A：</TD>
                                      <TD width="8%" class="table_none" colspan="2"><div align="center"><input type="checkbox" id="bdmaca" name="doubleEyeFunMendPo.bdmaca" ${doubleEyeFunMendPo.bdmaca ne '1' ? '':'checked' } value="1"></div></TD>
                                    </TR>
                                    <TR class="table_body" height="30">
                                    	<TD width="13%" class="table_body"><div align="center">BCC：</div></TD>
                                    	<TD width="15%" class="table_none" colspan="7">
                                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="bdmbcc" name="doubleEyeFunMendPo.bdmbcc" ${doubleEyeFunMendPo.bdmbcc ne '1' ? '':'checked' } value="1">
									  	</TD>
                                    </TR>
                                    <TR>
                                      	<TD class="table_body" rowspan="2" align="center">正/负相对调节</TD>
                                      	<TD class="table_none"><div align="right">PRA：&nbsp;&nbsp;OU</div></TD>
                                      	<TD class="table_none"><div align="center">
	                                     	<input type="checkbox" id="bdmpositiveaccpra" name="doubleEyeFunMendPo.bdmpositiveaccpra" ${doubleEyeFunMendPo.bdmpositiveaccpra ne '1' ? '':'checked' } value="1">
									 	</div></TD>
									 	<TD class="table_none"><div align="right">OD/OS</div></TD>
                                      	<TD class="table_none"><div align="center">
	                                     	<input type="checkbox" id="bdmpositiveaccpraod" name="doubleEyeFunMendPo.bdmpositiveaccpraodos" ${doubleEyeFunMendPo.bdmpositiveaccpraodos ne '1' ? '':'checked' } value="1">
									 	</div></TD>
									 	<TD class="table_none" colspan="2">&nbsp;
									 	</TD>
									</tr>
									<TR>
                                      <TD class="table_none"><div align="right">NRA：&nbsp;&nbsp;OU</div></TD>
                                      <TD class="table_none"><div align="center">
                                      	<input type="checkbox" id="bdmnegativeaccnra" name="doubleEyeFunMendPo.bdmnegativeaccnra" ${doubleEyeFunMendPo.bdmnegativeaccnra ne '1' ? '':'checked' } value="1"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">OD/OS</div></TD>
                                      	<TD class="table_none"><div align="center">
	                                     	<input type="checkbox" id="bdmnegativeaccnraod" name="doubleEyeFunMendPo.bdmnegativeaccnraodos" ${doubleEyeFunMendPo.bdmnegativeaccnraodos ne '1' ? '':'checked' } value="1">
									 	</div></TD>
									 	<TD class="table_none" colspan="2">&nbsp;
									 	</TD>
                                    </TR>
                                    <tr>
                                    	<td height="5"></td>
                                    </tr>
                                  </TBODY>
                                </TABLE>
								<br />						
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                  	<TR>
                                      <TD class="table_body" align="center">Add</TD>
                                      <TD class="table_none"><div align="right">OD/OS</div></TD>
                                      <TD class="table_none" colspan="13"><div align="left">
                                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                      <input type="checkbox" id="addOD" name="doubleEyeFunMendPo.bdmaddodos" ${doubleEyeFunMendPo.bdmaddodos ne '1' ? '':'checked' } value="1">
									  </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="6" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="1" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="1" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" rowspan="2" class="table_body" align="center">远：融像</TD>
                                      <TD width="5%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input type="checkbox" id="validateLevel" name="doubleEyeFunMendPo.bdmfaramaleveln" ${doubleEyeFunMendPo.bdmfaramaleveln ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                        <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmfaramalbu" ${doubleEyeFunMendPo.bdmfaramalbu ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmfaramabu" ${doubleEyeFunMendPo.bdmfaramabu ne '1' ? '':'checked' } value="1" >
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋</div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input type="checkbox" id="validateLevel" name="doubleEyeFunMendPo.bdmfaramalevelp" ${doubleEyeFunMendPo.bdmfaramalevelp ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmfaramalbd" ${doubleEyeFunMendPo.bdmfaramalbd ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmfaramabd" ${doubleEyeFunMendPo.bdmfaramabd ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="6" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="1" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="1" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD rowspan="2" class="table_body" align="center">近：融像</TD>
                                      <TD width="5%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input type="checkbox" id="validateLevel" name="doubleEyeFunMendPo.bdmcloseamaleveln" ${doubleEyeFunMendPo.bdmcloseamaleveln ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                          <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmcloseamalbu" ${doubleEyeFunMendPo.bdmcloseamalbu ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmcloseamabu" ${doubleEyeFunMendPo.bdmcloseamabu ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input type="checkbox" id="validateLevel" name="doubleEyeFunMendPo.bdmcloseamalevelp" ${doubleEyeFunMendPo.bdmcloseamalevelp ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmcloseamalbd" ${doubleEyeFunMendPo.bdmcloseamalbd ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input type="checkbox" id="validatedotNum" name="doubleEyeFunMendPo.bdmcloseamabd" ${doubleEyeFunMendPo.bdmcloseamabd ne '1' ? '':'checked' } value="1">
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							<br>
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                          	<font color="red">例：      远：隐斜勾选水平时</font>
                          	<img src="${ctx}/img/example/doubleCheckExampleImg.png"/>
							<font color="red">远隐斜垂直和近隐斜整行在视光检查中双眼视功能的必填区域内都会显示出来 </font>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>		
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>
</HTML>