<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订做镜片维护</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="lensCustomForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="type" id="type" value="" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
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
                      UNSELECTABLE="on">订做镜片详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                     
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPricesAbout.action?moduleID=${requestScope.moduleID}&goodsid=${goodsInfoPo.bgigoodsid}&returnUrl=retail&glassType=D';"
                      UNSELECTABLE="on">价格走势图</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                   
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
			                 <TD width="9%" height="26" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input200" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">${goodsInfoPo.bgigoodsname}&nbsp;
                             </TD>
			              
                        </TR>
                        <TR>
                          <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                             
                           ${goodsInfoPo.bgisuppliername}		               
			               </TD>
                           <TD  height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           ${goodsInfoPo.bgibrandname}&nbsp;
			               </TD>
			               <TD  height="26" class="table_body">型号</TD>
			               <TD  class="table_none">
                             ${goodsInfoPo.bgispec}&nbsp;
			               </TD>
                        </TR>
                        <TR>
                        	 <TD  height="26" class="table_body">商品编号</TD>
			               <TD  class="table_none">
                             ${goodsInfoPo.bgicolor}&nbsp;
			               </TD>
			               <TD  class="table_body">计量单位</TD>
			               <TD  class="table_none">  ${goodsInfoPo.bgiunitname}&nbsp;
			               </TD>
						   <TD  height="26" class="table_body">球镜</TD>
			               <TD  class="table_none">${goodsInfoPo.bgisphup } &nbsp;至&nbsp; ${goodsInfoPo.bgisphul } &nbsp;跨度&nbsp; ${goodsInfoPo.bgisphspan}</TD>
			            </TR>
                        <TR>
						   <TD  class="table_body">柱镜</TD>
			               <TD  class="table_none">${goodsInfoPo.bgicylup } &nbsp;至&nbsp; ${goodsInfoPo.bgicylul } &nbsp;跨度&nbsp; ${goodsInfoPo.bgicylspan}</TD>
						   <TD  class="table_body">下加光</TD>
			               <TD  class="table_none">${goodsInfoPo.bgibelowplusluminosityup } &nbsp;至&nbsp; ${ goodsInfoPo.bgibelowplusluminosityul}
								
			               </TD>
			               <TD  height="26" class="table_body">轴位</TD>
			               <TD  class="table_none">${goodsInfoPo.bgiaxis }&nbsp;
			               </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <TR>
  		               	   <TD  height="26" class="table_body">材料分类</TD>
			               <TD  class="table_none" >
			               		${goodsInfoPo.bgieyeglassmaterialtype == "1" ? '树脂' : '' }
			               		${goodsInfoPo.bgieyeglassmaterialtype == "2" ? '玻璃' : '' }
			               		${goodsInfoPo.bgieyeglassmaterialtype == "3" ? 'PC' : '' } &nbsp;
			               </TD>
			               <TD  height="26" class="table_body">订做周期</TD>
			               <TD class="table_none">
	                          ${goodsInfoPo.bgiordercycle} 天&nbsp;
			               </TD>
			               <TD height="26" class="table_body">商品级别</TD>
			               <td align="left" class="table_none">
                              ${goodsInfoPo.bgidefaultdiscountvaluename }
                           </td>
                        </TR>
                        </c:if>
                        <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                        <TR>
  		               	   <TD  height="26" class="table_body">材料分类</TD>
			               <TD  class="table_none">
			               		${goodsInfoPo.bgieyeglassmaterialtype == "1" ? '树脂' : '' }
			               		${goodsInfoPo.bgieyeglassmaterialtype == "2" ? '玻璃' : '' }
			               		${goodsInfoPo.bgieyeglassmaterialtype == "3" ? 'PC' : '' } &nbsp;
			               </TD>
			               <TD  height="26" class="table_body">订做周期</TD>
			               <TD  class="table_none" colspan="3">
	                          ${goodsInfoPo.bgiordercycle} 天&nbsp;
			               </TD>
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
			              <TD  height="26" class="table_body" width="9%">镜片种类</TD>
			              <TD  class="table_none" width="24%">
	                         ${goodsInfoPo.bgiismutiluminosity == '0' ? '单光' : '' }
                              ${goodsInfoPo.bgiismutiluminosity == 'M' ? '多光' : '' }
                              ${goodsInfoPo.bgiismutiluminosity == 'J' ? '渐进' : '' }
                              ${goodsInfoPo.bgiismutiluminosity == 'K' ? '抗疲劳' : '' }
                              ${goodsInfoPo.bgiismutiluminosity == 'Q' ? '其它' : '' } &nbsp;
			              </TD>
			              <TD  height="26" class="table_body" width="9%">渐进片分类</TD>
			              <TD  class="table_none" width="24%">
			               		${goodsInfoPo.bgigradualclass != "1" ? '' : '青少年渐进' }
			               			 ${goodsInfoPo.bgigradualclass != "2" ? '' : '成人渐进' } &nbsp;
			              </TD>
                          <TD  height="26" class="table_body" width="9%">折射率</TD>
                          <TD class="table_none">${goodsInfoPo.bgirefractive }&nbsp;
      	                  </TD>	
      	               </tr>
      	               <tr>  
						  <TD  height="26" class="table_body">镜片功能</TD>
			              <TD  class="table_none">
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='gn'}">
		                               ${(goodsInfoPo.bgifunctionclass == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                              </c:if>	                                      	
	                               </c:forEach>&nbsp;
			              </TD>
			               <TD  height="26" class="table_body">联合光度</TD>
			               <TD  class="table_none">${goodsInfoPo.bgiunionsphcyl}</TD>	
			               
			               <TD width="12%" height="30" class="table_body">柱镜为-0.25度(-25散)：</TD>
			               <TD width="38%" class="table_none">
			               	 ${goodsInfoPo.bgicyl25cannotdo == "0" ? '能' : '' }
			               	 ${goodsInfoPo.bgicyl25cannotdo == "1" ? '不能' : '' }&nbsp;
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
             <c:if test="${(permissionPo.keyf==1)}">           
                       <TR>
                       <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">${goodsInfoPo.bgitaxrate}&nbsp;</TD>                         
                           <TD height="26" class="table_body" width="9%">含税单价</TD>
			               <TD class="table_none" width="24%">${goodsInfoPo.bgicostprice}&nbsp;</TD>
                           <TD class="table_body" width="9%">批发价</TD>
			               <TD class="table_none">${goodsInfoPo.bgiwholesaleprice}&nbsp;</TD>
                        </TR>
            </c:if>
            <c:if test="${(permissionPo.keyf!=1)}">           
                        <tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" colspan="5">${goodsInfoPo.bgitaxrate}&nbsp;</TD> 
                        </tr>
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