package co.micol.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//요청이 test.do로 들어왔을때 처리하는 곳
		return "test1";		//보여줄 페이지를 리턴
	}

}
