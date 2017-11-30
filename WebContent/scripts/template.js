$(function(){
	var filename = location.href.split("/").slice(-1);
	$(".top_bar").load("templates/template.jsp .top_bar");
	if(filename == "all_books.jsp"){
		$("#navibar").load("templates/template.jsp #navibarBrowse");
	}else if(filename =="about.jsp"){
		$("#navibar").load("templates/template.jsp #navibarAbout");
	}else if(filename == "index.jsp"){
		$("#navibar").load("templates/template.jsp #navibarHome");
	}else{
		$("#navibar").load("templates/template.jsp #navibar");
	}
	$(".footer").load("templates/template.jsp .footer");
	//alert('Got to template function');
});