package web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��֤��Servlet�࣬�������ڴ��л�����֤�룬����������������ʾ
 * @author yeluo1942
 *
 */
@WebServlet("/IdentifyCode")
public class IdentifyCode extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int width = 100;
		int height = 50;
		//1.���ڴ��л���ͼƬ
		BufferedImage bi = new BufferedImage(width, height ,BufferedImage.TYPE_INT_RGB);
		
		//2.��ͼƬ�л�����֤���Ѿ�ͼƬ��صĸ�Ԫ��
		//2.1  ��ȡ���ʣ���������ɫ�ͱ߿�
		Graphics g = bi.getGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.blue);
		g.drawRect(0, 0, width-1, height-1);
		//2.2 ������֤��
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random ran = new Random();
		
		//��ų������ɵ���֤��
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i ++) {
			int index = ran.nextInt(str.length());
			g.drawString(str.charAt(index) + "", (width/4)*i + 10, height/2);
			sb.append(str.charAt(index)	);
		}
		
		//�����ɵ���֤��洢��Session������
		req.getSession().setAttribute("iden", sb.toString());
		System.out.println("��֤�룺" + sb.toString());
		System.out.println("iden:" + req.getSession().hashCode());
		//2.3����������
		g.setColor(Color.GREEN);;
		for(int i = 0; i < 20; i ++) {
			int x1 = ran.nextInt(width);
			int x2 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int y2 = ran.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		//3 ��ͼƬ����������
		ImageIO.write(bi, "jpg", resp.getOutputStream());
	}
}
