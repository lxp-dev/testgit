<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	<c:choose>
		<c:when test="${flag eq '1'}">
			<c:choose>
				<c:when test="${modulePo.moduleHelpHtmlUrl ne ''}">
					location.href="help/${modulePo.moduleHelpHtmlUrl}";
				</c:when>
				<c:otherwise>
					alert("请功能尚未配置帮助文件路径！");
					winClose();
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${flag eq '2'}">
			<c:choose>
				<c:when test="${modulePo.moduleHelpMovieUrl ne ''}">
					location.href="${httpUrl}${modulePo.moduleHelpMovieUrl}";
				</c:when>
				<c:otherwise>
					alert("请功能尚未配置视频文件路径！");
					winClose();					
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			alert("操作失败，无法分辨提取帮助文件还是视频文件！");
			winClose();			
		</c:otherwise>				
	</c:choose>

	function winClose(){
		window.close();
	}
</script>