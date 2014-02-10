<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="publiclzhc@sina.com">
<title>视频信息</title>
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.png">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/respond.min.js"></script>
<!--[if lte IE 7]>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap/css/bootstrap-my-ie6-ie7.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap/css/bootstrap-ie6.min.css">
<![endif]-->

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/item.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/item.js"></script>

</head>
<body>
	<input type="hidden" id="contextPath" name="contextPath" value="<%=request.getContextPath() %>" />
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath() %>">得味驿站</a>
			</div>
			<ul class="nav navbar-nav">
				<c:forEach items="${topicDTOList}" var="topic" varStatus="st">
					<c:choose>
						<c:when test="${(st.index == 0 and empty param.topicId) or (param.topicId == topic.topicId)}">
							<li class="active"><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- <li class="active"><a href="#">首页</a></li>
				<li><a href="#">电视剧</a></li>
				<li><a href="#">动漫</a></li> -->
			</ul>
		</nav> <!-- header nav end -->
	</div>
	<div class="container">
		<!-- 行 -->
		<div class="row">
			<div class="col-xs-3" role="navigation">
				<div class="list-group">
					<c:choose>
		            		<c:when test="${(empty param.categoryId)}">
		            			<a class="list-group-item active" href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topicDTO.topicId }"><c:out value="${topicDTO.name}"></c:out> </a>
		            		</c:when>
		            		<c:otherwise>
		            			<a class="list-group-item" href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topicDTO.topicId }"><c:out value="${topicDTO.name}"></c:out> </a>
		            		</c:otherwise>
		            	</c:choose>
		            
		            <!-- <a href="#" class="list-group-item">Link</a> -->
		            <c:forEach items="${topicDTO.categoryDTOs }" var="category">
		            	<c:choose>
		            		<c:when test="${category.categoryId == param.categoryId}">
		            			<a class="list-group-item active" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${category.name }</a>
		            		</c:when>
		            		<c:otherwise>
		            			<a class="list-group-item" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${category.name }</a>
		            		</c:otherwise>
		            	</c:choose>
		            </c:forEach>
		        </div>
			</div> <!-- col -->
			<div class="col-xs-9">
				<div class="panel panel-default c-item-panel">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<h3 class="panel-title">${itemDTO.name}</h3>
					</div>
					<!-- Nav tabs -->
					<ul class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">基本信息</a></li>
						<!-- <li><a href="#profile" data-toggle="tab">Profile</a></li>
						<li><a href="#messages" data-toggle="tab">Messages</a></li>
						<li><a href="#settings" data-toggle="tab">Settings</a></li> -->
					</ul>
					<!-- <div class="panel-body"> -->
						<!-- Tab panes -->
						<div class="tab-content">
							<div class="tab-pane active" style="color:black;" id="home">
								<span class="c-info-title">地区： </span>${itemDTO.areaName } <span class="c-info-title">上映时间：</span>${itemDTO.showDate} 
												<span class="c-info-title">豆瓣评分：</span>${itemDTO.score}
											<p><span class="c-info-title">主演： </span>
													${itemDTO.actorName}
											</p>
											<p><span class="c-info-title">类型： </span>
												${itemDTO.itemType}
											</p>
											<p><span class="c-info-title">简介：</span> ${itemDTO.description}
											</p>
								<%-- <div class="media">
								  <!-- <a class="pull-left" href="#">
								    <img class="media-object" src="http://t3.baidu.com/it/u=3801314049,2971358795&fm=20" alt="照片">
								  </a> -->
								  <div class="media-body">
										<h4 class="media-heading">
											<span class="">地区： </span>${itemDTO.areaName } <span class="c-info-title">上映时间：</span>${itemDTO.showDate} 
												<span class="c-info-title">豆瓣评分：</span>${itemDTO.score}
											<p><span class="c-info-title">主演： </span>
													${itemDTO.actorName}
											</p>
											<p><span class="c-info-title">类型： </span>
												${itemDTO.itemType}
											</p>
											<p><span class="c-info-title">简介：</span> ${itemDTO.description}
											</p>
										</h4>
									</div>
								</div> --%>
							</div>
							<div class="tab-pane" id="profile">PROFILE</div>
							<div class="tab-pane" id="messages">MESSAGES</div>
							<div class="tab-pane" id="settings">SETTINGS</div>
						</div>
						<!-- videolist -->
						<!-- Nav tabs -->
						<ul class="nav nav-tabs">
							<c:forEach items="${itemDTO.videoSrcDTOs}" var="videoSrc" varStatus="st">
								<li <c:if test="${st.index == 0 }"> class="active"</c:if> >
									<a href="#${videoSrc.videoSrcId}" data-toggle="tab">${videoSrc.name}</a>
								</li>
							</c:forEach>
						</ul>
						<div class="tab-content c-video-content">
							<c:forEach items="${itemDTO.videoSrcDTOs}" var="videoSrc" varStatus="st">
									<div 
										<c:if test="${st.index == 0 }"> class="tab-pane active" </c:if>
										<c:if test="${st.index > 0 }"> class="tab-pane" </c:if>
									 id="${videoSrc.videoSrcId}">
										<div class="c-video-list">
											<ul class="nav navbar-nav">
												<c:forEach items="${videoSrc.videoDTOs }" var="video" varStatus="st">
														<li <c:if test="${st.index >= 20 }"> class="c-video-more-display" </c:if> ><a href="<%=request.getContextPath() %>/videoplay!play?url=${video.url}">第${st.count}集</a></li>
												</c:forEach>
											</ul>
										</div>
										<div class="clearfix"></div>
										<div class="pull-right">
											<a class="c-video-expanse" href="">展开》</a>
											<a class="c-video-collpase" href="">收起》</a>
										</div>
									</div>
							</c:forEach>
						</div>
					<!-- </div> --> <!-- panel-body -->
				</div> <!-- panel -->
				
			</div><!-- col end -->
		</div><!-- content row end -->
		<!-- 底部 -->
		<div class="footer">
			<p>&copy; Email: publiclzhc@sina.com 2013</p>
		</div>
	</div> <!-- container end -->
</body>
</html>
