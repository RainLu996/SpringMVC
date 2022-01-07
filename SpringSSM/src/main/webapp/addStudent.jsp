<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<center>
    <font style="background-color: greenyellow; color: red; font-size: 32px">这是一个springMVC项目</font>
    <form action="student/addStudent.do" method="get">
        <table>
            <tr>
                <td>
                    <label>
                        学号：<input type="text" name="id">
                    </label>
                </td>
            </tr>
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
                        邮箱：<input type="text" name="email">
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
                        &nbsp;&nbsp;&nbsp;&nbsp;&blacklozenge;<input type="submit" value="确认注册">&blacklozenge;
                    </label>
                </td>
            </tr>
        </table>
        <img src="static/img/img.png" alt="wellcome!!!">
    </form>
</center>
</body>
</html>
