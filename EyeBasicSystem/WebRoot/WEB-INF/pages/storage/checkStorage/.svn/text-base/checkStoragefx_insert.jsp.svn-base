<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘点管理</title>
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

	function save(){
	  if(checkForm(document.all.checkStorageForm)){
	    $("img").removeAttr("onclick");
		checkStorageForm.action = "checkStoragefxInsert.action";
		checkStorageForm.submit();
	  }
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="checkStorageForm" method="post" action="" >
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID }"> 

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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
					<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">盘点单号</TD>
                          <TD width="24%" class="table_none">&nbsp;${checkStoragePo.cshcsbillid}<input type="hidden" name="checkStoragefxPo.cshcsbillid" readonly="readonly" value="${checkStoragePo.cshcsbillid}"></TD>
                          <TD width="9%" class="table_body">制单日期</TD>
                          <TD width="24%" class="table_none">&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /></TD>
                          <TD width="9%" class="table_body">单据名称</TD>
						  <TD height="26" align="left" class="table_none">&nbsp;<input  class="text_input200"  name ="checkStoragefxPo.cshcscheckname" value="${checkStoragePo.cshcscheckname}" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写单据名称！'}]"></TD>
      	                </TR>
                        <TR> 
                          <TD class="table_body">仓位</TD>
						  <TD height="26" align="left" class="table_none">&nbsp;${checkStoragePo.cshcsstockname}<input type="hidden" name="checkStoragefxPo.cshcsstockname" value="${checkStoragePo.cshcsstockname}">
						   <input type="hidden" name="checkStoragefxPo.cshcsstockid" value="${checkStoragePo.cshcsstockid}">
						  </TD>
                          <TD class="table_body" height="26">制单人</TD> 
                          <TD class="table_none" colspan="3">&nbsp;${person.personName }<input type="hidden" name="checkStoragefxPo.cshcscheckstockperson" value="${person.id }"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
					   <TR>
						  <TD align="left"><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();"></TD>
                        </TR>                     
                    </TABLE>
                    <c:if test="${not empty(checkStorageEntrys)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH height="26" width="8%" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="6%" scope=col>规格</TH>
						  <TH width="8%" scope=col>盘盈数量</TH>
						  <TH width="8%" scope=col>盘亏数量</TH>
						  <TH width="15%" scope=col>盈亏金额</TH>
						  <TH width="15%" scope=col>原因分析</TH>
						  <TH width="15%" scope=col>建议解决方案</TH>
                        </TR>
                        <c:set value="0" var="booknumber" scope="page" />
                        <c:set value="0" var="checknumber" scope="page" />
                        <c:set value="0.00" var="surplusnumber" scope="page" />
                        
                        <c:forEach var="po" items="${checkStorageEntrys}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${po.cshcsegoodsid }<input type="hidden" name="checkStorageEntryfxTempPo.cshcsefxtgoodsid" value="${po.cshcsegoodsid}"></TD>
						  <td>${po.cshcsegoodsname }<input type="hidden" name="checkStorageEntryfxTempPo.cshcsefxtgoodsname" value="${po.cshcsegoodsname}"></td>
						  <td>${po.cshcseunitname }<input type="hidden" name="checkStorageEntryfxTempPo.cshcsefxtunitname" value="${po.cshcseunitname}"></td>
                           <TD>${po.cshcsebooknumber}<c:set value="${booknumber+po.cshcsebooknumber}" var="booknumber" scope="page" /><input type="hidden" name="checkStorageEntryfxTempPo.cshcsefxtbooknumber" value="${po.cshcsebooknumber}"></TD>
                          <TD>${po.cshcsechecknumber}<c:set value="${checknumber+po.cshcsechecknumber}" var="checknumber" scope="page" /><input type="hidden" name="checkStorageEntryfxTempPo.cshcsefxtchecknumber" value="${po.cshcsechecknumber}"></TD>                         
                          <TD>${po.cshcsecostPrice}<c:set value="${surplusnumber+po.cshcsecostPrice}" var="surplusnumber" scope="page" /><input type="hidden" name="checkStorageEntryfxTempPo.cshcsefxtcostPrice" value="${po.cshcsecostPrice}"></TD>
                          <td><input class="text_input200" id="cshcsefxtreason" name="checkStorageEntryfxTempPo.cshcsefxtreason" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写原因分析！'}]"></td>
                          <td><input class="text_input200" id="cshcsefxtsolve" name="checkStorageEntryfxTempPo.cshcsefxtsolve" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写建议解决方案！'}]"></td>
                        </TR>
                        </c:forEach>
                        <TR class=table_title align=middle>
                          <TH height="26"  scope=col></TH>
                          <TH  scope=col></TH>
                          <TH scope=col>合计:</TH>
                          <TH >${booknumber}</TH>
						  <TH >${checknumber}</TH>                          
                          <TH  scope=col><fmt:formatNumber value="${surplusnumber}" pattern="0.00"/></TH>
                          <TH  scope=col></TH>
                          <TH  scope=col></TH>
                        </TR>
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
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
