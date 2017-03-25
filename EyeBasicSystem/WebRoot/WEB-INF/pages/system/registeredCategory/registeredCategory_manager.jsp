<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="<%=request.getContextPath()%>/js/selectTransferValue.js" type="text/javascript" charset="utf-8"></script>
<script>

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
	});

	function showSelect(obj){
		if (obj.value==1) {
			document.getElementById('menus').style.display = 'none';
			document.getElementById('enumsFunction').style.display = 'none'; 
			document.getElementById('pageFunction').style.display = '';
		}else{
			document.getElementById('menus').style.display = '';
			document.getElementById('enumsFunction').style.display = ''
			document.getElementById('pageFunction').style.display = 'none';
		}
	}
	
	
	function save(){
		
		var sel1 = document.all.sel1;
		var sel2 = document.all.sel2;
		
		for(i=0;i<sel1.length;i++){
			sel1.options[i].selected = true
		}
		
		for(j=0;j<sel2.length;j++){
			sel2.options[j].selected = true
		}
		$("img").removeAttr("onclick");		
		registeredCategoryForm.action = "saveRegisteredCategoryManager.action";
		registeredCategoryForm.submit();
	}
	//移到另一个下拉列表
	function insertSelectValue(objOneName,objTwoName){
		//原Select列表
		var selOne = document.getElementById(objOneName);

		//目标Select列表
		var selTwo = document.getElementById(objTwoName);

		var nowPlace = selTwo.selectedIndex;
		if(selOne.value!="" )
		{
			if(selOne.length != 0)
			{
			
				var selOneValue = selOne.options[selOne.selectedIndex].value;
				
				var selOneName =  selOne.options[selOne.selectedIndex].text;
				
				removeSelectValueWithIndex(selOne,selOne.selectedIndex);
			
				selTwo.options.add(new Option(selOneName,selOneValue),nowPlace);
				
				if(nowPlace == -1){
					selTwo.options[selTwo.length-1].selected = true;
				}else{
					selTwo.options[nowPlace].selected = true;
					selTwo.options[nowPlace+1].selected = false;
				}
				
			}
		}
	}
	
	//向上移动
	function moveUp(targetObj){
		var selTwo = document.getElementById(targetObj);
		var nowPlace = selTwo.selectedIndex;
		//alert(nowPlace);
		if(nowPlace>0)
		{
			var nowValue = selTwo.options[nowPlace].value;
			var nowName =  selTwo.options[nowPlace].text;
			if(nowPlace != 0)
			{
				removeSelectValueWithIndex(selTwo,nowPlace);
				selTwo.options.add(new Option(nowName,nowValue),nowPlace-1);
				if(nowPlace-1 == 0)
					selTwo.options[0].selected = true;
				else
					selTwo.options[nowPlace-1].selected = true;
			}
		}
	}
	
	//向下移动
	function moveDown(targetObj){
	
		var selTwo = document.getElementById(targetObj);
		var nowPlace = selTwo.selectedIndex;
		
		if(nowPlace>=0)
		{
			var nowValue = selTwo.options[nowPlace].value;
			var nowName =  selTwo.options[nowPlace].text;
			if(nowPlace != selTwo.length){
				removeSelectValueWithIndex(selTwo,nowPlace);
				selTwo.options.add(new Option(nowName,nowValue),nowPlace+1);
				if(nowPlace == selTwo.length-1)
					selTwo.options[selTwo.length-1].selected = true;
				else
					selTwo.options[nowPlace+1].selected = true;
			}
		}
	}
	
	
	function search(){
		var feeType = document.all.feeType;
		var obj = document.all.feeTypeSel;
		
		if(feeType.value == ""){
			feeType.value = obj.options[obj.selectedIndex].value;
		}
		
		registeredCategoryForm.action = "searchRegisteredCategoryManager.action";
		registeredCategoryForm.submit();
	}
	
	function changeValue(obj){
		var feeType = document.all.feeType;
		feeType.value = obj.options[obj.selectedIndex].value;
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号类别维护</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="registeredCategoryForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						  <TD width="10%" height="30" class="table_body">挂号类型</TD>
                          <TD width="20%" class="table_none" colspan="2">
						  <select id="feeTypeSel" name="feeTypeSel" onChange="changeValue(this)">
								<option value="1">收费</option>
								<option value="2">退费</option>
						  </select>
						  <input type="hidden" value="${requestScope.feeType}" name="feeType" id="feeType" value="feeType" />
						  </TD>
						  <TD width="70%" class="table_none" >
						      <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="search()">
						  </TD>
			            </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(requestScope.feeType)}">
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="70%"  border=0>
	                      <TBODY>
	                      	<TR  height="30" class=table_title align=middle>
	                          	<TH scope=col>停用</TH>
	                          	<TH style="background-color:width;"></TH>
	                          	<TH scope=col>启用</TH>
                        	</TR>                
							<TR>
	                          <TD  width="30%" align="left">
							  	<select size="10" id="sel1" name="sel1" style="width:300px;background-color : #e9f2f7;" multiple="">
								  	<c:if test="${not empty(requestScope.stopList)}">
				                        <c:forEach items="${requestScope.stopList}" var="item" varStatus="lineNum"> 
				                        	<option value="${item.frcid}">${item.frcregisteredname}</option>
				                        </c:forEach>
			                        </c:if>
							  	</select>
							  	</TD>
								<td width="7%">
							  	<img src="${ctx }/img/newbtn/btn_qiyong_0.png" btn=btn title='启用' onClick="insertSelectValue('sel1','sel2')"><br/><br/>
								<img src="${ctx }/img/newbtn/btn_tingyong_0.png" btn=btn title='停用' onClick="insertSelectValue('sel2','sel1')">
								</td>
								<td align="left" width="30%">
								<select size="10" id="sel2" name="sel2" style="width:300px;background-color : #e9f2f7;" multiple="">
									<c:if test="${not empty(requestScope.startList)}">
				                        <c:forEach items="${requestScope.startList}" var="item" varStatus="lineNum"> 
				                        	<option value="${item.frcid}">${item.frcregisteredname}</option>
				                        </c:forEach>
			                        </c:if>
							  	</select>
							  	
							  	</TD>
							  	<td width="7%">
							  	<img src="${ctx }/img/newbtn/btn_up_0.png" btn=btn title='上' onClick="moveUp('sel2')"/><br/><br/>
								<img src="${ctx }/img/newbtn/btn_down_0.png" btn=btn title='下' onClick="moveDown('sel2')"/>
								</td>
	                        </TR>
	                      </TBODY>
	                    </TABLE>
	                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
	                      <TBODY>                        
							<TR>
	                          <TD valign="middle">
	                          <img btn=btn src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()">
	                          </TD>
	                        </TR>
	                      </TBODY>
	                    </TABLE>
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
<%@ include file="/WEB-INF/inc/message.jsp" %>
<script>
	<c:if test="${not empty(requestScope.feeType)}">
		defaultSelValue(document.all.feeTypeSel,'${requestScope.feeType}');
	</c:if>
</script>