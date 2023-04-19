package com.KoreaIT.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.demo.repository.MemberRepository;
import com.KoreaIT.demo.util.Util;
import com.KoreaIT.demo.vo.Member;
import com.KoreaIT.demo.vo.ResultData;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public ResultData joinMember(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {

		Member existsMember = getMemberByLoginId(loginId);
		Member existsNickname = getMemberByNickname(nickname);
		
		if (existsMember != null) {
			return ResultData.from("F-7", Util.f("이미 사용중인 아이디(%s)입니다", loginId));
		}
		if (existsNickname != null) {
			return ResultData.from("F-8", Util.f("이미 사용중인 닉네임(%s)입니다", nickname));
		}
		
		existsMember = getMemberByNameAndEmail(name, email);
		
		if (existsMember != null) {
			return ResultData.from("F-9", Util.f("이미 사용중인 이름(%s)과 이메일(%s)입니다", name, email));
		}
		
		memberRepository.joinMember(loginId, loginPw, name, nickname, cellphoneNum, email);
		
		return ResultData.from("S-1","회원가입이 완료 되었습니다.",memberRepository.getLastInsertId());
	}
	
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}
	
	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}
	private Member getMemberByNickname(String nickname) {
		return memberRepository.getMemberByNickname(nickname);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
}