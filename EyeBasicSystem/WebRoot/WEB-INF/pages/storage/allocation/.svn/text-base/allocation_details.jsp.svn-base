<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调拨管理</title>
</head>
<script>
	//条码批量打印
	function batPrintGoodsBarCode(){
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[pid=pcbarcode]");
			var goodsQuantitys = $("input[id=quantity]");
			var brandnames = $("input[id=brandname]");
			var sources = $("input[id=source]");
			var specs = $("input[id=spec]");
			var colors = $("input[id=color]");
			var retailprices = $("input[id=retailprice]");
			var guaranteeperiods = $("input[id=guaranteeperiod]");
			var batchs = $("input[id=batch]");
			
			var suffix;
			var barCount = 0;
			
			var barCode = new Array();
			var quantity = new Array();
			var brandname = new Array();
			var source = new Array();
			var spec = new Array();
			var color = new Array();
			var retailprice = new Array();
			var person = new Array();
			var guaranteeperiod = new Array();
			var batch = new Array();
			
			for(var i=0 ; i< barCodes.length; i++){
				if(ids[i].checked == true){
					person[person.length] = persons.val();
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					
					brandname[brandname.length] = brandnames[i].value;
					source[source.length] = sources[i].value;
					spec[spec.length] = specs[i].value;
					color[color.length] = colors[i].value;
					retailprice[retailprice.length] = retailprices[i].value;
					guaranteeperiod[guaranteeperiod.length] = guaranteeperiods[i].value;
					batch[batch.length] = batchs[i].value;
					/*alert(persons[0].value);
					alert(barCodes[i].value);
					alert(goodsQuantitys[i].value);
					alert(brandnames[i].value);
					alert(sources[i].value);
					alert(colors[i].value);
					alert(retailprices[i].value);
					alert(guaranteeperiods[i].value);
					alert(batchs[i].value);*/
					flag = true;
				}
			}

			if(flag == false){
				alert("请钩选要打印的商品条码！");
			}else{
				var printtype = {"1":"${systemParameterPo.fspframebarcodetype}"
					 ,"2":"${systemParameterPo.fsppartsbarcodetype}"
					 ,"3":"${systemParameterPo.fspglassbarcodetype}"
					 ,"4":"${systemParameterPo.fspstealthbarcodetype}"
					 ,"5":"${systemParameterPo.fspsolutionbarcodetype}"
					 ,"6":"${systemParameterPo.fspsunglassesbarcodetype}"
					 ,"7":"${systemParameterPo.fspconsumebarcodetype}"
					 ,"8":"${systemParameterPo.fspoldglassesbarcodetype}"
					 ,"9":"${systemParameterPo.fspmetropiabarcodetype}"};
				/*alert("条码："+barCode);
				alert("数量："+quantity);
				alert("品种："+brandname);
				alert("产地："+source);
				alert("规格："+spec);
				alert("色号："+color);
				alert("零售价："+retailprice);
				alert("定价员："+person);
				alert("打印样式："+printtype);
				alert("效期："+guaranteeperiod);
				alert("批号："+batch);*/
				try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,guaranteeperiod,batch);
				} catch(e) {
					alert("打印失败!请检查条码打印机是否正确连接!");
					return;
				}
			}
		}
	}

	function receiveAllocation(){
		$('#recTD').hide();
		$("img").removeAttr("onclick");
		allocationForm.action = "receiveAllocation.action";
		allocationForm.submit();
	}
    
    $(document).ready(function(){
   		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
		
		var needTotal=0;
		$('input[name=needNumber]').each(function(){
			needTotal=accAdd(needTotal,$(this).val());
		});
		$('#needTotal').text(needTotal);

		var priceamountTotal=0;
		$('input[name=priceamount]').each(function(){
			priceamountTotal=accAdd(priceamountTotal,$(this).val());
		});
		$('#goodsAmountTotal').text(priceamountTotal);
		
    });

    $(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <c:if test="${statusPo.cshastatusapplybillid != null}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__1 onclick="JavaScript:window.location.href='allocationApplyDetails.action?hid=${statusPo.cshastatusapplybillid}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">调拨申请单详细</TD>
                        <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    <c:if test="${statusPo.cshastatusorderid != null}">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initProcurementOrdersView.action?hid=${statusPo.cshastatusorderid}'"
                      UNSELECTABLE="on">采购订单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
					</c:if>
					<c:if test="${statusPo.cshastatusreceiptid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='procurementReceiptDetails.action?hid=${statusPo.cshastatusreceiptid}';"
                      UNSELECTABLE="on">采购收货单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if>  
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 background=${ctx}/img/pic/tab_active_bg.gif  UNSELECTABLE="on">商品调拨单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_active_right.gif" width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					<TD align="right" background=${ctx}/img/pic/tab_top_bg.gif>
			          	<c:if test="${allocationPo.cshaaconsignstate==0 && allocationPo.cshaaauditstate==1 && allocationPo.cshaaindepartmentid==person.departmentID}">
			          	<img src="${ctx }/img/newbtn/btn_querenshouhuo_0.png" btn=btn title='确认收货' onClick="javascript:receiveAllocation('${cshaabillid}')">
			          	</c:if>
                    	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
							<s:param name="actionTypeID">15</s:param>
                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_printbrand_0.png</s:param>
                    		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&billid=${allocationPo.cshaabillid}</s:param>
                    		<s:param name="actionReportingServiceRequestString"></s:param>
                    		<s:param name="actionReportTitle">调拨单(按品种)打印</s:param>
                    	</s:action>
                    </td>
                    <td width="5%" align="right" background=${ctx}/img/pic/tab_top_bg.gif> 	
                    	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
							<s:param name="actionTypeID">16</s:param>
                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_printgoods_0.png</s:param>
                    		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&billid=${allocationPo.cshaabillid}&isShowBatch=${systemParameterPo.fspstealtheffective }</s:param>
                    		<s:param name="actionReportingServiceRequestString"></s:param>
                    		<s:param name="actionReportTitle">调拨单(按商品)打印</s:param>
                    	</s:action>
                    </td>
					</TR>
        <TR>
          <TD bgColor=#ffffff colspan="3">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif ><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
					<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0 class="privateBorder" style='TABLE-LAYOUT: fixed'>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">调拨单号</TD>
                          <TD width="24%" class="table_none">&nbsp;${allocationPo.cshaabillid}<input type="hidden" id="cshaabillid" name="cshaabillid" value="${allocationPo.cshaabillid}"></TD>
                          <TD width="9%" class="table_body" height="26">关联单号</TD>
                          <TD width="24%" class="table_none">${allocationPo.cshaabillassociation}&nbsp;</TD>
                          <TD width="9%" class="table_body" height="26">调出部门</TD>
                          <TD class="table_none">${allocationPo.cshaaoutdepartmentname}&nbsp;</TD>	  			       
						</TR>
                        <TR>
                          <TD class="table_body" height="26">调出仓位</TD>
						  <TD class="table_none"> ${allocationPo.cshaaoutstockname}&nbsp;<input name="allocationPo.cshaaoutstockid" type="hidden" value="${allocationPo.cshaaoutstockid}"/></TD>
                          <TD class="table_body" height="26">调入部门</TD>
						  <TD class="table_none"> ${allocationPo.cshaaindepartmentname}&nbsp;</TD>
                          <TD class="table_body" height="26">调入仓位</TD>
                          <TD class="table_none" >${allocationPo.cshaainstockname}&nbsp;<input name="allocationPo.cshaainstockid" type="hidden" value="${allocationPo.cshaainstockid }"/></TD>             
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >${allocationPo.cshaacreatepersonname}&nbsp;</TD>
                          <TD class="table_body" height="26">单据日期</TD>
                          <TD class="table_none">${fn:substring(allocationPo.cshaabilldate,0,16)}&nbsp;</TD>	
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none" > ${allocationPo.cshaaauditpersonname}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核日期</TD>
                          <TD class="table_none" > ${fn:substring(allocationPo.cshaaauditdate,0,16)}&nbsp;</TD>
                          <TD class="table_body" height="26">收货人</TD>
                          <TD class="table_none">${allocationPo.cshaaconsigneename}&nbsp; </TD>
                          <TD class="table_body">收货日期</TD>
                          <TD class="table_none">${fn:substring(allocationPo.cshaaconsigndate,0,16)}&nbsp;</TD>
                        </TR>
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                          <TR>
                          <TD width="9%" height="26" class="table_body">商品类别</TD>
                          <TD width="24%" height="26" class="table_none" colspan="5">
                              ${allocationPo.goodscategoryname }
                          </TD>
                          </TR>
                          </c:if>	
                        <TR>
                          <TD class="table_body" width="9%">备注</TD>
                          <TD class="table_none" colSpan=5 style='word-WRAP: break-word'><label>
                          ${allocationPo.cshaaremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                           	<td align="right">
                           	<img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
					        </td>
					   </TR>
                    </TABLE>
					<table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>    
                          <TH width="3%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                      
                          <TH width="12%" scope=col height="28">商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="5%" scope=col>需求数量</TH>
                          <TH width="6%" scope=col>${allocationPo.whichretailname }</TH>
                          <TH width="5%" scope=col>调拨数量</TH>
                           <c:if test="${permissionPo.keyi eq '1'}">
                            <c:if test="${allocationPo.cshaaamounttype eq '1'}">
                                <TH width="6%" scope=col id="dj">含税单价</TH>
                                <TH width="6%" scope=col id="hj">价税合计</TH> 
                            </c:if>
                            <c:if test="${allocationPo.cshaaamounttype eq '2'}">
                                <TH width="6%" scope=col id="dj">单位成本</TH>
                                <TH width="6%" scope=col id="hj">成本合计</TH> 
                            </c:if>
                            <c:if test="${allocationPo.cshaaamounttype eq '3'}">
                                <TH width="6%" scope=col id="dj">批发单价</TH>
                                <TH width="6%" scope=col id="hj">批发合计</TH> 
                            </c:if>
                           </c:if>
                        
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
                           		<c:if test="${systemParameterPo.fspstealtheffective ne 1 && systemParameterPo.fspstealtheffective ne 2}"> 
                          		<TH width="15%" scope=col>商品条码</TH> 
                          		</c:if>	
                          		<c:if test="${systemParameterPo.fspstealtheffective eq 1 || systemParameterPo.fspstealtheffective eq 2}">  
                          		<TH width="15%" scope=col>商品条码</TH>
                          		<TH width="6%" scope=col>效期</TH>
                          		<TH width="6%" scope=col>批号</TH> 
                          		<TH width="6%" scope=col>注册证号</TH> 
                          		</c:if>
                           </c:if>
                                        
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH height="26" colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col id="goodsquantityTotal">0</TH>
					    	<c:if test="${permissionPo.keyi eq '1'}">
					    		<TH scope=col>&nbsp;</TH> 
					    		<TH scope=col id="goodsAmountTotal">0</TH>  
					    	</c:if>	
					    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
                           		<c:if test="${systemParameterPo.fspstealtheffective ne 1 && systemParameterPo.fspstealtheffective ne 2}"> 
                          			<TH scope=col>&nbsp;</TH> 
                          		</c:if>	
                          		<c:if test="${systemParameterPo.fspstealtheffective eq 1 || systemParameterPo.fspstealtheffective eq 2}">  
	                          		<TH scope=col>&nbsp;</TH>
	                          		<TH scope=col>&nbsp;</TH>
	                          		<TH scope=col>&nbsp;</TH> 
	                          		<TH scope=col>&nbsp;</TH> 
                          		</c:if>
                           </c:if>    
				   		</TR>
                        <s:iterator value="allocationEntryList" status="idx">
                        <TR id="rowrow" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">  
                        <TD height="26"><input id="chk" name="chk" type="checkbox" value="${cshaaegoodsBarCode }"></TD>
                        <TD height="26">${cshaaegoodsid}</TD>
                        <TD>${cshaaegoodsname}</TD>
                        <TD>${cshaaespec}</TD>
                        <TD>${cshaaerequirementquantity}</TD>
                        <TD>${cshaaebgiretailprice}<input type="hidden" class="text_input60" name="price" value="${cshaaebgiretailprice}" /></TD>
                        <TD>${cshaaeallocationquantity}<input type="hidden" class="text_input60" id=quantity name="goodsInfoTempPo.goodsquantity" value="${cshaaeallocationquantity}" /></TD>
                        <c:if test="${permissionPo.keyi eq '1'}">
                            <c:if test="${allocationPo.cshaaamounttype eq '1'}">
                                <TD>${cshaaecostprice}</TD>
                                <TD>${cshaaecostpriceamount}<input type="hidden" class="text_input60" name="priceamount" value="${cshaaecostpriceamount}" /></TD>
                            </c:if>
                            <c:if test="${allocationPo.cshaaamounttype eq '2'}">
                                <TD>${cshaaenottaxrate}</TD>
                                <TD>${cshaaenottaxrateamount}<input type="hidden" class="text_input60" name="priceamount" value="${cshaaenottaxrateamount}" /></TD>
                            </c:if>
                            <c:if test="${allocationPo.cshaaamounttype eq '3'}">
                                <TD>${cshaaewholesaleprice}</TD>
                                <TD>${cshaaewholesalepriceamount}<input type="hidden" class="text_input60" name="priceamount" value="${cshaaewholesalepriceamount}" /></TD>
                            </c:if>
                        </c:if>
                       
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                        
					    </c:if> 
					    
					    <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
                           		<c:if test="${systemParameterPo.fspstealtheffective ne 1 && systemParameterPo.fspstealtheffective ne 2}"> 
                          			<TD>${cshaaegoodsBarCode }<input type="hidden" id="selectGbc" pid=pcbarcode name="goodsInfoTempPo.goodsbarcode" value="${cshaaegoodsBarCode }" multiple="multiple" class="text_input200 gbc" />
			                        	<input type="hidden" id="spec" value="${cshaaespec }" />
								   		<input type="hidden" id="color" value="${cshaaecolor }" />
								   		<input type="hidden" id="retailprice" value="${cshaaebgiretailprice }" />
								   		<input type="hidden" id="person" value="${allocationPo.cshaacreatepersonname }" />
								   		<input type="hidden" id="brandname" value="${cshaaebrandname }" />
								   		<input type="hidden" id="source" value="${cshaaesource }" />
								   		<input type="hidden" id="guaranteeperiod" value="${cshaaeguaranteeperiod }" />
									   	<input type="hidden" id="batch" value="${cshaaebatch }" />
			                        </TD> 
                          		</c:if>	
                          		<c:if test="${systemParameterPo.fspstealtheffective eq 1 || systemParameterPo.fspstealtheffective eq 2}">  
	                          		<TD>${cshaaegoodsBarCode }<input type="hidden" id="selectGbc" pid=pcbarcode name="goodsInfoTempPo.goodsbarcode" value="${cshaaegoodsBarCode }" multiple="multiple" class="text_input200 gbc" />
			                        	<input type="hidden" id="spec" value="${cshaaespec }" />
								   		<input type="hidden" id="color" value="${cshaaecolor }" />
								   		<input type="hidden" id="retailprice" value="${cshaaebgiretailprice }" />
								   		<input type="hidden" id="person" value="${allocationPo.cshaacreatepersonname }" />
								   		<input type="hidden" id="brandname" value="${cshaaebrandname }" />
								   		<input type="hidden" id="source" value="${cshaaesource }" />
								   		<input type="hidden" id="guaranteeperiod" value="${cshaaeguaranteeperiod }" />
									   	<input type="hidden" id="batch" value="${cshaaebatch }" />
			                        </TD>  
			                        <TD>
			                        	${cshaaeguaranteeperiod }
			                        </TD> 
			                        <TD>
			                        	${cshaaebatch }
			                        </TD>
			                        <TD>
			                        	${cshaaeregistrationnum }
			                        </TD>
                          		</c:if>
                           </c:if> 
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
              </TD>
            </TR>
           </TBODY>
          </TABLE>
         </TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="3"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR>
                    <tr><td></td></tr>    
                    <TR>         
                    <TD class=menubar_readme_text vAlign=bottom>
          </TD></TR>
            </TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>