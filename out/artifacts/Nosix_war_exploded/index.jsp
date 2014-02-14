<%--
  Created by IntelliJ IDEA.
  User: Yaxiang He
  Date: 14-2-14
  Time: 下午1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>Nosix</title>
      <link type="text/css" href="./static/bootstrap/css/bootstrap.css">
      <script type="text/javascript" src="./static/jquery/jquery-1.10.2.js"></script>
      <script type="text/javascript" src="./static/bootstrap/js/bootstrap.min.js"></script>
      <link type="text/css" href="./static/bootstrap/css/bootstrap-theme.min.css">
  </head>
  <body>
  <div class="row">
      <form action="${ctx}/login.do" method="post" class="form-control">
          UserName:<input class="input-lg" name="username" placeholder="请输入用户名"><br>
          Password:<input class="input-lg" name="password" placeholder="请输入密码">
          <input type="submit" value="提交">
      </form>
  </div>
  </body>
</html>
