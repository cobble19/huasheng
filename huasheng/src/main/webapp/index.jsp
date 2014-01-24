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
<title>得味驿站首页</title>
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

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/index.css">

<script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>

</head>
<body>
	<input type="hidden" id="contextPath" name="contextPath" value="<%=request.getContextPath() %>" />
	<div class="container">
		<nav id="header" class="navbar navbar-default" role="navigation">
		
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
			</ul>
		</nav>
	</div>
	<div class="container">
		<!-- 行 -->
		<div class="row">
			<div class="col-xs-3">
				<div class="list-group">
					<c:choose>
	            		<c:when test="${(empty param.categoryId)}">
	            			<a class="list-group-item active" href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topicDTO.topicId }"><c:out value="${topicDTO.name}"></c:out> </a>
	            		</c:when>
	            		<c:otherwise>
	            			<a class="list-group-item" href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topicDTO.topicId }"><c:out value="${topicDTO.name}"></c:out> </a>
	            		</c:otherwise>
	            	</c:choose>
		            
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
			</div>
			<div class="col-xs-9">
					<c:forEach items="${topicDTO.categoryDTOs }" var="category">
		            	<div class="col-md-4">
							<div class="panel panel-default">
							  <!-- Default panel contents -->
							  <div class="panel-heading">
							  ${category.name }
							  	<%-- <h3 class="panel-title">${category.name }
							  		<p class="pull-right">
										<a href="<%=request.getContextPath() %>/category!getCategoryById?categoryId=${category.categoryId }&topicId=${topicDTO.topicId }" class="navbar-link">更多</a>
									</p>
							  	</h3> --%>
							  </div>
							  <!-- <div class="row c-panel-title">
							    	<div class="col-xs-3">排名</div>
							    	<div class="col-xs-4">名称</div>
							    	<div class="col-xs-5">点击数</div>
							    </div> -->
							    <%-- <c:forEach items="${category.itemDTOs }" var="item" varStatus="st">
							    	<div class="row c-panel-content">
								    	<div class="col-xs-3">${st.index + 1 }</div>
								    	<div class="col-xs-4"><a href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${item.name }</a></div>
								    	<div class="col-xs-4"><span class="badge">${item.hits }</span></div>
								    </div>
							    </c:forEach> --%>
							    
							  <!-- <div class="panel-body">
							  </div> -->
							  <!-- Table -->
							  <table class="table table-hover">
							  	<thead>
								  	<tr>
								    	<th>排名</th>
								    	<th>名称</th>
								    	<th>点击数</th>
								    </tr>
							  	</thead>
							  	<tbody>
								    <tr>
									    <c:forEach items="${category.itemDTOs }" var="item" varStatus="st">
									    	<tr>
										    	<td>${st.index + 1 }</td>
										    	<td><a href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${item.name }</a></td>
										    	<td><span class="badge">${item.hits }</span></td>
									    	</tr>
									    </c:forEach>
								    </tr>
							  	</tbody>
							  </table>
								<div class="panel-footer">谢谢收看
									<%-- <h3 class="panel-title">谢谢收看
							  			<p class="pull-right">
											<a href="<%=request.getContextPath() %>/category!getCategoryById?categoryId=${category.categoryId }&topicId=${topicDTO.topicId }" class="navbar-link">更多</a>
										</p>
							  		</h3> --%>
								</div>
							</div>
						</div>
		            </c:forEach>
			</div>
		</div>
	</div> <!-- container end -->
	
		<!-- 底部 -->
		<hr>
		<div class="container">
			<footer>
			  <p>&copy; Email: publiclzhc@sina.com 2013</p>
			</footer>
			<!-- <div class="row">
				<div class="footer">
					<p>&copy; Email: publiclzhc@sina.com 2013</p>
				</div>
			</div> -->
		</div>
</body>
</html>
