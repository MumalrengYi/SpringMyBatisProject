package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.EmployeeCommand;

public class EmployeeCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	
	//EmployeeCommand를 받아 유효성을 검사합니다.
	@Override
	public void validate(Object target, Errors errors) {
		EmployeeCommand employeeCommand = (EmployeeCommand)target;
		
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			errors.rejectValue("userPwCon", "nomatch");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "required");
		ValidationUtils.rejectIfEmpty(errors, "empUserid", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPwCon", "required");
		ValidationUtils.rejectIfEmpty(errors, "empName", "required");
		ValidationUtils.rejectIfEmpty(errors, "hireDate", "required");
		ValidationUtils.rejectIfEmpty(errors, "jobId", "required");
		ValidationUtils.rejectIfEmpty(errors, "phNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "officeNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "email", "required");
		ValidationUtils.rejectIfEmpty(errors, "empAddress", "required");
		
	}
	//employeeCommand에 대한 유효성검사를 위한 클래스

}
