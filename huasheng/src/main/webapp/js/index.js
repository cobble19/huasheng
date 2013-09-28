$(document).ready(function() {
	console.log("index.js");
	/*$.ajax({
		url: $("#contextPath").val() + "/topicJson/topic!execute",
		dataType: "json",
		success: function(data, textStatus, jqXHR ) {
			console.log(data);
			topicDTOList = data.topicDTOList;
			for (var i = 0; i < topicDTOList.length; i++) {
				console.log(topicDTOList[i].topicId);
				var liClass="";
				if (i == 0) {
					liClass = " class=\"active\"";
				}
				var $li = $("<li" + liClass + "><a href=\"" + $("#contextPath").val() + "/topic!getTopicById?topicId="
						+ topicDTOList[i].topicId + "\">"
						+ topicDTOList[i].name + "</a></li>");
				$("nav ul").append($li);
			}
			
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});*/
});