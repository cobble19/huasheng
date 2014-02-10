$(document).ready(function() {
	/*展开*/
	$(".c-video-content .c-video-expanse").click(function(event) {
		event.preventDefault();
		$(this).parent().siblings().find(".c-video-more-display").show();
		/*$(".c-video-more-display").show();*/
		$(this).hide();
		$(this).parent().find(".c-video-collpase").show();
		/*$(".c-video-content .c-video-collpase").show();*/
	});
	/*收起*/
	$(".c-video-content .c-video-collpase").click(function(event) {
		event.preventDefault();
		$(this).parent().siblings().find(".c-video-more-display").hide();
		/*$(".c-video-more-display").hide();*/
		$(this).hide();
		$(this).parent().find(".c-video-expanse").show();
		/*$(".c-video-content .c-video-expanse").show();*/
	});
});