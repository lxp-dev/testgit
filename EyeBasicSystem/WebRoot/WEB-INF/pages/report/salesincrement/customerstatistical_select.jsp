<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表中心</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
	    if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	}); 

	function search(){
		var shopCode = $('#departmentID').val();
		if(shopCode == ''){
			shopCode = $("#dids").val();
		}
		
		var bgnDate = $('#bgnDate').val();
		var endDate = $('#endDate').val();
		var bgnDate2 = $('#bgnDate2').val();
		var endDate2 = $('#endDate2').val();		
		var shopCodeName = $('#bdpdepartmentname').val();
		if(shopCodeName == ''){
			shopCodeName = EncodeUtf8($("#dnames").val());
		}
		var isShow = $("input[id=isShow]:checked").val();
        var showCompanyName = $('input[name=showCompanyName2]:checked').val();
		
        var goodsType='';
        $('input[goodsType=goodsType]').each(function(){
            if ($(this).attr('checked') == true){
            	goodsType += $(this).val() + ',';                 
            }
        });
        if (goodsType == ''){
            alert('请选择商品类型!')
            return;
        }
			
		if(checkForm(goodsForm)){

			var DataURL = "report.action?reportlet=sales_kudantongji.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&shopCode="+shopCode+"&bgnDate="+bgnDate+"&endDate="+endDate+"&bgnDate2="+bgnDate2+"&endDate2="+endDate2+"&shopCodeName="+EncodeUtf8(shopCodeName)+"&isShow="+isShow+"&goodsType="+goodsType+"&showCompanyName="+showCompanyName;    
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				openWindowForReport(DataURL);				
			}		
			document.getElementById('popupTitle').innerHTML="【客单统计表 】";
	    }

	}
	
	function clean(){
		goodsForm.reset();
		
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";

	}
	
	/**
	 * 开窗赋值实现方法
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
	
	function loadDepartmentids(cid) {  
		if(cid == ''){
			$("#departmentID").val('');
	   		$("#bdpdepartmentname").val('');
	   		$("#ds").val('');
	   		$("#dids").val('');
			$("#dnames").val('');
		}else{
			$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxDepartmentForCompanyID.action",          
	   	   	    async: true, 
	   	   	    data: "companysid="+cid+"&type=1",     
	   	   	    success: function(msg){
	   	   	    	var item = msg.split("/");
	                <c:if test="${person.departmenttype!=1}">
	                	$("#departmentID").val(item[0]);
	   	   	    		$("#bdpdepartmentname").val(item[1]);
	   	   	    		$("#ds").val(item[1]);
						$("#dids").val(item[0]);
						$("#dnames").val(item[1]);
					</c:if>  
	   	   	    }
			});
		}
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="dids" name="dids" value="">
<input type="hidden" id="dnames" name="dnames" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>决策分析类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：客单统计表  </TD>
            <TD align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      	<TR>
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none" colspan="5">
			                <c:if test="${person.personcompanytype eq '2'}">
			                	${person.personcompanyname }
	                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        </c:if>
	                        
	                        <c:if test="${person.personcompanytype ne '2'}">
	                        	<c:if test="${person.departmenttype!=1}">
							   		<select clean="clean" id="companysid" name="companysid" onchange="loadDepartmentids(this.options[this.options.selectedIndex].value)" >
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
		                              </s:iterator>
		                            </select>
								</c:if>  
							    <c:if test="${person.departmenttype==1}">
		                            ${person.personcompanyname }
		                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        	</c:if>
	                        </c:if>
                           </TD>
                        </TR>
					  	<TR>
						   <TD width="12%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="36%">
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" value="${personInfoPo.bdpdepartmentname }" type="hidden" />
						   		<textarea class="text_input200" id="ds"  name="ds" value=""   style='height:50px;width:300px' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" name="personInfoPo.departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
						 
						</c:if>
						<c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="bdpdepartmentname" value="${person.bdpdepartmentname}" name="bdpdepartmentname">
      	                </c:if> 
						  </TD>
			               <TD class="table_body">对比日期</TD>
			               <TD class="table_none"> 	                      
	      	                  <li class="horizontal_onlyRight">   
	      	                  <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择往年起始日期！'}]" 
					               id="bgnDate"
							       name="bgnDate"
							       type="text" 
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate\')}'})"
							       MAXDATE="#F{document.getElementById('endDate').value}" 
							       readonly="readonly"/>
							       至
					         <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择往年截止日期！'}]" 
						       id="endDate"
						       name="endDate" 
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bgnDate\')}'})"
						       MINDATE="#F{document.getElementById('bgnDate').value}"
						       readonly="readonly"/></li>
							 --与--	
							 <li class="horizontal_onlyRight">   
							 <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择本期起始日期！'}]" 
					               id="bgnDate2"
							       name="bgnDate2" 
							       type="text" 
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate2\')}'})"
							       MAXDATE="#F{document.getElementById('endDate2').value}" 
							       readonly="readonly"/>
							       至
					         <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择本期截止日期！'}]" 
						       id="endDate2"
						       name="endDate2" 
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bgnDate2\')}'})"
						       MINDATE="#F{document.getElementById('bgnDate2').value}"
						       readonly="readonly"/></li>								
							  <label style="color:red;">&nbsp;*&nbsp;</label>	
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">商品类型</TD>
			               <TD class="table_none" colspan="3">
                               <input type="checkbox" id="goodsType1" name="goodsType1" value="1" goodsType="goodsType"/>镜架&nbsp;
                               <input type="checkbox" id="goodsType2" name="goodsType2" value="2" goodsType="goodsType"/>配件&nbsp;
                               <input type="checkbox" id="goodsType3" name="goodsType3" value="3" goodsType="goodsType"/>镜片&nbsp;
                               <input type="checkbox" id="goodsType4" name="goodsType4" value="4" goodsType="goodsType"/>隐形&nbsp;
                               <input type="checkbox" id="goodsType5" name="goodsType5" value="5" goodsType="goodsType"/>护理液&nbsp;
                               <input type="checkbox" id="goodsType6" name="goodsType6" value="6" goodsType="goodsType"/>太阳镜&nbsp;
                               <input type="checkbox" id="goodsType7" name="goodsType7" value="7" goodsType="goodsType"/>耗材&nbsp;
                               <input type="checkbox" id="goodsType8" name="goodsType8" value="8" goodsType="goodsType"/>老花镜&nbsp;
                               <input type="checkbox" id="goodsType9" name="goodsType9" value="9" goodsType="goodsType"/>视光&nbsp;                            
                               <label style="color:red;">&nbsp;*&nbsp;</label>	           
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">是否显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
                  </DIV>
                </DIV>

                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
