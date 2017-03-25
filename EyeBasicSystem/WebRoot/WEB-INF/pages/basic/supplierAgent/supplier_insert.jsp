<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#bspid').focus();

    	var showMonth = "${brandPo.bbdsettlement }";
		if(showMonth != "2") {
	    	$("input[month=month]").hide();
	    	$("span[month=month]").hide();
		}
	});

	function showMonth() {
		if($("select[id=bspsettlement]").val() == "jxfs2") {
			$("span[month=month]").show();
			$("input[month=month]").show();
		} else {
			$("span[month=month]").hide();
			$("input[month=month]").hide();
			$("input[month=month]").val("");
		}
	}

	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
        $('textarea[clean=clean]').each(function(){
            $(this).val('');
        });
	}
	
	function save(){
		if(checkForm(document.all.supplierForm)){
	    	var goodsCategoryID = document.getElementsByName("goodsCategoryID");
	    	var check=0; 
        	for(var i=0;i <goodsCategoryID.length;i++){ 
         		if(goodsCategoryID[i].checked){ 
          			check=1; 
         		} 
        	} 
		
			var bbdsettlementmonth = $("#bspsettlementmonth").val();
			if($("#bspsettlement").val() == '2') {
				if(bbdsettlementmonth != "" && isNaN(bbdsettlementmonth) || bbdsettlementmonth.indexOf("\.") >= 0 || bbdsettlementmonth<= 0) {
					alert("月数只能输入正整数!");
					$("#bspsettlementmonth").select();
					return;
				}
			}
			
			if($("input[id=goodsCategoryID][value=4]").attr("checked")){
				if(!$("input[id=bspylicenceid]").val()){
					alert("请填写医疗器械经营许可证号!");
					$("input[id=bspylicenceid]").focus();
					return;
				}
				
				if(!$("input[id=bspylicencevalidity]").val()){
					alert("请填写医疗器械经营许可证效期!");
					$("input[id=bspylicencevalidity]").focus();
					return;
				}
			}
			
			if($("input[id=goodsCategoryID][value=1]").attr("checked") || $("input[id=goodsCategoryID][value=6]").attr("checked") || $("input[id=goodsCategoryID][value=8]").attr("checked") || $("input[id=goodsCategoryID][value=3]").attr("checked")){
				if(!$("input[id=bspglicenceid]").val()){
					alert("请填写全国工业品生产许可证号!");
					$("input[id=bspglicenceid]").focus();
					return;
				}
				
				if(!$("input[id=bspglicencevalidity]").val()){
					alert("请填写全国工业品生产许可证有效期!");
					$("input[id=bspglicencevalidity]").focus();
					return;
				}
			}
			
        	$("img").removeAttr("onclick");
			supplierForm.action = "insertSupplierAgent.action";
			supplierForm.submit();
		}
	}
	function checkSupplierId(thiz){
		$(thiz).val($(thiz).val().toUpperCase());
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bsplinksupplierid').value = json.id;
		document.getElementById('bsplinksuppliername').value = json.value;
		
		$("#bsplicenceid").val(json.bsplicenceid);
		$("#bsplicencevalidity").val(json.bsplicencevalidity);
		$("#bspylicenceid").val(json.bspylicenceid);
		$("#bspylicencevalidity").val(json.bspylicencevalidity);
		$("#bspglicenceid").val(json.bspglicenceid);
		$("#bspglicencevalidity").val(json.bspglicencevalidity);
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="">
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" /> 
<input type="hidden" name="cateid" id="cateid" value="${cateid}" />
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">供应商代码</TD>
			               <TD width="24%" class="table_none">
                            <input clean=clean class="text_input100" onkeyup="checkSupplierId(this);" maxlength="4" type="text" id="bspid" name="supplierPo.bspid" 
                            validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '供应商代码不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '供应商代码只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.EQLength, Params : [4]}, 'Message' : '供应商代码应为4位字符'}]"><label style="color:red;">&nbsp;*&nbsp;供应商代码必须为四位</label>
			               </TD>
			               <TD width="9%" height="26" class="table_body">供应商简称</TD>
			               <TD width="24%" class="table_none">
                             <input clean=clean class="text_input160" maxlength="30" type="text" id="bspsuppliername" name="supplierPo.bspsuppliername" value="${supplierPo.bspsuppliername }" onblur="$(this).val($.trim($(this).val()));" 
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '供应商简称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ObjectNameOrNULL, 'Message' : '供应商简称填写有误！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [31]}, 'Message' : '供应商简称不能大于30字符'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
			               <TD width="9%" height="26" class="table_body">供应商全称</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input200" maxlength="30" type="text" id="bspfroshort" name="supplierPo.bspfroshort" value="${supplierPo.bspfroshort}" onblur="$(this).val($.trim($(this).val()));" 
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '供应商名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ObjectNameOrNULL, 'Message' : '供应商名称填写有误！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [31]}, 'Message' : '供应商名称不能大于30字符'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
                        </TR>
                        <TR>	
                           <TD width="9%" class="table_body">所属制造商</TD>
						   <TD width="19%" height="26" align="left" class="table_none">
						   		<li class="horizontal_onlyRight">
						   		<input clean=clean id="bsplinksuppliername" class="text_input160" name="supplierPo.bsplinksuppliername" value="${supplierPo.bsplinksuppliername }" readonly="readonly" />
						   		<input clean=clean type="hidden" id="bsplinksupplierid" name="supplierPo.bsplinksupplierid" value="${supplierPo.bsplinksupplierid }"
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
							    </li>
							    <li class="horizontal_onlyRight">
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
							    </li>
							    <label style="color:red;">&nbsp;*</label>
						   </TD>		               
			               <TD width="10%" height="26" class="table_body">供应商联系人</TD>
			               <TD width="19%" class="table_none">
                             <input clean=clean class="text_input100" maxlength="16" type="text" id="bspcontactperson" name="supplierPo.bspcontactperson" value="${supplierPo.bspcontactperson }" onblur="$(this).val($.trim($(this).val()));" 
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '供应商联系人不能为空！'},{'Type' : Type.String, 'Formula' : Formula.PersonNameOrNULL, 'Message' : '供应商联系人姓名填写有误！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [17]}, 'Message' : '供应商联系人不能大于16字符'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
						   <TD height="26" class="table_body">供应商电话</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" maxlength="18" type="text" id="bspcontactphone" name="supplierPo.bspcontactphone" value="${supplierPo.bspcontactphone }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '供应商电话不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '供应商电话填写有误！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [21]}, 'Message' : '供应商电话不能大于20字符'}]"><label style="color:red;">&nbsp;*&nbsp;如：022-85123455</label>
			               </TD>
                        </TR>
                        <TR>	
			               <TD height="26" class="table_body">联系人电话</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" maxlength="18" type="text" id="bsplinkmanphonel" name="supplierPo.bsplinkmanphonel" value="${supplierPo.bsplinkmanphonel}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系人电话不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '联系人电话填写有误！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [21]}, 'Message' : '联系人电话不能大于20字符'}]"><label style="color:red;">&nbsp;*&nbsp;如：022-85123455</label>
			               </TD>
			               <TD height="26" class="table_body">供应商传真</TD>
			               <TD class="table_none" colspan="3">
                             <input clean=clean class="text_input100" maxlength="18" type="text" id="bspfax" name="supplierPo.bspfax" value="${supplierPo.bspfax }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '供应商传真不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '供应商传真填写有误！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [21]}, 'Message' : '供应商传真不能大于20字符'}]"><label style="color:red;">&nbsp;*&nbsp;如：022-85123455</label>
			               </TD>
                        </TR>
                       <TR>
			               <TD height="26" class="table_body">供应商地址</TD>
			               <TD class="table_none" colspan="5">
                             <input clean=clean class="text_input160" maxlength="50" type="text" id="bspaddress" name="supplierPo.bspaddress" value="${supplierPo.bspaddress }" style="width: 500" 
                             validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [51]}, 'Message' : '供应商地址不能大于50字符'}]">
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">三证号</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input160" maxlength="20" type="text" id="bsplicenceid" name="supplierPo.bsplicenceid" value="${supplierPo.bsplicenceid }"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '三证号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [51]}, 'Message' : '三证号不能大于50字符'}]">
			               </TD>
			              <TD height="26" class="table_body">三证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 <input id="bsplicencevalidity"
					       name="supplierPo.bsplicencevalidity" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true})" 
					        value="${supplierPo.bsplicencevalidity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '三证有效期不能为空！'}]"/>
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">医疗器械经营许可证号</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input160" maxlength="20" type="text" id="bspylicenceid" name="supplierPo.bspylicenceid" value="${supplierPo.bspylicenceid }"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [51]}, 'Message' : '医疗器械经营许可证号不能大于50字符'}]">
			               </TD>
			              <TD height="26" class="table_body">医疗器械经营许可证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 <input id="bspylicencevalidity"
					       name="supplierPo.bspylicencevalidity" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true})" 
					        value="${supplierPo.bspylicencevalidity}"/>
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">全国工业品生产许可证号</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input160" maxlength="20" type="text" id="bspglicenceid" name="supplierPo.bspglicenceid" value="${supplierPo.bspglicenceid }"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [51]}, 'Message' : '全国工业品生产许可证号不能大于50字符'}]">
			               </TD>
			              <TD height="26" class="table_body">全国工业品生产许可证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 <input id="bspglicencevalidity"
					       name="supplierPo.bspglicencevalidity" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true})" 
					        value="${supplierPo.bspglicencevalidity}"/>
			               </TD>
                        </TR>
                        <TR>
			              <TD height="62" class="table_body">备注</TD>
			               <TD class="table_none" colspan="5">
                             <textarea id="textarea" clean=clean name="supplierPo.bspremark">${supplierPo.bspremark}</textarea>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" icon='icon-save' type='button' value='保存' onClick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
	
	
	




