<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存预警设置</title>
</head>
<script>
	function save(){
		if(checkForm(document.all.stockAlertSettingForm)){  
			var bgistorageupperlimit=parseInt(document.getElementById('bgistorageupperlimit').value);
			var bgistoragelowerlimit=parseInt(document.getElementById('bgistoragelowerlimit').value);
			var bgistorageredlimit=parseInt(document.getElementById('bgistorageredlimit').value);
	
		    if(bgistoragelowerlimit>bgistorageupperlimit){
		      alert('库存下限不能大于库存上限');
		      document.all.bgistorageupperlimit.focus();
		      return false;
		    } 
		    
		    if(bgistorageredlimit>bgistoragelowerlimit){
		      alert('红色预警不能大于库存下限');
		      document.all.bgistorageredlimit.focus();
		      return false;
		    }
	
		    $("img").removeAttr("onclick");
			stockAlertSettingForm.action = "stockAlertSettingBatchUpt.action";
			stockAlertSettingForm.submit();
		}
	}
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
    
    function clean(){
        $('#bgistorageupperlimit').val('');
        $('#bgistoragelowerlimit').val('');
        $('#bgistorageredlimit').val('');
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="stockAlertSettingForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="alertSettingPo.csasaid" value="${billID }">

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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
			            <TR>
						   <TD width="12%" height="30" class="table_body">库存上限</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistorageupperlimit" name="alertSettingPo.csasastockcap" value="${alertSettingPo.csasastockcap }"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '库存上限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '库存上限应为整数！'}]">
			               </TD>
			               <TD width="12%" height="30" class="table_body">库存下限</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistoragelowerlimit" name="alertSettingPo.csasastocklower"  value="${alertSettingPo.csasastocklower }"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '库存下限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '库存下限应为整数！'}]">
			               </TD>
			               <TD height="26" class="table_body">红色预警</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistorageredlimit" name="alertSettingPo.csasastockred" 
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '红色预警不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '红色预警应为整数！'}]">
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img btn=btn src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onClick="clean()" > 
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
<script>
	if(document.all.bgisph!=null){
		var index_bgisph = 0;
		var arr = document.all.bgisph.options.length;
		for(i=0;i<arr;i++){
			if(document.all.bgisph.options.options[i].value == '<c:out value="${goodsInfoPo.bgisph}"/>'){
				document.all.bgisph.options.selectedIndex = index_bgisph;
				break;
			}
			index_bgisph++;
		}
	}
</script>