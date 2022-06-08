package co.micol.study.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.study.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);	//Mapper Interface에서 전달인자가 하나일때는 그냥 쓰면 되는데 두개 이상일때는 @Param 추가 해야함
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(int id);	//조회수 증가 메소드

}
