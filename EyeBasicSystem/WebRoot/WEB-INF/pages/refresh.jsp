<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/WEB-INF/inc/message.jsp" %>
<script language="javascript">
<c:choose>
	<c:when test="${requestScope.flag=='insert'}">
      window.location=${requestScope.url};
	</c:when>
	<c:when test="${requestScope.flag=='update'}">
     window.location=${requestScope.url};
	</c:when>
	<c:when test="${requestScope.flag=='delete'}">	
	  parent.window.location=${requestScope.url};
      JavaScript:parent.hidePopWin();
	</c:when>
	<c:when test="${requestScope.flag=='delete2'}">	
	  window.location=${requestScope.url};
	</c:when>
	<c:when test="${requestScope.flag=='move'}">
     window.location=${requestScope.url};
	</c:when>
	<c:when test="${requestScope.flag=='openUpdate'}">
	$("form:first",parent.window.document).submit();
     JavaScript:parent.hidePopWin();
	</c:when>	
	<c:when test="${requestScope.flag=='openUpdate2'}">
     JavaScript:parent.hidePopWin();
	</c:when>
	
	<c:when test="${requestScope.flag=='openUpdate3'}">	
	  parent.window.location=${requestScope.url};
      JavaScript:parent.hidePopWin();
	</c:when>
	
	<c:when test="${requestScope.flag=='openUpdate4'}">	
	  parent.parent.window.location=${requestScope.url};
      JavaScript:parent.hidePopWin();
	</c:when>
	
	<c:when test="${requestScope.flag=='openUpdate5'}">
     JavaScript: parent.hidePopWin();parent.toRound();parent.showSaleserName('${saleser}');
  	
	</c:when>

	<c:when test="${requestScope.flag=='openUpdate6'}">
    $("form:first",window.parent.parent[0].document).submit();
    $("form:first",window.parent.frames["bottom"].document).submit();
    window.location=${requestScope.url};   
	</c:when>
	

	<c:when test="${requestScope.flag=='openUpdate7'}">	
	  parent.window.parent.leftframe1.test();
	  $("form:first",parent.window.document).submit();
    JavaScript:parent.hidePopWin();
	</c:when>	
	
	<c:when test="${requestScope.flag=='openUpdate8'}">	
	parent.parent.frames[0].updateTree("${requestScope.parentID}");	
	$("form:first",parent.window.document).submit();
     JavaScript:parent.hidePopWin();
	</c:when>	

	<c:when test="${requestScope.flag=='openUpdate9'}">	
	  parent.window.parent.leftframe1.testParent();
	  $("form:first",parent.window.document).submit();
    JavaScript:parent.hidePopWin();
	</c:when>	

	<c:when test="${requestScope.flag=='refresh'}">	
		parent.location.href = parent.location.reload(); 
    	JavaScript:parent.hidePopWin();
	</c:when>	

	<c:when test="${requestScope.flag=='reload'}">
		$("form:first",window.document).submit();	
	</c:when>
	
	<c:when test="${requestScope.flag=='openUpdate10'}">
	     parent.$('#mailMsg').show();
         JavaScript:parent.hidePopWin();
	</c:when>

	
	<c:when test="${requestScope.flag=='openUpdate11'}">
    $("form:first",parent.window.document).submit();
    parent.hidePopWin();   
    $("form:first",window.parent.parent[0].document).submit();    
	</c:when>

	<c:when test="${requestScope.flag=='openUpdate12'}">
	  <c:if test="${systemParameterPo.fspshowcustomertable == '1'}">
	  	parent.setReportEvent_HYK('${memberid}');
	  </c:if>
	 $("form:first",parent.window.document).submit();
     JavaScript:parent.hidePopWin();
	</c:when>

	<c:when test="${requestScope.flag=='openUpdate13'}">
	$("form:first",parent.window.document).submit();
    JavaScript:parent.hidePopWin(); 
    $("form:first",window.parent.parent.parent[0].document).submit();
    $("form:first",window.parent.parent.frames["bottom"].document).submit(); 

	</c:when>	
	
</c:choose>
</script>