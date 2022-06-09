package co.micol.study.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.study.comm.Command;
import co.micol.study.home.command.HomeCommand;
import co.micol.study.notice.command.NoticeSelect;
import co.micol.study.notice.command.NoticeSelectList;
import co.micol.study.student.command.Login;
import co.micol.study.student.command.LoginForm;
import co.micol.study.student.command.Logout;



@WebServlet("*.do")		//.do로 들어오는 모든 요청은 다 처리하겠다	
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>();
       

    public FrontController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {		//init 초기화한다는 뜻
		//map.put(key, value)
		map.put("/home.do", new HomeCommand());	//홈 페이지		//Command의 자식 객체 HomeCommand
		map.put("/noticeSelectList.do", new NoticeSelectList());	//공지사항 목록
		map.put("/noticeSelect.do", new NoticeSelect());	//세부내역 보기
		map.put("/loginForm.do", new LoginForm());	//로그인 폼
		map.put("/login.do", new Login());	//로그인 처리
		map.put("/logout.do", new Logout());	//로그아웃 처리
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		//viewResolve: 보여줄 페이지를 선택한다
		if(!viewPage.endsWith(".do")) {
//			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			viewPage = viewPage + ".tiles"; 
					
		}
		
		//RequestDispatcher 권한이임하는데 내가 만든 dispatcher를 가지고 간다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
