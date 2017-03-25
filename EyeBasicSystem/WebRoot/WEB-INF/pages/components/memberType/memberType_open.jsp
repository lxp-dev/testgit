<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡类别维护</title>
</head>
<script>


	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/*
	function setValue(id, value){
		var json = {'id' : id, 'value' :　value};
		window.parent.openDepartmentValues(json);
		
		//parent.hidePopWin();

	}*/
	
	/**
	 *  调用页面赋值
	 */
	function setValue(){ 	         
        var chk=$('input[id=chk]');
        var objValue="";
        var count=0;
        var chktext=$("input[id=firmembertype]",window.parent.document).val();
		var chkname=$("input[id=firmembertypename]",window.parent.document).val();
		var temp=chktext.split(",");
        var t1=	chkname.split(",");
          	if(temp!="")
          	{         		
          		for(var i=0;i<temp.length;i++)
          		{	
          			var mm=true;	
          			$("input[id=chk]").each(function()
          			{
	          			if(temp[i]==$(this).attr("fmmid"))
	          			{
			              mm=false;
			           }
		           });
		           if(mm)
		           {
		           		if(objValue=="")
		           	 	{
			           		objValue="{'firmembertype':'"+temp[i]+"','firmembertypename':'"+t1[i]+"'}";
			         	}else
			         	{
			           		objValue=objValue+","+"{'firmembertype':'"+temp[i]+"','firmembertypename':'"+t1[i]+"'}";
			         	}  
			        }
          		}
		}
        for(var i=0;i<chk.length;i++)
        {
           if(chk[i].checked==true)
           {
           	 if(objValue=="")
           	 {
	           objValue=chk[i].value;
	         }else
	         {
	           objValue=objValue+","+chk[i].value;
	         }  
	         count++;          
           }
        }   
        objValue="["+objValue+"]";

        
        window.parent.openMemberTypeValues(objValue);
        
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){ 
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        
        setValue();
    }
    
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext= "";
		chktext	=$("input[id=firmembertype]",window.parent.document).val();

          $("input[id=chk]").each(function(){	
          	var temp=chktext.split(",");
          	if(temp!="")
          	{
          		for(var i=0;i<temp.length;i++)
          		{	
          			if(temp[i]==$(this).attr("fmmid"))
          			{
		              $(this).attr("checked","checked");
		           }
          		}
          	}
         	
		});
    }
    $(document).ready(function (){
		setCheckValue();
	});

    $(document).ready(function() { 
        $("img[btn=btn]").attr("style","cursor: hand;"); 
        $("img[btn=btn]").mouseover(function () { 
        $(this).attr("src",$(this).attr("src").replace("0","1")); 
        }).mouseout(function () { 
          $(this).attr("src",$(this).attr("src").replace("1","0")); 
        }); 
    });
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="isclosed" value="${requestScope.isclosed}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>           
				</TD></TR>
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
                  	<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                    
                    <c:if test="${not empty(memberManagementlist)}">

                   
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>  
                          <TH height="26" scope=col>会员卡类型名称</TH>
                          <TH height="26" scope=col>升级后会员卡类型名称</TH>
                          <TH width="25%" scope=col>积分范围</TH>
                          <TH width="10%" scope=col>默认会员卡</TH>
                          <TH width="10%" scope=col>参与优惠活动</TH>
						  </TR>
						<s:iterator value="memberManagementlist">	
							<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
								<TD height="26">
		                          	<input type="checkbox" id="chk" fmmid="${fmmid}" onClick="setValue();" value="{'firmembertype':'${fmmid}','firmembertypename':'${fmmmembername}'}">
		                        </TD>
                          <TD height="26">${fmmmembername}</TD>
                          <TD>${fmmtypeid}</TD>
                          <TD>${fmmdown}~${fmmup}</TD>
                          <TD><c:if test="${fmmsetdefault eq '1'}">默认</c:if>&nbsp;</TD>
                          <TD><c:if test="${fmmisfavorable eq '1'}">参与</c:if><c:if test="${fmmisfavorable eq '0'}">未参与</c:if>&nbsp;</TD>

							</TR>
						</s:iterator>
						
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
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