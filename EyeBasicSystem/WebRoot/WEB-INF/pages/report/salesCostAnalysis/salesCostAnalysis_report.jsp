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
	function search(){
	    var begindate = document.all.begintime.value;
	    var enddate = document.all.endtime.value;categoryid
	    var categoryid = $("[id=categoryid]:checked").val();
	    var supplierid = $("#supplierID").val();
	    var brandid = $("#brandID").val();
	    var goodsid = $("#goodsid").val();
	    var goodsname = $("#goodsname").val();
	    var departmentid = $("#departmentID").val();
	    var pricemin = $("#pricemin").val();
	    var pricemax = $("#pricemax").val();
	    var iszz = $("#iszz").val();
	    var whichcost = $("[id=whichcost]:checked").val();
	    var departmentname = EncodeUtf8($("input[id=bdpdepartmentname]").val());
	    var categoryname = EncodeUtf8($("[id=categoryid]:selected").text());
	    var suppliername = EncodeUtf8($("input[id=supplierName]").val());
	    var brandname = EncodeUtf8($("input[id=brandName]").val());
	    var goodsname = EncodeUtf8($("input[id=goodsname]").val());
	    var isShow = $("[id=isShow]:checked").val();
	    var showCompanyName = $("[id=showCompanyName]:checked").val();
	    
		if(begindate == "" || enddate == ""){
			alert('请选择日期');
			return false;
		}else{
			var DataURL = "report.action?reportlet=sales_salesCostAnalysis.cpt"+
							"&departmentid="+departmentid+
							"&begindate="+begindate+
							"&enddate="+enddate+
							"&categoryid="+categoryid+
							"&supplierid="+supplierid+
							"&brandid="+brandid+
							"&goodsid="+goodsid+
							"&goodsname="+goodsname+
							"&pricemin="+pricemin+
							"&pricemax="+pricemax+
							"&iszz="+iszz+
							"&departmentname="+departmentname+
							"&categoryname="+categoryname+
							"&suppliername="+suppliername+
							"&brandname="+brandname+
							"&goodsname="+goodsname+
							"&whichcost="+whichcost+
							"&isShow="+isShow+
							"&showCompanyName="+showCompanyName+
							"&__bypagesize__=false";                    
		    				
            window.open (DataURL,'商品库存成本统计表', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes'); 
		}
	}
	
	function clean(){
		$("[clean=clean]").val("");
		$("[id=whichcost][value=1]").attr("checked","checked");
		$("[id=categoryid][value=1]").attr("checked","checked");
	}
	
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var categoryid = $("[id=categoryid]:checked").val();
		var cid = $("#cid").val();
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+categoryid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+categoryid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		var categoryid = $("[id=categoryid]:checked").val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+categoryid+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+categoryid+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}

	$(document).ready(function() {
		$("input[type=radio]").eq(0).attr("checked","checked");
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () {
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });
    }); 
    
    /**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}
	
	function loadDepartmentids(cid) {  
		if(cid == ''){
			$("#departmentID").val('');
	   		$("#bdpdepartmentname").val('');
	   		$("#ds").val('');
	   		$("#dids").val('');
			$("#dnames").val('');
		}else{
			$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxDepartmentForCompanyID.action",          
	   	   	    async: true, 
	   	   	    data: "companysid="+cid+"&type=1",     
	   	   	    success: function(msg){
	   	   	    	var item = msg.split("/");
	                <c:if test="${person.departmenttype!=1}">
	                	$("#departmentID").val(item[0]);
	   	   	    		$("#bdpdepartmentname").val(item[1]);
	   	   	    		$("#ds").val(item[1]);
					$("#dids").val(item[0]);
					$("#dnames").val(item[1]);
					</c:if>  
	   	   	    }
			});
		}
    }
    
    function StringToDate()
	{ 
		var beg = Date.parse($("#begintime").val());
		
		var myDate = new Date(beg);
		if (isNaN(myDate))
		{
			var arys= $("#begintime").val().split('-');
			myDate = new Date(arys[0],--arys[1],arys[2]);
		}
		alert(myDate);
		return myDate;
	} 
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="button" onclick="StringToDate()"/>
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>决策分析类报表</TD>
            <TD align="left" width="45%">目前操作功能：商品库存成本统计表</TD>
            <TD align=right></TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      	<TR>
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none" colspan="5">
			                <c:if test="${person.personcompanytype eq '2'}">
			                	${person.personcompanyname }
	                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        </c:if>
	                        
	                        <c:if test="${person.personcompanytype ne '2'}">
	                        	<c:if test="${person.departmenttype!=1}">
							   		<select clean="clean" id="companysid" name="companysid" onchange="loadDepartmentids(this.options[this.options.selectedIndex].value)" >
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
		                              </s:iterator>
		                            </select>
								</c:if>
							    <c:if test="${person.departmenttype==1}">
		                            ${person.personcompanyname }
		                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        	</c:if>
	                        </c:if>
                           </TD>
                        </TR>
					  	<TR>
					  		<TD width="7%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="30%">
			               <c:if test="${person.departmenttype != 1}">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" clean=clean />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 240px' readonly="readonly" value="" clean=clean ></textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID" value="" clean=clean />
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
      	                   </c:if>
      	                   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID" />
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>
			               </TD>
			               <TD width="8%" height="30" class="table_body">查看日期</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
                            <input class="text_input100"
				               id="begintime"
						       name="begintime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endtime\')}'})"
						       MAXDATE="{readOnly:true, maxDate:'#F{document.getElementById(\'endtime\').value}'}" 
						       readonly="readonly" clean=clean />
						       至
					         <input class="text_input100"
						       id="endtime"
						       name="endtime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'begintime\')}'})"
						       MINDATE="#F{document.getElementById(\'begintime\').value}"
						       readonly="readonly" clean=clean />
						       
						   </li>
						   <li class="horizontal_onlyRight">
					  				  <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('begintime','endtime')"></li>
						   <li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_month_0.png" title="当月" onClick="currtMonth('begintime','endtime')"></li>
                            
			               </TD>
                        </TR>
                        <TR goods=goods>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
	      	                   <s:iterator value="goodsCategorys">
	      	                   <input type="radio" name="categoryid" onclick="showterm();" id ="categoryid" value="${bgcid}"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <tr>
                        <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" clean=clean type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" clean=clean name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();"></li>
			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text" clean=clean id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" clean=clean id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						 <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();"></li>
			               </TD>
			            </TR>
			            <TR>
			            	<TD class="table_body">品种代码</TD>
			               	<TD class="table_none">
						   		<input class="text_input160" type="text" clean=clean id="goodsid" name="goodsid" value="${requestScope.goodsid}">
			               	</TD>
			               	<TD class="table_body">品种名称</TD>
			               	<TD class="table_none">
						   		<input class="text_input160" type="text" clean=clean id="goodsname" name="goodsname" value="${goodsname}">
			               	</TD>
			               	<TD class="table_body">零售价</TD>
			               	<TD class="table_none">
						   		<input class="text_input80" type="text" clean=clean id="pricemin" name="pricemin" value="${pricemin}">--
						   		<input class="text_input80" type="text" clean=clean id="pricemax" name="pricemax" value="${pricemax}">
			               	</TD>
			            </TR>
			            <TR>
			            	<TD height="26" class="table_body">成本类别</TD>
			                <TD class="table_none">
	      	                   <input type="radio" name="whichcost" id ="whichcost" value="1" checked/>含税&nbsp;&nbsp;
	      	                   <input type="radio" name="whichcost" id ="whichcost" value="2"/>不含税&nbsp;&nbsp;
	      	                   <input type="radio" name="whichcost" id ="whichcost" value="3"/>加权&nbsp;&nbsp;
	      	                </TD>
			               	<TD class="table_body">是否显示自架</TD>
			               	<TD class="table_none" colspan="3">
			               		<SELECT id="iszz">
			               			<option value="0">不显示</option>
			               			<option value="1">显示</option>
			               		</SELECT>
			               	</TD>
			            </TR>
			            <TR>
			               <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="showCompanyName" name="showCompanyName" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName" name="showCompanyName" value="2"/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td>
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
							</td>
						</tr>
						<tr height="30">
							<td>
							<font color="red">此报表如果重新汇众数据，请在定时任务维护中对  '商品库存周转率'和'日销售商品明细' 重新汇总！</font>
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
