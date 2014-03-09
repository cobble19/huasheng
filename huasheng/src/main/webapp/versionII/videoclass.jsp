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
<title>得味驿站</title>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.png">
<link href="<%=request.getContextPath()%>/versionII/css/videoindex.css" type="text/css" rel="stylesheet" media="print, projection, screen"/>
</head>

<body>
<div class="main">
<div class="videotop-main">

  <div class="videotop-tou">

      <div class="logo"><a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/versionII/images/logo.jpg" /></a></div>

  </div>
  
  <div class="videoclass-dhk">
      <div class="videoclass-dhk-zuo">
	      <div class="videoclass-dhk-zuo-top">
	           <p>影视导航 >></p>
	      </div>
	      <div class="videoclass-dhk-zuo-bottom">
	           <p>详细分类 >></p>
	      </div>
	  </div>
	  <div class="videoclass-dhk-you">
          <div class="videoclass-dhk-you-top">
		       <c:forEach items="${topicDTOList}" var="topic" varStatus="st">
			   <c:choose>
				<c:when test="${param.topicId == topic.topicId}">
	            <div class="select-top-y"><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name}</a></div>
				</c:when>
				<c:otherwise>
				<div class="select-top-n"><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">${topic.name}</a></div>
				</c:otherwise>
				</c:choose>
				</c:forEach>	   
	      </div>
		  <div class="fhsy"><a href="<%=request.getContextPath() %>">返回首页>></a></div>
	      <div class="videoclass-dhk-you-bottom">
		      <c:forEach items="${topicDTO.categoryDTOs }" var="category">
		      <c:choose>
		      <c:when test="${category.categoryId == param.categoryId}">
	          <div class="select-bottom-y"><a class="select" title="${category.name }" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${category.name }</a></div>
			  </c:when>
		      <c:otherwise>
			  <div class="select-bottom-n"><a title="${category.name }" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">${category.name }</a></div>
			  </c:otherwise>
		      </c:choose>
		      </c:forEach>
	      </div>
	  </div>
  </div>
  <div class="video-index-main">
  <c:forEach items="${topicDTO.categoryDTOs }" var="category">
  <div class="videoclass-lbk">
            
            <ul class="videoclass-lbtk">
			    <div class="videoclass-lbbt">${category.name}</div>
				
                <div class="videoclass-lbmore"><a title="${category.name }" href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topicDTO.topicId }&categoryId=${category.categoryId }">更多>></a></div>
            </ul>

            <ul class="videoclass-lb">
                   <c:forEach items="${category.itemDTOs }" var="item" varStatus="st">
			       <li>
				       <a class="videoclass-tp" href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topic.topicId }&categoryId=${category.categoryId }" target=_blank><img src="<%=request.getContextPath()%>/${item.imgUrl}" /></a>
					   <a class="videoclass-bt" title="${item.name }"
										href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${category.categoryId }" target=_blank>${item.name }</a>
					   <p class="videoclass-ms">${item.itemType}</p>
				   </li>
				   </c:forEach>
			   </ul>

    </div>
  <div class="videoclass-ph">
  
      <div class="video-index-pht">${category.name}剧排行榜</div>

      <div class="nr_ph_lb">

				  <UL class=nr-item-list>
                  <c:forEach items="${category.itemDTOs }" var="item" varStatus="st">
                  <LI class=nr-current>
                  <DIV class=nr-item-hd><SPAN class=ph-num>${st.index + 1 }</SPAN> <A class=nr-list-title title="${item.name }" href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topicDTO.topicId }&categoryId=${category.categoryId }" target=_blank>${item.name }</A><SPAN class=video-index-rise>${item.hits }</SPAN></DIV>
                  </LI>
                  </c:forEach>
                  </UL>  
		</div>
  </div>
  </c:forEach>
</div>


<%@ include file="bottom.jsp"%>
</div>
</body>

</html>

