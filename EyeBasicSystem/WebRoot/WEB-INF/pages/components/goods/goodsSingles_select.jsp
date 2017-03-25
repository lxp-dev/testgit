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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
	$("img").removeAttr("onclick");
		goodsForm.action = "selGoodsSingles.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsName').value = "";
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('goodscode').value = "";
		
		
		document.getElementById('bgiretailbeginprice').value = "";
		document.getElementById('bgiretailendprice').value = "";

	    <c:if test="${empty(supplierID_open) }">
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    </c:if>
	    <c:if test="${empty(categoryID_open) }">
	    document.all.goodscategoryID.value="";
	    </c:if>
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
		
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
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand()
	{
		var goodscategoryID= document.all.goodscategoryID.value;
		var supplierID=document.getElementById('supplierID').value;
		
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
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

          $("input[id=chk]").each(function(){
         	if(chktext.indexOf($(this).attr("goodsid"))>=0){
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
        //alert(objValue);
        window.parent.openGoodSingleDeleteValues(objValue);
       // alert('您选择的商品信息已添加到商品列表中！');
        
	}	

	function setValue(id, value,code){	
		var json = {'id' : id, 'value' :　value,'code':code};
		window.parent.openGoodsValues(json);
		
		parent.hidePopWin();

	}	
	/**
	 *  调用页面赋值
	 */
	function setValues(){ 	         

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
        //alert(objValue);
        window.parent.openGoodSingleValues(objValue);
       // alert('您选择的商品信息已添加到商品列表中！');
        
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
	function selectContact(obj){
		var act = document.activeElement.id;
		
		if(act == "pageNos"&&event.keyCode==13){
			document.getElementById(act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	$(document).ready(function (){
		setCheckValue();
	});

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id="isrefresh" value="1" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	</TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
						   <TD width="60" height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" onkeyup="selectContact(this)">
			               </TD>
			               <TD width="60" height="26" class="table_body">商品条码</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodscode" name="goodscode" value="${requestScope.goodscode}" onkeyup="selectContact(this)">
			               </TD>
                           <TD width="60" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" onkeyup="selectContact(this)">
			               </TD>
                        </TR>
                        <TR>
                         <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID" ${not empty(categoryID_open) ? 'disabled="disabled"' : '' }>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }${categoryID_open == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>
                         <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						   				<c:if test="${empty(supplierID_open)}">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openSupplier();" ></li>
						   				</c:if>
						   	</TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openBrand();"></li>
			              </TD>
                        </TR>
                          <TR>	
                           <!-- quyanping 2011-5-26 -->
			               <TD width="60" height="26" class="table_body">工艺类型</TD>
			               <TD class="table_none">
                            <select id="technologyTypeID" name="technologyTypeID" >
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="technologyType">
				               <option value="${fttid}" ${technologyTypeID == fttid ? 'selected="selected"' : '' }>${fttname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>		               
						   <TD height="26" class="table_body">零售价</TD>
			               <TD class="table_none" colspan="3">
			               <input class="text_input100" type="text" id="bgiretailbeginprice" name="bgiretailbeginprice" value="${requestScope.bgiretailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"> ~ <input class="text_input100" type="text"  id="bgiretailendprice" name="bgiretailendprice" value="${requestScope.bgiretailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"></TD>
                           </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">

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
					<!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="4%" height="26" scope=col>操作</TH>                        
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="15%" scope=col>制造商</TH>
                          <TH width="4%" scope=col>单位</TH>
                          <TH width="8%" scope=col>零售价格</TH>
                          <c:if test="${goodscategoryID == '1'}">
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="5%" scope=col>颜色</TH>  
                          </c:if>  
                          <c:if test="${goodscategoryID == '2'}">
                          <TH width="5%" scope=col>型号</TH>
                          </c:if>
                          <c:if test="${goodscategoryID == '3'}">
                          <TH width="7%" scope=col>球镜</TH>
                          <TH width="7%" scope=col>柱镜</TH>
                          <TH width="7%" scope=col>轴向</TH>
                          </c:if> 
                          <c:if test="${goodscategoryID == '4'}">
                          <TH width="7%" scope=col>球镜</TH>
                          <TH width="7%" scope=col>柱镜</TH>
                          <TH width="7%" scope=col>轴向</TH>
                          <TH width="7%" scope=col>曲率</TH>
                          <TH width="7%" scope=col>直径</TH>
                          </c:if>     
                          <c:if test="${goodscategoryID == '5'}">
                          <TH width="5%" scope=col>型号</TH>
                          </c:if>    
                          <c:if test="${goodscategoryID == '6'}">
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="5%" scope=col>颜色</TH>  
                          </c:if> 
                          <c:if test="${goodscategoryID == '7'}">
                          <TH width="5%" scope=col>型号</TH>
                          </c:if>  
                          <c:if test="${goodscategoryID == '8'}">
                          <TH width="5%" scope=col>型号</TH>
                          </c:if>
                          <c:if test="${goodscategoryID == '9'}">
                          <TH width="5%" scope=col>型号</TH>
                          </c:if>                  
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                           <img src="${ctx }/img/newbtn/select_0.png" btn=btn title="选择" onClick="setValue('${bgigoodsid}', '${bgigoodsname}','${bgigoodsbarcode}');">
		                 
                          </TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgisuppliername}</TD>
                          <TD>${bgiunitname}</TD>
                          <TD>${bgiretailprice}</TD>
                          <c:if test="${goodscategoryID == '1'}">
                          <TD>${bgispec}</TD>
                          <TD>${bgicolor}</TD>  
                          </c:if>
                          <c:if test="${goodscategoryID == '2'}">
                          <TD>${bgispec}</TD>
                          </c:if>
                          <c:if test="${goodscategoryID == '3'}">
                          <TD>${bgisph}</TD>
                          <TD>${bgicyl}</TD>
                          <TD>${bgiaxis}</TD>
                          </c:if> 
                          <c:if test="${goodscategoryID == '4'}">
                          <TD>${bgisph}</TD>
                          <TD>${bgicyl}</TD>
                          <TD>${bgiaxis}</TD>
                          <TD>${bgicurvature1}</TD>
                          <TD>${bgidia}</TD>
                          </c:if>
                          <c:if test="${goodscategoryID == '5'}">
                          <TD>${bgispec}</TD>
                          </c:if>  
                          <c:if test="${goodscategoryID == '6'}">
                          <TD>${bgispec}</TD>
                          <TD>${bgicolor}</TD> 
                          </c:if> 
                          <c:if test="${goodscategoryID == '7'}">
                          <TD>${bgispec}</TD>
                          </c:if>  
                          <c:if test="${goodscategoryID == '8'}">
                          <TD>${bgispec}</TD>
                          </c:if>
                          <c:if test="${goodscategoryID == '9'}">
                          <TD>${bgispec}</TD>
                          </c:if> 
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
