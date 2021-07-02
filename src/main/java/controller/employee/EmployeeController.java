package controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import model.AuthInfoDTO;
import service.employee.EmployeeDeleteService;
import service.employee.EmployeeInfoService;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeListService;
import service.employee.EmployeeNumService;
import service.employee.EmployeeUpdateService;
import service.main.LoginService;
import validator.EmployeeCommandValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeNumService employeeNumServices;
	
	//EmployeeJoinService를 Context에 등록한 후 어노테이션 추가
	@Autowired
	EmployeeJoinService employeeJoinService;
	
	//직원리스트 컨트롤러
	@Autowired
	EmployeeListService employeeListService;
	
	@Autowired
	EmployeeInfoService employeeInfoService;
	
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	
	//controller를 만들면 이어서 service도 만들어야된다고!!!
	
	
	//직원정보삭제
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="empId")String empId) {
		employeeDeleteService.empDelete(empId);
		
		return "redirect:empList";
	}
	
	
	
	//직원정보수정(2) _empModifyOk
	@RequestMapping(value="empModifyOk", method=RequestMethod.POST)
	public String empModifyOk(EmployeeCommand employeeCommand) {
		employeeUpdateService.empUpdate(employeeCommand);
		//수정하고 empList로 돌아가기
		return "redirect:empList";
	}
	
	
	
	//직원정보수정페이지
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="empId")String empId, Model model) {
		employeeInfoService.empInfo(empId, model);
		return "employee/employeeModify";
	}
	
	
	
	//직원리스트페이지 -> 직원상세보기 페이지
	@RequestMapping("empInfo") 
	//밑에 파라미터값은 EmployeeInfoService로 전달.
	public String empInfo(@RequestParam(value="empId")String empId,Model model) {
		
		//파람으로 받아온 empId를 String empId로 넣고 Model로 보내줘서 저장
		employeeInfoService.empInfo(empId, model);
		
		return "employee/employeeInfo";
	}
	
	
	//직원리스트페이지 메서드
	@RequestMapping(value="empList", method= RequestMethod.GET)
	public String empList(Model model) {
		employeeListService.empList(model);
		return "employee/employeeList";
	}
	
	//직원등록페이지 컨트롤러
	@RequestMapping(value="empRegist", method=RequestMethod.GET)
	public String empRegist(Model model, EmployeeCommand employeeCommand) {
		
		employeeNumServices.empNo(model,employeeCommand);
//		model.addAttribute("employeeCommand",new EmployeeCommand());
		
		return "employee/employeeForm";
	}
	
	//직원등록페이지 컨트롤러! (버튼누르면 정보를 담아 넘어오는 페이지)
	@Autowired LoginService loginService;
	@RequestMapping(value="empJoin", method = RequestMethod.POST)
	public String empJoin(EmployeeCommand employeeCommand,Errors errors, Model model) {
		//command객체는 html 폼으로부터 받아온 값을 전달한다.
		//그러므로 @RequestParam은 사용 안해도 됨!
//		System.out.println("empJoin: "+employeeCommand.getEmpName());
		new EmployeeCommandValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/employeeForm";
		}
		AuthInfoDTO authInfo = loginService.logIn(employeeCommand.getEmpUserid(), employeeCommand.getEmpPw());
		if(authInfo!=null) {
			errors.rejectValue("empUserid", "duplicate");
			return "employee/employeeForm";
		}
		//@Autowired로 어노테이션 추가한다음 이 안에있는 empInsert()사용하겠다 선언
		employeeJoinService.empInsert(employeeCommand); //employeeCommand에서 값을 가져와야징!
		return "redirect:empList";
	}
	
	
}
