package kosta.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.CustomerDAO;
import kosta.dao.CustomerDAOImpl;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		CustomerDAO dao = new CustomerDAOImpl();
		PrintWriter out = response.getWriter();
		if(dao.idCheck(id)) {
			out.println("���̵� �ߺ��Դϴ�.");
		}else {
			out.println("��밡���մϴ�");
		}
	}

}
