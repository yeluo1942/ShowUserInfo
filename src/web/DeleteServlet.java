package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import service.ServiceImpl;

/**
 * 删除
 * @author yeluo1942
 *
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Service service = new ServiceImpl();
		if(service.deleteById(id)) {
			//成功则重定向到UserServlet
			resp.sendRedirect("http://localhost:8080/ShowUserInfo/UserServlet");
		}else {
			//不成功则跳转到UserList.jsp
			req.getRequestDispatcher("/UserList.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
