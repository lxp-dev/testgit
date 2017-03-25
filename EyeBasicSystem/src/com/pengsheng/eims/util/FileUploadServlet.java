package com.pengsheng.eims.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pengsheng.eims.util.tools.Utility;

public class FileUploadServlet extends HttpServlet {

	private static final int UPLOAD_SUCCSSS=0;    // "上传文件成功！", 
	private static final int UPLOAD_FAILURE=1;    // "上传文件失败！"), 
	private static final int UPLOAD_TYPE_ERROR=2; // "上传文件类型错误！"), 
	private static final int UPLOAD_OVERSIZE=3;   // "上传文件过大！"),
	private static final int UPLOAD_ZEROSIZE=4;   // "上传文件为空！"),
	private static final int UPLOAD_NOTFOUND=5;   // "上传文件路径错误！")

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		 String deleteFlag = Utility.getName(request.getParameter("deleteFlag"));
		 String rootPath = request.getParameter("rootPath");  
		 String uploadpath = request.getParameter("uploadpath");
		 String param = request.getParameter("param");

		 if(rootPath == null) rootPath = "";  
		    rootPath = rootPath.trim();  
		 if(rootPath.equals("")){  
			 rootPath = this.getServletContext().getRealPath("");  
		 } 
		 
		 if(deleteFlag.equals("true")){
			 String fileName = Utility.getName(request.getParameter("fileName"));
			 fileName = rootPath+fileName;

			 if(fileName.equals("")){
				 out.print("删除失败，请检查参数！");
			 }else{
				 if(deleteFile(fileName)){
					 //out.print("删除成功！");
				 }else{
					 out.print("删除失败！");
				 }
			 }
		 }else{	
			 //上传操作  
			  FileItemFactory factory = new DiskFileItemFactory();  
			  ServletFileUpload upload = new ServletFileUpload(factory);  
			  upload.setHeaderEncoding("UTF-8");  
			  try{  
			      List items = upload.parseRequest(request);  
			      if(null != items){  
			          Iterator itr = items.iterator();
			          String generateFileName = "";
			          while(itr.hasNext()){  
			              FileItem item = (FileItem)itr.next();
			              if(item.isFormField()){  
			                 continue;  
			              }else{  
			            	  generateFileName = generateFileName(item.getName());
			                   //以当前精确到秒的日期为上传的文件的文件名  
			                  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddkkmmss"); 

			                  File savedFile = new File(rootPath+uploadpath,generateFileName);  
			                  item.write(savedFile); 
			                  
			                  out.print("{status:"+this.UPLOAD_SUCCSSS+",message:'"+uploadpath+"/"+generateFileName+"'}");
			              }  
			          }  
			      }  
			  }catch(Exception e){  
			      e.printStackTrace();  
			  }
		 }
	}

	 /** 
     * new文件名= 时间 + 全球唯一编号 
     * @param fileName old文件名 
     * @return new文件名 
     */  
    private String generateFileName(String fileName) {  
        String uuid=UUID.randomUUID().toString();
        int position = fileName.lastIndexOf(".");     
        String extension = fileName.substring(position);     
        return uuid + extension;     
    }  
    
    /** 
     * 删除单个文件 
     * @param   sPath    被删除文件的文件名 
     * @return 单个文件删除成功返回true，否则返回false 
     */  
    public boolean deleteFile(String sPath) {  
        Boolean flag = false;  
        File file = new File(sPath);  
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) {  
            file.delete();  
            flag = true;  
        }  
        return flag;  
    }  
}
