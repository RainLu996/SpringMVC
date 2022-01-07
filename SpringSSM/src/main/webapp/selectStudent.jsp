<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2022/1/6
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select</title>
    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#select").click(function () {
                $.ajax({
                    url:"student/queryStudent.do",
                    type:"get",
                    dataType:"json",
                    success:function (data) {
                        $("#data").empty();
                        $.each(data, function (i, n) {
                            $("#data").append("<tr>" + "<td>" + n.id + "</td>")
                                .append("<td>" + n.name + "</td>")
                                .append("<td>" + n.age + "</td>" + "</tr>")
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
    <center>
        <table>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
        </table>
        <table id="data"></table>
        <input type="button" id="select" value="查询学生"/>
    </center>
</body>
</html>
















