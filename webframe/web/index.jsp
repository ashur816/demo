<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/7/16
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/MoonCat.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center"><a style="font: 8em">Welcome to my world!</a></div>
<br/>

<div style="height: 20%">
    <a style="padding-left: 80%">Martin Zhang</a>
</div>

<div align="center">
    <form id="userForm">
        <p>用户名 <input type="text" name="username"/></p>
        <p>密&nbsp;&nbsp;码 <input type="password" name="password"></p>
    </form>
    <button id="ok">登录</button>
    &nbsp;&nbsp;
    <button id="cancel">取消</button>
</div>
</body>
</html>
<script type="text/javascript">

    getById("ok").click(function () {
        var param = getFormData("userForm");
        var url = "<%=request.getContextPath()%>/business/action.LoginAction?action=login";
        var ud = postInfo(url+param, null);
        alert(ud);
    });
</script>