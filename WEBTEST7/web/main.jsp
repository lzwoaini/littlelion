<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/1
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>图书管理系统主页</title>
</head>
<body>
<h1><s:property value="#session['user'].name"/>,欢迎登录图书管理系统! <a href="<s:url action="logout"/>">注销登录</a></h1><br><hr>
<a href="addBook.jsp">1.添加图书</a><br>
<a href="listBook.action">2.浏览查询</a>
</body>
</html>
