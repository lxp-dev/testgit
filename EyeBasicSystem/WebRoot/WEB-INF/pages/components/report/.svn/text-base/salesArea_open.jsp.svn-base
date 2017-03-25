<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询价格区间</title>
</head>
<script>

	/**
	 *  调用页面赋值
	 */
	function setValue(){ 	         
        var chk=$('input[id=chk]');
        var objValue="";
        var count=0;
        var chktext=$("input[id=salesArea]",window.parent.document).val();
		var temp=chktext.split(",");
      
          	if(temp!="")
          	{         		
          		for(var i=0;i<temp.length;i++)
          		{	
          			var mm=true;	
          			$("input[id=chk]").each(function()
          			{
	          			if(temp[i]==$(this).attr("areaid"))
	          			{
			              mm=false;
			           }
		           });
		           if(mm)
		           {
		           		if(objValue=="")
		           	 	{
			           		objValue="{'areaid':'"+temp[i]+"'}";
			         	}else
			         	{
			           		objValue=objValue+","+"{'areaid':'"+temp[i]+"'}";
			         	}  
			        }
          		}
		}
        for(var i=0;i<chk.length;i++)
        {
           if(chk[i].checked==true)
           {
           	 if(objValue=="")
           	 {
	           objValue=chk[i].value;
	         }else
	         {
	           objValue=objValue+","+chk[i].value;
	         }  
	         count++;          
           }
        }   
        objValue="["+objValue+"]";
        
        window.parent.openAmountValues(objValue);
        
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){ 
        var chks=document.all.chks;
        var count = 0;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
            count++;
        }); 

        if (count > 0){
        	setValue();
        }
        
    }
	
    /**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue()
    {
        var chktext= "";
		chktext	=$("input[id=salesArea]",window.parent.document).val();
          $("input[id=chk]").each(function(){	
          	var temp=chktext.split(",");
          	if(temp!="")
          	{
          		for(var i=0;i<temp.length;i++)
          		{	
          		
          			if(temp[i]==$(this).attr("areaid"))
          			{
		              $(this).attr("checked","checked");
		           }
          		}
          	}
         	
		});
    }
    $(document).ready(function (){
		setCheckValue();
    	var typeID = "${requestScope.typeID}";
    	if(typeID == "") {
        	typeID = "1";
    	}
    	setDisabled(typeID);
	});

	function seachArea() {
		departmentstForm.action="salesAreaOpen.action";
		departmentstForm.submit();
	}
	function setDisabled(typeId) {
		$("#type").val(typeId);
		$("input[id=saleTypeID]").attr("disabled", true);
		$("input[id=categoryID]").attr("disabled", true);
		$("#type").attr("disabled", true);

		if(typeId == 1) {
			$("tr[id=salesTr]").attr("style", "display:none");
			$("tr[id=goodsTr]").attr("style", "");
		} else {
			$("tr[id=goodsTr]").attr("style", "display:none");
			$("tr[id=salesTr]").attr("style", "");
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

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
				</TD></TR>
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
                    
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                   
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                       <TR>
						   <TD width="10%" height="26" class="table_body">价格区间类型</TD>
			               <TD width="90%" class="table_none" colspan="5">
			                 <select id="type" name="typeID" onchange="setDisabled(this.selectedIndex+1)">
			                 	<option ${requestScope.typeID eq 1 ? 'selected="selected"' : "" } value="1">商品类型</option>
			                 	<option ${requestScope.typeID eq 2 ? 'selected="selected"' : "" } value="2">销售类型</option>
			                 </select>
			               </TD>
                       </TR>
                       <TR id="goodsTr">
						   <TD width="10%" height="26" class="table_body">商品类别</TD>
			               <TD width="90%" class="table_none" colspan="5">
                             <TABLE>
                               <TR>
                                 <s:iterator value="goodsCategoryList">
                                   <TD>
                                     <input type="radio" id="categoryID" name="goodsCategoryID" ${requestScope.goodsCategoryID eq bgcid ? 'checked="checked"' : ''} value="${bgcid }" onclick="seachArea()"/>${bgcgoodscategoryname }
                                   </TD>
                                 </s:iterator>
                               </TR>
                             </TABLE>
			               </TD>
                        </TR>
                       <TR id="salesTr">
						   <TD width="10%" height="26" class="table_body">销售类别</TD>
			               <TD width="90%" class="table_none" colspan="5">
                             <TABLE>
                               <TR>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="1" onclick="seachArea()" ${requestScope.salesTypeID eq 1 ? 'checked="checked"' : "" }/>框镜成品
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="2" onclick="seachArea()" ${requestScope.salesTypeID eq 2 ? 'checked="checked"' : "" }/>框镜订制
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="3" onclick="seachArea()" ${requestScope.salesTypeID eq 3 ? 'checked="checked"' : "" }/>隐形成品
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="4" onclick="seachArea()" ${requestScope.salesTypeID eq 4 ? 'checked="checked"' : "" }/>隐形订制
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="5" onclick="seachArea()" ${requestScope.salesTypeID eq 5 ? 'checked="checked"' : "" }/>辅料
                                 </TD>
                               </TR>
                             </TABLE>
			               </TD>
                        </TR>
                    </table>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>  
                          <TH width="95%" scope=col>价格区间</TH>                        
						</TR>						  
						<s:iterator value="salesAreaList">	
							<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
								<TD height="26">
		                          	<input type="checkbox" id="chk" areaid="${rsapricemin}-${rsapricemax}" onClick="setValue();" value="{'areaid':'${rsapricemin}-${rsapricemax}'}">
		                        </TD>
                          		<TD>${rsapricemin}-${rsapricemax}</TD>                          		
							</TR>
						</s:iterator>
						
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