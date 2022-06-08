package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
//@WebServlet("/First")	//어노테이션 매핑방법
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //요청방식이 get방식
    //?=
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실행시킬 code 작성
		PrintWriter out = response.getWriter();
		//out.print("Hello");
		out.print("<h1>Hello</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//요청방식이 post방식
	//Form 객체(태크)를 이용해서 함
	//post방식으로 실행해도 get에서 실행이 됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	//post방식으로 실행해도 get에서 실행이 됨
	}

}
