<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>得味驿站</title>
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.png">
<link href="<%=request.getContextPath()%>/versionII/css/videorank.css" type="text/css" rel="stylesheet" media="print, projection, screen"/>
        <script src="<%=request.getContextPath()%>/versionII/js/jquery-1.2.4b.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/versionII/js/ui.core.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/versionII/js/ui.tabs.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function() {
                $('#rotate > ul').tabs({ fx: { opacity: 'toggle' } }).tabs('rotate', 0);
            });
        </script> 
</head>

<body>
<div class="main">
  <div class="tou">
      <div class="logo"><img src="<%=request.getContextPath()%>/versionII/images/logo.jpg" /></div>
  </div>
  <div class="top">
      <ul>
	      <li><a href="<%=request.getContextPath() %>">首页</a></li>
		  <c:forEach items="${topicDTOList}" var="topic" varStatus="st">
					<li><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name}</a></li>
		  </c:forEach>
	  </ul>
  </div>
  <div class="main-z">
	      <div class="tvjs-tp"><img src="<%=request.getContextPath()%>/${itemDTO.imgUrl}" /></div>
		  <div class="tvjs-wz">
		      <div class="tvjs-wz-mz">${itemDTO.name}</div>
			  <div class="tvjs-wz-zy"><p>主演：</p> <span>${itemDTO.actorName}</span></div>
			  <div class="tvjs-wz-dy"><p>导演：</p> <span>${itemDTO.director}</span></div>
			  <div class="tvjs-wz-dq"><p>地区：</p> <span>${itemDTO.areaName }</span></div>
			  <div class="tvjs-wz-bq"><p>标签：</p> <span>${itemDTO.itemType}</span></div>
			  <div class="tvjs-wz-jj" id="hutia"><p>简介：</p> ${itemDTO.description}</div>
			  <script src="<%=request.getContextPath()%>/versionII/js/ss.js" type="text/javascript"></script>
		  </div>
		  
		  
		  
		  <div id="rotate">
            <ul>
                <div class="zxgk">在线观看:</div>
				<c:forEach items="${itemDTO.videoSrcDTOs}" var="videoSrc" varStatus="st">
				    <li><a href="#${videoSrc.videoSrcId}"><span>${videoSrc.name}</span></a></li>
				</c:forEach>
            </ul>
			<c:forEach items="${itemDTO.videoSrcDTOs}" var="videoSrc" varStatus="st">  
			<div id="${videoSrc.videoSrcId}">
               <ul class="myj">
			     <c:forEach items="${videoSrc.videoDTOs }" var="video" varStatus="st">
			       <li><a href="<%=request.getContextPath() %>/videoplay!play?url=${video.url}">第${st.count}集</a></li>
				 </c:forEach>
			   </ul>
            </div>

			</c:forEach>
    </div>
		  
		  
		  
		  
		  
		  
  
  </div>
  <div class="main-y">
  
  
      <div class="pht">最热<c:out value="${topicDTO.name}"></c:out>排行榜</div>
      <div class="nr_ph_lb">
			      
				  <UL class=nr-item-list>
				  <c:forEach items="${categoryDTO.itemDTOs }" var="item" varStatus="st">
                  <LI class=nr-current>
                  <DIV class=nr-item-hd><SPAN class=ph-num>${st.index + 1}</SPAN> <A class=nr-list-title title="${item.name }" href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${categoryDTO.categoryId }" target=_blank>${item.name }</A></DIV>
                  </LI>
				  </c:forEach>
                  </UL>  
		</div>
  
  
  
  </div>

</div>
</body>
</html>
