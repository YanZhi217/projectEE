<%--
  Created by IntelliJ IDEA.
  User: YanZhi
  Date: 2023-03-11
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>hello jsp</h1>
<%
  System.out.println("hello jsp~");
  int i = 3;
%>

<%="hello"%>
<%=i%>

<%!
void show(){};
String name = "zhangsan";
%>



</body>
</html>
