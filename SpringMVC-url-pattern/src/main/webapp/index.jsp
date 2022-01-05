<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2022/1/2
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC-url-pattern</title>
</head>
<body>
    <center>
        <font style="background-color: greenyellow; color: red; font-size: 32px">这是一个springMVC项目</font>
        <form action="lujun61/some.do" method="get">
            <table>
                <tr>
                    <td>
                        <label>
                            姓名：<input type="text" name="name">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            年龄：<input type="text" name="age">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&blacklozenge;<input type="submit" value="发起请求，发送请求参数">&blacklozenge;
                        </label>
                    </td>
                </tr>
            </table>
            <img src="static/img.png" alt="静态资源文件">
        </form>
    </center>
</body>
</html>
