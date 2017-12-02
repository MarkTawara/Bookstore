$(function(){
	$ajax({
		url : 'SearchBooksServlet',
		data : {"type" : "all"},
		dataType : "json", 
		method : "POST",
		success : function(response) {
			var obj = JSON.stringify(result);
			console.log(obj);
		}
	})
});