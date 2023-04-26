<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	let msg = '${msg}'.trim();
	let isHistoryBack = '${isHistoryBack}';
	
	// falsy 값이 있으면 true값 반환
	if (msg) {
		alert(msg);
	}
	
	if (isHistoryBack) {
		history.back();
	}
</script>