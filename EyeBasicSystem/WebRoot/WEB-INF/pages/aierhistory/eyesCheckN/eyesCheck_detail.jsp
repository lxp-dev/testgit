<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000;
	font-weight: bold;
}
-->
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查维护</title>
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
<body onkeydown="KeyDown()"    onhelp="Showhelp();return false;">
<form name="salaryForm" method="post" action="">
<input type="hidden" name="moduleID" value="${moduleID}">

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
					  <fieldset>
						<legend>顾客资料</legend>
						<table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
						  		<TR>
                                     <TD width="10%" class="table_body" height="30">卡号：</TD>
                                     <TD width="15%" class="table_none"><div align="left">${eyesCheckPo.sopeccustomerpostcode}&nbsp;</div></TD>
                                     <TD width="10%" class="table_body">姓名：&nbsp;</TD>
                                     <TD width="15%" class="table_none"><div align="left">${eyesCheckPo.sopeccustomername}&nbsp;</div></TD>
                                     <TD width="10%" class="table_body">检查人员：</TD>
                                     <TD width="15%" class="table_none"><div align="left">${eyesCheckPo.sopecpersonname}&nbsp;</div></TD>
                                     <TD width="10%" class="table_body">检查时间：</TD>
                                     <TD width="15%" class="table_none"><div align="left">${fn:substring(eyesCheckPo.sopecvisiontime,0,16)}&nbsp;</div></TD>
                                   </TR>
					  </table>
					</fieldset>			 
					<br />		
						<fieldset>
							<legend>检查项目</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="3%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="17%" class="table_body"><div align="center">外眼</div></TD>
                                      <TD width="22%" class="table_body"><div align="center">结膜充血</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">结膜</div></TD>
                                      <TD width="21%" class="table_body"><div align="center">角膜</div></TD>
                                      <TD width="20%" class="table_body"><div align="center">泪液</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OD</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecsurfaceeyeod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='1')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccongestiveod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='2')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                       
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecnippleod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='3')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccornealod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='4')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                       
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopectearosod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='5')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OS</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecsurfaceeyeos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='1')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccongestiveos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='2')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecnippleos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='3')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccornealos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='4')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopectearosos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='5')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							    <br>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="2%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="11%" class="table_body"><div align="center">前房</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">虹膜</div></TD>
                                      <TD width="16%" class="table_body"><div align="center">晶体</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">眼底</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">眼球运动</div></TD>
                                      <TD width="14%" class="table_body"><div align="center">色觉</div></TD>
                                      <TD class="table_body"><div align="center">眼压</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OD</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopechyphemaod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='6')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecirisod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='7')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccrystalod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='8')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecfundusod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='9')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccampaignod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='10')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccolorod == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='11')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div>
                                      </TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                          ${eyesCheckPo.sopeciopod}&nbsp;mmHg                                     
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OS</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopechyphemaos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='6')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecirisos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='7')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccrystalos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='8')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecfundusos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='9')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccampaignos == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='10')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopeccoloros == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='11')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${eyesCheckPo.sopeciopos}&nbsp;mmHg                                      
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
							
							<TABLE width="99%" border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="10%" height="30" class="table_body">是否散瞳</TD>
                                      <TD width="23%" class="table_none">
                                      	${eyesCheckPo.sopecismydriasis != '1' ? '否' : '是'}&nbsp;
                                      </TD>
									  <TD width="10%" height="30" class="table_body">散瞳用药</TD>
                                      <TD width="23%" class="table_none">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecanaesthetic == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='13')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
				                      </TD>
									  <TD width="10%" height="30" class="table_body">眼部健康诊断</TD>
                                      <TD width="23%" class="table_none">
                                      	<c:if test="${eyesCheckPo.sopecfruit == '0'}">正常	</c:if>
                                      	<c:if test="${eyesCheckPo.sopecfruit == '1'}">异常:
                                      	  <c:set value="${ fn:split(eyesCheckPo.sopecills, ',') }" var="str" />                                      	
                                          <c:forEach items="${ str }" var="s">
          									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      	<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='60')}">
		                                      		${optionParamPoTmp.fopparamname} 
		                                      	</c:if>	                                      	
	                                      	</c:forEach> 
										  </c:forEach>   
										  </c:if>&nbsp;                                  	
									  </TD>
								  </TR>
							  	</TBODY>
							  </TABLE>
							  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorder">
                                  <TBODY>
                                    <TR>
                                      <TD width="20%" height="30" class="table_body">眼病史</TD>
                                      <TD width="80%" class="table_none">
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecillhistory1 == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='14')}">
		                                      	${optionParamPoTmp.fopparamname}&nbsp;&nbsp;
		                                      </c:if>	                                      	
	                                     </c:forEach>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecillhistory2 == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='14')}">
		                                      	${optionParamPoTmp.fopparamname}&nbsp;&nbsp;
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecillhistory3 == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='14')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">遗传史</TD>
                                      <TD class="table_none">
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecheredityhistory1 == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='15')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
	                                  </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">过敏史</TD>
                                      <TD class="table_none">
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${(eyesCheckPo.sopecallergyhistory1 == optionParamPoTmp.fopparamid) && (optionParamPoTmp.fopparentid=='16')}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                      
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
						</fieldset>               	
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>