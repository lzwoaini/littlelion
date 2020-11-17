<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/1
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="login" method="POST">
    <s:textfield name="user.name" label="用户名"/>
    <s:password name="user.password" label="密码"/>
    <s:submit value="登录"/>
</s:form>
</body>
</html>
