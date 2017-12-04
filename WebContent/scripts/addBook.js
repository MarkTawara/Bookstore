/**
 * 
 */

//Alerts user if file chosen is not an appropriate image
function extensionFailure(){
	$('#imageFailure').show();
	$('#imageFailure').html(" Please use an appropriate image.").css('color', 'red');
};

//Function handles error checking when submitted a book to the database.
$(document).ready(function(){
	$('#addBookForm').submit(function(submission){
	
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

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#myImg')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

