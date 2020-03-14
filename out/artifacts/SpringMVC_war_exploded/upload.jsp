<%--
  Created by IntelliJ IDEA.
  User: wenwu
  Date: 3/14/2020
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
<form action="uploadImage" method="post" enctype="multipart/form-data">
    选择图片：<input type="file" name="image" accept="image/*"/><br>
    <%--accept="image/*" 表示支持所有图片类型，不限制图像格式；也可以更改想要的类型accept="image/gif,image/jepg，"--%>
    <input type="submit" value="上传">
</form>
</body>
</html>
