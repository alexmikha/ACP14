<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Ajax</title>
</head>
<body>
<div id="my-content">
    <Label>Input Name</Label>
    <input id="nameInput" type="text"><br>
    <button onclick="sendReq()">Send Ajax Req</button>
    <div id="responseText"></div>
</div>
</body>
<script>

    function sendReq() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState)
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseText").innerHTML = xhttp.responseText
            }
        }
        xhttp.open("Get", "ajax/hello", true);
        xhttp.send();
    }
</script>

</html>