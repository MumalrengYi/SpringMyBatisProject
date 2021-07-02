package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {

	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.memberMapper";
	String statement;
	
	public void memberInsert(MemberDTO dto) {
		statement = namespace+".memberInsert";
		int i = sqlSession.selectOne(statement);
		System.out.println(i+"개가 추가되었습니다 (memberInsert");
	}
}
