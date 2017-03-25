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
	}); 

	function search(){
		if(checkForm(goodsForm)){

			if(!is_iPad()){
				createForm();
			}

			var BeginDate = document.getElementById("startTime").value;
			var End = document.getElementById("endTime").value;
			var isShow = $('input[name=isShow2]:checked').val();
			var showCompanyName = $('input[name=showCompanyName2]:checked').val();
			
			var supplierID = $("input[id=supplierID2]").val();
			if (supplierID == undefined){
				supplierID = '';
		    }
			var brandID=$("input[id=brandID2]").val();
			if (brandID == undefined){
				brandID = '';
		    }
			var supplierName = $("input[id=supplierName2]").val();
			if (supplierName == undefined){
				supplierName = '';
		    }
			var brandName=$("input[id=brandName2]").val();
			if (brandName == undefined){
				brandName = '';
		    }
			
			if(BeginDate==""){
				alert('请选择起始日期!');
				document.getElementById("startTime").focus();
				return false;
			}
			if(End==""){
				alert('请选择结束日期!');
				document.getElementById("endTime").focus();
				return false;
			}
            
			var reportName = '';
			var formAction = '';
            var reportUrl = "&bgnDate="+BeginDate+"&endDate="+End+"&supplierID="+supplierID+"&brandID="+brandID+'&isShow='+isShow+"&showCompanyName="+showCompanyName+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName); 
	
			reportName = 'sales_framePriceArea.cpt';
			formAction = 'zzl1';
	        
	        DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
			
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;	
			if(is_iPad()){
				showPopWin(DataURL+reportUrl,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{				

				$('#rptFrm input[name=bgnDate]').get(0).value = BeginDate;
				$('#rptFrm input[name=endDate]').get(0).value = End;
				$('#rptFrm input[name=isShow]').get(0).value = isShow;
				$('#rptFrm input[name=supplierID]').get(0).value = supplierID;
				$('#rptFrm input[name=brandID]').get(0).value = brandID;
				$('#rptFrm input[name=showCompanyName]').get(0).value = showCompanyName;
				$('#rptFrm input[name=supplierName]').get(0).value = supplierName;
				$('#rptFrm input[name=brandName]').get(0).value = brandName;

				queryReport(DataURL,formAction);

			}		
			document.getElementById('popupTitle').innerHTML="【镜架价位段统计表】";
		}		
	}


	function createForm(){
		
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post";   

	    var bgnDate = document.createElement("input");	     
	    bgnDate.type = "hidden";
	    bgnDate.name = "bgnDate";
	    bgnDate.value = '';	  
	    rptFrm.appendChild(bgnDate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);  

	    var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 

	    var supplierID = document.createElement("input");	     
	    supplierID.type = "hidden";
	    supplierID.name = "supplierID";
	    supplierID.value = '';	  
	    rptFrm.appendChild(supplierID);   

	    var brandID = document.createElement("input");	     
	    brandID.type = "hidden";
	    brandID.name = "brandID";
	    brandID.value = '';	  
	    rptFrm.appendChild(brandID);   

	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';	  
	    rptFrm.appendChild(showCompanyName);   

	    var supplierName = document.createElement("input");	     
	    supplierName.type = "hidden";
	    supplierName.name = "supplierName";
	    supplierName.value = '';	  
	    rptFrm.appendChild(supplierName);   

	    var brandName = document.createElement("input");	     
	    brandName.type = "hidden";
	    brandName.name = "brandName";
	    brandName.value = '';	  
	    rptFrm.appendChild(brandName); 
	    
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
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodscategoryID = '1';
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		$('input[id=supplierID2]').val(json.id);
		$('input[id=supplierName2]').val(json.value);
		$('input[id=brandID2]').val('');
		$('input[id=brandName2]').val('');		
	}
	
	function openBrand(){
		var goodscategoryID = '1';
		var supplierID=$('input[id=supplierID2]').val();

	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		$('input[id=brandID2]').val(json.brandID);
		$('input[id=brandName2]').val(json.brandName);
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：镜架价位段统计表 </TD>
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
                         <TD width="10%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      	<TR>
                      	   <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">镜架类&nbsp;
	      	               </TD>
			               <TD width="9%" class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
                               <label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="supplierName2" name="supplierName2" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="supplierID2" name="supplierID2" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="brandName2" name="brandName2" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="brandID2" name="brandID2" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>  
                        <TR>
                           <TD height="26" class="table_body">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                           <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>否
			               </TD>
                        </TR>                   
                      </TBODY>
                    </TABLE>    
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                                <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
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
