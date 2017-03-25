<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制造商维护</title>
</head>
<script>
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="">

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
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif></TD>
		</TR>
		</TBODY>
	  </TABLE>
	</TD>
   </TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" vAlign=top>
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
						   <TD width="9%" height="26" class="table_body">制造商代码</TD>
			               <TD width="19%" class="table_none">${supplierPo.bspid}&nbsp;
                            <input type="hidden" id="bspid" name="supplierPo.bspid" value="${supplierPo.bspid}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商简称</TD>
			               <TD width="22%" class="table_none">${supplierPo.bspsuppliername}&nbsp;</TD>
			               <TD width="9%" height="26" class="table_body">制造商联系人</TD>
			               <TD width="19%" class="table_none">${supplierPo.bspcontactperson}&nbsp;</TD>
                        </TR>
                        <TR>			               
			               <TD height="26" class="table_body">制造商全称</TD>
			               <TD class="table_none">${supplierPo.bspfroshort}&nbsp;</TD>
						   <TD height="26" class="table_body">制造商电话</TD>
			               <TD class="table_none">${supplierPo.bspcontactphone}&nbsp;</TD>
			               <TD height="26" class="table_body">联系人电话</TD>
			               <TD class="table_none">${supplierPo.bsplinkmanphonel}&nbsp;</TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">商品类别</TD>
			               <TD  class="table_none" colspan="3">
                             <c:forEach items="${goodsCategoryList}" var="goodsCategoryList" varStatus="linerole">
                             	${goodsCategoryList.flag == '1' ? goodsCategoryList.bgcgoodscategoryname : ''}
                             </c:forEach>
			               </TD>
			               <TD height="26" class="table_body">制造商传真</TD>
			               <TD class="table_none">${supplierPo.bspfax}</TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">制造商地址</TD>
			               <TD class="table_none" colspan="3">${supplierPo.bspaddress}&nbsp;</TD>
			               <TD height="26" class="table_body">开票状态</TD>
			               <TD class="table_none">
			                   <c:if test="${supplierPo.bspmakeinvoiceflag eq '1'}">开票</c:if>
			                   <c:if test="${supplierPo.bspmakeinvoiceflag eq '0'}">不开票</c:if>
			                    &nbsp;
			               </TD>
                        </TR>
                        <TR>
		      	          <TD height="26" class="table_body">采购结算方式</TD>
					      <TD class="table_none" colspan="5">
					      	 <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                              <c:if test="${optionParamPoTmp.fopparentid=='jxfs' && supplierPo.bspsettlement == optionParamPoTmp.fopparamid}">
	                                ${optionParamPoTmp.fopparamname} 
	                                <c:if test="${supplierPo.bspsettlement == 'jxfs2'}">
	                              		&nbsp;&nbsp;&nbsp;&nbsp;${supplierPo.bspsettlementmonth}&nbsp;&nbsp;天
	                                </c:if>
	                              </c:if>
                             </c:forEach>
		                   </TD>
		                </TR>
                        <TR>
			               <TD height="26" class="table_body">行业许可证号</TD>
			               <TD class="table_none">
                            ${supplierPo.bsplicenceid}
			               </TD>
			              <TD height="26" class="table_body">许可证有效期</TD>
			               <TD class="table_none" colspan="3">
                             ${supplierPo.bsplicencevalidity}
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">医疗器械经营许可证号</TD>
			               <TD class="table_none">
                             ${supplierPo.bspylicenceid }
			               </TD>
			               <TD height="26" class="table_body">医疗器械经营许可证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 ${supplierPo.bspylicencevalidity}
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">全国工业品生产许可证号</TD>
			               <TD class="table_none">
                             ${supplierPo.bspglicenceid }
			               </TD>
			              <TD height="26" class="table_body">全国工业品生产许可证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 ${supplierPo.bspglicencevalidity}
			               </TD>
                        </TR>
                        <TR>
			              <TD height="62" class="table_body">备注</TD>
			               <TD class="table_none" colspan="5">
                             ${supplierPo.bspremark}&nbsp;
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
	
	
	




