<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/7/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Cookie ck = new Cookie("gg", "this is god!");
  response.addCookie(ck);
%>
<html>
<head>
  <title></title>
</head>
<body>
<input value="111" type="button" onclick="click1()"/>
</body>
</html>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
  function click1() {
    $.ajax({
      url: "http://localhost:9527/webcode/servlet/CookiesServlet",
      type: "POST",
      success: function (data) {
        window.location = "next.jsp";
      }
    });
  }
</script>
