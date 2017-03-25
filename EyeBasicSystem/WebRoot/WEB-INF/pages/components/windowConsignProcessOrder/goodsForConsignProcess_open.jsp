<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "selGoodsForConsignProcessOpen.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsName').value = "";
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";

	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.getElementById("goodscategory").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var goodscategoryID= document.getElementById("goodscategory").value;
	    var supplierID=document.getElementById('supplierID').value;
		 if(supplierID=='')
		 {
	      alert('请选择所属制造商');
	      return false;
	    }
		//showPopWin("","selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	 *  调用页面赋值
	 */
	function setValue(cstcpodgoodsid,cstcpodgoodsname){
	
	    var glassflag=document.all.glassflag.value;
	    var sph=document.all.sph.value;
	    var cyl=document.all.cyl.value;
	    var axis=document.all.axis.value;
	    var belowplusluminosity=document.all.belowplusluminosity.value;
	    var arriseglass=document.all.arriseglass.value;	    
	    var basis=document.all.basis.value;
	    var curvature1=document.all.curvature1.value;
	    var curvature2=document.all.curvature2.value;
	    var dia=document.all.dia.value;	
	    var curvature=curvature1; 
	    if(curvature2!=''){
	      curvature=curvature+"/"+curvature2;
	    }       
        var objValue="{'cstcpodgoodsid':'"+cstcpodgoodsid+"','cstcpodgoodsname':'"+cstcpodgoodsname+"','cstcpodglassflag':'"+glassflag+"',";       
        objValue=objValue+"'cstcpodballglass':'"+sph+"','cstcpodpostglass':'"+cyl+"',";
        objValue=objValue+"'cstcpodaxes':'"+axis+"','cstcpodadd':'"+belowplusluminosity+"','cstcpodarriseglass':'"+arriseglass+"',";
        objValue=objValue+"'cstcpodbasis':'"+basis+"','cstcpodeyecurvature':'"+curvature+"','cstcpoddiameter':'"+dia+"'}";                

       // objValue="["+objValue+"]";
       window.parent.openGoodsForConsignProcessValues(objValue);
		parent.hidePopWin();
        
	}
	
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }  onkeyup="selectContact(this)">
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
           <br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
				</TD></TR>
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
						   <TD width="8%" height="26" class="table_body">商品代码</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">商品名称</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
                           <TD width="8%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
			                  <c:if test="${goodscategory==3}">
                                    镜片
                              </c:if>
                              <c:if test="${goodscategory==4}">
                                    隐形镜片
                              </c:if> 
                                <input type="hidden" id="goodscategory" name="goodscategory" value="${goodscategory}">
			               </TD>
                        </TR>
                        <TR>	
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   		${supplierName }
						   		<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
						   		<input type="hidden" id="supplierName" name="supplierName" value="${supplierName }" />
						   	</TD>		               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openBrand();"></li>
			               </TD>

                           <TD height="26" class="table_body">材质</TD>
			               <TD class="table_none" >
			                  <c:if test="${materialType==2}">
                                    玻璃
                              </c:if>
                              <c:if test="${materialType==1}">
                                    树脂
                              </c:if>
                              <c:if test="${materialType==3}">
                                PC
                              </c:if>  
                                <input type="hidden" id="materialType" name="materialType" value="${materialType}">
                                <input type="hidden" id="glassflag" name="glassflag" value="${glassflag}">
                                <input type="hidden" id="sph" name="sph" value="${sph}">
                                <input type="hidden" id="cyl" name="cyl" value="${cyl}">   
                                <input type="hidden" id="axis" name="axis" value="${axis}">
                                <input type="hidden" id="belowplusluminosity" name="belowplusluminosity" value="${belowplusluminosity}">  
                                <input type="hidden" id="arriseglass" name="arriseglass" value="${arriseglass}">
                                <input type="hidden" id="basis" name="basis" value="${basis}"> 
                                <input type="hidden" id="curvature1" name="curvature1" value="${curvature1}">  
                                <input type="hidden" id="curvature2" name="curvature2" value="${curvature2}">
                                <input type="hidden" id="dia" name="dia" value="${dia}">                                                                                              
			               </TD>

                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
								
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
					<c:if test="${not empty(goodsList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>  
                        <TH width="4%" scope=col>操作</TH>                         
                          <TH width="25%" height="26" scope=col>商品代码</TH>
                          <TH width="25%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>单位</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>零售价格</TH>  
                                                                                                                                                  

						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">   
                          <TD width="4%">
                          <img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="setValue('${cstcpodgoodsid}','${cstcpodgoodsname}');">
                          </TD>                      
                          <TD height="26">${cstcpodgoodsid}</TD>
                          <TD>${cstcpodgoodsname}</TD>
                          <TD>${cstcpounitname}</TD>
                          <TD>${cstcpobgispec}</TD>
                          <TD>${cstcporetailprice}</TD>
                        
                      
						</TR>
						</s:iterator>
                      </TBODY>
                    </TABLE>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
