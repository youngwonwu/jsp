package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testServ")
public class TestServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		
		PrintWriter out = resp.getWriter();	//응답정보 출력스트림
		//[{"name":"홍길동","age":10}, {"name":"박민수","age":15}]
//		out.print("[{\"name\":\"홍길동\",\"age\":10}, {\"name\":\"박민수\",\"age\":15}]");		//json
		// <data><name>홍길동</name><age>10</age><name>박민수</name><age>15</age></data>
		out.print("<data><name>홍길동</name><age>10</age><name>박민수</name><age>15</age></data>");		//xml
	}

}
