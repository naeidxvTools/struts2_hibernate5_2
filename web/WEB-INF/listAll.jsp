<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function del()
        {
            if (confirm("你确定要删除吗？"))
            {
                return true;
            }
            return false;
        }
    </script>
</head>
<body>

<h3 align="center">用户信息</h3>
<table width="80%" align="center" border="1">
    <tr>
        <th>order</th>
        <th>username</th>
        <th>password</th>
        <th>age</th>
        <th>registerDate</th>
        <th>删除</th>
        <th>更新</th>
    </tr>

<%--    <s:iterator value="#request['list']" var="person" status="st"> 或者--%>
    <s:iterator value="#request.list" var="person" status="st">
        <tr>
            <td><s:property value="#st.index + 1"></s:property></td>
            <td><s:a href="getSinglePerson.action?id=%{#person.id}"><s:property value="username"></s:property></s:a></td>
            <td><s:property value="password"></s:property></td>
            <td><s:property value="age"></s:property></td>
            <td><s:property value="registerDate"></s:property></td>
            <td><s:a href="updatePPerson.action?id=%{#person.id}">更新</s:a></td>
            <td><s:a href="deletePerson.action?id=%{#person.id}" onclick="return del();">删除</s:a></td>
        </tr>
    </s:iterator>


</table>

</body>
</html>
