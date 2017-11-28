//Function handles error checking when inputting an email to the forgot email page
$(document).ready(function(){
	$('#forgotpw').submit(function(submission){

		//Send an alert to the user if one or more fields is left blank.
		//Loop controls the alert to just one alert, instead of alerting the user for all the fields left blank.
		var loop = true;
		$(':input').each(function(){
			if($(this).val()==="" && loop===true){
				alert("One or more fields have been left blank.");
				loop = false;
			}
		});
		
		var email = document.getElementById("email").value;
		if(email.indexOf("@") == -1){
			alert("Please use a valid form of email address.");
			return false;
		}else if(email.indexOf(".") == -1){
			alert("Please use a valid form of email address.");
			return false;
		}

	});
});