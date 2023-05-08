package com.KoreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.demo.service.ReactionPointService;
import com.KoreaIT.demo.vo.ReactionPoint;
import com.KoreaIT.demo.vo.ResultData;
import com.KoreaIT.demo.vo.Rq;

@Controller
public class UsrReactionPointController {

	private ReactionPointService reactionPointService;
	private Rq rq;

	@Autowired
	public UsrReactionPointController(ReactionPointService reactionPointService, Rq rq) {
		this.reactionPointService = reactionPointService;
		this.rq = rq;
	}

	@RequestMapping("/usr/reactionPoint/getReactionPoint")
	@ResponseBody
	public ResultData getReactionPoint(int relId, String relTypeCode) {

		ReactionPoint reactionPoint = reactionPointService.getReactionPoint(rq.getLoginedMemberId(), relId, relTypeCode);

		return ResultData.from("S-1", "리액션 정보 조회 성공", "reactionPoint", reactionPoint);
	}

}