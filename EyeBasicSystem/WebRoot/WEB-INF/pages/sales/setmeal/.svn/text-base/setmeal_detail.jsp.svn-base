<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐维护</title>
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

function copySetMeal(){
	setMealFrm.action="copySetMeal.action?hid=${setMealPo.ssmsmid}";
	setMealFrm.submit();
}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="setMealFrm" name="setMealFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" value="${setMealPo.ssmsmid }" name="setMealPo.ssmsmid">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
         <c:if test="${(permissionPo.keyf!=1)}">
           <tr height="20"><td></td></tr>
         </c:if>
         <c:if test="${(permissionPo.keyf==1)}">
           <TR>
            <td align="right">&nbsp;
				<img src="${ctx }/img/newbtn/btn_fztc_0.png" btn=btn title="复制套餐" onClick="JavaScript:copySetMeal();" />
            </td>
          </TR>
        </c:if> 
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
							<TD width="9%" height="26" class="table_body">套餐标题</TD>
			            	<TD width="24%" class="table_none">${setMealPo.ssmsmtitle }&nbsp;</TD>
			            	<TD width="9%" height="26" class="table_body">套餐日期</TD>
			            	<TD width="24%" class="table_none">${setMealPo.ssmsmcreatedate}&nbsp;</TD>
			              <TD width="9%" height="26" class="table_body">套餐形式</TD>
			              <TD width="24%" class="table_none">${setMealPo.ssmsmform eq '1' ? '多种优惠方式' : '单一优惠方式' }</TD>
			             
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">生效日期</TD>
			              <TD class="table_none">${setMealPo.ssmsmeffectivedate }&nbsp;
			              </TD>
           				  <TD height="26" class="table_body">截止日期</TD>
                        	<TD height="26" class="table_none" >${setMealPo.ssmsmenddate}&nbsp; </TD>
                        	<TD height="26" class="table_body">套餐分类</TD>
                        	<TD height="26" class="table_none" >
                        	   <c:if test="${setMealPo.ssmsmclassify eq '1' }">框镜销售</c:if>
                        	   <c:if test="${setMealPo.ssmsmclassify eq '3' }">隐形销售</c:if>
                        	   <c:if test="${setMealPo.ssmsmclassify eq '5' }">辅料销售</c:if>&nbsp;                     	  
                      	  </TD>
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">套餐价格区间</TD>
			              <TD class="table_none">
                             ${setMealPo.ssmsmsourcebgnAmount }&nbsp;至&nbsp;${setMealPo.ssmsmsourceendAmount }
			              </TD>
           				  <TD height="26" class="table_body">套餐金额</TD>
                          <TD height="26" class="table_none">${setMealPo.ssmsmendbgnAmount}&nbsp;</TD> 
                          <TD height="26" class="table_body">允许累计积分</TD>
						  <TD class="table_none">${setMealPo.ssmsmintegralsum eq '2' ? '不允许' : '允许' }&nbsp;</TD>                       	
			            </TR>
			            <TR>
                          <TD height="26" class="table_body">允许累加</TD>
						  <TD class="table_none">${setMealPo.ssmsmissum eq '0' ? '不允许' : '允许' }&nbsp;</TD>
						  <TD height="26" class="table_body">折上折</TD>
						  <TD class="table_none" colspan="3">
						  	  ${setMealPo.ssmsmisdiscount eq '0' ? '不允许' : '允许' }
                          </TD>
			            </TR>
			            <c:if test="${setMealPo.ssmsmisenabled ne '1'}">
			            <TR>
                          <TD height="26" class="table_body">失效状态</TD>
						  <TD class="table_none">${setMealPo.ssmsmisenabled eq '1' ? '未失效' : '已失效' }&nbsp;</TD>
						  <TD height="26" class="table_body">停用人</TD>
						  <TD class="table_none">
						  	  ${setMealPo.ssmsmunenabledpersonname }&nbsp;
                          </TD>
                          <TD height="26" class="table_body">失效日期</TD>
						  <TD class="table_none">
						  	  ${setMealPo.ssmsmunenableddate}&nbsp;
                          </TD>
			            </TR>
			            </c:if>	
				        <TR>                             
				           <TD height="62" class="table_body">活动门店
				           </TD>
				           <TD class="table_none" colspan="5">
								<li class="horizontal_onlyRight">${setMealPo.ssmsmshopcodename }&nbsp;</TD>
				        </TR>
			            <TR>
			               <TD height="62" class="table_body">备注</TD>
						   <TD class="table_none" colspan="5">${setMealPo.ssmsmremark }&nbsp;</TD>
			            </TR>
                    </TABLE>
            <c:if test="${not empty(salesGoodsArrayList)}">        
                    <br>    
      				<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
             </c:if>                           
             <c:if test="${setMealPo.ssmsmdetailform eq '12'}">
                    <br/>  
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR align=middle>
                          <TD height="26" class="table_body" width="9%">整单满</TD>
                          <TD align="left" class="table_none">${setMealPo.ssmsmexpensespendup}&nbsp;至&nbsp;${setMealPo.ssmsmexpensespendul}</TD>
                        </TR>
                      </TBODY>
                    </TABLE>  
             </c:if>
             <c:if test="${setMealPo.ssmsmdetailform eq '22' || setMealPo.ssmsmdetailform eq '23' || setMealPo.ssmsmdetailform eq '24'}">
                    <br/>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0>
                      <TBODY>
                        <TR align=middle>
                          <TD height="26" class="table_body" width="9%">整单满</TD>
                          <TD align="left" class="table_none" width="20%">${setMealPo.ssmsmexpensespendup }&nbsp;至&nbsp;${setMealPo.ssmsmexpensespendul}</TD>
                          <td align="left" class="table_none" width="15%">
                                                                        优惠方式：<c:if test="${setMealPo.ssmsmdetailform eq '23'}">打折</c:if><c:if test="${setMealPo.ssmsmdetailform eq '22'}">返现</c:if><c:if test="${setMealPo.ssmsmdetailform eq '24'}">特价</c:if>
                          </td>
                          <td align="left" class="table_none" width="60%">
                          <c:if test="${setMealPo.ssmsmdetailform eq '23'}">${setMealPo.ssmsmdiscountrate }</c:if>
                          <c:if test="${setMealPo.ssmsmdetailform eq '22'}">${setMealPo.ssmsmexpenseamount }</c:if>
                          <c:if test="${setMealPo.ssmsmdetailform eq '24'}">${setMealPo.ssmsmsalesbillamount }</c:if>
                          &nbsp;</td>
                        </TR>
                      </TBODY>
                    </TABLE> 
             </c:if>
             <c:if test="${not empty(salesGoodsArrayList)}">
                  <br/>        
					<fieldset id="show1">
					<legend style="font-size:18px">购买商品</legend>
					<TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR valign="middle">
                        <td align="left" width="80%">购买方式 :&nbsp; 
                          <input id="x1" name='setMealPo.ssmsmsalesflag' type="radio" ${setMealPo.ssmsmsalesflag eq '1' ? 'checked="checked"' : 'disabled="disabled"' } value="1" >任选其一
                          <input id="x2" name='setMealPo.ssmsmsalesflag' type="radio" ${setMealPo.ssmsmsalesflag eq '2' ? 'checked="checked"' : 'disabled="disabled"' } value="2" >符合全部
                        </td>
                      </TR>
                    </TABLE>
             <c:if test="${setMealPo.ssmsmdetailform eq '12' || setMealPo.ssmsmdetailform eq '11' || setMealPo.ssmsmdetailform eq '21'}">       
					<TABLE id="addTablebangding" width="100%"  border=0 cellspacing=1>
                      <TBODY>
                        <TR class=table_title align="center" valign="middle">
						  <TH width="39%" scope=col height="26">商品信息</TH>
                          <TH width="9%" scope=col>商品原价区间</TH>
                          <TH width="9%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>销售数量</TH>
                          <TH width="9%" scope=col>消费满</TH> 
						  <TH width="5%" scope=col>优惠方式</TH>
						  <TH width="5%" scope=col>套餐单价</TH>
						  <TH width="5%" scope=col>特价金额</TH>
						  <TH width="5%" scope=col>优惠金额</TH>
						  <TH width="5%" scope=col>优惠折扣</TH>
                         </TR>
                     <s:iterator value="salesGoodsArrayList" status="idx">
                       <c:if test="${ssmsgflag eq '1'}">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <Td align="left" height="26">
                          <li class="horizontal_onlyRight">
                          <c:if test="${setMealPo.ssmsmclassify eq '1'}">
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize eq '0' }">成品片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize eq 'D' }">订做片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize!='0' && ssmsgiscustomize!='D' }">镜片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                  </c:if>
                          <c:if test="${setMealPo.ssmsmclassify eq '3'}">
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize eq '0'}">隐形成品片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize eq 'D' }">隐形订做片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize!='0' && ssmsgiscustomize!='D' }">隐形镜片</c:if> 
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>      	                       
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>	                    
      	                  </c:if>  
                          <c:if test="${setMealPo.ssmsmclassify eq '5'}">
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>      	                       
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>
      		              </c:if>
      		              &nbsp;&nbsp;&nbsp;
      		              </li>
      		              <li class="horizontal_onlyRight">
                             ${ssmsgsmallclass}
                          </li>
      		              &nbsp;&nbsp;
                          <li class="horizontal_onlyRight">${ssmsggoodsname}</li>    
                          </Td>
                          <Td>${ssmsgmincostPrice}至${ssmsgmaxcostPrice}</Td>
                          <Td>${ssmsgbeginAmount}至${ssmsgendAmount}</Td>
                          <Td>${ssmsggoodsquantity}</Td>
                          <Td>${ssmsgexpensespendup}至${ssmsgexpensespendul}</Td>
                          <Td>
                              <c:if test="${ssmsgfavorableflag eq '1'}">原价</c:if>
                              <c:if test="${ssmsgfavorableflag eq '2'}">打折</c:if>
                              <c:if test="${ssmsgfavorableflag eq '3'}">返现</c:if>
                              <c:if test="${ssmsgfavorableflag eq '4'}">特价</c:if>
                          </Td>
                          <Td>${ssmsgretailPrice}</Td>
						  <Td>${ssmsgspecialoffer}</Td>  
                          <Td>${ssmsgexpensecredit}</Td>
                          <Td>${ssmsgdiscountrate}</Td>
                         </TR>
                         </c:if>
                         </s:iterator>
                                                  
					  </TBODY>
                    </TABLE>
            </c:if>
            <c:if test="${setMealPo.ssmsmdetailform eq '22' || setMealPo.ssmsmdetailform eq '23' || setMealPo.ssmsmdetailform eq '24'}">
            		<TABLE id="addTablebangding" width="100%"  border=0 cellspacing=1>
                      <TBODY>
                        <TR class=table_title align="center" valign="middle">
						  <TH width="39%" scope=col height="26">商品信息</TH>
                          <TH width="9%" scope=col>商品原价区间</TH>
                          <TH width="9%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>销售数量</TH>
                          <TH width="9%" scope=col>消费满</TH>
                         </TR>
                     <s:iterator value="salesGoodsArrayList" status="idx">
                       <c:if test="${ssmsgflag eq '1'}">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <Td align="left" height="26">
                          <li class="horizontal_onlyRight">
                          <c:if test="${setMealPo.ssmsmclassify eq '1'}">
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize eq '0' }">成品片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize eq 'D' }">订做片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize!='0' && ssmsgiscustomize!='D' }">镜片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>
      	                  </c:if>
                          <c:if test="${setMealPo.ssmsmclassify eq '3'}">
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize eq '0'}">隐形成品片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize eq 'D' }">隐形订做片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize!='0' && ssmsgiscustomize!='D' }">隐形镜片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>      	                       
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>      	                    
      	                  </c:if>  
                          <c:if test="${setMealPo.ssmsmclassify eq '5'}">
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>      	                       
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>
      		              </c:if>
      		              &nbsp;&nbsp;&nbsp;
      		              </li>
      		              <li class="horizontal_onlyRight">
                             ${ssmsgsmallclass}
                          </li>
      		              &nbsp;&nbsp;
                          <li class="horizontal_onlyRight">${ssmsggoodsname}</li>    
                          </Td>
                          <Td>${ssmsgmincostPrice}至${ssmsgmaxcostPrice}</Td>
                          <Td>${ssmsgbeginAmount}至${ssmsgendAmount}</Td>
                          <Td>${ssmsggoodsquantity}</Td>
                          <Td>${ssmsgexpensespendup}至${ssmsgexpensespendul}</Td>                          
                         </TR>
                         </c:if>
                         </s:iterator>
                                                  
					  </TBODY>
                    </TABLE>
            </c:if>        
                    <table width="100%" border=0 align=center>
                      <TBODY>
                        <TR>
                          <TD></TD>
                        </TR>
                      </TBODY>
                      </table>
					</fieldset>
		</c:if>			
		<c:if test="${(setMealPo.ssmsmdetailform eq '11' || setMealPo.ssmsmdetailform eq '12')}">	
					<br>				
					<fieldset id="show3">
					<legend style="font-size:18px">优惠商品</legend>				
					<TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR valign="middle">
                        <td align="left" width="80%">优惠方式: &nbsp;
                          <input id="x5" name='setMealPo.ssmsmcreditflag' type="radio" ${setMealPo.ssmsmcreditflag eq '1' ? 'checked="checked"' : 'disabled="disabled"' } >任选其一
                          <input id="x6" name='setMealPo.ssmsmcreditflag' type="radio" ${setMealPo.ssmsmcreditflag eq '2' ? 'checked="checked"' : 'disabled="disabled"' } >符合全部
                        </td>
                      </TR>
                    </TABLE>
                    
					<TABLE id="addTablesong2" width="100%"  border=0 align=center cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>				  
                          <TH width="39%" scope=col height="26">商品信息</TH>
                          <TH width="10%" scope=col>商品原价区间</TH>
                          <TH width="10%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>商品数量</TH> 
						  <TH width="5%" scope=col>优惠方式</TH>
						  <TH width="5%" scope=col>套餐单价</TH>
						  <TH width="5%" scope=col>特价金额</TH>
						  <TH width="5%" scope=col>优惠金额</TH>
						  <TH width="5%" scope=col>优惠折扣</TH> 
                         </TR>
                  <s:iterator value="salesGoodsArrayList" status="idx">
                       <c:if test="${ssmsgflag eq '2'}">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <Td align="left" height="26">
                          <li class="horizontal_onlyRight">
                          <c:if test="${setMealPo.ssmsmclassify eq '1'}">
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize eq '0' }">成品片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize eq 'D' }">订做片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '3' && ssmsgiscustomize!='0' && ssmsgiscustomize!='D' }">镜片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>
      	                  </c:if>
                          <c:if test="${setMealPo.ssmsmclassify eq '3'}">
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize eq '0'}">隐形成品片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize eq 'D' }">隐形订做片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '4' && ssmsgiscustomize!='0' && ssmsgiscustomize!='D' }">隐形镜片</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>      	                       
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>       	                    
      	                  </c:if>  
                          <c:if test="${setMealPo.ssmsmclassify eq '5'}">
      	                       <c:if test="${ssmsggoodscategory eq '6'}">太阳镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '8'}">老花镜</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '1'}">镜架</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '7'}">耗材</c:if>  
      	                       <c:if test="${ssmsggoodscategory eq '9'}">视光</c:if>
      	                       <c:if test="${ssmsggoodscategory eq '5'}">隐形护理液</c:if>  
      	                       <c:if test="${ssmsggoodscategory eq '2'}">配件</c:if>      		                
      		              </c:if>
      		              &nbsp;&nbsp;&nbsp;      		              
                          </li>  
                         
      		              <li class="horizontal_onlyRight">
                              ${ssmsgsmallclass}        
                          </li>
      		              &nbsp;&nbsp; 
                          <li class="horizontal_onlyRight">${ssmsggoodsname} </li>
      
                          </Td>
                          <Td>${ssmsgmincostPrice}至${ssmsgmaxcostPrice}</Td>
                          <Td>${ssmsgbeginAmount}至${ssmsgendAmount}</Td>
                          <Td>${ssmsggoodsquantity}</Td>
                          <Td>
                              <c:if test="${ssmsgfavorableflag eq '1'}">原价</c:if>
                              <c:if test="${ssmsgfavorableflag eq '2'}">打折</c:if>
                              <c:if test="${ssmsgfavorableflag eq '3'}">返现</c:if>
                              <c:if test="${ssmsgfavorableflag eq '4'}">特价</c:if>
                          </Td>
                          <Td>${ssmsgretailPrice}</Td>
						  <Td>${ssmsgspecialoffer}</Td>  
                          <Td>${ssmsgexpensecredit}</Td>
                          <Td>${ssmsgdiscountrate}</Td>				  
                         </TR>
                         </c:if>
                      </s:iterator>                        
                         
					  </TBODY>
                    </TABLE>
					</fieldset> 
				</c:if>	                     
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
    </form></BODY></html>