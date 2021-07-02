package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeJoinService {
	@Autowired
	EmployeeRepository employeeRepository;  
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder; //비번 암호화를 위한 객체주입(from spring-context)
	
	public void empInsert(EmployeeCommand employeeCommand) {
		//controller에서 사용함.
		//사용하려면, context에 등록필요
		//<bean id="employeeJoinService" class="service.employee.EmployeeJoinService"/>
		//등록완료! , 등록했으니 controlle에서 사용할수있게 어노테이션 선언
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmail(employeeCommand.getEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPw(bcryptPasswordEncoder.encode(employeeCommand.getEmpPw()));
		dto.setEmpUserId(employeeCommand.getEmpUserid());
		dto.setHireDate(employeeCommand.getHireDate());
		dto.setJobId(employeeCommand.getJobId());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setPhNumber(employeeCommand.getPhNumber());
		employeeRepository.empInsert(dto);
	}
}
