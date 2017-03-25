<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班次维护</title>
<script>
	$(document).ready(function() {	
    	$("input:text")[0].focus();  
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	function timePart(timeStr) 
		{
            var parts;
            parts = timeStr.split(':');
            
            for (i = 0; i < parts.length; i++) {
                //如果构成时间的某个部分不是数字，则返回false
                if (isNaN(parts[i])) 
                {
                    return false;
                }
            }
            h = parts[0]; //小時
            if (h < 0 || h > 23) {
                //限制小时的范围
                return false;
            }
            if(parts.length>1)
            {
	            m = parts[1]; //分
	            
	            if (m < 0 || m > 59) {
	                //限制分钟的范围
	                return false;
	            }
            }
            return true;
        }
	function save(){
		if(checkForm(postForm))
		{
			if(timePart($("#msmworkBegin").val())==false)
			 {
			 	alert("请正确填写工作时间！");
				$("#msmworkBegin").focus();
				return;		 	
			}
			if(timePart($("#msmworkEnd").val())==false)
			 {
			 	alert("请正确填写工作时间！");
				$("#msmworkEnd").focus();
				return;		 	
			}
			$("img").removeAttr("onclick");
			postForm.action = "insertShiftMaintainPo.action";
			postForm.submit();
		}
	}
	function clean(){
		document.getElementById('mtccontentNumber').value = "";
		document.getElementById('mtccontentName').value = "";
	} 
	
	function pickedFunc()
	{       
		var mm=document.getElementById("msmworkLong").value;
		var msmworkBegin=document.getElementById("msmworkBegin").value;
		if(mm!="")
		{
			if(msmworkBegin!="")
			{
				 $dp.hide();    
		        var m = $dp.cal.getP('m');      
		        var temp=mm*60;
		        var nn =  $dp.$D('msmworkBegin',{m:temp}) ;
	
		      	 if(nn.m<10)
				{
					$('#msmworkEnd').val(nn.H+":"+"0"+nn.m);
				}else
				{
					$('#msmworkEnd').val(nn.H+":"+nn.m);
				}
			}else
			{
				alert("请先填写开始时间！");
			}
		}else
		{
			alert("请先填写时长！");
		}    	      
     }
     
     function changeTime()
	{       
		var ty=document.getElementById("msmworkLong").value;
		var msmworkBegin=document.getElementById("msmworkBegin").value;
		if(ty!="")
		{
			if(msmworkBegin!="")
			{
				 $dp.hide();    
		        var m = $dp.cal.getP('mm');      
		        var temp=ty*60;
		        var nn = $dp.$D('msmworkBegin',{m:temp}) ;
				if(nn.m<10)
				{
					$('#msmworkEnd').val(nn.H+":"+"0"+nn.m);
				}else
				{
					$('#msmworkEnd').val(nn.H+":"+nn.m);
				}
		      	 
			}
		}       	      
     }

	
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="postForm">
<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    <br/>
    
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
						   <TD width="8%" height="26" class="table_body">班次编号</TD>
			               <TD width="24%" class="table_none"><input class="text_input100" value="${shiftMaintainPo.msmshiftNumber}" name="shiftMaintainPo.msmshiftNumber" id="msmshiftNumber" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '班次编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '班次编号只允许输入整数和字母！'}]"><label style="color:red;">&nbsp;*</label></TD>
						
						  <TD width="8%" height="26" class="table_body">班次名称</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" value="${shiftMaintainPo.msmshiftName}"  name="shiftMaintainPo.msmshiftName" id="msmshiftName"  maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '班次名称不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
                          
                          <TD width="8%" height="26" class="table_body">时长</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" value="${shiftMaintainPo.msmworkLong}" name="shiftMaintainPo.msmworkLong" id="msmworkLong" onblur="if(!isNaN(this.value)) {if(this.value!=''){this.value = new Number(this.value).toFixed(2);}}"  onchange="changeTime();"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '时长不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '时长格式错误！'}]">小时<label style="color:red;">&nbsp;*</label></TD>
			            </TR>
			            
			             <TR>
						   <TD width="8%" height="26" class="table_body">工作时间</TD>
			               <TD width="24%" class="table_none"><input class="text_input100" value="${shiftMaintainPo.msmworkBegin}" name="shiftMaintainPo.msmworkBegin" id="msmworkBegin" onFocus="WdatePicker({readOnly:true, dateFmt:'HH:mm'})" onchange="changeTime();"  maxlength="10" >-<input class="text_input100" value="${shiftMaintainPo.msmworkEnd}" name="shiftMaintainPo.msmworkEnd" id="msmworkEnd" maxlength="10" onFocus="pickedFunc()" readonly="readonly"></TD>
						
						  <TD width="8%" height="26" class="table_body">&nbsp;</TD>
                          <TD width="24%" class="table_none">&nbsp;</TD>
                          
                          <TD width="8%" height="26" class="table_body">&nbsp;</TD>
                          <TD width="24%" class="table_none">&nbsp;</TD>
			            </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">	
						 	<!-- <input icon='icon-reload' type='button' value='清空' onClick="clean()"> -->
							  
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
    </BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>