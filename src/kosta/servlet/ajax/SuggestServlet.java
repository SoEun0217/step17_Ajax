package kosta.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/suggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String [] words = {
		"�ڹ����α׷���","�ڹٽ�ũ��Ʈ","�ڹپȳ�","Java�����ϱ�","Ajax�� �����ΰ�?",
		"ajax�� ����","�����ۿ���","�������Ͱ���","�� ������","jQuery�����ϱ�","Javascript",
		"jsp�����ϱ�","jsp ����մ�"
	};
	/**
	 * �μ��� ���޵� �ܾ�� �����ϴ� �ܾ���� ��Ƽ� �������ش�
	 * */
	
	public List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word:words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {//������ true ������ false,
				list.add(word);
			}
		}
		return list;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String keyWord = request.getParameter("keyWord");
		//System.out.println(keyWord);
		List<String>list =this.search(keyWord);
		//list�� text���·� ��ȯ�ؼ� Ŭ���̾�Ʈ������ ����
		//ex) ���� | �ܾ�, �ܾ�,�ܾ�,...
		String str = list.size()+"|";
		for(int i=0;i<list.size();i++) {
			if(list.size()==i+1) {
				str+=list.get(i);
			}else {
				str+=list.get(i)+",";
			}
		}
		PrintWriter out = response.getWriter();
		out.print(str);
	}
	

}
