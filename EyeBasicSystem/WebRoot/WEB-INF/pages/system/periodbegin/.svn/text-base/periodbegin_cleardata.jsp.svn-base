<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>清空数据</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		$('input[id=chks]').attr('checked','checked');
		chkAll();
	});
	

	function save(){

		if (($('input[id=chk]:checked').size() + $('input[id=chk2]:checked').size()) == 0){
            alert('请选择需要清空的数据!');
            return;
		}

		if(checkForm(periodBeginFrm)){
			$("img").removeAttr("onclick");
			periodBeginFrm.action = "insertPeriodBeginClearData.action";
			periodBeginFrm.submit();
			showLoadingBar();
		}

	}

	function chkAll(){
        var chks=document.all.chks;
        $('input[id=chk]').each(function (){
            $(this).attr('checked',$('input[id=chks]').attr('checked'));
        });
        $('input[id=chks1]').attr('checked',$('input[id=chks]').attr('checked'));
    }

	function chkAll2(){
        var chks=document.all.chks;
        $('input[id=chk]').each(function (){
            $(this).attr('checked',$('input[id=chks1]').attr('checked'));
        });
        $('input[id=chks]').attr('checked',$('input[id=chks1]').attr('checked'));
    }

	function chkAll3(){
        var chks=document.all.chks2;
        $('input[id=chk2]').each(function (){
            $(this).attr('checked',$('input[id=chks2]').attr('checked'));
        });
        $('input[id=chks3]').attr('checked',$('input[id=chks2]').attr('checked'));
    }

	function chkAll4(){
        var chks=document.all.chks3;
        $('input[id=chk2]').each(function (){
            $(this).attr('checked',$('input[id=chks3]').attr('checked'));
        });
        $('input[id=chks2]').attr('checked',$('input[id=chks3]').attr('checked'));
    }

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<FORM name="periodBeginFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}"> 
<s:token></s:token>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- 头部菜单 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/sys/tab_bg.gif>
          </TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 
                  background=${ctx}/img/sys/tab_bg.gif><IMG 
                  height=1 src="${ctx}/img/sys/tab_bg.gif" 
                  width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><INPUT id=FrameWork_YOYO_LzppccSelectIndex 
                  type=hidden value=0 name=FrameWork_YOYO_LzppccSelectIndex><!--内容框Start-->
                  <DIV id=tabContent__0 style="DISPLAY: ">
                   <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  <DIV id=rightsTable >
   <!-----------------------------------------------------------------------------------------------------------------------------------------------> 
   <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
       <TBODY>	
           <TR>
		       <TH align="left" colSpan=9><label style="color:red;"><b>由于使用此功能之后，相应数据被删除，建议使用此功能前先行备份数据库!</b></label></TH>
		   </TR>

           <TR>
               <TD width="10%" colSpan=8 height="26" class="table_body">所属公司</TD>
               <TD width="90%" height="26" class="table_none">
                   <c:if test="${person.personcompanytype == '1'}">
		               <select id="pbccompanyid" name="periodBeginClearPo.pbccompanyid">
		                   <option value="">所有公司</option>
		                   <s:iterator value="companyNamePos">
		                       <option value="${fcnId }">${fcnName}</option>
		                   </s:iterator>
		               </select><label style="color:red;">&nbsp;默认清空所有公司的数据</label>
	               </c:if>
	               
	               <c:if test="${person.personcompanytype != '1'}">
	                   <input type="hidden" id="pbccompanyid" name="periodBeginClearPo.pbccompanyid" value="${person.personcompanyid }">${person.personcompanyname}
	               </c:if>
	               
               </TD>
           </TR>
                
 		   <TR class=table_title align=middle>
		       <TH align="right" colSpan=8>全选<input type="checkbox" id="chks" name="chks" value="1" onclick="chkAll()"/></TH>
		       <TH align=left height="26"></TH>
		   </TR>

           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill4" value="1" /></TD>
               <TD align=left height="26">库存预警</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill5" value="1" /></TD>
               <TD align=left height="26">在途库存</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill6" value="1" /></TD>
               <TD align=left height="26">盘点单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill7" value="1" /></TD>
               <TD align=left height="26">盈亏分析单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill8" value="1" /></TD>
               <TD align=left height="26">调拨单：各公司只能删除本公司内部的调拨单，跨公司的调拨单不能单独删除，只能在总公司并将所属公司的条件置为默认时由删除全部的调拨单。</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill9" value="1" /></TD>
               <TD align=left height="26">调拨申请单</TD>
           </TR>
                      
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill11" value="1" /></TD>
               <TD align=left height="26">不合格品单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill12" value="1" /></TD>
               <TD align=left height="26">委外订单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill13" value="1" /></TD>
               <TD align=left height="26">采购订单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill14" value="1" /></TD>
               <TD align=left height="26">业务单据：包括采购收货单、采购退货单、销售出库单、盘亏单、盘盈单、其他入库单、其他出库单。</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill15" value="1" /></TD>
               <TD align=left height="26">委外收货单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill16" value="1" /></TD>
               <TD align=left height="26">收货检验单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill17" value="1" /></TD>
               <TD align=left height="26">领用出库单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill19" value="1" /></TD>
               <TD align=left height="26">财务数据：包括凭证、发票、制造商往来、付款单等财务数据。</TD>
           </TR>
 
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill22" value="1" /></TD>
               <TD align=left height="26">门店积分兑换单</TD>
           </TR>
           
           <TR class=table_none align=middle>     
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill23" value="1" /></TD>                    
               <TD align=left height="26">各张报表数据：包括所有工作量报表、商品销售分析表、销售业绩表、商品库存周转率表等报表数据（除商品销售统计表）。</TD>
           </TR>
           
           <TR class=table_none align=middle> 
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill24" value="1" /></TD>                        
               <TD align=left height="26">挂号</TD>
           </TR>
           
           <TR class=table_none align=middle>
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill25" value="1" /></TD>                         
               <TD align=left height="26">维修收费</TD>
           </TR>           
                      
           <TR class=table_none align=middle> 
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill26" value="1" /></TD>                        
               <TD align=left height="26">销售数据：包括邮寄、附加费、加工要求、在途及加工等所有与配镜单有关的全部数据。</TD>
           </TR>
           
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill27" value="1" /></TD>                       
               <TD align=left height="26">预销售设置：包括业绩进度表等设置的预销售设置。</TD>
           </TR>           
                      
           <TR class=table_none align=middle>   
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill28" value="1" /></TD>                      
               <TD align=left height="26">无库存销售</TD>
           </TR>
           
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk" name="periodBeginClearPo.pbcbill40" value="1" /></TD>                       
               <TD align=left height="26">库存</TD>
           </TR>

  		   <TR class=table_title align=middle>
		       <TH align="right" colSpan=8>全选<input type="checkbox" id="chks1" name="chks1" value="1" onclick="chkAll2()"/></TH>
		       <TH align=left height="26"></TH>
		   </TR>
		   
		   <TR>
		       <TH align="left" colSpan=9><label style="color:red;"><b>由于使用此功能之后，相应数据被删除，建议使用此功能前先行备份数据库!</b></label></TH>
		   </TR>
		  
       </TBODY>
   </TABLE> 
   
   <c:if test="${person.personcompanytype == '1'}">
    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
       <TBODY>	

           <TR>
               <TD width="10%" colSpan=8 height="26" class="table_body">所属公司</TD>
               <TD width="90%" height="26" class="table_none">所有公司</TD>
           </TR>
                
 		   <TR class=table_title align=middle>
		       <TH align="right" colSpan=8>全选<input type="checkbox" id="chks2" name="chks2" value="1" onclick="chkAll3()"/></TH>
		       <TH align=left height="26"></TH>
		   </TR>
		                                
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill1" value="1" /></TD>
               <TD align=left height="26">含税成本调价单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill2" value="1" /></TD>
               <TD align=left height="26">零售价调价单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill3" value="1" /></TD>
               <TD align=left height="26">批发价调价单</TD>
           </TR>

           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill10" value="1" /></TD>
               <TD align=left height="26">客户批发调货申请单</TD>
           </TR>
  
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill18" value="1" /></TD>
               <TD align=left height="26">客户批发调货单/客户批发退货单</TD>
           </TR>
           
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill44" value="1" /></TD>                       
               <TD align=left height="26">会员信息</TD>
           </TR>
                                 
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill29" value="1" /></TD>                       
               <TD align=left height="26">清空会员积分、销售次数、消费金额及积分使用记录</TD>
           </TR>
           
           <TR class=table_none align=middle> 
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill30" value="1" /></TD>                        
               <TD align=left height="26">会员投诉记录</TD>
           </TR>
           
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill31" value="1" /></TD>                       
               <TD align=left height="26">会员回访记录</TD>
           </TR>

           <TR class=table_none align=middle>   
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill32" value="1" /></TD>                      
               <TD align=left height="26">积分使用记录</TD>
           </TR> 
           
           <TR class=table_none align=middle> 
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill33" value="1" /></TD>                        
               <TD align=left height="26">会员升级记录</TD>
           </TR>
             
           <TR class=table_none align=middle> 
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill21" value="1" /></TD>              
               <TD align=left height="26">验光：包括屈光检查、双眼视功能、检查结论、眼部健康检查、散瞳等全部验光数据。</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill20" value="1" /></TD>
               <TD align=left height="26">人事：包括排班、档案、薪酬、培训等全部人事数据。</TD>
           </TR>
 
           <TR class=table_none align=middle>
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill34" value="1" /></TD>                         
               <TD align=left height="26">套餐</TD>
           </TR>            
                                
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill35" value="1" /></TD>
               <TD align=left height="26">储值卡</TD>
           </TR>
           
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill36" value="1" /></TD>                       
               <TD align=left height="26">打折卡、员工打折券</TD>
           </TR>
           
           <TR class=table_none align=middle>  
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill38" value="1" /></TD>                       
               <TD align=left height="26">微信</TD>
           </TR>
                               
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill37" value="1" /></TD>
               <TD align=left height="26">短信记录</TD>
           </TR>
             
           <TR class=table_none align=middle>   
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill39" value="1" /></TD>                      
               <TD align=left height="26">系统操作日志</TD>
           </TR>
        
           <TR class=table_none align=middle>   
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill41" value="1" /></TD>                      
               <TD align=left height="26">客户批发导入单</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill42" value="1" /></TD>
               <TD align=left height="26">财务数据：包括客户往来、收款单等财务数据。</TD>
           </TR>
           
           <TR class=table_none align=middle>               
               <TD align="right" colSpan=8><input type="checkbox" id="chk2" name="periodBeginClearPo.pbcbill43" value="1" /></TD>
               <TD align=left height="26">商品销售统计报表、商品进销存报表数据。</TD>
           </TR>

  		   <TR class=table_title align=middle>
		       <TH align="right" colSpan=8>全选<input type="checkbox" id="chks3" name="chks3" value="1" onclick="chkAll4()"/></TH>
		       <TH align=left height="26"></TH>
		   </TR>
		   
		   <TR>
		       <TH align="left" colSpan=9><label style="color:red;"><b>由于使用此功能之后，相应数据被删除，建议使用此功能前先行备份数据库!</b></label></TH>
		   </TR>
		  
       </TBODY>
   </TABLE> 
   </c:if>
   
   	<table>		                                             	           
		  <tr>
			<td colspan="9" align="left">
				<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onClick="save()">
		    </td>
		  </tr>
	</table>
   
   <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
	<table id="loadingBar" width="100%" STYLE="display:none">
	  <tr><td height="10">&nbsp;</td></tr>
	  <tr>                         
	    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
	    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
		<script>
			function showLoadingBar(){
				gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
				document.getElementById("loadingBar").style.display="";
			}
		</script>                            
	    </td>
	</tr>
	</table>                      
	<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->

</DIV></DIV><!--内容框End--></TD>
                <TD width=1 
                  background=${ctx}/img/sys/tab_bg.gif><IMG 
                  height=1 src="${ctx}/img/sys/tab_bg.gif" 
                  width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background="${ctx}/img/sys/tab_bg.gif" bgColor="#ffffff">
          	<IMG height=1 src="${ctx}/img/sys/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--选项卡 End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></FORM></DIV></body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>