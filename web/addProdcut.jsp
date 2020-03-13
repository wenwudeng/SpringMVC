<%--
  Created by IntelliJ IDEA.
  User: wenwu
  Date: 3/14/2020
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>

<form action="/addProduct">
    商品名称：<input type="text" name="name" value=""><br/>
    商品价格：<input type="text" name="price" value=""><br>
    <input type="submit" value="增加商品" >
</form>
</body>
</html>
