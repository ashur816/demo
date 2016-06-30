<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/8/5
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/MoonCat.jsp"%>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<input id="intA" type="text" height="200px" width="800px"/>
<input id="btnA" type="button" value="222"/>
</body>
</html>
<script type="text/javascript">
    $("#btnA").onclick = function () {
        var pParam = "&a=1&b=2";
        var pUrl = "<%=request.getContextPath()%>/business/action.CookiesAction?action=aa";
        try {
            var obj = postInfo(pUrl, pParam);
            var jsonObj = eval("(" + obj + ")");
            $("#btnA").innerText = jsonObj[0]["A"] + jsonObj[0]["B"];
        } catch (e) {
            alert(e.message);
        }
    };
</script>
