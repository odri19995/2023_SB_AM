package com.KoreaIT.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.demo.repository.MemberRepository;
import com.KoreaIT.demo.vo.Member;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public void joinMember(String loginId, String loginPw, String name,String nickname, String cellphoneNum, String email) {
		memberRepository.joinMember(loginId, loginPw, name,nickname, cellphoneNum, email);
	}
	
	public int getLastInsertId() {
		return memberRepository.getLastInsertId();
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
}