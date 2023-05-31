<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Main" />
<%@ include file="../common/head.jsp" %>
	<section class="mt-8">
		<div class="container mx-auto">
			<div>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus ut voluptates atque quod tempore quaerat non cumque magni nihil eveniet molestiae eius earum ratione! Voluptate error minus magni quibusdam similique.
			</div>
			<div>
				안녕하세요
			</div>
			<div><img src="/resource/image/shoes.jpg"/></div>
			<span class="modal-exam">모달예시</span>
			<br />
			<span class="popUp-exam">팝업예시</span>
			
			
			<div class="layer-bg"></div>
			<div class="layer">
				<h1>MODAL</h1>
				<span class="close-x-btn">&times;</span>
				<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero aut ab atque porro aliquid consequuntur tempore! Consequatur magnam explicabo placeat quos commodi quam ad odit voluptatum culpa tempora necessitatibus quo?</div>
				<button class="close-btn btn btn-active">CLOSE</button>				
			</div>
			
			<div>
				<form action="upload" method="POST" enctype="multipart/form-data">
					<input type="file" name="file" />
					<button>업로드</button>
				</form>
			</div>
			
			<div>
				<a href="/usr/home/view">파일보러가기</a>
			</div>
			
			
		</div>
	</section>
<%@ include file="../common/foot.jsp" %>