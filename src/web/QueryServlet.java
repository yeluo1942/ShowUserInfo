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
 * 根据id查询记录
 * @author yeluo1942
 *
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		Service service = new ServiceImpl();
		User user = service.queryUserById(id);
		//把user对象存入request域中，之后转发给update.jsp
		req.setAttribute("user", user);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
