<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>基础信息维护</title>		
<script type="text/javascript">

	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;			
		if(is_iPad()){
			showPopWin("initRepairsCostSetInsert.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRepairsCostSetInsert.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【维修项新增】";
	}

	function update(hid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initRepairsCostSetUpdate.action?rcid="+hid+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRepairsCostSetUpdate.action?rcid="+hid+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【维修项修改】";
	}

	function del(hid,subjectName){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		showPopWin("initRepairsCostSetDelete.action?rcid="+hid+"&rcrname="+EncodeUtf8(subjectName)+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);		
		document.getElementById('popupTitle').innerHTML="【维修项删除】";
	}
       
	function clean(){
	    $('input[clean=clean]').each(function(){
			$(this).val('');
		});
	}
     
	function search(){
		if(!$("#nidek").val()){
			alert("请填写NIDEK截串字符！");
			return;
		}
		
		if(!$("#topcon").val()){
			alert("请填写TOPCON截串字符！");
			return;
		}
	
		noticeTypeFrm.action = "updateGetMachineValue.action";
		noticeTypeFrm.submit();
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
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="noticeTypeFrm" name="noticeTypeFrm" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;基础信息维护</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：焦度计取值设置</TD>
          <td align="right" width="40%" valign="bottom">&nbsp;
          </td>
        </TR>
          <TR>
            <TD class=menubar_function_text colspan="4">
            	<table></table>
            </TD>
          </TR>
      </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
							<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
		                        <TR height="26px">
		                          <TD width="15%" class="table_body">焦度计品种</TD>
		                          <TD class="table_none">
		                          	&nbsp;&nbsp;NIDEK<input id="nidekortopcon" name="apparatusPo.nidekortopcon" type="radio" value="n" checked="checked" ${apparatusPo.nidekortopcon eq 'n' ? 'checked=checked' : '' }>
		                          	&nbsp;&nbsp;TOPCON<input id="nidekortopcon" name="apparatusPo.nidekortopcon" type="radio" value="t" ${apparatusPo.nidekortopcon eq 't' ? 'checked=checked' : '' }>
		                          </TD>
		                        </TR>
		                        <TR height="26px">
		                          <TD width="15%" class="table_body">NIDEK截取字符</TD>
		                          <TD class="table_none">
		                          	<input id="nidek" class="text_input60" name="apparatusPo.nidek" type="text" value="${apparatusPo.nidek }" maxlength="2">
		                          </TD>
		                        </TR>
		                        <TR height="26px">
		                          <TD width="15%" class="table_body">TOPCON截取字符</TD>
		                          <TD class="table_none">
		                          	<input id="topcon" class="text_input60" name="apparatusPo.topcon" type="text" value="${apparatusPo.topcon }" maxlength="2">
		                          </TD>
		                        </TR>
		                        <TR height="26px">
		                          <TD width="15%" class="table_body">串口取值（COM）</TD>
		                          <TD class="table_none">
		                          	<textarea id="nidekortopconstr" name="apparatusPo.nidekortopconstr">${apparatusPo.nidekortopconstr }</textarea>
		                          </TD>
		                        </TR>
		                      </TBODY>
		                    </TABLE>
		                    <br/>
							<TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
																	<TR >
																		<TD class="table_none" class="PrivateBorderBlue">
																			&nbsp;
																		</TD>
																		<TD class="table_none" class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="table_none" class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD class="table_none" class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		<TD class="table_none" class="PrivateBorderBlue">
																			<div align="center">
																				瞳距(mm)
																			</div>
																		</TD>
																		<TD class="table_none" class="PrivateBorderBlue">
																			<div align="center"> 
																				VA 
																			</div>
																		</TD>
																		<TD class="table_none" class="PrivateBorderBlue">
																			<div align="center">Add<br> 
																				 
																			</div>
																		</TD>
																	</TR>
																	<TBODY>
																		<TR >
																			<TD width="11%" class="table_none"
																				class="PrivateBorderBlue">
																				OD
																			</TD>
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly" needChange="needChange"
																						qj="qj" name="apparatusPo.sphOD"
																						value="${apparatusPo.sphOD }"
																						class="text_input60" size="4" 
																						id="enter31" >
																				</div>
																			</TD>
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly" needChange="needChange"
																						zj="zj" name="apparatusPo.cylOD"
																						value="${apparatusPo.cylOD }"
																						class="text_input60" size="4" 
																						id="text_input60" >
																				</div>
																			</TD>
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.axisOD" zx="zx"
																						value="${apparatusPo.axisOD }"
																						class="text_input60" size="4"
																						id="enter33" >
																				</div>
																			</TD>
																			
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.lpd"
																						tongju="tongju"
																						value="${apparatusPo.lpd }"
																						class="text_input60" size="4" id="enter36" >
																				</div>
																			</TD>
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.vaOD" va='va' maxlength='20'
																						value="${apparatusPo.vaOD }"
																						class="text_input60" size="4" id="enter39">
																				</div>
																			</TD>
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="10"
																						name="apparatusPo.addOD" sph="sph"
																						value="${apparatusPo.addOD }"
																						class="text_input60" size="4" id="enter40">
																				</div>
																			</TD>
																		</TR>
																		<TR >
																			<TD width="11%" class="table_none"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			<TD class="table_none" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly" needChange="needChange"
																						qj="qj" name="apparatusPo.sphOS"
																						value="${apparatusPo.sphOS }"
																						class="text_input60" size="4" 
																						id="enter41" >
																				</div>
																			</TD>
																			<TD class="table_none" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly" needChange="needChange"
																						zj="zj" name="apparatusPo.cylOS"
																						value="${apparatusPo.cylOS }"
																						class="text_input60" size="4" 
																						id="enter42" >
																				</div>
																			</TD>
																			<TD class="table_none" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.axisOS" zx="zx"
																						value="${apparatusPo.axisOS }"
																						class="text_input60" size="4" id="enter43"
																						>
																				</div>
																			</TD>
																			
																			<TD width="8%" class="table_none"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.rpd"
																						tongju="tongju"
																						value="${apparatusPo.rpd}"
																						class="text_input60" size="4" id="enter48" >
																				</div>
																			</TD>
																			<TD class="table_none" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.vaOS" va='va' maxlength='20'
																						value="${apparatusPo.vaOS }"
																						class="text_input60" size="4" id="enter49" >
																				</div>
																			</TD>
																			<TD class="table_none" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" readonly="readonly"
																						name="apparatusPo.addOS" sph="sph"
																						value="${apparatusPo.addOS }" 
																						class="text_input60" size="4" id="enter50" >
																				</div>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >			
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>