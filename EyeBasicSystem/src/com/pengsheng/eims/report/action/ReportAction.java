package com.pengsheng.eims.report.action;

import com.fr.base.FRContext;
import com.fr.base.IconManager;
import com.fr.base.core.RegistEditionException;
import com.fr.base.core.json.JSONException;
import com.fr.base.core.json.JSONObject;
import com.fr.base.file.ConfigManager;
import com.fr.script.Calculator;
import com.fr.util.Consts;
import com.fr.web.Browser;

import com.fr.web.core.ErrorHandlerHelper;
import com.fr.web.core.ReportDispatcher;

import com.fr.web.core.WebUtils;
import com.fr.web.core.gzip.GZIPResponseWrapper;
import com.fr.web.core.service.EmbResourceService;
import java.io.PrintWriter;

import com.pengsheng.eims.util.basicaction.BaseAction;
import javax.servlet.http.HttpServletRequest;

public class ReportAction extends BaseAction {
	
	  private static final long serialVersionUID = 2204797189775876731L;
	  private static String reportName;

	public String execReport() throws Exception{
		if (Consts.WEB_APP_NAME == null)
	    {
	      Consts.WEB_APP_NAME = request.getContextPath();
	      if (Consts.WEB_APP_NAME.startsWith("/"))
	        Consts.WEB_APP_NAME = Consts.WEB_APP_NAME.substring(1);
	    }
	    saveRequestContext(request);
	    GZIPResponseWrapper localGZIPResponseWrapper = null;
	    try
	    {
	      String str = request.getHeader("accept-encoding");
	      if ((ConfigManager.getInstance().isSupportGzip()) && (!"false".equals(request.getParameter("gzip"))) && (str != null) && (str.indexOf("gzip") != -1) && (Browser.resolve(request).supportGzip()))
	        localGZIPResponseWrapper = new GZIPResponseWrapper(response);
	      if (localGZIPResponseWrapper != null)
	        response = localGZIPResponseWrapper;
	      response.addHeader("P3P", "CP=CAO PSA OUR");
	      ReportDispatcher.dealWithRequest(request, response);
	    }
	    catch (RegistEditionException localRegistEditionException)
	    {
	      if (localRegistEditionException.isAjax())
	      {
	        PrintWriter localPrintWriter = WebUtils.createPrintWriter(response);
	        JSONObject localJSONObject = new JSONObject();
	        try
	        {
	          localJSONObject.put("exception", "FAILPASS");
	          if (localRegistEditionException.getFUNC() != null)
	            localJSONObject.put("func", localRegistEditionException.getFUNC().toString());
	        }
	        catch (JSONException localJSONException)
	        {
	          localJSONException.printStackTrace();
	        }
	        localPrintWriter.write(localJSONObject.toString());
	        localPrintWriter.flush();
	        localPrintWriter.close();
	        //jsr 112;
	      }
	      FRContext.getLogger().errorWithServerLevel(localRegistEditionException.getMessage(), localRegistEditionException);
	      ErrorHandlerHelper.getErrorHandler().error(request, response, localRegistEditionException);
	    }
	    catch (Exception localException)
	    {
	      FRContext.getLogger().errorWithServerLevel(localException.getMessage(), localException);
	      ErrorHandlerHelper.getErrorHandler().error(request, response, localException);
	    }
	    catch (OutOfMemoryError localOutOfMemoryError)
	    {
	      FRContext.getLogger().errorWithServerLevel(localOutOfMemoryError.getMessage(), localOutOfMemoryError);
	      ErrorHandlerHelper.getErrorHandler().error(request, response, localOutOfMemoryError);
	      System.gc();
	    }
	    finally
	    {
	      if (localGZIPResponseWrapper != null)
	        localGZIPResponseWrapper.finishResponse();
	      Calculator.clearThreadSavedParameter();
	    }
		return null;
	}
	
	 public static void saveRequestContext(HttpServletRequest paramHttpServletRequest)
	  {
	    StringBuffer localStringBuffer = new StringBuffer();
	    localStringBuffer.append(paramHttpServletRequest.getScheme());
	    localStringBuffer.append("://");
	    localStringBuffer.append(paramHttpServletRequest.getServerName());
	    localStringBuffer.append(':');
	    localStringBuffer.append(paramHttpServletRequest.getServerPort());
	    Calculator.setThreadSavedParameter("servletURL", WebUtils.createServletURL(paramHttpServletRequest));
	    Calculator.setThreadSavedParameter("serverURL", localStringBuffer);
	    Calculator.setThreadSavedParameter("serverSchema", paramHttpServletRequest.getScheme());
	    Calculator.setThreadSavedParameter("serverName", paramHttpServletRequest.getServerName());
	    Calculator.setThreadSavedParameter("serverPort", Integer.toString(paramHttpServletRequest.getServerPort()));
	    Calculator.setThreadSavedParameter("contextPath", paramHttpServletRequest.getContextPath());
	    String str = WebUtils.getReportTitleFromRequest(paramHttpServletRequest);
	    reportName = str == null ? reportName : str;
	    Calculator.setThreadSavedParameter("reportName", reportName);
	  }

	  public long getLastModified(HttpServletRequest paramHttpServletRequest)
	  {
	    String str1 = WebUtils.getHTTPRequestParameter(paramHttpServletRequest, "resource");
	    if (str1 != null)
	      return EmbResourceService.getInstance().getLastModified(str1);
	    String str2 = WebUtils.getHTTPRequestParameter(paramHttpServletRequest, "op");
	    if ("toolbar_icon".equalsIgnoreCase(str2))
	      return IconManager.getLastModified();
	    return -1L;
	  }
}
