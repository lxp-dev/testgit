<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>折射率维护</title>
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

	function clean(){
        $('textarea[clean=clean]').each(function(){
            $(this).val('');
        });
	}
	function preview(){
		if(!$("#birthdaycontent").val()){
			alert("请填写短信内容！");
			return;
		} 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
        showPopWin("initNoteTemplatePreview.action",237,418,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【短信预览】";
	}
	function checkLen(name)
	{
		
		if($(name).attr("checked")==true)
		{
			var ss=$(name).val();
			$("#len"+ss).show();
			
		}else
		{
			var ss=$(name).val();
			$("#len"+ss).hide();
		}
	}
	function save(){
	if(checkForm(document.all.noteTemplateForm)){	
		if(!$("#bntname").val()){
			alert("请选择短信类型！");
			return;
		} 
	
		if(!$("#birthdaycontent").text()){
			alert("请填写短信内容！");
			return;
		}  
		if($("#bntname").val()==13)
		{		
			var ch=false;	
			$('input[name="throwType"]:checked').each(function()
			{    
				if(!$("#qq"+$(this).val()).val())
				{
					alert("数量必须填写!");
					$("#qq"+$(this).val()).focus();
					ch=true;
					return false;										
				}  				   
  			})
  			if(ch)
  			{
  				return;
  			}
  			
			
			var rad=$('input:radio[name="noteTemplatePo.bntsendtype"]:checked').val();
			if(rad==null)
			{
                alert("请选择发送方式 !");
                return;
            }
            if($("#bntsendtime").val()=="")
            {
            	alert("请选择短信发送时间 !");
            	$("#bntsendtime").focus();
                return;
            } 
            if($("#bntsendhour").val()=="")
            {
            	alert("请选择短信发送具体时间 !");
            	$("#bntsendhour").focus();
                return;
            }                         
		}  
		$('#submitButton').removeAttr("onclick"); 
		noteTemplateForm.action = "noteTemplateInsert.action";
		noteTemplateForm.submit();
		
	}
}

	/**  
	 * 在光标的位置插入图片  
	 * @param {Object} myField  
	 * @param {Object} myValue  
	 */  
	function AddOnPos(myField, myValue)   
	{   
	    //IE support   
	    if (document.selection)   
	    {   
	    myField.focus();   
	    sel = document.selection.createRange();   
	    myValue = "%"+myValue+"%";   
	    sel.text = myValue;   
	    sel.select();   
	    }   
	    //MOZILLA/NETSCAPE support   
	    else if (myField.selectionStart || myField.selectionStart == '0')   
	    {   
	    var startPos = myField.selectionStart;   
	    var endPos = myField.selectionEnd;   
	    // save scrollTop before insert   
	    var restoreTop = myField.scrollTop;   
	    myValue = "%"+myValue+"%";   
	    myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring(endPos,myField.value.length);   
	    if (restoreTop > 0)   
	    {   
	    // restore previous scrollTop   
	    myField.scrollTop = restoreTop;   
	    }   
	    myField.focus();   
	    myField.selectionStart = startPos + myValue.length;   
	    myField.selectionEnd = startPos + myValue.length;   
	    } else {   
	    myField.val(myField.val()+myValue);
	    myField.focus();   
	    }   
	} 
	
	function emptyContent(obj){
		$("#birthdaycontent").text('');
		$("div[group=type]").hide();
		$("div[group=type][id="+$(obj).val()+"]").show();

		if(obj.value=='11')
		{
			$("table[id=data1]").show();
		}else
		{
			$("table[id=data1]").hide();
		}
		if(obj.value=='13')
		{
			$("table[id=data13]").show();
			$("#explain13").show();
		}else
		{
			$("table[id=data13]").hide();
			$("#explain13").hide();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="noteTemplateForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="fnpidpage" name="fnpidpage" value="${requestScope.fnpidpage}">
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
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="5%" height="26" class="table_body">短信类型 </TD>
			               <TD class="table_none" width="10%">
			               <select clean=clean id="bntname" name="noteTemplatePo.bntname" onchange="emptyContent(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先选择短信类型！'}]">
	                          <option value="">----请选择----</option>
	                          <s:iterator value="noteTypeList">
	                              <option value="${bnttypeid }">${bnttypename}</option>
	                          </s:iterator>
                          </select>
                          <label style="color:red;">&nbsp;*</label>
			              </TD>		
			              <td class="table_none" colspan="2"><input type="checkbox" name="noteTemplatePo.bntautosend" />&nbsp;&nbsp;设置为默认发送模版</td>	              
                        </TR>
                        <TR>
						   <TD width="5%" height="26" class="table_body">短信内容 </TD>
			               <TD class="table_none" width="50%" colspan="3">
			                  <textarea clean=clean id="birthdaycontent" name="noteTemplatePo.bntcontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [1001]}, 'Message' : '短信内容不能超过1000字！'}]" ></textarea>
			               </TD>						
                        </TR>
                      </TBODY>
                    </TABLE>
 					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="data1" style="display: none;">
                      <TBODY>
                        <TR>
						   <TD width="5%" height="26" class="table_body">短信发送时间 </TD>
			               <TD class="table_none" width="50%" colspan="3">
			               <input type="radio" name="data" value="1" checked="checked">当天<input type="radio" value="2" name="data">前一天
			               			               <select clean=clean id="data2" name="data2" >
	                          <option value="">----请选择----</option>
	                          	  <option value="6:00">6:00</option>
	                              <option value="7:00">7:00</option>
	                              <option value="8:00">8:00</option>
	                              <option value="9:00">9:00</option>
	                              <option value="10:00">10:00</option>
	                              <option value="11:00">11:00</option>
	                              <option value="12:00">12:00</option>
	                              <option value="13:00">13:00</option>
	                              <option value="14:00">14:00</option>
	                              <option value="15:00">15:00</option>
	                              <option value="16:00">16:00</option>
	                              <option value="17:00">17:00</option>
	                              <option value="18:00">18:00</option>
	                              <option value="19:00">19:00</option>
	                              <option value="20:00">20:00</option>
	                              <option value="21:00">21:00</option>
	                              <option value="22:00">22:00</option>
                          </select>

			              </TD>		
						
                        </TR>
                      </TBODY>
                    </TABLE>                   
                    <div id="10" group="type" style="display: none;">
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_tsrq_0.png" btn=btn type="button" title="投诉日期" onclick="AddOnPos($('#birthdaycontent'),'投诉日期');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="11" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="12" group="type" style="display: none;">
                    </div>
                    
                    <div id="2" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_zsjf_0.png" btn=btn type="button" title="赠送积分" onclick="AddOnPos($('#birthdaycontent'),'赠送积分');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_zsyy_0.png" btn=btn type="button" title="赠送原因" onclick="AddOnPos($('#birthdaycontent'),'赠送原因');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_zssj_0.png" btn=btn type="button" title="赠送时间" onclick="AddOnPos($('#birthdaycontent'),'赠送时间');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="3" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_sjss_0.png" btn=btn type="button" title="升级时间" onclick="AddOnPos($('#birthdaycontent'),'升级时间');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_sjhhyklb_0.png" btn=btn type="button" title="升级后会员卡类型" onclick="AddOnPos($('#birthdaycontent'),'升级后会员卡类型');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="4" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_pjdh_0.png" btn=btn type="button" title="配镜单号" onclick="AddOnPos($('#birthdaycontent'),'配镜单号');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_fknr_0.png" btn=btn type="button" title="反馈内容" onclick="AddOnPos($('#birthdaycontent'),'反馈内容');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	   
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="5" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_ygrq_0.png" btn=btn type="button" title="验光日期" onclick="AddOnPos($('#birthdaycontent'),'验光日期');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_fyrq_0.png" btn=btn type="button" title="复验日期" onclick="AddOnPos($('#birthdaycontent'),'复验日期');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="6" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_pjdh_0.png" btn=btn type="button" title="配镜单号" onclick="AddOnPos($('#birthdaycontent'),'配镜单号');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_qjmd_0.png" btn=btn type="button" title="取镜门店" onclick="AddOnPos($('#birthdaycontent'),'取镜门店');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_qjmddh_0.png" btn=btn type="button" title="取镜门店电话" onclick="AddOnPos($('#birthdaycontent'),'取镜门店电话');"/>
                        	   
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="7" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_pjdh_0.png" btn=btn type="button" title="配镜单号" onclick="AddOnPos($('#birthdaycontent'),'配镜单号');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_qjsj_0.png" btn=btn type="button" title="取镜时间" onclick="AddOnPos($('#birthdaycontent'),'取镜时间');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <div id="8" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_pjdh_0.png" btn=btn type="button" title="配镜单号" onclick="AddOnPos($('#birthdaycontent'),'配镜单号');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_yjdh_0.png" btn=btn type="button" title="邮寄单号" onclick="AddOnPos($('#birthdaycontent'),'邮寄单号');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_yjgs_0.png" btn=btn type="button" title="邮寄公司" onclick="AddOnPos($('#birthdaycontent'),'邮寄公司');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        	   
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>

                    <div id="9" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_pjdh_0.png" btn=btn type="button" title="配镜单号" onclick="AddOnPos($('#birthdaycontent'),'配镜单号');"/>
                        		<img src="${ctx}/img/newbtn/btn_addxiaoshoumendian_0.png" btn=btn type="button" title="销售门店" onclick="AddOnPos($('#birthdaycontent'),'销售门店');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_ssje_0.png" btn=btn type="button" title="实收金额" onclick="AddOnPos($('#birthdaycontent'),'实收金额');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_hqjf_0.png" btn=btn type="button" title="获取积分" onclick="AddOnPos($('#birthdaycontent'),'获取积分');"/>
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    
                    <div id="13" group="type" style="display: none;">
                    <table width="100%">
                      <TBODY>
                        <TR>
                        	<td>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_gkxm_0.png" btn=btn type="button" title="顾客姓名" onclick="AddOnPos($('#birthdaycontent'),'顾客姓名');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_xb_0.png" btn=btn type="button" title="性别" onclick="AddOnPos($('#birthdaycontent'),'性别');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_pjdh_0.png" btn=btn type="button" title="配镜单号" onclick="AddOnPos($('#birthdaycontent'),'配镜单号');"/>
                        		
                        		<img src="${ctx}/img/newbtn/btn_pqlx_0.jpg" btn=btn type="button" title="抛弃类型" onclick="AddOnPos($('#birthdaycontent'),'抛弃类型');"/>
                        		<img src="${ctx}/img/newbtn/btn_spmc_0.jpg" btn=btn type="button" title="商品名称" onclick="AddOnPos($('#birthdaycontent'),'商品名称');"/>
                        		
                        		<img src="${ctx}/img/newbtn/btn_addxiaoshoumendian_0.png" btn=btn type="button" title="销售门店" onclick="AddOnPos($('#birthdaycontent'),'销售门店');"/>
                        		<img src="${ctx}/img/newbtn/btn_dxmb_mddh_0.png" btn=btn type="button" title="门店电话" onclick="AddOnPos($('#birthdaycontent'),'门店电话');"/>
                        		
                        	    
                        	</td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>
                    
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="data13" style="display: none;">
                      <TBODY>
                        <TR>
						   <TD width="5%" height="26" class="table_body">抛弃类型 </TD>
			               <TD class="table_none" width="50%" colspan="3">
			               <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
				               	<tr>
					               	<td width="10%">
					               		<input type="checkbox" name="throwType" value="1"  onclick="checkLen(this)" >日抛
					               	</td>
					               	<td  id="len1" style="display:none;">
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input  id="qq1"  type="text" name="noteTemplatePo.bntdaythrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]" >
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="2"  onclick="checkLen(this)">周抛
					               	</td>
					               	<td id="len2" style="display:none;">
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input id="qq2"   type="text" name="noteTemplatePo.bntweekthrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="9" onclick="checkLen(this)">双周抛
					               	</td>
					               	<td id="len9" style="display:none;">
					               		数量: &nbsp;&nbsp;&nbsp;
					               
					               		<input id="qq9"  type="text" name="noteTemplatePo.bntbiweeklythrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="3" onclick="checkLen(this)">月抛
					               	</td>
					               	<td  id="len3" style="display:none;">
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input id="qq3"  type="text" name="noteTemplatePo.bntmonththrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="4" onclick="checkLen(this)">季抛
					               	</td>
					               	<td id="len4" style="display:none;" >
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input id="qq4"   type="text" name="noteTemplatePo.bntseasonthrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="5" onclick="checkLen(this)">半年抛
					               	</td>
					               	<td id="len5" style="display:none;" >
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input id="qq5"   type="text" name="noteTemplatePo.bnthalfyearthrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="6" onclick="checkLen(this)">年抛
					               	</td>
					               	<td id="len6" style="display:none;" >
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input id="qq6"   type="text" name="noteTemplatePo.bntyearthrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="7" onclick="checkLen(this)">RGP
					               	</td>
					               	<td id="len7" style="display:none;">
					               		数量: &nbsp;&nbsp;&nbsp;
					               	
					               		<input id="qq7"  type="text" name="noteTemplatePo.bntrgpthrownumber" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
				               	</tr>
				               	
			               </table>
			               </td>
			               </tr>
			               
			               <tr>
				               	<TD width="5%" height="26" class="table_body">发送方式 </TD>
				               	<TD class="table_none" width="50%" colspan="3" height="40">
				               		<input type="radio" name="noteTemplatePo.bntsendtype" value="1" >长周期<input type="radio" value="2" name="noteTemplatePo.bntsendtype">短周期
				               		<input type="radio" name="noteTemplatePo.bntsendtype" value="3" >长周期+短周期
				               	</TD>
			               </tr>
			               <tr>
				               	<TD width="5%" height="26" class="table_body">短信发送时间  </TD>
				               	<TD class="table_none" width="50%" colspan="3">
				               		前 &nbsp;<select clean=clean id="bntsendtime" name="noteTemplatePo.bntsendtime" >
	                          		<option value="">----请选择----</option>
	                          	  <option value="1">1</option>
	                              <option value="2">2</option>
	                              <option value="3">3</option>
	                              <option value="4">4</option>
	                              <option value="5">5</option>
	                              <option value="6">6</option>
	                              <option value="7">7</option>	                              
                          </select> &nbsp;&nbsp;天&nbsp;&nbsp;<select clean=clean id="bntsendhour" name="noteTemplatePo.bntsendhour" >
	                          <option value="">----请选择----</option>
	                          	  <option value="6:00">6:00</option>
	                              <option value="7:00">7:00</option>
	                              <option value="8:00">8:00</option>
	                              <option value="9:00">9:00</option>
	                              <option value="10:00">10:00</option>
	                              <option value="11:00">11:00</option>
	                              <option value="12:00">12:00</option>
	                              <option value="13:00">13:00</option>
	                              <option value="14:00">14:00</option>
	                              <option value="15:00">15:00</option>
	                              <option value="16:00">16:00</option>
	                              <option value="17:00">17:00</option>
	                              <option value="18:00">18:00</option>
	                              <option value="19:00">19:00</option>
	                              <option value="20:00">20:00</option>
	                              <option value="21:00">21:00</option>
	                              <option value="22:00">22:00</option>
                          </select>
				               	</TD>
			               </tr>
			               
                      </TBODY>
                    </TABLE>  
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_preview_0.png" btn=btn type="button" title="预览" onclick="preview();"/>
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
                        	  
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>注释：在短信内容中“%”代表系统标量值，请勿在内容中使用“%”。</TD>
                        </TR>
                        <TR id="explain13" style="display:none;">
                          <TD>
                            <table width="100%">
                              <tr >
                                 <div style=" color: red" >
                          1.隐形商品使用提醒: 购买隐形商品后，通过短信方式进行提醒 <br/>
                          2.数量：  指购买（对应抛弃类型）隐形商品的数量，大于等于填写的数量时，发送短信息 <br/>
                          3.长周期：指购买隐形商品（数量 * 使用天数）的最大值 <br/>
                          4.短周期：指购买隐形商品（数量 * 使用天数）的最小值 <br/>
                          5.长周期+短周期：指购买隐形数量大于等于填写的数量时发送短息 <br/>
                                </div>               
                             </tr>       
              </table>                
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>