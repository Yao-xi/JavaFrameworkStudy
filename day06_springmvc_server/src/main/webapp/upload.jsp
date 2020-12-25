<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="ajax/upload" method="post" enctype="multipart/form-data">
        姓名: <input type="text" name="name"/><br/>
        图片1: <input type="file" name="file"/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
