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
 * �û���¼��֤
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
		//��ȡ���ݵĲ���
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pass = req.getParameter("pwd");
		String identify = req.getParameter("iden");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPwd(pass);
		//�����ж���֤���Ƿ���ȷ
		String iden = (String) req.getSession().getAttribute("iden");
		//��ȡ��֤���������������ԣ���֤��֤��ֻ��ʹ��һ��
		req.getSession().removeAttribute("identifyCode");
		System.out.println("Login:" + req.getSession().hashCode());
		if(iden != null && iden.equals(identify)) {
			//��֤����ȷ���ٽ����û���У��
			Service service = new ServiceImpl();
			if(service.judgeAdmin(admin)) {
				//��֤�ɹ����ض���UserService������Ѿ���¼��ʶ����֮����������ͨ��������
				System.out.println("��֤��ȷ");
				req.getSession().setAttribute("logined", "yes");
				String path = req.getContextPath();
				System.out.println("path:" + path);
				resp.sendRedirect("http://localhost:8080" + req.getContextPath() + "/PageServlet?currentPage=1&rows=5");	
			}else {
				//��¼ʧ�ܣ���ת����¼����
				req.setAttribute("error", "�û������������");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}
		}else {
			//��֤�벻��ȷ�������Ϣ������ת����¼����
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}













