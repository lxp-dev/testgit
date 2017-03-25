package com.pengsheng.eims.util.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.RequestUtils;

public class Pagination
{
    public class Link
    {

        public String getLink()
        {
            return link;
        }

        public void setLink(String link)
        {
            this.link = link;
        }

        public Integer getPageNo()
        {
            return pageNo;
        }

        public void setPageNo(Integer pageNo)
        {
            this.pageNo = pageNo;
        }

        private Integer pageNo;
        private String link;

        public Link(Integer pageNo, String link)
        {
            this.pageNo = pageNo;
            this.link = link;
        }
    }

    private class Page
    {

        public String getPagination()
        {
            return pagination;
        }

        public void setPagination(String pagination)
        {
            this.pagination = pagination;
        }

        public int getPageNo()
        {
            return pageNo;
        }

        public void setPageNo(int pageNo)
        {
            this.pageNo = pageNo;
        }

        public int getTotal()
        {
            return total;
        }

        public void setTotal(int total)
        {
            this.total = total;
        }

        public int getTotalPage()
        {
            return totalPage;
        }

        public void setTotalPage(int totalPage)
        {
            this.totalPage = totalPage;
        }

        public String getNextLink()
        {
            return nextLink;
        }

        public void setNextLink(String nextLink)
        {
            this.nextLink = nextLink;
        }

        public String getPreviousLink()
        {
            return previousLink;
        }

        public void setPreviousLink(String previousLink)
        {
            this.previousLink = previousLink;
        }

        public boolean isNextPage()
        {
            return nextPage;
        }

        public void setNextPage(boolean nextPage)
        {
            this.nextPage = nextPage;
        }

        public boolean isPreviousPage()
        {
            return previousPage;
        }

        public void setPreviousPage(boolean previousPage)
        {
            this.previousPage = previousPage;
        }

        public int getPageSize()
        {
            return pageSize;
        }

        public void setPageSize(int pageSize)
        {
            this.pageSize = pageSize;
        }

        public List getLinks()
        {
            return links;
        }

        public void addLink(Link link)
        {
            links.add(link);
        }

        public int getStart()
        {
            return start;
        }

        public void setStart(int start)
        {
            this.start = start;
        }

        public int getEnd()
        {
            return end;
        }

        public void setEnd(int end)
        {
            this.end = end;
        }
        
//		add by Matrix_guan
        public int getPerPageNo()
        {
        	return perPageNo;
        }
        
        public void setPerPageNo(int perPageNo)
        {
        	this.perPageNo = perPageNo;        	
        }
//      end by Matrix_guan
        private int pageNo;
        private int pageSize;
        private int start;
        private int end;
        private int total;
        private int totalPage;
        private boolean nextPage;
        private boolean previousPage;
        private String nextLink;
        private String nowLink;
        public String getNowLink() {
			return nowLink;
		}

		public void setNowLink(String nowLink) {
			this.nowLink = nowLink;
		}
		private String previousLink;
        private String startLink;
        private String endLink;
        private List links;
        private String pagination;
//		add by Matrix_guan        
        private int perPageNo;
//      end by Matrix_guan
        
        private Page()
        {
            pageNo = 1;
            links = new ArrayList();
        }

        Page(Page page1)
        {
            this();
        }

		public String getEndLink() {
			return endLink;
		}

		public void setEndLink(String endLink) {
			this.endLink = endLink;
		}

		public String getStartLink() {
			return startLink;
		}

		public void setStartLink(String startLink) {
			this.startLink = startLink;
		}

    }


    public Pagination(HttpServletRequest request, int total)
    {
        this(request, total, "", 10);
    }

    public Pagination(HttpServletRequest request, int total, int pageSize)
    {
        this(request, total, "", pageSize);
    }

    public Pagination(HttpServletRequest request, int total, String pageIndex)
    {
        this(request, total, pageIndex, 10);
    }

