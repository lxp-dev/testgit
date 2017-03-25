<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<style type="text/css">
    img{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);}
    /* #sysLogo{ position:absolute; z-index:12; filter:alpha(opacity:0); opacity:0;} */
    
.input_text{ width:398px; margin-right:8px; border:1px solid #e0dfde; padding-left:4px; height:30px; line-height:30px;}
.input_file{width:72px; margin-left:-76px; filter:alpha(opacity=0); opacity:0; height:30px;}
.input_file_button{ height:30px; width:67px;}
    
</style>
<title>公司维护</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

	    changeCompanyType('1');
	}); 	

   var logoPath = '';
   var backgroundPath = '';
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
           	}else if(window.navigator.userAgent.indexOf("Chrome") >= 0){
                return window.webkitURL.createObjectURL(obj.files[0]);
            }
           	
	    	return obj.value;
		}
	}
	
	var ImgObj = new Image(); 	// 建立一个图像对象
	var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|";	// 全部图片格式类型
	var FileObj,ImgFileSize,ImgWidth,ImgHeight,FileExt,ErrMsg,FileMsg,IsImg; // 全局变量图片相关属性
	// 以下为限制变量
	var AllowExt = ".jpg|.jpeg|.gif|.bmp|.png|"; 	// 允许上传的文件类型 &#320;为无限制每个扩展名后边要加一个"|" 小写字母表示
	
	var AllowImgFileSize = 30; 	// 允许上传图片文件的大小 0为无限制 单位：KB
	var AllowImgWidth = 800; 		// 允许上传的图片的宽度 &#385;为无限制　单位：px(像素)
	var AllowImgHeight = 800; 	// 允许上传的图片的高度 &#441;为无限制　单位：px(像素)
	
	ImgObj.onerror = function(){ErrMsg = '\n图片格式不正确或者图片已损坏!';}	
	function CheckExt(obj,flag){	    
	    ErrMsg = "";
		FileMsg = "";
		IsImg = false;
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt+"|") == -1){ 
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);
			return false;
		}
		obj.value = getPath(obj);
		if (flag == 'l'){
			$('#fcnLogoPath').val(flag);
	    }else if(flag == 'd'){
		    $('#fcndepground').val(flag);
	    }else{
			$('#fcnbackGroundPath').val(flag);
		}
	}
	
	function insert(){
		if(checkForm(document.all.companyNameForm)){			    
			var FileExt;
			var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|"	// 全部图片格式类型 		
       		var flag = false;
       		$('input[name=upload]').each(function(){
           		var bbdlogo = $(this).val();
           		if(bbdlogo != "" && bbdlogo != null){ 
       		        FileExt = bbdlogo.substr(bbdlogo.lastIndexOf(".")).toLowerCase();       		
			        if(AllImgExt.indexOf(FileExt+"|") == -1){ // 如果不是图片文件，则提示
				        alert("该文件类型不允许上传,请上传 " + AllImgExt + " 类型的文件\n当前文件类型为" + FileExt);
				        flag = true;
				        return false;
			        }
       		    }
            });       		
       		if (flag){
       		    return;
       		}
       		$("img").removeAttr("onclick");     		
			companyNameForm.action = "saveCompanyName.action";
			companyNameForm.submit();
		}
		
	}

    function defaultCompanyInfo(flag){
   		var showSystem = document.getElementById("showSystem");
		if (showSystem.checked){
		    showSystem = '1';
		}else{
		    showSystem = '0';
		}
			
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDefaultCompanyInfo.action?fcnID="+$('#fcnID').val()+'&flag='+flag+"&moduleID=${requestScope.moduleID}&showSystem="+showSystem+'&fcnName='+EncodeUtf8($('#fcnName').val()),400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【公司维护】";
    }

    function changeCompanyType(type){
        if (type == '1'){
            $('tr[id=wholesaleprice]').hide();
            $('#fcnwholesaleprice').attr('noValidate','noValidate');
        }else{
        	$('tr[id=wholesaleprice]').show();
        	$('#fcnwholesaleprice').removeAttr('noValidate');
        }
        $('#fcnwholesaleprice').val('');
    }

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="fcnLogoPath" name="companyNamePo.fcnLogoPath">
<input type="hidden" id="fcnbackGroundPath" name="companyNamePo.fcnbackGroundPath">
<input type="hidden" id="fcndepground" name="companyNamePo.fcndepground">
<input type="hidden" name="companyNamePo.fcnmasterorvice" value="2">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
		    <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif></TD>					
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
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
			           <TR>
                          <TD height="26" class="table_body " align="right">公司名称</TD>
                          <TD  colspan="3" class="table_none ">
                            <input class="text_input240"  id="fcnName"  name="companyNamePo.fcnName" maxlength="20" value="${companyNamePo.fcnName}">
							<label style="color:red;">&nbsp;*</label>
							
							<input type="checkbox" id="showSystem" name="companyNamePo.fcnShowSystem" ${companyNamePo.fcnShowSystem=='1' ?  'checked="checked"' : '' }>
							显示在系统logo中&nbsp;&nbsp;
							<input type="checkbox" id="loginShowSystem" name="companyNamePo.fcnLoginShowSystem" ${companyNamePo.fcnLoginShowSystem=='1' ?  'checked="checked"' : '' }>
							显示在登陆首页中&nbsp;&nbsp;
							<input type="checkbox" id="changeDptShowSystem" name="companyNamePo.fcnDepartmentShowSystem" ${companyNamePo.fcnDepartmentShowSystem=='1' ?  'checked="checked"' : '' }>
							显示在部门切换页面中&nbsp;&nbsp;
							<input type="checkbox" id="fcnLoginShowFooter" name="companyNamePo.fcnLoginShowFooter" ${companyNamePo.fcnLoginShowFooter=='1' ?  'checked="checked"' : '' }>
							登录后显示页脚&nbsp;&nbsp;&nbsp;&nbsp;
							左边距：<input class="text_input40"  id="fcnleftnum"  name="companyNamePo.fcnleftnum" maxlength="3" value="${companyNamePo.fcnleftnum}"  validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '左边距值必须是整数！'}]">
							<br /> <font color="red">(公司名称涉及登陆页面、部门选择、主页、报表4部分的更换。 )</font>
                          </TD>
					   </TR>
					   <TR>
                          <TD height="26" class="table_body " align="right" width="10%">所属区域</TD>
                          <TD class="table_none">
                           	<select id="fcnregionid" name="companyNamePo.fcnregionid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属区域！'}]">
                            	<option value="">----请选择----</option>
                            	<s:iterator value="regionPos">
                            		<option ${companyNamePo.fcnregionid eq fcnjrid ? 'selected="selected"' : '' } value="${fcnjrid }">${fcnjrname }</option>
                            	</s:iterator>
                            </select>
                            <label style="color:red;">&nbsp;*</label>
                          </TD>
					   </TR> 
					   <TR>
                          <TD height="26" class="table_body " align="right">公司电话</TD>
                          <TD  colspan="3" class="table_none ">
                          	<input class="text_input120" type="text" value="${companyNamePo.fcnPhone }" id="fcnPhone" name="companyNamePo.fcnPhone" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '请重新填写公司电话！'}]"><label style="color:red;">&nbsp;*&nbsp;</label>			           
                          </TD>
					   </TR> 
					   <TR>
                          <TD height="26" class="table_body " align="right">法人</TD>
                          <TD  colspan="3" class="table_none ">
                          	<input class="text_input100" type="text" maxlength="15" id="fcnlegalperson" name="companyNamePo.fcnlegalperson" value="${companyNamePo.fcnlegalperson }"/>			           
                          </TD>
					   </TR> 
					   <TR>
                          <TD height="26" class="table_body " align="right">手机号码</TD>
                          <TD  colspan="3" class="table_none ">
                          	<input class="text_input120" type="text" id="fcnlegalpersonphone" name="companyNamePo.fcnlegalpersonphone" value="${companyNamePo.fcnlegalpersonphone }" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneOrNull, 'Message' : '手机号码格式不正确！'}]">
                          </TD>
					   </TR>
					   
					   <TR>
                         <TD height="26" class="table_body " align="right">默认采购收货地址</TD>
                         <TD class="table_none " colspan="5">
                         	<input class="text_input200" maxlength="100" type="text" name="companyNamePo.fcntakeaddress" value="${companyNamePo.fcntakeaddress }" style="width: 600">
                         <br/><font color="red">(此项将打印在采购订单地址栏中。)</font>
                         </TD>
                       </TR>
                       <TR>
                         <TD height="26" class="table_body " align="right">默认采购收货联系人</TD>
                         <TD class="table_none " colspan="5"><input class="text_input160" maxlength="10" type="text" name="companyNamePo.fcntakeperson" value="${companyNamePo.fcntakeperson }"
      validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [16]}, 'Message' : '收货电话不能大于15字符'}]">
      					 <br/><font color="red">(此项将打印在采购订单收货人中。)</font>
      					</TD>
                       </TR>
                       <TR>
                         <TD height="26" class="table_body " align="right">默认采购收货电话</TD>
                         <TD class="table_none " colspan="5"><input class="text_input160" maxlength="13" type="text" name="companyNamePo.fcntakephone" value="${companyNamePo.fcntakephone }"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [16]}, 'Message' : '收货电话不能大于15字符'}]">
                         <br/><font color="red">(此项将打印在采购订单联系电话中。)</font>
                         </TD>
                       </TR>
                       <TR>
                          <TD height="26" class="table_body " align="right">默认采购收货传真</TD>
                          <TD class="table_none " colspan="5"><input class="text_input160" maxlength="13" type="text" name="companyNamePo.fcntakeportraiture" value="${companyNamePo.fcntakeportraiture }"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [16]}, 'Message' : '收货传真不能大于15字符'}]">
                            <br/><font color="red">(此项将打印在采购订单收货传真中。)</font> 
                          </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" class="table_body " align="right">报表表头显示名称</TD>
                          <TD  colspan="3" class="table_none ">
                          	<input class="text_input120" type="text" id="fcnreportshowname" name="companyNamePo.fcnreportshowname" value="${companyNamePo.fcnreportshowname }" maxlength="40">
                          </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" class="table_body " align="right">调拨金额</TD>
                          <TD  colspan="3" class="table_none ">
                          	<input type="radio" id="companytype" name="companyNamePo.fcncompanytype" value="1" ${(companyNamePo.fcncompanytype eq '1' || empty(companyNamePo.fcncompanytype)) ? 'checked="checked"' : '' } onclick="changeCompanyType('1')">向本公司调拨时，默认填写成本价
                          	
                          	<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                          	<input type="radio" id="companytype2" name="companyNamePo.fcncompanytype" value="2" ${companyNamePo.fcncompanytype eq '2' ? 'checked="checked"' : '' } onclick="changeCompanyType('2')">向本公司调拨时，需要手工填写批发价
                            </c:if>
                          </TD>
					   </TR>
					   
					   <TR id="wholesaleprice">
                          <TD height="26" class="table_body " align="right">批发价比例</TD>
                          <TD  colspan="3" class="table_none ">
                          	<input class="text_input120" type="text" id="fcnwholesaleprice" name="companyNamePo.fcnwholesaleprice" value="${companyNamePo.fcnwholesaleprice}" maxlength="10" noValidate="noValidate" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写批发价比例！'}]">
                          	<label style="color:red;">用于设置向加盟商的门店调货时的批发金额，计算公式：批发金额  = 基础信息中的批发价 * 批发价比例</label>
                          </TD>
					   </TR>
					   					   
					   <TR>
                          <TD height="26" class="table_body " align="right">系统logo</TD>
                          <TD colspan="3" class="table_none ">
                           <li class="horizontal_onlyRight">
                             <input type="file" name="upload" id="sysLogo" style="width: 70%" onchange="CheckExt(this,'l');">
                           </li> 
                           <li class="horizontal_onlyRight">
                             <label style="color:red;">&nbsp;&nbsp;&nbsp;尺寸&nbsp;:&nbsp;700&nbsp;*&nbsp;70</label>
                           </li> 
                          </TD>
					   </TR>
				   
                       <TR>
                          <TD height="26" class="table_body " align="right">背景图</TD>
                          <TD colspan="3" class="table_none ">
                          <li class="horizontal_onlyRight">
                             <input type="file" name="upload" id="bgLogo" style="width: 70%" onchange="CheckExt(this,'b');">
                          </li>   
                          <li class="horizontal_onlyRight">    
                             <label style="color:red;">&nbsp;&nbsp;&nbsp;&nbsp;尺寸&nbsp;:&nbsp;1&nbsp;*&nbsp;70</label>
                          </li>                           
                          </TD>
					   </TR>
					    <TR>
                          <TD height="26" class="table_body " align="right">部门选择背景图</TD>
                          <TD colspan="3" class="table_none ">
                           <li class="horizontal_onlyRight">
                             <input type="file" name="upload" id="depLogo" style="width: 70%" onchange="CheckExt(this,'d');">
                           </li> 
                           <li class="horizontal_onlyRight">
                             <!-- <label style="color:red;">&nbsp;&nbsp;&nbsp;尺寸&nbsp;:&nbsp;700&nbsp;*&nbsp;70</label> -->
                           </li> 
                          </TD>
					   </TR>
					   <TR>
                          <TD height="26" class="table_body " align="right">Logo图例</TD>
                          <TD colspan="3" class="table_none ">
                          <li class="horizontal_onlyRight">
                             <img src="${ctx }/img/frame/index01-eims12.jpg">
                             </li>
                          </TD>
					   </TR>						   
					   <TR>
                          <TD height="26" class="table_body " align="right">背景图例</TD>
                          <TD colspan="3" class="table_none ">
                          <li class="horizontal_onlyRight">
                             <img src="${ctx }/img/frame/index02-eims.jpg">
                             </li>
                          </TD>
					   </TR>
					   <TR>
                          <TD height="26" class="table_body " align="right">部门选择背景图例</TD>
                          <TD colspan="3" class="table_none ">
                          <li class="horizontal_onlyRight">
                             <img src="${ctx }/img/login/P11.jpg">
                             </li>
                          </TD>
					   </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="insert();">
                          </TD>
                        </TR>
                      </TBODY>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
