<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物资再利用</title>
</head>
<script>	
	
	
	function save(){
		if(checkForm(goodsImgLeaveMsgFrm)){
			
			$("img").removeAttr("onclick");
			goodsImgLeaveMsgFrm.action = "insertGoodsImgLeaveMsgWord.action";
			goodsImgLeaveMsgFrm.submit();
		}
	}

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
	});

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsImgLeaveMsgFrm" method="post" action="">
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
						  <TD width="10%" height="26" class="table_body">商品名称</TD>
                          <TD width="90%" class="table_none">
                          	${goodsImgLeaveMsgPo.cmrlmGoodsName }&nbsp;
						  </TD>
						</TR> 
						<TR>
						  <TD width="10%" height="62" class="table_body">内容简介</TD>
                          <TD width="90%" class="table_none">
                          	${goodsImgLeaveMsgPo.cmrlmGoodsContent }&nbsp;
						  </TD>
						</TR>
						<TR>
						  <TD width="10%" height="62" class="table_body">商品图片</TD>
                          <TD width="90%" class="table_none">
                             <c:if test="${not empty(goodsImgLeaveMsgPo.cmrlmPicUrl) && goodsImgLeaveMsgPo.cmrlmPicUrl ne ''}">
                                 <img src="${ctx}/goodsimgleavemsg/img/${goodsImgLeaveMsgPo.cmrlmPicUrl }" border="0">
                             </c:if>
                             <c:if test="${empty(goodsImgLeaveMsgPo.cmrlmPicUrl) && goodsImgLeaveMsgPo.cmrlmPicUrl eq ''}">
                                                                                       暂无图片
                             </c:if>
						  </TD>
						</TR>                       
						<TR>
						  <TD width="10%" height="30" class="table_body">留言</TD>
                          <TD width="90%" class="table_none">
                          	<textarea id="goodsContent" name="goodsImgLeaveMsgPo.cmrlmecontent" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [1000]}, 'Message' : '留言不能过多!'}]"></textarea>
                          	<input type="hidden" class="text_input240" name="goodsImgLeaveMsgPo.cmrlmemrid" value="${goodsImgLeaveMsgPo.cmrlmid}">
						  </TD>
						</TR>
					
                      </TBODY>
                    </TABLE>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
							  
                          </TD>
                        </TR>
                      </TBODY>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
