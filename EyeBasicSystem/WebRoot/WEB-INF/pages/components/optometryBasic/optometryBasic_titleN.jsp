<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	$(document).ready(function() {
	
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
         
		if($('#customerReadonly').val() == null){
			if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
				document.getElementById('smecimemberid').focus(); 
	        }
			$('#smecimemberid').keyup(function(){
				selectCustomer();
			});
		}else {
			//document.getElementById('smecimemberid').readOnly = true;
			$("[hidebtn=hidebtn]").hide();
		}
		
		if('${optometryPersonID }' != ''){
			$('#optometryPerson').attr("disabled","disabled");
		}
	});

	function customerDetails(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid=${customerInfoPo.smecicustomerid}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid=${customerInfoPo.smecicustomerid}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}
	
	function disabledOptometryPersonSelect(){
		$('#optometryPerson').attr("disabled","disabled");
		$('#optometryPersonName').val($('#optometryPerson').find("option:selected").text());
		$('#optometryPersonID').val($('#optometryPerson').val());
	}
	
	function changeOptometryPerson(){
		if ($('#optometryPerson').attr("disabled") == true){
			$('#optometryPerson').attr("disabled","");
		}else{
			$('#optometryPerson').attr("disabled","disabled");
	    }	
	}
	 
</script>

<fieldset>
	<legend>
		<table>
			<tr>
				<td valign="middle">
					验光信息
			  </td>
			</tr>
		</table>
	</legend>
	<TABLE width="98%" id="title1" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
	  <tr>
	    <td bgcolor="#cadee8"><li class="horizontal">验光号&nbsp;
	            <input type="text" name="optometryPo.sopoyoptometryid" class="text_input200" value="${optometryPo.sopoyoptometryid }" readOnly="readOnly">
	            <input type="hidden" value="${optometryPo.sopoyoptometryid }" name="optometryID"/>
	            <input type="hidden" name="optometryPo.sopoyoptometrybasicid" class="text_input200" value="${optometryPo.sopoyoptometrybasicid }" readOnly="readOnly">
	      </li>
	      <li class="horizontal">验光师&nbsp;
	      	<c:if test="${systemParameterPo.fspselectoptometrist eq ''}">
	            <font color="red">验光师选择样式未设置</font>
	        </c:if>
	      	<c:if test="${systemParameterPo.fspselectoptometrist eq '1'}">
	            <input name="optometryPersonName" class="text_input100" readOnly="readOnly" value="${person.personName }">
	            <input id="optometryPersonID" name="optometryPersonID" type="hidden" value="${person.id }">
	        </c:if>
	        <c:if test="${systemParameterPo.fspselectoptometrist eq '2' && selecttype eq '1' && empty(optometryPo.sopoypersonid) }">
	            <li id="saleserDiv" class="horizontal_onlyRight">
					<select id="optometryPerson" name="optometryPerson" onchange="disabledOptometryPersonSelect()" disabled="disabled">
					    <option value="" selected="selected">---请选择---</option>
						<c:forEach var="opo" items="${optometryPersonInfoPos}">
							<c:if test="${empty(optometryPersonID) }">
								<option value="${opo.id }" ${person.id eq opo.id ? 'selected="selected"' : '' }>${opo.personName }</option>
							</c:if>
							<c:if test="${not empty(optometryPersonID) }">
								<option value="${opo.id }" ${optometryPersonID eq opo.id ? 'selected="selected"' : '' }>${opo.personName }</option>
							</c:if>
						</c:forEach>
					</select>
					<input type="hidden" id="optometryPersonName" name="optometryPersonName" value="${not empty(optometryPersonName) ? optometryPersonName : person.personName }"/>
					<input type="hidden" id="optometryPersonID" name="optometryPersonID" value="${not empty(optometryPersonID) ? optometryPersonID : person.id }"/>
				</li>
				<li id="saleserDiv" class="horizontal_onlyRight">
					<img name="button32" hidebtn=hidebtn btn=btn id="btnlock" src="${ctx}/img/newbtn/lock_0.png" title="解除/锁定" align="left"  onclick="changeOptometryPerson()">
				</li>
	        </c:if>
	        <c:if test="${(systemParameterPo.fspselectoptometrist eq '3' || (systemParameterPo.fspselectoptometrist eq '2' && selecttype ne '1')) && empty(optometryPo.sopoypersonid)}">
	            <li id="saleserDiv" class="horizontal_onlyRight">
					<select id="optometryPerson" name="optometryPerson" onchange="disabledOptometryPersonSelect()">
					    <option value="" selected="selected">---请选择---</option>
						<c:forEach var="opo" items="${optometryPersonInfoPos}">
							<option value="${opo.id }" ${optometryPersonID eq opo.id ? 'selected="selected"' : '' }>${opo.personName }</option>
						</c:forEach>
					</select>
					<input type="hidden" id="optometryPersonName" name="optometryPersonName" value="${optometryPersonName }"/>
					<input type="hidden" id="optometryPersonID" name="optometryPersonID" value="${optometryPersonID }"/>
				</li>
				<li id="saleserDiv" class="horizontal_onlyRight">
					<img name="button32" hidebtn=hidebtn btn=btn id="btnlock" src="${ctx}/img/newbtn/lock_0.png" title="解除/锁定" align="left"  onclick="changeOptometryPerson()">
				</li>
	        </c:if>
	        <c:if test="${not empty(optometryPo.sopoypersonid)}">
	            <input name="optometryPersonName" class="text_input100" readOnly="readOnly" value="${optometryPo.sopoypersonname }">
	            <input id="optometryPersonID" name="optometryPersonID" type="hidden" value="${optometryPo.sopoypersonid }">
	        </c:if>
	      </li>
	      <li class="horizontal">日期&nbsp;
	            <input name="userName423" class="text_input80" readOnly="readOnly" value="${fn:substring(optometryPo.sopoytime, 0, 10) }">
	      </li>
	  </tr>
