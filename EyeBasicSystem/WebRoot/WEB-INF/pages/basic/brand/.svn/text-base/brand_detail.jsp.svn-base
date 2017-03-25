<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品种</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" id="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">品种代码</TD>
			               <TD width="19%" class="table_none">${brandPo.bbdid }</TD>
					   
						   <TD width="9%" height="26" class="table_body">品种名称</TD>
			               <TD width="25%" class="table_none">${brandPo.bbdbrandname }</TD>
			               <TD width="9%" class="table_body">制造商</TD>
						   <TD width="19%" height="26" class="table_none">${brandPo.bspsuppliername }</TD>
						</TR>
	                  <TR>
                        <TD height="26" class="table_body">商品类别</TD>
	                    <TD class="table_none" >${brandPo.bgcgoodscategoryname }</TD>
	                    <TD height="26" class="table_body">产地</TD>
                        <TD class="table_none">${brandPo.bbdplace }</TD>  
                        <TD height="26" class="table_body">计量单位</TD>
		                <TD class="table_none" >${brandPo.bbdunitname}</TD>                          
                      </TR>
                     <c:if test="${(brandPo.bbdgoodscategory eq '1')}">
                      	<TR>
                           <TD height="26" class="table_body">镜架材质</TD>
			               <TD class="table_none" colspan="5">
                               ${brandPo.bbdframematerialtypename}
      	                    </TD>                       
                      	 </TR>
                      </c:if>
                      <c:if test="${(brandPo.bbdgoodscategory eq '3')}">
                      <TR id="goodscatory301"> 
                       <TD height="26" class="table_body">材料分类</TD>
			               <TD class="table_none">
      	                   <c:choose>
				               <c:when test="${brandPo.bbdmaterialclass=='1'}">
				                 	树脂
				               </c:when>
				               <c:when test="${brandPo.bbdmaterialclass=='2'}">
				               		玻璃
				               </c:when>
				               <c:when test="${brandPo.bbdmaterialclass=='3'}">
				               		PC
				               </c:when>			               						               
	               			</c:choose>
      	                </TD> 
      	                <TD height="26" class="table_body">折射率</TD>
			               <TD class="table_none">
                                   ${brandPo.bbdrefractive }
      	                </TD>
                        <TD height="26" class="table_body">镜片功能</TD>
			               <TD class="table_none">
      	                   <c:choose>
				               <c:when test="${brandPo.bbdfunctionclass=='1'}">
				                 	白色片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='2'}">
				               		变色片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='3'}">
				               		偏光片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='4'}">
				                 	变色偏光片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='5'}">
				               		染色片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='6'}">
				               		抗疲劳片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='7'}">
				               		抗疲劳变色片
				               </c:when>
				               <c:when test="${brandPo.bbdfunctionclass=='8'}">
				               		偏光抗疲劳片
				               </c:when>				               						               
	               			</c:choose>
      	                </TD>
                      </TR>
                      <TR id="goodscatory302">
      	                <TD height="26" class="table_body">光度分类</TD>
                        <TD class="table_none">
      	                   <c:choose>
				               <c:when test="${brandPo.bbdluminosityclass=='0'}">
				                 	单光
				               </c:when>
				               <c:when test="${brandPo.bbdluminosityclass=='M'}">
				               		多光
				               </c:when>
				               <c:when test="${brandPo.bbdluminosityclass=='J'}">
				               		渐进
				               </c:when>
				               <c:when test="${brandPo.bbdluminosityclass=='K'}">
				                 	抗疲劳
				               </c:when>
				               <c:when test="${brandPo.bbdluminosityclass=='Q'}">
				               		其他
				               </c:when>               						               
	               			</c:choose>
      	                </TD>  
      	                
      	                <TD height="26" class="table_body"><c:if test="${brandPo.bbdluminosityclass=='J'}">渐进片分类</c:if>&nbsp;</TD>
			            <TD class="table_none" colspan="3">
      	                   <c:choose>
				               <c:when test="${brandPo.bbdgradualclass=='1'}">
				                 	青少年渐进
				               </c:when>
				               <c:when test="${brandPo.bbdgradualclass=='2'}">
				               		成人渐进
				               </c:when>         						               
	               			</c:choose>
	               			&nbsp;
      	                </TD>                   
                      </TR>
                      </c:if>
                      <c:if test="${(brandPo.bbdgoodscategory eq '4')}">
                      	<TR>
                      	<TD height="26" class="table_body">使用类型</TD>
			               <TD class="table_none">
      	                   <c:choose>
				               <c:when test="${brandPo.bbdusetype=='1'}">
				                 	常带型
				               </c:when>
				               <c:when test="${brandPo.bbdusetype=='2'}">
				               		抛弃型
				               </c:when>
				               <c:when test="${brandPo.bbdusetype=='3'}">
				               		塑形镜
				               </c:when>				               					               						               
	               			</c:choose>
      	                </TD>
                        <TD height="26" class="table_body">抛弃型分类</TD>
			            <TD class="table_none">
			            	<c:choose>
				               <c:when test="${brandPo.bbdstealthclass=='1'}">
				                 	日抛
				               </c:when>
				               <c:when test="${brandPo.bbdstealthclass=='2'}">
				               		周抛
				               </c:when>
				               <c:when test="${brandPo.bbdstealthclass=='9'}">
				               		双周抛
				               </c:when>
				               <c:when test="${brandPo.bbdstealthclass=='3'}">
				               		月抛
				               </c:when>
				               <c:when test="${brandPo.bbdstealthclass=='4'}">
				               		季抛
				               </c:when>	
				               <c:when test="${brandPo.bbdstealthclass=='5'}">
				               		半年抛
				               </c:when>
				               <c:when test="${brandPo.bbdstealthclass=='6'}">
				               		年抛
				               </c:when>
				               <c:when test="${brandPo.bbdstealthclass=='7'}">
				               		RGP
				               </c:when>					               						               
	               			</c:choose>
			            </TD>
			            <TD height="26" class="table_body">注册证号</TD>
			            <TD class="table_none">${brandPo.bbdregistrationnum}&nbsp;
      	                </TD>                           
                      </TR>
                      </c:if>
                      
                      <c:if test="${(brandPo.bbdgoodscategory eq '5')}">
                      	<TR>
			            <TD height="26" class="table_body">注册证号</TD>
			            <TD class="table_none" colspan="5">${brandPo.bbdregistrationnum}&nbsp;
      	                </TD>                           
                      </TR>
                      </c:if>
                      
                      <TR> 
      	                <TD height="26" class="table_body">采购结算方式</TD>
			            <TD class="table_none">
				      	 <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
                              <c:if test="${optionParamPoTmp.fopparentid=='jxfs' && brandPo.bbdsettlement == optionParamPoTmp.fopparamid}">
                                ${optionParamPoTmp.fopparamname} 
                                <c:if test="${brandPo.bbdsettlement == 'jxfs2'}">
                              		&nbsp;&nbsp;&nbsp;&nbsp;${brandPo.bbdsettlementmonth}&nbsp;&nbsp;天
                                </c:if>
                              </c:if>
                         </c:forEach>			            
                         </TD>
                         <TD height="26" class="table_body">商品级别</TD>
			             <TD class="table_none">
			             	${brandPo.bbddefaultdiscountname}&nbsp;
                         </TD>
                       	 <TD height="26" class="table_body">批号管理</TD>
		                 <td align="left" class="table_none">
	                		<c:choose>
	                			<c:when test="${brandPo.bbdbarcodeflag eq '1'}">
	                				是
	                			</c:when>
	                			<c:otherwise>
	                				否
	                			</c:otherwise>
	                		</c:choose>
                         </td>
                      </TR>
                      <TR> 
                       <TD height="26" class="table_body">促销金额</TD>
			               <TD class="table_none">
			                 ${brandPo.bbdpromotion}&nbsp;
      	                </TD>
      	                <TD height="30" class="table_body">速记码</TD>
                        <TD class="table_none" colspan="3">
                        	${brandPo.bbdmnemoniccode }&nbsp;
			            </TD>           
                      </TR>
                      
                      <c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
							   <li class="horizontal_onlyRight">
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
		                               ${(brandPo.bbdpayfeeid == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                              </c:if>	                                      	
	                               </c:forEach> 
	                           </li>
		      	             </TD>                
	                      </TR>
                      </c:if>
                      
                      </TBODY>
                    </TABLE>
 		
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
                  