<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="publiclzhc@sina.com">
<title>得味驿站首页</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.png">
<link href="<%=request.getContextPath()%>/versionII/css/ys.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<input type="hidden" id="contextPath" name="contextPath"
		value="<%=request.getContextPath()%>" />
	<div class="main">
		<div class="tou">
			<div class="logo">
				<img src="<%=request.getContextPath()%>/versionII/images/logo.jpg" />
			</div>
		</div>
		<div class="top">
			<ul>
			    <c:choose>
			    <c:when test="${(st.index == 0) or (empty param.topicId)}">
				<li class="select"><a href="<%=request.getContextPath() %>">首页</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="<%=request.getContextPath() %>">首页</a></li>
				</c:otherwise>
				</c:choose>
				<c:forEach items="${topicDTOList}" var="topic" varStatus="st">
				<c:choose>
				<c:when test="${param.topicId == topic.topicId}">
					<li class="select"><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name}</a></li>
				</c:when>
				<c:otherwise>
				    <li><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name}</a></li>
				</c:otherwise>
				</c:choose>
				</c:forEach>
			</ul>
		</div>
		<div class="top_x"></div>
		<div class="main_1">
			<div class="main_lm">
            	<div class="main_lm_t"><c:out value="${topicDTO.name}"></c:out>分类</div>
				<div class="main_lm_lb">
					<ul>
						<c:forEach items="${topicDTO.categoryDTOs }" var="category">
		            	<c:choose>
		            		<c:when test="${category.categoryId == param.categoryId}">
		            			<li class="ls"><a title="${category.name }" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${category.name }</a></li>
		            		</c:when>
		            		<c:otherwise>
		            			<li class="bs"><a title="${category.name }" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${category.name }</a></li>
		            		</c:otherwise>
		            	</c:choose>
		                </c:forEach>
					</ul>
				</div>
			</div>
			<div class="main_zt">
			<c:forEach items="${topicDTO.categoryDTOs }" var="category">
				<div class="main_zt_2">
					<div class="main_zt_lm">
						<div class="zt-c3">${category.name }</div>
					</div>
					<div class="main_zt_fl">
						<SPAN class=tt-index>排名</SPAN><SPAN class=tt-title>关键词</SPAN><SPAN
							class=tt-value>点击指数</SPAN>
					</div>
					<div class="main_zt_lb">
						<UL class=item-list>
							<c:forEach items="${category.itemDTOs }" var="item" varStatus="st">
								<LI class=current>
								<DIV class=item-hd>
									<SPAN class=num-top2>${st.index + 1 }</SPAN> <A class=list-title title="${item.name }"
										href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${category.categoryId }" target=_blank>${item.name }</A><SPAN class=icon-rise>${item.hits }</SPAN>
								</DIV>
							</LI>
							</c:forEach>
						</UL>
					</div>
				</div>
			</c:forEach>
            </div>
			</div>
		</div>
</body>
</html>
