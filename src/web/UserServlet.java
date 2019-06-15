package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Service;
import service.ServiceImpl;

/**
 * web层，接收用户数据，并调用service层的相关方法
 * @author yeluo1942
 *
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询userinfo表中的所有记录
		req.setCharacterEncoding("utf-8");
		Service service = new ServiceImpl();
		List<User> list = service.queryAll();
		req.setAttribute("list", list);
		//转发给userLlist.jsp展示
		req.getRequestDispatcher("/userList.jsp").forward(req, resp);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
