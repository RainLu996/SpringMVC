<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2022/1/4
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>returnString-view</title>
</head>
<body>
<center>
    <h1>这是数据处理完成后的应答界面</h1>
    <h2>手动添加的name参数：${requestScope.get("name")}</h2>
    <h2>手动添加的age参数：${requestScope.get("age")}</h2>
</center>
</body>
</html>
