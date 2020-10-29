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
		"자바프로그래밍","자바스크립트","자바안녕","Java시작하기","Ajax란 무엇인가?",
		"ajax를 하자","웹동작원리","웹마스터과정","웹 개발자","jQuery시작하기","Javascript",
		"jsp공부하기","jsp 재미잇다"
	};
	/**
	 * 인수로 전달된 단어로 시작하는 단어들을 모아서 리턴해준다
	 * */
	
	public List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word:words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {//있으면 true 없으면 false,
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
		//list를 text형태로 변환해서 클라이언트쪽으로 응답
		//ex) 개수 | 단어, 단어,단어,...
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
