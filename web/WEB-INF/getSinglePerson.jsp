<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询结果</h3>

    用户名：<s:property value="#request.person.username"></s:property> <br>
    密码：<s:property value="#request.person.password"/>

</body>
</html>
