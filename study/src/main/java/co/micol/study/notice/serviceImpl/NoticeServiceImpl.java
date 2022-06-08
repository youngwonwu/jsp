package co.micol.study.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.study.comm.DataSource;
import co.micol.study.notice.service.NoticeMapper;
import co.micol.study.notice.service.NoticeService;
import co.micol.study.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	//DB연결
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);		//dao 연결	true를 하지않으면 자동(auto commit)으로 commit이 안됨
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);

	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		return map.noticeSearchList(key, val);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(int id) {
		return map.noticeHitUpdate(id);
	}

}
