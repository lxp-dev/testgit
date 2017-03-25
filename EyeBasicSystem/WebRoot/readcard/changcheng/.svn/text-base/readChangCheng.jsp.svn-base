<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>长城读卡器</title>
</head>
<script>

	function  f_ReadID()
	{   
        alert('HIS暂不支持返回身份证信息!');
        return; 
		
	    var iRet=0;
	    var obj=document.getElementById('Select1');
	    var index=obj.selectedIndex;
	    var text = obj.options[index].text;
	   
	    iRet=EdzID.GetEdz(text);   //获取二代证ID
	    if (iRet=="1")                                                   //返回1失败，0正常   
	    {
	        alert('读二代证失败！！！');
	    }
	    else
	    {
	        document.getElementById("scancode").value=EdzID.EdzID;           //读到的二代证ID
	        
	        var textvalue = EdzID.EdzID; 
	        gocustinfo(textvalue);
	    }
	}
	function f_ReadM1()
	{
	//打开通讯端口
	    var obj=document.getElementById('Select3');
	    var index=obj.selectedIndex;
	    var r_card =IcCard.OpenPort(index);
	   
	    if(r_card!=0)
	    {
	        alert("连接设备失败!"+r_card);
	        IcCard.IccClosePort();
	        return;
	    }
	//m1卡激活
	    r_card=IcCard.M1ActiveCard();
	    if(r_card!=0)
	    {
	        alert("激活M1卡失败:"+ r_card);
	        IcCard.IccClosePort();
	        return;
	    }    
	//m1卡校验密码
	    var isector=document.getElementById('Text2').value;
	    var ktype=document.all.Select2.value;
	    IcCard.keydata=document.all.Text4.value;	   
	    r_card = IcCard.M1CheckCardPin(isector,ktype);
	    if(r_card!=0)
	    {
	        alert("密码校验失败:"+ r_card);
	        IcCard.IccClosePort();
	        return;
	    }     
	//m1读卡
	    var iblock=document.all.Text3.value;
	    var r_card=IcCard.M1ReadCard(iblock);
	    if(r_card!=0)
	    {
	        IcCard.IccClosePort();
	        alert("读卡失败:"+ r_card);
	    }     
	    document.getElementById("scancode").value=IcCard.rdata ;	
	    var textvalue = IcCard.rdata;
	    IcCard.IccClosePort();
	      
	    gocustinfo(textvalue);
	}
	function gocustinfo(text){
	     //准备参数   
	    var url = 'getCustomerInfoByHis.action';
	  	var targetpage = '/readcard/changcheng/readChangCheng.jsp';
	 	var memberid = '${memberid}';
	 	var pflag = '${pflag}';
	  
       	  if(text == '' || text == null){ 
			   alert('请输入诊疗卡号!');
			   return; 
		  }
		  
          if(pflag == '0'){//'${flag}' == '0'不能向HIS读取患者信息
				parent.hidePopWin();
				parent.$("#smecimemberid").focus().val(text);
				parent.$("#smecicustomerid").val(memberid);
				window.parent.selectCust(true);
          }else if(pflag == '1'){//'${flag}' == '1'可以向HIS读取患者信息
	           //获得卡号后跳转页面        
	           
		   		if('${person.bdplinkhisflag}'=='1' && '${systemParameterPo.fsphisflag}' == '2'){
		   		
		         		selCustomerHIS(url,text,targetpage,pflag); 
		       	}else{
		       	
					parent.hidePopWin();
					parent.$("#smecimemberid").focus().val(text); 
					parent.$("#smecicustomerid").val(memberid);
					window.parent.selectCust(true);
		       	}
           }
	 }
	    $(function(){
	        var cardno='${cardno}';
	   		var todayjiuzhenid='${requestScope.todayjiuzhenid}';
	   		var memberid = '${memberid}'; 
			if(cardno != ''){
				parent.hidePopWin();
				parent.$("#smecimemberid").val(cardno);
				parent.$("#smecicustomerid").val(memberid);
				parent.$("#sopoytreatmentnum").val(todayjiuzhenid);
				window.parent.selectCust(true);
			}
			$('#scancode').focus(); 
	    });
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } style="overflow：none;">
<object classid="clsid:0BD75DDD-D4B8-4250-AE28-54362CB8CB91" id="EdzID" CODEBASE="<%=request.getContextPath()%>/readcard/changcheng/GetEdzID.CAB#Version=1,0,0,1" style="display: none;"></object>
<object classid="clsid:3ADCC782-613D-4BC7-884E-55AC492E31C0" id="IcCard" CODEBASE="<%=request.getContextPath()%>/readcard/changcheng/IcCard.CAB#Version=1,0,0,1" style="display: none;"></object> 
<form name="idScanForm" method="post">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID }" />
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
        <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
        	<tr>
        		<td class="table_body" width="30%" height="30">
        			卡信息
        		</td>
        		<td class="table_none" width="70%">
        			<input id="scancode" name="scancode" type="text" maxlength="26" class="text_input200" style="height: 26px;/>
           		</td>
           	</tr>          	
           </TABLE>
      </TD>
  </TR>  
  <TR>
    <TD>
        <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
        	<tr>
        		<td class="table_none" colspan="2" height="30"> 
        			<input id="Button2" type="button" value="读M1卡" onclick="f_ReadM1()" />&nbsp;&nbsp;&nbsp;&nbsp;	
        			<input id="Button1" type="button" value="读二代证ID" onclick="f_ReadID()" />
           		</td>
           	</tr>           	
           </TABLE>
      </TD>
  </TR>
  </TBODY>
</TABLE>
<div style="display:none;width: 1080px; height: 450px; background-color: whitesmoke; margin-right: 10px; margin-top: 10px; margin-bottom:10px; float:left; padding-left: 10px; padding-top: 10px;"><span id="font1"> &nbsp;&nbsp; 读二代证ID、 M1卡OCX控件测试页</span><hr style="margin-left:3px; margin-right:15px; " />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、读二代证： &nbsp;&nbsp;通讯端口 &nbsp; 
          <select id="Select1" style="width: 60px;height:20px;">
              <option value="0"  selected="selected">USB</option>          
              <option value="1">COM1</option>
              <option value="2">COM2</option>
              <option value="3">COM3</option>
              <option value="4">COM4</option>
              <option value="5">COM5</option>
              <option value="6">COM6</option>
              <option value="7">COM7</option>
              <option value="8">COM8</option>
         </select>   
          <hr style="margin-left:3px; margin-right:15px; " />
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、读M1卡：&nbsp;&nbsp;&nbsp;&nbsp;通讯端口 &nbsp; 
          <select id="Select3" style="width: 60px;height:20px;">
              <option value="0"  selected="selected">USB</option>
              <option value="1">COM1</option>
              <option value="2">COM2</option>
              <option value="3">COM3</option>
              <option value="4">COM4</option>
              <option value="5">COM5</option>
              <option value="6">COM6</option>
              <option value="7">COM7</option>
              <option value="8">COM8</option>
         </select>   
          扇区号  <input id="Text2" style="width: 50px" type="text"  value="0"/>
          块号 <input id="Text3" style="width: 50px" type="text"  value="1" />
          密钥类型 <select id="Select2" style="width: 70px;height:20px;">
                        <option value="1"  selected="selected">A密钥</option>
                        <option value="2">B密钥</option>
                   </select>   
          密钥<input id="Text4" style="width: 100px" type="text"  value="FFFFFFFFFFFF"/>
    </div>
</form>
 ${actionErrors[0]}
</body></html>