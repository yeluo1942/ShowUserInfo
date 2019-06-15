package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import service.Service;
import service.ServiceImpl;

/**
 * 用户登录验证
 * @author yeluo1942
 *
 */

@WebServlet("/Login")
public class Login extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取传递的参数
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pass = req.getParameter("pwd");
		String identify = req.getParameter("iden");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPwd(pass);
		//首先判断验证码是否正确
		String iden = (String) req.getSession().getAttribute("iden");
		//获取验证码后，立即清除该属性，保证验证码只能使用一次
		req.getSession().removeAttribute("identifyCode");
		System.out.println("Login:" + req.getSession().hashCode());
		if(iden != null && iden.equals(identify)) {
			//验证码正确，再进行用户名校验
			Service service = new ServiceImpl();
			if(service.judgeAdmin(admin)) {
				//验证成功，重定向到UserService，添加已经登录标识，是之后的请求可以通过过滤器
				System.out.println("验证正确");
				req.getSession().setAttribute("logined", "yes");
				String path = req.getContextPath();
				System.out.println("path:" + path);
				resp.sendRedirect("http://localhost:8080" + req.getContextPath() + "/PageServlet?currentPage=1&rows=5");	
			}else {
				//登录失败，跳转到登录界面
				req.setAttribute("error", "用户名或密码错误");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}
		}else {
			//验证码不正确，输出信息，并跳转到登录界面
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}













