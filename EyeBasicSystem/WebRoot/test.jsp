<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
     <title>fanrui page</title>
     <meta http-equiv="pragma" content="no-cache">
     <meta http-equiv="cache-control" content="no-cache">
     <meta http-equiv="expires" content="0">
     <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
     <meta http-equiv="description" content="This is my page">
   </head>
<%!
private static int pagecount=0;   //分页的数目
private static int pagesize=0;       //每页的大小
private static int currentstart=0;     //当前开始条目
private static int currentend=0; //当前结束条目
private static int totalcount=0;       //总的条目数
private static int intpage=1;         //当前页

private int allpageNum=0; //导航总数
private int onePieceCount=0;   //导航每篇显示数量
private int nowPageNum=1;   //导航的当前篇数
private int allPiaceNum=0;   //导航一共的篇数
private int nowFirst=0;    //一篇内，导航起始数
private int nowLast=0;       //一篇内，导航结束数

public static int getPagecount() {
   return pagecount;
}

public static int getTotalCount(){
   return totalcount;
}

public static int getIntPage(){
   return intpage;
}


public static int getCurrentend() {
   return currentend;
}

public static int getCurrentstart() {
   return currentstart;
}

public static int getPagesize() {
   return pagesize;
}

public static void setPagesize(int ps) {
   pagesize = ps;
}

public static void setTotalcount(int total) {
   totalcount = total;
}


public static void pageconfig(int intpage){
   intpage=intpage;
         int j=totalcount; 
    totalcount=j;
    j=j/pagesize;
   
    if((totalcount%pagesize)!=0){
       pagecount=j+1;   
    } 
    else{
       pagecount=j;  
    }
  
    int ipage =intpage;      // intpage 是要查看的那一页页码   
    if (ipage <= 0){
             ipage = 1;
         }      
    if (ipage >pagecount) {
             ipage =pagecount ;
         }
   
    currentstart=(ipage-1)*pagesize;    
    currentend=(ipage)*pagesize-1;
    if(currentend>=totalcount)
    {
      currentend= totalcount-1;    
    }
    if(currentend<0)
    {
      currentend= 0;    
    }
    if(currentstart<0)
    {
      currentstart=0;   
    }
}


%> 
   <body>
<%
   //伪造数据
   ArrayList countList=new ArrayList();
   for(int i=0;i<28;i++){
    countList.add(i,i+"*"+i);
   }
   //伪造数据
  
   //记录分页取出
   int   intPage=1;
   if(request.getParameter("intpage")!=null)intPage=Integer.parseInt(request.getParameter("intpage").toString());   //待显示页码
   this.setPagesize(4);   //设置没页要展示的数量
   this.setTotalcount(countList.size());   //设置记录总数
   this.pageconfig(intPage);       //分页操作，传入当前页 
   List vlist=null;     //中间临时对象
   String title[]=new String[this.getPagesize()];    //声明一个存放标题的数组
   int j=0;    
   for(int i=this.getCurrentstart();i<=this.getCurrentend();i++){
    title[j]=(String)countList.get(i); //vlist 里第二个是标题，取出来放到title数组里
    j++;
   }
   for(int i=j;i<this.getPagesize();i++){
    title[i]="*****";
   }
   //记录分页取出
  
   //导航分篇
   int allpageNum=this.getPagecount(); //导航总数
   int onePieceCount=3;   //导航每篇显示数量
   int nowPageNum=(intPage-1)/onePieceCount+1;   //导航的当前篇数
   int allPiaceNum=this.getPagecount()/onePieceCount;   //导航一共的篇数
   if(allpageNum%onePieceCount!=0)allPiaceNum++;
   int nowFirst=(nowPageNum-1)*onePieceCount+1;    //一篇内，导航起始数
   int nowLast=nowFirst+onePieceCount-1;       //一篇内，导航结束数
  
   if(nowFirst<=1)nowFirst=1;
   if(nowLast>=allpageNum)nowLast=allpageNum;
   //导航分篇
%> 
   共有记录:<%=this.getTotalCount()%>条<br>
   每页显示:<%=this.getPagesize()%>条<br>
   共有页数:<%=this.getPagecount()%><br>
   当前页:<%=intPage%><br>
   起始页:<%=this.getCurrentstart()%><br>
   结束页:<%=this.getCurrentend()%><br>
   导航共有:<%=allPiaceNum%>篇<br>
   导航属于第:<%=nowPageNum%>篇<br>
   导航起始数:<%=nowFirst%><br>
   导航结束数:<%=nowLast%><br>
   <!-- 分页导航 -->
   <table>
    <tr>
     <td>
     <%
      if(nowPageNum>1){
     %>
       <a href="page.jsp?intpage=<%=nowFirst-onePieceCount%>">&lt;&lt;</a>&nbsp;
     <% 
      }
      for(int i=nowFirst;i<=nowLast;i++){
     %>
       <a href="page.jsp?intpage=<%=i%>"><%=i%></a>&nbsp; 
     <%  
      }
     
      if(nowPageNum<allPiaceNum){
     %>
       <a href="page.jsp?intpage=<%=nowLast+1%>">&gt;&gt;</a>&nbsp; 
     <%
      }
     %>
     </td>
    </tr>
   </table>
   <!-- 分页导航 -->
   <!-- 展示区 -->
   <table width="80%">
    <tr>
     <td><%=title[0]%></td><td><%=title[1]%></td>
    </tr>
    <tr>
     <td><%=title[2]%></td><td><%=title[3]%></td>
    </tr>      
   </table>  
     <!-- 展示区 -->
   <!-- 分页导航 -->
   <table>
    <tr>
     <td>
     <%
      if(nowPageNum>1){
     %>
       <a href="page.jsp?intpage=<%=nowFirst-onePieceCount%>">&lt;&lt;</a>&nbsp;
     <% 
      }
      for(int i=nowFirst;i<=nowLast;i++){
     %>
       <a href="page.jsp?intpage=<%=i%>"><%=i%></a>&nbsp; 
     <%  
      }
     
      if(nowPageNum<allPiaceNum){
     %>
       <a href="page.jsp?intpage=<%=nowLast+1%>">&gt;&gt;</a>&nbsp; 
     <%
      }
     %>
     </td>
    </tr>
   </table>
   <!-- 分页导航 -->    
    
   </body>
</html>


