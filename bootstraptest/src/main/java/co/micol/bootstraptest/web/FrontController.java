package co.micol.bootstraptest.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstraptest.command.Command;
import co.micol.bootstraptest.home.Home;
import co.micol.bootstraptest.notice.command.AjaxSearchList;
import co.micol.bootstraptest.notice.command.NoticeInput;
import co.micol.bootstraptest.notice.command.NoticeInputForm;
import co.micol.bootstraptest.notice.command.NoticeList;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 실행명령 두는 곳
		map.put("/home.do", new Home());	//처음들어오는 곳 처리
		map.put("/noticeInputForm.do", new NoticeInputForm());	//게시글 입력 폼
		map.put("/noticeInput.do", new NoticeInput());	//게시글 저장
		map.put("/noticeList.do", new NoticeList());	//게시글 목록
		map.put("/ajaxSearchList.do", new AjaxSearchList());	//게시글 검색
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청분석, 실행 및 결과를 리턴하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				//ajax 처리
				response.setContentType("text/html; charset=UTF-8");
				viewPage = viewPage.substring(5);	//왜...??
				response.getWriter().append(viewPage);
				return;
				
			} else {
				//viewPage = viewPage + ".tiles";
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
