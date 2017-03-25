<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>卡号扫描</title>
</head>
<script>

			var url = "getCustomerInfoByHis.action";
			var targetpage = "/WEB-INF/pages/aierhis/cusOpenWin/hisCusWin.jsp";
			var memberid = '${memberid}';
			var pflag = '${pflag}';
	function getPersonDetails(obj){
	
		if(event.keyCode==13){
			if($("#inputfocus").val() == '' || $("#inputfocus").val() == null){
				alert("请扫描员工卡号！");
				return;
			}
			 
			if(pflag == '0'){ //'${pflag}' == '0'不能向HIS读取患者信息
				parent.hidePopWin();
				parent.$("#smecimemberid").focus().val($("#inputfocus").val());
				parent.$("#smecicustomerid").val(memberid);
				window.parent.selectCust(true);
			}else if(pflag == '1'){ //'${pflag}' == '1'可以向HIS读取患者信息
				if('${person.bdplinkhisflag}'=='1' && '${systemParameterPo.fsphisflag}' == '2' ){
					selCustomerHIS(url,$("#inputfocus").val(),targetpage,pflag);
				}else{
					parent.hidePopWin();
					parent.$("#smecimemberid").focus().val($("#inputfocus").val());
					parent.$("#smecicustomerid").val(memberid);
					window.parent.selectCust(true);
				}
			}
		}
	}
	  $(function(){
		    var cardno='${cardno}';
		    var memberid='${memberid}';
		    var todayjiuzhenid='${requestScope.todayjiuzhenid}';
		     
			if(cardno!=''){
				parent.hidePopWin();
				parent.$("#smecimemberid").val(cardno);
				parent.$("#smecicustomerid").val(memberid);
				parent.$("#sopoytreatmentnum").val(todayjiuzhenid);
				window.parent.selectCust(true);
			}
			$('#inputfocus').focus();
			$('#inputfocus').select();
	    });

</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  style="overflow：none;">
<br/><br/> 
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 class="privateBorder">
  <TBODY>
  <TR>
    <TD vAlign=top>
        <table width="100%" height="30" border=0 align=center cellpadding=1 cellspacing=1 >
        	<tr>
        		<td class="table_body" width="30%" >
        			诊疗卡号
        		</td>
        		<td class="table_none" width="70%">
        			<input id="inputfocus" type="text" value="" maxlength="100" class="text_input200" onkeypress="getPersonDetails(this)"/>
           		</td>
           	</tr>
           </TABLE>
      </TD>
  </TR>
  </TBODY>
</TABLE>
${actionErrors[0]}
</body></html>
