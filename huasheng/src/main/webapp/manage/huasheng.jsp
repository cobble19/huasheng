<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="publiclzhc@sina.com">
<title>manage > huasheng.jsp</title>
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.png">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/extjs4/resources/css/ext-all.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/extjs4/ext-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/manage/huasheng.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/extjs-common.css">
<!--[if lte IE 7]>
<script type="text/javascript">
	var console = console || {
    log : function(){
        return false;
    }
}
</script>
<![endif]-->
</head>
<body>
	<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="username" value="<%= request.getUserPrincipal().getName()%>" />
	<input type="hidden" id="securityUsername" value='<security:authentication property="principal.username"/>' />
	
</body>
</html>