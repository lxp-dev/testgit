<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品条码批号设置</title>
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
		if(checkForm(MaxDiscountFrm)){		   
			$("img").removeAttr("onclick");
			MaxDiscountFrm.action = "updateBarCodeSet.action";
		    MaxDiscountFrm.submit();
		}
	}
	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
	}



</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="MaxDiscountFrm" method="post" action="">
<input type="hidden" name="hid">
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none"> ${barCodeSetPo.fbcsgoodscategoryname}<input type="hidden" id="fbcsid" class="text_input160" name="barCodeSetPo.fbcsid" value="${barCodeSetPo.fbcsid }" maxlength="50"/>
                               <input type="hidden" id="fbcsgoodscategoryid" class="text_input160" name="barCodeSetPo.fbcsgoodscategoryid" value="${barCodeSetPo.fbcsgoodscategoryid }" maxlength="50"/>
                               <input type="hidden" id="fbcssuppliername" class="text_input160" name="barCodeSetPo.fbcssuppliername" value="${barCodeSetPo.fbcssuppliername }" maxlength="50"/>
                               <input type="hidden" id="fbcssupplierid" class="text_input160" name="barCodeSetPo.fbcssupplierid" value="${barCodeSetPo.fbcssupplierid }" maxlength="50"/>
                               <input type="hidden" id="fbcsbrandname" class="text_input160" name="barCodeSetPo.fbcsbrandname" value="${barCodeSetPo.fbcsbrandname }" maxlength="50"/>
                               <input type="hidden" id="fbcsbrandid" class="text_input160" name="barCodeSetPofbcsbrandid" value="${barCodeSetPo.fbcsbrandid }" maxlength="50"/>
                               <input type="hidden" id="fbcsgoodsname" class="text_input160" name="barCodeSetPo.fbcsgoodsname" value="${barCodeSetPo.fbcsgoodsname}" maxlength="50"/>
                               <input type="hidden" id="fbcsgoodsid" class="text_input160" name="barCodeSetPo.fbcsgoodsid" value="${barCodeSetPo.fbcsgoodsid}" maxlength="50"/>
                               <input type="hidden" id="fbcsgoodscategoryname" class="text_input160" name="barCodeSetPo.fbcsgoodscategoryname" value="${barCodeSetPo.fbcsgoodscategoryname}" maxlength="50"/>
						   
							  	
                              </TD>
						   <TD width="9%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   		${barCodeSetPo.fbcssuppliername }
						   </TD>
						    <TD class="table_body" width="9%">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
                                 ${barCodeSetPo.fbcsbrandname}
			               </TD>
                        </tr>
                        <tr>
                          
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="5">
                           <li class="horizontal_onlyRight">
                                 ${barCodeSetPo.fbcsgoodsname}
			               </TD>

                        </tr>
                        <tr>
                           <TD class="table_body" height="62">商品条码批号设置</TD>
			               <TD class="table_none" colspan="5">
			               <input type="radio" id="fbcsbarcodeflag" name="barCodeSetPo.fbcsbarcodeflag" value="1" checked="checked">按入库时间设置商品条码批号
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
                        <s:iterator value="maxDiscountDetailsPos">
                        <TR>
					       <TD height="26" class="table_body" width="8%">商品级别</TD>
			              <td align="left" class="table_none" width="23%">
				               	<input type="hidden" value="${fbcsdgoodslevel}" name="maxDiscountDetailsPo.fbcsdgoodslevels">${fbcsdgoodslevelname}
                          </td>
                          <TD height="26" class="table_body" width="8%">折扣率</TD>
			              <td align="left" class="table_none">
				               	<input type="text" class="text_input100" value="${fbcsddiscount }" name="maxDiscountDetailsPo.fbcsddiscounts" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写折扣！'}]">
                          </td>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="document.MaxDiscountFrm.reset();">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>