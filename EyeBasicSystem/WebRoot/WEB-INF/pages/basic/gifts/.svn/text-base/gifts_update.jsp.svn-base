<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赠品类修改</title>
</head>
<SCRIPT type="text/javascript">

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });
	}); 

	function save(){
		if(checkForm(giftsForm)){
			$("img").removeAttr("onclick");
			giftsForm.action = "giftsUpdate.action";
			giftsForm.submit();
		}
	}

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}
</SCRIPT>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="giftsForm">
<input type="hidden" name="giftsPo.bgsuuid" value="${giftsPo.bgsuuid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}"/>
<input type="hidden" name="giftsPo.bgsgoodsid" value="${giftsPo.bgsgoodsid }">
<input type="hidden" name="giftsPo.bgsauditstate" value="${giftsPo.bgsauditstate }">
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>

                          <TD width="10%" class="table_body">赠品名称</TD>
                          <TD width="24%" class="table_none">${giftsPo.bgsgoodsname }&nbsp;
                          </TD>
                          <TD width="9%" class="table_body">商品代码</TD>
                          <TD width="24%" class="table_none">${giftsPo.bgsgoodsid }&nbsp;</TD>
                          <TD width="9%" class="table_body" height="26">赠品简称</TD>
                          <TD width="30%" class="table_none">
                             <input class="text_input160" type="text" maxlength="30" name="giftsPo.bgsviewname" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写赠品简称！'}]" value="${giftsPo.bgsviewname}">
                             <li class="horizontal_onlyRight">
							     <input name="giftsPo.bdpisshow" type="checkbox" ${giftsPo.bdpisshow eq '1' ? 'checked="checked"' : '' }>&nbsp;赠品简称显示在销售页面
							 </li>
                          </TD>
						  
                        </TR>
                         <TR>
                          <TD class="table_body" height="26">活动门店</TD>
                           <TD class="table_none">
                          <li class="horizontal_onlyRight">
							
							<input type="hidden" id="bdpdepartmentname" value="${giftsPo.bdpdepartmentname}"   />
							<textarea id="ds"  name="ds" style='height:50px;width: 300px' readonly="readonly" 
                          					validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '活动门店不能为空！'}]">${giftsPo.bdpdepartmentname}</textarea>
							
						   		<input type="hidden" id="departmentID" name="giftsPo.bgsdepartments" value="${giftsPo.bgsdepartments}"/>
                          </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
						   </li>
						  </TD>
						  <TD width="9%" class="table_body" height="26">赠品类型</TD>
                          <TD width="24%" class="table_none" colspan="3">
                          	<select id="bgstype" name="giftsPo.bgstype">
                          		<option value="1" ${giftsPo.bgstype eq '1'? ' selected':''}>门店赠品类 【存放于门店的赠品，结款时消减库存】</option>
                          		<option value="2" ${giftsPo.bgstype eq '2'? ' selected':''}>通用赠品类 【存放于库房、或加工中心的赠品，根据出仓配置消减库存】</option>
                          	</select>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>

                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <img name="button1" id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          <img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置' onclick="document.giftsForm.reset();">                        
                          </TD>
					   </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>