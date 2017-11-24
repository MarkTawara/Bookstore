/**
 * 
 */

//Alerts user if file chosen is not an appropriate image
function extensionFailure(){
	$('#imageFailure').show();
	$('#imageFailure').html(" Please use an appropriate image.").css('color', 'red');
};

//Alerts user without using an alert if price is unsatisfactory.
function priceFailure(){
	$('#priceFailure').show();
	$('#priceFailure').html(" Please use only numbers for Price.").css('color', 'red');
};

//Removes the alert if previously present.
function priceOkay(){
	$('#priceFailure').hide();
};

//Function handles error checking when submitted a book to the database.
$(document).ready(function(){
	$('#addBookForm').submit(function(submission){
		
		//Send an alert to the user if one or more fields is left blank.
		//Loop controls the alert to just one alert, instead of alerting the user for all the fields left blank.
		var loop = true;
		$(':input').each(function(){
			if($(this).val()==="" && loop===true){
				alert("One or more fields have been left blank.");
				loop = false;
			}
		});
		
		//Check if the price contains valid digits and format. Also allows for "."
		//The priceFailure() is only ran when there is something wrong with the price, 
		//so it will not over alert the user, (For example when the price is left blank).
		var price= $('#price').val();
		if(price.match('[0-9].?[0-9]')){
			priceOkay();
		}else if(price===''){
			priceOkay();
		}else{
			priceFailure();
			return false;
		}
		
		// Grab filename based on ID tag for the image
		var filename = $('#image').val();
		// Remove anything before the extension - including the .
		var ext = filename.replace(/^.*\./, '');
		ext = ext.toLowerCase();
		// Detect for the proper file extension.
		switch (ext) {
		case 'jpg':
		case 'jpeg':
		case 'png':
			break;
		default:
			// If a file of the above extensions is not submitted, don't allow
			// the form to submit, and alert the user.
			extensionFailure();
			return false;
		}
	});
});

