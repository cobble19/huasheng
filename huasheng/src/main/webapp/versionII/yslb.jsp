<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>得味驿站</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.png">
<link href="<%=request.getContextPath()%>/versionII/css/ys.css"
	type="text/css" rel="stylesheet" />

</head>

<body>
<div class="main">
		<div class="tou">
			<div class="logo">
				<img src="<%=request.getContextPath()%>/versionII/images/logo.jpg" />
			</div>
		</div>
		<div class="top">
			<ul>
				<c:choose>
			    <c:when test="${(st.index == 0) and (empty param.topicId)}">
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
            	<div class="main_lm_t"><c:out value="${topicDTO.name}"></c:out>分类 </div>
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
	  <div class="main_lb_zt">
	      <div class="main_lb_k">
		      <div class="main_lb_t"><p><c:out value="${topicDTO.name}"></c:out>分类排行</p></div>
			  <div class="main_lb_f"><SPAN class=tt-lb-index>排名</SPAN><SPAN class=tt-lb-title>关键词</SPAN><SPAN class=tt-lb-value>搜索指数</SPAN> </div>
			  <div class="main_lb">			      
				  <UL class=item-list>
				  <c:forEach items="${categoryDTO.itemDTOs }" var="item" varStatus="st">
                  <LI class=current>
                  <DIV class=item-hd-lb><SPAN class=num-top>${st.index + 1}</SPAN> <A class=list-lb-title title="${item.name }" href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${categoryDTO.categoryId }" target=_blank>${item.name }</A><SPAN class=icon-lb-rise>${item.hits }</SPAN></DIV>
				  <div class="lb_fx"></div>
				  <div class="lb_js">
				      <div class="lb_js_tp"><img src="images/lbtp.jpg" /></div>
					  <div class="lb_js_wz">${item.description}</div>
				  </div>
                  </LI>
				  </c:forEach>
                  </UL>  
			  </div>
		  </div>
	      
		  
	  </div>
  </div>

</div>
</body>
</html>
