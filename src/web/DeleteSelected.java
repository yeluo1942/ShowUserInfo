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
 * ɾ��ѡ��
 * @author yeluo1942
 *
 */
@WebServlet("/DeleteSelected")
public class DeleteSelected extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//��ȡuid��������
		String[] uids = req.getParameterValues("uid");
		
		if(uids != null && uids.length > 0) {
			Service service = new ServiceImpl();
			service.delSelected(uids);
		}else {
			//��ʾ������Ϣ
			req.setAttribute("error", "������ѡ��һ����¼ɾ��");
		}
		//ɾ����ɣ�ת����UserServlet
		req.getRequestDispatcher("/UserServlet").forward(req, resp);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
