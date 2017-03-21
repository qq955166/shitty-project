/**
 * 
 */

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