package com.KoreaIT.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.demo.service.MemberService;
import com.KoreaIT.demo.util.Util;
import com.KoreaIT.demo.vo.Member;
import com.KoreaIT.demo.vo.ResultData;

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
		public ResultData<Member> doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {

			if (Util.empty(loginId)) {
				return ResultData.from("F-1", "아이디를 입력해주세요");
			}
			if (Util.empty(loginPw)) {
				return ResultData.from("F-2", "비밀번호를 입력해주세요");
			}
			if (Util.empty(name)) {
				return ResultData.from("F-3", "이름을 입력해주세요");
			}
			if (Util.empty(nickname)) {
				return ResultData.from("F-4", "닉네임을 입력해주세요");
			}
			if (Util.empty(cellphoneNum)) {
				return ResultData.from("F-5", "전화번호를 입력해주세요");
			}
			if (Util.empty(email)) {
				return ResultData.from("F-6", "이메일을 입력해주세요");
			}
			
			ResultData<Integer> doJoinRd = memberService.joinMember(loginId, loginPw, name, nickname, cellphoneNum, email);
			
			if (doJoinRd.Fail()) {
				return ResultData.from(doJoinRd.getResultCode(), doJoinRd.getMsg());
			}	
			
			return ResultData.from(doJoinRd.getResultCode(), doJoinRd.getMsg(), memberService.getMemberById((int)doJoinRd.getData1()) );
		}
		
	}