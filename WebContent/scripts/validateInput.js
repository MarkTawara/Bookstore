/**
 * 
 */

$(document).ready(function() {
	$("#create_account_button").click(function() {
		//if (validateForm()) {
			console.log("entei the pokemon");
			check_email();
		//}
	})
	
	/*
	function check_inputs(){
		var fname = $("#firstname").val();
		var lname = $("#firstname").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var phone = $("#phone").val();
		var street1 = $("#street").val();
		var city1= $("#city").val();
		var zip1= $("#zip").val();
		var cardnum= $("#cardnum").val();
		var street2 = $("#street2").val();
		var city2 = $("#city2").val();
		var zip2 = $("#zip2").val();
		if (!fname){
			
		}
	}
	*/
	
	function validateForm()
	{
	  var fields = ["firstname", "lastname", "email", "password", "phonenum", "street", "city", "zip", "cardnum", "street2", "city2", "zip2"]

	  var i, l = fields.length;
	  var fieldname;
	  for (i = 0; i < l; i++) {
	    fieldname = fields[i];
	    console.log(document.forms["registration_form"][fieldname].value);
	    
	    if (document.forms["registration_form"][fieldname].value === "") {
	      alert("Please fill out all inputs");
	      return false;
	    }
	  }
	  return true;
	}
	
	function check_email() {
		var info = $("#registration_form").serializeArray();
		
		//alert("hi");
		
		$.ajax({
			url: 'SignUpServlet',
			data : info,
			method: "POST",
			success : function(responseText) {
				// Means email exists therefore invalid
				if (responseText == "true") {
					$("#email_error").html("Email is already registered");
				} else {
					$("#email_error").html("");
				}
			}
		})
	}
	
})