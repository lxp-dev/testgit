<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>条码打印</title>
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

	function batPrintGoodsBarCode(){
		if($("#addTable").find("tr").length < 2){
			alert("请选择打印品种！");
			return;
		}
	
		if(confirm("条码打印确认！")){
			createForm();
			
			var brandName=$("input[id=brandName]");
			var bspsuppliername=$("input[id=bspsuppliername]");
			var bbdplace=$("input[id=bbdplace]");
			var bbdunitname=$("input[id=bbdunitname]");
			var bgnreprice=$("input[id=bgnreprice]");
			var endreprice=$("input[id=endreprice]");
			
			var sqlstr = "";
			
			for(var i=0; i<$("input[id=brandName]").size(); i++){
				sqlstr = sqlstr +'select \'\''+  brandName.eq(i).val() +'\'\' as brandName,\'\''+ bspsuppliername.eq(i).val() +'\'\' as bspsuppliername,\'\''+ bbdplace.eq(i).val() +'\'\' as bbdplace,\'\''+ bbdunitname.eq(i).val() +'\'\' as bbdunitname,\'\''+ bgnreprice.eq(i).val() +'/'+ endreprice.eq(i).val() +'\'\' as price';
				if(i != $("input[id=brandName]").size() - 1){
					sqlstr = sqlstr + ' union all ';
				}
			}
			
			$("#hid").val('\''+sqlstr+'\'');
			
			$("input[name=sqlstr]").val('\''+sqlstr+'\'');
			var formAction = 'printbrandcard';
			var reportName = 'print_brandcard.cpt';
			
			DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
			queryReport(DataURL,formAction);
			
			document.getElementById('popupTitle').innerHTML="【商品标价签】";
		}
	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelPrintBrandOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelPrintBrandOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=$("input[id=chk]");
        var chks=$("#chks");
        var ischeck = chks.attr("checked");
        chk.each(function (){
        	$(this).attr("checked",ischeck);
        });
    }
    
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
	}
    
    function openGoodSingleValues(objValue){
		var brandPos = eval('(' + objValue + ')');
		for(var i = 0; i < brandPos.length; i++){	
			addRow(brandPos[i]);
		}
	}
	
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
		}
	}
     function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bbdid){
			   $(this).parent().parent().remove();	
           }
		});
    }
	
	function addRow(brandPo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == brandPo.bbdid) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + brandPo.bbdid + '" />';
        c2.innerHTML = brandPo.bbdid + '<input type="hidden" name="brandID" value="' + brandPo.bbdid +'" />';
        c3.innerHTML = brandPo.bbdbrandname + '<input type="hidden" id="brandName" name="brandName" value="' + brandPo.bbdbrandname +'" />';
		c4.innerHTML = brandPo.bspsuppliername + '<input type="hidden" id="bspsuppliername" name="bspsuppliername" value="' + brandPo.bspsuppliername +'" />';
		c5.innerHTML = brandPo.bbdplace + '<input type="hidden" id="bbdplace" name="bbdplace" value="' + brandPo.bbdplace +'" />';
		c6.innerHTML = brandPo.bbdunitname + '<input type="hidden" id="bbdunitname" name="bbdunitname" value="' + brandPo.bbdunitname +'" />';
		c7.innerHTML = '<input type="text" class="text_input60" maxlength="18" name="bgnreprice" id="bgnreprice"/>--<input type="text" class="text_input60" maxlength="18" name="endreprice" id="endreprice"/>';
    }

    function checkPrintNumber() {
        var flag = true;
        $("input[id=quantity]").each(function() {
            if(isNaN($(this).val()) || $(this).val() <= 0) {
                alert("请填写正确的打印数量!");
                flag = false;
                $(this).select();
                return flag;
            }
        });
        return flag;
    }
    
    function deleteitem(){
    	// 商品id去重
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		

				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}
		
		document.all.chks.checked = false;
		
    }
    
    function createForm(){
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";
		rptFrm.method = "post";
		
		var sqlstr = document.createElement("input");	     
	    sqlstr.type = "hidden";
	    sqlstr.name = "sqlstr";
	    sqlstr.value = '';
	    rptFrm.appendChild(sqlstr); 
	    
	    document.body.appendChild(rptFrm);
    }
    
    function queryReport(DataURL,formAction){
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			//rptFrm.removeEventListener("onsubmit");	
		}         

	    rptFrm.submit();  
	  
	    document.body.removeChild(rptFrm); 
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="printJQForm" method="post" action="">
<input type="hidden" id="hid" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：品种打印</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPrintBarcode.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">条码打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif
                      onclick="JavaScript:window.location.href='initPrintBrandBarcode.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">品种打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPrintJQ.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">价签打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品标价签打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                 	<table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="addGodos" src="${ctx}/img/newbtn/btn_addbrand_0.png" btn=btn title="添加品种"  onClick="javascript:openBrand();">
								<img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos" onClick="javascript:batPrintGoodsBarCode();">
								<img src="${ctx}/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
							</td>
						</tr>
					</table>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
                    
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="8%" height="30">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="10%" scope=col>品种代码</TH>
						  <TH width="20%" scope=col>品种</TH>						
                          <TH width="20%" scope=col>制造商</TH>
                          <TH width="10%" scope=col>产地</TH>
                          <TH width="10%" scope=col>单位</TH>
						  <TH scope=col>价签金额区间</TH>
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