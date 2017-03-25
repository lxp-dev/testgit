<s:if test="hasActionMessages()">    
	<s:iterator value="actionMessages">    
	    <script language="JavaScript">    
	    	alert("<s:property escape="false"/>");
	    </script>    
	</s:iterator>    
</s:if>  
<s:if test="hasActionErrors()">    
	<s:iterator value="actionErrors">    
		<script language="JavaScript">    
			alert("<s:property escape="false"/>");
		</script>
	</s:iterator>    
</s:if>