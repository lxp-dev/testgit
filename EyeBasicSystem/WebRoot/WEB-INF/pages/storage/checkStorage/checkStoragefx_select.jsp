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
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 

    function storagefxSel(id){
        var DataURL = "report.action?reportlet=checkStoragefxSelRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&billID="+id;
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
        if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
        document.getElementById('popupTitle').innerHTML="【盈亏分析表】";
    }

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="checkStorageForm" method="post" action="" enctype ="multipart/form-data">
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }"> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20">
          <TD align="right" colspan="3">
             <img src="${ctx }/img/newbtn/btn_print_0.png" btn=btn title="打印单据" onClick="storagefxSel('${checkStoragefxPo.cshcsbillid }');">
          </TD>
        </tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                          <TD width="10%" class="table_body" height="30">盘点单号</TD>
                          <TD width="40%" class="table_none">&nbsp;${checkStoragefxPo.cshcsbillid}</TD>
                          <TD width="10%" class="table_body">制单日期</TD>
                          <TD width="40%" class="table_none">&nbsp;${fn:substring(checkStoragefxPo.cshcscheckdate,0,10)}</TD>
					    </TR>
                        <TR>
                          <TD class="table_body">单据名称</TD>
						   <TD height="30" align="left" class="table_none">&nbsp;${checkStoragefxPo.cshcscheckname}</TD>
						   <TD class="table_body">仓位</TD>
						   <TD height="30" align="left" class="table_none">&nbsp;${checkStoragefxPo.cshcsstockname }</TD>
      	                </TR>
                        <TR> 
                          <TD class="table_body" height="30">制单人</TD> 
                          <TD class="table_none" colspan="3">&nbsp;${person.personName }</TD>
                        </TR>
                      </TBODY>
                    </TABLE>

                    <c:if test="${not empty(checkStoragefxEntryList)}">
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
                          <TH height="30" width="8%" scope=col>商品代码</TH>
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
                        
                        <c:forEach var="po" items="${checkStoragefxEntryList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="30">${po.cshcsegoodsid}</TD>
						  <td>${po.cshcsegoodsname}</td>
						  <td>${po.cshcseunitname }</td> 
                          <TD>${po.cshcsebooknumber}<c:set value="${booknumber+po.cshcsebooknumber}" var="booknumber" scope="page" /></TD>
                          <TD>${po.cshcsechecknumber}<c:set value="${checknumber+po.cshcsechecknumber}" var="checknumber" scope="page" /></TD>
                          <TD>${po.cshcsecostPrice}<c:set value="${surplusnumber+po.cshcsecostPrice}" var="surplusnumber" scope="page" /></TD>
                          <td>${po.cshcsereason}</td>
                          <td>${po.cshcsesolve}</td>
                        </TR>
                        </c:forEach>
                        <TR class=table_title align=middle>
                          <TH height="30"  scope=col></TH>
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
