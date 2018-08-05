<%--
  Created by IntelliJ IDEA.
  User: ljiu
  Date: 2018/8/4
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>认证成功！</title>
</head>
<body>
认证成功！<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">退出</a>
</shiro:user>
<br>
<shiro:hasRole name="user">
    用户[<shiro:principal/>]拥有角色user<br/>
</shiro:hasRole>

</body>
</html>
