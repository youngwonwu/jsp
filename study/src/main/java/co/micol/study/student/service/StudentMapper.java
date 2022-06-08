package co.micol.study.student.service;

import java.util.List;

import co.micol.study.student.vo.StudentVO;

public interface StudentMapper {
	
	List<StudentVO> studentSelectList();	//전체리스트
	StudentVO studentSelect(StudentVO vo);	//한명조회
	int studentInsert(StudentVO vo);	//추가
	int studentUpdate(StudentVO vo);	//변경
	int studnetDelete(StudentVO vo);	//삭제

}
