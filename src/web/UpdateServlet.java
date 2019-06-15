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
 * 修改
 * @author yeluo1942
 *
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String qq = req.getParameter("qq");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setAddress(address);
		user.setAge(Integer.parseInt(age));
		user.setGender(gender);
		user.setQq(qq);
		user.setEmail(email);
		
		Service service = new ServiceImpl();
		
		if(service.updateUser(user)) {
			
			//重定向到UserServlet
			resp.sendRedirect("http://localhost:8080/ShowUserInfo/UserServlet");
		}else {
			//把之前的user对象传递过去，使得update.jsp页面任然是未修改的状态
			req.setAttribute("user", user);
			//跳转到update.jsp，并提示错误信息
			req.setAttribute("error", "修改记录失败");
			req.getRequestDispatcher("/update.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
