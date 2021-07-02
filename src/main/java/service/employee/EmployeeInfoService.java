package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService {
//직원상세보기를 위한 페이지 서비스!
	
	@Autowired
	EmployeeRepository employeeRepository;
	public void empInfo(String empId, Model model) {
		//empID로 값 받아오고 JSP단으로 정보를 넘기기 위해서는 Model 통해서 보내줌
		//context에 등록
		
		EmployeeDTO dto = employeeRepository.empInfo(empId);
		model.addAttribute("emp", dto);
		
	}
}
