<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代金券新增</title> 
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		var bcctype = '${cashCouponPo.bcctype}'.split(',');
		for(var i=0; i<bcctype.length; i++){
			$('#bcctype'+bcctype[i].trim()).attr("checked","checked");
		}
		var bccexpense=$('#bccexpense').val();
		if(bccexpense==undefined||bccexpense==''){
			$('#bccexpense').val('0.00');
            return;
			}
	});
	function trim(str){ //删除左右两端的空格
　　      return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
	function save(){
		if(checkForm(document.all.glassesFrameForm)){ 
			var bcctype1=$("input[id=bcctype1]:checked").val();
			var bcctype2=$("input[id=bcctype2]:checked").val();
			var bcctype3=$("input[id=bcctype3]:checked").val();
			var bcctype4=$("input[id=bcctype4]:checked").val();
			var bcctype5=$("input[id=bcctype5]:checked").val();
		 	if(bcctype1!=undefined || bcctype2!=undefined||bcctype3!=undefined||bcctype4!=undefined||bcctype5!=undefined){
		 	}else{
              alert("消费类型不能为空!");
              return;
			}
			var bccamount=$('#bccamount').val();
			
			if(bccamount<=0.00){
	              alert("代金券金额必须大于0.00!");
	              return;
				}
			var bccexpense=$('#bccexpense').val();
			
			if(bccexpense<0.00){
	              alert("使用限制金额必须大于等于0.00!");
	              return;
				}
		    $("img").removeAttr("onclick");
			glassesFrameForm.action = "insertCashCoupon.action";
			glassesFrameForm.submit();
		}
	}


</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}" >

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						    <TD width="8%" height="26" class="table_body">代金券号</TD>
			                <TD width="23%" class="table_none">
                            <input class="text_input160" type="text" id="bcccard" maxlength="20" value="${cashCouponPo.bcccard}" name="cashCouponPo.bcccard" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写代金券号！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '代金券号应为数字或字母！'}]" >
			                <label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD width="8%" height="26" class="table_body">代金券金额</TD>
			               <TD class="table_none" valign="middle" width="23%">
                            <input class="text_input160" type="text" id="bccamount" maxlength="10" value="${cashCouponPo.bccamount}" name="cashCouponPo.bccamount" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写代金券金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的代金券金额！'}]" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}">
                            <label style="color:red;">&nbsp;*</label>
                            </TD>
			               <TD width="8%" height="26" class="table_body">有效期</TD>
			               <TD class="table_none" valign="middle" width="23%">
			               <input type="hidden" class="text_input200" id="createdate" name="createdate" value="${createDate}" >
			              <input id="bccbegindate"  
					       name="cashCouponPo.bccbegindate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'createdate\')}',maxDate:'#F{$dp.$D(\'bccenddate\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择使用开始日期！'}]" 
					       value="${cashCouponPo.bccbegindate}"/>至
					       <input id="bccenddate" 
					       name="cashCouponPo.bccenddate" 
					       type="text" class="text_input100" value="${cashCouponPo.bccenddate}" 
					       onfocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'bccbegindate\')|| $dp.$D(\'createdate\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择使用截止日期！'}]" 
					       />
                            <label style="color:red;">&nbsp;*</label>
                            </TD>			                
			             </TR>
			             <TR>
						    <TD height="26" width="8%" class="table_body">消费类型</TD>
			                <TD class="table_none" >
                            <input type="checkbox" value="1" id="bcctype1" name="cashCouponPo.bcctype">框镜
                            <input type="checkbox" value="2" id="bcctype2" name="cashCouponPo.bcctype">隐形
							<input type="checkbox" value="3" id="bcctype3" name="cashCouponPo.bcctype">辅料
							<input type="checkbox" value="4" id="bcctype4" name="cashCouponPo.bcctype">挂号
							<input type="checkbox" value="5" id="bcctype5" name="cashCouponPo.bcctype">维修费
			                <label style="color:red;">&nbsp;*</label>
			                </TD>
			                <TD width="8%" height="26" class="table_body">使用限制</TD>
			                <TD width="23%" class="table_none" valign="middle" colspan="3">
                            	<input class="text_input160" type="text" id="bccexpense" maxlength="18" value="${cashCouponPo.bccexpense}" name="cashCouponPo.bccexpense" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写使用限制金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的使用限制金额！'}]" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}">&nbsp;&nbsp;元之上使用
                           		<label style="color:red;">&nbsp;*</label>
                            </TD>
			             </TR>
			             <TR>
						    <TD width="8%" height="26" class="table_body">备注</TD>
			                <TD class="table_none" colspan="5">
			                	<textarea id="bccmark" name="cashCouponPo.bccmark" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [200]}, 'Message' : '备注不能大于200字符'}]">${cashCouponPo.bccmark}</textarea>
			               </TD>
			             </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR><td>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="document.glassesFrameForm.reset();">
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