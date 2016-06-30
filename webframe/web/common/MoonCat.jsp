<% response.setHeader("Cache-Control", "no-cache"); %>
<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/common/UserData.js" type="text/javascript"></script>
<script type="text/javascript">
    function getById(_id) {
        return $("#" + _id);
    }

    function postInfo(url, xml) {
        var XMLSender = null;
        if (typeof ActiveXObject != "undefined") {
            //Internet Explorer
            XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
        }
        else if (window.XMLHttpRequest) {
            //Mozilla/Safari
            XMLSender = new XMLHttpRequest();
        }
        else {
            return false;
        }
        XMLSender.open("POST", url, false);
        XMLSender.setRequestHeader("CONTENT-TYPE", "multipart/form-data");
        XMLSender.send(xml);
        var re = eval("("+XMLSender.responseText+")");
        var ud = createUserData(re);
        return ud;
    }

    function getFormData(_formId) {
        var formObj = getById(_formId)[0];
        var len = formObj.length;
        var retStr = "";
        for (var i = 0; i < len; i++) {
            retStr += "&" + formObj[i].name + "=" + formObj[i].value;
        }
        return retStr;
    }
</script>