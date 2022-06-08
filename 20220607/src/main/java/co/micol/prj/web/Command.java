package co.micol.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//Command 명령 수행
	public String exec(HttpServletRequest request, HttpServletResponse response);

}
