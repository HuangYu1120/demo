<%--
  Created by IntelliJ IDEA.
  User: swagg
  Date: 2021/6/16
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>首页</title>
    <script src="http://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="./css/main.css">
	<style>
      *{
          padding:0;
          margin: 0;
      }
      .wrapper{
          width:100%;
          height:800px;
      }
      .header{
          width:100%;
          height:80px;
          background-color: #05A;
      }
      .main{
          width: 100%;
          height:640px;
          position: relative;
      }
      .left{
          width:10%;
          height:100%;/* 相对父容器 */
          background-color: bisque;
      }
      .content{
          width: 90%;
          height: 100%;
          background-color: cyan;
          position: absolute;
          top: 0px;
          left: 10%;
      }
      .footer{
        width: 100%;
        height: 80px;
        background-color:darkcyan;
      }
  </style>
    <script>
        $(function(){
            $("#div1").on("click",".father",function () {
                var flag = $(this).nextUntil("li").is(":hidden");
                if (flag) {
                    //show() 方法: 使隐藏的变为显示
                    $(this).nextUntil("li").toggle();
                    $("#fimg1").css("transform", "rotate(0deg)");
                } else {
                    $(this).nextUntil("li").hide();
                    $("#fimg1").css("transform", "rotate(270deg)");
                }
            });
            // index.jsp页面一加载，就会请求后台获取菜单
            $.ajax({
                url:'tree/getAllTree.do',
                success:function(data){//data服务器返回的数据
                    firsul=$("<ul id=\"first\"></ul>");
                    $.each(data,function(index,tree){
                        //创建dom
                        if(tree.isParent=="true"){
                            fatherli=$("<li class=\"father\"></li>");
                            fatherA=$("<a href=\"javascript:void(0)\">"+tree.title+"<img id=\"fimg1\" src=\"images/jt.png\" alt=\"father1jt\"></a>");
                            fatherli.append(fatherA);
                            firsul.append(fatherli);
                        }else{
                            secondul=$("<ul class=\"second\"></ul>");
                            sonli=$("<li class=\"son\"></li>");
                            sonA=$("<a target=\"right\" href="+tree.url+">"+tree.title+"</a>");
                            sonli.append(sonA);
                            secondul.append(sonli);
                            firsul.append(secondul);
                        }
                    })
                    $("#div1").append(firsul);//渲染完毕
                }
            });
        })
    </script>
</head>
<body>
<div class="wrapper">
        <div class="header">
            页眉
        </div>
        <div class="main">
            <div id="div1">
            </div>
            <div class="content">
                <iframe src="" width="100%" height="100%" name="right" frameborder="0"></iframe>
            </div>
        </div>
        <div class="footer">
            页脚
        </div>
    </div>
</body>
</html>