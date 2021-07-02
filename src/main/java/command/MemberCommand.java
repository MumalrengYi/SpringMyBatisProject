package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberCommand {
	
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberAddress;
	String memberName;
	String memberPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String memberGender;
	String memberAccount;
	String memberEmail;
	String memberEmailCk;
	String postNumber;
	String detailAdd;
	
	public String getMemberPwCon() {
		return memberPwCon;
	}
	public void setMemberPwCon(String memberPwCon) {
		this.memberPwCon = memberPwCon;
	}
	public String getDetailAdd() {
		return detailAdd;
	}
	public void setDetailAdd(String detailAdd) {
		this.detailAdd = detailAdd;
	}
	public boolean isMemPwEqualsMemPwCon() {
		return memberPw.equals(memberPwCon);
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberEmailCk() {
		return memberEmailCk;
	}
	public void setMemberEmailCk(String memberEmailCk) {
		this.memberEmailCk = memberEmailCk;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	
	
}
