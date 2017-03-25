package com.pengsheng.eims.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	public static final String USER_SESSION_KEY = "person";

	public static final String GOING_TO_URL_KEY = "GOING_TO";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) actionContext
				.get(StrutsStatics.HTTP_RESPONSE);

		Map session = actionContext.getSession();
		if (session != null && session.get(USER_SESSION_KEY) != null) {
			return invocation.invoke();
		}

		setGoingToURL(session, invocation);

		return "logout";
	}

	private void setGoingToURL(Map session, ActionInvocation invocation) {
		String url = "";
		String namespace = invocation.getProxy().getNamespace();
		if (StringUtils.isNotBlank(namespace) && !namespace.equals("/")) {
			url = url + namespace;
		}
		String actionName = invocation.getProxy().getActionName();
		if (StringUtils.isNotBlank(actionName)) {
			url = url + "/" + actionName + ".action";
		}
		session.put(GOING_TO_URL_KEY, url);
	}

}
