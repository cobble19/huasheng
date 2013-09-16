$(document).ready(function() {
	/*展开*/
	$(".c-video-content .c-video-expanse").click(function(event) {
		event.preventDefault();
		$(".c-video-more-display").show();
		$(this).hide();
		$(".c-video-content .c-video-collpase").show();
	});
	/*收起*/
	$(".c-video-content .c-video-collpase").click(function(event) {
		event.preventDefault();
		$(".c-video-more-display").hide();
		$(this).hide();
		$(".c-video-content .c-video-expanse").show();
	});
});