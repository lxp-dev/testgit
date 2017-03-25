<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="${ctx}/img/favicon.ico" type="image/x-icon" />
<title>眼视光信息管理系统</title>
</head>
<FRAMESET id=total border=0 frameSpacing=0 rows=99,8,*,15 frameBorder=NO cols=*>
 <FRAME id=top name=top marginWidth=0 src="initTopFrame.action" frameBorder=NO scrolling=no>
 <FRAME id=hiddenTop name=hiddenTop marginWidth=0 src="hiddenTopFrame.html" frameBorder=NO scrolling=no>
  <FRAMESET id=btmframe border=0 name=btmframe frameSpacing=0 rows=* frameBorder=no cols=230,8,*>
   <FRAME name=leftframe src="leftTreeFrame_admin.jsp" frameBorder=no noResize scrolling=yes>
	</FRAME>
   <FRAME id=centerframe name=centerframe src="centerFrame.htm" frameBorder=no noResize scrolling=no>
   <FRAME id=mainFrame name=mainFrame src="initNoticeStore.action" frameBorder=NO><NOFRAMES>
				<body>
					<p>
						&nbsp;
					</p>
				</body>
			</NOFRAMES></FRAMESET>
 <FRAME name=bottom marginWidth=0 src="bottom.html" frameBorder=NO scrolling=no>
</FRAMESET>
<!-- window.parent.frames['hiddenTop'].document.getElementById('toptag').value -->
<body></body>
</html>
