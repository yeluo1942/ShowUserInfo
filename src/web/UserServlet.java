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
 * web�㣬�����û����ݣ�������service�����ط���
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
		//��ѯuserinfo���е����м�¼
		req.setCharacterEncoding("utf-8");
		Service service = new ServiceImpl();
		List<User> list = service.queryAll();
		req.setAttribute("list", list);
		//ת����userLlist.jspչʾ
		req.getRequestDispatcher("/userList.jsp").forward(req, resp);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
