package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录校验过滤器，用户必须登录过后，才能访问其他资源，否则只能停在登录页面
 * @author yeluo1942
 *
 */
//@WebFilter("/*")		//拦截所有请求
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//getURI是httprequest的方法，必须把request强制转型成它
		HttpServletRequest req = (HttpServletRequest)request;
		//获取URI进行路径判断，放行登录相关的资源
		String uri = req.getRequestURI();
		//登录相关的资源包括登录页面，登录处理servlet，验证码，css样式等等登录用到的资源都要放行
		//判断session对象中是否存在logined属性，用于表征该用户是否登录过
		if(uri.contains("/Login.jsp") || uri.contains("/Login") || uri.contains("/IdentifyCode")
				|| uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")) {
			chain.doFilter(request, response);
		}else if(req.getSession().getAttribute("logined") != null){
			
			chain.doFilter(request, response);
		}else {
			
			//还没登录，跳转到登录页面
			System.out.println("Filter:" + req.getSession().hashCode());
			request.setAttribute("error", "还未登录，请登录");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
