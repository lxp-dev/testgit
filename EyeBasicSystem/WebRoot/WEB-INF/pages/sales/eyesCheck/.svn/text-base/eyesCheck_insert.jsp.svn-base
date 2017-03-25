<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
 
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		document.getElementById('smecimemberid').focus();
	});

	function save(){
	if(checkForm(document.all.mydriasisForm)){    
        $("img").removeAttr("onclick");
		mydriasisForm.action = "insertEyesCheck.action";
		mydriasisForm.submit();
		}
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【会员信息】";	
	}
	
	  /*   单个汉字的宽度,根据你的字体大小自行设定   */   
	  var   wordWidth   =   '14';   
	  function   setWidth()   
	  {   
		  obj   =   event.srcElement;   
		  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
	  }
	  function eyesChargePut(){
		showPopWin("","initEyesChargePutInsert.action",700,500,'',null,true);
		selectHidden();
	}


	/**
	 *查看
	 */
	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
   }


    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");   
		mydriasisForm.action = "selEyesCheckForCustomer.action";
		mydriasisForm.submit();
	}
	

	function selectCust(flag){
		if(flag){
			frameSalesForm.action="queryShopSalesMain.action";
			frameSalesForm.submit();
		}
	}
	function selectCustomer(){
	    if('${person.bdplinkhisflag}' == '1'){
	            alert('此门店已经连接HIS系统，不能查询会员!');
	            document.getElementById('smecimemberid').value= '';
	         return ;
		}
		if(document.getElementById('smecimemberid').value.trim() != ''){
			if(event.keyCode == 13){
				$("img").removeAttr("onclick");   
				mydriasisForm.action = "selEyesCheckForCustomer.action";
				mydriasisForm.submit();
			}
		}
	}
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
                    <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：眼部健康检查 
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                      UNSELECTABLE="on">眼部检查新增</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initEyesCheckSel.action;'" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">眼部检查查询</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
					
					</TR>
					
					
					</TBODY></TABLE></TD>
					
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
						  <fieldset>
							<legend><font size="2">顾客资料</font></legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td align="center">
								  <table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
									  <tr>
										<td class="table_body">
										 
										  <li class="horizontal"> 顾客卡号：
										  <input onpropertychange="setWidth()" style="text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid}"
										   onkeydown="selectCustomer();" ${systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' } validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  <input name="eyesCheckPo.sopeccustomerid" type="hidden" value="${customerInfoPo.smecicustomerid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  &nbsp;&nbsp;</li>
									    
										  <li class="horizontal">
										    <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
							              	<img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
							              </li> 
									  
										 <li class="horizontal">姓名：
										  <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smeciname" value="${customerInfoPo.smeciname}" class="text_input80" readOnly="readOnly">
										  &nbsp;&nbsp;</li>  <li class="horizontal"> 性别：
											<c:if test="${customerInfoPo.smecisex==0}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="男" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                                <c:if test="${customerInfoPo.smecisex==1}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="女" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                                <c:if test="${empty(customerInfoPo.smecisex)}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                              &nbsp;&nbsp;</li>  <li class="horizontal"> 年龄：
										   <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecibirthday" value="${customerInfoPo.fmmage}" class="text_input100" readOnly="readOnly">
										   <c:if test="${not empty(customerInfoPo.smecicustomerid)}">								  
										      &nbsp;</li>  <li class="horizontal">
										      <img btn=btn src="${ctx }/img/newbtn/btn_details_0.png" title='详情' onClick="javascript:details('${customerInfoPo.smecicustomerid}')">
										  </c:if>	</li>							
										</td>
									  </tr>
								  </table>
								</td>
							  </tr>
						  </table>
						</fieldset>	
						
						<br />		
						<fieldset>
							<legend>检查项目</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="3%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="17%" class="table_body"><div align="center">外眼</div></TD>
                                      <TD width="22%" class="table_body"><div align="center">结膜充血</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">结膜</div></TD>
                                      <TD width="21%" class="table_body"><div align="center">角膜</div></TD>
                                      <TD width="20%" class="table_body"><div align="center">泪液</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">右</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecsurfaceeyeod" style="width:100%">
                                          <option value="" selected></option>
                                          <option value="正常" ${eyesCheckPo.sopecsurfaceeyeod != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="睑外翻" ${eyesCheckPo.sopecsurfaceeyeod != '睑外翻' ? '' : 'selected=selected'}>睑外翻</option>
                                          <option value="睑内翻" ${eyesCheckPo.sopecsurfaceeyeod != '睑内翻' ? '' : 'selected=selected'}>睑内翻</option>
                                          <option value="上睑下垂" ${eyesCheckPo.sopecsurfaceeyeod != '上睑下垂' ? '' : 'selected=selected'}>上睑下垂</option>
                                          <option value="闭合不全" ${eyesCheckPo.sopecsurfaceeyeod != '闭合不全' ? '' : 'selected=selected'}>闭合不全</option>
                                          <option value="倒睫" ${eyesCheckPo.sopecsurfaceeyeod != '倒睫' ? '' : 'selected=selected'}>倒睫</option>
                                          <option value="内眦赘皮" ${eyesCheckPo.sopecsurfaceeyeod != '内眦赘皮' ? '' : 'selected=selected'}>内眦赘皮</option>
                                          <option value="眼球突出" ${eyesCheckPo.sopecsurfaceeyeod != '眼球突出' ? '' : 'selected=selected'}>眼球突出</option>
                                          <option value="睑缘炎" ${eyesCheckPo.sopecsurfaceeyeod != '睑缘炎' ? '' : 'selected=selected'}>睑缘炎</option>
                                                                  
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccongestiveod" style="width:100%">
                                          <option value="" selected></option>
                   						  <option value="正常" ${eyesCheckPo.sopeccongestiveod != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="球结膜充血+" ${eyesCheckPo.sopeccongestiveod != '球结膜充血+' ? '' : 'selected=selected'}>球结膜充血+</option>
                                          <option value="球结膜充血++" ${eyesCheckPo.sopeccongestiveod != '球结膜充血++' ? '' : 'selected=selected'}>球结膜充血++</option>
                                          <option value="球结膜充血+++" ${eyesCheckPo.sopeccongestiveod != '球结膜充血+++' ? '' : 'selected=selected'}>球结膜充血+++</option>
                                          <option value="睑结膜充血+" ${eyesCheckPo.sopeccongestiveod != '睑结膜充血+' ? '' : 'selected=selected'}>睑结膜充血+</option>
                                          <option value="睑结膜充血++" ${eyesCheckPo.sopeccongestiveod != '睑结膜充血++' ? '' : 'selected=selected'}>睑结膜充血++</option>
                                          <option value="睑结膜充血+++" ${eyesCheckPo.sopeccongestiveod != '睑结膜充血+++' ? '' : 'selected=selected'}>睑结膜充血+++</option>
                                          <option value="睫状充血" ${eyesCheckPo.sopeccongestiveod != '睫状充血' ? '' : 'selected=selected'}>睫状充血</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecnippleod" style="width:100%">
                                          <option value="" selected></option>
                   						  <option value="正常" ${eyesCheckPo.sopecnippleod != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="乳头增生" ${eyesCheckPo.sopecnippleod != '乳头增生' ? '' : 'selected=selected'}>乳头增生</option>
                                          <option value="滤泡" ${eyesCheckPo.sopecnippleod != '滤泡' ? '' : 'selected=selected'}>滤泡</option>
                                          <option value="结石" ${eyesCheckPo.sopecnippleod != '结石' ? '' : 'selected=selected'}>结石</option>
                                          <option value="水肿" ${eyesCheckPo.sopecnippleod != '水肿' ? '' : 'selected=selected'}>水肿</option>
                                          <option value="睑板瘢痕" ${eyesCheckPo.sopecnippleod != '睑板瘢痕' ? '' : 'selected=selected'}>睑板瘢痕</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccornealod" style="width:100%">
                                          <option value="" selected></option>
                  						  <option value="正常" ${eyesCheckPo.sopeccornealod != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="上皮缺损" ${eyesCheckPo.sopeccornealod != '上皮缺损' ? '' : 'selected=selected'}>上皮缺损</option>
                                          <option value="云翳" ${eyesCheckPo.sopeccornealod != '云翳' ? '' : 'selected=selected'}>云翳</option>
                                          <option value="白斑" ${eyesCheckPo.sopeccornealod != '白斑' ? '' : 'selected=selected'}>白斑</option>
                                          <option value="浸润" ${eyesCheckPo.sopeccornealod != '浸润' ? '' : 'selected=selected'}>浸润</option>
                                          <option value="瘢痕" ${eyesCheckPo.sopeccornealod != '瘢痕' ? '' : 'selected=selected'}>瘢痕</option>
                                          <option value="新生血管" ${eyesCheckPo.sopeccornealod != '新生血管' ? '' : 'selected=selected'}>新生血管</option>
                                          <option value="异物" ${eyesCheckPo.sopeccornealod != '异物' ? '' : 'selected=selected'}>异物</option>
                                          <option value="水肿" ${eyesCheckPo.sopeccornealod != '水肿' ? '' : 'selected=selected'}>水肿</option>
                                          <option value="上皮染色" ${eyesCheckPo.sopeccornealod != '上皮染色' ? '' : 'selected=selected'}>上皮染色</option>
                                          <option value="透明" ${eyesCheckPo.sopeccornealod != '透明' ? '' : 'selected=selected'}>透明</option>
                                          <option value="屈光力偏高" ${eyesCheckPo.sopeccornealod != '屈光力偏高' ? '' : 'selected=selected'}>屈光力偏高</option>
                                          <option value="规则指数异常" ${eyesCheckPo.sopeccornealod != '规则指数异常' ? '' : 'selected=selected'}>规则指数异常</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopectearosod" style="width:100%">
                                          <option value="" selected></option>
                                          <option value="Ⅰ-Ⅱ级" ${eyesCheckPo.sopectearosod != 'Ⅰ-Ⅱ级' ? '' : 'selected=selected'}>Ⅰ-Ⅱ级</option>
                                          <option value="Ⅲ级" ${eyesCheckPo.sopectearosod != 'Ⅲ级' ? '' : 'selected=selected'}>Ⅲ级</option>
                                          <option value="Ⅳ级" ${eyesCheckPo.sopectearosod != 'Ⅳ级' ? '' : 'selected=selected'}>Ⅳ级</option>
                                          <option value="Ⅴ级" ${eyesCheckPo.sopectearosod != 'Ⅴ级' ? '' : 'selected=selected'}>Ⅴ级</option>
                                          <option value="泪腺正常" ${eyesCheckPo.sopectearosod != '泪腺正常' ? '' : 'selected=selected'}>泪腺正常</option>
                                          <option value="泪腺中断" ${eyesCheckPo.sopectearosod != '泪腺中断' ? '' : 'selected=selected'}>泪腺中断</option>
                                        </select>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">左</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecsurfaceeyeos" style="width:100%">
                                          <option value="" selected></option>
                                          <option value="正常" ${eyesCheckPo.sopecsurfaceeyeos != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="睑外翻" ${eyesCheckPo.sopecsurfaceeyeos != '睑外翻' ? '' : 'selected=selected'}>睑外翻</option>
                                          <option value="睑内翻" ${eyesCheckPo.sopecsurfaceeyeos != '睑内翻' ? '' : 'selected=selected'}>睑内翻</option>
                                          <option value="上睑下垂" ${eyesCheckPo.sopecsurfaceeyeos != '上睑下垂' ? '' : 'selected=selected'}>上睑下垂</option>
                                          <option value="闭合不全" ${eyesCheckPo.sopecsurfaceeyeos != '闭合不全' ? '' : 'selected=selected'}>闭合不全</option>
                                          <option value="倒睫" ${eyesCheckPo.sopecsurfaceeyeos != '倒睫' ? '' : 'selected=selected'}>倒睫</option>
                                          <option value="内眦赘皮" ${eyesCheckPo.sopecsurfaceeyeos != '内眦赘皮' ? '' : 'selected=selected'}>内眦赘皮</option>
                                          <option value="眼球突出" ${eyesCheckPo.sopecsurfaceeyeos != '眼球突出' ? '' : 'selected=selected'}>眼球突出</option>
                                          <option value="睑缘炎" ${eyesCheckPo.sopecsurfaceeyeos != '睑缘炎' ? '' : 'selected=selected'}>睑缘炎</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccongestiveos" style="width:100%">
                                          <option value="" selected></option>
                   						  <option value="正常" ${eyesCheckPo.sopeccongestiveos != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="球结膜充血+" ${eyesCheckPo.sopeccongestiveos != '球结膜充血+' ? '' : 'selected=selected'}>球结膜充血+</option>
                                          <option value="球结膜充血++" ${eyesCheckPo.sopeccongestiveos != '球结膜充血++' ? '' : 'selected=selected'}>球结膜充血++</option>
                                          <option value="球结膜充血+++" ${eyesCheckPo.sopeccongestiveos != '球结膜充血+++' ? '' : 'selected=selected'}>球结膜充血+++</option>
                                          <option value="睑结膜充血+" ${eyesCheckPo.sopeccongestiveos != '睑结膜充血+' ? '' : 'selected=selected'}>睑结膜充血+</option>
                                          <option value="睑结膜充血++" ${eyesCheckPo.sopeccongestiveos != '睑结膜充血++' ? '' : 'selected=selected'}>睑结膜充血++</option>
                                          <option value="睑结膜充血+++" ${eyesCheckPo.sopeccongestiveos != '睑结膜充血+++' ? '' : 'selected=selected'}>睑结膜充血+++</option>
                                          <option value="睫状充血" ${eyesCheckPo.sopeccongestiveos != '睫状充血' ? '' : 'selected=selected'}>睫状充血</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecnippleos" style="width:100%">
                                          <option value="" selected></option>
                                          <option value="正常" ${eyesCheckPo.sopecnippleod != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="乳头增生" ${eyesCheckPo.sopecnippleod != '乳头增生' ? '' : 'selected=selected'}>乳头增生</option>
                                          <option value="滤泡" ${eyesCheckPo.sopecnippleod != '滤泡' ? '' : 'selected=selected'}>滤泡</option>
                                          <option value="结石" ${eyesCheckPo.sopecnippleod != '结石' ? '' : 'selected=selected'}>结石</option>
                                          <option value="水肿" ${eyesCheckPo.sopecnippleod != '水肿' ? '' : 'selected=selected'}>水肿</option>
                                          <option value="睑板瘢痕" ${eyesCheckPo.sopecnippleod != '睑板瘢痕' ? '' : 'selected=selected'}>睑板瘢痕</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccornealos" style="width:100%">
                                          <option value="" selected></option>
                  						  <option value="正常" ${eyesCheckPo.sopeccornealos != '正常' ? '' : 'selected=selected'}>正常</option>
                                          <option value="上皮缺损" ${eyesCheckPo.sopeccornealos != '上皮缺损' ? '' : 'selected=selected'}>上皮缺损</option>
                                          <option value="云翳" ${eyesCheckPo.sopeccornealos != '云翳' ? '' : 'selected=selected'}>云翳</option>
                                          <option value="白斑" ${eyesCheckPo.sopeccornealos != '白斑' ? '' : 'selected=selected'}>白斑</option>
                                          <option value="浸润" ${eyesCheckPo.sopeccornealos != '浸润' ? '' : 'selected=selected'}>浸润</option>
                                          <option value="瘢痕" ${eyesCheckPo.sopeccornealos != '瘢痕' ? '' : 'selected=selected'}>瘢痕</option>
                                          <option value="新生血管" ${eyesCheckPo.sopeccornealos != '新生血管' ? '' : 'selected=selected'}>新生血管</option>
                                          <option value="异物" ${eyesCheckPo.sopeccornealos != '异物' ? '' : 'selected=selected'}>异物</option>
                                          <option value="水肿" ${eyesCheckPo.sopeccornealos != '水肿' ? '' : 'selected=selected'}>水肿</option>
                                          <option value="上皮染色" ${eyesCheckPo.sopeccornealos != '上皮染色' ? '' : 'selected=selected'}>上皮染色</option>
                                          <option value="透明" ${eyesCheckPo.sopeccornealos != '透明' ? '' : 'selected=selected'}>透明</option>
                                          <option value="屈光力偏高" ${eyesCheckPo.sopeccornealos != '屈光力偏高' ? '' : 'selected=selected'}>屈光力偏高</option>
                                          <option value="规则指数异常" ${eyesCheckPo.sopeccornealos != '规则指数异常' ? '' : 'selected=selected'}>规则指数异常</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopectearosos" style="width:100%">
                                          <option value="" selected></option>
                                          <option value="Ⅰ-Ⅱ级" ${eyesCheckPo.sopectearosos != 'Ⅰ-Ⅱ级' ? '' : 'selected=selected'}>Ⅰ-Ⅱ级</option>
                                          <option value="Ⅲ级" ${eyesCheckPo.sopectearosos != 'Ⅲ级' ? '' : 'selected=selected'}>Ⅲ级</option>
                                          <option value="Ⅳ级" ${eyesCheckPo.sopectearosos != 'Ⅳ级' ? '' : 'selected=selected'}>Ⅳ级</option>
                                          <option value="Ⅴ级" ${eyesCheckPo.sopectearosos != 'Ⅴ级' ? '' : 'selected=selected'}>Ⅴ级</option>
                                          <option value="泪腺正常" ${eyesCheckPo.sopectearosos != '泪腺正常' ? '' : 'selected=selected'}>泪腺正常</option>
                                          <option value="泪腺中断" ${eyesCheckPo.sopectearosos != '泪腺中断' ? '' : 'selected=selected'}>泪腺中断</option>
                                        </select>
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							    <br>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="2%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="11%" class="table_body"><div align="center">前房</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">虹膜</div></TD>
                                      <TD width="16%" class="table_body"><div align="center">晶体</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">眼底</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">眼球运动</div></TD>
                                      <TD width="14%" class="table_body"><div align="center">色觉</div></TD>
                                      <TD colspan="2" class="table_body"><div align="center">眼压</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">右</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopechyphemaod" style="width:100%">
                                          	<option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopechyphemaod != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="浅前房" ${eyesCheckPo.sopechyphemaod != '浅前房' ? '' : 'selected=selected'}>浅前房</option>
											<option value="房水闪辉+" ${eyesCheckPo.sopechyphemaod != '房水闪辉+' ? '' : 'selected=selected'}>房水闪辉+</option>
											<option value="前房积脓" ${eyesCheckPo.sopechyphemaod != '前房积脓' ? '' : 'selected=selected'}>前房积脓</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecirisod" style="width:100%">
                                          	<option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopecirisod != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="瞳孔放大" ${eyesCheckPo.sopecirisod != '瞳孔放大' ? '' : 'selected=selected'}>瞳孔放大</option>
											<option value="瞳孔缩小" ${eyesCheckPo.sopecirisod != '瞳孔缩小' ? '' : 'selected=selected'}>瞳孔缩小</option>
											<option value="萎缩斑" ${eyesCheckPo.sopecirisod != '萎缩斑' ? '' : 'selected=selected'}>萎缩斑</option>
											<option value="色素缺失" ${eyesCheckPo.sopecirisod != '色素缺失' ? '' : 'selected=selected'}>色素缺失</option>
                                          </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccrystalod" style="width:100%">
                                          	<option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopeccrystalod != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="晶体皮质混浊" ${eyesCheckPo.sopeccrystalod != '晶体皮质混浊' ? '' : 'selected=selected'}>晶体皮质混浊</option>
											<option value="晶体核棕色混浊" ${eyesCheckPo.sopeccrystalod != '晶体核棕色混浊' ? '' : 'selected=selected'}>晶体核棕色混浊</option>
											<option value="晶体位置偏移" ${eyesCheckPo.sopeccrystalod != '晶体位置偏移' ? '' : 'selected=selected'}>晶体位置偏移</option>
											<option value="术后人工晶体眼" ${eyesCheckPo.sopeccrystalod != '术后人工晶体眼' ? '' : 'selected=selected'}>术后人工晶体眼</option>
											<option value="术后无晶体眼" ${eyesCheckPo.sopeccrystalod != '术后无晶体眼' ? '' : 'selected=selected'}>术后无晶体眼</option>
											<option value="先天性白内障" ${eyesCheckPo.sopeccrystalod != '先天性白内障' ? '' : 'selected=selected'}>先天性白内障</option>
                                          </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <select name="eyesCheckPo.sopecfundusod" style="width:100%">
                                            <option value="" selected></option>
                                            <option value="正常" ${eyesCheckPo.sopecfundusod != '正常' ? '' : 'selected=selected'}>正常</option>
                                            <option value="杯盘比大" ${eyesCheckPo.sopecfundusod != '杯盘比大' ? '' : 'selected=selected'}>杯盘比大</option>											
											<option value="网脱术后" ${eyesCheckPo.sopecfundusod != '网脱术后' ? '' : 'selected=selected'}>网脱术后</option>
											<option value="眼底激光术后" ${eyesCheckPo.sopecfundusod != '眼底激光术后' ? '' : 'selected=selected'}>眼底激光术后</option>
											<option value="视网膜色素变性" ${eyesCheckPo.sopecfundusod != '视网膜色素变性' ? '' : 'selected=selected'}>视网膜色素变性</option>
											<option value="视神经萎缩" ${eyesCheckPo.sopecfundusod != '视神经萎缩' ? '' : 'selected=selected'}>视神经萎缩</option>
											<option value="糖尿病眼底病变" ${eyesCheckPo.sopecfundusod != '糖尿病眼底病变' ? '' : 'selected=selected'}>糖尿病眼底病变</option>
											<option value="高度近视眼底病变" ${eyesCheckPo.sopecfundusod != '高度近视眼底病变' ? '' : 'selected=selected'}>高度近视眼底病变</option>
											<option value="老年黄斑变性" ${eyesCheckPo.sopecfundusod != '老年黄斑变性' ? '' : 'selected=selected'}>老年黄斑变性</option>
											<option value="视网膜脱离／裂孔" ${eyesCheckPo.sopecfundusod != '视网膜脱离／裂孔' ? '' : 'selected=selected'}>视网膜脱离／裂孔</option>
											<option value="中央动脉堵塞" ${eyesCheckPo.sopecfundusod != '中央动脉堵塞' ? '' : 'selected=selected'}>中央动脉堵塞</option>
											<option value="中央静脉堵塞" ${eyesCheckPo.sopecfundusod != '中央静脉堵塞' ? '' : 'selected=selected'}>中央静脉堵塞</option>
											<option value="周边网膜变性" ${eyesCheckPo.sopecfundusod != '周边网膜变性' ? '' : 'selected=selected'}>周边网膜变性</option>
											<option value="视乳头水肿" ${eyesCheckPo.sopecfundusod != '视乳头水肿' ? '' : 'selected=selected'}>视乳头水肿</option>
											
                                          </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <select name="eyesCheckPo.sopeccampaignod" style="width:100%">
                                            <option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopeccampaignod != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="眼球震颤" ${eyesCheckPo.sopeccampaignod != '眼球震颤' ? '' : 'selected=selected'}>眼球震颤</option>
											<option value="外展障碍" ${eyesCheckPo.sopeccampaignod != '外展障碍' ? '' : 'selected=selected'}>外展障碍</option>
											<option value="内收障碍" ${eyesCheckPo.sopeccampaignod != '内收障碍' ? '' : 'selected=selected'}>内收障碍</option>
											<option value="上转障碍" ${eyesCheckPo.sopeccampaignod != '上转障碍' ? '' : 'selected=selected'}>上转障碍</option>
											<option value="下转障碍" ${eyesCheckPo.sopeccampaignod != '下转障碍' ? '' : 'selected=selected'}>下转障碍</option>
                                          </select>
                                      </div></TD>
                                      <TD class="table_none">
	                                      <select name="eyesCheckPo.sopeccolorod" style="width:100%">
	                                        <option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopeccolorod != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="全色盲" ${eyesCheckPo.sopeccolorod != '全色盲' ? '' : 'selected=selected'}>全色盲</option>
											<option value="红色盲" ${eyesCheckPo.sopeccolorod != '红色盲' ? '' : 'selected=selected'}>红色盲</option>
											<option value="绿色盲" ${eyesCheckPo.sopeccolorod != '绿色盲' ? '' : 'selected=selected'}>绿色盲</option>
											<option value="红色弱" ${eyesCheckPo.sopeccolorod != '红色弱' ? '' : 'selected=selected'}>红色弱</option>
											<option value="绿色弱" ${eyesCheckPo.sopeccolorod != '绿色弱' ? '' : 'selected=selected'}>绿色弱</option>
											<option value="其它(蓝紫等)" ${eyesCheckPo.sopeccolorod != '其它(蓝紫等)' ? '' : 'selected=selected'}>其它(蓝紫等)</option>
	                                      </select>
                                      </TD>
                                      <TD width="10%" class="table_none"><input name="eyesCheckPo.sopeciopod" class="text_input80" value="${eyesCheckPo.sopeciopod }"></TD>
                                      <TD width="10%" class="table_none">
	                                      <select name="eyesCheckPo.sopeciopselod" style="width:100%">
	                                        <option value="" selected></option>
											<option value="Tn" ${eyesCheckPo.sopeciopselod != 'Tn' ? '' : 'selected=selected'}>Tn</option>
											<option value="Tn+1" ${eyesCheckPo.sopeciopselod != 'Tn+1' ? '' : 'selected=selected'}>Tn+1</option>
											<option value="Tn-1" ${eyesCheckPo.sopeciopselod != 'Tn-1' ? '' : 'selected=selected'}>Tn-1</option>
	                                      </select>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">左</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopechyphemaos" style="width:100%">
                                          	<option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopechyphemaos != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="浅前房" ${eyesCheckPo.sopechyphemaos != '浅前房' ? '' : 'selected=selected'}>浅前房</option>
											<option value="房水闪辉+" ${eyesCheckPo.sopechyphemaos != '房水闪辉+' ? '' : 'selected=selected'}>房水闪辉+</option>
											<option value="前房积脓" ${eyesCheckPo.sopechyphemaos != '前房积脓' ? '' : 'selected=selected'}>前房积脓</option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecirisos" style="width:100%">
                                          	<option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopecirisos != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="瞳孔放大" ${eyesCheckPo.sopecirisos != '瞳孔放大' ? '' : 'selected=selected'}>瞳孔放大</option>
											<option value="瞳孔缩小" ${eyesCheckPo.sopecirisos != '瞳孔缩小' ? '' : 'selected=selected'}>瞳孔缩小</option>
											<option value="萎缩斑" ${eyesCheckPo.sopecirisos != '萎缩斑' ? '' : 'selected=selected'}>萎缩斑</option>
											<option value="色素缺失" ${eyesCheckPo.sopecirisos != '色素缺失' ? '' : 'selected=selected'}>色素缺失</option>
                                          </select>
                                      </div></TD>
                                      <TD class="table_none">
                                      <div align="center">
                                        <select name="eyesCheckPo.sopeccrystalos" style="width:100%">
                                          	<option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopeccrystalos != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="晶体皮质混浊" ${eyesCheckPo.sopeccrystalos != '晶体皮质混浊' ? '' : 'selected=selected'}>晶体皮质混浊</option>
											<option value="晶体核棕色混浊" ${eyesCheckPo.sopeccrystalos != '晶体核棕色混浊' ? '' : 'selected=selected'}>晶体核棕色混浊</option>
											<option value="晶体位置偏移" ${eyesCheckPo.sopeccrystalos != '晶体位置偏移' ? '' : 'selected=selected'}>晶体位置偏移</option>
											<option value="术后人工晶体眼" ${eyesCheckPo.sopeccrystalos != '术后人工晶体眼' ? '' : 'selected=selected'}>术后人工晶体眼</option>
											<option value="术后无晶体眼" ${eyesCheckPo.sopeccrystalos != '术后无晶体眼' ? '' : 'selected=selected'}>术后无晶体眼</option>
											<option value="先天性白内障" ${eyesCheckPo.sopeccrystalos != '先天性白内障' ? '' : 'selected=selected'}>先天性白内障</option>
                                          </select>
                                      </div>
                                      </TD>
                                      <TD class="table_none"><div align="center">
                                          <select name="eyesCheckPo.sopecfundusos" style="width:100%">
                                            <option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopecfundusos != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="杯盘比大" ${eyesCheckPo.sopecfundusos != '杯盘比大' ? '' : 'selected=selected'}>杯盘比大</option>
											<option value="网脱术后" ${eyesCheckPo.sopecfundusos != '网脱术后' ? '' : 'selected=selected'}>网脱术后</option>
											<option value="眼底激光术后" ${eyesCheckPo.sopecfundusos != '眼底激光术后' ? '' : 'selected=selected'}>眼底激光术后</option>
											<option value="视网膜色素变性" ${eyesCheckPo.sopecfundusos != '视网膜色素变性' ? '' : 'selected=selected'}>视网膜色素变性</option>
											<option value="视神经萎缩" ${eyesCheckPo.sopecfundusos != '视神经萎缩' ? '' : 'selected=selected'}>视神经萎缩</option>
											<option value="糖尿病眼底病变" ${eyesCheckPo.sopecfundusos != '糖尿病眼底病变' ? '' : 'selected=selected'}>糖尿病眼底病变</option>
											<option value="高度近视眼底病变" ${eyesCheckPo.sopecfundusos != '高度近视眼底病变' ? '' : 'selected=selected'}>高度近视眼底病变</option>
											<option value="老年黄斑变性" ${eyesCheckPo.sopecfundusos != '老年黄斑变性' ? '' : 'selected=selected'}>老年黄斑变性</option>
											<option value="视网膜脱离／裂孔" ${eyesCheckPo.sopecfundusos != '视网膜脱离／裂孔' ? '' : 'selected=selected'}>视网膜脱离／裂孔</option>
											<option value="中央动脉堵塞" ${eyesCheckPo.sopecfundusos != '中央动脉堵塞' ? '' : 'selected=selected'}>中央动脉堵塞</option>
											<option value="中央静脉堵塞" ${eyesCheckPo.sopecfundusos != '中央静脉堵塞' ? '' : 'selected=selected'}>中央静脉堵塞</option>
											<option value="周边网膜变性" ${eyesCheckPo.sopecfundusos != '周边网膜变性' ? '' : 'selected=selected'}>周边网膜变性</option>
											<option value="视乳头水肿" ${eyesCheckPo.sopecfundusos != '视乳头水肿' ? '' : 'selected=selected'}>视乳头水肿</option>
											
                                          </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <select name="eyesCheckPo.sopeccampaignos" style="width:100%">
                                            <option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopeccampaignos != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="眼球震颤" ${eyesCheckPo.sopeccampaignos != '眼球震颤' ? '' : 'selected=selected'}>眼球震颤</option>
											<option value="外展障碍" ${eyesCheckPo.sopeccampaignos != '外展障碍' ? '' : 'selected=selected'}>外展障碍</option>
											<option value="内收障碍" ${eyesCheckPo.sopeccampaignos != '内收障碍' ? '' : 'selected=selected'}>内收障碍</option>
											<option value="上转障碍" ${eyesCheckPo.sopeccampaignos != '上转障碍' ? '' : 'selected=selected'}>上转障碍</option>
											<option value="下转障碍" ${eyesCheckPo.sopeccampaignos != '下转障碍' ? '' : 'selected=selected'}>下转障碍</option>
                                          </select>
                                      </div></TD>
                                      <TD class="table_none">
	                                      <select name="eyesCheckPo.sopeccoloros" style="width:100%">
	                                        <option value="" selected></option>
											<option value="正常" ${eyesCheckPo.sopeccoloros != '正常' ? '' : 'selected=selected'}>正常</option>
											<option value="全色盲" ${eyesCheckPo.sopeccoloros != '全色盲' ? '' : 'selected=selected'}>全色盲</option>
											<option value="红色盲" ${eyesCheckPo.sopeccoloros != '红色盲' ? '' : 'selected=selected'}>红色盲</option>
											<option value="绿色盲" ${eyesCheckPo.sopeccoloros != '绿色盲' ? '' : 'selected=selected'}>绿色盲</option>
											<option value="红色弱" ${eyesCheckPo.sopeccoloros != '红色弱' ? '' : 'selected=selected'}>红色弱</option>
											<option value="绿色弱" ${eyesCheckPo.sopeccoloros != '绿色弱' ? '' : 'selected=selected'}>绿色弱</option>
											<option value="其它(蓝紫等)" ${eyesCheckPo.sopeccoloros != '其它(蓝紫等)' ? '' : 'selected=selected'}>其它(蓝紫等)</option>
	                                      </select>
                                      </TD>
                                      <TD width="10%" class="table_none"><input name="eyesCheckPo.sopeciopos" class="text_input80" value="${eyesCheckPo.sopeciopos }"></TD>
                                      <TD width="10%" class="table_none">
	                                      <select name="eyesCheckPo.sopeciopselos" style="width:100%">
	                                        <option value="" selected></option>
											<option value="Tn" ${eyesCheckPo.sopeciopselos != 'Tn' ? '' : 'selected=selected'}>Tn</option>
											<option value="Tn+1" ${eyesCheckPo.sopeciopselos != 'Tn+1' ? '' : 'selected=selected'}>Tn+1</option>
											<option value="Tn-1" ${eyesCheckPo.sopeciopselos != 'Tn-1' ? '' : 'selected=selected'}>Tn-1</option>
	                                      </select>
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	  <input type="hidden" name="moduleID" value="${requestScope.moduleID}">
                          	  <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
                        	  <!-- <img icon='icon-reload' type='reset' value='清空' > -->
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
	
	
	




