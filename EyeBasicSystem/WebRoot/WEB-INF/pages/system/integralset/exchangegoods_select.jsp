<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		if ($('#goodsCategoryID').val() != '1'){
            $('#teachnologyName').hide();
            $('#teachnologyType').hide();
            $('#teachnologyType').val('');
		}else{
            $('#teachnologyName').show();
            $('#teachnologyType').show();
		}
	});
	
	function search(){
		integralFrm.action = "exchangeGoodsOpen.action";
		integralFrm.submit();
	}
    function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });

		if ($('#goodsCategoryID').val() != '1'){
            $('#teachnologyName').hide();
            $('#teachnologyType').hide();
            $('#teachnologyType').val('');
		}else{
            $('#teachnologyName').show();
            $('#teachnologyType').show();
		}
	}
    
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var firGoodsCategoryID = document.getElementById("goodsCategoryID").value.substring(0,1);
	    if(firGoodsCategoryID==''){
	      alert('请选择商品类别!');
	      return false;
	    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+firGoodsCategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+firGoodsCategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
		document.getElementById('goodsID').value ='';
		document.getElementById('goodsName').value = '';
	}
	
	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
		document.getElementById('goodsID').value ='';
		document.getElementById('goodsName').value = '';

		if ($('#goodsCategoryID').val() != '1'){
            $('#teachnologyName').hide();
            $('#teachnologyType').hide();
            $('#teachnologyType').val('');
		}else{
            $('#teachnologyName').show();
            $('#teachnologyType').show();
		}
	}	
			
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var firGoodsCategoryID = document.getElementById("goodsCategoryID").value.substring(0,1);
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商!');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+firGoodsCategoryID+"&supplierID_open=" +supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+firGoodsCategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;		
		document.getElementById('goodsID').value ='';
		document.getElementById('goodsName').value = '';
	}
	
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){	
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        if(chks.checked){
          setValue();
        }else{
          setDelValue();
        }        
    }
    
	$(document).ready(function (){
		setCheckValue();
	});
	
	/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

        $("input[id=chk]").each(function(){
         	if(chktext.indexOf($(this).attr("goodsID"))>=0){
              $(this).attr("checked","checked");
           }
		});
    }
	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){
        var objValue="["+obj.value+"]";;
        if(obj.checked==true){
           window.parent.openGoodSingleValues(objValue);
        }else if(obj.checked==false){
           window.parent.openGoodSingleDeleteValues(objValue);
        }

    }
    
	/**
	 *  调用页面赋值删除
	 */
	function setDelValue(){ 	         

        var objValue="";
        var count=0;

        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==false){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;  
	         }  
		});
        
         if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleDeleteValues(objValue);
        
	}		
	/**
	 *  调用页面赋值
	 */
	function setValue(){
        var objValue="";
        var count=0;
        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==true){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;    
		     }
		});
         if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleValues(objValue);     
	}

	function setAllValue(){
		var json = {'goodsCategoryID' : $('#goodsCategoryID').val(), 'supplierID' :$('#supplierID').val(), 'brandID' :$('#brandID').val(), 'goodsID' :$('#goodsID').val(), 'goodsName' :　$('#goodsName').val(), 'costprice' :　$('#costprice').val(), 'retailprice' :$('#retailprice').val(), 'teachnologyType' :$('#teachnologyType').val()};
		window.parent.openAllGoodsValues(json);
		
		parent.hidePopWin();
	}
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="integralFrm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none">
							  	<select clean=clean id="goodsCategoryID" name="goodsCategoryID" onchange="changeGoodsCategory();">
							  		<option value="">----请选择----</option>
							  		<option value="1" ${goodsCategoryID == '1' ? 'selected="selected"' : '' } >镜架</option>
							  		<option value="2" ${goodsCategoryID == '2' ? 'selected="selected"' : '' } >配件</option>
							  		<option value="3-0" ${goodsCategoryID == '3-0' ? 'selected="selected"' : '' } >成品片</option>
							  	<!-- 	<option value="3-D" ${goodsCategoryID == '3-D' ? 'selected="selected"' : '' } >订做片类</option>  -->
							  		<option value="4-0" ${goodsCategoryID == '4-0' ? 'selected="selected"' : '' } >隐形成品片</option>
							  	<!-- 	<option value="4-D" ${goodsCategoryID == '4-D' ? 'selected="selected"' : '' } >隐形订做片</option> -->
							  		<option value="5" ${goodsCategoryID == '5' ? 'selected="selected"' : '' } >隐形护理液</option>
							  		<option value="6" ${goodsCategoryID == '6' ? 'selected="selected"' : '' } >太阳镜</option>
							  		<option value="7" ${goodsCategoryID == '7' ? 'selected="selected"' : '' } >耗材</option>
							  		<option value="8" ${goodsCategoryID == '8' ? 'selected="selected"' : '' } >老花镜</option>
							  		<option value="9" ${goodsCategoryID == '9' ? 'selected="selected"' : '' } >视光</option>
								</select></TD>
						   <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input clean=clean id="supplierName" class="text_input160" name="supplierName" value="${supplierName }" readonly="readonly" />
						   		<input clean=clean type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                           <TD width="9%" class="table_body">商品品种</TD>
			               <TD width="24%" class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li>
			               </TD>
                        </tr>
                        <tr>
						   <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" maxlength="50">
			               </TD>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" maxlength="200">
			               </TD>
			              <TD height="26" class="table_body">含税单价</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="costprice" name="costprice" value="${requestScope.costprice}" maxlength="18">
			               </TD>
                        </tr>
                        <tr>
			               <TD height="26" class="table_body">零售价</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="retailprice" name="retailprice" value="${requestScope.retailprice}" maxlength="18">
			               </TD>
			               <TD height="26" class="table_body"><span id="teachnologyName">工艺类型</span>&nbsp;</TD>
			               <TD class="table_none" colspan="3">
                           <select id="teachnologyType" name="teachnologyType">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="teachnologyTypeList">
				               <option value="${fttid}" ${teachnologyType != fttid ? '' : 'selected="selected"' }>${fttname}</option>
	     	                 </s:iterator>
      	                   </select>&nbsp;
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                     
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                        <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="javascript:search()">
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onclick="clean()">
							    <%--<img src="${ctx }/img/newbtn/btn_changesuoyou_0.png" btn=btn title="选择所有查询结果" onclick="setAllValue()">--%>
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
                          <TH width="5%" scope=col><input type="checkbox" id="chks" name="chks" onclick="chkAll()">全选</TH>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>                          
                          <TH width="8%" scope=col>单位</TH>
                          <TH width="8%" scope=col>零售价</TH>
                          <TH width="5%" scope=col>球镜</TH>
                          <TH width="5%" scope=col>柱镜</TH>
						</TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <td height="26" >
                            <input type="checkbox" id="chk" name="chk" goodsID="${bgigoodsid}" onClick="setSingleValue(this);" value="{'goodsID':'${bgigoodsid}','goodsName':'${bgigoodsname}'}" />
                          </td>
                          <TD>${bgigoodsid }</TD>
                          <TD>${bgiviewgoodsname }</TD>
                          <TD>${bgiunitname }</TD>
                          <TD>${bgiretailprice }</TD>
                          <TD>${bgisph }</TD>
                          <TD>${bgicyl}</TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=20></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>