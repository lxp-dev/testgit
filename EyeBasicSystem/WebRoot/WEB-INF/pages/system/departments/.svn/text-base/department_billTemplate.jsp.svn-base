<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店单据模版配置</title>
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

    
    //下属仓位配置
    function setPuisneWarehouse(){
    	departmentsForm.action = "initPuisneWarehouse.action";
	    departmentsForm.submit();
    }  
    
    //门店销售商品出仓配置
    function setGoodsOutWarehouse(){
        departmentsForm.action = "initGoodsOutWarehouse.action";
	    departmentsForm.submit();
    }
    
    //仓位列表默认值配置
    function setDefaultWarehouse(){
        departmentsForm.action = "initDefaultWarehouse.action";
	    departmentsForm.submit();
    }
    
    //部门修改
    function departmentsUpdate(){
        departmentsForm.action = "initDepartmentsUpdate.action";
	    departmentsForm.submit();
    }
    
    //门店销售商品入仓配置
    function setGoodsInWarehouse(){
        departmentsForm.action = "initGoodsInWarehouse.action";
	    departmentsForm.submit();
    }

  //模版开窗
	function changeBillTemplate(typeID,id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initBillTemplateDepartmentOpen.action?moduleID=${requestScope.moduleID}&departmentId="+ departmentsPo.bdpdepartmentid +"&typeID="+typeID+"&id="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initBillTemplateDepartmentOpen.action?moduleID=${requestScope.moduleID}&typeID="+typeID+"&id="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【模版选择】";
	}    

	//模版开窗赋值方法
	function changeBillTemplateValues(id,type,url){
		switch(type) 
		{ 
		case "1": 	//框架配镜单
			$('#bdpkjid').val(id);
			$('#bdpkjurl').attr('src',url);
			break; 
		case "2": 	//隐形配镜单 
			$('#bdpyxid').val(id);
			$('#bdpyxurl').attr('src',url);
			break; 
		case "3": 	//辅料配镜单 
			$('#bdpflid').val(id);
			$('#bdpflurl').attr('src',url);
			break; 
		case "4": 	//定金单 
			$('#bdpdjdid').val(id);
	        $('#bdpdjdurl').attr('src',url);
			break; 
		case "5": 	//挂号单
			$('#bdpghdid').val(id);
	        $('#bdpghdurl').attr('src',url);
			break; 
		case "41": 	//退框架配镜单
			$('#bdptkjid').val(id);
			$('#bdptkjurl').attr('src',url);
			break; 
		case "42": 	//退隐形配镜单 
			$('#bdptyxid').val(id);
			$('#bdptyxurl').attr('src',url);
			break; 
		case "43": 	//退辅料配镜单 
			$('#bdptflid').val(id);
			$('#bdptflurl').attr('src',url);
			break; 			
		}					
	}	

	function imgclick(src){
		var id = src.src;
		var width = $(src).attr("width2");
		var height = $(src).attr("height2");
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,600,300,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,900,500,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【模版预览--鼠标滚轮可以对图片进行放大和缩小】";
	}

	function save(){
		departmentsForm.action = "updateBillTemplate.action";
		departmentsForm.submit();
	}	

    //HIS配置
    function setHis(){
        departmentsForm.action = "initHisSet.action";
	    departmentsForm.submit();
    }
    
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid}">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
          <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22  src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__1 background=${ctx }/img/pic/tab_unactive_bg.gif onclick="departmentsUpdate();" UNSELECTABLE="on">部门修改</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx }/img/pic/tab_unactive_right.gif" width=3></TD>
                      <TD width=3><IMG id=tabImgLeft__1 height=22  src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__1 background=${ctx }/img/pic/tab_unactive_bg.gif  onclick="setPuisneWarehouse();" UNSELECTABLE="on">下属仓位配置</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx }/img/pic/tab_unactive_right.gif" width=3></TD>
                      <c:if test="${departmentsPo.bdptype=='3'}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22  src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="150" align="center" class=tab id=tabLabel__1 background=${ctx }/img/pic/tab_unactive_bg.gif onclick="setDefaultWarehouse();" UNSELECTABLE="on">仓位列表默认值配置</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx }/img/pic/tab_unactive_right.gif" width=3></TD>  
                      </c:if>
                      <c:if test="${departmentsPo.bdptype=='1'}"> 
                      <TD width=3><IMG id=tabImgLeft__1 height=22  src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__1 background=${ctx }/img/pic/tab_unactive_bg.gif onclick="setGoodsOutWarehouse();" UNSELECTABLE="on">门店仓位配置</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx }/img/pic/tab_unactive_right.gif" width=3></TD>  
                      </c:if>                                                              
                      <TD width=3><IMG id=tabImgLeft__1 height=22 src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__1 background=${ctx }/img/pic/tab_active_bg.gif UNSELECTABLE="on">单据模版配置</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx }/img/pic/tab_active_right.gif" width=3></TD>
                      
              <c:if test="${departmentsPo.bdptype == '1' && systemParameterPo.fsphisflag == '2'}">  
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setHis();"
                      UNSELECTABLE="on">HIS系统配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>                   
                    </TR>
                    </TBODY>
                  </TABLE>
                 </TD> 
              </c:if>
              
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
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
                          <TD height="26" class="table_body " align="right">配镜单样式</TD>
                          <TD class="table_none " colspan="5">
								<li class="horizontal_onlyRight">
								   <img btn=btn src="${ctx }/img/newbtn/btn_szkjxsys_0.png" title="选择框镜配镜单样式" onClick="changeBillTemplate('1','${departmentsPo.bdpkjid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdpkjid" name="departmentsPo.bdpkjid" value="${departmentsPo.bdpkjid }">
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPo.bdpkjurl}" id="bdpkjurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								   <img btn=btn src="${ctx }/img/newbtn/btn_szyxxsys_0.png" title="选择隐形配镜单样式" onClick="changeBillTemplate('2','${departmentsPo.bdpyxid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdpyxid" name="departmentsPo.bdpyxid" value="${departmentsPo.bdpyxid }">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								    <img src="${ctx}${departmentsPo.bdpyxurl}" id="bdpyxurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								   <img btn=btn src="${ctx }/img/newbtn/btn_szflxsys_0.png" title="选择辅料配镜单样式" onClick="changeBillTemplate('3','${departmentsPo.bdpflid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdpflid" name="departmentsPo.bdpflid" value="${departmentsPo.bdpflid }">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								    <img src="${ctx}${departmentsPo.bdpflurl}" id="bdpflurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
					   <TR>
                          <TD height="26" class="table_body " align="right">退款单样式</TD>
                          <TD class="table_none " colspan="5">
								<li class="horizontal_onlyRight">
								   <img btn=btn src="${ctx }/img/newbtn/btn_szkjxsys_0.png" title="选择退框镜配镜单样式" onClick="changeBillTemplate('41','${departmentsPo.bdptkjid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdptkjid" name="departmentsPo.bdptkjid" value="${departmentsPo.bdptkjid }">
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPo.bdptkjurl}" id="bdptkjurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								   <img btn=btn src="${ctx }/img/newbtn/btn_szyxxsys_0.png" title="选择退隐形配镜单样式" onClick="changeBillTemplate('42','${departmentsPo.bdptyxid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdptyxid" name="departmentsPo.bdptyxid" value="${departmentsPo.bdptyxid }">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								    <img src="${ctx}${departmentsPo.bdptyxurl}" id="bdptyxurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								   <img btn=btn src="${ctx }/img/newbtn/btn_szflxsys_0.png" title="选择退辅料配镜单样式" onClick="changeBillTemplate('43','${departmentsPo.bdptflid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdptflid" name="departmentsPo.bdptflid" value="${departmentsPo.bdptflid }">
								</li>
								<li class="horizontal_onlyRight" ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
								    <img src="${ctx}${departmentsPo.bdptflurl}" id="bdptflurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>					   
					   <TR ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
                          <TD height="26" class="table_body " align="right">订金单样式</TD>
                          <TD class="table_none " colspan="5">
								<li class="horizontal_onlyRight">
								   <img btn=btn src="${ctx }/img/newbtn/btn_szdjdys_0.png" title="选择订金单样式" onClick="changeBillTemplate('4','${departmentsPo.bdpdjdid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdpdjdid" name="departmentsPo.bdpdjdid" value="${departmentsPo.bdpdjdid }">
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPo.bdpdjdurl}" id="bdpdjdurl" width="160" height="100" width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
					   <TR ${departmentsPo.bdptype == '1' ? '' : 'style="display: none"'}>
                          <TD height="26" class="table_body " align="right">挂号单样式</TD>
                          <TD class="table_none " colspan="5">
								<li class="horizontal_onlyRight">
								   <img btn=btn src="${ctx }/img/newbtn/btn_szghays_0.png" title="选择挂号单样式" onClick="changeBillTemplate('5','${departmentsPo.bdpghdid }');" width="100" height="20">
								   <input class="text_input60" type="hidden" id="bdpghdid" name="departmentsPo.bdpghdid" value="${departmentsPo.bdpghdid }">
								</li>
								<li class="horizontal_onlyRight">
								    <img src="${ctx}${departmentsPo.bdpghdurl}" id="bdpghdurl" width="160" height="100"  width2="600" height2="450" onclick="imgclick(this)" style="cursor: hand;">
								</li>
                          </TD>
					   </TR>
                      </TABLE>
                      <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TBODY>
                          <TR>
                            <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" onclick="save();" title='保存'>
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
width=1></TD>
              </TR>
            </TBODY>
          </TABLE></TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
    <%@ include file="/WEB-INF/inc/message.jsp" %>