<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<title>报表中心</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 
	
	function save(){
		$("img").removeAttr("onclick");
		goodsForm.action = "insertReportQuartzData.action";
		goodsForm.submit();
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="fquartzSwitchPo.fqsuuid" value="${fquartzSwitchPo.fqsuuid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：定时任务开关维护 </td>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD></TR>
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
                     
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                       <TR>
                          <TD height="26" width="20%" class="table_body " align="right">商品零售价定时调价</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqslsjtj" name="fquartzSwitchPo.fqslsjtj"  value="0" ${fquartzSwitchPo.fqslsjtj == '0' ? 'checked':'' }>
                          		关闭后，将导致零售价调价单无法使用按时调价功能
                          	<br/><input type="radio" id="fqslsjtj" name="fquartzSwitchPo.fqslsjtj"  value="1" ${fquartzSwitchPo.fqslsjtj == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">商品含税成本定时调价</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqscbjtj" name="fquartzSwitchPo.fqscbjtj"  value="0" ${fquartzSwitchPo.fqscbjtj == '0' ? 'checked':'' }>
                          		关闭后，将导致含税成本调价单无法使用按时调价功能
                          	<br/><input type="radio" id="fqscbjtj" name="fquartzSwitchPo.fqscbjtj"  value="1" ${fquartzSwitchPo.fqscbjtj == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">商品批发价定时调价</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqspfjtj" name="fquartzSwitchPo.fqspfjtj"  value="0" ${fquartzSwitchPo.fqspfjtj == '0' ? 'checked':'' }>
                          		关闭后，将导致批发价调价单无法使用按时调价功能
                          	<br/><input type="radio" id="fqspfjtj" name="fquartzSwitchPo.fqspfjtj"  value="1" ${fquartzSwitchPo.fqspfjtj == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">生日提醒</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqssrtx" name="fquartzSwitchPo.fqssrtx"  value="0" ${fquartzSwitchPo.fqssrtx == '0' ? 'checked':'' }>
                          		关闭后，将导致无法发送生日提醒短信
                            <br/><input type="radio" id="fqssrtx" name="fquartzSwitchPo.fqssrtx"  value="1" ${fquartzSwitchPo.fqssrtx == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">委外收货单转委外结算单</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqswashzwajs" name="fquartzSwitchPo.fqswashzwajs"  value="0" ${fquartzSwitchPo.fqswashzwajs == '0' ? 'checked':'' }>
                          		关闭后，将导致委外收货单无法汇总委外结算单并无法将结算单传递财务
                          	<br/><input type="radio" id="fqswashzwajs" name="fquartzSwitchPo.fqswashzwajs"  value="1" ${fquartzSwitchPo.fqswashzwajs == '1' ? 'checked':'' }>
                            	每张委外收货单都将生成一张委外结算单
                            <br/><input type="radio" id="fqswashzwajs" name="fquartzSwitchPo.fqswashzwajs"  value="2" ${fquartzSwitchPo.fqswashzwajs == '2' ? 'checked':'' }>
                            	同一制造商的委外收货单汇总成一张委外结算单
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">汇总当日库存流水</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqshzkc" name="fquartzSwitchPo.fqshzkc"  value="0" ${fquartzSwitchPo.fqshzkc == '0' ? 'checked':'' }>
                          		关闭后，可能会影响系统的库存查询效率
                          	<br/><input type="radio" id="fqshzkc" name="fquartzSwitchPo.fqshzkc"  value="1" ${fquartzSwitchPo.fqshzkc == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>					   
					   				   
			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">按商品类型汇总库存</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsasplxhzkc" name="fquartzSwitchPo.fqsasplxhzkc"  value="0" ${fquartzSwitchPo.fqsasplxhzkc == '0' ? 'checked':'' }>
                          		关闭后，将导致系统库存查询效率变慢
                            <br/><input type="radio" id="fqsasplxhzkc" name="fquartzSwitchPo.fqsasplxhzkc"  value="1" ${fquartzSwitchPo.fqsasplxhzkc == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">委外送货单汇总出库单</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqswwshdhzckdflag" name="fquartzSwitchPo.fqswwshdhzckdflag"  value="0" ${fquartzSwitchPo.fqswwshdhzckdflag == '0' ? 'checked':'' }>
                          		关闭
                          	<br/><input type="radio" id="fqswwshdhzckdflag" name="fquartzSwitchPo.fqswwshdhzckdflag"  value="1" ${fquartzSwitchPo.fqswwshdhzckdflag == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为天津眼科定制需求。)</font>
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">委外订单报残汇总出库单</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqswwddbchzckdflag" name="fquartzSwitchPo.fqswwddbchzckdflag"  value="0" ${fquartzSwitchPo.fqswwddbchzckdflag == '0' ? 'checked':'' }>
                          		关闭
                          	<br/><input type="radio" id="fqswwddbchzckdflag" name="fquartzSwitchPo.fqswwddbchzckdflag"  value="1" ${fquartzSwitchPo.fqswwddbchzckdflag == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为天津眼科定制需求。)</font>
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">报残退回负调拨汇总出库单</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsbcthfdbhzckdflag" name="fquartzSwitchPo.fqsbcthfdbhzckdflag"  value="0" ${fquartzSwitchPo.fqsbcthfdbhzckdflag == '0' ? 'checked':'' }>
                          		关闭
                          	<br/><input type="radio" id="fqsbcthfdbhzckdflag" name="fquartzSwitchPo.fqsbcthfdbhzckdflag"  value="1" ${fquartzSwitchPo.fqsbcthfdbhzckdflag == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为天津眼科定制需求。)</font>	
						  </TD>
					   </TR>
					   
			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">清空当日销售数据</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsqkdrxssj" name="fquartzSwitchPo.fqsqkdrxssj"  value="0" ${fquartzSwitchPo.fqsqkdrxssj == '0' ? 'checked':'' }>
                          		关闭后，将导致部分销售类报表数据不准确
                          	<br/><input type="radio" id="fqsqkdrxssj" name="fquartzSwitchPo.fqsqkdrxssj"  value="1" ${fquartzSwitchPo.fqsqkdrxssj == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">成本计算</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqscbjs" name="fquartzSwitchPo.fqscbjs"  value="1" ${fquartzSwitchPo.fqscbjs == '1' ? 'checked':'' }>
                          		按【不含税成本】进行成本计算
                            <br/><input type="radio" id="fqscbjs" name="fquartzSwitchPo.fqscbjs"  value="2" ${fquartzSwitchPo.fqscbjs == '2' ? 'checked':'' }>
                            	按【含税成本】进行成本计算
						  </TD>
					   </TR>
					   
			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">成本计算创建销售凭证</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqscbjscjpz" name="fquartzSwitchPo.fqscbjscjpz"  value="1" ${fquartzSwitchPo.fqscbjscjpz == '1' ? 'checked':'' }>
                          		关闭
                            <br/><input type="radio" id="fqscbjscjpz" name="fquartzSwitchPo.fqscbjscjpz"  value="2" ${fquartzSwitchPo.fqscbjscjpz == '2' ? 'checked':'' }>
                            	创建（西安波涛专用）
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">销售出库单汇总方式</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsxsckhz" name="fquartzSwitchPo.fqsxsckhz"  value="0" ${fquartzSwitchPo.fqsxsckhz == '0' ? 'checked':'' }>
                          		关闭
                            <br/><input type="radio"  id="fqsxsckhz" name="fquartzSwitchPo.fqsxsckhz"  value="1" ${fquartzSwitchPo.fqsxsckhz == '1' ? 'checked':'' }>
                          		按订金第一种方式汇总（基础版）	
                            <br/><input type="radio" id="fqsxsckhz" name="fquartzSwitchPo.fqsxsckhz"  value="2" ${fquartzSwitchPo.fqsxsckhz == '2' ? 'checked':'' }>
                            	按订金第二种方式汇总（基础版）
                            <br/><input type="radio" id="fqsxsckhz" name="fquartzSwitchPo.fqsxsckhz"  value="3" ${fquartzSwitchPo.fqsxsckhz == '3' ? 'checked':'' }>
                            	按订金第一种方式汇总（天津眼科专用）
                            <br/><input type="radio" id="fqsxsckhz" name="fquartzSwitchPo.fqsxsckhz"  value="4" ${fquartzSwitchPo.fqsxsckhz == '4' ? 'checked':'' }>
                            	按订金第二种方式汇总（天津眼科专用） 		
						  </TD>
					   </TR>					   

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">会员升级</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqshysj" name="fquartzSwitchPo.fqshysj"  value="0" ${fquartzSwitchPo.fqshysj == '0' ? 'checked':'' }>
                          		关闭后，将导致会员无法自动升级而全部采用手工的方式升级
                            <br/><input type="radio" id="fqshysj" name="fquartzSwitchPo.fqshysj"  value="1" ${fquartzSwitchPo.fqshysj == '1' ? 'checked':'' }>
                            	按基础版需求进行会员自动升级
                            <br/><input type="radio" id="fqshysj" name="fquartzSwitchPo.fqshysj"  value="2" ${fquartzSwitchPo.fqshysj == '2' ? 'checked':'' }>
                            	按北京同仁定制需求进行会员自动升级                          	
						  </TD>
					   </TR>
					   
			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">系统设置</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqswzhzstd" name="fquartzSwitchPo.fqswzhzstd"  value="1" ${fquartzSwitchPo.fqswzhzstd == '1' ? 'checked':'' }>
                          		正式系统
                            <br/><input type="radio" id="fqswzhzstd" name="fquartzSwitchPo.fqswzhzstd"  value="2" ${fquartzSwitchPo.fqswzhzstd == '2' ? 'checked':'' }>
                            	外帐系统
                            <br/><font color="red">(此定时任务为西安波涛定制需求。)</font>	       	                   		
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">外帐设置</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqscdpjd" name="fquartzSwitchPo.fqscdpjd"  value="0" ${fquartzSwitchPo.fqscdpjd == '0' ? 'checked':'' }>
                          		关闭后，将导致正式系统无法向外帐系统传递配镜单
                            <br/><input type="radio" id="fqscdpjd" name="fquartzSwitchPo.fqscdpjd"  value="1" ${fquartzSwitchPo.fqscdpjd == '1' ? 'checked':'' }>
                            	开启  
                            <br/><font color="red">(此定时任务为西安波涛定制需求。)</font>	                        		
						  </TD>
					   </TR>
					   
			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">判断套餐是否过期</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqstcgq" name="fquartzSwitchPo.fqstcgq"  value="0" ${fquartzSwitchPo.fqstcgq == '0' ? 'checked':'' }>
                          		关闭后，将导致无法自动验证套餐是否过期，会对门店销售造成影响
                            <br/><input type="radio" id="fqstcgq" name="fquartzSwitchPo.fqstcgq"  value="1" ${fquartzSwitchPo.fqstcgq == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">收银员工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqssyygzl" name="fquartzSwitchPo.fqssyygzl"  value="0" ${fquartzSwitchPo.fqssyygzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计收银员工作量
                          	<br/><input type="radio" id="fqssyygzl" name="fquartzSwitchPo.fqssyygzl"  value="1" ${fquartzSwitchPo.fqssyygzl == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">检查人员工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsjcrygzl" name="fquartzSwitchPo.fqsjcrygzl"  value="0" ${fquartzSwitchPo.fqsjcrygzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计检查人员工作量
                          	<br/><input type="radio" id="fqsjcrygzl" name="fquartzSwitchPo.fqsjcrygzl"  value="1" ${fquartzSwitchPo.fqsjcrygzl == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">取镜人员工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsqjrygzl" name="fquartzSwitchPo.fqsqjrygzl"  value="0" ${fquartzSwitchPo.fqsqjrygzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计取镜人员工作量
                            <br/><input type="radio" id="fqsqjrygzl" name="fquartzSwitchPo.fqsqjrygzl"  value="1" ${fquartzSwitchPo.fqsqjrygzl == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">加工人员工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsjgsgzl" name="fquartzSwitchPo.fqsjgsgzl"  value="0" ${fquartzSwitchPo.fqsjgsgzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计加工师工作量
                          	<br/><input type="radio" id="fqsjgsgzl" name="fquartzSwitchPo.fqsjgsgzl"  value="1" ${fquartzSwitchPo.fqsjgsgzl == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">发料人员工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsflrygzl" name="fquartzSwitchPo.fqsflrygzl"  value="0" ${fquartzSwitchPo.fqsflrygzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计发料人员工作量
                          	<br/><input type="radio" id="fqsflrygzl" name="fquartzSwitchPo.fqsflrygzl"  value="1" ${fquartzSwitchPo.fqsflrygzl == '1' ? 'checked':'' }>
                            	开启
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">营业员工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsyyygzl" name="fquartzSwitchPo.fqsyyygzl"  value="0" ${fquartzSwitchPo.fqsyyygzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计营业员工作量
                            <br/><input type="radio" id="fqsyyygzl" name="fquartzSwitchPo.fqsyyygzl"  value="1" ${fquartzSwitchPo.fqsyyygzl == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>
					   
			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">验光师工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsygsgzl" name="fquartzSwitchPo.fqsygsgzl"  value="0" ${fquartzSwitchPo.fqsygsgzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计验光师工作量
                            <br/><input type="radio" id="fqsygsgzl" name="fquartzSwitchPo.fqsygsgzl"  value="1" ${fquartzSwitchPo.fqsygsgzl == '1' ? 'checked':'' }>
                            	验光师工作量（基础版）
                            <br/><input type="radio" id="fqsygsgzl" name="fquartzSwitchPo.fqsygsgzl"  value="2" ${fquartzSwitchPo.fqsygsgzl == '2' ? 'checked':'' }>
                            	验光师工作量（北京同仁专用）            	
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">日销售汇总表统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsrxshz" name="fquartzSwitchPo.fqsrxshz"  value="0" ${fquartzSwitchPo.fqsrxshz == '0' ? 'checked':'' }>
                          		关闭后，将导致部分销售类报表数据不准确
                            <br/><input type="radio" id="fqsrxshz" name="fquartzSwitchPo.fqsrxshz"  value="1" ${fquartzSwitchPo.fqsrxshz == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">日销售商品类别汇总表统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsrxssplxhz" name="fquartzSwitchPo.fqsrxssplxhz"  value="0" ${fquartzSwitchPo.fqsrxssplxhz == '0' ? 'checked':'' }>
                          		关闭后，将导致部分销售类报表数据不准确
                            <br/><input type="radio" id="fqsrxssplxhz" name="fquartzSwitchPo.fqsrxssplxhz"  value="1" ${fquartzSwitchPo.fqsrxssplxhz == '1' ? 'checked':'' }>
                            	开启                         		
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">日销售商品类别区间汇总表统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsrxssplxqjhz" name="fquartzSwitchPo.fqsrxssplxqjhz"  value="0" ${fquartzSwitchPo.fqsrxssplxqjhz == '0' ? 'checked':'' }>
                          		关闭后，将导致部分销售类报表数据不准确
                            <br/><input type="radio" id="fqsrxssplxqjhz" name="fquartzSwitchPo.fqsrxssplxqjhz"  value="1" ${fquartzSwitchPo.fqsrxssplxqjhz == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">日销售商品明细表统计 </TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsrxsspmxhz" name="fquartzSwitchPo.fqsrxsspmxhz"  value="0" ${fquartzSwitchPo.fqsrxsspmxhz == '0' ? 'checked':'' }>
                          		关闭后，将导致部分销售类报表数据不准确
                            <br/><input type="radio" id="fqsrxsspmxhz" name="fquartzSwitchPo.fqsrxsspmxhz"  value="1" ${fquartzSwitchPo.fqsrxsspmxhz == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">销售产品同期综合对比分析表(隐形镜片分析)</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqssscptqzhdbfxb" name="fquartzSwitchPo.fqssscptqzhdbfxb"  value="0" ${fquartzSwitchPo.fqssscptqzhdbfxb == '0' ? 'checked':'' }>
                          		关闭后，将导致部分销售类报表数据不准确
                            <br/><input type="radio" id="fqssscptqzhdbfxb" name="fquartzSwitchPo.fqssscptqzhdbfxb"  value="1" ${fquartzSwitchPo.fqssscptqzhdbfxb == '1' ? 'checked':'' }>
                            	开启 
                            <br/><font color="red">(此定时任务为重庆精益定制需求。)</font>	                         		
						  </TD>
					   </TR>

			           <TR>
                          <TD height="26" width="20%" class="table_body " align="right">商品库存周转率统计表</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqskczzl" name="fquartzSwitchPo.fqskczzl"  value="0" ${fquartzSwitchPo.fqskczzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计商品库存周转率统计表数据
                            <br/><input type="radio" id="fqskczzl" name="fquartzSwitchPo.fqskczzl"  value="1" ${fquartzSwitchPo.fqskczzl == '1' ? 'checked':'' }>
                            	开启                         		
						  </TD>
					   </TR>
					   					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">挂号台工作量统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsghtgzl" name="fquartzSwitchPo.fqsghtgzl"  value="0" ${fquartzSwitchPo.fqsghtgzl == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计挂号台工作量
                          	<br/><input type="radio" id="fqsghtgzl" name="fquartzSwitchPo.fqsghtgzl"  value="1" ${fquartzSwitchPo.fqsghtgzl == '1' ? 'checked':'' }>
                            	挂号台工作量（北京同仁专用）
						  </TD>
					   </TR>
					   
					   					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">商品销售统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqssoxstj" name="fquartzSwitchPo.fqssoxstj"  value="0" ${fquartzSwitchPo.fqssoxstj == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计商品销售统计表数据
                            <br/><input type="radio" id="fqssoxstj" name="fquartzSwitchPo.fqssoxstj"  value="1" ${fquartzSwitchPo.fqssoxstj == '1' ? 'checked':'' }>
                            	开启                          		
						  </TD>
					   </TR>
					   
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">汇总客单价统计</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqshzkdjtjb" name="fquartzSwitchPo.fqshzkdjtjb"  value="0" ${fquartzSwitchPo.fqshzkdjtjb == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计客单价统计表数据
                            <br/><input type="radio" id="fqshzkdjtjb" name="fquartzSwitchPo.fqshzkdjtjb"  value="1" ${fquartzSwitchPo.fqshzkdjtjb == '1' ? 'checked':'' }>
                            	开启   
                            <br/><font color="red">(此定时任务为四川大光明定制需求。)</font>	                      		
						  </TD>
					   </TR>

					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">分店销售指南表</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqsfdxsznbflag" name="fquartzSwitchPo.fqsfdxsznbflag"  value="0" ${fquartzSwitchPo.fqsfdxsznbflag == '0' ? 'checked':'' }>
                          		关闭后，将导致无法统计分店销售指南表表数据
                          	<br/><input type="radio" id="fqsfdxsznbflag" name="fquartzSwitchPo.fqsfdxsznbflag"  value="1" ${fquartzSwitchPo.fqsfdxsznbflag == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为天津眼科定制需求。)</font>
						  </TD>
					   </TR>
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">自动关账和创建临时凭证表</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqszdgzhcjlspzbflag" name="fquartzSwitchPo.fqszdgzhcjlspzbflag"  value="0" ${fquartzSwitchPo.fqszdgzhcjlspzbflag == '0' ? 'checked':'' }>
                          		关闭后，将导致无法自动关账和创建临时凭证表
                          	<br/><input type="radio" id="fqszdgzhcjlspzbflag" name="fquartzSwitchPo.fqszdgzhcjlspzbflag"  value="1" ${fquartzSwitchPo.fqszdgzhcjlspzbflag == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为天津眼科定制需求。)</font>	
						  </TD>
					   </TR>
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">医院端是否自动同步集团端商品成本</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"  id="fqssynchronizecost" name="fquartzSwitchPo.fqssynchronizecost"  value="0" ${fquartzSwitchPo.fqssynchronizecost == '0' ? 'checked':'' }>
                          		关闭
                          	<br/><input type="radio" id="fqssynchronizecost" name="fquartzSwitchPo.fqssynchronizecost"  value="1" ${fquartzSwitchPo.fqssynchronizecost == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为爱尔定制需求。)</font>	
						  </TD>
					   </TR>
					   <TR>
                          <TD height="26" width="20%" class="table_body " align="right">医院端是否是否上传会员信息</TD>
                          <TD width="80%" class="table_none ">
                            <input type="radio"      id="fqssynchronizecustomer" name="fquartzSwitchPo.fqssynchronizecustomer"  value="0" ${fquartzSwitchPo.fqssynchronizecustomer == '0' ? 'checked':'' }>
                          		关闭
                          	<br/><input type="radio" id="fqssynchronizecustomer" name="fquartzSwitchPo.fqssynchronizecustomer"  value="1" ${fquartzSwitchPo.fqssynchronizecustomer == '1' ? 'checked':'' }>
                            	开启
                            <br/><font color="red">(此定时任务为爱尔定制需求。)</font>	
						  </TD>
					   </TR>
					   </TBODY>
					 </table>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>

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
