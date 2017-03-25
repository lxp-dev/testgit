<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门维护</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

        if ('${departmentsPo.bdplinkhisflag}' != '1'){
        	$('#bdpchargingitemid').attr('noValidate','noValidate');
        	$('#bdplinkhis').attr('noValidate','noValidate');
            $('tr[id=histr1]').hide();
            $('tr[id=histr2]').hide();
        }

        if ('${departmentsPo.bdpnotpayfeeform}' == '1'){
        	$('#bdpchargingitemid').attr('noValidate','noValidate');
        	$('#bdplinkhis').attr('noValidate','noValidate');
            $('tr[id=histr2]').hide();
        }
    	
	});

	function changeLinkHisFlag(obj){
        if (obj == '1'){
            $('tr[id=histr1]').show();
            $('tr[id=histr2]').show();
            $('#bdpchargingitemid').removeAttr('noValidate','noValidate');
        	$('#bdplinkhis').removeAttr('noValidate','noValidate');
        }else{
            $('#bdpchargingitemid').val('');
            $('#bdplinkhis').val('');
            $('#bdpnotpayfeeform2').attr('checked',true);
            $('#bdpchargingitemid').attr('noValidate','noValidate');
        	$('#bdplinkhis').attr('noValidate','noValidate');
            
            $('tr[id=histr1]').hide();
            $('tr[id=histr2]').hide();
        }
    }

	function changeLinkHisFlag2(obj){
        if (obj == '1'){
            $('#bdpchargingitemid').val('');
            $('#bdpchargingitemid').attr('noValidate','noValidate');
        	$('#bdplinkhis').attr('noValidate','noValidate');
            $('tr[id=histr2]').hide();
        }else{
            $('tr[id=histr2]').show();
            $('#bdpchargingitemid').removeAttr('noValidate','noValidate');
        	$('#bdplinkhis').removeAttr('noValidate','noValidate');
        }
    }

	function save(){
		if(checkForm(departmentsForm)){
			$("img").removeAttr("onclick");
			departmentsForm.action = "updateHisSet.action";
			departmentsForm.submit();
		}
	
	}
    
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

    //门店单据模版配置
    function setBillTemplate(){
        departmentsForm.action = "initBillTemplate.action";
	    departmentsForm.submit();
    }    

    //部门修改
    function departmentsUpdate(){
        departmentsForm.action = "initDepartmentsUpdate.action";
	    departmentsForm.submit();
    }

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

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

                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      onclick="departmentsUpdate();"
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">部门修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>
                  <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 

                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setPuisneWarehouse();"
                      UNSELECTABLE="on">下属仓位配置</TD>
    
                    </TR></TBODY></TABLE></TD>

					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setGoodsOutWarehouse();"
                      UNSELECTABLE="on">门店仓位配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>
                   
                    </TR></TBODY></TABLE></TD>  
    	         <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setBillTemplate();"
                      UNSELECTABLE="on">单据模版配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>                   
                    </TR>
                    </TBODY>
                  </TABLE>
                 </TD>  

                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">HIS系统配置</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3 ></TD>                   
                    </TR>
                    </TBODY>
                  </TABLE>
                 </TD> 

                 
					</TR></TBODY></TABLE></TD>					
			  </TR>
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
                            <TD width="12%" height="26" class="table_body">部门编码</TD>
                            <TD width="24%" class="table_none">${departmentsPo.bdpdepartmentid }<input type="hidden" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid }"></TD>
                            <TD width="12%" height="26" class="table_body">部门名称</TD>
                            <TD width="24%" class="table_none">${departmentsPo.bdpdepartmentname }</TD>
                          </TR>
                          <TR>
                            <TD height="26" class="table_body">连接HIS系统</TD>
                            <TD class="table_none" colspan="3">
                              <input type="radio" id="bdplinkhisflag1" name="departmentsPo.bdplinkhisflag" value="1" ${departmentsPo.bdplinkhisflag == '1' ? 'checked="checked"' : '' } onclick="changeLinkHisFlag('1');">连接&nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" id="bdplinkhisflag2" name="departmentsPo.bdplinkhisflag" value="0" ${departmentsPo.bdplinkhisflag == '0' ? 'checked="checked"' : '' } onclick="changeLinkHisFlag('0');">不连接
                            </TD>
                          </TR>

                          <TR id="histr1">
                            <TD height="26" class="table_body">医院HIS系统</TD>
                            <TD height="26" class="table_none" >
                              <select id="bdplinkhis" name="departmentsPo.bdplinkhis" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择医院HIS系统！'}]">
                                  <option value="">----请选择----</option>
                                  <s:iterator value="hisInfoList">
                                      <option value="${bhid }" ${departmentsPo.bdplinkhis == bhid ? 'selected="selected"' : '' }>${bhhisname}</option>
                                  </s:iterator>
                              </select>
                              <label style="color:red;">&nbsp;*</label>                            
                            </TD>
                            <TD height="26" class="table_body">待收费记录向HIS传递方式</TD>
                            <TD height="26" class="table_none" >                           
                              <input type="radio" id="bdpnotpayfeeform1" name="departmentsPo.bdpnotpayfeeform" value="1" ${departmentsPo.bdpnotpayfeeform == '1' ? 'checked="checked"' : '' } onclick="changeLinkHisFlag2('1');">按商品明细传递&nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" id="bdpnotpayfeeform2" name="departmentsPo.bdpnotpayfeeform" value="2" ${departmentsPo.bdpnotpayfeeform != '1' ? 'checked="checked"' : '' } onclick="changeLinkHisFlag2('2');">按整单传递
                            </TD>
                          </TR>
  
                          <TR id="histr2">
                            <TD width="10%" height="26" class="table_body">收费项目编号</TD>
                            <TD width="23%" class="table_none" colspan="3">
                                <input class="text_input200" id="bdpchargingitemid" name="departmentsPo.bdpchargingitemid" value="${departmentsPo.bdpchargingitemid }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新输入收费项目编号！'}]">
                                <label style="color:red;">&nbsp;*</label>
                            </TD>
                          </TR>
                      
                      </TABLE>
                      <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TBODY>
                          <TR>
                            <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn onclick="save();" title='保存'>
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