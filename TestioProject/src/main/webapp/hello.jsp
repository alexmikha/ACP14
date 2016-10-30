<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Ajax</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<div id="my-content">
    <Label>Input Name</Label>
    <input id="nameInput" type="text"><br>
    <button onclick="sendAjaxReqJquery()">Send Ajax Req</button>
    <div id="responseText"></div>
</div>
</body>
<script>

    function sendAjaxReqJquery() {

        var name = $("#nameInput").val();
        var url = "ajax/hello" + "?name" + name;
        var confObj = {
           type:"Get",
            url:"ajax/hello",
            data: {name:name},
            success: function (result) {
                $("#responseText").html(result);
            }
        };
        $.ajax(confObj);
    }

</script>

</html>