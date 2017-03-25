<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>镜架维护</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
	  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR><TD></br></TD></TR>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">镜架详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initGlassesFramePhotoDetail.action?moduleID=${requestScope.moduleID}&goodsid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">图片预览</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                     
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPricesAbout.action?moduleID=${requestScope.moduleID}&goodsid=${goodsInfoPo.bgigoodsid}&returnUrl=retail';"
                      UNSELECTABLE="on">价格走势图</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
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
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsid}<input class="text_input200" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			               <TD width="9%" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input200" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            ${goodsInfoPo.bgigoodsname}  &nbsp;</TD>
			             
			            </TR>
						   
                        <TR>
                          <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                           
                            ${goodsInfoPo.bgisuppliername}		&nbsp;  	               
			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                            ${goodsInfoPo.bgibrandname}&nbsp;
			               </TD>
			               <TD class="table_body">型号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgispec}&nbsp;
			               </TD>
			             
                        </TR>
                        <TR>
                         <TD height="26" class="table_body">厂家色号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgisuppliercolor}<input class="text_input200" type="hidden" id="bgisuppliercolor" name="goodsInfoPo.bgisuppliercolor" value="${goodsInfoPo.bgisuppliercolor}">
			              
			               </TD>
                          <TD class="table_body">色号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgicolor}&nbsp;
			               </TD>
                           <TD class="table_body">计量单位</TD>
			               <TD class="table_none">
                         	 ${goodsInfoPo.bgiunitname}&nbsp;
			               </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <tr>
                        <TD height="26" class="table_body">厂家型号</TD>
			               <TD class="table_none">
			               		${goodsInfoPo.bgisupplierspec}
			               </TD>
			               <TD class="table_body">商品级别</TD>
			               <td align="left" class="table_none">
                              ${goodsInfoPo.bgidefaultdiscountvaluename }
                           </td>
	      	               <TD class="table_body">批号管理</TD>
			               <td align="left" class="table_none">
   	                		<c:choose>
	                			<c:when test="${goodsInfoPo.bgibarcodeflag eq '1'}">
	                				是
	                			</c:when>
	                			<c:otherwise>
	                				否
	                			</c:otherwise>
	                		</c:choose>
                           </td>                            
                        </TR>
                        </c:if>
                        <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                        <tr>
                        <TD height="26" class="table_body">厂家型号</TD>
			               <TD class="table_none">
			               		${goodsInfoPo.bgisupplierspec}
			               </TD>
			               <TD class="table_body">批号管理</TD>
			               <td align="left" class="table_none" colspan="3">
   	                		<c:choose>
	                			<c:when test="${goodsInfoPo.bgibarcodeflag eq '1'}">
	                				是
	                			</c:when>
	                			<c:otherwise>
	                				否
	                			</c:otherwise>
	                		</c:choose>
                           </td>			               
                        </TR>
                        </c:if>
                        <c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
							   <li class="horizontal_onlyRight">
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
		                               ${(goodsInfoPo.bgipayfeeid == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                              </c:if>	                                      	
	                               </c:forEach> 
	                           </li>
		      	             </TD>                
	                      </TR>
                      </c:if>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;非&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                           <TD height="26" class="table_body" width="9%">镜架尺寸</TD>
			               <TD class="table_none" width="24%">
			               ${goodsInfoPo.bgiframesize}&nbsp;
                           </TD>
                           <TD class="table_body" width="9%">工艺类型</TD>
			               <TD class="table_none" width="24%">
      	                 	 <c:forEach items="${teachnologyTypeList}" var="teachnologyTypeList" varStatus="linerole">
                             	${teachnologyTypeList.fttid == goodsInfoPo.bgiframeprocesscrafttype ? teachnologyTypeList.fttname : ''}
                             </c:forEach>&nbsp;
			               </TD>
                           <TD class="table_body" width="9%">镜架材质</TD>
			               <TD class="table_none">${goodsInfoPo.bgiframematerialtypename}&nbsp;</TD>                           
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">颜色</TD>
			               <TD class="table_none">
                         	 ${goodsInfoPo.bgichinesecolorname}&nbsp;
			               </TD>
			               <TD height="26" class="table_body">款式</TD>
			               <TD class="table_none">
			               		<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                              <c:if test="${optionParamPoTmp.fopparentid=='ks' && goodsInfoPo.bgiframestyle == optionParamPoTmp.fopparamid}">
	                                ${optionParamPoTmp.fopparamname} 
	                              </c:if>
                             </c:forEach>
			               </TD>
			               <TD class="table_body">采购年份</TD>
			               <TD class="table_none" colspan="3">${goodsInfoPo.bgibrandyear}&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
             			<c:if test="${(permissionPo.keyf==1)}">           
                       <TR>
			               <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                             <TD height="26" class="table_body" width="9%">税率</TD>
			                 <TD class="table_none" width="24%">${goodsInfoPo.bgitaxrate}&nbsp;</TD> 
                             <TD class="table_body" width="9%">含税单价</TD>
			                 <TD class="table_none" width="24%">${goodsInfoPo.bgicostprice}&nbsp;</TD>
                             <TD class="table_body" width="9%">批发价格</TD>
			                 <TD class="table_none">${goodsInfoPo.bgiwholesaleprice}&nbsp;</TD>
			               </c:if>
			               <c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                             <TD height="26" class="table_body" width="9%">税率</TD>
			                 <TD class="table_none" width="24%">${goodsInfoPo.bgitaxrate}&nbsp;</TD> 
                             <TD height="26" class="table_body" width="9%">含税单价</TD>
			                 <TD class="table_none" colspan=3>${goodsInfoPo.bgicostprice}&nbsp;</TD>
			               </c:if>
                        </TR>
                        <%--<tr>                                      
                           <TD height="26" class="table_body">加权平均成本</TD>
			               <TD class="table_none" colspan="5">${goodsInfoPo.bgiaveragenotnaxrate}&nbsp;</TD>
                        </tr>--%>
            			</c:if>
            			<c:if test="${(permissionPo.keyf!=1)}">
            			<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
	                        <tr>
	                         <TD height="26" class="table_body" width="9%">税率</TD>
				             <TD class="table_none">${goodsInfoPo.bgitaxrate}&nbsp;</TD> 
                             <TD class="table_body">批发价格</TD>
			                 <TD class="table_none" colspan="3">${goodsInfoPo.bgiwholesaleprice}&nbsp;</TD>
	                        </tr>
            			</c:if>
            			<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
	                        <tr>
	                           <TD height="26" class="table_body" width="9%">税率</TD>
				               <TD class="table_none" colspan="5">${goodsInfoPo.bgitaxrate}&nbsp;</TD> 
	                        </tr>
                        </c:if>
            			</c:if>
                      </TBODY>
                    </TABLE>
                	<%@ include file="/commons/basic_retailPrices.jsp" %>
                    </fieldset>
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