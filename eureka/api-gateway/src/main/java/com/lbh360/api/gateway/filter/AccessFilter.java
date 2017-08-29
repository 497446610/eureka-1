package com.lbh360.api.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.pt.core.utils.ObjectUtil;

public class AccessFilter extends ZuulFilter {

	private final static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		logger.info(" send {} request to {}", request.getMethod(), request.getRequestURL().toString());

		String token = request.getParameter("token");
		if (ObjectUtil.isNull(token)) {
			setFailedRequest(403, "403 Forbidden!");
		}

		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	private void setFailedRequest(int code, String msg) {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.setResponseStatusCode(code);
		if (ctx.getResponseBody() == null) {
			ctx.setResponseBody(msg);
			ctx.setSendZuulResponse(false);
			throw new RuntimeException("Code: " + code + ", " + msg); // optional
		}
	}

}
