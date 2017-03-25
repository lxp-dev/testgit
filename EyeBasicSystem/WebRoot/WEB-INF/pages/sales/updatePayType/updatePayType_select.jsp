<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </HEAD>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }
	});

	/**
	 *销售结款弹窗
	 */
	function cashOpen(id,ssesborderstype,sseslpaymenttype){
		if('${bwcflag}' == ''){
			alert("请设置本部门出仓配置！");
			return;
		}
		var moduleID = $('input[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertUpdatePayType.action?hid="+id+"&moduleID="+moduleID+"&ssesborderstype="+ssesborderstype+"&sseslpaymenttype="+sseslpaymenttype,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertUpdatePayType.action?hid="+id+"&moduleID="+moduleID+"&ssesborderstype="+ssesborderstype+"&sseslpaymenttype="+sseslpaymenttype,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【银台更新结款方式新增】";
    }
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【顾客信息】";
	}
	
	/**
	 *查看
	 */
	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
    }
    
    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selUpdatePayType.action";
		guitarMangermentForm.submit()
	}
	

   
   function setSalesValue(json){
   		$('#salseID').val(json.ssesbsalesid );// salesID
   		$('#priceSum').val(json.ssesbpricesum );// 原价合计
   		$('#discountNum').val(json.ssesbdiscountnum );// 折扣金额
   		$('#salseValue').val(json.ssesbsalesvalue );// 应收金额
   		$('#psalsvalue').val(json.ssesbpsalsvalue );// 实缴金额
   		$('#ssesborderstype').val(json.ssesborderstype);//订单类型
   		$('#ssesbarrearsvalue').val(json.ssesbarrearsvalue);//欠款
   		$('#checkoutFlag').val(json.ssesbcheckoutflag);
   		document.getElementById('jfButton').disabled = false;
   }
   
   function validate(){
   		if($('#salseID').val() == ''){
   			return;
   		}
		if(!confirm('请确认提交！')){
			return;
		}
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = 'insertGuitarManagement.action';
		guitarMangermentForm.submit();
	}
	
	function validateSales(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		
		if(!isNaN(obj.value.trim())){
			$('#zl').val(($('#psalsvalue').val().trim() - obj.value.trim()).toFixed(2));
		}
	}
	
	function validateSalesFocus(obj){
		if(obj.value.trim() == ''){
			$('#zl').val('0.00');
			return ;
		}
		if (obj.value.trim() == '' || !(/^[0-9]*([.][0-9]{1,2})?$/.test(obj.value.trim()))){
			alert('数字格式输入错误！');
			obj.select();
			return false;
		}
		obj.value = parseFloat(obj.value).toFixed(2);
		$('#zl').val(($('#psalsvalue').val().trim() - obj.value.trim()).toFixed(2));
	}
	
	/*配镜单信息*/
	function winPopUp(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	}
	
	
		/**
	 *回车事件
	 */
	
function judgekey(){
     if(event.keyCode==13){
		var memberId=document.getElementById('smecimemberid').value;
		var salesId=document.getElementById('fmmsalesid').value;
			if(memberId=='' && salesId==''){
				return false;
			}
			$("img").removeAttr("onclick");
			guitarMangermentForm.action = "selUpdatePayType.action";
			guitarMangermentForm.submit();
	}
}
function selectCust(flag){
    if(flag){
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selUpdatePayType.action";
		guitarMangermentForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			$("img").removeAttr("onclick");
			guitarMangermentForm.action = "selUpdatePayType.action";
			guitarMangermentForm.submit();
		}
	}
}	
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：更改结款方式 </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3" align=right><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20px"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif ><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr height="26">
					        <td bgcolor="#cadee8">
					        
					          <li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid }" 
					                onkeyup="selectCustomer();" ${systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }>
					          </li>
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					            </li>
					            <li class="horizontal">配镜单号&nbsp;
					                <input id="fmmsalesid" name="fmmsalesid" class="text_input160" onkeyup="judgekey();" value="${customerInfoPo.fmmsalesid }">
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
					          <c:if test="${empty(customerInfoPo.smecicustomerid)}"></c:if>
					          <c:if test="${not empty(customerInfoPo.smecicustomerid)}">
					            <img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详情' onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
					          </c:if>
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
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" scope=col colspan="2">操作</TH>
                          <TH height="26" scope=col>销售单号</TH>
                          <TH width="9%" scope=col>缴费类型</TH>
                          <TH width="8%" scope=col>销售人员</TH>
                          <TH width="9%" scope=col>原价合计</TH>
                          <TH width="7%" scope=col>折扣金额</TH>
                          <TH width="7%" scope=col>抹零金额</TH>
                          <TH width="9%" scope=col>应收金额</TH>
                          <TH width="9%" scope=col>缴费金额</TH>
                          <TH width="16%" scope=col>缴费日期</TH>
                        </TR>
                        
                        <c:forEach var="po" items="${salesBasicPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${po.sseslpaymenttype == '4' ? 'style="color: red;"':''}>
                          <TD height="26" width="3%">
                            <img src="${ctx }/img/newbtn/search_0.png" name="button32234" title='配镜单详情' btn=btn onClick="winPopUp('${po.ssesbsalesid }')">
                          </TD>
                          <TD width="3%">
                          <c:if test="${(permissionPo.keya==1)}">
                          <img src="${ctx }/img/newbtn/pay_0.png" name="pay" btn=btn title='缴费' onclick="cashOpen('${po.ssesbsalesid}','${po.ssesborderstype }','${po.sseslpaymenttype }')">
                          </c:if>
                          <c:if test="${(permissionPo.keya!=1)}">
                          &nbsp;
                          </c:if>
                          </TD>
                          <TD>${po.ssesbsalesid }</TD>
                          <TD>${po.sseslpaymenttypename }</TD>
                          <TD>${po.ssesbsalerName }</TD>
                          <TD>${po.ssesbpricesum }</TD>
                          <TD>${po.ssesbdiscountnum }</TD>
                          <TD>${po.ssesbrenums }</TD>
                          <TD>${po.ssesbsalesvalue }</TD>
                          <TD>${po.sseslprice }</TD>
                          <TD>${po.ssesldatetime }</TD>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    </c:if>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif colspan="2"><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
