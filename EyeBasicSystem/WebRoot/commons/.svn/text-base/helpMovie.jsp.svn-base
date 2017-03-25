<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	/**
	*flag	1:help;2:movie;
	*/
	function getHelp(){
		window.open("getSystemModuleHelp.action?moduleID=${requestScope.moduleID}&flag=1",'help','height=500,width=700,top=100,left=100,scrollbars=yes');
	}

	/**
	*flag	1:help;2:movie;
	*/
	function getMovie(thewidth,theheight){
		var url="getSystemModuleHelp.action?moduleID=${requestScope.moduleID}&flag=2&httpUrl=${systemParameterPo.fspipurl}";
		if ( thewidth>500){
			window.open (url, "newwindow","width="+thewidth+","+"height="+theheight+",,toolbar=no,menubar=no, scrollbars=yes, resizable=yes,top=50,left=150, location=no, status=no,directories=no");
		}else{
			window.open (url, "newwindow","width="+thewidth+","+"height="+theheight+",,toolbar=no,menubar=no, scrollbars=no, resizable=yes,top=50,left=150, location=no, status=no,directories=no");
		}
	}
</script>
<a href="#" ><img style="vertical-align:middle" border='0' onclick="getHelp()" src='${ctx}/img/frame/helpUrl.png' width="16" title="帮助文档" /></a>
<a href="#" ><img style="vertical-align:middle" border='0' onclick="getMovie(418,420)" src='${ctx}/img/frame/helpMovie.png' width="16" title="帮助视频" /></a>