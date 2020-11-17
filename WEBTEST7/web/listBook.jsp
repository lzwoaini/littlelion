<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/2
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>图书浏览和查询</h2>
<s:form action="listBook" method="POST" theme="simple" onclick="return x()">
    <s:label value="搜索条件"/>
    <s:textfield name="condition"/>
    <s:submit value="查询"/>
</s:form>
<table border="1" width="450">
    <tr><td>书号</td><td>书名</td><td>作者</td><td>价格</td><td colspan="2" align="center">操作</td></tr>
<s:iterator value="books" status="st">
    <tr>
    <td><s:property value="isbn"/></td>
    <td><s:property value="title"/></td>
    <td><s:property value="author"/></td>
    <td><s:property value="price"/></td>
    <td><s:a action="deleteBook">删除
        <s:param name="book.isbn" value="isbn"></s:param>
        <s:param name="book.title" value="title"></s:param>
    </s:a></td>
    <s:url var="url" value="updateBook.jsp">
        <s:param name="book2.isbn" value="isbn"></s:param>
        <s:param name="book.title" value="title"/>
        <s:param name="book.author" value="author"/>
        <s:param name="book.price" value="price"/>
    </s:url>
    <td><s:a href="%{url}">修改</s:a></td>
    </tr>
</s:iterator>
</table>
<s:a action="listBook">查询全部</s:a>
<a href="main.jsp">返回主页</a>
</body>
</html>
