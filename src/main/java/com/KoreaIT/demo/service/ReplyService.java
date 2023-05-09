package com.KoreaIT.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KoreaIT.demo.repository.ReplyRepository;
import com.KoreaIT.demo.util.Util;
import com.KoreaIT.demo.vo.Reply;
import com.KoreaIT.demo.vo.ResultData;

@Service
public class ReplyService {
	
	private ReplyRepository replyRepository;
	
	@Autowired
	public ReplyService(ReplyRepository replyRepository) {
		this.replyRepository = replyRepository;
	}
	
	public ResultData<Integer> writeReply(int loginedMemberId, String relTypeCode, int relId, String body) {
		replyRepository.writeReply(loginedMemberId, relTypeCode, relId, body);
		
		int id = replyRepository.getLastInsertId();
		
		return ResultData.from("S-1", Util.f("%d번 댓글이 등록되었습니다", id), "id", id);
	}

	public List<Reply> getReplies(String relTypeCode, int relId) {
		return replyRepository.getReplies(relTypeCode, relId);
	}
	
}