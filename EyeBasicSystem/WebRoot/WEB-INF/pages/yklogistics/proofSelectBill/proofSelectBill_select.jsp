<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证管理</title>
</head>
<script>	

 	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
	    $('#shopCode').val('${shopNum}');
	    document.getElementById('billid').focus();  
	}); 
	
	function search(){	    
	    var stockID = document.getElementsByName("stockID");
	    if (stockID.length != 0){
	        if (stockID[0].value == ''){
                alert("请选择一个仓位!");
                return;	        
	        }
	    }
	    $("img").removeAttr("onclick");
		selectBill.action = "ykselectSelectBills.action";
		selectBill.submit();
		showLoadingBar();
	}
	
	function billinfo(id,billType){
		document.all.hid.value = id;
		openPopWindow("ykinitBillInfoSels.action?hid="+id+"&billType="+billType+"&moduleID=${moduleID}","单据详细");
	}

	function clean(){
	    document.all.billid.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.invoiceState.value="";
	}	
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		openPopWindow("ykselSupplierOpen.action","制造商查询");
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    /**
	 *  调用页面赋值
	 */
	function setValue(){
		var billID='';
		$('input[name=chk]:checked').each(function(){
			billID=billID+$(this).val()+',';
		});
		
		if(billID.indexOf(',') < 0){
			alert('请选择商品!');
        	return false;
		}
		
		window.parent.openGoodSingleValues(billID.substring(0,billID.length-1));
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}

	function openPopWindow(url,msg){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【"+msg+"】";	
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form name="selectBill" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="sVoucherType" id="sVoucherType" value="${requestScope.sVoucherType}" />
<input type="hidden" name="voucherID" id="voucherID" value="${requestScope.voucherID}" />
<input type="hidden" name="voucherDate" id="voucherDate" value="${requestScope.voucherDate}" />
<input type="hidden" name="createPerson" id="createPerson" value="${requestScope.createPerson}" />
<input type="hidden" name="remark" id="remark" value="${requestScope.remark}" />
<input type="hidden" name="billtype" id="billtype" value="${requestScope.type}" /> 

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
						   <TD width="10%" height="30" class="table_body">单据编号</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input200" type="text" id="billid" name="billid" maxlength=22 value="${requestScope.billid}">
			               </TD>
			               <TD width="10%" height="30" class="table_body">单据日期</TD>
                           <TD class="table_none" width="40%">
                         <li class="horizontal_onlyRight">
                            <input id="startTime"
					       	name="startTime" 
					       	type="text" class="text_input100" 
					      	onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       	value="${startTime }" /> 
					       	至 
					       	<input id="endTime"
					       	name="endTime" 
					       	type="text" class="text_input100" 
					       	onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" />
					        
					       </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('startTime','endTime')"></li>
                            
			               </TD>
                        </TR>
                    	<TR>
                    	   <TD width="10%" height="30" class="table_body">单据类型</TD>
			               <TD class="table_none">
			               		<input type="hidden" name="savebilltype" id="savebilltype" value="${requestScope.billtype}" />
			               	<select id="billtype" name="billtype" disabled> 
                               <option value="">----请选择----</option> 
                               <option value="1" ${billtype == '1' ? 'selected="selected"' : '' }>采购收货单</option>
                               <option value="2" ${billtype == '2' ? 'selected="selected"' : '' }>采购退货单</option>
                           	   <option value="3" ${billtype == '3' ? 'selected="selected"' : '' }>销售出库单</option>
                           	   <option value="5" ${billtype == '5' ? 'selected="selected"' : '' }>盘盈单</option>
                           	   <option value="6" ${billtype == '6' ? 'selected="selected"' : '' }>盘亏单</option>
                           	   <option value="7" ${billtype == '7' ? 'selected="selected"' : '' }>其他入库单</option>
                           	   <option value="8" ${billtype == '8' ? 'selected="selected"' : '' }>其他出库单</option>
                           	   <option value="9" ${billtype == '9' ? 'selected="selected"' : '' }>委外收货单</option>
                            </select> 
                           </TD>
                           <TD width="10%" height="30" class="table_body">核销状态</TD>
			               <TD class="table_none">
			               	<select id="invoiceState" name="invoiceState"> 
                               <option value="" ${invoiceState == '' ? 'selected="selected"' : '' }>----请选择----</option> 
                               <option value="0" ${invoiceState == '0' ? 'selected="selected"' : '' }>未核销</option>
                           	   <option value="1" ${invoiceState == '1' ? 'selected="selected"' : '' }>部分核销</option>
                           	   <option value="2" ${invoiceState == '2' ? 'selected="selected"' : '' }>完全核销</option>
                            </select> 
                           </TD>
                        </TR>
                        <c:if test="${type != '3' && type != '7' && type != '8'}">
                        <TR>
                    	   <TD width="10%" height="30" class="table_body">制造商</TD>
			               <TD class="table_none" colspan="3">
			               ${requestScope.supplierName}
						   	<input class="text_input200" type="hidden"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   	<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
                           </TD>
                        </TR> 
                        </c:if>
                        <c:if test="${type == '8'}">
                        <TR>
                    	   <TD width="10%" height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
			               ${requestScope.supplierName}
						   	<input class="text_input200" type="hidden"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   	<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
                           </TD>
                    	   <TD width="10%" height="30" class="table_body">门店名称</TD>
			               <TD class="table_none" colspan="3">
						   	   <select id="shopCode" name="shopCode"}>      		                       
      		                       <s:iterator value="salesShopList">
      		                           <option value="${shopID}">${shopName}</option>
      		                       </s:iterator>
      	                       </select>
                           </TD>
                        </TR> 
                        </c:if>
                        <c:if test="${type == '3'}">
                        <TR>
                    	   <TD width="10%" height="30" class="table_body">门店名称</TD>
			               <TD class="table_none" colspan="3">
						   	   <select id="shopCode" name="shopCode"}>      		                       
      		                       <s:iterator value="salesShopList">
      		                           <option value="${shopID}">${shopName}</option>
      		                       </s:iterator>
      	                       </select>
                           </TD>
                        </TR> 
                        </c:if> 
                        <input name="typeID" type="hidden" value='${type}'>                     
                      </TBODY>
                    </TABLE> 
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                            <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title='选择' onClick="setValue();">
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
					<c:if test="${not empty(selectBillList)}">
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
                          <TH width="10%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH width="15%" scope=col>单据编号</TH>						
						  <TH width="15%" scope=col>单据类型</TH>
						 <c:if test="${type != '3' && type != '8'}">
						  <TH width="25%" scope=col>制造商</TH>
						 </c:if>
						 <c:if test="${type == '3'}">
						  <TH width="25%" scope=col>销售部门</TH>
						 </c:if>
						 <c:if test="${type == '8'}">
						  <TH width="25%" scope=col>发出部门</TH>
						 </c:if>
						  <TH width="15%" scope=col>单据日期</TH>
						  <TH width="10%" scope=col>核销状态</TH> 
						  <TH width="10%" scope=col>详细</TH>
						  </TR>
						<s:iterator value="selectBillList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="30">
                          <c:if test="${cstifinanceauditstate==0 || cstifinanceauditstate==1 || cstienottaxrate!=0}">
                          		<input type="checkbox" id="chk" name="chk" value="${cstibillid}">
                          </c:if>
                           </TD>
                          <TD>${cstibillid}</TD>
                          
                          <TD>
                          <c:if test="${cstibilltypeid==1}">
                         	采购收货单
                          </c:if>
                          
                          <c:if test="${cstibilltypeid==9}">
                         	委外收货单
                          </c:if>
                          
                          <c:if test="${cstibilltypeid==2}">
                          	采购退货单
                          </c:if>
                          
                          <c:if test="${cstibilltypeid==7}">
                          	其它入库单
                          </c:if>
                          
                          <c:if test="${cstibilltypeid==8}">
                          	其它出库单
                          </c:if>
                          
                          <c:if test="${cstibilltypeid==3}">
                          	销售出库
                          </c:if>
                          </TD>
						  <TD>
						     <c:if test="${type != '3'}">
						       ${cstisuppliername}
						     </c:if>
						     <c:if test="${type == '3'}">
						       ${cstidepartmentname}
						     </c:if>
						     <c:if test="${type == '8'}">
						       ${cstidepartmentname}
						     </c:if>
						 </TD>
                          <TD>${fn:substring(cstibilldate,0,10)}</TD>
                          
                          <TD>
                          <c:if test="${cstibilltypeid!=8 && cstibilltypeid!=7}">
                          	 <c:if test="${cstifinanceauditstate==0}">
                          	   未核销
                             </c:if>                          
                             <c:if test="${cstifinanceauditstate==1}">
                          	  部分核销
                             </c:if>                          
                             <c:if test="${cstifinanceauditstate==2}">
                          	  完全核销
                             </c:if>
                          </c:if>
                          </TD>
                          <TD>
		                     <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:billinfo('${cstibillid}','${cstibilltypeid}')">
		                  </TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
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