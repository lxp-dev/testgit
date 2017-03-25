<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
</head>
<script>
	function setAge(){
		document.getElementById("tableage").innerHTML =jsGetAge('${fn:substring(customerInfoPo.smecibirthday,0,10)}');
		if(document.getElementById("memberPicID")!=null){
			document.getElementById("memberPicID").src=document.getElementById("memberPicID").src+"?t="+Math.random();
		}
	}
	
	function jsGetAge(strBirthday){       
	    var returnAge;
	    var strBirthdayArr=strBirthday.split("-");
	    var birthYear = strBirthdayArr[0];
	    var birthMonth = strBirthdayArr[1];
	    var birthDay = strBirthdayArr[2];
	    
	    d = new Date();
	    var nowYear = d.getFullYear();
	    var nowMonth = d.getMonth() + 1;
	    var nowDay = d.getDate();
	    //alert(nowYear + "  " + birthYear);
	    if(nowYear == birthYear)
	    {
	        //returnAge = 0;//同年 则为0岁
	        returnAge = 1;//同年 则为0岁
	    }
	    else
	    {
	        var ageDiff = nowYear - birthYear ; //年之差
	        
	        returnAge = ageDiff;
	    }    
    return returnAge;//返回周岁年龄    
}

</script>
<!--JavaScript:window.location.href='selectOptometryInformation.action?customerID=${customerInfoPo.smecicustomerid }';-->
<body onload="setAge()"  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="dontshow" id="dontshow" value="${dontshow }" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">会员详细</TD>
                      
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectOptometryInformation.action?customerID=${customerInfoPo.smecicustomerid }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">病历信息</TD>
                      
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectVenditionInformation.action?customerID=${customerInfoPo.smecicustomerid }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">销售信息</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectReturnVisitInformation.action?customerID=${customerInfoPo.smecicustomerid }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">顾客回访</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>   
                    
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectCustomerComplainByCustomer.action?customerID=${customerInfoPo.smecicustomerid }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">顾客投诉</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>  
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='integralExpense.action?customerID=${customerInfoPo.smecicustomerid }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">积分记录</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>     
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='chuZhiKaExpense.action?customerID=${customerInfoPo.smecicustomerid }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">储值卡记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>               
                         </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR>
			              <TD  height="26" colSpan="6" class="table_body" align="center" ><b>--基本信息--</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                      </TR>
                      <c:if test="${customerInfoPo.memberPicPath!=null&&customerInfoPo.memberPicPath!=''}">
 					 <TR>
						  <TD height="26" width="8%" class="table_body " align="right">照片</TD>
			              <TD height="26" width="20%" colSpan="5"  class="table_none ">
			              <c:choose>
							<c:when test="${customerInfoPo.memberPicPath ne ''}">
								<c:choose>
									<c:when test="${fn:indexOf(customerInfoPo.memberPicPath, 'http://') ne ''}">
										<img id="memberPicID" width="125" src="${customerInfoPo.memberPicPath}" alt="">
									</c:when>
									<c:otherwise>
										<img id="memberPicID" width="125" src="${ctx}/${customerInfoPo.memberPicPath}" alt="">
									</c:otherwise>								
								</c:choose>
								</c:when>
								<c:otherwise>
									<img id="memberPicID" width="125" src="${ctx}/weixin_personcenter/default_images/person.png" alt="">
								</c:otherwise>
							</c:choose>	
			              </TD>						                  
			           </TR>  
			           </c:if>                    
                      <TR>
						  <TD height="26" width="8%" class="table_body " align="right">顾客姓名</TD>
			              <TD height="26" width="20%" class="table_none ">${customerInfoPo.smeciname}&nbsp;</TD>

						  <TD height="26" width="8%" class="table_body " align="right">顾客性别</TD>
                          <TD height="26" width="30%" class="table_none ">
                          	<c:if test="${customerInfoPo.smecisex==0}">
	                              	男
	                          </c:if>
	                          <c:if test="${customerInfoPo.smecisex==1}">
	                             	 女
	                        </c:if>&nbsp;
                          </TD>
						  <TD height="26" width="8%" class="table_body " align="right">出生日期</TD>
			              <TD height="26" width="26%" class="table_none ">
			              	${fn:substring(customerInfoPo.smecibirthday,0,10)}&nbsp;
			              </TD>
			           </TR>
                      <TR>
						  <TD height="26" class="table_body " align="right">年龄</TD>
                          <TD height="26" class="table_none " id="tableage">&nbsp;</TD>

						  <TD height="26" class="table_body " align="right">
						  	${(systemParameterPo.fspaddresstype eq '0')? '地区(3级)':'地区(5级)'}
						  	</TD>
                          <TD height="26" class="table_none ">
	                          <c:choose>
	                          	<c:when test="${(systemParameterPo.fspaddresstype eq '0')}">
	                          		${customerInfoPo.smecizone}
	                          	</c:when>
	                          	<c:when test="${(systemParameterPo.fspaddresstype ne '0')}">
		                          ${(customerInfoPo.smeciarea1name ne '')? customerInfoPo.smeciarea1name:''}
		                          ${(customerInfoPo.smeciarea2name ne '')? customerInfoPo.smeciarea2name:''}
		                          ${(customerInfoPo.smeciarea3name ne '')? customerInfoPo.smeciarea3name:''}
		                          ${(customerInfoPo.smeciarea4name ne '')? customerInfoPo.smeciarea4name:''}
		                          ${(customerInfoPo.smeciarea5name ne '')? customerInfoPo.smeciarea5name:''}                          	
	                          	</c:when>
	                          </c:choose>
                          </TD>                          
                          <TD height="26" class="table_body" align="right">关联顾客卡</TD>
                          <TD height="26" class="table_none">${customerInfoPo.smecisourcecard}&nbsp;</TD>
                     </TR> 
                     <TR>
						  <TD height="26" class="table_body" align="right">联系电话1</TD>
			              <TD height="26" class="table_none">${customerInfoPo.smeciphone}&nbsp;</TD>   							
   						  <TD height="26" class="table_body" align="right">联系电话2</TD>
			              <TD height="26" class="table_none">${customerInfoPo.smeciphone2}&nbsp;</TD>			              
			              <TD height="26" class="table_body" align="right">联系电话3</TD>
			              <TD height="26" class="table_none">${customerInfoPo.smeciphone3}&nbsp;</TD>
                     </TR> 
                       <TR>
     					  <TD height="26"  class="table_body " align="right">邮编</TD>
			              <TD height="26"  class="table_none ">${customerInfoPo.smecipostcode}&nbsp;</TD> 
						  <TD height="26"  class="table_body " align="right">职业</TD>
                          <TD height="26"  class="table_none ">${customerInfoPo.smeciworkname}&nbsp;</TD>
						  <TD height="26"  class="table_body " align="right">人群分类</TD>
			              <TD height="26"  class="table_none " >${customerInfoPo.smecipersontypename}&nbsp;</TD>
                      </TR>   
                      <TR>   
                      	  <TD height="26"  class="table_body" align="right">QQ号码</TD>
			              <TD height="26"  class="table_none" >${customerInfoPo.smeciqqnumber}&nbsp;</TD>  
                          <TD height="26"  class="table_body" align="right">来源</TD>
                          <TD height="26"  class="table_none" >${customerInfoPo.smecimemberoriginname}&nbsp;</TD>
						  <TD height="26"  class="table_body" align="right">兴趣</TD>
			              <TD height="26"  class="table_none" >
			                 <c:forEach items="${interestpolist}" var="interestpolist" varStatus="linerole">
                             	${interestpolist.flag == '1' ? interestpolist.birname : ''}
                             </c:forEach>&nbsp;
                          </TD>  
                      </TR> 
                      <TR>
                      	  <TD height="26"  class="table_body" align="right">E-Mail</TD>
			              <TD height="26"  class="table_none">${customerInfoPo.smeciemail}&nbsp;</TD>
                          <TD height="26"  class="table_body" align="right">注册门店</TD>
                          <TD height="26"  class="table_none" >${customerInfoPo.smecishopcode}&nbsp;</TD>
                          <TD height="26"  class="table_body" align="right">地址</TD>
                          <TD height="26"  class="table_none">${customerInfoPo.smeciaddress}&nbsp;</TD>
                      </TR> 
                      <TR>
                      	  <TD height="26"  class="table_body" align="right">劳模证</TD>
                          <TD class="table_none">&nbsp;${customerInfoPo.smecimodelworkerscode}</TD>
                          <TD class="table_body" align="right">身份证</TD>
                          <TD class="table_none" >&nbsp;${customerInfoPo.smeidentitycard}</TD>
                          <TD class="table_body" align="right">推荐人手机号</TD>
                          <TD class="table_none">${customerInfoPo.smecitjrphone}&nbsp;</TD>
                      </TR>  
                                                            
                     <TR>
			              <TD  height="26" colSpan="6" class="table_body" align="center" ><b>--会员卡信息--</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                      </TR>
                      <TR>
						  <TD height="26" width="8%" class="table_body" align="right">会员卡号</TD>
			              <TD height="26" width="24%" class="table_none">${customerInfoPo.smecimemberid}&nbsp;</TD>
   
						  <TD height="26" width="8%" class="table_body" align="right">会员卡名称</TD>
                          <TD height="26" width="24%" class="table_none">${customerInfoPo.fmmmembername}&nbsp;</TD>

						  <TD height="26" width="9%" class="table_body " align="right">
						  	<c:if test="${not empty(customerInfoPo.smecifmemberid) }">主卡积分</c:if>
						  	<c:if test="${empty(customerInfoPo.smecifmemberid) }">积分</c:if>
						  </TD>
                          <TD height="26" class="table_none">${customerInfoPo.smeciintegral}&nbsp;</TD>
                      </TR>
                      <TR> 
                          <TD height="26"  class="table_body" align="right">消费次数</TD>
                          <TD height="26"  class="table_none" >${customerInfoPo.smeciconsumptionnumber}&nbsp;</TD>  
	                      <TD height="26"  class="table_body" align="right">消费总金额</TD>
                          <TD height="26"  class="table_none">${customerInfoPo.smeciconsumptionprice}&nbsp;</TD>
                          <TD height="26"  class="table_body" align="right">主卡</TD>
                          <TD height="26"  class="table_none" ><c:if test="${not empty(customerInfoPo.smecifmemberid) }">${customerInfoPo.smecifmemberid}（${customerInfoPo.smecifmemberidname }）</c:if>&nbsp;</TD> 
                      </TR>
                      <TR> 
                          <TD height="26"  class="table_body" align="right">副卡</TD>
                          <TD height="26"  class="table_none" colspan="5">
                          	<s:iterator value="gxlist">
                          		${smecimemberid}（${smeciname }）&nbsp;&nbsp;
                          	</s:iterator>
                          &nbsp;
                          </TD>  
                      </TR>
                       <TR> 
                          <TD height="26"  class="table_body" align="right">备注</TD>
                          <TD height="26"  class="table_none" colspan="5">${customerInfoPo.smeciremark}&nbsp;</TD>  
                      </TR>
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