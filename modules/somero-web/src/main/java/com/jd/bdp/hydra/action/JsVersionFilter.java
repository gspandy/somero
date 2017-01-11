package com.jd.bdp.hydra.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class JsVersionFilter implements Filter {

	private Date date;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		date = new Date();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 针对上线更改js之后的版本，用于处理缓存，每次tomcat启动刷新一下版本
		// 调试阶段注释掉
		// ((HttpServletRequest)request).getSession().getServletContext().setAttribute("staticVersion", date);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// To change body of implemented methods use File | Settings | File Templates.
	}
}
