package com.lbh360.api.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.pt.core.utils.ObjectUtil;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AccessFilter extends ZuulFilter {

	private final static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	RedisTemplate redisTemplate;

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		logger.info(" send {} request to {}", request.getMethod(), request.getRequestURL().toString());

		String token = request.getParameter("token");

		if (ObjectUtil.isNull(token)) {

		} else {
			// 从redis服务器获取用户登录信息
			Object memberInfo = redisTemplate.opsForHash().get("session", token);
			if (memberInfo == null) {
				setFailedRequest(403, "403 Forbidden!");
			}
		}

		return null;
	}

	@Override
	public boolean shouldFilter() {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String reqUrl = request.getRequestURL().toString();
		if (ObjectUtil.isNull(reqUrl)) {// 不需要过滤
			return false;
		}

		if (reqUrl.indexOf("/dddd/") > 0) { // 需要验证的接口地址
			return true;
		}

		return false;

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

	@Autowired
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		RedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setHashValueSerializer(stringSerializer);
		this.redisTemplate = redisTemplate;
	}

}
