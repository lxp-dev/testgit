<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </HEAD>
<script>
	/**
	 *详情
	 */
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200,'',null,true);
		selectHidden();
	}
	
	/**
	 *聚焦
	 */
	window.onload=function(){
		document.getElementById('smecimemberid').focus();  
	}
	
	/**
	 *查看
	 */
	function selCustomerInfo(){
		showPopWin("","initSelCustomerInfoWin.action", screen.width-200,screen.height-200, '',null,true);
		selectHidden();
		putOptometryForm.action = "selectPutOptometry.action";
    }
    
    function deleteSalesID(salesid){
		showPopWin("","initGuitarManagementDelete.action?salesid=" + salesid, 400, 250, '',null,true);
		selectHidden();
    }
    
    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		guitarMangermentForm.action = "selGuitarManagement.action";
		$("img").removeAttr("onclick");
		guitarMangermentForm.submit()
	}
	
	/**
	 *回车事件
	 */
	function selectCustomer(){
		if(event.keyCode==13){
		var memberId=document.getElementById('smecimemberid').value;
		var salesId=document.getElementById('fmmsalesid').value;
			if(memberId=='' && salesId==''){
				return false;
			}
			guitarMangermentForm.action = "selGuitarManagement.action";
			$("img").removeAttr("onclick");
			guitarMangermentForm.submit();
		}
   }
   
   function setSalesValue(json){
   		$('#salseID').val(json.ssesbsalesid );// salesID
   		$('#priceSum').val(json.ssesbpricesum );// 原价合计
   		$('#discountNum').val(json.ssesbdiscountnum );// 折扣金额
   		$('#salseValue').val(json.ssesbsalesvalue );// 应收金额
   		$('#psalsvalue').val(json.ssesbpsalsvalue );// 实缴金额
   		
   		document.getElementById('jfButton').disabled = false;
   }
   
   function validate(){
   		if($('#salseID').val() == ''){
   			return;
   		}
		if(!confirm('请确认提交！')){
			return;
		}
		
		guitarMangermentForm.action = 'insertGuitarManagement.action';
		$("img").removeAttr("onclick");
		guitarMangermentForm.submit();
	}
	
	function validateNum(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		if (event.keyCode == 13) {
			if (obj.value.trim() == '' || !(/^[0-9]*([.][0-9]{1,2})?$/.test(obj.value.trim()))){
				alert('数字格式输入错误！');
				obj.select();
				return false;
			}
			//alert(obj.value);
			obj.value = parseFloat(obj.value).toFixed(2);
			$('#zl').val(($('#psalsvalue').val().trim() - obj.value.trim()).toFixed(2));
		}
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD class=menubar_readme_text vAlign=bottom></TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：结款管理</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif><TABLE cellSpacing=0 cellPadding=0 border=0>
            <TBODY>
              <TR>
                <!--ťStart-->
                <TD><TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">结款管理</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
												width=3></TD>
                      </TR>
                    </TBODY>
                </TABLE></TD>
              </TR>
            </TBODY>
          </TABLE></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr>
					        <td bgcolor="#cadee8"><li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="smecimemberid" class="text_input100" 
					                	value="${customerInfoPo.smecimemberid }" onkeyup="selectCustomer()" >
					          </li>
					            <li class="horizontal">
					              <input name="button22" type='button' value='查找' icon='icon-search' onclick="selCustomerInfo();" >
					            </li>
					            <li class="horizontal">配镜单号&nbsp;
					                <input id="fmmsalesid" name="fmmsalesid" class="text_input100" value="${fmmsalesid}" onkeyup="selCustomerInfo()">
					          </li>
					          <li class="horizontal">姓名&nbsp;
					                <input class="text_input60" readOnly="readOnly" value="${customerInfoPo.smeciname }">
					          </li>
					          <li class="horizontal">性别&nbsp;
					                <input value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">年龄&nbsp;
					                <input value="${customerInfoPo.fmmage }" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">&nbsp;
					            <input name="button32" type='button' value='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid }');" ${empty(customerInfoPo.smecicustomerid) ? 'disabled="disabled"': ''  }>
					          </li>
					      </tr>
					    </table>
					</fieldset>
                    <TABLE id=ctl00_PageBody_PostButton  cellSpacing=0 cellPadding=0 width="100%" border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
							<div align="right">
							  &nbsp;
							</div>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(salesBasicPos)}"> 
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="16%" height="30" scope=col>销售单号</TH>
                          <TH width="15%" scope=col>销售人员</TH>
                          <TH width="15%" scope=col>原价合计</TH>
                          <TH width="15%" scope=col>折扣金额</TH>
                          <TH width="15%" scope=col>应收金额</TH>
                          <TH width="15%" scope=col>实缴金额</TH>
                          <TH width="10%" scope=col>欠费金额</TH>
                          <TH width="8%" scope=col>查看</TH>
                          <TH width="8%" scope=col>缴费</TH>
                          <TH width="8%" scope=col>删除</TH>
                        </TR>
                        
                        <c:forEach var="po" items="${salesBasicPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>${po.ssesbsalesid }</TD>
                          <TD>${po.ssesbsalerName }</TD>
                          <TD>${po.ssesbpricesum }</TD>
                          <TD>${po.ssesbdiscountnum }</TD>
                          <TD>${po.ssesbsalesvalue }</TD>
                          <TD>${po.ssesbpsalsvalue }</TD>
                          <td>${po.ssesbarrearsvalue }</td>
                          <c:if test="${(ssesbcheckoutflag)==1}">
                          <TD><font color="red" ><fmt:formatNumber value='${po.ssesbarrearsvalue }' pattern="0.00"/></font></TD>
                          </c:if>
                          <c:if test="${(ssesbcheckoutflag)==0}">
                          <TD>&nbsp;</TD>
                          </c:if>
                          <TD><a href="#">
                            <input name="button32234" type='button' value='查看' align="left" onClick="javascript:showPopWin('About','销售单信息.htm',screen.width-100,screen.height-100, '',null,true);selectHidden(); ">
                          </a></TD>
                          <TD><input name="button3223" icon="icon-add-row" type='button' value='缴费' align="left" 
                          		onclick="setSalesValue({'ssesbsalesid' : '${po.ssesbsalesid }', 
                          				'ssesbpricesum' : '${po.ssesbpricesum }', 
                          				'ssesbdiscountnum' : '${po.ssesbdiscountnum }', 
                          				'ssesbsalesvalue' : '${po.ssesbsalesvalue }', 
                          				'ssesbpsalsvalue' : '${po.ssesbpsalsvalue }', 
                          				'ssesbarrearsvalue' : '${po.ssesbarrearsvalue }'});"></TD>
                          <TD><input name="button3222" icon="icon-delete" type='button' value='删除' align="left" onclick="deleteSalesID('${po.ssesbsalesid }');"></TD>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <br/>
                    <div id="queryInfo" align="center">
	<TABLE width="70%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable privateBorder">
        <tr>
        	<td class="qtCenterLine">
            	<TABLE width="100%">
				  <tr><input type="hidden" id="optometryID" name="optometryID" />
				  	  <input type="hidden" id="checkoutFlag" name="checkoutFlag"/>
					  <input type="hidden" id="salseType" name="salseType" />
					  <input type="hidden" id="recipeType" name="recipeType" />
					  <input type="hidden" id="ordersType" name="ordersType" />
				  	<td width="50%" class="table_body" align="right">销售单号：</td>
					<td width="50%" class="table_none">
						<input type="text" class="rb_inputText100" id="salseID" name="salseID" readonly="readonly" /></td>
				  </tr>
				  <tr>  	
				    <td class="table_body" align="right">原价合计：</td>
				    <td class="table_none">
						<input type="text" class="rb_inputText100" id="priceSum" name="priceSum" readonly="readonly" />
				    </td>
				  </tr>
				  <tr>  	
				    <td class="table_body" align="right">折扣金额：</td>
				    <td class="table_none">
						<input type="text" class="rb_inputText100" id="discountNum" name="discountNum" readonly="readonly" />
				    </td>
				  </tr>
				  <tr>  	
				    <td class="table_body" align="right">应收金额：</td>
				    <td class="table_none">    	
						<input type="text" class="rb_inputText100" id="salseValue" name="salseValue" value="" readonly="readonly" />
				    </td>
				  </tr>
				  <tr>
				    <td class="table_body" align="right">实缴金额：</td>
				    <td class="table_none"><input type="text" class="rb_inputText100" id="psalsvalue" name="psalsvalue" value="" readonly="readonly" />
				    </td>
				  </tr>
				  <tr>
				    <td class="table_body" align="right">缴费金额：</td>
				    <td class="table_none">
				    	<input type="text" class="rb_inputText100" id="jf" value="" onkeyup="validateNum(this);" onblur="validateNum(this);"/>&nbsp;&nbsp;
				  	</td>
				  </tr>
				  <tr>
				  	<td class="table_body" align="right">
						<span style="color:red">找零：</span>
					</td>
					<td class="table_none">
						<input type="text" class="rb_inputText100" id="zl" style="color:red" value="" readonly="readonly" />
				    </td>
				  </tr>
				</table>
		</td></tr>
</table>
</div>
<div id="queryInfo" align="center">
	<table class="queryInfoTable">
		<tr>
			<td align="center" height="30">
				<input id="jfButton" name="jfButton" icon="icon-add-row" type='button' value='缴费' onClick="validate();">
			</td>
		</tr>
		</table>
</div>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
