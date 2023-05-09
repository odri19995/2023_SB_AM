<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Detail" />
<%@ include file="../common/head.jsp" %>


	<script>
		function getReactionPoint(){
			
			$.get('../reactionPoint/getReactionPoint', {
				relId : ${article.id},
				relTypeCode : 'article'
			}, function(data) {
/* 				console.log($('#goodBtn'));
				console.log(data); */
				
				if(data.data1.sumReactionPoint > 0){
					let goodBtn = $('#goodBtn');
					goodBtn.removeClass('btn-outline');
					goodBtn.attr('href', '../reactionPoint/doDeleteReactionPoint?relId=${article.id }&relTypeCode=article&point=1');
				}else if (data.data1.sumReactionPoint<0){
					let badBtn = $('#badBtn');
					badBtn.removeClass('btn-outline');
					badBtn.prop('href', '../reactionPoint/doDeleteReactionPoint?relId=${article.id }&relTypeCode=article&point=-1');
				}
				
			}, 'json');
			
		}
		
		$(function() {
			getReactionPoint();
		})
	</script>



	<section class="mt-8 text-xl">
		<div class="container mx-auto px-3">
			<div class="table w-full">
				<table>
					<colgroup>
						<col width="200" />
					</colgroup>
					<tbody>
						<tr class="hover">
							<th>번호</th>
							<td>${article.id }</td>
						</tr>
						<tr>
							<th>작성날짜</th>
							<td>${article.regDate }</td>
						</tr>
						
						<tr class="hover">
							<th>수정날짜</th>
							<td>${article.updateDate }</td>
						</tr>
						<tr>
							<th>추천</th>
							<td>
								<c:if test="${rq.getLoginedMemberId() == 0 }">
<!-- 								로그인 되어있지 않을 경우 -->
									<span class="ml-2 badge">좋아요 : ${article.goodReactionPoint }개</span>
									<br />
									<span class="ml-2 badge">싫어요 : ${article.badReactionPoint * -1 }개</span>
								</c:if>
								<c:if test="${rq.getLoginedMemberId() != 0 }">
<!-- 								로그인 되어있을 경우 -->
									<a id="goodBtn" class="btn btn-outline btn-xs" href="../reactionPoint/doInsertReactionPoint?relId=${article.id }&relTypeCode=article&point=1">좋아요👍</a>
									<span class="ml-2 badge">좋아요 : ${article.goodReactionPoint }개</span>
									<br />
									<a id="badBtn" class="btn btn-outline btn-xs" href="../reactionPoint/doInsertReactionPoint?relId=${article.id }&relTypeCode=article&point=-1">싫어요👎</a>
									<span class="ml-2 badge">싫어요 : ${article.badReactionPoint * -1 }개</span>
								</c:if>
							</td>
						</tr>
						<tr class="hover">
							<th>작성자</th>
							<td>${article.writerName }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${article.title }</td>
						</tr>
						<tr class="hover">
							<th>내용</th>
							<td>${article.body }</td>
						</tr>
						<tr class="hover">
							<th>조회수</th>
							<td><span class="badge" id="articleDetail_increaseHitCount">${article.hitCount }</span></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="btns">
				<button class="btn-text-link btn btn-active" type="button" onclick="history.back();">뒤로가기</button>
				<c:if test="${article.actorCanChangeData }">
					<a class="btn-text-link btn btn-active" href="modify?id=${article.id }">수정</a>
					<a class="btn-text-link btn btn-active" href="doDelete?id=${article.id }" onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;">삭제</a>
				</c:if>
			</div>		
		</div>
	</section>
	
	<section class="mt-5 text-xl">
		<div class="container mx-auto px-3">
			<h2>댓글</h2>
			<form action="../reply/doWrite" method="POST" onsubmit="replyWrite_submitForm(this); return false;">
				<input type="hidden" name="relTypeCode" value="article" />
				<input type="hidden" name="relId" value="${article.id }" />
				<div class="mt-4 border border-gray-400 rounded-lg text-base p-4">
					<div class="mb-2"><span>닉네임</span></div>
					<textarea class="textarea textarea-bordered w-full" name="body" placeholder="내용을 입력해주세요"></textarea>
					<div class="flex justify-end"><button class="btn-text-link btn btn-active btn-sm">등록</button></div>
				</div>
			</form>
		</div>
	</section>
		
		
		
		
			</form>
		</div>
	</section>
	
<%@ include file="../common/foot.jsp" %>