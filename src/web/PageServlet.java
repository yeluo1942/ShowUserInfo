package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import service.Service;
import service.ServiceImpl;

/**
 * ∑÷“≥¥¶¿Ì
 * @author yeluo1942
 *
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String currentPage = req.getParameter("currentPage");
		String rows = req.getParameter("rows");
		
		Map<String, String[]> map = new HashMap<String, String[]>(req.getParameterMap());
		map.remove("currentPage");
		map.remove("rows");
		Service service = new ServiceImpl();

		PageBean pb = service.queryLimit(currentPage, rows, map);
		req.setAttribute("pageBean", pb);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/userList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
