<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
# {	color: #F00;
}
.STYLE1 {color: #FF0000;
	font-weight: bold;
}
</style>
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
	});

	function save(){

		if ('${systemParameterPo.fsphisflag}' == '2' && '${departmentsPo.bdplinkhisflag}' == '1' && '${departmentsPo.bdptype}' == '1' && $('input[name=departmentsPo.bdpsalestype]:checked').val() == '1'){
            alert('此门店已经连接HIS系统， 销售方式只能选取：验光+销售 !');
            return;
		}
		
		if(checkForm(departmentsForm)){
			$("img").removeAttr("onclick");
			departmentsForm.action = "updateDepartment.action";
			departmentsForm.submit();
		}
	
	}
	
    function isshow(){
	    var cw = document.getElementById("cw");
	    if(cw.checked){
		    $('#showtr').show();
	    }else{
		    $('#showtr').hide();
	    }

    }
    
    //下属仓位配置
    function setPuisneWarehouse(){
    	departmentsForm.action = "initPuisneWarehouse.action";
	    departmentsForm.submit();
    }    
    
    //仓位列表默认值配置
    function setDefaultWarehouse(){
        departmentsForm.action = "initDefaultWarehouse.action";
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
    
    //门店销售商品入仓配置
    function setGoodsInWarehouse(){
        departmentsForm.action = "initGoodsInWarehouse.action";
	    departmentsForm.submit();
    }

    //HIS配置
    function setHis(){
        departmentsForm.action = "initHisSet.action";
	    departmentsForm.submit();
    }

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
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
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">部门修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3 ></TD></TR></TBODY></TABLE></TD>                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 

                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setPuisneWarehouse();"
                      UNSELECTABLE="on">下属仓位配置</TD>
             <c:if test="${departmentsPo.bdptype=='3'}">         
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                      
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3 ></TD>
             </c:if>       
                    </TR></TBODY></TABLE></TD>
			 <c:if test="${departmentsPo.bdptype=='3'}">		
					<TD width="120" class=tab align="center" id=tabLabel__1 onclick="setDefaultWarehouse();"                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">仓位列表默认值配置</TD>
			 </c:if>		
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <c:if test="${departmentsPo.bdptype=='1'}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22                                                             
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
                        <TD width="100" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="setGoodsOutWarehouse();"
                      UNSELECTABLE="on">门店仓位配置</TD>
                      </c:if>
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
                            <TD width="24%" class="table_none"><span class="STYLE1">
                              <input class="text_input200" id="bdpdepartmentname" name="departmentsPo.bdpdepartmentname" value="${departmentsPo.bdpdepartmentname }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '部门名称不能为空！'}]">
                              *</span></TD>
                            <TD width="12%" height="26" class="table_body">负责人</TD>
                            <TD width="24%" class="table_none"><input class="text_input200" id="bdpperson" name="departmentsPo.bdpperson" value="${departmentsPo.bdpperson }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.PersonNameOrNULL, 'Message' : '负责人姓名填写有误！'}]" onblur="$(this).val($.trim($(this).val()));"></TD>
                          
                          </TR>
                          <TR>
                            <TD height="26" class="table_body">部门状态</TD>
                            <TD class="table_none"><span class="STYLE1">
                              <select id="bdpisclosed" name="departmentsPo.bdpisclosed">
                                <option value="0" ${departmentsPo.bdpisclosed == '0'? 'selected="selected"' : '' }>启用</option>
                                <option value="1" ${departmentsPo.bdpisclosed == '1'? 'selected="selected"' : '' }>停用</option>
                              </select>
                              *</span></TD>
                            <TD height="26" class="table_body">部门类型</TD>
                            <TD height="26" class="table_none" >
                            ${departmentsPo.bdptypename}
                            <input type="hidden" name="departmentsPo.bdptype" value="${departmentsPo.bdptype }">
                            
                            </TD>
                            <TD height="26" class="table_body">关联加工中心</TD>
                            <TD height="26" class="table_none" >
                            <c:if test="${departmentsPo.bdptype == '1'}">
                            <select id="bdpregid" name="departmentsPo.bdpregid">
                              <option value="">----请选择----</option>
							<s:iterator value="processDptList">
                        	  <option value="${bdpdepartmentid }" ${departmentsPo.bdpregid==bdpdepartmentid ? 'selected="selected"' :'' }>${bdpdepartmentname }</option>
                            </s:iterator>
                            </select>
                            </c:if>
                            </TD>
                          </TR>
                      <c:if test="${departmentsPo.bdptype == '1'}"> 	  
			            <TR>                             
                            <TD height="26" class="table_body"><li class="horizontal_onlyRight">默认成品镜片取镜时间</li>
                            </TD>
                        	<TD height="26" class="table_none" >
                        	<li class="horizontal_onlyRight">
                        	<input class="text_input100" id="bdptakeglassdate" name="departmentsPo.bdptakeglassdate" value="${departmentsPo.bdptakeglassdate}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写整数！'}]"> 小时
			            	  </li>
                      	    </TD>
                            <TD height="26" class="table_body"><li class="horizontal_onlyRight">存入银行</li>
                            </TD>
                            <TD height="26" class="table_none" >
                        	<li class="horizontal_onlyRight">
                          <select id="bdpbankcard" name="departmentsPo.bdpbankcard">
                              <option value="">----请选择----</option>
                              <s:iterator value="brankCardList">
							  <option value="${bbcid}" ${departmentsPo.bdpbankcard == bbcid ? 'selected="selected"' : '' }>${bbcname}</option>
							  </s:iterator>
                      	  </select>
			            	  </li>
                      	  </TD>
                      	  <TD height="26" class="table_body"><li class="horizontal_onlyRight">销售方式</li>
                            </TD>
                            <TD height="26" class="table_none" >
                        	<li class="horizontal_onlyRight">
                                 <input type="radio" name="departmentsPo.bdpsalestype" value="1" ${departmentsPo.bdpsalestype == '1' ? 'checked="checked"' : '' }>验光+销售+收银
								 <input type="radio" name="departmentsPo.bdpsalestype" value="2" ${departmentsPo.bdpsalestype == '2' ? 'checked="checked"' : '' }>验光+销售
			            	  </li>
                      	  </TD>
			              </TR>
			              <TR>
			            	<TD height="26" class="table_body">隐形和护理液同单销售</TD>
                        	<TD width="23%" class="table_none" ${systemParameterPo.fspprintmedicalhistory == '2' ? '' : 'colspan="5"'  }>
			            		<select name="departmentsPo.bdpstealthflag">
			            		    <option value="" ${departmentsPo.bdpstealthflag == '' ? 'selected="selected"' : ''}>----请选择----</option>
			            			<option value="0" ${departmentsPo.bdpstealthflag =='0' ? 'selected="selected"' : ''}>不能同单销售</option>
			            			<option value="1" ${departmentsPo.bdpstealthflag =='1' ? 'selected="selected"' : ''}>可以同单销售</option>
			            		</select>
			            	</TD>
			            	<c:if test="${systemParameterPo.fspprintmedicalhistory == '2'}">
				            	<TD height="26" class="table_body">打印病历</TD>
	                        	<TD width="23%" class="table_none" colspan="3">
				            		<select name="departmentsPo.bdpprintmedicalhistory" id="bdpprintmedicalhistory" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取是否打印病历！'}]">
				            		    <option value="" ${departmentsPo.bdpprintmedicalhistory == '' ? 'selected="selected"' : ''}>----请选择----</option>
				            			<option value="1" ${departmentsPo.bdpprintmedicalhistory =='1' ? 'selected="selected"' : ''}>打印</option>
				            			<option value="0" ${departmentsPo.bdpprintmedicalhistory =='0' ? 'selected="selected"' : ''}>不打印</option>
				            		</select>
				            	</TD>
			            	</c:if>
			            </TR>
                        <TR>
                         <TD width="10%" height="26" class="table_body">闭店时间</TD>
                         <TD width="23%" class="table_none"><input class="text_input60" id="bdpclosedate" name="departmentsPo.bdpclosedate" value="${departmentsPo.bdpclosedate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写整数！'}]">点
                             <span class="STYLE1">门店打印的销售单会打印此闭店时间</span>
                         </TD>
                         <TD width="10%" height="26" class="table_body">读取会员卡方式</TD>
                         <TD width="23%" class="table_none" colspan="3" >
                          	<select name="departmentsPo.bdpreadcardform" id="bdpreadcardform">
		            			<option value="initSCIHISsaomaWin.action" ${departmentsPo.bdpreadcardform =='initSCIHISsaomaWin.action' ? 'selected="selected"' : ''}>扫码枪</option>
		            			<option value="initSCIHISdukaWin.action" ${departmentsPo.bdpreadcardform =='initSCIHISdukaWin.action' ? 'selected="selected"' : ''}>长城读卡器</option>
	            		    </select>
                         </TD>
                       	</TR>  			            
			            </c:if>    
                           <TR>
                            <TD width="10%" height="26" class="table_body">部门全称</TD>
                            <TD width="23%" class="table_none" colspan="5" ><input class="text_input200" id="bdpfullname" name="departmentsPo.bdpfullname" value="${departmentsPo.bdpfullname }" maxlength="500">
                                <span class="STYLE1">门店打印的销售单会打印此名称</span>
                            </TD>
                          </TR>
                          
                          <TR>
                            <TD width="10%" height="26" class="table_body">部门电话</TD>
                            <TD width="23%" class="table_none" colspan="5" ><input class="text_input200" id="bdpphone" name="departmentsPo.bdpphone" value="${departmentsPo.bdpphone }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '部门电话格式错误！'}]">
                                <span class="STYLE1">门店打印的销售单会打印此电话</span>
                            </TD>

                          </TR>
                           <TR>
                            <TD width="10%" height="26" class="table_body">部门地址</TD>
                            <TD width="23%" class="table_none" colspan="5" ><input class="text_input240" id="bdpaddress" name="departmentsPo.bdpaddress" value="${departmentsPo.bdpaddress}" maxlength="500">
                                <span class="STYLE1">门店打印的销售单会打印此地址</span>
                            </TD>
                          </TR>
                          <TR>
                            <TD width="10%" height="26" class="table_body">公司名称</TD>
                            <TD width="23%" class="table_none" colspan="5" ><input class="text_input240" id="bdpaddress" name="departmentsPo.bdpcompanyname" value="${departmentsPo.bdpcompanyname}" maxlength="200">
                                <span class="STYLE1">门店打印的销售单会打印此公司名称</span>
                            </TD>
                          </TR> 
                          <TR>
                            <TD height="26" class="table_body">所属公司</TD>
                        	<TD height="26" class="table_none"  colspan="5">

                                <c:if test="${person.personcompanytype == '1'}">
		                        	<select clean="clean" id="bdpcompanysid" name="departmentsPo.bdpcompanysid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属公司！'}]">
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ${departmentsPo.bdpcompanysid == fcnId ? 'selected="selected"':'' } ctype="${fcnmasterorvice }">${fcnName}</option>
		                              </s:iterator>
		                            </select>
                        	    </c:if>
                        	    
                        	    <c:if test="${person.personcompanytype == '2'}">
		                            ${person.personcompanyname}<input type="hidden" id="bdpcompanysid" name="departmentsPo.bdpcompanysid" value="${person.personcompanyid }" readonly="readonly">
                        	    </c:if>
                        	    
                        	  <span class="STYLE1">门店打印的销售单会打印此公司名称*</span></TD>
                          </TR>
                      <c:if test="${systemParameterPo.fspkqsystem == '2'}">    
                          <TR>
                            <TD width="10%" height="26" class="table_body">考勤系统部门编码</TD>
                            <TD width="23%" class="table_none" colspan="5" ><input class="text_input200" id="bdpkqDptID" name="departmentsPo.bdpkqDptID" value="${departmentsPo.bdpkqDptID}" maxlength="5">
                                <span class="STYLE1">此部门编码必须与考勤系统中的部门编码一致</span>
                            </TD>
                          </TR>
                      </c:if>                              
                          <c:if test="${departmentsPo.bdptype == '1'}">
                          <tr>
                     	  <TD height="26" class="table_body">使用零售价</TD>
                     	  <TD width="23%" height="26" class="table_none" colspan="5">
                        	<li class="horizontal_onlyRight">
	                          <select id="bdpwhichretail" name="departmentsPo.bdpwhichretail">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${departmentsPo.bdpwhichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${departmentsPo.bdpwhichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${departmentsPo.bdpwhichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${departmentsPo.bdpwhichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${departmentsPo.bdpwhichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${departmentsPo.bdpwhichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${departmentsPo.bdpwhichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${departmentsPo.bdpwhichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${departmentsPo.bdpwhichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${departmentsPo.bdpwhichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select>
			            	</li>
                      	  </TD>
                     </tr>
                     </c:if>
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