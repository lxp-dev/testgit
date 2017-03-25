<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存预警设置</title>
</head>
<script>
	function save(){
		if(checkForm(document.all.stockAlertSettingForm)){ 
			var bgistorageupperlimit=parseInt(document.getElementById('bgistorageupperlimit').value);
		    var bgistoragelowerlimit=parseInt(document.getElementById('bgistoragelowerlimit').value);
		    var bgistorageredlimit=parseInt(document.getElementById('bgistorageredlimit').value);
	
		    if(bgistoragelowerlimit>bgistorageupperlimit){
		      alert('库存下限不能大于库存上限');
		      document.all.bgistorageupperlimit.focus();
		      return false;
		    }

		    if(bgistorageredlimit>bgistoragelowerlimit){
		      alert('红色预警不能大于库存下限');
		      document.all.bgistorageredlimit.focus();
		      return false;
		    }
	    
			<c:if test="${param.goodsType == 0 }" >
			var bgisphul=parseFloat(document.all.bgisphul.value);
		    var bgisphup=parseFloat(document.all.bgisphup.value);
		    if(bgisphul<bgisphup){
		      alert('球镜下限不能大于球镜上限');
		      document.all.bgisphul.focus();
		      return false;
		    }
		    
		    var bgicylul=parseFloat(document.all.bgicylul.value);
		    var bgicylup=parseFloat(document.all.bgicylup.value);
		    if(bgicylul<bgicylup){
		      alert('柱镜下限不能大于柱镜上限');
		      document.all.bgicylup.focus();
		      return false;
		    }
		    </c:if>

		    if(parseFloat($('#bgistorageupperlimit').val())<0){
		    $('#bgistorageupperlimit').focus();
		    	alert('上限不能为负!');
		    	return;
		    }
		     if(parseFloat($('#bgistoragelowerlimit').val())<0){
		     $('#bgistoragelowerlimit').focus();
		    	alert('下限不能为负!');
		    	return;
		    }
		    
		    $("img").removeAttr("onclick");
			stockAlertSettingForm.action = "insertStockAlertSetting2D.action";
			stockAlertSettingForm.submit();
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodscategoryID=document.getElementById('cstpgoodscategory').value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		deleteROWss();
		document.getElementById('bgisupplierid').value = json.id;
		document.getElementById('bgisuppliername').value = json.value;
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
	function clean(){
		document.stockAlertSettingForm.reset();
	}

    function changeCategory(obj){
    	deleteROWss();
		document.getElementById('bgisupplierid').value = "";
		document.getElementById('bgisuppliername').value = "";
    }
    
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		var chaasupplier =document.getElementById('bgisupplierid').value;
	    if(chaasupplier==''){
		    alert('请选择制造商');
		    return false;
	    }
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+$('#cstpgoodscategory').val()+"&bspsuppliername="+EncodeUtf8($('#bgisuppliername').val())+"&cstpsupplierid="+$('#bgisupplierid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+$('#cstpgoodscategory').val()+"&bspsuppliername="+EncodeUtf8($('#bgisuppliername').val())+"&cstpsupplierid="+$('#bgisupplierid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【按二维表添加商品】";
	}
	
	function addtdgoods(){
		//deleteROWss();
		stockAlertSettingForm.action = "addStockAlertDimension.action";
		stockAlertSettingForm.submit();
	}

    function deleteROWss(){
        $('input[id=chk]').each(function(){ 
        	$(this).parent().parent().remove(); 
        }); 

        $('#tdgoodsids').val('');
        $('#tdvs').val('');
	}
    
    function deleteitem(){   
        $('input[id=chk]').each(function(){ 
           	if($(this).is(":checked")){ 
           		$(this).parent().parent().remove(); 
            } 
        }); 

		document.all.chks.checked = false;

		var goodsID = '';
        $('input[id=chk]').each(function(){ 
        	goodsID += $(this).val() + ',';
        }); 
        $('#tdgoodsids').val(goodsID);
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
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="stockAlertSettingForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>

          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD >
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStockAlertSettingInsert.action?moduleID=${requestScope.moduleID}&goodsType=0';"
                      UNSELECTABLE="on">库存预警设置(区间)</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1               
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存预警设置(二维)</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    	width=3></TD>                                  	
                    </TR></TBODY></TABLE></TD>              
                    	
                    <td width="8%" align="right" valign="top">
                    	<img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D" onClick="javascript:open2D();">
                    </td>
                    
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                           <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="cstpgoodscategory" name="cstpgoodscategory" onchange="changeCategory(this)">
                                <option value="3" ${cstpgoodscategory == '3' ? 'selected="selected"' : '' }>框镜成品镜片</option>
                                <option value="4" ${cstpgoodscategory == '4' ? 'selected="selected"' : '' }>隐形成品镜片</option>
                            </select>
                            <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD width="24%" class="table_none">                             
			               	<li class="horizontal_onlyRight">
						   		<input id="bgisuppliername" class="text_input160" name="csasasuppliername"  readonly="readonly" value="${csasasuppliername}" />
						   		<input type="hidden" value="${csasasupplierid}" id="bgisupplierid" name="csasasupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						    <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" btn=btn onClick="openSupplier();">
						  				</li>	
						  	<label style="color:red;">&nbsp;*&nbsp;</label> 					               
			               </TD>
						   <TD height="26" class="table_body">仓位</TD>
			               <TD class="table_none">
                            <select id="warehouseID" name="csasastockid">
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid }" ${csasastockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
      	                   <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>	                
                        </TR>
						<TR>			               
						   <TD height="26" class="table_body">库存上限</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistorageupperlimit" name="csasastockcap" value="${csasastockcap }" 
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '库存上限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ZINT, 'Message' : '库存上限应为正整数！'}]">
			                 <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
			               <TD height="26" class="table_body">库存下限</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistoragelowerlimit" name="csasastocklower" value="${csasastocklower }" 
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '库存下限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '库存下限应为整数！'}]">
			                 <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
			               <TD height="26" class="table_body">红色预警</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistorageredlimit" name="csasastockred" value="${csasastockred }"  
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '红色预警不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '红色预警应为整数！'}]">
			                 <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
			            </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          	<TD>
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</TD>
                          	<TD  align="right" width="40%">
					            <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
                            </TD>
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
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="10%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="15%" scope=col>商品品种</TH>
                          <TH width="5%" scope=col id=qj>球镜</TH>
                          <TH width="5%" scope=col id=zj>柱镜</TH>                  
                        </TR>   
                       <s:iterator value="goodsInfoPos">
				   		<TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${bgigoodsid}" ></TD>
                        <TD>${bgigoodsid}<input type="hidden" name="goodsInfoTempPo.goodsid" value="${bgigoodsid}" /></TD>                        	
                        <TD>${bgigoodsname}<input type="hidden" name="goodsInfoTempPo.goodsname" value="${bgigoodsname}" /></TD>
                        <TD>${bgibrandname}<input type="hidden" name="goodsInfoTempPo.brandnames" value="${bgibrandname}" /></TD>
                        <TD>${bgisph }<input type="hidden" name="goodsInfoTempPo.sphs" value="${bgisph}" /></TD>
                        <TD>${bgicyl }<input type="hidden" name="goodsInfoTempPo.cyls" value="${bgicyl}" /></TD>                                                                    
                        </TR>
				   		</s:iterator>                                   
                      </TBODY>
                    </TABLE>
                	
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background="${ctx}/img/pic/tab_bg.gif"><IMG height=1  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>