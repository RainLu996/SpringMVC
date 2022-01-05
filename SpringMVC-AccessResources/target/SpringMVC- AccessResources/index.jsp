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
    <title>SpringMVC-AccessResources</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#doAjaxForReturnVoid").click(function () {
                doAjaxForReturnVoid();
            })
            $("#doAjaxForReturnObject").click(function () {
                doAjaxForReturnObject();
            })
            $("#doAjaxForReturnJsonArray").click(function () {
                doAjaxForReturnJsonArray();
            })
            $("#returnStringData").click(function () {
                returnStringData();
            })
        })

        function doAjaxForReturnVoid() {
            $.ajax({
                url:"lujun61/returnVoid.do",
                data:{
                    name:"lujun",
                    age:18
                },
                type:"get",
                dataType:"json",
                success:function (resp) {
                    /*
                        resp是从服务端返回的json数据格式的字符串
                        jQuery会把字符串转换为json对象，并赋值给resp形参
                    */
                    window.alert(resp.name + ";" + resp.age);
                }
            })
        }
        function doAjaxForReturnObject() {
            $.ajax({
                url:"lujun61/returnObject.do",
                data:{
                    name:"lujun",
                    age:19
                },
                type:"get",
                dataType:"json",
                success:function (resp) {
                    /*
                        resp是从服务端返回的json数据格式的字符串
                        jQuery会把字符串转换为json对象，并赋值给resp形参
                    */
                    window.alert(resp.name + ";" + resp.age);
                }
            })
        }
        function doAjaxForReturnJsonArray() {
            $.ajax({
                url:"lujun61/returnJsonArray.do",
                data:{
                    name:"lujun",
                    age:19
                },
                type:"get",
                dataType:"json",
                success:function (resp) {
                    /*
                        resp是从服务端返回的json数据格式的字符串数组
                    */
                    $.each(resp, function (i, n) {
                        window.alert("第" + i + "个元素：" + n.name + ";" + n.age);
                    })
                }
            })
        }
        function returnStringData() {
            $.ajax({
                url:"lujun61/returnStringData.do",
                data:{
                    name:"lujun",
                    age:19
                },
                type:"get",
                dataType:"text",
                success:function (resp) {
                    /*
                        resp是从服务端返回的json数据格式的字符串数组
                    */
                    window.alert(resp);
                }
            })
        }
    </script>
</head>
<body>
    <center>
        <font style="background-color: greenyellow; color: red; font-size: 32px">这是一个springMVC项目</font>
        <br><a href="lujun61/some.do">发起some.do请求</a>
        <br><a href="lujun61/other.do">发起other.do请求</a>
        <br><a href="https://www.baidu.com">百度</a>

                                <%-- 测试不同的请求方式 --%>
        <form action="lujun61/some.do" method="get">
            <table>
                <tr>
                    <td><input type="submit" value="GET请求"></td>
                </tr>
            </table>
        </form>
        <form action="lujun61/other.do" method="post">
            <table>
                <tr>
                    <td><input type="submit" value="POST请求"></td>
                </tr>
            </table>
        </form>


                                        <%-- 参数接收 --%>
        <form action="lujun61/param.do" method="get">
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
        </form>
        <form action="lujun61/differentParam.do" method="post">
            <table>
                <tr>
                    <td>姓名：<input type="text" name="diffName"> </td>
                </tr>
                <tr>
                    <td>年龄：<input type="text" name="diffAge"> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="参数名与控制器形参名不同的请求"></td>
                </tr>
            </table>
        </form>
        <form action="lujun61/objParam.do" method="get">
            <table>
                <tr>
                    <td>姓名：<input type="text" name="name"> </td>
                </tr>
                <tr>
                    <td>年龄：<input type="text" name="age"> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="使用java对象接收请求参数"></td>
                </tr>
            </table>
        </form>


                                    <%-- 不同的返回值 --%>
        <form action="lujun61/returnString-view.do" method="get">
            <table>
                <tr>
                    <td>姓名：<input type="text" name="name"> </td>
                </tr>
                <tr>
                    <td>年龄：<input type="text" name="age"> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="返回值用String"></td>
                </tr>
            </table>
        </form>
        <table>
            <tr>
                <td><input type="button" id="doAjaxForReturnVoid" value="返回值是void的ajax"></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><input type="button" id="doAjaxForReturnObject" value="返回值是Object的ajax"></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><input type="button" id="doAjaxForReturnJsonArray" value="返回值是JsonArray的ajax"></td>
            </tr>
        </table>
        <table>
            <tr>
                <td><input type="button" id="returnStringData" value="返回值是String，但此时表示【数据】"></td>
            </tr>
        </table>
    </center>
</body>
</html>
