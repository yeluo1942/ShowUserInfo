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
 * ����û���Servlet
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
			//��Ӽ�¼�ɹ����ض���UserSevrlet
			resp.sendRedirect("http://localhost:8080/ShowUserInfo/UserServlet");
		}else {
			//���ʧ�ܣ����ص�UserList.jsp�������������Ϣ
			req.setAttribute("error", "���ʧ��");
			req.getRequestDispatcher("/userList.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
