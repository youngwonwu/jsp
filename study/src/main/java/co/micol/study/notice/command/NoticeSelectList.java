package co.micol.study.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.study.comm.Command;
import co.micol.study.notice.service.NoticeService;
import co.micol.study.notice.serviceImpl.NoticeServiceImpl;
import co.micol.study.notice.vo.NoticeVO;

public class NoticeSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//공지사랑 목록
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		return "notice/noticeSelectList";
	}

}
