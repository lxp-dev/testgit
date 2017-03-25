<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡管理</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		var goodscategoryid = '${memberManagementPo.fmmisgoodscategoryid}'.split(',');
		for(var i=0; i<goodscategoryid.length; i++){
			$('#fmmisgoodscategoryid'+goodscategoryid[i].trim()).attr("checked","checked");
		}
	});

	function save(){
		if ($('#isfavorable').attr('checked') == false){
            $('#fmdmaxdiscount').val('1.00');
            $('#isupdate').attr({'checked':'checked'});            
		}

		if(checkForm(document.all.memberManagementForm)){		
		    var fmmup=parseInt(document.all.fmmup.value);
		    var fmmdown=parseInt(document.all.fmmdown.value);
			
		    if(fmmdown>fmmup){
		      alert('积分范围下限不能大于积分范围上限');
		      document.all.fmmdown.focus();
		      return false;
		    } 
		    var fmmdiscount= parseInt(document.all.fmdmaxdiscount.value);
		    if(fmmdiscount>1||fmmdiscount<0){
		      alert('折扣必须在0-1之间');
		      document.all.fmdmaxdiscount.focus();
		      return false;
		    }  
		    $("img").removeAttr("onclick");
			memberManagementForm.action = "updateMemberManagement.action";
			memberManagementForm.submit();
		}
	}
	
	
	function toZero(obj){
		if($.trim(obj.value) == '' || isNaN(obj.value) || obj.value.indexOf('.') == 0) {
			obj.value = '';
		} else {
			obj.value = parseFloat(obj.value).toFixed(2);
		}
	}

	function yzZheKou(){
		var vl=$('#fmdmaxdiscount').val();
		if((vl>1||isNaN(vl))&&vl){
			alert("折扣有问题,请重新输入！");
			$('#fmdmaxdiscount').focus();
			$('#fmdmaxdiscount').select();
			return;
		}

		if(vl){
			$('#fmdmaxdiscount').val(parseFloat(vl).toFixed(2))
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="memberManagementForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
						   <TD width="11%" height="26" class="table_body">会员卡类型名称</TD>
			               <TD width="20%" class="table_none"><input class="text_input160" type="text"  id="fmmmembername" name="memberManagementPo.fmmmembername" value="${memberManagementPo.fmmmembername}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '会员卡不能为空！'}]"><label style="color:red;">&nbsp;*</label><input type="hidden"  id="fmmid" name="memberManagementPo.fmmid" value="${memberManagementPo.fmmid}"></TD>
						
                          
						  <TD width="14%" height="26" class="table_body">积分范围</TD>
                          <TD width="24%" class="table_none"><input class="text_input100" type="text"  id="fmmdown" name="memberManagementPo.fmmdown" value="${memberManagementPo.fmmdown}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '积分范围下限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '积分范围下限必须为整数！'}]">
                          与 <input class="text_input100" type="text"  id="fmmup" name="memberManagementPo.fmmup" value="${memberManagementPo.fmmup}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '积分范围上限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '积分范围上限必须为整数！'}]"><label style="color:red;">&nbsp;*</label></TD>
                        <TD class="table_body">升级后会员卡类型</TD>
                          <TD class="table_none">
	                          <select name="memberManagementPo.fmmtypeid" id="fmmtypeid" style="width:150">
	                             <option value="">----请选择----</option>
	                             <c:if test="${not empty(list)}">	                             
		                             <s:iterator value="list">		                              	
		                              <c:if test="${memberManagementPo.fmmid != fmmid }">	                                
		                                 <option value="${fmmid}" ${memberManagementPo.fmmtypeid == fmmid ? 'selected="selected"' : ''}>${fmmmembername}</option>
		                              </c:if>   
		                             </s:iterator>
	                             </c:if>
	                          </select>
                          </TD>
                        </TR>
                        <TR height="26">       
                          <TD class="table_body">会员升级扣除积分数</TD>
                          <TD class="table_none">
                             <input class="text_input100" type="text"  id="fmmsubintegral" name="memberManagementPo.fmmsubintegral" value="${memberManagementPo.fmmsubintegral}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写升级后扣除的积分数,积分数应为非负整数！'}]">
                             <label style="color:red;">&nbsp;*&nbsp;整数</label>
                          </TD>
                          <TD class="table_body">按商品类别设置默认折扣<br/><font color="red">&nbsp;(折扣在0-1之间)</font></TD>
                          <TD class="table_none" colspan="3">
                             <input class="text_input100" onblur="yzZheKou();" id="fmdmaxdiscount" name="memberManagementPo.fmmdiscount" value="${memberManagementPo.fmmdiscount }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'}]"  maxlength="4" >&nbsp;折&nbsp;&nbsp;&nbsp;
                             <input type="checkbox" id="isupdate" name="isupdate" value="1">&nbsp;更新所有商品类别设置默认折扣&nbsp;&nbsp;
                             <input type="checkbox" name="setdefault" value="1" ${memberManagementPo.fmmsetdefault eq '1' ? 'checked="checked"' : '' }>&nbsp;设置为默认会员卡类型
                             <input type="checkbox" id="isfavorable" name="setisfavorable" value="1" ${memberManagementPo.fmmisfavorable eq '1' ? 'checked="checked"' : '' }>&nbsp;参与优惠活动
                          </TD>
                        </TR>
                        
                        <TR height="26">
                           <TD class="table_body ">允许购买的商品</TD>
                           <TD class="table_none " colspan="5">
						   	<input type="checkbox" value="1" id="fmmisgoodscategoryid1" name="memberManagementPo.fmmisgoodscategoryid">
						   	           镜架
                            <input type="checkbox" value="2" id="fmmisgoodscategoryid2" name="memberManagementPo.fmmisgoodscategoryid">
                                                                                      配件
							<input type="checkbox" value="3" id="fmmisgoodscategoryid3" name="memberManagementPo.fmmisgoodscategoryid">
							           镜片
							<input type="checkbox" value="4" id="fmmisgoodscategoryid4" name="memberManagementPo.fmmisgoodscategoryid">
							           隐形
							<input type="checkbox" value="5" id="fmmisgoodscategoryid5" name="memberManagementPo.fmmisgoodscategoryid">
							           护理液
							<input type="checkbox" value="6" id="fmmisgoodscategoryid6" name="memberManagementPo.fmmisgoodscategoryid">
							           太阳镜
							<input type="checkbox" value="7" id="fmmisgoodscategoryid7" name="memberManagementPo.fmmisgoodscategoryid">
							           耗材     
							<input type="checkbox" value="8" id="fmmisgoodscategoryid8" name="memberManagementPo.fmmisgoodscategoryid">
							           老花镜
							<input type="checkbox" value="9" id="fmmisgoodscategoryid9" name="memberManagementPo.fmmisgoodscategoryid">
							           视光
						   </TD>
                       </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
                        	  <!-- <input icon='icon-reload' type='reset' value='重置' > -->
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
	
	
	




