<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐查询</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

    	$('tr[hide=hide]').each(function(){
            $(this).hide();
        });
	});

	function showLoadingBar(){
	}
	
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSetmealDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSetmealDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【套餐详细】";
	}

	function setValue(value){
        var objValue="";
        $("input[setMealID="+value+"]").each(function(){    
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
		});
        objValue="["+objValue+"]";
        
        window.parent.openGoodSingleValues(objValue);
        parent.hidePopWin();
        parent.toRound();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

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
          background=${ctx}/img/pic/tab_bg.gif>
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
                          <TH width="4%" scope=col>选择</TH>
                          <TH width="4%" scope=col>详细</TH>
                          <TH width="30%" height="26" scope=col>套餐标题</TH>
                          <TH width="10%" scope=col>套餐形式</TH>
                          <TH width="10%" scope=col>优惠形式</TH>
                          <TH width="10%" scope=col>折上折</TH>
                          <TH width="10%" scope=col>套餐分类</TH>
                          <TH width="10%" scope=col>生效日期</TH>
                          <TH width="10%" scope=col>截止日期</TH>
						  </TR>
					<s:iterator value="setMealList">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="4%">
                              <img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onclick="javascript:setValue('${ssmsmid}')">
                          </TD>
                          <TD width="4%">
                              <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onclick="javascript:detail('${ssmsmid}')">
                          </TD>
                          <TD height="26">${ssmsmtitle}</TD>
                          <TD>
                              <c:choose>
                                  <c:when test="${ssmsmform eq '1'}">多种优惠方式</c:when>
                                  <c:when test="${ssmsmform eq '2'}">单一优惠方式</c:when>
                              </c:choose>
                          </TD>
                          <TD>
                              <c:choose>
                                  <c:when test="${ssmsmdetailform eq '11'}">商品满减</c:when>
                                  <c:when test="${ssmsmdetailform eq '12'}">整单满减</c:when>
                                  <c:when test="${ssmsmdetailform eq '21'}">商品特价</c:when>
                                  <c:when test="${ssmsmdetailform eq '22'}">整单返现</c:when>
                                  <c:when test="${ssmsmdetailform eq '23'}">整单折扣</c:when>
                                  <c:when test="${ssmsmdetailform eq '24'}">整单限价</c:when>
                              </c:choose>
                          </TD>
                          <TD>${ssmsmisdiscount == '0' ? '不允许':'允许'}</TD>
                          <TD>
                              <c:choose>
                                  <c:when test="${ssmsmclassify eq '1'}">框镜销售类</c:when>
                                  <c:when test="${ssmsmclassify eq '3'}">隐形销售类</c:when>
                                  <c:when test="${ssmsmclassify eq '5'}">辅料销售类</c:when>
                              </c:choose>
                          </TD>
                          <TD>${ssmsmeffectivedate}</TD>
                          <TD>${ssmsmenddate}</TD>
						</TR>
						<s:iterator value="setMealEntryList">	
							<TR hide=hide>
	                          <TD height="26"><input type="hidden" id=chk setMealID="${ssmsmid}" value="{'id':'${ssmsgsetmealid}','goodsID':'${ssmsggoodsid}','goodsQuantity':'${ssmsggoodsquantity}','retailPrice':'${ssmsgretailPrice}','creditPrice':'${ssmsgexpensecredit}','isintegralsum':'${ssmsmintegralsum}','discountrate':'${ssmsgdiscountrate}','activemoney':'${ssmsgspecialoffer}','flag':'${ssmsmform}','title':'${ssmsmtitle}','favorableflag':'${ssmsgfavorableflag}','detailid':'${ssmsmdetailform}','isdiscount':'${ssmsmisdiscount}','goodsClass':'${ssmsggoodsclass}','isCustomize':'${ssmsgiscustomize}','beginAmount':'${ssmsgbeginAmount}','endAmount':'${ssmsgendAmount}','sphul':'${ssmsgsphul}','sphup':'${ssmsgsphup}','cylul':'${ssmsgcylul }','cylup':'${ssmsgcylup }','clfl':'${ssmsgclfl }','zsl':'${ssmsgzsl }','gdfl':'${ssmsggdfl }','gndl':'${ssmsggndl }','jjcz':'${ssmsgjjcz }','sylx':'${ssmsgsylx }','pqlx':'${ssmsgpqlx }','tyjgn':'${ssmsgtyjgn }'}"></TD>
	                          <TD>${ssmsmisdiscount}</TD>
	                          <TD>${ssmsggoodsid}</TD>
	                          <TD>${ssmsggoodsquantity}</TD>
	                          <TD>${ssmsgretailPrice}</TD>
	                          <TD>${ssmsgexpensecredit}</TD>
	                          <TD>${ssmsgdiscountrate}</TD>
	                          <TD>${ssmsgspecialoffer}</TD>
	                          <TD>${ssmsggoodsclass}</TD>
	                          <TD>${ssmsgbeginAmount}</TD>
	                          <TD>${ssmsgendAmount}</TD>
							</TR>
						</s:iterator>
					</s:iterator>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(setMealList)}">
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