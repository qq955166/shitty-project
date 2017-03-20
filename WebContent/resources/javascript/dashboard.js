/**
 * 
 */

/*// Get the modal
var rtnmsg = document.getElementById('rtnmsg');

// Get the button that opens the modal
var result = document.getElementById("result");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

//When the user clicks on <span> (x), close the modal
span.onclick = function() {
	rtnmsg.style.display = "none";
}

window.onclick = function(event) {
	if(event.target==rtnmsg){
		rtnmsg.style.display = 'none';
	}
}*/

$(document).ready(function() {
	$('tr:nth-child(even)').addClass('alt');
	
	if($('#result').val()){
		$('#rtnmsg')[0].style.display = "block";
	}
	
	$('.close').on('click', function() {
		$('#rtnmsg')[0].style.display = "none";
	});
	
	$(window).on('click', function() {
		$('#rtnmsg')[0].style.display = "none";
	});
});