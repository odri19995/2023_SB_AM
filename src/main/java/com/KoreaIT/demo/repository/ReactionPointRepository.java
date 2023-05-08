package com.KoreaIT.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.KoreaIT.demo.vo.ReactionPoint;


@Mapper
public interface ReactionPointRepository {

	@Select("""
			SELECT IFNULL(SUM(`point`), 0) AS sumReactionPoint
				FROM reactionPoint
				WHERE memberId = #{loginedMemberId}
				AND relId = #{relId}
				AND relTypeCode = #{relTypeCode}
			""")
	ReactionPoint getReactionPoint(int loginedMemberId, int relId, String relTypeCode);

}