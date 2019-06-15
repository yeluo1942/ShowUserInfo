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
 * ��¼У����������û������¼���󣬲��ܷ���������Դ������ֻ��ͣ�ڵ�¼ҳ��
 * @author yeluo1942
 *
 */
//@WebFilter("/*")		//������������
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//getURI��httprequest�ķ����������requestǿ��ת�ͳ���
		HttpServletRequest req = (HttpServletRequest)request;
		//��ȡURI����·���жϣ����е�¼��ص���Դ
		String uri = req.getRequestURI();
		//��¼��ص���Դ������¼ҳ�棬��¼����servlet����֤�룬css��ʽ�ȵȵ�¼�õ�����Դ��Ҫ����
		//�ж�session�������Ƿ����logined���ԣ����ڱ������û��Ƿ��¼��
		if(uri.contains("/Login.jsp") || uri.contains("/Login") || uri.contains("/IdentifyCode")
				|| uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")) {
			chain.doFilter(request, response);
		}else if(req.getSession().getAttribute("logined") != null){
			
			chain.doFilter(request, response);
		}else {
			
			//��û��¼����ת����¼ҳ��
			System.out.println("Filter:" + req.getSession().hashCode());
			request.setAttribute("error", "��δ��¼�����¼");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
