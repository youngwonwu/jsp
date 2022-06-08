package co.micol.study.home.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.study.comm.Command;

public class HomeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//처음 접속하는 페이지
		return "home/home";
	}

}
