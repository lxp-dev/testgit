<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FrameTitle</title><style type="text/css">
.salesout{
background:transparent;border:0px;
}
</style>
</head>

<script>
	function salesout(item){
		$(item).addClass('salesout');
	}
	function salesover(item){
		$(item).removeClass('salesout');
	}
	function parseData(arg0){
		arg0=arg0.toString();
		 if(param==1){
				if(arg0.indexOf('.')!=-1){
					arg0=arg0.substring(0,arg0.indexOf('.'));
				}
				arg0=arg0+".00";
		}else if(param==2){
				if(arg0.indexOf('.')!=-1){
					arg0=arg0.substring(0,arg0.indexOf('.')+2);
					arg0=arg0+"0";
				}else {
					arg0=arg0+".00";
				}
		}
		return arg0;
	}
	/*
	整单打折 
	*/
	var param=2;//所舍位数 1保留至元2保留至毛
	/*
	打折开窗
	*/
	function discount1(){
		showPopWin("","initPersonDiscountSelect.action",screen.width-600,screen.height-500, '', null, true);
		selectHidden();
	}
	/*
	整单打折开窗回调
	*/
	function setDiscount1(discount){
		$('#ssespbnewdiscountrate').val(discount);
		$('input[name=salesPostDetailPo.ssespddiscountrate]').each(function(){
			if($(this).val()!='0.00'){
				$(this).val(discount);
				var oldDetailYs=$(this).parent().parent().find('.oldDetailPost').val();
				$(this).parent().parent().find('.yssum').val(parseData(accMul($(this).parent().parent().find('.pricesums').val(),discount)));
				$(this).parent().parent().find('.postvalue').val(parseData(accAdd(oldDetailYs,'-'+$(this).parent().parent().find('.yssum').val())));
				$(this).parent().parent().find('.zksum').val(parseData(accAdd($(this).parent().parent().find('.pricesums').val(),'-'+$(this).parent().parent().find('.yssum').val())));
			}
		});
		
		var ystotal=0;
		$('input[name=salesPostDetailPo.ssespdsalesvalue]').each(function(){
			ystotal=accAdd(ystotal,$(this).val());
		});
		
		$('#ssespbnewpsalsvalue').val(parseData(ystotal));
		
		var oldys='${salesBasicPo.ssesbsalesvalue}';
		
		$('#ssespbpostvalue').text(parseData(accAdd(oldys,'-'+ystotal)));
		$('#ssespbnewdiscountnum').text(parseData(accAdd('${salesBasicPo.ssesbpricesum }','-'+ystotal)));
	}
	/*
	单品打折
	*/
	function discount2(item){
		showPopWin("","initPersonDiscountSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),screen.width-600,screen.height-500, '', null, true);
		selectHidden();
	}
	
	function setDiscount2(discount2,rownumber){
		$('tr[id=goodsrow]').find('.yssum')[rownumber].value=parseData(accMul($('tr[id=goodsrow]').find('.pricesums')[rownumber].value,discount2));
		$('tr[id=goodsrow]').find('.zksum')[rownumber].value=parseData(accAdd($('tr[id=goodsrow]').find('.pricesums')[rownumber].value,'-'+$('tr[id=goodsrow]').find('.yssum')[rownumber].value));
		$('tr[id=goodsrow]').find('.discount')[rownumber].value=discount2;
		$('tr[id=goodsrow]').find('.postvalue')[rownumber].value=parseData(accAdd($('tr[id=goodsrow]').find('.oldDetailPost')[rownumber].value,'-'+accMul(discount2,$('tr[id=goodsrow]').find('.pricesums')[rownumber].value)));
		alert($('tr[id=goodsrow]').find('.postvalue')[rownumber].value);
		
		var ystotal=0;
		$('input[name=salesPostDetailPo.ssespdsalesvalue]').each(function(){
			ystotal=accAdd(ystotal,$(this).val());
		});
		
		$('#ssespbnewpsalsvalue').val(parseData(ystotal));
		
		var oldys='${salesBasicPo.ssesbsalesvalue}';
		
		$('#ssespbpostvalue').text(parseData(accAdd(oldys,'-'+ystotal)));
		
		$('#ssespbnewdiscountnum').text(parseData(accAdd('${salesBasicPo.ssesbpricesum }','-'+ystotal)));
	}
	
	$(document).ready(function(){
		
		$('input').each(function(){
			$(this).attr("readyonly","readonly");
		});
	});
	
	
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="diffPriceForm"  action="">
<input type=hidden name="salesPostBasicPo.ssespbnewdiscountnum"/>
<input type=hidden name="salesPostBasicPo.ssespbpostvalue"/>
<input type=hidden name="salesPostBasicPo.ssespbnewarrearsvalue"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;退差价管理</TD>
 				<TD class=menubar_readme_text vAlign=bottom><div align="right">
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="显隐查询条件" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                      </TR>
                    </TBODY>
                  </TABLE>
			    </div>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：退差价管理</TD>
          <TD class=menubar_function_text align=right>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" 
                onmouseout=javascript:MenuOnMouseOver(this);></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->

					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 

                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">配镜单查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					
					</TR>
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
                        <TR>
                          <TD width="15%" height="30" class="table_body">配镜单号</TD>
                          <TD width="35%" class="table_none"><input type="hidden" name="salesPostBasicPo.ssespbsalesid" value="${salesBasicPo.ssesbsalesid }"/>${salesBasicPo.ssesbsalesid }</TD>
                          <TD width="15%" class="table_body">配镜门店</TD>
                          <TD width="35%" class="table_none">${salesBasicPo.ssesbshopName }</TD>
                          
                        </TR>
                        <TR>
                          <TD class="table_body">顾客姓名</TD>
                          <TD class="table_none">${salesBasicPo.ssesbpersonName }</TD>
						                          <TD class="table_body" height="30">顾客电话</TD>
                                                  <TD class="table_none">${salesBasicPo.ssesbphone }</TD>
                          </TR>
                                                <TR >
                                                  <TD class="table_body">配镜时间</TD>
                                                  <TD class="table_none" >${fn:substring(salesBasicPo.ssesbsalesdatetime,0,16) }</TD>
                                                  <TD class="table_body" height="30">取镜时间</TD>
                                                  <TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,16) }</TD>
						                            
                        </TR>
                                                <TR >
                                                  <TD class="table_body">原价金额</TD>
                                                  <TD class="table_none" >${salesBasicPo.ssesbpricesum }</TD>
                                                  <TD class="table_body" height="30">应收金额</TD>
                                                  <TD class="table_none">${salesBasicPo.ssesbsalesvalue }</TD>
						                            
                        </TR>
                                                                        <TR >
                                                  <TD class="table_body">折扣率</TD>
                                                  <TD class="table_none" >${fn:substring(salesBasicPo.ssesbdiscountrate,0,4) }</TD>
                                                  <TD class="table_body" height="30">折扣金额</TD>
                                                  <TD class="table_none">${salesBasicPo.ssesbdiscountnum }</TD>
						                            
                        </TR>
                                    <TR >
                                                  <TD class="table_body">实缴金额</TD>
                                                  <TD class="table_none" >${salesBasicPo.ssesbpsalsvalue }</TD>
                                                  <TD class="table_body" height="30">欠款金额</TD>
                                                  <TD class="table_none">${salesBasicPo.ssesbarrearsvalue}</TD>
						                            
                        </TR>
                        
                        </TBODY>
                    </TABLE>
                    							<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
							  <TBODY>
                                <TR>
                                              <TD></TD>
                                              <td></td>
                                                                      </TR>
                        </TBODY>
                    </TABLE>
							<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
							  <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                          </TABLE>
                              <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder privateTable">
                                <tr>
                                  <td width="18%" height="30" class="table_body"><div align="center">商品代码</div></td>
                                  <td width="22%" class="table_body"><div align="center">名称</div></td>
                                  <td width="8%" class="table_body"><div align="center">单价</div></td>
                                  <td width="8%" class="table_body"><div align="center">数量</div></td>
                                  <td width="8%" class="table_body"><div align="center">原价</div></td>
                                  <td width="8%" class="table_body"><div align="center">折扣率</div></td>
                                  <td width="8%" class="table_body"><div align="center">折扣金额</div></td>
                                  <td width="8%" class="table_body"><div align="center">应收金额</div></td>
                                </tr>
                                <s:iterator value="salesDetailList" status="index">
                                <tr id="goodsrow">
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespdsalesitemid" class="text_input100" value="${ssesdsalesitemid }" readOnly="readOnly"></td>
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespdsalesitemname" class="text_input100" value="${ssesdsalesitemname }" readOnly="readOnly"></td>
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespdsprice" class="text_input100" value="${ssesdsprice }" readOnly="readOnly"></td>
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespdnumber" class="text_input100" value="${ssesdnumber }" readOnly="readOnly"></td>
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespdpricesum" class="text_input100 pricesums" value="${ssesdpricesum }" readOnly="readOnly"></td>
                                  <td class="Privateborder"><input style="width:100%"  name="salesPostDetailPo.ssespddiscountrate" class="text_input100 salesout discount" value="${ssesddiscountrate }" onClick="discount2(this)" readOnly="readOnly"/><input type="hidden"  value="${index.index}" class="rownumber"/> </td>
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespddiscountnum" class="text_input100 zksum" value="${ssesddiscountnum }" readOnly="readOnly"></td>
                                  <td class="Privateborder"><input style="width:100%;background:transparent;border:0px;" name="salesPostDetailPo.ssespdsalesvalue" class="text_input100 yssum" value="${ssesdsalesvalue }" readOnly="readOnly"><input type="hidden" value="${ssesdsalesvalue }" class="oldDetailPost" name="oldDetailPost"/> <input class="postvalue" type="hidden" name="salesPostDetailPo.ssespdpostvalue"/></td>
                                </tr>
                              </s:iterator>
                              </table>
                              <c:if test="${not empty(additionalList)}">
   							  <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
							  <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                          </TABLE>
							<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="10%" height="30">附加费用名称</TH>
						  <TH scope=col width="20%">附加费用金额</TH>						
                          </TR>
                         <s:iterator value="additionalList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD height="28">${ssecostsname}</TD>
						  <TD>${sseamount}</TD>
                          </TR>
                          </s:iterator> 
                      </TBODY>
                    </TABLE>
</c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"></TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    </form>
    </BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>