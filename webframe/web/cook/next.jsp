<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/7/16
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Cookie[] ck = request.getCookies();
  String s = "";
  if(ck != null){
    for (int i = 0; i < ck.length; i++) {
      if("gg".equals(ck[i].getName())){
        s = ck[i].getValue();
      }
    }
  }
%>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center"><a style="font: 10em"><%=s%></a></div>
</body>
</html>
