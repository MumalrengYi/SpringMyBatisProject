package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.MemberCommand;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberJoinService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public void memJoin(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemberAccount(memberCommand.getMemberAccount());
		dto.setMemberAddress(memberCommand.getMemberAddress());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberEmailCk(memberCommand.getMemberEmailCk());
		dto.setMemberGender(memberCommand.getMemberGender());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberPw(bCryptPasswordEncoder.encode(memberCommand.getMemberPw()));
		dto.setPostNumber(memberCommand.getPostNumber());
		memberRepository.memberInsert(dto);
	}
}