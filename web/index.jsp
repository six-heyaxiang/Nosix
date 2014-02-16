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
    <jsp:include page="/WEB-INF/views/common.jsp"></jsp:include>
  </head>
  <body>
  <div class="container">
      <div class="row">
          <c:if test="${msg ne null}">
              <div class="col-lg-offset-4 col-lg-5 alert alert-danger">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  <strong>警告!</strong> ${msg}
              </div>
          </c:if>
      </div>
      <div class="row">
          <form class="col-lg-offset-5 col-lg-3 form-signin" role="form" action="${ctx}/account/login.do" method="post">
              <h2 class="form-signin-heading">管理员登录</h2>
              <input type="text" name="NSusername" class="form-control" placeholder="帐号" required autofocus>
              <input type="password" name="NSpassword" class="form-control" placeholder="密码" required>
              <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
          </form>
      </div>
  </div><!-- /container -->
  </body>
</html>
