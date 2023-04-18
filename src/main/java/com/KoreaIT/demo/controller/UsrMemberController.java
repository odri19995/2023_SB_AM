package com.KoreaIT.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.demo.service.MemberService;
import com.KoreaIT.demo.vo.Member;

@Controller
public class UsrMemberController {
	
	private MemberService memberService;
	
	@Autowired  //의존성 주입 객체를 따로 만들지 않는다. 
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 액션 메서드
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Member doJoin(String loginId, String loginPw, String name,String nickname, String cellphoneNum, String email ) {
		
		memberService.joinMember(loginId, loginPw, name, nickname, cellphoneNum, email);
		
		int id = memberService.getLastInsertId();
		
		return memberService.getMemberById(id);
	}
}