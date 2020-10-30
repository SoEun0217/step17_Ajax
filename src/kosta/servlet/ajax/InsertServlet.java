package kosta.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import kosta.dao.CustomerDAO;
import kosta.dao.CustomerDAOImpl;
import kosta.dto.CustomerDTO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age= request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		CustomerDTO customer = new CustomerDTO(id, name, Integer.parseInt(age), tel, addr);
		CustomerDAO dao = new CustomerDAOImpl();
		int result = dao.insert(customer);
		PrintWriter out = response.getWriter();
		out.println(result);
	
	}

}