    protected Pagination(HttpServletRequest request, int total, String pageIndex, int pageSize)
    {
        page = new Page(null);
        String pageNoName;
        if(StringUtils.isBlank(pageIndex))
        {
            pageNoName = "pageNo";
            page.setPagination("pagination");
        } else
        {
            pageNoName = "pageNo" + pageIndex;
            page.setPagination("pagination" + pageIndex);
        }
        page.setPageSize(pageSize);
        page.setTotal(total);
        page.setTotalPage(page.getTotal() / pageSize);
        if(page.getTotal() % pageSize != 0)
            page.setTotalPage(page.getTotalPage() + 1);
        page.setPageNo(RequestUtils.getIntParameter(request, pageNoName, 1));
        page.setPageNo(Math.min(page.getTotalPage(), page.getPageNo()));
        page.setPageNo(Math.max(1, page.getPageNo()));
        if(page.getPageNo() < page.getTotalPage())
            page.setNextPage(true);
        else
            page.setNextPage(false);
        if(page.getPageNo() > 1)
            page.setPreviousPage(true);
        else
            page.setPreviousPage(false);
        page.setStart((page.getPageNo() - 1) * pageSize);
        if(page.getPageNo() == page.getTotalPage())
            page.setEnd(page.getTotal());
        else
            page.setEnd(page.getStart() + pageSize);
        Enumeration enumeration = request.getParameterNames();
        String value = null;
        StringBuffer queryString = new StringBuffer();
        while(enumeration.hasMoreElements()) 
        {
            String name = (String)enumeration.nextElement();
            try
            {
                value = URLEncoder.encode(request.getParameter(name), "UTF-8");
            }
            catch(UnsupportedEncodingException e)
            {
                e.printStackTrace();
                value = request.getParameter(name);
            }
            if(StringUtils.isNotBlank(name) && StringUtils.isNotEmpty(value) && !StringUtils.equals(pageNoName, name) && !StringUtils.equals("errorCode", name)&&!StringUtils.equals("perPage", name))
            {
                if(queryString.length() == 0)
                    queryString.append("?");
                else
                    queryString.append("&");
                queryString.append(name);
                queryString.append("=");
                if(name.equals("perPageNo"))
                	queryString.append(pageSize);
                else
                	queryString.append(value);
            }
            
//            if((StringUtils.isNotBlank(name) && StringUtils.isNotEmpty(value) && !StringUtils.equals("errorCode", name)) && (StringUtils.equals("pageNo", name) || StringUtils.equals("perPageNo", name) || StringUtils.equals("moduleID", name)))
//            {
//                if(queryString.length() == 0)
//                    queryString.append("?");
//                else
//                    queryString.append("&");
//                queryString.append(name);
//                queryString.append("=");
//                if(name.equals("perPageNo"))
//                	queryString.append(pageSize);
//                else
//                	queryString.append(value);
//            }
        }
        if(queryString.length() == 0)
            queryString.append("?");
        else
            queryString.append("&");
        queryString.append(pageNoName);
        queryString.append("=");
        String path = StringUtils.defaultString(request.getRequestURI());
        String link = path + queryString.toString();
        
      
        if(page.isPreviousPage())
//            page.setPreviousLink(link + (page.getPageNo() - 1)+ "&perPageNo="+pageSize);
        	page.setPreviousLink(link + (page.getPageNo() - 1));
        if(page.isNextPage())
//            page.setNextLink(link + (page.getPageNo() + 1)+ "&perPageNo="+pageSize);
        	page.setNextLink(link + (page.getPageNo() + 1));
        
//        page.setStartLink(link+1+ "&perPageNo="+pageSize);
//        page.setEndLink(link+page.getTotalPage()+ "&perPageNo="+pageSize);
        
        page.setStartLink(link+1);
        page.setEndLink(link+page.getTotalPage());
        page.setNowLink(link);
        
        /*for(int i = 1; i <= page.getTotalPage(); i++)
            if(i == 2 && page.getPageNo() - 5 - 1 > 1)
            {
                page.addLink(null);
                i = page.getPageNo() - 5 - 1;
            } else
            if(i == page.getPageNo() + 5 + 1 && page.getPageNo() + 5 + 1 < page.getTotalPage())
            {
                page.addLink(null);
                i = page.getTotalPage() - 1;
            } else
            {
                page.addLink(new Link(new Integer(i), link + i));
            }*/

    }

    public String getPagination()
    {
        return page.getPagination();
    }

    public int getPageNo()
    {
        return page.getPageNo();
    }

    public int getTotal()
    {
        return page.getTotal();
    }

    public int getTotalPage()
    {
        return page.getTotalPage();
    }

    public String getNextLink()
    {
        return page.getNextLink();
    }

    public String getPreviousLink()
    {
        return page.getPreviousLink();
    }
    public String getStartLink(){
    	return page.getStartLink();
    }
    public String getNowLink(){
    	return page.getNowLink();
    }
    public String getEndLink(){
    	return page.getEndLink();
    }
    
    public boolean isNextPage()
    {
        return page.isNextPage();
    }

    public boolean isPreviousPage()
    {
        return page.isPreviousPage();
    }

    public int getPageSize()
    {
        return page.getPageSize();
    }

    public List getLinks()
    {
        return page.getLinks();
    }

    public int getStart()
    {
        return page.getStart();
    }

    public int getEnd()
    {
        return page.getEnd();
    }

    private static final int PAGE_RANGE = 5;
    private static final String PAGE_NO = "pageNo";
    public static final String PAGINATION = "pagination";
    public static final String PERPAGE = "perPage"; 
    private static final String CONTEXT_ROOT = "";
    private static final int PAGE_SIZE = 10;
    private Page page;
}
