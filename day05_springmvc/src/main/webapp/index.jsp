<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/save">save</a>

    <button id="btn">点我</button>
    <button id="btn2">点我</button>

    <textarea id="txt"></textarea>
</body>
</html>
<script>
    $("#btn1").click(function() {
        let arr = [{username: 'zs', age: 16}, {username: 'ls', age: 17}, {username: '王五', age: 18}];
        console.log(JSON.stringify(arr));
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/resp/show4",
            data: JSON.stringify(arr),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function(data) {
                console.log(data);
                alert(data);
            }
        });
    });
</script>
