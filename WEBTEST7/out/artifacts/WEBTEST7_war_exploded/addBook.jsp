<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/1
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<s:form action="addBook" method="POST">
    <s:textfield name="book.isbn" label="书号"/>
    <s:textfield name="book.title" label="书名"/>
    <s:textfield name="book.author" label="作者"/>
    <s:textfield name="book.price" label="价格"/>
    <s:submit value="添加"/>
    <s:reset value="重置"/>
</s:form>
<s:if test="message==null">
</s:if>
<s:else>
    <s:property value="message"/><br>
</s:else>

<s:a href="main.jsp" name="alink">返回主页.</s:a>
</body>
</html>

