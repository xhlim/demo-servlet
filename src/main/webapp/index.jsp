<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
    <style>
        html, body {
            width: 100%;
            height: 100%;
        }

        thead, tbody, tr {
            width: 100%;
        }

        table {
            margin-top: 20px;
            display: none;
            text-align: center;
            table-layout: auto;
        }
    </style>
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<body>
<h1>你好</h1>
<div>
    <button class="user-list">查看用户列表</button>
</div>
<div>
    <table class="user-table" border="1px">
        <thead>
        <tr>
            <td style="width: 20%;">id</td>
            <td style="width: 20%;">用户名</td>
            <td style="width: 20%;">密码</td>
            <td style="width: 20%;">性别</td>
            <td style="width: 20%;">年龄</td>
        </tr>
        </thead>
        <tbody class="user-html"></tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        $(".user-list").click(function () {
            // see http://www.cnblogs.com/tylerdonet/p/3520862.html
            $.ajax({
                url: "/demo/user/get",
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    // 清空内容
                    $('.user-html').empty();
                    var html = '';
                    $.each(data, function (index, user) {
                        console.info(index);
                        console.info(user);
                        var sex = user.sex === 0 ? "保密" : user.sex === 1 ? "男" : "女";
                        var age = user.age === 0 ? "保密" : user.age;
                        html += '<tr>' +
                            '<td>' + user.id + '</td>' +
                            '<td>' + user.name + '</td>' +
                            '<td>' + user.password + '</td>' +
                            '<td>' + sex + '</td>' +
                            '<td>' + age + '</td>' +
                            '</tr>';
                    });
                    $(".user-table").css('display', 'inline-block');
                    $('.user-html').html(html);
                },
                error: function (data) {
                    alert("出错误了：" + data);
                }
            });
        });
    });
</script>
</body>
</html>
