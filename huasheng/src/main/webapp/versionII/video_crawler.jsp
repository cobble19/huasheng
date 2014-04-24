<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>得味驿站</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath() %>/images/favicon.png">
<link href="<%=request.getContextPath()%>/versionII/css/videorank.css"
	type="text/css" rel="stylesheet" media="print, projection, screen" />
<script
	src="<%=request.getContextPath()%>/versionII/js/jquery-1.2.4b.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/versionII/js/ui.core.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/versionII/js/ui.tabs.js"
	type="text/javascript"></script>
<script type="text/javascript">
            $(function() {
                $('#rotate > ul').tabs({ fx: { opacity: 'toggle' } }).tabs('rotate', 0);
            });
        </script>
</head>

<body>
	<div class="main">
		<div class="tou">
			<div class="logo">
				<img src="<%=request.getContextPath()%>/versionII/images/logo.jpg" />
			</div>
		</div>
		<div class="top">
			<form action="<%=request.getContextPath()%>/videoCrawler!video">
				<label for="url">URL:</label>
				<input id="url" type="text" name="fragmentDTOSearch.url" value="http://www.soku.com/t/nisearch/%E4%B8%9C%E9%82%AA%E8%A5%BF%E6%AF%92">
				<label for="atag">Atag:</label>
				<input id="atag" type="text" name="fragmentDTOSearch.atag" value="div.T a">
				<input type="submit" value="查询">
			</form>
		</div>
		
		<div class="main-z">
			<div id="rotate">
				<div>
					<ul class="myj">
						<c:forEach items="${videoDTOList}" var="video" varStatus="st">
							<li><a
								href="<%=request.getContextPath() %>/videoplay!play?url=${video.url}"
								target="_blank">${video.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<%@ include file="bottom.jsp"%>
	</div>
</body>
</html>
