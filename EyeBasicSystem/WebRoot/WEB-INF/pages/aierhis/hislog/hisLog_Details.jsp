<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HIS日志详情</title>
<%--<style type="text/css">
table{ table-layout: fixed;}
</style>
--%></head>
<body>
<DIV>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR>
			              <TD  height="40" colSpan="6" class="table_body" align="center" ><b>--LOG信息--</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD>
                      </TR>
                      <TR>
						  <TD height="35" width="6%" class="table_body " align="right">调用部门</TD>
			              <TD height="35" width="18%" class="table_none ">${hisLogPo.hislogdepatmentname}&nbsp;</TD>

						  <TD height="35" width="6%" class="table_body " align="right">调用人员</TD>
                          <TD height="35" width="32%" class="table_none ">${hisLogPo.hislogpersonname}&nbsp;</TD>
						  <TD height="35" width="6%" class="table_body " align="right">调用日期</TD>
			              <TD height="35" width="28%" class="table_none ">${hisLogPo.hislogdate}&nbsp;</TD>
			           </TR>
                      <TR>
						  <TD height="35" class="table_body " align="right">IP地址</TD>
                          <TD height="35" class="table_none " id="tableage">${hisLogPo.hislogip}&nbsp;</TD>

						  <TD height="35" class="table_body " align="right">接口名称</TD>
                          <TD height="35" class="table_none ">${hisLogPo.hisloginterfacename}&nbsp;</TD>                          
                          <TD height="35"  class="table_body" align="right">调用模块</TD>
                          <TD height="35"  class="table_none" >${hisLogPo.hislogmodulename}&nbsp;</TD>  
                     </TR> 
                       <TR> 
                          <TD height="35" class="table_body" align="right" >传入参数</TD>
                          <TD height="35" class="table_none" colspan="5">${hisLogPo.hisloginparam}&nbsp;</TD>
                      </TR>
                      <TR>
						  <TD height="35" width="8%" class="table_body" align="right">接口返回数据</TD>
			              <TD height="55" width="92%" class="table_none" colspan="5">${hisLogPo.hislogreturnparam}&nbsp;</TD>
                      </TR>
                      <TR>
						  <TD height="35" width="8%" class="table_body" align="right">相关单据</TD>
			              <TD height="55" width="92%" class="table_none" colspan="5">${billid}&nbsp;</TD>
                      </TR>
                      
                    </TABLE>
                  </DIV>
</body>
</html>