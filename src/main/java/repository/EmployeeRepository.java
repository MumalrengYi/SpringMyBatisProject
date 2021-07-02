package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;

public class EmployeeRepository { //service가 사용 (service의 의존객체)
//empDAO와 같다.
	
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.employeeMapper";
	String statement;
	
	public void empDelete(String empId) {
		statement = namespace+".empDelete";
		int i = sqlSession.delete(statement,empId);
		System.out.println(i+" 개 삭제완료 (empDelete)");
		System.out.println(statement);
	}
	
	
	
	public void empUpdate(EmployeeDTO dto) {
		statement = namespace+".empUpdate";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+"update 완료 (empUpdate)");
		System.out.println(statement);
	}
	
	
	public EmployeeDTO empInfo(String empId) {

		statement = namespace+".empInfo";
		
		//내정보가져오기때문에 한개만 가져오는거임
		return sqlSession.selectOne(statement,empId);
	}
	
	
	public List<EmployeeDTO> empList(){
		statement = namespace+".empList";
		return sqlSession.selectList(statement);
	}
	
	public void empInsert(EmployeeDTO dto) {
		statement = namespace+".empInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개가 insert 되었습니다.");
		System.out.println("statement: "+statement);
		System.out.println();
	}
	public String empNo() {
		statement = namespace+".empNo";
		return sqlSession.selectOne(statement);
	}
	
	
}
