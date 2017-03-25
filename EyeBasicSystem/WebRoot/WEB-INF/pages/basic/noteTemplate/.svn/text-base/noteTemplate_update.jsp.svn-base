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
    	if('${noteTemplatePo.bnttypeid}'=='11'){
			$("table[id=data1]").show();
        }
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
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
			if(!$("#birthdaycontent").text()){
				alert("请填写短信内容！");
				return;
			}

			if($("#bnttypeid").val()==13)
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
	            	alert("请选择短信发送具体时间!");
	            	$("#bntsendhour").focus();
	                return;
	            }                     
			}
			
			
			$('img').removeAttr("onclick"); 
			noteTemplateForm.action = "noteTemplateUpdate.action";
			noteTemplateForm.submit();
		}
	}
	
	function reload(){
		document.noteTemplateForm.reset();
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="noteTemplateForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="fnpidpage" name="fnpidpage" value="${requestScope.fnpidpage}">
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
						   <TD width="5%" height="26" class="table_body">短信类型 </TD>
			               <TD class="table_none" width="10%">
			               <input type="hidden" name="noteTemplatePo.bntid" value="${noteTemplatePo.bntid }">
			               <input type="hidden" id="bnttypeid" name="noteTemplatePo.bnttypeid" value="${noteTemplatePo.bnttypeid }">
			               
			               <input type="hidden" name="noteTemplatePo.bntname" value="${noteTemplatePo.bntname2 }">
                             ${noteTemplatePo.bntname}
                           </TD>						
                          <td class="table_none" colspan="2"><input type="checkbox" name="noteTemplatePo.bntautosend" ${noteTemplatePo.bntautosend == '1' ? 'checked="checked"' : '' }/>&nbsp;&nbsp;设置为默认发送模版</td>
                        </TR>
                        <TR>
						   <TD width="5%" height="26" class="table_body">短信内容 </TD>
			               <TD class="table_none" width="50%" colspan="3">
			                  <textarea clean=clean id="birthdaycontent" name="noteTemplatePo.bntcontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [1001]}, 'Message' : '短信内容不能超过1000字！'}]" >${noteTemplatePo.bntcontent }</textarea>
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
                    <c:if test="${noteTemplatePo.bnttypeid eq '10'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '11'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '12'}">
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '2'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '3'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '4'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '5'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '6'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '7'}">
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
                    </c:if>
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '8'}">
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
                    </c:if>

                    <c:if test="${noteTemplatePo.bnttypeid eq '9'}">
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
                    </c:if>
                    
                    
                    <c:if test="${noteTemplatePo.bnttypeid eq '13'}">
                  
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
                   
                    
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="data13" >
                      <TBODY>
                        <TR>
						   <TD width="5%" class="table_body">抛弃类型 </TD>
			               <TD class="table_none" width="50%" colspan="3">
			               <table width="100%" border=0 align=center  class="privateBorder">
				               	<tr>
					               	<td width="10%">
					               		<input type="checkbox" name="throwType" value="1" onclick="checkLen(this)"  <c:if test="${noteTemplatePo.bntdaythrow==1 }">checked="checked" </c:if> >日抛
					               	</td>
					               
					               		<c:if test="${noteTemplatePo.bntdaythrow==1 }">
						               		<td id="len1" >
						               		  	数量 &nbsp; &nbsp; &nbsp;
					               			<input type="text" id="qq1" name="noteTemplatePo.bntdaythrownumber" value="${noteTemplatePo.bntdaythrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               			</td>
					               		</c:if>
					               		<c:if test="${noteTemplatePo.bntdaythrow!=1 }">
						               		<td id="len1" style="display:none;" >
							               		  	数量 &nbsp; &nbsp; &nbsp;
						               			<input type="text" id="qq1"   name="noteTemplatePo.bntdaythrownumber" value="${noteTemplatePo.bntdaythrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
						               		</td>
					               		</c:if>
					               
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="2" onclick="checkLen(this)" <c:if test="${noteTemplatePo.bntweekthrow==1 }" >checked="checked" </c:if> >周抛
					               	</td>
					               
					               	<c:if test="${noteTemplatePo.bntweekthrow==1 }" >
					               	<td id="len2" >
							               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq2"  name="noteTemplatePo.bntweekthrownumber" value="${noteTemplatePo.bntweekthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bntweekthrow!=1 }" >
					               		<td id="len2" style="display:none;" >
							               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq2"  name="noteTemplatePo.bntweekthrownumber" value="${noteTemplatePo.bntweekthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               		</td>
					               	</c:if>
					               
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="9" onclick="checkLen(this)"  <c:if test="${noteTemplatePo.bntbiweeklythrow==1 }">checked="checked" </c:if> >双周抛
					               	</td>
					               	
					               	<c:if test="${noteTemplatePo.bntbiweeklythrow==1 }">
					               	<td id="len9"  >
							               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq9"  name="noteTemplatePo.bntbiweeklythrownumber" value="${noteTemplatePo.bntbiweeklythrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	
					               	</td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bntbiweeklythrow!=1 }">
					               	<td id="len9" style="display:none;" >
							               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq9"  name="noteTemplatePo.bntbiweeklythrownumber" value="${noteTemplatePo.bntbiweeklythrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               </td>
					               	</c:if>
					               	
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="3" onclick="checkLen(this)"  <c:if test="${noteTemplatePo.bntmonththrow==1 }">checked="checked" </c:if> >月抛
					               	</td>
					               	
					               	<c:if test="${noteTemplatePo.bntmonththrow==1 }">
						               	<td id="len3"  >
								               		  	数量 &nbsp; &nbsp; &nbsp;
						               		<input type="text" id="qq3"  name="noteTemplatePo.bntmonththrownumber" value="${ noteTemplatePo.bntmonththrownumber}" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
						               	</td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bntmonththrow!=1 }">
						               	<td id="len3" style="display:none;" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
						               		<input type="text" id="qq3"  name="noteTemplatePo.bntmonththrownumber" value="${ noteTemplatePo.bntmonththrownumber}" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
						               </td>
									</c:if>
					               	
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="4" onclick="checkLen(this)" <c:if test="${noteTemplatePo.bntseasonthrow==1 }">checked="checked" </c:if> >季抛
					               	</td>
					               	
					               	<c:if test="${noteTemplatePo.bntseasonthrow==1 }">
					               	<td id="len4" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq4"  name="noteTemplatePo.bntseasonthrownumber" value="${noteTemplatePo.bntseasonthrownumber }"  class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bntseasonthrow!=1 }">
					               	<td id="len4" style="display:none;" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq4"   name="noteTemplatePo.bntseasonthrownumber" value="${noteTemplatePo.bntseasonthrownumber }"  class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               </td>
					               	</c:if>
					               	
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="5" onclick="checkLen(this)"  <c:if test="${noteTemplatePo.bnthalfyearthrow==1 }">checked="checked" </c:if> >半年抛
					               	</td>
					               	
					               	<c:if test="${noteTemplatePo.bnthalfyearthrow==1 }">
					               	<td id="len5" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq5"   name="noteTemplatePo.bnthalfyearthrownumber" value="${noteTemplatePo.bnthalfyearthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bnthalfyearthrow!=1 }">
					               	<td id="len5" style="display:none;" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq5"  name="noteTemplatePo.bnthalfyearthrownumber" value="${noteTemplatePo.bnthalfyearthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
					               	</c:if>
					               
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="6" onclick="checkLen(this)" <c:if test="${noteTemplatePo.bntyearthrow==1 }">checked="checked" </c:if> >年抛
					               	</td>
					               	
					               	<c:if test="${noteTemplatePo.bntyearthrow==1 }">
						               	<td id="len6" >
									               		  	数量 &nbsp; &nbsp; &nbsp;
						               		<input type="text" id="qq6"  name="noteTemplatePo.bntyearthrownumber" value="${noteTemplatePo.bntyearthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
						               </td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bntyearthrow!=1 }">
						               		<td id="len6" style="display:none;" >
									               		  	数量 &nbsp; &nbsp; &nbsp;
						               		<input type="text" id="qq6"   name="noteTemplatePo.bntyearthrownumber" value="${noteTemplatePo.bntyearthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
						               		</td>
					               	</c:if>
					               	
				               	</tr>
				               	<tr>
					               	<td>
					               		<input type="checkbox" name="throwType" value="7" onclick="checkLen(this)"  <c:if test="${noteTemplatePo.bntrgpthrow==1 }">checked="checked" </c:if> >RGP
					               	</td>
					               	
					               	<c:if test="${noteTemplatePo.bntrgpthrow==1 }">
					               	<td id="len7" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text" id="qq7"  name="noteTemplatePo.bntrgpthrownumber" value="${noteTemplatePo.bntrgpthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
					               	</c:if>
					               	<c:if test="${noteTemplatePo.bntrgpthrow!=1 }">
					               	<td id="len7" style="display:none;" >
								               		  	数量 &nbsp; &nbsp; &nbsp;
					               		<input type="text"  id="qq7"  name="noteTemplatePo.bntrgpthrownumber" value="${noteTemplatePo.bntrgpthrownumber }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '数量只能为数字!'}]">
					               	</td>
					               	</c:if>
					               	</td>
				               	</tr>
				               	
			               </table>
			               </td>
			               </tr>
			               
			               <tr>
				               	<TD width="5%"  class="table_body">发送方式 </TD>
				               	<TD class="table_none" width="50%" colspan="3" height="40">
				               		<input type="radio" name="noteTemplatePo.bntsendtype" value="1"  <c:if test="${noteTemplatePo.bntsendtype==1 }"> checked="checked"</c:if> >长周期<input type="radio" value="2" <c:if test="${noteTemplatePo.bntsendtype==2 }"> checked="checked"</c:if> name="noteTemplatePo.bntsendtype">短周期
				               		<input type="radio" name="noteTemplatePo.bntsendtype" value="3"  <c:if test="${noteTemplatePo.bntsendtype==3 }"> checked="checked"</c:if>>长周期+短周期
				               	</TD>
			               </tr>
			               <tr>
				               	<TD width="5%" class="table_body">短信发送时间  </TD>
				               	<TD class="table_none" width="50%" colspan="3" align="left">
				               		前 &nbsp;<select clean=clean id="bntsendtime" name="noteTemplatePo.bntsendtime" >
	                          		<option value="">----请选择----</option>
	                          	  <option value="1"  <c:if test="${noteTemplatePo.bntsendtime==1 }"> selected="selected"</c:if> >1</option>
	                              <option value="2" <c:if test="${noteTemplatePo.bntsendtime==2 }"> selected="selected"</c:if> >2</option>
	                              <option value="3" <c:if test="${noteTemplatePo.bntsendtime==3 }"> selected="selected"</c:if> >3</option>
	                              <option value="4" <c:if test="${noteTemplatePo.bntsendtime==4 }"> selected="selected"</c:if> >4</option>
	                              <option value="5" <c:if test="${noteTemplatePo.bntsendtime==5 }"> selected="selected"</c:if> >5</option>
	                              <option value="6" <c:if test="${noteTemplatePo.bntsendtime==6 }"> selected="selected"</c:if> >6</option>
	                              <option value="7" <c:if test="${noteTemplatePo.bntsendtime==7 }"> selected="selected"</c:if> >7</option>	                              
                          </select>  &nbsp;&nbsp;天 &nbsp;&nbsp;<select clean=clean id="bntsendhour" name="noteTemplatePo.bntsendhour" >
	                          <option value="">----请选择----</option>
	                          	  <option value="6:00" <c:if test="${noteTemplatePo.bntsendhour=='6:00' }"> selected="selected"</c:if> >6:00</option>
	                              <option value="7:00" <c:if test="${noteTemplatePo.bntsendhour=='7:00' }"> selected="selected"</c:if> >7:00</option>
	                              <option value="8:00" <c:if test="${noteTemplatePo.bntsendhour=='8:00' }"> selected="selected"</c:if> >8:00</option>
	                              <option value="9:00" <c:if test="${noteTemplatePo.bntsendhour=='9:00' }"> selected="selected"</c:if> >9:00</option>
	                              <option value="10:00" <c:if test="${noteTemplatePo.bntsendhour=='10:00' }"> selected="selected"</c:if> >10:00</option>
	                              <option value="11:00" <c:if test="${noteTemplatePo.bntsendhour=='11:00' }"> selected="selected"</c:if> >11:00</option>
	                              <option value="12:00" <c:if test="${noteTemplatePo.bntsendhour=='12:00' }"> selected="selected"</c:if> >12:00</option>
	                              <option value="13:00" <c:if test="${noteTemplatePo.bntsendhour=='13:00' }"> selected="selected"</c:if> >13:00</option>
	                              <option value="14:00" <c:if test="${noteTemplatePo.bntsendhour=='14:00' }"> selected="selected"</c:if> >14:00</option>
	                              <option value="15:00" <c:if test="${noteTemplatePo.bntsendhour=='15:00' }"> selected="selected"</c:if> >15:00</option>
	                              <option value="16:00" <c:if test="${noteTemplatePo.bntsendhour=='16:00' }"> selected="selected"</c:if> >16:00</option>
	                              <option value="17:00" <c:if test="${noteTemplatePo.bntsendhour=='17:00' }"> selected="selected"</c:if> >17:00</option>
	                              <option value="18:00" <c:if test="${noteTemplatePo.bntsendhour=='18:00' }"> selected="selected"</c:if> >18:00</option>
	                              <option value="20:00" <c:if test="${noteTemplatePo.bntsendhour=='20:00' }"> selected="selected"</c:if> >20:00</option>
	                              <option value="21:00" <c:if test="${noteTemplatePo.bntsendhour=='21:00' }"> selected="selected"</c:if> >21:00</option>
	                              <option value="22:00" <c:if test="${noteTemplatePo.bntsendhour=='22:00' }"> selected="selected"</c:if> >22:00</option>
                          </select>
				               	</TD>
			               </tr>
			               
                      </TBODY>
                    </TABLE> 
                    </c:if>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_preview_0.png" btn=btn type="button" title="预览" onclick="preview();"/>
                              <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_return_0.png" btn=btn title='还原' onclick="reload()">

                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                	<br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <div>注释：在短信内容中“%”代表系统标量值，请勿在内容中使用“%”。</div>
                        </TR>
                        
                        <c:if test="${noteTemplatePo.bnttypeid eq '13'}">
                        	<TR>
                        	<div style=" color: red">
                          1.隐形商品使用提醒: 购买隐形商品后，通过短信方式进行提醒 <br/>
                          2.数量：  指购买（对应抛弃类型）隐形商品的数量，大于等于填写的数量时，发送短信息 <br/>
                          3.长周期：指购买隐形商品（数量 * 使用天数）的最大值 <br/>
                          4.短周期：指购买隐形商品（数量 * 使用天数）的最小值 <br/>
                          5.长周期+短周期：指购买隐形数量大于等于填写的数量时发送短息 <br/>
                          </div>
                        </TR>
                        </c:if>
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