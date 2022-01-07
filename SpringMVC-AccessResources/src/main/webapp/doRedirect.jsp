<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2022/1/6
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doRedirect</title>
</head>
<body>
    <center>
        <h1>这是数据处理完成后的应答界面</h1>
        <h2>name参数：${param.name}</h2>
        <h2>age参数：${param.age}</h2>
        <%--上述EL表达式相当于以下代码--%>
        <h2>age参数：<%=request.getParameter("age")%></h2>
    </center>
</body>
</html>
