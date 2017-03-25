<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发票管理</title>
</head>
<script>	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	$(document).ready(function(){
		$('td[id=td2]').each(function(){
			$(this).text($(this).text()==''?'0':$(this).text());
			$(this).find("input").text($(this).text());
		});
		$('td[id=td3]').each(function(){
			$(this).text($(this).text()==''?'0':$(this).text());
			$(this).find("input").text($(this).text());
		});
		
		for(var i=1;i<=6;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=accAdd(total,$(this).find("input").val());
				}else{
					total=accAdd(total,$(this).text());
				}
			});
			if (i<=3){
			    $('#td'+i+'t').text(parseFloat(total));
			}else{
                $('#td'+i+'t').text(parseFloat(total).toFixed(2));
            }			
		}
	});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height='26'>
                          <TD class="table_body" width="10%" height="26">单据编号</TD>
                          <TD class="table_none" width="40%">
                          	${inventoryPo.cstibillid}
                          </TD>
                          <TD class="table_body" width="10%">单据日期</TD>
                          <TD class="table_none" width="40%">
                          	${fn:substring(inventoryPo.cstibilldate,0,10)}
					      </TD>
                        </TR>
                        <TR height='26'>
                          <TD class="table_body" height="26">制造商</TD>
                          <TD class="table_none">${inventoryPo.cstisuppliername}</TD>
						  <TD class="table_body">单据类型</TD>
						  <TD class="table_none">						  
						  <c:if test="${inventoryPo.cstibilltypeid==1}">
                         	采购收货单
                          </c:if>                          
                          <c:if test="${inventoryPo.cstibilltypeid==2}">
                          	采购退货单
                          </c:if>
                          <c:if test="${inventoryPo.cstibilltypeid==9}">
                          	委外收货单
                          </c:if>							  
						  </TD>
                        </TR>
                        <TR height='26'>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none">${inventoryPo.csticreateperson}</TD>
						  <TD class="table_body">
						  
						  <c:if test="${inventoryPo.cstibilltypeid==1 || inventoryPo.cstibilltypeid==7}">
						  	接收仓位
						  </c:if>
						  
						  <c:if test="${inventoryPo.cstibilltypeid==2 || inventoryPo.cstibilltypeid==8}">
						  	发出仓位
						  </c:if>
						  
						  </TD>
						  <TD class="table_none">
						  
						  <c:if test="${inventoryPo.cstibilltypeid==1 || inventoryPo.cstibilltypeid==7}">
						  	${inventoryPo.cstiinstockid}
						  </c:if>
						  
						  <c:if test="${inventoryPo.cstibilltypeid==2 || inventoryPo.cstibilltypeid==8}">
						  	${inventoryPo.cstioutstockid}
						  </c:if>
						  
						  </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none" colspan="3">${inventoryPo.cstiauditperson}</TD>
                        </TR>
                        <TR height='60px'>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colspan="3">
                          	${inventoryPo.cstiremark}
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<c:if test="${not empty(invoiceInEntryList)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>                          
                          <TH width="6%" scope=col>球镜</TH>
						  <th width="6%" scope=col>柱镜</th>
						  <TH width="5%" scope=col>数量</TH>
						  <TH width="7%" scope=col>核销数量</TH>
						  <TH width="7%" scope=col>暂估数量</TH>
						  <TH width="8%" scope=col>单位成本</TH>
                          <TH width="5%" scope=col>含税单价</TH>					  
						  <TH width="7%" scope=col>成本合计</TH>
						  <TH width="7%" scope=col>税额合计</TH>
						  <TH width="7%" scope=col>价税合计</TH>
						  <TH width="7%" scope=col>核销状态</TH>
                        </TR>
                        <TR class=table_title align=middle>
                          <TD height="26">合计：</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="td1t"></div></TD>
                          <TD><div id="td2t"></div></TD>
                          <TD><div id="td3t"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="td4t"></div></TD>
                          <TD><div id="td5t"></div></TD>
                          <TD><div id="td6t"></div></TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <s:iterator value="invoiceInEntryList">
                        <c:if test="${cstiegoodsquantity<=0 }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: red">
                        </c:if>
                        <c:if test="${cstiegoodsquantity>0 }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        </c:if>                        
                          <TD height="26">${cstiegoodsid }</TD>
                          <TD>${cstiegoodsname }</TD>
                          <TD>${cstiesph }</TD>
						  <td>${cstiecyl }</td>
                          <TD id="td1">${cstiegoodsquantity }<input type="hidden" value="${cstiegoodsquantity }"></TD>
                          <TD id="td2">${cstiecheckgoodsquantity }<input type="hidden" value="${cstiecheckgoodsquantity }"></TD>
                          <TD id="td3">${cstieprovisionalnum }<input type="hidden" value="${cstieprovisionalnum }"></TD>
                          <TD>${cstienottaxrate}</TD>
                          <TD>${cstiecostprice}</TD>
                          <TD id="td4">${cstienottaxrateamount }<input type="hidden" value="${cstienottaxrateamount }"></TD>
                          <TD id="td5">${cstietaxamount }<input type="hidden" value="${cstietaxamount }"></TD>
                          <TD id="td6">${cstiecostpriceamount }<input type="hidden" value="${cstiecostpriceamount }"></TD>
                          <TD>                          
                          <c:choose>
                            <c:when test="${cstieinvoicestate==0}">未核销</c:when>
                            <c:when test="${cstieinvoicestate==2}">完全核销</c:when>
                            <c:otherwise>部分核销</c:otherwise>
                          </c:choose>                        
                          </TD>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    </c:if>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
  
	
    </form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
