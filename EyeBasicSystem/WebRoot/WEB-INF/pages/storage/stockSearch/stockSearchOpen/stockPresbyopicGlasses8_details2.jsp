<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老花镜维护</title>
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="presbyopicGlassesForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品信息</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                 
                  <c:if test="${not empty(bgiwarehouseid) }">
                  <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='selStockSearchLs2.action?moduleID=${requestScope.moduleID}&bgigoodsid=${bgigoodsid }&bgigoodsbarcode=${goodsInfoPo.bgigoodsbarcode }&bgiwarehouseid=${bgiwarehouseid }&startTime=${startTime}&endTime=${endTime}' ;"
                      UNSELECTABLE="on">库存流水</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                  </c:if>
                      
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsid}<input class="text_input200" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			                <TD width="9%" height="26" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input200" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD width="24%" class="table_none">${goodsInfoPo.bgigoodsname}&nbsp;
                            </TD>
			              
                        </TR>
                        <TR>
                         <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                           
                            ${goodsInfoPo.bgisuppliername}		&nbsp;  	               
			               </TD>
                           <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                            ${goodsInfoPo.bgibrandname}&nbsp;
			               </TD>
			               <TD height="26" class="table_body">型号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgispec}&nbsp;
			               </TD>
			            </c:if> 
			            <c:if test="${systemParameterPo.fspisshowsupplierandbrand != '1' && departmenttype == '1'}">
                           <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                            ${goodsInfoPo.bgibrandname}&nbsp;
			               </TD>
			               <TD height="26" class="table_body">型号</TD>
			               <TD class="table_none" colspan="3">
                             ${goodsInfoPo.bgispec}&nbsp;
			               </TD>
			            </c:if>
                        </TR>
			             <TR>
			               <TD height="26" class="table_body">厂家色号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgisuppliercolor}&nbsp; </TD>
			              <TD  height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgiunitname}&nbsp;
			               </TD>
			              
                           		<TD  height="26" class="table_body">老花镜度数</TD>
					        	<TD class="table_none">${goodsInfoPo.bgisph }&nbsp;
									
								</TD>
				   
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">镜架尺寸</TD>
			               <TD class="table_none">${goodsInfoPo.bgiframesize}&nbsp;
                            </TD>
			          	   <TD  height="26" class="table_body">零售价格（￥）</TD>
			               <TD class="table_none" colspan="5">
                             ${goodsInfoPo.bgiretailprice}&nbsp;
			               </TD>    
			              
			             </TR>
                   <c:if test="${(permissionPo.keyb == 1)}">     
                        <tr>
                         <TD  class="table_body">批发价格</TD>
			               <TD class="table_none">${goodsInfoPo.bgiwholesaleprice}&nbsp;
                            </TD>
                                    
                         <TD height="26" class="table_body">加权平均成本（￥）</TD>
			               <TD class="table_none">${goodsInfoPo.bgiaveragenotnaxrate}&nbsp;</TD>	
			             <TD height="26" class="table_body">成本价格（￥）</TD>
			               <TD class="table_none">${goodsInfoPo.bgicostprice}&nbsp;
			              </TD>		 
                        </tr>
                        <TR>
			              <TD  height="26" class="table_body">税率（%）</TD>
			               <TD class="table_none" colspan="5">${goodsInfoPo.bgitaxrate}&nbsp;
                            </TD>			              
			             </TR>
                   </c:if> 
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1"> 
                        <TR>
                           <TD width="10%" height="26" class="table_body">库存预警上限</TD>
			               <TD width="15%" class="table_none">${empty(goodsInfoPo.bgistorageupperlimit) ? '未设置' : goodsInfoPo.bgistorageupperlimit }&nbsp;</TD>
                           <TD width="10%" height="26" class="table_body">库存预警下限</TD>
			               <TD width="15%" class="table_none">${empty(goodsInfoPo.bgistoragelowerlimit) ? '未设置' : goodsInfoPo.bgistoragelowerlimit }&nbsp;</TD>
                           <TD width="10%" height="26" class="table_body">库存红色预警</TD>
			               <TD width="15%" class="table_none">${empty(goodsInfoPo.bgistorageredlimit) ? '未设置' : goodsInfoPo.bgistorageredlimit }&nbsp;</TD>
			               <TD width="10%" height="26" class="table_body">当前库存量</TD>
			               <TD width="15%" class="table_none">${goodsInfoPo.bgigoodsquantity}&nbsp;</TD>
                        </TR>
                    </table>
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
<script>
	if(document.all.bgisph!=null){
		var index_bgisph = 0;
		var arr = document.all.bgisph.options.length;
		for(i=0;i<arr;i++){
			if(document.all.bgisph.options.options[i].value == '<c:out value="${goodsInfoPo.bgisph}"/>'){
				document.all.bgisph.options.selectedIndex = index_bgisph;
				break;
			}
			index_bgisph++;
		}
	}
</script>