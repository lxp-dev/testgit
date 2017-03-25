<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>    
    function indexPage(){
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val(); 
    } 

    function zixun(){
    	$.post("getDuokefuTypeAjax.action",function(data) {
    		 data = eval(data);
    		 //alert(data.wcrkftype);
    		 //alert(data.wcrkfurl);
    		 if(data.wcrkftype == '1'){//使用微信多客服
    			WeixinJSBridge.call('closeWindow');
    		    $.post("getDuokefuAjax.action?openID="+$('#openID').val());
    		 }else if(data.wcrkftype == '2'){//使用第三方客服系统
    			 location.href=data.wcrkfurl;"";
    		 }
    	});
    } 

    function contactUs(){
    	location.href="initContactUsSel.action?openID="+$('#openID').val();  
    }    
    
    function newActivity(){
    	location.href="initNewActivitySel.action?openID="+$('#openID').val();  
    }          
</script>
	<c:if test="${sessionScope.personcenterisshow ne '1'}">
		<!-- 浮 -->
		<div class="Right_bk" style="display: none;">
			<div class="Right_b2">
				<a href="#top"> <img src="${ctx}/weixin_personcenter/images/ico_fh2.png" alt=""></a>
			</div>
			<div class="Right_b2">
				<a href="#top"> <img src="${ctx}/weixin_personcenter/images/u807.png" alt=""></a>
			</div>
		</div>
		<!-- 浮结束 -->
		<!-- 个人中心结束 -->
		<footer>
			<a class="xf_fz2" href="#" onclick="indexPage();">返回首页</a>
			<a class="xf_ftsy cur" href="#" onclick="zixun();">在线咨询 </a>
			<a class="xf_ftmy" href="#" onclick="contactUs();">联系我们</a>
			<a class="xf_ftcd" href="#" onclick="newActivity();">最新活动</a>
		</footer>
	</c:if>