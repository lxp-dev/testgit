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
	$(document).ready(function() {
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        }); 

        changeSalesType();
        changeselect('1');
        
        if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	}); 

	function search(){
		if(checkForm(goodsForm)){
			
			if(!is_iPad()){
				createForm();
			}
			
			var ShopCode = $('#departmentID').val();
			if(ShopCode == ''){
				ShopCode = $("#dids").val();
			}
			
			var BeginDate = document.getElementById("startTime").value;
			var End = document.getElementById("endTime").value;
			var goodsCategoryID = document.getElementById('goodsCategoryID2').value;	 
			var selType= document.getElementById('selType2').value;	 
			var ShopCodeName = $('#ds').val(); 
			if(ShopCodeName == ''){
				ShopCodeName = EncodeUtf8($("#dnames").val());
			}
			
			var salesnumtype = $('#salesnumtype2').val(); 
			var isShow = $('input[name=isShow2]:checked').val();
			var showCompanyName = $('input[name=showCompanyName2]:checked').val();
			
			if(BeginDate==""){
				alert('请选择日期!');
				document.getElementById("startTime").focus();
				return false;
			}
			if(End==""){
				alert('请选择日期!');
				document.getElementById("endTime").focus();
				return false;
			}
			if(selType==""){
				alert('请选择查看方式!');
				document.getElementById("selType2").focus();
				return false;
			}

			var salesnumtypeName = salesnumtype == '1' ? '显示全部' : '忽略销售数量为零';
			var goodsCategoryName = '';
			switch(goodsCategoryID){
				case '1':
					goodsCategoryName = '镜架';
					break;
				case '2':
					goodsCategoryName = '配件';
					break;
				case '3':
					goodsCategoryName = '镜片';
					break;
				case '4':
					goodsCategoryName = '隐形';
					break;
				case '5':
					goodsCategoryName = '护理液';
					break;
				case '6':
					goodsCategoryName = '太阳镜';
					break;
				case '7':
					goodsCategoryName = '耗材';
					break;
				case '8':
					goodsCategoryName = '老花镜';
					break;
				case '9':
					goodsCategoryName = '视光';
					break;
				default:
					break;																																								
			}
			ShopCodeName = ShopCodeName == '' ? '所有门店' : ShopCodeName;
						
			var DataURL='';
			var reportName = '';
			var formAction = '';
			
			if(selType=='1'){
				if ($('#queryFrm').val() == '1'){
					reportName = 'lead_SupplierRanking.cpt';
					formAction = 'pm1';
					
					DataURL = "report.action?reportlet=lead_SupplierRanking.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode+"&beginDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodsCategoryID+"&ShopCodeName="+EncodeUtf8(ShopCodeName)+'&isShow='+isShow+"&salesnumtype="+salesnumtype+"&bgnretailamount="+$('#bgnretailamount2').val()+"&endretailamount="+$('#endretailamount2').val()+"&goodsCategoryName="+EncodeUtf8(goodsCategoryName)+"&salesnumtypeName="+EncodeUtf8(salesnumtypeName)+"&showCompanyName="+showCompanyName; 
				}else if ($('#queryFrm').val() == '2'){
					reportName = 'lead_SupplierRankingByGoods.cpt';
					formAction = 'pm2';
					
					DataURL = "report.action?reportlet=lead_SupplierRankingByGoods.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode+"&beginDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodsCategoryID+"&ShopCodeName="+EncodeUtf8(ShopCodeName)+'&isShow='+isShow+"&salesnumtype="+salesnumtype+"&bgnretailamount="+$('#bgnretailamount2').val()+"&endretailamount="+$('#endretailamount2').val()+"&goodsCategoryName="+EncodeUtf8(goodsCategoryName)+"&salesnumtypeName="+EncodeUtf8(salesnumtypeName)+"&showCompanyName="+showCompanyName; 
			    }else{
					reportName = 'lead_SupplierRankingForBrand.cpt';
					formAction = 'pm3';
					
			    	DataURL = "report.action?reportlet=lead_SupplierRankingForBrand.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode+"&beginDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodsCategoryID+"&ShopCodeName="+EncodeUtf8(ShopCodeName)+'&isShow='+isShow+"&salesnumtype="+salesnumtype+"&bgnretailamount="+$('#bgnretailamount2').val()+"&endretailamount="+$('#endretailamount2').val()+"&goodsCategoryName="+EncodeUtf8(goodsCategoryName)+"&salesnumtypeName="+EncodeUtf8(salesnumtypeName)+"&showCompanyName="+showCompanyName; 
				}
			}else{
				reportName = 'lead_SupplierOrder.cpt';
				formAction = 'pm4';
				
				DataURL = "report.action?reportlet=lead_SupplierOrder.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode+"&beginDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodsCategoryID+"&ShopCodeName="+EncodeUtf8(ShopCodeName)+'&isShow='+isShow+"&bgnretailamount="+$('#bgnretailamount2').val()+"&endretailamount="+$('#endretailamount2').val(); 
			}

			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				DataURL = "report.action?reportlet=" + reportName+"&__bypagesize__=false";

				$('#rptFrm input[name=departmentsID]').get(0).value = ShopCode;
				$('#rptFrm input[name=beginDate]').get(0).value = BeginDate;
				$('#rptFrm input[name=endDate]').get(0).value = End;
				$('#rptFrm input[name=goodsCategoryID]').get(0).value = goodsCategoryID;
				$('#rptFrm input[name=ShopCodeName]').get(0).value = ShopCodeName;
				$('#rptFrm input[name=isShow]').get(0).value = isShow;
				$('#rptFrm input[name=salesnumtype]').get(0).value = salesnumtype;
				$('#rptFrm input[name=bgnretailamount]').get(0).value = $('#bgnretailamount2').val();
				$('#rptFrm input[name=endretailamount]').get(0).value = $('#endretailamount2').val();
				$('#rptFrm input[name=goodsCategoryName]').get(0).value = goodsCategoryName;
				$('#rptFrm input[name=salesnumtypeName]').get(0).value = salesnumtypeName;
				$('#rptFrm input[name=showCompanyName]').get(0).value = showCompanyName;
				$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
			
				queryReport(DataURL,formAction);
			}		
			document.getElementById('popupTitle').innerHTML="【销售排名表】";
		}		
	}

	function createForm(){
		
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post";    
		
		var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);

	    var departmentsID = document.createElement("input");	     
	    departmentsID.type = "hidden";
	    departmentsID.name = "departmentsID";
	    departmentsID.value = '';	  
	    rptFrm.appendChild(departmentsID);  

	    var beginDate = document.createElement("input");	     
	    beginDate.type = "hidden";
	    beginDate.name = "beginDate";
	    beginDate.value = '';	  
	    rptFrm.appendChild(beginDate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);  

	    var goodsCategoryID = document.createElement("input");	     
	    goodsCategoryID.type = "hidden";
	    goodsCategoryID.name = "goodsCategoryID";
	    goodsCategoryID.value = '';	  
	    rptFrm.appendChild(goodsCategoryID);  

	    var ShopCodeName = document.createElement("input");	     
	    ShopCodeName.type = "hidden";
	    ShopCodeName.name = "ShopCodeName";
	    ShopCodeName.value = '';	  
	    rptFrm.appendChild(ShopCodeName); 

	    var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 

	    var salesnumtype = document.createElement("input");	     
	    salesnumtype.type = "hidden";
	    salesnumtype.name = "salesnumtype";
	    salesnumtype.value = '';	  
	    rptFrm.appendChild(salesnumtype);   

	    var bgnretailamount = document.createElement("input");	     
	    bgnretailamount.type = "hidden";
	    bgnretailamount.name = "bgnretailamount";
	    bgnretailamount.value = '';	  
	    rptFrm.appendChild(bgnretailamount);   

	    var endretailamount = document.createElement("input");	     
	    endretailamount.type = "hidden";
	    endretailamount.name = "endretailamount";
	    endretailamount.value = '';	  
	    rptFrm.appendChild(endretailamount);   

	    var goodsCategoryName = document.createElement("input");	     
	    goodsCategoryName.type = "hidden";
	    goodsCategoryName.name = "goodsCategoryName";
	    goodsCategoryName.value = '';	  
	    rptFrm.appendChild(goodsCategoryName);   
	    
	    var salesnumtypeName = document.createElement("input");	     
	    salesnumtypeName.type = "hidden";
	    salesnumtypeName.name = "salesnumtypeName";
	    salesnumtypeName.value = '';	  
	    rptFrm.appendChild(salesnumtypeName);    

	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';	  
	    rptFrm.appendChild(showCompanyName);   
	    
	    document.body.appendChild(rptFrm);
    }
    
	function queryReport(DataURL,formAction){
		
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			//rptFrm.removeEventListener("onsubmit");	
		}         

	    rptFrm.submit();  
	  
	    document.body.removeChild(rptFrm); 
    }
	
	function clean(){
		goodsForm.reset();	
	}

	/**
	 * 清空制造商和品种
	 */
	function changeGoodsCategory(){
		
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodsCategoryID = document.getElementById('goodsCategoryID2').value;
	    if(goodsCategoryID==''){
		      alert('请选择商品类型!');
		      return false;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodsCategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodsCategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodsCategoryID = document.getElementById('goodsCategoryID2').value;
	    if(goodsCategoryID==''){
		      alert('请选择商品类型!');
		      return false;
		}
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

	function changeSalesType(){
        if ($('#selType2').val() == '1'){
            $('#salesnumset').show();
            $('#salesnumtype2').show();
            $('#queryFrmTab').show();
        }else{
        	$('#salesnumset').hide();
        	$('#salesnumtype2').val('1');
        	$('#salesnumtype2').hide();
        	$('#queryFrmTab').hide();
        }
    }

	function changeselect(obj){
		var selecta = $("#intransittype");
		var selectb = $("#bgngoodsnum");
		var selectc = $("#intransittype2");
		var selectd = $("#endgoodsnum");
		if(obj == '0'){
			if(selecta.val() == '1' || selecta.val() == '4' || selecta.val() == '5'){
				selectc.hide();
				selectd.hide();
				selectd.val('');
			}else if(selecta.val() == '2' || selecta.val() == '3'){
				selectc.show();
				selectd.show();
			}
		}
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" id="goodsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="dids" name="dids" value="">
<input type="hidden" id="dnames" name="dnames" value="">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：销售排名表</TD>
            <TD>&nbsp;</TD>
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
                      	   <TD width="10%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="26%">
			               <c:if test="${person.departmenttype != 1}">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input160" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" />
							   		<textarea id="ds"  name="ds" style='height:50px;width: 200px' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
      	                   </c:if>
      	                   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname }" name="ds"/>
      	                   </c:if>
			               </TD>
			               <TD width="10%" class="table_body">查询日期</TD>
			               <TD class="table_none" width="20%">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               
			               <TD width="10%" class="table_body">商品类别</TD>
			               <TD class="table_none">
			                 <select id="goodsCategoryID2" name="goodsCategoryID2" onchange="changeGoodsCategory()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取商品类型！'}]">
			                        <option value="">----请选择----</option>
                                <s:iterator value="goodsCategoryList">
								    <option value="${bgcid}" goodsCategoryName="${bgcgoodscategoryname}">(${bgcid})${bgcgoodscategoryname}</option>
								</s:iterator>
							 </select>
			               </TD>
			               
                        </TR>
                        <TR>
		                   <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>否
			               </TD>
			               <TD width="10%" height="26" class="table_body">查看方式</TD>
			               <TD class="table_none" >
			                 <select id="selType2" name="selType2" onchange="changeSalesType(this)">
			                 		<option value="">----请选择----</option>
			                        <option value="1" selected="selected">按报表</option>
			                        <option value="2">按图表</option>
							 </select>
			               </TD>
			            </TR>
                        <TR id="queryFrmTab">
                           <TD width="10%" height="26" class="table_body">销售区间</TD>
			               <TD class="table_none" >
								<input class="text_input60" type="text" id="bgnretailamount2" name="bgnretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/> 至 
								<input class="text_input60" type="text" id="endretailamount2" name="endretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>
			               </TD>
                           <TD class="table_body" height="26">查询方式</TD>
			               <TD class="table_none">
			                 <select id="queryFrm" name="queryFrm" >
			                        <option value="1">按制造商</option>
			                        <option value="3">按商品品种</option>
			                        <option value="2">按商品</option>
							 </select>
			               </TD>
                           <TD class="table_body" height="26"><span id="salesnumset">销售数量</span>&nbsp;</TD>
			               <TD class="table_none">
			                 <select id="salesnumtype2" name="salesnumtype2" >
			                        <option value="1">显示全部</option>
			                        <option value="2">忽略销售数量为零</option>
							 </select>
			               </TD>
			               <!-- 
			               <TD class="table_body" height="26">销售数量区间</TD>
			               <TD class="table_none" colspan="3">
	                          <select name="intransittype" id="intransittype" onchange="changeselect('0')">
	                            <option value="1" ${requestScope.intransittype == '1' ? 'selected="selected"' : '' }>=</option>
	                            <option value="2" ${requestScope.intransittype == '2' ? 'selected="selected"' : '' }>>=</option>
	                            <option value="3" ${requestScope.intransittype == '3' ? 'selected="selected"' : '' }>></option>
	                            <option value="4" ${requestScope.intransittype == '4' ? 'selected="selected"' : '' }><=</option>
	                            <option value="5" ${requestScope.intransittype == '5' ? 'selected="selected"' : '' }><</option>
	                          </select>
	                          <input class="text_input60" type="text" id="bgngoodsnum" name="bgngoodsnum" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '请重新填写销售数量！'}]"/>
		                      <select name="intransittype2" id="intransittype2" onchange="changeselect('3')">
	                              <option value="1" ${requestScope.intransittype2 == '1' ? 'selected="selected"' : '' }><=</option>
	                              <option value="2" ${requestScope.intransittype2 == '2' ? 'selected="selected"' : '' }><</option>
	                          </select>
	                          <input class="text_input60" type="text" id="endgoodsnum" name="endgoodsnum" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '请重新填写销售数量！'}]"/>                            
                            
			               </TD>
			                -->
                        </TR>
                      </TBODY>
                    </TABLE>
            <c:if test="${permissionPo.keya eq '1'}">        
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                                <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
			</c:if>		
			<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">												
1.查询条件：销售门店（必选）、查询日期（必选）、商品类别、制造商、商品品种<br/>																		
2.根据选择的日期、门店，对制造商下每个品种的销售情况进行统计，并且每个制造商的品种按照销售数量进行排序
					</div>														
			</c:if>		
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
