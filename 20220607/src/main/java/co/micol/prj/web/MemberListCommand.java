package co.micol.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.serviceImpl.StudentServiceImpl;
import co.micol.prj.student.vo.StudentVO;

public class MemberListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
//		//DB처리하는 부분 작업하고
//		//보여줄 페이지에 값을 실고
//		request.setAttribute("name", "홍길동");
//		request.setAttribute("id", "micol");
//		request.setAttribute("password", "1234");
		
		StudentService dao = new StudentServiceImpl();
		List<StudentVO> students = new ArrayList<StudentVO>();
		students = dao.studentSelectList();
		request.setAttribute("students", students);		//실행내역 객체 담고
		return "member/member";
	}

}
