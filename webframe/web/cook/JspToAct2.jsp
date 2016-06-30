<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/8/12
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<input id="intA" type="text" height="200px" width="800px"/>
</body>
</html>
<script src="../js/json.js" type="text/javascript"></script>
<script type="text/javascript">
  window.onload = function () {
    var pParam = "&a=1&b=2";
    var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
    var pUrl = "http://localhost:9527/webcode/business/action.CookiesAction?action=bb";
    XMLSender.open("POST", pUrl, false);
    XMLSender.setRequestHeader("CONTENT-TYPE","multipart/form-data");
    XMLSender.setRequestHeader("CONTENT-LENGTH",pParam.length);
    XMLSender.send(pParam);
    var obj = XMLSender.responseText;
    var jsonObj = eval("("+obj+")");
    document.getElementById("intA").innerText=jsonObj[0]["A"] + jsonObj[0]["B"];
  };
</script>