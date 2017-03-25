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
<script type="text/javascript" charset="gb2312">  
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function openGoodSingle(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelBP.action?categoryID_open=" + '' + "&supplierID_open=" + '' ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelBP.action?categoryID_open=" + '' + "&supplierID_open=" + '' ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){	
			addRow(goodInfos[i]);
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
         	if($(this).val()== goodInfo.bgigoodsid){
			   	$(this).parent().parent().remove();	
            }
		});
    }
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		// 商品id去重
		var chk=document.getElementsByName("chk");
		/*for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
		}*/
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgipcbarcode + '" />';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="guaranteeperiod" name="guaranteeperiod" value="' + goodInfo.guaranteeperiod +'" /><input type="hidden" id="batch" name="batch" value="' + goodInfo.batch +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="goodsname" name="goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgibrandname + '<input type="hidden" id="brandname" name="brandname" value="' + goodInfo.bgibrandname +'" />';
		c5.innerHTML = goodInfo.bgisource + '<input type="hidden" id="source" name="source" value="' + goodInfo.bgisource +'" />';
		c6.innerHTML = goodInfo.bgispec + '<input type="hidden" id="spec" name="spec" value="' + goodInfo.bgispec +'" />';
		c7.innerHTML = goodInfo.bgicolor + '<input type="hidden" id="color" name="color" value="' + goodInfo.bgicolor +'" />';
		c8.innerHTML = goodInfo.bgiretailprice + '<input type="hidden" id="retailprice" name="retailprice" value="' + goodInfo.bgiretailprice +'" />';
		c9.innerHTML = goodInfo.bgiunitname + '<input type="hidden" name="unitname" value="' + goodInfo.bgiunitname +'" />';
		c10.innerHTML = goodInfo.bgipcbarcode + '<input type="hidden" class="text_input200" name="goodsBarcode" id="pcbarcode" value="' + goodInfo.bgipcbarcode +'" />';
		c11.innerHTML = '<input type="text" class="text_input60" maxlength="5" name="quantity" id="quantity" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写打印数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'打印数量应为整数！\'}]" onKeyUp="value=value.replace(/[^\\d]/g, \'\')" />';
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
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
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
    
    //条码批量打印
	function batPrintGoodsBarCode(){
		if(checkPrintNumber()) {
			if(confirm("条码打印确认！")){
				var persons = $("input[id=person]");
				var barCodes = $("input[id=pcbarcode]");
				var goodsQuantitys = $("input[id=quantity]");
				var brandnames = $("input[id=brandname]");
				var sources = $("input[id=source]");
				var specs = $("input[id=spec]");
				var colors = $("input[id=color]");
				var retailprices = $("input[id=retailprice]");
				var guaranteeperiods = $("input[id=guaranteeperiod]");
				var batchs = $("input[id=batch]");
				
				var suffix;
				var barCount = 0;
				
				var barCode = new Array();
				var quantity = new Array();
				var brandname = new Array();
				var source = new Array();
				var spec = new Array();
				var color = new Array();
				var retailprice = new Array();
				var person = new Array();
				var guaranteeperiod = new Array();
				var batch = new Array();
				
				for(var i=0 ; i< barCodes.length; i++){
					person[person.length] = persons.val();
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					brandname[brandname.length] = brandnames[i].value;
					
					source[source.length] = sources[i].value;
					spec[spec.length] = specs[i].value;
					color[color.length] = colors[i].value;
					retailprice[retailprice.length] = retailprices[i].value;
					guaranteeperiod[guaranteeperiod.length] = guaranteeperiods[i].value;
					batch[batch.length] = batchs[i].value;
					/*alert(persons[0].value);
					alert(barCodes[i].value);
					alert(goodsQuantitys[i].value);
					alert(brandnames[i].value);
					alert(sources[i].value);
					alert(colors[i].value);
					alert(retailprices[i].value);*/
				}
				var printtype = {"1":"${systemParameterPo.fspframebarcodetype}"
								 ,"2":"${systemParameterPo.fsppartsbarcodetype}"
								 ,"3":"${systemParameterPo.fspglassbarcodetype}"
								 ,"4":"${systemParameterPo.fspstealthbarcodetype}"
								 ,"5":"${systemParameterPo.fspsolutionbarcodetype}"
								 ,"6":"${systemParameterPo.fspsunglassesbarcodetype}"
								 ,"7":"${systemParameterPo.fspconsumebarcodetype}"
								 ,"8":"${systemParameterPo.fspoldglassesbarcodetype}"
								 ,"9":"${systemParameterPo.fspmetropiabarcodetype}"};
				//alert(guaranteeperiod+"+++"+batch);
				try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,guaranteeperiod,batch);
				} catch(e) {
					alert("打印失败!请检查条码打印机是否已正确连接!");
				}
			}
		}
	}	
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="person" id="person" value="${person.id }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left" ><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：条码打印</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">条码打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPrintJQcqjy.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">商品标价签打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background='${ctx}/img/pic/tab_bg.gif'><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                 <table id="title2" cellspacing="2">
						<tr>
							<td>
							<img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="添加商品" onClick="javascript:openGoodSingle();">
			 				<img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos" onClick="javascript:batPrintGoodsBarCode();">
							<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
			
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
                    
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="6%" height="30">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH scope=col width="10%">商品代码</TH>
						  <TH scope=col width="14%">商品名称</TH>
                          <TH scope=col width="14%">商品品种</TH>
                          <th width="10%" scope=col>产地</th>
                          <TH scope=col width="6%">型号</TH>
                          <TH scope=col width="5%">色号</TH>
                          <TH scope=col width="7%">零售价</TH>
                          <TH scope=col width="5%">单位</TH>
                          <TH scope=col width="13%">商品条码</TH>
                          <TH scope=col width="6%">打印数量</TH>
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