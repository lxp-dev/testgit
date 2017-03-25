<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表中心</title>
</head>
<script>	
   
	function clean(){
		goodsForm.reset();
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

    function save(){
		if(checkForm(goodsForm)){
			$("img").removeAttr("onclick");
			goodsForm.action = "preShopSalesUpdate.action";
			goodsForm.submit();
		}
    }
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	 <TD width="10%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="30%">${preShopSalesPo.ssepsshopcodename }&nbsp;
			                   <input class="text_input80" clean=clean id="ssepsid" name="preShopSalesPo.ssepsid" type="hidden" value="${preShopSalesPo.ssepsid }"/>
			                   <input class="text_input80" clean=clean id="ssepsshopcode" name="preShopSalesPo.ssepsshopcode" type="hidden" value="${preShopSalesPo.ssepsshopcode }"/>
			               </TD>
			               <TD width="10%" height="26" class="table_body">任务年月</TD>
			               <TD class="table_none" width="20%" >${preShopSalesPo.ssepsprebgndate }&nbsp;至${preShopSalesPo.ssepspreenddate }</TD>
			               <TD width="10%" class="table_body">计划金额</TD>
			               <TD class="table_none"  width="40%">
                                <input class="text_input80" clean=clean id="salesprice" name="preShopSalesPo.ssepssalesprice" type="text" value="${preShopSalesPo.ssepssalesprice }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写计划金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写计划金额！'}]" onblur="if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"/>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();" >
								<img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='清空' onClick="clean()">
							</td>
						</tr>
					</table>
                   
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
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
