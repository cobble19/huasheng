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

        <script src="<%=request.getContextPath()%>/versionII/js/jquery-1.2.4b.js" type="text/javascript"></script>

        <script src="<%=request.getContextPath()%>/versionII/js/ui.core.js" type="text/javascript"></script>

        <script src="<%=request.getContextPath()%>/versionII/js/ui.tabs.js" type="text/javascript"></script>


</head>



<body>
<div class="main">
<div class="videotop-main">
  <div class="videotop-tou">

      <div class="logo"><a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/versionII/images/logo.jpg" /></a></div>

  </div>
  
  <div class="videotop-dh-k">
      <c:forEach items="${topicDTOList}" var="topic" varStatus="st">
      <div class="videotop-dh">
	     <div class="videotop-dh-s">
		    <div class="videotop-dh-t">${topic.name}</div>
			<div class="videotop-dh-m"><a>排行</a><p>|</p><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">更多</a></div>
		 </div>
	     <div class="videotop-dh-fl">
		 <c:forEach items="${topic.categoryDTOs }" var="category">
		 <a href="<%=request.getContextPath() %>/category!getCategoryById?topicId=${topic.topicId }&categoryId=${category.categoryId }">${category.name }</a>
		 </c:forEach>
		 </div>
	  </div>
	  </c:forEach>
	  <div class="videotop-dh-r">
	     <a>排行榜</a><a>游戏</a><a>微电影</a><a>体育</a>
	  </div>
      
  </div>
</div>
  <c:forEach items="${topicDTOList}" var="topic" varStatus="st">
  <script type="text/javascript">

       $(function() {

           $('#rotate${topic.topicId } > ul').tabs({ fx: { opacity: 'toggle' } }).tabs('rotate', 0);

       });

  </script> 
<div class="video-index-main">
  <div class="video-index-lbk">
       <div id="rotate${topic.topicId }">
            
            <ul>
			    <div class="video-index-lbbt">${topic.name}</div>
				
				<c:forEach items="${topic.categoryDTOs }" var="category">
				<li><a href="#${category.categoryId}"><span>${category.name }</span></a></li>
				</c:forEach>
				
                <div class="video-index-lbmore"><a href="<%=request.getContextPath() %>/topic!getTopicById?topicId=${topic.topicId }">更多>></a></div>
            </ul>
			
            <c:forEach items="${topic.categoryDTOs }" var="category">
            <div id="${category.categoryId}">
               
               <ul class="video-index-lb">
                   <c:forEach items="${category.itemDTOs }" var="item" varStatus="st" begin="0" end="9" step="1">
			       <li>
				       <a class="video-index-tp" href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topic.topicId }&categoryId=${category.categoryId }" title="${item.name }" target=_blank><img src="<%=request.getContextPath()%>/${item.imgUrl}" /></a>
					   <a class="video-index-bt" href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${topic.topicId }&categoryId=${category.categoryId }" title="${item.name }" target=_blank>${item.name }</a>
					   <p class="video-index-ms">${item.itemType}</p>
				   </li>
				   </c:forEach>
			   </ul>
			   </div>
			   </c:forEach>
            </div>

      </div>
	  <div class="video-index-ph">

      <div class="video-index-pht">最热${topic.name}排行榜</div>
      <div class="nr_ph_lb">

				  <UL class=nr-item-list>
                  	<c:forEach items="${itemDTOList}" var="item" varStatus="st" begin="0" end="9" step="1">
                  		<c:if test="${item.categoryDTO.topicDTO.topicId == topic.topicId}">
							<LI class=nr-current>
								<DIV class=nr-item-hd>
									<SPAN class=ph-num>${st.index + 1 }</SPAN> <A
										class=nr-list-title title="${item.name }"
										href="<%=request.getContextPath() %>/item/item!getItemById?itemId=${item.itemId}&topicId=${item.categoryDTO.topicDTO.topicId }&categoryId=${item.categoryDTO.categoryId }"
										target=_blank>${item.name }</A><SPAN class=video-index-rise>${item.hits }</SPAN>
								</DIV>
							</LI>
                  		</c:if>
					</c:forEach>
                  </UL>  
		</div>
		<div class="videoindexgg"></div>
   </div>
   </c:forEach>
   </div>
<%@ include file="bottom.jsp"%>



</div>
</body>

</html>

