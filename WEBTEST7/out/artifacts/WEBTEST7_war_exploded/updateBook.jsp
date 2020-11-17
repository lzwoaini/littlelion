<%@ page import="JavaBean.Book" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/8
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书</title>
</head>
<body>
<h2>修改书籍</h2>
<%
    session.setAttribute("isbn",request.getParameter("book2.isbn"));
    session.setAttribute("title",request.getParameter("book.title"));
    session.setAttribute("author",request.getParameter("book.author"));
    session.setAttribute("price",request.getParameter("book.price"));
%>
<s:form action="updateBook" method="POST">
    <s:textfield name="book.isbn" label="书号" readonly="true" value="%{#session.isbn}"/>
    <s:textfield name="book.title" label="书名" value="%{#session.title}"/>
    <s:textfield name="book.author" label="作者" value="%{#session.author}"/>
    <s:textfield name="book.price" label="价格" value="%{#session.price}"/>
    <s:submit value="修改"/>
</s:form>
<s:property value="message"></s:property><br>
<a href="listBook.action">浏览查询</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="main.jsp">返回主页</a>
</body>
</html>
