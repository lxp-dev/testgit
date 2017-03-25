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
				
		if(checkForm(goodsForm)){

            if (bgnDate.substring(0,7) != endDate.substring(0,7)){
                alert('本期日期请选择同年份、月份的日期!');
                return;
            }
            if (bgnDate2.substring(0,7) != endDate2.substring(0,7)){
                alert('往年日期请选择同年份、月份的日期!');
                return;
            }
			
			var DataURL = "report.action?reportlet=sales_xiaoshouyejidizengbiRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&shopCode="+shopCode+"&bgnDate="+bgnDate+"&endDate="+endDate+"&bgnDate2="+bgnDate2+"&endDate2="+endDate2+"&shopCodeName="+EncodeUtf8(shopCodeName)+"&isShow="+isShow;    
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				openWindowForReport(DataURL);				
			}		
			document.getElementById('popupTitle').innerHTML="【门店销售业绩递增比表】";
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>工作量类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店销售业绩递增比表 </TD>
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
			               <TD class="table_none" width="38%">
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
			               <!-- 
							   	<select id="bgnyear" name="bgnyear" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择往年年份！'}]">
							   	    <option value="">----请选择----</option>      		                          
      		                        <c:forEach var="i" begin="2013" end="${currentYear}" step="1"> 
                                      <option value="${i}">${i}</option>
      		                        </c:forEach>      		                 
      	                        </select>								
						  		<select id="bgnmonth" name="bgnmonth" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择往年月份！'}]">
						  			<option value="">----请选择----</option>
                                    <option value="01">01</option>
                                    <option value="02">02</option>   
                                    <option value="03">03</option>   
                                    <option value="04">04</option>   
                                    <option value="05">05</option>
                                    <option value="06">06</option>   
                                    <option value="07">07</option>   
                                    <option value="08">08</option> 
                                    <option value="09">09</option>
                                    <option value="10">10</option>   
                                    <option value="11">11</option>   
                                    <option value="12">12</option>                                                                                                                                                                                                 
      	                        </select>
      	                        --与--
      	                        <select id="endyear" name="endyear" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择本期年份！'}]">
							   	    <option value="">----请选择----</option>      		                          
      		                        <c:forEach var="i" begin="2013" end="${currentYear}" step="1"> 
                                      <option value="${i}">${i}</option>
      		                        </c:forEach>      		                 
      	                        </select>								
						  		<select id="endmonth" name="endmonth" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择本期月份！'}]">
						  			<option value="">----请选择----</option>
                                    <option value="01">01</option>
                                    <option value="02">02</option>   
                                    <option value="03">03</option>   
                                    <option value="04">04</option>   
                                    <option value="05">05</option>
                                    <option value="06">06</option>   
                                    <option value="07">07</option>   
                                    <option value="08">08</option> 
                                    <option value="09">09</option>
                                    <option value="10">10</option>   
                                    <option value="11">11</option>   
                                    <option value="12">12</option>                                                                                                                                                                                                 
      	                        </select>
      	                      -->
      	                      
	      	                  <li class="horizontal_onlyRight">   
	      	                  <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择往年起始日期！'}]" 
					               id="bgnDate2"
							       name="bgnDate2"
							       type="text" 
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate2\')}'})"
							       MAXDATE="#F{document.getElementById('endDate2').value}" 
							       readonly="readonly"/>
							       至
					         <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择往年截止日期！'}]" 
						       id="endDate2"
						       name="endDate2" 
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bgnDate2\')}'})"
						       MINDATE="#F{document.getElementById('bgnDate2').value}"
						       readonly="readonly"/></li>
							 --与--	
							 <li class="horizontal_onlyRight">   
							 <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择本期起始日期！'}]" 
					               id="bgnDate"
							       name="bgnDate" 
							       type="text" 
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate\')}'})"
							       MAXDATE="#F{document.getElementById('endDate').value}" 
							       readonly="readonly"/>
							       至
					         <input class="text_input80" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择本期截止日期！'}]" 
						       id="endDate"
						       name="endDate" 
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bgnDate\')}'})"
						       MINDATE="#F{document.getElementById('bgnDate').value}"
						       readonly="readonly"/></li>								
							  <label style="color:red;">&nbsp;*&nbsp;</label>	
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">是否显示查询条件</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
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
            <c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">
1.查询条件：【销售门店】为非必填，不选取任何门店的情况下，默认查询所有门店，选取门店时可以任意选取多个或单一门店；【对比日期】为必填项，<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用于选取对比的日期段；【是否显示查询条件】用于在报表中是否呈现所选的查询信息。<br/>
2.报表说明：&nbsp;&nbsp;用于查看各个门店在当前日期段内总销售业绩以及平均业绩，并与往年日期段内总销售业绩进行对比，计算递增比。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销售业绩、每日平均、预计当月业绩、往年业绩均按门店实际收入统计。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;营运指标、完成比、排名、预计完成比为手工填写项。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对比日期格式：【往年起始日期】至【往年截止日期 】--与--【本期起始日期】至【本期截止日期 】。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;【往年日期段】必须为同年份、月份内的日期；【往年日期段】必须为同年份、月份内的日期。<br/>
3.涉及公式：【销售业绩】:各门店在当前日期段内总销售业绩(包含挂号费、积分抵扣等)。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;【往年业绩】:各门店在往年日期段内总销售业绩(包含挂号费、积分抵扣等)。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;【每日平均】:销售业绩&nbsp;/&nbsp;当前查询日期天数。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;【递增比】:(销售业绩-往年业绩)&nbsp;/&nbsp;往年业绩。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;【预计当月业绩】:每日平均&nbsp;*&nbsp;当月天数。<br/>

					</div>														
			</c:if>	
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
