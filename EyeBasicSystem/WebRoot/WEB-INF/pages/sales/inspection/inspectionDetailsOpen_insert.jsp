<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>验光检查</title>
</head>
<script type="text/javascript">
	function save(){
		if(confirm('是否为正式提交处方？')){
			inspectionForm.action="inspectionInsertDetailsOpen.action?ruleFlag=1&nw='N' ";
			$("img").removeAttr("onclick");
			inspectionForm.submit();
		}else{
			inspectionForm.action="inspectionInsertDetailsOpen.action?ruleFlag=''&nw='N' ";
			$("img").removeAttr("onclick");
			inspectionForm.submit();
		}
	}
</script>
<body>
<form name="inspectionForm" method="post" action="">
<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />
<input type="hidden" name="oldOptometryIDFirst"  value="${requestScope.oldOptometryIDFirst}" />  
<input type="hidden" name="moduleID"  value="${moduleID }"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                                  <TD width="5%"><div><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="6%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="40%" colspan="7">
                           	${customerInfoPo.smeciname}
			               </TD>
                        </TR>
                        
                        <c:forEach var='po' items='${inspectionPos}'>
                        <c:if test="${po.sopipglasstype == '1'}">
                        
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TBODY>
                        <TR>
                           <TD width="6%" height="26" class="table_body">
                                                                                      处方
                           </TD>
			               <TD class="table_none" width="40%" colspan="8">
                            	远用
		 	               </TD>
                        </TR>
                        
                    	<TR>
						   <TD width="12%" height="26" class="table_body">OD:</TD>
			               <TD width="11%" class="table_none" align="center">球径：${po.sopipballglassod  }</TD>
			               <TD width="11%" class="table_none" align="center">柱径：${po.sopippostglassod }</TD>
			               <TD width="11%" class="table_none" align="center">轴向：${po.sopipaxesod }</TD>
			               <TD width="12%" class="table_none" align="center">三棱镜：${po.sopiparriseglassod1 }</TD>
			               <TD width="12%" class="table_none" align="center">基底：${po.sopipbasisod1 }</TD>
						   <TD width="12%" class="table_none" align="center">远用瞳距：${po.sopipinterhighod }</TD>
						   <TD width="12%" class="table_none" align="center">瞳高：${po.sopippupilheightod }</TD>
						   <TD width="12%" class="table_none" align="center">远用VA：${po.sopipfarvaod }</TD>
                        </TR>
						<TR>
						   <TD height="26" class="table_body">OS:</TD>
			               <TD class="table_none" align="center">球径：${po.sopipballglassos  }</TD>
			               <TD class="table_none" align="center">柱径：${po.sopippostglassos }</TD>
			               <TD class="table_none" align="center">轴向：${po.sopipaxesos }</TD>
			               <TD class="table_none" align="center">三棱镜：${po.sopiparriseglassos1 }</TD>
			               <TD class="table_none" align="center">基底：${po.sopipbasisos1 }</TD>
						   <TD class="table_none" align="center">远用瞳距：${po.sopipinterhighos }</TD>
						   <TD width="12%" class="table_none" align="center">瞳高：${po.sopippupilheightos }</TD>
						   <TD class="table_none" align="center">远用VA：${po.sopipfarvaos }</TD>
                        </TR>
                        </TBODY>
                        </table>
                        <br/>
                        </c:if>
                        
                        <c:if test="${po.sopipglasstype == '2'}">
                        <br/>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR>
                           <TD width="6%" height="26" class="table_body">
                                                                            处方
                           </TD>
			               <TD class="table_none" width="40%" colspan="8">
                           	 近用
		 	               </TD>
                        </TR>
                    	<TR>
						   <TD width="12%" height="26" class="table_body">OD:</TD>
			               <TD width="11%" class="table_none" align="center">球径：${po.sopipballglassod  }</TD>
			               <TD width="11%" class="table_none" align="center">柱径：${po.sopippostglassod }</TD>
			               <TD width="11%" class="table_none" align="center">轴向：${po.sopipaxesod }</TD>
			               <TD width="12%" class="table_none" align="center">三棱镜：${po.sopiparriseglassod1 }</TD>
			               <TD width="12%" class="table_none" align="center">基底：${po.sopipbasisod1 }</TD>
						   <TD width="12%" class="table_none" align="center">近用瞳距：${po.sopipinterdistanceod  }</TD>
						   <TD width="12%" class="table_none" align="center">瞳高：${po.sopippupilheightod }</TD>
						   <TD width="12%" class="table_none" align="center">近用VA：${po.sopipclosevaod }</TD>
                        </TR>
						<TR>
						   <TD width="12%" height="26" class="table_body">OS:</TD>
			               <TD width="11%" class="table_none" align="center">球径：${po.sopipballglassos  }</TD>
			               <TD width="11%" class="table_none" align="center">柱径：${po.sopippostglassos }</TD>
			               <TD width="11%" class="table_none" align="center">轴向：${po.sopipaxesos }</TD>
			               <TD width="12%" class="table_none" align="center">三棱镜：${po.sopiparriseglassos1 }</TD>
			               <TD width="12%" class="table_none" align="center">基底：${po.sopipbasisos1 }</TD>
						   <TD width="12%" class="table_none" align="center">近用瞳距：${po.sopipinterdistanceos  }</TD>
						   <TD width="12%" class="table_none" align="center">瞳高：${po.sopippupilheightos }</TD>
						   <TD width="12%" class="table_none" align="center">近用VA：${po.sopipclosevaos }</TD>
                        </TR>
                        </table>
                        <br/>
                        </c:if>
                        
                        <c:if test="${po.sopipglasstype == '3'}">
                        <br/>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR>
                           <TD width="6%" height="26" class="table_body">
                           	处方
                           </TD>
			               <TD class="table_none" width="40%" colspan="11">
                           	渐进/双光
		 	               </TD>
                        </TR>
                    	<TR>
						   <TD width="1%" height="26" class="table_body">OD:</TD>
			               <TD width="9%" class="table_none" align="center">球径：${po.sopipballglassod  }</TD>
			               <TD width="9%" class="table_none" align="center">柱径：${po.sopippostglassod }</TD>
			               <TD width="9%" class="table_none" align="center">轴向：${po.sopipaxesod }</TD>
			               <TD width="9%" class="table_none" align="center">ADD：${po.sopipaddod }</TD>
			               <TD width="9%" class="table_none" align="center">三棱镜：${po.sopiparriseglassod1 }</TD>
			               <TD width="9%" class="table_none" align="center">基底：${po.sopipbasisod1 }</TD>
			               <TD width="9%" class="table_none" align="center">远用瞳距：${po.sopipinterhighod  }</TD>
						   <TD width="9%" class="table_none" align="center">近用瞳距：${po.sopipinterdistanceod  }</TD>
						   <TD width="9%" class="table_none" align="center">瞳高：${po.sopippupilheightod }</TD>
						   <TD width="9%" class="table_none" align="center">远用VA：${po.sopipfarvaod }</TD>
						   <TD width="9%" class="table_none" align="center">近用VA：${po.sopipclosevaod }</TD>
                        </TR>
						<TR>
						   <TD width="1%" height="26" class="table_body">OS:</TD>
			               <TD width="9%" class="table_none" align="center">球径：${po.sopipballglassos  }</TD>
			               <TD width="9%" class="table_none" align="center">柱径：${po.sopippostglassos }</TD>
			               <TD width="9%" class="table_none" align="center">轴向：${po.sopipaxesos }</TD>
			               <TD width="9%" class="table_none" align="center">ADD：${po.sopipaddos }</TD>
			               <TD width="9%" class="table_none" align="center">三棱镜：${po.sopiparriseglassos1 }</TD>
			               <TD width="9%" class="table_none" align="center">基底：${po.sopipbasisos1 }</TD>
						   <TD width="9%" class="table_none" align="center">远用瞳距：${po.sopipinterhighos  }</TD>
						   <TD width="9%" class="table_none" align="center">近用瞳距：${po.sopipinterdistanceos  }</TD>
						   <TD width="9%" class="table_none" align="center">瞳高：${po.sopippupilheightos }</TD>
						   <TD width="9%" class="table_none" align="center">远用VA：${po.sopipfarvaos }</TD>
						   <TD width="9%" class="table_none" align="center">近用VA：${po.sopipclosevaos }</TD>
                        </TR>
                        </table>
                        <br/>
                        
                        </c:if>
                        
                        <c:if test="${po.sopipglasstype == '4'}">
                        <br/>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR>
                           <TD width="6%" height="26" class="table_body">
                           	处方
                           </TD>
			               <TD class="table_none" width="40%" colspan="9">
                           	隐形
		 	               </TD>
                        </TR>
                    	<TR>
						   <TD width="1%" height="26" class="table_body">OD:</TD>
			               <TD width="9%" class="table_none" align="center">球径：${po.sopipballglassod  }</TD>
			               <TD width="9%" class="table_none" align="center">柱径：${po.sopippostglassod }</TD>
			               <TD width="9%" class="table_none" align="center">轴向：${po.sopipaxesod }</TD>
			               <TD width="9%" class="table_none" align="center">曲率1：${po.sopipeyecurvatureod1 }</TD>
			               <TD width="9%" class="table_none" align="center">曲率2 ：${po.sopipeyecurvatureod2 }</TD>
			               <TD width="9%" class="table_none" align="center">直径：${po.sopipdiameterod  }</TD>
						   <TD width="9%" class="table_none" align="center">隐形VA：${po.sopipconlenvaod  }</TD>
                        </TR>
						<TR>
						   <TD width="1%" height="26" class="table_body">OS:</TD>
			               <TD width="9%" class="table_none" align="center">球径：${po.sopipballglassos  }</TD>
			               <TD width="9%" class="table_none" align="center">柱径：${po.sopippostglassos }</TD>
			               <TD width="9%" class="table_none" align="center">轴向：${po.sopipaxesos }</TD>
			               <TD width="9%" class="table_none" align="center">曲率1：${po.sopipeyecurvatureos1 }</TD>
			               <TD width="9%" class="table_none" align="center">曲率2：${po.sopipeyecurvatureos2 }</TD>
						   <TD width="9%" class="table_none" align="center">直径：${po.sopipdiameteros  }</TD>
						   <TD width="9%" class="table_none" align="center">隐形VA：${po.sopipconlenvaos }</TD>
                        </TR>
                        </table>
                        <br/>
                        
                        </c:if>
                        
                        <c:if test="${po.sopipglasstype == '5'}">
                        <br/>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR>
                           <TD width="6%" height="26" class="table_body">
                           	处方
                           </TD>
			               <TD class="table_none" width="40%" colspan="9">
                           	中用
		 	               </TD>
                        </TR>
                    	<TR>
						   <TD width="12%" height="26" class="table_body">OD:</TD>
			               <TD width="11%" class="table_none" align="center">球径：${po.sopipballglassod  }</TD>
			               <TD width="11%" class="table_none" align="center">柱径：${po.sopippostglassod }</TD>
			               <TD width="11%" class="table_none" align="center">轴向：${po.sopipaxesod }</TD>
			               <TD width="12%" class="table_none" align="center">三棱镜：${po.sopiparriseglassod1 }</TD>
			               <TD width="12%" class="table_none" align="center">基底：${po.sopipbasisod1 }</TD>
						   <TD width="12%" class="table_none" align="center">中用瞳距：${po.sopipinterhighod }</TD>
						   <TD width="9%" class="table_none" align="center">瞳高：${po.sopippupilheightod }</TD>
						   <TD width="12%" class="table_none" align="center">远用VA：${po.sopipfarvaod }</TD>
                        </TR>
						<TR>
						   <TD width="12%" height="26" class="table_body">OS:</TD>
			               <TD width="11%" class="table_none" align="center">球径：${po.sopipballglassos  }</TD>
			               <TD width="11%" class="table_none" align="center">柱径：${po.sopippostglassos }</TD>
			               <TD width="11%" class="table_none" align="center">轴向：${po.sopipaxesos }</TD>
			               <TD width="12%" class="table_none" align="center">三棱镜：${po.sopiparriseglassos1 }</TD>
			               <TD width="12%" class="table_none" align="center">基底：${po.sopipbasisos1 }</TD>
						   <TD width="12%" class="table_none" align="center">中用瞳距：${po.sopipinterhighos }</TD>
						   <TD width="9%" class="table_none" align="center">瞳高：${po.sopippupilheightos }</TD>
						   <TD width="12%" class="table_none" align="center">远用VA：${po.sopipfarvaos }</TD>
                        </TR>
                        </table>
                        <br/>
                        
                        </c:if>
                        
                        </c:forEach>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
						<TR>
			               <TD class="table_none" height="26" colspan="8">
						   	<input icon='icon-save' type='button' value="确定" 
							onClick="save()">
						   </TD>
                        </TR>
                        </table>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
    
  </body>
</html>
