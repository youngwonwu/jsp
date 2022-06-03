package co.edu;
//위치 주소
//C:\Dev\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\WEB-INF\classes\jsp

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SampleServlet extends HttpServlet {	//HttpServlet 기능에 따라 처리한다
	//IOC
	
	@Override
	public void init() throws ServletException {	//최초 한번 호출
		System.out.println("init 호출...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {	//요청시 매번
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		System.out.println("service 호출...");
		
			//getMethod() get방식인지 post방식인지 호출
		if (req.getMethod().equals("GET")) {
			System.out.println("GET 요청입니다.");
			
		} else if (req.getMethod().equals("POST")) {
			System.out.println("POST 요청입니다.");
		}
		
		String name = req.getParameter("name");	//name=???&age=???
		String age = req.getParameter("age");
		System.out.println(req.getParameter("name"));
		PrintWriter out = resp.getWriter();	//출력
		out.print("<h3>요청파라미터 : " + name + "</h3>");
		out.print("<h3>요청파라미터 : " + age + "</h3>");
		out.close();
	}
	
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}
	
	@Override
	public void destroy() {		//서버가 stop이 되면 호출
		System.out.println("destroy 호출...");
	}

}
