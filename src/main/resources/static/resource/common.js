$('select[data-value]').each(function(index, item){
//select 태그의 data-value를 찾아서 요소를 하나씩 순회한다. each 함수안에 함수가 있다.
	const items = $(item);
	
	const defaultValue = items.attr('data-value').trim();
	
	if (defaultValue.length > 0) {
		items.val(defaultValue);
	}
	
	//아이템에 defaultvalue를 세팅
})