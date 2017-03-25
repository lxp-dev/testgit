<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>商品退货管理</title>
</head>

<script>
	
	function save(){
	if(checkForm(document.all.returnMerchandiseManagementForm)){ 
		var table = document.getElementById('addTable');
		
		//判断商品数量是否为空	
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++){
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				return;	
			}
			goodsquantityCount++;
		}
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }

		//验证商品类别和制造商是否与添加商品一样
		var supplierID=document.all.cstisupplierid.value;
		var chk=document.getElementsByName("chk");
		var length = chk.length;
		
		var re = new RegExp();
		re.compile("^[1-9]\." + supplierID);
		for(i = 0; i < length; i++){
			if(!re.test(chk[i].value)){
				alert("制造商与添加的商品不匹配！");
				return;	
			}		
		}		
        
		$("img").removeAttr("onclick");
		returnMerchandiseManagementForm.action = "insertReturnMerchandiseManagement.action";
		returnMerchandiseManagementForm.submit();
		}
		
	}
	function openGoodSingle(){
		var supplierID= document.getElementById('cstisupplierid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		showPopWin("","initGoodsSingleSel.action?supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
		//initPriceAmount();
	}	

    
   function deleteitem(){
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		var count=0;
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
				count++; 
			}
			  
		}
		if(count==0){
          alert('请选择商品!');
          return false;
        }
		document.all.chks.checked = false;
    }
    
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		//showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 制造商开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstisupplierid').value = json.id;
		document.getElementById('cstisuppliername').value = json.value;
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
    
    /**
	*	设定价格调试各Input元素的变化属性；
	*	goodsquantityStateArray 	：商品数量数组；
	*	nottaxrateStateArray		：单位成本数组；
	*	nottaxrateamountStateArray 	：成本合计数组；
	*	taxrateStateArray 			：税率数组；
	*	costpriceStateArray 		：含税单价数组；
	*	costpriceamountStateArray 	：价税合计数组；		
	*	taxamountStateArray 		：税额合计数组；			
	*	例子：goodsquantityStateArray =new Array(arg0,arg1,arg2,arg3);
	*	arg0：当自动计算时，是否只读；true表示只读；false表示非只读；
	*	arg1：当自动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	*	arg2：当手动计算时，是否只读；true表示只读；false表示非只读；
	*	arg3：当手动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	**/
	
	function getInputState(){	
		var goodsquantityStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var nottaxrateStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var nottaxrateamountStateArray =new Array(true,"",false,"totalCount");
		var taxrateStateArray =new Array(true,"",false,"totalCount");
		var costpriceStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var costpriceamountStateArray =new Array(true,"",false,"totalCount");
		var taxamountStateArray =new Array(true,"",false,"totalCount");
		var stateArray=new Array(goodsquantityStateArray,nottaxrateStateArray,nottaxrateamountStateArray,taxrateStateArray,costpriceStateArray,costpriceamountStateArray,taxamountStateArray);
		return stateArray;
	}
	
    
    ////////////////////////////////
    	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		
		
		
		row.className = 'row';
		row.height="28";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = '<input type="text" class="text_input40"  name="goodsInfoTempPo.goodsquantity" onblur="amount();"  value="' + ((goodInfo.goodsquantity != "" && goodInfo.goodsquantity != null) ?  goodInfo.goodsquantity : "") + '" maxlength="18" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写订购商品数量！\'}, {\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写商品数量！\'}]"/>';
		$("input[name='goodsInfoTempPo\\.goodsquantity']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val(
				$(this).val().replace(/[^0-9.][0-9]*/g,'')
				);
			});	
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val(
					$(this).val().replace(/[^0-9.][0-9]*/g,'')
					);
				}else{
					$(this).val('');
				}
			});	
		});
    }
    
        function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(goodsI=0;goodsI<goodsquantity.length;goodsI++){
			if(goodsquantity[goodsI].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[goodsI].value))).toFixed(0);
		}	
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
 </script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="returnMerchandiseManagementForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="inventoryPo.cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品退货管理</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品退货新增</TD>
                      <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品退货新增</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

					</TR></TBODY></TABLE></TD>
					
					</TR>
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
						   <TD width="10%" height="30" class="table_body">单据编号</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input200"  type="text" id="cstibillid" name="cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly">
			               </TD>
			               <TD width="10%" height="30" class="table_body">单据日期</TD>
			               <TD class="table_none">
			               	 <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input name="cstibilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>
                        </TR>
						<TR>
			               <TD width="10%" height="30" class="table_body">所属制造商</TD>
			               <TD class="table_none">                             
			               	<li class="horizontal_onlyRight">
						   		<input id="cstisuppliername" class="text_input200" name="cstisuppliername"  readonly="readonly" />
						   		<input type="hidden" id="cstisupplierid" name="cstisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						    <input icon="icon-zoom" type=button value="选 择" onClick="openSupplier();"></li>
			               
			               </TD>
						   <TD width="10%" height="30" class="table_body">退货部门</TD>
			               <TD class="table_none">
                          	<select id="cstidepartmentid" name="cstidepartmentid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '退货部门不能为空！'}]">
      		                 	<option value="">请选择退货部门</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${inventoryPo.cstidepartmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
                        </TR>                        
                        <TR>
			               <TD width="10%" height="30" class="table_body">退货仓位</TD>
			               <TD class="table_none">                            
                          	<select id="cstiinstockid" name="cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '退货仓位不能为空！'}]">
      		                 	<option value="">请选退货仓位</option>
                             	<c:if test="${not empty(warehouselist)}">
				               	  <s:iterator value="warehouselist">
                    	           <OPTION value="${bwhid}" ${'yybhgpc'!= bwhid  ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD width="10%" height="30" class="table_body">制单人</TD>
			               <TD class="table_none">${person.personName }<input class="text_input100" type="hidden" name="csticreateperson" value="${person.id }"></TD>
                        </TR>
                         <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=3>
                            <textarea name="cstiremark" id="cstiremark" ></textarea>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
<!--                          <td width="20%">-->
<!--	                          <input name="radiobutton" id="autoCount" type="radio" value="autoCount" checked="checked" onClick="changeRadioType(this,getInputState())"/>自动计算-->
<!--	  				  		  <input type="radio" id="notAutoCount" name="radiobutton" value="notAutoCount" onClick="changeRadioType(this,getInputState())"/>手动计算-->
<!--	  				  	  </td>-->
                          <TD align="left" width="80%">
						  <input icon='icon-edit' type='button' value="商品添加" 
						  onClick="javascript:openGoodSingle();">
                          <input id="del" icon="icon-delete" type="button" value="商品删除" onClick="deleteitem();" ></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="5%">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="7%">成本合计</TH>
                          <TH width="12%" scope=col>数量</TH>      
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="30"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal" name="goodsquantityTotal">0</TH>
				   		</TR>
                      </TBODY>
                    </TABLE>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left"><input type="checkbox" id="cstiauditstate" name="cstiauditstate" value="1">保存并审核</TD>
					   </TR>
					   <TR>
						  <TD align="left"><input id="submitButton" icon='icon-save' type='button' value='保存' onClick="save()">
						  </TD>
                        </TR>                     
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