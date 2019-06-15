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
 * �޸�
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
			
			//�ض���UserServlet
			resp.sendRedirect("http://localhost:8080/ShowUserInfo/UserServlet");
		}else {
			//��֮ǰ��user���󴫵ݹ�ȥ��ʹ��update.jspҳ����Ȼ��δ�޸ĵ�״̬
			req.setAttribute("user", user);
			//��ת��update.jsp������ʾ������Ϣ
			req.setAttribute("error", "�޸ļ�¼ʧ��");
			req.getRequestDispatcher("/update.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
