<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>更新</h3>
<form action="updatePerson.action">

    username: <s:textfield name="username" value="%{#request.person.username}" readonly="true"></s:textfield> <br>
    password: <s:password name="password" value="%{#request.person.password}"></s:password> <br>
    age: <s:textfield name="age" value="%{#request.person.age}"></s:textfield> <br>
    registerDate: <s:textfield name="registerDate" value="%{#request.person.registerDate}"></s:textfield> <br>

    <s:hidden name="id" value="%{#request.person.id}"></s:hidden>

    <input type="submit" value="submit">
</form>

</body>
</html>
