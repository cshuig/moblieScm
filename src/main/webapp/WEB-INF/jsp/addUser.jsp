<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <button id="add" onclick="add()">添加</button>
</body>
<script type="text/javascript" src="${contextPath}/resources/js/jquery/jquery-1.11.1.js"></script>
<script>

    var roleLists = [];
    function add(){
        for(var i=1;i<=5;i++){
            var obj = {
                "id":i,
                "roleName":"admin"+i,
                "status" :1,
                "remark" : "remark"+i
            }
            roleLists.push(obj);
        }
        var user = {}
        user.id = 1;
        user.name = "cshuig";
        user.roleLists = roleLists;

        $.ajax({
            type:'POST',
            url:'addUser1',
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(user),
            success : function(data){
                alert(data.msg);
            }
        })

    }

</script>
<script type="text/javascript">
    $(document).ready(function () {
    var saveDataAry = [];
    for(var i=1;i<=5;i++){
        var obj = {
            "id":i,
            "roleName":"admin"+i,
            "status" :1,
            "remark" : "remark"+i
        }
        saveDataAry.push(obj);
    }
    //var data1 = {"id":1,"roleName": "test",status:1, "remark": "gz"};
    //var data2 = {"id":2,"roleName": "test",status:2, "remark": "gz"};
    //saveDataAry.push(data1);
    //saveDataAry.push(data2);
    $.ajax({
        type: "POST",
        url: "addUser3",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(saveDataAry),
        success: function (data) {
            alert(data.msg);
        }
    });
});  </script>
</html>