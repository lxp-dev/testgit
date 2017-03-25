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
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
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
    
    function integralExchangeselect(){
    	if($('#smecimemberid').val() == ''){
    		alert("请输入顾客卡号!");
   			return;
   		}
    	var integral = document.getElementById("jifen").value;
    	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selGoodsSingleExchange.action?integral="+integral,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGoodsSingleExchange.action?integral="+integral,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【积分兑换商品查询】";
    }

    function send()
    {
        
    	if($('input[id="goodsid"]').size() == 0){
			alert('请选择需要兑换的商品！');
			return ;
		}
		var integralcount=0;
		var number=$('input[id="integralCount"]').size();
		
		for(var i=0;i<number;i++)
		{
			integralcount=integralcount+parseFloat($('input[id="integralCount"]').eq(i).val());
		}
		if(integralcount>parseFloat(document.getElementById('jifen').value))
		{
			alert('您的积分不足，请重新选择商品！');
			return;
		}
    	$("img").removeAttr("onclick");
    	guitarMangermentForm.action='insertIntegralExchangeManagement.action';
	  	guitarMangermentForm.submit();
    }
    
    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selIntegralExchangeManagement.action";
		guitarMangermentForm.submit()
	}
    function openGoodSingleValues(goodsinfo)
    {	
		addRow(goodsinfo);
    }

    function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var row = table.insertRow(table.rows.length);
		row.onMouseOver="mover(this,'#a2c1eb')"
		row.onMouseOut="mout(this,'#cadee8')"
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		row.className = 'row';
		row.height="26";
		c1.height="26";
		c1.innerHTML = '<img id="del" src="${ctx }/img/newbtn/delete_0.png" btn=btn title="删除" onclick="$(this).parent().parent().remove();" />';
        c2.innerHTML = goodInfo.id + '<input type="hidden" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.id +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.code +'" />';
        c3.innerHTML = goodInfo.name+ '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goodInfo.name +'" />';
        c4.innerHTML = goodInfo.counts+ '<input type="hidden" id="integralCount" name="goodsInfoTempPo.integralCount" value="' + goodInfo.counts +'" />';
	
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
   		if($('#smecimemberid').val() == ''){
   	   		alert("请输入顾客卡号");
   			return;
   		}
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = 'selIntegralExchangeManagement.action';
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
		//alert(obj.value);
		obj.value = parseFloat(obj.value).toFixed(2);
		$('#zl').val(($('#psalsvalue').val().trim() - obj.value.trim()).toFixed(2));
	}
	
	/**
	 *回车事件
	 */
	
function selectCust(flag){
    if(flag){
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selIntegralExchangeManagement.action";
		guitarMangermentForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	 
	if(event.keyCode == 13){
	    var memberId=document.getElementById('smecimemberid').value;
		if(memberId==''){
			return false;
		}
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "selIntegralExchangeManagement.action";
		guitarMangermentForm.submit();
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
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>柜台销售</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：积分兑换 </td>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                   <TD >当前日期：&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /></TD> 
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
			</TR>
        </TBODY></TABLE>
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
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">积分兑换新增</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initIntegralExchangeManagementSel.action;'" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">积分兑换查询</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initWeiXinIntegralMSelectSel.action;'" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">微信积分兑换</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
					</TR>
					</TBODY></TABLE></TD>
					
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
					                 onkeyup="selectCustomer();" ${ person.bdplinkhisflag == '1' && systemParameterPo.fsphisflag == '2' ? 'readonly=readonly':'' }>
					                <input type="hidden" id="smecicustomerid" name="smecicustomerid" class="text_input100" 
					                	value="${customerInfoPo.smecicustomerid }">	
					          </li>
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					            </li>
					            <li class="horizontal">&nbsp;
					               <img src="${ctx }/img/newbtn/btn_dhlpxz_0.png" name="button222" title='兑换礼品选择' btn=btn onclick="integralExchangeselect();" >
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
					          <li class="horizontal">积分&nbsp;
					                <input id='jifen' value="${customerInfoPo.smeciintegral}" name="jifen" class="text_input60" readOnly="readOnly">
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
                    <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable" >
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder" id='addTable'>
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="4%" scope=col>操作</TH>
                          <TH height="26" width="30%" scope=col>商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="30%" scope=col>所需积分</TH>
                        </TR>     
               
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                      <TBODY>
                        <TR class="row" height="10" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center">
                          <table border="0"  width="30%">
                          	<tr>
                            	<td>
                                	
                                </td>
                                <td>
                                	<li class="horizontal_onlyRight">
                                	<img src="${ctx }/img/newbtn/btn_qrdh_0.png" btn=btn name="button32" title='确认兑换' onClick="send()" />  </li>
                           <li class="horizontal_onlyRight">
                          </li>
                                </td>
                            </tr>
                          </table>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
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
