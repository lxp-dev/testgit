<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导入商品库存</title>
</head>
<script>	
    function importGoods(){

        if ($('#bdpdepartmentid').val() == ''){
            alert("请选择所属部门!");
            return;
        }

        if ($('#bgiwarehouseid').val() == ''){
            alert("请选择所属仓位!");
            return;
        }
        
        if ($('#file').val() == ''){
            alert("请选择需要上传的文档!");
            return;
        }
        if (!CheckExt(document.getElementById('file'))){
            return;
        }
        if (confirm("确认为: " + $('#bdpdepartmentid').find('option:selected').text() + " 下的  " + $('#bgiwarehouseid').find('option:selected').text())){
        	$("img").removeAttr("onclick");
            importGoodsFrm.action = "importFile.action?sjtype="+$('input[name=sjtype]:checked').val();
            importGoodsFrm.submit();
            
            showLoadingBar();
        }
        
    }
    
    function printBarCode(){
        if ($('#bgiwarehouseid').val() == ''){
            alert("请先选择仓位!");
            return;
        }       
        
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initBarCodePrint.action?moduleID=${moduleID}&bgiwarehouseid="+$('#bgiwarehouseid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initBarCodePrint.action?moduleID=${moduleID}&bgiwarehouseid="+$('#bgiwarehouseid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【打印条码】";
    }
    
    function clean(){
        $('#bdpdepartmentid').val('');
        document.getElementById('bgiwarehouseid').options.length = 0;
        document.getElementById('bgiwarehouseid').options.add(new Option("----请选择----","")); 
    }
    
    function getPath(obj){
		if(obj){
	    	if (window.navigator.userAgent.indexOf("MSIE") >= 1){ 
	        	obj.select();      
	            return document.selection.createRange().text;	               
	        }
	        else if(window.navigator.userAgent.indexOf("Firefox") >= 1){	               
	        	if(obj.files){ 	                           
	            	return obj.files.item(0).getAsDataURL();
	            }
	        	return obj.value;
           	}
	    	return obj.value;
		}
	}

	var AllImgExt = ".xlsx";
	var FileExt;
	function CheckExt(obj){
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt) != -1){
	        obj.value = getPath(obj);
            return true;

		}else{
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);

			return false;
		}		
	}
	
	function changeDepartmentID(){
	    $('#'+'bgiwarehouseid').load("selWarehouseByDepartment.action?departmentID="+document.getElementById('bdpdepartmentid').value);
	}
	
	window.onload = function(){
		if (document.getElementById('bgiwarehouseid').options.length == 0){
		    document.getElementById('bgiwarehouseid').options.add(new Option("----请选择----","")); 
		}
	}
	
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }> 
<form id="importGoodsFrm" name="importGoodsFrm" method="post" action="" enctype="multipart/form-data">
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="9%" height="26" class="table_body">所属部门</TD>
	                          <TD width="24%" class="table_none">
							  	<select id="bdpdepartmentid" name="bdpdepartmentid" onChange="changeDepartmentID()">
							  		<option value="">----请选择----</option>
		     	               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}">${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
								</select><label style="color:red;">&nbsp;*&nbsp;</label>
						   </TD>
						   <TD width="9%" class="table_body">所属仓位</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
                                <select id="bgiwarehouseid" name="goodsInfoPo.bgiwarehouseid">
								</select><label style="color:red;">&nbsp;*&nbsp;选取所属部门后，才会显示所属仓位</label>
						  </TD>
                          
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">数据形式</TD>
					  		<TD height="26" class="table_none" colspan="3">
					  		    <input type="radio" id="sjtype1" name="sjtype" value="1" checked="checked">&nbsp;继续导入&nbsp;<label style="color:red;">(保留当前所属仓位下的所有库存，再导入新库存)</label>
					  		    <input type="radio" id="sjtype2" name="sjtype" value="2" >&nbsp;重新导入&nbsp;<label style="color:red;">(删除当前所属仓位下的所有库存后，再导入新库存)</label>
					  		</TD>
                        </TR>
                        
                        <tr>
                        	<TD width="15%" height="26" class="table_body">文档路径</TD>
			               	<TD width="25%" class="table_none" colspan="3">
			               	<input type="file" name="upload" id="file" style="width: 600" onchange="CheckExt(this)"><label style="color:red;">&nbsp;*&nbsp;文件格式为 .xlsx </label>
			               	</TD>
                        </tr>
                                             
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="26">
							  <td>
							  <img btn=btn src="${ctx }/img/newbtn/btn_drspkc_0.png" title='导入商品库存' onclick="importGoods();" >	
							  <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >
							  <img btn=btn src="${ctx }/img/newbtn/btn_printbarcode_0.png" title='打印条码' onclick="printBarCode();" >	
							  </td>							  
						</tr>
						
						<tr>
                        	<TD height="26" colspan="5">
                        	    <label style="color:red;"><b>导入期初库存的模板为Excel 2007，如果使用Excel 2007以前的版本，需要安装Excel 2007的兼容包！</b></label>
                            </TD>
                        </tr> 
                        
                        <tr>
                        	<TD height="26" colspan="5">
                        	    <label style="color:red;"><b>此功能页面用来新增不带批号的镜架、配件、镜片、太阳镜、耗材、老花镜、视光类商品以及不带效期和批号的隐形、护理液类商品的库存！</b></label>
                            </TD>
                        </tr>
					</table>
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<table id="loadingBar" width="100%" STYLE="display:none">
				  <tr><td height="10">&nbsp;</td></tr>
				  <tr>                         
				    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
				    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在导入数据，由于数据量较大可能需要较长时间，请耐心等候...</div>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
