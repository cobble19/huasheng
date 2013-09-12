<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="leho.school.com">
<meta name="author" content="gebangyao@aliyun.com">
<title>Index</title>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css"> --%>
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.png">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/justified-nav.css">

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3 class="text-muted">leho project</h3>
			<ul class="nav nav-justified">
				<li class="active"><a href="#">首页</a></li>
				<li><a href="#">项目</a></li>
				<li><a href="#">服务</a></li>
				<li><a href="#">下载</a></li>
				<li><a href="#">关于我们</a></li>
				<li><a href="#">联系方式</a></li>
			</ul>
		</div>
		<div class="jumbotron">
			<h1>欢迎主题</h1>
			<p class="lead">热烈欢迎大家来访</p>
			<p><a class="btn btn-lg btn-success" href="#" role="button">开始今天的活动</a></p>
		</div>
		<!-- 行 -->
		<div class="row">
			<div class="col-lg-4">
				<h2>活动一</h2>
				<p>这个活动比较精彩。</p>
				<p><a class="btn btn-primary" role="button" href="#">详情 &raquo;</a></p>
			</div>
			<div class="col-lg-4">
				<h2>活动二</h2>
				<p>这个活动相当精彩。</p>
				<p><a class="btn btn-primary" role="button" href="#">详情 &raquo;</a></p>
			</div>
			<div class="col-lg-4">
				<h2>活动三</h2>
				<p>这个活动不是一般的精彩。</p>
				<p><a class="btn btn-primary" role="button" href="#">详情 &raquo;</a></p>
			</div>
		</div>
		<!-- 底部 -->
		<div class="footer">
			<p>&copy; gebangyao@aliyun.com 2013</p>
		</div>
	</div>
</body>
</html>