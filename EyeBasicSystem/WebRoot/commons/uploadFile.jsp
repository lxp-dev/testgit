<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!----------------------文件上传--------------------------------->
<!--莫永生 2015-3-24 封装-->
<link href="${ctx}/swfupload/css/swfupload-default.css" rel="stylesheet"type="text/css" />
<script type="text/javascript" src="${ctx}/swfupload/js/swfupload.js"></script>
<script type="text/javascript" src="${ctx}/swfupload/js/handlers.js"></script>
<script language="javascript">
	var contextPath="${ctx}";
	function startLoad(uploadPath,uploadLimit,picID,picDivID,picWidth,picHeight,updateOrInsert,paramid){
		if($.trim(uploadPath)=="" ||$.trim(uploadLimit)=="" ||$.trim(picID)==""){
			alert("参数有误！");
		}else{
			var url=contextPath+"/fileUploadServlet?timeStamp=" + new Date().getTime() +"&uploadpath=" + uploadPath; //处理上传的servlet
			var sizeLimit="1 MB";// 文件的大小  注意: 中间要有空格
			var types="*.jpg;*.jpeg;*.gif;*.png"; //注意是 " ; " 分割 
			var typesdesc="web iamge file"; //这里可以自定义
			//var uploadLimit=20;  //上传文件的 个数
			//var updateOrInsert;	//上传之前是否清除原上传图片;'update:清除(为空时默认)；insert:不清除，累加;'
			initSwfupload(url,sizeLimit,types,typesdesc,uploadLimit,picID,picDivID,picWidth,picHeight,updateOrInsert,paramid);
		}
	}

	function deleteServerFile(obj,fileName,picID,paramid){
        if($.trim(fileName)=="")
        {
            alert("输入参数有误，无法删除文件!");
        }
        else
        {
        	var tmpfileName = fileName;
            if (typeof(paramid) != "undefined" && paramid != ""){
            	tmpfileName = fileName + "_" + paramid;
            }
            //alert(tmpfileName);
            $.ajax({
             type: "get",
             url: contextPath+"/fileUploadServlet",
             data: "timeStamp=" + new Date().getTime() +"&deleteFlag=true&fileName="+ fileName,	//提交表单，相当于***.action?ID=
             success: function(msg){//操作成功后的操作！msg是后台传过来的值
                if($.trim(msg)!=""){//不成功时，提示。
                	alert( msg );
                }
               }   
            }); 
            
            document.getElementById(picID).value=document.getElementById(picID).value.replace(tmpfileName+',','');
            $(obj).parent().remove();
        } 
    }
   
</script>
<!----------------------文件上传--------------------------------->