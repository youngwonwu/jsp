package co.micol.bootstraptest.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstraptest.command.Command;

public class NoticeInputForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 입력폼 호출
		return "notice/noticeInputForm";
	}

}
