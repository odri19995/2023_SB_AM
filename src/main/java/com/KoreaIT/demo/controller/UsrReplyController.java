package com.KoreaIT.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KoreaIT.demo.service.ReplyService;
import com.KoreaIT.demo.util.Util;
import com.KoreaIT.demo.vo.ResultData;
import com.KoreaIT.demo.vo.Rq;

@Controller
public class UsrReplyController {

	private ReplyService replyService;
	private Rq rq;

	@Autowired
	public UsrReplyController(ReplyService replyService, Rq rq) {
		this.replyService = replyService;
		this.rq = rq;
	}

	@RequestMapping("/usr/reply/doWrite")
	@ResponseBody
	public String doWrite(String relTypeCode, int relId, String body) {

		ResultData<Integer> replyWriteRd = replyService.writeReply(rq.getLoginedMemberId(), relTypeCode, relId, body);

		return Util.jsReplace(replyWriteRd.getMsg(), Util.f("../article/detail?id=%d", relId));
	}

	
}