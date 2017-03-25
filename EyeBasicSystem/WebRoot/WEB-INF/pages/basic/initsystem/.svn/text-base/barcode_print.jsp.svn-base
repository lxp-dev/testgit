<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>打印商品条码</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
	    return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	//条码批量打印
	function batPrintGoodsBarCode(){
		var flag = false;
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[id=pcbarcode]");
			var goodsQuantitys = $("input[id=quantity]");
			var goodsnames = $("input[id=goodsname]");
			var brandnames = $("input[id=bgibrandname]");
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
			var goodsname = new Array();
			var brandname = new Array();
			var source = new Array();
			var spec = new Array();
			var color = new Array();
			var retailprice = new Array();
			var person = new Array();
			var guaranteeperiod = new Array();
			var batch = new Array();
			
			for(var i=0 ; i< barCodes.length; i++){
				if(ids[i].checked == true){
					person[person.length] = persons[0].value;
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					
					goodsname[goodsname.length] = goodsnames[i].value;
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
					alert(goodsnames[i].value);
					alert(sources[i].value);
					alert(colors[i].value);
					alert(retailprices[i].value);*/
					
					flag = true;
				}
			}
			
			if(flag == false){
				alert("请钩选要打印的商品条码！");
			}else{
				var barCodeList = '';
				for (var i=0 ; i< barCode.length; i++){
				    barCodeList = barCodeList + barCode[i] + ',';
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
				try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,guaranteeperiod,batch);
					printBarCodeFrm.action = "barCodePrint.action?moduleID=${moduleID}&bgiwarehouseid="+$('#bgiwarehouseid').val()+"&barCodeList="+barCodeList;
			  	    printBarCodeFrm.submit();
				} catch(e) {
					alert("打印失败!请检查条码打印机是否正确连接!");
					return;
				}
			}
		}	
	}		
	
	/**
	 *  调用普通打印机打印商品条码
	 */	
	function printBarCodeByWindow(){
    	var ids = document.getElementsByName("chk");
		if(ids){
			var barCodes = document.getElementsByName("goodsInfoTempPo.pcbarcode");
			var goodsQuantitys = document.getElementsByName("goodsInfoTempPo.goodsquantity");
			
			var barCode = new Array();
			var quantity = new Array();
			for(var i=0 ; i< ids.length; i++){
				if(ids[i].checked == true){					
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
				}
			}
			
			var barCodeList = '';
			for (var i=0 ; i< barCode.length; i++){
			    barCodeList = barCodeList + barCode[i] + ',';
			}
						
            window.print();

			printBarCodeFrm.action = "barCodePrint.action?moduleID=${moduleID}&bgiwarehouseid="+$('#bgiwarehouseid').val()+"&barCodeList="+barCodeList;
	  	    printBarCodeFrm.submit();
		}
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

	    $('input[type=text]').bind('blur',function(){
	        $(this).val($.trim($(this).val()));
	    });
    }); 

	function search(){
		$("img").removeAttr("onclick");
		printBarCodeFrm.action = "initBarCodePrint.action";
		printBarCodeFrm.submit();		
		showLoadingBar();
	}

	function clean(){
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsName').value = "";
		$("#isprint").val("0");
		$("input[name=bgnDate]").val("");
		$("input[name=endDate]").val("");
		$("#goodscategoryID").val("");
	}
	
	function selectWhichretail(){
		printBarCodeFrm.action = "initBarCodePrint.action";
		printBarCodeFrm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="printBarCodeFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="bgiwarehouseid" name="bgiwarehouseid" value="${bgiwarehouseid}">
<input type="hidden" id="person" value="${person.id }"/>
<span id='div1'></span>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR height="20px">
          <TD></TD>
        </TR>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
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
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                           <li class="horizontal_onlyRight">
                          	  <select id="whichretail" name="whichretail" onchange="selectWhichretail()">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${whichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${whichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${whichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${whichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${whichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${whichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${whichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${whichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${whichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${whichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select> 
	                      	  </li>
	                      	  <li class="horizontal_onlyRight">
						   		<img btn=btn id="addGodos" src="${ctx }/img/newbtn/btn_printbarcode_0.png" title='打印条码' onclick="javascript:batPrintGoodsBarCode();" >	
                         	  </li>
                         </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <div id="div_goodslist">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <tr>
                        	<TD width="9%" height="26" class="table_body">商品类别</TD>
			                <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID"}>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                    </select>
			                </TD>
							<TD  height="26" class="table_body">商品代码</TD>
                          	<TD class="table_none"><input type="text" clean=clean class="text_input160" id="goodsID" name="goodsID" value="${goodsID }" maxlength="30"></TD>
							<TD  height="26" class="table_body">商品名称</TD>
                          	<TD class="table_none"><input type="text" clean=clean class="text_input160" id="goodsName" name="goodsName" value="${goodsName }" maxlength="100"></TD>
						</tr>
						<TR>
                          <TD height="26" class="table_body">导入时间</TD>
                          <TD class="table_none" colspan="3">
                          <li class="horizontal_onlyRight">
                          <input class="text_input100" clean=clean
				               id="startTime"
						       name="bgnDate" value="${requestScope.bgnDate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100" clean=clean
						       id="endTime"
						       name="endDate" value="${requestScope.endDate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
						       
						 </li><li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startTime','endTime')"></li>
                          <li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('startTime','endTime')"></li>    
						 </TD>
						 <TD  height="26" class="table_body">打印状态</TD>
                          	<TD class="table_none"><select id="isprint" name="isprint">
                          		<option value="0" ${isprint == '0' ? 'selected="selected"':'' }>未打印</option>
                          		<option value="1" ${isprint == '1' ? 'selected="selected"':'' }>已打印</option>
                          	</select></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							  <td>
								  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" />
								  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" />
							  </td>
						</tr>
					</table>
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<table id="loadingBar" width="100%" STYLE="display:none">
				  <tr><td height="10">&nbsp;</td></tr>
				  <tr>                         
				    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
				    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
					<script>
						function showLoadingBar(){
							gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
							document.getElementById("loadingBar").style.display="";
						}
					</script>                            
				    </td>
				</tr>
				</table>                      
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
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
		                            <TR class=table_title align=middle height="26">
		                              <TH width="5%" scope=col>选择<input type="checkbox" id="chks" onclick="chkAll()"></TH>
			                          <TH width="15%" scope=col>商品代码</TH>
			                          <TH width="20%" scope=col>商品名称</TH>
			                          <TH width="10%" scope=col>${whichretailname}</TH>
			                          <TH width="20%" scope=col>商品条码</TH>
			                          <TH width="15%" scope=col>仓位名称</TH>
			                          <TH width="10%" scope=col>打印数量</TH>
			                        </TR>
		                        <s:iterator value="goodsInfoList">
		                           	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                          <TD  height="26"><input id="chk" name="chk" type="checkbox" value="${bgigoodsid}" ></TD>
			                          <TD>${bgigoodsid}</TD>
			                          <TD>${bgigoodsname}
			                          <input type="hidden" id="goodsname" value="${bgigoodsname }" >
			                          <input type="hidden" id="bgibrandname" value="${bgibrandname }" >
			                          <input type="hidden" id="source" value="${bgisource }" >
			                          <input type="hidden" id="spec" value="${bgispec }" >
			                          <input type="hidden" id="color" value="${bgicolor }" >
			                          <input type="hidden" id="guaranteeperiod" value="${guaranteeperiod }" >
			                          <input type="hidden" id="batch" value="${batch }" >
			                          </TD>
			                          <TD>${bgiretailprice }<input type="hidden" id="retailprice" value="${bgiretailprice }" ></TD>
			                          <TD>${bgigoodsbarcode}<input type="hidden" id="pcbarcode" name="goodsInfoTempPo.pcbarcode" value="${bgigoodsbarcode}" ></TD>
			                          <TD>${bgiwarehousename}</TD>
			                          <TD>${isprint == '' || isprint == '0' ? bgigoodsquantity : '' }<input ${isprint == '' || isprint == '0' ? 'type="hidden"': 'type="text"' } id="quantity" onKeyUp="value=value.replace(/[^\d]/g,'')" name="goodsInfoTempPo.goodsquantity" class="text_input60" value="${bgigoodsquantity}" ></TD>
			                        </TR>
			                    </s:iterator>                       
                      </TBODY>
                    </TABLE>
                    </div>
	              <c:if test="${not empty(goodsInfoList)}">
                     <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					 <!-- END 分页 -->
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
<%@ include file="/WEB-INF/inc/message.jsp" %>