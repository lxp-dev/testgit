<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置商品名称显示样式</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});

		var fspcjjs="${systemParameterPo.fspcjj}".split(",");
		for(var i=0; i<fspcjjs.length; i++){
			$("input[id=fspcjj"+fspcjjs[i].trim()+"]").attr("checked","checked");
		}

		var fspcpjs="${systemParameterPo.fspcpj}".split(",");
		for(var i=0; i<fspcpjs.length; i++){
			$("input[id=fspcpj"+fspcpjs[i].trim()+"]").attr("checked","checked");
		}

		var fspcjps="${systemParameterPo.fspcjp}".split(",");
		for(var i=0; i<fspcjps.length; i++){
			$("input[id=fspcjp"+fspcjps[i].trim()+"]").attr("checked","checked");
		}

		var fspcyxjps="${systemParameterPo.fspcyxjp}".split(",");
		for(var i=0; i<fspcyxjps.length; i++){
			$("input[id=fspcyxjp"+fspcyxjps[i].trim()+"]").attr("checked","checked");
		}

		var fspchlys="${systemParameterPo.fspchly}".split(",");
		for(var i=0; i<fspchlys.length; i++){
			$("input[id=fspchly"+fspchlys[i].trim()+"]").attr("checked","checked");
		}

		var fspctyjs="${systemParameterPo.fspctyj}".split(",");
		for(var i=0; i<fspctyjs.length; i++){
			$("input[id=fspctyj"+fspctyjs[i].trim()+"]").attr("checked","checked");
		}

		var fspchcs="${systemParameterPo.fspchc}".split(",");
		for(var i=0; i<fspchcs.length; i++){
			$("input[id=fspchc"+fspchcs[i].trim()+"]").attr("checked","checked");
		}

		var fspclhs="${systemParameterPo.fspclh}".split(",");
		for(var i=0; i<fspclhs.length; i++){
			$("input[id=fspclh"+fspclhs[i].trim()+"]").attr("checked","checked");
		}

		var fspcsgs="${systemParameterPo.fspcsg}".split(",");
		for(var i=0; i<fspcsgs.length; i++){
			$("input[id=fspcsg"+fspcsgs[i].trim()+"]").attr("checked","checked");
		}
	});
	
	function save(){
		if(checkForm(companyNameForm)){
			$("img").removeAttr("onclick");
			companyNameForm.action = "insertSetGoodsName.action";
			companyNameForm.submit();
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="systemParameterPo.fspuuid" value="${systemParameterPo.fspuuid}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：设置商品名称显示样式 </td>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%""><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                       <TR>
                         <TD height="26" class="table_body " align="right">镜架商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_SupplierSpec" id="fspcjjB_GI_SupplierSpec" name="systemParameterPo.fspcjj">厂家型号
                         	+<input type="checkbox" value="B_GI_Spec" id="fspcjjB_GI_Spec" name="systemParameterPo.fspcjj">型号
                         	+<input type="checkbox" value="B_GI_SupplierColor" id="fspcjjB_GI_SupplierColor" name="systemParameterPo.fspcjj">厂家色号
                         	+<input type="checkbox" value="B_GI_Color1" id="fspcjjB_GI_Color1" name="systemParameterPo.fspcjj">色号
                         	+<input type="checkbox" value="B_GI_Color" id="fspcjjB_GI_Color" name="systemParameterPo.fspcjj">颜色
                         	+<input type="checkbox" value="B_GI_FrameMaterialType" id="fspcjjB_GI_FrameMaterialType" name="systemParameterPo.fspcjj">材质
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcjjB_GI_RetailPrice" name="systemParameterPo.fspcjj">标准零售价
                           	+<input type="checkbox" value="B_GI_FrameSize" id="fspcjjB_GI_FrameSize" name="systemParameterPo.fspcjj">尺寸
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">配件商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspcpjB_GI_Spec" name="systemParameterPo.fspcpj">型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcpjB_GI_RetailPrice" name="systemParameterPo.fspcpj">标准零售价
                            <br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">镜片商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Sph" id="fspcjpB_GI_Sph" name="systemParameterPo.fspcjp" }>球镜
                         	+<input type="checkbox" value="B_GI_Cyl" id="fspcjpB_GI_Cyl" name="systemParameterPo.fspcjp" }>柱镜
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcjpB_GI_RetailPrice" name="systemParameterPo.fspcjp" }>标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">隐形镜片商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Sph" id="fspcyxjpB_GI_Sph" name="systemParameterPo.fspcyxjp" >球镜
                         	+<input type="checkbox" value="B_GI_Cyl" id="fspcyxjpB_GI_Cyl" name="systemParameterPo.fspcyxjp" >柱镜
                         	+<input type="checkbox" value="B_GI_Color" id="fspcyxjpB_GI_Color" name="systemParameterPo.fspcyxjp">颜色
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcyxjpB_GI_RetailPrice" name="systemParameterPo.fspcyxjp" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">护理液类商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspchlyB_GI_Spec" name="systemParameterPo.fspchly" >型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspchlyB_GI_RetailPrice" name="systemParameterPo.fspchly" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">太阳镜商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_SupplierSpec" id="fspctyjB_GI_SupplierSpec" name="systemParameterPo.fspctyj" >厂家型号
                         	+<input type="checkbox" value="B_GI_Spec" id="fspctyjB_GI_Spec" name="systemParameterPo.fspctyj" >型号
                         	+<input type="checkbox" value="B_GI_SupplierColor" id="fspctyjB_GI_SupplierColor" name="systemParameterPo.fspctyj" >厂家色号
                         	+<input type="checkbox" value="B_GI_Color1" id="fspctyjB_GI_Color1" name="systemParameterPo.fspctyj" >色号
                         	+<input type="checkbox" value="B_GI_Color" id="fspctyjB_GI_Color" name="systemParameterPo.fspctyj" >颜色
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspctyjB_GI_RetailPrice" name="systemParameterPo.fspctyj" >标准零售价
                           	+<input type="checkbox" value="B_GI_FrameSize" id="fspctyjB_GI_FrameSize" name="systemParameterPo.fspctyj">尺寸
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">耗材商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspchcB_GI_Spec" name="systemParameterPo.fspchc" >型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspchcB_GI_RetailPrice" name="systemParameterPo.fspchc" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">老花镜商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Sph" id="fspclhB_GI_Sph" name="systemParameterPo.fspclh" >球镜
                         	+<input type="checkbox" value="B_GI_Spec" id="fspclhB_GI_Spec" name="systemParameterPo.fspclh" >型号
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspclhB_GI_RetailPrice" name="systemParameterPo.fspclh" >标准零售价
                           	+<input type="checkbox" value="B_GI_FrameSize" id="fspclhB_GI_FrameSize" name="systemParameterPo.fspclh">尺寸
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR>
                         <TD height="26" class="table_body " align="right">视光商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	商品名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspcsgB_GI_Spec" name="systemParameterPo.fspcsg">型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcsgB_GI_RetailPrice" name="systemParameterPo.fspcsg">标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>
    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
