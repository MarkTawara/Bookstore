/**
 * Created by Branden on 9/29/17.
 */

$(document).ready(function(){
    $('.carousel').slick({
        infinite: true,
        arrows: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 3,
        autoplay: true
    });
});

/* This function toggles the select all for the checkboxes on shipping_manager.html*/
function toggle(source) {
	  checkboxes = document.getElementsByName('box');
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = source.checked;
	  }
	}
