package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberCommand;

public class MemberCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return false;
	}

	public void validate(Object target, Errors errors) {
		MemberCommand memberCommand = (MemberCommand)target;
		if(!memberCommand.isMemPwEqualsMemPwCon()) {
			errors.rejectValue("memPwCon", "noMatch");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memId", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberPwCon", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberName", "required");
		ValidationUtils.rejectIfEmpty(errors, "postNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberAddress", "required");
		ValidationUtils.rejectIfEmpty(errors, "detailAdd", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberPhone", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberBirth", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberGender", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberAccount", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "memberEmailCk", "required");
		
		
	}

}