<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<HEAD>
<title>卡号扫描</title>
<script type='text/javascript' src='${ctx }/js/jquery/jquery-1.3.2.min.js'></script>
   <script  type="text/javascript" language="javascript">
        function f_ReadM1()
        {   //扫卡方法
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
            var text1=IcCard.rdata;	
	        IcCard.IccClosePort();
            
            
            var url = 'getCustomerInfoByHis.action';
	       	var targetpage="readEdzM1.jsp";
			 var memberid='${memberid}';
			 var pflag='${pflag}';
	       	if(text1 == '' || text1 == null){ 
				alert('请输入诊疗卡号!');
				return;
			}
            if(pflag == '0'){//'${flag}' == '0'不能向HIS读取患者信息
				parent.hidePopWin();
				parent.$("#smecimemberid").focus().val(text1);
				parent.$("#smecicustomerid").val(memberid);
				window.parent.selectCust(true);
            }else if(pflag == '1'){//'${flag}' == '1'可以向HIS读取患者信息
		           //获得卡号后跳转页面        
		   		if('${personInfoPo.bdplinkhisflag}'=='1'){
		         		selCustomerHIS(url,text1,targetpage,pflag);
		       	}else{
					parent.hidePopWin();
					parent.$("#smecimemberid").focus().val(text1);
					parent.$("#smecicustomerid").val(memberid);
					window.parent.selectCust(true);
					 
		       	}
            }
   		}
    
	    $(function(){
		    var cardno='${cardno}';
		    var memberid='${memberid}';
		    var todayjiuzhenid='${requestScope.todayjiuzhenid}';
			if(cardno!=''){
				parent.hidePopWin();
				parent.$("#smecimemberid").focus().val(cardno);
				parent.$("#smecicustomerid").val(memberid);
				parent.$("#sopoytreatmentnum").val(todayjiuzhenid);
				window.parent.selectCust(true);
				
			}
			$('#inputfocus').focus(); 
	    });
    </script>
    <style type="text/css">
        body { font-family:Verdana; font-size:18px; margin:0 auto;}
        #container {margin: 0 auto; width:1080px;overflow:hidden;}
        #font1 { font-family:Verdana; font-size:24px; color:#563455}
    </style>
</head>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body id="container">
    <object classid="clsid:0BD75DDD-D4B8-4250-AE28-54362CB8CB91"
	     id="EdzID"
	    CODEBASE="${ctx }/GetEdzID.ocx#version=1,0,0,1"  width=0 height=0 >
	</object>  
        <!--读串口的ACTIVEX控件-->
	<object classid="clsid:3ADCC782-613D-4BC7-884E-55AC492E31C0"
	    id="IcCard"
	    CODEBASE="${ctx }/IcCard.ocx#version=1,0,0,1" width=0 height=0>
	</object>    
	
    <div style="width: 1080px; height: 450px; background-color: whitesmoke; margin-right: 10px; margin-top: 0px; margin-bottom:10px; float:left; padding-left: 10px; padding-top: 10px;">
    <br/>
    <span id="font1"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 读取IC卡</span>
    <hr style="margin-left:3px; margin-right:15px; " />
      <form  style=" float:left; width: 1080px; height: 450px;">
         
           &nbsp;&nbsp;&nbsp;&nbsp;读IC卡&nbsp;&nbsp;：&nbsp;&nbsp;&nbsp;
           <input type="button" id="Button2" style="width: 84px; height: 24px; margin-left:20px; font-size:small"  value="读IC卡" onclick="f_ReadM1()" />
             
             <hr style="margin-left:3px; margin-right:15px; " />
          &nbsp;&nbsp;&nbsp;&nbsp;读到的证件ID信息是&nbsp;:&nbsp;&nbsp;
          <input  type="text" id="Text1" class="text_input200" /><br />
              <br/><br/><br/>  <br/><br/><br/>  <br/><br/><br/>  <br/><br/><br/> 
			                        通讯端口 &nbsp; 
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
          
         
      </form>
    </div> 
     ${actionErrors[0]}
</body>
</html>