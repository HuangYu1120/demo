<%--
  Created by IntelliJ IDEA.
  User: liwei
  Date: 2021-06-26
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,thead,tbody,tr,th,td{
            border-collapse: collapse;
        }
    </style>
    <script src="http://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
    <script>
        $(function () {
            $("#tb").on("click","#del",function(){
                // 如何拿到userId，当前元素（超链接）的父元素的父元素的第一个td的内容就是userId
                var userId=$(this).parent().parent().find("td:first").text();//如果让你使用原生的JavaScript去实现这个功能会怎样？
                $.ajax({
                    url:'user/deleteUser.do?userId='+userId,
                    success:function(){
                        // 删除成功后怎么办？刷新
                        loadUserData();
                    }
                })
            });
            loadUserData();//页面第一次显示出来的时候，要加载一次用户的数据
        })
        function loadUserData(){
            // 把tbody里面的元素全部删除
            $.ajax({
                url: 'user/getAllUser.do',
                success: function (data) {
                    $.each(data, function (index, user) {
                        var tr = $("<tr\>");
                        var tdId = $("<td>" + user.userId + "</td>");
                        var tdUsername = $("<td>" + user.username + "</td>");
                        var tdRealname = $("<td>" + user.realName + "</td>");
                        var tdMail = $("<td>" + user.email + "</td>");
                        var tdState = $("<td>" + user.state + "</td>");
                        var tdCreatetime = $("<td>" + user.createTime + "</td>");
                        var tdOp=$("<td><a id=\"del\" href=\"javascript:void(0)\">删除</a></td>");
                        // 同步请求会导致页面跳转（页面切换）

                        tr.append(tdId)
                            .append(tdUsername)
                            .append(tdRealname)
                            .append(tdMail)
                            .append(tdState)
                            .append(tdCreatetime)
                            .append(tdOp);
                        $("#tb").append(tr);
                    })
                }
            })
        }
    </script>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>账号ID</th>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>邮箱</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tb">

    </tbody>
</table>
</body>
</html>
