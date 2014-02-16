<%--
  Created by IntelliJ IDEA.
  User: Moji
  Date: 14-2-16
  Time: 上午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>权限管理</title>
    <jsp:include page="${ctx}/WEB-INF/views/common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container col-md-10 col-md-offset-1">
    <div class="row">
        <div class="col-md-2">
            <jsp:include page="../layout/left.jsp"></jsp:include>
        </div>
        <div class="col-md-10">
            <h1>权限管理模块</h1>
        </div>
    </div>
</div>
</body>
</html>
