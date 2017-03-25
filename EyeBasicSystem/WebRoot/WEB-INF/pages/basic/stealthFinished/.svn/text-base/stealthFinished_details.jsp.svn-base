<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>隐形成品片维护</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="stealthFinishedForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

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
                      UNSELECTABLE="on">隐形成品片详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                     
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPricesAbout.action?moduleID=${requestScope.moduleID}&goodsid=${goodsInfoPo.bgigoodsid}&returnUrl=retail&glassType=C';"
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
                            ${goodsInfoPo.bgigoodsid}<input class="text_input160" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			               <TD width="9%" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input160" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none">${goodsInfoPo.bgigoodsname}&nbsp;
                           </TD>
                        </TR>
                        <TR>
                         <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                             
                           	${goodsInfoPo.bgisuppliername}		               
			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                           ${goodsInfoPo.bgibrandname}
			               </TD>
			               <TD class="table_body">商品编号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgicolor}&nbsp;
			               </TD>
                        </TR>
                        <TR>
                       	   <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
	                           ${goodsInfoPo.bgiunitname}&nbsp;
			               </TD>
			               <TD class="table_body">球镜</TD>
			               <TD class="table_none">${goodsInfoPo.bgisph }
			               </TD>
			               <TD class="table_body">柱镜</TD>
			               <TD class="table_none">${goodsInfoPo.bgicyl}&nbsp;
			               </TD>
			            </TR>
                        <TR>
			               <TD height="26" class="table_body">轴向</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgiaxis}&nbsp;
			               </TD>
			               <TD class="table_body">曲率</TD>
			               <TD class="table_none">${goodsInfoPo.bgicurvature1 }
                           </TD>
			               <TD class="table_body">直径</TD>
			               <TD class="table_none">${goodsInfoPo.bgidia}&nbsp; 
                           </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <tr>
                           <TD height="26" class="table_body">商品级别</TD>
			               <td align="left" class="table_none" colspan="5">
                              ${goodsInfoPo.bgidefaultdiscountvaluename }
                           </td>
                        </tr>
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
                    <table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                         <TR>
			               <TD height="26" class="table_body" width="9%">使用类型</TD>
			               <TD class="table_none" width="24%">
                           ${goodsInfoPo.bgiusetype != "1" ? '' : '常戴型' }
      		               ${goodsInfoPo.bgiusetype != "2" ? '' : '抛弃型' }
      		               ${goodsInfoPo.bgiusetype != "3" ? '' : '塑形镜' }&nbsp; 
			               </TD>
			               <TD class="table_body">抛弃型分类</TD>
			               <TD class="table_none" >
                            ${goodsInfoPo.bgistealthclass == "1" ? '日抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "2" ? '周抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "9" ? '双周抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "3" ? '月抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "4" ? '季抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "5" ? '半年抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "6" ? '年抛' : '' }
                            ${goodsInfoPo.bgistealthclass == "7" ? 'RGP' : '' }
                            ${goodsInfoPo.bgistealthclass == "8" ? '塑形镜' : '' }&nbsp; 
			               </TD>
			               <TD class="table_body">产品可使用天数</TD>
			               <TD class="table_none">${goodsInfoPo.bginumberofdays}</TD>			               

                        </TR>
                        <TR>
						   <TD height="26" class="table_body" width="9%">效期提醒上限</TD>
			               	<TD class="table_none" width="24%">有效期前&nbsp;${goodsInfoPo.bgireturnmax }&nbsp;天提醒进入滞销状态
                           		</td>
                           	<TD class="table_body" width="9%">效期提醒下限</TD>
			               	<TD class="table_none" width="24%">有效期前&nbsp;${goodsInfoPo.bgireturnmin }&nbsp;天提醒进入即将失效状态
                            </TD>
			               <TD class="table_body" width="9%">颜色</TD>
			               <TD class="table_none">
                         	 ${goodsInfoPo.bgichinesecolorname}&nbsp;
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">隐形类别</TD>
			               <TD class="table_none" >
			                 <c:if test="${goodsInfoPo.bgicontacttype == '1' }">RGP</c:if>
			                 <c:if test="${goodsInfoPo.bgicontacttype == '2' }">塑形镜</c:if>
			                 <c:if test="${goodsInfoPo.bgicontacttype == '3' }">软性隐性</c:if>
			                 <c:if test="${goodsInfoPo.bgicontacttype == '4' }">医用隐性</c:if>&nbsp;
			               </TD>
			               <TD class="table_body">材质</TD>
			               <TD class="table_none" colspan="3">
			               <c:if test="${goodsInfoPo.bgistealthtype==0}">
			                                         软镜
			               </c:if>
			               <c:if test="${goodsInfoPo.bgistealthtype==1}">
			                                        硬镜
			               </c:if>
			               <c:if test="${goodsInfoPo.bgistealthtype==2}">
			                                        硬镜
			               </c:if>
			               </TD>
                        </TR>        
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
             <c:if test="${(permissionPo.keyf==1)}">  
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">         
                       <TR>
                       <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">${goodsInfoPo.bgitaxrate}&nbsp;</TD>                         
                           <TD class="table_body" width="9%">含税单价</TD>
			               <TD class="table_none" width="24%">${goodsInfoPo.bgicostprice}&nbsp;</TD>
                           <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none">${goodsInfoPo.bgiwholesaleprice}&nbsp;</TD>
                        </TR>
                </c:if>
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">         
                       <TR>
                       <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">${goodsInfoPo.bgitaxrate}&nbsp;</TD>                         
                           <TD height="26" class="table_body" width="9%">含税单价</TD>
			               <TD class="table_none" colspan="3">${goodsInfoPo.bgicostprice}&nbsp;</TD>
                        </TR>
                </c:if>
            </c:if>
            <c:if test="${(permissionPo.keyf!=1)}">  
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">          
                        <tr>
                           <TD height="26" class="table_body">税率</TD>
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
	
	
	




