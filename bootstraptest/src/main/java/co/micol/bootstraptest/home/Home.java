package co.micol.bootstraptest.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstraptest.command.Command;

public class Home implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//홈 페이지에 보여준다
		//홈 페이지에 가져올것 들고오면 됨?
		
		return "home/home";
	}

}
