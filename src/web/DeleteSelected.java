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
 * 删除选中
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
		//获取uid参数数组
		String[] uids = req.getParameterValues("uid");
		
		if(uids != null && uids.length > 0) {
			Service service = new ServiceImpl();
			service.delSelected(uids);
		}else {
			//显示错误信息
			req.setAttribute("error", "请至少选择一条记录删除");
		}
		//删除完成，转发给UserServlet
		req.getRequestDispatcher("/UserServlet").forward(req, resp);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
