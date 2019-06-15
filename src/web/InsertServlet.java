package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Service;
import service.ServiceImpl;

/**
 * 添加用户的Servlet
 * @author yeluo1942
 *
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String qq = req.getParameter("qq");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setAge(Integer.parseInt(age));
		user.setGender(gender);
		user.setQq(qq);
		user.setEmail(email);
		
		Service service = new ServiceImpl();
		if(service.insertUser(user)) {
			//添加记录成功，重定向到UserSevrlet
			resp.sendRedirect("http://localhost:8080/ShowUserInfo/UserServlet");
		}else {
			//添加失败，返回到UserList.jsp，并输出错误信息
			req.setAttribute("error", "添加失败");
			req.getRequestDispatcher("/userList.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
