package co.micol.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.study.comm.Command;
import co.micol.study.student.service.StudentService;
import co.micol.study.student.serviceImpl.StudentServiceImpl;
import co.micol.study.student.vo.StudentVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StudentService dao = new StudentServiceImpl();
		HttpSession session = request.getSession();	//세션객체 활용을 위헤 request가 가지고 있는 getSession()호출
		
		StudentVO vo = new StudentVO();
		vo.setStudentId(request.getParameter("studentId"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.studentSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getStudentId());	// 아이디담고
			session.setAttribute("name", vo.getName());	//사용자 이름 담고
			session.setAttribute("author", vo.getAuthor());	//사용자 권한 담고
			request.setAttribute("message", vo.getName() + "님 환영합니다.");
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		
		return "student/login";
	}

}
