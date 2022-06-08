package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 받아서 철리하는 곳
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();
    }

	/**
	 * 요청과 처리 명령를 연결하는 부분
	 */
	public void init(ServletConfig config) throws ServletException {
		//mapping	요청이 올때마다 구현
		//"/요청명", 모델명
		map.put("/test.do", new TestCommand());
		map.put("/memberList.do", new MemberListCommand());		//학생목록
	}

	/**
	 * 요기서 들어온 요청을 분석하고 명령을 실행해서 결과를 돌려보내누는 곳
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	//한글깨짐 방지
		String uri = request.getRequestURI();	//요청 URI 구함	어떤 요청이 왔는지 쪼갬
		String contextPath = request.getContextPath();	//루트 디렉토리 정보
		String page = uri.substring(contextPath.length());	//실제 요청 명령을 받음	실제 요청한 페이지
		
		//인터페이스 변수   = new 구현체();  무슨말인디 모르겟..?????????
		Command command = map.get(page);	//실행할 명령객체를 찾음
		String viewPage = command.exec(request, response);	//명령을 실행하고 결과를 돌려받음		돌려받을 거
		
		//viewResolve
		//어떤 jsp가 적절하지 만들어줌?????????
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {	//돌려받을 page에서 마지막 문자열에 .do가 보함 안된값
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		};
		
		//결과 페이지를 돌려준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	//돌려줄때
		dispatcher.forward(request, response);	//forward()보여줄 페이지 던짐
	}

}