</table>
 </fieldset>			
<br />		
 
<fieldset>
	<legend>顾客资料</legend>
	<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
      <tr>
        <td bgcolor="#cadee8">
          <li class="horizontal">卡号&nbsp; 
            <input type="text" id="smecimemberid" name="customerInfoPo.smecimemberid" class="text_input100"  value="${customerInfoPo.smecimemberid }" 
            onkeydown="selectCustomer();" ${systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }>
            <input type="hidden" id="isfresh" name="isfresh" value="${customerInfoPo.smecimemberid }" >
            <input type="hidden" id="smecicustomerid" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid }">
            <input type="hidden" name="memberID" value="${ memberID}"/>
          </li>
          <li class="horizontal">
            <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' > 
            <img name="button22" hidebtn=hidebtn src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title="查询" onclick="selCustomer();" id='searchbutton'>
          </li>
    
          <li class="horizontal">姓名&nbsp;
                <input class="text_input60" name="customerInfoPo.smeciname" readOnly="readOnly" value="${customerInfoPo.smeciname }">
          </li>
          <li class="horizontal">性别&nbsp;
                <input value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" class="text_input40" readOnly="readOnly">
          </li>
          <li class="horizontal">年龄&nbsp;
                <input value="${customerInfoPo.fmmage}" class="text_input40" readOnly="readOnly">
          </li>
          <li class="horizontal">&nbsp;
          <c:if test="${dontshow != '1'}">
          	<c:if test="${empty(customerInfoPo.smecicustomerid)}">
          	</c:if>
          	<c:if test="${not empty(customerInfoPo.smecicustomerid)}">
            	<img name="button32" title='详细' src="${ctx }/img/newbtn/btn_details_0.png" btn=btn onClick="javascript:customerDetails('${customerInfoPo.smecicustomerid }');">
          	</c:if>
          </c:if>
          </li>
      </tr>
    </table>
</fieldset>
<script>
    
			
function selectCust(flag){
   if(flag){
    	document.forms[0].submit();
   }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			document.forms[0].submit();
		}
	}
}
	
	function details(id){
		showPopWin(""," ?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}	
	function selCustomer(){
        if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
            return;
        }
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
	}
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		document.forms[0].submit();
	}

</script>