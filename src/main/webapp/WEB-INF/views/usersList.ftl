<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Users list </h1>
<table>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.age}</td>
        </tr>
    </#list>


    </tbody>
</table>


</body>
</html>