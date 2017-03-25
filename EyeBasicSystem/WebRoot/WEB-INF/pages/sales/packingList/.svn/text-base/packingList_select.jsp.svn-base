<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印包装签</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
	});

	function selectContact(obj){
		var act = document.activeElement.id; 
		
		if(act == "pageNos"){
			$('#'+act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	
	/*查看*/
	function search(){
	//	document.all.submitButton.disabled="true";
		packinglistForm.action = "selectPackingList.action";
		packinglistForm.submit();
	}	
	
	
	/*重置*/
	function clean(){
		document.getElementById('salesid').value = "";
		document.getElementById('customerName').value = "";
		document.getElementById('departmentid').value = "";
		document.getElementById('salesdatestarttime').value = "";
		document.getElementById('salesdateendtime').value = "";
		document.getElementById('takeglassstartdata').value = "";
		document.getElementById('takeglassenddata').value = "";
		document.getElementById('memberid').value = "";
        <c:if test="${systemParameterPo.fspdjsbm == '1'}">
        document.getElementById('djsbm').value = "";
        </c:if> 		
		$('#chooseflag').val('');
		$('#ssesbphone').val('');
		
	}	
	
	function permissionMessage(){
	  alert('您无此操作权限');
	}
	
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	
	/*顾客信息*/
	function winPopUp(id){

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInTransitDetailsSel.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInTransitDetailsSel.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【在途详细】";
    }
    
	function batPrintGoodsBarCode(salesid, customername, takedate, takeshopname, salesdate, isd){
		printPakingList(salesid, customername, takedate, takeshopname, salesdate, isd);
		//doFRPrint(salesid);
	}
	
	function batPrintGoodsBarCode1(){
		salesid='';
		customername=$('#printCustomerName').val();
		takedate=$('#printTakeglassenddata').val();
		takeshopname=$('#printDepartmentid').val();
		salesdate='';
		isd=$('#printChooseflag').val();
		printPakingList(salesid, customername, takedate, takeshopname, salesdate, isd);
		//doFRPrint(salesid);
	}

	function doFRPrint(salesid){ //点击打印的时候调用
		var reportURL = "report.action?reportlet=print_peijingdan_baozhuangqian.cpt&salesid=" + salesid +"&__bypagesize__=false";  //拼接最终的报表路径
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(reportURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}			
		document.getElementById('popupTitle').innerHTML="【配镜单打印】";	
	}
	
	function OnKeyDownEnter(){
		
		if(event.keyCode == 13 ){
			search();
		}
	}
	/**
	 *打印条码
	 *@param barCode条码
	 *@param quantity打印数量
	 */
	function printPakingList(salesid, customername, takedate, takeshopname, salesdate, isd) {
		var num=1;
		var fso,f1,ts,s;
		var ForReading = 1;
		fso = new ActiveXObject("Scripting.FileSystemObject");
		if(fso==null){
			alert("请检查条码打印机！");
			return false;
		}
		
		
		f1 = fso.CreateTextFile("lpt1:",true,true); 
		f1.Write("\x1B\x40");   
		f1.Write("^XA"); 
		f1.Write("^MD21"); 
		f1.Write("^CWX,E:MSUNG24.FNT^FS"); 
		f1.Write("^AI26");
		if(isd == 'D'){
			f1.Write("^FO40,30^A0,40,40^FD"+"*"+"^FS");
		}
		f1.Write("^BY2,2.0,10^FO40,70^BQN,8,8^FDQM,A" + salesid + "^FS");
		f1.Write("^FO250,90^A0,30,30^FD" + salesid + "^FS");
		f1.Write("^FO250,140^AX,34,34^FD"+"顾客姓名："+"^FS");  
	 f1.Write("^FO355,125^AX,40,40^FD"+customername+"^FS");
		f1.Write("^FO250,190^AX,34,34^FD"+"取镜地点："+takeshopname+"^FS");
		f1.Write("^FO250,240^AX,35,35^FD"+"取镜日期："+takedate.substring(0,10)+"^FS");
		
		f1.Write("^PQ1^FS"); 
		f1.Write("^XZ"); 
		f1.close(); 
		sleep(500); 
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="packinglistForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="InTransitCount" name="InTransitCount" value="${InTransitCount}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：打印包装签 </TD>
            <TD align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_0.png');" title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=0 colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 0px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=0 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                     
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">打印包装单签</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>

                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="8%" height="30" class="table_body">配镜单号</TD>
                          <TD width="25%" class="table_none">
                          	<input class="text_input200" type="text"  id="salesid" name="salesid" value="${salesid}" onkeyup="OnKeyDownEnter();">
                          </TD>
                          <TD width="8%" class="table_body">顾客姓名</TD>
                          <TD width="25%" class="table_none">
                          	<input class="text_input100" type="text" id="customerName" name="customerName" onkeyup="OnKeyDownEnter();" value="${customerName}" >
						  </TD>
						  <TD width="8%" height="30" class="table_body">销售门店</TD>
                          <TD width="26%" class="table_none">
                          	  <select id="departmentid" name="departmentid">
      		                 	<option value="">请选择销售门店</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
						  </TD>
                        </TR> 
                        <TR>

                          <TD width="8%" height="30" class="table_body">顾客电话</TD>
                          <TD class="table_none">
                        	<input class="text_input100" onkeyup="OnKeyDownEnter();" type="text" id="ssesbphone" name="ssesbphone" value="${ssesbphones}" >
			               </TD>

                          <TD width="8%" height="30" class="table_body">配镜日期</TD>
                          <TD class="table_none">
                             <input class="text_input100"
				               id="salesdatestarttime"
						       name="salesdatestarttime" value="${requestScope.ssesbsalesdatestarttime }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'salesdateendtime\')}'})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="salesdateendtime"
						       name="salesdateendtime" value="${requestScope.ssesbsalesdateendtime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'salesdatestarttime\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
			               </TD>
						   <TD width="7%" class="table_body">取镜日期</TD>
                          <TD class="table_none">
                             <input class="text_input100"
				               id="takeglassstartdata"
						       name="takeglassstartdata" value="${requestScope.ssesbtakeglassstartdata }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'takeglassenddata\')}'})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="takeglassenddata"
						       name="takeglassenddata" value="${requestScope.ssesbtakeglassenddata}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'takeglassstartdata\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
			               </TD>
                        </TR>
                        <TR> 
                          <TD width="8%" height="30" class="table_body">配镜类型</TD>
                          <TD class="table_none">
                             <select name="chooseflag" id="chooseflag">
                            <option value="">请选择单据类型</option>
                            <option value="1" ${requestScope.chooseflag == 1 ? 'selected="selected"' : '' }>框镜成品</option>
                            <option value="2" ${requestScope.chooseflag == 2 ? 'selected="selected"' : '' }>框镜订做</option>
                            </select>
			               </TD>
						<c:choose>
							<c:when test="${systemParameterPo.fspdjsbm == '1'}">
				                <TD width="8%" class="table_body">顾客卡号</TD>
		                        <TD class="table_none">
		                        	<input class="text_input100" onkeyup="OnKeyDownEnter();" type="text" id="memberid" name="memberid" value="${smecimemberid}" >
			               		</TD>                                                                   
				               	<TD height="26" class="table_body">单据识别码</TD>
				               	<TD class="table_none">
	                              <input class="text_input160" type="text" id="djsbm" name="djsbm" value="${requestScope.djsbm}" onkeyup="selectContact(this)"/>
				               	</TD>							
							</c:when>
							<c:otherwise>
				                <TD width="8%" height="30" class="table_body">顾客卡号</TD>
		                        <TD class="table_none" colspan="3">
		                        	<input class="text_input100" onkeyup="OnKeyDownEnter();" type="text" id="memberid" name="memberid" value="${smecimemberid}" >
			               		</TD> 							
							</c:otherwise>
						</c:choose>  	               
                        </TR>         
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="26">						
							<td width="100%">
							  <c:if test="${(permissionPo.keya==1)}">
								<img id="submitimg" style="cursor: hand;" src="${ctx }/img/newbtn/btn_search_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_search_0.png');" onClick="javascript:search()">
								<img style="cursor: hand;" src="${ctx }/img/newbtn/btn_empty_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');" onClick="clean()">
							  </c:if>
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->

					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
					
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                         <th height="30" width="4%" scope="col">详细</th>
						  <th width="4%" scope="col">打印</th>
						  <th width="4%" scope="col">打印</th>
                          <th width="15%" scope="col">配镜单号</th> 
                          <th width="10%" scope="col">配镜类型</th> 
						  <th width="10%" scope="col">销售门店</th>
						  <th width="10%" scope="col">取镜地点</th>
                          <th width="8%" scope="col">顾客姓名</th>
                          <th width="10%" scope="col">联系电话</th>
						  <th width="12%" scope="col">配镜时间</th>
						  <th width="12%" scope="col">取镜时间</th>
 						  <th scope="col">邮寄</th>
						  </TR>
						  <tr class="row" onmouseover="mover(this,'#a2c1eb')" onmouseout="mout(this,'#cadee8')"> 
						  	<td>&nbsp;</td>
	                         <td>
	                         <img src="${ctx }/img/newbtn/print_0.png" btn=btn title="打印" style="cursor: hand;" onClick="batPrintGoodsBarCode1()"/>
				              </td>
							  <td height="26" ></td> 
							  <td><select name="printChooseflag" id="printChooseflag">
		                            <option value="">单据类型</option>
		                            <option value="0" ${requestScope.chooseflag == 1 ? 'selected="selected"' : '' }>框镜成品</option>
		                            <option value="D" ${requestScope.chooseflag == 2 ? 'selected="selected"' : '' }>框镜订做</option>
		                            </select></td>
							  <td></td>
							  <td ><select id="printDepartmentid" name="printDepartmentid">
      		                 	<option value="">销售门店</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentname}" >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select></td>
	                          <td><input class="text_input80" type="text" id="printCustomerName" name="printCustomerName" value="" ></td>
	                          <td>${ssesbphone }</td>
							  <td>${fn:substring(ssesbsalesdatetime,0,16) } </td> 
							  <td><input class="text_input80"
						       id="printTakeglassenddata"
						       name="printTakeglassenddata" value="${requestScope.ssesbtakeglassenddata}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'takeglassstartdata\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" /></td>
						       <td>&nbsp;</td><td>&nbsp;</td>
							  </tr>
							  
                    <c:if test="${not empty(salesBasicList ) }">
				      <s:iterator  value="salesBasicList">
                        <tr class="row" onmouseover="mover(this,'#a2c1eb')" onmouseout="mout(this,'#cadee8')"> 
                         <td>
                         <c:if test="${(permissionPo.keyc==1)}">
                         <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="winPopUp('${ssesbsalesid }')"/>
                         	</c:if>
			              </td>
                         <td>
                         <c:if test="${(permissionPo.keya==1)}">
                           <img src="${ctx }/img/newbtn/print_0.png" btn=btn title="打印" style="cursor: hand;" onClick="batPrintGoodsBarCode('${ssesbsalesid }','${ssesbcustomerid }','${fn:substring(ssesbtakeglassdata,0,16) }','${ssesblocation }','${fn:substring(ssesbsalesdatetime,0,16) }','${ssesbsalestype }')"/>
                         	</c:if>
			              </td>
                         <td>
                         	<img src="${ctx }/img/newbtn/print_0.png" btn=btn title="打印" style="cursor: hand;" onClick="doFRPrint('${ssesbsalesid }')"/>
			              </td>			              
						  <td height="26" >${ssesbsalesid }</td> 
						  <td>${ssesbchooseflag }</td>
						  <td>${ssesbshopcode }</td>
						  <td ${ssesbshopcode== ssesblocation  ? '' : 'style="color: red;"' }>${ssesblocation }</td>
                          <td>${ssesbcustomerid }</td>
                          <td>${ssesbphone }</td>
						  <td>${fn:substring(ssesbsalesdatetime,0,16) } </td> 
						  <td>${fn:substring(ssesbtakeglassdata,0,16) } </td>
						  <td><c:if test="${isMail ne ''}"><font color="blue">是</font></c:if></td>
                          </tr> 
                     </s:iterator>
                     </c:if>
                      </tbody> 
                    </table>
                     <c:if test="${not empty(salesBasicList ) }">
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
				<!--      BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
				<!--	 END 分页 -->
					</table>
					</c:if>
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