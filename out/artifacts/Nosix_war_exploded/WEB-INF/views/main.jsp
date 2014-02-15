<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2/14/14
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nosix Manage System</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript">
        $(function(){
            $(".menu-item").click(function(){
                if($(this)){
                    $(this).next("ul").toggle(500);
                }
            });
        });
    </script>
</head>
<body>
<jsp:include page="layout/header.jsp"></jsp:include>
<div class="container" style="margin: 40px;">
    <div class="row">
        <div class="col-md-2">
            <jsp:include page="layout/left.jsp"></jsp:include>
        </div>
        <div class="col-md-10">

        </div>
    </div>
</div>
</body>
</html>
