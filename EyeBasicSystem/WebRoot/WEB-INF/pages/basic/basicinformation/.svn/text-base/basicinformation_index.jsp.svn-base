<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>眼视光学信息管理系统</title>
</head>
<script>
	$(document).ready(function(){
		var frm = window.parent.frames;
		
		for (var i=0; i < frm.length; i++){
			if(frm[i].name=='centerframe'){
				frm[i].toLeft();
			}			
		}	
	});
</script>
  <FRAMESET id=btmframeTmp border=0 name=btmframeTmp frameSpacing=0 rows=* frameBorder=no cols=300,*>
   <FRAME name=leftframe src="initBasicinformationLeft.action?moduleID=${requestScope.moduleID}" frameBorder=1 noResize scrolling=yes>
	</FRAME>

   <FRAME name=mainFrame7 src="initBasicinformationRight.action" frameBorder=NO><NOFRAMES>
				<body>
					<p>&nbsp;
						
					</p>
				</body>
			</NOFRAMES></FRAME></FRAMESET>

<!-- window.parent.frames['hiddenTop'].document.getElementById('toptag').value -->
<body></body>
</html>