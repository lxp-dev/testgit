<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加工检验管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>
<script>

	$(document).ready(function (){
		assignmentZT();
		jassignmentZT();
	});
	
	function assignmentZT(){
		if($('#pchckcokeballglassod').text()!=''&&$('#pchckcokepostglassod').text()!=''&&$('#pchckcokeaxesod').text()!=''){
			$('#pchckcokeballglassod2').text((parseFloat($('#pchckcokeballglassod').text())+parseFloat($('#pchckcokepostglassod').text())).toFixed(2));
			$('#pchckcokepostglassod2').text((parseFloat($('#pchckcokepostglassod').text())-parseFloat($('#pchckcokepostglassod').text())-parseFloat($('#pchckcokepostglassod').text())).toFixed(2));
			$('#pchckcokeaxesod2').text($('#pchckcokeaxesod').text()<=90?parseFloat($('#pchckcokeaxesod').text())+parseFloat(90):parseFloat($('#pchckcokeaxesod').text())-parseFloat(90));
		}
			
		if($('#pchckcokeballglassos').text()!=''&&$('#pchckcokepostglassos').text()!=''&&$('#pchckcokeaxesos').text()!=''){
			$('#pchckcokeballglassos2').text((parseFloat($('#pchckcokeballglassos').text())+parseFloat($('#pchckcokepostglassos').text())).toFixed(2));
			$('#pchckcokepostglassos2').text((parseFloat($('#pchckcokepostglassos').text())-parseFloat($('#pchckcokepostglassos').text())-parseFloat($('#pchckcokepostglassos').text())).toFixed(2));
			$('#pchckcokeaxesos2').text($('#pchckcokeaxesos').text()<=90?parseFloat($('#pchckcokeaxesos').text())+parseFloat(90):parseFloat($('#pchckcokeaxesos').text())-parseFloat(90));
		}
				
	}
	
	function jassignmentZT(){
		if($('#jpchckcokeballglassod').text()!=''&&$('#jpchckcokepostglassod').text()!=''&&$('#jpchckcokeaxesod').text()!=''){
			$('#jpchckcokeballglassod2').text((parseFloat($('#jpchckcokeballglassod').text())+parseFloat($('#jpchckcokepostglassod').text())).toFixed(2));
			$('#jpchckcokepostglassod2').text((parseFloat($('#jpchckcokepostglassod').text())-parseFloat($('#jpchckcokepostglassod').text())-parseFloat($('#jpchckcokepostglassod').text())).toFixed(2));
			$('#jpchckcokeaxesod2').text($('#jpchckcokeaxesod').text()<=90?parseFloat($('#jpchckcokeaxesod').text())+parseFloat(90):parseFloat($('#jpchckcokeaxesod').text())-parseFloat(90));
		}
			
		if($('#jpchckcokeballglassos').text()!=''&&$('#jpchckcokepostglassos').text()!=''&&$('#jpchckcokeaxesos').text()!=''){
			$('#jpchckcokeballglassos2').text((parseFloat($('#jpchckcokeballglassos').text())+parseFloat($('#jpchckcokepostglassos').text())).toFixed(2));
			$('#jpchckcokepostglassos2').text((parseFloat($('#jpchckcokepostglassos').text())-parseFloat($('#jpchckcokepostglassos').text())-parseFloat($('#jpchckcokepostglassos').text())).toFixed(2));
			$('#jpchckcokeaxesos2').text($('#jpchckcokeaxesos').text()<=90?parseFloat($('#jpchckcokeaxesos').text())+parseFloat(90):parseFloat($('#jpchckcokeaxesos').text())-parseFloat(90));
		}
				
	}
		
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckInsertForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${salesBasicPo.ssesbsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif>
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
                     <TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                     </TABLE>
					 <TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="20%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="8%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbshopName}</TD>
						   <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}　　【卡号：${salesBasicPo.ssesbMemberId}】</TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none" >${salesBasicPo.ssesbphone}</TD>
						   <TD height="26" class="table_body">加工师</TD>
			               <TD class="table_none" >
			               	${workingCheckPo.pchckprocesspersonname }
			               </TD>
			               <TD height="26" class="table_body">检验员</TD>
			               <TD class="table_none" >${sessionScope.person.personName}</TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">抽检人</TD>
			               <TD class="table_none" >
			               	${workingCheckPo.pchckpersonname}
			               </TD>
			               <TD height="26" class="table_body">抽检结果</TD>
			               <TD class="table_none">
			               <c:if test="${samplingCheckPo.pchckqualified == '1' }">
			               	合格
			               </c:if>
			               <c:if test="${samplingCheckPo.pchckqualified != '1' }">
			               	不合格
			               </c:if>						 
                           </TD>
                           <TD height="26" class="table_body">配送地点</TD>
			               <TD class="table_none" ${salesBasicPo.ssesbshopName== salesBasicPo.ssesbtakeshopname  ? '' : 'style="color: red;"' }>
			               	${salesBasicPo.ssesbtakeshopname}
			               </TD>
                        </TR> 
                        <TR>
						   
			               <TD height="26" class="table_body">特殊加工要求</TD>
			               <TD class="table_none" colspan="5">
			               		<font color="red">
			               				<c:if test="${not empty(specialPDetailList)}">
			               					<s:iterator value="specialPDetailList">
			               						${ssesdrequirement} &nbsp;&nbsp;&nbsp;&nbsp;
			               					</s:iterator>
			               				</c:if>
			               		</font>
			               </TD>
                        </TR>               
                      </TBODY>
                    </TABLE>             
                     <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="26">右眼(R)/左眼(L)</TH>		
						  <TH width="10%" scope=col height="26">子午面</TH>				
						  <TH width="10%" scope=col>球镜</TH>
						  <TH width="10%" scope=col>柱镜</TH>
						  <TH width="10%" scope=col>轴向</TH>
						  <TH width="15%" scope=col>斜视</TH>
						  <TH width="10%" scope=col>add</TH>
						  <TH width="10%" scope=col>瞳距</TH>
						  <TH width="15%" scope=col>商品名称</TH>
						</TR>
                        <TR class="row">
                          <TD align="center" height="26" rowspan="4">R</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${joDPo.ssesbballglassod}</TD>
                          <TD>${joDPo.ssesbpostglassod}</TD>
                          <TD>${joDPo.ssesbaxesod}</TD>
                          <TD>${joDPo.ssesbarriseglassod}&nbsp;&nbsp;&nbsp;&nbsp;${joDPo.ssesbbasisod}</TD>
                          <TD>${joDPo.ssesbaddod}</TD>
                          <c:if test="${(joDPo.ssesbrecipetype)==1}">
                          <TD>${joDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${(joDPo.ssesbrecipetype)==2}">
                          <TD>${joDPo.ssesbinterdistanceod}</TD>
                          </c:if>
                          <c:if test="${(joDPo.ssesbrecipetype)==3}">
                          <TD>${joDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <TD rowspan="4">${joDPo.ssesbgoodsname}</TD>
						</TR>
						<TR class="row" >
                          <TD align="center" height="26">焦度计</TD>
                          <TD id="jpchckcokeballglassod">${workingCheckPo.pchckcokeballglassod }</TD>
                          <TD id="jpchckcokepostglassod">${workingCheckPo.pchckcokepostglassod }</TD>
                          <TD id="jpchckcokeaxesod">${workingCheckPo.pchckcokeaxesod}</TD>
                          <TD rowspan="3" align="center">
                          	三棱镜：${workingCheckPo.pchckcokearriseglassod }&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${workingCheckPo.pchckcokebasisod }
                          </TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokeaddod }</TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokepupildistanceod }</TD>
						</TR>
						<tr class="row" >
						  <TD height="26">主子午面二</TD>
						  <c:if test="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod>0}">
						  	<TD>+${joDPo.ssesbballglassod+joDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod<0}">
						  	<TD>${joDPo.ssesbballglassod+joDPo.ssesbpostglassod}</TD>
						  </c:if>
						  
						  <c:if test="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  <c:if test="${joDPo.ssesbpostglassod=='0.00'}">
						  	<TD>${joDPo.ssesbpostglassod}</TD>
						  </c:if>
						 
						  <c:if test="${joDPo.ssesbpostglassod!='0.00'}">
							  	<c:if test="${-joDPo.ssesbpostglassod>0}">
							  		<TD>+${-joDPo.ssesbpostglassod}</TD>
							    </c:if>
							    <c:if test="${-joDPo.ssesbpostglassod<0}">
							  		<TD>${-joDPo.ssesbpostglassod}</TD>
							    </c:if>
						  </c:if>
						  <c:if test="${joDPo.ssesbaxesod == '0.00'}">
						  	<TD>${joDPo.ssesbaxesod}</TD>
						  </c:if>
						  <c:if test="${joDPo.ssesbaxesod != '0.00'}">
								<c:if test="${joDPo.ssesbaxesod == ''}">
								  	<TD>&nbsp;</TD>
								</c:if>
						  		<c:if test="${joDPo.ssesbaxesod != '' && joDPo.ssesbaxesod <= 90}">
						  			<TD>${joDPo.ssesbaxesod + 90}</TD>
						    	</c:if>
						  		<c:if test="${joDPo.ssesbaxesod != '' && joDPo.ssesbaxesod > 90}">
						  			<TD>${joDPo.ssesbaxesod - 90}</TD>
						  		</c:if>
						  </c:if>
						</tr>
						<tr class="row" >
						  <TD height="26">焦度计</TD>
						  <TD id="jpchckcokeballglassod2"></TD>
                          <TD id="jpchckcokepostglassod2"></TD>
                          <TD id="jpchckcokeaxesod2"></TD>
						  					 
						</tr>
						<TR class="row" >
                          <TD align="center" height="26" rowspan="4">L</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${joSPo.ssesbballglassos}</TD>
                          <TD>${joSPo.ssesbpostglassos}</TD>
                          <TD>${joSPo.ssesbaxesos}</TD>
                          <TD>${joSPo.ssesbarriseglassos}&nbsp;&nbsp;&nbsp;&nbsp;${joSPo.ssesbbasisos}</TD>
                          <TD>${joSPo.ssesbaddos}</TD>
                          
                          <c:if test="${(joSPo.ssesbrecipetype)==1}">
                          <TD>${joSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${(joSPo.ssesbrecipetype)==2}">
                          <TD>${joSPo.ssesbinterdistanceos}</TD>
                          </c:if>
                          <c:if test="${(joSPo.ssesbrecipetype)==3}">
                          <TD>${joSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <TD rowspan="4">${joSPo.ssesbgoodsname}</TD>
						</TR>
						
						<TR class="row">
                          <TD align="center" height="26">焦度计</TD>
                          <TD id="jpchckcokeballglassos">${workingCheckPo.pchckcokeballglassos }</TD>
                          <TD id="jpchckcokepostglassos">${workingCheckPo.pchckcokepostglassos }</TD>
                          <TD id="jpchckcokeaxesos">${workingCheckPo.pchckcokeaxesos }</TD>
                          <TD rowspan="3">
                          	三棱镜：${workingCheckPo.pchckcokearriseglassos }&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${workingCheckPo.pchckcokebasisos }                       	
                          </TD>
                          
                          <TD rowspan="3">${workingCheckPo.pchckcokeaddos }</TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokepupildistanceos }</TD>
						</TR>
						<tr class="row">
						  <TD height="26">主子午面二</TD>
						  <c:if test="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos>0}">
						  	<TD>+${joSPo.ssesbballglassos+joSPo.ssesbpostglassos}</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos<0}">
						  	<TD>${joSPo.ssesbballglassos+joSPo.ssesbpostglassos}</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbpostglassos=='0.00'}">
						  	<TD>${joSPo.ssesbpostglassos}</TD>
						  </c:if>
						  <c:if test="${joSPo.ssesbpostglassos!='0.00'}">
							  	<c:if test="${-joSPo.ssesbpostglassos>0}">
							  		<TD>+${-joSPo.ssesbpostglassos}</TD>
							    </c:if>
							    <c:if test="${-joSPo.ssesbpostglassos<0}">
							  		<TD>${-joSPo.ssesbpostglassos}</TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbaxesos=='0.00'}">
						  	<TD>${joSPo.ssesbaxesos}</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbaxesos!='0.00'}">				  		
						  		<c:if test="${joSPo.ssesbaxesos == ''}">
								  	<TD>&nbsp;</TD>
								</c:if>
						  		<c:if test="${joSPo.ssesbaxesos != '' && joSPo.ssesbaxesos <= 90}">
						  			<TD>${joSPo.ssesbaxesos + 90}</TD>
						    	</c:if>
						  		<c:if test="${joSPo.ssesbaxesos != '' && joSPo.ssesbaxesos > 90}">
						  			<TD>${joSPo.ssesbaxesos - 90}</TD>
						  		</c:if>
						  </c:if>				  
						</tr>
						<tr class="row">
						  <TD height="26">焦度计</TD>
						  <TD id="jpchckcokeballglassos2"></TD>
                          <TD id="jpchckcokepostglassos2"></TD>
                          <TD id="jpchckcokeaxesos2"></TD>
								 
						</tr>		
						
						</TBODY>
                    </TABLE>
               
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
						  <TH width="10%" scope=col>光心垂差</TH>						
						  <TH width="18%" scope=col>光心垂差(焦度计)</TH>
						  <TH width="18%" scope=col>光心高度</TH>
						  <TH width="18%" scope=col>色泽互差</TH>
						  <TH width="18%" scope=col>装配质量</TH>
						  <TH width="18%" scope=col>整形</TH>
						  </TR>
                        <TR class="row">
                          <TD align="center" height="26" id="oldgxcc"> ${salesBasicPo.ssesblightvertical}</TD>
                          <TD>${workingCheckPo.pchckcokecentervertical }</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
						</TR>				  
                      </TBODY>
                    </TABLE>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="26">右眼(R)/左眼(L)</TH>		
						  <TH width="10%" scope=col height="26">子午面</TH>				
						  <TH width="10%" scope=col>球镜</TH>
						  <TH width="10%" scope=col>柱镜</TH>
						  <TH width="10%" scope=col>轴向</TH>
						  <TH width="15%" scope=col>斜视</TH>
						  <TH width="10%" scope=col>add</TH>
						  <TH width="10%" scope=col>瞳距</TH>
						  <TH width="15%" scope=col>商品名称</TH>
						  </TR>
                        
                        <TR class="row">
                          <TD align="center" height="26" rowspan="4">R</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${oDPo.ssesbballglassod}</TD>
                          <TD>${oDPo.ssesbpostglassod}</TD>
                          <TD>${oDPo.ssesbaxesod}</TD>
                          <TD>${oDPo.ssesbarriseglassod}&nbsp;&nbsp;&nbsp;&nbsp;${oDPo.ssesbbasisod}</TD>
                          <TD>${oDPo.ssesbaddod}</TD>
                          
                          <c:if test="${(oDPo.ssesbrecipetype)==1}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)==2}">
                          <TD>${oDPo.ssesbinterdistanceod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)==3}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          
                          <TD rowspan="4">${oDPo.ssesbgoodsname}</TD>
						</TR>
						
						<TR class="row" >
                          <TD align="center" height="26">焦度计</TD>
                          <TD id="pchckcokeballglassod">${samplingCheckPo.pchckcokeballglassod }</TD>
                          <TD id="pchckcokepostglassod">${samplingCheckPo.pchckcokepostglassod }</TD>
                          <TD id="pchckcokeaxesod">${samplingCheckPo.pchckcokeaxesod }</TD>
                          <TD rowspan="3">
                          	三棱镜：${samplingCheckPo.pchckcokearriseglassod}
                          	&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${samplingCheckPo.pchckcokebasisod}

                          </TD>
                          <TD rowspan="3" id="pchckcokeaddod">${samplingCheckPo.pchckcokeaddod}</TD>
                          <TD rowspan="3" id="pchckcokepupildistanceod">${samplingCheckPo.pchckcokepupildistanceod}</TD>
						</TR>
						<tr class="row" >
						  <TD height="26">主子午面二</TD>
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod>0}">
						  	<TD>+${oDPo.ssesbballglassod+oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod<0}">
						  	<TD>${oDPo.ssesbballglassod+oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbpostglassod=='0.00'}">
						  	<TD>${oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbpostglassod!='0.00'}">
							  	<c:if test="${-oDPo.ssesbpostglassod>0}">
							  		<TD>+${-oDPo.ssesbpostglassod}</TD>
							    </c:if>
							    <c:if test="${-oDPo.ssesbpostglassod<0}">
							  		<TD>${-oDPo.ssesbpostglassod}</TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbaxesod=='0.00'}">
						  	<TD>${oDPo.ssesbaxesod}</TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbaxesod!='0.00'}">
						  		<c:if test="${oDPo.ssesbaxesod == ''}">
						  			<TD>&nbsp;</TD>
						    	</c:if>
						  		<c:if test="${oDPo.ssesbaxesod != '' && oDPo.ssesbaxesod<=90}">
						  			<TD>${oDPo.ssesbaxesod+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${oDPo.ssesbaxesod != '' && oDPo.ssesbaxesod>90}">
						  			<TD>${oDPo.ssesbaxesod-90}</TD>
						  		</c:if>
						  </c:if>
						  			  
						</tr>
						<tr class="row" >
						  <TD height="26">焦度计</TD>
						  <TD id="pchckcokeballglassod2"></TD>
                          <TD id="pchckcokepostglassod2"></TD>
                          <TD id="pchckcokeaxesod2"></TD>
						  					 
						</tr>
						<TR class="row" >
                          <TD align="center" height="26" rowspan="4">L</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${oSPo.ssesbballglassos}</TD>
                          <TD>${oSPo.ssesbpostglassos}</TD>
                          <TD>${oSPo.ssesbaxesos}</TD>
                          <TD>${oSPo.ssesbarriseglassos}&nbsp;&nbsp;&nbsp;&nbsp;${oSPo.ssesbbasisos}</TD>
                          <TD>${oSPo.ssesbaddos}</TD>
                          
                          <c:if test="${(oSPo.ssesbrecipetype)==1}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)==2}">
                          <TD>${oSPo.ssesbinterdistanceos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)==3}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <TD rowspan="4">${oSPo.ssesbgoodsname}</TD>
						</TR>
						
						<TR class="row">
                          <TD align="center" height="26">焦度计</TD>
                          <TD id="pchckcokeballglassos">${samplingCheckPo.pchckcokeballglassos}</TD>
                          <TD id="pchckcokepostglassos">${samplingCheckPo.pchckcokepostglassos }</TD>
                          <TD id="pchckcokeaxesos">${samplingCheckPo.pchckcokeaxesos }</TD>
                          <TD rowspan="3">
                          	三棱镜：${samplingCheckPo.pchckcokearriseglassos }
                          	&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${samplingCheckPo.pchckcokebasisos }
                          </TD>
                          
                          <TD rowspan="3">${samplingCheckPo.pchckcokeaddos }</TD>
                          <TD rowspan="3">${samplingCheckPo.pchckcokepupildistanceos }</TD>
						</TR>
						<tr class="row">
						  <TD height="26">主子午面二</TD>
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos>0}">
						  	<TD>+${oSPo.ssesbballglassos+oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos<0}">
						  	<TD>${oSPo.ssesbballglassos+oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbpostglassos=='0.00'}">
						  	<TD>${oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  <c:if test="${oSPo.ssesbpostglassos!='0.00'}">
							  	<c:if test="${-oSPo.ssesbpostglassos>0}">
							  		<TD>+${-oSPo.ssesbpostglassos}</TD>
							    </c:if>
							    <c:if test="${-oSPo.ssesbpostglassos<0}">
							  		<TD>${-oSPo.ssesbpostglassos}</TD>
							    </c:if>				  		
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbaxesos=='0.00'}">
						  	<TD>${oSPo.ssesbaxesos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbaxesos!='0.00'}">						    
							    <c:if test="${oSPo.ssesbaxesos == ''}">
						  			<TD>&nbsp;</TD>
						    	</c:if>
						  		<c:if test="${oSPo.ssesbaxesos != '' && oSPo.ssesbaxesos<=90}">
						  			<TD>${oDPo.ssesbaxesod+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${oSPo.ssesbaxesos != '' && oSPo.ssesbaxesos>90}">
						  			<TD>${oDPo.ssesbaxesod-90}</TD>
						  		</c:if>						  		
						  </c:if>				  
						</tr>
						<tr class="row">
						  <TD height="26">焦度计</TD>
						  <TD id="pchckcokeballglassos2"></TD>
                          <TD id="pchckcokepostglassos2"></TD>
                          <TD id="pchckcokeaxesos2"></TD>
								 
						</tr>		
						
						</TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
						  <TH width="10%" scope=col>光心垂差</TH>						
						  <TH width="18%" scope=col>光心垂差(焦度计)</TH>
						  <TH width="18%" scope=col>光心高度</TH>
						  <TH width="18%" scope=col>色泽互差</TH>
						  <TH width="18%" scope=col>装配质量</TH>
						  <TH width="18%" scope=col>整形</TH>
						  </TR>
                        <TR class="row">
                          <TD align="center" height="26" id="oldgxcc"> ${salesBasicPo.ssesblightvertical}</TD>
                          <TD>${samplingCheckPo.pchckcokecentervertical }</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
						</TR>				  
                      </TBODY>
                    </TABLE>      
                 </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        	<TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
        </TR></TBODY></TABLE>

  </TBODY></TABLE></DIV>
</form>
</body></html>