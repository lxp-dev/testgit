<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>外批送货管理</title>
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

    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("consignProcessOrderDetailsTempPo.cstcpodnum");

		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	window.onload = function(){
		amount();
	};	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="consignProcessDeliverForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
             <s:action name="getFittingTemplateTypeInfo" executeResult="true">
				<s:param name="actionTypeID">28</s:param>
           		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
           		<s:param name="actionFinereportRequestString"></s:param>
           		<s:param name="actionReportingServiceRequestString">&cstddeliverbillid=${deliverPo.cstddeliverbillid}</s:param>
           		<s:param name="actionReportTitle">委外送货单打印</s:param>
             </s:action>           	
          </TD>
        </TR>
       </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->    
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
		</TR>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="30">单据编号</TD>
                          <TD width="24%" class="table_none">${deliverPo.cstddeliverbillid}<input type="hidden" id="cstddeliverbillid" name="deliverPo.cstddeliverbillid" value="${deliverPo.cstddeliverbillid}"></TD>                         
						  <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">
						  ${fn:substring(deliverPo.cstddeliverdate,0,10)}
                          <input name="deliverPo.cstddeliverdate" type="hidden" value="${fn:substring(deliverPo.cstddeliverdate,0,10)}"/>
						  </TD>
						  <TD width="9%" class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >
                          ${deliverPo.cstdcreatepersonname}<input type="hidden" name="deliverPo.cstdcreateperson" value="${deliverPo.cstdcreateperson}">
                          </TD>
                        </TR>
                        <TR>                          				       
                          <TD class="table_body" height="26">送货单位</TD>
                          <TD class="table_none">${deliverPo.cstddeliverdept}<input type="hidden" id="cstddeliverdept" name="deliverPo.cstddeliverdept" value="${deliverPo.cstddeliverdept}"></TD>
						  <TD width="9%" class="table_body">审核日期</TD>
                          <TD width="24%" class="table_none">
						  ${fn:substring(deliverPo.cstdauditdate,0,10)}
						  </TD>
						  <TD width="9%" class="table_body" height="26">审核人</TD>
                          <TD class="table_none" >
                          ${deliverPo.cstdauditpersonname}
                          </TD>						
						</TR>
                        <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colSpan=5>${deliverPo.cstdremark}</TD>
                        </TR>
                      </TBODY>
                    </TABLE>

					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
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
                          <TH width="15%" scope=col height="26">配镜单号</TH>
                          <TH width="8%" scope=col>顾客名称</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="3%" scope=col>R/L</TH>
                          <TH width="5%" scope=col>球镜</TH>
                          <TH width="5%" scope=col>柱镜</TH>
                          <TH width="3%" scope=col>轴向</TH>
                          <TH width="3%" scope=col>下加</TH> 
                          <TH width="3%" scope=col>棱镜</TH>
                          <TH width="3%" scope=col>基底</TH>
                          <TH width="3%" scope=col>曲率</TH>
                          <TH width="3%" scope=col>直径</TH> 
                          <TH width="16%" scope=col>特殊加工要求</TH>                            
                          <TH width="5%" scope=col>数量</TH>    
                      
                        </TR>
                    	<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=13 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
				   		<s:iterator value="consignProcessOrderDetailsList" status="idx">
                        <TR class="row">
                        <TD height="28">${cstcpodglassesbillid}
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcprdreceiptbilld" value="${cstcprdreceiptbilld}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodid" value="${cstcpodid}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodglassesbillid" value="${cstcpodglassesbillid}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodgoodsid" value="${cstcpodgoodsid}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodgoodsbarcode" value="${cstcpodgoodsbarcode}" />
                        <input type="hidden" name="consignProcessOrderDetailsTempPo.cstcpodnum" value="${cstcpodnum}" />
                        </TD>
                        <TD>${cstcpodcustomername}</TD>
                        <TD>${cstcpodgoodsname}</TD>
                        <TD>${cstcpodglassflag}</TD>                        
                        <TD>${cstcpodballglass}</TD>
                        <TD>${cstcpodpostglass}</TD>
                        <TD>${cstcpodaxes}</TD>
                        <TD>${cstcpodadd}</TD>
                        <TD>${cstcpodarriseglass}</TD>
                        <TD>${cstcpodbasis}</TD>
                        <TD>${cstcpodeyecurvature}</TD>
                        <TD>${cstcpoddiameter}</TD>
                        <TD>${cstcpodrequirement}</TD>                          
                        <TD>${cstcpodnum}</TD>    
                                                                                                                                                 
                        </TR>
                        </s:iterator>                        
                      </TBODY>
                    </TABLE>

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